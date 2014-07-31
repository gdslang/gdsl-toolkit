package gdsl.asm;

import gdsl.asm.annotation.Annotation;
import gdsl.asm.annotation.FunctionAnnotation;
import gdsl.asm.annotation.OperandAnnotation;
import gdsl.asm.annotation.StringAnnotation;
import gdsl.asm.boundary.SizeBoundary;
import gdsl.asm.boundary.SizeOffsetBoundary;
import gdsl.asm.operand.Annotated;
import gdsl.asm.operand.Bounded;
import gdsl.asm.operand.Composite;
import gdsl.asm.operand.Immediate;
import gdsl.asm.operand.Memory;
import gdsl.asm.operand.Operand;
import gdsl.asm.operand.PostOperation;
import gdsl.asm.operand.PreOperation;
import gdsl.asm.operand.Register;
import gdsl.asm.operand.Relative;
import gdsl.asm.operand.Scale;
import gdsl.asm.operand.Sign;
import gdsl.asm.operand.Sum;

public class Visitor {
  public void visit(Instruction i) {
    Annotation[] annotations = i.getAnnotations();
    for (int j = 0; j < annotations.length; j++)
      annotations[j].accept(this);
    Operand[] operands = i.getOperands();
    for (int j = 0; j < operands.length; j++)
      operands[j].accept(this);
  }
  
  public void visit(FunctionAnnotation fa) {
    Operand[] arguments = fa.getArguments();
    for (int j = 0; j < arguments.length; j++)
      arguments[j].accept(this);
    
  }
  
  public void visit(OperandAnnotation oa) {
    oa.getOperand().accept(this);
  }
  
  public void visit(StringAnnotation sa) {
  }
  
  public void visit(SizeBoundary sb) {
  }
  
  public void visit(SizeOffsetBoundary sob) {
  }
  
  public void visit(Annotated a) {
    a.getAnnotation().accept(this);
    a.getOperand().accept(this);
  }
  
  public void visit(Bounded b) {
    b.getBoundary().accept(this);
    b.getOperand().accept(this);
  }
  
  public void visit(Composite c) {
    Operand[] operands = c.getOperands();
    for (int j = 0; j < operands.length; j++)
      operands[j].accept(this);
  }
  
  public void visit(Immediate i) {
  }
  
  public void visit(Memory m) {
    m.getPointer().accept(this);
  }
  
  public void visit(PostOperation po) {
    po.getOperand().accept(this);
    po.getExpression().accept(this);
  }
  
  public void visit(PreOperation po) {
    po.getExpression().accept(this);
    po.getOperand().accept(this);
  }
  
  public void visit(Register r) {
  }
  
  public void visit(Relative r) {
    r.getOperand().accept(this);
  }
  
  public void visit(Scale s) {
    s.getRhs().accept(this);
  }
  
  public void visit(Sign s) {
    s.getOperand().accept(this);
  }
  
  public void visit(Sum s) {
    s.getLhs().accept(this);
    s.getRhs().accept(this);
  }
}
