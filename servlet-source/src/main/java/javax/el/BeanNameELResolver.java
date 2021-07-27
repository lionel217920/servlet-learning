/*     */ package javax.el;
/*     */ 
/*     */ import java.beans.FeatureDescriptor;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BeanNameELResolver
/*     */   extends ELResolver
/*     */ {
/*     */   private BeanNameResolver beanNameResolver;
/*     */   
/*     */   public BeanNameELResolver(BeanNameResolver beanNameResolver) {
/*  74 */     this.beanNameResolver = beanNameResolver;
/*     */   }
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
/*     */   public Object getValue(ELContext context, Object base, Object property) {
/* 102 */     if (context == null) {
/* 103 */       throw new NullPointerException();
/*     */     }
/* 105 */     if (base == null && property instanceof String && 
/* 106 */       this.beanNameResolver.isNameResolved((String)property)) {
/* 107 */       context.setPropertyResolved(base, property);
/* 108 */       return this.beanNameResolver.getBean((String)property);
/*     */     } 
/*     */     
/* 111 */     return null;
/*     */   }
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
/*     */   
/*     */   public void setValue(ELContext context, Object base, Object property, Object value) {
/* 142 */     if (context == null) {
/* 143 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 146 */     if (base == null && property instanceof String) {
/* 147 */       String beanName = (String)property;
/* 148 */       if (this.beanNameResolver.isNameResolved(beanName) || this.beanNameResolver.canCreateBean(beanName)) {
/*     */         
/* 150 */         this.beanNameResolver.setBeanValue(beanName, value);
/* 151 */         context.setPropertyResolved(base, property);
/*     */       } 
/*     */     } 
/*     */   }
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
/*     */   public Class<?> getType(ELContext context, Object base, Object property) {
/* 182 */     if (context == null) {
/* 183 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 186 */     if (base == null && property instanceof String && 
/* 187 */       this.beanNameResolver.isNameResolved((String)property)) {
/* 188 */       context.setPropertyResolved(true);
/* 189 */       return this.beanNameResolver.getBean((String)property).getClass();
/*     */     } 
/*     */     
/* 192 */     return null;
/*     */   }
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
/*     */   public boolean isReadOnly(ELContext context, Object base, Object property) {
/* 221 */     if (context == null) {
/* 222 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 225 */     if (base == null && property instanceof String && 
/* 226 */       this.beanNameResolver.isNameResolved((String)property)) {
/* 227 */       context.setPropertyResolved(true);
/* 228 */       return this.beanNameResolver.isReadOnly((String)property);
/*     */     } 
/*     */     
/* 231 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
/* 243 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getCommonPropertyType(ELContext context, Object base) {
/* 254 */     return String.class;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/BeanNameELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */