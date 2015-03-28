#
# substitution map, models a mapping
#
#   variable x offset x size -> expression
#
# that tells the valuations of registers at the current program point.
#
# For example, an assignment
#
# x.16 =:8 y+z
#
# will remove all existing entries spanning bits 16..23 of x from the substmap.
#
# Care has to be taken that all entries whose right hand side refer to the
# removed entries are also removed from the map.
#
# Also, self-referential updates like {ip=ip+1} must be handled correctly    
#
# most simple implementation:
#
#   type subst-map = Subst-map-empty
#
type subst-map = 
    Substmap-empty
  | Substmap-bind-linear of {offset:int, size:int, id:sem_id, rhs:sem_sexpr, cont:subst-map, inverted:int}
  | Substmap-mark-overwritten of {offset:int, size:int, id:sem_id, cont:subst-map}

val substmap-initial = Substmap-empty


# bind right hand side to a location
#
# Parameters:
#   current subst map
#   offset, size and register-id of write location
#   right hand side to be bound
#
# Returns:
#   subst map with right hand side bound to write location
#
export substmap-bind-sexpr : (subst-map, int, int, sem_id, sem_sexpr) -> subst-map
val substmap-bind-sexpr state offset size var linear
	= let val newSize = rreil-size-by-sexpr-type size linear 
		  val isInverted = 0
	in Substmap-bind-linear {offset=offset, size=newSize, id=var, rhs=linear, cont=state, inverted=isInverted}
	end  

export substmap-bind-sexpr-inverted : (subst-map, int, int, sem_id, sem_sexpr) -> subst-map
val substmap-bind-sexpr-inverted state offset size var linear
	= let val newSize = rreil-size-by-sexpr-type size linear 
		  val isInverted = 1
	in Substmap-bind-linear {offset=offset, size=newSize, id=var, rhs=linear, cont=state, inverted=isInverted}
	end  



# mark a location as overwritten.
#
# removes its binding and all bindings whose right hand side refers to
# this location
# 
# Parameters:
#   current subst map
#   offset, size and register-id of overwritten location
# 
# Returns:
#   subst map with removed bindings
#
export substmap-mark-overwritten : (subst-map, int, int, sem_id) -> subst-map
val substmap-mark-overwritten state offset size var = Substmap-mark-overwritten {offset=offset, size=size, id=var, cont=state}


type maybe-linear = Nothing-linear | Just-linear of sem_linear



type maybe-sexpr = Nothing-sexpr | Just-sexpr of sem_sexpr | Just-sexpr-inverted of sem_sexpr


# lookup binding for location
#
# Parameters:
#   current subst map
#   offset, size and var of location
#
# Returns:
#   linear expression that substitutes value at location
#
export substmap-var-to-lin: (subst-map, int, int, sem_id) -> sem_linear
val substmap-var-to-lin state offset size var = case substmap-lookup-var-to-linear state offset size var of
    Nothing-linear        : SEM_LIN_VAR {id=var, offset=offset}
  | Just-linear linear    : linear
	end
	
export substmap-var-to-sexpr: (subst-map, int, int, sem_id) -> sem_sexpr
val substmap-var-to-sexpr state offset size var = case substmap-lookup-var-to-sexpr state offset size var of
    Nothing-sexpr              : SEM_SEXPR_LIN (SEM_LIN_VAR {id=var, offset=offset})
  | Just-sexpr linear          : linear
  | Just-sexpr-inverted linear : SEM_SEXPR_LIN (SEM_LIN_VAR {id=var, offset=offset})
	end



export substmap-lookup-var-to-cond: (subst-map, int, sem_id) -> maybe-sexpr
val substmap-lookup-var-to-cond state offset var = substmap-lookup-var-to-sexpr state offset 1 var

 
# lookup binding for location, recursive worker function
#
# Parameters:
#   current subst map
#   offset, size and var of location
#
# Returns:
#   just the linear expression that substitutes value at location
#   or nothing (if binding is nonexisting or overwritten or if rhs
#   of binding refers to variables that are invalidated since then)  
#
export substmap-lookup-var-to-sexpr: (subst-map, int, int, sem_id) -> maybe-sexpr
val substmap-lookup-var-to-sexpr state offset size var = #Nothing-linear
 case state of
    Substmap-bind-linear      s :
    	if id-eq? var s.id
    	then (if size+offset <= s.offset or s.size+s.offset <= offset
    		then  checkOverwritten-sexpr s.offset s.size s.id size (substmap-lookup-var-to-sexpr s.cont offset size var) # checkoverwrites
    		else (if size+offset <= s.offset+s.size
    			then (if offset===s.offset
    				then (if s.inverted === 0
    						then Just-sexpr s.rhs
    						else Just-sexpr-inverted s.rhs)
    				else Nothing-sexpr)
    			else Nothing-sexpr))
    	else checkOverwritten-sexpr s.offset s.size s.id size (substmap-lookup-var-to-sexpr s.cont offset size var)
  | Substmap-mark-overwritten s :
      	if id-eq? var s.id
    	then (if size+offset <= s.offset or s.size+s.offset <= offset
    		then checkOverwritten-sexpr s.offset s.size s.id size (substmap-lookup-var-to-sexpr s.cont offset size var)  # checkoverwrites
    		else Nothing-sexpr)
    	else checkOverwritten-sexpr s.offset s.size s.id size (substmap-lookup-var-to-sexpr s.cont offset size var)
  |	Substmap-empty              : Nothing-sexpr
    end

# lookup binding for location, recursive worker function
#
# Parameters:
#   current subst map
#   offset, size and var of location
#
# Returns:
#   just the linear expression that substitutes value at location
#   or nothing (if binding is nonexisting or overwritten or if rhs
#   of binding refers to variables that are invalidated since then)  
#
export substmap-lookup-var-to-linear: (subst-map, int, int, sem_id) -> maybe-linear
val substmap-lookup-var-to-linear state offset size var = #Nothing-linear
 case state of
    Substmap-bind-linear      s :
    	if id-eq? var s.id
    	then (if size+offset <= s.offset or s.size+s.offset <= offset
    		then  checkOverwritten-linear s.offset s.size s.id size (substmap-lookup-var-to-linear s.cont offset size var) 
    		else (if size+offset <= s.offset+s.size
    			then (if offset===s.offset and s.inverted === 0
    				then case s.rhs of
    					SEM_SEXPR_LIN l : Just-linear l
    					| _ : Nothing-linear
    				end
    				else Nothing-linear)
    			else Nothing-linear))
    	else checkOverwritten-linear s.offset s.size s.id size (substmap-lookup-var-to-linear s.cont offset size var)
  | Substmap-mark-overwritten s :
      	if id-eq? var s.id
    	then (if size+offset <= s.offset or s.size+s.offset <= offset
    		then checkOverwritten-linear s.offset s.size s.id size (substmap-lookup-var-to-linear s.cont offset size var)  # checkoverwrites
    		else Nothing-linear)
    	else checkOverwritten-linear s.offset s.size s.id size (substmap-lookup-var-to-linear s.cont offset size var)
  |	Substmap-empty              : Nothing-linear
    end

 
 export checkOverwritten-sexpr : (int, int, sem_id, int, maybe-sexpr) -> maybe-sexpr
 val checkOverwritten-sexpr offset size var rhssize maybeRhs = case maybeRhs of
     Nothing-sexpr : maybeRhs
   | Just-sexpr l  : if sexpr-uses-location offset size var rhssize l
   		then Nothing-sexpr
   		else maybeRhs
   	end
 
 export checkOverwritten-linear : (int, int, sem_id, int, maybe-linear) -> maybe-linear
 val checkOverwritten-linear offset size var rhssize maybeRhs = case maybeRhs of
     Nothing-linear : maybeRhs
   | Just-linear l  : if lin-uses-location offset size var rhssize l
   		then Nothing-linear
   		else maybeRhs
   	end


export sexpr-uses-location : (int,int,sem_id, int,sem_sexpr) -> |1|
val sexpr-uses-location o s v rs lin = case lin of
    SEM_SEXPR_LIN l : lin-uses-location o s v rs l
  | SEM_SEXPR_CMP e : cmp-uses-location o e.size v rs e.cmp
  | SEM_SEXPR_ARB   : '0'
  end
       
export cmp-uses-location : (int,int,sem_id, int,sem_expr_cmp) -> |1|
val cmp-uses-location o s v rs lin = case lin of
   SEM_CMPEQ    lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2
 | SEM_CMPNEQ    lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2
 | SEM_CMPLES    lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2
 | SEM_CMPLEU    lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2
 | SEM_CMPLTS    lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2
 | SEM_CMPLTU    lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2
 end
   

export lin-uses-location : (int,int,sem_id, int,sem_linear) -> |1|
val lin-uses-location o s v rs lin = case lin of
    SEM_LIN_VAR   lr : id-eq? v lr.id and o+s> lr.offset and lr.offset+rs>o
  | SEM_LIN_IMM   lr : '0'
  | SEM_LIN_ADD   lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2 
  | SEM_LIN_SUB   lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2 
  | SEM_LIN_SCALE lr : lin-uses-location o s v rs lr.opnd 
    end
    
    
val show-substmap sm = case sm of
	Substmap-empty : ""
  | Substmap-bind-linear x : rreil-show-id x.id +++ "." +++ show-int x.offset +++ ":" +++ show-int x.size +++ " = " +++ rreil-show-sexpr x.rhs +++ " inv="+++show-int x.inverted+++ "\n" +++ show-substmap x.cont 
  | Substmap-mark-overwritten x : rreil-show-id x.id +++ "." +++ show-int x.offset +++ ":" +++ show-int x.size +++ " = <?>\n" +++ show-substmap x.cont
	end
