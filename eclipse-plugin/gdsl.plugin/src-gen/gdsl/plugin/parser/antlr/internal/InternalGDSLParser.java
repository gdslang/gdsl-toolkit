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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_S", "RULE_LESS", "RULE_GREATER", "RULE_STRING", "RULE_DOT", "RULE_HEXINT", "RULE_USCORE", "RULE_ID_WO_CONS", "RULE_SLASH", "RULE_MIXID", "RULE_BS", "RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER", "RULE_NEGINT", "RULE_POSINT_WO_DUALS", "RULE_DUALS", "RULE_BINS", "RULE_CONS_WO_S", "RULE_CHARSYM", "RULE_OTHERSYM", "RULE_IDCHAR", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "';'", "'export'", "':'", "'type'", "'='", "'|'", "'val'", "'['", "']'", "','", "'of'", "'int'", "'string'", "'unit'", "'{'", "'}'", "'('", "')'", "'->'", "'()'", "'=>'", "'case'", "'end'", "'if'", "'then'", "'else'", "'do'", "'<-'", "'or'", "'and'", "'+'", "'-'", "'*'", "'%'", "'^'", "'~'", "'@'", "'$'", "'let'", "'in'", "'\\''"
    };
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER=15;
    public static final int RULE_CONS_WO_S=20;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int RULE_DOT=8;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_IDCHAR=23;
    public static final int T__59=59;
    public static final int RULE_S=4;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int RULE_GREATER=6;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_USCORE=10;
    public static final int RULE_SL_COMMENT=26;
    public static final int RULE_HEXINT=9;
    public static final int RULE_ML_COMMENT=25;
    public static final int RULE_BS=14;
    public static final int RULE_BINS=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=7;
    public static final int T__32=32;
    public static final int RULE_MIXID=13;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int RULE_ID_WO_CONS=11;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_OTHERSYM=22;
    public static final int T__39=39;
    public static final int RULE_NEGINT=16;
    public static final int RULE_DUALS=18;
    public static final int RULE_LESS=5;
    public static final int RULE_SLASH=12;
    public static final int RULE_CHARSYM=21;
    public static final int RULE_WS=24;
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

                if ( ((LA2_0>=27 && LA2_0<=28)||LA2_0==30||LA2_0==33) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )? ( (lv_decl_2_0= ruleDecl ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:3: (otherlv_1= ';' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==27) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:98:5: otherlv_1= ';'
            	            {
            	            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleModel145); if (state.failed) return current;
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
            case 28:
                {
                alt3=1;
                }
                break;
            case 30:
                {
                alt3=2;
                }
                break;
            case 33:
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:187:1: ruleDeclExport returns [EObject current=null] : (otherlv_0= 'export' ( ( ruleID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) ) ) ;
    public final EObject ruleDeclExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_tyVars_2_0 = null;

        EObject lv_type_4_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:190:28: ( (otherlv_0= 'export' ( ( ruleID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:191:1: (otherlv_0= 'export' ( ( ruleID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:191:1: (otherlv_0= 'export' ( ( ruleID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:191:3: otherlv_0= 'export' ( ( ruleID ) ) ( (lv_tyVars_2_0= ruleTyVars ) )? otherlv_3= ':' ( (lv_type_4_0= ruleTy ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleDeclExport399); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeclExportAccess().getExportKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:195:1: ( ( ruleID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:196:1: ( ruleID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:196:1: ( ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:197:3: ruleID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getDeclExportRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclExportAccess().getNameDeclValCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleID_in_ruleDeclExport422);
            ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:210:2: ( (lv_tyVars_2_0= ruleTyVars ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==34) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:211:1: (lv_tyVars_2_0= ruleTyVars )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:211:1: (lv_tyVars_2_0= ruleTyVars )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:212:3: lv_tyVars_2_0= ruleTyVars
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclExportAccess().getTyVarsTyVarsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTyVars_in_ruleDeclExport443);
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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleDeclExport456); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDeclExportAccess().getColonKeyword_3());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:232:1: ( (lv_type_4_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:233:1: (lv_type_4_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:233:1: (lv_type_4_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:234:3: lv_type_4_0= ruleTy
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclExportAccess().getTypeTyParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTy_in_ruleDeclExport477);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:258:1: entryRuleDeclType returns [EObject current=null] : iv_ruleDeclType= ruleDeclType EOF ;
    public final EObject entryRuleDeclType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclType = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:259:2: (iv_ruleDeclType= ruleDeclType EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:260:2: iv_ruleDeclType= ruleDeclType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDeclType_in_entryRuleDeclType513);
            iv_ruleDeclType=ruleDeclType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclType523); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:267:1: ruleDeclType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= ruleID ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) ) ) ;
    public final EObject ruleDeclType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_conDecl_3_0 = null;

        EObject lv_conDecl_5_0 = null;

        EObject lv_value_6_0 = null;

        EObject lv_tyVars_7_0 = null;

        EObject lv_conDecl_9_0 = null;

        EObject lv_conDecl_11_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:270:28: ( (otherlv_0= 'type' ( (lv_name_1_0= ruleID ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:271:1: (otherlv_0= 'type' ( (lv_name_1_0= ruleID ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:271:1: (otherlv_0= 'type' ( (lv_name_1_0= ruleID ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:271:3: otherlv_0= 'type' ( (lv_name_1_0= ruleID ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleDeclType560); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeclTypeAccess().getTypeKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:275:1: ( (lv_name_1_0= ruleID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:276:1: (lv_name_1_0= ruleID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:276:1: (lv_name_1_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:277:3: lv_name_1_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclTypeAccess().getNameIDParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleID_in_ruleDeclType581);
            lv_name_1_0=ruleID();

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
                      		"ID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:293:2: ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==31) ) {
                alt8=1;
            }
            else if ( (LA8_0==34) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:293:3: (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:293:3: (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:293:5: otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleDeclType595); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_0_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:297:1: ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) )
                    int alt6=2;
                    switch ( input.LA(1) ) {
                    case RULE_S:
                        {
                        int LA6_1 = input.LA(2);

                        if ( (synpred1_InternalGDSL()) ) {
                            alt6=1;
                        }
                        else if ( (true) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_CONS_WO_S:
                        {
                        int LA6_2 = input.LA(2);

                        if ( (synpred1_InternalGDSL()) ) {
                            alt6=1;
                        }
                        else if ( (true) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_HEXINT:
                    case RULE_ID_WO_CONS:
                    case RULE_SLASH:
                    case RULE_NEGINT:
                    case RULE_POSINT_WO_DUALS:
                    case RULE_DUALS:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 43:
                    case 46:
                        {
                        alt6=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }

                    switch (alt6) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:297:2: ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:297:2: ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:297:3: ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:306:8: ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:306:9: ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:306:9: ( (lv_conDecl_3_0= ruleConDecl ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:307:1: (lv_conDecl_3_0= ruleConDecl )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:307:1: (lv_conDecl_3_0= ruleConDecl )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:308:3: lv_conDecl_3_0= ruleConDecl
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_2_0_1_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType649);
                            lv_conDecl_3_0=ruleConDecl();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"conDecl",
                                      		lv_conDecl_3_0, 
                                      		"ConDecl");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:324:2: (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==32) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:324:4: otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) )
                            	    {
                            	    otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleDeclType662); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_4, grammarAccess.getDeclTypeAccess().getVerticalLineKeyword_2_0_1_0_0_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:328:1: ( (lv_conDecl_5_0= ruleConDecl ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:329:1: (lv_conDecl_5_0= ruleConDecl )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:329:1: (lv_conDecl_5_0= ruleConDecl )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:330:3: lv_conDecl_5_0= ruleConDecl
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_2_0_1_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType683);
                            	    lv_conDecl_5_0=ruleConDecl();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"conDecl",
                            	              		lv_conDecl_5_0, 
                            	              		"ConDecl");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop5;
                                }
                            } while (true);


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:347:6: ( (lv_value_6_0= ruleTy ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:347:6: ( (lv_value_6_0= ruleTy ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:348:1: (lv_value_6_0= ruleTy )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:348:1: (lv_value_6_0= ruleTy )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:349:3: lv_value_6_0= ruleTy
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_2_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTy_in_ruleDeclType714);
                            lv_value_6_0=ruleTy();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"value",
                                      		lv_value_6_0, 
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
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:366:6: ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:366:6: ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:366:7: ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:366:7: ( (lv_tyVars_7_0= ruleTyVars ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:367:1: (lv_tyVars_7_0= ruleTyVars )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:367:1: (lv_tyVars_7_0= ruleTyVars )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:368:3: lv_tyVars_7_0= ruleTyVars
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getTyVarsTyVarsParserRuleCall_2_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTyVars_in_ruleDeclType744);
                    lv_tyVars_7_0=ruleTyVars();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"tyVars",
                              		lv_tyVars_7_0, 
                              		"TyVars");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,31,FOLLOW_31_in_ruleDeclType756); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:388:1: ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:388:2: ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:388:2: ( (lv_conDecl_9_0= ruleConDecl ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:389:1: (lv_conDecl_9_0= ruleConDecl )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:389:1: (lv_conDecl_9_0= ruleConDecl )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:390:3: lv_conDecl_9_0= ruleConDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_2_1_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType778);
                    lv_conDecl_9_0=ruleConDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"conDecl",
                              		lv_conDecl_9_0, 
                              		"ConDecl");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:406:2: (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==32) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:406:4: otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) )
                    	    {
                    	    otherlv_10=(Token)match(input,32,FOLLOW_32_in_ruleDeclType791); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getDeclTypeAccess().getVerticalLineKeyword_2_1_2_1_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:410:1: ( (lv_conDecl_11_0= ruleConDecl ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:411:1: (lv_conDecl_11_0= ruleConDecl )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:411:1: (lv_conDecl_11_0= ruleConDecl )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:412:3: lv_conDecl_11_0= ruleConDecl
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_2_1_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType812);
                    	    lv_conDecl_11_0=ruleConDecl();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeclTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"conDecl",
                    	              		lv_conDecl_11_0, 
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:436:1: entryRuleDeclVal returns [EObject current=null] : iv_ruleDeclVal= ruleDeclVal EOF ;
    public final EObject entryRuleDeclVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclVal = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:437:2: (iv_ruleDeclVal= ruleDeclVal EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:438:2: iv_ruleDeclVal= ruleDeclVal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclValRule()); 
            }
            pushFollow(FOLLOW_ruleDeclVal_in_entryRuleDeclVal853);
            iv_ruleDeclVal=ruleDeclVal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclVal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclVal863); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:445:1: ruleDeclVal returns [EObject current=null] : (otherlv_0= 'val' ( ( ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) ) ;
    public final EObject ruleDeclVal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_attr_3_0 = null;

        EObject lv_exp_5_0 = null;

        AntlrDatatypeRuleToken lv_mid_6_0 = null;

        AntlrDatatypeRuleToken lv_attr_7_0 = null;

        EObject lv_exp_9_0 = null;

        AntlrDatatypeRuleToken lv_name_10_0 = null;

        AntlrDatatypeRuleToken lv_decPat_12_0 = null;

        EObject lv_exp_15_0 = null;

        EObject lv_exps_17_0 = null;

        EObject lv_exps_19_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:448:28: ( (otherlv_0= 'val' ( ( ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:449:1: (otherlv_0= 'val' ( ( ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:449:1: (otherlv_0= 'val' ( ( ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:449:3: otherlv_0= 'val' ( ( ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleDeclVal900); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeclValAccess().getValKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:1: ( ( ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )
            int alt15=3;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:2: ( ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:2: ( ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:3: ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:475:6: ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:475:7: ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:475:7: ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==RULE_S||LA9_0==RULE_ID_WO_CONS||LA9_0==RULE_CONS_WO_S) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==RULE_SLASH) ) {
                        int LA9_2 = input.LA(2);

                        if ( (true) ) {
                            alt9=1;
                        }
                        else if ( (synpred4_InternalGDSL()) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 2, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA9_0==RULE_USCORE) && (synpred4_InternalGDSL())) {
                        alt9=2;
                    }
                    else if ( (LA9_0==RULE_BS) && (synpred4_InternalGDSL())) {
                        alt9=2;
                    }
                    else if ( (LA9_0==RULE_DOT) && (synpred4_InternalGDSL())) {
                        alt9=2;
                    }
                    else if ( (LA9_0==RULE_LESS) && (synpred4_InternalGDSL())) {
                        alt9=2;
                    }
                    else if ( (LA9_0==RULE_GREATER) && (synpred4_InternalGDSL())) {
                        alt9=2;
                    }
                    else if ( (LA9_0==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred4_InternalGDSL())) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:475:8: ( (lv_name_1_0= ruleID ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:475:8: ( (lv_name_1_0= ruleID ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:1: (lv_name_1_0= ruleID )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:476:1: (lv_name_1_0= ruleID )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:477:3: lv_name_1_0= ruleID
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getNameIDParserRuleCall_1_0_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleID_in_ruleDeclVal989);
                            lv_name_1_0=ruleID();

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
                                      		"ID");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:494:6: ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:494:6: ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:494:7: ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:499:1: (lv_name_2_0= ruleSYM )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:500:3: lv_name_2_0= ruleSYM
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getNameSYMParserRuleCall_1_0_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleSYM_in_ruleDeclVal1026);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:516:3: ( (lv_attr_3_0= ruleID ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_S||(LA10_0>=RULE_ID_WO_CONS && LA10_0<=RULE_SLASH)||LA10_0==RULE_CONS_WO_S) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:517:1: (lv_attr_3_0= ruleID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:517:1: (lv_attr_3_0= ruleID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:518:3: lv_attr_3_0= ruleID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getAttrIDParserRuleCall_1_0_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleID_in_ruleDeclVal1048);
                    	    lv_attr_3_0=ruleID();

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
                    	              		"ID");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleDeclVal1061); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_0_0_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:538:1: ( (lv_exp_5_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:539:1: (lv_exp_5_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:539:1: (lv_exp_5_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:540:3: lv_exp_5_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_0_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1082);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:557:6: ( ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:557:6: ( ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:557:7: ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:557:7: ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_USCORE||LA11_0==RULE_MIXID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:557:8: ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:557:8: ( (lv_mid_6_0= ruleMID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:558:1: (lv_mid_6_0= ruleMID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:558:1: (lv_mid_6_0= ruleMID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:559:3: lv_mid_6_0= ruleMID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getMidMIDParserRuleCall_1_1_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMID_in_ruleDeclVal1113);
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

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:575:2: ( (lv_attr_7_0= ruleID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:576:1: (lv_attr_7_0= ruleID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:576:1: (lv_attr_7_0= ruleID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:577:3: lv_attr_7_0= ruleID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getAttrIDParserRuleCall_1_1_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleID_in_ruleDeclVal1134);
                    	    lv_attr_7_0=ruleID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"attr",
                    	              		lv_attr_7_0, 
                    	              		"ID");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,31,FOLLOW_31_in_ruleDeclVal1148); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:597:1: ( (lv_exp_9_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:598:1: (lv_exp_9_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:598:1: (lv_exp_9_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:599:3: lv_exp_9_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1169);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:616:6: ( ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:616:6: ( ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:616:7: ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:616:7: ( (lv_name_10_0= ruleID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:617:1: (lv_name_10_0= ruleID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:617:1: (lv_name_10_0= ruleID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:618:3: lv_name_10_0= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getNameIDParserRuleCall_1_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleID_in_ruleDeclVal1198);
                    lv_name_10_0=ruleID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclValRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_10_0, 
                              		"ID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_11=(Token)match(input,34,FOLLOW_34_in_ruleDeclVal1210); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:638:1: ( (lv_decPat_12_0= ruleDECODEPAT ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_S||LA12_0==RULE_HEXINT||(LA12_0>=RULE_ID_WO_CONS && LA12_0<=RULE_SLASH)||LA12_0==RULE_CONS_WO_S||LA12_0==67) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:639:1: (lv_decPat_12_0= ruleDECODEPAT )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:639:1: (lv_decPat_12_0= ruleDECODEPAT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:640:3: lv_decPat_12_0= ruleDECODEPAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getDecPatDECODEPATParserRuleCall_1_2_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleDECODEPAT_in_ruleDeclVal1231);
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
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,35,FOLLOW_35_in_ruleDeclVal1244); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_2_3());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:660:1: ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==31) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==32) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:660:2: (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:660:2: (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:660:4: otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) )
                            {
                            otherlv_14=(Token)match(input,31,FOLLOW_31_in_ruleDeclVal1258); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_2_4_0_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:664:1: ( (lv_exp_15_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:665:1: (lv_exp_15_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:665:1: (lv_exp_15_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:666:3: lv_exp_15_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_2_4_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1279);
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:683:6: (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:683:6: (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==32) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:683:8: otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) )
                            	    {
                            	    otherlv_16=(Token)match(input,32,FOLLOW_32_in_ruleDeclVal1299); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_16, grammarAccess.getDeclValAccess().getVerticalLineKeyword_1_2_4_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:687:1: ( (lv_exps_17_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:688:1: (lv_exps_17_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:688:1: (lv_exps_17_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:689:3: lv_exps_17_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_2_4_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1320);
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

                            	    otherlv_18=(Token)match(input,31,FOLLOW_31_in_ruleDeclVal1332); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_18, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_2_4_1_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:709:1: ( (lv_exps_19_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:710:1: (lv_exps_19_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:710:1: (lv_exps_19_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:711:3: lv_exps_19_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_2_4_1_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1353);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:735:1: entryRuleTyVars returns [EObject current=null] : iv_ruleTyVars= ruleTyVars EOF ;
    public final EObject entryRuleTyVars() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyVars = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:736:2: (iv_ruleTyVars= ruleTyVars EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:737:2: iv_ruleTyVars= ruleTyVars EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyVarsRule()); 
            }
            pushFollow(FOLLOW_ruleTyVars_in_entryRuleTyVars1394);
            iv_ruleTyVars=ruleTyVars();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyVars; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyVars1404); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:744:1: ruleTyVars returns [EObject current=null] : (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleTyVars() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attr_1_0 = null;

        EObject lv_attr_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:747:28: ( (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:748:1: (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:748:1: (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:748:3: otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleTyVars1441); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTyVarsAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:752:1: ( (lv_attr_1_0= ruleTyVar ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:753:1: (lv_attr_1_0= ruleTyVar )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:753:1: (lv_attr_1_0= ruleTyVar )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:754:3: lv_attr_1_0= ruleTyVar
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyVarsAccess().getAttrTyVarParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTyVar_in_ruleTyVars1462);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:770:2: (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==36) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:770:4: otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) )
            	    {
            	    otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleTyVars1475); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTyVarsAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:774:1: ( (lv_attr_3_0= ruleTyVar ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:775:1: (lv_attr_3_0= ruleTyVar )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:775:1: (lv_attr_3_0= ruleTyVar )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:776:3: lv_attr_3_0= ruleTyVar
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTyVarsAccess().getAttrTyVarParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTyVar_in_ruleTyVars1496);
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
            	    break loop16;
                }
            } while (true);

            otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleTyVars1510); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:804:1: entryRuleTyVar returns [EObject current=null] : iv_ruleTyVar= ruleTyVar EOF ;
    public final EObject entryRuleTyVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyVar = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:805:2: (iv_ruleTyVar= ruleTyVar EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:806:2: iv_ruleTyVar= ruleTyVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyVarRule()); 
            }
            pushFollow(FOLLOW_ruleTyVar_in_entryRuleTyVar1546);
            iv_ruleTyVar=ruleTyVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyVar1556); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:813:1: ruleTyVar returns [EObject current=null] : ( (lv_name_0_0= ruleID ) ) ;
    public final EObject ruleTyVar() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:816:28: ( ( (lv_name_0_0= ruleID ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:817:1: ( (lv_name_0_0= ruleID ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:817:1: ( (lv_name_0_0= ruleID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:818:1: (lv_name_0_0= ruleID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:818:1: (lv_name_0_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:819:3: lv_name_0_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyVarAccess().getNameIDParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleID_in_ruleTyVar1601);
            lv_name_0_0=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTyVarRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	        afterParserOrEnumRuleCall();
              	    
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:843:1: entryRuleConDecl returns [EObject current=null] : iv_ruleConDecl= ruleConDecl EOF ;
    public final EObject entryRuleConDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:844:2: (iv_ruleConDecl= ruleConDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:845:2: iv_ruleConDecl= ruleConDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConDeclRule()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl1636);
            iv_ruleConDecl=ruleConDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl1646); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:852:1: ruleConDecl returns [EObject current=null] : ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleConDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ty_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:855:28: ( ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:856:1: ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:856:1: ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:856:2: ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:856:2: ( (lv_name_0_0= ruleCONS ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:857:1: (lv_name_0_0= ruleCONS )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:857:1: (lv_name_0_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:858:3: lv_name_0_0= ruleCONS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConDeclAccess().getNameCONSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConDecl1692);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:874:2: (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==37) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:874:4: otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleConDecl1705); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConDeclAccess().getOfKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:878:1: ( (lv_ty_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:879:1: (lv_ty_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:879:1: (lv_ty_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:880:3: lv_ty_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleConDecl1726);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:904:1: entryRuleTy returns [EObject current=null] : iv_ruleTy= ruleTy EOF ;
    public final EObject entryRuleTy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTy = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:905:2: (iv_ruleTy= ruleTy EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:906:2: iv_ruleTy= ruleTy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyRule()); 
            }
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy1764);
            iv_ruleTy=ruleTy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTy; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy1774); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:913:1: ruleTy returns [EObject current=null] : ( ( (lv_value_0_0= ruleINTEGER ) ) | ( ( ( ( ruleID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? ) | ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' ) | (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) ) | ( () otherlv_22= '()' ) | (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER ) ) ;
    public final EObject ruleTy() throws RecognitionException {
        EObject current = null;

        Token lv_type_2_1=null;
        Token lv_type_2_2=null;
        Token lv_type_2_3=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_22=null;
        Token this_S_23=null;
        Token this_LESS_25=null;
        Token otherlv_27=null;
        Token this_GREATER_29=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;

        EObject lv_tyBind_4_0 = null;

        EObject lv_tyBind_6_0 = null;

        EObject lv_elements_10_0 = null;

        EObject lv_elements_12_0 = null;

        EObject lv_param_15_0 = null;

        EObject lv_param_17_0 = null;

        EObject lv_resType_20_0 = null;

        EObject lv_r_24_0 = null;

        EObject lv_in_26_0 = null;

        EObject lv_out_28_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:916:28: ( ( ( (lv_value_0_0= ruleINTEGER ) ) | ( ( ( ( ruleID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? ) | ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' ) | (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) ) | ( () otherlv_22= '()' ) | (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:917:1: ( ( (lv_value_0_0= ruleINTEGER ) ) | ( ( ( ( ruleID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? ) | ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' ) | (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) ) | ( () otherlv_22= '()' ) | (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:917:1: ( ( (lv_value_0_0= ruleINTEGER ) ) | ( ( ( ( ruleID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? ) | ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' ) | (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) ) | ( () otherlv_22= '()' ) | (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER ) )
            int alt25=6;
            switch ( input.LA(1) ) {
            case RULE_HEXINT:
            case RULE_NEGINT:
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
                {
                alt25=1;
                }
                break;
            case RULE_S:
                {
                int LA25_2 = input.LA(2);

                if ( (LA25_2==EOF||(LA25_2>=RULE_LESS && LA25_2<=RULE_GREATER)||(LA25_2>=27 && LA25_2<=28)||LA25_2==30||(LA25_2>=32 && LA25_2<=36)||LA25_2==42||LA25_2==44||LA25_2==47) ) {
                    alt25=2;
                }
                else if ( (LA25_2==RULE_S||LA25_2==RULE_HEXINT||(LA25_2>=RULE_ID_WO_CONS && LA25_2<=RULE_SLASH)||(LA25_2>=RULE_NEGINT && LA25_2<=RULE_DUALS)||LA25_2==RULE_CONS_WO_S||(LA25_2>=38 && LA25_2<=41)||LA25_2==43||LA25_2==46) ) {
                    alt25=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID_WO_CONS:
            case RULE_SLASH:
            case RULE_CONS_WO_S:
            case 38:
            case 39:
            case 40:
                {
                alt25=2;
                }
                break;
            case 41:
                {
                alt25=3;
                }
                break;
            case 43:
                {
                alt25=4;
                }
                break;
            case 46:
                {
                alt25=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:917:2: ( (lv_value_0_0= ruleINTEGER ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:917:2: ( (lv_value_0_0= ruleINTEGER ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:918:1: (lv_value_0_0= ruleINTEGER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:918:1: (lv_value_0_0= ruleINTEGER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:919:3: lv_value_0_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueINTEGERParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleTy1820);
                    lv_value_0_0=ruleINTEGER();

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
                              		"INTEGER");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:936:6: ( ( ( ( ruleID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:936:6: ( ( ( ( ruleID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:936:7: ( ( ( ruleID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:936:7: ( ( ( ruleID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_S||(LA19_0>=RULE_ID_WO_CONS && LA19_0<=RULE_SLASH)||LA19_0==RULE_CONS_WO_S) ) {
                        alt19=1;
                    }
                    else if ( ((LA19_0>=38 && LA19_0<=40)) ) {
                        alt19=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:936:8: ( ( ruleID ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:936:8: ( ( ruleID ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:937:1: ( ruleID )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:937:1: ( ruleID )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:938:3: ruleID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTyRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getTypeRefTypeCrossReference_1_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleID_in_ruleTy1851);
                            ruleID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:952:6: ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:952:6: ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:953:1: ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:953:1: ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:954:1: (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:954:1: (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' )
                            int alt18=3;
                            switch ( input.LA(1) ) {
                            case 38:
                                {
                                alt18=1;
                                }
                                break;
                            case 39:
                                {
                                alt18=2;
                                }
                                break;
                            case 40:
                                {
                                alt18=3;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 18, 0, input);

                                throw nvae;
                            }

                            switch (alt18) {
                                case 1 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:955:3: lv_type_2_1= 'int'
                                    {
                                    lv_type_2_1=(Token)match(input,38,FOLLOW_38_in_ruleTy1877); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_type_2_1, grammarAccess.getTyAccess().getTypeIntKeyword_1_0_1_0_0());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getTyRule());
                                      	        }
                                             		setWithLastConsumed(current, "type", lv_type_2_1, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:967:8: lv_type_2_2= 'string'
                                    {
                                    lv_type_2_2=(Token)match(input,39,FOLLOW_39_in_ruleTy1906); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_type_2_2, grammarAccess.getTyAccess().getTypeStringKeyword_1_0_1_0_1());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getTyRule());
                                      	        }
                                             		setWithLastConsumed(current, "type", lv_type_2_2, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 3 :
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:979:8: lv_type_2_3= 'unit'
                                    {
                                    lv_type_2_3=(Token)match(input,40,FOLLOW_40_in_ruleTy1935); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_type_2_3, grammarAccess.getTyAccess().getTypeUnitKeyword_1_0_1_0_2());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getTyRule());
                                      	        }
                                             		setWithLastConsumed(current, "type", lv_type_2_3, null);
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;

                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:994:3: (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==34) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:994:5: otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']'
                            {
                            otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleTy1965); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getTyAccess().getLeftSquareBracketKeyword_1_1_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:998:1: ( (lv_tyBind_4_0= ruleTyBind ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:999:1: (lv_tyBind_4_0= ruleTyBind )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:999:1: (lv_tyBind_4_0= ruleTyBind )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1000:3: lv_tyBind_4_0= ruleTyBind
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyBind_in_ruleTy1986);
                            lv_tyBind_4_0=ruleTyBind();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTyRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"tyBind",
                                      		lv_tyBind_4_0, 
                                      		"TyBind");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1016:2: (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==36) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1016:4: otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) )
                            	    {
                            	    otherlv_5=(Token)match(input,36,FOLLOW_36_in_ruleTy1999); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_5, grammarAccess.getTyAccess().getCommaKeyword_1_1_2_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1020:1: ( (lv_tyBind_6_0= ruleTyBind ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1021:1: (lv_tyBind_6_0= ruleTyBind )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1021:1: (lv_tyBind_6_0= ruleTyBind )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1022:3: lv_tyBind_6_0= ruleTyBind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_1_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyBind_in_ruleTy2020);
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


                            	    }
                            	    break;

                            	default :
                            	    break loop20;
                                }
                            } while (true);

                            otherlv_7=(Token)match(input,35,FOLLOW_35_in_ruleTy2034); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getTyAccess().getRightSquareBracketKeyword_1_1_3());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1043:6: ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1043:6: ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1043:7: () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1043:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1044:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTyAccess().getTyAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_9=(Token)match(input,41,FOLLOW_41_in_ruleTy2065); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_2_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1053:1: ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==RULE_S||(LA23_0>=RULE_ID_WO_CONS && LA23_0<=RULE_SLASH)||LA23_0==RULE_CONS_WO_S) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1053:2: ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1053:2: ( (lv_elements_10_0= ruleTyElement ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:1: (lv_elements_10_0= ruleTyElement )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:1: (lv_elements_10_0= ruleTyElement )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1055:3: lv_elements_10_0= ruleTyElement
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyElement_in_ruleTy2087);
                            lv_elements_10_0=ruleTyElement();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTyRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"elements",
                                      		lv_elements_10_0, 
                                      		"TyElement");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1071:2: (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==36) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1071:4: otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) )
                            	    {
                            	    otherlv_11=(Token)match(input,36,FOLLOW_36_in_ruleTy2100); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getTyAccess().getCommaKeyword_2_2_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1075:1: ( (lv_elements_12_0= ruleTyElement ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1076:1: (lv_elements_12_0= ruleTyElement )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1076:1: (lv_elements_12_0= ruleTyElement )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1077:3: lv_elements_12_0= ruleTyElement
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_2_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2121);
                            	    lv_elements_12_0=ruleTyElement();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getTyRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"elements",
                            	              		lv_elements_12_0, 
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


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,42,FOLLOW_42_in_ruleTy2137); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getTyAccess().getRightCurlyBracketKeyword_2_3());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1098:6: (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1098:6: (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1098:8: otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) )
                    {
                    otherlv_14=(Token)match(input,43,FOLLOW_43_in_ruleTy2157); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getTyAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1102:1: ( (lv_param_15_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1103:1: (lv_param_15_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1103:1: (lv_param_15_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1104:3: lv_param_15_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getParamTyParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2178);
                    lv_param_15_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		add(
                             			current, 
                             			"param",
                              		lv_param_15_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1120:2: (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==36) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1120:4: otherlv_16= ',' ( (lv_param_17_0= ruleTy ) )
                    	    {
                    	    otherlv_16=(Token)match(input,36,FOLLOW_36_in_ruleTy2191); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_16, grammarAccess.getTyAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1124:1: ( (lv_param_17_0= ruleTy ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1125:1: (lv_param_17_0= ruleTy )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1125:1: (lv_param_17_0= ruleTy )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1126:3: lv_param_17_0= ruleTy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTyAccess().getParamTyParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTy_in_ruleTy2212);
                    	    lv_param_17_0=ruleTy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTyRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"param",
                    	              		lv_param_17_0, 
                    	              		"Ty");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,44,FOLLOW_44_in_ruleTy2226); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getTyAccess().getRightParenthesisKeyword_3_3());
                          
                    }
                    otherlv_19=(Token)match(input,45,FOLLOW_45_in_ruleTy2238); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getTyAccess().getHyphenMinusGreaterThanSignKeyword_3_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1150:1: ( (lv_resType_20_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1151:1: (lv_resType_20_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1151:1: (lv_resType_20_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1152:3: lv_resType_20_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getResTypeTyParserRuleCall_3_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2259);
                    lv_resType_20_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"resType",
                              		lv_resType_20_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:6: ( () otherlv_22= '()' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:6: ( () otherlv_22= '()' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:7: () otherlv_22= '()'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1170:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTyAccess().getTyAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_22=(Token)match(input,46,FOLLOW_46_in_ruleTy2288); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getTyAccess().getLeftParenthesisRightParenthesisKeyword_4_1());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1180:6: (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1180:6: (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1180:7: this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER
                    {
                    this_S_23=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTy2307); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_S_23, grammarAccess.getTyAccess().getSTerminalRuleCall_5_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1184:1: ( (lv_r_24_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1185:1: (lv_r_24_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1185:1: (lv_r_24_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1186:3: lv_r_24_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getRTyParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2327);
                    lv_r_24_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"r",
                              		lv_r_24_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_LESS_25=(Token)match(input,RULE_LESS,FOLLOW_RULE_LESS_in_ruleTy2338); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LESS_25, grammarAccess.getTyAccess().getLESSTerminalRuleCall_5_2()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1206:1: ( (lv_in_26_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1207:1: (lv_in_26_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1207:1: (lv_in_26_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1208:3: lv_in_26_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getInTyParserRuleCall_5_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2358);
                    lv_in_26_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"in",
                              		lv_in_26_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_27=(Token)match(input,47,FOLLOW_47_in_ruleTy2370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getTyAccess().getEqualsSignGreaterThanSignKeyword_5_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1228:1: ( (lv_out_28_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1229:1: (lv_out_28_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1229:1: (lv_out_28_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1230:3: lv_out_28_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getOutTyParserRuleCall_5_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2391);
                    lv_out_28_0=ruleTy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTyRule());
                      	        }
                             		set(
                             			current, 
                             			"out",
                              		lv_out_28_0, 
                              		"Ty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_GREATER_29=(Token)match(input,RULE_GREATER,FOLLOW_RULE_GREATER_in_ruleTy2402); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_GREATER_29, grammarAccess.getTyAccess().getGREATERTerminalRuleCall_5_6()); 
                          
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1258:1: entryRuleTyBind returns [EObject current=null] : iv_ruleTyBind= ruleTyBind EOF ;
    public final EObject entryRuleTyBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1259:2: (iv_ruleTyBind= ruleTyBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1260:2: iv_ruleTyBind= ruleTyBind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyBindRule()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind2438);
            iv_ruleTyBind=ruleTyBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyBind; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind2448); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1267:1: ruleTyBind returns [EObject current=null] : ( ( (lv_name_0_0= ruleID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleTyBind() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1270:28: ( ( ( (lv_name_0_0= ruleID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1271:1: ( ( (lv_name_0_0= ruleID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1271:1: ( ( (lv_name_0_0= ruleID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1271:2: ( (lv_name_0_0= ruleID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1271:2: ( (lv_name_0_0= ruleID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1272:1: (lv_name_0_0= ruleID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1272:1: (lv_name_0_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1273:3: lv_name_0_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyBindAccess().getNameIDParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleID_in_ruleTyBind2494);
            lv_name_0_0=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTyBindRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1289:2: (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==31) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1289:4: otherlv_1= '=' ( (lv_value_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleTyBind2507); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1293:1: ( (lv_value_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1294:1: (lv_value_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1294:1: (lv_value_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1295:3: lv_value_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTyBind2528);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1319:1: entryRuleTyElement returns [EObject current=null] : iv_ruleTyElement= ruleTyElement EOF ;
    public final EObject entryRuleTyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyElement = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1320:2: (iv_ruleTyElement= ruleTyElement EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1321:2: iv_ruleTyElement= ruleTyElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyElementRule()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement2566);
            iv_ruleTyElement=ruleTyElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement2576); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1328:1: ruleTyElement returns [EObject current=null] : ( ( (lv_name_0_0= ruleID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) ;
    public final EObject ruleTyElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1331:28: ( ( ( (lv_name_0_0= ruleID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:1: ( ( (lv_name_0_0= ruleID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:1: ( ( (lv_name_0_0= ruleID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:2: ( (lv_name_0_0= ruleID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1332:2: ( (lv_name_0_0= ruleID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1333:1: (lv_name_0_0= ruleID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1333:1: (lv_name_0_0= ruleID )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1334:3: lv_name_0_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyElementAccess().getNameIDParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleID_in_ruleTyElement2622);
            lv_name_0_0=ruleID();

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
                      		"ID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleTyElement2634); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTyElementAccess().getColonKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1354:1: ( (lv_value_2_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1355:1: (lv_value_2_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1355:1: (lv_value_2_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1356:3: lv_value_2_0= ruleTy
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTy_in_ruleTyElement2655);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1380:1: entryRuleExp returns [EObject current=null] : iv_ruleExp= ruleExp EOF ;
    public final EObject entryRuleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1381:2: (iv_ruleExp= ruleExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1382:2: iv_ruleExp= ruleExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpRule()); 
            }
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp2691);
            iv_ruleExp=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp2701); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1389:1: ruleExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ ) ;
    public final EObject ruleExp() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_mid_1_0 = null;

        EObject lv_caseExps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1392:28: ( ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1393:1: ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1393:1: ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_S||LA28_0==RULE_STRING||LA28_0==RULE_HEXINT||(LA28_0>=RULE_ID_WO_CONS && LA28_0<=RULE_SLASH)||(LA28_0>=RULE_NEGINT && LA28_0<=RULE_DUALS)||LA28_0==RULE_CONS_WO_S||LA28_0==41||LA28_0==43||LA28_0==48||LA28_0==50||LA28_0==53||(LA28_0>=62 && LA28_0<=65)||LA28_0==67) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_USCORE||LA28_0==RULE_MIXID) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1393:2: ( (lv_name_0_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1393:2: ( (lv_name_0_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1394:1: (lv_name_0_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1394:1: (lv_name_0_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1395:3: lv_name_0_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getNameCaseExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp2747);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1412:6: ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1412:6: ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_USCORE||LA27_0==RULE_MIXID) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1412:7: ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1412:7: ( (lv_mid_1_0= ruleMID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1413:1: (lv_mid_1_0= ruleMID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1413:1: (lv_mid_1_0= ruleMID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1414:3: lv_mid_1_0= ruleMID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpAccess().getMidMIDParserRuleCall_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMID_in_ruleExp2775);
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

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1430:2: ( (lv_caseExps_2_0= ruleCaseExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1431:1: (lv_caseExps_2_0= ruleCaseExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1431:1: (lv_caseExps_2_0= ruleCaseExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1432:3: lv_caseExps_2_0= ruleCaseExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpAccess().getCaseExpsCaseExpParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp2796);
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
                    	    if ( cnt27 >= 1 ) break loop27;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1456:1: entryRuleCaseExp returns [EObject current=null] : iv_ruleCaseExp= ruleCaseExp EOF ;
    public final EObject entryRuleCaseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1457:2: (iv_ruleCaseExp= ruleCaseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1458:2: iv_ruleCaseExp= ruleCaseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseExpRule()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_entryRuleCaseExp2834);
            iv_ruleCaseExp=ruleCaseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseExp2844); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1465:1: ruleCaseExp returns [EObject current=null] : (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) ) ;
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

        AntlrDatatypeRuleToken lv_pat_4_0 = null;

        EObject lv_exp_6_0 = null;

        AntlrDatatypeRuleToken lv_pat_8_0 = null;

        EObject lv_exp_10_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1468:28: ( (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1469:1: (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1469:1: (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_S||LA30_0==RULE_STRING||LA30_0==RULE_HEXINT||(LA30_0>=RULE_ID_WO_CONS && LA30_0<=RULE_SLASH)||(LA30_0>=RULE_NEGINT && LA30_0<=RULE_DUALS)||LA30_0==RULE_CONS_WO_S||LA30_0==41||LA30_0==43||LA30_0==50||LA30_0==53||(LA30_0>=62 && LA30_0<=65)||LA30_0==67) ) {
                alt30=1;
            }
            else if ( (LA30_0==48) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1470:5: this_ClosedExp_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp2891);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1479:6: ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1479:6: ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1479:7: ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1479:7: ( (lv_name_1_0= 'case' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1480:1: (lv_name_1_0= 'case' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1480:1: (lv_name_1_0= 'case' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1481:3: lv_name_1_0= 'case'
                    {
                    lv_name_1_0=(Token)match(input,48,FOLLOW_48_in_ruleCaseExp2915); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1494:2: ( (lv_closedExp_2_0= ruleClosedExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1495:1: (lv_closedExp_2_0= ruleClosedExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1495:1: (lv_closedExp_2_0= ruleClosedExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1496:3: lv_closedExp_2_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpClosedExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp2949);
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

                    otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleCaseExp2961); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCaseExpAccess().getOfKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1516:1: ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1516:2: ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1516:2: ( (lv_pat_4_0= rulePAT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1517:1: (lv_pat_4_0= rulePAT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1517:1: (lv_pat_4_0= rulePAT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1518:3: lv_pat_4_0= rulePAT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getPatPATParserRuleCall_1_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePAT_in_ruleCaseExp2983);
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

                    otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleCaseExp2995); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCaseExpAccess().getColonKeyword_1_3_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1538:1: ( (lv_exp_6_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1539:1: (lv_exp_6_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1539:1: (lv_exp_6_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1540:3: lv_exp_6_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getExpExpParserRuleCall_1_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleCaseExp3016);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1556:2: (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==32) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1556:4: otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) )
                    	    {
                    	    otherlv_7=(Token)match(input,32,FOLLOW_32_in_ruleCaseExp3029); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getCaseExpAccess().getVerticalLineKeyword_1_3_3_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1560:1: ( (lv_pat_8_0= rulePAT ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1561:1: (lv_pat_8_0= rulePAT )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1561:1: (lv_pat_8_0= rulePAT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1562:3: lv_pat_8_0= rulePAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCaseExpAccess().getPatPATParserRuleCall_1_3_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePAT_in_ruleCaseExp3050);
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

                    	    otherlv_9=(Token)match(input,29,FOLLOW_29_in_ruleCaseExp3062); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getCaseExpAccess().getColonKeyword_1_3_3_2());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1582:1: ( (lv_exp_10_0= ruleExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1583:1: (lv_exp_10_0= ruleExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1583:1: (lv_exp_10_0= ruleExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1584:3: lv_exp_10_0= ruleExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCaseExpAccess().getExpExpParserRuleCall_1_3_3_3_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExp_in_ruleCaseExp3083);
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
                    	    break loop29;
                        }
                    } while (true);


                    }

                    otherlv_11=(Token)match(input,49,FOLLOW_49_in_ruleCaseExp3098); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1612:1: entryRuleClosedExp returns [EObject current=null] : iv_ruleClosedExp= ruleClosedExp EOF ;
    public final EObject entryRuleClosedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosedExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1613:2: (iv_ruleClosedExp= ruleClosedExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1614:2: iv_ruleClosedExp= ruleClosedExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosedExpRule()); 
            }
            pushFollow(FOLLOW_ruleClosedExp_in_entryRuleClosedExp3135);
            iv_ruleClosedExp=ruleClosedExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosedExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedExp3145); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1621:1: ruleClosedExp returns [EObject current=null] : (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1624:28: ( (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1625:1: (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1625:1: (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            int alt32=3;
            switch ( input.LA(1) ) {
            case RULE_S:
            case RULE_STRING:
            case RULE_HEXINT:
            case RULE_ID_WO_CONS:
            case RULE_SLASH:
            case RULE_NEGINT:
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
            case RULE_CONS_WO_S:
            case 41:
            case 43:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
                {
                alt32=1;
                }
                break;
            case 50:
                {
                alt32=2;
                }
                break;
            case 53:
                {
                alt32=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1626:5: this_OrElseExp_0= ruleOrElseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClosedExpAccess().getOrElseExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrElseExp_in_ruleClosedExp3192);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1635:6: ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1635:6: ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1635:7: ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1635:7: ( (lv_name_1_0= 'if' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1636:1: (lv_name_1_0= 'if' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1636:1: (lv_name_1_0= 'if' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1637:3: lv_name_1_0= 'if'
                    {
                    lv_name_1_0=(Token)match(input,50,FOLLOW_50_in_ruleClosedExp3216); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1650:2: ( (lv_ifCaseExp_2_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1651:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1651:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1652:3: lv_ifCaseExp_2_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getIfCaseExpCaseExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3250);
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

                    otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleClosedExp3262); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getClosedExpAccess().getThenKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1672:1: ( (lv_thenCaseExp_4_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1673:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1673:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1674:3: lv_thenCaseExp_4_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getThenCaseExpCaseExpParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3283);
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

                    otherlv_5=(Token)match(input,52,FOLLOW_52_in_ruleClosedExp3295); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getClosedExpAccess().getElseKeyword_1_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1694:1: ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1695:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1695:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1696:3: lv_elseCaseExp_6_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getElseCaseExpCaseExpParserRuleCall_1_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3316);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:6: ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:6: ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:7: ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:7: ( (lv_name_7_0= 'do' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1714:1: (lv_name_7_0= 'do' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1714:1: (lv_name_7_0= 'do' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1715:3: lv_name_7_0= 'do'
                    {
                    lv_name_7_0=(Token)match(input,53,FOLLOW_53_in_ruleClosedExp3342); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1728:2: ( (lv_doExp_8_0= ruleMonadicExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1729:1: (lv_doExp_8_0= ruleMonadicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1729:1: (lv_doExp_8_0= ruleMonadicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1730:3: lv_doExp_8_0= ruleMonadicExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3376);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1746:2: (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==27) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1746:4: otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    {
                    	    otherlv_9=(Token)match(input,27,FOLLOW_27_in_ruleClosedExp3389); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getClosedExpAccess().getSemicolonKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1750:1: ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1751:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1751:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1752:3: lv_doExp_10_0= ruleMonadicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3410);
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
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,49,FOLLOW_49_in_ruleClosedExp3424); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1780:1: entryRuleMonadicExp returns [EObject current=null] : iv_ruleMonadicExp= ruleMonadicExp EOF ;
    public final EObject entryRuleMonadicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonadicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1781:2: (iv_ruleMonadicExp= ruleMonadicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1782:2: iv_ruleMonadicExp= ruleMonadicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMonadicExpRule()); 
            }
            pushFollow(FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3461);
            iv_ruleMonadicExp=ruleMonadicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMonadicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonadicExp3471); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1789:1: ruleMonadicExp returns [EObject current=null] : ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleID ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) ;
    public final EObject ruleMonadicExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_exp_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_exp_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1792:28: ( ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleID ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1793:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleID ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1793:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleID ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1793:2: ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1793:2: ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1793:3: ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1798:1: (lv_exp_0_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1799:3: lv_exp_0_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3527);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1816:6: ( ( (lv_name_1_0= ruleID ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1816:6: ( ( (lv_name_1_0= ruleID ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1816:7: ( (lv_name_1_0= ruleID ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1816:7: ( (lv_name_1_0= ruleID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1817:1: (lv_name_1_0= ruleID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1817:1: (lv_name_1_0= ruleID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1818:3: lv_name_1_0= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getNameIDParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleID_in_ruleMonadicExp3555);
                    lv_name_1_0=ruleID();

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
                              		"ID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,54,FOLLOW_54_in_ruleMonadicExp3567); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getMonadicExpAccess().getLessThanSignHyphenMinusKeyword_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1838:1: ( (lv_exp_3_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:1: (lv_exp_3_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1839:1: (lv_exp_3_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1840:3: lv_exp_3_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3588);
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
            pushFollow(FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3625);
            iv_ruleOrElseExp=ruleOrElseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrElseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrElseExp3635); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1873:1: ruleOrElseExp returns [EObject current=null] : (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) ;
    public final EObject ruleOrElseExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_AndAlsoExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1876:28: ( (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1877:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1877:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1878:5: this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrElseExpAccess().getAndAlsoExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3682);
            this_AndAlsoExp_0=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndAlsoExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1886:1: ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==55) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1886:2: () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) )
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1892:2: ( (lv_name_2_0= 'or' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1893:1: (lv_name_2_0= 'or' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1893:1: (lv_name_2_0= 'or' )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1894:3: lv_name_2_0= 'or'
            	    {
            	    lv_name_2_0=(Token)match(input,55,FOLLOW_55_in_ruleOrElseExp3709); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1907:2: ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1908:1: (lv_right_3_0= ruleAndAlsoExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1908:1: (lv_right_3_0= ruleAndAlsoExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1909:3: lv_right_3_0= ruleAndAlsoExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrElseExpAccess().getRightAndAlsoExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3743);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1933:1: entryRuleAndAlsoExp returns [EObject current=null] : iv_ruleAndAlsoExp= ruleAndAlsoExp EOF ;
    public final EObject entryRuleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndAlsoExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1934:2: (iv_ruleAndAlsoExp= ruleAndAlsoExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1935:2: iv_ruleAndAlsoExp= ruleAndAlsoExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndAlsoExpRule()); 
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp3781);
            iv_ruleAndAlsoExp=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndAlsoExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndAlsoExp3791); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1942:1: ruleAndAlsoExp returns [EObject current=null] : (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* ) ;
    public final EObject ruleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_RExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:28: ( (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1946:1: (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1946:1: (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1947:5: this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp3838);
            this_RExp_0=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1955:1: ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==56) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1955:2: () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1955:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1956:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1961:2: ( (lv_name_2_0= 'and' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1962:1: (lv_name_2_0= 'and' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1962:1: (lv_name_2_0= 'and' )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1963:3: lv_name_2_0= 'and'
            	    {
            	    lv_name_2_0=(Token)match(input,56,FOLLOW_56_in_ruleAndAlsoExp3865); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1976:2: ( (lv_right_3_0= ruleRExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1977:1: (lv_right_3_0= ruleRExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1977:1: (lv_right_3_0= ruleRExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1978:3: lv_right_3_0= ruleRExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRightRExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp3899);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2002:1: entryRuleRExp returns [EObject current=null] : iv_ruleRExp= ruleRExp EOF ;
    public final EObject entryRuleRExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2003:2: (iv_ruleRExp= ruleRExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2004:2: iv_ruleRExp= ruleRExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRExpRule()); 
            }
            pushFollow(FOLLOW_ruleRExp_in_entryRuleRExp3937);
            iv_ruleRExp=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRExp3947); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2011:1: ruleRExp returns [EObject current=null] : (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) ;
    public final EObject ruleRExp() throws RecognitionException {
        EObject current = null;

        EObject this_AExp_0 = null;

        AntlrDatatypeRuleToken lv_sym_1_0 = null;

        EObject lv_aexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2014:28: ( (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2015:1: (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2015:1: (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2016:5: this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRExpAccess().getAExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAExp_in_ruleRExp3994);
            this_AExp_0=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2024:1: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2024:2: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2024:2: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2024:3: ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2029:1: (lv_sym_1_0= ruleSYM )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2030:3: lv_sym_1_0= ruleSYM
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getSymSYMParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSYM_in_ruleRExp4025);
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2046:2: ( (lv_aexps_2_0= ruleAExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2047:1: (lv_aexps_2_0= ruleAExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2047:1: (lv_aexps_2_0= ruleAExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2048:3: lv_aexps_2_0= ruleAExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getAexpsAExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAExp_in_ruleRExp4046);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2072:1: entryRuleAExp returns [EObject current=null] : iv_ruleAExp= ruleAExp EOF ;
    public final EObject entryRuleAExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2073:2: (iv_ruleAExp= ruleAExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2074:2: iv_ruleAExp= ruleAExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpRule()); 
            }
            pushFollow(FOLLOW_ruleAExp_in_entryRuleAExp4084);
            iv_ruleAExp=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExp4094); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2081:1: ruleAExp returns [EObject current=null] : (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) ;
    public final EObject ruleAExp() throws RecognitionException {
        EObject current = null;

        Token lv_sign_1_1=null;
        Token lv_sign_1_2=null;
        EObject this_MExp_0 = null;

        EObject lv_mexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2084:28: ( (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2085:1: (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2085:1: (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2086:5: this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAExpAccess().getMExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMExp_in_ruleAExp4141);
            this_MExp_0=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2094:1: ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=57 && LA38_0<=58)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2094:2: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2094:2: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2095:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2095:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2096:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2096:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==57) ) {
            	        alt37=1;
            	    }
            	    else if ( (LA37_0==58) ) {
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2097:3: lv_sign_1_1= '+'
            	            {
            	            lv_sign_1_1=(Token)match(input,57,FOLLOW_57_in_ruleAExp4161); if (state.failed) return current;
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2109:8: lv_sign_1_2= '-'
            	            {
            	            lv_sign_1_2=(Token)match(input,58,FOLLOW_58_in_ruleAExp4190); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2124:2: ( (lv_mexps_2_0= ruleMExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2125:1: (lv_mexps_2_0= ruleMExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2125:1: (lv_mexps_2_0= ruleMExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2126:3: lv_mexps_2_0= ruleMExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAExpAccess().getMexpsMExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMExp_in_ruleAExp4227);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2150:1: entryRuleMExp returns [EObject current=null] : iv_ruleMExp= ruleMExp EOF ;
    public final EObject entryRuleMExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2151:2: (iv_ruleMExp= ruleMExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2152:2: iv_ruleMExp= ruleMExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMExpRule()); 
            }
            pushFollow(FOLLOW_ruleMExp_in_entryRuleMExp4265);
            iv_ruleMExp=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMExp4275); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2159:1: ruleMExp returns [EObject current=null] : (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) ;
    public final EObject ruleMExp() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_1=null;
        Token lv_symbol_1_2=null;
        EObject this_SelectExp_0 = null;

        EObject lv_applyexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2162:28: ( (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2163:1: (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2163:1: (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2164:5: this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMExpAccess().getSelectExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleSelectExp_in_ruleMExp4322);
            this_SelectExp_0=ruleSelectExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_SelectExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2172:1: ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=59 && LA40_0<=60)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2172:2: ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2172:2: ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2173:1: ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2173:1: ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2174:1: (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2174:1: (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' )
            	    int alt39=2;
            	    int LA39_0 = input.LA(1);

            	    if ( (LA39_0==59) ) {
            	        alt39=1;
            	    }
            	    else if ( (LA39_0==60) ) {
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2175:3: lv_symbol_1_1= '*'
            	            {
            	            lv_symbol_1_1=(Token)match(input,59,FOLLOW_59_in_ruleMExp4342); if (state.failed) return current;
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2187:8: lv_symbol_1_2= '%'
            	            {
            	            lv_symbol_1_2=(Token)match(input,60,FOLLOW_60_in_ruleMExp4371); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2202:2: ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2203:1: (lv_applyexps_2_0= ruleApplyExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2203:1: (lv_applyexps_2_0= ruleApplyExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2204:3: lv_applyexps_2_0= ruleApplyExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMExpAccess().getApplyexpsApplyExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleApplyExp_in_ruleMExp4408);
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
            	    break loop40;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2228:1: entryRuleSelectExp returns [EObject current=null] : iv_ruleSelectExp= ruleSelectExp EOF ;
    public final EObject entryRuleSelectExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2229:2: (iv_ruleSelectExp= ruleSelectExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2230:2: iv_ruleSelectExp= ruleSelectExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelectExpRule()); 
            }
            pushFollow(FOLLOW_ruleSelectExp_in_entryRuleSelectExp4446);
            iv_ruleSelectExp=ruleSelectExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelectExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectExp4456); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2237:1: ruleSelectExp returns [EObject current=null] : (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) ;
    public final EObject ruleSelectExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ApplyExp_0 = null;

        EObject lv_applyexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2240:28: ( (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2241:1: (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2241:1: (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2242:5: this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSelectExpAccess().getApplyExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleApplyExp_in_ruleSelectExp4503);
            this_ApplyExp_0=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ApplyExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2250:1: (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==61) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2250:3: otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    {
            	    otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleSelectExp4515); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getSelectExpAccess().getCircumflexAccentKeyword_1_0());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2254:1: ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2255:1: (lv_applyexps_2_0= ruleApplyExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2255:1: (lv_applyexps_2_0= ruleApplyExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2256:3: lv_applyexps_2_0= ruleApplyExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSelectExpAccess().getApplyexpsApplyExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleApplyExp_in_ruleSelectExp4536);
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
            	    break loop41;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2280:1: entryRuleApplyExp returns [EObject current=null] : iv_ruleApplyExp= ruleApplyExp EOF ;
    public final EObject entryRuleApplyExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2281:2: (iv_ruleApplyExp= ruleApplyExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2282:2: iv_ruleApplyExp= ruleApplyExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getApplyExpRule()); 
            }
            pushFollow(FOLLOW_ruleApplyExp_in_entryRuleApplyExp4574);
            iv_ruleApplyExp=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleApplyExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleApplyExp4584); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2289:1: ruleApplyExp returns [EObject current=null] : ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+ ) ;
    public final EObject ruleApplyExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_AtomicExp_1 = null;

        EObject lv_atomicExp_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2292:28: ( ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2293:1: ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2293:1: ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+ )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==62) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_S||LA43_0==RULE_STRING||LA43_0==RULE_HEXINT||(LA43_0>=RULE_ID_WO_CONS && LA43_0<=RULE_SLASH)||(LA43_0>=RULE_NEGINT && LA43_0<=RULE_DUALS)||LA43_0==RULE_CONS_WO_S||LA43_0==41||LA43_0==43||(LA43_0>=63 && LA43_0<=65)||LA43_0==67) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2293:2: (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2293:2: (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2293:4: otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp
                    {
                    otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleApplyExp4622); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getApplyExpAccess().getTildeKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getApplyExpAccess().getAtomicExpParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAtomicExp_in_ruleApplyExp4644);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2307:6: ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2307:6: ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=2;
                        alt42 = dfa42.predict(input);
                        switch (alt42) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2307:7: ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2311:5: ( (lv_atomicExp_2_0= ruleAtomicExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2312:1: (lv_atomicExp_2_0= ruleAtomicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2312:1: (lv_atomicExp_2_0= ruleAtomicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2313:3: lv_atomicExp_2_0= ruleAtomicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getApplyExpAccess().getAtomicExpAtomicExpParserRuleCall_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAtomicExp_in_ruleApplyExp4684);
                    	    lv_atomicExp_2_0=ruleAtomicExp();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getApplyExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"atomicExp",
                    	              		lv_atomicExp_2_0, 
                    	              		"AtomicExp");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt42 >= 1 ) break loop42;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
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
    // $ANTLR end "ruleApplyExp"


    // $ANTLR start "entryRuleAtomicExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2337:1: entryRuleAtomicExp returns [EObject current=null] : iv_ruleAtomicExp= ruleAtomicExp EOF ;
    public final EObject entryRuleAtomicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2338:2: (iv_ruleAtomicExp= ruleAtomicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2339:2: iv_ruleAtomicExp= ruleAtomicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExpRule()); 
            }
            pushFollow(FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp4722);
            iv_ruleAtomicExp=ruleAtomicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicExp4732); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2346:1: ruleAtomicExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( ( ruleCONS ) ) )=> ( (lv_name_2_0= ruleCONS ) ) ) | ( ( (lv_name_3_0= ruleID ) ) ( ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) ) )* ) | ( ( (lv_name_6_0= '@' ) ) otherlv_7= '{' ( (lv_fields_8_0= ruleField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleField ) ) )* otherlv_11= '}' ) | (otherlv_12= '$' ( (lv_name_13_0= ruleID ) ) ) | (otherlv_14= '(' ( (lv_expr_15_0= ruleExp ) ) otherlv_16= ')' ( ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) ) )* ) | ( () otherlv_20= '{' ( ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )* )? otherlv_28= '}' ) | ( ( (lv_name_29_0= 'let' ) ) ( (lv_valDecl_30_0= ruleValueDecl ) )+ otherlv_31= 'in' ( (lv_expr_32_0= ruleExp ) ) otherlv_33= 'end' ) ) ;
    public final EObject ruleAtomicExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token this_DOT_4=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token this_DOT_17=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token lv_name_29_0=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_id_5_0 = null;

        EObject lv_fields_8_0 = null;

        EObject lv_fields_10_0 = null;

        AntlrDatatypeRuleToken lv_name_13_0 = null;

        EObject lv_expr_15_0 = null;

        AntlrDatatypeRuleToken lv_id_18_0 = null;

        AntlrDatatypeRuleToken lv_id_21_0 = null;

        EObject lv_exps_23_0 = null;

        AntlrDatatypeRuleToken lv_id_25_0 = null;

        EObject lv_exps_27_0 = null;

        EObject lv_valDecl_30_0 = null;

        EObject lv_expr_32_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2349:28: ( ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( ( ruleCONS ) ) )=> ( (lv_name_2_0= ruleCONS ) ) ) | ( ( (lv_name_3_0= ruleID ) ) ( ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) ) )* ) | ( ( (lv_name_6_0= '@' ) ) otherlv_7= '{' ( (lv_fields_8_0= ruleField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleField ) ) )* otherlv_11= '}' ) | (otherlv_12= '$' ( (lv_name_13_0= ruleID ) ) ) | (otherlv_14= '(' ( (lv_expr_15_0= ruleExp ) ) otherlv_16= ')' ( ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) ) )* ) | ( () otherlv_20= '{' ( ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )* )? otherlv_28= '}' ) | ( ( (lv_name_29_0= 'let' ) ) ( (lv_valDecl_30_0= ruleValueDecl ) )+ otherlv_31= 'in' ( (lv_expr_32_0= ruleExp ) ) otherlv_33= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2350:1: ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( ( ruleCONS ) ) )=> ( (lv_name_2_0= ruleCONS ) ) ) | ( ( (lv_name_3_0= ruleID ) ) ( ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) ) )* ) | ( ( (lv_name_6_0= '@' ) ) otherlv_7= '{' ( (lv_fields_8_0= ruleField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleField ) ) )* otherlv_11= '}' ) | (otherlv_12= '$' ( (lv_name_13_0= ruleID ) ) ) | (otherlv_14= '(' ( (lv_expr_15_0= ruleExp ) ) otherlv_16= ')' ( ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) ) )* ) | ( () otherlv_20= '{' ( ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )* )? otherlv_28= '}' ) | ( ( (lv_name_29_0= 'let' ) ) ( (lv_valDecl_30_0= ruleValueDecl ) )+ otherlv_31= 'in' ( (lv_expr_32_0= ruleExp ) ) otherlv_33= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2350:1: ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( ( ruleCONS ) ) )=> ( (lv_name_2_0= ruleCONS ) ) ) | ( ( (lv_name_3_0= ruleID ) ) ( ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) ) )* ) | ( ( (lv_name_6_0= '@' ) ) otherlv_7= '{' ( (lv_fields_8_0= ruleField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleField ) ) )* otherlv_11= '}' ) | (otherlv_12= '$' ( (lv_name_13_0= ruleID ) ) ) | (otherlv_14= '(' ( (lv_expr_15_0= ruleExp ) ) otherlv_16= ')' ( ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) ) )* ) | ( () otherlv_20= '{' ( ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )* )? otherlv_28= '}' ) | ( ( (lv_name_29_0= 'let' ) ) ( (lv_valDecl_30_0= ruleValueDecl ) )+ otherlv_31= 'in' ( (lv_expr_32_0= ruleExp ) ) otherlv_33= 'end' ) )
            int alt50=9;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2350:2: ( (lv_name_0_0= ruleLIT ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2350:2: ( (lv_name_0_0= ruleLIT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2351:1: (lv_name_0_0= ruleLIT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2351:1: (lv_name_0_0= ruleLIT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2352:3: lv_name_0_0= ruleLIT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getNameLITParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLIT_in_ruleAtomicExp4778);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2369:6: ( (lv_name_1_0= RULE_STRING ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2369:6: ( (lv_name_1_0= RULE_STRING ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2370:1: (lv_name_1_0= RULE_STRING )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2370:1: (lv_name_1_0= RULE_STRING )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2371:3: lv_name_1_0= RULE_STRING
                    {
                    lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAtomicExp4801); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2388:6: ( ( ( ( ruleCONS ) ) )=> ( (lv_name_2_0= ruleCONS ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2388:6: ( ( ( ( ruleCONS ) ) )=> ( (lv_name_2_0= ruleCONS ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2388:7: ( ( ( ruleCONS ) ) )=> ( (lv_name_2_0= ruleCONS ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2392:5: ( (lv_name_2_0= ruleCONS ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2393:1: (lv_name_2_0= ruleCONS )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2393:1: (lv_name_2_0= ruleCONS )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2394:3: lv_name_2_0= ruleCONS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getNameCONSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCONS_in_ruleAtomicExp4846);
                    lv_name_2_0=ruleCONS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"CONS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2411:6: ( ( (lv_name_3_0= ruleID ) ) ( ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2411:6: ( ( (lv_name_3_0= ruleID ) ) ( ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2411:7: ( (lv_name_3_0= ruleID ) ) ( ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2411:7: ( (lv_name_3_0= ruleID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2412:1: (lv_name_3_0= ruleID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2412:1: (lv_name_3_0= ruleID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2413:3: lv_name_3_0= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getNameIDParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleID_in_ruleAtomicExp4875);
                    lv_name_3_0=ruleID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_3_0, 
                              		"ID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2429:2: ( ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_DOT) ) {
                            switch ( input.LA(2) ) {
                            case RULE_S:
                                {
                                int LA44_3 = input.LA(3);

                                if ( (synpred9_InternalGDSL()) ) {
                                    alt44=1;
                                }


                                }
                                break;
                            case RULE_CONS_WO_S:
                                {
                                int LA44_4 = input.LA(3);

                                if ( (synpred9_InternalGDSL()) ) {
                                    alt44=1;
                                }


                                }
                                break;
                            case RULE_ID_WO_CONS:
                                {
                                int LA44_5 = input.LA(3);

                                if ( (synpred9_InternalGDSL()) ) {
                                    alt44=1;
                                }


                                }
                                break;
                            case RULE_SLASH:
                                {
                                int LA44_6 = input.LA(3);

                                if ( (synpred9_InternalGDSL()) ) {
                                    alt44=1;
                                }


                                }
                                break;

                            }

                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2429:3: ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2429:3: ( ( RULE_DOT )=>this_DOT_4= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2429:4: ( RULE_DOT )=>this_DOT_4= RULE_DOT
                    	    {
                    	    this_DOT_4=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp4893); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_4, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_3_1_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2433:2: ( (lv_id_5_0= ruleID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2434:1: (lv_id_5_0= ruleID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2434:1: (lv_id_5_0= ruleID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2435:3: lv_id_5_0= ruleID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getIdIDParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleID_in_ruleAtomicExp4914);
                    	    lv_id_5_0=ruleID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"id",
                    	              		lv_id_5_0, 
                    	              		"ID");
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
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2452:6: ( ( (lv_name_6_0= '@' ) ) otherlv_7= '{' ( (lv_fields_8_0= ruleField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleField ) ) )* otherlv_11= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2452:6: ( ( (lv_name_6_0= '@' ) ) otherlv_7= '{' ( (lv_fields_8_0= ruleField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleField ) ) )* otherlv_11= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2452:7: ( (lv_name_6_0= '@' ) ) otherlv_7= '{' ( (lv_fields_8_0= ruleField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleField ) ) )* otherlv_11= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2452:7: ( (lv_name_6_0= '@' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2453:1: (lv_name_6_0= '@' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2453:1: (lv_name_6_0= '@' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2454:3: lv_name_6_0= '@'
                    {
                    lv_name_6_0=(Token)match(input,63,FOLLOW_63_in_ruleAtomicExp4942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_6_0, grammarAccess.getAtomicExpAccess().getNameCommercialAtKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExpRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_6_0, "@");
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,41,FOLLOW_41_in_ruleAtomicExp4967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_4_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2471:1: ( (lv_fields_8_0= ruleField ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2472:1: (lv_fields_8_0= ruleField )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2472:1: (lv_fields_8_0= ruleField )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2473:3: lv_fields_8_0= ruleField
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp4988);
                    lv_fields_8_0=ruleField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		add(
                             			current, 
                             			"fields",
                              		lv_fields_8_0, 
                              		"Field");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2489:2: (otherlv_9= ',' ( (lv_fields_10_0= ruleField ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==36) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2489:4: otherlv_9= ',' ( (lv_fields_10_0= ruleField ) )
                    	    {
                    	    otherlv_9=(Token)match(input,36,FOLLOW_36_in_ruleAtomicExp5001); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getAtomicExpAccess().getCommaKeyword_4_3_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2493:1: ( (lv_fields_10_0= ruleField ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2494:1: (lv_fields_10_0= ruleField )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2494:1: (lv_fields_10_0= ruleField )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2495:3: lv_fields_10_0= ruleField
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_4_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp5022);
                    	    lv_fields_10_0=ruleField();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fields",
                    	              		lv_fields_10_0, 
                    	              		"Field");
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

                    otherlv_11=(Token)match(input,42,FOLLOW_42_in_ruleAtomicExp5036); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_4_4());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2516:6: (otherlv_12= '$' ( (lv_name_13_0= ruleID ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2516:6: (otherlv_12= '$' ( (lv_name_13_0= ruleID ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2516:8: otherlv_12= '$' ( (lv_name_13_0= ruleID ) )
                    {
                    otherlv_12=(Token)match(input,64,FOLLOW_64_in_ruleAtomicExp5056); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getAtomicExpAccess().getDollarSignKeyword_5_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2520:1: ( (lv_name_13_0= ruleID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2521:1: (lv_name_13_0= ruleID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2521:1: (lv_name_13_0= ruleID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2522:3: lv_name_13_0= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getNameIDParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleID_in_ruleAtomicExp5077);
                    lv_name_13_0=ruleID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_13_0, 
                              		"ID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2539:6: (otherlv_14= '(' ( (lv_expr_15_0= ruleExp ) ) otherlv_16= ')' ( ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2539:6: (otherlv_14= '(' ( (lv_expr_15_0= ruleExp ) ) otherlv_16= ')' ( ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2539:8: otherlv_14= '(' ( (lv_expr_15_0= ruleExp ) ) otherlv_16= ')' ( ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) ) )*
                    {
                    otherlv_14=(Token)match(input,43,FOLLOW_43_in_ruleAtomicExp5097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getAtomicExpAccess().getLeftParenthesisKeyword_6_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2543:1: ( (lv_expr_15_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2544:1: (lv_expr_15_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2544:1: (lv_expr_15_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2545:3: lv_expr_15_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExprExpParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5118);
                    lv_expr_15_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_15_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_16=(Token)match(input,44,FOLLOW_44_in_ruleAtomicExp5130); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getAtomicExpAccess().getRightParenthesisKeyword_6_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2565:1: ( ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==RULE_DOT) ) {
                            switch ( input.LA(2) ) {
                            case RULE_S:
                                {
                                int LA46_3 = input.LA(3);

                                if ( (synpred10_InternalGDSL()) ) {
                                    alt46=1;
                                }


                                }
                                break;
                            case RULE_CONS_WO_S:
                                {
                                int LA46_4 = input.LA(3);

                                if ( (synpred10_InternalGDSL()) ) {
                                    alt46=1;
                                }


                                }
                                break;
                            case RULE_ID_WO_CONS:
                                {
                                int LA46_5 = input.LA(3);

                                if ( (synpred10_InternalGDSL()) ) {
                                    alt46=1;
                                }


                                }
                                break;
                            case RULE_SLASH:
                                {
                                int LA46_6 = input.LA(3);

                                if ( (synpred10_InternalGDSL()) ) {
                                    alt46=1;
                                }


                                }
                                break;

                            }

                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2565:2: ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2565:2: ( ( RULE_DOT )=>this_DOT_17= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2565:3: ( RULE_DOT )=>this_DOT_17= RULE_DOT
                    	    {
                    	    this_DOT_17=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp5148); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_17, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_6_3_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2569:2: ( (lv_id_18_0= ruleID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2570:1: (lv_id_18_0= ruleID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2570:1: (lv_id_18_0= ruleID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2571:3: lv_id_18_0= ruleID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getIdIDParserRuleCall_6_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleID_in_ruleAtomicExp5169);
                    	    lv_id_18_0=ruleID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"id",
                    	              		lv_id_18_0, 
                    	              		"ID");
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
                    break;
                case 8 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2588:6: ( () otherlv_20= '{' ( ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )* )? otherlv_28= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2588:6: ( () otherlv_20= '{' ( ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )* )? otherlv_28= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2588:7: () otherlv_20= '{' ( ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )* )? otherlv_28= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2588:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2589:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExpAccess().getAtomicExpAction_7_0(),
                                  current);
                          
                    }

                    }

                    otherlv_20=(Token)match(input,41,FOLLOW_41_in_ruleAtomicExp5200); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_7_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2598:1: ( ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )* )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==RULE_S||(LA48_0>=RULE_ID_WO_CONS && LA48_0<=RULE_SLASH)||LA48_0==RULE_CONS_WO_S) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2598:2: ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2598:2: ( (lv_id_21_0= ruleID ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2599:1: (lv_id_21_0= ruleID )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2599:1: (lv_id_21_0= ruleID )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2600:3: lv_id_21_0= ruleID
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExpAccess().getIdIDParserRuleCall_7_2_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleID_in_ruleAtomicExp5222);
                            lv_id_21_0=ruleID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"id",
                                      		lv_id_21_0, 
                                      		"ID");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_22=(Token)match(input,31,FOLLOW_31_in_ruleAtomicExp5234); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_22, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_7_2_1());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2620:1: ( (lv_exps_23_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2621:1: (lv_exps_23_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2621:1: (lv_exps_23_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2622:3: lv_exps_23_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_7_2_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5255);
                            lv_exps_23_0=ruleExp();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"exps",
                                      		lv_exps_23_0, 
                                      		"Exp");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2638:2: (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )*
                            loop47:
                            do {
                                int alt47=2;
                                int LA47_0 = input.LA(1);

                                if ( (LA47_0==36) ) {
                                    alt47=1;
                                }


                                switch (alt47) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2638:4: otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) )
                            	    {
                            	    otherlv_24=(Token)match(input,36,FOLLOW_36_in_ruleAtomicExp5268); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_24, grammarAccess.getAtomicExpAccess().getCommaKeyword_7_2_3_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2642:1: ( (lv_id_25_0= ruleID ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2643:1: (lv_id_25_0= ruleID )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2643:1: (lv_id_25_0= ruleID )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2644:3: lv_id_25_0= ruleID
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getIdIDParserRuleCall_7_2_3_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleID_in_ruleAtomicExp5289);
                            	    lv_id_25_0=ruleID();

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
                            	              		"ID");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }

                            	    otherlv_26=(Token)match(input,31,FOLLOW_31_in_ruleAtomicExp5301); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_26, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_7_2_3_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2664:1: ( (lv_exps_27_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2665:1: (lv_exps_27_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2665:1: (lv_exps_27_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2666:3: lv_exps_27_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_7_2_3_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5322);
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


                            	    }
                            	    break;

                            	default :
                            	    break loop47;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_28=(Token)match(input,42,FOLLOW_42_in_ruleAtomicExp5338); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_7_3());
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2687:6: ( ( (lv_name_29_0= 'let' ) ) ( (lv_valDecl_30_0= ruleValueDecl ) )+ otherlv_31= 'in' ( (lv_expr_32_0= ruleExp ) ) otherlv_33= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2687:6: ( ( (lv_name_29_0= 'let' ) ) ( (lv_valDecl_30_0= ruleValueDecl ) )+ otherlv_31= 'in' ( (lv_expr_32_0= ruleExp ) ) otherlv_33= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2687:7: ( (lv_name_29_0= 'let' ) ) ( (lv_valDecl_30_0= ruleValueDecl ) )+ otherlv_31= 'in' ( (lv_expr_32_0= ruleExp ) ) otherlv_33= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2687:7: ( (lv_name_29_0= 'let' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2688:1: (lv_name_29_0= 'let' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2688:1: (lv_name_29_0= 'let' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2689:3: lv_name_29_0= 'let'
                    {
                    lv_name_29_0=(Token)match(input,65,FOLLOW_65_in_ruleAtomicExp5364); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_29_0, grammarAccess.getAtomicExpAccess().getNameLetKeyword_8_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExpRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_29_0, "let");
                      	    
                    }

                    }


                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2702:2: ( (lv_valDecl_30_0= ruleValueDecl ) )+
                    int cnt49=0;
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==33) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2703:1: (lv_valDecl_30_0= ruleValueDecl )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2703:1: (lv_valDecl_30_0= ruleValueDecl )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2704:3: lv_valDecl_30_0= ruleValueDecl
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getValDeclValueDeclParserRuleCall_8_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleValueDecl_in_ruleAtomicExp5398);
                    	    lv_valDecl_30_0=ruleValueDecl();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"valDecl",
                    	              		lv_valDecl_30_0, 
                    	              		"ValueDecl");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt49 >= 1 ) break loop49;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(49, input);
                                throw eee;
                        }
                        cnt49++;
                    } while (true);

                    otherlv_31=(Token)match(input,66,FOLLOW_66_in_ruleAtomicExp5411); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_31, grammarAccess.getAtomicExpAccess().getInKeyword_8_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2724:1: ( (lv_expr_32_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2725:1: (lv_expr_32_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2725:1: (lv_expr_32_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2726:3: lv_expr_32_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExprExpParserRuleCall_8_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5432);
                    lv_expr_32_0=ruleExp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExpRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_32_0, 
                              		"Exp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_33=(Token)match(input,49,FOLLOW_49_in_ruleAtomicExp5444); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getAtomicExpAccess().getEndKeyword_8_4());
                          
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2754:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2755:2: (iv_ruleField= ruleField EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2756:2: iv_ruleField= ruleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_ruleField_in_entryRuleField5481);
            iv_ruleField=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleField5491); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2763:1: ruleField returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleID ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( (lv_name_4_0= ruleID ) ) ) ) ;
    public final EObject ruleField() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_exp_2_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2766:28: ( ( ( ( (lv_name_0_0= ruleID ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( (lv_name_4_0= ruleID ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2767:1: ( ( ( (lv_name_0_0= ruleID ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( (lv_name_4_0= ruleID ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2767:1: ( ( ( (lv_name_0_0= ruleID ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( (lv_name_4_0= ruleID ) ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_S||(LA51_0>=RULE_ID_WO_CONS && LA51_0<=RULE_SLASH)||LA51_0==RULE_CONS_WO_S) ) {
                alt51=1;
            }
            else if ( (LA51_0==62) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2767:2: ( ( (lv_name_0_0= ruleID ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2767:2: ( ( (lv_name_0_0= ruleID ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2767:3: ( (lv_name_0_0= ruleID ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2767:3: ( (lv_name_0_0= ruleID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2768:1: (lv_name_0_0= ruleID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2768:1: (lv_name_0_0= ruleID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2769:3: lv_name_0_0= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFieldAccess().getNameIDParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleID_in_ruleField5538);
                    lv_name_0_0=ruleID();

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
                              		"ID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleField5550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getFieldAccess().getEqualsSignKeyword_0_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2789:1: ( (lv_exp_2_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2790:1: (lv_exp_2_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2790:1: (lv_exp_2_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2791:3: lv_exp_2_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFieldAccess().getExpExpParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleField5571);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2808:6: (otherlv_3= '~' ( (lv_name_4_0= ruleID ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2808:6: (otherlv_3= '~' ( (lv_name_4_0= ruleID ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2808:8: otherlv_3= '~' ( (lv_name_4_0= ruleID ) )
                    {
                    otherlv_3=(Token)match(input,62,FOLLOW_62_in_ruleField5591); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getTildeKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2812:1: ( (lv_name_4_0= ruleID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2813:1: (lv_name_4_0= ruleID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2813:1: (lv_name_4_0= ruleID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2814:3: lv_name_4_0= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFieldAccess().getNameIDParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleID_in_ruleField5612);
                    lv_name_4_0=ruleID();

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
                              		"ID");
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2838:1: entryRuleValueDecl returns [EObject current=null] : iv_ruleValueDecl= ruleValueDecl EOF ;
    public final EObject entryRuleValueDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2839:2: (iv_ruleValueDecl= ruleValueDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2840:2: iv_ruleValueDecl= ruleValueDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueDeclRule()); 
            }
            pushFollow(FOLLOW_ruleValueDecl_in_entryRuleValueDecl5649);
            iv_ruleValueDecl=ruleValueDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueDecl5659); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2847:1: ruleValueDecl returns [EObject current=null] : (otherlv_0= 'val' ( ( ( ( ruleID ) )=> (lv_name_1_0= ruleID ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( (lv_ids_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ;
    public final EObject ruleValueDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_ids_3_0 = null;

        EObject lv_exp_5_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2850:28: ( (otherlv_0= 'val' ( ( ( ( ruleID ) )=> (lv_name_1_0= ruleID ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( (lv_ids_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2851:1: (otherlv_0= 'val' ( ( ( ( ruleID ) )=> (lv_name_1_0= ruleID ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( (lv_ids_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2851:1: (otherlv_0= 'val' ( ( ( ( ruleID ) )=> (lv_name_1_0= ruleID ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( (lv_ids_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2851:3: otherlv_0= 'val' ( ( ( ( ruleID ) )=> (lv_name_1_0= ruleID ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( (lv_ids_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleValueDecl5696); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getValueDeclAccess().getValKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2855:1: ( ( ( ( ruleID ) )=> (lv_name_1_0= ruleID ) ) | ( (lv_name_2_0= ruleSYM ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_S) && (synpred11_InternalGDSL())) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_CONS_WO_S) && (synpred11_InternalGDSL())) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_ID_WO_CONS) && (synpred11_InternalGDSL())) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_SLASH) ) {
                int LA52_4 = input.LA(2);

                if ( (synpred11_InternalGDSL()) ) {
                    alt52=1;
                }
                else if ( (true) ) {
                    alt52=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 4, input);

                    throw nvae;
                }
            }
            else if ( ((LA52_0>=RULE_LESS && LA52_0<=RULE_GREATER)||LA52_0==RULE_DOT||LA52_0==RULE_USCORE||(LA52_0>=RULE_BS && LA52_0<=RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER)) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2855:2: ( ( ( ruleID ) )=> (lv_name_1_0= ruleID ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2855:2: ( ( ( ruleID ) )=> (lv_name_1_0= ruleID ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2855:3: ( ( ruleID ) )=> (lv_name_1_0= ruleID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2860:1: (lv_name_1_0= ruleID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2861:3: lv_name_1_0= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueDeclAccess().getNameIDParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleID_in_ruleValueDecl5728);
                    lv_name_1_0=ruleID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueDeclRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"ID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2878:6: ( (lv_name_2_0= ruleSYM ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2878:6: ( (lv_name_2_0= ruleSYM ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2879:1: (lv_name_2_0= ruleSYM )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2879:1: (lv_name_2_0= ruleSYM )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2880:3: lv_name_2_0= ruleSYM
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueDeclAccess().getNameSYMParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSYM_in_ruleValueDecl5755);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2896:3: ( (lv_ids_3_0= ruleID ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_S||(LA53_0>=RULE_ID_WO_CONS && LA53_0<=RULE_SLASH)||LA53_0==RULE_CONS_WO_S) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2897:1: (lv_ids_3_0= ruleID )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2897:1: (lv_ids_3_0= ruleID )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2898:3: lv_ids_3_0= ruleID
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueDeclAccess().getIdsIDParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleID_in_ruleValueDecl5777);
            	    lv_ids_3_0=ruleID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getValueDeclRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ids",
            	              		lv_ids_3_0, 
            	              		"ID");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleValueDecl5790); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getValueDeclAccess().getEqualsSignKeyword_3());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2918:1: ( (lv_exp_5_0= ruleExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2919:1: (lv_exp_5_0= ruleExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2919:1: (lv_exp_5_0= ruleExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2920:3: lv_exp_5_0= ruleExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueDeclAccess().getExpExpParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExp_in_ruleValueDecl5811);
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


    // $ANTLR start "entryRuleDECODEPAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2944:1: entryRuleDECODEPAT returns [String current=null] : iv_ruleDECODEPAT= ruleDECODEPAT EOF ;
    public final String entryRuleDECODEPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDECODEPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2945:2: (iv_ruleDECODEPAT= ruleDECODEPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2946:2: iv_ruleDECODEPAT= ruleDECODEPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDECODEPATRule()); 
            }
            pushFollow(FOLLOW_ruleDECODEPAT_in_entryRuleDECODEPAT5848);
            iv_ruleDECODEPAT=ruleDECODEPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDECODEPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDECODEPAT5859); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2953:1: ruleDECODEPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT ) ;
    public final AntlrDatatypeRuleToken ruleDECODEPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_BITPAT_1 = null;

        AntlrDatatypeRuleToken this_TOKPAT_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2956:28: ( ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2957:1: ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2957:1: ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==67) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_S||LA55_0==RULE_HEXINT||(LA55_0>=RULE_ID_WO_CONS && LA55_0<=RULE_SLASH)||LA55_0==RULE_CONS_WO_S) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2957:2: (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2957:2: (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2958:2: kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\''
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleDECODEPAT5898); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDECODEPATAccess().getApostropheKeyword_0_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2963:1: (this_BITPAT_1= ruleBITPAT )+
                    int cnt54=0;
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==RULE_S||LA54_0==RULE_DOT||(LA54_0>=RULE_ID_WO_CONS && LA54_0<=RULE_SLASH)||LA54_0==RULE_BS||(LA54_0>=RULE_DUALS && LA54_0<=RULE_CONS_WO_S)) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2964:5: this_BITPAT_1= ruleBITPAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getDECODEPATAccess().getBITPATParserRuleCall_0_1()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_ruleBITPAT_in_ruleDECODEPAT5921);
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
                    	    if ( cnt54 >= 1 ) break loop54;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(54, input);
                                throw eee;
                        }
                        cnt54++;
                    } while (true);

                    kw=(Token)match(input,67,FOLLOW_67_in_ruleDECODEPAT5941); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDECODEPATAccess().getApostropheKeyword_0_2()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2982:5: this_TOKPAT_3= ruleTOKPAT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDECODEPATAccess().getTOKPATParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTOKPAT_in_ruleDECODEPAT5970);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3000:1: entryRuleTOKPAT returns [String current=null] : iv_ruleTOKPAT= ruleTOKPAT EOF ;
    public final String entryRuleTOKPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTOKPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3001:2: (iv_ruleTOKPAT= ruleTOKPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3002:2: iv_ruleTOKPAT= ruleTOKPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTOKPATRule()); 
            }
            pushFollow(FOLLOW_ruleTOKPAT_in_entryRuleTOKPAT6016);
            iv_ruleTOKPAT=ruleTOKPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTOKPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTOKPAT6027); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3009:1: ruleTOKPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEXINT_0= RULE_HEXINT | this_ID_1= ruleID ) ;
    public final AntlrDatatypeRuleToken ruleTOKPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEXINT_0=null;
        AntlrDatatypeRuleToken this_ID_1 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3012:28: ( (this_HEXINT_0= RULE_HEXINT | this_ID_1= ruleID ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3013:1: (this_HEXINT_0= RULE_HEXINT | this_ID_1= ruleID )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3013:1: (this_HEXINT_0= RULE_HEXINT | this_ID_1= ruleID )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_HEXINT) ) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_S||(LA56_0>=RULE_ID_WO_CONS && LA56_0<=RULE_SLASH)||LA56_0==RULE_CONS_WO_S) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3013:6: this_HEXINT_0= RULE_HEXINT
                    {
                    this_HEXINT_0=(Token)match(input,RULE_HEXINT,FOLLOW_RULE_HEXINT_in_ruleTOKPAT6067); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXINT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEXINT_0, grammarAccess.getTOKPATAccess().getHEXINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3022:5: this_ID_1= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTOKPATAccess().getIDParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleID_in_ruleTOKPAT6100);
                    this_ID_1=ruleID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_1);
                          
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
    // $ANTLR end "ruleTOKPAT"


    // $ANTLR start "entryRuleBITPAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3040:1: entryRuleBITPAT returns [String current=null] : iv_ruleBITPAT= ruleBITPAT EOF ;
    public final String entryRuleBITPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3041:2: (iv_ruleBITPAT= ruleBITPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3042:2: iv_ruleBITPAT= ruleBITPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITPATRule()); 
            }
            pushFollow(FOLLOW_ruleBITPAT_in_entryRuleBITPAT6146);
            iv_ruleBITPAT=ruleBITPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITPAT6157); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3049:1: ruleBITPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINARY_0= ruleBINARY | (this_ID_1= ruleID (this_BITPATORINT_2= ruleBITPATORINT )? ) ) ;
    public final AntlrDatatypeRuleToken ruleBITPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_BINARY_0 = null;

        AntlrDatatypeRuleToken this_ID_1 = null;

        AntlrDatatypeRuleToken this_BITPATORINT_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3052:28: ( (this_BINARY_0= ruleBINARY | (this_ID_1= ruleID (this_BITPATORINT_2= ruleBITPATORINT )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3053:1: (this_BINARY_0= ruleBINARY | (this_ID_1= ruleID (this_BITPATORINT_2= ruleBITPATORINT )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3053:1: (this_BINARY_0= ruleBINARY | (this_ID_1= ruleID (this_BITPATORINT_2= ruleBITPATORINT )? ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_DOT||LA58_0==RULE_BS||(LA58_0>=RULE_DUALS && LA58_0<=RULE_BINS)) ) {
                alt58=1;
            }
            else if ( (LA58_0==RULE_S||(LA58_0>=RULE_ID_WO_CONS && LA58_0<=RULE_SLASH)||LA58_0==RULE_CONS_WO_S) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3054:5: this_BINARY_0= ruleBINARY
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATAccess().getBINARYParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBINARY_in_ruleBITPAT6204);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3065:6: (this_ID_1= ruleID (this_BITPATORINT_2= ruleBITPATORINT )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3065:6: (this_ID_1= ruleID (this_BITPATORINT_2= ruleBITPATORINT )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3066:5: this_ID_1= ruleID (this_BITPATORINT_2= ruleBITPATORINT )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATAccess().getIDParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleID_in_ruleBITPAT6238);
                    this_ID_1=ruleID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3076:1: (this_BITPATORINT_2= ruleBITPATORINT )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==29||LA57_0==63) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3077:5: this_BITPATORINT_2= ruleBITPATORINT
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getBITPATAccess().getBITPATORINTParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBITPATORINT_in_ruleBITPAT6266);
                            this_BITPATORINT_2=ruleBITPATORINT();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_BITPATORINT_2);
                                  
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3095:1: entryRuleBITPATORINT returns [String current=null] : iv_ruleBITPATORINT= ruleBITPATORINT EOF ;
    public final String entryRuleBITPATORINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITPATORINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3096:2: (iv_ruleBITPATORINT= ruleBITPATORINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3097:2: iv_ruleBITPATORINT= ruleBITPATORINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITPATORINTRule()); 
            }
            pushFollow(FOLLOW_ruleBITPATORINT_in_entryRuleBITPATORINT6315);
            iv_ruleBITPATORINT=ruleBITPATORINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITPATORINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITPATORINT6326); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3104:1: ruleBITPATORINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) ) ;
    public final AntlrDatatypeRuleToken ruleBITPATORINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_POSINT_1 = null;

        AntlrDatatypeRuleToken this_BINARY_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3107:28: ( ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3108:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3108:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==29) ) {
                alt59=1;
            }
            else if ( (LA59_0==63) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3108:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3108:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3109:2: kw= ':' this_POSINT_1= rulePOSINT
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleBITPATORINT6365); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBITPATORINTAccess().getColonKeyword_0_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATORINTAccess().getPOSINTParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleBITPATORINT6387);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3126:6: (kw= '@' this_BINARY_3= ruleBINARY )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3126:6: (kw= '@' this_BINARY_3= ruleBINARY )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3127:2: kw= '@' this_BINARY_3= ruleBINARY
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleBITPATORINT6413); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBITPATORINTAccess().getCommercialAtKeyword_1_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATORINTAccess().getBINARYParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBINARY_in_ruleBITPATORINT6435);
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


    // $ANTLR start "entryRulePAT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3151:1: entryRulePAT returns [String current=null] : iv_rulePAT= rulePAT EOF ;
    public final String entryRulePAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3152:2: (iv_rulePAT= rulePAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3153:2: iv_rulePAT= rulePAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPATRule()); 
            }
            pushFollow(FOLLOW_rulePAT_in_entryRulePAT6482);
            iv_rulePAT=rulePAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePAT6493); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3160:1: rulePAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_USCORE_0= RULE_USCORE | ( ( ruleINTEGER )=>this_INTEGER_1= ruleINTEGER ) | ( ( ( ruleCONS )=>this_CONS_2= ruleCONS ) (this_PAT_3= rulePAT )? ) | ( ( ruleID )=>this_ID_4= ruleID ) | (kw= '\\'' this_BITPAT_6= ruleBITPAT kw= '\\'' ) ) ;
    public final AntlrDatatypeRuleToken rulePAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_USCORE_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_INTEGER_1 = null;

        AntlrDatatypeRuleToken this_CONS_2 = null;

        AntlrDatatypeRuleToken this_PAT_3 = null;

        AntlrDatatypeRuleToken this_ID_4 = null;

        AntlrDatatypeRuleToken this_BITPAT_6 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3163:28: ( (this_USCORE_0= RULE_USCORE | ( ( ruleINTEGER )=>this_INTEGER_1= ruleINTEGER ) | ( ( ( ruleCONS )=>this_CONS_2= ruleCONS ) (this_PAT_3= rulePAT )? ) | ( ( ruleID )=>this_ID_4= ruleID ) | (kw= '\\'' this_BITPAT_6= ruleBITPAT kw= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3164:1: (this_USCORE_0= RULE_USCORE | ( ( ruleINTEGER )=>this_INTEGER_1= ruleINTEGER ) | ( ( ( ruleCONS )=>this_CONS_2= ruleCONS ) (this_PAT_3= rulePAT )? ) | ( ( ruleID )=>this_ID_4= ruleID ) | (kw= '\\'' this_BITPAT_6= ruleBITPAT kw= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3164:1: (this_USCORE_0= RULE_USCORE | ( ( ruleINTEGER )=>this_INTEGER_1= ruleINTEGER ) | ( ( ( ruleCONS )=>this_CONS_2= ruleCONS ) (this_PAT_3= rulePAT )? ) | ( ( ruleID )=>this_ID_4= ruleID ) | (kw= '\\'' this_BITPAT_6= ruleBITPAT kw= '\\'' ) )
            int alt61=5;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3164:6: this_USCORE_0= RULE_USCORE
                    {
                    this_USCORE_0=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_rulePAT6533); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_USCORE_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_USCORE_0, grammarAccess.getPATAccess().getUSCORETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3172:6: ( ( ruleINTEGER )=>this_INTEGER_1= ruleINTEGER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3172:6: ( ( ruleINTEGER )=>this_INTEGER_1= ruleINTEGER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3172:7: ( ruleINTEGER )=>this_INTEGER_1= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPATAccess().getINTEGERParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_rulePAT6572);
                    this_INTEGER_1=ruleINTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INTEGER_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3184:6: ( ( ( ruleCONS )=>this_CONS_2= ruleCONS ) (this_PAT_3= rulePAT )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3184:6: ( ( ( ruleCONS )=>this_CONS_2= ruleCONS ) (this_PAT_3= rulePAT )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3184:7: ( ( ruleCONS )=>this_CONS_2= ruleCONS ) (this_PAT_3= rulePAT )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3184:7: ( ( ruleCONS )=>this_CONS_2= ruleCONS )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3184:8: ( ruleCONS )=>this_CONS_2= ruleCONS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPATAccess().getCONSParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCONS_in_rulePAT6613);
                    this_CONS_2=ruleCONS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CONS_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3195:2: (this_PAT_3= rulePAT )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==RULE_S||(LA60_0>=RULE_HEXINT && LA60_0<=RULE_SLASH)||(LA60_0>=RULE_NEGINT && LA60_0<=RULE_DUALS)||LA60_0==RULE_CONS_WO_S||LA60_0==67) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3196:5: this_PAT_3= rulePAT
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getPATAccess().getPATParserRuleCall_2_1()); 
                                  
                            }
                            pushFollow(FOLLOW_rulePAT_in_rulePAT6642);
                            this_PAT_3=rulePAT();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_PAT_3);
                                  
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
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3207:6: ( ( ruleID )=>this_ID_4= ruleID )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3207:6: ( ( ruleID )=>this_ID_4= ruleID )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3207:7: ( ruleID )=>this_ID_4= ruleID
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPATAccess().getIDParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleID_in_rulePAT6684);
                    this_ID_4=ruleID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3219:6: (kw= '\\'' this_BITPAT_6= ruleBITPAT kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3219:6: (kw= '\\'' this_BITPAT_6= ruleBITPAT kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3220:2: kw= '\\'' this_BITPAT_6= ruleBITPAT kw= '\\''
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_rulePAT6710); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPATAccess().getApostropheKeyword_4_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPATAccess().getBITPATParserRuleCall_4_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBITPAT_in_rulePAT6732);
                    this_BITPAT_6=ruleBITPAT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BITPAT_6);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    kw=(Token)match(input,67,FOLLOW_67_in_rulePAT6750); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPATAccess().getApostropheKeyword_4_2()); 
                          
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


    // $ANTLR start "entryRuleLIT"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3250:1: entryRuleLIT returns [String current=null] : iv_ruleLIT= ruleLIT EOF ;
    public final String entryRuleLIT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLIT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3251:2: (iv_ruleLIT= ruleLIT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3252:2: iv_ruleLIT= ruleLIT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLITRule()); 
            }
            pushFollow(FOLLOW_ruleLIT_in_entryRuleLIT6792);
            iv_ruleLIT=ruleLIT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLIT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLIT6803); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3259:1: ruleLIT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) ) ;
    public final AntlrDatatypeRuleToken ruleLIT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_INTEGER_0 = null;

        AntlrDatatypeRuleToken this_BINARY_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3262:28: ( (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3263:1: (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3263:1: (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_HEXINT||(LA63_0>=RULE_NEGINT && LA63_0<=RULE_DUALS)) ) {
                alt63=1;
            }
            else if ( (LA63_0==67) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3264:5: this_INTEGER_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLITAccess().getINTEGERParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleLIT6850);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3275:6: (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3275:6: (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3276:2: kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\''
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleLIT6875); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLITAccess().getApostropheKeyword_1_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3281:1: (this_BINARY_2= ruleBINARY )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==RULE_DOT||LA62_0==RULE_BS||(LA62_0>=RULE_DUALS && LA62_0<=RULE_BINS)) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3282:5: this_BINARY_2= ruleBINARY
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getLITAccess().getBINARYParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBINARY_in_ruleLIT6898);
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

                    kw=(Token)match(input,67,FOLLOW_67_in_ruleLIT6918); if (state.failed) return current;
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


    // $ANTLR start "entryRuleID"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3306:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3307:2: (iv_ruleID= ruleID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3308:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FOLLOW_ruleID_in_entryRuleID6960);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleID6971); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3315:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CONS_0= ruleCONS | this_ID_WO_CONS_1= RULE_ID_WO_CONS | this_SLASH_2= RULE_SLASH ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_WO_CONS_1=null;
        Token this_SLASH_2=null;
        AntlrDatatypeRuleToken this_CONS_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3318:28: ( (this_CONS_0= ruleCONS | this_ID_WO_CONS_1= RULE_ID_WO_CONS | this_SLASH_2= RULE_SLASH ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3319:1: (this_CONS_0= ruleCONS | this_ID_WO_CONS_1= RULE_ID_WO_CONS | this_SLASH_2= RULE_SLASH )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3319:1: (this_CONS_0= ruleCONS | this_ID_WO_CONS_1= RULE_ID_WO_CONS | this_SLASH_2= RULE_SLASH )
            int alt64=3;
            switch ( input.LA(1) ) {
            case RULE_S:
            case RULE_CONS_WO_S:
                {
                alt64=1;
                }
                break;
            case RULE_ID_WO_CONS:
                {
                alt64=2;
                }
                break;
            case RULE_SLASH:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3320:5: this_CONS_0= ruleCONS
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getIDAccess().getCONSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCONS_in_ruleID7018);
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
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3331:10: this_ID_WO_CONS_1= RULE_ID_WO_CONS
                    {
                    this_ID_WO_CONS_1=(Token)match(input,RULE_ID_WO_CONS,FOLLOW_RULE_ID_WO_CONS_in_ruleID7044); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_WO_CONS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_WO_CONS_1, grammarAccess.getIDAccess().getID_WO_CONSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3339:10: this_SLASH_2= RULE_SLASH
                    {
                    this_SLASH_2=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleID7070); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SLASH_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SLASH_2, grammarAccess.getIDAccess().getSLASHTerminalRuleCall_2()); 
                          
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
    // $ANTLR end "ruleID"


    // $ANTLR start "entryRuleMID"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3354:1: entryRuleMID returns [String current=null] : iv_ruleMID= ruleMID EOF ;
    public final String entryRuleMID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3355:2: (iv_ruleMID= ruleMID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3356:2: iv_ruleMID= ruleMID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMIDRule()); 
            }
            pushFollow(FOLLOW_ruleMID_in_entryRuleMID7116);
            iv_ruleMID=ruleMID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMID7127); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3363:1: ruleMID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE ) ;
    public final AntlrDatatypeRuleToken ruleMID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MIXID_0=null;
        Token this_USCORE_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3366:28: ( (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3367:1: (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3367:1: (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_MIXID) ) {
                alt65=1;
            }
            else if ( (LA65_0==RULE_USCORE) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3367:6: this_MIXID_0= RULE_MIXID
                    {
                    this_MIXID_0=(Token)match(input,RULE_MIXID,FOLLOW_RULE_MIXID_in_ruleMID7167); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MIXID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_MIXID_0, grammarAccess.getMIDAccess().getMIXIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3375:10: this_USCORE_1= RULE_USCORE
                    {
                    this_USCORE_1=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_ruleMID7193); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3390:1: entryRuleSYM returns [String current=null] : iv_ruleSYM= ruleSYM EOF ;
    public final String entryRuleSYM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSYM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3391:2: (iv_ruleSYM= ruleSYM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3392:2: iv_ruleSYM= ruleSYM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSYMRule()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_entryRuleSYM7239);
            iv_ruleSYM=ruleSYM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSYM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSYM7250); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3399:1: ruleSYM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_USCORE_0= RULE_USCORE | this_SLASH_1= RULE_SLASH | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT | this_LESS_4= RULE_LESS | this_GREATER_5= RULE_GREATER | this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_6= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER ) ;
    public final AntlrDatatypeRuleToken ruleSYM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_USCORE_0=null;
        Token this_SLASH_1=null;
        Token this_BS_2=null;
        Token this_DOT_3=null;
        Token this_LESS_4=null;
        Token this_GREATER_5=null;
        Token this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_6=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3402:28: ( (this_USCORE_0= RULE_USCORE | this_SLASH_1= RULE_SLASH | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT | this_LESS_4= RULE_LESS | this_GREATER_5= RULE_GREATER | this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_6= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3403:1: (this_USCORE_0= RULE_USCORE | this_SLASH_1= RULE_SLASH | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT | this_LESS_4= RULE_LESS | this_GREATER_5= RULE_GREATER | this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_6= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3403:1: (this_USCORE_0= RULE_USCORE | this_SLASH_1= RULE_SLASH | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT | this_LESS_4= RULE_LESS | this_GREATER_5= RULE_GREATER | this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_6= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER )
            int alt66=7;
            switch ( input.LA(1) ) {
            case RULE_USCORE:
                {
                alt66=1;
                }
                break;
            case RULE_SLASH:
                {
                alt66=2;
                }
                break;
            case RULE_BS:
                {
                alt66=3;
                }
                break;
            case RULE_DOT:
                {
                alt66=4;
                }
                break;
            case RULE_LESS:
                {
                alt66=5;
                }
                break;
            case RULE_GREATER:
                {
                alt66=6;
                }
                break;
            case RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER:
                {
                alt66=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3403:6: this_USCORE_0= RULE_USCORE
                    {
                    this_USCORE_0=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_ruleSYM7290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_USCORE_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_USCORE_0, grammarAccess.getSYMAccess().getUSCORETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3411:10: this_SLASH_1= RULE_SLASH
                    {
                    this_SLASH_1=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleSYM7316); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SLASH_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SLASH_1, grammarAccess.getSYMAccess().getSLASHTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3419:10: this_BS_2= RULE_BS
                    {
                    this_BS_2=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleSYM7342); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_2, grammarAccess.getSYMAccess().getBSTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3427:10: this_DOT_3= RULE_DOT
                    {
                    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSYM7368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_3, grammarAccess.getSYMAccess().getDOTTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3435:10: this_LESS_4= RULE_LESS
                    {
                    this_LESS_4=(Token)match(input,RULE_LESS,FOLLOW_RULE_LESS_in_ruleSYM7394); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LESS_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LESS_4, grammarAccess.getSYMAccess().getLESSTerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3443:10: this_GREATER_5= RULE_GREATER
                    {
                    this_GREATER_5=(Token)match(input,RULE_GREATER,FOLLOW_RULE_GREATER_in_ruleSYM7420); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_GREATER_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_GREATER_5, grammarAccess.getSYMAccess().getGREATERTerminalRuleCall_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3451:10: this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_6= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER
                    {
                    this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_6=(Token)match(input,RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER,FOLLOW_RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_in_ruleSYM7446); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_6);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_6, grammarAccess.getSYMAccess().getSYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATERTerminalRuleCall_6()); 
                          
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3466:1: entryRuleINTEGER returns [String current=null] : iv_ruleINTEGER= ruleINTEGER EOF ;
    public final String entryRuleINTEGER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTEGER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3467:2: (iv_ruleINTEGER= ruleINTEGER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3468:2: iv_ruleINTEGER= ruleINTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleINTEGER_in_entryRuleINTEGER7492);
            iv_ruleINTEGER=ruleINTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTEGER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTEGER7503); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3475:1: ruleINTEGER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT ) ;
    public final AntlrDatatypeRuleToken ruleINTEGER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEXINT_1=null;
        Token this_NEGINT_2=null;
        AntlrDatatypeRuleToken this_POSINT_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3478:28: ( (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3479:1: (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3479:1: (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT )
            int alt67=3;
            switch ( input.LA(1) ) {
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
                {
                alt67=1;
                }
                break;
            case RULE_HEXINT:
                {
                alt67=2;
                }
                break;
            case RULE_NEGINT:
                {
                alt67=3;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3480:5: this_POSINT_0= rulePOSINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getINTEGERAccess().getPOSINTParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleINTEGER7550);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3491:10: this_HEXINT_1= RULE_HEXINT
                    {
                    this_HEXINT_1=(Token)match(input,RULE_HEXINT,FOLLOW_RULE_HEXINT_in_ruleINTEGER7576); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXINT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEXINT_1, grammarAccess.getINTEGERAccess().getHEXINTTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3499:10: this_NEGINT_2= RULE_NEGINT
                    {
                    this_NEGINT_2=(Token)match(input,RULE_NEGINT,FOLLOW_RULE_NEGINT_in_ruleINTEGER7602); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3514:1: entryRulePOSINT returns [String current=null] : iv_rulePOSINT= rulePOSINT EOF ;
    public final String entryRulePOSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePOSINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3515:2: (iv_rulePOSINT= rulePOSINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3516:2: iv_rulePOSINT= rulePOSINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPOSINTRule()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT7648);
            iv_rulePOSINT=rulePOSINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePOSINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT7659); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3523:1: rulePOSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS ) ;
    public final AntlrDatatypeRuleToken rulePOSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_POSINT_WO_DUALS_0=null;
        Token this_DUALS_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3526:28: ( (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3527:1: (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3527:1: (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_POSINT_WO_DUALS) ) {
                alt68=1;
            }
            else if ( (LA68_0==RULE_DUALS) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3527:6: this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS
                    {
                    this_POSINT_WO_DUALS_0=(Token)match(input,RULE_POSINT_WO_DUALS,FOLLOW_RULE_POSINT_WO_DUALS_in_rulePOSINT7699); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_POSINT_WO_DUALS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_POSINT_WO_DUALS_0, grammarAccess.getPOSINTAccess().getPOSINT_WO_DUALSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3535:10: this_DUALS_1= RULE_DUALS
                    {
                    this_DUALS_1=(Token)match(input,RULE_DUALS,FOLLOW_RULE_DUALS_in_rulePOSINT7725); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3550:1: entryRuleBINARY returns [String current=null] : iv_ruleBINARY= ruleBINARY EOF ;
    public final String entryRuleBINARY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBINARY = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3551:2: (iv_ruleBINARY= ruleBINARY EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3552:2: iv_ruleBINARY= ruleBINARY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBINARYRule()); 
            }
            pushFollow(FOLLOW_ruleBINARY_in_entryRuleBINARY7771);
            iv_ruleBINARY=ruleBINARY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBINARY.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBINARY7782); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3559:1: ruleBINARY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT ) ;
    public final AntlrDatatypeRuleToken ruleBINARY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DUALS_0=null;
        Token this_BINS_1=null;
        Token this_BS_2=null;
        Token this_DOT_3=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3562:28: ( (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3563:1: (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3563:1: (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT )
            int alt69=4;
            switch ( input.LA(1) ) {
            case RULE_DUALS:
                {
                alt69=1;
                }
                break;
            case RULE_BINS:
                {
                alt69=2;
                }
                break;
            case RULE_BS:
                {
                alt69=3;
                }
                break;
            case RULE_DOT:
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3563:6: this_DUALS_0= RULE_DUALS
                    {
                    this_DUALS_0=(Token)match(input,RULE_DUALS,FOLLOW_RULE_DUALS_in_ruleBINARY7822); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DUALS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DUALS_0, grammarAccess.getBINARYAccess().getDUALSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3571:10: this_BINS_1= RULE_BINS
                    {
                    this_BINS_1=(Token)match(input,RULE_BINS,FOLLOW_RULE_BINS_in_ruleBINARY7848); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINS_1, grammarAccess.getBINARYAccess().getBINSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3579:10: this_BS_2= RULE_BS
                    {
                    this_BS_2=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleBINARY7874); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_2, grammarAccess.getBINARYAccess().getBSTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3587:10: this_DOT_3= RULE_DOT
                    {
                    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleBINARY7900); if (state.failed) return current;
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


    // $ANTLR start "entryRuleCONS"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3602:1: entryRuleCONS returns [String current=null] : iv_ruleCONS= ruleCONS EOF ;
    public final String entryRuleCONS() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCONS = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3603:2: (iv_ruleCONS= ruleCONS EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3604:2: iv_ruleCONS= ruleCONS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCONSRule()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS7946);
            iv_ruleCONS=ruleCONS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCONS.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS7957); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3611:1: ruleCONS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_S_0= RULE_S | this_CONS_WO_S_1= RULE_CONS_WO_S ) ;
    public final AntlrDatatypeRuleToken ruleCONS() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_S_0=null;
        Token this_CONS_WO_S_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3614:28: ( (this_S_0= RULE_S | this_CONS_WO_S_1= RULE_CONS_WO_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3615:1: (this_S_0= RULE_S | this_CONS_WO_S_1= RULE_CONS_WO_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3615:1: (this_S_0= RULE_S | this_CONS_WO_S_1= RULE_CONS_WO_S )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_S) ) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_CONS_WO_S) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3615:6: this_S_0= RULE_S
                    {
                    this_S_0=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleCONS7997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_S_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_S_0, grammarAccess.getCONSAccess().getSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3623:10: this_CONS_WO_S_1= RULE_CONS_WO_S
                    {
                    this_CONS_WO_S_1=(Token)match(input,RULE_CONS_WO_S,FOLLOW_RULE_CONS_WO_S_in_ruleCONS8023); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CONS_WO_S_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_CONS_WO_S_1, grammarAccess.getCONSAccess().getCONS_WO_STerminalRuleCall_1()); 
                          
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
    // $ANTLR end "ruleCONS"

    // $ANTLR start synpred1_InternalGDSL
    public final void synpred1_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:297:3: ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:297:4: ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:297:4: ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:297:5: ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )*
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:297:5: ( ( ruleConDecl ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:298:1: ( ruleConDecl )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:298:1: ( ruleConDecl )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:299:1: ruleConDecl
        {
        pushFollow(FOLLOW_ruleConDecl_in_synpred1_InternalGDSL612);
        ruleConDecl();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:301:2: ( '|' ( ( ruleConDecl ) ) )*
        loop71:
        do {
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==32) ) {
                alt71=1;
            }


            switch (alt71) {
        	case 1 :
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:301:4: '|' ( ( ruleConDecl ) )
        	    {
        	    match(input,32,FOLLOW_32_in_synpred1_InternalGDSL619); if (state.failed) return ;
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:302:1: ( ( ruleConDecl ) )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:303:1: ( ruleConDecl )
        	    {
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:303:1: ( ruleConDecl )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:304:1: ruleConDecl
        	    {
        	    pushFollow(FOLLOW_ruleConDecl_in_synpred1_InternalGDSL626);
        	    ruleConDecl();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop71;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred1_InternalGDSL

    // $ANTLR start synpred2_InternalGDSL
    public final void synpred2_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:458:7: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:459:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:459:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:460:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred2_InternalGDSL934);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalGDSL

    // $ANTLR start synpred3_InternalGDSL
    public final void synpred3_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:3: ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:4: ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:4: ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:5: ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:5: ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) )
        int alt72=2;
        int LA72_0 = input.LA(1);

        if ( (LA72_0==RULE_S||LA72_0==RULE_ID_WO_CONS||LA72_0==RULE_CONS_WO_S) ) {
            alt72=1;
        }
        else if ( (LA72_0==RULE_SLASH) ) {
            int LA72_2 = input.LA(2);

            if ( (true) ) {
                alt72=1;
            }
            else if ( (synpred2_InternalGDSL()) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 2, input);

                throw nvae;
            }
        }
        else if ( (LA72_0==RULE_USCORE) && (synpred2_InternalGDSL())) {
            alt72=2;
        }
        else if ( (LA72_0==RULE_BS) && (synpred2_InternalGDSL())) {
            alt72=2;
        }
        else if ( (LA72_0==RULE_DOT) && (synpred2_InternalGDSL())) {
            alt72=2;
        }
        else if ( (LA72_0==RULE_LESS) && (synpred2_InternalGDSL())) {
            alt72=2;
        }
        else if ( (LA72_0==RULE_GREATER) && (synpred2_InternalGDSL())) {
            alt72=2;
        }
        else if ( (LA72_0==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred2_InternalGDSL())) {
            alt72=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 72, 0, input);

            throw nvae;
        }
        switch (alt72) {
            case 1 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:6: ( ( ruleID ) )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:6: ( ( ruleID ) )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:1: ( ruleID )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:1: ( ruleID )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:455:1: ruleID
                {
                pushFollow(FOLLOW_ruleID_in_synpred3_InternalGDSL918);
                ruleID();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:458:6: ( ( ( ruleSYM ) )=> ( ruleSYM ) )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:458:6: ( ( ( ruleSYM ) )=> ( ruleSYM ) )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:458:7: ( ( ruleSYM ) )=> ( ruleSYM )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:463:1: ( ruleSYM )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:464:1: ruleSYM
                {
                pushFollow(FOLLOW_ruleSYM_in_synpred3_InternalGDSL943);
                ruleSYM();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:466:3: ( ( ruleID ) )*
        loop73:
        do {
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_S||(LA73_0>=RULE_ID_WO_CONS && LA73_0<=RULE_SLASH)||LA73_0==RULE_CONS_WO_S) ) {
                alt73=1;
            }


            switch (alt73) {
        	case 1 :
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:467:1: ( ruleID )
        	    {
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:467:1: ( ruleID )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:468:1: ruleID
        	    {
        	    pushFollow(FOLLOW_ruleID_in_synpred3_InternalGDSL953);
        	    ruleID();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop73;
            }
        } while (true);

        match(input,31,FOLLOW_31_in_synpred3_InternalGDSL960); if (state.failed) return ;
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:471:1: ( ( ruleExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:472:1: ( ruleExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:472:1: ( ruleExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:473:1: ruleExp
        {
        pushFollow(FOLLOW_ruleExp_in_synpred3_InternalGDSL967);
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
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:494:7: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:495:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:495:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:496:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred4_InternalGDSL1009);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalGDSL

    // $ANTLR start synpred5_InternalGDSL
    public final void synpred5_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1793:3: ( ( ruleExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1794:1: ( ruleExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1794:1: ( ruleExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1795:1: ruleExp
        {
        pushFollow(FOLLOW_ruleExp_in_synpred5_InternalGDSL3510);
        ruleExp();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalGDSL

    // $ANTLR start synpred6_InternalGDSL
    public final void synpred6_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2024:3: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2025:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2025:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2026:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred6_InternalGDSL4008);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalGDSL

    // $ANTLR start synpred7_InternalGDSL
    public final void synpred7_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2307:7: ( ( ( ruleAtomicExp ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2307:8: ( ( ruleAtomicExp ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2307:8: ( ( ruleAtomicExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2308:1: ( ruleAtomicExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2308:1: ( ruleAtomicExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2309:1: ruleAtomicExp
        {
        pushFollow(FOLLOW_ruleAtomicExp_in_synpred7_InternalGDSL4665);
        ruleAtomicExp();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred7_InternalGDSL

    // $ANTLR start synpred8_InternalGDSL
    public final void synpred8_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2388:7: ( ( ( ruleCONS ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2388:8: ( ( ruleCONS ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2388:8: ( ( ruleCONS ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2389:1: ( ruleCONS )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2389:1: ( ruleCONS )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2390:1: ruleCONS
        {
        pushFollow(FOLLOW_ruleCONS_in_synpred8_InternalGDSL4827);
        ruleCONS();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred8_InternalGDSL

    // $ANTLR start synpred9_InternalGDSL
    public final void synpred9_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2429:4: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2429:6: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred9_InternalGDSL4888); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalGDSL

    // $ANTLR start synpred10_InternalGDSL
    public final void synpred10_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2565:3: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2565:5: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred10_InternalGDSL5143); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalGDSL

    // $ANTLR start synpred11_InternalGDSL
    public final void synpred11_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2855:3: ( ( ruleID ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2856:1: ( ruleID )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2856:1: ( ruleID )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2857:1: ruleID
        {
        pushFollow(FOLLOW_ruleID_in_synpred11_InternalGDSL5711);
        ruleID();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalGDSL

    // $ANTLR start synpred12_InternalGDSL
    public final void synpred12_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3172:7: ( ruleINTEGER )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3172:9: ruleINTEGER
        {
        pushFollow(FOLLOW_ruleINTEGER_in_synpred12_InternalGDSL6556);
        ruleINTEGER();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalGDSL

    // $ANTLR start synpred13_InternalGDSL
    public final void synpred13_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3184:8: ( ruleCONS )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3184:10: ruleCONS
        {
        pushFollow(FOLLOW_ruleCONS_in_synpred13_InternalGDSL6597);
        ruleCONS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalGDSL

    // $ANTLR start synpred14_InternalGDSL
    public final void synpred14_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3207:7: ( ruleID )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3207:9: ruleID
        {
        pushFollow(FOLLOW_ruleID_in_synpred14_InternalGDSL6668);
        ruleID();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalGDSL

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
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA50 dfa50 = new DFA50(this);
    protected DFA61 dfa61 = new DFA61(this);
    static final String DFA15_eotS =
        "\16\uffff";
    static final String DFA15_eofS =
        "\16\uffff";
    static final String DFA15_minS =
        "\1\4\5\0\10\uffff";
    static final String DFA15_maxS =
        "\1\37\5\0\10\uffff";
    static final String DFA15_acceptS =
        "\6\uffff\5\1\1\2\1\uffff\1\3";
    static final String DFA15_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\10\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\1\10\1\11\1\uffff\1\7\1\uffff\1\5\1\3\1\4\1\13\1\6\1\12"+
            "\4\uffff\1\2\12\uffff\1\13",
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
            ""
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
            return "453:1: ( ( ( ( ( ( ( ruleID ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ruleID ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( (lv_name_1_0= ruleID ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( (lv_attr_3_0= ruleID ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( (lv_attr_7_0= ruleID ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( (lv_name_10_0= ruleID ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_0 = input.LA(1);

                         
                        int index15_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA15_0==RULE_S) ) {s = 1;}

                        else if ( (LA15_0==RULE_CONS_WO_S) ) {s = 2;}

                        else if ( (LA15_0==RULE_ID_WO_CONS) ) {s = 3;}

                        else if ( (LA15_0==RULE_SLASH) ) {s = 4;}

                        else if ( (LA15_0==RULE_USCORE) ) {s = 5;}

                        else if ( (LA15_0==RULE_BS) && (synpred3_InternalGDSL())) {s = 6;}

                        else if ( (LA15_0==RULE_DOT) && (synpred3_InternalGDSL())) {s = 7;}

                        else if ( (LA15_0==RULE_LESS) && (synpred3_InternalGDSL())) {s = 8;}

                        else if ( (LA15_0==RULE_GREATER) && (synpred3_InternalGDSL())) {s = 9;}

                        else if ( (LA15_0==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred3_InternalGDSL())) {s = 10;}

                        else if ( (LA15_0==RULE_MIXID||LA15_0==31) ) {s = 11;}

                         
                        input.seek(index15_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_1 = input.LA(1);

                         
                        int index15_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 10;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index15_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_2 = input.LA(1);

                         
                        int index15_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 10;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index15_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_3 = input.LA(1);

                         
                        int index15_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 10;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index15_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_4 = input.LA(1);

                         
                        int index15_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 10;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index15_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA15_5 = input.LA(1);

                         
                        int index15_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index15_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\53\uffff";
    static final String DFA33_eofS =
        "\10\uffff\4\46\37\uffff";
    static final String DFA33_minS =
        "\1\4\7\uffff\4\4\37\uffff";
    static final String DFA33_maxS =
        "\1\103\7\uffff\4\103\37\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\7\1\4\uffff\36\1\1\2";
    static final String DFA33_specialS =
        "\1\1\7\uffff\1\3\1\0\1\2\1\4\37\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\10\2\uffff\1\7\1\uffff\1\4\1\25\1\12\1\13\1\24\2\uffff\1"+
            "\5\1\2\1\3\1\uffff\1\11\24\uffff\1\17\1\uffff\1\16\4\uffff\1"+
            "\23\1\uffff\1\21\2\uffff\1\22\10\uffff\1\1\1\14\1\15\1\20\1"+
            "\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\47\1\37\1\40\1\7\1\36\1\4\1\33\1\51\1\34\1\uffff\1\35\1"+
            "\41\1\5\1\2\1\3\1\uffff\1\50\6\uffff\1\44\15\uffff\1\17\1\uffff"+
            "\1\16\5\uffff\1\45\4\uffff\1\52\1\43\1\42\1\31\1\32\1\27\1\30"+
            "\1\26\1\uffff\1\14\1\15\1\20\1\uffff\1\6",
            "\1\47\1\37\1\40\1\7\1\36\1\4\1\33\1\51\1\34\1\uffff\1\35\1"+
            "\41\1\5\1\2\1\3\1\uffff\1\50\6\uffff\1\44\15\uffff\1\17\1\uffff"+
            "\1\16\5\uffff\1\45\4\uffff\1\52\1\43\1\42\1\31\1\32\1\27\1\30"+
            "\1\26\1\uffff\1\14\1\15\1\20\1\uffff\1\6",
            "\1\47\1\37\1\40\1\7\1\36\1\4\1\33\1\51\1\34\1\uffff\1\35\1"+
            "\41\1\5\1\2\1\3\1\uffff\1\50\6\uffff\1\44\15\uffff\1\17\1\uffff"+
            "\1\16\5\uffff\1\45\4\uffff\1\52\1\43\1\42\1\31\1\32\1\27\1\30"+
            "\1\26\1\uffff\1\14\1\15\1\20\1\uffff\1\6",
            "\1\47\1\37\1\40\1\7\1\36\1\4\1\33\1\51\1\34\1\uffff\1\35\1"+
            "\41\1\5\1\2\1\3\1\uffff\1\50\6\uffff\1\44\15\uffff\1\17\1\uffff"+
            "\1\16\5\uffff\1\45\4\uffff\1\52\1\43\1\42\1\31\1\32\1\27\1\30"+
            "\1\26\1\uffff\1\14\1\15\1\20\1\uffff\1\6",
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

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "1793:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( (lv_name_1_0= ruleID ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_9 = input.LA(1);

                         
                        int index33_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA33_9==54) ) {s = 42;}

                        else if ( (LA33_9==RULE_DOT) && (synpred5_InternalGDSL())) {s = 30;}

                        else if ( (LA33_9==61) && (synpred5_InternalGDSL())) {s = 22;}

                        else if ( (LA33_9==59) && (synpred5_InternalGDSL())) {s = 23;}

                        else if ( (LA33_9==60) && (synpred5_InternalGDSL())) {s = 24;}

                        else if ( (LA33_9==57) && (synpred5_InternalGDSL())) {s = 25;}

                        else if ( (LA33_9==58) && (synpred5_InternalGDSL())) {s = 26;}

                        else if ( (LA33_9==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 27;}

                        else if ( (LA33_9==RULE_SLASH) && (synpred5_InternalGDSL())) {s = 28;}

                        else if ( (LA33_9==RULE_BS) && (synpred5_InternalGDSL())) {s = 29;}

                        else if ( (LA33_9==RULE_LESS) && (synpred5_InternalGDSL())) {s = 31;}

                        else if ( (LA33_9==RULE_GREATER) && (synpred5_InternalGDSL())) {s = 32;}

                        else if ( (LA33_9==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred5_InternalGDSL())) {s = 33;}

                        else if ( (LA33_9==56) && (synpred5_InternalGDSL())) {s = 34;}

                        else if ( (LA33_9==55) && (synpred5_InternalGDSL())) {s = 35;}

                        else if ( (LA33_9==27) && (synpred5_InternalGDSL())) {s = 36;}

                        else if ( (LA33_9==49) && (synpred5_InternalGDSL())) {s = 37;}

                        else if ( (LA33_9==EOF) && (synpred5_InternalGDSL())) {s = 38;}

                        else if ( (LA33_9==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA33_9==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA33_9==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA33_9==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA33_9==67) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA33_9==RULE_STRING) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA33_9==RULE_S) && (synpred5_InternalGDSL())) {s = 39;}

                        else if ( (LA33_9==RULE_CONS_WO_S) && (synpred5_InternalGDSL())) {s = 40;}

                        else if ( (LA33_9==RULE_ID_WO_CONS) && (synpred5_InternalGDSL())) {s = 41;}

                        else if ( (LA33_9==63) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA33_9==64) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA33_9==43) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA33_9==41) && (synpred5_InternalGDSL())) {s = 15;}

                        else if ( (LA33_9==65) && (synpred5_InternalGDSL())) {s = 16;}

                         
                        input.seek(index33_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_0 = input.LA(1);

                         
                        int index33_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA33_0==62) && (synpred5_InternalGDSL())) {s = 1;}

                        else if ( (LA33_0==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA33_0==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA33_0==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA33_0==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA33_0==67) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA33_0==RULE_STRING) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA33_0==RULE_S) ) {s = 8;}

                        else if ( (LA33_0==RULE_CONS_WO_S) ) {s = 9;}

                        else if ( (LA33_0==RULE_ID_WO_CONS) ) {s = 10;}

                        else if ( (LA33_0==RULE_SLASH) ) {s = 11;}

                        else if ( (LA33_0==63) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA33_0==64) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA33_0==43) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA33_0==41) && (synpred5_InternalGDSL())) {s = 15;}

                        else if ( (LA33_0==65) && (synpred5_InternalGDSL())) {s = 16;}

                        else if ( (LA33_0==50) && (synpred5_InternalGDSL())) {s = 17;}

                        else if ( (LA33_0==53) && (synpred5_InternalGDSL())) {s = 18;}

                        else if ( (LA33_0==48) && (synpred5_InternalGDSL())) {s = 19;}

                        else if ( (LA33_0==RULE_MIXID) && (synpred5_InternalGDSL())) {s = 20;}

                        else if ( (LA33_0==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 21;}

                         
                        input.seek(index33_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA33_10 = input.LA(1);

                         
                        int index33_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA33_10==54) ) {s = 42;}

                        else if ( (LA33_10==RULE_DOT) && (synpred5_InternalGDSL())) {s = 30;}

                        else if ( (LA33_10==61) && (synpred5_InternalGDSL())) {s = 22;}

                        else if ( (LA33_10==59) && (synpred5_InternalGDSL())) {s = 23;}

                        else if ( (LA33_10==60) && (synpred5_InternalGDSL())) {s = 24;}

                        else if ( (LA33_10==57) && (synpred5_InternalGDSL())) {s = 25;}

                        else if ( (LA33_10==58) && (synpred5_InternalGDSL())) {s = 26;}

                        else if ( (LA33_10==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 27;}

                        else if ( (LA33_10==RULE_SLASH) && (synpred5_InternalGDSL())) {s = 28;}

                        else if ( (LA33_10==RULE_BS) && (synpred5_InternalGDSL())) {s = 29;}

                        else if ( (LA33_10==RULE_LESS) && (synpred5_InternalGDSL())) {s = 31;}

                        else if ( (LA33_10==RULE_GREATER) && (synpred5_InternalGDSL())) {s = 32;}

                        else if ( (LA33_10==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred5_InternalGDSL())) {s = 33;}

                        else if ( (LA33_10==56) && (synpred5_InternalGDSL())) {s = 34;}

                        else if ( (LA33_10==55) && (synpred5_InternalGDSL())) {s = 35;}

                        else if ( (LA33_10==27) && (synpred5_InternalGDSL())) {s = 36;}

                        else if ( (LA33_10==49) && (synpred5_InternalGDSL())) {s = 37;}

                        else if ( (LA33_10==EOF) && (synpred5_InternalGDSL())) {s = 38;}

                        else if ( (LA33_10==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA33_10==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA33_10==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA33_10==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA33_10==67) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA33_10==RULE_STRING) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA33_10==RULE_S) && (synpred5_InternalGDSL())) {s = 39;}

                        else if ( (LA33_10==RULE_CONS_WO_S) && (synpred5_InternalGDSL())) {s = 40;}

                        else if ( (LA33_10==RULE_ID_WO_CONS) && (synpred5_InternalGDSL())) {s = 41;}

                        else if ( (LA33_10==63) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA33_10==64) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA33_10==43) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA33_10==41) && (synpred5_InternalGDSL())) {s = 15;}

                        else if ( (LA33_10==65) && (synpred5_InternalGDSL())) {s = 16;}

                         
                        input.seek(index33_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA33_8 = input.LA(1);

                         
                        int index33_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA33_8==61) && (synpred5_InternalGDSL())) {s = 22;}

                        else if ( (LA33_8==59) && (synpred5_InternalGDSL())) {s = 23;}

                        else if ( (LA33_8==60) && (synpred5_InternalGDSL())) {s = 24;}

                        else if ( (LA33_8==57) && (synpred5_InternalGDSL())) {s = 25;}

                        else if ( (LA33_8==58) && (synpred5_InternalGDSL())) {s = 26;}

                        else if ( (LA33_8==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 27;}

                        else if ( (LA33_8==RULE_SLASH) && (synpred5_InternalGDSL())) {s = 28;}

                        else if ( (LA33_8==RULE_BS) && (synpred5_InternalGDSL())) {s = 29;}

                        else if ( (LA33_8==RULE_DOT) && (synpred5_InternalGDSL())) {s = 30;}

                        else if ( (LA33_8==RULE_LESS) && (synpred5_InternalGDSL())) {s = 31;}

                        else if ( (LA33_8==RULE_GREATER) && (synpred5_InternalGDSL())) {s = 32;}

                        else if ( (LA33_8==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred5_InternalGDSL())) {s = 33;}

                        else if ( (LA33_8==56) && (synpred5_InternalGDSL())) {s = 34;}

                        else if ( (LA33_8==55) && (synpred5_InternalGDSL())) {s = 35;}

                        else if ( (LA33_8==27) && (synpred5_InternalGDSL())) {s = 36;}

                        else if ( (LA33_8==49) && (synpred5_InternalGDSL())) {s = 37;}

                        else if ( (LA33_8==EOF) && (synpred5_InternalGDSL())) {s = 38;}

                        else if ( (LA33_8==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA33_8==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA33_8==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA33_8==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA33_8==67) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA33_8==RULE_STRING) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA33_8==RULE_S) && (synpred5_InternalGDSL())) {s = 39;}

                        else if ( (LA33_8==RULE_CONS_WO_S) && (synpred5_InternalGDSL())) {s = 40;}

                        else if ( (LA33_8==RULE_ID_WO_CONS) && (synpred5_InternalGDSL())) {s = 41;}

                        else if ( (LA33_8==63) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA33_8==64) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA33_8==43) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA33_8==41) && (synpred5_InternalGDSL())) {s = 15;}

                        else if ( (LA33_8==65) && (synpred5_InternalGDSL())) {s = 16;}

                        else if ( (LA33_8==54) ) {s = 42;}

                         
                        input.seek(index33_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA33_11 = input.LA(1);

                         
                        int index33_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA33_11==RULE_DOT) && (synpred5_InternalGDSL())) {s = 30;}

                        else if ( (LA33_11==61) && (synpred5_InternalGDSL())) {s = 22;}

                        else if ( (LA33_11==59) && (synpred5_InternalGDSL())) {s = 23;}

                        else if ( (LA33_11==60) && (synpred5_InternalGDSL())) {s = 24;}

                        else if ( (LA33_11==57) && (synpred5_InternalGDSL())) {s = 25;}

                        else if ( (LA33_11==58) && (synpred5_InternalGDSL())) {s = 26;}

                        else if ( (LA33_11==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 27;}

                        else if ( (LA33_11==RULE_SLASH) && (synpred5_InternalGDSL())) {s = 28;}

                        else if ( (LA33_11==RULE_BS) && (synpred5_InternalGDSL())) {s = 29;}

                        else if ( (LA33_11==RULE_LESS) && (synpred5_InternalGDSL())) {s = 31;}

                        else if ( (LA33_11==RULE_GREATER) && (synpred5_InternalGDSL())) {s = 32;}

                        else if ( (LA33_11==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred5_InternalGDSL())) {s = 33;}

                        else if ( (LA33_11==56) && (synpred5_InternalGDSL())) {s = 34;}

                        else if ( (LA33_11==55) && (synpred5_InternalGDSL())) {s = 35;}

                        else if ( (LA33_11==27) && (synpred5_InternalGDSL())) {s = 36;}

                        else if ( (LA33_11==49) && (synpred5_InternalGDSL())) {s = 37;}

                        else if ( (LA33_11==EOF) && (synpred5_InternalGDSL())) {s = 38;}

                        else if ( (LA33_11==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA33_11==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA33_11==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA33_11==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA33_11==67) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA33_11==RULE_STRING) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA33_11==RULE_S) && (synpred5_InternalGDSL())) {s = 39;}

                        else if ( (LA33_11==RULE_CONS_WO_S) && (synpred5_InternalGDSL())) {s = 40;}

                        else if ( (LA33_11==RULE_ID_WO_CONS) && (synpred5_InternalGDSL())) {s = 41;}

                        else if ( (LA33_11==63) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA33_11==64) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA33_11==43) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA33_11==41) && (synpred5_InternalGDSL())) {s = 15;}

                        else if ( (LA33_11==65) && (synpred5_InternalGDSL())) {s = 16;}

                        else if ( (LA33_11==54) ) {s = 42;}

                         
                        input.seek(index33_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA36_eotS =
        "\32\uffff";
    static final String DFA36_eofS =
        "\1\1\31\uffff";
    static final String DFA36_minS =
        "\1\5\17\uffff\1\0\11\uffff";
    static final String DFA36_maxS =
        "\1\102\17\uffff\1\0\11\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\2\22\uffff\6\1";
    static final String DFA36_specialS =
        "\1\0\17\uffff\1\1\11\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\27\1\30\1\uffff\1\26\1\uffff\1\20\1\uffff\1\24\1\1\1\25\1"+
            "\31\13\uffff\2\1\1\uffff\4\1\2\uffff\2\1\4\uffff\1\1\1\uffff"+
            "\1\1\4\uffff\1\1\1\uffff\2\1\2\uffff\2\1\11\uffff\1\1",
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
            return "()* loopback of 2024:1: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*";
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
                        if ( (LA36_0==EOF||LA36_0==RULE_MIXID||(LA36_0>=27 && LA36_0<=28)||(LA36_0>=30 && LA36_0<=33)||(LA36_0>=36 && LA36_0<=37)||LA36_0==42||LA36_0==44||LA36_0==49||(LA36_0>=51 && LA36_0<=52)||(LA36_0>=55 && LA36_0<=56)||LA36_0==66) ) {s = 1;}

                        else if ( (LA36_0==RULE_USCORE) ) {s = 16;}

                        else if ( (LA36_0==RULE_SLASH) && (synpred6_InternalGDSL())) {s = 20;}

                        else if ( (LA36_0==RULE_BS) && (synpred6_InternalGDSL())) {s = 21;}

                        else if ( (LA36_0==RULE_DOT) && (synpred6_InternalGDSL())) {s = 22;}

                        else if ( (LA36_0==RULE_LESS) && (synpred6_InternalGDSL())) {s = 23;}

                        else if ( (LA36_0==RULE_GREATER) && (synpred6_InternalGDSL())) {s = 24;}

                        else if ( (LA36_0==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred6_InternalGDSL())) {s = 25;}

                         
                        input.seek(index36_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_16 = input.LA(1);

                         
                        int index36_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalGDSL()) ) {s = 25;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_16);
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
    static final String DFA42_eotS =
        "\21\uffff";
    static final String DFA42_eofS =
        "\1\1\20\uffff";
    static final String DFA42_minS =
        "\1\4\1\uffff\1\0\16\uffff";
    static final String DFA42_maxS =
        "\1\103\1\uffff\1\0\16\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\2\1\uffff\16\1";
    static final String DFA42_specialS =
        "\1\0\1\uffff\1\1\16\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\11\2\1\1\10\1\1\1\5\1\1\1\13\1\2\3\1\1\6\1\3\1\4\1\uffff"+
            "\1\12\6\uffff\2\1\1\uffff\4\1\2\uffff\2\1\3\uffff\1\17\1\1\1"+
            "\16\1\1\4\uffff\1\1\1\uffff\2\1\2\uffff\7\1\1\uffff\1\14\1\15"+
            "\1\20\1\1\1\7",
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
            "",
            "",
            "",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2307:6: ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_0 = input.LA(1);

                         
                        int index42_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA42_0==EOF||(LA42_0>=RULE_LESS && LA42_0<=RULE_GREATER)||LA42_0==RULE_DOT||LA42_0==RULE_USCORE||(LA42_0>=RULE_MIXID && LA42_0<=RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER)||(LA42_0>=27 && LA42_0<=28)||(LA42_0>=30 && LA42_0<=33)||(LA42_0>=36 && LA42_0<=37)||LA42_0==42||LA42_0==44||LA42_0==49||(LA42_0>=51 && LA42_0<=52)||(LA42_0>=55 && LA42_0<=61)||LA42_0==66) ) {s = 1;}

                        else if ( (LA42_0==RULE_SLASH) ) {s = 2;}

                        else if ( (LA42_0==RULE_POSINT_WO_DUALS) && (synpred7_InternalGDSL())) {s = 3;}

                        else if ( (LA42_0==RULE_DUALS) && (synpred7_InternalGDSL())) {s = 4;}

                        else if ( (LA42_0==RULE_HEXINT) && (synpred7_InternalGDSL())) {s = 5;}

                        else if ( (LA42_0==RULE_NEGINT) && (synpred7_InternalGDSL())) {s = 6;}

                        else if ( (LA42_0==67) && (synpred7_InternalGDSL())) {s = 7;}

                        else if ( (LA42_0==RULE_STRING) && (synpred7_InternalGDSL())) {s = 8;}

                        else if ( (LA42_0==RULE_S) && (synpred7_InternalGDSL())) {s = 9;}

                        else if ( (LA42_0==RULE_CONS_WO_S) && (synpred7_InternalGDSL())) {s = 10;}

                        else if ( (LA42_0==RULE_ID_WO_CONS) && (synpred7_InternalGDSL())) {s = 11;}

                        else if ( (LA42_0==63) && (synpred7_InternalGDSL())) {s = 12;}

                        else if ( (LA42_0==64) && (synpred7_InternalGDSL())) {s = 13;}

                        else if ( (LA42_0==43) && (synpred7_InternalGDSL())) {s = 14;}

                        else if ( (LA42_0==41) && (synpred7_InternalGDSL())) {s = 15;}

                        else if ( (LA42_0==65) && (synpred7_InternalGDSL())) {s = 16;}

                         
                        input.seek(index42_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_2 = input.LA(1);

                         
                        int index42_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_InternalGDSL()) ) {s = 16;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA50_eotS =
        "\14\uffff";
    static final String DFA50_eofS =
        "\14\uffff";
    static final String DFA50_minS =
        "\1\4\2\uffff\2\0\7\uffff";
    static final String DFA50_maxS =
        "\1\103\2\uffff\2\0\7\uffff";
    static final String DFA50_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\3";
    static final String DFA50_specialS =
        "\3\uffff\1\0\1\1\7\uffff}>";
    static final String[] DFA50_transitionS = {
            "\1\3\2\uffff\1\2\1\uffff\1\1\1\uffff\2\5\3\uffff\3\1\1\uffff"+
            "\1\4\24\uffff\1\11\1\uffff\1\10\23\uffff\1\6\1\7\1\12\1\uffff"+
            "\1\1",
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

    static final short[] DFA50_eot = DFA.unpackEncodedString(DFA50_eotS);
    static final short[] DFA50_eof = DFA.unpackEncodedString(DFA50_eofS);
    static final char[] DFA50_min = DFA.unpackEncodedStringToUnsignedChars(DFA50_minS);
    static final char[] DFA50_max = DFA.unpackEncodedStringToUnsignedChars(DFA50_maxS);
    static final short[] DFA50_accept = DFA.unpackEncodedString(DFA50_acceptS);
    static final short[] DFA50_special = DFA.unpackEncodedString(DFA50_specialS);
    static final short[][] DFA50_transition;

    static {
        int numStates = DFA50_transitionS.length;
        DFA50_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA50_transition[i] = DFA.unpackEncodedString(DFA50_transitionS[i]);
        }
    }

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = DFA50_eot;
            this.eof = DFA50_eof;
            this.min = DFA50_min;
            this.max = DFA50_max;
            this.accept = DFA50_accept;
            this.special = DFA50_special;
            this.transition = DFA50_transition;
        }
        public String getDescription() {
            return "2350:1: ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( ( ruleCONS ) ) )=> ( (lv_name_2_0= ruleCONS ) ) ) | ( ( (lv_name_3_0= ruleID ) ) ( ( ( RULE_DOT )=>this_DOT_4= RULE_DOT ) ( (lv_id_5_0= ruleID ) ) )* ) | ( ( (lv_name_6_0= '@' ) ) otherlv_7= '{' ( (lv_fields_8_0= ruleField ) ) (otherlv_9= ',' ( (lv_fields_10_0= ruleField ) ) )* otherlv_11= '}' ) | (otherlv_12= '$' ( (lv_name_13_0= ruleID ) ) ) | (otherlv_14= '(' ( (lv_expr_15_0= ruleExp ) ) otherlv_16= ')' ( ( ( RULE_DOT )=>this_DOT_17= RULE_DOT ) ( (lv_id_18_0= ruleID ) ) )* ) | ( () otherlv_20= '{' ( ( (lv_id_21_0= ruleID ) ) otherlv_22= '=' ( (lv_exps_23_0= ruleExp ) ) (otherlv_24= ',' ( (lv_id_25_0= ruleID ) ) otherlv_26= '=' ( (lv_exps_27_0= ruleExp ) ) )* )? otherlv_28= '}' ) | ( ( (lv_name_29_0= 'let' ) ) ( (lv_valDecl_30_0= ruleValueDecl ) )+ otherlv_31= 'in' ( (lv_expr_32_0= ruleExp ) ) otherlv_33= 'end' ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA50_3 = input.LA(1);

                         
                        int index50_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGDSL()) ) {s = 11;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index50_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA50_4 = input.LA(1);

                         
                        int index50_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalGDSL()) ) {s = 11;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index50_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 50, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\14\uffff";
    static final String DFA61_eofS =
        "\14\uffff";
    static final String DFA61_minS =
        "\1\4\5\uffff\2\0\4\uffff";
    static final String DFA61_maxS =
        "\1\103\5\uffff\2\0\4\uffff";
    static final String DFA61_acceptS =
        "\1\uffff\1\1\4\2\2\uffff\2\4\1\5\1\3";
    static final String DFA61_specialS =
        "\1\1\5\uffff\1\0\1\2\4\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\6\4\uffff\1\4\1\1\1\10\1\11\3\uffff\1\5\1\2\1\3\1\uffff\1"+
            "\7\56\uffff\1\12",
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
            ""
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "3164:1: (this_USCORE_0= RULE_USCORE | ( ( ruleINTEGER )=>this_INTEGER_1= ruleINTEGER ) | ( ( ( ruleCONS )=>this_CONS_2= ruleCONS ) (this_PAT_3= rulePAT )? ) | ( ( ruleID )=>this_ID_4= ruleID ) | (kw= '\\'' this_BITPAT_6= ruleBITPAT kw= '\\'' ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_6 = input.LA(1);

                         
                        int index61_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalGDSL()) ) {s = 11;}

                        else if ( (synpred14_InternalGDSL()) ) {s = 9;}

                         
                        input.seek(index61_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_0 = input.LA(1);

                         
                        int index61_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA61_0==RULE_USCORE) ) {s = 1;}

                        else if ( (LA61_0==RULE_POSINT_WO_DUALS) && (synpred12_InternalGDSL())) {s = 2;}

                        else if ( (LA61_0==RULE_DUALS) && (synpred12_InternalGDSL())) {s = 3;}

                        else if ( (LA61_0==RULE_HEXINT) && (synpred12_InternalGDSL())) {s = 4;}

                        else if ( (LA61_0==RULE_NEGINT) && (synpred12_InternalGDSL())) {s = 5;}

                        else if ( (LA61_0==RULE_S) ) {s = 6;}

                        else if ( (LA61_0==RULE_CONS_WO_S) ) {s = 7;}

                        else if ( (LA61_0==RULE_ID_WO_CONS) && (synpred14_InternalGDSL())) {s = 8;}

                        else if ( (LA61_0==RULE_SLASH) && (synpred14_InternalGDSL())) {s = 9;}

                        else if ( (LA61_0==67) ) {s = 10;}

                         
                        input.seek(index61_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_7 = input.LA(1);

                         
                        int index61_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalGDSL()) ) {s = 11;}

                        else if ( (synpred14_InternalGDSL()) ) {s = 9;}

                         
                        input.seek(index61_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel131 = new BitSet(new long[]{0x0000000258000002L});
    public static final BitSet FOLLOW_27_in_ruleModel145 = new BitSet(new long[]{0x0000000258000000L});
    public static final BitSet FOLLOW_ruleDecl_in_ruleModel168 = new BitSet(new long[]{0x0000000258000002L});
    public static final BitSet FOLLOW_ruleDecl_in_entryRuleDecl206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecl216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_ruleDecl263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_ruleDecl290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_ruleDecl317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclExport_in_entryRuleDeclExport352 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclExport362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDeclExport399 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleDeclExport422 = new BitSet(new long[]{0x0000000420000000L});
    public static final BitSet FOLLOW_ruleTyVars_in_ruleDeclExport443 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclExport456 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclExport477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDeclType560 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleDeclType581 = new BitSet(new long[]{0x0000000480000000L});
    public static final BitSet FOLLOW_31_in_ruleDeclType595 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType649 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleDeclType662 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType683 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclType714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyVars_in_ruleDeclType744 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleDeclType756 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType778 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleDeclType791 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType812 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleDeclVal900 = new BitSet(new long[]{0x000000008010FD70L});
    public static final BitSet FOLLOW_ruleID_in_ruleDeclVal989 = new BitSet(new long[]{0x0000000080101810L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleDeclVal1026 = new BitSet(new long[]{0x0000000080101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleDeclVal1048 = new BitSet(new long[]{0x0000000080101810L});
    public static final BitSet FOLLOW_31_in_ruleDeclVal1061 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_ruleDeclVal1113 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleDeclVal1134 = new BitSet(new long[]{0x0000000080002400L});
    public static final BitSet FOLLOW_31_in_ruleDeclVal1148 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleDeclVal1198 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleDeclVal1210 = new BitSet(new long[]{0x0000000800101A10L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleDECODEPAT_in_ruleDeclVal1231 = new BitSet(new long[]{0x0000000800101A10L,0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_ruleDeclVal1244 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_31_in_ruleDeclVal1258 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleDeclVal1299 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1320 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleDeclVal1332 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1353 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleTyVars_in_entryRuleTyVars1394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyVars1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleTyVars1441 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleTyVar_in_ruleTyVars1462 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_ruleTyVars1475 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleTyVar_in_ruleTyVars1496 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_ruleTyVars1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyVar_in_entryRuleTyVar1546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyVar1556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleTyVar1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl1636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConDecl1692 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleConDecl1705 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleConDecl1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy1764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleTy1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleTy1851 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_38_in_ruleTy1877 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_39_in_ruleTy1906 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_40_in_ruleTy1935 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleTy1965 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy1986 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_36_in_ruleTy1999 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2020 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35_in_ruleTy2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleTy2065 = new BitSet(new long[]{0x0000040000101810L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2087 = new BitSet(new long[]{0x0000041000000000L});
    public static final BitSet FOLLOW_36_in_ruleTy2100 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2121 = new BitSet(new long[]{0x0000041000000000L});
    public static final BitSet FOLLOW_42_in_ruleTy2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleTy2157 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2178 = new BitSet(new long[]{0x0000101000000000L});
    public static final BitSet FOLLOW_36_in_ruleTy2191 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2212 = new BitSet(new long[]{0x0000101000000000L});
    public static final BitSet FOLLOW_44_in_ruleTy2226 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleTy2238 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleTy2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTy2307 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2327 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LESS_in_ruleTy2338 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2358 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleTy2370 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2391 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_GREATER_in_ruleTy2402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind2438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleTyBind2494 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleTyBind2507 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyBind2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement2566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleTyElement2622 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleTyElement2634 = new BitSet(new long[]{0x00004BC000171A10L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyElement2655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp2691 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp2701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_ruleExp2775 = new BitSet(new long[]{0xC0250A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp2796 = new BitSet(new long[]{0x0000000000002402L});
    public static final BitSet FOLLOW_ruleCaseExp_in_entryRuleCaseExp2834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseExp2844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleCaseExp2915 = new BitSet(new long[]{0xC0240A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp2949 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleCaseExp2961 = new BitSet(new long[]{0x0000000000171E10L,0x0000000000000008L});
    public static final BitSet FOLLOW_rulePAT_in_ruleCaseExp2983 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleCaseExp2995 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleCaseExp3016 = new BitSet(new long[]{0x0002000100000000L});
    public static final BitSet FOLLOW_32_in_ruleCaseExp3029 = new BitSet(new long[]{0x0000000000171E10L,0x0000000000000008L});
    public static final BitSet FOLLOW_rulePAT_in_ruleCaseExp3050 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleCaseExp3062 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleCaseExp3083 = new BitSet(new long[]{0x0002000100000000L});
    public static final BitSet FOLLOW_49_in_ruleCaseExp3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_entryRuleClosedExp3135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedExp3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_ruleClosedExp3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleClosedExp3216 = new BitSet(new long[]{0xC0250A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3250 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleClosedExp3262 = new BitSet(new long[]{0xC0250A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3283 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleClosedExp3295 = new BitSet(new long[]{0xC0250A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleClosedExp3342 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3376 = new BitSet(new long[]{0x0002000008000000L});
    public static final BitSet FOLLOW_27_in_ruleClosedExp3389 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3410 = new BitSet(new long[]{0x0002000008000000L});
    public static final BitSet FOLLOW_49_in_ruleClosedExp3424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonadicExp3471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleMonadicExp3555 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleMonadicExp3567 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrElseExp3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3682 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleOrElseExp3709 = new BitSet(new long[]{0xC0000A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3743 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp3781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndAlsoExp3791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp3838 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_56_in_ruleAndAlsoExp3865 = new BitSet(new long[]{0xC0000A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp3899 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_entryRuleRExp3937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRExp3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp3994 = new BitSet(new long[]{0x000000000010DD72L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleRExp4025 = new BitSet(new long[]{0xC0000A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp4046 = new BitSet(new long[]{0x000000000010DD72L});
    public static final BitSet FOLLOW_ruleAExp_in_entryRuleAExp4084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExp4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4141 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_57_in_ruleAExp4161 = new BitSet(new long[]{0xC0000A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_58_in_ruleAExp4190 = new BitSet(new long[]{0xC0000A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4227 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_entryRuleMExp4265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMExp4275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectExp_in_ruleMExp4322 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleMExp4342 = new BitSet(new long[]{0xC0000A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_60_in_ruleMExp4371 = new BitSet(new long[]{0xC0000A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleMExp4408 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_ruleSelectExp_in_entryRuleSelectExp4446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectExp4456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleSelectExp4503 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleSelectExp4515 = new BitSet(new long[]{0xC0000A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleSelectExp4536 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_entryRuleApplyExp4574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleApplyExp4584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleApplyExp4622 = new BitSet(new long[]{0xC0000A0000171A90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleApplyExp4644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleApplyExp4684 = new BitSet(new long[]{0xC0000A0000171A92L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp4722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicExp4732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLIT_in_ruleAtomicExp4778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAtomicExp4801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleAtomicExp4846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleAtomicExp4875 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp4893 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleAtomicExp4914 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_63_in_ruleAtomicExp4942 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleAtomicExp4967 = new BitSet(new long[]{0x4000000000101810L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp4988 = new BitSet(new long[]{0x0000041000000000L});
    public static final BitSet FOLLOW_36_in_ruleAtomicExp5001 = new BitSet(new long[]{0x4000000000101810L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp5022 = new BitSet(new long[]{0x0000041000000000L});
    public static final BitSet FOLLOW_42_in_ruleAtomicExp5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleAtomicExp5056 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleAtomicExp5077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleAtomicExp5097 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5118 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleAtomicExp5130 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp5148 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleAtomicExp5169 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_41_in_ruleAtomicExp5200 = new BitSet(new long[]{0x0000040000101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleAtomicExp5222 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAtomicExp5234 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5255 = new BitSet(new long[]{0x0000041000000000L});
    public static final BitSet FOLLOW_36_in_ruleAtomicExp5268 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleAtomicExp5289 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAtomicExp5301 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5322 = new BitSet(new long[]{0x0000041000000000L});
    public static final BitSet FOLLOW_42_in_ruleAtomicExp5338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAtomicExp5364 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ruleValueDecl_in_ruleAtomicExp5398 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleAtomicExp5411 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5432 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleAtomicExp5444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleField_in_entryRuleField5481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleField5491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleField5538 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleField5550 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleField5571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleField5591 = new BitSet(new long[]{0x0000000000101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleField5612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueDecl_in_entryRuleValueDecl5649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueDecl5659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleValueDecl5696 = new BitSet(new long[]{0x000000000010DD70L});
    public static final BitSet FOLLOW_ruleID_in_ruleValueDecl5728 = new BitSet(new long[]{0x0000000080101810L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleValueDecl5755 = new BitSet(new long[]{0x0000000080101810L});
    public static final BitSet FOLLOW_ruleID_in_ruleValueDecl5777 = new BitSet(new long[]{0x0000000080101810L});
    public static final BitSet FOLLOW_31_in_ruleValueDecl5790 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_ruleValueDecl5811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECODEPAT_in_entryRuleDECODEPAT5848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDECODEPAT5859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleDECODEPAT5898 = new BitSet(new long[]{0x00000000001C5910L});
    public static final BitSet FOLLOW_ruleBITPAT_in_ruleDECODEPAT5921 = new BitSet(new long[]{0x00000000001C5910L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleDECODEPAT5941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTOKPAT_in_ruleDECODEPAT5970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTOKPAT_in_entryRuleTOKPAT6016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTOKPAT6027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXINT_in_ruleTOKPAT6067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleTOKPAT6100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITPAT_in_entryRuleBITPAT6146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITPAT6157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITPAT6204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_ruleBITPAT6238 = new BitSet(new long[]{0x8000000020000002L});
    public static final BitSet FOLLOW_ruleBITPATORINT_in_ruleBITPAT6266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITPATORINT_in_entryRuleBITPATORINT6315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITPATORINT6326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBITPATORINT6365 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleBITPATORINT6387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleBITPATORINT6413 = new BitSet(new long[]{0x00000000000C4100L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITPATORINT6435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_entryRulePAT6482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePAT6493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_rulePAT6533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_rulePAT6572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_rulePAT6613 = new BitSet(new long[]{0x0000000000171E12L,0x0000000000000008L});
    public static final BitSet FOLLOW_rulePAT_in_rulePAT6642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_rulePAT6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_rulePAT6710 = new BitSet(new long[]{0x00000000001C5910L});
    public static final BitSet FOLLOW_ruleBITPAT_in_rulePAT6732 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_rulePAT6750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLIT_in_entryRuleLIT6792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLIT6803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleLIT6850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleLIT6875 = new BitSet(new long[]{0x00000000000C4100L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleLIT6898 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleLIT6918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_entryRuleID6960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleID6971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleID7018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_WO_CONS_in_ruleID7044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleID7070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_entryRuleMID7116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMID7127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIXID_in_ruleMID7167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_ruleMID7193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_entryRuleSYM7239 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSYM7250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_ruleSYM7290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleSYM7316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleSYM7342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSYM7368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LESS_in_ruleSYM7394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_GREATER_in_ruleSYM7420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_in_ruleSYM7446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_entryRuleINTEGER7492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTEGER7503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleINTEGER7550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXINT_in_ruleINTEGER7576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEGINT_in_ruleINTEGER7602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT7648 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT7659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_POSINT_WO_DUALS_in_rulePOSINT7699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DUALS_in_rulePOSINT7725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_entryRuleBINARY7771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBINARY7782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DUALS_in_ruleBINARY7822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINS_in_ruleBINARY7848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleBINARY7874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleBINARY7900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS7946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS7957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleCONS7997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CONS_WO_S_in_ruleCONS8023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_synpred1_InternalGDSL612 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_synpred1_InternalGDSL619 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleConDecl_in_synpred1_InternalGDSL626 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred2_InternalGDSL934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_synpred3_InternalGDSL918 = new BitSet(new long[]{0x0000000080101810L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred3_InternalGDSL943 = new BitSet(new long[]{0x0000000080101810L});
    public static final BitSet FOLLOW_ruleID_in_synpred3_InternalGDSL953 = new BitSet(new long[]{0x0000000080101810L});
    public static final BitSet FOLLOW_31_in_synpred3_InternalGDSL960 = new BitSet(new long[]{0xC0250A0000173E90L,0x000000000000000BL});
    public static final BitSet FOLLOW_ruleExp_in_synpred3_InternalGDSL967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred4_InternalGDSL1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_synpred5_InternalGDSL3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred6_InternalGDSL4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_synpred7_InternalGDSL4665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_synpred8_InternalGDSL4827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred9_InternalGDSL4888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred10_InternalGDSL5143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_synpred11_InternalGDSL5711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_synpred12_InternalGDSL6556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_synpred13_InternalGDSL6597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleID_in_synpred14_InternalGDSL6668 = new BitSet(new long[]{0x0000000000000002L});

}