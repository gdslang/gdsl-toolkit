val registers-live-map = let
  val ++- map reg-sem =
    fmap-add-range map reg-sem.id reg-sem.size reg-sem.offset
  val ++ map r = map ++- semantic-register-of r
in
  fmap-empty
  ++ R0
end
