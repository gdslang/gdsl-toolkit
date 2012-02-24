structure Primitives = struct
   open Types

   fun var a = VAR (a,BD.freshBVar ())

   (* result type of the decoder function *)
   val r : tvar = freshTVar ()
   val state : tvar = freshTVar ()
   val size : tvar = freshTVar ()
   val s1 : tvar = freshTVar ()
   val s2 : tvar = freshTVar ()
   val s3 : tvar = freshTVar ()
   val s4 : tvar = freshTVar ()
   val s5 : tvar = freshTVar ()
   val a : tvar = freshTVar ()
   val d : tvar = freshTVar ()
   val e : tvar = freshTVar ()

   (*create a type from two vectors to one vector, all of size s*)
   fun vvv s = FUN (VEC (var s), FUN (VEC (var s), VEC (var s)))

   val anonDecodeFunction : string = "top-level decode function"
   val globalState : string = "global state"
   
   val primitiveValues
      : {pName : string, pType : texp, dType : texp option} list
      = [
         { pName = "continue", pType = MONAD (var r), dType = SOME (var size) },
         { pName = anonDecodeFunction, pType = MONAD (var r), dType = SOME (var size) },
         { pName = globalState, pType = var state, dType = NONE },
         { pName = "return", pType = FUN (var a, MONAD (var a)), dType = NONE},
         { pName = "update", pType = FUN (FUN (var state, var state), MONAD (var d)), dType = NONE},
         { pName = "query", pType = FUN (FUN (var state, var state), MONAD (var e)), dType = NONE},
         { pName = "+", pType = vvv s1, dType = NONE},
         { pName = "*", pType = vvv s2, dType = NONE},
         { pName = "signed", pType = FUN (VEC (var s3), ZENO), dType = NONE},
         { pName = "unsigned", pType = FUN (VEC (var s4), ZENO), dType = NONE},
         { pName = "bits8", pType = FUN (ZENO, VEC (CONST 8)), dType = NONE},
         { pName = "^", pType = vvv s5, dType = NONE},
         { pName = "otherwise", pType = VEC (CONST 1), dType = NONE}
      ]

   val primitiveTypes = [
      { tName = "int", tType = ZENO},
      { tName = "string", tType = FLOAT}
   ]

   structure ST = SymbolTables
   
   fun addVar {pName = n, pType = _, dType = _} = let
         val (newTable, _) = SymbolTable.create (!ST.varTable,
                                                 Atom.atom n,
                                                 SymbolTable.noSpan)
      in
         (ST.varTable := newTable)
      end
   fun addType {tName = t, tType = _} =
      let
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
   fun getSymbolTypes () = List.map
      (fn {pName = n, pType = t, dType = ow} =>
         (SymbolTable.lookup (!ST.varTable, Atom.atom n), t, ow)
      )
      primitiveValues

end                                                       