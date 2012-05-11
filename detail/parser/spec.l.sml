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
(0w58,0w58,28)], []), ([(0w0,0w8,20),
(0w14,0w31,20),
(0w127,0w2147483647,20),
(0w9,0w13,31),
(0w32,0w32,31),
(0w33,0w33,32),
(0w38,0w38,32),
(0w63,0w63,32),
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
(0w62,0w62,52),
(0w64,0w64,53),
(0w65,0w90,54),
(0w91,0w91,55),
(0w93,0w93,56),
(0w94,0w94,57),
(0w95,0w95,58),
(0w97,0w97,59),
(0w98,0w98,60),
(0w102,0w102,60),
(0w104,0w104,60),
(0w106,0w107,60),
(0w109,0w110,60),
(0w112,0w113,60),
(0w115,0w115,60),
(0w117,0w117,60),
(0w120,0w122,60),
(0w99,0w99,61),
(0w100,0w100,62),
(0w101,0w101,63),
(0w103,0w103,64),
(0w105,0w105,65),
(0w108,0w108,66),
(0w111,0w111,67),
(0w114,0w114,68),
(0w116,0w116,69),
(0w118,0w118,70),
(0w119,0w119,71),
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
(0w93,0w126,14)], [64]), ([], [70]), ([(0w42,0w42,19)], [70]), ([(0w41,0w41,18)], [70]), ([], [69]), ([], [68]), ([], [71]), ([], [50, 71]), ([], [46, 71]), ([(0w48,0w57,24)], [54, 71]), ([(0w48,0w57,24)], [54]), ([], [49, 71]), ([(0w46,0w46,30),
(0w48,0w49,30),
(0w124,0w124,30)], [47, 71]), ([(0w39,0w39,29),
(0w45,0w45,29),
(0w47,0w57,29),
(0w63,0w63,29),
(0w65,0w90,29),
(0w95,0w95,29),
(0w97,0w122,29)], [48, 71]), ([], [45, 71]), ([(0w39,0w39,29),
(0w45,0w45,29),
(0w47,0w57,29),
(0w63,0w63,29),
(0w65,0w90,29),
(0w95,0w95,29),
(0w97,0w122,29)], [48]), ([(0w46,0w46,30),
(0w48,0w49,30),
(0w124,0w124,30)], [47]), ([], [58, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [53, 71]), ([], [60, 71]), ([(0w0,0w9,160),
(0w11,0w32,160),
(0w34,0w34,160),
(0w39,0w41,160),
(0w44,0w44,160),
(0w46,0w46,160),
(0w48,0w57,160),
(0w59,0w59,160),
(0w65,0w91,160),
(0w93,0w93,160),
(0w95,0w95,160),
(0w97,0w123,160),
(0w125,0w125,160),
(0w127,0w2147483647,160),
(0w10,0w10,161),
(0w33,0w33,162),
(0w35,0w38,162),
(0w42,0w43,162),
(0w45,0w45,162),
(0w47,0w47,162),
(0w58,0w58,162),
(0w60,0w64,162),
(0w92,0w92,162),
(0w94,0w94,162),
(0w96,0w96,162),
(0w124,0w124,162),
(0w126,0w126,162)], [53, 61, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [20, 53, 71]), ([], [43, 71]), ([(0w42,0w42,159)], [36, 71]), ([], [37, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [27, 53, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [38, 53, 71]), ([], [31, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [39, 53, 71]), ([], [44, 71]), ([(0w33,0w33,76),
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
(0w45,0w45,158),
(0w47,0w47,158),
(0w63,0w63,158)], [52, 53, 71]), ([(0w46,0w46,78),
(0w48,0w57,155),
(0w120,0w120,156)], [54, 71]), ([(0w46,0w46,78),
(0w48,0w57,155)], [54, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [35, 53, 71]), ([], [32, 71]), ([(0w33,0w33,76),
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
(0w45,0w45,154)], [40, 53, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [30, 53, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [41, 53, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [28, 53, 71]), ([(0w39,0w39,153),
(0w45,0w45,153),
(0w47,0w57,153),
(0w63,0w63,153),
(0w65,0w90,153),
(0w95,0w95,153),
(0w97,0w122,153)], [51, 52, 71]), ([], [22, 71]), ([], [23, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [33, 53, 71]), ([], [26, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w109,83),
(0w111,0w122,83),
(0w110,0w110,147)], [52, 71]), ([(0w39,0w39,83),
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
(0w97,0w97,144)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w104,83),
(0w106,0w110,83),
(0w112,0w122,83),
(0w97,0w97,134),
(0w105,0w105,135),
(0w111,0w111,136)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w109,83),
(0w111,0w119,83),
(0w121,0w122,83),
(0w108,0w108,124),
(0w110,0w110,125),
(0w120,0w120,126)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w113,83),
(0w115,0w122,83),
(0w114,0w114,114)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w101,83),
(0w103,0w109,83),
(0w111,0w122,83),
(0w102,0w102,107),
(0w110,0w110,108)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,105)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w101,83),
(0w103,0w113,83),
(0w115,0w122,83),
(0w102,0w102,99),
(0w114,0w114,100)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,95)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w103,83),
(0w105,0w120,83),
(0w122,0w122,83),
(0w104,0w104,89),
(0w121,0w121,90)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,87)], [52, 71]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w104,83),
(0w106,0w122,83),
(0w105,0w105,84)], [52, 71]), ([], [24, 71]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [34, 53, 71]), ([], [25, 71]), ([(0w33,0w33,76),
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
(0w48,0w57,77)], [42, 53, 71]), ([(0w33,0w33,76),
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
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,85)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w103,83),
(0w105,0w122,83),
(0w104,0w104,86)], [52]), ([(0w39,0w39,83),
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
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,88)], [52]), ([(0w39,0w39,83),
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
(0w101,0w101,93)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w111,83),
(0w113,0w122,83),
(0w112,0w112,91)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,92)], [52]), ([(0w39,0w39,83),
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
(0w97,0w109,83),
(0w111,0w122,83),
(0w110,0w110,94)], [52]), ([(0w39,0w39,83),
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
(0w97,0w104,83),
(0w106,0w122,83),
(0w105,0w105,96)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w114,83),
(0w116,0w122,83),
(0w115,0w115,97)], [52]), ([(0w39,0w39,83),
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
(0w97,0w122,83)], [6, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [21, 52]), ([(0w39,0w39,83),
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
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,102)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w114,83),
(0w116,0w122,83),
(0w115,0w115,103)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,104)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [18, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,106)], [52]), ([(0w39,0w39,83),
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
(0w97,0w122,83)], [7, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w98,83),
(0w100,0w122,83),
(0w99,0w99,109)], [15, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,110)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w116,83),
(0w118,0w122,83),
(0w117,0w117,111)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w99,83),
(0w101,0w122,83),
(0w100,0w100,112)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,113)], [52]), ([(0w39,0w39,83),
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
(0w98,0w122,83),
(0w97,0w97,115)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w109,83),
(0w111,0w122,83),
(0w110,0w110,116)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w116,83),
(0w118,0w122,83),
(0w117,0w117,117)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,118)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,119)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w113,83),
(0w115,0w122,83),
(0w114,0w114,120)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w104,83),
(0w106,0w122,83),
(0w105,0w105,121)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,122)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w120,83),
(0w122,0w122,83),
(0w121,0w121,123)], [52]), ([(0w39,0w39,83),
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
(0w115,0w115,132)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w99,83),
(0w101,0w122,83),
(0w100,0w100,131)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w111,83),
(0w113,0w122,83),
(0w112,0w112,127)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w110,83),
(0w112,0w122,83),
(0w111,0w111,128)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w113,83),
(0w115,0w122,83),
(0w114,0w114,129)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,130)], [52]), ([(0w39,0w39,83),
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
(0w97,0w122,83)], [13, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,133)], [52]), ([(0w39,0w39,83),
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
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,138)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w117,83),
(0w119,0w122,83),
(0w118,0w118,137)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [14, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [16, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,139)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w115,83),
(0w117,0w122,83),
(0w116,0w116,140)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w120,83),
(0w122,0w122,83),
(0w121,0w121,141)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w111,83),
(0w113,0w122,83),
(0w112,0w112,142)], [52]), ([(0w39,0w39,83),
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
(0w97,0w122,83)], [4, 52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w114,83),
(0w116,0w122,83),
(0w115,0w115,145)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w100,83),
(0w102,0w122,83),
(0w101,0w101,146)], [52]), ([(0w39,0w39,83),
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
(0w97,0w99,83),
(0w101,0w122,83),
(0w100,0w100,148)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w98,0w122,83),
(0w97,0w97,149)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w107,83),
(0w109,0w122,83),
(0w108,0w108,150)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w114,83),
(0w116,0w122,83),
(0w115,0w115,151)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w110,83),
(0w112,0w122,83),
(0w111,0w111,152)], [52]), ([(0w39,0w39,83),
(0w45,0w45,83),
(0w47,0w57,83),
(0w63,0w63,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83)], [17, 52]), ([(0w39,0w39,153),
(0w45,0w45,153),
(0w47,0w57,153),
(0w63,0w63,153),
(0w65,0w90,153),
(0w95,0w95,153),
(0w97,0w122,153)], [51, 52]), ([(0w33,0w33,76),
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
(0w126,0w126,76)], [19, 53]), ([(0w46,0w46,78),
(0w48,0w57,155)], [54]), ([(0w48,0w57,157),
(0w65,0w70,157),
(0w97,0w102,157)], []), ([(0w48,0w57,157),
(0w65,0w70,157),
(0w97,0w102,157)], [57]), ([(0w33,0w33,76),
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
(0w45,0w45,158),
(0w47,0w47,158),
(0w63,0w63,158)], [52, 53]), ([], [59]), ([(0w0,0w9,160),
(0w11,0w2147483647,160)], [61]), ([], [62]), ([(0w0,0w9,160),
(0w11,0w32,160),
(0w34,0w34,160),
(0w39,0w41,160),
(0w44,0w44,160),
(0w46,0w46,160),
(0w48,0w57,160),
(0w59,0w59,160),
(0w65,0w91,160),
(0w93,0w93,160),
(0w95,0w95,160),
(0w97,0w123,160),
(0w125,0w125,160),
(0w127,0w2147483647,160),
(0w33,0w33,162),
(0w35,0w38,162),
(0w42,0w43,162),
(0w45,0w45,162),
(0w47,0w47,162),
(0w58,0w58,162),
(0w60,0w64,162),
(0w92,0w92,162),
(0w94,0w94,162),
(0w96,0w96,162),
(0w124,0w124,162),
(0w126,0w126,162)], [53, 61])]
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
fun yyAction1 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_with)
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
fun yyAction17 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_and)
fun yyAction18 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_or)
fun yyAction19 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BIND)
fun yyAction20 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_mod)
fun yyAction21 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_of)
fun yyAction22 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LB)
fun yyAction23 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RB)
fun yyAction24 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LCB)
fun yyAction25 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RCB)
fun yyAction26 (strm, lastMatch : yymatch) = (yystrm := strm;  T.WILD)
fun yyAction27 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TIMES)
fun yyAction28 (strm, lastMatch : yymatch) = (yystrm := strm;  T.WITH)
fun yyAction29 (strm, lastMatch : yymatch) = (yystrm := strm;  T.SELECT)
fun yyAction30 (strm, lastMatch : yymatch) = (yystrm := strm;  T.EQ)
fun yyAction31 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COMMA)
fun yyAction32 (strm, lastMatch : yymatch) = (yystrm := strm;  T.SEMI)
fun yyAction33 (strm, lastMatch : yymatch) = (yystrm := strm;  T.CONCAT)
fun yyAction34 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BAR)
fun yyAction35 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COLON)
fun yyAction36 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LP)
fun yyAction37 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RP)
fun yyAction38 (strm, lastMatch : yymatch) = (yystrm := strm;  T.PLUS)
fun yyAction39 (strm, lastMatch : yymatch) = (yystrm := strm;  T.MINUS)
fun yyAction40 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LESSTHAN)
fun yyAction41 (strm, lastMatch : yymatch) = (yystrm := strm;  T.GREATERTHAN)
fun yyAction42 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TILDE)
fun yyAction43 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; T.TICK)
fun yyAction44 (strm, lastMatch : yymatch) = (yystrm := strm;  T.DOT)
fun yyAction45 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPATNUM; T.COLON)
fun yyAction46 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; T.TICK)
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
