export translate: (insndata) -> S sem_stmts <{} => {}>
export decode-translate-block: (decoder-configuration, int) -> S sem_stmts <{insns: insn_list_obj} => {insns: insn_list_obj}>
export decode-translate-block-insns: (decoder-configuration, int, (insn_list_obj, insndata) -> insn_list_obj) -> S sem_stmts <{insns: insn_list_obj} => {insns: insn_list_obj}>
#decode-translate-single{insns} decode-translate-super-block{insns} succ-pretty

val insn-append-default a b = a

val decode-translate-block-headless config limit insn-append = do
   insn <- decode config;
   insns <- query $insns;
   update @{insns=insn-append insns insn};
   translate-block-single insn;
   jmp <- query $foundJump;
   idx <- idxget;
   if jmp or (idx >= limit) then
     query $stack
   else
     decode-translate-block-headless config limit insn-append
end

val decode-translate-block config limit = do
  update @{ins_count=0,stack=SEM_NIL,foundJump='0'};
	stmts <- decode-translate-block-headless config limit insn-append-default;
  return (rreil-stmts-rev stmts)
end

val decode-translate-block-insns config limit insn-append = do
  update @{ins_count=0,stack=SEM_NIL,foundJump='0'};
	stmts <- decode-translate-block-headless config limit insn-append;
  return (rreil-stmts-rev stmts)
end

val decode-translate-single config = decode-translate-block config 0

val io a b = {a=a,b=b}
val io-to a = {a=a,b=IO_NONE}
val io-tw a = {a=a,b=a}

val relative-next-generic is_sem_ip stmts = let
  val raddress addr =
	  case addr.address of
		   SEM_LIN_ADD s:
			   case s.opnd1 of
				    SEM_LIN_VAR v:
						  if (is_sem_ip v.id) then
								case s.opnd2 of
								   SEM_LIN_IMM i: IO_SOME i.const
								 | _: IO_NONE
								end
						  else
                IO_NONE
				  | SEM_LIN_IMM i:
					    case s.opnd2 of
							   SEM_LIN_VAR v:
								   if (is_sem_ip v.id) then
									   IO_SOME i.const
									 else
                     IO_NONE
							 | _: IO_NONE
							end
				 end
		 | SEM_LIN_VAR v:
		     if (is_sem_ip v.id) then
				   IO_SOME 0
				 else
           IO_NONE
		 | _: IO_NONE
		end
in
  case stmts of
	   SEM_CONS x:
		   case x.hd of
			    SEM_CBRANCH b: io (raddress b.target-true) (raddress b.target-false)
				| SEM_BRANCH b: io-to (raddress b.target)
				| SEM_ITE c: io (relative-next (rreil-stmts-rev c.then_branch)).a (relative-next (rreil-stmts-rev c.else_branch)).a
			  | _: io-tw IO_NONE
			 end
	 | SEM_NIL: (io-tw IO_NONE)
	end
end

type stmts_option =
   SO_SOME of sem_stmts
 | SO_NONE

type translate-result = {insns:int, succ_a:int, succ_b:int}

val decode-translate-super-block-insncb config limit insn-append = let
  val translate-block-at idx = do
	  current <- idxget;
		#error <- rseek idx;
		error <- seek (current + idx);
		result <- if error === 0 then do
		  stmts <- decode-translate-block config int-max;
		  seek current;
			return (SO_SOME stmts)
		end else
		  return SO_NONE
		;
		return result
  end

  val seek-translate-block-at idx-opt = do
	  case idx-opt of
		   IO_SOME i: translate-block-at i
		 | IO_NONE: return SO_NONE
		end
	end
in do
  update @{ins_count=0,stack=SEM_NIL,foundJump='0'};
  stmts <- decode-translate-block-headless config limit insn-append;

  ic <- query $ins_count;

  succs <- return (relative-next stmts);
  succ_a <- seek-translate-block-at succs.a;
  succ_b <- seek-translate-block-at succs.b;

  update@{ins_count=ic};

  return {insns=(rreil-stmts-rev stmts), succ_a=succ_a, succ_b=succ_b}
end end

val decode-translate-super-block config limit = let
  val default-append a b = a
in
  decode-translate-super-block-insncb config limit default-append
end

val succ-pretty succ name =
  case succ of
	   SO_SOME i: "Succ " +++ (from-string-lit name) +++ ":\n" +++ (rreil-pretty i)
	 | SO_NONE: "Succ " +++ (from-string-lit name) +++ ": NONE :-("
	end
