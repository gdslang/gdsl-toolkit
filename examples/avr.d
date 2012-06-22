val decode = do
 update@{
  rd='',
  rr=''
 };
 /
end

datatype instruction =
   ADC of binop
 | ADD of binop

datatype register =
   R0
 | R1
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
 | R16
 | R17
 | R18
 | R19
 | R20
 | R21
 | R22
 | R23
 | R24
 | R25
 | R26
 | R27
 | R28
 | R29
 | R30
 | R31

val register-from-bits bits =
 case bits of
    '00000': R0
  | '00001': R1
  | '00010': R2
  | '00011': R3
  | '00100': R4
  | '00101': R5
  | '00110': R6
  | '00111': R7
  | '01000': R8
  | '01001': R9
  | '01010': R10
  | '01011': R11
  | '01100': R12
  | '01101': R13
  | '01110': R14
  | '01111': R15
  | '10000': R16
  | '10001': R17
  | '10010': R18
  | '10011': R19
  | '10100': R20
  | '10101': R21
  | '10110': R22
  | '10111': R23
  | '11000': R24
  | '11001': R25
  | '11010': R26
  | '11011': R27
  | '11100': R28
  | '11101': R29
  | '11110': R30
  | '11111': R31

val d bit = do
 rd <- query $rd;
 rd <- rd ^ bit;
 update@{rd=rd};
end

val r bit = do
 rr <- query $rr;
 rr <- rr ^ bit;
 update@{rr=rr};
end

val rd = do
 rd <- query $rd;
 return (register-from-bits rd)
end
 
val rr = do
 rr <- query $rd;
 return (register-from-bits rr)
end

val binop cons left right = do
 _left <- left;
 _right <- right;
 return (cons {left=_left, right=_right});
end

val / ['000111' r d d d d d r r r r] = binop ADC rd rr
