/*     */ package javax.el;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.Properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FactoryFinder
/*     */ {
/*     */   private static Object newInstance(String className, ClassLoader classLoader, Properties properties) {
/*     */     try {
/*     */       Class<?> spiClass;
/*  43 */       if (classLoader == null) {
/*  44 */         spiClass = Class.forName(className);
/*     */       } else {
/*  46 */         spiClass = classLoader.loadClass(className);
/*     */       } 
/*  48 */       if (properties != null) {
/*  49 */         Constructor<?> constr = null;
/*     */         try {
/*  51 */           constr = spiClass.getConstructor(new Class[] { Properties.class });
/*  52 */         } catch (Exception exception) {}
/*     */         
/*  54 */         if (constr != null) {
/*  55 */           return constr.newInstance(new Object[] { properties });
/*     */         }
/*     */       } 
/*  58 */       return spiClass.newInstance();
/*  59 */     } catch (ClassNotFoundException x) {
/*  60 */       throw new ELException("Provider " + className + " not found", x);
/*     */     }
/*  62 */     catch (Exception x) {
/*  63 */       throw new ELException("Provider " + className + " could not be instantiated: " + x, x);
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
/*     */   static Object find(String factoryId, String fallbackClassName, Properties properties) {
/*     */     ClassLoader classLoader;
/*     */     try {
/*  94 */       classLoader = Thread.currentThread().getContextClassLoader();
/*  95 */     } catch (Exception x) {
/*  96 */       throw new ELException(x.toString(), x);
/*     */     } 
/*     */     
/*  99 */     String serviceId = "META-INF/services/" + factoryId;
/*     */     
/*     */     try {
/* 102 */       InputStream is = null;
/* 103 */       if (classLoader == null) {
/* 104 */         is = ClassLoader.getSystemResourceAsStream(serviceId);
/*     */       } else {
/* 106 */         is = classLoader.getResourceAsStream(serviceId);
/*     */       } 
/*     */       
/* 109 */       if (is != null) {
/* 110 */         BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
/*     */ 
/*     */         
/* 113 */         String factoryClassName = rd.readLine();
/* 114 */         rd.close();
/*     */         
/* 116 */         if (factoryClassName != null && !"".equals(factoryClassName))
/*     */         {
/* 118 */           return newInstance(factoryClassName, classLoader, properties);
/*     */         }
/*     */       } 
/* 121 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 127 */       String javah = System.getProperty("java.home");
/* 128 */       String configFile = javah + File.separator + "lib" + File.separator + "el.properties";
/*     */       
/* 130 */       File f = new File(configFile);
/* 131 */       if (f.exists()) {
/* 132 */         Properties props = new Properties();
/* 133 */         props.load(new FileInputStream(f));
/* 134 */         String factoryClassName = props.getProperty(factoryId);
/* 135 */         return newInstance(factoryClassName, classLoader, properties);
/*     */       } 
/* 137 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 143 */       String systemProp = System.getProperty(factoryId);
/*     */       
/* 145 */       if (systemProp != null) {
/* 146 */         return newInstance(systemProp, classLoader, properties);
/*     */       }
/* 148 */     } catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 151 */     if (fallbackClassName == null) {
/* 152 */       throw new ELException("Provider for " + factoryId + " cannot be found", null);
/*     */     }
/*     */ 
/*     */     
/* 156 */     return newInstance(fallbackClassName, classLoader, properties);
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/FactoryFinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */