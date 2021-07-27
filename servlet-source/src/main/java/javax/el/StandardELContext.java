/*     */ package javax.el;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StandardELContext
/*     */   extends ELContext
/*     */ {
/*     */   private ELResolver elResolver;
/*     */   private CompositeELResolver customResolvers;
/*     */   private ELResolver streamELResolver;
/*     */   private FunctionMapper functionMapper;
/*     */   private Map<String, Method> initFunctionMap;
/*     */   private VariableMapper variableMapper;
/*  94 */   private ELContext delegate = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   private Map<String, Object> beans = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StandardELContext(ExpressionFactory factory) {
/* 106 */     this.streamELResolver = factory.getStreamELResolver();
/* 107 */     this.initFunctionMap = factory.getInitFunctionMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StandardELContext(ELContext context) {
/* 115 */     this.delegate = context;
/*     */     
/* 117 */     CompositeELResolver elr = new CompositeELResolver();
/* 118 */     elr.add(new BeanNameELResolver(new LocalBeanNameResolver()));
/* 119 */     this.customResolvers = new CompositeELResolver();
/* 120 */     elr.add(this.customResolvers);
/* 121 */     elr.add(context.getELResolver());
/* 122 */     this.elResolver = elr;
/*     */     
/* 124 */     this.functionMapper = context.getFunctionMapper();
/* 125 */     this.variableMapper = context.getVariableMapper();
/* 126 */     setLocale(context.getLocale());
/*     */   }
/*     */ 
/*     */   
/*     */   public void putContext(Class key, Object contextObject) {
/* 131 */     if (this.delegate != null) {
/* 132 */       this.delegate.putContext(key, contextObject);
/*     */     } else {
/* 134 */       super.putContext(key, contextObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getContext(Class key) {
/* 140 */     if (this.delegate != null) {
/* 141 */       return this.delegate.getContext(key);
/*     */     }
/* 143 */     return super.getContext(key);
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
/*     */   public ELResolver getELResolver() {
/* 168 */     if (this.elResolver == null) {
/* 169 */       CompositeELResolver resolver = new CompositeELResolver();
/* 170 */       this.customResolvers = new CompositeELResolver();
/* 171 */       resolver.add(this.customResolvers);
/* 172 */       resolver.add(new BeanNameELResolver(new LocalBeanNameResolver()));
/* 173 */       if (this.streamELResolver != null) {
/* 174 */         resolver.add(this.streamELResolver);
/*     */       }
/* 176 */       resolver.add(new StaticFieldELResolver());
/* 177 */       resolver.add(new MapELResolver());
/* 178 */       resolver.add(new ResourceBundleELResolver());
/* 179 */       resolver.add(new ListELResolver());
/* 180 */       resolver.add(new ArrayELResolver());
/* 181 */       resolver.add(new BeanELResolver());
/* 182 */       this.elResolver = resolver;
/*     */     } 
/* 184 */     return this.elResolver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addELResolver(ELResolver cELResolver) {
/* 194 */     getELResolver();
/* 195 */     this.customResolvers.add(cELResolver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Map<String, Object> getBeans() {
/* 203 */     return this.beans;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionMapper getFunctionMapper() {
/* 212 */     if (this.functionMapper == null) {
/* 213 */       this.functionMapper = new DefaultFunctionMapper(this.initFunctionMap);
/*     */     }
/* 215 */     return this.functionMapper;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VariableMapper getVariableMapper() {
/* 224 */     if (this.variableMapper == null) {
/* 225 */       this.variableMapper = new DefaultVariableMapper();
/*     */     }
/* 227 */     return this.variableMapper;
/*     */   }
/*     */   
/*     */   private static class DefaultFunctionMapper
/*     */     extends FunctionMapper {
/* 232 */     private Map<String, Method> functions = null;
/*     */     
/*     */     DefaultFunctionMapper(Map<String, Method> initMap) {
/* 235 */       this.functions = (initMap == null) ? new HashMap<>() : new HashMap<>(initMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Method resolveFunction(String prefix, String localName) {
/* 242 */       return this.functions.get(prefix + ":" + localName);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void mapFunction(String prefix, String localName, Method meth) {
/* 248 */       this.functions.put(prefix + ":" + localName, meth);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class DefaultVariableMapper
/*     */     extends VariableMapper {
/* 254 */     private Map<String, ValueExpression> variables = null;
/*     */ 
/*     */     
/*     */     public ValueExpression resolveVariable(String variable) {
/* 258 */       if (this.variables == null) {
/* 259 */         return null;
/*     */       }
/* 261 */       return this.variables.get(variable);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ValueExpression setVariable(String variable, ValueExpression expression) {
/* 267 */       if (this.variables == null) {
/* 268 */         this.variables = new HashMap<>();
/*     */       }
/* 270 */       ValueExpression prev = null;
/* 271 */       if (expression == null) {
/* 272 */         prev = this.variables.remove(variable);
/*     */       } else {
/* 274 */         prev = this.variables.put(variable, expression);
/*     */       } 
/* 276 */       return prev;
/*     */     }
/*     */     
/*     */     private DefaultVariableMapper() {}
/*     */   }
/*     */   
/*     */   private class LocalBeanNameResolver extends BeanNameResolver {
/*     */     public boolean isNameResolved(String beanName) {
/* 284 */       return StandardELContext.this.beans.containsKey(beanName);
/*     */     }
/*     */     private LocalBeanNameResolver() {}
/*     */     
/*     */     public Object getBean(String beanName) {
/* 289 */       return StandardELContext.this.beans.get(beanName);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setBeanValue(String beanName, Object value) {
/* 294 */       StandardELContext.this.beans.put(beanName, value);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isReadOnly(String beanName) {
/* 299 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean canCreateBean(String beanName) {
/* 304 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/StandardELContext.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */