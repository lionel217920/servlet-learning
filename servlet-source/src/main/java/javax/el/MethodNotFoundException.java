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
/*    */ public class MethodNotFoundException
/*    */   extends ELException
/*    */ {
/*    */   public MethodNotFoundException() {}
/*    */   
/*    */   public MethodNotFoundException(String message) {
/* 43 */     super(message);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MethodNotFoundException(Throwable exception) {
/* 53 */     super(exception);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MethodNotFoundException(String pMessage, Throwable pRootCause) {
/* 64 */     super(pMessage, pRootCause);
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/MethodNotFoundException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */