export = con_index{index} state_get select_succ_a{succ_a} select_succ_b{succ_b} select_insns{insns}
   select_ins_count{ins_count} select_live{live} select_initial{initial}
   select_after{after} select_hd{hd} select_tl{tl}

val con_index c = index c
val state_get = let
  val me x = x
in
  query me
end

val select_succ_a r = r.succ_a
val select_succ_b r = r.succ_b
val select_insns r = r.insns
val select_ins_count = query $ins_count
val select_live = query $live
val select_initial r = r.initial
val select_after r = r.after
val select_hd r = r.hd
val select_tl r = r.tl
#val select_args r = r.args
