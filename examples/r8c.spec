
granularity = 8

datatype size = B | W

# The state of the R8C decoder contains the size bit
state {
 # initial value doesn't matter
 size: size = B
}

# Store the original bit vectors
datatype imm =
   IMM8 {value: 8}
 | IMM16 {value: 16}

datatype opnd =
   R0L
 | R0
 | R1H
 | R1
 | A0
 | A1
 | SB
 | FB
 | PTR of {deref: opnd}
 | SUM of {lhs: opnd, rhs: opnd}
 | IMM of {value: imm}

# Type alias for instruction with "src" and "dst" operands
type arg2 = {size: size, src: opnd, dst: opnd}

datatype instruction =
   ADC of arg2
 | ADCF of {size: size, dst: opnd}
 | ADD of arg2

# The 's' action reads one bit and updates the monadic state
val s ['sizeBit:1'] = let
   val sizeTag =
      case sizeBit of
         '0':B
       | '1': W
in
   update {size=sizeTag}
end

# `imm` is a monadic action that reads 8 or 16 bits, depending on the current
# state
val imm = do
   sizeTag = query size;
   case sizeTag of
      B: imm8
    | W: imm16;

imm8 ['byte:8'] = return (IMM8 {value=byte})
imm16 ['byte1:8' 'byte2:8'] = return (IMM16 {value=byte1 ^ byte2})

# `opnd` is an (monadic) action that does not read any input but merely
# dispatches over its 4-bit argument and returns an AST for that argument
opnd argument = do
  s = query size;
  case argument of
     '0000': return (case s of '0': R0L | '1': R0)
   | '0001': return (case s of '0': R0H | '1': R1)
   | '0010': return (case s of '0': R1L | '1': R2)
   | '0011': return (case s of '0': R1H | '1': R3)
   | '0100': return A0
   | '0101': return A1
   | '0110': return PTR {deref=A0}
   | '0111': return PTR {deref=A1}
   | '1000': do
      dsp = imm8;
      return (PTR {deref=SUM {lhs=A0, rhs=IMM {dsp}}});
   | '1001': do
      dsp = imm8;
      return (PTR {deref=SUM {lhs=A1, rhs=IMM {value=dsp}})};
   | '1010': do
      dsp = imm8;
      return (PTR {deref=SUM {lhs=SB, rhs=IMM {value=dsp}}});
   | '1011': do
      dsp = imm8;
      return (PTR {deref=SUM {lhs=FB, rhs=IMM {value=dsp}}});
   | '1000': do
      dsp = imm8;
      return (PTR {deref=SUM {lhs=A0, rhs=IMM {value=dsp}}});
   | '1001': do
      dsp = imm8;
      return (PTR {deref=SUM {lhs=A1, rhs=IMM {value=dsp}}});
   | '1010': do
      dsp = imm8;
      return (PTR {deref=SUM {lhs=SB, rhs=IMM {value=dsp}}});
   | '1011': do
      i = imm16;
      return (IMM {value=i});
   ;

# generate an instruction with one destination
instrD constr genDest = do
   arg = genDest;
   sizeTag = query size;
   return constr {size=sizeTag, dst=arg};

instrDI constr genDest = do
  arg = genDest;
  i = imm;
  sizeTag = query size;
  return constr {size=sizeTag, src= IMM {i}, dst=arg};

# generate an instruction with two arguments
instrSD constr genSrc genDest = do
  src = genSrc;
  dest = genDest;
  sizeTag = query size;
  return (constr {size=sizeTag, src=src, dst=dest});

# in all instructions, the monadic action s updates the global state
decode ['0111 011 s' '0110 dest:4'] = instrDI ADC (opnd dest)
decode ['1011 000 s' 'src:4 dest:4'] = instrSD ADC (opnd src) (opnd dest)
decode ['0111 011 s' '1110 dest:4'] = instrD ADCF (opnd dest)
decode ['0111 011 s' '0100 dest:4'] = instrDI ADD (opnd dest)
decode ['1010 000 s' 'src:4 dest:4'] = instrSD ADD (opnd src) (opnd dest)
