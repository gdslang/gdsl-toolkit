
structure FromCore : sig
   val run:
      Core.Spec.t ->
         CPS.Spec.t CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure Exp = CPS.Exp
   structure CCTab = CPS.CCTab
   structure S = Substring

   val variable = Atom.atom "x"
   val function = Atom.atom "f"
   val constructor = Atom.atom "cons"
   val continuation = CCTab.kont

   structure Builtin = struct
      fun fresh v = let
         val (tab, sym) =
            VarInfo.fresh (!SymbolTables.varTable, Atom.atom v)
      in
         sym before SymbolTables.varTable := tab
      end

      fun field f = let
         val (tab, sym) =
            FieldInfo.fresh (!SymbolTables.fieldTable, f)
      in
         sym before SymbolTables.fieldTable := tab
      end
      
      fun get s = VarInfo.lookup (!SymbolTables.varTable, Atom.atom s)

      fun mk () = let
         open Core.Exp
         val slice = get "slice"
         val consume = get "consume"
         val unconsume = get "unconsume"
         val andd = get "and"
         val concat = get "^"
         val == = get "=="
         val not = get "not"
         val raisee = get "raise"

         (* val and a b = %and(a,b) *)
         val andd =
            let
               val a = fresh "a"
               val b = fresh "b"
               val primAnd = get "%and"
               val body = PRI (primAnd, [a, b])
                     
            in
               (andd, [a, b], body)
            end

         (* val == a b = %equal(a,b) *)
         val == =
            let
               val a = fresh "a"
               val b = fresh "b"
               val primEqual = get "%equal"
               val body = PRI (primEqual, [a, b])
            in
               (==, [a, b], body)
            end

         (* val not a = %not(a) *)
         val not =
            let
               val a = fresh "a"
               val x = fresh "x"
               val primNot = get "%not"
               val body = PRI (primNot, [a])
            in
               (not, [a], body)
            end

         (* val ^ k a b =
          *    letval x = %concat(a,b) in
          *       k x
          *)
         val concat =
            let
               val a = fresh "a"
               val b = fresh "b"
               val primConcat = get "%concat"
               val body = PRI (primConcat, [a, b])
            in
               (concat, [a, b], body)
            end

         (* val raise a  = %raise(a) *)
         val raisee =
            let
               val a = fresh "a"
               val primRaise = get "%raise"
               val body = PRI (primRaise, [a])
            in
               (raisee, [a], body)
            end

         (* TODO: fix definition, `%slice` should not take 
          * the state as argument (is not monadic).
          *
          * val slice k tok offs sz s =
          *    letval x = %slice(tok,offs,sz,s) in
          *       k x
          *
          * should be
          *
          * val slice k tok offs sz =
          *    letval x = %slice(tok,offs,sz) in
          *       return k x
          *)
         val slice =
            let
               val tok = fresh "tok"
               val offs = fresh "offs"
               val sz = fresh "sz"
               val s = fresh "s"
               val primSlice = get "%slice"
               val body = PRI (primSlice, [tok, offs, sz, s])
            in
               (slice, [tok, offs, sz, s], body) 
            end

         (* val consume s = %consume(s) *)
         val consume =
            let
               val s = fresh "s"
               val primConsume = get "%consume"
               val body = PRI (primConsume, [s])
            in
               (consume, [s], body)
            end

         (* val unconsume s = %unconsume(s) *)
         val unconsume =
            let
               val s = fresh "s"
               val primUnconsume = get "%unconsume"
               val body = PRI (primUnconsume, [s])
            in
               (unconsume, [s], body)
            end
      in
         [slice, consume, unconsume, andd, not, ==, concat, raisee]
      end

   end

   val constructors: (Spec.sym * Spec.ty option) SymMap.map ref = ref SymMap.empty

   fun isEnumLike c =
      case SymMap.lookup (!constructors, c) of
         (_, NONE) => true | _ => false

   fun fresh variable = let
      val (tab, sym) =
         VarInfo.fresh (!SymbolTables.varTable, variable)
   in
      sym before SymbolTables.varTable := tab
   end

   fun bind map v t = SymMap.insert (map, v, t) 

   local open Core.Exp in

   fun field f = let
      val tab = SymbolTables.fieldTable
      val n = VarInfo.getAtom (!SymbolTables.varTable, f)
   in
      case FieldInfo.find (!tab, n) of
         SOME s => s
       | NONE =>
            let
               val (tab, sym) = FieldInfo.fresh (!tab, n)
            in
               sym before SymbolTables.fieldTable := tab
            end
   end

   fun translate spec =
      Spec.upd
         (fn cs =>
            let
               val main = fresh function
               val kont = fresh continuation
               val () = constructors := Spec.get#constructors spec
               fun exports cs =
                  rev (foldl
                     (fn ((f, _, _), acc) => 
                        let
                           val fld = field f
                        in
                           (fld, ID f)::acc
                        end)
                     [] cs)
               fun exports spec =
                  let 
                     val es = Spec.get#exports spec
                  in
                     map (fn e => (field e, ID e)) es
                  end
               val cps =
                  trans0 
                     (* TODO: "export" exported symbols as record *)
                     (LETREC (Builtin.mk()@cs, RECORD (exports spec)))
                     (fn z => Exp.APP (main, kont, [z]))
            in
               cps
            end) spec

   and trans0 e kappa = 
      case e of
         LETVAL (v, e, body) =>
            let
               val j = fresh continuation
               val body = trans0 body kappa
            in
               Exp.LETCONT ([(j, [v], body)], trans1 e j)
            end
       | LETREC (ds, body) => Exp.LETREC (map trans0rec ds, trans0 body kappa)
       | IF (iff, thenn, elsee) =>
            trans0
               (CASE
                  (iff,
                   [(Core.Pat.BIT "1", thenn),
                    (Core.Pat.BIT "0", elsee)]))
               kappa
       | CASE (e, ps) =>
            let
               val j = fresh continuation
               fun trans z ps cps ks =
                  case ps of
                     [] =>
                        let
                           val x = fresh variable
                        in
                           case ks of
                              [([],body)] =>
                                 Exp.LETCONT
                                    ((j, [x], kappa x)::cps,
                                     Exp.CC body)

                            | _ =>
                                 Exp.LETCONT
                                    ((j, [x], kappa x)::cps,
                                     Exp.CASE (z, ks))
                        end
                   | (p, e)::ps =>
                        let
                           val k = fresh continuation
                           val (xs, ks) = transPat p k ks
                        in
                           trans z ps ((k, xs, trans1 e j)::cps) ks
                        end
            in
               trans0 e (fn z => trans z ps [] [])
            end
       | APP (e1, e2) =>
            let
               val k = fresh continuation
               val x = fresh variable
            in
               trans0 e1 (fn x1 =>
                  trans0 e2 (fn x2 =>
                     Exp.LETCONT ([(k, [x], kappa x)], Exp.APP (x1, k, [x2]))))
            end
       | PRI (f, xs) =>
            let
               val x = fresh variable
            in
               Exp.LETVAL (x, Exp.PRI (f, xs), kappa x)
            end
       | FN (x, e) =>
            let
               val f = fresh function
               val k = fresh continuation
            in
               Exp.LETVAL (f, Exp.FN (k, [x], trans1 e k), kappa f) 
            end
       | RECORD fs =>
            let
               fun trans fs fvs =
                  case fs of
                     [] =>
                        let
                           val x = fresh variable
                        in
                           Exp.LETVAL (x, Exp.REC fvs, kappa x)
                        end
                   | (f, e)::fs =>
                        trans0 e (fn z =>
                           trans fs ((f, z)::fvs))
            in
               trans fs []
            end
       | UPDATE fs => 
            let
               val f = fresh function
               val k = fresh continuation
               val z = fresh variable
               val x = fresh variable
               fun trans fs fvs =
                  case fs of
                     [] =>
                        Exp.LETVAL
                           (f,
                            Exp.FN (k, [x],
                              Exp.LETUPD (z, x, fvs,
                                 Exp.CC (k, [z]))),
                            kappa f)
                   | (f, e)::fs =>
                        trans0 e (fn z =>
                           trans fs ((f, z)::fvs))
            in
               trans fs []
            end
       | SELECT fld =>
            let
               val f = fresh function
               val k = fresh continuation
               val x = fresh variable
               val z = fresh variable
            in
               
               (* Exp.LETREC
                  ([(f, k, [x],
                     Exp.LETPRJ (z, fld, x, Exp.CC (k, z)))],
                   kappa f) *)
               Exp.LETVAL
                  (f,
                   Exp.FN
                     (k,
                      [x],
                      Exp.LETPRJ (z, fld, x, Exp.CC (k, [z]))),
                   kappa f)
            end
       | CON c =>
            if isEnumLike c
               then
                  let
                     val x = fresh variable
                     val y = fresh variable
                  in
                     Exp.LETVAL (y, Exp.UNT,
                     Exp.LETVAL (x, Exp.INJ (c, y), kappa x))
                  end
            else
               let
                  val f = fresh constructor
                  val k = fresh continuation
                  val x = fresh variable
                  val y = fresh variable
                  val j = fresh continuation
                  val z = fresh variable
               in
                  (* Exp.LETREC
                     ([(f, k, [x],
                       Exp.LETVAL (y, Exp.INJ (c, x), Exp.CC (k, y)))],
                      kappa f) *)
                  Exp.LETVAL
                     (f,
                      Exp.FN
                        (k,
                         [x],
                         Exp.LETVAL (y, Exp.INJ (c, x), Exp.CC (k, [y]))),
                      kappa f) 
               end
       | LIT l =>
            let
               val x = fresh variable
            in
               Exp.LETVAL (x, transLit l, kappa x)
            end
       | ID v => kappa v
       | _ => raise CM.CompilationError
  
   and explodePat str =
      let
         fun toWord str =
            case StringCvt.scanString (Word.scan StringCvt.BIN) str of
               SOME w => w
             | NONE => raise Fail ("Invalid bit-pattern: " ^ str)
         val cvt = toWord o String.implode
         fun lp (s, acc) =
            case S.getc s of
               SOME (#".",s) => lp(s,#"0"::acc)@lp(s,#"1"::acc)
             | SOME (n,s) =>
                  if not (Char.isDigit n)
                     then raise Fail ("Invalid bit-pattern: " ^ str)
                  else lp(s,n::acc)
             | NONE => [cvt (rev acc)]
      in
         if CharVector.all (fn c => c = #".") str then [] else
         case str of
            "" => []
          | _ => lp (S.full str, [])
      end

   and transPat p k ks =
      let (* TODO: apply arguments to the branches *)
          (* TODO: check size of generated patterns and bail out if to large *)
         open Core.Pat

         fun toIdx p =
            case p of
               BIT str => explodePat str
             | INT i => [Word.fromLargeInt (IntInf.toLarge i)]
             | CON (s, NONE) => [Word.fromInt (SymbolTable.toInt s)]
             | _ => []
      in
         ([], (toIdx p, (k, [](*TODO*)))::ks)
      end

   and trans0rec (n, args, e) =
      let
         val k = fresh continuation
         fun unfold (xs, e) =
            case xs of
               [] => e
             | x::xs => FN (x, unfold (xs, e))
      in
         case args of
            [] =>
               let
                  val x = fresh variable
               in
                  (* TODO *)
                  (n, k, [x], trans1 (APP (e, ID x)) k)
               end
          | [x] => (n, k, args, trans1 e k)
          | x::xs => (n, k, [x], trans1 (unfold (xs, e)) k)
      end

   and trans1 e kont =
      case e of
         LETVAL (v, e, body) =>
            let
               val j = fresh continuation
               val body = trans1 body kont
            in
               Exp.LETCONT ([(j, [v], body)], trans1 e j)
            end
       | LETREC (ds, body) => Exp.LETREC (map trans0rec ds, trans1 body kont)
       | IF (iff, thenn, elsee) =>
            trans1
               (CASE
                  (iff,
                   [(Core.Pat.BIT "1", thenn),
                    (Core.Pat.BIT "0", elsee)]))
               kont
       | CASE (e, ps) =>
            let
               fun trans z ps cps ks =
                  case ps of
                     (p, e)::ps =>
                        let
                           val k = fresh continuation
                           val (xs, ks) = transPat p k ks
                        in
                           trans z ps ((k, xs, trans1 e kont)::cps) ks
                        end
                   | [] =>
                        case ks of
                           [([],body)] =>
                              Exp.LETCONT (cps, Exp.CC body)
                         | _ =>
                              Exp.LETCONT (cps, Exp.CASE (z, ks))
            in
               trans0 e (fn z => trans z ps [] [])
            end
       | APP (e1, e2) =>
            trans0 e1 (fn x1 =>
               trans0 e2 (fn x2 =>
                  Exp.APP (x1, kont, [x2])))
       | PRI (f, xs) =>
            let
               val x = fresh variable
            in
               Exp.LETVAL (x, Exp.PRI (f, xs), Exp.CC (kont, [x]))
            end
       | FN (x, e) =>
            let
               val f = fresh function
               val j = fresh continuation
            in
               Exp.LETVAL (f, Exp.FN (j, [x], trans1 e j), Exp.CC (kont, [f]))
            end
       | RECORD fs =>
            let
               fun trans fs fvs =
                  case fs of
                     [] =>
                        let
                           val x = fresh variable
                        in
                           Exp.LETVAL (x, Exp.REC fvs, Exp.CC (kont, [x]))
                        end
                   | (f, e)::fs =>
                        trans0 e (fn z =>
                           trans fs ((f, z)::fvs))
            in
               trans fs []
            end
       | UPDATE fs => 
            let
               val f = fresh function
               val k = fresh continuation
               val x = fresh variable
               val z = fresh variable
               fun trans y fs fvs =
                  case fs of
                     [] =>
                        let
                           val x = fresh variable
                        in
                           Exp.LETUPD (x, y, fvs, Exp.CC (kont, [x]))
                        end
                   | (f, e)::fs =>
                        trans0 e (fn z =>
                           trans y fs ((f, z)::fvs))
            in
               (* TODO: letval f = \k x. ... *)
               Exp.LETVAL
                  (f,
                   Exp.FN (k, [x], trans x fs []),
                   Exp.CC (kont, [f]))
            end
       | SELECT fld =>
            let
               val f = fresh function
               val k = fresh continuation
               val x = fresh variable
               val z = fresh variable
            in
               (* TODO: letval f = \k x. ... *)
               Exp.LETVAL
                  (f,
                   Exp.FN (k, [x], Exp.LETPRJ (z, fld, x, Exp.CC (k, [z]))),
                   Exp.CC (kont, [f]))
            end
       | CON c =>
            if isEnumLike c
               then
                  let
                     val x = fresh variable
                     val y = fresh variable
                  in
                     Exp.LETVAL (y, Exp.UNT,
                     Exp.LETVAL (x, Exp.INJ (c, y), Exp.CC (kont, [x])))
                  end
            else
               let
                  val f = fresh constructor
                  val k = fresh continuation
                  val x = fresh variable
                  val y = fresh variable
               in
                  (* TODO: letval f = \k x. ... *)
                  Exp.LETVAL
                     (f,
                      Exp.FN
                        (k,
                         [x],
                         Exp.LETVAL
                           (y, Exp.INJ (c, x), Exp.CC (k, [y]))),
                      Exp.CC (kont, [f]))
               end
       | LIT l =>
            let
               val x = fresh variable
            in
               Exp.LETVAL (x, transLit l, Exp.CC (kont, [x]))
            end
       | ID x => Exp.CC (kont, [x])
       | _ => raise CM.CompilationError

   and transLit l =
      case l of
         Core.Lit.INTlit i => Exp.INT i
       | Core.Lit.FLTlit f => Exp.FLT f
       | Core.Lit.VEClit v => Exp.VEC v 
       | Core.Lit.STRlit s => Exp.STR s

   end (* end local *)

   fun dumpPre (os, spec) = Pretty.prettyTo (os, Core.PP.spec spec)
   fun dumpPost (os, spec) = Pretty.prettyTo (os, CPS.PP.spec spec)

   val translate =
      BasicControl.mkKeepPass
         {passName="cpsConversion",
          registry=CPSControl.registry,
          pass=translate,
          preExt="core",
          preOutput=dumpPre,
          postExt="cps",
          postOutput=dumpPost}

   fun run spec = CM.return (translate spec)
end
