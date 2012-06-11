(* Copyright (C) 2006 Entain, Inc.
 *
 * This code is released under the MLton license, a BSD-style license.
 * See the LICENSE file or http://mlton.org/License for details.
 *)

structure Javascript : JAVASCRIPT = struct

structure Pervasive =
   struct
      structure String = String
   end

structure Regexp : JSREGEXP =
   struct

      datatype t = T of {body: string,
                         flags: string}

      fun equals (T {body = b, flags = f}, T {body = b', flags = f'}) =
         b = b' andalso f = f'

      val make = T

      fun toString (T {body, flags}) = concat ["/", body, "/", flags]

      val layout = Layout.str o toString
end

structure Vector =
   struct
      open Vector
      fun toList a = foldr op:: [] a
      fun toListMap (a, f) = foldr (fn (a, ac) => f a :: ac) [] a
      fun forall (w, f) = all f w
      fun foreach (v, f) = Vector.app f v
      fun new0 () = fromList []
      fun new1 a = tabulate (1, fn _ => a)
      fun fold (v,s,f) = foldl f s v
   end

structure Id =
   struct
      datatype t = T of string

      fun equals (T s, T s') = s = s'

      val fromString = T

      fun toString (T s) = s

      val layout = Layout.str o toString
   end

structure AssignOp =
   struct
      datatype t =
         Add
       | BitwiseAnd
       | BitwiseOr
       | BitwiseXor
       | Div
       | Equals
       | LeftShift
       | Mul
       | Mod
       | RightShiftSigned
       | RightShiftUnsigned
       | Sub

      val toString =
         fn Add => "+="
          | BitwiseAnd => "&="
          | BitwiseOr => "|="
          | BitwiseXor => "^="
          | Div => "/="
          | Equals => "="
          | LeftShift => "<<="
          | Mul => "*="
          | Mod => "%="
          | RightShiftSigned => ">>="
          | RightShiftUnsigned => ">>>="
          | Sub => "-="

      val layout = Layout.str o toString
   end

structure BinaryOp =
   struct
      datatype t =
         Add
       | BitwiseAnd
       | BitwiseOr
       | BitwiseXor
       | Div
       | Equals
       | GreaterThan
       | GreaterThanEqual
       | In
       | InstanceOf
       | LeftShift
       | LessThan
       | LessThanEqual
       | LogicalAnd
       | LogicalOr
       | Mod
       | Mul
       | NotEquals
       | RightShiftSigned
       | RightShiftUnsigned
       | StrictEquals
       | StrictNotEquals
       | Sub

      val toString =
         fn Add => "+"
          | BitwiseAnd => "&"
          | BitwiseOr => "|"
          | BitwiseXor => "^"
          | Div => "/"
          | Equals => "=="
          | GreaterThan => ">"
          | GreaterThanEqual => ">="
          | In => "in"
          | InstanceOf => "instanceof"
          | LeftShift => "<<"
          | LessThan => "<"
          | LessThanEqual => "<="
          | LogicalAnd => "&&"
          | LogicalOr => "||"
          | Mod => "%"
          | Mul => "*"
          | NotEquals => "!="
          | RightShiftSigned => ">>"
          | RightShiftUnsigned => ">>>"
          | StrictEquals => "==="
          | StrictNotEquals => "!=="
          | Sub => "-"

      val layout = Layout.str o toString
         
      val equals: t * t -> bool = op =

      val precedences: t list list =
         [[Div, Mod, Mul],
          [Add, Sub],
          [LeftShift, RightShiftSigned, RightShiftUnsigned],
          [GreaterThan, GreaterThanEqual, LessThan, LessThanEqual, In,
           InstanceOf],
          [Equals, NotEquals, StrictEquals, StrictNotEquals],
          [BitwiseAnd],
          [BitwiseXor],
          [BitwiseOr],
          [LogicalAnd],
          [LogicalOr]]

      val precedencesRev = rev precedences
   end

structure UnaryOp =
   struct
      datatype t =
         Add
       | BitwiseNot
       | Delete
       | LogicalNot
       | Neg
       | PreDecrement
       | PreIncrement
       | PostDecrement
       | PostIncrement
       | TypeOf
       | Void

      val hasSideEffect =
       fn PreDecrement => true
        | PreIncrement => true
        | PostDecrement => true
        | PostIncrement => true
        | _ => false

      val isAlphaNumeric =
         fn Delete => true
          | TypeOf => true
          | Void => true
          | _ => false

      val isSymbolic = not o isAlphaNumeric

      fun mustSeparate (o1, o2) =
         if isAlphaNumeric o1
            then isAlphaNumeric o2
         else
            case (o1, o2) of
               (Add, Add) => true
             | (Add, PreIncrement) => true
             | (Neg, Neg) => true
             | (Neg, PreDecrement) => true
             | _ => false

      val toString =
         fn Add => "+"
          | BitwiseNot => "~" 
          | Delete => "delete"
          | LogicalNot => "!"
          | Neg => "-"
          | PreDecrement => "--"
          | PreIncrement => "++"
          | PostDecrement => "--"
          | PostIncrement => "++"
          | TypeOf => "typeof"
          | Void => "void"

      val layout = Layout.str o toString
               
      val isPostfix =
         fn PostDecrement => true
          | PostIncrement => true
          | _ => false

      val isPrefix = not o isPostfix
   end

structure Number =
   struct

      fun realToJavascript r =
         if Real.== (r, Real.realFloor r) then
            let
               (* val i = Real.toIntInf r *)
               val i = IntInf.fromLarge (Real.toLargeInt IEEEReal.TO_NEAREST r)
               val (isNeg, i) = if i < 0 then (true, ~i) else (false, i)
               val sD = IntInf.fmt StringCvt.DEC i
               val sH = IntInf.fmt StringCvt.HEX i
               val s =
                  if String.size sD <= String.size sH + 2 then
                     sD
                  else
                     concat ["0x", sH]
            in
               if isNeg then concat ["-", s] else s
            end
         else
            (* Want to lay out numbers nicely, but without losing precision.
             * Seventeen digits is enough to do this.
             *)
            String.translate
             (fn #"~" => "-"
              | c => String.str c)
            (Real.fmt (StringCvt.GEN (SOME 17)) r)

      datatype t = T of Real.real

      fun equals (T r, T r') = Real.== (r, r')

      fun fromReal r = if r < 0.0 then raise Fail "Number.fromReal" else T r

      val toReal = fn T r => r

      val fromInt = fromReal o Real.fromInt

      val zero = fromInt 0

      fun isZero n = equals (n, zero)

      fun toString (T r) = realToJavascript r

      val layout = Layout.str o toString
   end

structure JSString =
   struct
      fun escapeJavascript (ws: Word.word vector) =
         let
            val w2c = Char.chr o Word.toInt
            val w2s = Char.toString o w2c
            val c2w = Word.fromInt o Char.ord
            fun num w =
               Vector.foldl (fn (w', n) => if w = w' then n + 1 else n) 0 ws
            val sq = c2w #"'"
            val dq = c2w #"\""
            val quote = if Int.>= (num dq, num sq) then sq else dq
            val quoteS = w2s quote
            fun fromHexDigit (n: int): char = String.sub ("0123456789ABCDEF", n)
            fun toHexDigits (w, n) =
               let
                  fun loop (n, w, ac) =
                     if n = 0
                        then implode ac
                     else loop (n - 1,
                                Word.div (w, 0wx10),
                                fromHexDigit (Word.toInt
                                             (Word.mod (w, 0wx10)))
                                :: ac)
               in
                  loop (n, w, [])
               end
            val body =
               concat
               (Vector.toListMap
                (ws, fn w =>
                 if w = quote then concat ["\\", w2s w]
                 else if w > 0wxFFFF then concat ["\\U", toHexDigits (w, 8)]
                 else if w > 0wxFF then concat ["\\u", toHexDigits (w, 4)]
                 else
                    case w2c w of
                       #"\000" => "\\0"
                     | #"\b" => "\\b"
                     | #"\f" => "\\f"
                     | #"\n" => "\\n"
                     | #"\r" => "\\r"
                     | #"\t" => "\\t"
                     | #"\v" => "\\v"
                     | #"\\" => "\\\\"
                     | c => if Char.isPrint c
                               then Char.toString c
                            else concat ["\\x", toHexDigits (w, 2)]))
         in
            concat [quoteS, body, quoteS]
         end

      datatype t = T of word vector

      val make = T

      fun fromString s =
         T (Vector.tabulate
            (String.size s, fn i =>
             Word.fromInt (Char.ord (String.sub (s, i)))))

      fun escape (T ws) = escapeJavascript ws

      fun toString (T ws) =
         CharVector.tabulate (Vector.length ws, fn i =>
                          Char.chr (Word.toInt (Vector.sub (ws, i))))

      val layout = Layout.str o escape

      val w2c = Char.chr o Word.toInt

      val keywords =
         ["true", "false", "break", "case", "catch", "const", "continue",
          "default", "delete", "do", "else", "finally", "for", "function",
          "if", "in", "instanceof", "new", "null", "return", "switch", "this",
          "throw", "tilde", "try", "typeof", "var", "void", "while", "with"]

      fun isKeyword s = List.exists (fn s' => s=s') keywords

      fun isValidIdentifier (T ws) =
         0 < Vector.length ws
         andalso
         let
            fun isOk c = Char.isAlphaNum c orelse c = #"_" orelse c = #"$"
         in
            (isOk (w2c (Vector.sub (ws, 0)))
             andalso Vector.forall (ws, fn w =>
                                    let
                                       val c = w2c w
                                    in
                                       isOk c orelse Char.isDigit c
                                    end)
             andalso not (isKeyword (CharVector.tabulate
                                     (Vector.length ws, fn i =>
                                      w2c (Vector.sub (ws, i))))))
            handle Chr => false
         end
         
      fun layoutAsPropertyName (s: t): Layout.t =
         if isValidIdentifier s
            then Layout.str (toString s)
         else layout s
   end

structure PropertyName =
   struct
      datatype t =
         Number of Number.t
       | String of JSString.t

      val layout =
         fn Number n => Number.layout n
          | String s => JSString.layoutAsPropertyName s

      val fromInt = Number o Number.fromInt

      val fromString = String o JSString.fromString
   end

structure Joint =
   struct
      datatype exp =
         Array of exp option vector
       | Assign of {lhs: exp,
                    oper: AssignOp.t,
                    rhs: exp}
       | Bool of bool
       | Binary of {lhs: exp,
                    oper: BinaryOp.t,
                    rhs: exp}
       | Call of {args: exp vector,
                  func: exp}
       | Cond of {elsee: exp,
                  test: exp,
                  thenn: exp}
       | Function of {args: Id.t vector,
                      body: statement vector,
                      name: Id.t option}
       | Id of Id.t
       | New of {args: exp vector,
                 object: exp}
       | Number of Number.t
       | Null
       | Object of objectInit vector
       | Regexp of Regexp.t
       | Seq of exp vector
       | Select of {object: exp,
                    property: exp}
       | SelectId of {object: exp,
                      property: Id.t}
       | String of JSString.t
       | Unary of {exp: exp,
                   oper: UnaryOp.t}
       | This

      and objectInit =
         Get of {args: Id.t vector,
                 body: statement vector,
                 name: Id.t}
       | Property of {property: PropertyName.t,
                      value: exp}
       | Set of {args: Id.t vector,
                 body: statement vector,
                 name: Id.t}

      and statement =
         Block of statement vector
        | Break of Id.t option
        | Const of (Id.t * exp) vector
        | Continue of Id.t option
        | Do of {body: statement,
                 test: exp}
        | Empty
        | Exp of exp
        | For of {body: statement,
                  inc: exp option,
                  init: exp option,
                  test: exp option}
        | ForIn of {body: statement,
                    lhs: exp,
                    object: exp}
        | ForVar of {body: statement,
                     inc: exp option,
                     init: (Id.t * exp option) vector,
                     test: exp option}
        | ForVarIn of {body: statement,
                       id: Id.t,
                       init: exp option,
                       object: exp}
        | FunctionDec of {args: Id.t vector,
                          body: statement vector,
                          name: Id.t}
        | If of {elsee: statement option,
                 test: exp,
                 thenn: statement}
        | Labeled of Id.t * statement
        | Return of exp option
        | Switch of {clauses: (exp list * statement vector) vector,
                     test: exp}
        | Throw of exp
        | Try of {body: statement vector,
                  catch: (Id.t * statement vector) option,
                  finally: statement vector option}
        | Var of (Id.t * exp option) vector
        | While of {body: statement,
                    test: exp}
        | With of {body: statement,
                   object: exp}
   end

structure Exp =
   struct
      datatype t = datatype Joint.exp
   end

structure Statement =
   struct
      datatype t = datatype Joint.statement
   end

structure ObjectInit =
   struct
      datatype dest = datatype Joint.objectInit
      datatype t = datatype dest
   end

structure Joint =
   struct
      open Joint

      local
         open Layout
      in
         fun commaList (v: 'a vector, lay: 'a -> Layout.t): Layout.t =
            mayAlign (separateRight (Vector.toListMap (v, lay), ","))
            
         fun for (iter, body) =
            layoutStatementIn (body, seq [str "for ", paren iter], NONE)
            
         and layoutArguments es =
            paren (commaList (es, layoutAssignmentExp))

         and layoutAssignmentExp e =
            layoutAssignmentExpGen (e, {isStatement = false,
                                        mayHaveIn = true})
            
         and layoutAssignmentExpGen (e, {isStatement, mayHaveIn}) =
            case e of
               Assign {lhs, oper, rhs} =>
                  mayAlign [seq [layoutLeftHandSideExp
                                 (lhs, {isStatement = isStatement}),
                                 str " ", AssignOp.layout oper],
                            indent 2 (layoutAssignmentExpGen
                                    (rhs, {isStatement = false,
                                           mayHaveIn = mayHaveIn}))]
             | _ => layoutConditionalExp (e, {isStatement = isStatement,
                                              mayHaveIn = mayHaveIn})

         and layoutBinaryExp (e: Exp.t, {isStatement, mayHaveIn}) : Layout.t =
            let
               fun loop arg: Layout.t =
                  (fn (e: Exp.t, {isStatement}, opers) =>
                  case e of
                     Binary {lhs, oper, rhs} =>
                        if not mayHaveIn
                           andalso BinaryOp.equals (oper, BinaryOp.In)
                           then layoutUnaryExp (e, {isStatement = isStatement})
                        else
                           let
                              fun loop' opers' =
                                 case opers' of
                                    [] =>
                                       layoutUnaryExp
                                       (e, {isStatement = isStatement})
                                  | z :: opers'' =>
                                       if List.exists
                                          (fn oper' =>
                                           BinaryOp.equals (oper, oper')) z
                                          then (mayAlign
                                                [loop
                                                 (lhs,
                                                  {isStatement = isStatement},
                                                  opers'),
                                                 seq [BinaryOp.layout oper,
                                                      str " ",
                                                      loop (rhs,
                                                            {isStatement = false},
                                                            opers'')]])
                                       else loop' opers''
                           in
                              loop' opers
                           end
                   | _ => layoutUnaryExp (e, {isStatement = isStatement}))
                  arg
            in
               loop (e, {isStatement = isStatement}, BinaryOp.precedencesRev)
            end
            
         and layoutCall (f, args) =
            mayAlign [f, indent 2 (layoutArguments args)]

         and layoutSelect (object, property) =
            seq [object, str "[", layoutExp property, str "]"]

         and layoutSelectId (object, property) =
            seq [object, str ".", Id.layout property]
            
         and layoutConditionalExp (e, z as {isStatement = _, mayHaveIn}) =
            case e of
               Cond {elsee, test, thenn} =>
                  let
                     val mhi = {isStatement = false,
                                mayHaveIn = mayHaveIn}
                  in
                     align [layoutBinaryExp (test, z),
                            seq [str "? ", layoutAssignmentExpGen (thenn, mhi)],
                            seq [str ": ", layoutAssignmentExpGen (elsee, mhi)]]
                  end
             | _ => layoutBinaryExp (e, z)
            
         and layoutExp e =
            layoutExpGen (e, {isStatement = false, mayHaveIn = true})

         and layoutExpGen (e, {isStatement, mayHaveIn}) =
            case e of
               Seq es =>
                  commaList
                  (Vector.mapi
                   (fn (i, e) =>
                    layoutAssignmentExpGen
                    (e, {isStatement = isStatement andalso i = 0,
                         mayHaveIn = mayHaveIn})) es,
                   fn z => z)
             | _ => layoutAssignmentExpGen (e, {isStatement = isStatement,
                                                mayHaveIn = mayHaveIn})

         and layoutExpOpt eo =
            case eo of
               NONE => empty
             | SOME e => layoutExp e

         and layoutExpNoInOpt eo =
            case eo of
               NONE => empty
             | SOME e => layoutExpGen (e, {isStatement = false,
                                           mayHaveIn = false})

         and layoutFunction (keyword, {args, body, name}) =
            align [seq [str keyword,
                        case name of
                           NONE => empty
                         | SOME id => seq [str " ", Id.layout id],
                        str " ", tuple (Vector.toListMap (args, Id.layout)),
                        str " {"],
                   indent 2 (layoutStatements body),
                   str "}"]

         and layoutLeftHandSideExp (e, {isStatement}) =
            case e of
               New _ => layoutNewExp e
             | _ =>
                  let
                     fun loop (e, {precedesDot}) =
                        case e of
                           Call {args, func} =>
                              layoutCall (loop (func,
                                                {precedesDot = false}),
                                          args)
                         | Select {object, property} =>
                              layoutSelect (loop (object,
                                                  {precedesDot = false}),
                                            property)
                         | SelectId {object, property} =>
                              layoutSelectId (loop (object,
                                                    {precedesDot = true}),
                                              property)
                         | _ => layoutMemberExp (e, {isStatement = isStatement,
                                                     precedesDot = precedesDot})
                  in
                     loop (e, {precedesDot = false})
                  end

         and layoutMemberExp (e, {isStatement, precedesDot}) =
            case e of
               New {args, object} =>
                  seq [str "new ",
                       layoutMemberExp (object, {isStatement = false,
                                                 precedesDot = false}),
                       layoutArguments args]
             | Function z =>
                  let
                     val f = layoutFunction ("function", z)
                  in
                     if isStatement then paren f else f
                  end
             | Select {object, property} =>
                  layoutSelect (layoutMemberExp (object,
                                                 {isStatement = isStatement,
                                                  precedesDot = false}),
                                property)
             | SelectId {object, property} =>
                  layoutSelectId (layoutMemberExp (object,
                                                   {isStatement = isStatement,
                                                    precedesDot = true}),
                                  property)
             | _ => layoutPrimaryExp (e, {isStatement = isStatement,
                                          precedesDot = precedesDot})

         and layoutNewExp e =
            case e of
               New {args, object} =>
                  seq [str "new ",
                       if 0 = Vector.length args
                          then layoutNewExp object
                       else seq [layoutMemberExp (object,
                                                  {isStatement = false,
                                                   precedesDot = false}),
                                 layoutArguments args]]
             | _ => layoutMemberExp (e, {isStatement = false,
                                         precedesDot = false})

         and layoutPostfixExp (e, is) =
            case e of
               Unary {exp, oper} =>
                  if UnaryOp.isPostfix oper
                     then seq [layoutLeftHandSideExp (exp, is),
                               UnaryOp.layout oper]
                  else layoutLeftHandSideExp (e, is)
             | _ => layoutLeftHandSideExp (e, is)

         and layoutPrimaryExp (e, {isStatement, precedesDot}) =
            case e of
               Array es =>
                  seq [str "[",
                       seq (rev
                            (#2
                             (Vector.fold
                              (es, (false, []), fn (eo, (z, ac)) =>
                               let
                                  val ac = str (if z then "," else "") :: ac
                               in
                                  case eo of
                                     NONE => (false, str "," :: ac)
                                   | SOME e =>
                                        (true, layoutAssignmentExp e :: ac)
                               end)))),
                       str "]"]
             | Bool b => if b then Layout.str "true" else Layout.str "false"
             | Id id => Id.layout id
             | Number n =>
                  let
                     val s = Number.toString n
                  in
                     if precedesDot
                        andalso not (String.isSubstring "." s) then
                        paren (str s)
                     else str s
                  end
             | Null => str "null"
             | Object inits =>
                  let
                     val z =
                        seq [str "{",
                             commaList (inits, layoutObjectInit),
                             str "}"]
                  in
                     if isStatement then paren z else z
                  end
             | Regexp r => Regexp.layout r
             | String s => JSString.layout s
             | This => str "this"
             | _ => paren (layoutExp e)

         and layoutObjectInit oi =
            case oi of
               Get {args, body, name} =>
                  layoutFunction ("get", {args = args,
                                          body = body,
                                          name = SOME name})
             | Property {property, value} =>
                  seq [PropertyName.layout property,
                       str ": ",
                       layoutAssignmentExp value]
             | Set {args, body, name} =>
                  layoutFunction ("set", {args = args,
                                          body = body,
                                          name = SOME name})
 
         and layoutStatementStart (s, pre: Layout.t)
            : Layout.t * Layout.t option =
            case s of
               Block ss =>
                  (align [seq [pre, str " {"],
                          indent 2 (align (Vector.toListMap
                                          (ss, layoutStatement)))],
                   SOME (str "}"))
             | _ => (align [pre, indent 2 (layoutStatement s)],
                     NONE)

         and combine (l: Layout.t option, l': Layout.t option) =
            case (l, l') of
               (NONE, NONE) => NONE
             | (SOME l, NONE) => SOME l
             | (NONE, SOME l') => SOME l'
             | (SOME l, SOME l') => SOME (seq [l, str " ", l'])

         and layoutStatementIn (s, pre: Layout.t, suf: Layout.t option)
            : Layout.t =
            let
               val (l, suf0) = layoutStatementStart (s, pre)
            in
               case combine (suf0, suf) of
                  NONE => l
                | SOME suf => align [l, suf]
            end

         and layoutStatement (s: Statement.t): Layout.t =
            case s of
               Block ss =>
                  align [str "{", indent 2 (layoutStatements ss), str "}"]
             | Break ido =>
                  seq [str "break",
                       case ido of
                          NONE => empty
                        | SOME id => seq [str " ", Id.layout id],
                       str ";"]
             | Const ds =>
                  seq [str "const ",
                       commaList (ds, fn (x, e) =>
                                  layoutVariableDeclaration (x, SOME e)),
                       str ";"]
             | Continue ido =>
                  seq [str "continue",
                       case ido of
                          NONE => empty
                        | SOME id => seq [str " ", Id.layout id],
                       str ";"]
             | Do {body, test} =>
                  layoutStatementIn
                  (body, str "do",
                   SOME (seq [str "while ", paren (layoutExp test), str ";"]))
             | Empty => str ";"
             | Exp e =>
                  seq [layoutExpGen (e, {isStatement = true,
                                         mayHaveIn = true}),
                       str ";"]
             | For {body, inc, init, test} =>
                  for (mayAlign [seq [layoutExpNoInOpt init, str ";"],
                                 seq [layoutExpOpt test, str ";"],
                                 layoutExpOpt inc],
                       body)
             | ForIn {body, lhs, object} =>
                  for (seq [layoutLeftHandSideExp (lhs, {isStatement = false}),
                            str " in ",
                            layoutExp object],
                       body)
             | ForVar {body, inc, init, test} =>
                  for (mayAlign
                       [seq [str "var ",
                             commaList (init, layoutVariableDeclarationNoIn),
                             str ";"],
                        seq [layoutExpOpt test, str ";"],
                        layoutExpOpt inc],
                       body)
             | ForVarIn {body, id, init, object} =>
                  for (seq [str "var ",
                            layoutVariableDeclarationNoIn (id, init),
                            str " in ",
                            layoutExp object],
                       body)
             | FunctionDec {args, body, name} =>
                  layoutFunction ("function",
                                  {args = args,
                                   body = body,
                                   name = SOME name})
             | If {elsee, test, thenn} =>
                  let
                     fun loop (pre, test, thenn, elsee) =
                        let
                           fun catchesElse s =
                              case s of
                                 If {elsee, thenn, ...} =>
                                    (case elsee of
                                        NONE => true
                                      | SOME e => catchesElse e)
                               | _ => false
                           val thenn =
                              if isSome elsee andalso catchesElse thenn then
                                 Block (Vector.new1 thenn)
                              else
                                 thenn
                           val (pre, suf) =
                              layoutStatementStart
                              (thenn,
                               seq [pre, str "if ", paren (layoutExp test)])
                        in
                           case elsee of
                              NONE =>
                                 (case suf of
                                     NONE => pre
                                   | SOME suf => align [pre, suf])
                            | SOME s => 
                                 align
                                 [pre,
                                  let
                                     val e =
                                        valOf (combine (suf, SOME (str "else")))
                                  in
                                     case s of
                                        If {elsee, test, thenn} =>
                                           loop (seq [e, str " "], test,
                                                 thenn, elsee)
                                      | _ => layoutStatementIn (s, e, NONE)
                                  end]
                        end
                  in
                     loop (str "", test, thenn, elsee)
                  end                                      
             | Labeled (id, s) =>
                  align [seq [Id.layout id, str ":"],
                         layoutStatement s]
             | Return eo =>
                  seq [str "return",
                       case eo of
                          NONE => empty
                        | SOME e => seq [str " ", layoutExp e],
                             str ";"]
             | Switch {clauses, test} =>
                  align [seq [str "switch ", paren (layoutExp test), str " {"],
                         align (Vector.toListMap
                                (clauses, fn (eo, ss) =>
                                 align [case eo of
                                           [] => str "default:"
                                         | es =>
                                             seq [align (map (fn e =>
                                                            seq [str "case ",
                                                                 layoutExp e,
                                                                 str ":"]) es)],
                                        indent 2 (layoutStatements ss)])),
                         str "}"]
             | Throw e => seq [str "throw ", layoutExp e, str ";"]
             | Try {body, catch, finally} =>
                  align [str "try {",
                         indent 2 (layoutStatements body),
                         case catch of
                            NONE => empty
                          | SOME (id, ss) =>
                               align
                               [seq [str "} catch ", paren (Id.layout id),
                                     str " {"],
                                indent 2 (layoutStatements ss)],
                         case finally of
                            NONE => empty
                          | SOME ss =>
                               align [str "} finally {",
                                      indent 2 (layoutStatements ss)],
                         str "}"]
             | Var ds =>
                  seq [str "var ",
                       commaList (ds, layoutVariableDeclaration),
                       str ";"]
             | While {body, test} =>
                  layoutStatementIn
                  (body, seq [str "while ", paren (layoutExp test)], NONE)
             | With {body, object} =>
                  layoutStatementIn
                  (body, seq [str "with ", paren (layoutExp object)], NONE)
         and layoutStatements ss =
            align (Vector.toListMap (ss, layoutStatement))

         and layoutUnaryExp (e, {isStatement}) =
            let
               fun loop (e, {isStatement, lastOp}) =
                  let
                     fun done () =
                        seq [case lastOp of
                                NONE => empty
                              | SOME oper =>
                                   if UnaryOp.isSymbolic oper
                                      then empty
                                   else str " ",
                             layoutPostfixExp (e, {isStatement = isStatement})]
                  in
                     case e of
                        Unary {exp, oper} =>
                           if UnaryOp.isPrefix oper
                              then seq [(case lastOp of
                                            NONE => empty
                                          | SOME oper' =>
                                               if UnaryOp.mustSeparate
                                                  (oper', oper)
                                                  then str " "
                                               else empty),
                                        UnaryOp.layout oper,
                                        loop (exp, {isStatement = false,
                                                    lastOp = SOME oper})]
                           else done ()
                      | _ => done ()
                  end
            in
               loop (e, {isStatement = isStatement, lastOp = NONE})
            end

         and layoutVariableDeclaration z =
             layoutVariableDeclarationGen (z, {mayHaveIn = true})

         and layoutVariableDeclarationNoIn z =
             layoutVariableDeclarationGen (z, {mayHaveIn = false})
             
         and layoutVariableDeclarationGen ((id, eo), {mayHaveIn}) =
            seq [Id.layout id,
                 case eo of
                    NONE => empty
                  | SOME e => seq [str " = ",
                                   layoutAssignmentExpGen
                                   (e, {isStatement = false,
                                        mayHaveIn = mayHaveIn})]]
      end
   end

structure Exp =
   struct
      open Exp
         
      val layout = Joint.layoutExp

      val toString = Layout.tostring o layout

      val int = Number o Number.fromInt

      fun word w =
         Number (Number.fromReal (Real.fromLargeInt (Word.toLargeInt w)))

      val string = String o JSString.fromString

      fun seq es =
         if 1 = Vector.length es
            then Vector.sub (es, 0)
         else Seq es

      val falsee = Bool false
      val truee = Bool true
    
      fun object v = Object (Vector.map ObjectInit.Property v)
         
      fun select {object: t, property: t}: t =
         let
            fun simple () = Select {object = object, property = property}
         in
            case property of
               String s =>
                  if JSString.isValidIdentifier s
                     then (SelectId
                           {object = object,
                            property = Id.fromString (JSString.toString s)})
                  else simple ()
             | _ => simple ()
         end

      val isBool = fn Bool _ => true | _ => false

      val isFalse = fn Bool true => true | _ => false

      val isTrue = fn Bool true => true | _ => false

      fun array (n: t): t =
         New {args = Vector.new1 n,
              object = Id (Id.fromString "Array")}

      fun not e =
         let
            datatype z = datatype UnaryOp.t
            fun keep () = Unary {exp = e, oper = LogicalNot}
         in
            case e of
               Binary {lhs, oper, rhs} =>
                  let
                     datatype z = datatype BinaryOp.t
                     fun make oper = Binary {lhs = lhs, oper = oper, rhs = rhs}
                  in
                     case oper of
                        Equals => make NotEquals
                      | GreaterThan => make LessThanEqual
                      | GreaterThanEqual => make LessThan
                      | LessThan => make GreaterThanEqual
                      | LessThanEqual => make GreaterThan
                      | NotEquals => make Equals
                      | StrictEquals => make StrictNotEquals
                      | StrictNotEquals => make StrictEquals
                      | _ => keep ()
                  end
             | Unary {exp, oper} =>
                  (case oper of
                      LogicalNot => exp
                    | _ => keep ())
             | _ => keep ()
         end
   end

structure Joint =
   struct
      open Joint

      fun simplifyExps es = Vector.map simplifyExp es
      and simplifyExpOpt eo = Option.map simplifyExp eo
      and simplifyExp (e: exp): exp =
         case e of
            Array eos => Array (Vector.map simplifyExpOpt eos)
          | Assign {lhs, oper, rhs} =>
               Assign {lhs = simplifyExp lhs,
                       oper = oper,
                       rhs = simplifyExp rhs}
          | Bool _ => e
          | Binary {lhs, oper, rhs} =>
               let
                  val lhs = simplifyExp lhs
                  val rhs = simplifyExp rhs
                  fun keep () = Binary {lhs = lhs, oper = oper, rhs = rhs}
                  datatype z = datatype BinaryOp.t
               in
                  case oper of
                     Equals =>
                        (case (lhs, rhs) of
                            (Number n, _) =>
                               if Number.isZero n then Exp.not rhs else keep ()
                          | (_, Number n) =>
                               if Number.isZero n then Exp.not lhs else keep ()
                          | _ => keep ())
                   | NotEquals => 
                        (case (lhs, rhs) of
                            (Number n, _) =>
                               if Number.isZero n then rhs else keep ()
                          | (_, Number n) =>
                               if Number.isZero n then lhs else keep ()
                          | _ => keep ())
                   | _ => keep ()
               end
          | Call {args, func} => Call {args = simplifyExps args,
                                       func = simplifyExp func}
          | Cond {elsee, test, thenn} =>
               Cond {elsee = simplifyExp elsee,
                     test = simplifyExp test,
                     thenn = simplifyExp thenn}
          | Function {args, body, name} =>
               Function {args = args,
                         body = simplifyStatements body,
                         name = name}
          | Id _ => e
          | New {args, object} =>
               New {args = simplifyExps args, object = simplifyExp object}
          | Number _ => e
          | Null => e
          | Object ois =>
               Object (Vector.map
                       (fn oi =>
                        let
                           datatype z = datatype ObjectInit.t
                        in
                           case oi of
                              Get _ => oi
                            | Property {property, value} =>
                                 Property {property = property,
                                           value = simplifyExp value}
                            | Set _ => oi
                        end) ois)
          | Regexp _ => e
          | Seq es => Seq (Vector.map simplifyExp es)
          | Select {object, property} =>
               Select {object = simplifyExp object,
                       property = simplifyExp property}
          | SelectId {object, property} =>
               SelectId {object = simplifyExp object,
                         property = property}
          | String _ => e
          | Unary {exp, oper} =>
               let
                  val exp = simplifyExp exp
                  datatype z = datatype UnaryOp.t
               in
                  case oper of
                     LogicalNot => Exp.not exp
                   | _ => Unary {exp = exp, oper = oper}
               end
          | This => e
      and simplifyStatements ss = Vector.map simplifyStatement ss
      and simplifyStatementOpt so = Option.map simplifyStatement so
      and simplifyStatement (s: statement): statement =
         case s of
            Block ss => Block (simplifyStatements ss)
          | Break _ => s
          | Const ies =>
               Const (Vector.map (fn (i, e) => (i, simplifyExp e)) ies)
          | Continue _ => s
          | Do {body, test} => Do {body = simplifyStatement body,
                                   test = simplifyExp test}
          | Empty => s
          | Exp e => Exp (simplifyExp e)
          | For {body, inc, init, test} =>
               For {body = simplifyStatement body,
                    inc = simplifyExpOpt inc,
                    init = simplifyExpOpt init,
                    test = simplifyExpOpt test}
          | ForIn {body, lhs, object} =>
               ForIn {body = simplifyStatement body,
                      lhs = simplifyExp lhs,
                      object = simplifyExp object}
          | ForVar {body, inc, init, test} =>
               ForVar {body = simplifyStatement body,
                       inc = simplifyExpOpt inc,
                       init = Vector.map (fn (i, eo) =>
                                          (i, simplifyExpOpt eo)) init,
                       test = simplifyExpOpt test}
          | ForVarIn {body, id, init, object} =>
               ForVarIn {body = simplifyStatement body,
                         id = id,
                         init = simplifyExpOpt init,
                         object = simplifyExp object}
          | FunctionDec {args, body, name} =>
               FunctionDec {args = args,
                            body = Vector.map simplifyStatement body,
                            name = name}
          | If {elsee, test, thenn} =>
               let
                  val elsee = simplifyStatementOpt elsee
                  val test = simplifyExp test
                  val thenn = simplifyStatement thenn
               in
                  case (test, elsee) of
                     (Unary {exp, oper = UnaryOp.LogicalNot}, SOME elsee) =>
                        If {elsee = SOME thenn,
                            test = exp,
                            thenn = elsee}
                   | _ => If {elsee = elsee, test = test, thenn = thenn}
               end
          | Labeled (id, s) =>
               Labeled (id, simplifyStatement s)
          | Return eo =>
               Return (simplifyExpOpt eo)
          | Switch {clauses, test} =>
               Switch {clauses = Vector.map (fn (es, ss) =>
                                             (map simplifyExp es,
                                              simplifyStatements ss)) clauses,
                       test = simplifyExp test}
          | Throw e => Throw (simplifyExp e)
          | Try {body, catch, finally} =>
               Try {body = simplifyStatements body,
                    catch = Option.map (fn (i, ss) =>
                                        (i, simplifyStatements ss)) catch,
                    finally = Option.map simplifyStatements finally}
          | Var ies =>
               Var (Vector.map (fn (i, eo) => (i, simplifyExpOpt eo)) ies)
          | While {body, test} =>
               While {body = simplifyStatement body,
                      test = simplifyExp test}
          | With {body, object} =>
               With {body = simplifyStatement body,
                     object = simplifyExp object}
   end


structure ObjectInit =
   struct
      datatype t = datatype Joint.objectInit
   end

structure Statement =
   struct
      open Statement

      val layout = Joint.layoutStatement

      fun scope (s: t vector): t =
         Exp (Exp.Call {args = Vector.new0 (),
                        func = Exp.Function {args = Vector.new0 (),
                                             body = s,
                                             name = NONE}})
   end

structure Program =
   struct
      datatype t = T of Statement.t vector
      fun layout (T ss) = Joint.layoutStatements ss
      fun layouts (T ss, lay) = Vector.foreach (ss, lay o Statement.layout)
      fun simplify (T ss) = T (Joint.simplifyStatements ss)
   end
end
