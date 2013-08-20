# Texas Instrument's MSP430 microcontroller instruction decoder

export = decode

type register
  = PC
  | SP
  | R2
  | R3
  | R4
  | R5
  | R6
  | R7
  | R8
  | R9
  | R10
  | R11
  | R12
  | R13
  | R14
  | R15
  
type expr
  = Register of { reg: register, incr: 1 }
  | Indexed of { reg: register, offset: 16 }
  | Const of 16
  
type arg
  = Direct of expr
  | Indirect of expr
  | Void

val word ['value:16'] = return value

val genSource = do
   as <- query $as;
   reg <- query $src;
   case as of
      '00' : case reg of
         R3 : return (Direct (Const '0000000000000000'))
       | _ : return (Direct (Register {reg = reg, incr = '0'}))
      end
    | '01' : case reg of
         R2 : do
            x <- word;
            return (Indirect (Const x))
         end
       | R3 : return (Direct (Const '0000000000000001'))
       | _ : do
            x <- word;
            return (Indirect (Indexed {reg = reg, offset = x}))
         end
      end
    | '10' : case reg of
         R2 : return (Direct (Const '0000000000000100'))
       | R3 : return (Direct (Const '0000000000000010'))
       | _ : return (Indirect (Register {reg = reg, incr = '0'}))
      end
    | '11' : case reg of
         PC : do
            n <- word;
            return (Direct (Const n))
         end
       | R2 : return (Direct (Const '0000000000001000'))
       | R3 : return (Direct (Const '1111111111111111'))
       | _ : return (Indirect (Register {reg = reg, incr = '1'}))
      end
   end
end

val genDest = do
   ad <- query $ad;
   reg <- query $dst;
   case ad of
      '0' : case reg of
         R3 : return Void
       | _ : return (Direct (Register {reg = reg, incr = '0'}))
      end
    | '1' : case reg of
         R2 : do
            x <- word;
            return (Indirect (Const x))
         end
       | R3 : return Void
       | _ : do
            x <- word;
            return (Indirect (Indexed {reg = reg, offset = x}))
         end
      end
   end
end
         

type binop = {
  byte : 1,
  src : arg,
  dst : arg
}

type unop = {
  byte : 1,
  src : arg
}

type target = int

type instr
  = RRC   of unop
  | SWPB  of arg
  | RRA   of unop
  | SXT   of arg
  | PUSH  of unop
  | CALL  of arg
  | RETI
  | JNE   of target
  | JEQ   of target
  | JNC   of target
  | JC    of target
  | JN    of target
  | JGE   of target
  | JL    of target
  | JMP   of target
  | MOV   of binop
  | ADD   of binop
  | ADDC  of binop
  | SUBC  of binop
  | SUB   of binop
  | CMP   of binop
  | DADD  of binop
  | BIT   of binop
  | BIC   of binop
  | BIS   of binop
  | XOR   of binop
  | AND   of binop

val cond ['000'] = update @{ jump = JNE }
val cond ['001'] = update @{ jump = JEQ }
val cond ['010'] = update @{ jump = JNC }
val cond ['011'] = update @{ jump = JC }
val cond ['100'] = update @{ jump = JN }
val cond ['101'] = update @{ jump = JGE }
val cond ['110'] = update @{ jump = JL }
val cond ['111'] = update @{ jump = JMP }

val opcode ['0100'] = update @{ mnemonic = MOV }
val opcode ['0101'] = update @{ mnemonic = ADD }
val opcode ['0110'] = update @{ mnemonic = ADDC }
val opcode ['0111'] = update @{ mnemonic = SUBC }
val opcode ['1000'] = update @{ mnemonic = SUB }
val opcode ['1001'] = update @{ mnemonic = CMP }
val opcode ['1010'] = update @{ mnemonic = DADD }
val opcode ['1011'] = update @{ mnemonic = BIT }
val opcode ['1100'] = update @{ mnemonic = BIC }
val opcode ['1101'] = update @{ mnemonic = BIS }
val opcode ['1110'] = update @{ mnemonic = XOR }
val opcode ['1111'] = update @{ mnemonic = AND }

val genRegister reg =
   case reg of
      '0000' : PC
    | '0001' : SP
    | '0010' : R2
    | '0011' : R3
    | '0100' : R4
    | '0101' : R5
    | '0110' : R6
    | '0111' : R7
    | '1000' : R8
    | '1001' : R9
    | '1010' : R10
    | '1011' : R11
    | '1100' : R12
    | '1101' : R13
    | '1110' : R14
    | '1111' : R15
   end

val unop m = do
  s <- genSource;
  b <- query $useByte;
  return (m {byte = b, src = s})
end

val unopW m = do
  s <- genSource;
  return (m s)
end

val b/w ['useByte:1'] = update @{ useByte = useByte }
val as ['as:2'] = update @{ as = as}
val ad ['ad:1'] = update @{ ad = ad}
val sReg ['reg:4'] = update @{ src = genRegister reg }
val dReg ['reg:4'] = update @{ dst = genRegister reg }

val decode ['000100 000 b/w as sReg '] = unop RRC
val decode ['000100 001   0 as sReg '] = unopW SWPB
val decode ['000100 010 b/w as sReg '] = unop RRA
val decode ['000100 011   0 as sReg '] = unopW SXT
val decode ['000100 100 b/w as sReg '] = unop PUSH
val decode ['000100 101   0 as sReg '] = unopW CALL
val decode ['000100 110   0 as sReg '] = return RETI


  
val decode ['001 cond offset:10'] = do
  m <- query $jump;
  return (m (sx (offset^'0')))
end

val decode ['opcode sReg ad b/w as dReg '] = do
  m <- query $mnemonic;
  s <- genSource;
  d <- genDest;
  b <- query $useByte;
  return (m { byte = b, src = s, dst = d })
end
