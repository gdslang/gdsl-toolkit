
structure Pretty = struct
   structure PP = PPDescFn (PPStreamFn
      (structure Token = StringToken
       structure Device = SimpleTextIODev))
   open PP
   val comma = token ","
   val lp = token "("
   val rp = token ")"
   val lb = token "{"
   val rb = token "}"
   val int = token o IntInf.toString
   fun tuple2 (pa, pb) (a, b) =
      hBox [lp, pa a, comma, pb b, rp]
   fun tuple3 (pa, pb, pc) (a, b, c) =
      hBox [lp, pa a, comma, pb b, comma, pc c, rp]
   fun pretty desc = let
      val os =
         PP.PPS.openStream
            (SimpleTextIODev.openDev {dst=TextIO.stdOut, wid=79})
   in
      PP.description (os, desc)
   end
end