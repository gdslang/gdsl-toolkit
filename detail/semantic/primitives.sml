structure Primitives = struct
   structure ST = SymbolTables
   structure SC = SizeConstraint
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
   val s8 : tvar = freshTVar ()
   val s9 : tvar = freshTVar ()
   val s10 : tvar = freshTVar ()
   val s11 : tvar = freshTVar ()
   val s12 : tvar = freshTVar ()
   val s13 : tvar = freshTVar ()
   val s14 : tvar = freshTVar ()
   val s15 : tvar = freshTVar ()
   val s16 : tvar = freshTVar ()
   val s17 : tvar = freshTVar ()
   val s18 : tvar = freshTVar ()
   val s19 : tvar = freshTVar ()
   val a : tvar = freshTVar ()
   val b : tvar = freshTVar ()
   val c : tvar = freshTVar ()
   val d : tvar = freshTVar ()
   val e : tvar = freshTVar ()
   val t = freshTVar

   (*create a type from two vectors to one vector, all of size s*)
   fun vvv s = FUN (VEC (var s), FUN (VEC (var s), VEC (var s)))
   fun vv  s = FUN (VEC (var s), VEC (var s))
   fun vvb s = FUN (VEC (var s), FUN (VEC (var s), VEC (CONST 1)))

   val granularity : string = "granularity"
   val globalState : string = "global state"
   val caseExpression : string = "case expression"
   
   val primitiveValues =
      [{name="true", ty=VEC (CONST 1)},
       {name="false", ty=VEC (CONST 1)},
       {name="continue", ty=MONAD (var r)},
       {name="consume", ty=MONAD (VEC (var size))},
       {name="unconsume", ty=MONAD UNIT},
       {name="raise", ty=MONAD (var (t()))},
       {name=caseExpression, ty=UNIT},
       {name=globalState, ty=var state},
       {name=granularity, ty=UNIT},
       {name="return", ty=FUN (var a, MONAD (var a))},
       {name=">>=", ty=
         let
            val a' = var b
            val b' = var c
         in
            (* 'a M -> ('a -> 'b M) -> 'b M *)
            FUN (FUN (MONAD a', FUN (a', MONAD b')), MONAD b')
         end},
       {name="update", ty=FUN (FUN (var state, var state), MONAD (var d))},
       {name="query", ty=FUN (FUN (var state, var e), MONAD (var e))},
       {name="+", ty=vvv s1},
       {name="-", ty=vvv s2},
       {name="*", ty=vvv s3},
       {name="bits8", ty=FUN (ZENO, VEC (CONST 8))},
       {name = "||", ty = vvv s4},
       {name = "&&", ty = vvv s5},
       {name = "<~", ty = vvb s6},
       {name = ">~", ty = vvb s7},
       {name = "==", ty = vvb s8},
       {name = "!=", ty = vvb s9},
       {name = "not", ty = vv s10},
       {name="prefix", ty = FUN (VEC (var s11), VEC (var s12))},
       {name="suffix", ty = FUN (VEC (var s13), VEC (var s14))},
       {name="^", ty=FUN (VEC (var s15), FUN (VEC (var s16), VEC (var s17)))},
       {name="signed", ty=FUN (VEC (var s18), ZENO)},
       {name="unsigned", ty=FUN (VEC (var s19), ZENO)},
       {name="otherwise", ty=FUN (var state, VEC (CONST 1))}]

   fun initialSizeConstraints scs = 
      SC.add (SC.equality (s17, [s15,s16], 0), scs)

   val primitiveDecoders =
      [{name=granularity, ty=var size},
       {name="consume", ty=var size}]

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
