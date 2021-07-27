/*     */ package javax.el;
/*     */ 
/*     */ import java.beans.FeatureDescriptor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListELResolver
/*     */   extends ELResolver
/*     */ {
/*     */   public ListELResolver() {
/*  55 */     this.isReadOnly = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListELResolver(boolean isReadOnly) {
/*  66 */     this.isReadOnly = isReadOnly;
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
/*     */   public Class<?> getType(ELContext context, Object base, Object property) {
/* 104 */     if (context == null) {
/* 105 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 108 */     if (base != null && base instanceof List) {
/* 109 */       context.setPropertyResolved(true);
/* 110 */       List list = (List)base;
/* 111 */       int index = toInteger(property);
/* 112 */       if (index < 0 || index >= list.size()) {
/* 113 */         throw new PropertyNotFoundException();
/*     */       }
/* 115 */       return Object.class;
/*     */     } 
/* 117 */     return null;
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
/* 154 */     if (context == null) {
/* 155 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 158 */     if (base != null && base instanceof List) {
/* 159 */       context.setPropertyResolved(base, property);
/* 160 */       List list = (List)base;
/* 161 */       int index = toInteger(property);
/* 162 */       if (index < 0 || index >= list.size()) {
/* 163 */         return null;
/*     */       }
/* 165 */       return list.get(index);
/*     */     } 
/* 167 */     return null;
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
/*     */ 
/*     */ 
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
/* 224 */     if (context == null) {
/* 225 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 228 */     if (base != null && base instanceof List) {
/* 229 */       context.setPropertyResolved(base, property);
/*     */ 
/*     */       
/* 232 */       List<Object> list = (List<Object>)base;
/* 233 */       int index = toInteger(property);
/* 234 */       if (this.isReadOnly) {
/* 235 */         throw new PropertyNotWritableException();
/*     */       }
/*     */       try {
/* 238 */         list.set(index, val);
/* 239 */       } catch (UnsupportedOperationException ex) {
/* 240 */         throw new PropertyNotWritableException();
/* 241 */       } catch (IndexOutOfBoundsException ex) {
/* 242 */         throw new PropertyNotFoundException();
/* 243 */       } catch (ClassCastException ex) {
/* 244 */         throw ex;
/* 245 */       } catch (NullPointerException ex) {
/* 246 */         throw ex;
/* 247 */       } catch (IllegalArgumentException ex) {
/* 248 */         throw ex;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/* 253 */   private static Class<?> theUnmodifiableListClass = Collections.unmodifiableList(new ArrayList()).getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public boolean isReadOnly(ELContext context, Object base, Object property) {
/* 300 */     if (context == null) {
/* 301 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 304 */     if (base != null && base instanceof List) {
/* 305 */       context.setPropertyResolved(true);
/* 306 */       List list = (List)base;
/* 307 */       int index = toInteger(property);
/* 308 */       if (index < 0 || index >= list.size()) {
/* 309 */         throw new PropertyNotFoundException();
/*     */       }
/* 311 */       return (list.getClass() == theUnmodifiableListClass || this.isReadOnly);
/*     */     } 
/* 313 */     return false;
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
/* 331 */     return null;
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
/* 351 */     if (base != null && base instanceof List) {
/* 352 */       return Integer.class;
/*     */     }
/* 354 */     return null;
/*     */   }
/*     */   
/*     */   private int toInteger(Object p) {
/* 358 */     if (p instanceof Integer) {
/* 359 */       return ((Integer)p).intValue();
/*     */     }
/* 361 */     if (p instanceof Character) {
/* 362 */       return ((Character)p).charValue();
/*     */     }
/* 364 */     if (p instanceof Number) {
/* 365 */       return ((Number)p).intValue();
/*     */     }
/* 367 */     if (p instanceof String) {
/* 368 */       return Integer.parseInt((String)p);
/*     */     }
/* 370 */     throw new IllegalArgumentException();
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ListELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */