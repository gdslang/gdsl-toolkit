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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_S", "RULE_BINS", "RULE_LESS", "RULE_GREATER", "RULE_STRING", "RULE_DOT", "RULE_USCORE", "RULE_HEXINT", "RULE_MIXID", "RULE_BS", "RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER", "RULE_NEGINT", "RULE_POSINT_WO_DUALS", "RULE_DUALS", "RULE_IDCHAR", "RULE_CHARSYM", "RULE_OTHERSYM", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "';'", "'export'", "':'", "'type'", "'='", "'|'", "'val'", "'['", "']'", "','", "'of'", "'int'", "'string'", "'unit'", "'{'", "'}'", "'('", "')'", "'->'", "'()'", "'=>'", "'case'", "'end'", "'if'", "'then'", "'else'", "'do'", "'<-'", "'or'", "'and'", "'+'", "'-'", "'*'", "'%'", "'^'", "'~'", "'@'", "'$'", "'let'", "'in'", "'\\''"
    };
    public static final int RULE_ID=4;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__26=26;
    public static final int T__63=63;
    public static final int T__25=25;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int RULE_DOT=10;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_IDCHAR=19;
    public static final int T__59=59;
    public static final int RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER=15;
    public static final int RULE_S=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int RULE_GREATER=8;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_USCORE=11;
    public static final int RULE_SL_COMMENT=24;
    public static final int RULE_HEXINT=12;
    public static final int RULE_ML_COMMENT=23;
    public static final int RULE_BS=14;
    public static final int RULE_BINS=6;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=9;
    public static final int T__32=32;
    public static final int RULE_MIXID=13;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_OTHERSYM=21;
    public static final int T__39=39;
    public static final int RULE_NEGINT=16;
    public static final int RULE_DUALS=18;
    public static final int RULE_LESS=7;
    public static final int RULE_CHARSYM=20;
    public static final int RULE_WS=22;
    public static final int RULE_POSINT_WO_DUALS=17;

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

                if ( ((LA2_0>=25 && LA2_0<=26)||LA2_0==28||LA2_0==31) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==25) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:5: otherlv_1= ';'
            	            {
            	            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleModel145); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:137:1: ruleDecl returns [EObject current=null] : (this_DeclExport_0= ruleDeclExport | this_DeclType_1= ruleDeclType | this_DeclVal_2= ruleDeclVal ) ;
    public final EObject ruleDecl() throws RecognitionException {
        EObject current = null;

        EObject this_DeclExport_0 = null;

        EObject this_DeclType_1 = null;

        EObject this_DeclVal_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:140:28: ( (this_DeclExport_0= ruleDeclExport | this_DeclType_1= ruleDeclType | this_DeclVal_2= ruleDeclVal ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:141:1: (this_DeclExport_0= ruleDeclExport | this_DeclType_1= ruleDeclType | this_DeclVal_2= ruleDeclVal )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:141:1: (this_DeclExport_0= ruleDeclExport | this_DeclType_1= ruleDeclType | this_DeclVal_2= ruleDeclVal )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt3=1;
                }
                break;
            case 28:
                {
                alt3=2;
                }
                break;
            case 31:
                {
                alt3=3;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:142:5: this_DeclExport_0= ruleDeclExport
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclAccess().getDeclExportParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDeclExport_in_ruleDecl263);
                    this_DeclExport_0=ruleDeclExport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DeclExport_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:152:5: this_DeclType_1= ruleDeclType
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclAccess().getDeclTypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDeclType_in_ruleDecl290);
                    this_DeclType_1=ruleDeclType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DeclType_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:162:5: this_DeclVal_2= ruleDeclVal
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDeclAccess().getDeclValParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDeclVal_in_ruleDecl317);
                    this_DeclVal_2=ruleDeclVal();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DeclVal_2; 
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


    // $ANTLR start "entryRuleDeclExport"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:178:1: entryRuleDeclExport returns [EObject current=null] : iv_ruleDeclExport= ruleDeclExport EOF ;
    public final EObject entryRuleDeclExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclExport = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:179:2: (iv_ruleDeclExport= ruleDeclExport EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:180:2: iv_ruleDeclExport= ruleDeclExport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclExportRule()); 
            }
            pushFollow(FOLLOW_ruleDeclExport_in_entryRuleDeclExport352);
            iv_ruleDeclExport=ruleDeclExport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclExport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclExport362); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:187:1: ruleDeclExport returns [EObject current=null] : (otherlv_0= 'export' ( (otherlv_1= RULE_ID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) ) ) ;
    public final EObject ruleDeclExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_tyVars_2_0 = null;

        EObject lv_type_4_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:190:28: ( (otherlv_0= 'export' ( (otherlv_1= RULE_ID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:191:1: (otherlv_0= 'export' ( (otherlv_1= RULE_ID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:191:1: (otherlv_0= 'export' ( (otherlv_1= RULE_ID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:191:3: otherlv_0= 'export' ( (otherlv_1= RULE_ID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleDeclExport399); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeclExportAccess().getExportKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:195:1: ( (otherlv_1= RULE_ID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:196:1: (otherlv_1= RULE_ID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:196:1: (otherlv_1= RULE_ID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:197:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getDeclExportRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclExport419); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getDeclExportAccess().getNameValCrossReference_1_0()); 
              	
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:208:2: ( (lv_tyVars_2_0= ruleTyVars ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==32) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:209:1: (lv_tyVars_2_0= ruleTyVars )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:209:1: (lv_tyVars_2_0= ruleTyVars )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:210:3: lv_tyVars_2_0= ruleTyVars
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclExportAccess().getTyVarsTyVarsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTyVars_in_ruleDeclExport440);
                    lv_tyVars_2_0=ruleTyVars();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclExportRule());
                      	        }
                             		set(
                             			current, 
                             			"tyVars",
                              		lv_tyVars_2_0, 
                              		"TyVars");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleDeclExport453); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDeclExportAccess().getColonKeyword_3());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:230:1: ( (lv_type_4_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:231:1: (lv_type_4_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:231:1: (lv_type_4_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:232:3: lv_type_4_0= ruleTy
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclExportAccess().getTypeTyParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTy_in_ruleDeclExport474);
            lv_type_4_0=ruleTy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeclExportRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_4_0, 
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
    // $ANTLR end "ruleDeclExport"


    // $ANTLR start "entryRuleDeclType"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:256:1: entryRuleDeclType returns [EObject current=null] : iv_ruleDeclType= ruleDeclType EOF ;
    public final EObject entryRuleDeclType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclType = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:257:2: (iv_ruleDeclType= ruleDeclType EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:258:2: iv_ruleDeclType= ruleDeclType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDeclType_in_entryRuleDeclType510);
            iv_ruleDeclType=ruleDeclType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclType520); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:265:1: ruleDeclType returns [EObject current=null] : (otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* ) ) | ( (lv_value_7_0= ruleTy ) ) ) ) ;
    public final EObject ruleDeclType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_tyVars_2_0 = null;

        EObject lv_conDecl_4_0 = null;

        EObject lv_conDecl_6_0 = null;

        EObject lv_value_7_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:268:28: ( (otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* ) ) | ( (lv_value_7_0= ruleTy ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:269:1: (otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* ) ) | ( (lv_value_7_0= ruleTy ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:269:1: (otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* ) ) | ( (lv_value_7_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:269:3: otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* ) ) | ( (lv_value_7_0= ruleTy ) ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleDeclType557); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeclTypeAccess().getTypeKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:273:1: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:274:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:274:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:275:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:275:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_S) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:276:3: lv_name_1_1= RULE_ID
                    {
                    lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclType576); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_1, grammarAccess.getDeclTypeAccess().getNameIDTerminalRuleCall_1_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDeclTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_1, 
                              		"ID");
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:291:8: lv_name_1_2= RULE_S
                    {
                    lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclType596); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_2, grammarAccess.getDeclTypeAccess().getNameSTerminalRuleCall_1_0_1()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDeclTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_2, 
                              		"S");
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:309:2: ( (lv_tyVars_2_0= ruleTyVars ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==32) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:310:1: (lv_tyVars_2_0= ruleTyVars )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:310:1: (lv_tyVars_2_0= ruleTyVars )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:311:3: lv_tyVars_2_0= ruleTyVars
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getTyVarsTyVarsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTyVars_in_ruleDeclType625);
                    lv_tyVars_2_0=ruleTyVars();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"tyVars",
                              		lv_tyVars_2_0, 
                              		"TyVars");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleDeclType638); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_3());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:331:1: ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* ) ) | ( (lv_value_7_0= ruleTy ) ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:331:2: ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:331:2: ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:331:3: ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:340:8: ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:340:9: ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:340:9: ( (lv_conDecl_4_0= ruleConDecl ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:341:1: (lv_conDecl_4_0= ruleConDecl )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:341:1: (lv_conDecl_4_0= ruleConDecl )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:342:3: lv_conDecl_4_0= ruleConDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_4_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType692);
                    lv_conDecl_4_0=ruleConDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"conDecl",
                              		lv_conDecl_4_0, 
                              		"ConDecl");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:358:2: (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==30) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:358:4: otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) )
                    	    {
                    	    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleDeclType705); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getDeclTypeAccess().getVerticalLineKeyword_4_0_0_1_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:362:1: ( (lv_conDecl_6_0= ruleConDecl ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:363:1: (lv_conDecl_6_0= ruleConDecl )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:363:1: (lv_conDecl_6_0= ruleConDecl )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:364:3: lv_conDecl_6_0= ruleConDecl
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_4_0_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType726);
                    	    lv_conDecl_6_0=ruleConDecl();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"conDecl",
                    	              		lv_conDecl_6_0, 
                    	              		"ConDecl");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:381:6: ( (lv_value_7_0= ruleTy ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:381:6: ( (lv_value_7_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:382:1: (lv_value_7_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:382:1: (lv_value_7_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:383:3: lv_value_7_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleDeclType757);
                    lv_value_7_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_7_0, 
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
    // $ANTLR end "ruleDeclType"


    // $ANTLR start "entryRuleDeclVal"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:407:1: entryRuleDeclVal returns [EObject current=null] : iv_ruleDeclVal= ruleDeclVal EOF ;
    public final EObject entryRuleDeclVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclVal = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:408:2: (iv_ruleDeclVal= ruleDeclVal EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:409:2: iv_ruleDeclVal= ruleDeclVal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclValRule()); 
            }
            pushFollow(FOLLOW_ruleDeclVal_in_entryRuleDeclVal794);
            iv_ruleDeclVal=ruleDeclVal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclVal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclVal804); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:416:1: ruleDeclVal returns [EObject current=null] : (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) ) ;
    public final EObject ruleDeclVal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_attr_3_1=null;
        Token lv_attr_3_2=null;
        Token otherlv_4=null;
        Token lv_attr_7_1=null;
        Token lv_attr_7_2=null;
        Token otherlv_8=null;
        Token lv_name_10_1=null;
        Token lv_name_10_2=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_exp_5_0 = null;

        AntlrDatatypeRuleToken lv_mid_6_0 = null;

        EObject lv_exp_9_0 = null;

        AntlrDatatypeRuleToken lv_decPat_12_0 = null;

        EObject lv_exp_15_0 = null;

        EObject lv_exps_17_0 = null;

        EObject lv_exps_19_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:419:28: ( (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:420:1: (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:420:1: (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:420:3: otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleDeclVal841); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeclValAccess().getValKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:1: ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:2: ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:2: ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:3: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:6: ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:7: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:7: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_S)) ) {
                        alt10=1;
                    }
                    else if ( ((LA10_0>=RULE_LESS && LA10_0<=RULE_GREATER)||(LA10_0>=RULE_DOT && LA10_0<=RULE_USCORE)||(LA10_0>=RULE_BS && LA10_0<=RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER)) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:8: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:8: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:455:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:455:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:456:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:456:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0==RULE_ID) ) {
                                alt9=1;
                            }
                            else if ( (LA9_0==RULE_S) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 0, input);

                                throw nvae;
                            }
                            switch (alt9) {
                                case 1 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:457:3: lv_name_1_1= RULE_ID
                                    {
                                    lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal950); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_name_1_1, grammarAccess.getDeclValAccess().getNameIDTerminalRuleCall_1_0_0_0_0_0_0()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getDeclValRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"name",
                                              		lv_name_1_1, 
                                              		"ID");
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:472:8: lv_name_1_2= RULE_S
                                    {
                                    lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal970); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_name_1_2, grammarAccess.getDeclValAccess().getNameSTerminalRuleCall_1_0_0_0_0_0_1()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getDeclValRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"name",
                                              		lv_name_1_2, 
                                              		"S");
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:491:6: ( (lv_name_2_0= ruleSYM ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:491:6: ( (lv_name_2_0= ruleSYM ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:492:1: (lv_name_2_0= ruleSYM )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:492:1: (lv_name_2_0= ruleSYM )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:493:3: lv_name_2_0= ruleSYM
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getNameSYMParserRuleCall_1_0_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleSYM_in_ruleDeclVal1005);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:509:3: ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_S)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:510:1: ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:510:1: ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:511:1: (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:511:1: (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S )
                    	    int alt11=2;
                    	    int LA11_0 = input.LA(1);

                    	    if ( (LA11_0==RULE_ID) ) {
                    	        alt11=1;
                    	    }
                    	    else if ( (LA11_0==RULE_S) ) {
                    	        alt11=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 11, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt11) {
                    	        case 1 :
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:512:3: lv_attr_3_1= RULE_ID
                    	            {
                    	            lv_attr_3_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1025); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_attr_3_1, grammarAccess.getDeclValAccess().getAttrIDTerminalRuleCall_1_0_0_1_0_0()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getDeclValRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"attr",
                    	                      		lv_attr_3_1, 
                    	                      		"ID");
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:527:8: lv_attr_3_2= RULE_S
                    	            {
                    	            lv_attr_3_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1045); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_attr_3_2, grammarAccess.getDeclValAccess().getAttrSTerminalRuleCall_1_0_0_1_0_1()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getDeclValRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"attr",
                    	                      		lv_attr_3_2, 
                    	                      		"S");
                    	              	    
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1066); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_0_0_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:549:1: ( (lv_exp_5_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:550:1: (lv_exp_5_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:550:1: (lv_exp_5_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:551:3: lv_exp_5_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_0_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1087);
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


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:568:6: ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:568:6: ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:568:7: ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:568:7: ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_USCORE||LA14_0==RULE_MIXID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:568:8: ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:568:8: ( (lv_mid_6_0= ruleMID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:569:1: (lv_mid_6_0= ruleMID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:569:1: (lv_mid_6_0= ruleMID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:570:3: lv_mid_6_0= ruleMID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getMidMIDParserRuleCall_1_1_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMID_in_ruleDeclVal1118);
                    	    lv_mid_6_0=ruleMID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"mid",
                    	              		lv_mid_6_0, 
                    	              		"MID");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:586:2: ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:587:1: ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:587:1: ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:588:1: (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:588:1: (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S )
                    	    int alt13=2;
                    	    int LA13_0 = input.LA(1);

                    	    if ( (LA13_0==RULE_ID) ) {
                    	        alt13=1;
                    	    }
                    	    else if ( (LA13_0==RULE_S) ) {
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:589:3: lv_attr_7_1= RULE_ID
                    	            {
                    	            lv_attr_7_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1137); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_attr_7_1, grammarAccess.getDeclValAccess().getAttrIDTerminalRuleCall_1_1_0_1_0_0()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getDeclValRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"attr",
                    	                      		lv_attr_7_1, 
                    	                      		"ID");
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:604:8: lv_attr_7_2= RULE_S
                    	            {
                    	            lv_attr_7_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1157); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_attr_7_2, grammarAccess.getDeclValAccess().getAttrSTerminalRuleCall_1_1_0_1_0_1()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getDeclValRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"attr",
                    	                      		lv_attr_7_2, 
                    	                      		"S");
                    	              	    
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1179); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:626:1: ( (lv_exp_9_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:627:1: (lv_exp_9_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:627:1: (lv_exp_9_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:628:3: lv_exp_9_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1200);
                    lv_exp_9_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_9_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:645:6: ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:645:6: ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:645:7: ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:645:7: ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:646:1: ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:646:1: ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:647:1: (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:647:1: (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==RULE_S) ) {
                        alt15=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:648:3: lv_name_10_1= RULE_ID
                            {
                            lv_name_10_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1227); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_10_1, grammarAccess.getDeclValAccess().getNameIDTerminalRuleCall_1_2_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getDeclValRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_10_1, 
                                      		"ID");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:663:8: lv_name_10_2= RULE_S
                            {
                            lv_name_10_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1247); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_10_2, grammarAccess.getDeclValAccess().getNameSTerminalRuleCall_1_2_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getDeclValRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_10_2, 
                                      		"S");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_11=(Token)match(input,32,FOLLOW_32_in_ruleDeclVal1267); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:685:1: ( (lv_decPat_12_0= ruleDECODEPAT ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_S)||LA16_0==RULE_HEXINT||LA16_0==65) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:686:1: (lv_decPat_12_0= ruleDECODEPAT )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:686:1: (lv_decPat_12_0= ruleDECODEPAT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:687:3: lv_decPat_12_0= ruleDECODEPAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getDecPatDECODEPATParserRuleCall_1_2_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleDECODEPAT_in_ruleDeclVal1288);
                    	    lv_decPat_12_0=ruleDECODEPAT();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"decPat",
                    	              		lv_decPat_12_0, 
                    	              		"DECODEPAT");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,33,FOLLOW_33_in_ruleDeclVal1301); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_2_3());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:707:1: ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==29) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==30) ) {
                        alt18=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:707:2: (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:707:2: (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:707:4: otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) )
                            {
                            otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1315); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_2_4_0_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:711:1: ( (lv_exp_15_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:712:1: (lv_exp_15_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:712:1: (lv_exp_15_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:713:3: lv_exp_15_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_2_4_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1336);
                            lv_exp_15_0=ruleExp();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"exp",
                                      		lv_exp_15_0, 
                                      		"Exp");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:730:6: (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:730:6: (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+
                            int cnt17=0;
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==30) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:730:8: otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) )
                            	    {
                            	    otherlv_16=(Token)match(input,30,FOLLOW_30_in_ruleDeclVal1356); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_16, grammarAccess.getDeclValAccess().getVerticalLineKeyword_1_2_4_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:734:1: ( (lv_exps_17_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:735:1: (lv_exps_17_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:735:1: (lv_exps_17_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:736:3: lv_exps_17_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_2_4_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1377);
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

                            	    otherlv_18=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1389); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_18, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_2_4_1_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:756:1: ( (lv_exps_19_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:757:1: (lv_exps_19_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:757:1: (lv_exps_19_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:758:3: lv_exps_19_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_2_4_1_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1410);
                            	    lv_exps_19_0=ruleExp();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"exps",
                            	              		lv_exps_19_0, 
                            	              		"Exp");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt17 >= 1 ) break loop17;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(17, input);
                                        throw eee;
                                }
                                cnt17++;
                            } while (true);


                            }
                            break;

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
    // $ANTLR end "ruleDeclVal"


    // $ANTLR start "entryRuleTyVars"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:782:1: entryRuleTyVars returns [EObject current=null] : iv_ruleTyVars= ruleTyVars EOF ;
    public final EObject entryRuleTyVars() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyVars = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:783:2: (iv_ruleTyVars= ruleTyVars EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:784:2: iv_ruleTyVars= ruleTyVars EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyVarsRule()); 
            }
            pushFollow(FOLLOW_ruleTyVars_in_entryRuleTyVars1451);
            iv_ruleTyVars=ruleTyVars();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyVars; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyVars1461); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTyVars"


    // $ANTLR start "ruleTyVars"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:791:1: ruleTyVars returns [EObject current=null] : (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleTyVars() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attr_1_0 = null;

        EObject lv_attr_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:794:28: ( (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:795:1: (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:795:1: (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:795:3: otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleTyVars1498); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTyVarsAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:799:1: ( (lv_attr_1_0= ruleTyVar ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:800:1: (lv_attr_1_0= ruleTyVar )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:800:1: (lv_attr_1_0= ruleTyVar )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:801:3: lv_attr_1_0= ruleTyVar
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyVarsAccess().getAttrTyVarParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTyVar_in_ruleTyVars1519);
            lv_attr_1_0=ruleTyVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTyVarsRule());
              	        }
                     		add(
                     			current, 
                     			"attr",
                      		lv_attr_1_0, 
                      		"TyVar");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:817:2: (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:817:4: otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) )
            	    {
            	    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleTyVars1532); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTyVarsAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:821:1: ( (lv_attr_3_0= ruleTyVar ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:822:1: (lv_attr_3_0= ruleTyVar )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:822:1: (lv_attr_3_0= ruleTyVar )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:823:3: lv_attr_3_0= ruleTyVar
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTyVarsAccess().getAttrTyVarParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTyVar_in_ruleTyVars1553);
            	    lv_attr_3_0=ruleTyVar();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTyVarsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"attr",
            	              		lv_attr_3_0, 
            	              		"TyVar");
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

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleTyVars1567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTyVarsAccess().getRightSquareBracketKeyword_3());
                  
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
    // $ANTLR end "ruleTyVars"


    // $ANTLR start "entryRuleTyVar"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:851:1: entryRuleTyVar returns [EObject current=null] : iv_ruleTyVar= ruleTyVar EOF ;
    public final EObject entryRuleTyVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyVar = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:852:2: (iv_ruleTyVar= ruleTyVar EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:853:2: iv_ruleTyVar= ruleTyVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyVarRule()); 
            }
            pushFollow(FOLLOW_ruleTyVar_in_entryRuleTyVar1603);
            iv_ruleTyVar=ruleTyVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyVar1613); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTyVar"


    // $ANTLR start "ruleTyVar"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:860:1: ruleTyVar returns [EObject current=null] : ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) ;
    public final EObject ruleTyVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:863:28: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:864:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:864:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:865:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:865:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:866:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:866:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_S) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:867:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyVar1656); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_1, grammarAccess.getTyVarAccess().getNameIDTerminalRuleCall_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTyVarRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_1, 
                              		"ID");
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:882:8: lv_name_0_2= RULE_S
                    {
                    lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTyVar1676); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_2, grammarAccess.getTyVarAccess().getNameSTerminalRuleCall_0_1()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTyVarRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_2, 
                              		"S");
                      	    
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
    // $ANTLR end "ruleTyVar"


    // $ANTLR start "entryRuleConDecl"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:908:1: entryRuleConDecl returns [EObject current=null] : iv_ruleConDecl= ruleConDecl EOF ;
    public final EObject entryRuleConDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:909:2: (iv_ruleConDecl= ruleConDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:910:2: iv_ruleConDecl= ruleConDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConDeclRule()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl1719);
            iv_ruleConDecl=ruleConDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl1729); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:917:1: ruleConDecl returns [EObject current=null] : ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleConDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_ty_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:920:28: ( ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:921:1: ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:921:1: ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:921:2: ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:921:2: ( (lv_name_0_0= ruleCONS ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:922:1: (lv_name_0_0= ruleCONS )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:922:1: (lv_name_0_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:923:3: lv_name_0_0= ruleCONS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConDeclAccess().getNameCONSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConDecl1775);
            lv_name_0_0=ruleCONS();

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
                      		"CONS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:939:2: (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:939:4: otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleConDecl1788); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConDeclAccess().getOfKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:943:1: ( (lv_ty_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:944:1: (lv_ty_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:944:1: (lv_ty_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:945:3: lv_ty_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleConDecl1809);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:969:1: entryRuleTy returns [EObject current=null] : iv_ruleTy= ruleTy EOF ;
    public final EObject entryRuleTy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTy = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:970:2: (iv_ruleTy= ruleTy EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:971:2: iv_ruleTy= ruleTy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyRule()); 
            }
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy1847);
            iv_ruleTy=ruleTy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTy; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy1857); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:978:1: ruleTy returns [EObject current=null] : ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) ) ;
    public final EObject ruleTy() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_2=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_type_8_1=null;
        Token lv_type_8_2=null;
        Token lv_type_8_3=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token this_S_31=null;
        Token this_LESS_33=null;
        Token otherlv_35=null;
        Token this_GREATER_37=null;
        AntlrDatatypeRuleToken lv_value_0_1 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;

        EObject lv_tyBind_10_0 = null;

        EObject lv_tyBind_12_0 = null;

        EObject lv_elements_16_0 = null;

        EObject lv_elements_18_0 = null;

        EObject lv_param_21_0 = null;

        EObject lv_param_23_0 = null;

        EObject lv_resType_26_0 = null;

        EObject lv_resType_30_0 = null;

        EObject lv_r_32_0 = null;

        EObject lv_in_34_0 = null;

        EObject lv_out_36_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:981:28: ( ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:982:1: ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:982:1: ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) )
            int alt32=8;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:982:2: ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:982:2: ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:983:1: ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:983:1: ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:984:1: (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:984:1: (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==RULE_HEXINT||(LA23_0>=RULE_NEGINT && LA23_0<=RULE_DUALS)) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==RULE_BINS) ) {
                        alt23=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:985:3: lv_value_0_1= ruleINTEGER
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getValueINTEGERParserRuleCall_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleINTEGER_in_ruleTy1905);
                            lv_value_0_1=ruleINTEGER();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTyRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"value",
                                      		lv_value_0_1, 
                                      		"INTEGER");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1000:8: lv_value_0_2= RULE_BINS
                            {
                            lv_value_0_2=(Token)match(input,RULE_BINS,FOLLOW_RULE_BINS_in_ruleTy1920); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_value_0_2, grammarAccess.getTyAccess().getValueBINSTerminalRuleCall_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getTyRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"value",
                                      		lv_value_0_2, 
                                      		"BINS");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1019:6: (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1019:6: (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1019:8: otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleTy1947); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTyAccess().getVerticalLineKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1023:1: ( (lv_value_2_0= ruleINTEGER ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1024:1: (lv_value_2_0= ruleINTEGER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1024:1: (lv_value_2_0= ruleINTEGER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1025:3: lv_value_2_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueINTEGERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleTy1968);
                    lv_value_2_0=ruleINTEGER();

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
                              		"INTEGER");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleTy1980); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTyAccess().getVerticalLineKeyword_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1046:6: (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1046:6: (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1046:8: otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|'
                    {
                    otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleTy2000); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getTyAccess().getVerticalLineKeyword_2_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1050:1: ( (otherlv_5= RULE_ID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1051:1: (otherlv_5= RULE_ID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1051:1: (otherlv_5= RULE_ID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1052:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTyRule());
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTy2020); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_5, grammarAccess.getTyAccess().getTypeRefTypeCrossReference_2_1_0()); 
                      	
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleTy2032); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getTyAccess().getVerticalLineKeyword_2_2());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1068:6: ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1068:6: ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1068:7: ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1068:7: ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==RULE_ID) ) {
                        alt25=1;
                    }
                    else if ( ((LA25_0>=36 && LA25_0<=38)) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1068:8: ( (otherlv_7= RULE_ID ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1068:8: ( (otherlv_7= RULE_ID ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1069:1: (otherlv_7= RULE_ID )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1069:1: (otherlv_7= RULE_ID )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1070:3: otherlv_7= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTyRule());
                              	        }
                                      
                            }
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTy2061); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_7, grammarAccess.getTyAccess().getTypeRefTypeCrossReference_3_0_0_0()); 
                              	
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1082:6: ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1082:6: ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1083:1: ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1083:1: ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1084:1: (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1084:1: (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' )
                            int alt24=3;
                            switch ( input.LA(1) ) {
                            case 36:
                                {
                                alt24=1;
                                }
                                break;
                            case 37:
                                {
                                alt24=2;
                                }
                                break;
                            case 38:
                                {
                                alt24=3;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 24, 0, input);

                                throw nvae;
                            }

                            switch (alt24) {
                                case 1 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1085:3: lv_type_8_1= 'int'
                                    {
                                    lv_type_8_1=(Token)match(input,36,FOLLOW_36_in_ruleTy2087); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_type_8_1, grammarAccess.getTyAccess().getTypeIntKeyword_3_0_1_0_0());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getTyRule());
                                      	        }
                                             		setWithLastConsumed(current, "type", lv_type_8_1, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1097:8: lv_type_8_2= 'string'
                                    {
                                    lv_type_8_2=(Token)match(input,37,FOLLOW_37_in_ruleTy2116); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_type_8_2, grammarAccess.getTyAccess().getTypeStringKeyword_3_0_1_0_1());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getTyRule());
                                      	        }
                                             		setWithLastConsumed(current, "type", lv_type_8_2, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 3 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1109:8: lv_type_8_3= 'unit'
                                    {
                                    lv_type_8_3=(Token)match(input,38,FOLLOW_38_in_ruleTy2145); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_type_8_3, grammarAccess.getTyAccess().getTypeUnitKeyword_3_0_1_0_2());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getTyRule());
                                      	        }
                                             		setWithLastConsumed(current, "type", lv_type_8_3, null);
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;

                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1124:3: (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==32) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1124:5: otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']'
                            {
                            otherlv_9=(Token)match(input,32,FOLLOW_32_in_ruleTy2175); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getTyAccess().getLeftSquareBracketKeyword_3_1_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1128:1: ( (lv_tyBind_10_0= ruleTyBind ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1129:1: (lv_tyBind_10_0= ruleTyBind )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1129:1: (lv_tyBind_10_0= ruleTyBind )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1130:3: lv_tyBind_10_0= ruleTyBind
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_3_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyBind_in_ruleTy2196);
                            lv_tyBind_10_0=ruleTyBind();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTyRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"tyBind",
                                      		lv_tyBind_10_0, 
                                      		"TyBind");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1146:2: (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==34) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1146:4: otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) )
                            	    {
                            	    otherlv_11=(Token)match(input,34,FOLLOW_34_in_ruleTy2209); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getTyAccess().getCommaKeyword_3_1_2_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1150:1: ( (lv_tyBind_12_0= ruleTyBind ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1151:1: (lv_tyBind_12_0= ruleTyBind )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1151:1: (lv_tyBind_12_0= ruleTyBind )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1152:3: lv_tyBind_12_0= ruleTyBind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_3_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyBind_in_ruleTy2230);
                            	    lv_tyBind_12_0=ruleTyBind();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getTyRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"tyBind",
                            	              		lv_tyBind_12_0, 
                            	              		"TyBind");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop26;
                                }
                            } while (true);

                            otherlv_13=(Token)match(input,33,FOLLOW_33_in_ruleTy2244); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_13, grammarAccess.getTyAccess().getRightSquareBracketKeyword_3_1_3());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1173:6: ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1173:6: ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1173:7: () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1173:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1174:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTyAccess().getTyAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_15=(Token)match(input,39,FOLLOW_39_in_ruleTy2275); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_4_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1183:1: ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_S)) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1183:2: ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1183:2: ( (lv_elements_16_0= ruleTyElement ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1184:1: (lv_elements_16_0= ruleTyElement )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1184:1: (lv_elements_16_0= ruleTyElement )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1185:3: lv_elements_16_0= ruleTyElement
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_4_2_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyElement_in_ruleTy2297);
                            lv_elements_16_0=ruleTyElement();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTyRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"elements",
                                      		lv_elements_16_0, 
                                      		"TyElement");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1201:2: (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==34) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1201:4: otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) )
                            	    {
                            	    otherlv_17=(Token)match(input,34,FOLLOW_34_in_ruleTy2310); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_17, grammarAccess.getTyAccess().getCommaKeyword_4_2_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1205:1: ( (lv_elements_18_0= ruleTyElement ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1206:1: (lv_elements_18_0= ruleTyElement )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1206:1: (lv_elements_18_0= ruleTyElement )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1207:3: lv_elements_18_0= ruleTyElement
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_4_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2331);
                            	    lv_elements_18_0=ruleTyElement();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getTyRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"elements",
                            	              		lv_elements_18_0, 
                            	              		"TyElement");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop28;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_19=(Token)match(input,40,FOLLOW_40_in_ruleTy2347); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getTyAccess().getRightCurlyBracketKeyword_4_3());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1228:6: (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1228:6: (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1228:8: otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) )
                    {
                    otherlv_20=(Token)match(input,41,FOLLOW_41_in_ruleTy2367); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getTyAccess().getLeftParenthesisKeyword_5_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1232:1: ( (lv_param_21_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1233:1: (lv_param_21_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1233:1: (lv_param_21_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1234:3: lv_param_21_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getParamTyParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2388);
                    lv_param_21_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		add(
                             			current, 
                             			"param",
                              		lv_param_21_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1250:2: (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==34) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1250:4: otherlv_22= ',' ( (lv_param_23_0= ruleTy ) )
                    	    {
                    	    otherlv_22=(Token)match(input,34,FOLLOW_34_in_ruleTy2401); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_22, grammarAccess.getTyAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1254:1: ( (lv_param_23_0= ruleTy ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1255:1: (lv_param_23_0= ruleTy )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1255:1: (lv_param_23_0= ruleTy )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1256:3: lv_param_23_0= ruleTy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTyAccess().getParamTyParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTy_in_ruleTy2422);
                    	    lv_param_23_0=ruleTy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTyRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"param",
                    	              		lv_param_23_0, 
                    	              		"Ty");
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

                    otherlv_24=(Token)match(input,42,FOLLOW_42_in_ruleTy2436); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getTyAccess().getRightParenthesisKeyword_5_3());
                          
                    }
                    otherlv_25=(Token)match(input,43,FOLLOW_43_in_ruleTy2448); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getTyAccess().getHyphenMinusGreaterThanSignKeyword_5_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1280:1: ( (lv_resType_26_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1281:1: (lv_resType_26_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1281:1: (lv_resType_26_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1282:3: lv_resType_26_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getResTypeTyParserRuleCall_5_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2469);
                    lv_resType_26_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"resType",
                              		lv_resType_26_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1299:6: ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1299:6: ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1299:7: () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1299:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1300:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTyAccess().getTyAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_28=(Token)match(input,44,FOLLOW_44_in_ruleTy2498); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getTyAccess().getLeftParenthesisRightParenthesisKeyword_6_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1309:1: (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==43) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1309:3: otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) )
                            {
                            otherlv_29=(Token)match(input,43,FOLLOW_43_in_ruleTy2511); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_29, grammarAccess.getTyAccess().getHyphenMinusGreaterThanSignKeyword_6_2_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1313:1: ( (lv_resType_30_0= ruleTy ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1314:1: (lv_resType_30_0= ruleTy )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1314:1: (lv_resType_30_0= ruleTy )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1315:3: lv_resType_30_0= ruleTy
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getResTypeTyParserRuleCall_6_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTy_in_ruleTy2532);
                            lv_resType_30_0=ruleTy();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTyRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"resType",
                                      		lv_resType_30_0, 
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
                    break;
                case 8 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:6: (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:6: (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:7: this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER
                    {
                    this_S_31=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTy2553); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_S_31, grammarAccess.getTyAccess().getSTerminalRuleCall_7_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1336:1: ( (lv_r_32_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1337:1: (lv_r_32_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1337:1: (lv_r_32_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1338:3: lv_r_32_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getRTyParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2573);
                    lv_r_32_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"r",
                              		lv_r_32_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_LESS_33=(Token)match(input,RULE_LESS,FOLLOW_RULE_LESS_in_ruleTy2584); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LESS_33, grammarAccess.getTyAccess().getLESSTerminalRuleCall_7_2()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1358:1: ( (lv_in_34_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1359:1: (lv_in_34_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1359:1: (lv_in_34_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1360:3: lv_in_34_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getInTyParserRuleCall_7_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2604);
                    lv_in_34_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"in",
                              		lv_in_34_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_35=(Token)match(input,45,FOLLOW_45_in_ruleTy2616); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_35, grammarAccess.getTyAccess().getEqualsSignGreaterThanSignKeyword_7_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1380:1: ( (lv_out_36_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1381:1: (lv_out_36_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1381:1: (lv_out_36_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1382:3: lv_out_36_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getOutTyParserRuleCall_7_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2637);
                    lv_out_36_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"out",
                              		lv_out_36_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_GREATER_37=(Token)match(input,RULE_GREATER,FOLLOW_RULE_GREATER_in_ruleTy2648); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_GREATER_37, grammarAccess.getTyAccess().getGREATERTerminalRuleCall_7_6()); 
                          
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


    // $ANTLR start "entryRuleTyBind"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1410:1: entryRuleTyBind returns [EObject current=null] : iv_ruleTyBind= ruleTyBind EOF ;
    public final EObject entryRuleTyBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1411:2: (iv_ruleTyBind= ruleTyBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1412:2: iv_ruleTyBind= ruleTyBind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyBindRule()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind2684);
            iv_ruleTyBind=ruleTyBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyBind; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind2694); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1419:1: ruleTyBind returns [EObject current=null] : ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleTyBind() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1422:28: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1423:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1423:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1423:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1423:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1424:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1424:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1425:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1425:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_S) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1426:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyBind2738); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_1, grammarAccess.getTyBindAccess().getNameIDTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTyBindRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_1, 
                              		"ID");
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1441:8: lv_name_0_2= RULE_S
                    {
                    lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTyBind2758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_2, grammarAccess.getTyBindAccess().getNameSTerminalRuleCall_0_0_1()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTyBindRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_2, 
                              		"S");
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1459:2: (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==29) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1459:4: otherlv_1= '=' ( (lv_value_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleTyBind2779); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1463:1: ( (lv_value_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1464:1: (lv_value_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1464:1: (lv_value_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1465:3: lv_value_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTyBind2800);
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


    // $ANTLR start "entryRuleTyElement"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1489:1: entryRuleTyElement returns [EObject current=null] : iv_ruleTyElement= ruleTyElement EOF ;
    public final EObject entryRuleTyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyElement = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1490:2: (iv_ruleTyElement= ruleTyElement EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1491:2: iv_ruleTyElement= ruleTyElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyElementRule()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement2838);
            iv_ruleTyElement=ruleTyElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement2848); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1498:1: ruleTyElement returns [EObject current=null] : ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) ;
    public final EObject ruleTyElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1501:28: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1502:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1502:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1502:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1502:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1503:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1503:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1504:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1504:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_S) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1505:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyElement2892); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_1, grammarAccess.getTyElementAccess().getNameIDTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTyElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_1, 
                              		"ID");
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1520:8: lv_name_0_2= RULE_S
                    {
                    lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTyElement2912); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_2, grammarAccess.getTyElementAccess().getNameSTerminalRuleCall_0_0_1()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTyElementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_2, 
                              		"S");
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleTyElement2932); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTyElementAccess().getColonKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1542:1: ( (lv_value_2_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1543:1: (lv_value_2_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1543:1: (lv_value_2_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1544:3: lv_value_2_0= ruleTy
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTy_in_ruleTyElement2953);
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


    // $ANTLR start "entryRuleExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1568:1: entryRuleExp returns [EObject current=null] : iv_ruleExp= ruleExp EOF ;
    public final EObject entryRuleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1569:2: (iv_ruleExp= ruleExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1570:2: iv_ruleExp= ruleExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpRule()); 
            }
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp2989);
            iv_ruleExp=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp2999); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1577:1: ruleExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ ) ;
    public final EObject ruleExp() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_mid_1_0 = null;

        EObject lv_caseExps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1580:28: ( ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1581:1: ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1581:1: ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_ID && LA37_0<=RULE_S)||LA37_0==RULE_STRING||LA37_0==RULE_HEXINT||(LA37_0>=RULE_NEGINT && LA37_0<=RULE_DUALS)||LA37_0==39||LA37_0==41||LA37_0==46||LA37_0==48||LA37_0==51||(LA37_0>=60 && LA37_0<=63)||LA37_0==65) ) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_USCORE||LA37_0==RULE_MIXID) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1581:2: ( (lv_name_0_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1581:2: ( (lv_name_0_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1582:1: (lv_name_0_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1582:1: (lv_name_0_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1583:3: lv_name_0_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getNameCaseExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp3045);
                    lv_name_0_0=ruleCaseExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"CaseExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1600:6: ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1600:6: ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==RULE_USCORE||LA36_0==RULE_MIXID) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1600:7: ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1600:7: ( (lv_mid_1_0= ruleMID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1601:1: (lv_mid_1_0= ruleMID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1601:1: (lv_mid_1_0= ruleMID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1602:3: lv_mid_1_0= ruleMID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpAccess().getMidMIDParserRuleCall_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMID_in_ruleExp3073);
                    	    lv_mid_1_0=ruleMID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"mid",
                    	              		lv_mid_1_0, 
                    	              		"MID");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1618:2: ( (lv_caseExps_2_0= ruleCaseExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1619:1: (lv_caseExps_2_0= ruleCaseExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1619:1: (lv_caseExps_2_0= ruleCaseExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1620:3: lv_caseExps_2_0= ruleCaseExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpAccess().getCaseExpsCaseExpParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp3094);
                    	    lv_caseExps_2_0=ruleCaseExp();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"caseExps",
                    	              		lv_caseExps_2_0, 
                    	              		"CaseExp");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);


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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1644:1: entryRuleCaseExp returns [EObject current=null] : iv_ruleCaseExp= ruleCaseExp EOF ;
    public final EObject entryRuleCaseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1645:2: (iv_ruleCaseExp= ruleCaseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1646:2: iv_ruleCaseExp= ruleCaseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseExpRule()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_entryRuleCaseExp3132);
            iv_ruleCaseExp=ruleCaseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseExp3142); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1653:1: ruleCaseExp returns [EObject current=null] : (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) ) ;
    public final EObject ruleCaseExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject this_ClosedExp_0 = null;

        EObject lv_closedExp_2_0 = null;

        EObject lv_pat_4_0 = null;

        EObject lv_exp_6_0 = null;

        EObject lv_pat_8_0 = null;

        EObject lv_exp_10_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1656:28: ( (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1657:1: (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1657:1: (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_S)||LA39_0==RULE_STRING||LA39_0==RULE_HEXINT||(LA39_0>=RULE_NEGINT && LA39_0<=RULE_DUALS)||LA39_0==39||LA39_0==41||LA39_0==48||LA39_0==51||(LA39_0>=60 && LA39_0<=63)||LA39_0==65) ) {
                alt39=1;
            }
            else if ( (LA39_0==46) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1658:5: this_ClosedExp_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp3189);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1667:6: ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1667:6: ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1667:7: ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1667:7: ( (lv_name_1_0= 'case' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1668:1: (lv_name_1_0= 'case' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1668:1: (lv_name_1_0= 'case' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1669:3: lv_name_1_0= 'case'
                    {
                    lv_name_1_0=(Token)match(input,46,FOLLOW_46_in_ruleCaseExp3213); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_1_0, grammarAccess.getCaseExpAccess().getNameCaseKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCaseExpRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_1_0, "case");
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1682:2: ( (lv_closedExp_2_0= ruleClosedExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1683:1: (lv_closedExp_2_0= ruleClosedExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1683:1: (lv_closedExp_2_0= ruleClosedExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1684:3: lv_closedExp_2_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpClosedExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp3247);
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

                    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleCaseExp3259); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCaseExpAccess().getOfKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1704:1: ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1704:2: ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1704:2: ( (lv_pat_4_0= rulePAT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1705:1: (lv_pat_4_0= rulePAT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1705:1: (lv_pat_4_0= rulePAT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1706:3: lv_pat_4_0= rulePAT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getPatPATParserRuleCall_1_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePAT_in_ruleCaseExp3281);
                    lv_pat_4_0=rulePAT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCaseExpRule());
                      	        }
                             		add(
                             			current, 
                             			"pat",
                              		lv_pat_4_0, 
                              		"PAT");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleCaseExp3293); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCaseExpAccess().getColonKeyword_1_3_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1726:1: ( (lv_exp_6_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1727:1: (lv_exp_6_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1727:1: (lv_exp_6_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1728:3: lv_exp_6_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getExpExpParserRuleCall_1_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleCaseExp3314);
                    lv_exp_6_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCaseExpRule());
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1744:2: (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==30) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1744:4: otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) )
                    	    {
                    	    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleCaseExp3327); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getCaseExpAccess().getVerticalLineKeyword_1_3_3_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1748:1: ( (lv_pat_8_0= rulePAT ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1749:1: (lv_pat_8_0= rulePAT )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1749:1: (lv_pat_8_0= rulePAT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1750:3: lv_pat_8_0= rulePAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCaseExpAccess().getPatPATParserRuleCall_1_3_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePAT_in_ruleCaseExp3348);
                    	    lv_pat_8_0=rulePAT();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCaseExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"pat",
                    	              		lv_pat_8_0, 
                    	              		"PAT");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_9=(Token)match(input,27,FOLLOW_27_in_ruleCaseExp3360); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getCaseExpAccess().getColonKeyword_1_3_3_2());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1770:1: ( (lv_exp_10_0= ruleExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1771:1: (lv_exp_10_0= ruleExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1771:1: (lv_exp_10_0= ruleExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1772:3: lv_exp_10_0= ruleExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCaseExpAccess().getExpExpParserRuleCall_1_3_3_3_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExp_in_ruleCaseExp3381);
                    	    lv_exp_10_0=ruleExp();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCaseExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"exp",
                    	              		lv_exp_10_0, 
                    	              		"Exp");
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

                    otherlv_11=(Token)match(input,47,FOLLOW_47_in_ruleCaseExp3396); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getCaseExpAccess().getEndKeyword_1_4());
                          
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1800:1: entryRuleClosedExp returns [EObject current=null] : iv_ruleClosedExp= ruleClosedExp EOF ;
    public final EObject entryRuleClosedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosedExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1801:2: (iv_ruleClosedExp= ruleClosedExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1802:2: iv_ruleClosedExp= ruleClosedExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosedExpRule()); 
            }
            pushFollow(FOLLOW_ruleClosedExp_in_entryRuleClosedExp3433);
            iv_ruleClosedExp=ruleClosedExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosedExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedExp3443); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1809:1: ruleClosedExp returns [EObject current=null] : (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) ;
    public final EObject ruleClosedExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_name_7_0=null;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1812:28: ( (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1813:1: (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1813:1: (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_S:
            case RULE_STRING:
            case RULE_HEXINT:
            case RULE_NEGINT:
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
            case 39:
            case 41:
            case 60:
            case 61:
            case 62:
            case 63:
            case 65:
                {
                alt41=1;
                }
                break;
            case 48:
                {
                alt41=2;
                }
                break;
            case 51:
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1814:5: this_OrElseExp_0= ruleOrElseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClosedExpAccess().getOrElseExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrElseExp_in_ruleClosedExp3490);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1823:6: ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1823:6: ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1823:7: ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1823:7: ( (lv_name_1_0= 'if' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1824:1: (lv_name_1_0= 'if' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1824:1: (lv_name_1_0= 'if' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1825:3: lv_name_1_0= 'if'
                    {
                    lv_name_1_0=(Token)match(input,48,FOLLOW_48_in_ruleClosedExp3514); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_1_0, grammarAccess.getClosedExpAccess().getNameIfKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getClosedExpRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_1_0, "if");
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1838:2: ( (lv_ifCaseExp_2_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1840:3: lv_ifCaseExp_2_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getIfCaseExpCaseExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3548);
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

                    otherlv_3=(Token)match(input,49,FOLLOW_49_in_ruleClosedExp3560); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getClosedExpAccess().getThenKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1860:1: ( (lv_thenCaseExp_4_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1861:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1861:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1862:3: lv_thenCaseExp_4_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getThenCaseExpCaseExpParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3581);
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

                    otherlv_5=(Token)match(input,50,FOLLOW_50_in_ruleClosedExp3593); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getClosedExpAccess().getElseKeyword_1_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1882:1: ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1883:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1883:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1884:3: lv_elseCaseExp_6_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getElseCaseExpCaseExpParserRuleCall_1_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3614);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1901:6: ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1901:6: ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1901:7: ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1901:7: ( (lv_name_7_0= 'do' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1902:1: (lv_name_7_0= 'do' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1902:1: (lv_name_7_0= 'do' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1903:3: lv_name_7_0= 'do'
                    {
                    lv_name_7_0=(Token)match(input,51,FOLLOW_51_in_ruleClosedExp3640); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_7_0, grammarAccess.getClosedExpAccess().getNameDoKeyword_2_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getClosedExpRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_7_0, "do");
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1916:2: ( (lv_doExp_8_0= ruleMonadicExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1917:1: (lv_doExp_8_0= ruleMonadicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1917:1: (lv_doExp_8_0= ruleMonadicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1918:3: lv_doExp_8_0= ruleMonadicExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3674);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1934:2: (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==25) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1934:4: otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    {
                    	    otherlv_9=(Token)match(input,25,FOLLOW_25_in_ruleClosedExp3687); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getClosedExpAccess().getSemicolonKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1938:1: ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1939:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1939:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1940:3: lv_doExp_10_0= ruleMonadicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3708);
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
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,47,FOLLOW_47_in_ruleClosedExp3722); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1968:1: entryRuleMonadicExp returns [EObject current=null] : iv_ruleMonadicExp= ruleMonadicExp EOF ;
    public final EObject entryRuleMonadicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonadicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1969:2: (iv_ruleMonadicExp= ruleMonadicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1970:2: iv_ruleMonadicExp= ruleMonadicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMonadicExpRule()); 
            }
            pushFollow(FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3759);
            iv_ruleMonadicExp=ruleMonadicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMonadicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonadicExp3769); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1977:1: ruleMonadicExp returns [EObject current=null] : ( ( (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) ;
    public final EObject ruleMonadicExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1980:28: ( ( ( (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1981:1: ( ( (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1981:1: ( ( (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            int alt43=2;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_USCORE:
            case RULE_HEXINT:
            case RULE_MIXID:
            case RULE_NEGINT:
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
            case 39:
            case 41:
            case 46:
            case 48:
            case 51:
            case 60:
            case 61:
            case 62:
            case 63:
            case 65:
                {
                alt43=1;
                }
                break;
            case RULE_ID:
                {
                int LA43_2 = input.LA(2);

                if ( (LA43_2==EOF||(LA43_2>=RULE_ID && LA43_2<=RULE_S)||(LA43_2>=RULE_LESS && LA43_2<=RULE_HEXINT)||(LA43_2>=RULE_BS && LA43_2<=RULE_DUALS)||LA43_2==25||LA43_2==39||LA43_2==41||LA43_2==44||LA43_2==47||(LA43_2>=53 && LA43_2<=59)||(LA43_2>=61 && LA43_2<=63)||LA43_2==65) ) {
                    alt43=1;
                }
                else if ( (LA43_2==52) ) {
                    alt43=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_S:
                {
                int LA43_3 = input.LA(2);

                if ( (LA43_3==52) ) {
                    alt43=2;
                }
                else if ( (LA43_3==EOF||(LA43_3>=RULE_ID && LA43_3<=RULE_S)||(LA43_3>=RULE_LESS && LA43_3<=RULE_HEXINT)||(LA43_3>=RULE_BS && LA43_3<=RULE_DUALS)||LA43_3==25||LA43_3==39||LA43_3==41||LA43_3==44||LA43_3==47||(LA43_3>=53 && LA43_3<=59)||(LA43_3>=61 && LA43_3<=63)||LA43_3==65) ) {
                    alt43=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1981:2: ( (lv_exp_0_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1981:2: ( (lv_exp_0_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1982:1: (lv_exp_0_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1982:1: (lv_exp_0_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1983:3: lv_exp_0_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3815);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2000:6: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2000:6: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2000:7: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2000:7: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2001:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2001:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2002:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2002:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==RULE_ID) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==RULE_S) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2003:3: lv_name_1_1= RULE_ID
                            {
                            lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonadicExp3841); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_1_1, grammarAccess.getMonadicExpAccess().getNameIDTerminalRuleCall_1_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getMonadicExpRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_1_1, 
                                      		"ID");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2018:8: lv_name_1_2= RULE_S
                            {
                            lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleMonadicExp3861); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_1_2, grammarAccess.getMonadicExpAccess().getNameSTerminalRuleCall_1_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getMonadicExpRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_1_2, 
                                      		"S");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleMonadicExp3881); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getMonadicExpAccess().getLessThanSignHyphenMinusKeyword_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2040:1: ( (lv_exp_3_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2041:1: (lv_exp_3_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2041:1: (lv_exp_3_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2042:3: lv_exp_3_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3902);
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


    // $ANTLR start "entryRuleOrElseExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2066:1: entryRuleOrElseExp returns [EObject current=null] : iv_ruleOrElseExp= ruleOrElseExp EOF ;
    public final EObject entryRuleOrElseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrElseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2067:2: (iv_ruleOrElseExp= ruleOrElseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2068:2: iv_ruleOrElseExp= ruleOrElseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrElseExpRule()); 
            }
            pushFollow(FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3939);
            iv_ruleOrElseExp=ruleOrElseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrElseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrElseExp3949); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2075:1: ruleOrElseExp returns [EObject current=null] : (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) ;
    public final EObject ruleOrElseExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_AndAlsoExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:28: ( (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2079:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2079:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2080:5: this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrElseExpAccess().getAndAlsoExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3996);
            this_AndAlsoExp_0=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndAlsoExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2088:1: ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==53) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2088:2: () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2088:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2089:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2094:2: ( (lv_name_2_0= 'or' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2095:1: (lv_name_2_0= 'or' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2095:1: (lv_name_2_0= 'or' )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2096:3: lv_name_2_0= 'or'
            	    {
            	    lv_name_2_0=(Token)match(input,53,FOLLOW_53_in_ruleOrElseExp4023); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_name_2_0, grammarAccess.getOrElseExpAccess().getNameOrKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getOrElseExpRule());
            	      	        }
            	             		setWithLastConsumed(current, "name", lv_name_2_0, "or");
            	      	    
            	    }

            	    }


            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2109:2: ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2110:1: (lv_right_3_0= ruleAndAlsoExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2110:1: (lv_right_3_0= ruleAndAlsoExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2111:3: lv_right_3_0= ruleAndAlsoExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrElseExpAccess().getRightAndAlsoExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp4057);
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
            	    break loop44;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2135:1: entryRuleAndAlsoExp returns [EObject current=null] : iv_ruleAndAlsoExp= ruleAndAlsoExp EOF ;
    public final EObject entryRuleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndAlsoExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2136:2: (iv_ruleAndAlsoExp= ruleAndAlsoExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2137:2: iv_ruleAndAlsoExp= ruleAndAlsoExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndAlsoExpRule()); 
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp4095);
            iv_ruleAndAlsoExp=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndAlsoExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndAlsoExp4105); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2144:1: ruleAndAlsoExp returns [EObject current=null] : (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* ) ;
    public final EObject ruleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_RExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2147:28: ( (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2148:1: (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2148:1: (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2149:5: this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp4152);
            this_RExp_0=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2157:1: ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==54) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2157:2: () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2157:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2158:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2163:2: ( (lv_name_2_0= 'and' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2164:1: (lv_name_2_0= 'and' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2164:1: (lv_name_2_0= 'and' )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2165:3: lv_name_2_0= 'and'
            	    {
            	    lv_name_2_0=(Token)match(input,54,FOLLOW_54_in_ruleAndAlsoExp4179); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_name_2_0, grammarAccess.getAndAlsoExpAccess().getNameAndKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAndAlsoExpRule());
            	      	        }
            	             		setWithLastConsumed(current, "name", lv_name_2_0, "and");
            	      	    
            	    }

            	    }


            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2178:2: ( (lv_right_3_0= ruleRExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2179:1: (lv_right_3_0= ruleRExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2179:1: (lv_right_3_0= ruleRExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2180:3: lv_right_3_0= ruleRExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRightRExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp4213);
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
            	    break loop45;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2204:1: entryRuleRExp returns [EObject current=null] : iv_ruleRExp= ruleRExp EOF ;
    public final EObject entryRuleRExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2205:2: (iv_ruleRExp= ruleRExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2206:2: iv_ruleRExp= ruleRExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRExpRule()); 
            }
            pushFollow(FOLLOW_ruleRExp_in_entryRuleRExp4251);
            iv_ruleRExp=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRExp4261); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2213:1: ruleRExp returns [EObject current=null] : (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) ;
    public final EObject ruleRExp() throws RecognitionException {
        EObject current = null;

        EObject this_AExp_0 = null;

        AntlrDatatypeRuleToken lv_sym_1_0 = null;

        EObject lv_aexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2216:28: ( (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2217:1: (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2217:1: (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2218:5: this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRExpAccess().getAExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAExp_in_ruleRExp4308);
            this_AExp_0=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2226:1: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            loop46:
            do {
                int alt46=2;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2226:2: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2226:2: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2226:3: ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2231:1: (lv_sym_1_0= ruleSYM )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2232:3: lv_sym_1_0= ruleSYM
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getSymSYMParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSYM_in_ruleRExp4339);
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2248:2: ( (lv_aexps_2_0= ruleAExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2249:1: (lv_aexps_2_0= ruleAExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2249:1: (lv_aexps_2_0= ruleAExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2250:3: lv_aexps_2_0= ruleAExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getAexpsAExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAExp_in_ruleRExp4360);
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
            	    break loop46;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2274:1: entryRuleAExp returns [EObject current=null] : iv_ruleAExp= ruleAExp EOF ;
    public final EObject entryRuleAExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2275:2: (iv_ruleAExp= ruleAExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2276:2: iv_ruleAExp= ruleAExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpRule()); 
            }
            pushFollow(FOLLOW_ruleAExp_in_entryRuleAExp4398);
            iv_ruleAExp=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExp4408); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2283:1: ruleAExp returns [EObject current=null] : (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) ;
    public final EObject ruleAExp() throws RecognitionException {
        EObject current = null;

        Token lv_sign_1_1=null;
        Token lv_sign_1_2=null;
        EObject this_MExp_0 = null;

        EObject lv_mexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2286:28: ( (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2287:1: (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2287:1: (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2288:5: this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAExpAccess().getMExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMExp_in_ruleAExp4455);
            this_MExp_0=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2296:1: ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=55 && LA48_0<=56)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2296:2: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2296:2: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2297:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2297:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2298:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2298:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
            	    int alt47=2;
            	    int LA47_0 = input.LA(1);

            	    if ( (LA47_0==55) ) {
            	        alt47=1;
            	    }
            	    else if ( (LA47_0==56) ) {
            	        alt47=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 47, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt47) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2299:3: lv_sign_1_1= '+'
            	            {
            	            lv_sign_1_1=(Token)match(input,55,FOLLOW_55_in_ruleAExp4475); if (state.failed) return current;
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2311:8: lv_sign_1_2= '-'
            	            {
            	            lv_sign_1_2=(Token)match(input,56,FOLLOW_56_in_ruleAExp4504); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2326:2: ( (lv_mexps_2_0= ruleMExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2327:1: (lv_mexps_2_0= ruleMExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2327:1: (lv_mexps_2_0= ruleMExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2328:3: lv_mexps_2_0= ruleMExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAExpAccess().getMexpsMExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMExp_in_ruleAExp4541);
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
    // $ANTLR end "ruleAExp"


    // $ANTLR start "entryRuleMExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2352:1: entryRuleMExp returns [EObject current=null] : iv_ruleMExp= ruleMExp EOF ;
    public final EObject entryRuleMExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2353:2: (iv_ruleMExp= ruleMExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2354:2: iv_ruleMExp= ruleMExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMExpRule()); 
            }
            pushFollow(FOLLOW_ruleMExp_in_entryRuleMExp4579);
            iv_ruleMExp=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMExp4589); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2361:1: ruleMExp returns [EObject current=null] : (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) ;
    public final EObject ruleMExp() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_1=null;
        Token lv_symbol_1_2=null;
        EObject this_SelectExp_0 = null;

        EObject lv_applyexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2364:28: ( (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2365:1: (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2365:1: (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2366:5: this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMExpAccess().getSelectExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleSelectExp_in_ruleMExp4636);
            this_SelectExp_0=ruleSelectExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_SelectExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2374:1: ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=57 && LA50_0<=58)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2374:2: ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2374:2: ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2375:1: ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2375:1: ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2376:1: (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2376:1: (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' )
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==57) ) {
            	        alt49=1;
            	    }
            	    else if ( (LA49_0==58) ) {
            	        alt49=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2377:3: lv_symbol_1_1= '*'
            	            {
            	            lv_symbol_1_1=(Token)match(input,57,FOLLOW_57_in_ruleMExp4656); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_symbol_1_1, grammarAccess.getMExpAccess().getSymbolAsteriskKeyword_1_0_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMExpRule());
            	              	        }
            	                     		addWithLastConsumed(current, "symbol", lv_symbol_1_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2389:8: lv_symbol_1_2= '%'
            	            {
            	            lv_symbol_1_2=(Token)match(input,58,FOLLOW_58_in_ruleMExp4685); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_symbol_1_2, grammarAccess.getMExpAccess().getSymbolPercentSignKeyword_1_0_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMExpRule());
            	              	        }
            	                     		addWithLastConsumed(current, "symbol", lv_symbol_1_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2404:2: ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2405:1: (lv_applyexps_2_0= ruleApplyExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2405:1: (lv_applyexps_2_0= ruleApplyExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2406:3: lv_applyexps_2_0= ruleApplyExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMExpAccess().getApplyexpsApplyExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleApplyExp_in_ruleMExp4722);
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
            	    break loop50;
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


    // $ANTLR start "entryRuleSelectExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2430:1: entryRuleSelectExp returns [EObject current=null] : iv_ruleSelectExp= ruleSelectExp EOF ;
    public final EObject entryRuleSelectExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2431:2: (iv_ruleSelectExp= ruleSelectExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2432:2: iv_ruleSelectExp= ruleSelectExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelectExpRule()); 
            }
            pushFollow(FOLLOW_ruleSelectExp_in_entryRuleSelectExp4760);
            iv_ruleSelectExp=ruleSelectExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelectExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectExp4770); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectExp"


    // $ANTLR start "ruleSelectExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2439:1: ruleSelectExp returns [EObject current=null] : (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) ;
    public final EObject ruleSelectExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ApplyExp_0 = null;

        EObject lv_applyexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2442:28: ( (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2443:1: (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2443:1: (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2444:5: this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSelectExpAccess().getApplyExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleApplyExp_in_ruleSelectExp4817);
            this_ApplyExp_0=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ApplyExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2452:1: (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==59) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2452:3: otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    {
            	    otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleSelectExp4829); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getSelectExpAccess().getCircumflexAccentKeyword_1_0());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2456:1: ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2457:1: (lv_applyexps_2_0= ruleApplyExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2457:1: (lv_applyexps_2_0= ruleApplyExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2458:3: lv_applyexps_2_0= ruleApplyExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSelectExpAccess().getApplyexpsApplyExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleApplyExp_in_ruleSelectExp4850);
            	    lv_applyexps_2_0=ruleApplyExp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSelectExpRule());
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
            	    break loop51;
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
    // $ANTLR end "ruleSelectExp"


    // $ANTLR start "entryRuleApplyExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2482:1: entryRuleApplyExp returns [EObject current=null] : iv_ruleApplyExp= ruleApplyExp EOF ;
    public final EObject entryRuleApplyExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2483:2: (iv_ruleApplyExp= ruleApplyExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2484:2: iv_ruleApplyExp= ruleApplyExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getApplyExpRule()); 
            }
            pushFollow(FOLLOW_ruleApplyExp_in_entryRuleApplyExp4888);
            iv_ruleApplyExp=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleApplyExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleApplyExp4898); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2491:1: ruleApplyExp returns [EObject current=null] : ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) ) ) ;
    public final EObject ruleApplyExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_AtomicExp_1 = null;

        EObject lv_atomicExp_2_0 = null;

        EObject lv_args_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2494:28: ( ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2495:1: ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2495:1: ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==60) ) {
                alt52=1;
            }
            else if ( ((LA52_0>=RULE_ID && LA52_0<=RULE_S)||LA52_0==RULE_STRING||LA52_0==RULE_HEXINT||(LA52_0>=RULE_NEGINT && LA52_0<=RULE_DUALS)||LA52_0==39||LA52_0==41||(LA52_0>=61 && LA52_0<=63)||LA52_0==65) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2495:2: (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2495:2: (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2495:4: otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp
                    {
                    otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleApplyExp4936); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getApplyExpAccess().getTildeKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getApplyExpAccess().getAtomicExpParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAtomicExp_in_ruleApplyExp4958);
                    this_AtomicExp_1=ruleAtomicExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AtomicExp_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2509:6: ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2509:6: ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2509:7: ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2509:7: ( (lv_atomicExp_2_0= ruleAtomicExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2510:1: (lv_atomicExp_2_0= ruleAtomicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2510:1: (lv_atomicExp_2_0= ruleAtomicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2511:3: lv_atomicExp_2_0= ruleAtomicExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getApplyExpAccess().getAtomicExpAtomicExpParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAtomicExp_in_ruleApplyExp4986);
                    lv_atomicExp_2_0=ruleAtomicExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getApplyExpRule());
                      	        }
                             		set(
                             			current, 
                             			"atomicExp",
                              		lv_atomicExp_2_0, 
                              		"AtomicExp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2527:2: ( (lv_args_3_0= ruleArgs ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2528:1: (lv_args_3_0= ruleArgs )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2528:1: (lv_args_3_0= ruleArgs )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2529:3: lv_args_3_0= ruleArgs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getApplyExpAccess().getArgsArgsParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgs_in_ruleApplyExp5007);
                    lv_args_3_0=ruleArgs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getApplyExpRule());
                      	        }
                             		set(
                             			current, 
                             			"args",
                              		lv_args_3_0, 
                              		"Args");
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
    // $ANTLR end "ruleApplyExp"


    // $ANTLR start "entryRuleArgs"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2553:1: entryRuleArgs returns [EObject current=null] : iv_ruleArgs= ruleArgs EOF ;
    public final EObject entryRuleArgs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgs = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2554:2: (iv_ruleArgs= ruleArgs EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2555:2: iv_ruleArgs= ruleArgs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgsRule()); 
            }
            pushFollow(FOLLOW_ruleArgs_in_entryRuleArgs5044);
            iv_ruleArgs=ruleArgs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgs; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgs5054); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgs"


    // $ANTLR start "ruleArgs"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2562:1: ruleArgs returns [EObject current=null] : ( () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' ) ) ;
    public final EObject ruleArgs() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_args_1_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2565:28: ( ( () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2566:1: ( () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2566:1: ( () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2566:2: () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2566:2: ()
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2567:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getArgsAccess().getArgsAction_0(),
                          current);
                  
            }

            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2572:2: ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==EOF||(LA54_0>=RULE_ID && LA54_0<=RULE_S)||(LA54_0>=RULE_LESS && LA54_0<=RULE_DUALS)||(LA54_0>=25 && LA54_0<=26)||(LA54_0>=28 && LA54_0<=31)||(LA54_0>=34 && LA54_0<=35)||(LA54_0>=39 && LA54_0<=42)||LA54_0==47||(LA54_0>=49 && LA54_0<=50)||(LA54_0>=53 && LA54_0<=59)||(LA54_0>=61 && LA54_0<=65)) ) {
                alt54=1;
            }
            else if ( (LA54_0==44) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2572:3: ( (lv_args_1_0= ruleAtomicExp ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2572:3: ( (lv_args_1_0= ruleAtomicExp ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( ((LA53_0>=RULE_ID && LA53_0<=RULE_S)||LA53_0==RULE_STRING||LA53_0==RULE_HEXINT||(LA53_0>=RULE_NEGINT && LA53_0<=RULE_DUALS)||LA53_0==39||LA53_0==41||(LA53_0>=61 && LA53_0<=63)||LA53_0==65) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2573:1: (lv_args_1_0= ruleAtomicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2573:1: (lv_args_1_0= ruleAtomicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2574:3: lv_args_1_0= ruleAtomicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getArgsAccess().getArgsAtomicExpParserRuleCall_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAtomicExp_in_ruleArgs5110);
                    	    lv_args_1_0=ruleAtomicExp();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getArgsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_1_0, 
                    	              		"AtomicExp");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2591:7: otherlv_2= '()'
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleArgs5129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getArgsAccess().getLeftParenthesisRightParenthesisKeyword_1_1());
                          
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
    // $ANTLR end "ruleArgs"


    // $ANTLR start "entryRuleAtomicExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2603:1: entryRuleAtomicExp returns [EObject current=null] : iv_ruleAtomicExp= ruleAtomicExp EOF ;
    public final EObject entryRuleAtomicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2604:2: (iv_ruleAtomicExp= ruleAtomicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2605:2: iv_ruleAtomicExp= ruleAtomicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExpRule()); 
            }
            pushFollow(FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp5166);
            iv_ruleAtomicExp=ruleAtomicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicExp5176); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2612:1: ruleAtomicExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) ) ;
    public final EObject ruleAtomicExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_name_2_1=null;
        Token lv_name_2_2=null;
        Token this_DOT_3=null;
        Token lv_id_4_1=null;
        Token lv_id_4_2=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_name_12_1=null;
        Token lv_name_12_2=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token this_DOT_16=null;
        Token lv_id_17_1=null;
        Token lv_id_17_2=null;
        Token otherlv_19=null;
        Token lv_id_20_1=null;
        Token lv_id_20_2=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token lv_id_24_1=null;
        Token lv_id_24_2=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token lv_name_28_0=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_fields_7_0 = null;

        EObject lv_fields_9_0 = null;

        EObject lv_expr_14_0 = null;

        EObject lv_exps_22_0 = null;

        EObject lv_exps_26_0 = null;

        EObject lv_valDecl_29_0 = null;

        EObject lv_expr_31_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2615:28: ( ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2616:1: ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2616:1: ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) )
            int alt67=8;
            switch ( input.LA(1) ) {
            case RULE_HEXINT:
            case RULE_NEGINT:
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
            case 65:
                {
                alt67=1;
                }
                break;
            case RULE_STRING:
                {
                alt67=2;
                }
                break;
            case RULE_ID:
            case RULE_S:
                {
                alt67=3;
                }
                break;
            case 61:
                {
                alt67=4;
                }
                break;
            case 62:
                {
                alt67=5;
                }
                break;
            case 41:
                {
                alt67=6;
                }
                break;
            case 39:
                {
                alt67=7;
                }
                break;
            case 63:
                {
                alt67=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2616:2: ( (lv_name_0_0= ruleLIT ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2616:2: ( (lv_name_0_0= ruleLIT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2617:1: (lv_name_0_0= ruleLIT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2617:1: (lv_name_0_0= ruleLIT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2618:3: lv_name_0_0= ruleLIT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getNameLITParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLIT_in_ruleAtomicExp5222);
                    lv_name_0_0=ruleLIT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"LIT");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2635:6: ( (lv_name_1_0= RULE_STRING ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2635:6: ( (lv_name_1_0= RULE_STRING ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2636:1: (lv_name_1_0= RULE_STRING )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2636:1: (lv_name_1_0= RULE_STRING )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2637:3: lv_name_1_0= RULE_STRING
                    {
                    lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAtomicExp5245); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getAtomicExpAccess().getNameSTRINGTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExpRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2654:6: ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2654:6: ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2654:7: ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2654:7: ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2655:1: ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2655:1: ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2656:1: (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2656:1: (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S )
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==RULE_ID) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==RULE_S) ) {
                        alt55=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 55, 0, input);

                        throw nvae;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2657:3: lv_name_2_1= RULE_ID
                            {
                            lv_name_2_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5276); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_2_1, grammarAccess.getAtomicExpAccess().getNameIDTerminalRuleCall_2_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_2_1, 
                                      		"ID");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2672:8: lv_name_2_2= RULE_S
                            {
                            lv_name_2_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5296); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_2_2, grammarAccess.getAtomicExpAccess().getNameSTerminalRuleCall_2_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_2_2, 
                                      		"S");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2690:2: ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==RULE_DOT) ) {
                            int LA57_2 = input.LA(2);

                            if ( (LA57_2==RULE_ID) ) {
                                int LA57_3 = input.LA(3);

                                if ( (synpred4_InternalGDSL()) ) {
                                    alt57=1;
                                }


                            }
                            else if ( (LA57_2==RULE_S) ) {
                                int LA57_4 = input.LA(3);

                                if ( (synpred4_InternalGDSL()) ) {
                                    alt57=1;
                                }


                            }


                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2690:3: ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2690:3: ( ( RULE_DOT )=>this_DOT_3= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2690:4: ( RULE_DOT )=>this_DOT_3= RULE_DOT
                    	    {
                    	    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp5322); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_3, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_2_1_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2694:2: ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2695:1: ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2695:1: ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2696:1: (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2696:1: (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S )
                    	    int alt56=2;
                    	    int LA56_0 = input.LA(1);

                    	    if ( (LA56_0==RULE_ID) ) {
                    	        alt56=1;
                    	    }
                    	    else if ( (LA56_0==RULE_S) ) {
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2697:3: lv_id_4_1= RULE_ID
                    	            {
                    	            lv_id_4_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5341); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_id_4_1, grammarAccess.getAtomicExpAccess().getIdIDTerminalRuleCall_2_1_1_0_0()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"id",
                    	                      		lv_id_4_1, 
                    	                      		"ID");
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2712:8: lv_id_4_2= RULE_S
                    	            {
                    	            lv_id_4_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5361); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_id_4_2, grammarAccess.getAtomicExpAccess().getIdSTerminalRuleCall_2_1_1_0_1()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"id",
                    	                      		lv_id_4_2, 
                    	                      		"S");
                    	              	    
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2731:6: ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2731:6: ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2731:7: ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2731:7: ( (lv_name_5_0= '@' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2732:1: (lv_name_5_0= '@' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2732:1: (lv_name_5_0= '@' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2733:3: lv_name_5_0= '@'
                    {
                    lv_name_5_0=(Token)match(input,61,FOLLOW_61_in_ruleAtomicExp5397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_5_0, grammarAccess.getAtomicExpAccess().getNameCommercialAtKeyword_3_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExpRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_5_0, "@");
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,39,FOLLOW_39_in_ruleAtomicExp5422); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_3_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2750:1: ( (lv_fields_7_0= ruleField ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2751:1: (lv_fields_7_0= ruleField )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2751:1: (lv_fields_7_0= ruleField )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2752:3: lv_fields_7_0= ruleField
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp5443);
                    lv_fields_7_0=ruleField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		add(
                             			current, 
                             			"fields",
                              		lv_fields_7_0, 
                              		"Field");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2768:2: (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==34) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2768:4: otherlv_8= ',' ( (lv_fields_9_0= ruleField ) )
                    	    {
                    	    otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExp5456); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getAtomicExpAccess().getCommaKeyword_3_3_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2772:1: ( (lv_fields_9_0= ruleField ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2773:1: (lv_fields_9_0= ruleField )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2773:1: (lv_fields_9_0= ruleField )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2774:3: lv_fields_9_0= ruleField
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_3_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp5477);
                    	    lv_fields_9_0=ruleField();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fields",
                    	              		lv_fields_9_0, 
                    	              		"Field");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,40,FOLLOW_40_in_ruleAtomicExp5491); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_3_4());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2795:6: (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2795:6: (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2795:8: otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) )
                    {
                    otherlv_11=(Token)match(input,62,FOLLOW_62_in_ruleAtomicExp5511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getAtomicExpAccess().getDollarSignKeyword_4_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2799:1: ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2800:1: ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2800:1: ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2801:1: (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2801:1: (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==RULE_ID) ) {
                        alt59=1;
                    }
                    else if ( (LA59_0==RULE_S) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2802:3: lv_name_12_1= RULE_ID
                            {
                            lv_name_12_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5530); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_12_1, grammarAccess.getAtomicExpAccess().getNameIDTerminalRuleCall_4_1_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_12_1, 
                                      		"ID");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2817:8: lv_name_12_2= RULE_S
                            {
                            lv_name_12_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5550); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_12_2, grammarAccess.getAtomicExpAccess().getNameSTerminalRuleCall_4_1_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_12_2, 
                                      		"S");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2836:6: (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2836:6: (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2836:8: otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )*
                    {
                    otherlv_13=(Token)match(input,41,FOLLOW_41_in_ruleAtomicExp5578); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getAtomicExpAccess().getLeftParenthesisKeyword_5_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2840:1: ( (lv_expr_14_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2841:1: (lv_expr_14_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2841:1: (lv_expr_14_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2842:3: lv_expr_14_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExprExpParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5599);
                    lv_expr_14_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_14_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_15=(Token)match(input,42,FOLLOW_42_in_ruleAtomicExp5611); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getAtomicExpAccess().getRightParenthesisKeyword_5_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2862:1: ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==RULE_DOT) ) {
                            int LA61_2 = input.LA(2);

                            if ( (LA61_2==RULE_ID) ) {
                                int LA61_3 = input.LA(3);

                                if ( (synpred5_InternalGDSL()) ) {
                                    alt61=1;
                                }


                            }
                            else if ( (LA61_2==RULE_S) ) {
                                int LA61_4 = input.LA(3);

                                if ( (synpred5_InternalGDSL()) ) {
                                    alt61=1;
                                }


                            }


                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2862:2: ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2862:2: ( ( RULE_DOT )=>this_DOT_16= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2862:3: ( RULE_DOT )=>this_DOT_16= RULE_DOT
                    	    {
                    	    this_DOT_16=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp5629); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_16, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_5_3_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2866:2: ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2867:1: ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2867:1: ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2868:1: (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2868:1: (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S )
                    	    int alt60=2;
                    	    int LA60_0 = input.LA(1);

                    	    if ( (LA60_0==RULE_ID) ) {
                    	        alt60=1;
                    	    }
                    	    else if ( (LA60_0==RULE_S) ) {
                    	        alt60=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 60, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt60) {
                    	        case 1 :
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2869:3: lv_id_17_1= RULE_ID
                    	            {
                    	            lv_id_17_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5648); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_id_17_1, grammarAccess.getAtomicExpAccess().getIdIDTerminalRuleCall_5_3_1_0_0()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"id",
                    	                      		lv_id_17_1, 
                    	                      		"ID");
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2884:8: lv_id_17_2= RULE_S
                    	            {
                    	            lv_id_17_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5668); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              			newLeafNode(lv_id_17_2, grammarAccess.getAtomicExpAccess().getIdSTerminalRuleCall_5_3_1_0_1()); 
                    	              		
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                    	              	        }
                    	                     		addWithLastConsumed(
                    	                     			current, 
                    	                     			"id",
                    	                      		lv_id_17_2, 
                    	                      		"S");
                    	              	    
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 7 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2903:6: ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2903:6: ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2903:7: () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2903:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2904:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExpAccess().getAtomicExpAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_19=(Token)match(input,39,FOLLOW_39_in_ruleAtomicExp5707); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_6_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2913:1: ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( ((LA65_0>=RULE_ID && LA65_0<=RULE_S)) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2913:2: ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2913:2: ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2914:1: ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2914:1: ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2915:1: (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2915:1: (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S )
                            int alt62=2;
                            int LA62_0 = input.LA(1);

                            if ( (LA62_0==RULE_ID) ) {
                                alt62=1;
                            }
                            else if ( (LA62_0==RULE_S) ) {
                                alt62=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 62, 0, input);

                                throw nvae;
                            }
                            switch (alt62) {
                                case 1 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2916:3: lv_id_20_1= RULE_ID
                                    {
                                    lv_id_20_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5727); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_id_20_1, grammarAccess.getAtomicExpAccess().getIdIDTerminalRuleCall_6_2_0_0_0()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getAtomicExpRule());
                                      	        }
                                             		addWithLastConsumed(
                                             			current, 
                                             			"id",
                                              		lv_id_20_1, 
                                              		"ID");
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2931:8: lv_id_20_2= RULE_S
                                    {
                                    lv_id_20_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5747); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_id_20_2, grammarAccess.getAtomicExpAccess().getIdSTerminalRuleCall_6_2_0_0_1()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getAtomicExpRule());
                                      	        }
                                             		addWithLastConsumed(
                                             			current, 
                                             			"id",
                                              		lv_id_20_2, 
                                              		"S");
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }

                            otherlv_21=(Token)match(input,29,FOLLOW_29_in_ruleAtomicExp5767); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_21, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_6_2_1());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2953:1: ( (lv_exps_22_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2954:1: (lv_exps_22_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2954:1: (lv_exps_22_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2955:3: lv_exps_22_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_6_2_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5788);
                            lv_exps_22_0=ruleExp();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2971:2: (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )*
                            loop64:
                            do {
                                int alt64=2;
                                int LA64_0 = input.LA(1);

                                if ( (LA64_0==34) ) {
                                    alt64=1;
                                }


                                switch (alt64) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2971:4: otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) )
                            	    {
                            	    otherlv_23=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExp5801); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_23, grammarAccess.getAtomicExpAccess().getCommaKeyword_6_2_3_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2975:1: ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2976:1: ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2976:1: ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2977:1: (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2977:1: (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S )
                            	    int alt63=2;
                            	    int LA63_0 = input.LA(1);

                            	    if ( (LA63_0==RULE_ID) ) {
                            	        alt63=1;
                            	    }
                            	    else if ( (LA63_0==RULE_S) ) {
                            	        alt63=2;
                            	    }
                            	    else {
                            	        if (state.backtracking>0) {state.failed=true; return current;}
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 63, 0, input);

                            	        throw nvae;
                            	    }
                            	    switch (alt63) {
                            	        case 1 :
                            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2978:3: lv_id_24_1= RULE_ID
                            	            {
                            	            lv_id_24_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5820); if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              			newLeafNode(lv_id_24_1, grammarAccess.getAtomicExpAccess().getIdIDTerminalRuleCall_6_2_3_1_0_0()); 
                            	              		
                            	            }
                            	            if ( state.backtracking==0 ) {

                            	              	        if (current==null) {
                            	              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                            	              	        }
                            	                     		addWithLastConsumed(
                            	                     			current, 
                            	                     			"id",
                            	                      		lv_id_24_1, 
                            	                      		"ID");
                            	              	    
                            	            }

                            	            }
                            	            break;
                            	        case 2 :
                            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2993:8: lv_id_24_2= RULE_S
                            	            {
                            	            lv_id_24_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5840); if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              			newLeafNode(lv_id_24_2, grammarAccess.getAtomicExpAccess().getIdSTerminalRuleCall_6_2_3_1_0_1()); 
                            	              		
                            	            }
                            	            if ( state.backtracking==0 ) {

                            	              	        if (current==null) {
                            	              	            current = createModelElement(grammarAccess.getAtomicExpRule());
                            	              	        }
                            	                     		addWithLastConsumed(
                            	                     			current, 
                            	                     			"id",
                            	                      		lv_id_24_2, 
                            	                      		"S");
                            	              	    
                            	            }

                            	            }
                            	            break;

                            	    }


                            	    }


                            	    }

                            	    otherlv_25=(Token)match(input,29,FOLLOW_29_in_ruleAtomicExp5860); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_25, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_6_2_3_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3015:1: ( (lv_exps_26_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3016:1: (lv_exps_26_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3016:1: (lv_exps_26_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3017:3: lv_exps_26_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_6_2_3_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5881);
                            	    lv_exps_26_0=ruleExp();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"exps",
                            	              		lv_exps_26_0, 
                            	              		"Exp");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop64;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_27=(Token)match(input,40,FOLLOW_40_in_ruleAtomicExp5897); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_6_3());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3038:6: ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3038:6: ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3038:7: ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3038:7: ( (lv_name_28_0= 'let' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3039:1: (lv_name_28_0= 'let' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3039:1: (lv_name_28_0= 'let' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3040:3: lv_name_28_0= 'let'
                    {
                    lv_name_28_0=(Token)match(input,63,FOLLOW_63_in_ruleAtomicExp5923); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_28_0, grammarAccess.getAtomicExpAccess().getNameLetKeyword_7_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExpRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_28_0, "let");
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3053:2: ( (lv_valDecl_29_0= ruleValueDecl ) )+
                    int cnt66=0;
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==31) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3054:1: (lv_valDecl_29_0= ruleValueDecl )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3054:1: (lv_valDecl_29_0= ruleValueDecl )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3055:3: lv_valDecl_29_0= ruleValueDecl
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getValDeclValueDeclParserRuleCall_7_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleValueDecl_in_ruleAtomicExp5957);
                    	    lv_valDecl_29_0=ruleValueDecl();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"valDecl",
                    	              		lv_valDecl_29_0, 
                    	              		"ValueDecl");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt66 >= 1 ) break loop66;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(66, input);
                                throw eee;
                        }
                        cnt66++;
                    } while (true);

                    otherlv_30=(Token)match(input,64,FOLLOW_64_in_ruleAtomicExp5970); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_30, grammarAccess.getAtomicExpAccess().getInKeyword_7_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3075:1: ( (lv_expr_31_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3076:1: (lv_expr_31_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3076:1: (lv_expr_31_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3077:3: lv_expr_31_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExprExpParserRuleCall_7_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5991);
                    lv_expr_31_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_31_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_32=(Token)match(input,47,FOLLOW_47_in_ruleAtomicExp6003); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_32, grammarAccess.getAtomicExpAccess().getEndKeyword_7_4());
                          
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3105:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3106:2: (iv_ruleField= ruleField EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3107:2: iv_ruleField= ruleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_ruleField_in_entryRuleField6040);
            iv_ruleField=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleField6050); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3114:1: ruleField returns [EObject current=null] : ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_name_4_1=null;
        Token lv_name_4_2=null;
        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3117:28: ( ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3118:1: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3118:1: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=RULE_ID && LA70_0<=RULE_S)) ) {
                alt70=1;
            }
            else if ( (LA70_0==60) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3118:2: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3118:2: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3118:3: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3118:3: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3119:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3119:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3120:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3120:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==RULE_ID) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==RULE_S) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3121:3: lv_name_0_1= RULE_ID
                            {
                            lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleField6095); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_0_1, grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_0_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getFieldRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_0_1, 
                                      		"ID");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3136:8: lv_name_0_2= RULE_S
                            {
                            lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleField6115); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_0_2, grammarAccess.getFieldAccess().getNameSTerminalRuleCall_0_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getFieldRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_0_2, 
                                      		"S");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleField6135); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getFieldAccess().getEqualsSignKeyword_0_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3158:1: ( (lv_exp_2_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3159:1: (lv_exp_2_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3159:1: (lv_exp_2_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3160:3: lv_exp_2_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFieldAccess().getExpExpParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleField6156);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3177:6: (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3177:6: (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3177:8: otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) )
                    {
                    otherlv_3=(Token)match(input,60,FOLLOW_60_in_ruleField6176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getTildeKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3181:1: ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3182:1: ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3182:1: ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3183:1: (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3183:1: (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S )
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==RULE_ID) ) {
                        alt69=1;
                    }
                    else if ( (LA69_0==RULE_S) ) {
                        alt69=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 0, input);

                        throw nvae;
                    }
                    switch (alt69) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3184:3: lv_name_4_1= RULE_ID
                            {
                            lv_name_4_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleField6195); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_4_1, grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_1_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getFieldRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_4_1, 
                                      		"ID");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3199:8: lv_name_4_2= RULE_S
                            {
                            lv_name_4_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleField6215); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_4_2, grammarAccess.getFieldAccess().getNameSTerminalRuleCall_1_1_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getFieldRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_4_2, 
                                      		"S");
                              	    
                            }

                            }
                            break;

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3225:1: entryRuleValueDecl returns [EObject current=null] : iv_ruleValueDecl= ruleValueDecl EOF ;
    public final EObject entryRuleValueDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3226:2: (iv_ruleValueDecl= ruleValueDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3227:2: iv_ruleValueDecl= ruleValueDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueDeclRule()); 
            }
            pushFollow(FOLLOW_ruleValueDecl_in_entryRuleValueDecl6260);
            iv_ruleValueDecl=ruleValueDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueDecl6270); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3234:1: ruleValueDecl returns [EObject current=null] : (otherlv_0= 'val' ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ;
    public final EObject ruleValueDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_ids_3_1=null;
        Token lv_ids_3_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_exp_5_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3237:28: ( (otherlv_0= 'val' ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3238:1: (otherlv_0= 'val' ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3238:1: (otherlv_0= 'val' ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3238:3: otherlv_0= 'val' ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleValueDecl6307); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getValueDeclAccess().getValKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3242:1: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=RULE_ID && LA72_0<=RULE_S)) ) {
                alt72=1;
            }
            else if ( ((LA72_0>=RULE_LESS && LA72_0<=RULE_GREATER)||(LA72_0>=RULE_DOT && LA72_0<=RULE_USCORE)||(LA72_0>=RULE_BS && LA72_0<=RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER)) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3242:2: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3242:2: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3243:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3243:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3244:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3244:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==RULE_ID) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==RULE_S) ) {
                        alt71=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3245:3: lv_name_1_1= RULE_ID
                            {
                            lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueDecl6327); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_1_1, grammarAccess.getValueDeclAccess().getNameIDTerminalRuleCall_1_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getValueDeclRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_1_1, 
                                      		"ID");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3260:8: lv_name_1_2= RULE_S
                            {
                            lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleValueDecl6347); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_1_2, grammarAccess.getValueDeclAccess().getNameSTerminalRuleCall_1_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getValueDeclRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_1_2, 
                                      		"S");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3279:6: ( (lv_name_2_0= ruleSYM ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3279:6: ( (lv_name_2_0= ruleSYM ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3280:1: (lv_name_2_0= ruleSYM )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3280:1: (lv_name_2_0= ruleSYM )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3281:3: lv_name_2_0= ruleSYM
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueDeclAccess().getNameSYMParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSYM_in_ruleValueDecl6382);
                    lv_name_2_0=ruleSYM();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueDeclRule());
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3297:3: ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_S)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3298:1: ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3298:1: ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3299:1: (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3299:1: (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S )
            	    int alt73=2;
            	    int LA73_0 = input.LA(1);

            	    if ( (LA73_0==RULE_ID) ) {
            	        alt73=1;
            	    }
            	    else if ( (LA73_0==RULE_S) ) {
            	        alt73=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 73, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt73) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3300:3: lv_ids_3_1= RULE_ID
            	            {
            	            lv_ids_3_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueDecl6402); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_ids_3_1, grammarAccess.getValueDeclAccess().getIdsIDTerminalRuleCall_2_0_0()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getValueDeclRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"ids",
            	                      		lv_ids_3_1, 
            	                      		"ID");
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3315:8: lv_ids_3_2= RULE_S
            	            {
            	            lv_ids_3_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleValueDecl6422); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              			newLeafNode(lv_ids_3_2, grammarAccess.getValueDeclAccess().getIdsSTerminalRuleCall_2_0_1()); 
            	              		
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getValueDeclRule());
            	              	        }
            	                     		addWithLastConsumed(
            	                     			current, 
            	                     			"ids",
            	                      		lv_ids_3_2, 
            	                      		"S");
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleValueDecl6443); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getValueDeclAccess().getEqualsSignKeyword_3());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3337:1: ( (lv_exp_5_0= ruleExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3338:1: (lv_exp_5_0= ruleExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3338:1: (lv_exp_5_0= ruleExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3339:3: lv_exp_5_0= ruleExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueDeclAccess().getExpExpParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExp_in_ruleValueDecl6464);
            lv_exp_5_0=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueDeclRule());
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


    // $ANTLR start "entryRulePAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3363:1: entryRulePAT returns [EObject current=null] : iv_rulePAT= rulePAT EOF ;
    public final EObject entryRulePAT() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3364:2: (iv_rulePAT= rulePAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3365:2: iv_rulePAT= rulePAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPATRule()); 
            }
            pushFollow(FOLLOW_rulePAT_in_entryRulePAT6500);
            iv_rulePAT=rulePAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePAT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePAT6510); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePAT"


    // $ANTLR start "rulePAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3372:1: rulePAT returns [EObject current=null] : ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) ) ;
    public final EObject rulePAT() throws RecognitionException {
        EObject current = null;

        Token lv_uscore_0_0=null;
        Token lv_id_2_1=null;
        Token lv_id_2_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_int_1_0 = null;

        EObject lv_pat_3_0 = null;

        AntlrDatatypeRuleToken lv_bitpat_5_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3375:28: ( ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3376:1: ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3376:1: ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) )
            int alt77=4;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_USCORE) ) {
                alt77=1;
            }
            else if ( (LA77_0==RULE_POSINT_WO_DUALS) && (synpred6_InternalGDSL())) {
                alt77=2;
            }
            else if ( (LA77_0==RULE_DUALS) && (synpred6_InternalGDSL())) {
                alt77=2;
            }
            else if ( (LA77_0==RULE_HEXINT) && (synpred6_InternalGDSL())) {
                alt77=2;
            }
            else if ( (LA77_0==RULE_NEGINT) && (synpred6_InternalGDSL())) {
                alt77=2;
            }
            else if ( (LA77_0==RULE_ID) && (synpred7_InternalGDSL())) {
                alt77=3;
            }
            else if ( (LA77_0==RULE_S) && (synpred7_InternalGDSL())) {
                alt77=3;
            }
            else if ( (LA77_0==65) ) {
                alt77=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3376:2: ( (lv_uscore_0_0= RULE_USCORE ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3376:2: ( (lv_uscore_0_0= RULE_USCORE ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3377:1: (lv_uscore_0_0= RULE_USCORE )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3377:1: (lv_uscore_0_0= RULE_USCORE )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3378:3: lv_uscore_0_0= RULE_USCORE
                    {
                    lv_uscore_0_0=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_rulePAT6552); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_uscore_0_0, grammarAccess.getPATAccess().getUscoreUSCORETerminalRuleCall_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPATRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"uscore",
                              		lv_uscore_0_0, 
                              		"USCORE");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3395:6: ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3395:6: ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3395:7: ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3399:5: ( (lv_int_1_0= ruleINTEGER ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3400:1: (lv_int_1_0= ruleINTEGER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3400:1: (lv_int_1_0= ruleINTEGER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3401:3: lv_int_1_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPATAccess().getIntINTEGERParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_rulePAT6597);
                    lv_int_1_0=ruleINTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPATRule());
                      	        }
                             		set(
                             			current, 
                             			"int",
                              		lv_int_1_0, 
                              		"INTEGER");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:6: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:6: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:7: ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3432:7: ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3432:8: ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3432:8: ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3433:1: ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3433:1: ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3434:1: (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3434:1: (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S )
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==RULE_ID) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==RULE_S) ) {
                        alt75=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);

                        throw nvae;
                    }
                    switch (alt75) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3435:3: lv_id_2_1= RULE_ID
                            {
                            lv_id_2_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePAT6665); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_id_2_1, grammarAccess.getPATAccess().getIdIDTerminalRuleCall_2_0_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPATRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"id",
                                      		lv_id_2_1, 
                                      		"ID");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3450:8: lv_id_2_2= RULE_S
                            {
                            lv_id_2_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_rulePAT6685); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_id_2_2, grammarAccess.getPATAccess().getIdSTerminalRuleCall_2_0_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPATRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"id",
                                      		lv_id_2_2, 
                                      		"S");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3468:2: ( (lv_pat_3_0= rulePAT ) )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( ((LA76_0>=RULE_ID && LA76_0<=RULE_S)||(LA76_0>=RULE_USCORE && LA76_0<=RULE_HEXINT)||(LA76_0>=RULE_NEGINT && LA76_0<=RULE_DUALS)||LA76_0==65) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3469:1: (lv_pat_3_0= rulePAT )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3469:1: (lv_pat_3_0= rulePAT )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3470:3: lv_pat_3_0= rulePAT
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPATAccess().getPatPATParserRuleCall_2_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePAT_in_rulePAT6714);
                            lv_pat_3_0=rulePAT();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPATRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"pat",
                                      		lv_pat_3_0, 
                                      		"PAT");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3487:6: (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3487:6: (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3487:8: otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\''
                    {
                    otherlv_4=(Token)match(input,65,FOLLOW_65_in_rulePAT6736); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPATAccess().getApostropheKeyword_3_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3491:1: ( (lv_bitpat_5_0= ruleBITPAT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3492:1: (lv_bitpat_5_0= ruleBITPAT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3492:1: (lv_bitpat_5_0= ruleBITPAT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3493:3: lv_bitpat_5_0= ruleBITPAT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPATAccess().getBitpatBITPATParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBITPAT_in_rulePAT6757);
                    lv_bitpat_5_0=ruleBITPAT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPATRule());
                      	        }
                             		set(
                             			current, 
                             			"bitpat",
                              		lv_bitpat_5_0, 
                              		"BITPAT");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,65,FOLLOW_65_in_rulePAT6769); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPATAccess().getApostropheKeyword_3_2());
                          
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
    // $ANTLR end "rulePAT"


    // $ANTLR start "entryRuleCONS"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3521:1: entryRuleCONS returns [EObject current=null] : iv_ruleCONS= ruleCONS EOF ;
    public final EObject entryRuleCONS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCONS = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3522:2: (iv_ruleCONS= ruleCONS EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3523:2: iv_ruleCONS= ruleCONS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCONSRule()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS6806);
            iv_ruleCONS=ruleCONS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCONS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS6816); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3530:1: ruleCONS returns [EObject current=null] : ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) ) ;
    public final EObject ruleCONS() throws RecognitionException {
        EObject current = null;

        Token lv_conName_0_1=null;
        Token lv_conName_0_2=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3533:28: ( ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3534:1: ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3534:1: ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3535:1: ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3535:1: ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3536:1: (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3536:1: (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                alt78=1;
            }
            else if ( (LA78_0==RULE_S) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3537:3: lv_conName_0_1= RULE_ID
                    {
                    lv_conName_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCONS6859); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_conName_0_1, grammarAccess.getCONSAccess().getConNameIDTerminalRuleCall_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCONSRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"conName",
                              		lv_conName_0_1, 
                              		"ID");
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3552:8: lv_conName_0_2= RULE_S
                    {
                    lv_conName_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleCONS6879); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_conName_0_2, grammarAccess.getCONSAccess().getConNameSTerminalRuleCall_0_1()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCONSRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"conName",
                              		lv_conName_0_2, 
                              		"S");
                      	    
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
    // $ANTLR end "ruleCONS"


    // $ANTLR start "entryRuleDECODEPAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3578:1: entryRuleDECODEPAT returns [String current=null] : iv_ruleDECODEPAT= ruleDECODEPAT EOF ;
    public final String entryRuleDECODEPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDECODEPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3579:2: (iv_ruleDECODEPAT= ruleDECODEPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3580:2: iv_ruleDECODEPAT= ruleDECODEPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDECODEPATRule()); 
            }
            pushFollow(FOLLOW_ruleDECODEPAT_in_entryRuleDECODEPAT6923);
            iv_ruleDECODEPAT=ruleDECODEPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDECODEPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDECODEPAT6934); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDECODEPAT"


    // $ANTLR start "ruleDECODEPAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3587:1: ruleDECODEPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT ) ;
    public final AntlrDatatypeRuleToken ruleDECODEPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_BITPAT_1 = null;

        AntlrDatatypeRuleToken this_TOKPAT_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3590:28: ( ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3591:1: ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3591:1: ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==65) ) {
                alt80=1;
            }
            else if ( ((LA80_0>=RULE_ID && LA80_0<=RULE_S)||LA80_0==RULE_HEXINT) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3591:2: (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3591:2: (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3592:2: kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\''
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleDECODEPAT6973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDECODEPATAccess().getApostropheKeyword_0_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3597:1: (this_BITPAT_1= ruleBITPAT )+
                    int cnt79=0;
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( ((LA79_0>=RULE_ID && LA79_0<=RULE_BINS)||LA79_0==RULE_DOT||LA79_0==RULE_BS||LA79_0==RULE_DUALS) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3598:5: this_BITPAT_1= ruleBITPAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getDECODEPATAccess().getBITPATParserRuleCall_0_1()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_ruleBITPAT_in_ruleDECODEPAT6996);
                    	    this_BITPAT_1=ruleBITPAT();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		current.merge(this_BITPAT_1);
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              afterParserOrEnumRuleCall();
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt79 >= 1 ) break loop79;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(79, input);
                                throw eee;
                        }
                        cnt79++;
                    } while (true);

                    kw=(Token)match(input,65,FOLLOW_65_in_ruleDECODEPAT7016); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDECODEPATAccess().getApostropheKeyword_0_2()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3616:5: this_TOKPAT_3= ruleTOKPAT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDECODEPATAccess().getTOKPATParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTOKPAT_in_ruleDECODEPAT7045);
                    this_TOKPAT_3=ruleTOKPAT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_TOKPAT_3);
                          
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
    // $ANTLR end "ruleDECODEPAT"


    // $ANTLR start "entryRuleTOKPAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3634:1: entryRuleTOKPAT returns [String current=null] : iv_ruleTOKPAT= ruleTOKPAT EOF ;
    public final String entryRuleTOKPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTOKPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3635:2: (iv_ruleTOKPAT= ruleTOKPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3636:2: iv_ruleTOKPAT= ruleTOKPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTOKPATRule()); 
            }
            pushFollow(FOLLOW_ruleTOKPAT_in_entryRuleTOKPAT7091);
            iv_ruleTOKPAT=ruleTOKPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTOKPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTOKPAT7102); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTOKPAT"


    // $ANTLR start "ruleTOKPAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3643:1: ruleTOKPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) ) ;
    public final AntlrDatatypeRuleToken ruleTOKPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEXINT_0=null;
        Token this_ID_1=null;
        Token this_S_2=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3646:28: ( (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3647:1: (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3647:1: (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_HEXINT) ) {
                alt82=1;
            }
            else if ( ((LA82_0>=RULE_ID && LA82_0<=RULE_S)) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3647:6: this_HEXINT_0= RULE_HEXINT
                    {
                    this_HEXINT_0=(Token)match(input,RULE_HEXINT,FOLLOW_RULE_HEXINT_in_ruleTOKPAT7142); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXINT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEXINT_0, grammarAccess.getTOKPATAccess().getHEXINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3655:6: (this_ID_1= RULE_ID | this_S_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3655:6: (this_ID_1= RULE_ID | this_S_2= RULE_S )
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==RULE_ID) ) {
                        alt81=1;
                    }
                    else if ( (LA81_0==RULE_S) ) {
                        alt81=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 81, 0, input);

                        throw nvae;
                    }
                    switch (alt81) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3655:11: this_ID_1= RULE_ID
                            {
                            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTOKPAT7169); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_ID_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_ID_1, grammarAccess.getTOKPATAccess().getIDTerminalRuleCall_1_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3663:10: this_S_2= RULE_S
                            {
                            this_S_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTOKPAT7195); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_S_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_S_2, grammarAccess.getTOKPATAccess().getSTerminalRuleCall_1_1()); 
                                  
                            }

                            }
                            break;

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
    // $ANTLR end "ruleTOKPAT"


    // $ANTLR start "entryRuleBITPAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3678:1: entryRuleBITPAT returns [String current=null] : iv_ruleBITPAT= ruleBITPAT EOF ;
    public final String entryRuleBITPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3679:2: (iv_ruleBITPAT= ruleBITPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3680:2: iv_ruleBITPAT= ruleBITPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITPATRule()); 
            }
            pushFollow(FOLLOW_ruleBITPAT_in_entryRuleBITPAT7242);
            iv_ruleBITPAT=ruleBITPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITPAT7253); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBITPAT"


    // $ANTLR start "ruleBITPAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3687:1: ruleBITPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) ) ;
    public final AntlrDatatypeRuleToken ruleBITPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_1=null;
        Token this_S_2=null;
        AntlrDatatypeRuleToken this_BINARY_0 = null;

        AntlrDatatypeRuleToken this_BITPATORINT_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3690:28: ( (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3691:1: (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3691:1: (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_BINS||LA85_0==RULE_DOT||LA85_0==RULE_BS||LA85_0==RULE_DUALS) ) {
                alt85=1;
            }
            else if ( ((LA85_0>=RULE_ID && LA85_0<=RULE_S)) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3692:5: this_BINARY_0= ruleBINARY
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATAccess().getBINARYParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBINARY_in_ruleBITPAT7300);
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
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3703:6: ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3703:6: ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3703:7: (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3703:7: (this_ID_1= RULE_ID | this_S_2= RULE_S )
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==RULE_ID) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==RULE_S) ) {
                        alt83=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 0, input);

                        throw nvae;
                    }
                    switch (alt83) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3703:12: this_ID_1= RULE_ID
                            {
                            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBITPAT7328); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_ID_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_ID_1, grammarAccess.getBITPATAccess().getIDTerminalRuleCall_1_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3711:10: this_S_2= RULE_S
                            {
                            this_S_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleBITPAT7354); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_S_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_S_2, grammarAccess.getBITPATAccess().getSTerminalRuleCall_1_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3718:2: (this_BITPATORINT_3= ruleBITPATORINT )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==27||LA84_0==61) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3719:5: this_BITPATORINT_3= ruleBITPATORINT
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getBITPATAccess().getBITPATORINTParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBITPATORINT_in_ruleBITPAT7383);
                            this_BITPATORINT_3=ruleBITPATORINT();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_BITPATORINT_3);
                                  
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
    // $ANTLR end "ruleBITPAT"


    // $ANTLR start "entryRuleBITPATORINT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3737:1: entryRuleBITPATORINT returns [String current=null] : iv_ruleBITPATORINT= ruleBITPATORINT EOF ;
    public final String entryRuleBITPATORINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITPATORINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3738:2: (iv_ruleBITPATORINT= ruleBITPATORINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3739:2: iv_ruleBITPATORINT= ruleBITPATORINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITPATORINTRule()); 
            }
            pushFollow(FOLLOW_ruleBITPATORINT_in_entryRuleBITPATORINT7432);
            iv_ruleBITPATORINT=ruleBITPATORINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITPATORINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITPATORINT7443); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBITPATORINT"


    // $ANTLR start "ruleBITPATORINT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3746:1: ruleBITPATORINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) ) ;
    public final AntlrDatatypeRuleToken ruleBITPATORINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_POSINT_1 = null;

        AntlrDatatypeRuleToken this_BINARY_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3749:28: ( ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3750:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3750:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==27) ) {
                alt86=1;
            }
            else if ( (LA86_0==61) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3750:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3750:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3751:2: kw= ':' this_POSINT_1= rulePOSINT
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleBITPATORINT7482); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBITPATORINTAccess().getColonKeyword_0_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATORINTAccess().getPOSINTParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleBITPATORINT7504);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3768:6: (kw= '@' this_BINARY_3= ruleBINARY )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3768:6: (kw= '@' this_BINARY_3= ruleBINARY )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3769:2: kw= '@' this_BINARY_3= ruleBINARY
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleBITPATORINT7530); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBITPATORINTAccess().getCommercialAtKeyword_1_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATORINTAccess().getBINARYParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBINARY_in_ruleBITPATORINT7552);
                    this_BINARY_3=ruleBINARY();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINARY_3);
                          
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
    // $ANTLR end "ruleBITPATORINT"


    // $ANTLR start "entryRuleLIT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3793:1: entryRuleLIT returns [String current=null] : iv_ruleLIT= ruleLIT EOF ;
    public final String entryRuleLIT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLIT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3794:2: (iv_ruleLIT= ruleLIT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3795:2: iv_ruleLIT= ruleLIT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLITRule()); 
            }
            pushFollow(FOLLOW_ruleLIT_in_entryRuleLIT7599);
            iv_ruleLIT=ruleLIT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLIT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLIT7610); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLIT"


    // $ANTLR start "ruleLIT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3802:1: ruleLIT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) ) ;
    public final AntlrDatatypeRuleToken ruleLIT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_INTEGER_0 = null;

        AntlrDatatypeRuleToken this_BINARY_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3805:28: ( (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3806:1: (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3806:1: (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_HEXINT||(LA88_0>=RULE_NEGINT && LA88_0<=RULE_DUALS)) ) {
                alt88=1;
            }
            else if ( (LA88_0==65) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3807:5: this_INTEGER_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLITAccess().getINTEGERParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleLIT7657);
                    this_INTEGER_0=ruleINTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INTEGER_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3818:6: (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3818:6: (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3819:2: kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\''
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleLIT7682); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLITAccess().getApostropheKeyword_1_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3824:1: (this_BINARY_2= ruleBINARY )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==RULE_BINS||LA87_0==RULE_DOT||LA87_0==RULE_BS||LA87_0==RULE_DUALS) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3825:5: this_BINARY_2= ruleBINARY
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getLITAccess().getBINARYParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBINARY_in_ruleLIT7705);
                            this_BINARY_2=ruleBINARY();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_BINARY_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;

                    }

                    kw=(Token)match(input,65,FOLLOW_65_in_ruleLIT7725); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLITAccess().getApostropheKeyword_1_2()); 
                          
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
    // $ANTLR end "ruleLIT"


    // $ANTLR start "entryRuleMID"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3849:1: entryRuleMID returns [String current=null] : iv_ruleMID= ruleMID EOF ;
    public final String entryRuleMID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3850:2: (iv_ruleMID= ruleMID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3851:2: iv_ruleMID= ruleMID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMIDRule()); 
            }
            pushFollow(FOLLOW_ruleMID_in_entryRuleMID7767);
            iv_ruleMID=ruleMID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMID7778); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMID"


    // $ANTLR start "ruleMID"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3858:1: ruleMID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE ) ;
    public final AntlrDatatypeRuleToken ruleMID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MIXID_0=null;
        Token this_USCORE_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3861:28: ( (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3862:1: (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3862:1: (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_MIXID) ) {
                alt89=1;
            }
            else if ( (LA89_0==RULE_USCORE) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3862:6: this_MIXID_0= RULE_MIXID
                    {
                    this_MIXID_0=(Token)match(input,RULE_MIXID,FOLLOW_RULE_MIXID_in_ruleMID7818); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MIXID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_MIXID_0, grammarAccess.getMIDAccess().getMIXIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3870:10: this_USCORE_1= RULE_USCORE
                    {
                    this_USCORE_1=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_ruleMID7844); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_USCORE_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_USCORE_1, grammarAccess.getMIDAccess().getUSCORETerminalRuleCall_1()); 
                          
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
    // $ANTLR end "ruleMID"


    // $ANTLR start "entryRuleSYM"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3885:1: entryRuleSYM returns [String current=null] : iv_ruleSYM= ruleSYM EOF ;
    public final String entryRuleSYM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSYM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3886:2: (iv_ruleSYM= ruleSYM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3887:2: iv_ruleSYM= ruleSYM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSYMRule()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_entryRuleSYM7890);
            iv_ruleSYM=ruleSYM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSYM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSYM7901); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3894:1: ruleSYM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER ) ;
    public final AntlrDatatypeRuleToken ruleSYM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_USCORE_0=null;
        Token this_BS_1=null;
        Token this_DOT_2=null;
        Token this_LESS_3=null;
        Token this_GREATER_4=null;
        Token this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3897:28: ( (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3898:1: (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3898:1: (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER )
            int alt90=6;
            switch ( input.LA(1) ) {
            case RULE_USCORE:
                {
                alt90=1;
                }
                break;
            case RULE_BS:
                {
                alt90=2;
                }
                break;
            case RULE_DOT:
                {
                alt90=3;
                }
                break;
            case RULE_LESS:
                {
                alt90=4;
                }
                break;
            case RULE_GREATER:
                {
                alt90=5;
                }
                break;
            case RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER:
                {
                alt90=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3898:6: this_USCORE_0= RULE_USCORE
                    {
                    this_USCORE_0=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_ruleSYM7941); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_USCORE_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_USCORE_0, grammarAccess.getSYMAccess().getUSCORETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3906:10: this_BS_1= RULE_BS
                    {
                    this_BS_1=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleSYM7967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_1, grammarAccess.getSYMAccess().getBSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3914:10: this_DOT_2= RULE_DOT
                    {
                    this_DOT_2=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSYM7993); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_2, grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3922:10: this_LESS_3= RULE_LESS
                    {
                    this_LESS_3=(Token)match(input,RULE_LESS,FOLLOW_RULE_LESS_in_ruleSYM8019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LESS_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LESS_3, grammarAccess.getSYMAccess().getLESSTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3930:10: this_GREATER_4= RULE_GREATER
                    {
                    this_GREATER_4=(Token)match(input,RULE_GREATER,FOLLOW_RULE_GREATER_in_ruleSYM8045); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_GREATER_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_GREATER_4, grammarAccess.getSYMAccess().getGREATERTerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3938:10: this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER
                    {
                    this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5=(Token)match(input,RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER,FOLLOW_RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_in_ruleSYM8071); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5, grammarAccess.getSYMAccess().getSYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATERTerminalRuleCall_5()); 
                          
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


    // $ANTLR start "entryRuleINTEGER"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3953:1: entryRuleINTEGER returns [String current=null] : iv_ruleINTEGER= ruleINTEGER EOF ;
    public final String entryRuleINTEGER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTEGER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3954:2: (iv_ruleINTEGER= ruleINTEGER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3955:2: iv_ruleINTEGER= ruleINTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleINTEGER_in_entryRuleINTEGER8117);
            iv_ruleINTEGER=ruleINTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTEGER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTEGER8128); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTEGER"


    // $ANTLR start "ruleINTEGER"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3962:1: ruleINTEGER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT ) ;
    public final AntlrDatatypeRuleToken ruleINTEGER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEXINT_1=null;
        Token this_NEGINT_2=null;
        AntlrDatatypeRuleToken this_POSINT_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3965:28: ( (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3966:1: (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3966:1: (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT )
            int alt91=3;
            switch ( input.LA(1) ) {
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
                {
                alt91=1;
                }
                break;
            case RULE_HEXINT:
                {
                alt91=2;
                }
                break;
            case RULE_NEGINT:
                {
                alt91=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3967:5: this_POSINT_0= rulePOSINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getINTEGERAccess().getPOSINTParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleINTEGER8175);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3978:10: this_HEXINT_1= RULE_HEXINT
                    {
                    this_HEXINT_1=(Token)match(input,RULE_HEXINT,FOLLOW_RULE_HEXINT_in_ruleINTEGER8201); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXINT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEXINT_1, grammarAccess.getINTEGERAccess().getHEXINTTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3986:10: this_NEGINT_2= RULE_NEGINT
                    {
                    this_NEGINT_2=(Token)match(input,RULE_NEGINT,FOLLOW_RULE_NEGINT_in_ruleINTEGER8227); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NEGINT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEGINT_2, grammarAccess.getINTEGERAccess().getNEGINTTerminalRuleCall_2()); 
                          
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
    // $ANTLR end "ruleINTEGER"


    // $ANTLR start "entryRulePOSINT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4001:1: entryRulePOSINT returns [String current=null] : iv_rulePOSINT= rulePOSINT EOF ;
    public final String entryRulePOSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePOSINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4002:2: (iv_rulePOSINT= rulePOSINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4003:2: iv_rulePOSINT= rulePOSINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPOSINTRule()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT8273);
            iv_rulePOSINT=rulePOSINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePOSINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT8284); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4010:1: rulePOSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS ) ;
    public final AntlrDatatypeRuleToken rulePOSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_POSINT_WO_DUALS_0=null;
        Token this_DUALS_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4013:28: ( (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4014:1: (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4014:1: (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_POSINT_WO_DUALS) ) {
                alt92=1;
            }
            else if ( (LA92_0==RULE_DUALS) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4014:6: this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS
                    {
                    this_POSINT_WO_DUALS_0=(Token)match(input,RULE_POSINT_WO_DUALS,FOLLOW_RULE_POSINT_WO_DUALS_in_rulePOSINT8324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_POSINT_WO_DUALS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_POSINT_WO_DUALS_0, grammarAccess.getPOSINTAccess().getPOSINT_WO_DUALSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4022:10: this_DUALS_1= RULE_DUALS
                    {
                    this_DUALS_1=(Token)match(input,RULE_DUALS,FOLLOW_RULE_DUALS_in_rulePOSINT8350); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DUALS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DUALS_1, grammarAccess.getPOSINTAccess().getDUALSTerminalRuleCall_1()); 
                          
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


    // $ANTLR start "entryRuleBINARY"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4037:1: entryRuleBINARY returns [String current=null] : iv_ruleBINARY= ruleBINARY EOF ;
    public final String entryRuleBINARY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBINARY = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4038:2: (iv_ruleBINARY= ruleBINARY EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4039:2: iv_ruleBINARY= ruleBINARY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBINARYRule()); 
            }
            pushFollow(FOLLOW_ruleBINARY_in_entryRuleBINARY8396);
            iv_ruleBINARY=ruleBINARY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBINARY.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBINARY8407); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4046:1: ruleBINARY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT ) ;
    public final AntlrDatatypeRuleToken ruleBINARY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DUALS_0=null;
        Token this_BINS_1=null;
        Token this_BS_2=null;
        Token this_DOT_3=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4049:28: ( (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4050:1: (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4050:1: (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT )
            int alt93=4;
            switch ( input.LA(1) ) {
            case RULE_DUALS:
                {
                alt93=1;
                }
                break;
            case RULE_BINS:
                {
                alt93=2;
                }
                break;
            case RULE_BS:
                {
                alt93=3;
                }
                break;
            case RULE_DOT:
                {
                alt93=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4050:6: this_DUALS_0= RULE_DUALS
                    {
                    this_DUALS_0=(Token)match(input,RULE_DUALS,FOLLOW_RULE_DUALS_in_ruleBINARY8447); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DUALS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DUALS_0, grammarAccess.getBINARYAccess().getDUALSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4058:10: this_BINS_1= RULE_BINS
                    {
                    this_BINS_1=(Token)match(input,RULE_BINS,FOLLOW_RULE_BINS_in_ruleBINARY8473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINS_1, grammarAccess.getBINARYAccess().getBINSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4066:10: this_BS_2= RULE_BS
                    {
                    this_BS_2=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleBINARY8499); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_2, grammarAccess.getBINARYAccess().getBSTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4074:10: this_DOT_3= RULE_DOT
                    {
                    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleBINARY8525); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_3, grammarAccess.getBINARYAccess().getDOTTerminalRuleCall_3()); 
                          
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

    // $ANTLR start synpred1_InternalGDSL
    public final void synpred1_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:331:3: ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:331:4: ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:331:4: ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:331:5: ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )*
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:331:5: ( ( ruleConDecl ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:332:1: ( ruleConDecl )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:332:1: ( ruleConDecl )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:333:1: ruleConDecl
        {
        pushFollow(FOLLOW_ruleConDecl_in_synpred1_InternalGDSL655);
        ruleConDecl();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:335:2: ( '|' ( ( ruleConDecl ) ) )*
        loop94:
        do {
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==30) ) {
                alt94=1;
            }


            switch (alt94) {
        	case 1 :
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:335:4: '|' ( ( ruleConDecl ) )
        	    {
        	    match(input,30,FOLLOW_30_in_synpred1_InternalGDSL662); if (state.failed) return ;
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:336:1: ( ( ruleConDecl ) )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:337:1: ( ruleConDecl )
        	    {
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:337:1: ( ruleConDecl )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:338:1: ruleConDecl
        	    {
        	    pushFollow(FOLLOW_ruleConDecl_in_synpred1_InternalGDSL669);
        	    ruleConDecl();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop94;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred1_InternalGDSL

    // $ANTLR start synpred2_InternalGDSL
    public final void synpred2_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:3: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:4: ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:4: ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:5: ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:5: ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) )
        int alt95=2;
        int LA95_0 = input.LA(1);

        if ( ((LA95_0>=RULE_ID && LA95_0<=RULE_S)) ) {
            alt95=1;
        }
        else if ( ((LA95_0>=RULE_LESS && LA95_0<=RULE_GREATER)||(LA95_0>=RULE_DOT && LA95_0<=RULE_USCORE)||(LA95_0>=RULE_BS && LA95_0<=RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER)) ) {
            alt95=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 95, 0, input);

            throw nvae;
        }
        switch (alt95) {
            case 1 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:6: ( ( ( RULE_ID | RULE_S ) ) )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:6: ( ( ( RULE_ID | RULE_S ) ) )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:425:1: ( ( RULE_ID | RULE_S ) )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:425:1: ( ( RULE_ID | RULE_S ) )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:426:1: ( RULE_ID | RULE_S )
                {
                if ( (input.LA(1)>=RULE_ID && input.LA(1)<=RULE_S) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }


                }


                }


                }
                break;
            case 2 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:435:6: ( ( ruleSYM ) )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:435:6: ( ( ruleSYM ) )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:436:1: ( ruleSYM )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:436:1: ( ruleSYM )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:437:1: ruleSYM
                {
                pushFollow(FOLLOW_ruleSYM_in_synpred2_InternalGDSL890);
                ruleSYM();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:439:3: ( ( ( RULE_ID | RULE_S ) ) )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( ((LA96_0>=RULE_ID && LA96_0<=RULE_S)) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:440:1: ( ( RULE_ID | RULE_S ) )
        	    {
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:440:1: ( ( RULE_ID | RULE_S ) )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:441:1: ( RULE_ID | RULE_S )
        	    {
        	    if ( (input.LA(1)>=RULE_ID && input.LA(1)<=RULE_S) ) {
        	        input.consume();
        	        state.errorRecovery=false;state.failed=false;
        	    }
        	    else {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        MismatchedSetException mse = new MismatchedSetException(null,input);
        	        throw mse;
        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop96;
            }
        } while (true);

        match(input,29,FOLLOW_29_in_synpred2_InternalGDSL923); if (state.failed) return ;
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:450:1: ( ( ruleExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:451:1: ( ruleExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:451:1: ( ruleExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:452:1: ruleExp
        {
        pushFollow(FOLLOW_ruleExp_in_synpred2_InternalGDSL930);
        ruleExp();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalGDSL

    // $ANTLR start synpred3_InternalGDSL
    public final void synpred3_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2226:3: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2227:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2227:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2228:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred3_InternalGDSL4322);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalGDSL

    // $ANTLR start synpred4_InternalGDSL
    public final void synpred4_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2690:4: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2690:6: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred4_InternalGDSL5317); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalGDSL

    // $ANTLR start synpred5_InternalGDSL
    public final void synpred5_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2862:3: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2862:5: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred5_InternalGDSL5624); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalGDSL

    // $ANTLR start synpred6_InternalGDSL
    public final void synpred6_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3395:7: ( ( ( ruleINTEGER ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3395:8: ( ( ruleINTEGER ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3395:8: ( ( ruleINTEGER ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3396:1: ( ruleINTEGER )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3396:1: ( ruleINTEGER )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3397:1: ruleINTEGER
        {
        pushFollow(FOLLOW_ruleINTEGER_in_synpred6_InternalGDSL6578);
        ruleINTEGER();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred6_InternalGDSL

    // $ANTLR start synpred7_InternalGDSL
    public final void synpred7_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:7: ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:8: ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:8: ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:9: ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )?
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:9: ( ( ( RULE_ID | RULE_S ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3419:1: ( ( RULE_ID | RULE_S ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3419:1: ( ( RULE_ID | RULE_S ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3420:1: ( RULE_ID | RULE_S )
        {
        if ( (input.LA(1)>=RULE_ID && input.LA(1)<=RULE_S) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3428:2: ( ( rulePAT ) )?
        int alt97=2;
        int LA97_0 = input.LA(1);

        if ( ((LA97_0>=RULE_ID && LA97_0<=RULE_S)||(LA97_0>=RULE_USCORE && LA97_0<=RULE_HEXINT)||(LA97_0>=RULE_NEGINT && LA97_0<=RULE_DUALS)||LA97_0==65) ) {
            alt97=1;
        }
        switch (alt97) {
            case 1 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3429:1: ( rulePAT )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3429:1: ( rulePAT )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3430:1: rulePAT
                {
                pushFollow(FOLLOW_rulePAT_in_synpred7_InternalGDSL6645);
                rulePAT();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }


        }


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


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA46 dfa46 = new DFA46(this);
    static final String DFA8_eotS =
        "\21\uffff";
    static final String DFA8_eofS =
        "\2\uffff\1\13\11\uffff\1\13\4\uffff";
    static final String DFA8_minS =
        "\1\4\1\0\1\4\3\uffff\1\4\5\uffff\1\31\1\uffff\1\4\2\uffff";
    static final String DFA8_maxS =
        "\1\54\1\0\1\54\3\uffff\1\22\5\uffff\1\43\1\uffff\1\7\2\uffff";
    static final String DFA8_acceptS =
        "\3\uffff\1\2\2\1\1\uffff\5\1\1\uffff\1\1\1\uffff\2\1";
    static final String DFA8_specialS =
        "\1\uffff\1\3\1\4\3\uffff\1\1\5\uffff\1\2\1\uffff\1\0\2\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\1\2\1\3\5\uffff\1\3\3\uffff\3\3\13\uffff\1\3\5\uffff\4"+
            "\3\1\uffff\1\3\2\uffff\1\3",
            "\1\uffff",
            "\3\3\5\uffff\1\3\3\uffff\3\3\6\uffff\1\7\1\10\1\uffff\1\11"+
            "\1\uffff\1\6\1\12\3\uffff\1\5\4\3\1\uffff\1\3\2\uffff\1\3",
            "",
            "",
            "",
            "\1\14\1\15\6\uffff\1\3\3\uffff\3\3",
            "",
            "",
            "",
            "",
            "",
            "\1\7\1\10\1\uffff\1\11\1\uffff\1\16\1\12\3\uffff\1\17",
            "",
            "\1\20\1\15\1\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "331:1: ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_4_0= ruleConDecl ) ) (otherlv_5= '|' ( (lv_conDecl_6_0= ruleConDecl ) ) )* ) ) | ( (lv_value_7_0= ruleTy ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_14 = input.LA(1);

                         
                        int index8_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_14==RULE_ID) && (synpred1_InternalGDSL())) {s = 16;}

                        else if ( (LA8_14==RULE_S) && (synpred1_InternalGDSL())) {s = 13;}

                        else if ( (LA8_14==RULE_LESS) ) {s = 3;}

                         
                        input.seek(index8_14);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_6 = input.LA(1);

                         
                        int index8_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_6==RULE_ID) ) {s = 12;}

                        else if ( (LA8_6==RULE_S) && (synpred1_InternalGDSL())) {s = 13;}

                        else if ( (LA8_6==RULE_HEXINT||(LA8_6>=RULE_NEGINT && LA8_6<=RULE_DUALS)) ) {s = 3;}

                         
                        input.seek(index8_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_12 = input.LA(1);

                         
                        int index8_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_12==30) ) {s = 14;}

                        else if ( (LA8_12==35) && (synpred1_InternalGDSL())) {s = 15;}

                        else if ( (LA8_12==25) && (synpred1_InternalGDSL())) {s = 7;}

                        else if ( (LA8_12==26) && (synpred1_InternalGDSL())) {s = 8;}

                        else if ( (LA8_12==28) && (synpred1_InternalGDSL())) {s = 9;}

                        else if ( (LA8_12==31) && (synpred1_InternalGDSL())) {s = 10;}

                        else if ( (LA8_12==EOF) && (synpred1_InternalGDSL())) {s = 11;}

                         
                        input.seek(index8_12);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA8_1 = input.LA(1);

                         
                        int index8_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalGDSL()) ) {s = 4;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index8_1);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA8_2 = input.LA(1);

                         
                        int index8_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_2==35) && (synpred1_InternalGDSL())) {s = 5;}

                        else if ( (LA8_2==30) ) {s = 6;}

                        else if ( (LA8_2==25) && (synpred1_InternalGDSL())) {s = 7;}

                        else if ( (LA8_2==26) && (synpred1_InternalGDSL())) {s = 8;}

                        else if ( (LA8_2==28) && (synpred1_InternalGDSL())) {s = 9;}

                        else if ( (LA8_2==31) && (synpred1_InternalGDSL())) {s = 10;}

                        else if ( (LA8_2==EOF) && (synpred1_InternalGDSL())) {s = 11;}

                        else if ( ((LA8_2>=RULE_ID && LA8_2<=RULE_BINS)||LA8_2==RULE_HEXINT||(LA8_2>=RULE_NEGINT && LA8_2<=RULE_DUALS)||(LA8_2>=36 && LA8_2<=39)||LA8_2==41||LA8_2==44) ) {s = 3;}

                         
                        input.seek(index8_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA19_eotS =
        "\14\uffff";
    static final String DFA19_eofS =
        "\14\uffff";
    static final String DFA19_minS =
        "\1\4\3\0\10\uffff";
    static final String DFA19_maxS =
        "\1\35\3\0\10\uffff";
    static final String DFA19_acceptS =
        "\4\uffff\5\1\1\2\1\uffff\1\3";
    static final String DFA19_specialS =
        "\1\0\1\1\1\2\1\3\10\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\2\1\uffff\1\6\1\7\1\uffff\1\5\1\3\1\uffff\1\11\1\4\1"+
            "\10\15\uffff\1\11",
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
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "424:1: ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_0 = input.LA(1);

                         
                        int index19_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA19_0==RULE_ID) ) {s = 1;}

                        else if ( (LA19_0==RULE_S) ) {s = 2;}

                        else if ( (LA19_0==RULE_USCORE) ) {s = 3;}

                        else if ( (LA19_0==RULE_BS) && (synpred2_InternalGDSL())) {s = 4;}

                        else if ( (LA19_0==RULE_DOT) && (synpred2_InternalGDSL())) {s = 5;}

                        else if ( (LA19_0==RULE_LESS) && (synpred2_InternalGDSL())) {s = 6;}

                        else if ( (LA19_0==RULE_GREATER) && (synpred2_InternalGDSL())) {s = 7;}

                        else if ( (LA19_0==RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER) && (synpred2_InternalGDSL())) {s = 8;}

                        else if ( (LA19_0==RULE_MIXID||LA19_0==29) ) {s = 9;}

                         
                        input.seek(index19_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_1 = input.LA(1);

                         
                        int index19_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalGDSL()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index19_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_2 = input.LA(1);

                         
                        int index19_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalGDSL()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index19_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_3 = input.LA(1);

                         
                        int index19_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalGDSL()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index19_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\12\uffff";
    static final String DFA32_eofS =
        "\12\uffff";
    static final String DFA32_minS =
        "\1\4\1\uffff\1\4\7\uffff";
    static final String DFA32_maxS =
        "\1\54\1\uffff\1\22\7\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\1\7\1\10\1\2\1\3";
    static final String DFA32_specialS =
        "\12\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\3\1\7\1\1\5\uffff\1\1\3\uffff\3\1\13\uffff\1\2\5\uffff\3"+
            "\3\1\4\1\uffff\1\5\2\uffff\1\6",
            "",
            "\1\11\7\uffff\1\10\3\uffff\3\10",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
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
            return "982:1: ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) )";
        }
    }
    static final String DFA46_eotS =
        "\31\uffff";
    static final String DFA46_eofS =
        "\1\1\30\uffff";
    static final String DFA46_minS =
        "\1\7\17\uffff\1\0\10\uffff";
    static final String DFA46_maxS =
        "\1\100\17\uffff\1\0\10\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\2\22\uffff\5\1";
    static final String DFA46_specialS =
        "\1\0\17\uffff\1\1\10\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\26\1\27\1\uffff\1\25\1\20\1\uffff\1\1\1\24\1\30\11\uffff"+
            "\2\1\1\uffff\4\1\2\uffff\2\1\4\uffff\1\1\1\uffff\1\1\4\uffff"+
            "\1\1\1\uffff\2\1\2\uffff\2\1\11\uffff\1\1",
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
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "()* loopback of 2226:1: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_0 = input.LA(1);

                         
                        int index46_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA46_0==EOF||LA46_0==RULE_MIXID||(LA46_0>=25 && LA46_0<=26)||(LA46_0>=28 && LA46_0<=31)||(LA46_0>=34 && LA46_0<=35)||LA46_0==40||LA46_0==42||LA46_0==47||(LA46_0>=49 && LA46_0<=50)||(LA46_0>=53 && LA46_0<=54)||LA46_0==64) ) {s = 1;}

                        else if ( (LA46_0==RULE_USCORE) ) {s = 16;}

                        else if ( (LA46_0==RULE_BS) && (synpred3_InternalGDSL())) {s = 20;}

                        else if ( (LA46_0==RULE_DOT) && (synpred3_InternalGDSL())) {s = 21;}

                        else if ( (LA46_0==RULE_LESS) && (synpred3_InternalGDSL())) {s = 22;}

                        else if ( (LA46_0==RULE_GREATER) && (synpred3_InternalGDSL())) {s = 23;}

                        else if ( (LA46_0==RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER) && (synpred3_InternalGDSL())) {s = 24;}

                         
                        input.seek(index46_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_16 = input.LA(1);

                         
                        int index46_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 24;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index46_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel131 = new BitSet(new long[]{0x0000000096000002L});
    public static final BitSet FOLLOW_25_in_ruleModel145 = new BitSet(new long[]{0x0000000096000000L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel168 = new BitSet(new long[]{0x0000000096000002L});
    public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecl216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_ruleDecl263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_ruleDecl290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_ruleDecl317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport352 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleDeclExport399 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclExport419 = new BitSet(new long[]{0x0000000108000000L});
    public static final BitSet FOLLOW_ruleTyVars_in_ruleDeclExport440 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleDeclExport453 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclExport474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDeclType557 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclType576 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclType596 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_ruleTyVars_in_ruleDeclType625 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclType638 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType692 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleDeclType705 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType726 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclType757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDeclVal841 = new BitSet(new long[]{0x000000002000EDB0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal950 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal970 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleDeclVal1005 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1025 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1045 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1066 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_ruleDeclVal1118 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1137 = new BitSet(new long[]{0x0000000020002800L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1157 = new BitSet(new long[]{0x0000000020002800L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1179 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1227 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1247 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleDeclVal1267 = new BitSet(new long[]{0x0000000200001030L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECODEPAT_in_ruleDeclVal1288 = new BitSet(new long[]{0x0000000200001030L,0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleDeclVal1301 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1315 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDeclVal1356 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1377 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1389 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1410 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleTyVars_in_entryRuleTyVars1451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyVars1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleTyVars1498 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyVar_in_ruleTyVars1519 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleTyVars1532 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyVar_in_ruleTyVars1553 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleTyVars1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyVar_in_entryRuleTyVar1603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyVar1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyVar1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTyVar1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl1719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConDecl1775 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleConDecl1788 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleConDecl1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy1847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleTy1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINS_in_ruleTy1920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTy1947 = new BitSet(new long[]{0x0000000000071000L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleTy1968 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTy1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTy2000 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTy2020 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTy2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTy2061 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_36_in_ruleTy2087 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_37_in_ruleTy2116 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_38_in_ruleTy2145 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleTy2175 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2196 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleTy2209 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2230 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleTy2244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleTy2275 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2297 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_34_in_ruleTy2310 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2331 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_40_in_ruleTy2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleTy2367 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2388 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_34_in_ruleTy2401 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2422 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_42_in_ruleTy2436 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleTy2448 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleTy2498 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleTy2511 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTy2553 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2573 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_LESS_in_ruleTy2584 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2604 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleTy2616 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2637 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_GREATER_in_ruleTy2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind2684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyBind2738 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTyBind2758 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleTyBind2779 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyBind2800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement2838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyElement2892 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTyElement2912 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleTyElement2932 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyElement2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp2989 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp3045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_ruleExp3073 = new BitSet(new long[]{0xF009428000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp3094 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_ruleCaseExp_in_entryRuleCaseExp3132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseExp3142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleCaseExp3213 = new BitSet(new long[]{0xF009028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp3247 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleCaseExp3259 = new BitSet(new long[]{0x0000000000071830L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_ruleCaseExp3281 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleCaseExp3293 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCaseExp3314 = new BitSet(new long[]{0x0000800040000000L});
    public static final BitSet FOLLOW_30_in_ruleCaseExp3327 = new BitSet(new long[]{0x0000000000071830L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_ruleCaseExp3348 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleCaseExp3360 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCaseExp3381 = new BitSet(new long[]{0x0000800040000000L});
    public static final BitSet FOLLOW_47_in_ruleCaseExp3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_entryRuleClosedExp3433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedExp3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_ruleClosedExp3490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleClosedExp3514 = new BitSet(new long[]{0xF009428000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3548 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleClosedExp3560 = new BitSet(new long[]{0xF009428000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3581 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleClosedExp3593 = new BitSet(new long[]{0xF009428000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleClosedExp3640 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3674 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_25_in_ruleClosedExp3687 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3708 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_47_in_ruleClosedExp3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonadicExp3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonadicExp3841 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleMonadicExp3861 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleMonadicExp3881 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3939 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrElseExp3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3996 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOrElseExp4023 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp4057 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp4095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndAlsoExp4105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp4152 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_ruleAndAlsoExp4179 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp4213 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_entryRuleRExp4251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRExp4261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp4308 = new BitSet(new long[]{0x000000000000CDB2L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleRExp4339 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp4360 = new BitSet(new long[]{0x000000000000CDB2L});
    public static final BitSet FOLLOW_ruleAExp_in_entryRuleAExp4398 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExp4408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4455 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_55_in_ruleAExp4475 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleAExp4504 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4541 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_entryRuleMExp4579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMExp4589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectExp_in_ruleMExp4636 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_57_in_ruleMExp4656 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleMExp4685 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleMExp4722 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleSelectExp_in_entryRuleSelectExp4760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectExp4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleSelectExp4817 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleSelectExp4829 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleSelectExp4850 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_entryRuleApplyExp4888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleApplyExp4898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleApplyExp4936 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleApplyExp4958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleApplyExp4986 = new BitSet(new long[]{0xF000128000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgs_in_ruleApplyExp5007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgs_in_entryRuleArgs5044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgs5054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleArgs5110 = new BitSet(new long[]{0xF000028000071232L,0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleArgs5129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp5166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicExp5176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLIT_in_ruleAtomicExp5222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAtomicExp5245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5276 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5296 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp5322 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5341 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5361 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_61_in_ruleAtomicExp5397 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleAtomicExp5422 = new BitSet(new long[]{0x1000000000000030L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp5443 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExp5456 = new BitSet(new long[]{0x1000000000000030L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp5477 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_40_in_ruleAtomicExp5491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleAtomicExp5511 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleAtomicExp5578 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5599 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleAtomicExp5611 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp5629 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5648 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5668 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_39_in_ruleAtomicExp5707 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5727 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5747 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAtomicExp5767 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5788 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExp5801 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5820 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5840 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAtomicExp5860 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5881 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_40_in_ruleAtomicExp5897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAtomicExp5923 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleValueDecl_in_ruleAtomicExp5957 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleAtomicExp5970 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5991 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleAtomicExp6003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleField_in_entryRuleField6040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleField6050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleField6095 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleField6115 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleField6135 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleField6156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleField6176 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleField6195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleField6215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueDecl_in_entryRuleValueDecl6260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueDecl6270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleValueDecl6307 = new BitSet(new long[]{0x000000000000CDB0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueDecl6327 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleValueDecl6347 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleValueDecl6382 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueDecl6402 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleValueDecl6422 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_29_in_ruleValueDecl6443 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleValueDecl6464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_entryRulePAT6500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePAT6510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_rulePAT6552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_rulePAT6597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePAT6665 = new BitSet(new long[]{0x0000000000071832L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_rulePAT6685 = new BitSet(new long[]{0x0000000000071832L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_rulePAT6714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rulePAT6736 = new BitSet(new long[]{0x0000000000044470L});
    public static final BitSet FOLLOW_ruleBITPAT_in_rulePAT6757 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rulePAT6769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS6806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS6816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCONS6859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleCONS6879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECODEPAT_in_entryRuleDECODEPAT6923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDECODEPAT6934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleDECODEPAT6973 = new BitSet(new long[]{0x0000000000044470L});
    public static final BitSet FOLLOW_ruleBITPAT_in_ruleDECODEPAT6996 = new BitSet(new long[]{0x0000000000044470L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleDECODEPAT7016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTOKPAT_in_ruleDECODEPAT7045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTOKPAT_in_entryRuleTOKPAT7091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTOKPAT7102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXINT_in_ruleTOKPAT7142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTOKPAT7169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTOKPAT7195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITPAT_in_entryRuleBITPAT7242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITPAT7253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITPAT7300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBITPAT7328 = new BitSet(new long[]{0x2000000008000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleBITPAT7354 = new BitSet(new long[]{0x2000000008000002L});
    public static final BitSet FOLLOW_ruleBITPATORINT_in_ruleBITPAT7383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITPATORINT_in_entryRuleBITPATORINT7432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITPATORINT7443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleBITPATORINT7482 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleBITPATORINT7504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleBITPATORINT7530 = new BitSet(new long[]{0x0000000000044440L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITPATORINT7552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLIT_in_entryRuleLIT7599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLIT7610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleLIT7657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLIT7682 = new BitSet(new long[]{0x0000000000044440L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleLIT7705 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLIT7725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_entryRuleMID7767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMID7778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIXID_in_ruleMID7818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_ruleMID7844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_entryRuleSYM7890 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSYM7901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_ruleSYM7941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleSYM7967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSYM7993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LESS_in_ruleSYM8019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_GREATER_in_ruleSYM8045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_in_ruleSYM8071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_entryRuleINTEGER8117 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTEGER8128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleINTEGER8175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXINT_in_ruleINTEGER8201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEGINT_in_ruleINTEGER8227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT8273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT8284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_POSINT_WO_DUALS_in_rulePOSINT8324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DUALS_in_rulePOSINT8350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_entryRuleBINARY8396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBINARY8407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DUALS_in_ruleBINARY8447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINS_in_ruleBINARY8473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleBINARY8499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleBINARY8525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_synpred1_InternalGDSL655 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_synpred1_InternalGDSL662 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleConDecl_in_synpred1_InternalGDSL669 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_set_in_synpred2_InternalGDSL859 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred2_InternalGDSL890 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_set_in_synpred2_InternalGDSL900 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_29_in_synpred2_InternalGDSL923 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_synpred2_InternalGDSL930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred3_InternalGDSL4322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred4_InternalGDSL5317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred5_InternalGDSL5624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_synpred6_InternalGDSL6578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred7_InternalGDSL6620 = new BitSet(new long[]{0x0000000000071832L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_synpred7_InternalGDSL6645 = new BitSet(new long[]{0x0000000000000002L});

}