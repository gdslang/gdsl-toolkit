package gdsl.plugin.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import gdsl.plugin.services.GDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalGDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_PIPE", "RULE_DOT", "RULE_LHEXCHAR", "RULE_UHEXCHAR", "RULE_UNHEXCHAR", "RULE_LNHEXCHAR", "RULE_SLASH", "RULE_CHARSYM", "RULE_BINDIG", "RULE_BS", "RULE_NBINDIG", "RULE_OTHERSYM", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "';'", "'granularity'", "'='", "'export'", "'type'", "'['", "','", "']'", "'val'", "'{'", "'}'", "'of'", "':'", "'\\''", "'case'", "'end'", "'if'", "'then'", "'else'", "'do'", "'<-'", "'or'", "'and'", "'+'", "'-'", "'^'", "'~'", "'@'", "'$'", "'('", "')'", "'let'", "'in'", "'\"'", "'_'", "'0x'"
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
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_DOT=5;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_NBINDIG=14;
    public static final int RULE_LHEXCHAR=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=18;
    public static final int RULE_ML_COMMENT=17;
    public static final int RULE_BS=13;
    public static final int RULE_UNHEXCHAR=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int RULE_PIPE=4;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_OTHERSYM=15;
    public static final int T__39=39;
    public static final int RULE_LNHEXCHAR=9;
    public static final int RULE_BINDIG=12;
    public static final int RULE_SLASH=10;
    public static final int RULE_CHARSYM=11;
    public static final int RULE_WS=16;
    public static final int RULE_UHEXCHAR=7;

    // delegates
    // delegators


        public InternalGDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGDSLParser.tokenNames; }
    public String getGrammarFileName() { return "../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g"; }



     	private GDSLGrammarAccess grammarAccess;
     	
        public InternalGDSLParser(TokenStream input, GDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected GDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:69:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:76:1: ruleModel returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDecl ) ) ( (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:79:28: ( ( ( (lv_decl_0_0= ruleDecl ) ) ( (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:80:1: ( ( (lv_decl_0_0= ruleDecl ) ) ( (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:80:1: ( ( (lv_decl_0_0= ruleDecl ) ) ( (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:80:2: ( (lv_decl_0_0= ruleDecl ) ) ( (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:80:2: ( (lv_decl_0_0= ruleDecl ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:81:1: (lv_decl_0_0= ruleDecl )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:81:1: (lv_decl_0_0= ruleDecl )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:82:3: lv_decl_0_0= ruleDecl
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDecl_in_ruleModel131);
            lv_decl_0_0=ruleDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModelRule());
              	        }
                     		add(
                     			current, 
                     			"decl",
                      		lv_decl_0_0, 
                      		"Decl");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:2: ( (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=19 && LA2_0<=20)||(LA2_0>=22 && LA2_0<=23)||LA2_0==27) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==19) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:5: otherlv_1= ';'
            	            {
            	            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleModel145); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getSemicolonKeyword_1_0());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:102:3: ( (lv_decl_2_0= ruleDecl ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:103:1: (lv_decl_2_0= ruleDecl )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:103:1: (lv_decl_2_0= ruleDecl )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:104:3: lv_decl_2_0= ruleDecl
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDecl_in_ruleModel168);
            	    lv_decl_2_0=ruleDecl();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"decl",
            	              		lv_decl_2_0, 
            	              		"Decl");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDecl"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:128:1: entryRuleDecl returns [EObject current=null] : iv_ruleDecl= ruleDecl EOF ;
    public final EObject entryRuleDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:129:2: (iv_ruleDecl= ruleDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:130:2: iv_ruleDecl= ruleDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclRule()); 
            }
            pushFollow(FOLLOW_ruleDecl_in_entryRuleDecl206);
            iv_ruleDecl=ruleDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecl216); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecl"


    // $ANTLR start "ruleDecl"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:137:1: ruleDecl returns [EObject current=null] : (this_DeclGranularity_0= ruleDeclGranularity | this_DeclExport_1= ruleDeclExport | this_DeclType_2= ruleDeclType | this_DeclVal_3= ruleDeclVal ) ;
    public final EObject ruleDecl() throws RecognitionException {
        EObject current = null;

        EObject this_DeclGranularity_0 = null;

        EObject this_DeclExport_1 = null;

        EObject this_DeclType_2 = null;

        EObject this_DeclVal_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:140:28: ( (this_DeclGranularity_0= ruleDeclGranularity | this_DeclExport_1= ruleDeclExport | this_DeclType_2= ruleDeclType | this_DeclVal_3= ruleDeclVal ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:141:1: (this_DeclGranularity_0= ruleDeclGranularity | this_DeclExport_1= ruleDeclExport | this_DeclType_2= ruleDeclType | this_DeclVal_3= ruleDeclVal )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:141:1: (this_DeclGranularity_0= ruleDeclGranularity | this_DeclExport_1= ruleDeclExport | this_DeclType_2= ruleDeclType | this_DeclVal_3= ruleDeclVal )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case 23:
                {
                alt3=3;
                }
                break;
            case 27:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:142:5: this_DeclGranularity_0= ruleDeclGranularity
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDeclGranularity_in_ruleDecl263);
                    this_DeclGranularity_0=ruleDeclGranularity();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DeclGranularity_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:152:5: this_DeclExport_1= ruleDeclExport
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDeclExport_in_ruleDecl290);
                    this_DeclExport_1=ruleDeclExport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DeclExport_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:162:5: this_DeclType_2= ruleDeclType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDeclType_in_ruleDecl317);
                    this_DeclType_2=ruleDeclType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DeclType_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:172:5: this_DeclVal_3= ruleDeclVal
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDeclVal_in_ruleDecl344);
                    this_DeclVal_3=ruleDeclVal();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DeclVal_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecl"


    // $ANTLR start "entryRuleDeclGranularity"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:188:1: entryRuleDeclGranularity returns [EObject current=null] : iv_ruleDeclGranularity= ruleDeclGranularity EOF ;
    public final EObject entryRuleDeclGranularity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclGranularity = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:189:2: (iv_ruleDeclGranularity= ruleDeclGranularity EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:190:2: iv_ruleDeclGranularity= ruleDeclGranularity EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclGranularityRule()); 
            }
            pushFollow(FOLLOW_ruleDeclGranularity_in_entryRuleDeclGranularity379);
            iv_ruleDeclGranularity=ruleDeclGranularity();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclGranularity; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclGranularity389); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclGranularity"


    // $ANTLR start "ruleDeclGranularity"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:197:1: ruleDeclGranularity returns [EObject current=null] : ( ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInt ) ) ) ;
    public final EObject ruleDeclGranularity() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_granularity_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:200:28: ( ( ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInt ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:201:1: ( ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInt ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:201:1: ( ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInt ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:201:2: ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInt ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:201:2: ( (lv_name_0_0= 'granularity' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:202:1: (lv_name_0_0= 'granularity' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:202:1: (lv_name_0_0= 'granularity' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:203:3: lv_name_0_0= 'granularity'
            {
            lv_name_0_0=(Token)match(input,20,FOLLOW_20_in_ruleDeclGranularity432); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDeclGranularityRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "granularity");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleDeclGranularity457); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:220:1: ( (lv_granularity_2_0= ruleInt ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:221:1: (lv_granularity_2_0= ruleInt )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:221:1: (lv_granularity_2_0= ruleInt )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:222:3: lv_granularity_2_0= ruleInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclGranularityAccess().getGranularityIntParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleInt_in_ruleDeclGranularity478);
            lv_granularity_2_0=ruleInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeclGranularityRule());
              	        }
                     		set(
                     			current, 
                     			"granularity",
                      		lv_granularity_2_0, 
                      		"Int");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclGranularity"


    // $ANTLR start "entryRuleDeclExport"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:246:1: entryRuleDeclExport returns [EObject current=null] : iv_ruleDeclExport= ruleDeclExport EOF ;
    public final EObject entryRuleDeclExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclExport = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:247:2: (iv_ruleDeclExport= ruleDeclExport EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:248:2: iv_ruleDeclExport= ruleDeclExport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclExportRule()); 
            }
            pushFollow(FOLLOW_ruleDeclExport_in_entryRuleDeclExport514);
            iv_ruleDeclExport=ruleDeclExport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclExport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclExport524); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclExport"


    // $ANTLR start "ruleDeclExport"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:255:1: ruleDeclExport returns [EObject current=null] : ( ( (lv_name_0_0= 'export' ) ) otherlv_1= '=' ( (lv_exports_2_0= ruleExport ) )* ) ;
    public final EObject ruleDeclExport() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_exports_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:258:28: ( ( ( (lv_name_0_0= 'export' ) ) otherlv_1= '=' ( (lv_exports_2_0= ruleExport ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:259:1: ( ( (lv_name_0_0= 'export' ) ) otherlv_1= '=' ( (lv_exports_2_0= ruleExport ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:259:1: ( ( (lv_name_0_0= 'export' ) ) otherlv_1= '=' ( (lv_exports_2_0= ruleExport ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:259:2: ( (lv_name_0_0= 'export' ) ) otherlv_1= '=' ( (lv_exports_2_0= ruleExport ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:259:2: ( (lv_name_0_0= 'export' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:260:1: (lv_name_0_0= 'export' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:260:1: (lv_name_0_0= 'export' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:261:3: lv_name_0_0= 'export'
            {
            lv_name_0_0=(Token)match(input,22,FOLLOW_22_in_ruleDeclExport567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDeclExportRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "export");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleDeclExport592); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:278:1: ( (lv_exports_2_0= ruleExport ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=RULE_LHEXCHAR && LA4_0<=RULE_SLASH)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:279:1: (lv_exports_2_0= ruleExport )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:279:1: (lv_exports_2_0= ruleExport )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:280:3: lv_exports_2_0= ruleExport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExport_in_ruleDeclExport613);
            	    lv_exports_2_0=ruleExport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDeclExportRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"exports",
            	              		lv_exports_2_0, 
            	              		"Export");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclExport"


    // $ANTLR start "entryRuleDeclType"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:304:1: entryRuleDeclType returns [EObject current=null] : iv_ruleDeclType= ruleDeclType EOF ;
    public final EObject entryRuleDeclType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclType = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:305:2: (iv_ruleDeclType= ruleDeclType EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:306:2: iv_ruleDeclType= ruleDeclType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDeclType_in_entryRuleDeclType650);
            iv_ruleDeclType=ruleDeclType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclType660); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclType"


    // $ANTLR start "ruleDeclType"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:1: ruleDeclType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) ( ( (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) ) | ( (lv_value_4_0= ruleTy ) ) ) | (otherlv_5= '[' ( (lv_attrName_6_0= ruleName ) ) (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )* otherlv_9= ']' otherlv_10= '=' ( (lv_value_11_0= ruleConDecls ) ) ) ) ) ;
    public final EObject ruleDeclType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_value_3_0 = null;

        EObject lv_value_4_0 = null;

        AntlrDatatypeRuleToken lv_attrName_6_0 = null;

        AntlrDatatypeRuleToken lv_attrName_8_0 = null;

        EObject lv_value_11_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:316:28: ( (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) ( ( (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) ) | ( (lv_value_4_0= ruleTy ) ) ) | (otherlv_5= '[' ( (lv_attrName_6_0= ruleName ) ) (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )* otherlv_9= ']' otherlv_10= '=' ( (lv_value_11_0= ruleConDecls ) ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:1: (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) ( ( (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) ) | ( (lv_value_4_0= ruleTy ) ) ) | (otherlv_5= '[' ( (lv_attrName_6_0= ruleName ) ) (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )* otherlv_9= ']' otherlv_10= '=' ( (lv_value_11_0= ruleConDecls ) ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:1: (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) ( ( (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) ) | ( (lv_value_4_0= ruleTy ) ) ) | (otherlv_5= '[' ( (lv_attrName_6_0= ruleName ) ) (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )* otherlv_9= ']' otherlv_10= '=' ( (lv_value_11_0= ruleConDecls ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:3: otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) ( ( (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) ) | ( (lv_value_4_0= ruleTy ) ) ) | (otherlv_5= '[' ( (lv_attrName_6_0= ruleName ) ) (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )* otherlv_9= ']' otherlv_10= '=' ( (lv_value_11_0= ruleConDecls ) ) ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleDeclType697); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeclTypeAccess().getTypeKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:321:1: ( (lv_name_1_0= ruleName ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:1: (lv_name_1_0= ruleName )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:1: (lv_name_1_0= ruleName )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:323:3: lv_name_1_0= ruleName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleName_in_ruleDeclType718);
            lv_name_1_0=ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"Name");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:339:2: ( ( (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) ) | ( (lv_value_4_0= ruleTy ) ) ) | (otherlv_5= '[' ( (lv_attrName_6_0= ruleName ) ) (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )* otherlv_9= ']' otherlv_10= '=' ( (lv_value_11_0= ruleConDecls ) ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_PIPE||(LA7_0>=RULE_LHEXCHAR && LA7_0<=RULE_SLASH)||LA7_0==RULE_BINDIG||LA7_0==RULE_NBINDIG||LA7_0==21||LA7_0==28||LA7_0==45||LA7_0==54) ) {
                alt7=1;
            }
            else if ( (LA7_0==24) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:339:3: ( (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) ) | ( (lv_value_4_0= ruleTy ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:339:3: ( (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) ) | ( (lv_value_4_0= ruleTy ) ) )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==21) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==RULE_PIPE||(LA5_0>=RULE_LHEXCHAR && LA5_0<=RULE_SLASH)||LA5_0==RULE_BINDIG||LA5_0==RULE_NBINDIG||LA5_0==28||LA5_0==45||LA5_0==54) ) {
                        alt5=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:339:4: (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:339:4: (otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:339:6: otherlv_2= '=' ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) )
                            {
                            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleDeclType733); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_0_0_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:343:1: ( ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:343:2: ( ( ruleConDecls ) )=> (lv_value_3_0= ruleConDecls )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:348:1: (lv_value_3_0= ruleConDecls )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:349:3: lv_value_3_0= ruleConDecls
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_2_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleConDecls_in_ruleDeclType764);
                            lv_value_3_0=ruleConDecls();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"value",
                                      		lv_value_3_0, 
                                      		"ConDecls");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:366:6: ( (lv_value_4_0= ruleTy ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:366:6: ( (lv_value_4_0= ruleTy ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:367:1: (lv_value_4_0= ruleTy )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:367:1: (lv_value_4_0= ruleTy )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:368:3: lv_value_4_0= ruleTy
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_2_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTy_in_ruleDeclType792);
                            lv_value_4_0=ruleTy();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"value",
                                      		lv_value_4_0, 
                                      		"Ty");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:385:6: (otherlv_5= '[' ( (lv_attrName_6_0= ruleName ) ) (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )* otherlv_9= ']' otherlv_10= '=' ( (lv_value_11_0= ruleConDecls ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:385:6: (otherlv_5= '[' ( (lv_attrName_6_0= ruleName ) ) (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )* otherlv_9= ']' otherlv_10= '=' ( (lv_value_11_0= ruleConDecls ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:385:8: otherlv_5= '[' ( (lv_attrName_6_0= ruleName ) ) (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )* otherlv_9= ']' otherlv_10= '=' ( (lv_value_11_0= ruleConDecls ) )
                    {
                    otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleDeclType812); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDeclTypeAccess().getLeftSquareBracketKeyword_2_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:389:1: ( (lv_attrName_6_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:390:1: (lv_attrName_6_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:390:1: (lv_attrName_6_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:391:3: lv_attrName_6_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleDeclType833);
                    lv_attrName_6_0=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"attrName",
                              		lv_attrName_6_0, 
                              		"Name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:407:2: (otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==25) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:407:4: otherlv_7= ',' ( (lv_attrName_8_0= ruleName ) )
                    	    {
                    	    otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleDeclType846); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getDeclTypeAccess().getCommaKeyword_2_1_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:411:1: ( (lv_attrName_8_0= ruleName ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:412:1: (lv_attrName_8_0= ruleName )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:412:1: (lv_attrName_8_0= ruleName )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:413:3: lv_attrName_8_0= ruleName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_2_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleName_in_ruleDeclType867);
                    	    lv_attrName_8_0=ruleName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"attrName",
                    	              		lv_attrName_8_0, 
                    	              		"Name");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,26,FOLLOW_26_in_ruleDeclType881); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getDeclTypeAccess().getRightSquareBracketKeyword_2_1_3());
                          
                    }
                    otherlv_10=(Token)match(input,21,FOLLOW_21_in_ruleDeclType893); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_1_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:437:1: ( (lv_value_11_0= ruleConDecls ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:438:1: (lv_value_11_0= ruleConDecls )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:438:1: (lv_value_11_0= ruleConDecls )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:439:3: lv_value_11_0= ruleConDecls
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_2_1_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConDecls_in_ruleDeclType914);
                    lv_value_11_0=ruleConDecls();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_11_0, 
                              		"ConDecls");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclType"


    // $ANTLR start "entryRuleDeclVal"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:463:1: entryRuleDeclVal returns [EObject current=null] : iv_ruleDeclVal= ruleDeclVal EOF ;
    public final EObject entryRuleDeclVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclVal = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:464:2: (iv_ruleDeclVal= ruleDeclVal EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:465:2: iv_ruleDeclVal= ruleDeclVal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclValRule()); 
            }
            pushFollow(FOLLOW_ruleDeclVal_in_entryRuleDeclVal952);
            iv_ruleDeclVal=ruleDeclVal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclVal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclVal962); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclVal"


    // $ANTLR start "ruleDeclVal"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:472:1: ruleDeclVal returns [EObject current=null] : ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) ) )* otherlv_9= '=' ( (lv_exp_10_0= ruleExp ) ) ) | (otherlv_11= 'val' ( (lv_name_12_0= ruleName ) ) otherlv_13= '[' ( ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )* )? otherlv_16= ']' ( (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) ) | (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+ ) ) ) ;
    public final EObject ruleDeclVal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token this_PIPE_19=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_attr_3_0 = null;

        EObject lv_exp_5_0 = null;

        AntlrDatatypeRuleToken lv_mid_7_0 = null;

        AntlrDatatypeRuleToken lv_attr_8_0 = null;

        EObject lv_exp_10_0 = null;

        AntlrDatatypeRuleToken lv_name_12_0 = null;

        EObject lv_decPat_14_0 = null;

        EObject lv_decPat_15_0 = null;

        EObject lv_exp_18_0 = null;

        EObject lv_exps_20_0 = null;

        EObject lv_exps_22_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:475:28: ( ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) ) )* otherlv_9= '=' ( (lv_exp_10_0= ruleExp ) ) ) | (otherlv_11= 'val' ( (lv_name_12_0= ruleName ) ) otherlv_13= '[' ( ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )* )? otherlv_16= ']' ( (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) ) | (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+ ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:1: ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) ) )* otherlv_9= '=' ( (lv_exp_10_0= ruleExp ) ) ) | (otherlv_11= 'val' ( (lv_name_12_0= ruleName ) ) otherlv_13= '[' ( ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )* )? otherlv_16= ']' ( (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) ) | (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+ ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:1: ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) ) )* otherlv_9= '=' ( (lv_exp_10_0= ruleExp ) ) ) | (otherlv_11= 'val' ( (lv_name_12_0= ruleName ) ) otherlv_13= '[' ( ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )* )? otherlv_16= ']' ( (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) ) | (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+ ) ) )
            int alt15=3;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:2: (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:2: (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:4: otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) )
                    {
                    otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleDeclVal1000); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDeclValAccess().getValKeyword_0_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:480:1: ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( ((LA8_0>=RULE_LHEXCHAR && LA8_0<=RULE_LNHEXCHAR)) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==RULE_SLASH) ) {
                        int LA8_2 = input.LA(2);

                        if ( (true) ) {
                            alt8=1;
                        }
                        else if ( (synpred2_InternalGDSL()) ) {
                            alt8=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 2, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA8_0==RULE_BS) && (synpred2_InternalGDSL())) {
                        alt8=2;
                    }
                    else if ( (LA8_0==RULE_DOT) && (synpred2_InternalGDSL())) {
                        alt8=2;
                    }
                    else if ( (LA8_0==RULE_CHARSYM) && (synpred2_InternalGDSL())) {
                        alt8=2;
                    }
                    else if ( (LA8_0==RULE_OTHERSYM) && (synpred2_InternalGDSL())) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:480:2: ( (lv_name_1_0= ruleName ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:480:2: ( (lv_name_1_0= ruleName ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:481:1: (lv_name_1_0= ruleName )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:481:1: (lv_name_1_0= ruleName )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:482:3: lv_name_1_0= ruleName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleName_in_ruleDeclVal1022);
                            lv_name_1_0=ruleName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"name",
                                      		lv_name_1_0, 
                                      		"Name");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:499:6: ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:499:6: ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:499:7: ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:504:1: (lv_name_2_0= ruleSYM )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:505:3: lv_name_2_0= ruleSYM
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getNameSYMParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleSYM_in_ruleDeclVal1059);
                            lv_name_2_0=ruleSYM();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"name",
                                      		lv_name_2_0, 
                                      		"SYM");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:521:3: ( (lv_attr_3_0= ruleName ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=RULE_LHEXCHAR && LA9_0<=RULE_SLASH)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:522:1: (lv_attr_3_0= ruleName )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:522:1: (lv_attr_3_0= ruleName )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:523:3: lv_attr_3_0= ruleName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getAttrNameParserRuleCall_0_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleName_in_ruleDeclVal1081);
                    	    lv_attr_3_0=ruleName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"attr",
                    	              		lv_attr_3_0, 
                    	              		"Name");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleDeclVal1094); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclValAccess().getEqualsSignKeyword_0_3());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:543:1: ( (lv_exp_5_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:544:1: (lv_exp_5_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:544:1: (lv_exp_5_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:545:3: lv_exp_5_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_0_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1115);
                    lv_exp_5_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_5_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:562:6: (otherlv_6= 'val' ( ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) ) )* otherlv_9= '=' ( (lv_exp_10_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:562:6: (otherlv_6= 'val' ( ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) ) )* otherlv_9= '=' ( (lv_exp_10_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:562:8: otherlv_6= 'val' ( ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) ) )* otherlv_9= '=' ( (lv_exp_10_0= ruleExp ) )
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleDeclVal1135); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDeclValAccess().getValKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:566:1: ( ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==53) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:566:2: ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:566:2: ( (lv_mid_7_0= ruleMIXID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:567:1: (lv_mid_7_0= ruleMIXID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:567:1: (lv_mid_7_0= ruleMIXID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:568:3: lv_mid_7_0= ruleMIXID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getMidMIXIDParserRuleCall_1_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMIXID_in_ruleDeclVal1157);
                    	    lv_mid_7_0=ruleMIXID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"mid",
                    	              		lv_mid_7_0, 
                    	              		"MIXID");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:584:2: ( (lv_attr_8_0= ruleName ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:585:1: (lv_attr_8_0= ruleName )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:585:1: (lv_attr_8_0= ruleName )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:586:3: lv_attr_8_0= ruleName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getAttrNameParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleName_in_ruleDeclVal1178);
                    	    lv_attr_8_0=ruleName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"attr",
                    	              		lv_attr_8_0, 
                    	              		"Name");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleDeclVal1192); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:606:1: ( (lv_exp_10_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:607:1: (lv_exp_10_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:607:1: (lv_exp_10_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:608:3: lv_exp_10_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1213);
                    lv_exp_10_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_10_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:625:6: (otherlv_11= 'val' ( (lv_name_12_0= ruleName ) ) otherlv_13= '[' ( ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )* )? otherlv_16= ']' ( (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) ) | (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+ ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:625:6: (otherlv_11= 'val' ( (lv_name_12_0= ruleName ) ) otherlv_13= '[' ( ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )* )? otherlv_16= ']' ( (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) ) | (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+ ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:625:8: otherlv_11= 'val' ( (lv_name_12_0= ruleName ) ) otherlv_13= '[' ( ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )* )? otherlv_16= ']' ( (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) ) | (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+ )
                    {
                    otherlv_11=(Token)match(input,27,FOLLOW_27_in_ruleDeclVal1233); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDeclValAccess().getValKeyword_2_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:629:1: ( (lv_name_12_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:630:1: (lv_name_12_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:630:1: (lv_name_12_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:631:3: lv_name_12_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleDeclVal1254);
                    lv_name_12_0=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_12_0, 
                              		"Name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,24,FOLLOW_24_in_ruleDeclVal1266); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_2_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:651:1: ( ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=RULE_LHEXCHAR && LA12_0<=RULE_SLASH)||LA12_0==RULE_BINDIG||LA12_0==RULE_NBINDIG||LA12_0==32||LA12_0==45||LA12_0==54) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:651:2: ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:651:2: ( (lv_decPat_14_0= ruleDecodePat ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:652:1: (lv_decPat_14_0= ruleDecodePat )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:652:1: (lv_decPat_14_0= ruleDecodePat )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:653:3: lv_decPat_14_0= ruleDecodePat
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_2_3_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleDecodePat_in_ruleDeclVal1288);
                            lv_decPat_14_0=ruleDecodePat();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"decPat",
                                      		lv_decPat_14_0, 
                                      		"DecodePat");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:669:2: ( (lv_decPat_15_0= ruleDecodePat ) )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( ((LA11_0>=RULE_LHEXCHAR && LA11_0<=RULE_SLASH)||LA11_0==RULE_BINDIG||LA11_0==RULE_NBINDIG||LA11_0==32||LA11_0==45||LA11_0==54) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:670:1: (lv_decPat_15_0= ruleDecodePat )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:670:1: (lv_decPat_15_0= ruleDecodePat )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:671:3: lv_decPat_15_0= ruleDecodePat
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_2_3_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDecodePat_in_ruleDeclVal1309);
                            	    lv_decPat_15_0=ruleDecodePat();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"decPat",
                            	              		lv_decPat_15_0, 
                            	              		"DecodePat");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,26,FOLLOW_26_in_ruleDeclVal1324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_2_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:691:1: ( (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) ) | (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+ )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==21) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==RULE_PIPE) ) {
                        alt14=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:691:2: (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:691:2: (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:691:4: otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) )
                            {
                            otherlv_17=(Token)match(input,21,FOLLOW_21_in_ruleDeclVal1338); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_17, grammarAccess.getDeclValAccess().getEqualsSignKeyword_2_5_0_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:695:1: ( (lv_exp_18_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:696:1: (lv_exp_18_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:696:1: (lv_exp_18_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:697:3: lv_exp_18_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_2_5_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1359);
                            lv_exp_18_0=ruleExp();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"exp",
                                      		lv_exp_18_0, 
                                      		"Exp");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:714:6: (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:714:6: (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==RULE_PIPE) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:714:7: this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) )
                            	    {
                            	    this_PIPE_19=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleDeclVal1378); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_PIPE_19, grammarAccess.getDeclValAccess().getPIPETerminalRuleCall_2_5_1_0()); 
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:718:1: ( (lv_exps_20_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:719:1: (lv_exps_20_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:719:1: (lv_exps_20_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:720:3: lv_exps_20_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_2_5_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1398);
                            	    lv_exps_20_0=ruleExp();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"exps",
                            	              		lv_exps_20_0, 
                            	              		"Exp");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }

                            	    otherlv_21=(Token)match(input,21,FOLLOW_21_in_ruleDeclVal1410); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_21, grammarAccess.getDeclValAccess().getEqualsSignKeyword_2_5_1_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:740:1: ( (lv_exps_22_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:741:1: (lv_exps_22_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:741:1: (lv_exps_22_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:742:3: lv_exps_22_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_2_5_1_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1431);
                            	    lv_exps_22_0=ruleExp();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"exps",
                            	              		lv_exps_22_0, 
                            	              		"Exp");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt13 >= 1 ) break loop13;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclVal"


    // $ANTLR start "entryRuleExport"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:766:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:767:2: (iv_ruleExport= ruleExport EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:768:2: iv_ruleExport= ruleExport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExportRule()); 
            }
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport1471);
            iv_ruleExport=ruleExport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport1481); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExport"


    // $ANTLR start "ruleExport"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:775:1: ruleExport returns [EObject current=null] : ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? ) ;
    public final EObject ruleExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_attrName_2_0 = null;

        AntlrDatatypeRuleToken lv_attrName_4_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:778:28: ( ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:779:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:779:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:779:2: ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:779:2: ( (lv_name_0_0= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:780:1: (lv_name_0_0= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:780:1: (lv_name_0_0= ruleQid )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:781:3: lv_name_0_0= ruleQid
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQid_in_ruleExport1527);
            lv_name_0_0=ruleQid();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExportRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"Qid");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:797:2: (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:797:4: otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleExport1540); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:801:1: ( (lv_attrName_2_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:802:1: (lv_attrName_2_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:802:1: (lv_attrName_2_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:803:3: lv_attrName_2_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleExport1561);
                    lv_attrName_2_0=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExportRule());
                      	        }
                             		add(
                             			current, 
                             			"attrName",
                              		lv_attrName_2_0, 
                              		"Name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:819:2: (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==25) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:819:4: otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleExport1574); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getExportAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:823:1: ( (lv_attrName_4_0= ruleName ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:824:1: (lv_attrName_4_0= ruleName )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:824:1: (lv_attrName_4_0= ruleName )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:825:3: lv_attrName_4_0= ruleName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleName_in_ruleExport1595);
                    	    lv_attrName_4_0=ruleName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getExportRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"attrName",
                    	              		lv_attrName_4_0, 
                    	              		"Name");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleExport1609); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getExportAccess().getRightCurlyBracketKeyword_1_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExport"


    // $ANTLR start "entryRuleConDecls"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:853:1: entryRuleConDecls returns [EObject current=null] : iv_ruleConDecls= ruleConDecls EOF ;
    public final EObject entryRuleConDecls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecls = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:854:2: (iv_ruleConDecls= ruleConDecls EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:855:2: iv_ruleConDecls= ruleConDecls EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConDeclsRule()); 
            }
            pushFollow(FOLLOW_ruleConDecls_in_entryRuleConDecls1647);
            iv_ruleConDecls=ruleConDecls();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConDecls; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecls1657); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConDecls"


    // $ANTLR start "ruleConDecls"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:862:1: ruleConDecls returns [EObject current=null] : ( ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )* ) ;
    public final EObject ruleConDecls() throws RecognitionException {
        EObject current = null;

        Token this_PIPE_1=null;
        EObject lv_conDecls_0_0 = null;

        EObject lv_conDecls_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:865:28: ( ( ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:866:1: ( ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:866:1: ( ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:866:2: ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:866:2: ( (lv_conDecls_0_0= ruleConDecl ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:867:1: (lv_conDecls_0_0= ruleConDecl )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:867:1: (lv_conDecls_0_0= ruleConDecl )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:868:3: lv_conDecls_0_0= ruleConDecl
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConDecl_in_ruleConDecls1703);
            lv_conDecls_0_0=ruleConDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConDeclsRule());
              	        }
                     		add(
                     			current, 
                     			"conDecls",
                      		lv_conDecls_0_0, 
                      		"ConDecl");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:884:2: (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_PIPE) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:884:3: this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) )
            	    {
            	    this_PIPE_1=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleConDecls1715); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_PIPE_1, grammarAccess.getConDeclsAccess().getPIPETerminalRuleCall_1_0()); 
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:888:1: ( (lv_conDecls_2_0= ruleConDecl ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:889:1: (lv_conDecls_2_0= ruleConDecl )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:889:1: (lv_conDecls_2_0= ruleConDecl )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:890:3: lv_conDecls_2_0= ruleConDecl
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConDecl_in_ruleConDecls1735);
            	    lv_conDecls_2_0=ruleConDecl();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getConDeclsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"conDecls",
            	              		lv_conDecls_2_0, 
            	              		"ConDecl");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConDecls"


    // $ANTLR start "entryRuleConDecl"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:914:1: entryRuleConDecl returns [EObject current=null] : iv_ruleConDecl= ruleConDecl EOF ;
    public final EObject entryRuleConDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:915:2: (iv_ruleConDecl= ruleConDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:916:2: iv_ruleConDecl= ruleConDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConDeclRule()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl1773);
            iv_ruleConDecl=ruleConDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl1783); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConDecl"


    // $ANTLR start "ruleConDecl"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:923:1: ruleConDecl returns [EObject current=null] : ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleConDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ty_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:926:28: ( ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:927:1: ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:927:1: ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:927:2: ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:927:2: ( (lv_name_0_0= ruleConBind ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:928:1: (lv_name_0_0= ruleConBind )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:928:1: (lv_name_0_0= ruleConBind )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:929:3: lv_name_0_0= ruleConBind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConBind_in_ruleConDecl1829);
            lv_name_0_0=ruleConBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConDeclRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ConBind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:945:2: (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:945:4: otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleConDecl1842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConDeclAccess().getOfKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:949:1: ( (lv_ty_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:950:1: (lv_ty_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:950:1: (lv_ty_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:951:3: lv_ty_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleConDecl1863);
                    lv_ty_2_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"ty",
                              		lv_ty_2_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConDecl"


    // $ANTLR start "entryRuleTy"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:975:1: entryRuleTy returns [EObject current=null] : iv_ruleTy= ruleTy EOF ;
    public final EObject entryRuleTy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTy = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:976:2: (iv_ruleTy= ruleTy EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:977:2: iv_ruleTy= ruleTy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyRule()); 
            }
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy1901);
            iv_ruleTy=ruleTy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTy; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy1911); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTy"


    // $ANTLR start "ruleTy"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:984:1: ruleTy returns [EObject current=null] : ( ( (lv_value_0_0= ruleInt ) ) | (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) ) ;
    public final EObject ruleTy() throws RecognitionException {
        EObject current = null;

        Token this_PIPE_1=null;
        Token this_PIPE_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;

        EObject lv_tyBind_6_0 = null;

        EObject lv_tyBind_8_0 = null;

        EObject lv_elements_11_0 = null;

        EObject lv_elements_13_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:987:28: ( ( ( (lv_value_0_0= ruleInt ) ) | (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:988:1: ( ( (lv_value_0_0= ruleInt ) ) | (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:988:1: ( ( (lv_value_0_0= ruleInt ) ) | (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) )
            int alt23=4;
            switch ( input.LA(1) ) {
            case RULE_BINDIG:
            case RULE_NBINDIG:
            case 45:
            case 54:
                {
                alt23=1;
                }
                break;
            case RULE_PIPE:
                {
                alt23=2;
                }
                break;
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
                {
                alt23=3;
                }
                break;
            case 28:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:988:2: ( (lv_value_0_0= ruleInt ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:988:2: ( (lv_value_0_0= ruleInt ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:989:1: (lv_value_0_0= ruleInt )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:989:1: (lv_value_0_0= ruleInt )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:990:3: lv_value_0_0= ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInt_in_ruleTy1957);
                    lv_value_0_0=ruleInt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_0_0, 
                              		"Int");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1007:6: (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1007:6: (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1007:7: this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE
                    {
                    this_PIPE_1=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleTy1975); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_PIPE_1, grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1011:1: ( (lv_value_2_0= ruleInt ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1012:1: (lv_value_2_0= ruleInt )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1012:1: (lv_value_2_0= ruleInt )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1013:3: lv_value_2_0= ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInt_in_ruleTy1995);
                    lv_value_2_0=ruleInt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_2_0, 
                              		"Int");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_PIPE_3=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleTy2006); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_PIPE_3, grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_2()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1034:6: ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1034:6: ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1034:7: ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1034:7: ( (lv_value_4_0= ruleQid ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1035:1: (lv_value_4_0= ruleQid )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1035:1: (lv_value_4_0= ruleQid )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1036:3: lv_value_4_0= ruleQid
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQid_in_ruleTy2034);
                    lv_value_4_0=ruleQid();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_4_0, 
                              		"Qid");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1052:2: (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==24) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1052:4: otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']'
                            {
                            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleTy2047); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1056:1: ( (lv_tyBind_6_0= ruleTyBind ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1057:1: (lv_tyBind_6_0= ruleTyBind )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1057:1: (lv_tyBind_6_0= ruleTyBind )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1058:3: lv_tyBind_6_0= ruleTyBind
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyBind_in_ruleTy2068);
                            lv_tyBind_6_0=ruleTyBind();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTyRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"tyBind",
                                      		lv_tyBind_6_0, 
                                      		"TyBind");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1074:2: (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==25) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1074:4: otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) )
                            	    {
                            	    otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleTy2081); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_7, grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1078:1: ( (lv_tyBind_8_0= ruleTyBind ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1079:1: (lv_tyBind_8_0= ruleTyBind )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1079:1: (lv_tyBind_8_0= ruleTyBind )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1080:3: lv_tyBind_8_0= ruleTyBind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyBind_in_ruleTy2102);
                            	    lv_tyBind_8_0=ruleTyBind();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getTyRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"tyBind",
                            	              		lv_tyBind_8_0, 
                            	              		"TyBind");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop20;
                                }
                            } while (true);

                            otherlv_9=(Token)match(input,26,FOLLOW_26_in_ruleTy2116); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getTyAccess().getRightSquareBracketKeyword_2_1_3());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1101:6: (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1101:6: (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1101:8: otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,28,FOLLOW_28_in_ruleTy2138); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1105:1: ( (lv_elements_11_0= ruleTyElement ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1106:1: (lv_elements_11_0= ruleTyElement )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1106:1: (lv_elements_11_0= ruleTyElement )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1107:3: lv_elements_11_0= ruleTyElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2159);
                    lv_elements_11_0=ruleTyElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		add(
                             			current, 
                             			"elements",
                              		lv_elements_11_0, 
                              		"TyElement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1123:2: (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==25) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1123:4: otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) )
                    	    {
                    	    otherlv_12=(Token)match(input,25,FOLLOW_25_in_ruleTy2172); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_12, grammarAccess.getTyAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1127:1: ( (lv_elements_13_0= ruleTyElement ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1128:1: (lv_elements_13_0= ruleTyElement )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1128:1: (lv_elements_13_0= ruleTyElement )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1129:3: lv_elements_13_0= ruleTyElement
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2193);
                    	    lv_elements_13_0=ruleTyElement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTyRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"elements",
                    	              		lv_elements_13_0, 
                    	              		"TyElement");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleTy2207); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getTyAccess().getRightCurlyBracketKeyword_3_3());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTy"


    // $ANTLR start "entryRuleTyElement"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1157:1: entryRuleTyElement returns [EObject current=null] : iv_ruleTyElement= ruleTyElement EOF ;
    public final EObject entryRuleTyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyElement = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1158:2: (iv_ruleTyElement= ruleTyElement EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1159:2: iv_ruleTyElement= ruleTyElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyElementRule()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement2244);
            iv_ruleTyElement=ruleTyElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement2254); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTyElement"


    // $ANTLR start "ruleTyElement"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1166:1: ruleTyElement returns [EObject current=null] : ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) ;
    public final EObject ruleTyElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:28: ( ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1170:1: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1170:1: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1170:2: ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1170:2: ( (lv_name_0_0= ruleName ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1171:1: (lv_name_0_0= ruleName )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1171:1: (lv_name_0_0= ruleName )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1172:3: lv_name_0_0= ruleName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyElementAccess().getNameNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleName_in_ruleTyElement2300);
            lv_name_0_0=ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTyElementRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"Name");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleTyElement2312); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTyElementAccess().getColonKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1192:1: ( (lv_value_2_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1193:1: (lv_value_2_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1193:1: (lv_value_2_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1194:3: lv_value_2_0= ruleTy
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTy_in_ruleTyElement2333);
            lv_value_2_0=ruleTy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTyElementRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"Ty");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTyElement"


    // $ANTLR start "entryRuleTyBind"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1218:1: entryRuleTyBind returns [EObject current=null] : iv_ruleTyBind= ruleTyBind EOF ;
    public final EObject entryRuleTyBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1219:2: (iv_ruleTyBind= ruleTyBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1220:2: iv_ruleTyBind= ruleTyBind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyBindRule()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind2369);
            iv_ruleTyBind=ruleTyBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyBind; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind2379); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTyBind"


    // $ANTLR start "ruleTyBind"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1227:1: ruleTyBind returns [EObject current=null] : ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleTyBind() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1230:28: ( ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1231:1: ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1231:1: ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1231:2: ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1231:2: ( (lv_key_0_0= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1232:1: (lv_key_0_0= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1232:1: (lv_key_0_0= ruleQid )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1233:3: lv_key_0_0= ruleQid
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQid_in_ruleTyBind2425);
            lv_key_0_0=ruleQid();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTyBindRule());
              	        }
                     		set(
                     			current, 
                     			"key",
                      		lv_key_0_0, 
                      		"Qid");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1249:2: (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==21) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1249:4: otherlv_1= '=' ( (lv_value_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleTyBind2438); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1253:1: ( (lv_value_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1254:1: (lv_value_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1254:1: (lv_value_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1255:3: lv_value_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTyBind2459);
                    lv_value_2_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyBindRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_2_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTyBind"


    // $ANTLR start "entryRuleDecodePat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1279:1: entryRuleDecodePat returns [EObject current=null] : iv_ruleDecodePat= ruleDecodePat EOF ;
    public final EObject entryRuleDecodePat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecodePat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1280:2: (iv_ruleDecodePat= ruleDecodePat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1281:2: iv_ruleDecodePat= ruleDecodePat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDecodePatRule()); 
            }
            pushFollow(FOLLOW_ruleDecodePat_in_entryRuleDecodePat2497);
            iv_ruleDecodePat=ruleDecodePat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDecodePat; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecodePat2507); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecodePat"


    // $ANTLR start "ruleDecodePat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1288:1: ruleDecodePat returns [EObject current=null] : (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat ) ;
    public final EObject ruleDecodePat() throws RecognitionException {
        EObject current = null;

        EObject this_BitPat_0 = null;

        EObject this_TokPat_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1291:28: ( (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1292:1: (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1292:1: (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=RULE_LHEXCHAR && LA25_0<=RULE_SLASH)||LA25_0==RULE_BINDIG||LA25_0==RULE_NBINDIG||LA25_0==45||LA25_0==54) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1293:5: this_BitPat_0= ruleBitPat
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDecodePatAccess().getBitPatParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBitPat_in_ruleDecodePat2554);
                    this_BitPat_0=ruleBitPat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BitPat_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1303:5: this_TokPat_1= ruleTokPat
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDecodePatAccess().getTokPatParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTokPat_in_ruleDecodePat2581);
                    this_TokPat_1=ruleTokPat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TokPat_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecodePat"


    // $ANTLR start "entryRuleBitPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1319:1: entryRuleBitPat returns [EObject current=null] : iv_ruleBitPat= ruleBitPat EOF ;
    public final EObject entryRuleBitPat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1320:2: (iv_ruleBitPat= ruleBitPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1321:2: iv_ruleBitPat= ruleBitPat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitPatRule()); 
            }
            pushFollow(FOLLOW_ruleBitPat_in_entryRuleBitPat2616);
            iv_ruleBitPat=ruleBitPat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitPat; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPat2626); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitPat"


    // $ANTLR start "ruleBitPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1328:1: ruleBitPat returns [EObject current=null] : (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\'' ) ;
    public final EObject ruleBitPat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_bitpat_1_0 = null;

        AntlrDatatypeRuleToken lv_bitpat_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1331:28: ( (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\'' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:1: (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\'' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:1: (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\'' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:3: otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\''
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleBitPat2663); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBitPatAccess().getApostropheKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1336:1: ( (lv_bitpat_1_0= rulePrimBitPat ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1337:1: (lv_bitpat_1_0= rulePrimBitPat )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1337:1: (lv_bitpat_1_0= rulePrimBitPat )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1338:3: lv_bitpat_1_0= rulePrimBitPat
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_ruleBitPat2684);
            lv_bitpat_1_0=rulePrimBitPat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBitPatRule());
              	        }
                     		add(
                     			current, 
                     			"bitpat",
                      		lv_bitpat_1_0, 
                      		"PrimBitPat");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1354:2: ( (lv_bitpat_2_0= rulePrimBitPat ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=RULE_PIPE && LA26_0<=RULE_SLASH)||(LA26_0>=RULE_BINDIG && LA26_0<=RULE_BS)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1355:1: (lv_bitpat_2_0= rulePrimBitPat )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1355:1: (lv_bitpat_2_0= rulePrimBitPat )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1356:3: lv_bitpat_2_0= rulePrimBitPat
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePrimBitPat_in_ruleBitPat2705);
            	    lv_bitpat_2_0=rulePrimBitPat();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBitPatRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"bitpat",
            	              		lv_bitpat_2_0, 
            	              		"PrimBitPat");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleBitPat2718); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getBitPatAccess().getApostropheKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitPat"


    // $ANTLR start "entryRuleTokPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1384:1: entryRuleTokPat returns [EObject current=null] : iv_ruleTokPat= ruleTokPat EOF ;
    public final EObject entryRuleTokPat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1385:2: (iv_ruleTokPat= ruleTokPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1386:2: iv_ruleTokPat= ruleTokPat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokPatRule()); 
            }
            pushFollow(FOLLOW_ruleTokPat_in_entryRuleTokPat2754);
            iv_ruleTokPat=ruleTokPat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTokPat; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTokPat2764); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTokPat"


    // $ANTLR start "ruleTokPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1393:1: ruleTokPat returns [EObject current=null] : ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) ) ;
    public final EObject ruleTokPat() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_tokPat_0_1 = null;

        AntlrDatatypeRuleToken lv_tokPat_0_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1396:28: ( ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1397:1: ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1397:1: ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1398:1: ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1398:1: ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1399:1: (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1399:1: (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_BINDIG||LA27_0==RULE_NBINDIG||LA27_0==45||LA27_0==54) ) {
                alt27=1;
            }
            else if ( ((LA27_0>=RULE_LHEXCHAR && LA27_0<=RULE_SLASH)) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1400:3: lv_tokPat_0_1= ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTokPatAccess().getTokPatIntParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInt_in_ruleTokPat2811);
                    lv_tokPat_0_1=ruleInt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTokPatRule());
                      	        }
                             		set(
                             			current, 
                             			"tokPat",
                              		lv_tokPat_0_1, 
                              		"Int");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1415:8: lv_tokPat_0_2= ruleQid
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTokPatAccess().getTokPatQidParserRuleCall_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQid_in_ruleTokPat2830);
                    lv_tokPat_0_2=ruleQid();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTokPatRule());
                      	        }
                             		set(
                             			current, 
                             			"tokPat",
                              		lv_tokPat_0_2, 
                              		"Qid");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTokPat"


    // $ANTLR start "entryRuleExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1441:1: entryRuleExp returns [EObject current=null] : iv_ruleExp= ruleExp EOF ;
    public final EObject entryRuleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1442:2: (iv_ruleExp= ruleExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1443:2: iv_ruleExp= ruleExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpRule()); 
            }
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp2868);
            iv_ruleExp=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp2878); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExp"


    // $ANTLR start "ruleExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1450:1: ruleExp returns [EObject current=null] : ( ( (lv_caseExp_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) ) ) ;
    public final EObject ruleExp() throws RecognitionException {
        EObject current = null;

        EObject lv_caseExp_0_0 = null;

        AntlrDatatypeRuleToken lv_mid_1_0 = null;

        EObject lv_caseExp_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1453:28: ( ( ( (lv_caseExp_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1454:1: ( ( (lv_caseExp_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1454:1: ( ( (lv_caseExp_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_LHEXCHAR && LA28_0<=RULE_SLASH)||LA28_0==RULE_BINDIG||LA28_0==RULE_NBINDIG||LA28_0==28||(LA28_0>=32 && LA28_0<=33)||LA28_0==35||LA28_0==38||(LA28_0>=45 && LA28_0<=48)||LA28_0==50||LA28_0==52||LA28_0==54) ) {
                alt28=1;
            }
            else if ( (LA28_0==53) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1454:2: ( (lv_caseExp_0_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1454:2: ( (lv_caseExp_0_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1455:1: (lv_caseExp_0_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1455:1: (lv_caseExp_0_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1456:3: lv_caseExp_0_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getCaseExpCaseExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp2924);
                    lv_caseExp_0_0=ruleCaseExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpRule());
                      	        }
                             		set(
                             			current, 
                             			"caseExp",
                              		lv_caseExp_0_0, 
                              		"CaseExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1473:6: ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1473:6: ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1473:7: ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1473:7: ( (lv_mid_1_0= ruleMIXID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1474:1: (lv_mid_1_0= ruleMIXID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1474:1: (lv_mid_1_0= ruleMIXID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1475:3: lv_mid_1_0= ruleMIXID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getMidMIXIDParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMIXID_in_ruleExp2952);
                    lv_mid_1_0=ruleMIXID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpRule());
                      	        }
                             		set(
                             			current, 
                             			"mid",
                              		lv_mid_1_0, 
                              		"MIXID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1491:2: ( (lv_caseExp_2_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1492:1: (lv_caseExp_2_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1492:1: (lv_caseExp_2_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1493:3: lv_caseExp_2_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getCaseExpCaseExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp2973);
                    lv_caseExp_2_0=ruleCaseExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpRule());
                      	        }
                             		set(
                             			current, 
                             			"caseExp",
                              		lv_caseExp_2_0, 
                              		"CaseExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExp"


    // $ANTLR start "entryRuleCaseExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1517:1: entryRuleCaseExp returns [EObject current=null] : iv_ruleCaseExp= ruleCaseExp EOF ;
    public final EObject entryRuleCaseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1518:2: (iv_ruleCaseExp= ruleCaseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1519:2: iv_ruleCaseExp= ruleCaseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseExpRule()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_entryRuleCaseExp3010);
            iv_ruleCaseExp=ruleCaseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseExp3020); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseExp"


    // $ANTLR start "ruleCaseExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1526:1: ruleCaseExp returns [EObject current=null] : (this_ClosedExp_0= ruleClosedExp | (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' ) ) ;
    public final EObject ruleCaseExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_ClosedExp_0 = null;

        EObject lv_closedExp_2_0 = null;

        EObject lv_cases_4_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1529:28: ( (this_ClosedExp_0= ruleClosedExp | (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1530:1: (this_ClosedExp_0= ruleClosedExp | (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1530:1: (this_ClosedExp_0= ruleClosedExp | (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_LHEXCHAR && LA29_0<=RULE_SLASH)||LA29_0==RULE_BINDIG||LA29_0==RULE_NBINDIG||LA29_0==28||LA29_0==32||LA29_0==35||LA29_0==38||(LA29_0>=45 && LA29_0<=48)||LA29_0==50||LA29_0==52||LA29_0==54) ) {
                alt29=1;
            }
            else if ( (LA29_0==33) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1531:5: this_ClosedExp_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp3067);
                    this_ClosedExp_0=ruleClosedExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ClosedExp_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1540:6: (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1540:6: (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1540:8: otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end'
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleCaseExp3085); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCaseExpAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1544:1: ( (lv_closedExp_2_0= ruleClosedExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1545:1: (lv_closedExp_2_0= ruleClosedExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1545:1: (lv_closedExp_2_0= ruleClosedExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1546:3: lv_closedExp_2_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpClosedExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp3106);
                    lv_closedExp_2_0=ruleClosedExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCaseExpRule());
                      	        }
                             		set(
                             			current, 
                             			"closedExp",
                              		lv_closedExp_2_0, 
                              		"ClosedExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleCaseExp3118); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCaseExpAccess().getOfKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1566:1: ( (lv_cases_4_0= ruleCases ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1567:1: (lv_cases_4_0= ruleCases )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1567:1: (lv_cases_4_0= ruleCases )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1568:3: lv_cases_4_0= ruleCases
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getCasesCasesParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCases_in_ruleCaseExp3139);
                    lv_cases_4_0=ruleCases();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCaseExpRule());
                      	        }
                             		set(
                             			current, 
                             			"cases",
                              		lv_cases_4_0, 
                              		"Cases");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleCaseExp3151); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCaseExpAccess().getEndKeyword_1_4());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseExp"


    // $ANTLR start "entryRuleClosedExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1596:1: entryRuleClosedExp returns [EObject current=null] : iv_ruleClosedExp= ruleClosedExp EOF ;
    public final EObject entryRuleClosedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosedExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1597:2: (iv_ruleClosedExp= ruleClosedExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1598:2: iv_ruleClosedExp= ruleClosedExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosedExpRule()); 
            }
            pushFollow(FOLLOW_ruleClosedExp_in_entryRuleClosedExp3188);
            iv_ruleClosedExp=ruleClosedExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosedExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedExp3198); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClosedExp"


    // $ANTLR start "ruleClosedExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1605:1: ruleClosedExp returns [EObject current=null] : (this_OrElseExp_0= ruleOrElseExp | (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) ;
    public final EObject ruleClosedExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject this_OrElseExp_0 = null;

        EObject lv_ifCaseExp_2_0 = null;

        EObject lv_thenCaseExp_4_0 = null;

        EObject lv_elseCaseExp_6_0 = null;

        EObject lv_doExp_8_0 = null;

        EObject lv_doExp_10_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1608:28: ( (this_OrElseExp_0= ruleOrElseExp | (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1609:1: (this_OrElseExp_0= ruleOrElseExp | (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1609:1: (this_OrElseExp_0= ruleOrElseExp | (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
            case RULE_BINDIG:
            case RULE_NBINDIG:
            case 28:
            case 32:
            case 45:
            case 46:
            case 47:
            case 48:
            case 50:
            case 52:
            case 54:
                {
                alt31=1;
                }
                break;
            case 35:
                {
                alt31=2;
                }
                break;
            case 38:
                {
                alt31=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1610:5: this_OrElseExp_0= ruleOrElseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClosedExpAccess().getOrElseExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrElseExp_in_ruleClosedExp3245);
                    this_OrElseExp_0=ruleOrElseExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OrElseExp_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1619:6: (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1619:6: (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1619:8: otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleClosedExp3263); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getClosedExpAccess().getIfKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1623:1: ( (lv_ifCaseExp_2_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1624:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1624:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1625:3: lv_ifCaseExp_2_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getIfCaseExpCaseExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3284);
                    lv_ifCaseExp_2_0=ruleCaseExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClosedExpRule());
                      	        }
                             		set(
                             			current, 
                             			"ifCaseExp",
                              		lv_ifCaseExp_2_0, 
                              		"CaseExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,36,FOLLOW_36_in_ruleClosedExp3296); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getClosedExpAccess().getThenKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1645:1: ( (lv_thenCaseExp_4_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1646:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1646:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1647:3: lv_thenCaseExp_4_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getThenCaseExpCaseExpParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3317);
                    lv_thenCaseExp_4_0=ruleCaseExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClosedExpRule());
                      	        }
                             		set(
                             			current, 
                             			"thenCaseExp",
                              		lv_thenCaseExp_4_0, 
                              		"CaseExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,37,FOLLOW_37_in_ruleClosedExp3329); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getClosedExpAccess().getElseKeyword_1_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1667:1: ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1668:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1668:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1669:3: lv_elseCaseExp_6_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getElseCaseExpCaseExpParserRuleCall_1_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3350);
                    lv_elseCaseExp_6_0=ruleCaseExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClosedExpRule());
                      	        }
                             		set(
                             			current, 
                             			"elseCaseExp",
                              		lv_elseCaseExp_6_0, 
                              		"CaseExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1686:6: (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1686:6: (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1686:8: otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end'
                    {
                    otherlv_7=(Token)match(input,38,FOLLOW_38_in_ruleClosedExp3370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getClosedExpAccess().getDoKeyword_2_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1690:1: ( (lv_doExp_8_0= ruleMonadicExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1691:1: (lv_doExp_8_0= ruleMonadicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1691:1: (lv_doExp_8_0= ruleMonadicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1692:3: lv_doExp_8_0= ruleMonadicExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3391);
                    lv_doExp_8_0=ruleMonadicExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClosedExpRule());
                      	        }
                             		add(
                             			current, 
                             			"doExp",
                              		lv_doExp_8_0, 
                              		"MonadicExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1708:2: (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==19) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1708:4: otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleClosedExp3404); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getClosedExpAccess().getSemicolonKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1712:1: ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1714:3: lv_doExp_10_0= ruleMonadicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3425);
                    	    lv_doExp_10_0=ruleMonadicExp();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getClosedExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"doExp",
                    	              		lv_doExp_10_0, 
                    	              		"MonadicExp");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,34,FOLLOW_34_in_ruleClosedExp3439); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getClosedExpAccess().getEndKeyword_2_3());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClosedExp"


    // $ANTLR start "entryRuleMonadicExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1742:1: entryRuleMonadicExp returns [EObject current=null] : iv_ruleMonadicExp= ruleMonadicExp EOF ;
    public final EObject entryRuleMonadicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonadicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1743:2: (iv_ruleMonadicExp= ruleMonadicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1744:2: iv_ruleMonadicExp= ruleMonadicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMonadicExpRule()); 
            }
            pushFollow(FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3476);
            iv_ruleMonadicExp=ruleMonadicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMonadicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonadicExp3486); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMonadicExp"


    // $ANTLR start "ruleMonadicExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1751:1: ruleMonadicExp returns [EObject current=null] : ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) ;
    public final EObject ruleMonadicExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_exp_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_exp_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1754:28: ( ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1755:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1755:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1755:2: ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1755:2: ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1755:3: ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1760:1: (lv_exp_0_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1761:3: lv_exp_0_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3542);
                    lv_exp_0_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMonadicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_0_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1778:6: ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1778:6: ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1778:7: ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1778:7: ( (lv_name_1_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1779:1: (lv_name_1_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1779:1: (lv_name_1_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1780:3: lv_name_1_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getNameNameParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleMonadicExp3570);
                    lv_name_1_0=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMonadicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"Name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleMonadicExp3582); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getMonadicExpAccess().getLessThanSignHyphenMinusKeyword_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1800:1: ( (lv_exp_3_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1801:1: (lv_exp_3_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1801:1: (lv_exp_3_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1802:3: lv_exp_3_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3603);
                    lv_exp_3_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMonadicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_3_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMonadicExp"


    // $ANTLR start "entryRuleCases"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1826:1: entryRuleCases returns [EObject current=null] : iv_ruleCases= ruleCases EOF ;
    public final EObject entryRuleCases() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCases = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1827:2: (iv_ruleCases= ruleCases EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1828:2: iv_ruleCases= ruleCases EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCasesRule()); 
            }
            pushFollow(FOLLOW_ruleCases_in_entryRuleCases3640);
            iv_ruleCases=ruleCases();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCases; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCases3650); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCases"


    // $ANTLR start "ruleCases"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1835:1: ruleCases returns [EObject current=null] : ( ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )* ) ;
    public final EObject ruleCases() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_PIPE_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_pat_0_0 = null;

        EObject lv_exp_2_0 = null;

        AntlrDatatypeRuleToken lv_pat_4_0 = null;

        EObject lv_exp_6_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1838:28: ( ( ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:1: ( ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:1: ( ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:2: ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:2: ( (lv_pat_0_0= rulePat ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1840:1: (lv_pat_0_0= rulePat )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1840:1: (lv_pat_0_0= rulePat )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1841:3: lv_pat_0_0= rulePat
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCasesAccess().getPatPatParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePat_in_ruleCases3696);
            lv_pat_0_0=rulePat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCasesRule());
              	        }
                     		add(
                     			current, 
                     			"pat",
                      		lv_pat_0_0, 
                      		"Pat");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleCases3708); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCasesAccess().getColonKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1861:1: ( (lv_exp_2_0= ruleExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1862:1: (lv_exp_2_0= ruleExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1862:1: (lv_exp_2_0= ruleExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1863:3: lv_exp_2_0= ruleExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCasesAccess().getExpExpParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExp_in_ruleCases3729);
            lv_exp_2_0=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCasesRule());
              	        }
                     		add(
                     			current, 
                     			"exp",
                      		lv_exp_2_0, 
                      		"Exp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1879:2: (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_PIPE) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1879:3: this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) )
            	    {
            	    this_PIPE_3=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleCases3741); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_PIPE_3, grammarAccess.getCasesAccess().getPIPETerminalRuleCall_3_0()); 
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1883:1: ( (lv_pat_4_0= rulePat ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1884:1: (lv_pat_4_0= rulePat )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1884:1: (lv_pat_4_0= rulePat )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1885:3: lv_pat_4_0= rulePat
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCasesAccess().getPatPatParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePat_in_ruleCases3761);
            	    lv_pat_4_0=rulePat();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCasesRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"pat",
            	              		lv_pat_4_0, 
            	              		"Pat");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleCases3773); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getCasesAccess().getColonKeyword_3_2());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1905:1: ( (lv_exp_6_0= ruleExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1906:1: (lv_exp_6_0= ruleExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1906:1: (lv_exp_6_0= ruleExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1907:3: lv_exp_6_0= ruleExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCasesAccess().getExpExpParserRuleCall_3_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExp_in_ruleCases3794);
            	    lv_exp_6_0=ruleExp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCasesRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"exp",
            	              		lv_exp_6_0, 
            	              		"Exp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCases"


    // $ANTLR start "entryRuleOrElseExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1931:1: entryRuleOrElseExp returns [EObject current=null] : iv_ruleOrElseExp= ruleOrElseExp EOF ;
    public final EObject entryRuleOrElseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrElseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1932:2: (iv_ruleOrElseExp= ruleOrElseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1933:2: iv_ruleOrElseExp= ruleOrElseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrElseExpRule()); 
            }
            pushFollow(FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3832);
            iv_ruleOrElseExp=ruleOrElseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrElseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrElseExp3842); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrElseExp"


    // $ANTLR start "ruleOrElseExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1940:1: ruleOrElseExp returns [EObject current=null] : (this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) ;
    public final EObject ruleOrElseExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndAlsoExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1943:28: ( (this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1944:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1944:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:5: this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrElseExpAccess().getAndAlsoExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3889);
            this_AndAlsoExp_0=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndAlsoExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1953:1: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==40) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1953:2: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1953:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1954:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleOrElseExp3910); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getOrElseExpAccess().getOrKeyword_1_1());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1963:1: ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1964:1: (lv_right_3_0= ruleAndAlsoExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1964:1: (lv_right_3_0= ruleAndAlsoExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1965:3: lv_right_3_0= ruleAndAlsoExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrElseExpAccess().getRightAndAlsoExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3931);
            	    lv_right_3_0=ruleAndAlsoExp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrElseExpRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AndAlsoExp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrElseExp"


    // $ANTLR start "entryRuleAndAlsoExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:1: entryRuleAndAlsoExp returns [EObject current=null] : iv_ruleAndAlsoExp= ruleAndAlsoExp EOF ;
    public final EObject entryRuleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndAlsoExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1990:2: (iv_ruleAndAlsoExp= ruleAndAlsoExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1991:2: iv_ruleAndAlsoExp= ruleAndAlsoExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndAlsoExpRule()); 
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp3969);
            iv_ruleAndAlsoExp=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndAlsoExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndAlsoExp3979); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndAlsoExp"


    // $ANTLR start "ruleAndAlsoExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1998:1: ruleAndAlsoExp returns [EObject current=null] : (this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )* ) ;
    public final EObject ruleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2001:28: ( (this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2002:1: (this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2002:1: (this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2003:5: this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp4026);
            this_RExp_0=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2011:1: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==41) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2011:2: () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2011:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2012:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleAndAlsoExp4047); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAndAlsoExpAccess().getAndKeyword_1_1());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2021:1: ( (lv_right_3_0= ruleRExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2022:1: (lv_right_3_0= ruleRExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2022:1: (lv_right_3_0= ruleRExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2023:3: lv_right_3_0= ruleRExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRightRExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp4068);
            	    lv_right_3_0=ruleRExp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndAlsoExpRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"RExp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndAlsoExp"


    // $ANTLR start "entryRuleRExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2047:1: entryRuleRExp returns [EObject current=null] : iv_ruleRExp= ruleRExp EOF ;
    public final EObject entryRuleRExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2048:2: (iv_ruleRExp= ruleRExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2049:2: iv_ruleRExp= ruleRExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRExpRule()); 
            }
            pushFollow(FOLLOW_ruleRExp_in_entryRuleRExp4106);
            iv_ruleRExp=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRExp4116); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRExp"


    // $ANTLR start "ruleRExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2056:1: ruleRExp returns [EObject current=null] : ( ( (lv_aexp_0_0= ruleAExp ) ) ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) ;
    public final EObject ruleRExp() throws RecognitionException {
        EObject current = null;

        EObject lv_aexp_0_0 = null;

        AntlrDatatypeRuleToken lv_sym_1_0 = null;

        EObject lv_aexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2059:28: ( ( ( (lv_aexp_0_0= ruleAExp ) ) ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2060:1: ( ( (lv_aexp_0_0= ruleAExp ) ) ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2060:1: ( ( (lv_aexp_0_0= ruleAExp ) ) ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2060:2: ( (lv_aexp_0_0= ruleAExp ) ) ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2060:2: ( (lv_aexp_0_0= ruleAExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2061:1: (lv_aexp_0_0= ruleAExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2061:1: (lv_aexp_0_0= ruleAExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2062:3: lv_aexp_0_0= ruleAExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRExpAccess().getAexpAExpParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExp_in_ruleRExp4162);
            lv_aexp_0_0=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRExpRule());
              	        }
                     		set(
                     			current, 
                     			"aexp",
                      		lv_aexp_0_0, 
                      		"AExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:2: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:3: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:3: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:4: ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2083:1: (lv_sym_1_0= ruleSYM )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2084:3: lv_sym_1_0= ruleSYM
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getSymSYMParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSYM_in_ruleRExp4194);
            	    lv_sym_1_0=ruleSYM();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRExpRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"sym",
            	              		lv_sym_1_0, 
            	              		"SYM");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2100:2: ( (lv_aexps_2_0= ruleAExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2101:1: (lv_aexps_2_0= ruleAExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2101:1: (lv_aexps_2_0= ruleAExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2102:3: lv_aexps_2_0= ruleAExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getAexpsAExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAExp_in_ruleRExp4215);
            	    lv_aexps_2_0=ruleAExp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRExpRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"aexps",
            	              		lv_aexps_2_0, 
            	              		"AExp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRExp"


    // $ANTLR start "entryRuleAExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2126:1: entryRuleAExp returns [EObject current=null] : iv_ruleAExp= ruleAExp EOF ;
    public final EObject entryRuleAExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2127:2: (iv_ruleAExp= ruleAExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2128:2: iv_ruleAExp= ruleAExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpRule()); 
            }
            pushFollow(FOLLOW_ruleAExp_in_entryRuleAExp4253);
            iv_ruleAExp=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExp4263); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAExp"


    // $ANTLR start "ruleAExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2135:1: ruleAExp returns [EObject current=null] : ( ( (lv_mexp_0_0= ruleMExp ) ) ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) ;
    public final EObject ruleAExp() throws RecognitionException {
        EObject current = null;

        Token lv_sign_1_1=null;
        Token lv_sign_1_2=null;
        EObject lv_mexp_0_0 = null;

        EObject lv_mexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2138:28: ( ( ( (lv_mexp_0_0= ruleMExp ) ) ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2139:1: ( ( (lv_mexp_0_0= ruleMExp ) ) ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2139:1: ( ( (lv_mexp_0_0= ruleMExp ) ) ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2139:2: ( (lv_mexp_0_0= ruleMExp ) ) ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2139:2: ( (lv_mexp_0_0= ruleMExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2140:1: (lv_mexp_0_0= ruleMExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2140:1: (lv_mexp_0_0= ruleMExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2141:3: lv_mexp_0_0= ruleMExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAExpAccess().getMexpMExpParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMExp_in_ruleAExp4309);
            lv_mexp_0_0=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAExpRule());
              	        }
                     		set(
                     			current, 
                     			"mexp",
                      		lv_mexp_0_0, 
                      		"MExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2157:2: ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=42 && LA38_0<=43)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2157:3: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2157:3: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2158:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2158:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==42) ) {
            	        alt37=1;
            	    }
            	    else if ( (LA37_0==43) ) {
            	        alt37=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2160:3: lv_sign_1_1= '+'
            	            {
            	            lv_sign_1_1=(Token)match(input,42,FOLLOW_42_in_ruleAExp4330); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_sign_1_1, grammarAccess.getAExpAccess().getSignPlusSignKeyword_1_0_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAExpRule());
            	              	        }
            	                     		addWithLastConsumed(current, "sign", lv_sign_1_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2172:8: lv_sign_1_2= '-'
            	            {
            	            lv_sign_1_2=(Token)match(input,43,FOLLOW_43_in_ruleAExp4359); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_sign_1_2, grammarAccess.getAExpAccess().getSignHyphenMinusKeyword_1_0_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAExpRule());
            	              	        }
            	                     		addWithLastConsumed(current, "sign", lv_sign_1_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2187:2: ( (lv_mexps_2_0= ruleMExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2188:1: (lv_mexps_2_0= ruleMExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2188:1: (lv_mexps_2_0= ruleMExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2189:3: lv_mexps_2_0= ruleMExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAExpAccess().getMexpsMExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMExp_in_ruleAExp4396);
            	    lv_mexps_2_0=ruleMExp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAExpRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"mexps",
            	              		lv_mexps_2_0, 
            	              		"MExp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAExp"


    // $ANTLR start "entryRuleMExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2213:1: entryRuleMExp returns [EObject current=null] : iv_ruleMExp= ruleMExp EOF ;
    public final EObject entryRuleMExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2214:2: (iv_ruleMExp= ruleMExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2215:2: iv_ruleMExp= ruleMExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMExpRule()); 
            }
            pushFollow(FOLLOW_ruleMExp_in_entryRuleMExp4434);
            iv_ruleMExp=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMExp4444); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMExp"


    // $ANTLR start "ruleMExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2222:1: ruleMExp returns [EObject current=null] : ( ( (lv_applyexps_0_0= ruleApplyExp ) ) (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) ;
    public final EObject ruleMExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_applyexps_0_0 = null;

        EObject lv_applyexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2225:28: ( ( ( (lv_applyexps_0_0= ruleApplyExp ) ) (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2226:1: ( ( (lv_applyexps_0_0= ruleApplyExp ) ) (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2226:1: ( ( (lv_applyexps_0_0= ruleApplyExp ) ) (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2226:2: ( (lv_applyexps_0_0= ruleApplyExp ) ) (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2226:2: ( (lv_applyexps_0_0= ruleApplyExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2227:1: (lv_applyexps_0_0= ruleApplyExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2227:1: (lv_applyexps_0_0= ruleApplyExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2228:3: lv_applyexps_0_0= ruleApplyExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMExpAccess().getApplyexpsApplyExpParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleApplyExp_in_ruleMExp4490);
            lv_applyexps_0_0=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMExpRule());
              	        }
                     		add(
                     			current, 
                     			"applyexps",
                      		lv_applyexps_0_0, 
                      		"ApplyExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2244:2: (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==44) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2244:4: otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    {
            	    otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleMExp4503); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getMExpAccess().getCircumflexAccentKeyword_1_0());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2248:1: ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2249:1: (lv_applyexps_2_0= ruleApplyExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2249:1: (lv_applyexps_2_0= ruleApplyExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2250:3: lv_applyexps_2_0= ruleApplyExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMExpAccess().getApplyexpsApplyExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleApplyExp_in_ruleMExp4524);
            	    lv_applyexps_2_0=ruleApplyExp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMExpRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"applyexps",
            	              		lv_applyexps_2_0, 
            	              		"ApplyExp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMExp"


    // $ANTLR start "entryRuleApplyExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2274:1: entryRuleApplyExp returns [EObject current=null] : iv_ruleApplyExp= ruleApplyExp EOF ;
    public final EObject entryRuleApplyExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2275:2: (iv_ruleApplyExp= ruleApplyExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2276:2: iv_ruleApplyExp= ruleApplyExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getApplyExpRule()); 
            }
            pushFollow(FOLLOW_ruleApplyExp_in_entryRuleApplyExp4562);
            iv_ruleApplyExp=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleApplyExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleApplyExp4572); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleApplyExp"


    // $ANTLR start "ruleApplyExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2283:1: ruleApplyExp returns [EObject current=null] : ( ( (lv_neg_0_0= '~' ) )? ( ( ( ruleAtomicExp ) )=> (lv_exp_1_0= ruleAtomicExp ) ) ) ;
    public final EObject ruleApplyExp() throws RecognitionException {
        EObject current = null;

        Token lv_neg_0_0=null;
        EObject lv_exp_1_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2286:28: ( ( ( (lv_neg_0_0= '~' ) )? ( ( ( ruleAtomicExp ) )=> (lv_exp_1_0= ruleAtomicExp ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2287:1: ( ( (lv_neg_0_0= '~' ) )? ( ( ( ruleAtomicExp ) )=> (lv_exp_1_0= ruleAtomicExp ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2287:1: ( ( (lv_neg_0_0= '~' ) )? ( ( ( ruleAtomicExp ) )=> (lv_exp_1_0= ruleAtomicExp ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2287:2: ( (lv_neg_0_0= '~' ) )? ( ( ( ruleAtomicExp ) )=> (lv_exp_1_0= ruleAtomicExp ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2287:2: ( (lv_neg_0_0= '~' ) )?
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2288:1: (lv_neg_0_0= '~' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2288:1: (lv_neg_0_0= '~' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2289:3: lv_neg_0_0= '~'
                    {
                    lv_neg_0_0=(Token)match(input,45,FOLLOW_45_in_ruleApplyExp4615); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_neg_0_0, grammarAccess.getApplyExpAccess().getNegTildeKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getApplyExpRule());
                      	        }
                             		setWithLastConsumed(current, "neg", true, "~");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2302:3: ( ( ( ruleAtomicExp ) )=> (lv_exp_1_0= ruleAtomicExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2302:4: ( ( ruleAtomicExp ) )=> (lv_exp_1_0= ruleAtomicExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2307:1: (lv_exp_1_0= ruleAtomicExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2308:3: lv_exp_1_0= ruleAtomicExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getApplyExpAccess().getExpAtomicExpParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAtomicExp_in_ruleApplyExp4660);
            lv_exp_1_0=ruleAtomicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getApplyExpRule());
              	        }
                     		set(
                     			current, 
                     			"exp",
                      		lv_exp_1_0, 
                      		"AtomicExp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleApplyExp"


    // $ANTLR start "entryRuleAtomicExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2332:1: entryRuleAtomicExp returns [EObject current=null] : iv_ruleAtomicExp= ruleAtomicExp EOF ;
    public final EObject entryRuleAtomicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2333:2: (iv_ruleAtomicExp= ruleAtomicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2334:2: iv_ruleAtomicExp= ruleAtomicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExpRule()); 
            }
            pushFollow(FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp4696);
            iv_ruleAtomicExp=ruleAtomicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicExp4706); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicExp"


    // $ANTLR start "ruleAtomicExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2341:1: ruleAtomicExp returns [EObject current=null] : ( ( () ruleLit ) | ( () ruleString ) | ( ( ( ( ruleQid ) )=> (lv_id_4_0= ruleQid ) ) ( ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) ) )* ) | ( () ruleConUse ) | (otherlv_9= '@' otherlv_10= '{' ( (lv_fields_11_0= ruleField ) ) (otherlv_12= ',' ( (lv_fields_13_0= ruleField ) ) )* otherlv_14= '}' ) | ( () otherlv_16= '$' ruleQid ) | (otherlv_18= '(' ( (lv_exp_19_0= ruleExp ) ) otherlv_20= ')' ( ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) ) )* ) | ( () otherlv_24= '{' ( ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )* )? otherlv_31= '}' ) | (otherlv_32= 'let' ( (lv_valDecl_33_0= ruleValueDecl ) )+ otherlv_34= 'in' ( (lv_exp_35_0= ruleExp ) ) otherlv_36= 'end' ) ) ;
    public final EObject ruleAtomicExp() throws RecognitionException {
        EObject current = null;

        Token this_DOT_5=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token this_DOT_21=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        AntlrDatatypeRuleToken lv_id_4_0 = null;

        AntlrDatatypeRuleToken lv_id_6_0 = null;

        EObject lv_fields_11_0 = null;

        EObject lv_fields_13_0 = null;

        EObject lv_exp_19_0 = null;

        AntlrDatatypeRuleToken lv_id_22_0 = null;

        AntlrDatatypeRuleToken lv_id_25_0 = null;

        EObject lv_exps_27_0 = null;

        AntlrDatatypeRuleToken lv_id_28_0 = null;

        EObject lv_exps_30_0 = null;

        EObject lv_valDecl_33_0 = null;

        EObject lv_exp_35_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2344:28: ( ( ( () ruleLit ) | ( () ruleString ) | ( ( ( ( ruleQid ) )=> (lv_id_4_0= ruleQid ) ) ( ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) ) )* ) | ( () ruleConUse ) | (otherlv_9= '@' otherlv_10= '{' ( (lv_fields_11_0= ruleField ) ) (otherlv_12= ',' ( (lv_fields_13_0= ruleField ) ) )* otherlv_14= '}' ) | ( () otherlv_16= '$' ruleQid ) | (otherlv_18= '(' ( (lv_exp_19_0= ruleExp ) ) otherlv_20= ')' ( ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) ) )* ) | ( () otherlv_24= '{' ( ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )* )? otherlv_31= '}' ) | (otherlv_32= 'let' ( (lv_valDecl_33_0= ruleValueDecl ) )+ otherlv_34= 'in' ( (lv_exp_35_0= ruleExp ) ) otherlv_36= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2345:1: ( ( () ruleLit ) | ( () ruleString ) | ( ( ( ( ruleQid ) )=> (lv_id_4_0= ruleQid ) ) ( ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) ) )* ) | ( () ruleConUse ) | (otherlv_9= '@' otherlv_10= '{' ( (lv_fields_11_0= ruleField ) ) (otherlv_12= ',' ( (lv_fields_13_0= ruleField ) ) )* otherlv_14= '}' ) | ( () otherlv_16= '$' ruleQid ) | (otherlv_18= '(' ( (lv_exp_19_0= ruleExp ) ) otherlv_20= ')' ( ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) ) )* ) | ( () otherlv_24= '{' ( ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )* )? otherlv_31= '}' ) | (otherlv_32= 'let' ( (lv_valDecl_33_0= ruleValueDecl ) )+ otherlv_34= 'in' ( (lv_exp_35_0= ruleExp ) ) otherlv_36= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2345:1: ( ( () ruleLit ) | ( () ruleString ) | ( ( ( ( ruleQid ) )=> (lv_id_4_0= ruleQid ) ) ( ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) ) )* ) | ( () ruleConUse ) | (otherlv_9= '@' otherlv_10= '{' ( (lv_fields_11_0= ruleField ) ) (otherlv_12= ',' ( (lv_fields_13_0= ruleField ) ) )* otherlv_14= '}' ) | ( () otherlv_16= '$' ruleQid ) | (otherlv_18= '(' ( (lv_exp_19_0= ruleExp ) ) otherlv_20= ')' ( ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) ) )* ) | ( () otherlv_24= '{' ( ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )* )? otherlv_31= '}' ) | (otherlv_32= 'let' ( (lv_valDecl_33_0= ruleValueDecl ) )+ otherlv_34= 'in' ( (lv_exp_35_0= ruleExp ) ) otherlv_36= 'end' ) )
            int alt47=9;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2345:2: ( () ruleLit )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2345:2: ( () ruleLit )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2345:3: () ruleLit
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2345:3: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2346:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExpAccess().getAtomicExpAction_0_0(),
                                  current);
                          
                    }

                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExpAccess().getLitParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLit_in_ruleAtomicExp4757);
                    ruleLit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2360:6: ( () ruleString )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2360:6: ( () ruleString )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2360:7: () ruleString
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2360:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2361:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExpAccess().getAtomicExpAction_1_0(),
                                  current);
                          
                    }

                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExpAccess().getStringParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleString_in_ruleAtomicExp4789);
                    ruleString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2375:6: ( ( ( ( ruleQid ) )=> (lv_id_4_0= ruleQid ) ) ( ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2375:6: ( ( ( ( ruleQid ) )=> (lv_id_4_0= ruleQid ) ) ( ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2375:7: ( ( ( ruleQid ) )=> (lv_id_4_0= ruleQid ) ) ( ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2375:7: ( ( ( ruleQid ) )=> (lv_id_4_0= ruleQid ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2375:8: ( ( ruleQid ) )=> (lv_id_4_0= ruleQid )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2380:1: (lv_id_4_0= ruleQid )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2381:3: lv_id_4_0= ruleQid
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getIdQidParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQid_in_ruleAtomicExp4827);
                    lv_id_4_0=ruleQid();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		add(
                             			current, 
                             			"id",
                              		lv_id_4_0, 
                              		"Qid");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2397:2: ( ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==RULE_DOT) ) {
                            switch ( input.LA(2) ) {
                            case RULE_LHEXCHAR:
                                {
                                int LA41_3 = input.LA(3);

                                if ( (synpred7_InternalGDSL()) ) {
                                    alt41=1;
                                }


                                }
                                break;
                            case RULE_LNHEXCHAR:
                                {
                                int LA41_4 = input.LA(3);

                                if ( (synpred7_InternalGDSL()) ) {
                                    alt41=1;
                                }


                                }
                                break;
                            case RULE_UHEXCHAR:
                                {
                                int LA41_5 = input.LA(3);

                                if ( (synpred7_InternalGDSL()) ) {
                                    alt41=1;
                                }


                                }
                                break;
                            case RULE_UNHEXCHAR:
                                {
                                int LA41_6 = input.LA(3);

                                if ( (synpred7_InternalGDSL()) ) {
                                    alt41=1;
                                }


                                }
                                break;
                            case RULE_SLASH:
                                {
                                int LA41_7 = input.LA(3);

                                if ( (synpred7_InternalGDSL()) ) {
                                    alt41=1;
                                }


                                }
                                break;

                            }

                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2397:3: ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2397:3: ( ( RULE_DOT )=>this_DOT_5= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2397:4: ( RULE_DOT )=>this_DOT_5= RULE_DOT
                    	    {
                    	    this_DOT_5=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp4845); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_5, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_2_1_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2401:2: ( (lv_id_6_0= ruleQid ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2402:1: (lv_id_6_0= ruleQid )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2402:1: (lv_id_6_0= ruleQid )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2403:3: lv_id_6_0= ruleQid
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getIdQidParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleQid_in_ruleAtomicExp4866);
                    	    lv_id_6_0=ruleQid();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"id",
                    	              		lv_id_6_0, 
                    	              		"Qid");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2420:6: ( () ruleConUse )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2420:6: ( () ruleConUse )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2420:7: () ruleConUse
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2420:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2421:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExpAccess().getAtomicExpAction_3_0(),
                                  current);
                          
                    }

                    }

                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExpAccess().getConUseParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConUse_in_ruleAtomicExp4901);
                    ruleConUse();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2435:6: (otherlv_9= '@' otherlv_10= '{' ( (lv_fields_11_0= ruleField ) ) (otherlv_12= ',' ( (lv_fields_13_0= ruleField ) ) )* otherlv_14= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2435:6: (otherlv_9= '@' otherlv_10= '{' ( (lv_fields_11_0= ruleField ) ) (otherlv_12= ',' ( (lv_fields_13_0= ruleField ) ) )* otherlv_14= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2435:8: otherlv_9= '@' otherlv_10= '{' ( (lv_fields_11_0= ruleField ) ) (otherlv_12= ',' ( (lv_fields_13_0= ruleField ) ) )* otherlv_14= '}'
                    {
                    otherlv_9=(Token)match(input,46,FOLLOW_46_in_ruleAtomicExp4920); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getAtomicExpAccess().getCommercialAtKeyword_4_0());
                          
                    }
                    otherlv_10=(Token)match(input,28,FOLLOW_28_in_ruleAtomicExp4932); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_4_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2443:1: ( (lv_fields_11_0= ruleField ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2444:1: (lv_fields_11_0= ruleField )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2444:1: (lv_fields_11_0= ruleField )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2445:3: lv_fields_11_0= ruleField
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp4953);
                    lv_fields_11_0=ruleField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		add(
                             			current, 
                             			"fields",
                              		lv_fields_11_0, 
                              		"Field");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2461:2: (otherlv_12= ',' ( (lv_fields_13_0= ruleField ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==25) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2461:4: otherlv_12= ',' ( (lv_fields_13_0= ruleField ) )
                    	    {
                    	    otherlv_12=(Token)match(input,25,FOLLOW_25_in_ruleAtomicExp4966); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_12, grammarAccess.getAtomicExpAccess().getCommaKeyword_4_3_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2465:1: ( (lv_fields_13_0= ruleField ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2466:1: (lv_fields_13_0= ruleField )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2466:1: (lv_fields_13_0= ruleField )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2467:3: lv_fields_13_0= ruleField
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_4_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp4987);
                    	    lv_fields_13_0=ruleField();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fields",
                    	              		lv_fields_13_0, 
                    	              		"Field");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleAtomicExp5001); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_4_4());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2488:6: ( () otherlv_16= '$' ruleQid )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2488:6: ( () otherlv_16= '$' ruleQid )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2488:7: () otherlv_16= '$' ruleQid
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2488:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2489:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExpAccess().getAtomicExpAction_5_0(),
                                  current);
                          
                    }

                    }

                    otherlv_16=(Token)match(input,47,FOLLOW_47_in_ruleAtomicExp5030); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getAtomicExpAccess().getDollarSignKeyword_5_1());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExpAccess().getQidParserRuleCall_5_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleQid_in_ruleAtomicExp5046);
                    ruleQid();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2507:6: (otherlv_18= '(' ( (lv_exp_19_0= ruleExp ) ) otherlv_20= ')' ( ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2507:6: (otherlv_18= '(' ( (lv_exp_19_0= ruleExp ) ) otherlv_20= ')' ( ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2507:8: otherlv_18= '(' ( (lv_exp_19_0= ruleExp ) ) otherlv_20= ')' ( ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) ) )*
                    {
                    otherlv_18=(Token)match(input,48,FOLLOW_48_in_ruleAtomicExp5065); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getAtomicExpAccess().getLeftParenthesisKeyword_6_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2511:1: ( (lv_exp_19_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2512:1: (lv_exp_19_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2512:1: (lv_exp_19_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2513:3: lv_exp_19_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpExpParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5086);
                    lv_exp_19_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_19_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_20=(Token)match(input,49,FOLLOW_49_in_ruleAtomicExp5098); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getAtomicExpAccess().getRightParenthesisKeyword_6_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2533:1: ( ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==RULE_DOT) ) {
                            switch ( input.LA(2) ) {
                            case RULE_LHEXCHAR:
                                {
                                int LA43_3 = input.LA(3);

                                if ( (synpred8_InternalGDSL()) ) {
                                    alt43=1;
                                }


                                }
                                break;
                            case RULE_LNHEXCHAR:
                                {
                                int LA43_4 = input.LA(3);

                                if ( (synpred8_InternalGDSL()) ) {
                                    alt43=1;
                                }


                                }
                                break;
                            case RULE_UHEXCHAR:
                                {
                                int LA43_5 = input.LA(3);

                                if ( (synpred8_InternalGDSL()) ) {
                                    alt43=1;
                                }


                                }
                                break;
                            case RULE_UNHEXCHAR:
                                {
                                int LA43_6 = input.LA(3);

                                if ( (synpred8_InternalGDSL()) ) {
                                    alt43=1;
                                }


                                }
                                break;
                            case RULE_SLASH:
                                {
                                int LA43_7 = input.LA(3);

                                if ( (synpred8_InternalGDSL()) ) {
                                    alt43=1;
                                }


                                }
                                break;

                            }

                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2533:2: ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2533:2: ( ( RULE_DOT )=>this_DOT_21= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2533:3: ( RULE_DOT )=>this_DOT_21= RULE_DOT
                    	    {
                    	    this_DOT_21=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp5116); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_21, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_6_3_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2537:2: ( (lv_id_22_0= ruleQid ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2538:1: (lv_id_22_0= ruleQid )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2538:1: (lv_id_22_0= ruleQid )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2539:3: lv_id_22_0= ruleQid
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getIdQidParserRuleCall_6_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleQid_in_ruleAtomicExp5137);
                    	    lv_id_22_0=ruleQid();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"id",
                    	              		lv_id_22_0, 
                    	              		"Qid");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 8 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2556:6: ( () otherlv_24= '{' ( ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )* )? otherlv_31= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2556:6: ( () otherlv_24= '{' ( ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )* )? otherlv_31= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2556:7: () otherlv_24= '{' ( ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )* )? otherlv_31= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2556:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2557:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExpAccess().getAtomicExpAction_7_0(),
                                  current);
                          
                    }

                    }

                    otherlv_24=(Token)match(input,28,FOLLOW_28_in_ruleAtomicExp5168); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_7_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2566:1: ( ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )* )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( ((LA45_0>=RULE_LHEXCHAR && LA45_0<=RULE_SLASH)) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2566:2: ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2566:2: ( (lv_id_25_0= ruleName ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2567:1: (lv_id_25_0= ruleName )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2567:1: (lv_id_25_0= ruleName )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2568:3: lv_id_25_0= ruleName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExpAccess().getIdNameParserRuleCall_7_2_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleName_in_ruleAtomicExp5190);
                            lv_id_25_0=ruleName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"id",
                                      		lv_id_25_0, 
                                      		"Name");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_26=(Token)match(input,21,FOLLOW_21_in_ruleAtomicExp5202); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_26, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_7_2_1());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2588:1: ( (lv_exps_27_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2589:1: (lv_exps_27_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2589:1: (lv_exps_27_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2590:3: lv_exps_27_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_7_2_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5223);
                            lv_exps_27_0=ruleExp();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"exps",
                                      		lv_exps_27_0, 
                                      		"Exp");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2606:2: ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )*
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==RULE_LHEXCHAR) && (synpred9_InternalGDSL())) {
                                    alt44=1;
                                }
                                else if ( (LA44_0==RULE_LNHEXCHAR) && (synpred9_InternalGDSL())) {
                                    alt44=1;
                                }
                                else if ( (LA44_0==RULE_UHEXCHAR) && (synpred9_InternalGDSL())) {
                                    alt44=1;
                                }
                                else if ( (LA44_0==RULE_UNHEXCHAR) && (synpred9_InternalGDSL())) {
                                    alt44=1;
                                }
                                else if ( (LA44_0==RULE_SLASH) && (synpred9_InternalGDSL())) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2606:3: ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2606:3: ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2606:4: ( ( ruleName ) )=> (lv_id_28_0= ruleName )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2611:1: (lv_id_28_0= ruleName )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2612:3: lv_id_28_0= ruleName
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getIdNameParserRuleCall_7_2_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleName_in_ruleAtomicExp5255);
                            	    lv_id_28_0=ruleName();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"id",
                            	              		lv_id_28_0, 
                            	              		"Name");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }

                            	    otherlv_29=(Token)match(input,21,FOLLOW_21_in_ruleAtomicExp5267); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_29, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_7_2_3_1());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2632:1: ( (lv_exps_30_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2633:1: (lv_exps_30_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2633:1: (lv_exps_30_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2634:3: lv_exps_30_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_7_2_3_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5288);
                            	    lv_exps_30_0=ruleExp();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"exps",
                            	              		lv_exps_30_0, 
                            	              		"Exp");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop44;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_31=(Token)match(input,29,FOLLOW_29_in_ruleAtomicExp5304); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_31, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_7_3());
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2655:6: (otherlv_32= 'let' ( (lv_valDecl_33_0= ruleValueDecl ) )+ otherlv_34= 'in' ( (lv_exp_35_0= ruleExp ) ) otherlv_36= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2655:6: (otherlv_32= 'let' ( (lv_valDecl_33_0= ruleValueDecl ) )+ otherlv_34= 'in' ( (lv_exp_35_0= ruleExp ) ) otherlv_36= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2655:8: otherlv_32= 'let' ( (lv_valDecl_33_0= ruleValueDecl ) )+ otherlv_34= 'in' ( (lv_exp_35_0= ruleExp ) ) otherlv_36= 'end'
                    {
                    otherlv_32=(Token)match(input,50,FOLLOW_50_in_ruleAtomicExp5324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_32, grammarAccess.getAtomicExpAccess().getLetKeyword_8_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2659:1: ( (lv_valDecl_33_0= ruleValueDecl ) )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==27) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2660:1: (lv_valDecl_33_0= ruleValueDecl )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2660:1: (lv_valDecl_33_0= ruleValueDecl )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2661:3: lv_valDecl_33_0= ruleValueDecl
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getValDeclValueDeclParserRuleCall_8_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleValueDecl_in_ruleAtomicExp5345);
                    	    lv_valDecl_33_0=ruleValueDecl();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"valDecl",
                    	              		lv_valDecl_33_0, 
                    	              		"ValueDecl");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt46 >= 1 ) break loop46;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(46, input);
                                throw eee;
                        }
                        cnt46++;
                    } while (true);

                    otherlv_34=(Token)match(input,51,FOLLOW_51_in_ruleAtomicExp5358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_34, grammarAccess.getAtomicExpAccess().getInKeyword_8_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2681:1: ( (lv_exp_35_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2682:1: (lv_exp_35_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2682:1: (lv_exp_35_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2683:3: lv_exp_35_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpExpParserRuleCall_8_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5379);
                    lv_exp_35_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_35_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_36=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExp5391); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_36, grammarAccess.getAtomicExpAccess().getEndKeyword_8_4());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicExp"


    // $ANTLR start "entryRuleField"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2711:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2712:2: (iv_ruleField= ruleField EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2713:2: iv_ruleField= ruleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_ruleField_in_entryRuleField5428);
            iv_ruleField=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleField5438); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2720:1: ruleField returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( (lv_name_4_0= ruleName ) ) ) ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_exp_2_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2723:28: ( ( ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( (lv_name_4_0= ruleName ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2724:1: ( ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( (lv_name_4_0= ruleName ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2724:1: ( ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( (lv_name_4_0= ruleName ) ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_LHEXCHAR && LA48_0<=RULE_SLASH)) ) {
                alt48=1;
            }
            else if ( (LA48_0==45) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2724:2: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2724:2: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2724:3: ( (lv_name_0_0= ruleName ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2724:3: ( (lv_name_0_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2725:1: (lv_name_0_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2725:1: (lv_name_0_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2726:3: lv_name_0_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFieldAccess().getNameNameParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleField5485);
                    lv_name_0_0=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFieldRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"Name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleField5497); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getFieldAccess().getEqualsSignKeyword_0_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2746:1: ( (lv_exp_2_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2747:1: (lv_exp_2_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2747:1: (lv_exp_2_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2748:3: lv_exp_2_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFieldAccess().getExpExpParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleField5518);
                    lv_exp_2_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFieldRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_2_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2765:6: (otherlv_3= '~' ( (lv_name_4_0= ruleName ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2765:6: (otherlv_3= '~' ( (lv_name_4_0= ruleName ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2765:8: otherlv_3= '~' ( (lv_name_4_0= ruleName ) )
                    {
                    otherlv_3=(Token)match(input,45,FOLLOW_45_in_ruleField5538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getTildeKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2769:1: ( (lv_name_4_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2770:1: (lv_name_4_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2770:1: (lv_name_4_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2771:3: lv_name_4_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFieldAccess().getNameNameParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleField5559);
                    lv_name_4_0=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFieldRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"Name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleValueDecl"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2795:1: entryRuleValueDecl returns [EObject current=null] : iv_ruleValueDecl= ruleValueDecl EOF ;
    public final EObject entryRuleValueDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2796:2: (iv_ruleValueDecl= ruleValueDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2797:2: iv_ruleValueDecl= ruleValueDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueDeclRule()); 
            }
            pushFollow(FOLLOW_ruleValueDecl_in_entryRuleValueDecl5596);
            iv_ruleValueDecl=ruleValueDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueDecl5606); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueDecl"


    // $ANTLR start "ruleValueDecl"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2804:1: ruleValueDecl returns [EObject current=null] : (otherlv_0= 'val' ruleName ( ruleName )* otherlv_3= '=' this_Exp_4= ruleExp ) ;
    public final EObject ruleValueDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_Exp_4 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2807:28: ( (otherlv_0= 'val' ruleName ( ruleName )* otherlv_3= '=' this_Exp_4= ruleExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2808:1: (otherlv_0= 'val' ruleName ( ruleName )* otherlv_3= '=' this_Exp_4= ruleExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2808:1: (otherlv_0= 'val' ruleName ( ruleName )* otherlv_3= '=' this_Exp_4= ruleExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2808:3: otherlv_0= 'val' ruleName ( ruleName )* otherlv_3= '=' this_Exp_4= ruleExp
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleValueDecl5643); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getValueDeclAccess().getValKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getValueDeclAccess().getNameParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleName_in_ruleValueDecl5659);
            ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2820:1: ( ruleName )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=RULE_LHEXCHAR && LA49_0<=RULE_SLASH)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2821:5: ruleName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getValueDeclAccess().getNameParserRuleCall_2()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleName_in_ruleValueDecl5675);
            	    ruleName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleValueDecl5688); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getValueDeclAccess().getEqualsSignKeyword_3());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getValueDeclAccess().getExpParserRuleCall_4()); 
                  
            }
            pushFollow(FOLLOW_ruleExp_in_ruleValueDecl5710);
            this_Exp_4=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Exp_4; 
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueDecl"


    // $ANTLR start "entryRuleString"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2849:1: entryRuleString returns [String current=null] : iv_ruleString= ruleString EOF ;
    public final String entryRuleString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleString = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2850:2: (iv_ruleString= ruleString EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2851:2: iv_ruleString= ruleString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringRule()); 
            }
            pushFollow(FOLLOW_ruleString_in_entryRuleString5746);
            iv_ruleString=ruleString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleString5757); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleString"


    // $ANTLR start "ruleString"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2858:1: ruleString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '\"' (this_STRCHAR_1= ruleSTRCHAR )* kw= '\"' ) ;
    public final AntlrDatatypeRuleToken ruleString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_STRCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2861:28: ( (kw= '\"' (this_STRCHAR_1= ruleSTRCHAR )* kw= '\"' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2862:1: (kw= '\"' (this_STRCHAR_1= ruleSTRCHAR )* kw= '\"' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2862:1: (kw= '\"' (this_STRCHAR_1= ruleSTRCHAR )* kw= '\"' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2863:2: kw= '\"' (this_STRCHAR_1= ruleSTRCHAR )* kw= '\"'
            {
            kw=(Token)match(input,52,FOLLOW_52_in_ruleString5795); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getStringAccess().getQuotationMarkKeyword_0()); 
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2868:1: (this_STRCHAR_1= ruleSTRCHAR )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_LHEXCHAR && LA50_0<=RULE_SLASH)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2869:5: this_STRCHAR_1= ruleSTRCHAR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getStringAccess().getSTRCHARParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleSTRCHAR_in_ruleString5818);
            	    this_STRCHAR_1=ruleSTRCHAR();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_STRCHAR_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            kw=(Token)match(input,52,FOLLOW_52_in_ruleString5838); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getStringAccess().getQuotationMarkKeyword_2()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleString"


    // $ANTLR start "entryRulePat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2893:1: entryRulePat returns [String current=null] : iv_rulePat= rulePat EOF ;
    public final String entryRulePat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2894:2: (iv_rulePat= rulePat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2895:2: iv_rulePat= rulePat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatRule()); 
            }
            pushFollow(FOLLOW_rulePat_in_entryRulePat5879);
            iv_rulePat=rulePat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePat5890); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePat"


    // $ANTLR start "rulePat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2902:1: rulePat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '_' | this_Lit_1= ruleLit | ( ( ruleName )=>this_Name_2= ruleName ) | (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? ) ) ;
    public final AntlrDatatypeRuleToken rulePat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Lit_1 = null;

        AntlrDatatypeRuleToken this_Name_2 = null;

        AntlrDatatypeRuleToken this_ConUse_3 = null;

        AntlrDatatypeRuleToken this_Pat_4 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2905:28: ( (kw= '_' | this_Lit_1= ruleLit | ( ( ruleName )=>this_Name_2= ruleName ) | (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2906:1: (kw= '_' | this_Lit_1= ruleLit | ( ( ruleName )=>this_Name_2= ruleName ) | (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2906:1: (kw= '_' | this_Lit_1= ruleLit | ( ( ruleName )=>this_Name_2= ruleName ) | (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? ) )
            int alt52=4;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==53) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_BINDIG||LA52_0==RULE_NBINDIG||LA52_0==32||LA52_0==45||LA52_0==54) ) {
                alt52=2;
            }
            else if ( (LA52_0==RULE_LHEXCHAR) && (synpred10_InternalGDSL())) {
                alt52=3;
            }
            else if ( (LA52_0==RULE_LNHEXCHAR) && (synpred10_InternalGDSL())) {
                alt52=3;
            }
            else if ( (LA52_0==RULE_UHEXCHAR) ) {
                int LA52_5 = input.LA(2);

                if ( (synpred10_InternalGDSL()) ) {
                    alt52=3;
                }
                else if ( (true) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 5, input);

                    throw nvae;
                }
            }
            else if ( (LA52_0==RULE_UNHEXCHAR) ) {
                int LA52_6 = input.LA(2);

                if ( (synpred10_InternalGDSL()) ) {
                    alt52=3;
                }
                else if ( (true) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 6, input);

                    throw nvae;
                }
            }
            else if ( (LA52_0==RULE_SLASH) && (synpred10_InternalGDSL())) {
                alt52=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2907:2: kw= '_'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_rulePat5928); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPatAccess().get_Keyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2914:5: this_Lit_1= ruleLit
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatAccess().getLitParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLit_in_rulePat5956);
                    this_Lit_1=ruleLit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Lit_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2925:6: ( ( ruleName )=>this_Name_2= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2925:6: ( ( ruleName )=>this_Name_2= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2925:7: ( ruleName )=>this_Name_2= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatAccess().getNameParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleName_in_rulePat5995);
                    this_Name_2=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Name_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2937:6: (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2937:6: (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2938:5: this_ConUse_3= ruleConUse (this_Pat_4= rulePat )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatAccess().getConUseParserRuleCall_3_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConUse_in_rulePat6030);
                    this_ConUse_3=ruleConUse();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ConUse_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2948:1: (this_Pat_4= rulePat )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( ((LA51_0>=RULE_LHEXCHAR && LA51_0<=RULE_SLASH)||LA51_0==RULE_BINDIG||LA51_0==RULE_NBINDIG||LA51_0==32||LA51_0==45||(LA51_0>=53 && LA51_0<=54)) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2949:5: this_Pat_4= rulePat
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getPatAccess().getPatParserRuleCall_3_1()); 
                                  
                            }
                            pushFollow(FOLLOW_rulePat_in_rulePat6058);
                            this_Pat_4=rulePat();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_Pat_4);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePat"


    // $ANTLR start "entryRuleLit"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2967:1: entryRuleLit returns [String current=null] : iv_ruleLit= ruleLit EOF ;
    public final String entryRuleLit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLit = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2968:2: (iv_ruleLit= ruleLit EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2969:2: iv_ruleLit= ruleLit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLitRule()); 
            }
            pushFollow(FOLLOW_ruleLit_in_entryRuleLit6107);
            iv_ruleLit=ruleLit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLit.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLit6118); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLit"


    // $ANTLR start "ruleLit"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2976:1: ruleLit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Int_0= ruleInt | (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' ) ) ;
    public final AntlrDatatypeRuleToken ruleLit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Int_0 = null;

        AntlrDatatypeRuleToken this_BITSTR_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2979:28: ( (this_Int_0= ruleInt | (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2980:1: (this_Int_0= ruleInt | (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2980:1: (this_Int_0= ruleInt | (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_BINDIG||LA54_0==RULE_NBINDIG||LA54_0==45||LA54_0==54) ) {
                alt54=1;
            }
            else if ( (LA54_0==32) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2981:5: this_Int_0= ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLitAccess().getIntParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInt_in_ruleLit6165);
                    this_Int_0=ruleInt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Int_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2992:6: (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2992:6: (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2993:2: kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\''
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleLit6190); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLitAccess().getApostropheKeyword_1_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2998:1: (this_BITSTR_2= ruleBITSTR )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( ((LA53_0>=RULE_PIPE && LA53_0<=RULE_DOT)||(LA53_0>=RULE_BINDIG && LA53_0<=RULE_BS)) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2999:5: this_BITSTR_2= ruleBITSTR
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getLitAccess().getBITSTRParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBITSTR_in_ruleLit6213);
                            this_BITSTR_2=ruleBITSTR();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_BITSTR_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;

                    }

                    kw=(Token)match(input,32,FOLLOW_32_in_ruleLit6233); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLitAccess().getApostropheKeyword_1_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLit"


    // $ANTLR start "entryRulePrimBitPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3023:1: entryRulePrimBitPat returns [String current=null] : iv_rulePrimBitPat= rulePrimBitPat EOF ;
    public final String entryRulePrimBitPat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimBitPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3024:2: (iv_rulePrimBitPat= rulePrimBitPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3025:2: iv_rulePrimBitPat= rulePrimBitPat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimBitPatRule()); 
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat6275);
            iv_rulePrimBitPat=rulePrimBitPat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimBitPat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimBitPat6286); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimBitPat"


    // $ANTLR start "rulePrimBitPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3032:1: rulePrimBitPat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) ) ;
    public final AntlrDatatypeRuleToken rulePrimBitPat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BITSTR_0 = null;

        AntlrDatatypeRuleToken this_Qid_1 = null;

        AntlrDatatypeRuleToken this_BitPatOrInt_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3035:28: ( ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3036:1: ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3036:1: ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_BINDIG) && (synpred11_InternalGDSL())) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_BS) && (synpred11_InternalGDSL())) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_DOT) && (synpred11_InternalGDSL())) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_PIPE) && (synpred11_InternalGDSL())) {
                alt56=1;
            }
            else if ( ((LA56_0>=RULE_LHEXCHAR && LA56_0<=RULE_SLASH)) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3036:2: ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3036:2: ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3036:3: ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimBitPatAccess().getBITSTRParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBITSTR_in_rulePrimBitPat6339);
                    this_BITSTR_0=ruleBITSTR();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BITSTR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3048:6: (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3048:6: (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3049:5: this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimBitPatAccess().getQidParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleQid_in_rulePrimBitPat6374);
                    this_Qid_1=ruleQid();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Qid_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3059:1: (this_BitPatOrInt_2= ruleBitPatOrInt )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==31||LA55_0==46) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3060:5: this_BitPatOrInt_2= ruleBitPatOrInt
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getPrimBitPatAccess().getBitPatOrIntParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBitPatOrInt_in_rulePrimBitPat6402);
                            this_BitPatOrInt_2=ruleBitPatOrInt();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_BitPatOrInt_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimBitPat"


    // $ANTLR start "entryRuleBitPatOrInt"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3078:1: entryRuleBitPatOrInt returns [String current=null] : iv_ruleBitPatOrInt= ruleBitPatOrInt EOF ;
    public final String entryRuleBitPatOrInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitPatOrInt = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3079:2: (iv_ruleBitPatOrInt= ruleBitPatOrInt EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3080:2: iv_ruleBitPatOrInt= ruleBitPatOrInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitPatOrIntRule()); 
            }
            pushFollow(FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt6451);
            iv_ruleBitPatOrInt=ruleBitPatOrInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitPatOrInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPatOrInt6462); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitPatOrInt"


    // $ANTLR start "ruleBitPatOrInt"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3087:1: ruleBitPatOrInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) ) ;
    public final AntlrDatatypeRuleToken ruleBitPatOrInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_POSINT_1 = null;

        AntlrDatatypeRuleToken this_BITSTR_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3090:28: ( ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3091:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3091:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==31) ) {
                alt57=1;
            }
            else if ( (LA57_0==46) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3091:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3091:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3092:2: kw= ':' this_POSINT_1= rulePOSINT
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleBitPatOrInt6501); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBitPatOrIntAccess().getColonKeyword_0_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBitPatOrIntAccess().getPOSINTParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleBitPatOrInt6523);
                    this_POSINT_1=rulePOSINT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_POSINT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3109:6: (kw= '@' this_BITSTR_3= ruleBITSTR )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3109:6: (kw= '@' this_BITSTR_3= ruleBITSTR )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3110:2: kw= '@' this_BITSTR_3= ruleBITSTR
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleBitPatOrInt6549); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBitPatOrIntAccess().getCommercialAtKeyword_1_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBitPatOrIntAccess().getBITSTRParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBITSTR_in_ruleBitPatOrInt6571);
                    this_BITSTR_3=ruleBITSTR();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BITSTR_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitPatOrInt"


    // $ANTLR start "entryRuleInt"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3134:1: entryRuleInt returns [String current=null] : iv_ruleInt= ruleInt EOF ;
    public final String entryRuleInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInt = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3135:2: (iv_ruleInt= ruleInt EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3136:2: iv_ruleInt= ruleInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntRule()); 
            }
            pushFollow(FOLLOW_ruleInt_in_entryRuleInt6618);
            iv_ruleInt=ruleInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInt6629); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInt"


    // $ANTLR start "ruleInt"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3143:1: ruleInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT ) ;
    public final AntlrDatatypeRuleToken ruleInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_POSINT_0 = null;

        AntlrDatatypeRuleToken this_NEGINT_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3146:28: ( (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3147:1: (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3147:1: (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_BINDIG||LA58_0==RULE_NBINDIG||LA58_0==54) ) {
                alt58=1;
            }
            else if ( (LA58_0==45) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3148:5: this_POSINT_0= rulePOSINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIntAccess().getPOSINTParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleInt6676);
                    this_POSINT_0=rulePOSINT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_POSINT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3160:5: this_NEGINT_1= ruleNEGINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIntAccess().getNEGINTParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNEGINT_in_ruleInt6709);
                    this_NEGINT_1=ruleNEGINT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NEGINT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInt"


    // $ANTLR start "entryRuleName"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3178:1: entryRuleName returns [String current=null] : iv_ruleName= ruleName EOF ;
    public final String entryRuleName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleName = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3179:2: (iv_ruleName= ruleName EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3180:2: iv_ruleName= ruleName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameRule()); 
            }
            pushFollow(FOLLOW_ruleName_in_entryRuleName6755);
            iv_ruleName=ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleName6766); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleName"


    // $ANTLR start "ruleName"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3187:1: ruleName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3190:28: (this_ID_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3192:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNameAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleID_in_ruleName6812);
            this_ID_0=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleName"


    // $ANTLR start "entryRuleConBind"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3210:1: entryRuleConBind returns [String current=null] : iv_ruleConBind= ruleConBind EOF ;
    public final String entryRuleConBind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3211:2: (iv_ruleConBind= ruleConBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3212:2: iv_ruleConBind= ruleConBind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConBindRule()); 
            }
            pushFollow(FOLLOW_ruleConBind_in_entryRuleConBind6857);
            iv_ruleConBind=ruleConBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConBind.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConBind6868); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConBind"


    // $ANTLR start "ruleConBind"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3219:1: ruleConBind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CONS_0= ruleCONS ;
    public final AntlrDatatypeRuleToken ruleConBind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_CONS_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3222:28: (this_CONS_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3224:5: this_CONS_0= ruleCONS
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConBindAccess().getCONSParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConBind6914);
            this_CONS_0=ruleCONS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_CONS_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConBind"


    // $ANTLR start "entryRuleConUse"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3242:1: entryRuleConUse returns [String current=null] : iv_ruleConUse= ruleConUse EOF ;
    public final String entryRuleConUse() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConUse = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3243:2: (iv_ruleConUse= ruleConUse EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3244:2: iv_ruleConUse= ruleConUse EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConUseRule()); 
            }
            pushFollow(FOLLOW_ruleConUse_in_entryRuleConUse6959);
            iv_ruleConUse=ruleConUse();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConUse.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConUse6970); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConUse"


    // $ANTLR start "ruleConUse"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3251:1: ruleConUse returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CONS_0= ruleCONS ;
    public final AntlrDatatypeRuleToken ruleConUse() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_CONS_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3254:28: (this_CONS_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3256:5: this_CONS_0= ruleCONS
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConUseAccess().getCONSParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConUse7016);
            this_CONS_0=ruleCONS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_CONS_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConUse"


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3274:1: entryRuleQid returns [String current=null] : iv_ruleQid= ruleQid EOF ;
    public final String entryRuleQid() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQid = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3275:2: (iv_ruleQid= ruleQid EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3276:2: iv_ruleQid= ruleQid EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQidRule()); 
            }
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid7061);
            iv_ruleQid=ruleQid();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQid.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid7072); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQid"


    // $ANTLR start "ruleQid"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3283:1: ruleQid returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleQid() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3286:28: (this_ID_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3288:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQidAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleID_in_ruleQid7118);
            this_ID_0=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQid"


    // $ANTLR start "entryRulePOSINT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3306:1: entryRulePOSINT returns [String current=null] : iv_rulePOSINT= rulePOSINT EOF ;
    public final String entryRulePOSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePOSINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3307:2: (iv_rulePOSINT= rulePOSINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3308:2: iv_rulePOSINT= rulePOSINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPOSINTRule()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT7163);
            iv_rulePOSINT=rulePOSINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePOSINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT7174); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePOSINT"


    // $ANTLR start "rulePOSINT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3315:1: rulePOSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM ) ;
    public final AntlrDatatypeRuleToken rulePOSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_NUM_0 = null;

        AntlrDatatypeRuleToken this_HEXNUM_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3318:28: ( (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3319:1: (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3319:1: (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_BINDIG||LA59_0==RULE_NBINDIG) ) {
                alt59=1;
            }
            else if ( (LA59_0==54) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3320:5: this_NUM_0= ruleNUM
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPOSINTAccess().getNUMParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNUM_in_rulePOSINT7221);
                    this_NUM_0=ruleNUM();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NUM_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3332:5: this_HEXNUM_1= ruleHEXNUM
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPOSINTAccess().getHEXNUMParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleHEXNUM_in_rulePOSINT7254);
                    this_HEXNUM_1=ruleHEXNUM();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXNUM_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePOSINT"


    // $ANTLR start "entryRuleNEGINT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3350:1: entryRuleNEGINT returns [String current=null] : iv_ruleNEGINT= ruleNEGINT EOF ;
    public final String entryRuleNEGINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNEGINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3351:2: (iv_ruleNEGINT= ruleNEGINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3352:2: iv_ruleNEGINT= ruleNEGINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNEGINTRule()); 
            }
            pushFollow(FOLLOW_ruleNEGINT_in_entryRuleNEGINT7300);
            iv_ruleNEGINT=ruleNEGINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNEGINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNEGINT7311); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNEGINT"


    // $ANTLR start "ruleNEGINT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3359:1: ruleNEGINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '~' this_NUM_1= ruleNUM ) ;
    public final AntlrDatatypeRuleToken ruleNEGINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_NUM_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3362:28: ( (kw= '~' this_NUM_1= ruleNUM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3363:1: (kw= '~' this_NUM_1= ruleNUM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3363:1: (kw= '~' this_NUM_1= ruleNUM )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3364:2: kw= '~' this_NUM_1= ruleNUM
            {
            kw=(Token)match(input,45,FOLLOW_45_in_ruleNEGINT7349); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getNEGINTAccess().getTildeKeyword_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNEGINTAccess().getNUMParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleNUM_in_ruleNEGINT7371);
            this_NUM_1=ruleNUM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_NUM_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNEGINT"


    // $ANTLR start "entryRuleNUM"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3388:1: entryRuleNUM returns [String current=null] : iv_ruleNUM= ruleNUM EOF ;
    public final String entryRuleNUM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3389:2: (iv_ruleNUM= ruleNUM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3390:2: iv_ruleNUM= ruleNUM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMRule()); 
            }
            pushFollow(FOLLOW_ruleNUM_in_entryRuleNUM7417);
            iv_ruleNUM=ruleNUM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUM7428); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNUM"


    // $ANTLR start "ruleNUM"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3397:1: ruleNUM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( ruleDIG )=>this_DIG_0= ruleDIG )+ ;
    public final AntlrDatatypeRuleToken ruleNUM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DIG_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3400:28: ( ( ( ruleDIG )=>this_DIG_0= ruleDIG )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3401:1: ( ( ruleDIG )=>this_DIG_0= ruleDIG )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3401:1: ( ( ruleDIG )=>this_DIG_0= ruleDIG )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_BINDIG) ) {
                    int LA60_1 = input.LA(2);

                    if ( (synpred12_InternalGDSL()) ) {
                        alt60=1;
                    }


                }
                else if ( (LA60_0==RULE_NBINDIG) ) {
                    int LA60_3 = input.LA(2);

                    if ( (synpred12_InternalGDSL()) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3401:2: ( ruleDIG )=>this_DIG_0= ruleDIG
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleDIG_in_ruleNUM7480);
            	    this_DIG_0=ruleDIG();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_DIG_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNUM"


    // $ANTLR start "entryRuleHEXNUM"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3420:1: entryRuleHEXNUM returns [String current=null] : iv_ruleHEXNUM= ruleHEXNUM EOF ;
    public final String entryRuleHEXNUM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXNUM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3421:2: (iv_ruleHEXNUM= ruleHEXNUM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3422:2: iv_ruleHEXNUM= ruleHEXNUM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHEXNUMRule()); 
            }
            pushFollow(FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM7527);
            iv_ruleHEXNUM=ruleHEXNUM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXNUM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXNUM7538); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHEXNUM"


    // $ANTLR start "ruleHEXNUM"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3429:1: ruleHEXNUM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ ) ;
    public final AntlrDatatypeRuleToken ruleHEXNUM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_HEXDIGIT_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3432:28: ( (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3433:1: (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3433:1: (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3434:2: kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+
            {
            kw=(Token)match(input,54,FOLLOW_54_in_ruleHEXNUM7576); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getHEXNUMAccess().getXKeyword_0()); 
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3439:1: ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                switch ( input.LA(1) ) {
                case RULE_BINDIG:
                    {
                    int LA61_1 = input.LA(2);

                    if ( (synpred13_InternalGDSL()) ) {
                        alt61=1;
                    }


                    }
                    break;
                case RULE_LHEXCHAR:
                    {
                    int LA61_3 = input.LA(2);

                    if ( (synpred13_InternalGDSL()) ) {
                        alt61=1;
                    }


                    }
                    break;
                case RULE_UHEXCHAR:
                    {
                    int LA61_4 = input.LA(2);

                    if ( (synpred13_InternalGDSL()) ) {
                        alt61=1;
                    }


                    }
                    break;
                case RULE_NBINDIG:
                    {
                    int LA61_5 = input.LA(2);

                    if ( (synpred13_InternalGDSL()) ) {
                        alt61=1;
                    }


                    }
                    break;

                }

                switch (alt61) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3439:2: ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleHEXDIGIT_in_ruleHEXNUM7604);
            	    this_HEXDIGIT_1=ruleHEXDIGIT();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_HEXDIGIT_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHEXNUM"


    // $ANTLR start "entryRuleBITSTR"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3460:1: entryRuleBITSTR returns [String current=null] : iv_ruleBITSTR= ruleBITSTR EOF ;
    public final String entryRuleBITSTR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITSTR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3461:2: (iv_ruleBITSTR= ruleBITSTR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3462:2: iv_ruleBITSTR= ruleBITSTR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITSTRRule()); 
            }
            pushFollow(FOLLOW_ruleBITSTR_in_entryRuleBITSTR7654);
            iv_ruleBITSTR=ruleBITSTR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITSTR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITSTR7665); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBITSTR"


    // $ANTLR start "ruleBITSTR"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3469:1: ruleBITSTR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+ ;
    public final AntlrDatatypeRuleToken ruleBITSTR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BINARY_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3472:28: ( ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3473:1: ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3473:1: ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case RULE_BINDIG:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred14_InternalGDSL()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case RULE_BS:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred14_InternalGDSL()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case RULE_DOT:
                    {
                    int LA62_4 = input.LA(2);

                    if ( (synpred14_InternalGDSL()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case RULE_PIPE:
                    {
                    int LA62_5 = input.LA(2);

                    if ( (synpred14_InternalGDSL()) ) {
                        alt62=1;
                    }


                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3473:2: ( ruleBINARY )=>this_BINARY_0= ruleBINARY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleBINARY_in_ruleBITSTR7717);
            	    this_BINARY_0=ruleBINARY();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_BINARY_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBITSTR"


    // $ANTLR start "entryRuleMIXID"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3492:1: entryRuleMIXID returns [String current=null] : iv_ruleMIXID= ruleMIXID EOF ;
    public final String entryRuleMIXID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMIXID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3493:2: (iv_ruleMIXID= ruleMIXID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3494:2: iv_ruleMIXID= ruleMIXID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMIXIDRule()); 
            }
            pushFollow(FOLLOW_ruleMIXID_in_entryRuleMIXID7764);
            iv_ruleMIXID=ruleMIXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMIXID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMIXID7775); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMIXID"


    // $ANTLR start "ruleMIXID"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3501:1: ruleMIXID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '_' ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )+ ) ;
    public final AntlrDatatypeRuleToken ruleMIXID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_IDCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3504:28: ( (kw= '_' ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3505:1: (kw= '_' ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3505:1: (kw= '_' ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3506:2: kw= '_' ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )+
            {
            kw=(Token)match(input,53,FOLLOW_53_in_ruleMIXID7813); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getMIXIDAccess().get_Keyword_0()); 
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3511:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                alt63 = dfa63.predict(input);
                switch (alt63) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3511:2: ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMIXIDAccess().getIDCHARParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleIDCHAR_in_ruleMIXID7841);
            	    this_IDCHAR_1=ruleIDCHAR();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_IDCHAR_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMIXID"


    // $ANTLR start "entryRuleCONS"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3530:1: entryRuleCONS returns [String current=null] : iv_ruleCONS= ruleCONS EOF ;
    public final String entryRuleCONS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCONS = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3531:2: (iv_ruleCONS= ruleCONS EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3532:2: iv_ruleCONS= ruleCONS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCONSRule()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS7889);
            iv_ruleCONS=ruleCONS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCONS.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS7900); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCONS"


    // $ANTLR start "ruleCONS"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3539:1: ruleCONS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) ;
    public final AntlrDatatypeRuleToken ruleCONS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ULETTER_0 = null;

        AntlrDatatypeRuleToken this_IDCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3542:28: ( (this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3543:1: (this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3543:1: (this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3544:5: this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCONSAccess().getULETTERParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleULETTER_in_ruleCONS7947);
            this_ULETTER_0=ruleULETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ULETTER_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3554:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            loop64:
            do {
                int alt64=2;
                alt64 = dfa64.predict(input);
                switch (alt64) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3554:2: ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getCONSAccess().getIDCHARParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleIDCHAR_in_ruleCONS7980);
            	    this_IDCHAR_1=ruleIDCHAR();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_IDCHAR_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCONS"


    // $ANTLR start "entryRuleID"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3573:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3574:2: (iv_ruleID= ruleID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3575:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FOLLOW_ruleID_in_entryRuleID8028);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleID8039); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleID"


    // $ANTLR start "ruleID"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3582:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_LETTER_0 = null;

        AntlrDatatypeRuleToken this_IDCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3585:28: ( (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3586:1: (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3586:1: (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3587:5: this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIDAccess().getLETTERParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLETTER_in_ruleID8086);
            this_LETTER_0=ruleLETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_LETTER_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3597:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            loop65:
            do {
                int alt65=2;
                alt65 = dfa65.predict(input);
                switch (alt65) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3597:2: ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getIDAccess().getIDCHARParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleIDCHAR_in_ruleID8119);
            	    this_IDCHAR_1=ruleIDCHAR();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_IDCHAR_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleID"


    // $ANTLR start "entryRuleSTRCHAR"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3616:1: entryRuleSTRCHAR returns [String current=null] : iv_ruleSTRCHAR= ruleSTRCHAR EOF ;
    public final String entryRuleSTRCHAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRCHAR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3617:2: (iv_ruleSTRCHAR= ruleSTRCHAR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3618:2: iv_ruleSTRCHAR= ruleSTRCHAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTRCHARRule()); 
            }
            pushFollow(FOLLOW_ruleSTRCHAR_in_entryRuleSTRCHAR8167);
            iv_ruleSTRCHAR=ruleSTRCHAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTRCHAR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTRCHAR8178); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTRCHAR"


    // $ANTLR start "ruleSTRCHAR"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3625:1: ruleSTRCHAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_LETTER_0= ruleLETTER ;
    public final AntlrDatatypeRuleToken ruleSTRCHAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_LETTER_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3628:28: (this_LETTER_0= ruleLETTER )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3630:5: this_LETTER_0= ruleLETTER
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSTRCHARAccess().getLETTERParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleLETTER_in_ruleSTRCHAR8224);
            this_LETTER_0=ruleLETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_LETTER_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTRCHAR"


    // $ANTLR start "entryRuleHEXDIGIT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3648:1: entryRuleHEXDIGIT returns [String current=null] : iv_ruleHEXDIGIT= ruleHEXDIGIT EOF ;
    public final String entryRuleHEXDIGIT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXDIGIT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3649:2: (iv_ruleHEXDIGIT= ruleHEXDIGIT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3650:2: iv_ruleHEXDIGIT= ruleHEXDIGIT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHEXDIGITRule()); 
            }
            pushFollow(FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT8269);
            iv_ruleHEXDIGIT=ruleHEXDIGIT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXDIGIT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXDIGIT8280); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHEXDIGIT"


    // $ANTLR start "ruleHEXDIGIT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3657:1: ruleHEXDIGIT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR ) ;
    public final AntlrDatatypeRuleToken ruleHEXDIGIT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DIG_0 = null;

        AntlrDatatypeRuleToken this_HEXCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3660:28: ( (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3661:1: (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3661:1: (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_BINDIG||LA66_0==RULE_NBINDIG) ) {
                alt66=1;
            }
            else if ( ((LA66_0>=RULE_LHEXCHAR && LA66_0<=RULE_UHEXCHAR)) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3662:5: this_DIG_0= ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getHEXDIGITAccess().getDIGParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDIG_in_ruleHEXDIGIT8327);
                    this_DIG_0=ruleDIG();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DIG_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3674:5: this_HEXCHAR_1= ruleHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getHEXDIGITAccess().getHEXCHARParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleHEXCHAR_in_ruleHEXDIGIT8360);
                    this_HEXCHAR_1=ruleHEXCHAR();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXCHAR_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHEXDIGIT"


    // $ANTLR start "entryRuleHEXCHAR"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3692:1: entryRuleHEXCHAR returns [String current=null] : iv_ruleHEXCHAR= ruleHEXCHAR EOF ;
    public final String entryRuleHEXCHAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXCHAR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3693:2: (iv_ruleHEXCHAR= ruleHEXCHAR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3694:2: iv_ruleHEXCHAR= ruleHEXCHAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHEXCHARRule()); 
            }
            pushFollow(FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR8406);
            iv_ruleHEXCHAR=ruleHEXCHAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXCHAR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXCHAR8417); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHEXCHAR"


    // $ANTLR start "ruleHEXCHAR"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3701:1: ruleHEXCHAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR ) ;
    public final AntlrDatatypeRuleToken ruleHEXCHAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LHEXCHAR_0=null;
        Token this_UHEXCHAR_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3704:28: ( (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3705:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3705:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_LHEXCHAR) ) {
                alt67=1;
            }
            else if ( (LA67_0==RULE_UHEXCHAR) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3705:6: this_LHEXCHAR_0= RULE_LHEXCHAR
                    {
                    this_LHEXCHAR_0=(Token)match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_ruleHEXCHAR8457); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LHEXCHAR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LHEXCHAR_0, grammarAccess.getHEXCHARAccess().getLHEXCHARTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3713:10: this_UHEXCHAR_1= RULE_UHEXCHAR
                    {
                    this_UHEXCHAR_1=(Token)match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_ruleHEXCHAR8483); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UHEXCHAR_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_UHEXCHAR_1, grammarAccess.getHEXCHARAccess().getUHEXCHARTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHEXCHAR"


    // $ANTLR start "entryRuleULETTER"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3728:1: entryRuleULETTER returns [String current=null] : iv_ruleULETTER= ruleULETTER EOF ;
    public final String entryRuleULETTER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleULETTER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3729:2: (iv_ruleULETTER= ruleULETTER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3730:2: iv_ruleULETTER= ruleULETTER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getULETTERRule()); 
            }
            pushFollow(FOLLOW_ruleULETTER_in_entryRuleULETTER8529);
            iv_ruleULETTER=ruleULETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleULETTER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleULETTER8540); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleULETTER"


    // $ANTLR start "ruleULETTER"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3737:1: ruleULETTER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR ) ;
    public final AntlrDatatypeRuleToken ruleULETTER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_UHEXCHAR_0=null;
        Token this_UNHEXCHAR_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3740:28: ( (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3741:1: (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3741:1: (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_UHEXCHAR) ) {
                alt68=1;
            }
            else if ( (LA68_0==RULE_UNHEXCHAR) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3741:6: this_UHEXCHAR_0= RULE_UHEXCHAR
                    {
                    this_UHEXCHAR_0=(Token)match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_ruleULETTER8580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UHEXCHAR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_UHEXCHAR_0, grammarAccess.getULETTERAccess().getUHEXCHARTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3749:10: this_UNHEXCHAR_1= RULE_UNHEXCHAR
                    {
                    this_UNHEXCHAR_1=(Token)match(input,RULE_UNHEXCHAR,FOLLOW_RULE_UNHEXCHAR_in_ruleULETTER8606); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UNHEXCHAR_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_UNHEXCHAR_1, grammarAccess.getULETTERAccess().getUNHEXCHARTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleULETTER"


    // $ANTLR start "entryRuleLETTER"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3764:1: entryRuleLETTER returns [String current=null] : iv_ruleLETTER= ruleLETTER EOF ;
    public final String entryRuleLETTER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLETTER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3765:2: (iv_ruleLETTER= ruleLETTER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3766:2: iv_ruleLETTER= ruleLETTER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLETTERRule()); 
            }
            pushFollow(FOLLOW_ruleLETTER_in_entryRuleLETTER8652);
            iv_ruleLETTER=ruleLETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLETTER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLETTER8663); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLETTER"


    // $ANTLR start "ruleLETTER"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3773:1: ruleLETTER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH ) ;
    public final AntlrDatatypeRuleToken ruleLETTER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LHEXCHAR_0=null;
        Token this_LNHEXCHAR_1=null;
        Token this_SLASH_3=null;
        AntlrDatatypeRuleToken this_ULETTER_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3776:28: ( (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3777:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3777:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH )
            int alt69=4;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
                {
                alt69=1;
                }
                break;
            case RULE_LNHEXCHAR:
                {
                alt69=2;
                }
                break;
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
                {
                alt69=3;
                }
                break;
            case RULE_SLASH:
                {
                alt69=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3777:6: this_LHEXCHAR_0= RULE_LHEXCHAR
                    {
                    this_LHEXCHAR_0=(Token)match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_ruleLETTER8703); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LHEXCHAR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LHEXCHAR_0, grammarAccess.getLETTERAccess().getLHEXCHARTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3785:10: this_LNHEXCHAR_1= RULE_LNHEXCHAR
                    {
                    this_LNHEXCHAR_1=(Token)match(input,RULE_LNHEXCHAR,FOLLOW_RULE_LNHEXCHAR_in_ruleLETTER8729); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LNHEXCHAR_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LNHEXCHAR_1, grammarAccess.getLETTERAccess().getLNHEXCHARTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3794:5: this_ULETTER_2= ruleULETTER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLETTERAccess().getULETTERParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleULETTER_in_ruleLETTER8762);
                    this_ULETTER_2=ruleULETTER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ULETTER_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3805:10: this_SLASH_3= RULE_SLASH
                    {
                    this_SLASH_3=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleLETTER8788); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SLASH_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SLASH_3, grammarAccess.getLETTERAccess().getSLASHTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLETTER"


    // $ANTLR start "entryRuleIDCHAR"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3820:1: entryRuleIDCHAR returns [String current=null] : iv_ruleIDCHAR= ruleIDCHAR EOF ;
    public final String entryRuleIDCHAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDCHAR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3821:2: (iv_ruleIDCHAR= ruleIDCHAR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3822:2: iv_ruleIDCHAR= ruleIDCHAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDCHARRule()); 
            }
            pushFollow(FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR8834);
            iv_ruleIDCHAR=ruleIDCHAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIDCHAR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDCHAR8845); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIDCHAR"


    // $ANTLR start "ruleIDCHAR"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3829:1: ruleIDCHAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM ) ;
    public final AntlrDatatypeRuleToken ruleIDCHAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CHARSYM_2=null;
        AntlrDatatypeRuleToken this_LETTER_0 = null;

        AntlrDatatypeRuleToken this_DIG_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3832:28: ( (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3833:1: (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3833:1: (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM )
            int alt70=3;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
                {
                alt70=1;
                }
                break;
            case RULE_BINDIG:
            case RULE_NBINDIG:
                {
                alt70=2;
                }
                break;
            case RULE_CHARSYM:
                {
                alt70=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3834:5: this_LETTER_0= ruleLETTER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIDCHARAccess().getLETTERParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLETTER_in_ruleIDCHAR8892);
                    this_LETTER_0=ruleLETTER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LETTER_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3846:5: this_DIG_1= ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIDCHARAccess().getDIGParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDIG_in_ruleIDCHAR8925);
                    this_DIG_1=ruleDIG();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DIG_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3857:10: this_CHARSYM_2= RULE_CHARSYM
                    {
                    this_CHARSYM_2=(Token)match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_ruleIDCHAR8951); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CHARSYM_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_CHARSYM_2, grammarAccess.getIDCHARAccess().getCHARSYMTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIDCHAR"


    // $ANTLR start "entryRuleBINARY"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3872:1: entryRuleBINARY returns [String current=null] : iv_ruleBINARY= ruleBINARY EOF ;
    public final String entryRuleBINARY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBINARY = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3873:2: (iv_ruleBINARY= ruleBINARY EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3874:2: iv_ruleBINARY= ruleBINARY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBINARYRule()); 
            }
            pushFollow(FOLLOW_ruleBINARY_in_entryRuleBINARY8997);
            iv_ruleBINARY=ruleBINARY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBINARY.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBINARY9008); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBINARY"


    // $ANTLR start "ruleBINARY"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3881:1: ruleBINARY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE ) ;
    public final AntlrDatatypeRuleToken ruleBINARY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINDIG_0=null;
        Token this_BS_1=null;
        Token this_DOT_2=null;
        Token this_PIPE_3=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3884:28: ( (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3885:1: (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3885:1: (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE )
            int alt71=4;
            switch ( input.LA(1) ) {
            case RULE_BINDIG:
                {
                alt71=1;
                }
                break;
            case RULE_BS:
                {
                alt71=2;
                }
                break;
            case RULE_DOT:
                {
                alt71=3;
                }
                break;
            case RULE_PIPE:
                {
                alt71=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3885:6: this_BINDIG_0= RULE_BINDIG
                    {
                    this_BINDIG_0=(Token)match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_ruleBINARY9048); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINDIG_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINDIG_0, grammarAccess.getBINARYAccess().getBINDIGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3893:10: this_BS_1= RULE_BS
                    {
                    this_BS_1=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleBINARY9074); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_1, grammarAccess.getBINARYAccess().getBSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3901:10: this_DOT_2= RULE_DOT
                    {
                    this_DOT_2=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleBINARY9100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_2, grammarAccess.getBINARYAccess().getDOTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3909:10: this_PIPE_3= RULE_PIPE
                    {
                    this_PIPE_3=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleBINARY9126); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_PIPE_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_PIPE_3, grammarAccess.getBINARYAccess().getPIPETerminalRuleCall_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBINARY"


    // $ANTLR start "entryRuleDIG"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3924:1: entryRuleDIG returns [String current=null] : iv_ruleDIG= ruleDIG EOF ;
    public final String entryRuleDIG() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDIG = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3925:2: (iv_ruleDIG= ruleDIG EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3926:2: iv_ruleDIG= ruleDIG EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDIGRule()); 
            }
            pushFollow(FOLLOW_ruleDIG_in_entryRuleDIG9172);
            iv_ruleDIG=ruleDIG();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDIG.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDIG9183); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDIG"


    // $ANTLR start "ruleDIG"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3933:1: ruleDIG returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG ) ;
    public final AntlrDatatypeRuleToken ruleDIG() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINDIG_0=null;
        Token this_NBINDIG_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3936:28: ( (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3937:1: (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3937:1: (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_BINDIG) ) {
                alt72=1;
            }
            else if ( (LA72_0==RULE_NBINDIG) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3937:6: this_BINDIG_0= RULE_BINDIG
                    {
                    this_BINDIG_0=(Token)match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_ruleDIG9223); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINDIG_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINDIG_0, grammarAccess.getDIGAccess().getBINDIGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3945:10: this_NBINDIG_1= RULE_NBINDIG
                    {
                    this_NBINDIG_1=(Token)match(input,RULE_NBINDIG,FOLLOW_RULE_NBINDIG_in_ruleDIG9249); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NBINDIG_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NBINDIG_1, grammarAccess.getDIGAccess().getNBINDIGTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDIG"


    // $ANTLR start "entryRuleSYM"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3960:1: entryRuleSYM returns [String current=null] : iv_ruleSYM= ruleSYM EOF ;
    public final String entryRuleSYM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSYM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3961:2: (iv_ruleSYM= ruleSYM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3962:2: iv_ruleSYM= ruleSYM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSYMRule()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_entryRuleSYM9295);
            iv_ruleSYM=ruleSYM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSYM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSYM9306); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSYM"


    // $ANTLR start "ruleSYM"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3969:1: ruleSYM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM ) ;
    public final AntlrDatatypeRuleToken ruleSYM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BS_0=null;
        Token this_SLASH_1=null;
        Token this_DOT_2=null;
        Token this_CHARSYM_3=null;
        Token this_OTHERSYM_4=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3972:28: ( (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3973:1: (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3973:1: (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM )
            int alt73=5;
            switch ( input.LA(1) ) {
            case RULE_BS:
                {
                alt73=1;
                }
                break;
            case RULE_SLASH:
                {
                alt73=2;
                }
                break;
            case RULE_DOT:
                {
                alt73=3;
                }
                break;
            case RULE_CHARSYM:
                {
                alt73=4;
                }
                break;
            case RULE_OTHERSYM:
                {
                alt73=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3973:6: this_BS_0= RULE_BS
                    {
                    this_BS_0=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleSYM9346); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_0, grammarAccess.getSYMAccess().getBSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3981:10: this_SLASH_1= RULE_SLASH
                    {
                    this_SLASH_1=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleSYM9372); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SLASH_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SLASH_1, grammarAccess.getSYMAccess().getSLASHTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3989:10: this_DOT_2= RULE_DOT
                    {
                    this_DOT_2=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSYM9398); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_2, grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3997:10: this_CHARSYM_3= RULE_CHARSYM
                    {
                    this_CHARSYM_3=(Token)match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_ruleSYM9424); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CHARSYM_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_CHARSYM_3, grammarAccess.getSYMAccess().getCHARSYMTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4005:10: this_OTHERSYM_4= RULE_OTHERSYM
                    {
                    this_OTHERSYM_4=(Token)match(input,RULE_OTHERSYM,FOLLOW_RULE_OTHERSYM_in_ruleSYM9450); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_OTHERSYM_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_OTHERSYM_4, grammarAccess.getSYMAccess().getOTHERSYMTerminalRuleCall_4()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSYM"

    // $ANTLR start synpred2_InternalGDSL
    public final void synpred2_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:499:7: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:500:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:500:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:501:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred2_InternalGDSL1042);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalGDSL

    // $ANTLR start synpred3_InternalGDSL
    public final void synpred3_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1755:3: ( ( ruleExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1756:1: ( ruleExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1756:1: ( ruleExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1757:1: ruleExp
        {
        pushFollow(FOLLOW_ruleExp_in_synpred3_InternalGDSL3525);
        ruleExp();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalGDSL

    // $ANTLR start synpred4_InternalGDSL
    public final void synpred4_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:4: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2079:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2079:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2080:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred4_InternalGDSL4177);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalGDSL

    // $ANTLR start synpred5_InternalGDSL
    public final void synpred5_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2302:4: ( ( ruleAtomicExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2303:1: ( ruleAtomicExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2303:1: ( ruleAtomicExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2304:1: ruleAtomicExp
        {
        pushFollow(FOLLOW_ruleAtomicExp_in_synpred5_InternalGDSL4643);
        ruleAtomicExp();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalGDSL

    // $ANTLR start synpred6_InternalGDSL
    public final void synpred6_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2375:8: ( ( ruleQid ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2376:1: ( ruleQid )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2376:1: ( ruleQid )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2377:1: ruleQid
        {
        pushFollow(FOLLOW_ruleQid_in_synpred6_InternalGDSL4810);
        ruleQid();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalGDSL

    // $ANTLR start synpred7_InternalGDSL
    public final void synpred7_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2397:4: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2397:6: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred7_InternalGDSL4840); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalGDSL

    // $ANTLR start synpred8_InternalGDSL
    public final void synpred8_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2533:3: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2533:5: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred8_InternalGDSL5111); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalGDSL

    // $ANTLR start synpred9_InternalGDSL
    public final void synpred9_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2606:4: ( ( ruleName ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2607:1: ( ruleName )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2607:1: ( ruleName )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2608:1: ruleName
        {
        pushFollow(FOLLOW_ruleName_in_synpred9_InternalGDSL5238);
        ruleName();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_InternalGDSL

    // $ANTLR start synpred10_InternalGDSL
    public final void synpred10_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2925:7: ( ruleName )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2925:9: ruleName
        {
        pushFollow(FOLLOW_ruleName_in_synpred10_InternalGDSL5979);
        ruleName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalGDSL

    // $ANTLR start synpred11_InternalGDSL
    public final void synpred11_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3036:3: ( ruleBITSTR )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3036:5: ruleBITSTR
        {
        pushFollow(FOLLOW_ruleBITSTR_in_synpred11_InternalGDSL6323);
        ruleBITSTR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalGDSL

    // $ANTLR start synpred12_InternalGDSL
    public final void synpred12_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3401:2: ( ruleDIG )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3401:4: ruleDIG
        {
        pushFollow(FOLLOW_ruleDIG_in_synpred12_InternalGDSL7464);
        ruleDIG();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalGDSL

    // $ANTLR start synpred13_InternalGDSL
    public final void synpred13_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3439:2: ( ruleHEXDIGIT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3439:4: ruleHEXDIGIT
        {
        pushFollow(FOLLOW_ruleHEXDIGIT_in_synpred13_InternalGDSL7588);
        ruleHEXDIGIT();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalGDSL

    // $ANTLR start synpred14_InternalGDSL
    public final void synpred14_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3473:2: ( ruleBINARY )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3473:4: ruleBINARY
        {
        pushFollow(FOLLOW_ruleBINARY_in_synpred14_InternalGDSL7701);
        ruleBINARY();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalGDSL

    // $ANTLR start synpred15_InternalGDSL
    public final void synpred15_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3511:2: ( ruleIDCHAR )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3511:4: ruleIDCHAR
        {
        pushFollow(FOLLOW_ruleIDCHAR_in_synpred15_InternalGDSL7825);
        ruleIDCHAR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalGDSL

    // $ANTLR start synpred16_InternalGDSL
    public final void synpred16_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3554:2: ( ruleIDCHAR )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3554:4: ruleIDCHAR
        {
        pushFollow(FOLLOW_ruleIDCHAR_in_synpred16_InternalGDSL7964);
        ruleIDCHAR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalGDSL

    // $ANTLR start synpred17_InternalGDSL
    public final void synpred17_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3597:2: ( ruleIDCHAR )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3597:4: ruleIDCHAR
        {
        pushFollow(FOLLOW_ruleIDCHAR_in_synpred17_InternalGDSL8103);
        ruleIDCHAR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalGDSL

    // Delegated rules

    public final boolean synpred4_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalGDSL_fragment(); // can never throw exception
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
    public final boolean synpred7_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalGDSL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalGDSL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA65 dfa65 = new DFA65(this);
    static final String DFA15_eotS =
        "\32\uffff";
    static final String DFA15_eofS =
        "\32\uffff";
    static final String DFA15_minS =
        "\1\33\1\5\5\6\2\uffff\10\6\1\uffff\10\6";
    static final String DFA15_maxS =
        "\1\33\1\65\5\30\2\uffff\10\30\1\uffff\10\30";
    static final String DFA15_acceptS =
        "\7\uffff\1\1\1\2\10\uffff\1\3\10\uffff";
    static final String DFA15_specialS =
        "\32\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1",
            "\1\7\1\2\1\4\1\5\1\3\1\6\1\7\1\uffff\1\7\1\uffff\1\7\5\uffff"+
            "\1\10\37\uffff\1\10",
            "\1\11\1\13\1\14\1\12\1\15\1\20\1\16\1\uffff\1\17\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\11\1\13\1\14\1\12\1\15\1\20\1\16\1\uffff\1\17\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\11\1\13\1\14\1\12\1\15\1\20\1\16\1\uffff\1\17\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\11\1\13\1\14\1\12\1\15\1\20\1\16\1\uffff\1\17\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\11\1\13\1\14\1\12\1\15\1\20\1\16\1\uffff\1\17\6\uffff\1"+
            "\7\2\uffff\1\21",
            "",
            "",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\11\1\13\1\14\1\12\1\15\1\20\1\16\1\uffff\1\17\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\11\1\13\1\14\1\12\1\15\1\20\1\16\1\uffff\1\17\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\11\1\13\1\14\1\12\1\15\1\20\1\16\1\uffff\1\17\6\uffff\1"+
            "\7\2\uffff\1\21",
            "",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21",
            "\1\22\1\24\1\25\1\23\1\26\1\31\1\27\1\uffff\1\30\6\uffff\1"+
            "\7\2\uffff\1\21"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "476:1: ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( ( (lv_mid_7_0= ruleMIXID ) ) ( (lv_attr_8_0= ruleName ) ) )* otherlv_9= '=' ( (lv_exp_10_0= ruleExp ) ) ) | (otherlv_11= 'val' ( (lv_name_12_0= ruleName ) ) otherlv_13= '[' ( ( (lv_decPat_14_0= ruleDecodePat ) ) ( (lv_decPat_15_0= ruleDecodePat ) )* )? otherlv_16= ']' ( (otherlv_17= '=' ( (lv_exp_18_0= ruleExp ) ) ) | (this_PIPE_19= RULE_PIPE ( (lv_exps_20_0= ruleExp ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) )+ ) ) )";
        }
    }
    static final String DFA32_eotS =
        "\u0088\uffff";
    static final String DFA32_eofS =
        "\7\uffff\5\50\11\uffff\10\50\14\uffff\17\50\11\uffff\17\50\4\uffff"+
        "\64\50";
    static final String DFA32_minS =
        "\1\6\6\uffff\5\5\11\uffff\10\5\14\uffff\17\5\11\uffff\17\5\4\uffff"+
        "\64\5";
    static final String DFA32_maxS =
        "\1\66\6\uffff\5\54\11\uffff\4\54\1\66\2\54\1\66\14\uffff\4\54\1"+
        "\66\2\54\1\66\4\54\1\66\2\54\11\uffff\4\54\1\66\6\54\1\66\2\54\1"+
        "\66\4\uffff\4\54\1\66\2\54\1\66\4\54\1\66\6\54\1\66\2\54\1\66\4"+
        "\54\1\66\2\54\1\66\4\54\1\66\2\54\1\66\6\54\1\66\6\54";
    static final String DFA32_acceptS =
        "\1\uffff\6\1\5\uffff\11\1\10\uffff\1\2\13\1\17\uffff\11\1\17\uffff"+
        "\4\1\64\uffff";
    static final String DFA32_specialS =
        "\1\123\6\uffff\1\34\1\66\1\57\1\117\1\112\11\uffff\1\47\1\65\1\0"+
        "\1\126\1\20\1\44\1\33\1\136\14\uffff\1\50\1\111\1\31\1\52\1\17\1"+
        "\32\1\15\1\56\1\77\1\121\1\124\1\27\1\10\1\60\1\25\11\uffff\1\100"+
        "\1\105\1\107\1\42\1\64\1\21\1\62\1\11\1\134\1\45\1\23\1\76\1\125"+
        "\1\1\1\135\4\uffff\1\54\1\30\1\122\1\102\1\70\1\14\1\116\1\3\1\22"+
        "\1\127\1\137\1\63\1\16\1\113\1\46\1\53\1\26\1\120\1\101\1\67\1\13"+
        "\1\115\1\2\1\110\1\12\1\72\1\6\1\51\1\7\1\55\1\75\1\41\1\132\1\37"+
        "\1\106\1\74\1\36\1\104\1\73\1\40\1\131\1\43\1\133\1\35\1\103\1\24"+
        "\1\114\1\71\1\5\1\61\1\130\1\4}>";
    static final String[] DFA32_transitionS = {
            "\1\7\1\11\1\12\1\10\1\13\1\uffff\1\2\1\uffff\1\3\15\uffff\1"+
            "\17\3\uffff\1\5\1\23\1\uffff\1\21\2\uffff\1\22\6\uffff\1\1\1"+
            "\14\1\15\1\16\1\uffff\1\20\1\uffff\1\6\1\24\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\32\1\42\1\33\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\32\1\42\1\33\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\56\1\42\1\57\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\56\1\42\1\57\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\32\1\42\1\33\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\32\1\42\1\33\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\32\1\42\1\33\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\32\1\42\1\33\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\32\1\42\1\33\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\61\1\63\1\64\1\62\1\65\1\34\1\66\1\42\1\67\1\43\3\uffff"+
            "\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4\uffff\1\35\1"+
            "\45\1\44\1\40\1\41\1\37\1\70\1\74\1\75\1\76\1\uffff\1\100\1"+
            "\uffff\1\73\1\uffff\1\71",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\32\1\42\1\33\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\32\1\42\1\33\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\61\1\63\1\64\1\62\1\65\1\34\1\66\1\42\1\67\1\43\3\uffff"+
            "\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4\uffff\1\35\1"+
            "\45\1\44\1\40\1\41\1\37\1\70\1\74\1\75\1\76\1\uffff\1\100\1"+
            "\uffff\1\73\1\uffff\1\71",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\56\1\42\1\57\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\56\1\42\1\57\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\56\1\42\1\57\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\56\1\42\1\57\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\101\1\103\1\104\1\102\1\105\1\60\1\106\1\42\1\107\1"+
            "\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4\uffff"+
            "\1\35\1\45\1\44\1\40\1\41\1\37\1\70\1\74\1\75\1\76\1\uffff\1"+
            "\100\1\uffff\1\73\1\uffff\1\71",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\56\1\42\1\57\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\56\1\42\1\57\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\40\1\41\1\37",
            "\1\36\1\101\1\103\1\104\1\102\1\105\1\60\1\106\1\42\1\107\1"+
            "\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4\uffff"+
            "\1\35\1\45\1\44\1\40\1\41\1\37\1\70\1\74\1\75\1\76\1\uffff\1"+
            "\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\134\1\136\1\137\1\135\1\140\1\117\1\141\1\42\1\142"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\66\1\42\1\67\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122\1\123\1\121",
            "\1\36\1\25\1\27\1\30\1\26\1\31\1\34\1\66\1\42\1\67\1\43\3\uffff"+
            "\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122\1\123\1\121",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\163\1\165\1\166\1\164\1\167\1\152\1\170\1\42\1\171"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\106\1\42\1\107\1\43\3"+
            "\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122\1\123"+
            "\1\121",
            "\1\36\1\51\1\53\1\54\1\52\1\55\1\60\1\106\1\42\1\107\1\43\3"+
            "\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122\1\123"+
            "\1\121",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\134\1\136\1\137\1\135\1\140\1\117\1\141\1\42\1\142"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\134\1\136\1\137\1\135\1\140\1\117\1\141\1\42\1\142"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "",
            "",
            "",
            "",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\173\1\175\1\176\1\174\1\172\1\133\1\177\1\42\1\u0080"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\173\1\175\1\176\1\174\1\172\1\133\1\177\1\42\1\u0080"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\115\1\42\1\116"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\134\1\136\1\137\1\135\1\140\1\117\1\141\1\42\1\142"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\141\1\42\1\142"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\110\1\112\1\113\1\111\1\114\1\117\1\141\1\42\1\142"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\163\1\165\1\166\1\164\1\167\1\152\1\170\1\42\1\171"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\163\1\165\1\166\1\164\1\167\1\152\1\170\1\42\1\171"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\u0082\1\u0084\1\u0085\1\u0083\1\u0081\1\162\1\u0086"+
            "\1\42\1\u0087\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1"+
            "\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1"+
            "\74\1\75\1\76\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\u0082\1\u0084\1\u0085\1\u0083\1\u0081\1\162\1\u0086"+
            "\1\42\1\u0087\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1"+
            "\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1"+
            "\74\1\75\1\76\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\150\1\42\1\151"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\163\1\165\1\166\1\164\1\167\1\152\1\170\1\42\1\171"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\170\1\42\1\171"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\143\1\145\1\146\1\144\1\147\1\152\1\170\1\42\1\171"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\173\1\175\1\176\1\174\1\172\1\133\1\177\1\42\1\u0080"+
            "\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1\uffff\1\47\4"+
            "\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1\74\1\75\1\76"+
            "\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\131\1\42\1\132"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\177\1\42\1\u0080"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\124\1\126\1\127\1\125\1\130\1\133\1\177\1\42\1\u0080"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\u0082\1\u0084\1\u0085\1\u0083\1\u0081\1\162\1\u0086"+
            "\1\42\1\u0087\1\43\3\uffff\1\46\10\uffff\1\77\3\uffff\1\72\1"+
            "\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122\1\123\1\121\1\70\1"+
            "\74\1\75\1\76\1\uffff\1\100\1\uffff\1\73\1\uffff\1\71",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\160\1\42\1\161"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\u0086\1\42\1\u0087"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121",
            "\1\120\1\153\1\155\1\156\1\154\1\157\1\162\1\u0086\1\42\1\u0087"+
            "\1\43\3\uffff\1\46\16\uffff\1\47\4\uffff\1\35\1\45\1\44\1\122"+
            "\1\123\1\121"
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1755:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_23 = input.LA(1);

                         
                        int index32_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_23==39) ) {s = 29;}

                        else if ( (LA32_23==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_23==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_23==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_23==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_23==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_23==RULE_BINDIG) ) {s = 26;}

                        else if ( (LA32_23==RULE_NBINDIG) ) {s = 27;}

                        else if ( (LA32_23==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_23==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_23==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_23==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_23==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_23==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_23==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_23==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_23==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_23==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_23==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_23==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_23);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_78 = input.LA(1);

                         
                        int index32_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_78==39) ) {s = 29;}

                        else if ( (LA32_78==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_78==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_78==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_78==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_78==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_78==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_78==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_78==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_78==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_78==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_78==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_78==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_78==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_78==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_78==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_78==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_78==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_78==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_78==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_78);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_106 = input.LA(1);

                         
                        int index32_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_106==39) ) {s = 29;}

                        else if ( (LA32_106==RULE_LHEXCHAR) ) {s = 115;}

                        else if ( (LA32_106==RULE_LNHEXCHAR) ) {s = 116;}

                        else if ( (LA32_106==RULE_UHEXCHAR) ) {s = 117;}

                        else if ( (LA32_106==RULE_UNHEXCHAR) ) {s = 118;}

                        else if ( (LA32_106==RULE_SLASH) ) {s = 119;}

                        else if ( (LA32_106==RULE_BINDIG) ) {s = 120;}

                        else if ( (LA32_106==RULE_NBINDIG) ) {s = 121;}

                        else if ( (LA32_106==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_106==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_106==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_106==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_106==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_106==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_106==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_106==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_106==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_106==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_106==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_106==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_106==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_106==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_106==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_106==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_106==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_106==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_106==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_106==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_106==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_106);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_91 = input.LA(1);

                         
                        int index32_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_91==39) ) {s = 29;}

                        else if ( (LA32_91==RULE_LHEXCHAR) ) {s = 123;}

                        else if ( (LA32_91==RULE_LNHEXCHAR) ) {s = 124;}

                        else if ( (LA32_91==RULE_UHEXCHAR) ) {s = 125;}

                        else if ( (LA32_91==RULE_UNHEXCHAR) ) {s = 126;}

                        else if ( (LA32_91==RULE_SLASH) ) {s = 122;}

                        else if ( (LA32_91==RULE_BINDIG) ) {s = 127;}

                        else if ( (LA32_91==RULE_NBINDIG) ) {s = 128;}

                        else if ( (LA32_91==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_91==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_91==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_91==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_91==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_91==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_91==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_91==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_91==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_91==50) && (synpred3_InternalGDSL())) {s = 64;}

                        else if ( (LA32_91==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_91==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_91==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_91==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_91==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_91==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_91==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_91==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_91==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_91==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_91==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_91);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_135 = input.LA(1);

                         
                        int index32_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_135==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_135==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_135==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_135==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_135==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_135==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_135==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_135==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_135==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_135==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_135==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_135==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_135==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_135==RULE_BINDIG) ) {s = 134;}

                        else if ( (LA32_135==RULE_NBINDIG) ) {s = 135;}

                        else if ( (LA32_135==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_135==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_135==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_135==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_135==39) ) {s = 29;}

                         
                        input.seek(index32_135);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_132 = input.LA(1);

                         
                        int index32_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_132==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_132==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_132==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_132==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_132==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_132==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_132==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_132==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_132==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_132==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_132==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_132==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_132==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_132==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_132==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_132==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_132==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_132==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_132==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_132==39) ) {s = 29;}

                         
                        input.seek(index32_132);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_110 = input.LA(1);

                         
                        int index32_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_110==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_110==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_110==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_110==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_110==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_110==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_110==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_110==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_110==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_110==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_110==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_110==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_110==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_110==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_110==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_110==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_110==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_110==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_110==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_110==39) ) {s = 29;}

                         
                        input.seek(index32_110);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_112 = input.LA(1);

                         
                        int index32_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_112==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_112==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_112==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_112==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_112==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_112==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_112==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_112==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_112==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_112==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_112==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_112==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_112==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_112==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_112==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_112==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_112==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_112==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_112==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_112==39) ) {s = 29;}

                         
                        input.seek(index32_112);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA32_53 = input.LA(1);

                         
                        int index32_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_53==RULE_LHEXCHAR) ) {s = 92;}

                        else if ( (LA32_53==RULE_LNHEXCHAR) ) {s = 93;}

                        else if ( (LA32_53==RULE_UHEXCHAR) ) {s = 94;}

                        else if ( (LA32_53==RULE_UNHEXCHAR) ) {s = 95;}

                        else if ( (LA32_53==RULE_SLASH) ) {s = 96;}

                        else if ( (LA32_53==RULE_BINDIG) ) {s = 97;}

                        else if ( (LA32_53==RULE_NBINDIG) ) {s = 98;}

                        else if ( (LA32_53==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_53==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_53==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_53==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_53==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_53==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_53==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_53==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_53==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_53==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_53==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_53==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_53==39) ) {s = 29;}

                        else if ( (LA32_53==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_53==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_53==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_53==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_53==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_53==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_53==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_53==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_53==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_53);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA32_72 = input.LA(1);

                         
                        int index32_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_72==39) ) {s = 29;}

                        else if ( (LA32_72==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_72==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_72==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_72==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_72==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_72==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_72==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_72==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_72==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_72==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_72==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_72==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_72==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_72==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_72==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_72==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_72==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_72==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_72==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_72);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA32_108 = input.LA(1);

                         
                        int index32_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_108==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_108==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_108==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_108==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_108==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_108==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_108==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_108==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_108==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_108==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_108==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_108==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_108==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_108==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_108==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_108==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_108==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_108==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_108==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_108==39) ) {s = 29;}

                         
                        input.seek(index32_108);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA32_104 = input.LA(1);

                         
                        int index32_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_104==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_104==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_104==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_104==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_104==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_104==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_104==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_104==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_104==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_104==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_104==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_104==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_104==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_104==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_104==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_104==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_104==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_104==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_104==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_104==39) ) {s = 29;}

                         
                        input.seek(index32_104);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA32_89 = input.LA(1);

                         
                        int index32_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_89==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_89==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_89==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_89==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_89==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_89==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_89==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_89==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_89==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_89==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_89==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_89==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_89==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_89==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_89==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_89==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_89==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_89==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_89==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_89==39) ) {s = 29;}

                         
                        input.seek(index32_89);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA32_47 = input.LA(1);

                         
                        int index32_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_47==39) ) {s = 29;}

                        else if ( (LA32_47==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_47==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_47==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_47==RULE_UNHEXCHAR) ) {s = 44;}

                        else if ( (LA32_47==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_47==RULE_BINDIG) ) {s = 46;}

                        else if ( (LA32_47==RULE_NBINDIG) ) {s = 47;}

                        else if ( (LA32_47==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_47==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_47==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_47==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_47==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_47==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_47==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_47==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_47==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_47==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_47==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_47==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_47);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA32_96 = input.LA(1);

                         
                        int index32_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_96==RULE_LHEXCHAR) ) {s = 92;}

                        else if ( (LA32_96==RULE_LNHEXCHAR) ) {s = 93;}

                        else if ( (LA32_96==RULE_UHEXCHAR) ) {s = 94;}

                        else if ( (LA32_96==RULE_UNHEXCHAR) ) {s = 95;}

                        else if ( (LA32_96==RULE_SLASH) ) {s = 96;}

                        else if ( (LA32_96==RULE_BINDIG) ) {s = 97;}

                        else if ( (LA32_96==RULE_NBINDIG) ) {s = 98;}

                        else if ( (LA32_96==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_96==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_96==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_96==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_96==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_96==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_96==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_96==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_96==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_96==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_96==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_96==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_96==39) ) {s = 29;}

                        else if ( (LA32_96==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_96==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_96==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_96==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_96==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_96==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_96==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_96==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_96==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_96);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA32_45 = input.LA(1);

                         
                        int index32_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_45==39) ) {s = 29;}

                        else if ( (LA32_45==RULE_LHEXCHAR) ) {s = 65;}

                        else if ( (LA32_45==RULE_LNHEXCHAR) ) {s = 66;}

                        else if ( (LA32_45==RULE_UHEXCHAR) ) {s = 67;}

                        else if ( (LA32_45==RULE_UNHEXCHAR) ) {s = 68;}

                        else if ( (LA32_45==RULE_SLASH) ) {s = 69;}

                        else if ( (LA32_45==RULE_BINDIG) ) {s = 70;}

                        else if ( (LA32_45==RULE_NBINDIG) ) {s = 71;}

                        else if ( (LA32_45==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_45==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_45==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_45==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_45==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_45==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_45==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_45==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_45==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_45==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_45==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_45==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_45==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_45==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_45==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_45==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_45==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_45==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_45==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_45==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_45==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_45);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA32_25 = input.LA(1);

                         
                        int index32_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_25==39) ) {s = 29;}

                        else if ( (LA32_25==RULE_LHEXCHAR) ) {s = 49;}

                        else if ( (LA32_25==RULE_LNHEXCHAR) ) {s = 50;}

                        else if ( (LA32_25==RULE_UHEXCHAR) ) {s = 51;}

                        else if ( (LA32_25==RULE_UNHEXCHAR) ) {s = 52;}

                        else if ( (LA32_25==RULE_SLASH) ) {s = 53;}

                        else if ( (LA32_25==RULE_BINDIG) ) {s = 54;}

                        else if ( (LA32_25==RULE_NBINDIG) ) {s = 55;}

                        else if ( (LA32_25==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_25==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_25==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_25==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_25==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_25==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_25==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_25==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_25==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_25==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_25==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_25==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_25==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_25==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_25==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_25==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_25==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_25==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_25==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_25==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_25==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_25);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA32_70 = input.LA(1);

                         
                        int index32_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_70==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_70==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_70==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_70==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_70==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_70==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_70==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_70==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_70==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_70==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_70==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_70==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_70==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_70==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_70==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_70==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_70==RULE_UNHEXCHAR) ) {s = 44;}

                        else if ( (LA32_70==RULE_BINDIG) ) {s = 70;}

                        else if ( (LA32_70==RULE_NBINDIG) ) {s = 71;}

                        else if ( (LA32_70==39) ) {s = 29;}

                         
                        input.seek(index32_70);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA32_92 = input.LA(1);

                         
                        int index32_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_92==39) ) {s = 29;}

                        else if ( (LA32_92==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_92==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_92==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_92==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_92==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_92==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_92==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_92==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_92==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_92==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_92==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_92==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_92==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_92==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_92==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_92==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_92==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_92==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_92==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_92);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA32_75 = input.LA(1);

                         
                        int index32_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_75==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_75==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_75==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_75==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_75==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_75==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_75==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_75==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_75==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_75==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_75==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_75==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_75==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_75==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_75==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_75==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_75==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_75==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_75==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_75==39) ) {s = 29;}

                         
                        input.seek(index32_75);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA32_129 = input.LA(1);

                         
                        int index32_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_129==RULE_LHEXCHAR) ) {s = 130;}

                        else if ( (LA32_129==RULE_LNHEXCHAR) ) {s = 131;}

                        else if ( (LA32_129==RULE_UHEXCHAR) ) {s = 132;}

                        else if ( (LA32_129==RULE_UNHEXCHAR) ) {s = 133;}

                        else if ( (LA32_129==RULE_SLASH) ) {s = 129;}

                        else if ( (LA32_129==RULE_BINDIG) ) {s = 134;}

                        else if ( (LA32_129==RULE_NBINDIG) ) {s = 135;}

                        else if ( (LA32_129==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_129==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_129==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_129==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_129==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_129==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_129==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_129==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_129==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_129==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_129==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_129==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_129==39) ) {s = 29;}

                        else if ( (LA32_129==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_129==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_129==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_129==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_129==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_129==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_129==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_129==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_129==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_129);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA32_55 = input.LA(1);

                         
                        int index32_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_55==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_55==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_55==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_55==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_55==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_55==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_55==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_55==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_55==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_55==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_55==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_55==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_55==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_55==RULE_BINDIG) ) {s = 54;}

                        else if ( (LA32_55==RULE_NBINDIG) ) {s = 55;}

                        else if ( (LA32_55==39) ) {s = 29;}

                        else if ( (LA32_55==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_55==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_55==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_55==RULE_UNHEXCHAR) ) {s = 24;}

                         
                        input.seek(index32_55);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA32_100 = input.LA(1);

                         
                        int index32_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_100==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_100==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_100==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_100==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_100==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_100==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_100==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_100==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_100==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_100==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_100==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_100==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_100==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_100==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_100==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_100==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_100==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_100==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_100==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_100==39) ) {s = 29;}

                         
                        input.seek(index32_100);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA32_52 = input.LA(1);

                         
                        int index32_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_52==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_52==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_52==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_52==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_52==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_52==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_52==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_52==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_52==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_52==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_52==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_52==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_52==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_52==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_52==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_52==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_52==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_52==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_52==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_52==39) ) {s = 29;}

                         
                        input.seek(index32_52);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA32_85 = input.LA(1);

                         
                        int index32_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_85==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_85==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_85==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_85==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_85==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_85==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_85==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_85==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_85==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_85==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_85==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_85==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_85==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_85==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_85==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_85==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_85==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_85==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_85==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_85==39) ) {s = 29;}

                         
                        input.seek(index32_85);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA32_43 = input.LA(1);

                         
                        int index32_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_43==39) ) {s = 29;}

                        else if ( (LA32_43==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_43==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_43==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_43==RULE_UNHEXCHAR) ) {s = 44;}

                        else if ( (LA32_43==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_43==RULE_BINDIG) ) {s = 46;}

                        else if ( (LA32_43==RULE_NBINDIG) ) {s = 47;}

                        else if ( (LA32_43==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_43==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_43==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_43==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_43==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_43==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_43==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_43==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_43==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_43==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_43==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_43==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_43);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA32_46 = input.LA(1);

                         
                        int index32_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_46==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_46==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_46==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_46==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_46==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_46==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_46==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_46==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_46==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_46==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_46==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_46==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_46==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_46==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_46==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_46==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_46==RULE_UNHEXCHAR) ) {s = 44;}

                        else if ( (LA32_46==RULE_BINDIG) ) {s = 46;}

                        else if ( (LA32_46==RULE_NBINDIG) ) {s = 47;}

                        else if ( (LA32_46==39) ) {s = 29;}

                         
                        input.seek(index32_46);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA32_27 = input.LA(1);

                         
                        int index32_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_27==39) ) {s = 29;}

                        else if ( (LA32_27==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_27==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_27==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_27==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_27==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_27==RULE_BINDIG) ) {s = 26;}

                        else if ( (LA32_27==RULE_NBINDIG) ) {s = 27;}

                        else if ( (LA32_27==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_27==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_27==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_27==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_27==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_27==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_27==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_27==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_27==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_27==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_27==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_27==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_27);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_7==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_7==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_7==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_7==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_7==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_7==RULE_BINDIG) ) {s = 26;}

                        else if ( (LA32_7==RULE_NBINDIG) ) {s = 27;}

                        else if ( (LA32_7==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_7==39) ) {s = 29;}

                        else if ( (LA32_7==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_7==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_7==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_7==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_7==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_7==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_7==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_7==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_7==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_7==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_7==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_7);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA32_127 = input.LA(1);

                         
                        int index32_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_127==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_127==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_127==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_127==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_127==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_127==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_127==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_127==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_127==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_127==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_127==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_127==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_127==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_127==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_127==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_127==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_127==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_127==RULE_BINDIG) ) {s = 127;}

                        else if ( (LA32_127==RULE_NBINDIG) ) {s = 128;}

                        else if ( (LA32_127==39) ) {s = 29;}

                         
                        input.seek(index32_127);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA32_120 = input.LA(1);

                         
                        int index32_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_120==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_120==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_120==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_120==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_120==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_120==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_120==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_120==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_120==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_120==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_120==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_120==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_120==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_120==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_120==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_120==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_120==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_120==RULE_BINDIG) ) {s = 120;}

                        else if ( (LA32_120==RULE_NBINDIG) ) {s = 121;}

                        else if ( (LA32_120==39) ) {s = 29;}

                         
                        input.seek(index32_120);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA32_117 = input.LA(1);

                         
                        int index32_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_117==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_117==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_117==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_117==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_117==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_117==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_117==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_117==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_117==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_117==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_117==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_117==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_117==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_117==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_117==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_117==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_117==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_117==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_117==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_117==39) ) {s = 29;}

                         
                        input.seek(index32_117);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA32_123 = input.LA(1);

                         
                        int index32_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_123==39) ) {s = 29;}

                        else if ( (LA32_123==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_123==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_123==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_123==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_123==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_123==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_123==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_123==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_123==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_123==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_123==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_123==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_123==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_123==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_123==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_123==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_123==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_123==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_123==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_123);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA32_115 = input.LA(1);

                         
                        int index32_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_115==39) ) {s = 29;}

                        else if ( (LA32_115==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_115==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_115==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_115==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_115==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_115==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_115==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_115==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_115==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_115==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_115==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_115==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_115==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_115==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_115==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_115==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_115==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_115==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_115==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_115);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA32_68 = input.LA(1);

                         
                        int index32_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_68==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_68==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_68==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_68==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_68==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_68==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_68==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_68==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_68==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_68==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_68==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_68==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_68==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_68==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_68==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_68==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_68==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_68==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_68==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_68==39) ) {s = 29;}

                         
                        input.seek(index32_68);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA32_125 = input.LA(1);

                         
                        int index32_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_125==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_125==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_125==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_125==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_125==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_125==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_125==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_125==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_125==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_125==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_125==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_125==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_125==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_125==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_125==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_125==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_125==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_125==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_125==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_125==39) ) {s = 29;}

                         
                        input.seek(index32_125);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA32_26 = input.LA(1);

                         
                        int index32_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_26==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_26==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_26==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_26==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_26==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_26==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_26==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_26==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_26==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_26==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_26==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_26==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_26==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_26==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_26==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_26==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_26==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_26==RULE_BINDIG) ) {s = 26;}

                        else if ( (LA32_26==RULE_NBINDIG) ) {s = 27;}

                        else if ( (LA32_26==39) ) {s = 29;}

                         
                        input.seek(index32_26);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA32_74 = input.LA(1);

                         
                        int index32_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_74==39) ) {s = 29;}

                        else if ( (LA32_74==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_74==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_74==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_74==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_74==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_74==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_74==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_74==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_74==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_74==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_74==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_74==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_74==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_74==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_74==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_74==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_74==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_74==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_74==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_74);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA32_98 = input.LA(1);

                         
                        int index32_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_98==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_98==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_98==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_98==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_98==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_98==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_98==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_98==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_98==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_98==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_98==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_98==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_98==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_98==RULE_BINDIG) ) {s = 97;}

                        else if ( (LA32_98==RULE_NBINDIG) ) {s = 98;}

                        else if ( (LA32_98==39) ) {s = 29;}

                        else if ( (LA32_98==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_98==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_98==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_98==RULE_UNHEXCHAR) ) {s = 75;}

                         
                        input.seek(index32_98);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA32_21 = input.LA(1);

                         
                        int index32_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_21==39) ) {s = 29;}

                        else if ( (LA32_21==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_21==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_21==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_21==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_21==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_21==RULE_BINDIG) ) {s = 26;}

                        else if ( (LA32_21==RULE_NBINDIG) ) {s = 27;}

                        else if ( (LA32_21==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_21==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_21==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_21==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_21==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_21==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_21==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_21==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_21==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_21==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_21==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_21==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_21);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA32_41 = input.LA(1);

                         
                        int index32_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_41==39) ) {s = 29;}

                        else if ( (LA32_41==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_41==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_41==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_41==RULE_UNHEXCHAR) ) {s = 44;}

                        else if ( (LA32_41==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_41==RULE_BINDIG) ) {s = 46;}

                        else if ( (LA32_41==RULE_NBINDIG) ) {s = 47;}

                        else if ( (LA32_41==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_41==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_41==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_41==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_41==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_41==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_41==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_41==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_41==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_41==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_41==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_41==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA32_111 = input.LA(1);

                         
                        int index32_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_111==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_111==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_111==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_111==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_111==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_111==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_111==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_111==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_111==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_111==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_111==RULE_SLASH) ) {s = 129;}

                        else if ( (LA32_111==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_111==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_111==RULE_LHEXCHAR) ) {s = 130;}

                        else if ( (LA32_111==RULE_LNHEXCHAR) ) {s = 131;}

                        else if ( (LA32_111==RULE_UHEXCHAR) ) {s = 132;}

                        else if ( (LA32_111==RULE_UNHEXCHAR) ) {s = 133;}

                        else if ( (LA32_111==RULE_BINDIG) ) {s = 134;}

                        else if ( (LA32_111==RULE_NBINDIG) ) {s = 135;}

                        else if ( (LA32_111==39) ) {s = 29;}

                        else if ( (LA32_111==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_111==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_111==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_111==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_111==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_111==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_111==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_111==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_111==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_111);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA32_44 = input.LA(1);

                         
                        int index32_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_44==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_44==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_44==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_44==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_44==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_44==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_44==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_44==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_44==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_44==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_44==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_44==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_44==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_44==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_44==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_44==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_44==RULE_UNHEXCHAR) ) {s = 44;}

                        else if ( (LA32_44==RULE_BINDIG) ) {s = 46;}

                        else if ( (LA32_44==RULE_NBINDIG) ) {s = 47;}

                        else if ( (LA32_44==39) ) {s = 29;}

                         
                        input.seek(index32_44);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA32_99 = input.LA(1);

                         
                        int index32_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_99==39) ) {s = 29;}

                        else if ( (LA32_99==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_99==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_99==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_99==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_99==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_99==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_99==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_99==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_99==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_99==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_99==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_99==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_99==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_99==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_99==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_99==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_99==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_99==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_99==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_99);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA32_84 = input.LA(1);

                         
                        int index32_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_84==39) ) {s = 29;}

                        else if ( (LA32_84==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_84==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_84==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_84==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_84==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_84==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_84==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_84==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_84==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_84==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_84==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_84==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_84==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_84==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_84==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_84==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_84==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_84==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_84==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_84);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA32_113 = input.LA(1);

                         
                        int index32_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_113==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_113==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_113==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_113==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_113==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_113==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_113==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_113==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_113==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_113==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_113==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_113==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_113==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_113==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_113==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_113==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_113==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_113==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_113==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_113==39) ) {s = 29;}

                         
                        input.seek(index32_113);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA32_48 = input.LA(1);

                         
                        int index32_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_48==39) ) {s = 29;}

                        else if ( (LA32_48==RULE_LHEXCHAR) ) {s = 65;}

                        else if ( (LA32_48==RULE_LNHEXCHAR) ) {s = 66;}

                        else if ( (LA32_48==RULE_UHEXCHAR) ) {s = 67;}

                        else if ( (LA32_48==RULE_UNHEXCHAR) ) {s = 68;}

                        else if ( (LA32_48==RULE_SLASH) ) {s = 69;}

                        else if ( (LA32_48==RULE_BINDIG) ) {s = 70;}

                        else if ( (LA32_48==RULE_NBINDIG) ) {s = 71;}

                        else if ( (LA32_48==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_48==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_48==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_48==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_48==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_48==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_48==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_48==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_48==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_48==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_48==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_48==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_48==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_48==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_48==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_48==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_48==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_48==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_48==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_48==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_48==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_48);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA32_9 = input.LA(1);

                         
                        int index32_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_9==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_9==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_9==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_9==RULE_UNHEXCHAR) ) {s = 44;}

                        else if ( (LA32_9==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_9==RULE_BINDIG) ) {s = 46;}

                        else if ( (LA32_9==RULE_NBINDIG) ) {s = 47;}

                        else if ( (LA32_9==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_9==39) ) {s = 29;}

                        else if ( (LA32_9==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_9==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_9==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_9==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_9==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_9==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_9==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_9==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_9==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_9==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_9==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_9);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA32_54 = input.LA(1);

                         
                        int index32_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_54==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_54==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_54==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_54==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_54==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_54==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_54==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_54==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_54==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_54==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_54==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_54==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_54==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_54==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_54==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_54==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_54==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_54==RULE_BINDIG) ) {s = 54;}

                        else if ( (LA32_54==RULE_NBINDIG) ) {s = 55;}

                        else if ( (LA32_54==39) ) {s = 29;}

                         
                        input.seek(index32_54);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA32_133 = input.LA(1);

                         
                        int index32_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_133==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_133==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_133==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_133==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_133==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_133==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_133==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_133==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_133==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_133==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_133==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_133==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_133==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_133==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_133==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_133==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_133==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_133==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_133==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_133==39) ) {s = 29;}

                         
                        input.seek(index32_133);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA32_71 = input.LA(1);

                         
                        int index32_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_71==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_71==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_71==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_71==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_71==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_71==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_71==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_71==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_71==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_71==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_71==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_71==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_71==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_71==RULE_BINDIG) ) {s = 70;}

                        else if ( (LA32_71==RULE_NBINDIG) ) {s = 71;}

                        else if ( (LA32_71==39) ) {s = 29;}

                        else if ( (LA32_71==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_71==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_71==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_71==RULE_UNHEXCHAR) ) {s = 44;}

                         
                        input.seek(index32_71);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA32_95 = input.LA(1);

                         
                        int index32_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_95==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_95==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_95==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_95==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_95==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_95==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_95==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_95==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_95==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_95==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_95==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_95==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_95==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_95==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_95==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_95==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_95==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_95==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_95==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_95==39) ) {s = 29;}

                         
                        input.seek(index32_95);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA32_69 = input.LA(1);

                         
                        int index32_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_69==RULE_LHEXCHAR) ) {s = 115;}

                        else if ( (LA32_69==RULE_LNHEXCHAR) ) {s = 116;}

                        else if ( (LA32_69==RULE_UHEXCHAR) ) {s = 117;}

                        else if ( (LA32_69==RULE_UNHEXCHAR) ) {s = 118;}

                        else if ( (LA32_69==RULE_SLASH) ) {s = 119;}

                        else if ( (LA32_69==RULE_BINDIG) ) {s = 120;}

                        else if ( (LA32_69==RULE_NBINDIG) ) {s = 121;}

                        else if ( (LA32_69==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_69==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_69==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_69==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_69==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_69==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_69==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_69==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_69==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_69==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_69==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_69==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_69==39) ) {s = 29;}

                        else if ( (LA32_69==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_69==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_69==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_69==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_69==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_69==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_69==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_69==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_69==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_69);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA32_22 = input.LA(1);

                         
                        int index32_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_22==39) ) {s = 29;}

                        else if ( (LA32_22==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_22==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_22==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_22==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_22==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_22==RULE_BINDIG) ) {s = 26;}

                        else if ( (LA32_22==RULE_NBINDIG) ) {s = 27;}

                        else if ( (LA32_22==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_22==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_22==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_22==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_22==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_22==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_22==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_22==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_22==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_22==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_22==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_22==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_22);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA32_8 = input.LA(1);

                         
                        int index32_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_8==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_8==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_8==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_8==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_8==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_8==RULE_BINDIG) ) {s = 26;}

                        else if ( (LA32_8==RULE_NBINDIG) ) {s = 27;}

                        else if ( (LA32_8==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_8==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_8==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_8==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_8==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_8==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_8==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_8==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_8==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_8==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_8==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_8==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_8==39) ) {s = 29;}

                         
                        input.seek(index32_8);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA32_103 = input.LA(1);

                         
                        int index32_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_103==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_103==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_103==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_103==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_103==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_103==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_103==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_103==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_103==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_103==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_103==RULE_SLASH) ) {s = 119;}

                        else if ( (LA32_103==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_103==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_103==RULE_LHEXCHAR) ) {s = 115;}

                        else if ( (LA32_103==RULE_LNHEXCHAR) ) {s = 116;}

                        else if ( (LA32_103==RULE_UHEXCHAR) ) {s = 117;}

                        else if ( (LA32_103==RULE_UNHEXCHAR) ) {s = 118;}

                        else if ( (LA32_103==RULE_BINDIG) ) {s = 120;}

                        else if ( (LA32_103==RULE_NBINDIG) ) {s = 121;}

                        else if ( (LA32_103==39) ) {s = 29;}

                        else if ( (LA32_103==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_103==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_103==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_103==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_103==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_103==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_103==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_103==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_103==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_103);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA32_88 = input.LA(1);

                         
                        int index32_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_88==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_88==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_88==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_88==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_88==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_88==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_88==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_88==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_88==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_88==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_88==RULE_SLASH) ) {s = 122;}

                        else if ( (LA32_88==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_88==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_88==RULE_LHEXCHAR) ) {s = 123;}

                        else if ( (LA32_88==RULE_LNHEXCHAR) ) {s = 124;}

                        else if ( (LA32_88==RULE_UHEXCHAR) ) {s = 125;}

                        else if ( (LA32_88==RULE_UNHEXCHAR) ) {s = 126;}

                        else if ( (LA32_88==RULE_BINDIG) ) {s = 127;}

                        else if ( (LA32_88==RULE_NBINDIG) ) {s = 128;}

                        else if ( (LA32_88==39) ) {s = 29;}

                        else if ( (LA32_88==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_88==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_88==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_88==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_88==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_88==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_88==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_88==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_88==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_88);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA32_131 = input.LA(1);

                         
                        int index32_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_131==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_131==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_131==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_131==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_131==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_131==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_131==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_131==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_131==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_131==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_131==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_131==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_131==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_131==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_131==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_131==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_131==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_131==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_131==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_131==39) ) {s = 29;}

                         
                        input.seek(index32_131);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA32_109 = input.LA(1);

                         
                        int index32_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_109==39) ) {s = 29;}

                        else if ( (LA32_109==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_109==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_109==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_109==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_109==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_109==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_109==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_109==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_109==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_109==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_109==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_109==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_109==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_109==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_109==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_109==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_109==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_109==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_109==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_109);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA32_122 = input.LA(1);

                         
                        int index32_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_122==RULE_LHEXCHAR) ) {s = 123;}

                        else if ( (LA32_122==RULE_LNHEXCHAR) ) {s = 124;}

                        else if ( (LA32_122==RULE_UHEXCHAR) ) {s = 125;}

                        else if ( (LA32_122==RULE_UNHEXCHAR) ) {s = 126;}

                        else if ( (LA32_122==RULE_SLASH) ) {s = 122;}

                        else if ( (LA32_122==RULE_BINDIG) ) {s = 127;}

                        else if ( (LA32_122==RULE_NBINDIG) ) {s = 128;}

                        else if ( (LA32_122==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_122==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_122==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_122==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_122==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_122==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_122==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_122==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_122==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_122==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_122==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_122==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_122==39) ) {s = 29;}

                        else if ( (LA32_122==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_122==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_122==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_122==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_122==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_122==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_122==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_122==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_122==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_122);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA32_119 = input.LA(1);

                         
                        int index32_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_119==RULE_LHEXCHAR) ) {s = 115;}

                        else if ( (LA32_119==RULE_LNHEXCHAR) ) {s = 116;}

                        else if ( (LA32_119==RULE_UHEXCHAR) ) {s = 117;}

                        else if ( (LA32_119==RULE_UNHEXCHAR) ) {s = 118;}

                        else if ( (LA32_119==RULE_SLASH) ) {s = 119;}

                        else if ( (LA32_119==RULE_BINDIG) ) {s = 120;}

                        else if ( (LA32_119==RULE_NBINDIG) ) {s = 121;}

                        else if ( (LA32_119==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_119==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_119==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_119==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_119==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_119==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_119==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_119==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_119==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_119==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_119==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_119==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_119==39) ) {s = 29;}

                        else if ( (LA32_119==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_119==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_119==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_119==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_119==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_119==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_119==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_119==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_119==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_119);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA32_114 = input.LA(1);

                         
                        int index32_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_114==39) ) {s = 29;}

                        else if ( (LA32_114==RULE_LHEXCHAR) ) {s = 130;}

                        else if ( (LA32_114==RULE_LNHEXCHAR) ) {s = 131;}

                        else if ( (LA32_114==RULE_UHEXCHAR) ) {s = 132;}

                        else if ( (LA32_114==RULE_UNHEXCHAR) ) {s = 133;}

                        else if ( (LA32_114==RULE_SLASH) ) {s = 129;}

                        else if ( (LA32_114==RULE_BINDIG) ) {s = 134;}

                        else if ( (LA32_114==RULE_NBINDIG) ) {s = 135;}

                        else if ( (LA32_114==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_114==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_114==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_114==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_114==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_114==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_114==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_114==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_114==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_114==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_114==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_114==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_114==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_114==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_114==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_114==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_114==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_114==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_114==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_114==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_114==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_114);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA32_76 = input.LA(1);

                         
                        int index32_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_76==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_76==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_76==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_76==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_76==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_76==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_76==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_76==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_76==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_76==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_76==RULE_SLASH) ) {s = 96;}

                        else if ( (LA32_76==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_76==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_76==RULE_LHEXCHAR) ) {s = 92;}

                        else if ( (LA32_76==RULE_LNHEXCHAR) ) {s = 93;}

                        else if ( (LA32_76==RULE_UHEXCHAR) ) {s = 94;}

                        else if ( (LA32_76==RULE_UNHEXCHAR) ) {s = 95;}

                        else if ( (LA32_76==RULE_BINDIG) ) {s = 97;}

                        else if ( (LA32_76==RULE_NBINDIG) ) {s = 98;}

                        else if ( (LA32_76==39) ) {s = 29;}

                        else if ( (LA32_76==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_76==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_76==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_76==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_76==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_76==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_76==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_76==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_76==50) && (synpred3_InternalGDSL())) {s = 64;}

                         
                        input.seek(index32_76);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA32_49 = input.LA(1);

                         
                        int index32_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_49==39) ) {s = 29;}

                        else if ( (LA32_49==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_49==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_49==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_49==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_49==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_49==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_49==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_49==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_49==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_49==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_49==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_49==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_49==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_49==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_49==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_49==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_49==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_49==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_49==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_49);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA32_65 = input.LA(1);

                         
                        int index32_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_65==39) ) {s = 29;}

                        else if ( (LA32_65==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_65==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_65==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_65==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_65==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_65==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_65==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_65==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_65==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_65==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_65==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_65==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_65==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_65==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_65==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_65==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_65==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_65==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_65==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_65);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA32_102 = input.LA(1);

                         
                        int index32_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_102==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_102==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_102==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_102==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_102==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_102==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_102==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_102==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_102==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_102==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_102==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_102==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_102==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_102==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_102==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_102==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_102==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_102==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_102==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_102==39) ) {s = 29;}

                         
                        input.seek(index32_102);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA32_87 = input.LA(1);

                         
                        int index32_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_87==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_87==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_87==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_87==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_87==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_87==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_87==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_87==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_87==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_87==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_87==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_87==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_87==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_87==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_87==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_87==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_87==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_87==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_87==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_87==39) ) {s = 29;}

                         
                        input.seek(index32_87);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA32_128 = input.LA(1);

                         
                        int index32_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_128==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_128==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_128==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_128==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_128==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_128==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_128==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_128==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_128==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_128==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_128==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_128==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_128==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_128==RULE_BINDIG) ) {s = 127;}

                        else if ( (LA32_128==RULE_NBINDIG) ) {s = 128;}

                        else if ( (LA32_128==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_128==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_128==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_128==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_128==39) ) {s = 29;}

                         
                        input.seek(index32_128);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA32_121 = input.LA(1);

                         
                        int index32_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_121==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_121==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_121==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_121==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_121==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_121==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_121==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_121==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_121==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_121==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_121==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_121==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_121==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_121==RULE_BINDIG) ) {s = 120;}

                        else if ( (LA32_121==RULE_NBINDIG) ) {s = 121;}

                        else if ( (LA32_121==39) ) {s = 29;}

                        else if ( (LA32_121==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_121==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_121==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_121==RULE_UNHEXCHAR) ) {s = 102;}

                         
                        input.seek(index32_121);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA32_66 = input.LA(1);

                         
                        int index32_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_66==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_66==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_66==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_66==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_66==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_66==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_66==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_66==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_66==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_66==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_66==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_66==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_66==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_66==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_66==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_66==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_66==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_66==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_66==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_66==39) ) {s = 29;}

                         
                        input.seek(index32_66);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA32_118 = input.LA(1);

                         
                        int index32_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_118==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_118==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_118==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_118==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_118==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_118==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_118==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_118==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_118==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_118==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_118==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_118==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_118==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_118==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_118==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_118==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_118==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_118==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_118==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_118==39) ) {s = 29;}

                         
                        input.seek(index32_118);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA32_67 = input.LA(1);

                         
                        int index32_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_67==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_67==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_67==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_67==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_67==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_67==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_67==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_67==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_67==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_67==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_67==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_67==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_67==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_67==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_67==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_67==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_67==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_67==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_67==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_67==39) ) {s = 29;}

                         
                        input.seek(index32_67);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA32_107 = input.LA(1);

                         
                        int index32_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_107==39) ) {s = 29;}

                        else if ( (LA32_107==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_107==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_107==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_107==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_107==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_107==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_107==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_107==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_107==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_107==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_107==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_107==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_107==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_107==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_107==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_107==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_107==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_107==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_107==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_107);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA32_42 = input.LA(1);

                         
                        int index32_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_42==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_42==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_42==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_42==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_42==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_42==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_42==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_42==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_42==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_42==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_42==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_42==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_42==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_42==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_42==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_42==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_42==RULE_UNHEXCHAR) ) {s = 44;}

                        else if ( (LA32_42==RULE_BINDIG) ) {s = 46;}

                        else if ( (LA32_42==RULE_NBINDIG) ) {s = 47;}

                        else if ( (LA32_42==39) ) {s = 29;}

                         
                        input.seek(index32_42);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA32_11 = input.LA(1);

                         
                        int index32_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_11==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_11==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_11==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_11==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_11==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_11==RULE_BINDIG) ) {s = 26;}

                        else if ( (LA32_11==RULE_NBINDIG) ) {s = 27;}

                        else if ( (LA32_11==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_11==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_11==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_11==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_11==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_11==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_11==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_11==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_11==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_11==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_11==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_11==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_11==39) ) {s = 29;}

                         
                        input.seek(index32_11);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA32_97 = input.LA(1);

                         
                        int index32_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_97==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_97==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_97==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_97==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_97==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_97==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_97==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_97==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_97==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_97==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_97==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_97==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_97==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_97==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_97==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_97==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_97==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_97==RULE_BINDIG) ) {s = 97;}

                        else if ( (LA32_97==RULE_NBINDIG) ) {s = 98;}

                        else if ( (LA32_97==39) ) {s = 29;}

                         
                        input.seek(index32_97);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA32_130 = input.LA(1);

                         
                        int index32_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_130==39) ) {s = 29;}

                        else if ( (LA32_130==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_130==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_130==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_130==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_130==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_130==RULE_BINDIG) ) {s = 112;}

                        else if ( (LA32_130==RULE_NBINDIG) ) {s = 113;}

                        else if ( (LA32_130==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_130==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_130==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_130==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_130==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_130==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_130==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_130==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_130==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_130==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_130==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_130==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_130);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA32_105 = input.LA(1);

                         
                        int index32_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_105==39) ) {s = 29;}

                        else if ( (LA32_105==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_105==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_105==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_105==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_105==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_105==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_105==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_105==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_105==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_105==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_105==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_105==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_105==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_105==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_105==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_105==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_105==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_105==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_105==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_105);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA32_90 = input.LA(1);

                         
                        int index32_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_90==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_90==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_90==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_90==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_90==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_90==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_90==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_90==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_90==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_90==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_90==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_90==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_90==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_90==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_90==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_90==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_90==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_90==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_90==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_90==39) ) {s = 29;}

                         
                        input.seek(index32_90);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA32_10 = input.LA(1);

                         
                        int index32_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_10==RULE_LHEXCHAR) ) {s = 41;}

                        else if ( (LA32_10==RULE_LNHEXCHAR) ) {s = 42;}

                        else if ( (LA32_10==RULE_UHEXCHAR) ) {s = 43;}

                        else if ( (LA32_10==RULE_UNHEXCHAR) ) {s = 44;}

                        else if ( (LA32_10==RULE_SLASH) ) {s = 45;}

                        else if ( (LA32_10==RULE_BINDIG) ) {s = 46;}

                        else if ( (LA32_10==RULE_NBINDIG) ) {s = 47;}

                        else if ( (LA32_10==RULE_CHARSYM) ) {s = 48;}

                        else if ( (LA32_10==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_10==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_10==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_10==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_10==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_10==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_10==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_10==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_10==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_10==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_10==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_10==39) ) {s = 29;}

                         
                        input.seek(index32_10);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA32_101 = input.LA(1);

                         
                        int index32_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_101==39) ) {s = 29;}

                        else if ( (LA32_101==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_101==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_101==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_101==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_101==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_101==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_101==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_101==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_101==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_101==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_101==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_101==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_101==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_101==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_101==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_101==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_101==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_101==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_101==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_101);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA32_50 = input.LA(1);

                         
                        int index32_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_50==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_50==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_50==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_50==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_50==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_50==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_50==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_50==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_50==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_50==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_50==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_50==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_50==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_50==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_50==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_50==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_50==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_50==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_50==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_50==39) ) {s = 29;}

                         
                        input.seek(index32_50);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA32_86 = input.LA(1);

                         
                        int index32_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_86==39) ) {s = 29;}

                        else if ( (LA32_86==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_86==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_86==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_86==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_86==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_86==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_86==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_86==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_86==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_86==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_86==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_86==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_86==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_86==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_86==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_86==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_86==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_86==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_86==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                         
                        input.seek(index32_86);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA32_0 = input.LA(1);

                         
                        int index32_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_0==45) && (synpred3_InternalGDSL())) {s = 1;}

                        else if ( (LA32_0==RULE_BINDIG) && (synpred3_InternalGDSL())) {s = 2;}

                        else if ( (LA32_0==RULE_NBINDIG) && (synpred3_InternalGDSL())) {s = 3;}

                        else if ( (LA32_0==54) && (synpred3_InternalGDSL())) {s = 4;}

                        else if ( (LA32_0==32) && (synpred3_InternalGDSL())) {s = 5;}

                        else if ( (LA32_0==52) && (synpred3_InternalGDSL())) {s = 6;}

                        else if ( (LA32_0==RULE_LHEXCHAR) ) {s = 7;}

                        else if ( (LA32_0==RULE_LNHEXCHAR) ) {s = 8;}

                        else if ( (LA32_0==RULE_UHEXCHAR) ) {s = 9;}

                        else if ( (LA32_0==RULE_UNHEXCHAR) ) {s = 10;}

                        else if ( (LA32_0==RULE_SLASH) ) {s = 11;}

                        else if ( (LA32_0==46) && (synpred3_InternalGDSL())) {s = 12;}

                        else if ( (LA32_0==47) && (synpred3_InternalGDSL())) {s = 13;}

                        else if ( (LA32_0==48) && (synpred3_InternalGDSL())) {s = 14;}

                        else if ( (LA32_0==28) && (synpred3_InternalGDSL())) {s = 15;}

                        else if ( (LA32_0==50) && (synpred3_InternalGDSL())) {s = 16;}

                        else if ( (LA32_0==35) && (synpred3_InternalGDSL())) {s = 17;}

                        else if ( (LA32_0==38) && (synpred3_InternalGDSL())) {s = 18;}

                        else if ( (LA32_0==33) && (synpred3_InternalGDSL())) {s = 19;}

                        else if ( (LA32_0==53) && (synpred3_InternalGDSL())) {s = 20;}

                         
                        input.seek(index32_0);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA32_51 = input.LA(1);

                         
                        int index32_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_51==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_51==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_51==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_51==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_51==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_51==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_51==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_51==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_51==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_51==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_51==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_51==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_51==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_51==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_51==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_51==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_51==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_51==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_51==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_51==39) ) {s = 29;}

                         
                        input.seek(index32_51);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA32_77 = input.LA(1);

                         
                        int index32_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_77==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_77==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_77==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_77==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_77==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_77==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_77==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_77==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_77==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_77==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_77==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_77==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_77==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_77==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_77==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_77==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_77==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_77==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_77==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_77==39) ) {s = 29;}

                         
                        input.seek(index32_77);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA32_24 = input.LA(1);

                         
                        int index32_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_24==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_24==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_24==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_24==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_24==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_24==RULE_SLASH) ) {s = 25;}

                        else if ( (LA32_24==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_24==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_24==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_24==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_24==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_24==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_24==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_24==RULE_LHEXCHAR) ) {s = 21;}

                        else if ( (LA32_24==RULE_LNHEXCHAR) ) {s = 22;}

                        else if ( (LA32_24==RULE_UHEXCHAR) ) {s = 23;}

                        else if ( (LA32_24==RULE_UNHEXCHAR) ) {s = 24;}

                        else if ( (LA32_24==RULE_BINDIG) ) {s = 26;}

                        else if ( (LA32_24==RULE_NBINDIG) ) {s = 27;}

                        else if ( (LA32_24==39) ) {s = 29;}

                         
                        input.seek(index32_24);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA32_93 = input.LA(1);

                         
                        int index32_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_93==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_93==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_93==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_93==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_93==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_93==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_93==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_93==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_93==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_93==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_93==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_93==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_93==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_93==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_93==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_93==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_93==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_93==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_93==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_93==39) ) {s = 29;}

                         
                        input.seek(index32_93);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA32_134 = input.LA(1);

                         
                        int index32_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_134==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_134==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_134==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_134==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_134==RULE_SLASH) ) {s = 111;}

                        else if ( (LA32_134==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_134==RULE_CHARSYM) ) {s = 114;}

                        else if ( (LA32_134==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_134==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_134==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_134==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_134==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_134==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_134==RULE_LHEXCHAR) ) {s = 107;}

                        else if ( (LA32_134==RULE_LNHEXCHAR) ) {s = 108;}

                        else if ( (LA32_134==RULE_UHEXCHAR) ) {s = 109;}

                        else if ( (LA32_134==RULE_UNHEXCHAR) ) {s = 110;}

                        else if ( (LA32_134==RULE_BINDIG) ) {s = 134;}

                        else if ( (LA32_134==RULE_NBINDIG) ) {s = 135;}

                        else if ( (LA32_134==39) ) {s = 29;}

                         
                        input.seek(index32_134);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA32_124 = input.LA(1);

                         
                        int index32_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_124==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_124==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_124==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_124==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_124==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_124==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_124==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_124==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_124==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_124==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_124==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_124==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_124==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_124==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_124==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_124==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_124==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_124==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_124==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_124==39) ) {s = 29;}

                         
                        input.seek(index32_124);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA32_116 = input.LA(1);

                         
                        int index32_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_116==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_116==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_116==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_116==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_116==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_116==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_116==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_116==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_116==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_116==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_116==RULE_SLASH) ) {s = 103;}

                        else if ( (LA32_116==RULE_CHARSYM) ) {s = 106;}

                        else if ( (LA32_116==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_116==RULE_LHEXCHAR) ) {s = 99;}

                        else if ( (LA32_116==RULE_LNHEXCHAR) ) {s = 100;}

                        else if ( (LA32_116==RULE_UHEXCHAR) ) {s = 101;}

                        else if ( (LA32_116==RULE_UNHEXCHAR) ) {s = 102;}

                        else if ( (LA32_116==RULE_BINDIG) ) {s = 104;}

                        else if ( (LA32_116==RULE_NBINDIG) ) {s = 105;}

                        else if ( (LA32_116==39) ) {s = 29;}

                         
                        input.seek(index32_116);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA32_126 = input.LA(1);

                         
                        int index32_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_126==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_126==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_126==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_126==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_126==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_126==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_126==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_126==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_126==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_126==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_126==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_126==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_126==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_126==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_126==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_126==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_126==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_126==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_126==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_126==39) ) {s = 29;}

                         
                        input.seek(index32_126);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA32_73 = input.LA(1);

                         
                        int index32_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_73==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_73==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_73==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_73==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_73==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_73==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_73==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_73==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_73==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_73==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_73==RULE_SLASH) ) {s = 76;}

                        else if ( (LA32_73==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_73==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_73==RULE_LHEXCHAR) ) {s = 72;}

                        else if ( (LA32_73==RULE_LNHEXCHAR) ) {s = 73;}

                        else if ( (LA32_73==RULE_UHEXCHAR) ) {s = 74;}

                        else if ( (LA32_73==RULE_UNHEXCHAR) ) {s = 75;}

                        else if ( (LA32_73==RULE_BINDIG) ) {s = 77;}

                        else if ( (LA32_73==RULE_NBINDIG) ) {s = 78;}

                        else if ( (LA32_73==39) ) {s = 29;}

                         
                        input.seek(index32_73);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA32_79 = input.LA(1);

                         
                        int index32_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_79==39) ) {s = 29;}

                        else if ( (LA32_79==RULE_LHEXCHAR) ) {s = 92;}

                        else if ( (LA32_79==RULE_LNHEXCHAR) ) {s = 93;}

                        else if ( (LA32_79==RULE_UHEXCHAR) ) {s = 94;}

                        else if ( (LA32_79==RULE_UNHEXCHAR) ) {s = 95;}

                        else if ( (LA32_79==RULE_SLASH) ) {s = 96;}

                        else if ( (LA32_79==RULE_BINDIG) ) {s = 97;}

                        else if ( (LA32_79==RULE_NBINDIG) ) {s = 98;}

                        else if ( (LA32_79==RULE_CHARSYM) ) {s = 79;}

                        else if ( (LA32_79==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_79==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_79==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_79==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_79==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_79==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_79==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_79==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_79==50) && (synpred3_InternalGDSL())) {s = 64;}

                        else if ( (LA32_79==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_79==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_79==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_79==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_79==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_79==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_79==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_79==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_79==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_79==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_79==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_79);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA32_28 = input.LA(1);

                         
                        int index32_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_28==39) ) {s = 29;}

                        else if ( (LA32_28==RULE_LHEXCHAR) ) {s = 49;}

                        else if ( (LA32_28==RULE_LNHEXCHAR) ) {s = 50;}

                        else if ( (LA32_28==RULE_UHEXCHAR) ) {s = 51;}

                        else if ( (LA32_28==RULE_UNHEXCHAR) ) {s = 52;}

                        else if ( (LA32_28==RULE_SLASH) ) {s = 53;}

                        else if ( (LA32_28==RULE_BINDIG) ) {s = 54;}

                        else if ( (LA32_28==RULE_NBINDIG) ) {s = 55;}

                        else if ( (LA32_28==RULE_CHARSYM) ) {s = 28;}

                        else if ( (LA32_28==45) && (synpred3_InternalGDSL())) {s = 56;}

                        else if ( (LA32_28==54) && (synpred3_InternalGDSL())) {s = 57;}

                        else if ( (LA32_28==32) && (synpred3_InternalGDSL())) {s = 58;}

                        else if ( (LA32_28==52) && (synpred3_InternalGDSL())) {s = 59;}

                        else if ( (LA32_28==46) && (synpred3_InternalGDSL())) {s = 60;}

                        else if ( (LA32_28==47) && (synpred3_InternalGDSL())) {s = 61;}

                        else if ( (LA32_28==48) && (synpred3_InternalGDSL())) {s = 62;}

                        else if ( (LA32_28==28) && (synpred3_InternalGDSL())) {s = 63;}

                        else if ( (LA32_28==50) && (synpred3_InternalGDSL())) {s = 64;}

                        else if ( (LA32_28==RULE_DOT) && (synpred3_InternalGDSL())) {s = 30;}

                        else if ( (LA32_28==44) && (synpred3_InternalGDSL())) {s = 31;}

                        else if ( (LA32_28==42) && (synpred3_InternalGDSL())) {s = 32;}

                        else if ( (LA32_28==43) && (synpred3_InternalGDSL())) {s = 33;}

                        else if ( (LA32_28==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_28==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_28==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_28==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_28==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_28==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_28==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                         
                        input.seek(index32_28);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA32_94 = input.LA(1);

                         
                        int index32_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_94==RULE_LHEXCHAR) ) {s = 84;}

                        else if ( (LA32_94==RULE_LNHEXCHAR) ) {s = 85;}

                        else if ( (LA32_94==RULE_UHEXCHAR) ) {s = 86;}

                        else if ( (LA32_94==RULE_UNHEXCHAR) ) {s = 87;}

                        else if ( (LA32_94==RULE_SLASH) ) {s = 88;}

                        else if ( (LA32_94==RULE_BINDIG) ) {s = 89;}

                        else if ( (LA32_94==RULE_NBINDIG) ) {s = 90;}

                        else if ( (LA32_94==RULE_CHARSYM) ) {s = 91;}

                        else if ( (LA32_94==RULE_DOT) && (synpred3_InternalGDSL())) {s = 80;}

                        else if ( (LA32_94==44) && (synpred3_InternalGDSL())) {s = 81;}

                        else if ( (LA32_94==42) && (synpred3_InternalGDSL())) {s = 82;}

                        else if ( (LA32_94==43) && (synpred3_InternalGDSL())) {s = 83;}

                        else if ( (LA32_94==41) && (synpred3_InternalGDSL())) {s = 36;}

                        else if ( (LA32_94==40) && (synpred3_InternalGDSL())) {s = 37;}

                        else if ( (LA32_94==19) && (synpred3_InternalGDSL())) {s = 38;}

                        else if ( (LA32_94==34) && (synpred3_InternalGDSL())) {s = 39;}

                        else if ( (LA32_94==EOF) && (synpred3_InternalGDSL())) {s = 40;}

                        else if ( (LA32_94==RULE_BS) && (synpred3_InternalGDSL())) {s = 34;}

                        else if ( (LA32_94==RULE_OTHERSYM) && (synpred3_InternalGDSL())) {s = 35;}

                        else if ( (LA32_94==39) ) {s = 29;}

                         
                        input.seek(index32_94);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA36_eotS =
        "\34\uffff";
    static final String DFA36_eofS =
        "\1\1\33\uffff";
    static final String DFA36_minS =
        "\1\4\20\uffff\1\0\12\uffff";
    static final String DFA36_maxS =
        "\1\63\20\uffff\1\0\12\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\2\26\uffff\4\1";
    static final String DFA36_specialS =
        "\1\0\20\uffff\1\1\12\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\31\4\1\1\21\1\32\1\uffff\1\30\1\uffff\1\33\3\uffff\5"+
            "\1\1\uffff\1\1\1\uffff\1\1\1\uffff\2\1\3\uffff\1\1\1\uffff\2"+
            "\1\2\uffff\2\1\7\uffff\1\1\1\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()* loopback of 2078:2: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_0 = input.LA(1);

                         
                        int index36_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA36_0==EOF||LA36_0==RULE_PIPE||(LA36_0>=RULE_LHEXCHAR && LA36_0<=RULE_LNHEXCHAR)||(LA36_0>=19 && LA36_0<=23)||LA36_0==25||LA36_0==27||(LA36_0>=29 && LA36_0<=30)||LA36_0==34||(LA36_0>=36 && LA36_0<=37)||(LA36_0>=40 && LA36_0<=41)||LA36_0==49||LA36_0==51) ) {s = 1;}

                        else if ( (LA36_0==RULE_SLASH) ) {s = 17;}

                        else if ( (LA36_0==RULE_BS) && (synpred4_InternalGDSL())) {s = 24;}

                        else if ( (LA36_0==RULE_DOT) && (synpred4_InternalGDSL())) {s = 25;}

                        else if ( (LA36_0==RULE_CHARSYM) && (synpred4_InternalGDSL())) {s = 26;}

                        else if ( (LA36_0==RULE_OTHERSYM) && (synpred4_InternalGDSL())) {s = 27;}

                         
                        input.seek(index36_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_17 = input.LA(1);

                         
                        int index36_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalGDSL()) ) {s = 27;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\24\uffff";
    static final String DFA40_eofS =
        "\24\uffff";
    static final String DFA40_minS =
        "\2\6\17\uffff\2\0\1\uffff";
    static final String DFA40_maxS =
        "\2\66\17\uffff\2\0\1\uffff";
    static final String DFA40_acceptS =
        "\2\uffff\17\2\2\uffff\1\1";
    static final String DFA40_specialS =
        "\1\0\20\uffff\1\1\1\2\1\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\7\1\11\1\12\1\10\1\13\1\uffff\1\2\1\uffff\1\3\15\uffff\1"+
            "\17\3\uffff\1\5\14\uffff\1\1\1\14\1\15\1\16\1\uffff\1\20\1\uffff"+
            "\1\6\1\uffff\1\4",
            "\5\23\1\uffff\1\21\1\uffff\1\22\15\uffff\1\23\3\uffff\1\23"+
            "\14\uffff\4\23\1\uffff\1\23\1\uffff\1\23\1\uffff\1\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "2287:2: ( (lv_neg_0_0= '~' ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_0 = input.LA(1);

                         
                        int index40_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA40_0==45) ) {s = 1;}

                        else if ( (LA40_0==RULE_BINDIG) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA40_0==RULE_NBINDIG) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA40_0==54) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA40_0==32) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA40_0==52) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA40_0==RULE_LHEXCHAR) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA40_0==RULE_LNHEXCHAR) && (synpred5_InternalGDSL())) {s = 8;}

                        else if ( (LA40_0==RULE_UHEXCHAR) && (synpred5_InternalGDSL())) {s = 9;}

                        else if ( (LA40_0==RULE_UNHEXCHAR) && (synpred5_InternalGDSL())) {s = 10;}

                        else if ( (LA40_0==RULE_SLASH) && (synpred5_InternalGDSL())) {s = 11;}

                        else if ( (LA40_0==46) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA40_0==47) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA40_0==48) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA40_0==28) && (synpred5_InternalGDSL())) {s = 15;}

                        else if ( (LA40_0==50) && (synpred5_InternalGDSL())) {s = 16;}

                         
                        input.seek(index40_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_17 = input.LA(1);

                         
                        int index40_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 19;}

                        else if ( (synpred5_InternalGDSL()) ) {s = 16;}

                         
                        input.seek(index40_17);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_18 = input.LA(1);

                         
                        int index40_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 19;}

                        else if ( (synpred5_InternalGDSL()) ) {s = 16;}

                         
                        input.seek(index40_18);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA47_eotS =
        "\16\uffff";
    static final String DFA47_eofS =
        "\16\uffff";
    static final String DFA47_minS =
        "\1\6\4\uffff\2\0\7\uffff";
    static final String DFA47_maxS =
        "\1\66\4\uffff\2\0\7\uffff";
    static final String DFA47_acceptS =
        "\1\uffff\1\1\1\2\2\3\2\uffff\1\3\1\5\1\6\1\7\1\10\1\11\1\4";
    static final String DFA47_specialS =
        "\1\1\4\uffff\1\0\1\2\7\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\3\1\5\1\6\1\4\1\7\1\uffff\1\1\1\uffff\1\1\15\uffff\1\13\3"+
            "\uffff\1\1\14\uffff\1\1\1\10\1\11\1\12\1\uffff\1\14\1\uffff"+
            "\1\2\1\uffff\1\1",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "2345:1: ( ( () ruleLit ) | ( () ruleString ) | ( ( ( ( ruleQid ) )=> (lv_id_4_0= ruleQid ) ) ( ( ( RULE_DOT )=>this_DOT_5= RULE_DOT ) ( (lv_id_6_0= ruleQid ) ) )* ) | ( () ruleConUse ) | (otherlv_9= '@' otherlv_10= '{' ( (lv_fields_11_0= ruleField ) ) (otherlv_12= ',' ( (lv_fields_13_0= ruleField ) ) )* otherlv_14= '}' ) | ( () otherlv_16= '$' ruleQid ) | (otherlv_18= '(' ( (lv_exp_19_0= ruleExp ) ) otherlv_20= ')' ( ( ( RULE_DOT )=>this_DOT_21= RULE_DOT ) ( (lv_id_22_0= ruleQid ) ) )* ) | ( () otherlv_24= '{' ( ( (lv_id_25_0= ruleName ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) ( ( ( ( ruleName ) )=> (lv_id_28_0= ruleName ) ) otherlv_29= '=' ( (lv_exps_30_0= ruleExp ) ) )* )? otherlv_31= '}' ) | (otherlv_32= 'let' ( (lv_valDecl_33_0= ruleValueDecl ) )+ otherlv_34= 'in' ( (lv_exp_35_0= ruleExp ) ) otherlv_36= 'end' ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_5 = input.LA(1);

                         
                        int index47_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalGDSL()) ) {s = 7;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index47_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA47_0 = input.LA(1);

                         
                        int index47_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA47_0==RULE_BINDIG||LA47_0==RULE_NBINDIG||LA47_0==32||LA47_0==45||LA47_0==54) ) {s = 1;}

                        else if ( (LA47_0==52) ) {s = 2;}

                        else if ( (LA47_0==RULE_LHEXCHAR) && (synpred6_InternalGDSL())) {s = 3;}

                        else if ( (LA47_0==RULE_LNHEXCHAR) && (synpred6_InternalGDSL())) {s = 4;}

                        else if ( (LA47_0==RULE_UHEXCHAR) ) {s = 5;}

                        else if ( (LA47_0==RULE_UNHEXCHAR) ) {s = 6;}

                        else if ( (LA47_0==RULE_SLASH) && (synpred6_InternalGDSL())) {s = 7;}

                        else if ( (LA47_0==46) ) {s = 8;}

                        else if ( (LA47_0==47) ) {s = 9;}

                        else if ( (LA47_0==48) ) {s = 10;}

                        else if ( (LA47_0==28) ) {s = 11;}

                        else if ( (LA47_0==50) ) {s = 12;}

                         
                        input.seek(index47_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA47_6 = input.LA(1);

                         
                        int index47_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalGDSL()) ) {s = 7;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index47_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA63_eotS =
        "\26\uffff";
    static final String DFA63_eofS =
        "\1\6\25\uffff";
    static final String DFA63_minS =
        "\1\6\5\0\1\uffff\2\0\15\uffff";
    static final String DFA63_maxS =
        "\1\66\5\0\1\uffff\2\0\15\uffff";
    static final String DFA63_acceptS =
        "\6\uffff\1\2\16\uffff\1\1";
    static final String DFA63_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\1\uffff\1\6\1\7\15\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\1\1\3\1\4\1\2\1\5\1\25\1\7\1\uffff\1\10\15\uffff\1\6\3\uffff"+
            "\2\6\1\uffff\1\6\2\uffff\1\6\6\uffff\4\6\1\uffff\1\6\1\uffff"+
            "\1\6\1\uffff\1\6",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "()+ loopback of 3511:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_0 = input.LA(1);

                         
                        int index63_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA63_0==RULE_LHEXCHAR) ) {s = 1;}

                        else if ( (LA63_0==RULE_LNHEXCHAR) ) {s = 2;}

                        else if ( (LA63_0==RULE_UHEXCHAR) ) {s = 3;}

                        else if ( (LA63_0==RULE_UNHEXCHAR) ) {s = 4;}

                        else if ( (LA63_0==RULE_SLASH) ) {s = 5;}

                        else if ( (LA63_0==EOF||LA63_0==28||(LA63_0>=32 && LA63_0<=33)||LA63_0==35||LA63_0==38||(LA63_0>=45 && LA63_0<=48)||LA63_0==50||LA63_0==52||LA63_0==54) ) {s = 6;}

                        else if ( (LA63_0==RULE_BINDIG) ) {s = 7;}

                        else if ( (LA63_0==RULE_NBINDIG) ) {s = 8;}

                        else if ( (LA63_0==RULE_CHARSYM) && (synpred15_InternalGDSL())) {s = 21;}

                         
                        input.seek(index63_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA63_1 = input.LA(1);

                         
                        int index63_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalGDSL()) ) {s = 21;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA63_2 = input.LA(1);

                         
                        int index63_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalGDSL()) ) {s = 21;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA63_3 = input.LA(1);

                         
                        int index63_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalGDSL()) ) {s = 21;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA63_4 = input.LA(1);

                         
                        int index63_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalGDSL()) ) {s = 21;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA63_5 = input.LA(1);

                         
                        int index63_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalGDSL()) ) {s = 21;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA63_7 = input.LA(1);

                         
                        int index63_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalGDSL()) ) {s = 21;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA63_8 = input.LA(1);

                         
                        int index63_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalGDSL()) ) {s = 21;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 63, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA64_eotS =
        "\47\uffff";
    static final String DFA64_eofS =
        "\1\1\46\uffff";
    static final String DFA64_minS =
        "\1\4\14\uffff\1\0\1\uffff\1\0\6\uffff\4\0\6\uffff\2\0\5\uffff";
    static final String DFA64_maxS =
        "\1\66\14\uffff\1\0\1\uffff\1\0\6\uffff\4\0\6\uffff\2\0\5\uffff";
    static final String DFA64_acceptS =
        "\1\uffff\1\2\44\uffff\1\1";
    static final String DFA64_specialS =
        "\15\uffff\1\0\1\uffff\1\1\6\uffff\1\2\1\3\1\4\1\5\6\uffff\1\6\1"+
        "\7\5\uffff}>";
    static final String[] DFA64_transitionS = {
            "\2\1\1\26\1\30\1\31\1\27\1\15\1\17\1\40\1\1\1\41\1\1\3\uffff"+
            "\5\1\1\uffff\1\1\1\uffff\1\1\1\uffff\4\1\1\uffff\1\1\1\uffff"+
            "\2\1\2\uffff\6\1\3\uffff\1\1\1\uffff\1\1\1\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "()* loopback of 3554:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_13 = input.LA(1);

                         
                        int index64_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalGDSL()) ) {s = 38;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA64_15 = input.LA(1);

                         
                        int index64_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalGDSL()) ) {s = 38;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA64_22 = input.LA(1);

                         
                        int index64_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalGDSL()) ) {s = 38;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_22);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA64_23 = input.LA(1);

                         
                        int index64_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalGDSL()) ) {s = 38;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_23);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA64_24 = input.LA(1);

                         
                        int index64_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalGDSL()) ) {s = 38;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_24);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA64_25 = input.LA(1);

                         
                        int index64_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalGDSL()) ) {s = 38;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_25);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA64_32 = input.LA(1);

                         
                        int index64_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalGDSL()) ) {s = 38;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_32);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA64_33 = input.LA(1);

                         
                        int index64_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalGDSL()) ) {s = 38;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_33);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA65_eotS =
        "\54\uffff";
    static final String DFA65_eofS =
        "\1\1\53\uffff";
    static final String DFA65_minS =
        "\1\4\1\uffff\2\0\3\uffff\5\0\24\uffff\1\0\13\uffff";
    static final String DFA65_maxS =
        "\1\66\1\uffff\2\0\3\uffff\5\0\24\uffff\1\0\13\uffff";
    static final String DFA65_acceptS =
        "\1\uffff\1\2\51\uffff\1\1";
    static final String DFA65_specialS =
        "\2\uffff\1\0\1\1\3\uffff\1\2\1\3\1\4\1\5\1\6\24\uffff\1\7\13\uffff}>";
    static final String[] DFA65_transitionS = {
            "\2\1\1\7\1\11\1\12\1\10\1\13\1\40\1\2\1\1\1\3\1\1\3\uffff\16"+
            "\1\1\uffff\1\1\1\uffff\2\1\1\uffff\10\1\2\uffff\1\1\1\uffff"+
            "\1\1\1\uffff\2\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "()* loopback of 3597:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_2 = input.LA(1);

                         
                        int index65_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalGDSL()) ) {s = 43;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA65_3 = input.LA(1);

                         
                        int index65_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalGDSL()) ) {s = 43;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA65_7 = input.LA(1);

                         
                        int index65_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalGDSL()) ) {s = 43;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA65_8 = input.LA(1);

                         
                        int index65_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalGDSL()) ) {s = 43;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA65_9 = input.LA(1);

                         
                        int index65_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalGDSL()) ) {s = 43;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA65_10 = input.LA(1);

                         
                        int index65_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalGDSL()) ) {s = 43;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA65_11 = input.LA(1);

                         
                        int index65_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalGDSL()) ) {s = 43;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_11);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA65_32 = input.LA(1);

                         
                        int index65_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalGDSL()) ) {s = 43;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_32);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel131 = new BitSet(new long[]{0x0000000008D80002L});
    public static final BitSet FOLLOW_19_in_ruleModel145 = new BitSet(new long[]{0x0000000008D80000L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel168 = new BitSet(new long[]{0x0000000008D80002L});
    public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecl216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_ruleDecl263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_ruleDecl290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_ruleDecl317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_ruleDecl344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_entryRuleDeclGranularity379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclGranularity389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleDeclGranularity432 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclGranularity457 = new BitSet(new long[]{0x0040200000005000L});
    public static final BitSet FOLLOW_ruleInt_in_ruleDeclGranularity478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleDeclExport567 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclExport592 = new BitSet(new long[]{0x00000000000007C2L});
    public static final BitSet FOLLOW_ruleExport_in_ruleDeclExport613 = new BitSet(new long[]{0x00000000000007C2L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDeclType697 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType718 = new BitSet(new long[]{0x00402000112057D0L});
    public static final BitSet FOLLOW_21_in_ruleDeclType733 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_ruleConDecls_in_ruleDeclType764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclType792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleDeclType812 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType833 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleDeclType846 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType867 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleDeclType881 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclType893 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_ruleConDecls_in_ruleDeclType914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDeclVal1000 = new BitSet(new long[]{0x000000000000AFE0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1022 = new BitSet(new long[]{0x00000000002007C0L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleDeclVal1059 = new BitSet(new long[]{0x00000000002007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1081 = new BitSet(new long[]{0x00000000002007C0L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1094 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDeclVal1135 = new BitSet(new long[]{0x0075E04B102057C0L});
    public static final BitSet FOLLOW_ruleMIXID_in_ruleDeclVal1157 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1178 = new BitSet(new long[]{0x0075E04B102057C0L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1192 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDeclVal1233 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1254 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDeclVal1266 = new BitSet(new long[]{0x00402001040057C0L});
    public static final BitSet FOLLOW_ruleDecodePat_in_ruleDeclVal1288 = new BitSet(new long[]{0x00402001040057C0L});
    public static final BitSet FOLLOW_ruleDecodePat_in_ruleDeclVal1309 = new BitSet(new long[]{0x00402001040057C0L});
    public static final BitSet FOLLOW_26_in_ruleDeclVal1324 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1338 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleDeclVal1378 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1398 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1410 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1431 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport1471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleExport1527 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleExport1540 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleExport1561 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_25_in_ruleExport1574 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleExport1595 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_ruleExport1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_entryRuleConDecls1647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecls1657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleConDecls1703 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleConDecls1715 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleConDecls1735 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl1773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_ruleConDecl1829 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleConDecl1842 = new BitSet(new long[]{0x00402000102057D0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleConDecl1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy1901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy1911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTy1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleTy1975 = new BitSet(new long[]{0x0040200000005000L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTy1995 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleTy2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTy2034 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleTy2047 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2068 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleTy2081 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2102 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleTy2116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTy2138 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2159 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_25_in_ruleTy2172 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2193 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_ruleTy2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement2244 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleTyElement2300 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleTyElement2312 = new BitSet(new long[]{0x00402000102057D0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyElement2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind2369 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind2379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTyBind2425 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleTyBind2438 = new BitSet(new long[]{0x00402000102057D0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyBind2459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecodePat_in_entryRuleDecodePat2497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecodePat2507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_ruleDecodePat2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_ruleDecodePat2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_entryRuleBitPat2616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPat2626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBitPat2663 = new BitSet(new long[]{0x00000000000037F0L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_ruleBitPat2684 = new BitSet(new long[]{0x00000001000037F0L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_ruleBitPat2705 = new BitSet(new long[]{0x00000001000037F0L});
    public static final BitSet FOLLOW_32_in_ruleBitPat2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_entryRuleTokPat2754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTokPat2764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTokPat2811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTokPat2830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp2868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp2924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMIXID_in_ruleExp2952 = new BitSet(new long[]{0x0055E04B100057C0L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp2973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_entryRuleCaseExp3010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseExp3020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleCaseExp3085 = new BitSet(new long[]{0x0055E049100057C0L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp3106 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleCaseExp3118 = new BitSet(new long[]{0x00602001000057C0L});
    public static final BitSet FOLLOW_ruleCases_in_ruleCaseExp3139 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleCaseExp3151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_entryRuleClosedExp3188 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedExp3198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_ruleClosedExp3245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleClosedExp3263 = new BitSet(new long[]{0x0055E04B100057C0L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3284 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleClosedExp3296 = new BitSet(new long[]{0x0055E04B100057C0L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3317 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleClosedExp3329 = new BitSet(new long[]{0x0055E04B100057C0L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleClosedExp3370 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3391 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_19_in_ruleClosedExp3404 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3425 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_34_in_ruleClosedExp3439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonadicExp3486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleMonadicExp3570 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleMonadicExp3582 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCases_in_entryRuleCases3640 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCases3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePat_in_ruleCases3696 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleCases3708 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCases3729 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleCases3741 = new BitSet(new long[]{0x00602001000057C0L});
    public static final BitSet FOLLOW_rulePat_in_ruleCases3761 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleCases3773 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCases3794 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3832 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrElseExp3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3889 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleOrElseExp3910 = new BitSet(new long[]{0x0055E001100057C0L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3931 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp3969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndAlsoExp3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp4026 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleAndAlsoExp4047 = new BitSet(new long[]{0x0055E001100057C0L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp4068 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_entryRuleRExp4106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRExp4116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp4162 = new BitSet(new long[]{0x000000000000AFE2L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleRExp4194 = new BitSet(new long[]{0x0055E001100057C0L});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp4215 = new BitSet(new long[]{0x000000000000AFE2L});
    public static final BitSet FOLLOW_ruleAExp_in_entryRuleAExp4253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExp4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4309 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_42_in_ruleAExp4330 = new BitSet(new long[]{0x0055E001100057C0L});
    public static final BitSet FOLLOW_43_in_ruleAExp4359 = new BitSet(new long[]{0x0055E001100057C0L});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4396 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_entryRuleMExp4434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMExp4444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleMExp4490 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleMExp4503 = new BitSet(new long[]{0x0055E001100057C0L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleMExp4524 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_entryRuleApplyExp4562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleApplyExp4572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleApplyExp4615 = new BitSet(new long[]{0x0055E001100057C0L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleApplyExp4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp4696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicExp4706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLit_in_ruleAtomicExp4757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleString_in_ruleAtomicExp4789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleAtomicExp4827 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp4845 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleQid_in_ruleAtomicExp4866 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleConUse_in_ruleAtomicExp4901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleAtomicExp4920 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleAtomicExp4932 = new BitSet(new long[]{0x00002000000007C0L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp4953 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_25_in_ruleAtomicExp4966 = new BitSet(new long[]{0x00002000000007C0L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp4987 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_ruleAtomicExp5001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleAtomicExp5030 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleQid_in_ruleAtomicExp5046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleAtomicExp5065 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5086 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleAtomicExp5098 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp5116 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleQid_in_ruleAtomicExp5137 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_28_in_ruleAtomicExp5168 = new BitSet(new long[]{0x00000000200007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleAtomicExp5190 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleAtomicExp5202 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5223 = new BitSet(new long[]{0x00000000200007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleAtomicExp5255 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleAtomicExp5267 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5288 = new BitSet(new long[]{0x00000000200007C0L});
    public static final BitSet FOLLOW_29_in_ruleAtomicExp5304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleAtomicExp5324 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_ruleValueDecl_in_ruleAtomicExp5345 = new BitSet(new long[]{0x0008000008000000L});
    public static final BitSet FOLLOW_51_in_ruleAtomicExp5358 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5379 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExp5391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleField_in_entryRuleField5428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleField5438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleField5485 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleField5497 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleField5518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleField5538 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleField5559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueDecl_in_entryRuleValueDecl5596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueDecl5606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleValueDecl5643 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleValueDecl5659 = new BitSet(new long[]{0x00000000002007C0L});
    public static final BitSet FOLLOW_ruleName_in_ruleValueDecl5675 = new BitSet(new long[]{0x00000000002007C0L});
    public static final BitSet FOLLOW_21_in_ruleValueDecl5688 = new BitSet(new long[]{0x0075E04B100057C0L});
    public static final BitSet FOLLOW_ruleExp_in_ruleValueDecl5710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleString_in_entryRuleString5746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleString5757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleString5795 = new BitSet(new long[]{0x00100000000007C0L});
    public static final BitSet FOLLOW_ruleSTRCHAR_in_ruleString5818 = new BitSet(new long[]{0x00100000000007C0L});
    public static final BitSet FOLLOW_52_in_ruleString5838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePat_in_entryRulePat5879 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePat5890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rulePat5928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLit_in_rulePat5956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rulePat5995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConUse_in_rulePat6030 = new BitSet(new long[]{0x00602001000057C2L});
    public static final BitSet FOLLOW_rulePat_in_rulePat6058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLit_in_entryRuleLit6107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLit6118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleLit6165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleLit6190 = new BitSet(new long[]{0x0000000100003030L});
    public static final BitSet FOLLOW_ruleBITSTR_in_ruleLit6213 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleLit6233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat6275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimBitPat6286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rulePrimBitPat6339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rulePrimBitPat6374 = new BitSet(new long[]{0x0000400080000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_rulePrimBitPat6402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt6451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPatOrInt6462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBitPatOrInt6501 = new BitSet(new long[]{0x0040000000005000L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleBitPatOrInt6523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleBitPatOrInt6549 = new BitSet(new long[]{0x0000000000003030L});
    public static final BitSet FOLLOW_ruleBITSTR_in_ruleBitPatOrInt6571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_entryRuleInt6618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInt6629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleInt6676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_ruleInt6709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName6755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleName6812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_entryRuleConBind6857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConBind6868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConBind6914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConUse_in_entryRuleConUse6959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConUse6970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConUse7016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid7061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid7072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleQid7118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT7163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT7174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_rulePOSINT7221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_rulePOSINT7254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_entryRuleNEGINT7300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNEGINT7311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleNEGINT7349 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_ruleNUM_in_ruleNEGINT7371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_entryRuleNUM7417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUM7428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleNUM7480 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM7527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXNUM7538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleHEXNUM7576 = new BitSet(new long[]{0x00000000000050C0L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_ruleHEXNUM7604 = new BitSet(new long[]{0x00000000000050C2L});
    public static final BitSet FOLLOW_ruleBITSTR_in_entryRuleBITSTR7654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITSTR7665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITSTR7717 = new BitSet(new long[]{0x0000000000003032L});
    public static final BitSet FOLLOW_ruleMIXID_in_entryRuleMIXID7764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMIXID7775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleMIXID7813 = new BitSet(new long[]{0x0000000000005FC0L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_ruleMIXID7841 = new BitSet(new long[]{0x0000000000005FC2L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS7889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS7900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_ruleCONS7947 = new BitSet(new long[]{0x0000000000005FC2L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_ruleCONS7980 = new BitSet(new long[]{0x0000000000005FC2L});
    public static final BitSet FOLLOW_ruleID_in_entryRuleID8028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleID8039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_ruleID8086 = new BitSet(new long[]{0x0000000000005FC2L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_ruleID8119 = new BitSet(new long[]{0x0000000000005FC2L});
    public static final BitSet FOLLOW_ruleSTRCHAR_in_entryRuleSTRCHAR8167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTRCHAR8178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_ruleSTRCHAR8224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT8269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXDIGIT8280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleHEXDIGIT8327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_ruleHEXDIGIT8360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR8406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXCHAR8417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_ruleHEXCHAR8457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_ruleHEXCHAR8483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_entryRuleULETTER8529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleULETTER8540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_ruleULETTER8580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNHEXCHAR_in_ruleULETTER8606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_entryRuleLETTER8652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLETTER8663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_ruleLETTER8703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LNHEXCHAR_in_ruleLETTER8729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_ruleLETTER8762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleLETTER8788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR8834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDCHAR8845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_ruleIDCHAR8892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleIDCHAR8925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_ruleIDCHAR8951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_entryRuleBINARY8997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBINARY9008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_ruleBINARY9048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleBINARY9074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleBINARY9100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleBINARY9126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_entryRuleDIG9172 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDIG9183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_ruleDIG9223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NBINDIG_in_ruleDIG9249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_entryRuleSYM9295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSYM9306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleSYM9346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleSYM9372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSYM9398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_ruleSYM9424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OTHERSYM_in_ruleSYM9450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred2_InternalGDSL1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_synpred3_InternalGDSL3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred4_InternalGDSL4177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_synpred5_InternalGDSL4643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_synpred6_InternalGDSL4810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred7_InternalGDSL4840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred8_InternalGDSL5111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_synpred9_InternalGDSL5238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_synpred10_InternalGDSL5979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_synpred11_InternalGDSL6323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_synpred12_InternalGDSL7464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_synpred13_InternalGDSL7588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_synpred14_InternalGDSL7701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_synpred15_InternalGDSL7825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_synpred16_InternalGDSL7964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_synpred17_InternalGDSL8103 = new BitSet(new long[]{0x0000000000000002L});

}