# vim:filetype=sml:ts=3:sw=3:expandtab

# This is a modified version of the original implementation for SML.
#
# Copyright 1992-1996 Stephen Adams.
#
# This software may be used freely provided that:
#   1. This copyright notice is attached to any copy, derived work,
#      or work including all or part of this software.
#   2. Any derived work must contain a prominent notice stating that
#      it has been altered from the original.

# weight is a parameter to the rebalancing process. 
#val weight:int = 3

export =
   bbtree-size
   bbtree-empty
   bbtree-singleton
   bbtree-add
   bbtree-add-with
   bbtree-intersection
   bbtree-difference
   bbtree-contains?
   bbtree-simple-union
   bbtree-split-less-than
   bbtree-split-greater-than
   bbtree-union
   bbtree-remove
   bbtree-remove-min
   bbtree-get
   bbtree-get-orelse
   bbtree-fold
   bbtree-pretty

   intset-size
   intset-empty
   intset-singleton
   intset-add
   intset-intersection
   intset-difference
   intset-contains?
   intset-union
   intset-remove
   intset-remove-min
   intset-fold

   fitree-lt?
   fitree-size
   fitree-empty
   fitree-singleton
   fitree-add
   fitree-intersection
   fitree-difference
   fitree-interval-difference
   fitree-contains?
   fitree-union
   #fitree-remove
   fitree-remove-min
   fitree-fold
   fitree-pretty
   fitree-mk

#type intset = bbtree [a=int]
#type fitree = bbtree [a={lo:int,hi:int}]

type bbtree [a] = 
   Lf
 | Br of {size: int, left: bbtree, right: bbtree, payload: a}

val bbtree-size t =
   case t of
      Lf: 0
    | Br x: x.size
   end

val mkBr v sz l r = Br{payload=v, size=sz, left=l, right=r}

val mkN v l r =
   case l of
      Lf:
         case r of
            Lf: mkBr v 1 l r
          | Br x: mkBr v (x.size+1) l r
         end
    | Br x:
         case r of
            Lf: mkBr v (x.size+1) l r
          | Br y: mkBr v (x.size+y.size+1) l r
         end
   end

val bbtree-rotateSingleLeft a l r =
   case r of
      Br r: mkN r.payload (mkN a l r.left) r.right
   end

val bbtree-rotateSingleRight b l r =
   case l of
      Br l: mkN l.payload l.left (mkN b l.right r)
   end

val bbtree-rotateDoubleLeft a l r =
   case r of
      Br r:
         case r.left of
            Br rl: mkN rl.payload (mkN a l rl.left) (mkN r.payload rl.right r.right)
         end
   end

val bbtree-rotateDoubleRight c l r =
   case l of
      Br l:
         case l.right of
            Br lr: mkN lr.payload (mkN l.payload l.left lr.left) (mkN c lr.right r)
         end
   end

val bbtree-empty? t =
   case t of
      Lf: '1'
    | _ : '0'
   end

val mkT v lt rt =
   case lt of
      Lf:
         case rt of
            Lf: mkBr v 1 lt rt
          | Br r:
               case r.left of
                  Lf:
                     case r.right of
                        Lf: mkBr v 2 lt rt
                      | _ : bbtree-rotateSingleLeft v lt rt
                     end
                | Br rl:
                     case r.right of
                        Lf: bbtree-rotateDoubleLeft v lt rt
                      | Br rr:
                           if rl.size < rr.size
                              then bbtree-rotateSingleLeft v lt rt
                           else bbtree-rotateDoubleLeft v lt rt
                     end
               end
         end
    | Br l:
         case rt of
           Lf:
               case l.left of
                  Lf:
                     case l.right of
                        Lf: mkBr v 2 lt rt
                      | _ : bbtree-rotateDoubleRight v lt rt
                     end
                | Br ll:
                     case l.right of
                        Lf: bbtree-rotateSingleRight v lt rt
                      | Br lr:
                           if ll.size > lr.size
                              then bbtree-rotateSingleRight v lt rt
                           else bbtree-rotateDoubleRight v lt rt
                     end
               end
          | Br r:
               if r.size >= 3 * l.size
                  then
                     if bbtree-size r.left < bbtree-size r.right
                        then bbtree-rotateSingleLeft v lt rt
                     else bbtree-rotateDoubleLeft v lt rt
               else if l.size >= 3 * r.size
                  then
                     if bbtree-size l.right < bbtree-size l.left
                        then bbtree-rotateSingleRight v lt rt
                     else bbtree-rotateDoubleRight v lt rt
               else mkBr v (l.size+r.size+1) lt rt
         end
   end

val bbtree-add lt? bt x =
   case bt of
      Lf: mkBr x 1 bt bt
    | Br t:
         if lt? x t.payload
            then mkT t.payload (bbtree-add lt? t.left x) t.right
         else if lt? t.payload x
            then mkT t.payload t.left (bbtree-add lt? t.right x)
         else mkBr x t.size t.left t.right
   end

val bbtree-add-with lt? f bt x =
   case bt of
      Lf: mkBr x 1 bt bt
    | Br t:
         if lt? x t.payload
            then mkT t.payload (bbtree-add-with lt? f t.left x) t.right
         else if lt? t.payload x
            then mkT t.payload t.left (bbtree-add-with lt? f t.right x)
         else mkBr (f t.payload x) t.size t.left t.right
   end

val bbtree-remove lt? bt x =
   case bt of
      Lf: bt
    | Br t:
         if lt? x t.payload
            then mkT t.payload (bbtree-remove lt? t.left x) t.right
         else if lt? t.payload x
            then mkT t.payload t.left (bbtree-remove lt? t.right x)
         else bbtree-remove2 t.left t.right
   end

val bbtree-remove2 btl btr =
   case btl of
      Lf: btr
    | Br l:
         case btr of
            Lf: btl
          | Br r: mkT (bbtree-min btr) btl (bbtree-remove-min btr)
         end
   end

val bbtree-remove-min bt =
   case bt of
      Br t: 
         case t.left of
            Lf: t.right
          | Br l: mkT t.payload (bbtree-remove-min t.left) t.right
         end
   end

val bbtree-min bt =
   case bt of
      Br t: 
         case t.left of
            Lf: t.payload
          | _ : bbtree-min t.left
         end
   end

val bbtree-max bt =
   case bt of
      Br t: 
         case t.right of
            Lf: t.payload
          | _ : bbtree-max t.right
         end
   end

val bbtree-empty x = Lf
val bbtree-singleton x = mkBr x 1 Lf Lf

val bbtree-concat3 lt? btl x btr =
   case btl of
      Lf: bbtree-add lt? btr x
    | Br l:
       case btr of
          Lf: bbtree-add lt? btl x
        | Br r:
            if l.size * 3 < r.size
               then mkT r.payload (bbtree-concat3 lt? btl x r.left) r.right
            else if r.size * 3 < l.size
               then mkT l.payload l.left (bbtree-concat3 lt? l.right x btr)
            else mkN x btl btr
      end
   end

val bbtree-split-less-than lt? bt x =
   case bt of
      Lf: bt
    | Br t:
         if lt? x t.payload
            then bbtree-split-less-than lt? t.left x
         else if lt? t.payload x
            then bbtree-concat3 lt? t.left t.payload (bbtree-split-less-than lt? t.right x)
         else t.left
   end

val bbtree-split-greater-than lt? bt x =
   case bt of
      Lf: bt
    | Br t:
         if lt? t.payload x
            then bbtree-split-greater-than lt? t.right x
         else if lt? x t.payload
            then bbtree-concat3 lt? (bbtree-split-greater-than lt? t.left x) t.payload t.right
         else t.right
   end

val bbtree-difference lt? btl btr =
   case btl of
      Lf: btl
    | Br l:
         case btr of
            Lf: btr
          | Br r:
               bbtree-concat
                  (bbtree-difference
                     lt?
                     (bbtree-split-less-than lt? btl r.payload)
                     r.left)
                  (bbtree-difference
                     lt?
                     (bbtree-split-greater-than lt? btl r.payload)
                     r.right)
         end
   end

val bbtree-concat btl btr =
   case btl of
      Lf: btr
    | Br l:
       case btr of
          Lf: btl
        | Br r:
            if l.size * 3 < r.size
               then mkT r.payload (bbtree-concat btl r.left) r.right
            else if r.size * 3 < l.size
               then mkT l.payload l.left (bbtree-concat l.right btr)
            else mkT (bbtree-min btr) btl (bbtree-remove-min btr)
      end
   end

val bbtree-contains? lt? bt x =
   case bt of
      Lf: '0'
    | Br t: 
         if lt? x t.payload
            then bbtree-contains? lt? t.left x
         else if lt? t.payload x 
            then bbtree-contains? lt? t.right x 
         else '1'
   end

val bbtree-get lt? bt x =
   case bt of
      Br t: 
         if lt? x t.payload
            then bbtree-get lt? t.left x
         else if lt? t.payload x 
            then bbtree-get lt? t.right x 
         else t.payload
   end

val bbtree-get-orelse lt? bt x =
   case bt of
      Lf: x
    | Br t: 
         if lt? x t.payload
            then bbtree-get-orelse lt? t.left x
         else if lt? t.payload x 
            then bbtree-get-orelse lt? t.right x
         else t.payload
   end

val bbtree-intersection lt? btl btr =
   case btl of
      Lf: btl
    | Br l:
         case btr of
            Lf: btr
          | Br r:
               if bbtree-contains? lt? btl r.payload
                  then
                     bbtree-concat3
                        lt?
                        (bbtree-intersection
                           lt?
                           (bbtree-split-less-than lt? btl r.payload)
                           r.left)
                        r.payload
                        (bbtree-intersection
                           lt?
                           (bbtree-split-greater-than lt? btl r.payload)
                           r.right)
               else
                  bbtree-concat
                     (bbtree-intersection
                        lt?
                        (bbtree-split-less-than lt? btl r.payload)
                        r.left)
                     (bbtree-intersection
                        lt?
                        (bbtree-split-greater-than lt? btl r.payload)
                        r.right)
         end
   end

val bbtree-simple-union lt? btl btr =
   case btl of
      Lf: btr
    | Br l:
         case btr of
            Lf: btl
          | Br r:
               bbtree-concat3
                  lt?
                  (bbtree-simple-union
                     lt?
                     l.left
                     (bbtree-split-less-than lt? btr l.payload))
                  l.payload
                  (bbtree-simple-union
                     lt?
                     l.right
                     (bbtree-split-greater-than lt? btr l.payload))
         end
   end

val bbtree-union lt? btl btr = bbtree-simple-union lt? btl btr

val bbtree-fold f s bt =
   case bt of
      Lf: s
    | Br t: bbtree-fold f (f (bbtree-fold f s t.right) t.payload) t.left
   end

val bbtree-pretty f bt =
   let
      val prettyKey s x = s +++ f x +++ ","
   in
      "{" +++ bbtree-fold prettyKey "" bt +++ "}"
   end

## Integer Sets

val intset-lt? a b = a < b
val intset-add s x = bbtree-add intset-lt? s x
val intset-remove s x = bbtree-remove intset-lt? s x
val intset-remove-min s = bbtree-remove-min s
val intset-union a b = bbtree-union intset-lt? a b
val intset-intersection a b = bbtree-intersection intset-lt? a b
val intset-difference a b = bbtree-difference intset-lt? a b
val intset-contains? s x = bbtree-contains? intset-lt? s x
val intset-empty x = bbtree-empty x
val intset-singleton x = bbtree-singleton x
val intset-size s = bbtree-size s
val intset-fold f s t = bbtree-fold f s t

## (Finite) Interval Trees

val fitree-lt? a b =
   if a.lo < b.lo
      then '1'
   else if a.lo > b.lo
      then '0'
   else a.hi < b.hi

val interval-overlaps? x y = x.lo <= y.hi and y.lo <= x.hi
val interval-contains? x y = x.lo <= y.lo and y.hi <= x.hi
   
val fitree-search p? it x =
   let
      val maybe-search-left it acc =
         case it of
            Lf: acc
          | _ :
               if x.lo <= (bbtree-max it).hi
                  then search it acc
               else acc
         end
      val maybe-search-right it acc =
         case it of
            Lf: acc
          | _ :
               if x.hi >= (bbtree-min it).lo
                  then search it acc
               else acc
         end
      val search it acc =
         case it of
            Lf: acc
          | Br t:
               maybe-search-left
                  t.left
                  (maybe-search-right
                     t.right 
                     (if p? x t.payload
                         then fitree-add acc t.payload
                      else acc))
         end
   in
      search it (fitree-empty {})
   end

val fitree-any p? it x =
   let
      val maybe-search-left it =
         case it of
            Lf: '0'
          | _ :
               if x.lo <= (bbtree-max it).hi
                  then search it
               else '0'
         end
      val maybe-search-right it =
         case it of
            Lf: '0'
          | _ :
               if x.hi >= (bbtree-min it).lo
                  then search it
               else '0'
         end
      val search it =
         case it of
            Lf: '0'
          | Br t:
               if p? x t.payload
                  then '1'
               else
                  maybe-search-left t.left
                  or maybe-search-right t.right
         end
   in
      search it
   end

val fitree-any-overlapping? t x = fitree-any interval-overlaps? t x
val fitree-search-contained t x = fitree-search interval-contains? t x
val fitree-search-overlapping t x = fitree-search interval-overlaps? t x

# TODO:
#   Real interval difference supporting interval splitting, cutting and 
#   full interval containing 
val fitree-interval-difference a b =
   let
      val remove-contained it x = fitree-difference it (fitree-search-contained it x)
   in
      fitree-fold remove-contained a b
   end

val fitree-mk l h = {lo=l, hi=h}
val fitree-add s x = bbtree-add fitree-lt? s x
#val fitree-remove s x = bbtree-remove fitree-lt? s x
val fitree-remove-min s = bbtree-remove-min s
val fitree-union a b = bbtree-union fitree-lt? a b
val fitree-intersection a b = bbtree-intersection fitree-lt? a b
val fitree-difference a b = bbtree-difference fitree-lt? a b
val fitree-contains? s x = bbtree-contains? fitree-lt? s x
val fitree-empty x = bbtree-empty x
val fitree-singleton x = bbtree-singleton x
val fitree-size s = bbtree-size s
val fitree-fold f s t = bbtree-fold f s t
val fitree-pretty t =
   let
      val prettyInterval x =
         "[" +++ showint x.lo +++ "," +++ showint x.hi +++ "]"
   in
      bbtree-pretty prettyInterval t
   end

# TODO: Port the following {hedge union} sml code to GDSL

#local
#fun trim (lo,hi,E) = E
#| trim (lo,hi,s as T(v,_,l,r)) =
# if  lt(lo,v)  then
#if  lt(v,hi)  then  s
#else  trim(lo,hi,l)
# else trim(lo,hi,r)
#
#    
#fun uni_bd (s,E,lo,hi) = s
#| uni_bd (E,T(v,_,l,r),lo,hi) = 
#  concat3(split_gt(l,lo),v,split_lt(r,hi))
#| uni_bd (T(v,_,l1,r1), s2 as T(v2,_,l2,r2),lo,hi) =
#concat3(uni_bd(l1,trim(lo,v,s2),lo,v),
#   v, 
#   uni_bd(r1,trim(v,hi,s2),v,hi))
#    (* inv:  lo < v < hi *)
#
#      (*all the other versions of uni and trim are
#      specializations of the above two functions with
#      lo=-infinity and/or hi=+infinity *)
#
#fun trim_lo (_ ,E) = E
#| trim_lo (lo,s as T(v,_,_,r)) =
#     if lt(lo,v) then s else trim_lo(lo,r)
#fun trim_hi (_ ,E) = E
#| trim_hi (hi,s as T(v,_,l,_)) =
#     if lt(v,hi) then s else trim_hi(hi,l)
#    
#fun uni_hi (s,E,hi) = s
#| uni_hi (E,T(v,_,l,r),hi) = 
#  concat3(l,v,split_lt(r,hi))
#| uni_hi (T(v,_,l1,r1), s2 as T(v2,_,l2,r2),hi) =
#concat3(uni_hi(l1,trim_hi(v,s2),v),
#   v, 
#   uni_bd(r1,trim(v,hi,s2),v,hi))
#
#fun uni_lo (s,E,lo) = s
#| uni_lo (E,T(v,_,l,r),lo) = 
#  concat3(split_gt(l,lo),v,r)
#| uni_lo (T(v,_,l1,r1), s2 as T(v2,_,l2,r2),lo) =
#concat3(uni_bd(l1,trim(lo,v,s2),lo,v),
#   v, 
#   uni_lo(r1,trim_lo(v,s2),v))
#
#fun uni (s,E) = s
#| uni (E,s as T(v,_,l,r)) = s
#| uni (T(v,_,l1,r1), s2 as T(v2,_,l2,r2)) =
#concat3(uni_hi(l1,trim_hi(v,s2),v),
#   v, 
#   uni_lo(r1,trim_lo(v,s2),v))
#
#in
#val hedge_union = uni
#end
#
#   (* The old_union version is about 20% slower than
#      hedge_union in most cases *)
#
#val union = hedge_union
#(*val union = old_union*)
#
#val add = add
