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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_PIPE", "RULE_LHEXCHAR", "RULE_UHEXCHAR", "RULE_UNHEXCHAR", "RULE_LNHEXCHAR", "RULE_SLASH", "RULE_CHARSYM", "RULE_BINDIG", "RULE_BS", "RULE_DOT", "RULE_NBINDIG", "RULE_OTHERSYM", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "';'", "'granularity'", "'='", "'export'", "'type'", "'['", "','", "']'", "'val'", "'{'", "'}'", "'of'", "':'", "'\\''", "'case'", "'end'", "'if'", "'then'", "'else'", "'do'", "'<-'", "'or'", "'and'", "'todo'", "'_'", "'@'", "'~'", "'0x'"
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
    public static final int RULE_DOT=13;
    public static final int RULE_NBINDIG=14;
    public static final int RULE_LHEXCHAR=5;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_SL_COMMENT=18;
    public static final int RULE_ML_COMMENT=17;
    public static final int RULE_BS=12;
    public static final int RULE_UNHEXCHAR=7;
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
    public static final int RULE_LNHEXCHAR=8;
    public static final int RULE_BINDIG=11;
    public static final int RULE_SLASH=9;
    public static final int RULE_CHARSYM=10;
    public static final int RULE_WS=16;
    public static final int RULE_UHEXCHAR=6;

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

            if ( ((LA7_0>=RULE_PIPE && LA7_0<=RULE_SLASH)||LA7_0==RULE_BINDIG||LA7_0==RULE_NBINDIG||LA7_0==21||LA7_0==28||(LA7_0>=45 && LA7_0<=46)) ) {
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
                    else if ( ((LA5_0>=RULE_PIPE && LA5_0<=RULE_SLASH)||LA5_0==RULE_BINDIG||LA5_0==RULE_NBINDIG||LA5_0==28||(LA5_0>=45 && LA5_0<=46)) ) {
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:472:1: ruleDeclVal returns [EObject current=null] : ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( (lv_name_7_0= ruleName ) ) otherlv_8= '[' ( ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )* )? otherlv_11= ']' ( (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) ) | (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+ ) ) ) ;
    public final EObject ruleDeclVal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token this_PIPE_14=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_attr_3_0 = null;

        EObject lv_exp_5_0 = null;

        AntlrDatatypeRuleToken lv_name_7_0 = null;

        EObject lv_decPat_9_0 = null;

        EObject lv_decPat_10_0 = null;

        EObject lv_exp_13_0 = null;

        EObject lv_exps_15_0 = null;

        EObject lv_exps_17_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:475:28: ( ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( (lv_name_7_0= ruleName ) ) otherlv_8= '[' ( ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )* )? otherlv_11= ']' ( (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) ) | (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+ ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:1: ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( (lv_name_7_0= ruleName ) ) otherlv_8= '[' ( ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )* )? otherlv_11= ']' ( (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) ) | (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+ ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:1: ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( (lv_name_7_0= ruleName ) ) otherlv_8= '[' ( ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )* )? otherlv_11= ']' ( (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) ) | (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+ ) ) )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:562:6: (otherlv_6= 'val' ( (lv_name_7_0= ruleName ) ) otherlv_8= '[' ( ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )* )? otherlv_11= ']' ( (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) ) | (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+ ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:562:6: (otherlv_6= 'val' ( (lv_name_7_0= ruleName ) ) otherlv_8= '[' ( ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )* )? otherlv_11= ']' ( (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) ) | (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+ ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:562:8: otherlv_6= 'val' ( (lv_name_7_0= ruleName ) ) otherlv_8= '[' ( ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )* )? otherlv_11= ']' ( (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) ) | (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+ )
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleDeclVal1135); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDeclValAccess().getValKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:566:1: ( (lv_name_7_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:567:1: (lv_name_7_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:567:1: (lv_name_7_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:568:3: lv_name_7_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleDeclVal1156);
                    lv_name_7_0=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_7_0, 
                              		"Name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,24,FOLLOW_24_in_ruleDeclVal1168); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:588:1: ( ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=RULE_LHEXCHAR && LA11_0<=RULE_SLASH)||LA11_0==RULE_BINDIG||LA11_0==RULE_NBINDIG||LA11_0==32||(LA11_0>=45 && LA11_0<=46)) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:588:2: ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:588:2: ( (lv_decPat_9_0= ruleDecodePat ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:589:1: (lv_decPat_9_0= ruleDecodePat )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:589:1: (lv_decPat_9_0= ruleDecodePat )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:590:3: lv_decPat_9_0= ruleDecodePat
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleDecodePat_in_ruleDeclVal1190);
                            lv_decPat_9_0=ruleDecodePat();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"decPat",
                                      		lv_decPat_9_0, 
                                      		"DecodePat");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:606:2: ( (lv_decPat_10_0= ruleDecodePat ) )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( ((LA10_0>=RULE_LHEXCHAR && LA10_0<=RULE_SLASH)||LA10_0==RULE_BINDIG||LA10_0==RULE_NBINDIG||LA10_0==32||(LA10_0>=45 && LA10_0<=46)) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:607:1: (lv_decPat_10_0= ruleDecodePat )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:607:1: (lv_decPat_10_0= ruleDecodePat )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:608:3: lv_decPat_10_0= ruleDecodePat
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDecodePat_in_ruleDeclVal1211);
                            	    lv_decPat_10_0=ruleDecodePat();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"decPat",
                            	              		lv_decPat_10_0, 
                            	              		"DecodePat");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,26,FOLLOW_26_in_ruleDeclVal1226); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:628:1: ( (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) ) | (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+ )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==21) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==RULE_PIPE) ) {
                        alt13=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:628:2: (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:628:2: (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:628:4: otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) )
                            {
                            otherlv_12=(Token)match(input,21,FOLLOW_21_in_ruleDeclVal1240); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_12, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_0_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:632:1: ( (lv_exp_13_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:633:1: (lv_exp_13_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:633:1: (lv_exp_13_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:634:3: lv_exp_13_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_5_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1261);
                            lv_exp_13_0=ruleExp();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"exp",
                                      		lv_exp_13_0, 
                                      		"Exp");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:651:6: (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:651:6: (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+
                            int cnt12=0;
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==RULE_PIPE) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:651:7: this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) )
                            	    {
                            	    this_PIPE_14=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleDeclVal1280); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_PIPE_14, grammarAccess.getDeclValAccess().getPIPETerminalRuleCall_1_5_1_0()); 
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:655:1: ( (lv_exps_15_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:656:1: (lv_exps_15_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:656:1: (lv_exps_15_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:657:3: lv_exps_15_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1300);
                            	    lv_exps_15_0=ruleExp();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"exps",
                            	              		lv_exps_15_0, 
                            	              		"Exp");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }

                            	    otherlv_16=(Token)match(input,21,FOLLOW_21_in_ruleDeclVal1312); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_16, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_1_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:677:1: ( (lv_exps_17_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:678:1: (lv_exps_17_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:678:1: (lv_exps_17_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:679:3: lv_exps_17_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1333);
                            	    lv_exps_17_0=ruleExp();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"exps",
                            	              		lv_exps_17_0, 
                            	              		"Exp");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt12 >= 1 ) break loop12;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(12, input);
                                        throw eee;
                                }
                                cnt12++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:703:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:704:2: (iv_ruleExport= ruleExport EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:705:2: iv_ruleExport= ruleExport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExportRule()); 
            }
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport1373);
            iv_ruleExport=ruleExport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport1383); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:712:1: ruleExport returns [EObject current=null] : ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:715:28: ( ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:716:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:716:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:716:2: ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:716:2: ( (lv_name_0_0= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:717:1: (lv_name_0_0= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:717:1: (lv_name_0_0= ruleQid )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:718:3: lv_name_0_0= ruleQid
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQid_in_ruleExport1429);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:734:2: (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:734:4: otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleExport1442); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:738:1: ( (lv_attrName_2_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:739:1: (lv_attrName_2_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:739:1: (lv_attrName_2_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:740:3: lv_attrName_2_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleExport1463);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:756:2: (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==25) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:756:4: otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleExport1476); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getExportAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:760:1: ( (lv_attrName_4_0= ruleName ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:761:1: (lv_attrName_4_0= ruleName )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:761:1: (lv_attrName_4_0= ruleName )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:762:3: lv_attrName_4_0= ruleName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleName_in_ruleExport1497);
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
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleExport1511); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:790:1: entryRuleConDecls returns [EObject current=null] : iv_ruleConDecls= ruleConDecls EOF ;
    public final EObject entryRuleConDecls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecls = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:791:2: (iv_ruleConDecls= ruleConDecls EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:792:2: iv_ruleConDecls= ruleConDecls EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConDeclsRule()); 
            }
            pushFollow(FOLLOW_ruleConDecls_in_entryRuleConDecls1549);
            iv_ruleConDecls=ruleConDecls();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConDecls; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecls1559); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:799:1: ruleConDecls returns [EObject current=null] : ( ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )* ) ;
    public final EObject ruleConDecls() throws RecognitionException {
        EObject current = null;

        Token this_PIPE_1=null;
        EObject lv_conDecls_0_0 = null;

        EObject lv_conDecls_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:802:28: ( ( ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:803:1: ( ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:803:1: ( ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:803:2: ( (lv_conDecls_0_0= ruleConDecl ) ) (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:803:2: ( (lv_conDecls_0_0= ruleConDecl ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:804:1: (lv_conDecls_0_0= ruleConDecl )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:804:1: (lv_conDecls_0_0= ruleConDecl )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:805:3: lv_conDecls_0_0= ruleConDecl
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConDecl_in_ruleConDecls1605);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:821:2: (this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_PIPE) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:821:3: this_PIPE_1= RULE_PIPE ( (lv_conDecls_2_0= ruleConDecl ) )
            	    {
            	    this_PIPE_1=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleConDecls1617); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_PIPE_1, grammarAccess.getConDeclsAccess().getPIPETerminalRuleCall_1_0()); 
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:825:1: ( (lv_conDecls_2_0= ruleConDecl ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:826:1: (lv_conDecls_2_0= ruleConDecl )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:826:1: (lv_conDecls_2_0= ruleConDecl )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:827:3: lv_conDecls_2_0= ruleConDecl
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConDecl_in_ruleConDecls1637);
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
            	    break loop17;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:851:1: entryRuleConDecl returns [EObject current=null] : iv_ruleConDecl= ruleConDecl EOF ;
    public final EObject entryRuleConDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:852:2: (iv_ruleConDecl= ruleConDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:853:2: iv_ruleConDecl= ruleConDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConDeclRule()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl1675);
            iv_ruleConDecl=ruleConDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl1685); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:860:1: ruleConDecl returns [EObject current=null] : ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleConDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ty_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:863:28: ( ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:864:1: ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:864:1: ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:864:2: ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:864:2: ( (lv_name_0_0= ruleConBind ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:865:1: (lv_name_0_0= ruleConBind )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:865:1: (lv_name_0_0= ruleConBind )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:866:3: lv_name_0_0= ruleConBind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConBind_in_ruleConDecl1731);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:882:2: (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:882:4: otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleConDecl1744); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConDeclAccess().getOfKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:886:1: ( (lv_ty_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:887:1: (lv_ty_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:887:1: (lv_ty_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:888:3: lv_ty_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleConDecl1765);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:912:1: entryRuleTy returns [EObject current=null] : iv_ruleTy= ruleTy EOF ;
    public final EObject entryRuleTy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTy = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:913:2: (iv_ruleTy= ruleTy EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:914:2: iv_ruleTy= ruleTy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyRule()); 
            }
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy1803);
            iv_ruleTy=ruleTy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTy; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy1813); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:921:1: ruleTy returns [EObject current=null] : ( ( (lv_value_0_0= ruleInt ) ) | (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:924:28: ( ( ( (lv_value_0_0= ruleInt ) ) | (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:925:1: ( ( (lv_value_0_0= ruleInt ) ) | (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:925:1: ( ( (lv_value_0_0= ruleInt ) ) | (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) )
            int alt22=4;
            switch ( input.LA(1) ) {
            case RULE_BINDIG:
            case RULE_NBINDIG:
            case 45:
            case 46:
                {
                alt22=1;
                }
                break;
            case RULE_PIPE:
                {
                alt22=2;
                }
                break;
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
                {
                alt22=3;
                }
                break;
            case 28:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:925:2: ( (lv_value_0_0= ruleInt ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:925:2: ( (lv_value_0_0= ruleInt ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:926:1: (lv_value_0_0= ruleInt )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:926:1: (lv_value_0_0= ruleInt )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:927:3: lv_value_0_0= ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInt_in_ruleTy1859);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:944:6: (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:944:6: (this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:944:7: this_PIPE_1= RULE_PIPE ( (lv_value_2_0= ruleInt ) ) this_PIPE_3= RULE_PIPE
                    {
                    this_PIPE_1=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleTy1877); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_PIPE_1, grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:948:1: ( (lv_value_2_0= ruleInt ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:949:1: (lv_value_2_0= ruleInt )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:949:1: (lv_value_2_0= ruleInt )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:950:3: lv_value_2_0= ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInt_in_ruleTy1897);
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

                    this_PIPE_3=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleTy1908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_PIPE_3, grammarAccess.getTyAccess().getPIPETerminalRuleCall_1_2()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:971:6: ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:971:6: ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:971:7: ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:971:7: ( (lv_value_4_0= ruleQid ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:972:1: (lv_value_4_0= ruleQid )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:972:1: (lv_value_4_0= ruleQid )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:973:3: lv_value_4_0= ruleQid
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQid_in_ruleTy1936);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:989:2: (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==24) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:989:4: otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']'
                            {
                            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleTy1949); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:993:1: ( (lv_tyBind_6_0= ruleTyBind ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:994:1: (lv_tyBind_6_0= ruleTyBind )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:994:1: (lv_tyBind_6_0= ruleTyBind )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:995:3: lv_tyBind_6_0= ruleTyBind
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyBind_in_ruleTy1970);
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1011:2: (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==25) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1011:4: otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) )
                            	    {
                            	    otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleTy1983); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_7, grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1015:1: ( (lv_tyBind_8_0= ruleTyBind ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1016:1: (lv_tyBind_8_0= ruleTyBind )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1016:1: (lv_tyBind_8_0= ruleTyBind )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1017:3: lv_tyBind_8_0= ruleTyBind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyBind_in_ruleTy2004);
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
                            	    break loop19;
                                }
                            } while (true);

                            otherlv_9=(Token)match(input,26,FOLLOW_26_in_ruleTy2018); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1038:6: (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1038:6: (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1038:8: otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,28,FOLLOW_28_in_ruleTy2040); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1042:1: ( (lv_elements_11_0= ruleTyElement ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1043:1: (lv_elements_11_0= ruleTyElement )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1043:1: (lv_elements_11_0= ruleTyElement )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1044:3: lv_elements_11_0= ruleTyElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2061);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1060:2: (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==25) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1060:4: otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) )
                    	    {
                    	    otherlv_12=(Token)match(input,25,FOLLOW_25_in_ruleTy2074); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_12, grammarAccess.getTyAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1064:1: ( (lv_elements_13_0= ruleTyElement ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1065:1: (lv_elements_13_0= ruleTyElement )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1065:1: (lv_elements_13_0= ruleTyElement )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1066:3: lv_elements_13_0= ruleTyElement
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2095);
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
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleTy2109); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1094:1: entryRuleTyElement returns [EObject current=null] : iv_ruleTyElement= ruleTyElement EOF ;
    public final EObject entryRuleTyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyElement = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1095:2: (iv_ruleTyElement= ruleTyElement EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1096:2: iv_ruleTyElement= ruleTyElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyElementRule()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement2146);
            iv_ruleTyElement=ruleTyElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement2156); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1103:1: ruleTyElement returns [EObject current=null] : ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) ;
    public final EObject ruleTyElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1106:28: ( ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1107:1: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1107:1: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1107:2: ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1107:2: ( (lv_name_0_0= ruleName ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1108:1: (lv_name_0_0= ruleName )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1108:1: (lv_name_0_0= ruleName )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1109:3: lv_name_0_0= ruleName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyElementAccess().getNameNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleName_in_ruleTyElement2202);
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

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleTyElement2214); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTyElementAccess().getColonKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1129:1: ( (lv_value_2_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1130:1: (lv_value_2_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1130:1: (lv_value_2_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1131:3: lv_value_2_0= ruleTy
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTy_in_ruleTyElement2235);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1155:1: entryRuleTyBind returns [EObject current=null] : iv_ruleTyBind= ruleTyBind EOF ;
    public final EObject entryRuleTyBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1156:2: (iv_ruleTyBind= ruleTyBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1157:2: iv_ruleTyBind= ruleTyBind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyBindRule()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind2271);
            iv_ruleTyBind=ruleTyBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyBind; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind2281); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1164:1: ruleTyBind returns [EObject current=null] : ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleTyBind() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1167:28: ( ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1168:1: ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1168:1: ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1168:2: ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1168:2: ( (lv_key_0_0= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:1: (lv_key_0_0= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:1: (lv_key_0_0= ruleQid )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1170:3: lv_key_0_0= ruleQid
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQid_in_ruleTyBind2327);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1186:2: (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==21) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1186:4: otherlv_1= '=' ( (lv_value_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleTyBind2340); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1190:1: ( (lv_value_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1191:1: (lv_value_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1191:1: (lv_value_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1192:3: lv_value_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTyBind2361);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1216:1: entryRuleDecodePat returns [EObject current=null] : iv_ruleDecodePat= ruleDecodePat EOF ;
    public final EObject entryRuleDecodePat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecodePat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1217:2: (iv_ruleDecodePat= ruleDecodePat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1218:2: iv_ruleDecodePat= ruleDecodePat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDecodePatRule()); 
            }
            pushFollow(FOLLOW_ruleDecodePat_in_entryRuleDecodePat2399);
            iv_ruleDecodePat=ruleDecodePat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDecodePat; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecodePat2409); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1225:1: ruleDecodePat returns [EObject current=null] : (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat ) ;
    public final EObject ruleDecodePat() throws RecognitionException {
        EObject current = null;

        EObject this_BitPat_0 = null;

        EObject this_TokPat_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1228:28: ( (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1229:1: (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1229:1: (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=RULE_LHEXCHAR && LA24_0<=RULE_SLASH)||LA24_0==RULE_BINDIG||LA24_0==RULE_NBINDIG||(LA24_0>=45 && LA24_0<=46)) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1230:5: this_BitPat_0= ruleBitPat
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDecodePatAccess().getBitPatParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBitPat_in_ruleDecodePat2456);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1240:5: this_TokPat_1= ruleTokPat
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDecodePatAccess().getTokPatParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTokPat_in_ruleDecodePat2483);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1256:1: entryRuleBitPat returns [EObject current=null] : iv_ruleBitPat= ruleBitPat EOF ;
    public final EObject entryRuleBitPat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1257:2: (iv_ruleBitPat= ruleBitPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1258:2: iv_ruleBitPat= ruleBitPat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitPatRule()); 
            }
            pushFollow(FOLLOW_ruleBitPat_in_entryRuleBitPat2518);
            iv_ruleBitPat=ruleBitPat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitPat; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPat2528); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1265:1: ruleBitPat returns [EObject current=null] : (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\'' ) ;
    public final EObject ruleBitPat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_bitpat_1_0 = null;

        AntlrDatatypeRuleToken lv_bitpat_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1268:28: ( (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\'' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1269:1: (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\'' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1269:1: (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\'' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1269:3: otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) ( (lv_bitpat_2_0= rulePrimBitPat ) )* otherlv_3= '\\''
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleBitPat2565); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBitPatAccess().getApostropheKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1273:1: ( (lv_bitpat_1_0= rulePrimBitPat ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1274:1: (lv_bitpat_1_0= rulePrimBitPat )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1274:1: (lv_bitpat_1_0= rulePrimBitPat )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1275:3: lv_bitpat_1_0= rulePrimBitPat
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_ruleBitPat2586);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1291:2: ( (lv_bitpat_2_0= rulePrimBitPat ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_PIPE && LA25_0<=RULE_SLASH)||(LA25_0>=RULE_BINDIG && LA25_0<=RULE_DOT)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1292:1: (lv_bitpat_2_0= rulePrimBitPat )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1292:1: (lv_bitpat_2_0= rulePrimBitPat )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1293:3: lv_bitpat_2_0= rulePrimBitPat
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePrimBitPat_in_ruleBitPat2607);
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
            	    break loop25;
                }
            } while (true);

            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleBitPat2620); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1321:1: entryRuleTokPat returns [EObject current=null] : iv_ruleTokPat= ruleTokPat EOF ;
    public final EObject entryRuleTokPat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1322:2: (iv_ruleTokPat= ruleTokPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1323:2: iv_ruleTokPat= ruleTokPat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTokPatRule()); 
            }
            pushFollow(FOLLOW_ruleTokPat_in_entryRuleTokPat2656);
            iv_ruleTokPat=ruleTokPat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTokPat; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTokPat2666); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1330:1: ruleTokPat returns [EObject current=null] : ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) ) ;
    public final EObject ruleTokPat() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_tokPat_0_1 = null;

        AntlrDatatypeRuleToken lv_tokPat_0_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1333:28: ( ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1334:1: ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1334:1: ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1335:1: ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1335:1: ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1336:1: (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1336:1: (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_BINDIG||LA26_0==RULE_NBINDIG||(LA26_0>=45 && LA26_0<=46)) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=RULE_LHEXCHAR && LA26_0<=RULE_SLASH)) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1337:3: lv_tokPat_0_1= ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTokPatAccess().getTokPatIntParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInt_in_ruleTokPat2713);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1352:8: lv_tokPat_0_2= ruleQid
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTokPatAccess().getTokPatQidParserRuleCall_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQid_in_ruleTokPat2732);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1378:1: entryRuleExp returns [EObject current=null] : iv_ruleExp= ruleExp EOF ;
    public final EObject entryRuleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1379:2: (iv_ruleExp= ruleExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1380:2: iv_ruleExp= ruleExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpRule()); 
            }
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp2770);
            iv_ruleExp=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp2780); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1387:1: ruleExp returns [EObject current=null] : ( ( (lv_caseExp_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) ) ) ;
    public final EObject ruleExp() throws RecognitionException {
        EObject current = null;

        EObject lv_caseExp_0_0 = null;

        AntlrDatatypeRuleToken lv_mid_1_0 = null;

        EObject lv_caseExp_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1390:28: ( ( ( (lv_caseExp_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:1: ( ( (lv_caseExp_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:1: ( ( (lv_caseExp_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33||LA27_0==35||LA27_0==38||LA27_0==42) ) {
                alt27=1;
            }
            else if ( (LA27_0==43) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:2: ( (lv_caseExp_0_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:2: ( (lv_caseExp_0_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1392:1: (lv_caseExp_0_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1392:1: (lv_caseExp_0_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1393:3: lv_caseExp_0_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getCaseExpCaseExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp2826);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1410:6: ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1410:6: ( ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1410:7: ( (lv_mid_1_0= ruleMIXID ) ) ( (lv_caseExp_2_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1410:7: ( (lv_mid_1_0= ruleMIXID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1411:1: (lv_mid_1_0= ruleMIXID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1411:1: (lv_mid_1_0= ruleMIXID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1412:3: lv_mid_1_0= ruleMIXID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getMidMIXIDParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMIXID_in_ruleExp2854);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1428:2: ( (lv_caseExp_2_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1429:1: (lv_caseExp_2_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1429:1: (lv_caseExp_2_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1430:3: lv_caseExp_2_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getCaseExpCaseExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp2875);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1454:1: entryRuleCaseExp returns [EObject current=null] : iv_ruleCaseExp= ruleCaseExp EOF ;
    public final EObject entryRuleCaseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1455:2: (iv_ruleCaseExp= ruleCaseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1456:2: iv_ruleCaseExp= ruleCaseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseExpRule()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_entryRuleCaseExp2912);
            iv_ruleCaseExp=ruleCaseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseExp2922); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1463:1: ruleCaseExp returns [EObject current=null] : (this_ClosedExp_0= ruleClosedExp | (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1466:28: ( (this_ClosedExp_0= ruleClosedExp | (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1467:1: (this_ClosedExp_0= ruleClosedExp | (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1467:1: (this_ClosedExp_0= ruleClosedExp | (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==35||LA28_0==38||LA28_0==42) ) {
                alt28=1;
            }
            else if ( (LA28_0==33) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1468:5: this_ClosedExp_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp2969);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1477:6: (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1477:6: (otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1477:8: otherlv_1= 'case' ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( (lv_cases_4_0= ruleCases ) ) otherlv_5= 'end'
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleCaseExp2987); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCaseExpAccess().getCaseKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1481:1: ( (lv_closedExp_2_0= ruleClosedExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1482:1: (lv_closedExp_2_0= ruleClosedExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1482:1: (lv_closedExp_2_0= ruleClosedExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1483:3: lv_closedExp_2_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpClosedExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp3008);
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

                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleCaseExp3020); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCaseExpAccess().getOfKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1503:1: ( (lv_cases_4_0= ruleCases ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1504:1: (lv_cases_4_0= ruleCases )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1504:1: (lv_cases_4_0= ruleCases )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1505:3: lv_cases_4_0= ruleCases
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getCasesCasesParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCases_in_ruleCaseExp3041);
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

                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleCaseExp3053); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1533:1: entryRuleClosedExp returns [EObject current=null] : iv_ruleClosedExp= ruleClosedExp EOF ;
    public final EObject entryRuleClosedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosedExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1534:2: (iv_ruleClosedExp= ruleClosedExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1535:2: iv_ruleClosedExp= ruleClosedExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosedExpRule()); 
            }
            pushFollow(FOLLOW_ruleClosedExp_in_entryRuleClosedExp3090);
            iv_ruleClosedExp=ruleClosedExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosedExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedExp3100); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1542:1: ruleClosedExp returns [EObject current=null] : (this_OrElseExp_0= ruleOrElseExp | (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1545:28: ( (this_OrElseExp_0= ruleOrElseExp | (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1546:1: (this_OrElseExp_0= ruleOrElseExp | (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1546:1: (this_OrElseExp_0= ruleOrElseExp | (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt30=1;
                }
                break;
            case 35:
                {
                alt30=2;
                }
                break;
            case 38:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1547:5: this_OrElseExp_0= ruleOrElseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClosedExpAccess().getOrElseExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrElseExp_in_ruleClosedExp3147);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1556:6: (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1556:6: (otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1556:8: otherlv_1= 'if' ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleClosedExp3165); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getClosedExpAccess().getIfKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1560:1: ( (lv_ifCaseExp_2_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1561:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1561:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1562:3: lv_ifCaseExp_2_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getIfCaseExpCaseExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3186);
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

                    otherlv_3=(Token)match(input,36,FOLLOW_36_in_ruleClosedExp3198); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getClosedExpAccess().getThenKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1582:1: ( (lv_thenCaseExp_4_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1583:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1583:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1584:3: lv_thenCaseExp_4_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getThenCaseExpCaseExpParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3219);
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

                    otherlv_5=(Token)match(input,37,FOLLOW_37_in_ruleClosedExp3231); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getClosedExpAccess().getElseKeyword_1_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1604:1: ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1605:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1605:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1606:3: lv_elseCaseExp_6_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getElseCaseExpCaseExpParserRuleCall_1_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3252);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1623:6: (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1623:6: (otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1623:8: otherlv_7= 'do' ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end'
                    {
                    otherlv_7=(Token)match(input,38,FOLLOW_38_in_ruleClosedExp3272); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getClosedExpAccess().getDoKeyword_2_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1627:1: ( (lv_doExp_8_0= ruleMonadicExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1628:1: (lv_doExp_8_0= ruleMonadicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1628:1: (lv_doExp_8_0= ruleMonadicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1629:3: lv_doExp_8_0= ruleMonadicExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3293);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1645:2: (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==19) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1645:4: otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    {
                    	    otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleClosedExp3306); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getClosedExpAccess().getSemicolonKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1649:1: ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1650:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1650:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1651:3: lv_doExp_10_0= ruleMonadicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3327);
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
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,34,FOLLOW_34_in_ruleClosedExp3341); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1679:1: entryRuleMonadicExp returns [EObject current=null] : iv_ruleMonadicExp= ruleMonadicExp EOF ;
    public final EObject entryRuleMonadicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonadicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1680:2: (iv_ruleMonadicExp= ruleMonadicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1681:2: iv_ruleMonadicExp= ruleMonadicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMonadicExpRule()); 
            }
            pushFollow(FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3378);
            iv_ruleMonadicExp=ruleMonadicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMonadicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonadicExp3388); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1688:1: ruleMonadicExp returns [EObject current=null] : ( ( (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) ;
    public final EObject ruleMonadicExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_exp_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_exp_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1691:28: ( ( ( (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1692:1: ( ( (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1692:1: ( ( (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33||LA31_0==35||LA31_0==38||(LA31_0>=42 && LA31_0<=43)) ) {
                alt31=1;
            }
            else if ( ((LA31_0>=RULE_LHEXCHAR && LA31_0<=RULE_SLASH)) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1692:2: ( (lv_exp_0_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1692:2: ( (lv_exp_0_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1693:1: (lv_exp_0_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1693:1: (lv_exp_0_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1694:3: lv_exp_0_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3434);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1711:6: ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1711:6: ( ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1711:7: ( (lv_name_1_0= ruleName ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1711:7: ( (lv_name_1_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1712:1: (lv_name_1_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1712:1: (lv_name_1_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:3: lv_name_1_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getNameNameParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleMonadicExp3462);
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

                    otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleMonadicExp3474); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getMonadicExpAccess().getLessThanSignHyphenMinusKeyword_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1733:1: ( (lv_exp_3_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1734:1: (lv_exp_3_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1734:1: (lv_exp_3_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1735:3: lv_exp_3_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3495);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1759:1: entryRuleCases returns [EObject current=null] : iv_ruleCases= ruleCases EOF ;
    public final EObject entryRuleCases() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCases = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1760:2: (iv_ruleCases= ruleCases EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1761:2: iv_ruleCases= ruleCases EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCasesRule()); 
            }
            pushFollow(FOLLOW_ruleCases_in_entryRuleCases3532);
            iv_ruleCases=ruleCases();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCases; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCases3542); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1768:1: ruleCases returns [EObject current=null] : ( ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )* ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1771:28: ( ( ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1772:1: ( ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1772:1: ( ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1772:2: ( (lv_pat_0_0= rulePat ) ) otherlv_1= ':' ( (lv_exp_2_0= ruleExp ) ) (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1772:2: ( (lv_pat_0_0= rulePat ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1773:1: (lv_pat_0_0= rulePat )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1773:1: (lv_pat_0_0= rulePat )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1774:3: lv_pat_0_0= rulePat
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCasesAccess().getPatPatParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePat_in_ruleCases3588);
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

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleCases3600); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCasesAccess().getColonKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1794:1: ( (lv_exp_2_0= ruleExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1795:1: (lv_exp_2_0= ruleExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1795:1: (lv_exp_2_0= ruleExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1796:3: lv_exp_2_0= ruleExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCasesAccess().getExpExpParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExp_in_ruleCases3621);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1812:2: (this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_PIPE) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1812:3: this_PIPE_3= RULE_PIPE ( (lv_pat_4_0= rulePat ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) )
            	    {
            	    this_PIPE_3=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleCases3633); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_PIPE_3, grammarAccess.getCasesAccess().getPIPETerminalRuleCall_3_0()); 
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1816:1: ( (lv_pat_4_0= rulePat ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1817:1: (lv_pat_4_0= rulePat )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1817:1: (lv_pat_4_0= rulePat )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1818:3: lv_pat_4_0= rulePat
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCasesAccess().getPatPatParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePat_in_ruleCases3653);
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

            	    otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleCases3665); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getCasesAccess().getColonKeyword_3_2());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1838:1: ( (lv_exp_6_0= ruleExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:1: (lv_exp_6_0= ruleExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:1: (lv_exp_6_0= ruleExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1840:3: lv_exp_6_0= ruleExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCasesAccess().getExpExpParserRuleCall_3_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExp_in_ruleCases3686);
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
            	    break loop32;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1864:1: entryRuleOrElseExp returns [EObject current=null] : iv_ruleOrElseExp= ruleOrElseExp EOF ;
    public final EObject entryRuleOrElseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrElseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1865:2: (iv_ruleOrElseExp= ruleOrElseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1866:2: iv_ruleOrElseExp= ruleOrElseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrElseExpRule()); 
            }
            pushFollow(FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3724);
            iv_ruleOrElseExp=ruleOrElseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrElseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrElseExp3734); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1873:1: ruleOrElseExp returns [EObject current=null] : (this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) ;
    public final EObject ruleOrElseExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndAlsoExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1876:28: ( (this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1877:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1877:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1878:5: this_AndAlsoExp_0= ruleAndAlsoExp ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrElseExpAccess().getAndAlsoExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3781);
            this_AndAlsoExp_0=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndAlsoExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1886:1: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==40) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1886:2: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1886:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1887:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleOrElseExp3802); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getOrElseExpAccess().getOrKeyword_1_1());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1896:1: ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1897:1: (lv_right_3_0= ruleAndAlsoExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1897:1: (lv_right_3_0= ruleAndAlsoExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1898:3: lv_right_3_0= ruleAndAlsoExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrElseExpAccess().getRightAndAlsoExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3823);
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
    // $ANTLR end "ruleOrElseExp"


    // $ANTLR start "entryRuleAndAlsoExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1922:1: entryRuleAndAlsoExp returns [EObject current=null] : iv_ruleAndAlsoExp= ruleAndAlsoExp EOF ;
    public final EObject entryRuleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndAlsoExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1923:2: (iv_ruleAndAlsoExp= ruleAndAlsoExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1924:2: iv_ruleAndAlsoExp= ruleAndAlsoExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndAlsoExpRule()); 
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp3861);
            iv_ruleAndAlsoExp=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndAlsoExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndAlsoExp3871); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1931:1: ruleAndAlsoExp returns [EObject current=null] : (this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )* ) ;
    public final EObject ruleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1934:28: ( (this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1935:1: (this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1935:1: (this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1936:5: this_RExp_0= ruleRExp ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp3918);
            this_RExp_0=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1944:1: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==41) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1944:2: () otherlv_2= 'and' ( (lv_right_3_0= ruleRExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1944:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleAndAlsoExp3939); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAndAlsoExpAccess().getAndKeyword_1_1());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1954:1: ( (lv_right_3_0= ruleRExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1955:1: (lv_right_3_0= ruleRExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1955:1: (lv_right_3_0= ruleRExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1956:3: lv_right_3_0= ruleRExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRightRExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp3960);
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
    // $ANTLR end "ruleAndAlsoExp"


    // $ANTLR start "entryRuleRExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1980:1: entryRuleRExp returns [EObject current=null] : iv_ruleRExp= ruleRExp EOF ;
    public final EObject entryRuleRExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1981:2: (iv_ruleRExp= ruleRExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1982:2: iv_ruleRExp= ruleRExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRExpRule()); 
            }
            pushFollow(FOLLOW_ruleRExp_in_entryRuleRExp3998);
            iv_ruleRExp=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRExp4008); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:1: ruleRExp returns [EObject current=null] : ( (lv_name_0_0= 'todo' ) ) ;
    public final EObject ruleRExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1992:28: ( ( (lv_name_0_0= 'todo' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1993:1: ( (lv_name_0_0= 'todo' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1993:1: ( (lv_name_0_0= 'todo' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1994:1: (lv_name_0_0= 'todo' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1994:1: (lv_name_0_0= 'todo' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1995:3: lv_name_0_0= 'todo'
            {
            lv_name_0_0=(Token)match(input,42,FOLLOW_42_in_ruleRExp4050); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getRExpAccess().getNameTodoKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRExpRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "todo");
              	    
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
    // $ANTLR end "ruleRExp"


    // $ANTLR start "entryRulePat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2016:1: entryRulePat returns [String current=null] : iv_rulePat= rulePat EOF ;
    public final String entryRulePat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2017:2: (iv_rulePat= rulePat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2018:2: iv_rulePat= rulePat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatRule()); 
            }
            pushFollow(FOLLOW_rulePat_in_entryRulePat4099);
            iv_rulePat=rulePat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePat4110); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2025:1: rulePat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '_' | this_Lit_1= ruleLit | ( ( ruleName )=>this_Name_2= ruleName ) | (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? ) ) ;
    public final AntlrDatatypeRuleToken rulePat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Lit_1 = null;

        AntlrDatatypeRuleToken this_Name_2 = null;

        AntlrDatatypeRuleToken this_ConUse_3 = null;

        AntlrDatatypeRuleToken this_Pat_4 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2028:28: ( (kw= '_' | this_Lit_1= ruleLit | ( ( ruleName )=>this_Name_2= ruleName ) | (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2029:1: (kw= '_' | this_Lit_1= ruleLit | ( ( ruleName )=>this_Name_2= ruleName ) | (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2029:1: (kw= '_' | this_Lit_1= ruleLit | ( ( ruleName )=>this_Name_2= ruleName ) | (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? ) )
            int alt36=4;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==43) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_BINDIG||LA36_0==RULE_NBINDIG||LA36_0==32||(LA36_0>=45 && LA36_0<=46)) ) {
                alt36=2;
            }
            else if ( (LA36_0==RULE_LHEXCHAR) && (synpred3_InternalGDSL())) {
                alt36=3;
            }
            else if ( (LA36_0==RULE_LNHEXCHAR) && (synpred3_InternalGDSL())) {
                alt36=3;
            }
            else if ( (LA36_0==RULE_UHEXCHAR) ) {
                int LA36_5 = input.LA(2);

                if ( (synpred3_InternalGDSL()) ) {
                    alt36=3;
                }
                else if ( (true) ) {
                    alt36=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 5, input);

                    throw nvae;
                }
            }
            else if ( (LA36_0==RULE_UNHEXCHAR) ) {
                int LA36_6 = input.LA(2);

                if ( (synpred3_InternalGDSL()) ) {
                    alt36=3;
                }
                else if ( (true) ) {
                    alt36=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 6, input);

                    throw nvae;
                }
            }
            else if ( (LA36_0==RULE_SLASH) && (synpred3_InternalGDSL())) {
                alt36=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2030:2: kw= '_'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_rulePat4148); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPatAccess().get_Keyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2037:5: this_Lit_1= ruleLit
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatAccess().getLitParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLit_in_rulePat4176);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2048:6: ( ( ruleName )=>this_Name_2= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2048:6: ( ( ruleName )=>this_Name_2= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2048:7: ( ruleName )=>this_Name_2= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatAccess().getNameParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleName_in_rulePat4215);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2060:6: (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2060:6: (this_ConUse_3= ruleConUse (this_Pat_4= rulePat )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2061:5: this_ConUse_3= ruleConUse (this_Pat_4= rulePat )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatAccess().getConUseParserRuleCall_3_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConUse_in_rulePat4250);
                    this_ConUse_3=ruleConUse();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ConUse_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2071:1: (this_Pat_4= rulePat )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( ((LA35_0>=RULE_LHEXCHAR && LA35_0<=RULE_SLASH)||LA35_0==RULE_BINDIG||LA35_0==RULE_NBINDIG||LA35_0==32||LA35_0==43||(LA35_0>=45 && LA35_0<=46)) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2072:5: this_Pat_4= rulePat
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getPatAccess().getPatParserRuleCall_3_1()); 
                                  
                            }
                            pushFollow(FOLLOW_rulePat_in_rulePat4278);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2090:1: entryRuleLit returns [String current=null] : iv_ruleLit= ruleLit EOF ;
    public final String entryRuleLit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLit = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2091:2: (iv_ruleLit= ruleLit EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2092:2: iv_ruleLit= ruleLit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLitRule()); 
            }
            pushFollow(FOLLOW_ruleLit_in_entryRuleLit4327);
            iv_ruleLit=ruleLit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLit.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLit4338); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2099:1: ruleLit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Int_0= ruleInt | (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' ) ) ;
    public final AntlrDatatypeRuleToken ruleLit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Int_0 = null;

        AntlrDatatypeRuleToken this_BITSTR_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2102:28: ( (this_Int_0= ruleInt | (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2103:1: (this_Int_0= ruleInt | (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2103:1: (this_Int_0= ruleInt | (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_BINDIG||LA38_0==RULE_NBINDIG||(LA38_0>=45 && LA38_0<=46)) ) {
                alt38=1;
            }
            else if ( (LA38_0==32) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2104:5: this_Int_0= ruleInt
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLitAccess().getIntParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInt_in_ruleLit4385);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2115:6: (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2115:6: (kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2116:2: kw= '\\'' (this_BITSTR_2= ruleBITSTR )? kw= '\\''
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleLit4410); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLitAccess().getApostropheKeyword_1_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2121:1: (this_BITSTR_2= ruleBITSTR )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==RULE_PIPE||(LA37_0>=RULE_BINDIG && LA37_0<=RULE_DOT)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2122:5: this_BITSTR_2= ruleBITSTR
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getLitAccess().getBITSTRParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBITSTR_in_ruleLit4433);
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

                    kw=(Token)match(input,32,FOLLOW_32_in_ruleLit4453); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2146:1: entryRulePrimBitPat returns [String current=null] : iv_rulePrimBitPat= rulePrimBitPat EOF ;
    public final String entryRulePrimBitPat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimBitPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2147:2: (iv_rulePrimBitPat= rulePrimBitPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2148:2: iv_rulePrimBitPat= rulePrimBitPat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimBitPatRule()); 
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat4495);
            iv_rulePrimBitPat=rulePrimBitPat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimBitPat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimBitPat4506); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2155:1: rulePrimBitPat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) ) ;
    public final AntlrDatatypeRuleToken rulePrimBitPat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BITSTR_0 = null;

        AntlrDatatypeRuleToken this_Qid_1 = null;

        AntlrDatatypeRuleToken this_BitPatOrInt_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2158:28: ( ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:1: ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:1: ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_BINDIG) && (synpred4_InternalGDSL())) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_BS) && (synpred4_InternalGDSL())) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_DOT) && (synpred4_InternalGDSL())) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_PIPE) && (synpred4_InternalGDSL())) {
                alt40=1;
            }
            else if ( ((LA40_0>=RULE_LHEXCHAR && LA40_0<=RULE_SLASH)) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:2: ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:2: ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:3: ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimBitPatAccess().getBITSTRParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBITSTR_in_rulePrimBitPat4559);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2171:6: (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2171:6: (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2172:5: this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimBitPatAccess().getQidParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleQid_in_rulePrimBitPat4594);
                    this_Qid_1=ruleQid();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Qid_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2182:1: (this_BitPatOrInt_2= ruleBitPatOrInt )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==31||LA39_0==44) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2183:5: this_BitPatOrInt_2= ruleBitPatOrInt
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getPrimBitPatAccess().getBitPatOrIntParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBitPatOrInt_in_rulePrimBitPat4622);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2201:1: entryRuleBitPatOrInt returns [String current=null] : iv_ruleBitPatOrInt= ruleBitPatOrInt EOF ;
    public final String entryRuleBitPatOrInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitPatOrInt = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2202:2: (iv_ruleBitPatOrInt= ruleBitPatOrInt EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2203:2: iv_ruleBitPatOrInt= ruleBitPatOrInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitPatOrIntRule()); 
            }
            pushFollow(FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt4671);
            iv_ruleBitPatOrInt=ruleBitPatOrInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitPatOrInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPatOrInt4682); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2210:1: ruleBitPatOrInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) ) ;
    public final AntlrDatatypeRuleToken ruleBitPatOrInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_POSINT_1 = null;

        AntlrDatatypeRuleToken this_BITSTR_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2213:28: ( ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2214:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2214:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==31) ) {
                alt41=1;
            }
            else if ( (LA41_0==44) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2214:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2214:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2215:2: kw= ':' this_POSINT_1= rulePOSINT
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleBitPatOrInt4721); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBitPatOrIntAccess().getColonKeyword_0_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBitPatOrIntAccess().getPOSINTParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleBitPatOrInt4743);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2232:6: (kw= '@' this_BITSTR_3= ruleBITSTR )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2232:6: (kw= '@' this_BITSTR_3= ruleBITSTR )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2233:2: kw= '@' this_BITSTR_3= ruleBITSTR
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleBitPatOrInt4769); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBitPatOrIntAccess().getCommercialAtKeyword_1_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBitPatOrIntAccess().getBITSTRParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBITSTR_in_ruleBitPatOrInt4791);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2257:1: entryRuleInt returns [String current=null] : iv_ruleInt= ruleInt EOF ;
    public final String entryRuleInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInt = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2258:2: (iv_ruleInt= ruleInt EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2259:2: iv_ruleInt= ruleInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntRule()); 
            }
            pushFollow(FOLLOW_ruleInt_in_entryRuleInt4838);
            iv_ruleInt=ruleInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInt4849); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2266:1: ruleInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT ) ;
    public final AntlrDatatypeRuleToken ruleInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_POSINT_0 = null;

        AntlrDatatypeRuleToken this_NEGINT_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2269:28: ( (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2270:1: (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2270:1: (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_BINDIG||LA42_0==RULE_NBINDIG||LA42_0==46) ) {
                alt42=1;
            }
            else if ( (LA42_0==45) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2271:5: this_POSINT_0= rulePOSINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIntAccess().getPOSINTParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleInt4896);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2283:5: this_NEGINT_1= ruleNEGINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIntAccess().getNEGINTParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNEGINT_in_ruleInt4929);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2301:1: entryRuleName returns [String current=null] : iv_ruleName= ruleName EOF ;
    public final String entryRuleName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleName = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2302:2: (iv_ruleName= ruleName EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2303:2: iv_ruleName= ruleName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameRule()); 
            }
            pushFollow(FOLLOW_ruleName_in_entryRuleName4975);
            iv_ruleName=ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleName4986); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2310:1: ruleName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2313:28: (this_ID_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2315:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNameAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleID_in_ruleName5032);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2333:1: entryRuleConBind returns [String current=null] : iv_ruleConBind= ruleConBind EOF ;
    public final String entryRuleConBind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2334:2: (iv_ruleConBind= ruleConBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2335:2: iv_ruleConBind= ruleConBind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConBindRule()); 
            }
            pushFollow(FOLLOW_ruleConBind_in_entryRuleConBind5077);
            iv_ruleConBind=ruleConBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConBind.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConBind5088); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2342:1: ruleConBind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CONS_0= ruleCONS ;
    public final AntlrDatatypeRuleToken ruleConBind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_CONS_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2345:28: (this_CONS_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2347:5: this_CONS_0= ruleCONS
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConBindAccess().getCONSParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConBind5134);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2365:1: entryRuleConUse returns [String current=null] : iv_ruleConUse= ruleConUse EOF ;
    public final String entryRuleConUse() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConUse = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2366:2: (iv_ruleConUse= ruleConUse EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2367:2: iv_ruleConUse= ruleConUse EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConUseRule()); 
            }
            pushFollow(FOLLOW_ruleConUse_in_entryRuleConUse5179);
            iv_ruleConUse=ruleConUse();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConUse.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConUse5190); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2374:1: ruleConUse returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CONS_0= ruleCONS ;
    public final AntlrDatatypeRuleToken ruleConUse() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_CONS_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2377:28: (this_CONS_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2379:5: this_CONS_0= ruleCONS
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConUseAccess().getCONSParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConUse5236);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2397:1: entryRuleQid returns [String current=null] : iv_ruleQid= ruleQid EOF ;
    public final String entryRuleQid() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQid = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2398:2: (iv_ruleQid= ruleQid EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2399:2: iv_ruleQid= ruleQid EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQidRule()); 
            }
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid5281);
            iv_ruleQid=ruleQid();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQid.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid5292); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2406:1: ruleQid returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleQid() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2409:28: (this_ID_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2411:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQidAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleID_in_ruleQid5338);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2429:1: entryRulePOSINT returns [String current=null] : iv_rulePOSINT= rulePOSINT EOF ;
    public final String entryRulePOSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePOSINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2430:2: (iv_rulePOSINT= rulePOSINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2431:2: iv_rulePOSINT= rulePOSINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPOSINTRule()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT5383);
            iv_rulePOSINT=rulePOSINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePOSINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT5394); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2438:1: rulePOSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM ) ;
    public final AntlrDatatypeRuleToken rulePOSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_NUM_0 = null;

        AntlrDatatypeRuleToken this_HEXNUM_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2441:28: ( (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2442:1: (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2442:1: (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_BINDIG||LA43_0==RULE_NBINDIG) ) {
                alt43=1;
            }
            else if ( (LA43_0==46) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2443:5: this_NUM_0= ruleNUM
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPOSINTAccess().getNUMParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNUM_in_rulePOSINT5441);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2455:5: this_HEXNUM_1= ruleHEXNUM
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPOSINTAccess().getHEXNUMParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleHEXNUM_in_rulePOSINT5474);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2473:1: entryRuleNEGINT returns [String current=null] : iv_ruleNEGINT= ruleNEGINT EOF ;
    public final String entryRuleNEGINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNEGINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2474:2: (iv_ruleNEGINT= ruleNEGINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2475:2: iv_ruleNEGINT= ruleNEGINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNEGINTRule()); 
            }
            pushFollow(FOLLOW_ruleNEGINT_in_entryRuleNEGINT5520);
            iv_ruleNEGINT=ruleNEGINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNEGINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNEGINT5531); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2482:1: ruleNEGINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '~' this_NUM_1= ruleNUM ) ;
    public final AntlrDatatypeRuleToken ruleNEGINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_NUM_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2485:28: ( (kw= '~' this_NUM_1= ruleNUM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2486:1: (kw= '~' this_NUM_1= ruleNUM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2486:1: (kw= '~' this_NUM_1= ruleNUM )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2487:2: kw= '~' this_NUM_1= ruleNUM
            {
            kw=(Token)match(input,45,FOLLOW_45_in_ruleNEGINT5569); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getNEGINTAccess().getTildeKeyword_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNEGINTAccess().getNUMParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleNUM_in_ruleNEGINT5591);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2511:1: entryRuleNUM returns [String current=null] : iv_ruleNUM= ruleNUM EOF ;
    public final String entryRuleNUM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2512:2: (iv_ruleNUM= ruleNUM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2513:2: iv_ruleNUM= ruleNUM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMRule()); 
            }
            pushFollow(FOLLOW_ruleNUM_in_entryRuleNUM5637);
            iv_ruleNUM=ruleNUM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUM5648); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2520:1: ruleNUM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( ruleDIG )=>this_DIG_0= ruleDIG )+ ;
    public final AntlrDatatypeRuleToken ruleNUM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DIG_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2523:28: ( ( ( ruleDIG )=>this_DIG_0= ruleDIG )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2524:1: ( ( ruleDIG )=>this_DIG_0= ruleDIG )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2524:1: ( ( ruleDIG )=>this_DIG_0= ruleDIG )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_BINDIG) ) {
                    int LA44_1 = input.LA(2);

                    if ( (synpred5_InternalGDSL()) ) {
                        alt44=1;
                    }


                }
                else if ( (LA44_0==RULE_NBINDIG) ) {
                    int LA44_3 = input.LA(2);

                    if ( (synpred5_InternalGDSL()) ) {
                        alt44=1;
                    }


                }


                switch (alt44) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2524:2: ( ruleDIG )=>this_DIG_0= ruleDIG
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleDIG_in_ruleNUM5700);
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
            	    if ( cnt44 >= 1 ) break loop44;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2543:1: entryRuleHEXNUM returns [String current=null] : iv_ruleHEXNUM= ruleHEXNUM EOF ;
    public final String entryRuleHEXNUM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXNUM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2544:2: (iv_ruleHEXNUM= ruleHEXNUM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2545:2: iv_ruleHEXNUM= ruleHEXNUM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHEXNUMRule()); 
            }
            pushFollow(FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM5747);
            iv_ruleHEXNUM=ruleHEXNUM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXNUM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXNUM5758); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2552:1: ruleHEXNUM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ ) ;
    public final AntlrDatatypeRuleToken ruleHEXNUM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_HEXDIGIT_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2555:28: ( (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2556:1: (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2556:1: (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2557:2: kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+
            {
            kw=(Token)match(input,46,FOLLOW_46_in_ruleHEXNUM5796); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getHEXNUMAccess().getXKeyword_0()); 
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2562:1: ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                switch ( input.LA(1) ) {
                case RULE_BINDIG:
                    {
                    int LA45_1 = input.LA(2);

                    if ( (synpred6_InternalGDSL()) ) {
                        alt45=1;
                    }


                    }
                    break;
                case RULE_LHEXCHAR:
                    {
                    int LA45_3 = input.LA(2);

                    if ( (synpred6_InternalGDSL()) ) {
                        alt45=1;
                    }


                    }
                    break;
                case RULE_UHEXCHAR:
                    {
                    int LA45_4 = input.LA(2);

                    if ( (synpred6_InternalGDSL()) ) {
                        alt45=1;
                    }


                    }
                    break;
                case RULE_NBINDIG:
                    {
                    int LA45_5 = input.LA(2);

                    if ( (synpred6_InternalGDSL()) ) {
                        alt45=1;
                    }


                    }
                    break;

                }

                switch (alt45) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2562:2: ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleHEXDIGIT_in_ruleHEXNUM5824);
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
            	    if ( cnt45 >= 1 ) break loop45;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2583:1: entryRuleBITSTR returns [String current=null] : iv_ruleBITSTR= ruleBITSTR EOF ;
    public final String entryRuleBITSTR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITSTR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2584:2: (iv_ruleBITSTR= ruleBITSTR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2585:2: iv_ruleBITSTR= ruleBITSTR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITSTRRule()); 
            }
            pushFollow(FOLLOW_ruleBITSTR_in_entryRuleBITSTR5874);
            iv_ruleBITSTR=ruleBITSTR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITSTR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITSTR5885); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2592:1: ruleBITSTR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+ ;
    public final AntlrDatatypeRuleToken ruleBITSTR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BINARY_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2595:28: ( ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2596:1: ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2596:1: ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                switch ( input.LA(1) ) {
                case RULE_BINDIG:
                    {
                    int LA46_2 = input.LA(2);

                    if ( (synpred7_InternalGDSL()) ) {
                        alt46=1;
                    }


                    }
                    break;
                case RULE_BS:
                    {
                    int LA46_3 = input.LA(2);

                    if ( (synpred7_InternalGDSL()) ) {
                        alt46=1;
                    }


                    }
                    break;
                case RULE_DOT:
                    {
                    int LA46_4 = input.LA(2);

                    if ( (synpred7_InternalGDSL()) ) {
                        alt46=1;
                    }


                    }
                    break;
                case RULE_PIPE:
                    {
                    int LA46_5 = input.LA(2);

                    if ( (synpred7_InternalGDSL()) ) {
                        alt46=1;
                    }


                    }
                    break;

                }

                switch (alt46) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2596:2: ( ruleBINARY )=>this_BINARY_0= ruleBINARY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleBINARY_in_ruleBITSTR5937);
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
            	    if ( cnt46 >= 1 ) break loop46;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2615:1: entryRuleMIXID returns [String current=null] : iv_ruleMIXID= ruleMIXID EOF ;
    public final String entryRuleMIXID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMIXID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2616:2: (iv_ruleMIXID= ruleMIXID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2617:2: iv_ruleMIXID= ruleMIXID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMIXIDRule()); 
            }
            pushFollow(FOLLOW_ruleMIXID_in_entryRuleMIXID5984);
            iv_ruleMIXID=ruleMIXID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMIXID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMIXID5995); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2624:1: ruleMIXID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '_' (this_IDCHAR_1= ruleIDCHAR )+ ) ;
    public final AntlrDatatypeRuleToken ruleMIXID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_IDCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2627:28: ( (kw= '_' (this_IDCHAR_1= ruleIDCHAR )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2628:1: (kw= '_' (this_IDCHAR_1= ruleIDCHAR )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2628:1: (kw= '_' (this_IDCHAR_1= ruleIDCHAR )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2629:2: kw= '_' (this_IDCHAR_1= ruleIDCHAR )+
            {
            kw=(Token)match(input,43,FOLLOW_43_in_ruleMIXID6033); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getMIXIDAccess().get_Keyword_0()); 
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2634:1: (this_IDCHAR_1= ruleIDCHAR )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_LHEXCHAR && LA47_0<=RULE_BINDIG)||LA47_0==RULE_NBINDIG) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2635:5: this_IDCHAR_1= ruleIDCHAR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getMIXIDAccess().getIDCHARParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleIDCHAR_in_ruleMIXID6056);
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
            	    if ( cnt47 >= 1 ) break loop47;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2653:1: entryRuleCONS returns [String current=null] : iv_ruleCONS= ruleCONS EOF ;
    public final String entryRuleCONS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCONS = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2654:2: (iv_ruleCONS= ruleCONS EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2655:2: iv_ruleCONS= ruleCONS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCONSRule()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS6104);
            iv_ruleCONS=ruleCONS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCONS.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS6115); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2662:1: ruleCONS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) ;
    public final AntlrDatatypeRuleToken ruleCONS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ULETTER_0 = null;

        AntlrDatatypeRuleToken this_IDCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2665:28: ( (this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2666:1: (this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2666:1: (this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2667:5: this_ULETTER_0= ruleULETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCONSAccess().getULETTERParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleULETTER_in_ruleCONS6162);
            this_ULETTER_0=ruleULETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ULETTER_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2677:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            loop48:
            do {
                int alt48=2;
                alt48 = dfa48.predict(input);
                switch (alt48) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2677:2: ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getCONSAccess().getIDCHARParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleIDCHAR_in_ruleCONS6195);
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
            	    break loop48;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2696:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2697:2: (iv_ruleID= ruleID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2698:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FOLLOW_ruleID_in_entryRuleID6243);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleID6254); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2705:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_LETTER_0 = null;

        AntlrDatatypeRuleToken this_IDCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2708:28: ( (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2709:1: (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2709:1: (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2710:5: this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIDAccess().getLETTERParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLETTER_in_ruleID6301);
            this_LETTER_0=ruleLETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_LETTER_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2720:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            loop49:
            do {
                int alt49=2;
                alt49 = dfa49.predict(input);
                switch (alt49) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2720:2: ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getIDAccess().getIDCHARParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleIDCHAR_in_ruleID6334);
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
            	    break loop49;
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


    // $ANTLR start "entryRuleHEXDIGIT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2739:1: entryRuleHEXDIGIT returns [String current=null] : iv_ruleHEXDIGIT= ruleHEXDIGIT EOF ;
    public final String entryRuleHEXDIGIT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXDIGIT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2740:2: (iv_ruleHEXDIGIT= ruleHEXDIGIT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2741:2: iv_ruleHEXDIGIT= ruleHEXDIGIT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHEXDIGITRule()); 
            }
            pushFollow(FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT6382);
            iv_ruleHEXDIGIT=ruleHEXDIGIT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXDIGIT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXDIGIT6393); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2748:1: ruleHEXDIGIT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR ) ;
    public final AntlrDatatypeRuleToken ruleHEXDIGIT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DIG_0 = null;

        AntlrDatatypeRuleToken this_HEXCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2751:28: ( (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2752:1: (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2752:1: (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_BINDIG||LA50_0==RULE_NBINDIG) ) {
                alt50=1;
            }
            else if ( ((LA50_0>=RULE_LHEXCHAR && LA50_0<=RULE_UHEXCHAR)) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2753:5: this_DIG_0= ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getHEXDIGITAccess().getDIGParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDIG_in_ruleHEXDIGIT6440);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2765:5: this_HEXCHAR_1= ruleHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getHEXDIGITAccess().getHEXCHARParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleHEXCHAR_in_ruleHEXDIGIT6473);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2783:1: entryRuleHEXCHAR returns [String current=null] : iv_ruleHEXCHAR= ruleHEXCHAR EOF ;
    public final String entryRuleHEXCHAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXCHAR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2784:2: (iv_ruleHEXCHAR= ruleHEXCHAR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2785:2: iv_ruleHEXCHAR= ruleHEXCHAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHEXCHARRule()); 
            }
            pushFollow(FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR6519);
            iv_ruleHEXCHAR=ruleHEXCHAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXCHAR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXCHAR6530); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2792:1: ruleHEXCHAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR ) ;
    public final AntlrDatatypeRuleToken ruleHEXCHAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LHEXCHAR_0=null;
        Token this_UHEXCHAR_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2795:28: ( (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2796:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2796:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_LHEXCHAR) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_UHEXCHAR) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2796:6: this_LHEXCHAR_0= RULE_LHEXCHAR
                    {
                    this_LHEXCHAR_0=(Token)match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_ruleHEXCHAR6570); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LHEXCHAR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LHEXCHAR_0, grammarAccess.getHEXCHARAccess().getLHEXCHARTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2804:10: this_UHEXCHAR_1= RULE_UHEXCHAR
                    {
                    this_UHEXCHAR_1=(Token)match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_ruleHEXCHAR6596); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2819:1: entryRuleULETTER returns [String current=null] : iv_ruleULETTER= ruleULETTER EOF ;
    public final String entryRuleULETTER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleULETTER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2820:2: (iv_ruleULETTER= ruleULETTER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2821:2: iv_ruleULETTER= ruleULETTER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getULETTERRule()); 
            }
            pushFollow(FOLLOW_ruleULETTER_in_entryRuleULETTER6642);
            iv_ruleULETTER=ruleULETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleULETTER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleULETTER6653); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2828:1: ruleULETTER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR ) ;
    public final AntlrDatatypeRuleToken ruleULETTER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_UHEXCHAR_0=null;
        Token this_UNHEXCHAR_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2831:28: ( (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2832:1: (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2832:1: (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_UHEXCHAR) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_UNHEXCHAR) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2832:6: this_UHEXCHAR_0= RULE_UHEXCHAR
                    {
                    this_UHEXCHAR_0=(Token)match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_ruleULETTER6693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UHEXCHAR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_UHEXCHAR_0, grammarAccess.getULETTERAccess().getUHEXCHARTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2840:10: this_UNHEXCHAR_1= RULE_UNHEXCHAR
                    {
                    this_UNHEXCHAR_1=(Token)match(input,RULE_UNHEXCHAR,FOLLOW_RULE_UNHEXCHAR_in_ruleULETTER6719); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2855:1: entryRuleLETTER returns [String current=null] : iv_ruleLETTER= ruleLETTER EOF ;
    public final String entryRuleLETTER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLETTER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2856:2: (iv_ruleLETTER= ruleLETTER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2857:2: iv_ruleLETTER= ruleLETTER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLETTERRule()); 
            }
            pushFollow(FOLLOW_ruleLETTER_in_entryRuleLETTER6765);
            iv_ruleLETTER=ruleLETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLETTER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLETTER6776); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2864:1: ruleLETTER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH ) ;
    public final AntlrDatatypeRuleToken ruleLETTER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LHEXCHAR_0=null;
        Token this_LNHEXCHAR_1=null;
        Token this_SLASH_3=null;
        AntlrDatatypeRuleToken this_ULETTER_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2867:28: ( (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2868:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2868:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH )
            int alt53=4;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
                {
                alt53=1;
                }
                break;
            case RULE_LNHEXCHAR:
                {
                alt53=2;
                }
                break;
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
                {
                alt53=3;
                }
                break;
            case RULE_SLASH:
                {
                alt53=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2868:6: this_LHEXCHAR_0= RULE_LHEXCHAR
                    {
                    this_LHEXCHAR_0=(Token)match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_ruleLETTER6816); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LHEXCHAR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LHEXCHAR_0, grammarAccess.getLETTERAccess().getLHEXCHARTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2876:10: this_LNHEXCHAR_1= RULE_LNHEXCHAR
                    {
                    this_LNHEXCHAR_1=(Token)match(input,RULE_LNHEXCHAR,FOLLOW_RULE_LNHEXCHAR_in_ruleLETTER6842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LNHEXCHAR_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LNHEXCHAR_1, grammarAccess.getLETTERAccess().getLNHEXCHARTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2885:5: this_ULETTER_2= ruleULETTER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLETTERAccess().getULETTERParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleULETTER_in_ruleLETTER6875);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2896:10: this_SLASH_3= RULE_SLASH
                    {
                    this_SLASH_3=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleLETTER6901); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2911:1: entryRuleIDCHAR returns [String current=null] : iv_ruleIDCHAR= ruleIDCHAR EOF ;
    public final String entryRuleIDCHAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDCHAR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2912:2: (iv_ruleIDCHAR= ruleIDCHAR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2913:2: iv_ruleIDCHAR= ruleIDCHAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDCHARRule()); 
            }
            pushFollow(FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR6947);
            iv_ruleIDCHAR=ruleIDCHAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIDCHAR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDCHAR6958); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2920:1: ruleIDCHAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM ) ;
    public final AntlrDatatypeRuleToken ruleIDCHAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CHARSYM_2=null;
        AntlrDatatypeRuleToken this_LETTER_0 = null;

        AntlrDatatypeRuleToken this_DIG_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2923:28: ( (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2924:1: (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2924:1: (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM )
            int alt54=3;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
                {
                alt54=1;
                }
                break;
            case RULE_BINDIG:
            case RULE_NBINDIG:
                {
                alt54=2;
                }
                break;
            case RULE_CHARSYM:
                {
                alt54=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2925:5: this_LETTER_0= ruleLETTER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIDCHARAccess().getLETTERParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLETTER_in_ruleIDCHAR7005);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2937:5: this_DIG_1= ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIDCHARAccess().getDIGParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDIG_in_ruleIDCHAR7038);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2948:10: this_CHARSYM_2= RULE_CHARSYM
                    {
                    this_CHARSYM_2=(Token)match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_ruleIDCHAR7064); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2963:1: entryRuleBINARY returns [String current=null] : iv_ruleBINARY= ruleBINARY EOF ;
    public final String entryRuleBINARY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBINARY = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2964:2: (iv_ruleBINARY= ruleBINARY EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2965:2: iv_ruleBINARY= ruleBINARY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBINARYRule()); 
            }
            pushFollow(FOLLOW_ruleBINARY_in_entryRuleBINARY7110);
            iv_ruleBINARY=ruleBINARY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBINARY.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBINARY7121); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2972:1: ruleBINARY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE ) ;
    public final AntlrDatatypeRuleToken ruleBINARY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINDIG_0=null;
        Token this_BS_1=null;
        Token this_DOT_2=null;
        Token this_PIPE_3=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2975:28: ( (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2976:1: (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2976:1: (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE )
            int alt55=4;
            switch ( input.LA(1) ) {
            case RULE_BINDIG:
                {
                alt55=1;
                }
                break;
            case RULE_BS:
                {
                alt55=2;
                }
                break;
            case RULE_DOT:
                {
                alt55=3;
                }
                break;
            case RULE_PIPE:
                {
                alt55=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2976:6: this_BINDIG_0= RULE_BINDIG
                    {
                    this_BINDIG_0=(Token)match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_ruleBINARY7161); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINDIG_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINDIG_0, grammarAccess.getBINARYAccess().getBINDIGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2984:10: this_BS_1= RULE_BS
                    {
                    this_BS_1=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleBINARY7187); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_1, grammarAccess.getBINARYAccess().getBSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2992:10: this_DOT_2= RULE_DOT
                    {
                    this_DOT_2=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleBINARY7213); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_2, grammarAccess.getBINARYAccess().getDOTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3000:10: this_PIPE_3= RULE_PIPE
                    {
                    this_PIPE_3=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleBINARY7239); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3015:1: entryRuleDIG returns [String current=null] : iv_ruleDIG= ruleDIG EOF ;
    public final String entryRuleDIG() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDIG = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3016:2: (iv_ruleDIG= ruleDIG EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3017:2: iv_ruleDIG= ruleDIG EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDIGRule()); 
            }
            pushFollow(FOLLOW_ruleDIG_in_entryRuleDIG7285);
            iv_ruleDIG=ruleDIG();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDIG.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDIG7296); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3024:1: ruleDIG returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG ) ;
    public final AntlrDatatypeRuleToken ruleDIG() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINDIG_0=null;
        Token this_NBINDIG_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3027:28: ( (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3028:1: (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3028:1: (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_BINDIG) ) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_NBINDIG) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3028:6: this_BINDIG_0= RULE_BINDIG
                    {
                    this_BINDIG_0=(Token)match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_ruleDIG7336); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINDIG_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINDIG_0, grammarAccess.getDIGAccess().getBINDIGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3036:10: this_NBINDIG_1= RULE_NBINDIG
                    {
                    this_NBINDIG_1=(Token)match(input,RULE_NBINDIG,FOLLOW_RULE_NBINDIG_in_ruleDIG7362); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3051:1: entryRuleSYM returns [String current=null] : iv_ruleSYM= ruleSYM EOF ;
    public final String entryRuleSYM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSYM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3052:2: (iv_ruleSYM= ruleSYM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3053:2: iv_ruleSYM= ruleSYM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSYMRule()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_entryRuleSYM7408);
            iv_ruleSYM=ruleSYM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSYM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSYM7419); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3060:1: ruleSYM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM ) ;
    public final AntlrDatatypeRuleToken ruleSYM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BS_0=null;
        Token this_SLASH_1=null;
        Token this_DOT_2=null;
        Token this_CHARSYM_3=null;
        Token this_OTHERSYM_4=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3063:28: ( (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3064:1: (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3064:1: (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM )
            int alt57=5;
            switch ( input.LA(1) ) {
            case RULE_BS:
                {
                alt57=1;
                }
                break;
            case RULE_SLASH:
                {
                alt57=2;
                }
                break;
            case RULE_DOT:
                {
                alt57=3;
                }
                break;
            case RULE_CHARSYM:
                {
                alt57=4;
                }
                break;
            case RULE_OTHERSYM:
                {
                alt57=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3064:6: this_BS_0= RULE_BS
                    {
                    this_BS_0=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleSYM7459); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_0, grammarAccess.getSYMAccess().getBSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3072:10: this_SLASH_1= RULE_SLASH
                    {
                    this_SLASH_1=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleSYM7485); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SLASH_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SLASH_1, grammarAccess.getSYMAccess().getSLASHTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3080:10: this_DOT_2= RULE_DOT
                    {
                    this_DOT_2=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSYM7511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_2, grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3088:10: this_CHARSYM_3= RULE_CHARSYM
                    {
                    this_CHARSYM_3=(Token)match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_ruleSYM7537); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CHARSYM_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_CHARSYM_3, grammarAccess.getSYMAccess().getCHARSYMTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3096:10: this_OTHERSYM_4= RULE_OTHERSYM
                    {
                    this_OTHERSYM_4=(Token)match(input,RULE_OTHERSYM,FOLLOW_RULE_OTHERSYM_in_ruleSYM7563); if (state.failed) return current;
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
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2048:7: ( ruleName )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2048:9: ruleName
        {
        pushFollow(FOLLOW_ruleName_in_synpred3_InternalGDSL4199);
        ruleName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalGDSL

    // $ANTLR start synpred4_InternalGDSL
    public final void synpred4_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:3: ( ruleBITSTR )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:5: ruleBITSTR
        {
        pushFollow(FOLLOW_ruleBITSTR_in_synpred4_InternalGDSL4543);
        ruleBITSTR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalGDSL

    // $ANTLR start synpred5_InternalGDSL
    public final void synpred5_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2524:2: ( ruleDIG )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2524:4: ruleDIG
        {
        pushFollow(FOLLOW_ruleDIG_in_synpred5_InternalGDSL5684);
        ruleDIG();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalGDSL

    // $ANTLR start synpred6_InternalGDSL
    public final void synpred6_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2562:2: ( ruleHEXDIGIT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2562:4: ruleHEXDIGIT
        {
        pushFollow(FOLLOW_ruleHEXDIGIT_in_synpred6_InternalGDSL5808);
        ruleHEXDIGIT();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalGDSL

    // $ANTLR start synpred7_InternalGDSL
    public final void synpred7_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2596:2: ( ruleBINARY )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2596:4: ruleBINARY
        {
        pushFollow(FOLLOW_ruleBINARY_in_synpred7_InternalGDSL5921);
        ruleBINARY();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalGDSL

    // $ANTLR start synpred8_InternalGDSL
    public final void synpred8_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2677:2: ( ruleIDCHAR )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2677:4: ruleIDCHAR
        {
        pushFollow(FOLLOW_ruleIDCHAR_in_synpred8_InternalGDSL6179);
        ruleIDCHAR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalGDSL

    // $ANTLR start synpred9_InternalGDSL
    public final void synpred9_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2720:2: ( ruleIDCHAR )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2720:4: ruleIDCHAR
        {
        pushFollow(FOLLOW_ruleIDCHAR_in_synpred9_InternalGDSL6318);
        ruleIDCHAR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalGDSL

    // Delegated rules

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


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA49 dfa49 = new DFA49(this);
    static final String DFA14_eotS =
        "\31\uffff";
    static final String DFA14_eofS =
        "\31\uffff";
    static final String DFA14_minS =
        "\1\33\6\5\1\uffff\10\5\1\uffff\10\5";
    static final String DFA14_maxS =
        "\1\33\1\17\5\30\1\uffff\10\30\1\uffff\10\30";
    static final String DFA14_acceptS =
        "\7\uffff\1\1\10\uffff\1\2\10\uffff";
    static final String DFA14_specialS =
        "\31\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1",
            "\1\2\1\4\1\5\1\3\1\6\1\7\1\uffff\2\7\1\uffff\1\7",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\2\uffff\1\16\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\2\uffff\1\16\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\2\uffff\1\16\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\2\uffff\1\16\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\2\uffff\1\16\6\uffff\1"+
            "\7\2\uffff\1\20",
            "",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\2\uffff\1\16\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\2\uffff\1\16\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\10\1\12\1\13\1\11\1\14\1\17\1\15\2\uffff\1\16\6\uffff\1"+
            "\7\2\uffff\1\20",
            "",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20",
            "\1\21\1\23\1\24\1\22\1\25\1\30\1\26\2\uffff\1\27\6\uffff\1"+
            "\7\2\uffff\1\20"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "476:1: ( (otherlv_0= 'val' ( ( (lv_name_1_0= ruleName ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleName ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) | (otherlv_6= 'val' ( (lv_name_7_0= ruleName ) ) otherlv_8= '[' ( ( (lv_decPat_9_0= ruleDecodePat ) ) ( (lv_decPat_10_0= ruleDecodePat ) )* )? otherlv_11= ']' ( (otherlv_12= '=' ( (lv_exp_13_0= ruleExp ) ) ) | (this_PIPE_14= RULE_PIPE ( (lv_exps_15_0= ruleExp ) ) otherlv_16= '=' ( (lv_exps_17_0= ruleExp ) ) )+ ) ) )";
        }
    }
    static final String DFA48_eotS =
        "\12\uffff";
    static final String DFA48_eofS =
        "\1\1\11\uffff";
    static final String DFA48_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA48_maxS =
        "\1\56\1\uffff\7\0\1\uffff";
    static final String DFA48_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA48_specialS =
        "\1\1\1\uffff\1\3\1\7\1\6\1\0\1\4\1\5\1\2\1\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\1\1\4\1\6\1\7\1\5\1\10\1\11\1\2\2\uffff\1\3\4\uffff\2\1\1"+
            "\uffff\2\1\3\uffff\1\1\2\uffff\3\1\12\uffff\1\1\1\uffff\2\1",
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

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "()* loopback of 2677:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_5 = input.LA(1);

                         
                        int index48_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index48_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA48_0 = input.LA(1);

                         
                        int index48_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA48_0==EOF||LA48_0==RULE_PIPE||(LA48_0>=19 && LA48_0<=20)||(LA48_0>=22 && LA48_0<=23)||LA48_0==27||(LA48_0>=30 && LA48_0<=32)||LA48_0==43||(LA48_0>=45 && LA48_0<=46)) ) {s = 1;}

                        else if ( (LA48_0==RULE_BINDIG) ) {s = 2;}

                        else if ( (LA48_0==RULE_NBINDIG) ) {s = 3;}

                        else if ( (LA48_0==RULE_LHEXCHAR) ) {s = 4;}

                        else if ( (LA48_0==RULE_LNHEXCHAR) ) {s = 5;}

                        else if ( (LA48_0==RULE_UHEXCHAR) ) {s = 6;}

                        else if ( (LA48_0==RULE_UNHEXCHAR) ) {s = 7;}

                        else if ( (LA48_0==RULE_SLASH) ) {s = 8;}

                        else if ( (LA48_0==RULE_CHARSYM) && (synpred8_InternalGDSL())) {s = 9;}

                         
                        input.seek(index48_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA48_8 = input.LA(1);

                         
                        int index48_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index48_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA48_2 = input.LA(1);

                         
                        int index48_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index48_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA48_6 = input.LA(1);

                         
                        int index48_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index48_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA48_7 = input.LA(1);

                         
                        int index48_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index48_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA48_4 = input.LA(1);

                         
                        int index48_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index48_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA48_3 = input.LA(1);

                         
                        int index48_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index48_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 48, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA49_eotS =
        "\12\uffff";
    static final String DFA49_eofS =
        "\1\1\11\uffff";
    static final String DFA49_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA49_maxS =
        "\1\56\1\uffff\7\0\1\uffff";
    static final String DFA49_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA49_specialS =
        "\1\7\1\uffff\1\1\1\5\1\2\1\6\1\3\1\4\1\0\1\uffff}>";
    static final String[] DFA49_transitionS = {
            "\1\1\1\4\1\6\1\7\1\5\1\10\1\11\1\2\2\1\1\3\4\uffff\13\1\1\uffff"+
            "\2\1\6\uffff\1\1\4\uffff\3\1",
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

    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;

    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "()* loopback of 2720:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA49_8 = input.LA(1);

                         
                        int index49_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index49_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA49_2 = input.LA(1);

                         
                        int index49_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index49_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA49_4 = input.LA(1);

                         
                        int index49_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index49_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA49_6 = input.LA(1);

                         
                        int index49_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index49_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA49_7 = input.LA(1);

                         
                        int index49_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index49_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA49_3 = input.LA(1);

                         
                        int index49_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index49_3);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA49_5 = input.LA(1);

                         
                        int index49_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index49_5);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA49_0 = input.LA(1);

                         
                        int index49_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA49_0==EOF||LA49_0==RULE_PIPE||(LA49_0>=RULE_BS && LA49_0<=RULE_DOT)||(LA49_0>=19 && LA49_0<=29)||(LA49_0>=31 && LA49_0<=32)||LA49_0==39||(LA49_0>=44 && LA49_0<=46)) ) {s = 1;}

                        else if ( (LA49_0==RULE_BINDIG) ) {s = 2;}

                        else if ( (LA49_0==RULE_NBINDIG) ) {s = 3;}

                        else if ( (LA49_0==RULE_LHEXCHAR) ) {s = 4;}

                        else if ( (LA49_0==RULE_LNHEXCHAR) ) {s = 5;}

                        else if ( (LA49_0==RULE_UHEXCHAR) ) {s = 6;}

                        else if ( (LA49_0==RULE_UNHEXCHAR) ) {s = 7;}

                        else if ( (LA49_0==RULE_SLASH) ) {s = 8;}

                        else if ( (LA49_0==RULE_CHARSYM) && (synpred9_InternalGDSL())) {s = 9;}

                         
                        input.seek(index49_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 49, _s, input);
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
    public static final BitSet FOLLOW_21_in_ruleDeclGranularity457 = new BitSet(new long[]{0x0000600000004800L});
    public static final BitSet FOLLOW_ruleInt_in_ruleDeclGranularity478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleDeclExport567 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclExport592 = new BitSet(new long[]{0x00000000000003E2L});
    public static final BitSet FOLLOW_ruleExport_in_ruleDeclExport613 = new BitSet(new long[]{0x00000000000003E2L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDeclType697 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType718 = new BitSet(new long[]{0x0000600011204BF0L});
    public static final BitSet FOLLOW_21_in_ruleDeclType733 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleConDecls_in_ruleDeclType764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclType792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleDeclType812 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType833 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleDeclType846 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType867 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleDeclType881 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclType893 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleConDecls_in_ruleDeclType914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDeclVal1000 = new BitSet(new long[]{0x000000000000B7E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1022 = new BitSet(new long[]{0x00000000002003E0L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleDeclVal1059 = new BitSet(new long[]{0x00000000002003E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1081 = new BitSet(new long[]{0x00000000002003E0L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1094 = new BitSet(new long[]{0x00000C4A00000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDeclVal1135 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1156 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDeclVal1168 = new BitSet(new long[]{0x0000600104004BE0L});
    public static final BitSet FOLLOW_ruleDecodePat_in_ruleDeclVal1190 = new BitSet(new long[]{0x0000600104004BE0L});
    public static final BitSet FOLLOW_ruleDecodePat_in_ruleDeclVal1211 = new BitSet(new long[]{0x0000600104004BE0L});
    public static final BitSet FOLLOW_26_in_ruleDeclVal1226 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1240 = new BitSet(new long[]{0x00000C4A00000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleDeclVal1280 = new BitSet(new long[]{0x00000C4A00000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1300 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1312 = new BitSet(new long[]{0x00000C4A00000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1333 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport1373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleExport1429 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleExport1442 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleExport1463 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_25_in_ruleExport1476 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleExport1497 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_ruleExport1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_entryRuleConDecls1549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecls1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleConDecls1605 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleConDecls1617 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleConDecls1637 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl1675 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_ruleConDecl1731 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleConDecl1744 = new BitSet(new long[]{0x0000600010204BF0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleConDecl1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy1803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTy1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleTy1877 = new BitSet(new long[]{0x0000600000004800L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTy1897 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleTy1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTy1936 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleTy1949 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy1970 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleTy1983 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2004 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleTy2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTy2040 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2061 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_25_in_ruleTy2074 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2095 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_ruleTy2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement2146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement2156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleTyElement2202 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleTyElement2214 = new BitSet(new long[]{0x0000600010204BF0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyElement2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind2271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTyBind2327 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleTyBind2340 = new BitSet(new long[]{0x0000600010204BF0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyBind2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecodePat_in_entryRuleDecodePat2399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecodePat2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_ruleDecodePat2456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_ruleDecodePat2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_entryRuleBitPat2518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPat2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBitPat2565 = new BitSet(new long[]{0x0000000000003BF0L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_ruleBitPat2586 = new BitSet(new long[]{0x0000000100003BF0L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_ruleBitPat2607 = new BitSet(new long[]{0x0000000100003BF0L});
    public static final BitSet FOLLOW_32_in_ruleBitPat2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_entryRuleTokPat2656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTokPat2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTokPat2713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTokPat2732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp2770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMIXID_in_ruleExp2854 = new BitSet(new long[]{0x0000044A00000000L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp2875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_entryRuleCaseExp2912 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseExp2922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleCaseExp2987 = new BitSet(new long[]{0x0000044800000000L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp3008 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleCaseExp3020 = new BitSet(new long[]{0x0000680100004BE0L});
    public static final BitSet FOLLOW_ruleCases_in_ruleCaseExp3041 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleCaseExp3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_entryRuleClosedExp3090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedExp3100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_ruleClosedExp3147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleClosedExp3165 = new BitSet(new long[]{0x0000044A00000000L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3186 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleClosedExp3198 = new BitSet(new long[]{0x0000044A00000000L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3219 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleClosedExp3231 = new BitSet(new long[]{0x0000044A00000000L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleClosedExp3272 = new BitSet(new long[]{0x00000C4A000003E0L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3293 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_19_in_ruleClosedExp3306 = new BitSet(new long[]{0x00000C4A000003E0L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3327 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_34_in_ruleClosedExp3341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonadicExp3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleMonadicExp3462 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleMonadicExp3474 = new BitSet(new long[]{0x00000C4A00000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCases_in_entryRuleCases3532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCases3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePat_in_ruleCases3588 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleCases3600 = new BitSet(new long[]{0x00000C4A00000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCases3621 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleCases3633 = new BitSet(new long[]{0x0000680100004BE0L});
    public static final BitSet FOLLOW_rulePat_in_ruleCases3653 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleCases3665 = new BitSet(new long[]{0x00000C4A00000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCases3686 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrElseExp3734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3781 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleOrElseExp3802 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3823 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp3861 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndAlsoExp3871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp3918 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleAndAlsoExp3939 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp3960 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_entryRuleRExp3998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRExp4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleRExp4050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePat_in_entryRulePat4099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePat4110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rulePat4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLit_in_rulePat4176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_rulePat4215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConUse_in_rulePat4250 = new BitSet(new long[]{0x0000680100004BE2L});
    public static final BitSet FOLLOW_rulePat_in_rulePat4278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLit_in_entryRuleLit4327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLit4338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleLit4385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleLit4410 = new BitSet(new long[]{0x0000000100003810L});
    public static final BitSet FOLLOW_ruleBITSTR_in_ruleLit4433 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleLit4453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat4495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimBitPat4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rulePrimBitPat4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rulePrimBitPat4594 = new BitSet(new long[]{0x0000100080000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_rulePrimBitPat4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt4671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPatOrInt4682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBitPatOrInt4721 = new BitSet(new long[]{0x0000400000004800L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleBitPatOrInt4743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleBitPatOrInt4769 = new BitSet(new long[]{0x0000000000003810L});
    public static final BitSet FOLLOW_ruleBITSTR_in_ruleBitPatOrInt4791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_entryRuleInt4838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInt4849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleInt4896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_ruleInt4929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName4975 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName4986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleName5032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_entryRuleConBind5077 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConBind5088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConBind5134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConUse_in_entryRuleConUse5179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConUse5190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConUse5236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid5281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid5292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleQid5338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT5383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT5394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_rulePOSINT5441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_rulePOSINT5474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_entryRuleNEGINT5520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNEGINT5531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleNEGINT5569 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_ruleNUM_in_ruleNEGINT5591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_entryRuleNUM5637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUM5648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleNUM5700 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM5747 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXNUM5758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleHEXNUM5796 = new BitSet(new long[]{0x0000000000004860L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_ruleHEXNUM5824 = new BitSet(new long[]{0x0000000000004862L});
    public static final BitSet FOLLOW_ruleBITSTR_in_entryRuleBITSTR5874 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITSTR5885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITSTR5937 = new BitSet(new long[]{0x0000000000003812L});
    public static final BitSet FOLLOW_ruleMIXID_in_entryRuleMIXID5984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMIXID5995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleMIXID6033 = new BitSet(new long[]{0x0000000000004FE0L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_ruleMIXID6056 = new BitSet(new long[]{0x0000000000004FE2L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS6104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS6115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_ruleCONS6162 = new BitSet(new long[]{0x0000000000004FE2L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_ruleCONS6195 = new BitSet(new long[]{0x0000000000004FE2L});
    public static final BitSet FOLLOW_ruleID_in_entryRuleID6243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleID6254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_ruleID6301 = new BitSet(new long[]{0x0000000000004FE2L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_ruleID6334 = new BitSet(new long[]{0x0000000000004FE2L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT6382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXDIGIT6393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleHEXDIGIT6440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_ruleHEXDIGIT6473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR6519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXCHAR6530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_ruleHEXCHAR6570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_ruleHEXCHAR6596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_entryRuleULETTER6642 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleULETTER6653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_ruleULETTER6693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNHEXCHAR_in_ruleULETTER6719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_entryRuleLETTER6765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLETTER6776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_ruleLETTER6816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LNHEXCHAR_in_ruleLETTER6842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_ruleLETTER6875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleLETTER6901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR6947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDCHAR6958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_ruleIDCHAR7005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleIDCHAR7038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_ruleIDCHAR7064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_entryRuleBINARY7110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBINARY7121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_ruleBINARY7161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleBINARY7187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleBINARY7213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleBINARY7239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_entryRuleDIG7285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDIG7296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_ruleDIG7336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NBINDIG_in_ruleDIG7362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_entryRuleSYM7408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSYM7419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleSYM7459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleSYM7485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSYM7511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_ruleSYM7537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OTHERSYM_in_ruleSYM7563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred2_InternalGDSL1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_synpred3_InternalGDSL4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_synpred4_InternalGDSL4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_synpred5_InternalGDSL5684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_synpred6_InternalGDSL5808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_synpred7_InternalGDSL5921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_synpred8_InternalGDSL6179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_synpred9_InternalGDSL6318 = new BitSet(new long[]{0x0000000000000002L});

}