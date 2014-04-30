export = pretty-arch-id pretty-arch-exception

val arch-show-id r =
  case r of
	   Sem_ALL: "memory"
	 | Sem_PC: "PC"
	 | Sem_PM: "PM"
	end

val pretty-arch-id r = arch-show-id r

val arch-show-exception exception = case 0 of 1: "" end

val pretty-arch-exception exception = arch-show-exception exception
