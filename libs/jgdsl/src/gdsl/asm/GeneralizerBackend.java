package gdsl.asm;

import java.util.ArrayList;

import gdsl.asm.annotation.Annotation;
import gdsl.asm.annotation.FunctionAnnotation;
import gdsl.asm.annotation.OperandAnnotation;
import gdsl.asm.annotation.StringAnnotation;
import gdsl.asm.boundary.Boundary;
import gdsl.asm.boundary.SizeBoundary;
import gdsl.asm.boundary.SizeOffsetBoundary;
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
  private Object insn (Object length, Object mnemonic, Object annotations_, Object operands_) {
    @SuppressWarnings("unchecked")
    ArrayList<Annotation> annotations = (ArrayList<Annotation>)annotations_;
    @SuppressWarnings("unchecked")
    ArrayList<Operand> operands = (ArrayList<Operand>)operands_;
    return new Instruction((Long) length, (String)mnemonic, annotations.toArray(new Annotation[0]),
      operands.toArray(new Operand[0]));
  }
  
  // operands

  private Object opnds_next (Object next, Object _list) {
    @SuppressWarnings("unchecked")
    ArrayList<Operand> list = (ArrayList<Operand>)_list;
    list.add((Operand)next);
    return list;
  }
  
  private Object opnds_init() {
    return new ArrayList<Operand>();
  }
  
  // operand
  
  private Object register(Object mnemonic) {
    return new Register((String)mnemonic);
  }
  
  private Object memory(Object pointer) {
    return new Memory((Operand)pointer);
  }
  
  private Object immediate(Object imm) {
    return new Immediate((Long)imm);
  }
  
  private Object post_op(Object expression, Object operand) {
    return new PostOperation((Operand)expression, (Operand)operand);
  }
  
  private Object pre_op(Object expression, Object operand) {
    return new PreOperation((Operand)expression, (Operand)operand);
  }
  
  private Object rel(Object operand) {
    return new Relative((Operand)operand);
  }
  
  private Object annotated(Object ann, Object operand) {
    return new Annotated((Annotation)ann, (Operand)operand);
  }
  
  private Object sum(Object lhs, Object rhs) {
    return new Sum((Operand)lhs, (Operand)rhs);
  }
  
  private Object scale(Object factor, Object rhs) {
    return new Scale((Long)factor, (Operand)rhs);
  }
  
  private Object bounded(Object boundary, Object operand) {
    return new Bounded((Boundary)boundary, (Operand)operand);
  }
  
  private Object sign(Object signedness, Object operand) {
    return new Sign((Signedness)signedness, (Operand)operand);
  }
  
  // signedness
  
  private Object signed() {
    return Signedness.Signed;
  }
  
  private Object unsigned() {
    return Signedness.Unsigned;
  }
  
  // boundary
  
  private Object sz(Object size) {
    return new SizeBoundary((Long)size);
  }
  
  private Object sz_o(Object size, Object offset) {
    return new SizeOffsetBoundary((Long)size, (Long)offset);
  }
  
  // annotations
  
  private Object annotations_next (Object next, Object _list) {
    @SuppressWarnings("unchecked")
    ArrayList<Annotation> list = (ArrayList<Annotation>)_list;
    list.add((Annotation)next);
    return list;
  }
  
  private Object annotations_init() {
    return new ArrayList<Annotation>();
  }
  
  // annotation
  
  private Object string(Object annotation) {
    return new StringAnnotation((String)annotation);
  }
  
  private Object function(Object name, Object arguments_) {
    @SuppressWarnings("unchecked")
    ArrayList<Operand> arguments = (ArrayList<Operand>)arguments_;
    return new FunctionAnnotation((String)name, arguments.toArray(new Operand[0]));
  }
  
  private Object operand(Object name, Object operand) {
    return new OperandAnnotation((String)name, (Operand)operand);
  }
  
  public native Instruction generalize();
}
