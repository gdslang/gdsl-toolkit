structure Path : sig
   
   type flowpoints

   type flowinfo = {
      flag : BooleanDomain.bvar,
      contraVariant : bool
   }

   val typeToFlowpoints : Types.texp -> flowpoints
   val varsOfFlowpoints : flowpoints -> TVar.tvar list
   val flagsOfFlowpoints : flowpoints -> flowinfo list
   
   (* rename the first variable to the second one *)
   val renameVariable : TVar.tvar * TVar.tvar * flowpoints -> flowpoints
   
   (*type path
   val emptyPath : path
   val appendIntPath : int -> path -> path
   val appendFieldPath : FieldInfo.symid -> path -> path
   val termFieldPath : FieldInfo.symid -> bool -> path -> flowpoints
   val termVarPath : TVar.tvar -> bool -> path -> flowpoints*)
   val toStringSI : (flowpoints * TVar.varmap) -> (string * TVar.varmap)

end = struct
   structure BD = BooleanDomain
   open Types
   
   datatype leaf
      = LeafField of FieldInfo.symid
      | LeafVar of TVar.tvar

   datatype step
      = StepIndex of int
      | StepField of FieldInfo.symid

   type steps = step list

   fun compareSteps ([],[]) = EQUAL
     | compareSteps (s1::ss1,[]) = GREATER
     | compareSteps ([],s2::ss2) = LESS
     | compareSteps (StepIndex i1::ss1,StepIndex i2::ss2) =
         (case Int.compare (i1,i2) of
            EQUAL => compareSteps (ss1,ss2)
          | res => res
         )
     | compareSteps (StepField f1::ss1,StepField f2::ss2) =
         (case SymbolTable.compare_symid (f1,f2) of
            EQUAL => compareSteps (ss1,ss2)
          | res => res
         )
     | compareSteps (StepIndex _::_,_) = LESS
     | compareSteps _ = GREATER

   fun compareLeaf (LeafField f1, LeafField f2) =
         SymbolTable.compare_symid (f1,f2)
     | compareLeaf (LeafVar v1, LeafVar v2) =
         TVar.compare (v1,v2)
     | compareLeaf (LeafVar _, LeafField _) = LESS
     | compareLeaf _ = GREATER
      
   type flowinfo = {
      flag : BD.bvar,
      contraVariant : bool
   }

   fun showFlowInfo vStr {flag = f, contraVariant = cV} =
      (if cV then "!" else "") ^ vStr ^ BD.showVar f

   fun showSteps p =
      let
         fun showStep (StepIndex i) = Int.toString i ^ "-"
           | showStep (StepField f) =
            SymbolTable.getString (!SymbolTables.fieldTable,f) ^ "-"
      in
         String.concat (List.map showStep p)
      end
   
   structure TVarMap = RedBlackMapFn(struct
      type ord_key = TVar.tvar
      val compare = TVar.compare
   end)           

   structure StepsMap = RedBlackMapFn(struct
      type ord_key = steps
      val compare = compareSteps
   end)           

   type flowpoints = (flowinfo StepsMap.map TVarMap.map * flowinfo StepsMap.map SymMap.map)

   fun toStringSI ((varMap, symMap) : flowpoints,si) =
      let
         fun showPaths vStr pm = StepsMap.foldli (fn (p,fi,pStr) =>
            pStr ^ showSteps p ^ showFlowInfo vStr fi ^ ";") "" pm
         fun showVarMapping (v,pm,(str,si)) =
            let
               val (varStr, si) = TVar.varToString (v,si)
            in
               (str ^ "\n  " ^ showPaths varStr pm, si)
            end
         val (vStr,si) = TVarMap.foldli showVarMapping ("",si) varMap
         fun showSymMapping (f,pm,str) =
            let
               val varStr = SymbolTable.getString (!SymbolTables.fieldTable,f)
            in
               str ^ "\n  " ^ showPaths varStr pm
            end
         val fStr = SymMap.foldli showSymMapping "" symMap
      in
         (vStr ^ fStr,si)
      end

   fun typeToFlowpoints ty =
      let
         fun contra (steps,leaf,flag,cv) = (steps,leaf,flag,not cv)
         fun addI (idx,paths) =
            List.map (fn (steps,leaf,flag,cv) => (StepIndex idx :: steps,leaf,flag,cv)) paths
         fun addIs (c,t::ts) = addI (c,t) @ addIs (c+1,ts)
           | addIs (c,[]) = []
           
         fun paths (FUN (ts, t)) = addI (0,paths t) @ 
                                   List.map contra (addIs (1, List.map paths ts))
           | paths (SYN (syn, t)) = paths t
           | paths (ZENO) = []
           | paths (FLOAT) = []
           | paths (STRING) = []
           | paths (UNIT) = []
           | paths (VEC t) = paths t
           | paths (CONST c) = []
           | paths (ALG (sym, l)) = addIs (0, List.map paths l)
           | paths (RECORD (v,f,fs)) = ([],LeafVar v,f,false) :: List.concat (List.map pathsF fs)
           | paths (MONAD (r,a,b)) = addI (0,paths r) @ addI (1,paths a) @ addI (2, paths b)
           | paths (VAR (v,f)) = [([],LeafVar v,f,false)]
          and pathsF (RField {name = n, fty = t, exists = b}) = ([],LeafField n,b,false) ::
            List.map (fn (steps,leaf,flag,cv) => (StepField n :: steps,leaf,flag,cv)) (paths t)
         
         fun insert ((path, LeafVar v, flag, cv),(varMap, fieldMap)) =
            let
               val flowinfo = { flag = flag, contraVariant = cv }
               val pathMap = case TVarMap.find (varMap, v) of
                     SOME pm => pm
                   | NONE => StepsMap.empty
               val pathMap = StepsMap.insert (pathMap, path, flowinfo)
            in
               (TVarMap.insert (varMap, v, pathMap), fieldMap)
            end
           | insert ((path, LeafField f, flag, cv),(varMap, fieldMap)) =
            let
               val flowinfo = { flag = flag, contraVariant = cv }
               val pathMap = case SymMap.find (fieldMap, f) of
                     SOME pm => pm
                   | NONE => StepsMap.empty
               val pathMap = StepsMap.insert (pathMap, path, flowinfo)
            in
               (varMap, SymMap.insert (fieldMap, f, pathMap))
            end
      in
         List.foldl insert (TVarMap.empty, SymMap.empty) (paths ty)
      end

   fun varsOfFlowpoints (vm,_) = TVarMap.listKeys vm
   
   fun flagsOfFlowpoints (vm,fm) =
      let
         val pms = TVarMap.listItems vm @ SymMap.listItems fm
      in
         List.concat (List.map StepsMap.listItems pms)
      end

   fun renameVariable (v1,v2,(vm,fm)) =
      let
         val (vm,prev) = TVarMap.remove (vm,v1)
         val vmNew = TVarMap.singleton (v2,prev)
         fun doublePath (p1,p2) = p1
         val vm = TVarMap.unionWith (StepsMap.unionWith doublePath) (vm, vmNew)
      in
         (vm,fm)
      end
         
end


structure TypeTable : sig

   type table
   

   (*a type variable was not found in the type table*)
   exception IndexError

   val emptyTable : table

   val toStringSI : (SymbolTable.symid -> bool) * table * TVar.varmap -> string * TVar.varmap
   val showTableSI : table * TVar.tvar list * TVar.varmap * TVar.set -> string * TVar.varmap * TVar.set
   
   val newType : Types.texp * table -> TVar.tvar

   val addSymbol : SymbolTable.symid * Types.texp * table -> TVar.tvar
   val delSymbol : SymbolTable.symid * table -> (TVar.set * BooleanDomain.bvarset)
   
   val addPair : ((TVar.tvar * TVar.tvar) * TVar.set list) -> TVar.set list
   val getPair : TVar.set list -> (TVar.tvar * TVar.tvar * TVar.set list) option
   val aVar : TVar.tvar
   val bVar : TVar.tvar
   val cVar : TVar.tvar
   val dVar : TVar.tvar
   val eVar : TVar.tvar
   val fVar : TVar.tvar

   val test1 : unit -> unit
   val test2 : unit -> unit

end = struct

   type index = TVar.tvar

   structure HT = HashTable
   structure DA = DynamicArray
   structure S = Substitutions

   open Types
   
   datatype typeterm
      (* a function taking at least one argument *)
    = TT_FUN of (index list * index)
      (* a type synoym with its expanded type *)
    | TT_SYN of (TypeInfo.symid * index)
      (* an whole number *)
    | TT_ZENO
      (* a floating point number *)
    | TT_FLOAT
      (* a character sequence *)
    | TT_STRING
      (* a value containing no information *)
    | TT_UNIT
      (* a bit vector of a fixed size *)
    | TT_VEC of index
      (* a Herbrand constant, can only occur as the argument of VEC *)
    | TT_CONST of int
      (* an algebraic data type with a list of type arguments *)
    | TT_ALG of (TypeInfo.symid * index list)
      (* a record *)
    | TT_RECORD of (index * (FieldInfo.symid * index) list)
      (* the state monad: return value, input state, output state *)
    | TT_MONAD of index * index * index
 
   fun sym_hash s = Word.fromInt (SymbolTable.toInt s)

   fun hash_list [] = Word.fromInt 0
     | hash_list (x :: xs) = Word.fromInt 7*x + Word.fromInt 3*hash_list xs
     
   fun typeterm_hash (TT_FUN (is,i)) = hash_list (Word.fromInt 4234::TVar.hash i::map TVar.hash is)
     | typeterm_hash (TT_SYN (s,i)) = hash_list [sym_hash s,TVar.hash i]
     | typeterm_hash (TT_ZENO) = Word.fromInt 29834
     | typeterm_hash (TT_FLOAT) = Word.fromInt 9845
     | typeterm_hash (TT_STRING) = Word.fromInt 394208
     | typeterm_hash (TT_UNIT) = Word.fromInt 9823
     | typeterm_hash (TT_VEC v) = hash_list [Word.fromInt 98028,TVar.hash v]
     | typeterm_hash (TT_CONST i) = Word.fromInt 9823*Word.fromInt i+Word.fromInt 2834
     | typeterm_hash (TT_ALG (s,is)) = hash_list (sym_hash s :: map TVar.hash is)
     | typeterm_hash (TT_RECORD (i,fs)) = Word.fromInt 78342+
      hash_list (TVar.hash i::map (sym_hash o #1) fs @ map (TVar.hash o #2) fs)
     | typeterm_hash (TT_MONAD (i1,i2,i3)) = Word.fromInt 5345+hash_list [TVar.hash i1,TVar.hash i2, TVar.hash i3]

   fun typeterm_eq (TT_FUN (is1,i1),TT_FUN (is2,i2)) =
      ListPair.allEq TVar.eq (is1,is2) andalso TVar.eq (i1,i2)
     | typeterm_eq (TT_SYN (s1,i1),TT_SYN (s2,i2)) =
      SymbolTable.eq_symid (s1,s2) andalso TVar.eq (i1,i2)
     | typeterm_eq (TT_ZENO, TT_ZENO) = true
     | typeterm_eq (TT_FLOAT, TT_FLOAT) = true
     | typeterm_eq (TT_STRING, TT_STRING) = true
     | typeterm_eq (TT_UNIT, TT_UNIT) = true
     | typeterm_eq (TT_VEC i1, TT_VEC i2) = TVar.eq (i1,i2)
     | typeterm_eq (TT_CONST c1,TT_CONST c2) = c1=c2
     | typeterm_eq (TT_ALG (s1,is1), TT_ALG (s2,is2)) =
      SymbolTable.eq_symid (s1,s2) andalso ListPair.allEq TVar.eq (is1,is2)
     | typeterm_eq (TT_RECORD (i1,fs1), TT_RECORD (i2,fs2)) =
      TVar.eq (i1,i2) andalso
      ListPair.allEq (fn ((f1,i1),(f2,i2)) =>
         SymbolTable.eq_symid (f1,f2) andalso TVar.eq (i1,i2)
      ) (fs1,fs2)
     | typeterm_eq (TT_MONAD (i1,i2,i3),TT_MONAD (j1,j2,j3)) =
      TVar.eq (i1,j1) andalso TVar.eq (i2,j2) andalso TVar.eq (i3,j3)
     | typeterm_eq _ = false

   fun showTypeTermSI (ty, showInfo) = let
      val siTab = ref showInfo
      fun sep s [] = ""
        | sep s [v] = v
        | sep s (v :: vs) = v ^ s ^ sep s vs
      fun sT (TT_FUN ([f1], f2)) =
            showVar f1 ^ " -> " ^ showVar f2
        | sT (TT_FUN (fs1, f2)) =
            "(" ^ sep ", " (List.map showVar fs1) ^ ") -> " ^ showVar f2
        | sT (TT_SYN (syn, t)) = 
            SymbolTable.getString(!SymbolTables.typeTable, syn) ^ " => " ^ showVar t
        | sT (TT_ZENO) = "int"
        | sT (TT_FLOAT) = "float"
        | sT (TT_STRING) = "string"
        | sT (TT_UNIT) = "()"
        | sT (TT_VEC t) = "|" ^ showVar t ^ "|"
        | sT (TT_CONST c) = Int.toString(c)
        | sT (TT_ALG (ty, l)) =
         let
            val conStr = SymbolTable.getString(!SymbolTables.typeTable, ty)
         in
            conStr ^ 
            (if List.null l then "" else ("[" ^ sep "," (List.map showVar l) ^ "]"))
         end
        | sT (TT_RECORD (v,fs)) =
           "{" ^ sep ", " (List.map sTF fs @ [showVar v])  ^ "}"
        | sT (TT_MONAD (r,f,t)) = "S " ^ showVar r ^
           " <" ^ showVar f ^ " => " ^ showVar t ^ ">"
       and showVar var =
         let 
            val (str, newSiTab) = TVar.varToString (var, !siTab)
         in
            (siTab := newSiTab; str)
         end
      and sTF (fid, fty) =
            SymbolTable.getString(!SymbolTables.fieldTable, fid) ^
            ": " ^ showVar fty
   in
      (sT ty, !siTab) 
   end

    fun getVars (TT_FUN (fs1, f2)) = f2::fs1
      | getVars (TT_SYN (syn, t)) = [t]
      | getVars (TT_ZENO) = []
      | getVars (TT_FLOAT) = []
      | getVars (TT_STRING) = []
      | getVars (TT_UNIT) = []
      | getVars (TT_VEC t) = [t]
      | getVars (TT_CONST c) = []
      | getVars (TT_ALG (ty, l)) = l
      | getVars (TT_RECORD (v,fs)) = v :: List.map #2 fs
      | getVars (TT_MONAD (r,f,t)) = [r,f,t]

   datatype typeinfo
      = TERM of typeterm
      | LEAF of SymSet.set
      | FORW of index

   type entry = {
      flow : Path.flowpoints,
      info : index
   }
      
   type table = {
      hashCons : (typeterm, index) HT.hash_table,
      symTable : (SymbolTable.symid,entry) HT.hash_table,
      typeTable : typeinfo DA.array
   }

   exception CondensingError
   exception IndexError
   exception TypeTableError

   val emptyTable = {
      hashCons = HT.mkTable (typeterm_hash,typeterm_eq) (10000, CondensingError),
      symTable = HT.mkTable (sym_hash,SymbolTable.eq_symid) (100, IndexError),
      typeTable = DA.array (100000, LEAF SymSet.empty)
   } : table

   fun showTableSI (table : table, todo, si, done) =
      let
         val tt = #typeTable table
         fun printFixpoint (str, [], si, done) = (str,si,done)
           | printFixpoint (str, var::vars, si, done) =
            if TVar.member (done,var)
            then
              printFixpoint (str, vars, si, done)
            else
              (TextIO.print ("looking up var " ^ (#1 (TVar.varToString (var,TVar.emptyShowInfo))) ^ "\n"); case DA.sub (tt, TVar.toIdx var) of
                 TERM t =>
                 let
                    val (vStr,si) = TVar.varToString (var,si)
                    val (tStr,si) = showTypeTermSI (t,si)
                    val str = str ^ "\n" ^ vStr ^ " = " ^ tStr
                    val done = TVar.add (var,done)
                    val vars = getVars t @ vars
                 in
                    printFixpoint (str, vars, si, done)
                 end
               | LEAF refs =>
                  let
                     val (vStr,si) = TVar.varToString (var,si)
                     fun showSym (sym,(sep,str)) = (",", str ^ sep ^
                         SymbolTable.getString(!SymbolTables.varTable, sym))
                     val (_,rStr) = SymSet.foldl showSym ("","") refs
                     val str = str ^ "\n" ^ vStr ^ " used in " ^ rStr
                    val done = TVar.add (var,done)
                  in
                    printFixpoint (str, vars, si, done)
                  end
              ) handle IndexError => raise IndexError
      in
         printFixpoint ("", todo, si, done)
      end
      
   fun toStringSI (selector,table : table,si) =
      let
         val st = #symTable table
         fun showSym (sym,{flow=fp,info=i},(str,tVars,si)) =
            if selector sym then
               let
                  val symStr = SymbolTable.getString(!SymbolTables.varTable, sym)
                  val (varStr,si) = TVar.varToString (i,si)
                  val (pStr,si) = Path.toStringSI (fp,si)
                  val (tabStr,si,tVars) =
                     showTableSI (table, i :: Path.varsOfFlowpoints fp, si, tVars)
               in
                  (str ^ "\n" ^ symStr ^ ": " ^ varStr ^ pStr ^ tabStr,tVars,si)
               end
            else (str,tVars,si)
         val (sStr, tVars, si) = HT.foldi showSym ("",TVar.empty,si) st
      in
         (sStr, si)
      end

   fun find tt v =
      let
         fun resolve (v,v') = case DA.sub (tt,TVar.toIdx v') of
            FORW v'' => (DA.update (tt,TVar.toIdx v,FORW v''); resolve (v',v''))
          | _ => v'
      in
         case DA.sub (tt,TVar.toIdx v) of
            FORW v' => resolve (v,v')
          | _ => v
      end
   
   fun findIdx (tt,v) = TVar.toIdx (find tt v)
   
   fun ttGet (tt,v) = DA.sub (tt,findIdx (tt, v))
   fun ttSet (tt,v,ty) = DA.update (tt,findIdx (tt, v),ty)
   fun ttGetVars tt =
      let
         fun getVar (idx,FORW _,set) = set
           | getVar (idx,LEAF ss,set) = if SymSet.isEmpty ss then set else
               TVar.fromIdx idx :: set
           | getVar (idx,_,set) = TVar.fromIdx idx :: set
      in
         DA.foldri getVar [] tt
      end

   fun newType (ty,table : table) =
      let
         val hc = #hashCons table
         val tt = #typeTable table
         fun allocType t = case HT.find hc t of
            SOME idx => idx
          | NONE =>
            let
               val idx = TVar.freshTVar ()
               val _ = HT.insert hc (t, idx)
               val _ = DA.update (tt, TVar.toIdx idx, TERM t)
            in
               idx
            end
         fun conv (FUN (ts, t)) = allocType (TT_FUN (List.map conv ts, conv t))
           | conv (SYN (syn, t)) = allocType (TT_SYN (syn, conv t))
           | conv (ZENO) = allocType TT_ZENO
           | conv (FLOAT) = allocType TT_FLOAT
           | conv (STRING) = allocType TT_STRING
           | conv (UNIT) = allocType TT_UNIT
           | conv (VEC t) = allocType (TT_VEC (conv t))
           | conv (CONST c) = allocType (TT_CONST c)
           | conv (ALG (sym, l)) = allocType (TT_ALG (sym, List.map conv l))
           | conv (RECORD (v,_,l)) = allocType (TT_RECORD (v,List.map convF l))
           | conv (MONAD (r,f,t)) = allocType (TT_MONAD (conv r, conv f, conv t))
           | conv (VAR (v,_)) = (case ttGet (tt, v) of
                 (LEAF _) => v
               | _ => raise IndexError
             )
          and convF (RField {name = n, fty = t, exists = b}) = (n,conv t)
      in
         conv ty
      end

   fun addSymbol (sym,ty,table) =
      let
         val idx = newType (ty,table)
         val fp = Path.typeToFlowpoints ty
         val st = #symTable (table : table)
         fun addRef (LEAF syms) = LEAF (SymSet.add (syms,sym))
           | addRef _ = raise IndexError
         val tt = #typeTable table
         fun updateRef idx = ttSet (tt, idx, addRef (ttGet (tt, idx)))
         val _ = List.app updateRef (Path.varsOfFlowpoints fp)
         val _ = HT.insert st (sym,{ flow = fp, info = idx })
      in
        idx
      end

   fun delSymbol (sym,table) =
      let
         val st = #symTable (table : table)
         val { flow = fp, info = idx } = HT.remove st sym
         fun delRef (LEAF syms) = LEAF (SymSet.delete (syms,sym))
           | delRef _ = raise IndexError
         val tt = #typeTable table
         fun updateRef v = ttSet (tt, idx, delRef (ttGet (tt, idx)))
         val tVars = Path.varsOfFlowpoints fp
         val _ = List.app updateRef tVars
         fun addVar (idx,set) = TVar.add (find tt idx,set)
         val tVarSet = List.foldl addVar TVar.empty tVars
         val bVarSet = List.foldl BD.addToSet BD.emptySet
            (List.map #flag (Path.flagsOfFlowpoints fp))
      in
         (tVarSet,bVarSet)
      end

    (* pending unification constraints are represented as a set of
       variable set where each variable set contains variables that
       are to be made equal; no two sets of variables overlap *)
   type u_pairs = TVar.set list

   fun addPair ((v1,v2), pairs : u_pairs) =
      let
         fun getSet (v,pairs) =
            let
               val (vYes,vNo) = List.partition (fn set => TVar.member (set,v)) pairs
               val vYes = if List.null vYes then [TVar.singleton v] else vYes
            in
               (List.foldl TVar.union TVar.empty vYes, vNo)
            end
         val (withV1,pairs) = getSet (v1,pairs)
         val (withV2,pairs) = getSet (v2,pairs)
      in
         TVar.union (withV1, withV2) :: pairs
      end
   
   (* return a pair (v1,v2) that should be unified, v1 is to be removed
      from the system *)
   fun getPair ([] : u_pairs) = NONE
     | getPair (s :: ss) = (case TVar.listItems s of
        (v2 :: v1 :: []) => SOME (v1,v2, ss)
      | (v2 :: v1 :: vs) => SOME (v1,v2, TVar.del (v1,s) :: ss)
      | _ => getPair ss
     )
   
   fun unify (v1,v2, table : table) =
      let
         val tt = #typeTable table
         val st = #symTable table
         fun fixpoint pairs = case getPair pairs of
            NONE => ()
          | SOME (v1,v2,pairs) =>
            let
               val (v1Str,si) = TVar.varToString (v1,TVar.emptyShowInfo)
               val (v2Str,si) = TVar.varToString (v2,si)
               val _ = TextIO.print ("unifying " ^ v1Str ^ " with " ^ v2Str ^ ", removing the former\n")
               val newPairs = unify (v1,v2)
               val pairs = foldl addPair pairs newPairs
            in
               fixpoint pairs
            end
         and unify (v1,v2) = unifyTT (ttGet (tt,v1), ttGet (tt,v2))
         and unifyTT (LEAF symSet1, LEAF symSet2) =
               let
                  val symSet12 = SymSet.union (symSet1,symSet2)
                  val (vGood,sGood,vBad,sBad) =
                     if TVar.toIdx v1<TVar.toIdx v2 then
                        (v1,symSet1,v2,symSet2) else (v2,symSet2,v1,symSet1)
                  val _ = ttSet (tt,vBad, FORW vGood)
                  val _ = ttSet (tt,vGood, LEAF symSet12)
                  fun update sym =
                     let
                        val { flow = fp, info = idx } = HT.lookup st sym
                        val fp = Path.renameVariable (vBad,vGood,fp)
                        val idx = if TVar.eq (idx,v1) then v2 else idx
                        val _ = HT.insert st (sym, {flow = fp, info = idx})
                     in
                        ()
                     end
                  val _ = List.app update (SymSet.listItems sBad)
               in
                  []
               end
           | unifyTT (TERM t1, TERM t2) = genPairs (t1,t2)
           | unifyTT (LEAF symSet, TERM t) = substVar (v1,symSet,v2,t)
           | unifyTT (TERM t, LEAF symSet) = substVar (v2,symSet,v1,t)
           | unifyTT _ = raise TypeTableError
      and genPairs (TT_FUN (f1, f2), TT_FUN (g1, g2)) = if List.length f1<>List.length g1
         then raise S.UnificationFailure (S.Clash, 
               "function with different number of arguments (" ^
               Int.toString (List.length f1) ^ " and " ^
               Int.toString (List.length g1) ^ ")"
            )
         else (f2,g2)::ListPair.zip (f1,g1)
        | genPairs (TT_SYN (_,t1),t2) = unifyTT (ttGet (tt,t1), TERM t2)
        | genPairs (t1,TT_SYN (_,t2)) = unifyTT (TERM t1, ttGet (tt, t2))
        | genPairs (TT_ZENO, TT_ZENO) = []
        | genPairs (TT_FLOAT, TT_FLOAT) = []
        | genPairs (TT_STRING, TT_STRING) = []
        | genPairs (TT_UNIT, TT_UNIT) = []
        | genPairs (TT_VEC t1, TT_VEC t2) = [(t1, t2)]
        | genPairs (TT_CONST c1, TT_CONST c2) =
           if c1=c2 then [] else raise S.UnificationFailure (S.Clash,
            "incompatible bit vectors sizes (" ^ Int.toString c1 ^ " and " ^
            Int.toString c2 ^ ")")
        | genPairs (TT_RECORD (v1,l1), TT_RECORD (v2,l2)) =
         let
         (*   fun applySubsts (v, b, fs) = (case findSubstForVar (v) of
                 NONE => (v,b,fs)
               | SOME (WITH_FIELD (fs',v',b')) => (v', b', List.foldl insertField fs fs')
               | _ => raise SubstitutionBug
            )
            val (v1,b1,l1) = applySubsts (v1,b1,l1)
            val (v2,b2,l2) = applySubsts (v2,b2,l2)

            fun unify (v1, v2, [], []) =
               addSubst (v2, WITH_FIELD ([], v1, b1)) s
              | unify (v1, v2, (f1 as RField e1) :: fs1,
                       (f2 as RField e2) :: fs2) =
               (case compare_rfield (f1,f2) of
                  EQUAL =>
                  let
                     val s = genPairs (#fty e1, #fty e2)
                   in
                     unify (v1, v2, fs1, fs2)
                  end
                | LESS =>
                  let
                     val newVar = freshTVar ()
                     val newBVar = BD.freshBVar ()
                     val (f1,ei) = applySubstsToRField s (f1,emptyExpandInfo)
                     val s = addSubst (v2, WITH_FIELD ([f1], newVar, newBVar)) s
                  in
                     unify (v1, newVar, fs1, f2 :: fs2)
                  end
                | GREATER =>
                  let
                     val newVar = freshTVar ()
                     val newBVar = BD.freshBVar ()
                     val (f2,ei) = applySubstsToRField s (f2,emptyExpandInfo)
                     val s = addSubst (v1, WITH_FIELD ([f2], newVar, newBVar)) s
                  in
                     unify (newVar, v2, f1 :: fs1, fs2)
                  end
               )
              | unify (v1, v2, f1 :: fs1, []) =
               let
                  val newVar = freshTVar ()
                  val newBVar = BD.freshBVar ()
                  val (f1,ei) = applySubstsToRField s (f1,emptyExpandInfo)
                  val s = addSubst (v2, WITH_FIELD ([f1], newVar, newBVar)) s
               in
                  unify (v1, newVar, fs1, [])
               end
              | unify (v1, v2, [], f2 :: fs2) =
               let
                  val newVar = freshTVar ()
                  val newBVar = BD.freshBVar ()
                  val (f2,ei) = applySubstsToRField s (f2,emptyExpandInfo)
                  val s = addSubst (v1, WITH_FIELD ([f2], newVar, newBVar)) s
               in
                  unify (newVar, v2, [], fs2)
               end*)
         in
            [] (*unify (v1,v2,l1,l2,s)*)
         end
        | genPairs (TT_MONAD (r1,f1,t1), TT_MONAD (r2,f2,t2)) =
            [(r1, r2), (f1, f2), (t1, t2)]
        | genPairs (TT_ALG (ty1, l1), TT_ALG (ty2, l2)) =
         let 
            fun incompat () = raise S.UnificationFailure (S.Clash,
               "cannot match constructor " ^
               SymbolTable.getString(!SymbolTables.typeTable, ty1) ^
               " with " ^
               SymbolTable.getString(!SymbolTables.typeTable, ty2))
         in case SymbolTable.compare_symid (ty1, ty2) of
           LESS => incompat ()
         | GREATER => incompat ()
         | EQAL => ListPair.zipEq (l1,l2)
         end
        | genPairs (t1,t2) =
         let fun descr (TT_FUN _) = "a function type"
               | descr (TT_ZENO) = "int"
               | descr (TT_FLOAT) = "float"
               | descr (TT_STRING) = "string"
               | descr (TT_UNIT) = "()"
               | descr (TT_VEC t) = (case ttGet (tt,t) of
                  TERM (TT_CONST c) => "a vector of " ^ Int.toString c ^ " bits"
                | _ => "a bit vector"
               )
               | descr (TT_ALG (ty, _)) = "type " ^
                  SymbolTable.getString(!SymbolTables.typeTable, ty)
               | descr (TT_RECORD (_,fs)) = "a record {" ^
                  List.foldl (fn ((n,_),str) =>
                     SymbolTable.getString(!SymbolTables.fieldTable, n) ^
                     ", " ^ str) "..." fs ^ "}"
               | descr (TT_MONAD _) = "an action"
               | descr _ = "something that shouldn't be here"
         in
            raise S.UnificationFailure (S.Clash, "cannot match " ^ descr t1 ^
                                        " against " ^ descr t2)
         end
      and substVar (vVar,symSet,vType,t) = 
         let
            val _ = ttSet (tt,vVar, FORW vType)
         in
            []
         end

   in
      fixpoint (addPair ((v1,v2),[]))
   end
         
      
      
   val aVar = TVar.freshTVar ()      
   val bVar = TVar.freshTVar ()      
   val cVar = TVar.freshTVar ()      
   val dVar = TVar.freshTVar ()      
   val eVar = TVar.freshTVar ()      
   val fVar = TVar.freshTVar ()      

   fun test1 _ =
      let
         val table = emptyTable
         val idx = newType (Types.VEC (Types.VAR (TVar.freshTVar (), BooleanDomain.freshBVar ())), table)
         val (str,si,varset) = showTableSI (table, [idx], TVar.emptyShowInfo, TVar.empty);
      in
         TextIO.print (str ^ "\n")
      end

   fun test2 _ =
      let
         val table = emptyTable
         val st = !SymbolTables.varTable
         val st = SymbolTable.push st
         val (st,xVar) = SymbolTable.fresh (st, Atom.atom "x")
         val (st,yVar) = SymbolTable.fresh (st, Atom.atom "y")
         val (st,zVar) = SymbolTable.fresh (st, Atom.atom "z")
         val _ = SymbolTables.varTable := st
         fun newVar () = VAR (TVar.freshTVar (), BD.freshBVar ())
         val t = newVar ()
         val s = newVar ()
         fun getTVar (VAR (tv,bv)) = tv
         val idxX = addSymbol (xVar,FUN ([ZENO,t],VEC (newVar ())),table)
         val idxY = addSymbol (yVar,FUN ([s,t],t),table)
         val idxZ = addSymbol (zVar,FUN ([t,newVar ()],s),table)
         val idx = newType (Types.VEC (Types.VAR (TVar.freshTVar (), BooleanDomain.freshBVar ())), table)
         (*val _ = delSymbol (yVar,table)*)

         val (str,si) = toStringSI (fn _ => true, table, TVar.emptyShowInfo);
         val _ = SymbolTables.varTable := SymbolTable.pop (!SymbolTables.varTable)
         val (tStr,si,varset) = showTableSI (table, ttGetVars (#typeTable table), si, TVar.empty);
         val _ = TextIO.print (str ^ "\ntype table:\n" ^ tStr)

         val _ = unify (getTVar s,getTVar t,table)
         val (tStr,si,varset) = showTableSI (table, ttGetVars (#typeTable table), si, TVar.empty);
         val _ = TextIO.print ("again:\n" ^ tStr)
      in
         ()
      end
end
