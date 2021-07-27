/*     */ package javax.servlet.jsp.jstl.tlv;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Map;
/*     */ import javax.servlet.jsp.tagext.PageData;
/*     */ import javax.servlet.jsp.tagext.TagLibraryValidator;
/*     */ import javax.servlet.jsp.tagext.ValidationMessage;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.parsers.SAXParser;
/*     */ import javax.xml.parsers.SAXParserFactory;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.helpers.DefaultHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScriptFreeTLV
/*     */   extends TagLibraryValidator
/*     */ {
/*     */   private boolean allowDeclarations = false;
/*     */   private boolean allowScriptlets = false;
/*     */   private boolean allowExpressions = false;
/*     */   private boolean allowRTExpressions = false;
/*     */   private SAXParserFactory factory;
/*     */   
/*     */   public ScriptFreeTLV() {
/*  70 */     this.factory = SAXParserFactory.newInstance();
/*  71 */     this.factory.setValidating(false);
/*  72 */     this.factory.setNamespaceAware(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInitParameters(Map<String, Object> initParms) {
/*  81 */     super.setInitParameters(initParms);
/*  82 */     String declarationsParm = (String)initParms.get("allowDeclarations");
/*  83 */     String scriptletsParm = (String)initParms.get("allowScriptlets");
/*  84 */     String expressionsParm = (String)initParms.get("allowExpressions");
/*  85 */     String rtExpressionsParm = (String)initParms.get("allowRTExpressions");
/*     */     
/*  87 */     this.allowDeclarations = "true".equalsIgnoreCase(declarationsParm);
/*  88 */     this.allowScriptlets = "true".equalsIgnoreCase(scriptletsParm);
/*  89 */     this.allowExpressions = "true".equalsIgnoreCase(expressionsParm);
/*  90 */     this.allowRTExpressions = "true".equalsIgnoreCase(rtExpressionsParm);
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
/*     */   public ValidationMessage[] validate(String prefix, String uri, PageData page) {
/* 106 */     InputStream in = null;
/*     */     
/* 108 */     MyContentHandler handler = new MyContentHandler(); try {
/*     */       SAXParser parser;
/* 110 */       synchronized (this.factory) {
/* 111 */         parser = this.factory.newSAXParser();
/*     */       } 
/* 113 */       in = page.getInputStream();
/* 114 */       parser.parse(in, handler);
/*     */     }
/* 116 */     catch (ParserConfigurationException e) {
/* 117 */       return vmFromString(e.toString());
/*     */     }
/* 119 */     catch (SAXException e) {
/* 120 */       return vmFromString(e.toString());
/*     */     }
/* 122 */     catch (IOException e) {
/* 123 */       return vmFromString(e.toString());
/*     */     } finally {
/*     */       
/* 126 */       if (in != null) try { in.close(); } catch (IOException iOException) {} 
/*     */     } 
/* 128 */     return handler.reportResults();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class MyContentHandler
/*     */     extends DefaultHandler
/*     */   {
/* 137 */     private int declarationCount = 0;
/* 138 */     private int scriptletCount = 0;
/* 139 */     private int expressionCount = 0;
/* 140 */     private int rtExpressionCount = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void startElement(String namespaceUri, String localName, String qualifiedName, Attributes atts) {
/* 156 */       if (!ScriptFreeTLV.this.allowDeclarations && qualifiedName.equals("jsp:declaration")) {
/*     */         
/* 158 */         this.declarationCount++;
/* 159 */       } else if (!ScriptFreeTLV.this.allowScriptlets && qualifiedName.equals("jsp:scriptlet")) {
/*     */         
/* 161 */         this.scriptletCount++;
/* 162 */       } else if (!ScriptFreeTLV.this.allowExpressions && qualifiedName.equals("jsp:expression")) {
/*     */         
/* 164 */         this.expressionCount++;
/* 165 */       }  if (!ScriptFreeTLV.this.allowRTExpressions) countRTExpressions(atts);
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void countRTExpressions(Attributes atts) {
/* 176 */       int stop = atts.getLength();
/* 177 */       for (int i = 0; i < stop; i++) {
/* 178 */         String attval = atts.getValue(i);
/* 179 */         if (attval.startsWith("%=") && attval.endsWith("%")) {
/* 180 */           this.rtExpressionCount++;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ValidationMessage[] reportResults() {
/* 199 */       if (this.declarationCount + this.scriptletCount + this.expressionCount + this.rtExpressionCount > 0) {
/*     */         
/* 201 */         StringBuffer results = new StringBuffer("JSP page contains ");
/* 202 */         boolean first = true;
/* 203 */         if (this.declarationCount > 0) {
/* 204 */           results.append(Integer.toString(this.declarationCount));
/* 205 */           results.append(" declaration");
/* 206 */           if (this.declarationCount > 1) results.append('s'); 
/* 207 */           first = false;
/*     */         } 
/* 209 */         if (this.scriptletCount > 0) {
/* 210 */           if (!first) results.append(", "); 
/* 211 */           results.append(Integer.toString(this.scriptletCount));
/* 212 */           results.append(" scriptlet");
/* 213 */           if (this.scriptletCount > 1) results.append('s'); 
/* 214 */           first = false;
/*     */         } 
/* 216 */         if (this.expressionCount > 0) {
/* 217 */           if (!first) results.append(", "); 
/* 218 */           results.append(Integer.toString(this.expressionCount));
/* 219 */           results.append(" expression");
/* 220 */           if (this.expressionCount > 1) results.append('s'); 
/* 221 */           first = false;
/*     */         } 
/* 223 */         if (this.rtExpressionCount > 0) {
/* 224 */           if (!first) results.append(", "); 
/* 225 */           results.append(Integer.toString(this.rtExpressionCount));
/* 226 */           results.append(" request-time attribute value");
/* 227 */           if (this.rtExpressionCount > 1) results.append('s'); 
/* 228 */           first = false;
/*     */         } 
/* 230 */         results.append(".");
/* 231 */         return ScriptFreeTLV.vmFromString(results.toString());
/*     */       } 
/* 233 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     private MyContentHandler() {}
/*     */   }
/*     */   
/*     */   private static ValidationMessage[] vmFromString(String message) {
/* 241 */     return new ValidationMessage[] { new ValidationMessage(null, message) };
/*     */   }
/*     */ }


/* Location:              /Users/lionel/Downloads/javax.servlet.jsp.jstl-api-1.2.2.jar!/javax/servlet/jsp/jstl/tlv/ScriptFreeTLV.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */