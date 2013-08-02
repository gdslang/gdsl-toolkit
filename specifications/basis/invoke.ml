export = p_cons_unwrap p_unwrap_i p_unwrap_o p_is_int

type string_ = STRING of string
val string__payload x = case x of STRING s: s end

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
val invoke-oo callback closure o = invoke callback (plbuild (P_OBJ closure) (plstart (P_OBJ o)))
val invoke-oi callback closure i = invoke callback (plbuild (P_OBJ closure) (plstart (P_INT i)))
val invoke-ooo callback closure o1 o2 = invoke callback (plbuild (P_OBJ closure) (plbuild (P_OBJ o1) (plstart (P_OBJ o2))))
val invoke-ooi callback closure o1 i = invoke callback (plbuild (P_OBJ closure) (plbuild (P_OBJ o1) (plstart (P_INT i))))
val invoke-oio callback closure i o = invoke callback (plbuild (P_OBJ closure) (plbuild (P_INT i) (plstart (P_OBJ o))))
val invoke-oooo callback closure o1 o2 o3 = invoke callback (plbuild (P_OBJ closure) (plbuild (P_OBJ o1) (plbuild (P_OBJ o2) (plstart (P_OBJ o3)))))
val invoke-ooio callback closure o1 i o2 = invoke callback (plbuild (P_OBJ closure) (plbuild (P_OBJ o1) (plbuild (P_INT i) (plstart (P_OBJ o2)))))
val invoke-oioo callback closure i o1 o2 = invoke callback (plbuild (P_OBJ closure) (plbuild (P_INT i) (plbuild (P_OBJ o1) (plstart (P_OBJ o2)))))
val invoke-oiio callback closure i1 i2 o = invoke callback (plbuild (P_OBJ closure) (plbuild (P_INT i1) (plbuild (P_INT i2) (plstart (P_OBJ o)))))
