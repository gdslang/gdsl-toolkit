val arch-show-id r =
  case r of
	   Sem_ALL: "memory"
	 | Sem_PC: "PC"
	 | Sem_PM: "PM"
	end

val arch-show-exception exception = case 0 of 1: "" end
