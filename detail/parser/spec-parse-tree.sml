
(* Parse-tree representation of decoder specifications. *)
structure SpecParseTree = struct

   (* a term marked with a source-map span *)
   type 'a mark = 'a Error.mark

   (* qualified names *)
   type 'a path = (Atom.atom list * 'a) Error.mark

   type qid = Atom.atom path
   type ty_bind = Atom.atom
   type ty_use = qid
   type con_bind = Atom.atom
   type con_use = qid
   type var_bind = Atom.atom
   type var_use = qid
   type op_id = Atom.atom
   type mod_bind = Atom.atom
   type mod_use = qid
   type sig_id = Atom.atom

   datatype decl =
      MARKdecl of decl mark
    | INCLUDEdecl of string
    | GRANULARITYdecl of IntInf.int
    | STATEdecl of (var_bind * ty * exp) list
    | TYPEdecl of ty_bind * ty
    | DATATYPEdecl of ty_bind * condecl list
    | DECODEdecl of decodedecl
    | VALUEdecl of valuedecl

   and decodedecl =
      MARKdecodedecl of decodedecl mark
    | NAMEDdecodedecl of var_bind * decodepat list * exp
    | DECODEdecodedecl of decodepat list * exp
    | GUARDEDdecodedecl of decodepat list * (exp * exp) list

   and valuedecl =
      MARKvaluedecl of valuedecl mark
    | LETvaluedecl of var_bind * var_bind list * exp
    | LETRECvaluedecl of var_bind * var_bind list * exp

   and condecl =
      MARKcondecl of condecl mark
    | CONdecl of con_bind * ty option

   and ty =
      MARKty of ty mark
    | BITty of IntInf.int
    | NAMEDty of ty_use
    | RECty of (var_bind * ty) list

   and exp =
      MARKexp of exp mark
    | LETexp of valuedecl list * exp
    | IFexp of exp * exp * exp
    | CASEexp of exp * match list
    | RAISEexp of exp
    | ANDALSOexp of exp * exp
    | ORELSEexp of exp * exp
    | BINARYexp of exp * op_id * exp (* infix binary expressions *)
    | APPLYexp of exp * exp
    | RECORDexp of (var_bind * exp) list
    | LITexp of lit
    | SEQexp of seqexp list (* monadic sequence *)
    | IDexp of var_use (* either variable or nullary constant *)
    (* | CONSTRAINTexp of exp * ty (* type constraint *) *)
    | FNexp of (var_bind * exp) list (* anonymous function *)

   and seqexp =
      MARKseqexp of seqexp mark
    | ACTIONseqexp of exp
    | BINDseqexp of var_bind * exp

   and decodepat =
      MARKdecodepat of decodepat mark
    | TOKENdecodepat of tokpat
    | BITdecodepat of bitpat list

   and bitpat =
      MARKbitpat of bitpat mark
    | BITSTRbitpat of string
    | NAMEDbitpat of var_bind
    | BITVECbitpat of var_bind * IntInf.int

   and tokpat =
      MARKtokpat of tokpat mark
    | TOKtokpat of IntInf.int
    | NAMEDtokpat of var_bind

   and match =
      MARKmatch of match mark
    | CASEmatch of (pat * exp)

   and pat =
      MARKpat of pat mark
    | BITpat of string
    | LITpat of lit
    | IDpat of var_use
    | WILDpat

   and lit =
      INTlit of IntInf.int
    | FLTlit of FloatLit.float
    | STRlit of string

   type specification = decl list mark

  end
