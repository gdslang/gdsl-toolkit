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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_POSINT", "RULE_NEGINT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "';'", "'granularity'", "'='", "'export'", "'type'", "'todo'", "'val'", "'{'", "','", "'}'"
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

                if ( ((LA2_0>=10 && LA2_0<=11)||(LA2_0>=13 && LA2_0<=14)||LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==10) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:5: otherlv_1= ';'
            	            {
            	            otherlv_1=(Token)match(input,10,FOLLOW_10_in_ruleModel145); 

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
            case 11:
                {
                alt3=1;
                }
                break;
            case 13:
                {
                alt3=2;
                }
                break;
            case 14:
                {
                alt3=3;
                }
                break;
            case 16:
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:197:1: ruleDeclGranularity returns [EObject current=null] : ( ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInteger ) ) ) ;
    public final EObject ruleDeclGranularity() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_granularity_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:200:28: ( ( ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInteger ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:201:1: ( ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInteger ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:201:1: ( ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInteger ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:201:2: ( (lv_name_0_0= 'granularity' ) ) otherlv_1= '=' ( (lv_granularity_2_0= ruleInteger ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:201:2: ( (lv_name_0_0= 'granularity' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:202:1: (lv_name_0_0= 'granularity' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:202:1: (lv_name_0_0= 'granularity' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:203:3: lv_name_0_0= 'granularity'
            {
            lv_name_0_0=(Token)match(input,11,FOLLOW_11_in_ruleDeclGranularity432); 

                    newLeafNode(lv_name_0_0, grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclGranularityRule());
            	        }
                   		setWithLastConsumed(current, "name", lv_name_0_0, "granularity");
            	    

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleDeclGranularity457); 

                	newLeafNode(otherlv_1, grammarAccess.getDeclGranularityAccess().getEqualsSignKeyword_1());
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:220:1: ( (lv_granularity_2_0= ruleInteger ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:221:1: (lv_granularity_2_0= ruleInteger )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:221:1: (lv_granularity_2_0= ruleInteger )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:222:3: lv_granularity_2_0= ruleInteger
            {
             
            	        newCompositeNode(grammarAccess.getDeclGranularityAccess().getGranularityIntegerParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleInteger_in_ruleDeclGranularity478);
            lv_granularity_2_0=ruleInteger();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDeclGranularityRule());
            	        }
                   		set(
                   			current, 
                   			"granularity",
                    		lv_granularity_2_0, 
                    		"Integer");
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
            lv_name_0_0=(Token)match(input,13,FOLLOW_13_in_ruleDeclExport567); 

                    newLeafNode(lv_name_0_0, grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclExportRule());
            	        }
                   		setWithLastConsumed(current, "name", lv_name_0_0, "export");
            	    

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleDeclExport592); 

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:1: ruleDeclType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= 'todo' ) ;
    public final EObject ruleDeclType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:316:28: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= 'todo' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= 'todo' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= 'todo' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= 'todo'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleDeclType697); 

                	newLeafNode(otherlv_0, grammarAccess.getDeclTypeAccess().getTypeKeyword_0());
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:321:1: ( (lv_name_1_0= RULE_ID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:1: (lv_name_1_0= RULE_ID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:1: (lv_name_1_0= RULE_ID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:323:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclType714); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

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

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleDeclType731); 

                	newLeafNode(otherlv_2, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2());
                
            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleDeclType743); 

                	newLeafNode(otherlv_3, grammarAccess.getDeclTypeAccess().getTodoKeyword_3());
                

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:355:1: entryRuleDeclVal returns [EObject current=null] : iv_ruleDeclVal= ruleDeclVal EOF ;
    public final EObject entryRuleDeclVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclVal = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:356:2: (iv_ruleDeclVal= ruleDeclVal EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:357:2: iv_ruleDeclVal= ruleDeclVal EOF
            {
             newCompositeNode(grammarAccess.getDeclValRule()); 
            pushFollow(FOLLOW_ruleDeclVal_in_entryRuleDeclVal779);
            iv_ruleDeclVal=ruleDeclVal();

            state._fsp--;

             current =iv_ruleDeclVal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclVal789); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:364:1: ruleDeclVal returns [EObject current=null] : (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )* ) ;
    public final EObject ruleDeclVal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_attr_2_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:367:28: ( (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:368:1: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:368:1: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:368:3: otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) ( (lv_attr_2_0= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleDeclVal826); 

                	newLeafNode(otherlv_0, grammarAccess.getDeclValAccess().getValKeyword_0());
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:372:1: ( (lv_name_1_0= RULE_ID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:373:1: (lv_name_1_0= RULE_ID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:373:1: (lv_name_1_0= RULE_ID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:374:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal843); 

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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:390:2: ( (lv_attr_2_0= RULE_ID ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:391:1: (lv_attr_2_0= RULE_ID )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:391:1: (lv_attr_2_0= RULE_ID )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:392:3: lv_attr_2_0= RULE_ID
            	    {
            	    lv_attr_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal865); 

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
            	    break loop5;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:416:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:417:2: (iv_ruleExport= ruleExport EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:418:2: iv_ruleExport= ruleExport EOF
            {
             newCompositeNode(grammarAccess.getExportRule()); 
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport907);
            iv_ruleExport=ruleExport();

            state._fsp--;

             current =iv_ruleExport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport917); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:425:1: ruleExport returns [EObject current=null] : ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )? ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:428:28: ( ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:429:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:429:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:429:2: ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:429:2: ( (lv_name_0_0= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:430:1: (lv_name_0_0= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:430:1: (lv_name_0_0= ruleQid )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:431:3: lv_name_0_0= ruleQid
            {
             
            	        newCompositeNode(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQid_in_ruleExport963);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:447:2: (otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:447:4: otherlv_1= '{' ( (lv_attrName_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleExport976); 

                        	newLeafNode(otherlv_1, grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:451:1: ( (lv_attrName_2_0= RULE_ID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:452:1: (lv_attrName_2_0= RULE_ID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:452:1: (lv_attrName_2_0= RULE_ID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:3: lv_attrName_2_0= RULE_ID
                    {
                    lv_attrName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExport993); 

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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:2: (otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==18) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:4: otherlv_3= ',' ( (lv_attrName_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleExport1011); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getExportAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:473:1: ( (lv_attrName_4_0= RULE_ID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:474:1: (lv_attrName_4_0= RULE_ID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:474:1: (lv_attrName_4_0= RULE_ID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:475:3: lv_attrName_4_0= RULE_ID
                    	    {
                    	    lv_attrName_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExport1028); 

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
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleExport1047); 

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


    // $ANTLR start "entryRuleInteger"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:503:1: entryRuleInteger returns [String current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final String entryRuleInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:504:2: (iv_ruleInteger= ruleInteger EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:505:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_ruleInteger_in_entryRuleInteger1086);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInteger1097); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:512:1: ruleInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= RULE_POSINT | this_NEGINT_1= RULE_NEGINT ) ;
    public final AntlrDatatypeRuleToken ruleInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_POSINT_0=null;
        Token this_NEGINT_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:515:28: ( (this_POSINT_0= RULE_POSINT | this_NEGINT_1= RULE_NEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:516:1: (this_POSINT_0= RULE_POSINT | this_NEGINT_1= RULE_NEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:516:1: (this_POSINT_0= RULE_POSINT | this_NEGINT_1= RULE_NEGINT )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_POSINT) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_NEGINT) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:516:6: this_POSINT_0= RULE_POSINT
                    {
                    this_POSINT_0=(Token)match(input,RULE_POSINT,FOLLOW_RULE_POSINT_in_ruleInteger1137); 

                    		current.merge(this_POSINT_0);
                        
                     
                        newLeafNode(this_POSINT_0, grammarAccess.getIntegerAccess().getPOSINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:524:10: this_NEGINT_1= RULE_NEGINT
                    {
                    this_NEGINT_1=(Token)match(input,RULE_NEGINT,FOLLOW_RULE_NEGINT_in_ruleInteger1163); 

                    		current.merge(this_NEGINT_1);
                        
                     
                        newLeafNode(this_NEGINT_1, grammarAccess.getIntegerAccess().getNEGINTTerminalRuleCall_1()); 
                        

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
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:539:1: entryRuleQid returns [String current=null] : iv_ruleQid= ruleQid EOF ;
    public final String entryRuleQid() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQid = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:540:2: (iv_ruleQid= ruleQid EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:541:2: iv_ruleQid= ruleQid EOF
            {
             newCompositeNode(grammarAccess.getQidRule()); 
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid1209);
            iv_ruleQid=ruleQid();

            state._fsp--;

             current =iv_ruleQid.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid1220); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:548:1: ruleQid returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleQid() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:551:28: (this_ID_0= RULE_ID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:552:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQid1259); 

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
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel131 = new BitSet(new long[]{0x0000000000016C02L});
    public static final BitSet FOLLOW_10_in_ruleModel145 = new BitSet(new long[]{0x0000000000016C00L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel168 = new BitSet(new long[]{0x0000000000016C02L});
    public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecl216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_ruleDecl263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_ruleDecl290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_ruleDecl317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_ruleDecl344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclGranularity_in_entryRuleDeclGranularity379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclGranularity389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleDeclGranularity432 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDeclGranularity457 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleInteger_in_ruleDeclGranularity478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleDeclExport567 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDeclExport592 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleExport_in_ruleDeclExport613 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleDeclType697 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclType714 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleDeclType731 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDeclType743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal779 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDeclVal826 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal843 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal865 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleExport963 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleExport976 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExport993 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleExport1011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExport1028 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_ruleExport1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInteger_in_entryRuleInteger1086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInteger1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_POSINT_in_ruleInteger1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEGINT_in_ruleInteger1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid1209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQid1259 = new BitSet(new long[]{0x0000000000000002L});

}