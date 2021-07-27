/*     */ package javax.servlet.jsp.el;
/*     */ 
/*     */ import java.beans.FeatureDescriptor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import javax.el.ELClass;
/*     */ import javax.el.ELContext;
/*     */ import javax.el.ELResolver;
/*     */ import javax.servlet.jsp.JspContext;
/*     */ import javax.servlet.jsp.PageContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScopedAttributeELResolver
/*     */   extends ELResolver
/*     */ {
/*     */   public Object getValue(ELContext context, Object base, Object property) {
/* 118 */     if (context == null) {
/* 119 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 122 */     if (base == null) {
/* 123 */       context.setPropertyResolved(true);
/* 124 */       if (property instanceof String) {
/* 125 */         String attribute = (String)property;
/* 126 */         PageContext ctxt = (PageContext)context.getContext(JspContext.class);
/*     */         
/* 128 */         Object value = ctxt.findAttribute(attribute);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 137 */         if (value == null)
/*     */         {
/* 139 */           if (context.getImportHandler() != null) {
/* 140 */             Class<?> c = context.getImportHandler().resolveClass(attribute);
/* 141 */             if (c != null) {
/* 142 */               value = new ELClass(c);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 148 */         return value;
/*     */       } 
/*     */     } 
/* 151 */     return null;
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
/*     */   public Class<Object> getType(ELContext context, Object base, Object property) {
/* 182 */     if (context == null) {
/* 183 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 186 */     if (base == null) {
/* 187 */       context.setPropertyResolved(true);
/* 188 */       return Object.class;
/*     */     } 
/* 190 */     return null;
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
/*     */   public void setValue(ELContext context, Object base, Object property, Object val) {
/* 226 */     if (context == null) {
/* 227 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 230 */     if (base == null) {
/* 231 */       context.setPropertyResolved(true);
/* 232 */       if (property instanceof String) {
/* 233 */         PageContext ctxt = (PageContext)context.getContext(JspContext.class);
/*     */         
/* 235 */         String attr = (String)property;
/* 236 */         if (ctxt.getAttribute(attr, 2) != null) {
/* 237 */           ctxt.setAttribute(attr, val, 2);
/* 238 */         } else if (ctxt.getAttribute(attr, 3) != null) {
/* 239 */           ctxt.setAttribute(attr, val, 3);
/* 240 */         } else if (ctxt.getAttribute(attr, 4) != null) {
/* 241 */           ctxt.setAttribute(attr, val, 4);
/*     */         } else {
/* 243 */           ctxt.setAttribute(attr, val, 1);
/*     */         } 
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
/*     */   public boolean isReadOnly(ELContext context, Object base, Object property) {
/* 275 */     if (context == null) {
/* 276 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 279 */     if (base == null) {
/* 280 */       context.setPropertyResolved(true);
/*     */     }
/* 282 */     return false;
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
/*     */   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
/* 325 */     ArrayList<FeatureDescriptor> list = new ArrayList<>();
/* 326 */     PageContext ctxt = (PageContext)context.getContext(JspContext.class);
/*     */     
/* 328 */     Enumeration<String> attrs = ctxt.getAttributeNamesInScope(1);
/* 329 */     while (attrs.hasMoreElements()) {
/* 330 */       String name = attrs.nextElement();
/* 331 */       Object value = ctxt.getAttribute(name, 1);
/* 332 */       FeatureDescriptor descriptor = new FeatureDescriptor();
/* 333 */       descriptor.setName(name);
/* 334 */       descriptor.setDisplayName(name);
/* 335 */       descriptor.setShortDescription("page scope attribute");
/* 336 */       descriptor.setExpert(false);
/* 337 */       descriptor.setHidden(false);
/* 338 */       descriptor.setPreferred(true);
/* 339 */       descriptor.setValue("type", value.getClass());
/* 340 */       descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/* 341 */       list.add(descriptor);
/*     */     } 
/*     */     
/* 344 */     attrs = ctxt.getAttributeNamesInScope(2);
/* 345 */     while (attrs.hasMoreElements()) {
/* 346 */       String name = attrs.nextElement();
/* 347 */       Object value = ctxt.getAttribute(name, 2);
/* 348 */       FeatureDescriptor descriptor = new FeatureDescriptor();
/* 349 */       descriptor.setName(name);
/* 350 */       descriptor.setDisplayName(name);
/* 351 */       descriptor.setShortDescription("request scope attribute");
/* 352 */       descriptor.setExpert(false);
/* 353 */       descriptor.setHidden(false);
/* 354 */       descriptor.setPreferred(true);
/* 355 */       descriptor.setValue("type", value.getClass());
/* 356 */       descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/* 357 */       list.add(descriptor);
/*     */     } 
/*     */     
/* 360 */     attrs = ctxt.getAttributeNamesInScope(3);
/* 361 */     while (attrs.hasMoreElements()) {
/* 362 */       String name = attrs.nextElement();
/* 363 */       Object value = ctxt.getAttribute(name, 3);
/* 364 */       FeatureDescriptor descriptor = new FeatureDescriptor();
/* 365 */       descriptor.setName(name);
/* 366 */       descriptor.setDisplayName(name);
/* 367 */       descriptor.setShortDescription("session scope attribute");
/* 368 */       descriptor.setExpert(false);
/* 369 */       descriptor.setHidden(false);
/* 370 */       descriptor.setPreferred(true);
/* 371 */       descriptor.setValue("type", value.getClass());
/* 372 */       descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/* 373 */       list.add(descriptor);
/*     */     } 
/*     */     
/* 376 */     attrs = ctxt.getAttributeNamesInScope(4);
/* 377 */     while (attrs.hasMoreElements()) {
/* 378 */       String name = attrs.nextElement();
/* 379 */       Object value = ctxt.getAttribute(name, 4);
/* 380 */       FeatureDescriptor descriptor = new FeatureDescriptor();
/* 381 */       descriptor.setName(name);
/* 382 */       descriptor.setDisplayName(name);
/* 383 */       descriptor.setShortDescription("application scope attribute");
/* 384 */       descriptor.setExpert(false);
/* 385 */       descriptor.setHidden(false);
/* 386 */       descriptor.setPreferred(true);
/* 387 */       descriptor.setValue("type", value.getClass());
/* 388 */       descriptor.setValue("resolvableAtDesignTime", Boolean.TRUE);
/* 389 */       list.add(descriptor);
/*     */     } 
/* 391 */     return list.iterator();
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
/*     */   public Class<String> getCommonPropertyType(ELContext context, Object base) {
/* 406 */     if (base == null) {
/* 407 */       return String.class;
/*     */     }
/* 409 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp-api-2.3.3.jar!/javax/servlet/jsp/el/ScopedAttributeELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */