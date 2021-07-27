/*    */ package javax.servlet;
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
/*    */ public class HttpMethodConstraintElement
/*    */   extends HttpConstraintElement
/*    */ {
/*    */   private String methodName;
/*    */   
/*    */   public HttpMethodConstraintElement(String methodName) {
/* 63 */     if (methodName == null || methodName.length() == 0) {
/* 64 */       throw new IllegalArgumentException("invalid HTTP method name");
/*    */     }
/* 66 */     this.methodName = methodName;
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
/*    */ 
/*    */ 
/*    */   
/*    */   public HttpMethodConstraintElement(String methodName, HttpConstraintElement constraint) {
/* 81 */     super(constraint.getEmptyRoleSemantic(), constraint.getTransportGuarantee(), constraint.getRolesAllowed());
/*    */ 
/*    */     
/* 84 */     if (methodName == null || methodName.length() == 0) {
/* 85 */       throw new IllegalArgumentException("invalid HTTP method name");
/*    */     }
/* 87 */     this.methodName = methodName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMethodName() {
/* 96 */     return this.methodName;
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/HttpMethodConstraintElement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */