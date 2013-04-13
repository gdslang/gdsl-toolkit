export = liveness

val liveness instructions = do
  live-registers <- registers-live-map;
  lv-state <- lv-analyze live-registers (rreil-stmts-rev instructions);
  return lv-state.greedy 
end
