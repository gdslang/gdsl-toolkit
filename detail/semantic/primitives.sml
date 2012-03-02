structure Primitives = struct
   structure ST = SymbolTables
   open Types

   (* result type of the decoder function *)
   val r : tvar = freshTVar ()
   val state : tvar = freshTVar ()

   val s1 : tvar = freshTVar ()
   val s2 : tvar = freshTVar ()
   val s3 : tvar = freshTVar ()
   val s4 : tvar = freshTVar ()
   val s5 : tvar = freshTVar ()
   val s6 = freshTVar ()
   val a : tvar = freshTVar ()
   val d : tvar = freshTVar ()
   val e : tvar = freshTVar ()
   val t = freshTVar

   (*create a type from two vectors to one vector, all of size s*)
   fun vvv s = FUN (VEC (VAR s), FUN (VEC (VAR s), VEC (VAR s)))

   val primitiveValues =
      [{name="true", ty=ZENO},
       {name="false", ty=ZENO},
       {name="continue", ty=MONAD (VAR r)},
       {name="consume", ty=MONAD (VEC (VAR s6))},
       (* TODO *) {name="slice", ty=MONAD (VAR (t ()))},
       {name="#anon_decode_function", ty=MONAD (VAR r)},
       {name="return", ty=FUN (VAR a, MONAD (VAR a))},
       {name="update", ty=FUN (FUN (VAR state, VAR state), MONAD (VAR d))},
       {name="query", ty=FUN (FUN (VAR state, VAR state), MONAD (VAR e))},
       {name="+", ty=vvv s1},
       {name="*", ty=vvv s2},
       {name="signed", ty=FUN (VEC (VAR s3), ZENO)},
       {name="unsigned", ty=FUN (VEC (VAR s4), ZENO)},
       {name="bits8", ty=FUN (ZENO, VEC (CONST 8))},
       {name="^", ty=vvv s5},
       {name="otherwise", ty=VEC (CONST 1)}]

   val primitiveTypes =
      [{name="int", ty=ZENO},
       {name="string", ty=FLOAT}]

   fun addPrim table {name, ty} = let
      val (newTable, _) =
         SymbolTable.create
            (!table,
             Atom.atom name,
             SymbolTable.noSpan)
   in
      table := newTable
   end

   fun registerPrimitives () =
      (ST.varTable := VarInfo.empty
      ;ST.conTable := ConInfo.empty
      ;ST.typeTable := TypeInfo.empty
      ;ST.fieldTable := FieldInfo.empty
      ;List.map (addPrim ST.varTable) primitiveValues
      ;List.map (addPrim ST.typeTable) primitiveTypes)
end                                                       
