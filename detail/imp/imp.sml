(**
 * ## Simple imperative intermediate representation.
 *)
structure Imp = struct
   
   type sym = SymbolTable.symid
   type lit = SpecAbstractTree.lit

   (* types of values *)
   datatype vtype =
         VOID_vtype
       | BIT_vtype
       | INT_vtype
       | STRING_vtype
       | OBJ_vtype

   type arg = vtype * sym

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
   datatype pat =
      INTpat of int list
    | CONpat of sym
    | WILDpat

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
        funcBody : stmt list
      }
   
   and exp =
      IDexp of sym
    | CONexp of sym (* constructor constant symbol *)
    | CONFUNexp of sym (* constructor function *)
    | SELECTexp of sym
	 | QUERYexp of sym
    | PRIexp of sym * exp list
    | CALLexp of exp * exp list (* callee is a symbol *)
    | INVOKEexp of exp * exp list (* callee is a closure *)
    | LITexp of lit
    | BOXexp of vtype * exp
    | UNBOXexp of vtype * exp
    | CLOSUREexp of vtype * sym * arg list

   and stmt =
      ASSIGNstmt of sym * exp
    | UPDATEstmt of sym * exp
    | IFstmt of exp * stmt list * stmt list
    | CASEstmt of exp * (pat * stmt list) list
    | PRIstmt of sym * exp list
    | RETURNstmt of exp
    
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
      val is = seq [space, str "=", space]
      fun vars xs = seq [lp, seq (separate (map var xs, ",")), rp]
      fun vtype VOID_vtype = str "void"
        | vtype OBJ_vtype = str "obj"
        | vtype BIT_vtype = str "bitvec"
        | vtype INT_vtype = str "int"
        | vtype STRING_vtype = str "string"
      fun arg (t,n) = seq [vtype t, space, var n]
      fun args (lp,xs,rp) = [str lp, seq (separate (map arg xs, ",")), str rp]
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
           funcBody
         }) =
            align
               ([monkind funcMonadic, space, vtype funcType, space, var funcName] @
                (if null funcClosure then [] else args ("[", funcClosure, ")")) @
                (args ("(", funcArgs, ")")) @
                [indent 3 (align (map vardecl funcLocals @ map stmt funcBody))]
               )
      and vardecl (ty, sym) = seq [vtype ty, space, var sym]
      and expr e = seq []
      and stmt s = case s of
         (ASSIGNstmt (s,e)) => seq [var s, is, expr e]

      fun decls ds = align (map decl ds)
      val pretty = Pretty.pretty o decls
      val spec = Spec.PP.spec decls
   end
end
