


dec /s ['z:3'] = update {z=z}
dec /a ['x:2 y:3 /s'] = update {x=x, y=y}
dec /b ['w:2 v:3 u:3' /a] = update {w=w, v=v, u=u}
dec [0x11 /b] = return FOO

(*
==>

val /s z = update {z}
val /a x y z = do /s z; update {x, y} end
val /b w v u x y z = do /a x y z; update {w, v, u} end

==>
*)