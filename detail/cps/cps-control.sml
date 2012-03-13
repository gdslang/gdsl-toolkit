
structure CPSControl = struct
   val (registry, debug) =
      BasicControl.newRegistryWithDebug
         {name="cps",
          pri=9,
          help="controls for the cps phases"}
end
