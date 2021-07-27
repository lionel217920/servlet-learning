package javax.servlet.jsp.jstl.jstl.core;

public interface LoopTagStatus {
  Object getCurrent();
  
  int getIndex();
  
  int getCount();
  
  boolean isFirst();
  
  boolean isLast();
  
  Integer getBegin();
  
  Integer getEnd();
  
  Integer getStep();
}


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/core/LoopTagStatus.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */