package gdsl.asm;

import java.util.ArrayList;

import gdsl.asm.annotation.Annotation;
import gdsl.asm.annotation.FunctionAnnotation;
import gdsl.asm.annotation.OperandAnnotation;
import gdsl.asm.annotation.StringAnnotation;
import gdsl.asm.boundary.Boundary;
import gdsl.asm.operand.Annotated;
import gdsl.asm.operand.Bounded;
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

public class GeneralizerBackend {
  public Instruction insn (Long length, String mnemonic, ArrayList<Annotation> annotations, ArrayList<Operand> operands) {
    return new Instruction((Long) length, mnemonic, annotations.toArray(new Annotation[0]),
      operands.toArray(new Operand[0]));
  }
  
  // operands

  public ArrayList<Operand> opnds_next (Operand next, ArrayList<Operand> list) {
    list.add(next);
    return list;
  }
  
  public ArrayList<Operand> opnds_init() {
    return new ArrayList<Operand>();
  }
  
  // operand
  
  public Register register(String mnemonic) {
    return new Register(mnemonic);
  }
  
  public Memory memory(Operand pointer) {
    return new Memory(pointer);
  }
  
  public Immediate immediate(Long imm) {
    return new Immediate(imm);
  }
  
  public PostOperation post_op(Operand expression, Operand operand) {
    return new PostOperation(expression, operand);
  }
  
  public PreOperation pre_op(Operand expression, Operand operand) {
    return new PreOperation(expression, operand);
  }
  
  public Relative rel(Operand operand) {
    return new Relative(operand);
  }
  
  public Annotated annotated(Annotation ann, Operand operand) {
    return new Annotated(ann, operand);
  }
  
  public Sum sum(Operand lhs, Operand rhs) {
    return new Sum(lhs, rhs);
  }
  
  public Scale scale(Long factor, Operand rhs) {
    return new Scale(factor, rhs);
  }
  
  public Bounded bounded(Boundary boundary, Operand operand) {
    return new Bounded(boundary, operand);
  }
  
  public Sign sign(Signedness signedness, Operand operand) {
    return new Sign(signedness, operand);
  }
  
  // signedness
  
  public Signedness signed() {
    return Signedness.Signed;
  }
  
  public Signedness unsigned() {
    return Signedness.Unsigned;
  }
  
  // annotation
  
  public Annotation string(String annotation) {
    return new StringAnnotation(annotation);
  }
  
  public Annotation function(String name, Operand[] arguments) {
    return new FunctionAnnotation(name, arguments);
  }
  
  public Annotation operand(String name, Operand operand) {
    return new OperandAnnotation(name, operand);
  }
}
