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
(0w94,0w94,32),
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
(0w95,0w95,54),
(0w99,0w99,55),
(0w100,0w100,56),
(0w101,0w101,57),
(0w103,0w103,58),
(0w105,0w105,59),
(0w108,0w108,60),
(0w111,0w111,61),
(0w114,0w114,62),
(0w115,0w115,63),
(0w116,0w116,64),
(0w118,0w118,65),
(0w123,0w123,66),
(0w124,0w124,67),
(0w125,0w125,68),
(0w126,0w126,69)], []), ([], [60]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [57, 60]), ([], [58, 60]), ([(0w0,0w33,9),
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
(0w48,0w57,11)], [60]), ([], [59]), ([], [56, 59]), ([(0w48,0w57,12)], [59]), ([(0w48,0w57,13)], []), ([], [56]), ([(0w32,0w33,14),
(0w35,0w91,14),
(0w93,0w126,14)], [57]), ([], [63]), ([(0w42,0w42,19)], [63]), ([(0w41,0w41,18)], [63]), ([], [62]), ([], [61]), ([], [64]), ([], [45, 64]), ([], [41, 64]), ([(0w48,0w57,24)], [48, 64]), ([(0w48,0w57,24)], [48]), ([], [44, 64]), ([(0w45,0w45,30),
(0w47,0w57,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [43, 64]), ([(0w48,0w49,29)], [42, 64]), ([], [40, 64]), ([(0w48,0w49,29)], [42]), ([(0w45,0w45,30),
(0w47,0w57,30),
(0w65,0w90,30),
(0w95,0w95,30),
(0w97,0w122,30)], [43]), ([], [52, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [47, 64]), ([], [54, 64]), ([(0w0,0w9,150),
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
(0w126,0w126,151)], [47, 55, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [20, 47, 64]), ([], [38, 64]), ([(0w42,0w42,149)], [33, 64]), ([], [34, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [27, 47, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [35, 47, 64]), ([], [29, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [36, 47, 64]), ([], [39, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70),
(0w45,0w45,148),
(0w47,0w47,148),
(0w48,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [46, 47, 64]), ([(0w46,0w46,72),
(0w48,0w57,145),
(0w120,0w120,146)], [48, 64]), ([(0w46,0w46,72),
(0w48,0w57,145)], [48, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [32, 47, 64]), ([], [30, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70),
(0w45,0w45,144)], [47, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [28, 47, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [46, 64]), ([], [22, 64]), ([], [23, 64]), ([], [26, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w98,0w122,77),
(0w97,0w97,141)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w98,0w100,77),
(0w102,0w104,77),
(0w106,0w110,77),
(0w112,0w122,77),
(0w97,0w97,126),
(0w101,0w101,127),
(0w105,0w105,128),
(0w111,0w111,129)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w107,77),
(0w109,0w109,77),
(0w111,0w119,77),
(0w121,0w122,77),
(0w108,0w108,116),
(0w110,0w110,117),
(0w120,0w120,118)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w113,77),
(0w115,0w122,77),
(0w114,0w114,106)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w101,77),
(0w103,0w109,77),
(0w111,0w122,77),
(0w102,0w102,99),
(0w110,0w110,100)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,97)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w101,77),
(0w103,0w122,77),
(0w102,0w102,96)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w98,0w100,77),
(0w102,0w122,77),
(0w97,0w97,90),
(0w101,0w101,91)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w115,77),
(0w117,0w122,77),
(0w116,0w116,86)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w103,77),
(0w105,0w120,77),
(0w122,0w122,77),
(0w104,0w104,80),
(0w121,0w121,81)], [46, 64]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w98,0w122,77),
(0w97,0w97,78)], [46, 64]), ([], [24, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [31, 47, 64]), ([], [25, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70),
(0w48,0w57,71)], [37, 47, 64]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [47]), ([(0w46,0w46,72),
(0w48,0w57,71)], [49]), ([(0w48,0w57,73)], []), ([(0w48,0w57,73),
(0w69,0w69,74),
(0w101,0w101,74)], [50]), ([(0w43,0w43,75),
(0w126,0w126,75),
(0w48,0w57,76)], []), ([(0w48,0w57,76)], []), ([(0w48,0w57,76)], [50]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w107,77),
(0w109,0w122,77),
(0w108,0w108,79)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [13, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,84)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w111,77),
(0w113,0w122,77),
(0w112,0w112,82)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,83)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [5, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w109,77),
(0w111,0w122,77),
(0w110,0w110,85)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [9, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w98,0w122,77),
(0w97,0w97,87)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w115,77),
(0w117,0w122,77),
(0w116,0w116,88)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,89)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [1, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w104,77),
(0w106,0w122,77),
(0w105,0w105,93)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w98,77),
(0w100,0w122,77),
(0w99,0w99,92)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [15, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w114,77),
(0w116,0w122,77),
(0w115,0w115,94)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,95)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [7, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [21, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w115,77),
(0w117,0w122,77),
(0w116,0w116,98)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [12, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [8, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w98,77),
(0w100,0w122,77),
(0w99,0w99,101)], [17, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w107,77),
(0w109,0w122,77),
(0w108,0w108,102)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w116,77),
(0w118,0w122,77),
(0w117,0w117,103)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w99,77),
(0w101,0w122,77),
(0w100,0w100,104)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,105)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [2, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w98,0w122,77),
(0w97,0w97,107)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w109,77),
(0w111,0w122,77),
(0w110,0w110,108)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w116,77),
(0w118,0w122,77),
(0w117,0w117,109)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w107,77),
(0w109,0w122,77),
(0w108,0w108,110)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w98,0w122,77),
(0w97,0w97,111)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w113,77),
(0w115,0w122,77),
(0w114,0w114,112)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w104,77),
(0w106,0w122,77),
(0w105,0w105,113)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w115,77),
(0w117,0w122,77),
(0w116,0w116,114)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w120,77),
(0w122,0w122,77),
(0w121,0w121,115)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [0, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w114,77),
(0w116,0w122,77),
(0w115,0w115,124)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w99,77),
(0w101,0w122,77),
(0w100,0w100,123)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w115,77),
(0w117,0w122,77),
(0w116,0w116,119)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,120)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w109,77),
(0w111,0w122,77),
(0w110,0w110,121)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w99,77),
(0w101,0w122,77),
(0w100,0w100,122)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [4, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [14, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,125)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [10, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w115,77),
(0w117,0w122,77),
(0w116,0w116,135)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w98,77),
(0w100,0w122,77),
(0w99,0w99,131)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w117,77),
(0w119,0w122,77),
(0w118,0w118,130)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [16, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [18, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w110,77),
(0w112,0w122,77),
(0w111,0w111,132)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w99,77),
(0w101,0w122,77),
(0w100,0w100,133)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,134)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [6, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w98,0w122,77),
(0w97,0w97,136)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w115,77),
(0w117,0w122,77),
(0w116,0w116,137)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w120,77),
(0w122,0w122,77),
(0w121,0w121,138)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w111,77),
(0w113,0w122,77),
(0w112,0w112,139)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,140)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [3, 46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w114,77),
(0w116,0w122,77),
(0w115,0w115,142)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w100,77),
(0w102,0w122,77),
(0w101,0w101,143)], [46]), ([(0w45,0w45,77),
(0w47,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [11, 46]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w45,0w45,70),
(0w47,0w47,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70)], [19, 47]), ([(0w46,0w46,72),
(0w48,0w57,145)], [48]), ([(0w48,0w57,147),
(0w65,0w70,147),
(0w97,0w102,147)], []), ([(0w48,0w57,147),
(0w65,0w70,147),
(0w97,0w102,147)], [51]), ([(0w33,0w33,70),
(0w35,0w38,70),
(0w42,0w43,70),
(0w58,0w58,70),
(0w60,0w64,70),
(0w92,0w92,70),
(0w94,0w94,70),
(0w96,0w96,70),
(0w124,0w124,70),
(0w126,0w126,70),
(0w45,0w45,148),
(0w47,0w47,148),
(0w48,0w57,77),
(0w65,0w90,77),
(0w95,0w95,77),
(0w97,0w122,77)], [46, 47]), ([], [53]), ([(0w0,0w9,150),
(0w11,0w2147483647,150)], [55]), ([(0w0,0w9,150),
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
(0w126,0w126,151)], [47, 55])]
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
fun yyAction33 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LP)
fun yyAction34 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RP)
fun yyAction35 (strm, lastMatch : yymatch) = (yystrm := strm;  T.PLUS)
fun yyAction36 (strm, lastMatch : yymatch) = (yystrm := strm;  T.MINUS)
fun yyAction37 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TILDE)
fun yyAction38 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; T.TICK)
fun yyAction39 (strm, lastMatch : yymatch) = (yystrm := strm;  T.DOT)
fun yyAction40 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPATNUM; T.COLON)
fun yyAction41 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; T.TICK)
fun yyAction42 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.BITSTR yytext
      end
fun yyAction43 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction44 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction45 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; skip())
fun yyAction46 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction47 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.SYMBOL (Atom.atom yytext)
      end
fun yyAction48 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(valOf (IntInf.fromString yytext))
      end
fun yyAction49 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.NEGINT(valOf (IntInf.fromString yytext))
      end
fun yyAction50 (strm, lastMatch : yymatch) = let
      val yysubstr = yymksubstr(strm)
      in
        yystrm := strm;  mkFloat yysubstr
      end
fun yyAction51 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(fromHexString yytext)
      end
fun yyAction52 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction53 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN COMMENT; depth := 1; skip())
fun yyAction54 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN STRING; skip())
fun yyAction55 (strm, lastMatch : yymatch) = (yystrm := strm;  skip())
fun yyAction56 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr(valOf(String.fromString yytext)); continue()
      end
fun yyAction57 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr yytext; continue()
      end
fun yyAction58 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; mkString())
fun yyAction59 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad escape character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction60 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
         ["bad character `", String.toString yytext,
			 "' in string literal"])
   ;continue()
      end
fun yyAction61 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth + 1
	;skip())
fun yyAction62 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth - 1
   ;if (!depth = 0) then YYBEGIN INITIAL else ()
	;skip ())
fun yyAction63 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction64 (strm, lastMatch : yymatch) = let
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
  yyAction59, yyAction60, yyAction61, yyAction62, yyAction63, yyAction64])
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
