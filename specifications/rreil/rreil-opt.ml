export decode-translate-block-optimized: (decoder-configuration, int, int) -> S sem_stmt_list <{} => {}>
export decode-translate-block-optimized-insncb: (decoder-configuration, int, int, insn_list_obj, (insn_list_obj, insndata) -> insn_list_obj) -> S opt-result <{} => {}>

type sem_preservation =
   SEM_PRESERVATION_EVERYWHERE
 | SEM_PRESERVATION_BLOCK
 | SEM_PRESERVATION_CONTEXT

val decode-translate-block-optimized-insncb-inner config limit pres insn-append = case pres of
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
     translated <- decode-translate-super-block-insncb config limit insn-append;
     lv-result <- liveness_super translated;
     live <- query $live;
     clean <- cleanup live;
     return clean
   end
end

val decode-translate-block-optimized-inner config limit pres = let
  val default-append a b = a
in
  decode-translate-block-optimized-insncb-inner config limit pres default-append
end

type opt-result = {
  insns: insn_list_obj,
  rreil: sem_stmt_list
}

val decode-translate-block-optimized-insncb config limit pres insns-initv insn-append = do
#  limit <- return (limit + 0);
#  pres <- return (pres + 0);

  update @{insns=insns-initv};
  rreil <- case pres of
     0: decode-translate-block-optimized-insncb-inner config limit SEM_PRESERVATION_EVERYWHERE insn-append
   | 1: decode-translate-block-optimized-insncb-inner config limit SEM_PRESERVATION_BLOCK insn-append
   | 2: decode-translate-block-optimized-insncb-inner config limit SEM_PRESERVATION_CONTEXT insn-append
  end;
  insns <- query $insns;
  return {rreil=rreil, insns=insns}
end

val decode-translate-block-optimized config limit pres = let
  val default-append a b = a
in do
  result <- decode-translate-block-optimized-insncb config limit pres INSN_LIST_OBJ default-append;
  return result.rreil
end end

type insn_list_obj = INSN_LIST_OBJ
