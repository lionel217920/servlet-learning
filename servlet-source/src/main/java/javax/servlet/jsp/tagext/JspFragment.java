package javax.servlet.jsp.tagext;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;

public abstract class JspFragment {
  public abstract void invoke(Writer paramWriter) throws JspException, IOException;
  
  public abstract JspContext getJspContext();
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/JspFragment.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */