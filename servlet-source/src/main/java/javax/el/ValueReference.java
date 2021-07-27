/*    */ package javax.el;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class ValueReference
/*    */   implements Serializable
/*    */ {
/*    */   private Object base;
/*    */   private Object property;
/*    */   
/*    */   public ValueReference(Object base, Object property) {
/* 58 */     this.base = base;
/* 59 */     this.property = property;
/*    */   }
/*    */   
/*    */   public Object getBase() {
/* 63 */     return this.base;
/*    */   }
/*    */   
/*    */   public Object getProperty() {
/* 67 */     return this.property;
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ValueReference.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */