use std::fmt;
use std::fmt::Formatter;
use std::fmt::Result;

pub use rreil::id::arch::ArchId;

//#[path="arch.rs"]
mod arch;

pub enum Id {
  Arch(Box<ArchId>),
  Virtual(Box<VirtualId>)
}

fn cc<'a, T>(x: &'a T) -> &'a T { x }
//        (|fop: &'a ArchId| -> &'a ArchId { fop })(*id) as &'a SuperId

impl Id {
  pub fn inner<'a>(&'a self) -> &'a SuperId {
    match *self {
      Arch(ref id) => cc(*id) as &'a SuperId,
      Virtual(ref id) => cc(*id) as &'a SuperId
    }
  }
}

pub trait SuperId : fmt::Show {}

impl fmt::Show for Id {
  fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
//    match *self {
//    Arch(ref id) => id.fmt(f),
//    Virtual(ref id) => id.fmt(f)
//    }
    (*self).inner().fmt(f)
  }
}

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
