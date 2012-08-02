# tests that both branches of an if-statement are flowing into the result

val foo = if '1' then {bar=1,sum=7} else {sum=8,zoo=9}

val bar = $sum foo
