export = liveness liveness_super

val liveness instructions = do
  live-registers <- registers-live-map;
  lv-state <- lv-analyze live-registers (rreil-stmts-rev instructions);
  return lv-state.greedy 
end

type lv-super-result = {initial:stmts_option, after:int}

val liveness_super data = let
  val lv-option-analyze live-registers option =
	  case option of
		   SO_SOME stmts: do
			   state <- lv-analyze live-registers (rreil-stmts-rev stmts);
				 return state.greedy
			 end
		 | SO_NONE: return (fmap-empty {})
		end

	val lv-some-succ live-registers = do
    lv-succ-a <- lv-option-analyze live-registers data.succ_a;
    lv-succ-b <- lv-option-analyze live-registers data.succ_b;
		return (lv-union lv-succ-a lv-succ-b)
	end
in do
  live-registers <- registers-live-map;
	live-registers <-
	  case data.succ_a of
		   SO_NONE:
		  	  case data.succ_b of
	  	 		   SO_NONE: return live-registers
	  	 		 | SO_SOME a: lv-some-succ live-registers
	  	 	  end
		 | SO_SOME a: lv-some-succ live-registers
		end
	;
  lv-state <- lv-analyze live-registers (rreil-stmts-rev data.insns);
  return {initial=live-registers, after=lv-state.greedy}
end end
