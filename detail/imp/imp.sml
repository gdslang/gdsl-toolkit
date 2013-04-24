(**
 * ## Simple imperative intermediate representation.
 *)
structure Imp = struct
   
   type sym = SymbolTable.symid
   type lit = SpecAbstractTree.lit

   (* types of values *)
   datatype vtype =
         VOID_vtype
       | OBJ_vtype
       | BIT_vtype
       | INT_vtype
       | STRING_vtype

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

   datatype decl =
      TOPLEVELdecl of vtype * sym * arg list * stmt list
    | CLOSUREdecl of vtype * sym * arg list * arg list
   
   and exp =
      IDexp of sym
    | SELECTexp of sym
    | PRIexp of sym * sym list
    | DIRECTexp of sym * exp list
    | INDIRECTexp of sym * sym list * exp list
    | LITexp of vtype * lit
    | BOXexp of vtype * exp
    | UNBOXexp of vtype * exp

   and stmt =
      ASSIGNstmt of sym * exp
    | UPDATEstmt of sym * exp
    | IFstmt of exp * stmt list * stmt list
    | CASEstmt of exp * (pat * stmt list) list
    | PRIstmt of sym * sym list
    | DIRECTstmt of sym * exp list
    | INDIRECTstmt of sym * sym list * exp list

   type decls = decl list

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
        | vtype STRING_vtype = str "char*"
      fun arg (t,n) = seq [vtype t, space, var n]
      fun args xs = seq [lp, seq (separate (map arg xs, ",")), rp]
      
      fun decl d = case d of
         (TOPLEVELdecl (retTy, fName, formals, body)) =>
            align
               [vtype retTy, space, var fName,
                str "(", args formals, str ")",
                indent 3 (align (map stmt body))]
      | (CLOSUREdecl (retTy, fName, cformals, formals)) =>
            align
               [vtype retTy, space, var fName,
                str "(", args (cformals @ formals), str ")"]

      and expr e = seq []
      and stmt s = case s of
         (ASSIGNstmt (s,e)) => seq [var s, is, expr e]

      fun decls ds = align (map decl ds)
      val pretty = Pretty.pretty o decls
   end
end
