structure SizeConstraint : sig
   type size_constraint

   (*create a constraint of the form a = b+...z+42*)
   val equality : TVar.tvar * TVar.tvar list * int -> size_constraint

   type size_constraint_set

   datatype instantiation
      = RESULT of (TVar.tvar * int) list * size_constraint_set
      | REDUNDANT
      | UNSATISFIABLE
      | FRACTIONAL
      | NEGATIVE
   
   val empty : size_constraint_set
   val add : size_constraint * size_constraint_set -> instantiation
   val fromList : size_constraint list -> size_constraint_set
   val listItems : size_constraint_set -> size_constraint list

   val filter : TVar.set * size_constraint_set -> size_constraint_set
   val merge : size_constraint_set * size_constraint_set ->
               size_constraint_set
   val rename : TVar.tvar * TVar.tvar * size_constraint_set ->
                size_constraint_set
   val getVarset : size_constraint_set -> TVar.set
   val toStringSI : size_constraint_set * TVar.set option * TVar.varmap ->
                    string * TVar.varmap

end = struct

   type size_constraint = {
      terms : (int * TVar.tvar) list,
      const : int
   }
   type size_constraint_set = size_constraint list

   datatype instantiation
      = RESULT of (TVar.tvar * int) list * size_constraint_set
      | REDUNDANT
      | UNSATISFIABLE
      | FRACTIONAL
      | NEGATIVE

   fun filter (vs, scs) = List.filter
      (fn {terms = ts, const} =>
         List.exists (fn (_,v) => TVar.member (vs,v)) ts)
      scs

   fun toStringSI (scs, filterSet, si) =
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
         val scs = case filterSet of NONE => scs
                                   | SOME vs => filter (vs, scs)
         val (res,_) = List.foldl (fn (sc,(res,sep)) =>
               (res ^ sep ^ showTS (sc,"","","",""), ", ")) ("", "") scs
      in
         (res, !siRef)
      end
         
   val empty = []

   exception SizeConstraintBug

   fun add (sc,scs) =
      let
         fun merge (mul1,mul2,ts1,ts2) =
            let
               fun m ((f1,v1)::ts1, (f2,v2)::ts2) =
                  (case TVar.compare (v1,v2) of
                       LESS => (mul1*f1,v1) :: m (ts1, (f2,v2)::ts2)
                     | GREATER => (mul2*f2,v2) :: m ((f1,v1)::ts1, ts2)
                     | EQUAL => 
                        let
                           val f = mul1*f1+mul2*f2
                        in
                           if f=0 then m (ts1,ts2) else (f,v1) :: m (ts1,ts2)
                        end)
                 | m ((f1,v1)::ts1, []) = (mul1*f1,v1) :: m (ts1, [])
                 | m ([], (f2,v2)::ts2) = (mul2*f2,v2) :: m ([], ts2)
                 | m ([], []) = []
            in
               m (ts1,ts2)
            end
         fun ins ({terms = [], const = 0}, scs) = REDUNDANT
           | ins ({terms = [], const = _}, scs) = UNSATISFIABLE
           | ins ({terms = [(f,v)], const = n}, []) = 
               if Int.rem (~n, f) <> 0 then FRACTIONAL
               else if Int.quot (~n, f) <0 then NEGATIVE
               else RESULT ([(v,Int.quot (~n, f))], [])
           | ins (sc, []) = RESULT ([],[sc])
           | ins ((sc1 as {terms = ts1 as ((f1,v1) :: rem), const = n1}),
                  (sc2 as {terms = ts2 as ((f2,v2) :: _), const = n2}) :: scs) =
               let
                  fun genResult (is,scs) =
                     if not (List.null rem) then RESULT (is,scs) else
                     if Int.rem (~n1, f1) <> 0 then FRACTIONAL
                     else if Int.quot (~n1, f1) <0 then NEGATIVE
                     else RESULT ((v1,Int.quot (~n1, f1)) :: is, scs)
               in
                  case TVar.compare (v1,v2) of
                       GREATER => genResult ([], sc1 :: sc2 :: scs)
                     | LESS => (case ins (sc1, scs) of
                          RESULT (is,scs) => genResult (is, sc2 :: scs)
                        | other => other)
                     | EQUAL =>
                        let
                           val newTs = merge (f2,~f1,ts1,ts2)
                           val newN = f2*n1-f1*n2
                           
                        in
                           case ins ({terms = newTs, const = newN}, scs) of
                                RESULT (is,scs) => genResult (is, sc2 :: scs)
                              | other => other
                        end
               end
            | ins _ = raise SizeConstraintBug
      val (eStr, si) = toStringSI ([sc], NONE, TVar.emptyShowInfo)
      val (sStr, si) = toStringSI (scs, NONE, si)
      val nStr = case ins (sc,scs) of
           RESULT (_, scs) => #1 (toStringSI (scs, NONE, si))
         | UNSATISFIABLE => "unsatisfiabilitiy"
         | REDUNDANT => "redundancy"
         | FRACTIONAL => "non-integrality"
         | NEGATIVE => "negativitiy"
      val _ = TextIO.print ("inserting " ^ eStr ^ " into " ^ sStr ^ ", leading to " ^ nStr ^ "\n")
   in
      ins (sc, scs)
   end

   fun fromList eqs =
      let
         fun fL ([], scs) = scs
           | fL (eq :: eqs, scs) = case add (eq, scs) of
                RESULT ([], scs) => fL (eqs, scs)
              | _ => raise SizeConstraintBug
      in
         fL (eqs, empty)
      end

   fun listItems scs = scs

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

   fun getVarset scs =
      let
         fun gV ({terms = ts, const}, vs) =
            List.foldl (fn ((fac,var), vs) => TVar.add (var,vs)) vs ts
      in
         List.foldl gV TVar.empty scs
      end
      
   fun merge (scs1, scs2) =
      let
         (*val (sStr1, si) = toStringSI (scs1, NONE, TVar.emptyShowInfo)
         val (sStr2, si) = toStringSI (scs2, NONE, si)
         val _ = TextIO.print ("merging " ^ sStr1 ^ " with " ^ sStr2 ^ "\n")*)
         fun m ([], scs) = scs
           | m (eq :: eqs, scs) = case add (eq, scs) of
                RESULT (_, scs) => m (eqs, scs)
              | REDUNDANT => m (eqs, scs)
              | _ => raise SizeConstraintBug
      in
         m (scs1, scs2)
      end

   fun rename (v1,v2,scs) =
      let
         val (tVar1, si) = TVar.varToString (v1, TVar.emptyShowInfo)
         val (tVar2, si) = TVar.varToString (v2, si)
         val (sStr, si) = toStringSI (scs, NONE, si)
         val _ = TextIO.print ("renaming " ^ tVar1 ^ " to " ^ tVar2 ^ " in " ^ sStr ^ "\n")
         fun hasV1 {terms = ts,const} =
            List.exists (fn (_,v) => TVar.eq(v,v1)) ts
         val (withVar, retained) = List.partition hasV1 scs
         fun renameVar sc = case lookupVarSC (v1,sc) of f1 =>
               addTermToSC (f1,v2, addTermToSC (~f1,v1, sc))
         val renamed = List.map renameVar withVar
      in
         merge (renamed, retained)
      end
end