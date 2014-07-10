(* stream-pos.sml
 *
 * COPYRIGHT (c) 2006
 * John Reppy (http://www.cs.uchicago.edu/~jhr)
 * Aaron Turon (http://www.cs.uchicago.edu/~adrassi)
 * All rights reserved.
 *
 * Very simple position tracking and source maps for ml-ulex/ml-antlr
 *)

structure AntlrStreamPos :> sig

  type pos = Position.int
  type span = pos * pos
  type sourceloc = { fileName : string option, lineNo : int, colNo : int }
  type sourcemap

  exception PosMustIncrease

  (* the result of moving forward an integer number of characters *)
  val forward : pos * int -> pos

  val mkSourcemap  : unit   -> sourcemap
  val mkSourcemap' : string -> sourcemap

  val same : sourcemap * sourcemap -> bool

  (* log a new line occurence *)
  val markNewLine : sourcemap -> pos -> unit
  (* resychronize to a full source location *)
  val resynch     : sourcemap -> pos * sourceloc -> unit

  val sourceLoc	: sourcemap -> pos -> sourceloc
  val fileName	: sourcemap -> pos -> string option
  val lineNo	: sourcemap -> pos -> int
  val colNo	: sourcemap -> pos -> int
  val toString	: sourcemap -> pos -> string
  val spanToString : sourcemap -> span -> string

end = struct

  type pos = Position.int
  type span = pos * pos
  type sourceloc = { fileName : string option, lineNo : int, colNo : int }
  type sourcemap = (sourceloc * pos) list ref

  exception PosMustIncrease

  fun forward (p, i) = p + (Position.fromInt i)

  fun mkSrcMap fileOpt = ref [
	  ({fileName = fileOpt, lineNo = 1, colNo = 0}, Position.fromInt ~1)
	]

  fun mkSourcemap () = mkSrcMap NONE
  fun mkSourcemap' (fname) = mkSrcMap (SOME fname)

  fun same (sm1 : sourcemap, sm2) = (sm1 = sm2)

  fun markNewLine sm (newPos : pos) = let
        val ({fileName, lineNo, colNo}, pos) = hd (!sm)
        in
          if pos < newPos then
	    sm := ({ fileName = fileName,
		     lineNo = lineNo + 1,
		     colNo = 0}, 
		   newPos)::(!sm)
	  else () (* raise PosMustIncrease *)
        end

  fun resynch sm (newPos : pos, sourceLoc) = let
        val (_, pos) = hd (!sm)
        in
(*          if pos < newPos then *)
	    sm := (sourceLoc, newPos)::(!sm)
(*	  else raise PosMustIncrease *)
        end

  fun findLB ((loc, pos)::sm, pos' : pos) = 
        if pos <= pos' then (loc, pos)
	else findLB(sm, pos')
    | findLB _ = raise Fail "impossible"

  fun sourceLoc sm pos = let 
        val ({fileName, lineNo, colNo}, anchor) = findLB(!sm, pos)
        in
          {fileName = fileName, lineNo = lineNo, 
	   colNo = colNo + Position.toInt(pos - anchor)}
        end
  fun fileName sm pos = #fileName (sourceLoc sm pos)
  fun lineNo   sm pos = #lineNo   (sourceLoc sm pos)
  fun colNo    sm pos = #colNo    (sourceLoc sm pos)
  fun toString sm pos = String.concat [
	"[", case fileName sm pos
	      of NONE => ""
	       | SOME f => f ^ ":",
	     Int.toString (lineNo sm pos), ".",
	     Int.toString (colNo  sm pos), "]"]
  fun spanToString sm (pos1, pos2) = 
        if lineNo sm pos1 = lineNo sm pos2 andalso
	   colNo  sm pos1 = colNo  sm pos2 
	then toString sm pos1
	else String.concat [
  	  "[", case fileName sm pos1
	        of NONE => ""
	         | SOME f => f ^ ":",
	       Int.toString (lineNo sm pos1), ".",
	       Int.toString (colNo  sm pos1), "-",
	       Int.toString (lineNo sm pos2), ".",
	       Int.toString (colNo  sm pos2), "]"]

end
