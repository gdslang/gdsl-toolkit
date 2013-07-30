export = con_index state_get select_succ_a select_succ_b select_insns select_ins_count select_live select_initial select_after

val con_index c = index c
val state_get = let
  val me x = x
in
  query me
end

val select_succ_a r = r.succ_a
val select_succ_b r = r.succ_b
val select_insns r = r.insns
val select_ins_count r = r.ins_count
val select_live r = r.live
val select_initial r = r.initial
val select_after r = r.after
