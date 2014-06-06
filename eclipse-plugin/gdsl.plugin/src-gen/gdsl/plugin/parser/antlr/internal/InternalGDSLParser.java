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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_PIPE", "RULE_LHEXCHAR", "RULE_UHEXCHAR", "RULE_UNHEXCHAR", "RULE_LNHEXCHAR", "RULE_SLASH", "RULE_CHARSYM", "RULE_BINDIG", "RULE_BS", "RULE_DOT", "RULE_NBINDIG", "RULE_OTHERSYM", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "';'", "'granularity'", "'='", "'export'", "'type'", "'['", "','", "']'", "'val'", "'{'", "'}'", "'of'", "':'", "'\\''", "'@'", "'exptodo'", "'~'", "'0x'"
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
    public static final int RULE_BS=12;
    public static final int RULE_UNHEXCHAR=7;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int RULE_DOT=13;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int RULE_PIPE=4;
    public static final int T__36=36;
    public static final int RULE_OTHERSYM=15;
    public static final int RULE_NBINDIG=14;
    public static final int RULE_LNHEXCHAR=8;
    public static final int RULE_BINDIG=11;
    public static final int RULE_LHEXCHAR=5;
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

            if ( ((LA7_0>=RULE_PIPE && LA7_0<=RULE_SLASH)||LA7_0==RULE_BINDIG||LA7_0==RULE_NBINDIG||LA7_0==21||LA7_0==28||(LA7_0>=35 && LA7_0<=36)) ) {
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
                    else if ( ((LA5_0>=RULE_PIPE && LA5_0<=RULE_SLASH)||LA5_0==RULE_BINDIG||LA5_0==RULE_NBINDIG||LA5_0==28||(LA5_0>=35 && LA5_0<=36)) ) {
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

        AntlrDatatypeRuleToken lv_exp_5_0 = null;

        AntlrDatatypeRuleToken lv_name_7_0 = null;

        EObject lv_decPat_9_0 = null;

        EObject lv_decPat_10_0 = null;

        AntlrDatatypeRuleToken lv_exp_13_0 = null;

        AntlrDatatypeRuleToken lv_exps_15_0 = null;

        AntlrDatatypeRuleToken lv_exps_17_0 = null;


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

                    if ( ((LA11_0>=RULE_LHEXCHAR && LA11_0<=RULE_SLASH)||LA11_0==RULE_BINDIG||LA11_0==RULE_NBINDIG||LA11_0==32||(LA11_0>=35 && LA11_0<=36)) ) {
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

                                if ( ((LA10_0>=RULE_LHEXCHAR && LA10_0<=RULE_SLASH)||LA10_0==RULE_BINDIG||LA10_0==RULE_NBINDIG||LA10_0==32||(LA10_0>=35 && LA10_0<=36)) ) {
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
            case 35:
            case 36:
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
            else if ( ((LA24_0>=RULE_LHEXCHAR && LA24_0<=RULE_SLASH)||LA24_0==RULE_BINDIG||LA24_0==RULE_NBINDIG||(LA24_0>=35 && LA24_0<=36)) ) {
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

            if ( (LA26_0==RULE_BINDIG||LA26_0==RULE_NBINDIG||(LA26_0>=35 && LA26_0<=36)) ) {
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


    // $ANTLR start "entryRulePrimBitPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1378:1: entryRulePrimBitPat returns [String current=null] : iv_rulePrimBitPat= rulePrimBitPat EOF ;
    public final String entryRulePrimBitPat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimBitPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1379:2: (iv_rulePrimBitPat= rulePrimBitPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1380:2: iv_rulePrimBitPat= rulePrimBitPat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimBitPatRule()); 
            }
            pushFollow(FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat2771);
            iv_rulePrimBitPat=rulePrimBitPat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimBitPat.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimBitPat2782); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1387:1: rulePrimBitPat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) ) ;
    public final AntlrDatatypeRuleToken rulePrimBitPat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BITSTR_0 = null;

        AntlrDatatypeRuleToken this_Qid_1 = null;

        AntlrDatatypeRuleToken this_BitPatOrInt_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1390:28: ( ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:1: ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:1: ( ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR ) | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_BINDIG) && (synpred3_InternalGDSL())) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_BS) && (synpred3_InternalGDSL())) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_DOT) && (synpred3_InternalGDSL())) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_PIPE) && (synpred3_InternalGDSL())) {
                alt28=1;
            }
            else if ( ((LA28_0>=RULE_LHEXCHAR && LA28_0<=RULE_SLASH)) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:2: ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:2: ( ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:3: ( ruleBITSTR )=>this_BITSTR_0= ruleBITSTR
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimBitPatAccess().getBITSTRParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBITSTR_in_rulePrimBitPat2835);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1403:6: (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1403:6: (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1404:5: this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimBitPatAccess().getQidParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleQid_in_rulePrimBitPat2870);
                    this_Qid_1=ruleQid();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Qid_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1414:1: (this_BitPatOrInt_2= ruleBitPatOrInt )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==31||LA27_0==33) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1415:5: this_BitPatOrInt_2= ruleBitPatOrInt
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getPrimBitPatAccess().getBitPatOrIntParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBitPatOrInt_in_rulePrimBitPat2898);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1433:1: entryRuleBitPatOrInt returns [String current=null] : iv_ruleBitPatOrInt= ruleBitPatOrInt EOF ;
    public final String entryRuleBitPatOrInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitPatOrInt = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1434:2: (iv_ruleBitPatOrInt= ruleBitPatOrInt EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1435:2: iv_ruleBitPatOrInt= ruleBitPatOrInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitPatOrIntRule()); 
            }
            pushFollow(FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt2947);
            iv_ruleBitPatOrInt=ruleBitPatOrInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitPatOrInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPatOrInt2958); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1442:1: ruleBitPatOrInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) ) ;
    public final AntlrDatatypeRuleToken ruleBitPatOrInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_POSINT_1 = null;

        AntlrDatatypeRuleToken this_BITSTR_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1445:28: ( ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1446:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1446:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==31) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1446:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1446:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1447:2: kw= ':' this_POSINT_1= rulePOSINT
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleBitPatOrInt2997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBitPatOrIntAccess().getColonKeyword_0_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBitPatOrIntAccess().getPOSINTParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleBitPatOrInt3019);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1464:6: (kw= '@' this_BITSTR_3= ruleBITSTR )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1464:6: (kw= '@' this_BITSTR_3= ruleBITSTR )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1465:2: kw= '@' this_BITSTR_3= ruleBITSTR
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleBitPatOrInt3045); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBitPatOrIntAccess().getCommercialAtKeyword_1_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBitPatOrIntAccess().getBITSTRParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBITSTR_in_ruleBitPatOrInt3067);
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


    // $ANTLR start "entryRuleExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1489:1: entryRuleExp returns [String current=null] : iv_ruleExp= ruleExp EOF ;
    public final String entryRuleExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1490:2: (iv_ruleExp= ruleExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1491:2: iv_ruleExp= ruleExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpRule()); 
            }
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp3114);
            iv_ruleExp=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp3125); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1498:1: ruleExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'exptodo' ;
    public final AntlrDatatypeRuleToken ruleExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1501:28: (kw= 'exptodo' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1503:2: kw= 'exptodo'
            {
            kw=(Token)match(input,34,FOLLOW_34_in_ruleExp3162); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getExpAccess().getExptodoKeyword()); 
                  
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


    // $ANTLR start "entryRuleInt"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1516:1: entryRuleInt returns [String current=null] : iv_ruleInt= ruleInt EOF ;
    public final String entryRuleInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInt = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1517:2: (iv_ruleInt= ruleInt EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1518:2: iv_ruleInt= ruleInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntRule()); 
            }
            pushFollow(FOLLOW_ruleInt_in_entryRuleInt3202);
            iv_ruleInt=ruleInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInt3213); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1525:1: ruleInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT ) ;
    public final AntlrDatatypeRuleToken ruleInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_POSINT_0 = null;

        AntlrDatatypeRuleToken this_NEGINT_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1528:28: ( (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1529:1: (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1529:1: (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_BINDIG||LA30_0==RULE_NBINDIG||LA30_0==36) ) {
                alt30=1;
            }
            else if ( (LA30_0==35) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1530:5: this_POSINT_0= rulePOSINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIntAccess().getPOSINTParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleInt3260);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1542:5: this_NEGINT_1= ruleNEGINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIntAccess().getNEGINTParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNEGINT_in_ruleInt3293);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1560:1: entryRuleName returns [String current=null] : iv_ruleName= ruleName EOF ;
    public final String entryRuleName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleName = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1561:2: (iv_ruleName= ruleName EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1562:2: iv_ruleName= ruleName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameRule()); 
            }
            pushFollow(FOLLOW_ruleName_in_entryRuleName3339);
            iv_ruleName=ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleName3350); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1569:1: ruleName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1572:28: (this_ID_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1574:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNameAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleID_in_ruleName3396);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1592:1: entryRuleConBind returns [String current=null] : iv_ruleConBind= ruleConBind EOF ;
    public final String entryRuleConBind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1593:2: (iv_ruleConBind= ruleConBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1594:2: iv_ruleConBind= ruleConBind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConBindRule()); 
            }
            pushFollow(FOLLOW_ruleConBind_in_entryRuleConBind3441);
            iv_ruleConBind=ruleConBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConBind.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConBind3452); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1601:1: ruleConBind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CONS_0= ruleCONS ;
    public final AntlrDatatypeRuleToken ruleConBind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_CONS_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1604:28: (this_CONS_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1606:5: this_CONS_0= ruleCONS
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConBindAccess().getCONSParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConBind3498);
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


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1626:1: entryRuleQid returns [String current=null] : iv_ruleQid= ruleQid EOF ;
    public final String entryRuleQid() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQid = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1627:2: (iv_ruleQid= ruleQid EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1628:2: iv_ruleQid= ruleQid EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQidRule()); 
            }
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid3545);
            iv_ruleQid=ruleQid();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQid.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid3556); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1635:1: ruleQid returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleQid() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1638:28: (this_ID_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1640:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQidAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleID_in_ruleQid3602);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1658:1: entryRulePOSINT returns [String current=null] : iv_rulePOSINT= rulePOSINT EOF ;
    public final String entryRulePOSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePOSINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1659:2: (iv_rulePOSINT= rulePOSINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1660:2: iv_rulePOSINT= rulePOSINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPOSINTRule()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT3647);
            iv_rulePOSINT=rulePOSINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePOSINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT3658); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1667:1: rulePOSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM ) ;
    public final AntlrDatatypeRuleToken rulePOSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_NUM_0 = null;

        AntlrDatatypeRuleToken this_HEXNUM_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1670:28: ( (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1671:1: (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1671:1: (this_NUM_0= ruleNUM | this_HEXNUM_1= ruleHEXNUM )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_BINDIG||LA31_0==RULE_NBINDIG) ) {
                alt31=1;
            }
            else if ( (LA31_0==36) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1672:5: this_NUM_0= ruleNUM
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPOSINTAccess().getNUMParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNUM_in_rulePOSINT3705);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1684:5: this_HEXNUM_1= ruleHEXNUM
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPOSINTAccess().getHEXNUMParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleHEXNUM_in_rulePOSINT3738);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1702:1: entryRuleNEGINT returns [String current=null] : iv_ruleNEGINT= ruleNEGINT EOF ;
    public final String entryRuleNEGINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNEGINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1703:2: (iv_ruleNEGINT= ruleNEGINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1704:2: iv_ruleNEGINT= ruleNEGINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNEGINTRule()); 
            }
            pushFollow(FOLLOW_ruleNEGINT_in_entryRuleNEGINT3784);
            iv_ruleNEGINT=ruleNEGINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNEGINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNEGINT3795); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1711:1: ruleNEGINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '~' this_NUM_1= ruleNUM ) ;
    public final AntlrDatatypeRuleToken ruleNEGINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_NUM_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1714:28: ( (kw= '~' this_NUM_1= ruleNUM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1715:1: (kw= '~' this_NUM_1= ruleNUM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1715:1: (kw= '~' this_NUM_1= ruleNUM )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1716:2: kw= '~' this_NUM_1= ruleNUM
            {
            kw=(Token)match(input,35,FOLLOW_35_in_ruleNEGINT3833); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getNEGINTAccess().getTildeKeyword_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNEGINTAccess().getNUMParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleNUM_in_ruleNEGINT3855);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1740:1: entryRuleNUM returns [String current=null] : iv_ruleNUM= ruleNUM EOF ;
    public final String entryRuleNUM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1741:2: (iv_ruleNUM= ruleNUM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1742:2: iv_ruleNUM= ruleNUM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMRule()); 
            }
            pushFollow(FOLLOW_ruleNUM_in_entryRuleNUM3901);
            iv_ruleNUM=ruleNUM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUM3912); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1749:1: ruleNUM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( ruleDIG )=>this_DIG_0= ruleDIG )+ ;
    public final AntlrDatatypeRuleToken ruleNUM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DIG_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1752:28: ( ( ( ruleDIG )=>this_DIG_0= ruleDIG )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1753:1: ( ( ruleDIG )=>this_DIG_0= ruleDIG )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1753:1: ( ( ruleDIG )=>this_DIG_0= ruleDIG )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_BINDIG) ) {
                    int LA32_1 = input.LA(2);

                    if ( (synpred4_InternalGDSL()) ) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0==RULE_NBINDIG) ) {
                    int LA32_3 = input.LA(2);

                    if ( (synpred4_InternalGDSL()) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1753:2: ( ruleDIG )=>this_DIG_0= ruleDIG
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getNUMAccess().getDIGParserRuleCall()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleDIG_in_ruleNUM3964);
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
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1772:1: entryRuleHEXNUM returns [String current=null] : iv_ruleHEXNUM= ruleHEXNUM EOF ;
    public final String entryRuleHEXNUM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXNUM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1773:2: (iv_ruleHEXNUM= ruleHEXNUM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1774:2: iv_ruleHEXNUM= ruleHEXNUM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHEXNUMRule()); 
            }
            pushFollow(FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM4011);
            iv_ruleHEXNUM=ruleHEXNUM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXNUM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXNUM4022); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1781:1: ruleHEXNUM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ ) ;
    public final AntlrDatatypeRuleToken ruleHEXNUM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_HEXDIGIT_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1784:28: ( (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1785:1: (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1785:1: (kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1786:2: kw= '0x' ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+
            {
            kw=(Token)match(input,36,FOLLOW_36_in_ruleHEXNUM4060); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getHEXNUMAccess().getXKeyword_0()); 
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1791:1: ( ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                switch ( input.LA(1) ) {
                case RULE_BINDIG:
                    {
                    int LA33_1 = input.LA(2);

                    if ( (synpred5_InternalGDSL()) ) {
                        alt33=1;
                    }


                    }
                    break;
                case RULE_LHEXCHAR:
                    {
                    int LA33_3 = input.LA(2);

                    if ( (synpred5_InternalGDSL()) ) {
                        alt33=1;
                    }


                    }
                    break;
                case RULE_UHEXCHAR:
                    {
                    int LA33_4 = input.LA(2);

                    if ( (synpred5_InternalGDSL()) ) {
                        alt33=1;
                    }


                    }
                    break;
                case RULE_NBINDIG:
                    {
                    int LA33_5 = input.LA(2);

                    if ( (synpred5_InternalGDSL()) ) {
                        alt33=1;
                    }


                    }
                    break;

                }

                switch (alt33) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1791:2: ( ruleHEXDIGIT )=>this_HEXDIGIT_1= ruleHEXDIGIT
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getHEXNUMAccess().getHEXDIGITParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleHEXDIGIT_in_ruleHEXNUM4088);
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
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1812:1: entryRuleBITSTR returns [String current=null] : iv_ruleBITSTR= ruleBITSTR EOF ;
    public final String entryRuleBITSTR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITSTR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1813:2: (iv_ruleBITSTR= ruleBITSTR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1814:2: iv_ruleBITSTR= ruleBITSTR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITSTRRule()); 
            }
            pushFollow(FOLLOW_ruleBITSTR_in_entryRuleBITSTR4138);
            iv_ruleBITSTR=ruleBITSTR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITSTR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITSTR4149); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1821:1: ruleBITSTR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+ ;
    public final AntlrDatatypeRuleToken ruleBITSTR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BINARY_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1824:28: ( ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1825:1: ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1825:1: ( ( ruleBINARY )=>this_BINARY_0= ruleBINARY )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                switch ( input.LA(1) ) {
                case RULE_BINDIG:
                    {
                    int LA34_1 = input.LA(2);

                    if ( (synpred6_InternalGDSL()) ) {
                        alt34=1;
                    }


                    }
                    break;
                case RULE_BS:
                    {
                    int LA34_2 = input.LA(2);

                    if ( (synpred6_InternalGDSL()) ) {
                        alt34=1;
                    }


                    }
                    break;
                case RULE_DOT:
                    {
                    int LA34_3 = input.LA(2);

                    if ( (synpred6_InternalGDSL()) ) {
                        alt34=1;
                    }


                    }
                    break;
                case RULE_PIPE:
                    {
                    int LA34_4 = input.LA(2);

                    if ( (synpred6_InternalGDSL()) ) {
                        alt34=1;
                    }


                    }
                    break;

                }

                switch (alt34) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1825:2: ( ruleBINARY )=>this_BINARY_0= ruleBINARY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getBITSTRAccess().getBINARYParserRuleCall()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleBINARY_in_ruleBITSTR4201);
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
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
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


    // $ANTLR start "entryRuleCONS"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1846:1: entryRuleCONS returns [String current=null] : iv_ruleCONS= ruleCONS EOF ;
    public final String entryRuleCONS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCONS = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1847:2: (iv_ruleCONS= ruleCONS EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1848:2: iv_ruleCONS= ruleCONS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCONSRule()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS4250);
            iv_ruleCONS=ruleCONS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCONS.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS4261); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1855:1: ruleCONS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ULETTER_0= ruleULETTER (this_IDCHAR_1= ruleIDCHAR )* ) ;
    public final AntlrDatatypeRuleToken ruleCONS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ULETTER_0 = null;

        AntlrDatatypeRuleToken this_IDCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1858:28: ( (this_ULETTER_0= ruleULETTER (this_IDCHAR_1= ruleIDCHAR )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1859:1: (this_ULETTER_0= ruleULETTER (this_IDCHAR_1= ruleIDCHAR )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1859:1: (this_ULETTER_0= ruleULETTER (this_IDCHAR_1= ruleIDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1860:5: this_ULETTER_0= ruleULETTER (this_IDCHAR_1= ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCONSAccess().getULETTERParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleULETTER_in_ruleCONS4308);
            this_ULETTER_0=ruleULETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ULETTER_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1870:1: (this_IDCHAR_1= ruleIDCHAR )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_LHEXCHAR && LA35_0<=RULE_BINDIG)||LA35_0==RULE_NBINDIG) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1871:5: this_IDCHAR_1= ruleIDCHAR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getCONSAccess().getIDCHARParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleIDCHAR_in_ruleCONS4336);
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
    // $ANTLR end "ruleCONS"


    // $ANTLR start "entryRuleID"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1889:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1890:2: (iv_ruleID= ruleID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1891:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FOLLOW_ruleID_in_entryRuleID4384);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleID4395); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1898:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_LETTER_0 = null;

        AntlrDatatypeRuleToken this_IDCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1901:28: ( (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1902:1: (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1902:1: (this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1903:5: this_LETTER_0= ruleLETTER ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIDAccess().getLETTERParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleLETTER_in_ruleID4442);
            this_LETTER_0=ruleLETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_LETTER_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1913:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1913:2: ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getIDAccess().getIDCHARParserRuleCall_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleIDCHAR_in_ruleID4475);
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
    // $ANTLR end "ruleID"


    // $ANTLR start "entryRuleHEXDIGIT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1932:1: entryRuleHEXDIGIT returns [String current=null] : iv_ruleHEXDIGIT= ruleHEXDIGIT EOF ;
    public final String entryRuleHEXDIGIT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXDIGIT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1933:2: (iv_ruleHEXDIGIT= ruleHEXDIGIT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1934:2: iv_ruleHEXDIGIT= ruleHEXDIGIT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHEXDIGITRule()); 
            }
            pushFollow(FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT4523);
            iv_ruleHEXDIGIT=ruleHEXDIGIT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXDIGIT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXDIGIT4534); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1941:1: ruleHEXDIGIT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR ) ;
    public final AntlrDatatypeRuleToken ruleHEXDIGIT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_DIG_0 = null;

        AntlrDatatypeRuleToken this_HEXCHAR_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1944:28: ( (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:1: (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:1: (this_DIG_0= ruleDIG | this_HEXCHAR_1= ruleHEXCHAR )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_BINDIG||LA37_0==RULE_NBINDIG) ) {
                alt37=1;
            }
            else if ( ((LA37_0>=RULE_LHEXCHAR && LA37_0<=RULE_UHEXCHAR)) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1946:5: this_DIG_0= ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getHEXDIGITAccess().getDIGParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDIG_in_ruleHEXDIGIT4581);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1958:5: this_HEXCHAR_1= ruleHEXCHAR
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getHEXDIGITAccess().getHEXCHARParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleHEXCHAR_in_ruleHEXDIGIT4614);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1976:1: entryRuleHEXCHAR returns [String current=null] : iv_ruleHEXCHAR= ruleHEXCHAR EOF ;
    public final String entryRuleHEXCHAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXCHAR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1977:2: (iv_ruleHEXCHAR= ruleHEXCHAR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1978:2: iv_ruleHEXCHAR= ruleHEXCHAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHEXCHARRule()); 
            }
            pushFollow(FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR4660);
            iv_ruleHEXCHAR=ruleHEXCHAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHEXCHAR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXCHAR4671); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1985:1: ruleHEXCHAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR ) ;
    public final AntlrDatatypeRuleToken ruleHEXCHAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LHEXCHAR_0=null;
        Token this_UHEXCHAR_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1988:28: ( (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_UHEXCHAR_1= RULE_UHEXCHAR )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_LHEXCHAR) ) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_UHEXCHAR) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:6: this_LHEXCHAR_0= RULE_LHEXCHAR
                    {
                    this_LHEXCHAR_0=(Token)match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_ruleHEXCHAR4711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LHEXCHAR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LHEXCHAR_0, grammarAccess.getHEXCHARAccess().getLHEXCHARTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1997:10: this_UHEXCHAR_1= RULE_UHEXCHAR
                    {
                    this_UHEXCHAR_1=(Token)match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_ruleHEXCHAR4737); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2012:1: entryRuleULETTER returns [String current=null] : iv_ruleULETTER= ruleULETTER EOF ;
    public final String entryRuleULETTER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleULETTER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2013:2: (iv_ruleULETTER= ruleULETTER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2014:2: iv_ruleULETTER= ruleULETTER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getULETTERRule()); 
            }
            pushFollow(FOLLOW_ruleULETTER_in_entryRuleULETTER4783);
            iv_ruleULETTER=ruleULETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleULETTER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleULETTER4794); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2021:1: ruleULETTER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR ) ;
    public final AntlrDatatypeRuleToken ruleULETTER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_UHEXCHAR_0=null;
        Token this_UNHEXCHAR_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2024:28: ( (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2025:1: (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2025:1: (this_UHEXCHAR_0= RULE_UHEXCHAR | this_UNHEXCHAR_1= RULE_UNHEXCHAR )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_UHEXCHAR) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_UNHEXCHAR) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2025:6: this_UHEXCHAR_0= RULE_UHEXCHAR
                    {
                    this_UHEXCHAR_0=(Token)match(input,RULE_UHEXCHAR,FOLLOW_RULE_UHEXCHAR_in_ruleULETTER4834); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UHEXCHAR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_UHEXCHAR_0, grammarAccess.getULETTERAccess().getUHEXCHARTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2033:10: this_UNHEXCHAR_1= RULE_UNHEXCHAR
                    {
                    this_UNHEXCHAR_1=(Token)match(input,RULE_UNHEXCHAR,FOLLOW_RULE_UNHEXCHAR_in_ruleULETTER4860); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2048:1: entryRuleLETTER returns [String current=null] : iv_ruleLETTER= ruleLETTER EOF ;
    public final String entryRuleLETTER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLETTER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2049:2: (iv_ruleLETTER= ruleLETTER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2050:2: iv_ruleLETTER= ruleLETTER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLETTERRule()); 
            }
            pushFollow(FOLLOW_ruleLETTER_in_entryRuleLETTER4906);
            iv_ruleLETTER=ruleLETTER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLETTER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLETTER4917); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2057:1: ruleLETTER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH ) ;
    public final AntlrDatatypeRuleToken ruleLETTER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LHEXCHAR_0=null;
        Token this_LNHEXCHAR_1=null;
        Token this_SLASH_3=null;
        AntlrDatatypeRuleToken this_ULETTER_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2060:28: ( (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2061:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2061:1: (this_LHEXCHAR_0= RULE_LHEXCHAR | this_LNHEXCHAR_1= RULE_LNHEXCHAR | this_ULETTER_2= ruleULETTER | this_SLASH_3= RULE_SLASH )
            int alt40=4;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
                {
                alt40=1;
                }
                break;
            case RULE_LNHEXCHAR:
                {
                alt40=2;
                }
                break;
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
                {
                alt40=3;
                }
                break;
            case RULE_SLASH:
                {
                alt40=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2061:6: this_LHEXCHAR_0= RULE_LHEXCHAR
                    {
                    this_LHEXCHAR_0=(Token)match(input,RULE_LHEXCHAR,FOLLOW_RULE_LHEXCHAR_in_ruleLETTER4957); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LHEXCHAR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LHEXCHAR_0, grammarAccess.getLETTERAccess().getLHEXCHARTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2069:10: this_LNHEXCHAR_1= RULE_LNHEXCHAR
                    {
                    this_LNHEXCHAR_1=(Token)match(input,RULE_LNHEXCHAR,FOLLOW_RULE_LNHEXCHAR_in_ruleLETTER4983); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LNHEXCHAR_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LNHEXCHAR_1, grammarAccess.getLETTERAccess().getLNHEXCHARTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:5: this_ULETTER_2= ruleULETTER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLETTERAccess().getULETTERParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleULETTER_in_ruleLETTER5016);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2089:10: this_SLASH_3= RULE_SLASH
                    {
                    this_SLASH_3=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleLETTER5042); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2104:1: entryRuleIDCHAR returns [String current=null] : iv_ruleIDCHAR= ruleIDCHAR EOF ;
    public final String entryRuleIDCHAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDCHAR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2105:2: (iv_ruleIDCHAR= ruleIDCHAR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2106:2: iv_ruleIDCHAR= ruleIDCHAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDCHARRule()); 
            }
            pushFollow(FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR5088);
            iv_ruleIDCHAR=ruleIDCHAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIDCHAR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDCHAR5099); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2113:1: ruleIDCHAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM ) ;
    public final AntlrDatatypeRuleToken ruleIDCHAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CHARSYM_2=null;
        AntlrDatatypeRuleToken this_LETTER_0 = null;

        AntlrDatatypeRuleToken this_DIG_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2116:28: ( (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2117:1: (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2117:1: (this_LETTER_0= ruleLETTER | this_DIG_1= ruleDIG | this_CHARSYM_2= RULE_CHARSYM )
            int alt41=3;
            switch ( input.LA(1) ) {
            case RULE_LHEXCHAR:
            case RULE_UHEXCHAR:
            case RULE_UNHEXCHAR:
            case RULE_LNHEXCHAR:
            case RULE_SLASH:
                {
                alt41=1;
                }
                break;
            case RULE_BINDIG:
            case RULE_NBINDIG:
                {
                alt41=2;
                }
                break;
            case RULE_CHARSYM:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2118:5: this_LETTER_0= ruleLETTER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIDCHARAccess().getLETTERParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLETTER_in_ruleIDCHAR5146);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2130:5: this_DIG_1= ruleDIG
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIDCHARAccess().getDIGParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDIG_in_ruleIDCHAR5179);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2141:10: this_CHARSYM_2= RULE_CHARSYM
                    {
                    this_CHARSYM_2=(Token)match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_ruleIDCHAR5205); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2156:1: entryRuleBINARY returns [String current=null] : iv_ruleBINARY= ruleBINARY EOF ;
    public final String entryRuleBINARY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBINARY = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2157:2: (iv_ruleBINARY= ruleBINARY EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2158:2: iv_ruleBINARY= ruleBINARY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBINARYRule()); 
            }
            pushFollow(FOLLOW_ruleBINARY_in_entryRuleBINARY5251);
            iv_ruleBINARY=ruleBINARY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBINARY.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBINARY5262); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2165:1: ruleBINARY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE ) ;
    public final AntlrDatatypeRuleToken ruleBINARY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINDIG_0=null;
        Token this_BS_1=null;
        Token this_DOT_2=null;
        Token this_PIPE_3=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2168:28: ( (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2169:1: (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2169:1: (this_BINDIG_0= RULE_BINDIG | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_PIPE_3= RULE_PIPE )
            int alt42=4;
            switch ( input.LA(1) ) {
            case RULE_BINDIG:
                {
                alt42=1;
                }
                break;
            case RULE_BS:
                {
                alt42=2;
                }
                break;
            case RULE_DOT:
                {
                alt42=3;
                }
                break;
            case RULE_PIPE:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2169:6: this_BINDIG_0= RULE_BINDIG
                    {
                    this_BINDIG_0=(Token)match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_ruleBINARY5302); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINDIG_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINDIG_0, grammarAccess.getBINARYAccess().getBINDIGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2177:10: this_BS_1= RULE_BS
                    {
                    this_BS_1=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleBINARY5328); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_1, grammarAccess.getBINARYAccess().getBSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2185:10: this_DOT_2= RULE_DOT
                    {
                    this_DOT_2=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleBINARY5354); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_2, grammarAccess.getBINARYAccess().getDOTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2193:10: this_PIPE_3= RULE_PIPE
                    {
                    this_PIPE_3=(Token)match(input,RULE_PIPE,FOLLOW_RULE_PIPE_in_ruleBINARY5380); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2208:1: entryRuleDIG returns [String current=null] : iv_ruleDIG= ruleDIG EOF ;
    public final String entryRuleDIG() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDIG = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2209:2: (iv_ruleDIG= ruleDIG EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2210:2: iv_ruleDIG= ruleDIG EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDIGRule()); 
            }
            pushFollow(FOLLOW_ruleDIG_in_entryRuleDIG5426);
            iv_ruleDIG=ruleDIG();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDIG.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDIG5437); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2217:1: ruleDIG returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG ) ;
    public final AntlrDatatypeRuleToken ruleDIG() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINDIG_0=null;
        Token this_NBINDIG_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2220:28: ( (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2221:1: (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2221:1: (this_BINDIG_0= RULE_BINDIG | this_NBINDIG_1= RULE_NBINDIG )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_BINDIG) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_NBINDIG) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2221:6: this_BINDIG_0= RULE_BINDIG
                    {
                    this_BINDIG_0=(Token)match(input,RULE_BINDIG,FOLLOW_RULE_BINDIG_in_ruleDIG5477); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINDIG_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINDIG_0, grammarAccess.getDIGAccess().getBINDIGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2229:10: this_NBINDIG_1= RULE_NBINDIG
                    {
                    this_NBINDIG_1=(Token)match(input,RULE_NBINDIG,FOLLOW_RULE_NBINDIG_in_ruleDIG5503); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2244:1: entryRuleSYM returns [String current=null] : iv_ruleSYM= ruleSYM EOF ;
    public final String entryRuleSYM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSYM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2245:2: (iv_ruleSYM= ruleSYM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2246:2: iv_ruleSYM= ruleSYM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSYMRule()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_entryRuleSYM5549);
            iv_ruleSYM=ruleSYM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSYM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSYM5560); if (state.failed) return current;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2253:1: ruleSYM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM ) ;
    public final AntlrDatatypeRuleToken ruleSYM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BS_0=null;
        Token this_SLASH_1=null;
        Token this_DOT_2=null;
        Token this_CHARSYM_3=null;
        Token this_OTHERSYM_4=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2256:28: ( (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2257:1: (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2257:1: (this_BS_0= RULE_BS | this_SLASH_1= RULE_SLASH | this_DOT_2= RULE_DOT | this_CHARSYM_3= RULE_CHARSYM | this_OTHERSYM_4= RULE_OTHERSYM )
            int alt44=5;
            switch ( input.LA(1) ) {
            case RULE_BS:
                {
                alt44=1;
                }
                break;
            case RULE_SLASH:
                {
                alt44=2;
                }
                break;
            case RULE_DOT:
                {
                alt44=3;
                }
                break;
            case RULE_CHARSYM:
                {
                alt44=4;
                }
                break;
            case RULE_OTHERSYM:
                {
                alt44=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2257:6: this_BS_0= RULE_BS
                    {
                    this_BS_0=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleSYM5600); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_0, grammarAccess.getSYMAccess().getBSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2265:10: this_SLASH_1= RULE_SLASH
                    {
                    this_SLASH_1=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleSYM5626); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SLASH_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SLASH_1, grammarAccess.getSYMAccess().getSLASHTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2273:10: this_DOT_2= RULE_DOT
                    {
                    this_DOT_2=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSYM5652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_2, grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2281:10: this_CHARSYM_3= RULE_CHARSYM
                    {
                    this_CHARSYM_3=(Token)match(input,RULE_CHARSYM,FOLLOW_RULE_CHARSYM_in_ruleSYM5678); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CHARSYM_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_CHARSYM_3, grammarAccess.getSYMAccess().getCHARSYMTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2289:10: this_OTHERSYM_4= RULE_OTHERSYM
                    {
                    this_OTHERSYM_4=(Token)match(input,RULE_OTHERSYM,FOLLOW_RULE_OTHERSYM_in_ruleSYM5704); if (state.failed) return current;
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
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:3: ( ruleBITSTR )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1391:5: ruleBITSTR
        {
        pushFollow(FOLLOW_ruleBITSTR_in_synpred3_InternalGDSL2819);
        ruleBITSTR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalGDSL

    // $ANTLR start synpred4_InternalGDSL
    public final void synpred4_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1753:2: ( ruleDIG )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1753:4: ruleDIG
        {
        pushFollow(FOLLOW_ruleDIG_in_synpred4_InternalGDSL3948);
        ruleDIG();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalGDSL

    // $ANTLR start synpred5_InternalGDSL
    public final void synpred5_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1791:2: ( ruleHEXDIGIT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1791:4: ruleHEXDIGIT
        {
        pushFollow(FOLLOW_ruleHEXDIGIT_in_synpred5_InternalGDSL4072);
        ruleHEXDIGIT();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalGDSL

    // $ANTLR start synpred6_InternalGDSL
    public final void synpred6_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1825:2: ( ruleBINARY )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1825:4: ruleBINARY
        {
        pushFollow(FOLLOW_ruleBINARY_in_synpred6_InternalGDSL4185);
        ruleBINARY();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalGDSL

    // $ANTLR start synpred7_InternalGDSL
    public final void synpred7_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1913:2: ( ruleIDCHAR )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1913:4: ruleIDCHAR
        {
        pushFollow(FOLLOW_ruleIDCHAR_in_synpred7_InternalGDSL4459);
        ruleIDCHAR();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalGDSL

    // Delegated rules

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
    protected DFA36 dfa36 = new DFA36(this);
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
    static final String DFA36_eotS =
        "\12\uffff";
    static final String DFA36_eofS =
        "\1\1\11\uffff";
    static final String DFA36_minS =
        "\1\4\1\uffff\7\0\1\uffff";
    static final String DFA36_maxS =
        "\1\44\1\uffff\7\0\1\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\2\7\uffff\1\1";
    static final String DFA36_specialS =
        "\1\1\1\uffff\1\4\1\3\1\7\1\0\1\6\1\2\1\5\1\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\1\4\1\6\1\7\1\5\1\10\1\11\1\2\2\1\1\3\4\uffff\13\1\1\uffff"+
            "\3\1\1\uffff\2\1",
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
            return "()* loopback of 1913:1: ( ( ruleIDCHAR )=>this_IDCHAR_1= ruleIDCHAR )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_5 = input.LA(1);

                         
                        int index36_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_0 = input.LA(1);

                         
                        int index36_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA36_0==EOF||LA36_0==RULE_PIPE||(LA36_0>=RULE_BS && LA36_0<=RULE_DOT)||(LA36_0>=19 && LA36_0<=29)||(LA36_0>=31 && LA36_0<=33)||(LA36_0>=35 && LA36_0<=36)) ) {s = 1;}

                        else if ( (LA36_0==RULE_BINDIG) ) {s = 2;}

                        else if ( (LA36_0==RULE_NBINDIG) ) {s = 3;}

                        else if ( (LA36_0==RULE_LHEXCHAR) ) {s = 4;}

                        else if ( (LA36_0==RULE_LNHEXCHAR) ) {s = 5;}

                        else if ( (LA36_0==RULE_UHEXCHAR) ) {s = 6;}

                        else if ( (LA36_0==RULE_UNHEXCHAR) ) {s = 7;}

                        else if ( (LA36_0==RULE_SLASH) ) {s = 8;}

                        else if ( (LA36_0==RULE_CHARSYM) && (synpred7_InternalGDSL())) {s = 9;}

                         
                        input.seek(index36_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_7 = input.LA(1);

                         
                        int index36_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA36_3 = input.LA(1);

                         
                        int index36_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA36_2 = input.LA(1);

                         
                        int index36_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA36_8 = input.LA(1);

                         
                        int index36_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA36_6 = input.LA(1);

                         
                        int index36_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA36_4 = input.LA(1);

                         
                        int index36_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalGDSL()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_4);
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
    public static final BitSet FOLLOW_21_in_ruleDeclGranularity457 = new BitSet(new long[]{0x0000001800004800L});
    public static final BitSet FOLLOW_ruleInt_in_ruleDeclGranularity478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleDeclExport567 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclExport592 = new BitSet(new long[]{0x00000000000003E2L});
    public static final BitSet FOLLOW_ruleExport_in_ruleDeclExport613 = new BitSet(new long[]{0x00000000000003E2L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDeclType697 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType718 = new BitSet(new long[]{0x0000001811204BF0L});
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
    public static final BitSet FOLLOW_21_in_ruleDeclVal1094 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDeclVal1135 = new BitSet(new long[]{0x00000000000003E0L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1156 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDeclVal1168 = new BitSet(new long[]{0x0000001904004BE0L});
    public static final BitSet FOLLOW_ruleDecodePat_in_ruleDeclVal1190 = new BitSet(new long[]{0x0000001904004BE0L});
    public static final BitSet FOLLOW_ruleDecodePat_in_ruleDeclVal1211 = new BitSet(new long[]{0x0000001904004BE0L});
    public static final BitSet FOLLOW_26_in_ruleDeclVal1226 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1240 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleDeclVal1280 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1300 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1312 = new BitSet(new long[]{0x0000000400000000L});
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
    public static final BitSet FOLLOW_30_in_ruleConDecl1744 = new BitSet(new long[]{0x0000001810204BF0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleConDecl1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy1803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTy1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleTy1877 = new BitSet(new long[]{0x0000001800004800L});
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
    public static final BitSet FOLLOW_31_in_ruleTyElement2214 = new BitSet(new long[]{0x0000001810204BF0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyElement2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind2271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTyBind2327 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleTyBind2340 = new BitSet(new long[]{0x0000001810204BF0L});
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
    public static final BitSet FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat2771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimBitPat2782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rulePrimBitPat2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rulePrimBitPat2870 = new BitSet(new long[]{0x0000000280000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_rulePrimBitPat2898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt2947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPatOrInt2958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBitPatOrInt2997 = new BitSet(new long[]{0x0000001000004800L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleBitPatOrInt3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBitPatOrInt3045 = new BitSet(new long[]{0x0000000000003810L});
    public static final BitSet FOLLOW_ruleBITSTR_in_ruleBitPatOrInt3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp3114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleExp3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_entryRuleInt3202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInt3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleInt3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_ruleInt3293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName3339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleName3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_entryRuleConBind3441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConBind3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConBind3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid3545 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleQid3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT3647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_rulePOSINT3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_rulePOSINT3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_entryRuleNEGINT3784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNEGINT3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleNEGINT3833 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_ruleNUM_in_ruleNEGINT3855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_entryRuleNUM3901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUM3912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleNUM3964 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM4011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXNUM4022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleHEXNUM4060 = new BitSet(new long[]{0x0000000000004860L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_ruleHEXNUM4088 = new BitSet(new long[]{0x0000000000004862L});
    public static final BitSet FOLLOW_ruleBITSTR_in_entryRuleBITSTR4138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITSTR4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITSTR4201 = new BitSet(new long[]{0x0000000000003812L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS4250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS4261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_ruleCONS4308 = new BitSet(new long[]{0x0000000000004FE2L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_ruleCONS4336 = new BitSet(new long[]{0x0000000000004FE2L});
    public static final BitSet FOLLOW_ruleID_in_entryRuleID4384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleID4395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_ruleID4442 = new BitSet(new long[]{0x0000000000004FE2L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_ruleID4475 = new BitSet(new long[]{0x0000000000004FE2L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_entryRuleHEXDIGIT4523 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXDIGIT4534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleHEXDIGIT4581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_ruleHEXDIGIT4614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXCHAR_in_entryRuleHEXCHAR4660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXCHAR4671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_ruleHEXCHAR4711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_ruleHEXCHAR4737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_entryRuleULETTER4783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleULETTER4794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UHEXCHAR_in_ruleULETTER4834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNHEXCHAR_in_ruleULETTER4860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_entryRuleLETTER4906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLETTER4917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LHEXCHAR_in_ruleLETTER4957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LNHEXCHAR_in_ruleLETTER4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleULETTER_in_ruleLETTER5016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleLETTER5042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_entryRuleIDCHAR5088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDCHAR5099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLETTER_in_ruleIDCHAR5146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_ruleIDCHAR5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_ruleIDCHAR5205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_entryRuleBINARY5251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBINARY5262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_ruleBINARY5302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleBINARY5328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleBINARY5354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PIPE_in_ruleBINARY5380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_entryRuleDIG5426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDIG5437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINDIG_in_ruleDIG5477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NBINDIG_in_ruleDIG5503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_entryRuleSYM5549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSYM5560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleSYM5600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleSYM5626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSYM5652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CHARSYM_in_ruleSYM5678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OTHERSYM_in_ruleSYM5704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred2_InternalGDSL1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_synpred3_InternalGDSL2819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDIG_in_synpred4_InternalGDSL3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXDIGIT_in_synpred5_InternalGDSL4072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_synpred6_InternalGDSL4185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDCHAR_in_synpred7_InternalGDSL4459 = new BitSet(new long[]{0x0000000000000002L});

}