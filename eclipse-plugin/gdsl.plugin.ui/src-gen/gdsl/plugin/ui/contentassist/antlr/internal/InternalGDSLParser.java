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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_DIG", "RULE_BINARY", "RULE_SYM", "RULE_HEXDIGIT", "RULE_CONSTART", "RULE_IDCHAR", "RULE_BITSTRIDCHAR", "RULE_BITSTRID", "RULE_ESC", "RULE_SGOOD", "RULE_LETTER", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'exptodo'", "';'", "'='", "'type'", "'['", "']'", "','", "'val'", "'|'", "'{'", "'}'", "'of'", "':'", "'\\''", "'@'", "'+'", "'~'", "'0x'", "'granularity'", "'export'"
    };
    public static final int RULE_DIG=5;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int RULE_BITSTRIDCHAR=11;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int RULE_SGOOD=14;
    public static final int T__22=22;
    public static final int RULE_BITSTRID=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_HEXDIGIT=8;
    public static final int RULE_SYM=7;
    public static final int RULE_ESC=13;
    public static final int RULE_SL_COMMENT=18;
    public static final int EOF=-1;
    public static final int RULE_LETTER=15;
    public static final int RULE_CONSTART=9;
    public static final int RULE_ML_COMMENT=17;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int RULE_IDCHAR=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_BINARY=6;
    public static final int RULE_WS=16;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:209:1: ruleDeclVal : ( ( rule__DeclVal__Alternatives ) ) ;
    public final void ruleDeclVal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:213:2: ( ( ( rule__DeclVal__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:214:1: ( ( rule__DeclVal__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:214:1: ( ( rule__DeclVal__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:215:1: ( rule__DeclVal__Alternatives )
            {
             before(grammarAccess.getDeclValAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:216:1: ( rule__DeclVal__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:216:2: rule__DeclVal__Alternatives
            {
            pushFollow(FOLLOW_rule__DeclVal__Alternatives_in_ruleDeclVal394);
            rule__DeclVal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getAlternatives()); 

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


    // $ANTLR start "entryRuleDecodePat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:396:1: entryRuleDecodePat : ruleDecodePat EOF ;
    public final void entryRuleDecodePat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:397:1: ( ruleDecodePat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:398:1: ruleDecodePat EOF
            {
             before(grammarAccess.getDecodePatRule()); 
            pushFollow(FOLLOW_ruleDecodePat_in_entryRuleDecodePat781);
            ruleDecodePat();

            state._fsp--;

             after(grammarAccess.getDecodePatRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecodePat788); 

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
    // $ANTLR end "entryRuleDecodePat"


    // $ANTLR start "ruleDecodePat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:405:1: ruleDecodePat : ( ( rule__DecodePat__Alternatives ) ) ;
    public final void ruleDecodePat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:409:2: ( ( ( rule__DecodePat__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:410:1: ( ( rule__DecodePat__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:410:1: ( ( rule__DecodePat__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:411:1: ( rule__DecodePat__Alternatives )
            {
             before(grammarAccess.getDecodePatAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:412:1: ( rule__DecodePat__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:412:2: rule__DecodePat__Alternatives
            {
            pushFollow(FOLLOW_rule__DecodePat__Alternatives_in_ruleDecodePat814);
            rule__DecodePat__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDecodePatAccess().getAlternatives()); 

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
    // $ANTLR end "ruleDecodePat"


    // $ANTLR start "entryRuleBitPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:424:1: entryRuleBitPat : ruleBitPat EOF ;
    public final void entryRuleBitPat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:425:1: ( ruleBitPat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:426:1: ruleBitPat EOF
            {
             before(grammarAccess.getBitPatRule()); 
            pushFollow(FOLLOW_ruleBitPat_in_entryRuleBitPat841);
            ruleBitPat();

            state._fsp--;

             after(grammarAccess.getBitPatRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPat848); 

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
    // $ANTLR end "entryRuleBitPat"


    // $ANTLR start "ruleBitPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:433:1: ruleBitPat : ( ( rule__BitPat__Group__0 ) ) ;
    public final void ruleBitPat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:437:2: ( ( ( rule__BitPat__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:438:1: ( ( rule__BitPat__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:438:1: ( ( rule__BitPat__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:439:1: ( rule__BitPat__Group__0 )
            {
             before(grammarAccess.getBitPatAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:440:1: ( rule__BitPat__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:440:2: rule__BitPat__Group__0
            {
            pushFollow(FOLLOW_rule__BitPat__Group__0_in_ruleBitPat874);
            rule__BitPat__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBitPatAccess().getGroup()); 

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
    // $ANTLR end "ruleBitPat"


    // $ANTLR start "entryRuleTokPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:452:1: entryRuleTokPat : ruleTokPat EOF ;
    public final void entryRuleTokPat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:453:1: ( ruleTokPat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:454:1: ruleTokPat EOF
            {
             before(grammarAccess.getTokPatRule()); 
            pushFollow(FOLLOW_ruleTokPat_in_entryRuleTokPat901);
            ruleTokPat();

            state._fsp--;

             after(grammarAccess.getTokPatRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTokPat908); 

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
    // $ANTLR end "entryRuleTokPat"


    // $ANTLR start "ruleTokPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:461:1: ruleTokPat : ( ( rule__TokPat__TokPatAssignment ) ) ;
    public final void ruleTokPat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:465:2: ( ( ( rule__TokPat__TokPatAssignment ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:466:1: ( ( rule__TokPat__TokPatAssignment ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:466:1: ( ( rule__TokPat__TokPatAssignment ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:467:1: ( rule__TokPat__TokPatAssignment )
            {
             before(grammarAccess.getTokPatAccess().getTokPatAssignment()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:468:1: ( rule__TokPat__TokPatAssignment )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:468:2: rule__TokPat__TokPatAssignment
            {
            pushFollow(FOLLOW_rule__TokPat__TokPatAssignment_in_ruleTokPat934);
            rule__TokPat__TokPatAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTokPatAccess().getTokPatAssignment()); 

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
    // $ANTLR end "ruleTokPat"


    // $ANTLR start "entryRulePrimBitPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:480:1: entryRulePrimBitPat : rulePrimBitPat EOF ;
    public final void entryRulePrimBitPat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:481:1: ( rulePrimBitPat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:482:1: rulePrimBitPat EOF
            {
             before(grammarAccess.getPrimBitPatRule()); 
            pushFollow(FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat961);
            rulePrimBitPat();

            state._fsp--;

             after(grammarAccess.getPrimBitPatRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimBitPat968); 

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
    // $ANTLR end "entryRulePrimBitPat"


    // $ANTLR start "rulePrimBitPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:489:1: rulePrimBitPat : ( ( rule__PrimBitPat__Alternatives ) ) ;
    public final void rulePrimBitPat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:493:2: ( ( ( rule__PrimBitPat__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:494:1: ( ( rule__PrimBitPat__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:494:1: ( ( rule__PrimBitPat__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:495:1: ( rule__PrimBitPat__Alternatives )
            {
             before(grammarAccess.getPrimBitPatAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:496:1: ( rule__PrimBitPat__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:496:2: rule__PrimBitPat__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimBitPat__Alternatives_in_rulePrimBitPat994);
            rule__PrimBitPat__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimBitPatAccess().getAlternatives()); 

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
    // $ANTLR end "rulePrimBitPat"


    // $ANTLR start "entryRuleBitPatOrInt"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:508:1: entryRuleBitPatOrInt : ruleBitPatOrInt EOF ;
    public final void entryRuleBitPatOrInt() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:509:1: ( ruleBitPatOrInt EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:510:1: ruleBitPatOrInt EOF
            {
             before(grammarAccess.getBitPatOrIntRule()); 
            pushFollow(FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt1021);
            ruleBitPatOrInt();

            state._fsp--;

             after(grammarAccess.getBitPatOrIntRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPatOrInt1028); 

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
    // $ANTLR end "entryRuleBitPatOrInt"


    // $ANTLR start "ruleBitPatOrInt"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:517:1: ruleBitPatOrInt : ( ( rule__BitPatOrInt__Alternatives ) ) ;
    public final void ruleBitPatOrInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:521:2: ( ( ( rule__BitPatOrInt__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:522:1: ( ( rule__BitPatOrInt__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:522:1: ( ( rule__BitPatOrInt__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:523:1: ( rule__BitPatOrInt__Alternatives )
            {
             before(grammarAccess.getBitPatOrIntAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:524:1: ( rule__BitPatOrInt__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:524:2: rule__BitPatOrInt__Alternatives
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Alternatives_in_ruleBitPatOrInt1054);
            rule__BitPatOrInt__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBitPatOrIntAccess().getAlternatives()); 

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
    // $ANTLR end "ruleBitPatOrInt"


    // $ANTLR start "entryRuleExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:536:1: entryRuleExp : ruleExp EOF ;
    public final void entryRuleExp() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:537:1: ( ruleExp EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:538:1: ruleExp EOF
            {
             before(grammarAccess.getExpRule()); 
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp1081);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getExpRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp1088); 

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
    // $ANTLR end "entryRuleExp"


    // $ANTLR start "ruleExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:545:1: ruleExp : ( 'exptodo' ) ;
    public final void ruleExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:549:2: ( ( 'exptodo' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:550:1: ( 'exptodo' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:550:1: ( 'exptodo' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:551:1: 'exptodo'
            {
             before(grammarAccess.getExpAccess().getExptodoKeyword()); 
            match(input,19,FOLLOW_19_in_ruleExp1115); 
             after(grammarAccess.getExpAccess().getExptodoKeyword()); 

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
    // $ANTLR end "ruleExp"


    // $ANTLR start "entryRuleInt"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:566:1: entryRuleInt : ruleInt EOF ;
    public final void entryRuleInt() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:567:1: ( ruleInt EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:568:1: ruleInt EOF
            {
             before(grammarAccess.getIntRule()); 
            pushFollow(FOLLOW_ruleInt_in_entryRuleInt1143);
            ruleInt();

            state._fsp--;

             after(grammarAccess.getIntRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInt1150); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:575:1: ruleInt : ( ( rule__Int__Alternatives ) ) ;
    public final void ruleInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:579:2: ( ( ( rule__Int__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:580:1: ( ( rule__Int__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:580:1: ( ( rule__Int__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:581:1: ( rule__Int__Alternatives )
            {
             before(grammarAccess.getIntAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:582:1: ( rule__Int__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:582:2: rule__Int__Alternatives
            {
            pushFollow(FOLLOW_rule__Int__Alternatives_in_ruleInt1176);
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


    // $ANTLR start "entryRuleName"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:594:1: entryRuleName : ruleName EOF ;
    public final void entryRuleName() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:595:1: ( ruleName EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:596:1: ruleName EOF
            {
             before(grammarAccess.getNameRule()); 
            pushFollow(FOLLOW_ruleName_in_entryRuleName1203);
            ruleName();

            state._fsp--;

             after(grammarAccess.getNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleName1210); 

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
    // $ANTLR end "entryRuleName"


    // $ANTLR start "ruleName"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:603:1: ruleName : ( RULE_ID ) ;
    public final void ruleName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:607:2: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:608:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:608:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:609:1: RULE_ID
            {
             before(grammarAccess.getNameAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleName1236); 
             after(grammarAccess.getNameAccess().getIDTerminalRuleCall()); 

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
    // $ANTLR end "ruleName"


    // $ANTLR start "entryRuleConBind"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:622:1: entryRuleConBind : ruleConBind EOF ;
    public final void entryRuleConBind() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:623:1: ( ruleConBind EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:624:1: ruleConBind EOF
            {
             before(grammarAccess.getConBindRule()); 
            pushFollow(FOLLOW_ruleConBind_in_entryRuleConBind1262);
            ruleConBind();

            state._fsp--;

             after(grammarAccess.getConBindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConBind1269); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:631:1: ruleConBind : ( ruleCONS ) ;
    public final void ruleConBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:635:2: ( ( ruleCONS ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:636:1: ( ruleCONS )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:636:1: ( ruleCONS )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:637:1: ruleCONS
            {
             before(grammarAccess.getConBindAccess().getCONSParserRuleCall()); 
            pushFollow(FOLLOW_ruleCONS_in_ruleConBind1295);
            ruleCONS();

            state._fsp--;

             after(grammarAccess.getConBindAccess().getCONSParserRuleCall()); 

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


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:652:1: entryRuleQid : ruleQid EOF ;
    public final void entryRuleQid() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:653:1: ( ruleQid EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:654:1: ruleQid EOF
            {
             before(grammarAccess.getQidRule()); 
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid1323);
            ruleQid();

            state._fsp--;

             after(grammarAccess.getQidRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid1330); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:661:1: ruleQid : ( RULE_ID ) ;
    public final void ruleQid() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:665:2: ( ( RULE_ID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:666:1: ( RULE_ID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:666:1: ( RULE_ID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:667:1: RULE_ID
            {
             before(grammarAccess.getQidAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQid1356); 
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


    // $ANTLR start "entryRulePOSINT"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:680:1: entryRulePOSINT : rulePOSINT EOF ;
    public final void entryRulePOSINT() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:681:1: ( rulePOSINT EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:682:1: rulePOSINT EOF
            {
             before(grammarAccess.getPOSINTRule()); 
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT1382);
            rulePOSINT();

            state._fsp--;

             after(grammarAccess.getPOSINTRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT1389); 

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
    // $ANTLR end "entryRulePOSINT"


    // $ANTLR start "rulePOSINT"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:689:1: rulePOSINT : ( ( rule__POSINT__Alternatives ) ) ;
    public final void rulePOSINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:693:2: ( ( ( rule__POSINT__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:694:1: ( ( rule__POSINT__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:694:1: ( ( rule__POSINT__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:695:1: ( rule__POSINT__Alternatives )
            {
             before(grammarAccess.getPOSINTAccess().getAlternatives()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:696:1: ( rule__POSINT__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:696:2: rule__POSINT__Alternatives
            {
            pushFollow(FOLLOW_rule__POSINT__Alternatives_in_rulePOSINT1415);
            rule__POSINT__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPOSINTAccess().getAlternatives()); 

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
    // $ANTLR end "rulePOSINT"


    // $ANTLR start "entryRuleNEGINT"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:708:1: entryRuleNEGINT : ruleNEGINT EOF ;
    public final void entryRuleNEGINT() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:709:1: ( ruleNEGINT EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:710:1: ruleNEGINT EOF
            {
             before(grammarAccess.getNEGINTRule()); 
            pushFollow(FOLLOW_ruleNEGINT_in_entryRuleNEGINT1442);
            ruleNEGINT();

            state._fsp--;

             after(grammarAccess.getNEGINTRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNEGINT1449); 

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
    // $ANTLR end "entryRuleNEGINT"


    // $ANTLR start "ruleNEGINT"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:717:1: ruleNEGINT : ( ( rule__NEGINT__Group__0 ) ) ;
    public final void ruleNEGINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:721:2: ( ( ( rule__NEGINT__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:722:1: ( ( rule__NEGINT__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:722:1: ( ( rule__NEGINT__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:723:1: ( rule__NEGINT__Group__0 )
            {
             before(grammarAccess.getNEGINTAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:724:1: ( rule__NEGINT__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:724:2: rule__NEGINT__Group__0
            {
            pushFollow(FOLLOW_rule__NEGINT__Group__0_in_ruleNEGINT1475);
            rule__NEGINT__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNEGINTAccess().getGroup()); 

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
    // $ANTLR end "ruleNEGINT"


    // $ANTLR start "entryRuleNUM"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:736:1: entryRuleNUM : ruleNUM EOF ;
    public final void entryRuleNUM() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:737:1: ( ruleNUM EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:738:1: ruleNUM EOF
            {
             before(grammarAccess.getNUMRule()); 
            pushFollow(FOLLOW_ruleNUM_in_entryRuleNUM1502);
            ruleNUM();

            state._fsp--;

             after(grammarAccess.getNUMRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUM1509); 

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
    // $ANTLR end "entryRuleNUM"


    // $ANTLR start "ruleNUM"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:745:1: ruleNUM : ( ( ( RULE_DIG ) ) ( ( RULE_DIG )* ) ) ;
    public final void ruleNUM() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:749:2: ( ( ( ( RULE_DIG ) ) ( ( RULE_DIG )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:750:1: ( ( ( RULE_DIG ) ) ( ( RULE_DIG )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:750:1: ( ( ( RULE_DIG ) ) ( ( RULE_DIG )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:751:1: ( ( RULE_DIG ) ) ( ( RULE_DIG )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:751:1: ( ( RULE_DIG ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:752:1: ( RULE_DIG )
            {
             before(grammarAccess.getNUMAccess().getDIGTerminalRuleCall()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:753:1: ( RULE_DIG )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:753:3: RULE_DIG
            {
            match(input,RULE_DIG,FOLLOW_RULE_DIG_in_ruleNUM1538); 

            }

             after(grammarAccess.getNUMAccess().getDIGTerminalRuleCall()); 

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:756:1: ( ( RULE_DIG )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:757:1: ( RULE_DIG )*
            {
             before(grammarAccess.getNUMAccess().getDIGTerminalRuleCall()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:758:1: ( RULE_DIG )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_DIG) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:758:3: RULE_DIG
            	    {
            	    match(input,RULE_DIG,FOLLOW_RULE_DIG_in_ruleNUM1551); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getNUMAccess().getDIGTerminalRuleCall()); 

            }


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
    // $ANTLR end "ruleNUM"


    // $ANTLR start "entryRuleHEXNUM"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:771:1: entryRuleHEXNUM : ruleHEXNUM EOF ;
    public final void entryRuleHEXNUM() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:772:1: ( ruleHEXNUM EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:773:1: ruleHEXNUM EOF
            {
             before(grammarAccess.getHEXNUMRule()); 
            pushFollow(FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM1581);
            ruleHEXNUM();

            state._fsp--;

             after(grammarAccess.getHEXNUMRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXNUM1588); 

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
    // $ANTLR end "entryRuleHEXNUM"


    // $ANTLR start "ruleHEXNUM"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:780:1: ruleHEXNUM : ( ( rule__HEXNUM__Group__0 ) ) ;
    public final void ruleHEXNUM() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:784:2: ( ( ( rule__HEXNUM__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:785:1: ( ( rule__HEXNUM__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:785:1: ( ( rule__HEXNUM__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:786:1: ( rule__HEXNUM__Group__0 )
            {
             before(grammarAccess.getHEXNUMAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:787:1: ( rule__HEXNUM__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:787:2: rule__HEXNUM__Group__0
            {
            pushFollow(FOLLOW_rule__HEXNUM__Group__0_in_ruleHEXNUM1614);
            rule__HEXNUM__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHEXNUMAccess().getGroup()); 

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
    // $ANTLR end "ruleHEXNUM"


    // $ANTLR start "entryRuleBITSTR"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:801:1: entryRuleBITSTR : ruleBITSTR EOF ;
    public final void entryRuleBITSTR() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:802:1: ( ruleBITSTR EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:803:1: ruleBITSTR EOF
            {
             before(grammarAccess.getBITSTRRule()); 
            pushFollow(FOLLOW_ruleBITSTR_in_entryRuleBITSTR1643);
            ruleBITSTR();

            state._fsp--;

             after(grammarAccess.getBITSTRRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITSTR1650); 

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
    // $ANTLR end "entryRuleBITSTR"


    // $ANTLR start "ruleBITSTR"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:810:1: ruleBITSTR : ( ( ( RULE_BINARY ) ) ( ( RULE_BINARY )* ) ) ;
    public final void ruleBITSTR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:814:2: ( ( ( ( RULE_BINARY ) ) ( ( RULE_BINARY )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:815:1: ( ( ( RULE_BINARY ) ) ( ( RULE_BINARY )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:815:1: ( ( ( RULE_BINARY ) ) ( ( RULE_BINARY )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:816:1: ( ( RULE_BINARY ) ) ( ( RULE_BINARY )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:816:1: ( ( RULE_BINARY ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:817:1: ( RULE_BINARY )
            {
             before(grammarAccess.getBITSTRAccess().getBINARYTerminalRuleCall()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:818:1: ( RULE_BINARY )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:818:3: RULE_BINARY
            {
            match(input,RULE_BINARY,FOLLOW_RULE_BINARY_in_ruleBITSTR1679); 

            }

             after(grammarAccess.getBITSTRAccess().getBINARYTerminalRuleCall()); 

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:821:1: ( ( RULE_BINARY )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:822:1: ( RULE_BINARY )*
            {
             before(grammarAccess.getBITSTRAccess().getBINARYTerminalRuleCall()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:823:1: ( RULE_BINARY )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_BINARY) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:823:3: RULE_BINARY
            	    {
            	    match(input,RULE_BINARY,FOLLOW_RULE_BINARY_in_ruleBITSTR1692); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getBITSTRAccess().getBINARYTerminalRuleCall()); 

            }


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
    // $ANTLR end "ruleBITSTR"


    // $ANTLR start "entryRuleCONS"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:838:1: entryRuleCONS : ruleCONS EOF ;
    public final void entryRuleCONS() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:839:1: ( ruleCONS EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:840:1: ruleCONS EOF
            {
             before(grammarAccess.getCONSRule()); 
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS1724);
            ruleCONS();

            state._fsp--;

             after(grammarAccess.getCONSRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS1731); 

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
    // $ANTLR end "entryRuleCONS"


    // $ANTLR start "ruleCONS"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:847:1: ruleCONS : ( ( rule__CONS__Group__0 ) ) ;
    public final void ruleCONS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:851:2: ( ( ( rule__CONS__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:852:1: ( ( rule__CONS__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:852:1: ( ( rule__CONS__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:853:1: ( rule__CONS__Group__0 )
            {
             before(grammarAccess.getCONSAccess().getGroup()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:854:1: ( rule__CONS__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:854:2: rule__CONS__Group__0
            {
            pushFollow(FOLLOW_rule__CONS__Group__0_in_ruleCONS1757);
            rule__CONS__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCONSAccess().getGroup()); 

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
    // $ANTLR end "ruleCONS"


    // $ANTLR start "rule__Decl__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:866:1: rule__Decl__Alternatives : ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) );
    public final void rule__Decl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:870:1: ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt3=1;
                }
                break;
            case 38:
                {
                alt3=2;
                }
                break;
            case 22:
                {
                alt3=3;
                }
                break;
            case 26:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:871:1: ( ruleDeclGranularity )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:871:1: ( ruleDeclGranularity )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:872:1: ruleDeclGranularity
                    {
                     before(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives1793);
                    ruleDeclGranularity();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:877:6: ( ruleDeclExport )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:877:6: ( ruleDeclExport )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:878:1: ruleDeclExport
                    {
                     before(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives1810);
                    ruleDeclExport();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:883:6: ( ruleDeclType )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:883:6: ( ruleDeclType )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:884:1: ruleDeclType
                    {
                     before(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDeclType_in_rule__Decl__Alternatives1827);
                    ruleDeclType();

                    state._fsp--;

                     after(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:889:6: ( ruleDeclVal )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:889:6: ( ruleDeclVal )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:890:1: ruleDeclVal
                    {
                     before(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives1844);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:900:1: rule__DeclType__Alternatives : ( ( ( rule__DeclType__Group_0__0 ) ) | ( ( rule__DeclType__Group_1__0 ) ) );
    public final void rule__DeclType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:904:1: ( ( ( rule__DeclType__Group_0__0 ) ) | ( ( rule__DeclType__Group_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==22) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==RULE_ID) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==23) ) {
                        alt4=2;
                    }
                    else if ( (LA4_2==21) ) {
                        alt4=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:905:1: ( ( rule__DeclType__Group_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:905:1: ( ( rule__DeclType__Group_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:906:1: ( rule__DeclType__Group_0__0 )
                    {
                     before(grammarAccess.getDeclTypeAccess().getGroup_0()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:907:1: ( rule__DeclType__Group_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:907:2: rule__DeclType__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Group_0__0_in_rule__DeclType__Alternatives1876);
                    rule__DeclType__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDeclTypeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:911:6: ( ( rule__DeclType__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:911:6: ( ( rule__DeclType__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:912:1: ( rule__DeclType__Group_1__0 )
                    {
                     before(grammarAccess.getDeclTypeAccess().getGroup_1()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:913:1: ( rule__DeclType__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:913:2: rule__DeclType__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Group_1__0_in_rule__DeclType__Alternatives1894);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:922:1: rule__DeclType__ValueAlternatives_0_3_0 : ( ( ruleConDecls ) | ( ruleTy ) );
    public final void rule__DeclType__ValueAlternatives_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:926:1: ( ( ruleConDecls ) | ( ruleTy ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_CONSTART) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID||(LA5_0>=27 && LA5_0<=28)||(LA5_0>=34 && LA5_0<=36)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:927:1: ( ruleConDecls )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:927:1: ( ruleConDecls )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:928:1: ruleConDecls
                    {
                     before(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_0_3_0_0()); 
                    pushFollow(FOLLOW_ruleConDecls_in_rule__DeclType__ValueAlternatives_0_3_01927);
                    ruleConDecls();

                    state._fsp--;

                     after(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_0_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:933:6: ( ruleTy )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:933:6: ( ruleTy )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:934:1: ruleTy
                    {
                     before(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_0_3_0_1()); 
                    pushFollow(FOLLOW_ruleTy_in_rule__DeclType__ValueAlternatives_0_3_01944);
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


    // $ANTLR start "rule__DeclVal__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:944:1: rule__DeclVal__Alternatives : ( ( ( rule__DeclVal__Group_0__0 ) ) | ( ( rule__DeclVal__Group_1__0 ) ) );
    public final void rule__DeclVal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:948:1: ( ( ( rule__DeclVal__Group_0__0 ) ) | ( ( rule__DeclVal__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_ID) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==23) ) {
                        alt6=2;
                    }
                    else if ( (LA6_2==RULE_ID||LA6_2==21) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_1==RULE_SYM) ) {
                    alt6=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:949:1: ( ( rule__DeclVal__Group_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:949:1: ( ( rule__DeclVal__Group_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:950:1: ( rule__DeclVal__Group_0__0 )
                    {
                     before(grammarAccess.getDeclValAccess().getGroup_0()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:951:1: ( rule__DeclVal__Group_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:951:2: rule__DeclVal__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_0__0_in_rule__DeclVal__Alternatives1976);
                    rule__DeclVal__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDeclValAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:955:6: ( ( rule__DeclVal__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:955:6: ( ( rule__DeclVal__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:956:1: ( rule__DeclVal__Group_1__0 )
                    {
                     before(grammarAccess.getDeclValAccess().getGroup_1()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:957:1: ( rule__DeclVal__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:957:2: rule__DeclVal__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1__0_in_rule__DeclVal__Alternatives1994);
                    rule__DeclVal__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDeclValAccess().getGroup_1()); 

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
    // $ANTLR end "rule__DeclVal__Alternatives"


    // $ANTLR start "rule__DeclVal__NameAlternatives_0_1_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:966:1: rule__DeclVal__NameAlternatives_0_1_0 : ( ( ruleName ) | ( RULE_SYM ) );
    public final void rule__DeclVal__NameAlternatives_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:970:1: ( ( ruleName ) | ( RULE_SYM ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_SYM) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:971:1: ( ruleName )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:971:1: ( ruleName )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:972:1: ruleName
                    {
                     before(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_0_1_0_0()); 
                    pushFollow(FOLLOW_ruleName_in_rule__DeclVal__NameAlternatives_0_1_02027);
                    ruleName();

                    state._fsp--;

                     after(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_0_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:977:6: ( RULE_SYM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:977:6: ( RULE_SYM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:978:1: RULE_SYM
                    {
                     before(grammarAccess.getDeclValAccess().getNameSYMTerminalRuleCall_0_1_0_1()); 
                    match(input,RULE_SYM,FOLLOW_RULE_SYM_in_rule__DeclVal__NameAlternatives_0_1_02044); 
                     after(grammarAccess.getDeclValAccess().getNameSYMTerminalRuleCall_0_1_0_1()); 

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
    // $ANTLR end "rule__DeclVal__NameAlternatives_0_1_0"


    // $ANTLR start "rule__DeclVal__Alternatives_1_5"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:988:1: rule__DeclVal__Alternatives_1_5 : ( ( ( rule__DeclVal__Group_1_5_0__0 ) ) | ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) ) );
    public final void rule__DeclVal__Alternatives_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:992:1: ( ( ( rule__DeclVal__Group_1_5_0__0 ) ) | ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            else if ( (LA9_0==27) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:993:1: ( ( rule__DeclVal__Group_1_5_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:993:1: ( ( rule__DeclVal__Group_1_5_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:994:1: ( rule__DeclVal__Group_1_5_0__0 )
                    {
                     before(grammarAccess.getDeclValAccess().getGroup_1_5_0()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:995:1: ( rule__DeclVal__Group_1_5_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:995:2: rule__DeclVal__Group_1_5_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__0_in_rule__DeclVal__Alternatives_1_52076);
                    rule__DeclVal__Group_1_5_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDeclValAccess().getGroup_1_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:999:6: ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:999:6: ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1000:1: ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1000:1: ( ( rule__DeclVal__Group_1_5_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1001:1: ( rule__DeclVal__Group_1_5_1__0 )
                    {
                     before(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1002:1: ( rule__DeclVal__Group_1_5_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1002:2: rule__DeclVal__Group_1_5_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_52096);
                    rule__DeclVal__Group_1_5_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 

                    }

                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1005:1: ( ( rule__DeclVal__Group_1_5_1__0 )* )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1006:1: ( rule__DeclVal__Group_1_5_1__0 )*
                    {
                     before(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1007:1: ( rule__DeclVal__Group_1_5_1__0 )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==27) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1007:2: rule__DeclVal__Group_1_5_1__0
                    	    {
                    	    pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_52108);
                    	    rule__DeclVal__Group_1_5_1__0();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                     after(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 

                    }


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
    // $ANTLR end "rule__DeclVal__Alternatives_1_5"


    // $ANTLR start "rule__Ty__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1017:1: rule__Ty__Alternatives : ( ( ( rule__Ty__ValueAssignment_0 ) ) | ( ( rule__Ty__Group_1__0 ) ) | ( ( rule__Ty__Group_2__0 ) ) | ( ( rule__Ty__Group_3__0 ) ) );
    public final void rule__Ty__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1021:1: ( ( ( rule__Ty__ValueAssignment_0 ) ) | ( ( rule__Ty__Group_1__0 ) ) | ( ( rule__Ty__Group_2__0 ) ) | ( ( rule__Ty__Group_3__0 ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 34:
            case 35:
            case 36:
                {
                alt10=1;
                }
                break;
            case 27:
                {
                alt10=2;
                }
                break;
            case RULE_ID:
                {
                alt10=3;
                }
                break;
            case 28:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1022:1: ( ( rule__Ty__ValueAssignment_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1022:1: ( ( rule__Ty__ValueAssignment_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1023:1: ( rule__Ty__ValueAssignment_0 )
                    {
                     before(grammarAccess.getTyAccess().getValueAssignment_0()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1024:1: ( rule__Ty__ValueAssignment_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1024:2: rule__Ty__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Ty__ValueAssignment_0_in_rule__Ty__Alternatives2144);
                    rule__Ty__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTyAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1028:6: ( ( rule__Ty__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1028:6: ( ( rule__Ty__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1029:1: ( rule__Ty__Group_1__0 )
                    {
                     before(grammarAccess.getTyAccess().getGroup_1()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1030:1: ( rule__Ty__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1030:2: rule__Ty__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_1__0_in_rule__Ty__Alternatives2162);
                    rule__Ty__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTyAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1034:6: ( ( rule__Ty__Group_2__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1034:6: ( ( rule__Ty__Group_2__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1035:1: ( rule__Ty__Group_2__0 )
                    {
                     before(grammarAccess.getTyAccess().getGroup_2()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1036:1: ( rule__Ty__Group_2__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1036:2: rule__Ty__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_2__0_in_rule__Ty__Alternatives2180);
                    rule__Ty__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTyAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1040:6: ( ( rule__Ty__Group_3__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1040:6: ( ( rule__Ty__Group_3__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1041:1: ( rule__Ty__Group_3__0 )
                    {
                     before(grammarAccess.getTyAccess().getGroup_3()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1042:1: ( rule__Ty__Group_3__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1042:2: rule__Ty__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_3__0_in_rule__Ty__Alternatives2198);
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


    // $ANTLR start "rule__DecodePat__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1051:1: rule__DecodePat__Alternatives : ( ( ruleBitPat ) | ( ruleTokPat ) );
    public final void rule__DecodePat__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1055:1: ( ( ruleBitPat ) | ( ruleTokPat ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==32) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID||(LA11_0>=34 && LA11_0<=36)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1056:1: ( ruleBitPat )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1056:1: ( ruleBitPat )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1057:1: ruleBitPat
                    {
                     before(grammarAccess.getDecodePatAccess().getBitPatParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBitPat_in_rule__DecodePat__Alternatives2231);
                    ruleBitPat();

                    state._fsp--;

                     after(grammarAccess.getDecodePatAccess().getBitPatParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1062:6: ( ruleTokPat )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1062:6: ( ruleTokPat )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1063:1: ruleTokPat
                    {
                     before(grammarAccess.getDecodePatAccess().getTokPatParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTokPat_in_rule__DecodePat__Alternatives2248);
                    ruleTokPat();

                    state._fsp--;

                     after(grammarAccess.getDecodePatAccess().getTokPatParserRuleCall_1()); 

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
    // $ANTLR end "rule__DecodePat__Alternatives"


    // $ANTLR start "rule__TokPat__TokPatAlternatives_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1073:1: rule__TokPat__TokPatAlternatives_0 : ( ( ruleInt ) | ( ruleQid ) );
    public final void rule__TokPat__TokPatAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1077:1: ( ( ruleInt ) | ( ruleQid ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=34 && LA12_0<=36)) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1078:1: ( ruleInt )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1078:1: ( ruleInt )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1079:1: ruleInt
                    {
                     before(grammarAccess.getTokPatAccess().getTokPatIntParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_ruleInt_in_rule__TokPat__TokPatAlternatives_02280);
                    ruleInt();

                    state._fsp--;

                     after(grammarAccess.getTokPatAccess().getTokPatIntParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1084:6: ( ruleQid )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1084:6: ( ruleQid )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1085:1: ruleQid
                    {
                     before(grammarAccess.getTokPatAccess().getTokPatQidParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_ruleQid_in_rule__TokPat__TokPatAlternatives_02297);
                    ruleQid();

                    state._fsp--;

                     after(grammarAccess.getTokPatAccess().getTokPatQidParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__TokPat__TokPatAlternatives_0"


    // $ANTLR start "rule__PrimBitPat__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1095:1: rule__PrimBitPat__Alternatives : ( ( ruleBITSTR ) | ( ( rule__PrimBitPat__Group_1__0 ) ) );
    public final void rule__PrimBitPat__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1099:1: ( ( ruleBITSTR ) | ( ( rule__PrimBitPat__Group_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_BINARY) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1100:1: ( ruleBITSTR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1100:1: ( ruleBITSTR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1101:1: ruleBITSTR
                    {
                     before(grammarAccess.getPrimBitPatAccess().getBITSTRParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBITSTR_in_rule__PrimBitPat__Alternatives2329);
                    ruleBITSTR();

                    state._fsp--;

                     after(grammarAccess.getPrimBitPatAccess().getBITSTRParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1106:6: ( ( rule__PrimBitPat__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1106:6: ( ( rule__PrimBitPat__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1107:1: ( rule__PrimBitPat__Group_1__0 )
                    {
                     before(grammarAccess.getPrimBitPatAccess().getGroup_1()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1108:1: ( rule__PrimBitPat__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1108:2: rule__PrimBitPat__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimBitPat__Group_1__0_in_rule__PrimBitPat__Alternatives2346);
                    rule__PrimBitPat__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimBitPatAccess().getGroup_1()); 

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
    // $ANTLR end "rule__PrimBitPat__Alternatives"


    // $ANTLR start "rule__BitPatOrInt__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1117:1: rule__BitPatOrInt__Alternatives : ( ( ( rule__BitPatOrInt__Group_0__0 ) ) | ( ( rule__BitPatOrInt__Group_1__0 ) ) );
    public final void rule__BitPatOrInt__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1121:1: ( ( ( rule__BitPatOrInt__Group_0__0 ) ) | ( ( rule__BitPatOrInt__Group_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==31) ) {
                alt14=1;
            }
            else if ( (LA14_0==33) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1122:1: ( ( rule__BitPatOrInt__Group_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1122:1: ( ( rule__BitPatOrInt__Group_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1123:1: ( rule__BitPatOrInt__Group_0__0 )
                    {
                     before(grammarAccess.getBitPatOrIntAccess().getGroup_0()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1124:1: ( rule__BitPatOrInt__Group_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1124:2: rule__BitPatOrInt__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__0_in_rule__BitPatOrInt__Alternatives2379);
                    rule__BitPatOrInt__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBitPatOrIntAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1128:6: ( ( rule__BitPatOrInt__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1128:6: ( ( rule__BitPatOrInt__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1129:1: ( rule__BitPatOrInt__Group_1__0 )
                    {
                     before(grammarAccess.getBitPatOrIntAccess().getGroup_1()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1130:1: ( rule__BitPatOrInt__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1130:2: rule__BitPatOrInt__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__0_in_rule__BitPatOrInt__Alternatives2397);
                    rule__BitPatOrInt__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBitPatOrIntAccess().getGroup_1()); 

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
    // $ANTLR end "rule__BitPatOrInt__Alternatives"


    // $ANTLR start "rule__Int__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1139:1: rule__Int__Alternatives : ( ( rulePOSINT ) | ( ruleNEGINT ) );
    public final void rule__Int__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1143:1: ( ( rulePOSINT ) | ( ruleNEGINT ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34||LA15_0==36) ) {
                alt15=1;
            }
            else if ( (LA15_0==35) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1144:1: ( rulePOSINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1144:1: ( rulePOSINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1145:1: rulePOSINT
                    {
                     before(grammarAccess.getIntAccess().getPOSINTParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePOSINT_in_rule__Int__Alternatives2430);
                    rulePOSINT();

                    state._fsp--;

                     after(grammarAccess.getIntAccess().getPOSINTParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1150:6: ( ruleNEGINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1150:6: ( ruleNEGINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1151:1: ruleNEGINT
                    {
                     before(grammarAccess.getIntAccess().getNEGINTParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNEGINT_in_rule__Int__Alternatives2447);
                    ruleNEGINT();

                    state._fsp--;

                     after(grammarAccess.getIntAccess().getNEGINTParserRuleCall_1()); 

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


    // $ANTLR start "rule__POSINT__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1161:1: rule__POSINT__Alternatives : ( ( ( rule__POSINT__Group_0__0 ) ) | ( ruleHEXNUM ) );
    public final void rule__POSINT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1165:1: ( ( ( rule__POSINT__Group_0__0 ) ) | ( ruleHEXNUM ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==34) ) {
                alt16=1;
            }
            else if ( (LA16_0==36) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1166:1: ( ( rule__POSINT__Group_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1166:1: ( ( rule__POSINT__Group_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1167:1: ( rule__POSINT__Group_0__0 )
                    {
                     before(grammarAccess.getPOSINTAccess().getGroup_0()); 
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1168:1: ( rule__POSINT__Group_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1168:2: rule__POSINT__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__POSINT__Group_0__0_in_rule__POSINT__Alternatives2479);
                    rule__POSINT__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPOSINTAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1172:6: ( ruleHEXNUM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1172:6: ( ruleHEXNUM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1173:1: ruleHEXNUM
                    {
                     before(grammarAccess.getPOSINTAccess().getHEXNUMParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleHEXNUM_in_rule__POSINT__Alternatives2497);
                    ruleHEXNUM();

                    state._fsp--;

                     after(grammarAccess.getPOSINTAccess().getHEXNUMParserRuleCall_1()); 

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
    // $ANTLR end "rule__POSINT__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1185:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1189:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1190:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02527);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02530);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1197:1: rule__Model__Group__0__Impl : ( ( rule__Model__DeclAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1201:1: ( ( ( rule__Model__DeclAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1202:1: ( ( rule__Model__DeclAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1202:1: ( ( rule__Model__DeclAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1203:1: ( rule__Model__DeclAssignment_0 )
            {
             before(grammarAccess.getModelAccess().getDeclAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1204:1: ( rule__Model__DeclAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1204:2: rule__Model__DeclAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl2557);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1214:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1218:1: ( rule__Model__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1219:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12587);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1225:1: rule__Model__Group__1__Impl : ( ( rule__Model__Group_1__0 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1229:1: ( ( ( rule__Model__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1230:1: ( ( rule__Model__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1230:1: ( ( rule__Model__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1231:1: ( rule__Model__Group_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1232:1: ( rule__Model__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==20||LA17_0==22||LA17_0==26||(LA17_0>=37 && LA17_0<=38)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1232:2: rule__Model__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl2614);
            	    rule__Model__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1246:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1250:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1251:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__02649);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__02652);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1258:1: rule__Model__Group_1__0__Impl : ( ( ';' )? ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1262:1: ( ( ( ';' )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1263:1: ( ( ';' )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1263:1: ( ( ';' )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1264:1: ( ';' )?
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_1_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1265:1: ( ';' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==20) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1266:2: ';'
                    {
                    match(input,20,FOLLOW_20_in_rule__Model__Group_1__0__Impl2681); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1277:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1281:1: ( rule__Model__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1282:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__12714);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1288:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__DeclAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1292:1: ( ( ( rule__Model__DeclAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1293:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1293:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1294:1: ( rule__Model__DeclAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getDeclAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1295:1: ( rule__Model__DeclAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1295:2: rule__Model__DeclAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl2741);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1309:1: rule__DeclGranularity__Group__0 : rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 ;
    public final void rule__DeclGranularity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1313:1: ( rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1314:2: rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__02775);
            rule__DeclGranularity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__02778);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1321:1: rule__DeclGranularity__Group__0__Impl : ( ( rule__DeclGranularity__NameAssignment_0 ) ) ;
    public final void rule__DeclGranularity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1325:1: ( ( ( rule__DeclGranularity__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1326:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1326:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1327:1: ( rule__DeclGranularity__NameAssignment_0 )
            {
             before(grammarAccess.getDeclGranularityAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1328:1: ( rule__DeclGranularity__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1328:2: rule__DeclGranularity__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl2805);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1338:1: rule__DeclGranularity__Group__1 : rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 ;
    public final void rule__DeclGranularity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1342:1: ( rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1343:2: rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__12835);
            rule__DeclGranularity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__12838);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1350:1: rule__DeclGranularity__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclGranularity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1354:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1355:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1355:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1356:1: '='
            {
             before(grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__DeclGranularity__Group__1__Impl2866); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1369:1: rule__DeclGranularity__Group__2 : rule__DeclGranularity__Group__2__Impl ;
    public final void rule__DeclGranularity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1373:1: ( rule__DeclGranularity__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1374:2: rule__DeclGranularity__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__22897);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1380:1: rule__DeclGranularity__Group__2__Impl : ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) ;
    public final void rule__DeclGranularity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1384:1: ( ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1385:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1385:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1386:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            {
             before(grammarAccess.getDeclGranularityAccess().getGranularityAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1387:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1387:2: rule__DeclGranularity__GranularityAssignment_2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl2924);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1403:1: rule__DeclExport__Group__0 : rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 ;
    public final void rule__DeclExport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1407:1: ( rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1408:2: rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__02960);
            rule__DeclExport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__02963);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1415:1: rule__DeclExport__Group__0__Impl : ( ( rule__DeclExport__NameAssignment_0 ) ) ;
    public final void rule__DeclExport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1419:1: ( ( ( rule__DeclExport__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1420:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1420:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1421:1: ( rule__DeclExport__NameAssignment_0 )
            {
             before(grammarAccess.getDeclExportAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1422:1: ( rule__DeclExport__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1422:2: rule__DeclExport__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl2990);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1432:1: rule__DeclExport__Group__1 : rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 ;
    public final void rule__DeclExport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1436:1: ( rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1437:2: rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__13020);
            rule__DeclExport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__13023);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1444:1: rule__DeclExport__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclExport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1448:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1449:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1449:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1450:1: '='
            {
             before(grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__DeclExport__Group__1__Impl3051); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1463:1: rule__DeclExport__Group__2 : rule__DeclExport__Group__2__Impl ;
    public final void rule__DeclExport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1467:1: ( rule__DeclExport__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1468:2: rule__DeclExport__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__23082);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1474:1: rule__DeclExport__Group__2__Impl : ( ( rule__DeclExport__ExportsAssignment_2 )* ) ;
    public final void rule__DeclExport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1478:1: ( ( ( rule__DeclExport__ExportsAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1479:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1479:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1480:1: ( rule__DeclExport__ExportsAssignment_2 )*
            {
             before(grammarAccess.getDeclExportAccess().getExportsAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1481:1: ( rule__DeclExport__ExportsAssignment_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1481:2: rule__DeclExport__ExportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl3109);
            	    rule__DeclExport__ExportsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1497:1: rule__DeclType__Group_0__0 : rule__DeclType__Group_0__0__Impl rule__DeclType__Group_0__1 ;
    public final void rule__DeclType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1501:1: ( rule__DeclType__Group_0__0__Impl rule__DeclType__Group_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1502:2: rule__DeclType__Group_0__0__Impl rule__DeclType__Group_0__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_0__0__Impl_in_rule__DeclType__Group_0__03146);
            rule__DeclType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_0__1_in_rule__DeclType__Group_0__03149);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1509:1: rule__DeclType__Group_0__0__Impl : ( 'type' ) ;
    public final void rule__DeclType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1513:1: ( ( 'type' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1514:1: ( 'type' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1514:1: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1515:1: 'type'
            {
             before(grammarAccess.getDeclTypeAccess().getTypeKeyword_0_0()); 
            match(input,22,FOLLOW_22_in_rule__DeclType__Group_0__0__Impl3177); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1528:1: rule__DeclType__Group_0__1 : rule__DeclType__Group_0__1__Impl rule__DeclType__Group_0__2 ;
    public final void rule__DeclType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1532:1: ( rule__DeclType__Group_0__1__Impl rule__DeclType__Group_0__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1533:2: rule__DeclType__Group_0__1__Impl rule__DeclType__Group_0__2
            {
            pushFollow(FOLLOW_rule__DeclType__Group_0__1__Impl_in_rule__DeclType__Group_0__13208);
            rule__DeclType__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_0__2_in_rule__DeclType__Group_0__13211);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1540:1: rule__DeclType__Group_0__1__Impl : ( ( rule__DeclType__NameAssignment_0_1 ) ) ;
    public final void rule__DeclType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1544:1: ( ( ( rule__DeclType__NameAssignment_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1545:1: ( ( rule__DeclType__NameAssignment_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1545:1: ( ( rule__DeclType__NameAssignment_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1546:1: ( rule__DeclType__NameAssignment_0_1 )
            {
             before(grammarAccess.getDeclTypeAccess().getNameAssignment_0_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1547:1: ( rule__DeclType__NameAssignment_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1547:2: rule__DeclType__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__DeclType__NameAssignment_0_1_in_rule__DeclType__Group_0__1__Impl3238);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1557:1: rule__DeclType__Group_0__2 : rule__DeclType__Group_0__2__Impl rule__DeclType__Group_0__3 ;
    public final void rule__DeclType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1561:1: ( rule__DeclType__Group_0__2__Impl rule__DeclType__Group_0__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1562:2: rule__DeclType__Group_0__2__Impl rule__DeclType__Group_0__3
            {
            pushFollow(FOLLOW_rule__DeclType__Group_0__2__Impl_in_rule__DeclType__Group_0__23268);
            rule__DeclType__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_0__3_in_rule__DeclType__Group_0__23271);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1569:1: rule__DeclType__Group_0__2__Impl : ( '=' ) ;
    public final void rule__DeclType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1573:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1574:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1574:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1575:1: '='
            {
             before(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_0_2()); 
            match(input,21,FOLLOW_21_in_rule__DeclType__Group_0__2__Impl3299); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1588:1: rule__DeclType__Group_0__3 : rule__DeclType__Group_0__3__Impl ;
    public final void rule__DeclType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1592:1: ( rule__DeclType__Group_0__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1593:2: rule__DeclType__Group_0__3__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_0__3__Impl_in_rule__DeclType__Group_0__33330);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1599:1: rule__DeclType__Group_0__3__Impl : ( ( rule__DeclType__ValueAssignment_0_3 ) ) ;
    public final void rule__DeclType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1603:1: ( ( ( rule__DeclType__ValueAssignment_0_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1604:1: ( ( rule__DeclType__ValueAssignment_0_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1604:1: ( ( rule__DeclType__ValueAssignment_0_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1605:1: ( rule__DeclType__ValueAssignment_0_3 )
            {
             before(grammarAccess.getDeclTypeAccess().getValueAssignment_0_3()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1606:1: ( rule__DeclType__ValueAssignment_0_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1606:2: rule__DeclType__ValueAssignment_0_3
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAssignment_0_3_in_rule__DeclType__Group_0__3__Impl3357);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1624:1: rule__DeclType__Group_1__0 : rule__DeclType__Group_1__0__Impl rule__DeclType__Group_1__1 ;
    public final void rule__DeclType__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1628:1: ( rule__DeclType__Group_1__0__Impl rule__DeclType__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1629:2: rule__DeclType__Group_1__0__Impl rule__DeclType__Group_1__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__0__Impl_in_rule__DeclType__Group_1__03395);
            rule__DeclType__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__1_in_rule__DeclType__Group_1__03398);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1636:1: rule__DeclType__Group_1__0__Impl : ( 'type' ) ;
    public final void rule__DeclType__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1640:1: ( ( 'type' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1641:1: ( 'type' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1641:1: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1642:1: 'type'
            {
             before(grammarAccess.getDeclTypeAccess().getTypeKeyword_1_0()); 
            match(input,22,FOLLOW_22_in_rule__DeclType__Group_1__0__Impl3426); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1655:1: rule__DeclType__Group_1__1 : rule__DeclType__Group_1__1__Impl rule__DeclType__Group_1__2 ;
    public final void rule__DeclType__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1659:1: ( rule__DeclType__Group_1__1__Impl rule__DeclType__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1660:2: rule__DeclType__Group_1__1__Impl rule__DeclType__Group_1__2
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__1__Impl_in_rule__DeclType__Group_1__13457);
            rule__DeclType__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__2_in_rule__DeclType__Group_1__13460);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1667:1: rule__DeclType__Group_1__1__Impl : ( ( rule__DeclType__NameAssignment_1_1 ) ) ;
    public final void rule__DeclType__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1671:1: ( ( ( rule__DeclType__NameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1672:1: ( ( rule__DeclType__NameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1672:1: ( ( rule__DeclType__NameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1673:1: ( rule__DeclType__NameAssignment_1_1 )
            {
             before(grammarAccess.getDeclTypeAccess().getNameAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1674:1: ( rule__DeclType__NameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1674:2: rule__DeclType__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__DeclType__NameAssignment_1_1_in_rule__DeclType__Group_1__1__Impl3487);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1684:1: rule__DeclType__Group_1__2 : rule__DeclType__Group_1__2__Impl rule__DeclType__Group_1__3 ;
    public final void rule__DeclType__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1688:1: ( rule__DeclType__Group_1__2__Impl rule__DeclType__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1689:2: rule__DeclType__Group_1__2__Impl rule__DeclType__Group_1__3
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__2__Impl_in_rule__DeclType__Group_1__23517);
            rule__DeclType__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__3_in_rule__DeclType__Group_1__23520);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1696:1: rule__DeclType__Group_1__2__Impl : ( '[' ) ;
    public final void rule__DeclType__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1700:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1701:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1701:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1702:1: '['
            {
             before(grammarAccess.getDeclTypeAccess().getLeftSquareBracketKeyword_1_2()); 
            match(input,23,FOLLOW_23_in_rule__DeclType__Group_1__2__Impl3548); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1715:1: rule__DeclType__Group_1__3 : rule__DeclType__Group_1__3__Impl rule__DeclType__Group_1__4 ;
    public final void rule__DeclType__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1719:1: ( rule__DeclType__Group_1__3__Impl rule__DeclType__Group_1__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1720:2: rule__DeclType__Group_1__3__Impl rule__DeclType__Group_1__4
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__3__Impl_in_rule__DeclType__Group_1__33579);
            rule__DeclType__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__4_in_rule__DeclType__Group_1__33582);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1727:1: rule__DeclType__Group_1__3__Impl : ( ( rule__DeclType__AttrNameAssignment_1_3 ) ) ;
    public final void rule__DeclType__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1731:1: ( ( ( rule__DeclType__AttrNameAssignment_1_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1732:1: ( ( rule__DeclType__AttrNameAssignment_1_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1732:1: ( ( rule__DeclType__AttrNameAssignment_1_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1733:1: ( rule__DeclType__AttrNameAssignment_1_3 )
            {
             before(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_1_3()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1734:1: ( rule__DeclType__AttrNameAssignment_1_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1734:2: rule__DeclType__AttrNameAssignment_1_3
            {
            pushFollow(FOLLOW_rule__DeclType__AttrNameAssignment_1_3_in_rule__DeclType__Group_1__3__Impl3609);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1744:1: rule__DeclType__Group_1__4 : rule__DeclType__Group_1__4__Impl rule__DeclType__Group_1__5 ;
    public final void rule__DeclType__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1748:1: ( rule__DeclType__Group_1__4__Impl rule__DeclType__Group_1__5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1749:2: rule__DeclType__Group_1__4__Impl rule__DeclType__Group_1__5
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__4__Impl_in_rule__DeclType__Group_1__43639);
            rule__DeclType__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__5_in_rule__DeclType__Group_1__43642);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1756:1: rule__DeclType__Group_1__4__Impl : ( ( rule__DeclType__Group_1_4__0 )* ) ;
    public final void rule__DeclType__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1760:1: ( ( ( rule__DeclType__Group_1_4__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1761:1: ( ( rule__DeclType__Group_1_4__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1761:1: ( ( rule__DeclType__Group_1_4__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1762:1: ( rule__DeclType__Group_1_4__0 )*
            {
             before(grammarAccess.getDeclTypeAccess().getGroup_1_4()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1763:1: ( rule__DeclType__Group_1_4__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==25) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1763:2: rule__DeclType__Group_1_4__0
            	    {
            	    pushFollow(FOLLOW_rule__DeclType__Group_1_4__0_in_rule__DeclType__Group_1__4__Impl3669);
            	    rule__DeclType__Group_1_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1773:1: rule__DeclType__Group_1__5 : rule__DeclType__Group_1__5__Impl rule__DeclType__Group_1__6 ;
    public final void rule__DeclType__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1777:1: ( rule__DeclType__Group_1__5__Impl rule__DeclType__Group_1__6 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1778:2: rule__DeclType__Group_1__5__Impl rule__DeclType__Group_1__6
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__5__Impl_in_rule__DeclType__Group_1__53700);
            rule__DeclType__Group_1__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__6_in_rule__DeclType__Group_1__53703);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1785:1: rule__DeclType__Group_1__5__Impl : ( ']' ) ;
    public final void rule__DeclType__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1789:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1790:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1790:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1791:1: ']'
            {
             before(grammarAccess.getDeclTypeAccess().getRightSquareBracketKeyword_1_5()); 
            match(input,24,FOLLOW_24_in_rule__DeclType__Group_1__5__Impl3731); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1804:1: rule__DeclType__Group_1__6 : rule__DeclType__Group_1__6__Impl rule__DeclType__Group_1__7 ;
    public final void rule__DeclType__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1808:1: ( rule__DeclType__Group_1__6__Impl rule__DeclType__Group_1__7 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1809:2: rule__DeclType__Group_1__6__Impl rule__DeclType__Group_1__7
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__6__Impl_in_rule__DeclType__Group_1__63762);
            rule__DeclType__Group_1__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1__7_in_rule__DeclType__Group_1__63765);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1816:1: rule__DeclType__Group_1__6__Impl : ( '=' ) ;
    public final void rule__DeclType__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1820:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1821:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1821:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1822:1: '='
            {
             before(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_1_6()); 
            match(input,21,FOLLOW_21_in_rule__DeclType__Group_1__6__Impl3793); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1835:1: rule__DeclType__Group_1__7 : rule__DeclType__Group_1__7__Impl ;
    public final void rule__DeclType__Group_1__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1839:1: ( rule__DeclType__Group_1__7__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1840:2: rule__DeclType__Group_1__7__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1__7__Impl_in_rule__DeclType__Group_1__73824);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1846:1: rule__DeclType__Group_1__7__Impl : ( ( rule__DeclType__ValueAssignment_1_7 ) ) ;
    public final void rule__DeclType__Group_1__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1850:1: ( ( ( rule__DeclType__ValueAssignment_1_7 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1851:1: ( ( rule__DeclType__ValueAssignment_1_7 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1851:1: ( ( rule__DeclType__ValueAssignment_1_7 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1852:1: ( rule__DeclType__ValueAssignment_1_7 )
            {
             before(grammarAccess.getDeclTypeAccess().getValueAssignment_1_7()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1853:1: ( rule__DeclType__ValueAssignment_1_7 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1853:2: rule__DeclType__ValueAssignment_1_7
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAssignment_1_7_in_rule__DeclType__Group_1__7__Impl3851);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1879:1: rule__DeclType__Group_1_4__0 : rule__DeclType__Group_1_4__0__Impl rule__DeclType__Group_1_4__1 ;
    public final void rule__DeclType__Group_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1883:1: ( rule__DeclType__Group_1_4__0__Impl rule__DeclType__Group_1_4__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1884:2: rule__DeclType__Group_1_4__0__Impl rule__DeclType__Group_1_4__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1_4__0__Impl_in_rule__DeclType__Group_1_4__03897);
            rule__DeclType__Group_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclType__Group_1_4__1_in_rule__DeclType__Group_1_4__03900);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1891:1: rule__DeclType__Group_1_4__0__Impl : ( ',' ) ;
    public final void rule__DeclType__Group_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1895:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1896:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1896:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1897:1: ','
            {
             before(grammarAccess.getDeclTypeAccess().getCommaKeyword_1_4_0()); 
            match(input,25,FOLLOW_25_in_rule__DeclType__Group_1_4__0__Impl3928); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1910:1: rule__DeclType__Group_1_4__1 : rule__DeclType__Group_1_4__1__Impl ;
    public final void rule__DeclType__Group_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1914:1: ( rule__DeclType__Group_1_4__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1915:2: rule__DeclType__Group_1_4__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_1_4__1__Impl_in_rule__DeclType__Group_1_4__13959);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1921:1: rule__DeclType__Group_1_4__1__Impl : ( ( rule__DeclType__AttrNameAssignment_1_4_1 ) ) ;
    public final void rule__DeclType__Group_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1925:1: ( ( ( rule__DeclType__AttrNameAssignment_1_4_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1926:1: ( ( rule__DeclType__AttrNameAssignment_1_4_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1926:1: ( ( rule__DeclType__AttrNameAssignment_1_4_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1927:1: ( rule__DeclType__AttrNameAssignment_1_4_1 )
            {
             before(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_1_4_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1928:1: ( rule__DeclType__AttrNameAssignment_1_4_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1928:2: rule__DeclType__AttrNameAssignment_1_4_1
            {
            pushFollow(FOLLOW_rule__DeclType__AttrNameAssignment_1_4_1_in_rule__DeclType__Group_1_4__1__Impl3986);
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


    // $ANTLR start "rule__DeclVal__Group_0__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1942:1: rule__DeclVal__Group_0__0 : rule__DeclVal__Group_0__0__Impl rule__DeclVal__Group_0__1 ;
    public final void rule__DeclVal__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1946:1: ( rule__DeclVal__Group_0__0__Impl rule__DeclVal__Group_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1947:2: rule__DeclVal__Group_0__0__Impl rule__DeclVal__Group_0__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__0__Impl_in_rule__DeclVal__Group_0__04020);
            rule__DeclVal__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_0__1_in_rule__DeclVal__Group_0__04023);
            rule__DeclVal__Group_0__1();

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
    // $ANTLR end "rule__DeclVal__Group_0__0"


    // $ANTLR start "rule__DeclVal__Group_0__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1954:1: rule__DeclVal__Group_0__0__Impl : ( 'val' ) ;
    public final void rule__DeclVal__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1958:1: ( ( 'val' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1959:1: ( 'val' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1959:1: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1960:1: 'val'
            {
             before(grammarAccess.getDeclValAccess().getValKeyword_0_0()); 
            match(input,26,FOLLOW_26_in_rule__DeclVal__Group_0__0__Impl4051); 
             after(grammarAccess.getDeclValAccess().getValKeyword_0_0()); 

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
    // $ANTLR end "rule__DeclVal__Group_0__0__Impl"


    // $ANTLR start "rule__DeclVal__Group_0__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1973:1: rule__DeclVal__Group_0__1 : rule__DeclVal__Group_0__1__Impl rule__DeclVal__Group_0__2 ;
    public final void rule__DeclVal__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1977:1: ( rule__DeclVal__Group_0__1__Impl rule__DeclVal__Group_0__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1978:2: rule__DeclVal__Group_0__1__Impl rule__DeclVal__Group_0__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__1__Impl_in_rule__DeclVal__Group_0__14082);
            rule__DeclVal__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_0__2_in_rule__DeclVal__Group_0__14085);
            rule__DeclVal__Group_0__2();

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
    // $ANTLR end "rule__DeclVal__Group_0__1"


    // $ANTLR start "rule__DeclVal__Group_0__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1985:1: rule__DeclVal__Group_0__1__Impl : ( ( rule__DeclVal__NameAssignment_0_1 ) ) ;
    public final void rule__DeclVal__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1989:1: ( ( ( rule__DeclVal__NameAssignment_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1990:1: ( ( rule__DeclVal__NameAssignment_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1990:1: ( ( rule__DeclVal__NameAssignment_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1991:1: ( rule__DeclVal__NameAssignment_0_1 )
            {
             before(grammarAccess.getDeclValAccess().getNameAssignment_0_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1992:1: ( rule__DeclVal__NameAssignment_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1992:2: rule__DeclVal__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__DeclVal__NameAssignment_0_1_in_rule__DeclVal__Group_0__1__Impl4112);
            rule__DeclVal__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getNameAssignment_0_1()); 

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
    // $ANTLR end "rule__DeclVal__Group_0__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_0__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2002:1: rule__DeclVal__Group_0__2 : rule__DeclVal__Group_0__2__Impl rule__DeclVal__Group_0__3 ;
    public final void rule__DeclVal__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2006:1: ( rule__DeclVal__Group_0__2__Impl rule__DeclVal__Group_0__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2007:2: rule__DeclVal__Group_0__2__Impl rule__DeclVal__Group_0__3
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__2__Impl_in_rule__DeclVal__Group_0__24142);
            rule__DeclVal__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_0__3_in_rule__DeclVal__Group_0__24145);
            rule__DeclVal__Group_0__3();

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
    // $ANTLR end "rule__DeclVal__Group_0__2"


    // $ANTLR start "rule__DeclVal__Group_0__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2014:1: rule__DeclVal__Group_0__2__Impl : ( ( rule__DeclVal__AttrAssignment_0_2 )* ) ;
    public final void rule__DeclVal__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2018:1: ( ( ( rule__DeclVal__AttrAssignment_0_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2019:1: ( ( rule__DeclVal__AttrAssignment_0_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2019:1: ( ( rule__DeclVal__AttrAssignment_0_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2020:1: ( rule__DeclVal__AttrAssignment_0_2 )*
            {
             before(grammarAccess.getDeclValAccess().getAttrAssignment_0_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2021:1: ( rule__DeclVal__AttrAssignment_0_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2021:2: rule__DeclVal__AttrAssignment_0_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclVal__AttrAssignment_0_2_in_rule__DeclVal__Group_0__2__Impl4172);
            	    rule__DeclVal__AttrAssignment_0_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getDeclValAccess().getAttrAssignment_0_2()); 

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
    // $ANTLR end "rule__DeclVal__Group_0__2__Impl"


    // $ANTLR start "rule__DeclVal__Group_0__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2031:1: rule__DeclVal__Group_0__3 : rule__DeclVal__Group_0__3__Impl rule__DeclVal__Group_0__4 ;
    public final void rule__DeclVal__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2035:1: ( rule__DeclVal__Group_0__3__Impl rule__DeclVal__Group_0__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2036:2: rule__DeclVal__Group_0__3__Impl rule__DeclVal__Group_0__4
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__3__Impl_in_rule__DeclVal__Group_0__34203);
            rule__DeclVal__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_0__4_in_rule__DeclVal__Group_0__34206);
            rule__DeclVal__Group_0__4();

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
    // $ANTLR end "rule__DeclVal__Group_0__3"


    // $ANTLR start "rule__DeclVal__Group_0__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2043:1: rule__DeclVal__Group_0__3__Impl : ( '=' ) ;
    public final void rule__DeclVal__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2047:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2048:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2048:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2049:1: '='
            {
             before(grammarAccess.getDeclValAccess().getEqualsSignKeyword_0_3()); 
            match(input,21,FOLLOW_21_in_rule__DeclVal__Group_0__3__Impl4234); 
             after(grammarAccess.getDeclValAccess().getEqualsSignKeyword_0_3()); 

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
    // $ANTLR end "rule__DeclVal__Group_0__3__Impl"


    // $ANTLR start "rule__DeclVal__Group_0__4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2062:1: rule__DeclVal__Group_0__4 : rule__DeclVal__Group_0__4__Impl ;
    public final void rule__DeclVal__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2066:1: ( rule__DeclVal__Group_0__4__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2067:2: rule__DeclVal__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__4__Impl_in_rule__DeclVal__Group_0__44265);
            rule__DeclVal__Group_0__4__Impl();

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
    // $ANTLR end "rule__DeclVal__Group_0__4"


    // $ANTLR start "rule__DeclVal__Group_0__4__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2073:1: rule__DeclVal__Group_0__4__Impl : ( ( rule__DeclVal__ExpAssignment_0_4 ) ) ;
    public final void rule__DeclVal__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2077:1: ( ( ( rule__DeclVal__ExpAssignment_0_4 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2078:1: ( ( rule__DeclVal__ExpAssignment_0_4 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2078:1: ( ( rule__DeclVal__ExpAssignment_0_4 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2079:1: ( rule__DeclVal__ExpAssignment_0_4 )
            {
             before(grammarAccess.getDeclValAccess().getExpAssignment_0_4()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2080:1: ( rule__DeclVal__ExpAssignment_0_4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2080:2: rule__DeclVal__ExpAssignment_0_4
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpAssignment_0_4_in_rule__DeclVal__Group_0__4__Impl4292);
            rule__DeclVal__ExpAssignment_0_4();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getExpAssignment_0_4()); 

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
    // $ANTLR end "rule__DeclVal__Group_0__4__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2100:1: rule__DeclVal__Group_1__0 : rule__DeclVal__Group_1__0__Impl rule__DeclVal__Group_1__1 ;
    public final void rule__DeclVal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2104:1: ( rule__DeclVal__Group_1__0__Impl rule__DeclVal__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2105:2: rule__DeclVal__Group_1__0__Impl rule__DeclVal__Group_1__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__0__Impl_in_rule__DeclVal__Group_1__04332);
            rule__DeclVal__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_1__1_in_rule__DeclVal__Group_1__04335);
            rule__DeclVal__Group_1__1();

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
    // $ANTLR end "rule__DeclVal__Group_1__0"


    // $ANTLR start "rule__DeclVal__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2112:1: rule__DeclVal__Group_1__0__Impl : ( 'val' ) ;
    public final void rule__DeclVal__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2116:1: ( ( 'val' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2117:1: ( 'val' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2117:1: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2118:1: 'val'
            {
             before(grammarAccess.getDeclValAccess().getValKeyword_1_0()); 
            match(input,26,FOLLOW_26_in_rule__DeclVal__Group_1__0__Impl4363); 
             after(grammarAccess.getDeclValAccess().getValKeyword_1_0()); 

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
    // $ANTLR end "rule__DeclVal__Group_1__0__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2131:1: rule__DeclVal__Group_1__1 : rule__DeclVal__Group_1__1__Impl rule__DeclVal__Group_1__2 ;
    public final void rule__DeclVal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2135:1: ( rule__DeclVal__Group_1__1__Impl rule__DeclVal__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2136:2: rule__DeclVal__Group_1__1__Impl rule__DeclVal__Group_1__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__1__Impl_in_rule__DeclVal__Group_1__14394);
            rule__DeclVal__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_1__2_in_rule__DeclVal__Group_1__14397);
            rule__DeclVal__Group_1__2();

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
    // $ANTLR end "rule__DeclVal__Group_1__1"


    // $ANTLR start "rule__DeclVal__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2143:1: rule__DeclVal__Group_1__1__Impl : ( ( rule__DeclVal__NameAssignment_1_1 ) ) ;
    public final void rule__DeclVal__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2147:1: ( ( ( rule__DeclVal__NameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2148:1: ( ( rule__DeclVal__NameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2148:1: ( ( rule__DeclVal__NameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2149:1: ( rule__DeclVal__NameAssignment_1_1 )
            {
             before(grammarAccess.getDeclValAccess().getNameAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2150:1: ( rule__DeclVal__NameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2150:2: rule__DeclVal__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__DeclVal__NameAssignment_1_1_in_rule__DeclVal__Group_1__1__Impl4424);
            rule__DeclVal__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getNameAssignment_1_1()); 

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
    // $ANTLR end "rule__DeclVal__Group_1__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2160:1: rule__DeclVal__Group_1__2 : rule__DeclVal__Group_1__2__Impl rule__DeclVal__Group_1__3 ;
    public final void rule__DeclVal__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2164:1: ( rule__DeclVal__Group_1__2__Impl rule__DeclVal__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2165:2: rule__DeclVal__Group_1__2__Impl rule__DeclVal__Group_1__3
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__2__Impl_in_rule__DeclVal__Group_1__24454);
            rule__DeclVal__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_1__3_in_rule__DeclVal__Group_1__24457);
            rule__DeclVal__Group_1__3();

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
    // $ANTLR end "rule__DeclVal__Group_1__2"


    // $ANTLR start "rule__DeclVal__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2172:1: rule__DeclVal__Group_1__2__Impl : ( '[' ) ;
    public final void rule__DeclVal__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2176:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2177:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2177:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2178:1: '['
            {
             before(grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2()); 
            match(input,23,FOLLOW_23_in_rule__DeclVal__Group_1__2__Impl4485); 
             after(grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2()); 

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
    // $ANTLR end "rule__DeclVal__Group_1__2__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2191:1: rule__DeclVal__Group_1__3 : rule__DeclVal__Group_1__3__Impl rule__DeclVal__Group_1__4 ;
    public final void rule__DeclVal__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2195:1: ( rule__DeclVal__Group_1__3__Impl rule__DeclVal__Group_1__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2196:2: rule__DeclVal__Group_1__3__Impl rule__DeclVal__Group_1__4
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__3__Impl_in_rule__DeclVal__Group_1__34516);
            rule__DeclVal__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_1__4_in_rule__DeclVal__Group_1__34519);
            rule__DeclVal__Group_1__4();

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
    // $ANTLR end "rule__DeclVal__Group_1__3"


    // $ANTLR start "rule__DeclVal__Group_1__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2203:1: rule__DeclVal__Group_1__3__Impl : ( ( rule__DeclVal__DecPatAssignment_1_3 )* ) ;
    public final void rule__DeclVal__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2207:1: ( ( ( rule__DeclVal__DecPatAssignment_1_3 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2208:1: ( ( rule__DeclVal__DecPatAssignment_1_3 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2208:1: ( ( rule__DeclVal__DecPatAssignment_1_3 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2209:1: ( rule__DeclVal__DecPatAssignment_1_3 )*
            {
             before(grammarAccess.getDeclValAccess().getDecPatAssignment_1_3()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2210:1: ( rule__DeclVal__DecPatAssignment_1_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID||LA22_0==32||(LA22_0>=34 && LA22_0<=36)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2210:2: rule__DeclVal__DecPatAssignment_1_3
            	    {
            	    pushFollow(FOLLOW_rule__DeclVal__DecPatAssignment_1_3_in_rule__DeclVal__Group_1__3__Impl4546);
            	    rule__DeclVal__DecPatAssignment_1_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getDeclValAccess().getDecPatAssignment_1_3()); 

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
    // $ANTLR end "rule__DeclVal__Group_1__3__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2220:1: rule__DeclVal__Group_1__4 : rule__DeclVal__Group_1__4__Impl rule__DeclVal__Group_1__5 ;
    public final void rule__DeclVal__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2224:1: ( rule__DeclVal__Group_1__4__Impl rule__DeclVal__Group_1__5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2225:2: rule__DeclVal__Group_1__4__Impl rule__DeclVal__Group_1__5
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__4__Impl_in_rule__DeclVal__Group_1__44577);
            rule__DeclVal__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_1__5_in_rule__DeclVal__Group_1__44580);
            rule__DeclVal__Group_1__5();

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
    // $ANTLR end "rule__DeclVal__Group_1__4"


    // $ANTLR start "rule__DeclVal__Group_1__4__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2232:1: rule__DeclVal__Group_1__4__Impl : ( ']' ) ;
    public final void rule__DeclVal__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2236:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2237:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2237:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2238:1: ']'
            {
             before(grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_4()); 
            match(input,24,FOLLOW_24_in_rule__DeclVal__Group_1__4__Impl4608); 
             after(grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_4()); 

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
    // $ANTLR end "rule__DeclVal__Group_1__4__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__5"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2251:1: rule__DeclVal__Group_1__5 : rule__DeclVal__Group_1__5__Impl ;
    public final void rule__DeclVal__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2255:1: ( rule__DeclVal__Group_1__5__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2256:2: rule__DeclVal__Group_1__5__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__5__Impl_in_rule__DeclVal__Group_1__54639);
            rule__DeclVal__Group_1__5__Impl();

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
    // $ANTLR end "rule__DeclVal__Group_1__5"


    // $ANTLR start "rule__DeclVal__Group_1__5__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2262:1: rule__DeclVal__Group_1__5__Impl : ( ( rule__DeclVal__Alternatives_1_5 ) ) ;
    public final void rule__DeclVal__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2266:1: ( ( ( rule__DeclVal__Alternatives_1_5 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2267:1: ( ( rule__DeclVal__Alternatives_1_5 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2267:1: ( ( rule__DeclVal__Alternatives_1_5 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2268:1: ( rule__DeclVal__Alternatives_1_5 )
            {
             before(grammarAccess.getDeclValAccess().getAlternatives_1_5()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2269:1: ( rule__DeclVal__Alternatives_1_5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2269:2: rule__DeclVal__Alternatives_1_5
            {
            pushFollow(FOLLOW_rule__DeclVal__Alternatives_1_5_in_rule__DeclVal__Group_1__5__Impl4666);
            rule__DeclVal__Alternatives_1_5();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getAlternatives_1_5()); 

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
    // $ANTLR end "rule__DeclVal__Group_1__5__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_0__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2291:1: rule__DeclVal__Group_1_5_0__0 : rule__DeclVal__Group_1_5_0__0__Impl rule__DeclVal__Group_1_5_0__1 ;
    public final void rule__DeclVal__Group_1_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2295:1: ( rule__DeclVal__Group_1_5_0__0__Impl rule__DeclVal__Group_1_5_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2296:2: rule__DeclVal__Group_1_5_0__0__Impl rule__DeclVal__Group_1_5_0__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__0__Impl_in_rule__DeclVal__Group_1_5_0__04708);
            rule__DeclVal__Group_1_5_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__1_in_rule__DeclVal__Group_1_5_0__04711);
            rule__DeclVal__Group_1_5_0__1();

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
    // $ANTLR end "rule__DeclVal__Group_1_5_0__0"


    // $ANTLR start "rule__DeclVal__Group_1_5_0__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2303:1: rule__DeclVal__Group_1_5_0__0__Impl : ( '=' ) ;
    public final void rule__DeclVal__Group_1_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2307:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2308:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2308:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2309:1: '='
            {
             before(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_0_0()); 
            match(input,21,FOLLOW_21_in_rule__DeclVal__Group_1_5_0__0__Impl4739); 
             after(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_0_0()); 

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
    // $ANTLR end "rule__DeclVal__Group_1_5_0__0__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_0__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2322:1: rule__DeclVal__Group_1_5_0__1 : rule__DeclVal__Group_1_5_0__1__Impl ;
    public final void rule__DeclVal__Group_1_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2326:1: ( rule__DeclVal__Group_1_5_0__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2327:2: rule__DeclVal__Group_1_5_0__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__1__Impl_in_rule__DeclVal__Group_1_5_0__14770);
            rule__DeclVal__Group_1_5_0__1__Impl();

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
    // $ANTLR end "rule__DeclVal__Group_1_5_0__1"


    // $ANTLR start "rule__DeclVal__Group_1_5_0__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2333:1: rule__DeclVal__Group_1_5_0__1__Impl : ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) ) ;
    public final void rule__DeclVal__Group_1_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2337:1: ( ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2338:1: ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2338:1: ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2339:1: ( rule__DeclVal__ExpAssignment_1_5_0_1 )
            {
             before(grammarAccess.getDeclValAccess().getExpAssignment_1_5_0_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2340:1: ( rule__DeclVal__ExpAssignment_1_5_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2340:2: rule__DeclVal__ExpAssignment_1_5_0_1
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpAssignment_1_5_0_1_in_rule__DeclVal__Group_1_5_0__1__Impl4797);
            rule__DeclVal__ExpAssignment_1_5_0_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getExpAssignment_1_5_0_1()); 

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
    // $ANTLR end "rule__DeclVal__Group_1_5_0__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2354:1: rule__DeclVal__Group_1_5_1__0 : rule__DeclVal__Group_1_5_1__0__Impl rule__DeclVal__Group_1_5_1__1 ;
    public final void rule__DeclVal__Group_1_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2358:1: ( rule__DeclVal__Group_1_5_1__0__Impl rule__DeclVal__Group_1_5_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2359:2: rule__DeclVal__Group_1_5_1__0__Impl rule__DeclVal__Group_1_5_1__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__0__Impl_in_rule__DeclVal__Group_1_5_1__04831);
            rule__DeclVal__Group_1_5_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__1_in_rule__DeclVal__Group_1_5_1__04834);
            rule__DeclVal__Group_1_5_1__1();

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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__0"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2366:1: rule__DeclVal__Group_1_5_1__0__Impl : ( '|' ) ;
    public final void rule__DeclVal__Group_1_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2370:1: ( ( '|' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2371:1: ( '|' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2371:1: ( '|' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2372:1: '|'
            {
             before(grammarAccess.getDeclValAccess().getVerticalLineKeyword_1_5_1_0()); 
            match(input,27,FOLLOW_27_in_rule__DeclVal__Group_1_5_1__0__Impl4862); 
             after(grammarAccess.getDeclValAccess().getVerticalLineKeyword_1_5_1_0()); 

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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__0__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2385:1: rule__DeclVal__Group_1_5_1__1 : rule__DeclVal__Group_1_5_1__1__Impl rule__DeclVal__Group_1_5_1__2 ;
    public final void rule__DeclVal__Group_1_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2389:1: ( rule__DeclVal__Group_1_5_1__1__Impl rule__DeclVal__Group_1_5_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2390:2: rule__DeclVal__Group_1_5_1__1__Impl rule__DeclVal__Group_1_5_1__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__1__Impl_in_rule__DeclVal__Group_1_5_1__14893);
            rule__DeclVal__Group_1_5_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__2_in_rule__DeclVal__Group_1_5_1__14896);
            rule__DeclVal__Group_1_5_1__2();

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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__1"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2397:1: rule__DeclVal__Group_1_5_1__1__Impl : ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) ) ;
    public final void rule__DeclVal__Group_1_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2401:1: ( ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2402:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2402:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2403:1: ( rule__DeclVal__ExpsAssignment_1_5_1_1 )
            {
             before(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2404:1: ( rule__DeclVal__ExpsAssignment_1_5_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2404:2: rule__DeclVal__ExpsAssignment_1_5_1_1
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_1_in_rule__DeclVal__Group_1_5_1__1__Impl4923);
            rule__DeclVal__ExpsAssignment_1_5_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_1()); 

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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2414:1: rule__DeclVal__Group_1_5_1__2 : rule__DeclVal__Group_1_5_1__2__Impl rule__DeclVal__Group_1_5_1__3 ;
    public final void rule__DeclVal__Group_1_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2418:1: ( rule__DeclVal__Group_1_5_1__2__Impl rule__DeclVal__Group_1_5_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2419:2: rule__DeclVal__Group_1_5_1__2__Impl rule__DeclVal__Group_1_5_1__3
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__2__Impl_in_rule__DeclVal__Group_1_5_1__24953);
            rule__DeclVal__Group_1_5_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__3_in_rule__DeclVal__Group_1_5_1__24956);
            rule__DeclVal__Group_1_5_1__3();

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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__2"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2426:1: rule__DeclVal__Group_1_5_1__2__Impl : ( '=' ) ;
    public final void rule__DeclVal__Group_1_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2430:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2431:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2431:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2432:1: '='
            {
             before(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_1_2()); 
            match(input,21,FOLLOW_21_in_rule__DeclVal__Group_1_5_1__2__Impl4984); 
             after(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_1_2()); 

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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__2__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2445:1: rule__DeclVal__Group_1_5_1__3 : rule__DeclVal__Group_1_5_1__3__Impl ;
    public final void rule__DeclVal__Group_1_5_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2449:1: ( rule__DeclVal__Group_1_5_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2450:2: rule__DeclVal__Group_1_5_1__3__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__3__Impl_in_rule__DeclVal__Group_1_5_1__35015);
            rule__DeclVal__Group_1_5_1__3__Impl();

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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__3"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2456:1: rule__DeclVal__Group_1_5_1__3__Impl : ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) ) ;
    public final void rule__DeclVal__Group_1_5_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2460:1: ( ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2461:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2461:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2462:1: ( rule__DeclVal__ExpsAssignment_1_5_1_3 )
            {
             before(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_3()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2463:1: ( rule__DeclVal__ExpsAssignment_1_5_1_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2463:2: rule__DeclVal__ExpsAssignment_1_5_1_3
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_3_in_rule__DeclVal__Group_1_5_1__3__Impl5042);
            rule__DeclVal__ExpsAssignment_1_5_1_3();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_3()); 

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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__3__Impl"


    // $ANTLR start "rule__Export__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2481:1: rule__Export__Group__0 : rule__Export__Group__0__Impl rule__Export__Group__1 ;
    public final void rule__Export__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2485:1: ( rule__Export__Group__0__Impl rule__Export__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2486:2: rule__Export__Group__0__Impl rule__Export__Group__1
            {
            pushFollow(FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__05080);
            rule__Export__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group__1_in_rule__Export__Group__05083);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2493:1: rule__Export__Group__0__Impl : ( ( rule__Export__NameAssignment_0 ) ) ;
    public final void rule__Export__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2497:1: ( ( ( rule__Export__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2498:1: ( ( rule__Export__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2498:1: ( ( rule__Export__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2499:1: ( rule__Export__NameAssignment_0 )
            {
             before(grammarAccess.getExportAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2500:1: ( rule__Export__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2500:2: rule__Export__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl5110);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2510:1: rule__Export__Group__1 : rule__Export__Group__1__Impl ;
    public final void rule__Export__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2514:1: ( rule__Export__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2515:2: rule__Export__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__15140);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2521:1: rule__Export__Group__1__Impl : ( ( rule__Export__Group_1__0 )? ) ;
    public final void rule__Export__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2525:1: ( ( ( rule__Export__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2526:1: ( ( rule__Export__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2526:1: ( ( rule__Export__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2527:1: ( rule__Export__Group_1__0 )?
            {
             before(grammarAccess.getExportAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2528:1: ( rule__Export__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==28) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2528:2: rule__Export__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl5167);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2542:1: rule__Export__Group_1__0 : rule__Export__Group_1__0__Impl rule__Export__Group_1__1 ;
    public final void rule__Export__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2546:1: ( rule__Export__Group_1__0__Impl rule__Export__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2547:2: rule__Export__Group_1__0__Impl rule__Export__Group_1__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__05202);
            rule__Export__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__05205);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2554:1: rule__Export__Group_1__0__Impl : ( '{' ) ;
    public final void rule__Export__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2558:1: ( ( '{' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2559:1: ( '{' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2559:1: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2560:1: '{'
            {
             before(grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__Export__Group_1__0__Impl5233); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2573:1: rule__Export__Group_1__1 : rule__Export__Group_1__1__Impl rule__Export__Group_1__2 ;
    public final void rule__Export__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2577:1: ( rule__Export__Group_1__1__Impl rule__Export__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2578:2: rule__Export__Group_1__1__Impl rule__Export__Group_1__2
            {
            pushFollow(FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__15264);
            rule__Export__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__15267);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2585:1: rule__Export__Group_1__1__Impl : ( ( rule__Export__AttrNameAssignment_1_1 ) ) ;
    public final void rule__Export__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2589:1: ( ( ( rule__Export__AttrNameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2590:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2590:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2591:1: ( rule__Export__AttrNameAssignment_1_1 )
            {
             before(grammarAccess.getExportAccess().getAttrNameAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2592:1: ( rule__Export__AttrNameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2592:2: rule__Export__AttrNameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl5294);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2602:1: rule__Export__Group_1__2 : rule__Export__Group_1__2__Impl rule__Export__Group_1__3 ;
    public final void rule__Export__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2606:1: ( rule__Export__Group_1__2__Impl rule__Export__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2607:2: rule__Export__Group_1__2__Impl rule__Export__Group_1__3
            {
            pushFollow(FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__25324);
            rule__Export__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__25327);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2614:1: rule__Export__Group_1__2__Impl : ( ( rule__Export__Group_1_2__0 )* ) ;
    public final void rule__Export__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2618:1: ( ( ( rule__Export__Group_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2619:1: ( ( rule__Export__Group_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2619:1: ( ( rule__Export__Group_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2620:1: ( rule__Export__Group_1_2__0 )*
            {
             before(grammarAccess.getExportAccess().getGroup_1_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2621:1: ( rule__Export__Group_1_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==25) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2621:2: rule__Export__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl5354);
            	    rule__Export__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2631:1: rule__Export__Group_1__3 : rule__Export__Group_1__3__Impl ;
    public final void rule__Export__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2635:1: ( rule__Export__Group_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2636:2: rule__Export__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__35385);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2642:1: rule__Export__Group_1__3__Impl : ( '}' ) ;
    public final void rule__Export__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2646:1: ( ( '}' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2647:1: ( '}' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2647:1: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2648:1: '}'
            {
             before(grammarAccess.getExportAccess().getRightCurlyBracketKeyword_1_3()); 
            match(input,29,FOLLOW_29_in_rule__Export__Group_1__3__Impl5413); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2669:1: rule__Export__Group_1_2__0 : rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 ;
    public final void rule__Export__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2673:1: ( rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2674:2: rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__05452);
            rule__Export__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__05455);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2681:1: rule__Export__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__Export__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2685:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2686:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2686:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2687:1: ','
            {
             before(grammarAccess.getExportAccess().getCommaKeyword_1_2_0()); 
            match(input,25,FOLLOW_25_in_rule__Export__Group_1_2__0__Impl5483); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2700:1: rule__Export__Group_1_2__1 : rule__Export__Group_1_2__1__Impl ;
    public final void rule__Export__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2704:1: ( rule__Export__Group_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2705:2: rule__Export__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__15514);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2711:1: rule__Export__Group_1_2__1__Impl : ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) ;
    public final void rule__Export__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2715:1: ( ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2716:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2716:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2717:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            {
             before(grammarAccess.getExportAccess().getAttrNameAssignment_1_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2718:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2718:2: rule__Export__AttrNameAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl5541);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2732:1: rule__ConDecls__Group__0 : rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1 ;
    public final void rule__ConDecls__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2736:1: ( rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2737:2: rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__0__Impl_in_rule__ConDecls__Group__05575);
            rule__ConDecls__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConDecls__Group__1_in_rule__ConDecls__Group__05578);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2744:1: rule__ConDecls__Group__0__Impl : ( ( rule__ConDecls__ConDeclsAssignment_0 ) ) ;
    public final void rule__ConDecls__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2748:1: ( ( ( rule__ConDecls__ConDeclsAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2749:1: ( ( rule__ConDecls__ConDeclsAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2749:1: ( ( rule__ConDecls__ConDeclsAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2750:1: ( rule__ConDecls__ConDeclsAssignment_0 )
            {
             before(grammarAccess.getConDeclsAccess().getConDeclsAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2751:1: ( rule__ConDecls__ConDeclsAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2751:2: rule__ConDecls__ConDeclsAssignment_0
            {
            pushFollow(FOLLOW_rule__ConDecls__ConDeclsAssignment_0_in_rule__ConDecls__Group__0__Impl5605);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2761:1: rule__ConDecls__Group__1 : rule__ConDecls__Group__1__Impl ;
    public final void rule__ConDecls__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2765:1: ( rule__ConDecls__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2766:2: rule__ConDecls__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__1__Impl_in_rule__ConDecls__Group__15635);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2772:1: rule__ConDecls__Group__1__Impl : ( ( rule__ConDecls__Group_1__0 )* ) ;
    public final void rule__ConDecls__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2776:1: ( ( ( rule__ConDecls__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2777:1: ( ( rule__ConDecls__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2777:1: ( ( rule__ConDecls__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2778:1: ( rule__ConDecls__Group_1__0 )*
            {
             before(grammarAccess.getConDeclsAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2779:1: ( rule__ConDecls__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==27) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2779:2: rule__ConDecls__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConDecls__Group_1__0_in_rule__ConDecls__Group__1__Impl5662);
            	    rule__ConDecls__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2793:1: rule__ConDecls__Group_1__0 : rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1 ;
    public final void rule__ConDecls__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2797:1: ( rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2798:2: rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConDecls__Group_1__0__Impl_in_rule__ConDecls__Group_1__05697);
            rule__ConDecls__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConDecls__Group_1__1_in_rule__ConDecls__Group_1__05700);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2805:1: rule__ConDecls__Group_1__0__Impl : ( '|' ) ;
    public final void rule__ConDecls__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2809:1: ( ( '|' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2810:1: ( '|' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2810:1: ( '|' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2811:1: '|'
            {
             before(grammarAccess.getConDeclsAccess().getVerticalLineKeyword_1_0()); 
            match(input,27,FOLLOW_27_in_rule__ConDecls__Group_1__0__Impl5728); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2824:1: rule__ConDecls__Group_1__1 : rule__ConDecls__Group_1__1__Impl ;
    public final void rule__ConDecls__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2828:1: ( rule__ConDecls__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2829:2: rule__ConDecls__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecls__Group_1__1__Impl_in_rule__ConDecls__Group_1__15759);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2835:1: rule__ConDecls__Group_1__1__Impl : ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) ) ;
    public final void rule__ConDecls__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2839:1: ( ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2840:1: ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2840:1: ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2841:1: ( rule__ConDecls__ConDeclsAssignment_1_1 )
            {
             before(grammarAccess.getConDeclsAccess().getConDeclsAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2842:1: ( rule__ConDecls__ConDeclsAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2842:2: rule__ConDecls__ConDeclsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConDecls__ConDeclsAssignment_1_1_in_rule__ConDecls__Group_1__1__Impl5786);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2856:1: rule__ConDecl__Group__0 : rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1 ;
    public final void rule__ConDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2860:1: ( rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2861:2: rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__0__Impl_in_rule__ConDecl__Group__05820);
            rule__ConDecl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConDecl__Group__1_in_rule__ConDecl__Group__05823);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2868:1: rule__ConDecl__Group__0__Impl : ( ( rule__ConDecl__NameAssignment_0 ) ) ;
    public final void rule__ConDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2872:1: ( ( ( rule__ConDecl__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2873:1: ( ( rule__ConDecl__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2873:1: ( ( rule__ConDecl__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2874:1: ( rule__ConDecl__NameAssignment_0 )
            {
             before(grammarAccess.getConDeclAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2875:1: ( rule__ConDecl__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2875:2: rule__ConDecl__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ConDecl__NameAssignment_0_in_rule__ConDecl__Group__0__Impl5850);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2885:1: rule__ConDecl__Group__1 : rule__ConDecl__Group__1__Impl ;
    public final void rule__ConDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2889:1: ( rule__ConDecl__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2890:2: rule__ConDecl__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__1__Impl_in_rule__ConDecl__Group__15880);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2896:1: rule__ConDecl__Group__1__Impl : ( ( rule__ConDecl__Group_1__0 )? ) ;
    public final void rule__ConDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2900:1: ( ( ( rule__ConDecl__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2901:1: ( ( rule__ConDecl__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2901:1: ( ( rule__ConDecl__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2902:1: ( rule__ConDecl__Group_1__0 )?
            {
             before(grammarAccess.getConDeclAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2903:1: ( rule__ConDecl__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==30) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2903:2: rule__ConDecl__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConDecl__Group_1__0_in_rule__ConDecl__Group__1__Impl5907);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2917:1: rule__ConDecl__Group_1__0 : rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1 ;
    public final void rule__ConDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2921:1: ( rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2922:2: rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConDecl__Group_1__0__Impl_in_rule__ConDecl__Group_1__05942);
            rule__ConDecl__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConDecl__Group_1__1_in_rule__ConDecl__Group_1__05945);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2929:1: rule__ConDecl__Group_1__0__Impl : ( 'of' ) ;
    public final void rule__ConDecl__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2933:1: ( ( 'of' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2934:1: ( 'of' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2934:1: ( 'of' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2935:1: 'of'
            {
             before(grammarAccess.getConDeclAccess().getOfKeyword_1_0()); 
            match(input,30,FOLLOW_30_in_rule__ConDecl__Group_1__0__Impl5973); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2948:1: rule__ConDecl__Group_1__1 : rule__ConDecl__Group_1__1__Impl ;
    public final void rule__ConDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2952:1: ( rule__ConDecl__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2953:2: rule__ConDecl__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecl__Group_1__1__Impl_in_rule__ConDecl__Group_1__16004);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2959:1: rule__ConDecl__Group_1__1__Impl : ( ( rule__ConDecl__TyAssignment_1_1 ) ) ;
    public final void rule__ConDecl__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2963:1: ( ( ( rule__ConDecl__TyAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2964:1: ( ( rule__ConDecl__TyAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2964:1: ( ( rule__ConDecl__TyAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2965:1: ( rule__ConDecl__TyAssignment_1_1 )
            {
             before(grammarAccess.getConDeclAccess().getTyAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2966:1: ( rule__ConDecl__TyAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2966:2: rule__ConDecl__TyAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConDecl__TyAssignment_1_1_in_rule__ConDecl__Group_1__1__Impl6031);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2980:1: rule__Ty__Group_1__0 : rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1 ;
    public final void rule__Ty__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2984:1: ( rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2985:2: rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__0__Impl_in_rule__Ty__Group_1__06065);
            rule__Ty__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_1__1_in_rule__Ty__Group_1__06068);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2992:1: rule__Ty__Group_1__0__Impl : ( '|' ) ;
    public final void rule__Ty__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2996:1: ( ( '|' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2997:1: ( '|' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2997:1: ( '|' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2998:1: '|'
            {
             before(grammarAccess.getTyAccess().getVerticalLineKeyword_1_0()); 
            match(input,27,FOLLOW_27_in_rule__Ty__Group_1__0__Impl6096); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3011:1: rule__Ty__Group_1__1 : rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2 ;
    public final void rule__Ty__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3015:1: ( rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3016:2: rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__1__Impl_in_rule__Ty__Group_1__16127);
            rule__Ty__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_1__2_in_rule__Ty__Group_1__16130);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3023:1: rule__Ty__Group_1__1__Impl : ( ( rule__Ty__ValueAssignment_1_1 ) ) ;
    public final void rule__Ty__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3027:1: ( ( ( rule__Ty__ValueAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3028:1: ( ( rule__Ty__ValueAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3028:1: ( ( rule__Ty__ValueAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3029:1: ( rule__Ty__ValueAssignment_1_1 )
            {
             before(grammarAccess.getTyAccess().getValueAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3030:1: ( rule__Ty__ValueAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3030:2: rule__Ty__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Ty__ValueAssignment_1_1_in_rule__Ty__Group_1__1__Impl6157);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3040:1: rule__Ty__Group_1__2 : rule__Ty__Group_1__2__Impl ;
    public final void rule__Ty__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3044:1: ( rule__Ty__Group_1__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3045:2: rule__Ty__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__2__Impl_in_rule__Ty__Group_1__26187);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3051:1: rule__Ty__Group_1__2__Impl : ( '|' ) ;
    public final void rule__Ty__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3055:1: ( ( '|' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3056:1: ( '|' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3056:1: ( '|' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3057:1: '|'
            {
             before(grammarAccess.getTyAccess().getVerticalLineKeyword_1_2()); 
            match(input,27,FOLLOW_27_in_rule__Ty__Group_1__2__Impl6215); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3076:1: rule__Ty__Group_2__0 : rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1 ;
    public final void rule__Ty__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3080:1: ( rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3081:2: rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2__0__Impl_in_rule__Ty__Group_2__06252);
            rule__Ty__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2__1_in_rule__Ty__Group_2__06255);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3088:1: rule__Ty__Group_2__0__Impl : ( ( rule__Ty__ValueAssignment_2_0 ) ) ;
    public final void rule__Ty__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3092:1: ( ( ( rule__Ty__ValueAssignment_2_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3093:1: ( ( rule__Ty__ValueAssignment_2_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3093:1: ( ( rule__Ty__ValueAssignment_2_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3094:1: ( rule__Ty__ValueAssignment_2_0 )
            {
             before(grammarAccess.getTyAccess().getValueAssignment_2_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3095:1: ( rule__Ty__ValueAssignment_2_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3095:2: rule__Ty__ValueAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Ty__ValueAssignment_2_0_in_rule__Ty__Group_2__0__Impl6282);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3105:1: rule__Ty__Group_2__1 : rule__Ty__Group_2__1__Impl ;
    public final void rule__Ty__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3109:1: ( rule__Ty__Group_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3110:2: rule__Ty__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2__1__Impl_in_rule__Ty__Group_2__16312);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3116:1: rule__Ty__Group_2__1__Impl : ( ( rule__Ty__Group_2_1__0 )? ) ;
    public final void rule__Ty__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3120:1: ( ( ( rule__Ty__Group_2_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3121:1: ( ( rule__Ty__Group_2_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3121:1: ( ( rule__Ty__Group_2_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3122:1: ( rule__Ty__Group_2_1__0 )?
            {
             before(grammarAccess.getTyAccess().getGroup_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3123:1: ( rule__Ty__Group_2_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==23) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3123:2: rule__Ty__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_2_1__0_in_rule__Ty__Group_2__1__Impl6339);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3137:1: rule__Ty__Group_2_1__0 : rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1 ;
    public final void rule__Ty__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3141:1: ( rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3142:2: rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__0__Impl_in_rule__Ty__Group_2_1__06374);
            rule__Ty__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2_1__1_in_rule__Ty__Group_2_1__06377);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3149:1: rule__Ty__Group_2_1__0__Impl : ( '[' ) ;
    public final void rule__Ty__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3153:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3154:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3154:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3155:1: '['
            {
             before(grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0()); 
            match(input,23,FOLLOW_23_in_rule__Ty__Group_2_1__0__Impl6405); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3168:1: rule__Ty__Group_2_1__1 : rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2 ;
    public final void rule__Ty__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3172:1: ( rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3173:2: rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__1__Impl_in_rule__Ty__Group_2_1__16436);
            rule__Ty__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2_1__2_in_rule__Ty__Group_2_1__16439);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3180:1: rule__Ty__Group_2_1__1__Impl : ( ( rule__Ty__TyBindAssignment_2_1_1 ) ) ;
    public final void rule__Ty__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3184:1: ( ( ( rule__Ty__TyBindAssignment_2_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3185:1: ( ( rule__Ty__TyBindAssignment_2_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3185:1: ( ( rule__Ty__TyBindAssignment_2_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3186:1: ( rule__Ty__TyBindAssignment_2_1_1 )
            {
             before(grammarAccess.getTyAccess().getTyBindAssignment_2_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3187:1: ( rule__Ty__TyBindAssignment_2_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3187:2: rule__Ty__TyBindAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Ty__TyBindAssignment_2_1_1_in_rule__Ty__Group_2_1__1__Impl6466);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3197:1: rule__Ty__Group_2_1__2 : rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3 ;
    public final void rule__Ty__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3201:1: ( rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3202:2: rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__2__Impl_in_rule__Ty__Group_2_1__26496);
            rule__Ty__Group_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2_1__3_in_rule__Ty__Group_2_1__26499);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3209:1: rule__Ty__Group_2_1__2__Impl : ( ( rule__Ty__Group_2_1_2__0 )* ) ;
    public final void rule__Ty__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3213:1: ( ( ( rule__Ty__Group_2_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3214:1: ( ( rule__Ty__Group_2_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3214:1: ( ( rule__Ty__Group_2_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3215:1: ( rule__Ty__Group_2_1_2__0 )*
            {
             before(grammarAccess.getTyAccess().getGroup_2_1_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3216:1: ( rule__Ty__Group_2_1_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==25) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3216:2: rule__Ty__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Ty__Group_2_1_2__0_in_rule__Ty__Group_2_1__2__Impl6526);
            	    rule__Ty__Group_2_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3226:1: rule__Ty__Group_2_1__3 : rule__Ty__Group_2_1__3__Impl ;
    public final void rule__Ty__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3230:1: ( rule__Ty__Group_2_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3231:2: rule__Ty__Group_2_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__3__Impl_in_rule__Ty__Group_2_1__36557);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3237:1: rule__Ty__Group_2_1__3__Impl : ( ']' ) ;
    public final void rule__Ty__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3241:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3242:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3242:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3243:1: ']'
            {
             before(grammarAccess.getTyAccess().getRightSquareBracketKeyword_2_1_3()); 
            match(input,24,FOLLOW_24_in_rule__Ty__Group_2_1__3__Impl6585); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3264:1: rule__Ty__Group_2_1_2__0 : rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1 ;
    public final void rule__Ty__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3268:1: ( rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3269:2: rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__0__Impl_in_rule__Ty__Group_2_1_2__06624);
            rule__Ty__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__1_in_rule__Ty__Group_2_1_2__06627);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3276:1: rule__Ty__Group_2_1_2__0__Impl : ( ',' ) ;
    public final void rule__Ty__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3280:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3281:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3281:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3282:1: ','
            {
             before(grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0()); 
            match(input,25,FOLLOW_25_in_rule__Ty__Group_2_1_2__0__Impl6655); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3295:1: rule__Ty__Group_2_1_2__1 : rule__Ty__Group_2_1_2__1__Impl ;
    public final void rule__Ty__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3299:1: ( rule__Ty__Group_2_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3300:2: rule__Ty__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__1__Impl_in_rule__Ty__Group_2_1_2__16686);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3306:1: rule__Ty__Group_2_1_2__1__Impl : ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) ) ;
    public final void rule__Ty__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3310:1: ( ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3311:1: ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3311:1: ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3312:1: ( rule__Ty__TyBindAssignment_2_1_2_1 )
            {
             before(grammarAccess.getTyAccess().getTyBindAssignment_2_1_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3313:1: ( rule__Ty__TyBindAssignment_2_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3313:2: rule__Ty__TyBindAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Ty__TyBindAssignment_2_1_2_1_in_rule__Ty__Group_2_1_2__1__Impl6713);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3327:1: rule__Ty__Group_3__0 : rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1 ;
    public final void rule__Ty__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3331:1: ( rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3332:2: rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__0__Impl_in_rule__Ty__Group_3__06747);
            rule__Ty__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_3__1_in_rule__Ty__Group_3__06750);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3339:1: rule__Ty__Group_3__0__Impl : ( '{' ) ;
    public final void rule__Ty__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3343:1: ( ( '{' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3344:1: ( '{' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3344:1: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3345:1: '{'
            {
             before(grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,28,FOLLOW_28_in_rule__Ty__Group_3__0__Impl6778); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3358:1: rule__Ty__Group_3__1 : rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2 ;
    public final void rule__Ty__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3362:1: ( rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3363:2: rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__1__Impl_in_rule__Ty__Group_3__16809);
            rule__Ty__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_3__2_in_rule__Ty__Group_3__16812);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3370:1: rule__Ty__Group_3__1__Impl : ( ( rule__Ty__ElementsAssignment_3_1 ) ) ;
    public final void rule__Ty__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3374:1: ( ( ( rule__Ty__ElementsAssignment_3_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3375:1: ( ( rule__Ty__ElementsAssignment_3_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3375:1: ( ( rule__Ty__ElementsAssignment_3_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3376:1: ( rule__Ty__ElementsAssignment_3_1 )
            {
             before(grammarAccess.getTyAccess().getElementsAssignment_3_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3377:1: ( rule__Ty__ElementsAssignment_3_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3377:2: rule__Ty__ElementsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Ty__ElementsAssignment_3_1_in_rule__Ty__Group_3__1__Impl6839);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3387:1: rule__Ty__Group_3__2 : rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3 ;
    public final void rule__Ty__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3391:1: ( rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3392:2: rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__2__Impl_in_rule__Ty__Group_3__26869);
            rule__Ty__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_3__3_in_rule__Ty__Group_3__26872);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3399:1: rule__Ty__Group_3__2__Impl : ( ( rule__Ty__Group_3_2__0 )* ) ;
    public final void rule__Ty__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3403:1: ( ( ( rule__Ty__Group_3_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3404:1: ( ( rule__Ty__Group_3_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3404:1: ( ( rule__Ty__Group_3_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3405:1: ( rule__Ty__Group_3_2__0 )*
            {
             before(grammarAccess.getTyAccess().getGroup_3_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3406:1: ( rule__Ty__Group_3_2__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==25) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3406:2: rule__Ty__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Ty__Group_3_2__0_in_rule__Ty__Group_3__2__Impl6899);
            	    rule__Ty__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3416:1: rule__Ty__Group_3__3 : rule__Ty__Group_3__3__Impl ;
    public final void rule__Ty__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3420:1: ( rule__Ty__Group_3__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3421:2: rule__Ty__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__3__Impl_in_rule__Ty__Group_3__36930);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3427:1: rule__Ty__Group_3__3__Impl : ( '}' ) ;
    public final void rule__Ty__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3431:1: ( ( '}' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3432:1: ( '}' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3432:1: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3433:1: '}'
            {
             before(grammarAccess.getTyAccess().getRightCurlyBracketKeyword_3_3()); 
            match(input,29,FOLLOW_29_in_rule__Ty__Group_3__3__Impl6958); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3454:1: rule__Ty__Group_3_2__0 : rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1 ;
    public final void rule__Ty__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3458:1: ( rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3459:2: rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_3_2__0__Impl_in_rule__Ty__Group_3_2__06997);
            rule__Ty__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Ty__Group_3_2__1_in_rule__Ty__Group_3_2__07000);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3466:1: rule__Ty__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Ty__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3470:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3471:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3471:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3472:1: ','
            {
             before(grammarAccess.getTyAccess().getCommaKeyword_3_2_0()); 
            match(input,25,FOLLOW_25_in_rule__Ty__Group_3_2__0__Impl7028); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3485:1: rule__Ty__Group_3_2__1 : rule__Ty__Group_3_2__1__Impl ;
    public final void rule__Ty__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3489:1: ( rule__Ty__Group_3_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3490:2: rule__Ty__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_3_2__1__Impl_in_rule__Ty__Group_3_2__17059);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3496:1: rule__Ty__Group_3_2__1__Impl : ( ( rule__Ty__ElementsAssignment_3_2_1 ) ) ;
    public final void rule__Ty__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3500:1: ( ( ( rule__Ty__ElementsAssignment_3_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3501:1: ( ( rule__Ty__ElementsAssignment_3_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3501:1: ( ( rule__Ty__ElementsAssignment_3_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3502:1: ( rule__Ty__ElementsAssignment_3_2_1 )
            {
             before(grammarAccess.getTyAccess().getElementsAssignment_3_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3503:1: ( rule__Ty__ElementsAssignment_3_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3503:2: rule__Ty__ElementsAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__Ty__ElementsAssignment_3_2_1_in_rule__Ty__Group_3_2__1__Impl7086);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3517:1: rule__TyElement__Group__0 : rule__TyElement__Group__0__Impl rule__TyElement__Group__1 ;
    public final void rule__TyElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3521:1: ( rule__TyElement__Group__0__Impl rule__TyElement__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3522:2: rule__TyElement__Group__0__Impl rule__TyElement__Group__1
            {
            pushFollow(FOLLOW_rule__TyElement__Group__0__Impl_in_rule__TyElement__Group__07120);
            rule__TyElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TyElement__Group__1_in_rule__TyElement__Group__07123);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3529:1: rule__TyElement__Group__0__Impl : ( ( rule__TyElement__NameAssignment_0 ) ) ;
    public final void rule__TyElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3533:1: ( ( ( rule__TyElement__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3534:1: ( ( rule__TyElement__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3534:1: ( ( rule__TyElement__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3535:1: ( rule__TyElement__NameAssignment_0 )
            {
             before(grammarAccess.getTyElementAccess().getNameAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3536:1: ( rule__TyElement__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3536:2: rule__TyElement__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__TyElement__NameAssignment_0_in_rule__TyElement__Group__0__Impl7150);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3546:1: rule__TyElement__Group__1 : rule__TyElement__Group__1__Impl rule__TyElement__Group__2 ;
    public final void rule__TyElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3550:1: ( rule__TyElement__Group__1__Impl rule__TyElement__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3551:2: rule__TyElement__Group__1__Impl rule__TyElement__Group__2
            {
            pushFollow(FOLLOW_rule__TyElement__Group__1__Impl_in_rule__TyElement__Group__17180);
            rule__TyElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TyElement__Group__2_in_rule__TyElement__Group__17183);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3558:1: rule__TyElement__Group__1__Impl : ( ':' ) ;
    public final void rule__TyElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3562:1: ( ( ':' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3563:1: ( ':' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3563:1: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3564:1: ':'
            {
             before(grammarAccess.getTyElementAccess().getColonKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__TyElement__Group__1__Impl7211); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3577:1: rule__TyElement__Group__2 : rule__TyElement__Group__2__Impl ;
    public final void rule__TyElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3581:1: ( rule__TyElement__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3582:2: rule__TyElement__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TyElement__Group__2__Impl_in_rule__TyElement__Group__27242);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3588:1: rule__TyElement__Group__2__Impl : ( ( rule__TyElement__ValueAssignment_2 ) ) ;
    public final void rule__TyElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3592:1: ( ( ( rule__TyElement__ValueAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3593:1: ( ( rule__TyElement__ValueAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3593:1: ( ( rule__TyElement__ValueAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3594:1: ( rule__TyElement__ValueAssignment_2 )
            {
             before(grammarAccess.getTyElementAccess().getValueAssignment_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3595:1: ( rule__TyElement__ValueAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3595:2: rule__TyElement__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__TyElement__ValueAssignment_2_in_rule__TyElement__Group__2__Impl7269);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3611:1: rule__TyBind__Group__0 : rule__TyBind__Group__0__Impl rule__TyBind__Group__1 ;
    public final void rule__TyBind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3615:1: ( rule__TyBind__Group__0__Impl rule__TyBind__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3616:2: rule__TyBind__Group__0__Impl rule__TyBind__Group__1
            {
            pushFollow(FOLLOW_rule__TyBind__Group__0__Impl_in_rule__TyBind__Group__07305);
            rule__TyBind__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TyBind__Group__1_in_rule__TyBind__Group__07308);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3623:1: rule__TyBind__Group__0__Impl : ( ( rule__TyBind__KeyAssignment_0 ) ) ;
    public final void rule__TyBind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3627:1: ( ( ( rule__TyBind__KeyAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3628:1: ( ( rule__TyBind__KeyAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3628:1: ( ( rule__TyBind__KeyAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3629:1: ( rule__TyBind__KeyAssignment_0 )
            {
             before(grammarAccess.getTyBindAccess().getKeyAssignment_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3630:1: ( rule__TyBind__KeyAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3630:2: rule__TyBind__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__TyBind__KeyAssignment_0_in_rule__TyBind__Group__0__Impl7335);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3640:1: rule__TyBind__Group__1 : rule__TyBind__Group__1__Impl ;
    public final void rule__TyBind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3644:1: ( rule__TyBind__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3645:2: rule__TyBind__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TyBind__Group__1__Impl_in_rule__TyBind__Group__17365);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3651:1: rule__TyBind__Group__1__Impl : ( ( rule__TyBind__Group_1__0 )? ) ;
    public final void rule__TyBind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3655:1: ( ( ( rule__TyBind__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3656:1: ( ( rule__TyBind__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3656:1: ( ( rule__TyBind__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3657:1: ( rule__TyBind__Group_1__0 )?
            {
             before(grammarAccess.getTyBindAccess().getGroup_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3658:1: ( rule__TyBind__Group_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==21) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3658:2: rule__TyBind__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TyBind__Group_1__0_in_rule__TyBind__Group__1__Impl7392);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3672:1: rule__TyBind__Group_1__0 : rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1 ;
    public final void rule__TyBind__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3676:1: ( rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3677:2: rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1
            {
            pushFollow(FOLLOW_rule__TyBind__Group_1__0__Impl_in_rule__TyBind__Group_1__07427);
            rule__TyBind__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TyBind__Group_1__1_in_rule__TyBind__Group_1__07430);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3684:1: rule__TyBind__Group_1__0__Impl : ( '=' ) ;
    public final void rule__TyBind__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3688:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3689:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3689:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3690:1: '='
            {
             before(grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0()); 
            match(input,21,FOLLOW_21_in_rule__TyBind__Group_1__0__Impl7458); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3703:1: rule__TyBind__Group_1__1 : rule__TyBind__Group_1__1__Impl ;
    public final void rule__TyBind__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3707:1: ( rule__TyBind__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3708:2: rule__TyBind__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TyBind__Group_1__1__Impl_in_rule__TyBind__Group_1__17489);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3714:1: rule__TyBind__Group_1__1__Impl : ( ( rule__TyBind__ValueAssignment_1_1 ) ) ;
    public final void rule__TyBind__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3718:1: ( ( ( rule__TyBind__ValueAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3719:1: ( ( rule__TyBind__ValueAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3719:1: ( ( rule__TyBind__ValueAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3720:1: ( rule__TyBind__ValueAssignment_1_1 )
            {
             before(grammarAccess.getTyBindAccess().getValueAssignment_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3721:1: ( rule__TyBind__ValueAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3721:2: rule__TyBind__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__TyBind__ValueAssignment_1_1_in_rule__TyBind__Group_1__1__Impl7516);
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


    // $ANTLR start "rule__BitPat__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3735:1: rule__BitPat__Group__0 : rule__BitPat__Group__0__Impl rule__BitPat__Group__1 ;
    public final void rule__BitPat__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3739:1: ( rule__BitPat__Group__0__Impl rule__BitPat__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3740:2: rule__BitPat__Group__0__Impl rule__BitPat__Group__1
            {
            pushFollow(FOLLOW_rule__BitPat__Group__0__Impl_in_rule__BitPat__Group__07550);
            rule__BitPat__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BitPat__Group__1_in_rule__BitPat__Group__07553);
            rule__BitPat__Group__1();

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
    // $ANTLR end "rule__BitPat__Group__0"


    // $ANTLR start "rule__BitPat__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3747:1: rule__BitPat__Group__0__Impl : ( '\\'' ) ;
    public final void rule__BitPat__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3751:1: ( ( '\\'' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3752:1: ( '\\'' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3752:1: ( '\\'' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3753:1: '\\''
            {
             before(grammarAccess.getBitPatAccess().getApostropheKeyword_0()); 
            match(input,32,FOLLOW_32_in_rule__BitPat__Group__0__Impl7581); 
             after(grammarAccess.getBitPatAccess().getApostropheKeyword_0()); 

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
    // $ANTLR end "rule__BitPat__Group__0__Impl"


    // $ANTLR start "rule__BitPat__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3766:1: rule__BitPat__Group__1 : rule__BitPat__Group__1__Impl rule__BitPat__Group__2 ;
    public final void rule__BitPat__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3770:1: ( rule__BitPat__Group__1__Impl rule__BitPat__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3771:2: rule__BitPat__Group__1__Impl rule__BitPat__Group__2
            {
            pushFollow(FOLLOW_rule__BitPat__Group__1__Impl_in_rule__BitPat__Group__17612);
            rule__BitPat__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BitPat__Group__2_in_rule__BitPat__Group__17615);
            rule__BitPat__Group__2();

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
    // $ANTLR end "rule__BitPat__Group__1"


    // $ANTLR start "rule__BitPat__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3778:1: rule__BitPat__Group__1__Impl : ( ( rule__BitPat__BitpatAssignment_1 ) ) ;
    public final void rule__BitPat__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3782:1: ( ( ( rule__BitPat__BitpatAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3783:1: ( ( rule__BitPat__BitpatAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3783:1: ( ( rule__BitPat__BitpatAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3784:1: ( rule__BitPat__BitpatAssignment_1 )
            {
             before(grammarAccess.getBitPatAccess().getBitpatAssignment_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3785:1: ( rule__BitPat__BitpatAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3785:2: rule__BitPat__BitpatAssignment_1
            {
            pushFollow(FOLLOW_rule__BitPat__BitpatAssignment_1_in_rule__BitPat__Group__1__Impl7642);
            rule__BitPat__BitpatAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBitPatAccess().getBitpatAssignment_1()); 

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
    // $ANTLR end "rule__BitPat__Group__1__Impl"


    // $ANTLR start "rule__BitPat__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3795:1: rule__BitPat__Group__2 : rule__BitPat__Group__2__Impl rule__BitPat__Group__3 ;
    public final void rule__BitPat__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3799:1: ( rule__BitPat__Group__2__Impl rule__BitPat__Group__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3800:2: rule__BitPat__Group__2__Impl rule__BitPat__Group__3
            {
            pushFollow(FOLLOW_rule__BitPat__Group__2__Impl_in_rule__BitPat__Group__27672);
            rule__BitPat__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BitPat__Group__3_in_rule__BitPat__Group__27675);
            rule__BitPat__Group__3();

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
    // $ANTLR end "rule__BitPat__Group__2"


    // $ANTLR start "rule__BitPat__Group__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3807:1: rule__BitPat__Group__2__Impl : ( ( rule__BitPat__Group_2__0 )* ) ;
    public final void rule__BitPat__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3811:1: ( ( ( rule__BitPat__Group_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3812:1: ( ( rule__BitPat__Group_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3812:1: ( ( rule__BitPat__Group_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3813:1: ( rule__BitPat__Group_2__0 )*
            {
             before(grammarAccess.getBitPatAccess().getGroup_2()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3814:1: ( rule__BitPat__Group_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==25) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3814:2: rule__BitPat__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__BitPat__Group_2__0_in_rule__BitPat__Group__2__Impl7702);
            	    rule__BitPat__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getBitPatAccess().getGroup_2()); 

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
    // $ANTLR end "rule__BitPat__Group__2__Impl"


    // $ANTLR start "rule__BitPat__Group__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3824:1: rule__BitPat__Group__3 : rule__BitPat__Group__3__Impl ;
    public final void rule__BitPat__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3828:1: ( rule__BitPat__Group__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3829:2: rule__BitPat__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__BitPat__Group__3__Impl_in_rule__BitPat__Group__37733);
            rule__BitPat__Group__3__Impl();

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
    // $ANTLR end "rule__BitPat__Group__3"


    // $ANTLR start "rule__BitPat__Group__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3835:1: rule__BitPat__Group__3__Impl : ( '\\'' ) ;
    public final void rule__BitPat__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3839:1: ( ( '\\'' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3840:1: ( '\\'' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3840:1: ( '\\'' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3841:1: '\\''
            {
             before(grammarAccess.getBitPatAccess().getApostropheKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__BitPat__Group__3__Impl7761); 
             after(grammarAccess.getBitPatAccess().getApostropheKeyword_3()); 

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
    // $ANTLR end "rule__BitPat__Group__3__Impl"


    // $ANTLR start "rule__BitPat__Group_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3862:1: rule__BitPat__Group_2__0 : rule__BitPat__Group_2__0__Impl rule__BitPat__Group_2__1 ;
    public final void rule__BitPat__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3866:1: ( rule__BitPat__Group_2__0__Impl rule__BitPat__Group_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3867:2: rule__BitPat__Group_2__0__Impl rule__BitPat__Group_2__1
            {
            pushFollow(FOLLOW_rule__BitPat__Group_2__0__Impl_in_rule__BitPat__Group_2__07800);
            rule__BitPat__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BitPat__Group_2__1_in_rule__BitPat__Group_2__07803);
            rule__BitPat__Group_2__1();

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
    // $ANTLR end "rule__BitPat__Group_2__0"


    // $ANTLR start "rule__BitPat__Group_2__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3874:1: rule__BitPat__Group_2__0__Impl : ( ',' ) ;
    public final void rule__BitPat__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3878:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3879:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3879:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3880:1: ','
            {
             before(grammarAccess.getBitPatAccess().getCommaKeyword_2_0()); 
            match(input,25,FOLLOW_25_in_rule__BitPat__Group_2__0__Impl7831); 
             after(grammarAccess.getBitPatAccess().getCommaKeyword_2_0()); 

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
    // $ANTLR end "rule__BitPat__Group_2__0__Impl"


    // $ANTLR start "rule__BitPat__Group_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3893:1: rule__BitPat__Group_2__1 : rule__BitPat__Group_2__1__Impl ;
    public final void rule__BitPat__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3897:1: ( rule__BitPat__Group_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3898:2: rule__BitPat__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__BitPat__Group_2__1__Impl_in_rule__BitPat__Group_2__17862);
            rule__BitPat__Group_2__1__Impl();

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
    // $ANTLR end "rule__BitPat__Group_2__1"


    // $ANTLR start "rule__BitPat__Group_2__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3904:1: rule__BitPat__Group_2__1__Impl : ( ( rule__BitPat__BitpatAssignment_2_1 ) ) ;
    public final void rule__BitPat__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3908:1: ( ( ( rule__BitPat__BitpatAssignment_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3909:1: ( ( rule__BitPat__BitpatAssignment_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3909:1: ( ( rule__BitPat__BitpatAssignment_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3910:1: ( rule__BitPat__BitpatAssignment_2_1 )
            {
             before(grammarAccess.getBitPatAccess().getBitpatAssignment_2_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3911:1: ( rule__BitPat__BitpatAssignment_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3911:2: rule__BitPat__BitpatAssignment_2_1
            {
            pushFollow(FOLLOW_rule__BitPat__BitpatAssignment_2_1_in_rule__BitPat__Group_2__1__Impl7889);
            rule__BitPat__BitpatAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getBitPatAccess().getBitpatAssignment_2_1()); 

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
    // $ANTLR end "rule__BitPat__Group_2__1__Impl"


    // $ANTLR start "rule__PrimBitPat__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3925:1: rule__PrimBitPat__Group_1__0 : rule__PrimBitPat__Group_1__0__Impl rule__PrimBitPat__Group_1__1 ;
    public final void rule__PrimBitPat__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3929:1: ( rule__PrimBitPat__Group_1__0__Impl rule__PrimBitPat__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3930:2: rule__PrimBitPat__Group_1__0__Impl rule__PrimBitPat__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimBitPat__Group_1__0__Impl_in_rule__PrimBitPat__Group_1__07923);
            rule__PrimBitPat__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimBitPat__Group_1__1_in_rule__PrimBitPat__Group_1__07926);
            rule__PrimBitPat__Group_1__1();

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
    // $ANTLR end "rule__PrimBitPat__Group_1__0"


    // $ANTLR start "rule__PrimBitPat__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3937:1: rule__PrimBitPat__Group_1__0__Impl : ( ruleQid ) ;
    public final void rule__PrimBitPat__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3941:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3942:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3942:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3943:1: ruleQid
            {
             before(grammarAccess.getPrimBitPatAccess().getQidParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQid_in_rule__PrimBitPat__Group_1__0__Impl7953);
            ruleQid();

            state._fsp--;

             after(grammarAccess.getPrimBitPatAccess().getQidParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__PrimBitPat__Group_1__0__Impl"


    // $ANTLR start "rule__PrimBitPat__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3954:1: rule__PrimBitPat__Group_1__1 : rule__PrimBitPat__Group_1__1__Impl ;
    public final void rule__PrimBitPat__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3958:1: ( rule__PrimBitPat__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3959:2: rule__PrimBitPat__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimBitPat__Group_1__1__Impl_in_rule__PrimBitPat__Group_1__17982);
            rule__PrimBitPat__Group_1__1__Impl();

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
    // $ANTLR end "rule__PrimBitPat__Group_1__1"


    // $ANTLR start "rule__PrimBitPat__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3965:1: rule__PrimBitPat__Group_1__1__Impl : ( ( ruleBitPatOrInt )? ) ;
    public final void rule__PrimBitPat__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3969:1: ( ( ( ruleBitPatOrInt )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3970:1: ( ( ruleBitPatOrInt )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3970:1: ( ( ruleBitPatOrInt )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3971:1: ( ruleBitPatOrInt )?
            {
             before(grammarAccess.getPrimBitPatAccess().getBitPatOrIntParserRuleCall_1_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3972:1: ( ruleBitPatOrInt )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==31||LA32_0==33) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3972:3: ruleBitPatOrInt
                    {
                    pushFollow(FOLLOW_ruleBitPatOrInt_in_rule__PrimBitPat__Group_1__1__Impl8010);
                    ruleBitPatOrInt();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPrimBitPatAccess().getBitPatOrIntParserRuleCall_1_1()); 

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
    // $ANTLR end "rule__PrimBitPat__Group_1__1__Impl"


    // $ANTLR start "rule__BitPatOrInt__Group_0__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3986:1: rule__BitPatOrInt__Group_0__0 : rule__BitPatOrInt__Group_0__0__Impl rule__BitPatOrInt__Group_0__1 ;
    public final void rule__BitPatOrInt__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3990:1: ( rule__BitPatOrInt__Group_0__0__Impl rule__BitPatOrInt__Group_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3991:2: rule__BitPatOrInt__Group_0__0__Impl rule__BitPatOrInt__Group_0__1
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__0__Impl_in_rule__BitPatOrInt__Group_0__08045);
            rule__BitPatOrInt__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__1_in_rule__BitPatOrInt__Group_0__08048);
            rule__BitPatOrInt__Group_0__1();

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
    // $ANTLR end "rule__BitPatOrInt__Group_0__0"


    // $ANTLR start "rule__BitPatOrInt__Group_0__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3998:1: rule__BitPatOrInt__Group_0__0__Impl : ( ':' ) ;
    public final void rule__BitPatOrInt__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4002:1: ( ( ':' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4003:1: ( ':' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4003:1: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4004:1: ':'
            {
             before(grammarAccess.getBitPatOrIntAccess().getColonKeyword_0_0()); 
            match(input,31,FOLLOW_31_in_rule__BitPatOrInt__Group_0__0__Impl8076); 
             after(grammarAccess.getBitPatOrIntAccess().getColonKeyword_0_0()); 

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
    // $ANTLR end "rule__BitPatOrInt__Group_0__0__Impl"


    // $ANTLR start "rule__BitPatOrInt__Group_0__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4017:1: rule__BitPatOrInt__Group_0__1 : rule__BitPatOrInt__Group_0__1__Impl ;
    public final void rule__BitPatOrInt__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4021:1: ( rule__BitPatOrInt__Group_0__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4022:2: rule__BitPatOrInt__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__1__Impl_in_rule__BitPatOrInt__Group_0__18107);
            rule__BitPatOrInt__Group_0__1__Impl();

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
    // $ANTLR end "rule__BitPatOrInt__Group_0__1"


    // $ANTLR start "rule__BitPatOrInt__Group_0__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4028:1: rule__BitPatOrInt__Group_0__1__Impl : ( rulePOSINT ) ;
    public final void rule__BitPatOrInt__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4032:1: ( ( rulePOSINT ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4033:1: ( rulePOSINT )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4033:1: ( rulePOSINT )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4034:1: rulePOSINT
            {
             before(grammarAccess.getBitPatOrIntAccess().getPOSINTParserRuleCall_0_1()); 
            pushFollow(FOLLOW_rulePOSINT_in_rule__BitPatOrInt__Group_0__1__Impl8134);
            rulePOSINT();

            state._fsp--;

             after(grammarAccess.getBitPatOrIntAccess().getPOSINTParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__BitPatOrInt__Group_0__1__Impl"


    // $ANTLR start "rule__BitPatOrInt__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4049:1: rule__BitPatOrInt__Group_1__0 : rule__BitPatOrInt__Group_1__0__Impl rule__BitPatOrInt__Group_1__1 ;
    public final void rule__BitPatOrInt__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4053:1: ( rule__BitPatOrInt__Group_1__0__Impl rule__BitPatOrInt__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4054:2: rule__BitPatOrInt__Group_1__0__Impl rule__BitPatOrInt__Group_1__1
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__0__Impl_in_rule__BitPatOrInt__Group_1__08167);
            rule__BitPatOrInt__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__1_in_rule__BitPatOrInt__Group_1__08170);
            rule__BitPatOrInt__Group_1__1();

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
    // $ANTLR end "rule__BitPatOrInt__Group_1__0"


    // $ANTLR start "rule__BitPatOrInt__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4061:1: rule__BitPatOrInt__Group_1__0__Impl : ( '@' ) ;
    public final void rule__BitPatOrInt__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4065:1: ( ( '@' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4066:1: ( '@' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4066:1: ( '@' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4067:1: '@'
            {
             before(grammarAccess.getBitPatOrIntAccess().getCommercialAtKeyword_1_0()); 
            match(input,33,FOLLOW_33_in_rule__BitPatOrInt__Group_1__0__Impl8198); 
             after(grammarAccess.getBitPatOrIntAccess().getCommercialAtKeyword_1_0()); 

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
    // $ANTLR end "rule__BitPatOrInt__Group_1__0__Impl"


    // $ANTLR start "rule__BitPatOrInt__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4080:1: rule__BitPatOrInt__Group_1__1 : rule__BitPatOrInt__Group_1__1__Impl ;
    public final void rule__BitPatOrInt__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4084:1: ( rule__BitPatOrInt__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4085:2: rule__BitPatOrInt__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__1__Impl_in_rule__BitPatOrInt__Group_1__18229);
            rule__BitPatOrInt__Group_1__1__Impl();

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
    // $ANTLR end "rule__BitPatOrInt__Group_1__1"


    // $ANTLR start "rule__BitPatOrInt__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4091:1: rule__BitPatOrInt__Group_1__1__Impl : ( ruleBITSTR ) ;
    public final void rule__BitPatOrInt__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4095:1: ( ( ruleBITSTR ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4096:1: ( ruleBITSTR )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4096:1: ( ruleBITSTR )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4097:1: ruleBITSTR
            {
             before(grammarAccess.getBitPatOrIntAccess().getBITSTRParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleBITSTR_in_rule__BitPatOrInt__Group_1__1__Impl8256);
            ruleBITSTR();

            state._fsp--;

             after(grammarAccess.getBitPatOrIntAccess().getBITSTRParserRuleCall_1_1()); 

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
    // $ANTLR end "rule__BitPatOrInt__Group_1__1__Impl"


    // $ANTLR start "rule__POSINT__Group_0__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4112:1: rule__POSINT__Group_0__0 : rule__POSINT__Group_0__0__Impl rule__POSINT__Group_0__1 ;
    public final void rule__POSINT__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4116:1: ( rule__POSINT__Group_0__0__Impl rule__POSINT__Group_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4117:2: rule__POSINT__Group_0__0__Impl rule__POSINT__Group_0__1
            {
            pushFollow(FOLLOW_rule__POSINT__Group_0__0__Impl_in_rule__POSINT__Group_0__08289);
            rule__POSINT__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__POSINT__Group_0__1_in_rule__POSINT__Group_0__08292);
            rule__POSINT__Group_0__1();

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
    // $ANTLR end "rule__POSINT__Group_0__0"


    // $ANTLR start "rule__POSINT__Group_0__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4124:1: rule__POSINT__Group_0__0__Impl : ( '+' ) ;
    public final void rule__POSINT__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4128:1: ( ( '+' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4129:1: ( '+' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4129:1: ( '+' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4130:1: '+'
            {
             before(grammarAccess.getPOSINTAccess().getPlusSignKeyword_0_0()); 
            match(input,34,FOLLOW_34_in_rule__POSINT__Group_0__0__Impl8320); 
             after(grammarAccess.getPOSINTAccess().getPlusSignKeyword_0_0()); 

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
    // $ANTLR end "rule__POSINT__Group_0__0__Impl"


    // $ANTLR start "rule__POSINT__Group_0__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4143:1: rule__POSINT__Group_0__1 : rule__POSINT__Group_0__1__Impl ;
    public final void rule__POSINT__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4147:1: ( rule__POSINT__Group_0__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4148:2: rule__POSINT__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__POSINT__Group_0__1__Impl_in_rule__POSINT__Group_0__18351);
            rule__POSINT__Group_0__1__Impl();

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
    // $ANTLR end "rule__POSINT__Group_0__1"


    // $ANTLR start "rule__POSINT__Group_0__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4154:1: rule__POSINT__Group_0__1__Impl : ( ruleNUM ) ;
    public final void rule__POSINT__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4158:1: ( ( ruleNUM ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4159:1: ( ruleNUM )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4159:1: ( ruleNUM )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4160:1: ruleNUM
            {
             before(grammarAccess.getPOSINTAccess().getNUMParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleNUM_in_rule__POSINT__Group_0__1__Impl8378);
            ruleNUM();

            state._fsp--;

             after(grammarAccess.getPOSINTAccess().getNUMParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__POSINT__Group_0__1__Impl"


    // $ANTLR start "rule__NEGINT__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4175:1: rule__NEGINT__Group__0 : rule__NEGINT__Group__0__Impl rule__NEGINT__Group__1 ;
    public final void rule__NEGINT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4179:1: ( rule__NEGINT__Group__0__Impl rule__NEGINT__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4180:2: rule__NEGINT__Group__0__Impl rule__NEGINT__Group__1
            {
            pushFollow(FOLLOW_rule__NEGINT__Group__0__Impl_in_rule__NEGINT__Group__08411);
            rule__NEGINT__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NEGINT__Group__1_in_rule__NEGINT__Group__08414);
            rule__NEGINT__Group__1();

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
    // $ANTLR end "rule__NEGINT__Group__0"


    // $ANTLR start "rule__NEGINT__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4187:1: rule__NEGINT__Group__0__Impl : ( '~' ) ;
    public final void rule__NEGINT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4191:1: ( ( '~' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4192:1: ( '~' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4192:1: ( '~' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4193:1: '~'
            {
             before(grammarAccess.getNEGINTAccess().getTildeKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__NEGINT__Group__0__Impl8442); 
             after(grammarAccess.getNEGINTAccess().getTildeKeyword_0()); 

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
    // $ANTLR end "rule__NEGINT__Group__0__Impl"


    // $ANTLR start "rule__NEGINT__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4206:1: rule__NEGINT__Group__1 : rule__NEGINT__Group__1__Impl ;
    public final void rule__NEGINT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4210:1: ( rule__NEGINT__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4211:2: rule__NEGINT__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NEGINT__Group__1__Impl_in_rule__NEGINT__Group__18473);
            rule__NEGINT__Group__1__Impl();

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
    // $ANTLR end "rule__NEGINT__Group__1"


    // $ANTLR start "rule__NEGINT__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4217:1: rule__NEGINT__Group__1__Impl : ( ruleNUM ) ;
    public final void rule__NEGINT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4221:1: ( ( ruleNUM ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4222:1: ( ruleNUM )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4222:1: ( ruleNUM )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4223:1: ruleNUM
            {
             before(grammarAccess.getNEGINTAccess().getNUMParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleNUM_in_rule__NEGINT__Group__1__Impl8500);
            ruleNUM();

            state._fsp--;

             after(grammarAccess.getNEGINTAccess().getNUMParserRuleCall_1()); 

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
    // $ANTLR end "rule__NEGINT__Group__1__Impl"


    // $ANTLR start "rule__HEXNUM__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4238:1: rule__HEXNUM__Group__0 : rule__HEXNUM__Group__0__Impl rule__HEXNUM__Group__1 ;
    public final void rule__HEXNUM__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4242:1: ( rule__HEXNUM__Group__0__Impl rule__HEXNUM__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4243:2: rule__HEXNUM__Group__0__Impl rule__HEXNUM__Group__1
            {
            pushFollow(FOLLOW_rule__HEXNUM__Group__0__Impl_in_rule__HEXNUM__Group__08533);
            rule__HEXNUM__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__HEXNUM__Group__1_in_rule__HEXNUM__Group__08536);
            rule__HEXNUM__Group__1();

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
    // $ANTLR end "rule__HEXNUM__Group__0"


    // $ANTLR start "rule__HEXNUM__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4250:1: rule__HEXNUM__Group__0__Impl : ( '0x' ) ;
    public final void rule__HEXNUM__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4254:1: ( ( '0x' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4255:1: ( '0x' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4255:1: ( '0x' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4256:1: '0x'
            {
             before(grammarAccess.getHEXNUMAccess().getXKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__HEXNUM__Group__0__Impl8564); 
             after(grammarAccess.getHEXNUMAccess().getXKeyword_0()); 

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
    // $ANTLR end "rule__HEXNUM__Group__0__Impl"


    // $ANTLR start "rule__HEXNUM__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4269:1: rule__HEXNUM__Group__1 : rule__HEXNUM__Group__1__Impl ;
    public final void rule__HEXNUM__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4273:1: ( rule__HEXNUM__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4274:2: rule__HEXNUM__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__HEXNUM__Group__1__Impl_in_rule__HEXNUM__Group__18595);
            rule__HEXNUM__Group__1__Impl();

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
    // $ANTLR end "rule__HEXNUM__Group__1"


    // $ANTLR start "rule__HEXNUM__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4280:1: rule__HEXNUM__Group__1__Impl : ( ( ( RULE_HEXDIGIT ) ) ( ( RULE_HEXDIGIT )* ) ) ;
    public final void rule__HEXNUM__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4284:1: ( ( ( ( RULE_HEXDIGIT ) ) ( ( RULE_HEXDIGIT )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4285:1: ( ( ( RULE_HEXDIGIT ) ) ( ( RULE_HEXDIGIT )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4285:1: ( ( ( RULE_HEXDIGIT ) ) ( ( RULE_HEXDIGIT )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4286:1: ( ( RULE_HEXDIGIT ) ) ( ( RULE_HEXDIGIT )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4286:1: ( ( RULE_HEXDIGIT ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4287:1: ( RULE_HEXDIGIT )
            {
             before(grammarAccess.getHEXNUMAccess().getHEXDIGITTerminalRuleCall_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4288:1: ( RULE_HEXDIGIT )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4288:3: RULE_HEXDIGIT
            {
            match(input,RULE_HEXDIGIT,FOLLOW_RULE_HEXDIGIT_in_rule__HEXNUM__Group__1__Impl8625); 

            }

             after(grammarAccess.getHEXNUMAccess().getHEXDIGITTerminalRuleCall_1()); 

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4291:1: ( ( RULE_HEXDIGIT )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4292:1: ( RULE_HEXDIGIT )*
            {
             before(grammarAccess.getHEXNUMAccess().getHEXDIGITTerminalRuleCall_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4293:1: ( RULE_HEXDIGIT )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_HEXDIGIT) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4293:3: RULE_HEXDIGIT
            	    {
            	    match(input,RULE_HEXDIGIT,FOLLOW_RULE_HEXDIGIT_in_rule__HEXNUM__Group__1__Impl8638); 

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getHEXNUMAccess().getHEXDIGITTerminalRuleCall_1()); 

            }


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
    // $ANTLR end "rule__HEXNUM__Group__1__Impl"


    // $ANTLR start "rule__CONS__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4309:1: rule__CONS__Group__0 : rule__CONS__Group__0__Impl rule__CONS__Group__1 ;
    public final void rule__CONS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4313:1: ( rule__CONS__Group__0__Impl rule__CONS__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4314:2: rule__CONS__Group__0__Impl rule__CONS__Group__1
            {
            pushFollow(FOLLOW_rule__CONS__Group__0__Impl_in_rule__CONS__Group__08676);
            rule__CONS__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CONS__Group__1_in_rule__CONS__Group__08679);
            rule__CONS__Group__1();

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
    // $ANTLR end "rule__CONS__Group__0"


    // $ANTLR start "rule__CONS__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4321:1: rule__CONS__Group__0__Impl : ( RULE_CONSTART ) ;
    public final void rule__CONS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4325:1: ( ( RULE_CONSTART ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4326:1: ( RULE_CONSTART )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4326:1: ( RULE_CONSTART )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4327:1: RULE_CONSTART
            {
             before(grammarAccess.getCONSAccess().getCONSTARTTerminalRuleCall_0()); 
            match(input,RULE_CONSTART,FOLLOW_RULE_CONSTART_in_rule__CONS__Group__0__Impl8706); 
             after(grammarAccess.getCONSAccess().getCONSTARTTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__CONS__Group__0__Impl"


    // $ANTLR start "rule__CONS__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4338:1: rule__CONS__Group__1 : rule__CONS__Group__1__Impl ;
    public final void rule__CONS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4342:1: ( rule__CONS__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4343:2: rule__CONS__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__CONS__Group__1__Impl_in_rule__CONS__Group__18735);
            rule__CONS__Group__1__Impl();

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
    // $ANTLR end "rule__CONS__Group__1"


    // $ANTLR start "rule__CONS__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4349:1: rule__CONS__Group__1__Impl : ( ( RULE_IDCHAR )* ) ;
    public final void rule__CONS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4353:1: ( ( ( RULE_IDCHAR )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4354:1: ( ( RULE_IDCHAR )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4354:1: ( ( RULE_IDCHAR )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4355:1: ( RULE_IDCHAR )*
            {
             before(grammarAccess.getCONSAccess().getIDCHARTerminalRuleCall_1()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4356:1: ( RULE_IDCHAR )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_IDCHAR) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4356:3: RULE_IDCHAR
            	    {
            	    match(input,RULE_IDCHAR,FOLLOW_RULE_IDCHAR_in_rule__CONS__Group__1__Impl8763); 

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getCONSAccess().getIDCHARTerminalRuleCall_1()); 

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
    // $ANTLR end "rule__CONS__Group__1__Impl"


    // $ANTLR start "rule__Model__DeclAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4371:1: rule__Model__DeclAssignment_0 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4375:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4376:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4376:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4377:1: ruleDecl
            {
             before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_08803);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4386:1: rule__Model__DeclAssignment_1_1 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4390:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4391:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4391:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4392:1: ruleDecl
            {
             before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_18834);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4401:1: rule__DeclGranularity__NameAssignment_0 : ( ( 'granularity' ) ) ;
    public final void rule__DeclGranularity__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4405:1: ( ( ( 'granularity' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4406:1: ( ( 'granularity' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4406:1: ( ( 'granularity' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4407:1: ( 'granularity' )
            {
             before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4408:1: ( 'granularity' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4409:1: 'granularity'
            {
             before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            match(input,37,FOLLOW_37_in_rule__DeclGranularity__NameAssignment_08870); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4424:1: rule__DeclGranularity__GranularityAssignment_2 : ( ruleInt ) ;
    public final void rule__DeclGranularity__GranularityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4428:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4429:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4429:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4430:1: ruleInt
            {
             before(grammarAccess.getDeclGranularityAccess().getGranularityIntParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInt_in_rule__DeclGranularity__GranularityAssignment_28909);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4439:1: rule__DeclExport__NameAssignment_0 : ( ( 'export' ) ) ;
    public final void rule__DeclExport__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4443:1: ( ( ( 'export' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4444:1: ( ( 'export' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4444:1: ( ( 'export' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4445:1: ( 'export' )
            {
             before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4446:1: ( 'export' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4447:1: 'export'
            {
             before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            match(input,38,FOLLOW_38_in_rule__DeclExport__NameAssignment_08945); 
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4462:1: rule__DeclExport__ExportsAssignment_2 : ( ruleExport ) ;
    public final void rule__DeclExport__ExportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4466:1: ( ( ruleExport ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4467:1: ( ruleExport )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4467:1: ( ruleExport )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4468:1: ruleExport
            {
             before(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_28984);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4477:1: rule__DeclType__NameAssignment_0_1 : ( ruleName ) ;
    public final void rule__DeclType__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4481:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4482:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4482:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4483:1: ruleName
            {
             before(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__NameAssignment_0_19015);
            ruleName();

            state._fsp--;

             after(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_0_1_0()); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4492:1: rule__DeclType__ValueAssignment_0_3 : ( ( rule__DeclType__ValueAlternatives_0_3_0 ) ) ;
    public final void rule__DeclType__ValueAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4496:1: ( ( ( rule__DeclType__ValueAlternatives_0_3_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4497:1: ( ( rule__DeclType__ValueAlternatives_0_3_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4497:1: ( ( rule__DeclType__ValueAlternatives_0_3_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4498:1: ( rule__DeclType__ValueAlternatives_0_3_0 )
            {
             before(grammarAccess.getDeclTypeAccess().getValueAlternatives_0_3_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4499:1: ( rule__DeclType__ValueAlternatives_0_3_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4499:2: rule__DeclType__ValueAlternatives_0_3_0
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAlternatives_0_3_0_in_rule__DeclType__ValueAssignment_0_39046);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4508:1: rule__DeclType__NameAssignment_1_1 : ( ruleName ) ;
    public final void rule__DeclType__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4512:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4513:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4513:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4514:1: ruleName
            {
             before(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__NameAssignment_1_19079);
            ruleName();

            state._fsp--;

             after(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_1_1_0()); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4523:1: rule__DeclType__AttrNameAssignment_1_3 : ( ruleName ) ;
    public final void rule__DeclType__AttrNameAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4527:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4528:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4528:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4529:1: ruleName
            {
             before(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_1_39110);
            ruleName();

            state._fsp--;

             after(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_1_3_0()); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4538:1: rule__DeclType__AttrNameAssignment_1_4_1 : ( ruleName ) ;
    public final void rule__DeclType__AttrNameAssignment_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4542:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4543:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4543:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4544:1: ruleName
            {
             before(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_1_4_1_0()); 
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_1_4_19141);
            ruleName();

            state._fsp--;

             after(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_1_4_1_0()); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4553:1: rule__DeclType__ValueAssignment_1_7 : ( ruleConDecls ) ;
    public final void rule__DeclType__ValueAssignment_1_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4557:1: ( ( ruleConDecls ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4558:1: ( ruleConDecls )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4558:1: ( ruleConDecls )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4559:1: ruleConDecls
            {
             before(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_1_7_0()); 
            pushFollow(FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_1_79172);
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


    // $ANTLR start "rule__DeclVal__NameAssignment_0_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4568:1: rule__DeclVal__NameAssignment_0_1 : ( ( rule__DeclVal__NameAlternatives_0_1_0 ) ) ;
    public final void rule__DeclVal__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4572:1: ( ( ( rule__DeclVal__NameAlternatives_0_1_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4573:1: ( ( rule__DeclVal__NameAlternatives_0_1_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4573:1: ( ( rule__DeclVal__NameAlternatives_0_1_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4574:1: ( rule__DeclVal__NameAlternatives_0_1_0 )
            {
             before(grammarAccess.getDeclValAccess().getNameAlternatives_0_1_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4575:1: ( rule__DeclVal__NameAlternatives_0_1_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4575:2: rule__DeclVal__NameAlternatives_0_1_0
            {
            pushFollow(FOLLOW_rule__DeclVal__NameAlternatives_0_1_0_in_rule__DeclVal__NameAssignment_0_19203);
            rule__DeclVal__NameAlternatives_0_1_0();

            state._fsp--;


            }

             after(grammarAccess.getDeclValAccess().getNameAlternatives_0_1_0()); 

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
    // $ANTLR end "rule__DeclVal__NameAssignment_0_1"


    // $ANTLR start "rule__DeclVal__AttrAssignment_0_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4584:1: rule__DeclVal__AttrAssignment_0_2 : ( ruleName ) ;
    public final void rule__DeclVal__AttrAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4588:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4589:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4589:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4590:1: ruleName
            {
             before(grammarAccess.getDeclValAccess().getAttrNameParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_ruleName_in_rule__DeclVal__AttrAssignment_0_29236);
            ruleName();

            state._fsp--;

             after(grammarAccess.getDeclValAccess().getAttrNameParserRuleCall_0_2_0()); 

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
    // $ANTLR end "rule__DeclVal__AttrAssignment_0_2"


    // $ANTLR start "rule__DeclVal__ExpAssignment_0_4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4599:1: rule__DeclVal__ExpAssignment_0_4 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4603:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4604:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4604:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4605:1: ruleExp
            {
             before(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_0_49267);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_0_4_0()); 

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
    // $ANTLR end "rule__DeclVal__ExpAssignment_0_4"


    // $ANTLR start "rule__DeclVal__NameAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4614:1: rule__DeclVal__NameAssignment_1_1 : ( ruleName ) ;
    public final void rule__DeclVal__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4618:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4619:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4619:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4620:1: ruleName
            {
             before(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_1_19298);
            ruleName();

            state._fsp--;

             after(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__DeclVal__NameAssignment_1_1"


    // $ANTLR start "rule__DeclVal__DecPatAssignment_1_3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4629:1: rule__DeclVal__DecPatAssignment_1_3 : ( ruleDecodePat ) ;
    public final void rule__DeclVal__DecPatAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4633:1: ( ( ruleDecodePat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4634:1: ( ruleDecodePat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4634:1: ( ruleDecodePat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4635:1: ruleDecodePat
            {
             before(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_39329);
            ruleDecodePat();

            state._fsp--;

             after(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_0()); 

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
    // $ANTLR end "rule__DeclVal__DecPatAssignment_1_3"


    // $ANTLR start "rule__DeclVal__ExpAssignment_1_5_0_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4644:1: rule__DeclVal__ExpAssignment_1_5_0_1 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpAssignment_1_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4648:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4649:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4649:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4650:1: ruleExp
            {
             before(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_5_0_1_0()); 
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_1_5_0_19360);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_5_0_1_0()); 

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
    // $ANTLR end "rule__DeclVal__ExpAssignment_1_5_0_1"


    // $ANTLR start "rule__DeclVal__ExpsAssignment_1_5_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4659:1: rule__DeclVal__ExpsAssignment_1_5_1_1 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpsAssignment_1_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4663:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4664:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4664:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4665:1: ruleExp
            {
             before(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_1_0()); 
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_19391);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_1_0()); 

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
    // $ANTLR end "rule__DeclVal__ExpsAssignment_1_5_1_1"


    // $ANTLR start "rule__DeclVal__ExpsAssignment_1_5_1_3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4674:1: rule__DeclVal__ExpsAssignment_1_5_1_3 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpsAssignment_1_5_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4678:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4679:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4679:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4680:1: ruleExp
            {
             before(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_3_0()); 
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_39422);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_3_0()); 

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
    // $ANTLR end "rule__DeclVal__ExpsAssignment_1_5_1_3"


    // $ANTLR start "rule__Export__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4689:1: rule__Export__NameAssignment_0 : ( ruleQid ) ;
    public final void rule__Export__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4693:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4694:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4694:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4695:1: ruleQid
            {
             before(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQid_in_rule__Export__NameAssignment_09453);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4704:1: rule__Export__AttrNameAssignment_1_1 : ( ruleName ) ;
    public final void rule__Export__AttrNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4708:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4709:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4709:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4710:1: ruleName
            {
             before(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_19484);
            ruleName();

            state._fsp--;

             after(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_1_0()); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4719:1: rule__Export__AttrNameAssignment_1_2_1 : ( ruleName ) ;
    public final void rule__Export__AttrNameAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4723:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4724:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4724:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4725:1: ruleName
            {
             before(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_2_1_0()); 
            pushFollow(FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_2_19515);
            ruleName();

            state._fsp--;

             after(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_2_1_0()); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4734:1: rule__ConDecls__ConDeclsAssignment_0 : ( ruleConDecl ) ;
    public final void rule__ConDecls__ConDeclsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4738:1: ( ( ruleConDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4739:1: ( ruleConDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4739:1: ( ruleConDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4740:1: ruleConDecl
            {
             before(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_09546);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4749:1: rule__ConDecls__ConDeclsAssignment_1_1 : ( ruleConDecl ) ;
    public final void rule__ConDecls__ConDeclsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4753:1: ( ( ruleConDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4754:1: ( ruleConDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4754:1: ( ruleConDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4755:1: ruleConDecl
            {
             before(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_1_19577);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4764:1: rule__ConDecl__NameAssignment_0 : ( ruleConBind ) ;
    public final void rule__ConDecl__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4768:1: ( ( ruleConBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4769:1: ( ruleConBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4769:1: ( ruleConBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4770:1: ruleConBind
            {
             before(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleConBind_in_rule__ConDecl__NameAssignment_09608);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4779:1: rule__ConDecl__TyAssignment_1_1 : ( ruleTy ) ;
    public final void rule__ConDecl__TyAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4783:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4784:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4784:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4785:1: ruleTy
            {
             before(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleTy_in_rule__ConDecl__TyAssignment_1_19639);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4794:1: rule__Ty__ValueAssignment_0 : ( ruleInt ) ;
    public final void rule__Ty__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4798:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4799:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4799:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4800:1: ruleInt
            {
             before(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_09670);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4809:1: rule__Ty__ValueAssignment_1_1 : ( ruleInt ) ;
    public final void rule__Ty__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4813:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4814:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4814:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4815:1: ruleInt
            {
             before(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_1_19701);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4824:1: rule__Ty__ValueAssignment_2_0 : ( ruleQid ) ;
    public final void rule__Ty__ValueAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4828:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4829:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4829:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4830:1: ruleQid
            {
             before(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleQid_in_rule__Ty__ValueAssignment_2_09732);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4839:1: rule__Ty__TyBindAssignment_2_1_1 : ( ruleTyBind ) ;
    public final void rule__Ty__TyBindAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4843:1: ( ( ruleTyBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4844:1: ( ruleTyBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4844:1: ( ruleTyBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4845:1: ruleTyBind
            {
             before(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_19763);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4854:1: rule__Ty__TyBindAssignment_2_1_2_1 : ( ruleTyBind ) ;
    public final void rule__Ty__TyBindAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4858:1: ( ( ruleTyBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4859:1: ( ruleTyBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4859:1: ( ruleTyBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4860:1: ruleTyBind
            {
             before(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_2_19794);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4869:1: rule__Ty__ElementsAssignment_3_1 : ( ruleTyElement ) ;
    public final void rule__Ty__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4873:1: ( ( ruleTyElement ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4874:1: ( ruleTyElement )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4874:1: ( ruleTyElement )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4875:1: ruleTyElement
            {
             before(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_19825);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4884:1: rule__Ty__ElementsAssignment_3_2_1 : ( ruleTyElement ) ;
    public final void rule__Ty__ElementsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4888:1: ( ( ruleTyElement ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4889:1: ( ruleTyElement )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4889:1: ( ruleTyElement )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4890:1: ruleTyElement
            {
             before(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_2_19856);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4899:1: rule__TyElement__NameAssignment_0 : ( ruleName ) ;
    public final void rule__TyElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4903:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4904:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4904:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4905:1: ruleName
            {
             before(grammarAccess.getTyElementAccess().getNameNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleName_in_rule__TyElement__NameAssignment_09887);
            ruleName();

            state._fsp--;

             after(grammarAccess.getTyElementAccess().getNameNameParserRuleCall_0_0()); 

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4914:1: rule__TyElement__ValueAssignment_2 : ( ruleTy ) ;
    public final void rule__TyElement__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4918:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4919:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4919:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4920:1: ruleTy
            {
             before(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleTy_in_rule__TyElement__ValueAssignment_29918);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4929:1: rule__TyBind__KeyAssignment_0 : ( ruleQid ) ;
    public final void rule__TyBind__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4933:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4934:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4934:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4935:1: ruleQid
            {
             before(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleQid_in_rule__TyBind__KeyAssignment_09949);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4944:1: rule__TyBind__ValueAssignment_1_1 : ( ruleTy ) ;
    public final void rule__TyBind__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4948:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4949:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4949:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4950:1: ruleTy
            {
             before(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleTy_in_rule__TyBind__ValueAssignment_1_19980);
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


    // $ANTLR start "rule__BitPat__BitpatAssignment_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4959:1: rule__BitPat__BitpatAssignment_1 : ( rulePrimBitPat ) ;
    public final void rule__BitPat__BitpatAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4963:1: ( ( rulePrimBitPat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4964:1: ( rulePrimBitPat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4964:1: ( rulePrimBitPat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4965:1: rulePrimBitPat
            {
             before(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_1_0()); 
            pushFollow(FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_110011);
            rulePrimBitPat();

            state._fsp--;

             after(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__BitPat__BitpatAssignment_1"


    // $ANTLR start "rule__BitPat__BitpatAssignment_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4974:1: rule__BitPat__BitpatAssignment_2_1 : ( rulePrimBitPat ) ;
    public final void rule__BitPat__BitpatAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4978:1: ( ( rulePrimBitPat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4979:1: ( rulePrimBitPat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4979:1: ( rulePrimBitPat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4980:1: rulePrimBitPat
            {
             before(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_2_110042);
            rulePrimBitPat();

            state._fsp--;

             after(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__BitPat__BitpatAssignment_2_1"


    // $ANTLR start "rule__TokPat__TokPatAssignment"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4989:1: rule__TokPat__TokPatAssignment : ( ( rule__TokPat__TokPatAlternatives_0 ) ) ;
    public final void rule__TokPat__TokPatAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4993:1: ( ( ( rule__TokPat__TokPatAlternatives_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4994:1: ( ( rule__TokPat__TokPatAlternatives_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4994:1: ( ( rule__TokPat__TokPatAlternatives_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4995:1: ( rule__TokPat__TokPatAlternatives_0 )
            {
             before(grammarAccess.getTokPatAccess().getTokPatAlternatives_0()); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4996:1: ( rule__TokPat__TokPatAlternatives_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4996:2: rule__TokPat__TokPatAlternatives_0
            {
            pushFollow(FOLLOW_rule__TokPat__TokPatAlternatives_0_in_rule__TokPat__TokPatAssignment10073);
            rule__TokPat__TokPatAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTokPatAccess().getTokPatAlternatives_0()); 

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
    // $ANTLR end "rule__TokPat__TokPatAssignment"

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
    public static final BitSet FOLLOW_rule__DeclVal__Alternatives_in_ruleDeclVal394 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_ruleDecodePat_in_entryRuleDecodePat781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecodePat788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecodePat__Alternatives_in_ruleDecodePat814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_entryRuleBitPat841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPat848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__0_in_ruleBitPat874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_entryRuleTokPat901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTokPat908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TokPat__TokPatAssignment_in_ruleTokPat934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimBitPat968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Alternatives_in_rulePrimBitPat994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPatOrInt1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Alternatives_in_ruleBitPatOrInt1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleExp1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_entryRuleInt1143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInt1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Int__Alternatives_in_ruleInt1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName1203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleName1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_entryRuleConBind1262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConBind1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConBind1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid1323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQid1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT1382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__POSINT__Alternatives_in_rulePOSINT1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_entryRuleNEGINT1442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNEGINT1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__0_in_ruleNEGINT1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_entryRuleNUM1502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUM1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DIG_in_ruleNUM1538 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_DIG_in_ruleNUM1551 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM1581 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXNUM1588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__0_in_ruleHEXNUM1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_entryRuleBITSTR1643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITSTR1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINARY_in_ruleBITSTR1679 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_RULE_BINARY_in_ruleBITSTR1692 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS1724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONS__Group__0_in_ruleCONS1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_rule__Decl__Alternatives1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__0_in_rule__DeclType__Alternatives1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__0_in_rule__DeclType__Alternatives1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_rule__DeclType__ValueAlternatives_0_3_01927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__DeclType__ValueAlternatives_0_3_01944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__0_in_rule__DeclVal__Alternatives1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__0_in_rule__DeclVal__Alternatives1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclVal__NameAlternatives_0_1_02027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYM_in_rule__DeclVal__NameAlternatives_0_1_02044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__0_in_rule__DeclVal__Alternatives_1_52076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_52096 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_52108 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_0_in_rule__Ty__Alternatives2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__0_in_rule__Ty__Alternatives2162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__0_in_rule__Ty__Alternatives2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__0_in_rule__Ty__Alternatives2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_rule__DecodePat__Alternatives2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_rule__DecodePat__Alternatives2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__TokPat__TokPatAlternatives_02280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__TokPat__TokPatAlternatives_02297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rule__PrimBitPat__Alternatives2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__0_in_rule__PrimBitPat__Alternatives2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__0_in_rule__BitPatOrInt__Alternatives2379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__0_in_rule__BitPatOrInt__Alternatives2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_rule__Int__Alternatives2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_rule__Int__Alternatives2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__POSINT__Group_0__0_in_rule__POSINT__Alternatives2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_rule__POSINT__Alternatives2497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02527 = new BitSet(new long[]{0x0000006004500000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl2557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl2614 = new BitSet(new long[]{0x0000006004500002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__02649 = new BitSet(new long[]{0x0000006004500000L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__02652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Model__Group_1__0__Impl2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__12714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__02775 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__02778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__12835 = new BitSet(new long[]{0x0000001C00000000L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__12838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclGranularity__Group__1__Impl2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__22897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl2924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__02960 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__02963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl2990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__13020 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__13023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclExport__Group__1__Impl3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__23082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl3109 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__0__Impl_in_rule__DeclType__Group_0__03146 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__1_in_rule__DeclType__Group_0__03149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__DeclType__Group_0__0__Impl3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__1__Impl_in_rule__DeclType__Group_0__13208 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__2_in_rule__DeclType__Group_0__13211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__NameAssignment_0_1_in_rule__DeclType__Group_0__1__Impl3238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__2__Impl_in_rule__DeclType__Group_0__23268 = new BitSet(new long[]{0x0000001C18000210L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__3_in_rule__DeclType__Group_0__23271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclType__Group_0__2__Impl3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_0__3__Impl_in_rule__DeclType__Group_0__33330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_0_3_in_rule__DeclType__Group_0__3__Impl3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__0__Impl_in_rule__DeclType__Group_1__03395 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__1_in_rule__DeclType__Group_1__03398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__DeclType__Group_1__0__Impl3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__1__Impl_in_rule__DeclType__Group_1__13457 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__2_in_rule__DeclType__Group_1__13460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__NameAssignment_1_1_in_rule__DeclType__Group_1__1__Impl3487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__2__Impl_in_rule__DeclType__Group_1__23517 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__3_in_rule__DeclType__Group_1__23520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DeclType__Group_1__2__Impl3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__3__Impl_in_rule__DeclType__Group_1__33579 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__4_in_rule__DeclType__Group_1__33582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__AttrNameAssignment_1_3_in_rule__DeclType__Group_1__3__Impl3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__4__Impl_in_rule__DeclType__Group_1__43639 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__5_in_rule__DeclType__Group_1__43642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1_4__0_in_rule__DeclType__Group_1__4__Impl3669 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__5__Impl_in_rule__DeclType__Group_1__53700 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__6_in_rule__DeclType__Group_1__53703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__DeclType__Group_1__5__Impl3731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__6__Impl_in_rule__DeclType__Group_1__63762 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__7_in_rule__DeclType__Group_1__63765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclType__Group_1__6__Impl3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1__7__Impl_in_rule__DeclType__Group_1__73824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_1_7_in_rule__DeclType__Group_1__7__Impl3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1_4__0__Impl_in_rule__DeclType__Group_1_4__03897 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1_4__1_in_rule__DeclType__Group_1_4__03900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__DeclType__Group_1_4__0__Impl3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_1_4__1__Impl_in_rule__DeclType__Group_1_4__13959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__AttrNameAssignment_1_4_1_in_rule__DeclType__Group_1_4__1__Impl3986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__0__Impl_in_rule__DeclVal__Group_0__04020 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__1_in_rule__DeclVal__Group_0__04023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DeclVal__Group_0__0__Impl4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__1__Impl_in_rule__DeclVal__Group_0__14082 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__2_in_rule__DeclVal__Group_0__14085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_0_1_in_rule__DeclVal__Group_0__1__Impl4112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__2__Impl_in_rule__DeclVal__Group_0__24142 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__3_in_rule__DeclVal__Group_0__24145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__AttrAssignment_0_2_in_rule__DeclVal__Group_0__2__Impl4172 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__3__Impl_in_rule__DeclVal__Group_0__34203 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__4_in_rule__DeclVal__Group_0__34206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclVal__Group_0__3__Impl4234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__4__Impl_in_rule__DeclVal__Group_0__44265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpAssignment_0_4_in_rule__DeclVal__Group_0__4__Impl4292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__0__Impl_in_rule__DeclVal__Group_1__04332 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__1_in_rule__DeclVal__Group_1__04335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DeclVal__Group_1__0__Impl4363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__1__Impl_in_rule__DeclVal__Group_1__14394 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__2_in_rule__DeclVal__Group_1__14397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_1_1_in_rule__DeclVal__Group_1__1__Impl4424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__2__Impl_in_rule__DeclVal__Group_1__24454 = new BitSet(new long[]{0x0000001D01000010L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__3_in_rule__DeclVal__Group_1__24457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DeclVal__Group_1__2__Impl4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__3__Impl_in_rule__DeclVal__Group_1__34516 = new BitSet(new long[]{0x0000001D01000010L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__4_in_rule__DeclVal__Group_1__34519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__DecPatAssignment_1_3_in_rule__DeclVal__Group_1__3__Impl4546 = new BitSet(new long[]{0x0000001D00000012L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__4__Impl_in_rule__DeclVal__Group_1__44577 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__5_in_rule__DeclVal__Group_1__44580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__DeclVal__Group_1__4__Impl4608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__5__Impl_in_rule__DeclVal__Group_1__54639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Alternatives_1_5_in_rule__DeclVal__Group_1__5__Impl4666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__0__Impl_in_rule__DeclVal__Group_1_5_0__04708 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__1_in_rule__DeclVal__Group_1_5_0__04711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclVal__Group_1_5_0__0__Impl4739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__1__Impl_in_rule__DeclVal__Group_1_5_0__14770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpAssignment_1_5_0_1_in_rule__DeclVal__Group_1_5_0__1__Impl4797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__0__Impl_in_rule__DeclVal__Group_1_5_1__04831 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__1_in_rule__DeclVal__Group_1_5_1__04834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__DeclVal__Group_1_5_1__0__Impl4862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__1__Impl_in_rule__DeclVal__Group_1_5_1__14893 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__2_in_rule__DeclVal__Group_1_5_1__14896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_1_in_rule__DeclVal__Group_1_5_1__1__Impl4923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__2__Impl_in_rule__DeclVal__Group_1_5_1__24953 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__3_in_rule__DeclVal__Group_1_5_1__24956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclVal__Group_1_5_1__2__Impl4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__3__Impl_in_rule__DeclVal__Group_1_5_1__35015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_3_in_rule__DeclVal__Group_1_5_1__3__Impl5042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__05080 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Export__Group__1_in_rule__Export__Group__05083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl5110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__15140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl5167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__05202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__05205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Export__Group_1__0__Impl5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__15264 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__15267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl5294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__25324 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__25327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl5354 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__35385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Export__Group_1__3__Impl5413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__05452 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__05455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Export__Group_1_2__0__Impl5483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__15514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl5541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__0__Impl_in_rule__ConDecls__Group__05575 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__1_in_rule__ConDecls__Group__05578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__ConDeclsAssignment_0_in_rule__ConDecls__Group__0__Impl5605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__1__Impl_in_rule__ConDecls__Group__15635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__0_in_rule__ConDecls__Group__1__Impl5662 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__0__Impl_in_rule__ConDecls__Group_1__05697 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__1_in_rule__ConDecls__Group_1__05700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ConDecls__Group_1__0__Impl5728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__1__Impl_in_rule__ConDecls__Group_1__15759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__ConDeclsAssignment_1_1_in_rule__ConDecls__Group_1__1__Impl5786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__0__Impl_in_rule__ConDecl__Group__05820 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__1_in_rule__ConDecl__Group__05823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__NameAssignment_0_in_rule__ConDecl__Group__0__Impl5850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__1__Impl_in_rule__ConDecl__Group__15880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__0_in_rule__ConDecl__Group__1__Impl5907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__0__Impl_in_rule__ConDecl__Group_1__05942 = new BitSet(new long[]{0x0000001C18000210L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__1_in_rule__ConDecl__Group_1__05945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ConDecl__Group_1__0__Impl5973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__1__Impl_in_rule__ConDecl__Group_1__16004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__TyAssignment_1_1_in_rule__ConDecl__Group_1__1__Impl6031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__0__Impl_in_rule__Ty__Group_1__06065 = new BitSet(new long[]{0x0000001C00000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__1_in_rule__Ty__Group_1__06068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Ty__Group_1__0__Impl6096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__1__Impl_in_rule__Ty__Group_1__16127 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__2_in_rule__Ty__Group_1__16130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_1_1_in_rule__Ty__Group_1__1__Impl6157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__2__Impl_in_rule__Ty__Group_1__26187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Ty__Group_1__2__Impl6215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__0__Impl_in_rule__Ty__Group_2__06252 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__1_in_rule__Ty__Group_2__06255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_2_0_in_rule__Ty__Group_2__0__Impl6282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__1__Impl_in_rule__Ty__Group_2__16312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__0_in_rule__Ty__Group_2__1__Impl6339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__0__Impl_in_rule__Ty__Group_2_1__06374 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__1_in_rule__Ty__Group_2_1__06377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Ty__Group_2_1__0__Impl6405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__1__Impl_in_rule__Ty__Group_2_1__16436 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__2_in_rule__Ty__Group_2_1__16439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__TyBindAssignment_2_1_1_in_rule__Ty__Group_2_1__1__Impl6466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__2__Impl_in_rule__Ty__Group_2_1__26496 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__3_in_rule__Ty__Group_2_1__26499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__0_in_rule__Ty__Group_2_1__2__Impl6526 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__3__Impl_in_rule__Ty__Group_2_1__36557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Ty__Group_2_1__3__Impl6585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__0__Impl_in_rule__Ty__Group_2_1_2__06624 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__1_in_rule__Ty__Group_2_1_2__06627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Ty__Group_2_1_2__0__Impl6655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__1__Impl_in_rule__Ty__Group_2_1_2__16686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__TyBindAssignment_2_1_2_1_in_rule__Ty__Group_2_1_2__1__Impl6713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__0__Impl_in_rule__Ty__Group_3__06747 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__1_in_rule__Ty__Group_3__06750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Ty__Group_3__0__Impl6778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__1__Impl_in_rule__Ty__Group_3__16809 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__2_in_rule__Ty__Group_3__16812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ElementsAssignment_3_1_in_rule__Ty__Group_3__1__Impl6839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__2__Impl_in_rule__Ty__Group_3__26869 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__3_in_rule__Ty__Group_3__26872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__0_in_rule__Ty__Group_3__2__Impl6899 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__3__Impl_in_rule__Ty__Group_3__36930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Ty__Group_3__3__Impl6958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__0__Impl_in_rule__Ty__Group_3_2__06997 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__1_in_rule__Ty__Group_3_2__07000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Ty__Group_3_2__0__Impl7028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__1__Impl_in_rule__Ty__Group_3_2__17059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ElementsAssignment_3_2_1_in_rule__Ty__Group_3_2__1__Impl7086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__0__Impl_in_rule__TyElement__Group__07120 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__TyElement__Group__1_in_rule__TyElement__Group__07123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__NameAssignment_0_in_rule__TyElement__Group__0__Impl7150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__1__Impl_in_rule__TyElement__Group__17180 = new BitSet(new long[]{0x0000001C18000210L});
    public static final BitSet FOLLOW_rule__TyElement__Group__2_in_rule__TyElement__Group__17183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__TyElement__Group__1__Impl7211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__2__Impl_in_rule__TyElement__Group__27242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__ValueAssignment_2_in_rule__TyElement__Group__2__Impl7269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__0__Impl_in_rule__TyBind__Group__07305 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__TyBind__Group__1_in_rule__TyBind__Group__07308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__KeyAssignment_0_in_rule__TyBind__Group__0__Impl7335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__1__Impl_in_rule__TyBind__Group__17365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__0_in_rule__TyBind__Group__1__Impl7392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__0__Impl_in_rule__TyBind__Group_1__07427 = new BitSet(new long[]{0x0000001C18000210L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__1_in_rule__TyBind__Group_1__07430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__TyBind__Group_1__0__Impl7458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__1__Impl_in_rule__TyBind__Group_1__17489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__ValueAssignment_1_1_in_rule__TyBind__Group_1__1__Impl7516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__0__Impl_in_rule__BitPat__Group__07550 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule__BitPat__Group__1_in_rule__BitPat__Group__07553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__BitPat__Group__0__Impl7581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__1__Impl_in_rule__BitPat__Group__17612 = new BitSet(new long[]{0x0000000102000000L});
    public static final BitSet FOLLOW_rule__BitPat__Group__2_in_rule__BitPat__Group__17615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__BitpatAssignment_1_in_rule__BitPat__Group__1__Impl7642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__2__Impl_in_rule__BitPat__Group__27672 = new BitSet(new long[]{0x0000000102000000L});
    public static final BitSet FOLLOW_rule__BitPat__Group__3_in_rule__BitPat__Group__27675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group_2__0_in_rule__BitPat__Group__2__Impl7702 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__3__Impl_in_rule__BitPat__Group__37733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__BitPat__Group__3__Impl7761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group_2__0__Impl_in_rule__BitPat__Group_2__07800 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_rule__BitPat__Group_2__1_in_rule__BitPat__Group_2__07803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__BitPat__Group_2__0__Impl7831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group_2__1__Impl_in_rule__BitPat__Group_2__17862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__BitpatAssignment_2_1_in_rule__BitPat__Group_2__1__Impl7889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__0__Impl_in_rule__PrimBitPat__Group_1__07923 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__1_in_rule__PrimBitPat__Group_1__07926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__PrimBitPat__Group_1__0__Impl7953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__1__Impl_in_rule__PrimBitPat__Group_1__17982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_rule__PrimBitPat__Group_1__1__Impl8010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__0__Impl_in_rule__BitPatOrInt__Group_0__08045 = new BitSet(new long[]{0x0000001400000000L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__1_in_rule__BitPatOrInt__Group_0__08048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__BitPatOrInt__Group_0__0__Impl8076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__1__Impl_in_rule__BitPatOrInt__Group_0__18107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_rule__BitPatOrInt__Group_0__1__Impl8134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__0__Impl_in_rule__BitPatOrInt__Group_1__08167 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__1_in_rule__BitPatOrInt__Group_1__08170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__BitPatOrInt__Group_1__0__Impl8198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__1__Impl_in_rule__BitPatOrInt__Group_1__18229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rule__BitPatOrInt__Group_1__1__Impl8256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__POSINT__Group_0__0__Impl_in_rule__POSINT__Group_0__08289 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__POSINT__Group_0__1_in_rule__POSINT__Group_0__08292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__POSINT__Group_0__0__Impl8320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__POSINT__Group_0__1__Impl_in_rule__POSINT__Group_0__18351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_rule__POSINT__Group_0__1__Impl8378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__0__Impl_in_rule__NEGINT__Group__08411 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__1_in_rule__NEGINT__Group__08414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__NEGINT__Group__0__Impl8442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__1__Impl_in_rule__NEGINT__Group__18473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_rule__NEGINT__Group__1__Impl8500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__0__Impl_in_rule__HEXNUM__Group__08533 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__1_in_rule__HEXNUM__Group__08536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__HEXNUM__Group__0__Impl8564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__1__Impl_in_rule__HEXNUM__Group__18595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXDIGIT_in_rule__HEXNUM__Group__1__Impl8625 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_RULE_HEXDIGIT_in_rule__HEXNUM__Group__1__Impl8638 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__CONS__Group__0__Impl_in_rule__CONS__Group__08676 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__CONS__Group__1_in_rule__CONS__Group__08679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CONSTART_in_rule__CONS__Group__0__Impl8706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONS__Group__1__Impl_in_rule__CONS__Group__18735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IDCHAR_in_rule__CONS__Group__1__Impl8763 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_08803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_18834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__DeclGranularity__NameAssignment_08870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__DeclGranularity__GranularityAssignment_28909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__DeclExport__NameAssignment_08945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_28984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__NameAssignment_0_19015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAlternatives_0_3_0_in_rule__DeclType__ValueAssignment_0_39046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__NameAssignment_1_19079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_1_39110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_1_4_19141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_1_79172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAlternatives_0_1_0_in_rule__DeclVal__NameAssignment_0_19203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclVal__AttrAssignment_0_29236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_0_49267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_1_19298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_39329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_1_5_0_19360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_19391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_39422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__Export__NameAssignment_09453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_19484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_2_19515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_09546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_1_19577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_rule__ConDecl__NameAssignment_09608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__ConDecl__TyAssignment_1_19639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_09670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_1_19701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__Ty__ValueAssignment_2_09732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_19763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_2_19794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_19825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_2_19856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__TyElement__NameAssignment_09887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__TyElement__ValueAssignment_29918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__TyBind__KeyAssignment_09949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__TyBind__ValueAssignment_1_19980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_110011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_2_110042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TokPat__TokPatAlternatives_0_in_rule__TokPat__TokPatAssignment10073 = new BitSet(new long[]{0x0000000000000002L});

}