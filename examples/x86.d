granularity = 8
export = main

# Optional arguments
#
# Limit:
#   - Restricts the maximium size of the decode-stream
# Recursion-depth:
#   - Annotate the maximum number of recursion steps for
#     the given decoder. This way, we can compute an upper
#     bound for the maximum used storage for the emitted AST.
#     Additionally, the decoder may fail if during runtime
#     a recrusion depth violation occurs.
#
# limit = 120
# recursion-depth = main = 4

# The state of the decode monad
state =
   {mode64:1=0,
    rep:1=0,
    rexw:1=0,
    rexb:1=0,
    rexr:1=0,
    rexx:1=0,
    opndsz:1=0,
    addrsz:1=0,
    segment:register=DS}

datatype register =
   AL | AH | AX | EAX | RAX
 | BL | BH | BX | EBX | RBX
 | CL | CH | CX | ECX | RCX
 | DL | DH | DX | EDX | RDX
 | R8L | R8W | R8D | R8 
 | R9L | R9W | R9D | R9 
 | R10L | R10W | R10D | R10 
 | R11L | R11W | R11D | R11 
 | R12L | R12W | R12D | R12 
 | R13L | R13W | R13D | R13 
 | R14L | R14W | R14D | R14 
 | R15L | R15W | R15D | R15 
 | SP | ESP | RSP
 | BP | EBP | RBP
 | SI | ESI | RSI
 | DI | EDI | RDI
 | XMM0
 | XMM1
 | XMM2
 | XMM3
 | XMM4
 | XMM5
 | XMM6
 | XMM7
 | MM0
 | MM1
 | MM2
 | MM3
 | MM4
 | MM5
 | MM6
 | MM7
 | ES
 | SS
 | DS
 | FS
 | GS
 | CS

datatype opnd =
   IMM8 of 8
 | IMM16 of 16
 | IMM32 of 32
 | IMM64 of 64
 | REG of register
 | MEM of {sz: int, segment: register, opnd: opnd}
 | SUM of {a:opnd, b:opnd}
 | SCALE of {imm:2, opnd:opnd}

val al = return (REG AL)
val ah = return (REG AH)
val ax = return (REG AX)
val eax = return (REG EAX)
val rax = return (REG RAX)
val bl = return (REG BL)
val bh = return (REG BH)
val bx = return (REG BX)
val ebx = return (REG EBX)
val rbx = return (REG RBX)
val cl = return (REG CL)
val ch = return (REG CH)
val cx = return (REG CX)
val ecx = return (REG ECX)
val rcx = return (REG RCX)
val dl = return (REG DL)
val dh = return (REG DH)
val dx = return (REG DX)
val edx = return (REG EDX)
val rdx = return (REG RDX)
val sp = return (REG SP)
val esp = return (REG ESP)
val rsp = return (REG RSP)
val bp = return (REG BP)
val ebp = return (REG EBP)
val rbp = return (REG RBP)
val si = return (REG SI)
val esi = return (REG ESI)
val rsi = return (REG RSI)
val di = return (REG DI)
val edi = return (REG EDI)
val rdi = return (REG RDI)

# A type alias used for instructions taking two arguments
type binop = {opnd1:opnd, opnd2:opnd}

datatype insn =
   ADD of binop
 |  MOV of binop
 | CVTPD2PI of binop

val imm8 ['b:8'] = return (IMM8 b)
val imm16 ['b1:8 b2:8'] = return (IMM16 (b1 ^ b2))
val imm32 ['b1:8 b2:8 b3:8 b4:8'] = return (IMM32 (b1 ^ b2 ^ b3 ^ b4))
val imm64 ['b1:8 b2:8 b3:8 b4:8 b5:8 b6:8 b7:8 b8:8'] =
   return (IMM32 (b1 ^ b2 ^ b3 ^ b4 ^ b5 ^ b6 ^ b7 ^ b8))

## Convert a bit-vectors to registers

val reg8 n =
   case n of
      '000': REG AL
    | '001': REG CL
    | '010': REG DL
    | '011': REG BL
    | '100': REG AH
    | '101': REG CH
    | '110': REG DH
    | '111': REG BH
   end

val reg16 n =
   case n of
      '000': REG AX
    | '001': REG CX
    | '010': REG DX
    | '011': REG BX
    | '100': REG SP
    | '101': REG BP
    | '110': REG SI
    | '111': REG DI
   end

val reg32 n =
   case n of
      '000': REG EAX
    | '001': REG ECX
    | '010': REG EDX
    | '011': REG EBX
    | '100': REG ESP
    | '101': REG EBP
    | '110': REG ESI
    | '111': REG EDI
   end

val reg64 n =
   case n of
      '000': REG RAX
    | '001': REG RCX
    | '010': REG RDX
    | '011': REG RBX
    | '100': REG RSP
    | '101': REG RBP
    | '110': REG RSI
    | '111': REG RDI
   end

val sreg3 n =
   case n of
      '000': REG ES
    | '001': REG CS
    | '010': REG SS
    | '011': REG DS
    | '100': REG FS
    | '101': REG GS
#| '110': reserved
#| '111': reserved
   end

val xmm n =
   case n of
      '000': REG XMM0
    | '001': REG XMM1
    | '010': REG XMM2
    | '011': REG XMM3
    | '100': REG XMM4
    | '101': REG XMM5
    | '110': REG XMM6
    | '111': REG XMM7
   end

val mm n =
   case n of
      '000': REG MM0
    | '001': REG MM1
    | '010': REG MM2
    | '011': REG MM3
    | '100': REG MM4
    | '101': REG MM5
    | '110': REG MM6
    | '111': REG MM7
   end

# Deslice the mod/rm byte and put it into the the state

val /0 ['mod:2 000 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=0}
val /1 ['mod:2 001 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=1}
val /2 ['mod:2 010 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=2}
val /3 ['mod:2 011 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=3}
val /4 ['mod:2 100 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=4}
val /5 ['mod:2 101 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=5}
val /6 ['mod:2 110 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=6}
val /7 ['mod:2 111 rm:3'] = update @{mod=mod, rm=rm, reg/opcode=7}
val /r ['mod:2 reg/opcode:3 rm:3'] = update @{mod=mod, reg/opcode=reg/opcode, rm=rm}

## Decoding the SIB byte
#    TODO: this is only for 32bit addressing

val sib-without-index reg = do
   mod <- query $mod;
   case mod of
      '00': imm32
    | '01': return (reg '101') # rBP
    | '10': return (reg '101') # rBP
   end
end

val sib-without-base reg scale index =
   let
      val scaled = SCALE{imm=scale, opnd=reg index}
   in
      do
         mod <- query $mod;
         case mod of
            '00': 
               do
                  i <- imm32;
                  return (SUM{a=scaled, b=IMM32 i})
               end
          | _ : return (SUM{a=scaled, b=reg '101'}) # rBP
         end
      end
   end

val sib-with-index-and-base reg s i b =
   return (SUM{a=SCALE{imm=s, opnd=i}, b=reg b})

val sib ['scale:2 100 101']
 | $addrsz = sib-without-index reg16
 | otherwise = sib-without-index reg32

val sib ['scale:2 index:3 101'] 
 | $addrsz = sib-without-base reg16 scale index
 | otherwise = sib-without-base reg32 scale index

val sib ['scale:2 index:3 base:3']
 | $addrsz = sib-with-index-and-base reg16 scale index base
 | otherwise = sib-with-index-and-base reg32 scale index base

## Decoding the mod/rm byte

val addrsz = do
   sz <- query $addrsz;
   case sz of
      1: 16
    | 0: 32
   end
end

val mem op = do
   sz <- addrsz;
   seg <- query $segment;
   return (MEM {sz=sz, segment=seg, opnd=op})
end

val r/m-with-sib = do
   sibOpnd <- sib;
   mod <- query $mod;
   case mod of
      '00': mem sibOpnd
    | '01':
         do
            i <- imm8;
            mem (SUM{a=sibOpnd, b=i})
         end
    | '10':
         do
            i <- imm32;
            mem (SUM{a=sibOpnd, b=i})
         end
   end
end

val r/m-without-sib reg = do
   mod <- query $mod;
   rm <- query $rm;
   case mod of
      '00':
         case rm of
            '101':
               do
                  i <- imm32;
                  mem i
               end
          | _ : mem (reg rm)
         end
    | '01':
         do
            i <- imm8;
            mem (SUM{a=reg rm, b=i})
         end
    | '10':
         do
            i <- imm32;
            mem (SUM{a=reg rm, b=i})
         end
    | '11': return (reg rm)
   end
end

val r/m reg = do
   mod <- query $mod;
   rm <- query $rm;
   case rm of
      '100': r/m-with-sib
    | _ : r/m-without-sib reg
   end
end

val r/m8 = r/m reg8
val r/m16 = r/m reg16
val r/m32 = r/m reg32
val r/m64 = r/m reg64
val xmm/m128 = r/m xmm

val r/ reg = do
   r <- query $reg;
   return reg r
end

val r8 = r/ reg8
val r16 = r/ reg16
val r32 = r/ reg32
val r64 = r/ reg64
val mm64 = r/ mm
val xmm128 = r/ xmm

val moffs8 = do
   i <- imm8;
   mem i
end

val moffs16 = do
   i <- imm16;
   mem i
end

val moffs32 = do
   i <- imm32;
   mem i
end

val moffs64 = do
   i <- imm64;
   mem i
end

val binop cons giveOp1 giveOp2 = do
   op1 <- giveOp1;
   op2 <- giveOp2;
   return (cons {op1=op1, op2=op2})
   # We could add syntatic sugar for record field creation:
   #   return (MOV {op1, op2})
end

val mov = binop MOV
val add = binop ADD

## The REX prefixes

val /rex ['0100 w:1 r:1 x:1 b:1'] = update @{rexw=w, rexb=b, rexx=x, rexr=r}

## Decode prefixes, recursion could be limited with "recursion-depth main = 4" 

val main [0x2e] = do update @{segment=CS}; main end
val main [0x36] = do update @{segment=SS}; main end
val main [0x3e] = do update @{segment=DS}; main end
val main [0x26] = do update @{segment=ES}; main end
val main [0x64] = do update @{segment=FS}; main end
val main [0x65] = do update @{segment=GS}; main end
val main [0x66] = do update @{opndsz=1}; main end
val main [0x67] = do update @{addrsz=1}; main end
val main [0x66 0x0f] = twp-byte-opcode-0f 
val main [0x66 /rex 0x0f] = twp-byte-opcode-0f 
val main [/rex] = one-byte-opcode
val main [] = one-byte-opcode

## Instruction decoders

## One Byte Opcodes

### MOV Vol 2A 3-643

val one-byte-opcode [0x04] = add al imm8
val one-byte-opcode [0x05]
   | $rexw = add rax imm64
   | $opndsz = add rax imm32
   | otherwise = add rax imm16
val one-byte-opcode [0x80 /0] = r/m8 imm8
val one-byte-opcode [0x81 /0]
   | $rexw = add r/m64 imm64
   | $opndsz = add r/m32 imm32
   | otherwise = add r/m16 imm16
val one-byte-opcode [0x83 /0]
   | $rexw = add r/m64 imm8
   | $opndsz = add r/m32 imm8
   | otherwise = add r/m16 imm8
val one-byte-opcode [0x00 /r] = add r/m8 r8
val one-byte-opcode [0x01 /0]
   | $rexw = add r/m64 r64
   | $opndsz = add r/m32 r32
   | otherwise = add r/m16 r16
val one-byte-opcode [0x02 /r] = add r8 r/m8
val one-byte-opcode [0x03 /0]
   | $rexw = add r64 r/m64
   | $opndsz = add r32 r/m32
   | otherwise = add r16 r/m16

val one-byte-opcode [0x88 /r] = mov r/m8 r8
val one-byte-opcode [0x89 /r] 
 | $opndsz = mov r/m16 r16
#| $rexw = mov r/m64 r64
 | otherwise = mov r/m32 r32
val one-byte-opcode [0x8a /r] = mov r8 r/m8
val one-byte-opcode [0x8b /r]
 | $opndsz = mov r16 r/m16
 | otherwise = mov r32 r/m32
val one-byte-opcode [0x8c /r] = mov r/m16 (r/ sreg3)
val one-byte-opcode [0x8e /r] = mov (r/ sreg3) r/m16
val one-byte-opcode [0xa0] = mov al moffs8 
val one-byte-opcode [0xa1]
 | $addrsz = mov ax moffs16
 | otherwise = mov eax moffs32
val one-byte-opcode [0xa2] = mov moffs8 al
val one-byte-opcode [0xa3]
 | $addrsz = mov moffs16 ax
 | otherwise = mov moffs32 eax
val one-byte-opcode [0xb0] = mov al imm8
val one-byte-opcode [0xb1] = mov cl imm8
val one-byte-opcode [0xb2] = mov dl imm8
val one-byte-opcode [0xb3] = mov bl imm8
val one-byte-opcode [0xb4] = mov ah imm8
val one-byte-opcode [0xb5] = mov ch imm8
val one-byte-opcode [0xb6] = mov dh imm8
val one-byte-opcode [0xb7] = mov bh imm8
val one-byte-opcode [0xb8]
 | $opndsz = mov ax imm16
 | otherwise = mov eax imm32
val one-byte-opcode [0xb9]
 | $opndsz = mov cx imm16
 | otherwise = mov ecx imm32
val one-byte-opcode [0xba]
 | $opndsz = mov dx imm16
 | otherwise = mov edx imm32
val one-byte-opcode [0xbb]
 | $opndsz = mov bx imm16
 | otherwise = mov ebx imm32
val one-byte-opcode [0xbc]
 | $opndsz = mov sp imm16
 | otherwise = mov esp imm32
val one-byte-opcode [0xbd]
 | $opndsz = mov bp imm16
 | otherwise = mov ebp imm32
val one-byte-opcode [0xbe]
 | $opndsz = mov si imm16
 | otherwise = mov esi imm32
val one-byte-opcode [0xbf]
 | $opndsz = mov di imm16
 | otherwise = mov edi imm32
val one-byte-opcode [0xC6 /0] = mov r/m8 imm8
val one-byte-opcode [0xC7 /0]
 | $opndsz = mov r/m16 imm16
 | otherwise = mov r/m32 imm32

## Two Byte Opcodes with Prefix 0x0f

### CVTPD2PI Vol 2A 3-248

val twp-byte-opcode-0f [0x2d /r] = binop CVTPD2PI mm64 xmm/m128
