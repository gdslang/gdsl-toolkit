
granularity = 8

datatype Size = B | W

// the state of the R8C decoder contains the size bit

state {
 size : Size = B // initial value doesn't matter
}

datatype Arg
 = R0L | R0 | R1H | R1 | A0 | A1 | SB | FB | PTR { deref = Arg } |
   SUM { lhs = Arg, rhs = Arg } | Const { value = Imm }

// let's store the original bit vectors
datatype Imm = Imm8 { vec8 : 8 } | Imm16 { vec16 : 16 }

// the 's' action reads one bit and updates the monadic state
let s ['sizeBit:1'] = do
 let sizeTag = case sizeBit of '0' -> B; '1' -> W; ;
 update { size = sizeTag }

// arg is an action that does not read any input but merely
// dispatches over its 4-bit argument and returns an AST for that argument
let arg argument = {
  s <- query size;
  case argument {
    '0000' -> return (case s { '0' -> R0L; '1' -> R0; };
    '0001' -> return (case s { '0' -> R0H; '1' -> R1; };
    '0010' -> return (case s of '0' -> R1L; '1' -> R2; };
    '0011' -> return (case s of '0' -> R1H; '1' -> R3; };
    '0100' -> return A0;
    '0101' -> return A1;
    '0110' -> return PTR { deref = A0 };
    '0111' -> return PTR { deref = A1 };
    '1000' -> {
      dsp <- imm8;
      return PTR { SUM { A0, Const { dsp } })}
    };
    '1001' -> {
      dsp <- imm8;
      return PTR { deref = SUM { lhs = A1, rhs = Const { value = dsp } })}
    };
    '1010' -> {
      dsp <- imm8;
      return PTR { deref = SUM { lhs = SB, rhs = Const { value = dsp } })}
    };
    '1011' -> {
      dsp <- imm8;
      return PTR { deref = SUM { lhs = FB, rhs = Const { value = dsp } })}
    };
    '1000' -> {
      dsp <- imm8;
      return PTR { deref = (SUM { lhs = A0, rhs = Const { value = dsp } })}
    };
    '1001' -> {
      dsp <- imm8;
      return PTR { deref = SUM { lhs = A1, rhs = Const { value = dsp } })}
    };
    '1010' -> {
      dsp <- imm8;
      return PTR { deref = SUM { lhs = SB, rhs = Const { value = dsp } })}
    };
    '1011' -> {
      i <- imm16;
      return Const { value = i };
    }
  }
}

// imm is a monadic action that reads 8 or 16 bits, depending on the current
// state
imm = {
 sizeTag <- query size;
 case sizeTag { B -> imm8; W -> imm16 }
}

imm8 ['byte:8'] = return (Imm8 { vec8 = byte })

imm16 ['byte1:8' 'byte2:8'] = return (Imm16 { vec16 = byte1 || byte2 })

// here || is vector concatenation

datatype Instr
 = ADC { size : Size, src: Arg, dest : Arg }
 | ADCF { size : Size, dest : Arg }
 | ADD { size : Size, src: Arg, dest : Arg }
// ...

// generate an instruction with one destination
instrD constr genDest = {
  arg <- genDest;
  sizeTag <- query size;
  return constr { size = sizeTag,  dest = arg }
}

instrDI constr genDest = {
  arg <- genDest;
  i <- imm;
  sizeTag <- query size;
  return constr { size = sizeTag, src = Const { i }, dest = arg }
}

// generate an instruction with two arguments
instrSD constr genSrc genDest = {
  src <- genSrc;
  dest <- genDest;
  sizeTag <- query size;
  return (constr { size = sizeTag, src = src, dest = dest })
}

// in all instructions, the monadic action s updates the global state
decode ['0111 011 s' '0110 dest:4'] = instrDI ADC (arg dest)
decode ['1011 000 s' 'src:4 dest:4'] = instrSD ADC (arg src) (arg dest)
decode ['0111 011 s' '1110 dest:4'] = instrD ADCF (arg dest)
decode ['0111 011 s' '0100 dest:4'] = instrDI ADD (arg dest)
decode ['1010 000 s' 'src:4 dest:4'] = instrSD ADD (arg src) (arg dest)

