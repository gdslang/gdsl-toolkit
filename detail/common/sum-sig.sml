(* Copyright (C) 2006-2007 SSH Communications Security, Helsinki, Finland
 *
 * This code is released under the MLton license, a BSD-style license.
 * See the LICENSE file or http://mlton.org/License for details.
 *)

(** A general purpose sum type. *)
signature SUM = sig
   datatype ('a, 'b) sum = INL of 'a | INR of 'b
   type ('a, 'b) t = ('a, 'b) sum
   exception Sum
   val swap : ('a, 'b) t -> ('b, 'a) t
end
