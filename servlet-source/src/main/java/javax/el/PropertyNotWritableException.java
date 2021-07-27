/*    */ package javax.el;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PropertyNotWritableException
/*    */   extends ELException
/*    */ {
/*    */   public PropertyNotWritableException() {}
/*    */   
/*    */   public PropertyNotWritableException(String pMessage) {
/* 49 */     super(pMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PropertyNotWritableException(Throwable exception) {
/* 60 */     super(exception);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PropertyNotWritableException(String pMessage, Throwable pRootCause) {
/* 72 */     super(pMessage, pRootCause);
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/PropertyNotWritableException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */