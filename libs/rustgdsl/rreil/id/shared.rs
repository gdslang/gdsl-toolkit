use std::fmt;
use rreil::id::SuperId;

pub enum SharedId {
  FloatingFlags
}

impl fmt::Show for SharedId {
  fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
    let self_str = match *self {
      FloatingFlags => "FloatingFlags"
    };
    write!(f, "{}", self_str)
  }
}

impl SuperId for SharedId {
}
