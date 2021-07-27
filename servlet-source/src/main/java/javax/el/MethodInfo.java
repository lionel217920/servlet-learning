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
/*    */ public class MethodInfo
/*    */ {
/*    */   private String name;
/*    */   private Class<?> returnType;
/*    */   private Class<?>[] paramTypes;
/*    */   
/*    */   public MethodInfo(String name, Class<?> returnType, Class<?>[] paramTypes) {
/* 37 */     this.name = name;
/* 38 */     this.returnType = returnType;
/* 39 */     this.paramTypes = paramTypes;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 48 */     return this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> getReturnType() {
/* 57 */     return this.returnType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?>[] getParamTypes() {
/* 66 */     return this.paramTypes;
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/MethodInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */