structure 
SpecTokens = struct

    datatype token = EOF
      | SYMBOL of Atom.atom
      | STRING of string
      | FLOAT of FloatLit.float
      | NEGINT of IntInf.int
      | POSINT of IntInf.int
      | CONS of Atom.atom
      | ID of Atom.atom
      | TYVAR of Atom.atom
      | BITSTR of string
      | WILD
      | COLON
      | BAR
      | SEMI
      | COMMA
      | TILDE
      | SLASH
      | TIMES
      | MINUS
      | PLUS
      | CONCAT
      | RCB
      | LCB
      | RB
      | LB
      | RP
      | LP
      | DOT
      | TICK
      | EQ
      | BIND
      | SELECT
      | WITH
      | KW_orelse
      | KW_andalso
      | KW_type
      | KW_then
      | KW_state
      | KW_raise
      | KW_granularity
      | KW_of
      | KW_mod
      | KW_val
      | KW_let
      | KW_if
      | KW_end
      | KW_else
      | KW_div
      | KW_export
      | KW_include
      | KW_datatype
      | KW_do
      | KW_in
      | KW_case

    val allToks = [EOF, WILD, COLON, BAR, SEMI, COMMA, TILDE, SLASH, TIMES, MINUS, PLUS, CONCAT, RCB, LCB, RB, LB, RP, LP, DOT, TICK, EQ, BIND, SELECT, WITH, KW_orelse, KW_andalso, KW_type, KW_then, KW_state, KW_raise, KW_granularity, KW_of, KW_mod, KW_val, KW_let, KW_if, KW_end, KW_else, KW_div, KW_export, KW_include, KW_datatype, KW_do, KW_in, KW_case]

    fun toString tok =
(case (tok)
 of (EOF) => "EOF"
  | (SYMBOL(_)) => "SYMBOL"
  | (STRING(_)) => "STRING"
  | (FLOAT(_)) => "FLOAT"
  | (NEGINT(_)) => "NEGINT"
  | (POSINT(_)) => "POSINT"
  | (CONS(_)) => "CONS"
  | (ID(_)) => "ID"
  | (TYVAR(_)) => "TYVAR"
  | (BITSTR(_)) => "BITSTR"
  | (WILD) => "_"
  | (COLON) => ":"
  | (BAR) => "|"
  | (SEMI) => ";"
  | (COMMA) => ","
  | (TILDE) => "~"
  | (SLASH) => "/"
  | (TIMES) => "*"
  | (MINUS) => "-"
  | (PLUS) => "+"
  | (CONCAT) => "^"
  | (RCB) => "}"
  | (LCB) => "{"
  | (RB) => "]"
  | (LB) => "["
  | (RP) => ")"
  | (LP) => "("
  | (DOT) => "."
  | (TICK) => "'"
  | (EQ) => "="
  | (BIND) => "<-"
  | (SELECT) => "$"
  | (WITH) => "@"
  | (KW_orelse) => "orelse"
  | (KW_andalso) => "andalso"
  | (KW_type) => "type"
  | (KW_then) => "then"
  | (KW_state) => "state"
  | (KW_raise) => "raise"
  | (KW_granularity) => "granularity"
  | (KW_of) => "of"
  | (KW_mod) => "%"
  | (KW_val) => "val"
  | (KW_let) => "let"
  | (KW_if) => "if"
  | (KW_end) => "end"
  | (KW_else) => "else"
  | (KW_div) => "div"
  | (KW_export) => "export"
  | (KW_include) => "include"
  | (KW_datatype) => "datatype"
  | (KW_do) => "do"
  | (KW_in) => "in"
  | (KW_case) => "case"
(* end case *))
    fun isKW tok =
(case (tok)
 of (EOF) => false
  | (SYMBOL(_)) => false
  | (STRING(_)) => false
  | (FLOAT(_)) => false
  | (NEGINT(_)) => false
  | (POSINT(_)) => false
  | (CONS(_)) => false
  | (ID(_)) => false
  | (TYVAR(_)) => false
  | (BITSTR(_)) => false
  | (WILD) => false
  | (COLON) => false
  | (BAR) => false
  | (SEMI) => false
  | (COMMA) => false
  | (TILDE) => false
  | (SLASH) => false
  | (TIMES) => false
  | (MINUS) => false
  | (PLUS) => false
  | (CONCAT) => false
  | (RCB) => false
  | (LCB) => false
  | (RB) => false
  | (LB) => false
  | (RP) => false
  | (LP) => false
  | (DOT) => false
  | (TICK) => false
  | (EQ) => false
  | (BIND) => false
  | (SELECT) => false
  | (WITH) => false
  | (KW_orelse) => false
  | (KW_andalso) => false
  | (KW_type) => false
  | (KW_then) => false
  | (KW_state) => false
  | (KW_raise) => false
  | (KW_granularity) => false
  | (KW_of) => false
  | (KW_mod) => false
  | (KW_val) => false
  | (KW_let) => false
  | (KW_if) => false
  | (KW_end) => false
  | (KW_else) => false
  | (KW_div) => false
  | (KW_export) => false
  | (KW_include) => false
  | (KW_datatype) => false
  | (KW_do) => false
  | (KW_in) => false
  | (KW_case) => false
(* end case *))


  fun toksToString toks = String.concatWith " " (map toString toks)

  fun isEOF EOF = true
    | isEOF _ = false

end

functor SpecParseFn(Lex : ANTLR_LEXER) = struct

  local
    structure Tok = 
SpecTokens
    structure UserCode = struct

 
   structure PT = SpecParseTree

   
   fun mark cons (span : AntlrStreamPos.span, tr) = cons{span = span, tree = tr}

   
   val markDecl = mark PT.MARKdecl
   fun markExp (_, e as PT.MARKexp _) = e
     | markExp (sp, tr) = mark PT.MARKexp (sp, tr)
   fun markPat (_, p as PT.MARKpat _) = p
     | markPat (sp, tr) = mark PT.MARKpat (sp, tr)

   
   fun mkCondExp con = let
      fun mk (e, []) = e
        | mk (e, e'::r) = mk (con(e', e), r)
   in
      mk
   end

   
   fun mkBinApp (e1, rator, e2) = PT.BINARYexp(e1, rator, e2)

   
   fun mkLBinExp (e, []) = e
     | mkLBinExp (e, (id, e')::r) = mkLBinExp (mkBinApp(e, id, e'), r)

   
   fun mkRBinExp (e, []) = e
     | mkRBinExp (e, [(id, e')]) = mkBinApp(e, id, e')
     | mkRBinExp (e, (id, e')::r) = mkBinApp(e, id, mkRBinExp(e', r))

   
   fun mkApply (e, []) = e
     | mkApply (e, e'::r) = mkApply (PT.APPLYexp(e, e'), r)


fun Program_PROD_1_ACT (SR, Decl, SR_SPAN : (Lex.pos * Lex.pos), Decl_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      {span=FULL_SPAN, tree=Decl::SR})
fun Decl_PROD_1_ACT (EQ, Int, KW_granularity, EQ_SPAN : (Lex.pos * Lex.pos), Int_SPAN : (Lex.pos * Lex.pos), KW_granularity_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( markDecl (FULL_SPAN, PT.GRANULARITYdecl Int))
fun Decl_PROD_2_ACT (EQ, Qid, KW_export, EQ_SPAN : (Lex.pos * Lex.pos), Qid_SPAN : (Lex.pos * Lex.pos), KW_export_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( markDecl (FULL_SPAN, PT.EXPORTdecl Qid))
fun Decl_PROD_3_ACT (STRING, KW_include, STRING_SPAN : (Lex.pos * Lex.pos), KW_include_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( markDecl (FULL_SPAN, PT.INCLUDEdecl STRING))
fun Decl_PROD_4_ACT (EQ, KW_state, StateTy, EQ_SPAN : (Lex.pos * Lex.pos), KW_state_SPAN : (Lex.pos * Lex.pos), StateTy_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( markDecl (FULL_SPAN, PT.STATEdecl StateTy))
fun Decl_PROD_5_ACT (EQ, Name, KW_datatype, ConDecls, EQ_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), KW_datatype_SPAN : (Lex.pos * Lex.pos), ConDecls_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      markDecl (FULL_SPAN, PT.DATATYPEdecl (Name, ConDecls)))
fun Decl_PROD_6_ACT (EQ, Ty, Name, KW_type, EQ_SPAN : (Lex.pos * Lex.pos), Ty_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), KW_type_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( markDecl (FULL_SPAN, PT.TYPEdecl (Name, Ty)))
fun Decl_PROD_7_ACT (EQ, Exp, Name1, Name2, KW_val, EQ_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Name1_SPAN : (Lex.pos * Lex.pos), Name2_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      markDecl (FULL_SPAN, PT.LETRECdecl (Name1, Name2, Exp)))
fun Decl_PROD_8_ACT (EQ, Exp, Sym, Name, KW_val, EQ_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Sym_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      markDecl (FULL_SPAN, PT.LETRECdecl (Sym, Name, Exp)))
fun Decl_PROD_9_SUBRULE_2_PROD_1_ACT (EQ, LB, RB, Exp, Name, DecodePat, KW_val, EQ_SPAN : (Lex.pos * Lex.pos), LB_SPAN : (Lex.pos * Lex.pos), RB_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), DecodePat_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
         PT.DECODEdecl (Name, DecodePat, Sum.INL Exp))
fun Decl_PROD_9_SUBRULE_2_PROD_2_ACT (LB, RB, SR, Name, DecodePat, KW_val, LB_SPAN : (Lex.pos * Lex.pos), RB_SPAN : (Lex.pos * Lex.pos), SR_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), DecodePat_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
         PT.DECODEdecl (Name, DecodePat, Sum.INR SR))
fun Decl_PROD_9_ACT (LB, RB, Name, decl, DecodePat, KW_val, LB_SPAN : (Lex.pos * Lex.pos), RB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), decl_SPAN : (Lex.pos * Lex.pos), DecodePat_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      markDecl (FULL_SPAN, decl))
fun StateTy_PROD_1_ACT (EQ, SR, Ty, Exp, LCB, RCB, Name, COLON, EQ_SPAN : (Lex.pos * Lex.pos), SR_SPAN : (Lex.pos * Lex.pos), Ty_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), COLON_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      (Name, Ty, Exp)::SR)
fun ConDecls_PROD_1_ACT (SR, ConDecl, SR_SPAN : (Lex.pos * Lex.pos), ConDecl_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( ConDecl::SR)
fun ConDecl_PROD_1_ACT (SR, ConBind, SR_SPAN : (Lex.pos * Lex.pos), ConBind_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( (ConBind, SR))
fun Ty_PROD_1_ACT (Int, Int_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKty (FULL_SPAN, PT.BITty Int))
fun Ty_PROD_2_ACT (Qid, Qid_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKty (FULL_SPAN, PT.NAMEDty Qid))
fun Ty_PROD_3_ACT (SR, Ty, LCB, RCB, Name, COLON, SR_SPAN : (Lex.pos * Lex.pos), Ty_SPAN : (Lex.pos * Lex.pos), LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), COLON_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKty (FULL_SPAN, PT.RECORDty ((Name, Ty)::SR)))
fun DecodePat_PROD_1_ACT (BitPat, BitPat_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( BitPat)
fun DecodePat_PROD_2_ACT (TokPat, TokPat_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKdecodepat (FULL_SPAN, PT.TOKENdecodepat TokPat))
fun BitPat_PROD_1_ACT (PrimBitPat, TICK1, TICK2, PrimBitPat_SPAN : (Lex.pos * Lex.pos), TICK1_SPAN : (Lex.pos * Lex.pos), TICK2_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKdecodepat (FULL_SPAN, PT.BITdecodepat PrimBitPat))
fun TokPat_PROD_1_ACT (Int, Int_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKtokpat (FULL_SPAN, PT.TOKtokpat Int))
fun TokPat_PROD_2_ACT (Qid, Qid_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKtokpat (FULL_SPAN, PT.NAMEDtokpat Qid))
fun PrimBitPat_PROD_1_ACT (BITSTR, BITSTR_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKbitpat (FULL_SPAN, PT.BITSTRbitpat BITSTR))
fun PrimBitPat_PROD_2_ACT (SR, Qid, SR_SPAN : (Lex.pos * Lex.pos), Qid_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark
         PT.MARKbitpat
         (FULL_SPAN,
          case SR of
             NONE => PT.NAMEDbitpat Qid
           | SOME i => PT.BITVECbitpat (#tree Qid, i)))
fun Exp_PROD_1_ACT (ClosedExp, ClosedExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( ClosedExp)
fun Exp_PROD_2_ACT (KW_case, Cases, KW_of, ClosedExp, KW_end, KW_case_SPAN : (Lex.pos * Lex.pos), Cases_SPAN : (Lex.pos * Lex.pos), KW_of_SPAN : (Lex.pos * Lex.pos), ClosedExp_SPAN : (Lex.pos * Lex.pos), KW_end_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, PT.CASEexp (ClosedExp, Cases)))
fun ClosedExp_PROD_2_ACT (Exp1, Exp2, Exp3, KW_else, KW_then, KW_if, Exp1_SPAN : (Lex.pos * Lex.pos), Exp2_SPAN : (Lex.pos * Lex.pos), Exp3_SPAN : (Lex.pos * Lex.pos), KW_else_SPAN : (Lex.pos * Lex.pos), KW_then_SPAN : (Lex.pos * Lex.pos), KW_if_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, PT.IFexp (Exp1, Exp2, Exp3)))
fun ClosedExp_PROD_3_ACT (SR, MonadicExp, KW_do, KW_end, SR_SPAN : (Lex.pos * Lex.pos), MonadicExp_SPAN : (Lex.pos * Lex.pos), KW_do_SPAN : (Lex.pos * Lex.pos), KW_end_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, PT.SEQexp (MonadicExp::SR)))
fun MonadicExp_PROD_1_ACT (Exp, Exp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKseqexp (FULL_SPAN, PT.ACTIONseqexp Exp))
fun MonadicExp_PROD_2_ACT (Exp, BIND, Name, Exp_SPAN : (Lex.pos * Lex.pos), BIND_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKseqexp (FULL_SPAN, PT.BINDseqexp (Name, Exp)))
fun Cases_PROD_1_ACT (SR, Exp, Pat, COLON, SR_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Pat_SPAN : (Lex.pos * Lex.pos), COLON_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( (Pat, Exp)::SR)
fun Pat_PROD_1_ACT (WILD, WILD_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKpat (FULL_SPAN, PT.WILDpat))
fun Pat_PROD_2_ACT (Lit, Lit_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKpat (FULL_SPAN, PT.LITpat Lit))
fun Pat_PROD_3_ACT (Name, Name_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKpat (FULL_SPAN, PT.IDpat Name))
fun Pat_PROD_4_ACT (Pat, ConUse, Pat_SPAN : (Lex.pos * Lex.pos), ConUse_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKpat (FULL_SPAN, PT.CONpat (ConUse, Pat)))
fun OrElseExp_PROD_1_ACT (SR, AndAlsoExp, SR_SPAN : (Lex.pos * Lex.pos), AndAlsoExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, mkLBinExp (AndAlsoExp, SR)))
fun OrElse_PROD_1_ACT (KW_orelse, KW_orelse_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.orElse))
fun AndAlsoExp_PROD_1_ACT (SR, RExp, SR_SPAN : (Lex.pos * Lex.pos), RExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, mkLBinExp (RExp, SR)))
fun AndAlso_PROD_1_ACT (KW_andalso, KW_andalso_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.andAlso))
fun RExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1_ACT (Sym, AExp, Sym_SPAN : (Lex.pos * Lex.pos), AExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Sym))
fun RExp_PROD_1_ACT (SR, AExp, SR_SPAN : (Lex.pos * Lex.pos), AExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, mkLBinExp(AExp, SR)))
fun AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1_ACT (MExp, PLUS, MExp_SPAN : (Lex.pos * Lex.pos), PLUS_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.plus))
fun AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_2_ACT (MExp, MINUS, MExp_SPAN : (Lex.pos * Lex.pos), MINUS_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.minus))
fun AExp_PROD_1_SUBRULE_1_PROD_1_ACT (SR, MExp, SR_SPAN : (Lex.pos * Lex.pos), MExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( SR, MExp)
fun AExp_PROD_1_ACT (SR, MExp, SR_SPAN : (Lex.pos * Lex.pos), MExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, mkLBinExp (MExp, SR)))
fun MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1_ACT (TIMES, SelectExp, TIMES_SPAN : (Lex.pos * Lex.pos), SelectExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.times))
fun MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_2_ACT (SelectExp, KW_div, SelectExp_SPAN : (Lex.pos * Lex.pos), KW_div_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.div))
fun MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_3_ACT (SelectExp, KW_mod, SelectExp_SPAN : (Lex.pos * Lex.pos), KW_mod_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.mod))
fun MExp_PROD_1_SUBRULE_1_PROD_1_ACT (SR, SelectExp, ApplyExp, SR_SPAN : (Lex.pos * Lex.pos), SelectExp_SPAN : (Lex.pos * Lex.pos), ApplyExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      SR, SelectExp)
fun MExp_PROD_1_ACT (SR, SelectExp, SR_SPAN : (Lex.pos * Lex.pos), SelectExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
         mark PT.MARKexp (FULL_SPAN, mkLBinExp (SelectExp, SR)))
fun SelectExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1_ACT (CONCAT, ApplyExp, CONCAT_SPAN : (Lex.pos * Lex.pos), ApplyExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.concat))
fun SelectExp_PROD_1_SUBRULE_1_PROD_1_ACT (SR, ApplyExp, SR_SPAN : (Lex.pos * Lex.pos), ApplyExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( SR, ApplyExp)
fun SelectExp_PROD_1_ACT (SR, ApplyExp, SR_SPAN : (Lex.pos * Lex.pos), ApplyExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, mkLBinExp (ApplyExp, SR)))
fun ApplyExp_PROD_1_SUBRULE_1_PROD_1_ACT (rhs, AtomicExp, rhs_SPAN : (Lex.pos * Lex.pos), AtomicExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mkApply(AtomicExp, rhs))
fun ApplyExp_PROD_1_ACT (exp, AtomicExp, exp_SPAN : (Lex.pos * Lex.pos), AtomicExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
         mark PT.MARKexp (FULL_SPAN, exp))
fun ApplyExp_PROD_2_ACT (TILDE, AtomicExp, TILDE_SPAN : (Lex.pos * Lex.pos), AtomicExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, PT.APPLYexp (PT.IDexp {span=FULL_SPAN, tree=Op.uminus}, AtomicExp)))
fun AtomicExp_PROD_1_ACT (Lit, Lit_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKexp (FULL_SPAN, PT.LITexp Lit))
fun AtomicExp_PROD_2_ACT (Qid, Qid_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKexp (FULL_SPAN, PT.IDexp Qid))
fun AtomicExp_PROD_3_ACT (ConUse, ConUse_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKexp (FULL_SPAN, PT.CONexp ConUse))
fun AtomicExp_PROD_4_ACT (EQ, SR, Exp, LCB, RCB, Name, WITH, EQ_SPAN : (Lex.pos * Lex.pos), SR_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), WITH_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, PT.UPDATEexp ((Name, Exp)::SR)))
fun AtomicExp_PROD_5_ACT (Qid, SELECT, Qid_SPAN : (Lex.pos * Lex.pos), SELECT_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKexp (FULL_SPAN, PT.SELECTexp Qid))
fun AtomicExp_PROD_6_ACT (LP, RP, LP_SPAN : (Lex.pos * Lex.pos), RP_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKexp (FULL_SPAN, PT.RECORDexp []))
fun AtomicExp_PROD_7_ACT (LP, RP, Exp, LP_SPAN : (Lex.pos * Lex.pos), RP_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( Exp)
fun AtomicExp_PROD_8_ACT (LCB, RCB, LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( mark PT.MARKexp (FULL_SPAN, PT.RECORDexp []))
fun AtomicExp_PROD_9_ACT (EQ, SR, Exp, LCB, RCB, Name, EQ_SPAN : (Lex.pos * Lex.pos), SR_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, PT.RECORDexp ((Name, Exp)::SR)))
fun AtomicExp_PROD_10_ACT (Exp, ValueDecl, KW_in, KW_end, KW_let, Exp_SPAN : (Lex.pos * Lex.pos), ValueDecl_SPAN : (Lex.pos * Lex.pos), KW_in_SPAN : (Lex.pos * Lex.pos), KW_end_SPAN : (Lex.pos * Lex.pos), KW_let_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  (
      mark PT.MARKexp (FULL_SPAN, PT.LETRECexp (ValueDecl, Exp)))
fun ValueDecl_PROD_1_ACT (EQ, Exp, Name1, Name2, KW_val, EQ_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Name1_SPAN : (Lex.pos * Lex.pos), Name2_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( Name1, Name2, Exp)
fun Lit_PROD_1_ACT (Int, Int_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( PT.INTlit Int)
fun Lit_PROD_2_ACT (STRING, STRING_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( PT.STRlit STRING)
fun Lit_PROD_3_ACT (TICK1, TICK2, BITSTR, TICK1_SPAN : (Lex.pos * Lex.pos), TICK2_SPAN : (Lex.pos * Lex.pos), BITSTR_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( PT.VEClit BITSTR)
fun Int_PROD_1_ACT (POSINT, POSINT_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( POSINT)
fun Int_PROD_2_ACT (NEGINT, NEGINT_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( NEGINT)
fun Name_PROD_1_ACT (ID, ID_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( ID)
fun ConBind_PROD_1_ACT (CONS, CONS_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( CONS)
fun ConUse_PROD_1_ACT (CONS, CONS_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( {span=FULL_SPAN, tree=CONS})
fun Sym_PROD_1_ACT (SYMBOL, SYMBOL_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( SYMBOL)
fun Qid_PROD_1_ACT (ID, ID_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)) = 
  ( {span=FULL_SPAN, tree=ID})

    end

    structure Err = AntlrErrHandler(
      structure Tok = Tok
      structure Lex = Lex)
    structure EBNF = AntlrEBNF(struct
			         type strm = Err.wstream
			         val getSpan = Err.getSpan
			       end)

    fun mk lexFn = let
fun getS() = {}
fun putS{} = ()
fun unwrap (ret, strm, repairs) = (ret, strm, repairs)
        val (eh, lex) = Err.mkErrHandler {get = getS, put = putS}
	fun fail() = Err.failure eh
	fun tryProds (strm, prods) = let
	  fun try [] = fail()
	    | try (prod :: prods) = 
	        (Err.whileDisabled eh (fn() => prod strm)) 
		handle Err.ParseError => try (prods)
          in try prods end
fun matchEOF strm = (case (lex(strm))
 of (Tok.EOF, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchSYMBOL strm = (case (lex(strm))
 of (Tok.SYMBOL(x), span, strm') => (x, span, strm')
  | _ => fail()
(* end case *))
fun matchSTRING strm = (case (lex(strm))
 of (Tok.STRING(x), span, strm') => (x, span, strm')
  | _ => fail()
(* end case *))
fun matchFLOAT strm = (case (lex(strm))
 of (Tok.FLOAT(x), span, strm') => (x, span, strm')
  | _ => fail()
(* end case *))
fun matchNEGINT strm = (case (lex(strm))
 of (Tok.NEGINT(x), span, strm') => (x, span, strm')
  | _ => fail()
(* end case *))
fun matchPOSINT strm = (case (lex(strm))
 of (Tok.POSINT(x), span, strm') => (x, span, strm')
  | _ => fail()
(* end case *))
fun matchCONS strm = (case (lex(strm))
 of (Tok.CONS(x), span, strm') => (x, span, strm')
  | _ => fail()
(* end case *))
fun matchID strm = (case (lex(strm))
 of (Tok.ID(x), span, strm') => (x, span, strm')
  | _ => fail()
(* end case *))
fun matchTYVAR strm = (case (lex(strm))
 of (Tok.TYVAR(x), span, strm') => (x, span, strm')
  | _ => fail()
(* end case *))
fun matchBITSTR strm = (case (lex(strm))
 of (Tok.BITSTR(x), span, strm') => (x, span, strm')
  | _ => fail()
(* end case *))
fun matchWILD strm = (case (lex(strm))
 of (Tok.WILD, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchCOLON strm = (case (lex(strm))
 of (Tok.COLON, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchBAR strm = (case (lex(strm))
 of (Tok.BAR, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchSEMI strm = (case (lex(strm))
 of (Tok.SEMI, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchCOMMA strm = (case (lex(strm))
 of (Tok.COMMA, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchTILDE strm = (case (lex(strm))
 of (Tok.TILDE, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchSLASH strm = (case (lex(strm))
 of (Tok.SLASH, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchTIMES strm = (case (lex(strm))
 of (Tok.TIMES, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchMINUS strm = (case (lex(strm))
 of (Tok.MINUS, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchPLUS strm = (case (lex(strm))
 of (Tok.PLUS, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchCONCAT strm = (case (lex(strm))
 of (Tok.CONCAT, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchRCB strm = (case (lex(strm))
 of (Tok.RCB, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchLCB strm = (case (lex(strm))
 of (Tok.LCB, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchRB strm = (case (lex(strm))
 of (Tok.RB, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchLB strm = (case (lex(strm))
 of (Tok.LB, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchRP strm = (case (lex(strm))
 of (Tok.RP, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchLP strm = (case (lex(strm))
 of (Tok.LP, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchDOT strm = (case (lex(strm))
 of (Tok.DOT, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchTICK strm = (case (lex(strm))
 of (Tok.TICK, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchEQ strm = (case (lex(strm))
 of (Tok.EQ, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchBIND strm = (case (lex(strm))
 of (Tok.BIND, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchSELECT strm = (case (lex(strm))
 of (Tok.SELECT, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchWITH strm = (case (lex(strm))
 of (Tok.WITH, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_orelse strm = (case (lex(strm))
 of (Tok.KW_orelse, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_andalso strm = (case (lex(strm))
 of (Tok.KW_andalso, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_type strm = (case (lex(strm))
 of (Tok.KW_type, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_then strm = (case (lex(strm))
 of (Tok.KW_then, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_state strm = (case (lex(strm))
 of (Tok.KW_state, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_raise strm = (case (lex(strm))
 of (Tok.KW_raise, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_granularity strm = (case (lex(strm))
 of (Tok.KW_granularity, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_of strm = (case (lex(strm))
 of (Tok.KW_of, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_mod strm = (case (lex(strm))
 of (Tok.KW_mod, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_val strm = (case (lex(strm))
 of (Tok.KW_val, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_let strm = (case (lex(strm))
 of (Tok.KW_let, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_if strm = (case (lex(strm))
 of (Tok.KW_if, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_end strm = (case (lex(strm))
 of (Tok.KW_end, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_else strm = (case (lex(strm))
 of (Tok.KW_else, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_div strm = (case (lex(strm))
 of (Tok.KW_div, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_export strm = (case (lex(strm))
 of (Tok.KW_export, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_include strm = (case (lex(strm))
 of (Tok.KW_include, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_datatype strm = (case (lex(strm))
 of (Tok.KW_datatype, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_do strm = (case (lex(strm))
 of (Tok.KW_do, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_in strm = (case (lex(strm))
 of (Tok.KW_in, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))
fun matchKW_case strm = (case (lex(strm))
 of (Tok.KW_case, span, strm') => ((), span, strm')
  | _ => fail()
(* end case *))

val (Program_NT) = 
let
fun ConUse_NT (strm) = let
      val (CONS_RES, CONS_SPAN, strm') = matchCONS(strm)
      val FULL_SPAN = (#1(CONS_SPAN), #2(CONS_SPAN))
      in
        (UserCode.ConUse_PROD_1_ACT (CONS_RES, CONS_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun Name_NT (strm) = let
      val (ID_RES, ID_SPAN, strm') = matchID(strm)
      val FULL_SPAN = (#1(ID_SPAN), #2(ID_SPAN))
      in
        (UserCode.Name_PROD_1_ACT (ID_RES, ID_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun Int_NT (strm) = let
      fun Int_PROD_1 (strm) = let
            val (POSINT_RES, POSINT_SPAN, strm') = matchPOSINT(strm)
            val FULL_SPAN = (#1(POSINT_SPAN), #2(POSINT_SPAN))
            in
              (UserCode.Int_PROD_1_ACT (POSINT_RES, POSINT_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Int_PROD_2 (strm) = let
            val (NEGINT_RES, NEGINT_SPAN, strm') = matchNEGINT(strm)
            val FULL_SPAN = (#1(NEGINT_SPAN), #2(NEGINT_SPAN))
            in
              (UserCode.Int_PROD_2_ACT (NEGINT_RES, NEGINT_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.NEGINT(_), _, strm') => Int_PROD_2(strm)
          | (Tok.POSINT(_), _, strm') => Int_PROD_1(strm)
          | _ => fail()
        (* end case *))
      end
fun Lit_NT (strm) = let
      fun Lit_PROD_1 (strm) = let
            val (Int_RES, Int_SPAN, strm') = Int_NT(strm)
            val FULL_SPAN = (#1(Int_SPAN), #2(Int_SPAN))
            in
              (UserCode.Lit_PROD_1_ACT (Int_RES, Int_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Lit_PROD_2 (strm) = let
            val (STRING_RES, STRING_SPAN, strm') = matchSTRING(strm)
            val FULL_SPAN = (#1(STRING_SPAN), #2(STRING_SPAN))
            in
              (UserCode.Lit_PROD_2_ACT (STRING_RES, STRING_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Lit_PROD_3 (strm) = let
            val (TICK1_RES, TICK1_SPAN, strm') = matchTICK(strm)
            val (BITSTR_RES, BITSTR_SPAN, strm') = matchBITSTR(strm')
            val (TICK2_RES, TICK2_SPAN, strm') = matchTICK(strm')
            val FULL_SPAN = (#1(TICK1_SPAN), #2(TICK2_SPAN))
            in
              (UserCode.Lit_PROD_3_ACT (TICK1_RES, TICK2_RES, BITSTR_RES, TICK1_SPAN : (Lex.pos * Lex.pos), TICK2_SPAN : (Lex.pos * Lex.pos), BITSTR_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.TICK, _, strm') => Lit_PROD_3(strm)
          | (Tok.POSINT(_), _, strm') => Lit_PROD_1(strm)
          | (Tok.NEGINT(_), _, strm') => Lit_PROD_1(strm)
          | (Tok.STRING(_), _, strm') => Lit_PROD_2(strm)
          | _ => fail()
        (* end case *))
      end
fun Pat_NT (strm) = let
      fun Pat_PROD_1 (strm) = let
            val (WILD_RES, WILD_SPAN, strm') = matchWILD(strm)
            val FULL_SPAN = (#1(WILD_SPAN), #2(WILD_SPAN))
            in
              (UserCode.Pat_PROD_1_ACT (WILD_RES, WILD_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Pat_PROD_2 (strm) = let
            val (Lit_RES, Lit_SPAN, strm') = Lit_NT(strm)
            val FULL_SPAN = (#1(Lit_SPAN), #2(Lit_SPAN))
            in
              (UserCode.Pat_PROD_2_ACT (Lit_RES, Lit_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Pat_PROD_3 (strm) = let
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm)
            val FULL_SPAN = (#1(Name_SPAN), #2(Name_SPAN))
            in
              (UserCode.Pat_PROD_3_ACT (Name_RES, Name_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Pat_PROD_4 (strm) = let
            val (ConUse_RES, ConUse_SPAN, strm') = ConUse_NT(strm)
            fun Pat_PROD_4_SUBRULE_1_NT (strm) = let
                  val (Pat_RES, Pat_SPAN, strm') = Pat_NT(strm)
                  val FULL_SPAN = (#1(Pat_SPAN), #2(Pat_SPAN))
                  in
                    ((Pat_RES), FULL_SPAN, strm')
                  end
            fun Pat_PROD_4_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.TICK, _, strm') => true
                    | (Tok.WILD, _, strm') => true
                    | (Tok.ID(_), _, strm') => true
                    | (Tok.CONS(_), _, strm') => true
                    | (Tok.POSINT(_), _, strm') => true
                    | (Tok.NEGINT(_), _, strm') => true
                    | (Tok.STRING(_), _, strm') => true
                    | _ => false
                  (* end case *))
            val (Pat_RES, Pat_SPAN, strm') = EBNF.optional(Pat_PROD_4_SUBRULE_1_PRED, Pat_PROD_4_SUBRULE_1_NT, strm')
            val FULL_SPAN = (#1(ConUse_SPAN), #2(Pat_SPAN))
            in
              (UserCode.Pat_PROD_4_ACT (Pat_RES, ConUse_RES, Pat_SPAN : (Lex.pos * Lex.pos), ConUse_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.CONS(_), _, strm') => Pat_PROD_4(strm)
          | (Tok.TICK, _, strm') => Pat_PROD_2(strm)
          | (Tok.POSINT(_), _, strm') => Pat_PROD_2(strm)
          | (Tok.NEGINT(_), _, strm') => Pat_PROD_2(strm)
          | (Tok.STRING(_), _, strm') => Pat_PROD_2(strm)
          | (Tok.WILD, _, strm') => Pat_PROD_1(strm)
          | (Tok.ID(_), _, strm') => Pat_PROD_3(strm)
          | _ => fail()
        (* end case *))
      end
fun Qid_NT (strm) = let
      val (ID_RES, ID_SPAN, strm') = matchID(strm)
      val FULL_SPAN = (#1(ID_SPAN), #2(ID_SPAN))
      in
        (UserCode.Qid_PROD_1_ACT (ID_RES, ID_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun Sym_NT (strm) = let
      val (SYMBOL_RES, SYMBOL_SPAN, strm') = matchSYMBOL(strm)
      val FULL_SPAN = (#1(SYMBOL_SPAN), #2(SYMBOL_SPAN))
      in
        (UserCode.Sym_PROD_1_ACT (SYMBOL_RES, SYMBOL_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun AndAlso_NT (strm) = let
      val (KW_andalso_RES, KW_andalso_SPAN, strm') = matchKW_andalso(strm)
      val FULL_SPAN = (#1(KW_andalso_SPAN), #2(KW_andalso_SPAN))
      in
        (UserCode.AndAlso_PROD_1_ACT (KW_andalso_RES, KW_andalso_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun OrElse_NT (strm) = let
      val (KW_orelse_RES, KW_orelse_SPAN, strm') = matchKW_orelse(strm)
      val FULL_SPAN = (#1(KW_orelse_SPAN), #2(KW_orelse_SPAN))
      in
        (UserCode.OrElse_PROD_1_ACT (KW_orelse_RES, KW_orelse_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun Exp_NT (strm) = let
      fun Exp_PROD_1 (strm) = let
            val (ClosedExp_RES, ClosedExp_SPAN, strm') = ClosedExp_NT(strm)
            val FULL_SPAN = (#1(ClosedExp_SPAN), #2(ClosedExp_SPAN))
            in
              (UserCode.Exp_PROD_1_ACT (ClosedExp_RES, ClosedExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Exp_PROD_2 (strm) = let
            val (KW_case_RES, KW_case_SPAN, strm') = matchKW_case(strm)
            val (ClosedExp_RES, ClosedExp_SPAN, strm') = ClosedExp_NT(strm')
            val (KW_of_RES, KW_of_SPAN, strm') = matchKW_of(strm')
            val (Cases_RES, Cases_SPAN, strm') = Cases_NT(strm')
            val (KW_end_RES, KW_end_SPAN, strm') = matchKW_end(strm')
            val FULL_SPAN = (#1(KW_case_SPAN), #2(KW_end_SPAN))
            in
              (UserCode.Exp_PROD_2_ACT (KW_case_RES, Cases_RES, KW_of_RES, ClosedExp_RES, KW_end_RES, KW_case_SPAN : (Lex.pos * Lex.pos), Cases_SPAN : (Lex.pos * Lex.pos), KW_of_SPAN : (Lex.pos * Lex.pos), ClosedExp_SPAN : (Lex.pos * Lex.pos), KW_end_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.KW_case, _, strm') => Exp_PROD_2(strm)
          | (Tok.KW_do, _, strm') => Exp_PROD_1(strm)
          | (Tok.KW_if, _, strm') => Exp_PROD_1(strm)
          | (Tok.KW_let, _, strm') => Exp_PROD_1(strm)
          | (Tok.WITH, _, strm') => Exp_PROD_1(strm)
          | (Tok.SELECT, _, strm') => Exp_PROD_1(strm)
          | (Tok.TICK, _, strm') => Exp_PROD_1(strm)
          | (Tok.LP, _, strm') => Exp_PROD_1(strm)
          | (Tok.LCB, _, strm') => Exp_PROD_1(strm)
          | (Tok.TILDE, _, strm') => Exp_PROD_1(strm)
          | (Tok.ID(_), _, strm') => Exp_PROD_1(strm)
          | (Tok.CONS(_), _, strm') => Exp_PROD_1(strm)
          | (Tok.POSINT(_), _, strm') => Exp_PROD_1(strm)
          | (Tok.NEGINT(_), _, strm') => Exp_PROD_1(strm)
          | (Tok.STRING(_), _, strm') => Exp_PROD_1(strm)
          | _ => fail()
        (* end case *))
      end
and Cases_NT (strm) = let
      val (Pat_RES, Pat_SPAN, strm') = Pat_NT(strm)
      val (COLON_RES, COLON_SPAN, strm') = matchCOLON(strm')
      val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
      fun Cases_PROD_1_SUBRULE_1_NT (strm) = let
            val (BAR_RES, BAR_SPAN, strm') = matchBAR(strm)
            val (Pat_RES, Pat_SPAN, strm') = Pat_NT(strm')
            val (COLON_RES, COLON_SPAN, strm') = matchCOLON(strm')
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
            val FULL_SPAN = (#1(BAR_SPAN), #2(Exp_SPAN))
            in
              ((Pat_RES, Exp_RES), FULL_SPAN, strm')
            end
      fun Cases_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.BAR, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(Cases_PROD_1_SUBRULE_1_PRED, Cases_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(Pat_SPAN), #2(SR_SPAN))
      in
        (UserCode.Cases_PROD_1_ACT (SR_RES, Exp_RES, Pat_RES, COLON_RES, SR_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Pat_SPAN : (Lex.pos * Lex.pos), COLON_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
and ClosedExp_NT (strm) = let
      fun ClosedExp_PROD_1 (strm) = let
            val (OrElseExp_RES, OrElseExp_SPAN, strm') = OrElseExp_NT(strm)
            val FULL_SPAN = (#1(OrElseExp_SPAN), #2(OrElseExp_SPAN))
            in
              ((OrElseExp_RES), FULL_SPAN, strm')
            end
      fun ClosedExp_PROD_2 (strm) = let
            val (KW_if_RES, KW_if_SPAN, strm') = matchKW_if(strm)
            val (Exp1_RES, Exp1_SPAN, strm') = Exp_NT(strm')
            val (KW_then_RES, KW_then_SPAN, strm') = matchKW_then(strm')
            val (Exp2_RES, Exp2_SPAN, strm') = Exp_NT(strm')
            val (KW_else_RES, KW_else_SPAN, strm') = matchKW_else(strm')
            val (Exp3_RES, Exp3_SPAN, strm') = Exp_NT(strm')
            val FULL_SPAN = (#1(KW_if_SPAN), #2(Exp3_SPAN))
            in
              (UserCode.ClosedExp_PROD_2_ACT (Exp1_RES, Exp2_RES, Exp3_RES, KW_else_RES, KW_then_RES, KW_if_RES, Exp1_SPAN : (Lex.pos * Lex.pos), Exp2_SPAN : (Lex.pos * Lex.pos), Exp3_SPAN : (Lex.pos * Lex.pos), KW_else_SPAN : (Lex.pos * Lex.pos), KW_then_SPAN : (Lex.pos * Lex.pos), KW_if_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun ClosedExp_PROD_3 (strm) = let
            val (KW_do_RES, KW_do_SPAN, strm') = matchKW_do(strm)
            val (MonadicExp_RES, MonadicExp_SPAN, strm') = MonadicExp_NT(strm')
            fun ClosedExp_PROD_3_SUBRULE_1_NT (strm) = let
                  val (SEMI_RES, SEMI_SPAN, strm') = matchSEMI(strm)
                  val (MonadicExp_RES, MonadicExp_SPAN, strm') = MonadicExp_NT(strm')
                  val FULL_SPAN = (#1(SEMI_SPAN), #2(MonadicExp_SPAN))
                  in
                    ((MonadicExp_RES), FULL_SPAN, strm')
                  end
            fun ClosedExp_PROD_3_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.SEMI, _, strm') => true
                    | _ => false
                  (* end case *))
            val (SR_RES, SR_SPAN, strm') = EBNF.closure(ClosedExp_PROD_3_SUBRULE_1_PRED, ClosedExp_PROD_3_SUBRULE_1_NT, strm')
            val (KW_end_RES, KW_end_SPAN, strm') = matchKW_end(strm')
            val FULL_SPAN = (#1(KW_do_SPAN), #2(KW_end_SPAN))
            in
              (UserCode.ClosedExp_PROD_3_ACT (SR_RES, MonadicExp_RES, KW_do_RES, KW_end_RES, SR_SPAN : (Lex.pos * Lex.pos), MonadicExp_SPAN : (Lex.pos * Lex.pos), KW_do_SPAN : (Lex.pos * Lex.pos), KW_end_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.KW_do, _, strm') => ClosedExp_PROD_3(strm)
          | (Tok.KW_let, _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.WITH, _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.SELECT, _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.TICK, _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.LP, _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.LCB, _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.TILDE, _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.ID(_), _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.CONS(_), _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.POSINT(_), _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.NEGINT(_), _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.STRING(_), _, strm') => ClosedExp_PROD_1(strm)
          | (Tok.KW_if, _, strm') => ClosedExp_PROD_2(strm)
          | _ => fail()
        (* end case *))
      end
and MonadicExp_NT (strm) = let
      fun MonadicExp_PROD_1 (strm) = let
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm)
            val FULL_SPAN = (#1(Exp_SPAN), #2(Exp_SPAN))
            in
              (UserCode.MonadicExp_PROD_1_ACT (Exp_RES, Exp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun MonadicExp_PROD_2 (strm) = let
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm)
            val (BIND_RES, BIND_SPAN, strm') = matchBIND(strm')
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
            val FULL_SPAN = (#1(Name_SPAN), #2(Exp_SPAN))
            in
              (UserCode.MonadicExp_PROD_2_ACT (Exp_RES, BIND_RES, Name_RES, Exp_SPAN : (Lex.pos * Lex.pos), BIND_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.ID(_), _, strm') =>
              (case (lex(strm'))
               of (Tok.KW_div, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.KW_end, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.KW_let, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.KW_mod, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.KW_andalso, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.KW_orelse, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.WITH, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.SELECT, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.TICK, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.LP, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.LCB, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.CONCAT, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.PLUS, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.MINUS, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.TIMES, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.SEMI, _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.ID(_), _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.CONS(_), _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.POSINT(_), _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.NEGINT(_), _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.STRING(_), _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.SYMBOL(_), _, strm') => MonadicExp_PROD_1(strm)
                | (Tok.BIND, _, strm') => MonadicExp_PROD_2(strm)
                | _ => fail()
              (* end case *))
          | (Tok.KW_case, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.KW_do, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.KW_if, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.KW_let, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.WITH, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.SELECT, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.TICK, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.LP, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.LCB, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.TILDE, _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.CONS(_), _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.POSINT(_), _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.NEGINT(_), _, strm') => MonadicExp_PROD_1(strm)
          | (Tok.STRING(_), _, strm') => MonadicExp_PROD_1(strm)
          | _ => fail()
        (* end case *))
      end
and OrElseExp_NT (strm) = let
      val (AndAlsoExp_RES, AndAlsoExp_SPAN, strm') = AndAlsoExp_NT(strm)
      fun OrElseExp_PROD_1_SUBRULE_1_NT (strm) = let
            val (OrElse_RES, OrElse_SPAN, strm') = OrElse_NT(strm)
            val (AndAlsoExp_RES, AndAlsoExp_SPAN, strm') = AndAlsoExp_NT(strm')
            val FULL_SPAN = (#1(OrElse_SPAN), #2(AndAlsoExp_SPAN))
            in
              ((OrElse_RES, AndAlsoExp_RES), FULL_SPAN, strm')
            end
      fun OrElseExp_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.KW_orelse, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(OrElseExp_PROD_1_SUBRULE_1_PRED, OrElseExp_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(AndAlsoExp_SPAN), #2(SR_SPAN))
      in
        (UserCode.OrElseExp_PROD_1_ACT (SR_RES, AndAlsoExp_RES, SR_SPAN : (Lex.pos * Lex.pos), AndAlsoExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
and AndAlsoExp_NT (strm) = let
      val (RExp_RES, RExp_SPAN, strm') = RExp_NT(strm)
      fun AndAlsoExp_PROD_1_SUBRULE_1_NT (strm) = let
            val (AndAlso_RES, AndAlso_SPAN, strm') = AndAlso_NT(strm)
            val (RExp_RES, RExp_SPAN, strm') = RExp_NT(strm')
            val FULL_SPAN = (#1(AndAlso_SPAN), #2(RExp_SPAN))
            in
              ((AndAlso_RES, RExp_RES), FULL_SPAN, strm')
            end
      fun AndAlsoExp_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.KW_andalso, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(AndAlsoExp_PROD_1_SUBRULE_1_PRED, AndAlsoExp_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(RExp_SPAN), #2(SR_SPAN))
      in
        (UserCode.AndAlsoExp_PROD_1_ACT (SR_RES, RExp_RES, SR_SPAN : (Lex.pos * Lex.pos), RExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
and RExp_NT (strm) = let
      val (AExp_RES, AExp_SPAN, strm') = AExp_NT(strm)
      fun RExp_PROD_1_SUBRULE_1_NT (strm) = let
            val (SR_RES, SR_SPAN, strm') = let
            fun RExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT (strm) = let
                  val (Sym_RES, Sym_SPAN, strm') = Sym_NT(strm)
                  val FULL_SPAN = (#1(Sym_SPAN), #2(Sym_SPAN))
                  in
                    (UserCode.RExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1_ACT (Sym_RES, AExp_RES, Sym_SPAN : (Lex.pos * Lex.pos), AExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                      FULL_SPAN, strm')
                  end
            in
              RExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT(strm)
            end
            val (AExp_RES, AExp_SPAN, strm') = AExp_NT(strm')
            val FULL_SPAN = (#1(SR_SPAN), #2(AExp_SPAN))
            in
              ((SR_RES, AExp_RES), FULL_SPAN, strm')
            end
      fun RExp_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.SYMBOL(_), _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(RExp_PROD_1_SUBRULE_1_PRED, RExp_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(AExp_SPAN), #2(SR_SPAN))
      in
        (UserCode.RExp_PROD_1_ACT (SR_RES, AExp_RES, SR_SPAN : (Lex.pos * Lex.pos), AExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
and AExp_NT (strm) = let
      val (MExp_RES, MExp_SPAN, strm') = MExp_NT(strm)
      fun AExp_PROD_1_SUBRULE_1_NT (strm) = let
            val (SR_RES, SR_SPAN, strm') = let
            fun AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT (strm) = let
                  fun AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1 (strm) = let
                        val (PLUS_RES, PLUS_SPAN, strm') = matchPLUS(strm)
                        val FULL_SPAN = (#1(PLUS_SPAN), #2(PLUS_SPAN))
                        in
                          (UserCode.AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1_ACT (MExp_RES, PLUS_RES, MExp_SPAN : (Lex.pos * Lex.pos), PLUS_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                            FULL_SPAN, strm')
                        end
                  fun AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_2 (strm) = let
                        val (MINUS_RES, MINUS_SPAN, strm') = matchMINUS(strm)
                        val FULL_SPAN = (#1(MINUS_SPAN), #2(MINUS_SPAN))
                        in
                          (UserCode.AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_2_ACT (MExp_RES, MINUS_RES, MExp_SPAN : (Lex.pos * Lex.pos), MINUS_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                            FULL_SPAN, strm')
                        end
                  in
                    (case (lex(strm))
                     of (Tok.MINUS, _, strm') =>
                          AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_2(strm)
                      | (Tok.PLUS, _, strm') =>
                          AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1(strm)
                      | _ => fail()
                    (* end case *))
                  end
            in
              AExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT(strm)
            end
            val (MExp_RES, MExp_SPAN, strm') = MExp_NT(strm')
            val FULL_SPAN = (#1(SR_SPAN), #2(MExp_SPAN))
            in
              (UserCode.AExp_PROD_1_SUBRULE_1_PROD_1_ACT (SR_RES, MExp_RES, SR_SPAN : (Lex.pos * Lex.pos), MExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AExp_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.PLUS, _, strm') => true
              | (Tok.MINUS, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(AExp_PROD_1_SUBRULE_1_PRED, AExp_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(MExp_SPAN), #2(SR_SPAN))
      in
        (UserCode.AExp_PROD_1_ACT (SR_RES, MExp_RES, SR_SPAN : (Lex.pos * Lex.pos), MExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
and MExp_NT (strm) = let
      val (SelectExp_RES, SelectExp_SPAN, strm') = SelectExp_NT(strm)
      fun MExp_PROD_1_SUBRULE_1_NT (strm) = let
            val (SR_RES, SR_SPAN, strm') = let
            fun MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT (strm) = let
                  fun MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1 (strm) = let
                        val (TIMES_RES, TIMES_SPAN, strm') = matchTIMES(strm)
                        val FULL_SPAN = (#1(TIMES_SPAN), #2(TIMES_SPAN))
                        in
                          (UserCode.MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1_ACT (TIMES_RES, SelectExp_RES, TIMES_SPAN : (Lex.pos * Lex.pos), SelectExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                            FULL_SPAN, strm')
                        end
                  fun MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_2 (strm) = let
                        val (KW_div_RES, KW_div_SPAN, strm') = matchKW_div(strm)
                        val FULL_SPAN = (#1(KW_div_SPAN), #2(KW_div_SPAN))
                        in
                          (UserCode.MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_2_ACT (SelectExp_RES, KW_div_RES, SelectExp_SPAN : (Lex.pos * Lex.pos), KW_div_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                            FULL_SPAN, strm')
                        end
                  fun MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_3 (strm) = let
                        val (KW_mod_RES, KW_mod_SPAN, strm') = matchKW_mod(strm)
                        val FULL_SPAN = (#1(KW_mod_SPAN), #2(KW_mod_SPAN))
                        in
                          (UserCode.MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_3_ACT (SelectExp_RES, KW_mod_RES, SelectExp_SPAN : (Lex.pos * Lex.pos), KW_mod_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                            FULL_SPAN, strm')
                        end
                  in
                    (case (lex(strm))
                     of (Tok.KW_mod, _, strm') =>
                          MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_3(strm)
                      | (Tok.TIMES, _, strm') =>
                          MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1(strm)
                      | (Tok.KW_div, _, strm') =>
                          MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_2(strm)
                      | _ => fail()
                    (* end case *))
                  end
            in
              MExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT(strm)
            end
            val (ApplyExp_RES, ApplyExp_SPAN, strm') = ApplyExp_NT(strm')
            val FULL_SPAN = (#1(SR_SPAN), #2(ApplyExp_SPAN))
            in
              (UserCode.MExp_PROD_1_SUBRULE_1_PROD_1_ACT (SR_RES, SelectExp_RES, ApplyExp_RES, SR_SPAN : (Lex.pos * Lex.pos), SelectExp_SPAN : (Lex.pos * Lex.pos), ApplyExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun MExp_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.KW_div, _, strm') => true
              | (Tok.KW_mod, _, strm') => true
              | (Tok.TIMES, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(MExp_PROD_1_SUBRULE_1_PRED, MExp_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(SelectExp_SPAN), #2(SR_SPAN))
      in
        (UserCode.MExp_PROD_1_ACT (SR_RES, SelectExp_RES, SR_SPAN : (Lex.pos * Lex.pos), SelectExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
and ApplyExp_NT (strm) = let
      fun ApplyExp_PROD_1 (strm) = let
            val (AtomicExp_RES, AtomicExp_SPAN, strm') = AtomicExp_NT(strm)
            val (exp_RES, exp_SPAN, strm') = let
            fun ApplyExp_PROD_1_SUBRULE_1_NT (strm) = let
                  fun ApplyExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT (strm) = let
                        val (AtomicExp_RES, AtomicExp_SPAN, strm') = AtomicExp_NT(strm)
                        val FULL_SPAN = (#1(AtomicExp_SPAN),
                          #2(AtomicExp_SPAN))
                        in
                          ((AtomicExp_RES), FULL_SPAN, strm')
                        end
                  fun ApplyExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
                         of (Tok.KW_let, _, strm') => true
                          | (Tok.WITH, _, strm') => true
                          | (Tok.SELECT, _, strm') => true
                          | (Tok.TICK, _, strm') => true
                          | (Tok.LP, _, strm') => true
                          | (Tok.LCB, _, strm') => true
                          | (Tok.ID(_), _, strm') => true
                          | (Tok.CONS(_), _, strm') => true
                          | (Tok.POSINT(_), _, strm') => true
                          | (Tok.NEGINT(_), _, strm') => true
                          | (Tok.STRING(_), _, strm') => true
                          | _ => false
                        (* end case *))
                  val (rhs_RES, rhs_SPAN, strm') = EBNF.closure(ApplyExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PRED, ApplyExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT, strm)
                  val FULL_SPAN = (#1(rhs_SPAN), #2(rhs_SPAN))
                  in
                    (UserCode.ApplyExp_PROD_1_SUBRULE_1_PROD_1_ACT (rhs_RES, AtomicExp_RES, rhs_SPAN : (Lex.pos * Lex.pos), AtomicExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                      FULL_SPAN, strm')
                  end
            in
              ApplyExp_PROD_1_SUBRULE_1_NT(strm')
            end
            val FULL_SPAN = (#1(AtomicExp_SPAN), #2(exp_SPAN))
            in
              (UserCode.ApplyExp_PROD_1_ACT (exp_RES, AtomicExp_RES, exp_SPAN : (Lex.pos * Lex.pos), AtomicExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun ApplyExp_PROD_2 (strm) = let
            val (TILDE_RES, TILDE_SPAN, strm') = matchTILDE(strm)
            val (AtomicExp_RES, AtomicExp_SPAN, strm') = AtomicExp_NT(strm')
            val FULL_SPAN = (#1(TILDE_SPAN), #2(AtomicExp_SPAN))
            in
              (UserCode.ApplyExp_PROD_2_ACT (TILDE_RES, AtomicExp_RES, TILDE_SPAN : (Lex.pos * Lex.pos), AtomicExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.TILDE, _, strm') => ApplyExp_PROD_2(strm)
          | (Tok.KW_let, _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.WITH, _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.SELECT, _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.TICK, _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.LP, _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.LCB, _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.ID(_), _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.CONS(_), _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.POSINT(_), _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.NEGINT(_), _, strm') => ApplyExp_PROD_1(strm)
          | (Tok.STRING(_), _, strm') => ApplyExp_PROD_1(strm)
          | _ => fail()
        (* end case *))
      end
and AtomicExp_NT (strm) = let
      fun AtomicExp_PROD_1 (strm) = let
            val (Lit_RES, Lit_SPAN, strm') = Lit_NT(strm)
            val FULL_SPAN = (#1(Lit_SPAN), #2(Lit_SPAN))
            in
              (UserCode.AtomicExp_PROD_1_ACT (Lit_RES, Lit_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AtomicExp_PROD_2 (strm) = let
            val (Qid_RES, Qid_SPAN, strm') = Qid_NT(strm)
            val FULL_SPAN = (#1(Qid_SPAN), #2(Qid_SPAN))
            in
              (UserCode.AtomicExp_PROD_2_ACT (Qid_RES, Qid_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AtomicExp_PROD_3 (strm) = let
            val (ConUse_RES, ConUse_SPAN, strm') = ConUse_NT(strm)
            val FULL_SPAN = (#1(ConUse_SPAN), #2(ConUse_SPAN))
            in
              (UserCode.AtomicExp_PROD_3_ACT (ConUse_RES, ConUse_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AtomicExp_PROD_4 (strm) = let
            val (WITH_RES, WITH_SPAN, strm') = matchWITH(strm)
            val (LCB_RES, LCB_SPAN, strm') = matchLCB(strm')
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
            fun AtomicExp_PROD_4_SUBRULE_1_NT (strm) = let
                  val (COMMA_RES, COMMA_SPAN, strm') = matchCOMMA(strm)
                  val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
                  val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
                  val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
                  val FULL_SPAN = (#1(COMMA_SPAN), #2(Exp_SPAN))
                  in
                    ((Name_RES, Exp_RES), FULL_SPAN, strm')
                  end
            fun AtomicExp_PROD_4_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.COMMA, _, strm') => true
                    | _ => false
                  (* end case *))
            val (SR_RES, SR_SPAN, strm') = EBNF.closure(AtomicExp_PROD_4_SUBRULE_1_PRED, AtomicExp_PROD_4_SUBRULE_1_NT, strm')
            val (RCB_RES, RCB_SPAN, strm') = matchRCB(strm')
            val FULL_SPAN = (#1(WITH_SPAN), #2(RCB_SPAN))
            in
              (UserCode.AtomicExp_PROD_4_ACT (EQ_RES, SR_RES, Exp_RES, LCB_RES, RCB_RES, Name_RES, WITH_RES, EQ_SPAN : (Lex.pos * Lex.pos), SR_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), WITH_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AtomicExp_PROD_5 (strm) = let
            val (SELECT_RES, SELECT_SPAN, strm') = matchSELECT(strm)
            val (Qid_RES, Qid_SPAN, strm') = Qid_NT(strm')
            val FULL_SPAN = (#1(SELECT_SPAN), #2(Qid_SPAN))
            in
              (UserCode.AtomicExp_PROD_5_ACT (Qid_RES, SELECT_RES, Qid_SPAN : (Lex.pos * Lex.pos), SELECT_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AtomicExp_PROD_6 (strm) = let
            val (LP_RES, LP_SPAN, strm') = matchLP(strm)
            val (RP_RES, RP_SPAN, strm') = matchRP(strm')
            val FULL_SPAN = (#1(LP_SPAN), #2(RP_SPAN))
            in
              (UserCode.AtomicExp_PROD_6_ACT (LP_RES, RP_RES, LP_SPAN : (Lex.pos * Lex.pos), RP_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AtomicExp_PROD_7 (strm) = let
            val (LP_RES, LP_SPAN, strm') = matchLP(strm)
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
            val (RP_RES, RP_SPAN, strm') = matchRP(strm')
            val FULL_SPAN = (#1(LP_SPAN), #2(RP_SPAN))
            in
              (UserCode.AtomicExp_PROD_7_ACT (LP_RES, RP_RES, Exp_RES, LP_SPAN : (Lex.pos * Lex.pos), RP_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AtomicExp_PROD_8 (strm) = let
            val (LCB_RES, LCB_SPAN, strm') = matchLCB(strm)
            val (RCB_RES, RCB_SPAN, strm') = matchRCB(strm')
            val FULL_SPAN = (#1(LCB_SPAN), #2(RCB_SPAN))
            in
              (UserCode.AtomicExp_PROD_8_ACT (LCB_RES, RCB_RES, LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AtomicExp_PROD_9 (strm) = let
            val (LCB_RES, LCB_SPAN, strm') = matchLCB(strm)
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
            fun AtomicExp_PROD_9_SUBRULE_1_NT (strm) = let
                  val (COMMA_RES, COMMA_SPAN, strm') = matchCOMMA(strm)
                  val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
                  val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
                  val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
                  val FULL_SPAN = (#1(COMMA_SPAN), #2(Exp_SPAN))
                  in
                    ((Name_RES, Exp_RES), FULL_SPAN, strm')
                  end
            fun AtomicExp_PROD_9_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.COMMA, _, strm') => true
                    | _ => false
                  (* end case *))
            val (SR_RES, SR_SPAN, strm') = EBNF.closure(AtomicExp_PROD_9_SUBRULE_1_PRED, AtomicExp_PROD_9_SUBRULE_1_NT, strm')
            val (RCB_RES, RCB_SPAN, strm') = matchRCB(strm')
            val FULL_SPAN = (#1(LCB_SPAN), #2(RCB_SPAN))
            in
              (UserCode.AtomicExp_PROD_9_ACT (EQ_RES, SR_RES, Exp_RES, LCB_RES, RCB_RES, Name_RES, EQ_SPAN : (Lex.pos * Lex.pos), SR_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun AtomicExp_PROD_10 (strm) = let
            val (KW_let_RES, KW_let_SPAN, strm') = matchKW_let(strm)
            fun AtomicExp_PROD_10_SUBRULE_1_NT (strm) = let
                  val (ValueDecl_RES, ValueDecl_SPAN, strm') = ValueDecl_NT(strm)
                  val FULL_SPAN = (#1(ValueDecl_SPAN), #2(ValueDecl_SPAN))
                  in
                    ((ValueDecl_RES), FULL_SPAN, strm')
                  end
            fun AtomicExp_PROD_10_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.KW_val, _, strm') => true
                    | _ => false
                  (* end case *))
            val (ValueDecl_RES, ValueDecl_SPAN, strm') = EBNF.posclos(AtomicExp_PROD_10_SUBRULE_1_PRED, AtomicExp_PROD_10_SUBRULE_1_NT, strm')
            val (KW_in_RES, KW_in_SPAN, strm') = matchKW_in(strm')
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
            val (KW_end_RES, KW_end_SPAN, strm') = matchKW_end(strm')
            val FULL_SPAN = (#1(KW_let_SPAN), #2(KW_end_SPAN))
            in
              (UserCode.AtomicExp_PROD_10_ACT (Exp_RES, ValueDecl_RES, KW_in_RES, KW_end_RES, KW_let_RES, Exp_SPAN : (Lex.pos * Lex.pos), ValueDecl_SPAN : (Lex.pos * Lex.pos), KW_in_SPAN : (Lex.pos * Lex.pos), KW_end_SPAN : (Lex.pos * Lex.pos), KW_let_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.KW_let, _, strm') => AtomicExp_PROD_10(strm)
          | (Tok.LCB, _, strm') =>
              (case (lex(strm'))
               of (Tok.RCB, _, strm') => AtomicExp_PROD_8(strm)
                | (Tok.ID(_), _, strm') => AtomicExp_PROD_9(strm)
                | _ => fail()
              (* end case *))
          | (Tok.LP, _, strm') =>
              (case (lex(strm'))
               of (Tok.RP, _, strm') => AtomicExp_PROD_6(strm)
                | (Tok.KW_case, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.KW_do, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.KW_if, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.KW_let, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.WITH, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.SELECT, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.TICK, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.LP, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.LCB, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.TILDE, _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.ID(_), _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.CONS(_), _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.POSINT(_), _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.NEGINT(_), _, strm') => AtomicExp_PROD_7(strm)
                | (Tok.STRING(_), _, strm') => AtomicExp_PROD_7(strm)
                | _ => fail()
              (* end case *))
          | (Tok.WITH, _, strm') => AtomicExp_PROD_4(strm)
          | (Tok.ID(_), _, strm') => AtomicExp_PROD_2(strm)
          | (Tok.TICK, _, strm') => AtomicExp_PROD_1(strm)
          | (Tok.POSINT(_), _, strm') => AtomicExp_PROD_1(strm)
          | (Tok.NEGINT(_), _, strm') => AtomicExp_PROD_1(strm)
          | (Tok.STRING(_), _, strm') => AtomicExp_PROD_1(strm)
          | (Tok.CONS(_), _, strm') => AtomicExp_PROD_3(strm)
          | (Tok.SELECT, _, strm') => AtomicExp_PROD_5(strm)
          | _ => fail()
        (* end case *))
      end
and ValueDecl_NT (strm) = let
      val (KW_val_RES, KW_val_SPAN, strm') = matchKW_val(strm)
      val (Name1_RES, Name1_SPAN, strm') = Name_NT(strm')
      fun ValueDecl_PROD_1_SUBRULE_1_NT (strm) = let
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm)
            val FULL_SPAN = (#1(Name_SPAN), #2(Name_SPAN))
            in
              ((Name_RES), FULL_SPAN, strm')
            end
      fun ValueDecl_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.ID(_), _, strm') => true
              | _ => false
            (* end case *))
      val (Name2_RES, Name2_SPAN, strm') = EBNF.closure(ValueDecl_PROD_1_SUBRULE_1_PRED, ValueDecl_PROD_1_SUBRULE_1_NT, strm')
      val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
      val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
      val FULL_SPAN = (#1(KW_val_SPAN), #2(Exp_SPAN))
      in
        (UserCode.ValueDecl_PROD_1_ACT (EQ_RES, Exp_RES, Name1_RES, Name2_RES, KW_val_RES, EQ_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Name1_SPAN : (Lex.pos * Lex.pos), Name2_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
and SelectExp_NT (strm) = let
      val (ApplyExp_RES, ApplyExp_SPAN, strm') = ApplyExp_NT(strm)
      fun SelectExp_PROD_1_SUBRULE_1_NT (strm) = let
            val (SR_RES, SR_SPAN, strm') = let
            fun SelectExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT (strm) = let
                  val (CONCAT_RES, CONCAT_SPAN, strm') = matchCONCAT(strm)
                  val FULL_SPAN = (#1(CONCAT_SPAN), #2(CONCAT_SPAN))
                  in
                    (UserCode.SelectExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PROD_1_ACT (CONCAT_RES, ApplyExp_RES, CONCAT_SPAN : (Lex.pos * Lex.pos), ApplyExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                      FULL_SPAN, strm')
                  end
            in
              SelectExp_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT(strm)
            end
            val (ApplyExp_RES, ApplyExp_SPAN, strm') = ApplyExp_NT(strm')
            val FULL_SPAN = (#1(SR_SPAN), #2(ApplyExp_SPAN))
            in
              (UserCode.SelectExp_PROD_1_SUBRULE_1_PROD_1_ACT (SR_RES, ApplyExp_RES, SR_SPAN : (Lex.pos * Lex.pos), ApplyExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun SelectExp_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.CONCAT, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(SelectExp_PROD_1_SUBRULE_1_PRED, SelectExp_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(ApplyExp_SPAN), #2(SR_SPAN))
      in
        (UserCode.SelectExp_PROD_1_ACT (SR_RES, ApplyExp_RES, SR_SPAN : (Lex.pos * Lex.pos), ApplyExp_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun TokPat_NT (strm) = let
      fun TokPat_PROD_1 (strm) = let
            val (Int_RES, Int_SPAN, strm') = Int_NT(strm)
            val FULL_SPAN = (#1(Int_SPAN), #2(Int_SPAN))
            in
              (UserCode.TokPat_PROD_1_ACT (Int_RES, Int_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun TokPat_PROD_2 (strm) = let
            val (Qid_RES, Qid_SPAN, strm') = Qid_NT(strm)
            val FULL_SPAN = (#1(Qid_SPAN), #2(Qid_SPAN))
            in
              (UserCode.TokPat_PROD_2_ACT (Qid_RES, Qid_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.ID(_), _, strm') => TokPat_PROD_2(strm)
          | (Tok.POSINT(_), _, strm') => TokPat_PROD_1(strm)
          | (Tok.NEGINT(_), _, strm') => TokPat_PROD_1(strm)
          | _ => fail()
        (* end case *))
      end
fun PrimBitPat_NT (strm) = let
      fun PrimBitPat_PROD_1 (strm) = let
            val (BITSTR_RES, BITSTR_SPAN, strm') = matchBITSTR(strm)
            val FULL_SPAN = (#1(BITSTR_SPAN), #2(BITSTR_SPAN))
            in
              (UserCode.PrimBitPat_PROD_1_ACT (BITSTR_RES, BITSTR_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun PrimBitPat_PROD_2 (strm) = let
            val (Qid_RES, Qid_SPAN, strm') = Qid_NT(strm)
            fun PrimBitPat_PROD_2_SUBRULE_1_NT (strm) = let
                  val (COLON_RES, COLON_SPAN, strm') = matchCOLON(strm)
                  val (POSINT_RES, POSINT_SPAN, strm') = matchPOSINT(strm')
                  val FULL_SPAN = (#1(COLON_SPAN), #2(POSINT_SPAN))
                  in
                    ((POSINT_RES), FULL_SPAN, strm')
                  end
            fun PrimBitPat_PROD_2_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.COLON, _, strm') => true
                    | _ => false
                  (* end case *))
            val (SR_RES, SR_SPAN, strm') = EBNF.optional(PrimBitPat_PROD_2_SUBRULE_1_PRED, PrimBitPat_PROD_2_SUBRULE_1_NT, strm')
            val FULL_SPAN = (#1(Qid_SPAN), #2(SR_SPAN))
            in
              (UserCode.PrimBitPat_PROD_2_ACT (SR_RES, Qid_RES, SR_SPAN : (Lex.pos * Lex.pos), Qid_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.ID(_), _, strm') => PrimBitPat_PROD_2(strm)
          | (Tok.BITSTR(_), _, strm') => PrimBitPat_PROD_1(strm)
          | _ => fail()
        (* end case *))
      end
fun BitPat_NT (strm) = let
      val (TICK1_RES, TICK1_SPAN, strm') = matchTICK(strm)
      fun BitPat_PROD_1_SUBRULE_1_NT (strm) = let
            val (PrimBitPat_RES, PrimBitPat_SPAN, strm') = PrimBitPat_NT(strm)
            val FULL_SPAN = (#1(PrimBitPat_SPAN), #2(PrimBitPat_SPAN))
            in
              ((PrimBitPat_RES), FULL_SPAN, strm')
            end
      fun BitPat_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.BITSTR(_), _, strm') => true
              | (Tok.ID(_), _, strm') => true
              | _ => false
            (* end case *))
      val (PrimBitPat_RES, PrimBitPat_SPAN, strm') = EBNF.posclos(BitPat_PROD_1_SUBRULE_1_PRED, BitPat_PROD_1_SUBRULE_1_NT, strm')
      val (TICK2_RES, TICK2_SPAN, strm') = matchTICK(strm')
      val FULL_SPAN = (#1(TICK1_SPAN), #2(TICK2_SPAN))
      in
        (UserCode.BitPat_PROD_1_ACT (PrimBitPat_RES, TICK1_RES, TICK2_RES, PrimBitPat_SPAN : (Lex.pos * Lex.pos), TICK1_SPAN : (Lex.pos * Lex.pos), TICK2_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun DecodePat_NT (strm) = let
      fun DecodePat_PROD_1 (strm) = let
            val (BitPat_RES, BitPat_SPAN, strm') = BitPat_NT(strm)
            val FULL_SPAN = (#1(BitPat_SPAN), #2(BitPat_SPAN))
            in
              (UserCode.DecodePat_PROD_1_ACT (BitPat_RES, BitPat_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun DecodePat_PROD_2 (strm) = let
            val (TokPat_RES, TokPat_SPAN, strm') = TokPat_NT(strm)
            val FULL_SPAN = (#1(TokPat_SPAN), #2(TokPat_SPAN))
            in
              (UserCode.DecodePat_PROD_2_ACT (TokPat_RES, TokPat_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.ID(_), _, strm') => DecodePat_PROD_2(strm)
          | (Tok.POSINT(_), _, strm') => DecodePat_PROD_2(strm)
          | (Tok.NEGINT(_), _, strm') => DecodePat_PROD_2(strm)
          | (Tok.TICK, _, strm') => DecodePat_PROD_1(strm)
          | _ => fail()
        (* end case *))
      end
fun Ty_NT (strm) = let
      fun Ty_PROD_1 (strm) = let
            val (Int_RES, Int_SPAN, strm') = Int_NT(strm)
            val FULL_SPAN = (#1(Int_SPAN), #2(Int_SPAN))
            in
              (UserCode.Ty_PROD_1_ACT (Int_RES, Int_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Ty_PROD_2 (strm) = let
            val (Qid_RES, Qid_SPAN, strm') = Qid_NT(strm)
            val FULL_SPAN = (#1(Qid_SPAN), #2(Qid_SPAN))
            in
              (UserCode.Ty_PROD_2_ACT (Qid_RES, Qid_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Ty_PROD_3 (strm) = let
            val (LCB_RES, LCB_SPAN, strm') = matchLCB(strm)
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
            val (COLON_RES, COLON_SPAN, strm') = matchCOLON(strm')
            val (Ty_RES, Ty_SPAN, strm') = Ty_NT(strm')
            fun Ty_PROD_3_SUBRULE_1_NT (strm) = let
                  val (COMMA_RES, COMMA_SPAN, strm') = matchCOMMA(strm)
                  val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
                  val (COLON_RES, COLON_SPAN, strm') = matchCOLON(strm')
                  val (Ty_RES, Ty_SPAN, strm') = Ty_NT(strm')
                  val FULL_SPAN = (#1(COMMA_SPAN), #2(Ty_SPAN))
                  in
                    ((Name_RES, Ty_RES), FULL_SPAN, strm')
                  end
            fun Ty_PROD_3_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.COMMA, _, strm') => true
                    | _ => false
                  (* end case *))
            val (SR_RES, SR_SPAN, strm') = EBNF.closure(Ty_PROD_3_SUBRULE_1_PRED, Ty_PROD_3_SUBRULE_1_NT, strm')
            val (RCB_RES, RCB_SPAN, strm') = matchRCB(strm')
            val FULL_SPAN = (#1(LCB_SPAN), #2(RCB_SPAN))
            in
              (UserCode.Ty_PROD_3_ACT (SR_RES, Ty_RES, LCB_RES, RCB_RES, Name_RES, COLON_RES, SR_SPAN : (Lex.pos * Lex.pos), Ty_SPAN : (Lex.pos * Lex.pos), LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), COLON_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.LCB, _, strm') => Ty_PROD_3(strm)
          | (Tok.POSINT(_), _, strm') => Ty_PROD_1(strm)
          | (Tok.NEGINT(_), _, strm') => Ty_PROD_1(strm)
          | (Tok.ID(_), _, strm') => Ty_PROD_2(strm)
          | _ => fail()
        (* end case *))
      end
fun ConBind_NT (strm) = let
      val (CONS_RES, CONS_SPAN, strm') = matchCONS(strm)
      val FULL_SPAN = (#1(CONS_SPAN), #2(CONS_SPAN))
      in
        (UserCode.ConBind_PROD_1_ACT (CONS_RES, CONS_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun ConDecl_NT (strm) = let
      val (ConBind_RES, ConBind_SPAN, strm') = ConBind_NT(strm)
      fun ConDecl_PROD_1_SUBRULE_1_NT (strm) = let
            val (KW_of_RES, KW_of_SPAN, strm') = matchKW_of(strm)
            val (Ty_RES, Ty_SPAN, strm') = Ty_NT(strm')
            val FULL_SPAN = (#1(KW_of_SPAN), #2(Ty_SPAN))
            in
              ((Ty_RES), FULL_SPAN, strm')
            end
      fun ConDecl_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.KW_of, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.optional(ConDecl_PROD_1_SUBRULE_1_PRED, ConDecl_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(ConBind_SPAN), #2(SR_SPAN))
      in
        (UserCode.ConDecl_PROD_1_ACT (SR_RES, ConBind_RES, SR_SPAN : (Lex.pos * Lex.pos), ConBind_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun ConDecls_NT (strm) = let
      val (ConDecl_RES, ConDecl_SPAN, strm') = ConDecl_NT(strm)
      fun ConDecls_PROD_1_SUBRULE_1_NT (strm) = let
            val (BAR_RES, BAR_SPAN, strm') = matchBAR(strm)
            val (ConDecl_RES, ConDecl_SPAN, strm') = ConDecl_NT(strm')
            val FULL_SPAN = (#1(BAR_SPAN), #2(ConDecl_SPAN))
            in
              ((ConDecl_RES), FULL_SPAN, strm')
            end
      fun ConDecls_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.BAR, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(ConDecls_PROD_1_SUBRULE_1_PRED, ConDecls_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(ConDecl_SPAN), #2(SR_SPAN))
      in
        (UserCode.ConDecls_PROD_1_ACT (SR_RES, ConDecl_RES, SR_SPAN : (Lex.pos * Lex.pos), ConDecl_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun StateTy_NT (strm) = let
      val (LCB_RES, LCB_SPAN, strm') = matchLCB(strm)
      val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
      val (COLON_RES, COLON_SPAN, strm') = matchCOLON(strm')
      val (Ty_RES, Ty_SPAN, strm') = Ty_NT(strm')
      val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
      val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
      fun StateTy_PROD_1_SUBRULE_1_NT (strm) = let
            val (COMMA_RES, COMMA_SPAN, strm') = matchCOMMA(strm)
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
            val (COLON_RES, COLON_SPAN, strm') = matchCOLON(strm')
            val (Ty_RES, Ty_SPAN, strm') = Ty_NT(strm')
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
            val FULL_SPAN = (#1(COMMA_SPAN), #2(Exp_SPAN))
            in
              ((Name_RES, Ty_RES, Exp_RES), FULL_SPAN, strm')
            end
      fun StateTy_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.COMMA, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(StateTy_PROD_1_SUBRULE_1_PRED, StateTy_PROD_1_SUBRULE_1_NT, strm')
      val (RCB_RES, RCB_SPAN, strm') = matchRCB(strm')
      val FULL_SPAN = (#1(LCB_SPAN), #2(RCB_SPAN))
      in
        (UserCode.StateTy_PROD_1_ACT (EQ_RES, SR_RES, Ty_RES, Exp_RES, LCB_RES, RCB_RES, Name_RES, COLON_RES, EQ_SPAN : (Lex.pos * Lex.pos), SR_SPAN : (Lex.pos * Lex.pos), Ty_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), LCB_SPAN : (Lex.pos * Lex.pos), RCB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), COLON_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
fun Decl_NT (strm) = let
      fun Decl_PROD_1 (strm) = let
            val (KW_granularity_RES, KW_granularity_SPAN, strm') = matchKW_granularity(strm)
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            val (Int_RES, Int_SPAN, strm') = Int_NT(strm')
            val FULL_SPAN = (#1(KW_granularity_SPAN), #2(Int_SPAN))
            in
              (UserCode.Decl_PROD_1_ACT (EQ_RES, Int_RES, KW_granularity_RES, EQ_SPAN : (Lex.pos * Lex.pos), Int_SPAN : (Lex.pos * Lex.pos), KW_granularity_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Decl_PROD_2 (strm) = let
            val (KW_export_RES, KW_export_SPAN, strm') = matchKW_export(strm)
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            fun Decl_PROD_2_SUBRULE_1_NT (strm) = let
                  val (Qid_RES, Qid_SPAN, strm') = Qid_NT(strm)
                  val FULL_SPAN = (#1(Qid_SPAN), #2(Qid_SPAN))
                  in
                    ((Qid_RES), FULL_SPAN, strm')
                  end
            fun Decl_PROD_2_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.ID(_), _, strm') => true
                    | _ => false
                  (* end case *))
            val (Qid_RES, Qid_SPAN, strm') = EBNF.closure(Decl_PROD_2_SUBRULE_1_PRED, Decl_PROD_2_SUBRULE_1_NT, strm')
            val FULL_SPAN = (#1(KW_export_SPAN), #2(Qid_SPAN))
            in
              (UserCode.Decl_PROD_2_ACT (EQ_RES, Qid_RES, KW_export_RES, EQ_SPAN : (Lex.pos * Lex.pos), Qid_SPAN : (Lex.pos * Lex.pos), KW_export_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Decl_PROD_3 (strm) = let
            val (KW_include_RES, KW_include_SPAN, strm') = matchKW_include(strm)
            val (STRING_RES, STRING_SPAN, strm') = matchSTRING(strm')
            val FULL_SPAN = (#1(KW_include_SPAN), #2(STRING_SPAN))
            in
              (UserCode.Decl_PROD_3_ACT (STRING_RES, KW_include_RES, STRING_SPAN : (Lex.pos * Lex.pos), KW_include_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Decl_PROD_4 (strm) = let
            val (KW_state_RES, KW_state_SPAN, strm') = matchKW_state(strm)
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            val (StateTy_RES, StateTy_SPAN, strm') = StateTy_NT(strm')
            val FULL_SPAN = (#1(KW_state_SPAN), #2(StateTy_SPAN))
            in
              (UserCode.Decl_PROD_4_ACT (EQ_RES, KW_state_RES, StateTy_RES, EQ_SPAN : (Lex.pos * Lex.pos), KW_state_SPAN : (Lex.pos * Lex.pos), StateTy_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Decl_PROD_5 (strm) = let
            val (KW_datatype_RES, KW_datatype_SPAN, strm') = matchKW_datatype(strm)
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            val (ConDecls_RES, ConDecls_SPAN, strm') = ConDecls_NT(strm')
            val FULL_SPAN = (#1(KW_datatype_SPAN), #2(ConDecls_SPAN))
            in
              (UserCode.Decl_PROD_5_ACT (EQ_RES, Name_RES, KW_datatype_RES, ConDecls_RES, EQ_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), KW_datatype_SPAN : (Lex.pos * Lex.pos), ConDecls_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Decl_PROD_6 (strm) = let
            val (KW_type_RES, KW_type_SPAN, strm') = matchKW_type(strm)
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            val (Ty_RES, Ty_SPAN, strm') = Ty_NT(strm')
            val FULL_SPAN = (#1(KW_type_SPAN), #2(Ty_SPAN))
            in
              (UserCode.Decl_PROD_6_ACT (EQ_RES, Ty_RES, Name_RES, KW_type_RES, EQ_SPAN : (Lex.pos * Lex.pos), Ty_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), KW_type_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Decl_PROD_7 (strm) = let
            val (KW_val_RES, KW_val_SPAN, strm') = matchKW_val(strm)
            val (Name1_RES, Name1_SPAN, strm') = Name_NT(strm')
            fun Decl_PROD_7_SUBRULE_1_NT (strm) = let
                  val (Name_RES, Name_SPAN, strm') = Name_NT(strm)
                  val FULL_SPAN = (#1(Name_SPAN), #2(Name_SPAN))
                  in
                    ((Name_RES), FULL_SPAN, strm')
                  end
            fun Decl_PROD_7_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.ID(_), _, strm') => true
                    | _ => false
                  (* end case *))
            val (Name2_RES, Name2_SPAN, strm') = EBNF.closure(Decl_PROD_7_SUBRULE_1_PRED, Decl_PROD_7_SUBRULE_1_NT, strm')
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
            val FULL_SPAN = (#1(KW_val_SPAN), #2(Exp_SPAN))
            in
              (UserCode.Decl_PROD_7_ACT (EQ_RES, Exp_RES, Name1_RES, Name2_RES, KW_val_RES, EQ_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Name1_SPAN : (Lex.pos * Lex.pos), Name2_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Decl_PROD_8 (strm) = let
            val (KW_val_RES, KW_val_SPAN, strm') = matchKW_val(strm)
            val (Sym_RES, Sym_SPAN, strm') = Sym_NT(strm')
            fun Decl_PROD_8_SUBRULE_1_NT (strm) = let
                  val (Name_RES, Name_SPAN, strm') = Name_NT(strm)
                  val FULL_SPAN = (#1(Name_SPAN), #2(Name_SPAN))
                  in
                    ((Name_RES), FULL_SPAN, strm')
                  end
            fun Decl_PROD_8_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.ID(_), _, strm') => true
                    | _ => false
                  (* end case *))
            val (Name_RES, Name_SPAN, strm') = EBNF.closure(Decl_PROD_8_SUBRULE_1_PRED, Decl_PROD_8_SUBRULE_1_NT, strm')
            val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
            val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
            val FULL_SPAN = (#1(KW_val_SPAN), #2(Exp_SPAN))
            in
              (UserCode.Decl_PROD_8_ACT (EQ_RES, Exp_RES, Sym_RES, Name_RES, KW_val_RES, EQ_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Sym_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      fun Decl_PROD_9 (strm) = let
            val (KW_val_RES, KW_val_SPAN, strm') = matchKW_val(strm)
            val (Name_RES, Name_SPAN, strm') = Name_NT(strm')
            val (LB_RES, LB_SPAN, strm') = matchLB(strm')
            fun Decl_PROD_9_SUBRULE_1_NT (strm) = let
                  val (DecodePat_RES, DecodePat_SPAN, strm') = DecodePat_NT(strm)
                  val FULL_SPAN = (#1(DecodePat_SPAN), #2(DecodePat_SPAN))
                  in
                    ((DecodePat_RES), FULL_SPAN, strm')
                  end
            fun Decl_PROD_9_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.TICK, _, strm') => true
                    | (Tok.ID(_), _, strm') => true
                    | (Tok.POSINT(_), _, strm') => true
                    | (Tok.NEGINT(_), _, strm') => true
                    | _ => false
                  (* end case *))
            val (DecodePat_RES, DecodePat_SPAN, strm') = EBNF.closure(Decl_PROD_9_SUBRULE_1_PRED, Decl_PROD_9_SUBRULE_1_NT, strm')
            val (RB_RES, RB_SPAN, strm') = matchRB(strm')
            val (decl_RES, decl_SPAN, strm') = let
            fun Decl_PROD_9_SUBRULE_2_NT (strm) = let
                  fun Decl_PROD_9_SUBRULE_2_PROD_1 (strm) = let
                        val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm)
                        val (Exp_RES, Exp_SPAN, strm') = Exp_NT(strm')
                        val FULL_SPAN = (#1(EQ_SPAN), #2(Exp_SPAN))
                        in
                          (UserCode.Decl_PROD_9_SUBRULE_2_PROD_1_ACT (EQ_RES, LB_RES, RB_RES, Exp_RES, Name_RES, DecodePat_RES, KW_val_RES, EQ_SPAN : (Lex.pos * Lex.pos), LB_SPAN : (Lex.pos * Lex.pos), RB_SPAN : (Lex.pos * Lex.pos), Exp_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), DecodePat_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                            FULL_SPAN, strm')
                        end
                  fun Decl_PROD_9_SUBRULE_2_PROD_2 (strm) = let
                        fun Decl_PROD_9_SUBRULE_2_PROD_2_SUBRULE_1_NT (strm) = let
                              val (BAR_RES, BAR_SPAN, strm') = matchBAR(strm)
                              val (Exp1_RES, Exp1_SPAN, strm') = Exp_NT(strm')
                              val (EQ_RES, EQ_SPAN, strm') = matchEQ(strm')
                              val (Exp2_RES, Exp2_SPAN, strm') = Exp_NT(strm')
                              val FULL_SPAN = (#1(BAR_SPAN), #2(Exp2_SPAN))
                              in
                                ((Exp1_RES, Exp2_RES), FULL_SPAN, strm')
                              end
                        fun Decl_PROD_9_SUBRULE_2_PROD_2_SUBRULE_1_PRED (strm) = (case (lex(strm))
                               of (Tok.BAR, _, strm') => true
                                | _ => false
                              (* end case *))
                        val (SR_RES, SR_SPAN, strm') = EBNF.posclos(Decl_PROD_9_SUBRULE_2_PROD_2_SUBRULE_1_PRED, Decl_PROD_9_SUBRULE_2_PROD_2_SUBRULE_1_NT, strm)
                        val FULL_SPAN = (#1(SR_SPAN), #2(SR_SPAN))
                        in
                          (UserCode.Decl_PROD_9_SUBRULE_2_PROD_2_ACT (LB_RES, RB_RES, SR_RES, Name_RES, DecodePat_RES, KW_val_RES, LB_SPAN : (Lex.pos * Lex.pos), RB_SPAN : (Lex.pos * Lex.pos), SR_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), DecodePat_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                            FULL_SPAN, strm')
                        end
                  in
                    (case (lex(strm))
                     of (Tok.BAR, _, strm') =>
                          Decl_PROD_9_SUBRULE_2_PROD_2(strm)
                      | (Tok.EQ, _, strm') =>
                          Decl_PROD_9_SUBRULE_2_PROD_1(strm)
                      | _ => fail()
                    (* end case *))
                  end
            in
              Decl_PROD_9_SUBRULE_2_NT(strm')
            end
            val FULL_SPAN = (#1(KW_val_SPAN), #2(decl_SPAN))
            in
              (UserCode.Decl_PROD_9_ACT (LB_RES, RB_RES, Name_RES, decl_RES, DecodePat_RES, KW_val_RES, LB_SPAN : (Lex.pos * Lex.pos), RB_SPAN : (Lex.pos * Lex.pos), Name_SPAN : (Lex.pos * Lex.pos), decl_SPAN : (Lex.pos * Lex.pos), DecodePat_SPAN : (Lex.pos * Lex.pos), KW_val_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
                FULL_SPAN, strm')
            end
      in
        (case (lex(strm))
         of (Tok.KW_val, _, strm') =>
              (case (lex(strm'))
               of (Tok.ID(_), _, strm') =>
                    (case (lex(strm'))
                     of (Tok.LB, _, strm') => Decl_PROD_9(strm)
                      | (Tok.EQ, _, strm') => Decl_PROD_7(strm)
                      | (Tok.ID(_), _, strm') => Decl_PROD_7(strm)
                      | _ => fail()
                    (* end case *))
                | (Tok.SYMBOL(_), _, strm') => Decl_PROD_8(strm)
                | _ => fail()
              (* end case *))
          | (Tok.KW_datatype, _, strm') => Decl_PROD_5(strm)
          | (Tok.KW_include, _, strm') => Decl_PROD_3(strm)
          | (Tok.KW_granularity, _, strm') => Decl_PROD_1(strm)
          | (Tok.KW_export, _, strm') => Decl_PROD_2(strm)
          | (Tok.KW_state, _, strm') => Decl_PROD_4(strm)
          | (Tok.KW_type, _, strm') => Decl_PROD_6(strm)
          | _ => fail()
        (* end case *))
      end
fun Program_NT (strm) = let
      val (Decl_RES, Decl_SPAN, strm') = Decl_NT(strm)
      fun Program_PROD_1_SUBRULE_1_NT (strm) = let
            fun Program_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT (strm) = let
                  val (SEMI_RES, SEMI_SPAN, strm') = matchSEMI(strm)
                  val FULL_SPAN = (#1(SEMI_SPAN), #2(SEMI_SPAN))
                  in
                    ((), FULL_SPAN, strm')
                  end
            fun Program_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
                   of (Tok.SEMI, _, strm') => true
                    | _ => false
                  (* end case *))
            val (SEMI_RES, SEMI_SPAN, strm') = EBNF.optional(Program_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_PRED, Program_PROD_1_SUBRULE_1_PROD_1_SUBRULE_1_NT, strm)
            val (Decl_RES, Decl_SPAN, strm') = Decl_NT(strm')
            val FULL_SPAN = (#1(SEMI_SPAN), #2(Decl_SPAN))
            in
              ((Decl_RES), FULL_SPAN, strm')
            end
      fun Program_PROD_1_SUBRULE_1_PRED (strm) = (case (lex(strm))
             of (Tok.KW_datatype, _, strm') => true
              | (Tok.KW_include, _, strm') => true
              | (Tok.KW_export, _, strm') => true
              | (Tok.KW_val, _, strm') => true
              | (Tok.KW_granularity, _, strm') => true
              | (Tok.KW_state, _, strm') => true
              | (Tok.KW_type, _, strm') => true
              | (Tok.SEMI, _, strm') => true
              | _ => false
            (* end case *))
      val (SR_RES, SR_SPAN, strm') = EBNF.closure(Program_PROD_1_SUBRULE_1_PRED, Program_PROD_1_SUBRULE_1_NT, strm')
      val FULL_SPAN = (#1(Decl_SPAN), #2(SR_SPAN))
      in
        (UserCode.Program_PROD_1_ACT (SR_RES, Decl_RES, SR_SPAN : (Lex.pos * Lex.pos), Decl_SPAN : (Lex.pos * Lex.pos), FULL_SPAN : (Lex.pos * Lex.pos)),
          FULL_SPAN, strm')
      end
in
  (Program_NT)
end
val Program_NT =  fn s => unwrap (Err.launch (eh, lexFn, Program_NT , true) s)

in (Program_NT) end
  in
fun parse lexFn  s = let val (Program_NT) = mk lexFn in Program_NT s end

  end

end
