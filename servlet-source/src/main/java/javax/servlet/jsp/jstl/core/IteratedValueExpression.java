/*    */ package javax.servlet.jsp.jstl.core;
/*    */ 
/*    */ import javax.el.ELContext;
/*    */ import javax.el.ValueExpression;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class IteratedValueExpression
/*    */   extends ValueExpression
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   protected final int i;
/*    */   protected final IteratedExpression iteratedExpression;
/*    */   
/*    */   public IteratedValueExpression(IteratedExpression iteratedExpr, int i) {
/* 34 */     this.i = i;
/* 35 */     this.iteratedExpression = iteratedExpr;
/*    */   }
/*    */   
/*    */   public Object getValue(ELContext context) {
/* 39 */     return this.iteratedExpression.getItem(context, this.i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(ELContext context, Object value) {}
/*    */   
/*    */   public boolean isReadOnly(ELContext context) {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public Class getType(ELContext context) {
/* 50 */     return null;
/*    */   }
/*    */   
/*    */   public Class getExpectedType() {
/* 54 */     return Object.class;
/*    */   }
/*    */   
/*    */   public String getExpressionString() {
/* 58 */     return this.iteratedExpression.getValueExpression().getExpressionString();
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj) {
/* 62 */     return this.iteratedExpression.getValueExpression().equals(obj);
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     return this.iteratedExpression.getValueExpression().hashCode();
/*    */   }
/*    */   
/*    */   public boolean isLiteralText() {
/* 70 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/core/IteratedValueExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */