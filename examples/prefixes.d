granularity = 8
export = main decode

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

val p [0x66] = do update@{opndsz='1'}; p/66 end
val p [0xf2] = do update@{repne='1'}; p end
val p [0xf3] = do update@{rep='1'}; p end
val p [] = main

val p/66 [0xf2] = do update@{repne='1'}; p/66/f2 end
val p/66 [0xf3] = do update@{rep='1'}; p/66/f3 end
val p/66 [0x66] = p/66
val p/66 [] = do setTab main; /66 end

#val p/66/f2 [0x66] = p/f2/66
val p/66/f2 [0xf3] = do update@{rep='1'}; p/66/f2/f3 end
val p/66/f2 [0xf2] = p/66/f2
val p/66/f2 [] = do setTab p/66; /f2 end

#val p/66/f3 [0x66] = p/f2/66
val p/66/f3 [0xf2] = do update@{repne='1'}; p/66/f3/f2 end
val p/66/f3 [0xf3] = p/66/f3
val p/66/f3 [] = do setTab p/66; /f3 end

#val p/66/f2/f3 [0x66] = p/f2/f3/66
val p/66/f2/f3 [0xf2] = p/66/f3/f2
val p/66/f2/f3 [0xf3] = p/66/f2/f3
val p/66/f2/f3 [] = do try-f2/66; /f3 end

#val p/66/f3/f2 [0x66] = p/f3/f2/66
val p/66/f3/f2 [0xf2] = p/66/f3/f2
val p/66/f3/f2 [0xf3] = p/66/f2/f3
val p/66/f3/f2 [] = do try-f3/66; /f2 end

val /66 [] = do
   tab <- getTab;
   tab
end

val /f2 [] = do
   tab <- getTab;
   tab
end

val /f3 [] = do
   tab <- getTab;
   tab
end

val try-f3/f2 = do
   setTab /f2;
   /f3
end

val try-f2/f3 = do
   setTab /f3;
   /f2
end

val try-f3/66 = do
   setTab /66;
   /f3
end

val try-66/f3 = do
   setTab /f3;
   /66
end

val try-f2/66 = do
   setTab /66;
   /f2
end

val try-66/f2 = do
   setTab /f2;
   /66
end

### MOV
val main [0x51]
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
   p
end

val setTab tab = update@{tab=tab}
val getTab = query$tab

val & giveA giveB = do
   a <- giveA;
   b <- giveB;
   return (a andalso b)
end

val / act = do
   res <- act;
   return (not res)
end

val otherwise = return '1'
val opndsz? = query$opndsz
