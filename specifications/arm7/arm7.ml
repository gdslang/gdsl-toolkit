#arm7 instruction decoder

export config-default: decoder-configuration
export decode: (decoder-configuration) -> S insndata <{} => {}>
export decoder-config : configuration[vec=decoder-configuration]
export insn-length: int

export operands : (insndata) -> int

(* TODO: *)
val operands x = 0

type decoder-configuration = 0

(* TODO *)
val typeof-opnd insn i = 0

val decoder-config = END
val config-default = ''

val insn-length = 32

type insndata = {instruction:instruction} 

type instruction = 
    AND  of dp
  | ANDS of dp
  | EOR  of dp
  | EORS of dp
  | SUB  of dp
  | SUBS of dp
  | RSB  of dp
  | RSBS of dp
  | ADD  of dp
  | ADDS of dp
  | ADC  of dp
  | ADCS of dp
  | SBC  of dp
  | SBCS  of dp
  | RSC  of dp
  | RSCS of dp
  | TST  of dp
  | TSTS of dp
  | TEQ  of dp
  | TEQS of dp
  | CMP  of dp
  | CMPS of dp
  | CMN  of dp
  | CMNS of dp
  | ORR  of dp
  | ORRS of dp
  | MOV  of dp
  | MOVS of dp
  | BIC  of dp
  | BICS of dp
  | MVN  of dp
  | MVNS of dp

type dp = {condition:condition,rn:register,rd:register,op2:operand}

type operand
  = REGSHIFTAMOUNT of shiftamount 
  | REGSHIFTREG of shiftregister
  | IMMEDIATE of int

type shiftedregister
  = SHIFTAMOUNT of shiftamount
  | SHIFTREGISTER of shiftregister
 
type shiftamount = {rm:register, amount:int, shift_type:shifttype}
type shiftregister = {rm:register, register:register, shift_type:shifttype}

type shifttype
  = LLS # logical left shift
  | LRS # logical right shift
  | ARS # arathmetic right shift
  | RR  # rotate right

type register
  = R0          #Argument1, Return Value: Temporory register
  | R1          #Argument2, Second 32-bits if double/int Return Value: Temporory register
  | R2          #Argument: Temporory register
  | R3          #Argument: Temporory register
  | R4          #permanent register
  | R5          #permanent register
  | R6          #permanent register
  | R7          #permanent register (THUMB frame pointer)
  | R8          #permanent register
  | R9          #permanent register
  | R10         #permanent register
  | R11         #ARM frame pointer: permanent register
  | R12         #Temporory register
  | R13         #Stack pointer: permanent register
  | R14         #Link register: permanent register
  | R15         #Program Counter
        
type condition =
        EQ
      | NE
      | CS
      | CC
      | MI
      | PL
      | VS
      | VC
      | HI
      | LS
      | GE
      | LT
      | GT
      | LE
      | AL

val decode config = do
        reset;
        insn <- /;
        return {instruction=insn}
end


val dp cons condition rn rd op2 = do
        condition <- condition;
        rn <- rn;
        rd <- rd;
        op2 <- op2;
        return (cons{condition=condition,rn=rn,rd=rd,op2=op2})
end

val shiftregister cons rm register shift_type = do
        rm <- rm;
        register <- register;
        shift_type <- shift_type;
        return (cons{rm=rm, register=register, shift_type=shift_type})
end


val shiftamount cons rm amount shift_type = do
        rm <- rm;
        amount <- amount;
        shift_type <- shift_type;
        return (cons{rm=rm, amount=amount, shift_type=shift_type})
end

val register-from-bits' bits = do
        return (register-from-bits bits)
end

val register-from-bits bits=
  case bits of
      '0001' : R0
    | '0010' : R1
    | '0011' : R2
    | '0100' : R3
    | '0101' : R4
    | '0110' : R5
    | '0111' : R6
    | '1000' : R7
    | '1001' : R8
    | '1010' : R9
    | '1011' : R10
    | '1100' : R11
    | '1101' : R12
    | '1110' : R13
end

val shifttype-from-bits' bits = do
  return (shifttype-from-bits bits)
end

val shifttype-from-bits bits = 
  case bits of
      '00' : LLS
    | '01' : LRS
    | '10' : ARS
    | '11' : RR
  end

val cond-from-bits bits =
  case bits of
       '0000': EQ
     | '0001': NE
     | '0010': CS
     | '0011': CC
     | '0100': MI
     | '0101': PL
     | '0110': VS
     | '0111': VC
     | '1000': HI
     | '1001': LS
     | '1010': GE
     | '1011': LT
     | '1100': GT
     | '1101': LE
     | '1110': AL
end



val /cond ['cond:4'] = update@{cond=cond}

val cond = do
       cond  <- query $cond;
       update @{cond=''};
       return (cond-from-bits cond)
end       

(**)

val /op2register ['shift:5 shifttype:2 0 rm:4'] = update@{shiftoperation=0 ,shift_amount=shift, shifttype=shifttype, rm=rm}
val /op2register ['shiftregister:4 0 shifttype:2 1 rm:4'] = update@{shiftoperation=1, shift_register=shiftregister, shifttype=shifttype, rm=rm}
val /op2imm ['rotate:4 imm:8'] = update@{rotate=rotate, imm=imm}

val op2register = do
        shiftoperation <- query $shiftoperation;
        rm <- query $rm;
        shifttype <- query $shifttype;
        shift_amount <- query $shift_amount;
        shift_register <- query $shift_register;
        reset;
        ret <-case shiftoperation of
            1 : (shiftregister REGSHIFTREG(register-from-bits' rm) (register-from-bits' shift_register) (shifttype-from-bits' shifttype))
            # | 0 : shiftamount SHIFTAMOUNT (register-from-bits' rm) (zx shift_amount) (shifttype-from-bits' shifttype)
        end;
        return (ret)

end        

val reset = do
        update @{shiftoperation=0};
        update @{rm='0000', shifttype='00'};
        update @{shift_amount='00000'};
        update @{shift_register='0000'};
        update @{imm='00000000'};
        update @{rotate='0000'}
end

val op2imm = do
  imm <- query $imm;
  rotate <- query $rotate;
  reset;
  return (IMMEDIATE 42)
end


### AND
val / ['/cond 00000000 rn:4 rd:4 /op2register'] = dp AND cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00100000 rn:4 rd:4 /op2imm'] = dp AND cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### ANDS
val / ['/cond 00000001 rn:4 rd:4 /op2register'] = dp ANDS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00100001 rn:4 rd:4 /op2imm'] = dp ANDS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### EOR
val / ['/cond 00000010 rn:4 rd:4 /op2register'] = dp EOR cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00100010 rn:4 rd:4 /op2imm'] = dp EOR cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### EORS
val / ['/cond 00100011 rn:4 rd:4 /op2register'] = dp EORS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00000011 rn:4 rd:4 /op2imm'] = dp EORS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### SUB
val / ['/cond 00100100 rn:4 rd:4 /op2register'] = dp SUB cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00000100 rn:4 rd:4 /op2imm'] = dp SUB cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### SUBS
val / ['/cond 00100101 rn:4 rd:4 /op2register'] = dp SUBS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00000101 rn:4 rd:4 /op2imm'] = dp SUBS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### RSB
val / ['/cond 00100110 rn:4 rd:4 /op2register'] = dp RSB cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00000110 rn:4 rd:4 /op2imm'] = dp RSB cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### RSBS
val / ['/cond 00100111 rn:4 rd:4 /op2register'] = dp RSBS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00000111 rn:4 rd:4 /op2imm'] = dp RSBS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### ADD 
val / ['/cond 00101000 rn:4 rd:4 /op2register'] = dp ADD cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00001000 rn:4 rd:4 /op2imm'] = dp ADD cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### ADDS
val / ['/cond 00101001 rn:4 rd:4 /op2register'] = dp ADDS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00001001 rn:4 rd:4 /op2imm'] = dp ADDS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### ADC 
val / ['/cond 00101010 rn:4 rd:4 /op2register'] = dp ADC cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00001010 rn:4 rd:4 /op2imm'] = dp ADC cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### ADCS
val / ['/cond 00101011 rn:4 rd:4 /op2register'] = dp ADCS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00001011 rn:4 rd:4 /op2imm'] = dp ADCS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### SBC 
val / ['/cond 00101100 rn:4 rd:4 /op2register'] = dp SBC cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00001100 rn:4 rd:4 /op2imm'] = dp SBC cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### SBCS
val / ['/cond 00101101 rn:4 rd:4 /op2register'] = dp SBCS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00001101 rn:4 rd:4 /op2imm'] = dp SBCS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### RSC 
val / ['/cond 00101110 rn:4 rd:4 /op2register'] = dp RSC cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00001110 rn:4 rd:4 /op2imm'] = dp RSC cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### RSCS
val / ['/cond 00101111 rn:4 rd:4 /op2register'] = dp RSCS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00001111 rn:4 rd:4 /op2imm'] = dp RSCS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### TST 
val / ['/cond 00110000 rn:4 rd:4 /op2register'] = dp TST cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00010000 rn:4 rd:4 /op2imm'] = dp TST cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### TSTS
val / ['/cond 00110001 rn:4 rd:4 /op2register'] = dp TSTS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00010001 rn:4 rd:4 /op2imm'] = dp TSTS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### TEQ 
val / ['/cond 00110010 rn:4 rd:4 /op2register'] = dp TEQ cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00010010 rn:4 rd:4 /op2imm'] = dp TEQ cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### TEQS
val / ['/cond 00110011 rn:4 rd:4 /op2register'] = dp TEQS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00010011 rn:4 rd:4 /op2imm'] = dp TEQS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### CMP 
val / ['/cond 00110100 rn:4 rd:4 /op2register'] = dp CMP cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00010100 rn:4 rd:4 /op2imm'] = dp CMP cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### CMPS
val / ['/cond 00110101 rn:4 rd:4 /op2register'] = dp CMPS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00010101 rn:4 rd:4 /op2imm'] = dp CMPS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### CMN 
val / ['/cond 00110110 rn:4 rd:4 /op2register'] = dp CMN cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00010110 rn:4 rd:4 /op2imm'] = dp CMN cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### CMNS
val / ['/cond 00110111 rn:4 rd:4 /op2register'] = dp CMNS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00010111 rn:4 rd:4 /op2imm'] = dp CMNS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### ORR 
val / ['/cond 00111000 rn:4 rd:4 /op2register'] = dp ORR cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00011000 rn:4 rd:4 /op2imm'] = dp ORR cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### ORRS
val / ['/cond 00111001 rn:4 rd:4 /op2register'] = dp ORRS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00011001 rn:4 rd:4 /op2imm'] = dp ORRS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### MOV 
val / ['/cond 00111010 rn:4 rd:4 /op2register'] = dp MOV cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00011010 rn:4 rd:4 /op2imm'] = dp MOV cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### MOVS
val / ['/cond 00111011 rn:4 rd:4 /op2register'] = dp MOVS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00011011 rn:4 rd:4 /op2imm'] = dp MOVS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### BIC 
val / ['/cond 00111100 rn:4 rd:4 /op2register'] = dp BIC cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00011100 rn:4 rd:4 /op2imm'] = dp BIC cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### BICS
val / ['/cond 00111101 rn:4 rd:4 /op2register'] = dp BICS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00011101 rn:4 rd:4 /op2imm'] = dp BICS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### MVN 
val / ['/cond 00111110 rn:4 rd:4 /op2register'] = dp MVN cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00011110 rn:4 rd:4 /op2imm'] = dp MVN cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

### MVNS
val / ['/cond 00111111 rn:4 rd:4 /op2register'] = dp MVNS cond (register-from-bits' rn) (register-from-bits' rd) (op2register)
val / ['/cond 00011111 rn:4 rd:4 /op2imm'] = dp MVNS cond (register-from-bits' rn) (register-from-bits' rd) (op2imm)

