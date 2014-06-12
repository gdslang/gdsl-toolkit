use rreil::id::VirtualId;
use rreil::id::ArchId;
use rreil::id::Arch;
use rreil::id::SuperId;

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
  y.inner().fap();
}
