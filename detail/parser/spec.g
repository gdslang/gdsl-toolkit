
%name Spec;

%tokens
   : KW_case ("case")
   | KW_in ("in")
   | KW_do ("do")
   | KW_datatype ("datatype")
   | KW_include ("include")
   | KW_export ("export")
   | KW_div ("div")
   | KW_else ("else")
   | KW_end ("end")
   | KW_if ("if")
   | KW_let ("let")
   | KW_val ("val")
   | KW_mod ("%")
   | KW_of ("of")
   | KW_granularity ("granularity")
   | KW_raise ("raise")
   | KW_then ("then")
   | KW_type ("type")
   | KW_and ("and")
   | KW_or ("or")
   | WITH ("@")
   | SELECT ("$")
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
   | CONS of Atom.atom
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
   | "export" "=" Qid* => (markDecl (FULL_SPAN, PT.EXPORTdecl Qid))
   | "include" STRING => (markDecl (FULL_SPAN, PT.INCLUDEdecl STRING))
   | "datatype" Name "=" ConDecls =>
      (markDecl (FULL_SPAN, PT.DATATYPEdecl (Name, ConDecls)))
   | "type" Name "=" Ty => (markDecl (FULL_SPAN, PT.TYPEdecl (Name, Ty)))
   | "val" Name Name* "=" Exp =>
      (markDecl (FULL_SPAN, PT.LETRECdecl (Name1, Name2, Exp)))
   | "val" Sym Name* "=" Exp =>
      (markDecl (FULL_SPAN, PT.LETRECdecl (Sym, Name, Exp)))
   | "val" Name "[" DecodePat* "]" decl=
      ( "=" Exp =>
         (PT.DECODEdecl (Name, DecodePat, Sum.INL Exp))
      | ("|" Exp "=" Exp)+ =>
         (PT.DECODEdecl (Name, DecodePat, Sum.INR SR))) =>
      (markDecl (FULL_SPAN, decl))
   ; 

ConDecls
   : ConDecl ("|" ConDecl)* => (ConDecl::SR)
   ;

ConDecl
   : ConBind ("of" Ty)? => ((ConBind, SR))
   ;

Ty
   : Int => (mark PT.MARKty (FULL_SPAN, PT.BITty Int))
   | Qid => (mark PT.MARKty (FULL_SPAN, PT.NAMEDty Qid))
   | "{" Name ":" Ty ("," Name ":" Ty)* "}" =>
      (mark PT.MARKty (FULL_SPAN, PT.RECORDty ((Name, Ty)::SR)))
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
   | Qid => (mark PT.MARKtokpat (FULL_SPAN, PT.NAMEDtokpat Qid))
   ;

PrimBitPat
   : BITSTR => (mark PT.MARKbitpat (FULL_SPAN, PT.BITSTRbitpat BITSTR))
   | Qid (BitPatOrInt)? =>
      (mark
         PT.MARKbitpat
         (FULL_SPAN,
          case SR of
             NONE => PT.NAMEDbitpat Qid
           | SOME i => PT.BITVECbitpat (#tree Qid, i)))
   ;

BitPatOrInt
   : ":" POSINT => (let fun dup n = if n=0 then "" else "." ^ dup (n-1)
                in dup (IntInf.toInt POSINT) end)
   | "@" BITSTR => (BITSTR)
   ;

Exp
   : ClosedExp => (ClosedExp)
   | "case" ClosedExp "of" Cases "end" =>
      (mark PT.MARKexp (FULL_SPAN, PT.CASEexp (ClosedExp, Cases)))
   ;

ClosedExp
   : OrElseExp
   | "if" Exp "then" Exp "else" Exp =>
      (mark PT.MARKexp (FULL_SPAN, PT.IFexp (Exp1, Exp2, Exp3)))
(* | "raise" Exp =>
       (mark PT.MARKexp (FULL_SPAN, PT.RAISEexp Exp))
*)
   | "do" MonadicExp (";" MonadicExp)* "end" =>
      (mark PT.MARKexp (FULL_SPAN, PT.SEQexp (MonadicExp::SR)))
   ;

MonadicExp
   : Exp =>
      (mark PT.MARKseqexp (FULL_SPAN, PT.ACTIONseqexp Exp))
   | Name "<-" Exp =>
      (mark PT.MARKseqexp (FULL_SPAN, PT.BINDseqexp (Name, Exp)))
   ;

Cases
   : Pat ":" Exp ("|" Pat ":" Exp)* => ((Pat, Exp)::SR)
   ;

Pat
   : "_" => (mark PT.MARKpat (FULL_SPAN, PT.WILDpat))
   | Lit => (mark PT.MARKpat (FULL_SPAN, PT.LITpat Lit))
   | Name => (mark PT.MARKpat (FULL_SPAN, PT.IDpat Name))
   | ConUse Pat? => (mark PT.MARKpat (FULL_SPAN, PT.CONpat (ConUse, Pat)))
   ;

OrElseExp
   : AndAlsoExp (OrElse AndAlsoExp)* =>
      (mark PT.MARKexp (FULL_SPAN, mkLBinExp (AndAlsoExp, SR)))
   ;

OrElse
   : "or" => (mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.orElse))
   ;

AndAlsoExp
   : RExp (AndAlso RExp)* =>
      (mark PT.MARKexp (FULL_SPAN, mkLBinExp (RExp, SR)))
   ;

AndAlso
   : "and" => (mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.andAlso))
   ;

RExp
   : AExp ((Sym => (mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Sym))
          ) AExp)* =>
      (mark PT.MARKexp (FULL_SPAN, mkLBinExp(AExp, SR)))
   ;

AExp
   : MExp (( "+" => (mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.plus))
           | "-" => (mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.minus))
          ) MExp => (SR, MExp))* =>
      (mark PT.MARKexp (FULL_SPAN, mkLBinExp (MExp, SR)))
   ;

MExp
   : SelectExp
      (( "*" => (mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.times))
       | "div" => (mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.div))
       | "%" => (mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.mod))
       ) ApplyExp =>
      (SR, SelectExp))* =>
         (mark PT.MARKexp (FULL_SPAN, mkLBinExp (SelectExp, SR)))
   ;

SelectExp
   : ApplyExp 
      (("^" => (mark PT.MARKinfixop (FULL_SPAN, PT.OPinfixop Op.concat))
      ) ApplyExp => (SR, ApplyExp))* =>
      (mark PT.MARKexp (FULL_SPAN, mkLBinExp (ApplyExp, SR)))
   ;

ApplyExp
   : AtomicExp exp=
      ( rhs=AtomicExp* => (mkApply(AtomicExp, rhs))) =>
         (mark PT.MARKexp (FULL_SPAN, exp))
   | "~" AtomicExp =>
      (mark PT.MARKexp (FULL_SPAN, PT.APPLYexp (PT.IDexp {span=FULL_SPAN, tree=Op.uminus}, AtomicExp)))
   ;

AtomicExp
   : Lit => (mark PT.MARKexp (FULL_SPAN, PT.LITexp Lit))
   | Qid => (mark PT.MARKexp (FULL_SPAN, PT.IDexp Qid))
   | ConUse => (mark PT.MARKexp (FULL_SPAN, PT.CONexp ConUse))
   | "@" "{" Name "=" Exp ("," Name "=" Exp)* "}" =>
      (mark PT.MARKexp (FULL_SPAN, PT.UPDATEexp ((Name, Exp)::SR)))
   | "$" Qid => (mark PT.MARKexp (FULL_SPAN, PT.SELECTexp Qid))
   | "(" Exp ")" => (Exp)
   | "{" "}" => (mark PT.MARKexp (FULL_SPAN, PT.RECORDexp []))
   | "{" Name "=" Exp ("," Name "=" Exp)* "}" =>
      (mark PT.MARKexp (FULL_SPAN, PT.RECORDexp ((Name, Exp)::SR)))
   | "let" ValueDecl+ "in" Exp "end" =>
      (mark PT.MARKexp (FULL_SPAN, PT.LETRECexp (ValueDecl, Exp)))
   ;

ValueDecl
   : "val" Name Name* "=" Exp => (Name1, Name2, Exp)
   ;

Lit
   : Int => (PT.INTlit Int)
   | STRING => (PT.STRlit STRING)
   | "'" BITSTR "'" => (PT.VEClit BITSTR)
   ;                   

Int
   : POSINT => (POSINT)
   | NEGINT => (NEGINT)
   ;

Name
   : ID => (ID)
   ;

(* Constructors *)
ConBind
   : CONS => (CONS)
   ;

ConUse
   : CONS => ({span=FULL_SPAN, tree=CONS})
   ;

Sym
   : SYMBOL => (SYMBOL)
   ;

Qid
   : ID => ({span=FULL_SPAN, tree=ID})
   ;
