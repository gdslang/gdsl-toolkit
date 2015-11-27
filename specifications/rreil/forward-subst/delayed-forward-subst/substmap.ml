

# remove a location from the subst-map
#
# Parameters:
#   current subst map
#   offset, size and register-id of write location
#
# Returns:
#   subst map without any occurrences of the linear
#
val substmap-remove-linear state offset size var-id =
   case state of
      Substmap-empty : state
    | Substmap-bind-linear l :
         if l.offset === offset and l.size === size and (id-eq? l.id var-id)
           then substmap-remove-linear l.cont offset size var-id
           else Substmap-bind-linear {offset=l.offset, size=l.size, id=l.id, rhs=l.rhs, cont=(substmap-remove-linear l.cont offset size var-id), inverted=l.inverted}  
    | Substmap-mark-overwritten l :
         if l.offset === offset and l.size === size and (id-eq? l.id var-id)
           then substmap-remove-linear l.cont offset size var-id
           else Substmap-mark-overwritten {offset=l.offset, size=l.size, id=l.id, cont=(substmap-remove-linear l.cont offset size var-id)}
   end



# update a location from the subst-map (removes existing and adds it then)
#
# Parameters:
#   current subst map
#   offset, size and register-id of write location
#
# Returns:
#   subst map with the updated/new added linear
#
val substmap-update-linear state offset size var-id sexpr =
   case state of
      Substmap-empty : Substmap-bind-linear {offset=offset, size=size, id=var-id, rhs=sexpr, cont=Substmap-empty, inverted=0} 
    | Substmap-bind-linear l :
         if l.offset === offset and l.size === size and (id-eq? l.id var-id)
           then substmap-update-linear l.cont offset size var-id sexpr
           else Substmap-bind-linear {offset=l.offset, size=l.size, id=l.id, rhs=l.rhs, cont=(substmap-update-linear l.cont offset size var-id sexpr), inverted=l.inverted}  
    | Substmap-mark-overwritten l :
         if l.offset === offset and l.size === size and (id-eq? l.id var-id)
           then substmap-update-linear l.cont offset size var-id sexpr
           else Substmap-mark-overwritten {offset=l.offset, size=l.size, id=l.id, cont=(substmap-update-linear l.cont offset size var-id sexpr)}
   end



val sexpr-uses-id v lin = case lin of
    SEM_SEXPR_LIN l : lin-uses-id v l
  | SEM_SEXPR_CMP e : cmp-uses-id v e.cmp
  | SEM_SEXPR_ARB   : '0'
  end
       
val cmp-uses-id v lin = case lin of
   SEM_CMPEQ    lr : lin-uses-id v lr.opnd1 or lin-uses-id v lr.opnd2
 | SEM_CMPNEQ    lr : lin-uses-id v lr.opnd1 or lin-uses-id v lr.opnd2
 | SEM_CMPLES    lr : lin-uses-id v lr.opnd1 or lin-uses-id v lr.opnd2
 | SEM_CMPLEU    lr : lin-uses-id v lr.opnd1 or lin-uses-id v lr.opnd2
 | SEM_CMPLTS    lr : lin-uses-id v lr.opnd1 or lin-uses-id v lr.opnd2
 | SEM_CMPLTU    lr : lin-uses-id v lr.opnd1 or lin-uses-id v lr.opnd2
 end
   
val lin-uses-id v lin = case lin of
    SEM_LIN_VAR   lr : id-eq? v lr.id
  | SEM_LIN_IMM   lr : '0'
  | SEM_LIN_ADD   lr : lin-uses-id v lr.opnd1 or lin-uses-id v lr.opnd2 
  | SEM_LIN_SUB   lr : lin-uses-id v lr.opnd1 or lin-uses-id v lr.opnd2 
  | SEM_LIN_SCALE lr : lin-uses-id v lr.opnd 
    end
