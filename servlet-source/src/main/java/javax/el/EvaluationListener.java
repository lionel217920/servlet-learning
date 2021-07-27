package javax.el;

public abstract class EvaluationListener {
  public void beforeEvaluation(ELContext context, String expression) {}
  
  public void afterEvaluation(ELContext context, String expression) {}
  
  public void propertyResolved(ELContext context, Object base, Object property) {}
}


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/EvaluationListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */