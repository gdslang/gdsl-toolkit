package gdsl.asm.annotation;

public class StringAnnotation extends Annotation {
  private String annotation;
  
  public String getAnnotation() {
    return annotation;
  }
  
  public StringAnnotation(String annotation) {
    this.annotation = annotation;
  }
}
