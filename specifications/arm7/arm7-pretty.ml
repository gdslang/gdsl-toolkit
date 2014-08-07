# vim:ts=3:sw=3:expandtab

export pretty : (insndata) -> rope

val pretty i = show/op i.instruction


val show/op i = 
      case i of
        SUB p : "SUB"
      | SUBS p : "SUBS"
      | _ : "ERR(show/op)"
   end

