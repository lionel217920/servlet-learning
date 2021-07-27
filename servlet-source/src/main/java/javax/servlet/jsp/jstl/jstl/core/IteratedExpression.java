/*     */ package javax.servlet.jsp.jstl.jstl.core;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.el.ELContext;
/*     */ import javax.el.ELException;
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
/*     */ public final class IteratedExpression
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected final ValueExpression orig;
/*     */   protected final String delims;
/*     */   private Object base;
/*     */   private int index;
/*     */   private Iterator iter;
/*     */   
/*     */   public IteratedExpression(ValueExpression orig, String delims) {
/*  48 */     this.orig = orig;
/*  49 */     this.delims = delims;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getItem(ELContext context, int i) {
/*  59 */     if (this.base == null) {
/*  60 */       this.base = this.orig.getValue(context);
/*  61 */       if (this.base == null) {
/*  62 */         return null;
/*     */       }
/*  64 */       this.iter = toIterator(this.base);
/*  65 */       this.index = 0;
/*     */     } 
/*  67 */     if (this.index > i) {
/*     */       
/*  69 */       this.iter = toIterator(this.base);
/*  70 */       this.index = 0;
/*     */     } 
/*  72 */     while (this.iter.hasNext()) {
/*  73 */       Object item = this.iter.next();
/*  74 */       if (this.index++ == i) {
/*  75 */         return item;
/*     */       }
/*     */     } 
/*  78 */     return null;
/*     */   }
/*     */   
/*     */   public ValueExpression getValueExpression() {
/*  82 */     return this.orig;
/*     */   }
/*     */ 
/*     */   
/*     */   private Iterator toIterator(Object obj) {
/*     */     Iterator iter;
/*  88 */     if (obj instanceof String) {
/*  89 */       iter = toIterator(new StringTokenizer((String)obj, this.delims));
/*     */     }
/*  91 */     else if (obj instanceof Iterator) {
/*  92 */       iter = (Iterator)obj;
/*     */     }
/*  94 */     else if (obj instanceof Collection) {
/*  95 */       iter = toIterator(((Collection)obj).iterator());
/*     */     }
/*  97 */     else if (obj instanceof Enumeration) {
/*  98 */       iter = toIterator((Enumeration)obj);
/*     */     }
/* 100 */     else if (obj instanceof Map) {
/* 101 */       iter = ((Map)obj).entrySet().iterator();
/*     */     } else {
/* 103 */       throw new ELException("Don't know how to iterate over supplied items in forEach");
/*     */     } 
/*     */     
/* 106 */     return iter;
/*     */   }
/*     */   
/*     */   private Iterator toIterator(final Enumeration obj) {
/* 110 */     return new Iterator() {
/*     */         public boolean hasNext() {
/* 112 */           return obj.hasMoreElements();
/*     */         }
/*     */         public Object next() {
/* 115 */           return obj.nextElement();
/*     */         }
/*     */         
/*     */         public void remove() {}
/*     */       };
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/core/IteratedExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */