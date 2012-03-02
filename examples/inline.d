
dec /s ['z:3'] = update {z=z}
dec /a ['x:2 y:3 /s'] = update {x=x, y=y}
dec /b ['w:2 v:3 u:3' /a] = update {w=w, v=v, u=u}
dec [0x11 /b] = return FOO
