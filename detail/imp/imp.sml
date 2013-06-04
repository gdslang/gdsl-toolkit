(**
 * ## Simple imperative intermediate representation.
 *)
structure Imp = struct
   
   type sym = SymbolTable.symid

   (* types of values *)
   datatype vtype =
         VOIDvtype
       | BITvtype
       | INTvtype
       | STRINGvtype
       | MONADvtype of vtype
       | OBJvtype
       | FUNvtype of (vtype * bool * vtype list) (* flag is true if function contains closure arguments *) 

   type arg = vtype * sym

   datatype prim =
         GETSTATEprim
       | SETSTATEprim
       | IPGETprim
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
       | BITVEC_TO_STRINGprim
       | CONCAT_STRINGprim
       | SLICEprim
       | GET_CON_IDXprim
       | GET_CON_ARGprim

   (* information on how to print primitives, the name is the C name
      and the priority is the operator precedence, 0 if not infix *)
   fun prim_info GETSTATEprim = { name = "__get_state", prio = 0 }
     | prim_info SETSTATEprim = { name = "__set_state", prio = 0 }
     | prim_info IPGETprim = { name = "__ipget", prio = 0 }
     | prim_info CONSUME8prim = { name = "__consume8", prio = 0 }
     | prim_info CONSUME16prim = { name = "__consume16", prio = 0 }
     | prim_info CONSUME32prim = { name = "__consume32", prio = 0 }
     | prim_info UNCONSUME8prim = { name = "__unconsume8", prio = 0 }
     | prim_info UNCONSUME16prim = { name = "__unconsume16", prio = 0 }
     | prim_info UNCONSUME32prim = { name = "__consume32", prio = 0 }
     | prim_info PRINTLNprim = { name = "__println", prio = 0 }
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
     | prim_info BITVEC_TO_STRINGprim  = { name = "__showbitvec", prio = 0 }
     | prim_info CONCAT_STRINGprim = { name = "__concatstring", prio = 0 }
     | prim_info SLICEprim = { name = "__slice", prio = 0 }
     | prim_info GET_CON_IDXprim = { name = "__get_con_idx", prio = 0 }
     | prim_info GET_CON_ARGprim = { name = "__get_con_arg", prio = 0 }

   (*
   * fun f x =
   *   let fun g y = x * y          g = closure(g_closure, [x])
   *   in
   *     g 4                        invoke(g,[y])
   *   end
   *
   * int g_closure(x, y) {
   *   return x * y;
   * }
   *
   * int f(int x) {
   *   return g_closure(x, 4);
   * }
   *)
   datatype monkind =
      PUREmonkind
    | ACTmonkind

   datatype decl =
      FUNCdecl of {
        funcMonadic : monkind,
        funcClosure : arg list,
        funcType : vtype,
        funcName : sym,
        funcArgs : arg list,
        funcBody : block,
        funcRes : sym
      }
    | SELECTdecl of {
        selectName : sym,
        selectField : sym,
        selectType : vtype
      }
    | UPDATEdecl of {
        updateName : sym,
        updateFields : sym list,
        updateType : vtype
      }
    | CONdecl of {
        conName : sym,
        conArg : sym,
        conType : vtype
      }

   and exp =
      IDexp of sym
    | PRIexp of monkind * prim * vtype * exp list
    | CALLexp of monkind * sym * exp list (* callee is unboxed *)
    | INVOKEexp of monkind * vtype * exp * exp list (* callee is a closure *)
    | RECORDexp of (sym * exp) list
    | LITexp of vtype * lit
    | BOXexp of vtype * exp
    | UNBOXexp of vtype * exp
    | VEC2INTexp of int option * exp
    | INT2VECexp of int * exp
    | CLOSUREexp of vtype * sym * exp list
    | STATEexp of block * exp (* generate closure that expects a state *)
    | EXECexp of exp (* apply the state to the closure *)

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

   type decls = decl list

   type imp = {
      decls : decl list,
      fdecls : vtype SymMap.map
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
      fun vtype VOIDvtype = str "void"
        | vtype OBJvtype = str "obj"
        | vtype BITvtype = str "bitvec"
        | vtype INTvtype = str "int"
        | vtype STRINGvtype = str "string"
        | vtype (MONADvtype t) = seq [str "M", space, vtype t]
        | vtype (FUNvtype (res, cl, atys)) =
            seq (args (if cl then "(...," else "(",vtype,atys,")") @
                [str "->", vtype res])
      fun arg (t,n) = seq [vtype t, space, var n]
      fun monarg PUREmonkind = empty
        | monarg ACTmonkind = seq [space, str "ACT"]
      fun decl (FUNCdecl {
           funcMonadic,
           funcClosure,
           funcType,
           funcName,
           funcArgs,
           funcBody,
           funcRes
         }) =
            align [
               seq ([vtype funcType, space,
                   var funcName, monarg funcMonadic] @
                   (if null funcClosure then [] else
                     args ("[", arg, funcClosure, "]")) @
                   (args ("(", arg, funcArgs, ")")) @
                   [str " = ", var funcRes, str " where"]
               ),
               block funcBody
               ]
        | decl (SELECTdecl { selectName = name, selectField = f, selectType = t }) =
            seq [vtype t, space, var name, str ";"]
        | decl (UPDATEdecl { updateName = name, updateFields = fs, updateType = t }) =
            seq [vtype t, space, var name, str ";"]
        | decl (CONdecl { conName = name, conArg = arg, conType = t }) =
            seq [vtype t, space, var name, str "(", var arg, str ");"]
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
        | exp (PRIexp (m,p,t,es)) =
            seq (vtype t :: space :: str "prim" :: space ::
              str (#name (prim_info p)) :: monarg m :: args ("(",exp,es,")"))
        | exp (CALLexp (m,f,es)) = seq (var f :: monarg m :: args ("(",exp,es,")"))
        | exp (INVOKEexp (m,t,f,es)) = seq (str "*" :: vtype t :: monarg m :: space :: exp f :: args ("(",exp,es,")"))
        | exp (RECORDexp fs) = seq (args ("{",field,fs,"}"))
        | exp (LITexp l) = lit l
        | exp (BOXexp (t,e)) = seq [str "box[", vtype t, str "](", exp e, str ")"]
        | exp (UNBOXexp (t,e)) = seq [str "unbox[", vtype t, str "](", exp e, str ")"]
        | exp (VEC2INTexp (NONE,e)) = seq [str "vec2int(", exp e, str ")"]
        | exp (VEC2INTexp (SOME s,e)) = seq [str "vec2int[", str (Int.toString s), str "](", exp e, str ")"]
        | exp (INT2VECexp (s,e)) = seq [str "int2vec[", str (Int.toString s), str "](", exp e, str ")"]
        | exp (CLOSUREexp (t,s,es)) =
         seq ([vtype t, space, str "closure", space, var s] @
              args ("[",exp,es,"]"))
        | exp (STATEexp (BASICblock ([],[]), e)) = seq [str "(fn $ => ", exp e, str ")"]
        | exp (STATEexp (b, e)) = align [
               str "fn $ => ",
               block b,
               indent 3 (exp e)
            ]
        | exp (EXECexp e) = seq [str "EXEC(", exp e, str ")"]
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
      fun imp ({ decls = ds, fdecls = fs } : imp) = decls ds
      val pretty = Pretty.pretty o imp
      val spec = Spec.PP.spec imp
   end
end
