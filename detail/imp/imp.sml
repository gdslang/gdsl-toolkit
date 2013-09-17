(**
 * ## Simple imperative intermediate representation.
 *)
structure Imp = struct
   
   type sym = SymbolTable.symid

   (* types of values *)
   datatype vtype =
         VOIDvtype
       | VECvtype
       | INTvtype
       | STRINGvtype
       | OBJvtype
       | RECORDvtype of bool * (SymbolTable.symid * vtype) list (* record with a fixed set of fields, boolean is true if record should be boxed *)
       | FUNvtype of (vtype * bool * vtype list) (* flag is true if function contains closure arguments *)
       | MONADvtype of vtype (* result of monadic action *) 

   type arg = vtype * sym

   datatype prim =
         GETSTATEprim
       | SETSTATEprim
       | IPGETprim
       | SEEKprim
       (*| RSEEKprim*)
       | DIVprim
       | CONSUME8prim
       | CONSUME16prim
       | CONSUME32prim
       | UNCONSUME8prim
       | UNCONSUME16prim
       | UNCONSUME32prim
       | PRINTLNprim
       | RAISEprim
       | ANDprim
       | ORprim
       | SIGNEDprim
       | UNSIGNEDprim
       | ADDprim
       | SUBprim
       | EQprim
       | MULprim
       | LTprim
       | LEprim
       | NOT_VECprim
       | EQ_VECprim
       | CONCAT_VECprim
       | INT_TO_STRINGprim
       | STRLENprim
       | CONCAT_STRINGprim
       | SLICEprim
       | GET_CON_IDXprim
       | GET_CON_ARGprim
       | VOIDprim

   (* information on how to print primitives, the name is the C name
      and the priority is the operator precedence, 0 if not infix *)
   fun prim_info GETSTATEprim = { name = "__get_state", prio = 0 }
     | prim_info SETSTATEprim = { name = "__set_state", prio = 0 }
     | prim_info IPGETprim = { name = "idxget", prio = 0 }
     | prim_info SEEKprim = { name = "seek", prio = 0 }
     (*| prim_info RSEEKprim = { name = "rseek", prio = 0 }*)
     | prim_info DIVprim = { name = "/z", prio = 5 }
     | prim_info CONSUME8prim = { name = "__consume8", prio = 0 }
     | prim_info CONSUME16prim = { name = "__consume16", prio = 0 }
     | prim_info CONSUME32prim = { name = "__consume32", prio = 0 }
     | prim_info UNCONSUME8prim = { name = "__unconsume8", prio = 0 }
     | prim_info UNCONSUME16prim = { name = "__unconsume16", prio = 0 }
     | prim_info UNCONSUME32prim = { name = "__consume32", prio = 0 }
     | prim_info PRINTLNprim = { name = "__puts", prio = 0 }
     | prim_info RAISEprim = { name = "__raise", prio = 0 }
     | prim_info ANDprim = { name = "&", prio = 10 }
     | prim_info ORprim = { name = "|", prio = 12 }
     | prim_info SIGNEDprim = { name = "__sx", prio = 0 }
     | prim_info UNSIGNEDprim = { name = "__zx", prio = 0 }
     | prim_info ADDprim = { name = "+", prio = 6 }
     | prim_info SUBprim = { name = "-", prio = 6 }
     | prim_info EQprim = { name = "==", prio = 9 }
     | prim_info MULprim = { name = "*", prio = 5 }
     | prim_info LTprim = { name = "<", prio = 8 }
     | prim_info LEprim = { name = "<=", prio = 8 }
     | prim_info NOT_VECprim = { name = "__not", prio = 0 }
     | prim_info EQ_VECprim = {name = "__equal", prio = 0 }
     | prim_info CONCAT_VECprim = { name = "__concat", prio = 0 }
     | prim_info INT_TO_STRINGprim = { name = "__showint", prio = 0 }
     | prim_info STRLENprim = { name = "__strlen", prio = 0 }
     | prim_info CONCAT_STRINGprim = { name = "__concatstring", prio = 0 }
     | prim_info SLICEprim = { name = "__slice", prio = 0 }
     | prim_info GET_CON_IDXprim = { name = "__get_con_idx", prio = 0 }
     | prim_info GET_CON_ARGprim = { name = "__get_con_arg", prio = 0 }
     | prim_info VOIDprim = { name = "void", prio = 0 }

   (*
   * fun f x =
   *   let fun g y = x * y          g = closure(g_closure, [x])
   *   in
   *     g 4                        invoke(g,[y])
   *   end
   *
   * int g_closure(args[], y) {
   *   return g(arg[0], y);
   * }
   *
   * int g(x, y) {
   *   return x * y;
   * }
   *
   * int f(int x) {
   *   return g_closure(x, 4);
   * }
   *)
   
   type rec_sym = sym (* a dummy symbol associated with each record literal and selector, a hack for the type refinement *)

   datatype decl =
      FUNCdecl of {
        funcClosure : arg list,
        funcType : vtype,
        funcName : sym,
        funcArgs : arg list,
        funcBody : block,
        funcRes : sym
      }
    | UPDATEdecl of {
        updateName : sym,
        updateArg : sym,
        updateFields : sym list,  (* field symbols *)
        updateType : vtype
      }
    | CONdecl of {
        conName : sym,
        conTag : sym, (* constructor symbol *)
        conArg : arg,
        conType : vtype
      }
    | CLOSUREdecl of {
        closureName : sym,
        closureArgs : vtype list,
        closureDelegate : sym,
        closureDelArgs : arg list,
        closureRetTy : vtype
      }

   and exp =
      IDexp of sym
    | PRIexp of prim * vtype * exp list
    | CALLexp of exp * exp list (* callee is unboxed *)
    | INVOKEexp of vtype * exp * exp list (* callee is a closure, type is that of exp *)
    | RECORDexp of rec_sym * vtype * (sym * exp) list
    | SELECTexp of rec_sym * vtype * sym * exp (* type is that of the record exp *)
    | LITexp of vtype * lit
    | BOXexp of vtype * exp
    | UNBOXexp of vtype * exp
    | VEC2INTexp of int option * exp
    | INT2VECexp of int * exp
    | CLOSUREexp of vtype * sym * exp list
    | STATEexp of block * vtype * exp (* generate closure of an action, the type is that of the expression *)
    | EXECexp of vtype * exp (* execute an action, type is that of exp (i.e. monadic) *)

   and stmt =
      ASSIGNstmt of sym option * exp
    | IFstmt of exp * block * block
    | CASEstmt of exp * (pat * block) list
   
   and block = BASICblock of arg list * stmt list

   and pat =
      VECpat of String.string list (* list is never empty *)
    | CONpat of sym
    | INTpat of IntInf.int
    | WILDpat

   and lit = 
      VEClit of String.string
    | STRlit of String.string
    | INTlit of IntInf.int
    | CONlit of sym

   fun getDeclName (FUNCdecl { funcName = name, ... }) = name
     | getDeclName (UPDATEdecl { updateName = name, ... }) = name
     | getDeclName (CONdecl { conName = name, ... }) = name
     | getDeclName (CLOSUREdecl { closureName = name, ... }) = name

   type decls = decl list

   type imp = {
      decls : decl list,
      fdecls : vtype SymMap.map,
      exports : sym list
   }

   structure Spec = struct
      open Spec
      type t = imp Spec.t
   end

   structure PP = struct
      open Layout Pretty
      fun var sym = SpecAbstractTree.PP.var_use sym
      fun con sym = SpecAbstractTree.PP.con_use sym
      fun fld sym = SpecAbstractTree.PP.field_use sym
      fun vars xs = seq [lp, seq (separate (map var xs, ",")), rp]
      fun args (lp,arg,xs,rp) = [str lp, seq (separate (map arg xs, ",")), str rp]
      fun fieldTy (f,t) = seq [fld f, str ":", vtype t]
      and vtype VOIDvtype = str "void"
        | vtype OBJvtype = str "obj"
        | vtype VECvtype = str "bitvec"
        | vtype INTvtype = str "int"
        | vtype STRINGvtype = str "string"
        | vtype (RECORDvtype (boxed,fs)) = 
            seq (str (if boxed then "*{" else "{") :: separate (map fieldTy fs,",") @ [str "}"])
        | vtype (FUNvtype (res, cl, atys)) =
            seq (args ("(",vtype,atys,")") @
                [str (if cl then "=>" else "->"), vtype res])
        | vtype (MONADvtype res) = seq [str "M", space, vtype res]

      fun arg (t,n) = seq [vtype t, space, var n]
      fun decl (FUNCdecl {
           funcClosure,
           funcType,
           funcName,
           funcArgs,
           funcBody,
           funcRes
         }) =
            align [
               seq ([vtype funcType, space, var funcName] @
                   (if null funcClosure then [] else
                     args ("[", arg, funcClosure, "]")) @
                   (args ("(", arg, funcArgs, ")")) @
                   [str " = ", var funcRes, str " where"]
               ),
               block funcBody
               ]
        | decl (UPDATEdecl { updateName = name, updateArg = arg, updateFields = fs, updateType = t }) =
            seq ([vtype t, space, var name, str ";"] @ args ("[",fld, fs, "]") @ [str "(", var arg, str ")"])
        | decl (CONdecl { conName = name, conTag = tag, conArg = conArg, conType = t }) =
            seq [vtype t, space, var name, str "(", arg conArg, str ");"]
        | decl (CLOSUREdecl { closureName = name, closureArgs = ts,
                              closureDelegate = del, closureDelArgs = delArgs,
                              closureRetTy = retTy }) =
            seq ([var name, space, str "invokes", space, vtype retTy, space, var del] @
                  args ("[",vtype,ts,"]") @ args ("(",arg,delArgs,")"))
      and vardecl (ty, sym) = seq [vtype ty, space, var sym]
      and lit (t,VEClit s) = seq [str "0b", str s] 
        | lit (t,STRlit s) = seq [str "\"", str s, str "\""]
        | lit (t,INTlit i) = str (IntInf.toString i)
        | lit (t,CONlit s) = con s
      and block (BASICblock (decls, stmts)) = indent 3 (align (
            seq (separate (map vardecl decls, ", ")) ::
            map stmt stmts
         ))
      and exp (IDexp sym) = var sym
        | exp (PRIexp (p,t,es)) =
            seq (vtype t :: space :: str "prim" :: space ::
              str (#name (prim_info p)) :: args ("(",exp,es,")"))
        | exp (CALLexp (f,es)) = seq (exp f :: args ("(",exp,es,")"))
        | exp (INVOKEexp (t,f,es)) = seq (vtype t :: space :: str "*" :: exp f :: args ("(",exp,es,")"))
        | exp (RECORDexp (_,t,fs)) = seq (vtype t :: space :: args ("{",field,fs,"}"))
        | exp (SELECTexp (_,t,f,e)) = seq [str "(", vtype t, str ")", exp e, space, str ".", fld f]
        | exp (LITexp l) = lit l
        | exp (BOXexp (t,e)) = seq [str "box[", vtype t, str "](", exp e, str ")"]
        | exp (UNBOXexp (t,e)) = seq [str "unbox[", vtype t, str "](", exp e, str ")"]
        | exp (VEC2INTexp (NONE,e)) = seq [str "vec2int(", exp e, str ")"]
        | exp (VEC2INTexp (SOME s,e)) = seq [str "vec2int[", str (Int.toString s), str "](", exp e, str ")"]
        | exp (INT2VECexp (s,e)) = seq [str "int2vec[", str (Int.toString s), str "](", exp e, str ")"]
        | exp (CLOSUREexp (t,s,es)) =
         seq ([vtype t, space, str "closure", space, var s] @
              args ("[",exp,es,"]"))
        | exp (STATEexp (BASICblock ([],[]), t, e)) = seq [str "(fn $ => (", vtype t, str ") ", exp e, str ")"]
        | exp (STATEexp (b, t, e)) = align [
               str "fn $ => ",
               block b,
               indent 3 (seq [str "(", vtype t, str ") ", exp e])
            ]
        | exp (EXECexp (ty,e)) = seq [str "EXEC", vtype ty, str "(", exp e, str ")"]
      and stmts ss = align (map stmt ss)
      and stmt (ASSIGNstmt (SOME s,e)) = seq [var s, space, str "=", space, exp e]
        | stmt (ASSIGNstmt (NONE,e)) = exp e
        | stmt (IFstmt (c,t,e)) =
            align [
               seq [str "if", space, exp c, space, str "then"],
               block t,
               str "else",
               block e
            ]
        | stmt (CASEstmt (e, cs)) = align
            [seq [str "case", space, exp e, space, str "of"], cases cs]
      and pat (VECpat bps) =
         seq (separate (map (fn s => str ("0b" ^ s)) bps, ","))
        | pat (CONpat s) = con s
        | pat (INTpat i) = str (IntInf.toString i)
        | pat WILDpat = str "_"
      and casee (p, ss) =
         align
            [seq [pat p, space, str ":"],
             block ss]
      and cases cs =
         case cs of [] => str "<empty>" | cs =>
            indent 3 (alignPrefix (map casee cs, "| "))
      and field (f, e) = seq [fld f, space, str "=", space, exp e]
      and def (intro, body) =
         align [seq [intro, space, str "="], indent 3 body]
      fun decls ds = align (map decl ds)
      fun imp ({ decls = ds, fdecls = fs, exports } : imp) = decls ds
      val pretty = Pretty.pretty o imp
      val spec = Spec.PP.spec imp
   end
end
