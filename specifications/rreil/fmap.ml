## Map rreil identifiers (registers) to interval trees (fields)

val fmap-lt? a b = rreil-ltid? a.id b.id
val fmap-value-merge x y = {id=x.id, fields=fitree-union x.fields y.fields}
val fmap-add t x = bbtree-add fmap-lt? t x
val fmap-add-with f t x = bbtree-add-with fmap-lt? f t x
val fmap-update t x = fmap-add-with fmap-value-merge t x
val fmap-remove t x = bbtree-remove fmap-lt? t x
val fmap-remove-min t = bbtree-remove-min t
val fmap-get t x = bbtree-get fmap-lt? t {id=x.id,fields=fitree-empty {}} 
val fmap-get-orelse t x = bbtree-get-orelse fmap-lt? t x
val fmap-union a b = bbtree-union fmap-lt? a b
val fmap-intersection a b = bbtree-intersection fmap-lt? a b
val fmap-difference a b = bbtree-difference fmap-lt? a b
val fmap-contains? t x = bbtree-contains? fmap-lt? t x
val fmap-empty x = bbtree-empty x
val fmap-singleton x = bbtree-singleton x
val fmap-size t = bbtree-size t
val fmap-fold f s t = bbtree-fold f s t
val to-field sz offs = {lo=offs, hi=offs + sz - 1}
val fmap-add-field t x f = fmap-update t {id=x, fields=fitree-singleton f}
val fmap-add-range t x sz offs = fmap-add-field t x (to-field sz offs)
val rreil-ltid? a b =
   let
      val ltf? a b =
         case b of
 #           ARCH_R x: '1'
            VIRT_T x: '0'
          | _ : index a < index b
         end
   in
      case a of
#         ARCH_R x:
#            case b of
#               ARCH_R y: x < y
#             | _ : '0'
#            end
         VIRT_T x:
            case b of
               VIRT_T y: x < y
             | _ : '1'
            end
       | _: ltf? a b
      end
   end 
