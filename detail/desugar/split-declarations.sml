
structure SplitDeclarations : sig
   type sym = VarInfo.symid
   type pat = SpecAbstractTree.decodepat
   type exp = SpecAbstractTree.exp
   type i = SpecAbstractTree.specification
   type value = sym * sym list * exp
   type decode = pat list * (exp, (exp * exp) list) Sum.t
   type o = (value list * decode list SymMap.map) Spec.t
   val run: i -> o CompilationMonad.t
   val layout: (value list * decode list SymMap.map) -> Layout.layout
end = struct

   structure CM = CompilationMonad
   structure AST = SpecAbstractTree
   type sym = VarInfo.symid
   type i = SpecAbstractTree.specification
   type pat = SpecAbstractTree.decodepat
   type exp = SpecAbstractTree.exp
   type value = sym * sym list * exp
   type decode = pat list * (exp, (exp * exp) list) Sum.t
   type o = (value list * decode list SymMap.map) Spec.t

   fun split {span, tree} = let
      open AST
      val granularity = ref (~1: IntInf.int)
      val typealias = ref []
      val datatypes = ref []
      val constructors = ref SymMap.empty
      val valuedecls = ref []
      val decodedecls = ref SymMap.empty
      val exports = ref []

      fun insertDecode (n, pats, es) =
         decodedecls :=
            SymMap.unionWith
               op@
               (!decodedecls, SymMap.singleton (n, [(pats, es)]))

      fun updateConstructors (n, cons) = let
         fun updateCons (c, optTy) =
            case SymMap.find (!constructors, c) of
               NONE =>
                  constructors :=
                     SymMap.insert (!constructors, c, (n, optTy))
             | _ => raise CM.CompilationError
      in
         app updateCons cons
      end

      fun splitToplevel spec =
         case spec of
            MARKdecl t => splitToplevel (#tree t)
          | INCLUDEdecl _ => raise CM.CompilationError 
          | GRANULARITYdecl i => granularity := i
          | TYPEdecl d => typealias := d::(!typealias)
          | DECODEdecl d => insertDecode d
          | LETRECdecl d => valuedecls := d::(!valuedecls)
          | EXPORTdecl es => exports := !exports@es
          | DATATYPEdecl (n, cons) =>
               (datatypes := (n, cons)::(!datatypes)
               ;updateConstructors (n, cons))
                  
   in
      app splitToplevel tree
     ;Spec.IN
         {granularity= !granularity,
          exports= !exports,
          typealias= rev (!typealias),
          datatypes= rev (!datatypes),
          constructors= !constructors,
          declarations= (rev (!valuedecls), !decodedecls)}
   end

   fun dumpPre (os, spec) = AST.PP.prettyTo (os, spec)

   fun layout (vs, ds) = let
      open Layout Pretty
      fun dec n (pats, e) =
         AST.PP.decl
            (AST.DECODEdecl (n, pats, e))
      fun decs (n, ds, acc) = map (dec n) ds @ acc
      fun letrec (n, pats, e) =
         AST.PP.decl
            (AST.LETRECdecl (n, pats, e))
   in
      align
         [align (SymMap.foldli decs [] ds),
          align (map letrec vs)]
   end

   fun dumpPost (os, spec) = Pretty.prettyTo (os, Spec.PP.spec layout spec)

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
