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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LHEXCHAR", "RULE_UHEXCHAR", "RULE_UNHEXCHAR", "RULE_LNHEXCHAR", "RULE_SLASH", "RULE_CHARSYM", "RULE_BINDIG", "RULE_BS", "RULE_DOT", "RULE_PIPE", "RULE_NBINDIG", "RULE_OTHERSYM", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'_'", "';'", "'='", "'type'", "'['", "']'", "','", "'val'", "'{'", "'}'", "'of'", "':'", "'\\''", "'case'", "'end'", "'if'", "'then'", "'else'", "'do'", "'<-'", "'or'", "'and'", "'@'", "'~'", "'0x'", "'granularity'", "'export'", "'todo'"
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
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_DOT=12;
    public static final int RULE_NBINDIG=14;
    public static final int RULE_LHEXCHAR=4;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_SL_COMMENT=18;
    public static final int RULE_ML_COMMENT=17;
    public static final int RULE_BS=11;
    public static final int RULE_UNHEXCHAR=6;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int RULE_PIPE=13;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_OTHERSYM=15;
    public static final int T__39=39;
    public static final int RULE_LNHEXCHAR=7;
    public static final int RULE_BINDIG=10;
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


    // $ANTLR start "entryRuleExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:481:1: entryRuleExp : ruleExp EOF ;
    public final void entryRuleExp() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:482:1: ( ruleExp EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:483:1: ruleExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpRule()); 
            }
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp967);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp974); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:490:1: ruleExp : ( ( rule__Exp__Alternatives ) ) ;
    public final void ruleExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:494:2: ( ( ( rule__Exp__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:495:1: ( ( rule__Exp__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:495:1: ( ( rule__Exp__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:496:1: ( rule__Exp__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:497:1: ( rule__Exp__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:497:2: rule__Exp__Alternatives
            {
            pushFollow(FOLLOW_rule__Exp__Alternatives_in_ruleExp1000);
            rule__Exp__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpAccess().getAlternatives()); 
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


    // $ANTLR start "entryRuleCaseExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:509:1: entryRuleCaseExp : ruleCaseExp EOF ;
    public final void entryRuleCaseExp() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:510:1: ( ruleCaseExp EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:511:1: ruleCaseExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCaseExpRule()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_entryRuleCaseExp1027);
            ruleCaseExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCaseExpRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseExp1034); if (state.failed) return ;

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
    // $ANTLR end "entryRuleCaseExp"


    // $ANTLR start "ruleCaseExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:518:1: ruleCaseExp : ( ( rule__CaseExp__Alternatives ) ) ;
    public final void ruleCaseExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:522:2: ( ( ( rule__CaseExp__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:523:1: ( ( rule__CaseExp__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:523:1: ( ( rule__CaseExp__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:524:1: ( rule__CaseExp__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCaseExpAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:525:1: ( rule__CaseExp__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:525:2: rule__CaseExp__Alternatives
            {
            pushFollow(FOLLOW_rule__CaseExp__Alternatives_in_ruleCaseExp1060);
            rule__CaseExp__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCaseExpAccess().getAlternatives()); 
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
    // $ANTLR end "ruleCaseExp"


    // $ANTLR start "entryRuleClosedExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:537:1: entryRuleClosedExp : ruleClosedExp EOF ;
    public final void entryRuleClosedExp() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:538:1: ( ruleClosedExp EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:539:1: ruleClosedExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpRule()); 
            }
            pushFollow(FOLLOW_ruleClosedExp_in_entryRuleClosedExp1087);
            ruleClosedExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedExp1094); if (state.failed) return ;

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
    // $ANTLR end "entryRuleClosedExp"


    // $ANTLR start "ruleClosedExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:546:1: ruleClosedExp : ( ( rule__ClosedExp__Alternatives ) ) ;
    public final void ruleClosedExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:550:2: ( ( ( rule__ClosedExp__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:551:1: ( ( rule__ClosedExp__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:551:1: ( ( rule__ClosedExp__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:552:1: ( rule__ClosedExp__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:553:1: ( rule__ClosedExp__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:553:2: rule__ClosedExp__Alternatives
            {
            pushFollow(FOLLOW_rule__ClosedExp__Alternatives_in_ruleClosedExp1120);
            rule__ClosedExp__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getAlternatives()); 
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
    // $ANTLR end "ruleClosedExp"


    // $ANTLR start "entryRuleMonadicExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:565:1: entryRuleMonadicExp : ruleMonadicExp EOF ;
    public final void entryRuleMonadicExp() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:566:1: ( ruleMonadicExp EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:567:1: ruleMonadicExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMonadicExpRule()); 
            }
            pushFollow(FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp1147);
            ruleMonadicExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMonadicExpRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonadicExp1154); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMonadicExp"


    // $ANTLR start "ruleMonadicExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:574:1: ruleMonadicExp : ( ( rule__MonadicExp__Alternatives ) ) ;
    public final void ruleMonadicExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:578:2: ( ( ( rule__MonadicExp__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:579:1: ( ( rule__MonadicExp__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:579:1: ( ( rule__MonadicExp__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:580:1: ( rule__MonadicExp__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMonadicExpAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:581:1: ( rule__MonadicExp__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:581:2: rule__MonadicExp__Alternatives
            {
            pushFollow(FOLLOW_rule__MonadicExp__Alternatives_in_ruleMonadicExp1180);
            rule__MonadicExp__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMonadicExpAccess().getAlternatives()); 
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
    // $ANTLR end "ruleMonadicExp"


    // $ANTLR start "entryRuleCases"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:593:1: entryRuleCases : ruleCases EOF ;
    public final void entryRuleCases() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:594:1: ( ruleCases EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:595:1: ruleCases EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesRule()); 
            }
            pushFollow(FOLLOW_ruleCases_in_entryRuleCases1207);
            ruleCases();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCases1214); if (state.failed) return ;

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
    // $ANTLR end "entryRuleCases"


    // $ANTLR start "ruleCases"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:602:1: ruleCases : ( ( rule__Cases__Group__0 ) ) ;
    public final void ruleCases() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:606:2: ( ( ( rule__Cases__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:607:1: ( ( rule__Cases__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:607:1: ( ( rule__Cases__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:608:1: ( rule__Cases__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:609:1: ( rule__Cases__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:609:2: rule__Cases__Group__0
            {
            pushFollow(FOLLOW_rule__Cases__Group__0_in_ruleCases1240);
            rule__Cases__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getGroup()); 
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
    // $ANTLR end "ruleCases"


    // $ANTLR start "entryRuleOrElseExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:621:1: entryRuleOrElseExp : ruleOrElseExp EOF ;
    public final void entryRuleOrElseExp() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:622:1: ( ruleOrElseExp EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:623:1: ruleOrElseExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrElseExpRule()); 
            }
            pushFollow(FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp1267);
            ruleOrElseExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrElseExpRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrElseExp1274); if (state.failed) return ;

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
    // $ANTLR end "entryRuleOrElseExp"


    // $ANTLR start "ruleOrElseExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:630:1: ruleOrElseExp : ( ( rule__OrElseExp__Group__0 ) ) ;
    public final void ruleOrElseExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:634:2: ( ( ( rule__OrElseExp__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:635:1: ( ( rule__OrElseExp__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:635:1: ( ( rule__OrElseExp__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:636:1: ( rule__OrElseExp__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrElseExpAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:637:1: ( rule__OrElseExp__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:637:2: rule__OrElseExp__Group__0
            {
            pushFollow(FOLLOW_rule__OrElseExp__Group__0_in_ruleOrElseExp1300);
            rule__OrElseExp__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrElseExpAccess().getGroup()); 
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
    // $ANTLR end "ruleOrElseExp"


    // $ANTLR start "entryRuleAndAlsoExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:649:1: entryRuleAndAlsoExp : ruleAndAlsoExp EOF ;
    public final void entryRuleAndAlsoExp() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:650:1: ( ruleAndAlsoExp EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:651:1: ruleAndAlsoExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAlsoExpRule()); 
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp1327);
            ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAlsoExpRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndAlsoExp1334); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAndAlsoExp"


    // $ANTLR start "ruleAndAlsoExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:658:1: ruleAndAlsoExp : ( ( rule__AndAlsoExp__Group__0 ) ) ;
    public final void ruleAndAlsoExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:662:2: ( ( ( rule__AndAlsoExp__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:663:1: ( ( rule__AndAlsoExp__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:663:1: ( ( rule__AndAlsoExp__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:664:1: ( rule__AndAlsoExp__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAlsoExpAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:665:1: ( rule__AndAlsoExp__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:665:2: rule__AndAlsoExp__Group__0
            {
            pushFollow(FOLLOW_rule__AndAlsoExp__Group__0_in_ruleAndAlsoExp1360);
            rule__AndAlsoExp__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAlsoExpAccess().getGroup()); 
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
    // $ANTLR end "ruleAndAlsoExp"


    // $ANTLR start "entryRuleRExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:677:1: entryRuleRExp : ruleRExp EOF ;
    public final void entryRuleRExp() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:678:1: ( ruleRExp EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:679:1: ruleRExp EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRExpRule()); 
            }
            pushFollow(FOLLOW_ruleRExp_in_entryRuleRExp1387);
            ruleRExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRExpRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRExp1394); if (state.failed) return ;

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
    // $ANTLR end "entryRuleRExp"


    // $ANTLR start "ruleRExp"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:686:1: ruleRExp : ( ( rule__RExp__NameAssignment ) ) ;
    public final void ruleRExp() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:690:2: ( ( ( rule__RExp__NameAssignment ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:691:1: ( ( rule__RExp__NameAssignment ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:691:1: ( ( rule__RExp__NameAssignment ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:692:1: ( rule__RExp__NameAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRExpAccess().getNameAssignment()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:693:1: ( rule__RExp__NameAssignment )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:693:2: rule__RExp__NameAssignment
            {
            pushFollow(FOLLOW_rule__RExp__NameAssignment_in_ruleRExp1420);
            rule__RExp__NameAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRExpAccess().getNameAssignment()); 
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
    // $ANTLR end "ruleRExp"


    // $ANTLR start "entryRulePat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:705:1: entryRulePat : rulePat EOF ;
    public final void entryRulePat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:706:1: ( rulePat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:707:1: rulePat EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPatRule()); 
            }
            pushFollow(FOLLOW_rulePat_in_entryRulePat1447);
            rulePat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPatRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePat1454); if (state.failed) return ;

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
    // $ANTLR end "entryRulePat"


    // $ANTLR start "rulePat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:714:1: rulePat : ( ( rule__Pat__Alternatives ) ) ;
    public final void rulePat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:718:2: ( ( ( rule__Pat__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:719:1: ( ( rule__Pat__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:719:1: ( ( rule__Pat__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:720:1: ( rule__Pat__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPatAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:721:1: ( rule__Pat__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:721:2: rule__Pat__Alternatives
            {
            pushFollow(FOLLOW_rule__Pat__Alternatives_in_rulePat1480);
            rule__Pat__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPatAccess().getAlternatives()); 
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
    // $ANTLR end "rulePat"


    // $ANTLR start "entryRuleLit"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:733:1: entryRuleLit : ruleLit EOF ;
    public final void entryRuleLit() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:734:1: ( ruleLit EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:735:1: ruleLit EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLitRule()); 
            }
            pushFollow(FOLLOW_ruleLit_in_entryRuleLit1507);
            ruleLit();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLitRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLit1514); if (state.failed) return ;

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
    // $ANTLR end "entryRuleLit"


    // $ANTLR start "ruleLit"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:742:1: ruleLit : ( ( rule__Lit__Alternatives ) ) ;
    public final void ruleLit() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:746:2: ( ( ( rule__Lit__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:747:1: ( ( rule__Lit__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:747:1: ( ( rule__Lit__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:748:1: ( rule__Lit__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLitAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:749:1: ( rule__Lit__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:749:2: rule__Lit__Alternatives
            {
            pushFollow(FOLLOW_rule__Lit__Alternatives_in_ruleLit1540);
            rule__Lit__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLitAccess().getAlternatives()); 
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
    // $ANTLR end "ruleLit"


    // $ANTLR start "entryRulePrimBitPat"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:761:1: entryRulePrimBitPat : rulePrimBitPat EOF ;
    public final void entryRulePrimBitPat() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:762:1: ( rulePrimBitPat EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:763:1: rulePrimBitPat EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimBitPatRule()); 
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat1567);
            rulePrimBitPat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimBitPatRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimBitPat1574); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:770:1: rulePrimBitPat : ( ( rule__PrimBitPat__Alternatives ) ) ;
    public final void rulePrimBitPat() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:774:2: ( ( ( rule__PrimBitPat__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:775:1: ( ( rule__PrimBitPat__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:775:1: ( ( rule__PrimBitPat__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:776:1: ( rule__PrimBitPat__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimBitPatAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:777:1: ( rule__PrimBitPat__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:777:2: rule__PrimBitPat__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimBitPat__Alternatives_in_rulePrimBitPat1600);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:789:1: entryRuleBitPatOrInt : ruleBitPatOrInt EOF ;
    public final void entryRuleBitPatOrInt() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:790:1: ( ruleBitPatOrInt EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:791:1: ruleBitPatOrInt EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntRule()); 
            }
            pushFollow(FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt1627);
            ruleBitPatOrInt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBitPatOrIntRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPatOrInt1634); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:798:1: ruleBitPatOrInt : ( ( rule__BitPatOrInt__Alternatives ) ) ;
    public final void ruleBitPatOrInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:802:2: ( ( ( rule__BitPatOrInt__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:803:1: ( ( rule__BitPatOrInt__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:803:1: ( ( rule__BitPatOrInt__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:804:1: ( rule__BitPatOrInt__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:805:1: ( rule__BitPatOrInt__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:805:2: rule__BitPatOrInt__Alternatives
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Alternatives_in_ruleBitPatOrInt1660);
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


    // $ANTLR start "entryRuleInt"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:817:1: entryRuleInt : ruleInt EOF ;
    public final void entryRuleInt() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:818:1: ( ruleInt EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:819:1: ruleInt EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntRule()); 
            }
            pushFollow(FOLLOW_ruleInt_in_entryRuleInt1687);
            ruleInt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInt1694); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:826:1: ruleInt : ( ( rule__Int__Alternatives ) ) ;
    public final void ruleInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:830:2: ( ( ( rule__Int__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:831:1: ( ( rule__Int__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:831:1: ( ( rule__Int__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:832:1: ( rule__Int__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:833:1: ( rule__Int__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:833:2: rule__Int__Alternatives
            {
            pushFollow(FOLLOW_rule__Int__Alternatives_in_ruleInt1720);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:845:1: entryRuleName : ruleName EOF ;
    public final void entryRuleName() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:846:1: ( ruleName EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:847:1: ruleName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameRule()); 
            }
            pushFollow(FOLLOW_ruleName_in_entryRuleName1747);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNameRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleName1754); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:854:1: ruleName : ( ruleID ) ;
    public final void ruleName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:858:2: ( ( ruleID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:859:1: ( ruleID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:859:1: ( ruleID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:860:1: ruleID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameAccess().getIDParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleID_in_ruleName1780);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:873:1: entryRuleConBind : ruleConBind EOF ;
    public final void entryRuleConBind() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:874:1: ( ruleConBind EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:875:1: ruleConBind EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConBindRule()); 
            }
            pushFollow(FOLLOW_ruleConBind_in_entryRuleConBind1806);
            ruleConBind();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConBindRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConBind1813); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:882:1: ruleConBind : ( ruleCONS ) ;
    public final void ruleConBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:886:2: ( ( ruleCONS ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:887:1: ( ruleCONS )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:887:1: ( ruleCONS )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:888:1: ruleCONS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConBindAccess().getCONSParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConBind1839);
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


    // $ANTLR start "entryRuleConUse"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:901:1: entryRuleConUse : ruleConUse EOF ;
    public final void entryRuleConUse() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:902:1: ( ruleConUse EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:903:1: ruleConUse EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConUseRule()); 
            }
            pushFollow(FOLLOW_ruleConUse_in_entryRuleConUse1865);
            ruleConUse();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConUseRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConUse1872); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConUse"


    // $ANTLR start "ruleConUse"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:910:1: ruleConUse : ( ruleCONS ) ;
    public final void ruleConUse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:914:2: ( ( ruleCONS ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:915:1: ( ruleCONS )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:915:1: ( ruleCONS )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:916:1: ruleCONS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConUseAccess().getCONSParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConUse1898);
            ruleCONS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConUseAccess().getCONSParserRuleCall()); 
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
    // $ANTLR end "ruleConUse"


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:929:1: entryRuleQid : ruleQid EOF ;
    public final void entryRuleQid() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:930:1: ( ruleQid EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:931:1: ruleQid EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQidRule()); 
            }
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid1924);
            ruleQid();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQidRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid1931); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:938:1: ruleQid : ( ruleID ) ;
    public final void ruleQid() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:942:2: ( ( ruleID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:943:1: ( ruleID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:943:1: ( ruleID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:944:1: ruleID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQidAccess().getIDParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleID_in_ruleQid1957);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:957:1: entryRulePOSINT : rulePOSINT EOF ;
    public final void entryRulePOSINT() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:958:1: ( rulePOSINT EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:959:1: rulePOSINT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOSINTRule()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT1983);
            rulePOSINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPOSINTRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT1990); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:966:1: rulePOSINT : ( ( rule__POSINT__Alternatives ) ) ;
    public final void rulePOSINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:970:2: ( ( ( rule__POSINT__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:971:1: ( ( rule__POSINT__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:971:1: ( ( rule__POSINT__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:972:1: ( rule__POSINT__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPOSINTAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:973:1: ( rule__POSINT__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:973:2: rule__POSINT__Alternatives
            {
            pushFollow(FOLLOW_rule__POSINT__Alternatives_in_rulePOSINT2016);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:985:1: entryRuleNEGINT : ruleNEGINT EOF ;
    public final void entryRuleNEGINT() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:986:1: ( ruleNEGINT EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:987:1: ruleNEGINT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNEGINTRule()); 
            }
            pushFollow(FOLLOW_ruleNEGINT_in_entryRuleNEGINT2043);
            ruleNEGINT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNEGINTRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNEGINT2050); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:994:1: ruleNEGINT : ( ( rule__NEGINT__Group__0 ) ) ;
    public final void ruleNEGINT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:998:2: ( ( ( rule__NEGINT__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:999:1: ( ( rule__NEGINT__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:999:1: ( ( rule__NEGINT__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1000:1: ( rule__NEGINT__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNEGINTAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1001:1: ( rule__NEGINT__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1001:2: rule__NEGINT__Group__0
            {
            pushFollow(FOLLOW_rule__NEGINT__Group__0_in_ruleNEGINT2076);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1013:1: entryRuleNUM : ruleNUM EOF ;
    public final void entryRuleNUM() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1014:1: ( ruleNUM EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1015:1: ruleNUM EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNUMRule()); 
            }
            pushFollow(FOLLOW_ruleNUM_in_entryRuleNUM2103);
            ruleNUM();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNUMRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUM2110); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1022:1: ruleNUM : ( ( ( ruleDIG ) ) ( ( ruleDIG )* ) ) ;
    public final void ruleNUM() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1026:2: ( ( ( ( ruleDIG ) ) ( ( ruleDIG )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1027:1: ( ( ( ruleDIG ) ) ( ( ruleDIG )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1027:1: ( ( ( ruleDIG ) ) ( ( ruleDIG )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1028:1: ( ( ruleDIG ) ) ( ( ruleDIG )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1028:1: ( ( ruleDIG ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1029:1: ( ruleDIG )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1030:1: ( ruleDIG )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1030:3: ruleDIG
            {
            pushFollow(FOLLOW_ruleDIG_in_ruleNUM2139);
            ruleDIG();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            }

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1033:1: ( ( ruleDIG )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1034:1: ( ruleDIG )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1035:1: ( ruleDIG )*
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
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1035:3: ruleDIG
            	    {
            	    pushFollow(FOLLOW_ruleDIG_in_ruleNUM2152);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1048:1: entryRuleHEXNUM : ruleHEXNUM EOF ;
    public final void entryRuleHEXNUM() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1049:1: ( ruleHEXNUM EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1050:1: ruleHEXNUM EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMRule()); 
            }
            pushFollow(FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM2182);
            ruleHEXNUM();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXNUMRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXNUM2189); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1057:1: ruleHEXNUM : ( ( rule__HEXNUM__Group__0 ) ) ;
    public final void ruleHEXNUM() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1061:2: ( ( ( rule__HEXNUM__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1062:1: ( ( rule__HEXNUM__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1062:1: ( ( rule__HEXNUM__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1063:1: ( rule__HEXNUM__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1064:1: ( rule__HEXNUM__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1064:2: rule__HEXNUM__Group__0
            {
            pushFollow(FOLLOW_rule__HEXNUM__Group__0_in_ruleHEXNUM2215);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1078:1: entryRuleBITSTR : ruleBITSTR EOF ;
    public final void entryRuleBITSTR() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1079:1: ( ruleBITSTR EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1080:1: ruleBITSTR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBITSTRRule()); 
            }
            pushFollow(FOLLOW_ruleBITSTR_in_entryRuleBITSTR2244);
            ruleBITSTR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBITSTRRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITSTR2251); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1087:1: ruleBITSTR : ( ( ( ruleBINARY ) ) ( ( ruleBINARY )* ) ) ;
    public final void ruleBITSTR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1091:2: ( ( ( ( ruleBINARY ) ) ( ( ruleBINARY )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1092:1: ( ( ( ruleBINARY ) ) ( ( ruleBINARY )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1092:1: ( ( ( ruleBINARY ) ) ( ( ruleBINARY )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1093:1: ( ( ruleBINARY ) ) ( ( ruleBINARY )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1093:1: ( ( ruleBINARY ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1094:1: ( ruleBINARY )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1095:1: ( ruleBINARY )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1095:3: ruleBINARY
            {
            pushFollow(FOLLOW_ruleBINARY_in_ruleBITSTR2280);
            ruleBINARY();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            }

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1098:1: ( ( ruleBINARY )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1099:1: ( ruleBINARY )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1100:1: ( ruleBINARY )*
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
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1100:3: ruleBINARY
            	    {
            	    pushFollow(FOLLOW_ruleBINARY_in_ruleBITSTR2293);
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


    // $ANTLR start "entryRuleMIXID"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1113:1: entryRuleMIXID : ruleMIXID EOF ;
    public final void entryRuleMIXID() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1114:1: ( ruleMIXID EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1115:1: ruleMIXID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIXIDRule()); 
            }
            pushFollow(FOLLOW_ruleMIXID_in_entryRuleMIXID2323);
            ruleMIXID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIXIDRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMIXID2330); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMIXID"


    // $ANTLR start "ruleMIXID"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1122:1: ruleMIXID : ( ( rule__MIXID__Group__0 ) ) ;
    public final void ruleMIXID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1126:2: ( ( ( rule__MIXID__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1127:1: ( ( rule__MIXID__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1127:1: ( ( rule__MIXID__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1128:1: ( rule__MIXID__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIXIDAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1129:1: ( rule__MIXID__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1129:2: rule__MIXID__Group__0
            {
            pushFollow(FOLLOW_rule__MIXID__Group__0_in_ruleMIXID2356);
            rule__MIXID__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIXIDAccess().getGroup()); 
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
    // $ANTLR end "ruleMIXID"


    // $ANTLR start "entryRuleCONS"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1141:1: entryRuleCONS : ruleCONS EOF ;
    public final void entryRuleCONS() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1142:1: ( ruleCONS EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1143:1: ruleCONS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCONSRule()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS2383);
            ruleCONS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCONSRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS2390); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1150:1: ruleCONS : ( ( rule__CONS__Group__0 ) ) ;
    public final void ruleCONS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1154:2: ( ( ( rule__CONS__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1155:1: ( ( rule__CONS__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1155:1: ( ( rule__CONS__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1156:1: ( rule__CONS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCONSAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1157:1: ( rule__CONS__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1157:2: rule__CONS__Group__0
            {
            pushFollow(FOLLOW_rule__CONS__Group__0_in_ruleCONS2416);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1169:1: entryRuleID : ruleID EOF ;
    public final void entryRuleID() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1170:1: ( ruleID EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1171:1: ruleID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDRule()); 
            }
            pushFollow(FOLLOW_ruleID_in_entryRuleID2443);
            ruleID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleID2450); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1178:1: ruleID : ( ( rule__ID__Group__0 ) ) ;
    public final void ruleID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1182:2: ( ( ( rule__ID__Group__0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1183:1: ( ( rule__ID__Group__0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1183:1: ( ( rule__ID__Group__0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1184:1: ( rule__ID__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getGroup()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1185:1: ( rule__ID__Group__0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1185:2: rule__ID__Group__0
            {
            pushFollow(FOLLOW_rule__ID__Group__0_in_ruleID2476);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1197:1: entryRuleHEXDIGIT : ruleHEXDIGIT EOF ;
    public final void entryRuleHEXDIGIT() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1198:1: ( ruleHEXDIGIT EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1199:1: ruleHEXDIGIT EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXDIGITRule()); 
            }
            pushFollow(FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT2503);
            ruleHEXDIGIT();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXDIGITRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXDIGIT2510); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1206:1: ruleHEXDIGIT : ( ( rule__HEXDIGIT__Alternatives ) ) ;
    public final void ruleHEXDIGIT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1210:2: ( ( ( rule__HEXDIGIT__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1211:1: ( ( rule__HEXDIGIT__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1211:1: ( ( rule__HEXDIGIT__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1212:1: ( rule__HEXDIGIT__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXDIGITAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1213:1: ( rule__HEXDIGIT__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1213:2: rule__HEXDIGIT__Alternatives
            {
            pushFollow(FOLLOW_rule__HEXDIGIT__Alternatives_in_ruleHEXDIGIT2536);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1225:1: entryRuleHEXCHAR : ruleHEXCHAR EOF ;
    public final void entryRuleHEXCHAR() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1226:1: ( ruleHEXCHAR EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1227:1: ruleHEXCHAR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXCHARRule()); 
            }
            pushFollow(FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR2563);
            ruleHEXCHAR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXCHARRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXCHAR2570); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1234:1: ruleHEXCHAR : ( ( rule__HEXCHAR__Alternatives ) ) ;
    public final void ruleHEXCHAR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1238:2: ( ( ( rule__HEXCHAR__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1239:1: ( ( rule__HEXCHAR__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1239:1: ( ( rule__HEXCHAR__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1240:1: ( rule__HEXCHAR__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXCHARAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1241:1: ( rule__HEXCHAR__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1241:2: rule__HEXCHAR__Alternatives
            {
            pushFollow(FOLLOW_rule__HEXCHAR__Alternatives_in_ruleHEXCHAR2596);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1253:1: entryRuleULETTER : ruleULETTER EOF ;
    public final void entryRuleULETTER() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1254:1: ( ruleULETTER EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1255:1: ruleULETTER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getULETTERRule()); 
            }
            pushFollow(FOLLOW_ruleULETTER_in_entryRuleULETTER2623);
            ruleULETTER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getULETTERRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleULETTER2630); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1262:1: ruleULETTER : ( ( rule__ULETTER__Alternatives ) ) ;
    public final void ruleULETTER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1266:2: ( ( ( rule__ULETTER__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1267:1: ( ( rule__ULETTER__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1267:1: ( ( rule__ULETTER__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1268:1: ( rule__ULETTER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getULETTERAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1269:1: ( rule__ULETTER__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1269:2: rule__ULETTER__Alternatives
            {
            pushFollow(FOLLOW_rule__ULETTER__Alternatives_in_ruleULETTER2656);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1281:1: entryRuleLETTER : ruleLETTER EOF ;
    public final void entryRuleLETTER() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1282:1: ( ruleLETTER EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1283:1: ruleLETTER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLETTERRule()); 
            }
            pushFollow(FOLLOW_ruleLETTER_in_entryRuleLETTER2683);
            ruleLETTER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLETTERRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLETTER2690); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1290:1: ruleLETTER : ( ( rule__LETTER__Alternatives ) ) ;
    public final void ruleLETTER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1294:2: ( ( ( rule__LETTER__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1295:1: ( ( rule__LETTER__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1295:1: ( ( rule__LETTER__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1296:1: ( rule__LETTER__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLETTERAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1297:1: ( rule__LETTER__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1297:2: rule__LETTER__Alternatives
            {
            pushFollow(FOLLOW_rule__LETTER__Alternatives_in_ruleLETTER2716);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1309:1: entryRuleIDCHAR : ruleIDCHAR EOF ;
    public final void entryRuleIDCHAR() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1310:1: ( ruleIDCHAR EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1311:1: ruleIDCHAR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDCHARRule()); 
            }
            pushFollow(FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR2743);
            ruleIDCHAR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIDCHARRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDCHAR2750); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1318:1: ruleIDCHAR : ( ( rule__IDCHAR__Alternatives ) ) ;
    public final void ruleIDCHAR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1322:2: ( ( ( rule__IDCHAR__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1323:1: ( ( rule__IDCHAR__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1323:1: ( ( rule__IDCHAR__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1324:1: ( rule__IDCHAR__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDCHARAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1325:1: ( rule__IDCHAR__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1325:2: rule__IDCHAR__Alternatives
            {
            pushFollow(FOLLOW_rule__IDCHAR__Alternatives_in_ruleIDCHAR2776);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1337:1: entryRuleBINARY : ruleBINARY EOF ;
    public final void entryRuleBINARY() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1338:1: ( ruleBINARY EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1339:1: ruleBINARY EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBINARYRule()); 
            }
            pushFollow(FOLLOW_ruleBINARY_in_entryRuleBINARY2803);
            ruleBINARY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBINARYRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBINARY2810); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1346:1: ruleBINARY : ( ( rule__BINARY__Alternatives ) ) ;
    public final void ruleBINARY() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1350:2: ( ( ( rule__BINARY__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1351:1: ( ( rule__BINARY__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1351:1: ( ( rule__BINARY__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1352:1: ( rule__BINARY__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBINARYAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1353:1: ( rule__BINARY__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1353:2: rule__BINARY__Alternatives
            {
            pushFollow(FOLLOW_rule__BINARY__Alternatives_in_ruleBINARY2836);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1365:1: entryRuleDIG : ruleDIG EOF ;
    public final void entryRuleDIG() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1366:1: ( ruleDIG EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1367:1: ruleDIG EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDIGRule()); 
            }
            pushFollow(FOLLOW_ruleDIG_in_entryRuleDIG2863);
            ruleDIG();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDIGRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDIG2870); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1374:1: ruleDIG : ( ( rule__DIG__Alternatives ) ) ;
    public final void ruleDIG() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1378:2: ( ( ( rule__DIG__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1379:1: ( ( rule__DIG__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1379:1: ( ( rule__DIG__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1380:1: ( rule__DIG__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDIGAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1381:1: ( rule__DIG__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1381:2: rule__DIG__Alternatives
            {
            pushFollow(FOLLOW_rule__DIG__Alternatives_in_ruleDIG2896);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1393:1: entryRuleSYM : ruleSYM EOF ;
    public final void entryRuleSYM() throws RecognitionException {
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1394:1: ( ruleSYM EOF )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1395:1: ruleSYM EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSYMRule()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_entryRuleSYM2923);
            ruleSYM();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSYMRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSYM2930); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1402:1: ruleSYM : ( ( rule__SYM__Alternatives ) ) ;
    public final void ruleSYM() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1406:2: ( ( ( rule__SYM__Alternatives ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1407:1: ( ( rule__SYM__Alternatives ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1407:1: ( ( rule__SYM__Alternatives ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1408:1: ( rule__SYM__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSYMAccess().getAlternatives()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1409:1: ( rule__SYM__Alternatives )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1409:2: rule__SYM__Alternatives
            {
            pushFollow(FOLLOW_rule__SYM__Alternatives_in_ruleSYM2956);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1421:1: rule__Decl__Alternatives : ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) );
    public final void rule__Decl__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1425:1: ( ( ruleDeclGranularity ) | ( ruleDeclExport ) | ( ruleDeclType ) | ( ruleDeclVal ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt3=1;
                }
                break;
            case 45:
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1426:1: ( ruleDeclGranularity )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1426:1: ( ruleDeclGranularity )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1427:1: ruleDeclGranularity
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives2992);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1432:6: ( ruleDeclExport )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1432:6: ( ruleDeclExport )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1433:1: ruleDeclExport
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives3009);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1438:6: ( ruleDeclType )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1438:6: ( ruleDeclType )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1439:1: ruleDeclType
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleDeclType_in_rule__Decl__Alternatives3026);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1444:6: ( ruleDeclVal )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1444:6: ( ruleDeclVal )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1445:1: ruleDeclVal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives3043);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1455:1: rule__DeclType__Alternatives_2 : ( ( ( rule__DeclType__Alternatives_2_0 ) ) | ( ( rule__DeclType__Group_2_1__0 ) ) );
    public final void rule__DeclType__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1459:1: ( ( ( rule__DeclType__Alternatives_2_0 ) ) | ( ( rule__DeclType__Group_2_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_LHEXCHAR && LA4_0<=RULE_SLASH)||LA4_0==RULE_BINDIG||(LA4_0>=RULE_PIPE && LA4_0<=RULE_NBINDIG)||LA4_0==21||LA4_0==27||(LA4_0>=42 && LA4_0<=43)) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1460:1: ( ( rule__DeclType__Alternatives_2_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1460:1: ( ( rule__DeclType__Alternatives_2_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1461:1: ( rule__DeclType__Alternatives_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclTypeAccess().getAlternatives_2_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1462:1: ( rule__DeclType__Alternatives_2_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1462:2: rule__DeclType__Alternatives_2_0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Alternatives_2_0_in_rule__DeclType__Alternatives_23075);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1466:6: ( ( rule__DeclType__Group_2_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1466:6: ( ( rule__DeclType__Group_2_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1467:1: ( rule__DeclType__Group_2_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclTypeAccess().getGroup_2_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1468:1: ( rule__DeclType__Group_2_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1468:2: rule__DeclType__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Group_2_1__0_in_rule__DeclType__Alternatives_23093);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1477:1: rule__DeclType__Alternatives_2_0 : ( ( ( rule__DeclType__Group_2_0_0__0 ) ) | ( ( rule__DeclType__ValueAssignment_2_0_1 ) ) );
    public final void rule__DeclType__Alternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1481:1: ( ( ( rule__DeclType__Group_2_0_0__0 ) ) | ( ( rule__DeclType__ValueAssignment_2_0_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_LHEXCHAR && LA5_0<=RULE_SLASH)||LA5_0==RULE_BINDIG||(LA5_0>=RULE_PIPE && LA5_0<=RULE_NBINDIG)||LA5_0==27||(LA5_0>=42 && LA5_0<=43)) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1482:1: ( ( rule__DeclType__Group_2_0_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1482:1: ( ( rule__DeclType__Group_2_0_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1483:1: ( rule__DeclType__Group_2_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclTypeAccess().getGroup_2_0_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1484:1: ( rule__DeclType__Group_2_0_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1484:2: rule__DeclType__Group_2_0_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclType__Group_2_0_0__0_in_rule__DeclType__Alternatives_2_03126);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1488:6: ( ( rule__DeclType__ValueAssignment_2_0_1 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1488:6: ( ( rule__DeclType__ValueAssignment_2_0_1 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1489:1: ( rule__DeclType__ValueAssignment_2_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclTypeAccess().getValueAssignment_2_0_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1490:1: ( rule__DeclType__ValueAssignment_2_0_1 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1490:2: rule__DeclType__ValueAssignment_2_0_1
                    {
                    pushFollow(FOLLOW_rule__DeclType__ValueAssignment_2_0_1_in_rule__DeclType__Alternatives_2_03144);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1499:1: rule__DeclVal__Alternatives : ( ( ( rule__DeclVal__Group_0__0 ) ) | ( ( rule__DeclVal__Group_1__0 ) ) );
    public final void rule__DeclVal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1503:1: ( ( ( rule__DeclVal__Group_0__0 ) ) | ( ( rule__DeclVal__Group_1__0 ) ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1504:1: ( ( rule__DeclVal__Group_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1504:1: ( ( rule__DeclVal__Group_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1505:1: ( rule__DeclVal__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1506:1: ( rule__DeclVal__Group_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1506:2: rule__DeclVal__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_0__0_in_rule__DeclVal__Alternatives3177);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1510:6: ( ( rule__DeclVal__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1510:6: ( ( rule__DeclVal__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1511:1: ( rule__DeclVal__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1512:1: ( rule__DeclVal__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1512:2: rule__DeclVal__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1__0_in_rule__DeclVal__Alternatives3195);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1521:1: rule__DeclVal__Alternatives_0_1 : ( ( ( rule__DeclVal__NameAssignment_0_1_0 ) ) | ( ( rule__DeclVal__NameAssignment_0_1_1 ) ) );
    public final void rule__DeclVal__Alternatives_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1525:1: ( ( ( rule__DeclVal__NameAssignment_0_1_0 ) ) | ( ( rule__DeclVal__NameAssignment_0_1_1 ) ) )
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1526:1: ( ( rule__DeclVal__NameAssignment_0_1_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1526:1: ( ( rule__DeclVal__NameAssignment_0_1_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1527:1: ( rule__DeclVal__NameAssignment_0_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getNameAssignment_0_1_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1528:1: ( rule__DeclVal__NameAssignment_0_1_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1528:2: rule__DeclVal__NameAssignment_0_1_0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__NameAssignment_0_1_0_in_rule__DeclVal__Alternatives_0_13228);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1532:6: ( ( rule__DeclVal__NameAssignment_0_1_1 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1532:6: ( ( rule__DeclVal__NameAssignment_0_1_1 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1533:1: ( rule__DeclVal__NameAssignment_0_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getNameAssignment_0_1_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1534:1: ( rule__DeclVal__NameAssignment_0_1_1 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1534:2: rule__DeclVal__NameAssignment_0_1_1
                    {
                    pushFollow(FOLLOW_rule__DeclVal__NameAssignment_0_1_1_in_rule__DeclVal__Alternatives_0_13246);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1543:1: rule__DeclVal__Alternatives_1_5 : ( ( ( rule__DeclVal__Group_1_5_0__0 ) ) | ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) ) );
    public final void rule__DeclVal__Alternatives_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1547:1: ( ( ( rule__DeclVal__Group_1_5_0__0 ) ) | ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) ) )
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1548:1: ( ( rule__DeclVal__Group_1_5_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1548:1: ( ( rule__DeclVal__Group_1_5_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1549:1: ( rule__DeclVal__Group_1_5_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_1_5_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1550:1: ( rule__DeclVal__Group_1_5_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1550:2: rule__DeclVal__Group_1_5_0__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__0_in_rule__DeclVal__Alternatives_1_53279);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1554:6: ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1554:6: ( ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1555:1: ( ( rule__DeclVal__Group_1_5_1__0 ) ) ( ( rule__DeclVal__Group_1_5_1__0 )* )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1555:1: ( ( rule__DeclVal__Group_1_5_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1556:1: ( rule__DeclVal__Group_1_5_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1557:1: ( rule__DeclVal__Group_1_5_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1557:2: rule__DeclVal__Group_1_5_1__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_53299);
                    rule__DeclVal__Group_1_5_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 
                    }

                    }

                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1560:1: ( ( rule__DeclVal__Group_1_5_1__0 )* )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1561:1: ( rule__DeclVal__Group_1_5_1__0 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDeclValAccess().getGroup_1_5_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1562:1: ( rule__DeclVal__Group_1_5_1__0 )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_PIPE) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1562:2: rule__DeclVal__Group_1_5_1__0
                    	    {
                    	    pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_53311);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1572:1: rule__Ty__Alternatives : ( ( ( rule__Ty__ValueAssignment_0 ) ) | ( ( rule__Ty__Group_1__0 ) ) | ( ( rule__Ty__Group_2__0 ) ) | ( ( rule__Ty__Group_3__0 ) ) );
    public final void rule__Ty__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1576:1: ( ( ( rule__Ty__ValueAssignment_0 ) ) | ( ( rule__Ty__Group_1__0 ) ) | ( ( rule__Ty__Group_2__0 ) ) | ( ( rule__Ty__Group_3__0 ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_BINDIG:
            case RULE_NBINDIG:
            case 42:
            case 43:
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1577:1: ( ( rule__Ty__ValueAssignment_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1577:1: ( ( rule__Ty__ValueAssignment_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1578:1: ( rule__Ty__ValueAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTyAccess().getValueAssignment_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1579:1: ( rule__Ty__ValueAssignment_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1579:2: rule__Ty__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Ty__ValueAssignment_0_in_rule__Ty__Alternatives3347);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1583:6: ( ( rule__Ty__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1583:6: ( ( rule__Ty__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1584:1: ( rule__Ty__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTyAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1585:1: ( rule__Ty__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1585:2: rule__Ty__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_1__0_in_rule__Ty__Alternatives3365);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1589:6: ( ( rule__Ty__Group_2__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1589:6: ( ( rule__Ty__Group_2__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1590:1: ( rule__Ty__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTyAccess().getGroup_2()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1591:1: ( rule__Ty__Group_2__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1591:2: rule__Ty__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_2__0_in_rule__Ty__Alternatives3383);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1595:6: ( ( rule__Ty__Group_3__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1595:6: ( ( rule__Ty__Group_3__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1596:1: ( rule__Ty__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTyAccess().getGroup_3()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1597:1: ( rule__Ty__Group_3__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1597:2: rule__Ty__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_3__0_in_rule__Ty__Alternatives3401);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1606:1: rule__DecodePat__Alternatives : ( ( ruleBitPat ) | ( ruleTokPat ) );
    public final void rule__DecodePat__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1610:1: ( ( ruleBitPat ) | ( ruleTokPat ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=RULE_LHEXCHAR && LA11_0<=RULE_SLASH)||LA11_0==RULE_BINDIG||LA11_0==RULE_NBINDIG||(LA11_0>=42 && LA11_0<=43)) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1611:1: ( ruleBitPat )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1611:1: ( ruleBitPat )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1612:1: ruleBitPat
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecodePatAccess().getBitPatParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleBitPat_in_rule__DecodePat__Alternatives3434);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1617:6: ( ruleTokPat )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1617:6: ( ruleTokPat )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1618:1: ruleTokPat
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDecodePatAccess().getTokPatParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleTokPat_in_rule__DecodePat__Alternatives3451);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1628:1: rule__TokPat__TokPatAlternatives_0 : ( ( ruleInt ) | ( ruleQid ) );
    public final void rule__TokPat__TokPatAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1632:1: ( ( ruleInt ) | ( ruleQid ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_BINDIG||LA12_0==RULE_NBINDIG||(LA12_0>=42 && LA12_0<=43)) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1633:1: ( ruleInt )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1633:1: ( ruleInt )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1634:1: ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokPatAccess().getTokPatIntParserRuleCall_0_0()); 
                    }
                    pushFollow(FOLLOW_ruleInt_in_rule__TokPat__TokPatAlternatives_03483);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1639:6: ( ruleQid )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1639:6: ( ruleQid )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1640:1: ruleQid
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTokPatAccess().getTokPatQidParserRuleCall_0_1()); 
                    }
                    pushFollow(FOLLOW_ruleQid_in_rule__TokPat__TokPatAlternatives_03500);
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


    // $ANTLR start "rule__Exp__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1650:1: rule__Exp__Alternatives : ( ( ( rule__Exp__CaseExpAssignment_0 ) ) | ( ( rule__Exp__Group_1__0 ) ) );
    public final void rule__Exp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1654:1: ( ( ( rule__Exp__CaseExpAssignment_0 ) ) | ( ( rule__Exp__Group_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32||LA13_0==34||LA13_0==37||LA13_0==46) ) {
                alt13=1;
            }
            else if ( (LA13_0==19) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1655:1: ( ( rule__Exp__CaseExpAssignment_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1655:1: ( ( rule__Exp__CaseExpAssignment_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1656:1: ( rule__Exp__CaseExpAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getExpAccess().getCaseExpAssignment_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1657:1: ( rule__Exp__CaseExpAssignment_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1657:2: rule__Exp__CaseExpAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Exp__CaseExpAssignment_0_in_rule__Exp__Alternatives3532);
                    rule__Exp__CaseExpAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getExpAccess().getCaseExpAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1661:6: ( ( rule__Exp__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1661:6: ( ( rule__Exp__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1662:1: ( rule__Exp__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getExpAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1663:1: ( rule__Exp__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1663:2: rule__Exp__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Exp__Group_1__0_in_rule__Exp__Alternatives3550);
                    rule__Exp__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getExpAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Exp__Alternatives"


    // $ANTLR start "rule__CaseExp__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1672:1: rule__CaseExp__Alternatives : ( ( ruleClosedExp ) | ( ( rule__CaseExp__Group_1__0 ) ) );
    public final void rule__CaseExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1676:1: ( ( ruleClosedExp ) | ( ( rule__CaseExp__Group_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==34||LA14_0==37||LA14_0==46) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1677:1: ( ruleClosedExp )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1677:1: ( ruleClosedExp )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1678:1: ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCaseExpAccess().getClosedExpParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_rule__CaseExp__Alternatives3583);
                    ruleClosedExp();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCaseExpAccess().getClosedExpParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1683:6: ( ( rule__CaseExp__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1683:6: ( ( rule__CaseExp__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1684:1: ( rule__CaseExp__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCaseExpAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1685:1: ( rule__CaseExp__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1685:2: rule__CaseExp__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__CaseExp__Group_1__0_in_rule__CaseExp__Alternatives3600);
                    rule__CaseExp__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCaseExpAccess().getGroup_1()); 
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
    // $ANTLR end "rule__CaseExp__Alternatives"


    // $ANTLR start "rule__ClosedExp__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1694:1: rule__ClosedExp__Alternatives : ( ( ruleOrElseExp ) | ( ( rule__ClosedExp__Group_1__0 ) ) | ( ( rule__ClosedExp__Group_2__0 ) ) );
    public final void rule__ClosedExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1698:1: ( ( ruleOrElseExp ) | ( ( rule__ClosedExp__Group_1__0 ) ) | ( ( rule__ClosedExp__Group_2__0 ) ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt15=1;
                }
                break;
            case 34:
                {
                alt15=2;
                }
                break;
            case 37:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1699:1: ( ruleOrElseExp )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1699:1: ( ruleOrElseExp )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1700:1: ruleOrElseExp
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClosedExpAccess().getOrElseExpParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleOrElseExp_in_rule__ClosedExp__Alternatives3633);
                    ruleOrElseExp();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClosedExpAccess().getOrElseExpParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1705:6: ( ( rule__ClosedExp__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1705:6: ( ( rule__ClosedExp__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1706:1: ( rule__ClosedExp__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClosedExpAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1707:1: ( rule__ClosedExp__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1707:2: rule__ClosedExp__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ClosedExp__Group_1__0_in_rule__ClosedExp__Alternatives3650);
                    rule__ClosedExp__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClosedExpAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1711:6: ( ( rule__ClosedExp__Group_2__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1711:6: ( ( rule__ClosedExp__Group_2__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1712:1: ( rule__ClosedExp__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClosedExpAccess().getGroup_2()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1713:1: ( rule__ClosedExp__Group_2__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1713:2: rule__ClosedExp__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ClosedExp__Group_2__0_in_rule__ClosedExp__Alternatives3668);
                    rule__ClosedExp__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClosedExpAccess().getGroup_2()); 
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
    // $ANTLR end "rule__ClosedExp__Alternatives"


    // $ANTLR start "rule__MonadicExp__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1722:1: rule__MonadicExp__Alternatives : ( ( ( rule__MonadicExp__ExpAssignment_0 ) ) | ( ( rule__MonadicExp__Group_1__0 ) ) );
    public final void rule__MonadicExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1726:1: ( ( ( rule__MonadicExp__ExpAssignment_0 ) ) | ( ( rule__MonadicExp__Group_1__0 ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==19||LA16_0==32||LA16_0==34||LA16_0==37||LA16_0==46) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=RULE_LHEXCHAR && LA16_0<=RULE_SLASH)) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1727:1: ( ( rule__MonadicExp__ExpAssignment_0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1727:1: ( ( rule__MonadicExp__ExpAssignment_0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1728:1: ( rule__MonadicExp__ExpAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMonadicExpAccess().getExpAssignment_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1729:1: ( rule__MonadicExp__ExpAssignment_0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1729:2: rule__MonadicExp__ExpAssignment_0
                    {
                    pushFollow(FOLLOW_rule__MonadicExp__ExpAssignment_0_in_rule__MonadicExp__Alternatives3701);
                    rule__MonadicExp__ExpAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMonadicExpAccess().getExpAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1733:6: ( ( rule__MonadicExp__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1733:6: ( ( rule__MonadicExp__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1734:1: ( rule__MonadicExp__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMonadicExpAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1735:1: ( rule__MonadicExp__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1735:2: rule__MonadicExp__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__MonadicExp__Group_1__0_in_rule__MonadicExp__Alternatives3719);
                    rule__MonadicExp__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMonadicExpAccess().getGroup_1()); 
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
    // $ANTLR end "rule__MonadicExp__Alternatives"


    // $ANTLR start "rule__Pat__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1744:1: rule__Pat__Alternatives : ( ( '_' ) | ( ruleLit ) | ( ( ruleName ) ) | ( ( rule__Pat__Group_3__0 ) ) );
    public final void rule__Pat__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1748:1: ( ( '_' ) | ( ruleLit ) | ( ( ruleName ) ) | ( ( rule__Pat__Group_3__0 ) ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt17=1;
                }
                break;
            case RULE_BINDIG:
            case RULE_NBINDIG:
            case 31:
            case 42:
            case 43:
                {
                alt17=2;
                }
                break;
            case RULE_LHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
                {
                alt17=3;
                }
                break;
            case RULE_UHEXCHAR:
                {
                int LA17_4 = input.LA(2);

                if ( (synpred24_InternalGDSL()) ) {
                    alt17=3;
                }
                else if ( (true) ) {
                    alt17=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_UNHEXCHAR:
                {
                int LA17_5 = input.LA(2);

                if ( (synpred24_InternalGDSL()) ) {
                    alt17=3;
                }
                else if ( (true) ) {
                    alt17=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1749:1: ( '_' )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1749:1: ( '_' )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1750:1: '_'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatAccess().get_Keyword_0()); 
                    }
                    match(input,19,FOLLOW_19_in_rule__Pat__Alternatives3753); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatAccess().get_Keyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1757:6: ( ruleLit )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1757:6: ( ruleLit )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1758:1: ruleLit
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatAccess().getLitParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleLit_in_rule__Pat__Alternatives3772);
                    ruleLit();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatAccess().getLitParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1763:6: ( ( ruleName ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1763:6: ( ( ruleName ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1764:1: ( ruleName )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatAccess().getNameParserRuleCall_2()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1765:1: ( ruleName )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1765:3: ruleName
                    {
                    pushFollow(FOLLOW_ruleName_in_rule__Pat__Alternatives3790);
                    ruleName();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatAccess().getNameParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1769:6: ( ( rule__Pat__Group_3__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1769:6: ( ( rule__Pat__Group_3__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1770:1: ( rule__Pat__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPatAccess().getGroup_3()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1771:1: ( rule__Pat__Group_3__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1771:2: rule__Pat__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Pat__Group_3__0_in_rule__Pat__Alternatives3808);
                    rule__Pat__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPatAccess().getGroup_3()); 
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
    // $ANTLR end "rule__Pat__Alternatives"


    // $ANTLR start "rule__Lit__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1780:1: rule__Lit__Alternatives : ( ( ruleInt ) | ( ( rule__Lit__Group_1__0 ) ) );
    public final void rule__Lit__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1784:1: ( ( ruleInt ) | ( ( rule__Lit__Group_1__0 ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_BINDIG||LA18_0==RULE_NBINDIG||(LA18_0>=42 && LA18_0<=43)) ) {
                alt18=1;
            }
            else if ( (LA18_0==31) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1785:1: ( ruleInt )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1785:1: ( ruleInt )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1786:1: ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLitAccess().getIntParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleInt_in_rule__Lit__Alternatives3841);
                    ruleInt();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLitAccess().getIntParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1791:6: ( ( rule__Lit__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1791:6: ( ( rule__Lit__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1792:1: ( rule__Lit__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLitAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1793:1: ( rule__Lit__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1793:2: rule__Lit__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Lit__Group_1__0_in_rule__Lit__Alternatives3858);
                    rule__Lit__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLitAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Lit__Alternatives"


    // $ANTLR start "rule__PrimBitPat__Alternatives"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1802:1: rule__PrimBitPat__Alternatives : ( ( ( ruleBITSTR ) ) | ( ( rule__PrimBitPat__Group_1__0 ) ) );
    public final void rule__PrimBitPat__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1806:1: ( ( ( ruleBITSTR ) ) | ( ( rule__PrimBitPat__Group_1__0 ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_BINDIG && LA19_0<=RULE_PIPE)) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=RULE_LHEXCHAR && LA19_0<=RULE_SLASH)) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1807:1: ( ( ruleBITSTR ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1807:1: ( ( ruleBITSTR ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1808:1: ( ruleBITSTR )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimBitPatAccess().getBITSTRParserRuleCall_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1809:1: ( ruleBITSTR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1809:3: ruleBITSTR
                    {
                    pushFollow(FOLLOW_ruleBITSTR_in_rule__PrimBitPat__Alternatives3892);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1813:6: ( ( rule__PrimBitPat__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1813:6: ( ( rule__PrimBitPat__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1814:1: ( rule__PrimBitPat__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimBitPatAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1815:1: ( rule__PrimBitPat__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1815:2: rule__PrimBitPat__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimBitPat__Group_1__0_in_rule__PrimBitPat__Alternatives3910);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1824:1: rule__BitPatOrInt__Alternatives : ( ( ( rule__BitPatOrInt__Group_0__0 ) ) | ( ( rule__BitPatOrInt__Group_1__0 ) ) );
    public final void rule__BitPatOrInt__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1828:1: ( ( ( rule__BitPatOrInt__Group_0__0 ) ) | ( ( rule__BitPatOrInt__Group_1__0 ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==30) ) {
                alt20=1;
            }
            else if ( (LA20_0==41) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1829:1: ( ( rule__BitPatOrInt__Group_0__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1829:1: ( ( rule__BitPatOrInt__Group_0__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1830:1: ( rule__BitPatOrInt__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBitPatOrIntAccess().getGroup_0()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1831:1: ( rule__BitPatOrInt__Group_0__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1831:2: rule__BitPatOrInt__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__0_in_rule__BitPatOrInt__Alternatives3943);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1835:6: ( ( rule__BitPatOrInt__Group_1__0 ) )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1835:6: ( ( rule__BitPatOrInt__Group_1__0 ) )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1836:1: ( rule__BitPatOrInt__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBitPatOrIntAccess().getGroup_1()); 
                    }
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1837:1: ( rule__BitPatOrInt__Group_1__0 )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1837:2: rule__BitPatOrInt__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__0_in_rule__BitPatOrInt__Alternatives3961);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1846:1: rule__Int__Alternatives : ( ( rulePOSINT ) | ( ruleNEGINT ) );
    public final void rule__Int__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1850:1: ( ( rulePOSINT ) | ( ruleNEGINT ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_BINDIG||LA21_0==RULE_NBINDIG||LA21_0==43) ) {
                alt21=1;
            }
            else if ( (LA21_0==42) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1851:1: ( rulePOSINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1851:1: ( rulePOSINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1852:1: rulePOSINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntAccess().getPOSINTParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_rule__Int__Alternatives3994);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1857:6: ( ruleNEGINT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1857:6: ( ruleNEGINT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1858:1: ruleNEGINT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIntAccess().getNEGINTParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleNEGINT_in_rule__Int__Alternatives4011);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1868:1: rule__POSINT__Alternatives : ( ( ruleNUM ) | ( ruleHEXNUM ) );
    public final void rule__POSINT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1872:1: ( ( ruleNUM ) | ( ruleHEXNUM ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_BINDIG||LA22_0==RULE_NBINDIG) ) {
                alt22=1;
            }
            else if ( (LA22_0==43) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1873:1: ( ruleNUM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1873:1: ( ruleNUM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1874:1: ruleNUM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPOSINTAccess().getNUMParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleNUM_in_rule__POSINT__Alternatives4043);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1879:6: ( ruleHEXNUM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1879:6: ( ruleHEXNUM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1880:1: ruleHEXNUM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPOSINTAccess().getHEXNUMParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleHEXNUM_in_rule__POSINT__Alternatives4060);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1890:1: rule__HEXDIGIT__Alternatives : ( ( ruleDIG ) | ( ruleHEXCHAR ) );
    public final void rule__HEXDIGIT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1894:1: ( ( ruleDIG ) | ( ruleHEXCHAR ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_BINDIG||LA23_0==RULE_NBINDIG) ) {
                alt23=1;
            }
            else if ( ((LA23_0>=RULE_LHEXCHAR && LA23_0<=RULE_UHEXCHAR)) ) {
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1895:1: ( ruleDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1895:1: ( ruleDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1896:1: ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getHEXDIGITAccess().getDIGParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleDIG_in_rule__HEXDIGIT__Alternatives4092);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1901:6: ( ruleHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1901:6: ( ruleHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1902:1: ruleHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getHEXDIGITAccess().getHEXCHARParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleHEXCHAR_in_rule__HEXDIGIT__Alternatives4109);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1912:1: rule__HEXCHAR__Alternatives : ( ( RULE_LHEXCHAR ) | ( RULE_UHEXCHAR ) );
    public final void rule__HEXCHAR__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1916:1: ( ( RULE_LHEXCHAR ) | ( RULE_UHEXCHAR ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_LHEXCHAR) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_UHEXCHAR) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1917:1: ( RULE_LHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1917:1: ( RULE_LHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1918:1: RULE_LHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getHEXCHARAccess().getLHEXCHARTerminalRuleCall_0()); 
                    }
                    match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_rule__HEXCHAR__Alternatives4141); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getHEXCHARAccess().getLHEXCHARTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1923:6: ( RULE_UHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1923:6: ( RULE_UHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1924:1: RULE_UHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getHEXCHARAccess().getUHEXCHARTerminalRuleCall_1()); 
                    }
                    match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_rule__HEXCHAR__Alternatives4158); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1934:1: rule__ULETTER__Alternatives : ( ( RULE_UHEXCHAR ) | ( RULE_UNHEXCHAR ) );
    public final void rule__ULETTER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1938:1: ( ( RULE_UHEXCHAR ) | ( RULE_UNHEXCHAR ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_UHEXCHAR) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_UNHEXCHAR) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1939:1: ( RULE_UHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1939:1: ( RULE_UHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1940:1: RULE_UHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getULETTERAccess().getUHEXCHARTerminalRuleCall_0()); 
                    }
                    match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_rule__ULETTER__Alternatives4190); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getULETTERAccess().getUHEXCHARTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1945:6: ( RULE_UNHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1945:6: ( RULE_UNHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1946:1: RULE_UNHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getULETTERAccess().getUNHEXCHARTerminalRuleCall_1()); 
                    }
                    match(input,RULE_UNHEXCHAR,FOLLOW_RULE_UNHEXCHAR_in_rule__ULETTER__Alternatives4207); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1956:1: rule__LETTER__Alternatives : ( ( RULE_LHEXCHAR ) | ( RULE_LNHEXCHAR ) | ( ruleULETTER ) | ( RULE_SLASH ) );
    public final void rule__LETTER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1960:1: ( ( RULE_LHEXCHAR ) | ( RULE_LNHEXCHAR ) | ( ruleULETTER ) | ( RULE_SLASH ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
                {
                alt26=1;
                }
                break;
            case RULE_LNHEXCHAR:
                {
                alt26=2;
                }
                break;
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
                {
                alt26=3;
                }
                break;
            case RULE_SLASH:
                {
                alt26=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1961:1: ( RULE_LHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1961:1: ( RULE_LHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1962:1: RULE_LHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLETTERAccess().getLHEXCHARTerminalRuleCall_0()); 
                    }
                    match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_rule__LETTER__Alternatives4239); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLETTERAccess().getLHEXCHARTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1967:6: ( RULE_LNHEXCHAR )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1967:6: ( RULE_LNHEXCHAR )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1968:1: RULE_LNHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLETTERAccess().getLNHEXCHARTerminalRuleCall_1()); 
                    }
                    match(input,RULE_LNHEXCHAR,FOLLOW_RULE_LNHEXCHAR_in_rule__LETTER__Alternatives4256); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLETTERAccess().getLNHEXCHARTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1973:6: ( ruleULETTER )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1973:6: ( ruleULETTER )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1974:1: ruleULETTER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLETTERAccess().getULETTERParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_ruleULETTER_in_rule__LETTER__Alternatives4273);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1979:6: ( RULE_SLASH )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1979:6: ( RULE_SLASH )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1980:1: RULE_SLASH
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLETTERAccess().getSLASHTerminalRuleCall_3()); 
                    }
                    match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_rule__LETTER__Alternatives4290); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1990:1: rule__IDCHAR__Alternatives : ( ( ruleLETTER ) | ( ruleDIG ) | ( RULE_CHARSYM ) );
    public final void rule__IDCHAR__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1994:1: ( ( ruleLETTER ) | ( ruleDIG ) | ( RULE_CHARSYM ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
                {
                alt27=1;
                }
                break;
            case RULE_BINDIG:
            case RULE_NBINDIG:
                {
                alt27=2;
                }
                break;
            case RULE_CHARSYM:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1995:1: ( ruleLETTER )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1995:1: ( ruleLETTER )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1996:1: ruleLETTER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDCHARAccess().getLETTERParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleLETTER_in_rule__IDCHAR__Alternatives4322);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2001:6: ( ruleDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2001:6: ( ruleDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2002:1: ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDCHARAccess().getDIGParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleDIG_in_rule__IDCHAR__Alternatives4339);
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
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2007:6: ( RULE_CHARSYM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2007:6: ( RULE_CHARSYM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2008:1: RULE_CHARSYM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIDCHARAccess().getCHARSYMTerminalRuleCall_2()); 
                    }
                    match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_rule__IDCHAR__Alternatives4356); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2018:1: rule__BINARY__Alternatives : ( ( RULE_BINDIG ) | ( RULE_BS ) | ( RULE_DOT ) | ( RULE_PIPE ) );
    public final void rule__BINARY__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2022:1: ( ( RULE_BINDIG ) | ( RULE_BS ) | ( RULE_DOT ) | ( RULE_PIPE ) )
            int alt28=4;
            switch ( input.LA(1) ) {
            case RULE_BINDIG:
                {
                alt28=1;
                }
                break;
            case RULE_BS:
                {
                alt28=2;
                }
                break;
            case RULE_DOT:
                {
                alt28=3;
                }
                break;
            case RULE_PIPE:
                {
                alt28=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2023:1: ( RULE_BINDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2023:1: ( RULE_BINDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2024:1: RULE_BINDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBINARYAccess().getBINDIGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_rule__BINARY__Alternatives4388); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBINARYAccess().getBINDIGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2029:6: ( RULE_BS )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2029:6: ( RULE_BS )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2030:1: RULE_BS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBINARYAccess().getBSTerminalRuleCall_1()); 
                    }
                    match(input,RULE_BS,FOLLOW_RULE_BS_in_rule__BINARY__Alternatives4405); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBINARYAccess().getBSTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2035:6: ( RULE_DOT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2035:6: ( RULE_DOT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2036:1: RULE_DOT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBINARYAccess().getDOTTerminalRuleCall_2()); 
                    }
                    match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rule__BINARY__Alternatives4422); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBINARYAccess().getDOTTerminalRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2041:6: ( RULE_PIPE )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2041:6: ( RULE_PIPE )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2042:1: RULE_PIPE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBINARYAccess().getPIPETerminalRuleCall_3()); 
                    }
                    match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__BINARY__Alternatives4439); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2052:1: rule__DIG__Alternatives : ( ( RULE_BINDIG ) | ( RULE_NBINDIG ) );
    public final void rule__DIG__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2056:1: ( ( RULE_BINDIG ) | ( RULE_NBINDIG ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_BINDIG) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_NBINDIG) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2057:1: ( RULE_BINDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2057:1: ( RULE_BINDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2058:1: RULE_BINDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDIGAccess().getBINDIGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_rule__DIG__Alternatives4471); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDIGAccess().getBINDIGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2063:6: ( RULE_NBINDIG )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2063:6: ( RULE_NBINDIG )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2064:1: RULE_NBINDIG
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDIGAccess().getNBINDIGTerminalRuleCall_1()); 
                    }
                    match(input,RULE_NBINDIG,FOLLOW_RULE_NBINDIG_in_rule__DIG__Alternatives4488); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2074:1: rule__SYM__Alternatives : ( ( RULE_BS ) | ( RULE_SLASH ) | ( RULE_DOT ) | ( RULE_CHARSYM ) | ( RULE_OTHERSYM ) );
    public final void rule__SYM__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2078:1: ( ( RULE_BS ) | ( RULE_SLASH ) | ( RULE_DOT ) | ( RULE_CHARSYM ) | ( RULE_OTHERSYM ) )
            int alt30=5;
            switch ( input.LA(1) ) {
            case RULE_BS:
                {
                alt30=1;
                }
                break;
            case RULE_SLASH:
                {
                alt30=2;
                }
                break;
            case RULE_DOT:
                {
                alt30=3;
                }
                break;
            case RULE_CHARSYM:
                {
                alt30=4;
                }
                break;
            case RULE_OTHERSYM:
                {
                alt30=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2079:1: ( RULE_BS )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2079:1: ( RULE_BS )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2080:1: RULE_BS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getBSTerminalRuleCall_0()); 
                    }
                    match(input,RULE_BS,FOLLOW_RULE_BS_in_rule__SYM__Alternatives4520); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSYMAccess().getBSTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2085:6: ( RULE_SLASH )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2085:6: ( RULE_SLASH )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2086:1: RULE_SLASH
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getSLASHTerminalRuleCall_1()); 
                    }
                    match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_rule__SYM__Alternatives4537); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSYMAccess().getSLASHTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2091:6: ( RULE_DOT )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2091:6: ( RULE_DOT )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2092:1: RULE_DOT
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                    }
                    match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rule__SYM__Alternatives4554); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2097:6: ( RULE_CHARSYM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2097:6: ( RULE_CHARSYM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2098:1: RULE_CHARSYM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getCHARSYMTerminalRuleCall_3()); 
                    }
                    match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_rule__SYM__Alternatives4571); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSYMAccess().getCHARSYMTerminalRuleCall_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2103:6: ( RULE_OTHERSYM )
                    {
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2103:6: ( RULE_OTHERSYM )
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2104:1: RULE_OTHERSYM
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSYMAccess().getOTHERSYMTerminalRuleCall_4()); 
                    }
                    match(input,RULE_OTHERSYM,FOLLOW_RULE_OTHERSYM_in_rule__SYM__Alternatives4588); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2116:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2120:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2121:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__04618);
            rule__Model__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__04621);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2128:1: rule__Model__Group__0__Impl : ( ( rule__Model__DeclAssignment_0 ) ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2132:1: ( ( ( rule__Model__DeclAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2133:1: ( ( rule__Model__DeclAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2133:1: ( ( rule__Model__DeclAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2134:1: ( rule__Model__DeclAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDeclAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2135:1: ( rule__Model__DeclAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2135:2: rule__Model__DeclAssignment_0
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl4648);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2145:1: rule__Model__Group__1 : rule__Model__Group__1__Impl ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2149:1: ( rule__Model__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2150:2: rule__Model__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14678);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2156:1: rule__Model__Group__1__Impl : ( ( rule__Model__Group_1__0 )* ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2160:1: ( ( ( rule__Model__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2161:1: ( ( rule__Model__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2161:1: ( ( rule__Model__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2162:1: ( rule__Model__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2163:1: ( rule__Model__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==20||LA31_0==22||LA31_0==26||(LA31_0>=44 && LA31_0<=45)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2163:2: rule__Model__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl4705);
            	    rule__Model__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2177:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2181:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2182:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__04740);
            rule__Model__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__04743);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2189:1: rule__Model__Group_1__0__Impl : ( ( ';' )? ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2193:1: ( ( ( ';' )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2194:1: ( ( ';' )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2194:1: ( ( ';' )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2195:1: ( ';' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getSemicolonKeyword_1_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2196:1: ( ';' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==20) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2197:2: ';'
                    {
                    match(input,20,FOLLOW_20_in_rule__Model__Group_1__0__Impl4772); if (state.failed) return ;

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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2208:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2212:1: ( rule__Model__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2213:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__14805);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2219:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__DeclAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2223:1: ( ( ( rule__Model__DeclAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2224:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2224:1: ( ( rule__Model__DeclAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2225:1: ( rule__Model__DeclAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDeclAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2226:1: ( rule__Model__DeclAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2226:2: rule__Model__DeclAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl4832);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2240:1: rule__DeclGranularity__Group__0 : rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 ;
    public final void rule__DeclGranularity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2244:1: ( rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2245:2: rule__DeclGranularity__Group__0__Impl rule__DeclGranularity__Group__1
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__04866);
            rule__DeclGranularity__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__04869);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2252:1: rule__DeclGranularity__Group__0__Impl : ( ( rule__DeclGranularity__NameAssignment_0 ) ) ;
    public final void rule__DeclGranularity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2256:1: ( ( ( rule__DeclGranularity__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2257:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2257:1: ( ( rule__DeclGranularity__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2258:1: ( rule__DeclGranularity__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2259:1: ( rule__DeclGranularity__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2259:2: rule__DeclGranularity__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl4896);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2269:1: rule__DeclGranularity__Group__1 : rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 ;
    public final void rule__DeclGranularity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2273:1: ( rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2274:2: rule__DeclGranularity__Group__1__Impl rule__DeclGranularity__Group__2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__14926);
            rule__DeclGranularity__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__14929);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2281:1: rule__DeclGranularity__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclGranularity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2285:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2286:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2286:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2287:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclGranularity__Group__1__Impl4957); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2300:1: rule__DeclGranularity__Group__2 : rule__DeclGranularity__Group__2__Impl ;
    public final void rule__DeclGranularity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2304:1: ( rule__DeclGranularity__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2305:2: rule__DeclGranularity__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__24988);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2311:1: rule__DeclGranularity__Group__2__Impl : ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) ;
    public final void rule__DeclGranularity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2315:1: ( ( ( rule__DeclGranularity__GranularityAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2316:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2316:1: ( ( rule__DeclGranularity__GranularityAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2317:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getGranularityAssignment_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2318:1: ( rule__DeclGranularity__GranularityAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2318:2: rule__DeclGranularity__GranularityAssignment_2
            {
            pushFollow(FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl5015);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2334:1: rule__DeclExport__Group__0 : rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 ;
    public final void rule__DeclExport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2338:1: ( rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2339:2: rule__DeclExport__Group__0__Impl rule__DeclExport__Group__1
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__05051);
            rule__DeclExport__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__05054);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2346:1: rule__DeclExport__Group__0__Impl : ( ( rule__DeclExport__NameAssignment_0 ) ) ;
    public final void rule__DeclExport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2350:1: ( ( ( rule__DeclExport__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2351:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2351:1: ( ( rule__DeclExport__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2352:1: ( rule__DeclExport__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2353:1: ( rule__DeclExport__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2353:2: rule__DeclExport__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl5081);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2363:1: rule__DeclExport__Group__1 : rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 ;
    public final void rule__DeclExport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2367:1: ( rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2368:2: rule__DeclExport__Group__1__Impl rule__DeclExport__Group__2
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__15111);
            rule__DeclExport__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__15114);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2375:1: rule__DeclExport__Group__1__Impl : ( '=' ) ;
    public final void rule__DeclExport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2379:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2380:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2380:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2381:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclExport__Group__1__Impl5142); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2394:1: rule__DeclExport__Group__2 : rule__DeclExport__Group__2__Impl ;
    public final void rule__DeclExport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2398:1: ( rule__DeclExport__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2399:2: rule__DeclExport__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__25173);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2405:1: rule__DeclExport__Group__2__Impl : ( ( rule__DeclExport__ExportsAssignment_2 )* ) ;
    public final void rule__DeclExport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2409:1: ( ( ( rule__DeclExport__ExportsAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2410:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2410:1: ( ( rule__DeclExport__ExportsAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2411:1: ( rule__DeclExport__ExportsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getExportsAssignment_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2412:1: ( rule__DeclExport__ExportsAssignment_2 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=RULE_LHEXCHAR && LA33_0<=RULE_SLASH)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2412:2: rule__DeclExport__ExportsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl5200);
            	    rule__DeclExport__ExportsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2428:1: rule__DeclType__Group__0 : rule__DeclType__Group__0__Impl rule__DeclType__Group__1 ;
    public final void rule__DeclType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2432:1: ( rule__DeclType__Group__0__Impl rule__DeclType__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2433:2: rule__DeclType__Group__0__Impl rule__DeclType__Group__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group__0__Impl_in_rule__DeclType__Group__05237);
            rule__DeclType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group__1_in_rule__DeclType__Group__05240);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2440:1: rule__DeclType__Group__0__Impl : ( 'type' ) ;
    public final void rule__DeclType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2444:1: ( ( 'type' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2445:1: ( 'type' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2445:1: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2446:1: 'type'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getTypeKeyword_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__DeclType__Group__0__Impl5268); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2459:1: rule__DeclType__Group__1 : rule__DeclType__Group__1__Impl rule__DeclType__Group__2 ;
    public final void rule__DeclType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2463:1: ( rule__DeclType__Group__1__Impl rule__DeclType__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2464:2: rule__DeclType__Group__1__Impl rule__DeclType__Group__2
            {
            pushFollow(FOLLOW_rule__DeclType__Group__1__Impl_in_rule__DeclType__Group__15299);
            rule__DeclType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group__2_in_rule__DeclType__Group__15302);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2471:1: rule__DeclType__Group__1__Impl : ( ( rule__DeclType__NameAssignment_1 ) ) ;
    public final void rule__DeclType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2475:1: ( ( ( rule__DeclType__NameAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2476:1: ( ( rule__DeclType__NameAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2476:1: ( ( rule__DeclType__NameAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2477:1: ( rule__DeclType__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getNameAssignment_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2478:1: ( rule__DeclType__NameAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2478:2: rule__DeclType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__DeclType__NameAssignment_1_in_rule__DeclType__Group__1__Impl5329);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2488:1: rule__DeclType__Group__2 : rule__DeclType__Group__2__Impl ;
    public final void rule__DeclType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2492:1: ( rule__DeclType__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2493:2: rule__DeclType__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group__2__Impl_in_rule__DeclType__Group__25359);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2499:1: rule__DeclType__Group__2__Impl : ( ( rule__DeclType__Alternatives_2 ) ) ;
    public final void rule__DeclType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2503:1: ( ( ( rule__DeclType__Alternatives_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2504:1: ( ( rule__DeclType__Alternatives_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2504:1: ( ( rule__DeclType__Alternatives_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2505:1: ( rule__DeclType__Alternatives_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAlternatives_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2506:1: ( rule__DeclType__Alternatives_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2506:2: rule__DeclType__Alternatives_2
            {
            pushFollow(FOLLOW_rule__DeclType__Alternatives_2_in_rule__DeclType__Group__2__Impl5386);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2522:1: rule__DeclType__Group_2_0_0__0 : rule__DeclType__Group_2_0_0__0__Impl rule__DeclType__Group_2_0_0__1 ;
    public final void rule__DeclType__Group_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2526:1: ( rule__DeclType__Group_2_0_0__0__Impl rule__DeclType__Group_2_0_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2527:2: rule__DeclType__Group_2_0_0__0__Impl rule__DeclType__Group_2_0_0__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_0_0__0__Impl_in_rule__DeclType__Group_2_0_0__05422);
            rule__DeclType__Group_2_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_0_0__1_in_rule__DeclType__Group_2_0_0__05425);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2534:1: rule__DeclType__Group_2_0_0__0__Impl : ( '=' ) ;
    public final void rule__DeclType__Group_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2538:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2539:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2539:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2540:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_0_0_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclType__Group_2_0_0__0__Impl5453); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2553:1: rule__DeclType__Group_2_0_0__1 : rule__DeclType__Group_2_0_0__1__Impl ;
    public final void rule__DeclType__Group_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2557:1: ( rule__DeclType__Group_2_0_0__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2558:2: rule__DeclType__Group_2_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_0_0__1__Impl_in_rule__DeclType__Group_2_0_0__15484);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2564:1: rule__DeclType__Group_2_0_0__1__Impl : ( ( rule__DeclType__ValueAssignment_2_0_0_1 ) ) ;
    public final void rule__DeclType__Group_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2568:1: ( ( ( rule__DeclType__ValueAssignment_2_0_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2569:1: ( ( rule__DeclType__ValueAssignment_2_0_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2569:1: ( ( rule__DeclType__ValueAssignment_2_0_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2570:1: ( rule__DeclType__ValueAssignment_2_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueAssignment_2_0_0_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2571:1: ( rule__DeclType__ValueAssignment_2_0_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2571:2: rule__DeclType__ValueAssignment_2_0_0_1
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAssignment_2_0_0_1_in_rule__DeclType__Group_2_0_0__1__Impl5511);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2585:1: rule__DeclType__Group_2_1__0 : rule__DeclType__Group_2_1__0__Impl rule__DeclType__Group_2_1__1 ;
    public final void rule__DeclType__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2589:1: ( rule__DeclType__Group_2_1__0__Impl rule__DeclType__Group_2_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2590:2: rule__DeclType__Group_2_1__0__Impl rule__DeclType__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__0__Impl_in_rule__DeclType__Group_2_1__05545);
            rule__DeclType__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__1_in_rule__DeclType__Group_2_1__05548);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2597:1: rule__DeclType__Group_2_1__0__Impl : ( '[' ) ;
    public final void rule__DeclType__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2601:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2602:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2602:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2603:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getLeftSquareBracketKeyword_2_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__DeclType__Group_2_1__0__Impl5576); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2616:1: rule__DeclType__Group_2_1__1 : rule__DeclType__Group_2_1__1__Impl rule__DeclType__Group_2_1__2 ;
    public final void rule__DeclType__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2620:1: ( rule__DeclType__Group_2_1__1__Impl rule__DeclType__Group_2_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2621:2: rule__DeclType__Group_2_1__1__Impl rule__DeclType__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__1__Impl_in_rule__DeclType__Group_2_1__15607);
            rule__DeclType__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__2_in_rule__DeclType__Group_2_1__15610);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2628:1: rule__DeclType__Group_2_1__1__Impl : ( ( rule__DeclType__AttrNameAssignment_2_1_1 ) ) ;
    public final void rule__DeclType__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2632:1: ( ( ( rule__DeclType__AttrNameAssignment_2_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2633:1: ( ( rule__DeclType__AttrNameAssignment_2_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2633:1: ( ( rule__DeclType__AttrNameAssignment_2_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2634:1: ( rule__DeclType__AttrNameAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_2_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2635:1: ( rule__DeclType__AttrNameAssignment_2_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2635:2: rule__DeclType__AttrNameAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__DeclType__AttrNameAssignment_2_1_1_in_rule__DeclType__Group_2_1__1__Impl5637);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2645:1: rule__DeclType__Group_2_1__2 : rule__DeclType__Group_2_1__2__Impl rule__DeclType__Group_2_1__3 ;
    public final void rule__DeclType__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2649:1: ( rule__DeclType__Group_2_1__2__Impl rule__DeclType__Group_2_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2650:2: rule__DeclType__Group_2_1__2__Impl rule__DeclType__Group_2_1__3
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__2__Impl_in_rule__DeclType__Group_2_1__25667);
            rule__DeclType__Group_2_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__3_in_rule__DeclType__Group_2_1__25670);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2657:1: rule__DeclType__Group_2_1__2__Impl : ( ( rule__DeclType__Group_2_1_2__0 )* ) ;
    public final void rule__DeclType__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2661:1: ( ( ( rule__DeclType__Group_2_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2662:1: ( ( rule__DeclType__Group_2_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2662:1: ( ( rule__DeclType__Group_2_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2663:1: ( rule__DeclType__Group_2_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getGroup_2_1_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2664:1: ( rule__DeclType__Group_2_1_2__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==25) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2664:2: rule__DeclType__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__DeclType__Group_2_1_2__0_in_rule__DeclType__Group_2_1__2__Impl5697);
            	    rule__DeclType__Group_2_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2674:1: rule__DeclType__Group_2_1__3 : rule__DeclType__Group_2_1__3__Impl rule__DeclType__Group_2_1__4 ;
    public final void rule__DeclType__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2678:1: ( rule__DeclType__Group_2_1__3__Impl rule__DeclType__Group_2_1__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2679:2: rule__DeclType__Group_2_1__3__Impl rule__DeclType__Group_2_1__4
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__3__Impl_in_rule__DeclType__Group_2_1__35728);
            rule__DeclType__Group_2_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__4_in_rule__DeclType__Group_2_1__35731);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2686:1: rule__DeclType__Group_2_1__3__Impl : ( ']' ) ;
    public final void rule__DeclType__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2690:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2691:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2691:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2692:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getRightSquareBracketKeyword_2_1_3()); 
            }
            match(input,24,FOLLOW_24_in_rule__DeclType__Group_2_1__3__Impl5759); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2705:1: rule__DeclType__Group_2_1__4 : rule__DeclType__Group_2_1__4__Impl rule__DeclType__Group_2_1__5 ;
    public final void rule__DeclType__Group_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2709:1: ( rule__DeclType__Group_2_1__4__Impl rule__DeclType__Group_2_1__5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2710:2: rule__DeclType__Group_2_1__4__Impl rule__DeclType__Group_2_1__5
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__4__Impl_in_rule__DeclType__Group_2_1__45790);
            rule__DeclType__Group_2_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__5_in_rule__DeclType__Group_2_1__45793);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2717:1: rule__DeclType__Group_2_1__4__Impl : ( '=' ) ;
    public final void rule__DeclType__Group_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2721:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2722:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2722:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2723:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_1_4()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclType__Group_2_1__4__Impl5821); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2736:1: rule__DeclType__Group_2_1__5 : rule__DeclType__Group_2_1__5__Impl ;
    public final void rule__DeclType__Group_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2740:1: ( rule__DeclType__Group_2_1__5__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2741:2: rule__DeclType__Group_2_1__5__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1__5__Impl_in_rule__DeclType__Group_2_1__55852);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2747:1: rule__DeclType__Group_2_1__5__Impl : ( ( rule__DeclType__ValueAssignment_2_1_5 ) ) ;
    public final void rule__DeclType__Group_2_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2751:1: ( ( ( rule__DeclType__ValueAssignment_2_1_5 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2752:1: ( ( rule__DeclType__ValueAssignment_2_1_5 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2752:1: ( ( rule__DeclType__ValueAssignment_2_1_5 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2753:1: ( rule__DeclType__ValueAssignment_2_1_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueAssignment_2_1_5()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2754:1: ( rule__DeclType__ValueAssignment_2_1_5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2754:2: rule__DeclType__ValueAssignment_2_1_5
            {
            pushFollow(FOLLOW_rule__DeclType__ValueAssignment_2_1_5_in_rule__DeclType__Group_2_1__5__Impl5879);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2776:1: rule__DeclType__Group_2_1_2__0 : rule__DeclType__Group_2_1_2__0__Impl rule__DeclType__Group_2_1_2__1 ;
    public final void rule__DeclType__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2780:1: ( rule__DeclType__Group_2_1_2__0__Impl rule__DeclType__Group_2_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2781:2: rule__DeclType__Group_2_1_2__0__Impl rule__DeclType__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1_2__0__Impl_in_rule__DeclType__Group_2_1_2__05921);
            rule__DeclType__Group_2_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclType__Group_2_1_2__1_in_rule__DeclType__Group_2_1_2__05924);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2788:1: rule__DeclType__Group_2_1_2__0__Impl : ( ',' ) ;
    public final void rule__DeclType__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2792:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2793:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2793:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2794:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getCommaKeyword_2_1_2_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__DeclType__Group_2_1_2__0__Impl5952); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2807:1: rule__DeclType__Group_2_1_2__1 : rule__DeclType__Group_2_1_2__1__Impl ;
    public final void rule__DeclType__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2811:1: ( rule__DeclType__Group_2_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2812:2: rule__DeclType__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclType__Group_2_1_2__1__Impl_in_rule__DeclType__Group_2_1_2__15983);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2818:1: rule__DeclType__Group_2_1_2__1__Impl : ( ( rule__DeclType__AttrNameAssignment_2_1_2_1 ) ) ;
    public final void rule__DeclType__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2822:1: ( ( ( rule__DeclType__AttrNameAssignment_2_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2823:1: ( ( rule__DeclType__AttrNameAssignment_2_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2823:1: ( ( rule__DeclType__AttrNameAssignment_2_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2824:1: ( rule__DeclType__AttrNameAssignment_2_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAttrNameAssignment_2_1_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2825:1: ( rule__DeclType__AttrNameAssignment_2_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2825:2: rule__DeclType__AttrNameAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__DeclType__AttrNameAssignment_2_1_2_1_in_rule__DeclType__Group_2_1_2__1__Impl6010);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2839:1: rule__DeclVal__Group_0__0 : rule__DeclVal__Group_0__0__Impl rule__DeclVal__Group_0__1 ;
    public final void rule__DeclVal__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2843:1: ( rule__DeclVal__Group_0__0__Impl rule__DeclVal__Group_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2844:2: rule__DeclVal__Group_0__0__Impl rule__DeclVal__Group_0__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__0__Impl_in_rule__DeclVal__Group_0__06044);
            rule__DeclVal__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_0__1_in_rule__DeclVal__Group_0__06047);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2851:1: rule__DeclVal__Group_0__0__Impl : ( 'val' ) ;
    public final void rule__DeclVal__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2855:1: ( ( 'val' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2856:1: ( 'val' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2856:1: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2857:1: 'val'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getValKeyword_0_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__DeclVal__Group_0__0__Impl6075); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2870:1: rule__DeclVal__Group_0__1 : rule__DeclVal__Group_0__1__Impl rule__DeclVal__Group_0__2 ;
    public final void rule__DeclVal__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2874:1: ( rule__DeclVal__Group_0__1__Impl rule__DeclVal__Group_0__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2875:2: rule__DeclVal__Group_0__1__Impl rule__DeclVal__Group_0__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__1__Impl_in_rule__DeclVal__Group_0__16106);
            rule__DeclVal__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_0__2_in_rule__DeclVal__Group_0__16109);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2882:1: rule__DeclVal__Group_0__1__Impl : ( ( rule__DeclVal__Alternatives_0_1 ) ) ;
    public final void rule__DeclVal__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2886:1: ( ( ( rule__DeclVal__Alternatives_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2887:1: ( ( rule__DeclVal__Alternatives_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2887:1: ( ( rule__DeclVal__Alternatives_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2888:1: ( rule__DeclVal__Alternatives_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getAlternatives_0_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2889:1: ( rule__DeclVal__Alternatives_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2889:2: rule__DeclVal__Alternatives_0_1
            {
            pushFollow(FOLLOW_rule__DeclVal__Alternatives_0_1_in_rule__DeclVal__Group_0__1__Impl6136);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2899:1: rule__DeclVal__Group_0__2 : rule__DeclVal__Group_0__2__Impl rule__DeclVal__Group_0__3 ;
    public final void rule__DeclVal__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2903:1: ( rule__DeclVal__Group_0__2__Impl rule__DeclVal__Group_0__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2904:2: rule__DeclVal__Group_0__2__Impl rule__DeclVal__Group_0__3
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__2__Impl_in_rule__DeclVal__Group_0__26166);
            rule__DeclVal__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_0__3_in_rule__DeclVal__Group_0__26169);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2911:1: rule__DeclVal__Group_0__2__Impl : ( ( rule__DeclVal__AttrAssignment_0_2 )* ) ;
    public final void rule__DeclVal__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2915:1: ( ( ( rule__DeclVal__AttrAssignment_0_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2916:1: ( ( rule__DeclVal__AttrAssignment_0_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2916:1: ( ( rule__DeclVal__AttrAssignment_0_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2917:1: ( rule__DeclVal__AttrAssignment_0_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getAttrAssignment_0_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2918:1: ( rule__DeclVal__AttrAssignment_0_2 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_LHEXCHAR && LA35_0<=RULE_SLASH)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2918:2: rule__DeclVal__AttrAssignment_0_2
            	    {
            	    pushFollow(FOLLOW_rule__DeclVal__AttrAssignment_0_2_in_rule__DeclVal__Group_0__2__Impl6196);
            	    rule__DeclVal__AttrAssignment_0_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2928:1: rule__DeclVal__Group_0__3 : rule__DeclVal__Group_0__3__Impl rule__DeclVal__Group_0__4 ;
    public final void rule__DeclVal__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2932:1: ( rule__DeclVal__Group_0__3__Impl rule__DeclVal__Group_0__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2933:2: rule__DeclVal__Group_0__3__Impl rule__DeclVal__Group_0__4
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__3__Impl_in_rule__DeclVal__Group_0__36227);
            rule__DeclVal__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_0__4_in_rule__DeclVal__Group_0__36230);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2940:1: rule__DeclVal__Group_0__3__Impl : ( '=' ) ;
    public final void rule__DeclVal__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2944:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2945:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2945:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2946:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getEqualsSignKeyword_0_3()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclVal__Group_0__3__Impl6258); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2959:1: rule__DeclVal__Group_0__4 : rule__DeclVal__Group_0__4__Impl ;
    public final void rule__DeclVal__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2963:1: ( rule__DeclVal__Group_0__4__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2964:2: rule__DeclVal__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_0__4__Impl_in_rule__DeclVal__Group_0__46289);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2970:1: rule__DeclVal__Group_0__4__Impl : ( ( rule__DeclVal__ExpAssignment_0_4 ) ) ;
    public final void rule__DeclVal__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2974:1: ( ( ( rule__DeclVal__ExpAssignment_0_4 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2975:1: ( ( rule__DeclVal__ExpAssignment_0_4 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2975:1: ( ( rule__DeclVal__ExpAssignment_0_4 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2976:1: ( rule__DeclVal__ExpAssignment_0_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpAssignment_0_4()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2977:1: ( rule__DeclVal__ExpAssignment_0_4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2977:2: rule__DeclVal__ExpAssignment_0_4
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpAssignment_0_4_in_rule__DeclVal__Group_0__4__Impl6316);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:2997:1: rule__DeclVal__Group_1__0 : rule__DeclVal__Group_1__0__Impl rule__DeclVal__Group_1__1 ;
    public final void rule__DeclVal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3001:1: ( rule__DeclVal__Group_1__0__Impl rule__DeclVal__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3002:2: rule__DeclVal__Group_1__0__Impl rule__DeclVal__Group_1__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__0__Impl_in_rule__DeclVal__Group_1__06356);
            rule__DeclVal__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__1_in_rule__DeclVal__Group_1__06359);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3009:1: rule__DeclVal__Group_1__0__Impl : ( 'val' ) ;
    public final void rule__DeclVal__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3013:1: ( ( 'val' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3014:1: ( 'val' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3014:1: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3015:1: 'val'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getValKeyword_1_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__DeclVal__Group_1__0__Impl6387); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3028:1: rule__DeclVal__Group_1__1 : rule__DeclVal__Group_1__1__Impl rule__DeclVal__Group_1__2 ;
    public final void rule__DeclVal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3032:1: ( rule__DeclVal__Group_1__1__Impl rule__DeclVal__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3033:2: rule__DeclVal__Group_1__1__Impl rule__DeclVal__Group_1__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__1__Impl_in_rule__DeclVal__Group_1__16418);
            rule__DeclVal__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__2_in_rule__DeclVal__Group_1__16421);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3040:1: rule__DeclVal__Group_1__1__Impl : ( ( rule__DeclVal__NameAssignment_1_1 ) ) ;
    public final void rule__DeclVal__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3044:1: ( ( ( rule__DeclVal__NameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3045:1: ( ( rule__DeclVal__NameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3045:1: ( ( rule__DeclVal__NameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3046:1: ( rule__DeclVal__NameAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getNameAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3047:1: ( rule__DeclVal__NameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3047:2: rule__DeclVal__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__DeclVal__NameAssignment_1_1_in_rule__DeclVal__Group_1__1__Impl6448);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3057:1: rule__DeclVal__Group_1__2 : rule__DeclVal__Group_1__2__Impl rule__DeclVal__Group_1__3 ;
    public final void rule__DeclVal__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3061:1: ( rule__DeclVal__Group_1__2__Impl rule__DeclVal__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3062:2: rule__DeclVal__Group_1__2__Impl rule__DeclVal__Group_1__3
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__2__Impl_in_rule__DeclVal__Group_1__26478);
            rule__DeclVal__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__3_in_rule__DeclVal__Group_1__26481);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3069:1: rule__DeclVal__Group_1__2__Impl : ( '[' ) ;
    public final void rule__DeclVal__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3073:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3074:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3074:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3075:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2()); 
            }
            match(input,23,FOLLOW_23_in_rule__DeclVal__Group_1__2__Impl6509); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3088:1: rule__DeclVal__Group_1__3 : rule__DeclVal__Group_1__3__Impl rule__DeclVal__Group_1__4 ;
    public final void rule__DeclVal__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3092:1: ( rule__DeclVal__Group_1__3__Impl rule__DeclVal__Group_1__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3093:2: rule__DeclVal__Group_1__3__Impl rule__DeclVal__Group_1__4
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__3__Impl_in_rule__DeclVal__Group_1__36540);
            rule__DeclVal__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__4_in_rule__DeclVal__Group_1__36543);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3100:1: rule__DeclVal__Group_1__3__Impl : ( ( rule__DeclVal__Group_1_3__0 )? ) ;
    public final void rule__DeclVal__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3104:1: ( ( ( rule__DeclVal__Group_1_3__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3105:1: ( ( rule__DeclVal__Group_1_3__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3105:1: ( ( rule__DeclVal__Group_1_3__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3106:1: ( rule__DeclVal__Group_1_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getGroup_1_3()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3107:1: ( rule__DeclVal__Group_1_3__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_LHEXCHAR && LA36_0<=RULE_SLASH)||LA36_0==RULE_BINDIG||LA36_0==RULE_NBINDIG||LA36_0==31||(LA36_0>=42 && LA36_0<=43)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3107:2: rule__DeclVal__Group_1_3__0
                    {
                    pushFollow(FOLLOW_rule__DeclVal__Group_1_3__0_in_rule__DeclVal__Group_1__3__Impl6570);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3117:1: rule__DeclVal__Group_1__4 : rule__DeclVal__Group_1__4__Impl rule__DeclVal__Group_1__5 ;
    public final void rule__DeclVal__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3121:1: ( rule__DeclVal__Group_1__4__Impl rule__DeclVal__Group_1__5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3122:2: rule__DeclVal__Group_1__4__Impl rule__DeclVal__Group_1__5
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__4__Impl_in_rule__DeclVal__Group_1__46601);
            rule__DeclVal__Group_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1__5_in_rule__DeclVal__Group_1__46604);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3129:1: rule__DeclVal__Group_1__4__Impl : ( ']' ) ;
    public final void rule__DeclVal__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3133:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3134:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3134:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3135:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_4()); 
            }
            match(input,24,FOLLOW_24_in_rule__DeclVal__Group_1__4__Impl6632); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3148:1: rule__DeclVal__Group_1__5 : rule__DeclVal__Group_1__5__Impl ;
    public final void rule__DeclVal__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3152:1: ( rule__DeclVal__Group_1__5__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3153:2: rule__DeclVal__Group_1__5__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1__5__Impl_in_rule__DeclVal__Group_1__56663);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3159:1: rule__DeclVal__Group_1__5__Impl : ( ( rule__DeclVal__Alternatives_1_5 ) ) ;
    public final void rule__DeclVal__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3163:1: ( ( ( rule__DeclVal__Alternatives_1_5 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3164:1: ( ( rule__DeclVal__Alternatives_1_5 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3164:1: ( ( rule__DeclVal__Alternatives_1_5 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3165:1: ( rule__DeclVal__Alternatives_1_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getAlternatives_1_5()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3166:1: ( rule__DeclVal__Alternatives_1_5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3166:2: rule__DeclVal__Alternatives_1_5
            {
            pushFollow(FOLLOW_rule__DeclVal__Alternatives_1_5_in_rule__DeclVal__Group_1__5__Impl6690);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3188:1: rule__DeclVal__Group_1_3__0 : rule__DeclVal__Group_1_3__0__Impl rule__DeclVal__Group_1_3__1 ;
    public final void rule__DeclVal__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3192:1: ( rule__DeclVal__Group_1_3__0__Impl rule__DeclVal__Group_1_3__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3193:2: rule__DeclVal__Group_1_3__0__Impl rule__DeclVal__Group_1_3__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_3__0__Impl_in_rule__DeclVal__Group_1_3__06732);
            rule__DeclVal__Group_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_3__1_in_rule__DeclVal__Group_1_3__06735);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3200:1: rule__DeclVal__Group_1_3__0__Impl : ( ( rule__DeclVal__DecPatAssignment_1_3_0 ) ) ;
    public final void rule__DeclVal__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3204:1: ( ( ( rule__DeclVal__DecPatAssignment_1_3_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3205:1: ( ( rule__DeclVal__DecPatAssignment_1_3_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3205:1: ( ( rule__DeclVal__DecPatAssignment_1_3_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3206:1: ( rule__DeclVal__DecPatAssignment_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getDecPatAssignment_1_3_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3207:1: ( rule__DeclVal__DecPatAssignment_1_3_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3207:2: rule__DeclVal__DecPatAssignment_1_3_0
            {
            pushFollow(FOLLOW_rule__DeclVal__DecPatAssignment_1_3_0_in_rule__DeclVal__Group_1_3__0__Impl6762);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3217:1: rule__DeclVal__Group_1_3__1 : rule__DeclVal__Group_1_3__1__Impl ;
    public final void rule__DeclVal__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3221:1: ( rule__DeclVal__Group_1_3__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3222:2: rule__DeclVal__Group_1_3__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_3__1__Impl_in_rule__DeclVal__Group_1_3__16792);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3228:1: rule__DeclVal__Group_1_3__1__Impl : ( ( rule__DeclVal__DecPatAssignment_1_3_1 )* ) ;
    public final void rule__DeclVal__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3232:1: ( ( ( rule__DeclVal__DecPatAssignment_1_3_1 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3233:1: ( ( rule__DeclVal__DecPatAssignment_1_3_1 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3233:1: ( ( rule__DeclVal__DecPatAssignment_1_3_1 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3234:1: ( rule__DeclVal__DecPatAssignment_1_3_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getDecPatAssignment_1_3_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3235:1: ( rule__DeclVal__DecPatAssignment_1_3_1 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_LHEXCHAR && LA37_0<=RULE_SLASH)||LA37_0==RULE_BINDIG||LA37_0==RULE_NBINDIG||LA37_0==31||(LA37_0>=42 && LA37_0<=43)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3235:2: rule__DeclVal__DecPatAssignment_1_3_1
            	    {
            	    pushFollow(FOLLOW_rule__DeclVal__DecPatAssignment_1_3_1_in_rule__DeclVal__Group_1_3__1__Impl6819);
            	    rule__DeclVal__DecPatAssignment_1_3_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3249:1: rule__DeclVal__Group_1_5_0__0 : rule__DeclVal__Group_1_5_0__0__Impl rule__DeclVal__Group_1_5_0__1 ;
    public final void rule__DeclVal__Group_1_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3253:1: ( rule__DeclVal__Group_1_5_0__0__Impl rule__DeclVal__Group_1_5_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3254:2: rule__DeclVal__Group_1_5_0__0__Impl rule__DeclVal__Group_1_5_0__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__0__Impl_in_rule__DeclVal__Group_1_5_0__06854);
            rule__DeclVal__Group_1_5_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__1_in_rule__DeclVal__Group_1_5_0__06857);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3261:1: rule__DeclVal__Group_1_5_0__0__Impl : ( '=' ) ;
    public final void rule__DeclVal__Group_1_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3265:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3266:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3266:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3267:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_0_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclVal__Group_1_5_0__0__Impl6885); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3280:1: rule__DeclVal__Group_1_5_0__1 : rule__DeclVal__Group_1_5_0__1__Impl ;
    public final void rule__DeclVal__Group_1_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3284:1: ( rule__DeclVal__Group_1_5_0__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3285:2: rule__DeclVal__Group_1_5_0__1__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_0__1__Impl_in_rule__DeclVal__Group_1_5_0__16916);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3291:1: rule__DeclVal__Group_1_5_0__1__Impl : ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) ) ;
    public final void rule__DeclVal__Group_1_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3295:1: ( ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3296:1: ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3296:1: ( ( rule__DeclVal__ExpAssignment_1_5_0_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3297:1: ( rule__DeclVal__ExpAssignment_1_5_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpAssignment_1_5_0_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3298:1: ( rule__DeclVal__ExpAssignment_1_5_0_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3298:2: rule__DeclVal__ExpAssignment_1_5_0_1
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpAssignment_1_5_0_1_in_rule__DeclVal__Group_1_5_0__1__Impl6943);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3312:1: rule__DeclVal__Group_1_5_1__0 : rule__DeclVal__Group_1_5_1__0__Impl rule__DeclVal__Group_1_5_1__1 ;
    public final void rule__DeclVal__Group_1_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3316:1: ( rule__DeclVal__Group_1_5_1__0__Impl rule__DeclVal__Group_1_5_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3317:2: rule__DeclVal__Group_1_5_1__0__Impl rule__DeclVal__Group_1_5_1__1
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__0__Impl_in_rule__DeclVal__Group_1_5_1__06977);
            rule__DeclVal__Group_1_5_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__1_in_rule__DeclVal__Group_1_5_1__06980);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3324:1: rule__DeclVal__Group_1_5_1__0__Impl : ( RULE_PIPE ) ;
    public final void rule__DeclVal__Group_1_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3328:1: ( ( RULE_PIPE ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3329:1: ( RULE_PIPE )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3329:1: ( RULE_PIPE )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3330:1: RULE_PIPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getPIPETerminalRuleCall_1_5_1_0()); 
            }
            match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__DeclVal__Group_1_5_1__0__Impl7007); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3341:1: rule__DeclVal__Group_1_5_1__1 : rule__DeclVal__Group_1_5_1__1__Impl rule__DeclVal__Group_1_5_1__2 ;
    public final void rule__DeclVal__Group_1_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3345:1: ( rule__DeclVal__Group_1_5_1__1__Impl rule__DeclVal__Group_1_5_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3346:2: rule__DeclVal__Group_1_5_1__1__Impl rule__DeclVal__Group_1_5_1__2
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__1__Impl_in_rule__DeclVal__Group_1_5_1__17036);
            rule__DeclVal__Group_1_5_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__2_in_rule__DeclVal__Group_1_5_1__17039);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3353:1: rule__DeclVal__Group_1_5_1__1__Impl : ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) ) ;
    public final void rule__DeclVal__Group_1_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3357:1: ( ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3358:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3358:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3359:1: ( rule__DeclVal__ExpsAssignment_1_5_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3360:1: ( rule__DeclVal__ExpsAssignment_1_5_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3360:2: rule__DeclVal__ExpsAssignment_1_5_1_1
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_1_in_rule__DeclVal__Group_1_5_1__1__Impl7066);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3370:1: rule__DeclVal__Group_1_5_1__2 : rule__DeclVal__Group_1_5_1__2__Impl rule__DeclVal__Group_1_5_1__3 ;
    public final void rule__DeclVal__Group_1_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3374:1: ( rule__DeclVal__Group_1_5_1__2__Impl rule__DeclVal__Group_1_5_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3375:2: rule__DeclVal__Group_1_5_1__2__Impl rule__DeclVal__Group_1_5_1__3
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__2__Impl_in_rule__DeclVal__Group_1_5_1__27096);
            rule__DeclVal__Group_1_5_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__3_in_rule__DeclVal__Group_1_5_1__27099);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3382:1: rule__DeclVal__Group_1_5_1__2__Impl : ( '=' ) ;
    public final void rule__DeclVal__Group_1_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3386:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3387:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3387:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3388:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_1_2()); 
            }
            match(input,21,FOLLOW_21_in_rule__DeclVal__Group_1_5_1__2__Impl7127); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3401:1: rule__DeclVal__Group_1_5_1__3 : rule__DeclVal__Group_1_5_1__3__Impl ;
    public final void rule__DeclVal__Group_1_5_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3405:1: ( rule__DeclVal__Group_1_5_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3406:2: rule__DeclVal__Group_1_5_1__3__Impl
            {
            pushFollow(FOLLOW_rule__DeclVal__Group_1_5_1__3__Impl_in_rule__DeclVal__Group_1_5_1__37158);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3412:1: rule__DeclVal__Group_1_5_1__3__Impl : ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) ) ;
    public final void rule__DeclVal__Group_1_5_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3416:1: ( ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3417:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3417:1: ( ( rule__DeclVal__ExpsAssignment_1_5_1_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3418:1: ( rule__DeclVal__ExpsAssignment_1_5_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpsAssignment_1_5_1_3()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3419:1: ( rule__DeclVal__ExpsAssignment_1_5_1_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3419:2: rule__DeclVal__ExpsAssignment_1_5_1_3
            {
            pushFollow(FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_3_in_rule__DeclVal__Group_1_5_1__3__Impl7185);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3437:1: rule__Export__Group__0 : rule__Export__Group__0__Impl rule__Export__Group__1 ;
    public final void rule__Export__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3441:1: ( rule__Export__Group__0__Impl rule__Export__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3442:2: rule__Export__Group__0__Impl rule__Export__Group__1
            {
            pushFollow(FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__07223);
            rule__Export__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group__1_in_rule__Export__Group__07226);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3449:1: rule__Export__Group__0__Impl : ( ( rule__Export__NameAssignment_0 ) ) ;
    public final void rule__Export__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3453:1: ( ( ( rule__Export__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3454:1: ( ( rule__Export__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3454:1: ( ( rule__Export__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3455:1: ( rule__Export__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3456:1: ( rule__Export__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3456:2: rule__Export__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl7253);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3466:1: rule__Export__Group__1 : rule__Export__Group__1__Impl ;
    public final void rule__Export__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3470:1: ( rule__Export__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3471:2: rule__Export__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__17283);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3477:1: rule__Export__Group__1__Impl : ( ( rule__Export__Group_1__0 )? ) ;
    public final void rule__Export__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3481:1: ( ( ( rule__Export__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3482:1: ( ( rule__Export__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3482:1: ( ( rule__Export__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3483:1: ( rule__Export__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3484:1: ( rule__Export__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==27) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3484:2: rule__Export__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl7310);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3498:1: rule__Export__Group_1__0 : rule__Export__Group_1__0__Impl rule__Export__Group_1__1 ;
    public final void rule__Export__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3502:1: ( rule__Export__Group_1__0__Impl rule__Export__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3503:2: rule__Export__Group_1__0__Impl rule__Export__Group_1__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__07345);
            rule__Export__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__07348);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3510:1: rule__Export__Group_1__0__Impl : ( '{' ) ;
    public final void rule__Export__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3514:1: ( ( '{' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3515:1: ( '{' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3515:1: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3516:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Export__Group_1__0__Impl7376); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3529:1: rule__Export__Group_1__1 : rule__Export__Group_1__1__Impl rule__Export__Group_1__2 ;
    public final void rule__Export__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3533:1: ( rule__Export__Group_1__1__Impl rule__Export__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3534:2: rule__Export__Group_1__1__Impl rule__Export__Group_1__2
            {
            pushFollow(FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__17407);
            rule__Export__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__17410);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3541:1: rule__Export__Group_1__1__Impl : ( ( rule__Export__AttrNameAssignment_1_1 ) ) ;
    public final void rule__Export__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3545:1: ( ( ( rule__Export__AttrNameAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3546:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3546:1: ( ( rule__Export__AttrNameAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3547:1: ( rule__Export__AttrNameAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getAttrNameAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3548:1: ( rule__Export__AttrNameAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3548:2: rule__Export__AttrNameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl7437);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3558:1: rule__Export__Group_1__2 : rule__Export__Group_1__2__Impl rule__Export__Group_1__3 ;
    public final void rule__Export__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3562:1: ( rule__Export__Group_1__2__Impl rule__Export__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3563:2: rule__Export__Group_1__2__Impl rule__Export__Group_1__3
            {
            pushFollow(FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__27467);
            rule__Export__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__27470);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3570:1: rule__Export__Group_1__2__Impl : ( ( rule__Export__Group_1_2__0 )* ) ;
    public final void rule__Export__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3574:1: ( ( ( rule__Export__Group_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3575:1: ( ( rule__Export__Group_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3575:1: ( ( rule__Export__Group_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3576:1: ( rule__Export__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getGroup_1_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3577:1: ( rule__Export__Group_1_2__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==25) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3577:2: rule__Export__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl7497);
            	    rule__Export__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3587:1: rule__Export__Group_1__3 : rule__Export__Group_1__3__Impl ;
    public final void rule__Export__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3591:1: ( rule__Export__Group_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3592:2: rule__Export__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__37528);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3598:1: rule__Export__Group_1__3__Impl : ( '}' ) ;
    public final void rule__Export__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3602:1: ( ( '}' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3603:1: ( '}' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3603:1: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3604:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getRightCurlyBracketKeyword_1_3()); 
            }
            match(input,28,FOLLOW_28_in_rule__Export__Group_1__3__Impl7556); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3625:1: rule__Export__Group_1_2__0 : rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 ;
    public final void rule__Export__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3629:1: ( rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3630:2: rule__Export__Group_1_2__0__Impl rule__Export__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__07595);
            rule__Export__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__07598);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3637:1: rule__Export__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__Export__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3641:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3642:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3642:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3643:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__Export__Group_1_2__0__Impl7626); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3656:1: rule__Export__Group_1_2__1 : rule__Export__Group_1_2__1__Impl ;
    public final void rule__Export__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3660:1: ( rule__Export__Group_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3661:2: rule__Export__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__17657);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3667:1: rule__Export__Group_1_2__1__Impl : ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) ;
    public final void rule__Export__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3671:1: ( ( ( rule__Export__AttrNameAssignment_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3672:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3672:1: ( ( rule__Export__AttrNameAssignment_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3673:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getAttrNameAssignment_1_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3674:1: ( rule__Export__AttrNameAssignment_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3674:2: rule__Export__AttrNameAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl7684);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3688:1: rule__ConDecls__Group__0 : rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1 ;
    public final void rule__ConDecls__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3692:1: ( rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3693:2: rule__ConDecls__Group__0__Impl rule__ConDecls__Group__1
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__0__Impl_in_rule__ConDecls__Group__07718);
            rule__ConDecls__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConDecls__Group__1_in_rule__ConDecls__Group__07721);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3700:1: rule__ConDecls__Group__0__Impl : ( ( rule__ConDecls__ConDeclsAssignment_0 ) ) ;
    public final void rule__ConDecls__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3704:1: ( ( ( rule__ConDecls__ConDeclsAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3705:1: ( ( rule__ConDecls__ConDeclsAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3705:1: ( ( rule__ConDecls__ConDeclsAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3706:1: ( rule__ConDecls__ConDeclsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getConDeclsAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3707:1: ( rule__ConDecls__ConDeclsAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3707:2: rule__ConDecls__ConDeclsAssignment_0
            {
            pushFollow(FOLLOW_rule__ConDecls__ConDeclsAssignment_0_in_rule__ConDecls__Group__0__Impl7748);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3717:1: rule__ConDecls__Group__1 : rule__ConDecls__Group__1__Impl ;
    public final void rule__ConDecls__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3721:1: ( rule__ConDecls__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3722:2: rule__ConDecls__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecls__Group__1__Impl_in_rule__ConDecls__Group__17778);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3728:1: rule__ConDecls__Group__1__Impl : ( ( rule__ConDecls__Group_1__0 )* ) ;
    public final void rule__ConDecls__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3732:1: ( ( ( rule__ConDecls__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3733:1: ( ( rule__ConDecls__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3733:1: ( ( rule__ConDecls__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3734:1: ( rule__ConDecls__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3735:1: ( rule__ConDecls__Group_1__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_PIPE) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3735:2: rule__ConDecls__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConDecls__Group_1__0_in_rule__ConDecls__Group__1__Impl7805);
            	    rule__ConDecls__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3749:1: rule__ConDecls__Group_1__0 : rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1 ;
    public final void rule__ConDecls__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3753:1: ( rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3754:2: rule__ConDecls__Group_1__0__Impl rule__ConDecls__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConDecls__Group_1__0__Impl_in_rule__ConDecls__Group_1__07840);
            rule__ConDecls__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConDecls__Group_1__1_in_rule__ConDecls__Group_1__07843);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3761:1: rule__ConDecls__Group_1__0__Impl : ( RULE_PIPE ) ;
    public final void rule__ConDecls__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3765:1: ( ( RULE_PIPE ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3766:1: ( RULE_PIPE )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3766:1: ( RULE_PIPE )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3767:1: RULE_PIPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getPIPETerminalRuleCall_1_0()); 
            }
            match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__ConDecls__Group_1__0__Impl7870); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3778:1: rule__ConDecls__Group_1__1 : rule__ConDecls__Group_1__1__Impl ;
    public final void rule__ConDecls__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3782:1: ( rule__ConDecls__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3783:2: rule__ConDecls__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecls__Group_1__1__Impl_in_rule__ConDecls__Group_1__17899);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3789:1: rule__ConDecls__Group_1__1__Impl : ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) ) ;
    public final void rule__ConDecls__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3793:1: ( ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3794:1: ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3794:1: ( ( rule__ConDecls__ConDeclsAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3795:1: ( rule__ConDecls__ConDeclsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getConDeclsAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3796:1: ( rule__ConDecls__ConDeclsAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3796:2: rule__ConDecls__ConDeclsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConDecls__ConDeclsAssignment_1_1_in_rule__ConDecls__Group_1__1__Impl7926);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3810:1: rule__ConDecl__Group__0 : rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1 ;
    public final void rule__ConDecl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3814:1: ( rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3815:2: rule__ConDecl__Group__0__Impl rule__ConDecl__Group__1
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__0__Impl_in_rule__ConDecl__Group__07960);
            rule__ConDecl__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConDecl__Group__1_in_rule__ConDecl__Group__07963);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3822:1: rule__ConDecl__Group__0__Impl : ( ( rule__ConDecl__NameAssignment_0 ) ) ;
    public final void rule__ConDecl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3826:1: ( ( ( rule__ConDecl__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3827:1: ( ( rule__ConDecl__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3827:1: ( ( rule__ConDecl__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3828:1: ( rule__ConDecl__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3829:1: ( rule__ConDecl__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3829:2: rule__ConDecl__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ConDecl__NameAssignment_0_in_rule__ConDecl__Group__0__Impl7990);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3839:1: rule__ConDecl__Group__1 : rule__ConDecl__Group__1__Impl ;
    public final void rule__ConDecl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3843:1: ( rule__ConDecl__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3844:2: rule__ConDecl__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecl__Group__1__Impl_in_rule__ConDecl__Group__18020);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3850:1: rule__ConDecl__Group__1__Impl : ( ( rule__ConDecl__Group_1__0 )? ) ;
    public final void rule__ConDecl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3854:1: ( ( ( rule__ConDecl__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3855:1: ( ( rule__ConDecl__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3855:1: ( ( rule__ConDecl__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3856:1: ( rule__ConDecl__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3857:1: ( rule__ConDecl__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==29) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3857:2: rule__ConDecl__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ConDecl__Group_1__0_in_rule__ConDecl__Group__1__Impl8047);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3871:1: rule__ConDecl__Group_1__0 : rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1 ;
    public final void rule__ConDecl__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3875:1: ( rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3876:2: rule__ConDecl__Group_1__0__Impl rule__ConDecl__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConDecl__Group_1__0__Impl_in_rule__ConDecl__Group_1__08082);
            rule__ConDecl__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ConDecl__Group_1__1_in_rule__ConDecl__Group_1__08085);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3883:1: rule__ConDecl__Group_1__0__Impl : ( 'of' ) ;
    public final void rule__ConDecl__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3887:1: ( ( 'of' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3888:1: ( 'of' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3888:1: ( 'of' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3889:1: 'of'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getOfKeyword_1_0()); 
            }
            match(input,29,FOLLOW_29_in_rule__ConDecl__Group_1__0__Impl8113); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3902:1: rule__ConDecl__Group_1__1 : rule__ConDecl__Group_1__1__Impl ;
    public final void rule__ConDecl__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3906:1: ( rule__ConDecl__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3907:2: rule__ConDecl__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ConDecl__Group_1__1__Impl_in_rule__ConDecl__Group_1__18144);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3913:1: rule__ConDecl__Group_1__1__Impl : ( ( rule__ConDecl__TyAssignment_1_1 ) ) ;
    public final void rule__ConDecl__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3917:1: ( ( ( rule__ConDecl__TyAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3918:1: ( ( rule__ConDecl__TyAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3918:1: ( ( rule__ConDecl__TyAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3919:1: ( rule__ConDecl__TyAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getTyAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3920:1: ( rule__ConDecl__TyAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3920:2: rule__ConDecl__TyAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ConDecl__TyAssignment_1_1_in_rule__ConDecl__Group_1__1__Impl8171);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3934:1: rule__Ty__Group_1__0 : rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1 ;
    public final void rule__Ty__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3938:1: ( rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3939:2: rule__Ty__Group_1__0__Impl rule__Ty__Group_1__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__0__Impl_in_rule__Ty__Group_1__08205);
            rule__Ty__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_1__1_in_rule__Ty__Group_1__08208);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3946:1: rule__Ty__Group_1__0__Impl : ( RULE_PIPE ) ;
    public final void rule__Ty__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3950:1: ( ( RULE_PIPE ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3951:1: ( RULE_PIPE )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3951:1: ( RULE_PIPE )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3952:1: RULE_PIPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_0()); 
            }
            match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__Ty__Group_1__0__Impl8235); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3963:1: rule__Ty__Group_1__1 : rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2 ;
    public final void rule__Ty__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3967:1: ( rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3968:2: rule__Ty__Group_1__1__Impl rule__Ty__Group_1__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__1__Impl_in_rule__Ty__Group_1__18264);
            rule__Ty__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_1__2_in_rule__Ty__Group_1__18267);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3975:1: rule__Ty__Group_1__1__Impl : ( ( rule__Ty__ValueAssignment_1_1 ) ) ;
    public final void rule__Ty__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3979:1: ( ( ( rule__Ty__ValueAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3980:1: ( ( rule__Ty__ValueAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3980:1: ( ( rule__Ty__ValueAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3981:1: ( rule__Ty__ValueAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3982:1: ( rule__Ty__ValueAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3982:2: rule__Ty__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Ty__ValueAssignment_1_1_in_rule__Ty__Group_1__1__Impl8294);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3992:1: rule__Ty__Group_1__2 : rule__Ty__Group_1__2__Impl ;
    public final void rule__Ty__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3996:1: ( rule__Ty__Group_1__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3997:2: rule__Ty__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_1__2__Impl_in_rule__Ty__Group_1__28324);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4003:1: rule__Ty__Group_1__2__Impl : ( RULE_PIPE ) ;
    public final void rule__Ty__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4007:1: ( ( RULE_PIPE ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4008:1: ( RULE_PIPE )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4008:1: ( RULE_PIPE )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4009:1: RULE_PIPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_2()); 
            }
            match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__Ty__Group_1__2__Impl8351); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4026:1: rule__Ty__Group_2__0 : rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1 ;
    public final void rule__Ty__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4030:1: ( rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4031:2: rule__Ty__Group_2__0__Impl rule__Ty__Group_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2__0__Impl_in_rule__Ty__Group_2__08386);
            rule__Ty__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2__1_in_rule__Ty__Group_2__08389);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4038:1: rule__Ty__Group_2__0__Impl : ( ( rule__Ty__ValueAssignment_2_0 ) ) ;
    public final void rule__Ty__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4042:1: ( ( ( rule__Ty__ValueAssignment_2_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4043:1: ( ( rule__Ty__ValueAssignment_2_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4043:1: ( ( rule__Ty__ValueAssignment_2_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4044:1: ( rule__Ty__ValueAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueAssignment_2_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4045:1: ( rule__Ty__ValueAssignment_2_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4045:2: rule__Ty__ValueAssignment_2_0
            {
            pushFollow(FOLLOW_rule__Ty__ValueAssignment_2_0_in_rule__Ty__Group_2__0__Impl8416);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4055:1: rule__Ty__Group_2__1 : rule__Ty__Group_2__1__Impl ;
    public final void rule__Ty__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4059:1: ( rule__Ty__Group_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4060:2: rule__Ty__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2__1__Impl_in_rule__Ty__Group_2__18446);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4066:1: rule__Ty__Group_2__1__Impl : ( ( rule__Ty__Group_2_1__0 )? ) ;
    public final void rule__Ty__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4070:1: ( ( ( rule__Ty__Group_2_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4071:1: ( ( rule__Ty__Group_2_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4071:1: ( ( rule__Ty__Group_2_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4072:1: ( rule__Ty__Group_2_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getGroup_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4073:1: ( rule__Ty__Group_2_1__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==23) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4073:2: rule__Ty__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Ty__Group_2_1__0_in_rule__Ty__Group_2__1__Impl8473);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4087:1: rule__Ty__Group_2_1__0 : rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1 ;
    public final void rule__Ty__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4091:1: ( rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4092:2: rule__Ty__Group_2_1__0__Impl rule__Ty__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__0__Impl_in_rule__Ty__Group_2_1__08508);
            rule__Ty__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2_1__1_in_rule__Ty__Group_2_1__08511);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4099:1: rule__Ty__Group_2_1__0__Impl : ( '[' ) ;
    public final void rule__Ty__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4103:1: ( ( '[' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4104:1: ( '[' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4104:1: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4105:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__Ty__Group_2_1__0__Impl8539); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4118:1: rule__Ty__Group_2_1__1 : rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2 ;
    public final void rule__Ty__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4122:1: ( rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4123:2: rule__Ty__Group_2_1__1__Impl rule__Ty__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__1__Impl_in_rule__Ty__Group_2_1__18570);
            rule__Ty__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2_1__2_in_rule__Ty__Group_2_1__18573);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4130:1: rule__Ty__Group_2_1__1__Impl : ( ( rule__Ty__TyBindAssignment_2_1_1 ) ) ;
    public final void rule__Ty__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4134:1: ( ( ( rule__Ty__TyBindAssignment_2_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4135:1: ( ( rule__Ty__TyBindAssignment_2_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4135:1: ( ( rule__Ty__TyBindAssignment_2_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4136:1: ( rule__Ty__TyBindAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getTyBindAssignment_2_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4137:1: ( rule__Ty__TyBindAssignment_2_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4137:2: rule__Ty__TyBindAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__Ty__TyBindAssignment_2_1_1_in_rule__Ty__Group_2_1__1__Impl8600);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4147:1: rule__Ty__Group_2_1__2 : rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3 ;
    public final void rule__Ty__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4151:1: ( rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4152:2: rule__Ty__Group_2_1__2__Impl rule__Ty__Group_2_1__3
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__2__Impl_in_rule__Ty__Group_2_1__28630);
            rule__Ty__Group_2_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2_1__3_in_rule__Ty__Group_2_1__28633);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4159:1: rule__Ty__Group_2_1__2__Impl : ( ( rule__Ty__Group_2_1_2__0 )* ) ;
    public final void rule__Ty__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4163:1: ( ( ( rule__Ty__Group_2_1_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4164:1: ( ( rule__Ty__Group_2_1_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4164:1: ( ( rule__Ty__Group_2_1_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4165:1: ( rule__Ty__Group_2_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getGroup_2_1_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4166:1: ( rule__Ty__Group_2_1_2__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==25) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4166:2: rule__Ty__Group_2_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Ty__Group_2_1_2__0_in_rule__Ty__Group_2_1__2__Impl8660);
            	    rule__Ty__Group_2_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop43;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4176:1: rule__Ty__Group_2_1__3 : rule__Ty__Group_2_1__3__Impl ;
    public final void rule__Ty__Group_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4180:1: ( rule__Ty__Group_2_1__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4181:2: rule__Ty__Group_2_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1__3__Impl_in_rule__Ty__Group_2_1__38691);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4187:1: rule__Ty__Group_2_1__3__Impl : ( ']' ) ;
    public final void rule__Ty__Group_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4191:1: ( ( ']' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4192:1: ( ']' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4192:1: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4193:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getRightSquareBracketKeyword_2_1_3()); 
            }
            match(input,24,FOLLOW_24_in_rule__Ty__Group_2_1__3__Impl8719); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4214:1: rule__Ty__Group_2_1_2__0 : rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1 ;
    public final void rule__Ty__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4218:1: ( rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4219:2: rule__Ty__Group_2_1_2__0__Impl rule__Ty__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__0__Impl_in_rule__Ty__Group_2_1_2__08758);
            rule__Ty__Group_2_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__1_in_rule__Ty__Group_2_1_2__08761);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4226:1: rule__Ty__Group_2_1_2__0__Impl : ( ',' ) ;
    public final void rule__Ty__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4230:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4231:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4231:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4232:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__Ty__Group_2_1_2__0__Impl8789); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4245:1: rule__Ty__Group_2_1_2__1 : rule__Ty__Group_2_1_2__1__Impl ;
    public final void rule__Ty__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4249:1: ( rule__Ty__Group_2_1_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4250:2: rule__Ty__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_2_1_2__1__Impl_in_rule__Ty__Group_2_1_2__18820);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4256:1: rule__Ty__Group_2_1_2__1__Impl : ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) ) ;
    public final void rule__Ty__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4260:1: ( ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4261:1: ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4261:1: ( ( rule__Ty__TyBindAssignment_2_1_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4262:1: ( rule__Ty__TyBindAssignment_2_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getTyBindAssignment_2_1_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4263:1: ( rule__Ty__TyBindAssignment_2_1_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4263:2: rule__Ty__TyBindAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Ty__TyBindAssignment_2_1_2_1_in_rule__Ty__Group_2_1_2__1__Impl8847);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4277:1: rule__Ty__Group_3__0 : rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1 ;
    public final void rule__Ty__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4281:1: ( rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4282:2: rule__Ty__Group_3__0__Impl rule__Ty__Group_3__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__0__Impl_in_rule__Ty__Group_3__08881);
            rule__Ty__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_3__1_in_rule__Ty__Group_3__08884);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4289:1: rule__Ty__Group_3__0__Impl : ( '{' ) ;
    public final void rule__Ty__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4293:1: ( ( '{' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4294:1: ( '{' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4294:1: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4295:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__Ty__Group_3__0__Impl8912); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4308:1: rule__Ty__Group_3__1 : rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2 ;
    public final void rule__Ty__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4312:1: ( rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4313:2: rule__Ty__Group_3__1__Impl rule__Ty__Group_3__2
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__1__Impl_in_rule__Ty__Group_3__18943);
            rule__Ty__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_3__2_in_rule__Ty__Group_3__18946);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4320:1: rule__Ty__Group_3__1__Impl : ( ( rule__Ty__ElementsAssignment_3_1 ) ) ;
    public final void rule__Ty__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4324:1: ( ( ( rule__Ty__ElementsAssignment_3_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4325:1: ( ( rule__Ty__ElementsAssignment_3_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4325:1: ( ( rule__Ty__ElementsAssignment_3_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4326:1: ( rule__Ty__ElementsAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getElementsAssignment_3_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4327:1: ( rule__Ty__ElementsAssignment_3_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4327:2: rule__Ty__ElementsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Ty__ElementsAssignment_3_1_in_rule__Ty__Group_3__1__Impl8973);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4337:1: rule__Ty__Group_3__2 : rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3 ;
    public final void rule__Ty__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4341:1: ( rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4342:2: rule__Ty__Group_3__2__Impl rule__Ty__Group_3__3
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__2__Impl_in_rule__Ty__Group_3__29003);
            rule__Ty__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_3__3_in_rule__Ty__Group_3__29006);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4349:1: rule__Ty__Group_3__2__Impl : ( ( rule__Ty__Group_3_2__0 )* ) ;
    public final void rule__Ty__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4353:1: ( ( ( rule__Ty__Group_3_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4354:1: ( ( rule__Ty__Group_3_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4354:1: ( ( rule__Ty__Group_3_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4355:1: ( rule__Ty__Group_3_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getGroup_3_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4356:1: ( rule__Ty__Group_3_2__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==25) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4356:2: rule__Ty__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Ty__Group_3_2__0_in_rule__Ty__Group_3__2__Impl9033);
            	    rule__Ty__Group_3_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4366:1: rule__Ty__Group_3__3 : rule__Ty__Group_3__3__Impl ;
    public final void rule__Ty__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4370:1: ( rule__Ty__Group_3__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4371:2: rule__Ty__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_3__3__Impl_in_rule__Ty__Group_3__39064);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4377:1: rule__Ty__Group_3__3__Impl : ( '}' ) ;
    public final void rule__Ty__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4381:1: ( ( '}' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4382:1: ( '}' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4382:1: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4383:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getRightCurlyBracketKeyword_3_3()); 
            }
            match(input,28,FOLLOW_28_in_rule__Ty__Group_3__3__Impl9092); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4404:1: rule__Ty__Group_3_2__0 : rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1 ;
    public final void rule__Ty__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4408:1: ( rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4409:2: rule__Ty__Group_3_2__0__Impl rule__Ty__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__Ty__Group_3_2__0__Impl_in_rule__Ty__Group_3_2__09131);
            rule__Ty__Group_3_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Ty__Group_3_2__1_in_rule__Ty__Group_3_2__09134);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4416:1: rule__Ty__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Ty__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4420:1: ( ( ',' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4421:1: ( ',' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4421:1: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4422:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__Ty__Group_3_2__0__Impl9162); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4435:1: rule__Ty__Group_3_2__1 : rule__Ty__Group_3_2__1__Impl ;
    public final void rule__Ty__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4439:1: ( rule__Ty__Group_3_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4440:2: rule__Ty__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Ty__Group_3_2__1__Impl_in_rule__Ty__Group_3_2__19193);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4446:1: rule__Ty__Group_3_2__1__Impl : ( ( rule__Ty__ElementsAssignment_3_2_1 ) ) ;
    public final void rule__Ty__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4450:1: ( ( ( rule__Ty__ElementsAssignment_3_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4451:1: ( ( rule__Ty__ElementsAssignment_3_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4451:1: ( ( rule__Ty__ElementsAssignment_3_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4452:1: ( rule__Ty__ElementsAssignment_3_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getElementsAssignment_3_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4453:1: ( rule__Ty__ElementsAssignment_3_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4453:2: rule__Ty__ElementsAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__Ty__ElementsAssignment_3_2_1_in_rule__Ty__Group_3_2__1__Impl9220);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4467:1: rule__TyElement__Group__0 : rule__TyElement__Group__0__Impl rule__TyElement__Group__1 ;
    public final void rule__TyElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4471:1: ( rule__TyElement__Group__0__Impl rule__TyElement__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4472:2: rule__TyElement__Group__0__Impl rule__TyElement__Group__1
            {
            pushFollow(FOLLOW_rule__TyElement__Group__0__Impl_in_rule__TyElement__Group__09254);
            rule__TyElement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TyElement__Group__1_in_rule__TyElement__Group__09257);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4479:1: rule__TyElement__Group__0__Impl : ( ( rule__TyElement__NameAssignment_0 ) ) ;
    public final void rule__TyElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4483:1: ( ( ( rule__TyElement__NameAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4484:1: ( ( rule__TyElement__NameAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4484:1: ( ( rule__TyElement__NameAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4485:1: ( rule__TyElement__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getNameAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4486:1: ( rule__TyElement__NameAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4486:2: rule__TyElement__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__TyElement__NameAssignment_0_in_rule__TyElement__Group__0__Impl9284);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4496:1: rule__TyElement__Group__1 : rule__TyElement__Group__1__Impl rule__TyElement__Group__2 ;
    public final void rule__TyElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4500:1: ( rule__TyElement__Group__1__Impl rule__TyElement__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4501:2: rule__TyElement__Group__1__Impl rule__TyElement__Group__2
            {
            pushFollow(FOLLOW_rule__TyElement__Group__1__Impl_in_rule__TyElement__Group__19314);
            rule__TyElement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TyElement__Group__2_in_rule__TyElement__Group__19317);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4508:1: rule__TyElement__Group__1__Impl : ( ':' ) ;
    public final void rule__TyElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4512:1: ( ( ':' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4513:1: ( ':' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4513:1: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4514:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getColonKeyword_1()); 
            }
            match(input,30,FOLLOW_30_in_rule__TyElement__Group__1__Impl9345); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4527:1: rule__TyElement__Group__2 : rule__TyElement__Group__2__Impl ;
    public final void rule__TyElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4531:1: ( rule__TyElement__Group__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4532:2: rule__TyElement__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TyElement__Group__2__Impl_in_rule__TyElement__Group__29376);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4538:1: rule__TyElement__Group__2__Impl : ( ( rule__TyElement__ValueAssignment_2 ) ) ;
    public final void rule__TyElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4542:1: ( ( ( rule__TyElement__ValueAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4543:1: ( ( rule__TyElement__ValueAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4543:1: ( ( rule__TyElement__ValueAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4544:1: ( rule__TyElement__ValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getValueAssignment_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4545:1: ( rule__TyElement__ValueAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4545:2: rule__TyElement__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__TyElement__ValueAssignment_2_in_rule__TyElement__Group__2__Impl9403);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4561:1: rule__TyBind__Group__0 : rule__TyBind__Group__0__Impl rule__TyBind__Group__1 ;
    public final void rule__TyBind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4565:1: ( rule__TyBind__Group__0__Impl rule__TyBind__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4566:2: rule__TyBind__Group__0__Impl rule__TyBind__Group__1
            {
            pushFollow(FOLLOW_rule__TyBind__Group__0__Impl_in_rule__TyBind__Group__09439);
            rule__TyBind__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TyBind__Group__1_in_rule__TyBind__Group__09442);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4573:1: rule__TyBind__Group__0__Impl : ( ( rule__TyBind__KeyAssignment_0 ) ) ;
    public final void rule__TyBind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4577:1: ( ( ( rule__TyBind__KeyAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4578:1: ( ( rule__TyBind__KeyAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4578:1: ( ( rule__TyBind__KeyAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4579:1: ( rule__TyBind__KeyAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getKeyAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4580:1: ( rule__TyBind__KeyAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4580:2: rule__TyBind__KeyAssignment_0
            {
            pushFollow(FOLLOW_rule__TyBind__KeyAssignment_0_in_rule__TyBind__Group__0__Impl9469);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4590:1: rule__TyBind__Group__1 : rule__TyBind__Group__1__Impl ;
    public final void rule__TyBind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4594:1: ( rule__TyBind__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4595:2: rule__TyBind__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TyBind__Group__1__Impl_in_rule__TyBind__Group__19499);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4601:1: rule__TyBind__Group__1__Impl : ( ( rule__TyBind__Group_1__0 )? ) ;
    public final void rule__TyBind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4605:1: ( ( ( rule__TyBind__Group_1__0 )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4606:1: ( ( rule__TyBind__Group_1__0 )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4606:1: ( ( rule__TyBind__Group_1__0 )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4607:1: ( rule__TyBind__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4608:1: ( rule__TyBind__Group_1__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==21) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4608:2: rule__TyBind__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TyBind__Group_1__0_in_rule__TyBind__Group__1__Impl9526);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4622:1: rule__TyBind__Group_1__0 : rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1 ;
    public final void rule__TyBind__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4626:1: ( rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4627:2: rule__TyBind__Group_1__0__Impl rule__TyBind__Group_1__1
            {
            pushFollow(FOLLOW_rule__TyBind__Group_1__0__Impl_in_rule__TyBind__Group_1__09561);
            rule__TyBind__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TyBind__Group_1__1_in_rule__TyBind__Group_1__09564);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4634:1: rule__TyBind__Group_1__0__Impl : ( '=' ) ;
    public final void rule__TyBind__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4638:1: ( ( '=' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4639:1: ( '=' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4639:1: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4640:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__TyBind__Group_1__0__Impl9592); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4653:1: rule__TyBind__Group_1__1 : rule__TyBind__Group_1__1__Impl ;
    public final void rule__TyBind__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4657:1: ( rule__TyBind__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4658:2: rule__TyBind__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TyBind__Group_1__1__Impl_in_rule__TyBind__Group_1__19623);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4664:1: rule__TyBind__Group_1__1__Impl : ( ( rule__TyBind__ValueAssignment_1_1 ) ) ;
    public final void rule__TyBind__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4668:1: ( ( ( rule__TyBind__ValueAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4669:1: ( ( rule__TyBind__ValueAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4669:1: ( ( rule__TyBind__ValueAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4670:1: ( rule__TyBind__ValueAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getValueAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4671:1: ( rule__TyBind__ValueAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4671:2: rule__TyBind__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_rule__TyBind__ValueAssignment_1_1_in_rule__TyBind__Group_1__1__Impl9650);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4685:1: rule__BitPat__Group__0 : rule__BitPat__Group__0__Impl rule__BitPat__Group__1 ;
    public final void rule__BitPat__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4689:1: ( rule__BitPat__Group__0__Impl rule__BitPat__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4690:2: rule__BitPat__Group__0__Impl rule__BitPat__Group__1
            {
            pushFollow(FOLLOW_rule__BitPat__Group__0__Impl_in_rule__BitPat__Group__09684);
            rule__BitPat__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPat__Group__1_in_rule__BitPat__Group__09687);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4697:1: rule__BitPat__Group__0__Impl : ( '\\'' ) ;
    public final void rule__BitPat__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4701:1: ( ( '\\'' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4702:1: ( '\\'' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4702:1: ( '\\'' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4703:1: '\\''
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getApostropheKeyword_0()); 
            }
            match(input,31,FOLLOW_31_in_rule__BitPat__Group__0__Impl9715); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4716:1: rule__BitPat__Group__1 : rule__BitPat__Group__1__Impl rule__BitPat__Group__2 ;
    public final void rule__BitPat__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4720:1: ( rule__BitPat__Group__1__Impl rule__BitPat__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4721:2: rule__BitPat__Group__1__Impl rule__BitPat__Group__2
            {
            pushFollow(FOLLOW_rule__BitPat__Group__1__Impl_in_rule__BitPat__Group__19746);
            rule__BitPat__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPat__Group__2_in_rule__BitPat__Group__19749);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4728:1: rule__BitPat__Group__1__Impl : ( ( rule__BitPat__BitpatAssignment_1 ) ) ;
    public final void rule__BitPat__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4732:1: ( ( ( rule__BitPat__BitpatAssignment_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4733:1: ( ( rule__BitPat__BitpatAssignment_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4733:1: ( ( rule__BitPat__BitpatAssignment_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4734:1: ( rule__BitPat__BitpatAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getBitpatAssignment_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4735:1: ( rule__BitPat__BitpatAssignment_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4735:2: rule__BitPat__BitpatAssignment_1
            {
            pushFollow(FOLLOW_rule__BitPat__BitpatAssignment_1_in_rule__BitPat__Group__1__Impl9776);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4745:1: rule__BitPat__Group__2 : rule__BitPat__Group__2__Impl rule__BitPat__Group__3 ;
    public final void rule__BitPat__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4749:1: ( rule__BitPat__Group__2__Impl rule__BitPat__Group__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4750:2: rule__BitPat__Group__2__Impl rule__BitPat__Group__3
            {
            pushFollow(FOLLOW_rule__BitPat__Group__2__Impl_in_rule__BitPat__Group__29806);
            rule__BitPat__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPat__Group__3_in_rule__BitPat__Group__29809);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4757:1: rule__BitPat__Group__2__Impl : ( ( rule__BitPat__BitpatAssignment_2 )* ) ;
    public final void rule__BitPat__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4761:1: ( ( ( rule__BitPat__BitpatAssignment_2 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4762:1: ( ( rule__BitPat__BitpatAssignment_2 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4762:1: ( ( rule__BitPat__BitpatAssignment_2 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4763:1: ( rule__BitPat__BitpatAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getBitpatAssignment_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4764:1: ( rule__BitPat__BitpatAssignment_2 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=RULE_LHEXCHAR && LA46_0<=RULE_SLASH)||(LA46_0>=RULE_BINDIG && LA46_0<=RULE_PIPE)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4764:2: rule__BitPat__BitpatAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__BitPat__BitpatAssignment_2_in_rule__BitPat__Group__2__Impl9836);
            	    rule__BitPat__BitpatAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop46;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4774:1: rule__BitPat__Group__3 : rule__BitPat__Group__3__Impl ;
    public final void rule__BitPat__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4778:1: ( rule__BitPat__Group__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4779:2: rule__BitPat__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__BitPat__Group__3__Impl_in_rule__BitPat__Group__39867);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4785:1: rule__BitPat__Group__3__Impl : ( '\\'' ) ;
    public final void rule__BitPat__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4789:1: ( ( '\\'' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4790:1: ( '\\'' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4790:1: ( '\\'' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4791:1: '\\''
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getApostropheKeyword_3()); 
            }
            match(input,31,FOLLOW_31_in_rule__BitPat__Group__3__Impl9895); if (state.failed) return ;
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


    // $ANTLR start "rule__Exp__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4812:1: rule__Exp__Group_1__0 : rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 ;
    public final void rule__Exp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4816:1: ( rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4817:2: rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1
            {
            pushFollow(FOLLOW_rule__Exp__Group_1__0__Impl_in_rule__Exp__Group_1__09934);
            rule__Exp__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Exp__Group_1__1_in_rule__Exp__Group_1__09937);
            rule__Exp__Group_1__1();

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
    // $ANTLR end "rule__Exp__Group_1__0"


    // $ANTLR start "rule__Exp__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4824:1: rule__Exp__Group_1__0__Impl : ( ( rule__Exp__MidAssignment_1_0 ) ) ;
    public final void rule__Exp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4828:1: ( ( ( rule__Exp__MidAssignment_1_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4829:1: ( ( rule__Exp__MidAssignment_1_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4829:1: ( ( rule__Exp__MidAssignment_1_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4830:1: ( rule__Exp__MidAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpAccess().getMidAssignment_1_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4831:1: ( rule__Exp__MidAssignment_1_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4831:2: rule__Exp__MidAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Exp__MidAssignment_1_0_in_rule__Exp__Group_1__0__Impl9964);
            rule__Exp__MidAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpAccess().getMidAssignment_1_0()); 
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
    // $ANTLR end "rule__Exp__Group_1__0__Impl"


    // $ANTLR start "rule__Exp__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4841:1: rule__Exp__Group_1__1 : rule__Exp__Group_1__1__Impl ;
    public final void rule__Exp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4845:1: ( rule__Exp__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4846:2: rule__Exp__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Exp__Group_1__1__Impl_in_rule__Exp__Group_1__19994);
            rule__Exp__Group_1__1__Impl();

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
    // $ANTLR end "rule__Exp__Group_1__1"


    // $ANTLR start "rule__Exp__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4852:1: rule__Exp__Group_1__1__Impl : ( ( rule__Exp__CaseExpAssignment_1_1 ) ) ;
    public final void rule__Exp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4856:1: ( ( ( rule__Exp__CaseExpAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4857:1: ( ( rule__Exp__CaseExpAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4857:1: ( ( rule__Exp__CaseExpAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4858:1: ( rule__Exp__CaseExpAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpAccess().getCaseExpAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4859:1: ( rule__Exp__CaseExpAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4859:2: rule__Exp__CaseExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Exp__CaseExpAssignment_1_1_in_rule__Exp__Group_1__1__Impl10021);
            rule__Exp__CaseExpAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpAccess().getCaseExpAssignment_1_1()); 
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
    // $ANTLR end "rule__Exp__Group_1__1__Impl"


    // $ANTLR start "rule__CaseExp__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4873:1: rule__CaseExp__Group_1__0 : rule__CaseExp__Group_1__0__Impl rule__CaseExp__Group_1__1 ;
    public final void rule__CaseExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4877:1: ( rule__CaseExp__Group_1__0__Impl rule__CaseExp__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4878:2: rule__CaseExp__Group_1__0__Impl rule__CaseExp__Group_1__1
            {
            pushFollow(FOLLOW_rule__CaseExp__Group_1__0__Impl_in_rule__CaseExp__Group_1__010055);
            rule__CaseExp__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CaseExp__Group_1__1_in_rule__CaseExp__Group_1__010058);
            rule__CaseExp__Group_1__1();

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
    // $ANTLR end "rule__CaseExp__Group_1__0"


    // $ANTLR start "rule__CaseExp__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4885:1: rule__CaseExp__Group_1__0__Impl : ( 'case' ) ;
    public final void rule__CaseExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4889:1: ( ( 'case' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4890:1: ( 'case' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4890:1: ( 'case' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4891:1: 'case'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCaseExpAccess().getCaseKeyword_1_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__CaseExp__Group_1__0__Impl10086); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCaseExpAccess().getCaseKeyword_1_0()); 
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
    // $ANTLR end "rule__CaseExp__Group_1__0__Impl"


    // $ANTLR start "rule__CaseExp__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4904:1: rule__CaseExp__Group_1__1 : rule__CaseExp__Group_1__1__Impl rule__CaseExp__Group_1__2 ;
    public final void rule__CaseExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4908:1: ( rule__CaseExp__Group_1__1__Impl rule__CaseExp__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4909:2: rule__CaseExp__Group_1__1__Impl rule__CaseExp__Group_1__2
            {
            pushFollow(FOLLOW_rule__CaseExp__Group_1__1__Impl_in_rule__CaseExp__Group_1__110117);
            rule__CaseExp__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CaseExp__Group_1__2_in_rule__CaseExp__Group_1__110120);
            rule__CaseExp__Group_1__2();

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
    // $ANTLR end "rule__CaseExp__Group_1__1"


    // $ANTLR start "rule__CaseExp__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4916:1: rule__CaseExp__Group_1__1__Impl : ( ( rule__CaseExp__ClosedExpAssignment_1_1 ) ) ;
    public final void rule__CaseExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4920:1: ( ( ( rule__CaseExp__ClosedExpAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4921:1: ( ( rule__CaseExp__ClosedExpAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4921:1: ( ( rule__CaseExp__ClosedExpAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4922:1: ( rule__CaseExp__ClosedExpAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCaseExpAccess().getClosedExpAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4923:1: ( rule__CaseExp__ClosedExpAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4923:2: rule__CaseExp__ClosedExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__CaseExp__ClosedExpAssignment_1_1_in_rule__CaseExp__Group_1__1__Impl10147);
            rule__CaseExp__ClosedExpAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCaseExpAccess().getClosedExpAssignment_1_1()); 
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
    // $ANTLR end "rule__CaseExp__Group_1__1__Impl"


    // $ANTLR start "rule__CaseExp__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4933:1: rule__CaseExp__Group_1__2 : rule__CaseExp__Group_1__2__Impl rule__CaseExp__Group_1__3 ;
    public final void rule__CaseExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4937:1: ( rule__CaseExp__Group_1__2__Impl rule__CaseExp__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4938:2: rule__CaseExp__Group_1__2__Impl rule__CaseExp__Group_1__3
            {
            pushFollow(FOLLOW_rule__CaseExp__Group_1__2__Impl_in_rule__CaseExp__Group_1__210177);
            rule__CaseExp__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CaseExp__Group_1__3_in_rule__CaseExp__Group_1__210180);
            rule__CaseExp__Group_1__3();

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
    // $ANTLR end "rule__CaseExp__Group_1__2"


    // $ANTLR start "rule__CaseExp__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4945:1: rule__CaseExp__Group_1__2__Impl : ( 'of' ) ;
    public final void rule__CaseExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4949:1: ( ( 'of' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4950:1: ( 'of' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4950:1: ( 'of' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4951:1: 'of'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCaseExpAccess().getOfKeyword_1_2()); 
            }
            match(input,29,FOLLOW_29_in_rule__CaseExp__Group_1__2__Impl10208); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCaseExpAccess().getOfKeyword_1_2()); 
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
    // $ANTLR end "rule__CaseExp__Group_1__2__Impl"


    // $ANTLR start "rule__CaseExp__Group_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4964:1: rule__CaseExp__Group_1__3 : rule__CaseExp__Group_1__3__Impl rule__CaseExp__Group_1__4 ;
    public final void rule__CaseExp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4968:1: ( rule__CaseExp__Group_1__3__Impl rule__CaseExp__Group_1__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4969:2: rule__CaseExp__Group_1__3__Impl rule__CaseExp__Group_1__4
            {
            pushFollow(FOLLOW_rule__CaseExp__Group_1__3__Impl_in_rule__CaseExp__Group_1__310239);
            rule__CaseExp__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CaseExp__Group_1__4_in_rule__CaseExp__Group_1__310242);
            rule__CaseExp__Group_1__4();

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
    // $ANTLR end "rule__CaseExp__Group_1__3"


    // $ANTLR start "rule__CaseExp__Group_1__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4976:1: rule__CaseExp__Group_1__3__Impl : ( ( rule__CaseExp__CasesAssignment_1_3 ) ) ;
    public final void rule__CaseExp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4980:1: ( ( ( rule__CaseExp__CasesAssignment_1_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4981:1: ( ( rule__CaseExp__CasesAssignment_1_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4981:1: ( ( rule__CaseExp__CasesAssignment_1_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4982:1: ( rule__CaseExp__CasesAssignment_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCaseExpAccess().getCasesAssignment_1_3()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4983:1: ( rule__CaseExp__CasesAssignment_1_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4983:2: rule__CaseExp__CasesAssignment_1_3
            {
            pushFollow(FOLLOW_rule__CaseExp__CasesAssignment_1_3_in_rule__CaseExp__Group_1__3__Impl10269);
            rule__CaseExp__CasesAssignment_1_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCaseExpAccess().getCasesAssignment_1_3()); 
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
    // $ANTLR end "rule__CaseExp__Group_1__3__Impl"


    // $ANTLR start "rule__CaseExp__Group_1__4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4993:1: rule__CaseExp__Group_1__4 : rule__CaseExp__Group_1__4__Impl ;
    public final void rule__CaseExp__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4997:1: ( rule__CaseExp__Group_1__4__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:4998:2: rule__CaseExp__Group_1__4__Impl
            {
            pushFollow(FOLLOW_rule__CaseExp__Group_1__4__Impl_in_rule__CaseExp__Group_1__410299);
            rule__CaseExp__Group_1__4__Impl();

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
    // $ANTLR end "rule__CaseExp__Group_1__4"


    // $ANTLR start "rule__CaseExp__Group_1__4__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5004:1: rule__CaseExp__Group_1__4__Impl : ( 'end' ) ;
    public final void rule__CaseExp__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5008:1: ( ( 'end' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5009:1: ( 'end' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5009:1: ( 'end' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5010:1: 'end'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCaseExpAccess().getEndKeyword_1_4()); 
            }
            match(input,33,FOLLOW_33_in_rule__CaseExp__Group_1__4__Impl10327); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCaseExpAccess().getEndKeyword_1_4()); 
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
    // $ANTLR end "rule__CaseExp__Group_1__4__Impl"


    // $ANTLR start "rule__ClosedExp__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5033:1: rule__ClosedExp__Group_1__0 : rule__ClosedExp__Group_1__0__Impl rule__ClosedExp__Group_1__1 ;
    public final void rule__ClosedExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5037:1: ( rule__ClosedExp__Group_1__0__Impl rule__ClosedExp__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5038:2: rule__ClosedExp__Group_1__0__Impl rule__ClosedExp__Group_1__1
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__0__Impl_in_rule__ClosedExp__Group_1__010368);
            rule__ClosedExp__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__1_in_rule__ClosedExp__Group_1__010371);
            rule__ClosedExp__Group_1__1();

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
    // $ANTLR end "rule__ClosedExp__Group_1__0"


    // $ANTLR start "rule__ClosedExp__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5045:1: rule__ClosedExp__Group_1__0__Impl : ( 'if' ) ;
    public final void rule__ClosedExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5049:1: ( ( 'if' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5050:1: ( 'if' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5050:1: ( 'if' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5051:1: 'if'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getIfKeyword_1_0()); 
            }
            match(input,34,FOLLOW_34_in_rule__ClosedExp__Group_1__0__Impl10399); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getIfKeyword_1_0()); 
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
    // $ANTLR end "rule__ClosedExp__Group_1__0__Impl"


    // $ANTLR start "rule__ClosedExp__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5064:1: rule__ClosedExp__Group_1__1 : rule__ClosedExp__Group_1__1__Impl rule__ClosedExp__Group_1__2 ;
    public final void rule__ClosedExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5068:1: ( rule__ClosedExp__Group_1__1__Impl rule__ClosedExp__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5069:2: rule__ClosedExp__Group_1__1__Impl rule__ClosedExp__Group_1__2
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__1__Impl_in_rule__ClosedExp__Group_1__110430);
            rule__ClosedExp__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__2_in_rule__ClosedExp__Group_1__110433);
            rule__ClosedExp__Group_1__2();

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
    // $ANTLR end "rule__ClosedExp__Group_1__1"


    // $ANTLR start "rule__ClosedExp__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5076:1: rule__ClosedExp__Group_1__1__Impl : ( ( rule__ClosedExp__IfCaseExpAssignment_1_1 ) ) ;
    public final void rule__ClosedExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5080:1: ( ( ( rule__ClosedExp__IfCaseExpAssignment_1_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5081:1: ( ( rule__ClosedExp__IfCaseExpAssignment_1_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5081:1: ( ( rule__ClosedExp__IfCaseExpAssignment_1_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5082:1: ( rule__ClosedExp__IfCaseExpAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getIfCaseExpAssignment_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5083:1: ( rule__ClosedExp__IfCaseExpAssignment_1_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5083:2: rule__ClosedExp__IfCaseExpAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ClosedExp__IfCaseExpAssignment_1_1_in_rule__ClosedExp__Group_1__1__Impl10460);
            rule__ClosedExp__IfCaseExpAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getIfCaseExpAssignment_1_1()); 
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
    // $ANTLR end "rule__ClosedExp__Group_1__1__Impl"


    // $ANTLR start "rule__ClosedExp__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5093:1: rule__ClosedExp__Group_1__2 : rule__ClosedExp__Group_1__2__Impl rule__ClosedExp__Group_1__3 ;
    public final void rule__ClosedExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5097:1: ( rule__ClosedExp__Group_1__2__Impl rule__ClosedExp__Group_1__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5098:2: rule__ClosedExp__Group_1__2__Impl rule__ClosedExp__Group_1__3
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__2__Impl_in_rule__ClosedExp__Group_1__210490);
            rule__ClosedExp__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__3_in_rule__ClosedExp__Group_1__210493);
            rule__ClosedExp__Group_1__3();

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
    // $ANTLR end "rule__ClosedExp__Group_1__2"


    // $ANTLR start "rule__ClosedExp__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5105:1: rule__ClosedExp__Group_1__2__Impl : ( 'then' ) ;
    public final void rule__ClosedExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5109:1: ( ( 'then' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5110:1: ( 'then' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5110:1: ( 'then' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5111:1: 'then'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getThenKeyword_1_2()); 
            }
            match(input,35,FOLLOW_35_in_rule__ClosedExp__Group_1__2__Impl10521); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getThenKeyword_1_2()); 
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
    // $ANTLR end "rule__ClosedExp__Group_1__2__Impl"


    // $ANTLR start "rule__ClosedExp__Group_1__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5124:1: rule__ClosedExp__Group_1__3 : rule__ClosedExp__Group_1__3__Impl rule__ClosedExp__Group_1__4 ;
    public final void rule__ClosedExp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5128:1: ( rule__ClosedExp__Group_1__3__Impl rule__ClosedExp__Group_1__4 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5129:2: rule__ClosedExp__Group_1__3__Impl rule__ClosedExp__Group_1__4
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__3__Impl_in_rule__ClosedExp__Group_1__310552);
            rule__ClosedExp__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__4_in_rule__ClosedExp__Group_1__310555);
            rule__ClosedExp__Group_1__4();

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
    // $ANTLR end "rule__ClosedExp__Group_1__3"


    // $ANTLR start "rule__ClosedExp__Group_1__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5136:1: rule__ClosedExp__Group_1__3__Impl : ( ( rule__ClosedExp__ThenCaseExpAssignment_1_3 ) ) ;
    public final void rule__ClosedExp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5140:1: ( ( ( rule__ClosedExp__ThenCaseExpAssignment_1_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5141:1: ( ( rule__ClosedExp__ThenCaseExpAssignment_1_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5141:1: ( ( rule__ClosedExp__ThenCaseExpAssignment_1_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5142:1: ( rule__ClosedExp__ThenCaseExpAssignment_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getThenCaseExpAssignment_1_3()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5143:1: ( rule__ClosedExp__ThenCaseExpAssignment_1_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5143:2: rule__ClosedExp__ThenCaseExpAssignment_1_3
            {
            pushFollow(FOLLOW_rule__ClosedExp__ThenCaseExpAssignment_1_3_in_rule__ClosedExp__Group_1__3__Impl10582);
            rule__ClosedExp__ThenCaseExpAssignment_1_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getThenCaseExpAssignment_1_3()); 
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
    // $ANTLR end "rule__ClosedExp__Group_1__3__Impl"


    // $ANTLR start "rule__ClosedExp__Group_1__4"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5153:1: rule__ClosedExp__Group_1__4 : rule__ClosedExp__Group_1__4__Impl rule__ClosedExp__Group_1__5 ;
    public final void rule__ClosedExp__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5157:1: ( rule__ClosedExp__Group_1__4__Impl rule__ClosedExp__Group_1__5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5158:2: rule__ClosedExp__Group_1__4__Impl rule__ClosedExp__Group_1__5
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__4__Impl_in_rule__ClosedExp__Group_1__410612);
            rule__ClosedExp__Group_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__5_in_rule__ClosedExp__Group_1__410615);
            rule__ClosedExp__Group_1__5();

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
    // $ANTLR end "rule__ClosedExp__Group_1__4"


    // $ANTLR start "rule__ClosedExp__Group_1__4__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5165:1: rule__ClosedExp__Group_1__4__Impl : ( 'else' ) ;
    public final void rule__ClosedExp__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5169:1: ( ( 'else' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5170:1: ( 'else' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5170:1: ( 'else' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5171:1: 'else'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getElseKeyword_1_4()); 
            }
            match(input,36,FOLLOW_36_in_rule__ClosedExp__Group_1__4__Impl10643); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getElseKeyword_1_4()); 
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
    // $ANTLR end "rule__ClosedExp__Group_1__4__Impl"


    // $ANTLR start "rule__ClosedExp__Group_1__5"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5184:1: rule__ClosedExp__Group_1__5 : rule__ClosedExp__Group_1__5__Impl ;
    public final void rule__ClosedExp__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5188:1: ( rule__ClosedExp__Group_1__5__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5189:2: rule__ClosedExp__Group_1__5__Impl
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_1__5__Impl_in_rule__ClosedExp__Group_1__510674);
            rule__ClosedExp__Group_1__5__Impl();

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
    // $ANTLR end "rule__ClosedExp__Group_1__5"


    // $ANTLR start "rule__ClosedExp__Group_1__5__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5195:1: rule__ClosedExp__Group_1__5__Impl : ( ( rule__ClosedExp__ElseCaseExpAssignment_1_5 ) ) ;
    public final void rule__ClosedExp__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5199:1: ( ( ( rule__ClosedExp__ElseCaseExpAssignment_1_5 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5200:1: ( ( rule__ClosedExp__ElseCaseExpAssignment_1_5 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5200:1: ( ( rule__ClosedExp__ElseCaseExpAssignment_1_5 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5201:1: ( rule__ClosedExp__ElseCaseExpAssignment_1_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getElseCaseExpAssignment_1_5()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5202:1: ( rule__ClosedExp__ElseCaseExpAssignment_1_5 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5202:2: rule__ClosedExp__ElseCaseExpAssignment_1_5
            {
            pushFollow(FOLLOW_rule__ClosedExp__ElseCaseExpAssignment_1_5_in_rule__ClosedExp__Group_1__5__Impl10701);
            rule__ClosedExp__ElseCaseExpAssignment_1_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getElseCaseExpAssignment_1_5()); 
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
    // $ANTLR end "rule__ClosedExp__Group_1__5__Impl"


    // $ANTLR start "rule__ClosedExp__Group_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5224:1: rule__ClosedExp__Group_2__0 : rule__ClosedExp__Group_2__0__Impl rule__ClosedExp__Group_2__1 ;
    public final void rule__ClosedExp__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5228:1: ( rule__ClosedExp__Group_2__0__Impl rule__ClosedExp__Group_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5229:2: rule__ClosedExp__Group_2__0__Impl rule__ClosedExp__Group_2__1
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_2__0__Impl_in_rule__ClosedExp__Group_2__010743);
            rule__ClosedExp__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ClosedExp__Group_2__1_in_rule__ClosedExp__Group_2__010746);
            rule__ClosedExp__Group_2__1();

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
    // $ANTLR end "rule__ClosedExp__Group_2__0"


    // $ANTLR start "rule__ClosedExp__Group_2__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5236:1: rule__ClosedExp__Group_2__0__Impl : ( 'do' ) ;
    public final void rule__ClosedExp__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5240:1: ( ( 'do' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5241:1: ( 'do' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5241:1: ( 'do' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5242:1: 'do'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getDoKeyword_2_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__ClosedExp__Group_2__0__Impl10774); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getDoKeyword_2_0()); 
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
    // $ANTLR end "rule__ClosedExp__Group_2__0__Impl"


    // $ANTLR start "rule__ClosedExp__Group_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5255:1: rule__ClosedExp__Group_2__1 : rule__ClosedExp__Group_2__1__Impl rule__ClosedExp__Group_2__2 ;
    public final void rule__ClosedExp__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5259:1: ( rule__ClosedExp__Group_2__1__Impl rule__ClosedExp__Group_2__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5260:2: rule__ClosedExp__Group_2__1__Impl rule__ClosedExp__Group_2__2
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_2__1__Impl_in_rule__ClosedExp__Group_2__110805);
            rule__ClosedExp__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ClosedExp__Group_2__2_in_rule__ClosedExp__Group_2__110808);
            rule__ClosedExp__Group_2__2();

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
    // $ANTLR end "rule__ClosedExp__Group_2__1"


    // $ANTLR start "rule__ClosedExp__Group_2__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5267:1: rule__ClosedExp__Group_2__1__Impl : ( ( rule__ClosedExp__DoExpAssignment_2_1 ) ) ;
    public final void rule__ClosedExp__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5271:1: ( ( ( rule__ClosedExp__DoExpAssignment_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5272:1: ( ( rule__ClosedExp__DoExpAssignment_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5272:1: ( ( rule__ClosedExp__DoExpAssignment_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5273:1: ( rule__ClosedExp__DoExpAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getDoExpAssignment_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5274:1: ( rule__ClosedExp__DoExpAssignment_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5274:2: rule__ClosedExp__DoExpAssignment_2_1
            {
            pushFollow(FOLLOW_rule__ClosedExp__DoExpAssignment_2_1_in_rule__ClosedExp__Group_2__1__Impl10835);
            rule__ClosedExp__DoExpAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getDoExpAssignment_2_1()); 
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
    // $ANTLR end "rule__ClosedExp__Group_2__1__Impl"


    // $ANTLR start "rule__ClosedExp__Group_2__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5284:1: rule__ClosedExp__Group_2__2 : rule__ClosedExp__Group_2__2__Impl rule__ClosedExp__Group_2__3 ;
    public final void rule__ClosedExp__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5288:1: ( rule__ClosedExp__Group_2__2__Impl rule__ClosedExp__Group_2__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5289:2: rule__ClosedExp__Group_2__2__Impl rule__ClosedExp__Group_2__3
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_2__2__Impl_in_rule__ClosedExp__Group_2__210865);
            rule__ClosedExp__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ClosedExp__Group_2__3_in_rule__ClosedExp__Group_2__210868);
            rule__ClosedExp__Group_2__3();

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
    // $ANTLR end "rule__ClosedExp__Group_2__2"


    // $ANTLR start "rule__ClosedExp__Group_2__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5296:1: rule__ClosedExp__Group_2__2__Impl : ( ( rule__ClosedExp__Group_2_2__0 )* ) ;
    public final void rule__ClosedExp__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5300:1: ( ( ( rule__ClosedExp__Group_2_2__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5301:1: ( ( rule__ClosedExp__Group_2_2__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5301:1: ( ( rule__ClosedExp__Group_2_2__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5302:1: ( rule__ClosedExp__Group_2_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getGroup_2_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5303:1: ( rule__ClosedExp__Group_2_2__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==20) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5303:2: rule__ClosedExp__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__ClosedExp__Group_2_2__0_in_rule__ClosedExp__Group_2__2__Impl10895);
            	    rule__ClosedExp__Group_2_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getGroup_2_2()); 
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
    // $ANTLR end "rule__ClosedExp__Group_2__2__Impl"


    // $ANTLR start "rule__ClosedExp__Group_2__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5313:1: rule__ClosedExp__Group_2__3 : rule__ClosedExp__Group_2__3__Impl ;
    public final void rule__ClosedExp__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5317:1: ( rule__ClosedExp__Group_2__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5318:2: rule__ClosedExp__Group_2__3__Impl
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_2__3__Impl_in_rule__ClosedExp__Group_2__310926);
            rule__ClosedExp__Group_2__3__Impl();

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
    // $ANTLR end "rule__ClosedExp__Group_2__3"


    // $ANTLR start "rule__ClosedExp__Group_2__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5324:1: rule__ClosedExp__Group_2__3__Impl : ( 'end' ) ;
    public final void rule__ClosedExp__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5328:1: ( ( 'end' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5329:1: ( 'end' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5329:1: ( 'end' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5330:1: 'end'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getEndKeyword_2_3()); 
            }
            match(input,33,FOLLOW_33_in_rule__ClosedExp__Group_2__3__Impl10954); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getEndKeyword_2_3()); 
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
    // $ANTLR end "rule__ClosedExp__Group_2__3__Impl"


    // $ANTLR start "rule__ClosedExp__Group_2_2__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5351:1: rule__ClosedExp__Group_2_2__0 : rule__ClosedExp__Group_2_2__0__Impl rule__ClosedExp__Group_2_2__1 ;
    public final void rule__ClosedExp__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5355:1: ( rule__ClosedExp__Group_2_2__0__Impl rule__ClosedExp__Group_2_2__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5356:2: rule__ClosedExp__Group_2_2__0__Impl rule__ClosedExp__Group_2_2__1
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_2_2__0__Impl_in_rule__ClosedExp__Group_2_2__010993);
            rule__ClosedExp__Group_2_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ClosedExp__Group_2_2__1_in_rule__ClosedExp__Group_2_2__010996);
            rule__ClosedExp__Group_2_2__1();

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
    // $ANTLR end "rule__ClosedExp__Group_2_2__0"


    // $ANTLR start "rule__ClosedExp__Group_2_2__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5363:1: rule__ClosedExp__Group_2_2__0__Impl : ( ';' ) ;
    public final void rule__ClosedExp__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5367:1: ( ( ';' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5368:1: ( ';' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5368:1: ( ';' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5369:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getSemicolonKeyword_2_2_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__ClosedExp__Group_2_2__0__Impl11024); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getSemicolonKeyword_2_2_0()); 
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
    // $ANTLR end "rule__ClosedExp__Group_2_2__0__Impl"


    // $ANTLR start "rule__ClosedExp__Group_2_2__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5382:1: rule__ClosedExp__Group_2_2__1 : rule__ClosedExp__Group_2_2__1__Impl ;
    public final void rule__ClosedExp__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5386:1: ( rule__ClosedExp__Group_2_2__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5387:2: rule__ClosedExp__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ClosedExp__Group_2_2__1__Impl_in_rule__ClosedExp__Group_2_2__111055);
            rule__ClosedExp__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__ClosedExp__Group_2_2__1"


    // $ANTLR start "rule__ClosedExp__Group_2_2__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5393:1: rule__ClosedExp__Group_2_2__1__Impl : ( ( rule__ClosedExp__DoExpAssignment_2_2_1 ) ) ;
    public final void rule__ClosedExp__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5397:1: ( ( ( rule__ClosedExp__DoExpAssignment_2_2_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5398:1: ( ( rule__ClosedExp__DoExpAssignment_2_2_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5398:1: ( ( rule__ClosedExp__DoExpAssignment_2_2_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5399:1: ( rule__ClosedExp__DoExpAssignment_2_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getDoExpAssignment_2_2_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5400:1: ( rule__ClosedExp__DoExpAssignment_2_2_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5400:2: rule__ClosedExp__DoExpAssignment_2_2_1
            {
            pushFollow(FOLLOW_rule__ClosedExp__DoExpAssignment_2_2_1_in_rule__ClosedExp__Group_2_2__1__Impl11082);
            rule__ClosedExp__DoExpAssignment_2_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getDoExpAssignment_2_2_1()); 
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
    // $ANTLR end "rule__ClosedExp__Group_2_2__1__Impl"


    // $ANTLR start "rule__MonadicExp__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5414:1: rule__MonadicExp__Group_1__0 : rule__MonadicExp__Group_1__0__Impl rule__MonadicExp__Group_1__1 ;
    public final void rule__MonadicExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5418:1: ( rule__MonadicExp__Group_1__0__Impl rule__MonadicExp__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5419:2: rule__MonadicExp__Group_1__0__Impl rule__MonadicExp__Group_1__1
            {
            pushFollow(FOLLOW_rule__MonadicExp__Group_1__0__Impl_in_rule__MonadicExp__Group_1__011116);
            rule__MonadicExp__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MonadicExp__Group_1__1_in_rule__MonadicExp__Group_1__011119);
            rule__MonadicExp__Group_1__1();

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
    // $ANTLR end "rule__MonadicExp__Group_1__0"


    // $ANTLR start "rule__MonadicExp__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5426:1: rule__MonadicExp__Group_1__0__Impl : ( ( rule__MonadicExp__NameAssignment_1_0 ) ) ;
    public final void rule__MonadicExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5430:1: ( ( ( rule__MonadicExp__NameAssignment_1_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5431:1: ( ( rule__MonadicExp__NameAssignment_1_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5431:1: ( ( rule__MonadicExp__NameAssignment_1_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5432:1: ( rule__MonadicExp__NameAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMonadicExpAccess().getNameAssignment_1_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5433:1: ( rule__MonadicExp__NameAssignment_1_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5433:2: rule__MonadicExp__NameAssignment_1_0
            {
            pushFollow(FOLLOW_rule__MonadicExp__NameAssignment_1_0_in_rule__MonadicExp__Group_1__0__Impl11146);
            rule__MonadicExp__NameAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMonadicExpAccess().getNameAssignment_1_0()); 
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
    // $ANTLR end "rule__MonadicExp__Group_1__0__Impl"


    // $ANTLR start "rule__MonadicExp__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5443:1: rule__MonadicExp__Group_1__1 : rule__MonadicExp__Group_1__1__Impl rule__MonadicExp__Group_1__2 ;
    public final void rule__MonadicExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5447:1: ( rule__MonadicExp__Group_1__1__Impl rule__MonadicExp__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5448:2: rule__MonadicExp__Group_1__1__Impl rule__MonadicExp__Group_1__2
            {
            pushFollow(FOLLOW_rule__MonadicExp__Group_1__1__Impl_in_rule__MonadicExp__Group_1__111176);
            rule__MonadicExp__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MonadicExp__Group_1__2_in_rule__MonadicExp__Group_1__111179);
            rule__MonadicExp__Group_1__2();

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
    // $ANTLR end "rule__MonadicExp__Group_1__1"


    // $ANTLR start "rule__MonadicExp__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5455:1: rule__MonadicExp__Group_1__1__Impl : ( '<-' ) ;
    public final void rule__MonadicExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5459:1: ( ( '<-' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5460:1: ( '<-' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5460:1: ( '<-' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5461:1: '<-'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMonadicExpAccess().getLessThanSignHyphenMinusKeyword_1_1()); 
            }
            match(input,38,FOLLOW_38_in_rule__MonadicExp__Group_1__1__Impl11207); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMonadicExpAccess().getLessThanSignHyphenMinusKeyword_1_1()); 
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
    // $ANTLR end "rule__MonadicExp__Group_1__1__Impl"


    // $ANTLR start "rule__MonadicExp__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5474:1: rule__MonadicExp__Group_1__2 : rule__MonadicExp__Group_1__2__Impl ;
    public final void rule__MonadicExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5478:1: ( rule__MonadicExp__Group_1__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5479:2: rule__MonadicExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__MonadicExp__Group_1__2__Impl_in_rule__MonadicExp__Group_1__211238);
            rule__MonadicExp__Group_1__2__Impl();

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
    // $ANTLR end "rule__MonadicExp__Group_1__2"


    // $ANTLR start "rule__MonadicExp__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5485:1: rule__MonadicExp__Group_1__2__Impl : ( ( rule__MonadicExp__ExpAssignment_1_2 ) ) ;
    public final void rule__MonadicExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5489:1: ( ( ( rule__MonadicExp__ExpAssignment_1_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5490:1: ( ( rule__MonadicExp__ExpAssignment_1_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5490:1: ( ( rule__MonadicExp__ExpAssignment_1_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5491:1: ( rule__MonadicExp__ExpAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMonadicExpAccess().getExpAssignment_1_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5492:1: ( rule__MonadicExp__ExpAssignment_1_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5492:2: rule__MonadicExp__ExpAssignment_1_2
            {
            pushFollow(FOLLOW_rule__MonadicExp__ExpAssignment_1_2_in_rule__MonadicExp__Group_1__2__Impl11265);
            rule__MonadicExp__ExpAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMonadicExpAccess().getExpAssignment_1_2()); 
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
    // $ANTLR end "rule__MonadicExp__Group_1__2__Impl"


    // $ANTLR start "rule__Cases__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5508:1: rule__Cases__Group__0 : rule__Cases__Group__0__Impl rule__Cases__Group__1 ;
    public final void rule__Cases__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5512:1: ( rule__Cases__Group__0__Impl rule__Cases__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5513:2: rule__Cases__Group__0__Impl rule__Cases__Group__1
            {
            pushFollow(FOLLOW_rule__Cases__Group__0__Impl_in_rule__Cases__Group__011301);
            rule__Cases__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Cases__Group__1_in_rule__Cases__Group__011304);
            rule__Cases__Group__1();

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
    // $ANTLR end "rule__Cases__Group__0"


    // $ANTLR start "rule__Cases__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5520:1: rule__Cases__Group__0__Impl : ( ( rule__Cases__PatAssignment_0 ) ) ;
    public final void rule__Cases__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5524:1: ( ( ( rule__Cases__PatAssignment_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5525:1: ( ( rule__Cases__PatAssignment_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5525:1: ( ( rule__Cases__PatAssignment_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5526:1: ( rule__Cases__PatAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getPatAssignment_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5527:1: ( rule__Cases__PatAssignment_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5527:2: rule__Cases__PatAssignment_0
            {
            pushFollow(FOLLOW_rule__Cases__PatAssignment_0_in_rule__Cases__Group__0__Impl11331);
            rule__Cases__PatAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getPatAssignment_0()); 
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
    // $ANTLR end "rule__Cases__Group__0__Impl"


    // $ANTLR start "rule__Cases__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5537:1: rule__Cases__Group__1 : rule__Cases__Group__1__Impl rule__Cases__Group__2 ;
    public final void rule__Cases__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5541:1: ( rule__Cases__Group__1__Impl rule__Cases__Group__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5542:2: rule__Cases__Group__1__Impl rule__Cases__Group__2
            {
            pushFollow(FOLLOW_rule__Cases__Group__1__Impl_in_rule__Cases__Group__111361);
            rule__Cases__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Cases__Group__2_in_rule__Cases__Group__111364);
            rule__Cases__Group__2();

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
    // $ANTLR end "rule__Cases__Group__1"


    // $ANTLR start "rule__Cases__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5549:1: rule__Cases__Group__1__Impl : ( ':' ) ;
    public final void rule__Cases__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5553:1: ( ( ':' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5554:1: ( ':' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5554:1: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5555:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getColonKeyword_1()); 
            }
            match(input,30,FOLLOW_30_in_rule__Cases__Group__1__Impl11392); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getColonKeyword_1()); 
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
    // $ANTLR end "rule__Cases__Group__1__Impl"


    // $ANTLR start "rule__Cases__Group__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5568:1: rule__Cases__Group__2 : rule__Cases__Group__2__Impl rule__Cases__Group__3 ;
    public final void rule__Cases__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5572:1: ( rule__Cases__Group__2__Impl rule__Cases__Group__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5573:2: rule__Cases__Group__2__Impl rule__Cases__Group__3
            {
            pushFollow(FOLLOW_rule__Cases__Group__2__Impl_in_rule__Cases__Group__211423);
            rule__Cases__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Cases__Group__3_in_rule__Cases__Group__211426);
            rule__Cases__Group__3();

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
    // $ANTLR end "rule__Cases__Group__2"


    // $ANTLR start "rule__Cases__Group__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5580:1: rule__Cases__Group__2__Impl : ( ( rule__Cases__ExpAssignment_2 ) ) ;
    public final void rule__Cases__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5584:1: ( ( ( rule__Cases__ExpAssignment_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5585:1: ( ( rule__Cases__ExpAssignment_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5585:1: ( ( rule__Cases__ExpAssignment_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5586:1: ( rule__Cases__ExpAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getExpAssignment_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5587:1: ( rule__Cases__ExpAssignment_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5587:2: rule__Cases__ExpAssignment_2
            {
            pushFollow(FOLLOW_rule__Cases__ExpAssignment_2_in_rule__Cases__Group__2__Impl11453);
            rule__Cases__ExpAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getExpAssignment_2()); 
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
    // $ANTLR end "rule__Cases__Group__2__Impl"


    // $ANTLR start "rule__Cases__Group__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5597:1: rule__Cases__Group__3 : rule__Cases__Group__3__Impl ;
    public final void rule__Cases__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5601:1: ( rule__Cases__Group__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5602:2: rule__Cases__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Cases__Group__3__Impl_in_rule__Cases__Group__311483);
            rule__Cases__Group__3__Impl();

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
    // $ANTLR end "rule__Cases__Group__3"


    // $ANTLR start "rule__Cases__Group__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5608:1: rule__Cases__Group__3__Impl : ( ( rule__Cases__Group_3__0 )* ) ;
    public final void rule__Cases__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5612:1: ( ( ( rule__Cases__Group_3__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5613:1: ( ( rule__Cases__Group_3__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5613:1: ( ( rule__Cases__Group_3__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5614:1: ( rule__Cases__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getGroup_3()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5615:1: ( rule__Cases__Group_3__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_PIPE) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5615:2: rule__Cases__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Cases__Group_3__0_in_rule__Cases__Group__3__Impl11510);
            	    rule__Cases__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getGroup_3()); 
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
    // $ANTLR end "rule__Cases__Group__3__Impl"


    // $ANTLR start "rule__Cases__Group_3__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5633:1: rule__Cases__Group_3__0 : rule__Cases__Group_3__0__Impl rule__Cases__Group_3__1 ;
    public final void rule__Cases__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5637:1: ( rule__Cases__Group_3__0__Impl rule__Cases__Group_3__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5638:2: rule__Cases__Group_3__0__Impl rule__Cases__Group_3__1
            {
            pushFollow(FOLLOW_rule__Cases__Group_3__0__Impl_in_rule__Cases__Group_3__011549);
            rule__Cases__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Cases__Group_3__1_in_rule__Cases__Group_3__011552);
            rule__Cases__Group_3__1();

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
    // $ANTLR end "rule__Cases__Group_3__0"


    // $ANTLR start "rule__Cases__Group_3__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5645:1: rule__Cases__Group_3__0__Impl : ( RULE_PIPE ) ;
    public final void rule__Cases__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5649:1: ( ( RULE_PIPE ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5650:1: ( RULE_PIPE )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5650:1: ( RULE_PIPE )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5651:1: RULE_PIPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getPIPETerminalRuleCall_3_0()); 
            }
            match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_rule__Cases__Group_3__0__Impl11579); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getPIPETerminalRuleCall_3_0()); 
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
    // $ANTLR end "rule__Cases__Group_3__0__Impl"


    // $ANTLR start "rule__Cases__Group_3__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5662:1: rule__Cases__Group_3__1 : rule__Cases__Group_3__1__Impl rule__Cases__Group_3__2 ;
    public final void rule__Cases__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5666:1: ( rule__Cases__Group_3__1__Impl rule__Cases__Group_3__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5667:2: rule__Cases__Group_3__1__Impl rule__Cases__Group_3__2
            {
            pushFollow(FOLLOW_rule__Cases__Group_3__1__Impl_in_rule__Cases__Group_3__111608);
            rule__Cases__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Cases__Group_3__2_in_rule__Cases__Group_3__111611);
            rule__Cases__Group_3__2();

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
    // $ANTLR end "rule__Cases__Group_3__1"


    // $ANTLR start "rule__Cases__Group_3__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5674:1: rule__Cases__Group_3__1__Impl : ( ( rule__Cases__PatAssignment_3_1 ) ) ;
    public final void rule__Cases__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5678:1: ( ( ( rule__Cases__PatAssignment_3_1 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5679:1: ( ( rule__Cases__PatAssignment_3_1 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5679:1: ( ( rule__Cases__PatAssignment_3_1 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5680:1: ( rule__Cases__PatAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getPatAssignment_3_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5681:1: ( rule__Cases__PatAssignment_3_1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5681:2: rule__Cases__PatAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Cases__PatAssignment_3_1_in_rule__Cases__Group_3__1__Impl11638);
            rule__Cases__PatAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getPatAssignment_3_1()); 
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
    // $ANTLR end "rule__Cases__Group_3__1__Impl"


    // $ANTLR start "rule__Cases__Group_3__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5691:1: rule__Cases__Group_3__2 : rule__Cases__Group_3__2__Impl rule__Cases__Group_3__3 ;
    public final void rule__Cases__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5695:1: ( rule__Cases__Group_3__2__Impl rule__Cases__Group_3__3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5696:2: rule__Cases__Group_3__2__Impl rule__Cases__Group_3__3
            {
            pushFollow(FOLLOW_rule__Cases__Group_3__2__Impl_in_rule__Cases__Group_3__211668);
            rule__Cases__Group_3__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Cases__Group_3__3_in_rule__Cases__Group_3__211671);
            rule__Cases__Group_3__3();

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
    // $ANTLR end "rule__Cases__Group_3__2"


    // $ANTLR start "rule__Cases__Group_3__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5703:1: rule__Cases__Group_3__2__Impl : ( ':' ) ;
    public final void rule__Cases__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5707:1: ( ( ':' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5708:1: ( ':' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5708:1: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5709:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getColonKeyword_3_2()); 
            }
            match(input,30,FOLLOW_30_in_rule__Cases__Group_3__2__Impl11699); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getColonKeyword_3_2()); 
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
    // $ANTLR end "rule__Cases__Group_3__2__Impl"


    // $ANTLR start "rule__Cases__Group_3__3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5722:1: rule__Cases__Group_3__3 : rule__Cases__Group_3__3__Impl ;
    public final void rule__Cases__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5726:1: ( rule__Cases__Group_3__3__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5727:2: rule__Cases__Group_3__3__Impl
            {
            pushFollow(FOLLOW_rule__Cases__Group_3__3__Impl_in_rule__Cases__Group_3__311730);
            rule__Cases__Group_3__3__Impl();

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
    // $ANTLR end "rule__Cases__Group_3__3"


    // $ANTLR start "rule__Cases__Group_3__3__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5733:1: rule__Cases__Group_3__3__Impl : ( ( rule__Cases__ExpAssignment_3_3 ) ) ;
    public final void rule__Cases__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5737:1: ( ( ( rule__Cases__ExpAssignment_3_3 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5738:1: ( ( rule__Cases__ExpAssignment_3_3 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5738:1: ( ( rule__Cases__ExpAssignment_3_3 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5739:1: ( rule__Cases__ExpAssignment_3_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getExpAssignment_3_3()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5740:1: ( rule__Cases__ExpAssignment_3_3 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5740:2: rule__Cases__ExpAssignment_3_3
            {
            pushFollow(FOLLOW_rule__Cases__ExpAssignment_3_3_in_rule__Cases__Group_3__3__Impl11757);
            rule__Cases__ExpAssignment_3_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getExpAssignment_3_3()); 
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
    // $ANTLR end "rule__Cases__Group_3__3__Impl"


    // $ANTLR start "rule__OrElseExp__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5758:1: rule__OrElseExp__Group__0 : rule__OrElseExp__Group__0__Impl rule__OrElseExp__Group__1 ;
    public final void rule__OrElseExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5762:1: ( rule__OrElseExp__Group__0__Impl rule__OrElseExp__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5763:2: rule__OrElseExp__Group__0__Impl rule__OrElseExp__Group__1
            {
            pushFollow(FOLLOW_rule__OrElseExp__Group__0__Impl_in_rule__OrElseExp__Group__011795);
            rule__OrElseExp__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__OrElseExp__Group__1_in_rule__OrElseExp__Group__011798);
            rule__OrElseExp__Group__1();

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
    // $ANTLR end "rule__OrElseExp__Group__0"


    // $ANTLR start "rule__OrElseExp__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5770:1: rule__OrElseExp__Group__0__Impl : ( ruleAndAlsoExp ) ;
    public final void rule__OrElseExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5774:1: ( ( ruleAndAlsoExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5775:1: ( ruleAndAlsoExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5775:1: ( ruleAndAlsoExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5776:1: ruleAndAlsoExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrElseExpAccess().getAndAlsoExpParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_rule__OrElseExp__Group__0__Impl11825);
            ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrElseExpAccess().getAndAlsoExpParserRuleCall_0()); 
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
    // $ANTLR end "rule__OrElseExp__Group__0__Impl"


    // $ANTLR start "rule__OrElseExp__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5787:1: rule__OrElseExp__Group__1 : rule__OrElseExp__Group__1__Impl ;
    public final void rule__OrElseExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5791:1: ( rule__OrElseExp__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5792:2: rule__OrElseExp__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__OrElseExp__Group__1__Impl_in_rule__OrElseExp__Group__111854);
            rule__OrElseExp__Group__1__Impl();

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
    // $ANTLR end "rule__OrElseExp__Group__1"


    // $ANTLR start "rule__OrElseExp__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5798:1: rule__OrElseExp__Group__1__Impl : ( ( rule__OrElseExp__Group_1__0 )* ) ;
    public final void rule__OrElseExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5802:1: ( ( ( rule__OrElseExp__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5803:1: ( ( rule__OrElseExp__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5803:1: ( ( rule__OrElseExp__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5804:1: ( rule__OrElseExp__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrElseExpAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5805:1: ( rule__OrElseExp__Group_1__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==39) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5805:2: rule__OrElseExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__OrElseExp__Group_1__0_in_rule__OrElseExp__Group__1__Impl11881);
            	    rule__OrElseExp__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrElseExpAccess().getGroup_1()); 
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
    // $ANTLR end "rule__OrElseExp__Group__1__Impl"


    // $ANTLR start "rule__OrElseExp__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5819:1: rule__OrElseExp__Group_1__0 : rule__OrElseExp__Group_1__0__Impl rule__OrElseExp__Group_1__1 ;
    public final void rule__OrElseExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5823:1: ( rule__OrElseExp__Group_1__0__Impl rule__OrElseExp__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5824:2: rule__OrElseExp__Group_1__0__Impl rule__OrElseExp__Group_1__1
            {
            pushFollow(FOLLOW_rule__OrElseExp__Group_1__0__Impl_in_rule__OrElseExp__Group_1__011916);
            rule__OrElseExp__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__OrElseExp__Group_1__1_in_rule__OrElseExp__Group_1__011919);
            rule__OrElseExp__Group_1__1();

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
    // $ANTLR end "rule__OrElseExp__Group_1__0"


    // $ANTLR start "rule__OrElseExp__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5831:1: rule__OrElseExp__Group_1__0__Impl : ( () ) ;
    public final void rule__OrElseExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5835:1: ( ( () ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5836:1: ( () )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5836:1: ( () )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5837:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5838:1: ()
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5840:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrElseExp__Group_1__0__Impl"


    // $ANTLR start "rule__OrElseExp__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5850:1: rule__OrElseExp__Group_1__1 : rule__OrElseExp__Group_1__1__Impl rule__OrElseExp__Group_1__2 ;
    public final void rule__OrElseExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5854:1: ( rule__OrElseExp__Group_1__1__Impl rule__OrElseExp__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5855:2: rule__OrElseExp__Group_1__1__Impl rule__OrElseExp__Group_1__2
            {
            pushFollow(FOLLOW_rule__OrElseExp__Group_1__1__Impl_in_rule__OrElseExp__Group_1__111977);
            rule__OrElseExp__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__OrElseExp__Group_1__2_in_rule__OrElseExp__Group_1__111980);
            rule__OrElseExp__Group_1__2();

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
    // $ANTLR end "rule__OrElseExp__Group_1__1"


    // $ANTLR start "rule__OrElseExp__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5862:1: rule__OrElseExp__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__OrElseExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5866:1: ( ( 'or' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5867:1: ( 'or' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5867:1: ( 'or' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5868:1: 'or'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrElseExpAccess().getOrKeyword_1_1()); 
            }
            match(input,39,FOLLOW_39_in_rule__OrElseExp__Group_1__1__Impl12008); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrElseExpAccess().getOrKeyword_1_1()); 
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
    // $ANTLR end "rule__OrElseExp__Group_1__1__Impl"


    // $ANTLR start "rule__OrElseExp__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5881:1: rule__OrElseExp__Group_1__2 : rule__OrElseExp__Group_1__2__Impl ;
    public final void rule__OrElseExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5885:1: ( rule__OrElseExp__Group_1__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5886:2: rule__OrElseExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__OrElseExp__Group_1__2__Impl_in_rule__OrElseExp__Group_1__212039);
            rule__OrElseExp__Group_1__2__Impl();

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
    // $ANTLR end "rule__OrElseExp__Group_1__2"


    // $ANTLR start "rule__OrElseExp__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5892:1: rule__OrElseExp__Group_1__2__Impl : ( ( rule__OrElseExp__RightAssignment_1_2 ) ) ;
    public final void rule__OrElseExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5896:1: ( ( ( rule__OrElseExp__RightAssignment_1_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5897:1: ( ( rule__OrElseExp__RightAssignment_1_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5897:1: ( ( rule__OrElseExp__RightAssignment_1_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5898:1: ( rule__OrElseExp__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrElseExpAccess().getRightAssignment_1_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5899:1: ( rule__OrElseExp__RightAssignment_1_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5899:2: rule__OrElseExp__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__OrElseExp__RightAssignment_1_2_in_rule__OrElseExp__Group_1__2__Impl12066);
            rule__OrElseExp__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrElseExpAccess().getRightAssignment_1_2()); 
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
    // $ANTLR end "rule__OrElseExp__Group_1__2__Impl"


    // $ANTLR start "rule__AndAlsoExp__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5915:1: rule__AndAlsoExp__Group__0 : rule__AndAlsoExp__Group__0__Impl rule__AndAlsoExp__Group__1 ;
    public final void rule__AndAlsoExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5919:1: ( rule__AndAlsoExp__Group__0__Impl rule__AndAlsoExp__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5920:2: rule__AndAlsoExp__Group__0__Impl rule__AndAlsoExp__Group__1
            {
            pushFollow(FOLLOW_rule__AndAlsoExp__Group__0__Impl_in_rule__AndAlsoExp__Group__012102);
            rule__AndAlsoExp__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AndAlsoExp__Group__1_in_rule__AndAlsoExp__Group__012105);
            rule__AndAlsoExp__Group__1();

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
    // $ANTLR end "rule__AndAlsoExp__Group__0"


    // $ANTLR start "rule__AndAlsoExp__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5927:1: rule__AndAlsoExp__Group__0__Impl : ( ruleRExp ) ;
    public final void rule__AndAlsoExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5931:1: ( ( ruleRExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5932:1: ( ruleRExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5932:1: ( ruleRExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5933:1: ruleRExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAlsoExpAccess().getRExpParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleRExp_in_rule__AndAlsoExp__Group__0__Impl12132);
            ruleRExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAlsoExpAccess().getRExpParserRuleCall_0()); 
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
    // $ANTLR end "rule__AndAlsoExp__Group__0__Impl"


    // $ANTLR start "rule__AndAlsoExp__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5944:1: rule__AndAlsoExp__Group__1 : rule__AndAlsoExp__Group__1__Impl ;
    public final void rule__AndAlsoExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5948:1: ( rule__AndAlsoExp__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5949:2: rule__AndAlsoExp__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AndAlsoExp__Group__1__Impl_in_rule__AndAlsoExp__Group__112161);
            rule__AndAlsoExp__Group__1__Impl();

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
    // $ANTLR end "rule__AndAlsoExp__Group__1"


    // $ANTLR start "rule__AndAlsoExp__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5955:1: rule__AndAlsoExp__Group__1__Impl : ( ( rule__AndAlsoExp__Group_1__0 )* ) ;
    public final void rule__AndAlsoExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5959:1: ( ( ( rule__AndAlsoExp__Group_1__0 )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5960:1: ( ( rule__AndAlsoExp__Group_1__0 )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5960:1: ( ( rule__AndAlsoExp__Group_1__0 )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5961:1: ( rule__AndAlsoExp__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAlsoExpAccess().getGroup_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5962:1: ( rule__AndAlsoExp__Group_1__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==40) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5962:2: rule__AndAlsoExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndAlsoExp__Group_1__0_in_rule__AndAlsoExp__Group__1__Impl12188);
            	    rule__AndAlsoExp__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAlsoExpAccess().getGroup_1()); 
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
    // $ANTLR end "rule__AndAlsoExp__Group__1__Impl"


    // $ANTLR start "rule__AndAlsoExp__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5976:1: rule__AndAlsoExp__Group_1__0 : rule__AndAlsoExp__Group_1__0__Impl rule__AndAlsoExp__Group_1__1 ;
    public final void rule__AndAlsoExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5980:1: ( rule__AndAlsoExp__Group_1__0__Impl rule__AndAlsoExp__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5981:2: rule__AndAlsoExp__Group_1__0__Impl rule__AndAlsoExp__Group_1__1
            {
            pushFollow(FOLLOW_rule__AndAlsoExp__Group_1__0__Impl_in_rule__AndAlsoExp__Group_1__012223);
            rule__AndAlsoExp__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AndAlsoExp__Group_1__1_in_rule__AndAlsoExp__Group_1__012226);
            rule__AndAlsoExp__Group_1__1();

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
    // $ANTLR end "rule__AndAlsoExp__Group_1__0"


    // $ANTLR start "rule__AndAlsoExp__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5988:1: rule__AndAlsoExp__Group_1__0__Impl : ( () ) ;
    public final void rule__AndAlsoExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5992:1: ( ( () ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5993:1: ( () )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5993:1: ( () )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5994:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5995:1: ()
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5997:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndAlsoExp__Group_1__0__Impl"


    // $ANTLR start "rule__AndAlsoExp__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6007:1: rule__AndAlsoExp__Group_1__1 : rule__AndAlsoExp__Group_1__1__Impl rule__AndAlsoExp__Group_1__2 ;
    public final void rule__AndAlsoExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6011:1: ( rule__AndAlsoExp__Group_1__1__Impl rule__AndAlsoExp__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6012:2: rule__AndAlsoExp__Group_1__1__Impl rule__AndAlsoExp__Group_1__2
            {
            pushFollow(FOLLOW_rule__AndAlsoExp__Group_1__1__Impl_in_rule__AndAlsoExp__Group_1__112284);
            rule__AndAlsoExp__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AndAlsoExp__Group_1__2_in_rule__AndAlsoExp__Group_1__112287);
            rule__AndAlsoExp__Group_1__2();

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
    // $ANTLR end "rule__AndAlsoExp__Group_1__1"


    // $ANTLR start "rule__AndAlsoExp__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6019:1: rule__AndAlsoExp__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__AndAlsoExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6023:1: ( ( 'and' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6024:1: ( 'and' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6024:1: ( 'and' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6025:1: 'and'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAlsoExpAccess().getAndKeyword_1_1()); 
            }
            match(input,40,FOLLOW_40_in_rule__AndAlsoExp__Group_1__1__Impl12315); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAlsoExpAccess().getAndKeyword_1_1()); 
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
    // $ANTLR end "rule__AndAlsoExp__Group_1__1__Impl"


    // $ANTLR start "rule__AndAlsoExp__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6038:1: rule__AndAlsoExp__Group_1__2 : rule__AndAlsoExp__Group_1__2__Impl ;
    public final void rule__AndAlsoExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6042:1: ( rule__AndAlsoExp__Group_1__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6043:2: rule__AndAlsoExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__AndAlsoExp__Group_1__2__Impl_in_rule__AndAlsoExp__Group_1__212346);
            rule__AndAlsoExp__Group_1__2__Impl();

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
    // $ANTLR end "rule__AndAlsoExp__Group_1__2"


    // $ANTLR start "rule__AndAlsoExp__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6049:1: rule__AndAlsoExp__Group_1__2__Impl : ( ( rule__AndAlsoExp__RightAssignment_1_2 ) ) ;
    public final void rule__AndAlsoExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6053:1: ( ( ( rule__AndAlsoExp__RightAssignment_1_2 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6054:1: ( ( rule__AndAlsoExp__RightAssignment_1_2 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6054:1: ( ( rule__AndAlsoExp__RightAssignment_1_2 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6055:1: ( rule__AndAlsoExp__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAlsoExpAccess().getRightAssignment_1_2()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6056:1: ( rule__AndAlsoExp__RightAssignment_1_2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6056:2: rule__AndAlsoExp__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__AndAlsoExp__RightAssignment_1_2_in_rule__AndAlsoExp__Group_1__2__Impl12373);
            rule__AndAlsoExp__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAlsoExpAccess().getRightAssignment_1_2()); 
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
    // $ANTLR end "rule__AndAlsoExp__Group_1__2__Impl"


    // $ANTLR start "rule__Pat__Group_3__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6072:1: rule__Pat__Group_3__0 : rule__Pat__Group_3__0__Impl rule__Pat__Group_3__1 ;
    public final void rule__Pat__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6076:1: ( rule__Pat__Group_3__0__Impl rule__Pat__Group_3__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6077:2: rule__Pat__Group_3__0__Impl rule__Pat__Group_3__1
            {
            pushFollow(FOLLOW_rule__Pat__Group_3__0__Impl_in_rule__Pat__Group_3__012409);
            rule__Pat__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Pat__Group_3__1_in_rule__Pat__Group_3__012412);
            rule__Pat__Group_3__1();

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
    // $ANTLR end "rule__Pat__Group_3__0"


    // $ANTLR start "rule__Pat__Group_3__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6084:1: rule__Pat__Group_3__0__Impl : ( ruleConUse ) ;
    public final void rule__Pat__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6088:1: ( ( ruleConUse ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6089:1: ( ruleConUse )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6089:1: ( ruleConUse )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6090:1: ruleConUse
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPatAccess().getConUseParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleConUse_in_rule__Pat__Group_3__0__Impl12439);
            ruleConUse();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPatAccess().getConUseParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__Pat__Group_3__0__Impl"


    // $ANTLR start "rule__Pat__Group_3__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6101:1: rule__Pat__Group_3__1 : rule__Pat__Group_3__1__Impl ;
    public final void rule__Pat__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6105:1: ( rule__Pat__Group_3__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6106:2: rule__Pat__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Pat__Group_3__1__Impl_in_rule__Pat__Group_3__112468);
            rule__Pat__Group_3__1__Impl();

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
    // $ANTLR end "rule__Pat__Group_3__1"


    // $ANTLR start "rule__Pat__Group_3__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6112:1: rule__Pat__Group_3__1__Impl : ( ( rulePat )? ) ;
    public final void rule__Pat__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6116:1: ( ( ( rulePat )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6117:1: ( ( rulePat )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6117:1: ( ( rulePat )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6118:1: ( rulePat )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPatAccess().getPatParserRuleCall_3_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6119:1: ( rulePat )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_LHEXCHAR && LA51_0<=RULE_SLASH)||LA51_0==RULE_BINDIG||LA51_0==RULE_NBINDIG||LA51_0==19||LA51_0==31||(LA51_0>=42 && LA51_0<=43)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6119:3: rulePat
                    {
                    pushFollow(FOLLOW_rulePat_in_rule__Pat__Group_3__1__Impl12496);
                    rulePat();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPatAccess().getPatParserRuleCall_3_1()); 
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
    // $ANTLR end "rule__Pat__Group_3__1__Impl"


    // $ANTLR start "rule__Lit__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6133:1: rule__Lit__Group_1__0 : rule__Lit__Group_1__0__Impl rule__Lit__Group_1__1 ;
    public final void rule__Lit__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6137:1: ( rule__Lit__Group_1__0__Impl rule__Lit__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6138:2: rule__Lit__Group_1__0__Impl rule__Lit__Group_1__1
            {
            pushFollow(FOLLOW_rule__Lit__Group_1__0__Impl_in_rule__Lit__Group_1__012531);
            rule__Lit__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Lit__Group_1__1_in_rule__Lit__Group_1__012534);
            rule__Lit__Group_1__1();

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
    // $ANTLR end "rule__Lit__Group_1__0"


    // $ANTLR start "rule__Lit__Group_1__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6145:1: rule__Lit__Group_1__0__Impl : ( '\\'' ) ;
    public final void rule__Lit__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6149:1: ( ( '\\'' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6150:1: ( '\\'' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6150:1: ( '\\'' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6151:1: '\\''
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLitAccess().getApostropheKeyword_1_0()); 
            }
            match(input,31,FOLLOW_31_in_rule__Lit__Group_1__0__Impl12562); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLitAccess().getApostropheKeyword_1_0()); 
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
    // $ANTLR end "rule__Lit__Group_1__0__Impl"


    // $ANTLR start "rule__Lit__Group_1__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6164:1: rule__Lit__Group_1__1 : rule__Lit__Group_1__1__Impl rule__Lit__Group_1__2 ;
    public final void rule__Lit__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6168:1: ( rule__Lit__Group_1__1__Impl rule__Lit__Group_1__2 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6169:2: rule__Lit__Group_1__1__Impl rule__Lit__Group_1__2
            {
            pushFollow(FOLLOW_rule__Lit__Group_1__1__Impl_in_rule__Lit__Group_1__112593);
            rule__Lit__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Lit__Group_1__2_in_rule__Lit__Group_1__112596);
            rule__Lit__Group_1__2();

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
    // $ANTLR end "rule__Lit__Group_1__1"


    // $ANTLR start "rule__Lit__Group_1__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6176:1: rule__Lit__Group_1__1__Impl : ( ( ruleBITSTR )? ) ;
    public final void rule__Lit__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6180:1: ( ( ( ruleBITSTR )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6181:1: ( ( ruleBITSTR )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6181:1: ( ( ruleBITSTR )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6182:1: ( ruleBITSTR )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLitAccess().getBITSTRParserRuleCall_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6183:1: ( ruleBITSTR )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=RULE_BINDIG && LA52_0<=RULE_PIPE)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6183:3: ruleBITSTR
                    {
                    pushFollow(FOLLOW_ruleBITSTR_in_rule__Lit__Group_1__1__Impl12624);
                    ruleBITSTR();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLitAccess().getBITSTRParserRuleCall_1_1()); 
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
    // $ANTLR end "rule__Lit__Group_1__1__Impl"


    // $ANTLR start "rule__Lit__Group_1__2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6193:1: rule__Lit__Group_1__2 : rule__Lit__Group_1__2__Impl ;
    public final void rule__Lit__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6197:1: ( rule__Lit__Group_1__2__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6198:2: rule__Lit__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Lit__Group_1__2__Impl_in_rule__Lit__Group_1__212655);
            rule__Lit__Group_1__2__Impl();

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
    // $ANTLR end "rule__Lit__Group_1__2"


    // $ANTLR start "rule__Lit__Group_1__2__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6204:1: rule__Lit__Group_1__2__Impl : ( '\\'' ) ;
    public final void rule__Lit__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6208:1: ( ( '\\'' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6209:1: ( '\\'' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6209:1: ( '\\'' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6210:1: '\\''
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLitAccess().getApostropheKeyword_1_2()); 
            }
            match(input,31,FOLLOW_31_in_rule__Lit__Group_1__2__Impl12683); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLitAccess().getApostropheKeyword_1_2()); 
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
    // $ANTLR end "rule__Lit__Group_1__2__Impl"


    // $ANTLR start "rule__PrimBitPat__Group_1__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6229:1: rule__PrimBitPat__Group_1__0 : rule__PrimBitPat__Group_1__0__Impl rule__PrimBitPat__Group_1__1 ;
    public final void rule__PrimBitPat__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6233:1: ( rule__PrimBitPat__Group_1__0__Impl rule__PrimBitPat__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6234:2: rule__PrimBitPat__Group_1__0__Impl rule__PrimBitPat__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimBitPat__Group_1__0__Impl_in_rule__PrimBitPat__Group_1__012720);
            rule__PrimBitPat__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__PrimBitPat__Group_1__1_in_rule__PrimBitPat__Group_1__012723);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6241:1: rule__PrimBitPat__Group_1__0__Impl : ( ruleQid ) ;
    public final void rule__PrimBitPat__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6245:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6246:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6246:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6247:1: ruleQid
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimBitPatAccess().getQidParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleQid_in_rule__PrimBitPat__Group_1__0__Impl12750);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6258:1: rule__PrimBitPat__Group_1__1 : rule__PrimBitPat__Group_1__1__Impl ;
    public final void rule__PrimBitPat__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6262:1: ( rule__PrimBitPat__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6263:2: rule__PrimBitPat__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimBitPat__Group_1__1__Impl_in_rule__PrimBitPat__Group_1__112779);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6269:1: rule__PrimBitPat__Group_1__1__Impl : ( ( ruleBitPatOrInt )? ) ;
    public final void rule__PrimBitPat__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6273:1: ( ( ( ruleBitPatOrInt )? ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6274:1: ( ( ruleBitPatOrInt )? )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6274:1: ( ( ruleBitPatOrInt )? )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6275:1: ( ruleBitPatOrInt )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimBitPatAccess().getBitPatOrIntParserRuleCall_1_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6276:1: ( ruleBitPatOrInt )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==30||LA53_0==41) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6276:3: ruleBitPatOrInt
                    {
                    pushFollow(FOLLOW_ruleBitPatOrInt_in_rule__PrimBitPat__Group_1__1__Impl12807);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6290:1: rule__BitPatOrInt__Group_0__0 : rule__BitPatOrInt__Group_0__0__Impl rule__BitPatOrInt__Group_0__1 ;
    public final void rule__BitPatOrInt__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6294:1: ( rule__BitPatOrInt__Group_0__0__Impl rule__BitPatOrInt__Group_0__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6295:2: rule__BitPatOrInt__Group_0__0__Impl rule__BitPatOrInt__Group_0__1
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__0__Impl_in_rule__BitPatOrInt__Group_0__012842);
            rule__BitPatOrInt__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__1_in_rule__BitPatOrInt__Group_0__012845);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6302:1: rule__BitPatOrInt__Group_0__0__Impl : ( ':' ) ;
    public final void rule__BitPatOrInt__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6306:1: ( ( ':' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6307:1: ( ':' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6307:1: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6308:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getColonKeyword_0_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__BitPatOrInt__Group_0__0__Impl12873); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6321:1: rule__BitPatOrInt__Group_0__1 : rule__BitPatOrInt__Group_0__1__Impl ;
    public final void rule__BitPatOrInt__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6325:1: ( rule__BitPatOrInt__Group_0__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6326:2: rule__BitPatOrInt__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_0__1__Impl_in_rule__BitPatOrInt__Group_0__112904);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6332:1: rule__BitPatOrInt__Group_0__1__Impl : ( rulePOSINT ) ;
    public final void rule__BitPatOrInt__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6336:1: ( ( rulePOSINT ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6337:1: ( rulePOSINT )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6337:1: ( rulePOSINT )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6338:1: rulePOSINT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getPOSINTParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_rule__BitPatOrInt__Group_0__1__Impl12931);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6353:1: rule__BitPatOrInt__Group_1__0 : rule__BitPatOrInt__Group_1__0__Impl rule__BitPatOrInt__Group_1__1 ;
    public final void rule__BitPatOrInt__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6357:1: ( rule__BitPatOrInt__Group_1__0__Impl rule__BitPatOrInt__Group_1__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6358:2: rule__BitPatOrInt__Group_1__0__Impl rule__BitPatOrInt__Group_1__1
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__0__Impl_in_rule__BitPatOrInt__Group_1__012964);
            rule__BitPatOrInt__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__1_in_rule__BitPatOrInt__Group_1__012967);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6365:1: rule__BitPatOrInt__Group_1__0__Impl : ( '@' ) ;
    public final void rule__BitPatOrInt__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6369:1: ( ( '@' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6370:1: ( '@' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6370:1: ( '@' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6371:1: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getCommercialAtKeyword_1_0()); 
            }
            match(input,41,FOLLOW_41_in_rule__BitPatOrInt__Group_1__0__Impl12995); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6384:1: rule__BitPatOrInt__Group_1__1 : rule__BitPatOrInt__Group_1__1__Impl ;
    public final void rule__BitPatOrInt__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6388:1: ( rule__BitPatOrInt__Group_1__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6389:2: rule__BitPatOrInt__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__BitPatOrInt__Group_1__1__Impl_in_rule__BitPatOrInt__Group_1__113026);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6395:1: rule__BitPatOrInt__Group_1__1__Impl : ( ruleBITSTR ) ;
    public final void rule__BitPatOrInt__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6399:1: ( ( ruleBITSTR ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6400:1: ( ruleBITSTR )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6400:1: ( ruleBITSTR )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6401:1: ruleBITSTR
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatOrIntAccess().getBITSTRParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleBITSTR_in_rule__BitPatOrInt__Group_1__1__Impl13053);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6416:1: rule__NEGINT__Group__0 : rule__NEGINT__Group__0__Impl rule__NEGINT__Group__1 ;
    public final void rule__NEGINT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6420:1: ( rule__NEGINT__Group__0__Impl rule__NEGINT__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6421:2: rule__NEGINT__Group__0__Impl rule__NEGINT__Group__1
            {
            pushFollow(FOLLOW_rule__NEGINT__Group__0__Impl_in_rule__NEGINT__Group__013086);
            rule__NEGINT__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__NEGINT__Group__1_in_rule__NEGINT__Group__013089);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6428:1: rule__NEGINT__Group__0__Impl : ( '~' ) ;
    public final void rule__NEGINT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6432:1: ( ( '~' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6433:1: ( '~' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6433:1: ( '~' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6434:1: '~'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNEGINTAccess().getTildeKeyword_0()); 
            }
            match(input,42,FOLLOW_42_in_rule__NEGINT__Group__0__Impl13117); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6447:1: rule__NEGINT__Group__1 : rule__NEGINT__Group__1__Impl ;
    public final void rule__NEGINT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6451:1: ( rule__NEGINT__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6452:2: rule__NEGINT__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NEGINT__Group__1__Impl_in_rule__NEGINT__Group__113148);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6458:1: rule__NEGINT__Group__1__Impl : ( ruleNUM ) ;
    public final void rule__NEGINT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6462:1: ( ( ruleNUM ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6463:1: ( ruleNUM )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6463:1: ( ruleNUM )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6464:1: ruleNUM
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNEGINTAccess().getNUMParserRuleCall_1()); 
            }
            pushFollow(FOLLOW_ruleNUM_in_rule__NEGINT__Group__1__Impl13175);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6479:1: rule__HEXNUM__Group__0 : rule__HEXNUM__Group__0__Impl rule__HEXNUM__Group__1 ;
    public final void rule__HEXNUM__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6483:1: ( rule__HEXNUM__Group__0__Impl rule__HEXNUM__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6484:2: rule__HEXNUM__Group__0__Impl rule__HEXNUM__Group__1
            {
            pushFollow(FOLLOW_rule__HEXNUM__Group__0__Impl_in_rule__HEXNUM__Group__013208);
            rule__HEXNUM__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__HEXNUM__Group__1_in_rule__HEXNUM__Group__013211);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6491:1: rule__HEXNUM__Group__0__Impl : ( '0x' ) ;
    public final void rule__HEXNUM__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6495:1: ( ( '0x' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6496:1: ( '0x' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6496:1: ( '0x' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6497:1: '0x'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMAccess().getXKeyword_0()); 
            }
            match(input,43,FOLLOW_43_in_rule__HEXNUM__Group__0__Impl13239); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6510:1: rule__HEXNUM__Group__1 : rule__HEXNUM__Group__1__Impl ;
    public final void rule__HEXNUM__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6514:1: ( rule__HEXNUM__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6515:2: rule__HEXNUM__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__HEXNUM__Group__1__Impl_in_rule__HEXNUM__Group__113270);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6521:1: rule__HEXNUM__Group__1__Impl : ( ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* ) ) ;
    public final void rule__HEXNUM__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6525:1: ( ( ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6526:1: ( ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6526:1: ( ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6527:1: ( ( ruleHEXDIGIT ) ) ( ( ruleHEXDIGIT )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6527:1: ( ( ruleHEXDIGIT ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6528:1: ( ruleHEXDIGIT )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6529:1: ( ruleHEXDIGIT )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6529:3: ruleHEXDIGIT
            {
            pushFollow(FOLLOW_ruleHEXDIGIT_in_rule__HEXNUM__Group__1__Impl13300);
            ruleHEXDIGIT();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            }

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6532:1: ( ( ruleHEXDIGIT )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6533:1: ( ruleHEXDIGIT )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6534:1: ( ruleHEXDIGIT )*
            loop54:
            do {
                int alt54=2;
                switch ( input.LA(1) ) {
                case RULE_BINDIG:
                    {
                    int LA54_2 = input.LA(2);

                    if ( (synpred69_InternalGDSL()) ) {
                        alt54=1;
                    }


                    }
                    break;
                case RULE_NBINDIG:
                    {
                    int LA54_3 = input.LA(2);

                    if ( (synpred69_InternalGDSL()) ) {
                        alt54=1;
                    }


                    }
                    break;
                case RULE_LHEXCHAR:
                    {
                    int LA54_4 = input.LA(2);

                    if ( (synpred69_InternalGDSL()) ) {
                        alt54=1;
                    }


                    }
                    break;
                case RULE_UHEXCHAR:
                    {
                    int LA54_5 = input.LA(2);

                    if ( (synpred69_InternalGDSL()) ) {
                        alt54=1;
                    }


                    }
                    break;

                }

                switch (alt54) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6534:3: ruleHEXDIGIT
            	    {
            	    pushFollow(FOLLOW_ruleHEXDIGIT_in_rule__HEXNUM__Group__1__Impl13313);
            	    ruleHEXDIGIT();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop54;
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


    // $ANTLR start "rule__MIXID__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6549:1: rule__MIXID__Group__0 : rule__MIXID__Group__0__Impl rule__MIXID__Group__1 ;
    public final void rule__MIXID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6553:1: ( rule__MIXID__Group__0__Impl rule__MIXID__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6554:2: rule__MIXID__Group__0__Impl rule__MIXID__Group__1
            {
            pushFollow(FOLLOW_rule__MIXID__Group__0__Impl_in_rule__MIXID__Group__013350);
            rule__MIXID__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MIXID__Group__1_in_rule__MIXID__Group__013353);
            rule__MIXID__Group__1();

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
    // $ANTLR end "rule__MIXID__Group__0"


    // $ANTLR start "rule__MIXID__Group__0__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6561:1: rule__MIXID__Group__0__Impl : ( '_' ) ;
    public final void rule__MIXID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6565:1: ( ( '_' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6566:1: ( '_' )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6566:1: ( '_' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6567:1: '_'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIXIDAccess().get_Keyword_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__MIXID__Group__0__Impl13381); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIXIDAccess().get_Keyword_0()); 
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
    // $ANTLR end "rule__MIXID__Group__0__Impl"


    // $ANTLR start "rule__MIXID__Group__1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6580:1: rule__MIXID__Group__1 : rule__MIXID__Group__1__Impl ;
    public final void rule__MIXID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6584:1: ( rule__MIXID__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6585:2: rule__MIXID__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MIXID__Group__1__Impl_in_rule__MIXID__Group__113412);
            rule__MIXID__Group__1__Impl();

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
    // $ANTLR end "rule__MIXID__Group__1"


    // $ANTLR start "rule__MIXID__Group__1__Impl"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6591:1: rule__MIXID__Group__1__Impl : ( ( ( ruleIDCHAR ) ) ( ( ruleIDCHAR )* ) ) ;
    public final void rule__MIXID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6595:1: ( ( ( ( ruleIDCHAR ) ) ( ( ruleIDCHAR )* ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6596:1: ( ( ( ruleIDCHAR ) ) ( ( ruleIDCHAR )* ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6596:1: ( ( ( ruleIDCHAR ) ) ( ( ruleIDCHAR )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6597:1: ( ( ruleIDCHAR ) ) ( ( ruleIDCHAR )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6597:1: ( ( ruleIDCHAR ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6598:1: ( ruleIDCHAR )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIXIDAccess().getIDCHARParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6599:1: ( ruleIDCHAR )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6599:3: ruleIDCHAR
            {
            pushFollow(FOLLOW_ruleIDCHAR_in_rule__MIXID__Group__1__Impl13442);
            ruleIDCHAR();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIXIDAccess().getIDCHARParserRuleCall_1()); 
            }

            }

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6602:1: ( ( ruleIDCHAR )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6603:1: ( ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMIXIDAccess().getIDCHARParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6604:1: ( ruleIDCHAR )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=RULE_LHEXCHAR && LA55_0<=RULE_BINDIG)||LA55_0==RULE_NBINDIG) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6604:3: ruleIDCHAR
            	    {
            	    pushFollow(FOLLOW_ruleIDCHAR_in_rule__MIXID__Group__1__Impl13455);
            	    ruleIDCHAR();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMIXIDAccess().getIDCHARParserRuleCall_1()); 
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
    // $ANTLR end "rule__MIXID__Group__1__Impl"


    // $ANTLR start "rule__CONS__Group__0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6619:1: rule__CONS__Group__0 : rule__CONS__Group__0__Impl rule__CONS__Group__1 ;
    public final void rule__CONS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6623:1: ( rule__CONS__Group__0__Impl rule__CONS__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6624:2: rule__CONS__Group__0__Impl rule__CONS__Group__1
            {
            pushFollow(FOLLOW_rule__CONS__Group__0__Impl_in_rule__CONS__Group__013492);
            rule__CONS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CONS__Group__1_in_rule__CONS__Group__013495);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6631:1: rule__CONS__Group__0__Impl : ( ruleULETTER ) ;
    public final void rule__CONS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6635:1: ( ( ruleULETTER ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6636:1: ( ruleULETTER )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6636:1: ( ruleULETTER )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6637:1: ruleULETTER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCONSAccess().getULETTERParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleULETTER_in_rule__CONS__Group__0__Impl13522);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6648:1: rule__CONS__Group__1 : rule__CONS__Group__1__Impl ;
    public final void rule__CONS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6652:1: ( rule__CONS__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6653:2: rule__CONS__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__CONS__Group__1__Impl_in_rule__CONS__Group__113551);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6659:1: rule__CONS__Group__1__Impl : ( ( ruleIDCHAR )* ) ;
    public final void rule__CONS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6663:1: ( ( ( ruleIDCHAR )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6664:1: ( ( ruleIDCHAR )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6664:1: ( ( ruleIDCHAR )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6665:1: ( ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCONSAccess().getIDCHARParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6666:1: ( ruleIDCHAR )*
            loop56:
            do {
                int alt56=2;
                alt56 = dfa56.predict(input);
                switch (alt56) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6666:3: ruleIDCHAR
            	    {
            	    pushFollow(FOLLOW_ruleIDCHAR_in_rule__CONS__Group__1__Impl13579);
            	    ruleIDCHAR();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop56;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6680:1: rule__ID__Group__0 : rule__ID__Group__0__Impl rule__ID__Group__1 ;
    public final void rule__ID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6684:1: ( rule__ID__Group__0__Impl rule__ID__Group__1 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6685:2: rule__ID__Group__0__Impl rule__ID__Group__1
            {
            pushFollow(FOLLOW_rule__ID__Group__0__Impl_in_rule__ID__Group__013614);
            rule__ID__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ID__Group__1_in_rule__ID__Group__013617);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6692:1: rule__ID__Group__0__Impl : ( ruleLETTER ) ;
    public final void rule__ID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6696:1: ( ( ruleLETTER ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6697:1: ( ruleLETTER )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6697:1: ( ruleLETTER )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6698:1: ruleLETTER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getLETTERParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleLETTER_in_rule__ID__Group__0__Impl13644);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6709:1: rule__ID__Group__1 : rule__ID__Group__1__Impl ;
    public final void rule__ID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6713:1: ( rule__ID__Group__1__Impl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6714:2: rule__ID__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ID__Group__1__Impl_in_rule__ID__Group__113673);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6720:1: rule__ID__Group__1__Impl : ( ( ruleIDCHAR )* ) ;
    public final void rule__ID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6724:1: ( ( ( ruleIDCHAR )* ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6725:1: ( ( ruleIDCHAR )* )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6725:1: ( ( ruleIDCHAR )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6726:1: ( ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIDAccess().getIDCHARParserRuleCall_1()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6727:1: ( ruleIDCHAR )*
            loop57:
            do {
                int alt57=2;
                alt57 = dfa57.predict(input);
                switch (alt57) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6727:3: ruleIDCHAR
            	    {
            	    pushFollow(FOLLOW_ruleIDCHAR_in_rule__ID__Group__1__Impl13701);
            	    ruleIDCHAR();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop57;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6742:1: rule__Model__DeclAssignment_0 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6746:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6747:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6747:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6748:1: ruleDecl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_013741);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6757:1: rule__Model__DeclAssignment_1_1 : ( ruleDecl ) ;
    public final void rule__Model__DeclAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6761:1: ( ( ruleDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6762:1: ( ruleDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6762:1: ( ruleDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6763:1: ruleDecl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_113772);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6772:1: rule__DeclGranularity__NameAssignment_0 : ( ( 'granularity' ) ) ;
    public final void rule__DeclGranularity__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6776:1: ( ( ( 'granularity' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6777:1: ( ( 'granularity' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6777:1: ( ( 'granularity' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6778:1: ( 'granularity' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6779:1: ( 'granularity' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6780:1: 'granularity'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0()); 
            }
            match(input,44,FOLLOW_44_in_rule__DeclGranularity__NameAssignment_013808); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6795:1: rule__DeclGranularity__GranularityAssignment_2 : ( ruleInt ) ;
    public final void rule__DeclGranularity__GranularityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6799:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6800:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6800:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6801:1: ruleInt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclGranularityAccess().getGranularityIntParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleInt_in_rule__DeclGranularity__GranularityAssignment_213847);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6810:1: rule__DeclExport__NameAssignment_0 : ( ( 'export' ) ) ;
    public final void rule__DeclExport__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6814:1: ( ( ( 'export' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6815:1: ( ( 'export' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6815:1: ( ( 'export' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6816:1: ( 'export' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6817:1: ( 'export' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6818:1: 'export'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0()); 
            }
            match(input,45,FOLLOW_45_in_rule__DeclExport__NameAssignment_013883); if (state.failed) return ;
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6833:1: rule__DeclExport__ExportsAssignment_2 : ( ruleExport ) ;
    public final void rule__DeclExport__ExportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6837:1: ( ( ruleExport ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6838:1: ( ruleExport )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6838:1: ( ruleExport )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6839:1: ruleExport
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_213922);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6848:1: rule__DeclType__NameAssignment_1 : ( ruleName ) ;
    public final void rule__DeclType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6852:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6853:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6853:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6854:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__NameAssignment_113953);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6863:1: rule__DeclType__ValueAssignment_2_0_0_1 : ( ruleConDecls ) ;
    public final void rule__DeclType__ValueAssignment_2_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6867:1: ( ( ruleConDecls ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6868:1: ( ruleConDecls )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6868:1: ( ruleConDecls )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6869:1: ruleConDecls
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_2_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_2_0_0_113984);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6878:1: rule__DeclType__ValueAssignment_2_0_1 : ( ruleTy ) ;
    public final void rule__DeclType__ValueAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6882:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6883:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6883:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6884:1: ruleTy
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_2_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleTy_in_rule__DeclType__ValueAssignment_2_0_114015);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6893:1: rule__DeclType__AttrNameAssignment_2_1_1 : ( ruleName ) ;
    public final void rule__DeclType__AttrNameAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6897:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6898:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6898:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6899:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_2_1_114046);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6908:1: rule__DeclType__AttrNameAssignment_2_1_2_1 : ( ruleName ) ;
    public final void rule__DeclType__AttrNameAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6912:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6913:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6913:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6914:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_2_1_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_2_1_2_114077);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6923:1: rule__DeclType__ValueAssignment_2_1_5 : ( ruleConDecls ) ;
    public final void rule__DeclType__ValueAssignment_2_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6927:1: ( ( ruleConDecls ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6928:1: ( ruleConDecls )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6928:1: ( ruleConDecls )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6929:1: ruleConDecls
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_2_1_5_0()); 
            }
            pushFollow(FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_2_1_514108);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6938:1: rule__DeclVal__NameAssignment_0_1_0 : ( ruleName ) ;
    public final void rule__DeclVal__NameAssignment_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6942:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6943:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6943:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6944:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_0_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_0_1_014139);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6953:1: rule__DeclVal__NameAssignment_0_1_1 : ( ruleSYM ) ;
    public final void rule__DeclVal__NameAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6957:1: ( ( ruleSYM ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6958:1: ( ruleSYM )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6958:1: ( ruleSYM )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6959:1: ruleSYM
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getNameSYMParserRuleCall_0_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_rule__DeclVal__NameAssignment_0_1_114170);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6968:1: rule__DeclVal__AttrAssignment_0_2 : ( ruleName ) ;
    public final void rule__DeclVal__AttrAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6972:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6973:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6973:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6974:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getAttrNameParserRuleCall_0_2_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclVal__AttrAssignment_0_214201);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6983:1: rule__DeclVal__ExpAssignment_0_4 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6987:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6988:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6988:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6989:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_0_4_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_0_414232);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6998:1: rule__DeclVal__NameAssignment_1_1 : ( ruleName ) ;
    public final void rule__DeclVal__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7002:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7003:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7003:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7004:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_1_114263);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7013:1: rule__DeclVal__DecPatAssignment_1_3_0 : ( ruleDecodePat ) ;
    public final void rule__DeclVal__DecPatAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7017:1: ( ( ruleDecodePat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7018:1: ( ruleDecodePat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7018:1: ( ruleDecodePat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7019:1: ruleDecodePat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_0_0()); 
            }
            pushFollow(FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_3_014294);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7028:1: rule__DeclVal__DecPatAssignment_1_3_1 : ( ruleDecodePat ) ;
    public final void rule__DeclVal__DecPatAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7032:1: ( ( ruleDecodePat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7033:1: ( ruleDecodePat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7033:1: ( ruleDecodePat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7034:1: ruleDecodePat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_3_114325);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7043:1: rule__DeclVal__ExpAssignment_1_5_0_1 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpAssignment_1_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7047:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7048:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7048:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7049:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_5_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_1_5_0_114356);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7058:1: rule__DeclVal__ExpsAssignment_1_5_1_1 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpsAssignment_1_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7062:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7063:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7063:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7064:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_114387);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7073:1: rule__DeclVal__ExpsAssignment_1_5_1_3 : ( ruleExp ) ;
    public final void rule__DeclVal__ExpsAssignment_1_5_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7077:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7078:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7078:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7079:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_3_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_314418);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7088:1: rule__Export__NameAssignment_0 : ( ruleQid ) ;
    public final void rule__Export__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7092:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7093:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7093:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7094:1: ruleQid
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleQid_in_rule__Export__NameAssignment_014449);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7103:1: rule__Export__AttrNameAssignment_1_1 : ( ruleName ) ;
    public final void rule__Export__AttrNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7107:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7108:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7108:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7109:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_114480);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7118:1: rule__Export__AttrNameAssignment_1_2_1 : ( ruleName ) ;
    public final void rule__Export__AttrNameAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7122:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7123:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7123:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7124:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_2_114511);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7133:1: rule__ConDecls__ConDeclsAssignment_0 : ( ruleConDecl ) ;
    public final void rule__ConDecls__ConDeclsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7137:1: ( ( ruleConDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7138:1: ( ruleConDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7138:1: ( ruleConDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7139:1: ruleConDecl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_014542);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7148:1: rule__ConDecls__ConDeclsAssignment_1_1 : ( ruleConDecl ) ;
    public final void rule__ConDecls__ConDeclsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7152:1: ( ( ruleConDecl ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7153:1: ( ruleConDecl )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7153:1: ( ruleConDecl )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7154:1: ruleConDecl
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_1_114573);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7163:1: rule__ConDecl__NameAssignment_0 : ( ruleConBind ) ;
    public final void rule__ConDecl__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7167:1: ( ( ruleConBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7168:1: ( ruleConBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7168:1: ( ruleConBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7169:1: ruleConBind
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleConBind_in_rule__ConDecl__NameAssignment_014604);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7178:1: rule__ConDecl__TyAssignment_1_1 : ( ruleTy ) ;
    public final void rule__ConDecl__TyAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7182:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7183:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7183:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7184:1: ruleTy
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleTy_in_rule__ConDecl__TyAssignment_1_114635);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7193:1: rule__Ty__ValueAssignment_0 : ( ruleInt ) ;
    public final void rule__Ty__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7197:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7198:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7198:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7199:1: ruleInt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_014666);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7208:1: rule__Ty__ValueAssignment_1_1 : ( ruleInt ) ;
    public final void rule__Ty__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7212:1: ( ( ruleInt ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7213:1: ( ruleInt )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7213:1: ( ruleInt )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7214:1: ruleInt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_1_114697);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7223:1: rule__Ty__ValueAssignment_2_0 : ( ruleQid ) ;
    public final void rule__Ty__ValueAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7227:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7228:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7228:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7229:1: ruleQid
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_ruleQid_in_rule__Ty__ValueAssignment_2_014728);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7238:1: rule__Ty__TyBindAssignment_2_1_1 : ( ruleTyBind ) ;
    public final void rule__Ty__TyBindAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7242:1: ( ( ruleTyBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7243:1: ( ruleTyBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7243:1: ( ruleTyBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7244:1: ruleTyBind
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_114759);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7253:1: rule__Ty__TyBindAssignment_2_1_2_1 : ( ruleTyBind ) ;
    public final void rule__Ty__TyBindAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7257:1: ( ( ruleTyBind ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7258:1: ( ruleTyBind )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7258:1: ( ruleTyBind )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7259:1: ruleTyBind
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_2_114790);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7268:1: rule__Ty__ElementsAssignment_3_1 : ( ruleTyElement ) ;
    public final void rule__Ty__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7272:1: ( ( ruleTyElement ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7273:1: ( ruleTyElement )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7273:1: ( ruleTyElement )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7274:1: ruleTyElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_114821);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7283:1: rule__Ty__ElementsAssignment_3_2_1 : ( ruleTyElement ) ;
    public final void rule__Ty__ElementsAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7287:1: ( ( ruleTyElement ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7288:1: ( ruleTyElement )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7288:1: ( ruleTyElement )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7289:1: ruleTyElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_2_114852);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7298:1: rule__TyElement__NameAssignment_0 : ( ruleName ) ;
    public final void rule__TyElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7302:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7303:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7303:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7304:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getNameNameParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__TyElement__NameAssignment_014883);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7313:1: rule__TyElement__ValueAssignment_2 : ( ruleTy ) ;
    public final void rule__TyElement__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7317:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7318:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7318:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7319:1: ruleTy
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleTy_in_rule__TyElement__ValueAssignment_214914);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7328:1: rule__TyBind__KeyAssignment_0 : ( ruleQid ) ;
    public final void rule__TyBind__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7332:1: ( ( ruleQid ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7333:1: ( ruleQid )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7333:1: ( ruleQid )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7334:1: ruleQid
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleQid_in_rule__TyBind__KeyAssignment_014945);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7343:1: rule__TyBind__ValueAssignment_1_1 : ( ruleTy ) ;
    public final void rule__TyBind__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7347:1: ( ( ruleTy ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7348:1: ( ruleTy )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7348:1: ( ruleTy )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7349:1: ruleTy
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleTy_in_rule__TyBind__ValueAssignment_1_114976);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7358:1: rule__BitPat__BitpatAssignment_1 : ( rulePrimBitPat ) ;
    public final void rule__BitPat__BitpatAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7362:1: ( ( rulePrimBitPat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7363:1: ( rulePrimBitPat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7363:1: ( rulePrimBitPat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7364:1: rulePrimBitPat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_115007);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7373:1: rule__BitPat__BitpatAssignment_2 : ( rulePrimBitPat ) ;
    public final void rule__BitPat__BitpatAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7377:1: ( ( rulePrimBitPat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7378:1: ( rulePrimBitPat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7378:1: ( rulePrimBitPat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7379:1: rulePrimBitPat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_215038);
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
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7388:1: rule__TokPat__TokPatAssignment : ( ( rule__TokPat__TokPatAlternatives_0 ) ) ;
    public final void rule__TokPat__TokPatAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7392:1: ( ( ( rule__TokPat__TokPatAlternatives_0 ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7393:1: ( ( rule__TokPat__TokPatAlternatives_0 ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7393:1: ( ( rule__TokPat__TokPatAlternatives_0 ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7394:1: ( rule__TokPat__TokPatAlternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTokPatAccess().getTokPatAlternatives_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7395:1: ( rule__TokPat__TokPatAlternatives_0 )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7395:2: rule__TokPat__TokPatAlternatives_0
            {
            pushFollow(FOLLOW_rule__TokPat__TokPatAlternatives_0_in_rule__TokPat__TokPatAssignment15069);
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


    // $ANTLR start "rule__Exp__CaseExpAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7404:1: rule__Exp__CaseExpAssignment_0 : ( ruleCaseExp ) ;
    public final void rule__Exp__CaseExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7408:1: ( ( ruleCaseExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7409:1: ( ruleCaseExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7409:1: ( ruleCaseExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7410:1: ruleCaseExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpAccess().getCaseExpCaseExpParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_rule__Exp__CaseExpAssignment_015102);
            ruleCaseExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpAccess().getCaseExpCaseExpParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Exp__CaseExpAssignment_0"


    // $ANTLR start "rule__Exp__MidAssignment_1_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7419:1: rule__Exp__MidAssignment_1_0 : ( ruleMIXID ) ;
    public final void rule__Exp__MidAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7423:1: ( ( ruleMIXID ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7424:1: ( ruleMIXID )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7424:1: ( ruleMIXID )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7425:1: ruleMIXID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpAccess().getMidMIXIDParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleMIXID_in_rule__Exp__MidAssignment_1_015133);
            ruleMIXID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpAccess().getMidMIXIDParserRuleCall_1_0_0()); 
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
    // $ANTLR end "rule__Exp__MidAssignment_1_0"


    // $ANTLR start "rule__Exp__CaseExpAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7434:1: rule__Exp__CaseExpAssignment_1_1 : ( ruleCaseExp ) ;
    public final void rule__Exp__CaseExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7438:1: ( ( ruleCaseExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7439:1: ( ruleCaseExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7439:1: ( ruleCaseExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7440:1: ruleCaseExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpAccess().getCaseExpCaseExpParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_rule__Exp__CaseExpAssignment_1_115164);
            ruleCaseExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpAccess().getCaseExpCaseExpParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Exp__CaseExpAssignment_1_1"


    // $ANTLR start "rule__CaseExp__ClosedExpAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7449:1: rule__CaseExp__ClosedExpAssignment_1_1 : ( ruleClosedExp ) ;
    public final void rule__CaseExp__ClosedExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7453:1: ( ( ruleClosedExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7454:1: ( ruleClosedExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7454:1: ( ruleClosedExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7455:1: ruleClosedExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCaseExpAccess().getClosedExpClosedExpParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleClosedExp_in_rule__CaseExp__ClosedExpAssignment_1_115195);
            ruleClosedExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCaseExpAccess().getClosedExpClosedExpParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__CaseExp__ClosedExpAssignment_1_1"


    // $ANTLR start "rule__CaseExp__CasesAssignment_1_3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7464:1: rule__CaseExp__CasesAssignment_1_3 : ( ruleCases ) ;
    public final void rule__CaseExp__CasesAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7468:1: ( ( ruleCases ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7469:1: ( ruleCases )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7469:1: ( ruleCases )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7470:1: ruleCases
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCaseExpAccess().getCasesCasesParserRuleCall_1_3_0()); 
            }
            pushFollow(FOLLOW_ruleCases_in_rule__CaseExp__CasesAssignment_1_315226);
            ruleCases();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCaseExpAccess().getCasesCasesParserRuleCall_1_3_0()); 
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
    // $ANTLR end "rule__CaseExp__CasesAssignment_1_3"


    // $ANTLR start "rule__ClosedExp__IfCaseExpAssignment_1_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7479:1: rule__ClosedExp__IfCaseExpAssignment_1_1 : ( ruleCaseExp ) ;
    public final void rule__ClosedExp__IfCaseExpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7483:1: ( ( ruleCaseExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7484:1: ( ruleCaseExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7484:1: ( ruleCaseExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7485:1: ruleCaseExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getIfCaseExpCaseExpParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_rule__ClosedExp__IfCaseExpAssignment_1_115257);
            ruleCaseExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getIfCaseExpCaseExpParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__ClosedExp__IfCaseExpAssignment_1_1"


    // $ANTLR start "rule__ClosedExp__ThenCaseExpAssignment_1_3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7494:1: rule__ClosedExp__ThenCaseExpAssignment_1_3 : ( ruleCaseExp ) ;
    public final void rule__ClosedExp__ThenCaseExpAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7498:1: ( ( ruleCaseExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7499:1: ( ruleCaseExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7499:1: ( ruleCaseExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7500:1: ruleCaseExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getThenCaseExpCaseExpParserRuleCall_1_3_0()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_rule__ClosedExp__ThenCaseExpAssignment_1_315288);
            ruleCaseExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getThenCaseExpCaseExpParserRuleCall_1_3_0()); 
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
    // $ANTLR end "rule__ClosedExp__ThenCaseExpAssignment_1_3"


    // $ANTLR start "rule__ClosedExp__ElseCaseExpAssignment_1_5"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7509:1: rule__ClosedExp__ElseCaseExpAssignment_1_5 : ( ruleCaseExp ) ;
    public final void rule__ClosedExp__ElseCaseExpAssignment_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7513:1: ( ( ruleCaseExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7514:1: ( ruleCaseExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7514:1: ( ruleCaseExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7515:1: ruleCaseExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getElseCaseExpCaseExpParserRuleCall_1_5_0()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_rule__ClosedExp__ElseCaseExpAssignment_1_515319);
            ruleCaseExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getElseCaseExpCaseExpParserRuleCall_1_5_0()); 
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
    // $ANTLR end "rule__ClosedExp__ElseCaseExpAssignment_1_5"


    // $ANTLR start "rule__ClosedExp__DoExpAssignment_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7524:1: rule__ClosedExp__DoExpAssignment_2_1 : ( ruleMonadicExp ) ;
    public final void rule__ClosedExp__DoExpAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7528:1: ( ( ruleMonadicExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7529:1: ( ruleMonadicExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7529:1: ( ruleMonadicExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7530:1: ruleMonadicExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleMonadicExp_in_rule__ClosedExp__DoExpAssignment_2_115350);
            ruleMonadicExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_1_0()); 
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
    // $ANTLR end "rule__ClosedExp__DoExpAssignment_2_1"


    // $ANTLR start "rule__ClosedExp__DoExpAssignment_2_2_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7539:1: rule__ClosedExp__DoExpAssignment_2_2_1 : ( ruleMonadicExp ) ;
    public final void rule__ClosedExp__DoExpAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7543:1: ( ( ruleMonadicExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7544:1: ( ruleMonadicExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7544:1: ( ruleMonadicExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7545:1: ruleMonadicExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleMonadicExp_in_rule__ClosedExp__DoExpAssignment_2_2_115381);
            ruleMonadicExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_2_1_0()); 
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
    // $ANTLR end "rule__ClosedExp__DoExpAssignment_2_2_1"


    // $ANTLR start "rule__MonadicExp__ExpAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7554:1: rule__MonadicExp__ExpAssignment_0 : ( ruleExp ) ;
    public final void rule__MonadicExp__ExpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7558:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7559:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7559:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7560:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__MonadicExp__ExpAssignment_015412);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__MonadicExp__ExpAssignment_0"


    // $ANTLR start "rule__MonadicExp__NameAssignment_1_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7569:1: rule__MonadicExp__NameAssignment_1_0 : ( ruleName ) ;
    public final void rule__MonadicExp__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7573:1: ( ( ruleName ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7574:1: ( ruleName )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7574:1: ( ruleName )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7575:1: ruleName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMonadicExpAccess().getNameNameParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleName_in_rule__MonadicExp__NameAssignment_1_015443);
            ruleName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMonadicExpAccess().getNameNameParserRuleCall_1_0_0()); 
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
    // $ANTLR end "rule__MonadicExp__NameAssignment_1_0"


    // $ANTLR start "rule__MonadicExp__ExpAssignment_1_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7584:1: rule__MonadicExp__ExpAssignment_1_2 : ( ruleExp ) ;
    public final void rule__MonadicExp__ExpAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7588:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7589:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7589:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7590:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__MonadicExp__ExpAssignment_1_215474);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__MonadicExp__ExpAssignment_1_2"


    // $ANTLR start "rule__Cases__PatAssignment_0"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7599:1: rule__Cases__PatAssignment_0 : ( rulePat ) ;
    public final void rule__Cases__PatAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7603:1: ( ( rulePat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7604:1: ( rulePat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7604:1: ( rulePat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7605:1: rulePat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getPatPatParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_rulePat_in_rule__Cases__PatAssignment_015505);
            rulePat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getPatPatParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Cases__PatAssignment_0"


    // $ANTLR start "rule__Cases__ExpAssignment_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7614:1: rule__Cases__ExpAssignment_2 : ( ruleExp ) ;
    public final void rule__Cases__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7618:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7619:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7619:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7620:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getExpExpParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__Cases__ExpAssignment_215536);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getExpExpParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__Cases__ExpAssignment_2"


    // $ANTLR start "rule__Cases__PatAssignment_3_1"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7629:1: rule__Cases__PatAssignment_3_1 : ( rulePat ) ;
    public final void rule__Cases__PatAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7633:1: ( ( rulePat ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7634:1: ( rulePat )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7634:1: ( rulePat )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7635:1: rulePat
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getPatPatParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_rulePat_in_rule__Cases__PatAssignment_3_115567);
            rulePat();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getPatPatParserRuleCall_3_1_0()); 
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
    // $ANTLR end "rule__Cases__PatAssignment_3_1"


    // $ANTLR start "rule__Cases__ExpAssignment_3_3"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7644:1: rule__Cases__ExpAssignment_3_3 : ( ruleExp ) ;
    public final void rule__Cases__ExpAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7648:1: ( ( ruleExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7649:1: ( ruleExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7649:1: ( ruleExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7650:1: ruleExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCasesAccess().getExpExpParserRuleCall_3_3_0()); 
            }
            pushFollow(FOLLOW_ruleExp_in_rule__Cases__ExpAssignment_3_315598);
            ruleExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCasesAccess().getExpExpParserRuleCall_3_3_0()); 
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
    // $ANTLR end "rule__Cases__ExpAssignment_3_3"


    // $ANTLR start "rule__OrElseExp__RightAssignment_1_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7659:1: rule__OrElseExp__RightAssignment_1_2 : ( ruleAndAlsoExp ) ;
    public final void rule__OrElseExp__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7663:1: ( ( ruleAndAlsoExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7664:1: ( ruleAndAlsoExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7664:1: ( ruleAndAlsoExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7665:1: ruleAndAlsoExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOrElseExpAccess().getRightAndAlsoExpParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_rule__OrElseExp__RightAssignment_1_215629);
            ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOrElseExpAccess().getRightAndAlsoExpParserRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__OrElseExp__RightAssignment_1_2"


    // $ANTLR start "rule__AndAlsoExp__RightAssignment_1_2"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7674:1: rule__AndAlsoExp__RightAssignment_1_2 : ( ruleRExp ) ;
    public final void rule__AndAlsoExp__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7678:1: ( ( ruleRExp ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7679:1: ( ruleRExp )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7679:1: ( ruleRExp )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7680:1: ruleRExp
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAndAlsoExpAccess().getRightRExpParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleRExp_in_rule__AndAlsoExp__RightAssignment_1_215660);
            ruleRExp();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAndAlsoExpAccess().getRightRExpParserRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__AndAlsoExp__RightAssignment_1_2"


    // $ANTLR start "rule__RExp__NameAssignment"
    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7689:1: rule__RExp__NameAssignment : ( ( 'todo' ) ) ;
    public final void rule__RExp__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7693:1: ( ( ( 'todo' ) ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7694:1: ( ( 'todo' ) )
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7694:1: ( ( 'todo' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7695:1: ( 'todo' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRExpAccess().getNameTodoKeyword_0()); 
            }
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7696:1: ( 'todo' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:7697:1: 'todo'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRExpAccess().getNameTodoKeyword_0()); 
            }
            match(input,46,FOLLOW_46_in_rule__RExp__NameAssignment15696); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRExpAccess().getNameTodoKeyword_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRExpAccess().getNameTodoKeyword_0()); 
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
    // $ANTLR end "rule__RExp__NameAssignment"

    // $ANTLR start synpred1_InternalGDSL
    public final void synpred1_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1035:3: ( ruleDIG )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1035:3: ruleDIG
        {
        pushFollow(FOLLOW_ruleDIG_in_synpred1_InternalGDSL2152);
        ruleDIG();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalGDSL

    // $ANTLR start synpred2_InternalGDSL
    public final void synpred2_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1100:3: ( ruleBINARY )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1100:3: ruleBINARY
        {
        pushFollow(FOLLOW_ruleBINARY_in_synpred2_InternalGDSL2293);
        ruleBINARY();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalGDSL

    // $ANTLR start synpred9_InternalGDSL
    public final void synpred9_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1526:1: ( ( ( rule__DeclVal__NameAssignment_0_1_0 ) ) )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1526:1: ( ( rule__DeclVal__NameAssignment_0_1_0 ) )
        {
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1526:1: ( ( rule__DeclVal__NameAssignment_0_1_0 ) )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1527:1: ( rule__DeclVal__NameAssignment_0_1_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getDeclValAccess().getNameAssignment_0_1_0()); 
        }
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1528:1: ( rule__DeclVal__NameAssignment_0_1_0 )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1528:2: rule__DeclVal__NameAssignment_0_1_0
        {
        pushFollow(FOLLOW_rule__DeclVal__NameAssignment_0_1_0_in_synpred9_InternalGDSL3228);
        rule__DeclVal__NameAssignment_0_1_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred9_InternalGDSL

    // $ANTLR start synpred24_InternalGDSL
    public final void synpred24_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1763:6: ( ( ( ruleName ) ) )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1763:6: ( ( ruleName ) )
        {
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1763:6: ( ( ruleName ) )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1764:1: ( ruleName )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getPatAccess().getNameParserRuleCall_2()); 
        }
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1765:1: ( ruleName )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1765:3: ruleName
        {
        pushFollow(FOLLOW_ruleName_in_synpred24_InternalGDSL3790);
        ruleName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred24_InternalGDSL

    // $ANTLR start synpred69_InternalGDSL
    public final void synpred69_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6534:3: ( ruleHEXDIGIT )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6534:3: ruleHEXDIGIT
        {
        pushFollow(FOLLOW_ruleHEXDIGIT_in_synpred69_InternalGDSL13313);
        ruleHEXDIGIT();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred69_InternalGDSL

    // $ANTLR start synpred71_InternalGDSL
    public final void synpred71_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6666:3: ( ruleIDCHAR )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6666:3: ruleIDCHAR
        {
        pushFollow(FOLLOW_ruleIDCHAR_in_synpred71_InternalGDSL13579);
        ruleIDCHAR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred71_InternalGDSL

    // $ANTLR start synpred72_InternalGDSL
    public final void synpred72_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6727:3: ( ruleIDCHAR )
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:6727:3: ruleIDCHAR
        {
        pushFollow(FOLLOW_ruleIDCHAR_in_synpred72_InternalGDSL13701);
        ruleIDCHAR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred72_InternalGDSL

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
    public final boolean synpred71_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_InternalGDSL_fragment(); // can never throw exception
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
    public final boolean synpred24_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalGDSL_fragment(); // can never throw exception
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
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA57 dfa57 = new DFA57(this);
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
            return "1499:1: rule__DeclVal__Alternatives : ( ( ( rule__DeclVal__Group_0__0 ) ) | ( ( rule__DeclVal__Group_1__0 ) ) );";
        }
    }
    static final String DFA56_eotS =
        "\12\uffff";
    static final String DFA56_eofS =
        "\1\1\11\uffff";
    static final String DFA56_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA56_maxS =
        "\1\55\1\uffff\7\0\1\uffff";
    static final String DFA56_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA56_specialS =
        "\2\uffff\1\1\1\3\1\5\1\2\1\6\1\0\1\4\1\uffff}>";
    static final String[] DFA56_transitionS = {
            "\1\4\1\6\1\7\1\5\1\10\1\11\1\2\2\uffff\1\1\1\3\4\uffff\2\1\1"+
            "\uffff\1\1\3\uffff\1\1\2\uffff\3\1\12\uffff\4\1",
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

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "()* loopback of 6666:1: ( ruleIDCHAR )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA56_7 = input.LA(1);

                         
                        int index56_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index56_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA56_2 = input.LA(1);

                         
                        int index56_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index56_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA56_5 = input.LA(1);

                         
                        int index56_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index56_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA56_3 = input.LA(1);

                         
                        int index56_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index56_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA56_8 = input.LA(1);

                         
                        int index56_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index56_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA56_4 = input.LA(1);

                         
                        int index56_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index56_4);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA56_6 = input.LA(1);

                         
                        int index56_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index56_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 56, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA57_eotS =
        "\12\uffff";
    static final String DFA57_eofS =
        "\1\1\11\uffff";
    static final String DFA57_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA57_maxS =
        "\1\55\1\uffff\7\0\1\uffff";
    static final String DFA57_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA57_specialS =
        "\2\uffff\1\1\1\6\1\4\1\2\1\3\1\5\1\0\1\uffff}>";
    static final String[] DFA57_transitionS = {
            "\1\4\1\6\1\7\1\5\1\10\1\11\1\2\3\1\1\3\5\uffff\11\1\1\uffff"+
            "\2\1\6\uffff\1\1\2\uffff\5\1",
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

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "()* loopback of 6727:1: ( ruleIDCHAR )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_8 = input.LA(1);

                         
                        int index57_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA57_2 = input.LA(1);

                         
                        int index57_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA57_5 = input.LA(1);

                         
                        int index57_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA57_6 = input.LA(1);

                         
                        int index57_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA57_4 = input.LA(1);

                         
                        int index57_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA57_7 = input.LA(1);

                         
                        int index57_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA57_3 = input.LA(1);

                         
                        int index57_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index57_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
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
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Exp__Alternatives_in_ruleExp1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_entryRuleCaseExp1027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseExp1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CaseExp__Alternatives_in_ruleCaseExp1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_entryRuleClosedExp1087 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedExp1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Alternatives_in_ruleClosedExp1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp1147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonadicExp1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MonadicExp__Alternatives_in_ruleMonadicExp1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCases_in_entryRuleCases1207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCases1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__Group__0_in_ruleCases1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp1267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrElseExp1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group__0_in_ruleOrElseExp1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp1327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndAlsoExp1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group__0_in_ruleAndAlsoExp1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_entryRuleRExp1387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRExp1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RExp__NameAssignment_in_ruleRExp1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePat_in_entryRulePat1447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePat1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Pat__Alternatives_in_rulePat1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLit_in_entryRuleLit1507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLit1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lit__Alternatives_in_ruleLit1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat1567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimBitPat1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Alternatives_in_rulePrimBitPat1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt1627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPatOrInt1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Alternatives_in_ruleBitPatOrInt1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_entryRuleInt1687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInt1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Int__Alternatives_in_ruleInt1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName1747 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleName1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_entryRuleConBind1806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConBind1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConBind1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConUse_in_entryRuleConUse1865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConUse1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConUse1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid1924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleQid1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT1983 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT1990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__POSINT__Alternatives_in_rulePOSINT2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_entryRuleNEGINT2043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNEGINT2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__0_in_ruleNEGINT2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_entryRuleNUM2103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUM2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleNUM2139 = new BitSet(new long[]{0x0000000000004402L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleNUM2152 = new BitSet(new long[]{0x0000000000004402L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM2182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXNUM2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__0_in_ruleHEXNUM2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_entryRuleBITSTR2244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITSTR2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITSTR2280 = new BitSet(new long[]{0x0000000000003C02L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITSTR2293 = new BitSet(new long[]{0x0000000000003C02L});
    public static final BitSet FOLLOW_ruleMIXID_in_entryRuleMIXID2323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMIXID2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MIXID__Group__0_in_ruleMIXID2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS2383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONS__Group__0_in_ruleCONS2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_entryRuleID2443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleID2450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ID__Group__0_in_ruleID2476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT2503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXDIGIT2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXDIGIT__Alternatives_in_ruleHEXDIGIT2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR2563 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXCHAR2570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXCHAR__Alternatives_in_ruleHEXCHAR2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_entryRuleULETTER2623 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleULETTER2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ULETTER__Alternatives_in_ruleULETTER2656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_entryRuleLETTER2683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLETTER2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LETTER__Alternatives_in_ruleLETTER2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR2743 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDCHAR2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IDCHAR__Alternatives_in_ruleIDCHAR2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_entryRuleBINARY2803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBINARY2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BINARY__Alternatives_in_ruleBINARY2836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_entryRuleDIG2863 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDIG2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DIG__Alternatives_in_ruleDIG2896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_entryRuleSYM2923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSYM2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SYM__Alternatives_in_ruleSYM2956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_rule__Decl__Alternatives2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_rule__Decl__Alternatives3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_rule__Decl__Alternatives3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_rule__Decl__Alternatives3043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Alternatives_2_0_in_rule__DeclType__Alternatives_23075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__0_in_rule__DeclType__Alternatives_23093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_0_0__0_in_rule__DeclType__Alternatives_2_03126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_2_0_1_in_rule__DeclType__Alternatives_2_03144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__0_in_rule__DeclVal__Alternatives3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__0_in_rule__DeclVal__Alternatives3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_0_1_0_in_rule__DeclVal__Alternatives_0_13228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_0_1_1_in_rule__DeclVal__Alternatives_0_13246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__0_in_rule__DeclVal__Alternatives_1_53279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_53299 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__0_in_rule__DeclVal__Alternatives_1_53311 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_0_in_rule__Ty__Alternatives3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__0_in_rule__Ty__Alternatives3365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__0_in_rule__Ty__Alternatives3383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__0_in_rule__Ty__Alternatives3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_rule__DecodePat__Alternatives3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_rule__DecodePat__Alternatives3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__TokPat__TokPatAlternatives_03483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__TokPat__TokPatAlternatives_03500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Exp__CaseExpAssignment_0_in_rule__Exp__Alternatives3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Exp__Group_1__0_in_rule__Exp__Alternatives3550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_rule__CaseExp__Alternatives3583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__0_in_rule__CaseExp__Alternatives3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_rule__ClosedExp__Alternatives3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__0_in_rule__ClosedExp__Alternatives3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2__0_in_rule__ClosedExp__Alternatives3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MonadicExp__ExpAssignment_0_in_rule__MonadicExp__Alternatives3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MonadicExp__Group_1__0_in_rule__MonadicExp__Alternatives3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Pat__Alternatives3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLit_in_rule__Pat__Alternatives3772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__Pat__Alternatives3790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Pat__Group_3__0_in_rule__Pat__Alternatives3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__Lit__Alternatives3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lit__Group_1__0_in_rule__Lit__Alternatives3858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rule__PrimBitPat__Alternatives3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__0_in_rule__PrimBitPat__Alternatives3910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__0_in_rule__BitPatOrInt__Alternatives3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__0_in_rule__BitPatOrInt__Alternatives3961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_rule__Int__Alternatives3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_rule__Int__Alternatives4011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_rule__POSINT__Alternatives4043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_rule__POSINT__Alternatives4060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_rule__HEXDIGIT__Alternatives4092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_rule__HEXDIGIT__Alternatives4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_rule__HEXCHAR__Alternatives4141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_rule__HEXCHAR__Alternatives4158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_rule__ULETTER__Alternatives4190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNHEXCHAR_in_rule__ULETTER__Alternatives4207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_rule__LETTER__Alternatives4239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LNHEXCHAR_in_rule__LETTER__Alternatives4256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_rule__LETTER__Alternatives4273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_rule__LETTER__Alternatives4290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_rule__IDCHAR__Alternatives4322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_rule__IDCHAR__Alternatives4339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_rule__IDCHAR__Alternatives4356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_rule__BINARY__Alternatives4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_rule__BINARY__Alternatives4405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_rule__BINARY__Alternatives4422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__BINARY__Alternatives4439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_rule__DIG__Alternatives4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NBINDIG_in_rule__DIG__Alternatives4488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_rule__SYM__Alternatives4520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_rule__SYM__Alternatives4537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_rule__SYM__Alternatives4554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_rule__SYM__Alternatives4571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OTHERSYM_in_rule__SYM__Alternatives4588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__04618 = new BitSet(new long[]{0x0000300004500000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__04621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_0_in_rule__Model__Group__0__Impl4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Group__1__Impl4705 = new BitSet(new long[]{0x0000300004500002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__04740 = new BitSet(new long[]{0x0000300004500000L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__04743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Model__Group_1__0__Impl4772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__14805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DeclAssignment_1_1_in_rule__Model__Group_1__1__Impl4832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__0__Impl_in_rule__DeclGranularity__Group__04866 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1_in_rule__DeclGranularity__Group__04869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__NameAssignment_0_in_rule__DeclGranularity__Group__0__Impl4896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__1__Impl_in_rule__DeclGranularity__Group__14926 = new BitSet(new long[]{0x00000C0000004400L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2_in_rule__DeclGranularity__Group__14929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclGranularity__Group__1__Impl4957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__Group__2__Impl_in_rule__DeclGranularity__Group__24988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclGranularity__GranularityAssignment_2_in_rule__DeclGranularity__Group__2__Impl5015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__0__Impl_in_rule__DeclExport__Group__05051 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1_in_rule__DeclExport__Group__05054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__NameAssignment_0_in_rule__DeclExport__Group__0__Impl5081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__1__Impl_in_rule__DeclExport__Group__15111 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2_in_rule__DeclExport__Group__15114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclExport__Group__1__Impl5142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__Group__2__Impl_in_rule__DeclExport__Group__25173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclExport__ExportsAssignment_2_in_rule__DeclExport__Group__2__Impl5200 = new BitSet(new long[]{0x00000000000001F2L});
    public static final BitSet FOLLOW_rule__DeclType__Group__0__Impl_in_rule__DeclType__Group__05237 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclType__Group__1_in_rule__DeclType__Group__05240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__DeclType__Group__0__Impl5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__1__Impl_in_rule__DeclType__Group__15299 = new BitSet(new long[]{0x00000C0008A065F0L});
    public static final BitSet FOLLOW_rule__DeclType__Group__2_in_rule__DeclType__Group__15302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__NameAssignment_1_in_rule__DeclType__Group__1__Impl5329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group__2__Impl_in_rule__DeclType__Group__25359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Alternatives_2_in_rule__DeclType__Group__2__Impl5386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_0_0__0__Impl_in_rule__DeclType__Group_2_0_0__05422 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_0_0__1_in_rule__DeclType__Group_2_0_0__05425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclType__Group_2_0_0__0__Impl5453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_0_0__1__Impl_in_rule__DeclType__Group_2_0_0__15484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_2_0_0_1_in_rule__DeclType__Group_2_0_0__1__Impl5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__0__Impl_in_rule__DeclType__Group_2_1__05545 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__1_in_rule__DeclType__Group_2_1__05548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DeclType__Group_2_1__0__Impl5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__1__Impl_in_rule__DeclType__Group_2_1__15607 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__2_in_rule__DeclType__Group_2_1__15610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__AttrNameAssignment_2_1_1_in_rule__DeclType__Group_2_1__1__Impl5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__2__Impl_in_rule__DeclType__Group_2_1__25667 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__3_in_rule__DeclType__Group_2_1__25670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1_2__0_in_rule__DeclType__Group_2_1__2__Impl5697 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__3__Impl_in_rule__DeclType__Group_2_1__35728 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__4_in_rule__DeclType__Group_2_1__35731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__DeclType__Group_2_1__3__Impl5759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__4__Impl_in_rule__DeclType__Group_2_1__45790 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__5_in_rule__DeclType__Group_2_1__45793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclType__Group_2_1__4__Impl5821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1__5__Impl_in_rule__DeclType__Group_2_1__55852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__ValueAssignment_2_1_5_in_rule__DeclType__Group_2_1__5__Impl5879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1_2__0__Impl_in_rule__DeclType__Group_2_1_2__05921 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1_2__1_in_rule__DeclType__Group_2_1_2__05924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__DeclType__Group_2_1_2__0__Impl5952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__Group_2_1_2__1__Impl_in_rule__DeclType__Group_2_1_2__15983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclType__AttrNameAssignment_2_1_2_1_in_rule__DeclType__Group_2_1_2__1__Impl6010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__0__Impl_in_rule__DeclVal__Group_0__06044 = new BitSet(new long[]{0x0000000000009BF0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__1_in_rule__DeclVal__Group_0__06047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DeclVal__Group_0__0__Impl6075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__1__Impl_in_rule__DeclVal__Group_0__16106 = new BitSet(new long[]{0x00000000002001F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__2_in_rule__DeclVal__Group_0__16109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Alternatives_0_1_in_rule__DeclVal__Group_0__1__Impl6136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__2__Impl_in_rule__DeclVal__Group_0__26166 = new BitSet(new long[]{0x00000000002001F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__3_in_rule__DeclVal__Group_0__26169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__AttrAssignment_0_2_in_rule__DeclVal__Group_0__2__Impl6196 = new BitSet(new long[]{0x00000000000001F2L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__3__Impl_in_rule__DeclVal__Group_0__36227 = new BitSet(new long[]{0x0000402500080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__4_in_rule__DeclVal__Group_0__36230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclVal__Group_0__3__Impl6258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_0__4__Impl_in_rule__DeclVal__Group_0__46289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpAssignment_0_4_in_rule__DeclVal__Group_0__4__Impl6316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__0__Impl_in_rule__DeclVal__Group_1__06356 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__1_in_rule__DeclVal__Group_1__06359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DeclVal__Group_1__0__Impl6387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__1__Impl_in_rule__DeclVal__Group_1__16418 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__2_in_rule__DeclVal__Group_1__16421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_1_1_in_rule__DeclVal__Group_1__1__Impl6448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__2__Impl_in_rule__DeclVal__Group_1__26478 = new BitSet(new long[]{0x00000C00810045F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__3_in_rule__DeclVal__Group_1__26481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__DeclVal__Group_1__2__Impl6509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__3__Impl_in_rule__DeclVal__Group_1__36540 = new BitSet(new long[]{0x00000C00810045F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__4_in_rule__DeclVal__Group_1__36543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_3__0_in_rule__DeclVal__Group_1__3__Impl6570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__4__Impl_in_rule__DeclVal__Group_1__46601 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__5_in_rule__DeclVal__Group_1__46604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__DeclVal__Group_1__4__Impl6632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1__5__Impl_in_rule__DeclVal__Group_1__56663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Alternatives_1_5_in_rule__DeclVal__Group_1__5__Impl6690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_3__0__Impl_in_rule__DeclVal__Group_1_3__06732 = new BitSet(new long[]{0x00000C00800045F0L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_3__1_in_rule__DeclVal__Group_1_3__06735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__DecPatAssignment_1_3_0_in_rule__DeclVal__Group_1_3__0__Impl6762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_3__1__Impl_in_rule__DeclVal__Group_1_3__16792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__DecPatAssignment_1_3_1_in_rule__DeclVal__Group_1_3__1__Impl6819 = new BitSet(new long[]{0x00000C00800045F2L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__0__Impl_in_rule__DeclVal__Group_1_5_0__06854 = new BitSet(new long[]{0x0000402500080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__1_in_rule__DeclVal__Group_1_5_0__06857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclVal__Group_1_5_0__0__Impl6885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_0__1__Impl_in_rule__DeclVal__Group_1_5_0__16916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpAssignment_1_5_0_1_in_rule__DeclVal__Group_1_5_0__1__Impl6943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__0__Impl_in_rule__DeclVal__Group_1_5_1__06977 = new BitSet(new long[]{0x0000402500080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__1_in_rule__DeclVal__Group_1_5_1__06980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__DeclVal__Group_1_5_1__0__Impl7007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__1__Impl_in_rule__DeclVal__Group_1_5_1__17036 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__2_in_rule__DeclVal__Group_1_5_1__17039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_1_in_rule__DeclVal__Group_1_5_1__1__Impl7066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__2__Impl_in_rule__DeclVal__Group_1_5_1__27096 = new BitSet(new long[]{0x0000402500080000L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__3_in_rule__DeclVal__Group_1_5_1__27099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__DeclVal__Group_1_5_1__2__Impl7127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__Group_1_5_1__3__Impl_in_rule__DeclVal__Group_1_5_1__37158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__ExpsAssignment_1_5_1_3_in_rule__DeclVal__Group_1_5_1__3__Impl7185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__0__Impl_in_rule__Export__Group__07223 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Export__Group__1_in_rule__Export__Group__07226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__NameAssignment_0_in_rule__Export__Group__0__Impl7253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group__1__Impl_in_rule__Export__Group__17283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0_in_rule__Export__Group__1__Impl7310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__0__Impl_in_rule__Export__Group_1__07345 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1_in_rule__Export__Group_1__07348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Export__Group_1__0__Impl7376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__1__Impl_in_rule__Export__Group_1__17407 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2_in_rule__Export__Group_1__17410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_1_in_rule__Export__Group_1__1__Impl7437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__2__Impl_in_rule__Export__Group_1__27467 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3_in_rule__Export__Group_1__27470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0_in_rule__Export__Group_1__2__Impl7497 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1__3__Impl_in_rule__Export__Group_1__37528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Export__Group_1__3__Impl7556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__0__Impl_in_rule__Export__Group_1_2__07595 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1_in_rule__Export__Group_1_2__07598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Export__Group_1_2__0__Impl7626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__Group_1_2__1__Impl_in_rule__Export__Group_1_2__17657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Export__AttrNameAssignment_1_2_1_in_rule__Export__Group_1_2__1__Impl7684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__0__Impl_in_rule__ConDecls__Group__07718 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__1_in_rule__ConDecls__Group__07721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__ConDeclsAssignment_0_in_rule__ConDecls__Group__0__Impl7748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group__1__Impl_in_rule__ConDecls__Group__17778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__0_in_rule__ConDecls__Group__1__Impl7805 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__0__Impl_in_rule__ConDecls__Group_1__07840 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__1_in_rule__ConDecls__Group_1__07843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__ConDecls__Group_1__0__Impl7870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__Group_1__1__Impl_in_rule__ConDecls__Group_1__17899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecls__ConDeclsAssignment_1_1_in_rule__ConDecls__Group_1__1__Impl7926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__0__Impl_in_rule__ConDecl__Group__07960 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__1_in_rule__ConDecl__Group__07963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__NameAssignment_0_in_rule__ConDecl__Group__0__Impl7990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group__1__Impl_in_rule__ConDecl__Group__18020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__0_in_rule__ConDecl__Group__1__Impl8047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__0__Impl_in_rule__ConDecl__Group_1__08082 = new BitSet(new long[]{0x00000C00082065F0L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__1_in_rule__ConDecl__Group_1__08085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ConDecl__Group_1__0__Impl8113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__Group_1__1__Impl_in_rule__ConDecl__Group_1__18144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConDecl__TyAssignment_1_1_in_rule__ConDecl__Group_1__1__Impl8171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__0__Impl_in_rule__Ty__Group_1__08205 = new BitSet(new long[]{0x00000C0000004400L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__1_in_rule__Ty__Group_1__08208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__Ty__Group_1__0__Impl8235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__1__Impl_in_rule__Ty__Group_1__18264 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__2_in_rule__Ty__Group_1__18267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_1_1_in_rule__Ty__Group_1__1__Impl8294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_1__2__Impl_in_rule__Ty__Group_1__28324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__Ty__Group_1__2__Impl8351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__0__Impl_in_rule__Ty__Group_2__08386 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__1_in_rule__Ty__Group_2__08389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ValueAssignment_2_0_in_rule__Ty__Group_2__0__Impl8416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2__1__Impl_in_rule__Ty__Group_2__18446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__0_in_rule__Ty__Group_2__1__Impl8473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__0__Impl_in_rule__Ty__Group_2_1__08508 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__1_in_rule__Ty__Group_2_1__08511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Ty__Group_2_1__0__Impl8539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__1__Impl_in_rule__Ty__Group_2_1__18570 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__2_in_rule__Ty__Group_2_1__18573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__TyBindAssignment_2_1_1_in_rule__Ty__Group_2_1__1__Impl8600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__2__Impl_in_rule__Ty__Group_2_1__28630 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__3_in_rule__Ty__Group_2_1__28633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__0_in_rule__Ty__Group_2_1__2__Impl8660 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1__3__Impl_in_rule__Ty__Group_2_1__38691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Ty__Group_2_1__3__Impl8719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__0__Impl_in_rule__Ty__Group_2_1_2__08758 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__1_in_rule__Ty__Group_2_1_2__08761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Ty__Group_2_1_2__0__Impl8789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_2_1_2__1__Impl_in_rule__Ty__Group_2_1_2__18820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__TyBindAssignment_2_1_2_1_in_rule__Ty__Group_2_1_2__1__Impl8847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__0__Impl_in_rule__Ty__Group_3__08881 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__1_in_rule__Ty__Group_3__08884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Ty__Group_3__0__Impl8912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__1__Impl_in_rule__Ty__Group_3__18943 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__2_in_rule__Ty__Group_3__18946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ElementsAssignment_3_1_in_rule__Ty__Group_3__1__Impl8973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__2__Impl_in_rule__Ty__Group_3__29003 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__3_in_rule__Ty__Group_3__29006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__0_in_rule__Ty__Group_3__2__Impl9033 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3__3__Impl_in_rule__Ty__Group_3__39064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Ty__Group_3__3__Impl9092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__0__Impl_in_rule__Ty__Group_3_2__09131 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__1_in_rule__Ty__Group_3_2__09134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Ty__Group_3_2__0__Impl9162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__Group_3_2__1__Impl_in_rule__Ty__Group_3_2__19193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Ty__ElementsAssignment_3_2_1_in_rule__Ty__Group_3_2__1__Impl9220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__0__Impl_in_rule__TyElement__Group__09254 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__TyElement__Group__1_in_rule__TyElement__Group__09257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__NameAssignment_0_in_rule__TyElement__Group__0__Impl9284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__1__Impl_in_rule__TyElement__Group__19314 = new BitSet(new long[]{0x00000C00082065F0L});
    public static final BitSet FOLLOW_rule__TyElement__Group__2_in_rule__TyElement__Group__19317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__TyElement__Group__1__Impl9345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__Group__2__Impl_in_rule__TyElement__Group__29376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyElement__ValueAssignment_2_in_rule__TyElement__Group__2__Impl9403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__0__Impl_in_rule__TyBind__Group__09439 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__TyBind__Group__1_in_rule__TyBind__Group__09442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__KeyAssignment_0_in_rule__TyBind__Group__0__Impl9469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group__1__Impl_in_rule__TyBind__Group__19499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__0_in_rule__TyBind__Group__1__Impl9526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__0__Impl_in_rule__TyBind__Group_1__09561 = new BitSet(new long[]{0x00000C00082065F0L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__1_in_rule__TyBind__Group_1__09564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__TyBind__Group_1__0__Impl9592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__Group_1__1__Impl_in_rule__TyBind__Group_1__19623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TyBind__ValueAssignment_1_1_in_rule__TyBind__Group_1__1__Impl9650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__0__Impl_in_rule__BitPat__Group__09684 = new BitSet(new long[]{0x0000000000003DF0L});
    public static final BitSet FOLLOW_rule__BitPat__Group__1_in_rule__BitPat__Group__09687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__BitPat__Group__0__Impl9715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__1__Impl_in_rule__BitPat__Group__19746 = new BitSet(new long[]{0x0000000080003DF0L});
    public static final BitSet FOLLOW_rule__BitPat__Group__2_in_rule__BitPat__Group__19749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__BitpatAssignment_1_in_rule__BitPat__Group__1__Impl9776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__Group__2__Impl_in_rule__BitPat__Group__29806 = new BitSet(new long[]{0x0000000080003DF0L});
    public static final BitSet FOLLOW_rule__BitPat__Group__3_in_rule__BitPat__Group__29809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPat__BitpatAssignment_2_in_rule__BitPat__Group__2__Impl9836 = new BitSet(new long[]{0x0000000000003DF2L});
    public static final BitSet FOLLOW_rule__BitPat__Group__3__Impl_in_rule__BitPat__Group__39867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__BitPat__Group__3__Impl9895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Exp__Group_1__0__Impl_in_rule__Exp__Group_1__09934 = new BitSet(new long[]{0x0000402500000000L});
    public static final BitSet FOLLOW_rule__Exp__Group_1__1_in_rule__Exp__Group_1__09937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Exp__MidAssignment_1_0_in_rule__Exp__Group_1__0__Impl9964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Exp__Group_1__1__Impl_in_rule__Exp__Group_1__19994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Exp__CaseExpAssignment_1_1_in_rule__Exp__Group_1__1__Impl10021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__0__Impl_in_rule__CaseExp__Group_1__010055 = new BitSet(new long[]{0x0000402400000000L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__1_in_rule__CaseExp__Group_1__010058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__CaseExp__Group_1__0__Impl10086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__1__Impl_in_rule__CaseExp__Group_1__110117 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__2_in_rule__CaseExp__Group_1__110120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CaseExp__ClosedExpAssignment_1_1_in_rule__CaseExp__Group_1__1__Impl10147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__2__Impl_in_rule__CaseExp__Group_1__210177 = new BitSet(new long[]{0x00000C00800845F0L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__3_in_rule__CaseExp__Group_1__210180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__CaseExp__Group_1__2__Impl10208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__3__Impl_in_rule__CaseExp__Group_1__310239 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__4_in_rule__CaseExp__Group_1__310242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CaseExp__CasesAssignment_1_3_in_rule__CaseExp__Group_1__3__Impl10269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CaseExp__Group_1__4__Impl_in_rule__CaseExp__Group_1__410299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__CaseExp__Group_1__4__Impl10327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__0__Impl_in_rule__ClosedExp__Group_1__010368 = new BitSet(new long[]{0x0000402500000000L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__1_in_rule__ClosedExp__Group_1__010371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ClosedExp__Group_1__0__Impl10399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__1__Impl_in_rule__ClosedExp__Group_1__110430 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__2_in_rule__ClosedExp__Group_1__110433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__IfCaseExpAssignment_1_1_in_rule__ClosedExp__Group_1__1__Impl10460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__2__Impl_in_rule__ClosedExp__Group_1__210490 = new BitSet(new long[]{0x0000402500000000L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__3_in_rule__ClosedExp__Group_1__210493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ClosedExp__Group_1__2__Impl10521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__3__Impl_in_rule__ClosedExp__Group_1__310552 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__4_in_rule__ClosedExp__Group_1__310555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__ThenCaseExpAssignment_1_3_in_rule__ClosedExp__Group_1__3__Impl10582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__4__Impl_in_rule__ClosedExp__Group_1__410612 = new BitSet(new long[]{0x0000402500000000L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__5_in_rule__ClosedExp__Group_1__410615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ClosedExp__Group_1__4__Impl10643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_1__5__Impl_in_rule__ClosedExp__Group_1__510674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__ElseCaseExpAssignment_1_5_in_rule__ClosedExp__Group_1__5__Impl10701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2__0__Impl_in_rule__ClosedExp__Group_2__010743 = new BitSet(new long[]{0x00004025000801F0L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2__1_in_rule__ClosedExp__Group_2__010746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ClosedExp__Group_2__0__Impl10774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2__1__Impl_in_rule__ClosedExp__Group_2__110805 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2__2_in_rule__ClosedExp__Group_2__110808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__DoExpAssignment_2_1_in_rule__ClosedExp__Group_2__1__Impl10835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2__2__Impl_in_rule__ClosedExp__Group_2__210865 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2__3_in_rule__ClosedExp__Group_2__210868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2_2__0_in_rule__ClosedExp__Group_2__2__Impl10895 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2__3__Impl_in_rule__ClosedExp__Group_2__310926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ClosedExp__Group_2__3__Impl10954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2_2__0__Impl_in_rule__ClosedExp__Group_2_2__010993 = new BitSet(new long[]{0x00004025000801F0L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2_2__1_in_rule__ClosedExp__Group_2_2__010996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ClosedExp__Group_2_2__0__Impl11024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__Group_2_2__1__Impl_in_rule__ClosedExp__Group_2_2__111055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedExp__DoExpAssignment_2_2_1_in_rule__ClosedExp__Group_2_2__1__Impl11082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MonadicExp__Group_1__0__Impl_in_rule__MonadicExp__Group_1__011116 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__MonadicExp__Group_1__1_in_rule__MonadicExp__Group_1__011119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MonadicExp__NameAssignment_1_0_in_rule__MonadicExp__Group_1__0__Impl11146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MonadicExp__Group_1__1__Impl_in_rule__MonadicExp__Group_1__111176 = new BitSet(new long[]{0x0000402500080000L});
    public static final BitSet FOLLOW_rule__MonadicExp__Group_1__2_in_rule__MonadicExp__Group_1__111179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__MonadicExp__Group_1__1__Impl11207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MonadicExp__Group_1__2__Impl_in_rule__MonadicExp__Group_1__211238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MonadicExp__ExpAssignment_1_2_in_rule__MonadicExp__Group_1__2__Impl11265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__Group__0__Impl_in_rule__Cases__Group__011301 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Cases__Group__1_in_rule__Cases__Group__011304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__PatAssignment_0_in_rule__Cases__Group__0__Impl11331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__Group__1__Impl_in_rule__Cases__Group__111361 = new BitSet(new long[]{0x0000402500080000L});
    public static final BitSet FOLLOW_rule__Cases__Group__2_in_rule__Cases__Group__111364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Cases__Group__1__Impl11392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__Group__2__Impl_in_rule__Cases__Group__211423 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Cases__Group__3_in_rule__Cases__Group__211426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__ExpAssignment_2_in_rule__Cases__Group__2__Impl11453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__Group__3__Impl_in_rule__Cases__Group__311483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__Group_3__0_in_rule__Cases__Group__3__Impl11510 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__Cases__Group_3__0__Impl_in_rule__Cases__Group_3__011549 = new BitSet(new long[]{0x00000C00800845F0L});
    public static final BitSet FOLLOW_rule__Cases__Group_3__1_in_rule__Cases__Group_3__011552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_rule__Cases__Group_3__0__Impl11579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__Group_3__1__Impl_in_rule__Cases__Group_3__111608 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Cases__Group_3__2_in_rule__Cases__Group_3__111611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__PatAssignment_3_1_in_rule__Cases__Group_3__1__Impl11638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__Group_3__2__Impl_in_rule__Cases__Group_3__211668 = new BitSet(new long[]{0x0000402500080000L});
    public static final BitSet FOLLOW_rule__Cases__Group_3__3_in_rule__Cases__Group_3__211671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Cases__Group_3__2__Impl11699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__Group_3__3__Impl_in_rule__Cases__Group_3__311730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Cases__ExpAssignment_3_3_in_rule__Cases__Group_3__3__Impl11757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group__0__Impl_in_rule__OrElseExp__Group__011795 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group__1_in_rule__OrElseExp__Group__011798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_rule__OrElseExp__Group__0__Impl11825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group__1__Impl_in_rule__OrElseExp__Group__111854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group_1__0_in_rule__OrElseExp__Group__1__Impl11881 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group_1__0__Impl_in_rule__OrElseExp__Group_1__011916 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group_1__1_in_rule__OrElseExp__Group_1__011919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group_1__1__Impl_in_rule__OrElseExp__Group_1__111977 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group_1__2_in_rule__OrElseExp__Group_1__111980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__OrElseExp__Group_1__1__Impl12008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrElseExp__Group_1__2__Impl_in_rule__OrElseExp__Group_1__212039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrElseExp__RightAssignment_1_2_in_rule__OrElseExp__Group_1__2__Impl12066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group__0__Impl_in_rule__AndAlsoExp__Group__012102 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group__1_in_rule__AndAlsoExp__Group__012105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_rule__AndAlsoExp__Group__0__Impl12132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group__1__Impl_in_rule__AndAlsoExp__Group__112161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group_1__0_in_rule__AndAlsoExp__Group__1__Impl12188 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group_1__0__Impl_in_rule__AndAlsoExp__Group_1__012223 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group_1__1_in_rule__AndAlsoExp__Group_1__012226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group_1__1__Impl_in_rule__AndAlsoExp__Group_1__112284 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group_1__2_in_rule__AndAlsoExp__Group_1__112287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__AndAlsoExp__Group_1__1__Impl12315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__Group_1__2__Impl_in_rule__AndAlsoExp__Group_1__212346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndAlsoExp__RightAssignment_1_2_in_rule__AndAlsoExp__Group_1__2__Impl12373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Pat__Group_3__0__Impl_in_rule__Pat__Group_3__012409 = new BitSet(new long[]{0x00000C00800845F0L});
    public static final BitSet FOLLOW_rule__Pat__Group_3__1_in_rule__Pat__Group_3__012412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConUse_in_rule__Pat__Group_3__0__Impl12439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Pat__Group_3__1__Impl_in_rule__Pat__Group_3__112468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePat_in_rule__Pat__Group_3__1__Impl12496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lit__Group_1__0__Impl_in_rule__Lit__Group_1__012531 = new BitSet(new long[]{0x0000000080003C00L});
    public static final BitSet FOLLOW_rule__Lit__Group_1__1_in_rule__Lit__Group_1__012534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Lit__Group_1__0__Impl12562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lit__Group_1__1__Impl_in_rule__Lit__Group_1__112593 = new BitSet(new long[]{0x0000000080003C00L});
    public static final BitSet FOLLOW_rule__Lit__Group_1__2_in_rule__Lit__Group_1__112596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rule__Lit__Group_1__1__Impl12624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lit__Group_1__2__Impl_in_rule__Lit__Group_1__212655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Lit__Group_1__2__Impl12683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__0__Impl_in_rule__PrimBitPat__Group_1__012720 = new BitSet(new long[]{0x0000020040000000L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__1_in_rule__PrimBitPat__Group_1__012723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__PrimBitPat__Group_1__0__Impl12750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimBitPat__Group_1__1__Impl_in_rule__PrimBitPat__Group_1__112779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_rule__PrimBitPat__Group_1__1__Impl12807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__0__Impl_in_rule__BitPatOrInt__Group_0__012842 = new BitSet(new long[]{0x0000080000004400L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__1_in_rule__BitPatOrInt__Group_0__012845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__BitPatOrInt__Group_0__0__Impl12873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_0__1__Impl_in_rule__BitPatOrInt__Group_0__112904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_rule__BitPatOrInt__Group_0__1__Impl12931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__0__Impl_in_rule__BitPatOrInt__Group_1__012964 = new BitSet(new long[]{0x0000000000003C00L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__1_in_rule__BitPatOrInt__Group_1__012967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__BitPatOrInt__Group_1__0__Impl12995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BitPatOrInt__Group_1__1__Impl_in_rule__BitPatOrInt__Group_1__113026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rule__BitPatOrInt__Group_1__1__Impl13053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__0__Impl_in_rule__NEGINT__Group__013086 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__1_in_rule__NEGINT__Group__013089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__NEGINT__Group__0__Impl13117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NEGINT__Group__1__Impl_in_rule__NEGINT__Group__113148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_rule__NEGINT__Group__1__Impl13175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__0__Impl_in_rule__HEXNUM__Group__013208 = new BitSet(new long[]{0x0000000000004430L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__1_in_rule__HEXNUM__Group__013211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__HEXNUM__Group__0__Impl13239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HEXNUM__Group__1__Impl_in_rule__HEXNUM__Group__113270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_rule__HEXNUM__Group__1__Impl13300 = new BitSet(new long[]{0x0000000000004432L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_rule__HEXNUM__Group__1__Impl13313 = new BitSet(new long[]{0x0000000000004432L});
    public static final BitSet FOLLOW_rule__MIXID__Group__0__Impl_in_rule__MIXID__Group__013350 = new BitSet(new long[]{0x00000000000047F0L});
    public static final BitSet FOLLOW_rule__MIXID__Group__1_in_rule__MIXID__Group__013353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__MIXID__Group__0__Impl13381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MIXID__Group__1__Impl_in_rule__MIXID__Group__113412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_rule__MIXID__Group__1__Impl13442 = new BitSet(new long[]{0x00000000000047F2L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_rule__MIXID__Group__1__Impl13455 = new BitSet(new long[]{0x00000000000047F2L});
    public static final BitSet FOLLOW_rule__CONS__Group__0__Impl_in_rule__CONS__Group__013492 = new BitSet(new long[]{0x00000000000047F0L});
    public static final BitSet FOLLOW_rule__CONS__Group__1_in_rule__CONS__Group__013495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_rule__CONS__Group__0__Impl13522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CONS__Group__1__Impl_in_rule__CONS__Group__113551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_rule__CONS__Group__1__Impl13579 = new BitSet(new long[]{0x00000000000047F2L});
    public static final BitSet FOLLOW_rule__ID__Group__0__Impl_in_rule__ID__Group__013614 = new BitSet(new long[]{0x00000000000047F0L});
    public static final BitSet FOLLOW_rule__ID__Group__1_in_rule__ID__Group__013617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_rule__ID__Group__0__Impl13644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ID__Group__1__Impl_in_rule__ID__Group__113673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_rule__ID__Group__1__Impl13701 = new BitSet(new long[]{0x00000000000047F2L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_013741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_rule__Model__DeclAssignment_1_113772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__DeclGranularity__NameAssignment_013808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__DeclGranularity__GranularityAssignment_213847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__DeclExport__NameAssignment_013883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExport_in_rule__DeclExport__ExportsAssignment_213922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__NameAssignment_113953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_2_0_0_113984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__DeclType__ValueAssignment_2_0_114015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_2_1_114046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclType__AttrNameAssignment_2_1_2_114077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_rule__DeclType__ValueAssignment_2_1_514108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_0_1_014139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_rule__DeclVal__NameAssignment_0_1_114170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclVal__AttrAssignment_0_214201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_0_414232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__DeclVal__NameAssignment_1_114263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_3_014294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecodePat_in_rule__DeclVal__DecPatAssignment_1_3_114325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpAssignment_1_5_0_114356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_114387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__DeclVal__ExpsAssignment_1_5_1_314418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__Export__NameAssignment_014449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_114480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__Export__AttrNameAssignment_1_2_114511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_014542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_rule__ConDecls__ConDeclsAssignment_1_114573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_rule__ConDecl__NameAssignment_014604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__ConDecl__TyAssignment_1_114635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_014666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_rule__Ty__ValueAssignment_1_114697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__Ty__ValueAssignment_2_014728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_114759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_rule__Ty__TyBindAssignment_2_1_2_114790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_114821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_rule__Ty__ElementsAssignment_3_2_114852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__TyElement__NameAssignment_014883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__TyElement__ValueAssignment_214914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rule__TyBind__KeyAssignment_014945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_rule__TyBind__ValueAssignment_1_114976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_115007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_rule__BitPat__BitpatAssignment_215038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TokPat__TokPatAlternatives_0_in_rule__TokPat__TokPatAssignment15069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_rule__Exp__CaseExpAssignment_015102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMIXID_in_rule__Exp__MidAssignment_1_015133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_rule__Exp__CaseExpAssignment_1_115164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_rule__CaseExp__ClosedExpAssignment_1_115195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCases_in_rule__CaseExp__CasesAssignment_1_315226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_rule__ClosedExp__IfCaseExpAssignment_1_115257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_rule__ClosedExp__ThenCaseExpAssignment_1_315288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_rule__ClosedExp__ElseCaseExpAssignment_1_515319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_rule__ClosedExp__DoExpAssignment_2_115350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_rule__ClosedExp__DoExpAssignment_2_2_115381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__MonadicExp__ExpAssignment_015412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rule__MonadicExp__NameAssignment_1_015443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__MonadicExp__ExpAssignment_1_215474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePat_in_rule__Cases__PatAssignment_015505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__Cases__ExpAssignment_215536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePat_in_rule__Cases__PatAssignment_3_115567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_rule__Cases__ExpAssignment_3_315598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_rule__OrElseExp__RightAssignment_1_215629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_rule__AndAlsoExp__RightAssignment_1_215660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__RExp__NameAssignment15696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_synpred1_InternalGDSL2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_synpred2_InternalGDSL2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DeclVal__NameAssignment_0_1_0_in_synpred9_InternalGDSL3228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_synpred24_InternalGDSL3790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_synpred69_InternalGDSL13313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_synpred71_InternalGDSL13579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_synpred72_InternalGDSL13701 = new BitSet(new long[]{0x0000000000000002L});

}