package gdsl.rreil;

import gdsl.rreil.IRReilCollection;
import gdsl.rreil.statement.IStatement;
import gdsl.rreil.statement.Statement;

import java.util.ArrayList;

public class DefaultStatementCollection implements IRReilCollection<IStatement> {
  ArrayList<Statement> statements = new ArrayList<Statement>();

  public void add (IStatement s) {
    statements.add((Statement) s);
  }

  public Statement get (int i) {
    return statements.get(i);
  }

  public int size () {
    return statements.size();
  }

  @Override public String toString () {
    String result = "";
    for (int i = 0; i < statements.size(); i++)
     result += statements.get(i).toString() + "\n";
    return result;
  }
}
