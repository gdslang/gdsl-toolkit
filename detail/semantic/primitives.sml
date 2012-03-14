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

   val primitiveValues =
      [{name="true", ty=VEC (CONST 1)},
       {name="false", ty=VEC (CONST 1)},
       {name="continue", ty=MONAD (var r)},
       {name="consume", ty=MONAD (VEC (var s6))},
       {name="unconsume", ty=MONAD UNIT},
       {name="raise", ty=MONAD (var (t()))},
       (* TODO *) {name="slice", ty=MONAD (var (t ()))},
       {name=caseExpression, ty=UNIT},
       {name=globalState, ty=var state},
       {name=anonDecodeFunction, ty=MONAD (var r)},
       {name="return", ty=FUN (var a, MONAD (var a))},
       {name=">>=", ty=
         let
            val a' = var a
            val b' = var a
         in
            (* 'a M -> ('a -> 'b M) -> 'b M *)
            FUN (FUN (MONAD a', FUN (a', MONAD b')), MONAD b')
         end},
       {name="update", ty=FUN (FUN (var state, var state), MONAD (var d))},
       {name="query", ty=FUN (FUN (var state, var state), MONAD (var e))},
       {name="+", ty=vvv s1},
       {name="*", ty=vvv s2},
       {name="signed", ty=FUN (VEC (var s3), ZENO)},
       {name="unsigned", ty=FUN (VEC (var s4), ZENO)},
       {name="bits8", ty=FUN (ZENO, VEC (CONST 8))},
       {name = "||", ty = FUN (VEC (CONST 1), FUN (VEC (CONST 1), VEC (CONST 1)))},
       {name = "<~", ty = FUN (VEC (var s6), FUN (VEC (var s6), VEC (CONST 1)))},
       {name = ">~", ty = FUN (VEC (var s7), FUN (VEC (var s7), VEC (CONST 1)))},
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
         fun find n nts =
            case nts of
               [] => NONE
             | {name, ty} :: nts =>
                  case String.compare (n, name) of
                     EQUAL => SOME ty
                   | _ => find n nts

         fun genTriple {name=n, ty=t} =
            (SymbolTable.lookup(!ST.varTable, Atom.atom n),
             t,
             find n primitiveDecoders)
      in
         List.map genTriple primitiveValues
      end
end                                                       
