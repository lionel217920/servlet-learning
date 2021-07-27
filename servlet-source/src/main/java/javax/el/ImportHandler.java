/*     */ package javax.el;
/*     */ 
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
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
/*     */ public class ImportHandler
/*     */ {
/*     */   private Map<String, String> classNameMap;
/*     */   private Map<String, Class<?>> classMap;
/*     */   private Map<String, String> staticNameMap;
/*     */   private HashSet<String> notAClass;
/*     */   private List<String> packages;
/*     */   
/*     */   public ImportHandler() {
/*  59 */     this.classNameMap = new HashMap<>();
/*  60 */     this.classMap = new HashMap<>();
/*  61 */     this.staticNameMap = new HashMap<>();
/*  62 */     this.notAClass = new HashSet<>();
/*  63 */     this.packages = new ArrayList<>();
/*     */ 
/*     */     
/*  66 */     importPackage("java.lang");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void importStatic(String name) throws ELException {
/*  76 */     int i = name.lastIndexOf('.');
/*  77 */     if (i <= 0) {
/*  78 */       throw new ELException("The name " + name + " is not a full static member name");
/*     */     }
/*     */     
/*  81 */     String memberName = name.substring(i + 1);
/*  82 */     String className = name.substring(0, i);
/*  83 */     this.staticNameMap.put(memberName, className);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void importClass(String name) throws ELException {
/*  92 */     int i = name.lastIndexOf('.');
/*  93 */     if (i <= 0) {
/*  94 */       throw new ELException("The name " + name + " is not a full class name");
/*     */     }
/*     */     
/*  97 */     String className = name.substring(i + 1);
/*  98 */     this.classNameMap.put(className, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void importPackage(String packageName) {
/* 106 */     this.packages.add(packageName);
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
/*     */   public Class<?> resolveClass(String name) {
/* 121 */     String className = this.classNameMap.get(name);
/* 122 */     if (className != null) {
/* 123 */       return resolveClassFor(className);
/*     */     }
/*     */     
/* 126 */     for (String packageName : this.packages) {
/* 127 */       String fullClassName = packageName + "." + name;
/* 128 */       Class<?> c = resolveClassFor(fullClassName);
/* 129 */       if (c != null) {
/* 130 */         this.classNameMap.put(name, fullClassName);
/* 131 */         return c;
/*     */       } 
/*     */     } 
/* 134 */     return null;
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
/*     */   public Class<?> resolveStatic(String name) {
/* 150 */     String className = this.staticNameMap.get(name);
/* 151 */     if (className != null) {
/* 152 */       Class<?> c = resolveClassFor(className);
/* 153 */       if (c != null) {
/* 154 */         return c;
/*     */       }
/*     */     } 
/* 157 */     return null;
/*     */   }
/*     */   
/*     */   private Class<?> resolveClassFor(String className) {
/* 161 */     Class<?> c = this.classMap.get(className);
/* 162 */     if (c != null) {
/* 163 */       return c;
/*     */     }
/* 165 */     c = getClassFor(className);
/* 166 */     if (c != null) {
/* 167 */       checkModifiers(c.getModifiers());
/* 168 */       this.classMap.put(className, c);
/*     */     } 
/* 170 */     return c;
/*     */   }
/*     */   
/*     */   private Class<?> getClassFor(String className) {
/* 174 */     if (!this.notAClass.contains(className)) {
/*     */       try {
/* 176 */         return Class.forName(className, false, Thread.currentThread().getContextClassLoader());
/* 177 */       } catch (ClassNotFoundException ex) {
/* 178 */         this.notAClass.add(className);
/*     */       } 
/*     */     }
/* 181 */     return null;
/*     */   }
/*     */   
/*     */   private void checkModifiers(int modifiers) {
/* 185 */     if (Modifier.isAbstract(modifiers) || Modifier.isInterface(modifiers) || !Modifier.isPublic(modifiers))
/*     */     {
/* 187 */       throw new ELException("Imported class must be public, and cannot be abstract or an interface");
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ImportHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */