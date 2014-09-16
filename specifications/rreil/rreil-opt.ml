export decode-translate-block-optimized: (decoder-configuration, int, optimization-configuration) -> S opt-result <{} => {}>
export traverse-insn-list: (insn_list, insn_list_obj, (insn_list_obj, insndata) -> insn_list_obj) -> insn_list_obj
export optimization-config : configuration[vec=optimization-configuration]

type optimization-configuration = |2|

val optimization-config =
  conf '00' "block"    "translate a basic block at a time" &*
  conf '01' "liveness" "remove dead assignments" &*
  conf '10' "inter-bb" "perform inter-basic block liveness analysis"

type insn_list_obj = INSN_LIST_OBJ

type insn_list =
   INSNS_CONS of {insn:insndata, tl:insn_list}
 | INSNS_NIL

val traverse-insn-list l init insn-append = case l of
   INSNS_CONS cons: insn-append (traverse-insn-list cons.tl init insn-append) cons.insn
 | INSNS_NIL: init
end

type sem_preservation =
   SEM_PRESERVATION_EVERYWHERE
 | SEM_PRESERVATION_BLOCK
 | SEM_PRESERVATION_CONTEXT

val decode-translate-block-optimized-inner config limit pres = case pres of
   SEM_PRESERVATION_EVERYWHERE: do
     translated <- decode-translate-block config limit;
     clean <- cleanup translated;
     return clean
   end
 | SEM_PRESERVATION_BLOCK: do
     translated <- decode-translate-block config limit;
     lv-result <- liveness translated;
     live <- query $live;
     clean <- cleanup live;
     return clean
   end
 | SEM_PRESERVATION_CONTEXT: do
     translated <- decode-translate-super-block config limit;
     lv-result <- liveness_super translated;
     live <- query $live;
     clean <- cleanup live;
     return clean
   end
end


type opt-result = {
  insns: insn_list,
  rreil: sem_stmt_list
}

val decode-translate-block-optimized config limit opt-config = do
  update @{insns=INSNS_NIL};
  rreil <- case opt-config of
     '00': decode-translate-block-optimized-inner config limit SEM_PRESERVATION_EVERYWHERE
   | '01': decode-translate-block-optimized-inner config limit SEM_PRESERVATION_BLOCK
   | '10': decode-translate-block-optimized-inner config limit SEM_PRESERVATION_CONTEXT
  end;
  insns <- query $insns;
  return {rreil=rreil, insns=insns}
end
