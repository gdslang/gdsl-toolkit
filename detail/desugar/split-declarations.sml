
structure SplitDeclarations: sig
   type sym = VarInfo.symid
   type pat = SpecAbstractTree.decodepat
   type exp = SpecAbstractTree.exp
   type i = SpecAbstractTree.specification
   type valuedecl = sym * sym list * exp
   type decodedecl = sym * pat list * (exp, (exp * exp) list) Sum.t
   type o = (valuedecl list * decodedecl list) Spec.t
   val run: i -> o CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure T = SpecAbstractTree
   type sym = VarInfo.symid
   type i = SpecAbstractTree.specification
   type pat = SpecAbstractTree.decodepat
   type exp = SpecAbstractTree.exp
   type valuedecl = sym * sym list * exp
   type decodedecl = sym * pat list * (exp, (exp * exp) list) Sum.t
   type o = (valuedecl list * decodedecl list) Spec.t

   fun split {span, tree} = let
      open T
      val granularity = ref (~1: IntInf.int)
      val state = ref [[]]
      val typealias = ref []
      val datatypes = ref []
      val valuedecls = ref []
      val decodedecls = ref []
      val exports = ref []

      fun splitToplevel spec =
         case spec of
            MARKdecl t => splitToplevel (#tree t)
          | INCLUDEdecl _ => raise CM.CompilationError 
          | GRANULARITYdecl i => granularity := i
          | STATEdecl d => state := [d]
          | TYPEdecl d => typealias := d::(!typealias)
          | DECODEdecl d => decodedecls := d::(!decodedecls)
          | LETRECdecl d => valuedecls := d::(!valuedecls)
          | EXPORTdecl es => exports := !exports@es
          | DATATYPEdecl (n, cons) => datatypes := (n, cons)::(!datatypes)

   in
      app splitToplevel tree
     ;Spec.IN
         {granularity= !granularity,
          state= hd(!state),
          exports= !exports,
          typealias= rev (!typealias),
          datatypes= rev (!datatypes),
          declarations= (rev (!valuedecls), rev (!decodedecls))}
   end

   fun dumpPre (os, spec) = T.PP.prettyTo (os, spec)
   fun dumpPost (os, spec) = Spec.PP.prettyTo Spec.PP.prettyDecls (os, spec)

   val split =
      BasicControl.mkKeepPass
         {passName="splitDeclarations",
          registry=DesugarControl.registry,
          pass=split,
          preExt="ast",
          preOutput=dumpPre,
          postExt="ast",
          postOutput=dumpPost}

   fun run spec = let
      open CompilationMonad
   in
      return (split spec)
   end
end
