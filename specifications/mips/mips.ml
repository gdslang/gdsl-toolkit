granularity = 32
export = config-default decode

val force-int-for-decode-config = decode config-default

type imm =
   IMM16 of 16
 | SIZE of int

type leftop =
   GPR of register
 | FPR of register

type rightop =
   LEFTOP of leftop
 | IMM of imm

val right leftop = do
  leftop <- leftop;
  return (LEFTOP leftop)
end

val config-default = ''

val decode config = do
  update@{ck='',rs='',rt='',rd='',immediate=''};
  /
end

### ADD
###  - ADD
val / ['000000 /rs /rt /rd 00000 100000'] = ternop ADD rd (right rs) (right rt)

val rs = do
  rs <- query $rs;
  update @{rs=''};
  return (GPR (gpr-from-bits rs))
end

val rt = do
  rt <- query $rt;
  update @{rt=''};
  return (GPR (gpr-from-bits rt))
end


val rd = do
  rd <- query $rd;
  update @{rd=''};
  return (GPR (gpr-from-bits rd))
end

val immediate = do
  immediate <- query $immediate;
  update @{immediate=''};
  return (IMM (IMM16 immediate))
end

val /rs ['rs:5'] = update@{rs=rs}
val /rt ['rt:5'] = update@{rt=rt}
val /rd ['rd:5'] = update@{rd=rd}
val /immediate ['immediate:16'] = update@{immediate=immediate}

type ternop = {destination:leftop,source1:rightop,source2:rightop}

val ternop cons destination source1 source2 = do
 destination <- destination;
 source1 <- source1;
 source2 <- source2;
 return (cons {destination=destination, source1=source1, source2=source2})
end

type instruction =
   ADD of ternop

type register =
   ZERO
 | AT
 | V0
 | V1
 | A0
 | A1
 | A2
 | A3
 | A4
 | A5
 | A6
 | A7
 | T4
 | T5
 | T6
 | T7
 | S0
 | S1
 | S2
 | S3
 | S4
 | S5
 | S6
 | S7
 | T8
 | T9
 | K0
 | K1
 | GP
 | SP
 | S8
 | RA
 | HI
 | LO
 | PC

type register =
   F of int
 | FIR
 | FCCR
 | FEXR
 | FENR
 | FCSR

val gpr-from-bits bits =
 case bits of
    '00000': ZERO
  | '00001': AT
  | '00010': V0
  | '00011': V1
  | '00100': A0
  | '00101': A1
  | '00110': A2
  | '00111': A3
  | '01000': A4
  | '01001': A5
  | '01010': A6
  | '01011': A7
  | '01100': T4
  | '01101': T5
  | '01110': T6
  | '01111': T7
  | '10000': S0
  | '10001': S1
  | '10010': S2
  | '10011': S3
  | '10100': S4
  | '10101': S5
  | '10110': S6
  | '10111': S7
  | '11000': T8
  | '11001': T9
  | '11010': K0
  | '11011': K1
  | '11100': GP
  | '11101': SP
  | '11110': S8
  | '11111': RA
 end

val fpr-from-bits bits = (F (zx bits))
