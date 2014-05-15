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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_POSINT", "RULE_NEGINT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "';'", "'='", "'type'", "'todo'", "'val'", "'{'", "'}'", "','", "'granularity'", "'export'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_POSINT=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int RULE_NEGINT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:181:1: ruleDeclType : ( ( rule__DeclType__Group__0 ) ) ;
    public final void ruleDeclType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:185:2: ( ( ( rule__DeclType__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:186:1: ( ( rule__DeclType__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:186:1: ( ( rule__DeclType__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:187:1: ( rule__DeclType__Group__0 )
            {
             before(grammarAccess.getDeclTypeAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:188:1: ( rule__DeclType__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:188:2: rule__DeclType__Group__0
            {
            pushFollow(FOLLOW_rule__DeclType__Group__0_in_ruleDeclType334);
            rule__DeclType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getGroup()); 

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


    // $ANTLR start "entryRuleInteger"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:256:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:257:1: ( ruleInteger EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:258:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger481);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger488); 

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
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:265:1: ruleInteger : ( ( rule__Integer__Alternatives ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:269:2: ( ( ( rule__Integer__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:270:1: ( ( rule__Integer__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:270:1: ( ( rule__Integer__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:271:1: ( rule__Integer__Alternatives )
            {
             before(grammarAccess.getIntegerAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:272:1: ( rule__Integer__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:272:2: rule__Integer__Alternatives
            {
            pushFollow(FOLLOW_rule__Integer__Alternatives_in_ruleInteger514);
            rule__Integer__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIntegerAccess().getAlternatives()); 

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
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:284:1: entryRuleQid : ruleQid EOF ;
    public final void entryRuleQid() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:285:1: ( ruleQid EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:286:1: ruleQid EOF
            {
             before(grammarAccess.getQidRule()); 
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid541);
            ruleQid();

            state._fsp--;

             after(grammarAccess.getQidRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid548); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:293:1: ruleQid : ( RULE_ID ) ;
    public final void ruleQid() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:297:2: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:298:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:298:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:299:1: RULE_ID
            {
             before(grammarAccess.getQidAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQid574); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:312:1: rule__Decl__Alternatives : ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) );
    public final void rule__Decl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:316:1: ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt1=1;
                }
                break;
            case 19:
                {
                alt1=2;
                }
                break;
            case 12:
                {
                alt1=3;
                }
                break;
            case 14:
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:317:1: ( ruleDeclGranularity )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:317:1: ( ruleDeclGranularity )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:318:1: ruleDeclGranularity
                    {
                     before(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives609);
                    ruleDeclGranularity();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:323:6: ( ruleDeclExport )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:323:6: ( ruleDeclExport )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:324:1: ruleDeclExport
                    {
                     before(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives626);
                    ruleDeclExport();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:329:6: ( ruleDeclType )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:329:6: ( ruleDeclType )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:330:1: ruleDeclType
                    {
                     before(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDeclType_in_rule__Decl__Alternatives643);
                    ruleDeclType();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:335:6: ( ruleDeclVal )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:335:6: ( ruleDeclVal )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:336:1: ruleDeclVal
                    {
                     before(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives660);
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


    // $ANTLR start "rule__Integer__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:346:1: rule__Integer__Alternatives : ( ( RULE_POSINT ) | ( RULE_NEGINT ) );
    public final void rule__Integer__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:350:1: ( ( RULE_POSINT ) | ( RULE_NEGINT ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_POSINT) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_NEGINT) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:351:1: ( RULE_POSINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:351:1: ( RULE_POSINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:352:1: RULE_POSINT
                    {
                     before(grammarAccess.getIntegerAccess().getPOSINTTerminalRuleCall_0()); 
                    match(input,RULE_POSINT,FOLLOW_RULE_POSINT_in_rule__Integer__Alternatives692); 
                     after(grammarAccess.getIntegerAccess().getPOSINTTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:357:6: ( RULE_NEGINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:357:6: ( RULE_NEGINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:358:1: RULE_NEGINT
                    {
                     before(grammarAccess.getIntegerAccess().getNEGINTTerminalRuleCall_1()); 
                    match(input,RULE_NEGINT,FOLLOW_RULE_NEGINT_in_rule__Integer__Alternatives709); 
                     after(grammarAccess.getIntegerAccess().getNEGINTTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__Integer__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:370:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:374:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:375:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0739);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0742);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:382:1: rule__Model__Group__0__Impl : ( ( rule__Model__DeclAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:386:1: ( ( ( rule__Model__DeclAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:387:1: ( ( rule__Model__DeclAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:387:1: ( ( rule__Model__DeclAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:388:1: ( rule__Model__DeclAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getDeclAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:389:1: ( rule__Model__DeclAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:389:2: rule__Model__DeclAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl769);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:399:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:403:1: ( rule__Model__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:404:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1799);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:410:1: rule__Model__Group__1__Impl : ( ( rule__Model__Group_1__0 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:414:1: ( ( ( rule__Model__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:415:1: ( ( rule__Model__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:415:1: ( ( rule__Model__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:416:1: ( rule__Model__Group_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:417:1: ( rule__Model__Group_1__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10||LA3_0==12||LA3_0==14||(LA3_0>=18 && LA3_0<=19)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:417:2: rule__Model__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl826);
            	    rule__Model__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:431:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:435:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:436:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__0861);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0864);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:443:1: rule__Model__Group_1__0__Impl : ( ( ';' )? ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:447:1: ( ( ( ';' )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:448:1: ( ( ';' )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:448:1: ( ( ';' )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:449:1: ( ';' )?
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_1_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:450:1: ( ';' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==10) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:451:2: ';'
                    {
                    match(input,10,FOLLOW_10_in_rule__Model__Group_1__0__Impl893); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:462:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:466:1: ( rule__Model__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:467:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__1926);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:473:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__DeclAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:477:1: ( ( ( rule__Model__DeclAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:478:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:478:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:479:1: ( rule__Model__DeclAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getDeclAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:480:1: ( rule__Model__DeclAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:480:2: rule__Model__DeclAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl953);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:494:1: rule__DeclGranularity__Group__0 : rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 ;
    public final void rule__DeclGranularity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:498:1: ( rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:499:2: rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__0987);
            rule__DeclGranularity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__0990);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:506:1: rule__DeclGranularity__Group__0__Impl : ( ( rule__DeclGranularity__NameAssignment_0 ) ) ;
    public final void rule__DeclGranularity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:510:1: ( ( ( rule__DeclGranularity__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:511:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:511:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:512:1: ( rule__DeclGranularity__NameAssignment_0 )
            {
             before(grammarAccess.getDeclGranularityAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:513:1: ( rule__DeclGranularity__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:513:2: rule__DeclGranularity__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl1017);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:523:1: rule__DeclGranularity__Group__1 : rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 ;
    public final void rule__DeclGranularity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:527:1: ( rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:528:2: rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__11047);
            rule__DeclGranularity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__11050);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:535:1: rule__DeclGranularity__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclGranularity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:539:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:540:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:540:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:541:1: '='
            {
             before(grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1()); 
            match(input,11,FOLLOW_11_in_rule__DeclGranularity__Group__1__Impl1078); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:554:1: rule__DeclGranularity__Group__2 : rule__DeclGranularity__Group__2__Impl ;
    public final void rule__DeclGranularity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:558:1: ( rule__DeclGranularity__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:559:2: rule__DeclGranularity__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__21109);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:565:1: rule__DeclGranularity__Group__2__Impl : ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) ;
    public final void rule__DeclGranularity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:569:1: ( ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:570:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:570:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:571:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            {
             before(grammarAccess.getDeclGranularityAccess().getGranularityAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:572:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:572:2: rule__DeclGranularity__GranularityAssignment_2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl1136);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:588:1: rule__DeclExport__Group__0 : rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 ;
    public final void rule__DeclExport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:592:1: ( rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:593:2: rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__01172);
            rule__DeclExport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__01175);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:600:1: rule__DeclExport__Group__0__Impl : ( ( rule__DeclExport__NameAssignment_0 ) ) ;
    public final void rule__DeclExport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:604:1: ( ( ( rule__DeclExport__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:605:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:605:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:606:1: ( rule__DeclExport__NameAssignment_0 )
            {
             before(grammarAccess.getDeclExportAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:607:1: ( rule__DeclExport__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:607:2: rule__DeclExport__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl1202);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:617:1: rule__DeclExport__Group__1 : rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 ;
    public final void rule__DeclExport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:621:1: ( rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:622:2: rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__11232);
            rule__DeclExport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__11235);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:629:1: rule__DeclExport__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclExport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:633:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:634:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:634:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:635:1: '='
            {
             before(grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1()); 
            match(input,11,FOLLOW_11_in_rule__DeclExport__Group__1__Impl1263); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:648:1: rule__DeclExport__Group__2 : rule__DeclExport__Group__2__Impl ;
    public final void rule__DeclExport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:652:1: ( rule__DeclExport__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:653:2: rule__DeclExport__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__21294);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:659:1: rule__DeclExport__Group__2__Impl : ( ( rule__DeclExport__ExportsAssignment_2 )* ) ;
    public final void rule__DeclExport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:663:1: ( ( ( rule__DeclExport__ExportsAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:664:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:664:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:665:1: ( rule__DeclExport__ExportsAssignment_2 )*
            {
             before(grammarAccess.getDeclExportAccess().getExportsAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:666:1: ( rule__DeclExport__ExportsAssignment_2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:666:2: rule__DeclExport__ExportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl1321);
            	    rule__DeclExport__ExportsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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


    // $ANTLR start "rule__DeclType__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:682:1: rule__DeclType__Group__0 : rule__DeclType__Group__0__Impl rule__DeclType__Group__1 ;
    public final void rule__DeclType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:686:1: ( rule__DeclType__Group__0__Impl rule__DeclType__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:687:2: rule__DeclType__Group__0__Impl rule__DeclType__Group__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group__0__Impl_in_rule__DeclType__Group__01358);
            rule__DeclType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group__1_in_rule__DeclType__Group__01361);
            rule__DeclType__Group__1();

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
    // $ANTLR end "rule__DeclType__Group__0"


    // $ANTLR start "rule__DeclType__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:694:1: rule__DeclType__Group__0__Impl : ( 'type' ) ;
    public final void rule__DeclType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:698:1: ( ( 'type' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:699:1: ( 'type' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:699:1: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:700:1: 'type'
            {
             before(grammarAccess.getDeclTypeAccess().getTypeKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__DeclType__Group__0__Impl1389); 
             after(grammarAccess.getDeclTypeAccess().getTypeKeyword_0()); 

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
    // $ANTLR end "rule__DeclType__Group__0__Impl"


    // $ANTLR start "rule__DeclType__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:713:1: rule__DeclType__Group__1 : rule__DeclType__Group__1__Impl rule__DeclType__Group__2 ;
    public final void rule__DeclType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:717:1: ( rule__DeclType__Group__1__Impl rule__DeclType__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:718:2: rule__DeclType__Group__1__Impl rule__DeclType__Group__2
            {
            pushFollow(FOLLOW_rule__DeclType__Group__1__Impl_in_rule__DeclType__Group__11420);
            rule__DeclType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group__2_in_rule__DeclType__Group__11423);
            rule__DeclType__Group__2();

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
    // $ANTLR end "rule__DeclType__Group__1"


    // $ANTLR start "rule__DeclType__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:725:1: rule__DeclType__Group__1__Impl : ( ( rule__DeclType__NameAssignment_1 ) ) ;
    public final void rule__DeclType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:729:1: ( ( ( rule__DeclType__NameAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:730:1: ( ( rule__DeclType__NameAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:730:1: ( ( rule__DeclType__NameAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:731:1: ( rule__DeclType__NameAssignment_1 )
            {
             before(grammarAccess.getDeclTypeAccess().getNameAssignment_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:732:1: ( rule__DeclType__NameAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:732:2: rule__DeclType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__DeclType__NameAssignment_1_in_rule__DeclType__Group__1__Impl1450);
            rule__DeclType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclTypeAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__DeclType__Group__1__Impl"


    // $ANTLR start "rule__DeclType__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:742:1: rule__DeclType__Group__2 : rule__DeclType__Group__2__Impl rule__DeclType__Group__3 ;
    public final void rule__DeclType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:746:1: ( rule__DeclType__Group__2__Impl rule__DeclType__Group__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:747:2: rule__DeclType__Group__2__Impl rule__DeclType__Group__3
            {
            pushFollow(FOLLOW_rule__DeclType__Group__2__Impl_in_rule__DeclType__Group__21480);
            rule__DeclType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group__3_in_rule__DeclType__Group__21483);
            rule__DeclType__Group__3();

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
    // $ANTLR end "rule__DeclType__Group__2"


    // $ANTLR start "rule__DeclType__Group__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:754:1: rule__DeclType__Group__2__Impl : ( '=' ) ;
    public final void rule__DeclType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:758:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:759:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:759:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:760:1: '='
            {
             before(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2()); 
            match(input,11,FOLLOW_11_in_rule__DeclType__Group__2__Impl1511); 
             after(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2()); 

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
    // $ANTLR end "rule__DeclType__Group__2__Impl"


    // $ANTLR start "rule__DeclType__Group__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:773:1: rule__DeclType__Group__3 : rule__DeclType__Group__3__Impl ;
    public final void rule__DeclType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:777:1: ( rule__DeclType__Group__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:778:2: rule__DeclType__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group__3__Impl_in_rule__DeclType__Group__31542);
            rule__DeclType__Group__3__Impl();

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
    // $ANTLR end "rule__DeclType__Group__3"


    // $ANTLR start "rule__DeclType__Group__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:784:1: rule__DeclType__Group__3__Impl : ( 'todo' ) ;
    public final void rule__DeclType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:788:1: ( ( 'todo' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:789:1: ( 'todo' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:789:1: ( 'todo' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:790:1: 'todo'
            {
             before(grammarAccess.getDeclTypeAccess().getTodoKeyword_3()); 
            match(input,13,FOLLOW_13_in_rule__DeclType__Group__3__Impl1570); 
             after(grammarAccess.getDeclTypeAccess().getTodoKeyword_3()); 

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
    // $ANTLR end "rule__DeclType__Group__3__Impl"


    // $ANTLR start "rule__DeclVal__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:811:1: rule__DeclVal__Group__0 : rule__DeclVal__Group__0__Impl rule__DeclVal__Group__1 ;
    public final void rule__DeclVal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:815:1: ( rule__DeclVal__Group__0__Impl rule__DeclVal__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:816:2: rule__DeclVal__Group__0__Impl rule__DeclVal__Group__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__0__Impl_in_rule__DeclVal__Group__01609);
            rule__DeclVal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group__1_in_rule__DeclVal__Group__01612);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:823:1: rule__DeclVal__Group__0__Impl : ( 'val' ) ;
    public final void rule__DeclVal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:827:1: ( ( 'val' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:828:1: ( 'val' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:828:1: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:829:1: 'val'
            {
             before(grammarAccess.getDeclValAccess().getValKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__DeclVal__Group__0__Impl1640); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:842:1: rule__DeclVal__Group__1 : rule__DeclVal__Group__1__Impl rule__DeclVal__Group__2 ;
    public final void rule__DeclVal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:846:1: ( rule__DeclVal__Group__1__Impl rule__DeclVal__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:847:2: rule__DeclVal__Group__1__Impl rule__DeclVal__Group__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__1__Impl_in_rule__DeclVal__Group__11671);
            rule__DeclVal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group__2_in_rule__DeclVal__Group__11674);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:854:1: rule__DeclVal__Group__1__Impl : ( ( rule__DeclVal__NameAssignment_1 ) ) ;
    public final void rule__DeclVal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:858:1: ( ( ( rule__DeclVal__NameAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:859:1: ( ( rule__DeclVal__NameAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:859:1: ( ( rule__DeclVal__NameAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:860:1: ( rule__DeclVal__NameAssignment_1 )
            {
             before(grammarAccess.getDeclValAccess().getNameAssignment_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:861:1: ( rule__DeclVal__NameAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:861:2: rule__DeclVal__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__DeclVal__NameAssignment_1_in_rule__DeclVal__Group__1__Impl1701);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:871:1: rule__DeclVal__Group__2 : rule__DeclVal__Group__2__Impl ;
    public final void rule__DeclVal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:875:1: ( rule__DeclVal__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:876:2: rule__DeclVal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__2__Impl_in_rule__DeclVal__Group__21731);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:882:1: rule__DeclVal__Group__2__Impl : ( ( rule__DeclVal__AttrAssignment_2 )* ) ;
    public final void rule__DeclVal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:886:1: ( ( ( rule__DeclVal__AttrAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:887:1: ( ( rule__DeclVal__AttrAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:887:1: ( ( rule__DeclVal__AttrAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:888:1: ( rule__DeclVal__AttrAssignment_2 )*
            {
             before(grammarAccess.getDeclValAccess().getAttrAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:889:1: ( rule__DeclVal__AttrAssignment_2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:889:2: rule__DeclVal__AttrAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclVal__AttrAssignment_2_in_rule__DeclVal__Group__2__Impl1758);
            	    rule__DeclVal__AttrAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:905:1: rule__Export__Group__0 : rule__Export__Group__0__Impl rule__Export__Group__1 ;
    public final void rule__Export__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:909:1: ( rule__Export__Group__0__Impl rule__Export__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:910:2: rule__Export__Group__0__Impl rule__Export__Group__1
            {
            pushFollow(FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__01795);
            rule__Export__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group__1_in_rule__Export__Group__01798);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:917:1: rule__Export__Group__0__Impl : ( ( rule__Export__NameAssignment_0 ) ) ;
    public final void rule__Export__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:921:1: ( ( ( rule__Export__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:922:1: ( ( rule__Export__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:922:1: ( ( rule__Export__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:923:1: ( rule__Export__NameAssignment_0 )
            {
             before(grammarAccess.getExportAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:924:1: ( rule__Export__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:924:2: rule__Export__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl1825);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:934:1: rule__Export__Group__1 : rule__Export__Group__1__Impl ;
    public final void rule__Export__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:938:1: ( rule__Export__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:939:2: rule__Export__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__11855);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:945:1: rule__Export__Group__1__Impl : ( ( rule__Export__Group_1__0 )? ) ;
    public final void rule__Export__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:949:1: ( ( ( rule__Export__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:950:1: ( ( rule__Export__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:950:1: ( ( rule__Export__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:951:1: ( rule__Export__Group_1__0 )?
            {
             before(grammarAccess.getExportAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:952:1: ( rule__Export__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:952:2: rule__Export__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl1882);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:966:1: rule__Export__Group_1__0 : rule__Export__Group_1__0__Impl rule__Export__Group_1__1 ;
    public final void rule__Export__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:970:1: ( rule__Export__Group_1__0__Impl rule__Export__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:971:2: rule__Export__Group_1__0__Impl rule__Export__Group_1__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__01917);
            rule__Export__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__01920);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:978:1: rule__Export__Group_1__0__Impl : ( '{' ) ;
    public final void rule__Export__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:982:1: ( ( '{' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:983:1: ( '{' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:983:1: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:984:1: '{'
            {
             before(grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,15,FOLLOW_15_in_rule__Export__Group_1__0__Impl1948); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:997:1: rule__Export__Group_1__1 : rule__Export__Group_1__1__Impl rule__Export__Group_1__2 ;
    public final void rule__Export__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1001:1: ( rule__Export__Group_1__1__Impl rule__Export__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1002:2: rule__Export__Group_1__1__Impl rule__Export__Group_1__2
            {
            pushFollow(FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__11979);
            rule__Export__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__11982);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1009:1: rule__Export__Group_1__1__Impl : ( ( rule__Export__AttrNameAssignment_1_1 ) ) ;
    public final void rule__Export__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1013:1: ( ( ( rule__Export__AttrNameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1014:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1014:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1015:1: ( rule__Export__AttrNameAssignment_1_1 )
            {
             before(grammarAccess.getExportAccess().getAttrNameAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1016:1: ( rule__Export__AttrNameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1016:2: rule__Export__AttrNameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl2009);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1026:1: rule__Export__Group_1__2 : rule__Export__Group_1__2__Impl rule__Export__Group_1__3 ;
    public final void rule__Export__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1030:1: ( rule__Export__Group_1__2__Impl rule__Export__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1031:2: rule__Export__Group_1__2__Impl rule__Export__Group_1__3
            {
            pushFollow(FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__22039);
            rule__Export__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__22042);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1038:1: rule__Export__Group_1__2__Impl : ( ( rule__Export__Group_1_2__0 )* ) ;
    public final void rule__Export__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1042:1: ( ( ( rule__Export__Group_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1043:1: ( ( rule__Export__Group_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1043:1: ( ( rule__Export__Group_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1044:1: ( rule__Export__Group_1_2__0 )*
            {
             before(grammarAccess.getExportAccess().getGroup_1_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1045:1: ( rule__Export__Group_1_2__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1045:2: rule__Export__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl2069);
            	    rule__Export__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1055:1: rule__Export__Group_1__3 : rule__Export__Group_1__3__Impl ;
    public final void rule__Export__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1059:1: ( rule__Export__Group_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1060:2: rule__Export__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__32100);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1066:1: rule__Export__Group_1__3__Impl : ( '}' ) ;
    public final void rule__Export__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1070:1: ( ( '}' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1071:1: ( '}' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1071:1: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1072:1: '}'
            {
             before(grammarAccess.getExportAccess().getRightCurlyBracketKeyword_1_3()); 
            match(input,16,FOLLOW_16_in_rule__Export__Group_1__3__Impl2128); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1093:1: rule__Export__Group_1_2__0 : rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 ;
    public final void rule__Export__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1097:1: ( rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1098:2: rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__02167);
            rule__Export__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__02170);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1105:1: rule__Export__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__Export__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1109:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1110:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1110:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1111:1: ','
            {
             before(grammarAccess.getExportAccess().getCommaKeyword_1_2_0()); 
            match(input,17,FOLLOW_17_in_rule__Export__Group_1_2__0__Impl2198); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1124:1: rule__Export__Group_1_2__1 : rule__Export__Group_1_2__1__Impl ;
    public final void rule__Export__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1128:1: ( rule__Export__Group_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1129:2: rule__Export__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__12229);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1135:1: rule__Export__Group_1_2__1__Impl : ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) ;
    public final void rule__Export__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1139:1: ( ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1140:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1140:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1141:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            {
             before(grammarAccess.getExportAccess().getAttrNameAssignment_1_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1142:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1142:2: rule__Export__AttrNameAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl2256);
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


    // $ANTLR start "rule__Model__DeclAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1157:1: rule__Model__DeclAssignment_0 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1161:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1162:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1162:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1163:1: ruleDecl
            {
             before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_02295);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1172:1: rule__Model__DeclAssignment_1_1 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1176:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1177:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1177:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1178:1: ruleDecl
            {
             before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_12326);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1187:1: rule__DeclGranularity__NameAssignment_0 : ( ( 'granularity' ) ) ;
    public final void rule__DeclGranularity__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1191:1: ( ( ( 'granularity' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1192:1: ( ( 'granularity' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1192:1: ( ( 'granularity' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1193:1: ( 'granularity' )
            {
             before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1194:1: ( 'granularity' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1195:1: 'granularity'
            {
             before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            match(input,18,FOLLOW_18_in_rule__DeclGranularity__NameAssignment_02362); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1210:1: rule__DeclGranularity__GranularityAssignment_2 : ( ruleInteger ) ;
    public final void rule__DeclGranularity__GranularityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1214:1: ( ( ruleInteger ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1215:1: ( ruleInteger )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1215:1: ( ruleInteger )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1216:1: ruleInteger
            {
             before(grammarAccess.getDeclGranularityAccess().getGranularityIntegerParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__DeclGranularity__GranularityAssignment_22401);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getDeclGranularityAccess().getGranularityIntegerParserRuleCall_2_0()); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1225:1: rule__DeclExport__NameAssignment_0 : ( ( 'export' ) ) ;
    public final void rule__DeclExport__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1229:1: ( ( ( 'export' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1230:1: ( ( 'export' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1230:1: ( ( 'export' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1231:1: ( 'export' )
            {
             before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1232:1: ( 'export' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1233:1: 'export'
            {
             before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            match(input,19,FOLLOW_19_in_rule__DeclExport__NameAssignment_02437); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1248:1: rule__DeclExport__ExportsAssignment_2 : ( ruleExport ) ;
    public final void rule__DeclExport__ExportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1252:1: ( ( ruleExport ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1253:1: ( ruleExport )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1253:1: ( ruleExport )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1254:1: ruleExport
            {
             before(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_22476);
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


    // $ANTLR start "rule__DeclType__NameAssignment_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1263:1: rule__DeclType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DeclType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1267:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1268:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1268:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1269:1: RULE_ID
            {
             before(grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclType__NameAssignment_12507); 
             after(grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__DeclType__NameAssignment_1"


    // $ANTLR start "rule__DeclVal__NameAssignment_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1278:1: rule__DeclVal__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DeclVal__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1282:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1283:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1283:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1284:1: RULE_ID
            {
             before(grammarAccess.getDeclValAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclVal__NameAssignment_12538); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1293:1: rule__DeclVal__AttrAssignment_2 : ( RULE_ID ) ;
    public final void rule__DeclVal__AttrAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1297:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1298:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1298:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1299:1: RULE_ID
            {
             before(grammarAccess.getDeclValAccess().getAttrIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclVal__AttrAssignment_22569); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1308:1: rule__Export__NameAssignment_0 : ( ruleQid ) ;
    public final void rule__Export__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1312:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1313:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1313:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1314:1: ruleQid
            {
             before(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQid_in_rule__Export__NameAssignment_02600);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1323:1: rule__Export__AttrNameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Export__AttrNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1327:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1328:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1328:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1329:1: RULE_ID
            {
             before(grammarAccess.getExportAccess().getAttrNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Export__AttrNameAssignment_1_12631); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1338:1: rule__Export__AttrNameAssignment_1_2_1 : ( RULE_ID ) ;
    public final void rule__Export__AttrNameAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1342:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1343:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1343:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1344:1: RULE_ID
            {
             before(grammarAccess.getExportAccess().getAttrNameIDTerminalRuleCall_1_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Export__AttrNameAssignment_1_2_12662); 
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
    public static final BitSet FOLLOW_rule__DeclType__Group__0_in_ruleDeclType334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__0_in_ruleDeclVal394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__0_in_ruleExport454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Integer__Alternatives_in_ruleInteger514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQid574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_rule__Decl__Alternatives643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_POSINT_in_rule__Integer__Alternatives692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEGINT_in_rule__Integer__Alternatives709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0739 = new BitSet(new long[]{0x00000000000C5400L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl826 = new BitSet(new long[]{0x00000000000C5402L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__0861 = new BitSet(new long[]{0x00000000000C5400L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__Model__Group_1__0__Impl893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__0987 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__0990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__11047 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__11050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__DeclGranularity__Group__1__Impl1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__21109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__01172 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__01175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__11232 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__11235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__DeclExport__Group__1__Impl1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__21294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl1321 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__DeclType__Group__0__Impl_in_rule__DeclType__Group__01358 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclType__Group__1_in_rule__DeclType__Group__01361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__DeclType__Group__0__Impl1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__1__Impl_in_rule__DeclType__Group__11420 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__DeclType__Group__2_in_rule__DeclType__Group__11423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__NameAssignment_1_in_rule__DeclType__Group__1__Impl1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__2__Impl_in_rule__DeclType__Group__21480 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__DeclType__Group__3_in_rule__DeclType__Group__21483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__DeclType__Group__2__Impl1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__3__Impl_in_rule__DeclType__Group__31542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__DeclType__Group__3__Impl1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__0__Impl_in_rule__DeclVal__Group__01609 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__1_in_rule__DeclVal__Group__01612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DeclVal__Group__0__Impl1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__1__Impl_in_rule__DeclVal__Group__11671 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__2_in_rule__DeclVal__Group__11674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_1_in_rule__DeclVal__Group__1__Impl1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__2__Impl_in_rule__DeclVal__Group__21731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__AttrAssignment_2_in_rule__DeclVal__Group__2__Impl1758 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__01795 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Export__Group__1_in_rule__Export__Group__01798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__11855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__01917 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__01920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Export__Group_1__0__Impl1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__11979 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__11982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__22039 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__22042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl2069 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__32100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Export__Group_1__3__Impl2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__02167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__02170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Export__Group_1_2__0__Impl2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__12229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_02295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_12326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__DeclGranularity__NameAssignment_02362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__DeclGranularity__GranularityAssignment_22401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__DeclExport__NameAssignment_02437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_22476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclType__NameAssignment_12507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclVal__NameAssignment_12538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclVal__AttrAssignment_22569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__Export__NameAssignment_02600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Export__AttrNameAssignment_1_12631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Export__AttrNameAssignment_1_2_12662 = new BitSet(new long[]{0x0000000000000002L});

}