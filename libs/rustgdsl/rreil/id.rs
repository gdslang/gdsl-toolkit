use std::fmt;
use std::fmt::Formatter;
use std::fmt::Result;

pub enum Id {
  Arch(Box<ArchId>),
  Virtual(Box<VirtualId>)
}

impl Id {
  pub fn inner<'a>(&'a self) ->&'a SuperId {
    match *self {
      Arch(ref id) => id as &SuperId,
      Virtual(ref id) => id as &SuperId
    }
  }
}

pub trait Fap {
  fn fap(&self);
}

pub trait SuperId : fmt::Show + Fap {}

impl fmt::Show for Id {
  fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
//    match *self {
//    Arch(ref id) => id.fmt(f),
//    Virtual(ref id) => id.fmt(f)
//    }
    (*self).inner().fmt(f)
  }
}

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

impl SuperId for Box<ArchId> {
}

impl Fap for Box<ArchId> {
  fn fap(&self) {
    println!("ArchMöp");
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

impl SuperId for Box<VirtualId> {
}

impl Fap for Box<VirtualId> {
  fn fap(&self) {
    println!("ArchMöp");
  }
}
