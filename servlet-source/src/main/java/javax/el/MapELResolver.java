/*     */ package javax.el;
/*     */ 
/*     */ import java.beans.FeatureDescriptor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapELResolver
/*     */   extends ELResolver
/*     */ {
/*     */   public MapELResolver() {
/*  56 */     this.isReadOnly = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MapELResolver(boolean isReadOnly) {
/*  67 */     this.isReadOnly = isReadOnly;
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
/*     */   public Class<?> getType(ELContext context, Object base, Object property) {
/* 102 */     if (context == null) {
/* 103 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 106 */     if (base != null && base instanceof Map) {
/* 107 */       context.setPropertyResolved(true);
/* 108 */       return Object.class;
/*     */     } 
/* 110 */     return null;
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
/*     */   public Object getValue(ELContext context, Object base, Object property) {
/* 151 */     if (context == null) {
/* 152 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 155 */     if (base != null && base instanceof Map) {
/* 156 */       context.setPropertyResolved(base, property);
/* 157 */       Map map = (Map)base;
/* 158 */       return map.get(property);
/*     */     } 
/* 160 */     return null;
/*     */   }
/*     */   
/* 163 */   private static Class<?> theUnmodifiableMapClass = Collections.unmodifiableMap(new HashMap<>()).getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isReadOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 213 */     if (context == null) {
/* 214 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 217 */     if (base != null && base instanceof Map) {
/* 218 */       context.setPropertyResolved(base, property);
/*     */ 
/*     */       
/* 221 */       Map<Object, Object> map = (Map<Object, Object>)base;
/* 222 */       if (this.isReadOnly || map.getClass() == theUnmodifiableMapClass) {
/* 223 */         throw new PropertyNotWritableException();
/*     */       }
/*     */       try {
/* 226 */         map.put(property, val);
/* 227 */       } catch (UnsupportedOperationException ex) {
/* 228 */         throw new PropertyNotWritableException();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 274 */     if (context == null) {
/* 275 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 278 */     if (base != null && base instanceof Map) {
/* 279 */       context.setPropertyResolved(true);
/* 280 */       Map map = (Map)base;
/* 281 */       return (this.isReadOnly || map.getClass() == theUnmodifiableMapClass);
/*     */     } 
/* 283 */     return false;
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
/*     */   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
/* 327 */     if (base != null && base instanceof Map) {
/* 328 */       Map map = (Map)base;
/* 329 */       Iterator iter = map.keySet().iterator();
/* 330 */       List<FeatureDescriptor> list = new ArrayList<>();
/* 331 */       while (iter.hasNext()) {
/* 332 */         Object key = iter.next();
/* 333 */         FeatureDescriptor descriptor = new FeatureDescriptor();
/* 334 */         String name = (key == null) ? null : key.toString();
/* 335 */         descriptor.setName(name);
/* 336 */         descriptor.setDisplayName(name);
/* 337 */         descriptor.setShortDescription("");
/* 338 */         descriptor.setExpert(false);
/* 339 */         descriptor.setHidden(false);
/* 340 */         descriptor.setPreferred(true);
/* 341 */         if (key != null) {
/* 342 */           descriptor.setValue("type", key.getClass());
/*     */         }
/* 344 */         descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/* 345 */         list.add(descriptor);
/*     */       } 
/* 347 */       return list.iterator();
/*     */     } 
/* 349 */     return null;
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
/*     */   public Class<?> getCommonPropertyType(ELContext context, Object base) {
/* 369 */     if (base != null && base instanceof Map) {
/* 370 */       return Object.class;
/*     */     }
/* 372 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/MapELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */