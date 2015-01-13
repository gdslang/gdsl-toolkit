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
  | Substmap-bind-linear of {offset:int, size:int, id:sem_id, rhs:sem_linear, cont:subst-map}
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
export substmap-bind-linear : (subst-map, int, int, sem_id, sem_linear) -> subst-map
val substmap-bind-linear state offset size var linear = Substmap-bind-linear {offset=offset, size=size, id=var, rhs=linear, cont=state}  



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
val substmap-var-to-lin state offset size var = case substmap-lookup-var state offset size var of
    Nothing-linear     : SEM_LIN_VAR {id=var, offset=offset}
  | Just-linear linear : linear
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
export substmap-lookup-var: (subst-map, int, int, sem_id) -> maybe-linear
val substmap-lookup-var state offset size var = #Nothing-linear
 case state of
    Substmap-bind-linear      s :
    	if id-eq? var s.id
    	then (if size+offset <= s.offset or s.size+s.offset <= offset
    		then  checkOverwritten s.offset s.size s.id size (substmap-lookup-var s.cont offset size var) # checkoverwrites
    		else (if size+offset <= s.offset+s.size
    			then (if offset===s.offset
    				then Just-linear s.rhs
    				else Nothing-linear)
    			else Nothing-linear))
    	else checkOverwritten s.offset s.size s.id size (substmap-lookup-var s.cont offset size var)
  | Substmap-mark-overwritten s :
      	if id-eq? var s.id
    	then (if size+offset <= s.offset or s.size+s.offset <= offset
    		then checkOverwritten s.offset s.size s.id size (substmap-lookup-var s.cont offset size var)  # checkoverwrites
    		else Nothing-linear)
    	else checkOverwritten s.offset s.size s.id size (substmap-lookup-var s.cont offset size var)
  |	Substmap-empty              : Nothing-linear
    end

 
 export checkOverwritten : (int, int, sem_id, int, maybe-linear) -> maybe-linear
 val checkOverwritten offset size var rhssize maybeRhs = case maybeRhs of
     Nothing-linear : maybeRhs
   | Just-linear l  : if lin-uses-location offset size var rhssize l
   		then Nothing-linear
   		else maybeRhs
   	end

export lin-uses-location : (int,int,sem_id, int,sem_linear) -> |1|
val lin-uses-location o s v rs lin = case lin of
    SEM_LIN_VAR   lr : id-eq? v lr.id and o+s> lr.offset and lr.offset+rs>o
  | SEM_LIN_IMM   lr : '0'
  | SEM_LIN_ADD   lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2 
  | SEM_LIN_SUB   lr : lin-uses-location o s v rs lr.opnd1 or lin-uses-location o s v rs lr.opnd2 
  | SEM_LIN_SCALE lr : lin-uses-location o s v rs lr.opnd 
    end
