
structure Primitives = struct
   structure ST = SymbolTables
   structure SC = SizeConstraint
   open Types

   exception Bug
   
   fun newFlow (VAR (a,_)) = VAR (a, BD.freshBVar ())
     | newFlow _ = raise Bug
   fun freshVar () = VAR (freshTVar (), BD.freshBVar ())
   fun bvar (VAR (v,b)) = b
     | bvar _ = raise Bug
   fun tvar (VAR (v,b)) = v
     | tvar _ = raise Bug

   (* result type of the decoder function *)
   val r = freshVar ()
   val state = freshVar ()
   val state' = newFlow state
   val state'' = newFlow state
   val state''' = newFlow state
   val state'''' = newFlow state
   val size = freshVar ()
   val s1 = freshVar ()
   val s2 = freshVar ()
   val s3 = freshVar ()
   val s4 = freshVar ()
   val s5 = freshVar ()
   val s6 = freshVar ()
   val s7 = freshVar ()
   val s8 = freshVar ()
   val s9 = freshVar ()
   val s10 = freshVar ()
   val s11 = freshVar ()
   val s12 = freshVar ()
   val s13 = freshVar ()
   val s14 = freshVar ()
   val s15 = freshVar ()
   val s16 = freshVar ()
   val s17 = freshVar ()
   val s18 = freshVar ()
   val s19 = freshVar ()
   val a = freshVar ()
   val a' = newFlow a
   val b = freshVar ()
   val b' = newFlow b
   val c = freshVar ()
   val c' = newFlow c
   val d = freshVar ()
   val e = freshVar ()
   val e' = newFlow e

   (*create a type from two vectors to one vector, all of size s*)
   fun vvv s = FUN (VEC s, FUN (VEC s, VEC s))
   fun vv  s = FUN (VEC s, VEC s)
   fun vvb s = FUN (VEC s, FUN (VEC s, VEC (CONST 1)))

   val granularity : string = "stream granularity"
   val globalState : string = "global state"
   val caseExpression : string = "case expression"
   
   val primitiveValues =
      [{name="true", ty=VEC (CONST 1)},
       {name="false", ty=VEC (CONST 1)},
       {name="consume", ty=MONAD (VEC size,newFlow state, newFlow state)},
       {name="unconsume", ty=MONAD (UNIT,newFlow state, newFlow state)}, 
       (* TODO *) {name="slice", ty=MONAD (freshVar (),newFlow state, newFlow state)},
       {name="raise", ty=MONAD (freshVar (),newFlow state, newFlow state)},
       {name=caseExpression, ty=UNIT},
       {name=globalState, ty=state},
       {name=granularity, ty=UNIT},
       (* 'a M -> ('a -> 'b M) -> 'b M *)
       {name=">>=", ty=FUN (MONAD (a,newFlow state, newFlow state),
            FUN (FUN (a', MONAD (b,newFlow state, newFlow state)),
               MONAD (b',newFlow state, newFlow state)))},
       {name="update", ty=FUN (FUN (state, state'), MONAD (d,state,state'))},
       {name="query", ty=FUN (FUN (state'', e), MONAD (e',state'',state'''))},
       {name="return", ty=FUN (c, MONAD (c',state'''',state''''))},
       {name="+", ty=vvv s1},
       {name="-", ty=vvv s2},
       {name="*", ty=vvv s3},
       {name="^", ty=FUN (VEC s4, FUN (VEC s5, VEC s6))},
       {name="bits8", ty=FUN (ZENO, VEC (CONST 8))},
       {name=Atom.toString Op.orElse, ty = vvv s7},
       {name=Atom.toString Op.andAlso, ty = vvv s8},
       {name="==", ty = vvb s9},
       {name="!=", ty = vvb s10},
       {name="not", ty = vv s11},
       {name="signed", ty=FUN (VEC s12, ZENO)},
       {name="unsigned", ty=FUN (VEC s13, ZENO)},
       {name="prefix", ty=FUN (VEC s14, VEC s15)},
       {name="suffix", ty=FUN (VEC s17, VEC s18)}
       ]

   val primitiveSizeConstraints =
      [SC.equality (tvar s6, [tvar s4,tvar s5], 0),
       SC.equality (tvar s14, [tvar s15,tvar s16], 0),
       SC.equality (tvar s17, [tvar s18,tvar s19], 0)
      ]

   val primitiveFlowConstraints =
      [BD.meetVarZero (bvar size),
       BD.meetVarImpliesVar (bvar state, bvar state'),
       BD.meetVarImpliesVar (bvar state'', bvar state'''),
       BD.meetVarImpliesVar (bvar a, bvar a'),
       BD.meetVarImpliesVar (bvar b, bvar b'),
       BD.meetVarImpliesVar (bvar c, bvar c'),
       BD.meetVarImpliesVar (bvar e, bvar e'),
       BD.meetVarZero (bvar s1),
       BD.meetVarZero (bvar s2),
       BD.meetVarZero (bvar s3),
       BD.meetVarZero (bvar s4),
       BD.meetVarZero (bvar s5),
       BD.meetVarZero (bvar s6),
       BD.meetVarZero (bvar s7),
       BD.meetVarZero (bvar s8),
       BD.meetVarZero (bvar s9),
       BD.meetVarZero (bvar s10),
       BD.meetVarZero (bvar s11),
       BD.meetVarZero (bvar s12),
       BD.meetVarZero (bvar s13),
       BD.meetVarZero (bvar s14),
       BD.meetVarZero (bvar s15),
       BD.meetVarZero (bvar s16),
       BD.meetVarZero (bvar s17),
       BD.meetVarZero (bvar s18),
       BD.meetVarZero (bvar s19)
      ]

   val primitiveDecoders =
      [{name=granularity, ty=size},
       {name="consume", ty=size},
       {name="prefix", ty=s16}, (* hack to get s16 expanded with s14,s15 *)
       {name="suffix", ty=s19}]

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
