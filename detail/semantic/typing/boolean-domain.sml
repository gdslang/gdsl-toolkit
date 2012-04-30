structure BooleanDomain : sig

   (*creation of Boolean variables*)
   type bvar
   val freshBVar : unit -> bvar

   val eq : (bvar * bvar) -> bool
   
   type bfun
   
   val empty : bfun

   val showVar : bvar -> string
   
   val showBFun : bfun -> string

   exception Unsatisfiable of bvar
   
   val meetVarImpliesVar : bvar * bvar -> bfun -> bfun

   (*val meetNotBoth : bvar * bvar * bfun -> bfun

   val meetEither : bvar * bvar * bfun -> bfun*)
   
   val meetEqual : bvar * bvar * bfun -> bfun

   val meetVarZero : bvar -> bfun -> bfun

   val meetVarOne : bvar -> bfun -> bfun

   type bvarset
   
   val meetVarSetZero : bvarset -> bfun -> bfun

   val meetVarSetOne : bvarset -> bfun -> bfun

   val emptySet : bvarset
   
   val union : bvarset * bvarset -> bvarset
   
   val addToSet : bvar * bvarset -> bvarset
   
   val setToString : bvarset -> string

   val projectOnto : bvarset * bfun -> bfun

   val expand : bvar list * (bool * bvar) list * bfun -> bfun
   
   val meet : bfun * bfun -> bfun
   
   (*val b1 : bvar
   val b2 : bvar
   val b3 : bvar
   val b4 : bvar
   val b5 : bvar
   val b6 : bvar
   
   val f1 : bfun
   val f2 : bfun
   val f3 : bfun
   val f4 : bfun
   val f5 : bfun*)

end = struct

   datatype bvar = BVAR of int

   fun eq (BVAR v1, BVAR v2) = v1=v2

   val bvarGenerator = ref 1

   fun freshBVar () = let
     val v = !bvarGenerator
   in
     (bvarGenerator := v+1; BVAR v)
   end

   type clause = int * int
   fun compare_clause ((s1,s2),(t1,t2)) =
      case Int.compare (s1,t1) of
           LESS => LESS
         | GREATER => GREATER
         | EQUAL => Int.compare (s2,t2)
         
   structure Clauses = ListSetFn(
      struct
         type ord_key = clause
         val compare = compare_clause
      end)
      
   type clauses = Clauses.set
   structure CS = Clauses

   type units = IntListSet.set
   structure US = IntListSet

   type bfun = units * clauses
   
   val empty = (US.empty, CS.empty)

   fun i v = Int.toString v

   fun showVar (BVAR v) = "." ^ i v

   val showUS =
      US.foldl (fn (v,str) => str ^
                  (if v<0 then "!" ^ i (~v) else " " ^ i v) ^ " ") ""
   val showCS = CS.foldl (fn ((v1,v2),str) => str ^ (
            if v1>0 andalso v2>0 then i v1 ^ " v " ^ i v2 else
            if v1<0 andalso v2>0 then i (~v1) ^ "->" ^ i v2 else
            if v1>0 andalso v2<0 then i v1 ^ "<-" ^ i (~v2) else
            if v2<0 andalso v2<0 then "!" ^ i (~v1) ^ "v!" ^ i (~v2) else
            "error") ^ " "
         ) ""
   fun showBFun (us, cs) = showUS us ^ showCS cs

   exception Unsatisfiable of bvar
   
   fun addUnits ([], f) = f
     | addUnits (v :: vs, f as (us, cs)) = (
     (*TextIO.print ("asserting " ^ i v ^ " in:" ^ showBFun f ^ "\n"); *)
      if US.member (us,~v) then raise (Unsatisfiable (BVAR (abs v))) else
      if US.member (us, v) then addUnits (vs, f) else
      let
         fun hasV (v1,v2) = v1=v orelse v1= ~v orelse v2=v orelse v2= ~v
         val (withV, withoutV) = CS.partition hasV cs
         fun ins v vs =
            if List.exists (fn v' => v'=v) vs then vs else
            if List.exists (fn v' => v'= ~v) vs then
               raise Unsatisfiable (BVAR (abs v)) 
            else v :: vs
         fun calcUnits ((v1,v2), units) = (
            (*TextIO.print ("\nlooking at " ^ i v1 ^ " v " ^ i v2);*)
            if v= ~v1 then ins v2 units else
            if v= ~v2 then ins v1 units else
            (* v=v1 orelse v=v2 *) units
            )
         val units = CS.foldl calcUnits vs withV
         val _ = if List.exists (fn u => u= ~160) units then
                  TextIO.print ("solving by asserting " ^ i v ^
                               ", giving units " ^ showUS (US.fromList units) ^
                               "due to" ^ showBFun (US.empty, withV) ^ ".\n")
                 else ()
      in
         addUnits (units, (US.add' (v,us), withoutV))
      end
      )
   and addClause ((v1,v2), f as (us,cs)) =
      if US.member (us,v1) then f else
      if US.member (us,v2) then f else
      if US.member (us,~v1) then addUnits ([v2], f) else
      if US.member (us,~v2) then addUnits ([v1], f) else
      if (Int.abs v1)=(Int.abs v2) then (
         if v1=v2 then addUnits ([v1], f) else f
      ) else (us, CS.add' (if v1<v2 then (v1,v2) else (v2,v1), cs))
   
   fun meetVarImpliesVar (BVAR v1, BVAR v2) f = (
      (*TextIO.print ("meet with " ^ i v1 ^ " -> " ^ i v2 ^ "\n");*)
      if v1=v2 then f else addClause ((~v1,v2), f)
      )
   fun meetNotBoth (BVAR v1, BVAR v2, f) = addClause ((~v1,~v2),f)
   fun meetEither (BVAR v1, BVAR v2, f) = addClause ((v1,v2),f)
   fun meetEqual  (BVAR v1, BVAR v2, f) =
      if v1=v2 then f else addClause ((~v1,v2), addClause ((~v2,v1),f))

   fun meetVarOne (BVAR v) f = (
         (*TextIO.print ("\nmeet with " ^ i v ^ " = t\n");*)
         addUnits ([v], f)
         )
   fun meetVarZero (BVAR v) f = (
         (*TextIO.print ("\nmeet with " ^ i v ^ " = f\n");*)
         addUnits ([~v], f)
         )

   fun resolve ([], (us, cs)) = (us, cs)
     | resolve (v :: vs, (us, cs)) =
     let
        val (pos,notPos) = CS.partition (fn (v1,v2) => v=v1 orelse v=v2) cs
        val (neg,cs) = CS.partition (fn (v1,v2) => v = ~v1 orelse v = ~v2) notPos
        val posVars = List.map (fn (v1,v2) => if v=v1 then v2 else v1) (CS.listItems pos)
        val negVars = List.map (fn (v1,v2) => if v= ~v1 then v2 else v1) (CS.listItems neg)
        fun combPos p (n,f as (us, cs)) =
            if p= ~n then f else if p=n then addUnits ([p], f) else
            (us, CS.add' (if p<n then (p,n) else (n,p), cs))
        fun comb f (p :: ps, ns) = comb (List.foldl (combPos p) f ns) (ps, ns)
          | comb f ([], ns) = f
     in
        resolve (vs, comb (us, cs) (posVars, negVars))
     end
     
   structure IS = IntBinarySet
   type bvarset = IS.set
   
   fun meetVarSetOne is f = (
         addUnits (IS.listItems is, f)
         )
   fun meetVarSetZero is f = (
         addUnits (List.map (~) (IS.listItems is), f)
         )
   

   val emptySet = IS.empty
   val union = IS.union

   fun addToSet (BVAR v, set) = IS.add' (v,set)

   fun setToString set =
      let
         fun show (v, (str, sep)) = (str ^ sep ^ i v, ", ")
      in
         #1 (List.foldl show ("", "{") (IS.listItems set)) ^ "}"
      end                               
   
   fun projectOnto (keep, (us, cs)) =
      let
         fun addBad (v,set) = if IS.member (keep,Int.abs v) then set
                              else IS.add' (Int.abs v,set)
         val bad = CS.foldl (fn ((v1,v2),set) => addBad (v1,addBad(v2,set)))
                            IS.empty cs
         val (us,cs) =  resolve (IS.listItems bad, (us, cs))

      in
         (US.filter (fn v => IS.member (keep, Int.abs v)) us, cs)
      end

   structure HT = IntHashTable
   exception Bug
   
   fun expand (l1, l2, (us, cs)) = if List.null l1 then (us,cs) else
      let
         val h = HT.mkTable (List.length l1, Bug)
         val _ = ListPair.appEq (fn (BVAR v1, (invert, BVAR v2)) =>
                                 HT.insert h (v1,if invert then ~v2 else v2))
                                (l1, l2)
         fun trans v = case HT.find h (Int.abs v) of
                          NONE => NONE
                        | SOME v' => SOME (if v<0 then ~v' else v')
         val newUnits = US.foldl (fn (v,set) => case trans v of
                          NONE => set
                        | SOME v => v :: set
                     ) [] us
         val newClauses = CS.foldl (fn ((v1,v2),set) =>
               case (trans v1, trans v2) of
                    (NONE, NONE) => set
                  | (SOME v1, NONE) => (v1,v2) :: set
                  | (NONE, SOME v2) => (v1,v2) :: set
                  | (SOME v1, SOME v2) => (v1,v2) :: set
               ) [] cs
         val (_,l1Str) = List.foldl (fn (BVAR v,(sep,str)) =>
                        (",",str ^ sep ^ Int.toString v)) ("","") l1
         val (_,l2Str) = List.foldl (fn ((_,BVAR v),(sep,str)) =>
                        (",",str ^ sep ^ Int.toString v)) ("","") l2
         val _ = TextIO.print ("expanding " ^ l1Str ^ " to " ^ l2Str ^
                     " by adding " ^
                     showBFun (US.fromList newUnits, CS.fromList newClauses)
                     ^ "\n")
      in
         List.foldl addClause (addUnits (newUnits, (us, cs))) newClauses
      end
   
   fun meet ((us, cs), f) =
      CS.foldl addClause (addUnits (US.listItems us,f)) cs
   
   (*val b1 = freshBVar ()
   val b2 = freshBVar ()
   val b3 = freshBVar ()
   val b4 = freshBVar ()
   val b5 = freshBVar ()
   val b6 = freshBVar ()
   
   val f1 = meetVarImpliesVar (b2,b1) empty
   val f2 = meetVarImpliesVar(b3,b2) f1
   val f3 = meetVarImpliesVar(b4,b3) f2
   val f4 = meetVarImpliesVar(b5,b4) (meetNotBoth(b1,b4,f3))
   val f5 = meetVarImpliesVar(b6,b5) (meetVarImpliesVar(b1,b6) f4)
   *)
end