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

@SuppressWarnings("all")
public class InternalGDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_CONS", "RULE_POSINT", "RULE_NEGINT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "';'", "'granularity'", "'='", "'export'", "'type'", "'['", "','", "']'", "'val'", "'{'", "'}'", "'|'", "'of'", "':'"
    };
    public static final int RULE_ID=4;
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
    public static final int RULE_CONS=5;
    public static final int T__15=15;
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
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

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
             
            	        newCompositeNode(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDecl_in_ruleModel131);
            lv_decl_0_0=ruleDecl();

            state._fsp--;


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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:2: ( (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=11 && LA2_0<=12)||(LA2_0>=14 && LA2_0<=15)||LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==11) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:5: otherlv_1= ';'
            	            {
            	            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleModel145); 

            	                	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getSemicolonKeyword_1_0());
            	                

            	            }
            	            break;

            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:102:3: ( (lv_decl_2_0= ruleDecl ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:103:1: (lv_decl_2_0= ruleDecl )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:103:1: (lv_decl_2_0= ruleDecl )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:104:3: lv_decl_2_0= ruleDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getDeclDeclParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDecl_in_ruleModel168);
            	    lv_decl_2_0=ruleDecl();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
             newCompositeNode(grammarAccess.getDeclRule()); 
            pushFollow(FOLLOW_ruleDecl_in_entryRuleDecl206);
            iv_ruleDecl=ruleDecl();

            state._fsp--;

             current =iv_ruleDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecl216); 

            }

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
            case 12:
                {
                alt3=1;
                }
                break;
            case 14:
                {
                alt3=2;
                }
                break;
            case 15:
                {
                alt3=3;
                }
                break;
            case 19:
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:142:5: this_DeclGranularity_0= ruleDeclGranularity
                    {
                     
                            newCompositeNode(grammarAccess.getDeclAccess().getDeclGranularityParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDeclGranularity_in_ruleDecl263);
                    this_DeclGranularity_0=ruleDeclGranularity();

                    state._fsp--;

                     
                            current = this_DeclGranularity_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:152:5: this_DeclExport_1= ruleDeclExport
                    {
                     
                            newCompositeNode(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDeclExport_in_ruleDecl290);
                    this_DeclExport_1=ruleDeclExport();

                    state._fsp--;

                     
                            current = this_DeclExport_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:162:5: this_DeclType_2= ruleDeclType
                    {
                     
                            newCompositeNode(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDeclType_in_ruleDecl317);
                    this_DeclType_2=ruleDeclType();

                    state._fsp--;

                     
                            current = this_DeclType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:172:5: this_DeclVal_3= ruleDeclVal
                    {
                     
                            newCompositeNode(grammarAccess.getDeclAccess().getDeclValParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleDeclVal_in_ruleDecl344);
                    this_DeclVal_3=ruleDeclVal();

                    state._fsp--;

                     
                            current = this_DeclVal_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
             newCompositeNode(grammarAccess.getDeclGranularityRule()); 
            pushFollow(FOLLOW_ruleDeclGranularity_in_entryRuleDeclGranularity379);
            iv_ruleDeclGranularity=ruleDeclGranularity();

            state._fsp--;

             current =iv_ruleDeclGranularity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclGranularity389); 

            }

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
            lv_name_0_0=(Token)match(input,12,FOLLOW_12_in_ruleDeclGranularity432); 

                    newLeafNode(lv_name_0_0, grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclGranularityRule());
            	        }
                   		setWithLastConsumed(current, "name", lv_name_0_0, "granularity");
            	    

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleDeclGranularity457); 

                	newLeafNode(otherlv_1, grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1());
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:220:1: ( (lv_granularity_2_0= ruleInt ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:221:1: (lv_granularity_2_0= ruleInt )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:221:1: (lv_granularity_2_0= ruleInt )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:222:3: lv_granularity_2_0= ruleInt
            {
             
            	        newCompositeNode(grammarAccess.getDeclGranularityAccess().getGranularityIntParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleInt_in_ruleDeclGranularity478);
            lv_granularity_2_0=ruleInt();

            state._fsp--;


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

             leaveRule(); 
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
             newCompositeNode(grammarAccess.getDeclExportRule()); 
            pushFollow(FOLLOW_ruleDeclExport_in_entryRuleDeclExport514);
            iv_ruleDeclExport=ruleDeclExport();

            state._fsp--;

             current =iv_ruleDeclExport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclExport524); 

            }

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
            lv_name_0_0=(Token)match(input,14,FOLLOW_14_in_ruleDeclExport567); 

                    newLeafNode(lv_name_0_0, grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclExportRule());
            	        }
                   		setWithLastConsumed(current, "name", lv_name_0_0, "export");
            	    

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleDeclExport592); 

                	newLeafNode(otherlv_1, grammarAccess.getDeclExportAccess().getEqualsSignKeyword_1());
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:278:1: ( (lv_exports_2_0= ruleExport ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:279:1: (lv_exports_2_0= ruleExport )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:279:1: (lv_exports_2_0= ruleExport )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:280:3: lv_exports_2_0= ruleExport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDeclExportAccess().getExportsExportParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExport_in_ruleDeclExport613);
            	    lv_exports_2_0=ruleExport();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
             newCompositeNode(grammarAccess.getDeclTypeRule()); 
            pushFollow(FOLLOW_ruleDeclType_in_entryRuleDeclType650);
            iv_ruleDeclType=ruleDeclType();

            state._fsp--;

             current =iv_ruleDeclType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclType660); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:1: ruleDeclType returns [EObject current=null] : ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) ) | (otherlv_4= 'type' ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '[' ( (lv_attrName_7_0= RULE_ID ) ) (otherlv_8= ',' ( (lv_attrName_9_0= RULE_ID ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) ) ) ;
    public final EObject ruleDeclType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token lv_attrName_7_0=null;
        Token otherlv_8=null;
        Token lv_attrName_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_value_3_1 = null;

        EObject lv_value_3_2 = null;

        EObject lv_value_12_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:316:28: ( ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) ) | (otherlv_4= 'type' ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '[' ( (lv_attrName_7_0= RULE_ID ) ) (otherlv_8= ',' ( (lv_attrName_9_0= RULE_ID ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:1: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) ) | (otherlv_4= 'type' ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '[' ( (lv_attrName_7_0= RULE_ID ) ) (otherlv_8= ',' ( (lv_attrName_9_0= RULE_ID ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:1: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) ) | (otherlv_4= 'type' ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '[' ( (lv_attrName_7_0= RULE_ID ) ) (otherlv_8= ',' ( (lv_attrName_9_0= RULE_ID ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==13) ) {
                        alt7=1;
                    }
                    else if ( (LA7_2==16) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:4: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) )
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleDeclType698); 

                        	newLeafNode(otherlv_0, grammarAccess.getDeclTypeAccess().getTypeKeyword_0_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:321:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:1: (lv_name_1_0= RULE_ID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:323:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclType715); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDeclTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleDeclType732); 

                        	newLeafNode(otherlv_2, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_0_2());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:343:1: ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:344:1: ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:344:1: ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:345:1: (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:345:1: (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==RULE_CONS) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==RULE_ID||(LA5_0>=RULE_POSINT && LA5_0<=RULE_NEGINT)||LA5_0==20||LA5_0==22) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:346:3: lv_value_3_1= ruleConDecls
                            {
                             
                            	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_0_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleConDecls_in_ruleDeclType755);
                            lv_value_3_1=ruleConDecls();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_3_1, 
                                    		"ConDecls");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:361:8: lv_value_3_2= ruleTy
                            {
                             
                            	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_0_3_0_1()); 
                            	    
                            pushFollow(FOLLOW_ruleTy_in_ruleDeclType774);
                            lv_value_3_2=ruleTy();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_3_2, 
                                    		"Ty");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:380:6: (otherlv_4= 'type' ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '[' ( (lv_attrName_7_0= RULE_ID ) ) (otherlv_8= ',' ( (lv_attrName_9_0= RULE_ID ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:380:6: (otherlv_4= 'type' ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '[' ( (lv_attrName_7_0= RULE_ID ) ) (otherlv_8= ',' ( (lv_attrName_9_0= RULE_ID ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:380:8: otherlv_4= 'type' ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '[' ( (lv_attrName_7_0= RULE_ID ) ) (otherlv_8= ',' ( (lv_attrName_9_0= RULE_ID ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) )
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleDeclType797); 

                        	newLeafNode(otherlv_4, grammarAccess.getDeclTypeAccess().getTypeKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:384:1: ( (lv_name_5_0= RULE_ID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:385:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:385:1: (lv_name_5_0= RULE_ID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:386:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclType814); 

                    			newLeafNode(lv_name_5_0, grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDeclTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_5_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleDeclType831); 

                        	newLeafNode(otherlv_6, grammarAccess.getDeclTypeAccess().getLeftSquareBracketKeyword_1_2());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:406:1: ( (lv_attrName_7_0= RULE_ID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:407:1: (lv_attrName_7_0= RULE_ID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:407:1: (lv_attrName_7_0= RULE_ID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:408:3: lv_attrName_7_0= RULE_ID
                    {
                    lv_attrName_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclType848); 

                    			newLeafNode(lv_attrName_7_0, grammarAccess.getDeclTypeAccess().getAttrNameIDTerminalRuleCall_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDeclTypeRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"attrName",
                            		lv_attrName_7_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:2: (otherlv_8= ',' ( (lv_attrName_9_0= RULE_ID ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:4: otherlv_8= ',' ( (lv_attrName_9_0= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleDeclType866); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getDeclTypeAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:428:1: ( (lv_attrName_9_0= RULE_ID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:429:1: (lv_attrName_9_0= RULE_ID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:429:1: (lv_attrName_9_0= RULE_ID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:430:3: lv_attrName_9_0= RULE_ID
                    	    {
                    	    lv_attrName_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclType883); 

                    	    			newLeafNode(lv_attrName_9_0, grammarAccess.getDeclTypeAccess().getAttrNameIDTerminalRuleCall_1_4_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getDeclTypeRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"attrName",
                    	            		lv_attrName_9_0, 
                    	            		"ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleDeclType902); 

                        	newLeafNode(otherlv_10, grammarAccess.getDeclTypeAccess().getRightSquareBracketKeyword_1_5());
                        
                    otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleDeclType914); 

                        	newLeafNode(otherlv_11, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_1_6());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:1: ( (lv_value_12_0= ruleConDecls ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:455:1: (lv_value_12_0= ruleConDecls )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:455:1: (lv_value_12_0= ruleConDecls )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:456:3: lv_value_12_0= ruleConDecls
                    {
                     
                    	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_1_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConDecls_in_ruleDeclType935);
                    lv_value_12_0=ruleConDecls();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_12_0, 
                            		"ConDecls");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:480:1: entryRuleDeclVal returns [EObject current=null] : iv_ruleDeclVal= ruleDeclVal EOF ;
    public final EObject entryRuleDeclVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclVal = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:481:2: (iv_ruleDeclVal= ruleDeclVal EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:482:2: iv_ruleDeclVal= ruleDeclVal EOF
            {
             newCompositeNode(grammarAccess.getDeclValRule()); 
            pushFollow(FOLLOW_ruleDeclVal_in_entryRuleDeclVal972);
            iv_ruleDeclVal=ruleDeclVal();

            state._fsp--;

             current =iv_ruleDeclVal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclVal982); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:489:1: ruleDeclVal returns [EObject current=null] : (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )* ) ;
    public final EObject ruleDeclVal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_attr_2_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:492:28: ( (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:493:1: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:493:1: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:493:3: otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleDeclVal1019); 

                	newLeafNode(otherlv_0, grammarAccess.getDeclValAccess().getValKeyword_0());
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:497:1: ( (lv_name_1_0= RULE_ID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:498:1: (lv_name_1_0= RULE_ID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:498:1: (lv_name_1_0= RULE_ID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:499:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1036); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDeclValAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclValRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:515:2: ( (lv_attr_2_0= RULE_ID ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:516:1: (lv_attr_2_0= RULE_ID )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:516:1: (lv_attr_2_0= RULE_ID )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:517:3: lv_attr_2_0= RULE_ID
            	    {
            	    lv_attr_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1058); 

            	    			newLeafNode(lv_attr_2_0, grammarAccess.getDeclValAccess().getAttrIDTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDeclValRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"attr",
            	            		lv_attr_2_0, 
            	            		"ID");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:541:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:542:2: (iv_ruleExport= ruleExport EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:543:2: iv_ruleExport= ruleExport EOF
            {
             newCompositeNode(grammarAccess.getExportRule()); 
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport1100);
            iv_ruleExport=ruleExport();

            state._fsp--;

             current =iv_ruleExport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport1110); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:550:1: ruleExport returns [EObject current=null] : ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )? ) ;
    public final EObject ruleExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_attrName_2_0=null;
        Token otherlv_3=null;
        Token lv_attrName_4_0=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:553:28: ( ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:554:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:554:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:554:2: ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:554:2: ( (lv_name_0_0= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:555:1: (lv_name_0_0= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:555:1: (lv_name_0_0= ruleQid )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:556:3: lv_name_0_0= ruleQid
            {
             
            	        newCompositeNode(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQid_in_ruleExport1156);
            lv_name_0_0=ruleQid();

            state._fsp--;


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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:572:2: (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:572:4: otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleExport1169); 

                        	newLeafNode(otherlv_1, grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:576:1: ( (lv_attrName_2_0= RULE_ID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:577:1: (lv_attrName_2_0= RULE_ID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:577:1: (lv_attrName_2_0= RULE_ID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:578:3: lv_attrName_2_0= RULE_ID
                    {
                    lv_attrName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExport1186); 

                    			newLeafNode(lv_attrName_2_0, grammarAccess.getExportAccess().getAttrNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getExportRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"attrName",
                            		lv_attrName_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:594:2: (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==17) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:594:4: otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleExport1204); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getExportAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:598:1: ( (lv_attrName_4_0= RULE_ID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:599:1: (lv_attrName_4_0= RULE_ID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:599:1: (lv_attrName_4_0= RULE_ID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:600:3: lv_attrName_4_0= RULE_ID
                    	    {
                    	    lv_attrName_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExport1221); 

                    	    			newLeafNode(lv_attrName_4_0, grammarAccess.getExportAccess().getAttrNameIDTerminalRuleCall_1_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getExportRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"attrName",
                    	            		lv_attrName_4_0, 
                    	            		"ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleExport1240); 

                        	newLeafNode(otherlv_5, grammarAccess.getExportAccess().getRightCurlyBracketKeyword_1_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:628:1: entryRuleConDecls returns [EObject current=null] : iv_ruleConDecls= ruleConDecls EOF ;
    public final EObject entryRuleConDecls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecls = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:629:2: (iv_ruleConDecls= ruleConDecls EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:630:2: iv_ruleConDecls= ruleConDecls EOF
            {
             newCompositeNode(grammarAccess.getConDeclsRule()); 
            pushFollow(FOLLOW_ruleConDecls_in_entryRuleConDecls1278);
            iv_ruleConDecls=ruleConDecls();

            state._fsp--;

             current =iv_ruleConDecls; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecls1288); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:637:1: ruleConDecls returns [EObject current=null] : ( ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )* ) ;
    public final EObject ruleConDecls() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_conDecls_0_0 = null;

        EObject lv_conDecls_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:640:28: ( ( ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:641:1: ( ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:641:1: ( ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:641:2: ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:641:2: ( (lv_conDecls_0_0= ruleConDecl ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:642:1: (lv_conDecls_0_0= ruleConDecl )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:642:1: (lv_conDecls_0_0= ruleConDecl )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:643:3: lv_conDecls_0_0= ruleConDecl
            {
             
            	        newCompositeNode(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConDecl_in_ruleConDecls1334);
            lv_conDecls_0_0=ruleConDecl();

            state._fsp--;


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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:659:2: (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==22) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:659:4: otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) )
            	    {
            	    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleConDecls1347); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConDeclsAccess().getVerticalLineKeyword_1_0());
            	        
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:663:1: ( (lv_conDecls_2_0= ruleConDecl ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:664:1: (lv_conDecls_2_0= ruleConDecl )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:664:1: (lv_conDecls_2_0= ruleConDecl )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:665:3: lv_conDecls_2_0= ruleConDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConDecl_in_ruleConDecls1368);
            	    lv_conDecls_2_0=ruleConDecl();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:689:1: entryRuleConDecl returns [EObject current=null] : iv_ruleConDecl= ruleConDecl EOF ;
    public final EObject entryRuleConDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:690:2: (iv_ruleConDecl= ruleConDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:691:2: iv_ruleConDecl= ruleConDecl EOF
            {
             newCompositeNode(grammarAccess.getConDeclRule()); 
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl1406);
            iv_ruleConDecl=ruleConDecl();

            state._fsp--;

             current =iv_ruleConDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl1416); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:698:1: ruleConDecl returns [EObject current=null] : ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleConDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ty_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:701:28: ( ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:702:1: ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:702:1: ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:702:2: ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:702:2: ( (lv_name_0_0= ruleConBind ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:703:1: (lv_name_0_0= ruleConBind )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:703:1: (lv_name_0_0= ruleConBind )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:704:3: lv_name_0_0= ruleConBind
            {
             
            	        newCompositeNode(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConBind_in_ruleConDecl1462);
            lv_name_0_0=ruleConBind();

            state._fsp--;


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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:720:2: (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:720:4: otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleConDecl1475); 

                        	newLeafNode(otherlv_1, grammarAccess.getConDeclAccess().getOfKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:724:1: ( (lv_ty_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:725:1: (lv_ty_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:725:1: (lv_ty_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:726:3: lv_ty_2_0= ruleTy
                    {
                     
                    	        newCompositeNode(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTy_in_ruleConDecl1496);
                    lv_ty_2_0=ruleTy();

                    state._fsp--;


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
                    break;

            }


            }


            }

             leaveRule(); 
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:750:1: entryRuleTy returns [EObject current=null] : iv_ruleTy= ruleTy EOF ;
    public final EObject entryRuleTy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTy = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:751:2: (iv_ruleTy= ruleTy EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:752:2: iv_ruleTy= ruleTy EOF
            {
             newCompositeNode(grammarAccess.getTyRule()); 
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy1534);
            iv_ruleTy=ruleTy();

            state._fsp--;

             current =iv_ruleTy; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy1544); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:759:1: ruleTy returns [EObject current=null] : ( ( (lv_value_0_0= ruleInt ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) ) ;
    public final EObject ruleTy() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:762:28: ( ( ( (lv_value_0_0= ruleInt ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:763:1: ( ( (lv_value_0_0= ruleInt ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:763:1: ( ( (lv_value_0_0= ruleInt ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_POSINT:
            case RULE_NEGINT:
                {
                alt16=1;
                }
                break;
            case 22:
                {
                alt16=2;
                }
                break;
            case RULE_ID:
                {
                alt16=3;
                }
                break;
            case 20:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:763:2: ( (lv_value_0_0= ruleInt ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:763:2: ( (lv_value_0_0= ruleInt ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:764:1: (lv_value_0_0= ruleInt )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:764:1: (lv_value_0_0= ruleInt )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:765:3: lv_value_0_0= ruleInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInt_in_ruleTy1590);
                    lv_value_0_0=ruleInt();

                    state._fsp--;


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
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:782:6: (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:782:6: (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:782:8: otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleTy1609); 

                        	newLeafNode(otherlv_1, grammarAccess.getTyAccess().getVerticalLineKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:786:1: ( (lv_value_2_0= ruleInt ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:787:1: (lv_value_2_0= ruleInt )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:787:1: (lv_value_2_0= ruleInt )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:788:3: lv_value_2_0= ruleInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInt_in_ruleTy1630);
                    lv_value_2_0=ruleInt();

                    state._fsp--;


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

                    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleTy1642); 

                        	newLeafNode(otherlv_3, grammarAccess.getTyAccess().getVerticalLineKeyword_1_2());
                        

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:809:6: ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:809:6: ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:809:7: ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:809:7: ( (lv_value_4_0= ruleQid ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:810:1: (lv_value_4_0= ruleQid )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:810:1: (lv_value_4_0= ruleQid )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:811:3: lv_value_4_0= ruleQid
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQid_in_ruleTy1671);
                    lv_value_4_0=ruleQid();

                    state._fsp--;


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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:827:2: (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==16) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:827:4: otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']'
                            {
                            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleTy1684); 

                                	newLeafNode(otherlv_5, grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0());
                                
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:831:1: ( (lv_tyBind_6_0= ruleTyBind ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:832:1: (lv_tyBind_6_0= ruleTyBind )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:832:1: (lv_tyBind_6_0= ruleTyBind )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:833:3: lv_tyBind_6_0= ruleTyBind
                            {
                             
                            	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleTyBind_in_ruleTy1705);
                            lv_tyBind_6_0=ruleTyBind();

                            state._fsp--;


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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:849:2: (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==17) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:849:4: otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) )
                            	    {
                            	    otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleTy1718); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0());
                            	        
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:853:1: ( (lv_tyBind_8_0= ruleTyBind ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:854:1: (lv_tyBind_8_0= ruleTyBind )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:854:1: (lv_tyBind_8_0= ruleTyBind )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:855:3: lv_tyBind_8_0= ruleTyBind
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleTyBind_in_ruleTy1739);
                            	    lv_tyBind_8_0=ruleTyBind();

                            	    state._fsp--;


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
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);

                            otherlv_9=(Token)match(input,18,FOLLOW_18_in_ruleTy1753); 

                                	newLeafNode(otherlv_9, grammarAccess.getTyAccess().getRightSquareBracketKeyword_2_1_3());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:876:6: (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:876:6: (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:876:8: otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleTy1775); 

                        	newLeafNode(otherlv_10, grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:880:1: ( (lv_elements_11_0= ruleTyElement ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:881:1: (lv_elements_11_0= ruleTyElement )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:881:1: (lv_elements_11_0= ruleTyElement )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:882:3: lv_elements_11_0= ruleTyElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTyElement_in_ruleTy1796);
                    lv_elements_11_0=ruleTyElement();

                    state._fsp--;


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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:898:2: (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==17) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:898:4: otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) )
                    	    {
                    	    otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleTy1809); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getTyAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:902:1: ( (lv_elements_13_0= ruleTyElement ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:903:1: (lv_elements_13_0= ruleTyElement )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:903:1: (lv_elements_13_0= ruleTyElement )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:904:3: lv_elements_13_0= ruleTyElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTyElement_in_ruleTy1830);
                    	    lv_elements_13_0=ruleTyElement();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,21,FOLLOW_21_in_ruleTy1844); 

                        	newLeafNode(otherlv_14, grammarAccess.getTyAccess().getRightCurlyBracketKeyword_3_3());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:932:1: entryRuleTyElement returns [EObject current=null] : iv_ruleTyElement= ruleTyElement EOF ;
    public final EObject entryRuleTyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyElement = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:933:2: (iv_ruleTyElement= ruleTyElement EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:934:2: iv_ruleTyElement= ruleTyElement EOF
            {
             newCompositeNode(grammarAccess.getTyElementRule()); 
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement1881);
            iv_ruleTyElement=ruleTyElement();

            state._fsp--;

             current =iv_ruleTyElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement1891); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:941:1: ruleTyElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) ;
    public final EObject ruleTyElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:944:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:945:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:945:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:945:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:945:2: ( (lv_name_0_0= RULE_ID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:946:1: (lv_name_0_0= RULE_ID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:946:1: (lv_name_0_0= RULE_ID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:947:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyElement1933); 

            			newLeafNode(lv_name_0_0, grammarAccess.getTyElementAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTyElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleTyElement1950); 

                	newLeafNode(otherlv_1, grammarAccess.getTyElementAccess().getColonKeyword_1());
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:967:1: ( (lv_value_2_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:968:1: (lv_value_2_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:968:1: (lv_value_2_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:969:3: lv_value_2_0= ruleTy
            {
             
            	        newCompositeNode(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTy_in_ruleTyElement1971);
            lv_value_2_0=ruleTy();

            state._fsp--;


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

             leaveRule(); 
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:993:1: entryRuleTyBind returns [EObject current=null] : iv_ruleTyBind= ruleTyBind EOF ;
    public final EObject entryRuleTyBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:994:2: (iv_ruleTyBind= ruleTyBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:995:2: iv_ruleTyBind= ruleTyBind EOF
            {
             newCompositeNode(grammarAccess.getTyBindRule()); 
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind2007);
            iv_ruleTyBind=ruleTyBind();

            state._fsp--;

             current =iv_ruleTyBind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind2017); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1002:1: ruleTyBind returns [EObject current=null] : ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleTyBind() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1005:28: ( ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1006:1: ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1006:1: ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1006:2: ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1006:2: ( (lv_key_0_0= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1007:1: (lv_key_0_0= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1007:1: (lv_key_0_0= ruleQid )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1008:3: lv_key_0_0= ruleQid
            {
             
            	        newCompositeNode(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQid_in_ruleTyBind2063);
            lv_key_0_0=ruleQid();

            state._fsp--;


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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1024:2: (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==13) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1024:4: otherlv_1= '=' ( (lv_value_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleTyBind2076); 

                        	newLeafNode(otherlv_1, grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1028:1: ( (lv_value_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1029:1: (lv_value_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1029:1: (lv_value_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1030:3: lv_value_2_0= ruleTy
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTy_in_ruleTyBind2097);
                    lv_value_2_0=ruleTy();

                    state._fsp--;


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
                    break;

            }


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleConBind"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:1: entryRuleConBind returns [String current=null] : iv_ruleConBind= ruleConBind EOF ;
    public final String entryRuleConBind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1055:2: (iv_ruleConBind= ruleConBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1056:2: iv_ruleConBind= ruleConBind EOF
            {
             newCompositeNode(grammarAccess.getConBindRule()); 
            pushFollow(FOLLOW_ruleConBind_in_entryRuleConBind2136);
            iv_ruleConBind=ruleConBind();

            state._fsp--;

             current =iv_ruleConBind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConBind2147); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1063:1: ruleConBind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CONS_0= RULE_CONS ;
    public final AntlrDatatypeRuleToken ruleConBind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CONS_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1066:28: (this_CONS_0= RULE_CONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1067:5: this_CONS_0= RULE_CONS
            {
            this_CONS_0=(Token)match(input,RULE_CONS,FOLLOW_RULE_CONS_in_ruleConBind2186); 

            		current.merge(this_CONS_0);
                
             
                newLeafNode(this_CONS_0, grammarAccess.getConBindAccess().getCONSTerminalRuleCall()); 
                

            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleInt"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1082:1: entryRuleInt returns [String current=null] : iv_ruleInt= ruleInt EOF ;
    public final String entryRuleInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInt = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1083:2: (iv_ruleInt= ruleInt EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1084:2: iv_ruleInt= ruleInt EOF
            {
             newCompositeNode(grammarAccess.getIntRule()); 
            pushFollow(FOLLOW_ruleInt_in_entryRuleInt2231);
            iv_ruleInt=ruleInt();

            state._fsp--;

             current =iv_ruleInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInt2242); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1091:1: ruleInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= RULE_POSINT | this_NEGINT_1= RULE_NEGINT ) ;
    public final AntlrDatatypeRuleToken ruleInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_POSINT_0=null;
        Token this_NEGINT_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1094:28: ( (this_POSINT_0= RULE_POSINT | this_NEGINT_1= RULE_NEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1095:1: (this_POSINT_0= RULE_POSINT | this_NEGINT_1= RULE_NEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1095:1: (this_POSINT_0= RULE_POSINT | this_NEGINT_1= RULE_NEGINT )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_POSINT) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_NEGINT) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1095:6: this_POSINT_0= RULE_POSINT
                    {
                    this_POSINT_0=(Token)match(input,RULE_POSINT,FOLLOW_RULE_POSINT_in_ruleInt2282); 

                    		current.merge(this_POSINT_0);
                        
                     
                        newLeafNode(this_POSINT_0, grammarAccess.getIntAccess().getPOSINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1103:10: this_NEGINT_1= RULE_NEGINT
                    {
                    this_NEGINT_1=(Token)match(input,RULE_NEGINT,FOLLOW_RULE_NEGINT_in_ruleInt2308); 

                    		current.merge(this_NEGINT_1);
                        
                     
                        newLeafNode(this_NEGINT_1, grammarAccess.getIntAccess().getNEGINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1118:1: entryRuleQid returns [String current=null] : iv_ruleQid= ruleQid EOF ;
    public final String entryRuleQid() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQid = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1119:2: (iv_ruleQid= ruleQid EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1120:2: iv_ruleQid= ruleQid EOF
            {
             newCompositeNode(grammarAccess.getQidRule()); 
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid2354);
            iv_ruleQid=ruleQid();

            state._fsp--;

             current =iv_ruleQid.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid2365); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1127:1: ruleQid returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleQid() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1130:28: (this_ID_0= RULE_ID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1131:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQid2404); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQidAccess().getIDTerminalRuleCall()); 
                

            }

             leaveRule(); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel131 = new BitSet(new long[]{0x000000000008D802L});
    public static final BitSet FOLLOW_11_in_ruleModel145 = new BitSet(new long[]{0x000000000008D800L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel168 = new BitSet(new long[]{0x000000000008D802L});
    public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecl216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_ruleDecl263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_ruleDecl290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_ruleDecl317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_ruleDecl344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_entryRuleDeclGranularity379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclGranularity389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleDeclGranularity432 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDeclGranularity457 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleInt_in_ruleDeclGranularity478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleDeclExport567 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDeclExport592 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleExport_in_ruleDeclExport613 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDeclType698 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclType715 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDeclType732 = new BitSet(new long[]{0x00000000005000F0L});
    public static final BitSet FOLLOW_ruleConDecls_in_ruleDeclType755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclType774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDeclType797 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclType814 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleDeclType831 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclType848 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleDeclType866 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclType883 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleDeclType902 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleDeclType914 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleConDecls_in_ruleDeclType935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal972 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleDeclVal1019 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1036 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1058 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport1100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleExport1156 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleExport1169 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExport1186 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_17_in_ruleExport1204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExport1221 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_21_in_ruleExport1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_entryRuleConDecls1278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecls1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleConDecls1334 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleConDecls1347 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleConDecls1368 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl1406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_ruleConDecl1462 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleConDecl1475 = new BitSet(new long[]{0x00000000005000F0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleConDecl1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy1534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTy1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleTy1609 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTy1630 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTy1642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTy1671 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleTy1684 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy1705 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleTy1718 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy1739 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleTy1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleTy1775 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy1796 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_17_in_ruleTy1809 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy1830 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_21_in_ruleTy1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement1881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyElement1933 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTyElement1950 = new BitSet(new long[]{0x00000000005000F0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyElement1971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind2007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTyBind2063 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleTyBind2076 = new BitSet(new long[]{0x00000000005000F0L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyBind2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_entryRuleConBind2136 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConBind2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CONS_in_ruleConBind2186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_entryRuleInt2231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInt2242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_POSINT_in_ruleInt2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEGINT_in_ruleInt2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid2354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQid2404 = new BitSet(new long[]{0x0000000000000002L});

}