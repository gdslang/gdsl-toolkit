export = decode-translate-block-optimized

type sem_preservation =
   SEM_PRESERVATION_EVERYWHERE
 | SEM_PRESERVATION_BLOCK
 | SEM_PRESERVATION_CONTEXT

val decode-translate-block-optimized config limit pres = case pres of
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

val decode-translate-block-optimized-int config limit pres = case pres of
   0: decode-translate-block-optimized config limit SEM_PRESERVATION_EVERYWHERE
 | 1: decode-translate-block-optimized config limit SEM_PRESERVATION_BLOCK
 | 2: decode-translate-block-optimized config limit SEM_PRESERVATION_CONTEXT
end
