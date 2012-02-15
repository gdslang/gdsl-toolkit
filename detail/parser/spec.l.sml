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
(0w97,0w98,51),
(0w102,0w102,51),
(0w104,0w104,51),
(0w106,0w107,51),
(0w109,0w110,51),
(0w112,0w113,51),
(0w117,0w117,51),
(0w119,0w122,51),
(0w91,0w91,52),
(0w93,0w93,53),
(0w94,0w94,54),
(0w95,0w95,55),
(0w99,0w99,56),
(0w100,0w100,57),
(0w101,0w101,58),
(0w103,0w103,59),
(0w105,0w105,60),
(0w108,0w108,61),
(0w111,0w111,62),
(0w114,0w114,63),
(0w115,0w115,64),
(0w116,0w116,65),
(0w118,0w118,66),
(0w123,0w123,67),
(0w124,0w124,68),
(0w125,0w125,69),
(0w126,0w126,70)], []), ([], [61]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [58, 61]), ([], [59, 61]), ([(0w0,0w33,9),
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
(0w48,0w57,11)], [61]), ([], [60]), ([], [57, 60]), ([(0w48,0w57,12)], [60]), ([(0w48,0w57,13)], []), ([], [57]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [58]), ([], [64]), ([(0w42,0w42,19)], [64]), ([(0w41,0w41,18)], [64]), ([], [63]), ([], [62]), ([], [65]), ([], [46, 65]), ([], [42, 65]), ([(0w48,0w57,24)], [49, 65]), ([(0w48,0w57,24)], [49]), ([], [45, 65]), ([(0w45,0w45,30),
(0w47,0w57,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [44, 65]), ([(0w48,0w49,29)], [43, 65]), ([], [41, 65]), ([(0w48,0w49,29)], [43]), ([(0w45,0w45,30),
(0w47,0w57,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [44]), ([], [53, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [48, 65]), ([], [55, 65]), ([(0w0,0w9,151),
(0w11,0w32,151),
(0w34,0w34,151),
(0w39,0w41,151),
(0w44,0w44,151),
(0w46,0w46,151),
(0w48,0w57,151),
(0w59,0w59,151),
(0w65,0w91,151),
(0w93,0w93,151),
(0w95,0w95,151),
(0w97,0w123,151),
(0w125,0w125,151),
(0w127,0w2147483647,151),
(0w33,0w33,152),
(0w35,0w38,152),
(0w42,0w43,152),
(0w45,0w45,152),
(0w47,0w47,152),
(0w58,0w58,152),
(0w60,0w64,152),
(0w92,0w92,152),
(0w94,0w94,152),
(0w96,0w96,152),
(0w124,0w124,152),
(0w126,0w126,152)], [48, 56, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [20, 48, 65]), ([], [39, 65]), ([(0w42,0w42,150)], [34, 65]), ([], [35, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [27, 48, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [36, 48, 65]), ([], [29, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [37, 48, 65]), ([], [40, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71),
(0w45,0w45,149),
(0w47,0w47,149),
(0w48,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [47, 48, 65]), ([(0w46,0w46,73),
(0w48,0w57,146),
(0w120,0w120,147)], [49, 65]), ([(0w46,0w46,73),
(0w48,0w57,146)], [49, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [33, 48, 65]), ([], [30, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71),
(0w45,0w45,145)], [48, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [28, 48, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [47, 65]), ([], [22, 65]), ([], [23, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [31, 48, 65]), ([], [26, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w98,0w122,78),
(0w97,0w97,142)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w98,0w100,78),
(0w102,0w104,78),
(0w106,0w110,78),
(0w112,0w122,78),
(0w97,0w97,127),
(0w101,0w101,128),
(0w105,0w105,129),
(0w111,0w111,130)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w107,78),
(0w109,0w109,78),
(0w111,0w119,78),
(0w121,0w122,78),
(0w108,0w108,117),
(0w110,0w110,118),
(0w120,0w120,119)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w113,78),
(0w115,0w122,78),
(0w114,0w114,107)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w101,78),
(0w103,0w109,78),
(0w111,0w122,78),
(0w102,0w102,100),
(0w110,0w110,101)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,98)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w101,78),
(0w103,0w122,78),
(0w102,0w102,97)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w98,0w100,78),
(0w102,0w122,78),
(0w97,0w97,91),
(0w101,0w101,92)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w115,78),
(0w117,0w122,78),
(0w116,0w116,87)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w103,78),
(0w105,0w120,78),
(0w122,0w122,78),
(0w104,0w104,81),
(0w121,0w121,82)], [47, 65]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w98,0w122,78),
(0w97,0w97,79)], [47, 65]), ([], [24, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [32, 48, 65]), ([], [25, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71),
(0w48,0w57,72)], [38, 48, 65]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [48]), ([(0w46,0w46,73),
(0w48,0w57,72)], [50]), ([(0w48,0w57,74)], []), ([(0w48,0w57,74),
(0w69,0w69,75),
(0w101,0w101,75)], [51]), ([(0w43,0w43,76),
(0w126,0w126,76),
(0w48,0w57,77)], []), ([(0w48,0w57,77)], []), ([(0w48,0w57,77)], [51]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w107,78),
(0w109,0w122,78),
(0w108,0w108,80)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [13, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,85)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w111,78),
(0w113,0w122,78),
(0w112,0w112,83)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,84)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [5, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w109,78),
(0w111,0w122,78),
(0w110,0w110,86)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [9, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w98,0w122,78),
(0w97,0w97,88)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w115,78),
(0w117,0w122,78),
(0w116,0w116,89)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,90)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [1, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w104,78),
(0w106,0w122,78),
(0w105,0w105,94)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w98,78),
(0w100,0w122,78),
(0w99,0w99,93)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [15, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w114,78),
(0w116,0w122,78),
(0w115,0w115,95)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,96)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [7, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [21, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w115,78),
(0w117,0w122,78),
(0w116,0w116,99)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [12, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [8, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w98,78),
(0w100,0w122,78),
(0w99,0w99,102)], [17, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w107,78),
(0w109,0w122,78),
(0w108,0w108,103)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w116,78),
(0w118,0w122,78),
(0w117,0w117,104)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w99,78),
(0w101,0w122,78),
(0w100,0w100,105)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,106)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [2, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w98,0w122,78),
(0w97,0w97,108)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w109,78),
(0w111,0w122,78),
(0w110,0w110,109)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w116,78),
(0w118,0w122,78),
(0w117,0w117,110)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w107,78),
(0w109,0w122,78),
(0w108,0w108,111)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w98,0w122,78),
(0w97,0w97,112)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w113,78),
(0w115,0w122,78),
(0w114,0w114,113)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w104,78),
(0w106,0w122,78),
(0w105,0w105,114)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w115,78),
(0w117,0w122,78),
(0w116,0w116,115)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w120,78),
(0w122,0w122,78),
(0w121,0w121,116)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [0, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w114,78),
(0w116,0w122,78),
(0w115,0w115,125)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w99,78),
(0w101,0w122,78),
(0w100,0w100,124)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w115,78),
(0w117,0w122,78),
(0w116,0w116,120)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,121)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w109,78),
(0w111,0w122,78),
(0w110,0w110,122)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w99,78),
(0w101,0w122,78),
(0w100,0w100,123)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [4, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [14, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,126)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [10, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w115,78),
(0w117,0w122,78),
(0w116,0w116,136)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w98,78),
(0w100,0w122,78),
(0w99,0w99,132)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w117,78),
(0w119,0w122,78),
(0w118,0w118,131)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [16, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [18, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w110,78),
(0w112,0w122,78),
(0w111,0w111,133)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w99,78),
(0w101,0w122,78),
(0w100,0w100,134)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,135)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [6, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w98,0w122,78),
(0w97,0w97,137)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w115,78),
(0w117,0w122,78),
(0w116,0w116,138)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w120,78),
(0w122,0w122,78),
(0w121,0w121,139)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w111,78),
(0w113,0w122,78),
(0w112,0w112,140)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,141)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [3, 47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w114,78),
(0w116,0w122,78),
(0w115,0w115,143)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w100,78),
(0w102,0w122,78),
(0w101,0w101,144)], [47]), ([(0w45,0w45,78),
(0w47,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [11, 47]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w45,0w45,71),
(0w47,0w47,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71)], [19, 48]), ([(0w46,0w46,73),
(0w48,0w57,146)], [49]), ([(0w48,0w57,148),
(0w65,0w70,148),
(0w97,0w102,148)], []), ([(0w48,0w57,148),
(0w65,0w70,148),
(0w97,0w102,148)], [52]), ([(0w33,0w33,71),
(0w35,0w38,71),
(0w42,0w43,71),
(0w58,0w58,71),
(0w60,0w64,71),
(0w92,0w92,71),
(0w94,0w94,71),
(0w96,0w96,71),
(0w124,0w124,71),
(0w126,0w126,71),
(0w45,0w45,149),
(0w47,0w47,149),
(0w48,0w57,78),
(0w65,0w90,78),
(0w95,0w95,78),
(0w97,0w122,78)], [47, 48]), ([], [54]), ([(0w0,0w9,151),
(0w11,0w2147483647,151)], [56]), ([(0w0,0w9,151),
(0w11,0w32,151),
(0w34,0w34,151),
(0w39,0w41,151),
(0w44,0w44,151),
(0w46,0w46,151),
(0w48,0w57,151),
(0w59,0w59,151),
(0w65,0w91,151),
(0w93,0w93,151),
(0w95,0w95,151),
(0w97,0w123,151),
(0w125,0w125,151),
(0w127,0w2147483647,151),
(0w33,0w33,152),
(0w35,0w38,152),
(0w42,0w43,152),
(0w45,0w45,152),
(0w47,0w47,152),
(0w58,0w58,152),
(0w60,0w64,152),
(0w92,0w92,152),
(0w94,0w94,152),
(0w96,0w96,152),
(0w124,0w124,152),
(0w126,0w126,152)], [48, 56])]
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
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction48 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.SYMBOL (Atom.atom yytext)
      end
fun yyAction49 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(valOf (IntInf.fromString yytext))
      end
fun yyAction50 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.NEGINT(valOf (IntInf.fromString yytext))
      end
fun yyAction51 (strm, lastMatch : yymatch) = let
      val yysubstr = yymksubstr(strm)
      in
        yystrm := strm;  mkFloat yysubstr
      end
fun yyAction52 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(fromHexString yytext)
      end
fun yyAction53 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction54 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN COMMENT; depth := 1; skip())
fun yyAction55 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN STRING; skip())
fun yyAction56 (strm, lastMatch : yymatch) = (yystrm := strm;  skip())
fun yyAction57 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr(valOf(String.fromString yytext)); continue()
      end
fun yyAction58 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr yytext; continue()
      end
fun yyAction59 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; mkString())
fun yyAction60 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad escape character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction61 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction62 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth + 1
	;skip())
fun yyAction63 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth - 1
   ;if (!depth = 0) then YYBEGIN INITIAL else ()
	;skip ())
fun yyAction64 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction65 (strm, lastMatch : yymatch) = let
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
  yyAction65])
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
