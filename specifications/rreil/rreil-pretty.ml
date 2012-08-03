# vim:filetype=sml:ts=3:sw=3:expandtab

# The following functions need to be defined elsewhere:
#   - arch-show-id

export = rreil-pretty rreil-pretty-rev rreil-pretty-stmt

val rreil-pretty-stmt s = rreil-show-stmt s
val rreil-pretty ss = rreil-show-stmts ss
val rreil-pretty-rev ss = rreil-show-stmts (rreil-stmts-rev ss)

val rreil-show-stmts ss =
   case ss of  
      SEM_NIL: ""
    | SEM_CONS x: rreil-show-stmt x.hd +++ "\n" +++ rreil-show-stmts x.tl
   end

val rreil-show-stmt s =
   case s of
      SEM_ASSIGN x: rreil-show-var x.lhs +++ " = " +++ rreil-show-op x.rhs 
    | SEM_LOAD x: rreil-show-var x.lhs +++ " = " +++ rreil-show-ptrderef x.size x.address
    | SEM_STORE x: "*" +++ rreil-show-address x.address +++ " = " +++ rreil-show-op x.rhs
    | SEM_LABEL x: rreil-show-label x.label
    | SEM_IF_GOTO_LABEL x: "if (" +++ rreil-show-linear x.cond +++ ") goto label " +++ rreil-show-label x.label
    | SEM_IF_GOTO x: "if (" +++ rreil-show-linear x.cond +++ ") goto " +++ rreil-show-linear x.target
    | SEM_CALL x: "if (" +++ rreil-show-linear x.cond +++ ") call " +++ rreil-show-address x.target
    | SEM_RETURN x: "if (" +++ rreil-show-linear x.cond +++ ") return " +++ rreil-show-address x.target
   end

val rreil-show-label l = "l" +++ showint l +++ ":"

val rreil-show-op op =
   case op of
      SEM_LIN x: rreil-show-arity1 x
    | SEM_BSWAP x: "bswap" +++ rreil-show-arity1 x
    | SEM_MUL x: "mul" +++ rreil-show-arity2 x
    | SEM_DIV x: "div" +++ rreil-show-arity2 x
    | SEM_DIVS x: "divs" +++ rreil-show-arity2 x
    | SEM_MOD x: "mod" +++ rreil-show-arity2 x
    | SEM_SHL x: "shl" +++ rreil-show-arity2 x
    | SEM_SHR x: "shr" +++ rreil-show-arity2 x
    | SEM_SHRS x: "shrs" +++ rreil-show-arity2 x
    | SEM_AND x: "and" +++ rreil-show-arity2 x
    | SEM_OR x: "or" +++ rreil-show-arity2 x
    | SEM_XOR x: "xor" +++ rreil-show-arity2 x
    | SEM_SX x: "sx[" +++ showint x.fromsize +++ "." +++ showint x.size +++ "](" +++ rreil-show-linear x.opnd1 +++ ")"
    | SEM_ZX x: "zx[" +++ showint x.fromsize +++ "." +++ showint x.size +++ "](" +++ rreil-show-linear x.opnd1 +++ ")"
    | SEM_CMPEQ x: "==" +++ rreil-show-cmp x
    | SEM_CMPNEQ x: "/=" +++ rreil-show-cmp x
    | SEM_CMPLES x: "<=s" +++ rreil-show-cmp x
    | SEM_CMPLEU x: "<=u" +++ rreil-show-cmp x
    | SEM_CMPLTS x: "<s" +++ rreil-show-cmp x
    | SEM_CMPLTU x: "<u" +++ rreil-show-cmp x
    | SEM_ARB x: "arbitrary[" +++ showint x.size +++ "]"
   end

val rreil-show-arity1 x = "[" +++ showint x.size +++ "](" +++ rreil-show-linear x.opnd1 +++ ")"
val rreil-show-arity2 x = "[" +++ showint x.size +++ "](" +++ rreil-show-linear x.opnd1 +++ "," +++ rreil-show-linear x.opnd2 +++ ")"
val rreil-show-cmp x = "[" +++ showint x.size +++ ".1](" +++ rreil-show-linear x.opnd1 +++ "," +++ rreil-show-linear x.opnd2 +++ ")"
val rreil-show-ptrderef sz addr = "*[" +++ showint addr.size +++ "." +++ showint sz +++ "](" +++ rreil-show-linear addr.address +++ ")"
val rreil-show-address addr = "[" +++ showint addr.size +++ "](" +++ rreil-show-linear addr.address +++ ")"
val rreil-show-var x =
   case x.offset of
      0: rreil-show-id x.id
    | o: rreil-show-id x.id +++ "/" +++ showint o
   end

val rreil-show-linear lin = 
   case lin of
      SEM_LIN_VAR x: rreil-show-var x
    | SEM_LIN_IMM x: showint x.imm
    | SEM_LIN_ADD x: rreil-show-linear x.opnd1 +++ "+" +++ rreil-show-linear x.opnd2
    | SEM_LIN_SUB x: rreil-show-linear x.opnd1 +++ "-" +++ rreil-show-linear x.opnd2
    | SEM_LIN_SCALE x:
         case x.imm of
            0: ""
          | 1: rreil-show-linear x.opnd
          | s: showint s +++ "*" +++ rreil-show-linear x.opnd
         end
   end

val rreil-show-id id =
   case id of
      ARCH_R x: arch-show-id x
    | VIRT_EQ: "EQ"
    | VIRT_NEQ: "NEQ"
    | VIRT_LES: "LES"
    | VIRT_LEU: "LEU"
    | VIRT_LTS: "LTS"
    | VIRT_LTU: "LTU"
    | VIRT_T x: "T" +++ showint x
   end
