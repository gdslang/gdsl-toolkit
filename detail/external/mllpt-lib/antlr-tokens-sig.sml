(* antlr-tokens-sig.sml
 *
 * COPYRIGHT (c) 2006
 * John Reppy (http://www.cs.uchicago.edu/~jhr)
 * Aaron Turon (http://www.cs.uchicago.edu/~adrassi)
 * All rights reserved.
 *
 * Signature for generated tokens module, for ml-antlr
 *)

signature ANTLR_TOKENS = sig

  type token
  
  val allToks : token list
  val isKW    : token -> bool
  val isEOF   : token -> bool
  val toString : token -> string

end