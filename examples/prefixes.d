granularity = 8
export = / decode

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

val set-opndsz = update@{opndsz='1'}
val set-repne = update@{repne='1'}
val set-rep = update@{rep='1'}

val set-CS = update@{segment='1'}
val set-DS = update@{segment='1'}
val set-ES = update@{segment='1'}
val set-FS = update@{segment='1'}
val set-GS = update@{segment='1'}
val set-SS = update@{segment='1'}
val set-lock = update@{lock='1'}
val set-addrsz = update@{addrsz='1'}

## Decoding prefixes

val failOver first second = do
   update@{tab=second};
   r <- first;
   update@{~tab};
   return r
end

val continue = do
   t <- query$tab;
   update@{~tab};
   r <- t;
   update@{tab=t};
   return r
end

val /66 [] = continue

val /f2 [] = continue

val /f3 [] = continue


val /legacy-p [0x2e] = do clear-rex; set-CS end
val /legacy-p [0x36] = do clear-rex; set-SS end
val /legacy-p [0x3e] = do clear-rex; set-DS end
val /legacy-p [0x26] = do clear-rex; set-ES end
val /legacy-p [0x64] = do clear-rex; set-FS end
val /legacy-p [0x65] = do clear-rex; set-GS end
val /legacy-p [0x67] = do clear-rex; set-addrsz end
val /legacy-p [0xf0] = do clear-rex; set-lock end

val /rex-p ['0100 w:1 r:1 x:1 b:1'] =
   update @{rex='1', rexw=w, rexb=b, rexx=x, rexr=r}
val clear-rex = update @{rexw='0',rexb='0',rexr='0',rexx='0'}

val p64 [0x66] = do set-opndsz; p/66 end
val p64 [0xf2] = do set-repne; p/f2 end
val p64 [0xf3] = do set-rep; p/f3 end
val p64 [/legacy-p] = p64
val p64 [/rex-p] = p64
val p64 [] = /

val p/66 [0xf2] = do set-repne; p/66/f2 end
val p/66 [0xf3] = do set-rep; p/66/f3 end
val p/66 [0x66] = do set-opndsz; p/66 end
val p/66 [/legacy-p] = p/66
val p/66 [/rex-p] = p/66
val p/66 [] = failOver /66 /

val p/f2 [0x66] = do set-opndsz; p/f2/66 end
val p/f2 [0xf2] = do set-repne; p/f2 end
val p/f2 [0xf3] = do set-rep; p/f2/f3 end
val p/f2 [/legacy-p] = p/f2
val p/f2 [/rex-p] = p/f2
val p/f2 [] = failOver /f2 / 

val p/f3 [0x66] = do set-opndsz; p/f3/66 end
val p/f3 [0xf2] = do set-repne; p/f3/f2 end
val p/f3 [0xf3] = do set-rep; p/f3 end
val p/f3 [/legacy-p] = p/f3
val p/f3 [/rex-p] = p/f3
val p/f3 [] = failOver /f3 / 

val p/f2/f3 [0x66] = do set-opndsz; p/f2/f3/66 end
val p/f2/f3 [0xf2] = do set-repne; p/f3/f2 end
val p/f2/f3 [0xf3] = do set-rep; p/f2/f3 end
val p/f2/f3 [/legacy-p] = p/f2/f3
val p/f2/f3 [/rex-p] = p/f2/f3
val p/f2/f3 [] = failOver /f3 (failOver /f2 /) #p/f2

val p/f3/f2 [0x66] = do set-opndsz; p/f2/f3/66 end
val p/f3/f2 [0xf2] = do set-repne; p/f3/f2 end
val p/f3/f2 [0xf3] = do set-rep; p/f2/f3 end
val p/f3/f2 [/legacy-p] = p/f3/f2
val p/f3/f2 [/rex-p] = p/f3/f2
val p/f3/f2 [] = failOver /f2 (failOver /f3 /)

val p/66/f2 [0x66] = do set-opndsz; p/f2/66 end
val p/66/f2 [0xf2] = do set-repne; p/66/f2 end
val p/66/f2 [0xf3] = do set-rep; p/66/f2/f3 end
val p/66/f2 [/legacy-p] = p/66/f2
val p/66/f2 [/rex-p] = p/66/f2
val p/66/f2 [] = failOver /f2 p/66

val p/66/f3 [0x66] = do set-opndsz; p/f3/66 end
val p/66/f3 [0xf2] = do set-repne; p/66/f3/f2 end
val p/66/f3 [0xf3] = do set-rep; p/66/f3 end
val p/66/f3 [/legacy-p] = p/66/f3
val p/66/f3 [/rex-p] = p/66/f3
val p/66/f3 [] = failOver /f3 p/66

val p/f2/66 [0x66] = do set-opndsz; p/f2/66 end
val p/f2/66 [0xf2] = do set-repne; p/66/f2 end
val p/f2/66 [0xf3] = do set-rep; p/f2/66/f3 end
val p/f2/66 [/legacy-p] = p/f2/66
val p/f2/66 [/rex-p] = p/f2/66
val p/f2/66 [] = failOver /66 p/f2

val p/f3/66 [0x66] = do set-opndsz; p/f3/66 end
val p/f3/66 [0xf2] = do set-repne; p/f3/66/f2 end
val p/f3/66 [0xf3] = do set-rep; p/66/f3 end
val p/f3/66 [/legacy-p] = p/f3/66
val p/f3/66 [/rex-p] = p/f3/66
val p/f3/66 [] = failOver /66 p/f3

val p/66/f2/f3 [0x66] = do clear-rex; p/f2/f3/66 end
val p/66/f2/f3 [0xf2] = do clear-rex; p/66/f3/f2 end
val p/66/f2/f3 [0xf3] = do clear-rex; p/66/f2/f3 end
val p/66/f2/f3 [/legacy-p] = p/66/f2/f3
val p/66/f2/f3 [/rex-p] = p/66/f2/f3
val p/66/f2/f3 [] = failOver /f3 p/66/f2

val p/66/f3/f2 [0x66] = do clear-rex; p/f3/f2/66 end
val p/66/f3/f2 [0xf2] = do clear-rex; p/66/f3/f2 end
val p/66/f3/f2 [0xf3] = do clear-rex; p/66/f2/f3 end
val p/66/f3/f2 [/legacy-p] = p/66/f3/f2
val p/66/f3/f2 [/rex-p] = p/66/f3/f2
val p/66/f3/f2 [] = failOver /f2 p/66/f3

val p/f3/f2/66 [0x66] = do clear-rex; p/f3/f2/66 end
val p/f3/f2/66 [0xf2] = do clear-rex; p/f3/66/f2 end
val p/f3/f2/66 [0xf3] = do clear-rex; p/f2/66/f3 end
val p/f3/f2/66 [/legacy-p] = p/f3/f2/66
val p/f3/f2/66 [/rex-p] = p/f3/f2/66
val p/f3/f2/66 [] = failOver /66 p/f3/f2

val p/f2/f3/66 [0x66] = do clear-rex; p/f2/f3/66 end
val p/f2/f3/66 [0xf2] = do clear-rex; p/f3/66/f2 end
val p/f2/f3/66 [0xf3] = do clear-rex; p/f2/66/f3 end
val p/f2/f3/66 [/legacy-p] = p/f2/f3/66
val p/f2/f3/66 [/rex-p] = p/f2/f3/66
val p/f2/f3/66 [] = failOver /66 p/f2/f3

val p/f3/66/f2 [0x66] = do clear-rex; p/f3/f2/66 end
val p/f3/66/f2 [0xf2] = do clear-rex; p/f3/66/f2 end
val p/f3/66/f2 [0xf3] = do clear-rex; p/66/f2/f3 end
val p/f3/66/f2 [/legacy-p] = p/f3/66/f2
val p/f3/66/f2 [/rex-p] = p/f3/66/f2
val p/f3/66/f2 [] = failOver /f2 p/f3/66

val p/f2/66/f3 [0x66] = do clear-rex; p/f2/f3/66 end
val p/f2/66/f3 [0xf2] = do clear-rex; p/66/f3/f2 end
val p/f2/66/f3 [0xf3] = do clear-rex; p/f2/66/f3 end
val p/f2/66/f3 [/legacy-p] = p/f2/66/f3
val p/f2/66/f3 [/rex-p] = p/f2/66/f3
val p/f2/66/f3 [] = failOver /f3 p/f2/66

### MOV
val / [0x51]
 | opndsz? = return MOV_66
 | otherwise = return MOV
val /f2 [0x50] = return MOV_F2
val /f3 [0x50] = return MOV_F3

### ADD
val /f2 [0x52] = return ADD_F2

datatype insn =
   MOV_66
 | MOV_F2
 | MOV_F3
 | ADD_F2
 | MOV

val decode = do
   update
      @{mode64='1',
        repne='0',
        rep='0',
        opndsz='0'};
   p64
end

val & giveA giveB = do
   a <- giveA;
   b <- giveB;
   return (a andalso b)
end

val otherwise = return '1'
val opndsz? = query$opndsz
