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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:416:1: ruleDeclVal returns [EObject current=null] : (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:419:28: ( (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:420:1: (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:420:1: (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:420:3: otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleDeclVal841); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeclValAccess().getValKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:1: ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:2: ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:2: ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:3: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:458:6: ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:458:7: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:458:7: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=RULE_ID && LA10_0<=RULE_S)) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==RULE_USCORE) && (synpred4_InternalGDSL())) {
                        alt10=2;
                    }
                    else if ( (LA10_0==RULE_BS) && (synpred4_InternalGDSL())) {
                        alt10=2;
                    }
                    else if ( (LA10_0==RULE_DOT) && (synpred4_InternalGDSL())) {
                        alt10=2;
                    }
                    else if ( (LA10_0==RULE_LESS) && (synpred4_InternalGDSL())) {
                        alt10=2;
                    }
                    else if ( (LA10_0==RULE_GREATER) && (synpred4_InternalGDSL())) {
                        alt10=2;
                    }
                    else if ( (LA10_0==RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER) && (synpred4_InternalGDSL())) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:458:8: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:458:8: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:459:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:459:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:460:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:460:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:461:3: lv_name_1_1= RULE_ID
                                    {
                                    lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal960); if (state.failed) return current;
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:8: lv_name_1_2= RULE_S
                                    {
                                    lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal980); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:495:6: ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:495:6: ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:495:7: ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:500:1: (lv_name_2_0= ruleSYM )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:501:3: lv_name_2_0= ruleSYM
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getNameSYMParserRuleCall_1_0_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleSYM_in_ruleDeclVal1025);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:517:3: ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_S)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:518:1: ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:518:1: ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:519:1: (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:519:1: (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S )
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:520:3: lv_attr_3_1= RULE_ID
                    	            {
                    	            lv_attr_3_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1045); if (state.failed) return current;
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:535:8: lv_attr_3_2= RULE_S
                    	            {
                    	            lv_attr_3_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1065); if (state.failed) return current;
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

                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1086); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_0_0_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:557:1: ( (lv_exp_5_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:558:1: (lv_exp_5_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:558:1: (lv_exp_5_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:559:3: lv_exp_5_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_0_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1107);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:576:6: ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:576:6: ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:576:7: ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:576:7: ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_USCORE||LA14_0==RULE_MIXID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:576:8: ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:576:8: ( (lv_mid_6_0= ruleMID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:577:1: (lv_mid_6_0= ruleMID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:577:1: (lv_mid_6_0= ruleMID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:578:3: lv_mid_6_0= ruleMID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getMidMIDParserRuleCall_1_1_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMID_in_ruleDeclVal1138);
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

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:594:2: ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:595:1: ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:595:1: ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:596:1: (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:596:1: (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S )
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:597:3: lv_attr_7_1= RULE_ID
                    	            {
                    	            lv_attr_7_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1157); if (state.failed) return current;
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:612:8: lv_attr_7_2= RULE_S
                    	            {
                    	            lv_attr_7_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1177); if (state.failed) return current;
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

                    otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1199); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:634:1: ( (lv_exp_9_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:635:1: (lv_exp_9_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:635:1: (lv_exp_9_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:636:3: lv_exp_9_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1220);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:653:6: ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:653:6: ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:653:7: ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:653:7: ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:654:1: ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:654:1: ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:655:1: (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:655:1: (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:656:3: lv_name_10_1= RULE_ID
                            {
                            lv_name_10_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1247); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:671:8: lv_name_10_2= RULE_S
                            {
                            lv_name_10_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1267); if (state.failed) return current;
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

                    otherlv_11=(Token)match(input,32,FOLLOW_32_in_ruleDeclVal1287); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:693:1: ( (lv_decPat_12_0= ruleDECODEPAT ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_S)||LA16_0==RULE_HEXINT||LA16_0==65) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:694:1: (lv_decPat_12_0= ruleDECODEPAT )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:694:1: (lv_decPat_12_0= ruleDECODEPAT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:695:3: lv_decPat_12_0= ruleDECODEPAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getDecPatDECODEPATParserRuleCall_1_2_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleDECODEPAT_in_ruleDeclVal1308);
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

                    otherlv_13=(Token)match(input,33,FOLLOW_33_in_ruleDeclVal1321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_2_3());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:715:1: ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:715:2: (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:715:2: (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:715:4: otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) )
                            {
                            otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1335); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_2_4_0_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:719:1: ( (lv_exp_15_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:720:1: (lv_exp_15_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:720:1: (lv_exp_15_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:721:3: lv_exp_15_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_2_4_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1356);
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:738:6: (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:738:6: (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+
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
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:738:8: otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) )
                            	    {
                            	    otherlv_16=(Token)match(input,30,FOLLOW_30_in_ruleDeclVal1376); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_16, grammarAccess.getDeclValAccess().getVerticalLineKeyword_1_2_4_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:742:1: ( (lv_exps_17_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:743:1: (lv_exps_17_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:743:1: (lv_exps_17_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:744:3: lv_exps_17_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_2_4_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1397);
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

                            	    otherlv_18=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1409); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_18, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_2_4_1_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:764:1: ( (lv_exps_19_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:765:1: (lv_exps_19_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:765:1: (lv_exps_19_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:766:3: lv_exps_19_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_2_4_1_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1430);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:790:1: entryRuleTyVars returns [EObject current=null] : iv_ruleTyVars= ruleTyVars EOF ;
    public final EObject entryRuleTyVars() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyVars = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:791:2: (iv_ruleTyVars= ruleTyVars EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:792:2: iv_ruleTyVars= ruleTyVars EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyVarsRule()); 
            }
            pushFollow(FOLLOW_ruleTyVars_in_entryRuleTyVars1471);
            iv_ruleTyVars=ruleTyVars();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyVars; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyVars1481); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:799:1: ruleTyVars returns [EObject current=null] : (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleTyVars() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attr_1_0 = null;

        EObject lv_attr_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:802:28: ( (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:803:1: (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:803:1: (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:803:3: otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleTyVars1518); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTyVarsAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:807:1: ( (lv_attr_1_0= ruleTyVar ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:808:1: (lv_attr_1_0= ruleTyVar )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:808:1: (lv_attr_1_0= ruleTyVar )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:809:3: lv_attr_1_0= ruleTyVar
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyVarsAccess().getAttrTyVarParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTyVar_in_ruleTyVars1539);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:825:2: (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:825:4: otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) )
            	    {
            	    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleTyVars1552); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTyVarsAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:829:1: ( (lv_attr_3_0= ruleTyVar ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:830:1: (lv_attr_3_0= ruleTyVar )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:830:1: (lv_attr_3_0= ruleTyVar )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:831:3: lv_attr_3_0= ruleTyVar
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTyVarsAccess().getAttrTyVarParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTyVar_in_ruleTyVars1573);
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

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleTyVars1587); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:859:1: entryRuleTyVar returns [EObject current=null] : iv_ruleTyVar= ruleTyVar EOF ;
    public final EObject entryRuleTyVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyVar = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:860:2: (iv_ruleTyVar= ruleTyVar EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:861:2: iv_ruleTyVar= ruleTyVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyVarRule()); 
            }
            pushFollow(FOLLOW_ruleTyVar_in_entryRuleTyVar1623);
            iv_ruleTyVar=ruleTyVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyVar1633); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:868:1: ruleTyVar returns [EObject current=null] : ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) ;
    public final EObject ruleTyVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:871:28: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:872:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:872:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:873:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:873:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:874:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:874:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:875:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyVar1676); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:890:8: lv_name_0_2= RULE_S
                    {
                    lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTyVar1696); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:916:1: entryRuleConDecl returns [EObject current=null] : iv_ruleConDecl= ruleConDecl EOF ;
    public final EObject entryRuleConDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:917:2: (iv_ruleConDecl= ruleConDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:918:2: iv_ruleConDecl= ruleConDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConDeclRule()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl1739);
            iv_ruleConDecl=ruleConDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl1749); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:925:1: ruleConDecl returns [EObject current=null] : ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleConDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_ty_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:928:28: ( ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:929:1: ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:929:1: ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:929:2: ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:929:2: ( (lv_name_0_0= ruleCONS ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:930:1: (lv_name_0_0= ruleCONS )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:930:1: (lv_name_0_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:931:3: lv_name_0_0= ruleCONS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConDeclAccess().getNameCONSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConDecl1795);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:947:2: (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==35) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:947:4: otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleConDecl1808); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConDeclAccess().getOfKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:951:1: ( (lv_ty_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:952:1: (lv_ty_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:952:1: (lv_ty_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:953:3: lv_ty_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleConDecl1829);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:977:1: entryRuleTy returns [EObject current=null] : iv_ruleTy= ruleTy EOF ;
    public final EObject entryRuleTy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTy = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:978:2: (iv_ruleTy= ruleTy EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:979:2: iv_ruleTy= ruleTy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyRule()); 
            }
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy1867);
            iv_ruleTy=ruleTy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTy; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy1877); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:986:1: ruleTy returns [EObject current=null] : ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:989:28: ( ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:990:1: ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:990:1: ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) )
            int alt32=8;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:990:2: ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:990:2: ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:991:1: ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:991:1: ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:992:1: (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:992:1: (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:993:3: lv_value_0_1= ruleINTEGER
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getValueINTEGERParserRuleCall_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleINTEGER_in_ruleTy1925);
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1008:8: lv_value_0_2= RULE_BINS
                            {
                            lv_value_0_2=(Token)match(input,RULE_BINS,FOLLOW_RULE_BINS_in_ruleTy1940); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1027:6: (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1027:6: (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1027:8: otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleTy1967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTyAccess().getVerticalLineKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1031:1: ( (lv_value_2_0= ruleINTEGER ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1032:1: (lv_value_2_0= ruleINTEGER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1032:1: (lv_value_2_0= ruleINTEGER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1033:3: lv_value_2_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueINTEGERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleTy1988);
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

                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleTy2000); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTyAccess().getVerticalLineKeyword_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:6: (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:6: (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:8: otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|'
                    {
                    otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleTy2020); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getTyAccess().getVerticalLineKeyword_2_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1058:1: ( (otherlv_5= RULE_ID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1059:1: (otherlv_5= RULE_ID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1059:1: (otherlv_5= RULE_ID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1060:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTyRule());
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTy2040); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_5, grammarAccess.getTyAccess().getTypeRefTypeCrossReference_2_1_0()); 
                      	
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleTy2052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getTyAccess().getVerticalLineKeyword_2_2());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1076:6: ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1076:6: ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1076:7: ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1076:7: ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1076:8: ( (otherlv_7= RULE_ID ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1076:8: ( (otherlv_7= RULE_ID ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1077:1: (otherlv_7= RULE_ID )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1077:1: (otherlv_7= RULE_ID )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1078:3: otherlv_7= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTyRule());
                              	        }
                                      
                            }
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTy2081); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_7, grammarAccess.getTyAccess().getTypeRefTypeCrossReference_3_0_0_0()); 
                              	
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1090:6: ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1090:6: ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1091:1: ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1091:1: ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1092:1: (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1092:1: (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' )
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1093:3: lv_type_8_1= 'int'
                                    {
                                    lv_type_8_1=(Token)match(input,36,FOLLOW_36_in_ruleTy2107); if (state.failed) return current;
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1105:8: lv_type_8_2= 'string'
                                    {
                                    lv_type_8_2=(Token)match(input,37,FOLLOW_37_in_ruleTy2136); if (state.failed) return current;
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1117:8: lv_type_8_3= 'unit'
                                    {
                                    lv_type_8_3=(Token)match(input,38,FOLLOW_38_in_ruleTy2165); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1132:3: (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==32) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1132:5: otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']'
                            {
                            otherlv_9=(Token)match(input,32,FOLLOW_32_in_ruleTy2195); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getTyAccess().getLeftSquareBracketKeyword_3_1_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1136:1: ( (lv_tyBind_10_0= ruleTyBind ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1137:1: (lv_tyBind_10_0= ruleTyBind )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1137:1: (lv_tyBind_10_0= ruleTyBind )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1138:3: lv_tyBind_10_0= ruleTyBind
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_3_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyBind_in_ruleTy2216);
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1154:2: (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==34) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1154:4: otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) )
                            	    {
                            	    otherlv_11=(Token)match(input,34,FOLLOW_34_in_ruleTy2229); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getTyAccess().getCommaKeyword_3_1_2_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1158:1: ( (lv_tyBind_12_0= ruleTyBind ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1159:1: (lv_tyBind_12_0= ruleTyBind )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1159:1: (lv_tyBind_12_0= ruleTyBind )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1160:3: lv_tyBind_12_0= ruleTyBind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_3_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyBind_in_ruleTy2250);
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

                            otherlv_13=(Token)match(input,33,FOLLOW_33_in_ruleTy2264); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1181:6: ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1181:6: ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1181:7: () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1181:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1182:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTyAccess().getTyAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_15=(Token)match(input,39,FOLLOW_39_in_ruleTy2295); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_4_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1191:1: ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_S)) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1191:2: ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1191:2: ( (lv_elements_16_0= ruleTyElement ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1192:1: (lv_elements_16_0= ruleTyElement )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1192:1: (lv_elements_16_0= ruleTyElement )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1193:3: lv_elements_16_0= ruleTyElement
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_4_2_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyElement_in_ruleTy2317);
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1209:2: (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==34) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1209:4: otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) )
                            	    {
                            	    otherlv_17=(Token)match(input,34,FOLLOW_34_in_ruleTy2330); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_17, grammarAccess.getTyAccess().getCommaKeyword_4_2_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1213:1: ( (lv_elements_18_0= ruleTyElement ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1214:1: (lv_elements_18_0= ruleTyElement )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1214:1: (lv_elements_18_0= ruleTyElement )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1215:3: lv_elements_18_0= ruleTyElement
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_4_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2351);
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

                    otherlv_19=(Token)match(input,40,FOLLOW_40_in_ruleTy2367); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getTyAccess().getRightCurlyBracketKeyword_4_3());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1236:6: (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1236:6: (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1236:8: otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) )
                    {
                    otherlv_20=(Token)match(input,41,FOLLOW_41_in_ruleTy2387); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getTyAccess().getLeftParenthesisKeyword_5_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1240:1: ( (lv_param_21_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1241:1: (lv_param_21_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1241:1: (lv_param_21_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1242:3: lv_param_21_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getParamTyParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2408);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1258:2: (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==34) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1258:4: otherlv_22= ',' ( (lv_param_23_0= ruleTy ) )
                    	    {
                    	    otherlv_22=(Token)match(input,34,FOLLOW_34_in_ruleTy2421); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_22, grammarAccess.getTyAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1262:1: ( (lv_param_23_0= ruleTy ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1263:1: (lv_param_23_0= ruleTy )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1263:1: (lv_param_23_0= ruleTy )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1264:3: lv_param_23_0= ruleTy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTyAccess().getParamTyParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTy_in_ruleTy2442);
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

                    otherlv_24=(Token)match(input,42,FOLLOW_42_in_ruleTy2456); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getTyAccess().getRightParenthesisKeyword_5_3());
                          
                    }
                    otherlv_25=(Token)match(input,43,FOLLOW_43_in_ruleTy2468); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getTyAccess().getHyphenMinusGreaterThanSignKeyword_5_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1288:1: ( (lv_resType_26_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1289:1: (lv_resType_26_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1289:1: (lv_resType_26_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1290:3: lv_resType_26_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getResTypeTyParserRuleCall_5_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2489);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1307:6: ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1307:6: ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1307:7: () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1307:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1308:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTyAccess().getTyAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_28=(Token)match(input,44,FOLLOW_44_in_ruleTy2518); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getTyAccess().getLeftParenthesisRightParenthesisKeyword_6_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1317:1: (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==43) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1317:3: otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) )
                            {
                            otherlv_29=(Token)match(input,43,FOLLOW_43_in_ruleTy2531); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_29, grammarAccess.getTyAccess().getHyphenMinusGreaterThanSignKeyword_6_2_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1321:1: ( (lv_resType_30_0= ruleTy ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1322:1: (lv_resType_30_0= ruleTy )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1322:1: (lv_resType_30_0= ruleTy )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1323:3: lv_resType_30_0= ruleTy
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getResTypeTyParserRuleCall_6_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTy_in_ruleTy2552);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1340:6: (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1340:6: (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1340:7: this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER
                    {
                    this_S_31=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTy2573); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_S_31, grammarAccess.getTyAccess().getSTerminalRuleCall_7_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1344:1: ( (lv_r_32_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1345:1: (lv_r_32_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1345:1: (lv_r_32_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1346:3: lv_r_32_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getRTyParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2593);
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

                    this_LESS_33=(Token)match(input,RULE_LESS,FOLLOW_RULE_LESS_in_ruleTy2604); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LESS_33, grammarAccess.getTyAccess().getLESSTerminalRuleCall_7_2()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1366:1: ( (lv_in_34_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1367:1: (lv_in_34_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1367:1: (lv_in_34_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1368:3: lv_in_34_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getInTyParserRuleCall_7_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2624);
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

                    otherlv_35=(Token)match(input,45,FOLLOW_45_in_ruleTy2636); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_35, grammarAccess.getTyAccess().getEqualsSignGreaterThanSignKeyword_7_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1388:1: ( (lv_out_36_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1389:1: (lv_out_36_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1389:1: (lv_out_36_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1390:3: lv_out_36_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getOutTyParserRuleCall_7_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2657);
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

                    this_GREATER_37=(Token)match(input,RULE_GREATER,FOLLOW_RULE_GREATER_in_ruleTy2668); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1418:1: entryRuleTyBind returns [EObject current=null] : iv_ruleTyBind= ruleTyBind EOF ;
    public final EObject entryRuleTyBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1419:2: (iv_ruleTyBind= ruleTyBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1420:2: iv_ruleTyBind= ruleTyBind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyBindRule()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind2704);
            iv_ruleTyBind=ruleTyBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyBind; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind2714); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1427:1: ruleTyBind returns [EObject current=null] : ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleTyBind() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1430:28: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1431:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1431:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1431:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1431:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1432:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1432:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1433:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1433:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1434:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyBind2758); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1449:8: lv_name_0_2= RULE_S
                    {
                    lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTyBind2778); if (state.failed) return current;
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1467:2: (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==29) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1467:4: otherlv_1= '=' ( (lv_value_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleTyBind2799); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1471:1: ( (lv_value_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1472:1: (lv_value_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1472:1: (lv_value_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1473:3: lv_value_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTyBind2820);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1497:1: entryRuleTyElement returns [EObject current=null] : iv_ruleTyElement= ruleTyElement EOF ;
    public final EObject entryRuleTyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyElement = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1498:2: (iv_ruleTyElement= ruleTyElement EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1499:2: iv_ruleTyElement= ruleTyElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyElementRule()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement2858);
            iv_ruleTyElement=ruleTyElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement2868); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1506:1: ruleTyElement returns [EObject current=null] : ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) ;
    public final EObject ruleTyElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1509:28: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1510:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1510:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1510:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1510:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1511:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1511:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1512:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1512:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1513:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyElement2912); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1528:8: lv_name_0_2= RULE_S
                    {
                    lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTyElement2932); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleTyElement2952); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTyElementAccess().getColonKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1550:1: ( (lv_value_2_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1551:1: (lv_value_2_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1551:1: (lv_value_2_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1552:3: lv_value_2_0= ruleTy
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTy_in_ruleTyElement2973);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1576:1: entryRuleExp returns [EObject current=null] : iv_ruleExp= ruleExp EOF ;
    public final EObject entryRuleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1577:2: (iv_ruleExp= ruleExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1578:2: iv_ruleExp= ruleExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpRule()); 
            }
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp3009);
            iv_ruleExp=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp3019); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1585:1: ruleExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ ) ;
    public final EObject ruleExp() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_mid_1_0 = null;

        EObject lv_caseExps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1588:28: ( ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1589:1: ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1589:1: ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1589:2: ( (lv_name_0_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1589:2: ( (lv_name_0_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1590:1: (lv_name_0_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1590:1: (lv_name_0_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1591:3: lv_name_0_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getNameCaseExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp3065);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1608:6: ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1608:6: ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+
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
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1608:7: ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1608:7: ( (lv_mid_1_0= ruleMID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1609:1: (lv_mid_1_0= ruleMID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1609:1: (lv_mid_1_0= ruleMID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1610:3: lv_mid_1_0= ruleMID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpAccess().getMidMIDParserRuleCall_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMID_in_ruleExp3093);
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

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1626:2: ( (lv_caseExps_2_0= ruleCaseExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1627:1: (lv_caseExps_2_0= ruleCaseExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1627:1: (lv_caseExps_2_0= ruleCaseExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1628:3: lv_caseExps_2_0= ruleCaseExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpAccess().getCaseExpsCaseExpParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp3114);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1652:1: entryRuleCaseExp returns [EObject current=null] : iv_ruleCaseExp= ruleCaseExp EOF ;
    public final EObject entryRuleCaseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1653:2: (iv_ruleCaseExp= ruleCaseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1654:2: iv_ruleCaseExp= ruleCaseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseExpRule()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_entryRuleCaseExp3152);
            iv_ruleCaseExp=ruleCaseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseExp3162); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1661:1: ruleCaseExp returns [EObject current=null] : (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1664:28: ( (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1665:1: (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1665:1: (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1666:5: this_ClosedExp_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp3209);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1675:6: ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1675:6: ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1675:7: ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1675:7: ( (lv_name_1_0= 'case' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1676:1: (lv_name_1_0= 'case' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1676:1: (lv_name_1_0= 'case' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1677:3: lv_name_1_0= 'case'
                    {
                    lv_name_1_0=(Token)match(input,46,FOLLOW_46_in_ruleCaseExp3233); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1690:2: ( (lv_closedExp_2_0= ruleClosedExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1691:1: (lv_closedExp_2_0= ruleClosedExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1691:1: (lv_closedExp_2_0= ruleClosedExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1692:3: lv_closedExp_2_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpClosedExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp3267);
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

                    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleCaseExp3279); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCaseExpAccess().getOfKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1712:1: ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1712:2: ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1712:2: ( (lv_pat_4_0= rulePAT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:1: (lv_pat_4_0= rulePAT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:1: (lv_pat_4_0= rulePAT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1714:3: lv_pat_4_0= rulePAT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getPatPATParserRuleCall_1_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePAT_in_ruleCaseExp3301);
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

                    otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleCaseExp3313); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCaseExpAccess().getColonKeyword_1_3_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1734:1: ( (lv_exp_6_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1735:1: (lv_exp_6_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1735:1: (lv_exp_6_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1736:3: lv_exp_6_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getExpExpParserRuleCall_1_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleCaseExp3334);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1752:2: (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==30) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1752:4: otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) )
                    	    {
                    	    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleCaseExp3347); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getCaseExpAccess().getVerticalLineKeyword_1_3_3_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1756:1: ( (lv_pat_8_0= rulePAT ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1757:1: (lv_pat_8_0= rulePAT )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1757:1: (lv_pat_8_0= rulePAT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1758:3: lv_pat_8_0= rulePAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCaseExpAccess().getPatPATParserRuleCall_1_3_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePAT_in_ruleCaseExp3368);
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

                    	    otherlv_9=(Token)match(input,27,FOLLOW_27_in_ruleCaseExp3380); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getCaseExpAccess().getColonKeyword_1_3_3_2());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1778:1: ( (lv_exp_10_0= ruleExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1779:1: (lv_exp_10_0= ruleExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1779:1: (lv_exp_10_0= ruleExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1780:3: lv_exp_10_0= ruleExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCaseExpAccess().getExpExpParserRuleCall_1_3_3_3_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExp_in_ruleCaseExp3401);
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

                    otherlv_11=(Token)match(input,47,FOLLOW_47_in_ruleCaseExp3416); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1808:1: entryRuleClosedExp returns [EObject current=null] : iv_ruleClosedExp= ruleClosedExp EOF ;
    public final EObject entryRuleClosedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosedExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1809:2: (iv_ruleClosedExp= ruleClosedExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1810:2: iv_ruleClosedExp= ruleClosedExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosedExpRule()); 
            }
            pushFollow(FOLLOW_ruleClosedExp_in_entryRuleClosedExp3453);
            iv_ruleClosedExp=ruleClosedExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosedExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedExp3463); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1817:1: ruleClosedExp returns [EObject current=null] : (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1820:28: ( (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1821:1: (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1821:1: (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1822:5: this_OrElseExp_0= ruleOrElseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClosedExpAccess().getOrElseExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrElseExp_in_ruleClosedExp3510);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1831:6: ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1831:6: ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1831:7: ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1831:7: ( (lv_name_1_0= 'if' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1832:1: (lv_name_1_0= 'if' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1832:1: (lv_name_1_0= 'if' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1833:3: lv_name_1_0= 'if'
                    {
                    lv_name_1_0=(Token)match(input,48,FOLLOW_48_in_ruleClosedExp3534); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1846:2: ( (lv_ifCaseExp_2_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1847:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1847:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1848:3: lv_ifCaseExp_2_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getIfCaseExpCaseExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3568);
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

                    otherlv_3=(Token)match(input,49,FOLLOW_49_in_ruleClosedExp3580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getClosedExpAccess().getThenKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1868:1: ( (lv_thenCaseExp_4_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1869:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1869:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1870:3: lv_thenCaseExp_4_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getThenCaseExpCaseExpParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3601);
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

                    otherlv_5=(Token)match(input,50,FOLLOW_50_in_ruleClosedExp3613); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getClosedExpAccess().getElseKeyword_1_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1890:1: ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1891:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1891:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1892:3: lv_elseCaseExp_6_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getElseCaseExpCaseExpParserRuleCall_1_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3634);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1909:6: ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1909:6: ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1909:7: ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1909:7: ( (lv_name_7_0= 'do' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1910:1: (lv_name_7_0= 'do' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1910:1: (lv_name_7_0= 'do' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1911:3: lv_name_7_0= 'do'
                    {
                    lv_name_7_0=(Token)match(input,51,FOLLOW_51_in_ruleClosedExp3660); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1924:2: ( (lv_doExp_8_0= ruleMonadicExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1925:1: (lv_doExp_8_0= ruleMonadicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1925:1: (lv_doExp_8_0= ruleMonadicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1926:3: lv_doExp_8_0= ruleMonadicExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3694);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1942:2: (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==25) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1942:4: otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    {
                    	    otherlv_9=(Token)match(input,25,FOLLOW_25_in_ruleClosedExp3707); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getClosedExpAccess().getSemicolonKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1946:1: ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1947:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1947:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1948:3: lv_doExp_10_0= ruleMonadicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3728);
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

                    otherlv_11=(Token)match(input,47,FOLLOW_47_in_ruleClosedExp3742); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1976:1: entryRuleMonadicExp returns [EObject current=null] : iv_ruleMonadicExp= ruleMonadicExp EOF ;
    public final EObject entryRuleMonadicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonadicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1977:2: (iv_ruleMonadicExp= ruleMonadicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1978:2: iv_ruleMonadicExp= ruleMonadicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMonadicExpRule()); 
            }
            pushFollow(FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3779);
            iv_ruleMonadicExp=ruleMonadicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMonadicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonadicExp3789); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1985:1: ruleMonadicExp returns [EObject current=null] : ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) ;
    public final EObject ruleMonadicExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1988:28: ( ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            int alt43=2;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:2: ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:2: ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:3: ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1994:1: (lv_exp_0_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1995:3: lv_exp_0_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3845);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2012:6: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2012:6: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2012:7: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2012:7: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2013:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2013:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2014:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2014:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2015:3: lv_name_1_1= RULE_ID
                            {
                            lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonadicExp3871); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2030:8: lv_name_1_2= RULE_S
                            {
                            lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleMonadicExp3891); if (state.failed) return current;
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

                    otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleMonadicExp3911); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getMonadicExpAccess().getLessThanSignHyphenMinusKeyword_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2052:1: ( (lv_exp_3_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2053:1: (lv_exp_3_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2053:1: (lv_exp_3_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2054:3: lv_exp_3_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3932);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:1: entryRuleOrElseExp returns [EObject current=null] : iv_ruleOrElseExp= ruleOrElseExp EOF ;
    public final EObject entryRuleOrElseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrElseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2079:2: (iv_ruleOrElseExp= ruleOrElseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2080:2: iv_ruleOrElseExp= ruleOrElseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrElseExpRule()); 
            }
            pushFollow(FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3969);
            iv_ruleOrElseExp=ruleOrElseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrElseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrElseExp3979); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2087:1: ruleOrElseExp returns [EObject current=null] : (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) ;
    public final EObject ruleOrElseExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_AndAlsoExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2090:28: ( (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2091:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2091:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2092:5: this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrElseExpAccess().getAndAlsoExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp4026);
            this_AndAlsoExp_0=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndAlsoExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2100:1: ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==53) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2100:2: () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2100:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2101:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2106:2: ( (lv_name_2_0= 'or' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2107:1: (lv_name_2_0= 'or' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2107:1: (lv_name_2_0= 'or' )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2108:3: lv_name_2_0= 'or'
            	    {
            	    lv_name_2_0=(Token)match(input,53,FOLLOW_53_in_ruleOrElseExp4053); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2121:2: ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2122:1: (lv_right_3_0= ruleAndAlsoExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2122:1: (lv_right_3_0= ruleAndAlsoExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2123:3: lv_right_3_0= ruleAndAlsoExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrElseExpAccess().getRightAndAlsoExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp4087);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2147:1: entryRuleAndAlsoExp returns [EObject current=null] : iv_ruleAndAlsoExp= ruleAndAlsoExp EOF ;
    public final EObject entryRuleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndAlsoExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2148:2: (iv_ruleAndAlsoExp= ruleAndAlsoExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2149:2: iv_ruleAndAlsoExp= ruleAndAlsoExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndAlsoExpRule()); 
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp4125);
            iv_ruleAndAlsoExp=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndAlsoExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndAlsoExp4135); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2156:1: ruleAndAlsoExp returns [EObject current=null] : (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* ) ;
    public final EObject ruleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_RExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:28: ( (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2160:1: (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2160:1: (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2161:5: this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp4182);
            this_RExp_0=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2169:1: ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==54) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2169:2: () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2169:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2170:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2175:2: ( (lv_name_2_0= 'and' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2176:1: (lv_name_2_0= 'and' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2176:1: (lv_name_2_0= 'and' )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2177:3: lv_name_2_0= 'and'
            	    {
            	    lv_name_2_0=(Token)match(input,54,FOLLOW_54_in_ruleAndAlsoExp4209); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2190:2: ( (lv_right_3_0= ruleRExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2191:1: (lv_right_3_0= ruleRExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2191:1: (lv_right_3_0= ruleRExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2192:3: lv_right_3_0= ruleRExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRightRExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp4243);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2216:1: entryRuleRExp returns [EObject current=null] : iv_ruleRExp= ruleRExp EOF ;
    public final EObject entryRuleRExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2217:2: (iv_ruleRExp= ruleRExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2218:2: iv_ruleRExp= ruleRExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRExpRule()); 
            }
            pushFollow(FOLLOW_ruleRExp_in_entryRuleRExp4281);
            iv_ruleRExp=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRExp4291); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2225:1: ruleRExp returns [EObject current=null] : (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) ;
    public final EObject ruleRExp() throws RecognitionException {
        EObject current = null;

        EObject this_AExp_0 = null;

        AntlrDatatypeRuleToken lv_sym_1_0 = null;

        EObject lv_aexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2228:28: ( (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2229:1: (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2229:1: (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2230:5: this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRExpAccess().getAExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAExp_in_ruleRExp4338);
            this_AExp_0=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2238:1: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            loop46:
            do {
                int alt46=2;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2238:2: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2238:2: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2238:3: ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2243:1: (lv_sym_1_0= ruleSYM )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2244:3: lv_sym_1_0= ruleSYM
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getSymSYMParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSYM_in_ruleRExp4369);
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2260:2: ( (lv_aexps_2_0= ruleAExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2261:1: (lv_aexps_2_0= ruleAExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2261:1: (lv_aexps_2_0= ruleAExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2262:3: lv_aexps_2_0= ruleAExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getAexpsAExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAExp_in_ruleRExp4390);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2286:1: entryRuleAExp returns [EObject current=null] : iv_ruleAExp= ruleAExp EOF ;
    public final EObject entryRuleAExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2287:2: (iv_ruleAExp= ruleAExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2288:2: iv_ruleAExp= ruleAExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpRule()); 
            }
            pushFollow(FOLLOW_ruleAExp_in_entryRuleAExp4428);
            iv_ruleAExp=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExp4438); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2295:1: ruleAExp returns [EObject current=null] : (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) ;
    public final EObject ruleAExp() throws RecognitionException {
        EObject current = null;

        Token lv_sign_1_1=null;
        Token lv_sign_1_2=null;
        EObject this_MExp_0 = null;

        EObject lv_mexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2298:28: ( (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2299:1: (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2299:1: (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2300:5: this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAExpAccess().getMExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMExp_in_ruleAExp4485);
            this_MExp_0=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2308:1: ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=55 && LA48_0<=56)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2308:2: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2308:2: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2309:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2309:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2310:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2310:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2311:3: lv_sign_1_1= '+'
            	            {
            	            lv_sign_1_1=(Token)match(input,55,FOLLOW_55_in_ruleAExp4505); if (state.failed) return current;
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2323:8: lv_sign_1_2= '-'
            	            {
            	            lv_sign_1_2=(Token)match(input,56,FOLLOW_56_in_ruleAExp4534); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2338:2: ( (lv_mexps_2_0= ruleMExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2339:1: (lv_mexps_2_0= ruleMExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2339:1: (lv_mexps_2_0= ruleMExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2340:3: lv_mexps_2_0= ruleMExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAExpAccess().getMexpsMExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMExp_in_ruleAExp4571);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2364:1: entryRuleMExp returns [EObject current=null] : iv_ruleMExp= ruleMExp EOF ;
    public final EObject entryRuleMExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2365:2: (iv_ruleMExp= ruleMExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2366:2: iv_ruleMExp= ruleMExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMExpRule()); 
            }
            pushFollow(FOLLOW_ruleMExp_in_entryRuleMExp4609);
            iv_ruleMExp=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMExp4619); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2373:1: ruleMExp returns [EObject current=null] : (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) ;
    public final EObject ruleMExp() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_1=null;
        Token lv_symbol_1_2=null;
        EObject this_SelectExp_0 = null;

        EObject lv_applyexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2376:28: ( (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2377:1: (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2377:1: (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2378:5: this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMExpAccess().getSelectExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleSelectExp_in_ruleMExp4666);
            this_SelectExp_0=ruleSelectExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_SelectExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2386:1: ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=57 && LA50_0<=58)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2386:2: ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2386:2: ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2387:1: ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2387:1: ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2388:1: (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2388:1: (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' )
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2389:3: lv_symbol_1_1= '*'
            	            {
            	            lv_symbol_1_1=(Token)match(input,57,FOLLOW_57_in_ruleMExp4686); if (state.failed) return current;
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2401:8: lv_symbol_1_2= '%'
            	            {
            	            lv_symbol_1_2=(Token)match(input,58,FOLLOW_58_in_ruleMExp4715); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2416:2: ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2417:1: (lv_applyexps_2_0= ruleApplyExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2417:1: (lv_applyexps_2_0= ruleApplyExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2418:3: lv_applyexps_2_0= ruleApplyExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMExpAccess().getApplyexpsApplyExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleApplyExp_in_ruleMExp4752);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2442:1: entryRuleSelectExp returns [EObject current=null] : iv_ruleSelectExp= ruleSelectExp EOF ;
    public final EObject entryRuleSelectExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2443:2: (iv_ruleSelectExp= ruleSelectExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2444:2: iv_ruleSelectExp= ruleSelectExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelectExpRule()); 
            }
            pushFollow(FOLLOW_ruleSelectExp_in_entryRuleSelectExp4790);
            iv_ruleSelectExp=ruleSelectExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelectExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectExp4800); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2451:1: ruleSelectExp returns [EObject current=null] : (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) ;
    public final EObject ruleSelectExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ApplyExp_0 = null;

        EObject lv_applyexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2454:28: ( (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2455:1: (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2455:1: (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2456:5: this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSelectExpAccess().getApplyExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleApplyExp_in_ruleSelectExp4847);
            this_ApplyExp_0=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ApplyExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2464:1: (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==59) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2464:3: otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    {
            	    otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleSelectExp4859); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getSelectExpAccess().getCircumflexAccentKeyword_1_0());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2468:1: ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2469:1: (lv_applyexps_2_0= ruleApplyExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2469:1: (lv_applyexps_2_0= ruleApplyExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2470:3: lv_applyexps_2_0= ruleApplyExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSelectExpAccess().getApplyexpsApplyExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleApplyExp_in_ruleSelectExp4880);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2494:1: entryRuleApplyExp returns [EObject current=null] : iv_ruleApplyExp= ruleApplyExp EOF ;
    public final EObject entryRuleApplyExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2495:2: (iv_ruleApplyExp= ruleApplyExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2496:2: iv_ruleApplyExp= ruleApplyExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getApplyExpRule()); 
            }
            pushFollow(FOLLOW_ruleApplyExp_in_entryRuleApplyExp4918);
            iv_ruleApplyExp=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleApplyExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleApplyExp4928); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2503:1: ruleApplyExp returns [EObject current=null] : ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) ) ) ;
    public final EObject ruleApplyExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_AtomicExp_1 = null;

        EObject lv_atomicExp_2_0 = null;

        EObject lv_args_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2506:28: ( ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2507:1: ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2507:1: ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) ) )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2507:2: (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2507:2: (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2507:4: otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp
                    {
                    otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleApplyExp4966); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getApplyExpAccess().getTildeKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getApplyExpAccess().getAtomicExpParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAtomicExp_in_ruleApplyExp4988);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2521:6: ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2521:6: ( ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2521:7: ( (lv_atomicExp_2_0= ruleAtomicExp ) ) ( (lv_args_3_0= ruleArgs ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2521:7: ( (lv_atomicExp_2_0= ruleAtomicExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2522:1: (lv_atomicExp_2_0= ruleAtomicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2522:1: (lv_atomicExp_2_0= ruleAtomicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2523:3: lv_atomicExp_2_0= ruleAtomicExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getApplyExpAccess().getAtomicExpAtomicExpParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAtomicExp_in_ruleApplyExp5016);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2539:2: ( (lv_args_3_0= ruleArgs ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2540:1: (lv_args_3_0= ruleArgs )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2540:1: (lv_args_3_0= ruleArgs )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2541:3: lv_args_3_0= ruleArgs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getApplyExpAccess().getArgsArgsParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgs_in_ruleApplyExp5037);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2565:1: entryRuleArgs returns [EObject current=null] : iv_ruleArgs= ruleArgs EOF ;
    public final EObject entryRuleArgs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgs = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2566:2: (iv_ruleArgs= ruleArgs EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2567:2: iv_ruleArgs= ruleArgs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgsRule()); 
            }
            pushFollow(FOLLOW_ruleArgs_in_entryRuleArgs5074);
            iv_ruleArgs=ruleArgs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgs; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgs5084); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2574:1: ruleArgs returns [EObject current=null] : ( () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' ) ) ;
    public final EObject ruleArgs() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_args_1_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2577:28: ( ( () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2578:1: ( () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2578:1: ( () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2578:2: () ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2578:2: ()
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2579:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getArgsAccess().getArgsAction_0(),
                          current);
                  
            }

            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2584:2: ( ( (lv_args_1_0= ruleAtomicExp ) )* | otherlv_2= '()' )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2584:3: ( (lv_args_1_0= ruleAtomicExp ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2584:3: ( (lv_args_1_0= ruleAtomicExp ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( ((LA53_0>=RULE_ID && LA53_0<=RULE_S)||LA53_0==RULE_STRING||LA53_0==RULE_HEXINT||(LA53_0>=RULE_NEGINT && LA53_0<=RULE_DUALS)||LA53_0==39||LA53_0==41||(LA53_0>=61 && LA53_0<=63)||LA53_0==65) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2585:1: (lv_args_1_0= ruleAtomicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2585:1: (lv_args_1_0= ruleAtomicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2586:3: lv_args_1_0= ruleAtomicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getArgsAccess().getArgsAtomicExpParserRuleCall_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAtomicExp_in_ruleArgs5140);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2603:7: otherlv_2= '()'
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleArgs5159); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2615:1: entryRuleAtomicExp returns [EObject current=null] : iv_ruleAtomicExp= ruleAtomicExp EOF ;
    public final EObject entryRuleAtomicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2616:2: (iv_ruleAtomicExp= ruleAtomicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2617:2: iv_ruleAtomicExp= ruleAtomicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExpRule()); 
            }
            pushFollow(FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp5196);
            iv_ruleAtomicExp=ruleAtomicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicExp5206); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2624:1: ruleAtomicExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2627:28: ( ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2628:1: ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2628:1: ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2628:2: ( (lv_name_0_0= ruleLIT ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2628:2: ( (lv_name_0_0= ruleLIT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2629:1: (lv_name_0_0= ruleLIT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2629:1: (lv_name_0_0= ruleLIT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2630:3: lv_name_0_0= ruleLIT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getNameLITParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLIT_in_ruleAtomicExp5252);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2647:6: ( (lv_name_1_0= RULE_STRING ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2647:6: ( (lv_name_1_0= RULE_STRING ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2648:1: (lv_name_1_0= RULE_STRING )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2648:1: (lv_name_1_0= RULE_STRING )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2649:3: lv_name_1_0= RULE_STRING
                    {
                    lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAtomicExp5275); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2666:6: ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2666:6: ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2666:7: ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2666:7: ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2667:1: ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2667:1: ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2668:1: (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2668:1: (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2669:3: lv_name_2_1= RULE_ID
                            {
                            lv_name_2_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5306); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2684:8: lv_name_2_2= RULE_S
                            {
                            lv_name_2_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5326); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2702:2: ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==RULE_DOT) ) {
                            int LA57_2 = input.LA(2);

                            if ( (LA57_2==RULE_ID) ) {
                                int LA57_3 = input.LA(3);

                                if ( (synpred7_InternalGDSL()) ) {
                                    alt57=1;
                                }


                            }
                            else if ( (LA57_2==RULE_S) ) {
                                int LA57_4 = input.LA(3);

                                if ( (synpred7_InternalGDSL()) ) {
                                    alt57=1;
                                }


                            }


                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2702:3: ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2702:3: ( ( RULE_DOT )=>this_DOT_3= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2702:4: ( RULE_DOT )=>this_DOT_3= RULE_DOT
                    	    {
                    	    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp5352); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_3, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_2_1_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2706:2: ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2707:1: ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2707:1: ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2708:1: (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2708:1: (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S )
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2709:3: lv_id_4_1= RULE_ID
                    	            {
                    	            lv_id_4_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5371); if (state.failed) return current;
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2724:8: lv_id_4_2= RULE_S
                    	            {
                    	            lv_id_4_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5391); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2743:6: ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2743:6: ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2743:7: ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2743:7: ( (lv_name_5_0= '@' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2744:1: (lv_name_5_0= '@' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2744:1: (lv_name_5_0= '@' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2745:3: lv_name_5_0= '@'
                    {
                    lv_name_5_0=(Token)match(input,61,FOLLOW_61_in_ruleAtomicExp5427); if (state.failed) return current;
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

                    otherlv_6=(Token)match(input,39,FOLLOW_39_in_ruleAtomicExp5452); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_3_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2762:1: ( (lv_fields_7_0= ruleField ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2763:1: (lv_fields_7_0= ruleField )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2763:1: (lv_fields_7_0= ruleField )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2764:3: lv_fields_7_0= ruleField
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp5473);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2780:2: (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==34) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2780:4: otherlv_8= ',' ( (lv_fields_9_0= ruleField ) )
                    	    {
                    	    otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExp5486); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getAtomicExpAccess().getCommaKeyword_3_3_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2784:1: ( (lv_fields_9_0= ruleField ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2785:1: (lv_fields_9_0= ruleField )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2785:1: (lv_fields_9_0= ruleField )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2786:3: lv_fields_9_0= ruleField
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_3_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp5507);
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

                    otherlv_10=(Token)match(input,40,FOLLOW_40_in_ruleAtomicExp5521); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_3_4());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2807:6: (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2807:6: (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2807:8: otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) )
                    {
                    otherlv_11=(Token)match(input,62,FOLLOW_62_in_ruleAtomicExp5541); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getAtomicExpAccess().getDollarSignKeyword_4_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2811:1: ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2812:1: ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2812:1: ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2813:1: (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2813:1: (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2814:3: lv_name_12_1= RULE_ID
                            {
                            lv_name_12_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5560); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2829:8: lv_name_12_2= RULE_S
                            {
                            lv_name_12_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5580); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2848:6: (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2848:6: (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2848:8: otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )*
                    {
                    otherlv_13=(Token)match(input,41,FOLLOW_41_in_ruleAtomicExp5608); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getAtomicExpAccess().getLeftParenthesisKeyword_5_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2852:1: ( (lv_expr_14_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2853:1: (lv_expr_14_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2853:1: (lv_expr_14_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2854:3: lv_expr_14_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExprExpParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5629);
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

                    otherlv_15=(Token)match(input,42,FOLLOW_42_in_ruleAtomicExp5641); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getAtomicExpAccess().getRightParenthesisKeyword_5_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2874:1: ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==RULE_DOT) ) {
                            int LA61_2 = input.LA(2);

                            if ( (LA61_2==RULE_ID) ) {
                                int LA61_3 = input.LA(3);

                                if ( (synpred8_InternalGDSL()) ) {
                                    alt61=1;
                                }


                            }
                            else if ( (LA61_2==RULE_S) ) {
                                int LA61_4 = input.LA(3);

                                if ( (synpred8_InternalGDSL()) ) {
                                    alt61=1;
                                }


                            }


                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2874:2: ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2874:2: ( ( RULE_DOT )=>this_DOT_16= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2874:3: ( RULE_DOT )=>this_DOT_16= RULE_DOT
                    	    {
                    	    this_DOT_16=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp5659); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_16, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_5_3_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2878:2: ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2879:1: ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2879:1: ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2880:1: (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2880:1: (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S )
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2881:3: lv_id_17_1= RULE_ID
                    	            {
                    	            lv_id_17_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5678); if (state.failed) return current;
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2896:8: lv_id_17_2= RULE_S
                    	            {
                    	            lv_id_17_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5698); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2915:6: ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2915:6: ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2915:7: () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2915:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2916:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExpAccess().getAtomicExpAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_19=(Token)match(input,39,FOLLOW_39_in_ruleAtomicExp5737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_6_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2925:1: ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( ((LA65_0>=RULE_ID && LA65_0<=RULE_S)) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2925:2: ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2925:2: ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2926:1: ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2926:1: ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2927:1: (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2927:1: (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S )
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2928:3: lv_id_20_1= RULE_ID
                                    {
                                    lv_id_20_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5757); if (state.failed) return current;
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2943:8: lv_id_20_2= RULE_S
                                    {
                                    lv_id_20_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5777); if (state.failed) return current;
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

                            otherlv_21=(Token)match(input,29,FOLLOW_29_in_ruleAtomicExp5797); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_21, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_6_2_1());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2965:1: ( (lv_exps_22_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2966:1: (lv_exps_22_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2966:1: (lv_exps_22_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2967:3: lv_exps_22_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_6_2_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5818);
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2983:2: (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )*
                            loop64:
                            do {
                                int alt64=2;
                                int LA64_0 = input.LA(1);

                                if ( (LA64_0==34) ) {
                                    alt64=1;
                                }


                                switch (alt64) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2983:4: otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) )
                            	    {
                            	    otherlv_23=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExp5831); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_23, grammarAccess.getAtomicExpAccess().getCommaKeyword_6_2_3_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2987:1: ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2988:1: ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2988:1: ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2989:1: (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2989:1: (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S )
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
                            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2990:3: lv_id_24_1= RULE_ID
                            	            {
                            	            lv_id_24_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5850); if (state.failed) return current;
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
                            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3005:8: lv_id_24_2= RULE_S
                            	            {
                            	            lv_id_24_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5870); if (state.failed) return current;
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

                            	    otherlv_25=(Token)match(input,29,FOLLOW_29_in_ruleAtomicExp5890); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_25, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_6_2_3_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3027:1: ( (lv_exps_26_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3028:1: (lv_exps_26_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3028:1: (lv_exps_26_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3029:3: lv_exps_26_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_6_2_3_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5911);
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

                    otherlv_27=(Token)match(input,40,FOLLOW_40_in_ruleAtomicExp5927); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_6_3());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3050:6: ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3050:6: ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3050:7: ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3050:7: ( (lv_name_28_0= 'let' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3051:1: (lv_name_28_0= 'let' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3051:1: (lv_name_28_0= 'let' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3052:3: lv_name_28_0= 'let'
                    {
                    lv_name_28_0=(Token)match(input,63,FOLLOW_63_in_ruleAtomicExp5953); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3065:2: ( (lv_valDecl_29_0= ruleValueDecl ) )+
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
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3066:1: (lv_valDecl_29_0= ruleValueDecl )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3066:1: (lv_valDecl_29_0= ruleValueDecl )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3067:3: lv_valDecl_29_0= ruleValueDecl
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getValDeclValueDeclParserRuleCall_7_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleValueDecl_in_ruleAtomicExp5987);
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

                    otherlv_30=(Token)match(input,64,FOLLOW_64_in_ruleAtomicExp6000); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_30, grammarAccess.getAtomicExpAccess().getInKeyword_7_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3087:1: ( (lv_expr_31_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3088:1: (lv_expr_31_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3088:1: (lv_expr_31_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3089:3: lv_expr_31_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExprExpParserRuleCall_7_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp6021);
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

                    otherlv_32=(Token)match(input,47,FOLLOW_47_in_ruleAtomicExp6033); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3117:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3118:2: (iv_ruleField= ruleField EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3119:2: iv_ruleField= ruleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_ruleField_in_entryRuleField6070);
            iv_ruleField=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleField6080); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3126:1: ruleField returns [EObject current=null] : ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3129:28: ( ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3130:1: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3130:1: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3130:2: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3130:2: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3130:3: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3130:3: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3131:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3131:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3132:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3132:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3133:3: lv_name_0_1= RULE_ID
                            {
                            lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleField6125); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3148:8: lv_name_0_2= RULE_S
                            {
                            lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleField6145); if (state.failed) return current;
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

                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleField6165); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getFieldAccess().getEqualsSignKeyword_0_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3170:1: ( (lv_exp_2_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3171:1: (lv_exp_2_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3171:1: (lv_exp_2_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3172:3: lv_exp_2_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFieldAccess().getExpExpParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleField6186);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3189:6: (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3189:6: (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3189:8: otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) )
                    {
                    otherlv_3=(Token)match(input,60,FOLLOW_60_in_ruleField6206); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getTildeKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3193:1: ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3194:1: ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3194:1: ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3195:1: (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3195:1: (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3196:3: lv_name_4_1= RULE_ID
                            {
                            lv_name_4_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleField6225); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3211:8: lv_name_4_2= RULE_S
                            {
                            lv_name_4_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleField6245); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3237:1: entryRuleValueDecl returns [EObject current=null] : iv_ruleValueDecl= ruleValueDecl EOF ;
    public final EObject entryRuleValueDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3238:2: (iv_ruleValueDecl= ruleValueDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3239:2: iv_ruleValueDecl= ruleValueDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueDeclRule()); 
            }
            pushFollow(FOLLOW_ruleValueDecl_in_entryRuleValueDecl6290);
            iv_ruleValueDecl=ruleValueDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueDecl6300); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3246:1: ruleValueDecl returns [EObject current=null] : (otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3249:28: ( (otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3250:1: (otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3250:1: (otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3250:3: otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleValueDecl6337); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getValueDeclAccess().getValKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3254:1: ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID) && (synpred9_InternalGDSL())) {
                alt72=1;
            }
            else if ( (LA72_0==RULE_S) && (synpred9_InternalGDSL())) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3254:2: ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3254:2: ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3254:3: ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3265:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3266:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3266:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3267:3: lv_name_1_1= RULE_ID
                            {
                            lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueDecl6383); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3282:8: lv_name_1_2= RULE_S
                            {
                            lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleValueDecl6403); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3301:6: ( (lv_name_2_0= ruleSYM ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3301:6: ( (lv_name_2_0= ruleSYM ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3302:1: (lv_name_2_0= ruleSYM )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3302:1: (lv_name_2_0= ruleSYM )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3303:3: lv_name_2_0= ruleSYM
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueDeclAccess().getNameSYMParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSYM_in_ruleValueDecl6438);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3319:3: ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_S)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3320:1: ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3320:1: ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3321:1: (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3321:1: (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S )
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3322:3: lv_ids_3_1= RULE_ID
            	            {
            	            lv_ids_3_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueDecl6458); if (state.failed) return current;
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3337:8: lv_ids_3_2= RULE_S
            	            {
            	            lv_ids_3_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleValueDecl6478); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleValueDecl6499); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getValueDeclAccess().getEqualsSignKeyword_3());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3359:1: ( (lv_exp_5_0= ruleExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3360:1: (lv_exp_5_0= ruleExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3360:1: (lv_exp_5_0= ruleExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3361:3: lv_exp_5_0= ruleExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueDeclAccess().getExpExpParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExp_in_ruleValueDecl6520);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3385:1: entryRulePAT returns [EObject current=null] : iv_rulePAT= rulePAT EOF ;
    public final EObject entryRulePAT() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3386:2: (iv_rulePAT= rulePAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3387:2: iv_rulePAT= rulePAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPATRule()); 
            }
            pushFollow(FOLLOW_rulePAT_in_entryRulePAT6556);
            iv_rulePAT=rulePAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePAT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePAT6566); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3394:1: rulePAT returns [EObject current=null] : ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3397:28: ( ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3398:1: ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3398:1: ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) )
            int alt77=4;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_USCORE) ) {
                alt77=1;
            }
            else if ( (LA77_0==RULE_POSINT_WO_DUALS) && (synpred10_InternalGDSL())) {
                alt77=2;
            }
            else if ( (LA77_0==RULE_DUALS) && (synpred10_InternalGDSL())) {
                alt77=2;
            }
            else if ( (LA77_0==RULE_HEXINT) && (synpred10_InternalGDSL())) {
                alt77=2;
            }
            else if ( (LA77_0==RULE_NEGINT) && (synpred10_InternalGDSL())) {
                alt77=2;
            }
            else if ( (LA77_0==RULE_ID) && (synpred11_InternalGDSL())) {
                alt77=3;
            }
            else if ( (LA77_0==RULE_S) && (synpred11_InternalGDSL())) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3398:2: ( (lv_uscore_0_0= RULE_USCORE ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3398:2: ( (lv_uscore_0_0= RULE_USCORE ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3399:1: (lv_uscore_0_0= RULE_USCORE )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3399:1: (lv_uscore_0_0= RULE_USCORE )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3400:3: lv_uscore_0_0= RULE_USCORE
                    {
                    lv_uscore_0_0=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_rulePAT6608); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3417:6: ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3417:6: ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3417:7: ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3421:5: ( (lv_int_1_0= ruleINTEGER ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3422:1: (lv_int_1_0= ruleINTEGER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3422:1: (lv_int_1_0= ruleINTEGER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3423:3: lv_int_1_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPATAccess().getIntINTEGERParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_rulePAT6653);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3440:6: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3440:6: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3440:7: ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3454:7: ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3454:8: ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3454:8: ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3455:1: ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3455:1: ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3456:1: (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3456:1: (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3457:3: lv_id_2_1= RULE_ID
                            {
                            lv_id_2_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePAT6721); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3472:8: lv_id_2_2= RULE_S
                            {
                            lv_id_2_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_rulePAT6741); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3490:2: ( (lv_pat_3_0= rulePAT ) )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( ((LA76_0>=RULE_ID && LA76_0<=RULE_S)||(LA76_0>=RULE_USCORE && LA76_0<=RULE_HEXINT)||(LA76_0>=RULE_NEGINT && LA76_0<=RULE_DUALS)||LA76_0==65) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3491:1: (lv_pat_3_0= rulePAT )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3491:1: (lv_pat_3_0= rulePAT )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3492:3: lv_pat_3_0= rulePAT
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPATAccess().getPatPATParserRuleCall_2_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePAT_in_rulePAT6770);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3509:6: (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3509:6: (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3509:8: otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\''
                    {
                    otherlv_4=(Token)match(input,65,FOLLOW_65_in_rulePAT6792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPATAccess().getApostropheKeyword_3_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3513:1: ( (lv_bitpat_5_0= ruleBITPAT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3514:1: (lv_bitpat_5_0= ruleBITPAT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3514:1: (lv_bitpat_5_0= ruleBITPAT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3515:3: lv_bitpat_5_0= ruleBITPAT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPATAccess().getBitpatBITPATParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBITPAT_in_rulePAT6813);
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

                    otherlv_6=(Token)match(input,65,FOLLOW_65_in_rulePAT6825); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3543:1: entryRuleCONS returns [EObject current=null] : iv_ruleCONS= ruleCONS EOF ;
    public final EObject entryRuleCONS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCONS = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3544:2: (iv_ruleCONS= ruleCONS EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3545:2: iv_ruleCONS= ruleCONS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCONSRule()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS6862);
            iv_ruleCONS=ruleCONS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCONS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS6872); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3552:1: ruleCONS returns [EObject current=null] : ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) ) ;
    public final EObject ruleCONS() throws RecognitionException {
        EObject current = null;

        Token lv_conName_0_1=null;
        Token lv_conName_0_2=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3555:28: ( ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3556:1: ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3556:1: ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3557:1: ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3557:1: ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3558:1: (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3558:1: (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3559:3: lv_conName_0_1= RULE_ID
                    {
                    lv_conName_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCONS6915); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3574:8: lv_conName_0_2= RULE_S
                    {
                    lv_conName_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleCONS6935); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3600:1: entryRuleDECODEPAT returns [String current=null] : iv_ruleDECODEPAT= ruleDECODEPAT EOF ;
    public final String entryRuleDECODEPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDECODEPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3601:2: (iv_ruleDECODEPAT= ruleDECODEPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3602:2: iv_ruleDECODEPAT= ruleDECODEPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDECODEPATRule()); 
            }
            pushFollow(FOLLOW_ruleDECODEPAT_in_entryRuleDECODEPAT6979);
            iv_ruleDECODEPAT=ruleDECODEPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDECODEPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDECODEPAT6990); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3609:1: ruleDECODEPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT ) ;
    public final AntlrDatatypeRuleToken ruleDECODEPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_BITPAT_1 = null;

        AntlrDatatypeRuleToken this_TOKPAT_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3612:28: ( ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3613:1: ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3613:1: ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3613:2: (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3613:2: (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3614:2: kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\''
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleDECODEPAT7029); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDECODEPATAccess().getApostropheKeyword_0_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3619:1: (this_BITPAT_1= ruleBITPAT )+
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
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3620:5: this_BITPAT_1= ruleBITPAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getDECODEPATAccess().getBITPATParserRuleCall_0_1()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_ruleBITPAT_in_ruleDECODEPAT7052);
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

                    kw=(Token)match(input,65,FOLLOW_65_in_ruleDECODEPAT7072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDECODEPATAccess().getApostropheKeyword_0_2()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3638:5: this_TOKPAT_3= ruleTOKPAT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDECODEPATAccess().getTOKPATParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTOKPAT_in_ruleDECODEPAT7101);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3656:1: entryRuleTOKPAT returns [String current=null] : iv_ruleTOKPAT= ruleTOKPAT EOF ;
    public final String entryRuleTOKPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTOKPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3657:2: (iv_ruleTOKPAT= ruleTOKPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3658:2: iv_ruleTOKPAT= ruleTOKPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTOKPATRule()); 
            }
            pushFollow(FOLLOW_ruleTOKPAT_in_entryRuleTOKPAT7147);
            iv_ruleTOKPAT=ruleTOKPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTOKPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTOKPAT7158); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3665:1: ruleTOKPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) ) ;
    public final AntlrDatatypeRuleToken ruleTOKPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEXINT_0=null;
        Token this_ID_1=null;
        Token this_S_2=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3668:28: ( (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3669:1: (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3669:1: (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3669:6: this_HEXINT_0= RULE_HEXINT
                    {
                    this_HEXINT_0=(Token)match(input,RULE_HEXINT,FOLLOW_RULE_HEXINT_in_ruleTOKPAT7198); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXINT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEXINT_0, grammarAccess.getTOKPATAccess().getHEXINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3677:6: (this_ID_1= RULE_ID | this_S_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3677:6: (this_ID_1= RULE_ID | this_S_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3677:11: this_ID_1= RULE_ID
                            {
                            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTOKPAT7225); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_ID_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_ID_1, grammarAccess.getTOKPATAccess().getIDTerminalRuleCall_1_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3685:10: this_S_2= RULE_S
                            {
                            this_S_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTOKPAT7251); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3700:1: entryRuleBITPAT returns [String current=null] : iv_ruleBITPAT= ruleBITPAT EOF ;
    public final String entryRuleBITPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3701:2: (iv_ruleBITPAT= ruleBITPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3702:2: iv_ruleBITPAT= ruleBITPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITPATRule()); 
            }
            pushFollow(FOLLOW_ruleBITPAT_in_entryRuleBITPAT7298);
            iv_ruleBITPAT=ruleBITPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITPAT7309); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3709:1: ruleBITPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) ) ;
    public final AntlrDatatypeRuleToken ruleBITPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_1=null;
        Token this_S_2=null;
        AntlrDatatypeRuleToken this_BINARY_0 = null;

        AntlrDatatypeRuleToken this_BITPATORINT_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3712:28: ( (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3713:1: (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3713:1: (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3714:5: this_BINARY_0= ruleBINARY
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATAccess().getBINARYParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBINARY_in_ruleBITPAT7356);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3725:6: ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3725:6: ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3725:7: (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3725:7: (this_ID_1= RULE_ID | this_S_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3725:12: this_ID_1= RULE_ID
                            {
                            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBITPAT7384); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_ID_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_ID_1, grammarAccess.getBITPATAccess().getIDTerminalRuleCall_1_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3733:10: this_S_2= RULE_S
                            {
                            this_S_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleBITPAT7410); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_S_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_S_2, grammarAccess.getBITPATAccess().getSTerminalRuleCall_1_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3740:2: (this_BITPATORINT_3= ruleBITPATORINT )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==27||LA84_0==61) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3741:5: this_BITPATORINT_3= ruleBITPATORINT
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getBITPATAccess().getBITPATORINTParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBITPATORINT_in_ruleBITPAT7439);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3759:1: entryRuleBITPATORINT returns [String current=null] : iv_ruleBITPATORINT= ruleBITPATORINT EOF ;
    public final String entryRuleBITPATORINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITPATORINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3760:2: (iv_ruleBITPATORINT= ruleBITPATORINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3761:2: iv_ruleBITPATORINT= ruleBITPATORINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITPATORINTRule()); 
            }
            pushFollow(FOLLOW_ruleBITPATORINT_in_entryRuleBITPATORINT7488);
            iv_ruleBITPATORINT=ruleBITPATORINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITPATORINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITPATORINT7499); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3768:1: ruleBITPATORINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) ) ;
    public final AntlrDatatypeRuleToken ruleBITPATORINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_POSINT_1 = null;

        AntlrDatatypeRuleToken this_BINARY_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3771:28: ( ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3772:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3772:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3772:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3772:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3773:2: kw= ':' this_POSINT_1= rulePOSINT
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleBITPATORINT7538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBITPATORINTAccess().getColonKeyword_0_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATORINTAccess().getPOSINTParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleBITPATORINT7560);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3790:6: (kw= '@' this_BINARY_3= ruleBINARY )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3790:6: (kw= '@' this_BINARY_3= ruleBINARY )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3791:2: kw= '@' this_BINARY_3= ruleBINARY
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleBITPATORINT7586); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBITPATORINTAccess().getCommercialAtKeyword_1_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATORINTAccess().getBINARYParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBINARY_in_ruleBITPATORINT7608);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3815:1: entryRuleLIT returns [String current=null] : iv_ruleLIT= ruleLIT EOF ;
    public final String entryRuleLIT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLIT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3816:2: (iv_ruleLIT= ruleLIT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3817:2: iv_ruleLIT= ruleLIT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLITRule()); 
            }
            pushFollow(FOLLOW_ruleLIT_in_entryRuleLIT7655);
            iv_ruleLIT=ruleLIT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLIT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLIT7666); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3824:1: ruleLIT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) ) ;
    public final AntlrDatatypeRuleToken ruleLIT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_INTEGER_0 = null;

        AntlrDatatypeRuleToken this_BINARY_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3827:28: ( (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3828:1: (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3828:1: (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3829:5: this_INTEGER_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLITAccess().getINTEGERParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleLIT7713);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3840:6: (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3840:6: (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3841:2: kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\''
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleLIT7738); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLITAccess().getApostropheKeyword_1_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3846:1: (this_BINARY_2= ruleBINARY )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==RULE_BINS||LA87_0==RULE_DOT||LA87_0==RULE_BS||LA87_0==RULE_DUALS) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3847:5: this_BINARY_2= ruleBINARY
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getLITAccess().getBINARYParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBINARY_in_ruleLIT7761);
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

                    kw=(Token)match(input,65,FOLLOW_65_in_ruleLIT7781); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3871:1: entryRuleMID returns [String current=null] : iv_ruleMID= ruleMID EOF ;
    public final String entryRuleMID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3872:2: (iv_ruleMID= ruleMID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3873:2: iv_ruleMID= ruleMID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMIDRule()); 
            }
            pushFollow(FOLLOW_ruleMID_in_entryRuleMID7823);
            iv_ruleMID=ruleMID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMID7834); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3880:1: ruleMID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE ) ;
    public final AntlrDatatypeRuleToken ruleMID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MIXID_0=null;
        Token this_USCORE_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3883:28: ( (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3884:1: (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3884:1: (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3884:6: this_MIXID_0= RULE_MIXID
                    {
                    this_MIXID_0=(Token)match(input,RULE_MIXID,FOLLOW_RULE_MIXID_in_ruleMID7874); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MIXID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_MIXID_0, grammarAccess.getMIDAccess().getMIXIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3892:10: this_USCORE_1= RULE_USCORE
                    {
                    this_USCORE_1=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_ruleMID7900); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3907:1: entryRuleSYM returns [String current=null] : iv_ruleSYM= ruleSYM EOF ;
    public final String entryRuleSYM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSYM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3908:2: (iv_ruleSYM= ruleSYM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3909:2: iv_ruleSYM= ruleSYM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSYMRule()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_entryRuleSYM7946);
            iv_ruleSYM=ruleSYM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSYM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSYM7957); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3916:1: ruleSYM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3919:28: ( (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3920:1: (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3920:1: (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3920:6: this_USCORE_0= RULE_USCORE
                    {
                    this_USCORE_0=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_ruleSYM7997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_USCORE_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_USCORE_0, grammarAccess.getSYMAccess().getUSCORETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3928:10: this_BS_1= RULE_BS
                    {
                    this_BS_1=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleSYM8023); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_1, grammarAccess.getSYMAccess().getBSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3936:10: this_DOT_2= RULE_DOT
                    {
                    this_DOT_2=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSYM8049); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_2, grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3944:10: this_LESS_3= RULE_LESS
                    {
                    this_LESS_3=(Token)match(input,RULE_LESS,FOLLOW_RULE_LESS_in_ruleSYM8075); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LESS_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LESS_3, grammarAccess.getSYMAccess().getLESSTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3952:10: this_GREATER_4= RULE_GREATER
                    {
                    this_GREATER_4=(Token)match(input,RULE_GREATER,FOLLOW_RULE_GREATER_in_ruleSYM8101); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_GREATER_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_GREATER_4, grammarAccess.getSYMAccess().getGREATERTerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3960:10: this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5= RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER
                    {
                    this_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_5=(Token)match(input,RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER,FOLLOW_RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_in_ruleSYM8127); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3975:1: entryRuleINTEGER returns [String current=null] : iv_ruleINTEGER= ruleINTEGER EOF ;
    public final String entryRuleINTEGER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTEGER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3976:2: (iv_ruleINTEGER= ruleINTEGER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3977:2: iv_ruleINTEGER= ruleINTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleINTEGER_in_entryRuleINTEGER8173);
            iv_ruleINTEGER=ruleINTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTEGER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTEGER8184); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3984:1: ruleINTEGER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT ) ;
    public final AntlrDatatypeRuleToken ruleINTEGER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEXINT_1=null;
        Token this_NEGINT_2=null;
        AntlrDatatypeRuleToken this_POSINT_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3987:28: ( (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3988:1: (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3988:1: (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3989:5: this_POSINT_0= rulePOSINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getINTEGERAccess().getPOSINTParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleINTEGER8231);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4000:10: this_HEXINT_1= RULE_HEXINT
                    {
                    this_HEXINT_1=(Token)match(input,RULE_HEXINT,FOLLOW_RULE_HEXINT_in_ruleINTEGER8257); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXINT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEXINT_1, grammarAccess.getINTEGERAccess().getHEXINTTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4008:10: this_NEGINT_2= RULE_NEGINT
                    {
                    this_NEGINT_2=(Token)match(input,RULE_NEGINT,FOLLOW_RULE_NEGINT_in_ruleINTEGER8283); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4023:1: entryRulePOSINT returns [String current=null] : iv_rulePOSINT= rulePOSINT EOF ;
    public final String entryRulePOSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePOSINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4024:2: (iv_rulePOSINT= rulePOSINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4025:2: iv_rulePOSINT= rulePOSINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPOSINTRule()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT8329);
            iv_rulePOSINT=rulePOSINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePOSINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT8340); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4032:1: rulePOSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS ) ;
    public final AntlrDatatypeRuleToken rulePOSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_POSINT_WO_DUALS_0=null;
        Token this_DUALS_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4035:28: ( (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4036:1: (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4036:1: (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4036:6: this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS
                    {
                    this_POSINT_WO_DUALS_0=(Token)match(input,RULE_POSINT_WO_DUALS,FOLLOW_RULE_POSINT_WO_DUALS_in_rulePOSINT8380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_POSINT_WO_DUALS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_POSINT_WO_DUALS_0, grammarAccess.getPOSINTAccess().getPOSINT_WO_DUALSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4044:10: this_DUALS_1= RULE_DUALS
                    {
                    this_DUALS_1=(Token)match(input,RULE_DUALS,FOLLOW_RULE_DUALS_in_rulePOSINT8406); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4059:1: entryRuleBINARY returns [String current=null] : iv_ruleBINARY= ruleBINARY EOF ;
    public final String entryRuleBINARY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBINARY = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4060:2: (iv_ruleBINARY= ruleBINARY EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4061:2: iv_ruleBINARY= ruleBINARY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBINARYRule()); 
            }
            pushFollow(FOLLOW_ruleBINARY_in_entryRuleBINARY8452);
            iv_ruleBINARY=ruleBINARY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBINARY.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBINARY8463); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4068:1: ruleBINARY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT ) ;
    public final AntlrDatatypeRuleToken ruleBINARY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DUALS_0=null;
        Token this_BINS_1=null;
        Token this_BS_2=null;
        Token this_DOT_3=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4071:28: ( (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4072:1: (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4072:1: (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4072:6: this_DUALS_0= RULE_DUALS
                    {
                    this_DUALS_0=(Token)match(input,RULE_DUALS,FOLLOW_RULE_DUALS_in_ruleBINARY8503); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DUALS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DUALS_0, grammarAccess.getBINARYAccess().getDUALSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4080:10: this_BINS_1= RULE_BINS
                    {
                    this_BINS_1=(Token)match(input,RULE_BINS,FOLLOW_RULE_BINS_in_ruleBINARY8529); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINS_1, grammarAccess.getBINARYAccess().getBINSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4088:10: this_BS_2= RULE_BS
                    {
                    this_BS_2=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleBINARY8555); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_2, grammarAccess.getBINARYAccess().getBSTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4096:10: this_DOT_3= RULE_DOT
                    {
                    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleBINARY8581); if (state.failed) return current;
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
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:435:7: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:436:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:436:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:437:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred2_InternalGDSL891);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalGDSL

    // $ANTLR start synpred3_InternalGDSL
    public final void synpred3_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:3: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:4: ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:4: ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:5: ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:424:5: ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) )
        int alt95=2;
        int LA95_0 = input.LA(1);

        if ( ((LA95_0>=RULE_ID && LA95_0<=RULE_S)) ) {
            alt95=1;
        }
        else if ( (LA95_0==RULE_USCORE) && (synpred2_InternalGDSL())) {
            alt95=2;
        }
        else if ( (LA95_0==RULE_BS) && (synpred2_InternalGDSL())) {
            alt95=2;
        }
        else if ( (LA95_0==RULE_DOT) && (synpred2_InternalGDSL())) {
            alt95=2;
        }
        else if ( (LA95_0==RULE_LESS) && (synpred2_InternalGDSL())) {
            alt95=2;
        }
        else if ( (LA95_0==RULE_GREATER) && (synpred2_InternalGDSL())) {
            alt95=2;
        }
        else if ( (LA95_0==RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER) && (synpred2_InternalGDSL())) {
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
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:435:6: ( ( ( ruleSYM ) )=> ( ruleSYM ) )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:435:6: ( ( ( ruleSYM ) )=> ( ruleSYM ) )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:435:7: ( ( ruleSYM ) )=> ( ruleSYM )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:440:1: ( ruleSYM )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:441:1: ruleSYM
                {
                pushFollow(FOLLOW_ruleSYM_in_synpred3_InternalGDSL900);
                ruleSYM();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:443:3: ( ( ( RULE_ID | RULE_S ) ) )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( ((LA96_0>=RULE_ID && LA96_0<=RULE_S)) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:444:1: ( ( RULE_ID | RULE_S ) )
        	    {
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:444:1: ( ( RULE_ID | RULE_S ) )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:445:1: ( RULE_ID | RULE_S )
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

        match(input,29,FOLLOW_29_in_synpred3_InternalGDSL933); if (state.failed) return ;
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:1: ( ( ruleExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:455:1: ( ruleExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:455:1: ( ruleExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:456:1: ruleExp
        {
        pushFollow(FOLLOW_ruleExp_in_synpred3_InternalGDSL940);
        ruleExp();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalGDSL

    // $ANTLR start synpred4_InternalGDSL
    public final void synpred4_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:495:7: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:496:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:496:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:497:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred4_InternalGDSL1008);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalGDSL

    // $ANTLR start synpred5_InternalGDSL
    public final void synpred5_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1989:3: ( ( ruleExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1990:1: ( ruleExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1990:1: ( ruleExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1991:1: ruleExp
        {
        pushFollow(FOLLOW_ruleExp_in_synpred5_InternalGDSL3828);
        ruleExp();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalGDSL

    // $ANTLR start synpred6_InternalGDSL
    public final void synpred6_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2238:3: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2239:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2239:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2240:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred6_InternalGDSL4352);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalGDSL

    // $ANTLR start synpred7_InternalGDSL
    public final void synpred7_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2702:4: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2702:6: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred7_InternalGDSL5347); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalGDSL

    // $ANTLR start synpred8_InternalGDSL
    public final void synpred8_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2874:3: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2874:5: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred8_InternalGDSL5654); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalGDSL

    // $ANTLR start synpred9_InternalGDSL
    public final void synpred9_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3254:3: ( ( ( RULE_ID | RULE_S ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3255:1: ( ( RULE_ID | RULE_S ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3255:1: ( ( RULE_ID | RULE_S ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3256:1: ( RULE_ID | RULE_S )
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
    // $ANTLR end synpred9_InternalGDSL

    // $ANTLR start synpred10_InternalGDSL
    public final void synpred10_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3417:7: ( ( ( ruleINTEGER ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3417:8: ( ( ruleINTEGER ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3417:8: ( ( ruleINTEGER ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:1: ( ruleINTEGER )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3418:1: ( ruleINTEGER )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3419:1: ruleINTEGER
        {
        pushFollow(FOLLOW_ruleINTEGER_in_synpred10_InternalGDSL6634);
        ruleINTEGER();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred10_InternalGDSL

    // $ANTLR start synpred11_InternalGDSL
    public final void synpred11_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3440:7: ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3440:8: ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3440:8: ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3440:9: ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )?
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3440:9: ( ( ( RULE_ID | RULE_S ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3441:1: ( ( RULE_ID | RULE_S ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3441:1: ( ( RULE_ID | RULE_S ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3442:1: ( RULE_ID | RULE_S )
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

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3450:2: ( ( rulePAT ) )?
        int alt97=2;
        int LA97_0 = input.LA(1);

        if ( ((LA97_0>=RULE_ID && LA97_0<=RULE_S)||(LA97_0>=RULE_USCORE && LA97_0<=RULE_HEXINT)||(LA97_0>=RULE_NEGINT && LA97_0<=RULE_DUALS)||LA97_0==65) ) {
            alt97=1;
        }
        switch (alt97) {
            case 1 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3451:1: ( rulePAT )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3451:1: ( rulePAT )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3452:1: rulePAT
                {
                pushFollow(FOLLOW_rulePAT_in_synpred11_InternalGDSL6701);
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
    // $ANTLR end synpred11_InternalGDSL

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
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA46 dfa46 = new DFA46(this);
    static final String DFA8_eotS =
        "\21\uffff";
    static final String DFA8_eofS =
        "\2\uffff\1\13\11\uffff\1\13\4\uffff";
    static final String DFA8_minS =
        "\1\4\1\0\1\4\3\uffff\1\4\5\uffff\1\31\2\uffff\1\4\1\uffff";
    static final String DFA8_maxS =
        "\1\54\1\0\1\54\3\uffff\1\22\5\uffff\1\43\2\uffff\1\7\1\uffff";
    static final String DFA8_acceptS =
        "\3\uffff\1\2\2\1\1\uffff\5\1\1\uffff\2\1\1\uffff\1\1";
    static final String DFA8_specialS =
        "\1\uffff\1\2\1\4\3\uffff\1\3\5\uffff\1\1\2\uffff\1\0\1\uffff}>";
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
            "\1\7\1\10\1\uffff\1\11\1\uffff\1\17\1\12\3\uffff\1\16",
            "",
            "",
            "\1\20\1\15\1\uffff\1\3",
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
                        int LA8_15 = input.LA(1);

                         
                        int index8_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_15==RULE_LESS) ) {s = 3;}

                        else if ( (LA8_15==RULE_ID) && (synpred1_InternalGDSL())) {s = 16;}

                        else if ( (LA8_15==RULE_S) && (synpred1_InternalGDSL())) {s = 13;}

                         
                        input.seek(index8_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_12 = input.LA(1);

                         
                        int index8_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_12==35) && (synpred1_InternalGDSL())) {s = 14;}

                        else if ( (LA8_12==25) && (synpred1_InternalGDSL())) {s = 7;}

                        else if ( (LA8_12==26) && (synpred1_InternalGDSL())) {s = 8;}

                        else if ( (LA8_12==28) && (synpred1_InternalGDSL())) {s = 9;}

                        else if ( (LA8_12==31) && (synpred1_InternalGDSL())) {s = 10;}

                        else if ( (LA8_12==EOF) && (synpred1_InternalGDSL())) {s = 11;}

                        else if ( (LA8_12==30) ) {s = 15;}

                         
                        input.seek(index8_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_1 = input.LA(1);

                         
                        int index8_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalGDSL()) ) {s = 4;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index8_1);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA8_6 = input.LA(1);

                         
                        int index8_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_6==RULE_HEXINT||(LA8_6>=RULE_NEGINT && LA8_6<=RULE_DUALS)) ) {s = 3;}

                        else if ( (LA8_6==RULE_ID) ) {s = 12;}

                        else if ( (LA8_6==RULE_S) && (synpred1_InternalGDSL())) {s = 13;}

                         
                        input.seek(index8_6);
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
            return "424:1: ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )";
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

                        else if ( (LA19_0==RULE_BS) && (synpred3_InternalGDSL())) {s = 4;}

                        else if ( (LA19_0==RULE_DOT) && (synpred3_InternalGDSL())) {s = 5;}

                        else if ( (LA19_0==RULE_LESS) && (synpred3_InternalGDSL())) {s = 6;}

                        else if ( (LA19_0==RULE_GREATER) && (synpred3_InternalGDSL())) {s = 7;}

                        else if ( (LA19_0==RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER) && (synpred3_InternalGDSL())) {s = 8;}

                        else if ( (LA19_0==RULE_MIXID||LA19_0==29) ) {s = 9;}

                         
                        input.seek(index19_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_1 = input.LA(1);

                         
                        int index19_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index19_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_2 = input.LA(1);

                         
                        int index19_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index19_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_3 = input.LA(1);

                         
                        int index19_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 8;}

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
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\1\7\1\10\1\3\1\2";
    static final String DFA32_specialS =
        "\12\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\3\1\7\1\1\5\uffff\1\1\3\uffff\3\1\13\uffff\1\2\5\uffff\3"+
            "\3\1\4\1\uffff\1\5\2\uffff\1\6",
            "",
            "\1\10\7\uffff\1\11\3\uffff\3\11",
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
            return "990:1: ( ( ( (lv_value_0_1= ruleINTEGER | lv_value_0_2= RULE_BINS ) ) ) | (otherlv_1= '|' ( (lv_value_2_0= ruleINTEGER ) ) otherlv_3= '|' ) | (otherlv_4= '|' ( (otherlv_5= RULE_ID ) ) otherlv_6= '|' ) | ( ( ( (otherlv_7= RULE_ID ) ) | ( ( (lv_type_8_1= 'int' | lv_type_8_2= 'string' | lv_type_8_3= 'unit' ) ) ) ) (otherlv_9= '[' ( (lv_tyBind_10_0= ruleTyBind ) ) (otherlv_11= ',' ( (lv_tyBind_12_0= ruleTyBind ) ) )* otherlv_13= ']' )? ) | ( () otherlv_15= '{' ( ( (lv_elements_16_0= ruleTyElement ) ) (otherlv_17= ',' ( (lv_elements_18_0= ruleTyElement ) ) )* )? otherlv_19= '}' ) | (otherlv_20= '(' ( (lv_param_21_0= ruleTy ) ) (otherlv_22= ',' ( (lv_param_23_0= ruleTy ) ) )* otherlv_24= ')' otherlv_25= '->' ( (lv_resType_26_0= ruleTy ) ) ) | ( () otherlv_28= '()' (otherlv_29= '->' ( (lv_resType_30_0= ruleTy ) ) )? ) | (this_S_31= RULE_S ( (lv_r_32_0= ruleTy ) ) this_LESS_33= RULE_LESS ( (lv_in_34_0= ruleTy ) ) otherlv_35= '=>' ( (lv_out_36_0= ruleTy ) ) this_GREATER_37= RULE_GREATER ) )";
        }
    }
    static final String DFA43_eotS =
        "\63\uffff";
    static final String DFA43_eofS =
        "\10\uffff\2\61\51\uffff";
    static final String DFA43_minS =
        "\1\4\7\uffff\2\4\51\uffff";
    static final String DFA43_maxS =
        "\1\101\7\uffff\2\101\51\uffff";
    static final String DFA43_acceptS =
        "\1\uffff\7\1\2\uffff\12\1\1\2\36\1";
    static final String DFA43_specialS =
        "\1\1\7\uffff\1\0\1\2\51\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\10\1\11\3\uffff\1\7\1\uffff\1\23\1\4\1\22\2\uffff\1\5\1\2"+
            "\1\3\24\uffff\1\15\1\uffff\1\14\4\uffff\1\21\1\uffff\1\17\2"+
            "\uffff\1\20\10\uffff\1\1\1\12\1\13\1\16\1\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34\1\35\1\uffff\1\52\1\53\1\33\1\25\1\50\1\30\1\uffff\1"+
            "\51\1\54\1\31\1\26\1\27\6\uffff\1\57\15\uffff\1\41\1\uffff\1"+
            "\40\2\uffff\1\62\2\uffff\1\60\4\uffff\1\24\1\56\1\55\1\46\1"+
            "\47\1\44\1\45\1\43\1\uffff\1\36\1\37\1\42\1\uffff\1\32",
            "\1\34\1\35\1\uffff\1\52\1\53\1\33\1\25\1\50\1\30\1\uffff\1"+
            "\51\1\54\1\31\1\26\1\27\6\uffff\1\57\15\uffff\1\41\1\uffff\1"+
            "\40\2\uffff\1\62\2\uffff\1\60\4\uffff\1\24\1\56\1\55\1\46\1"+
            "\47\1\44\1\45\1\43\1\uffff\1\36\1\37\1\42\1\uffff\1\32",
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
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "1989:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_8 = input.LA(1);

                         
                        int index43_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA43_8==52) ) {s = 20;}

                        else if ( (LA43_8==RULE_DOT) && (synpred5_InternalGDSL())) {s = 21;}

                        else if ( (LA43_8==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 22;}

                        else if ( (LA43_8==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 23;}

                        else if ( (LA43_8==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 24;}

                        else if ( (LA43_8==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 25;}

                        else if ( (LA43_8==65) && (synpred5_InternalGDSL())) {s = 26;}

                        else if ( (LA43_8==RULE_STRING) && (synpred5_InternalGDSL())) {s = 27;}

                        else if ( (LA43_8==RULE_ID) && (synpred5_InternalGDSL())) {s = 28;}

                        else if ( (LA43_8==RULE_S) && (synpred5_InternalGDSL())) {s = 29;}

                        else if ( (LA43_8==61) && (synpred5_InternalGDSL())) {s = 30;}

                        else if ( (LA43_8==62) && (synpred5_InternalGDSL())) {s = 31;}

                        else if ( (LA43_8==41) && (synpred5_InternalGDSL())) {s = 32;}

                        else if ( (LA43_8==39) && (synpred5_InternalGDSL())) {s = 33;}

                        else if ( (LA43_8==63) && (synpred5_InternalGDSL())) {s = 34;}

                        else if ( (LA43_8==59) && (synpred5_InternalGDSL())) {s = 35;}

                        else if ( (LA43_8==57) && (synpred5_InternalGDSL())) {s = 36;}

                        else if ( (LA43_8==58) && (synpred5_InternalGDSL())) {s = 37;}

                        else if ( (LA43_8==55) && (synpred5_InternalGDSL())) {s = 38;}

                        else if ( (LA43_8==56) && (synpred5_InternalGDSL())) {s = 39;}

                        else if ( (LA43_8==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 40;}

                        else if ( (LA43_8==RULE_BS) && (synpred5_InternalGDSL())) {s = 41;}

                        else if ( (LA43_8==RULE_LESS) && (synpred5_InternalGDSL())) {s = 42;}

                        else if ( (LA43_8==RULE_GREATER) && (synpred5_InternalGDSL())) {s = 43;}

                        else if ( (LA43_8==RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER) && (synpred5_InternalGDSL())) {s = 44;}

                        else if ( (LA43_8==54) && (synpred5_InternalGDSL())) {s = 45;}

                        else if ( (LA43_8==53) && (synpred5_InternalGDSL())) {s = 46;}

                        else if ( (LA43_8==25) && (synpred5_InternalGDSL())) {s = 47;}

                        else if ( (LA43_8==47) && (synpred5_InternalGDSL())) {s = 48;}

                        else if ( (LA43_8==EOF) && (synpred5_InternalGDSL())) {s = 49;}

                        else if ( (LA43_8==44) && (synpred5_InternalGDSL())) {s = 50;}

                         
                        input.seek(index43_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA43_0 = input.LA(1);

                         
                        int index43_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA43_0==60) && (synpred5_InternalGDSL())) {s = 1;}

                        else if ( (LA43_0==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA43_0==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA43_0==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA43_0==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA43_0==65) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA43_0==RULE_STRING) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA43_0==RULE_ID) ) {s = 8;}

                        else if ( (LA43_0==RULE_S) ) {s = 9;}

                        else if ( (LA43_0==61) && (synpred5_InternalGDSL())) {s = 10;}

                        else if ( (LA43_0==62) && (synpred5_InternalGDSL())) {s = 11;}

                        else if ( (LA43_0==41) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA43_0==39) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA43_0==63) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA43_0==48) && (synpred5_InternalGDSL())) {s = 15;}

                        else if ( (LA43_0==51) && (synpred5_InternalGDSL())) {s = 16;}

                        else if ( (LA43_0==46) && (synpred5_InternalGDSL())) {s = 17;}

                        else if ( (LA43_0==RULE_MIXID) && (synpred5_InternalGDSL())) {s = 18;}

                        else if ( (LA43_0==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 19;}

                         
                        input.seek(index43_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA43_9 = input.LA(1);

                         
                        int index43_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA43_9==52) ) {s = 20;}

                        else if ( (LA43_9==RULE_DOT) && (synpred5_InternalGDSL())) {s = 21;}

                        else if ( (LA43_9==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 22;}

                        else if ( (LA43_9==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 23;}

                        else if ( (LA43_9==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 24;}

                        else if ( (LA43_9==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 25;}

                        else if ( (LA43_9==65) && (synpred5_InternalGDSL())) {s = 26;}

                        else if ( (LA43_9==RULE_STRING) && (synpred5_InternalGDSL())) {s = 27;}

                        else if ( (LA43_9==RULE_ID) && (synpred5_InternalGDSL())) {s = 28;}

                        else if ( (LA43_9==RULE_S) && (synpred5_InternalGDSL())) {s = 29;}

                        else if ( (LA43_9==61) && (synpred5_InternalGDSL())) {s = 30;}

                        else if ( (LA43_9==62) && (synpred5_InternalGDSL())) {s = 31;}

                        else if ( (LA43_9==41) && (synpred5_InternalGDSL())) {s = 32;}

                        else if ( (LA43_9==39) && (synpred5_InternalGDSL())) {s = 33;}

                        else if ( (LA43_9==63) && (synpred5_InternalGDSL())) {s = 34;}

                        else if ( (LA43_9==59) && (synpred5_InternalGDSL())) {s = 35;}

                        else if ( (LA43_9==57) && (synpred5_InternalGDSL())) {s = 36;}

                        else if ( (LA43_9==58) && (synpred5_InternalGDSL())) {s = 37;}

                        else if ( (LA43_9==55) && (synpred5_InternalGDSL())) {s = 38;}

                        else if ( (LA43_9==56) && (synpred5_InternalGDSL())) {s = 39;}

                        else if ( (LA43_9==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 40;}

                        else if ( (LA43_9==RULE_BS) && (synpred5_InternalGDSL())) {s = 41;}

                        else if ( (LA43_9==RULE_LESS) && (synpred5_InternalGDSL())) {s = 42;}

                        else if ( (LA43_9==RULE_GREATER) && (synpred5_InternalGDSL())) {s = 43;}

                        else if ( (LA43_9==RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER) && (synpred5_InternalGDSL())) {s = 44;}

                        else if ( (LA43_9==54) && (synpred5_InternalGDSL())) {s = 45;}

                        else if ( (LA43_9==53) && (synpred5_InternalGDSL())) {s = 46;}

                        else if ( (LA43_9==25) && (synpred5_InternalGDSL())) {s = 47;}

                        else if ( (LA43_9==47) && (synpred5_InternalGDSL())) {s = 48;}

                        else if ( (LA43_9==EOF) && (synpred5_InternalGDSL())) {s = 49;}

                        else if ( (LA43_9==44) && (synpred5_InternalGDSL())) {s = 50;}

                         
                        input.seek(index43_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
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
            return "()* loopback of 2238:1: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*";
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

                        else if ( (LA46_0==RULE_BS) && (synpred6_InternalGDSL())) {s = 20;}

                        else if ( (LA46_0==RULE_DOT) && (synpred6_InternalGDSL())) {s = 21;}

                        else if ( (LA46_0==RULE_LESS) && (synpred6_InternalGDSL())) {s = 22;}

                        else if ( (LA46_0==RULE_GREATER) && (synpred6_InternalGDSL())) {s = 23;}

                        else if ( (LA46_0==RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER) && (synpred6_InternalGDSL())) {s = 24;}

                         
                        input.seek(index46_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_16 = input.LA(1);

                         
                        int index46_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalGDSL()) ) {s = 24;}

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
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal960 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal980 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleDeclVal1025 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1045 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1065 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1086 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_ruleDeclVal1138 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1157 = new BitSet(new long[]{0x0000000020002800L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1177 = new BitSet(new long[]{0x0000000020002800L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1199 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1247 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1267 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleDeclVal1287 = new BitSet(new long[]{0x0000000200001030L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECODEPAT_in_ruleDeclVal1308 = new BitSet(new long[]{0x0000000200001030L,0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleDeclVal1321 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1335 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDeclVal1376 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1397 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1409 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1430 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleTyVars_in_entryRuleTyVars1471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyVars1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleTyVars1518 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyVar_in_ruleTyVars1539 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleTyVars1552 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyVar_in_ruleTyVars1573 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleTyVars1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyVar_in_entryRuleTyVar1623 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyVar1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyVar1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTyVar1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl1739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConDecl1795 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleConDecl1808 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleConDecl1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy1867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleTy1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINS_in_ruleTy1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTy1967 = new BitSet(new long[]{0x0000000000071000L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleTy1988 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTy2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTy2020 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTy2040 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTy2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTy2081 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_36_in_ruleTy2107 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_37_in_ruleTy2136 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_38_in_ruleTy2165 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleTy2195 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2216 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleTy2229 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2250 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleTy2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleTy2295 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2317 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_34_in_ruleTy2330 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2351 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_40_in_ruleTy2367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleTy2387 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2408 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_34_in_ruleTy2421 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2442 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_42_in_ruleTy2456 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleTy2468 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleTy2518 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleTy2531 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTy2573 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2593 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_LESS_in_ruleTy2604 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2624 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleTy2636 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2657 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_GREATER_in_ruleTy2668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind2704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyBind2758 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTyBind2778 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleTyBind2799 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyBind2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement2858 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement2868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyElement2912 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTyElement2932 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleTyElement2952 = new BitSet(new long[]{0x000012F040071070L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyElement2973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp3009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_ruleExp3093 = new BitSet(new long[]{0xF009428000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp3114 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_ruleCaseExp_in_entryRuleCaseExp3152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseExp3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleCaseExp3233 = new BitSet(new long[]{0xF009028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp3267 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleCaseExp3279 = new BitSet(new long[]{0x0000000000071830L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_ruleCaseExp3301 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleCaseExp3313 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCaseExp3334 = new BitSet(new long[]{0x0000800040000000L});
    public static final BitSet FOLLOW_30_in_ruleCaseExp3347 = new BitSet(new long[]{0x0000000000071830L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_ruleCaseExp3368 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleCaseExp3380 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCaseExp3401 = new BitSet(new long[]{0x0000800040000000L});
    public static final BitSet FOLLOW_47_in_ruleCaseExp3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_entryRuleClosedExp3453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedExp3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_ruleClosedExp3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleClosedExp3534 = new BitSet(new long[]{0xF009428000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3568 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleClosedExp3580 = new BitSet(new long[]{0xF009428000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3601 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleClosedExp3613 = new BitSet(new long[]{0xF009428000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleClosedExp3660 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3694 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_25_in_ruleClosedExp3707 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3728 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_47_in_ruleClosedExp3742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3779 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonadicExp3789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonadicExp3871 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleMonadicExp3891 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleMonadicExp3911 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrElseExp3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp4026 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOrElseExp4053 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp4087 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp4125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndAlsoExp4135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp4182 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_ruleAndAlsoExp4209 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp4243 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_entryRuleRExp4281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRExp4291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp4338 = new BitSet(new long[]{0x000000000000CDB2L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleRExp4369 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp4390 = new BitSet(new long[]{0x000000000000CDB2L});
    public static final BitSet FOLLOW_ruleAExp_in_entryRuleAExp4428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExp4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4485 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_55_in_ruleAExp4505 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleAExp4534 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4571 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_entryRuleMExp4609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMExp4619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectExp_in_ruleMExp4666 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_57_in_ruleMExp4686 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleMExp4715 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleMExp4752 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleSelectExp_in_entryRuleSelectExp4790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectExp4800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleSelectExp4847 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleSelectExp4859 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleSelectExp4880 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_entryRuleApplyExp4918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleApplyExp4928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleApplyExp4966 = new BitSet(new long[]{0xF000028000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleApplyExp4988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleApplyExp5016 = new BitSet(new long[]{0xF000128000071230L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgs_in_ruleApplyExp5037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgs_in_entryRuleArgs5074 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgs5084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleArgs5140 = new BitSet(new long[]{0xF000028000071232L,0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleArgs5159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp5196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicExp5206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLIT_in_ruleAtomicExp5252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAtomicExp5275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5306 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5326 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp5352 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5371 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5391 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_61_in_ruleAtomicExp5427 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleAtomicExp5452 = new BitSet(new long[]{0x1000000000000030L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp5473 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExp5486 = new BitSet(new long[]{0x1000000000000030L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp5507 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_40_in_ruleAtomicExp5521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleAtomicExp5541 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleAtomicExp5608 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5629 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleAtomicExp5641 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp5659 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5678 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5698 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_39_in_ruleAtomicExp5737 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5757 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5777 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAtomicExp5797 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5818 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExp5831 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5850 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5870 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAtomicExp5890 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5911 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_40_in_ruleAtomicExp5927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAtomicExp5953 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleValueDecl_in_ruleAtomicExp5987 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleAtomicExp6000 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp6021 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleAtomicExp6033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleField_in_entryRuleField6070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleField6080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleField6125 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleField6145 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleField6165 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleField6186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleField6206 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleField6225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleField6245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueDecl_in_entryRuleValueDecl6290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueDecl6300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleValueDecl6337 = new BitSet(new long[]{0x000000000000CDB0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueDecl6383 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleValueDecl6403 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleValueDecl6438 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueDecl6458 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleValueDecl6478 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_29_in_ruleValueDecl6499 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleValueDecl6520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_entryRulePAT6556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePAT6566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_rulePAT6608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_rulePAT6653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePAT6721 = new BitSet(new long[]{0x0000000000071832L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_rulePAT6741 = new BitSet(new long[]{0x0000000000071832L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_rulePAT6770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rulePAT6792 = new BitSet(new long[]{0x0000000000044470L});
    public static final BitSet FOLLOW_ruleBITPAT_in_rulePAT6813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rulePAT6825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS6862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS6872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCONS6915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleCONS6935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECODEPAT_in_entryRuleDECODEPAT6979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDECODEPAT6990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleDECODEPAT7029 = new BitSet(new long[]{0x0000000000044470L});
    public static final BitSet FOLLOW_ruleBITPAT_in_ruleDECODEPAT7052 = new BitSet(new long[]{0x0000000000044470L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleDECODEPAT7072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTOKPAT_in_ruleDECODEPAT7101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTOKPAT_in_entryRuleTOKPAT7147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTOKPAT7158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXINT_in_ruleTOKPAT7198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTOKPAT7225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTOKPAT7251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITPAT_in_entryRuleBITPAT7298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITPAT7309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITPAT7356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBITPAT7384 = new BitSet(new long[]{0x2000000008000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleBITPAT7410 = new BitSet(new long[]{0x2000000008000002L});
    public static final BitSet FOLLOW_ruleBITPATORINT_in_ruleBITPAT7439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITPATORINT_in_entryRuleBITPATORINT7488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITPATORINT7499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleBITPATORINT7538 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleBITPATORINT7560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleBITPATORINT7586 = new BitSet(new long[]{0x0000000000044440L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITPATORINT7608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLIT_in_entryRuleLIT7655 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLIT7666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleLIT7713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLIT7738 = new BitSet(new long[]{0x0000000000044440L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleLIT7761 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLIT7781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_entryRuleMID7823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMID7834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIXID_in_ruleMID7874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_ruleMID7900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_entryRuleSYM7946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSYM7957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_ruleSYM7997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleSYM8023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSYM8049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LESS_in_ruleSYM8075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_GREATER_in_ruleSYM8101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER_in_ruleSYM8127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_entryRuleINTEGER8173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTEGER8184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleINTEGER8231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXINT_in_ruleINTEGER8257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEGINT_in_ruleINTEGER8283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT8329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT8340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_POSINT_WO_DUALS_in_rulePOSINT8380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DUALS_in_rulePOSINT8406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_entryRuleBINARY8452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBINARY8463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DUALS_in_ruleBINARY8503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINS_in_ruleBINARY8529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleBINARY8555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleBINARY8581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_synpred1_InternalGDSL655 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_synpred1_InternalGDSL662 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleConDecl_in_synpred1_InternalGDSL669 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred2_InternalGDSL891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred3_InternalGDSL859 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred3_InternalGDSL900 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_set_in_synpred3_InternalGDSL910 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_29_in_synpred3_InternalGDSL933 = new BitSet(new long[]{0xF009428000073A30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_synpred3_InternalGDSL940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred4_InternalGDSL1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_synpred5_InternalGDSL3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred6_InternalGDSL4352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred7_InternalGDSL5347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred8_InternalGDSL5654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred9_InternalGDSL6352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_synpred10_InternalGDSL6634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred11_InternalGDSL6676 = new BitSet(new long[]{0x0000000000071832L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_synpred11_InternalGDSL6701 = new BitSet(new long[]{0x0000000000000002L});

}