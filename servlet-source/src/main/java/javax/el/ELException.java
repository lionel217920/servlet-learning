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
/*    */ public class ELException
/*    */   extends RuntimeException
/*    */ {
/*    */   public ELException() {}
/*    */   
/*    */   public ELException(String pMessage) {
/* 43 */     super(pMessage);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ELException(Throwable pRootCause) {
/* 53 */     super(pRootCause);
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
/*    */   public ELException(String pMessage, Throwable pRootCause) {
/* 65 */     super(pMessage, pRootCause);
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ELException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */