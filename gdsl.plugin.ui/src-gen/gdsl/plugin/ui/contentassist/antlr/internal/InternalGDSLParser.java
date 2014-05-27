package gdsl.plugin.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import gdsl.plugin.services.GDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGDSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_CONS", "RULE_ID", "RULE_POSINT", "RULE_NEGINT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "';'", "'='", "'type'", "'['", "']'", "','", "'val'", "'{'", "'}'", "'|'", "'of'", "':'", "'granularity'", "'export'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_POSINT=6;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int RULE_CONS=4;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_NEGINT=7;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalGDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGDSLParser.tokenNames; }
    public String getGrammarFileName() { return "../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g"; }


     
     	private GDSLGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(GDSLGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:61:1: ( ruleModel EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:69:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:73:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:74:1: ( ( rule__Model__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:74:1: ( ( rule__Model__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:75:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:76:1: ( rule__Model__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:76:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDecl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:88:1: entryRuleDecl : ruleDecl EOF ;
    public final void entryRuleDecl() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:89:1: ( ruleDecl EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:90:1: ruleDecl EOF
            {
             before(grammarAccess.getDeclRule()); 
            pushFollow(FOLLOW_ruleDecl_in_entryRuleDecl121);
            ruleDecl();

            state._fsp--;

             after(grammarAccess.getDeclRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecl128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDecl"


    // $ANTLR start "ruleDecl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:97:1: ruleDecl : ( ( rule__Decl__Alternatives ) ) ;
    public final void ruleDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:101:2: ( ( ( rule__Decl__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:102:1: ( ( rule__Decl__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:102:1: ( ( rule__Decl__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:103:1: ( rule__Decl__Alternatives )
            {
             before(grammarAccess.getDeclAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:104:1: ( rule__Decl__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:104:2: rule__Decl__Alternatives
            {
            pushFollow(FOLLOW_rule__Decl__Alternatives_in_ruleDecl154);
            rule__Decl__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDeclAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDecl"


    // $ANTLR start "entryRuleDeclGranularity"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:116:1: entryRuleDeclGranularity : ruleDeclGranularity EOF ;
    public final void entryRuleDeclGranularity() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:117:1: ( ruleDeclGranularity EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:118:1: ruleDeclGranularity EOF
            {
             before(grammarAccess.getDeclGranularityRule()); 
            pushFollow(FOLLOW_ruleDeclGranularity_in_entryRuleDeclGranularity181);
            ruleDeclGranularity();

            state._fsp--;

             after(grammarAccess.getDeclGranularityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclGranularity188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeclGranularity"


    // $ANTLR start "ruleDeclGranularity"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:125:1: ruleDeclGranularity : ( ( rule__DeclGranularity__Group__0 ) ) ;
    public final void ruleDeclGranularity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:129:2: ( ( ( rule__DeclGranularity__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:130:1: ( ( rule__DeclGranularity__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:130:1: ( ( rule__DeclGranularity__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:131:1: ( rule__DeclGranularity__Group__0 )
            {
             before(grammarAccess.getDeclGranularityAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:132:1: ( rule__DeclGranularity__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:132:2: rule__DeclGranularity__Group__0
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__0_in_ruleDeclGranularity214);
            rule__DeclGranularity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeclGranularityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclGranularity"


    // $ANTLR start "entryRuleDeclExport"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:144:1: entryRuleDeclExport : ruleDeclExport EOF ;
    public final void entryRuleDeclExport() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:145:1: ( ruleDeclExport EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:146:1: ruleDeclExport EOF
            {
             before(grammarAccess.getDeclExportRule()); 
            pushFollow(FOLLOW_ruleDeclExport_in_entryRuleDeclExport241);
            ruleDeclExport();

            state._fsp--;

             after(grammarAccess.getDeclExportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclExport248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeclExport"


    // $ANTLR start "ruleDeclExport"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:153:1: ruleDeclExport : ( ( rule__DeclExport__Group__0 ) ) ;
    public final void ruleDeclExport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:157:2: ( ( ( rule__DeclExport__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:158:1: ( ( rule__DeclExport__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:158:1: ( ( rule__DeclExport__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:159:1: ( rule__DeclExport__Group__0 )
            {
             before(grammarAccess.getDeclExportAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:160:1: ( rule__DeclExport__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:160:2: rule__DeclExport__Group__0
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__0_in_ruleDeclExport274);
            rule__DeclExport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeclExportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclExport"


    // $ANTLR start "entryRuleDeclType"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:172:1: entryRuleDeclType : ruleDeclType EOF ;
    public final void entryRuleDeclType() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:173:1: ( ruleDeclType EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:174:1: ruleDeclType EOF
            {
             before(grammarAccess.getDeclTypeRule()); 
            pushFollow(FOLLOW_ruleDeclType_in_entryRuleDeclType301);
            ruleDeclType();

            state._fsp--;

             after(grammarAccess.getDeclTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclType308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeclType"


    // $ANTLR start "ruleDeclType"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:181:1: ruleDeclType : ( ( rule__DeclType__Alternatives ) ) ;
    public final void ruleDeclType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:185:2: ( ( ( rule__DeclType__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:186:1: ( ( rule__DeclType__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:186:1: ( ( rule__DeclType__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:187:1: ( rule__DeclType__Alternatives )
            {
             before(grammarAccess.getDeclTypeAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:188:1: ( rule__DeclType__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:188:2: rule__DeclType__Alternatives
            {
            pushFollow(FOLLOW_rule__DeclType__Alternatives_in_ruleDeclType334);
            rule__DeclType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclType"


    // $ANTLR start "entryRuleDeclVal"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:200:1: entryRuleDeclVal : ruleDeclVal EOF ;
    public final void entryRuleDeclVal() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:201:1: ( ruleDeclVal EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:202:1: ruleDeclVal EOF
            {
             before(grammarAccess.getDeclValRule()); 
            pushFollow(FOLLOW_ruleDeclVal_in_entryRuleDeclVal361);
            ruleDeclVal();

            state._fsp--;

             after(grammarAccess.getDeclValRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclVal368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeclVal"


    // $ANTLR start "ruleDeclVal"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:209:1: ruleDeclVal : ( ( rule__DeclVal__Group__0 ) ) ;
    public final void ruleDeclVal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:213:2: ( ( ( rule__DeclVal__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:214:1: ( ( rule__DeclVal__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:214:1: ( ( rule__DeclVal__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:215:1: ( rule__DeclVal__Group__0 )
            {
             before(grammarAccess.getDeclValAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:216:1: ( rule__DeclVal__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:216:2: rule__DeclVal__Group__0
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__0_in_ruleDeclVal394);
            rule__DeclVal__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclVal"


    // $ANTLR start "entryRuleExport"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:228:1: entryRuleExport : ruleExport EOF ;
    public final void entryRuleExport() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:229:1: ( ruleExport EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:230:1: ruleExport EOF
            {
             before(grammarAccess.getExportRule()); 
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport421);
            ruleExport();

            state._fsp--;

             after(grammarAccess.getExportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExport"


    // $ANTLR start "ruleExport"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:237:1: ruleExport : ( ( rule__Export__Group__0 ) ) ;
    public final void ruleExport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:241:2: ( ( ( rule__Export__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:242:1: ( ( rule__Export__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:242:1: ( ( rule__Export__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:243:1: ( rule__Export__Group__0 )
            {
             before(grammarAccess.getExportAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:244:1: ( rule__Export__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:244:2: rule__Export__Group__0
            {
            pushFollow(FOLLOW_rule__Export__Group__0_in_ruleExport454);
            rule__Export__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExport"


    // $ANTLR start "entryRuleConDecls"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:256:1: entryRuleConDecls : ruleConDecls EOF ;
    public final void entryRuleConDecls() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:257:1: ( ruleConDecls EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:258:1: ruleConDecls EOF
            {
             before(grammarAccess.getConDeclsRule()); 
            pushFollow(FOLLOW_ruleConDecls_in_entryRuleConDecls481);
            ruleConDecls();

            state._fsp--;

             after(grammarAccess.getConDeclsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecls488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConDecls"


    // $ANTLR start "ruleConDecls"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:265:1: ruleConDecls : ( ( rule__ConDecls__Group__0 ) ) ;
    public final void ruleConDecls() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:269:2: ( ( ( rule__ConDecls__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:270:1: ( ( rule__ConDecls__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:270:1: ( ( rule__ConDecls__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:271:1: ( rule__ConDecls__Group__0 )
            {
             before(grammarAccess.getConDeclsAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:272:1: ( rule__ConDecls__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:272:2: rule__ConDecls__Group__0
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__0_in_ruleConDecls514);
            rule__ConDecls__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConDeclsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConDecls"


    // $ANTLR start "entryRuleConDecl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:284:1: entryRuleConDecl : ruleConDecl EOF ;
    public final void entryRuleConDecl() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:285:1: ( ruleConDecl EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:286:1: ruleConDecl EOF
            {
             before(grammarAccess.getConDeclRule()); 
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl541);
            ruleConDecl();

            state._fsp--;

             after(grammarAccess.getConDeclRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConDecl"


    // $ANTLR start "ruleConDecl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:293:1: ruleConDecl : ( ( rule__ConDecl__Group__0 ) ) ;
    public final void ruleConDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:297:2: ( ( ( rule__ConDecl__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:298:1: ( ( rule__ConDecl__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:298:1: ( ( rule__ConDecl__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:299:1: ( rule__ConDecl__Group__0 )
            {
             before(grammarAccess.getConDeclAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:300:1: ( rule__ConDecl__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:300:2: rule__ConDecl__Group__0
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__0_in_ruleConDecl574);
            rule__ConDecl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConDeclAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConDecl"


    // $ANTLR start "entryRuleTy"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:312:1: entryRuleTy : ruleTy EOF ;
    public final void entryRuleTy() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:313:1: ( ruleTy EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:314:1: ruleTy EOF
            {
             before(grammarAccess.getTyRule()); 
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy601);
            ruleTy();

            state._fsp--;

             after(grammarAccess.getTyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTy"


    // $ANTLR start "ruleTy"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:321:1: ruleTy : ( ( rule__Ty__Alternatives ) ) ;
    public final void ruleTy() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:325:2: ( ( ( rule__Ty__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:326:1: ( ( rule__Ty__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:326:1: ( ( rule__Ty__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:327:1: ( rule__Ty__Alternatives )
            {
             before(grammarAccess.getTyAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:328:1: ( rule__Ty__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:328:2: rule__Ty__Alternatives
            {
            pushFollow(FOLLOW_rule__Ty__Alternatives_in_ruleTy634);
            rule__Ty__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTy"


    // $ANTLR start "entryRuleTyElement"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:340:1: entryRuleTyElement : ruleTyElement EOF ;
    public final void entryRuleTyElement() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:341:1: ( ruleTyElement EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:342:1: ruleTyElement EOF
            {
             before(grammarAccess.getTyElementRule()); 
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement661);
            ruleTyElement();

            state._fsp--;

             after(grammarAccess.getTyElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement668); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTyElement"


    // $ANTLR start "ruleTyElement"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:349:1: ruleTyElement : ( ( rule__TyElement__Group__0 ) ) ;
    public final void ruleTyElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:353:2: ( ( ( rule__TyElement__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:354:1: ( ( rule__TyElement__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:354:1: ( ( rule__TyElement__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:355:1: ( rule__TyElement__Group__0 )
            {
             before(grammarAccess.getTyElementAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:356:1: ( rule__TyElement__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:356:2: rule__TyElement__Group__0
            {
            pushFollow(FOLLOW_rule__TyElement__Group__0_in_ruleTyElement694);
            rule__TyElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTyElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTyElement"


    // $ANTLR start "entryRuleTyBind"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:368:1: entryRuleTyBind : ruleTyBind EOF ;
    public final void entryRuleTyBind() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:369:1: ( ruleTyBind EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:370:1: ruleTyBind EOF
            {
             before(grammarAccess.getTyBindRule()); 
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind721);
            ruleTyBind();

            state._fsp--;

             after(grammarAccess.getTyBindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind728); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTyBind"


    // $ANTLR start "ruleTyBind"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:377:1: ruleTyBind : ( ( rule__TyBind__Group__0 ) ) ;
    public final void ruleTyBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:381:2: ( ( ( rule__TyBind__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:382:1: ( ( rule__TyBind__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:382:1: ( ( rule__TyBind__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:383:1: ( rule__TyBind__Group__0 )
            {
             before(grammarAccess.getTyBindAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:384:1: ( rule__TyBind__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:384:2: rule__TyBind__Group__0
            {
            pushFollow(FOLLOW_rule__TyBind__Group__0_in_ruleTyBind754);
            rule__TyBind__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTyBindAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTyBind"


    // $ANTLR start "entryRuleConBind"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:396:1: entryRuleConBind : ruleConBind EOF ;
    public final void entryRuleConBind() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:397:1: ( ruleConBind EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:398:1: ruleConBind EOF
            {
             before(grammarAccess.getConBindRule()); 
            pushFollow(FOLLOW_ruleConBind_in_entryRuleConBind781);
            ruleConBind();

            state._fsp--;

             after(grammarAccess.getConBindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConBind788); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConBind"


    // $ANTLR start "ruleConBind"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:405:1: ruleConBind : ( RULE_CONS ) ;
    public final void ruleConBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:409:2: ( ( RULE_CONS ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:410:1: ( RULE_CONS )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:410:1: ( RULE_CONS )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:411:1: RULE_CONS
            {
             before(grammarAccess.getConBindAccess().getCONSTerminalRuleCall()); 
            match(input,RULE_CONS,FOLLOW_RULE_CONS_in_ruleConBind814); 
             after(grammarAccess.getConBindAccess().getCONSTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConBind"


    // $ANTLR start "entryRuleInt"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:424:1: entryRuleInt : ruleInt EOF ;
    public final void entryRuleInt() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:425:1: ( ruleInt EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:426:1: ruleInt EOF
            {
             before(grammarAccess.getIntRule()); 
            pushFollow(FOLLOW_ruleInt_in_entryRuleInt840);
            ruleInt();

            state._fsp--;

             after(grammarAccess.getIntRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInt847); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInt"


    // $ANTLR start "ruleInt"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:433:1: ruleInt : ( ( rule__Int__Alternatives ) ) ;
    public final void ruleInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:437:2: ( ( ( rule__Int__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:438:1: ( ( rule__Int__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:438:1: ( ( rule__Int__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:439:1: ( rule__Int__Alternatives )
            {
             before(grammarAccess.getIntAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:440:1: ( rule__Int__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:440:2: rule__Int__Alternatives
            {
            pushFollow(FOLLOW_rule__Int__Alternatives_in_ruleInt873);
            rule__Int__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIntAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInt"


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:452:1: entryRuleQid : ruleQid EOF ;
    public final void entryRuleQid() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:453:1: ( ruleQid EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:454:1: ruleQid EOF
            {
             before(grammarAccess.getQidRule()); 
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid900);
            ruleQid();

            state._fsp--;

             after(grammarAccess.getQidRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid907); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQid"


    // $ANTLR start "ruleQid"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:461:1: ruleQid : ( RULE_ID ) ;
    public final void ruleQid() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:465:2: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:466:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:466:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:467:1: RULE_ID
            {
             before(grammarAccess.getQidAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQid933); 
             after(grammarAccess.getQidAccess().getIDTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQid"


    // $ANTLR start "rule__Decl__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:480:1: rule__Decl__Alternatives : ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) );
    public final void rule__Decl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:484:1: ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 24:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:485:1: ( ruleDeclGranularity )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:485:1: ( ruleDeclGranularity )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:486:1: ruleDeclGranularity
                    {
                     before(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives968);
                    ruleDeclGranularity();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:491:6: ( ruleDeclExport )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:491:6: ( ruleDeclExport )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:492:1: ruleDeclExport
                    {
                     before(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives985);
                    ruleDeclExport();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:497:6: ( ruleDeclType )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:497:6: ( ruleDeclType )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:498:1: ruleDeclType
                    {
                     before(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDeclType_in_rule__Decl__Alternatives1002);
                    ruleDeclType();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:503:6: ( ruleDeclVal )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:503:6: ( ruleDeclVal )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:504:1: ruleDeclVal
                    {
                     before(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives1019);
                    ruleDeclVal();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decl__Alternatives"


    // $ANTLR start "rule__DeclType__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:514:1: rule__DeclType__Alternatives : ( ( ( rule__DeclType__Group_0__0 ) ) | ( ( rule__DeclType__Group_1__0 ) ) );
    public final void rule__DeclType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:518:1: ( ( ( rule__DeclType__Group_0__0 ) ) | ( ( rule__DeclType__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_ID) ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2==12) ) {
                        alt2=1;
                    }
                    else if ( (LA2_2==14) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:519:1: ( ( rule__DeclType__Group_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:519:1: ( ( rule__DeclType__Group_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:520:1: ( rule__DeclType__Group_0__0 )
                    {
                     before(grammarAccess.getDeclTypeAccess().getGroup_0()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:521:1: ( rule__DeclType__Group_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:521:2: rule__DeclType__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Group_0__0_in_rule__DeclType__Alternatives1051);
                    rule__DeclType__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDeclTypeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:525:6: ( ( rule__DeclType__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:525:6: ( ( rule__DeclType__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:526:1: ( rule__DeclType__Group_1__0 )
                    {
                     before(grammarAccess.getDeclTypeAccess().getGroup_1()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:527:1: ( rule__DeclType__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:527:2: rule__DeclType__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Group_1__0_in_rule__DeclType__Alternatives1069);
                    rule__DeclType__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDeclTypeAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Alternatives"


    // $ANTLR start "rule__DeclType__ValueAlternatives_0_3_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:536:1: rule__DeclType__ValueAlternatives_0_3_0 : ( ( ruleConDecls ) | ( ruleTy ) );
    public final void rule__DeclType__ValueAlternatives_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:540:1: ( ( ruleConDecls ) | ( ruleTy ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_CONS) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_NEGINT)||LA3_0==18||LA3_0==20) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:541:1: ( ruleConDecls )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:541:1: ( ruleConDecls )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:542:1: ruleConDecls
                    {
                     before(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_0_3_0_0()); 
                    pushFollow(FOLLOW_ruleConDecls_in_rule__DeclType__ValueAlternatives_0_3_01102);
                    ruleConDecls();

                    state._fsp--;

                     after(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_0_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:547:6: ( ruleTy )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:547:6: ( ruleTy )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:548:1: ruleTy
                    {
                     before(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_0_3_0_1()); 
                    pushFollow(FOLLOW_ruleTy_in_rule__DeclType__ValueAlternatives_0_3_01119);
                    ruleTy();

                    state._fsp--;

                     after(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_0_3_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__ValueAlternatives_0_3_0"


    // $ANTLR start "rule__Ty__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:558:1: rule__Ty__Alternatives : ( ( ( rule__Ty__ValueAssignment_0 ) ) | ( ( rule__Ty__Group_1__0 ) ) | ( ( rule__Ty__Group_2__0 ) ) | ( ( rule__Ty__Group_3__0 ) ) );
    public final void rule__Ty__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:562:1: ( ( ( rule__Ty__ValueAssignment_0 ) ) | ( ( rule__Ty__Group_1__0 ) ) | ( ( rule__Ty__Group_2__0 ) ) | ( ( rule__Ty__Group_3__0 ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case RULE_POSINT:
            case RULE_NEGINT:
                {
                alt4=1;
                }
                break;
            case 20:
                {
                alt4=2;
                }
                break;
            case RULE_ID:
                {
                alt4=3;
                }
                break;
            case 18:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:563:1: ( ( rule__Ty__ValueAssignment_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:563:1: ( ( rule__Ty__ValueAssignment_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:564:1: ( rule__Ty__ValueAssignment_0 )
                    {
                     before(grammarAccess.getTyAccess().getValueAssignment_0()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:565:1: ( rule__Ty__ValueAssignment_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:565:2: rule__Ty__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Ty__ValueAssignment_0_in_rule__Ty__Alternatives1151);
                    rule__Ty__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTyAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:569:6: ( ( rule__Ty__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:569:6: ( ( rule__Ty__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:570:1: ( rule__Ty__Group_1__0 )
                    {
                     before(grammarAccess.getTyAccess().getGroup_1()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:571:1: ( rule__Ty__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:571:2: rule__Ty__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_1__0_in_rule__Ty__Alternatives1169);
                    rule__Ty__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTyAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:575:6: ( ( rule__Ty__Group_2__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:575:6: ( ( rule__Ty__Group_2__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:576:1: ( rule__Ty__Group_2__0 )
                    {
                     before(grammarAccess.getTyAccess().getGroup_2()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:577:1: ( rule__Ty__Group_2__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:577:2: rule__Ty__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_2__0_in_rule__Ty__Alternatives1187);
                    rule__Ty__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTyAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:581:6: ( ( rule__Ty__Group_3__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:581:6: ( ( rule__Ty__Group_3__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:582:1: ( rule__Ty__Group_3__0 )
                    {
                     before(grammarAccess.getTyAccess().getGroup_3()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:583:1: ( rule__Ty__Group_3__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:583:2: rule__Ty__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_3__0_in_rule__Ty__Alternatives1205);
                    rule__Ty__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTyAccess().getGroup_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Alternatives"


    // $ANTLR start "rule__Int__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:592:1: rule__Int__Alternatives : ( ( RULE_POSINT ) | ( RULE_NEGINT ) );
    public final void rule__Int__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:596:1: ( ( RULE_POSINT ) | ( RULE_NEGINT ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_POSINT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_NEGINT) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:597:1: ( RULE_POSINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:597:1: ( RULE_POSINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:598:1: RULE_POSINT
                    {
                     before(grammarAccess.getIntAccess().getPOSINTTerminalRuleCall_0()); 
                    match(input,RULE_POSINT,FOLLOW_RULE_POSINT_in_rule__Int__Alternatives1238); 
                     after(grammarAccess.getIntAccess().getPOSINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:603:6: ( RULE_NEGINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:603:6: ( RULE_NEGINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:604:1: RULE_NEGINT
                    {
                     before(grammarAccess.getIntAccess().getNEGINTTerminalRuleCall_1()); 
                    match(input,RULE_NEGINT,FOLLOW_RULE_NEGINT_in_rule__Int__Alternatives1255); 
                     after(grammarAccess.getIntAccess().getNEGINTTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:616:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:620:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:621:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01285);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01288);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:628:1: rule__Model__Group__0__Impl : ( ( rule__Model__DeclAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:632:1: ( ( ( rule__Model__DeclAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:633:1: ( ( rule__Model__DeclAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:633:1: ( ( rule__Model__DeclAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:634:1: ( rule__Model__DeclAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getDeclAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:635:1: ( rule__Model__DeclAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:635:2: rule__Model__DeclAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl1315);
            rule__Model__DeclAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDeclAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:645:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:649:1: ( rule__Model__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:650:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11345);
            rule__Model__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:656:1: rule__Model__Group__1__Impl : ( ( rule__Model__Group_1__0 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:660:1: ( ( ( rule__Model__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:661:1: ( ( rule__Model__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:661:1: ( ( rule__Model__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:662:1: ( rule__Model__Group_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:663:1: ( rule__Model__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==11||LA6_0==13||LA6_0==17||(LA6_0>=23 && LA6_0<=24)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:663:2: rule__Model__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl1372);
            	    rule__Model__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:677:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:681:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:682:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__01407);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01410);
            rule__Model__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__0"


    // $ANTLR start "rule__Model__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:689:1: rule__Model__Group_1__0__Impl : ( ( ';' )? ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:693:1: ( ( ( ';' )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:694:1: ( ( ';' )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:694:1: ( ( ';' )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:695:1: ( ';' )?
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_1_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:696:1: ( ';' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==11) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:697:2: ';'
                    {
                    match(input,11,FOLLOW_11_in_rule__Model__Group_1__0__Impl1439); 

                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getSemicolonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:708:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:712:1: ( rule__Model__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:713:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__11472);
            rule__Model__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__1"


    // $ANTLR start "rule__Model__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:719:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__DeclAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:723:1: ( ( ( rule__Model__DeclAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:724:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:724:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:725:1: ( rule__Model__DeclAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getDeclAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:726:1: ( rule__Model__DeclAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:726:2: rule__Model__DeclAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl1499);
            rule__Model__DeclAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDeclAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__DeclGranularity__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:740:1: rule__DeclGranularity__Group__0 : rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 ;
    public final void rule__DeclGranularity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:744:1: ( rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:745:2: rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__01533);
            rule__DeclGranularity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__01536);
            rule__DeclGranularity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclGranularity__Group__0"


    // $ANTLR start "rule__DeclGranularity__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:752:1: rule__DeclGranularity__Group__0__Impl : ( ( rule__DeclGranularity__NameAssignment_0 ) ) ;
    public final void rule__DeclGranularity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:756:1: ( ( ( rule__DeclGranularity__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:757:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:757:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:758:1: ( rule__DeclGranularity__NameAssignment_0 )
            {
             before(grammarAccess.getDeclGranularityAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:759:1: ( rule__DeclGranularity__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:759:2: rule__DeclGranularity__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl1563);
            rule__DeclGranularity__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDeclGranularityAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclGranularity__Group__0__Impl"


    // $ANTLR start "rule__DeclGranularity__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:769:1: rule__DeclGranularity__Group__1 : rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 ;
    public final void rule__DeclGranularity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:773:1: ( rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:774:2: rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__11593);
            rule__DeclGranularity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__11596);
            rule__DeclGranularity__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclGranularity__Group__1"


    // $ANTLR start "rule__DeclGranularity__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:781:1: rule__DeclGranularity__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclGranularity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:785:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:786:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:786:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:787:1: '='
            {
             before(grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__DeclGranularity__Group__1__Impl1624); 
             after(grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclGranularity__Group__1__Impl"


    // $ANTLR start "rule__DeclGranularity__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:800:1: rule__DeclGranularity__Group__2 : rule__DeclGranularity__Group__2__Impl ;
    public final void rule__DeclGranularity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:804:1: ( rule__DeclGranularity__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:805:2: rule__DeclGranularity__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__21655);
            rule__DeclGranularity__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclGranularity__Group__2"


    // $ANTLR start "rule__DeclGranularity__Group__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:811:1: rule__DeclGranularity__Group__2__Impl : ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) ;
    public final void rule__DeclGranularity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:815:1: ( ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:816:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:816:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:817:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            {
             before(grammarAccess.getDeclGranularityAccess().getGranularityAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:818:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:818:2: rule__DeclGranularity__GranularityAssignment_2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl1682);
            rule__DeclGranularity__GranularityAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDeclGranularityAccess().getGranularityAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclGranularity__Group__2__Impl"


    // $ANTLR start "rule__DeclExport__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:834:1: rule__DeclExport__Group__0 : rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 ;
    public final void rule__DeclExport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:838:1: ( rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:839:2: rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__01718);
            rule__DeclExport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__01721);
            rule__DeclExport__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclExport__Group__0"


    // $ANTLR start "rule__DeclExport__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:846:1: rule__DeclExport__Group__0__Impl : ( ( rule__DeclExport__NameAssignment_0 ) ) ;
    public final void rule__DeclExport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:850:1: ( ( ( rule__DeclExport__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:851:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:851:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:852:1: ( rule__DeclExport__NameAssignment_0 )
            {
             before(grammarAccess.getDeclExportAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:853:1: ( rule__DeclExport__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:853:2: rule__DeclExport__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl1748);
            rule__DeclExport__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDeclExportAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclExport__Group__0__Impl"


    // $ANTLR start "rule__DeclExport__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:863:1: rule__DeclExport__Group__1 : rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 ;
    public final void rule__DeclExport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:867:1: ( rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:868:2: rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__11778);
            rule__DeclExport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__11781);
            rule__DeclExport__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclExport__Group__1"


    // $ANTLR start "rule__DeclExport__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:875:1: rule__DeclExport__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclExport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:879:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:880:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:880:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:881:1: '='
            {
             before(grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__DeclExport__Group__1__Impl1809); 
             after(grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclExport__Group__1__Impl"


    // $ANTLR start "rule__DeclExport__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:894:1: rule__DeclExport__Group__2 : rule__DeclExport__Group__2__Impl ;
    public final void rule__DeclExport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:898:1: ( rule__DeclExport__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:899:2: rule__DeclExport__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__21840);
            rule__DeclExport__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclExport__Group__2"


    // $ANTLR start "rule__DeclExport__Group__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:905:1: rule__DeclExport__Group__2__Impl : ( ( rule__DeclExport__ExportsAssignment_2 )* ) ;
    public final void rule__DeclExport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:909:1: ( ( ( rule__DeclExport__ExportsAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:910:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:910:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:911:1: ( rule__DeclExport__ExportsAssignment_2 )*
            {
             before(grammarAccess.getDeclExportAccess().getExportsAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:912:1: ( rule__DeclExport__ExportsAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:912:2: rule__DeclExport__ExportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl1867);
            	    rule__DeclExport__ExportsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getDeclExportAccess().getExportsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclExport__Group__2__Impl"


    // $ANTLR start "rule__DeclType__Group_0__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:928:1: rule__DeclType__Group_0__0 : rule__DeclType__Group_0__0__Impl rule__DeclType__Group_0__1 ;
    public final void rule__DeclType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:932:1: ( rule__DeclType__Group_0__0__Impl rule__DeclType__Group_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:933:2: rule__DeclType__Group_0__0__Impl rule__DeclType__Group_0__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_0__0__Impl_in_rule__DeclType__Group_0__01904);
            rule__DeclType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_0__1_in_rule__DeclType__Group_0__01907);
            rule__DeclType__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_0__0"


    // $ANTLR start "rule__DeclType__Group_0__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:940:1: rule__DeclType__Group_0__0__Impl : ( 'type' ) ;
    public final void rule__DeclType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:944:1: ( ( 'type' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:945:1: ( 'type' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:945:1: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:946:1: 'type'
            {
             before(grammarAccess.getDeclTypeAccess().getTypeKeyword_0_0()); 
            match(input,13,FOLLOW_13_in_rule__DeclType__Group_0__0__Impl1935); 
             after(grammarAccess.getDeclTypeAccess().getTypeKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_0__0__Impl"


    // $ANTLR start "rule__DeclType__Group_0__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:959:1: rule__DeclType__Group_0__1 : rule__DeclType__Group_0__1__Impl rule__DeclType__Group_0__2 ;
    public final void rule__DeclType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:963:1: ( rule__DeclType__Group_0__1__Impl rule__DeclType__Group_0__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:964:2: rule__DeclType__Group_0__1__Impl rule__DeclType__Group_0__2
            {
            pushFollow(FOLLOW_rule__DeclType__Group_0__1__Impl_in_rule__DeclType__Group_0__11966);
            rule__DeclType__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_0__2_in_rule__DeclType__Group_0__11969);
            rule__DeclType__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_0__1"


    // $ANTLR start "rule__DeclType__Group_0__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:971:1: rule__DeclType__Group_0__1__Impl : ( ( rule__DeclType__NameAssignment_0_1 ) ) ;
    public final void rule__DeclType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:975:1: ( ( ( rule__DeclType__NameAssignment_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:976:1: ( ( rule__DeclType__NameAssignment_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:976:1: ( ( rule__DeclType__NameAssignment_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:977:1: ( rule__DeclType__NameAssignment_0_1 )
            {
             before(grammarAccess.getDeclTypeAccess().getNameAssignment_0_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:978:1: ( rule__DeclType__NameAssignment_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:978:2: rule__DeclType__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__DeclType__NameAssignment_0_1_in_rule__DeclType__Group_0__1__Impl1996);
            rule__DeclType__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_0__1__Impl"


    // $ANTLR start "rule__DeclType__Group_0__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:988:1: rule__DeclType__Group_0__2 : rule__DeclType__Group_0__2__Impl rule__DeclType__Group_0__3 ;
    public final void rule__DeclType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:992:1: ( rule__DeclType__Group_0__2__Impl rule__DeclType__Group_0__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:993:2: rule__DeclType__Group_0__2__Impl rule__DeclType__Group_0__3
            {
            pushFollow(FOLLOW_rule__DeclType__Group_0__2__Impl_in_rule__DeclType__Group_0__22026);
            rule__DeclType__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_0__3_in_rule__DeclType__Group_0__22029);
            rule__DeclType__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_0__2"


    // $ANTLR start "rule__DeclType__Group_0__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1000:1: rule__DeclType__Group_0__2__Impl : ( '=' ) ;
    public final void rule__DeclType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1004:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1005:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1005:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1006:1: '='
            {
             before(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_0_2()); 
            match(input,12,FOLLOW_12_in_rule__DeclType__Group_0__2__Impl2057); 
             after(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_0__2__Impl"


    // $ANTLR start "rule__DeclType__Group_0__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1019:1: rule__DeclType__Group_0__3 : rule__DeclType__Group_0__3__Impl ;
    public final void rule__DeclType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1023:1: ( rule__DeclType__Group_0__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1024:2: rule__DeclType__Group_0__3__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_0__3__Impl_in_rule__DeclType__Group_0__32088);
            rule__DeclType__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_0__3"


    // $ANTLR start "rule__DeclType__Group_0__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1030:1: rule__DeclType__Group_0__3__Impl : ( ( rule__DeclType__ValueAssignment_0_3 ) ) ;
    public final void rule__DeclType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1034:1: ( ( ( rule__DeclType__ValueAssignment_0_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1035:1: ( ( rule__DeclType__ValueAssignment_0_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1035:1: ( ( rule__DeclType__ValueAssignment_0_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1036:1: ( rule__DeclType__ValueAssignment_0_3 )
            {
             before(grammarAccess.getDeclTypeAccess().getValueAssignment_0_3()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1037:1: ( rule__DeclType__ValueAssignment_0_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1037:2: rule__DeclType__ValueAssignment_0_3
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAssignment_0_3_in_rule__DeclType__Group_0__3__Impl2115);
            rule__DeclType__ValueAssignment_0_3();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getValueAssignment_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_0__3__Impl"


    // $ANTLR start "rule__DeclType__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1055:1: rule__DeclType__Group_1__0 : rule__DeclType__Group_1__0__Impl rule__DeclType__Group_1__1 ;
    public final void rule__DeclType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1059:1: ( rule__DeclType__Group_1__0__Impl rule__DeclType__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1060:2: rule__DeclType__Group_1__0__Impl rule__DeclType__Group_1__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__0__Impl_in_rule__DeclType__Group_1__02153);
            rule__DeclType__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__1_in_rule__DeclType__Group_1__02156);
            rule__DeclType__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__0"


    // $ANTLR start "rule__DeclType__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1067:1: rule__DeclType__Group_1__0__Impl : ( 'type' ) ;
    public final void rule__DeclType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1071:1: ( ( 'type' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1072:1: ( 'type' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1072:1: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1073:1: 'type'
            {
             before(grammarAccess.getDeclTypeAccess().getTypeKeyword_1_0()); 
            match(input,13,FOLLOW_13_in_rule__DeclType__Group_1__0__Impl2184); 
             after(grammarAccess.getDeclTypeAccess().getTypeKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__0__Impl"


    // $ANTLR start "rule__DeclType__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1086:1: rule__DeclType__Group_1__1 : rule__DeclType__Group_1__1__Impl rule__DeclType__Group_1__2 ;
    public final void rule__DeclType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1090:1: ( rule__DeclType__Group_1__1__Impl rule__DeclType__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1091:2: rule__DeclType__Group_1__1__Impl rule__DeclType__Group_1__2
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__1__Impl_in_rule__DeclType__Group_1__12215);
            rule__DeclType__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__2_in_rule__DeclType__Group_1__12218);
            rule__DeclType__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__1"


    // $ANTLR start "rule__DeclType__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1098:1: rule__DeclType__Group_1__1__Impl : ( ( rule__DeclType__NameAssignment_1_1 ) ) ;
    public final void rule__DeclType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1102:1: ( ( ( rule__DeclType__NameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1103:1: ( ( rule__DeclType__NameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1103:1: ( ( rule__DeclType__NameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1104:1: ( rule__DeclType__NameAssignment_1_1 )
            {
             before(grammarAccess.getDeclTypeAccess().getNameAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1105:1: ( rule__DeclType__NameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1105:2: rule__DeclType__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__DeclType__NameAssignment_1_1_in_rule__DeclType__Group_1__1__Impl2245);
            rule__DeclType__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__1__Impl"


    // $ANTLR start "rule__DeclType__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1115:1: rule__DeclType__Group_1__2 : rule__DeclType__Group_1__2__Impl rule__DeclType__Group_1__3 ;
    public final void rule__DeclType__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1119:1: ( rule__DeclType__Group_1__2__Impl rule__DeclType__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1120:2: rule__DeclType__Group_1__2__Impl rule__DeclType__Group_1__3
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__2__Impl_in_rule__DeclType__Group_1__22275);
            rule__DeclType__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__3_in_rule__DeclType__Group_1__22278);
            rule__DeclType__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__2"


    // $ANTLR start "rule__DeclType__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1127:1: rule__DeclType__Group_1__2__Impl : ( '[' ) ;
    public final void rule__DeclType__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1131:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1132:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1132:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1133:1: '['
            {
             before(grammarAccess.getDeclTypeAccess().getLeftSquareBracketKeyword_1_2()); 
            match(input,14,FOLLOW_14_in_rule__DeclType__Group_1__2__Impl2306); 
             after(grammarAccess.getDeclTypeAccess().getLeftSquareBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__2__Impl"


    // $ANTLR start "rule__DeclType__Group_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1146:1: rule__DeclType__Group_1__3 : rule__DeclType__Group_1__3__Impl rule__DeclType__Group_1__4 ;
    public final void rule__DeclType__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1150:1: ( rule__DeclType__Group_1__3__Impl rule__DeclType__Group_1__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1151:2: rule__DeclType__Group_1__3__Impl rule__DeclType__Group_1__4
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__3__Impl_in_rule__DeclType__Group_1__32337);
            rule__DeclType__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__4_in_rule__DeclType__Group_1__32340);
            rule__DeclType__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__3"


    // $ANTLR start "rule__DeclType__Group_1__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1158:1: rule__DeclType__Group_1__3__Impl : ( ( rule__DeclType__AttrNameAssignment_1_3 ) ) ;
    public final void rule__DeclType__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1162:1: ( ( ( rule__DeclType__AttrNameAssignment_1_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1163:1: ( ( rule__DeclType__AttrNameAssignment_1_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1163:1: ( ( rule__DeclType__AttrNameAssignment_1_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1164:1: ( rule__DeclType__AttrNameAssignment_1_3 )
            {
             before(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_1_3()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1165:1: ( rule__DeclType__AttrNameAssignment_1_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1165:2: rule__DeclType__AttrNameAssignment_1_3
            {
            pushFollow(FOLLOW_rule__DeclType__AttrNameAssignment_1_3_in_rule__DeclType__Group_1__3__Impl2367);
            rule__DeclType__AttrNameAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__3__Impl"


    // $ANTLR start "rule__DeclType__Group_1__4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1175:1: rule__DeclType__Group_1__4 : rule__DeclType__Group_1__4__Impl rule__DeclType__Group_1__5 ;
    public final void rule__DeclType__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1179:1: ( rule__DeclType__Group_1__4__Impl rule__DeclType__Group_1__5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1180:2: rule__DeclType__Group_1__4__Impl rule__DeclType__Group_1__5
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__4__Impl_in_rule__DeclType__Group_1__42397);
            rule__DeclType__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__5_in_rule__DeclType__Group_1__42400);
            rule__DeclType__Group_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__4"


    // $ANTLR start "rule__DeclType__Group_1__4__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1187:1: rule__DeclType__Group_1__4__Impl : ( ( rule__DeclType__Group_1_4__0 )* ) ;
    public final void rule__DeclType__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1191:1: ( ( ( rule__DeclType__Group_1_4__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1192:1: ( ( rule__DeclType__Group_1_4__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1192:1: ( ( rule__DeclType__Group_1_4__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1193:1: ( rule__DeclType__Group_1_4__0 )*
            {
             before(grammarAccess.getDeclTypeAccess().getGroup_1_4()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1194:1: ( rule__DeclType__Group_1_4__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1194:2: rule__DeclType__Group_1_4__0
            	    {
            	    pushFollow(FOLLOW_rule__DeclType__Group_1_4__0_in_rule__DeclType__Group_1__4__Impl2427);
            	    rule__DeclType__Group_1_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getDeclTypeAccess().getGroup_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__4__Impl"


    // $ANTLR start "rule__DeclType__Group_1__5"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1204:1: rule__DeclType__Group_1__5 : rule__DeclType__Group_1__5__Impl rule__DeclType__Group_1__6 ;
    public final void rule__DeclType__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1208:1: ( rule__DeclType__Group_1__5__Impl rule__DeclType__Group_1__6 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1209:2: rule__DeclType__Group_1__5__Impl rule__DeclType__Group_1__6
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__5__Impl_in_rule__DeclType__Group_1__52458);
            rule__DeclType__Group_1__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__6_in_rule__DeclType__Group_1__52461);
            rule__DeclType__Group_1__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__5"


    // $ANTLR start "rule__DeclType__Group_1__5__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1216:1: rule__DeclType__Group_1__5__Impl : ( ']' ) ;
    public final void rule__DeclType__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1220:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1221:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1221:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1222:1: ']'
            {
             before(grammarAccess.getDeclTypeAccess().getRightSquareBracketKeyword_1_5()); 
            match(input,15,FOLLOW_15_in_rule__DeclType__Group_1__5__Impl2489); 
             after(grammarAccess.getDeclTypeAccess().getRightSquareBracketKeyword_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__5__Impl"


    // $ANTLR start "rule__DeclType__Group_1__6"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1235:1: rule__DeclType__Group_1__6 : rule__DeclType__Group_1__6__Impl rule__DeclType__Group_1__7 ;
    public final void rule__DeclType__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1239:1: ( rule__DeclType__Group_1__6__Impl rule__DeclType__Group_1__7 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1240:2: rule__DeclType__Group_1__6__Impl rule__DeclType__Group_1__7
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__6__Impl_in_rule__DeclType__Group_1__62520);
            rule__DeclType__Group_1__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__7_in_rule__DeclType__Group_1__62523);
            rule__DeclType__Group_1__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__6"


    // $ANTLR start "rule__DeclType__Group_1__6__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1247:1: rule__DeclType__Group_1__6__Impl : ( '=' ) ;
    public final void rule__DeclType__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1251:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1252:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1252:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1253:1: '='
            {
             before(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_1_6()); 
            match(input,12,FOLLOW_12_in_rule__DeclType__Group_1__6__Impl2551); 
             after(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_1_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__6__Impl"


    // $ANTLR start "rule__DeclType__Group_1__7"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1266:1: rule__DeclType__Group_1__7 : rule__DeclType__Group_1__7__Impl ;
    public final void rule__DeclType__Group_1__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1270:1: ( rule__DeclType__Group_1__7__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1271:2: rule__DeclType__Group_1__7__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__7__Impl_in_rule__DeclType__Group_1__72582);
            rule__DeclType__Group_1__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__7"


    // $ANTLR start "rule__DeclType__Group_1__7__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1277:1: rule__DeclType__Group_1__7__Impl : ( ( rule__DeclType__ValueAssignment_1_7 ) ) ;
    public final void rule__DeclType__Group_1__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1281:1: ( ( ( rule__DeclType__ValueAssignment_1_7 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1282:1: ( ( rule__DeclType__ValueAssignment_1_7 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1282:1: ( ( rule__DeclType__ValueAssignment_1_7 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1283:1: ( rule__DeclType__ValueAssignment_1_7 )
            {
             before(grammarAccess.getDeclTypeAccess().getValueAssignment_1_7()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1284:1: ( rule__DeclType__ValueAssignment_1_7 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1284:2: rule__DeclType__ValueAssignment_1_7
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAssignment_1_7_in_rule__DeclType__Group_1__7__Impl2609);
            rule__DeclType__ValueAssignment_1_7();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getValueAssignment_1_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1__7__Impl"


    // $ANTLR start "rule__DeclType__Group_1_4__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1310:1: rule__DeclType__Group_1_4__0 : rule__DeclType__Group_1_4__0__Impl rule__DeclType__Group_1_4__1 ;
    public final void rule__DeclType__Group_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1314:1: ( rule__DeclType__Group_1_4__0__Impl rule__DeclType__Group_1_4__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1315:2: rule__DeclType__Group_1_4__0__Impl rule__DeclType__Group_1_4__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1_4__0__Impl_in_rule__DeclType__Group_1_4__02655);
            rule__DeclType__Group_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1_4__1_in_rule__DeclType__Group_1_4__02658);
            rule__DeclType__Group_1_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1_4__0"


    // $ANTLR start "rule__DeclType__Group_1_4__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1322:1: rule__DeclType__Group_1_4__0__Impl : ( ',' ) ;
    public final void rule__DeclType__Group_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1326:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1327:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1327:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1328:1: ','
            {
             before(grammarAccess.getDeclTypeAccess().getCommaKeyword_1_4_0()); 
            match(input,16,FOLLOW_16_in_rule__DeclType__Group_1_4__0__Impl2686); 
             after(grammarAccess.getDeclTypeAccess().getCommaKeyword_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1_4__0__Impl"


    // $ANTLR start "rule__DeclType__Group_1_4__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1341:1: rule__DeclType__Group_1_4__1 : rule__DeclType__Group_1_4__1__Impl ;
    public final void rule__DeclType__Group_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1345:1: ( rule__DeclType__Group_1_4__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1346:2: rule__DeclType__Group_1_4__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1_4__1__Impl_in_rule__DeclType__Group_1_4__12717);
            rule__DeclType__Group_1_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1_4__1"


    // $ANTLR start "rule__DeclType__Group_1_4__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1352:1: rule__DeclType__Group_1_4__1__Impl : ( ( rule__DeclType__AttrNameAssignment_1_4_1 ) ) ;
    public final void rule__DeclType__Group_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1356:1: ( ( ( rule__DeclType__AttrNameAssignment_1_4_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1357:1: ( ( rule__DeclType__AttrNameAssignment_1_4_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1357:1: ( ( rule__DeclType__AttrNameAssignment_1_4_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1358:1: ( rule__DeclType__AttrNameAssignment_1_4_1 )
            {
             before(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_1_4_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1359:1: ( rule__DeclType__AttrNameAssignment_1_4_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1359:2: rule__DeclType__AttrNameAssignment_1_4_1
            {
            pushFollow(FOLLOW_rule__DeclType__AttrNameAssignment_1_4_1_in_rule__DeclType__Group_1_4__1__Impl2744);
            rule__DeclType__AttrNameAssignment_1_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_1_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_1_4__1__Impl"


    // $ANTLR start "rule__DeclVal__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1373:1: rule__DeclVal__Group__0 : rule__DeclVal__Group__0__Impl rule__DeclVal__Group__1 ;
    public final void rule__DeclVal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1377:1: ( rule__DeclVal__Group__0__Impl rule__DeclVal__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1378:2: rule__DeclVal__Group__0__Impl rule__DeclVal__Group__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__0__Impl_in_rule__DeclVal__Group__02778);
            rule__DeclVal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group__1_in_rule__DeclVal__Group__02781);
            rule__DeclVal__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__Group__0"


    // $ANTLR start "rule__DeclVal__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1385:1: rule__DeclVal__Group__0__Impl : ( 'val' ) ;
    public final void rule__DeclVal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1389:1: ( ( 'val' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1390:1: ( 'val' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1390:1: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1391:1: 'val'
            {
             before(grammarAccess.getDeclValAccess().getValKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__DeclVal__Group__0__Impl2809); 
             after(grammarAccess.getDeclValAccess().getValKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__Group__0__Impl"


    // $ANTLR start "rule__DeclVal__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1404:1: rule__DeclVal__Group__1 : rule__DeclVal__Group__1__Impl rule__DeclVal__Group__2 ;
    public final void rule__DeclVal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1408:1: ( rule__DeclVal__Group__1__Impl rule__DeclVal__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1409:2: rule__DeclVal__Group__1__Impl rule__DeclVal__Group__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__1__Impl_in_rule__DeclVal__Group__12840);
            rule__DeclVal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group__2_in_rule__DeclVal__Group__12843);
            rule__DeclVal__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__Group__1"


    // $ANTLR start "rule__DeclVal__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1416:1: rule__DeclVal__Group__1__Impl : ( ( rule__DeclVal__NameAssignment_1 ) ) ;
    public final void rule__DeclVal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1420:1: ( ( ( rule__DeclVal__NameAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1421:1: ( ( rule__DeclVal__NameAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1421:1: ( ( rule__DeclVal__NameAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1422:1: ( rule__DeclVal__NameAssignment_1 )
            {
             before(grammarAccess.getDeclValAccess().getNameAssignment_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1423:1: ( rule__DeclVal__NameAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1423:2: rule__DeclVal__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__DeclVal__NameAssignment_1_in_rule__DeclVal__Group__1__Impl2870);
            rule__DeclVal__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__Group__1__Impl"


    // $ANTLR start "rule__DeclVal__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1433:1: rule__DeclVal__Group__2 : rule__DeclVal__Group__2__Impl ;
    public final void rule__DeclVal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1437:1: ( rule__DeclVal__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1438:2: rule__DeclVal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__2__Impl_in_rule__DeclVal__Group__22900);
            rule__DeclVal__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__Group__2"


    // $ANTLR start "rule__DeclVal__Group__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1444:1: rule__DeclVal__Group__2__Impl : ( ( rule__DeclVal__AttrAssignment_2 )* ) ;
    public final void rule__DeclVal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1448:1: ( ( ( rule__DeclVal__AttrAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1449:1: ( ( rule__DeclVal__AttrAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1449:1: ( ( rule__DeclVal__AttrAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1450:1: ( rule__DeclVal__AttrAssignment_2 )*
            {
             before(grammarAccess.getDeclValAccess().getAttrAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1451:1: ( rule__DeclVal__AttrAssignment_2 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1451:2: rule__DeclVal__AttrAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclVal__AttrAssignment_2_in_rule__DeclVal__Group__2__Impl2927);
            	    rule__DeclVal__AttrAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getDeclValAccess().getAttrAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__Group__2__Impl"


    // $ANTLR start "rule__Export__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1467:1: rule__Export__Group__0 : rule__Export__Group__0__Impl rule__Export__Group__1 ;
    public final void rule__Export__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1471:1: ( rule__Export__Group__0__Impl rule__Export__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1472:2: rule__Export__Group__0__Impl rule__Export__Group__1
            {
            pushFollow(FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__02964);
            rule__Export__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group__1_in_rule__Export__Group__02967);
            rule__Export__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group__0"


    // $ANTLR start "rule__Export__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1479:1: rule__Export__Group__0__Impl : ( ( rule__Export__NameAssignment_0 ) ) ;
    public final void rule__Export__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1483:1: ( ( ( rule__Export__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1484:1: ( ( rule__Export__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1484:1: ( ( rule__Export__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1485:1: ( rule__Export__NameAssignment_0 )
            {
             before(grammarAccess.getExportAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1486:1: ( rule__Export__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1486:2: rule__Export__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl2994);
            rule__Export__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getExportAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group__0__Impl"


    // $ANTLR start "rule__Export__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1496:1: rule__Export__Group__1 : rule__Export__Group__1__Impl ;
    public final void rule__Export__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1500:1: ( rule__Export__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1501:2: rule__Export__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__13024);
            rule__Export__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group__1"


    // $ANTLR start "rule__Export__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1507:1: rule__Export__Group__1__Impl : ( ( rule__Export__Group_1__0 )? ) ;
    public final void rule__Export__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1511:1: ( ( ( rule__Export__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1512:1: ( ( rule__Export__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1512:1: ( ( rule__Export__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1513:1: ( rule__Export__Group_1__0 )?
            {
             before(grammarAccess.getExportAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1514:1: ( rule__Export__Group_1__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1514:2: rule__Export__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl3051);
                    rule__Export__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExportAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group__1__Impl"


    // $ANTLR start "rule__Export__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1528:1: rule__Export__Group_1__0 : rule__Export__Group_1__0__Impl rule__Export__Group_1__1 ;
    public final void rule__Export__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1532:1: ( rule__Export__Group_1__0__Impl rule__Export__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1533:2: rule__Export__Group_1__0__Impl rule__Export__Group_1__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__03086);
            rule__Export__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__03089);
            rule__Export__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1__0"


    // $ANTLR start "rule__Export__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1540:1: rule__Export__Group_1__0__Impl : ( '{' ) ;
    public final void rule__Export__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1544:1: ( ( '{' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1545:1: ( '{' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1545:1: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1546:1: '{'
            {
             before(grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,18,FOLLOW_18_in_rule__Export__Group_1__0__Impl3117); 
             after(grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1__0__Impl"


    // $ANTLR start "rule__Export__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1559:1: rule__Export__Group_1__1 : rule__Export__Group_1__1__Impl rule__Export__Group_1__2 ;
    public final void rule__Export__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1563:1: ( rule__Export__Group_1__1__Impl rule__Export__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1564:2: rule__Export__Group_1__1__Impl rule__Export__Group_1__2
            {
            pushFollow(FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__13148);
            rule__Export__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__13151);
            rule__Export__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1__1"


    // $ANTLR start "rule__Export__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1571:1: rule__Export__Group_1__1__Impl : ( ( rule__Export__AttrNameAssignment_1_1 ) ) ;
    public final void rule__Export__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1575:1: ( ( ( rule__Export__AttrNameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1576:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1576:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1577:1: ( rule__Export__AttrNameAssignment_1_1 )
            {
             before(grammarAccess.getExportAccess().getAttrNameAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1578:1: ( rule__Export__AttrNameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1578:2: rule__Export__AttrNameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl3178);
            rule__Export__AttrNameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExportAccess().getAttrNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1__1__Impl"


    // $ANTLR start "rule__Export__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1588:1: rule__Export__Group_1__2 : rule__Export__Group_1__2__Impl rule__Export__Group_1__3 ;
    public final void rule__Export__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1592:1: ( rule__Export__Group_1__2__Impl rule__Export__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1593:2: rule__Export__Group_1__2__Impl rule__Export__Group_1__3
            {
            pushFollow(FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__23208);
            rule__Export__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__23211);
            rule__Export__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1__2"


    // $ANTLR start "rule__Export__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1600:1: rule__Export__Group_1__2__Impl : ( ( rule__Export__Group_1_2__0 )* ) ;
    public final void rule__Export__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1604:1: ( ( ( rule__Export__Group_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1605:1: ( ( rule__Export__Group_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1605:1: ( ( rule__Export__Group_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1606:1: ( rule__Export__Group_1_2__0 )*
            {
             before(grammarAccess.getExportAccess().getGroup_1_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1607:1: ( rule__Export__Group_1_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==16) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1607:2: rule__Export__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl3238);
            	    rule__Export__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getExportAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1__2__Impl"


    // $ANTLR start "rule__Export__Group_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1617:1: rule__Export__Group_1__3 : rule__Export__Group_1__3__Impl ;
    public final void rule__Export__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1621:1: ( rule__Export__Group_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1622:2: rule__Export__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__33269);
            rule__Export__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1__3"


    // $ANTLR start "rule__Export__Group_1__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1628:1: rule__Export__Group_1__3__Impl : ( '}' ) ;
    public final void rule__Export__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1632:1: ( ( '}' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1633:1: ( '}' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1633:1: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1634:1: '}'
            {
             before(grammarAccess.getExportAccess().getRightCurlyBracketKeyword_1_3()); 
            match(input,19,FOLLOW_19_in_rule__Export__Group_1__3__Impl3297); 
             after(grammarAccess.getExportAccess().getRightCurlyBracketKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1__3__Impl"


    // $ANTLR start "rule__Export__Group_1_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1655:1: rule__Export__Group_1_2__0 : rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 ;
    public final void rule__Export__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1659:1: ( rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1660:2: rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__03336);
            rule__Export__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__03339);
            rule__Export__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1_2__0"


    // $ANTLR start "rule__Export__Group_1_2__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1667:1: rule__Export__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__Export__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1671:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1672:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1672:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1673:1: ','
            {
             before(grammarAccess.getExportAccess().getCommaKeyword_1_2_0()); 
            match(input,16,FOLLOW_16_in_rule__Export__Group_1_2__0__Impl3367); 
             after(grammarAccess.getExportAccess().getCommaKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1_2__0__Impl"


    // $ANTLR start "rule__Export__Group_1_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1686:1: rule__Export__Group_1_2__1 : rule__Export__Group_1_2__1__Impl ;
    public final void rule__Export__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1690:1: ( rule__Export__Group_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1691:2: rule__Export__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__13398);
            rule__Export__Group_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1_2__1"


    // $ANTLR start "rule__Export__Group_1_2__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1697:1: rule__Export__Group_1_2__1__Impl : ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) ;
    public final void rule__Export__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1701:1: ( ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1702:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1702:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1703:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            {
             before(grammarAccess.getExportAccess().getAttrNameAssignment_1_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1704:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1704:2: rule__Export__AttrNameAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl3425);
            rule__Export__AttrNameAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getExportAccess().getAttrNameAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__Group_1_2__1__Impl"


    // $ANTLR start "rule__ConDecls__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1718:1: rule__ConDecls__Group__0 : rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1 ;
    public final void rule__ConDecls__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1722:1: ( rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1723:2: rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__0__Impl_in_rule__ConDecls__Group__03459);
            rule__ConDecls__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConDecls__Group__1_in_rule__ConDecls__Group__03462);
            rule__ConDecls__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__Group__0"


    // $ANTLR start "rule__ConDecls__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1730:1: rule__ConDecls__Group__0__Impl : ( ( rule__ConDecls__ConDeclsAssignment_0 ) ) ;
    public final void rule__ConDecls__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1734:1: ( ( ( rule__ConDecls__ConDeclsAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1735:1: ( ( rule__ConDecls__ConDeclsAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1735:1: ( ( rule__ConDecls__ConDeclsAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1736:1: ( rule__ConDecls__ConDeclsAssignment_0 )
            {
             before(grammarAccess.getConDeclsAccess().getConDeclsAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1737:1: ( rule__ConDecls__ConDeclsAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1737:2: rule__ConDecls__ConDeclsAssignment_0
            {
            pushFollow(FOLLOW_rule__ConDecls__ConDeclsAssignment_0_in_rule__ConDecls__Group__0__Impl3489);
            rule__ConDecls__ConDeclsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConDeclsAccess().getConDeclsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__Group__0__Impl"


    // $ANTLR start "rule__ConDecls__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1747:1: rule__ConDecls__Group__1 : rule__ConDecls__Group__1__Impl ;
    public final void rule__ConDecls__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1751:1: ( rule__ConDecls__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1752:2: rule__ConDecls__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__1__Impl_in_rule__ConDecls__Group__13519);
            rule__ConDecls__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__Group__1"


    // $ANTLR start "rule__ConDecls__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1758:1: rule__ConDecls__Group__1__Impl : ( ( rule__ConDecls__Group_1__0 )* ) ;
    public final void rule__ConDecls__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1762:1: ( ( ( rule__ConDecls__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1763:1: ( ( rule__ConDecls__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1763:1: ( ( rule__ConDecls__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1764:1: ( rule__ConDecls__Group_1__0 )*
            {
             before(grammarAccess.getConDeclsAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1765:1: ( rule__ConDecls__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1765:2: rule__ConDecls__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConDecls__Group_1__0_in_rule__ConDecls__Group__1__Impl3546);
            	    rule__ConDecls__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getConDeclsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__Group__1__Impl"


    // $ANTLR start "rule__ConDecls__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1779:1: rule__ConDecls__Group_1__0 : rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1 ;
    public final void rule__ConDecls__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1783:1: ( rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1784:2: rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConDecls__Group_1__0__Impl_in_rule__ConDecls__Group_1__03581);
            rule__ConDecls__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConDecls__Group_1__1_in_rule__ConDecls__Group_1__03584);
            rule__ConDecls__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__Group_1__0"


    // $ANTLR start "rule__ConDecls__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1791:1: rule__ConDecls__Group_1__0__Impl : ( '|' ) ;
    public final void rule__ConDecls__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1795:1: ( ( '|' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1796:1: ( '|' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1796:1: ( '|' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1797:1: '|'
            {
             before(grammarAccess.getConDeclsAccess().getVerticalLineKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__ConDecls__Group_1__0__Impl3612); 
             after(grammarAccess.getConDeclsAccess().getVerticalLineKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__Group_1__0__Impl"


    // $ANTLR start "rule__ConDecls__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1810:1: rule__ConDecls__Group_1__1 : rule__ConDecls__Group_1__1__Impl ;
    public final void rule__ConDecls__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1814:1: ( rule__ConDecls__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1815:2: rule__ConDecls__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecls__Group_1__1__Impl_in_rule__ConDecls__Group_1__13643);
            rule__ConDecls__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__Group_1__1"


    // $ANTLR start "rule__ConDecls__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1821:1: rule__ConDecls__Group_1__1__Impl : ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) ) ;
    public final void rule__ConDecls__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1825:1: ( ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1826:1: ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1826:1: ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1827:1: ( rule__ConDecls__ConDeclsAssignment_1_1 )
            {
             before(grammarAccess.getConDeclsAccess().getConDeclsAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1828:1: ( rule__ConDecls__ConDeclsAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1828:2: rule__ConDecls__ConDeclsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConDecls__ConDeclsAssignment_1_1_in_rule__ConDecls__Group_1__1__Impl3670);
            rule__ConDecls__ConDeclsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConDeclsAccess().getConDeclsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__Group_1__1__Impl"


    // $ANTLR start "rule__ConDecl__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1842:1: rule__ConDecl__Group__0 : rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1 ;
    public final void rule__ConDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1846:1: ( rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1847:2: rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__0__Impl_in_rule__ConDecl__Group__03704);
            rule__ConDecl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConDecl__Group__1_in_rule__ConDecl__Group__03707);
            rule__ConDecl__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__Group__0"


    // $ANTLR start "rule__ConDecl__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1854:1: rule__ConDecl__Group__0__Impl : ( ( rule__ConDecl__NameAssignment_0 ) ) ;
    public final void rule__ConDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1858:1: ( ( ( rule__ConDecl__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1859:1: ( ( rule__ConDecl__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1859:1: ( ( rule__ConDecl__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1860:1: ( rule__ConDecl__NameAssignment_0 )
            {
             before(grammarAccess.getConDeclAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1861:1: ( rule__ConDecl__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1861:2: rule__ConDecl__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ConDecl__NameAssignment_0_in_rule__ConDecl__Group__0__Impl3734);
            rule__ConDecl__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConDeclAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__Group__0__Impl"


    // $ANTLR start "rule__ConDecl__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1871:1: rule__ConDecl__Group__1 : rule__ConDecl__Group__1__Impl ;
    public final void rule__ConDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1875:1: ( rule__ConDecl__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1876:2: rule__ConDecl__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__1__Impl_in_rule__ConDecl__Group__13764);
            rule__ConDecl__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__Group__1"


    // $ANTLR start "rule__ConDecl__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1882:1: rule__ConDecl__Group__1__Impl : ( ( rule__ConDecl__Group_1__0 )? ) ;
    public final void rule__ConDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1886:1: ( ( ( rule__ConDecl__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1887:1: ( ( rule__ConDecl__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1887:1: ( ( rule__ConDecl__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1888:1: ( rule__ConDecl__Group_1__0 )?
            {
             before(grammarAccess.getConDeclAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1889:1: ( rule__ConDecl__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1889:2: rule__ConDecl__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConDecl__Group_1__0_in_rule__ConDecl__Group__1__Impl3791);
                    rule__ConDecl__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConDeclAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__Group__1__Impl"


    // $ANTLR start "rule__ConDecl__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1903:1: rule__ConDecl__Group_1__0 : rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1 ;
    public final void rule__ConDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1907:1: ( rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1908:2: rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConDecl__Group_1__0__Impl_in_rule__ConDecl__Group_1__03826);
            rule__ConDecl__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConDecl__Group_1__1_in_rule__ConDecl__Group_1__03829);
            rule__ConDecl__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__Group_1__0"


    // $ANTLR start "rule__ConDecl__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1915:1: rule__ConDecl__Group_1__0__Impl : ( 'of' ) ;
    public final void rule__ConDecl__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1919:1: ( ( 'of' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1920:1: ( 'of' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1920:1: ( 'of' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1921:1: 'of'
            {
             before(grammarAccess.getConDeclAccess().getOfKeyword_1_0()); 
            match(input,21,FOLLOW_21_in_rule__ConDecl__Group_1__0__Impl3857); 
             after(grammarAccess.getConDeclAccess().getOfKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__Group_1__0__Impl"


    // $ANTLR start "rule__ConDecl__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1934:1: rule__ConDecl__Group_1__1 : rule__ConDecl__Group_1__1__Impl ;
    public final void rule__ConDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1938:1: ( rule__ConDecl__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1939:2: rule__ConDecl__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecl__Group_1__1__Impl_in_rule__ConDecl__Group_1__13888);
            rule__ConDecl__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__Group_1__1"


    // $ANTLR start "rule__ConDecl__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1945:1: rule__ConDecl__Group_1__1__Impl : ( ( rule__ConDecl__TyAssignment_1_1 ) ) ;
    public final void rule__ConDecl__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1949:1: ( ( ( rule__ConDecl__TyAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1950:1: ( ( rule__ConDecl__TyAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1950:1: ( ( rule__ConDecl__TyAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1951:1: ( rule__ConDecl__TyAssignment_1_1 )
            {
             before(grammarAccess.getConDeclAccess().getTyAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1952:1: ( rule__ConDecl__TyAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1952:2: rule__ConDecl__TyAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConDecl__TyAssignment_1_1_in_rule__ConDecl__Group_1__1__Impl3915);
            rule__ConDecl__TyAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getConDeclAccess().getTyAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__Group_1__1__Impl"


    // $ANTLR start "rule__Ty__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1966:1: rule__Ty__Group_1__0 : rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1 ;
    public final void rule__Ty__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1970:1: ( rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1971:2: rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__0__Impl_in_rule__Ty__Group_1__03949);
            rule__Ty__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_1__1_in_rule__Ty__Group_1__03952);
            rule__Ty__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_1__0"


    // $ANTLR start "rule__Ty__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1978:1: rule__Ty__Group_1__0__Impl : ( '|' ) ;
    public final void rule__Ty__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1982:1: ( ( '|' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1983:1: ( '|' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1983:1: ( '|' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1984:1: '|'
            {
             before(grammarAccess.getTyAccess().getVerticalLineKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__Ty__Group_1__0__Impl3980); 
             after(grammarAccess.getTyAccess().getVerticalLineKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_1__0__Impl"


    // $ANTLR start "rule__Ty__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1997:1: rule__Ty__Group_1__1 : rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2 ;
    public final void rule__Ty__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2001:1: ( rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2002:2: rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__1__Impl_in_rule__Ty__Group_1__14011);
            rule__Ty__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_1__2_in_rule__Ty__Group_1__14014);
            rule__Ty__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_1__1"


    // $ANTLR start "rule__Ty__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2009:1: rule__Ty__Group_1__1__Impl : ( ( rule__Ty__ValueAssignment_1_1 ) ) ;
    public final void rule__Ty__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2013:1: ( ( ( rule__Ty__ValueAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2014:1: ( ( rule__Ty__ValueAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2014:1: ( ( rule__Ty__ValueAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2015:1: ( rule__Ty__ValueAssignment_1_1 )
            {
             before(grammarAccess.getTyAccess().getValueAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2016:1: ( rule__Ty__ValueAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2016:2: rule__Ty__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Ty__ValueAssignment_1_1_in_rule__Ty__Group_1__1__Impl4041);
            rule__Ty__ValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTyAccess().getValueAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_1__1__Impl"


    // $ANTLR start "rule__Ty__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2026:1: rule__Ty__Group_1__2 : rule__Ty__Group_1__2__Impl ;
    public final void rule__Ty__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2030:1: ( rule__Ty__Group_1__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2031:2: rule__Ty__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__2__Impl_in_rule__Ty__Group_1__24071);
            rule__Ty__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_1__2"


    // $ANTLR start "rule__Ty__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2037:1: rule__Ty__Group_1__2__Impl : ( '|' ) ;
    public final void rule__Ty__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2041:1: ( ( '|' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2042:1: ( '|' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2042:1: ( '|' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2043:1: '|'
            {
             before(grammarAccess.getTyAccess().getVerticalLineKeyword_1_2()); 
            match(input,20,FOLLOW_20_in_rule__Ty__Group_1__2__Impl4099); 
             after(grammarAccess.getTyAccess().getVerticalLineKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_1__2__Impl"


    // $ANTLR start "rule__Ty__Group_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2062:1: rule__Ty__Group_2__0 : rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1 ;
    public final void rule__Ty__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2066:1: ( rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2067:2: rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2__0__Impl_in_rule__Ty__Group_2__04136);
            rule__Ty__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2__1_in_rule__Ty__Group_2__04139);
            rule__Ty__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2__0"


    // $ANTLR start "rule__Ty__Group_2__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2074:1: rule__Ty__Group_2__0__Impl : ( ( rule__Ty__ValueAssignment_2_0 ) ) ;
    public final void rule__Ty__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2078:1: ( ( ( rule__Ty__ValueAssignment_2_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2079:1: ( ( rule__Ty__ValueAssignment_2_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2079:1: ( ( rule__Ty__ValueAssignment_2_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2080:1: ( rule__Ty__ValueAssignment_2_0 )
            {
             before(grammarAccess.getTyAccess().getValueAssignment_2_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2081:1: ( rule__Ty__ValueAssignment_2_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2081:2: rule__Ty__ValueAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Ty__ValueAssignment_2_0_in_rule__Ty__Group_2__0__Impl4166);
            rule__Ty__ValueAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getTyAccess().getValueAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2__0__Impl"


    // $ANTLR start "rule__Ty__Group_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2091:1: rule__Ty__Group_2__1 : rule__Ty__Group_2__1__Impl ;
    public final void rule__Ty__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2095:1: ( rule__Ty__Group_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2096:2: rule__Ty__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2__1__Impl_in_rule__Ty__Group_2__14196);
            rule__Ty__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2__1"


    // $ANTLR start "rule__Ty__Group_2__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2102:1: rule__Ty__Group_2__1__Impl : ( ( rule__Ty__Group_2_1__0 )? ) ;
    public final void rule__Ty__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2106:1: ( ( ( rule__Ty__Group_2_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2107:1: ( ( rule__Ty__Group_2_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2107:1: ( ( rule__Ty__Group_2_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2108:1: ( rule__Ty__Group_2_1__0 )?
            {
             before(grammarAccess.getTyAccess().getGroup_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2109:1: ( rule__Ty__Group_2_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2109:2: rule__Ty__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_2_1__0_in_rule__Ty__Group_2__1__Impl4223);
                    rule__Ty__Group_2_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTyAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2__1__Impl"


    // $ANTLR start "rule__Ty__Group_2_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2123:1: rule__Ty__Group_2_1__0 : rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1 ;
    public final void rule__Ty__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2127:1: ( rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2128:2: rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__0__Impl_in_rule__Ty__Group_2_1__04258);
            rule__Ty__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2_1__1_in_rule__Ty__Group_2_1__04261);
            rule__Ty__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1__0"


    // $ANTLR start "rule__Ty__Group_2_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2135:1: rule__Ty__Group_2_1__0__Impl : ( '[' ) ;
    public final void rule__Ty__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2139:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2140:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2140:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2141:1: '['
            {
             before(grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0()); 
            match(input,14,FOLLOW_14_in_rule__Ty__Group_2_1__0__Impl4289); 
             after(grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1__0__Impl"


    // $ANTLR start "rule__Ty__Group_2_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2154:1: rule__Ty__Group_2_1__1 : rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2 ;
    public final void rule__Ty__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2158:1: ( rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2159:2: rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__1__Impl_in_rule__Ty__Group_2_1__14320);
            rule__Ty__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2_1__2_in_rule__Ty__Group_2_1__14323);
            rule__Ty__Group_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1__1"


    // $ANTLR start "rule__Ty__Group_2_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2166:1: rule__Ty__Group_2_1__1__Impl : ( ( rule__Ty__TyBindAssignment_2_1_1 ) ) ;
    public final void rule__Ty__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2170:1: ( ( ( rule__Ty__TyBindAssignment_2_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2171:1: ( ( rule__Ty__TyBindAssignment_2_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2171:1: ( ( rule__Ty__TyBindAssignment_2_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2172:1: ( rule__Ty__TyBindAssignment_2_1_1 )
            {
             before(grammarAccess.getTyAccess().getTyBindAssignment_2_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2173:1: ( rule__Ty__TyBindAssignment_2_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2173:2: rule__Ty__TyBindAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Ty__TyBindAssignment_2_1_1_in_rule__Ty__Group_2_1__1__Impl4350);
            rule__Ty__TyBindAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTyAccess().getTyBindAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1__1__Impl"


    // $ANTLR start "rule__Ty__Group_2_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2183:1: rule__Ty__Group_2_1__2 : rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3 ;
    public final void rule__Ty__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2187:1: ( rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2188:2: rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__2__Impl_in_rule__Ty__Group_2_1__24380);
            rule__Ty__Group_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2_1__3_in_rule__Ty__Group_2_1__24383);
            rule__Ty__Group_2_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1__2"


    // $ANTLR start "rule__Ty__Group_2_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2195:1: rule__Ty__Group_2_1__2__Impl : ( ( rule__Ty__Group_2_1_2__0 )* ) ;
    public final void rule__Ty__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2199:1: ( ( ( rule__Ty__Group_2_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2200:1: ( ( rule__Ty__Group_2_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2200:1: ( ( rule__Ty__Group_2_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2201:1: ( rule__Ty__Group_2_1_2__0 )*
            {
             before(grammarAccess.getTyAccess().getGroup_2_1_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2202:1: ( rule__Ty__Group_2_1_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==16) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2202:2: rule__Ty__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Ty__Group_2_1_2__0_in_rule__Ty__Group_2_1__2__Impl4410);
            	    rule__Ty__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getTyAccess().getGroup_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1__2__Impl"


    // $ANTLR start "rule__Ty__Group_2_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2212:1: rule__Ty__Group_2_1__3 : rule__Ty__Group_2_1__3__Impl ;
    public final void rule__Ty__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2216:1: ( rule__Ty__Group_2_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2217:2: rule__Ty__Group_2_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__3__Impl_in_rule__Ty__Group_2_1__34441);
            rule__Ty__Group_2_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1__3"


    // $ANTLR start "rule__Ty__Group_2_1__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2223:1: rule__Ty__Group_2_1__3__Impl : ( ']' ) ;
    public final void rule__Ty__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2227:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2228:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2228:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2229:1: ']'
            {
             before(grammarAccess.getTyAccess().getRightSquareBracketKeyword_2_1_3()); 
            match(input,15,FOLLOW_15_in_rule__Ty__Group_2_1__3__Impl4469); 
             after(grammarAccess.getTyAccess().getRightSquareBracketKeyword_2_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1__3__Impl"


    // $ANTLR start "rule__Ty__Group_2_1_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2250:1: rule__Ty__Group_2_1_2__0 : rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1 ;
    public final void rule__Ty__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2254:1: ( rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2255:2: rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__0__Impl_in_rule__Ty__Group_2_1_2__04508);
            rule__Ty__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__1_in_rule__Ty__Group_2_1_2__04511);
            rule__Ty__Group_2_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1_2__0"


    // $ANTLR start "rule__Ty__Group_2_1_2__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2262:1: rule__Ty__Group_2_1_2__0__Impl : ( ',' ) ;
    public final void rule__Ty__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2266:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2267:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2267:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2268:1: ','
            {
             before(grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0()); 
            match(input,16,FOLLOW_16_in_rule__Ty__Group_2_1_2__0__Impl4539); 
             after(grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1_2__0__Impl"


    // $ANTLR start "rule__Ty__Group_2_1_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2281:1: rule__Ty__Group_2_1_2__1 : rule__Ty__Group_2_1_2__1__Impl ;
    public final void rule__Ty__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2285:1: ( rule__Ty__Group_2_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2286:2: rule__Ty__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__1__Impl_in_rule__Ty__Group_2_1_2__14570);
            rule__Ty__Group_2_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1_2__1"


    // $ANTLR start "rule__Ty__Group_2_1_2__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2292:1: rule__Ty__Group_2_1_2__1__Impl : ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) ) ;
    public final void rule__Ty__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2296:1: ( ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2297:1: ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2297:1: ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2298:1: ( rule__Ty__TyBindAssignment_2_1_2_1 )
            {
             before(grammarAccess.getTyAccess().getTyBindAssignment_2_1_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2299:1: ( rule__Ty__TyBindAssignment_2_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2299:2: rule__Ty__TyBindAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Ty__TyBindAssignment_2_1_2_1_in_rule__Ty__Group_2_1_2__1__Impl4597);
            rule__Ty__TyBindAssignment_2_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTyAccess().getTyBindAssignment_2_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_2_1_2__1__Impl"


    // $ANTLR start "rule__Ty__Group_3__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2313:1: rule__Ty__Group_3__0 : rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1 ;
    public final void rule__Ty__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2317:1: ( rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2318:2: rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__0__Impl_in_rule__Ty__Group_3__04631);
            rule__Ty__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_3__1_in_rule__Ty__Group_3__04634);
            rule__Ty__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3__0"


    // $ANTLR start "rule__Ty__Group_3__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2325:1: rule__Ty__Group_3__0__Impl : ( '{' ) ;
    public final void rule__Ty__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2329:1: ( ( '{' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2330:1: ( '{' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2330:1: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2331:1: '{'
            {
             before(grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,18,FOLLOW_18_in_rule__Ty__Group_3__0__Impl4662); 
             after(grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3__0__Impl"


    // $ANTLR start "rule__Ty__Group_3__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2344:1: rule__Ty__Group_3__1 : rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2 ;
    public final void rule__Ty__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2348:1: ( rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2349:2: rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__1__Impl_in_rule__Ty__Group_3__14693);
            rule__Ty__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_3__2_in_rule__Ty__Group_3__14696);
            rule__Ty__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3__1"


    // $ANTLR start "rule__Ty__Group_3__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2356:1: rule__Ty__Group_3__1__Impl : ( ( rule__Ty__ElementsAssignment_3_1 ) ) ;
    public final void rule__Ty__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2360:1: ( ( ( rule__Ty__ElementsAssignment_3_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2361:1: ( ( rule__Ty__ElementsAssignment_3_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2361:1: ( ( rule__Ty__ElementsAssignment_3_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2362:1: ( rule__Ty__ElementsAssignment_3_1 )
            {
             before(grammarAccess.getTyAccess().getElementsAssignment_3_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2363:1: ( rule__Ty__ElementsAssignment_3_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2363:2: rule__Ty__ElementsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Ty__ElementsAssignment_3_1_in_rule__Ty__Group_3__1__Impl4723);
            rule__Ty__ElementsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTyAccess().getElementsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3__1__Impl"


    // $ANTLR start "rule__Ty__Group_3__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2373:1: rule__Ty__Group_3__2 : rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3 ;
    public final void rule__Ty__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2377:1: ( rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2378:2: rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__2__Impl_in_rule__Ty__Group_3__24753);
            rule__Ty__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_3__3_in_rule__Ty__Group_3__24756);
            rule__Ty__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3__2"


    // $ANTLR start "rule__Ty__Group_3__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2385:1: rule__Ty__Group_3__2__Impl : ( ( rule__Ty__Group_3_2__0 )* ) ;
    public final void rule__Ty__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2389:1: ( ( ( rule__Ty__Group_3_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2390:1: ( ( rule__Ty__Group_3_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2390:1: ( ( rule__Ty__Group_3_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2391:1: ( rule__Ty__Group_3_2__0 )*
            {
             before(grammarAccess.getTyAccess().getGroup_3_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2392:1: ( rule__Ty__Group_3_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==16) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2392:2: rule__Ty__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Ty__Group_3_2__0_in_rule__Ty__Group_3__2__Impl4783);
            	    rule__Ty__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getTyAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3__2__Impl"


    // $ANTLR start "rule__Ty__Group_3__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2402:1: rule__Ty__Group_3__3 : rule__Ty__Group_3__3__Impl ;
    public final void rule__Ty__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2406:1: ( rule__Ty__Group_3__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2407:2: rule__Ty__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__3__Impl_in_rule__Ty__Group_3__34814);
            rule__Ty__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3__3"


    // $ANTLR start "rule__Ty__Group_3__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2413:1: rule__Ty__Group_3__3__Impl : ( '}' ) ;
    public final void rule__Ty__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2417:1: ( ( '}' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2418:1: ( '}' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2418:1: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2419:1: '}'
            {
             before(grammarAccess.getTyAccess().getRightCurlyBracketKeyword_3_3()); 
            match(input,19,FOLLOW_19_in_rule__Ty__Group_3__3__Impl4842); 
             after(grammarAccess.getTyAccess().getRightCurlyBracketKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3__3__Impl"


    // $ANTLR start "rule__Ty__Group_3_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2440:1: rule__Ty__Group_3_2__0 : rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1 ;
    public final void rule__Ty__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2444:1: ( rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2445:2: rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_3_2__0__Impl_in_rule__Ty__Group_3_2__04881);
            rule__Ty__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_3_2__1_in_rule__Ty__Group_3_2__04884);
            rule__Ty__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3_2__0"


    // $ANTLR start "rule__Ty__Group_3_2__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2452:1: rule__Ty__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Ty__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2456:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2457:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2457:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2458:1: ','
            {
             before(grammarAccess.getTyAccess().getCommaKeyword_3_2_0()); 
            match(input,16,FOLLOW_16_in_rule__Ty__Group_3_2__0__Impl4912); 
             after(grammarAccess.getTyAccess().getCommaKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3_2__0__Impl"


    // $ANTLR start "rule__Ty__Group_3_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2471:1: rule__Ty__Group_3_2__1 : rule__Ty__Group_3_2__1__Impl ;
    public final void rule__Ty__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2475:1: ( rule__Ty__Group_3_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2476:2: rule__Ty__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_3_2__1__Impl_in_rule__Ty__Group_3_2__14943);
            rule__Ty__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3_2__1"


    // $ANTLR start "rule__Ty__Group_3_2__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2482:1: rule__Ty__Group_3_2__1__Impl : ( ( rule__Ty__ElementsAssignment_3_2_1 ) ) ;
    public final void rule__Ty__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2486:1: ( ( ( rule__Ty__ElementsAssignment_3_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2487:1: ( ( rule__Ty__ElementsAssignment_3_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2487:1: ( ( rule__Ty__ElementsAssignment_3_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2488:1: ( rule__Ty__ElementsAssignment_3_2_1 )
            {
             before(grammarAccess.getTyAccess().getElementsAssignment_3_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2489:1: ( rule__Ty__ElementsAssignment_3_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2489:2: rule__Ty__ElementsAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__Ty__ElementsAssignment_3_2_1_in_rule__Ty__Group_3_2__1__Impl4970);
            rule__Ty__ElementsAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTyAccess().getElementsAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__Group_3_2__1__Impl"


    // $ANTLR start "rule__TyElement__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2503:1: rule__TyElement__Group__0 : rule__TyElement__Group__0__Impl rule__TyElement__Group__1 ;
    public final void rule__TyElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2507:1: ( rule__TyElement__Group__0__Impl rule__TyElement__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2508:2: rule__TyElement__Group__0__Impl rule__TyElement__Group__1
            {
            pushFollow(FOLLOW_rule__TyElement__Group__0__Impl_in_rule__TyElement__Group__05004);
            rule__TyElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TyElement__Group__1_in_rule__TyElement__Group__05007);
            rule__TyElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyElement__Group__0"


    // $ANTLR start "rule__TyElement__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2515:1: rule__TyElement__Group__0__Impl : ( ( rule__TyElement__NameAssignment_0 ) ) ;
    public final void rule__TyElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2519:1: ( ( ( rule__TyElement__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2520:1: ( ( rule__TyElement__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2520:1: ( ( rule__TyElement__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2521:1: ( rule__TyElement__NameAssignment_0 )
            {
             before(grammarAccess.getTyElementAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2522:1: ( rule__TyElement__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2522:2: rule__TyElement__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__TyElement__NameAssignment_0_in_rule__TyElement__Group__0__Impl5034);
            rule__TyElement__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTyElementAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyElement__Group__0__Impl"


    // $ANTLR start "rule__TyElement__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2532:1: rule__TyElement__Group__1 : rule__TyElement__Group__1__Impl rule__TyElement__Group__2 ;
    public final void rule__TyElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2536:1: ( rule__TyElement__Group__1__Impl rule__TyElement__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2537:2: rule__TyElement__Group__1__Impl rule__TyElement__Group__2
            {
            pushFollow(FOLLOW_rule__TyElement__Group__1__Impl_in_rule__TyElement__Group__15064);
            rule__TyElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TyElement__Group__2_in_rule__TyElement__Group__15067);
            rule__TyElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyElement__Group__1"


    // $ANTLR start "rule__TyElement__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2544:1: rule__TyElement__Group__1__Impl : ( ':' ) ;
    public final void rule__TyElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2548:1: ( ( ':' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2549:1: ( ':' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2549:1: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2550:1: ':'
            {
             before(grammarAccess.getTyElementAccess().getColonKeyword_1()); 
            match(input,22,FOLLOW_22_in_rule__TyElement__Group__1__Impl5095); 
             after(grammarAccess.getTyElementAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyElement__Group__1__Impl"


    // $ANTLR start "rule__TyElement__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2563:1: rule__TyElement__Group__2 : rule__TyElement__Group__2__Impl ;
    public final void rule__TyElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2567:1: ( rule__TyElement__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2568:2: rule__TyElement__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TyElement__Group__2__Impl_in_rule__TyElement__Group__25126);
            rule__TyElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyElement__Group__2"


    // $ANTLR start "rule__TyElement__Group__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2574:1: rule__TyElement__Group__2__Impl : ( ( rule__TyElement__ValueAssignment_2 ) ) ;
    public final void rule__TyElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2578:1: ( ( ( rule__TyElement__ValueAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2579:1: ( ( rule__TyElement__ValueAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2579:1: ( ( rule__TyElement__ValueAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2580:1: ( rule__TyElement__ValueAssignment_2 )
            {
             before(grammarAccess.getTyElementAccess().getValueAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2581:1: ( rule__TyElement__ValueAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2581:2: rule__TyElement__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__TyElement__ValueAssignment_2_in_rule__TyElement__Group__2__Impl5153);
            rule__TyElement__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTyElementAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyElement__Group__2__Impl"


    // $ANTLR start "rule__TyBind__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2597:1: rule__TyBind__Group__0 : rule__TyBind__Group__0__Impl rule__TyBind__Group__1 ;
    public final void rule__TyBind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2601:1: ( rule__TyBind__Group__0__Impl rule__TyBind__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2602:2: rule__TyBind__Group__0__Impl rule__TyBind__Group__1
            {
            pushFollow(FOLLOW_rule__TyBind__Group__0__Impl_in_rule__TyBind__Group__05189);
            rule__TyBind__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TyBind__Group__1_in_rule__TyBind__Group__05192);
            rule__TyBind__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__Group__0"


    // $ANTLR start "rule__TyBind__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2609:1: rule__TyBind__Group__0__Impl : ( ( rule__TyBind__KeyAssignment_0 ) ) ;
    public final void rule__TyBind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2613:1: ( ( ( rule__TyBind__KeyAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2614:1: ( ( rule__TyBind__KeyAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2614:1: ( ( rule__TyBind__KeyAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2615:1: ( rule__TyBind__KeyAssignment_0 )
            {
             before(grammarAccess.getTyBindAccess().getKeyAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2616:1: ( rule__TyBind__KeyAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2616:2: rule__TyBind__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__TyBind__KeyAssignment_0_in_rule__TyBind__Group__0__Impl5219);
            rule__TyBind__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTyBindAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__Group__0__Impl"


    // $ANTLR start "rule__TyBind__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2626:1: rule__TyBind__Group__1 : rule__TyBind__Group__1__Impl ;
    public final void rule__TyBind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2630:1: ( rule__TyBind__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2631:2: rule__TyBind__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TyBind__Group__1__Impl_in_rule__TyBind__Group__15249);
            rule__TyBind__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__Group__1"


    // $ANTLR start "rule__TyBind__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2637:1: rule__TyBind__Group__1__Impl : ( ( rule__TyBind__Group_1__0 )? ) ;
    public final void rule__TyBind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2641:1: ( ( ( rule__TyBind__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2642:1: ( ( rule__TyBind__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2642:1: ( ( rule__TyBind__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2643:1: ( rule__TyBind__Group_1__0 )?
            {
             before(grammarAccess.getTyBindAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2644:1: ( rule__TyBind__Group_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==12) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2644:2: rule__TyBind__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TyBind__Group_1__0_in_rule__TyBind__Group__1__Impl5276);
                    rule__TyBind__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTyBindAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__Group__1__Impl"


    // $ANTLR start "rule__TyBind__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2658:1: rule__TyBind__Group_1__0 : rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1 ;
    public final void rule__TyBind__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2662:1: ( rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2663:2: rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1
            {
            pushFollow(FOLLOW_rule__TyBind__Group_1__0__Impl_in_rule__TyBind__Group_1__05311);
            rule__TyBind__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TyBind__Group_1__1_in_rule__TyBind__Group_1__05314);
            rule__TyBind__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__Group_1__0"


    // $ANTLR start "rule__TyBind__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2670:1: rule__TyBind__Group_1__0__Impl : ( '=' ) ;
    public final void rule__TyBind__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2674:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2675:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2675:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2676:1: '='
            {
             before(grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0()); 
            match(input,12,FOLLOW_12_in_rule__TyBind__Group_1__0__Impl5342); 
             after(grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__Group_1__0__Impl"


    // $ANTLR start "rule__TyBind__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2689:1: rule__TyBind__Group_1__1 : rule__TyBind__Group_1__1__Impl ;
    public final void rule__TyBind__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2693:1: ( rule__TyBind__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2694:2: rule__TyBind__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TyBind__Group_1__1__Impl_in_rule__TyBind__Group_1__15373);
            rule__TyBind__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__Group_1__1"


    // $ANTLR start "rule__TyBind__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2700:1: rule__TyBind__Group_1__1__Impl : ( ( rule__TyBind__ValueAssignment_1_1 ) ) ;
    public final void rule__TyBind__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2704:1: ( ( ( rule__TyBind__ValueAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2705:1: ( ( rule__TyBind__ValueAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2705:1: ( ( rule__TyBind__ValueAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2706:1: ( rule__TyBind__ValueAssignment_1_1 )
            {
             before(grammarAccess.getTyBindAccess().getValueAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2707:1: ( rule__TyBind__ValueAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2707:2: rule__TyBind__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__TyBind__ValueAssignment_1_1_in_rule__TyBind__Group_1__1__Impl5400);
            rule__TyBind__ValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTyBindAccess().getValueAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__Group_1__1__Impl"


    // $ANTLR start "rule__Model__DeclAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2722:1: rule__Model__DeclAssignment_0 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2726:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2727:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2727:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2728:1: ruleDecl
            {
             before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_05439);
            ruleDecl();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DeclAssignment_0"


    // $ANTLR start "rule__Model__DeclAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2737:1: rule__Model__DeclAssignment_1_1 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2741:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2742:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2742:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2743:1: ruleDecl
            {
             before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_15470);
            ruleDecl();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DeclAssignment_1_1"


    // $ANTLR start "rule__DeclGranularity__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2752:1: rule__DeclGranularity__NameAssignment_0 : ( ( 'granularity' ) ) ;
    public final void rule__DeclGranularity__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2756:1: ( ( ( 'granularity' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2757:1: ( ( 'granularity' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2757:1: ( ( 'granularity' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2758:1: ( 'granularity' )
            {
             before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2759:1: ( 'granularity' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2760:1: 'granularity'
            {
             before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            match(input,23,FOLLOW_23_in_rule__DeclGranularity__NameAssignment_05506); 
             after(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 

            }

             after(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclGranularity__NameAssignment_0"


    // $ANTLR start "rule__DeclGranularity__GranularityAssignment_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2775:1: rule__DeclGranularity__GranularityAssignment_2 : ( ruleInt ) ;
    public final void rule__DeclGranularity__GranularityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2779:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2780:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2780:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2781:1: ruleInt
            {
             before(grammarAccess.getDeclGranularityAccess().getGranularityIntParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInt_in_rule__DeclGranularity__GranularityAssignment_25545);
            ruleInt();

            state._fsp--;

             after(grammarAccess.getDeclGranularityAccess().getGranularityIntParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclGranularity__GranularityAssignment_2"


    // $ANTLR start "rule__DeclExport__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2790:1: rule__DeclExport__NameAssignment_0 : ( ( 'export' ) ) ;
    public final void rule__DeclExport__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2794:1: ( ( ( 'export' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2795:1: ( ( 'export' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2795:1: ( ( 'export' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2796:1: ( 'export' )
            {
             before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2797:1: ( 'export' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2798:1: 'export'
            {
             before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            match(input,24,FOLLOW_24_in_rule__DeclExport__NameAssignment_05581); 
             after(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 

            }

             after(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclExport__NameAssignment_0"


    // $ANTLR start "rule__DeclExport__ExportsAssignment_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2813:1: rule__DeclExport__ExportsAssignment_2 : ( ruleExport ) ;
    public final void rule__DeclExport__ExportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2817:1: ( ( ruleExport ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2818:1: ( ruleExport )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2818:1: ( ruleExport )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2819:1: ruleExport
            {
             before(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_25620);
            ruleExport();

            state._fsp--;

             after(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclExport__ExportsAssignment_2"


    // $ANTLR start "rule__DeclType__NameAssignment_0_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2828:1: rule__DeclType__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__DeclType__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2832:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2833:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2833:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2834:1: RULE_ID
            {
             before(grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclType__NameAssignment_0_15651); 
             after(grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__NameAssignment_0_1"


    // $ANTLR start "rule__DeclType__ValueAssignment_0_3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2843:1: rule__DeclType__ValueAssignment_0_3 : ( ( rule__DeclType__ValueAlternatives_0_3_0 ) ) ;
    public final void rule__DeclType__ValueAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2847:1: ( ( ( rule__DeclType__ValueAlternatives_0_3_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2848:1: ( ( rule__DeclType__ValueAlternatives_0_3_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2848:1: ( ( rule__DeclType__ValueAlternatives_0_3_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2849:1: ( rule__DeclType__ValueAlternatives_0_3_0 )
            {
             before(grammarAccess.getDeclTypeAccess().getValueAlternatives_0_3_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2850:1: ( rule__DeclType__ValueAlternatives_0_3_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2850:2: rule__DeclType__ValueAlternatives_0_3_0
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAlternatives_0_3_0_in_rule__DeclType__ValueAssignment_0_35682);
            rule__DeclType__ValueAlternatives_0_3_0();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getValueAlternatives_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__ValueAssignment_0_3"


    // $ANTLR start "rule__DeclType__NameAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2859:1: rule__DeclType__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__DeclType__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2863:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2864:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2864:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2865:1: RULE_ID
            {
             before(grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclType__NameAssignment_1_15715); 
             after(grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__NameAssignment_1_1"


    // $ANTLR start "rule__DeclType__AttrNameAssignment_1_3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2874:1: rule__DeclType__AttrNameAssignment_1_3 : ( RULE_ID ) ;
    public final void rule__DeclType__AttrNameAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2878:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2879:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2879:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2880:1: RULE_ID
            {
             before(grammarAccess.getDeclTypeAccess().getAttrNameIDTerminalRuleCall_1_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclType__AttrNameAssignment_1_35746); 
             after(grammarAccess.getDeclTypeAccess().getAttrNameIDTerminalRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__AttrNameAssignment_1_3"


    // $ANTLR start "rule__DeclType__AttrNameAssignment_1_4_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2889:1: rule__DeclType__AttrNameAssignment_1_4_1 : ( RULE_ID ) ;
    public final void rule__DeclType__AttrNameAssignment_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2893:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2894:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2894:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2895:1: RULE_ID
            {
             before(grammarAccess.getDeclTypeAccess().getAttrNameIDTerminalRuleCall_1_4_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclType__AttrNameAssignment_1_4_15777); 
             after(grammarAccess.getDeclTypeAccess().getAttrNameIDTerminalRuleCall_1_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__AttrNameAssignment_1_4_1"


    // $ANTLR start "rule__DeclType__ValueAssignment_1_7"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2904:1: rule__DeclType__ValueAssignment_1_7 : ( ruleConDecls ) ;
    public final void rule__DeclType__ValueAssignment_1_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2908:1: ( ( ruleConDecls ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2909:1: ( ruleConDecls )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2909:1: ( ruleConDecls )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2910:1: ruleConDecls
            {
             before(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_1_7_0()); 
            pushFollow(FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_1_75808);
            ruleConDecls();

            state._fsp--;

             after(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_1_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__ValueAssignment_1_7"


    // $ANTLR start "rule__DeclVal__NameAssignment_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2919:1: rule__DeclVal__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DeclVal__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2923:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2924:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2924:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2925:1: RULE_ID
            {
             before(grammarAccess.getDeclValAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclVal__NameAssignment_15839); 
             after(grammarAccess.getDeclValAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__NameAssignment_1"


    // $ANTLR start "rule__DeclVal__AttrAssignment_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2934:1: rule__DeclVal__AttrAssignment_2 : ( RULE_ID ) ;
    public final void rule__DeclVal__AttrAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2938:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2939:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2939:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2940:1: RULE_ID
            {
             before(grammarAccess.getDeclValAccess().getAttrIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclVal__AttrAssignment_25870); 
             after(grammarAccess.getDeclValAccess().getAttrIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__AttrAssignment_2"


    // $ANTLR start "rule__Export__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2949:1: rule__Export__NameAssignment_0 : ( ruleQid ) ;
    public final void rule__Export__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2953:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2954:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2954:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2955:1: ruleQid
            {
             before(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQid_in_rule__Export__NameAssignment_05901);
            ruleQid();

            state._fsp--;

             after(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__NameAssignment_0"


    // $ANTLR start "rule__Export__AttrNameAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2964:1: rule__Export__AttrNameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Export__AttrNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2968:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2969:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2969:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2970:1: RULE_ID
            {
             before(grammarAccess.getExportAccess().getAttrNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Export__AttrNameAssignment_1_15932); 
             after(grammarAccess.getExportAccess().getAttrNameIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__AttrNameAssignment_1_1"


    // $ANTLR start "rule__Export__AttrNameAssignment_1_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2979:1: rule__Export__AttrNameAssignment_1_2_1 : ( RULE_ID ) ;
    public final void rule__Export__AttrNameAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2983:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2984:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2984:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2985:1: RULE_ID
            {
             before(grammarAccess.getExportAccess().getAttrNameIDTerminalRuleCall_1_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Export__AttrNameAssignment_1_2_15963); 
             after(grammarAccess.getExportAccess().getAttrNameIDTerminalRuleCall_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Export__AttrNameAssignment_1_2_1"


    // $ANTLR start "rule__ConDecls__ConDeclsAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2994:1: rule__ConDecls__ConDeclsAssignment_0 : ( ruleConDecl ) ;
    public final void rule__ConDecls__ConDeclsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2998:1: ( ( ruleConDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2999:1: ( ruleConDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2999:1: ( ruleConDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3000:1: ruleConDecl
            {
             before(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_05994);
            ruleConDecl();

            state._fsp--;

             after(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__ConDeclsAssignment_0"


    // $ANTLR start "rule__ConDecls__ConDeclsAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3009:1: rule__ConDecls__ConDeclsAssignment_1_1 : ( ruleConDecl ) ;
    public final void rule__ConDecls__ConDeclsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3013:1: ( ( ruleConDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3014:1: ( ruleConDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3014:1: ( ruleConDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3015:1: ruleConDecl
            {
             before(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_1_16025);
            ruleConDecl();

            state._fsp--;

             after(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecls__ConDeclsAssignment_1_1"


    // $ANTLR start "rule__ConDecl__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3024:1: rule__ConDecl__NameAssignment_0 : ( ruleConBind ) ;
    public final void rule__ConDecl__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3028:1: ( ( ruleConBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3029:1: ( ruleConBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3029:1: ( ruleConBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3030:1: ruleConBind
            {
             before(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConBind_in_rule__ConDecl__NameAssignment_06056);
            ruleConBind();

            state._fsp--;

             after(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__NameAssignment_0"


    // $ANTLR start "rule__ConDecl__TyAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3039:1: rule__ConDecl__TyAssignment_1_1 : ( ruleTy ) ;
    public final void rule__ConDecl__TyAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3043:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3044:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3044:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3045:1: ruleTy
            {
             before(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleTy_in_rule__ConDecl__TyAssignment_1_16087);
            ruleTy();

            state._fsp--;

             after(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConDecl__TyAssignment_1_1"


    // $ANTLR start "rule__Ty__ValueAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3054:1: rule__Ty__ValueAssignment_0 : ( ruleInt ) ;
    public final void rule__Ty__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3058:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3059:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3059:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3060:1: ruleInt
            {
             before(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_06118);
            ruleInt();

            state._fsp--;

             after(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__ValueAssignment_0"


    // $ANTLR start "rule__Ty__ValueAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3069:1: rule__Ty__ValueAssignment_1_1 : ( ruleInt ) ;
    public final void rule__Ty__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3073:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3074:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3074:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3075:1: ruleInt
            {
             before(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_1_16149);
            ruleInt();

            state._fsp--;

             after(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__ValueAssignment_1_1"


    // $ANTLR start "rule__Ty__ValueAssignment_2_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3084:1: rule__Ty__ValueAssignment_2_0 : ( ruleQid ) ;
    public final void rule__Ty__ValueAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3088:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3089:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3089:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3090:1: ruleQid
            {
             before(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleQid_in_rule__Ty__ValueAssignment_2_06180);
            ruleQid();

            state._fsp--;

             after(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__ValueAssignment_2_0"


    // $ANTLR start "rule__Ty__TyBindAssignment_2_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3099:1: rule__Ty__TyBindAssignment_2_1_1 : ( ruleTyBind ) ;
    public final void rule__Ty__TyBindAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3103:1: ( ( ruleTyBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3104:1: ( ruleTyBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3104:1: ( ruleTyBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3105:1: ruleTyBind
            {
             before(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_16211);
            ruleTyBind();

            state._fsp--;

             after(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__TyBindAssignment_2_1_1"


    // $ANTLR start "rule__Ty__TyBindAssignment_2_1_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3114:1: rule__Ty__TyBindAssignment_2_1_2_1 : ( ruleTyBind ) ;
    public final void rule__Ty__TyBindAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3118:1: ( ( ruleTyBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3119:1: ( ruleTyBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3119:1: ( ruleTyBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3120:1: ruleTyBind
            {
             before(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_2_16242);
            ruleTyBind();

            state._fsp--;

             after(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__TyBindAssignment_2_1_2_1"


    // $ANTLR start "rule__Ty__ElementsAssignment_3_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3129:1: rule__Ty__ElementsAssignment_3_1 : ( ruleTyElement ) ;
    public final void rule__Ty__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3133:1: ( ( ruleTyElement ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3134:1: ( ruleTyElement )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3134:1: ( ruleTyElement )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3135:1: ruleTyElement
            {
             before(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_16273);
            ruleTyElement();

            state._fsp--;

             after(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__ElementsAssignment_3_1"


    // $ANTLR start "rule__Ty__ElementsAssignment_3_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3144:1: rule__Ty__ElementsAssignment_3_2_1 : ( ruleTyElement ) ;
    public final void rule__Ty__ElementsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3148:1: ( ( ruleTyElement ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3149:1: ( ruleTyElement )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3149:1: ( ruleTyElement )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3150:1: ruleTyElement
            {
             before(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_2_16304);
            ruleTyElement();

            state._fsp--;

             after(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Ty__ElementsAssignment_3_2_1"


    // $ANTLR start "rule__TyElement__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3159:1: rule__TyElement__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__TyElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3163:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3164:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3164:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3165:1: RULE_ID
            {
             before(grammarAccess.getTyElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TyElement__NameAssignment_06335); 
             after(grammarAccess.getTyElementAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyElement__NameAssignment_0"


    // $ANTLR start "rule__TyElement__ValueAssignment_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3174:1: rule__TyElement__ValueAssignment_2 : ( ruleTy ) ;
    public final void rule__TyElement__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3178:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3179:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3179:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3180:1: ruleTy
            {
             before(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleTy_in_rule__TyElement__ValueAssignment_26366);
            ruleTy();

            state._fsp--;

             after(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyElement__ValueAssignment_2"


    // $ANTLR start "rule__TyBind__KeyAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3189:1: rule__TyBind__KeyAssignment_0 : ( ruleQid ) ;
    public final void rule__TyBind__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3193:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3194:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3194:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3195:1: ruleQid
            {
             before(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQid_in_rule__TyBind__KeyAssignment_06397);
            ruleQid();

            state._fsp--;

             after(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__KeyAssignment_0"


    // $ANTLR start "rule__TyBind__ValueAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3204:1: rule__TyBind__ValueAssignment_1_1 : ( ruleTy ) ;
    public final void rule__TyBind__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3208:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3209:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3209:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3210:1: ruleTy
            {
             before(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleTy_in_rule__TyBind__ValueAssignment_1_16428);
            ruleTy();

            state._fsp--;

             after(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TyBind__ValueAssignment_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecl128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decl__Alternatives_in_ruleDecl154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_entryRuleDeclGranularity181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclGranularity188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__0_in_ruleDeclGranularity214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__0_in_ruleDeclExport274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Alternatives_in_ruleDeclType334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__0_in_ruleDeclVal394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__0_in_ruleExport454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_entryRuleConDecls481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecls488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__0_in_ruleConDecls514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__0_in_ruleConDecl574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Alternatives_in_ruleTy634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__0_in_ruleTyElement694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__0_in_ruleTyBind754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_entryRuleConBind781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConBind788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CONS_in_ruleConBind814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_entryRuleInt840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInt847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Int__Alternatives_in_ruleInt873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQid933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_rule__Decl__Alternatives1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__0_in_rule__DeclType__Alternatives1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__0_in_rule__DeclType__Alternatives1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_rule__DeclType__ValueAlternatives_0_3_01102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__DeclType__ValueAlternatives_0_3_01119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_0_in_rule__Ty__Alternatives1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__0_in_rule__Ty__Alternatives1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__0_in_rule__Ty__Alternatives1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__0_in_rule__Ty__Alternatives1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_POSINT_in_rule__Int__Alternatives1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEGINT_in_rule__Int__Alternatives1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01285 = new BitSet(new long[]{0x0000000001822800L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl1372 = new BitSet(new long[]{0x0000000001822802L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__01407 = new BitSet(new long[]{0x0000000001822800L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__01410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Model__Group_1__0__Impl1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__11472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__01533 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__01536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__11593 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__11596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__DeclGranularity__Group__1__Impl1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__21655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__01718 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__01721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__11778 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__11781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__DeclExport__Group__1__Impl1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__21840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl1867 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__0__Impl_in_rule__DeclType__Group_0__01904 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__1_in_rule__DeclType__Group_0__01907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__DeclType__Group_0__0__Impl1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__1__Impl_in_rule__DeclType__Group_0__11966 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__2_in_rule__DeclType__Group_0__11969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__NameAssignment_0_1_in_rule__DeclType__Group_0__1__Impl1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__2__Impl_in_rule__DeclType__Group_0__22026 = new BitSet(new long[]{0x00000000001400F0L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__3_in_rule__DeclType__Group_0__22029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__DeclType__Group_0__2__Impl2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__3__Impl_in_rule__DeclType__Group_0__32088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_0_3_in_rule__DeclType__Group_0__3__Impl2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__0__Impl_in_rule__DeclType__Group_1__02153 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__1_in_rule__DeclType__Group_1__02156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__DeclType__Group_1__0__Impl2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__1__Impl_in_rule__DeclType__Group_1__12215 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__2_in_rule__DeclType__Group_1__12218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__NameAssignment_1_1_in_rule__DeclType__Group_1__1__Impl2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__2__Impl_in_rule__DeclType__Group_1__22275 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__3_in_rule__DeclType__Group_1__22278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DeclType__Group_1__2__Impl2306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__3__Impl_in_rule__DeclType__Group_1__32337 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__4_in_rule__DeclType__Group_1__32340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__AttrNameAssignment_1_3_in_rule__DeclType__Group_1__3__Impl2367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__4__Impl_in_rule__DeclType__Group_1__42397 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__5_in_rule__DeclType__Group_1__42400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1_4__0_in_rule__DeclType__Group_1__4__Impl2427 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__5__Impl_in_rule__DeclType__Group_1__52458 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__6_in_rule__DeclType__Group_1__52461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DeclType__Group_1__5__Impl2489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__6__Impl_in_rule__DeclType__Group_1__62520 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__7_in_rule__DeclType__Group_1__62523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__DeclType__Group_1__6__Impl2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__7__Impl_in_rule__DeclType__Group_1__72582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_1_7_in_rule__DeclType__Group_1__7__Impl2609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1_4__0__Impl_in_rule__DeclType__Group_1_4__02655 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1_4__1_in_rule__DeclType__Group_1_4__02658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DeclType__Group_1_4__0__Impl2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1_4__1__Impl_in_rule__DeclType__Group_1_4__12717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__AttrNameAssignment_1_4_1_in_rule__DeclType__Group_1_4__1__Impl2744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__0__Impl_in_rule__DeclVal__Group__02778 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__1_in_rule__DeclVal__Group__02781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__DeclVal__Group__0__Impl2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__1__Impl_in_rule__DeclVal__Group__12840 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__2_in_rule__DeclVal__Group__12843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_1_in_rule__DeclVal__Group__1__Impl2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__2__Impl_in_rule__DeclVal__Group__22900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__AttrAssignment_2_in_rule__DeclVal__Group__2__Impl2927 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__02964 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Export__Group__1_in_rule__Export__Group__02967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl2994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__13024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__03086 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__03089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Export__Group_1__0__Impl3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__13148 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__13151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__23208 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__23211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl3238 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__33269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Export__Group_1__3__Impl3297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__03336 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__03339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Export__Group_1_2__0__Impl3367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__13398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__0__Impl_in_rule__ConDecls__Group__03459 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__1_in_rule__ConDecls__Group__03462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__ConDeclsAssignment_0_in_rule__ConDecls__Group__0__Impl3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__1__Impl_in_rule__ConDecls__Group__13519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__0_in_rule__ConDecls__Group__1__Impl3546 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__0__Impl_in_rule__ConDecls__Group_1__03581 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__1_in_rule__ConDecls__Group_1__03584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ConDecls__Group_1__0__Impl3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__1__Impl_in_rule__ConDecls__Group_1__13643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__ConDeclsAssignment_1_1_in_rule__ConDecls__Group_1__1__Impl3670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__0__Impl_in_rule__ConDecl__Group__03704 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__1_in_rule__ConDecl__Group__03707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__NameAssignment_0_in_rule__ConDecl__Group__0__Impl3734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__1__Impl_in_rule__ConDecl__Group__13764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__0_in_rule__ConDecl__Group__1__Impl3791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__0__Impl_in_rule__ConDecl__Group_1__03826 = new BitSet(new long[]{0x00000000001400F0L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__1_in_rule__ConDecl__Group_1__03829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ConDecl__Group_1__0__Impl3857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__1__Impl_in_rule__ConDecl__Group_1__13888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__TyAssignment_1_1_in_rule__ConDecl__Group_1__1__Impl3915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__0__Impl_in_rule__Ty__Group_1__03949 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__1_in_rule__Ty__Group_1__03952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Ty__Group_1__0__Impl3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__1__Impl_in_rule__Ty__Group_1__14011 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__2_in_rule__Ty__Group_1__14014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_1_1_in_rule__Ty__Group_1__1__Impl4041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__2__Impl_in_rule__Ty__Group_1__24071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Ty__Group_1__2__Impl4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__0__Impl_in_rule__Ty__Group_2__04136 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__1_in_rule__Ty__Group_2__04139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_2_0_in_rule__Ty__Group_2__0__Impl4166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__1__Impl_in_rule__Ty__Group_2__14196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__0_in_rule__Ty__Group_2__1__Impl4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__0__Impl_in_rule__Ty__Group_2_1__04258 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__1_in_rule__Ty__Group_2_1__04261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Ty__Group_2_1__0__Impl4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__1__Impl_in_rule__Ty__Group_2_1__14320 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__2_in_rule__Ty__Group_2_1__14323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__TyBindAssignment_2_1_1_in_rule__Ty__Group_2_1__1__Impl4350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__2__Impl_in_rule__Ty__Group_2_1__24380 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__3_in_rule__Ty__Group_2_1__24383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__0_in_rule__Ty__Group_2_1__2__Impl4410 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__3__Impl_in_rule__Ty__Group_2_1__34441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Ty__Group_2_1__3__Impl4469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__0__Impl_in_rule__Ty__Group_2_1_2__04508 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__1_in_rule__Ty__Group_2_1_2__04511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Ty__Group_2_1_2__0__Impl4539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__1__Impl_in_rule__Ty__Group_2_1_2__14570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__TyBindAssignment_2_1_2_1_in_rule__Ty__Group_2_1_2__1__Impl4597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__0__Impl_in_rule__Ty__Group_3__04631 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__1_in_rule__Ty__Group_3__04634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Ty__Group_3__0__Impl4662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__1__Impl_in_rule__Ty__Group_3__14693 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__2_in_rule__Ty__Group_3__14696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ElementsAssignment_3_1_in_rule__Ty__Group_3__1__Impl4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__2__Impl_in_rule__Ty__Group_3__24753 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__3_in_rule__Ty__Group_3__24756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__0_in_rule__Ty__Group_3__2__Impl4783 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__3__Impl_in_rule__Ty__Group_3__34814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Ty__Group_3__3__Impl4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__0__Impl_in_rule__Ty__Group_3_2__04881 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__1_in_rule__Ty__Group_3_2__04884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Ty__Group_3_2__0__Impl4912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__1__Impl_in_rule__Ty__Group_3_2__14943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ElementsAssignment_3_2_1_in_rule__Ty__Group_3_2__1__Impl4970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__0__Impl_in_rule__TyElement__Group__05004 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__TyElement__Group__1_in_rule__TyElement__Group__05007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__NameAssignment_0_in_rule__TyElement__Group__0__Impl5034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__1__Impl_in_rule__TyElement__Group__15064 = new BitSet(new long[]{0x00000000001400F0L});
    public static final BitSet FOLLOW_rule__TyElement__Group__2_in_rule__TyElement__Group__15067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__TyElement__Group__1__Impl5095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__2__Impl_in_rule__TyElement__Group__25126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__ValueAssignment_2_in_rule__TyElement__Group__2__Impl5153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__0__Impl_in_rule__TyBind__Group__05189 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__TyBind__Group__1_in_rule__TyBind__Group__05192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__KeyAssignment_0_in_rule__TyBind__Group__0__Impl5219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__1__Impl_in_rule__TyBind__Group__15249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__0_in_rule__TyBind__Group__1__Impl5276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__0__Impl_in_rule__TyBind__Group_1__05311 = new BitSet(new long[]{0x00000000001400F0L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__1_in_rule__TyBind__Group_1__05314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__TyBind__Group_1__0__Impl5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__1__Impl_in_rule__TyBind__Group_1__15373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__ValueAssignment_1_1_in_rule__TyBind__Group_1__1__Impl5400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_05439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_15470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DeclGranularity__NameAssignment_05506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__DeclGranularity__GranularityAssignment_25545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__DeclExport__NameAssignment_05581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_25620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclType__NameAssignment_0_15651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAlternatives_0_3_0_in_rule__DeclType__ValueAssignment_0_35682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclType__NameAssignment_1_15715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclType__AttrNameAssignment_1_35746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclType__AttrNameAssignment_1_4_15777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_1_75808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclVal__NameAssignment_15839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclVal__AttrAssignment_25870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__Export__NameAssignment_05901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Export__AttrNameAssignment_1_15932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Export__AttrNameAssignment_1_2_15963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_05994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_1_16025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_rule__ConDecl__NameAssignment_06056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__ConDecl__TyAssignment_1_16087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_06118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_1_16149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__Ty__ValueAssignment_2_06180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_16211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_2_16242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_16273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_2_16304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TyElement__NameAssignment_06335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__TyElement__ValueAssignment_26366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__TyBind__KeyAssignment_06397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__TyBind__ValueAssignment_1_16428 = new BitSet(new long[]{0x0000000000000002L});

}