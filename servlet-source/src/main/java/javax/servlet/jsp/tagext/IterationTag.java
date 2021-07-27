package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JspException;

public interface IterationTag extends Tag {
  public static final int EVAL_BODY_AGAIN = 2;
  
  int doAfterBody() throws JspException;
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/IterationTag.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */