/*     */ package javax.el;
/*     */ 
/*     */ import java.beans.FeatureDescriptor;
/*     */ import java.lang.reflect.Array;
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
/*     */ public class ArrayELResolver
/*     */   extends ELResolver
/*     */ {
/*     */   private boolean isReadOnly;
/*     */   
/*     */   public ArrayELResolver() {
/*  52 */     this.isReadOnly = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayELResolver(boolean isReadOnly) {
/*  63 */     this.isReadOnly = isReadOnly;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getType(ELContext context, Object base, Object property) {
/* 102 */     if (context == null) {
/* 103 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 106 */     if (base != null && base.getClass().isArray()) {
/* 107 */       context.setPropertyResolved(true);
/* 108 */       int index = toInteger(property);
/* 109 */       if (index < 0 || index >= Array.getLength(base)) {
/* 110 */         throw new PropertyNotFoundException();
/*     */       }
/* 112 */       return base.getClass().getComponentType();
/*     */     } 
/* 114 */     return null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(ELContext context, Object base, Object property) {
/* 151 */     if (context == null) {
/* 152 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 155 */     if (base != null && base.getClass().isArray()) {
/* 156 */       context.setPropertyResolved(base, property);
/* 157 */       int index = toInteger(property);
/* 158 */       if (index >= 0 && index < Array.getLength(base)) {
/* 159 */         return Array.get(base, index);
/*     */       }
/*     */     } 
/* 162 */     return null;
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
/*     */   public void setValue(ELContext context, Object base, Object property, Object val) {
/* 208 */     if (context == null) {
/* 209 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 212 */     if (base != null && base.getClass().isArray()) {
/* 213 */       context.setPropertyResolved(base, property);
/* 214 */       if (this.isReadOnly) {
/* 215 */         throw new PropertyNotWritableException();
/*     */       }
/* 217 */       Class<?> type = base.getClass().getComponentType();
/* 218 */       if (val != null && !type.isAssignableFrom(val.getClass())) {
/* 219 */         throw new ClassCastException();
/*     */       }
/* 221 */       int index = toInteger(property);
/* 222 */       if (index < 0 || index >= Array.getLength(base)) {
/* 223 */         throw new PropertyNotFoundException();
/*     */       }
/* 225 */       Array.set(base, index, val);
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
/* 266 */     if (context == null) {
/* 267 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 270 */     if (base != null && base.getClass().isArray()) {
/* 271 */       context.setPropertyResolved(true);
/* 272 */       int index = toInteger(property);
/* 273 */       if (index < 0 || index >= Array.getLength(base)) {
/* 274 */         throw new PropertyNotFoundException();
/*     */       }
/*     */     } 
/* 277 */     return this.isReadOnly;
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
/*     */   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
/* 295 */     return null;
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
/*     */   public Class<?> getCommonPropertyType(ELContext context, Object base) {
/* 316 */     if (base != null && base.getClass().isArray()) {
/* 317 */       return Integer.class;
/*     */     }
/* 319 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private int toInteger(Object p) {
/* 324 */     if (p instanceof Integer) {
/* 325 */       return ((Integer)p).intValue();
/*     */     }
/* 327 */     if (p instanceof Character) {
/* 328 */       return ((Character)p).charValue();
/*     */     }
/* 330 */     if (p instanceof Boolean) {
/* 331 */       return ((Boolean)p).booleanValue() ? 1 : 0;
/*     */     }
/* 333 */     if (p instanceof Number) {
/* 334 */       return ((Number)p).intValue();
/*     */     }
/* 336 */     if (p instanceof String) {
/* 337 */       return Integer.parseInt((String)p);
/*     */     }
/* 339 */     throw new IllegalArgumentException();
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ArrayELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */