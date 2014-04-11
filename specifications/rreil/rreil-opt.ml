export = decode-translate-block-optimized{insns} decode-translate-block-optimized-int{insns}

type sem_preservation =
   SEM_PRESERVATION_EVERYWHERE
 | SEM_PRESERVATION_BLOCK
 | SEM_PRESERVATION_CONTEXT

val decode-translate-block-optimized config limit pres insn-append = case pres of
   SEM_PRESERVATION_EVERYWHERE: do
     translated <- decode-translate-block-insns config limit insn-append;
     clean <- cleanup translated;
     return clean
   end
 | SEM_PRESERVATION_BLOCK: do
     translated <- decode-translate-block-insns config limit insn-append;
     lv-result <- liveness translated;
     live <- query $live;
     clean <- cleanup live;
     return clean
   end
 | SEM_PRESERVATION_CONTEXT: do
     translated <- decode-translate-super-block config limit insn-append;
     lv-result <- liveness_super translated;
     live <- query $live;
     clean <- cleanup live;
     return clean
   end
end

type opt_result = {
  insns:int, rreil:sem_stmts
}

val decode-translate-block-optimized-int config limit pres insns-initv insn-append = do
  update @{insns=insns-initv};
  rreil <- case pres of
     0: decode-translate-block-optimized config limit SEM_PRESERVATION_EVERYWHERE insn-append
   | 1: decode-translate-block-optimized config limit SEM_PRESERVATION_BLOCK insn-append
   | 2: decode-translate-block-optimized config limit SEM_PRESERVATION_CONTEXT insn-append
  end;
  insns <- query $insns;
  return {rreil=rreil, insns=insns}
end
