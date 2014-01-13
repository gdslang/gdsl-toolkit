structure Path : sig
   
   type flowpoints

   val typeToFlowpoints : Types.texp -> flowpoints
   val varsOfFlowpoints : flowpoints -> TVar.tvar list
   val flagsOfFlowpoints : flowpoints -> BooleanDomain.bvarset
   
   (* rename the first variable to the second one *)
   val renameVariable : TVar.tvar * TVar.tvar * flowpoints -> flowpoints
             
   type leaf
   val mkVarLeaf : TVar.tvar -> leaf
   val mkFieldLeaf : FieldInfo.symid -> leaf
   val getVarLeaf : leaf -> TVar.tvar option
   
   type steps
   val emptySteps : steps
   val prependIntStep : int -> (steps * leaf) -> (steps * leaf)
   val prependFieldStep : FieldInfo.symid -> (steps * leaf) -> (steps * leaf)
   (* Determine if the new steps descend to a contravariant position *)
   val stepsContra : steps -> bool
   
   (* Replace the given type variable by the set of steps and new leaves. *)
   val insertSteps : flowpoints * TVar.tvar * (steps * leaf) list ->
         flowpoints * (BooleanDomain.bvar * BooleanDomain.bvar list) list

   val toStringSI : (flowpoints * TVar.varmap) -> (string * TVar.varmap)

end = struct
   structure BD = BooleanDomain
   open Types
   
   datatype leaf
      = LeafField of FieldInfo.symid
      | LeafVar of TVar.tvar

   val mkVarLeaf = LeafVar
   val mkFieldLeaf = LeafField
   fun getVarLeaf (LeafVar v) = SOME v
     | getVarLeaf _ = NONE

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

   type flowpoints = (BD.bvar StepsMap.map TVarMap.map * BD.bvar StepsMap.map SymMap.map)

   fun toStringSI ((varMap, symMap) : flowpoints,si) =
      let
         fun showPaths vStr pm = StepsMap.foldli (fn (p,fi,pStr) =>
            pStr ^ showSteps p ^ vStr ^ BD.showVar fi ^ ";") "" pm
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
         fun addI (idx,paths) =
            List.map (fn (steps,leaf,flag) => (StepIndex idx :: steps,leaf,flag)) paths
         fun addIs (c,t::ts) = addI (c,t) @ addIs (c-1,ts)
           | addIs (c,[]) = []
           
         fun paths (FUN (ts, t)) = addIs (0,List.map paths (t :: ts))
           | paths (SYN (syn, t)) = paths t
           | paths (ZENO) = []
           | paths (FLOAT) = []
           | paths (STRING) = []
           | paths (UNIT) = []
           | paths (VEC t) = paths t
           | paths (CONST c) = []
           | paths (ALG (sym, l)) = addIs (List.length l, List.map paths l)
           | paths (RECORD (v,f,fs)) =
               ([],LeafVar v,f) :: List.concat (List.map pathsF fs)
           | paths (MONAD (r,a,b)) = addI (0,paths r) @ addI (~1,paths a) @ addI (1, paths b)
           | paths (VAR (v,f)) = [([],LeafVar v,f)]
          and pathsF (RField {name = n, fty = t, exists = b}) = ([],LeafField n,b) ::
            List.map (fn (steps,leaf,flag) => (StepField n :: steps,leaf,flag)) (paths t)
         
         fun insert ((path, LeafVar v, flag),(varMap, fieldMap)) =
            let
               val pathMap = case TVarMap.find (varMap, v) of
                     SOME pm => pm
                   | NONE => StepsMap.empty
               val pathMap = StepsMap.insert (pathMap, path, flag)
            in
               (TVarMap.insert (varMap, v, pathMap), fieldMap)
            end
           | insert ((path, LeafField f, flag),(varMap, fieldMap)) =
            let
               val pathMap = case SymMap.find (fieldMap, f) of
                     SOME pm => pm
                   | NONE => StepsMap.empty
               val pathMap = StepsMap.insert (pathMap, path, flag)
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
         List.foldl BD.addToSet BD.emptySet (
            List.concat (List.map StepsMap.listItems pms)
         )
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

   val emptySteps = []
   fun prependIntStep idx (steps, leaf) = (StepIndex idx :: steps, leaf)
   fun prependFieldStep sym (steps, leaf) = (StepField sym :: steps, leaf)
   fun stepsContra [] = false
     | stepsContra (StepIndex idx :: steps) =
         if idx<0 then not (stepsContra steps) else stepsContra steps
     | stepsContra (StepField _ :: steps) = stepsContra steps

   fun insertSteps ((tVarMap,fieldMap), oldVar, stepsLeafList) =
      if not (TVarMap.inDomain (tVarMap,oldVar)) then ((tVarMap,fieldMap), []) else
      let
         val expandInfo = ref []
         fun addSteps ((oldSteps,bVar),fp) =
            let
               val newStepsLeafList = List.map (fn (steps, leaf) =>
                     ((oldSteps @ steps, leaf), BD.freshBVar ())) stepsLeafList
               val bVars = List.map #2 newStepsLeafList
               val _ = expandInfo := (bVar, bVars) :: !expandInfo

               fun insertSteps (((steps,LeafVar tVar),bVar), (tVarMap,fieldMap)) =
                     (TVarMap.insert (tVarMap,tVar, case TVarMap.find (tVarMap,tVar) of
                        NONE => StepsMap.singleton (steps, bVar)
                      | SOME sm => StepsMap.insert (sm, steps, bVar)),
                      fieldMap
                     )
                 | insertSteps (((steps,LeafField sym),bVar), (tVarMap,fieldMap)) =
                     (tVarMap,
                      SymMap.insert (fieldMap,sym, case SymMap.find (fieldMap, sym) of
                        NONE => StepsMap.singleton (steps, bVar)
                      | SOME sm => StepsMap.insert (sm, steps, bVar))
                     )
            in
               List.foldl insertSteps fp newStepsLeafList
            end

         val (tVarMap,sm) = TVarMap.remove (tVarMap,oldVar)
         val stepsBVar = StepsMap.listItemsi sm
      in
         (List.foldl addSteps (tVarMap,fieldMap) stepsBVar, !expandInfo)     
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
   structure BD = BooleanDomain
   structure SC = SizeConstraint

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
      (* a record, the variable points to a set of fields *)
    | TT_RECORD of index
      (* a record field *)
    | TT_FIELD of (FieldInfo.symid * index * index)
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
     | typeterm_hash (TT_RECORD i) = Word.fromInt 78342+TVar.hash i
     | typeterm_hash (TT_FIELD (f,i1,i2)) = sym_hash f + TVar.hash i1 + TVar.hash i2
     | typeterm_hash (TT_MONAD (i1,i2,i3)) = Word.fromInt 5345+hash_list [TVar.hash i1,TVar.hash i2, TVar.hash i3]

   (* structural equality, records with the same set of fields are different
   under this order *)
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
     | typeterm_eq (TT_RECORD i1, TT_RECORD i2) = TVar.eq (i1,i2)
     | typeterm_eq (TT_FIELD (f1,i1,j1), TT_FIELD (f2,i2,j2)) =
      SymbolTable.eq_symid (f1,f2) andalso TVar.eq (i1,i2) andalso TVar.eq (j1,j2)
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
        | sT (TT_RECORD i) = "{" ^ showVar i ^ "}"
        | sT (TT_FIELD (f,i,j)) = SymbolTable.getString(!SymbolTables.fieldTable, f) ^
           ": " ^ showVar i ^ ", " ^ showVar j  
        | sT (TT_MONAD (r,f,t)) = "S " ^ showVar r ^
           " <" ^ showVar f ^ " => " ^ showVar t ^ ">"
       and showVar var =
         let 
            val (str, newSiTab) = TVar.varToString (var, !siTab)
         in
            (siTab := newSiTab; str)
         end
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
      | getVars (TT_RECORD i) = [i]
      | getVars (TT_FIELD (f,i,j)) = [i,j]
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
      typeTable : typeinfo DA.array,
      boolDom : BD.bfun ref,
      sizeDom : SC.size_constraint_set ref
   }

   exception CondensingError
   exception IndexError
   exception TypeTableError

   val emptyTable = {
      hashCons = HT.mkTable (typeterm_hash,typeterm_eq) (10000, CondensingError),
      symTable = HT.mkTable (sym_hash,SymbolTable.eq_symid) (100, IndexError),
      typeTable = DA.array (100000, LEAF SymSet.empty),
      boolDom = ref BD.empty,
      sizeDom = ref SC.empty
   } : table

   fun dumpTableSI (table : table, si) =
      let
         val tt = (#typeTable table)
         val st = (#symTable table)
         val si = DA.foldli
            (fn (i,tt,si) =>
               if (case tt of LEAF refs => SymSet.isEmpty refs | _ => false)
               then si else #2 (TVar.varToString (TVar.fromIdx i,si))) si tt
         fun showSym (sym, { flow = fp, info = index },(str, si)) =
            let
               val symStr = SymbolTable.getString(!SymbolTables.varTable, sym)
               val (vStr,si) =  TVar.varToString (index,si)
               val (fpStr, si) = Path.toStringSI (fp, si)
               val out = "\nvar " ^ symStr ^ ": " ^ vStr ^ fpStr
            in
               (str ^ out, si)
            end
         val (symStr, si) = HT.foldi showSym ("",si) st
         fun showEntry (idx, TERM t, (str, si)) =
            let
               val (vStr,si) = TVar.varToString (TVar.fromIdx idx,si)
               val (tStr,si) = showTypeTermSI (t,si)
               val out = "\n" ^ vStr ^ " = " ^ tStr
            in
               (str ^ out, si)
            end
           | showEntry (idx, LEAF refs, (str, si)) =
            if SymSet.isEmpty refs then (str, si) else
            let
               val (vStr,si) = TVar.varToString (TVar.fromIdx idx,si)
               fun showSym (sym,(sep,str)) = (",", str ^ sep ^
                   SymbolTable.getString(!SymbolTables.varTable, sym))
               val (_,rStr) = SymSet.foldl showSym ("","") refs
               val out = "\n" ^ vStr ^ " used in " ^ rStr
            in
               (str ^ out, si)
            end
           | showEntry (idx, FORW index, (str, si)) =
            let
               val (vStr,si) = TVar.varToString (TVar.fromIdx idx,si)
               val (vStr',si) =  TVar.varToString (index,si)
               val out = "\n" ^ vStr ^ " => " ^ vStr'
            in
               (str ^ out , si)
            end
         val (tVarStr, si) = DA.foldli showEntry ("",si) tt
         val (tVarStr, si) = showEntry (DA.bound tt, DA.sub (tt, DA.bound tt),(tVarStr,si))
         val bdRef = #boolDom table
         val bdStr = BD.showBFun (!bdRef)
         val scRef = #sizeDom table
         val (scStr, si) = SC.toStringSI (!scRef, NONE, si)
         
      in
         (symStr ^ tVarStr ^ "\n" ^ bdStr ^ "\n" ^ scStr ^ "\n", si)
      end

   fun showTableSI (table : table, todo, si, done) =
      let
         val tt = #typeTable table
         fun printFixpoint (str, [], si, done) = (str,si,done)
           | printFixpoint (str, var::vars, si, done) =
            if TVar.member (done,var)
            then
              printFixpoint (str, vars, si, done)
            else
              (TextIO.print ("\nlooking up var " ^ (#1 (TVar.varToString (var,TVar.emptyShowInfo)))); case DA.sub (tt, TVar.toIdx var) of
                 TERM t =>
                 let
                    val (vStr,si) = TVar.varToString (var,si)
                    val (tStr,si) = showTypeTermSI (t,si)
                    val out = "\n" ^ vStr ^ " = " ^ tStr
                    val _ = TextIO.print out
                    val done = TVar.add (var,done)
                    val vars = getVars t @ vars
                 in
                    printFixpoint (str ^ out, vars, si, done)
                 end
               | LEAF refs =>
                  let
                     val (vStr,si) = TVar.varToString (var,si)
                     fun showSym (sym,(sep,str)) = (",", str ^ sep ^
                         SymbolTable.getString(!SymbolTables.varTable, sym))
                     val (_,rStr) = SymSet.foldl showSym ("","") refs
                     val out = "\n" ^ vStr ^ " used in " ^ rStr
                     val _ = TextIO.print out
                     val done = TVar.add (var,done)
                  in
                    printFixpoint (str ^ out, vars, si, done)
                  end
               | _ => raise IndexError
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

   fun allocType (t,table : table) =
      let
         val tt = #typeTable table
         val hc = #hashCons table
      in
         case HT.find hc t of
            SOME idx => idx
          | NONE =>
            let
               val idx = TVar.freshTVar ()
               val _ = HT.insert hc (t, idx)
               val _ = DA.update (tt, TVar.toIdx idx, TERM t)
            in
               idx
            end
      end

   fun newType (ty,table : table) =
      let
         val tt = #typeTable table
         val allocType = fn t => allocType (t,table)
         fun conv (FUN (ts, t)) = allocType (TT_FUN (List.map conv ts, conv t))
           | conv (SYN (syn, t)) = allocType (TT_SYN (syn, conv t))
           | conv (ZENO) = allocType TT_ZENO
           | conv (FLOAT) = allocType TT_FLOAT
           | conv (STRING) = allocType TT_STRING
           | conv (UNIT) = allocType TT_UNIT
           | conv (VEC t) = allocType (TT_VEC (conv t))
           | conv (CONST c) = allocType (TT_CONST c)
           | conv (ALG (sym, l)) = allocType (TT_ALG (sym, List.map conv l))
           | conv (RECORD (v,_,l)) = allocType (TT_RECORD (convF (v,l)))
           | conv (MONAD (r,f,t)) = allocType (TT_MONAD (conv r, conv f, conv t))
           | conv (VAR (v,_)) = (case ttGet (tt, v) of
                 (LEAF _) => v
               | _ => raise IndexError
             )
          and convF (v, RField {name = n, fty = t, exists = b} :: l) =
               allocType (TT_FIELD (n,conv t, convF (v,l)))
            | convF (v, []) = (case ttGet (tt, v) of
                 (LEAF _) => v
               | _ => raise IndexError
             )
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
         val { flow = fp, info } = HT.remove st sym
         val unusedTVars = ref TVar.empty
         fun delRef (v,LEAF syms) =
            let
               val newSet = SymSet.delete (syms,sym)
               val _ = if SymSet.isEmpty newSet then
                  unusedTVars := TVar.add (v,!unusedTVars) else ()
            in
               LEAF newSet
            end
           | delRef _ = raise IndexError
         val tt = #typeTable table
         fun updateRef v = ttSet (tt, v, delRef (v, ttGet (tt, v)))
         val tVars = Path.varsOfFlowpoints fp
         val _ = List.app updateRef tVars
      in
         (!unusedTVars,Path.flagsOfFlowpoints fp)
      end

   fun termToSteps (index,table : table) =
      let
         val tt = #typeTable table
         fun downFrom num [] = []
           | downFrom num (i :: is) =
               List.map (Path.prependIntStep num) i @ downFrom (num-1) is
         fun fromType v = case ttGet (tt,v) of
               TERM term => fromTerm term
             | LEAF _ => [(Path.emptySteps, Path.mkVarLeaf (find tt v))]
             | _ => raise IndexError
         and fromTerm (TT_FUN (is,res)) = downFrom 0 (List.map fromType (res::is))
           | fromTerm (TT_SYN (_,index)) = fromType index
           | fromTerm (TT_ZENO) = []
           | fromTerm (TT_FLOAT) = []
           | fromTerm (TT_STRING) = []
           | fromTerm (TT_UNIT) = []
           | fromTerm (TT_VEC index) =  fromType index
           | fromTerm (TT_CONST _) = []
           | fromTerm (TT_ALG (_, is)) = downFrom (length is) (List.map fromType is)
           | fromTerm (TT_RECORD _) = fromType index
           | fromTerm (TT_FIELD (f,i,j)) = (Path.emptySteps, Path.mkFieldLeaf f) ::
              List.map (Path.prependFieldStep f) (fromType i) @ fromType j
           | fromTerm (TT_MONAD (res,inp,out)) =
            List.map (Path.prependIntStep 0) (fromType res) @
            List.map (Path.prependIntStep (~1)) (fromType inp) @
            List.map (Path.prependIntStep 1) (fromType out)
      in
         fromType index
      end

    (* pending unification constraints are represented as a set of
       variable sets where each variable set contains variables that
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
               val v1 = find tt v1
               val v2 = find tt v2
               val newPairs = if TVar.eq (v1,v2) then [] else
                  unifyTT (v1, v2, ttGet (tt,v1), ttGet (tt,v2))
               val pairs = foldl addPair pairs newPairs
            in
               fixpoint pairs
            end
         and unifyTT (v1, v2, LEAF symSet1, LEAF symSet2) =
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
                  val scRef = #sizeDom table
                  val _ = scRef := SC.rename (vBad,vGood,!scRef)
               in
                  []
               end
           | unifyTT (v1, v2, TERM t1, TERM t2) = genPairs (v1,v2, t1,t2)
           | unifyTT (v1, v2, LEAF symSet, TERM t2) = substVar (v1,symSet,v2,t2)
           | unifyTT (v1, v2, TERM t1, LEAF symSet) = substVar (v2,symSet,v1,t1)
           | unifyTT _ = raise TypeTableError
      and genPairs (v1,v2,TT_FUN (f1, f2), TT_FUN (g1, g2)) = if List.length f1<>List.length g1
         then raise S.UnificationFailure (S.Clash, 
               "function with different number of arguments (" ^
               Int.toString (List.length f1) ^ " and " ^
               Int.toString (List.length g1) ^ ")"
            )
         else (f2,g2)::ListPair.zip (f1,g1)
        | genPairs (_ ,v2,TT_SYN (_,v1),t2) = unifyTT (find tt v1, v2, ttGet (tt,v1), TERM t2)
        | genPairs (v1,_ ,t1,TT_SYN (_,v2)) = unifyTT (v1, find tt v2, TERM t1, ttGet (tt, v2))
        | genPairs (v1,v2,TT_ZENO, TT_ZENO) = []
        | genPairs (v1,v2,TT_FLOAT, TT_FLOAT) = []
        | genPairs (v1,v2,TT_STRING, TT_STRING) = []
        | genPairs (v1,v2,TT_UNIT, TT_UNIT) = []
        | genPairs (v1,v2,TT_VEC t1, TT_VEC t2) = [(t1, t2)]
        | genPairs (v1,v2,TT_CONST c1, TT_CONST c2) =
           if c1=c2 then [] else raise S.UnificationFailure (S.Clash,
            "incompatible bit vectors sizes (" ^ Int.toString c1 ^ " and " ^
            Int.toString c2 ^ ")")
        | genPairs (v1,v2,TT_RECORD row1, TT_RECORD row2) =
         let
            fun gatherFields (fs,i) = case ttGet (tt,i) of
               TERM (TT_FIELD (f,i,j)) => gatherFields (SymMap.insert (fs,f,i), j)
             | LEAF symSet => (fs,i,symSet)
             | _ => raise IndexError
            val (fs1,row1,symSet1) = gatherFields (SymMap.empty, row1)
            val (fs2,row2,symSet2) = gatherFields (SymMap.empty, row2)
            val newIn1 = ref ([] : (FieldInfo.symid * index) list)
            val newIn2 = ref ([] : (FieldInfo.symid * index) list)
            val rPairs = ref ([] : (index * index) list)
            fun addRef (f, SOME fIdx1, SOME fIdx2) =
               (rPairs := (fIdx1,fIdx2) :: !rPairs; NONE)
              | addRef (f, SOME fIdx1, NONE) =
               (newIn2 := (f, fIdx1) :: !newIn2; NONE)
              | addRef (f, NONE, SOME fIdx2) =
               (newIn1 := (f, fIdx2) :: !newIn1; NONE)
              | addRef _ = raise IndexError
            val _ = SymMap.mergeWithi addRef (fs1,fs2)
            fun addField ((f,fIdx),row) = allocType (TT_FIELD (f,fIdx,row), table)
            val newRow = TVar.freshTVar ()
            val newFields1 = foldl addField newRow (!newIn1)
            val newFields2 = foldl addField newRow (!newIn2)
            fun getField (TERM t) = t
              | getField _ = raise IndexError
            val pairs1 = substVar (row1,symSet1,newFields2,getField (ttGet(tt,newFields2)))
            val pairs2 = substVar (row2,symSet2,newFields1,getField (ttGet(tt,newFields1)))
         in
            pairs1 @ pairs2 @ !rPairs
         end
        | genPairs (v1,v2,TT_MONAD (r1,f1,t1), TT_MONAD (r2,f2,t2)) =
            [(r1, r2), (f1, f2), (t1, t2)]
        | genPairs (v1,v2,TT_ALG (ty1, l1), TT_ALG (ty2, l2)) =
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
        | genPairs (v1,v2,t1,t2) =
         let
            fun descrF (TERM (TT_FIELD (f,i,j))) =
                  SymbolTable.getString(!SymbolTables.fieldTable, f) ^
                  ", " ^ descrF (ttGet (tt,j))
              | descrF (LEAF _) = "..." 
              | descrF _ = "something that shouldn't be here"
            fun descr (TT_FUN _) = "a function type"
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
              | descr (TT_RECORD i) = "a record {" ^ descrF (ttGet (tt,i)) ^ "}"
              | descr (TT_MONAD _) = "an action"
              | descr _ = "something that shouldn't be here"
         in
            raise S.UnificationFailure (S.Clash, "cannot match " ^ descr t1 ^
                                        " against " ^ descr t2)
         end
      and substVar (vVar,symSet,vType,termType) = 
         let
            val _ = ttSet (tt, vVar, FORW vType)
            val stepsLeafList = termToSteps (vType,table)
            fun updateNewLeaf (_,leaf) = case Path.getVarLeaf leaf of
                  NONE => ()
                | SOME v => (case ttGet (tt,v) of
                   LEAF ss => ttSet  (tt, v,LEAF (SymSet.union (ss,symSet)))
                 | _ => raise IndexError
                )
            val _ = List.app updateNewLeaf stepsLeafList
            fun getExpandInfoForSym sym =
               let
                  val { flow = fp, info = index } = HT.lookup st sym
                  val (fp, expandInfo) = Path.insertSteps (fp,vVar,stepsLeafList)
                  val _ = HT.insert st (sym, { flow = fp, info = index })
               in
                  expandInfo
               end
            val expandInfo = List.concat (List.map getExpandInfoForSym (SymSet.listItems symSet))
            val varsToExpand = List.map #1 expandInfo
            val vectorsToExpandTo = List.map #2 expandInfo 
            fun transpose [] = []
              | transpose ([]::_) = []
              | transpose rows = (map hd rows) :: (transpose (map tl rows))
            val vectorsTransposed = transpose vectorsToExpandTo
            val contra = List.map (Path.stepsContra o #1) stepsLeafList
            val _ = TextIO.print ("length of vars: " ^ Int.toString (length varsToExpand) ^
                                  ", length of contra: "^ Int.toString (length contra) ^
                                  "length of vec: " ^ Int.toString (length vectorsTransposed) ^
                                  foldl (fn (s,ss) => s ^ " " ^ ss) "" (map (Int.toString o length) vectorsTransposed) ^
                                  "\n")
            val bdRef = (#boolDom table)
            fun doExpand [] =
               bdRef := BD.projectOut (List.foldl BD.addToSet BD.emptySet varsToExpand, !bdRef)
              | doExpand ((contra, vs) :: cvss) =
               (bdRef := BD.expand (varsToExpand, map (fn v => (contra, v)) vs, !bdRef);
               doExpand cvss)
            val _ = doExpand (ListPair.zip (contra, vectorsTransposed))
            val scRef = (#sizeDom table)
            val newPairs = case termType of
                  TT_CONST n => (case SC.add (SC.equality (vVar,[],n), !scRef) of
                      SC.RESULT (newConsts,sCons) => (scRef := sCons;
                         List.map (fn (v,c) => (v, newType (CONST c,table))) newConsts
                         )
                     | SC.UNSATISFIABLE => raise S.UnificationFailure (S.Clash,
                        "size constraints over vectors are unsatisfiable")
                     | SC.FRACTIONAL => raise S.UnificationFailure (S.Clash,
                        "solution to size constraint is not integral")
                     | SC.NEGATIVE => raise S.UnificationFailure (S.Clash,
                        "constraint implies that vector has non-positive size")
                    )
               | _ => []
         in
            newPairs
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
         val ft = !SymbolTables.fieldTable
         val (ft,foo) = SymbolTable.fresh (ft, Atom.atom "foo")
         val (ft,bar) = SymbolTable.fresh (ft, Atom.atom "bar")
         val (ft,baz) = SymbolTable.fresh (ft, Atom.atom "baz")
         val (ft,bro) = SymbolTable.fresh (ft, Atom.atom "bro")
         val (ft,bru) = SymbolTable.fresh (ft, Atom.atom "bru")
         val (ft,ban) = SymbolTable.fresh (ft, Atom.atom "ban")
         val _ = SymbolTables.fieldTable := ft
         val t = TVar.freshTVar ()
         val s = TVar.freshTVar ()
         val u = TVar.freshTVar ()
         val v = TVar.freshTVar ()
         val w = TVar.freshTVar ()
         fun wBV tVar = VAR (tVar, BD.freshBVar ())
         fun getTVar (VAR (tv,bv)) = tv
         val rTy1 = Types.RECORD (TVar.freshTVar (),BD.freshBVar (),[
               Types.RField { name = foo, fty = Types.ZENO, exists = BD.freshBVar () },
               Types.RField { name = bar, fty = wBV s, exists = BD.freshBVar () },
               Types.RField { name = ban, fty = wBV t, exists = BD.freshBVar () }
            ])
         val rTy2 = Types.RECORD (TVar.freshTVar (),BD.freshBVar (),[
               Types.RField { name = bro, fty = Types.ZENO, exists = BD.freshBVar () },
               Types.RField { name = bru, fty = wBV s, exists = BD.freshBVar () },
               Types.RField { name = bar, fty = wBV w, exists = BD.freshBVar () },
               Types.RField { name = baz, fty = wBV t, exists = BD.freshBVar () }
            ])
         val rIdx1 = newType (rTy1, table)
         val rIdx2 = newType (rTy2, table)
         val idxX = addSymbol (xVar,FUN ([ZENO,wBV t],VEC (wBV u)),table)
         val idxY = addSymbol (yVar,FUN ([wBV s,wBV t],wBV t),table)
         val idxZ = addSymbol (zVar,FUN ([wBV t,wBV  v],rTy1),table)
         val idx = newType (Types.VEC (Types.VAR (TVar.freshTVar (), BooleanDomain.freshBVar ())), table)
         val x = TVar.freshTVar ()
         val y = TVar.freshTVar ()
         val z = TVar.freshTVar ()
         val fIdx = newType (FUN ([wBV x,wBV  y],wBV z),table)

         val si = TVar.emptyShowInfo
         (*val (str,si) = toStringSI (fn _ => true, table, si);*)
         val _ = SymbolTables.varTable := SymbolTable.pop (!SymbolTables.varTable)
         (*val (tStr,si,varset) = showTableSI (table, ttGetVars (#typeTable table), si, TVar.empty);*)
         val (tStr,si) = dumpTableSI (table, si);
         val _ = TextIO.print ("type table:\n" ^ tStr)

         (*val (tVars,bVars) = delSymbol (zVar,table)
         val (tSetStr, si) = TVar.setToString (tVars,si)
         val bSetStr = BD.setToString bVars
         val _ = TextIO.print ("no more references to " ^ tSetStr ^ " and " ^ bSetStr ^ "\n")*)
         val _ = unify (rIdx1,rIdx2,table)

         (*val (tStr,si,varset) = showTableSI (table, ttGetVars (#typeTable table), si, TVar.empty);*)
         val (tStr,si) = dumpTableSI (table, si);
         val _ = TextIO.print ("again:\n" ^ tStr)
      in
         ()
      end
end
