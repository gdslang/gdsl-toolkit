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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SYM", "RULE_ID", "RULE_DIG", "RULE_HEXDIGIT", "RULE_BINARY", "RULE_CONSTART", "RULE_IDCHAR", "RULE_BITSTRIDCHAR", "RULE_BITSTRID", "RULE_ESC", "RULE_SGOOD", "RULE_LETTER", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "';'", "'granularity'", "'='", "'export'", "'type'", "'['", "','", "']'", "'val'", "'|'", "'{'", "'}'", "'of'", "':'", "'\\''", "'@'", "'exptodo'", "'+'", "'~'", "'0x'"
    };
    public static final int RULE_DIG=6;
    public static final int RULE_ID=5;
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
    public static final int RULE_HEXDIGIT=7;
    public static final int RULE_SYM=4;
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
    public static final int RULE_BINARY=8;
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
            	            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleModel145); 

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
            lv_name_0_0=(Token)match(input,20,FOLLOW_20_in_ruleDeclGranularity432); 

                    newLeafNode(lv_name_0_0, grammarAccess.getDeclGranularityAccess().getNameGranularityKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclGranularityRule());
            	        }
                   		setWithLastConsumed(current, "name", lv_name_0_0, "granularity");
            	    

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleDeclGranularity457); 

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
            lv_name_0_0=(Token)match(input,22,FOLLOW_22_in_ruleDeclExport567); 

                    newLeafNode(lv_name_0_0, grammarAccess.getDeclExportAccess().getNameExportKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclExportRule());
            	        }
                   		setWithLastConsumed(current, "name", lv_name_0_0, "export");
            	    

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleDeclExport592); 

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:1: ruleDeclType returns [EObject current=null] : ( (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) ) | (otherlv_4= 'type' ( (lv_name_5_0= ruleName ) ) otherlv_6= '[' ( (lv_attrName_7_0= ruleName ) ) (otherlv_8= ',' ( (lv_attrName_9_0= ruleName ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) ) ) ;
    public final EObject ruleDeclType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_value_3_1 = null;

        EObject lv_value_3_2 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        AntlrDatatypeRuleToken lv_attrName_7_0 = null;

        AntlrDatatypeRuleToken lv_attrName_9_0 = null;

        EObject lv_value_12_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:316:28: ( ( (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) ) | (otherlv_4= 'type' ( (lv_name_5_0= ruleName ) ) otherlv_6= '[' ( (lv_attrName_7_0= ruleName ) ) (otherlv_8= ',' ( (lv_attrName_9_0= ruleName ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:1: ( (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) ) | (otherlv_4= 'type' ( (lv_name_5_0= ruleName ) ) otherlv_6= '[' ( (lv_attrName_7_0= ruleName ) ) (otherlv_8= ',' ( (lv_attrName_9_0= ruleName ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:1: ( (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) ) | (otherlv_4= 'type' ( (lv_name_5_0= ruleName ) ) otherlv_6= '[' ( (lv_attrName_7_0= ruleName ) ) (otherlv_8= ',' ( (lv_attrName_9_0= ruleName ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==23) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==24) ) {
                        alt7=2;
                    }
                    else if ( (LA7_2==21) ) {
                        alt7=1;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:2: (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:2: (otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:4: otherlv_0= 'type' ( (lv_name_1_0= ruleName ) ) otherlv_2= '=' ( ( (lv_value_3_1= ruleConDecls | lv_value_3_2= ruleTy ) ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleDeclType698); 

                        	newLeafNode(otherlv_0, grammarAccess.getDeclTypeAccess().getTypeKeyword_0_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:321:1: ( (lv_name_1_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:1: (lv_name_1_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:1: (lv_name_1_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:323:3: lv_name_1_0= ruleName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleName_in_ruleDeclType719);
                    lv_name_1_0=ruleName();

                    state._fsp--;


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

                    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleDeclType731); 

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

                    if ( (LA5_0==RULE_CONSTART) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==RULE_ID||(LA5_0>=28 && LA5_0<=29)||(LA5_0>=36 && LA5_0<=38)) ) {
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
                            	    
                            pushFollow(FOLLOW_ruleConDecls_in_ruleDeclType754);
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
                            	    
                            pushFollow(FOLLOW_ruleTy_in_ruleDeclType773);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:380:6: (otherlv_4= 'type' ( (lv_name_5_0= ruleName ) ) otherlv_6= '[' ( (lv_attrName_7_0= ruleName ) ) (otherlv_8= ',' ( (lv_attrName_9_0= ruleName ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:380:6: (otherlv_4= 'type' ( (lv_name_5_0= ruleName ) ) otherlv_6= '[' ( (lv_attrName_7_0= ruleName ) ) (otherlv_8= ',' ( (lv_attrName_9_0= ruleName ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:380:8: otherlv_4= 'type' ( (lv_name_5_0= ruleName ) ) otherlv_6= '[' ( (lv_attrName_7_0= ruleName ) ) (otherlv_8= ',' ( (lv_attrName_9_0= ruleName ) ) )* otherlv_10= ']' otherlv_11= '=' ( (lv_value_12_0= ruleConDecls ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleDeclType796); 

                        	newLeafNode(otherlv_4, grammarAccess.getDeclTypeAccess().getTypeKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:384:1: ( (lv_name_5_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:385:1: (lv_name_5_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:385:1: (lv_name_5_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:386:3: lv_name_5_0= ruleName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDeclTypeAccess().getNameNameParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleName_in_ruleDeclType817);
                    lv_name_5_0=ruleName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_5_0, 
                            		"Name");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleDeclType829); 

                        	newLeafNode(otherlv_6, grammarAccess.getDeclTypeAccess().getLeftSquareBracketKeyword_1_2());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:406:1: ( (lv_attrName_7_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:407:1: (lv_attrName_7_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:407:1: (lv_attrName_7_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:408:3: lv_attrName_7_0= ruleName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleName_in_ruleDeclType850);
                    lv_attrName_7_0=ruleName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"attrName",
                            		lv_attrName_7_0, 
                            		"Name");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:2: (otherlv_8= ',' ( (lv_attrName_9_0= ruleName ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==25) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:4: otherlv_8= ',' ( (lv_attrName_9_0= ruleName ) )
                    	    {
                    	    otherlv_8=(Token)match(input,25,FOLLOW_25_in_ruleDeclType863); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getDeclTypeAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:428:1: ( (lv_attrName_9_0= ruleName ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:429:1: (lv_attrName_9_0= ruleName )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:429:1: (lv_attrName_9_0= ruleName )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:430:3: lv_attrName_9_0= ruleName
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getDeclTypeAccess().getAttrNameNameParserRuleCall_1_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleName_in_ruleDeclType884);
                    	    lv_attrName_9_0=ruleName();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attrName",
                    	            		lv_attrName_9_0, 
                    	            		"Name");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,26,FOLLOW_26_in_ruleDeclType898); 

                        	newLeafNode(otherlv_10, grammarAccess.getDeclTypeAccess().getRightSquareBracketKeyword_1_5());
                        
                    otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleDeclType910); 

                        	newLeafNode(otherlv_11, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_1_6());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:1: ( (lv_value_12_0= ruleConDecls ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:455:1: (lv_value_12_0= ruleConDecls )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:455:1: (lv_value_12_0= ruleConDecls )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:456:3: lv_value_12_0= ruleConDecls
                    {
                     
                    	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueConDeclsParserRuleCall_1_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConDecls_in_ruleDeclType931);
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
            pushFollow(FOLLOW_ruleDeclVal_in_entryRuleDeclVal968);
            iv_ruleDeclVal=ruleDeclVal();

            state._fsp--;

             current =iv_ruleDeclVal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclVal978); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:489:1: ruleDeclVal returns [EObject current=null] : ( (otherlv_0= 'val' ( ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) ) ) ( (lv_attr_2_0= ruleName ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExp ) ) ) | (otherlv_5= 'val' ( (lv_name_6_0= ruleName ) ) otherlv_7= '[' ( (lv_decPat_8_0= ruleDecodePat ) )* otherlv_9= ']' ( (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) ) | (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+ ) ) ) ;
    public final EObject ruleDeclVal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_1_1 = null;

        AntlrDatatypeRuleToken lv_attr_2_0 = null;

        AntlrDatatypeRuleToken lv_exp_4_0 = null;

        AntlrDatatypeRuleToken lv_name_6_0 = null;

        EObject lv_decPat_8_0 = null;

        AntlrDatatypeRuleToken lv_exp_11_0 = null;

        AntlrDatatypeRuleToken lv_exps_13_0 = null;

        AntlrDatatypeRuleToken lv_exps_15_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:492:28: ( ( (otherlv_0= 'val' ( ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) ) ) ( (lv_attr_2_0= ruleName ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExp ) ) ) | (otherlv_5= 'val' ( (lv_name_6_0= ruleName ) ) otherlv_7= '[' ( (lv_decPat_8_0= ruleDecodePat ) )* otherlv_9= ']' ( (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) ) | (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+ ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:493:1: ( (otherlv_0= 'val' ( ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) ) ) ( (lv_attr_2_0= ruleName ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExp ) ) ) | (otherlv_5= 'val' ( (lv_name_6_0= ruleName ) ) otherlv_7= '[' ( (lv_decPat_8_0= ruleDecodePat ) )* otherlv_9= ']' ( (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) ) | (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+ ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:493:1: ( (otherlv_0= 'val' ( ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) ) ) ( (lv_attr_2_0= ruleName ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExp ) ) ) | (otherlv_5= 'val' ( (lv_name_6_0= ruleName ) ) otherlv_7= '[' ( (lv_decPat_8_0= ruleDecodePat ) )* otherlv_9= ']' ( (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) ) | (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+ ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_ID) ) {
                    int LA13_2 = input.LA(3);

                    if ( (LA13_2==RULE_ID||LA13_2==21) ) {
                        alt13=1;
                    }
                    else if ( (LA13_2==24) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA13_1==RULE_SYM) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:493:2: (otherlv_0= 'val' ( ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) ) ) ( (lv_attr_2_0= ruleName ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:493:2: (otherlv_0= 'val' ( ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) ) ) ( (lv_attr_2_0= ruleName ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:493:4: otherlv_0= 'val' ( ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) ) ) ( (lv_attr_2_0= ruleName ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExp ) )
                    {
                    otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleDeclVal1016); 

                        	newLeafNode(otherlv_0, grammarAccess.getDeclValAccess().getValKeyword_0_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:497:1: ( ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:498:1: ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:498:1: ( (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:499:1: (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:499:1: (lv_name_1_1= ruleName | lv_name_1_2= RULE_SYM )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==RULE_SYM) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:500:3: lv_name_1_1= ruleName
                            {
                             
                            	        newCompositeNode(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleName_in_ruleDeclVal1039);
                            lv_name_1_1=ruleName();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"name",
                                    		lv_name_1_1, 
                                    		"Name");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:515:8: lv_name_1_2= RULE_SYM
                            {
                            lv_name_1_2=(Token)match(input,RULE_SYM,FOLLOW_RULE_SYM_in_ruleDeclVal1054); 

                            			newLeafNode(lv_name_1_2, grammarAccess.getDeclValAccess().getNameSYMTerminalRuleCall_0_1_0_1()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getDeclValRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"name",
                                    		lv_name_1_2, 
                                    		"SYM");
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:533:2: ( (lv_attr_2_0= ruleName ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:534:1: (lv_attr_2_0= ruleName )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:534:1: (lv_attr_2_0= ruleName )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:535:3: lv_attr_2_0= ruleName
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getDeclValAccess().getAttrNameParserRuleCall_0_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleName_in_ruleDeclVal1083);
                    	    lv_attr_2_0=ruleName();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attr",
                    	            		lv_attr_2_0, 
                    	            		"Name");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleDeclVal1096); 

                        	newLeafNode(otherlv_3, grammarAccess.getDeclValAccess().getEqualsSignKeyword_0_3());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:555:1: ( (lv_exp_4_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:556:1: (lv_exp_4_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:556:1: (lv_exp_4_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:557:3: lv_exp_4_0= ruleExp
                    {
                     
                    	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1117);
                    lv_exp_4_0=ruleExp();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	        }
                           		set(
                           			current, 
                           			"exp",
                            		lv_exp_4_0, 
                            		"Exp");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:574:6: (otherlv_5= 'val' ( (lv_name_6_0= ruleName ) ) otherlv_7= '[' ( (lv_decPat_8_0= ruleDecodePat ) )* otherlv_9= ']' ( (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) ) | (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+ ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:574:6: (otherlv_5= 'val' ( (lv_name_6_0= ruleName ) ) otherlv_7= '[' ( (lv_decPat_8_0= ruleDecodePat ) )* otherlv_9= ']' ( (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) ) | (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+ ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:574:8: otherlv_5= 'val' ( (lv_name_6_0= ruleName ) ) otherlv_7= '[' ( (lv_decPat_8_0= ruleDecodePat ) )* otherlv_9= ']' ( (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) ) | (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+ )
                    {
                    otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleDeclVal1137); 

                        	newLeafNode(otherlv_5, grammarAccess.getDeclValAccess().getValKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:578:1: ( (lv_name_6_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:579:1: (lv_name_6_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:579:1: (lv_name_6_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:580:3: lv_name_6_0= ruleName
                    {
                     
                    	        newCompositeNode(grammarAccess.getDeclValAccess().getNameNameParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleName_in_ruleDeclVal1158);
                    lv_name_6_0=ruleName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_6_0, 
                            		"Name");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleDeclVal1170); 

                        	newLeafNode(otherlv_7, grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:600:1: ( (lv_decPat_8_0= ruleDecodePat ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID||LA10_0==33||(LA10_0>=36 && LA10_0<=38)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:601:1: (lv_decPat_8_0= ruleDecodePat )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:601:1: (lv_decPat_8_0= ruleDecodePat )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:602:3: lv_decPat_8_0= ruleDecodePat
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getDeclValAccess().getDecPatDecodePatParserRuleCall_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleDecodePat_in_ruleDeclVal1191);
                    	    lv_decPat_8_0=ruleDecodePat();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"decPat",
                    	            		lv_decPat_8_0, 
                    	            		"DecodePat");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,26,FOLLOW_26_in_ruleDeclVal1204); 

                        	newLeafNode(otherlv_9, grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_4());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:622:1: ( (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) ) | (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+ )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==21) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==28) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:622:2: (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:622:2: (otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:622:4: otherlv_10= '=' ( (lv_exp_11_0= ruleExp ) )
                            {
                            otherlv_10=(Token)match(input,21,FOLLOW_21_in_ruleDeclVal1218); 

                                	newLeafNode(otherlv_10, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_0_0());
                                
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:626:1: ( (lv_exp_11_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:627:1: (lv_exp_11_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:627:1: (lv_exp_11_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:628:3: lv_exp_11_0= ruleExp
                            {
                             
                            	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_5_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1239);
                            lv_exp_11_0=ruleExp();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"exp",
                                    		lv_exp_11_0, 
                                    		"Exp");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:645:6: (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:645:6: (otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) ) )+
                            int cnt11=0;
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==28) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:645:8: otherlv_12= '|' ( (lv_exps_13_0= ruleExp ) ) otherlv_14= '=' ( (lv_exps_15_0= ruleExp ) )
                            	    {
                            	    otherlv_12=(Token)match(input,28,FOLLOW_28_in_ruleDeclVal1259); 

                            	        	newLeafNode(otherlv_12, grammarAccess.getDeclValAccess().getVerticalLineKeyword_1_5_1_0());
                            	        
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:649:1: ( (lv_exps_13_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:650:1: (lv_exps_13_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:650:1: (lv_exps_13_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:651:3: lv_exps_13_0= ruleExp
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1280);
                            	    lv_exps_13_0=ruleExp();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"exps",
                            	            		lv_exps_13_0, 
                            	            		"Exp");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }

                            	    otherlv_14=(Token)match(input,21,FOLLOW_21_in_ruleDeclVal1292); 

                            	        	newLeafNode(otherlv_14, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_5_1_2());
                            	        
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:671:1: ( (lv_exps_15_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:672:1: (lv_exps_15_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:672:1: (lv_exps_15_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:673:3: lv_exps_15_0= ruleExp
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_5_1_3_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1313);
                            	    lv_exps_15_0=ruleExp();

                            	    state._fsp--;


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
                            	    break;

                            	default :
                            	    if ( cnt11 >= 1 ) break loop11;
                                        EarlyExitException eee =
                                            new EarlyExitException(11, input);
                                        throw eee;
                                }
                                cnt11++;
                            } while (true);


                            }
                            break;

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
    // $ANTLR end "ruleDeclVal"


    // $ANTLR start "entryRuleExport"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:697:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:698:2: (iv_ruleExport= ruleExport EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:699:2: iv_ruleExport= ruleExport EOF
            {
             newCompositeNode(grammarAccess.getExportRule()); 
            pushFollow(FOLLOW_ruleExport_in_entryRuleExport1353);
            iv_ruleExport=ruleExport();

            state._fsp--;

             current =iv_ruleExport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExport1363); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:706:1: ruleExport returns [EObject current=null] : ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:709:28: ( ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:710:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:710:1: ( ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:710:2: ( (lv_name_0_0= ruleQid ) ) (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:710:2: ( (lv_name_0_0= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:711:1: (lv_name_0_0= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:711:1: (lv_name_0_0= ruleQid )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:712:3: lv_name_0_0= ruleQid
            {
             
            	        newCompositeNode(grammarAccess.getExportAccess().getNameQidParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQid_in_ruleExport1409);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:728:2: (otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==29) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:728:4: otherlv_1= '{' ( (lv_attrName_2_0= ruleName ) ) (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleExport1422); 

                        	newLeafNode(otherlv_1, grammarAccess.getExportAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:732:1: ( (lv_attrName_2_0= ruleName ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:733:1: (lv_attrName_2_0= ruleName )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:733:1: (lv_attrName_2_0= ruleName )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:734:3: lv_attrName_2_0= ruleName
                    {
                     
                    	        newCompositeNode(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleName_in_ruleExport1443);
                    lv_attrName_2_0=ruleName();

                    state._fsp--;


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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:750:2: (otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==25) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:750:4: otherlv_3= ',' ( (lv_attrName_4_0= ruleName ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleExport1456); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getExportAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:754:1: ( (lv_attrName_4_0= ruleName ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:755:1: (lv_attrName_4_0= ruleName )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:755:1: (lv_attrName_4_0= ruleName )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:756:3: lv_attrName_4_0= ruleName
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getExportAccess().getAttrNameNameParserRuleCall_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleName_in_ruleExport1477);
                    	    lv_attrName_4_0=ruleName();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleExport1491); 

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:784:1: entryRuleConDecls returns [EObject current=null] : iv_ruleConDecls= ruleConDecls EOF ;
    public final EObject entryRuleConDecls() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecls = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:785:2: (iv_ruleConDecls= ruleConDecls EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:786:2: iv_ruleConDecls= ruleConDecls EOF
            {
             newCompositeNode(grammarAccess.getConDeclsRule()); 
            pushFollow(FOLLOW_ruleConDecls_in_entryRuleConDecls1529);
            iv_ruleConDecls=ruleConDecls();

            state._fsp--;

             current =iv_ruleConDecls; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecls1539); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:793:1: ruleConDecls returns [EObject current=null] : ( ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )* ) ;
    public final EObject ruleConDecls() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_conDecls_0_0 = null;

        EObject lv_conDecls_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:796:28: ( ( ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:797:1: ( ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:797:1: ( ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:797:2: ( (lv_conDecls_0_0= ruleConDecl ) ) (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:797:2: ( (lv_conDecls_0_0= ruleConDecl ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:798:1: (lv_conDecls_0_0= ruleConDecl )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:798:1: (lv_conDecls_0_0= ruleConDecl )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:799:3: lv_conDecls_0_0= ruleConDecl
            {
             
            	        newCompositeNode(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConDecl_in_ruleConDecls1585);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:815:2: (otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==28) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:815:4: otherlv_1= '|' ( (lv_conDecls_2_0= ruleConDecl ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleConDecls1598); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConDeclsAccess().getVerticalLineKeyword_1_0());
            	        
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:819:1: ( (lv_conDecls_2_0= ruleConDecl ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:820:1: (lv_conDecls_2_0= ruleConDecl )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:820:1: (lv_conDecls_2_0= ruleConDecl )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:821:3: lv_conDecls_2_0= ruleConDecl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConDeclsAccess().getConDeclsConDeclParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConDecl_in_ruleConDecls1619);
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
            	    break loop16;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:845:1: entryRuleConDecl returns [EObject current=null] : iv_ruleConDecl= ruleConDecl EOF ;
    public final EObject entryRuleConDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:846:2: (iv_ruleConDecl= ruleConDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:847:2: iv_ruleConDecl= ruleConDecl EOF
            {
             newCompositeNode(grammarAccess.getConDeclRule()); 
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl1657);
            iv_ruleConDecl=ruleConDecl();

            state._fsp--;

             current =iv_ruleConDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl1667); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:854:1: ruleConDecl returns [EObject current=null] : ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleConDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ty_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:857:28: ( ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:858:1: ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:858:1: ( ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:858:2: ( (lv_name_0_0= ruleConBind ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:858:2: ( (lv_name_0_0= ruleConBind ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:859:1: (lv_name_0_0= ruleConBind )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:859:1: (lv_name_0_0= ruleConBind )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:860:3: lv_name_0_0= ruleConBind
            {
             
            	        newCompositeNode(grammarAccess.getConDeclAccess().getNameConBindParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConBind_in_ruleConDecl1713);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:876:2: (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==31) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:876:4: otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleConDecl1726); 

                        	newLeafNode(otherlv_1, grammarAccess.getConDeclAccess().getOfKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:880:1: ( (lv_ty_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:881:1: (lv_ty_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:881:1: (lv_ty_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:882:3: lv_ty_2_0= ruleTy
                    {
                     
                    	        newCompositeNode(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTy_in_ruleConDecl1747);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:906:1: entryRuleTy returns [EObject current=null] : iv_ruleTy= ruleTy EOF ;
    public final EObject entryRuleTy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTy = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:907:2: (iv_ruleTy= ruleTy EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:908:2: iv_ruleTy= ruleTy EOF
            {
             newCompositeNode(grammarAccess.getTyRule()); 
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy1785);
            iv_ruleTy=ruleTy();

            state._fsp--;

             current =iv_ruleTy; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy1795); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:915:1: ruleTy returns [EObject current=null] : ( ( (lv_value_0_0= ruleInt ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:918:28: ( ( ( (lv_value_0_0= ruleInt ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:919:1: ( ( (lv_value_0_0= ruleInt ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:919:1: ( ( (lv_value_0_0= ruleInt ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' ) | ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? ) | (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' ) )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 36:
            case 37:
            case 38:
                {
                alt21=1;
                }
                break;
            case 28:
                {
                alt21=2;
                }
                break;
            case RULE_ID:
                {
                alt21=3;
                }
                break;
            case 29:
                {
                alt21=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:919:2: ( (lv_value_0_0= ruleInt ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:919:2: ( (lv_value_0_0= ruleInt ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:920:1: (lv_value_0_0= ruleInt )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:920:1: (lv_value_0_0= ruleInt )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:921:3: lv_value_0_0= ruleInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyAccess().getValueIntParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInt_in_ruleTy1841);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:938:6: (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:938:6: (otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:938:8: otherlv_1= '|' ( (lv_value_2_0= ruleInt ) ) otherlv_3= '|'
                    {
                    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleTy1860); 

                        	newLeafNode(otherlv_1, grammarAccess.getTyAccess().getVerticalLineKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:942:1: ( (lv_value_2_0= ruleInt ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:943:1: (lv_value_2_0= ruleInt )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:943:1: (lv_value_2_0= ruleInt )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:944:3: lv_value_2_0= ruleInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyAccess().getValueIntParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInt_in_ruleTy1881);
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

                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleTy1893); 

                        	newLeafNode(otherlv_3, grammarAccess.getTyAccess().getVerticalLineKeyword_1_2());
                        

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:965:6: ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:965:6: ( ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:965:7: ( (lv_value_4_0= ruleQid ) ) (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:965:7: ( (lv_value_4_0= ruleQid ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:966:1: (lv_value_4_0= ruleQid )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:966:1: (lv_value_4_0= ruleQid )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:967:3: lv_value_4_0= ruleQid
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyAccess().getValueQidParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQid_in_ruleTy1922);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:983:2: (otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']' )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==24) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:983:4: otherlv_5= '[' ( (lv_tyBind_6_0= ruleTyBind ) ) (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )* otherlv_9= ']'
                            {
                            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleTy1935); 

                                	newLeafNode(otherlv_5, grammarAccess.getTyAccess().getLeftSquareBracketKeyword_2_1_0());
                                
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:987:1: ( (lv_tyBind_6_0= ruleTyBind ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:988:1: (lv_tyBind_6_0= ruleTyBind )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:988:1: (lv_tyBind_6_0= ruleTyBind )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:989:3: lv_tyBind_6_0= ruleTyBind
                            {
                             
                            	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleTyBind_in_ruleTy1956);
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1005:2: (otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) ) )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==25) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1005:4: otherlv_7= ',' ( (lv_tyBind_8_0= ruleTyBind ) )
                            	    {
                            	    otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleTy1969); 

                            	        	newLeafNode(otherlv_7, grammarAccess.getTyAccess().getCommaKeyword_2_1_2_0());
                            	        
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1009:1: ( (lv_tyBind_8_0= ruleTyBind ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1010:1: (lv_tyBind_8_0= ruleTyBind )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1010:1: (lv_tyBind_8_0= ruleTyBind )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1011:3: lv_tyBind_8_0= ruleTyBind
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_2_1_2_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleTyBind_in_ruleTy1990);
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
                            	    break loop18;
                                }
                            } while (true);

                            otherlv_9=(Token)match(input,26,FOLLOW_26_in_ruleTy2004); 

                                	newLeafNode(otherlv_9, grammarAccess.getTyAccess().getRightSquareBracketKeyword_2_1_3());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1032:6: (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1032:6: (otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1032:8: otherlv_10= '{' ( (lv_elements_11_0= ruleTyElement ) ) (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )* otherlv_14= '}'
                    {
                    otherlv_10=(Token)match(input,29,FOLLOW_29_in_ruleTy2026); 

                        	newLeafNode(otherlv_10, grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1036:1: ( (lv_elements_11_0= ruleTyElement ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1037:1: (lv_elements_11_0= ruleTyElement )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1037:1: (lv_elements_11_0= ruleTyElement )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1038:3: lv_elements_11_0= ruleTyElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2047);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:2: (otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==25) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:4: otherlv_12= ',' ( (lv_elements_13_0= ruleTyElement ) )
                    	    {
                    	    otherlv_12=(Token)match(input,25,FOLLOW_25_in_ruleTy2060); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getTyAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1058:1: ( (lv_elements_13_0= ruleTyElement ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1059:1: (lv_elements_13_0= ruleTyElement )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1059:1: (lv_elements_13_0= ruleTyElement )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1060:3: lv_elements_13_0= ruleTyElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2081);
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
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,30,FOLLOW_30_in_ruleTy2095); 

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1088:1: entryRuleTyElement returns [EObject current=null] : iv_ruleTyElement= ruleTyElement EOF ;
    public final EObject entryRuleTyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyElement = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1089:2: (iv_ruleTyElement= ruleTyElement EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1090:2: iv_ruleTyElement= ruleTyElement EOF
            {
             newCompositeNode(grammarAccess.getTyElementRule()); 
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement2132);
            iv_ruleTyElement=ruleTyElement();

            state._fsp--;

             current =iv_ruleTyElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement2142); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1097:1: ruleTyElement returns [EObject current=null] : ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) ;
    public final EObject ruleTyElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1100:28: ( ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1101:1: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1101:1: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1101:2: ( (lv_name_0_0= ruleName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1101:2: ( (lv_name_0_0= ruleName ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1102:1: (lv_name_0_0= ruleName )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1102:1: (lv_name_0_0= ruleName )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1103:3: lv_name_0_0= ruleName
            {
             
            	        newCompositeNode(grammarAccess.getTyElementAccess().getNameNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleName_in_ruleTyElement2188);
            lv_name_0_0=ruleName();

            state._fsp--;


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

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleTyElement2200); 

                	newLeafNode(otherlv_1, grammarAccess.getTyElementAccess().getColonKeyword_1());
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1123:1: ( (lv_value_2_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1124:1: (lv_value_2_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1124:1: (lv_value_2_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1125:3: lv_value_2_0= ruleTy
            {
             
            	        newCompositeNode(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTy_in_ruleTyElement2221);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1149:1: entryRuleTyBind returns [EObject current=null] : iv_ruleTyBind= ruleTyBind EOF ;
    public final EObject entryRuleTyBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1150:2: (iv_ruleTyBind= ruleTyBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1151:2: iv_ruleTyBind= ruleTyBind EOF
            {
             newCompositeNode(grammarAccess.getTyBindRule()); 
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind2257);
            iv_ruleTyBind=ruleTyBind();

            state._fsp--;

             current =iv_ruleTyBind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind2267); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1158:1: ruleTyBind returns [EObject current=null] : ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleTyBind() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1161:28: ( ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1162:1: ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1162:1: ( ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1162:2: ( (lv_key_0_0= ruleQid ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1162:2: ( (lv_key_0_0= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1163:1: (lv_key_0_0= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1163:1: (lv_key_0_0= ruleQid )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1164:3: lv_key_0_0= ruleQid
            {
             
            	        newCompositeNode(grammarAccess.getTyBindAccess().getKeyQidParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQid_in_ruleTyBind2313);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1180:2: (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==21) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1180:4: otherlv_1= '=' ( (lv_value_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleTyBind2326); 

                        	newLeafNode(otherlv_1, grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0());
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1184:1: ( (lv_value_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1185:1: (lv_value_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1185:1: (lv_value_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1186:3: lv_value_2_0= ruleTy
                    {
                     
                    	        newCompositeNode(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTy_in_ruleTyBind2347);
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


    // $ANTLR start "entryRuleDecodePat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1210:1: entryRuleDecodePat returns [EObject current=null] : iv_ruleDecodePat= ruleDecodePat EOF ;
    public final EObject entryRuleDecodePat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecodePat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1211:2: (iv_ruleDecodePat= ruleDecodePat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1212:2: iv_ruleDecodePat= ruleDecodePat EOF
            {
             newCompositeNode(grammarAccess.getDecodePatRule()); 
            pushFollow(FOLLOW_ruleDecodePat_in_entryRuleDecodePat2385);
            iv_ruleDecodePat=ruleDecodePat();

            state._fsp--;

             current =iv_ruleDecodePat; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecodePat2395); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1219:1: ruleDecodePat returns [EObject current=null] : (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat ) ;
    public final EObject ruleDecodePat() throws RecognitionException {
        EObject current = null;

        EObject this_BitPat_0 = null;

        EObject this_TokPat_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1222:28: ( (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1223:1: (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1223:1: (this_BitPat_0= ruleBitPat | this_TokPat_1= ruleTokPat )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_ID||(LA23_0>=36 && LA23_0<=38)) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1224:5: this_BitPat_0= ruleBitPat
                    {
                     
                            newCompositeNode(grammarAccess.getDecodePatAccess().getBitPatParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBitPat_in_ruleDecodePat2442);
                    this_BitPat_0=ruleBitPat();

                    state._fsp--;

                     
                            current = this_BitPat_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1234:5: this_TokPat_1= ruleTokPat
                    {
                     
                            newCompositeNode(grammarAccess.getDecodePatAccess().getTokPatParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTokPat_in_ruleDecodePat2469);
                    this_TokPat_1=ruleTokPat();

                    state._fsp--;

                     
                            current = this_TokPat_1; 
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
    // $ANTLR end "ruleDecodePat"


    // $ANTLR start "entryRuleBitPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1250:1: entryRuleBitPat returns [EObject current=null] : iv_ruleBitPat= ruleBitPat EOF ;
    public final EObject entryRuleBitPat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1251:2: (iv_ruleBitPat= ruleBitPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1252:2: iv_ruleBitPat= ruleBitPat EOF
            {
             newCompositeNode(grammarAccess.getBitPatRule()); 
            pushFollow(FOLLOW_ruleBitPat_in_entryRuleBitPat2504);
            iv_ruleBitPat=ruleBitPat();

            state._fsp--;

             current =iv_ruleBitPat; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPat2514); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1259:1: ruleBitPat returns [EObject current=null] : (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) (otherlv_2= ',' ( (lv_bitpat_3_0= rulePrimBitPat ) ) )* otherlv_4= '\\'' ) ;
    public final EObject ruleBitPat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_bitpat_1_0 = null;

        AntlrDatatypeRuleToken lv_bitpat_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1262:28: ( (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) (otherlv_2= ',' ( (lv_bitpat_3_0= rulePrimBitPat ) ) )* otherlv_4= '\\'' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1263:1: (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) (otherlv_2= ',' ( (lv_bitpat_3_0= rulePrimBitPat ) ) )* otherlv_4= '\\'' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1263:1: (otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) (otherlv_2= ',' ( (lv_bitpat_3_0= rulePrimBitPat ) ) )* otherlv_4= '\\'' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1263:3: otherlv_0= '\\'' ( (lv_bitpat_1_0= rulePrimBitPat ) ) (otherlv_2= ',' ( (lv_bitpat_3_0= rulePrimBitPat ) ) )* otherlv_4= '\\''
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleBitPat2551); 

                	newLeafNode(otherlv_0, grammarAccess.getBitPatAccess().getApostropheKeyword_0());
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1267:1: ( (lv_bitpat_1_0= rulePrimBitPat ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1268:1: (lv_bitpat_1_0= rulePrimBitPat )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1268:1: (lv_bitpat_1_0= rulePrimBitPat )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1269:3: lv_bitpat_1_0= rulePrimBitPat
            {
             
            	        newCompositeNode(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulePrimBitPat_in_ruleBitPat2572);
            lv_bitpat_1_0=rulePrimBitPat();

            state._fsp--;


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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1285:2: (otherlv_2= ',' ( (lv_bitpat_3_0= rulePrimBitPat ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==25) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1285:4: otherlv_2= ',' ( (lv_bitpat_3_0= rulePrimBitPat ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleBitPat2585); 

            	        	newLeafNode(otherlv_2, grammarAccess.getBitPatAccess().getCommaKeyword_2_0());
            	        
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1289:1: ( (lv_bitpat_3_0= rulePrimBitPat ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1290:1: (lv_bitpat_3_0= rulePrimBitPat )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1290:1: (lv_bitpat_3_0= rulePrimBitPat )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1291:3: lv_bitpat_3_0= rulePrimBitPat
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBitPatAccess().getBitpatPrimBitPatParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePrimBitPat_in_ruleBitPat2606);
            	    lv_bitpat_3_0=rulePrimBitPat();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBitPatRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bitpat",
            	            		lv_bitpat_3_0, 
            	            		"PrimBitPat");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleBitPat2620); 

                	newLeafNode(otherlv_4, grammarAccess.getBitPatAccess().getApostropheKeyword_3());
                

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
    // $ANTLR end "ruleBitPat"


    // $ANTLR start "entryRuleTokPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1319:1: entryRuleTokPat returns [EObject current=null] : iv_ruleTokPat= ruleTokPat EOF ;
    public final EObject entryRuleTokPat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTokPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1320:2: (iv_ruleTokPat= ruleTokPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1321:2: iv_ruleTokPat= ruleTokPat EOF
            {
             newCompositeNode(grammarAccess.getTokPatRule()); 
            pushFollow(FOLLOW_ruleTokPat_in_entryRuleTokPat2656);
            iv_ruleTokPat=ruleTokPat();

            state._fsp--;

             current =iv_ruleTokPat; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTokPat2666); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1328:1: ruleTokPat returns [EObject current=null] : ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) ) ;
    public final EObject ruleTokPat() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_tokPat_0_1 = null;

        AntlrDatatypeRuleToken lv_tokPat_0_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1331:28: ( ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:1: ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:1: ( ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1333:1: ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1333:1: ( (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1334:1: (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1334:1: (lv_tokPat_0_1= ruleInt | lv_tokPat_0_2= ruleQid )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=36 && LA25_0<=38)) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ID) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1335:3: lv_tokPat_0_1= ruleInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getTokPatAccess().getTokPatIntParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInt_in_ruleTokPat2713);
                    lv_tokPat_0_1=ruleInt();

                    state._fsp--;


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
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1350:8: lv_tokPat_0_2= ruleQid
                    {
                     
                    	        newCompositeNode(grammarAccess.getTokPatAccess().getTokPatQidParserRuleCall_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleQid_in_ruleTokPat2732);
                    lv_tokPat_0_2=ruleQid();

                    state._fsp--;


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
                    break;

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
    // $ANTLR end "ruleTokPat"


    // $ANTLR start "entryRulePrimBitPat"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1376:1: entryRulePrimBitPat returns [String current=null] : iv_rulePrimBitPat= rulePrimBitPat EOF ;
    public final String entryRulePrimBitPat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimBitPat = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1377:2: (iv_rulePrimBitPat= rulePrimBitPat EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1378:2: iv_rulePrimBitPat= rulePrimBitPat EOF
            {
             newCompositeNode(grammarAccess.getPrimBitPatRule()); 
            pushFollow(FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat2771);
            iv_rulePrimBitPat=rulePrimBitPat();

            state._fsp--;

             current =iv_rulePrimBitPat.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimBitPat2782); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1385:1: rulePrimBitPat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BITSTR_0= ruleBITSTR | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) ) ;
    public final AntlrDatatypeRuleToken rulePrimBitPat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BITSTR_0 = null;

        AntlrDatatypeRuleToken this_Qid_1 = null;

        AntlrDatatypeRuleToken this_BitPatOrInt_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1388:28: ( (this_BITSTR_0= ruleBITSTR | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1389:1: (this_BITSTR_0= ruleBITSTR | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1389:1: (this_BITSTR_0= ruleBITSTR | (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_BINARY) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_ID) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1390:5: this_BITSTR_0= ruleBITSTR
                    {
                     
                            newCompositeNode(grammarAccess.getPrimBitPatAccess().getBITSTRParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBITSTR_in_rulePrimBitPat2829);
                    this_BITSTR_0=ruleBITSTR();

                    state._fsp--;


                    		current.merge(this_BITSTR_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1401:6: (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1401:6: (this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1402:5: this_Qid_1= ruleQid (this_BitPatOrInt_2= ruleBitPatOrInt )?
                    {
                     
                            newCompositeNode(grammarAccess.getPrimBitPatAccess().getQidParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleQid_in_rulePrimBitPat2863);
                    this_Qid_1=ruleQid();

                    state._fsp--;


                    		current.merge(this_Qid_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1412:1: (this_BitPatOrInt_2= ruleBitPatOrInt )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==32||LA26_0==34) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1413:5: this_BitPatOrInt_2= ruleBitPatOrInt
                            {
                             
                                    newCompositeNode(grammarAccess.getPrimBitPatAccess().getBitPatOrIntParserRuleCall_1_1()); 
                                
                            pushFollow(FOLLOW_ruleBitPatOrInt_in_rulePrimBitPat2891);
                            this_BitPatOrInt_2=ruleBitPatOrInt();

                            state._fsp--;


                            		current.merge(this_BitPatOrInt_2);
                                
                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

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
    // $ANTLR end "rulePrimBitPat"


    // $ANTLR start "entryRuleBitPatOrInt"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1431:1: entryRuleBitPatOrInt returns [String current=null] : iv_ruleBitPatOrInt= ruleBitPatOrInt EOF ;
    public final String entryRuleBitPatOrInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitPatOrInt = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1432:2: (iv_ruleBitPatOrInt= ruleBitPatOrInt EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1433:2: iv_ruleBitPatOrInt= ruleBitPatOrInt EOF
            {
             newCompositeNode(grammarAccess.getBitPatOrIntRule()); 
            pushFollow(FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt2940);
            iv_ruleBitPatOrInt=ruleBitPatOrInt();

            state._fsp--;

             current =iv_ruleBitPatOrInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitPatOrInt2951); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1440:1: ruleBitPatOrInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) ) ;
    public final AntlrDatatypeRuleToken ruleBitPatOrInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_POSINT_1 = null;

        AntlrDatatypeRuleToken this_BITSTR_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1443:28: ( ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1444:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1444:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BITSTR_3= ruleBITSTR ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==32) ) {
                alt28=1;
            }
            else if ( (LA28_0==34) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1444:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1444:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1445:2: kw= ':' this_POSINT_1= rulePOSINT
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleBitPatOrInt2990); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBitPatOrIntAccess().getColonKeyword_0_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getBitPatOrIntAccess().getPOSINTParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_rulePOSINT_in_ruleBitPatOrInt3012);
                    this_POSINT_1=rulePOSINT();

                    state._fsp--;


                    		current.merge(this_POSINT_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1462:6: (kw= '@' this_BITSTR_3= ruleBITSTR )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1462:6: (kw= '@' this_BITSTR_3= ruleBITSTR )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1463:2: kw= '@' this_BITSTR_3= ruleBITSTR
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleBitPatOrInt3038); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBitPatOrIntAccess().getCommercialAtKeyword_1_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getBitPatOrIntAccess().getBITSTRParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleBITSTR_in_ruleBitPatOrInt3060);
                    this_BITSTR_3=ruleBITSTR();

                    state._fsp--;


                    		current.merge(this_BITSTR_3);
                        
                     
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleBitPatOrInt"


    // $ANTLR start "entryRuleExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1487:1: entryRuleExp returns [String current=null] : iv_ruleExp= ruleExp EOF ;
    public final String entryRuleExp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1488:2: (iv_ruleExp= ruleExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1489:2: iv_ruleExp= ruleExp EOF
            {
             newCompositeNode(grammarAccess.getExpRule()); 
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp3107);
            iv_ruleExp=ruleExp();

            state._fsp--;

             current =iv_ruleExp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp3118); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1496:1: ruleExp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'exptodo' ;
    public final AntlrDatatypeRuleToken ruleExp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1499:28: (kw= 'exptodo' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1501:2: kw= 'exptodo'
            {
            kw=(Token)match(input,35,FOLLOW_35_in_ruleExp3155); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getExpAccess().getExptodoKeyword()); 
                

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
    // $ANTLR end "ruleExp"


    // $ANTLR start "entryRuleInt"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1514:1: entryRuleInt returns [String current=null] : iv_ruleInt= ruleInt EOF ;
    public final String entryRuleInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInt = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1515:2: (iv_ruleInt= ruleInt EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1516:2: iv_ruleInt= ruleInt EOF
            {
             newCompositeNode(grammarAccess.getIntRule()); 
            pushFollow(FOLLOW_ruleInt_in_entryRuleInt3195);
            iv_ruleInt=ruleInt();

            state._fsp--;

             current =iv_ruleInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInt3206); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1523:1: ruleInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT ) ;
    public final AntlrDatatypeRuleToken ruleInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_POSINT_0 = null;

        AntlrDatatypeRuleToken this_NEGINT_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1526:28: ( (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1527:1: (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1527:1: (this_POSINT_0= rulePOSINT | this_NEGINT_1= ruleNEGINT )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==36||LA29_0==38) ) {
                alt29=1;
            }
            else if ( (LA29_0==37) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1528:5: this_POSINT_0= rulePOSINT
                    {
                     
                            newCompositeNode(grammarAccess.getIntAccess().getPOSINTParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePOSINT_in_ruleInt3253);
                    this_POSINT_0=rulePOSINT();

                    state._fsp--;


                    		current.merge(this_POSINT_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1540:5: this_NEGINT_1= ruleNEGINT
                    {
                     
                            newCompositeNode(grammarAccess.getIntAccess().getNEGINTParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNEGINT_in_ruleInt3286);
                    this_NEGINT_1=ruleNEGINT();

                    state._fsp--;


                    		current.merge(this_NEGINT_1);
                        
                     
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
    // $ANTLR end "ruleInt"


    // $ANTLR start "entryRuleName"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1558:1: entryRuleName returns [String current=null] : iv_ruleName= ruleName EOF ;
    public final String entryRuleName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleName = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1559:2: (iv_ruleName= ruleName EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1560:2: iv_ruleName= ruleName EOF
            {
             newCompositeNode(grammarAccess.getNameRule()); 
            pushFollow(FOLLOW_ruleName_in_entryRuleName3332);
            iv_ruleName=ruleName();

            state._fsp--;

             current =iv_ruleName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleName3343); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1567:1: ruleName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1570:28: (this_ID_0= RULE_ID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1571:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleName3382); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getNameAccess().getIDTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleName"


    // $ANTLR start "entryRuleConBind"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1586:1: entryRuleConBind returns [String current=null] : iv_ruleConBind= ruleConBind EOF ;
    public final String entryRuleConBind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1587:2: (iv_ruleConBind= ruleConBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1588:2: iv_ruleConBind= ruleConBind EOF
            {
             newCompositeNode(grammarAccess.getConBindRule()); 
            pushFollow(FOLLOW_ruleConBind_in_entryRuleConBind3427);
            iv_ruleConBind=ruleConBind();

            state._fsp--;

             current =iv_ruleConBind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConBind3438); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1595:1: ruleConBind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_CONS_0= ruleCONS ;
    public final AntlrDatatypeRuleToken ruleConBind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_CONS_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1598:28: (this_CONS_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1600:5: this_CONS_0= ruleCONS
            {
             
                    newCompositeNode(grammarAccess.getConBindAccess().getCONSParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleCONS_in_ruleConBind3484);
            this_CONS_0=ruleCONS();

            state._fsp--;


            		current.merge(this_CONS_0);
                
             
                    afterParserOrEnumRuleCall();
                

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


    // $ANTLR start "entryRuleQid"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1620:1: entryRuleQid returns [String current=null] : iv_ruleQid= ruleQid EOF ;
    public final String entryRuleQid() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQid = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1621:2: (iv_ruleQid= ruleQid EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1622:2: iv_ruleQid= ruleQid EOF
            {
             newCompositeNode(grammarAccess.getQidRule()); 
            pushFollow(FOLLOW_ruleQid_in_entryRuleQid3531);
            iv_ruleQid=ruleQid();

            state._fsp--;

             current =iv_ruleQid.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQid3542); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1629:1: ruleQid returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleQid() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1632:28: (this_ID_0= RULE_ID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1633:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQid3581); 

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


    // $ANTLR start "entryRulePOSINT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1648:1: entryRulePOSINT returns [String current=null] : iv_rulePOSINT= rulePOSINT EOF ;
    public final String entryRulePOSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePOSINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1649:2: (iv_rulePOSINT= rulePOSINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1650:2: iv_rulePOSINT= rulePOSINT EOF
            {
             newCompositeNode(grammarAccess.getPOSINTRule()); 
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT3626);
            iv_rulePOSINT=rulePOSINT();

            state._fsp--;

             current =iv_rulePOSINT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT3637); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1657:1: rulePOSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' this_NUM_1= ruleNUM ) | this_HEXNUM_2= ruleHEXNUM ) ;
    public final AntlrDatatypeRuleToken rulePOSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_NUM_1 = null;

        AntlrDatatypeRuleToken this_HEXNUM_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1660:28: ( ( (kw= '+' this_NUM_1= ruleNUM ) | this_HEXNUM_2= ruleHEXNUM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1661:1: ( (kw= '+' this_NUM_1= ruleNUM ) | this_HEXNUM_2= ruleHEXNUM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1661:1: ( (kw= '+' this_NUM_1= ruleNUM ) | this_HEXNUM_2= ruleHEXNUM )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            else if ( (LA30_0==38) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1661:2: (kw= '+' this_NUM_1= ruleNUM )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1661:2: (kw= '+' this_NUM_1= ruleNUM )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1662:2: kw= '+' this_NUM_1= ruleNUM
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_rulePOSINT3676); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPOSINTAccess().getPlusSignKeyword_0_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getPOSINTAccess().getNUMParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleNUM_in_rulePOSINT3698);
                    this_NUM_1=ruleNUM();

                    state._fsp--;


                    		current.merge(this_NUM_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1680:5: this_HEXNUM_2= ruleHEXNUM
                    {
                     
                            newCompositeNode(grammarAccess.getPOSINTAccess().getHEXNUMParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHEXNUM_in_rulePOSINT3732);
                    this_HEXNUM_2=ruleHEXNUM();

                    state._fsp--;


                    		current.merge(this_HEXNUM_2);
                        
                     
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
    // $ANTLR end "rulePOSINT"


    // $ANTLR start "entryRuleNEGINT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1698:1: entryRuleNEGINT returns [String current=null] : iv_ruleNEGINT= ruleNEGINT EOF ;
    public final String entryRuleNEGINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNEGINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1699:2: (iv_ruleNEGINT= ruleNEGINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1700:2: iv_ruleNEGINT= ruleNEGINT EOF
            {
             newCompositeNode(grammarAccess.getNEGINTRule()); 
            pushFollow(FOLLOW_ruleNEGINT_in_entryRuleNEGINT3778);
            iv_ruleNEGINT=ruleNEGINT();

            state._fsp--;

             current =iv_ruleNEGINT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNEGINT3789); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1707:1: ruleNEGINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '~' this_NUM_1= ruleNUM ) ;
    public final AntlrDatatypeRuleToken ruleNEGINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_NUM_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1710:28: ( (kw= '~' this_NUM_1= ruleNUM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1711:1: (kw= '~' this_NUM_1= ruleNUM )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1711:1: (kw= '~' this_NUM_1= ruleNUM )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1712:2: kw= '~' this_NUM_1= ruleNUM
            {
            kw=(Token)match(input,37,FOLLOW_37_in_ruleNEGINT3827); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNEGINTAccess().getTildeKeyword_0()); 
                
             
                    newCompositeNode(grammarAccess.getNEGINTAccess().getNUMParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNUM_in_ruleNEGINT3849);
            this_NUM_1=ruleNUM();

            state._fsp--;


            		current.merge(this_NUM_1);
                
             
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleNEGINT"


    // $ANTLR start "entryRuleNUM"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1736:1: entryRuleNUM returns [String current=null] : iv_ruleNUM= ruleNUM EOF ;
    public final String entryRuleNUM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1737:2: (iv_ruleNUM= ruleNUM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1738:2: iv_ruleNUM= ruleNUM EOF
            {
             newCompositeNode(grammarAccess.getNUMRule()); 
            pushFollow(FOLLOW_ruleNUM_in_entryRuleNUM3895);
            iv_ruleNUM=ruleNUM();

            state._fsp--;

             current =iv_ruleNUM.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUM3906); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1745:1: ruleNUM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DIG_0= RULE_DIG )+ ;
    public final AntlrDatatypeRuleToken ruleNUM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DIG_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1748:28: ( (this_DIG_0= RULE_DIG )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1749:1: (this_DIG_0= RULE_DIG )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1749:1: (this_DIG_0= RULE_DIG )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_DIG) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1749:6: this_DIG_0= RULE_DIG
            	    {
            	    this_DIG_0=(Token)match(input,RULE_DIG,FOLLOW_RULE_DIG_in_ruleNUM3946); 

            	    		current.merge(this_DIG_0);
            	        
            	     
            	        newLeafNode(this_DIG_0, grammarAccess.getNUMAccess().getDIGTerminalRuleCall()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


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
    // $ANTLR end "ruleNUM"


    // $ANTLR start "entryRuleHEXNUM"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1764:1: entryRuleHEXNUM returns [String current=null] : iv_ruleHEXNUM= ruleHEXNUM EOF ;
    public final String entryRuleHEXNUM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHEXNUM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1765:2: (iv_ruleHEXNUM= ruleHEXNUM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1766:2: iv_ruleHEXNUM= ruleHEXNUM EOF
            {
             newCompositeNode(grammarAccess.getHEXNUMRule()); 
            pushFollow(FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM3993);
            iv_ruleHEXNUM=ruleHEXNUM();

            state._fsp--;

             current =iv_ruleHEXNUM.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHEXNUM4004); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1773:1: ruleHEXNUM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '0x' (this_HEXDIGIT_1= RULE_HEXDIGIT )+ ) ;
    public final AntlrDatatypeRuleToken ruleHEXNUM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_HEXDIGIT_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1776:28: ( (kw= '0x' (this_HEXDIGIT_1= RULE_HEXDIGIT )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1777:1: (kw= '0x' (this_HEXDIGIT_1= RULE_HEXDIGIT )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1777:1: (kw= '0x' (this_HEXDIGIT_1= RULE_HEXDIGIT )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1778:2: kw= '0x' (this_HEXDIGIT_1= RULE_HEXDIGIT )+
            {
            kw=(Token)match(input,38,FOLLOW_38_in_ruleHEXNUM4042); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getHEXNUMAccess().getXKeyword_0()); 
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1783:1: (this_HEXDIGIT_1= RULE_HEXDIGIT )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_HEXDIGIT) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1783:6: this_HEXDIGIT_1= RULE_HEXDIGIT
            	    {
            	    this_HEXDIGIT_1=(Token)match(input,RULE_HEXDIGIT,FOLLOW_RULE_HEXDIGIT_in_ruleHEXNUM4058); 

            	    		current.merge(this_HEXDIGIT_1);
            	        
            	     
            	        newLeafNode(this_HEXDIGIT_1, grammarAccess.getHEXNUMAccess().getHEXDIGITTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // $ANTLR end "ruleHEXNUM"


    // $ANTLR start "entryRuleBITSTR"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1800:1: entryRuleBITSTR returns [String current=null] : iv_ruleBITSTR= ruleBITSTR EOF ;
    public final String entryRuleBITSTR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITSTR = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1801:2: (iv_ruleBITSTR= ruleBITSTR EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1802:2: iv_ruleBITSTR= ruleBITSTR EOF
            {
             newCompositeNode(grammarAccess.getBITSTRRule()); 
            pushFollow(FOLLOW_ruleBITSTR_in_entryRuleBITSTR4108);
            iv_ruleBITSTR=ruleBITSTR();

            state._fsp--;

             current =iv_ruleBITSTR.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITSTR4119); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1809:1: ruleBITSTR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINARY_0= RULE_BINARY )+ ;
    public final AntlrDatatypeRuleToken ruleBITSTR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1812:28: ( (this_BINARY_0= RULE_BINARY )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1813:1: (this_BINARY_0= RULE_BINARY )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1813:1: (this_BINARY_0= RULE_BINARY )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_BINARY) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1813:6: this_BINARY_0= RULE_BINARY
            	    {
            	    this_BINARY_0=(Token)match(input,RULE_BINARY,FOLLOW_RULE_BINARY_in_ruleBITSTR4159); 

            	    		current.merge(this_BINARY_0);
            	        
            	     
            	        newLeafNode(this_BINARY_0, grammarAccess.getBITSTRAccess().getBINARYTerminalRuleCall()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


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
    // $ANTLR end "ruleBITSTR"


    // $ANTLR start "entryRuleCONS"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1830:1: entryRuleCONS returns [String current=null] : iv_ruleCONS= ruleCONS EOF ;
    public final String entryRuleCONS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCONS = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1831:2: (iv_ruleCONS= ruleCONS EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1832:2: iv_ruleCONS= ruleCONS EOF
            {
             newCompositeNode(grammarAccess.getCONSRule()); 
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS4208);
            iv_ruleCONS=ruleCONS();

            state._fsp--;

             current =iv_ruleCONS.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS4219); 

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:1: ruleCONS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CONSTART_0= RULE_CONSTART (this_IDCHAR_1= RULE_IDCHAR )* ) ;
    public final AntlrDatatypeRuleToken ruleCONS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CONSTART_0=null;
        Token this_IDCHAR_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1842:28: ( (this_CONSTART_0= RULE_CONSTART (this_IDCHAR_1= RULE_IDCHAR )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1843:1: (this_CONSTART_0= RULE_CONSTART (this_IDCHAR_1= RULE_IDCHAR )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1843:1: (this_CONSTART_0= RULE_CONSTART (this_IDCHAR_1= RULE_IDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1843:6: this_CONSTART_0= RULE_CONSTART (this_IDCHAR_1= RULE_IDCHAR )*
            {
            this_CONSTART_0=(Token)match(input,RULE_CONSTART,FOLLOW_RULE_CONSTART_in_ruleCONS4259); 

            		current.merge(this_CONSTART_0);
                
             
                newLeafNode(this_CONSTART_0, grammarAccess.getCONSAccess().getCONSTARTTerminalRuleCall_0()); 
                
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1850:1: (this_IDCHAR_1= RULE_IDCHAR )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_IDCHAR) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1850:6: this_IDCHAR_1= RULE_IDCHAR
            	    {
            	    this_IDCHAR_1=(Token)match(input,RULE_IDCHAR,FOLLOW_RULE_IDCHAR_in_ruleCONS4280); 

            	    		current.merge(this_IDCHAR_1);
            	        
            	     
            	        newLeafNode(this_IDCHAR_1, grammarAccess.getCONSAccess().getIDCHARTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // $ANTLR end "ruleCONS"

    // Delegated rules


 

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
    public static final BitSet FOLLOW_21_in_ruleDeclGranularity457 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_ruleInt_in_ruleDeclGranularity478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleDeclExport567 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclExport592 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleExport_in_ruleDeclExport613 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDeclType698 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType719 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclType731 = new BitSet(new long[]{0x0000007030000220L});
    public static final BitSet FOLLOW_ruleConDecls_in_ruleDeclType754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclType773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDeclType796 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType817 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDeclType829 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType850 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleDeclType863 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclType884 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleDeclType898 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclType910 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ruleConDecls_in_ruleDeclType931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDeclVal1016 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1039 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_RULE_SYM_in_ruleDeclVal1054 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1083 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1096 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDeclVal1137 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleName_in_ruleDeclVal1158 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDeclVal1170 = new BitSet(new long[]{0x0000007204000020L});
    public static final BitSet FOLLOW_ruleDecodePat_in_ruleDeclVal1191 = new BitSet(new long[]{0x0000007204000020L});
    public static final BitSet FOLLOW_26_in_ruleDeclVal1204 = new BitSet(new long[]{0x0000000010200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1218 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDeclVal1259 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1280 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleDeclVal1292 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1313 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleExport_in_entryRuleExport1353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExport1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleExport1409 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleExport1422 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleName_in_ruleExport1443 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_25_in_ruleExport1456 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleName_in_ruleExport1477 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_30_in_ruleExport1491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecls_in_entryRuleConDecls1529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecls1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleConDecls1585 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleConDecls1598 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleConDecls1619 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl1657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_ruleConDecl1713 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleConDecl1726 = new BitSet(new long[]{0x0000007030000220L});
    public static final BitSet FOLLOW_ruleTy_in_ruleConDecl1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy1785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTy1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTy1860 = new BitSet(new long[]{0x0000007000000000L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTy1881 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTy1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTy1922 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleTy1935 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy1956 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleTy1969 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy1990 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleTy2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTy2026 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2047 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_25_in_ruleTy2060 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2081 = new BitSet(new long[]{0x0000000042000000L});
    public static final BitSet FOLLOW_30_in_ruleTy2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement2132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleTyElement2188 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleTyElement2200 = new BitSet(new long[]{0x0000007030000220L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyElement2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind2257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTyBind2313 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleTyBind2326 = new BitSet(new long[]{0x0000007030000220L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyBind2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecodePat_in_entryRuleDecodePat2385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecodePat2395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_ruleDecodePat2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_ruleDecodePat2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPat_in_entryRuleBitPat2504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPat2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBitPat2551 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_ruleBitPat2572 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_25_in_ruleBitPat2585 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_ruleBitPat2606 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_ruleBitPat2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTokPat_in_entryRuleTokPat2656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTokPat2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_ruleTokPat2713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_ruleTokPat2732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimBitPat_in_entryRulePrimBitPat2771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimBitPat2782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITSTR_in_rulePrimBitPat2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_rulePrimBitPat2863 = new BitSet(new long[]{0x0000000500000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_rulePrimBitPat2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitPatOrInt_in_entryRuleBitPatOrInt2940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitPatOrInt2951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBitPatOrInt2990 = new BitSet(new long[]{0x0000005000000000L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleBitPatOrInt3012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleBitPatOrInt3038 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleBITSTR_in_ruleBitPatOrInt3060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp3107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp3118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleExp3155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInt_in_entryRuleInt3195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInt3206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleInt3253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_ruleInt3286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName3332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName3343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleName3382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConBind_in_entryRuleConBind3427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConBind3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConBind3484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQid_in_entryRuleQid3531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQid3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQid3581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT3626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rulePOSINT3676 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleNUM_in_rulePOSINT3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_rulePOSINT3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNEGINT_in_entryRuleNEGINT3778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNEGINT3789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleNEGINT3827 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleNUM_in_ruleNEGINT3849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUM_in_entryRuleNUM3895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUM3906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DIG_in_ruleNUM3946 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleHEXNUM_in_entryRuleHEXNUM3993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHEXNUM4004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleHEXNUM4042 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_HEXDIGIT_in_ruleHEXNUM4058 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleBITSTR_in_entryRuleBITSTR4108 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITSTR4119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINARY_in_ruleBITSTR4159 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS4208 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS4219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CONSTART_in_ruleCONS4259 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_IDCHAR_in_ruleCONS4280 = new BitSet(new long[]{0x0000000000000402L});

}