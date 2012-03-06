
structure SplitDeclarations: sig
   type i = SpecAbstractTree.specification
   type valuedecl = SpecAbstractTree.valuedecl
   type decodedecl = SpecAbstractTree.decodedecl
   type o = (valuedecl list * decodedecl list) Spec.t
   val run: i -> o CompilationMonad.t
end = struct

   structure CM = CompilationMonad
   structure T = SpecAbstractTree
   type i = SpecAbstractTree.specification
   type valuedecl = SpecAbstractTree.valuedecl
   type decodedecl = SpecAbstractTree.decodedecl
   type o = (valuedecl list * decodedecl list) Spec.t

   fun split spec = let
      open T
      val granularity = ref (~1: IntInf.int)
      val state = ref [[]]
      val typealias = ref []
      val datatypes = ref []
      val valuedecls = ref []
      val decodedecls = ref []

      fun splitToplevel spec =
         case spec of
            MARKdecl t => splitToplevel (#tree t)
          | INCLUDEdecl _ => raise CM.CompilationError 
          | GRANULARITYdecl i => granularity := i
          | STATEdecl d => state := [d]
          | TYPEdecl d => typealias := d::(!typealias)
          | DECODEdecl d => decodedecls := d::(!decodedecls)
          | VALUEdecl d => valuedecls := d::(!valuedecls)
          | DATATYPEdecl (n, condecls) =>
               let
                  val cons = map grabCondecl condecls
               in
                  datatypes := (n, cons)::(!datatypes)
               end
      and grabCondecl decl =
         case decl of
            MARKcondecl t => grabCondecl (#tree t)
          | CONdecl d => d
   in
      Spec.IN
         {granularity= !granularity,
          state= hd(!state),
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
