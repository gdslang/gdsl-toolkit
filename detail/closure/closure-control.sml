
structure ClosureControl = struct
   val (registry, debug) =
      BasicControl.newRegistryWithDebug
         {name="closure",
          pri=9,
          help="controls for the closure conversion phases"}
end
