use std::fmt;
use std::fmt::Formatter;
use std::fmt::Result;

use rreil::id::Id;
use rreil::cc;

pub use rreil::linear::binary::BinaryLinear;

pub mod binary;

pub enum Linear {
  Immediate(u64),
  Variable(Box<Id>)
}

pub trait SuperLinear : fmt::Show {}

impl Linear {
  pub fn inner<'a>(&'a self) -> &'a SuperLinear {
    match *self {
      Immediate(ref i) => i as &'a SuperLinear,
      Variable(ref id) => cc(*id) as &'a SuperLinear
    }
  }
}

impl fmt::Show for Linear {
  fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
    (*self).inner().fmt(f)
  }
}

impl SuperLinear for u64 {
}

impl SuperLinear for Id {
}
