# vim:filetype=sml:ts=3:sw=3:expandtab

# The following functions need to be defined elsewhere:
#   - arch-show-id

export = rreil-pretty

val rreil-pretty-stmt s = rreil-show-stmt s
val rreil-pretty ss = rreil-show-stmts ss
val rreil-pretty-rev ss = rreil-show-stmts (rreil-stmts-rev ss)

val rreil-show-stmts ss =
   case ss of  
      SEM_NIL: ""
    | SEM_CONS x: rreil-show-stmt x.hd +++ "\n" +++ rreil-show-stmts x.tl
   end

val rreil-show-varl v = rreil-show-var v +++ ":" +++ show-int v.size

val rreil-show-varls vs = let
  val show-inner vs =
    case vs of
       SEM_VARLS_CONS c: ", " +++ rreil-show-varl c.hd +++ show-inner c.tl
     | SEM_VARLS_NIL: ""
    end
in
  case vs of
     SEM_VARLS_CONS c: case c.tl of
          SEM_VARLS_CONS d: "(" +++ rreil-show-varl c.hd +++ show-inner c.tl +++ ")"
        | SEM_VARLS_NIL: rreil-show-varl c.hd
       end
     | SEM_VARLS_NIL: "(void)"
  end
end

val rreil-show-flop f =
  case f of
     SEM_FADD: "FADD"
   | SEM_FSUB: "FSUB"
   | SEM_FMUL: "FMUL"
  end

val rreil-show-stmt s =
  case s of
     SEM_ASSIGN x: rreil-show-var x.lhs +++ " = " +++ rreil-show-expr x.rhs 
   | SEM_LOAD x: rreil-show-var x.lhs +++ " = " +++ rreil-show-ptrderef x.size x.address
   | SEM_STORE x: "*" +++ rreil-show-address x.address +++ " = " +++ rreil-show-expr x.rhs
   | SEM_ITE x: "if (" +++ rreil-show-sexpr x.cond +++ ") {\n" +++ rreil-show-stmts x.then_branch +++ "} else {\n" +++ rreil-show-stmts x.else_branch +++ "}"
   | SEM_WHILE x: "while (" +++ rreil-show-sexpr x.cond +++ ") {\n" +++ rreil-show-stmts x.body +++ "}"
   | SEM_CBRANCH x: "if (" +++ rreil-show-sexpr x.cond +++ ") goto " +++ rreil-show-address x.target-true +++ " else goto " +++ rreil-show-address x.target-false
   | SEM_BRANCH x: "goto [" +++ rreil-show-hint x.hint +++ "] " +++ rreil-show-address x.target
   | SEM_PRIM p: rreil-show-varls p.lhs +++ " = $" +++ from-string-lit p.op +++ " " +++ rreil-show-varls p.rhs
   | SEM_FLOP f: rreil-show-varl f.lhs +++ " = $" +++ rreil-show-flop f.op +++ " " +++ rreil-show-varls f.rhs +++ " [flags:" +++ rreil-show-var f.flags +++ "]"
  end

val rreil-show-hint x =
  case x of
     HINT_JUMP: "JUMP"
   | HINT_CALL: "CALL"
   | HINT_RET: "RET"
  end

val rreil-show-label l = "l" +++ show-int l +++ ":"

val rreil-show-op-cmp cmp =
  case cmp of
     SEM_CMPEQ x: "==" +++ rreil-show-cmp x
   | SEM_CMPNEQ x: "/=" +++ rreil-show-cmp x
   | SEM_CMPLES x: "<=s" +++ rreil-show-cmp x
   | SEM_CMPLEU x: "<=u" +++ rreil-show-cmp x
   | SEM_CMPLTS x: "<s" +++ rreil-show-cmp x
   | SEM_CMPLTU x: "<u" +++ rreil-show-cmp x
  end

val rreil-show-expr expr =
   case expr of
      SEM_SEXPR x: rreil-show-arity1-sexpr x
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
    | SEM_SX x: "sx[" +++ show-int x.fromsize +++ "->" +++ show-int x.size +++ "](" +++ rreil-show-linear x.opnd1 +++ ")"
    | SEM_ZX x: "zx[" +++ show-int x.fromsize +++ "->" +++ show-int x.size +++ "](" +++ rreil-show-linear x.opnd1 +++ ")"
   end

val rreil-show-arity1-sexpr x = "[" +++ show-int x.size +++ "](" +++ rreil-show-sexpr x.opnd1 +++ ")"
val rreil-show-arity1 x = "[" +++ show-int x.size +++ "](" +++ rreil-show-linear x.opnd1 +++ ")"
val rreil-show-arity2 x = "[" +++ show-int x.size +++ "](" +++ rreil-show-linear x.opnd1 +++ "," +++ rreil-show-linear x.opnd2 +++ ")"
val rreil-show-cmp x = "[" +++ show-int x.size +++ "->1](" +++ rreil-show-linear x.opnd1 +++ "," +++ rreil-show-linear x.opnd2 +++ ")"
val rreil-show-ptrderef sz addr = "*[" +++ show-int addr.size +++ "->" +++ show-int sz +++ "](" +++ rreil-show-linear addr.address +++ ")"
val rreil-show-address addr = "[" +++ show-int addr.size +++ "](" +++ rreil-show-linear addr.address +++ ")"
val rreil-show-var x =
   case x.offset of
      0: rreil-show-id x.id
    | o: rreil-show-id x.id +++ "/" +++ show-int o
   end

val rreil-show-linear lin = 
   case lin of
      SEM_LIN_VAR x: rreil-show-var x
    | SEM_LIN_IMM x: show-int x.const
    | SEM_LIN_ADD x: rreil-show-linear x.opnd1 +++ "+" +++ rreil-show-linear x.opnd2
    | SEM_LIN_SUB x: rreil-show-linear x.opnd1 +++ "-" +++ rreil-show-linear x.opnd2
    | SEM_LIN_SCALE x:
         case x.const of
            0: ""
          | 1: rreil-show-linear x.opnd
          | s: show-int s +++ "*" +++ rreil-show-linear x.opnd
         end
   end

val rreil-show-sexpr sexpr =
  case sexpr of
	   SEM_SEXPR_LIN l: rreil-show-linear l
	 | SEM_SEXPR_CMP c: rreil-show-op-cmp c
   | SEM_SEXPR_ARB: "arbitrary"
	end

val rreil-show-id id =
   case id of
      FLOATING_FLAGS: "FLOATING_FLAGS"
    | VIRT_T x: "T" +++ show-int x
    | _: arch-show-id id
   end
