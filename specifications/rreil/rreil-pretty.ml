# vim:filetype=sml:ts=3:sw=3:expandtab

# The following functions need to be defined elsewhere:
#   - show/arch

export = prettyrreil

val prettyrreil ss = showrreil/stmts ss

val showrreil/stmts ss =
   case ss of  
      SEM_NIL: ""
    | SEM_CONS x: showrreil/stmt x.hd +++ "\n" +++ showrreil/stmts x.tl
   end

val showrreil/stmt s =
   case s of
      SEM_ASSIGN x: showrreil/var x.lhs +++ " = " +++ showrreil/op x.rhs 
    | SEM_LOAD x: showrreil/var x.lhs +++ " = " showrreil/ptrderef x.size x.address
    | SEM_STORE x: "*" +++ showrreil/address x.address +++ " = " +++ showrreil/op x.rhs
    | SEM_LABEL x: showrreil/label x.id
    | SEM_IF_GOTO_LABEL x: "if (" +++ showrreil/linear x.cond +++ ") goto label " +++ showrreil/label x.label
    | SEM_IF_GOTO x: "if (" +++ showrreil/linear x.cond +++ ") goto " +++ showrreil/address x.target
    | SEM_CALL x: "if (" +++ showrreil/linear x.cond +++ ") call " +++ showrreil/address x.target
    | SEM_RETURN x: "if (" +++ showrreil/linear x.cond +++ ") return " +++ showrreil/address x.target
   end

val showrreil/label l = "l" +++ showint l +++ ":"

val showrreil/op op =
   case op of
      SEM_LIN x: showrreil/arity1 x
    | SEM_BSWAP x: "bswap" +++ showrreil/arity1 x
    | SEM_MUL x: "mul" +++ showrreil/arity2 x
    | SEM_DIV x: "div" +++ showrreil/arity2 x
    | SEM_DIVS x: "divs" +++ showrreil/arity2 x
    | SEM_MOD x: "mod" +++ showrreil/arity2 x
    | SEM_SHL x: "shl" +++ showrreil/arity2 x
    | SEM_SHR x: "shr" +++ showrreil/arity2 x
    | SEM_SHRS x: "shrs" +++ showrreil/arity2 x
    | SEM_AND x: "and" +++ showrreil/arity2 x
    | SEM_OR x: "or" +++ showrreil/arity2 x
    | SEM_XOR x: "xor" +++ showrreil/arity2 x
    | SEM_SX x: "sx[" +++ showint x.fromsize +++ "." +++ showint x.size +++ "](" +++ showrreil/linear x.opnd1 +++ ")"
    | SEM_ZX x: "zx[" +++ showint x.fromsize +++ "." +++ showint x.size +++ "](" +++ showrreil/linear x.opnd1 +++ ")"
    | SEM_CMPEQ x: "==" +++ showrreil/cmp x
    | SEM_CMPNEQ x: "/=" +++ showrreil/cmp x
    | SEM_CMPLES x: "<=s" +++ showrreil/cmp x
    | SEM_CMPLEU x: "<=u" +++ showrreil/cmp x
    | SEM_CMPLTS x: "<s" +++ showrreil/cmp x
    | SEM_CMPLTU x: "<u" +++ showrreil/cmp x
    | SEM_ARB x: "arbitrary[" +++ showint x +++ "]"
   end

val showrreil/arity1 x = "[" +++ showint x.size +++ "](" +++ showrreil/linear x.opnd1 +++ ")"
val showrreil/arity2 x = "[" +++ showint x.size +++ "](" +++ showrreil/linear x.opnd1 +++ "," +++ showrreil/linear x.opnd2 +++ ")"
val showrreil/cmp x = "[" +++ showint x.size +++ ".1](" +++ showrreil/linear x.opnd1 +++ "," +++ showrreil/linear x.opnd2 +++ ")"
val showrreil/ptrderef sz addr = "*[" +++ showint addr.size +++ "." +++ showint sz +++ "](" +++ showrreil/linear addr.address +++ ")"
val showrreil/address addr = "[" +++ showint addr.size +++ "](" +++ showrreil/linear addr.address +++ ")"
val showrreil/var x =
   case x.offset of
      0: showrreil/id x.id
    | o: showrreil/id x.id +++ "/" +++ showint o
   end

val showrreil/linear lin = 
   case lin of
      SEM_LIN_VAR x: showrreil/var x
    | SEM_LIN_IMM x: showint x.imm
    | SEM_LIN_ADD x: showrreil/linear x.opnd1 +++ "+" +++ showrreil/linear x.opnd2
    | SEM_LIN_SUB x: showrreil/linear x.opnd1 +++ "-" +++ showrreil/linear x.opnd2
    | SEM_LIN_SCALE x:
         case x.imm of
            0: ""
          | 1: showrreil/linear x.opnd
          | s: showint s +++ "*" +++ showrreil/linear x.opnd
         end
   end

val showrreil/id id =
   case id of
      ARCH_R x: show/arch x
    | VIRT_EQ: "EQ"
    | VIRT_NEQ: "NEQ"
    | VIRT_LES: "LES"
    | VIRT_LEU: "LEU"
    | VIRT_LTS: "LTS"
    | VIRT_LTU: "LTU"
    | VIRT_T x: "T" +++ showint x
   end
