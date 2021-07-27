package javax.servlet.jsp.el;

public abstract class ExpressionEvaluator {
  public abstract Expression parseExpression(String paramString, Class paramClass, FunctionMapper paramFunctionMapper) throws ELException;
  
  public abstract Object evaluate(String paramString, Class paramClass, VariableResolver paramVariableResolver, FunctionMapper paramFunctionMapper) throws ELException;
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/el/ExpressionEvaluator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */