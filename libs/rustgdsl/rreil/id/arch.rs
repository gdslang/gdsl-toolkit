use std::fmt;
use rreil::id::SuperId;

pub struct ArchId {
  name: String
}

impl ArchId {
  pub fn new(name: String) -> ArchId {
    ArchId {name:name}
  }
}

impl fmt::Show for ArchId {
  fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
      write!(f, "{}", self.name)
  }
}

impl SuperId for ArchId {
}
