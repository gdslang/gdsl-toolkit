structure SizeConstraint : sig
   type size_constraint

   (*create a constraint of the form a = b+...z+42*)
   val equality : TVar.tvar * TVar.tvar list * int -> size_constraint

   type size_constraint_set
   val empty : size_constraint_set
   val add : size_constraint * size_constraint_set -> size_constraint_set
   val merge : size_constraint_set * size_constraint_set -> size_constraint_set
   val listItems : size_constraint_set -> size_constraint list

   datatype instantiation
      = INSTANCE of (TVar.tvar * int)
      | RESULT of size_constraint
      | REDUNDANT
      | UNSATISFIABLE
      | FRACTIONAL
      | NEGATIVE
   
   val applyRenaming : TVar.tvar * TVar.tvar * size_constraint -> instantiation
   val applyInstantiation : TVar.tvar * int * size_constraint -> instantiation
   
   val filter : TVar.set * size_constraint_set -> size_constraint_set
   
   val getVarset : size_constraint -> TVar.set
   val toStringSI : size_constraint_set * TVar.tvar option * TVar.varmap ->
                    string * TVar.varmap

end = struct

   type size_constraint = {
      terms : (int * TVar.tvar) list,
      const : int
   }
   type size_constraint_set = size_constraint list

   val empty = []
   val add = op ::
   val merge = op @
   fun listItems scs = scs

   fun toStringSI (scs, filter, si) =
      let
         val siRef = ref si
         fun showVar v = case TVar.varToString (v,!siRef) of
            (str,si) => (siRef := si; str)
         fun showFac f = if f=1 then "" else Int.toString f
         fun showTS ({terms=[], const=c},psep,pos,nsep,neg) =
            if c=0 then pos ^ "=" ^ neg else
            if c<0 then pos ^ "=" ^ neg ^ nsep ^ Int.toString(~c)
            else pos ^ psep ^ Int.toString(c) ^ "=" ^ neg
           | showTS ({terms=((fac,var)::ts), const=c},psep,pos,nsep,neg) =
               if fac>=0 then showTS ({terms = ts, const = c},
                  "+", pos ^ psep ^ showFac fac ^ showVar var, nsep, neg)
               else  showTS ({terms = ts, const = c},
                  psep, pos, "+", neg ^ nsep ^ showFac (~fac) ^ showVar var)
         val scs = case filter of
              NONE => scs
            | SOME v => List.filter (fn {terms=ts, const} =>
               List.all (fn (_,var) => not (TVar.eq(v,var))) ts) scs
         val (res,_) = List.foldl (fn (sc,(res,sep)) =>
               (res ^ sep ^ showTS (sc,"","","",""), ", ")) ("", "") scs
      in
         (res, !siRef)
      end
         
   fun addTermToSC (f,v,{terms = ts, const = c}) =
      let
         fun aTSC (res,[]) = res @ [(f,v)]
           | aTSC (res, (fac,var)::ts) = (case TVar.compare (v,var) of
                EQUAL => let val newF = fac+f in
                           if newF=0 then res @ ts else res @ (newF,v) :: ts
                         end
              | LESS => res @ (f,v) :: (fac,var)::ts
              | GREATER => aTSC (res @ [(fac,var)], ts))
      in
         {terms = aTSC ([],ts), const = c}
      end

   fun lookupVarSC (v, {terms = ts, const = c}) =
      case List.find (fn (fac,var) => TVar.eq (v,var)) ts of
           NONE => 0
         | SOME (fac,_) => fac

   fun equality (lhs, terms, c) =
      List.foldl (fn ((f,v), sc) => addTermToSC (f,v,sc))
         { terms = [], const = c}
         ((~1,lhs) :: List.map (fn v => (1,v)) terms)

   datatype instantiation
      = INSTANCE of (TVar.tvar * int)
      | RESULT of size_constraint
      | REDUNDANT
      | UNSATISFIABLE
      | FRACTIONAL
      | NEGATIVE

   fun checkForNewInstance {terms = [], const = 0} = REDUNDANT
     | checkForNewInstance {terms = [], const = _} = UNSATISFIABLE
     | checkForNewInstance {terms = [(f,v)], const = n} = 
         if Int.rem (~n, f) <> 0 then FRACTIONAL
         else if Int.quot (~n, f) <0 then NEGATIVE
         else INSTANCE (v,Int.quot (~n, f))
     | checkForNewInstance sc = RESULT sc

   fun applyRenaming (v1,v2,sc) =
      checkForNewInstance (case lookupVarSC (v1,sc) of
           0 => sc
         | n => addTermToSC (n,v2,addTermToSC (~n,v1,sc))
      )

   fun applyInstantiation (v,con,sc) =
      checkForNewInstance (case lookupVarSC (v,sc) of
            0 => sc
          | n => (case addTermToSC (~n,v,sc) of
             {terms = ts, const =c} => {terms = ts, const = c+(n*con)}
         )
      )

   fun getVarset {terms = ts, const} =
      List.foldl (fn ((fac,var), vs) => TVar.add (var,vs)) TVar.empty ts

   fun filter (vs, scs) = List.filter
      (fn sc => not (TVar.isEmpty (TVar.intersection (vs, getVarset sc)))) scs

end