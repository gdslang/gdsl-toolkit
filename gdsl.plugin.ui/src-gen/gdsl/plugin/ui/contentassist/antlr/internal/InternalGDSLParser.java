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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'='", "'type'", "'val'", "'granularity'", "'export'", "'todo'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:237:1: ruleExport : ( ( rule__Export__NameAssignment ) ) ;
    public final void ruleExport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:241:2: ( ( ( rule__Export__NameAssignment ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:242:1: ( ( rule__Export__NameAssignment ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:242:1: ( ( rule__Export__NameAssignment ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:243:1: ( rule__Export__NameAssignment )
            {
             before(grammarAccess.getExportAccess().getNameAssignment()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:244:1: ( rule__Export__NameAssignment )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:244:2: rule__Export__NameAssignment
            {
            pushFollow(FOLLOW_rule__Export__NameAssignment_in_ruleExport454);
            rule__Export__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getExportAccess().getNameAssignment()); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:265:1: ruleInteger : ( RULE_INT ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:269:2: ( ( RULE_INT ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:270:1: ( RULE_INT )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:270:1: ( RULE_INT )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:271:1: RULE_INT
            {
             before(grammarAccess.getIntegerAccess().getINTTerminalRuleCall()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleInteger514); 
             after(grammarAccess.getIntegerAccess().getINTTerminalRuleCall()); 

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


    // $ANTLR start "rule__Decl__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:284:1: rule__Decl__Alternatives : ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) );
    public final void rule__Decl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:288:1: ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt1=1;
                }
                break;
            case 16:
                {
                alt1=2;
                }
                break;
            case 13:
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:289:1: ( ruleDeclGranularity )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:289:1: ( ruleDeclGranularity )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:290:1: ruleDeclGranularity
                    {
                     before(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives549);
                    ruleDeclGranularity();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:295:6: ( ruleDeclExport )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:295:6: ( ruleDeclExport )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:296:1: ruleDeclExport
                    {
                     before(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives566);
                    ruleDeclExport();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:301:6: ( ruleDeclType )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:301:6: ( ruleDeclType )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:302:1: ruleDeclType
                    {
                     before(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDeclType_in_rule__Decl__Alternatives583);
                    ruleDeclType();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:307:6: ( ruleDeclVal )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:307:6: ( ruleDeclVal )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:308:1: ruleDeclVal
                    {
                     before(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives600);
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


    // $ANTLR start "rule__Model__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:320:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:324:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:325:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0630);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0633);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:332:1: rule__Model__Group__0__Impl : ( ( rule__Model__DeclAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:336:1: ( ( ( rule__Model__DeclAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:337:1: ( ( rule__Model__DeclAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:337:1: ( ( rule__Model__DeclAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:338:1: ( rule__Model__DeclAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getDeclAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:339:1: ( rule__Model__DeclAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:339:2: rule__Model__DeclAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl660);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:349:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:353:1: ( rule__Model__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:354:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1690);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:360:1: rule__Model__Group__1__Impl : ( ( rule__Model__Group_1__0 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:364:1: ( ( ( rule__Model__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:365:1: ( ( rule__Model__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:365:1: ( ( rule__Model__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:366:1: ( rule__Model__Group_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:367:1: ( rule__Model__Group_1__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11||(LA2_0>=13 && LA2_0<=16)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:367:2: rule__Model__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl717);
            	    rule__Model__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:381:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:385:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:386:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__0752);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0755);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:393:1: rule__Model__Group_1__0__Impl : ( ( ';' )? ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:397:1: ( ( ( ';' )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:398:1: ( ( ';' )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:398:1: ( ( ';' )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:399:1: ( ';' )?
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_1_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:400:1: ( ';' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:401:2: ';'
                    {
                    match(input,11,FOLLOW_11_in_rule__Model__Group_1__0__Impl784); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:412:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:416:1: ( rule__Model__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:417:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__1817);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:423:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__DeclAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:427:1: ( ( ( rule__Model__DeclAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:428:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:428:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:429:1: ( rule__Model__DeclAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getDeclAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:430:1: ( rule__Model__DeclAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:430:2: rule__Model__DeclAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl844);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:444:1: rule__DeclGranularity__Group__0 : rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 ;
    public final void rule__DeclGranularity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:448:1: ( rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:449:2: rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__0878);
            rule__DeclGranularity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__0881);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:456:1: rule__DeclGranularity__Group__0__Impl : ( ( rule__DeclGranularity__NameAssignment_0 ) ) ;
    public final void rule__DeclGranularity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:460:1: ( ( ( rule__DeclGranularity__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:461:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:461:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:462:1: ( rule__DeclGranularity__NameAssignment_0 )
            {
             before(grammarAccess.getDeclGranularityAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:463:1: ( rule__DeclGranularity__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:463:2: rule__DeclGranularity__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl908);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:473:1: rule__DeclGranularity__Group__1 : rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 ;
    public final void rule__DeclGranularity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:477:1: ( rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:478:2: rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__1938);
            rule__DeclGranularity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__1941);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:485:1: rule__DeclGranularity__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclGranularity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:489:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:490:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:490:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:491:1: '='
            {
             before(grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__DeclGranularity__Group__1__Impl969); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:504:1: rule__DeclGranularity__Group__2 : rule__DeclGranularity__Group__2__Impl ;
    public final void rule__DeclGranularity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:508:1: ( rule__DeclGranularity__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:509:2: rule__DeclGranularity__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__21000);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:515:1: rule__DeclGranularity__Group__2__Impl : ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) ;
    public final void rule__DeclGranularity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:519:1: ( ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:520:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:520:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:521:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            {
             before(grammarAccess.getDeclGranularityAccess().getGranularityAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:522:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:522:2: rule__DeclGranularity__GranularityAssignment_2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl1027);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:538:1: rule__DeclExport__Group__0 : rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 ;
    public final void rule__DeclExport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:542:1: ( rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:543:2: rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__01063);
            rule__DeclExport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__01066);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:550:1: rule__DeclExport__Group__0__Impl : ( ( rule__DeclExport__NameAssignment_0 ) ) ;
    public final void rule__DeclExport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:554:1: ( ( ( rule__DeclExport__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:555:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:555:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:556:1: ( rule__DeclExport__NameAssignment_0 )
            {
             before(grammarAccess.getDeclExportAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:557:1: ( rule__DeclExport__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:557:2: rule__DeclExport__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl1093);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:567:1: rule__DeclExport__Group__1 : rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 ;
    public final void rule__DeclExport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:571:1: ( rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:572:2: rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__11123);
            rule__DeclExport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__11126);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:579:1: rule__DeclExport__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclExport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:583:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:584:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:584:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:585:1: '='
            {
             before(grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__DeclExport__Group__1__Impl1154); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:598:1: rule__DeclExport__Group__2 : rule__DeclExport__Group__2__Impl ;
    public final void rule__DeclExport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:602:1: ( rule__DeclExport__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:603:2: rule__DeclExport__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__21185);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:609:1: rule__DeclExport__Group__2__Impl : ( ( rule__DeclExport__ExportsAssignment_2 )* ) ;
    public final void rule__DeclExport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:613:1: ( ( ( rule__DeclExport__ExportsAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:614:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:614:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:615:1: ( rule__DeclExport__ExportsAssignment_2 )*
            {
             before(grammarAccess.getDeclExportAccess().getExportsAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:616:1: ( rule__DeclExport__ExportsAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:616:2: rule__DeclExport__ExportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl1212);
            	    rule__DeclExport__ExportsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:632:1: rule__DeclType__Group__0 : rule__DeclType__Group__0__Impl rule__DeclType__Group__1 ;
    public final void rule__DeclType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:636:1: ( rule__DeclType__Group__0__Impl rule__DeclType__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:637:2: rule__DeclType__Group__0__Impl rule__DeclType__Group__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group__0__Impl_in_rule__DeclType__Group__01249);
            rule__DeclType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group__1_in_rule__DeclType__Group__01252);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:644:1: rule__DeclType__Group__0__Impl : ( 'type' ) ;
    public final void rule__DeclType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:648:1: ( ( 'type' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:649:1: ( 'type' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:649:1: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:650:1: 'type'
            {
             before(grammarAccess.getDeclTypeAccess().getTypeKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__DeclType__Group__0__Impl1280); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:663:1: rule__DeclType__Group__1 : rule__DeclType__Group__1__Impl ;
    public final void rule__DeclType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:667:1: ( rule__DeclType__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:668:2: rule__DeclType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group__1__Impl_in_rule__DeclType__Group__11311);
            rule__DeclType__Group__1__Impl();

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:674:1: rule__DeclType__Group__1__Impl : ( ( rule__DeclType__NameAssignment_1 ) ) ;
    public final void rule__DeclType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:678:1: ( ( ( rule__DeclType__NameAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:679:1: ( ( rule__DeclType__NameAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:679:1: ( ( rule__DeclType__NameAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:680:1: ( rule__DeclType__NameAssignment_1 )
            {
             before(grammarAccess.getDeclTypeAccess().getNameAssignment_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:681:1: ( rule__DeclType__NameAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:681:2: rule__DeclType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__DeclType__NameAssignment_1_in_rule__DeclType__Group__1__Impl1338);
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


    // $ANTLR start "rule__DeclVal__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:695:1: rule__DeclVal__Group__0 : rule__DeclVal__Group__0__Impl rule__DeclVal__Group__1 ;
    public final void rule__DeclVal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:699:1: ( rule__DeclVal__Group__0__Impl rule__DeclVal__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:700:2: rule__DeclVal__Group__0__Impl rule__DeclVal__Group__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__0__Impl_in_rule__DeclVal__Group__01372);
            rule__DeclVal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group__1_in_rule__DeclVal__Group__01375);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:707:1: rule__DeclVal__Group__0__Impl : ( 'val' ) ;
    public final void rule__DeclVal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:711:1: ( ( 'val' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:712:1: ( 'val' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:712:1: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:713:1: 'val'
            {
             before(grammarAccess.getDeclValAccess().getValKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__DeclVal__Group__0__Impl1403); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:726:1: rule__DeclVal__Group__1 : rule__DeclVal__Group__1__Impl rule__DeclVal__Group__2 ;
    public final void rule__DeclVal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:730:1: ( rule__DeclVal__Group__1__Impl rule__DeclVal__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:731:2: rule__DeclVal__Group__1__Impl rule__DeclVal__Group__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__1__Impl_in_rule__DeclVal__Group__11434);
            rule__DeclVal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group__2_in_rule__DeclVal__Group__11437);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:738:1: rule__DeclVal__Group__1__Impl : ( ( rule__DeclVal__NameAssignment_1 ) ) ;
    public final void rule__DeclVal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:742:1: ( ( ( rule__DeclVal__NameAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:743:1: ( ( rule__DeclVal__NameAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:743:1: ( ( rule__DeclVal__NameAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:744:1: ( rule__DeclVal__NameAssignment_1 )
            {
             before(grammarAccess.getDeclValAccess().getNameAssignment_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:745:1: ( rule__DeclVal__NameAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:745:2: rule__DeclVal__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__DeclVal__NameAssignment_1_in_rule__DeclVal__Group__1__Impl1464);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:755:1: rule__DeclVal__Group__2 : rule__DeclVal__Group__2__Impl ;
    public final void rule__DeclVal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:759:1: ( rule__DeclVal__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:760:2: rule__DeclVal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group__2__Impl_in_rule__DeclVal__Group__21494);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:766:1: rule__DeclVal__Group__2__Impl : ( ( rule__DeclVal__AttrAssignment_2 )* ) ;
    public final void rule__DeclVal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:770:1: ( ( ( rule__DeclVal__AttrAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:771:1: ( ( rule__DeclVal__AttrAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:771:1: ( ( rule__DeclVal__AttrAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:772:1: ( rule__DeclVal__AttrAssignment_2 )*
            {
             before(grammarAccess.getDeclValAccess().getAttrAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:773:1: ( rule__DeclVal__AttrAssignment_2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:773:2: rule__DeclVal__AttrAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclVal__AttrAssignment_2_in_rule__DeclVal__Group__2__Impl1521);
            	    rule__DeclVal__AttrAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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


    // $ANTLR start "rule__Model__DeclAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:790:1: rule__Model__DeclAssignment_0 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:794:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:795:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:795:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:796:1: ruleDecl
            {
             before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_01563);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:805:1: rule__Model__DeclAssignment_1_1 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:809:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:810:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:810:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:811:1: ruleDecl
            {
             before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_11594);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:820:1: rule__DeclGranularity__NameAssignment_0 : ( ( 'granularity' ) ) ;
    public final void rule__DeclGranularity__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:824:1: ( ( ( 'granularity' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:825:1: ( ( 'granularity' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:825:1: ( ( 'granularity' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:826:1: ( 'granularity' )
            {
             before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:827:1: ( 'granularity' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:828:1: 'granularity'
            {
             before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            match(input,15,FOLLOW_15_in_rule__DeclGranularity__NameAssignment_01630); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:843:1: rule__DeclGranularity__GranularityAssignment_2 : ( ruleInteger ) ;
    public final void rule__DeclGranularity__GranularityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:847:1: ( ( ruleInteger ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:848:1: ( ruleInteger )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:848:1: ( ruleInteger )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:849:1: ruleInteger
            {
             before(grammarAccess.getDeclGranularityAccess().getGranularityIntegerParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInteger_in_rule__DeclGranularity__GranularityAssignment_21669);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:858:1: rule__DeclExport__NameAssignment_0 : ( ( 'export' ) ) ;
    public final void rule__DeclExport__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:862:1: ( ( ( 'export' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:863:1: ( ( 'export' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:863:1: ( ( 'export' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:864:1: ( 'export' )
            {
             before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:865:1: ( 'export' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:866:1: 'export'
            {
             before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            match(input,16,FOLLOW_16_in_rule__DeclExport__NameAssignment_01705); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:881:1: rule__DeclExport__ExportsAssignment_2 : ( ruleExport ) ;
    public final void rule__DeclExport__ExportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:885:1: ( ( ruleExport ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:886:1: ( ruleExport )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:886:1: ( ruleExport )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:887:1: ruleExport
            {
             before(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_21744);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:896:1: rule__DeclType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DeclType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:900:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:901:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:901:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:902:1: RULE_ID
            {
             before(grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclType__NameAssignment_11775); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:911:1: rule__DeclVal__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DeclVal__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:915:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:916:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:916:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:917:1: RULE_ID
            {
             before(grammarAccess.getDeclValAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclVal__NameAssignment_11806); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:926:1: rule__DeclVal__AttrAssignment_2 : ( RULE_ID ) ;
    public final void rule__DeclVal__AttrAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:930:1: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:931:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:931:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:932:1: RULE_ID
            {
             before(grammarAccess.getDeclValAccess().getAttrIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DeclVal__AttrAssignment_21837); 
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


    // $ANTLR start "rule__Export__NameAssignment"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:941:1: rule__Export__NameAssignment : ( ( 'todo' ) ) ;
    public final void rule__Export__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:945:1: ( ( ( 'todo' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:946:1: ( ( 'todo' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:946:1: ( ( 'todo' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:947:1: ( 'todo' )
            {
             before(grammarAccess.getExportAccess().getNameTodoKeyword_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:948:1: ( 'todo' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:949:1: 'todo'
            {
             before(grammarAccess.getExportAccess().getNameTodoKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Export__NameAssignment1873); 
             after(grammarAccess.getExportAccess().getNameTodoKeyword_0()); 

            }

             after(grammarAccess.getExportAccess().getNameTodoKeyword_0()); 

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
    // $ANTLR end "rule__Export__NameAssignment"

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
    public static final BitSet FOLLOW_rule__Export__NameAssignment_in_ruleExport454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleInteger514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_rule__Decl__Alternatives583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__0630 = new BitSet(new long[]{0x000000000001E800L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl717 = new BitSet(new long[]{0x000000000001E802L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__0752 = new BitSet(new long[]{0x000000000001E800L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Model__Group_1__0__Impl784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__0878 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__0881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__1938 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__DeclGranularity__Group__1__Impl969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__21000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__01063 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__01066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__11123 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__11126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__DeclExport__Group__1__Impl1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__21185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl1212 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__0__Impl_in_rule__DeclType__Group__01249 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclType__Group__1_in_rule__DeclType__Group__01252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__DeclType__Group__0__Impl1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__1__Impl_in_rule__DeclType__Group__11311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__NameAssignment_1_in_rule__DeclType__Group__1__Impl1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__0__Impl_in_rule__DeclVal__Group__01372 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__1_in_rule__DeclVal__Group__01375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__DeclVal__Group__0__Impl1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__1__Impl_in_rule__DeclVal__Group__11434 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__2_in_rule__DeclVal__Group__11437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_1_in_rule__DeclVal__Group__1__Impl1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group__2__Impl_in_rule__DeclVal__Group__21494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__AttrAssignment_2_in_rule__DeclVal__Group__2__Impl1521 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_01563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_11594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__DeclGranularity__NameAssignment_01630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_rule__DeclGranularity__GranularityAssignment_21669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__DeclExport__NameAssignment_01705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_21744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclType__NameAssignment_11775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclVal__NameAssignment_11806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DeclVal__AttrAssignment_21837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Export__NameAssignment1873 = new BitSet(new long[]{0x0000000000000002L});

}