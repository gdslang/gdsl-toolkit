granularity = 32
export = config-default decode

val size r = do
  size <- query $..
  return (r@{size=size})
end

val ternop cons a b c = do
  r <- a {};
  r <- b r;
  r <- c r;
  return (cons r);
end

### ADD
###  - ADD
val / ['000000 gr:5 gt:5 gg:5 00000 100000'] = ternop ADD (return (GPR (gpr-from-bits gr))) (return (GPR (gpr-from-bits gt))) (return (GPR (gpr-from-bits gg)))


val config-default = ''

val decode config = do
  update@{ck=''};
  /
end

type imm =
   IMM16 of 16

type operand =
   GPR of register
 | FPR of register
 | IMM of imm

type quinop = {first:operand,second:operand,third:operand,fourth:operand,fifth:operand}
type quadop = {first:operand,second:operand,third:operand,fourth:operand}
type ternop = {first:operand,second:operand,third:operand}
type binop = {first:operand,second:operand}
type unop = {operand:operand}

type instruction =
   ADD of ternop

type register =
   R of int
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

val gpr-from-bits bits = (R (zx bits))
val fpr-from-bits bits = (F (zx bits))

val quinop cons first second third fourth fifth = do
 first <- first;
 second <- second;
 third <- third;
 fourth <- fourth;
 fifth <- fifth;
 return (cons {first=first, second=second, third=third, fourth=fourth, fifth=fifth})
end

val quadop cons first second third fourth = do
 first <- first;
 second <- second;
 third <- third;
 fourth <- fourth;
 return (cons {first=first, second=second, third=third, fourth=fourth})
end

val ternop cons first second third = do
 first <- first;
 second <- second;
 third <- third;
 return (cons {first=first, second=second, third=third})
end

val binop cons first second = do
 first <- first;
 second <- second;
 return (cons {first=first, second=second})
end

val unop cons operand = do
 operand <- operand;
 return (cons {operand=operand})
end

val nullop cons = do
 return cons
end

