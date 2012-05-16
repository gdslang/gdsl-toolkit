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
(0w62,0w63,33),
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
(0w119,0w122,60),
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
(0w123,0w123,71),
(0w124,0w124,72),
(0w125,0w125,73),
(0w126,0w126,74)], []), ([], [65]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [62, 65]), ([], [63, 65]), ([(0w0,0w33,9),
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
(0w48,0w57,11)], [65]), ([], [64]), ([], [61, 64]), ([(0w48,0w57,12)], [64]), ([(0w48,0w57,13)], []), ([], [61]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [62]), ([], [68]), ([(0w42,0w42,19)], [68]), ([(0w41,0w41,18)], [68]), ([], [67]), ([], [66]), ([], [69]), ([], [48, 69]), ([], [43, 69]), ([(0w48,0w57,24)], [52, 69]), ([(0w48,0w57,24)], [52]), ([], [47, 69]), ([(0w46,0w46,31),
(0w48,0w49,31),
(0w124,0w124,31)], [45, 69]), ([(0w39,0w39,30),
(0w45,0w45,30),
(0w47,0w57,30),
(0w63,0w63,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [46, 69]), ([], [42, 69]), ([], [44, 69]), ([(0w39,0w39,30),
(0w45,0w45,30),
(0w47,0w57,30),
(0w63,0w63,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [46]), ([(0w46,0w46,31),
(0w48,0w49,31),
(0w124,0w124,31)], [45]), ([], [56, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [51, 69]), ([], [58, 69]), ([(0w0,0w9,156),
(0w11,0w32,156),
(0w34,0w34,156),
(0w39,0w41,156),
(0w44,0w44,156),
(0w46,0w46,156),
(0w48,0w57,156),
(0w59,0w59,156),
(0w65,0w91,156),
(0w93,0w93,156),
(0w95,0w95,156),
(0w97,0w123,156),
(0w125,0w125,156),
(0w127,0w2147483647,156),
(0w10,0w10,157),
(0w33,0w33,158),
(0w35,0w38,158),
(0w42,0w43,158),
(0w45,0w45,158),
(0w47,0w47,158),
(0w58,0w58,158),
(0w60,0w64,158),
(0w92,0w92,158),
(0w94,0w94,158),
(0w96,0w96,158),
(0w124,0w124,158),
(0w126,0w126,158)], [51, 59, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [28, 51, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [19, 51, 69]), ([], [40, 69]), ([(0w42,0w42,155)], [35, 69]), ([], [36, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [26, 51, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [37, 51, 69]), ([], [30, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [38, 51, 69]), ([], [41, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w58,0w58,75),
(0w60,0w62,75),
(0w64,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75),
(0w39,0w39,82),
(0w48,0w57,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82),
(0w45,0w45,154),
(0w47,0w47,154),
(0w63,0w63,154)], [50, 51, 69]), ([(0w46,0w46,77),
(0w48,0w57,151),
(0w120,0w120,152)], [52, 69]), ([(0w46,0w46,77),
(0w48,0w57,151)], [52, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [34, 51, 69]), ([], [31, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75),
(0w45,0w45,150)], [51, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [29, 51, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [27, 51, 69]), ([(0w39,0w39,149),
(0w45,0w45,149),
(0w47,0w57,149),
(0w63,0w63,149),
(0w65,0w90,149),
(0w95,0w95,149),
(0w97,0w122,149)], [49, 50, 69]), ([], [21, 69]), ([], [22, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [32, 51, 69]), ([], [25, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w109,82),
(0w111,0w122,82),
(0w110,0w110,143)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w98,0w122,82),
(0w97,0w97,140)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w98,0w104,82),
(0w106,0w110,82),
(0w112,0w122,82),
(0w97,0w97,130),
(0w105,0w105,131),
(0w111,0w111,132)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w107,82),
(0w109,0w109,82),
(0w111,0w119,82),
(0w121,0w122,82),
(0w108,0w108,120),
(0w110,0w110,121),
(0w120,0w120,122)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w113,82),
(0w115,0w122,82),
(0w114,0w114,110)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w101,82),
(0w103,0w109,82),
(0w111,0w122,82),
(0w102,0w102,103),
(0w110,0w110,104)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,101)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w101,82),
(0w103,0w113,82),
(0w115,0w122,82),
(0w102,0w102,95),
(0w114,0w114,96)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w98,0w122,82),
(0w97,0w97,91)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w103,82),
(0w105,0w120,82),
(0w122,0w122,82),
(0w104,0w104,85),
(0w121,0w121,86)], [50, 69]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w98,0w122,82),
(0w97,0w97,83)], [50, 69]), ([], [23, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [33, 51, 69]), ([], [24, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75),
(0w48,0w57,76)], [39, 51, 69]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [51]), ([(0w46,0w46,77),
(0w48,0w57,76)], [53]), ([(0w48,0w57,78)], []), ([(0w48,0w57,78),
(0w69,0w69,79),
(0w101,0w101,79)], [54]), ([(0w43,0w43,80),
(0w126,0w126,80),
(0w48,0w57,81)], []), ([(0w48,0w57,81)], []), ([(0w48,0w57,81)], [54]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w107,82),
(0w109,0w122,82),
(0w108,0w108,84)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [11, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,89)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w111,82),
(0w113,0w122,82),
(0w112,0w112,87)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,88)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [4, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w109,82),
(0w111,0w122,82),
(0w110,0w110,90)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [7, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w104,82),
(0w106,0w122,82),
(0w105,0w105,92)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w114,82),
(0w116,0w122,82),
(0w115,0w115,93)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,94)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [5, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [20, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,97)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w107,82),
(0w109,0w122,82),
(0w108,0w108,98)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w114,82),
(0w116,0w122,82),
(0w115,0w115,99)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,100)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [17, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w115,82),
(0w117,0w122,82),
(0w116,0w116,102)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [10, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [6, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w98,82),
(0w100,0w122,82),
(0w99,0w99,105)], [14, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w107,82),
(0w109,0w122,82),
(0w108,0w108,106)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w116,82),
(0w118,0w122,82),
(0w117,0w117,107)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w99,82),
(0w101,0w122,82),
(0w100,0w100,108)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,109)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [1, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w98,0w122,82),
(0w97,0w97,111)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w109,82),
(0w111,0w122,82),
(0w110,0w110,112)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w116,82),
(0w118,0w122,82),
(0w117,0w117,113)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w107,82),
(0w109,0w122,82),
(0w108,0w108,114)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w98,0w122,82),
(0w97,0w97,115)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w113,82),
(0w115,0w122,82),
(0w114,0w114,116)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w104,82),
(0w106,0w122,82),
(0w105,0w105,117)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w115,82),
(0w117,0w122,82),
(0w116,0w116,118)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w120,82),
(0w122,0w122,82),
(0w121,0w121,119)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [0, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w114,82),
(0w116,0w122,82),
(0w115,0w115,128)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w99,82),
(0w101,0w122,82),
(0w100,0w100,127)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w111,82),
(0w113,0w122,82),
(0w112,0w112,123)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w110,82),
(0w112,0w122,82),
(0w111,0w111,124)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w113,82),
(0w115,0w122,82),
(0w114,0w114,125)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w115,82),
(0w117,0w122,82),
(0w116,0w116,126)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [2, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [12, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,129)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [8, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w115,82),
(0w117,0w122,82),
(0w116,0w116,134)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w117,82),
(0w119,0w122,82),
(0w118,0w118,133)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [13, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [15, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w98,0w122,82),
(0w97,0w97,135)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w115,82),
(0w117,0w122,82),
(0w116,0w116,136)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w120,82),
(0w122,0w122,82),
(0w121,0w121,137)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w111,82),
(0w113,0w122,82),
(0w112,0w112,138)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,139)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [3, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w114,82),
(0w116,0w122,82),
(0w115,0w115,141)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w100,82),
(0w102,0w122,82),
(0w101,0w101,142)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [9, 50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w99,82),
(0w101,0w122,82),
(0w100,0w100,144)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w98,0w122,82),
(0w97,0w97,145)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w107,82),
(0w109,0w122,82),
(0w108,0w108,146)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w114,82),
(0w116,0w122,82),
(0w115,0w115,147)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w110,82),
(0w112,0w122,82),
(0w111,0w111,148)], [50]), ([(0w39,0w39,82),
(0w45,0w45,82),
(0w47,0w57,82),
(0w63,0w63,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82)], [16, 50]), ([(0w39,0w39,149),
(0w45,0w45,149),
(0w47,0w57,149),
(0w63,0w63,149),
(0w65,0w90,149),
(0w95,0w95,149),
(0w97,0w122,149)], [49, 50]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w45,0w45,75),
(0w47,0w47,75),
(0w58,0w58,75),
(0w60,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75)], [18, 51]), ([(0w46,0w46,77),
(0w48,0w57,151)], [52]), ([(0w48,0w57,153),
(0w65,0w70,153),
(0w97,0w102,153)], []), ([(0w48,0w57,153),
(0w65,0w70,153),
(0w97,0w102,153)], [55]), ([(0w33,0w33,75),
(0w35,0w38,75),
(0w42,0w43,75),
(0w58,0w58,75),
(0w60,0w62,75),
(0w64,0w64,75),
(0w92,0w92,75),
(0w94,0w94,75),
(0w96,0w96,75),
(0w124,0w124,75),
(0w126,0w126,75),
(0w39,0w39,82),
(0w48,0w57,82),
(0w65,0w90,82),
(0w95,0w95,82),
(0w97,0w122,82),
(0w45,0w45,154),
(0w47,0w47,154),
(0w63,0w63,154)], [50, 51]), ([], [57]), ([(0w0,0w9,156),
(0w11,0w2147483647,156)], [59]), ([], [60]), ([(0w0,0w9,156),
(0w11,0w32,156),
(0w34,0w34,156),
(0w39,0w41,156),
(0w44,0w44,156),
(0w46,0w46,156),
(0w48,0w57,156),
(0w59,0w59,156),
(0w65,0w91,156),
(0w93,0w93,156),
(0w95,0w95,156),
(0w97,0w123,156),
(0w125,0w125,156),
(0w127,0w2147483647,156),
(0w33,0w33,158),
(0w35,0w38,158),
(0w42,0w43,158),
(0w45,0w45,158),
(0w47,0w47,158),
(0w58,0w58,158),
(0w60,0w64,158),
(0w92,0w92,158),
(0w94,0w94,158),
(0w96,0w96,158),
(0w124,0w124,158),
(0w126,0w126,158)], [51, 59])]
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
fun yyAction39 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TILDE)
fun yyAction40 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; T.TICK)
fun yyAction41 (strm, lastMatch : yymatch) = (yystrm := strm;  T.DOT)
fun yyAction42 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPATNUM; T.COLON)
fun yyAction43 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; T.TICK)
fun yyAction44 (strm, lastMatch : yymatch) = (yystrm := strm;  T.WITH)
fun yyAction45 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.BITSTR yytext
      end
fun yyAction46 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction47 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction48 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; skip())
fun yyAction49 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.CONS (Atom.atom yytext)
      end
fun yyAction50 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction51 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.SYMBOL (Atom.atom yytext)
      end
fun yyAction52 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(valOf (IntInf.fromString yytext))
      end
fun yyAction53 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.NEGINT(valOf (IntInf.fromString yytext))
      end
fun yyAction54 (strm, lastMatch : yymatch) = let
      val yysubstr = yymksubstr(strm)
      in
        yystrm := strm;  mkFloat yysubstr
      end
fun yyAction55 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(fromHexString yytext)
      end
fun yyAction56 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction57 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN COMMENT; depth := 1; skip())
fun yyAction58 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN STRING; skip())
fun yyAction59 (strm, lastMatch : yymatch) = (yystrm := strm;  skip())
fun yyAction60 (strm, lastMatch : yymatch) = (yystrm := strm;  skip())
fun yyAction61 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr(valOf(String.fromString yytext)); continue()
      end
fun yyAction62 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr yytext; continue()
      end
fun yyAction63 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; mkString())
fun yyAction64 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad escape character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction65 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction66 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth + 1
	;skip())
fun yyAction67 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth - 1
   ;if (!depth = 0) then YYBEGIN INITIAL else ()
	;skip ())
fun yyAction68 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction69 (strm, lastMatch : yymatch) = let
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
  yyAction65, yyAction66, yyAction67, yyAction68, yyAction69])
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
