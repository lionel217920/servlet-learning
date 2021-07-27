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
/*    */ public class PropertyNotFoundException
/*    */   extends ELException
/*    */ {
/*    */   public PropertyNotFoundException() {}
/*    */   
/*    */   public PropertyNotFoundException(String message) {
/* 48 */     super(message);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PropertyNotFoundException(Throwable exception) {
/* 58 */     super(exception);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PropertyNotFoundException(String pMessage, Throwable pRootCause) {
/* 69 */     super(pMessage, pRootCause);
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/PropertyNotFoundException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */