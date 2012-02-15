
%name Spec;

%tokens
   : KW_andalso ("andalso")
   | KW_case ("case")
   | KW_in ("in")
   | KW_do ("do")
   | KW_datatype ("datatype")
   | KW_decode ("decode")
   | KW_include ("include")
   | KW_extend ("extend")
   | KW_div ("div")
   | KW_else ("else")
   | KW_end ("end")
   | KW_if ("if")
   | KW_let ("let")
   | KW_val ("val")
   | KW_rec ("rec")
   | KW_mod ("%")
   | KW_of ("of")
   | KW_orelse ("orelse")
   | KW_granularity ("granularity")
   | KW_raise ("raise")
   | KW_state ("state")
   | KW_then ("then")
   | KW_type ("type")
   | BIND ("<-")
   | EQ ("=")
   | TICK ("'")
   | DOT (".")
   | LP ("(")
   | RP (")")
   | LB ("[")
   | RB ("]")
   | LCB ("{")
   | RCB ("}")
   | CONCAT ("^")
   | PLUS ("+")
   | MINUS ("-")
   | TIMES ("*")
   | SLASH ("/")
   | TILDE ("~")
   | COMMA (",")
   | SEMI (";")
   | BAR ("|")
   | COLON (":")
   | WILD ("_")
   | BITSTR of string
   | TYVAR of Atom.atom
   | ID of Atom.atom
   | POSINT of IntInf.int (* positive integer *)
   | NEGINT of IntInf.int (* negative integer *)
   | FLOAT of FloatLit.float
   | STRING of string
   | SYMBOL of Atom.atom
   ;

%defs (
   structure PT = SpecParseTree

   (* apply a mark constructor to a span and a tree *)
   fun mark cons (span : AntlrStreamPos.span, tr) = cons{span = span, tree = tr}

   (* specialize mark functions for common node types *)
   val markDecl = mark PT.MARKdecl
   fun markExp (_, e as PT.MARKexp _) = e
     | markExp (sp, tr) = mark PT.MARKexp (sp, tr)
   val markMatch = mark PT.MARKmatch
   fun markPat (_, p as PT.MARKpat _) = p
     | markPat (sp, tr) = mark PT.MARKpat (sp, tr)

   (* construct conditional expressions for a list of expressions *)
   fun mkCondExp con = let
      fun mk (e, []) = e
        | mk (e, e'::r) = mk (con(e', e), r)
   in
      mk
   end

   (* build an application for an infix binary operator *)
   fun mkBinApp (e1, rator, e2) = PT.BINARYexp(e1, rator, e2)

   (* construct application expressions for left-associative binary operators *)
   fun mkLBinExp (e, []) = e
     | mkLBinExp (e, (id, e')::r) = mkLBinExp (mkBinApp(e, id, e'), r)

   (* construct application expressions for right-associative binary operators *)
   fun mkRBinExp (e, []) = e
     | mkRBinExp (e, [(id, e')]) = mkBinApp(e, id, e')
     | mkRBinExp (e, (id, e')::r) = mkBinApp(e, id, mkRBinExp(e', r))

   (* turn a list of expressions into a tree of applications; remember that
    * application associates to the left. *)
   fun mkApply (e, []) = e
     | mkApply (e, e'::r) = mkApply (PT.APPLYexp(e, e'), r)
);

Program
   : Decl (";"? Decl)* =>
      ({span=FULL_SPAN, tree=Decl::SR})
   ;

Decl
   : "granularity" "=" Int => (markDecl (FULL_SPAN, PT.GRANULARITYdecl Int))
   | "include" STRING => (markDecl (FULL_SPAN, PT.INCLUDEdecl STRING))
   | "state" "=" StateTy => (markDecl (FULL_SPAN, PT.STATEdecl StateTy))
   | "datatype" Name "=" ConDecls => (markDecl (FULL_SPAN, PT.DATATYPEdecl (Name, ConDecls)))
   | "type" Name "=" Ty => (markDecl (FULL_SPAN, PT.TYPEdecl (Name, Ty)))
   | "decode" "[" DecodePat+ "]" pat=
      ( "=" Exp =>
         (mark PT.MARKdecodedecl (FULL_SPAN, PT.DECODEdecodedecl (DecodePat, Exp)))
      | ("|" Exp "=" Exp)+ =>
         (mark PT.MARKdecodedecl (FULL_SPAN, PT.GUARDEDdecodedecl (DecodePat, SR)))) =>
      (markDecl (FULL_SPAN, PT.DECODEdecl pat))
   | "val" Name decl=
      ( "[" DecodePat+ "]" "=" Exp =>
         (PT.DECODEdecl (mark PT.MARKdecodedecl (FULL_SPAN, PT.NAMEDdecodedecl (Name, DecodePat, Exp))))
      | args=Name* "=" Exp =>
         (PT.VALUEdecl (mark PT.MARKvaluedecl (FULL_SPAN, PT.LETvaluedecl (Name, args, Exp))))) =>
      (markDecl (FULL_SPAN, decl))
   ;

StateTy
   : "{" Name ":" Ty "=" Exp ("," Name ":" Ty "=" Exp)* "}" =>
      ((Name, Ty, Exp)::SR)
   ;

ConDecls
   : ConDecl ("|" ConDecl)* => (ConDecl::SR)
   ;

ConDecl
   : Name ("of" Ty)? => (mark PT.MARKcondecl (FULL_SPAN, PT.CONdecl (Name, SR)))
   ;

Ty
   : Int => (mark PT.MARKty (FULL_SPAN, PT.BITty Int))
   | Qid => (mark PT.MARKty (FULL_SPAN, PT.NAMEDty Qid))
   | "{" Name ":" Ty ("," Name ":" Ty)* "}" =>
      (mark PT.MARKty (FULL_SPAN, PT.RECty ((Name, Ty)::SR)))
   ;

DecodePat
   : BitPat => (BitPat)
   | TokPat => (mark PT.MARKdecodepat (FULL_SPAN, PT.TOKENdecodepat TokPat))
   ;

BitPat
   : "'" PrimBitPat+ "'" =>
      (mark PT.MARKdecodepat (FULL_SPAN, PT.BITdecodepat PrimBitPat))
   ;

TokPat
   : Int => (mark PT.MARKtokpat (FULL_SPAN, PT.TOKtokpat Int))
   | Name => (mark PT.MARKtokpat (FULL_SPAN, PT.NAMEDtokpat Name))
   ;

PrimBitPat
   : BITSTR => (mark PT.MARKbitpat (FULL_SPAN, PT.BITSTRbitpat BITSTR))
   | Name (":" POSINT)? =>
      (mark
         PT.MARKbitpat
         (FULL_SPAN,
          case SR of
             NONE => PT.NAMEDbitpat Name
           | SOME i => PT.BITVECbitpat (Name, i)))
   ;

Exp
   : ClosedExp => (ClosedExp)
   | "case" ClosedExp "of" Cases =>
      (mark PT.MARKexp (FULL_SPAN, PT.CASEexp (ClosedExp, Cases)))
   ;

ClosedExp
   : OrElseExp
   | "if" Exp "then" Exp "else" Exp =>
      (mark PT.MARKexp (FULL_SPAN, PT.IFexp (Exp1, Exp2, Exp3)))
   | "raise" Exp =>
      (mark PT.MARKexp (FULL_SPAN, PT.RAISEexp Exp))
   | "do" MonadicExp (";" MonadicExp)* "end" =>
      (mark PT.MARKexp (FULL_SPAN, PT.SEQexp SR))
   ;

MonadicExp
   : Exp =>
      (mark PT.MARKseqexp (FULL_SPAN, PT.ACTIONseqexp Exp))
   | Name "<-" Exp =>
      (mark PT.MARKseqexp (FULL_SPAN, PT.BINDseqexp (Name, Exp)))
   ;

(* HACK *)
Cases
   : %try Pat ":" ClosedExp "|" Cases =>
      (mark PT.MARKmatch (Pat_SPAN, PT.CASEmatch ((Pat, ClosedExp)))::Cases)
   | %try Pat ":" ClosedExp =>
      ([mark PT.MARKmatch (FULL_SPAN, PT.CASEmatch (Pat, ClosedExp))])
   ;

Pat
   : "'" BITSTR "'" => (mark PT.MARKpat (FULL_SPAN, PT.BITpat BITSTR))
   | "_" => (mark PT.MARKpat (FULL_SPAN, PT.WILDpat))
   | Lit => (mark PT.MARKpat (FULL_SPAN, PT.LITpat Lit))
   | Name => (mark PT.MARKpat (FULL_SPAN, PT.IDpat {span=FULL_SPAN, tree=Name}))
   ;

OrElseExp
   : AndAlsoExp ("orelse" AndAlsoExp)* =>
      (mark PT.MARKexp (FULL_SPAN, mkCondExp PT.ORELSEexp (AndAlsoExp, SR)))
   ;

AndAlsoExp
   : RExp ("andalso" RExp)* =>
      (mark PT.MARKexp (FULL_SPAN, mkCondExp PT.ANDALSOexp (RExp, SR)))
   ;

RExp
   : AExp (Sym AExp)* =>
      (mark PT.MARKexp (FULL_SPAN, mkLBinExp(AExp, SR)))
   ;

AExp
   : MExp (( "+" => (Op.plus) | "-" => (Op.minus)) MExp => (SR, MExp))* =>
      (mark PT.MARKexp (FULL_SPAN, mkLBinExp (MExp, SR)))
   ;

MExp
   : SelectExp
      (( "*" => (Op.times)
       | "div" => (Op.div)
       | "%" => (Op.mod)) ApplyExp =>
      (SR, SelectExp))* =>
         (mark PT.MARKexp (FULL_SPAN, mkLBinExp (SelectExp, SR)))
   ;

SelectExp
   : ApplyExp (("^" => (Op.concat)) ApplyExp => (SR, ApplyExp))* =>
      (mark PT.MARKexp (FULL_SPAN, mkLBinExp (ApplyExp, SR)))
   ;

ApplyExp
   : AtomicExp exp=
      ( rhs=AtomicExp* => (mkApply(AtomicExp, rhs))
      | "." Name => (PT.SELECTexp (AtomicExp, Name))) =>
         (mark PT.MARKexp (FULL_SPAN, exp))
   | "~" AtomicExp =>
      (mark PT.MARKexp (FULL_SPAN, PT.APPLYexp (PT.IDexp {span=FULL_SPAN, tree=Op.uminus}, AtomicExp)))
   ;

AtomicExp
   : Lit => (mark PT.MARKexp (FULL_SPAN, PT.LITexp Lit))
   | Qid => (mark PT.MARKexp (FULL_SPAN, PT.IDexp Qid))
   | "(" ")" => (mark PT.MARKexp (FULL_SPAN, PT.RECORDexp []))
   | "(" Exp ")" => (Exp)
   | "{" Name "=" Exp ("," Name "=" Exp)* "}" =>
      (mark PT.MARKexp (FULL_SPAN, PT.RECORDexp ((Name, Exp)::SR)))
   | "let" ValueDecl+ "in" Exp "end" =>
      (mark PT.MARKexp (FULL_SPAN, PT.LETexp (ValueDecl, Exp)))
   ;

ValueDecl
   : "val" Name Name* "=" Exp =>
      (mark PT.MARKvaluedecl (FULL_SPAN, PT.LETvaluedecl (Name1, Name2, Exp)))
   ;

Lit
   : Int => (PT.INTlit Int)
   | STRING => (PT.STRlit STRING)
   ;

Int
   : POSINT => (POSINT)
   | NEGINT => (NEGINT)
   ;

Name
   : ID => (ID)
   ;

Sym
   : SYMBOL => (SYMBOL)
   ;

Qid
   : ID => ({span=FULL_SPAN, tree=ID})
   ;
