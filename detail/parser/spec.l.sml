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
(0w38,0w38,32),
(0w62,0w64,32),
(0w92,0w92,32),
(0w96,0w96,32),
(0w34,0w34,33),
(0w35,0w35,34),
(0w37,0w37,35),
(0w39,0w39,36),
(0w40,0w40,37),
(0w41,0w41,38),
(0w42,0w42,39),
(0w43,0w43,40),
(0w44,0w44,41),
(0w45,0w45,42),
(0w46,0w46,43),
(0w47,0w47,44),
(0w48,0w48,45),
(0w49,0w57,46),
(0w58,0w58,47),
(0w59,0w59,48),
(0w60,0w60,49),
(0w61,0w61,50),
(0w65,0w90,51),
(0w91,0w91,52),
(0w93,0w93,53),
(0w94,0w94,54),
(0w95,0w95,55),
(0w97,0w98,56),
(0w102,0w102,56),
(0w104,0w104,56),
(0w106,0w107,56),
(0w109,0w110,56),
(0w112,0w113,56),
(0w117,0w117,56),
(0w119,0w122,56),
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
(0w126,0w126,71)], []), ([], [62]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [59, 62]), ([], [60, 62]), ([(0w0,0w33,9),
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
(0w48,0w57,11)], [62]), ([], [61]), ([], [58, 61]), ([(0w48,0w57,12)], [61]), ([(0w48,0w57,13)], []), ([], [58]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [59]), ([], [65]), ([(0w42,0w42,19)], [65]), ([(0w41,0w41,18)], [65]), ([], [64]), ([], [63]), ([], [66]), ([], [46, 66]), ([], [42, 66]), ([(0w48,0w57,24)], [50, 66]), ([(0w48,0w57,24)], [50]), ([], [45, 66]), ([(0w45,0w45,30),
(0w47,0w57,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [44, 66]), ([(0w48,0w49,29)], [43, 66]), ([], [41, 66]), ([(0w48,0w49,29)], [43]), ([(0w45,0w45,30),
(0w47,0w57,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [44]), ([], [54, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [49, 66]), ([], [56, 66]), ([(0w0,0w9,150),
(0w11,0w32,150),
(0w34,0w34,150),
(0w39,0w41,150),
(0w44,0w44,150),
(0w46,0w46,150),
(0w48,0w57,150),
(0w59,0w59,150),
(0w65,0w91,150),
(0w93,0w93,150),
(0w95,0w95,150),
(0w97,0w123,150),
(0w125,0w125,150),
(0w127,0w2147483647,150),
(0w33,0w33,151),
(0w35,0w38,151),
(0w42,0w43,151),
(0w45,0w45,151),
(0w47,0w47,151),
(0w58,0w58,151),
(0w60,0w64,151),
(0w92,0w92,151),
(0w94,0w94,151),
(0w96,0w96,151),
(0w124,0w124,151),
(0w126,0w126,151)], [49, 57, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [20, 49, 66]), ([], [39, 66]), ([(0w42,0w42,149)], [34, 66]), ([], [35, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [27, 49, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [36, 49, 66]), ([], [29, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [37, 49, 66]), ([], [40, 66]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72),
(0w45,0w45,148),
(0w47,0w47,148),
(0w48,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [48, 49, 66]), ([(0w46,0w46,74),
(0w48,0w57,145),
(0w120,0w120,146)], [50, 66]), ([(0w46,0w46,74),
(0w48,0w57,145)], [50, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [33, 49, 66]), ([], [30, 66]), ([(0w33,0w33,72),
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
(0w45,0w45,144)], [49, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [28, 49, 66]), ([(0w45,0w45,143),
(0w47,0w57,143),
(0w65,0w90,143),
(0w95,0w95,143),
(0w97,0w122,143)], [47, 48, 66]), ([], [22, 66]), ([], [23, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [31, 49, 66]), ([], [26, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w97,0w97,140)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w100,79),
(0w102,0w104,79),
(0w106,0w110,79),
(0w112,0w122,79),
(0w97,0w97,128),
(0w101,0w101,129),
(0w105,0w105,130),
(0w111,0w111,131)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w107,79),
(0w109,0w109,79),
(0w111,0w119,79),
(0w121,0w122,79),
(0w108,0w108,118),
(0w110,0w110,119),
(0w120,0w120,120)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w113,79),
(0w115,0w122,79),
(0w114,0w114,108)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w101,79),
(0w103,0w109,79),
(0w111,0w122,79),
(0w102,0w102,101),
(0w110,0w110,102)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,99)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w101,79),
(0w103,0w122,79),
(0w102,0w102,98)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w100,79),
(0w102,0w122,79),
(0w97,0w97,92),
(0w101,0w101,93)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w116,0w116,88)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w103,79),
(0w105,0w120,79),
(0w122,0w122,79),
(0w104,0w104,82),
(0w121,0w121,83)], [48, 66]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w97,0w97,80)], [48, 66]), ([], [24, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [32, 49, 66]), ([], [25, 66]), ([(0w33,0w33,72),
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
(0w48,0w57,73)], [38, 49, 66]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [49]), ([(0w46,0w46,74),
(0w48,0w57,73)], [51]), ([(0w48,0w57,75)], []), ([(0w48,0w57,75),
(0w69,0w69,76),
(0w101,0w101,76)], [52]), ([(0w43,0w43,77),
(0w126,0w126,77),
(0w48,0w57,78)], []), ([(0w48,0w57,78)], []), ([(0w48,0w57,78)], [52]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w107,79),
(0w109,0w122,79),
(0w108,0w108,81)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [13, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,86)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w111,79),
(0w113,0w122,79),
(0w112,0w112,84)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,85)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [5, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w109,79),
(0w111,0w122,79),
(0w110,0w110,87)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [9, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w97,0w97,89)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w116,0w116,90)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,91)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [1, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w104,79),
(0w106,0w122,79),
(0w105,0w105,95)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w98,79),
(0w100,0w122,79),
(0w99,0w99,94)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [15, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w114,79),
(0w116,0w122,79),
(0w115,0w115,96)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,97)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [7, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [21, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w116,0w116,100)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [12, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [8, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w98,79),
(0w100,0w122,79),
(0w99,0w99,103)], [17, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w107,79),
(0w109,0w122,79),
(0w108,0w108,104)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w116,79),
(0w118,0w122,79),
(0w117,0w117,105)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w99,79),
(0w101,0w122,79),
(0w100,0w100,106)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,107)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [2, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w97,0w97,109)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w109,79),
(0w111,0w122,79),
(0w110,0w110,110)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w116,79),
(0w118,0w122,79),
(0w117,0w117,111)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w107,79),
(0w109,0w122,79),
(0w108,0w108,112)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w97,0w97,113)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w113,79),
(0w115,0w122,79),
(0w114,0w114,114)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w104,79),
(0w106,0w122,79),
(0w105,0w105,115)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w116,0w116,116)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w120,79),
(0w122,0w122,79),
(0w121,0w121,117)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [0, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w114,79),
(0w116,0w122,79),
(0w115,0w115,126)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w99,79),
(0w101,0w122,79),
(0w100,0w100,125)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w116,0w116,121)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,122)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w109,79),
(0w111,0w122,79),
(0w110,0w110,123)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w99,79),
(0w101,0w122,79),
(0w100,0w100,124)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [4, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [14, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,127)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [10, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w116,0w116,134)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w98,79),
(0w100,0w122,79),
(0w99,0w99,133)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w117,79),
(0w119,0w122,79),
(0w118,0w118,132)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [16, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [18, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [6, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w98,0w122,79),
(0w97,0w97,135)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w115,79),
(0w117,0w122,79),
(0w116,0w116,136)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w120,79),
(0w122,0w122,79),
(0w121,0w121,137)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w111,79),
(0w113,0w122,79),
(0w112,0w112,138)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,139)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [3, 48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w114,79),
(0w116,0w122,79),
(0w115,0w115,141)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w100,79),
(0w102,0w122,79),
(0w101,0w101,142)], [48]), ([(0w45,0w45,79),
(0w47,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [11, 48]), ([(0w45,0w45,143),
(0w47,0w57,143),
(0w65,0w90,143),
(0w95,0w95,143),
(0w97,0w122,143)], [47, 48]), ([(0w33,0w33,72),
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
(0w126,0w126,72)], [19, 49]), ([(0w46,0w46,74),
(0w48,0w57,145)], [50]), ([(0w48,0w57,147),
(0w65,0w70,147),
(0w97,0w102,147)], []), ([(0w48,0w57,147),
(0w65,0w70,147),
(0w97,0w102,147)], [53]), ([(0w33,0w33,72),
(0w35,0w38,72),
(0w42,0w43,72),
(0w58,0w58,72),
(0w60,0w64,72),
(0w92,0w92,72),
(0w94,0w94,72),
(0w96,0w96,72),
(0w124,0w124,72),
(0w126,0w126,72),
(0w45,0w45,148),
(0w47,0w47,148),
(0w48,0w57,79),
(0w65,0w90,79),
(0w95,0w95,79),
(0w97,0w122,79)], [48, 49]), ([], [55]), ([(0w0,0w9,150),
(0w11,0w2147483647,150)], [57]), ([(0w0,0w9,150),
(0w11,0w32,150),
(0w34,0w34,150),
(0w39,0w41,150),
(0w44,0w44,150),
(0w46,0w46,150),
(0w48,0w57,150),
(0w59,0w59,150),
(0w65,0w91,150),
(0w93,0w93,150),
(0w95,0w95,150),
(0w97,0w123,150),
(0w125,0w125,150),
(0w127,0w2147483647,150),
(0w33,0w33,151),
(0w35,0w38,151),
(0w42,0w43,151),
(0w45,0w45,151),
(0w47,0w47,151),
(0w58,0w58,151),
(0w60,0w64,151),
(0w92,0w92,151),
(0w94,0w94,151),
(0w96,0w96,151),
(0w124,0w124,151),
(0w126,0w126,151)], [49, 57])]
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
fun yyAction58 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr(valOf(String.fromString yytext)); continue()
      end
fun yyAction59 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr yytext; continue()
      end
fun yyAction60 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; mkString())
fun yyAction61 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad escape character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction62 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction63 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth + 1
	;skip())
fun yyAction64 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth - 1
   ;if (!depth = 0) then YYBEGIN INITIAL else ()
	;skip ())
fun yyAction65 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction66 (strm, lastMatch : yymatch) = let
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
  yyAction65, yyAction66])
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
