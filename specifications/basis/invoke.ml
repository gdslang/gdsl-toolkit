export = p_cons_unwrap p_unwrap_i p_unwrap_o p_is_int

type parameter =
   P_INT of int
 | P_OBJ of string

type parameters =
   P_CONS of {hd:parameter, tl:parameters}
 | P_NIL

val p_cons_unwrap params = case params of
   P_CONS x: x
end

val p_unwrap_i param = case param of
   P_INT x: x
end

val p_unwrap_o param = case param of
   P_OBJ o: o
end

val p_is_int p = case p of
   P_INT x: 1
 | P_OBJ o: 0
end

val plbuild hd tl = P_CONS {hd=hd, tl=tl}
val plstart hd = P_CONS {hd=hd, tl=P_NIL}

val invoke-o callback closure = invoke callback (plstart (P_OBJ closure))
val invoke-oi callback closure i = invoke callback (plbuild (P_OBJ closure) (plstart (P_INT i)))
