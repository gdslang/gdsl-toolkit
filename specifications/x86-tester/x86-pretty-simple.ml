# vim:filetype=sml:ts=3:sw=3:expandtab

export pretty_simple : (insndata) -> rope

val flow_decode_pretty_simple = do
  inge <- decode config-default;
  return (pretty_simple inge)
end

val pretty_simple i = show/instruction/s i.insn

val show/arity1/s x = show/operand/s x.opnd1
val show/arity2/s x = show/operand/s x.opnd1 +++ ", " +++ show/operand/s x.opnd2
val show/arity3/s x = show/operand/s x.opnd1 +++ ", " +++ show/operand/s x.opnd2 +++ ", " +++ show/operand/s x.opnd3
val show/arity4/s x = show/operand/s x.opnd1 +++ ", " +++ show/operand/s x.opnd2 +++ ", " +++ show/operand/s x.opnd3 +++ ", " +++ show/operand/s x.opnd4
val show/flow1/s x = show/flowoperand/s x.opnd1

val show/segment/s s = 
   case s of
      SEG_NONE: ""
    | SEG_OVERRIDE r:
        case r of
           DS: ""
         | s: "REG:"
        end
   end

val show/scale/s s = 
   case s of
      '00': "SCALE*"
    | '01': "SCALE*"
    | '10': "SCALE*"
    | '11': "SCALE*"
   end

val show/operand/s op =
   case op of
      IMM8 x: "IMM"
    | IMM16 x: "IMM"
    | IMM32 x: "IMM"
    | IMM64 x: "IMM"
    | REG x: "REG"
    | MEM x: show/segment/s x.segment +++ "[" +++ show/operand/s x.opnd +++ "]" 
    | X86_SUM x: show/operand/s x.a +++ "+" +++ show/operand/s x.b
    | X86_SCALE x: show/scale/s x.imm +++ show/operand/s x.opnd
   end

val show/flowoperand/s op =
   case op of
      REL8 x: "REL"
    | REL16 x: "REL"
    | REL32 x: "REL"
    | REL64 x: "REL"
    | NEARABS x: show/operand/s x 
    | FARABS x: show/operand/s x
   end

val show/instruction/s insn = let
   val show/ua/s mnemonic ua = case ua of
      UA0: mnemonic
    | UA1 a: mnemonic -++ show/arity1/s a
    | UA2 a: mnemonic -++ show/arity2/s a
    | UA3 a: mnemonic -++ show/arity3/s a
    | UA4 a: mnemonic -++ show/arity4/s a
    | UAF f: mnemonic -++ show/flow1/s f
   end
in
   traverse show/ua/s insn
end
