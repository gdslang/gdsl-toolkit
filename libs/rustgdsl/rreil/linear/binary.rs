use std::fmt;
use rreil::linear::Linear;
use rreil::linear::SuperLinear;

pub enum Binop {
  Add, Sub
}

pub struct BinaryLinear {
  op: Binop,
  opnd1: Box<Linear>,
  opnd2: Box<Linear>
}

impl BinaryLinear {
  pub fn new(op: Binop, opnd1: Box<Linear>, opnd2: Box<Linear>) -> BinaryLinear {
    BinaryLinear {op:op, opnd1:opnd1, opnd2:opnd2}
  }
}
