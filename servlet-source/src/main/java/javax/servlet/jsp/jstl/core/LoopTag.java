package javax.servlet.jsp.jstl.core;

import javax.servlet.jsp.tagext.Tag;

public interface LoopTag extends Tag {
  Object getCurrent();
  
  LoopTagStatus getLoopStatus();
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/core/LoopTag.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */