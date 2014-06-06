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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalGDSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LHEXCHAR", "RULE_UHEXCHAR", "RULE_UNHEXCHAR", "RULE_LNHEXCHAR", "RULE_SLASH", "RULE_CHARSYM", "RULE_BINDIG", "RULE_BS", "RULE_DOT", "RULE_PIPE", "RULE_NBINDIG", "RULE_OTHERSYM", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'exptodo'", "';'", "'='", "'type'", "'['", "']'", "','", "'val'", "'{'", "'}'", "'of'", "':'", "'\\''", "'@'", "'~'", "'0x'", "'granularity'", "'export'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=18;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=17;
    public static final int RULE_BS=11;
    public static final int RULE_UNHEXCHAR=6;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int RULE_DOT=12;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int RULE_PIPE=13;
    public static final int T__36=36;
    public static final int RULE_OTHERSYM=15;
    public static final int RULE_NBINDIG=14;
    public static final int RULE_LNHEXCHAR=7;
    public static final int RULE_BINDIG=10;
    public static final int RULE_LHEXCHAR=4;
    public static final int RULE_SLASH=8;
    public static final int RULE_CHARSYM=9;
    public static final int RULE_WS=16;
    public static final int RULE_UHEXCHAR=5;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:62:1: ( ruleModel EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:63:1: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel67);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel74); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:70:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:74:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:75:1: ( ( rule__Model__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:75:1: ( ( rule__Model__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:76:1: ( rule__Model__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:77:1: ( rule__Model__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:77:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel100);
            rule__Model__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getGroup()); 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDecl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:89:1: entryRuleDecl : ruleDecl EOF ;
    public final void entryRuleDecl() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:90:1: ( ruleDecl EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:91:1: ruleDecl EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclRule()); 
            }
            pushFollow(FOLLOW_ruleDecl_in_entryRuleDecl127);
            ruleDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecl134); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:98:1: ruleDecl : ( ( rule__Decl__Alternatives ) ) ;
    public final void ruleDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:102:2: ( ( ( rule__Decl__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:103:1: ( ( rule__Decl__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:103:1: ( ( rule__Decl__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:104:1: ( rule__Decl__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:105:1: ( rule__Decl__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:105:2: rule__Decl__Alternatives
            {
            pushFollow(FOLLOW_rule__Decl__Alternatives_in_ruleDecl160);
            rule__Decl__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclAccess().getAlternatives()); 
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
    // $ANTLR end "ruleDecl"


    // $ANTLR start "entryRuleDeclGranularity"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:117:1: entryRuleDeclGranularity : ruleDeclGranularity EOF ;
    public final void entryRuleDeclGranularity() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:118:1: ( ruleDeclGranularity EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:119:1: ruleDeclGranularity EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityRule()); 
            }
            pushFollow(FOLLOW_ruleDeclGranularity_in_entryRuleDeclGranularity187);
            ruleDeclGranularity();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclGranularityRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclGranularity194); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:126:1: ruleDeclGranularity : ( ( rule__DeclGranularity__Group__0 ) ) ;
    public final void ruleDeclGranularity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:130:2: ( ( ( rule__DeclGranularity__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:131:1: ( ( rule__DeclGranularity__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:131:1: ( ( rule__DeclGranularity__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:132:1: ( rule__DeclGranularity__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:133:1: ( rule__DeclGranularity__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:133:2: rule__DeclGranularity__Group__0
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__0_in_ruleDeclGranularity220);
            rule__DeclGranularity__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclGranularityAccess().getGroup()); 
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
    // $ANTLR end "ruleDeclGranularity"


    // $ANTLR start "entryRuleDeclExport"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:145:1: entryRuleDeclExport : ruleDeclExport EOF ;
    public final void entryRuleDeclExport() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:146:1: ( ruleDeclExport EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:147:1: ruleDeclExport EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportRule()); 
            }
            pushFollow(FOLLOW_ruleDeclExport_in_entryRuleDeclExport247);
            ruleDeclExport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclExportRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclExport254); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:154:1: ruleDeclExport : ( ( rule__DeclExport__Group__0 ) ) ;
    public final void ruleDeclExport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:158:2: ( ( ( rule__DeclExport__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:159:1: ( ( rule__DeclExport__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:159:1: ( ( rule__DeclExport__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:160:1: ( rule__DeclExport__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:161:1: ( rule__DeclExport__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:161:2: rule__DeclExport__Group__0
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__0_in_ruleDeclExport280);
            rule__DeclExport__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclExportAccess().getGroup()); 
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
    // $ANTLR end "ruleDeclExport"


    // $ANTLR start "entryRuleDeclType"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:173:1: entryRuleDeclType : ruleDeclType EOF ;
    public final void entryRuleDeclType() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:174:1: ( ruleDeclType EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:175:1: ruleDeclType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDeclType_in_entryRuleDeclType307);
            ruleDeclType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclType314); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:182:1: ruleDeclType : ( ( rule__DeclType__Group__0 ) ) ;
    public final void ruleDeclType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:186:2: ( ( ( rule__DeclType__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:187:1: ( ( rule__DeclType__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:187:1: ( ( rule__DeclType__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:188:1: ( rule__DeclType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:189:1: ( rule__DeclType__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:189:2: rule__DeclType__Group__0
            {
            pushFollow(FOLLOW_rule__DeclType__Group__0_in_ruleDeclType340);
            rule__DeclType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getGroup()); 
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
    // $ANTLR end "ruleDeclType"


    // $ANTLR start "entryRuleDeclVal"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:201:1: entryRuleDeclVal : ruleDeclVal EOF ;
    public final void entryRuleDeclVal() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:202:1: ( ruleDeclVal EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:203:1: ruleDeclVal EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValRule()); 
            }
            pushFollow(FOLLOW_ruleDeclVal_in_entryRuleDeclVal367);
            ruleDeclVal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclVal374); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:210:1: ruleDeclVal : ( ( rule__DeclVal__Alternatives ) ) ;
    public final void ruleDeclVal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:214:2: ( ( ( rule__DeclVal__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:215:1: ( ( rule__DeclVal__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:215:1: ( ( rule__DeclVal__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:216:1: ( rule__DeclVal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:217:1: ( rule__DeclVal__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:217:2: rule__DeclVal__Alternatives
            {
            pushFollow(FOLLOW_rule__DeclVal__Alternatives_in_ruleDeclVal400);
            rule__DeclVal__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getAlternatives()); 
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
    // $ANTLR end "ruleDeclVal"


    // $ANTLR start "entryRuleExport"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:229:1: entryRuleExport : ruleExport EOF ;
    public final void entryRuleExport() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:230:1: ( ruleExport EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:231:1: ruleExport EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportRule()); 
            }
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport427);
            ruleExport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport434); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:238:1: ruleExport : ( ( rule__Export__Group__0 ) ) ;
    public final void ruleExport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:242:2: ( ( ( rule__Export__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:243:1: ( ( rule__Export__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:243:1: ( ( rule__Export__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:244:1: ( rule__Export__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:245:1: ( rule__Export__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:245:2: rule__Export__Group__0
            {
            pushFollow(FOLLOW_rule__Export__Group__0_in_ruleExport460);
            rule__Export__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getGroup()); 
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
    // $ANTLR end "ruleExport"


    // $ANTLR start "entryRuleConDecls"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:257:1: entryRuleConDecls : ruleConDecls EOF ;
    public final void entryRuleConDecls() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:258:1: ( ruleConDecls EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:259:1: ruleConDecls EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsRule()); 
            }
            pushFollow(FOLLOW_ruleConDecls_in_entryRuleConDecls487);
            ruleConDecls();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclsRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecls494); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:266:1: ruleConDecls : ( ( rule__ConDecls__Group__0 ) ) ;
    public final void ruleConDecls() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:270:2: ( ( ( rule__ConDecls__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:271:1: ( ( rule__ConDecls__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:271:1: ( ( rule__ConDecls__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:272:1: ( rule__ConDecls__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:273:1: ( rule__ConDecls__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:273:2: rule__ConDecls__Group__0
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__0_in_ruleConDecls520);
            rule__ConDecls__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclsAccess().getGroup()); 
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
    // $ANTLR end "ruleConDecls"


    // $ANTLR start "entryRuleConDecl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:285:1: entryRuleConDecl : ruleConDecl EOF ;
    public final void entryRuleConDecl() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:286:1: ( ruleConDecl EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:287:1: ruleConDecl EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclRule()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl547);
            ruleConDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl554); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:294:1: ruleConDecl : ( ( rule__ConDecl__Group__0 ) ) ;
    public final void ruleConDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:298:2: ( ( ( rule__ConDecl__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:299:1: ( ( rule__ConDecl__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:299:1: ( ( rule__ConDecl__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:300:1: ( rule__ConDecl__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:301:1: ( rule__ConDecl__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:301:2: rule__ConDecl__Group__0
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__0_in_ruleConDecl580);
            rule__ConDecl__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclAccess().getGroup()); 
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
    // $ANTLR end "ruleConDecl"


    // $ANTLR start "entryRuleTy"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:313:1: entryRuleTy : ruleTy EOF ;
    public final void entryRuleTy() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:314:1: ( ruleTy EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:315:1: ruleTy EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyRule()); 
            }
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy607);
            ruleTy();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy614); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:322:1: ruleTy : ( ( rule__Ty__Alternatives ) ) ;
    public final void ruleTy() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:326:2: ( ( ( rule__Ty__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:327:1: ( ( rule__Ty__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:327:1: ( ( rule__Ty__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:328:1: ( rule__Ty__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:329:1: ( rule__Ty__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:329:2: rule__Ty__Alternatives
            {
            pushFollow(FOLLOW_rule__Ty__Alternatives_in_ruleTy640);
            rule__Ty__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getAlternatives()); 
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
    // $ANTLR end "ruleTy"


    // $ANTLR start "entryRuleTyElement"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:341:1: entryRuleTyElement : ruleTyElement EOF ;
    public final void entryRuleTyElement() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:342:1: ( ruleTyElement EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:343:1: ruleTyElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementRule()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement667);
            ruleTyElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyElementRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement674); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:350:1: ruleTyElement : ( ( rule__TyElement__Group__0 ) ) ;
    public final void ruleTyElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:354:2: ( ( ( rule__TyElement__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:355:1: ( ( rule__TyElement__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:355:1: ( ( rule__TyElement__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:356:1: ( rule__TyElement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:357:1: ( rule__TyElement__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:357:2: rule__TyElement__Group__0
            {
            pushFollow(FOLLOW_rule__TyElement__Group__0_in_ruleTyElement700);
            rule__TyElement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyElementAccess().getGroup()); 
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
    // $ANTLR end "ruleTyElement"


    // $ANTLR start "entryRuleTyBind"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:369:1: entryRuleTyBind : ruleTyBind EOF ;
    public final void entryRuleTyBind() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:370:1: ( ruleTyBind EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:371:1: ruleTyBind EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindRule()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind727);
            ruleTyBind();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyBindRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind734); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:378:1: ruleTyBind : ( ( rule__TyBind__Group__0 ) ) ;
    public final void ruleTyBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:382:2: ( ( ( rule__TyBind__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:383:1: ( ( rule__TyBind__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:383:1: ( ( rule__TyBind__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:384:1: ( rule__TyBind__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:385:1: ( rule__TyBind__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:385:2: rule__TyBind__Group__0
            {
            pushFollow(FOLLOW_rule__TyBind__Group__0_in_ruleTyBind760);
            rule__TyBind__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyBindAccess().getGroup()); 
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
    // $ANTLR end "ruleTyBind"


    // $ANTLR start "entryRuleDecodePat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:397:1: entryRuleDecodePat : ruleDecodePat EOF ;
    public final void entryRuleDecodePat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:398:1: ( ruleDecodePat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:399:1: ruleDecodePat EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecodePatRule()); 
            }
            pushFollow(FOLLOW_ruleDecodePat_in_entryRuleDecodePat787);
            ruleDecodePat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecodePatRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecodePat794); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:406:1: ruleDecodePat : ( ( rule__DecodePat__Alternatives ) ) ;
    public final void ruleDecodePat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:410:2: ( ( ( rule__DecodePat__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:411:1: ( ( rule__DecodePat__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:411:1: ( ( rule__DecodePat__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:412:1: ( rule__DecodePat__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDecodePatAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:413:1: ( rule__DecodePat__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:413:2: rule__DecodePat__Alternatives
            {
            pushFollow(FOLLOW_rule__DecodePat__Alternatives_in_ruleDecodePat820);
            rule__DecodePat__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDecodePatAccess().getAlternatives()); 
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
    // $ANTLR end "ruleDecodePat"


    // $ANTLR start "entryRuleBitPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:425:1: entryRuleBitPat : ruleBitPat EOF ;
    public final void entryRuleBitPat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:426:1: ( ruleBitPat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:427:1: ruleBitPat EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatRule()); 
            }
            pushFollow(FOLLOW_ruleBitPat_in_entryRuleBitPat847);
            ruleBitPat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPat854); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:434:1: ruleBitPat : ( ( rule__BitPat__Group__0 ) ) ;
    public final void ruleBitPat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:438:2: ( ( ( rule__BitPat__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:439:1: ( ( rule__BitPat__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:439:1: ( ( rule__BitPat__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:440:1: ( rule__BitPat__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:441:1: ( rule__BitPat__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:441:2: rule__BitPat__Group__0
            {
            pushFollow(FOLLOW_rule__BitPat__Group__0_in_ruleBitPat880);
            rule__BitPat__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatAccess().getGroup()); 
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
    // $ANTLR end "ruleBitPat"


    // $ANTLR start "entryRuleTokPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:453:1: entryRuleTokPat : ruleTokPat EOF ;
    public final void entryRuleTokPat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:454:1: ( ruleTokPat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:455:1: ruleTokPat EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokPatRule()); 
            }
            pushFollow(FOLLOW_ruleTokPat_in_entryRuleTokPat907);
            ruleTokPat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokPatRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTokPat914); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:462:1: ruleTokPat : ( ( rule__TokPat__TokPatAssignment ) ) ;
    public final void ruleTokPat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:466:2: ( ( ( rule__TokPat__TokPatAssignment ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:467:1: ( ( rule__TokPat__TokPatAssignment ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:467:1: ( ( rule__TokPat__TokPatAssignment ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:468:1: ( rule__TokPat__TokPatAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokPatAccess().getTokPatAssignment()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:469:1: ( rule__TokPat__TokPatAssignment )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:469:2: rule__TokPat__TokPatAssignment
            {
            pushFollow(FOLLOW_rule__TokPat__TokPatAssignment_in_ruleTokPat940);
            rule__TokPat__TokPatAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokPatAccess().getTokPatAssignment()); 
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
    // $ANTLR end "ruleTokPat"


    // $ANTLR start "entryRulePrimBitPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:481:1: entryRulePrimBitPat : rulePrimBitPat EOF ;
    public final void entryRulePrimBitPat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:482:1: ( rulePrimBitPat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:483:1: rulePrimBitPat EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimBitPatRule()); 
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat967);
            rulePrimBitPat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimBitPatRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimBitPat974); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:490:1: rulePrimBitPat : ( ( rule__PrimBitPat__Alternatives ) ) ;
    public final void rulePrimBitPat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:494:2: ( ( ( rule__PrimBitPat__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:495:1: ( ( rule__PrimBitPat__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:495:1: ( ( rule__PrimBitPat__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:496:1: ( rule__PrimBitPat__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimBitPatAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:497:1: ( rule__PrimBitPat__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:497:2: rule__PrimBitPat__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimBitPat__Alternatives_in_rulePrimBitPat1000);
            rule__PrimBitPat__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimBitPatAccess().getAlternatives()); 
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
    // $ANTLR end "rulePrimBitPat"


    // $ANTLR start "entryRuleBitPatOrInt"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:509:1: entryRuleBitPatOrInt : ruleBitPatOrInt EOF ;
    public final void entryRuleBitPatOrInt() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:510:1: ( ruleBitPatOrInt EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:511:1: ruleBitPatOrInt EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntRule()); 
            }
            pushFollow(FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt1027);
            ruleBitPatOrInt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatOrIntRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPatOrInt1034); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:518:1: ruleBitPatOrInt : ( ( rule__BitPatOrInt__Alternatives ) ) ;
    public final void ruleBitPatOrInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:522:2: ( ( ( rule__BitPatOrInt__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:523:1: ( ( rule__BitPatOrInt__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:523:1: ( ( rule__BitPatOrInt__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:524:1: ( rule__BitPatOrInt__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:525:1: ( rule__BitPatOrInt__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:525:2: rule__BitPatOrInt__Alternatives
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Alternatives_in_ruleBitPatOrInt1060);
            rule__BitPatOrInt__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatOrIntAccess().getAlternatives()); 
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
    // $ANTLR end "ruleBitPatOrInt"


    // $ANTLR start "entryRuleExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:537:1: entryRuleExp : ruleExp EOF ;
    public final void entryRuleExp() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:538:1: ( ruleExp EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:539:1: ruleExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpRule()); 
            }
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp1087);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp1094); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:546:1: ruleExp : ( 'exptodo' ) ;
    public final void ruleExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:550:2: ( ( 'exptodo' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:551:1: ( 'exptodo' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:551:1: ( 'exptodo' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:552:1: 'exptodo'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpAccess().getExptodoKeyword()); 
            }
            match(input,19,FOLLOW_19_in_ruleExp1121); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpAccess().getExptodoKeyword()); 
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
    // $ANTLR end "ruleExp"


    // $ANTLR start "entryRuleInt"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:567:1: entryRuleInt : ruleInt EOF ;
    public final void entryRuleInt() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:568:1: ( ruleInt EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:569:1: ruleInt EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntRule()); 
            }
            pushFollow(FOLLOW_ruleInt_in_entryRuleInt1149);
            ruleInt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInt1156); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:576:1: ruleInt : ( ( rule__Int__Alternatives ) ) ;
    public final void ruleInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:580:2: ( ( ( rule__Int__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:581:1: ( ( rule__Int__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:581:1: ( ( rule__Int__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:582:1: ( rule__Int__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:583:1: ( rule__Int__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:583:2: rule__Int__Alternatives
            {
            pushFollow(FOLLOW_rule__Int__Alternatives_in_ruleInt1182);
            rule__Int__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntAccess().getAlternatives()); 
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
    // $ANTLR end "ruleInt"


    // $ANTLR start "entryRuleName"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:595:1: entryRuleName : ruleName EOF ;
    public final void entryRuleName() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:596:1: ( ruleName EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:597:1: ruleName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameRule()); 
            }
            pushFollow(FOLLOW_ruleName_in_entryRuleName1209);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNameRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleName1216); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:604:1: ruleName : ( ruleID ) ;
    public final void ruleName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:608:2: ( ( ruleID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:609:1: ( ruleID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:609:1: ( ruleID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:610:1: ruleID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameAccess().getIDParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleID_in_ruleName1242);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNameAccess().getIDParserRuleCall()); 
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
    // $ANTLR end "ruleName"


    // $ANTLR start "entryRuleConBind"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:623:1: entryRuleConBind : ruleConBind EOF ;
    public final void entryRuleConBind() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:624:1: ( ruleConBind EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:625:1: ruleConBind EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConBindRule()); 
            }
            pushFollow(FOLLOW_ruleConBind_in_entryRuleConBind1268);
            ruleConBind();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConBindRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConBind1275); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:632:1: ruleConBind : ( ruleCONS ) ;
    public final void ruleConBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:636:2: ( ( ruleCONS ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:637:1: ( ruleCONS )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:637:1: ( ruleCONS )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:638:1: ruleCONS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConBindAccess().getCONSParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConBind1301);
            ruleCONS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConBindAccess().getCONSParserRuleCall()); 
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
    // $ANTLR end "ruleConBind"


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:653:1: entryRuleQid : ruleQid EOF ;
    public final void entryRuleQid() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:654:1: ( ruleQid EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:655:1: ruleQid EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQidRule()); 
            }
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid1329);
            ruleQid();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQidRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid1336); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:662:1: ruleQid : ( ruleID ) ;
    public final void ruleQid() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:666:2: ( ( ruleID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:667:1: ( ruleID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:667:1: ( ruleID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:668:1: ruleID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQidAccess().getIDParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleID_in_ruleQid1362);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQidAccess().getIDParserRuleCall()); 
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
    // $ANTLR end "ruleQid"


    // $ANTLR start "entryRulePOSINT"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:681:1: entryRulePOSINT : rulePOSINT EOF ;
    public final void entryRulePOSINT() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:682:1: ( rulePOSINT EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:683:1: rulePOSINT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOSINTRule()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT1388);
            rulePOSINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOSINTRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT1395); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:690:1: rulePOSINT : ( ( rule__POSINT__Alternatives ) ) ;
    public final void rulePOSINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:694:2: ( ( ( rule__POSINT__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:695:1: ( ( rule__POSINT__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:695:1: ( ( rule__POSINT__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:696:1: ( rule__POSINT__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOSINTAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:697:1: ( rule__POSINT__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:697:2: rule__POSINT__Alternatives
            {
            pushFollow(FOLLOW_rule__POSINT__Alternatives_in_rulePOSINT1421);
            rule__POSINT__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOSINTAccess().getAlternatives()); 
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
    // $ANTLR end "rulePOSINT"


    // $ANTLR start "entryRuleNEGINT"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:709:1: entryRuleNEGINT : ruleNEGINT EOF ;
    public final void entryRuleNEGINT() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:710:1: ( ruleNEGINT EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:711:1: ruleNEGINT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNEGINTRule()); 
            }
            pushFollow(FOLLOW_ruleNEGINT_in_entryRuleNEGINT1448);
            ruleNEGINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNEGINTRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNEGINT1455); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:718:1: ruleNEGINT : ( ( rule__NEGINT__Group__0 ) ) ;
    public final void ruleNEGINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:722:2: ( ( ( rule__NEGINT__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:723:1: ( ( rule__NEGINT__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:723:1: ( ( rule__NEGINT__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:724:1: ( rule__NEGINT__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNEGINTAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:725:1: ( rule__NEGINT__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:725:2: rule__NEGINT__Group__0
            {
            pushFollow(FOLLOW_rule__NEGINT__Group__0_in_ruleNEGINT1481);
            rule__NEGINT__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNEGINTAccess().getGroup()); 
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
    // $ANTLR end "ruleNEGINT"


    // $ANTLR start "entryRuleNUM"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:737:1: entryRuleNUM : ruleNUM EOF ;
    public final void entryRuleNUM() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:738:1: ( ruleNUM EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:739:1: ruleNUM EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNUMRule()); 
            }
            pushFollow(FOLLOW_ruleNUM_in_entryRuleNUM1508);
            ruleNUM();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNUMRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUM1515); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:746:1: ruleNUM : ( ( ( ruleDIG ) ) ( ( ruleDIG )* ) ) ;
    public final void ruleNUM() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:750:2: ( ( ( ( ruleDIG ) ) ( ( ruleDIG )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:751:1: ( ( ( ruleDIG ) ) ( ( ruleDIG )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:751:1: ( ( ( ruleDIG ) ) ( ( ruleDIG )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:752:1: ( ( ruleDIG ) ) ( ( ruleDIG )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:752:1: ( ( ruleDIG ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:753:1: ( ruleDIG )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:754:1: ( ruleDIG )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:754:3: ruleDIG
            {
            pushFollow(FOLLOW_ruleDIG_in_ruleNUM1544);
            ruleDIG();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            }

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:757:1: ( ( ruleDIG )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:758:1: ( ruleDIG )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:759:1: ( ruleDIG )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_BINDIG) ) {
                    int LA1_2 = input.LA(2);

                    if ( (synpred1_InternalGDSL()) ) {
                        alt1=1;
                    }


                }
                else if ( (LA1_0==RULE_NBINDIG) ) {
                    int LA1_3 = input.LA(2);

                    if ( (synpred1_InternalGDSL()) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:759:3: ruleDIG
            	    {
            	    pushFollow(FOLLOW_ruleDIG_in_ruleNUM1557);
            	    ruleDIG();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            }

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:772:1: entryRuleHEXNUM : ruleHEXNUM EOF ;
    public final void entryRuleHEXNUM() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:773:1: ( ruleHEXNUM EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:774:1: ruleHEXNUM EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMRule()); 
            }
            pushFollow(FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM1587);
            ruleHEXNUM();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXNUMRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXNUM1594); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:781:1: ruleHEXNUM : ( ( rule__HEXNUM__Group__0 ) ) ;
    public final void ruleHEXNUM() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:785:2: ( ( ( rule__HEXNUM__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:786:1: ( ( rule__HEXNUM__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:786:1: ( ( rule__HEXNUM__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:787:1: ( rule__HEXNUM__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:788:1: ( rule__HEXNUM__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:788:2: rule__HEXNUM__Group__0
            {
            pushFollow(FOLLOW_rule__HEXNUM__Group__0_in_ruleHEXNUM1620);
            rule__HEXNUM__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXNUMAccess().getGroup()); 
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
    // $ANTLR end "ruleHEXNUM"


    // $ANTLR start "entryRuleBITSTR"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:802:1: entryRuleBITSTR : ruleBITSTR EOF ;
    public final void entryRuleBITSTR() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:803:1: ( ruleBITSTR EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:804:1: ruleBITSTR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBITSTRRule()); 
            }
            pushFollow(FOLLOW_ruleBITSTR_in_entryRuleBITSTR1649);
            ruleBITSTR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBITSTRRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITSTR1656); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:811:1: ruleBITSTR : ( ( ( ruleBINARY ) ) ( ( ruleBINARY )* ) ) ;
    public final void ruleBITSTR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:815:2: ( ( ( ( ruleBINARY ) ) ( ( ruleBINARY )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:816:1: ( ( ( ruleBINARY ) ) ( ( ruleBINARY )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:816:1: ( ( ( ruleBINARY ) ) ( ( ruleBINARY )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:817:1: ( ( ruleBINARY ) ) ( ( ruleBINARY )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:817:1: ( ( ruleBINARY ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:818:1: ( ruleBINARY )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:819:1: ( ruleBINARY )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:819:3: ruleBINARY
            {
            pushFollow(FOLLOW_ruleBINARY_in_ruleBITSTR1685);
            ruleBINARY();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            }

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:822:1: ( ( ruleBINARY )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:823:1: ( ruleBINARY )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:824:1: ( ruleBINARY )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case RULE_BINDIG:
                    {
                    int LA2_2 = input.LA(2);

                    if ( (synpred2_InternalGDSL()) ) {
                        alt2=1;
                    }


                    }
                    break;
                case RULE_BS:
                    {
                    int LA2_3 = input.LA(2);

                    if ( (synpred2_InternalGDSL()) ) {
                        alt2=1;
                    }


                    }
                    break;
                case RULE_DOT:
                    {
                    int LA2_4 = input.LA(2);

                    if ( (synpred2_InternalGDSL()) ) {
                        alt2=1;
                    }


                    }
                    break;
                case RULE_PIPE:
                    {
                    int LA2_5 = input.LA(2);

                    if ( (synpred2_InternalGDSL()) ) {
                        alt2=1;
                    }


                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:824:3: ruleBINARY
            	    {
            	    pushFollow(FOLLOW_ruleBINARY_in_ruleBITSTR1698);
            	    ruleBINARY();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            }

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:839:1: entryRuleCONS : ruleCONS EOF ;
    public final void entryRuleCONS() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:840:1: ( ruleCONS EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:841:1: ruleCONS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCONSRule()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS1730);
            ruleCONS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCONSRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS1737); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:848:1: ruleCONS : ( ( rule__CONS__Group__0 ) ) ;
    public final void ruleCONS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:852:2: ( ( ( rule__CONS__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:853:1: ( ( rule__CONS__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:853:1: ( ( rule__CONS__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:854:1: ( rule__CONS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCONSAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:855:1: ( rule__CONS__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:855:2: rule__CONS__Group__0
            {
            pushFollow(FOLLOW_rule__CONS__Group__0_in_ruleCONS1763);
            rule__CONS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCONSAccess().getGroup()); 
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
    // $ANTLR end "ruleCONS"


    // $ANTLR start "entryRuleID"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:867:1: entryRuleID : ruleID EOF ;
    public final void entryRuleID() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:868:1: ( ruleID EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:869:1: ruleID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDRule()); 
            }
            pushFollow(FOLLOW_ruleID_in_entryRuleID1790);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleID1797); if (state.failed) return ;

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
    // $ANTLR end "entryRuleID"


    // $ANTLR start "ruleID"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:876:1: ruleID : ( ( rule__ID__Group__0 ) ) ;
    public final void ruleID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:880:2: ( ( ( rule__ID__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:881:1: ( ( rule__ID__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:881:1: ( ( rule__ID__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:882:1: ( rule__ID__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:883:1: ( rule__ID__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:883:2: rule__ID__Group__0
            {
            pushFollow(FOLLOW_rule__ID__Group__0_in_ruleID1823);
            rule__ID__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDAccess().getGroup()); 
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
    // $ANTLR end "ruleID"


    // $ANTLR start "entryRuleHEXDIGIT"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:895:1: entryRuleHEXDIGIT : ruleHEXDIGIT EOF ;
    public final void entryRuleHEXDIGIT() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:896:1: ( ruleHEXDIGIT EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:897:1: ruleHEXDIGIT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXDIGITRule()); 
            }
            pushFollow(FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT1850);
            ruleHEXDIGIT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXDIGITRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXDIGIT1857); if (state.failed) return ;

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
    // $ANTLR end "entryRuleHEXDIGIT"


    // $ANTLR start "ruleHEXDIGIT"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:904:1: ruleHEXDIGIT : ( ( rule__HEXDIGIT__Alternatives ) ) ;
    public final void ruleHEXDIGIT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:908:2: ( ( ( rule__HEXDIGIT__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:909:1: ( ( rule__HEXDIGIT__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:909:1: ( ( rule__HEXDIGIT__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:910:1: ( rule__HEXDIGIT__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXDIGITAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:911:1: ( rule__HEXDIGIT__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:911:2: rule__HEXDIGIT__Alternatives
            {
            pushFollow(FOLLOW_rule__HEXDIGIT__Alternatives_in_ruleHEXDIGIT1883);
            rule__HEXDIGIT__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXDIGITAccess().getAlternatives()); 
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
    // $ANTLR end "ruleHEXDIGIT"


    // $ANTLR start "entryRuleHEXCHAR"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:923:1: entryRuleHEXCHAR : ruleHEXCHAR EOF ;
    public final void entryRuleHEXCHAR() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:924:1: ( ruleHEXCHAR EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:925:1: ruleHEXCHAR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXCHARRule()); 
            }
            pushFollow(FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR1910);
            ruleHEXCHAR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXCHARRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXCHAR1917); if (state.failed) return ;

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
    // $ANTLR end "entryRuleHEXCHAR"


    // $ANTLR start "ruleHEXCHAR"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:932:1: ruleHEXCHAR : ( ( rule__HEXCHAR__Alternatives ) ) ;
    public final void ruleHEXCHAR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:936:2: ( ( ( rule__HEXCHAR__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:937:1: ( ( rule__HEXCHAR__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:937:1: ( ( rule__HEXCHAR__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:938:1: ( rule__HEXCHAR__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXCHARAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:939:1: ( rule__HEXCHAR__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:939:2: rule__HEXCHAR__Alternatives
            {
            pushFollow(FOLLOW_rule__HEXCHAR__Alternatives_in_ruleHEXCHAR1943);
            rule__HEXCHAR__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXCHARAccess().getAlternatives()); 
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
    // $ANTLR end "ruleHEXCHAR"


    // $ANTLR start "entryRuleULETTER"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:951:1: entryRuleULETTER : ruleULETTER EOF ;
    public final void entryRuleULETTER() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:952:1: ( ruleULETTER EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:953:1: ruleULETTER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getULETTERRule()); 
            }
            pushFollow(FOLLOW_ruleULETTER_in_entryRuleULETTER1970);
            ruleULETTER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getULETTERRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleULETTER1977); if (state.failed) return ;

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
    // $ANTLR end "entryRuleULETTER"


    // $ANTLR start "ruleULETTER"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:960:1: ruleULETTER : ( ( rule__ULETTER__Alternatives ) ) ;
    public final void ruleULETTER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:964:2: ( ( ( rule__ULETTER__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:965:1: ( ( rule__ULETTER__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:965:1: ( ( rule__ULETTER__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:966:1: ( rule__ULETTER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getULETTERAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:967:1: ( rule__ULETTER__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:967:2: rule__ULETTER__Alternatives
            {
            pushFollow(FOLLOW_rule__ULETTER__Alternatives_in_ruleULETTER2003);
            rule__ULETTER__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getULETTERAccess().getAlternatives()); 
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
    // $ANTLR end "ruleULETTER"


    // $ANTLR start "entryRuleLETTER"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:979:1: entryRuleLETTER : ruleLETTER EOF ;
    public final void entryRuleLETTER() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:980:1: ( ruleLETTER EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:981:1: ruleLETTER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLETTERRule()); 
            }
            pushFollow(FOLLOW_ruleLETTER_in_entryRuleLETTER2030);
            ruleLETTER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLETTERRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLETTER2037); if (state.failed) return ;

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
    // $ANTLR end "entryRuleLETTER"


    // $ANTLR start "ruleLETTER"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:988:1: ruleLETTER : ( ( rule__LETTER__Alternatives ) ) ;
    public final void ruleLETTER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:992:2: ( ( ( rule__LETTER__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:993:1: ( ( rule__LETTER__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:993:1: ( ( rule__LETTER__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:994:1: ( rule__LETTER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLETTERAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:995:1: ( rule__LETTER__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:995:2: rule__LETTER__Alternatives
            {
            pushFollow(FOLLOW_rule__LETTER__Alternatives_in_ruleLETTER2063);
            rule__LETTER__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLETTERAccess().getAlternatives()); 
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
    // $ANTLR end "ruleLETTER"


    // $ANTLR start "entryRuleIDCHAR"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1007:1: entryRuleIDCHAR : ruleIDCHAR EOF ;
    public final void entryRuleIDCHAR() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1008:1: ( ruleIDCHAR EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1009:1: ruleIDCHAR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDCHARRule()); 
            }
            pushFollow(FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR2090);
            ruleIDCHAR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDCHARRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDCHAR2097); if (state.failed) return ;

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
    // $ANTLR end "entryRuleIDCHAR"


    // $ANTLR start "ruleIDCHAR"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1016:1: ruleIDCHAR : ( ( rule__IDCHAR__Alternatives ) ) ;
    public final void ruleIDCHAR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1020:2: ( ( ( rule__IDCHAR__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1021:1: ( ( rule__IDCHAR__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1021:1: ( ( rule__IDCHAR__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1022:1: ( rule__IDCHAR__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDCHARAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1023:1: ( rule__IDCHAR__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1023:2: rule__IDCHAR__Alternatives
            {
            pushFollow(FOLLOW_rule__IDCHAR__Alternatives_in_ruleIDCHAR2123);
            rule__IDCHAR__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDCHARAccess().getAlternatives()); 
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
    // $ANTLR end "ruleIDCHAR"


    // $ANTLR start "entryRuleBINARY"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1035:1: entryRuleBINARY : ruleBINARY EOF ;
    public final void entryRuleBINARY() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1036:1: ( ruleBINARY EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1037:1: ruleBINARY EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBINARYRule()); 
            }
            pushFollow(FOLLOW_ruleBINARY_in_entryRuleBINARY2150);
            ruleBINARY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBINARYRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBINARY2157); if (state.failed) return ;

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
    // $ANTLR end "entryRuleBINARY"


    // $ANTLR start "ruleBINARY"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1044:1: ruleBINARY : ( ( rule__BINARY__Alternatives ) ) ;
    public final void ruleBINARY() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1048:2: ( ( ( rule__BINARY__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1049:1: ( ( rule__BINARY__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1049:1: ( ( rule__BINARY__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1050:1: ( rule__BINARY__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBINARYAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1051:1: ( rule__BINARY__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1051:2: rule__BINARY__Alternatives
            {
            pushFollow(FOLLOW_rule__BINARY__Alternatives_in_ruleBINARY2183);
            rule__BINARY__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBINARYAccess().getAlternatives()); 
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
    // $ANTLR end "ruleBINARY"


    // $ANTLR start "entryRuleDIG"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1063:1: entryRuleDIG : ruleDIG EOF ;
    public final void entryRuleDIG() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1064:1: ( ruleDIG EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1065:1: ruleDIG EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDIGRule()); 
            }
            pushFollow(FOLLOW_ruleDIG_in_entryRuleDIG2210);
            ruleDIG();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDIGRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDIG2217); if (state.failed) return ;

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
    // $ANTLR end "entryRuleDIG"


    // $ANTLR start "ruleDIG"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1072:1: ruleDIG : ( ( rule__DIG__Alternatives ) ) ;
    public final void ruleDIG() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1076:2: ( ( ( rule__DIG__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1077:1: ( ( rule__DIG__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1077:1: ( ( rule__DIG__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1078:1: ( rule__DIG__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDIGAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1079:1: ( rule__DIG__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1079:2: rule__DIG__Alternatives
            {
            pushFollow(FOLLOW_rule__DIG__Alternatives_in_ruleDIG2243);
            rule__DIG__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDIGAccess().getAlternatives()); 
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
    // $ANTLR end "ruleDIG"


    // $ANTLR start "entryRuleSYM"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1091:1: entryRuleSYM : ruleSYM EOF ;
    public final void entryRuleSYM() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1092:1: ( ruleSYM EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1093:1: ruleSYM EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSYMRule()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_entryRuleSYM2270);
            ruleSYM();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSYMRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSYM2277); if (state.failed) return ;

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
    // $ANTLR end "entryRuleSYM"


    // $ANTLR start "ruleSYM"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1100:1: ruleSYM : ( ( rule__SYM__Alternatives ) ) ;
    public final void ruleSYM() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1104:2: ( ( ( rule__SYM__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1105:1: ( ( rule__SYM__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1105:1: ( ( rule__SYM__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1106:1: ( rule__SYM__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSYMAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1107:1: ( rule__SYM__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1107:2: rule__SYM__Alternatives
            {
            pushFollow(FOLLOW_rule__SYM__Alternatives_in_ruleSYM2303);
            rule__SYM__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSYMAccess().getAlternatives()); 
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
    // $ANTLR end "ruleSYM"


    // $ANTLR start "rule__Decl__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1119:1: rule__Decl__Alternatives : ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) );
    public final void rule__Decl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1123:1: ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt3=1;
                }
                break;
            case 36:
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
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1124:1: ( ruleDeclGranularity )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1124:1: ( ruleDeclGranularity )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1125:1: ruleDeclGranularity
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives2339);
                    ruleDeclGranularity();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1130:6: ( ruleDeclExport )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1130:6: ( ruleDeclExport )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1131:1: ruleDeclExport
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives2356);
                    ruleDeclExport();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1136:6: ( ruleDeclType )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1136:6: ( ruleDeclType )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1137:1: ruleDeclType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleDeclType_in_rule__Decl__Alternatives2373);
                    ruleDeclType();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1142:6: ( ruleDeclVal )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1142:6: ( ruleDeclVal )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1143:1: ruleDeclVal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives2390);
                    ruleDeclVal();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 
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
    // $ANTLR end "rule__Decl__Alternatives"


    // $ANTLR start "rule__DeclType__Alternatives_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1153:1: rule__DeclType__Alternatives_2 : ( ( ( rule__DeclType__Alternatives_2_0 ) ) | ( ( rule__DeclType__Group_2_1__0 ) ) );
    public final void rule__DeclType__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1157:1: ( ( ( rule__DeclType__Alternatives_2_0 ) ) | ( ( rule__DeclType__Group_2_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_LHEXCHAR && LA4_0<=RULE_SLASH)||LA4_0==RULE_BINDIG||(LA4_0>=RULE_PIPE && LA4_0<=RULE_NBINDIG)||LA4_0==21||LA4_0==27||(LA4_0>=33 && LA4_0<=34)) ) {
                alt4=1;
            }
            else if ( (LA4_0==23) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1158:1: ( ( rule__DeclType__Alternatives_2_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1158:1: ( ( rule__DeclType__Alternatives_2_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1159:1: ( rule__DeclType__Alternatives_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclTypeAccess().getAlternatives_2_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1160:1: ( rule__DeclType__Alternatives_2_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1160:2: rule__DeclType__Alternatives_2_0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Alternatives_2_0_in_rule__DeclType__Alternatives_22422);
                    rule__DeclType__Alternatives_2_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclTypeAccess().getAlternatives_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1164:6: ( ( rule__DeclType__Group_2_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1164:6: ( ( rule__DeclType__Group_2_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1165:1: ( rule__DeclType__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclTypeAccess().getGroup_2_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1166:1: ( rule__DeclType__Group_2_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1166:2: rule__DeclType__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Group_2_1__0_in_rule__DeclType__Alternatives_22440);
                    rule__DeclType__Group_2_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclTypeAccess().getGroup_2_1()); 
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
    // $ANTLR end "rule__DeclType__Alternatives_2"


    // $ANTLR start "rule__DeclType__Alternatives_2_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1175:1: rule__DeclType__Alternatives_2_0 : ( ( ( rule__DeclType__Group_2_0_0__0 ) ) | ( ( rule__DeclType__ValueAssignment_2_0_1 ) ) );
    public final void rule__DeclType__Alternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1179:1: ( ( ( rule__DeclType__Group_2_0_0__0 ) ) | ( ( rule__DeclType__ValueAssignment_2_0_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_LHEXCHAR && LA5_0<=RULE_SLASH)||LA5_0==RULE_BINDIG||(LA5_0>=RULE_PIPE && LA5_0<=RULE_NBINDIG)||LA5_0==27||(LA5_0>=33 && LA5_0<=34)) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1180:1: ( ( rule__DeclType__Group_2_0_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1180:1: ( ( rule__DeclType__Group_2_0_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1181:1: ( rule__DeclType__Group_2_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclTypeAccess().getGroup_2_0_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1182:1: ( rule__DeclType__Group_2_0_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1182:2: rule__DeclType__Group_2_0_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Group_2_0_0__0_in_rule__DeclType__Alternatives_2_02473);
                    rule__DeclType__Group_2_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclTypeAccess().getGroup_2_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1186:6: ( ( rule__DeclType__ValueAssignment_2_0_1 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1186:6: ( ( rule__DeclType__ValueAssignment_2_0_1 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1187:1: ( rule__DeclType__ValueAssignment_2_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclTypeAccess().getValueAssignment_2_0_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1188:1: ( rule__DeclType__ValueAssignment_2_0_1 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1188:2: rule__DeclType__ValueAssignment_2_0_1
                    {
                    pushFollow(FOLLOW_rule__DeclType__ValueAssignment_2_0_1_in_rule__DeclType__Alternatives_2_02491);
                    rule__DeclType__ValueAssignment_2_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclTypeAccess().getValueAssignment_2_0_1()); 
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
    // $ANTLR end "rule__DeclType__Alternatives_2_0"


    // $ANTLR start "rule__DeclVal__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1197:1: rule__DeclVal__Alternatives : ( ( ( rule__DeclVal__Group_0__0 ) ) | ( ( rule__DeclVal__Group_1__0 ) ) );
    public final void rule__DeclVal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1201:1: ( ( ( rule__DeclVal__Group_0__0 ) ) | ( ( rule__DeclVal__Group_1__0 ) ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1202:1: ( ( rule__DeclVal__Group_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1202:1: ( ( rule__DeclVal__Group_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1203:1: ( rule__DeclVal__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1204:1: ( rule__DeclVal__Group_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1204:2: rule__DeclVal__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_0__0_in_rule__DeclVal__Alternatives2524);
                    rule__DeclVal__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclValAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1208:6: ( ( rule__DeclVal__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1208:6: ( ( rule__DeclVal__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1209:1: ( rule__DeclVal__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1210:1: ( rule__DeclVal__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1210:2: rule__DeclVal__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1__0_in_rule__DeclVal__Alternatives2542);
                    rule__DeclVal__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclValAccess().getGroup_1()); 
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
    // $ANTLR end "rule__DeclVal__Alternatives"


    // $ANTLR start "rule__DeclVal__Alternatives_0_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1219:1: rule__DeclVal__Alternatives_0_1 : ( ( ( rule__DeclVal__NameAssignment_0_1_0 ) ) | ( ( rule__DeclVal__NameAssignment_0_1_1 ) ) );
    public final void rule__DeclVal__Alternatives_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1223:1: ( ( ( rule__DeclVal__NameAssignment_0_1_0 ) ) | ( ( rule__DeclVal__NameAssignment_0_1_1 ) ) )
            int alt7=2;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
                {
                alt7=1;
                }
                break;
            case RULE_SLASH:
                {
                int LA7_2 = input.LA(2);

                if ( (synpred9_InternalGDSL()) ) {
                    alt7=1;
                }
                else if ( (true) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_CHARSYM:
            case RULE_BS:
            case RULE_DOT:
            case RULE_OTHERSYM:
                {
                alt7=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1224:1: ( ( rule__DeclVal__NameAssignment_0_1_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1224:1: ( ( rule__DeclVal__NameAssignment_0_1_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1225:1: ( rule__DeclVal__NameAssignment_0_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getNameAssignment_0_1_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1226:1: ( rule__DeclVal__NameAssignment_0_1_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1226:2: rule__DeclVal__NameAssignment_0_1_0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__NameAssignment_0_1_0_in_rule__DeclVal__Alternatives_0_12575);
                    rule__DeclVal__NameAssignment_0_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclValAccess().getNameAssignment_0_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1230:6: ( ( rule__DeclVal__NameAssignment_0_1_1 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1230:6: ( ( rule__DeclVal__NameAssignment_0_1_1 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1231:1: ( rule__DeclVal__NameAssignment_0_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getNameAssignment_0_1_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1232:1: ( rule__DeclVal__NameAssignment_0_1_1 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1232:2: rule__DeclVal__NameAssignment_0_1_1
                    {
                    pushFollow(FOLLOW_rule__DeclVal__NameAssignment_0_1_1_in_rule__DeclVal__Alternatives_0_12593);
                    rule__DeclVal__NameAssignment_0_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclValAccess().getNameAssignment_0_1_1()); 
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
    // $ANTLR end "rule__DeclVal__Alternatives_0_1"


    // $ANTLR start "rule__DeclVal__Alternatives_1_5"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1241:1: rule__DeclVal__Alternatives_1_5 : ( ( ( rule__DeclVal__Group_1_5_0__0 ) ) | ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) ) );
    public final void rule__DeclVal__Alternatives_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1245:1: ( ( ( rule__DeclVal__Group_1_5_0__0 ) ) | ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_PIPE) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1246:1: ( ( rule__DeclVal__Group_1_5_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1246:1: ( ( rule__DeclVal__Group_1_5_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1247:1: ( rule__DeclVal__Group_1_5_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_1_5_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1248:1: ( rule__DeclVal__Group_1_5_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1248:2: rule__DeclVal__Group_1_5_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__0_in_rule__DeclVal__Alternatives_1_52626);
                    rule__DeclVal__Group_1_5_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclValAccess().getGroup_1_5_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1252:6: ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1252:6: ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1253:1: ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1253:1: ( ( rule__DeclVal__Group_1_5_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1254:1: ( rule__DeclVal__Group_1_5_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1255:1: ( rule__DeclVal__Group_1_5_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1255:2: rule__DeclVal__Group_1_5_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_52646);
                    rule__DeclVal__Group_1_5_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 
                    }

                    }

                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1258:1: ( ( rule__DeclVal__Group_1_5_1__0 )* )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1259:1: ( rule__DeclVal__Group_1_5_1__0 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1260:1: ( rule__DeclVal__Group_1_5_1__0 )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_PIPE) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1260:2: rule__DeclVal__Group_1_5_1__0
                    	    {
                    	    pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_52658);
                    	    rule__DeclVal__Group_1_5_1__0();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 
                    }

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1270:1: rule__Ty__Alternatives : ( ( ( rule__Ty__ValueAssignment_0 ) ) | ( ( rule__Ty__Group_1__0 ) ) | ( ( rule__Ty__Group_2__0 ) ) | ( ( rule__Ty__Group_3__0 ) ) );
    public final void rule__Ty__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1274:1: ( ( ( rule__Ty__ValueAssignment_0 ) ) | ( ( rule__Ty__Group_1__0 ) ) | ( ( rule__Ty__Group_2__0 ) ) | ( ( rule__Ty__Group_3__0 ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_BINDIG:
            case RULE_NBINDIG:
            case 33:
            case 34:
                {
                alt10=1;
                }
                break;
            case RULE_PIPE:
                {
                alt10=2;
                }
                break;
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
                {
                alt10=3;
                }
                break;
            case 27:
                {
                alt10=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1275:1: ( ( rule__Ty__ValueAssignment_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1275:1: ( ( rule__Ty__ValueAssignment_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1276:1: ( rule__Ty__ValueAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTyAccess().getValueAssignment_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1277:1: ( rule__Ty__ValueAssignment_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1277:2: rule__Ty__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Ty__ValueAssignment_0_in_rule__Ty__Alternatives2694);
                    rule__Ty__ValueAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTyAccess().getValueAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1281:6: ( ( rule__Ty__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1281:6: ( ( rule__Ty__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1282:1: ( rule__Ty__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTyAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1283:1: ( rule__Ty__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1283:2: rule__Ty__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_1__0_in_rule__Ty__Alternatives2712);
                    rule__Ty__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTyAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1287:6: ( ( rule__Ty__Group_2__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1287:6: ( ( rule__Ty__Group_2__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1288:1: ( rule__Ty__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTyAccess().getGroup_2()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1289:1: ( rule__Ty__Group_2__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1289:2: rule__Ty__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_2__0_in_rule__Ty__Alternatives2730);
                    rule__Ty__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTyAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1293:6: ( ( rule__Ty__Group_3__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1293:6: ( ( rule__Ty__Group_3__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1294:1: ( rule__Ty__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTyAccess().getGroup_3()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1295:1: ( rule__Ty__Group_3__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1295:2: rule__Ty__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_3__0_in_rule__Ty__Alternatives2748);
                    rule__Ty__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTyAccess().getGroup_3()); 
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
    // $ANTLR end "rule__Ty__Alternatives"


    // $ANTLR start "rule__DecodePat__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1304:1: rule__DecodePat__Alternatives : ( ( ruleBitPat ) | ( ruleTokPat ) );
    public final void rule__DecodePat__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1308:1: ( ( ruleBitPat ) | ( ruleTokPat ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=RULE_LHEXCHAR && LA11_0<=RULE_SLASH)||LA11_0==RULE_BINDIG||LA11_0==RULE_NBINDIG||(LA11_0>=33 && LA11_0<=34)) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1309:1: ( ruleBitPat )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1309:1: ( ruleBitPat )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1310:1: ruleBitPat
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecodePatAccess().getBitPatParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleBitPat_in_rule__DecodePat__Alternatives2781);
                    ruleBitPat();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecodePatAccess().getBitPatParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1315:6: ( ruleTokPat )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1315:6: ( ruleTokPat )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1316:1: ruleTokPat
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecodePatAccess().getTokPatParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleTokPat_in_rule__DecodePat__Alternatives2798);
                    ruleTokPat();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDecodePatAccess().getTokPatParserRuleCall_1()); 
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
    // $ANTLR end "rule__DecodePat__Alternatives"


    // $ANTLR start "rule__TokPat__TokPatAlternatives_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1326:1: rule__TokPat__TokPatAlternatives_0 : ( ( ruleInt ) | ( ruleQid ) );
    public final void rule__TokPat__TokPatAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1330:1: ( ( ruleInt ) | ( ruleQid ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_BINDIG||LA12_0==RULE_NBINDIG||(LA12_0>=33 && LA12_0<=34)) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=RULE_LHEXCHAR && LA12_0<=RULE_SLASH)) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1331:1: ( ruleInt )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1331:1: ( ruleInt )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1332:1: ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokPatAccess().getTokPatIntParserRuleCall_0_0()); 
                    }
                    pushFollow(FOLLOW_ruleInt_in_rule__TokPat__TokPatAlternatives_02830);
                    ruleInt();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokPatAccess().getTokPatIntParserRuleCall_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1337:6: ( ruleQid )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1337:6: ( ruleQid )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1338:1: ruleQid
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokPatAccess().getTokPatQidParserRuleCall_0_1()); 
                    }
                    pushFollow(FOLLOW_ruleQid_in_rule__TokPat__TokPatAlternatives_02847);
                    ruleQid();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTokPatAccess().getTokPatQidParserRuleCall_0_1()); 
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
    // $ANTLR end "rule__TokPat__TokPatAlternatives_0"


    // $ANTLR start "rule__PrimBitPat__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1348:1: rule__PrimBitPat__Alternatives : ( ( ( ruleBITSTR ) ) | ( ( rule__PrimBitPat__Group_1__0 ) ) );
    public final void rule__PrimBitPat__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1352:1: ( ( ( ruleBITSTR ) ) | ( ( rule__PrimBitPat__Group_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_BINDIG && LA13_0<=RULE_PIPE)) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=RULE_LHEXCHAR && LA13_0<=RULE_SLASH)) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1353:1: ( ( ruleBITSTR ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1353:1: ( ( ruleBITSTR ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1354:1: ( ruleBITSTR )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimBitPatAccess().getBITSTRParserRuleCall_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1355:1: ( ruleBITSTR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1355:3: ruleBITSTR
                    {
                    pushFollow(FOLLOW_ruleBITSTR_in_rule__PrimBitPat__Alternatives2880);
                    ruleBITSTR();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimBitPatAccess().getBITSTRParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1359:6: ( ( rule__PrimBitPat__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1359:6: ( ( rule__PrimBitPat__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1360:1: ( rule__PrimBitPat__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimBitPatAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1361:1: ( rule__PrimBitPat__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1361:2: rule__PrimBitPat__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimBitPat__Group_1__0_in_rule__PrimBitPat__Alternatives2898);
                    rule__PrimBitPat__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimBitPatAccess().getGroup_1()); 
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
    // $ANTLR end "rule__PrimBitPat__Alternatives"


    // $ANTLR start "rule__BitPatOrInt__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1370:1: rule__BitPatOrInt__Alternatives : ( ( ( rule__BitPatOrInt__Group_0__0 ) ) | ( ( rule__BitPatOrInt__Group_1__0 ) ) );
    public final void rule__BitPatOrInt__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1374:1: ( ( ( rule__BitPatOrInt__Group_0__0 ) ) | ( ( rule__BitPatOrInt__Group_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            else if ( (LA14_0==32) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1375:1: ( ( rule__BitPatOrInt__Group_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1375:1: ( ( rule__BitPatOrInt__Group_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1376:1: ( rule__BitPatOrInt__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBitPatOrIntAccess().getGroup_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1377:1: ( rule__BitPatOrInt__Group_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1377:2: rule__BitPatOrInt__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__0_in_rule__BitPatOrInt__Alternatives2931);
                    rule__BitPatOrInt__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBitPatOrIntAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1381:6: ( ( rule__BitPatOrInt__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1381:6: ( ( rule__BitPatOrInt__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1382:1: ( rule__BitPatOrInt__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBitPatOrIntAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1383:1: ( rule__BitPatOrInt__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1383:2: rule__BitPatOrInt__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__0_in_rule__BitPatOrInt__Alternatives2949);
                    rule__BitPatOrInt__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBitPatOrIntAccess().getGroup_1()); 
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
    // $ANTLR end "rule__BitPatOrInt__Alternatives"


    // $ANTLR start "rule__Int__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1392:1: rule__Int__Alternatives : ( ( rulePOSINT ) | ( ruleNEGINT ) );
    public final void rule__Int__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1396:1: ( ( rulePOSINT ) | ( ruleNEGINT ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_BINDIG||LA15_0==RULE_NBINDIG||LA15_0==34) ) {
                alt15=1;
            }
            else if ( (LA15_0==33) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1397:1: ( rulePOSINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1397:1: ( rulePOSINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1398:1: rulePOSINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntAccess().getPOSINTParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_rule__Int__Alternatives2982);
                    rulePOSINT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIntAccess().getPOSINTParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1403:6: ( ruleNEGINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1403:6: ( ruleNEGINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1404:1: ruleNEGINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntAccess().getNEGINTParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleNEGINT_in_rule__Int__Alternatives2999);
                    ruleNEGINT();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIntAccess().getNEGINTParserRuleCall_1()); 
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
    // $ANTLR end "rule__Int__Alternatives"


    // $ANTLR start "rule__POSINT__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1414:1: rule__POSINT__Alternatives : ( ( ruleNUM ) | ( ruleHEXNUM ) );
    public final void rule__POSINT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1418:1: ( ( ruleNUM ) | ( ruleHEXNUM ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_BINDIG||LA16_0==RULE_NBINDIG) ) {
                alt16=1;
            }
            else if ( (LA16_0==34) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1419:1: ( ruleNUM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1419:1: ( ruleNUM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1420:1: ruleNUM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPOSINTAccess().getNUMParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleNUM_in_rule__POSINT__Alternatives3031);
                    ruleNUM();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPOSINTAccess().getNUMParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1425:6: ( ruleHEXNUM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1425:6: ( ruleHEXNUM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1426:1: ruleHEXNUM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPOSINTAccess().getHEXNUMParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleHEXNUM_in_rule__POSINT__Alternatives3048);
                    ruleHEXNUM();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPOSINTAccess().getHEXNUMParserRuleCall_1()); 
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
    // $ANTLR end "rule__POSINT__Alternatives"


    // $ANTLR start "rule__HEXDIGIT__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1436:1: rule__HEXDIGIT__Alternatives : ( ( ruleDIG ) | ( ruleHEXCHAR ) );
    public final void rule__HEXDIGIT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1440:1: ( ( ruleDIG ) | ( ruleHEXCHAR ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_BINDIG||LA17_0==RULE_NBINDIG) ) {
                alt17=1;
            }
            else if ( ((LA17_0>=RULE_LHEXCHAR && LA17_0<=RULE_UHEXCHAR)) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1441:1: ( ruleDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1441:1: ( ruleDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1442:1: ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getHEXDIGITAccess().getDIGParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleDIG_in_rule__HEXDIGIT__Alternatives3080);
                    ruleDIG();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getHEXDIGITAccess().getDIGParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1447:6: ( ruleHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1447:6: ( ruleHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1448:1: ruleHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getHEXDIGITAccess().getHEXCHARParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleHEXCHAR_in_rule__HEXDIGIT__Alternatives3097);
                    ruleHEXCHAR();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getHEXDIGITAccess().getHEXCHARParserRuleCall_1()); 
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
    // $ANTLR end "rule__HEXDIGIT__Alternatives"


    // $ANTLR start "rule__HEXCHAR__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1458:1: rule__HEXCHAR__Alternatives : ( ( RULE_LHEXCHAR ) | ( RULE_UHEXCHAR ) );
    public final void rule__HEXCHAR__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1462:1: ( ( RULE_LHEXCHAR ) | ( RULE_UHEXCHAR ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_LHEXCHAR) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_UHEXCHAR) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1463:1: ( RULE_LHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1463:1: ( RULE_LHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1464:1: RULE_LHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getHEXCHARAccess().getLHEXCHARTerminalRuleCall_0()); 
                    }
                    match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_rule__HEXCHAR__Alternatives3129); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getHEXCHARAccess().getLHEXCHARTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1469:6: ( RULE_UHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1469:6: ( RULE_UHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1470:1: RULE_UHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getHEXCHARAccess().getUHEXCHARTerminalRuleCall_1()); 
                    }
                    match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_rule__HEXCHAR__Alternatives3146); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getHEXCHARAccess().getUHEXCHARTerminalRuleCall_1()); 
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
    // $ANTLR end "rule__HEXCHAR__Alternatives"


    // $ANTLR start "rule__ULETTER__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1480:1: rule__ULETTER__Alternatives : ( ( RULE_UHEXCHAR ) | ( RULE_UNHEXCHAR ) );
    public final void rule__ULETTER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1484:1: ( ( RULE_UHEXCHAR ) | ( RULE_UNHEXCHAR ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_UHEXCHAR) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_UNHEXCHAR) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1485:1: ( RULE_UHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1485:1: ( RULE_UHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1486:1: RULE_UHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getULETTERAccess().getUHEXCHARTerminalRuleCall_0()); 
                    }
                    match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_rule__ULETTER__Alternatives3178); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getULETTERAccess().getUHEXCHARTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1491:6: ( RULE_UNHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1491:6: ( RULE_UNHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1492:1: RULE_UNHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getULETTERAccess().getUNHEXCHARTerminalRuleCall_1()); 
                    }
                    match(input,RULE_UNHEXCHAR,FOLLOW_RULE_UNHEXCHAR_in_rule__ULETTER__Alternatives3195); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getULETTERAccess().getUNHEXCHARTerminalRuleCall_1()); 
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
    // $ANTLR end "rule__ULETTER__Alternatives"


    // $ANTLR start "rule__LETTER__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1502:1: rule__LETTER__Alternatives : ( ( RULE_LHEXCHAR ) | ( RULE_LNHEXCHAR ) | ( ruleULETTER ) | ( RULE_SLASH ) );
    public final void rule__LETTER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1506:1: ( ( RULE_LHEXCHAR ) | ( RULE_LNHEXCHAR ) | ( ruleULETTER ) | ( RULE_SLASH ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
                {
                alt20=1;
                }
                break;
            case RULE_LNHEXCHAR:
                {
                alt20=2;
                }
                break;
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
                {
                alt20=3;
                }
                break;
            case RULE_SLASH:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1507:1: ( RULE_LHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1507:1: ( RULE_LHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1508:1: RULE_LHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLETTERAccess().getLHEXCHARTerminalRuleCall_0()); 
                    }
                    match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_rule__LETTER__Alternatives3227); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLETTERAccess().getLHEXCHARTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1513:6: ( RULE_LNHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1513:6: ( RULE_LNHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1514:1: RULE_LNHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLETTERAccess().getLNHEXCHARTerminalRuleCall_1()); 
                    }
                    match(input,RULE_LNHEXCHAR,FOLLOW_RULE_LNHEXCHAR_in_rule__LETTER__Alternatives3244); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLETTERAccess().getLNHEXCHARTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1519:6: ( ruleULETTER )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1519:6: ( ruleULETTER )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1520:1: ruleULETTER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLETTERAccess().getULETTERParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleULETTER_in_rule__LETTER__Alternatives3261);
                    ruleULETTER();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLETTERAccess().getULETTERParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1525:6: ( RULE_SLASH )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1525:6: ( RULE_SLASH )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1526:1: RULE_SLASH
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLETTERAccess().getSLASHTerminalRuleCall_3()); 
                    }
                    match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_rule__LETTER__Alternatives3278); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLETTERAccess().getSLASHTerminalRuleCall_3()); 
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
    // $ANTLR end "rule__LETTER__Alternatives"


    // $ANTLR start "rule__IDCHAR__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1536:1: rule__IDCHAR__Alternatives : ( ( ruleLETTER ) | ( ruleDIG ) | ( RULE_CHARSYM ) );
    public final void rule__IDCHAR__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1540:1: ( ( ruleLETTER ) | ( ruleDIG ) | ( RULE_CHARSYM ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
                {
                alt21=1;
                }
                break;
            case RULE_BINDIG:
            case RULE_NBINDIG:
                {
                alt21=2;
                }
                break;
            case RULE_CHARSYM:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1541:1: ( ruleLETTER )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1541:1: ( ruleLETTER )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1542:1: ruleLETTER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDCHARAccess().getLETTERParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleLETTER_in_rule__IDCHAR__Alternatives3310);
                    ruleLETTER();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDCHARAccess().getLETTERParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1547:6: ( ruleDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1547:6: ( ruleDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1548:1: ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDCHARAccess().getDIGParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleDIG_in_rule__IDCHAR__Alternatives3327);
                    ruleDIG();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDCHARAccess().getDIGParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1553:6: ( RULE_CHARSYM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1553:6: ( RULE_CHARSYM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1554:1: RULE_CHARSYM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDCHARAccess().getCHARSYMTerminalRuleCall_2()); 
                    }
                    match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_rule__IDCHAR__Alternatives3344); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIDCHARAccess().getCHARSYMTerminalRuleCall_2()); 
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
    // $ANTLR end "rule__IDCHAR__Alternatives"


    // $ANTLR start "rule__BINARY__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1564:1: rule__BINARY__Alternatives : ( ( RULE_BINDIG ) | ( RULE_BS ) | ( RULE_DOT ) | ( RULE_PIPE ) );
    public final void rule__BINARY__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1568:1: ( ( RULE_BINDIG ) | ( RULE_BS ) | ( RULE_DOT ) | ( RULE_PIPE ) )
            int alt22=4;
            switch ( input.LA(1) ) {
            case RULE_BINDIG:
                {
                alt22=1;
                }
                break;
            case RULE_BS:
                {
                alt22=2;
                }
                break;
            case RULE_DOT:
                {
                alt22=3;
                }
                break;
            case RULE_PIPE:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1569:1: ( RULE_BINDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1569:1: ( RULE_BINDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1570:1: RULE_BINDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBINARYAccess().getBINDIGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_rule__BINARY__Alternatives3376); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBINARYAccess().getBINDIGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1575:6: ( RULE_BS )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1575:6: ( RULE_BS )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1576:1: RULE_BS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBINARYAccess().getBSTerminalRuleCall_1()); 
                    }
                    match(input,RULE_BS,FOLLOW_RULE_BS_in_rule__BINARY__Alternatives3393); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBINARYAccess().getBSTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1581:6: ( RULE_DOT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1581:6: ( RULE_DOT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1582:1: RULE_DOT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBINARYAccess().getDOTTerminalRuleCall_2()); 
                    }
                    match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rule__BINARY__Alternatives3410); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBINARYAccess().getDOTTerminalRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1587:6: ( RULE_PIPE )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1587:6: ( RULE_PIPE )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1588:1: RULE_PIPE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBINARYAccess().getPIPETerminalRuleCall_3()); 
                    }
                    match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__BINARY__Alternatives3427); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBINARYAccess().getPIPETerminalRuleCall_3()); 
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
    // $ANTLR end "rule__BINARY__Alternatives"


    // $ANTLR start "rule__DIG__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1598:1: rule__DIG__Alternatives : ( ( RULE_BINDIG ) | ( RULE_NBINDIG ) );
    public final void rule__DIG__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1602:1: ( ( RULE_BINDIG ) | ( RULE_NBINDIG ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_BINDIG) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_NBINDIG) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1603:1: ( RULE_BINDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1603:1: ( RULE_BINDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1604:1: RULE_BINDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDIGAccess().getBINDIGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_rule__DIG__Alternatives3459); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDIGAccess().getBINDIGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1609:6: ( RULE_NBINDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1609:6: ( RULE_NBINDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1610:1: RULE_NBINDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDIGAccess().getNBINDIGTerminalRuleCall_1()); 
                    }
                    match(input,RULE_NBINDIG,FOLLOW_RULE_NBINDIG_in_rule__DIG__Alternatives3476); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDIGAccess().getNBINDIGTerminalRuleCall_1()); 
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
    // $ANTLR end "rule__DIG__Alternatives"


    // $ANTLR start "rule__SYM__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1620:1: rule__SYM__Alternatives : ( ( RULE_BS ) | ( RULE_SLASH ) | ( RULE_DOT ) | ( RULE_CHARSYM ) | ( RULE_OTHERSYM ) );
    public final void rule__SYM__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1624:1: ( ( RULE_BS ) | ( RULE_SLASH ) | ( RULE_DOT ) | ( RULE_CHARSYM ) | ( RULE_OTHERSYM ) )
            int alt24=5;
            switch ( input.LA(1) ) {
            case RULE_BS:
                {
                alt24=1;
                }
                break;
            case RULE_SLASH:
                {
                alt24=2;
                }
                break;
            case RULE_DOT:
                {
                alt24=3;
                }
                break;
            case RULE_CHARSYM:
                {
                alt24=4;
                }
                break;
            case RULE_OTHERSYM:
                {
                alt24=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1625:1: ( RULE_BS )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1625:1: ( RULE_BS )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1626:1: RULE_BS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getBSTerminalRuleCall_0()); 
                    }
                    match(input,RULE_BS,FOLLOW_RULE_BS_in_rule__SYM__Alternatives3508); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSYMAccess().getBSTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1631:6: ( RULE_SLASH )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1631:6: ( RULE_SLASH )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1632:1: RULE_SLASH
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getSLASHTerminalRuleCall_1()); 
                    }
                    match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_rule__SYM__Alternatives3525); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSYMAccess().getSLASHTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1637:6: ( RULE_DOT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1637:6: ( RULE_DOT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1638:1: RULE_DOT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                    }
                    match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rule__SYM__Alternatives3542); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1643:6: ( RULE_CHARSYM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1643:6: ( RULE_CHARSYM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1644:1: RULE_CHARSYM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getCHARSYMTerminalRuleCall_3()); 
                    }
                    match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_rule__SYM__Alternatives3559); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSYMAccess().getCHARSYMTerminalRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1649:6: ( RULE_OTHERSYM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1649:6: ( RULE_OTHERSYM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1650:1: RULE_OTHERSYM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getOTHERSYMTerminalRuleCall_4()); 
                    }
                    match(input,RULE_OTHERSYM,FOLLOW_RULE_OTHERSYM_in_rule__SYM__Alternatives3576); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSYMAccess().getOTHERSYMTerminalRuleCall_4()); 
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
    // $ANTLR end "rule__SYM__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1662:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1666:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1667:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__03606);
            rule__Model__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__03609);
            rule__Model__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1674:1: rule__Model__Group__0__Impl : ( ( rule__Model__DeclAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1678:1: ( ( ( rule__Model__DeclAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1679:1: ( ( rule__Model__DeclAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1679:1: ( ( rule__Model__DeclAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1680:1: ( rule__Model__DeclAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDeclAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1681:1: ( rule__Model__DeclAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1681:2: rule__Model__DeclAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl3636);
            rule__Model__DeclAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDeclAssignment_0()); 
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
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1691:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1695:1: ( rule__Model__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1696:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__13666);
            rule__Model__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1702:1: rule__Model__Group__1__Impl : ( ( rule__Model__Group_1__0 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1706:1: ( ( ( rule__Model__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1707:1: ( ( rule__Model__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1707:1: ( ( rule__Model__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1708:1: ( rule__Model__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1709:1: ( rule__Model__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==20||LA25_0==22||LA25_0==26||(LA25_0>=35 && LA25_0<=36)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1709:2: rule__Model__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl3693);
            	    rule__Model__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1723:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1727:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1728:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__03728);
            rule__Model__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__03731);
            rule__Model__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1735:1: rule__Model__Group_1__0__Impl : ( ( ';' )? ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1739:1: ( ( ( ';' )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1740:1: ( ( ';' )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1740:1: ( ( ';' )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1741:1: ( ';' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSemicolonKeyword_1_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1742:1: ( ';' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==20) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1743:2: ';'
                    {
                    match(input,20,FOLLOW_20_in_rule__Model__Group_1__0__Impl3760); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getSemicolonKeyword_1_0()); 
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
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1754:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1758:1: ( rule__Model__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1759:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__13793);
            rule__Model__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1765:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__DeclAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1769:1: ( ( ( rule__Model__DeclAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1770:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1770:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1771:1: ( rule__Model__DeclAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDeclAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1772:1: ( rule__Model__DeclAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1772:2: rule__Model__DeclAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl3820);
            rule__Model__DeclAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDeclAssignment_1_1()); 
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
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__DeclGranularity__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1786:1: rule__DeclGranularity__Group__0 : rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 ;
    public final void rule__DeclGranularity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1790:1: ( rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1791:2: rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__03854);
            rule__DeclGranularity__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__03857);
            rule__DeclGranularity__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1798:1: rule__DeclGranularity__Group__0__Impl : ( ( rule__DeclGranularity__NameAssignment_0 ) ) ;
    public final void rule__DeclGranularity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1802:1: ( ( ( rule__DeclGranularity__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1803:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1803:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1804:1: ( rule__DeclGranularity__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1805:1: ( rule__DeclGranularity__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1805:2: rule__DeclGranularity__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl3884);
            rule__DeclGranularity__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclGranularityAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__DeclGranularity__Group__0__Impl"


    // $ANTLR start "rule__DeclGranularity__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1815:1: rule__DeclGranularity__Group__1 : rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 ;
    public final void rule__DeclGranularity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1819:1: ( rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1820:2: rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__13914);
            rule__DeclGranularity__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__13917);
            rule__DeclGranularity__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1827:1: rule__DeclGranularity__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclGranularity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1831:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1832:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1832:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1833:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclGranularity__Group__1__Impl3945); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1()); 
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
    // $ANTLR end "rule__DeclGranularity__Group__1__Impl"


    // $ANTLR start "rule__DeclGranularity__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1846:1: rule__DeclGranularity__Group__2 : rule__DeclGranularity__Group__2__Impl ;
    public final void rule__DeclGranularity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1850:1: ( rule__DeclGranularity__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1851:2: rule__DeclGranularity__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__23976);
            rule__DeclGranularity__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1857:1: rule__DeclGranularity__Group__2__Impl : ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) ;
    public final void rule__DeclGranularity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1861:1: ( ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1862:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1862:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1863:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getGranularityAssignment_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1864:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1864:2: rule__DeclGranularity__GranularityAssignment_2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl4003);
            rule__DeclGranularity__GranularityAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclGranularityAccess().getGranularityAssignment_2()); 
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
    // $ANTLR end "rule__DeclGranularity__Group__2__Impl"


    // $ANTLR start "rule__DeclExport__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1880:1: rule__DeclExport__Group__0 : rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 ;
    public final void rule__DeclExport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1884:1: ( rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1885:2: rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__04039);
            rule__DeclExport__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__04042);
            rule__DeclExport__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1892:1: rule__DeclExport__Group__0__Impl : ( ( rule__DeclExport__NameAssignment_0 ) ) ;
    public final void rule__DeclExport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1896:1: ( ( ( rule__DeclExport__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1897:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1897:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1898:1: ( rule__DeclExport__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1899:1: ( rule__DeclExport__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1899:2: rule__DeclExport__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl4069);
            rule__DeclExport__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclExportAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__DeclExport__Group__0__Impl"


    // $ANTLR start "rule__DeclExport__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1909:1: rule__DeclExport__Group__1 : rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 ;
    public final void rule__DeclExport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1913:1: ( rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1914:2: rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__14099);
            rule__DeclExport__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__14102);
            rule__DeclExport__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1921:1: rule__DeclExport__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclExport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1925:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1926:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1926:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1927:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclExport__Group__1__Impl4130); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1()); 
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
    // $ANTLR end "rule__DeclExport__Group__1__Impl"


    // $ANTLR start "rule__DeclExport__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1940:1: rule__DeclExport__Group__2 : rule__DeclExport__Group__2__Impl ;
    public final void rule__DeclExport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1944:1: ( rule__DeclExport__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1945:2: rule__DeclExport__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__24161);
            rule__DeclExport__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1951:1: rule__DeclExport__Group__2__Impl : ( ( rule__DeclExport__ExportsAssignment_2 )* ) ;
    public final void rule__DeclExport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1955:1: ( ( ( rule__DeclExport__ExportsAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1956:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1956:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1957:1: ( rule__DeclExport__ExportsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getExportsAssignment_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1958:1: ( rule__DeclExport__ExportsAssignment_2 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=RULE_LHEXCHAR && LA27_0<=RULE_SLASH)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1958:2: rule__DeclExport__ExportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl4188);
            	    rule__DeclExport__ExportsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclExportAccess().getExportsAssignment_2()); 
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
    // $ANTLR end "rule__DeclExport__Group__2__Impl"


    // $ANTLR start "rule__DeclType__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1974:1: rule__DeclType__Group__0 : rule__DeclType__Group__0__Impl rule__DeclType__Group__1 ;
    public final void rule__DeclType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1978:1: ( rule__DeclType__Group__0__Impl rule__DeclType__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1979:2: rule__DeclType__Group__0__Impl rule__DeclType__Group__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group__0__Impl_in_rule__DeclType__Group__04225);
            rule__DeclType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group__1_in_rule__DeclType__Group__04228);
            rule__DeclType__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1986:1: rule__DeclType__Group__0__Impl : ( 'type' ) ;
    public final void rule__DeclType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1990:1: ( ( 'type' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1991:1: ( 'type' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1991:1: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1992:1: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getTypeKeyword_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__DeclType__Group__0__Impl4256); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getTypeKeyword_0()); 
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
    // $ANTLR end "rule__DeclType__Group__0__Impl"


    // $ANTLR start "rule__DeclType__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2005:1: rule__DeclType__Group__1 : rule__DeclType__Group__1__Impl rule__DeclType__Group__2 ;
    public final void rule__DeclType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2009:1: ( rule__DeclType__Group__1__Impl rule__DeclType__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2010:2: rule__DeclType__Group__1__Impl rule__DeclType__Group__2
            {
            pushFollow(FOLLOW_rule__DeclType__Group__1__Impl_in_rule__DeclType__Group__14287);
            rule__DeclType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group__2_in_rule__DeclType__Group__14290);
            rule__DeclType__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2017:1: rule__DeclType__Group__1__Impl : ( ( rule__DeclType__NameAssignment_1 ) ) ;
    public final void rule__DeclType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2021:1: ( ( ( rule__DeclType__NameAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2022:1: ( ( rule__DeclType__NameAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2022:1: ( ( rule__DeclType__NameAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2023:1: ( rule__DeclType__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getNameAssignment_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2024:1: ( rule__DeclType__NameAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2024:2: rule__DeclType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__DeclType__NameAssignment_1_in_rule__DeclType__Group__1__Impl4317);
            rule__DeclType__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__DeclType__Group__1__Impl"


    // $ANTLR start "rule__DeclType__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2034:1: rule__DeclType__Group__2 : rule__DeclType__Group__2__Impl ;
    public final void rule__DeclType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2038:1: ( rule__DeclType__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2039:2: rule__DeclType__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group__2__Impl_in_rule__DeclType__Group__24347);
            rule__DeclType__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2045:1: rule__DeclType__Group__2__Impl : ( ( rule__DeclType__Alternatives_2 ) ) ;
    public final void rule__DeclType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2049:1: ( ( ( rule__DeclType__Alternatives_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2050:1: ( ( rule__DeclType__Alternatives_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2050:1: ( ( rule__DeclType__Alternatives_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2051:1: ( rule__DeclType__Alternatives_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAlternatives_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2052:1: ( rule__DeclType__Alternatives_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2052:2: rule__DeclType__Alternatives_2
            {
            pushFollow(FOLLOW_rule__DeclType__Alternatives_2_in_rule__DeclType__Group__2__Impl4374);
            rule__DeclType__Alternatives_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getAlternatives_2()); 
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
    // $ANTLR end "rule__DeclType__Group__2__Impl"


    // $ANTLR start "rule__DeclType__Group_2_0_0__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2068:1: rule__DeclType__Group_2_0_0__0 : rule__DeclType__Group_2_0_0__0__Impl rule__DeclType__Group_2_0_0__1 ;
    public final void rule__DeclType__Group_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2072:1: ( rule__DeclType__Group_2_0_0__0__Impl rule__DeclType__Group_2_0_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2073:2: rule__DeclType__Group_2_0_0__0__Impl rule__DeclType__Group_2_0_0__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_0_0__0__Impl_in_rule__DeclType__Group_2_0_0__04410);
            rule__DeclType__Group_2_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_0_0__1_in_rule__DeclType__Group_2_0_0__04413);
            rule__DeclType__Group_2_0_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_0_0__0"


    // $ANTLR start "rule__DeclType__Group_2_0_0__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2080:1: rule__DeclType__Group_2_0_0__0__Impl : ( '=' ) ;
    public final void rule__DeclType__Group_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2084:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2085:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2085:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2086:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_0_0_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclType__Group_2_0_0__0__Impl4441); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_0_0_0()); 
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
    // $ANTLR end "rule__DeclType__Group_2_0_0__0__Impl"


    // $ANTLR start "rule__DeclType__Group_2_0_0__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2099:1: rule__DeclType__Group_2_0_0__1 : rule__DeclType__Group_2_0_0__1__Impl ;
    public final void rule__DeclType__Group_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2103:1: ( rule__DeclType__Group_2_0_0__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2104:2: rule__DeclType__Group_2_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_0_0__1__Impl_in_rule__DeclType__Group_2_0_0__14472);
            rule__DeclType__Group_2_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_0_0__1"


    // $ANTLR start "rule__DeclType__Group_2_0_0__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2110:1: rule__DeclType__Group_2_0_0__1__Impl : ( ( rule__DeclType__ValueAssignment_2_0_0_1 ) ) ;
    public final void rule__DeclType__Group_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2114:1: ( ( ( rule__DeclType__ValueAssignment_2_0_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2115:1: ( ( rule__DeclType__ValueAssignment_2_0_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2115:1: ( ( rule__DeclType__ValueAssignment_2_0_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2116:1: ( rule__DeclType__ValueAssignment_2_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueAssignment_2_0_0_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2117:1: ( rule__DeclType__ValueAssignment_2_0_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2117:2: rule__DeclType__ValueAssignment_2_0_0_1
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAssignment_2_0_0_1_in_rule__DeclType__Group_2_0_0__1__Impl4499);
            rule__DeclType__ValueAssignment_2_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getValueAssignment_2_0_0_1()); 
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
    // $ANTLR end "rule__DeclType__Group_2_0_0__1__Impl"


    // $ANTLR start "rule__DeclType__Group_2_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2131:1: rule__DeclType__Group_2_1__0 : rule__DeclType__Group_2_1__0__Impl rule__DeclType__Group_2_1__1 ;
    public final void rule__DeclType__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2135:1: ( rule__DeclType__Group_2_1__0__Impl rule__DeclType__Group_2_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2136:2: rule__DeclType__Group_2_1__0__Impl rule__DeclType__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__0__Impl_in_rule__DeclType__Group_2_1__04533);
            rule__DeclType__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__1_in_rule__DeclType__Group_2_1__04536);
            rule__DeclType__Group_2_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_1__0"


    // $ANTLR start "rule__DeclType__Group_2_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2143:1: rule__DeclType__Group_2_1__0__Impl : ( '[' ) ;
    public final void rule__DeclType__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2147:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2148:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2148:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2149:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getLeftSquareBracketKeyword_2_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__DeclType__Group_2_1__0__Impl4564); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getLeftSquareBracketKeyword_2_1_0()); 
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
    // $ANTLR end "rule__DeclType__Group_2_1__0__Impl"


    // $ANTLR start "rule__DeclType__Group_2_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2162:1: rule__DeclType__Group_2_1__1 : rule__DeclType__Group_2_1__1__Impl rule__DeclType__Group_2_1__2 ;
    public final void rule__DeclType__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2166:1: ( rule__DeclType__Group_2_1__1__Impl rule__DeclType__Group_2_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2167:2: rule__DeclType__Group_2_1__1__Impl rule__DeclType__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__1__Impl_in_rule__DeclType__Group_2_1__14595);
            rule__DeclType__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__2_in_rule__DeclType__Group_2_1__14598);
            rule__DeclType__Group_2_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_1__1"


    // $ANTLR start "rule__DeclType__Group_2_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2174:1: rule__DeclType__Group_2_1__1__Impl : ( ( rule__DeclType__AttrNameAssignment_2_1_1 ) ) ;
    public final void rule__DeclType__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2178:1: ( ( ( rule__DeclType__AttrNameAssignment_2_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2179:1: ( ( rule__DeclType__AttrNameAssignment_2_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2179:1: ( ( rule__DeclType__AttrNameAssignment_2_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2180:1: ( rule__DeclType__AttrNameAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_2_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2181:1: ( rule__DeclType__AttrNameAssignment_2_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2181:2: rule__DeclType__AttrNameAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__DeclType__AttrNameAssignment_2_1_1_in_rule__DeclType__Group_2_1__1__Impl4625);
            rule__DeclType__AttrNameAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_2_1_1()); 
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
    // $ANTLR end "rule__DeclType__Group_2_1__1__Impl"


    // $ANTLR start "rule__DeclType__Group_2_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2191:1: rule__DeclType__Group_2_1__2 : rule__DeclType__Group_2_1__2__Impl rule__DeclType__Group_2_1__3 ;
    public final void rule__DeclType__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2195:1: ( rule__DeclType__Group_2_1__2__Impl rule__DeclType__Group_2_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2196:2: rule__DeclType__Group_2_1__2__Impl rule__DeclType__Group_2_1__3
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__2__Impl_in_rule__DeclType__Group_2_1__24655);
            rule__DeclType__Group_2_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__3_in_rule__DeclType__Group_2_1__24658);
            rule__DeclType__Group_2_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_1__2"


    // $ANTLR start "rule__DeclType__Group_2_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2203:1: rule__DeclType__Group_2_1__2__Impl : ( ( rule__DeclType__Group_2_1_2__0 )* ) ;
    public final void rule__DeclType__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2207:1: ( ( ( rule__DeclType__Group_2_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2208:1: ( ( rule__DeclType__Group_2_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2208:1: ( ( rule__DeclType__Group_2_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2209:1: ( rule__DeclType__Group_2_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getGroup_2_1_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2210:1: ( rule__DeclType__Group_2_1_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==25) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2210:2: rule__DeclType__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__DeclType__Group_2_1_2__0_in_rule__DeclType__Group_2_1__2__Impl4685);
            	    rule__DeclType__Group_2_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getGroup_2_1_2()); 
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
    // $ANTLR end "rule__DeclType__Group_2_1__2__Impl"


    // $ANTLR start "rule__DeclType__Group_2_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2220:1: rule__DeclType__Group_2_1__3 : rule__DeclType__Group_2_1__3__Impl rule__DeclType__Group_2_1__4 ;
    public final void rule__DeclType__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2224:1: ( rule__DeclType__Group_2_1__3__Impl rule__DeclType__Group_2_1__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2225:2: rule__DeclType__Group_2_1__3__Impl rule__DeclType__Group_2_1__4
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__3__Impl_in_rule__DeclType__Group_2_1__34716);
            rule__DeclType__Group_2_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__4_in_rule__DeclType__Group_2_1__34719);
            rule__DeclType__Group_2_1__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_1__3"


    // $ANTLR start "rule__DeclType__Group_2_1__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2232:1: rule__DeclType__Group_2_1__3__Impl : ( ']' ) ;
    public final void rule__DeclType__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2236:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2237:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2237:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2238:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getRightSquareBracketKeyword_2_1_3()); 
            }
            match(input,24,FOLLOW_24_in_rule__DeclType__Group_2_1__3__Impl4747); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getRightSquareBracketKeyword_2_1_3()); 
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
    // $ANTLR end "rule__DeclType__Group_2_1__3__Impl"


    // $ANTLR start "rule__DeclType__Group_2_1__4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2251:1: rule__DeclType__Group_2_1__4 : rule__DeclType__Group_2_1__4__Impl rule__DeclType__Group_2_1__5 ;
    public final void rule__DeclType__Group_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2255:1: ( rule__DeclType__Group_2_1__4__Impl rule__DeclType__Group_2_1__5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2256:2: rule__DeclType__Group_2_1__4__Impl rule__DeclType__Group_2_1__5
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__4__Impl_in_rule__DeclType__Group_2_1__44778);
            rule__DeclType__Group_2_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__5_in_rule__DeclType__Group_2_1__44781);
            rule__DeclType__Group_2_1__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_1__4"


    // $ANTLR start "rule__DeclType__Group_2_1__4__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2263:1: rule__DeclType__Group_2_1__4__Impl : ( '=' ) ;
    public final void rule__DeclType__Group_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2267:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2268:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2268:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2269:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_1_4()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclType__Group_2_1__4__Impl4809); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_1_4()); 
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
    // $ANTLR end "rule__DeclType__Group_2_1__4__Impl"


    // $ANTLR start "rule__DeclType__Group_2_1__5"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2282:1: rule__DeclType__Group_2_1__5 : rule__DeclType__Group_2_1__5__Impl ;
    public final void rule__DeclType__Group_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2286:1: ( rule__DeclType__Group_2_1__5__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2287:2: rule__DeclType__Group_2_1__5__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__5__Impl_in_rule__DeclType__Group_2_1__54840);
            rule__DeclType__Group_2_1__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_1__5"


    // $ANTLR start "rule__DeclType__Group_2_1__5__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2293:1: rule__DeclType__Group_2_1__5__Impl : ( ( rule__DeclType__ValueAssignment_2_1_5 ) ) ;
    public final void rule__DeclType__Group_2_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2297:1: ( ( ( rule__DeclType__ValueAssignment_2_1_5 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2298:1: ( ( rule__DeclType__ValueAssignment_2_1_5 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2298:1: ( ( rule__DeclType__ValueAssignment_2_1_5 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2299:1: ( rule__DeclType__ValueAssignment_2_1_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueAssignment_2_1_5()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2300:1: ( rule__DeclType__ValueAssignment_2_1_5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2300:2: rule__DeclType__ValueAssignment_2_1_5
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAssignment_2_1_5_in_rule__DeclType__Group_2_1__5__Impl4867);
            rule__DeclType__ValueAssignment_2_1_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getValueAssignment_2_1_5()); 
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
    // $ANTLR end "rule__DeclType__Group_2_1__5__Impl"


    // $ANTLR start "rule__DeclType__Group_2_1_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2322:1: rule__DeclType__Group_2_1_2__0 : rule__DeclType__Group_2_1_2__0__Impl rule__DeclType__Group_2_1_2__1 ;
    public final void rule__DeclType__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2326:1: ( rule__DeclType__Group_2_1_2__0__Impl rule__DeclType__Group_2_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2327:2: rule__DeclType__Group_2_1_2__0__Impl rule__DeclType__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1_2__0__Impl_in_rule__DeclType__Group_2_1_2__04909);
            rule__DeclType__Group_2_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1_2__1_in_rule__DeclType__Group_2_1_2__04912);
            rule__DeclType__Group_2_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_1_2__0"


    // $ANTLR start "rule__DeclType__Group_2_1_2__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2334:1: rule__DeclType__Group_2_1_2__0__Impl : ( ',' ) ;
    public final void rule__DeclType__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2338:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2339:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2339:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2340:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getCommaKeyword_2_1_2_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__DeclType__Group_2_1_2__0__Impl4940); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getCommaKeyword_2_1_2_0()); 
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
    // $ANTLR end "rule__DeclType__Group_2_1_2__0__Impl"


    // $ANTLR start "rule__DeclType__Group_2_1_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2353:1: rule__DeclType__Group_2_1_2__1 : rule__DeclType__Group_2_1_2__1__Impl ;
    public final void rule__DeclType__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2357:1: ( rule__DeclType__Group_2_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2358:2: rule__DeclType__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1_2__1__Impl_in_rule__DeclType__Group_2_1_2__14971);
            rule__DeclType__Group_2_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclType__Group_2_1_2__1"


    // $ANTLR start "rule__DeclType__Group_2_1_2__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2364:1: rule__DeclType__Group_2_1_2__1__Impl : ( ( rule__DeclType__AttrNameAssignment_2_1_2_1 ) ) ;
    public final void rule__DeclType__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2368:1: ( ( ( rule__DeclType__AttrNameAssignment_2_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2369:1: ( ( rule__DeclType__AttrNameAssignment_2_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2369:1: ( ( rule__DeclType__AttrNameAssignment_2_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2370:1: ( rule__DeclType__AttrNameAssignment_2_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_2_1_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2371:1: ( rule__DeclType__AttrNameAssignment_2_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2371:2: rule__DeclType__AttrNameAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__DeclType__AttrNameAssignment_2_1_2_1_in_rule__DeclType__Group_2_1_2__1__Impl4998);
            rule__DeclType__AttrNameAssignment_2_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_2_1_2_1()); 
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
    // $ANTLR end "rule__DeclType__Group_2_1_2__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_0__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2385:1: rule__DeclVal__Group_0__0 : rule__DeclVal__Group_0__0__Impl rule__DeclVal__Group_0__1 ;
    public final void rule__DeclVal__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2389:1: ( rule__DeclVal__Group_0__0__Impl rule__DeclVal__Group_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2390:2: rule__DeclVal__Group_0__0__Impl rule__DeclVal__Group_0__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__0__Impl_in_rule__DeclVal__Group_0__05032);
            rule__DeclVal__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_0__1_in_rule__DeclVal__Group_0__05035);
            rule__DeclVal__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2397:1: rule__DeclVal__Group_0__0__Impl : ( 'val' ) ;
    public final void rule__DeclVal__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2401:1: ( ( 'val' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2402:1: ( 'val' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2402:1: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2403:1: 'val'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getValKeyword_0_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__DeclVal__Group_0__0__Impl5063); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getValKeyword_0_0()); 
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
    // $ANTLR end "rule__DeclVal__Group_0__0__Impl"


    // $ANTLR start "rule__DeclVal__Group_0__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2416:1: rule__DeclVal__Group_0__1 : rule__DeclVal__Group_0__1__Impl rule__DeclVal__Group_0__2 ;
    public final void rule__DeclVal__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2420:1: ( rule__DeclVal__Group_0__1__Impl rule__DeclVal__Group_0__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2421:2: rule__DeclVal__Group_0__1__Impl rule__DeclVal__Group_0__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__1__Impl_in_rule__DeclVal__Group_0__15094);
            rule__DeclVal__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_0__2_in_rule__DeclVal__Group_0__15097);
            rule__DeclVal__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2428:1: rule__DeclVal__Group_0__1__Impl : ( ( rule__DeclVal__Alternatives_0_1 ) ) ;
    public final void rule__DeclVal__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2432:1: ( ( ( rule__DeclVal__Alternatives_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2433:1: ( ( rule__DeclVal__Alternatives_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2433:1: ( ( rule__DeclVal__Alternatives_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2434:1: ( rule__DeclVal__Alternatives_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getAlternatives_0_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2435:1: ( rule__DeclVal__Alternatives_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2435:2: rule__DeclVal__Alternatives_0_1
            {
            pushFollow(FOLLOW_rule__DeclVal__Alternatives_0_1_in_rule__DeclVal__Group_0__1__Impl5124);
            rule__DeclVal__Alternatives_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getAlternatives_0_1()); 
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
    // $ANTLR end "rule__DeclVal__Group_0__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_0__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2445:1: rule__DeclVal__Group_0__2 : rule__DeclVal__Group_0__2__Impl rule__DeclVal__Group_0__3 ;
    public final void rule__DeclVal__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2449:1: ( rule__DeclVal__Group_0__2__Impl rule__DeclVal__Group_0__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2450:2: rule__DeclVal__Group_0__2__Impl rule__DeclVal__Group_0__3
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__2__Impl_in_rule__DeclVal__Group_0__25154);
            rule__DeclVal__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_0__3_in_rule__DeclVal__Group_0__25157);
            rule__DeclVal__Group_0__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2457:1: rule__DeclVal__Group_0__2__Impl : ( ( rule__DeclVal__AttrAssignment_0_2 )* ) ;
    public final void rule__DeclVal__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2461:1: ( ( ( rule__DeclVal__AttrAssignment_0_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2462:1: ( ( rule__DeclVal__AttrAssignment_0_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2462:1: ( ( rule__DeclVal__AttrAssignment_0_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2463:1: ( rule__DeclVal__AttrAssignment_0_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getAttrAssignment_0_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2464:1: ( rule__DeclVal__AttrAssignment_0_2 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RULE_LHEXCHAR && LA29_0<=RULE_SLASH)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2464:2: rule__DeclVal__AttrAssignment_0_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclVal__AttrAssignment_0_2_in_rule__DeclVal__Group_0__2__Impl5184);
            	    rule__DeclVal__AttrAssignment_0_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getAttrAssignment_0_2()); 
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
    // $ANTLR end "rule__DeclVal__Group_0__2__Impl"


    // $ANTLR start "rule__DeclVal__Group_0__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2474:1: rule__DeclVal__Group_0__3 : rule__DeclVal__Group_0__3__Impl rule__DeclVal__Group_0__4 ;
    public final void rule__DeclVal__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2478:1: ( rule__DeclVal__Group_0__3__Impl rule__DeclVal__Group_0__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2479:2: rule__DeclVal__Group_0__3__Impl rule__DeclVal__Group_0__4
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__3__Impl_in_rule__DeclVal__Group_0__35215);
            rule__DeclVal__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_0__4_in_rule__DeclVal__Group_0__35218);
            rule__DeclVal__Group_0__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2486:1: rule__DeclVal__Group_0__3__Impl : ( '=' ) ;
    public final void rule__DeclVal__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2490:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2491:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2491:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2492:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getEqualsSignKeyword_0_3()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclVal__Group_0__3__Impl5246); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getEqualsSignKeyword_0_3()); 
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
    // $ANTLR end "rule__DeclVal__Group_0__3__Impl"


    // $ANTLR start "rule__DeclVal__Group_0__4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2505:1: rule__DeclVal__Group_0__4 : rule__DeclVal__Group_0__4__Impl ;
    public final void rule__DeclVal__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2509:1: ( rule__DeclVal__Group_0__4__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2510:2: rule__DeclVal__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__4__Impl_in_rule__DeclVal__Group_0__45277);
            rule__DeclVal__Group_0__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2516:1: rule__DeclVal__Group_0__4__Impl : ( ( rule__DeclVal__ExpAssignment_0_4 ) ) ;
    public final void rule__DeclVal__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2520:1: ( ( ( rule__DeclVal__ExpAssignment_0_4 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2521:1: ( ( rule__DeclVal__ExpAssignment_0_4 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2521:1: ( ( rule__DeclVal__ExpAssignment_0_4 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2522:1: ( rule__DeclVal__ExpAssignment_0_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpAssignment_0_4()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2523:1: ( rule__DeclVal__ExpAssignment_0_4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2523:2: rule__DeclVal__ExpAssignment_0_4
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpAssignment_0_4_in_rule__DeclVal__Group_0__4__Impl5304);
            rule__DeclVal__ExpAssignment_0_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getExpAssignment_0_4()); 
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
    // $ANTLR end "rule__DeclVal__Group_0__4__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2543:1: rule__DeclVal__Group_1__0 : rule__DeclVal__Group_1__0__Impl rule__DeclVal__Group_1__1 ;
    public final void rule__DeclVal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2547:1: ( rule__DeclVal__Group_1__0__Impl rule__DeclVal__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2548:2: rule__DeclVal__Group_1__0__Impl rule__DeclVal__Group_1__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__0__Impl_in_rule__DeclVal__Group_1__05344);
            rule__DeclVal__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__1_in_rule__DeclVal__Group_1__05347);
            rule__DeclVal__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2555:1: rule__DeclVal__Group_1__0__Impl : ( 'val' ) ;
    public final void rule__DeclVal__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2559:1: ( ( 'val' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2560:1: ( 'val' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2560:1: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2561:1: 'val'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getValKeyword_1_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__DeclVal__Group_1__0__Impl5375); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getValKeyword_1_0()); 
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
    // $ANTLR end "rule__DeclVal__Group_1__0__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2574:1: rule__DeclVal__Group_1__1 : rule__DeclVal__Group_1__1__Impl rule__DeclVal__Group_1__2 ;
    public final void rule__DeclVal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2578:1: ( rule__DeclVal__Group_1__1__Impl rule__DeclVal__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2579:2: rule__DeclVal__Group_1__1__Impl rule__DeclVal__Group_1__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__1__Impl_in_rule__DeclVal__Group_1__15406);
            rule__DeclVal__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__2_in_rule__DeclVal__Group_1__15409);
            rule__DeclVal__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2586:1: rule__DeclVal__Group_1__1__Impl : ( ( rule__DeclVal__NameAssignment_1_1 ) ) ;
    public final void rule__DeclVal__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2590:1: ( ( ( rule__DeclVal__NameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2591:1: ( ( rule__DeclVal__NameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2591:1: ( ( rule__DeclVal__NameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2592:1: ( rule__DeclVal__NameAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getNameAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2593:1: ( rule__DeclVal__NameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2593:2: rule__DeclVal__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__DeclVal__NameAssignment_1_1_in_rule__DeclVal__Group_1__1__Impl5436);
            rule__DeclVal__NameAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getNameAssignment_1_1()); 
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
    // $ANTLR end "rule__DeclVal__Group_1__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2603:1: rule__DeclVal__Group_1__2 : rule__DeclVal__Group_1__2__Impl rule__DeclVal__Group_1__3 ;
    public final void rule__DeclVal__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2607:1: ( rule__DeclVal__Group_1__2__Impl rule__DeclVal__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2608:2: rule__DeclVal__Group_1__2__Impl rule__DeclVal__Group_1__3
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__2__Impl_in_rule__DeclVal__Group_1__25466);
            rule__DeclVal__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__3_in_rule__DeclVal__Group_1__25469);
            rule__DeclVal__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2615:1: rule__DeclVal__Group_1__2__Impl : ( '[' ) ;
    public final void rule__DeclVal__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2619:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2620:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2620:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2621:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2()); 
            }
            match(input,23,FOLLOW_23_in_rule__DeclVal__Group_1__2__Impl5497); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2()); 
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
    // $ANTLR end "rule__DeclVal__Group_1__2__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2634:1: rule__DeclVal__Group_1__3 : rule__DeclVal__Group_1__3__Impl rule__DeclVal__Group_1__4 ;
    public final void rule__DeclVal__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2638:1: ( rule__DeclVal__Group_1__3__Impl rule__DeclVal__Group_1__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2639:2: rule__DeclVal__Group_1__3__Impl rule__DeclVal__Group_1__4
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__3__Impl_in_rule__DeclVal__Group_1__35528);
            rule__DeclVal__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__4_in_rule__DeclVal__Group_1__35531);
            rule__DeclVal__Group_1__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2646:1: rule__DeclVal__Group_1__3__Impl : ( ( rule__DeclVal__Group_1_3__0 )? ) ;
    public final void rule__DeclVal__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2650:1: ( ( ( rule__DeclVal__Group_1_3__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2651:1: ( ( rule__DeclVal__Group_1_3__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2651:1: ( ( rule__DeclVal__Group_1_3__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2652:1: ( rule__DeclVal__Group_1_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getGroup_1_3()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2653:1: ( rule__DeclVal__Group_1_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_LHEXCHAR && LA30_0<=RULE_SLASH)||LA30_0==RULE_BINDIG||LA30_0==RULE_NBINDIG||LA30_0==31||(LA30_0>=33 && LA30_0<=34)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2653:2: rule__DeclVal__Group_1_3__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1_3__0_in_rule__DeclVal__Group_1__3__Impl5558);
                    rule__DeclVal__Group_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getGroup_1_3()); 
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
    // $ANTLR end "rule__DeclVal__Group_1__3__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2663:1: rule__DeclVal__Group_1__4 : rule__DeclVal__Group_1__4__Impl rule__DeclVal__Group_1__5 ;
    public final void rule__DeclVal__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2667:1: ( rule__DeclVal__Group_1__4__Impl rule__DeclVal__Group_1__5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2668:2: rule__DeclVal__Group_1__4__Impl rule__DeclVal__Group_1__5
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__4__Impl_in_rule__DeclVal__Group_1__45589);
            rule__DeclVal__Group_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__5_in_rule__DeclVal__Group_1__45592);
            rule__DeclVal__Group_1__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2675:1: rule__DeclVal__Group_1__4__Impl : ( ']' ) ;
    public final void rule__DeclVal__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2679:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2680:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2680:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2681:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_4()); 
            }
            match(input,24,FOLLOW_24_in_rule__DeclVal__Group_1__4__Impl5620); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_4()); 
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
    // $ANTLR end "rule__DeclVal__Group_1__4__Impl"


    // $ANTLR start "rule__DeclVal__Group_1__5"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2694:1: rule__DeclVal__Group_1__5 : rule__DeclVal__Group_1__5__Impl ;
    public final void rule__DeclVal__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2698:1: ( rule__DeclVal__Group_1__5__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2699:2: rule__DeclVal__Group_1__5__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__5__Impl_in_rule__DeclVal__Group_1__55651);
            rule__DeclVal__Group_1__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2705:1: rule__DeclVal__Group_1__5__Impl : ( ( rule__DeclVal__Alternatives_1_5 ) ) ;
    public final void rule__DeclVal__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2709:1: ( ( ( rule__DeclVal__Alternatives_1_5 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2710:1: ( ( rule__DeclVal__Alternatives_1_5 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2710:1: ( ( rule__DeclVal__Alternatives_1_5 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2711:1: ( rule__DeclVal__Alternatives_1_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getAlternatives_1_5()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2712:1: ( rule__DeclVal__Alternatives_1_5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2712:2: rule__DeclVal__Alternatives_1_5
            {
            pushFollow(FOLLOW_rule__DeclVal__Alternatives_1_5_in_rule__DeclVal__Group_1__5__Impl5678);
            rule__DeclVal__Alternatives_1_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getAlternatives_1_5()); 
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
    // $ANTLR end "rule__DeclVal__Group_1__5__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_3__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2734:1: rule__DeclVal__Group_1_3__0 : rule__DeclVal__Group_1_3__0__Impl rule__DeclVal__Group_1_3__1 ;
    public final void rule__DeclVal__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2738:1: ( rule__DeclVal__Group_1_3__0__Impl rule__DeclVal__Group_1_3__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2739:2: rule__DeclVal__Group_1_3__0__Impl rule__DeclVal__Group_1_3__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_3__0__Impl_in_rule__DeclVal__Group_1_3__05720);
            rule__DeclVal__Group_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_3__1_in_rule__DeclVal__Group_1_3__05723);
            rule__DeclVal__Group_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__Group_1_3__0"


    // $ANTLR start "rule__DeclVal__Group_1_3__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2746:1: rule__DeclVal__Group_1_3__0__Impl : ( ( rule__DeclVal__DecPatAssignment_1_3_0 ) ) ;
    public final void rule__DeclVal__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2750:1: ( ( ( rule__DeclVal__DecPatAssignment_1_3_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2751:1: ( ( rule__DeclVal__DecPatAssignment_1_3_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2751:1: ( ( rule__DeclVal__DecPatAssignment_1_3_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2752:1: ( rule__DeclVal__DecPatAssignment_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getDecPatAssignment_1_3_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2753:1: ( rule__DeclVal__DecPatAssignment_1_3_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2753:2: rule__DeclVal__DecPatAssignment_1_3_0
            {
            pushFollow(FOLLOW_rule__DeclVal__DecPatAssignment_1_3_0_in_rule__DeclVal__Group_1_3__0__Impl5750);
            rule__DeclVal__DecPatAssignment_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getDecPatAssignment_1_3_0()); 
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
    // $ANTLR end "rule__DeclVal__Group_1_3__0__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_3__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2763:1: rule__DeclVal__Group_1_3__1 : rule__DeclVal__Group_1_3__1__Impl ;
    public final void rule__DeclVal__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2767:1: ( rule__DeclVal__Group_1_3__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2768:2: rule__DeclVal__Group_1_3__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_3__1__Impl_in_rule__DeclVal__Group_1_3__15780);
            rule__DeclVal__Group_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclVal__Group_1_3__1"


    // $ANTLR start "rule__DeclVal__Group_1_3__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2774:1: rule__DeclVal__Group_1_3__1__Impl : ( ( rule__DeclVal__DecPatAssignment_1_3_1 )* ) ;
    public final void rule__DeclVal__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2778:1: ( ( ( rule__DeclVal__DecPatAssignment_1_3_1 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2779:1: ( ( rule__DeclVal__DecPatAssignment_1_3_1 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2779:1: ( ( rule__DeclVal__DecPatAssignment_1_3_1 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2780:1: ( rule__DeclVal__DecPatAssignment_1_3_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getDecPatAssignment_1_3_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2781:1: ( rule__DeclVal__DecPatAssignment_1_3_1 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=RULE_LHEXCHAR && LA31_0<=RULE_SLASH)||LA31_0==RULE_BINDIG||LA31_0==RULE_NBINDIG||LA31_0==31||(LA31_0>=33 && LA31_0<=34)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2781:2: rule__DeclVal__DecPatAssignment_1_3_1
            	    {
            	    pushFollow(FOLLOW_rule__DeclVal__DecPatAssignment_1_3_1_in_rule__DeclVal__Group_1_3__1__Impl5807);
            	    rule__DeclVal__DecPatAssignment_1_3_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getDecPatAssignment_1_3_1()); 
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
    // $ANTLR end "rule__DeclVal__Group_1_3__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_0__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2795:1: rule__DeclVal__Group_1_5_0__0 : rule__DeclVal__Group_1_5_0__0__Impl rule__DeclVal__Group_1_5_0__1 ;
    public final void rule__DeclVal__Group_1_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2799:1: ( rule__DeclVal__Group_1_5_0__0__Impl rule__DeclVal__Group_1_5_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2800:2: rule__DeclVal__Group_1_5_0__0__Impl rule__DeclVal__Group_1_5_0__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__0__Impl_in_rule__DeclVal__Group_1_5_0__05842);
            rule__DeclVal__Group_1_5_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__1_in_rule__DeclVal__Group_1_5_0__05845);
            rule__DeclVal__Group_1_5_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2807:1: rule__DeclVal__Group_1_5_0__0__Impl : ( '=' ) ;
    public final void rule__DeclVal__Group_1_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2811:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2812:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2812:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2813:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_0_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclVal__Group_1_5_0__0__Impl5873); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_0_0()); 
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
    // $ANTLR end "rule__DeclVal__Group_1_5_0__0__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_0__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2826:1: rule__DeclVal__Group_1_5_0__1 : rule__DeclVal__Group_1_5_0__1__Impl ;
    public final void rule__DeclVal__Group_1_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2830:1: ( rule__DeclVal__Group_1_5_0__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2831:2: rule__DeclVal__Group_1_5_0__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__1__Impl_in_rule__DeclVal__Group_1_5_0__15904);
            rule__DeclVal__Group_1_5_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2837:1: rule__DeclVal__Group_1_5_0__1__Impl : ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) ) ;
    public final void rule__DeclVal__Group_1_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2841:1: ( ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2842:1: ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2842:1: ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2843:1: ( rule__DeclVal__ExpAssignment_1_5_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpAssignment_1_5_0_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2844:1: ( rule__DeclVal__ExpAssignment_1_5_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2844:2: rule__DeclVal__ExpAssignment_1_5_0_1
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpAssignment_1_5_0_1_in_rule__DeclVal__Group_1_5_0__1__Impl5931);
            rule__DeclVal__ExpAssignment_1_5_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getExpAssignment_1_5_0_1()); 
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
    // $ANTLR end "rule__DeclVal__Group_1_5_0__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2858:1: rule__DeclVal__Group_1_5_1__0 : rule__DeclVal__Group_1_5_1__0__Impl rule__DeclVal__Group_1_5_1__1 ;
    public final void rule__DeclVal__Group_1_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2862:1: ( rule__DeclVal__Group_1_5_1__0__Impl rule__DeclVal__Group_1_5_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2863:2: rule__DeclVal__Group_1_5_1__0__Impl rule__DeclVal__Group_1_5_1__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__0__Impl_in_rule__DeclVal__Group_1_5_1__05965);
            rule__DeclVal__Group_1_5_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__1_in_rule__DeclVal__Group_1_5_1__05968);
            rule__DeclVal__Group_1_5_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2870:1: rule__DeclVal__Group_1_5_1__0__Impl : ( RULE_PIPE ) ;
    public final void rule__DeclVal__Group_1_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2874:1: ( ( RULE_PIPE ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2875:1: ( RULE_PIPE )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2875:1: ( RULE_PIPE )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2876:1: RULE_PIPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getPIPETerminalRuleCall_1_5_1_0()); 
            }
            match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__DeclVal__Group_1_5_1__0__Impl5995); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getPIPETerminalRuleCall_1_5_1_0()); 
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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__0__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2887:1: rule__DeclVal__Group_1_5_1__1 : rule__DeclVal__Group_1_5_1__1__Impl rule__DeclVal__Group_1_5_1__2 ;
    public final void rule__DeclVal__Group_1_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2891:1: ( rule__DeclVal__Group_1_5_1__1__Impl rule__DeclVal__Group_1_5_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2892:2: rule__DeclVal__Group_1_5_1__1__Impl rule__DeclVal__Group_1_5_1__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__1__Impl_in_rule__DeclVal__Group_1_5_1__16024);
            rule__DeclVal__Group_1_5_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__2_in_rule__DeclVal__Group_1_5_1__16027);
            rule__DeclVal__Group_1_5_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2899:1: rule__DeclVal__Group_1_5_1__1__Impl : ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) ) ;
    public final void rule__DeclVal__Group_1_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2903:1: ( ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2904:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2904:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2905:1: ( rule__DeclVal__ExpsAssignment_1_5_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2906:1: ( rule__DeclVal__ExpsAssignment_1_5_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2906:2: rule__DeclVal__ExpsAssignment_1_5_1_1
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_1_in_rule__DeclVal__Group_1_5_1__1__Impl6054);
            rule__DeclVal__ExpsAssignment_1_5_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_1()); 
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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__1__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2916:1: rule__DeclVal__Group_1_5_1__2 : rule__DeclVal__Group_1_5_1__2__Impl rule__DeclVal__Group_1_5_1__3 ;
    public final void rule__DeclVal__Group_1_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2920:1: ( rule__DeclVal__Group_1_5_1__2__Impl rule__DeclVal__Group_1_5_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2921:2: rule__DeclVal__Group_1_5_1__2__Impl rule__DeclVal__Group_1_5_1__3
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__2__Impl_in_rule__DeclVal__Group_1_5_1__26084);
            rule__DeclVal__Group_1_5_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__3_in_rule__DeclVal__Group_1_5_1__26087);
            rule__DeclVal__Group_1_5_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2928:1: rule__DeclVal__Group_1_5_1__2__Impl : ( '=' ) ;
    public final void rule__DeclVal__Group_1_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2932:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2933:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2933:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2934:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_1_2()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclVal__Group_1_5_1__2__Impl6115); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_1_2()); 
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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__2__Impl"


    // $ANTLR start "rule__DeclVal__Group_1_5_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2947:1: rule__DeclVal__Group_1_5_1__3 : rule__DeclVal__Group_1_5_1__3__Impl ;
    public final void rule__DeclVal__Group_1_5_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2951:1: ( rule__DeclVal__Group_1_5_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2952:2: rule__DeclVal__Group_1_5_1__3__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__3__Impl_in_rule__DeclVal__Group_1_5_1__36146);
            rule__DeclVal__Group_1_5_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2958:1: rule__DeclVal__Group_1_5_1__3__Impl : ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) ) ;
    public final void rule__DeclVal__Group_1_5_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2962:1: ( ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2963:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2963:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2964:1: ( rule__DeclVal__ExpsAssignment_1_5_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_3()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2965:1: ( rule__DeclVal__ExpsAssignment_1_5_1_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2965:2: rule__DeclVal__ExpsAssignment_1_5_1_3
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_3_in_rule__DeclVal__Group_1_5_1__3__Impl6173);
            rule__DeclVal__ExpsAssignment_1_5_1_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_3()); 
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
    // $ANTLR end "rule__DeclVal__Group_1_5_1__3__Impl"


    // $ANTLR start "rule__Export__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2983:1: rule__Export__Group__0 : rule__Export__Group__0__Impl rule__Export__Group__1 ;
    public final void rule__Export__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2987:1: ( rule__Export__Group__0__Impl rule__Export__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2988:2: rule__Export__Group__0__Impl rule__Export__Group__1
            {
            pushFollow(FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__06211);
            rule__Export__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group__1_in_rule__Export__Group__06214);
            rule__Export__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2995:1: rule__Export__Group__0__Impl : ( ( rule__Export__NameAssignment_0 ) ) ;
    public final void rule__Export__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2999:1: ( ( ( rule__Export__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3000:1: ( ( rule__Export__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3000:1: ( ( rule__Export__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3001:1: ( rule__Export__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3002:1: ( rule__Export__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3002:2: rule__Export__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl6241);
            rule__Export__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__Export__Group__0__Impl"


    // $ANTLR start "rule__Export__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3012:1: rule__Export__Group__1 : rule__Export__Group__1__Impl ;
    public final void rule__Export__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3016:1: ( rule__Export__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3017:2: rule__Export__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__16271);
            rule__Export__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3023:1: rule__Export__Group__1__Impl : ( ( rule__Export__Group_1__0 )? ) ;
    public final void rule__Export__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3027:1: ( ( ( rule__Export__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3028:1: ( ( rule__Export__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3028:1: ( ( rule__Export__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3029:1: ( rule__Export__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3030:1: ( rule__Export__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==27) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3030:2: rule__Export__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl6298);
                    rule__Export__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Export__Group__1__Impl"


    // $ANTLR start "rule__Export__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3044:1: rule__Export__Group_1__0 : rule__Export__Group_1__0__Impl rule__Export__Group_1__1 ;
    public final void rule__Export__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3048:1: ( rule__Export__Group_1__0__Impl rule__Export__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3049:2: rule__Export__Group_1__0__Impl rule__Export__Group_1__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__06333);
            rule__Export__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__06336);
            rule__Export__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3056:1: rule__Export__Group_1__0__Impl : ( '{' ) ;
    public final void rule__Export__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3060:1: ( ( '{' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3061:1: ( '{' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3061:1: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3062:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Export__Group_1__0__Impl6364); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0()); 
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
    // $ANTLR end "rule__Export__Group_1__0__Impl"


    // $ANTLR start "rule__Export__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3075:1: rule__Export__Group_1__1 : rule__Export__Group_1__1__Impl rule__Export__Group_1__2 ;
    public final void rule__Export__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3079:1: ( rule__Export__Group_1__1__Impl rule__Export__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3080:2: rule__Export__Group_1__1__Impl rule__Export__Group_1__2
            {
            pushFollow(FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__16395);
            rule__Export__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__16398);
            rule__Export__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3087:1: rule__Export__Group_1__1__Impl : ( ( rule__Export__AttrNameAssignment_1_1 ) ) ;
    public final void rule__Export__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3091:1: ( ( ( rule__Export__AttrNameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3092:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3092:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3093:1: ( rule__Export__AttrNameAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getAttrNameAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3094:1: ( rule__Export__AttrNameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3094:2: rule__Export__AttrNameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl6425);
            rule__Export__AttrNameAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getAttrNameAssignment_1_1()); 
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
    // $ANTLR end "rule__Export__Group_1__1__Impl"


    // $ANTLR start "rule__Export__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3104:1: rule__Export__Group_1__2 : rule__Export__Group_1__2__Impl rule__Export__Group_1__3 ;
    public final void rule__Export__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3108:1: ( rule__Export__Group_1__2__Impl rule__Export__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3109:2: rule__Export__Group_1__2__Impl rule__Export__Group_1__3
            {
            pushFollow(FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__26455);
            rule__Export__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__26458);
            rule__Export__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3116:1: rule__Export__Group_1__2__Impl : ( ( rule__Export__Group_1_2__0 )* ) ;
    public final void rule__Export__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3120:1: ( ( ( rule__Export__Group_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3121:1: ( ( rule__Export__Group_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3121:1: ( ( rule__Export__Group_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3122:1: ( rule__Export__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getGroup_1_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3123:1: ( rule__Export__Group_1_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==25) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3123:2: rule__Export__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl6485);
            	    rule__Export__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getGroup_1_2()); 
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
    // $ANTLR end "rule__Export__Group_1__2__Impl"


    // $ANTLR start "rule__Export__Group_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3133:1: rule__Export__Group_1__3 : rule__Export__Group_1__3__Impl ;
    public final void rule__Export__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3137:1: ( rule__Export__Group_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3138:2: rule__Export__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__36516);
            rule__Export__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3144:1: rule__Export__Group_1__3__Impl : ( '}' ) ;
    public final void rule__Export__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3148:1: ( ( '}' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3149:1: ( '}' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3149:1: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3150:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getRightCurlyBracketKeyword_1_3()); 
            }
            match(input,28,FOLLOW_28_in_rule__Export__Group_1__3__Impl6544); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getRightCurlyBracketKeyword_1_3()); 
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
    // $ANTLR end "rule__Export__Group_1__3__Impl"


    // $ANTLR start "rule__Export__Group_1_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3171:1: rule__Export__Group_1_2__0 : rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 ;
    public final void rule__Export__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3175:1: ( rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3176:2: rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__06583);
            rule__Export__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__06586);
            rule__Export__Group_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3183:1: rule__Export__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__Export__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3187:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3188:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3188:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3189:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__Export__Group_1_2__0__Impl6614); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getCommaKeyword_1_2_0()); 
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
    // $ANTLR end "rule__Export__Group_1_2__0__Impl"


    // $ANTLR start "rule__Export__Group_1_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3202:1: rule__Export__Group_1_2__1 : rule__Export__Group_1_2__1__Impl ;
    public final void rule__Export__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3206:1: ( rule__Export__Group_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3207:2: rule__Export__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__16645);
            rule__Export__Group_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3213:1: rule__Export__Group_1_2__1__Impl : ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) ;
    public final void rule__Export__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3217:1: ( ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3218:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3218:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3219:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getAttrNameAssignment_1_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3220:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3220:2: rule__Export__AttrNameAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl6672);
            rule__Export__AttrNameAssignment_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getAttrNameAssignment_1_2_1()); 
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
    // $ANTLR end "rule__Export__Group_1_2__1__Impl"


    // $ANTLR start "rule__ConDecls__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3234:1: rule__ConDecls__Group__0 : rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1 ;
    public final void rule__ConDecls__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3238:1: ( rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3239:2: rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__0__Impl_in_rule__ConDecls__Group__06706);
            rule__ConDecls__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConDecls__Group__1_in_rule__ConDecls__Group__06709);
            rule__ConDecls__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3246:1: rule__ConDecls__Group__0__Impl : ( ( rule__ConDecls__ConDeclsAssignment_0 ) ) ;
    public final void rule__ConDecls__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3250:1: ( ( ( rule__ConDecls__ConDeclsAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3251:1: ( ( rule__ConDecls__ConDeclsAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3251:1: ( ( rule__ConDecls__ConDeclsAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3252:1: ( rule__ConDecls__ConDeclsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getConDeclsAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3253:1: ( rule__ConDecls__ConDeclsAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3253:2: rule__ConDecls__ConDeclsAssignment_0
            {
            pushFollow(FOLLOW_rule__ConDecls__ConDeclsAssignment_0_in_rule__ConDecls__Group__0__Impl6736);
            rule__ConDecls__ConDeclsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclsAccess().getConDeclsAssignment_0()); 
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
    // $ANTLR end "rule__ConDecls__Group__0__Impl"


    // $ANTLR start "rule__ConDecls__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3263:1: rule__ConDecls__Group__1 : rule__ConDecls__Group__1__Impl ;
    public final void rule__ConDecls__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3267:1: ( rule__ConDecls__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3268:2: rule__ConDecls__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__1__Impl_in_rule__ConDecls__Group__16766);
            rule__ConDecls__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3274:1: rule__ConDecls__Group__1__Impl : ( ( rule__ConDecls__Group_1__0 )* ) ;
    public final void rule__ConDecls__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3278:1: ( ( ( rule__ConDecls__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3279:1: ( ( rule__ConDecls__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3279:1: ( ( rule__ConDecls__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3280:1: ( rule__ConDecls__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3281:1: ( rule__ConDecls__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_PIPE) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3281:2: rule__ConDecls__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConDecls__Group_1__0_in_rule__ConDecls__Group__1__Impl6793);
            	    rule__ConDecls__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclsAccess().getGroup_1()); 
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
    // $ANTLR end "rule__ConDecls__Group__1__Impl"


    // $ANTLR start "rule__ConDecls__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3295:1: rule__ConDecls__Group_1__0 : rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1 ;
    public final void rule__ConDecls__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3299:1: ( rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3300:2: rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConDecls__Group_1__0__Impl_in_rule__ConDecls__Group_1__06828);
            rule__ConDecls__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConDecls__Group_1__1_in_rule__ConDecls__Group_1__06831);
            rule__ConDecls__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3307:1: rule__ConDecls__Group_1__0__Impl : ( RULE_PIPE ) ;
    public final void rule__ConDecls__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3311:1: ( ( RULE_PIPE ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3312:1: ( RULE_PIPE )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3312:1: ( RULE_PIPE )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3313:1: RULE_PIPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getPIPETerminalRuleCall_1_0()); 
            }
            match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__ConDecls__Group_1__0__Impl6858); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclsAccess().getPIPETerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__ConDecls__Group_1__0__Impl"


    // $ANTLR start "rule__ConDecls__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3324:1: rule__ConDecls__Group_1__1 : rule__ConDecls__Group_1__1__Impl ;
    public final void rule__ConDecls__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3328:1: ( rule__ConDecls__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3329:2: rule__ConDecls__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecls__Group_1__1__Impl_in_rule__ConDecls__Group_1__16887);
            rule__ConDecls__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3335:1: rule__ConDecls__Group_1__1__Impl : ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) ) ;
    public final void rule__ConDecls__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3339:1: ( ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3340:1: ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3340:1: ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3341:1: ( rule__ConDecls__ConDeclsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getConDeclsAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3342:1: ( rule__ConDecls__ConDeclsAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3342:2: rule__ConDecls__ConDeclsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConDecls__ConDeclsAssignment_1_1_in_rule__ConDecls__Group_1__1__Impl6914);
            rule__ConDecls__ConDeclsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclsAccess().getConDeclsAssignment_1_1()); 
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
    // $ANTLR end "rule__ConDecls__Group_1__1__Impl"


    // $ANTLR start "rule__ConDecl__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3356:1: rule__ConDecl__Group__0 : rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1 ;
    public final void rule__ConDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3360:1: ( rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3361:2: rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__0__Impl_in_rule__ConDecl__Group__06948);
            rule__ConDecl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConDecl__Group__1_in_rule__ConDecl__Group__06951);
            rule__ConDecl__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3368:1: rule__ConDecl__Group__0__Impl : ( ( rule__ConDecl__NameAssignment_0 ) ) ;
    public final void rule__ConDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3372:1: ( ( ( rule__ConDecl__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3373:1: ( ( rule__ConDecl__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3373:1: ( ( rule__ConDecl__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3374:1: ( rule__ConDecl__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3375:1: ( rule__ConDecl__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3375:2: rule__ConDecl__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ConDecl__NameAssignment_0_in_rule__ConDecl__Group__0__Impl6978);
            rule__ConDecl__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__ConDecl__Group__0__Impl"


    // $ANTLR start "rule__ConDecl__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3385:1: rule__ConDecl__Group__1 : rule__ConDecl__Group__1__Impl ;
    public final void rule__ConDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3389:1: ( rule__ConDecl__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3390:2: rule__ConDecl__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__1__Impl_in_rule__ConDecl__Group__17008);
            rule__ConDecl__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3396:1: rule__ConDecl__Group__1__Impl : ( ( rule__ConDecl__Group_1__0 )? ) ;
    public final void rule__ConDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3400:1: ( ( ( rule__ConDecl__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3401:1: ( ( rule__ConDecl__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3401:1: ( ( rule__ConDecl__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3402:1: ( rule__ConDecl__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3403:1: ( rule__ConDecl__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==29) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3403:2: rule__ConDecl__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConDecl__Group_1__0_in_rule__ConDecl__Group__1__Impl7035);
                    rule__ConDecl__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclAccess().getGroup_1()); 
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
    // $ANTLR end "rule__ConDecl__Group__1__Impl"


    // $ANTLR start "rule__ConDecl__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3417:1: rule__ConDecl__Group_1__0 : rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1 ;
    public final void rule__ConDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3421:1: ( rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3422:2: rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConDecl__Group_1__0__Impl_in_rule__ConDecl__Group_1__07070);
            rule__ConDecl__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConDecl__Group_1__1_in_rule__ConDecl__Group_1__07073);
            rule__ConDecl__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3429:1: rule__ConDecl__Group_1__0__Impl : ( 'of' ) ;
    public final void rule__ConDecl__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3433:1: ( ( 'of' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3434:1: ( 'of' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3434:1: ( 'of' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3435:1: 'of'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getOfKeyword_1_0()); 
            }
            match(input,29,FOLLOW_29_in_rule__ConDecl__Group_1__0__Impl7101); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclAccess().getOfKeyword_1_0()); 
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
    // $ANTLR end "rule__ConDecl__Group_1__0__Impl"


    // $ANTLR start "rule__ConDecl__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3448:1: rule__ConDecl__Group_1__1 : rule__ConDecl__Group_1__1__Impl ;
    public final void rule__ConDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3452:1: ( rule__ConDecl__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3453:2: rule__ConDecl__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecl__Group_1__1__Impl_in_rule__ConDecl__Group_1__17132);
            rule__ConDecl__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3459:1: rule__ConDecl__Group_1__1__Impl : ( ( rule__ConDecl__TyAssignment_1_1 ) ) ;
    public final void rule__ConDecl__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3463:1: ( ( ( rule__ConDecl__TyAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3464:1: ( ( rule__ConDecl__TyAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3464:1: ( ( rule__ConDecl__TyAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3465:1: ( rule__ConDecl__TyAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getTyAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3466:1: ( rule__ConDecl__TyAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3466:2: rule__ConDecl__TyAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConDecl__TyAssignment_1_1_in_rule__ConDecl__Group_1__1__Impl7159);
            rule__ConDecl__TyAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclAccess().getTyAssignment_1_1()); 
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
    // $ANTLR end "rule__ConDecl__Group_1__1__Impl"


    // $ANTLR start "rule__Ty__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3480:1: rule__Ty__Group_1__0 : rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1 ;
    public final void rule__Ty__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3484:1: ( rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3485:2: rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__0__Impl_in_rule__Ty__Group_1__07193);
            rule__Ty__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_1__1_in_rule__Ty__Group_1__07196);
            rule__Ty__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3492:1: rule__Ty__Group_1__0__Impl : ( RULE_PIPE ) ;
    public final void rule__Ty__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3496:1: ( ( RULE_PIPE ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3497:1: ( RULE_PIPE )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3497:1: ( RULE_PIPE )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3498:1: RULE_PIPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_0()); 
            }
            match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__Ty__Group_1__0__Impl7223); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Ty__Group_1__0__Impl"


    // $ANTLR start "rule__Ty__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3509:1: rule__Ty__Group_1__1 : rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2 ;
    public final void rule__Ty__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3513:1: ( rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3514:2: rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__1__Impl_in_rule__Ty__Group_1__17252);
            rule__Ty__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_1__2_in_rule__Ty__Group_1__17255);
            rule__Ty__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3521:1: rule__Ty__Group_1__1__Impl : ( ( rule__Ty__ValueAssignment_1_1 ) ) ;
    public final void rule__Ty__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3525:1: ( ( ( rule__Ty__ValueAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3526:1: ( ( rule__Ty__ValueAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3526:1: ( ( rule__Ty__ValueAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3527:1: ( rule__Ty__ValueAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3528:1: ( rule__Ty__ValueAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3528:2: rule__Ty__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Ty__ValueAssignment_1_1_in_rule__Ty__Group_1__1__Impl7282);
            rule__Ty__ValueAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getValueAssignment_1_1()); 
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
    // $ANTLR end "rule__Ty__Group_1__1__Impl"


    // $ANTLR start "rule__Ty__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3538:1: rule__Ty__Group_1__2 : rule__Ty__Group_1__2__Impl ;
    public final void rule__Ty__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3542:1: ( rule__Ty__Group_1__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3543:2: rule__Ty__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__2__Impl_in_rule__Ty__Group_1__27312);
            rule__Ty__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3549:1: rule__Ty__Group_1__2__Impl : ( RULE_PIPE ) ;
    public final void rule__Ty__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3553:1: ( ( RULE_PIPE ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3554:1: ( RULE_PIPE )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3554:1: ( RULE_PIPE )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3555:1: RULE_PIPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_2()); 
            }
            match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__Ty__Group_1__2__Impl7339); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_2()); 
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
    // $ANTLR end "rule__Ty__Group_1__2__Impl"


    // $ANTLR start "rule__Ty__Group_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3572:1: rule__Ty__Group_2__0 : rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1 ;
    public final void rule__Ty__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3576:1: ( rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3577:2: rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2__0__Impl_in_rule__Ty__Group_2__07374);
            rule__Ty__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2__1_in_rule__Ty__Group_2__07377);
            rule__Ty__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3584:1: rule__Ty__Group_2__0__Impl : ( ( rule__Ty__ValueAssignment_2_0 ) ) ;
    public final void rule__Ty__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3588:1: ( ( ( rule__Ty__ValueAssignment_2_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3589:1: ( ( rule__Ty__ValueAssignment_2_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3589:1: ( ( rule__Ty__ValueAssignment_2_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3590:1: ( rule__Ty__ValueAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueAssignment_2_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3591:1: ( rule__Ty__ValueAssignment_2_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3591:2: rule__Ty__ValueAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Ty__ValueAssignment_2_0_in_rule__Ty__Group_2__0__Impl7404);
            rule__Ty__ValueAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getValueAssignment_2_0()); 
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
    // $ANTLR end "rule__Ty__Group_2__0__Impl"


    // $ANTLR start "rule__Ty__Group_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3601:1: rule__Ty__Group_2__1 : rule__Ty__Group_2__1__Impl ;
    public final void rule__Ty__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3605:1: ( rule__Ty__Group_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3606:2: rule__Ty__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2__1__Impl_in_rule__Ty__Group_2__17434);
            rule__Ty__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3612:1: rule__Ty__Group_2__1__Impl : ( ( rule__Ty__Group_2_1__0 )? ) ;
    public final void rule__Ty__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3616:1: ( ( ( rule__Ty__Group_2_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3617:1: ( ( rule__Ty__Group_2_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3617:1: ( ( rule__Ty__Group_2_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3618:1: ( rule__Ty__Group_2_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getGroup_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3619:1: ( rule__Ty__Group_2_1__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==23) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3619:2: rule__Ty__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_2_1__0_in_rule__Ty__Group_2__1__Impl7461);
                    rule__Ty__Group_2_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getGroup_2_1()); 
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
    // $ANTLR end "rule__Ty__Group_2__1__Impl"


    // $ANTLR start "rule__Ty__Group_2_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3633:1: rule__Ty__Group_2_1__0 : rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1 ;
    public final void rule__Ty__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3637:1: ( rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3638:2: rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__0__Impl_in_rule__Ty__Group_2_1__07496);
            rule__Ty__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2_1__1_in_rule__Ty__Group_2_1__07499);
            rule__Ty__Group_2_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3645:1: rule__Ty__Group_2_1__0__Impl : ( '[' ) ;
    public final void rule__Ty__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3649:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3650:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3650:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3651:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Ty__Group_2_1__0__Impl7527); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0()); 
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
    // $ANTLR end "rule__Ty__Group_2_1__0__Impl"


    // $ANTLR start "rule__Ty__Group_2_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3664:1: rule__Ty__Group_2_1__1 : rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2 ;
    public final void rule__Ty__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3668:1: ( rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3669:2: rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__1__Impl_in_rule__Ty__Group_2_1__17558);
            rule__Ty__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2_1__2_in_rule__Ty__Group_2_1__17561);
            rule__Ty__Group_2_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3676:1: rule__Ty__Group_2_1__1__Impl : ( ( rule__Ty__TyBindAssignment_2_1_1 ) ) ;
    public final void rule__Ty__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3680:1: ( ( ( rule__Ty__TyBindAssignment_2_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3681:1: ( ( rule__Ty__TyBindAssignment_2_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3681:1: ( ( rule__Ty__TyBindAssignment_2_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3682:1: ( rule__Ty__TyBindAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getTyBindAssignment_2_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3683:1: ( rule__Ty__TyBindAssignment_2_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3683:2: rule__Ty__TyBindAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Ty__TyBindAssignment_2_1_1_in_rule__Ty__Group_2_1__1__Impl7588);
            rule__Ty__TyBindAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getTyBindAssignment_2_1_1()); 
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
    // $ANTLR end "rule__Ty__Group_2_1__1__Impl"


    // $ANTLR start "rule__Ty__Group_2_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3693:1: rule__Ty__Group_2_1__2 : rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3 ;
    public final void rule__Ty__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3697:1: ( rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3698:2: rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__2__Impl_in_rule__Ty__Group_2_1__27618);
            rule__Ty__Group_2_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2_1__3_in_rule__Ty__Group_2_1__27621);
            rule__Ty__Group_2_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3705:1: rule__Ty__Group_2_1__2__Impl : ( ( rule__Ty__Group_2_1_2__0 )* ) ;
    public final void rule__Ty__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3709:1: ( ( ( rule__Ty__Group_2_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3710:1: ( ( rule__Ty__Group_2_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3710:1: ( ( rule__Ty__Group_2_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3711:1: ( rule__Ty__Group_2_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getGroup_2_1_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3712:1: ( rule__Ty__Group_2_1_2__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==25) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3712:2: rule__Ty__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Ty__Group_2_1_2__0_in_rule__Ty__Group_2_1__2__Impl7648);
            	    rule__Ty__Group_2_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getGroup_2_1_2()); 
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
    // $ANTLR end "rule__Ty__Group_2_1__2__Impl"


    // $ANTLR start "rule__Ty__Group_2_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3722:1: rule__Ty__Group_2_1__3 : rule__Ty__Group_2_1__3__Impl ;
    public final void rule__Ty__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3726:1: ( rule__Ty__Group_2_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3727:2: rule__Ty__Group_2_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__3__Impl_in_rule__Ty__Group_2_1__37679);
            rule__Ty__Group_2_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3733:1: rule__Ty__Group_2_1__3__Impl : ( ']' ) ;
    public final void rule__Ty__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3737:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3738:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3738:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3739:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getRightSquareBracketKeyword_2_1_3()); 
            }
            match(input,24,FOLLOW_24_in_rule__Ty__Group_2_1__3__Impl7707); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getRightSquareBracketKeyword_2_1_3()); 
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
    // $ANTLR end "rule__Ty__Group_2_1__3__Impl"


    // $ANTLR start "rule__Ty__Group_2_1_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3760:1: rule__Ty__Group_2_1_2__0 : rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1 ;
    public final void rule__Ty__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3764:1: ( rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3765:2: rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__0__Impl_in_rule__Ty__Group_2_1_2__07746);
            rule__Ty__Group_2_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__1_in_rule__Ty__Group_2_1_2__07749);
            rule__Ty__Group_2_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3772:1: rule__Ty__Group_2_1_2__0__Impl : ( ',' ) ;
    public final void rule__Ty__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3776:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3777:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3777:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3778:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__Ty__Group_2_1_2__0__Impl7777); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0()); 
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
    // $ANTLR end "rule__Ty__Group_2_1_2__0__Impl"


    // $ANTLR start "rule__Ty__Group_2_1_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3791:1: rule__Ty__Group_2_1_2__1 : rule__Ty__Group_2_1_2__1__Impl ;
    public final void rule__Ty__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3795:1: ( rule__Ty__Group_2_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3796:2: rule__Ty__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__1__Impl_in_rule__Ty__Group_2_1_2__17808);
            rule__Ty__Group_2_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3802:1: rule__Ty__Group_2_1_2__1__Impl : ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) ) ;
    public final void rule__Ty__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3806:1: ( ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3807:1: ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3807:1: ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3808:1: ( rule__Ty__TyBindAssignment_2_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getTyBindAssignment_2_1_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3809:1: ( rule__Ty__TyBindAssignment_2_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3809:2: rule__Ty__TyBindAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Ty__TyBindAssignment_2_1_2_1_in_rule__Ty__Group_2_1_2__1__Impl7835);
            rule__Ty__TyBindAssignment_2_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getTyBindAssignment_2_1_2_1()); 
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
    // $ANTLR end "rule__Ty__Group_2_1_2__1__Impl"


    // $ANTLR start "rule__Ty__Group_3__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3823:1: rule__Ty__Group_3__0 : rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1 ;
    public final void rule__Ty__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3827:1: ( rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3828:2: rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__0__Impl_in_rule__Ty__Group_3__07869);
            rule__Ty__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_3__1_in_rule__Ty__Group_3__07872);
            rule__Ty__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3835:1: rule__Ty__Group_3__0__Impl : ( '{' ) ;
    public final void rule__Ty__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3839:1: ( ( '{' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3840:1: ( '{' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3840:1: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3841:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Ty__Group_3__0__Impl7900); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0()); 
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
    // $ANTLR end "rule__Ty__Group_3__0__Impl"


    // $ANTLR start "rule__Ty__Group_3__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3854:1: rule__Ty__Group_3__1 : rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2 ;
    public final void rule__Ty__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3858:1: ( rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3859:2: rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__1__Impl_in_rule__Ty__Group_3__17931);
            rule__Ty__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_3__2_in_rule__Ty__Group_3__17934);
            rule__Ty__Group_3__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3866:1: rule__Ty__Group_3__1__Impl : ( ( rule__Ty__ElementsAssignment_3_1 ) ) ;
    public final void rule__Ty__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3870:1: ( ( ( rule__Ty__ElementsAssignment_3_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3871:1: ( ( rule__Ty__ElementsAssignment_3_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3871:1: ( ( rule__Ty__ElementsAssignment_3_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3872:1: ( rule__Ty__ElementsAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getElementsAssignment_3_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3873:1: ( rule__Ty__ElementsAssignment_3_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3873:2: rule__Ty__ElementsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Ty__ElementsAssignment_3_1_in_rule__Ty__Group_3__1__Impl7961);
            rule__Ty__ElementsAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getElementsAssignment_3_1()); 
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
    // $ANTLR end "rule__Ty__Group_3__1__Impl"


    // $ANTLR start "rule__Ty__Group_3__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3883:1: rule__Ty__Group_3__2 : rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3 ;
    public final void rule__Ty__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3887:1: ( rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3888:2: rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__2__Impl_in_rule__Ty__Group_3__27991);
            rule__Ty__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_3__3_in_rule__Ty__Group_3__27994);
            rule__Ty__Group_3__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3895:1: rule__Ty__Group_3__2__Impl : ( ( rule__Ty__Group_3_2__0 )* ) ;
    public final void rule__Ty__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3899:1: ( ( ( rule__Ty__Group_3_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3900:1: ( ( rule__Ty__Group_3_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3900:1: ( ( rule__Ty__Group_3_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3901:1: ( rule__Ty__Group_3_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getGroup_3_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3902:1: ( rule__Ty__Group_3_2__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==25) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3902:2: rule__Ty__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Ty__Group_3_2__0_in_rule__Ty__Group_3__2__Impl8021);
            	    rule__Ty__Group_3_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getGroup_3_2()); 
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
    // $ANTLR end "rule__Ty__Group_3__2__Impl"


    // $ANTLR start "rule__Ty__Group_3__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3912:1: rule__Ty__Group_3__3 : rule__Ty__Group_3__3__Impl ;
    public final void rule__Ty__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3916:1: ( rule__Ty__Group_3__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3917:2: rule__Ty__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__3__Impl_in_rule__Ty__Group_3__38052);
            rule__Ty__Group_3__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3923:1: rule__Ty__Group_3__3__Impl : ( '}' ) ;
    public final void rule__Ty__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3927:1: ( ( '}' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3928:1: ( '}' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3928:1: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3929:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getRightCurlyBracketKeyword_3_3()); 
            }
            match(input,28,FOLLOW_28_in_rule__Ty__Group_3__3__Impl8080); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getRightCurlyBracketKeyword_3_3()); 
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
    // $ANTLR end "rule__Ty__Group_3__3__Impl"


    // $ANTLR start "rule__Ty__Group_3_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3950:1: rule__Ty__Group_3_2__0 : rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1 ;
    public final void rule__Ty__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3954:1: ( rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3955:2: rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_3_2__0__Impl_in_rule__Ty__Group_3_2__08119);
            rule__Ty__Group_3_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_3_2__1_in_rule__Ty__Group_3_2__08122);
            rule__Ty__Group_3_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3962:1: rule__Ty__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Ty__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3966:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3967:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3967:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3968:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__Ty__Group_3_2__0__Impl8150); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getCommaKeyword_3_2_0()); 
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
    // $ANTLR end "rule__Ty__Group_3_2__0__Impl"


    // $ANTLR start "rule__Ty__Group_3_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3981:1: rule__Ty__Group_3_2__1 : rule__Ty__Group_3_2__1__Impl ;
    public final void rule__Ty__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3985:1: ( rule__Ty__Group_3_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3986:2: rule__Ty__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_3_2__1__Impl_in_rule__Ty__Group_3_2__18181);
            rule__Ty__Group_3_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3992:1: rule__Ty__Group_3_2__1__Impl : ( ( rule__Ty__ElementsAssignment_3_2_1 ) ) ;
    public final void rule__Ty__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3996:1: ( ( ( rule__Ty__ElementsAssignment_3_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3997:1: ( ( rule__Ty__ElementsAssignment_3_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3997:1: ( ( rule__Ty__ElementsAssignment_3_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3998:1: ( rule__Ty__ElementsAssignment_3_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getElementsAssignment_3_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3999:1: ( rule__Ty__ElementsAssignment_3_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3999:2: rule__Ty__ElementsAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__Ty__ElementsAssignment_3_2_1_in_rule__Ty__Group_3_2__1__Impl8208);
            rule__Ty__ElementsAssignment_3_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getElementsAssignment_3_2_1()); 
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
    // $ANTLR end "rule__Ty__Group_3_2__1__Impl"


    // $ANTLR start "rule__TyElement__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4013:1: rule__TyElement__Group__0 : rule__TyElement__Group__0__Impl rule__TyElement__Group__1 ;
    public final void rule__TyElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4017:1: ( rule__TyElement__Group__0__Impl rule__TyElement__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4018:2: rule__TyElement__Group__0__Impl rule__TyElement__Group__1
            {
            pushFollow(FOLLOW_rule__TyElement__Group__0__Impl_in_rule__TyElement__Group__08242);
            rule__TyElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TyElement__Group__1_in_rule__TyElement__Group__08245);
            rule__TyElement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4025:1: rule__TyElement__Group__0__Impl : ( ( rule__TyElement__NameAssignment_0 ) ) ;
    public final void rule__TyElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4029:1: ( ( ( rule__TyElement__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4030:1: ( ( rule__TyElement__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4030:1: ( ( rule__TyElement__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4031:1: ( rule__TyElement__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4032:1: ( rule__TyElement__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4032:2: rule__TyElement__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__TyElement__NameAssignment_0_in_rule__TyElement__Group__0__Impl8272);
            rule__TyElement__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyElementAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__TyElement__Group__0__Impl"


    // $ANTLR start "rule__TyElement__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4042:1: rule__TyElement__Group__1 : rule__TyElement__Group__1__Impl rule__TyElement__Group__2 ;
    public final void rule__TyElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4046:1: ( rule__TyElement__Group__1__Impl rule__TyElement__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4047:2: rule__TyElement__Group__1__Impl rule__TyElement__Group__2
            {
            pushFollow(FOLLOW_rule__TyElement__Group__1__Impl_in_rule__TyElement__Group__18302);
            rule__TyElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TyElement__Group__2_in_rule__TyElement__Group__18305);
            rule__TyElement__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4054:1: rule__TyElement__Group__1__Impl : ( ':' ) ;
    public final void rule__TyElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4058:1: ( ( ':' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4059:1: ( ':' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4059:1: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4060:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getColonKeyword_1()); 
            }
            match(input,30,FOLLOW_30_in_rule__TyElement__Group__1__Impl8333); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyElementAccess().getColonKeyword_1()); 
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
    // $ANTLR end "rule__TyElement__Group__1__Impl"


    // $ANTLR start "rule__TyElement__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4073:1: rule__TyElement__Group__2 : rule__TyElement__Group__2__Impl ;
    public final void rule__TyElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4077:1: ( rule__TyElement__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4078:2: rule__TyElement__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TyElement__Group__2__Impl_in_rule__TyElement__Group__28364);
            rule__TyElement__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4084:1: rule__TyElement__Group__2__Impl : ( ( rule__TyElement__ValueAssignment_2 ) ) ;
    public final void rule__TyElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4088:1: ( ( ( rule__TyElement__ValueAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4089:1: ( ( rule__TyElement__ValueAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4089:1: ( ( rule__TyElement__ValueAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4090:1: ( rule__TyElement__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getValueAssignment_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4091:1: ( rule__TyElement__ValueAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4091:2: rule__TyElement__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__TyElement__ValueAssignment_2_in_rule__TyElement__Group__2__Impl8391);
            rule__TyElement__ValueAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyElementAccess().getValueAssignment_2()); 
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
    // $ANTLR end "rule__TyElement__Group__2__Impl"


    // $ANTLR start "rule__TyBind__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4107:1: rule__TyBind__Group__0 : rule__TyBind__Group__0__Impl rule__TyBind__Group__1 ;
    public final void rule__TyBind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4111:1: ( rule__TyBind__Group__0__Impl rule__TyBind__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4112:2: rule__TyBind__Group__0__Impl rule__TyBind__Group__1
            {
            pushFollow(FOLLOW_rule__TyBind__Group__0__Impl_in_rule__TyBind__Group__08427);
            rule__TyBind__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TyBind__Group__1_in_rule__TyBind__Group__08430);
            rule__TyBind__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4119:1: rule__TyBind__Group__0__Impl : ( ( rule__TyBind__KeyAssignment_0 ) ) ;
    public final void rule__TyBind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4123:1: ( ( ( rule__TyBind__KeyAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4124:1: ( ( rule__TyBind__KeyAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4124:1: ( ( rule__TyBind__KeyAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4125:1: ( rule__TyBind__KeyAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getKeyAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4126:1: ( rule__TyBind__KeyAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4126:2: rule__TyBind__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__TyBind__KeyAssignment_0_in_rule__TyBind__Group__0__Impl8457);
            rule__TyBind__KeyAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyBindAccess().getKeyAssignment_0()); 
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
    // $ANTLR end "rule__TyBind__Group__0__Impl"


    // $ANTLR start "rule__TyBind__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4136:1: rule__TyBind__Group__1 : rule__TyBind__Group__1__Impl ;
    public final void rule__TyBind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4140:1: ( rule__TyBind__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4141:2: rule__TyBind__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TyBind__Group__1__Impl_in_rule__TyBind__Group__18487);
            rule__TyBind__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4147:1: rule__TyBind__Group__1__Impl : ( ( rule__TyBind__Group_1__0 )? ) ;
    public final void rule__TyBind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4151:1: ( ( ( rule__TyBind__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4152:1: ( ( rule__TyBind__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4152:1: ( ( rule__TyBind__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4153:1: ( rule__TyBind__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4154:1: ( rule__TyBind__Group_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==21) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4154:2: rule__TyBind__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TyBind__Group_1__0_in_rule__TyBind__Group__1__Impl8514);
                    rule__TyBind__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyBindAccess().getGroup_1()); 
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
    // $ANTLR end "rule__TyBind__Group__1__Impl"


    // $ANTLR start "rule__TyBind__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4168:1: rule__TyBind__Group_1__0 : rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1 ;
    public final void rule__TyBind__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4172:1: ( rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4173:2: rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1
            {
            pushFollow(FOLLOW_rule__TyBind__Group_1__0__Impl_in_rule__TyBind__Group_1__08549);
            rule__TyBind__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TyBind__Group_1__1_in_rule__TyBind__Group_1__08552);
            rule__TyBind__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4180:1: rule__TyBind__Group_1__0__Impl : ( '=' ) ;
    public final void rule__TyBind__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4184:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4185:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4185:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4186:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__TyBind__Group_1__0__Impl8580); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0()); 
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
    // $ANTLR end "rule__TyBind__Group_1__0__Impl"


    // $ANTLR start "rule__TyBind__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4199:1: rule__TyBind__Group_1__1 : rule__TyBind__Group_1__1__Impl ;
    public final void rule__TyBind__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4203:1: ( rule__TyBind__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4204:2: rule__TyBind__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TyBind__Group_1__1__Impl_in_rule__TyBind__Group_1__18611);
            rule__TyBind__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4210:1: rule__TyBind__Group_1__1__Impl : ( ( rule__TyBind__ValueAssignment_1_1 ) ) ;
    public final void rule__TyBind__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4214:1: ( ( ( rule__TyBind__ValueAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4215:1: ( ( rule__TyBind__ValueAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4215:1: ( ( rule__TyBind__ValueAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4216:1: ( rule__TyBind__ValueAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getValueAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4217:1: ( rule__TyBind__ValueAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4217:2: rule__TyBind__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__TyBind__ValueAssignment_1_1_in_rule__TyBind__Group_1__1__Impl8638);
            rule__TyBind__ValueAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyBindAccess().getValueAssignment_1_1()); 
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
    // $ANTLR end "rule__TyBind__Group_1__1__Impl"


    // $ANTLR start "rule__BitPat__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4231:1: rule__BitPat__Group__0 : rule__BitPat__Group__0__Impl rule__BitPat__Group__1 ;
    public final void rule__BitPat__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4235:1: ( rule__BitPat__Group__0__Impl rule__BitPat__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4236:2: rule__BitPat__Group__0__Impl rule__BitPat__Group__1
            {
            pushFollow(FOLLOW_rule__BitPat__Group__0__Impl_in_rule__BitPat__Group__08672);
            rule__BitPat__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPat__Group__1_in_rule__BitPat__Group__08675);
            rule__BitPat__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4243:1: rule__BitPat__Group__0__Impl : ( '\\'' ) ;
    public final void rule__BitPat__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4247:1: ( ( '\\'' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4248:1: ( '\\'' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4248:1: ( '\\'' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4249:1: '\\''
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getApostropheKeyword_0()); 
            }
            match(input,31,FOLLOW_31_in_rule__BitPat__Group__0__Impl8703); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatAccess().getApostropheKeyword_0()); 
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
    // $ANTLR end "rule__BitPat__Group__0__Impl"


    // $ANTLR start "rule__BitPat__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4262:1: rule__BitPat__Group__1 : rule__BitPat__Group__1__Impl rule__BitPat__Group__2 ;
    public final void rule__BitPat__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4266:1: ( rule__BitPat__Group__1__Impl rule__BitPat__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4267:2: rule__BitPat__Group__1__Impl rule__BitPat__Group__2
            {
            pushFollow(FOLLOW_rule__BitPat__Group__1__Impl_in_rule__BitPat__Group__18734);
            rule__BitPat__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPat__Group__2_in_rule__BitPat__Group__18737);
            rule__BitPat__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4274:1: rule__BitPat__Group__1__Impl : ( ( rule__BitPat__BitpatAssignment_1 ) ) ;
    public final void rule__BitPat__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4278:1: ( ( ( rule__BitPat__BitpatAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4279:1: ( ( rule__BitPat__BitpatAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4279:1: ( ( rule__BitPat__BitpatAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4280:1: ( rule__BitPat__BitpatAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getBitpatAssignment_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4281:1: ( rule__BitPat__BitpatAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4281:2: rule__BitPat__BitpatAssignment_1
            {
            pushFollow(FOLLOW_rule__BitPat__BitpatAssignment_1_in_rule__BitPat__Group__1__Impl8764);
            rule__BitPat__BitpatAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatAccess().getBitpatAssignment_1()); 
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
    // $ANTLR end "rule__BitPat__Group__1__Impl"


    // $ANTLR start "rule__BitPat__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4291:1: rule__BitPat__Group__2 : rule__BitPat__Group__2__Impl rule__BitPat__Group__3 ;
    public final void rule__BitPat__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4295:1: ( rule__BitPat__Group__2__Impl rule__BitPat__Group__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4296:2: rule__BitPat__Group__2__Impl rule__BitPat__Group__3
            {
            pushFollow(FOLLOW_rule__BitPat__Group__2__Impl_in_rule__BitPat__Group__28794);
            rule__BitPat__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPat__Group__3_in_rule__BitPat__Group__28797);
            rule__BitPat__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4303:1: rule__BitPat__Group__2__Impl : ( ( rule__BitPat__BitpatAssignment_2 )* ) ;
    public final void rule__BitPat__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4307:1: ( ( ( rule__BitPat__BitpatAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4308:1: ( ( rule__BitPat__BitpatAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4308:1: ( ( rule__BitPat__BitpatAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4309:1: ( rule__BitPat__BitpatAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getBitpatAssignment_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4310:1: ( rule__BitPat__BitpatAssignment_2 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=RULE_LHEXCHAR && LA40_0<=RULE_SLASH)||(LA40_0>=RULE_BINDIG && LA40_0<=RULE_PIPE)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4310:2: rule__BitPat__BitpatAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__BitPat__BitpatAssignment_2_in_rule__BitPat__Group__2__Impl8824);
            	    rule__BitPat__BitpatAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatAccess().getBitpatAssignment_2()); 
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
    // $ANTLR end "rule__BitPat__Group__2__Impl"


    // $ANTLR start "rule__BitPat__Group__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4320:1: rule__BitPat__Group__3 : rule__BitPat__Group__3__Impl ;
    public final void rule__BitPat__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4324:1: ( rule__BitPat__Group__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4325:2: rule__BitPat__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__BitPat__Group__3__Impl_in_rule__BitPat__Group__38855);
            rule__BitPat__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4331:1: rule__BitPat__Group__3__Impl : ( '\\'' ) ;
    public final void rule__BitPat__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4335:1: ( ( '\\'' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4336:1: ( '\\'' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4336:1: ( '\\'' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4337:1: '\\''
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getApostropheKeyword_3()); 
            }
            match(input,31,FOLLOW_31_in_rule__BitPat__Group__3__Impl8883); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatAccess().getApostropheKeyword_3()); 
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
    // $ANTLR end "rule__BitPat__Group__3__Impl"


    // $ANTLR start "rule__PrimBitPat__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4358:1: rule__PrimBitPat__Group_1__0 : rule__PrimBitPat__Group_1__0__Impl rule__PrimBitPat__Group_1__1 ;
    public final void rule__PrimBitPat__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4362:1: ( rule__PrimBitPat__Group_1__0__Impl rule__PrimBitPat__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4363:2: rule__PrimBitPat__Group_1__0__Impl rule__PrimBitPat__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimBitPat__Group_1__0__Impl_in_rule__PrimBitPat__Group_1__08922);
            rule__PrimBitPat__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PrimBitPat__Group_1__1_in_rule__PrimBitPat__Group_1__08925);
            rule__PrimBitPat__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4370:1: rule__PrimBitPat__Group_1__0__Impl : ( ruleQid ) ;
    public final void rule__PrimBitPat__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4374:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4375:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4375:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4376:1: ruleQid
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimBitPatAccess().getQidParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleQid_in_rule__PrimBitPat__Group_1__0__Impl8952);
            ruleQid();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimBitPatAccess().getQidParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__PrimBitPat__Group_1__0__Impl"


    // $ANTLR start "rule__PrimBitPat__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4387:1: rule__PrimBitPat__Group_1__1 : rule__PrimBitPat__Group_1__1__Impl ;
    public final void rule__PrimBitPat__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4391:1: ( rule__PrimBitPat__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4392:2: rule__PrimBitPat__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimBitPat__Group_1__1__Impl_in_rule__PrimBitPat__Group_1__18981);
            rule__PrimBitPat__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4398:1: rule__PrimBitPat__Group_1__1__Impl : ( ( ruleBitPatOrInt )? ) ;
    public final void rule__PrimBitPat__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4402:1: ( ( ( ruleBitPatOrInt )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4403:1: ( ( ruleBitPatOrInt )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4403:1: ( ( ruleBitPatOrInt )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4404:1: ( ruleBitPatOrInt )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimBitPatAccess().getBitPatOrIntParserRuleCall_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4405:1: ( ruleBitPatOrInt )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==30||LA41_0==32) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4405:3: ruleBitPatOrInt
                    {
                    pushFollow(FOLLOW_ruleBitPatOrInt_in_rule__PrimBitPat__Group_1__1__Impl9009);
                    ruleBitPatOrInt();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimBitPatAccess().getBitPatOrIntParserRuleCall_1_1()); 
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
    // $ANTLR end "rule__PrimBitPat__Group_1__1__Impl"


    // $ANTLR start "rule__BitPatOrInt__Group_0__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4419:1: rule__BitPatOrInt__Group_0__0 : rule__BitPatOrInt__Group_0__0__Impl rule__BitPatOrInt__Group_0__1 ;
    public final void rule__BitPatOrInt__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4423:1: ( rule__BitPatOrInt__Group_0__0__Impl rule__BitPatOrInt__Group_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4424:2: rule__BitPatOrInt__Group_0__0__Impl rule__BitPatOrInt__Group_0__1
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__0__Impl_in_rule__BitPatOrInt__Group_0__09044);
            rule__BitPatOrInt__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__1_in_rule__BitPatOrInt__Group_0__09047);
            rule__BitPatOrInt__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4431:1: rule__BitPatOrInt__Group_0__0__Impl : ( ':' ) ;
    public final void rule__BitPatOrInt__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4435:1: ( ( ':' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4436:1: ( ':' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4436:1: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4437:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getColonKeyword_0_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__BitPatOrInt__Group_0__0__Impl9075); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatOrIntAccess().getColonKeyword_0_0()); 
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
    // $ANTLR end "rule__BitPatOrInt__Group_0__0__Impl"


    // $ANTLR start "rule__BitPatOrInt__Group_0__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4450:1: rule__BitPatOrInt__Group_0__1 : rule__BitPatOrInt__Group_0__1__Impl ;
    public final void rule__BitPatOrInt__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4454:1: ( rule__BitPatOrInt__Group_0__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4455:2: rule__BitPatOrInt__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__1__Impl_in_rule__BitPatOrInt__Group_0__19106);
            rule__BitPatOrInt__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4461:1: rule__BitPatOrInt__Group_0__1__Impl : ( rulePOSINT ) ;
    public final void rule__BitPatOrInt__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4465:1: ( ( rulePOSINT ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4466:1: ( rulePOSINT )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4466:1: ( rulePOSINT )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4467:1: rulePOSINT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getPOSINTParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_rule__BitPatOrInt__Group_0__1__Impl9133);
            rulePOSINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatOrIntAccess().getPOSINTParserRuleCall_0_1()); 
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
    // $ANTLR end "rule__BitPatOrInt__Group_0__1__Impl"


    // $ANTLR start "rule__BitPatOrInt__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4482:1: rule__BitPatOrInt__Group_1__0 : rule__BitPatOrInt__Group_1__0__Impl rule__BitPatOrInt__Group_1__1 ;
    public final void rule__BitPatOrInt__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4486:1: ( rule__BitPatOrInt__Group_1__0__Impl rule__BitPatOrInt__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4487:2: rule__BitPatOrInt__Group_1__0__Impl rule__BitPatOrInt__Group_1__1
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__0__Impl_in_rule__BitPatOrInt__Group_1__09166);
            rule__BitPatOrInt__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__1_in_rule__BitPatOrInt__Group_1__09169);
            rule__BitPatOrInt__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4494:1: rule__BitPatOrInt__Group_1__0__Impl : ( '@' ) ;
    public final void rule__BitPatOrInt__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4498:1: ( ( '@' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4499:1: ( '@' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4499:1: ( '@' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4500:1: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getCommercialAtKeyword_1_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__BitPatOrInt__Group_1__0__Impl9197); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatOrIntAccess().getCommercialAtKeyword_1_0()); 
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
    // $ANTLR end "rule__BitPatOrInt__Group_1__0__Impl"


    // $ANTLR start "rule__BitPatOrInt__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4513:1: rule__BitPatOrInt__Group_1__1 : rule__BitPatOrInt__Group_1__1__Impl ;
    public final void rule__BitPatOrInt__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4517:1: ( rule__BitPatOrInt__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4518:2: rule__BitPatOrInt__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__1__Impl_in_rule__BitPatOrInt__Group_1__19228);
            rule__BitPatOrInt__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4524:1: rule__BitPatOrInt__Group_1__1__Impl : ( ruleBITSTR ) ;
    public final void rule__BitPatOrInt__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4528:1: ( ( ruleBITSTR ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4529:1: ( ruleBITSTR )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4529:1: ( ruleBITSTR )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4530:1: ruleBITSTR
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getBITSTRParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleBITSTR_in_rule__BitPatOrInt__Group_1__1__Impl9255);
            ruleBITSTR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatOrIntAccess().getBITSTRParserRuleCall_1_1()); 
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
    // $ANTLR end "rule__BitPatOrInt__Group_1__1__Impl"


    // $ANTLR start "rule__NEGINT__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4545:1: rule__NEGINT__Group__0 : rule__NEGINT__Group__0__Impl rule__NEGINT__Group__1 ;
    public final void rule__NEGINT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4549:1: ( rule__NEGINT__Group__0__Impl rule__NEGINT__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4550:2: rule__NEGINT__Group__0__Impl rule__NEGINT__Group__1
            {
            pushFollow(FOLLOW_rule__NEGINT__Group__0__Impl_in_rule__NEGINT__Group__09288);
            rule__NEGINT__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NEGINT__Group__1_in_rule__NEGINT__Group__09291);
            rule__NEGINT__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4557:1: rule__NEGINT__Group__0__Impl : ( '~' ) ;
    public final void rule__NEGINT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4561:1: ( ( '~' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4562:1: ( '~' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4562:1: ( '~' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4563:1: '~'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNEGINTAccess().getTildeKeyword_0()); 
            }
            match(input,33,FOLLOW_33_in_rule__NEGINT__Group__0__Impl9319); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNEGINTAccess().getTildeKeyword_0()); 
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
    // $ANTLR end "rule__NEGINT__Group__0__Impl"


    // $ANTLR start "rule__NEGINT__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4576:1: rule__NEGINT__Group__1 : rule__NEGINT__Group__1__Impl ;
    public final void rule__NEGINT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4580:1: ( rule__NEGINT__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4581:2: rule__NEGINT__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NEGINT__Group__1__Impl_in_rule__NEGINT__Group__19350);
            rule__NEGINT__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4587:1: rule__NEGINT__Group__1__Impl : ( ruleNUM ) ;
    public final void rule__NEGINT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4591:1: ( ( ruleNUM ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4592:1: ( ruleNUM )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4592:1: ( ruleNUM )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4593:1: ruleNUM
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNEGINTAccess().getNUMParserRuleCall_1()); 
            }
            pushFollow(FOLLOW_ruleNUM_in_rule__NEGINT__Group__1__Impl9377);
            ruleNUM();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNEGINTAccess().getNUMParserRuleCall_1()); 
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
    // $ANTLR end "rule__NEGINT__Group__1__Impl"


    // $ANTLR start "rule__HEXNUM__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4608:1: rule__HEXNUM__Group__0 : rule__HEXNUM__Group__0__Impl rule__HEXNUM__Group__1 ;
    public final void rule__HEXNUM__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4612:1: ( rule__HEXNUM__Group__0__Impl rule__HEXNUM__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4613:2: rule__HEXNUM__Group__0__Impl rule__HEXNUM__Group__1
            {
            pushFollow(FOLLOW_rule__HEXNUM__Group__0__Impl_in_rule__HEXNUM__Group__09410);
            rule__HEXNUM__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__HEXNUM__Group__1_in_rule__HEXNUM__Group__09413);
            rule__HEXNUM__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4620:1: rule__HEXNUM__Group__0__Impl : ( '0x' ) ;
    public final void rule__HEXNUM__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4624:1: ( ( '0x' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4625:1: ( '0x' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4625:1: ( '0x' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4626:1: '0x'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMAccess().getXKeyword_0()); 
            }
            match(input,34,FOLLOW_34_in_rule__HEXNUM__Group__0__Impl9441); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXNUMAccess().getXKeyword_0()); 
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
    // $ANTLR end "rule__HEXNUM__Group__0__Impl"


    // $ANTLR start "rule__HEXNUM__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4639:1: rule__HEXNUM__Group__1 : rule__HEXNUM__Group__1__Impl ;
    public final void rule__HEXNUM__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4643:1: ( rule__HEXNUM__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4644:2: rule__HEXNUM__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__HEXNUM__Group__1__Impl_in_rule__HEXNUM__Group__19472);
            rule__HEXNUM__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4650:1: rule__HEXNUM__Group__1__Impl : ( ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* ) ) ;
    public final void rule__HEXNUM__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4654:1: ( ( ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4655:1: ( ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4655:1: ( ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4656:1: ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4656:1: ( ( ruleHEXDIGIT ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4657:1: ( ruleHEXDIGIT )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4658:1: ( ruleHEXDIGIT )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4658:3: ruleHEXDIGIT
            {
            pushFollow(FOLLOW_ruleHEXDIGIT_in_rule__HEXNUM__Group__1__Impl9502);
            ruleHEXDIGIT();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            }

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4661:1: ( ( ruleHEXDIGIT )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4662:1: ( ruleHEXDIGIT )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4663:1: ( ruleHEXDIGIT )*
            loop42:
            do {
                int alt42=2;
                switch ( input.LA(1) ) {
                case RULE_BINDIG:
                    {
                    int LA42_2 = input.LA(2);

                    if ( (synpred54_InternalGDSL()) ) {
                        alt42=1;
                    }


                    }
                    break;
                case RULE_NBINDIG:
                    {
                    int LA42_3 = input.LA(2);

                    if ( (synpred54_InternalGDSL()) ) {
                        alt42=1;
                    }


                    }
                    break;
                case RULE_LHEXCHAR:
                    {
                    int LA42_4 = input.LA(2);

                    if ( (synpred54_InternalGDSL()) ) {
                        alt42=1;
                    }


                    }
                    break;
                case RULE_UHEXCHAR:
                    {
                    int LA42_5 = input.LA(2);

                    if ( (synpred54_InternalGDSL()) ) {
                        alt42=1;
                    }


                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4663:3: ruleHEXDIGIT
            	    {
            	    pushFollow(FOLLOW_ruleHEXDIGIT_in_rule__HEXNUM__Group__1__Impl9515);
            	    ruleHEXDIGIT();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            }

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4679:1: rule__CONS__Group__0 : rule__CONS__Group__0__Impl rule__CONS__Group__1 ;
    public final void rule__CONS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4683:1: ( rule__CONS__Group__0__Impl rule__CONS__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4684:2: rule__CONS__Group__0__Impl rule__CONS__Group__1
            {
            pushFollow(FOLLOW_rule__CONS__Group__0__Impl_in_rule__CONS__Group__09553);
            rule__CONS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CONS__Group__1_in_rule__CONS__Group__09556);
            rule__CONS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4691:1: rule__CONS__Group__0__Impl : ( ruleULETTER ) ;
    public final void rule__CONS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4695:1: ( ( ruleULETTER ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4696:1: ( ruleULETTER )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4696:1: ( ruleULETTER )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4697:1: ruleULETTER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCONSAccess().getULETTERParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleULETTER_in_rule__CONS__Group__0__Impl9583);
            ruleULETTER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCONSAccess().getULETTERParserRuleCall_0()); 
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
    // $ANTLR end "rule__CONS__Group__0__Impl"


    // $ANTLR start "rule__CONS__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4708:1: rule__CONS__Group__1 : rule__CONS__Group__1__Impl ;
    public final void rule__CONS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4712:1: ( rule__CONS__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4713:2: rule__CONS__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__CONS__Group__1__Impl_in_rule__CONS__Group__19612);
            rule__CONS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4719:1: rule__CONS__Group__1__Impl : ( ( ruleIDCHAR )* ) ;
    public final void rule__CONS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4723:1: ( ( ( ruleIDCHAR )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4724:1: ( ( ruleIDCHAR )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4724:1: ( ( ruleIDCHAR )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4725:1: ( ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCONSAccess().getIDCHARParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4726:1: ( ruleIDCHAR )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=RULE_LHEXCHAR && LA43_0<=RULE_BINDIG)||LA43_0==RULE_NBINDIG) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4726:3: ruleIDCHAR
            	    {
            	    pushFollow(FOLLOW_ruleIDCHAR_in_rule__CONS__Group__1__Impl9640);
            	    ruleIDCHAR();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCONSAccess().getIDCHARParserRuleCall_1()); 
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
    // $ANTLR end "rule__CONS__Group__1__Impl"


    // $ANTLR start "rule__ID__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4740:1: rule__ID__Group__0 : rule__ID__Group__0__Impl rule__ID__Group__1 ;
    public final void rule__ID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4744:1: ( rule__ID__Group__0__Impl rule__ID__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4745:2: rule__ID__Group__0__Impl rule__ID__Group__1
            {
            pushFollow(FOLLOW_rule__ID__Group__0__Impl_in_rule__ID__Group__09675);
            rule__ID__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ID__Group__1_in_rule__ID__Group__09678);
            rule__ID__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ID__Group__0"


    // $ANTLR start "rule__ID__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4752:1: rule__ID__Group__0__Impl : ( ruleLETTER ) ;
    public final void rule__ID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4756:1: ( ( ruleLETTER ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4757:1: ( ruleLETTER )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4757:1: ( ruleLETTER )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4758:1: ruleLETTER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getLETTERParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLETTER_in_rule__ID__Group__0__Impl9705);
            ruleLETTER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDAccess().getLETTERParserRuleCall_0()); 
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
    // $ANTLR end "rule__ID__Group__0__Impl"


    // $ANTLR start "rule__ID__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4769:1: rule__ID__Group__1 : rule__ID__Group__1__Impl ;
    public final void rule__ID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4773:1: ( rule__ID__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4774:2: rule__ID__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ID__Group__1__Impl_in_rule__ID__Group__19734);
            rule__ID__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ID__Group__1"


    // $ANTLR start "rule__ID__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4780:1: rule__ID__Group__1__Impl : ( ( ruleIDCHAR )* ) ;
    public final void rule__ID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4784:1: ( ( ( ruleIDCHAR )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4785:1: ( ( ruleIDCHAR )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4785:1: ( ( ruleIDCHAR )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4786:1: ( ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getIDCHARParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4787:1: ( ruleIDCHAR )*
            loop44:
            do {
                int alt44=2;
                alt44 = dfa44.predict(input);
                switch (alt44) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4787:3: ruleIDCHAR
            	    {
            	    pushFollow(FOLLOW_ruleIDCHAR_in_rule__ID__Group__1__Impl9762);
            	    ruleIDCHAR();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDAccess().getIDCHARParserRuleCall_1()); 
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
    // $ANTLR end "rule__ID__Group__1__Impl"


    // $ANTLR start "rule__Model__DeclAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4802:1: rule__Model__DeclAssignment_0 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4806:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4807:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4807:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4808:1: ruleDecl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_09802);
            ruleDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Model__DeclAssignment_0"


    // $ANTLR start "rule__Model__DeclAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4817:1: rule__Model__DeclAssignment_1_1 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4821:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4822:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4822:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4823:1: ruleDecl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_19833);
            ruleDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Model__DeclAssignment_1_1"


    // $ANTLR start "rule__DeclGranularity__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4832:1: rule__DeclGranularity__NameAssignment_0 : ( ( 'granularity' ) ) ;
    public final void rule__DeclGranularity__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4836:1: ( ( ( 'granularity' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4837:1: ( ( 'granularity' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4837:1: ( ( 'granularity' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4838:1: ( 'granularity' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4839:1: ( 'granularity' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4840:1: 'granularity'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__DeclGranularity__NameAssignment_09869); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
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
    // $ANTLR end "rule__DeclGranularity__NameAssignment_0"


    // $ANTLR start "rule__DeclGranularity__GranularityAssignment_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4855:1: rule__DeclGranularity__GranularityAssignment_2 : ( ruleInt ) ;
    public final void rule__DeclGranularity__GranularityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4859:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4860:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4860:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4861:1: ruleInt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getGranularityIntParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleInt_in_rule__DeclGranularity__GranularityAssignment_29908);
            ruleInt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclGranularityAccess().getGranularityIntParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__DeclGranularity__GranularityAssignment_2"


    // $ANTLR start "rule__DeclExport__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4870:1: rule__DeclExport__NameAssignment_0 : ( ( 'export' ) ) ;
    public final void rule__DeclExport__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4874:1: ( ( ( 'export' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4875:1: ( ( 'export' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4875:1: ( ( 'export' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4876:1: ( 'export' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4877:1: ( 'export' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4878:1: 'export'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__DeclExport__NameAssignment_09944); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
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
    // $ANTLR end "rule__DeclExport__NameAssignment_0"


    // $ANTLR start "rule__DeclExport__ExportsAssignment_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4893:1: rule__DeclExport__ExportsAssignment_2 : ( ruleExport ) ;
    public final void rule__DeclExport__ExportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4897:1: ( ( ruleExport ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4898:1: ( ruleExport )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4898:1: ( ruleExport )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4899:1: ruleExport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_29983);
            ruleExport();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__DeclExport__ExportsAssignment_2"


    // $ANTLR start "rule__DeclType__NameAssignment_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4908:1: rule__DeclType__NameAssignment_1 : ( ruleName ) ;
    public final void rule__DeclType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4912:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4913:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4913:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4914:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__NameAssignment_110014);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__DeclType__NameAssignment_1"


    // $ANTLR start "rule__DeclType__ValueAssignment_2_0_0_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4923:1: rule__DeclType__ValueAssignment_2_0_0_1 : ( ruleConDecls ) ;
    public final void rule__DeclType__ValueAssignment_2_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4927:1: ( ( ruleConDecls ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4928:1: ( ruleConDecls )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4928:1: ( ruleConDecls )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4929:1: ruleConDecls
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_2_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_2_0_0_110045);
            ruleConDecls();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_2_0_0_1_0()); 
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
    // $ANTLR end "rule__DeclType__ValueAssignment_2_0_0_1"


    // $ANTLR start "rule__DeclType__ValueAssignment_2_0_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4938:1: rule__DeclType__ValueAssignment_2_0_1 : ( ruleTy ) ;
    public final void rule__DeclType__ValueAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4942:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4943:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4943:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4944:1: ruleTy
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_2_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleTy_in_rule__DeclType__ValueAssignment_2_0_110076);
            ruleTy();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_2_0_1_0()); 
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
    // $ANTLR end "rule__DeclType__ValueAssignment_2_0_1"


    // $ANTLR start "rule__DeclType__AttrNameAssignment_2_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4953:1: rule__DeclType__AttrNameAssignment_2_1_1 : ( ruleName ) ;
    public final void rule__DeclType__AttrNameAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4957:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4958:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4958:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4959:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_2_1_110107);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_2_1_1_0()); 
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
    // $ANTLR end "rule__DeclType__AttrNameAssignment_2_1_1"


    // $ANTLR start "rule__DeclType__AttrNameAssignment_2_1_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4968:1: rule__DeclType__AttrNameAssignment_2_1_2_1 : ( ruleName ) ;
    public final void rule__DeclType__AttrNameAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4972:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4973:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4973:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4974:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_2_1_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_2_1_2_110138);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_2_1_2_1_0()); 
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
    // $ANTLR end "rule__DeclType__AttrNameAssignment_2_1_2_1"


    // $ANTLR start "rule__DeclType__ValueAssignment_2_1_5"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4983:1: rule__DeclType__ValueAssignment_2_1_5 : ( ruleConDecls ) ;
    public final void rule__DeclType__ValueAssignment_2_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4987:1: ( ( ruleConDecls ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4988:1: ( ruleConDecls )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4988:1: ( ruleConDecls )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4989:1: ruleConDecls
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_2_1_5_0()); 
            }
            pushFollow(FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_2_1_510169);
            ruleConDecls();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_2_1_5_0()); 
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
    // $ANTLR end "rule__DeclType__ValueAssignment_2_1_5"


    // $ANTLR start "rule__DeclVal__NameAssignment_0_1_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4998:1: rule__DeclVal__NameAssignment_0_1_0 : ( ruleName ) ;
    public final void rule__DeclVal__NameAssignment_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5002:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5003:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5003:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5004:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_0_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_0_1_010200);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_0_1_0_0()); 
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
    // $ANTLR end "rule__DeclVal__NameAssignment_0_1_0"


    // $ANTLR start "rule__DeclVal__NameAssignment_0_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5013:1: rule__DeclVal__NameAssignment_0_1_1 : ( ruleSYM ) ;
    public final void rule__DeclVal__NameAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5017:1: ( ( ruleSYM ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5018:1: ( ruleSYM )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5018:1: ( ruleSYM )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5019:1: ruleSYM
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getNameSYMParserRuleCall_0_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_rule__DeclVal__NameAssignment_0_1_110231);
            ruleSYM();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getNameSYMParserRuleCall_0_1_1_0()); 
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
    // $ANTLR end "rule__DeclVal__NameAssignment_0_1_1"


    // $ANTLR start "rule__DeclVal__AttrAssignment_0_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5028:1: rule__DeclVal__AttrAssignment_0_2 : ( ruleName ) ;
    public final void rule__DeclVal__AttrAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5032:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5033:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5033:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5034:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getAttrNameParserRuleCall_0_2_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclVal__AttrAssignment_0_210262);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getAttrNameParserRuleCall_0_2_0()); 
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
    // $ANTLR end "rule__DeclVal__AttrAssignment_0_2"


    // $ANTLR start "rule__DeclVal__ExpAssignment_0_4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5043:1: rule__DeclVal__ExpAssignment_0_4 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5047:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5048:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5048:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5049:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_0_4_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_0_410293);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_0_4_0()); 
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
    // $ANTLR end "rule__DeclVal__ExpAssignment_0_4"


    // $ANTLR start "rule__DeclVal__NameAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5058:1: rule__DeclVal__NameAssignment_1_1 : ( ruleName ) ;
    public final void rule__DeclVal__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5062:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5063:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5063:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5064:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_1_110324);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__DeclVal__NameAssignment_1_1"


    // $ANTLR start "rule__DeclVal__DecPatAssignment_1_3_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5073:1: rule__DeclVal__DecPatAssignment_1_3_0 : ( ruleDecodePat ) ;
    public final void rule__DeclVal__DecPatAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5077:1: ( ( ruleDecodePat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5078:1: ( ruleDecodePat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5078:1: ( ruleDecodePat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5079:1: ruleDecodePat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_0_0()); 
            }
            pushFollow(FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_3_010355);
            ruleDecodePat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_0_0()); 
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
    // $ANTLR end "rule__DeclVal__DecPatAssignment_1_3_0"


    // $ANTLR start "rule__DeclVal__DecPatAssignment_1_3_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5088:1: rule__DeclVal__DecPatAssignment_1_3_1 : ( ruleDecodePat ) ;
    public final void rule__DeclVal__DecPatAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5092:1: ( ( ruleDecodePat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5093:1: ( ruleDecodePat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5093:1: ( ruleDecodePat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5094:1: ruleDecodePat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_3_110386);
            ruleDecodePat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_1_0()); 
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
    // $ANTLR end "rule__DeclVal__DecPatAssignment_1_3_1"


    // $ANTLR start "rule__DeclVal__ExpAssignment_1_5_0_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5103:1: rule__DeclVal__ExpAssignment_1_5_0_1 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpAssignment_1_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5107:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5108:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5108:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5109:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_5_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_1_5_0_110417);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_5_0_1_0()); 
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
    // $ANTLR end "rule__DeclVal__ExpAssignment_1_5_0_1"


    // $ANTLR start "rule__DeclVal__ExpsAssignment_1_5_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5118:1: rule__DeclVal__ExpsAssignment_1_5_1_1 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpsAssignment_1_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5122:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5123:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5123:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5124:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_110448);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_1_0()); 
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
    // $ANTLR end "rule__DeclVal__ExpsAssignment_1_5_1_1"


    // $ANTLR start "rule__DeclVal__ExpsAssignment_1_5_1_3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5133:1: rule__DeclVal__ExpsAssignment_1_5_1_3 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpsAssignment_1_5_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5137:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5138:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5138:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5139:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_3_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_310479);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_3_0()); 
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
    // $ANTLR end "rule__DeclVal__ExpsAssignment_1_5_1_3"


    // $ANTLR start "rule__Export__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5148:1: rule__Export__NameAssignment_0 : ( ruleQid ) ;
    public final void rule__Export__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5152:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5153:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5153:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5154:1: ruleQid
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleQid_in_rule__Export__NameAssignment_010510);
            ruleQid();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Export__NameAssignment_0"


    // $ANTLR start "rule__Export__AttrNameAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5163:1: rule__Export__AttrNameAssignment_1_1 : ( ruleName ) ;
    public final void rule__Export__AttrNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5167:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5168:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5168:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5169:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_110541);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Export__AttrNameAssignment_1_1"


    // $ANTLR start "rule__Export__AttrNameAssignment_1_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5178:1: rule__Export__AttrNameAssignment_1_2_1 : ( ruleName ) ;
    public final void rule__Export__AttrNameAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5182:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5183:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5183:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5184:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_2_110572);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_2_1_0()); 
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
    // $ANTLR end "rule__Export__AttrNameAssignment_1_2_1"


    // $ANTLR start "rule__ConDecls__ConDeclsAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5193:1: rule__ConDecls__ConDeclsAssignment_0 : ( ruleConDecl ) ;
    public final void rule__ConDecls__ConDeclsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5197:1: ( ( ruleConDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5198:1: ( ruleConDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5198:1: ( ruleConDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5199:1: ruleConDecl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_010603);
            ruleConDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__ConDecls__ConDeclsAssignment_0"


    // $ANTLR start "rule__ConDecls__ConDeclsAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5208:1: rule__ConDecls__ConDeclsAssignment_1_1 : ( ruleConDecl ) ;
    public final void rule__ConDecls__ConDeclsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5212:1: ( ( ruleConDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5213:1: ( ruleConDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5213:1: ( ruleConDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5214:1: ruleConDecl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_1_110634);
            ruleConDecl();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__ConDecls__ConDeclsAssignment_1_1"


    // $ANTLR start "rule__ConDecl__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5223:1: rule__ConDecl__NameAssignment_0 : ( ruleConBind ) ;
    public final void rule__ConDecl__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5227:1: ( ( ruleConBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5228:1: ( ruleConBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5228:1: ( ruleConBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5229:1: ruleConBind
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleConBind_in_rule__ConDecl__NameAssignment_010665);
            ruleConBind();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__ConDecl__NameAssignment_0"


    // $ANTLR start "rule__ConDecl__TyAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5238:1: rule__ConDecl__TyAssignment_1_1 : ( ruleTy ) ;
    public final void rule__ConDecl__TyAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5242:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5243:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5243:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5244:1: ruleTy
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleTy_in_rule__ConDecl__TyAssignment_1_110696);
            ruleTy();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__ConDecl__TyAssignment_1_1"


    // $ANTLR start "rule__Ty__ValueAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5253:1: rule__Ty__ValueAssignment_0 : ( ruleInt ) ;
    public final void rule__Ty__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5257:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5258:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5258:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5259:1: ruleInt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_010727);
            ruleInt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Ty__ValueAssignment_0"


    // $ANTLR start "rule__Ty__ValueAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5268:1: rule__Ty__ValueAssignment_1_1 : ( ruleInt ) ;
    public final void rule__Ty__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5272:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5273:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5273:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5274:1: ruleInt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_1_110758);
            ruleInt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Ty__ValueAssignment_1_1"


    // $ANTLR start "rule__Ty__ValueAssignment_2_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5283:1: rule__Ty__ValueAssignment_2_0 : ( ruleQid ) ;
    public final void rule__Ty__ValueAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5287:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5288:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5288:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5289:1: ruleQid
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_ruleQid_in_rule__Ty__ValueAssignment_2_010789);
            ruleQid();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 
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
    // $ANTLR end "rule__Ty__ValueAssignment_2_0"


    // $ANTLR start "rule__Ty__TyBindAssignment_2_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5298:1: rule__Ty__TyBindAssignment_2_1_1 : ( ruleTyBind ) ;
    public final void rule__Ty__TyBindAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5302:1: ( ( ruleTyBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5303:1: ( ruleTyBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5303:1: ( ruleTyBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5304:1: ruleTyBind
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_110820);
            ruleTyBind();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 
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
    // $ANTLR end "rule__Ty__TyBindAssignment_2_1_1"


    // $ANTLR start "rule__Ty__TyBindAssignment_2_1_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5313:1: rule__Ty__TyBindAssignment_2_1_2_1 : ( ruleTyBind ) ;
    public final void rule__Ty__TyBindAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5317:1: ( ( ruleTyBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5318:1: ( ruleTyBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5318:1: ( ruleTyBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5319:1: ruleTyBind
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_2_110851);
            ruleTyBind();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 
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
    // $ANTLR end "rule__Ty__TyBindAssignment_2_1_2_1"


    // $ANTLR start "rule__Ty__ElementsAssignment_3_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5328:1: rule__Ty__ElementsAssignment_3_1 : ( ruleTyElement ) ;
    public final void rule__Ty__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5332:1: ( ( ruleTyElement ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5333:1: ( ruleTyElement )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5333:1: ( ruleTyElement )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5334:1: ruleTyElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_110882);
            ruleTyElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 
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
    // $ANTLR end "rule__Ty__ElementsAssignment_3_1"


    // $ANTLR start "rule__Ty__ElementsAssignment_3_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5343:1: rule__Ty__ElementsAssignment_3_2_1 : ( ruleTyElement ) ;
    public final void rule__Ty__ElementsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5347:1: ( ( ruleTyElement ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5348:1: ( ruleTyElement )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5348:1: ( ruleTyElement )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5349:1: ruleTyElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_2_110913);
            ruleTyElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 
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
    // $ANTLR end "rule__Ty__ElementsAssignment_3_2_1"


    // $ANTLR start "rule__TyElement__NameAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5358:1: rule__TyElement__NameAssignment_0 : ( ruleName ) ;
    public final void rule__TyElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5362:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5363:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5363:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5364:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getNameNameParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__TyElement__NameAssignment_010944);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyElementAccess().getNameNameParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__TyElement__NameAssignment_0"


    // $ANTLR start "rule__TyElement__ValueAssignment_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5373:1: rule__TyElement__ValueAssignment_2 : ( ruleTy ) ;
    public final void rule__TyElement__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5377:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5378:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5378:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5379:1: ruleTy
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleTy_in_rule__TyElement__ValueAssignment_210975);
            ruleTy();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__TyElement__ValueAssignment_2"


    // $ANTLR start "rule__TyBind__KeyAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5388:1: rule__TyBind__KeyAssignment_0 : ( ruleQid ) ;
    public final void rule__TyBind__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5392:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5393:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5393:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5394:1: ruleQid
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleQid_in_rule__TyBind__KeyAssignment_011006);
            ruleQid();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__TyBind__KeyAssignment_0"


    // $ANTLR start "rule__TyBind__ValueAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5403:1: rule__TyBind__ValueAssignment_1_1 : ( ruleTy ) ;
    public final void rule__TyBind__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5407:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5408:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5408:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5409:1: ruleTy
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleTy_in_rule__TyBind__ValueAssignment_1_111037);
            ruleTy();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__TyBind__ValueAssignment_1_1"


    // $ANTLR start "rule__BitPat__BitpatAssignment_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5418:1: rule__BitPat__BitpatAssignment_1 : ( rulePrimBitPat ) ;
    public final void rule__BitPat__BitpatAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5422:1: ( ( rulePrimBitPat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5423:1: ( rulePrimBitPat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5423:1: ( rulePrimBitPat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5424:1: rulePrimBitPat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_111068);
            rulePrimBitPat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__BitPat__BitpatAssignment_1"


    // $ANTLR start "rule__BitPat__BitpatAssignment_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5433:1: rule__BitPat__BitpatAssignment_2 : ( rulePrimBitPat ) ;
    public final void rule__BitPat__BitpatAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5437:1: ( ( rulePrimBitPat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5438:1: ( rulePrimBitPat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5438:1: ( rulePrimBitPat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5439:1: rulePrimBitPat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_211099);
            rulePrimBitPat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__BitPat__BitpatAssignment_2"


    // $ANTLR start "rule__TokPat__TokPatAssignment"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5448:1: rule__TokPat__TokPatAssignment : ( ( rule__TokPat__TokPatAlternatives_0 ) ) ;
    public final void rule__TokPat__TokPatAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5452:1: ( ( ( rule__TokPat__TokPatAlternatives_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5453:1: ( ( rule__TokPat__TokPatAlternatives_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5453:1: ( ( rule__TokPat__TokPatAlternatives_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5454:1: ( rule__TokPat__TokPatAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokPatAccess().getTokPatAlternatives_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5455:1: ( rule__TokPat__TokPatAlternatives_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5455:2: rule__TokPat__TokPatAlternatives_0
            {
            pushFollow(FOLLOW_rule__TokPat__TokPatAlternatives_0_in_rule__TokPat__TokPatAssignment11130);
            rule__TokPat__TokPatAlternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTokPatAccess().getTokPatAlternatives_0()); 
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
    // $ANTLR end "rule__TokPat__TokPatAssignment"

    // $ANTLR start synpred1_InternalGDSL
    public final void synpred1_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:759:3: ( ruleDIG )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:759:3: ruleDIG
        {
        pushFollow(FOLLOW_ruleDIG_in_synpred1_InternalGDSL1557);
        ruleDIG();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalGDSL

    // $ANTLR start synpred2_InternalGDSL
    public final void synpred2_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:824:3: ( ruleBINARY )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:824:3: ruleBINARY
        {
        pushFollow(FOLLOW_ruleBINARY_in_synpred2_InternalGDSL1698);
        ruleBINARY();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalGDSL

    // $ANTLR start synpred9_InternalGDSL
    public final void synpred9_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1224:1: ( ( ( rule__DeclVal__NameAssignment_0_1_0 ) ) )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1224:1: ( ( rule__DeclVal__NameAssignment_0_1_0 ) )
        {
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1224:1: ( ( rule__DeclVal__NameAssignment_0_1_0 ) )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1225:1: ( rule__DeclVal__NameAssignment_0_1_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDeclValAccess().getNameAssignment_0_1_0()); 
        }
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1226:1: ( rule__DeclVal__NameAssignment_0_1_0 )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1226:2: rule__DeclVal__NameAssignment_0_1_0
        {
        pushFollow(FOLLOW_rule__DeclVal__NameAssignment_0_1_0_in_synpred9_InternalGDSL2575);
        rule__DeclVal__NameAssignment_0_1_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred9_InternalGDSL

    // $ANTLR start synpred54_InternalGDSL
    public final void synpred54_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4663:3: ( ruleHEXDIGIT )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4663:3: ruleHEXDIGIT
        {
        pushFollow(FOLLOW_ruleHEXDIGIT_in_synpred54_InternalGDSL9515);
        ruleHEXDIGIT();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_InternalGDSL

    // $ANTLR start synpred56_InternalGDSL
    public final void synpred56_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4787:3: ( ruleIDCHAR )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4787:3: ruleIDCHAR
        {
        pushFollow(FOLLOW_ruleIDCHAR_in_synpred56_InternalGDSL9762);
        ruleIDCHAR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalGDSL

    // Delegated rules

    public final boolean synpred9_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA44 dfa44 = new DFA44(this);
    static final String DFA6_eotS =
        "\31\uffff";
    static final String DFA6_eofS =
        "\31\uffff";
    static final String DFA6_minS =
        "\1\32\6\4\1\uffff\10\4\1\uffff\10\4";
    static final String DFA6_maxS =
        "\1\32\1\17\5\27\1\uffff\10\27\1\uffff\10\27";
    static final String DFA6_acceptS =
        "\7\uffff\1\1\10\uffff\1\2\10\uffff";
    static final String DFA6_specialS =
        "\31\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\2\1\4\1\5\1\3\1\6\1\7\1\uffff\2\7\2\uffff\1\7",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\3\uffff\1\16\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\3\uffff\1\16\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\3\uffff\1\16\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\3\uffff\1\16\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\3\uffff\1\16\6\uffff\1"+
            "\7\1\uffff\1\20",
            "",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\3\uffff\1\16\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\3\uffff\1\16\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\3\uffff\1\16\6\uffff\1"+
            "\7\1\uffff\1\20",
            "",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\3\uffff\1\27\6\uffff\1"+
            "\7\1\uffff\1\20"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1197:1: rule__DeclVal__Alternatives : ( ( ( rule__DeclVal__Group_0__0 ) ) | ( ( rule__DeclVal__Group_1__0 ) ) );";
        }
    }
    static final String DFA44_eotS =
        "\12\uffff";
    static final String DFA44_eofS =
        "\1\1\11\uffff";
    static final String DFA44_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA44_maxS =
        "\1\44\1\uffff\7\0\1\uffff";
    static final String DFA44_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA44_specialS =
        "\2\uffff\1\6\1\0\1\3\1\1\1\2\1\4\1\5\1\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\4\1\6\1\7\1\5\1\10\1\11\1\2\3\1\1\3\5\uffff\11\1\1\uffff"+
            "\7\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "()* loopback of 4787:1: ( ruleIDCHAR )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_3 = input.LA(1);

                         
                        int index44_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA44_5 = input.LA(1);

                         
                        int index44_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA44_6 = input.LA(1);

                         
                        int index44_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA44_4 = input.LA(1);

                         
                        int index44_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA44_7 = input.LA(1);

                         
                        int index44_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA44_8 = input.LA(1);

                         
                        int index44_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA44_2 = input.LA(1);

                         
                        int index44_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index44_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 44, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecl134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Decl__Alternatives_in_ruleDecl160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_entryRuleDeclGranularity187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclGranularity194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__0_in_ruleDeclGranularity220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__0_in_ruleDeclExport280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__0_in_ruleDeclType340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Alternatives_in_ruleDeclVal400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__0_in_ruleExport460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_entryRuleConDecls487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecls494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__0_in_ruleConDecls520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__0_in_ruleConDecl580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Alternatives_in_ruleTy640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__0_in_ruleTyElement700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__0_in_ruleTyBind760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecodePat_in_entryRuleDecodePat787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecodePat794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecodePat__Alternatives_in_ruleDecodePat820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_entryRuleBitPat847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPat854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__0_in_ruleBitPat880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_entryRuleTokPat907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTokPat914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TokPat__TokPatAssignment_in_ruleTokPat940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimBitPat974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Alternatives_in_rulePrimBitPat1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt1027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPatOrInt1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Alternatives_in_ruleBitPatOrInt1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp1087 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleExp1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_entryRuleInt1149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInt1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Int__Alternatives_in_ruleInt1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName1209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleName1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_entryRuleConBind1268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConBind1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConBind1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid1329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleQid1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT1388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__POSINT__Alternatives_in_rulePOSINT1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_entryRuleNEGINT1448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNEGINT1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__0_in_ruleNEGINT1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_entryRuleNUM1508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUM1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleNUM1544 = new BitSet(new long[]{0x0000000000004402L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleNUM1557 = new BitSet(new long[]{0x0000000000004402L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM1587 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXNUM1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__0_in_ruleHEXNUM1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_entryRuleBITSTR1649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITSTR1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITSTR1685 = new BitSet(new long[]{0x0000000000003C02L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITSTR1698 = new BitSet(new long[]{0x0000000000003C02L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS1730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONS__Group__0_in_ruleCONS1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_entryRuleID1790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleID1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ID__Group__0_in_ruleID1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT1850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXDIGIT1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXDIGIT__Alternatives_in_ruleHEXDIGIT1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR1910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXCHAR1917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXCHAR__Alternatives_in_ruleHEXCHAR1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_entryRuleULETTER1970 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleULETTER1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ULETTER__Alternatives_in_ruleULETTER2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_entryRuleLETTER2030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLETTER2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LETTER__Alternatives_in_ruleLETTER2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR2090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDCHAR2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IDCHAR__Alternatives_in_ruleIDCHAR2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_entryRuleBINARY2150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBINARY2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BINARY__Alternatives_in_ruleBINARY2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_entryRuleDIG2210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDIG2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DIG__Alternatives_in_ruleDIG2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_entryRuleSYM2270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSYM2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SYM__Alternatives_in_ruleSYM2303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_rule__Decl__Alternatives2373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Alternatives_2_0_in_rule__DeclType__Alternatives_22422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__0_in_rule__DeclType__Alternatives_22440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_0_0__0_in_rule__DeclType__Alternatives_2_02473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_2_0_1_in_rule__DeclType__Alternatives_2_02491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__0_in_rule__DeclVal__Alternatives2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__0_in_rule__DeclVal__Alternatives2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_0_1_0_in_rule__DeclVal__Alternatives_0_12575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_0_1_1_in_rule__DeclVal__Alternatives_0_12593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__0_in_rule__DeclVal__Alternatives_1_52626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_52646 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_52658 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_0_in_rule__Ty__Alternatives2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__0_in_rule__Ty__Alternatives2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__0_in_rule__Ty__Alternatives2730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__0_in_rule__Ty__Alternatives2748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_rule__DecodePat__Alternatives2781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_rule__DecodePat__Alternatives2798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__TokPat__TokPatAlternatives_02830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__TokPat__TokPatAlternatives_02847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rule__PrimBitPat__Alternatives2880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__0_in_rule__PrimBitPat__Alternatives2898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__0_in_rule__BitPatOrInt__Alternatives2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__0_in_rule__BitPatOrInt__Alternatives2949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_rule__Int__Alternatives2982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_rule__Int__Alternatives2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_rule__POSINT__Alternatives3031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_rule__POSINT__Alternatives3048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_rule__HEXDIGIT__Alternatives3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_rule__HEXDIGIT__Alternatives3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_rule__HEXCHAR__Alternatives3129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_rule__HEXCHAR__Alternatives3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_rule__ULETTER__Alternatives3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNHEXCHAR_in_rule__ULETTER__Alternatives3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_rule__LETTER__Alternatives3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LNHEXCHAR_in_rule__LETTER__Alternatives3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_rule__LETTER__Alternatives3261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_rule__LETTER__Alternatives3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_rule__IDCHAR__Alternatives3310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_rule__IDCHAR__Alternatives3327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_rule__IDCHAR__Alternatives3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_rule__BINARY__Alternatives3376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_rule__BINARY__Alternatives3393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_rule__BINARY__Alternatives3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__BINARY__Alternatives3427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_rule__DIG__Alternatives3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NBINDIG_in_rule__DIG__Alternatives3476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_rule__SYM__Alternatives3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_rule__SYM__Alternatives3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_rule__SYM__Alternatives3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_rule__SYM__Alternatives3559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OTHERSYM_in_rule__SYM__Alternatives3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__03606 = new BitSet(new long[]{0x0000001804500000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__03609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__13666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl3693 = new BitSet(new long[]{0x0000001804500002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__03728 = new BitSet(new long[]{0x0000001804500000L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__03731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Model__Group_1__0__Impl3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__13793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl3820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__03854 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__03857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl3884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__13914 = new BitSet(new long[]{0x0000000600004400L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__13917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclGranularity__Group__1__Impl3945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__23976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__04039 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__04042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl4069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__14099 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__14102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclExport__Group__1__Impl4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__24161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl4188 = new BitSet(new long[]{0x00000000000001F2L});
    public static final BitSet FOLLOW_rule__DeclType__Group__0__Impl_in_rule__DeclType__Group__04225 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclType__Group__1_in_rule__DeclType__Group__04228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__DeclType__Group__0__Impl4256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__1__Impl_in_rule__DeclType__Group__14287 = new BitSet(new long[]{0x0000000608A065F0L});
    public static final BitSet FOLLOW_rule__DeclType__Group__2_in_rule__DeclType__Group__14290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__NameAssignment_1_in_rule__DeclType__Group__1__Impl4317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__2__Impl_in_rule__DeclType__Group__24347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Alternatives_2_in_rule__DeclType__Group__2__Impl4374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_0_0__0__Impl_in_rule__DeclType__Group_2_0_0__04410 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_0_0__1_in_rule__DeclType__Group_2_0_0__04413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclType__Group_2_0_0__0__Impl4441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_0_0__1__Impl_in_rule__DeclType__Group_2_0_0__14472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_2_0_0_1_in_rule__DeclType__Group_2_0_0__1__Impl4499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__0__Impl_in_rule__DeclType__Group_2_1__04533 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__1_in_rule__DeclType__Group_2_1__04536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DeclType__Group_2_1__0__Impl4564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__1__Impl_in_rule__DeclType__Group_2_1__14595 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__2_in_rule__DeclType__Group_2_1__14598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__AttrNameAssignment_2_1_1_in_rule__DeclType__Group_2_1__1__Impl4625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__2__Impl_in_rule__DeclType__Group_2_1__24655 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__3_in_rule__DeclType__Group_2_1__24658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1_2__0_in_rule__DeclType__Group_2_1__2__Impl4685 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__3__Impl_in_rule__DeclType__Group_2_1__34716 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__4_in_rule__DeclType__Group_2_1__34719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__DeclType__Group_2_1__3__Impl4747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__4__Impl_in_rule__DeclType__Group_2_1__44778 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__5_in_rule__DeclType__Group_2_1__44781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclType__Group_2_1__4__Impl4809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__5__Impl_in_rule__DeclType__Group_2_1__54840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_2_1_5_in_rule__DeclType__Group_2_1__5__Impl4867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1_2__0__Impl_in_rule__DeclType__Group_2_1_2__04909 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1_2__1_in_rule__DeclType__Group_2_1_2__04912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__DeclType__Group_2_1_2__0__Impl4940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1_2__1__Impl_in_rule__DeclType__Group_2_1_2__14971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__AttrNameAssignment_2_1_2_1_in_rule__DeclType__Group_2_1_2__1__Impl4998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__0__Impl_in_rule__DeclVal__Group_0__05032 = new BitSet(new long[]{0x0000000000009BF0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__1_in_rule__DeclVal__Group_0__05035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DeclVal__Group_0__0__Impl5063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__1__Impl_in_rule__DeclVal__Group_0__15094 = new BitSet(new long[]{0x00000000002001F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__2_in_rule__DeclVal__Group_0__15097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Alternatives_0_1_in_rule__DeclVal__Group_0__1__Impl5124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__2__Impl_in_rule__DeclVal__Group_0__25154 = new BitSet(new long[]{0x00000000002001F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__3_in_rule__DeclVal__Group_0__25157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__AttrAssignment_0_2_in_rule__DeclVal__Group_0__2__Impl5184 = new BitSet(new long[]{0x00000000000001F2L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__3__Impl_in_rule__DeclVal__Group_0__35215 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__4_in_rule__DeclVal__Group_0__35218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclVal__Group_0__3__Impl5246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__4__Impl_in_rule__DeclVal__Group_0__45277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpAssignment_0_4_in_rule__DeclVal__Group_0__4__Impl5304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__0__Impl_in_rule__DeclVal__Group_1__05344 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__1_in_rule__DeclVal__Group_1__05347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DeclVal__Group_1__0__Impl5375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__1__Impl_in_rule__DeclVal__Group_1__15406 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__2_in_rule__DeclVal__Group_1__15409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_1_1_in_rule__DeclVal__Group_1__1__Impl5436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__2__Impl_in_rule__DeclVal__Group_1__25466 = new BitSet(new long[]{0x00000006810045F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__3_in_rule__DeclVal__Group_1__25469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DeclVal__Group_1__2__Impl5497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__3__Impl_in_rule__DeclVal__Group_1__35528 = new BitSet(new long[]{0x00000006810045F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__4_in_rule__DeclVal__Group_1__35531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_3__0_in_rule__DeclVal__Group_1__3__Impl5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__4__Impl_in_rule__DeclVal__Group_1__45589 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__5_in_rule__DeclVal__Group_1__45592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__DeclVal__Group_1__4__Impl5620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__5__Impl_in_rule__DeclVal__Group_1__55651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Alternatives_1_5_in_rule__DeclVal__Group_1__5__Impl5678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_3__0__Impl_in_rule__DeclVal__Group_1_3__05720 = new BitSet(new long[]{0x00000006800045F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_3__1_in_rule__DeclVal__Group_1_3__05723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__DecPatAssignment_1_3_0_in_rule__DeclVal__Group_1_3__0__Impl5750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_3__1__Impl_in_rule__DeclVal__Group_1_3__15780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__DecPatAssignment_1_3_1_in_rule__DeclVal__Group_1_3__1__Impl5807 = new BitSet(new long[]{0x00000006800045F2L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__0__Impl_in_rule__DeclVal__Group_1_5_0__05842 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__1_in_rule__DeclVal__Group_1_5_0__05845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclVal__Group_1_5_0__0__Impl5873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__1__Impl_in_rule__DeclVal__Group_1_5_0__15904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpAssignment_1_5_0_1_in_rule__DeclVal__Group_1_5_0__1__Impl5931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__0__Impl_in_rule__DeclVal__Group_1_5_1__05965 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__1_in_rule__DeclVal__Group_1_5_1__05968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__DeclVal__Group_1_5_1__0__Impl5995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__1__Impl_in_rule__DeclVal__Group_1_5_1__16024 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__2_in_rule__DeclVal__Group_1_5_1__16027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_1_in_rule__DeclVal__Group_1_5_1__1__Impl6054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__2__Impl_in_rule__DeclVal__Group_1_5_1__26084 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__3_in_rule__DeclVal__Group_1_5_1__26087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclVal__Group_1_5_1__2__Impl6115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__3__Impl_in_rule__DeclVal__Group_1_5_1__36146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_3_in_rule__DeclVal__Group_1_5_1__3__Impl6173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__06211 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Export__Group__1_in_rule__Export__Group__06214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl6241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__16271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl6298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__06333 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__06336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Export__Group_1__0__Impl6364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__16395 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__16398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl6425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__26455 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__26458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl6485 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__36516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Export__Group_1__3__Impl6544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__06583 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__06586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Export__Group_1_2__0__Impl6614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__16645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl6672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__0__Impl_in_rule__ConDecls__Group__06706 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__1_in_rule__ConDecls__Group__06709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__ConDeclsAssignment_0_in_rule__ConDecls__Group__0__Impl6736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__1__Impl_in_rule__ConDecls__Group__16766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__0_in_rule__ConDecls__Group__1__Impl6793 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__0__Impl_in_rule__ConDecls__Group_1__06828 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__1_in_rule__ConDecls__Group_1__06831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__ConDecls__Group_1__0__Impl6858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__1__Impl_in_rule__ConDecls__Group_1__16887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__ConDeclsAssignment_1_1_in_rule__ConDecls__Group_1__1__Impl6914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__0__Impl_in_rule__ConDecl__Group__06948 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__1_in_rule__ConDecl__Group__06951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__NameAssignment_0_in_rule__ConDecl__Group__0__Impl6978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__1__Impl_in_rule__ConDecl__Group__17008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__0_in_rule__ConDecl__Group__1__Impl7035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__0__Impl_in_rule__ConDecl__Group_1__07070 = new BitSet(new long[]{0x00000006082065F0L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__1_in_rule__ConDecl__Group_1__07073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConDecl__Group_1__0__Impl7101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__1__Impl_in_rule__ConDecl__Group_1__17132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__TyAssignment_1_1_in_rule__ConDecl__Group_1__1__Impl7159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__0__Impl_in_rule__Ty__Group_1__07193 = new BitSet(new long[]{0x0000000600004400L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__1_in_rule__Ty__Group_1__07196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__Ty__Group_1__0__Impl7223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__1__Impl_in_rule__Ty__Group_1__17252 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__2_in_rule__Ty__Group_1__17255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_1_1_in_rule__Ty__Group_1__1__Impl7282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__2__Impl_in_rule__Ty__Group_1__27312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__Ty__Group_1__2__Impl7339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__0__Impl_in_rule__Ty__Group_2__07374 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__1_in_rule__Ty__Group_2__07377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_2_0_in_rule__Ty__Group_2__0__Impl7404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__1__Impl_in_rule__Ty__Group_2__17434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__0_in_rule__Ty__Group_2__1__Impl7461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__0__Impl_in_rule__Ty__Group_2_1__07496 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__1_in_rule__Ty__Group_2_1__07499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Ty__Group_2_1__0__Impl7527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__1__Impl_in_rule__Ty__Group_2_1__17558 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__2_in_rule__Ty__Group_2_1__17561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__TyBindAssignment_2_1_1_in_rule__Ty__Group_2_1__1__Impl7588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__2__Impl_in_rule__Ty__Group_2_1__27618 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__3_in_rule__Ty__Group_2_1__27621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__0_in_rule__Ty__Group_2_1__2__Impl7648 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__3__Impl_in_rule__Ty__Group_2_1__37679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Ty__Group_2_1__3__Impl7707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__0__Impl_in_rule__Ty__Group_2_1_2__07746 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__1_in_rule__Ty__Group_2_1_2__07749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Ty__Group_2_1_2__0__Impl7777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__1__Impl_in_rule__Ty__Group_2_1_2__17808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__TyBindAssignment_2_1_2_1_in_rule__Ty__Group_2_1_2__1__Impl7835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__0__Impl_in_rule__Ty__Group_3__07869 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__1_in_rule__Ty__Group_3__07872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Ty__Group_3__0__Impl7900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__1__Impl_in_rule__Ty__Group_3__17931 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__2_in_rule__Ty__Group_3__17934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ElementsAssignment_3_1_in_rule__Ty__Group_3__1__Impl7961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__2__Impl_in_rule__Ty__Group_3__27991 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__3_in_rule__Ty__Group_3__27994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__0_in_rule__Ty__Group_3__2__Impl8021 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__3__Impl_in_rule__Ty__Group_3__38052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Ty__Group_3__3__Impl8080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__0__Impl_in_rule__Ty__Group_3_2__08119 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__1_in_rule__Ty__Group_3_2__08122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Ty__Group_3_2__0__Impl8150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__1__Impl_in_rule__Ty__Group_3_2__18181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ElementsAssignment_3_2_1_in_rule__Ty__Group_3_2__1__Impl8208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__0__Impl_in_rule__TyElement__Group__08242 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__TyElement__Group__1_in_rule__TyElement__Group__08245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__NameAssignment_0_in_rule__TyElement__Group__0__Impl8272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__1__Impl_in_rule__TyElement__Group__18302 = new BitSet(new long[]{0x00000006082065F0L});
    public static final BitSet FOLLOW_rule__TyElement__Group__2_in_rule__TyElement__Group__18305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__TyElement__Group__1__Impl8333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__2__Impl_in_rule__TyElement__Group__28364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__ValueAssignment_2_in_rule__TyElement__Group__2__Impl8391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__0__Impl_in_rule__TyBind__Group__08427 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__TyBind__Group__1_in_rule__TyBind__Group__08430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__KeyAssignment_0_in_rule__TyBind__Group__0__Impl8457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__1__Impl_in_rule__TyBind__Group__18487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__0_in_rule__TyBind__Group__1__Impl8514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__0__Impl_in_rule__TyBind__Group_1__08549 = new BitSet(new long[]{0x00000006082065F0L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__1_in_rule__TyBind__Group_1__08552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__TyBind__Group_1__0__Impl8580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__1__Impl_in_rule__TyBind__Group_1__18611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__ValueAssignment_1_1_in_rule__TyBind__Group_1__1__Impl8638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__0__Impl_in_rule__BitPat__Group__08672 = new BitSet(new long[]{0x0000000000003DF0L});
    public static final BitSet FOLLOW_rule__BitPat__Group__1_in_rule__BitPat__Group__08675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__BitPat__Group__0__Impl8703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__1__Impl_in_rule__BitPat__Group__18734 = new BitSet(new long[]{0x0000000080003DF0L});
    public static final BitSet FOLLOW_rule__BitPat__Group__2_in_rule__BitPat__Group__18737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__BitpatAssignment_1_in_rule__BitPat__Group__1__Impl8764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__2__Impl_in_rule__BitPat__Group__28794 = new BitSet(new long[]{0x0000000080003DF0L});
    public static final BitSet FOLLOW_rule__BitPat__Group__3_in_rule__BitPat__Group__28797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__BitpatAssignment_2_in_rule__BitPat__Group__2__Impl8824 = new BitSet(new long[]{0x0000000000003DF2L});
    public static final BitSet FOLLOW_rule__BitPat__Group__3__Impl_in_rule__BitPat__Group__38855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__BitPat__Group__3__Impl8883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__0__Impl_in_rule__PrimBitPat__Group_1__08922 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__1_in_rule__PrimBitPat__Group_1__08925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__PrimBitPat__Group_1__0__Impl8952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__1__Impl_in_rule__PrimBitPat__Group_1__18981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_rule__PrimBitPat__Group_1__1__Impl9009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__0__Impl_in_rule__BitPatOrInt__Group_0__09044 = new BitSet(new long[]{0x0000000400004400L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__1_in_rule__BitPatOrInt__Group_0__09047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__BitPatOrInt__Group_0__0__Impl9075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__1__Impl_in_rule__BitPatOrInt__Group_0__19106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_rule__BitPatOrInt__Group_0__1__Impl9133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__0__Impl_in_rule__BitPatOrInt__Group_1__09166 = new BitSet(new long[]{0x0000000000003C00L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__1_in_rule__BitPatOrInt__Group_1__09169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__BitPatOrInt__Group_1__0__Impl9197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__1__Impl_in_rule__BitPatOrInt__Group_1__19228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rule__BitPatOrInt__Group_1__1__Impl9255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__0__Impl_in_rule__NEGINT__Group__09288 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__1_in_rule__NEGINT__Group__09291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__NEGINT__Group__0__Impl9319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__1__Impl_in_rule__NEGINT__Group__19350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_rule__NEGINT__Group__1__Impl9377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__0__Impl_in_rule__HEXNUM__Group__09410 = new BitSet(new long[]{0x0000000000004430L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__1_in_rule__HEXNUM__Group__09413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__HEXNUM__Group__0__Impl9441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__1__Impl_in_rule__HEXNUM__Group__19472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_rule__HEXNUM__Group__1__Impl9502 = new BitSet(new long[]{0x0000000000004432L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_rule__HEXNUM__Group__1__Impl9515 = new BitSet(new long[]{0x0000000000004432L});
    public static final BitSet FOLLOW_rule__CONS__Group__0__Impl_in_rule__CONS__Group__09553 = new BitSet(new long[]{0x00000000000047F0L});
    public static final BitSet FOLLOW_rule__CONS__Group__1_in_rule__CONS__Group__09556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_rule__CONS__Group__0__Impl9583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONS__Group__1__Impl_in_rule__CONS__Group__19612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_rule__CONS__Group__1__Impl9640 = new BitSet(new long[]{0x00000000000047F2L});
    public static final BitSet FOLLOW_rule__ID__Group__0__Impl_in_rule__ID__Group__09675 = new BitSet(new long[]{0x00000000000047F0L});
    public static final BitSet FOLLOW_rule__ID__Group__1_in_rule__ID__Group__09678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_rule__ID__Group__0__Impl9705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ID__Group__1__Impl_in_rule__ID__Group__19734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_rule__ID__Group__1__Impl9762 = new BitSet(new long[]{0x00000000000047F2L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_09802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_19833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__DeclGranularity__NameAssignment_09869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__DeclGranularity__GranularityAssignment_29908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__DeclExport__NameAssignment_09944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_29983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__NameAssignment_110014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_2_0_0_110045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__DeclType__ValueAssignment_2_0_110076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_2_1_110107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_2_1_2_110138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_2_1_510169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_0_1_010200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_rule__DeclVal__NameAssignment_0_1_110231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclVal__AttrAssignment_0_210262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_0_410293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_1_110324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_3_010355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_3_110386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_1_5_0_110417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_110448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_310479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__Export__NameAssignment_010510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_110541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_2_110572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_010603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_1_110634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_rule__ConDecl__NameAssignment_010665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__ConDecl__TyAssignment_1_110696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_010727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_1_110758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__Ty__ValueAssignment_2_010789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_110820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_2_110851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_110882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_2_110913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__TyElement__NameAssignment_010944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__TyElement__ValueAssignment_210975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__TyBind__KeyAssignment_011006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__TyBind__ValueAssignment_1_111037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_111068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_211099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TokPat__TokPatAlternatives_0_in_rule__TokPat__TokPatAssignment11130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_synpred1_InternalGDSL1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_synpred2_InternalGDSL1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_0_1_0_in_synpred9_InternalGDSL2575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_synpred54_InternalGDSL9515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_synpred56_InternalGDSL9762 = new BitSet(new long[]{0x0000000000000002L});

}