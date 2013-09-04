
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
   val stateM = freshVar ()
   val stateM' = newFlow stateM
   val stateN = freshVar ()
   val stateN' = newFlow stateN
   val stateO = freshVar ()
   val stateO' = newFlow stateO
   val stateP = freshVar ()
   val stateP' = newFlow stateP
   val a = freshVar ()
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
   val h = freshVar ()
   val i = freshVar ()
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
   val content = freshVar ()
   val content' = newFlow content
   val content'' = newFlow content
   val content''' = newFlow content
   val content'''' = newFlow content
   val inp = freshVar ()
   val out = freshVar ()

   (*create a type from two vectors to one vector, all of size s*)
   fun func (a,b) = FUN ([a],b)
   fun vvv s = FUN ([VEC s, VEC s], VEC s)
   fun vv  s = FUN ([VEC s], VEC s)
   fun vvb s = FUN ([VEC s, VEC s], VEC (CONST 1))

   val granularity : string = "stream granularity"
   val globalState : string = "global state"
   val caseExpression : string = "case expression"
   val streamField : string = "input stream"

   fun noFlow bFun = bFun

   val primitiveValues =
      [{name="true", ty=VEC (CONST 1),
        flow = noFlow},
       {name="false", ty=VEC (CONST 1),
        flow = noFlow},
       {name="consume8", ty=MONAD (VEC size,stateA, stateA'),
        flow = BD.meetVarZero (bvar size) o
               BD.meetVarImpliesVar (bvar stateA', bvar stateA)},
       {name="unconsume8", ty=MONAD (UNIT,stateB, stateB'),
        flow = BD.meetVarImpliesVar (bvar stateB', bvar stateB)}, 
       {name="consume16", ty=MONAD (VEC size,stateA, stateA'),
        flow = BD.meetVarZero (bvar size) o
               BD.meetVarImpliesVar (bvar stateA', bvar stateA)},
       {name="unconsume16", ty=MONAD (UNIT,stateB, stateB'),
        flow = BD.meetVarImpliesVar (bvar stateB', bvar stateB)}, 
       {name="consume32", ty=MONAD (VEC size,stateA, stateA'),
        flow = BD.meetVarZero (bvar size) o
               BD.meetVarImpliesVar (bvar stateA', bvar stateA)},
       {name="unconsume32", ty=MONAD (UNIT,stateB, stateB'),
        flow = BD.meetVarImpliesVar (bvar stateB', bvar stateB)}, 
       {name="slice", ty=MONAD (freshVar (),stateC, stateC'),
        flow = BD.meetVarImpliesVar (bvar stateC', bvar stateC)},
       {name="raise", ty=MONAD (freshVar (),stateD, stateD'),
        flow = noFlow},
       {name="idxget", ty=MONAD (ZENO, stateM, stateM'),
        flow = BD.meetVarImpliesVar (bvar stateM', bvar stateM)},
       {name="rseek", ty=func (ZENO, MONAD (ZENO, stateN, stateN')),
        flow = BD.meetVarImpliesVar (bvar stateN', bvar stateN)},
       {name="seek", ty=func (ZENO, MONAD (ZENO, stateO, stateO')),
        flow = BD.meetVarImpliesVar (bvar stateO', bvar stateO)},
       {name="/z", ty=FUN([ZENO, ZENO],ZENO),flow=noFlow},
       {name="index", ty=func (h, ZENO), flow = noFlow},
       {name="puts", ty=func (i, MONAD (ZENO, stateL, stateL')),
         flow = BD.meetVarImpliesVar (bvar stateL', bvar stateL)},
       {name="%raise", ty=UNIT, flow = noFlow},
       {name="%and", ty=UNIT, flow = noFlow},
       {name="%or", ty=UNIT, flow = noFlow},
       {name="%sx", ty=UNIT, flow = noFlow},
       {name="%zx", ty=UNIT, flow = noFlow},
       {name="%addi", ty=UNIT, flow = noFlow},
       {name="%subi", ty=UNIT, flow = noFlow},
       {name="%eqi", ty=UNIT, flow = noFlow},
       {name="%muli", ty=UNIT, flow = noFlow},
       {name="%lti", ty=UNIT, flow = noFlow},
       {name="%lei", ty=UNIT, flow = noFlow},
       {name="%not", ty=UNIT, flow = noFlow},
       {name="%equal", ty=UNIT, flow = noFlow},
       {name="%concat", ty=UNIT, flow = noFlow},
       {name="showint", ty=FUN([ZENO],STRING), flow = noFlow},
       {name="%showint", ty=FUN([ZENO],STRING), flow = noFlow},
       {name=caseExpression, ty=UNIT,
        flow = noFlow},
       (*{name=globalState, ty=state,
        flow = noFlow},*)
       {name=granularity, ty=UNIT,
        flow = noFlow},
       (* 'a M -> ('a -> 'b M) -> 'b M *)
       {name=">>=", ty=func (MONAD (a, stateE, stateE'),
            func (func (a', MONAD (b,stateE'', stateE''')),
               MONAD (b', stateE'''', stateE'''''))),
        flow = BD.meetVarImpliesVar (bvar a', bvar a) o
               BD.meetVarImpliesVar (bvar b', bvar b) o
               BD.meetVarImpliesVar (bvar stateE, bvar stateE'''') o
               BD.meetVarImpliesVar (bvar stateE'', bvar stateE') o
               BD.meetVarImpliesVar (bvar stateE''''', bvar stateE''') },
       (* 'f M -> 'g M -> 'g M *)
       {name=">>", ty=func (MONAD (c, stateF, stateF'),
            func (MONAD (d,stateF'', stateF'''),
               MONAD (d', stateF'''', stateF'''''))),
        flow = BD.meetVarImpliesVar (bvar d', bvar d) o
               BD.meetVarImpliesVar (bvar stateF, bvar stateF'''') o
               BD.meetVarImpliesVar (bvar stateF'', bvar stateF') o
               BD.meetVarImpliesVar (bvar stateF''''', bvar stateF''') },
       {name="return", ty=func (e, MONAD (e',stateG,stateG')),
        flow = BD.meetVarImpliesVar (bvar e', bvar e) o
               BD.meetVarImpliesVar (bvar stateG', bvar stateG) },
       {name="update", ty=func (func (stateH, stateH'),
                               MONAD (UNIT,stateH'',stateH''')),
        flow = BD.meetVarImpliesVar (bvar stateH, bvar stateH'') o
               BD.meetVarImpliesVar (bvar stateH''', bvar stateH') },
       {name="query", ty=func (func (stateI', g), MONAD (g',stateI,stateI'')),
        flow = BD.meetVarImpliesVar (bvar g', bvar g) o
               BD.meetVarImpliesVar (bvar stateI', bvar stateI) o
               BD.meetVarImpliesVar (bvar stateI'', bvar stateI) },
       {name="+", ty=FUN([ZENO,ZENO],ZENO),flow=noFlow},
       {name="-", ty=FUN([ZENO,ZENO],ZENO),flow=noFlow},
       {name="*", ty=FUN([ZENO,ZENO],ZENO),flow=noFlow},
       {name="<", ty=FUN([ZENO,ZENO],VEC (CONST 1)),flow=noFlow},
       {name=">", ty=FUN([ZENO,ZENO],VEC (CONST 1)),flow=noFlow},
       {name="<=", ty=FUN([ZENO,ZENO],VEC (CONST 1)),flow=noFlow},
       {name=">=", ty=FUN([ZENO,ZENO],VEC (CONST 1)),flow=noFlow},
       {name="===", ty=FUN([ZENO,ZENO],VEC (CONST 1)),flow=noFlow},
       {name="++", ty=vvv s1,
        flow = BD.meetVarZero (bvar s1)},
       {name="--", ty=vvv s2,
        flow = BD.meetVarZero (bvar s2)},
       {name="**", ty=vvv s3,
        flow = BD.meetVarZero (bvar s3)},
       {name="strlen", ty=FUN([STRING], ZENO), flow = noFlow},
       {name="strcat", ty=FUN([STRING,STRING,ZENO], STRING), flow = noFlow},
       {name="^", ty=FUN ([VEC s4, VEC s5], VEC s6),
        flow = BD.meetVarZero (bvar s4) o
               BD.meetVarZero (bvar s5) o
               BD.meetVarZero (bvar s6)},
       {name="bits8", ty=func (ZENO, VEC (CONST 8)),
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
       {name="sx", ty=func (VEC s12, ZENO),
        flow = BD.meetVarZero (bvar s12)},
       {name="zx", ty=func (VEC s13, ZENO),
        flow = BD.meetVarZero (bvar s13)},
       {name="prefix", ty=func (VEC s14, VEC s15),
        flow = BD.meetVarZero (bvar s14) o
               BD.meetVarZero (bvar s15) o
               BD.meetVarZero (bvar s16)},
       {name="suffix", ty=func (VEC s17, VEC s18),
        flow = BD.meetVarZero (bvar s17) o
               BD.meetVarZero (bvar s18) o
               BD.meetVarZero (bvar s19)},
       {name="%concatstring", ty=UNIT, flow = noFlow},
       {name="%consume8", ty=UNIT, flow = noFlow},
       {name="%unconsume8", ty=UNIT, flow = noFlow},
       {name="%consume16", ty=UNIT, flow = noFlow},
       {name="%unconsume16", ty=UNIT, flow = noFlow},
       {name="%consume32", ty=UNIT, flow = noFlow},
       {name="%unconsume32", ty=UNIT, flow = noFlow},
       {name="%slice", ty=UNIT, flow = noFlow},
       {name="%idxget", ty=UNIT, flow = noFlow},
       {name="%rseek", ty=UNIT, flow = noFlow},
       {name="%seek", ty=UNIT, flow = noFlow},
       {name="%invoke", ty=UNIT, flow = noFlow},
       {name="%invoke_int", ty=UNIT, flow = noFlow},
       {name="%index", ty=UNIT, flow = noFlow},
       {name="%puts", ty=UNIT, flow = noFlow},
       {name="vcase", ty=FUN ([VEC inp, content',
         FUN ([content'', VEC out], content''')], content''''),
         flow = BD.meetVarImpliesVar (bvar content'''', bvar content') o
                BD.meetVarImpliesVar (bvar content'''', bvar content''') o
                BD.meetVarImpliesVar (bvar content'', bvar content')},
       {name="void", ty=UNIT, flow = noFlow}
       ]

   val primitiveSizeConstraints =
      [SC.equality (tvar s6, [tvar s4,tvar s5], 0),
       SC.equality (tvar s14, [tvar s15,tvar s16], 0),
       SC.equality (tvar s17, [tvar s18,tvar s19], 0),
       SC.equality (tvar out, [tvar inp], 1)
      ]

   val primitiveDecoders =
      [{name=granularity, ty=size},
       {name="consume", ty=size},
       {name="prefix", ty=s16}, (* hack to get s16 expanded with s14,s15 *)
       {name="suffix", ty=s19}]

   val primitiveTypes =
      [{name="int", ty=ZENO, flow=noFlow},
       {name="float", ty=FLOAT, flow=noFlow},
       {name="unit", ty=UNIT, flow=noFlow},
       {name="string", ty=STRING, flow=noFlow}]

   val primitiveFields =
      [{name=streamField, ty=UNIT, flow=noFlow}]
      
   fun addPrim table {name, ty, flow} = let
      val (newTable, _) =
         SymbolTable.create
            (!table,
             Atom.atom name,
             SymbolTable.noSpan)
   in
      table := newTable
   end

   (* a table detailing how to translate primitives into imp: for each name, returns
      a tuple with the type of the returned expression and a marshaller that processes
      the arguments that given to the primitive *)
   val prim_map = ref (SymMap.empty : (Imp.vtype * (Imp.exp list -> Imp.exp)) SymMap.map)
   val prim_val_map = ref (SymMap.empty : Imp.exp SymMap.map)
   
   val prim_table =
      let
         open Imp
         exception ImpPrimTranslationBug
         fun pr (prim,ty,args) = PRIexp (prim, ty, args)
         fun action e = STATEexp (BASICblock ([],[]), OBJvtype, e)
         fun unboxI args = map (fn arg => UNBOXexp (INTvtype, arg)) args
         fun unboxV args = map (fn arg => VEC2INTexp (SOME 1,UNBOXexp (VECvtype, arg))) args
         fun unboxVfixed args = map (fn arg => VEC2INTexp (NONE,UNBOXexp (VECvtype, arg))) args
         fun unboxV args = map (fn arg => UNBOXexp (VECvtype, arg)) args
         fun boxI arg = BOXexp (INTvtype, arg)
         fun boxV1 arg = BOXexp (VECvtype, INT2VECexp (1,arg))
         fun boxV8 arg = BOXexp (VECvtype, INT2VECexp (8,arg))
         fun boxV16 arg = BOXexp (VECvtype, INT2VECexp (16,arg))
         fun boxV32 arg = BOXexp (VECvtype, INT2VECexp (32,arg))
         fun boxV arg = BOXexp (VECvtype, arg)
         fun ftype args res = FUNvtype (res, false, args)
         val iii = ftype [INTvtype, INTvtype] INTvtype
         val vvv = ftype [VECvtype, VECvtype] VECvtype
         val sv =  ftype [STRINGvtype] VOIDvtype
         val bi = ftype [VECvtype] INTvtype
         val iib = ftype [INTvtype, INTvtype] VECvtype
         val bb = ftype [VECvtype] VECvtype
         val is = ftype [INTvtype] STRINGvtype
         val bs = ftype [VECvtype] STRINGvtype
         val iiib = ftype [INTvtype, INTvtype, INTvtype] VECvtype
         val ov = ftype [OBJvtype] VOIDvtype
         val ii = ftype [INTvtype] INTvtype
         val oi = ftype [OBJvtype] INTvtype
         val oio = ftype [OBJvtype, INTvtype] OBJvtype
         val oo = ftype [OBJvtype] OBJvtype
         val oos = ftype [OBJvtype, OBJvtype] STRINGvtype
         val o_ = ftype [] OBJvtype
         val ssis = ftype [STRINGvtype, STRINGvtype, INTvtype] STRINGvtype
         val si =  ftype [STRINGvtype] INTvtype
         val i = ftype [] INTvtype
         val v = ftype [] VOIDvtype
         val fMv = ftype [ftype [OBJvtype] OBJvtype] (MONADvtype VOIDvtype)
         (* Generate type of the returned expression. The value that this
            function is called with indicates the number of arguments. *)
         fun genType (ret, n) =
            FUNvtype (ret, false, List.tabulate (n, fn _ => VOIDvtype))
         fun t n = if n=0 then MONADvtype VOIDvtype else
                   if n>0 then genType (VOIDvtype, n) else
                               genType (MONADvtype VOIDvtype, ~n)
      in [
         ("raise", (t ~1, fn args => action (PRIexp (RAISEprim,sv,args)))),
         ((Atom.toString Op.andAlso), (t 2, fn args => boxV1 (pr (ANDprim,iii,unboxVfixed args)))),
         ((Atom.toString Op.orElse), (t 2, fn args => boxV1 (pr (ORprim,iii,unboxVfixed args)))),
         ("sx", (t 1, fn args => boxI (pr (SIGNEDprim,bi,unboxV args)))),
         ("zx", (t 1, fn args => boxI (pr (UNSIGNEDprim,bi,unboxV args)))),
         ("+", (t 2, fn args => boxI (pr (ADDprim,iii,unboxI args)))),
         ("-", (t 2, fn args => boxI (pr (SUBprim,iii,unboxI args)))),
         ("===", (t 2, fn args => boxV1 (pr (EQprim,iii,unboxI args)))),
         ("*", (t 2, fn args => boxI (pr (MULprim,iii,unboxI args)))),
         ("<", (t 2, fn args => boxV1 (pr (LTprim,iii,unboxI args)))),
         (">", (t 2, fn args => boxV1 (pr (LTprim,iii,unboxI (rev args))))),
         ("<=", (t 2, fn args => boxV1 (pr (LEprim,iii,unboxI args)))),
         (">=", (t 2, fn args => boxV1 (pr (LEprim,iii,unboxI (rev args))))),
         ("not", (t 1, fn args => boxV (pr (NOT_VECprim,bb,unboxV args)))),
         ("==", (t 2, fn args => boxV1 (pr (EQ_VECprim,iii,unboxVfixed args)))),
         ("^", (t 2, fn args => boxV (pr (CONCAT_VECprim,vvv,unboxV args)))),
         ("showint", (t 1, fn args => pr (INT_TO_STRINGprim,is,unboxI args))),
         ("strlen", (t 1, fn args => boxV (pr (STRLENprim,si,args)))),
         ("strcat", (t 3, fn args => (case args of
            [src,tgt,size] => pr (CONCAT_STRINGprim,ssis,[src,tgt,UNBOXexp (INTvtype, size)])
          | _ => raise ImpPrimTranslationBug))),
         ("slice", (t ~3, fn args => (case args of
            [vec,ofs,sz] => action (boxV (PRIexp (SLICEprim,iiib,unboxVfixed [vec] @ unboxI [ofs,sz])))
          | _ => raise ImpPrimTranslationBug))),
         ("index", (t 1, fn args => boxI (pr (GET_CON_IDXprim,oi,args)))),
         ("query", (t 1, fn args => (case args of
            [f] => action (INVOKEexp (ov, f,[PRIexp (GETSTATEprim, o_, [])]))
          | _ => raise ImpPrimTranslationBug))),
         ("update", (fMv, fn args => (case args of
            [f] => action (PRIexp (SETSTATEprim, ov, [
                  INVOKEexp (oo, f,[PRIexp (GETSTATEprim, o_, [])]) 
               ]))
          | _ => raise ImpPrimTranslationBug))),
         ("idxget", (t 0, fn args => action (boxI (PRIexp (IPGETprim,i,args))))),
         ("seek", (t 0, fn args => action (boxI (PRIexp (SEEKprim,ii,unboxI args))))),
         ("rseek", (t 0, fn args => action (boxI (PRIexp (RSEEKprim,ii,unboxI args))))),
         ("/z", (t 2, fn args => boxI (pr (DIVprim,iii,unboxI args)))),
         ("consume8", (t 0, fn args => action (boxV8 (PRIexp (CONSUME8prim,i,args))))),
         ("consume16", (t 0, fn args => action (boxV16 (PRIexp (CONSUME16prim,i,args))))),
         ("consume32", (t 0, fn args => action (boxV32 (PRIexp (CONSUME32prim,i,args))))),
         ("unconsume8", (t 0, fn args => action (PRIexp (UNCONSUME8prim,v,args)))),
         ("unconsume16", (t 0, fn args => action (PRIexp (UNCONSUME16prim,v,args)))),
         ("unconsume32", (t 0, fn args => action (PRIexp (UNCONSUME32prim,v,args)))),
         ("puts", (t ~1, fn args => action (PRIexp (PRINTLNprim,ov,args)))),
         ("return", (t ~1, fn args => (case args of
            [e] => action e
          | _ => raise ImpPrimTranslationBug)))
         ]
      end

   val prim_val_table =
      let
         open Imp
      in
         [
         ("void", PRIexp (VOIDprim, VOIDvtype, []))
         ]
      end

   fun registerPrimitives () =
      (ST.varTable := VarInfo.empty
      ;ST.conTable := ConInfo.empty
      ;ST.typeTable := TypeInfo.empty
      ;ST.fieldTable := FieldInfo.empty
      ;app (addPrim ST.fieldTable) primitiveFields
      ;app (addPrim ST.varTable) primitiveValues
      ;app (addPrim ST.typeTable) primitiveTypes
      ;prim_map :=
      let
         fun get s = VarInfo.lookup (!ST.varTable, Atom.atom s)
         fun insTrans ((k,v),m) = SymMap.insert (m,get k,v)
      in
         foldl insTrans SymMap.empty prim_table
      end
      ;prim_val_map :=
      let
         fun get s = VarInfo.lookup (!ST.varTable, Atom.atom s)
         fun insTrans ((k,v),m) = SymMap.insert (m,get k,v)
      in
         foldl insTrans SymMap.empty prim_val_table
      end
      )
   
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
