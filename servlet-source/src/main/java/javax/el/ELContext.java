/*     */ package javax.el;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Stack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ELContext
/*     */ {
/*     */   private Locale locale;
/*     */   private boolean resolved;
/*     */   
/*     */   public void setPropertyResolved(boolean resolved) {
/*  99 */     this.resolved = resolved;
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
/*     */   public void setPropertyResolved(Object base, Object property) {
/* 117 */     setPropertyResolved(true);
/*     */     
/* 119 */     notifyPropertyResolved(base, property);
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
/*     */   public boolean isPropertyResolved() {
/* 133 */     return this.resolved;
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
/*     */   public void putContext(Class<?> key, Object contextObject) {
/* 154 */     if (key == null || contextObject == null) {
/* 155 */       throw new NullPointerException();
/*     */     }
/* 157 */     this.map.put(key, contextObject);
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
/*     */   public Object getContext(Class key) {
/* 179 */     if (key == null) {
/* 180 */       throw new NullPointerException();
/*     */     }
/* 182 */     return this.map.get(key);
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
/*     */   public abstract ELResolver getELResolver();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ImportHandler getImportHandler() {
/* 209 */     if (this.importHandler == null) {
/* 210 */       this.importHandler = new ImportHandler();
/*     */     }
/* 212 */     return this.importHandler;
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
/*     */   public abstract FunctionMapper getFunctionMapper();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/* 242 */     return this.locale;
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
/*     */   public void setLocale(Locale locale) {
/* 254 */     this.locale = locale;
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
/*     */   public abstract VariableMapper getVariableMapper();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addEvaluationListener(EvaluationListener listener) {
/* 275 */     if (this.listeners == null) {
/* 276 */       this.listeners = new ArrayList<>();
/*     */     }
/* 278 */     this.listeners.add(listener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<EvaluationListener> getEvaluationListeners() {
/* 288 */     return this.listeners;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyBeforeEvaluation(String expr) {
/* 296 */     if (getEvaluationListeners() == null)
/*     */       return; 
/* 298 */     for (EvaluationListener listener : getEvaluationListeners()) {
/* 299 */       listener.beforeEvaluation(this, expr);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyAfterEvaluation(String expr) {
/* 308 */     if (getEvaluationListeners() == null)
/*     */       return; 
/* 310 */     for (EvaluationListener listener : getEvaluationListeners()) {
/* 311 */       listener.afterEvaluation(this, expr);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyPropertyResolved(Object base, Object property) {
/* 321 */     if (getEvaluationListeners() == null)
/*     */       return; 
/* 323 */     for (EvaluationListener listener : getEvaluationListeners()) {
/* 324 */       listener.propertyResolved(this, base, property);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLambdaArgument(String arg) {
/* 334 */     if (this.lambdaArgs == null) {
/* 335 */       return false;
/*     */     }
/*     */     
/* 338 */     for (int i = this.lambdaArgs.size() - 1; i >= 0; i--) {
/* 339 */       Map<String, Object> lmap = this.lambdaArgs.elementAt(i);
/* 340 */       if (lmap.containsKey(arg)) {
/* 341 */         return true;
/*     */       }
/*     */     } 
/* 344 */     return false;
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
/*     */   public Object getLambdaArgument(String arg) {
/* 360 */     if (this.lambdaArgs == null) {
/* 361 */       return null;
/*     */     }
/*     */     
/* 364 */     for (int i = this.lambdaArgs.size() - 1; i >= 0; i--) {
/* 365 */       Map<String, Object> lmap = this.lambdaArgs.elementAt(i);
/* 366 */       Object v = lmap.get(arg);
/* 367 */       if (v != null) {
/* 368 */         return v;
/*     */       }
/*     */     } 
/* 371 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void enterLambdaScope(Map<String, Object> args) {
/* 382 */     if (this.lambdaArgs == null) {
/* 383 */       this.lambdaArgs = new Stack<>();
/*     */     }
/* 385 */     this.lambdaArgs.push(args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void exitLambdaScope() {
/* 394 */     if (this.lambdaArgs != null) {
/* 395 */       this.lambdaArgs.pop();
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
/*     */   public Object convertToType(Object obj, Class<?> targetType) {
/* 415 */     boolean propertyResolvedSave = isPropertyResolved();
/*     */     try {
/* 417 */       setPropertyResolved(false);
/* 418 */       ELResolver elResolver = getELResolver();
/* 419 */       if (elResolver != null) {
/* 420 */         Object res = elResolver.convertToType(this, obj, targetType);
/* 421 */         if (isPropertyResolved()) {
/* 422 */           return res;
/*     */         }
/*     */       } 
/* 425 */     } catch (ELException ex) {
/* 426 */       throw ex;
/* 427 */     } catch (Exception ex) {
/* 428 */       throw new ELException(ex);
/*     */     } finally {
/* 430 */       setPropertyResolved(propertyResolvedSave);
/*     */     } 
/*     */     
/* 433 */     ExpressionFactory exprFactory = (ExpressionFactory)getContext(ExpressionFactory.class);
/* 434 */     if (exprFactory == null) {
/* 435 */       exprFactory = ELUtil.getExpressionFactory();
/*     */     }
/* 437 */     return exprFactory.coerceToType(obj, targetType);
/*     */   }
/*     */ 
/*     */   
/* 441 */   private HashMap<Class<?>, Object> map = new HashMap<>();
/* 442 */   private transient List<EvaluationListener> listeners = null;
/*     */   private Stack<Map<String, Object>> lambdaArgs;
/*     */   private ImportHandler importHandler;
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ELContext.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */