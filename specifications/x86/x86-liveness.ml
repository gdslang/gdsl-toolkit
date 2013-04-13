export = liveness

val liveness stack = do
  live-registers <- registers-live-map;
  lv-state <- lv-analyze live-registers stack;
  return lv-state.greedy 
end
