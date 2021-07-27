package javax.servlet.jsp;

import javax.el.ELContextListener;
import javax.el.ELResolver;
import javax.el.ExpressionFactory;

public interface JspApplicationContext {
  void addELResolver(ELResolver paramELResolver);
  
  ExpressionFactory getExpressionFactory();
  
  void addELContextListener(ELContextListener paramELContextListener);
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/JspApplicationContext.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */