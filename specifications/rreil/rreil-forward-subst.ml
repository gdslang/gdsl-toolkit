val set-empty = bbtree-empty {}
val map-empty = set-empty

val varlset-add set varl = bbtree-add rreil-ltvarl? set varl

val varset-add set var = bbtree-add rreil-ltvar? set var
val varset-contains? set var = bbtree-contains? rreil-ltvar? set var

val expr-map-lt? a b = rreil-ltvar? a.key b.key
val expr-map-add map item = bbtree-add expr-map-lt? map item
val expr-map-contains map key = bbtree-contains? expr-map-lt? map {key=key, value={}}

val vars lin size = let
  val visit-var set var = varset-add set var #(@{size=size}var)

  val visit-lin set lin = case lin of
     SEM_LIN_VAR v: visit-var set v
  end
in
  visit-lin set-empty lin
end

# ( ) expr: varls -> lin     { x.0/32 -> 2*y.5 + x.9, u.0/32 -> 2*y.5 + 3 }
# ( ) dep: varls -> 2^{vars} { y.5/32 -> {x.0, u.0}, x.9/32 -> {x.0} }

# (x) expr: vars -> (int*lin)     { x.0 -> (size, 2*y.5 + x.9), u.0 -> (size, 2*y.5 + 3) }
# ( ) dep: varls -> 2^{vars} { y -> ([5/32], {x.0, u.0}), x -> ([9/32], {x.0}) }; inaccurate?
# (x) dep: ids -> 2^{vars} { y -> {[5/32] => {x.0, u.0}}, x -> {[9/32] => {x.0}} };

val substitude state stmt = let
  val substitude-linear linear = case linear of
     SEM_LIN_VAR v: SEM_LIN_VAR v
   | l: l
  end
  val substitude-address address = @{address=substitude-linear address.address}address
  val substitude-sexpr sexpr = case sexpr of
     SEM_SEXPR_LIN l: SEM_SEXPR_LIN (substitude-linear l)
   | x: x
  end
  val substitude-expr expr = case expr of
     SEM_SEXPR s: SEM_SEXPR (substitude-sexpr s)
   | x: x
  end
in case stmt of
   SEM_LOAD l: SEM_LOAD (@{address=(substitude-address l.address)}l)
 | SEM_ASSIGN a: SEM_ASSIGN (@{rhs=substitude-expr a.rhs}a)
 | s: s
end end

val update-state state stmt = state

val sweep state tail = case tail of
   SEM_NIL: SEM_NIL
 | SEM_CONS cons: SEM_CONS {hd=substitude state cons.hd, tl=sweep (update-state state cons.hd) cons.tl}
end

#val forward-subst stmts = do
#  
#end
