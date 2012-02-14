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
(0w40,0w46,20),
(0w50,0w57,20),
(0w59,0w64,20),
(0w91,0w96,20),
(0w123,0w2147483647,20),
(0w9,0w13,25),
(0w32,0w32,25),
(0w39,0w39,22),
(0w47,0w47,26),
(0w65,0w90,26),
(0w97,0w122,26),
(0w48,0w49,27),
(0w58,0w58,28)], []), ([(0w0,0w8,20),
(0w14,0w31,20),
(0w127,0w2147483647,20),
(0w9,0w13,31),
(0w32,0w32,31),
(0w33,0w33,32),
(0w36,0w36,32),
(0w62,0w64,32),
(0w94,0w94,32),
(0w96,0w96,32),
(0w34,0w34,33),
(0w35,0w35,34),
(0w37,0w37,35),
(0w38,0w38,36),
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
(0w65,0w90,52),
(0w97,0w98,52),
(0w102,0w102,52),
(0w104,0w104,52),
(0w106,0w107,52),
(0w109,0w110,52),
(0w112,0w113,52),
(0w117,0w117,52),
(0w119,0w122,52),
(0w91,0w91,53),
(0w92,0w92,54),
(0w93,0w93,55),
(0w95,0w95,56),
(0w99,0w99,57),
(0w100,0w100,58),
(0w101,0w101,59),
(0w103,0w103,60),
(0w105,0w105,61),
(0w108,0w108,62),
(0w111,0w111,63),
(0w114,0w114,64),
(0w115,0w115,65),
(0w116,0w116,66),
(0w118,0w118,67),
(0w123,0w123,68),
(0w124,0w124,69),
(0w125,0w125,70),
(0w126,0w126,71)], []), ([], [63]), ([(0w32,0w33,14),
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
(0w93,0w126,14)], [60]), ([], [66]), ([(0w42,0w42,19)], [66]), ([(0w41,0w41,18)], [66]), ([], [65]), ([], [64]), ([], [67]), ([], [46, 67]), ([], [42, 67]), ([(0w48,0w57,24)], [51, 67]), ([(0w48,0w57,24)], [51]), ([], [45, 67]), ([(0w45,0w45,30),
(0w47,0w57,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [44, 67]), ([(0w48,0w49,29)], [43, 67]), ([], [41, 67]), ([(0w48,0w49,29)], [43]), ([(0w45,0w45,30),
(0w47,0w57,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [44]), ([], [55, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [50, 67]), ([], [57, 67]), ([(0w0,0w9,155),
(0w11,0w32,155),
(0w34,0w34,155),
(0w39,0w41,155),
(0w44,0w44,155),
(0w46,0w46,155),
(0w48,0w57,155),
(0w59,0w59,155),
(0w65,0w91,155),
(0w93,0w93,155),
(0w95,0w95,155),
(0w97,0w123,155),
(0w125,0w125,155),
(0w127,0w2147483647,155),
(0w33,0w33,156),
(0w35,0w38,156),
(0w42,0w43,156),
(0w45,0w45,156),
(0w47,0w47,156),
(0w58,0w58,156),
(0w60,0w64,156),
(0w92,0w92,156),
(0w94,0w94,156),
(0w96,0w96,156),
(0w124,0w124,156),
(0w126,0w126,156)], [50, 58, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [20, 50, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [33, 50, 67]), ([], [40, 67]), ([(0w42,0w42,154)], [35, 67]), ([], [36, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [27, 50, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [37, 50, 67]), ([], [29, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [38, 50, 67]), ([(0w45,0w45,153),
(0w47,0w57,153),
(0w65,0w90,153),
(0w95,0w95,153),
(0w97,0w122,153)], [67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72),
(0w45,0w45,152),
(0w47,0w47,152),
(0w46,0w46,80),
(0w48,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [49, 50, 67]), ([(0w46,0w46,74),
(0w48,0w57,149),
(0w120,0w120,150)], [51, 67]), ([(0w46,0w46,74),
(0w48,0w57,149)], [51, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [32, 50, 67]), ([], [30, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72),
(0w45,0w45,148)], [50, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [28, 50, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [49, 67]), ([], [22, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [34, 50, 67]), ([], [23, 67]), ([], [26, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w46,0w46,80),
(0w97,0w97,145)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w100,79),
(0w102,0w104,79),
(0w106,0w110,79),
(0w112,0w122,79),
(0w46,0w46,80),
(0w97,0w97,130),
(0w101,0w101,131),
(0w105,0w105,132),
(0w111,0w111,133)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w107,79),
(0w109,0w109,79),
(0w111,0w119,79),
(0w121,0w122,79),
(0w46,0w46,80),
(0w108,0w108,120),
(0w110,0w110,121),
(0w120,0w120,122)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w113,79),
(0w115,0w122,79),
(0w46,0w46,80),
(0w114,0w114,110)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w101,79),
(0w103,0w109,79),
(0w111,0w122,79),
(0w46,0w46,80),
(0w102,0w102,103),
(0w110,0w110,104)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,101)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w101,79),
(0w103,0w122,79),
(0w46,0w46,80),
(0w102,0w102,100)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w97,0w97,94),
(0w101,0w101,95)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w46,0w46,80),
(0w116,0w116,90)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w103,79),
(0w105,0w120,79),
(0w122,0w122,79),
(0w46,0w46,80),
(0w104,0w104,84),
(0w121,0w121,85)], [49, 67]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w46,0w46,80),
(0w97,0w97,81)], [49, 67]), ([], [24, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [31, 50, 67]), ([], [25, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72),
(0w48,0w57,73)], [39, 50, 67]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [50]), ([(0w46,0w46,74),
(0w48,0w57,73)], [52]), ([(0w48,0w57,75)], []), ([(0w48,0w57,75),
(0w69,0w69,76),
(0w101,0w101,76)], [53]), ([(0w43,0w43,77),
(0w126,0w126,77),
(0w48,0w57,78)], []), ([(0w48,0w57,78)], []), ([(0w48,0w57,78)], [53]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [49]), ([(0w47,0w47,83),
(0w65,0w90,83),
(0w97,0w122,83)], []), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w107,79),
(0w109,0w122,79),
(0w46,0w46,80),
(0w108,0w108,82)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [13, 49]), ([(0w45,0w45,83),
(0w47,0w57,83),
(0w65,0w90,83),
(0w95,0w95,83),
(0w97,0w122,83),
(0w46,0w46,80)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,88)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w111,79),
(0w113,0w122,79),
(0w46,0w46,80),
(0w112,0w112,86)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,87)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [5, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w109,79),
(0w111,0w122,79),
(0w46,0w46,80),
(0w110,0w110,89)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [9, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w46,0w46,80),
(0w97,0w97,91)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w46,0w46,80),
(0w116,0w116,92)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,93)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [1, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w104,79),
(0w106,0w122,79),
(0w46,0w46,80),
(0w105,0w105,97)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w98,79),
(0w100,0w122,79),
(0w46,0w46,80),
(0w99,0w99,96)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [15, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w114,79),
(0w116,0w122,79),
(0w46,0w46,80),
(0w115,0w115,98)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,99)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [7, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [21, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w46,0w46,80),
(0w116,0w116,102)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [12, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [8, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w98,79),
(0w100,0w122,79),
(0w46,0w46,80),
(0w99,0w99,105)], [17, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w107,79),
(0w109,0w122,79),
(0w46,0w46,80),
(0w108,0w108,106)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w116,79),
(0w118,0w122,79),
(0w46,0w46,80),
(0w117,0w117,107)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w99,79),
(0w101,0w122,79),
(0w46,0w46,80),
(0w100,0w100,108)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,109)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [2, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w46,0w46,80),
(0w97,0w97,111)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w109,79),
(0w111,0w122,79),
(0w46,0w46,80),
(0w110,0w110,112)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w116,79),
(0w118,0w122,79),
(0w46,0w46,80),
(0w117,0w117,113)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w107,79),
(0w109,0w122,79),
(0w46,0w46,80),
(0w108,0w108,114)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w46,0w46,80),
(0w97,0w97,115)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w113,79),
(0w115,0w122,79),
(0w46,0w46,80),
(0w114,0w114,116)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w104,79),
(0w106,0w122,79),
(0w46,0w46,80),
(0w105,0w105,117)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w46,0w46,80),
(0w116,0w116,118)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w120,79),
(0w122,0w122,79),
(0w46,0w46,80),
(0w121,0w121,119)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [0, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w114,79),
(0w116,0w122,79),
(0w46,0w46,80),
(0w115,0w115,128)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w99,79),
(0w101,0w122,79),
(0w46,0w46,80),
(0w100,0w100,127)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w46,0w46,80),
(0w116,0w116,123)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,124)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w109,79),
(0w111,0w122,79),
(0w46,0w46,80),
(0w110,0w110,125)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w99,79),
(0w101,0w122,79),
(0w46,0w46,80),
(0w100,0w100,126)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [4, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [14, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,129)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [10, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w46,0w46,80),
(0w116,0w116,139)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w98,79),
(0w100,0w122,79),
(0w46,0w46,80),
(0w99,0w99,135)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w117,79),
(0w119,0w122,79),
(0w46,0w46,80),
(0w118,0w118,134)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [16, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [18, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w110,79),
(0w112,0w122,79),
(0w46,0w46,80),
(0w111,0w111,136)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w99,79),
(0w101,0w122,79),
(0w46,0w46,80),
(0w100,0w100,137)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,138)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [6, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w46,0w46,80),
(0w97,0w97,140)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w46,0w46,80),
(0w116,0w116,141)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w120,79),
(0w122,0w122,79),
(0w46,0w46,80),
(0w121,0w121,142)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w111,79),
(0w113,0w122,79),
(0w46,0w46,80),
(0w112,0w112,143)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,144)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [3, 49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w114,79),
(0w116,0w122,79),
(0w46,0w46,80),
(0w115,0w115,146)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w46,0w46,80),
(0w101,0w101,147)], [49]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79),
(0w46,0w46,80)], [11, 49]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w45,0w45,72),
(0w47,0w47,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72)], [19, 50]), ([(0w46,0w46,74),
(0w48,0w57,149)], [51]), ([(0w48,0w57,151),
(0w65,0w70,151),
(0w97,0w102,151)], []), ([(0w48,0w57,151),
(0w65,0w70,151),
(0w97,0w102,151)], [54]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72),
(0w45,0w45,152),
(0w47,0w47,152),
(0w46,0w46,80),
(0w48,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [49, 50]), ([(0w45,0w45,153),
(0w47,0w57,153),
(0w65,0w90,153),
(0w95,0w95,153),
(0w97,0w122,153)], [47]), ([], [56]), ([(0w0,0w9,155),
(0w11,0w2147483647,155)], [58]), ([(0w0,0w9,155),
(0w11,0w32,155),
(0w34,0w34,155),
(0w39,0w41,155),
(0w44,0w44,155),
(0w46,0w46,155),
(0w48,0w57,155),
(0w59,0w59,155),
(0w65,0w91,155),
(0w93,0w93,155),
(0w95,0w95,155),
(0w97,0w123,155),
(0w125,0w125,155),
(0w127,0w2147483647,155),
(0w33,0w33,156),
(0w35,0w38,156),
(0w42,0w43,156),
(0w45,0w45,156),
(0w47,0w47,156),
(0w58,0w58,156),
(0w60,0w64,156),
(0w92,0w92,156),
(0w94,0w94,156),
(0w96,0w96,156),
(0w124,0w124,156),
(0w126,0w126,156)], [50, 58])]
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
fun yyAction6 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_decode)
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
fun yyAction28 (strm, lastMatch : yymatch) = (yystrm := strm;  T.EQ)
fun yyAction29 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COMMA)
fun yyAction30 (strm, lastMatch : yymatch) = (yystrm := strm;  T.SEMI)
fun yyAction31 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BAR)
fun yyAction32 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COLON)
fun yyAction33 (strm, lastMatch : yymatch) = (yystrm := strm;  T.AMP)
fun yyAction34 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BACKSLASH)
fun yyAction35 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LP)
fun yyAction36 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RP)
fun yyAction37 (strm, lastMatch : yymatch) = (yystrm := strm;  T.PLUS)
fun yyAction38 (strm, lastMatch : yymatch) = (yystrm := strm;  T.MINUS)
fun yyAction39 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TILDE)
fun yyAction40 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; T.TICK)
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
        yystrm := strm;  T.SELECT (Atom.atom yytext)
      end
fun yyAction48 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.QID(mkQId yytext)
      end
fun yyAction49 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction50 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.SYMBOL (Atom.atom yytext)
      end
fun yyAction51 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(valOf (IntInf.fromString yytext))
      end
fun yyAction52 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.NEGINT(valOf (IntInf.fromString yytext))
      end
fun yyAction53 (strm, lastMatch : yymatch) = let
      val yysubstr = yymksubstr(strm)
      in
        yystrm := strm;  mkFloat yysubstr
      end
fun yyAction54 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(fromHexString yytext)
      end
fun yyAction55 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction56 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN COMMENT; depth := 1; skip())
fun yyAction57 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN STRING; skip())
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
