package gdsl.rreil;

import gdsl.rreil.ILimitedVariable;
import gdsl.rreil.IRReilCollection;
import gdsl.rreil.LimitedVariable;

import java.util.ArrayList;

public class DefaultLimitedVariableCollection implements IRReilCollection<ILimitedVariable> {
  ArrayList<LimitedVariable> statements = new ArrayList<LimitedVariable>();

  public void add (ILimitedVariable s) {
    statements.add((LimitedVariable) s);
  }

  public LimitedVariable get (int i) {
    return statements.get(i);
  }

  public int size () {
    return statements.size();
  }

  @Override public String toString () {
    StringBuilder sb = new StringBuilder();
    if (statements.size() > 1)
      sb.append("(");
    for (int i = 0; i < statements.size(); i++) {
      if (i > 0)
        sb.append(", ");
      sb.append(statements.get(i).toString());
    }
    if (statements.size() > 1)
      sb.append(")");
    return sb.toString();
  }
}
