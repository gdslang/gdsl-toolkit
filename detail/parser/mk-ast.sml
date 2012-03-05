
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
   val var_bind: var_bind -> Layout.layout
   val var_use: var_use -> Layout.layout
   val ty_bind: ty_bind -> Layout.layout
   val ty_use: ty_use -> Layout.layout
   val syn_bind: syn_bind -> Layout.layout
   val syn_use: syn_use -> Layout.layout
   val con_bind: con_bind -> Layout.layout
   val con_use: con_use -> Layout.layout
   val field_bind: field_bind -> Layout.layout
   val field_use: field_use -> Layout.layout
   val op_id: op_id -> Layout.layout
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
    | DATATYPEdecl of con_bind * condecl list
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
    | SELECTexp of field_use  (* record field selector "$field" *)
    | UPDATEexp of (field_use * exp) list (* functional record update "@{a=a'} *)
    | LITexp of lit
    | SEQexp of seqexp list (* monadic sequence *)
    | IDexp of var_use (* either variable or nullary constant *)
    | CONexp of con_use (* constructor *)
    | FNexp of var_bind * exp (* anonymous function *)

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
    | NAMEDbitpat of var_use
    | BITVECbitpat of var_bind * IntInf.int

   and tokpat =
      MARKtokpat of tokpat mark
    | TOKtokpat of IntInf.int
    | NAMEDtokpat of var_use

   and match =
      MARKmatch of match mark
    | CASEmatch of (pat * exp)

   and pat =
      MARKpat of pat mark
    | BITpat of string
    | LITpat of lit
    | IDpat of var_bind
    | CONpat of con_use * pat option
    | WILDpat

   and lit =
      INTlit of IntInf.int
    | FLTlit of FloatLit.float
    | STRlit of string

   type specification = decl list mark

   structure PP = struct
      open Layout Pretty Core
      fun spec (ss:specification) = align (map decl (#tree ss))

      and decl t =
         case t of
            MARKdecl t' => decl (#tree t')
          | INCLUDEdecl inc => seq [str "INCLUDE", space, str inc]
          | GRANULARITYdecl i => seq [str "GRANULARITY", space, int i]
          | STATEdecl ss => def (str "STATE", list (map (tuple3 (var_bind, ty, exp)) ss))
          | TYPEdecl (t, tyexp) => seq [str "TYPE", space, syn_bind t, space, ty tyexp]
          | DATATYPEdecl (t, decls) => def (seq [str "DATATYPE", space, con_bind t], list (map condecl decls))
          | DECODEdecl decl => decodedecl decl
          | VALUEdecl decl => valuedecl decl

      and decodedecl t =
         case t of
            MARKdecodedecl t' => decodedecl (#tree t')
          | NAMEDdecodedecl (name, pats, e) => def (seq [str "DECODE", space, var_bind name, space, list (map decodepat pats)], exp e)
          | DECODEdecodedecl (pats, e) => def (seq [str "DECODE", space, list (map decodepat pats)], exp e)
          | GUARDEDdecodedecl (pats, gexps) =>
               def
                  (seq [str "DECODE", space, list (map decodepat pats)],
                   seq [str "[", alignPrefix (map guardedexp gexps, ","), str "]"])

      and decodepat t =
         case t of
            MARKdecodepat t' => decodepat (#tree t')
          | BITdecodepat bp => list (map bitpat bp)
          | TOKENdecodepat tp => tokpat tp

      and bitpat t =
         case t of
            MARKbitpat t' => bitpat (#tree t')
          | BITSTRbitpat s => str s
          | NAMEDbitpat n => var_use n
          | BITVECbitpat tybp => tuple2 (var_bind, int) tybp

      and tokpat t =
         case t of
            MARKtokpat t' => tokpat (#tree t')
          | TOKtokpat tok => str (IntInf.fmt StringCvt.HEX tok)
          | NAMEDtokpat n => var_use n

      and guardedexp gexp = tuple2 (exp, exp) gexp

      and valuedecl t =
         case t of
            MARKvaluedecl t' => valuedecl (#tree t')
          | LETvaluedecl (name, args, e) => def (seq [str "VAL", space, var_bind name, space, list (map var_bind args)], exp e)
          | LETRECvaluedecl (name, args, e) => def (seq [str "REC", space, var_bind name, space, list (map var_bind args)], exp e)

      and condecl t =
         case t of
            MARKcondecl t' => condecl (#tree t')
          | CONdecl (name, optTy) =>
               case optTy of
                  NONE => con_bind name
                | SOME t => seq [con_bind name, space, ty t]

      and ty t =
         case t of
            MARKty t' => ty (#tree t')
          | BITty i => int i
          | NAMEDty alias => Core.syn_use alias
          | RECty fields => list (map (tuple2 (field_bind, ty)) fields)

      and seqexp t =
         case t of
            MARKseqexp t' => seqexp (#tree t')
          | ACTIONseqexp act => exp act
          | BINDseqexp bnd => tuple2 (var_bind, exp) bnd

      and match t =
         case t of
            MARKmatch t' => match (#tree t')
          | CASEmatch ps => tuple2 (pat, exp) ps

      and pat t =
         case t of
            MARKpat t' => pat (#tree t')
          | BITpat s => seq [str "'", str s, str "'"]
          | LITpat l => lit l
          | IDpat n => var_bind n
          | CONpat (n, SOME p) => seq [con_use n, space, pat p]
          | CONpat (n, _) => con_use n
          | WILDpat => str "_"

      and lit t =
         case t of
            INTlit i => int i
          | FLTlit f => str (FloatLit.toString f)
          | STRlit s => str s

      and exp t =
         case t of
            MARKexp t' => exp (#tree t')
          | LETexp bs => paren (seq [str "LET", space, tuple2 (list o map valuedecl, exp) bs])
          | IFexp iff => paren (seq [str "IF", space, tuple3 (exp, exp, exp) iff])
          | CASEexp (e, ms) =>
               paren
                  (def
                     (seq [str "CASE", space, exp e],
                      list (map match ms)))
          | ANDALSOexp (e1, e2) => paren (seq [str "ANDALSO", space, exp e1, space, exp e2])
          | ORELSEexp (e1, e2) => paren (seq [str "ORELSE", space, exp e1, space, exp e2])
          | BINARYexp (e1, opid, e2) => paren (seq [op_id opid, space, exp e1, space, exp e2])
          | APPLYexp (e1, e2) => paren (seq [str "APP", space, exp e1, space, exp e2])
          | RECORDexp fs => listex "{" "}" "," (map (tuple2 (field_bind, exp)) fs)
          | SELECTexp f => paren (seq [str "SELECT", space, field_use f])
          | UPDATEexp fs => paren (seq [str "UPDATE", space, listex "{" "}" "," (map (tuple2 (field_use, exp)) fs)])
          | LITexp l => lit l
          | SEQexp s => paren (seq [str "DO", space, list (map seqexp s)])
          | IDexp id => var_use id
          | CONexp con => seq [str "`", con_use con]
          | FNexp (x, e) => paren (seq [str "FN", space, var_bind x, space, exp e])

      and def (nameAndArgs, body) = align [nameAndArgs, indent 2 body]

      val pretty = Pretty.pretty o spec
      fun prettyTo (os, t) = Pretty.prettyTo (os, spec t)
   end
end
