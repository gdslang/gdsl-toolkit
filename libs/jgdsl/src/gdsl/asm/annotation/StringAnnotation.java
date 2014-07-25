package gdsl.asm.annotation;

import gdsl.asm.Visitor;

public class StringAnnotation extends Annotation {
  private String annotation;
  
  public String getAnnotation() {
    return annotation;
  }
  
  public StringAnnotation(String annotation) {
    this.annotation = annotation;
  }

  @Override public String toString () {
    return "{Annotation: " + annotation + "}";
  }

  @Override public void accept (Visitor v) {
    v.visit(this);
  }
}
