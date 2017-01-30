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
type df-subst-map = 
    SUBSTMAP_EMPTY
  | SUBSTMAP_LINEAR of {offset:int, size:int, id:sem_id, rhs:sem_expr, cont:df-subst-map}

val df-substmap-initial = SUBSTMAP_EMPTY


type df-maybe-linear = NOTHING_LINEAR | JUST_LINEAR of sem_linear
type df-maybe-expr = NOTHING_EXPR | JUST_EXPR of sem_expr


# lookup binding for location
#
# Parameters:
#   current subst map
#   offset, size and var of location
#
# Returns:
#   linear expression that substitutes value at location
#
val df-substmap-var-to-lin state offset size var = case df-substmap-lookup-var-to-linear state offset size var of
    NOTHING_LINEAR        : SEM_LIN_VAR {id=var, offset=offset}
  | JUST_LINEAR linear    : linear
  end
  
val df-substmap-var-to-expr state offset size var = case df-substmap-lookup-var-to-expr state offset size var of
    NOTHING_EXPR              : SEM_SEXPR (SEM_SEXPR_LIN (SEM_LIN_VAR {id=var, offset=offset}))
  | JUST_EXPR e          : e
  end



val df-substmap-lookup-var-to-cond state offset var = df-substmap-lookup-var-to-expr state offset 1 var

 
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
val df-substmap-lookup-var-to-expr state offset size var =
 case state of
    SUBSTMAP_LINEAR      s :
      if id-eq? var s.id
      then (if size+offset <= s.offset or s.size+s.offset <= offset
        then  df-substmap-lookup-var-to-expr s.cont offset size var
        else (if size+offset <= s.offset+s.size
          then (if offset===s.offset
            then JUST_EXPR s.rhs
            else NOTHING_EXPR)
          else NOTHING_EXPR))
      else df-substmap-lookup-var-to-expr s.cont offset size var
  | SUBSTMAP_EMPTY              : NOTHING_EXPR
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
val df-substmap-lookup-var-to-linear state offset size var =
 case state of
    SUBSTMAP_LINEAR      s :
      if id-eq? var s.id
      then (if size+offset <= s.offset or s.size+s.offset <= offset
        then df-substmap-lookup-var-to-linear s.cont offset size var
        else (if size+offset <= s.offset+s.size
          then (if offset===s.offset
            then case s.rhs of
               SEM_SEXPR sex: case sex of
                 SEM_SEXPR_LIN l : JUST_LINEAR l
                 | _ : NOTHING_LINEAR
               end
             | _: NOTHING_LINEAR
            end
            else NOTHING_LINEAR)
          else NOTHING_LINEAR))
      else df-substmap-lookup-var-to-linear s.cont offset size var
  | SUBSTMAP_EMPTY              : NOTHING_LINEAR
    end

val df-expr-uses-location o s v rs lin =
  case lin of
     SEM_SEXPR se:
       case se of
           SEM_SEXPR_LIN l : df-lin-uses-location o s v rs l
         | SEM_SEXPR_CMP e : df-cmp-uses-location o e.size v rs e.cmp
         | SEM_SEXPR_ARB   : '0'
   end
  end
       
val df-cmp-uses-location o s v rs lin = case lin of
   SEM_CMPEQ    lr : df-lin-uses-location o s v rs lr.opnd1 or df-lin-uses-location o s v rs lr.opnd2
 | SEM_CMPNEQ    lr : df-lin-uses-location o s v rs lr.opnd1 or df-lin-uses-location o s v rs lr.opnd2
 | SEM_CMPLES    lr : df-lin-uses-location o s v rs lr.opnd1 or df-lin-uses-location o s v rs lr.opnd2
 | SEM_CMPLEU    lr : df-lin-uses-location o s v rs lr.opnd1 or df-lin-uses-location o s v rs lr.opnd2
 | SEM_CMPLTS    lr : df-lin-uses-location o s v rs lr.opnd1 or df-lin-uses-location o s v rs lr.opnd2
 | SEM_CMPLTU    lr : df-lin-uses-location o s v rs lr.opnd1 or df-lin-uses-location o s v rs lr.opnd2
 end
   

val df-lin-uses-location o s v rs lin = case lin of
    SEM_LIN_VAR   lr : id-eq? v lr.id and o+s> lr.offset and lr.offset+rs>o
  | SEM_LIN_IMM   lr : '0'
  | SEM_LIN_ADD   lr : df-lin-uses-location o s v rs lr.opnd1 or df-lin-uses-location o s v rs lr.opnd2 
  | SEM_LIN_SUB   lr : df-lin-uses-location o s v rs lr.opnd1 or df-lin-uses-location o s v rs lr.opnd2 
  | SEM_LIN_SCALE lr : df-lin-uses-location o s v rs lr.opnd 
    end
    
    
val df-show-substmap sm = case sm of
    SUBSTMAP_EMPTY : ""
  | SUBSTMAP_LINEAR x : rreil-show-id x.id +++ "." +++ show-int x.offset +++ ":" +++ show-int x.size +++ " = " +++ rreil-show-expr x.rhs +++ "\n" +++ df-show-substmap x.cont 
  end


val df-expr-uses-id v lin =
  case lin of
    SEM_SEXPR se:
      case se of
         SEM_SEXPR_LIN l : df-lin-uses-id v l
       | SEM_SEXPR_CMP e : df-cmp-uses-id v e.cmp
       | SEM_SEXPR_ARB   : '0'
    end
  end
       
val df-cmp-uses-id v lin = case lin of
   SEM_CMPEQ    lr : df-lin-uses-id v lr.opnd1 or df-lin-uses-id v lr.opnd2
 | SEM_CMPNEQ    lr : df-lin-uses-id v lr.opnd1 or df-lin-uses-id v lr.opnd2
 | SEM_CMPLES    lr : df-lin-uses-id v lr.opnd1 or df-lin-uses-id v lr.opnd2
 | SEM_CMPLEU    lr : df-lin-uses-id v lr.opnd1 or df-lin-uses-id v lr.opnd2
 | SEM_CMPLTS    lr : df-lin-uses-id v lr.opnd1 or df-lin-uses-id v lr.opnd2
 | SEM_CMPLTU    lr : df-lin-uses-id v lr.opnd1 or df-lin-uses-id v lr.opnd2
 end
   
val df-lin-uses-id v lin = case lin of
    SEM_LIN_VAR   lr : id-eq? v lr.id
  | SEM_LIN_IMM   lr : '0'
  | SEM_LIN_ADD   lr : df-lin-uses-id v lr.opnd1 or df-lin-uses-id v lr.opnd2 
  | SEM_LIN_SUB   lr : df-lin-uses-id v lr.opnd1 or df-lin-uses-id v lr.opnd2 
  | SEM_LIN_SCALE lr : df-lin-uses-id v lr.opnd 
    end


# remove a location from the subst-map
#
# Parameters:
#   current subst map
#   offset, size and register-id of write location
#
# Returns:
#   subst map without any occurrences of the linear
#
val df-substmap-remove-linear state offset size var-id =
   case state of
      SUBSTMAP_EMPTY : state
    | SUBSTMAP_LINEAR l :
         if l.offset === offset and l.size === size and (id-eq? l.id var-id)
           then df-substmap-remove-linear l.cont offset size var-id
           else SUBSTMAP_LINEAR {offset=l.offset, size=l.size, id=l.id, rhs=l.rhs, cont=(df-substmap-remove-linear l.cont offset size var-id)}  
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
val df-substmap-update-linear state offset size var-id expr =
   case state of
      SUBSTMAP_EMPTY : SUBSTMAP_LINEAR {offset=offset, size=size, id=var-id, rhs=expr, cont=SUBSTMAP_EMPTY, inverted=0} 
    | SUBSTMAP_LINEAR l :
         if l.offset === offset and l.size === size and (id-eq? l.id var-id)
           then df-substmap-update-linear l.cont offset size var-id expr
           else SUBSTMAP_LINEAR {offset=l.offset, size=l.size, id=l.id, rhs=l.rhs, cont=(df-substmap-update-linear l.cont offset size var-id expr)}  
   end
