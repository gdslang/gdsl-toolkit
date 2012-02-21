structure Primitives = struct
   open Types

   (* result type of the decoder function *)
   val r : tvar = freshTVar ()
   val state : tvar = freshTVar ()

   val s1 : tvar = freshTVar ()
   val s2 : tvar = freshTVar ()
   val s3 : tvar = freshTVar ()
   val s4 : tvar = freshTVar ()
   val s5 : tvar = freshTVar ()
   val a : tvar = freshTVar ()
   val d : tvar = freshTVar ()
   val e : tvar = freshTVar ()

   (*create a type from two vectors to one vector, all of size s*)
   fun vvv s = FUN (VEC (VAR s), FUN (VEC (VAR s), VEC (VAR s)))

   val primitiveValues : {pName : string, pType : texp} list = [
      { pName = "continue", pType = MONAD (VAR r) },
      { pName = "#anon_decode_function", pType = MONAD (VAR r) },
      { pName = "return", pType = FUN (VAR a, MONAD (VAR a))},
      { pName = "update", pType = FUN (FUN (VAR state, VAR state), MONAD (VAR d))},
      { pName = "query", pType = FUN (FUN (VAR state, VAR state), MONAD (VAR e))},
      { pName = "+", pType = vvv s1 },
      { pName = "*", pType = vvv s2 },
      { pName = "signed", pType = FUN (VEC (VAR s3), ZENO) },
      { pName = "unsigned", pType = FUN (VEC (VAR s4), ZENO) },
      { pName = "bits8", pType = FUN (ZENO, VEC (CONST 8)) },
      { pName = "^", pType = vvv s5 },
      { pName = "otherwise", pType = VEC (CONST 1)}
   ]

   val primitiveTypes = [
      { tName = "int", tType = ZENO},
      { tName = "string", tType = FLOAT}
   ]

   structure ST = SymbolTables
   
   fun addVar { pName = n, pType } = let
         val (newTable, _) = SymbolTable.create (!ST.varTable,
                                                 Atom.atom n,
                                                 SymbolTable.noSpan)
      in
         (ST.varTable := newTable)
      end
   fun addType { tName = t, tType } = let
         val (newTable, _) = SymbolTable.create (!ST.typeTable,
                                                 Atom.atom t,
                                                 SymbolTable.noSpan)
      in
         (ST.typeTable := newTable)
      end
  
   fun addPrimitivesToTables () = (
         ST.varTable := VarInfo.empty;
         ST.conTable := ConInfo.empty;
         ST.typeTable := TypeInfo.empty;
         ST.fieldTable := FieldInfo.empty;
         List.map addVar primitiveValues;
         List.map addType primitiveTypes
         )
end                                                       