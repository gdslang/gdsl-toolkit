
structure JS0Templates = struct
   val runtime = ExpandFile.mkTemplateFromFile "detail/codegen/js0/runtime.js"

   fun expandRuntime hooks =
      ExpandFile.expandTemplate
         {src=runtime,
          dst="dis.js",
          hooks=hooks}

   fun mkPrint f os = Pretty.prettyTo(os, f())
   fun mkFunctionsHook d = ("functions", mkPrint (fn () => d))
end

structure JS0Factory = struct
   structure JS = Javascript
   open JS
   structure JSStmt = struct
      fun var (x,e) = Joint.Var (Vector.fromList [(x,SOME e)])
      fun const (x,e) = var (x,e)(* Joint.Const (Vector.fromList [(x,e)]) *)
      fun function (f,xs,body) = Joint.FunctionDec {args=Vector.fromList xs, name=f,body=Vector.fromList body}
      fun seq xs = Joint.Block (Vector.fromList xs)
      fun call (f,xs) = Joint.Exp (Joint.Call {args=Vector.fromList(map Joint.Id xs),func=Joint.Id f})
      fun return e = Joint.Return (SOME e)
      fun throw e = Joint.Throw e
      fun switch (x, cs, dflt) = Joint.Switch {test=x,clauses=Vector.fromList (cs@[([],dflt)])}
      fun assignVars (x, y) = Joint.Exp (Joint.Assign {lhs=Joint.Id x, oper=AssignOp.Equals, rhs=Joint.Id y})
      fun assign (x, y) = Joint.Exp (Joint.Assign {lhs=x, oper=AssignOp.Equals, rhs=y})
   end
   structure JSExp = struct
      fun lambda (xs,body) = Joint.Function {args=Vector.fromList xs,body=body,name=NONE}
      fun call (f,xs) = Joint.Call {args=Vector.fromList(map Joint.Id xs),func=Joint.Id f}
      fun object fs =
         Joint.Object
            (Vector.fromList (map (fn (p,v) =>
               Joint.Property {property=p,value=v}) fs))
      fun tagged (tag,x) =
         object
            [(PropertyName.fromString "tag", tag),
             (PropertyName.fromString "payload", x)]
      fun int n = Joint.Number (Number.fromInt n)
      fun word n = Joint.Number (Number.fromInt (Word.toInt n))
      fun string s = Joint.String (JSString.fromString s)
      fun bitvec (sz,vec) =
         object
            [(PropertyName.fromString "sz", sz),
             (PropertyName.fromString "vec", vec)]
      fun select (p, obj) = Joint.SelectId {property=p, object=obj}
      fun id x = Joint.Id x
      val unit = object []
   end
end

structure JS0 = struct
   structure JS = Javascript
   structure CM = CompilationMonad
   open JS JS0Factory CPS CPS.Exp

   fun codegen cpsSpec =
      let
         val () = Mangle.reset()
         fun id s = Id.fromString (Mangle.apply s)
         fun field f = PropertyName.fromString (Mangle.applyField f)
         fun fieldId f = Id.fromString (Mangle.applyField f)
         fun tagName tag = Mangle.getStringOfTag tag
         fun veclit v = 
            (* We need to handle empty bit-vector patterns here *)
            case v of
               "" => 0
             | _ => valOf (StringCvt.scanString (Int.scan StringCvt.BIN) v)
         val empty = []
         fun visitExp (e,acc) =
            case e of
               LETVAL (x,v,t) => visitExp (t, JSStmt.const (id x, visitVal v)::acc)
             | LETREC (ds,t) => visitExp (t, foldl visitRec acc ds)
             | LETCONT (ds,t) => visitExp (t, foldl visitCont acc ds)
             | LETPRJ (x,f,y,t) => visitExp (t, JSStmt.const (id x, JSExp.select (fieldId f, JSExp.id (id y)))::acc)
             | LETDECON (x,y,t) => visitExp (t, JSStmt.const (id x, JSExp.select (Id.fromString "payload", JSExp.id (id y)))::acc)
             | LETUPD (x,y,fs,t) =>
                  (* FIXME: destructive update! *)
                  let
                     val x = id x
                     val y = id y
                     val upds =
                        map (fn (f, z) =>
                           JSStmt.assign
                              (JSExp.select (fieldId f, JSExp.id x),
                               JSExp.id (id z))) fs
                  in
                     visitExp (t, (upds@
                        [JSStmt.const (x, JSExp.id y)])@acc)
                  end
             | APP (f,k,xs) => rev (JSStmt.return (JSExp.call (id f, map id (k::xs)))::acc)
             | CC (c,xs) => rev (JSStmt.return (JSExp.call (id c, map id xs))::acc)
             | CASE (ty,x,cs) =>
                  let
                     fun branch (k,xs) = Vector.fromList [JSStmt.return (JSExp.call (id k, map id xs))]
                     val cs' = List.filter (fn (cs, _) => not (null cs)) cs
                     val dflt = List.find (fn (cs, _) => null cs) cs
                     val fatalDflt = Vector.fromList [JSStmt.throw (JSExp.string "[Match]")]
                     val dflt =
                        case dflt of
                           NONE => fatalDflt
                         | SOME (_, t) => branch t
                     val casetag = 
                        case ty of
                           CPS.Exp.CASETYCON => "__casetagcon"
                         | CPS.Exp.CASETYVEC => "__casetagvec"
                         | CPS.Exp.CASETYINT => "__casetagint"
                     val giveExp =
                        case ty of
                           CPS.Exp.CASETYCON => JSExp.string o tagName o ConInfo.unsafeFromWord
                         | CPS.Exp.CASETYVEC => JSExp.word
                         | CPS.Exp.CASETYINT => JSExp.word
                        
                  in
                     rev (JSStmt.switch
                        (JSExp.call (Id.fromString casetag, [id x]),
                         map (fn (cs, t) =>
                           (map giveExp cs, branch t)) cs',
                         dflt)::acc)
                  end
         
         and visitRec ((f, k, xs, t),acc) = JSStmt.function (id f, map id (k::xs), visitExp (t,[]))::acc
         and visitCont ((k, xs, t),acc) = JSStmt.function (id k, map id xs, visitExp (t,[]))::acc
         and visitVal v =
            case v of
               FN (k,xs,t) => JSExp.lambda (map id (k::xs), Vector.fromList (visitExp (t,[])))
             | PRI (f,xs) => JSExp.call (id f, map id xs)
             | INJ (tag,x) => JSExp.tagged (JSExp.string (tagName tag), JSExp.id (id x))
             | REC fs => JSExp.object (map (fn (f,x) => (field f, JSExp.id (id x))) fs)
             | INT i => JSExp.int (IntInf.toInt i) (* FIXME: precision loss! *)
             | STR s => JSExp.string s
             | VEC v => JSExp.bitvec (JSExp.int (String.size v), JSExp.int (veclit v))
             | UNT => JSExp.unit
             | _ => raise Fail "codegen.js0.unimplementedValueBinding"

         val cps = Spec.get#declarations cpsSpec
         val exports = Spec.get#exports cpsSpec
         (* register exported names *)
         val () =
            app (fn f =>
               let
                  val _ = Mangle.applyExport f
               in
                  ()
               end) exports
         val js = 
            let
               val funs =
                  case cps of
                     LETREC (ds,_) => ds
                   | _ => raise Fail "codegen.js0.invalidCpsProgram"
               val jsfuns = foldl visitRec [] funs
            in
               Program.T (Vector.fromList jsfuns)
            end
         val _ =
            JS0Templates.expandRuntime
               [JS0Templates.mkFunctionsHook (Program.layout js)]
      in
         js
      end

   fun dumpPre (os, spec) = Pretty.prettyTo (os, CPS.PP.spec spec)
   fun dumpPost (os, js) = Pretty.prettyTo (os, Program.layout js)

   val pass =
      BasicControl.mkKeepPass
         {passName="js0Codegen",
          registry=CodegenControl.registry,
          pass=codegen,
          preExt="cps",
          preOutput=dumpPre,
          postExt="js",
          postOutput=dumpPost}

   fun run spec = CM.return (pass spec)
end
