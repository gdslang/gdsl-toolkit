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
(0w59,0w64,20),
(0w91,0w96,20),
(0w123,0w2147483647,20),
(0w9,0w13,25),
(0w32,0w32,25),
(0w39,0w39,22),
(0w46,0w46,26),
(0w48,0w49,26),
(0w47,0w47,27),
(0w65,0w90,27),
(0w97,0w122,27),
(0w58,0w58,28)], []), ([(0w0,0w8,20),
(0w14,0w31,20),
(0w127,0w2147483647,20),
(0w9,0w13,31),
(0w32,0w32,31),
(0w33,0w33,32),
(0w38,0w38,32),
(0w62,0w63,32),
(0w92,0w92,32),
(0w96,0w96,32),
(0w34,0w34,33),
(0w35,0w35,34),
(0w36,0w36,35),
(0w37,0w37,36),
(0w39,0w39,37),
(0w40,0w40,38),
(0w41,0w41,39),
(0w42,0w42,40),
(0w43,0w43,41),
(0w44,0w44,42),
(0w45,0w45,43),
(0w46,0w46,44),
(0w47,0w47,45),
(0w48,0w48,46),
(0w49,0w57,47),
(0w58,0w58,48),
(0w59,0w59,49),
(0w60,0w60,50),
(0w61,0w61,51),
(0w64,0w64,52),
(0w65,0w90,53),
(0w91,0w91,54),
(0w93,0w93,55),
(0w94,0w94,56),
(0w95,0w95,57),
(0w97,0w98,58),
(0w102,0w102,58),
(0w104,0w104,58),
(0w106,0w107,58),
(0w109,0w110,58),
(0w112,0w113,58),
(0w117,0w117,58),
(0w119,0w122,58),
(0w99,0w99,59),
(0w100,0w100,60),
(0w101,0w101,61),
(0w103,0w103,62),
(0w105,0w105,63),
(0w108,0w108,64),
(0w111,0w111,65),
(0w114,0w114,66),
(0w115,0w115,67),
(0w116,0w116,68),
(0w118,0w118,69),
(0w123,0w123,70),
(0w124,0w124,71),
(0w125,0w125,72),
(0w126,0w126,73)], []), ([], [63]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [60, 63]), ([], [61, 63]), ([(0w0,0w33,9),
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
(0w48,0w57,11)], [63]), ([], [62]), ([], [59, 62]), ([(0w48,0w57,12)], [62]), ([(0w48,0w57,13)], []), ([], [59]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [60]), ([], [66]), ([(0w42,0w42,19)], [66]), ([(0w41,0w41,18)], [66]), ([], [65]), ([], [64]), ([], [67]), ([], [46, 67]), ([], [42, 67]), ([(0w48,0w57,24)], [50, 67]), ([(0w48,0w57,24)], [50]), ([], [45, 67]), ([(0w46,0w46,30),
(0w48,0w49,30)], [43, 67]), ([(0w39,0w39,29),
(0w45,0w45,29),
(0w47,0w57,29),
(0w63,0w63,29),
(0w65,0w90,29),
(0w95,0w95,29),
(0w97,0w122,29)], [44, 67]), ([], [41, 67]), ([(0w39,0w39,29),
(0w45,0w45,29),
(0w47,0w57,29),
(0w63,0w63,29),
(0w65,0w90,29),
(0w95,0w95,29),
(0w97,0w122,29)], [44]), ([(0w46,0w46,30),
(0w48,0w49,30)], [43]), ([], [54, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [49, 67]), ([], [56, 67]), ([(0w0,0w9,148),
(0w11,0w32,148),
(0w34,0w34,148),
(0w39,0w41,148),
(0w44,0w44,148),
(0w46,0w46,148),
(0w48,0w57,148),
(0w59,0w59,148),
(0w65,0w91,148),
(0w93,0w93,148),
(0w95,0w95,148),
(0w97,0w123,148),
(0w125,0w125,148),
(0w127,0w2147483647,148),
(0w10,0w10,149),
(0w33,0w33,150),
(0w35,0w38,150),
(0w42,0w43,150),
(0w45,0w45,150),
(0w47,0w47,150),
(0w58,0w58,150),
(0w60,0w64,150),
(0w92,0w92,150),
(0w94,0w94,150),
(0w96,0w96,150),
(0w124,0w124,150),
(0w126,0w126,150)], [49, 57, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [27, 49, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [18, 49, 67]), ([], [39, 67]), ([(0w42,0w42,147)], [34, 67]), ([], [35, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [25, 49, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [36, 49, 67]), ([], [29, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [37, 49, 67]), ([], [40, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w58,0w58,74),
(0w60,0w62,74),
(0w64,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74),
(0w39,0w39,81),
(0w48,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81),
(0w45,0w45,146),
(0w47,0w47,146),
(0w63,0w63,146)], [48, 49, 67]), ([(0w46,0w46,76),
(0w48,0w57,143),
(0w120,0w120,144)], [50, 67]), ([(0w46,0w46,76),
(0w48,0w57,143)], [50, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [33, 49, 67]), ([], [30, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74),
(0w45,0w45,142)], [49, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [28, 49, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [26, 49, 67]), ([(0w39,0w39,141),
(0w45,0w45,141),
(0w47,0w57,141),
(0w63,0w63,141),
(0w65,0w90,141),
(0w95,0w95,141),
(0w97,0w122,141)], [47, 48, 67]), ([], [20, 67]), ([], [21, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [31, 49, 67]), ([], [24, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,138)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w104,81),
(0w106,0w110,81),
(0w112,0w122,81),
(0w97,0w97,128),
(0w105,0w105,129),
(0w111,0w111,130)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w107,81),
(0w109,0w109,81),
(0w111,0w119,81),
(0w121,0w122,81),
(0w108,0w108,118),
(0w110,0w110,119),
(0w120,0w120,120)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w113,81),
(0w115,0w122,81),
(0w114,0w114,108)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w101,81),
(0w103,0w109,81),
(0w111,0w122,81),
(0w102,0w102,101),
(0w110,0w110,102)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,99)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w101,81),
(0w103,0w122,81),
(0w102,0w102,98)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,94)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,90)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w103,81),
(0w105,0w120,81),
(0w122,0w122,81),
(0w104,0w104,84),
(0w121,0w121,85)], [48, 67]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,82)], [48, 67]), ([], [22, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [32, 49, 67]), ([], [23, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74),
(0w48,0w57,75)], [38, 49, 67]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [49]), ([(0w46,0w46,76),
(0w48,0w57,75)], [51]), ([(0w48,0w57,77)], []), ([(0w48,0w57,77),
(0w69,0w69,78),
(0w101,0w101,78)], [52]), ([(0w43,0w43,79),
(0w126,0w126,79),
(0w48,0w57,80)], []), ([(0w48,0w57,80)], []), ([(0w48,0w57,80)], [52]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w107,81),
(0w109,0w122,81),
(0w108,0w108,83)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [12, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,88)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w111,81),
(0w113,0w122,81),
(0w112,0w112,86)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,87)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [5, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w109,81),
(0w111,0w122,81),
(0w110,0w110,89)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [8, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,91)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,92)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,93)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [1, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w104,81),
(0w106,0w122,81),
(0w105,0w105,95)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w114,81),
(0w116,0w122,81),
(0w115,0w115,96)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,97)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [6, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [19, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,100)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [11, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [7, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w98,81),
(0w100,0w122,81),
(0w99,0w99,103)], [15, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w107,81),
(0w109,0w122,81),
(0w108,0w108,104)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w116,81),
(0w118,0w122,81),
(0w117,0w117,105)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w99,81),
(0w101,0w122,81),
(0w100,0w100,106)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,107)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [2, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,109)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w109,81),
(0w111,0w122,81),
(0w110,0w110,110)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w116,81),
(0w118,0w122,81),
(0w117,0w117,111)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w107,81),
(0w109,0w122,81),
(0w108,0w108,112)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,113)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w113,81),
(0w115,0w122,81),
(0w114,0w114,114)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w104,81),
(0w106,0w122,81),
(0w105,0w105,115)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,116)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w120,81),
(0w122,0w122,81),
(0w121,0w121,117)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [0, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w114,81),
(0w116,0w122,81),
(0w115,0w115,126)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w99,81),
(0w101,0w122,81),
(0w100,0w100,125)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w111,81),
(0w113,0w122,81),
(0w112,0w112,121)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w110,81),
(0w112,0w122,81),
(0w111,0w111,122)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w113,81),
(0w115,0w122,81),
(0w114,0w114,123)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,124)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [3, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [13, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,127)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [9, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,132)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w117,81),
(0w119,0w122,81),
(0w118,0w118,131)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [14, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [16, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,133)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,134)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w120,81),
(0w122,0w122,81),
(0w121,0w121,135)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w111,81),
(0w113,0w122,81),
(0w112,0w112,136)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,137)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [4, 48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w114,81),
(0w116,0w122,81),
(0w115,0w115,139)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,140)], [48]), ([(0w39,0w39,81),
(0w45,0w45,81),
(0w47,0w57,81),
(0w63,0w63,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [10, 48]), ([(0w39,0w39,141),
(0w45,0w45,141),
(0w47,0w57,141),
(0w63,0w63,141),
(0w65,0w90,141),
(0w95,0w95,141),
(0w97,0w122,141)], [47, 48]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w45,0w45,74),
(0w47,0w47,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74)], [17, 49]), ([(0w46,0w46,76),
(0w48,0w57,143)], [50]), ([(0w48,0w57,145),
(0w65,0w70,145),
(0w97,0w102,145)], []), ([(0w48,0w57,145),
(0w65,0w70,145),
(0w97,0w102,145)], [53]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w58,0w58,74),
(0w60,0w62,74),
(0w64,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74),
(0w39,0w39,81),
(0w48,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81),
(0w45,0w45,146),
(0w47,0w47,146),
(0w63,0w63,146)], [48, 49]), ([], [55]), ([(0w0,0w9,148),
(0w11,0w2147483647,148)], [57]), ([], [58]), ([(0w0,0w9,148),
(0w11,0w32,148),
(0w34,0w34,148),
(0w39,0w41,148),
(0w44,0w44,148),
(0w46,0w46,148),
(0w48,0w57,148),
(0w59,0w59,148),
(0w65,0w91,148),
(0w93,0w93,148),
(0w95,0w95,148),
(0w97,0w123,148),
(0w125,0w125,148),
(0w127,0w2147483647,148),
(0w33,0w33,150),
(0w35,0w38,150),
(0w42,0w43,150),
(0w45,0w45,150),
(0w47,0w47,150),
(0w58,0w58,150),
(0w60,0w64,150),
(0w92,0w92,150),
(0w94,0w94,150),
(0w96,0w96,150),
(0w124,0w124,150),
(0w126,0w126,150)], [49, 57])]
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
fun yyAction1 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_state)
fun yyAction2 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_include)
fun yyAction3 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_export)
fun yyAction4 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_datatype)
fun yyAction5 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_type)
fun yyAction6 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_raise)
fun yyAction7 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_if)
fun yyAction8 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_then)
fun yyAction9 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_else)
fun yyAction10 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_case)
fun yyAction11 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_let)
fun yyAction12 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_val)
fun yyAction13 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_end)
fun yyAction14 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_do)
fun yyAction15 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_in)
fun yyAction16 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_div)
fun yyAction17 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BIND)
fun yyAction18 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_mod)
fun yyAction19 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_of)
fun yyAction20 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LB)
fun yyAction21 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RB)
fun yyAction22 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LCB)
fun yyAction23 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RCB)
fun yyAction24 (strm, lastMatch : yymatch) = (yystrm := strm;  T.WILD)
fun yyAction25 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TIMES)
fun yyAction26 (strm, lastMatch : yymatch) = (yystrm := strm;  T.WITH)
fun yyAction27 (strm, lastMatch : yymatch) = (yystrm := strm;  T.SELECT)
fun yyAction28 (strm, lastMatch : yymatch) = (yystrm := strm;  T.EQ)
fun yyAction29 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COMMA)
fun yyAction30 (strm, lastMatch : yymatch) = (yystrm := strm;  T.SEMI)
fun yyAction31 (strm, lastMatch : yymatch) = (yystrm := strm;  T.CONCAT)
fun yyAction32 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BAR)
fun yyAction33 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COLON)
fun yyAction34 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LP)
fun yyAction35 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RP)
fun yyAction36 (strm, lastMatch : yymatch) = (yystrm := strm;  T.PLUS)
fun yyAction37 (strm, lastMatch : yymatch) = (yystrm := strm;  T.MINUS)
fun yyAction38 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TILDE)
fun yyAction39 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; T.TICK)
fun yyAction40 (strm, lastMatch : yymatch) = (yystrm := strm;  T.DOT)
fun yyAction41 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPATNUM; T.COLON)
fun yyAction42 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; T.TICK)
fun yyAction43 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.BITSTR yytext
      end
fun yyAction44 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction45 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction46 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; skip())
fun yyAction47 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.CONS (Atom.atom yytext)
      end
fun yyAction48 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction49 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.SYMBOL (Atom.atom yytext)
      end
fun yyAction50 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(valOf (IntInf.fromString yytext))
      end
fun yyAction51 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.NEGINT(valOf (IntInf.fromString yytext))
      end
fun yyAction52 (strm, lastMatch : yymatch) = let
      val yysubstr = yymksubstr(strm)
      in
        yystrm := strm;  mkFloat yysubstr
      end
fun yyAction53 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(fromHexString yytext)
      end
fun yyAction54 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction55 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN COMMENT; depth := 1; skip())
fun yyAction56 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN STRING; skip())
fun yyAction57 (strm, lastMatch : yymatch) = (yystrm := strm;  skip())
fun yyAction58 (strm, lastMatch : yymatch) = (yystrm := strm;  skip())
fun yyAction59 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr(valOf(String.fromString yytext)); continue()
      end
fun yyAction60 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr yytext; continue()
      end
fun yyAction61 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; mkString())
fun yyAction62 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad escape character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction63 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction64 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth + 1
	;skip())
fun yyAction65 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth - 1
   ;if (!depth = 0) then YYBEGIN INITIAL else ()
	;skip ())
fun yyAction66 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction67 (strm, lastMatch : yymatch) = let
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
  yyAction65, yyAction66, yyAction67])
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
