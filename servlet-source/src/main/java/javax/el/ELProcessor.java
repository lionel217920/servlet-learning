/*     */ package javax.el;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ELProcessor
/*     */ {
/*  98 */   private ELManager elManager = new ELManager();
/*  99 */   private ExpressionFactory factory = ELManager.getExpressionFactory();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ELManager getELManager() {
/* 106 */     return this.elManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object eval(String expression) {
/* 115 */     return getValue(expression, Object.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue(String expression, Class<?> expectedType) {
/* 126 */     ValueExpression exp = this.factory.createValueExpression(this.elManager.getELContext(), bracket(expression), expectedType);
/*     */ 
/*     */     
/* 129 */     return exp.getValue(this.elManager.getELContext());
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
/*     */   public void setValue(String expression, Object value) {
/* 151 */     ValueExpression exp = this.factory.createValueExpression(this.elManager.getELContext(), bracket(expression), Object.class);
/*     */ 
/*     */     
/* 154 */     exp.setValue(this.elManager.getELContext(), value);
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
/*     */   public void setVariable(String var, String expression) {
/* 167 */     ValueExpression exp = this.factory.createValueExpression(this.elManager.getELContext(), bracket(expression), Object.class);
/*     */ 
/*     */     
/* 170 */     this.elManager.setVariable(var, exp);
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
/*     */   public void defineFunction(String prefix, String function, String className, String method) throws ClassNotFoundException, NoSuchMethodException {
/* 197 */     if (prefix == null || function == null || className == null || method == null)
/*     */     {
/* 199 */       throw new NullPointerException("Null argument for defineFunction");
/*     */     }
/*     */     
/* 202 */     Method meth = null;
/* 203 */     ClassLoader loader = Thread.currentThread().getContextClassLoader();
/* 204 */     if (loader == null)
/* 205 */       loader = getClass().getClassLoader(); 
/* 206 */     Class<?> klass = Class.forName(className, false, loader);
/* 207 */     int j = method.indexOf('(');
/* 208 */     if (j < 0) {
/*     */       
/* 210 */       for (Method m : klass.getDeclaredMethods()) {
/* 211 */         if (m.getName().equals(method)) {
/* 212 */           meth = m;
/*     */         }
/*     */       } 
/* 215 */       if (meth == null) {
/* 216 */         throw new NoSuchMethodException("Bad method name: " + method);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 221 */       int p = method.indexOf(' ');
/* 222 */       if (p < 0) {
/* 223 */         throw new NoSuchMethodException("Bad method singnature: " + method);
/*     */       }
/*     */       
/* 226 */       String methodName = method.substring(p + 1, j).trim();
/*     */       
/* 228 */       p = method.indexOf(')', j + 1);
/* 229 */       if (p < 0) {
/* 230 */         throw new NoSuchMethodException("Bad method singnature: " + method);
/*     */       }
/*     */       
/* 233 */       String[] params = method.substring(j + 1, p).split(",");
/* 234 */       Class<?>[] paramTypes = new Class[params.length];
/* 235 */       for (int i = 0; i < params.length; i++) {
/* 236 */         paramTypes[i] = toClass(params[i], loader);
/*     */       }
/* 238 */       meth = klass.getDeclaredMethod(methodName, paramTypes);
/*     */     } 
/* 240 */     if (!Modifier.isStatic(meth.getModifiers())) {
/* 241 */       throw new NoSuchMethodException("The method specified in defineFunction must be static: " + meth);
/*     */     }
/* 243 */     if (function.equals("")) {
/* 244 */       function = method;
/*     */     }
/* 246 */     this.elManager.mapFunction(prefix, function, meth);
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
/*     */   public void defineFunction(String prefix, String function, Method method) throws NoSuchMethodException {
/* 261 */     if (prefix == null || function == null || method == null) {
/* 262 */       throw new NullPointerException("Null argument for defineFunction");
/*     */     }
/* 264 */     if (!Modifier.isStatic(method.getModifiers())) {
/* 265 */       throw new NoSuchMethodException("The method specified in defineFunction must be static: " + method);
/*     */     }
/* 267 */     if (function.equals("")) {
/* 268 */       function = method.getName();
/*     */     }
/* 270 */     this.elManager.mapFunction(prefix, function, method);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void defineBean(String name, Object bean) {
/* 281 */     this.elManager.defineBean(name, bean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<?> toClass(String type, ClassLoader loader) throws ClassNotFoundException {
/* 291 */     Class<?> c = null;
/* 292 */     int i0 = type.indexOf('[');
/* 293 */     int dims = 0;
/* 294 */     if (i0 > 0) {
/*     */       
/* 296 */       for (int i = 0; i < type.length(); i++) {
/* 297 */         if (type.charAt(i) == '[')
/* 298 */           dims++; 
/*     */       } 
/* 300 */       type = type.substring(0, i0);
/*     */     } 
/*     */     
/* 303 */     if ("boolean".equals(type)) {
/* 304 */       c = boolean.class;
/* 305 */     } else if ("char".equals(type)) {
/* 306 */       c = char.class;
/* 307 */     } else if ("byte".equals(type)) {
/* 308 */       c = byte.class;
/* 309 */     } else if ("short".equals(type)) {
/* 310 */       c = short.class;
/* 311 */     } else if ("int".equals(type)) {
/* 312 */       c = int.class;
/* 313 */     } else if ("long".equals(type)) {
/* 314 */       c = long.class;
/* 315 */     } else if ("float".equals(type)) {
/* 316 */       c = float.class;
/* 317 */     } else if ("double".equals(type)) {
/* 318 */       c = double.class;
/*     */     } else {
/* 320 */       c = loader.loadClass(type);
/*     */     } 
/* 322 */     if (dims == 0) {
/* 323 */       return c;
/*     */     }
/* 325 */     if (dims == 1) {
/* 326 */       return Array.newInstance(c, 1).getClass();
/*     */     }
/*     */     
/* 329 */     return Array.newInstance(c, new int[dims]).getClass();
/*     */   }
/*     */   
/*     */   private String bracket(String expression) {
/* 333 */     return "${" + expression + '}';
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ELProcessor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */