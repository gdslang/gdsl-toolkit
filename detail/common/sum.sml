(* Copyright (C) 2006-2007 SSH Communications Security, Helsinki, Finland
 *
 * This code is released under the MLton license, a BSD-style license.
 * See the LICENSE file or http://mlton.org/License for details.
 *)

structure Sum : SUM = struct
   datatype ('a, 'b) sum = INL of 'a | INR of 'b
   type ('a, 'b) t = ('a, 'b) sum
   exception Sum
   val swap = fn INL x => INR x | INR x => INL x
end
