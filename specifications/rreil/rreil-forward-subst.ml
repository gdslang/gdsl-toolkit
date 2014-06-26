val set-empty = bbtree-empty {}
val map-empty = set-empty

val varlset-add set varl = bbtree-add rreil-ltvarl? set varl

val varset-add set var = bbtree-add rreil-ltvar? set var
val varset-contains? set var = bbtree-contains? rreil-ltvar? set var

val expr-map-lt? a b = rreil-ltvar? a.key b.key
val expr-map-add map item = bbtree-add expr-map-lt? map item
val expr-map-at map item = (bbtree-get expr-map-lt? map {key=item, value={}}).value
val expr-map-contains? map key = bbtree-contains? expr-map-lt? map {key=key, value={}}
val expr-map-union a b = bbtree-union expr-map-lt? a b

val vars lin size = let
  val visit-var set var = varset-add set var #(@{size=size}var)
  val visit-bin set bin = expr-map-union (visit-lin set bin.opnd1) (visit-lin set bin.opnd2)

  val visit-lin set lin = case lin of
     SEM_LIN_VAR v: visit-var set v
   | SEM_LIN_IMM i: set
   | SEM_LIN_ADD a: visit-bin set a
   | SEM_LIN_SUB s: visit-bin set s
   | SEM_LIN_SCALE s: visit-lin set s.opnd
  end
in
  visit-lin set-empty lin
end

# ( ) expr: varls -> lin     { x.0/32 -> 2*y.5 + x.9, u.0/32 -> 2*y.5 + 3 }
# ( ) dep: varls -> 2^{vars} { y.5/32 -> {x.0, u.0}, x.9/32 -> {x.0} }

# (x) expr: vars -> (int*lin)     { x.0 -> (size, 2*y.5 + x.9), u.0 -> (size, 2*y.5 + 3) }
# ( ) dep: varls -> 2^{vars} { y -> ([5/32], {x.0, u.0}), x -> ([9/32], {x.0}) }; inaccurate?
# (x) dep: ids -> 2^{vars} { y -> {[5/32] => {x.0, u.0}}, x -> {[9/32] => {x.0}} };

val substitute state stmt = let
  type lin_option =
     LIN_SOME of sem_linear
   | LIN_NONE

  val substitute-linear linear = case linear of
     SEM_LIN_VAR v: if expr-map-contains? state v then
       (expr-map-at state v).lin
     else
       SEM_LIN_VAR v
   | l: l
  end
  val substitute-address address = @{address=substitute-linear address.address}address
  val substitute-sexpr sexpr = case sexpr of
     SEM_SEXPR_LIN l: SEM_SEXPR_LIN (substitute-linear l)
   | x: x
  end
  val substitute-expr expr = case expr of
     SEM_SEXPR s: SEM_SEXPR (substitute-sexpr s)
   | x: x
  end
in case stmt of
   SEM_LOAD l: SEM_LOAD (@{address=(substitute-address l.address)}l)
 | SEM_ASSIGN a: SEM_ASSIGN (@{rhs=substitute-expr a.rhs}a)
 | s: s
end end

val update-state state stmt = let
  val update-expr size expr

in case stmt of
   SEM_ASSIGN a: state
 | s: state
end

val sweep state tail = case tail of
   SEM_NIL: SEM_NIL
 | SEM_CONS cons: SEM_CONS {hd=substitute state cons.hd, tl=sweep (update-state state cons.hd) cons.tl}
end

val forward-subst stmts = do
  return 0
end
