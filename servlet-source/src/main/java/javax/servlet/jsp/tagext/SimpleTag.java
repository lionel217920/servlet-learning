package javax.servlet.jsp.tagext;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;

public interface SimpleTag extends JspTag {
  void doTag() throws JspException, IOException;
  
  void setParent(JspTag paramJspTag);
  
  JspTag getParent();
  
  void setJspContext(JspContext paramJspContext);
  
  void setJspBody(JspFragment paramJspFragment);
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/SimpleTag.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */