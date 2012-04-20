
structure CodegenControl = struct
   val (registry, debug) =
      BasicControl.newRegistryWithDebug
         {name="codegen",
          pri=9,
          help="controls for the code generation phase"}
end
