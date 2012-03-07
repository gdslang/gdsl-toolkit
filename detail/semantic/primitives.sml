structure Primitives = struct
   structure ST = SymbolTables
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
   val s6 : tvar = freshTVar ()
   val s7 : tvar = freshTVar ()
   val a : tvar = freshTVar ()
   val d : tvar = freshTVar ()
   val e : tvar = freshTVar ()
   val t = freshTVar

   (*create a type from two vectors to one vector, all of size s*)
   fun vvv s = FUN (VEC (var s), FUN (VEC (var s), VEC (var s)))

   val anonDecodeFunction : string = "top-level decode function"
   val globalState : string = "global state"
   val caseExpression : string = "case expression"

(*

   val primitiveValues
      : {pName : string, pType : texp, dType : texp option} list
      = [{ pName = "continue", pType = MONAD (var r), dType = SOME (var size) },
         { pName = anonDecodeFunction, pType = MONAD (var r), dType = SOME (var size) },
         { pName = globalState, pType = var state, dType = NONE },
         (*{ pName = "return", pType = FUN (var a, MONAD (var a)), dType = NONE},
         { pName = "update", pType = FUN (FUN (var state, var state), MONAD (var d)), dType = NONE},
         { pName = "query", pType = FUN (FUN (var state, var state), MONAD (var e)), dType = NONE},
         { pName = "+", pType = vvv s1, dType = NONE},
         { pName = "*", pType = vvv s2, dType = NONE},
         { pName = "signed", pType = FUN (VEC (var s3), ZENO), dType = NONE},*)
         { pName = "unsigned", pType = FUN (VEC (var s4), ZENO), dType = NONE},
         { pName = "||", pType = FUN (VEC (CONST 1), FUN (VEC (CONST 1), VEC (CONST 1))), dType = NONE},
         { pName = "<~", pType = FUN (VEC (var s6), FUN (VEC (var s6), VEC (CONST 1))), dType = NONE},
         { pName = ">~", pType = FUN (VEC (var s7), FUN (VEC (var s7), VEC (CONST 1))), dType = NONE},
         (*{ pName = "bits8", pType = FUN (ZENO, VEC (CONST 8)), dType = NONE},
         { pName = "^", pType = vvv s5, dType = NONE},*)
         { pName = "otherwise", pType = VEC (CONST 1), dType = NONE}
      ]

*)

   val primitiveValues =
      [{name="true", ty=VEC (CONST 1)},
       {name="false", ty=VEC (CONST 1)},
       {name="continue", ty=MONAD (var r)},
       {name="consume", ty=MONAD (VEC (var s6))},
       {name="raise", ty=MONAD (var (t()))},
       (* TODO *) {name="slice", ty=MONAD (var (t ()))},
       {name=globalState, ty=var state},
       {name=anonDecodeFunction, ty=MONAD (var r)},
       {name="return", ty=FUN (var a, MONAD (var a))},
       {name="update", ty=FUN (FUN (var state, var state), MONAD (var d))},
       {name="query", ty=FUN (FUN (var state, var state), MONAD (var e))},
       {name="+", ty=vvv s1},
       {name="*", ty=vvv s2},
       {name="signed", ty=FUN (VEC (var s3), ZENO)},
       {name="unsigned", ty=FUN (VEC (var s4), ZENO)},
       {name="bits8", ty=FUN (ZENO, VEC (CONST 8))},
       {name="^", ty=vvv s5},
       {name="otherwise", ty=VEC (CONST 1)}]

   val primitiveDecoders =
      [{name=anonDecodeFunction, ty=var size}]

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
   
   fun getSymbolTypes () =
      let
         fun find n ({name, ty} :: nts) = (case String.compare (n,name) of
                 EQUAL => SOME ty
               | _ => find n nts
            )
           | find n [] = NONE
         fun genTriple {name=n, ty=t} =
            (SymbolTable.lookup(!ST.varTable, Atom.atom n)
            ,t
            ,find n primitiveDecoders)
      in
         List.map genTriple primitiveValues
      end
end                                                       
