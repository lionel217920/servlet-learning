/*     */ package javax.el;
/*     */ 
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.FeatureDescriptor;
/*     */ import java.beans.IntrospectionException;
/*     */ import java.beans.Introspector;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BeanELResolver
/*     */   extends ELResolver
/*     */ {
/*     */   private boolean isReadOnly;
/*     */   
/*     */   private static class BPSoftReference
/*     */     extends SoftReference<BeanProperties>
/*     */   {
/*     */     final Class<?> key;
/*     */     
/*     */     BPSoftReference(Class<?> key, BeanELResolver.BeanProperties beanProperties, ReferenceQueue<BeanELResolver.BeanProperties> refQ) {
/*  78 */       super(beanProperties, refQ);
/*  79 */       this.key = key;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class SoftConcurrentHashMap
/*     */     extends ConcurrentHashMap<Class<?>, BeanProperties>
/*     */   {
/*     */     private static final int CACHE_INIT_SIZE = 1024;
/*  87 */     private ConcurrentHashMap<Class<?>, BeanELResolver.BPSoftReference> map = new ConcurrentHashMap<>(1024);
/*     */     
/*  89 */     private ReferenceQueue<BeanELResolver.BeanProperties> refQ = new ReferenceQueue<>();
/*     */ 
/*     */ 
/*     */     
/*     */     private void cleanup() {
/*  94 */       BeanELResolver.BPSoftReference BPRef = null;
/*  95 */       while ((BPRef = (BeanELResolver.BPSoftReference)this.refQ.poll()) != null) {
/*  96 */         this.map.remove(BPRef.key);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public BeanELResolver.BeanProperties put(Class<?> key, BeanELResolver.BeanProperties value) {
/* 102 */       cleanup();
/* 103 */       BeanELResolver.BPSoftReference prev = this.map.put(key, new BeanELResolver.BPSoftReference(key, value, this.refQ));
/*     */       
/* 105 */       return (prev == null) ? null : prev.get();
/*     */     }
/*     */ 
/*     */     
/*     */     public BeanELResolver.BeanProperties putIfAbsent(Class<?> key, BeanELResolver.BeanProperties value) {
/* 110 */       cleanup();
/* 111 */       BeanELResolver.BPSoftReference prev = this.map.putIfAbsent(key, new BeanELResolver.BPSoftReference(key, value, this.refQ));
/*     */       
/* 113 */       return (prev == null) ? null : prev.get();
/*     */     }
/*     */ 
/*     */     
/*     */     public BeanELResolver.BeanProperties get(Object key) {
/* 118 */       cleanup();
/* 119 */       BeanELResolver.BPSoftReference BPRef = this.map.get(key);
/* 120 */       if (BPRef == null) {
/* 121 */         return null;
/*     */       }
/* 123 */       if (BPRef.get() == null) {
/*     */         
/* 125 */         this.map.remove(key);
/* 126 */         return null;
/*     */       } 
/* 128 */       return BPRef.get();
/*     */     }
/*     */ 
/*     */     
/*     */     private SoftConcurrentHashMap() {}
/*     */   }
/* 134 */   private static final SoftConcurrentHashMap properties = new SoftConcurrentHashMap();
/*     */ 
/*     */ 
/*     */   
/*     */   static final class BeanProperty
/*     */   {
/*     */     private Method readMethod;
/*     */     
/*     */     private Method writeMethod;
/*     */     
/*     */     private PropertyDescriptor descriptor;
/*     */ 
/*     */     
/*     */     public BeanProperty(Class<?> baseClass, PropertyDescriptor descriptor) {
/* 148 */       this.descriptor = descriptor;
/* 149 */       this.readMethod = ELUtil.getMethod(baseClass, descriptor.getReadMethod());
/* 150 */       this.writeMethod = ELUtil.getMethod(baseClass, descriptor.getWriteMethod());
/*     */     }
/*     */     
/*     */     public Class getPropertyType() {
/* 154 */       return this.descriptor.getPropertyType();
/*     */     }
/*     */     
/*     */     public boolean isReadOnly() {
/* 158 */       return (getWriteMethod() == null);
/*     */     }
/*     */     
/*     */     public Method getReadMethod() {
/* 162 */       return this.readMethod;
/*     */     }
/*     */     
/*     */     public Method getWriteMethod() {
/* 166 */       return this.writeMethod;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class BeanProperties {
/*     */     private final Map<String, BeanELResolver.BeanProperty> propertyMap;
/*     */     
/*     */     public BeanProperties(Class<?> baseClass) {
/*     */       PropertyDescriptor[] descriptors;
/* 175 */       this.propertyMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 181 */         BeanInfo info = Introspector.getBeanInfo(baseClass);
/* 182 */         descriptors = info.getPropertyDescriptors();
/* 183 */       } catch (IntrospectionException ie) {
/* 184 */         throw new ELException(ie);
/*     */       } 
/* 186 */       for (PropertyDescriptor pd : descriptors) {
/* 187 */         this.propertyMap.put(pd.getName(), new BeanELResolver.BeanProperty(baseClass, pd));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public BeanELResolver.BeanProperty getBeanProperty(String property) {
/* 193 */       return this.propertyMap.get(property);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BeanELResolver() {
/* 201 */     this.isReadOnly = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BeanELResolver(boolean isReadOnly) {
/* 212 */     this.isReadOnly = isReadOnly;
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
/* 251 */     if (context == null) {
/* 252 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 255 */     if (base == null || property == null) {
/* 256 */       return null;
/*     */     }
/*     */     
/* 259 */     BeanProperty bp = getBeanProperty(context, base, property);
/* 260 */     context.setPropertyResolved(true);
/* 261 */     return bp.getPropertyType();
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
/*     */   public Object getValue(ELContext context, Object base, Object property) {
/*     */     Object value;
/* 301 */     if (context == null) {
/* 302 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 305 */     if (base == null || property == null) {
/* 306 */       return null;
/*     */     }
/*     */     
/* 309 */     BeanProperty bp = getBeanProperty(context, base, property);
/* 310 */     Method method = bp.getReadMethod();
/* 311 */     if (method == null) {
/* 312 */       throw new PropertyNotFoundException(ELUtil.getExceptionMessageString(context, "propertyNotReadable", new Object[] { base.getClass().getName(), property.toString() }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 321 */       value = method.invoke(base, new Object[0]);
/* 322 */       context.setPropertyResolved(base, property);
/* 323 */     } catch (ELException ex) {
/* 324 */       throw ex;
/* 325 */     } catch (InvocationTargetException ite) {
/* 326 */       throw new ELException(ite.getCause());
/* 327 */     } catch (Exception ex) {
/* 328 */       throw new ELException(ex);
/*     */     } 
/* 330 */     return value;
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
/*     */   public void setValue(ELContext context, Object base, Object property, Object val) {
/* 374 */     if (context == null) {
/* 375 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 378 */     if (base == null || property == null) {
/*     */       return;
/*     */     }
/*     */     
/* 382 */     if (this.isReadOnly) {
/* 383 */       throw new PropertyNotWritableException(ELUtil.getExceptionMessageString(context, "resolverNotwritable", new Object[] { base.getClass().getName() }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 389 */     BeanProperty bp = getBeanProperty(context, base, property);
/* 390 */     Method method = bp.getWriteMethod();
/* 391 */     if (method == null) {
/* 392 */       throw new PropertyNotWritableException(ELUtil.getExceptionMessageString(context, "propertyNotWritable", new Object[] { base.getClass().getName(), property.toString() }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 400 */       method.invoke(base, new Object[] { val });
/* 401 */       context.setPropertyResolved(base, property);
/* 402 */     } catch (ELException ex) {
/* 403 */       throw ex;
/* 404 */     } catch (InvocationTargetException ite) {
/* 405 */       throw new ELException(ite.getCause());
/* 406 */     } catch (Exception ex) {
/* 407 */       if (null == val) {
/* 408 */         val = "null";
/*     */       }
/* 410 */       String message = ELUtil.getExceptionMessageString(context, "setPropertyFailed", new Object[] { property.toString(), base.getClass().getName(), val });
/*     */ 
/*     */ 
/*     */       
/* 414 */       throw new ELException(message, ex);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 482 */     if (base == null || method == null) {
/* 483 */       return null;
/*     */     }
/* 485 */     Method m = ELUtil.findMethod(base.getClass(), method.toString(), paramTypes, params, false);
/*     */     
/* 487 */     for (Object p : params) {
/*     */ 
/*     */       
/* 490 */       if (p instanceof LambdaExpression) {
/* 491 */         ((LambdaExpression)p).setELContext(context);
/*     */       }
/*     */     } 
/* 494 */     Object ret = ELUtil.invokeMethod(context, m, base, params);
/* 495 */     context.setPropertyResolved(base, method);
/* 496 */     return ret;
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
/* 540 */     if (context == null) {
/* 541 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 544 */     if (base == null || property == null) {
/* 545 */       return false;
/*     */     }
/*     */     
/* 548 */     context.setPropertyResolved(true);
/* 549 */     if (this.isReadOnly) {
/* 550 */       return true;
/*     */     }
/*     */     
/* 553 */     BeanProperty bp = getBeanProperty(context, base, property);
/* 554 */     return bp.isReadOnly();
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
/*     */   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
/* 587 */     if (base == null) {
/* 588 */       return null;
/*     */     }
/*     */     
/* 591 */     BeanInfo info = null;
/*     */     try {
/* 593 */       info = Introspector.getBeanInfo(base.getClass());
/* 594 */     } catch (Exception exception) {}
/*     */     
/* 596 */     if (info == null) {
/* 597 */       return null;
/*     */     }
/* 599 */     ArrayList<FeatureDescriptor> list = new ArrayList<>((info.getPropertyDescriptors()).length);
/*     */     
/* 601 */     for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
/* 602 */       pd.setValue("type", pd.getPropertyType());
/* 603 */       pd.setValue("resolvableAtDesignTime", Boolean.TRUE);
/* 604 */       list.add(pd);
/*     */     } 
/* 606 */     return list.iterator();
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
/*     */   public Class<?> getCommonPropertyType(ELContext context, Object base) {
/* 625 */     if (base == null) {
/* 626 */       return null;
/*     */     }
/*     */     
/* 629 */     return Object.class;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BeanProperty getBeanProperty(ELContext context, Object base, Object prop) {
/* 636 */     String property = prop.toString();
/* 637 */     Class<?> baseClass = base.getClass();
/* 638 */     BeanProperties bps = properties.get(baseClass);
/* 639 */     if (bps == null) {
/* 640 */       bps = new BeanProperties(baseClass);
/* 641 */       properties.put(baseClass, bps);
/*     */     } 
/* 643 */     BeanProperty bp = bps.getBeanProperty(property);
/* 644 */     if (bp == null) {
/* 645 */       throw new PropertyNotFoundException(ELUtil.getExceptionMessageString(context, "propertyNotFound", new Object[] { baseClass.getName(), property }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 651 */     return bp;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/BeanELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */