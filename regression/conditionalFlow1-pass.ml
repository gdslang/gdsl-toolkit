# tests that both branches of an if-statement are flowing into the result

val ite c t e  = if c then t else e

val res = $sum (ite '1' {bar=1,sum=7} {sum=8,zoo=9})

