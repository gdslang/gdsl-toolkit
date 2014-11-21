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

type subst-map = Subst-map-empty



# substitute values in a given right hand side
#
# Parameters:
#   right hand side
#   size of read access
#   current subst map
#
# Returns:
#   right hand side with substituted values
#
export subst-rhs : (sem_expr, int, subst-map) -> sem_expr

val subst-rhs rhs size map = case map of
		Subst-map-empty : rhs
	end



# add an entry at write
#
# may only bind rhs to lhs if lhs does not occur in rhs
#
# Parameters:
#    left hand side
#    right hand side with substituted values
#    old subst map
#
# Returns:
#    new subst map
#
export add-entry : (sem_varl, sem_expr, subst-map) -> subst-map 

val add-entry lhs rhs map = map

