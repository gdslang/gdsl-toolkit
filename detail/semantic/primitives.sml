
structure Primitives = struct
   structure ST = SymbolTables
   structure SC = SizeConstraint
   open Types
   
   (* result type of the decoder function *)
   val size = freshVar ()
   val stateA = freshVar ()
   val stateA' = newFlow stateA
   val stateB = freshVar ()
   val stateB' = newFlow stateB
   val stateC = freshVar ()
   val stateC' = newFlow stateC
   val stateD = freshVar ()
   val stateD' = newFlow stateD
   val stateE = freshVar ()
   val stateE' = freshVar ()
   val stateE'' = newFlow stateE'
   val stateE''' = freshVar ()
   val stateE'''' = newFlow stateE
   val stateE''''' = newFlow stateE'''
   val stateF = freshVar ()
   val stateF' = freshVar ()
   val stateF'' = newFlow stateF'
   val stateF''' = freshVar ()
   val stateF'''' = newFlow stateF
   val stateF''''' = newFlow stateF'''
   val stateG = freshVar ()
   val stateG' = newFlow stateG
   val stateH = freshVar ()
   val stateH' = freshVar ()
   val stateH'' = newFlow stateH
   val stateH''' = newFlow stateH'
   val stateI = freshVar ()
   val stateI' = newFlow stateI
   val stateI'' = newFlow stateI
   val stateJ = freshVar ()
   val stateJ' = newFlow stateJ
   val stateK = freshVar ()
   val stateK' = newFlow stateK
   val stateL = freshVar ()
   val stateL' = newFlow stateL
   val a = freshVar ()
   val a' = newFlow a
   val b = freshVar ()
   val b' = newFlow b
   val c = freshVar ()
   val d = freshVar ()
   val d' = newFlow d
   val e = freshVar ()
   val e' = newFlow e
   val f = freshVar ()
   val g = freshVar ()
   val g' = newFlow g
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

   (*create a type from two vectors to one vector, all of size s*)
   fun vvv s = FUN (VEC s, FUN (VEC s, VEC s))
   fun vv  s = FUN (VEC s, VEC s)
   fun vvb s = FUN (VEC s, FUN (VEC s, VEC (CONST 1)))

   val granularity : string = "stream granularity"
   val globalState : string = "global state"
   val caseExpression : string = "case expression"
   fun noFlow bFun = bFun

   val primitiveValues =
      [{name="true", ty=VEC (CONST 1),
        flow = noFlow},
       {name="false", ty=VEC (CONST 1),
        flow = noFlow},
       {name="consume", ty=MONAD (VEC size,stateA, stateA'),
        flow = BD.meetVarZero (bvar size) o
               BD.meetVarImpliesVar (bvar stateA', bvar stateA)},
       {name="unconsume", ty=MONAD (UNIT,stateB, stateB'),
        flow = BD.meetVarImpliesVar (bvar stateB', bvar stateB)}, 
       {name="slice", ty=MONAD (freshVar (),stateC, stateC'),
        flow = BD.meetVarImpliesVar (bvar stateC', bvar stateC)},
       {name="raise", ty=MONAD (freshVar (),stateD, stateD'),
        flow = noFlow},
       {name=caseExpression, ty=UNIT,
        flow = noFlow},
       (*{name=globalState, ty=state,
        flow = noFlow},*)
       {name=granularity, ty=UNIT,
        flow = noFlow},
       (* 'a M -> ('a -> 'b M) -> 'b M *)
       {name=">>=", ty=FUN (MONAD (a, stateE, stateE'),
            FUN (FUN (a', MONAD (b,stateE'', stateE''')),
               MONAD (b', stateE'''', stateE'''''))),
        flow = BD.meetVarImpliesVar (bvar a', bvar a) o
               BD.meetVarImpliesVar (bvar b', bvar b) o
               BD.meetVarImpliesVar (bvar stateE, bvar stateE'''') o
               BD.meetVarImpliesVar (bvar stateE'', bvar stateE') o
               BD.meetVarImpliesVar (bvar stateE''''', bvar stateE''') },
       (* 'f M -> 'g M -> 'g M *)
       {name=">>", ty=FUN (MONAD (c, stateF, stateF'),
            FUN (MONAD (d,stateF'', stateF'''),
               MONAD (d', stateF'''', stateF'''''))),
        flow = BD.meetVarImpliesVar (bvar d', bvar d) o
               BD.meetVarImpliesVar (bvar stateF, bvar stateF'''') o
               BD.meetVarImpliesVar (bvar stateF'', bvar stateF') o
               BD.meetVarImpliesVar (bvar stateF''''', bvar stateF''') },
       {name="return", ty=FUN (e, MONAD (e',stateG,stateG')),
        flow = BD.meetVarImpliesVar (bvar e', bvar e) o
               BD.meetVarImpliesVar (bvar stateG', bvar stateG) },
       {name="update", ty=FUN (FUN (stateH, stateH'),
                               MONAD (UNIT,stateH'',stateH''')),
        flow = BD.meetVarImpliesVar (bvar stateH, bvar stateH'') o
               BD.meetVarImpliesVar (bvar stateH''', bvar stateH') },
       {name="query", ty=FUN (FUN (stateI', g), MONAD (g',stateI,stateI'')),
        flow = BD.meetVarImpliesVar (bvar g', bvar g) o
               BD.meetVarImpliesVar (bvar stateI', bvar stateI) o
               BD.meetVarImpliesVar (bvar stateI'', bvar stateI) },
       {name="+", ty=vvv s1,
        flow = BD.meetVarZero (bvar s1)},
       {name="-", ty=vvv s2,
        flow = BD.meetVarZero (bvar s2)},
       {name="*", ty=vvv s3,
        flow = BD.meetVarZero (bvar s3)},
       {name="^", ty=FUN (VEC s4, FUN (VEC s5, VEC s6)),
        flow = BD.meetVarZero (bvar s4) o
               BD.meetVarZero (bvar s5) o
               BD.meetVarZero (bvar s6)},
       {name="bits8", ty=FUN (ZENO, VEC (CONST 8)),
        flow = noFlow},
       {name=Atom.toString Op.orElse, ty = vvv s7,
        flow = BD.meetVarZero (bvar s7)},
       {name=Atom.toString Op.andAlso, ty = vvv s8,
        flow = BD.meetVarZero (bvar s8)},
       {name="==", ty = vvb s9,
        flow = BD.meetVarZero (bvar s9)},
       {name="!=", ty = vvb s10,
        flow = BD.meetVarZero (bvar s10)},
       {name="not", ty = vv s11,
        flow = BD.meetVarZero (bvar s11)},
       {name="signed", ty=FUN (VEC s12, ZENO),
        flow = BD.meetVarZero (bvar s12)},
       {name="unsigned", ty=FUN (VEC s13, ZENO),
        flow = BD.meetVarZero (bvar s13)},
       {name="prefix", ty=FUN (VEC s14, VEC s15),
        flow = BD.meetVarZero (bvar s14) o
               BD.meetVarZero (bvar s15) o
               BD.meetVarZero (bvar s16)},
       {name="suffix", ty=FUN (VEC s17, VEC s18),
        flow = BD.meetVarZero (bvar s17) o
               BD.meetVarZero (bvar s18) o
               BD.meetVarZero (bvar s19)},
       {name="%consume", ty=MONAD (VEC size,stateJ, stateJ'),
        flow = BD.meetVarZero (bvar size) o
               BD.meetVarImpliesVar (bvar stateJ', bvar stateJ)},
       {name="%unconsume", ty=MONAD (UNIT,stateK, stateK'),
        flow = BD.meetVarImpliesVar (bvar stateK', bvar stateK)}, 
       {name="%slice", ty=MONAD (freshVar (),stateL, stateL'),
        flow = BD.meetVarImpliesVar (bvar stateL', bvar stateL)}
       ]

   val primitiveSizeConstraints =
      [SC.equality (tvar s6, [tvar s4,tvar s5], 0),
       SC.equality (tvar s14, [tvar s15,tvar s16], 0),
       SC.equality (tvar s17, [tvar s18,tvar s19], 0)
      ]

   val primitiveDecoders =
      [{name=granularity, ty=size},
       {name="consume", ty=size},
       {name="prefix", ty=s16}, (* hack to get s16 expanded with s14,s15 *)
       {name="suffix", ty=s19}]

   val primitiveTypes =
      [{name="int", ty=ZENO, flow=noFlow},
       {name="string", ty=FLOAT, flow=noFlow}]

   fun addPrim table {name, ty, flow} = let
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

         fun genInfo {name=n, ty=t, flow=f} =
            (SymbolTable.lookup(!ST.varTable, Atom.atom n),
             t,
             f,
             find n primitiveDecoders)
      in
         List.map genInfo primitiveValues
      end
end                                                       
