
structure DesugarControl = struct
   val (registry, debug) =
      BasicControl.newRegistryWithDebug
         {name="desugar",
          pri=9,
          help="controls for the desugaring phases"}
end
