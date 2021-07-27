/*     */ package javax.el;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LambdaExpression
/*     */ {
/*  75 */   private List<String> formalParameters = new ArrayList<>();
/*     */   
/*     */   private ValueExpression expression;
/*     */   private ELContext context;
/*  79 */   private Map<String, Object> envirArgs = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LambdaExpression(List<String> formalParameters, ValueExpression expression) {
/*  90 */     this.formalParameters = formalParameters;
/*  91 */     this.expression = expression;
/*  92 */     this.envirArgs = new HashMap<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setELContext(ELContext context) {
/* 102 */     this.context = context;
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
/*     */   public Object invoke(ELContext elContext, Object... args) throws ELException {
/* 128 */     int i = 0;
/* 129 */     Map<String, Object> lambdaArgs = new HashMap<>();
/*     */ 
/*     */     
/* 132 */     lambdaArgs.putAll(this.envirArgs);
/*     */     
/* 134 */     for (String fParam : this.formalParameters) {
/* 135 */       if (i >= args.length) {
/* 136 */         throw new ELException("Expected Argument " + fParam + " missing in Lambda Expression");
/*     */       }
/*     */       
/* 139 */       lambdaArgs.put(fParam, args[i++]);
/*     */     } 
/*     */     
/* 142 */     elContext.enterLambdaScope(lambdaArgs);
/* 143 */     Object ret = this.expression.getValue(elContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     if (ret instanceof LambdaExpression) {
/* 152 */       ((LambdaExpression)ret).envirArgs.putAll(lambdaArgs);
/*     */     }
/* 154 */     elContext.exitLambdaScope();
/* 155 */     return ret;
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
/*     */   public Object invoke(Object... args) {
/* 180 */     return invoke(this.context, args);
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.el-api-3.0.1-b06.jar!/javax/el/LambdaExpression.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */