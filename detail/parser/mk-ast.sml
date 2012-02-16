
signature AST_CORE = sig
   type ty_bind
   type ty_use
   type syn_bind
   type syn_use
   type con_bind
   type con_use
   type var_bind
   type var_use
   type field_bind
   type field_use
   type op_id
   val var_bind: var_bind -> Pretty.pp_desc
   val var_use: var_use -> Pretty.pp_desc
   val ty_bind: ty_bind -> Pretty.pp_desc
   val ty_use: ty_use -> Pretty.pp_desc
   val syn_bind: syn_bind -> Pretty.pp_desc
   val syn_use: syn_use -> Pretty.pp_desc
   val con_bind: con_bind -> Pretty.pp_desc
   val con_use: con_use -> Pretty.pp_desc
   val field_bind: field_bind -> Pretty.pp_desc
   val field_use: field_use -> Pretty.pp_desc
   val op_id: op_id -> Pretty.pp_desc
end

functor MkAst (Core: AST_CORE) = struct
   (* a term marked with a source-map span *)
   type 'a mark = 'a Error.mark

   type ty_bind = Core.ty_bind
   type ty_use = Core.ty_use
   type syn_bind = Core.syn_bind
   type syn_use = Core.syn_use
   type con_bind = Core.con_bind
   type con_use = Core.con_use
   type var_bind = Core.var_bind
   type var_use = Core.var_use
   type field_bind = Core.field_bind
   type field_use = Core.field_use
   type op_id = Core.op_id

   datatype decl =
      MARKdecl of decl mark
    | INCLUDEdecl of string
    | GRANULARITYdecl of IntInf.int
    | STATEdecl of (var_bind * ty * exp) list
    | TYPEdecl of syn_bind * ty
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
    | NAMEDty of syn_use
    | RECty of (field_bind * ty) list

   and exp =
      MARKexp of exp mark
    | LETexp of valuedecl list * exp
    | IFexp of exp * exp * exp
    | CASEexp of exp * match list
    | ANDALSOexp of exp * exp
    | ORELSEexp of exp * exp
    | BINARYexp of exp * op_id * exp (* infix binary expressions *)
    | APPLYexp of exp * exp
    | RECORDexp of (field_bind * exp) list
    | SELECTexp of exp * field_use  (* record field selector "x.field" *)
    | LITexp of lit
    | SEQexp of seqexp list (* monadic sequence *)
    | IDexp of var_use (* either variable or nullary constant *)
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

   structure PP = struct
      open Pretty
      val zeroIndent = Pretty.PPS.Rel 0
      val dflIndent = Pretty.PPS.Rel 3
      val empty = token "<.>"

      fun spec (ss:specification) = vBox (zeroIndent, map decl (#tree ss))

      and decl t =
         case t of
            MARKdecl t' => decl (#tree t')
          | INCLUDEdecl inc => hBox [token "include", space 1, token inc, newline]
          | GRANULARITYdecl i => hBox [token "granularity", space 1, int i, newline]
          | STATEdecl ss =>
               hBox
                  [token "state", space 1, lb,
                   hvBox (dflIndent, map (tuple3 (Core.var_bind, ty, exp)) ss),
                   rb, newline]
          | TYPEdecl t =>
               hBox [token "type", space 1, tuple2 (Core.syn_bind, ty) t, newline]
          | DATATYPEdecl (t, decls) =>
               hBox
                  [token "datatype", space 1, Core.ty_bind t, lb,
                   hvBox (dflIndent, map condecl decls),
                   rb, newline]
          | DECODEdecl dec => hBox [decodedecl dec, newline]
          | VALUEdecl dec => hBox [valuedecl dec, newline]

      and decodedecl t = empty

      and valuedecl t = empty

      and condecl t = empty

      and ty t = empty

      and exp t = empty

      and seqexp t = empty

      and decodepat t = empty

      and bitpat t = empty

      and tokpat t = empty

      and match t = empty

      and pat t = empty

      and lit t = empty

      val pretty = Pretty.pretty o spec
   end
end