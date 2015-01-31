export decode-translate-block-optimized: (decoder-configuration, int, optimization-configuration) -> S opt-result <{} => {}>
export traverse-insn-list: (insn_list, insn_list_obj, (insn_list_obj, insndata) -> insn_list_obj) -> insn_list_obj
export optimization-config : configuration[vec=optimization-configuration]

type optimization-configuration = |5|

val optimization-config =
  conf '00001' "preserve"  "instruction-wise optimizations" &*
  conf '00010' "block"  "basic block-wise optimizations" &*
  conf '00100' "inter"  "inter basic block-wise optimizations" &*
  conf '01000' "liveness"  "liveness optimization" &*
  conf '10000' "fsubst"  "forward propagation of constants and simple expressions"

#  conf '00001' "preserve"  "instruction-wise optimizations" &*
#  conf '00010' "liveness-block" "liveness analysis per basic block " &*
#  conf '00100' "liveness-inter" "inter basic block liveness analysis" &*
#  conf '01000' "propagate-block" "per basic block forward propagation of constants and simple expressions" &*
#  conf '10000' "propagate-inter" "inter basic block forward propagation with inter basic block liveness"

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

val decode-translate-block-optimized-preserve config limit pres do-propagate lv = case pres of
   SEM_PRESERVATION_EVERYWHERE: do
     translated <- decode-translate-block config limit;
     clean <- cleanup translated;
     #foot 10;
     return clean
   end
 | SEM_PRESERVATION_BLOCK: do
     translated <- decode-translate-block config limit;
     translated <- propagate do-propagate translated;
     translated <- if lv then do
       lv-result <- liveness translated;
       query $live
     end else
       return translated
     ;
     clean <- cleanup translated;
     return clean
   end
 | SEM_PRESERVATION_CONTEXT: do
     translated <- decode-translate-super-block config limit;
     translated <- propagate-contextful do-propagate translated;
     translated <- if lv then do
       lv-result <- liveness_super translated;
       query $live
     end else
       return ($insns translated)
     ;
     clean <- cleanup translated;
     return clean
   end
end

val propagate-contextful do-propagate translated 
  = do insns-p <- propagate do-propagate translated.insns;
    return {insns=insns-p, succ_a=translated.succ_a, succ_b=translated.succ_b}
    end

val propagate do-propagate translated = case do-propagate of 
        '1' : do  #println "-------------------";
              #println "translated:";
            #println (rreil-pretty translated);
            #println "-------------------";
              #println "propagating...";
              p <- return (propagate-values translated);
          #println "-------------------";
            #println "after propagation";
            #println (rreil-pretty p);
            #println "-------------------";
            #println "doing liveness optimization...";
            return p
            end
      | '0' : return translated
      end

#val foot i = case i of 0 : return 0 | j : do println (show-int j);foot(i - 1) end end 

type opt-result = {
  insns: insn_list,
  rreil: sem_stmt_list
}

val decode-translate-block-optimized config limit opt-config = do
  update @{insns=INSNS_NIL};
  rreil <- case opt-config of
     'fs:1 lv:1 000': decode-translate-block config limit
   | 'fs:1 lv:1 001': decode-translate-block-optimized-preserve config limit SEM_PRESERVATION_EVERYWHERE fs lv
   | 'fs:1 lv:1 01.': decode-translate-block-optimized-preserve config limit SEM_PRESERVATION_BLOCK fs lv
   | 'fs:1 lv:1 1..': decode-translate-block-optimized-preserve config limit SEM_PRESERVATION_CONTEXT fs lv
  end;
  insns <- query $insns;
  return {rreil=rreil, insns=insns}
end
