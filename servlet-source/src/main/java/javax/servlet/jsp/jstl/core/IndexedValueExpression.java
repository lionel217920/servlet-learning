/*     */ package javax.servlet.jsp.jstl.core;
/*     */ 
/*     */ import javax.el.ELContext;
/*     */ import javax.el.ValueExpression;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class IndexedValueExpression
/*     */   extends ValueExpression
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected final Integer i;
/*     */   protected final ValueExpression orig;
/*     */   
/*     */   public IndexedValueExpression(ValueExpression orig, int i) {
/*  40 */     this.i = Integer.valueOf(i);
/*  41 */     this.orig = orig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(ELContext context) {
/*  50 */     Object base = this.orig.getValue(context);
/*  51 */     if (base != null) {
/*  52 */       context.setPropertyResolved(false);
/*  53 */       return context.getELResolver().getValue(context, base, this.i);
/*     */     } 
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(ELContext context, Object value) {
/*  65 */     Object base = this.orig.getValue(context);
/*  66 */     if (base != null) {
/*  67 */       context.setPropertyResolved(false);
/*  68 */       context.getELResolver().setValue(context, base, this.i, value);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly(ELContext context) {
/*  78 */     Object base = this.orig.getValue(context);
/*  79 */     if (base != null) {
/*  80 */       context.setPropertyResolved(false);
/*  81 */       return context.getELResolver().isReadOnly(context, base, this.i);
/*     */     } 
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getType(ELContext context) {
/*  92 */     Object base = this.orig.getValue(context);
/*  93 */     if (base != null) {
/*  94 */       context.setPropertyResolved(false);
/*  95 */       return context.getELResolver().getType(context, base, this.i);
/*     */     } 
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getExpectedType() {
/* 106 */     return Object.class;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExpressionString() {
/* 115 */     return this.orig.getExpressionString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 124 */     return this.orig.equals(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 133 */     return this.orig.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLiteralText() {
/* 142 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/core/IndexedValueExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */