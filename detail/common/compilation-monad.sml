
structure CompilationMonad : sig
   type state = Error.err_stream
   type 'answer t = state -> state * 'answer
   exception CompilationError

   val >>= : 'a t * ('a -> 'b t) -> 'b t
   val >> : 'a t * 'b t -> 'b t
   val return: 'a -> 'a t
   val run: state -> 'a t -> 'a
   val fail: 'a t
   val getState: state t
   val setState: state -> unit t
   val getErrorStream: Error.err_stream t

   (* add error messages to the error stream *)
   val error: string list -> unit t
   val errorAt: Error.span * string list -> unit t

   (* add warning messages to the error stream *)
   val warning: string list -> unit t
   val warningAt: Error.span * string list -> unit t

end = struct
   infix >> >>=

   type state = Error.err_stream
   type 'answer t = state -> state * 'answer

   exception CompilationError

   fun return v s = (s, v)
   fun getState s = (s, s)
   fun setState s _ = (s, ())
   val getErrorStream: Error.err_stream t = getState
   fun fail s = raise CompilationError

   fun aT >>= a2bT = fn s =>
      let
         val (s, a) =
            aT s
               handle CompilationError =>
                  (Error.report (TextIO.stdErr, s)
                  ;raise CompilationError)
         val () = Error.report (TextIO.stdErr, s)
      in
         if Error.anyErrors s
            then raise CompilationError
         else a2bT a s
      end
   fun const x _ = x
   fun aM >> bM = aM >>= const bM

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
      val (_, b) = action state
   in
      b
   end
end