package javax.el;

import java.io.Serializable;

public abstract class Expression implements Serializable {
  public abstract String getExpressionString();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract boolean isLiteralText();
}


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/Expression.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */