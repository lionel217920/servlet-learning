package javax.servlet.jsp.tagext;

import javax.servlet.jsp.JspException;

public interface BodyTag extends IterationTag {
  public static final int EVAL_BODY_TAG = 2;
  
  public static final int EVAL_BODY_BUFFERED = 2;
  
  void setBodyContent(BodyContent paramBodyContent);
  
  void doInitBody() throws JspException;
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/tagext/BodyTag.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */