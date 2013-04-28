(**
 * ## Simple imperative intermediate representation.
 *)
structure Imp = struct
   
   type sym = SymbolTable.symid
   type lit = SpecAbstractTree.lit

   (* types of values *)
   datatype vtype =
         VOIDvtype
       | BITvtype of int
       | INTvtype
       | STRINGvtype
       | OBJvtype
       | FUNvtype of {
         result : vtype,
         closure : vtype list,
         args : vtype list
       }

   type arg = vtype * sym

   datatype prim_state =
         IPGETprim
       | CONSUME8prim
       | CONSUME16prim
       | CONSUME32prim
       | UNCONSUME8prim
       | UNCONSUME16prim
       | UNCONSUME32prim
       | PRINTLNprim
   
   datatype prim_fun =
         RAISEprim
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
       | INDEXprim

   (* information on how to print primitives, the name is the C name
      while the priority is the operator precedence, 0 if not infix *)
   fun prim_fun_info RAISEprim = { name = "__raise", prio = 0 }
     | prim_fun_info ANDprim = { name = "&", prio = 10 }
     | prim_fun_info ORprim = { name = "|", prio = 12 }
     | prim_fun_info SIGNEDprim = { name = "__sx", prio = 0 }
     | prim_fun_info UNSIGNEDprim = { name = "__zx", prio = 0 }
     | prim_fun_info ADDprim = { name = "+", prio = 6 }
     | prim_fun_info SUBprim = { name = "-", prio = 6 }
     | prim_fun_info EQprim = { name = "==", prio = 9 }
     | prim_fun_info MULprim = { name = "*", prio = 5 }
     | prim_fun_info LTprim = { name = "<", prio = 8 }
     | prim_fun_info LEprim = { name = "<=", prio = 8 }
     | prim_fun_info NOT_VECprim = { name = "__not", prio = 0 }
     | prim_fun_info EQ_VECprim = {name = "__equal", prio = 0 }
     | prim_fun_info CONCAT_VECprim = { name = "__concat", prio = 0 }
     | prim_fun_info INT_TO_STRINGprim = { name = "__showint", prio = 0 }
     | prim_fun_info BITVEC_TO_STRINGprim  = { name = "__showbitvec", prio = 0 }
     | prim_fun_info CONCAT_STRINGprim = { name = "__concatstring", prio = 0 }
     | prim_fun_info SLICEprim = { name = "__slice", prio = 0 }
     | prim_fun_info INDEXprim = { name = "__index", prio = 0 }

   fun prim_state_info IPGETprim = "__ipget"
     | prim_state_info CONSUME8prim = "__consume8"
     | prim_state_info CONSUME16prim = "__consume16"
     | prim_state_info CONSUME32prim = "__consume32"
     | prim_state_info UNCONSUME8prim = "__unconsume8"
     | prim_state_info UNCONSUME16prim = "__unconsume16"
     | prim_state_info UNCONSUME32prim = "__consume32"
     | prim_state_info PRINTLNprim = "__println"

   (*
   * fun f x =
   *   let fun g y = x * y
   *   in
   *     g 4
   *   end
   *
   * int g_closure(x, y) {
   * }
   *
   * int f(int x) {
   *   return g_closure(x, 4)
   * }
   *)
   datatype monkind =
      PUREmonkind
    | INmonkind
    | INOUTmonkind

   datatype decl =
      FUNCdecl of {
        funcMonadic : monkind,
        funcClosure : arg list,
        funcType : vtype,
        funcName : sym,
        funcArgs : arg list,
        funcLocals : arg list,
        funcBody : stmt list,
        funcRes : exp
      }
   
   and exp =
      IDexp of sym
    | CONexp of sym (* constructor constant symbol *)
    | CONFUNexp of sym (* constructor function *)
    | PRIexp of prim_fun * vtype * exp list
    | CALLexp of exp * exp list (* callee is unboxed *)
    | INVOKEexp of exp * exp list (* callee is a closure *)
    | RECORDexp of (sym * exp) list
    | LITexp of lit
    | BOXexp of vtype * exp
    | UNBOXexp of vtype * exp
    | CLOSUREexp of vtype * sym * arg list

   and stmt =
      ASSIGNstmt of sym * exp
    | IFstmt of exp * stmt list * stmt list
    | CASEstmt of exp * (Core.Pat.t * stmt list) list
    | STATEstmt of sym * monkind * prim_state * vtype * exp list

   type decls = decl list

   structure Spec = struct
      open Spec
      type t = decls Spec.t
   end

   structure PP = struct
      open Layout Pretty
      fun var sym = SpecAbstractTree.PP.var_use sym
      fun con sym = SpecAbstractTree.PP.con_use sym
      fun fld sym = SpecAbstractTree.PP.field_use sym
      fun vars xs = seq [lp, seq (separate (map var xs, ",")), rp]
      fun vtype VOIDvtype = str "void"
        | vtype OBJvtype = str "obj"
        | vtype (BITvtype s) = str ("bitvec" ^ Int.toString s)
        | vtype INTvtype = str "int"
        | vtype STRINGvtype = str "string"
        | vtype (FUNvtype _) = str "function"
      fun arg (t,n) = seq [vtype t, space, var n]
      fun args (lp,arg,xs,rp) = [str lp, seq (separate (map arg xs, ",")), str rp]
      fun monkind PUREmonkind = str "pure"
        | monkind INmonkind = str "readonly"
        | monkind INOUTmonkind = str "readwrite"
      fun decl (FUNCdecl {
           funcMonadic,
           funcClosure,
           funcType,
           funcName,
           funcArgs,
           funcLocals,
           funcBody,
           funcRes
         }) =
            align [
               seq ([monkind funcMonadic, space, vtype funcType, space,
                   var funcName] @
                   (if null funcClosure then [] else
                     args ("[", arg, funcClosure, "]")) @
                   (args ("(", arg, funcArgs, ")"))
               ),
               indent 3 (align (
                  map vardecl funcLocals @
                  map stmt funcBody @
                  [seq [str "return ", exp funcRes]] ))
               ]
      and vardecl (ty, sym) = seq [vtype ty, space, var sym]
      and exp (IDexp sym) = var sym
        | exp (CONexp sym) = con sym
        | exp (CONFUNexp sym) = con sym
        | exp (PRIexp (p,t,es)) =
            seq (vtype t :: space :: str (#name (prim_fun_info p)) ::
               args ("(",exp,es,")"))
        | exp (CALLexp (f,es)) = seq (exp f :: args ("(",exp,es,")"))
        | exp (INVOKEexp (f,es)) = seq (str "*" :: exp f :: args ("(",exp,es,")"))
        | exp (RECORDexp fs) = seq (args ("{",field,fs,"}"))
        | exp (LITexp l) = SpecAbstractTree.PP.lit l
        | exp (BOXexp (t,e)) = seq [str "box[", vtype t, str "](", exp e, str ")"]
        | exp (UNBOXexp (t,e)) = seq [str "unbox[", vtype t, str "](", exp e, str ")"]
        | exp (CLOSUREexp (t,s,es)) =
         seq ([vtype t, space, str "closure", space, var s] @
              args ("[",arg,es,"]"))
      and stmts ss = align (map stmt ss)
      and stmt (ASSIGNstmt (s,e)) = def (var s, exp e)
        | stmt (IFstmt (c,t,e)) =
            align [
               seq [str "if", space, exp c, space, str "then"],
               indent 3 (stmts t),
               str "else",
               indent 3 (stmts e)
            ]
        | stmt (CASEstmt (e, cs)) = align
            [seq [str "case", space, exp e, space, str "of"], cases cs]
        | stmt (STATEstmt (r,m,p,t,es)) = seq
            ([var r, space, str "=", space, monkind m, vtype t, space,
              str (prim_state_info p)] @
             args ("(",exp,es,")"))
      and casee (p, ss) =
         align
            [seq [Core.PP.pat p, space, str ":"],
             indent 3 (stmts ss)]
      and cases cs =
         case cs of [] => str "<empty>" | cs =>
            indent 3 (alignPrefix (map casee cs, "| "))
      and field (f, e) = seq [fld f, space, str "=", space, exp e]
      and def (intro, body) =
         align [seq [intro, space, str "="], indent 3 body]
      fun decls ds = align (map decl ds)
      val pretty = Pretty.pretty o decls
      val spec = Spec.PP.spec decls
   end
end
