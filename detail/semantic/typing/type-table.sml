structure Path : sig
   
   type flowpoints
   val typeToFlowpoints : Types.texp -> flowpoints
   val varsOfFlowpoints : flowpoints -> TVar.tvar list

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

   type path = step list

   fun comparePath ([],[]) = EQUAL
     | comparePath (s1::ss1,[]) = GREATER
     | comparePath ([],s2::ss2) = LESS
     | comparePath (StepIndex i1::ss1,StepIndex i2::ss2) =
         (case Int.compare (i1,i2) of
            EQUAL => comparePath (ss1,ss2)
          | res => res
         )
     | comparePath (StepField f1::ss1,StepField f2::ss2) =
         (case SymbolTable.compare_symid (f1,f2) of
            EQUAL => comparePath (ss1,ss2)
          | res => res
         )
     | comparePath (StepIndex _::_,_) = LESS
     | comparePath _ = GREATER

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

   fun showFlowInfo {flag = f, contraVariant = cV} =
      if cV then "!" ^ BD.showVar f else BD.showVar f

   fun showPath p =
      let
         fun showStep (StepIndex i) = Int.toString i ^ "."
           | showStep (StepField f) =
            SymbolTable.getString (!SymbolTables.fieldTable,f) ^ "."
      in
         String.concat (List.map showStep p)
      end
   
   structure TVarMap = RedBlackMapFn(struct
      type ord_key = TVar.tvar
      val compare = TVar.compare
   end)           

   structure PathMap = RedBlackMapFn(struct
      type ord_key = path
      val compare = comparePath
   end)           

   type flowpoints = (flowinfo PathMap.map TVarMap.map * flowinfo PathMap.map SymMap.map)

   fun toStringSI ((varMap, symMap) : flowpoints,si) =
      let
         fun showPaths pm = PathMap.foldli (fn (p,fi,pStr) =>
            showPath p ^ ":" ^ showFlowInfo fi ^ ";" ^ pStr) "" pm
         fun showVarMapping (v,pm,(str,si)) =
            let
               val (varStr, si) = TVar.varToString (v,si)
            in
               (str ^ "\n  " ^ varStr ^ ":" ^ showPaths pm, si)
            end
         val (vStr,si) = TVarMap.foldli showVarMapping ("",si) varMap
         fun showSymMapping (f,pm,str) =
            let
               val varStr = SymbolTable.getString (!SymbolTables.fieldTable,f)
            in
               str ^ "\n  " ^ varStr ^ ":" ^ showPaths pm
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
                   | NONE => PathMap.empty
               val pathMap = PathMap.insert (pathMap, path, flowinfo)
            in
               (TVarMap.insert (varMap, v, pathMap), fieldMap)
            end
           | insert ((path, LeafField f, flag, cv),(varMap, fieldMap)) =
            let
               val flowinfo = { flag = flag, contraVariant = cv }
               val pathMap = case SymMap.find (fieldMap, f) of
                     SOME pm => pm
                   | NONE => PathMap.empty
               val pathMap = PathMap.insert (pathMap, path, flowinfo)
            in
               (varMap, SymMap.insert (fieldMap, f, pathMap))
            end
      in
         List.foldl insert (TVarMap.empty, SymMap.empty) (paths ty)
      end

   fun varsOfFlowpoints (vm,_) = TVarMap.listKeys vm
   
end


structure TypeTable : sig

   type table
   

   (*a type variable was not found in the type table*)
   exception IndexError

   val emptyTable : table

   val toStringSI : (SymbolTable.symid -> bool) * table * TVar.varmap -> string * TVar.varmap
   
   val newType : Types.texp * table -> TVar.tvar
   val newTop : table -> TVar.tvar

   val addSymbol : SymbolTable.symid * Types.texp * table -> unit
   val delSymbol : SymbolTable.symid * table -> unit
   
end = struct

   type index = TVar.tvar

   structure HT = HashTable
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

   datatype typeinfo
      = TERM of typeterm
      | LEAF of SymSet.set

   type entry = {
      flow : Path.flowpoints,
      info : index
   }
      
   type table = {
      hashCons : (typeterm, index) HT.hash_table,
      symTable : (SymbolTable.symid,entry) HT.hash_table,
      typeTable : (index, typeinfo) HT.hash_table
   }

   exception CondensingError
   exception IndexError

   val emptyTable = {
      hashCons = HT.mkTable (typeterm_hash,typeterm_eq) (10000, CondensingError),
      symTable = HT.mkTable (sym_hash,SymbolTable.eq_symid) (100, IndexError),
      typeTable = HT.mkTable (TVar.hash, TVar.eq) (100000, IndexError)
   } : table

   fun showTableSI (table : table, todo, si, done) =
      let
         val tt = #typeTable table
         fun printFixpoint (str, [], si, done) = (str,si,done)
           | printFixpoint (str, var::vars, si, done) =
            if TVar.member (done,var) then printFixpoint (str, vars, si, done) else
            (case HT.lookup tt var of
               TERM t =>
               let
                  val str = str
                  val newVars = TVar.empty
                  val done = TVar.union (TVar.del (var,done), newVars)
               in
                  printFixpoint (str, vars, si, done)
               end
             | LEAF refs => printFixpoint (str, vars, si, done)
            )
               
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
                     showTableSI (table, Path.varsOfFlowpoints fp, si, tVars)
               in
                  (str ^ "\n" ^ symStr ^ ": " ^ varStr ^ pStr ^ tabStr,tVars,si)
               end
            else (str,tVars,si)
         val (sStr, tVars, si) = HT.foldi showSym ("",TVar.empty,si) st
      in
         (sStr, si)
      end

   fun newType (ty,table : table) =
      let
         val hc = #hashCons table
         fun allocType t = case HT.find hc t of
            SOME idx => idx
          | NONE =>
            let
               val idx = TVar.freshTVar ()
               val _ = HT.insert hc (t, idx)
            in
               idx
            end
         val tt = #typeTable table
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
           | conv (VAR (v,_)) = (case HT.find tt v of
                 NONE => (HT.insert tt (v,LEAF SymSet.empty); v)
               | SOME (LEAF _) => v
               | SOME (TERM _) => raise IndexError
             )
          and convF (RField {name = n, fty = t, exists = b}) = (n,conv t)
      in
         conv ty
      end

   fun newTop table =
      let
         val idx = TVar.freshTVar ()
         val tt = #typeTable (table : table)
         val _ = HT.insert tt (idx,LEAF SymSet.empty)
      in
         idx
      end

   fun addSymbol (sym,ty,table) =
      let
         val idx = newType (ty,table)
         val fp = Path.typeToFlowpoints ty
         val st = #symTable (table : table)
      in
        HT.insert st (sym,{ flow = fp, info = idx })
      end

    fun delSymbol (sym,table) = ()

end
