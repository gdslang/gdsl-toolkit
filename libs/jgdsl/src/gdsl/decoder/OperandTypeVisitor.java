package gdsl.decoder;

import gdsl.asm.Visitor;
import gdsl.asm.operand.Immediate;
import gdsl.asm.operand.Memory;
import gdsl.asm.operand.Register;
import gdsl.asm.operand.Relative;
import gdsl.asm.operand.Scale;
import gdsl.asm.operand.Sum;

public class OperandTypeVisitor extends Visitor {
    private OperandType ot;
    
    public OperandType getOperandType () {
      return ot;
    }
    
    private boolean visited;
    
    public boolean getVisited () {
      return visited;
    }
    
    @Override public void visit(Immediate i) {
      ot = OperandType.Immediate;
      visited = true;
    }
    
    @Override public void visit(Register r) {
      ot = OperandType.Register;
      visited = true;
      
    }
    
    @Override public void visit(Memory m) {
      ot = OperandType.Memory;
      visited = true;
      
    }
    
    @Override public void visit(Sum s) {
      ot = OperandType.Linear;
      visited = true;
      
    }
    
    @Override public void visit(Scale s) {
      ot = OperandType.Linear;
      visited = true;
    }
    
    @Override public void visit(Relative r) {
      ot = OperandType.Flow;
      visited = true;
    }
}
