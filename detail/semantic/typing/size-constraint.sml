structure SizeConstraint : sig
   type size_constraint

   (*create a constraint of the form a = b+...z+42*)
   val equality : TVar.tvar * TVar.tvar list * int -> size_constraint

   type size_constraint_set

   datatype instantiation
      = RESULT of (TVar.tvar * int) list * size_constraint_set
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

   exception SizeConstraintBug

   type size_constraint = {
      terms : (int * TVar.tvar) list,
      const : int
   }
   type size_constraint_set = size_constraint list

   datatype instantiation
      = RESULT of (TVar.tvar * int) list * size_constraint_set
      | UNSATISFIABLE
      | FRACTIONAL
      | NEGATIVE

   fun filter (vs, scs) =
      let
         fun hasDeadLeading {terms = (_,v)::_, const} = TVar.member (vs,v)
           | hasDeadLeading _ = raise SizeConstraintBug 
         val scs = List.filter hasDeadLeading scs
      in
         scs
      end

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

   fun mergeSC (_,0,sc1,sc2) = sc1
     | mergeSC (0,_,sc1,sc2) = sc2
     | mergeSC (mul1,mul2,{terms = ts1, const = n1},
               {terms = ts2, const = n2}) =
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
         val ts = m (ts1,ts2)
         val c = mul1*n1+mul2*n2
         fun gcd (m,n) = if m=n then n else
                           if m>n then gcd(m-n,n) else gcd(m,n-m)
         val d = List.foldl (fn ((f,_),d) => if d=0 then Int.abs f else
                                             gcd (Int.abs f,d))
                            (Int.abs c) ts
      in
         if d<=1 then {terms = ts, const = c} else
          {terms = List.map (fn (f,v) => (Int.quot (f,d),v)) ts,
           const = Int.quot (c,d)}
      end

   fun add (eq,scs) =
      let
         fun inline (sc as {terms = (f,v) :: _, const = n2}, eq) =
               mergeSC (~f, lookupVarSC (v, eq), eq, sc)
           | inline (_, eq) = eq
         fun eqsIntoEq (eq, scs) = List.foldl inline eq scs
         fun eqIntoEqs (eq, scs) = List.map (fn sc => inline (eq,sc)) scs
         fun insert (eq as {terms = [], const}, scs) = eq :: scs
           | insert (eq as {terms = (_,v1) :: _, const = n1},
                    (sc as {terms = (_,v2) :: _, const = n2}) :: scs) =
               (case TVar.compare (v1,v2) of
                    LESS => eq :: sc :: scs
                  | GREATER => sc :: insert (eq, scs)
                  | EQUAL => raise SizeConstraintBug)
           | insert (eq, []) = [eq]
           | insert (eq, sc :: scs) = sc :: insert (eq, scs)
         fun gatherFun ({terms = [], const = 0}, res) = res
           | gatherFun ({terms = [], const = _}, res) = UNSATISFIABLE
           | gatherFun ({terms = [(f,v)], const = n}, RESULT (is,eqs)) = 
               if Int.rem (~n, f) <> 0 then FRACTIONAL
               else if Int.quot (~n, f) < 0 then NEGATIVE
               else RESULT ((v,Int.quot (~n, f))::is, eqs)
           | gatherFun (eq, RESULT (is,eqs)) = RESULT (is,eqs @ [eq])
           | gatherFun (eq, res) = res
         val eq = eqsIntoEq (eq, scs)
         val scs = eqIntoEqs (eq, scs)
         (*val (eStr, si) = toStringSI ([eq], NONE, TVar.emptyShowInfo)
         val (sStr, si) = toStringSI (scs, NONE, si)
         val _ = TextIO.print ("inserting " ^ eStr ^ " into " ^ sStr ^ "\n")*)
         val scs = insert (eq,scs)
         val res = List.foldl gatherFun (RESULT ([],[])) scs
         (*val nStr = case res of
              RESULT (is, scs) =>
              let
                 val (scsStr, si) = (toStringSI (scs, NONE, si))
                 val (vsStr, si) = List.foldl (fn ((v,f),(str, si)) =>
                   let val (vStr, si) = TVar.varToString (v,si) in
                      (str ^ " " ^ vStr ^ "=" ^ Int.toString(f), si)
                   end) ("", si) is
              in
                 "result : " ^ scsStr ^ " and" ^ vsStr ^ " instantiated\n"
              end
            | UNSATISFIABLE => "unsatisfiabilitiy"
            | FRACTIONAL => "non-integrality"
            | NEGATIVE => "negativitiy"
         val _ = TextIO.print ("new system is " ^ nStr ^ "\n")*)
      in
         res
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
   
   fun diff (scs1, scs2) =
      let
         fun cmp ({terms=(_,v1)::_, const=_},{terms=(_,v2)::_, const=_}) =
                  TVar.compare (v1,v2)
           | cmp _ = raise SizeConstraintBug
         fun genDiff (sc1 :: scs1, sc2 :: scs2) =
            (case cmp (sc1,sc2) of
                 LESS => sc1 :: genDiff (scs1, sc2 :: scs2)
               | GREATER => genDiff (sc1 :: scs1, scs2)
               | EQUAL => genDiff (scs1, scs2)
            )
           | genDiff (scs1, _) = scs1
      in
         genDiff (scs1, scs2)
      end

   fun merge (scs1, scs2) =
      let
         val scs1 = diff (scs1,scs2)
         fun m ([], scs) = scs
           | m (eq :: eqs, scs) = case add (eq, scs) of
                RESULT (_, scs) => m (eqs, scs)
              | _ => raise SizeConstraintBug
         val scs = m (scs1, scs2)
         (*val (sStr1, si) = toStringSI (scs1, NONE, TVar.emptyShowInfo)
         val (sStr2, si) = toStringSI (scs2, NONE, si)
         val (sStr3, si) = toStringSI (scs, NONE, si)
         val _ = TextIO.print ("merging " ^ sStr1 ^ " with " ^ sStr2 ^ 
                               " resulting in " ^ sStr3 ^ "\n")*)
      in
         scs
      end

   fun rename (v1,v2,scs) =
      let
         (*val (tVar1, si) = TVar.varToString (v1, TVar.emptyShowInfo)
         val (tVar2, si) = TVar.varToString (v2, si)
         val (sStr, si) = toStringSI (scs, NONE, si)
         val _ = TextIO.print ("renaming " ^ tVar1 ^ " to " ^ tVar2 ^ " in " ^ sStr ^ "\n")*)
         fun hasV1 {terms = ts,const} =
            List.exists (fn (_,v) => TVar.eq(v,v1)) ts
         val (withVar, retained) = List.partition hasV1 scs
         fun renameVar sc = case lookupVarSC (v1,sc) of f1 =>
               addTermToSC (f1,v2, addTermToSC (~f1,v1, sc))
         val renamed = List.map renameVar withVar
         val renamed = List.filter
               (fn {terms=ts,const} => not (List.null ts)) renamed
      in
         merge (renamed, retained)
      end
end