use rreil::id::VirtualId;
use rreil::id::ArchId;
//use rreil::id::SharedId;
use rreil::id::shared::FloatingFlags;
use rreil::id::Arch;
use rreil::id::Shared;
use rreil::id::SuperId;

use rreil::linear::Linear;
use rreil::linear::Immediate;
use rreil::linear::Variable;
use rreil::linear::BinaryLinear;

use std::fmt;

mod rreil;

fn main() {
  let x = VirtualId::new(42);
  println!("{}", x);
  let x = ArchId::new(String::from_str("hugo"));
  println!("{}", x);

  let y = Arch(box x);
//  let p: &SuperId = y.inner();
//  let q: &fmt::Show = p as &fmt::Show;
  println!("{}", y);

  let q: Box<SuperId> = box ArchId::new(String::from_str("inge"));

  let fup = Shared(box FloatingFlags);
  println!("{}", fup)

  let lin = Immediate(55);
  println!("{}", lin);

  let lin2 = Variable(box y);
  println!("{}", lin2);

  let lin_bin = BinaryLinear::new(rreil::linear::binary::Add, box lin, box lin2);
}
