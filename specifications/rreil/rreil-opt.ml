export = translateBlockOptimized

type sem_preservation =
   SEM_PRESERVATION_EVERYWHERE
 | SEM_PRESERVATION_BLOCK
 | SEM_PRESERVATION_CONTEXT

val translateBlockOptimized config limit pres = case pres of
   SEM_PRESERVATION_EVERYWHERE: do
     translated <- translateBlock config limit;
     clean <- cleanup translated;
     return clean
   end
 | SEM_PRESERVATION_BLOCK: do
     translated <- translateBlock config limit;
     lv-result <- liveness translated;
     live <- query $live;
     clean <- cleanup live;
     return clean
   end
 | SEM_PRESERVATION_CONTEXT: do
     translated <- translateSuperBlock config limit;
     lv-result <- liveness_super translated;
     live <- query $live;
     clean <- cleanup live;
     return clean
   end
end
