use std::fmt;
use std::fmt::Formatter;
use std::fmt::Result;

pub use rreil::cc;

pub use rreil::id::arch::ArchId;
pub use rreil::id::virtual_::VirtualId;
pub use rreil::id::shared::SharedId;

//#[path="arch.rs"]
pub mod arch;
pub mod virtual_;
pub mod shared;

pub enum Id {
  Arch(Box<ArchId>),
  Virtual(Box<VirtualId>),
  Shared(Box<SharedId>)
}

//        (|fop: &'a ArchId| -> &'a ArchId { fop })(*id) as &'a SuperId

pub trait SuperId : fmt::Show {}

impl Id {
  pub fn inner<'a>(&'a self) -> &'a SuperId {
    match *self {
      Arch(ref id) => cc(*id) as &'a SuperId,
      Virtual(ref id) => cc(*id) as &'a SuperId,
      Shared(ref id) => cc(*id) as &'a SuperId
    }
  }
}


impl fmt::Show for Id {
  fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
    (*self).inner().fmt(f)
  }
}

