# vim:ts=3:sw=3:expandtab

export = pretty

val pretty i = show/instruction i

val show/unop x = show/operand x.operand
val show/binop x = show/operand x.first +++ ", " +++ show/operand x.second
val show/ternop x = show/operand x.first +++ ", " +++ show/operand x.second +++ ", " +++ show/operand x.third
val show/quadop x = show/operand x.first +++ ", " +++ show/operand x.second +++ ", " +++ show/operand x.third +++ ", " +++ show/operand x.fourth
val show/quinop x = show/operand x.first +++ ", " +++ show/operand x.second +++ ", " +++ show/operand x.third +++ ", " +++ show/operand x.fourth +++ ", " +++ show/operand x.fifth

val -++ a b = a +++ " " +++ b

val show/operand opnd = 
   case opnd of
      GPR r: show/register r
    | FPR r: show/register r
    | IMM imm: show/operand/imm imm
   end

val show/operand/imm imm =
   case imm of
      IMM16 x: show-int (zx x)
  end

val show/instruction i =
   case i of
      ADD x: "ADD" -++ show/ternop x    
   end

val show/register r =
   case r of
      R x: "r" +++ show-int x
    | HI: "HI"
    | LO: "LO"
    | PC: "PC"
    | F x: "f" +++ show-int x
    | FIR: "FIR"
    | FCCR: "FCCR"
    | FEXR: "FEXR"
    | FENR: "FENR"
    | FCSR: "FCSR"
   end
