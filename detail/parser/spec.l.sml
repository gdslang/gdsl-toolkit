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
Vector.fromList []
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
fun yyAction13 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_do)
fun yyAction14 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_div)
fun yyAction15 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_mod)
fun yyAction16 (strm, lastMatch : yymatch) = (yystrm := strm;  T.KW_of)
fun yyAction17 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LB)
fun yyAction18 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RB)
fun yyAction19 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LCB)
fun yyAction20 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RCB)
fun yyAction21 (strm, lastMatch : yymatch) = (yystrm := strm;  T.WILD)
fun yyAction22 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TIMES)
fun yyAction23 (strm, lastMatch : yymatch) = (yystrm := strm;  T.EQ)
fun yyAction24 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COMMA)
fun yyAction25 (strm, lastMatch : yymatch) = (yystrm := strm;  T.SEMI)
fun yyAction26 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BAR)
fun yyAction27 (strm, lastMatch : yymatch) = (yystrm := strm;  T.COLON)
fun yyAction28 (strm, lastMatch : yymatch) = (yystrm := strm;  T.AMP)
fun yyAction29 (strm, lastMatch : yymatch) = (yystrm := strm;  T.BACKSLASH)
fun yyAction30 (strm, lastMatch : yymatch) = (yystrm := strm;  T.LP)
fun yyAction31 (strm, lastMatch : yymatch) = (yystrm := strm;  T.RP)
fun yyAction32 (strm, lastMatch : yymatch) = (yystrm := strm;  T.PLUS)
fun yyAction33 (strm, lastMatch : yymatch) = (yystrm := strm;  T.MINUS)
fun yyAction34 (strm, lastMatch : yymatch) = (yystrm := strm;  T.TILDE)
fun yyAction35 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; T.TICK)
fun yyAction36 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPATNUM; T.COLON)
fun yyAction37 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; T.TICK)
fun yyAction38 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.BITSTR yytext
      end
fun yyAction39 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction40 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction41 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN BITPAT; skip())
fun yyAction42 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.SELECT (Atom.atom yytext)
      end
fun yyAction43 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.QID(mkQId yytext)
      end
fun yyAction44 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.ID (Atom.atom yytext)
      end
fun yyAction45 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.SYMBOL (Atom.atom yytext)
      end
fun yyAction46 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(valOf (IntInf.fromString yytext))
      end
fun yyAction47 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.NEGINT(valOf (IntInf.fromString yytext))
      end
fun yyAction48 (strm, lastMatch : yymatch) = let
      val yysubstr = yymksubstr(strm)
      in
        yystrm := strm;  mkFloat yysubstr
      end
fun yyAction49 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  T.POSINT(fromHexString yytext)
      end
fun yyAction50 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction51 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN COMMENT; depth := 1; skip())
fun yyAction52 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN STRING; skip())
fun yyAction53 (strm, lastMatch : yymatch) = (yystrm := strm;  skip())
fun yyAction54 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr(valOf(String.fromString yytext)); continue()
      end
fun yyAction55 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;  addStr yytext; continue()
      end
fun yyAction56 (strm, lastMatch : yymatch) = (yystrm := strm;
       YYBEGIN INITIAL; mkString())
fun yyAction57 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
       ["bad escape character `", String.toString yytext,
		  "' in string literal"])
   ;continue()
      end
fun yyAction58 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
      (yypos,
         ["bad character `", String.toString yytext,
			 "' in string literal"])
   ;continue()
      end
fun yyAction59 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth + 1
	;skip())
fun yyAction60 (strm, lastMatch : yymatch) = (yystrm := strm;
      
   depth := !depth - 1
   ;if (!depth = 0) then YYBEGIN INITIAL else ()
	;skip ())
fun yyAction61 (strm, lastMatch : yymatch) = (yystrm := strm;  skip ())
fun yyAction62 (strm, lastMatch : yymatch) = let
      val yytext = yymktext(strm)
      in
        yystrm := strm;
        
   lexErr
         (yypos,
          ["bad character `", String.toString yytext, "'"])
   ;continue()
      end
fun yyQ76 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction48(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ76(strm', yyMATCH(strm, yyAction48, yyNO_MATCH))
            else if inp < 0wx30
              then yyAction48(strm, yyNO_MATCH)
            else if inp <= 0wx39
              then yyQ76(strm', yyMATCH(strm, yyAction48, yyNO_MATCH))
              else yyAction48(strm, yyNO_MATCH)
      (* end case *))
fun yyQ75 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ76(strm', lastMatch)
            else if inp < 0wx30
              then yystuck(lastMatch)
            else if inp <= 0wx39
              then yyQ76(strm', lastMatch)
              else yystuck(lastMatch)
      (* end case *))
fun yyQ74 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ76(strm', lastMatch)
            else if inp < 0wx30
              then if inp = 0wx2B
                  then yyQ75(strm', lastMatch)
                  else yystuck(lastMatch)
            else if inp = 0wx7E
              then yyQ75(strm', lastMatch)
            else if inp < 0wx7E
              then if inp <= 0wx39
                  then yyQ76(strm', lastMatch)
                  else yystuck(lastMatch)
              else yystuck(lastMatch)
      (* end case *))
fun yyQ73 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction48(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx45
              then yyQ74(strm', yyMATCH(strm, yyAction48, yyNO_MATCH))
            else if inp < 0wx45
              then if inp = 0wx30
                  then yyQ73(strm', yyMATCH(strm, yyAction48, yyNO_MATCH))
                else if inp < 0wx30
                  then yyAction48(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ73(strm', yyMATCH(strm, yyAction48, yyNO_MATCH))
                  else yyAction48(strm, yyNO_MATCH)
            else if inp = 0wx65
              then yyQ74(strm', yyMATCH(strm, yyAction48, yyNO_MATCH))
              else yyAction48(strm, yyNO_MATCH)
      (* end case *))
fun yyQ72 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ73(strm', lastMatch)
            else if inp < 0wx30
              then yystuck(lastMatch)
            else if inp <= 0wx39
              then yyQ73(strm', lastMatch)
              else yystuck(lastMatch)
      (* end case *))
fun yyQ71 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction47(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx2F
              then yyAction47(strm, yyNO_MATCH)
            else if inp < 0wx2F
              then if inp = 0wx2E
                  then yyQ72(strm', yyMATCH(strm, yyAction47, yyNO_MATCH))
                  else yyAction47(strm, yyNO_MATCH)
            else if inp <= 0wx39
              then yyQ71(strm', yyMATCH(strm, yyAction47, yyNO_MATCH))
              else yyAction47(strm, yyNO_MATCH)
      (* end case *))
fun yyQ70 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction45(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction45(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction45(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                          else yyAction45(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction45(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction45(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyAction45(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyAction45(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction45(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction45(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyAction45(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyAction45(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction45(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyAction45(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
              else yyAction45(strm, yyNO_MATCH)
      (* end case *))
fun yyQ69 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction34(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction34(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction34(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                          else yyAction34(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction34(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction34(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                      else yyAction34(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                  else yyQ71(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction34(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction34(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                      else yyAction34(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                  else yyAction34(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction34(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
                  else yyAction34(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction34, yyNO_MATCH))
              else yyAction34(strm, yyNO_MATCH)
      (* end case *))
fun yyQ68 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction20(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction20(strm, yyNO_MATCH)
      (* end case *))
fun yyQ67 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction26(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction26(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction26(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                          else yyAction26(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction26(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction26(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                      else yyAction26(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                  else yyAction26(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction26(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction26(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                      else yyAction26(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                  else yyAction26(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction26(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
                  else yyAction26(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction26, yyNO_MATCH))
              else yyAction26(strm, yyNO_MATCH)
      (* end case *))
fun yyQ66 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction19(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction19(strm, yyNO_MATCH)
      (* end case *))
fun yyQ78 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ85(strm', lastMatch)
            else if inp < 0wx41
              then if inp = 0wx2F
                  then yyQ85(strm', lastMatch)
                  else yystuck(lastMatch)
            else if inp = 0wx61
              then yyQ85(strm', lastMatch)
            else if inp < 0wx61
              then if inp <= 0wx5A
                  then yyQ85(strm', lastMatch)
                  else yystuck(lastMatch)
            else if inp <= 0wx7A
              then yyQ85(strm', lastMatch)
              else yystuck(lastMatch)
      (* end case *))
and yyQ85 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction43(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ85(strm', yyMATCH(strm, yyAction43, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction43, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ85(strm', yyMATCH(strm, yyAction43, yyNO_MATCH))
                      else yyAction43(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ85(strm', yyMATCH(strm, yyAction43, yyNO_MATCH))
                  else yyAction43(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction43(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction43(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ85(strm', yyMATCH(strm, yyAction43, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ85(strm', yyMATCH(strm, yyAction43, yyNO_MATCH))
                  else yyAction43(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ85(strm', yyMATCH(strm, yyAction43, yyNO_MATCH))
              else yyAction43(strm, yyNO_MATCH)
      (* end case *))
fun yyQ77 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ82 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction5(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction5, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction5, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction5, yyNO_MATCH))
                      else yyAction5(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction5, yyNO_MATCH))
                  else yyAction5(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction5(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction5(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction5, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction5, yyNO_MATCH))
                  else yyAction5(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction5, yyNO_MATCH))
              else yyAction5(strm, yyNO_MATCH)
      (* end case *))
fun yyQ81 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ82(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ80 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx71
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx71
              then if inp = 0wx70
                  then yyQ81(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ84 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction9(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction9, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction9, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction9, yyNO_MATCH))
                      else yyAction9(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction9, yyNO_MATCH))
                  else yyAction9(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction9(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction9(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction9, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction9, yyNO_MATCH))
                  else yyAction9(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction9, yyNO_MATCH))
              else yyAction9(strm, yyNO_MATCH)
      (* end case *))
fun yyQ83 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx6F
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6F
              then if inp = 0wx6E
                  then yyQ84(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ79 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ83(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ65 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5F
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx5F
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx41
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx41
                  then if inp <= 0wx39
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp <= 0wx5A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx69
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx69
              then if inp = 0wx61
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx61
                  then yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx68
                  then yyQ79(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx7A
              then if inp = 0wx79
                  then yyQ80(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ89 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction1(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction1, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction1, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction1, yyNO_MATCH))
                      else yyAction1(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction1, yyNO_MATCH))
                  else yyAction1(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction1(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction1(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction1, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction1, yyNO_MATCH))
                  else yyAction1(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction1, yyNO_MATCH))
              else yyAction1(strm, yyNO_MATCH)
      (* end case *))
fun yyQ88 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ89(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ87 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx75
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx75
              then if inp = 0wx74
                  then yyQ88(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ86 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ87(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ64 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx75
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx75
              then if inp = 0wx74
                  then yyQ86(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ93 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction7(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction7, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction7, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction7, yyNO_MATCH))
                      else yyAction7(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction7, yyNO_MATCH))
                  else yyAction7(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction7(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction7(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction7, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction7, yyNO_MATCH))
                  else yyAction7(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction7, yyNO_MATCH))
              else yyAction7(strm, yyNO_MATCH)
      (* end case *))
fun yyQ92 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ93(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ91 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx74
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx74
              then if inp = 0wx73
                  then yyQ92(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ90 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx6A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6A
              then if inp = 0wx69
                  then yyQ91(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ63 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ90(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ94 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction16(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction16, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction16, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction16, yyNO_MATCH))
                      else yyAction16(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction16, yyNO_MATCH))
                  else yyAction16(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction16(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction16(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction16, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction16, yyNO_MATCH))
                  else yyAction16(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction16, yyNO_MATCH))
              else yyAction16(strm, yyNO_MATCH)
      (* end case *))
fun yyQ62 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx67
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx67
              then if inp = 0wx66
                  then yyQ94(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ96 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction12(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction12, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction12, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction12, yyNO_MATCH))
                      else yyAction12(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction12, yyNO_MATCH))
                  else yyAction12(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction12(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction12(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction12, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction12, yyNO_MATCH))
                  else yyAction12(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction12, yyNO_MATCH))
              else yyAction12(strm, yyNO_MATCH)
      (* end case *))
fun yyQ95 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx75
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx75
              then if inp = 0wx74
                  then yyQ96(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ61 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ95(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ103 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction2(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction2, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction2, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction2, yyNO_MATCH))
                      else yyAction2(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction2, yyNO_MATCH))
                  else yyAction2(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction2(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction2(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction2, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction2, yyNO_MATCH))
                  else yyAction2(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction2, yyNO_MATCH))
              else yyAction2(strm, yyNO_MATCH)
      (* end case *))
fun yyQ102 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ103(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ101 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx65
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx65
              then if inp = 0wx64
                  then yyQ102(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ100 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx76
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx76
              then if inp = 0wx75
                  then yyQ101(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ99 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx6D
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6D
              then if inp = 0wx6C
                  then yyQ100(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ98 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx64
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx64
              then if inp = 0wx63
                  then yyQ99(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ97 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction8(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction8, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction8, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction8, yyNO_MATCH))
                      else yyAction8(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction8, yyNO_MATCH))
                  else yyAction8(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction8(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction8(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction8, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction8, yyNO_MATCH))
                  else yyAction8(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction8, yyNO_MATCH))
              else yyAction8(strm, yyNO_MATCH)
      (* end case *))
fun yyQ60 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5F
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx5F
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx41
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx41
                  then if inp <= 0wx39
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp <= 0wx5A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx67
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx67
              then if inp = 0wx61
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx61
                  then yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx66
                  then yyQ97(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx6F
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6F
              then if inp = 0wx6E
                  then yyQ98(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ113 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction0(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction0, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction0, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction0, yyNO_MATCH))
                      else yyAction0(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction0, yyNO_MATCH))
                  else yyAction0(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction0(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction0(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction0, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction0, yyNO_MATCH))
                  else yyAction0(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction0, yyNO_MATCH))
              else yyAction0(strm, yyNO_MATCH)
      (* end case *))
fun yyQ112 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx7A
              then if inp = 0wx79
                  then yyQ113(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ111 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx75
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx75
              then if inp = 0wx74
                  then yyQ112(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ110 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx6A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6A
              then if inp = 0wx69
                  then yyQ111(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ109 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx73
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx73
              then if inp = 0wx72
                  then yyQ110(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ108 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ109(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ107 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx6D
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6D
              then if inp = 0wx6C
                  then yyQ108(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ106 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx76
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx76
              then if inp = 0wx75
                  then yyQ107(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ105 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx6F
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6F
              then if inp = 0wx6E
                  then yyQ106(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ104 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ105(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ59 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx73
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx73
              then if inp = 0wx72
                  then yyQ104(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ119 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction4(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction4, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction4, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction4, yyNO_MATCH))
                      else yyAction4(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction4, yyNO_MATCH))
                  else yyAction4(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction4(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction4(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction4, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction4, yyNO_MATCH))
                  else yyAction4(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction4, yyNO_MATCH))
              else yyAction4(strm, yyNO_MATCH)
      (* end case *))
fun yyQ118 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx65
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx65
              then if inp = 0wx64
                  then yyQ119(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ117 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx6F
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6F
              then if inp = 0wx6E
                  then yyQ118(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ116 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ117(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ115 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx75
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx75
              then if inp = 0wx74
                  then yyQ116(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ121 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction10(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction10, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction10, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction10, yyNO_MATCH))
                      else yyAction10(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction10, yyNO_MATCH))
                  else yyAction10(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction10(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction10(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction10, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction10, yyNO_MATCH))
                  else yyAction10(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction10, yyNO_MATCH))
              else yyAction10(strm, yyNO_MATCH)
      (* end case *))
fun yyQ120 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ121(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ114 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx74
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx74
              then if inp = 0wx73
                  then yyQ120(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ58 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5F
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx5F
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx41
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx41
                  then if inp <= 0wx39
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp <= 0wx5A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx6D
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6D
              then if inp = 0wx61
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx61
                  then yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx6C
                  then yyQ114(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx79
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx79
              then if inp = 0wx78
                  then yyQ115(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ125 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction13(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction13, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction13, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction13, yyNO_MATCH))
                      else yyAction13(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction13, yyNO_MATCH))
                  else yyAction13(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction13(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction13(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction13, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction13, yyNO_MATCH))
                  else yyAction13(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction13, yyNO_MATCH))
              else yyAction13(strm, yyNO_MATCH)
      (* end case *))
fun yyQ126 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction14(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction14, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction14, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction14, yyNO_MATCH))
                      else yyAction14(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction14, yyNO_MATCH))
                  else yyAction14(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction14(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction14(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction14, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction14, yyNO_MATCH))
                  else yyAction14(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction14, yyNO_MATCH))
              else yyAction14(strm, yyNO_MATCH)
      (* end case *))
fun yyQ124 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx77
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx77
              then if inp = 0wx76
                  then yyQ126(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ130 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction6(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction6, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction6, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction6, yyNO_MATCH))
                      else yyAction6(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction6, yyNO_MATCH))
                  else yyAction6(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction6(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction6(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction6, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction6, yyNO_MATCH))
                  else yyAction6(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction6, yyNO_MATCH))
              else yyAction6(strm, yyNO_MATCH)
      (* end case *))
fun yyQ129 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ130(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ128 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx65
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx65
              then if inp = 0wx64
                  then yyQ129(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ127 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx70
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx70
              then if inp = 0wx6F
                  then yyQ128(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ123 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx64
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx64
              then if inp = 0wx63
                  then yyQ127(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ136 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction3(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction3, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction3, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction3, yyNO_MATCH))
                      else yyAction3(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction3, yyNO_MATCH))
                  else yyAction3(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction3(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction3(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction3, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction3, yyNO_MATCH))
                  else yyAction3(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction3, yyNO_MATCH))
              else yyAction3(strm, yyNO_MATCH)
      (* end case *))
fun yyQ135 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ136(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ134 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx71
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx71
              then if inp = 0wx70
                  then yyQ135(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ133 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx7A
              then if inp = 0wx79
                  then yyQ134(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ132 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx75
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx75
              then if inp = 0wx74
                  then yyQ133(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ131 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ132(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ122 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx75
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx75
              then if inp = 0wx74
                  then yyQ131(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ57 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx61
              then yyQ122(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp < 0wx2E
                      then if inp = 0wx2D
                          then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                          else yyAction44(strm, yyNO_MATCH)
                      else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx5B
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then if inp <= 0wx40
                      then yyAction44(strm, yyNO_MATCH)
                      else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx6A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx6A
              then if inp = 0wx66
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx66
                  then if inp = 0wx65
                      then yyQ123(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx69
                  then yyQ124(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx70
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx70
              then if inp = 0wx6F
                  then yyQ125(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ139 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction11(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction11, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction11, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction11, yyNO_MATCH))
                      else yyAction11(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction11, yyNO_MATCH))
                  else yyAction11(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction11(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction11(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction11, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction11, yyNO_MATCH))
                  else yyAction11(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction11, yyNO_MATCH))
              else yyAction11(strm, yyNO_MATCH)
      (* end case *))
fun yyQ138 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx66
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx65
                  then yyQ139(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ137 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx74
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx74
              then if inp = 0wx73
                  then yyQ138(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ56 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx5B
              then if inp = 0wx2F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx3A
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp <= 0wx40
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx61
              then yyQ137(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx61
              then if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ55 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction21(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction21(strm, yyNO_MATCH)
      (* end case *))
fun yyQ54 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction18(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction18(strm, yyNO_MATCH)
      (* end case *))
fun yyQ53 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction29(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction29(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction29(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                          else yyAction29(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction29(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction29(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                      else yyAction29(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                  else yyAction29(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction29(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction29(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                      else yyAction29(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                  else yyAction29(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction29(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
                  else yyAction29(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction29, yyNO_MATCH))
              else yyAction29(strm, yyNO_MATCH)
      (* end case *))
fun yyQ52 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction17(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction17(strm, yyNO_MATCH)
      (* end case *))
fun yyQ51 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyAction44(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyAction44(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ50 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction23(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction23(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction23(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                          else yyAction23(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction23(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction23(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                      else yyAction23(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                  else yyAction23(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction23(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction23(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                      else yyAction23(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                  else yyAction23(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction23(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
                  else yyAction23(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction23, yyNO_MATCH))
              else yyAction23(strm, yyNO_MATCH)
      (* end case *))
fun yyQ49 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction25(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction25(strm, yyNO_MATCH)
      (* end case *))
fun yyQ48 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction27(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction27(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction27(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                          else yyAction27(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction27(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction27(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                      else yyAction27(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                  else yyAction27(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction27(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction27(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                      else yyAction27(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                  else yyAction27(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction27(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
                  else yyAction27(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction27, yyNO_MATCH))
              else yyAction27(strm, yyNO_MATCH)
      (* end case *))
fun yyQ140 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction46(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx2F
              then yyAction46(strm, yyNO_MATCH)
            else if inp < 0wx2F
              then if inp = 0wx2E
                  then yyQ72(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
                  else yyAction46(strm, yyNO_MATCH)
            else if inp <= 0wx39
              then yyQ140(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
              else yyAction46(strm, yyNO_MATCH)
      (* end case *))
fun yyQ47 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction46(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx2F
              then yyAction46(strm, yyNO_MATCH)
            else if inp < 0wx2F
              then if inp = 0wx2E
                  then yyQ72(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
                  else yyAction46(strm, yyNO_MATCH)
            else if inp <= 0wx39
              then yyQ140(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
              else yyAction46(strm, yyNO_MATCH)
      (* end case *))
fun yyQ142 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction49(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ142(strm', yyMATCH(strm, yyAction49, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx30
                  then yyQ142(strm', yyMATCH(strm, yyAction49, yyNO_MATCH))
                else if inp < 0wx30
                  then yyAction49(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ142(strm', yyMATCH(strm, yyAction49, yyNO_MATCH))
                  else yyAction49(strm, yyNO_MATCH)
            else if inp = 0wx61
              then yyQ142(strm', yyMATCH(strm, yyAction49, yyNO_MATCH))
            else if inp < 0wx61
              then if inp <= 0wx46
                  then yyQ142(strm', yyMATCH(strm, yyAction49, yyNO_MATCH))
                  else yyAction49(strm, yyNO_MATCH)
            else if inp <= 0wx66
              then yyQ142(strm', yyMATCH(strm, yyAction49, yyNO_MATCH))
              else yyAction49(strm, yyNO_MATCH)
      (* end case *))
fun yyQ141 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ142(strm', lastMatch)
            else if inp < 0wx41
              then if inp = 0wx30
                  then yyQ142(strm', lastMatch)
                else if inp < 0wx30
                  then yystuck(lastMatch)
                else if inp <= 0wx39
                  then yyQ142(strm', lastMatch)
                  else yystuck(lastMatch)
            else if inp = 0wx61
              then yyQ142(strm', lastMatch)
            else if inp < 0wx61
              then if inp <= 0wx46
                  then yyQ142(strm', lastMatch)
                  else yystuck(lastMatch)
            else if inp <= 0wx66
              then yyQ142(strm', lastMatch)
              else yystuck(lastMatch)
      (* end case *))
fun yyQ46 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction46(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ140(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
            else if inp < 0wx30
              then if inp = 0wx2E
                  then yyQ72(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
                  else yyAction46(strm, yyNO_MATCH)
            else if inp = 0wx78
              then yyQ141(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
            else if inp < 0wx78
              then if inp <= 0wx39
                  then yyQ140(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
                  else yyAction46(strm, yyNO_MATCH)
              else yyAction46(strm, yyNO_MATCH)
      (* end case *))
fun yyQ143 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3C
              then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx3C
              then if inp = 0wx2C
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                          else yyAction44(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction44(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction44(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx30
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx30
                  then if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyQ143(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx3B
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5C
                  then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx5C
                  then if inp = 0wx41
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx5B
                      then yyAction44(strm, yyNO_MATCH)
                      else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx5D
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx7D
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7B
                  then yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ45 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction44(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3C
              then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx3C
              then if inp = 0wx2C
                  then yyAction44(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                          else yyAction44(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction44(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction44(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx30
                  then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx30
                  then if inp = 0wx2E
                      then yyQ78(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                      else yyQ143(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx3B
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5C
                  then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp < 0wx5C
                  then if inp = 0wx41
                      then yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                    else if inp = 0wx5B
                      then yyAction44(strm, yyNO_MATCH)
                      else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                else if inp = 0wx5D
                  then yyAction44(strm, yyNO_MATCH)
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx7D
              then yyAction44(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7B
                  then yyAction44(strm, yyNO_MATCH)
                else if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
                  else yyQ77(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction44, yyNO_MATCH))
              else yyAction44(strm, yyNO_MATCH)
      (* end case *))
fun yyQ144 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction42(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ144(strm', yyMATCH(strm, yyAction42, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyAction42(strm, yyNO_MATCH)
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ144(strm', yyMATCH(strm, yyAction42, yyNO_MATCH))
                      else yyAction42(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ144(strm', yyMATCH(strm, yyAction42, yyNO_MATCH))
                  else yyAction42(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction42(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction42(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ144(strm', yyMATCH(strm, yyAction42, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ144(strm', yyMATCH(strm, yyAction42, yyNO_MATCH))
                  else yyAction42(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ144(strm', yyMATCH(strm, yyAction42, yyNO_MATCH))
              else yyAction42(strm, yyNO_MATCH)
      (* end case *))
fun yyQ44 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction62(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ144(strm', yyMATCH(strm, yyAction62, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyAction62(strm, yyNO_MATCH)
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ144(strm', yyMATCH(strm, yyAction62, yyNO_MATCH))
                      else yyAction62(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ144(strm', yyMATCH(strm, yyAction62, yyNO_MATCH))
                  else yyAction62(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction62(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction62(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ144(strm', yyMATCH(strm, yyAction62, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ144(strm', yyMATCH(strm, yyAction62, yyNO_MATCH))
                  else yyAction62(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ144(strm', yyMATCH(strm, yyAction62, yyNO_MATCH))
              else yyAction62(strm, yyNO_MATCH)
      (* end case *))
fun yyQ43 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction33(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction33(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction33(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                          else yyAction33(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction33(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction33(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                      else yyAction33(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                  else yyAction33(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction33(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction33(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                      else yyAction33(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                  else yyAction33(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction33(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
                  else yyAction33(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction33, yyNO_MATCH))
              else yyAction33(strm, yyNO_MATCH)
      (* end case *))
fun yyQ42 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction24(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction24(strm, yyNO_MATCH)
      (* end case *))
fun yyQ41 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction32(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction32(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction32(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                          else yyAction32(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction32(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction32(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                      else yyAction32(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                  else yyAction32(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction32(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction32(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                      else yyAction32(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                  else yyAction32(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction32(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
                  else yyAction32(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction32, yyNO_MATCH))
              else yyAction32(strm, yyNO_MATCH)
      (* end case *))
fun yyQ40 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction22(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction22(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction22(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                          else yyAction22(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction22(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction22(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                      else yyAction22(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                  else yyAction22(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction22(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction22(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                      else yyAction22(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                  else yyAction22(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction22(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
                  else yyAction22(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction22, yyNO_MATCH))
              else yyAction22(strm, yyNO_MATCH)
      (* end case *))
fun yyQ39 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction31(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction31(strm, yyNO_MATCH)
      (* end case *))
fun yyQ145 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction51(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction51(strm, yyNO_MATCH)
      (* end case *))
fun yyQ38 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction30(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx2A
              then yyQ145(strm', yyMATCH(strm, yyAction30, yyNO_MATCH))
              else yyAction30(strm, yyNO_MATCH)
      (* end case *))
fun yyQ37 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction35(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction35(strm, yyNO_MATCH)
      (* end case *))
fun yyQ36 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction28(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction28(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction28(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                          else yyAction28(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction28(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction28(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                      else yyAction28(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                  else yyAction28(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction28(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction28(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                      else yyAction28(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                  else yyAction28(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction28(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
                  else yyAction28(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction28, yyNO_MATCH))
              else yyAction28(strm, yyNO_MATCH)
      (* end case *))
fun yyQ35 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction15(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction15(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction15(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                          else yyAction15(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction15(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction15(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                      else yyAction15(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                  else yyAction15(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction15(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction15(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                      else yyAction15(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                  else yyAction15(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction15(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
                  else yyAction15(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction15, yyNO_MATCH))
              else yyAction15(strm, yyNO_MATCH)
      (* end case *))
fun yyQ146 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction53(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wxA
              then yyAction53(strm, yyNO_MATCH)
              else yyQ146(strm', yyMATCH(strm, yyAction53, yyNO_MATCH))
      (* end case *))
fun yyQ147 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction45(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3A
              then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp < 0wx3A
              then if inp = 0wx27
                  then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx27
                  then if inp = 0wx21
                      then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp < 0wx21
                      then if inp = 0wxA
                          then yyAction45(strm, yyNO_MATCH)
                          else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp = 0wx22
                      then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx2D
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx2D
                  then if inp = 0wx2A
                      then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp < 0wx2A
                      then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp = 0wx2C
                      then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp = 0wx5F
              then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp < 0wx5F
              then if inp = 0wx5C
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx5C
                  then if inp = 0wx3C
                      then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp < 0wx3C
                      then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp <= 0wx40
                      then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx5D
                  then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp = 0wx7D
              then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp < 0wx7D
              then if inp = 0wx61
                  then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx61
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx7C
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp = 0wx7E
              then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
              else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
      (* end case *))
fun yyQ34 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction45(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3A
              then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp < 0wx3A
              then if inp = 0wx27
                  then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx27
                  then if inp = 0wx21
                      then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp < 0wx21
                      then if inp = 0wxA
                          then yyAction45(strm, yyNO_MATCH)
                          else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp = 0wx22
                      then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx2D
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx2D
                  then if inp = 0wx2A
                      then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp < 0wx2A
                      then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp = 0wx2C
                      then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp = 0wx5F
              then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp < 0wx5F
              then if inp = 0wx5C
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx5C
                  then if inp = 0wx3C
                      then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp < 0wx3C
                      then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp <= 0wx40
                      then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx5D
                  then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp = 0wx7D
              then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp < 0wx7D
              then if inp = 0wx61
                  then yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx61
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx7C
                  then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp = 0wx7E
              then yyQ147(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
              else yyQ146(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
      (* end case *))
fun yyQ33 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction52(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction52(strm, yyNO_MATCH)
      (* end case *))
fun yyQ32 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction45(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx3B
              then yyAction45(strm, yyNO_MATCH)
            else if inp < 0wx3B
              then if inp = 0wx2C
                  then yyAction45(strm, yyNO_MATCH)
                else if inp < 0wx2C
                  then if inp = 0wx23
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx21
                          then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                          else yyAction45(strm, yyNO_MATCH)
                    else if inp = 0wx27
                      then yyAction45(strm, yyNO_MATCH)
                    else if inp < 0wx27
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp <= 0wx29
                      then yyAction45(strm, yyNO_MATCH)
                      else yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp = 0wx2F
                  then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                else if inp < 0wx2F
                  then if inp = 0wx2D
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyAction45(strm, yyNO_MATCH)
                else if inp = 0wx3A
                  then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyAction45(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
            else if inp < 0wx60
              then if inp = 0wx5D
                  then yyAction45(strm, yyNO_MATCH)
                else if inp < 0wx5D
                  then if inp = 0wx41
                      then yyAction45(strm, yyNO_MATCH)
                    else if inp < 0wx41
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                    else if inp = 0wx5C
                      then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                      else yyAction45(strm, yyNO_MATCH)
                else if inp = 0wx5E
                  then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyAction45(strm, yyNO_MATCH)
            else if inp = 0wx7D
              then yyAction45(strm, yyNO_MATCH)
            else if inp < 0wx7D
              then if inp = 0wx7C
                  then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
                  else yyAction45(strm, yyNO_MATCH)
            else if inp = 0wx7E
              then yyQ70(strm', yyMATCH(strm, yyAction45, yyNO_MATCH))
              else yyAction45(strm, yyNO_MATCH)
      (* end case *))
fun yyQ31 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction50(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction50(strm, yyNO_MATCH)
      (* end case *))
fun yyQ20 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction62(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction62(strm, yyNO_MATCH)
      (* end case *))
fun yyQ4 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE =>
            if ULexBuffer.eof(!(yystrm))
              then let
                val yycolno = ref(yygetcolNo(!(yystrm)))
                val yylineno = ref(yygetlineNo(!(yystrm)))
                in
                  (case (!(yyss))
                   of _ => (UserDeclarations.eof())
                  (* end case *))
                end
              else yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx5B
              then yyQ52(strm', lastMatch)
            else if inp < 0wx5B
              then if inp = 0wx2A
                  then yyQ40(strm', lastMatch)
                else if inp < 0wx2A
                  then if inp = 0wx23
                      then yyQ34(strm', lastMatch)
                    else if inp < 0wx23
                      then if inp = 0wx20
                          then yyQ31(strm', lastMatch)
                        else if inp < 0wx20
                          then if inp = 0wx9
                              then yyQ31(strm', lastMatch)
                            else if inp < 0wx9
                              then yyQ20(strm', lastMatch)
                            else if inp <= 0wxD
                              then yyQ31(strm', lastMatch)
                              else yyQ20(strm', lastMatch)
                        else if inp = 0wx21
                          then yyQ32(strm', lastMatch)
                          else yyQ33(strm', lastMatch)
                    else if inp = 0wx27
                      then yyQ37(strm', lastMatch)
                    else if inp < 0wx27
                      then if inp = 0wx25
                          then yyQ35(strm', lastMatch)
                        else if inp = 0wx24
                          then yyQ32(strm', lastMatch)
                          else yyQ36(strm', lastMatch)
                    else if inp = 0wx28
                      then yyQ38(strm', lastMatch)
                      else yyQ39(strm', lastMatch)
                else if inp = 0wx31
                  then yyQ47(strm', lastMatch)
                else if inp < 0wx31
                  then if inp = 0wx2E
                      then yyQ44(strm', lastMatch)
                    else if inp < 0wx2E
                      then if inp = 0wx2C
                          then yyQ42(strm', lastMatch)
                        else if inp = 0wx2B
                          then yyQ41(strm', lastMatch)
                          else yyQ43(strm', lastMatch)
                    else if inp = 0wx2F
                      then yyQ45(strm', lastMatch)
                      else yyQ46(strm', lastMatch)
                else if inp = 0wx3C
                  then yyQ32(strm', lastMatch)
                else if inp < 0wx3C
                  then if inp = 0wx3A
                      then yyQ48(strm', lastMatch)
                    else if inp = 0wx3B
                      then yyQ49(strm', lastMatch)
                      else yyQ47(strm', lastMatch)
                else if inp = 0wx3E
                  then yyQ32(strm', lastMatch)
                else if inp < 0wx3E
                  then yyQ50(strm', lastMatch)
                else if inp <= 0wx40
                  then yyQ32(strm', lastMatch)
                  else yyQ51(strm', lastMatch)
            else if inp = 0wx6A
              then yyQ51(strm', lastMatch)
            else if inp < 0wx6A
              then if inp = 0wx63
                  then yyQ56(strm', lastMatch)
                else if inp < 0wx63
                  then if inp = 0wx5F
                      then yyQ55(strm', lastMatch)
                    else if inp < 0wx5F
                      then if inp = 0wx5D
                          then yyQ54(strm', lastMatch)
                        else if inp = 0wx5C
                          then yyQ53(strm', lastMatch)
                          else yyQ32(strm', lastMatch)
                    else if inp = 0wx60
                      then yyQ32(strm', lastMatch)
                      else yyQ51(strm', lastMatch)
                else if inp = 0wx67
                  then yyQ59(strm', lastMatch)
                else if inp < 0wx67
                  then if inp = 0wx65
                      then yyQ58(strm', lastMatch)
                    else if inp = 0wx64
                      then yyQ57(strm', lastMatch)
                      else yyQ51(strm', lastMatch)
                else if inp = 0wx68
                  then yyQ51(strm', lastMatch)
                  else yyQ60(strm', lastMatch)
            else if inp = 0wx74
              then yyQ65(strm', lastMatch)
            else if inp < 0wx74
              then if inp = 0wx6F
                  then yyQ62(strm', lastMatch)
                else if inp < 0wx6F
                  then if inp = 0wx6C
                      then yyQ61(strm', lastMatch)
                      else yyQ51(strm', lastMatch)
                else if inp = 0wx72
                  then yyQ63(strm', lastMatch)
                else if inp = 0wx73
                  then yyQ64(strm', lastMatch)
                  else yyQ51(strm', lastMatch)
            else if inp = 0wx7D
              then yyQ68(strm', lastMatch)
            else if inp < 0wx7D
              then if inp = 0wx7B
                  then yyQ66(strm', lastMatch)
                else if inp = 0wx7C
                  then yyQ67(strm', lastMatch)
                  else yyQ51(strm', lastMatch)
            else if inp = 0wx7E
              then yyQ69(strm', lastMatch)
              else yyQ20(strm', lastMatch)
      (* end case *))
fun yyQ28 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction36(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction36(strm, yyNO_MATCH)
      (* end case *))
fun yyQ29 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction38(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ29(strm', yyMATCH(strm, yyAction38, yyNO_MATCH))
            else if inp < 0wx30
              then yyAction38(strm, yyNO_MATCH)
            else if inp <= 0wx31
              then yyQ29(strm', yyMATCH(strm, yyAction38, yyNO_MATCH))
              else yyAction38(strm, yyNO_MATCH)
      (* end case *))
fun yyQ27 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction38(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ29(strm', yyMATCH(strm, yyAction38, yyNO_MATCH))
            else if inp < 0wx30
              then yyAction38(strm, yyNO_MATCH)
            else if inp <= 0wx31
              then yyQ29(strm', yyMATCH(strm, yyAction38, yyNO_MATCH))
              else yyAction38(strm, yyNO_MATCH)
      (* end case *))
fun yyQ30 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction39(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyAction39(strm, yyNO_MATCH)
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
                      else yyAction39(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
                  else yyAction39(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction39(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction39(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
                  else yyAction39(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
              else yyAction39(strm, yyNO_MATCH)
      (* end case *))
fun yyQ26 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction39(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx41
              then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
            else if inp < 0wx41
              then if inp = 0wx2E
                  then yyAction39(strm, yyNO_MATCH)
                else if inp < 0wx2E
                  then if inp = 0wx2D
                      then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
                      else yyAction39(strm, yyNO_MATCH)
                else if inp <= 0wx39
                  then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
                  else yyAction39(strm, yyNO_MATCH)
            else if inp = 0wx60
              then yyAction39(strm, yyNO_MATCH)
            else if inp < 0wx60
              then if inp = 0wx5B
                  then yyAction39(strm, yyNO_MATCH)
                else if inp < 0wx5B
                  then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
                else if inp = 0wx5F
                  then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
                  else yyAction39(strm, yyNO_MATCH)
            else if inp <= 0wx7A
              then yyQ30(strm', yyMATCH(strm, yyAction39, yyNO_MATCH))
              else yyAction39(strm, yyNO_MATCH)
      (* end case *))
fun yyQ22 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction37(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction37(strm, yyNO_MATCH)
      (* end case *))
fun yyQ25 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction40(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction40(strm, yyNO_MATCH)
      (* end case *))
fun yyQ3 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE =>
            if ULexBuffer.eof(!(yystrm))
              then let
                val yycolno = ref(yygetcolNo(!(yystrm)))
                val yylineno = ref(yygetlineNo(!(yystrm)))
                in
                  (case (!(yyss))
                   of _ => (UserDeclarations.eof())
                  (* end case *))
                end
              else yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ27(strm', lastMatch)
            else if inp < 0wx30
              then if inp = 0wx21
                  then yyQ20(strm', lastMatch)
                else if inp < 0wx21
                  then if inp = 0wxE
                      then yyQ20(strm', lastMatch)
                    else if inp < 0wxE
                      then if inp <= 0wx8
                          then yyQ20(strm', lastMatch)
                          else yyQ25(strm', lastMatch)
                    else if inp = 0wx20
                      then yyQ25(strm', lastMatch)
                      else yyQ20(strm', lastMatch)
                else if inp = 0wx28
                  then yyQ20(strm', lastMatch)
                else if inp < 0wx28
                  then if inp = 0wx27
                      then yyQ22(strm', lastMatch)
                      else yyQ20(strm', lastMatch)
                else if inp = 0wx2F
                  then yyQ26(strm', lastMatch)
                  else yyQ20(strm', lastMatch)
            else if inp = 0wx41
              then yyQ26(strm', lastMatch)
            else if inp < 0wx41
              then if inp = 0wx3A
                  then yyQ28(strm', lastMatch)
                else if inp < 0wx3A
                  then if inp <= 0wx31
                      then yyQ27(strm', lastMatch)
                      else yyQ20(strm', lastMatch)
                  else yyQ20(strm', lastMatch)
            else if inp = 0wx61
              then yyQ26(strm', lastMatch)
            else if inp < 0wx61
              then if inp <= 0wx5A
                  then yyQ26(strm', lastMatch)
                  else yyQ20(strm', lastMatch)
            else if inp <= 0wx7A
              then yyQ26(strm', lastMatch)
              else yyQ20(strm', lastMatch)
      (* end case *))
fun yyQ24 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction46(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ24(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
            else if inp < 0wx30
              then yyAction46(strm, yyNO_MATCH)
            else if inp <= 0wx39
              then yyQ24(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
              else yyAction46(strm, yyNO_MATCH)
      (* end case *))
fun yyQ23 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction46(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ24(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
            else if inp < 0wx30
              then yyAction46(strm, yyNO_MATCH)
            else if inp <= 0wx39
              then yyQ24(strm', yyMATCH(strm, yyAction46, yyNO_MATCH))
              else yyAction46(strm, yyNO_MATCH)
      (* end case *))
fun yyQ21 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction41(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction41(strm, yyNO_MATCH)
      (* end case *))
fun yyQ2 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE =>
            if ULexBuffer.eof(!(yystrm))
              then let
                val yycolno = ref(yygetcolNo(!(yystrm)))
                val yylineno = ref(yygetlineNo(!(yystrm)))
                in
                  (case (!(yyss))
                   of _ => (UserDeclarations.eof())
                  (* end case *))
                end
              else yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx21
              then yyQ20(strm', lastMatch)
            else if inp < 0wx21
              then if inp = 0wxE
                  then yyQ20(strm', lastMatch)
                else if inp < 0wxE
                  then if inp <= 0wx8
                      then yyQ20(strm', lastMatch)
                      else yyQ21(strm', lastMatch)
                else if inp = 0wx20
                  then yyQ21(strm', lastMatch)
                  else yyQ20(strm', lastMatch)
            else if inp = 0wx28
              then yyQ20(strm', lastMatch)
            else if inp < 0wx28
              then if inp = 0wx27
                  then yyQ22(strm', lastMatch)
                  else yyQ20(strm', lastMatch)
            else if inp = 0wx30
              then yyQ23(strm', lastMatch)
            else if inp < 0wx30
              then yyQ20(strm', lastMatch)
            else if inp <= 0wx39
              then yyQ23(strm', lastMatch)
              else yyQ20(strm', lastMatch)
      (* end case *))
fun yyQ18 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction60(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction60(strm, yyNO_MATCH)
      (* end case *))
fun yyQ17 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction61(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx29
              then yyQ18(strm', yyMATCH(strm, yyAction61, yyNO_MATCH))
              else yyAction61(strm, yyNO_MATCH)
      (* end case *))
fun yyQ19 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction59(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction59(strm, yyNO_MATCH)
      (* end case *))
fun yyQ16 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction61(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx2A
              then yyQ19(strm', yyMATCH(strm, yyAction61, yyNO_MATCH))
              else yyAction61(strm, yyNO_MATCH)
      (* end case *))
fun yyQ15 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction61(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction61(strm, yyNO_MATCH)
      (* end case *))
fun yyQ1 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE =>
            if ULexBuffer.eof(!(yystrm))
              then let
                val yycolno = ref(yygetcolNo(!(yystrm)))
                val yylineno = ref(yygetlineNo(!(yystrm)))
                in
                  (case (!(yyss))
                   of _ => (UserDeclarations.eof())
                  (* end case *))
                end
              else yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx29
              then yyQ15(strm', lastMatch)
            else if inp < 0wx29
              then if inp = 0wx28
                  then yyQ16(strm', lastMatch)
                  else yyQ15(strm', lastMatch)
            else if inp = 0wx2A
              then yyQ17(strm', lastMatch)
              else yyQ15(strm', lastMatch)
      (* end case *))
fun yyQ13 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction54(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction54(strm, yyNO_MATCH)
      (* end case *))
fun yyQ12 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ13(strm', lastMatch)
            else if inp < 0wx30
              then yystuck(lastMatch)
            else if inp <= 0wx39
              then yyQ13(strm', lastMatch)
              else yystuck(lastMatch)
      (* end case *))
fun yyQ11 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction57(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx30
              then yyQ12(strm', yyMATCH(strm, yyAction57, yyNO_MATCH))
            else if inp < 0wx30
              then yyAction57(strm, yyNO_MATCH)
            else if inp <= 0wx39
              then yyQ12(strm', yyMATCH(strm, yyAction57, yyNO_MATCH))
              else yyAction57(strm, yyNO_MATCH)
      (* end case *))
fun yyQ10 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction54(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction54(strm, yyNO_MATCH)
      (* end case *))
fun yyQ9 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction57(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction57(strm, yyNO_MATCH)
      (* end case *))
fun yyQ8 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction58(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx66
              then yyQ10(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
            else if inp < 0wx66
              then if inp = 0wx3A
                  then yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                else if inp < 0wx3A
                  then if inp = 0wx23
                      then yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                    else if inp < 0wx23
                      then if inp = 0wx22
                          then yyQ10(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                          else yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                    else if inp <= 0wx2F
                      then yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                      else yyQ11(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                else if inp = 0wx5D
                  then yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                else if inp < 0wx5D
                  then if inp = 0wx5C
                      then yyQ10(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                      else yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                else if inp = 0wx61
                  then yyQ10(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                else if inp < 0wx61
                  then yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                else if inp <= 0wx62
                  then yyQ10(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                  else yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
            else if inp = 0wx73
              then yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
            else if inp < 0wx73
              then if inp = 0wx6F
                  then yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                else if inp < 0wx6F
                  then if inp = 0wx6E
                      then yyQ10(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                      else yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                else if inp = 0wx72
                  then yyQ10(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                  else yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
            else if inp = 0wx76
              then yyQ10(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
            else if inp < 0wx76
              then if inp = 0wx74
                  then yyQ10(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
                  else yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
              else yyQ9(strm', yyMATCH(strm, yyAction58, yyNO_MATCH))
      (* end case *))
fun yyQ7 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction56(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction56(strm, yyNO_MATCH)
      (* end case *))
fun yyQ14 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction55(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx23
              then yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
            else if inp < 0wx23
              then if inp = 0wx20
                  then yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
                else if inp < 0wx20
                  then yyAction55(strm, yyNO_MATCH)
                else if inp = 0wx22
                  then yyAction55(strm, yyNO_MATCH)
                  else yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
            else if inp = 0wx5D
              then yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
            else if inp < 0wx5D
              then if inp = 0wx5C
                  then yyAction55(strm, yyNO_MATCH)
                  else yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
            else if inp <= 0wx7E
              then yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
              else yyAction55(strm, yyNO_MATCH)
      (* end case *))
fun yyQ6 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction55(strm, yyNO_MATCH)
        | SOME(inp, strm') =>
            if inp = 0wx23
              then yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
            else if inp < 0wx23
              then if inp = 0wx20
                  then yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
                else if inp < 0wx20
                  then yyAction55(strm, yyNO_MATCH)
                else if inp = 0wx22
                  then yyAction55(strm, yyNO_MATCH)
                  else yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
            else if inp = 0wx5D
              then yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
            else if inp < 0wx5D
              then if inp = 0wx5C
                  then yyAction55(strm, yyNO_MATCH)
                  else yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
            else if inp <= 0wx7E
              then yyQ14(strm', yyMATCH(strm, yyAction55, yyNO_MATCH))
              else yyAction55(strm, yyNO_MATCH)
      (* end case *))
fun yyQ5 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE => yyAction58(strm, yyNO_MATCH)
        | SOME(inp, strm') => yyAction58(strm, yyNO_MATCH)
      (* end case *))
fun yyQ0 (strm, lastMatch : yymatch) = (case (yygetc(strm))
       of NONE =>
            if ULexBuffer.eof(!(yystrm))
              then let
                val yycolno = ref(yygetcolNo(!(yystrm)))
                val yylineno = ref(yygetlineNo(!(yystrm)))
                in
                  (case (!(yyss))
                   of _ => (UserDeclarations.eof())
                  (* end case *))
                end
              else yystuck(lastMatch)
        | SOME(inp, strm') =>
            if inp = 0wx23
              then yyQ6(strm', lastMatch)
            else if inp < 0wx23
              then if inp = 0wx20
                  then yyQ6(strm', lastMatch)
                else if inp < 0wx20
                  then yyQ5(strm', lastMatch)
                else if inp = 0wx22
                  then yyQ7(strm', lastMatch)
                  else yyQ6(strm', lastMatch)
            else if inp = 0wx5D
              then yyQ6(strm', lastMatch)
            else if inp < 0wx5D
              then if inp = 0wx5C
                  then yyQ8(strm', lastMatch)
                  else yyQ6(strm', lastMatch)
            else if inp <= 0wx7E
              then yyQ6(strm', lastMatch)
              else yyQ5(strm', lastMatch)
      (* end case *))
in
  (case (!(yyss))
   of STRING => yyQ0(!(yystrm), yyNO_MATCH)
    | COMMENT => yyQ1(!(yystrm), yyNO_MATCH)
    | BITPATNUM => yyQ2(!(yystrm), yyNO_MATCH)
    | BITPAT => yyQ3(!(yystrm), yyNO_MATCH)
    | INITIAL => yyQ4(!(yystrm), yyNO_MATCH)
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
