structure SpecLex  = struct

    datatype yystart_state = 
STRING | COMMENT | BITPATNUM | BITPAT | INITIAL
    structure UserDeclarations = 
      struct



    structure T = SpecTokens

  (* some type lex_result is necessitated by ml-ulex *)
    type lex_result = T.token

  (* the depth int ref will be used for keeping track of comment depth *)
    val depth = ref 0

  (* list of string fragments to concatenate *)
    val buf : string list ref = ref []

  (* add a string to the buffer *)
    fun addStr s = (buf := s :: !buf)

  (* make a FLOAT token from a substring *)
    fun mkFloat ss = let
	  val (isNeg, rest) = (case Substring.getc ss
		 of SOME(#"-", r) => (true, r)
		  | SOME(#"~", r) => (true, r)
		  | _ => (false, ss)
		(* end case *))
	  val (whole, rest) = Substring.splitl Char.isDigit rest
	  val rest = Substring.triml 1 rest (* remove "." *)
	  val (frac, rest) = Substring.splitl Char.isDigit rest
	  val exp = if Substring.isEmpty rest
		then 0
		else let
		  val rest = Substring.triml 1 rest (* remove "e" or "E" *)
		  in
		    #1(valOf(Int.scan StringCvt.DEC Substring.getc rest))
		  end
	  in
	    T.FLOAT(FloatLit.float{
		isNeg = isNeg,
		whole = Substring.string whole,
		frac = Substring.string frac,
		exp = exp
	      })
	  end

  (* scan a number from a hexidecimal string *)
    val fromHexString = valOf o (StringCvt.scanString (IntInf.scan StringCvt.HEX))
(* FIXME: the above code doesn't work in SML/NJ; here is a work around *)
fun fromHexString s = let
      val SOME(n, _) = IntInf.scan StringCvt.HEX Substring.getc
	    (Substring.triml 2 (Substring.full s))
      in
	n
      end

  (* convert a HLOp ID to an atom *)
    fun cvtHLOpId id = Atom.atom(String.extract(id, 1, NONE))

  (* split a qualified ID up into its prefix and id parts *)
    fun makeQualifiedId cvtId id = let
	  fun revMap ([], l) = l
	    | revMap (x::xs, l) = revMap(xs, Atom.atom x :: l)
	  in
	    case List.rev (String.tokens (fn c => c = #".") id)
	      of (id::path) => (revMap (path, []), cvtId id)
	       | _ => raise Fail "bogus qualified ID"
	    (* end case *)
	  end

    val mkQId = makeQualifiedId Atom.atom
    val mkQHLOpId = makeQualifiedId cvtHLOpId

  (* eof : unit -> lex_result *)
  (* ml-ulex requires this as well *)
    fun eof () = T.EOF

  (* count the nesting depth of "(" inside primcode blocks *)
    val primDepth = ref 0
    fun inPrimCode () = (!primDepth > 0)
    fun primPush () = (primDepth := !primDepth + 1)
    fun primPop () = let val p = !primDepth-1 in primDepth := p; (p > 0) end
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
(0w126,0w126,73)], []), ([], [64]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [61, 64]), ([], [62, 64]), ([(0w0,0w33,9),
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
(0w48,0w57,11)], [64]), ([], [63]), ([], [60, 63]), ([(0w48,0w57,12)], [63]), ([(0w48,0w57,13)], []), ([], [60]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [61]), ([], [67]), ([(0w42,0w42,19)], [67]), ([(0w41,0w41,18)], [67]), ([], [66]), ([], [65]), ([], [68]), ([], [48, 68]), ([], [44, 68]), ([(0w48,0w57,24)], [52, 68]), ([(0w48,0w57,24)], [52]), ([], [47, 68]), ([(0w46,0w46,30),
(0w48,0w49,30)], [45, 68]), ([(0w45,0w45,29),
(0w47,0w57,29),
(0w65,0w90,29),
(0w95,0w95,29),
(0w97,0w122,29)], [46, 68]), ([], [43, 68]), ([(0w45,0w45,29),
(0w47,0w57,29),
(0w65,0w90,29),
(0w95,0w95,29),
(0w97,0w122,29)], [46]), ([(0w46,0w46,30),
(0w48,0w49,30)], [45]), ([], [56, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [51, 68]), ([], [58, 68]), ([(0w0,0w9,152),
(0w11,0w32,152),
(0w34,0w34,152),
(0w39,0w41,152),
(0w44,0w44,152),
(0w46,0w46,152),
(0w48,0w57,152),
(0w59,0w59,152),
(0w65,0w91,152),
(0w93,0w93,152),
(0w95,0w95,152),
(0w97,0w123,152),
(0w125,0w125,152),
(0w127,0w2147483647,152),
(0w33,0w33,153),
(0w35,0w38,153),
(0w42,0w43,153),
(0w45,0w45,153),
(0w47,0w47,153),
(0w58,0w58,153),
(0w60,0w64,153),
(0w92,0w92,153),
(0w94,0w94,153),
(0w96,0w96,153),
(0w124,0w124,153),
(0w126,0w126,153)], [51, 59, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [29, 51, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [20, 51, 68]), ([], [41, 68]), ([(0w42,0w42,151)], [36, 68]), ([], [37, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [27, 51, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [38, 51, 68]), ([], [31, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [39, 51, 68]), ([], [42, 68]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74),
(0w45,0w45,150),
(0w47,0w47,150),
(0w48,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [50, 51, 68]), ([(0w46,0w46,76),
(0w48,0w57,147),
(0w120,0w120,148)], [52, 68]), ([(0w46,0w46,76),
(0w48,0w57,147)], [52, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [35, 51, 68]), ([], [32, 68]), ([(0w33,0w33,74),
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
(0w45,0w45,146)], [51, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [30, 51, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [28, 51, 68]), ([(0w45,0w45,145),
(0w47,0w57,145),
(0w65,0w90,145),
(0w95,0w95,145),
(0w97,0w122,145)], [49, 50, 68]), ([], [22, 68]), ([], [23, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [33, 51, 68]), ([], [26, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,142)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w100,81),
(0w102,0w104,81),
(0w106,0w110,81),
(0w112,0w122,81),
(0w97,0w97,130),
(0w101,0w101,131),
(0w105,0w105,132),
(0w111,0w111,133)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w107,81),
(0w109,0w109,81),
(0w111,0w119,81),
(0w121,0w122,81),
(0w108,0w108,120),
(0w110,0w110,121),
(0w120,0w120,122)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w113,81),
(0w115,0w122,81),
(0w114,0w114,110)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w101,81),
(0w103,0w109,81),
(0w111,0w122,81),
(0w102,0w102,103),
(0w110,0w110,104)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,101)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w101,81),
(0w103,0w122,81),
(0w102,0w102,100)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w100,81),
(0w102,0w122,81),
(0w97,0w97,94),
(0w101,0w101,95)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,90)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w103,81),
(0w105,0w120,81),
(0w122,0w122,81),
(0w104,0w104,84),
(0w121,0w121,85)], [50, 68]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,82)], [50, 68]), ([], [24, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [34, 51, 68]), ([], [25, 68]), ([(0w33,0w33,74),
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
(0w48,0w57,75)], [40, 51, 68]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [51]), ([(0w46,0w46,76),
(0w48,0w57,75)], [53]), ([(0w48,0w57,77)], []), ([(0w48,0w57,77),
(0w69,0w69,78),
(0w101,0w101,78)], [54]), ([(0w43,0w43,79),
(0w126,0w126,79),
(0w48,0w57,80)], []), ([(0w48,0w57,80)], []), ([(0w48,0w57,80)], [54]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w107,81),
(0w109,0w122,81),
(0w108,0w108,83)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [13, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,88)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w111,81),
(0w113,0w122,81),
(0w112,0w112,86)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,87)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [5, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w109,81),
(0w111,0w122,81),
(0w110,0w110,89)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [9, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,91)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,92)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,93)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [1, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w104,81),
(0w106,0w122,81),
(0w105,0w105,97)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w98,81),
(0w100,0w122,81),
(0w99,0w99,96)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [15, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w114,81),
(0w116,0w122,81),
(0w115,0w115,98)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,99)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [7, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [21, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,102)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [12, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [8, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w98,81),
(0w100,0w122,81),
(0w99,0w99,105)], [17, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w107,81),
(0w109,0w122,81),
(0w108,0w108,106)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w116,81),
(0w118,0w122,81),
(0w117,0w117,107)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w99,81),
(0w101,0w122,81),
(0w100,0w100,108)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,109)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [2, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,111)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w109,81),
(0w111,0w122,81),
(0w110,0w110,112)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w116,81),
(0w118,0w122,81),
(0w117,0w117,113)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w107,81),
(0w109,0w122,81),
(0w108,0w108,114)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,115)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w113,81),
(0w115,0w122,81),
(0w114,0w114,116)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w104,81),
(0w106,0w122,81),
(0w105,0w105,117)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,118)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w120,81),
(0w122,0w122,81),
(0w121,0w121,119)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [0, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w114,81),
(0w116,0w122,81),
(0w115,0w115,128)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w99,81),
(0w101,0w122,81),
(0w100,0w100,127)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,123)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,124)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w109,81),
(0w111,0w122,81),
(0w110,0w110,125)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w99,81),
(0w101,0w122,81),
(0w100,0w100,126)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [4, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [14, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,129)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [10, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,136)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w98,81),
(0w100,0w122,81),
(0w99,0w99,135)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w117,81),
(0w119,0w122,81),
(0w118,0w118,134)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [16, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [18, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [6, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w98,0w122,81),
(0w97,0w97,137)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w115,81),
(0w117,0w122,81),
(0w116,0w116,138)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w120,81),
(0w122,0w122,81),
(0w121,0w121,139)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w111,81),
(0w113,0w122,81),
(0w112,0w112,140)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,141)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [3, 50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w114,81),
(0w116,0w122,81),
(0w115,0w115,143)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w100,81),
(0w102,0w122,81),
(0w101,0w101,144)], [50]), ([(0w45,0w45,81),
(0w47,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [11, 50]), ([(0w45,0w45,145),
(0w47,0w57,145),
(0w65,0w90,145),
(0w95,0w95,145),
(0w97,0w122,145)], [49, 50]), ([(0w33,0w33,74),
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
(0w126,0w126,74)], [19, 51]), ([(0w46,0w46,76),
(0w48,0w57,147)], [52]), ([(0w48,0w57,149),
(0w65,0w70,149),
(0w97,0w102,149)], []), ([(0w48,0w57,149),
(0w65,0w70,149),
(0w97,0w102,149)], [55]), ([(0w33,0w33,74),
(0w35,0w38,74),
(0w42,0w43,74),
(0w58,0w58,74),
(0w60,0w64,74),
(0w92,0w92,74),
(0w94,0w94,74),
(0w96,0w96,74),
(0w124,0w124,74),
(0w126,0w126,74),
(0w45,0w45,150),
(0w47,0w47,150),
(0w48,0w57,81),
(0w65,0w90,81),
(0w95,0w95,81),
(0w97,0w122,81)], [50, 51]), ([], [57]), ([(0w0,0w9,152),
(0w11,0w2147483647,152)], [59]), ([(0w0,0w9,152),
(0w11,0w32,152),
(0w34,0w34,152),
(0w39,0w41,152),
(0w44,0w44,152),
(0w46,0w46,152),
(0w48,0w57,152),
(0w59,0w59,152),
(0w65,0w91,152),
(0w93,0w93,152),
(0w95,0w95,152),
(0w97,0w123,152),
(0w125,0w125,152),
(0w127,0w2147483647,152),
(0w33,0w33,153),
(0w35,0w38,153),
(0w42,0w43,153),
(0w45,0w45,153),
(0w47,0w47,153),
(0w58,0w58,153),
(0w60,0w64,153),
(0w92,0w92,153),
(0w94,0w94,153),
(0w96,0w96,153),
(0w124,0w124,153),
(0w126,0w126,153)], [51, 59])]
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
fun yyAction3 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_datatype)
fun yyAction4 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_extend)
fun yyAction5 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_type)
fun yyAction6 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_dec)
fun yyAction7 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_raise)
fun yyAction8 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_if)
fun yyAction9 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_then)
fun yyAction10 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_else)
fun yyAction11 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_case)
fun yyAction12 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_let)
fun yyAction13 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_val)
fun yyAction14 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_end)
fun yyAction15 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_rec)
fun yyAction16 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_do)
fun yyAction17 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_in)
fun yyAction18 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_div)
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
fun yyAction40 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TILDE)
fun yyAction41 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; T.TICK)
fun yyAction42 (strm, lastMatch : yymatch) = (yystrm := strm;  T.DOT)
fun yyAction43 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPATNUM; T.COLON)
fun yyAction44 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; T.TICK)
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
fun yyAction60 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr(valOf(String.fromString yytext)); continue()
      end
fun yyAction61 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr yytext; continue()
      end
fun yyAction62 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; mkString())
fun yyAction63 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad escape character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction64 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction65 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth + 1
	;skip())
fun yyAction66 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth - 1
   ;if (!depth = 0) then YYBEGIN INITIAL else ()
	;skip ())
fun yyAction67 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction68 (strm, lastMatch : yymatch) = let
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
  yyAction65, yyAction66, yyAction67, yyAction68])
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
