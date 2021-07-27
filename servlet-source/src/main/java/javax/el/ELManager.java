/*     */ package javax.el;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ELManager
/*     */ {
/*     */   private StandardELContext elContext;
/*     */   
/*     */   public static ExpressionFactory getExpressionFactory() {
/*  61 */     return ELUtil.getExpressionFactory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StandardELContext getELContext() {
/*  72 */     if (this.elContext == null) {
/*  73 */       this.elContext = new StandardELContext(getExpressionFactory());
/*     */     }
/*  75 */     return this.elContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ELContext setELContext(ELContext context) {
/*  86 */     ELContext prev = this.elContext;
/*  87 */     this.elContext = new StandardELContext(context);
/*  88 */     return prev;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addBeanNameResolver(BeanNameResolver bnr) {
/*  99 */     getELContext().addELResolver(new BeanNameELResolver(bnr));
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
/*     */   public void addELResolver(ELResolver elr) {
/* 113 */     getELContext().addELResolver(elr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mapFunction(String prefix, String function, Method meth) {
/* 123 */     getELContext().getFunctionMapper().mapFunction(prefix, function, meth);
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
/*     */   public void setVariable(String variable, ValueExpression expression) {
/* 137 */     getELContext().getVariableMapper().setVariable(variable, expression);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void importStatic(String staticMemberName) throws ELException {
/* 147 */     getELContext().getImportHandler().importStatic(staticMemberName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void importClass(String className) throws ELException {
/* 157 */     getELContext().getImportHandler().importClass(className);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void importPackage(String packageName) {
/* 168 */     getELContext().getImportHandler().importPackage(packageName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object defineBean(String name, Object bean) {
/* 178 */     Object ret = getELContext().getBeans().get(name);
/* 179 */     getELContext().getBeans().put(name, bean);
/* 180 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addEvaluationListener(EvaluationListener listener) {
/* 189 */     getELContext().addEvaluationListener(listener);
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/ELManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */