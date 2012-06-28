
structure CompilationMonad : sig
   type state = Error.err_stream
   type 'answer t = state -> 'answer * state
   exception CompilationError

   val >>= : 'a t * ('a -> 'b t) -> 'b t
   val >> : 'a t * 'b t -> 'b t
   val return: 'a -> 'a t
   val run: state -> 'a t -> 'a
   val mapM : ('a -> 'b t) -> 'a list -> ('b list) t
   
   val fail: 'a t
   val getState: state t
   val setState: state -> unit t
   val getErrorStream: Error.err_stream t
   val setErrorStream: Error.err_stream -> unit t

   (* add error messages to the error stream *)
   val error: string list -> unit t
   val errorAt: Error.span * string list -> unit t

   (* add warning messages to the error stream *)
   val warning: string list -> unit t
   val warningAt: Error.span * string list -> unit t

end = struct
   infix >> >>=

   type state = Error.err_stream
   type 'answer t = state -> 'answer * state

   exception CompilationError
   exception Fail of state

   fun return v s = (v, s)
   fun getState s = (s, s)
   fun setState s _ = ((), s)
   val getErrorStream: Error.err_stream t = getState
   fun setErrorStream ers s =
      if Error.anyErrors s
            then (TextIO.print ("setErrorStream"); (Error.report (TextIO.stdErr, s), ers)
               )
      else ((), ers)

   fun fail s = raise Fail s

   fun aT >>= a2bT = fn s =>
      let
         val (a, s) =
            aT s
      in
         if Error.anyErrors s
            then raise Fail s
         else a2bT a s
      end
   fun const x _ = x
   fun aM >> bM = aM >>= const bM
   fun mapM f xs = case xs of
        [] => return []
      | (x :: xs) =>
         f x >>= (fn r =>
         mapM f xs >>= (fn rs =>
         return (r :: rs)))

   fun liftErr f a =
      getErrorStream >>= (fn errs =>
      return (f (errs, a)))
   fun liftErr2 f (a, b) =
      getErrorStream >>= (fn errs =>
      return (f (errs, a, b)))

   val error = liftErr Error.error
   val errorAt = liftErr2 Error.errorAt
   val warning = liftErr Error.warning
   val warningAt = liftErr2 Error.warningAt

   fun run state action = let
      val (b, s) = action state
         handle Fail s =>
            (Error.report (TextIO.stdErr, s)
            ;raise CompilationError)
   in
      if Error.anyErrors s
            then (Error.report (TextIO.stdErr, s)
                 ;raise CompilationError)
      else b
   end
end
