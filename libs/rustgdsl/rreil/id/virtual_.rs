use std::fmt;
use rreil::id::SuperId;

pub struct VirtualId {
  t: i64
}

impl VirtualId {
  pub fn new(t: i64) -> VirtualId {
    VirtualId {t:t}
  }
}

impl fmt::Show for VirtualId {
  fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
      write!(f, "t{}", self.t)
  }
}

impl SuperId for VirtualId {
}
