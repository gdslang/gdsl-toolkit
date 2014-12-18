export decode-translate-block-optimized: (decoder-configuration, int, optimization-configuration) -> S opt-result <{} => {}>
export traverse-insn-list: (insn_list, insn_list_obj, (insn_list_obj, insndata) -> insn_list_obj) -> insn_list_obj
export optimization-config : configuration[vec=optimization-configuration]

type optimization-configuration = |5|

val optimization-config =
  conf '00001' "preserve-insn"  "instruction-wise optimizations" &*
  conf '00010' "liveness-block" "perform liveness analysis per basic block " &*
  conf '00100' "liveness-inter" "perform inter-basic block liveness analysis" &*
  conf '01000' "propagate-block" "in-block forward propagation of constants and simple expressions" &*
  conf '10000' "propagate-inter" "in-block forward propagation with inter-block liveness"

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

val decode-translate-block-optimized-preserve config limit pres do-propagate= case pres of
   SEM_PRESERVATION_EVERYWHERE: do
     translated <- decode-translate-block config limit;
     clean <- cleanup translated;
     #foot 10;
     return clean
   end
 | SEM_PRESERVATION_BLOCK: do
     translated <- decode-translate-block config limit;
     propagated <- propagate do-propagate translated;
     lv-result <- liveness propagated;
     live <- query $live;
     clean <- cleanup live;
     return clean
   end
 | SEM_PRESERVATION_CONTEXT: do
     translated <- decode-translate-super-block config limit;
     propagated <- propagate-contextful do-propagate translated;
     lv-result <- liveness_super propagated;
     live <- query $live;
     clean <- cleanup live;
     return clean
   end
end

val propagate-contextful do-propagate translated 
	= do insns-p <- propagate do-propagate translated.insns;
		return {insns=insns-p, succ_a=translated.succ_a, succ_b=translated.succ_b}
		end

val propagate do-propagate translated = case do-propagate of 
     	  '1' : do	#println "-------------------";
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
     '00000': decode-translate-block config limit
   | '00001': decode-translate-block-optimized-preserve config limit SEM_PRESERVATION_EVERYWHERE '0'
   | '0001.': decode-translate-block-optimized-preserve config limit SEM_PRESERVATION_BLOCK '0'
   | '001..': decode-translate-block-optimized-preserve config limit SEM_PRESERVATION_CONTEXT '0'
   | '01...': decode-translate-block-optimized-preserve config limit SEM_PRESERVATION_BLOCK '1'
   | '1....': decode-translate-block-optimized-preserve config limit SEM_PRESERVATION_CONTEXT '1'
  end;
  insns <- query $insns;
  return {rreil=rreil, insns=insns}
end
