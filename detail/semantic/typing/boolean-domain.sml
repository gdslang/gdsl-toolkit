structure BooleanDomain : sig

   (*creation of Boolean variables*)
   type bvar
   val freshBVar : unit -> bvar

   val eq : (bvar * bvar) -> bool
   
   type bfun
   
   val empty : unit -> bfun

   type bvarset
   
   val showVar : bvar -> string
   
   val showBFun : bfun -> string
   
   val dumpBFun : bfun -> string

   val showBFunPart : bvarset * bfun -> string

   exception Unsatisfiable of bvarset
   
   val meetVarImpliesVar : bvar * bvar -> bfun -> bfun

   val meetEqual : bvar * bvar * bfun -> bfun

   val meetVarZero : bvar -> bfun -> bfun

   val meetVarOne : bvar -> bfun -> bfun

   val meetVarSetZero : bvarset -> bfun -> bfun

   val meetVarSetOne : bvarset -> bfun -> bfun

   val emptySet : bvarset
   
   val union : bvarset * bvarset -> bvarset
   
   val addToSet : bvar * bvarset -> bvarset

   val member : bvarset * bvar -> bool
   
   val setToString : bvarset -> string

   val projectOut : bvarset * bfun -> bfun

   val expand : bvar list * (bool * bvar) list * bfun -> bfun
   
   val b1 : bvar
   val b2 : bvar
   val b3 : bvar
   val b4 : bvar
   val b5 : bvar
   val b6 : bvar
   
   val f1 : bfun
   val f2 : bfun

end = struct

   type var = int
   
   datatype bvar = BVAR of var

   fun eq (BVAR v1, BVAR v2) = v1=v2

   val bvarGenerator = ref 2
   
   fun freshBVar () = let
     val v = !bvarGenerator
   in
     (bvarGenerator := v+1; BVAR v)
   end
   
   val falseVar = 0
   val trueVar = 1
   
   structure IS = IntBinarySet
   type bvarset = IS.set

   type edge_info = unit
   
   fun combineEI (x : edge_info, y : edge_info) = () : edge_info
   
   structure HT = IntHashTable
   structure ES = IntListMap
   
   type edgeset = edge_info ES.map

   type bfun = {
      forward : edgeset HT.hash_table,
      backward : edgeset HT.hash_table,
      constants : bool HT.hash_table
   }
   
   exception BVarNotFound
   
   val initSize = 3000
   fun empty () =
      let
         val co = HT.mkTable (initSize,BVarNotFound)
         val _ = HT.insert co (falseVar,false)
         val _ = HT.insert co (trueVar,true)
      in
         {
            forward = HT.mkTable (initSize,BVarNotFound),
            backward = HT.mkTable (initSize,BVarNotFound),
            constants = co
         } : bfun
      end

   fun i v = Int.toString v

   fun showVar (BVAR v) = "." ^ i v

   fun showConst (var,true,str) = str ^ " " ^ Int.toString var
     | showConst (var,false,str) = str ^ " !" ^ Int.toString var

   fun showEdge (false, source) (target, ei, str) =
      str ^ " " ^ Int.toString source ^ "->" ^ Int.toString target
     | showEdge (true, source) (target, ei, str) =
      str ^ " " ^ Int.toString target ^ "->" ^ Int.toString source

   fun showBFun ({forward = fw, backward = bw, constants = co} : bfun) =
      let
         fun showEdges (source,es,str) = ES.foldli (showEdge (false,source)) str es
      in
         HT.foldi showEdges (HT.foldi showConst "" co) fw
      end
      
   fun showBFunPart (vs, {forward = fw, backward = bw, constants = co}) =
      let
         val str = IS.foldl (fn (v,str) =>
            case HT.find co v of
                 NONE => str
               | SOME truth => showConst (v,truth,str)) "" vs
         fun showEdges (source,es,str) = IS.foldl (fn (target,str) =>
            case ES.find (es, target) of
                 NONE => str
               | SOME ei => showEdge (false,source) (target,ei,str)) str vs
         val str = IS.foldl (fn (v,str) =>
            case HT.find fw v of
                 NONE => str
               | SOME es => showEdges (v,es,str)) str vs
      in
         str
      end
   
   fun dumpBFun {forward = fw, backward = bw, constants = co} =
      let
         val cStr = HT.foldi showConst "constants:" co
         fun showEdges swap (source,es,str) = ES.foldli (showEdge (swap,source)) str es
         val fStr = HT.foldi (showEdges false) "forward:" fw
         val bStr = HT.foldi (showEdges true) "backward:" bw
      in
         cStr ^ "\n" ^ fStr ^ "\n" ^ bStr ^ "\n"
      end

   exception Unsatisfiable of bvarset
   
   fun meetSetOne vs {forward = fw, backward = bw, constants = co} =
      let
         fun run [] = ()
           | run (v :: vs) = case HT.find co v of
                SOME true => run vs
              | SOME false => raise Unsatisfiable (IS.singleton v)
              | NONE => (HT.insert co (v,true); case HT.find fw v of
                   NONE => run vs
                 | SOME es => run (ES.foldli (fn (target,_,vs) => target::vs) vs es)
               )
         val _ = run vs
      in
         ()
      end
   
   fun meetSetZero vs {forward = fw, backward = bw, constants = co} =
      let
         fun run [] = ()
           | run (v :: vs) = case HT.find co v of
                SOME false => run vs
              | SOME true => raise Unsatisfiable (IS.singleton v)
              | NONE => (HT.insert co (v,false); case HT.find bw v of
                   NONE => run vs
                 | SOME es => run (ES.foldli (fn (source,_,vs) => source::vs) vs es)
               )
         val _ = run vs
      in
         ()
      end
 
   fun getEdgeSet (ht : edgeset HT.hash_table, key) = case HT.find ht key of
        NONE => ES.empty
      | SOME es => es
   fun setEdgeSet (ht : edgeset HT.hash_table, key, edges) = 
      if ES.isEmpty edges then (if HT.inDomain ht key then (HT.remove ht key; ()) else ())
      else HT.insert ht (key, edges)
   
   fun varImpliesVar (v1, v2) (bFun as {forward = fw, backward = bw, constants = co}) =
      if (v1=v2) then bFun else
      let
         val es = getEdgeSet (fw, v1)
         val _ = case ES.find (es, v2) of
              SOME ei => ()
            | NONE => (
               setEdgeSet (fw, v1, ES.insert (es, v2, ()));
               case HT.find co v2 of
                   SOME false => meetSetZero [v1] bFun
                 | _ => ()
             )
         val es = getEdgeSet (bw, v2)
         val _ = case ES.find (es, v1) of
              SOME ei => ()
            | NONE => (
               setEdgeSet (bw, v2, ES.insert (es, v1, ()));
               case HT.find co v1 of
                   SOME true => meetSetOne [v2] bFun
                 | _ => ()
             )
      in
         bFun
      end

   fun meetEqual  (BVAR v1, BVAR v2, bFun) =
      varImpliesVar (v1,v2) (varImpliesVar (v2,v1) bFun)

   fun meetVarImpliesVar (BVAR v1, BVAR v2) bFun = varImpliesVar (v1,v2) bFun

   fun meetVarOne (BVAR v) bFun = (varImpliesVar (v, trueVar) bFun; bFun)

   fun meetVarZero (BVAR v)  bFun = (varImpliesVar (falseVar, v) bFun; bFun)


   fun meetVarSetOne is bFun = (meetSetOne (IS.listItems is) bFun; bFun)

   fun meetVarSetZero is bFun = (meetSetZero (IS.listItems is) bFun; bFun)

   exception Bug
   
   fun removeVar (v, bFun as {forward = fw, backward = bw, constants = co}) =
      let
         val _ = if HT.inDomain co v then HT.remove co v else false
         val esForw = if HT.inDomain fw v then HT.remove fw v else ES.empty
         val esBack = if HT.inDomain bw v then HT.remove bw v else ES.empty
         fun removeSymmetric ht (v', _) =
            let
               val es = getEdgeSet (ht, v')
               val es = #1 (ES.remove (es, v))
                  handle NotFound => es
            in
               setEdgeSet (ht, v', es)
            end
         val _ = ES.appi (removeSymmetric fw) esBack
         val _ = ES.appi (removeSymmetric bw) esForw
         (* compute an edge from two edges v1 -> v (from esBack) and v -> v2 (from esForw) *)
         fun insertResultant (v1,ei1) (v2,ei2) = if v1=v2 then () else
            let
               val ei = combineEI (ei1,ei2)
               val _ = setEdgeSet (fw, v1, ES.insert (getEdgeSet (fw, v1),v2,ei))
               val _ = setEdgeSet (bw, v2, ES.insert (getEdgeSet (bw, v2),v1,ei))
            in
               ()
            end
         val _ = ES.appi (fn back => ES.appi (insertResultant back) esForw) esBack
      in
         bFun
      end

   fun projectOut (bad, bFun) = (List.foldl removeVar bFun (IS.listItems bad); bFun)

   (* this is a lazy implementation of expansion that only works when both
      variables of an edge are always expanded together (which happens to hold here) *)
   fun expand (l1, l2, bFun as  {forward = fw, backward = bw, constants = co}) =
      if List.null l1 then bFun else
      let
         val h = HT.mkTable (List.length l1, Bug)
         val _ = ListPair.appEq (fn (BVAR v1, (invert, BVAR v2)) =>
                                 HT.insert h (v1,if invert then ~v2 else v2))
                                (l1, l2)
         fun expandEdges ht (BVAR v1) =
            let
               val v1' = HT.lookup h v1
               val pos = v1'>0
               val es = getEdgeSet (ht,v1)
               fun renameEdge (v2,ei) =
                  let
                     val v2' = case HT.find h v2 of SOME v => v | NONE => v2
                     val (v1New, v2New) = if pos then (v1', v2') else (~v2', ~v1')
                  in
                     setEdgeSet (ht, v1New, ES.insert (getEdgeSet (ht, v1New),v2New,ei))
                  end
            in
               ES.appi renameEdge es
            end
         val _ = List.app (expandEdges fw) l1
         val _ = List.app (expandEdges bw) l1
         
         fun expandConst (BVAR v) = case HT.find co v of
              NONE => ()
            | SOME truth =>
               let
                  val v' = HT.lookup h v
                  val pos = v'>0
                  
               in
                  if pos then HT.insert co (v',truth) else HT.insert co (~v',not truth)
               end
         val _ = List.app expandConst l1
      in
         bFun
      end

   val emptySet = IS.empty
   val union = IS.union

   fun addToSet (BVAR v, set) = IS.add' (v,set)

   fun member (set, BVAR v) = IS.member(set, v)

   fun setToString set =
      let
         fun show (v, (str, sep)) = (str ^ sep ^ i v, ", ")
      in
         #1 (List.foldl show ("{", "") (IS.listItems set)) ^ "}"
      end                               
   
   
   val b1 = freshBVar ()
   val b2 = freshBVar ()
   val b3 = freshBVar ()
   val b4 = freshBVar ()
   val b5 = freshBVar ()
   val b6 = freshBVar ()
   
   val f1 = meetVarImpliesVar (b2,b1) (empty ())
   val _ = meetVarImpliesVar (b3,b2) f1
   val _ = meetVarImpliesVar (b5,b4) f1
   val _ = meetVarImpliesVar (b6,b5) f1
   
   val f2 = meetVarImpliesVar (b1,b2) (empty ())
   val _ = meetVarImpliesVar (b2,b3) f2
   val _ = meetVarImpliesVar (b3,b4) f2
   val _ = meetVarImpliesVar (b4,b5) f2
   val _ = meetVarImpliesVar (b5,b6) f2
   
end
