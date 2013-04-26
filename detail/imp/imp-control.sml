
structure ImpControl = struct
   val (registry, debug) =
      BasicControl.newRegistryWithDebug
         {name="imp",
          pri=9,
          help="controls for the imp phases"}
end
