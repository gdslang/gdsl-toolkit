structure SpecLex  = struct

    datatype yystart_state = 
STRING | COMMENT | BITPATNUM | BITPAT | INITIAL
    structure UserDeclarations = 
      struct



   structure T = SpecTokens
   type lex_result = T.token

   (* used for keeping track of comment depth *)
   val depth = ref 0

   (* list of string fragments to concatenate *)
   val buf : string list ref = ref []

   (* add a string to the buffer *)
   fun addStr s = (buf := s :: !buf)

   (* make a FLOAT token from a substring *)
   fun mkFloat ss = let
	   val (isNeg, rest) =
         (case Substring.getc ss of
            SOME(#"-", r) => (true, r)
		    | SOME(#"~", r) => (true, r)
		    | _ => (false, ss))
	   val (whole, rest) = Substring.splitl Char.isDigit rest
	   val rest = Substring.triml 1 rest (* remove "." *)
	   val (frac, rest) = Substring.splitl Char.isDigit rest
	   val exp =
         if Substring.isEmpty rest
		      then 0
		   else
            let
		         val rest = Substring.triml 1 rest (* remove "e" or "E" *)
		      in
		         #1(valOf(Int.scan StringCvt.DEC Substring.getc rest))
		      end
   in
	    T.FLOAT
         (FloatLit.float
            {isNeg = isNeg,
		       whole = Substring.string whole,
		       frac = Substring.string frac,
		       exp = exp})
	end

   (* scan a number from a hexidecimal string *)
   val fromHexString = valOf o (StringCvt.scanString (IntInf.scan StringCvt.HEX))
   (* FIXME: the above code doesn't work in SML/NJ; here is a work around *)
   fun fromHexString s = let
      val SOME(n, _) =
         IntInf.scan
            StringCvt.HEX
            Substring.getc
	         (Substring.triml 2 (Substring.full s))
   in
	   n
   end

   fun eof () = T.EOF

   (* count the nesting depth of "(" inside primcode blocks *)
   fun mkString() = T.STRING (String.concat(List.rev (!buf)))


      end

    local
    datatype yymatch 
      = yyNO_MATCH
      | yyMATCH of ULexBuffer.stream * action * yymatch
    withtype action = ULexBuffer.stream * yymatch -> UserDeclarations.lex_result

    val yytable : ((UTF8.wchar * UTF8.wchar * int) list * int list) Vector.vector = 
#[([(0w0,0w31,5),
(0w127,0w2147483647,5),
(0w32,0w33,6),
(0w35,0w91,6),
(0w93,0w126,6),
(0w34,0w34,7),
(0w92,0w92,8)], []), ([(0w0,0w39,15),
(0w41,0w41,15),
(0w43,0w2147483647,15),
(0w40,0w40,16),
(0w42,0w42,17)], []), ([(0w0,0w8,20),
(0w14,0w31,20),
(0w33,0w38,20),
(0w40,0w47,20),
(0w58,0w2147483647,20),
(0w9,0w13,21),
(0w32,0w32,21),
(0w39,0w39,22),
(0w48,0w57,23)], []), ([(0w0,0w8,20),
(0w14,0w31,20),
(0w33,0w38,20),
(0w40,0w45,20),
(0w50,0w57,20),
(0w59,0w63,20),
(0w91,0w96,20),
(0w123,0w123,20),
(0w125,0w2147483647,20),
(0w9,0w13,25),
(0w32,0w32,25),
(0w39,0w39,22),
(0w46,0w46,26),
(0w48,0w49,26),
(0w124,0w124,26),
(0w47,0w47,27),
(0w65,0w90,27),
(0w97,0w122,27),
(0w58,0w58,28),
(0w64,0w64,29)], []), ([(0w0,0w8,20),
(0w14,0w31,20),
(0w127,0w2147483647,20),
(0w9,0w13,32),
(0w32,0w32,32),
(0w33,0w33,33),
(0w38,0w38,33),
(0w63,0w63,33),
(0w92,0w92,33),
(0w96,0w96,33),
(0w34,0w34,34),
(0w35,0w35,35),
(0w36,0w36,36),
(0w37,0w37,37),
(0w39,0w39,38),
(0w40,0w40,39),
(0w41,0w41,40),
(0w42,0w42,41),
(0w43,0w43,42),
(0w44,0w44,43),
(0w45,0w45,44),
(0w46,0w46,45),
(0w47,0w47,46),
(0w48,0w48,47),
(0w49,0w57,48),
(0w58,0w58,49),
(0w59,0w59,50),
(0w60,0w60,51),
(0w61,0w61,52),
(0w62,0w62,53),
(0w64,0w64,54),
(0w65,0w90,55),
(0w91,0w91,56),
(0w93,0w93,57),
(0w94,0w94,58),
(0w95,0w95,59),
(0w97,0w97,60),
(0w98,0w98,61),
(0w102,0w102,61),
(0w104,0w104,61),
(0w106,0w107,61),
(0w109,0w110,61),
(0w112,0w113,61),
(0w115,0w115,61),
(0w117,0w117,61),
(0w119,0w122,61),
(0w99,0w99,62),
(0w100,0w100,63),
(0w101,0w101,64),
(0w103,0w103,65),
(0w105,0w105,66),
(0w108,0w108,67),
(0w111,0w111,68),
(0w114,0w114,69),
(0w116,0w116,70),
(0w118,0w118,71),
(0w123,0w123,72),
(0w124,0w124,73),
(0w125,0w125,74),
(0w126,0w126,75)], []), ([], [67]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [64, 67]), ([], [65, 67]), ([(0w0,0w33,9),
(0w35,0w47,9),
(0w58,0w91,9),
(0w93,0w96,9),
(0w99,0w101,9),
(0w103,0w109,9),
(0w111,0w113,9),
(0w115,0w115,9),
(0w117,0w117,9),
(0w119,0w2147483647,9),
(0w34,0w34,10),
(0w92,0w92,10),
(0w97,0w98,10),
(0w102,0w102,10),
(0w110,0w110,10),
(0w114,0w114,10),
(0w116,0w116,10),
(0w118,0w118,10),
(0w48,0w57,11)], [67]), ([], [66]), ([], [63, 66]), ([(0w48,0w57,12)], [66]), ([(0w48,0w57,13)], []), ([], [63]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [64]), ([], [70]), ([(0w42,0w42,19)], [70]), ([(0w41,0w41,18)], [70]), ([], [69]), ([], [68]), ([], [71]), ([], [50, 71]), ([], [45, 71]), ([(0w48,0w57,24)], [54, 71]), ([(0w48,0w57,24)], [54]), ([], [49, 71]), ([(0w46,0w46,31),
(0w48,0w49,31),
(0w124,0w124,31)], [47, 71]), ([(0w39,0w39,30),
(0w45,0w45,30),
(0w47,0w57,30),
(0w63,0w63,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [48, 71]), ([], [44, 71]), ([], [46, 71]), ([(0w39,0w39,30),
(0w45,0w45,30),
(0w47,0w57,30),
(0w63,0w63,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [48]), ([(0w46,0w46,31),
(0w48,0w49,31),
(0w124,0w124,31)], [47]), ([], [58, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [53, 71]), ([], [60, 71]), ([(0w0,0w9,157),
(0w11,0w32,157),
(0w34,0w34,157),
(0w39,0w41,157),
(0w44,0w44,157),
(0w46,0w46,157),
(0w48,0w57,157),
(0w59,0w59,157),
(0w65,0w91,157),
(0w93,0w93,157),
(0w95,0w95,157),
(0w97,0w123,157),
(0w125,0w125,157),
(0w127,0w2147483647,157),
(0w10,0w10,158),
(0w33,0w33,159),
(0w35,0w38,159),
(0w42,0w43,159),
(0w45,0w45,159),
(0w47,0w47,159),
(0w58,0w58,159),
(0w60,0w64,159),
(0w92,0w92,159),
(0w94,0w94,159),
(0w96,0w96,159),
(0w124,0w124,159),
(0w126,0w126,159)], [53, 61, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [28, 53, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [19, 53, 71]), ([], [42, 71]), ([(0w42,0w42,156)], [35, 71]), ([], [36, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [26, 53, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [37, 53, 71]), ([], [30, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [38, 53, 71]), ([], [43, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w58,0w58,76),
(0w60,0w62,76),
(0w64,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76),
(0w39,0w39,83),
(0w48,0w57,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83),
(0w45,0w45,155),
(0w47,0w47,155),
(0w63,0w63,155)], [52, 53, 71]), ([(0w46,0w46,78),
(0w48,0w57,152),
(0w120,0w120,153)], [54, 71]), ([(0w46,0w46,78),
(0w48,0w57,152)], [54, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [34, 53, 71]), ([], [31, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76),
(0w45,0w45,151)], [39, 53, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [29, 53, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [40, 53, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [27, 53, 71]), ([(0w39,0w39,150),
(0w45,0w45,150),
(0w47,0w57,150),
(0w63,0w63,150),
(0w65,0w90,150),
(0w95,0w95,150),
(0w97,0w122,150)], [51, 52, 71]), ([], [21, 71]), ([], [22, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [32, 53, 71]), ([], [25, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w109,83),
(0w111,0w122,83),
(0w110,0w110,144)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,141)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w104,83),
(0w106,0w110,83),
(0w112,0w122,83),
(0w97,0w97,131),
(0w105,0w105,132),
(0w111,0w111,133)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w109,83),
(0w111,0w119,83),
(0w121,0w122,83),
(0w108,0w108,121),
(0w110,0w110,122),
(0w120,0w120,123)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w113,83),
(0w115,0w122,83),
(0w114,0w114,111)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w101,83),
(0w103,0w109,83),
(0w111,0w122,83),
(0w102,0w102,104),
(0w110,0w110,105)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,102)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w101,83),
(0w103,0w113,83),
(0w115,0w122,83),
(0w102,0w102,96),
(0w114,0w114,97)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,92)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w103,83),
(0w105,0w120,83),
(0w122,0w122,83),
(0w104,0w104,86),
(0w121,0w121,87)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,84)], [52, 71]), ([], [23, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [33, 53, 71]), ([], [24, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76),
(0w48,0w57,77)], [41, 53, 71]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [53]), ([(0w46,0w46,78),
(0w48,0w57,77)], [55]), ([(0w48,0w57,79)], []), ([(0w48,0w57,79),
(0w69,0w69,80),
(0w101,0w101,80)], [56]), ([(0w43,0w43,81),
(0w126,0w126,81),
(0w48,0w57,82)], []), ([(0w48,0w57,82)], []), ([(0w48,0w57,82)], [56]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,85)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [11, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,90)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w111,83),
(0w113,0w122,83),
(0w112,0w112,88)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,89)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [4, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w109,83),
(0w111,0w122,83),
(0w110,0w110,91)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [7, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w104,83),
(0w106,0w122,83),
(0w105,0w105,93)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w114,83),
(0w116,0w122,83),
(0w115,0w115,94)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,95)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [5, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [20, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,98)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,99)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w114,83),
(0w116,0w122,83),
(0w115,0w115,100)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,101)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [17, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,103)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [10, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [6, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w98,83),
(0w100,0w122,83),
(0w99,0w99,106)], [14, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,107)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w116,83),
(0w118,0w122,83),
(0w117,0w117,108)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w99,83),
(0w101,0w122,83),
(0w100,0w100,109)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,110)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [1, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,112)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w109,83),
(0w111,0w122,83),
(0w110,0w110,113)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w116,83),
(0w118,0w122,83),
(0w117,0w117,114)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,115)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,116)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w113,83),
(0w115,0w122,83),
(0w114,0w114,117)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w104,83),
(0w106,0w122,83),
(0w105,0w105,118)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,119)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w120,83),
(0w122,0w122,83),
(0w121,0w121,120)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [0, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w114,83),
(0w116,0w122,83),
(0w115,0w115,129)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w99,83),
(0w101,0w122,83),
(0w100,0w100,128)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w111,83),
(0w113,0w122,83),
(0w112,0w112,124)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w110,83),
(0w112,0w122,83),
(0w111,0w111,125)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w113,83),
(0w115,0w122,83),
(0w114,0w114,126)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,127)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [2, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [12, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,130)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [8, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,135)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w117,83),
(0w119,0w122,83),
(0w118,0w118,134)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [13, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [15, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,136)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,137)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w120,83),
(0w122,0w122,83),
(0w121,0w121,138)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w111,83),
(0w113,0w122,83),
(0w112,0w112,139)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,140)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [3, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w114,83),
(0w116,0w122,83),
(0w115,0w115,142)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,143)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [9, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w99,83),
(0w101,0w122,83),
(0w100,0w100,145)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,146)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,147)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w114,83),
(0w116,0w122,83),
(0w115,0w115,148)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w110,83),
(0w112,0w122,83),
(0w111,0w111,149)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [16, 52]), ([(0w39,0w39,150),
(0w45,0w45,150),
(0w47,0w57,150),
(0w63,0w63,150),
(0w65,0w90,150),
(0w95,0w95,150),
(0w97,0w122,150)], [51, 52]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w45,0w45,76),
(0w47,0w47,76),
(0w58,0w58,76),
(0w60,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76)], [18, 53]), ([(0w46,0w46,78),
(0w48,0w57,152)], [54]), ([(0w48,0w57,154),
(0w65,0w70,154),
(0w97,0w102,154)], []), ([(0w48,0w57,154),
(0w65,0w70,154),
(0w97,0w102,154)], [57]), ([(0w33,0w33,76),
(0w35,0w38,76),
(0w42,0w43,76),
(0w58,0w58,76),
(0w60,0w62,76),
(0w64,0w64,76),
(0w92,0w92,76),
(0w94,0w94,76),
(0w96,0w96,76),
(0w124,0w124,76),
(0w126,0w126,76),
(0w39,0w39,83),
(0w48,0w57,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83),
(0w45,0w45,155),
(0w47,0w47,155),
(0w63,0w63,155)], [52, 53]), ([], [59]), ([(0w0,0w9,157),
(0w11,0w2147483647,157)], [61]), ([], [62]), ([(0w0,0w9,157),
(0w11,0w32,157),
(0w34,0w34,157),
(0w39,0w41,157),
(0w44,0w44,157),
(0w46,0w46,157),
(0w48,0w57,157),
(0w59,0w59,157),
(0w65,0w91,157),
(0w93,0w93,157),
(0w95,0w95,157),
(0w97,0w123,157),
(0w125,0w125,157),
(0w127,0w2147483647,157),
(0w33,0w33,159),
(0w35,0w38,159),
(0w42,0w43,159),
(0w45,0w45,159),
(0w47,0w47,159),
(0w58,0w58,159),
(0w60,0w64,159),
(0w92,0w92,159),
(0w94,0w94,159),
(0w96,0w96,159),
(0w124,0w124,159),
(0w126,0w126,159)], [53, 61])]
    fun yystreamify' p input = ULexBuffer.mkStream (p, input)

    fun yystreamifyReader' p readFn strm = let
          val s = ref strm
	  fun iter(strm, n, accum) = 
	        if n > 1024 then (String.implode (rev accum), strm)
		else (case readFn strm
		       of NONE => (String.implode (rev accum), strm)
			| SOME(c, strm') => iter (strm', n+1, c::accum))
          fun input() = let
	        val (data, strm) = iter(!s, 0, [])
	        in
	          s := strm;
		  data
	        end
          in
            yystreamify' p input
          end

    fun yystreamifyInstream' p strm = yystreamify' p (fn ()=>TextIO.input strm)

    fun innerLex 
(yyarg as  lexErr)(yystrm_, yyss_, yysm) = let
        (* current start state *)
          val yyss = ref yyss_
	  fun YYBEGIN ss = (yyss := ss)
	(* current input stream *)
          val yystrm = ref yystrm_
	  fun yysetStrm strm = yystrm := strm
	  fun yygetPos() = ULexBuffer.getpos (!yystrm)
	  fun yystreamify input = yystreamify' (yygetPos()) input
	  fun yystreamifyReader readFn strm = yystreamifyReader' (yygetPos()) readFn strm
	  fun yystreamifyInstream strm = yystreamifyInstream' (yygetPos()) strm
        (* start position of token -- can be updated via skip() *)
	  val yystartPos = ref (yygetPos())
	(* get one char of input *)
	  fun yygetc strm = (case UTF8.getu ULexBuffer.getc strm
                of (SOME (0w10, s')) => 
		     (AntlrStreamPos.markNewLine yysm (ULexBuffer.getpos strm);
		      SOME (0w10, s'))
		 | x => x)
          fun yygetList getc strm = let
            val get1 = UTF8.getu getc
            fun iter (strm, accum) = 
	        (case get1 strm
	          of NONE => rev accum
	           | SOME (w, strm') => iter (strm', w::accum)
	         (* end case *))
          in
            iter (strm, [])
          end
	(* create yytext *)
	  fun yymksubstr(strm) = ULexBuffer.subtract (strm, !yystrm)
	  fun yymktext(strm) = Substring.string (yymksubstr strm)
	  fun yymkunicode(strm) = yygetList Substring.getc (yymksubstr strm)
          open UserDeclarations
          fun lex () = let
            fun yystuck (yyNO_MATCH) = raise Fail "lexer reached a stuck state"
	      | yystuck (yyMATCH (strm, action, old)) = 
		  action (strm, old)
	    val yypos = yygetPos()
	    fun yygetlineNo strm = AntlrStreamPos.lineNo yysm (ULexBuffer.getpos strm)
	    fun yygetcolNo  strm = AntlrStreamPos.colNo  yysm (ULexBuffer.getpos strm)
	    fun yyactsToMatches (strm, [],	  oldMatches) = oldMatches
	      | yyactsToMatches (strm, act::acts, oldMatches) = 
		  yyMATCH (strm, act, yyactsToMatches (strm, acts, oldMatches))
	    fun yygo actTable = 
		(fn (~1, _, oldMatches) => yystuck oldMatches
		  | (curState, strm, oldMatches) => let
		      val (transitions, finals') = Vector.sub (yytable, curState)
		      val finals = map (fn i => Vector.sub (actTable, i)) finals'
		      fun tryfinal() = 
		            yystuck (yyactsToMatches (strm, finals, oldMatches))
		      fun find (c, []) = NONE
			| find (c, (c1, c2, s)::ts) = 
		            if c1 <= c andalso c <= c2 then SOME s
			    else find (c, ts)
		      in case yygetc strm
			  of SOME(c, strm') => 
			       (case find (c, transitions)
				 of NONE => tryfinal()
				  | SOME n => 
				      yygo actTable
					(n, strm', 
					 yyactsToMatches (strm, finals, oldMatches)))
			   | NONE => tryfinal()
		      end)
	    val yylastwasnref = ref (ULexBuffer.lastWasNL (!yystrm))
	    fun continue() = let val yylastwasn = !yylastwasnref in
let
fun yyAction0 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_granularity)
fun yyAction1 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_include)
fun yyAction2 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_export)
fun yyAction3 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_datatype)
fun yyAction4 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_type)
fun yyAction5 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_raise)
fun yyAction6 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_if)
fun yyAction7 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_then)
fun yyAction8 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_else)
fun yyAction9 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_case)
fun yyAction10 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_let)
fun yyAction11 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_val)
fun yyAction12 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_end)
fun yyAction13 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_do)
fun yyAction14 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_in)
fun yyAction15 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_div)
fun yyAction16 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_and)
fun yyAction17 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_or)
fun yyAction18 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BIND)
fun yyAction19 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_mod)
fun yyAction20 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_of)
fun yyAction21 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LB)
fun yyAction22 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RB)
fun yyAction23 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LCB)
fun yyAction24 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RCB)
fun yyAction25 (strm, lastMatch : yymatch) = (yystrm := strm;  T.WILD)
fun yyAction26 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TIMES)
fun yyAction27 (strm, lastMatch : yymatch) = (yystrm := strm;  T.WITH)
fun yyAction28 (strm, lastMatch : yymatch) = (yystrm := strm;  T.SELECT)
fun yyAction29 (strm, lastMatch : yymatch) = (yystrm := strm;  T.EQ)
fun yyAction30 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COMMA)
fun yyAction31 (strm, lastMatch : yymatch) = (yystrm := strm;  T.SEMI)
fun yyAction32 (strm, lastMatch : yymatch) = (yystrm := strm;  T.CONCAT)
fun yyAction33 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BAR)
fun yyAction34 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COLON)
fun yyAction35 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LP)
fun yyAction36 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RP)
fun yyAction37 (strm, lastMatch : yymatch) = (yystrm := strm;  T.PLUS)
fun yyAction38 (strm, lastMatch : yymatch) = (yystrm := strm;  T.MINUS)
fun yyAction39 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LESSTHAN)
fun yyAction40 (strm, lastMatch : yymatch) = (yystrm := strm;  T.GREATERTHAN)
fun yyAction41 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TILDE)
fun yyAction42 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; T.TICK)
fun yyAction43 (strm, lastMatch : yymatch) = (yystrm := strm;  T.DOT)
fun yyAction44 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPATNUM; T.COLON)
fun yyAction45 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; T.TICK)
fun yyAction46 (strm, lastMatch : yymatch) = (yystrm := strm;  T.WITH)
fun yyAction47 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.BITSTR yytext
      end
fun yyAction48 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction49 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction50 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; skip())
fun yyAction51 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.CONS (Atom.atom yytext)
      end
fun yyAction52 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction53 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.SYMBOL (Atom.atom yytext)
      end
fun yyAction54 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(valOf (IntInf.fromString yytext))
      end
fun yyAction55 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.NEGINT(valOf (IntInf.fromString yytext))
      end
fun yyAction56 (strm, lastMatch : yymatch) = let
      val yysubstr = yymksubstr(strm)
      in
        yystrm := strm;  mkFloat yysubstr
      end
fun yyAction57 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(fromHexString yytext)
      end
fun yyAction58 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction59 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN COMMENT; depth := 1; skip())
fun yyAction60 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN STRING; skip())
fun yyAction61 (strm, lastMatch : yymatch) = (yystrm := strm;  skip())
fun yyAction62 (strm, lastMatch : yymatch) = (yystrm := strm;  skip())
fun yyAction63 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr(valOf(String.fromString yytext)); continue()
      end
fun yyAction64 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr yytext; continue()
      end
fun yyAction65 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; mkString())
fun yyAction66 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad escape character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction67 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction68 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth + 1
	;skip())
fun yyAction69 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth - 1
   ;if (!depth = 0) then YYBEGIN INITIAL else ()
	;skip ())
fun yyAction70 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction71 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad character `", String.toString yytext, "'"])
   ;continue()
      end
val yyactTable = Vector.fromList([yyAction0, yyAction1, yyAction2, yyAction3,
  yyAction4, yyAction5, yyAction6, yyAction7, yyAction8, yyAction9, yyAction10,
  yyAction11, yyAction12, yyAction13, yyAction14, yyAction15, yyAction16,
  yyAction17, yyAction18, yyAction19, yyAction20, yyAction21, yyAction22,
  yyAction23, yyAction24, yyAction25, yyAction26, yyAction27, yyAction28,
  yyAction29, yyAction30, yyAction31, yyAction32, yyAction33, yyAction34,
  yyAction35, yyAction36, yyAction37, yyAction38, yyAction39, yyAction40,
  yyAction41, yyAction42, yyAction43, yyAction44, yyAction45, yyAction46,
  yyAction47, yyAction48, yyAction49, yyAction50, yyAction51, yyAction52,
  yyAction53, yyAction54, yyAction55, yyAction56, yyAction57, yyAction58,
  yyAction59, yyAction60, yyAction61, yyAction62, yyAction63, yyAction64,
  yyAction65, yyAction66, yyAction67, yyAction68, yyAction69, yyAction70,
  yyAction71])
in
  if ULexBuffer.eof(!(yystrm))
    then let
      val yycolno = ref(yygetcolNo(!(yystrm)))
      val yylineno = ref(yygetlineNo(!(yystrm)))
      in
        (case (!(yyss))
         of _ => (UserDeclarations.eof())
        (* end case *))
      end
    else (case (!(yyss))
       of STRING => yygo yyactTable (0, !(yystrm), yyNO_MATCH)
        | COMMENT => yygo yyactTable (1, !(yystrm), yyNO_MATCH)
        | BITPATNUM => yygo yyactTable (2, !(yystrm), yyNO_MATCH)
        | BITPAT => yygo yyactTable (3, !(yystrm), yyNO_MATCH)
        | INITIAL => yygo yyactTable (4, !(yystrm), yyNO_MATCH)
      (* end case *))
end
end
            and skip() = (yystartPos := yygetPos(); 
			  yylastwasnref := ULexBuffer.lastWasNL (!yystrm);
			  continue())
	    in (continue(), (!yystartPos, yygetPos()), !yystrm, !yyss) end
          in 
            lex()
          end
  in
    type pos = AntlrStreamPos.pos
    type span = AntlrStreamPos.span
    type tok = UserDeclarations.lex_result

    datatype prestrm = STRM of ULexBuffer.stream * 
		(yystart_state * tok * span * prestrm * yystart_state) option ref
    type strm = (prestrm * yystart_state)

    fun lex sm 
(yyarg as  lexErr)(STRM (yystrm, memo), ss) = (case !memo
	  of NONE => let
	     val (tok, span, yystrm', ss') = innerLex 
yyarg(yystrm, ss, sm)
	     val strm' = STRM (yystrm', ref NONE);
	     in 
	       memo := SOME (ss, tok, span, strm', ss');
	       (tok, span, (strm', ss'))
	     end
	   | SOME (ss', tok, span, strm', ss'') => 
	       if ss = ss' then
		 (tok, span, (strm', ss''))
	       else (
		 memo := NONE;
		 lex sm 
yyarg(STRM (yystrm, memo), ss))
         (* end case *))

    fun streamify input = (STRM (yystreamify' 0 input, ref NONE), INITIAL)
    fun streamifyReader readFn strm = (STRM (yystreamifyReader' 0 readFn strm, ref NONE), 
				       INITIAL)
    fun streamifyInstream strm = (STRM (yystreamifyInstream' 0 strm, ref NONE), 
				  INITIAL)

    fun getPos (STRM (strm, _), _) = ULexBuffer.getpos strm

  end
end
