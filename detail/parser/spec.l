
%name SpecLex;

%arg (lexErr);

%defs(

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
);

%states INITIAL BITPAT BITPATNUM STRING COMMENT;

%let letter = [a-zA-Z/];
%let dig = [0-9];
%let num = {dig}+;
%let hexdigit = [0-9a-fA-F];
%let hexnum = "0x"{hexdigit}+;
%let idchar = {letter}|{dig}|"_"|"-";
%let id = {letter}{idchar}*;
%let esc = "\\"[abfnrtv\\\"]|"\\"{dig}{dig}{dig};
%let sgood = [\032-\126]&[^\"\\]; (* sgood means "characters good inside strings" *)
%let ws = " "|[\t\n\v\f\r];
%let binary = [0-1];
%let bitstr = {binary}+;
%let sym=[-!%&$+/:<=>?@~`\^|#*\\];
%let symid={sym}+;

<INITIAL>"granularity" => (T.KW_granularity);
<INITIAL>"state" => (T.KW_state);
<INITIAL>"include" => (T.KW_include);
<INITIAL>"datatype" => (T.KW_datatype);
<INITIAL>"extend" => (T.KW_extend);
<INITIAL>"type" => (T.KW_type);
<INITIAL>"decode" => (T.KW_decode);
<INITIAL>"raise" => (T.KW_raise);
<INITIAL>"if" => (T.KW_if);
<INITIAL>"then" => (T.KW_then);
<INITIAL>"else" => (T.KW_else);
<INITIAL>"case" => (T.KW_case);
<INITIAL>"let" => (T.KW_let);
<INITIAL>"val" => (T.KW_val);
<INITIAL>"end" => (T.KW_end);
<INITIAL>"rec" => (T.KW_rec);
<INITIAL>"do" => (T.KW_do);
<INITIAL>"in" => (T.KW_in);
<INITIAL>"div" => (T.KW_div);
<INITIAL>"<-" => (T.BIND);
<INITIAL>"%" => (T.KW_mod);
<INITIAL>"of" => (T.KW_of);
<INITIAL>"[" => (T.LB);
<INITIAL>"]" => (T.RB);
<INITIAL>"{" => (T.LCB);
<INITIAL>"}" => (T.RCB);
<INITIAL>"_" => (T.WILD);
<INITIAL>"*" => (T.TIMES);
<INITIAL>"=" => (T.EQ);
<INITIAL>"," => (T.COMMA);
<INITIAL>";" => (T.SEMI);
<INITIAL>"|" => (T.BAR);
<INITIAL>":" => (T.COLON);
<INITIAL>"&" => (T.AMP);
<INITIAL>"\\" => (T.BACKSLASH);
<INITIAL>"(" => (T.LP);
<INITIAL>")" => (T.RP);
<INITIAL>"+" => (T.PLUS);
<INITIAL>"-" => (T.MINUS);
<INITIAL>"~" => (T.TILDE);
<INITIAL>"'" => (YYBEGIN BITPAT; T.TICK);
<INITIAL>"." => (T.DOT);

<BITPAT>":" => (YYBEGIN BITPATNUM; T.COLON);
<BITPAT,BITPATNUM>"'" => (YYBEGIN INITIAL; T.TICK);
<BITPAT>{bitstr} => (T.BITSTR yytext);
<BITPAT>{id} => (T.ID (Atom.atom yytext));
<BITPAT>{ws} => (skip ());
<BITPATNUM>{ws} => (YYBEGIN BITPAT; skip());

<INITIAL>{id} => (T.ID (Atom.atom yytext));
<INITIAL>{symid} => (T.SYMBOL (Atom.atom yytext));
<INITIAL,BITPATNUM>{num} => (T.POSINT(valOf (IntInf.fromString yytext)));
<INITIAL>"~"{num} => (T.NEGINT(valOf (IntInf.fromString yytext)));
<INITIAL>"~"?{num}"."{num}([eE][+~]?{num})? => (mkFloat yysubstr);
<INITIAL>{hexnum} => (T.POSINT(fromHexString yytext));
<INITIAL>{ws} => (skip ());
<INITIAL>"(*" => (YYBEGIN COMMENT; depth := 1; skip());
<INITIAL>"\"" => (YYBEGIN STRING; skip());
<INITIAL>"#"[^\n]* => (skip());

<STRING>{esc} => (addStr(valOf(String.fromString yytext)); continue());
<STRING>{sgood}+ => (addStr yytext; continue());
<STRING>"\"" => (YYBEGIN INITIAL; mkString());
<STRING>"\\". =>
   (lexErr
      (yypos,
       ["bad escape character `", String.toString yytext,
		  "' in string literal"])
   ;continue());
<STRING>. =>
   (lexErr
      (yypos,
         ["bad character `", String.toString yytext,
			 "' in string literal"])
   ;continue());

<COMMENT>"(*" =>
   (depth := !depth + 1
	;skip());
<COMMENT>"*)" =>
   (depth := !depth - 1
   ;if (!depth = 0) then YYBEGIN INITIAL else ()
	;skip ());
<COMMENT>.|"\n" => (skip ());

<INITIAL,BITPAT,BITPATNUM>. =>
   (lexErr
         (yypos,
          ["bad character `", String.toString yytext, "'"])
   ;continue());