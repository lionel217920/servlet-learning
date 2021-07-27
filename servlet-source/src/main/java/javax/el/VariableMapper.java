package javax.el;

public abstract class VariableMapper {
  public abstract ValueExpression resolveVariable(String paramString);
  
  public abstract ValueExpression setVariable(String paramString, ValueExpression paramValueExpression);
}


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/VariableMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */