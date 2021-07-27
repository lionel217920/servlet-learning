/*     */ package javax.el;
/*     */ 
/*     */ import java.beans.FeatureDescriptor;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StaticFieldELResolver
/*     */   extends ELResolver
/*     */ {
/*     */   public Object getValue(ELContext context, Object base, Object property) {
/*  89 */     if (context == null) {
/*  90 */       throw new NullPointerException();
/*     */     }
/*     */     
/*  93 */     if (base instanceof ELClass && property instanceof String) {
/*  94 */       Class<?> klass = ((ELClass)base).getKlass();
/*  95 */       String fieldName = (String)property;
/*     */       
/*  97 */       try { context.setPropertyResolved(base, property);
/*  98 */         Field field = klass.getField(fieldName);
/*  99 */         int mod = field.getModifiers();
/* 100 */         if (Modifier.isPublic(mod) && Modifier.isStatic(mod)) {
/* 101 */           return field.get(null);
/*     */         } }
/* 103 */       catch (NoSuchFieldException noSuchFieldException) {  }
/* 104 */       catch (IllegalAccessException illegalAccessException) {}
/*     */       
/* 106 */       throw new PropertyNotFoundException(ELUtil.getExceptionMessageString(context, "staticFieldReadError", new Object[] { klass.getName(), fieldName }));
/*     */     } 
/*     */ 
/*     */ 
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
/*     */   public void setValue(ELContext context, Object base, Object property, Object value) {
/* 130 */     if (context == null) {
/* 131 */       throw new NullPointerException();
/*     */     }
/* 133 */     if (base instanceof ELClass && property instanceof String) {
/* 134 */       Class<?> klass = ((ELClass)base).getKlass();
/* 135 */       String fieldName = (String)property;
/* 136 */       throw new PropertyNotWritableException(ELUtil.getExceptionMessageString(context, "staticFieldWriteError", new Object[] { klass.getName(), fieldName }));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object invoke(ELContext context, Object base, Object method, Class<?>[] paramTypes, Object[] params) {
/*     */     Object ret;
/* 188 */     if (context == null) {
/* 189 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 192 */     if (!(base instanceof ELClass) || !(method instanceof String)) {
/* 193 */       return null;
/*     */     }
/*     */     
/* 196 */     Class<?> klass = ((ELClass)base).getKlass();
/* 197 */     String name = (String)method;
/*     */ 
/*     */     
/* 200 */     if ("<init>".equals(name)) {
/* 201 */       Constructor<?> constructor = ELUtil.findConstructor(klass, paramTypes, params);
/*     */       
/* 203 */       ret = ELUtil.invokeConstructor(context, constructor, params);
/*     */     } else {
/* 205 */       Method meth = ELUtil.findMethod(klass, name, paramTypes, params, true);
/*     */       
/* 207 */       ret = ELUtil.invokeMethod(context, meth, null, params);
/*     */     } 
/* 209 */     context.setPropertyResolved(base, method);
/* 210 */     return ret;
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
/*     */   public Class<?> getType(ELContext context, Object base, Object property) {
/* 238 */     if (context == null) {
/* 239 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 242 */     if (base instanceof ELClass && property instanceof String) {
/* 243 */       Class<?> klass = ((ELClass)base).getKlass();
/* 244 */       String fieldName = (String)property;
/*     */       try {
/* 246 */         context.setPropertyResolved(true);
/* 247 */         Field field = klass.getField(fieldName);
/* 248 */         int mod = field.getModifiers();
/* 249 */         if (Modifier.isPublic(mod) && Modifier.isStatic(mod)) {
/* 250 */           return field.getType();
/*     */         }
/* 252 */       } catch (NoSuchFieldException noSuchFieldException) {}
/*     */       
/* 254 */       throw new PropertyNotFoundException(ELUtil.getExceptionMessageString(context, "staticFieldReadError", new Object[] { klass.getName(), fieldName }));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 259 */     return null;
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
/*     */   public boolean isReadOnly(ELContext context, Object base, Object property) {
/* 282 */     if (context == null) {
/* 283 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 286 */     if (base instanceof ELClass && property instanceof String) {
/* 287 */       Class<?> klass = ((ELClass)base).getKlass();
/* 288 */       context.setPropertyResolved(true);
/*     */     } 
/* 290 */     return true;
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
/*     */   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
/* 304 */     return null;
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
/*     */   public Class<?> getCommonPropertyType(ELContext context, Object base) {
/* 316 */     return String.class;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/StaticFieldELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */