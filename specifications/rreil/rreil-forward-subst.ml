val set-empty = bbtree-empty {}
val varlset-add set varl = bbtree-add rreil-ltvarl? set varl
val varset-add set var = bbtree-add rreil-ltvar? set var

val vars lin size = let
  val visit-var set var = varset-add set var #(@{size=size}var)

  val visit-lin set lin = case lin of
     SEM_LIN_VAR v: visit-var set v
  end
in
  visit-lin set-empty lin
end

# expr: varls -> lin     { x.0/32 -> 2*y.5 + x.9, u.0/32 -> 2*y.5 + 3 }
# dep: varls -> 2^{vars} { y.5/32 -> {x.0, u.0}, x.9/32 -> {x.0} }

# expr: varls -> lin     { x.0 -> (size, 2*y.5 + x.9), u.0 -> (size, 2*y.5 + 3) }
# dep: varls -> 2^{vars} { y -> ([5/32], {x.0, u.0}), x -> ([9/32], {x.0}) }; inaccurate?
# dep: varls -> 2^{vars} { y -> {[5/32] => {x.0, u.0}}, x -> {[9/32] => {x.0}} };
