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
  | '00000': R1

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
 

val binop cons left right = do
 _left <- left;
 _right <- right;
 return (cons {left=_left, right=_right});
end

val / ['000111' r d d d d d r r r r] = binop ADC rd rr
