export pretty-arch-id: (sem_id) -> rope
export pretty-arch-exception: (sem_exception) -> rope

val arch-show-id r =
  case r of
	   Sem_ALL: "memory"
	 | Sem_PC: "PC"
	 | Sem_PM: "PM"
	end

val pretty-arch-id r = arch-show-id r

val pretty-arch-exception exception = case 0 of 1: "" end
