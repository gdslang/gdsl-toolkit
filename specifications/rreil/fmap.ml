## Map rreil identifiers (registers) to interval trees (fields)

val fmap-lt? a b = rreil-ltid? a.id b.id
val fmap-value-merge x y = {id=x.id, fields=fitree-union x.fields y.fields}
val fmap-add t x = bbtree-add fmap-lt? t x
val fmap-add-with f t x = bbtree-add-with fmap-lt? f t x
val fmap-update t x = fmap-add-with fmap-value-merge t x
val fmap-remove t x = bbtree-remove fmap-lt? t x
val fmap-remove-min t = bbtree-remove-min t
val fmap-get t x = bbtree-get fmap-lt? t {id=x.id,fields=fitree-empty} 
val fmap-get-orelse t x = bbtree-get-orelse fmap-lt? t x
val fmap-union a b = bbtree-union fmap-lt? a b
val fmap-intersection a b = bbtree-intersection fmap-lt? a b
val fmap-difference a b = bbtree-difference fmap-lt? a b
val fmap-contains? t x = bbtree-contains? fmap-lt? t x
val fmap-empty = bbtree-empty
val fmap-singleton x = bbtree-singleton x
val fmap-size t = bbtree-size t
val fmap-fold f s t = bbtree-fold f s t
val to-field sz offs = {lo=offs, hi=offs + sz - 1}
val fmap-add-field t x f = fmap-update t {id=x, fields=fitree-singleton f}
val fmap-add-range t x sz offs = fmap-add-field t x (to-field sz offs)
