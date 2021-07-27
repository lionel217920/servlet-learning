/*    */ package javax.servlet.annotation;
/*    */ 
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.ElementType;
/*    */ import java.lang.annotation.Inherited;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import java.lang.annotation.Target;
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
/*    */ @Inherited
/*    */ @Documented
/*    */ @Target({ElementType.TYPE})
/*    */ @Retention(RetentionPolicy.RUNTIME)
/*    */ public @interface ServletSecurity
/*    */ {
/*    */   HttpConstraint value() default @HttpConstraint;
/*    */   
/*    */   HttpMethodConstraint[] httpMethodConstraints() default {};
/*    */   
/*    */   public enum EmptyRoleSemantic
/*    */   {
/* 74 */     PERMIT,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 79 */     DENY;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public enum TransportGuarantee
/*    */   {
/* 90 */     NONE,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 95 */     CONFIDENTIAL;
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.servlet-api-3.1.0.jar!/javax/servlet/annotation/ServletSecurity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */