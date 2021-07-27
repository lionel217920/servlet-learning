/*     */ package javax.el;
/*     */ 
/*     */ import java.beans.FeatureDescriptor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.ResourceBundle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResourceBundleELResolver
/*     */   extends ELResolver
/*     */ {
/*     */   public Object getValue(ELContext context, Object base, Object property) {
/*  92 */     if (context == null) {
/*  93 */       throw new NullPointerException();
/*     */     }
/*     */     
/*  96 */     if (base instanceof ResourceBundle) {
/*  97 */       context.setPropertyResolved(true);
/*  98 */       if (property != null) {
/*     */         try {
/* 100 */           return ((ResourceBundle)base).getObject(property.toString());
/*     */         }
/* 102 */         catch (MissingResourceException e) {
/* 103 */           return "???" + property + "???";
/*     */         } 
/*     */       }
/*     */     } 
/* 107 */     return null;
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
/* 135 */     if (context == null) {
/* 136 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 139 */     if (base instanceof ResourceBundle) {
/* 140 */       context.setPropertyResolved(true);
/*     */     }
/* 142 */     return null;
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
/*     */   public void setValue(ELContext context, Object base, Object property, Object value) {
/* 165 */     if (context == null) {
/* 166 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 169 */     if (base instanceof ResourceBundle) {
/* 170 */       context.setPropertyResolved(true);
/* 171 */       throw new PropertyNotWritableException("ResourceBundles are immutable");
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
/*     */   public boolean isReadOnly(ELContext context, Object base, Object property) {
/* 194 */     if (context == null) {
/* 195 */       throw new NullPointerException();
/*     */     }
/* 197 */     if (base instanceof ResourceBundle) {
/* 198 */       context.setPropertyResolved(true);
/* 199 */       return true;
/*     */     } 
/* 201 */     return false;
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
/*     */   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
/* 242 */     if (base instanceof ResourceBundle) {
/* 243 */       ResourceBundle bundle = (ResourceBundle)base;
/* 244 */       List<FeatureDescriptor> features = new ArrayList<>();
/* 245 */       String key = null;
/* 246 */       FeatureDescriptor desc = null;
/* 247 */       for (Enumeration<String> e = bundle.getKeys(); e.hasMoreElements(); ) {
/* 248 */         key = e.nextElement();
/* 249 */         desc = new FeatureDescriptor();
/* 250 */         desc.setDisplayName(key);
/* 251 */         desc.setExpert(false);
/* 252 */         desc.setHidden(false);
/* 253 */         desc.setName(key);
/* 254 */         desc.setPreferred(true);
/* 255 */         desc.setValue("type", String.class);
/* 256 */         desc.setValue("resolvableAtDesignTime", Boolean.TRUE);
/* 257 */         features.add(desc);
/*     */       } 
/* 259 */       return features.iterator();
/*     */     } 
/* 261 */     return null;
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
/* 282 */     if (base instanceof ResourceBundle) {
/* 283 */       return String.class;
/*     */     }
/* 285 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ResourceBundleELResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */