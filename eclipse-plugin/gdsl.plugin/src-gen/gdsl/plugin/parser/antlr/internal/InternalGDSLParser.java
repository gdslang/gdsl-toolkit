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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_S", "RULE_LESS", "RULE_GREATER", "RULE_STRING", "RULE_DOT", "RULE_USCORE", "RULE_HEXINT", "RULE_MIXID", "RULE_BS", "RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER", "RULE_NEGINT", "RULE_POSINT_WO_DUALS", "RULE_DUALS", "RULE_BINS", "RULE_IDCHAR", "RULE_CHARSYM", "RULE_OTHERSYM", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "';'", "'export'", "':'", "'type'", "'='", "'|'", "'val'", "'['", "']'", "','", "'of'", "'int'", "'string'", "'unit'", "'{'", "'}'", "'('", "')'", "'->'", "'()'", "'=>'", "'case'", "'end'", "'if'", "'then'", "'else'", "'do'", "'<-'", "'or'", "'and'", "'+'", "'-'", "'*'", "'%'", "'^'", "'~'", "'@'", "'$'", "'let'", "'in'", "'\\''"
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
    public static final int RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER=14;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int RULE_DOT=9;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_IDCHAR=19;
    public static final int T__59=59;
    public static final int RULE_S=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int RULE_GREATER=7;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_USCORE=10;
    public static final int RULE_SL_COMMENT=24;
    public static final int RULE_HEXINT=11;
    public static final int RULE_ML_COMMENT=23;
    public static final int RULE_BS=13;
    public static final int RULE_BINS=18;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=8;
    public static final int T__32=32;
    public static final int RULE_MIXID=12;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_OTHERSYM=21;
    public static final int T__39=39;
    public static final int RULE_NEGINT=15;
    public static final int RULE_DUALS=17;
    public static final int RULE_LESS=6;
    public static final int RULE_CHARSYM=20;
    public static final int RULE_WS=22;
    public static final int RULE_POSINT_WO_DUALS=16;

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

              		newLeafNode(otherlv_1, grammarAccess.getDeclExportAccess().getNameDeclValCrossReference_1_0()); 
              	
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:265:1: ruleDeclType returns [EObject current=null] : (otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) ) ) ;
    public final EObject ruleDeclType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_conDecl_3_0 = null;

        EObject lv_conDecl_5_0 = null;

        EObject lv_value_6_0 = null;

        EObject lv_tyVars_7_0 = null;

        EObject lv_conDecl_9_0 = null;

        EObject lv_conDecl_11_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:268:28: ( (otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:269:1: (otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:269:1: (otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:269:3: otherlv_0= 'type' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) )
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:309:2: ( (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) ) | ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==29) ) {
                alt9=1;
            }
            else if ( (LA9_0==32) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:309:3: (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:309:3: (otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:309:5: otherlv_2= '=' ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) )
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleDeclType618); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_0_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:1: ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) )
                    int alt7=2;
                    alt7 = dfa7.predict(input);
                    switch (alt7) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:2: ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:2: ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:3: ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:8: ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:9: ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:322:9: ( (lv_conDecl_3_0= ruleConDecl ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:323:1: (lv_conDecl_3_0= ruleConDecl )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:323:1: (lv_conDecl_3_0= ruleConDecl )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:324:3: lv_conDecl_3_0= ruleConDecl
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_2_0_1_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType672);
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:340:2: (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )*
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( (LA6_0==30) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:340:4: otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) )
                            	    {
                            	    otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleDeclType685); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_4, grammarAccess.getDeclTypeAccess().getVerticalLineKeyword_2_0_1_0_0_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:344:1: ( (lv_conDecl_5_0= ruleConDecl ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:345:1: (lv_conDecl_5_0= ruleConDecl )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:345:1: (lv_conDecl_5_0= ruleConDecl )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:346:3: lv_conDecl_5_0= ruleConDecl
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_2_0_1_0_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType706);
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
                            	    break loop6;
                                }
                            } while (true);


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:363:6: ( (lv_value_6_0= ruleTy ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:363:6: ( (lv_value_6_0= ruleTy ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:364:1: (lv_value_6_0= ruleTy )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:364:1: (lv_value_6_0= ruleTy )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:365:3: lv_value_6_0= ruleTy
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclTypeAccess().getValueTyParserRuleCall_2_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTy_in_ruleDeclType737);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:382:6: ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:382:6: ( ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:382:7: ( (lv_tyVars_7_0= ruleTyVars ) ) otherlv_8= '=' ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:382:7: ( (lv_tyVars_7_0= ruleTyVars ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:383:1: (lv_tyVars_7_0= ruleTyVars )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:383:1: (lv_tyVars_7_0= ruleTyVars )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:384:3: lv_tyVars_7_0= ruleTyVars
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getTyVarsTyVarsParserRuleCall_2_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTyVars_in_ruleDeclType767);
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

                    otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleDeclType779); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDeclTypeAccess().getEqualsSignKeyword_2_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:404:1: ( ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:404:2: ( (lv_conDecl_9_0= ruleConDecl ) ) (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:404:2: ( (lv_conDecl_9_0= ruleConDecl ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:405:1: (lv_conDecl_9_0= ruleConDecl )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:405:1: (lv_conDecl_9_0= ruleConDecl )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:406:3: lv_conDecl_9_0= ruleConDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_2_1_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType801);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:422:2: (otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==30) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:422:4: otherlv_10= '|' ( (lv_conDecl_11_0= ruleConDecl ) )
                    	    {
                    	    otherlv_10=(Token)match(input,30,FOLLOW_30_in_ruleDeclType814); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getDeclTypeAccess().getVerticalLineKeyword_2_1_2_1_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:426:1: ( (lv_conDecl_11_0= ruleConDecl ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:427:1: (lv_conDecl_11_0= ruleConDecl )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:427:1: (lv_conDecl_11_0= ruleConDecl )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:428:3: lv_conDecl_11_0= ruleConDecl
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclTypeAccess().getConDeclConDeclParserRuleCall_2_1_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleConDecl_in_ruleDeclType835);
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
                    	    break loop8;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:452:1: entryRuleDeclVal returns [EObject current=null] : iv_ruleDeclVal= ruleDeclVal EOF ;
    public final EObject entryRuleDeclVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclVal = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:453:2: (iv_ruleDeclVal= ruleDeclVal EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:454:2: iv_ruleDeclVal= ruleDeclVal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclValRule()); 
            }
            pushFollow(FOLLOW_ruleDeclVal_in_entryRuleDeclVal876);
            iv_ruleDeclVal=ruleDeclVal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclVal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclVal886); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:461:1: ruleDeclVal returns [EObject current=null] : (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:464:28: ( (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:465:1: (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:465:1: (otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:465:3: otherlv_0= 'val' ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleDeclVal923); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDeclValAccess().getValKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:1: ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )
            int alt20=3;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:2: ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:2: ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:3: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:503:6: ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:503:7: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:503:7: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_S)) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==RULE_USCORE) && (synpred4_InternalGDSL())) {
                        alt11=2;
                    }
                    else if ( (LA11_0==RULE_BS) && (synpred4_InternalGDSL())) {
                        alt11=2;
                    }
                    else if ( (LA11_0==RULE_DOT) && (synpred4_InternalGDSL())) {
                        alt11=2;
                    }
                    else if ( (LA11_0==RULE_LESS) && (synpred4_InternalGDSL())) {
                        alt11=2;
                    }
                    else if ( (LA11_0==RULE_GREATER) && (synpred4_InternalGDSL())) {
                        alt11=2;
                    }
                    else if ( (LA11_0==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred4_InternalGDSL())) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:503:8: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:503:8: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:504:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:504:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:505:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:505:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0==RULE_ID) ) {
                                alt10=1;
                            }
                            else if ( (LA10_0==RULE_S) ) {
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:506:3: lv_name_1_1= RULE_ID
                                    {
                                    lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1042); if (state.failed) return current;
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:521:8: lv_name_1_2= RULE_S
                                    {
                                    lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1062); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:540:6: ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:540:6: ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:540:7: ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:545:1: (lv_name_2_0= ruleSYM )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:546:3: lv_name_2_0= ruleSYM
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getNameSYMParserRuleCall_1_0_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleSYM_in_ruleDeclVal1107);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:562:3: ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_S)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:563:1: ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:563:1: ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:564:1: (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:564:1: (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S )
                    	    int alt12=2;
                    	    int LA12_0 = input.LA(1);

                    	    if ( (LA12_0==RULE_ID) ) {
                    	        alt12=1;
                    	    }
                    	    else if ( (LA12_0==RULE_S) ) {
                    	        alt12=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 12, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt12) {
                    	        case 1 :
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:565:3: lv_attr_3_1= RULE_ID
                    	            {
                    	            lv_attr_3_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1127); if (state.failed) return current;
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:580:8: lv_attr_3_2= RULE_S
                    	            {
                    	            lv_attr_3_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1147); if (state.failed) return current;
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
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1168); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_0_0_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:602:1: ( (lv_exp_5_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:603:1: (lv_exp_5_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:603:1: (lv_exp_5_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:604:3: lv_exp_5_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_0_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1189);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:621:6: ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:621:6: ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:621:7: ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:621:7: ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_USCORE||LA15_0==RULE_MIXID) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:621:8: ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:621:8: ( (lv_mid_6_0= ruleMID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:622:1: (lv_mid_6_0= ruleMID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:622:1: (lv_mid_6_0= ruleMID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:623:3: lv_mid_6_0= ruleMID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getMidMIDParserRuleCall_1_1_0_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMID_in_ruleDeclVal1220);
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

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:639:2: ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:640:1: ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:640:1: ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:641:1: (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:641:1: (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S )
                    	    int alt14=2;
                    	    int LA14_0 = input.LA(1);

                    	    if ( (LA14_0==RULE_ID) ) {
                    	        alt14=1;
                    	    }
                    	    else if ( (LA14_0==RULE_S) ) {
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:642:3: lv_attr_7_1= RULE_ID
                    	            {
                    	            lv_attr_7_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1239); if (state.failed) return current;
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:657:8: lv_attr_7_2= RULE_S
                    	            {
                    	            lv_attr_7_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1259); if (state.failed) return current;
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
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1281); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:679:1: ( (lv_exp_9_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:680:1: (lv_exp_9_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:680:1: (lv_exp_9_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:681:3: lv_exp_9_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1302);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:698:6: ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:698:6: ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:698:7: ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:698:7: ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:699:1: ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:699:1: ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:700:1: (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:700:1: (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_ID) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==RULE_S) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:701:3: lv_name_10_1= RULE_ID
                            {
                            lv_name_10_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclVal1329); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:716:8: lv_name_10_2= RULE_S
                            {
                            lv_name_10_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleDeclVal1349); if (state.failed) return current;
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

                    otherlv_11=(Token)match(input,32,FOLLOW_32_in_ruleDeclVal1369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDeclValAccess().getLeftSquareBracketKeyword_1_2_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:738:1: ( (lv_decPat_12_0= ruleDECODEPAT ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_S)||LA17_0==RULE_HEXINT||LA17_0==65) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:739:1: (lv_decPat_12_0= ruleDECODEPAT )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:739:1: (lv_decPat_12_0= ruleDECODEPAT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:740:3: lv_decPat_12_0= ruleDECODEPAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDeclValAccess().getDecPatDECODEPATParserRuleCall_1_2_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleDECODEPAT_in_ruleDeclVal1390);
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
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,33,FOLLOW_33_in_ruleDeclVal1403); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getDeclValAccess().getRightSquareBracketKeyword_1_2_3());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:760:1: ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==29) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==30) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:760:2: (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:760:2: (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:760:4: otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) )
                            {
                            otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1417); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_2_4_0_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:764:1: ( (lv_exp_15_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:765:1: (lv_exp_15_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:765:1: (lv_exp_15_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:766:3: lv_exp_15_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getDeclValAccess().getExpExpParserRuleCall_1_2_4_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1438);
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:783:6: (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:783:6: (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+
                            int cnt18=0;
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==30) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:783:8: otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) )
                            	    {
                            	    otherlv_16=(Token)match(input,30,FOLLOW_30_in_ruleDeclVal1458); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_16, grammarAccess.getDeclValAccess().getVerticalLineKeyword_1_2_4_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:787:1: ( (lv_exps_17_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:788:1: (lv_exps_17_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:788:1: (lv_exps_17_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:789:3: lv_exps_17_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_2_4_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1479);
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

                            	    otherlv_18=(Token)match(input,29,FOLLOW_29_in_ruleDeclVal1491); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_18, grammarAccess.getDeclValAccess().getEqualsSignKeyword_1_2_4_1_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:809:1: ( (lv_exps_19_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:810:1: (lv_exps_19_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:810:1: (lv_exps_19_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:811:3: lv_exps_19_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDeclValAccess().getExpsExpParserRuleCall_1_2_4_1_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleDeclVal1512);
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
                            	    if ( cnt18 >= 1 ) break loop18;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(18, input);
                                        throw eee;
                                }
                                cnt18++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:835:1: entryRuleTyVars returns [EObject current=null] : iv_ruleTyVars= ruleTyVars EOF ;
    public final EObject entryRuleTyVars() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyVars = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:836:2: (iv_ruleTyVars= ruleTyVars EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:837:2: iv_ruleTyVars= ruleTyVars EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyVarsRule()); 
            }
            pushFollow(FOLLOW_ruleTyVars_in_entryRuleTyVars1553);
            iv_ruleTyVars=ruleTyVars();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyVars; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyVars1563); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:844:1: ruleTyVars returns [EObject current=null] : (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleTyVars() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attr_1_0 = null;

        EObject lv_attr_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:847:28: ( (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:848:1: (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:848:1: (otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:848:3: otherlv_0= '[' ( (lv_attr_1_0= ruleTyVar ) ) (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleTyVars1600); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTyVarsAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:852:1: ( (lv_attr_1_0= ruleTyVar ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:853:1: (lv_attr_1_0= ruleTyVar )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:853:1: (lv_attr_1_0= ruleTyVar )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:854:3: lv_attr_1_0= ruleTyVar
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyVarsAccess().getAttrTyVarParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTyVar_in_ruleTyVars1621);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:870:2: (otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==34) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:870:4: otherlv_2= ',' ( (lv_attr_3_0= ruleTyVar ) )
            	    {
            	    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleTyVars1634); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTyVarsAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:874:1: ( (lv_attr_3_0= ruleTyVar ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:875:1: (lv_attr_3_0= ruleTyVar )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:875:1: (lv_attr_3_0= ruleTyVar )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:876:3: lv_attr_3_0= ruleTyVar
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTyVarsAccess().getAttrTyVarParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTyVar_in_ruleTyVars1655);
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
            	    break loop21;
                }
            } while (true);

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleTyVars1669); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:904:1: entryRuleTyVar returns [EObject current=null] : iv_ruleTyVar= ruleTyVar EOF ;
    public final EObject entryRuleTyVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyVar = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:905:2: (iv_ruleTyVar= ruleTyVar EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:906:2: iv_ruleTyVar= ruleTyVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyVarRule()); 
            }
            pushFollow(FOLLOW_ruleTyVar_in_entryRuleTyVar1705);
            iv_ruleTyVar=ruleTyVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyVar1715); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:913:1: ruleTyVar returns [EObject current=null] : ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) ;
    public final EObject ruleTyVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:916:28: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:917:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:917:1: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:918:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:918:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:919:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:919:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_S) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:920:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyVar1758); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:935:8: lv_name_0_2= RULE_S
                    {
                    lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTyVar1778); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:961:1: entryRuleConDecl returns [EObject current=null] : iv_ruleConDecl= ruleConDecl EOF ;
    public final EObject entryRuleConDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:962:2: (iv_ruleConDecl= ruleConDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:963:2: iv_ruleConDecl= ruleConDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConDeclRule()); 
            }
            pushFollow(FOLLOW_ruleConDecl_in_entryRuleConDecl1821);
            iv_ruleConDecl=ruleConDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConDecl1831); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:970:1: ruleConDecl returns [EObject current=null] : ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleConDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_ty_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:973:28: ( ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:974:1: ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:974:1: ( ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:974:2: ( (lv_name_0_0= ruleCONS ) ) (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:974:2: ( (lv_name_0_0= ruleCONS ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:975:1: (lv_name_0_0= ruleCONS )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:975:1: (lv_name_0_0= ruleCONS )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:976:3: lv_name_0_0= ruleCONS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConDeclAccess().getNameCONSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCONS_in_ruleConDecl1877);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:992:2: (otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:992:4: otherlv_1= 'of' ( (lv_ty_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleConDecl1890); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConDeclAccess().getOfKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:996:1: ( (lv_ty_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:997:1: (lv_ty_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:997:1: (lv_ty_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:998:3: lv_ty_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConDeclAccess().getTyTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleConDecl1911);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1022:1: entryRuleTy returns [EObject current=null] : iv_ruleTy= ruleTy EOF ;
    public final EObject entryRuleTy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTy = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1023:2: (iv_ruleTy= ruleTy EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1024:2: iv_ruleTy= ruleTy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyRule()); 
            }
            pushFollow(FOLLOW_ruleTy_in_entryRuleTy1949);
            iv_ruleTy=ruleTy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTy; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTy1959); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1031:1: ruleTy returns [EObject current=null] : ( ( (lv_value_0_0= ruleINTEGER ) ) | ( ( ( (otherlv_1= RULE_ID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? ) | ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' ) | (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) ) | ( () otherlv_22= '()' ) | (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER ) ) ;
    public final EObject ruleTy() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1034:28: ( ( ( (lv_value_0_0= ruleINTEGER ) ) | ( ( ( (otherlv_1= RULE_ID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? ) | ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' ) | (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) ) | ( () otherlv_22= '()' ) | (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1035:1: ( ( (lv_value_0_0= ruleINTEGER ) ) | ( ( ( (otherlv_1= RULE_ID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? ) | ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' ) | (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) ) | ( () otherlv_22= '()' ) | (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1035:1: ( ( (lv_value_0_0= ruleINTEGER ) ) | ( ( ( (otherlv_1= RULE_ID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? ) | ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' ) | (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) ) | ( () otherlv_22= '()' ) | (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER ) )
            int alt31=6;
            switch ( input.LA(1) ) {
            case RULE_HEXINT:
            case RULE_NEGINT:
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
                {
                alt31=1;
                }
                break;
            case RULE_ID:
            case 36:
            case 37:
            case 38:
                {
                alt31=2;
                }
                break;
            case 39:
                {
                alt31=3;
                }
                break;
            case 41:
                {
                alt31=4;
                }
                break;
            case 44:
                {
                alt31=5;
                }
                break;
            case RULE_S:
                {
                alt31=6;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1035:2: ( (lv_value_0_0= ruleINTEGER ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1035:2: ( (lv_value_0_0= ruleINTEGER ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1036:1: (lv_value_0_0= ruleINTEGER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1036:1: (lv_value_0_0= ruleINTEGER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1037:3: lv_value_0_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getValueINTEGERParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleTy2005);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:6: ( ( ( (otherlv_1= RULE_ID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:6: ( ( ( (otherlv_1= RULE_ID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:7: ( ( (otherlv_1= RULE_ID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) ) (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:7: ( ( (otherlv_1= RULE_ID ) ) | ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) ) )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:8: ( (otherlv_1= RULE_ID ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1054:8: ( (otherlv_1= RULE_ID ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1055:1: (otherlv_1= RULE_ID )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1055:1: (otherlv_1= RULE_ID )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1056:3: otherlv_1= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTyRule());
                              	        }
                                      
                            }
                            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTy2033); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_1, grammarAccess.getTyAccess().getTypeRefTypeCrossReference_1_0_0_0()); 
                              	
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1068:6: ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1068:6: ( ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1069:1: ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1069:1: ( (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1070:1: (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1070:1: (lv_type_2_1= 'int' | lv_type_2_2= 'string' | lv_type_2_3= 'unit' )
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1071:3: lv_type_2_1= 'int'
                                    {
                                    lv_type_2_1=(Token)match(input,36,FOLLOW_36_in_ruleTy2059); if (state.failed) return current;
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1083:8: lv_type_2_2= 'string'
                                    {
                                    lv_type_2_2=(Token)match(input,37,FOLLOW_37_in_ruleTy2088); if (state.failed) return current;
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1095:8: lv_type_2_3= 'unit'
                                    {
                                    lv_type_2_3=(Token)match(input,38,FOLLOW_38_in_ruleTy2117); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1110:3: (otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==32) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1110:5: otherlv_3= '[' ( (lv_tyBind_4_0= ruleTyBind ) ) (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )* otherlv_7= ']'
                            {
                            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleTy2147); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getTyAccess().getLeftSquareBracketKeyword_1_1_0());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1114:1: ( (lv_tyBind_4_0= ruleTyBind ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1115:1: (lv_tyBind_4_0= ruleTyBind )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1115:1: (lv_tyBind_4_0= ruleTyBind )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1116:3: lv_tyBind_4_0= ruleTyBind
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyBind_in_ruleTy2168);
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1132:2: (otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) ) )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==34) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1132:4: otherlv_5= ',' ( (lv_tyBind_6_0= ruleTyBind ) )
                            	    {
                            	    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleTy2181); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_5, grammarAccess.getTyAccess().getCommaKeyword_1_1_2_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1136:1: ( (lv_tyBind_6_0= ruleTyBind ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1137:1: (lv_tyBind_6_0= ruleTyBind )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1137:1: (lv_tyBind_6_0= ruleTyBind )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1138:3: lv_tyBind_6_0= ruleTyBind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getTyBindTyBindParserRuleCall_1_1_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyBind_in_ruleTy2202);
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
                            	    break loop26;
                                }
                            } while (true);

                            otherlv_7=(Token)match(input,33,FOLLOW_33_in_ruleTy2216); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1159:6: ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1159:6: ( () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1159:7: () otherlv_9= '{' ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )? otherlv_13= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1159:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1160:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTyAccess().getTyAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_9=(Token)match(input,39,FOLLOW_39_in_ruleTy2247); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getTyAccess().getLeftCurlyBracketKeyword_2_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:1: ( ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )* )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_S)) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:2: ( (lv_elements_10_0= ruleTyElement ) ) (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1169:2: ( (lv_elements_10_0= ruleTyElement ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1170:1: (lv_elements_10_0= ruleTyElement )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1170:1: (lv_elements_10_0= ruleTyElement )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1171:3: lv_elements_10_0= ruleTyElement
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleTyElement_in_ruleTy2269);
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1187:2: (otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) ) )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==34) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1187:4: otherlv_11= ',' ( (lv_elements_12_0= ruleTyElement ) )
                            	    {
                            	    otherlv_11=(Token)match(input,34,FOLLOW_34_in_ruleTy2282); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_11, grammarAccess.getTyAccess().getCommaKeyword_2_2_1_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1191:1: ( (lv_elements_12_0= ruleTyElement ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1192:1: (lv_elements_12_0= ruleTyElement )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1192:1: (lv_elements_12_0= ruleTyElement )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1193:3: lv_elements_12_0= ruleTyElement
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTyAccess().getElementsTyElementParserRuleCall_2_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleTyElement_in_ruleTy2303);
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
                            	    break loop28;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,40,FOLLOW_40_in_ruleTy2319); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getTyAccess().getRightCurlyBracketKeyword_2_3());
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1214:6: (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1214:6: (otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1214:8: otherlv_14= '(' ( (lv_param_15_0= ruleTy ) ) (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )* otherlv_18= ')' otherlv_19= '->' ( (lv_resType_20_0= ruleTy ) )
                    {
                    otherlv_14=(Token)match(input,41,FOLLOW_41_in_ruleTy2339); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getTyAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1218:1: ( (lv_param_15_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1219:1: (lv_param_15_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1219:1: (lv_param_15_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1220:3: lv_param_15_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getParamTyParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2360);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1236:2: (otherlv_16= ',' ( (lv_param_17_0= ruleTy ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==34) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1236:4: otherlv_16= ',' ( (lv_param_17_0= ruleTy ) )
                    	    {
                    	    otherlv_16=(Token)match(input,34,FOLLOW_34_in_ruleTy2373); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_16, grammarAccess.getTyAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1240:1: ( (lv_param_17_0= ruleTy ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1241:1: (lv_param_17_0= ruleTy )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1241:1: (lv_param_17_0= ruleTy )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1242:3: lv_param_17_0= ruleTy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTyAccess().getParamTyParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTy_in_ruleTy2394);
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
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,42,FOLLOW_42_in_ruleTy2408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getTyAccess().getRightParenthesisKeyword_3_3());
                          
                    }
                    otherlv_19=(Token)match(input,43,FOLLOW_43_in_ruleTy2420); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getTyAccess().getHyphenMinusGreaterThanSignKeyword_3_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1266:1: ( (lv_resType_20_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1267:1: (lv_resType_20_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1267:1: (lv_resType_20_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1268:3: lv_resType_20_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getResTypeTyParserRuleCall_3_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2441);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1285:6: ( () otherlv_22= '()' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1285:6: ( () otherlv_22= '()' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1285:7: () otherlv_22= '()'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1285:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1286:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTyAccess().getTyAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_22=(Token)match(input,44,FOLLOW_44_in_ruleTy2470); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getTyAccess().getLeftParenthesisRightParenthesisKeyword_4_1());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1296:6: (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1296:6: (this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1296:7: this_S_23= RULE_S ( (lv_r_24_0= ruleTy ) ) this_LESS_25= RULE_LESS ( (lv_in_26_0= ruleTy ) ) otherlv_27= '=>' ( (lv_out_28_0= ruleTy ) ) this_GREATER_29= RULE_GREATER
                    {
                    this_S_23=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTy2489); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_S_23, grammarAccess.getTyAccess().getSTerminalRuleCall_5_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1300:1: ( (lv_r_24_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1301:1: (lv_r_24_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1301:1: (lv_r_24_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1302:3: lv_r_24_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getRTyParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2509);
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

                    this_LESS_25=(Token)match(input,RULE_LESS,FOLLOW_RULE_LESS_in_ruleTy2520); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LESS_25, grammarAccess.getTyAccess().getLESSTerminalRuleCall_5_2()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1322:1: ( (lv_in_26_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1323:1: (lv_in_26_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1323:1: (lv_in_26_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1324:3: lv_in_26_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getInTyParserRuleCall_5_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2540);
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

                    otherlv_27=(Token)match(input,45,FOLLOW_45_in_ruleTy2552); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getTyAccess().getEqualsSignGreaterThanSignKeyword_5_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1344:1: ( (lv_out_28_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1345:1: (lv_out_28_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1345:1: (lv_out_28_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1346:3: lv_out_28_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyAccess().getOutTyParserRuleCall_5_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTy2573);
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

                    this_GREATER_29=(Token)match(input,RULE_GREATER,FOLLOW_RULE_GREATER_in_ruleTy2584); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1374:1: entryRuleTyBind returns [EObject current=null] : iv_ruleTyBind= ruleTyBind EOF ;
    public final EObject entryRuleTyBind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyBind = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1375:2: (iv_ruleTyBind= ruleTyBind EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1376:2: iv_ruleTyBind= ruleTyBind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyBindRule()); 
            }
            pushFollow(FOLLOW_ruleTyBind_in_entryRuleTyBind2620);
            iv_ruleTyBind=ruleTyBind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyBind; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyBind2630); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1383:1: ruleTyBind returns [EObject current=null] : ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) ;
    public final EObject ruleTyBind() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1386:28: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1387:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1387:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )? )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1387:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1387:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1388:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1388:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1389:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1389:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_S) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1390:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyBind2674); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1405:8: lv_name_0_2= RULE_S
                    {
                    lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTyBind2694); if (state.failed) return current;
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1423:2: (otherlv_1= '=' ( (lv_value_2_0= ruleTy ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==29) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1423:4: otherlv_1= '=' ( (lv_value_2_0= ruleTy ) )
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleTyBind2715); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTyBindAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1427:1: ( (lv_value_2_0= ruleTy ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1428:1: (lv_value_2_0= ruleTy )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1428:1: (lv_value_2_0= ruleTy )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1429:3: lv_value_2_0= ruleTy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTyBindAccess().getValueTyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTy_in_ruleTyBind2736);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1453:1: entryRuleTyElement returns [EObject current=null] : iv_ruleTyElement= ruleTyElement EOF ;
    public final EObject entryRuleTyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTyElement = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1454:2: (iv_ruleTyElement= ruleTyElement EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1455:2: iv_ruleTyElement= ruleTyElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTyElementRule()); 
            }
            pushFollow(FOLLOW_ruleTyElement_in_entryRuleTyElement2774);
            iv_ruleTyElement=ruleTyElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTyElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTyElement2784); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1462:1: ruleTyElement returns [EObject current=null] : ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) ;
    public final EObject ruleTyElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1465:28: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1466:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1466:1: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1466:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleTy ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1466:2: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1467:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1467:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1468:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1468:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_S) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1469:3: lv_name_0_1= RULE_ID
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTyElement2828); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1484:8: lv_name_0_2= RULE_S
                    {
                    lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTyElement2848); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleTyElement2868); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTyElementAccess().getColonKeyword_1());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1506:1: ( (lv_value_2_0= ruleTy ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1507:1: (lv_value_2_0= ruleTy )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1507:1: (lv_value_2_0= ruleTy )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1508:3: lv_value_2_0= ruleTy
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTyElementAccess().getValueTyParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTy_in_ruleTyElement2889);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1532:1: entryRuleExp returns [EObject current=null] : iv_ruleExp= ruleExp EOF ;
    public final EObject entryRuleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1533:2: (iv_ruleExp= ruleExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1534:2: iv_ruleExp= ruleExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpRule()); 
            }
            pushFollow(FOLLOW_ruleExp_in_entryRuleExp2925);
            iv_ruleExp=ruleExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExp2935); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1541:1: ruleExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ ) ;
    public final EObject ruleExp() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_mid_1_0 = null;

        EObject lv_caseExps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1544:28: ( ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1545:1: ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1545:1: ( ( (lv_name_0_0= ruleCaseExp ) ) | ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+ )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_ID && LA36_0<=RULE_S)||LA36_0==RULE_STRING||LA36_0==RULE_HEXINT||(LA36_0>=RULE_NEGINT && LA36_0<=RULE_DUALS)||LA36_0==39||LA36_0==41||LA36_0==46||LA36_0==48||LA36_0==51||(LA36_0>=60 && LA36_0<=63)||LA36_0==65) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_USCORE||LA36_0==RULE_MIXID) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1545:2: ( (lv_name_0_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1545:2: ( (lv_name_0_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1546:1: (lv_name_0_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1546:1: (lv_name_0_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1547:3: lv_name_0_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpAccess().getNameCaseExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp2981);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1564:6: ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1564:6: ( ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) ) )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==RULE_USCORE||LA35_0==RULE_MIXID) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1564:7: ( (lv_mid_1_0= ruleMID ) ) ( (lv_caseExps_2_0= ruleCaseExp ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1564:7: ( (lv_mid_1_0= ruleMID ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1565:1: (lv_mid_1_0= ruleMID )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1565:1: (lv_mid_1_0= ruleMID )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1566:3: lv_mid_1_0= ruleMID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpAccess().getMidMIDParserRuleCall_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMID_in_ruleExp3009);
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

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1582:2: ( (lv_caseExps_2_0= ruleCaseExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1583:1: (lv_caseExps_2_0= ruleCaseExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1583:1: (lv_caseExps_2_0= ruleCaseExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1584:3: lv_caseExps_2_0= ruleCaseExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpAccess().getCaseExpsCaseExpParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCaseExp_in_ruleExp3030);
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
                    	    if ( cnt35 >= 1 ) break loop35;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1608:1: entryRuleCaseExp returns [EObject current=null] : iv_ruleCaseExp= ruleCaseExp EOF ;
    public final EObject entryRuleCaseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1609:2: (iv_ruleCaseExp= ruleCaseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1610:2: iv_ruleCaseExp= ruleCaseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseExpRule()); 
            }
            pushFollow(FOLLOW_ruleCaseExp_in_entryRuleCaseExp3068);
            iv_ruleCaseExp=ruleCaseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseExp3078); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1617:1: ruleCaseExp returns [EObject current=null] : (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1620:28: ( (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1621:1: (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1621:1: (this_ClosedExp_0= ruleClosedExp | ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_S)||LA38_0==RULE_STRING||LA38_0==RULE_HEXINT||(LA38_0>=RULE_NEGINT && LA38_0<=RULE_DUALS)||LA38_0==39||LA38_0==41||LA38_0==48||LA38_0==51||(LA38_0>=60 && LA38_0<=63)||LA38_0==65) ) {
                alt38=1;
            }
            else if ( (LA38_0==46) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1622:5: this_ClosedExp_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp3125);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1631:6: ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1631:6: ( ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1631:7: ( (lv_name_1_0= 'case' ) ) ( (lv_closedExp_2_0= ruleClosedExp ) ) otherlv_3= 'of' ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* ) otherlv_11= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1631:7: ( (lv_name_1_0= 'case' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1632:1: (lv_name_1_0= 'case' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1632:1: (lv_name_1_0= 'case' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1633:3: lv_name_1_0= 'case'
                    {
                    lv_name_1_0=(Token)match(input,46,FOLLOW_46_in_ruleCaseExp3149); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1646:2: ( (lv_closedExp_2_0= ruleClosedExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1647:1: (lv_closedExp_2_0= ruleClosedExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1647:1: (lv_closedExp_2_0= ruleClosedExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1648:3: lv_closedExp_2_0= ruleClosedExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getClosedExpClosedExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClosedExp_in_ruleCaseExp3183);
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

                    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleCaseExp3195); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCaseExpAccess().getOfKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1668:1: ( ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1668:2: ( (lv_pat_4_0= rulePAT ) ) otherlv_5= ':' ( (lv_exp_6_0= ruleExp ) ) (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1668:2: ( (lv_pat_4_0= rulePAT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1669:1: (lv_pat_4_0= rulePAT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1669:1: (lv_pat_4_0= rulePAT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1670:3: lv_pat_4_0= rulePAT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getPatPATParserRuleCall_1_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePAT_in_ruleCaseExp3217);
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

                    otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleCaseExp3229); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCaseExpAccess().getColonKeyword_1_3_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1690:1: ( (lv_exp_6_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1691:1: (lv_exp_6_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1691:1: (lv_exp_6_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1692:3: lv_exp_6_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseExpAccess().getExpExpParserRuleCall_1_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleCaseExp3250);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1708:2: (otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==30) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1708:4: otherlv_7= '|' ( (lv_pat_8_0= rulePAT ) ) otherlv_9= ':' ( (lv_exp_10_0= ruleExp ) )
                    	    {
                    	    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleCaseExp3263); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_7, grammarAccess.getCaseExpAccess().getVerticalLineKeyword_1_3_3_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1712:1: ( (lv_pat_8_0= rulePAT ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:1: (lv_pat_8_0= rulePAT )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1713:1: (lv_pat_8_0= rulePAT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1714:3: lv_pat_8_0= rulePAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCaseExpAccess().getPatPATParserRuleCall_1_3_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePAT_in_ruleCaseExp3284);
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

                    	    otherlv_9=(Token)match(input,27,FOLLOW_27_in_ruleCaseExp3296); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getCaseExpAccess().getColonKeyword_1_3_3_2());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1734:1: ( (lv_exp_10_0= ruleExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1735:1: (lv_exp_10_0= ruleExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1735:1: (lv_exp_10_0= ruleExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1736:3: lv_exp_10_0= ruleExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCaseExpAccess().getExpExpParserRuleCall_1_3_3_3_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExp_in_ruleCaseExp3317);
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
                    	    break loop37;
                        }
                    } while (true);


                    }

                    otherlv_11=(Token)match(input,47,FOLLOW_47_in_ruleCaseExp3332); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1764:1: entryRuleClosedExp returns [EObject current=null] : iv_ruleClosedExp= ruleClosedExp EOF ;
    public final EObject entryRuleClosedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClosedExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1765:2: (iv_ruleClosedExp= ruleClosedExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1766:2: iv_ruleClosedExp= ruleClosedExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClosedExpRule()); 
            }
            pushFollow(FOLLOW_ruleClosedExp_in_entryRuleClosedExp3369);
            iv_ruleClosedExp=ruleClosedExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosedExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedExp3379); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1773:1: ruleClosedExp returns [EObject current=null] : (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1776:28: ( (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1777:1: (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1777:1: (this_OrElseExp_0= ruleOrElseExp | ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) ) | ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' ) )
            int alt40=3;
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
                alt40=1;
                }
                break;
            case 48:
                {
                alt40=2;
                }
                break;
            case 51:
                {
                alt40=3;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1778:5: this_OrElseExp_0= ruleOrElseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClosedExpAccess().getOrElseExpParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrElseExp_in_ruleClosedExp3426);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1787:6: ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1787:6: ( ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1787:7: ( (lv_name_1_0= 'if' ) ) ( (lv_ifCaseExp_2_0= ruleCaseExp ) ) otherlv_3= 'then' ( (lv_thenCaseExp_4_0= ruleCaseExp ) ) otherlv_5= 'else' ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1787:7: ( (lv_name_1_0= 'if' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1788:1: (lv_name_1_0= 'if' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1788:1: (lv_name_1_0= 'if' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1789:3: lv_name_1_0= 'if'
                    {
                    lv_name_1_0=(Token)match(input,48,FOLLOW_48_in_ruleClosedExp3450); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1802:2: ( (lv_ifCaseExp_2_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1803:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1803:1: (lv_ifCaseExp_2_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1804:3: lv_ifCaseExp_2_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getIfCaseExpCaseExpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3484);
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

                    otherlv_3=(Token)match(input,49,FOLLOW_49_in_ruleClosedExp3496); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getClosedExpAccess().getThenKeyword_1_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1824:1: ( (lv_thenCaseExp_4_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1825:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1825:1: (lv_thenCaseExp_4_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1826:3: lv_thenCaseExp_4_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getThenCaseExpCaseExpParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3517);
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

                    otherlv_5=(Token)match(input,50,FOLLOW_50_in_ruleClosedExp3529); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getClosedExpAccess().getElseKeyword_1_4());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1846:1: ( (lv_elseCaseExp_6_0= ruleCaseExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1847:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1847:1: (lv_elseCaseExp_6_0= ruleCaseExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1848:3: lv_elseCaseExp_6_0= ruleCaseExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getElseCaseExpCaseExpParserRuleCall_1_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCaseExp_in_ruleClosedExp3550);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1865:6: ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1865:6: ( ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1865:7: ( (lv_name_7_0= 'do' ) ) ( (lv_doExp_8_0= ruleMonadicExp ) ) (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )* otherlv_11= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1865:7: ( (lv_name_7_0= 'do' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1866:1: (lv_name_7_0= 'do' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1866:1: (lv_name_7_0= 'do' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1867:3: lv_name_7_0= 'do'
                    {
                    lv_name_7_0=(Token)match(input,51,FOLLOW_51_in_ruleClosedExp3576); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1880:2: ( (lv_doExp_8_0= ruleMonadicExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1881:1: (lv_doExp_8_0= ruleMonadicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1881:1: (lv_doExp_8_0= ruleMonadicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1882:3: lv_doExp_8_0= ruleMonadicExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3610);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1898:2: (otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==25) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1898:4: otherlv_9= ';' ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    {
                    	    otherlv_9=(Token)match(input,25,FOLLOW_25_in_ruleClosedExp3623); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getClosedExpAccess().getSemicolonKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1902:1: ( (lv_doExp_10_0= ruleMonadicExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1903:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1903:1: (lv_doExp_10_0= ruleMonadicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1904:3: lv_doExp_10_0= ruleMonadicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClosedExpAccess().getDoExpMonadicExpParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMonadicExp_in_ruleClosedExp3644);
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
                    	    break loop39;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,47,FOLLOW_47_in_ruleClosedExp3658); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1932:1: entryRuleMonadicExp returns [EObject current=null] : iv_ruleMonadicExp= ruleMonadicExp EOF ;
    public final EObject entryRuleMonadicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonadicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1933:2: (iv_ruleMonadicExp= ruleMonadicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1934:2: iv_ruleMonadicExp= ruleMonadicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMonadicExpRule()); 
            }
            pushFollow(FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3695);
            iv_ruleMonadicExp=ruleMonadicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMonadicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMonadicExp3705); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1941:1: ruleMonadicExp returns [EObject current=null] : ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) ;
    public final EObject ruleMonadicExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1944:28: ( ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:2: ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:2: ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:3: ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1950:1: (lv_exp_0_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1951:3: lv_exp_0_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3761);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1968:6: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1968:6: ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1968:7: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1968:7: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1969:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1969:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1970:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1970:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==RULE_ID) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==RULE_S) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1971:3: lv_name_1_1= RULE_ID
                            {
                            lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMonadicExp3787); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1986:8: lv_name_1_2= RULE_S
                            {
                            lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleMonadicExp3807); if (state.failed) return current;
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

                    otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleMonadicExp3827); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getMonadicExpAccess().getLessThanSignHyphenMinusKeyword_1_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2008:1: ( (lv_exp_3_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2009:1: (lv_exp_3_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2009:1: (lv_exp_3_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2010:3: lv_exp_3_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMonadicExpAccess().getExpExpParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleMonadicExp3848);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2034:1: entryRuleOrElseExp returns [EObject current=null] : iv_ruleOrElseExp= ruleOrElseExp EOF ;
    public final EObject entryRuleOrElseExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrElseExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2035:2: (iv_ruleOrElseExp= ruleOrElseExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2036:2: iv_ruleOrElseExp= ruleOrElseExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrElseExpRule()); 
            }
            pushFollow(FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3885);
            iv_ruleOrElseExp=ruleOrElseExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrElseExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrElseExp3895); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2043:1: ruleOrElseExp returns [EObject current=null] : (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) ;
    public final EObject ruleOrElseExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_AndAlsoExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2046:28: ( (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2047:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2047:1: (this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2048:5: this_AndAlsoExp_0= ruleAndAlsoExp ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrElseExpAccess().getAndAlsoExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3942);
            this_AndAlsoExp_0=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndAlsoExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2056:1: ( () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==53) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2056:2: () ( (lv_name_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2056:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2057:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrElseExpAccess().getOrElseExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2062:2: ( (lv_name_2_0= 'or' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2063:1: (lv_name_2_0= 'or' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2063:1: (lv_name_2_0= 'or' )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2064:3: lv_name_2_0= 'or'
            	    {
            	    lv_name_2_0=(Token)match(input,53,FOLLOW_53_in_ruleOrElseExp3969); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2077:2: ( (lv_right_3_0= ruleAndAlsoExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:1: (lv_right_3_0= ruleAndAlsoExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2078:1: (lv_right_3_0= ruleAndAlsoExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2079:3: lv_right_3_0= ruleAndAlsoExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrElseExpAccess().getRightAndAlsoExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp4003);
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
            	    break loop43;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2103:1: entryRuleAndAlsoExp returns [EObject current=null] : iv_ruleAndAlsoExp= ruleAndAlsoExp EOF ;
    public final EObject entryRuleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndAlsoExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2104:2: (iv_ruleAndAlsoExp= ruleAndAlsoExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2105:2: iv_ruleAndAlsoExp= ruleAndAlsoExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndAlsoExpRule()); 
            }
            pushFollow(FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp4041);
            iv_ruleAndAlsoExp=ruleAndAlsoExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndAlsoExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndAlsoExp4051); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2112:1: ruleAndAlsoExp returns [EObject current=null] : (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* ) ;
    public final EObject ruleAndAlsoExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject this_RExp_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2115:28: ( (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2116:1: (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2116:1: (this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2117:5: this_RExp_0= ruleRExp ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp4098);
            this_RExp_0=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2125:1: ( () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==54) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2125:2: () ( (lv_name_2_0= 'and' ) ) ( (lv_right_3_0= ruleRExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2125:2: ()
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2126:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndAlsoExpAccess().getAndAlsoExpLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2131:2: ( (lv_name_2_0= 'and' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2132:1: (lv_name_2_0= 'and' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2132:1: (lv_name_2_0= 'and' )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2133:3: lv_name_2_0= 'and'
            	    {
            	    lv_name_2_0=(Token)match(input,54,FOLLOW_54_in_ruleAndAlsoExp4125); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2146:2: ( (lv_right_3_0= ruleRExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2147:1: (lv_right_3_0= ruleRExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2147:1: (lv_right_3_0= ruleRExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2148:3: lv_right_3_0= ruleRExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndAlsoExpAccess().getRightRExpParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRExp_in_ruleAndAlsoExp4159);
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
    // $ANTLR end "ruleAndAlsoExp"


    // $ANTLR start "entryRuleRExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2172:1: entryRuleRExp returns [EObject current=null] : iv_ruleRExp= ruleRExp EOF ;
    public final EObject entryRuleRExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2173:2: (iv_ruleRExp= ruleRExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2174:2: iv_ruleRExp= ruleRExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRExpRule()); 
            }
            pushFollow(FOLLOW_ruleRExp_in_entryRuleRExp4197);
            iv_ruleRExp=ruleRExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRExp4207); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2181:1: ruleRExp returns [EObject current=null] : (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) ;
    public final EObject ruleRExp() throws RecognitionException {
        EObject current = null;

        EObject this_AExp_0 = null;

        AntlrDatatypeRuleToken lv_sym_1_0 = null;

        EObject lv_aexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2184:28: ( (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2185:1: (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2185:1: (this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2186:5: this_AExp_0= ruleAExp ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRExpAccess().getAExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAExp_in_ruleRExp4254);
            this_AExp_0=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2194:1: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*
            loop45:
            do {
                int alt45=2;
                alt45 = dfa45.predict(input);
                switch (alt45) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2194:2: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2194:2: ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2194:3: ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2199:1: (lv_sym_1_0= ruleSYM )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2200:3: lv_sym_1_0= ruleSYM
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getSymSYMParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSYM_in_ruleRExp4285);
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2216:2: ( (lv_aexps_2_0= ruleAExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2217:1: (lv_aexps_2_0= ruleAExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2217:1: (lv_aexps_2_0= ruleAExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2218:3: lv_aexps_2_0= ruleAExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRExpAccess().getAexpsAExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAExp_in_ruleRExp4306);
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
    // $ANTLR end "ruleRExp"


    // $ANTLR start "entryRuleAExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2242:1: entryRuleAExp returns [EObject current=null] : iv_ruleAExp= ruleAExp EOF ;
    public final EObject entryRuleAExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2243:2: (iv_ruleAExp= ruleAExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2244:2: iv_ruleAExp= ruleAExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpRule()); 
            }
            pushFollow(FOLLOW_ruleAExp_in_entryRuleAExp4344);
            iv_ruleAExp=ruleAExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExp4354); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2251:1: ruleAExp returns [EObject current=null] : (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) ;
    public final EObject ruleAExp() throws RecognitionException {
        EObject current = null;

        Token lv_sign_1_1=null;
        Token lv_sign_1_2=null;
        EObject this_MExp_0 = null;

        EObject lv_mexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2254:28: ( (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2255:1: (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2255:1: (this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2256:5: this_MExp_0= ruleMExp ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAExpAccess().getMExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMExp_in_ruleAExp4401);
            this_MExp_0=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2264:1: ( ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=55 && LA47_0<=56)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2264:2: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) ) ( (lv_mexps_2_0= ruleMExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2264:2: ( ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2265:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2265:1: ( (lv_sign_1_1= '+' | lv_sign_1_2= '-' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2266:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2266:1: (lv_sign_1_1= '+' | lv_sign_1_2= '-' )
            	    int alt46=2;
            	    int LA46_0 = input.LA(1);

            	    if ( (LA46_0==55) ) {
            	        alt46=1;
            	    }
            	    else if ( (LA46_0==56) ) {
            	        alt46=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 46, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt46) {
            	        case 1 :
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2267:3: lv_sign_1_1= '+'
            	            {
            	            lv_sign_1_1=(Token)match(input,55,FOLLOW_55_in_ruleAExp4421); if (state.failed) return current;
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2279:8: lv_sign_1_2= '-'
            	            {
            	            lv_sign_1_2=(Token)match(input,56,FOLLOW_56_in_ruleAExp4450); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2294:2: ( (lv_mexps_2_0= ruleMExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2295:1: (lv_mexps_2_0= ruleMExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2295:1: (lv_mexps_2_0= ruleMExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2296:3: lv_mexps_2_0= ruleMExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAExpAccess().getMexpsMExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMExp_in_ruleAExp4487);
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
            	    break loop47;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2320:1: entryRuleMExp returns [EObject current=null] : iv_ruleMExp= ruleMExp EOF ;
    public final EObject entryRuleMExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2321:2: (iv_ruleMExp= ruleMExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2322:2: iv_ruleMExp= ruleMExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMExpRule()); 
            }
            pushFollow(FOLLOW_ruleMExp_in_entryRuleMExp4525);
            iv_ruleMExp=ruleMExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMExp4535); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2329:1: ruleMExp returns [EObject current=null] : (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) ;
    public final EObject ruleMExp() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_1_1=null;
        Token lv_symbol_1_2=null;
        EObject this_SelectExp_0 = null;

        EObject lv_applyexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2332:28: ( (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2333:1: (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2333:1: (this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2334:5: this_SelectExp_0= ruleSelectExp ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMExpAccess().getSelectExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleSelectExp_in_ruleMExp4582);
            this_SelectExp_0=ruleSelectExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_SelectExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2342:1: ( ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=57 && LA49_0<=58)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2342:2: ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) ) ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2342:2: ( ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2343:1: ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2343:1: ( (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2344:1: (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2344:1: (lv_symbol_1_1= '*' | lv_symbol_1_2= '%' )
            	    int alt48=2;
            	    int LA48_0 = input.LA(1);

            	    if ( (LA48_0==57) ) {
            	        alt48=1;
            	    }
            	    else if ( (LA48_0==58) ) {
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2345:3: lv_symbol_1_1= '*'
            	            {
            	            lv_symbol_1_1=(Token)match(input,57,FOLLOW_57_in_ruleMExp4602); if (state.failed) return current;
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2357:8: lv_symbol_1_2= '%'
            	            {
            	            lv_symbol_1_2=(Token)match(input,58,FOLLOW_58_in_ruleMExp4631); if (state.failed) return current;
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

            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2372:2: ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2373:1: (lv_applyexps_2_0= ruleApplyExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2373:1: (lv_applyexps_2_0= ruleApplyExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2374:3: lv_applyexps_2_0= ruleApplyExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMExpAccess().getApplyexpsApplyExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleApplyExp_in_ruleMExp4668);
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
    // $ANTLR end "ruleMExp"


    // $ANTLR start "entryRuleSelectExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2398:1: entryRuleSelectExp returns [EObject current=null] : iv_ruleSelectExp= ruleSelectExp EOF ;
    public final EObject entryRuleSelectExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2399:2: (iv_ruleSelectExp= ruleSelectExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2400:2: iv_ruleSelectExp= ruleSelectExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelectExpRule()); 
            }
            pushFollow(FOLLOW_ruleSelectExp_in_entryRuleSelectExp4706);
            iv_ruleSelectExp=ruleSelectExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelectExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectExp4716); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2407:1: ruleSelectExp returns [EObject current=null] : (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) ;
    public final EObject ruleSelectExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ApplyExp_0 = null;

        EObject lv_applyexps_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2410:28: ( (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2411:1: (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2411:1: (this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2412:5: this_ApplyExp_0= ruleApplyExp (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSelectExpAccess().getApplyExpParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleApplyExp_in_ruleSelectExp4763);
            this_ApplyExp_0=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ApplyExp_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2420:1: (otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==59) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2420:3: otherlv_1= '^' ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    {
            	    otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleSelectExp4775); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getSelectExpAccess().getCircumflexAccentKeyword_1_0());
            	          
            	    }
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2424:1: ( (lv_applyexps_2_0= ruleApplyExp ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2425:1: (lv_applyexps_2_0= ruleApplyExp )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2425:1: (lv_applyexps_2_0= ruleApplyExp )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2426:3: lv_applyexps_2_0= ruleApplyExp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSelectExpAccess().getApplyexpsApplyExpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleApplyExp_in_ruleSelectExp4796);
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
    // $ANTLR end "ruleSelectExp"


    // $ANTLR start "entryRuleApplyExp"
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2450:1: entryRuleApplyExp returns [EObject current=null] : iv_ruleApplyExp= ruleApplyExp EOF ;
    public final EObject entryRuleApplyExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleApplyExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2451:2: (iv_ruleApplyExp= ruleApplyExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2452:2: iv_ruleApplyExp= ruleApplyExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getApplyExpRule()); 
            }
            pushFollow(FOLLOW_ruleApplyExp_in_entryRuleApplyExp4834);
            iv_ruleApplyExp=ruleApplyExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleApplyExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleApplyExp4844); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2459:1: ruleApplyExp returns [EObject current=null] : ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+ ) ;
    public final EObject ruleApplyExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_AtomicExp_1 = null;

        EObject lv_atomicExp_2_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2462:28: ( ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+ ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2463:1: ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+ )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2463:1: ( (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp ) | ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+ )
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2463:2: (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2463:2: (otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2463:4: otherlv_0= '~' this_AtomicExp_1= ruleAtomicExp
                    {
                    otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleApplyExp4882); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getApplyExpAccess().getTildeKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getApplyExpAccess().getAtomicExpParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAtomicExp_in_ruleApplyExp4904);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2477:6: ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2477:6: ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+
                    int cnt51=0;
                    loop51:
                    do {
                        int alt51=2;
                        alt51 = dfa51.predict(input);
                        switch (alt51) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2477:7: ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2481:5: ( (lv_atomicExp_2_0= ruleAtomicExp ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2482:1: (lv_atomicExp_2_0= ruleAtomicExp )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2482:1: (lv_atomicExp_2_0= ruleAtomicExp )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2483:3: lv_atomicExp_2_0= ruleAtomicExp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getApplyExpAccess().getAtomicExpAtomicExpParserRuleCall_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleAtomicExp_in_ruleApplyExp4944);
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
                    	    if ( cnt51 >= 1 ) break loop51;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(51, input);
                                throw eee;
                        }
                        cnt51++;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2507:1: entryRuleAtomicExp returns [EObject current=null] : iv_ruleAtomicExp= ruleAtomicExp EOF ;
    public final EObject entryRuleAtomicExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExp = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2508:2: (iv_ruleAtomicExp= ruleAtomicExp EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2509:2: iv_ruleAtomicExp= ruleAtomicExp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExpRule()); 
            }
            pushFollow(FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp4982);
            iv_ruleAtomicExp=ruleAtomicExp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExp; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicExp4992); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2516:1: ruleAtomicExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2519:28: ( ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2520:1: ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2520:1: ( ( (lv_name_0_0= ruleLIT ) ) | ( (lv_name_1_0= RULE_STRING ) ) | ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* ) | ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' ) | (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) ) | (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* ) | ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' ) | ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' ) )
            int alt65=8;
            switch ( input.LA(1) ) {
            case RULE_HEXINT:
            case RULE_NEGINT:
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
            case 65:
                {
                alt65=1;
                }
                break;
            case RULE_STRING:
                {
                alt65=2;
                }
                break;
            case RULE_ID:
            case RULE_S:
                {
                alt65=3;
                }
                break;
            case 61:
                {
                alt65=4;
                }
                break;
            case 62:
                {
                alt65=5;
                }
                break;
            case 41:
                {
                alt65=6;
                }
                break;
            case 39:
                {
                alt65=7;
                }
                break;
            case 63:
                {
                alt65=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2520:2: ( (lv_name_0_0= ruleLIT ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2520:2: ( (lv_name_0_0= ruleLIT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2521:1: (lv_name_0_0= ruleLIT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2521:1: (lv_name_0_0= ruleLIT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2522:3: lv_name_0_0= ruleLIT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getNameLITParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLIT_in_ruleAtomicExp5038);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2539:6: ( (lv_name_1_0= RULE_STRING ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2539:6: ( (lv_name_1_0= RULE_STRING ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2540:1: (lv_name_1_0= RULE_STRING )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2540:1: (lv_name_1_0= RULE_STRING )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2541:3: lv_name_1_0= RULE_STRING
                    {
                    lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAtomicExp5061); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2558:6: ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2558:6: ( ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2558:7: ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) ) ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )*
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2558:7: ( ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2559:1: ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2559:1: ( (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2560:1: (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2560:1: (lv_name_2_1= RULE_ID | lv_name_2_2= RULE_S )
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==RULE_ID) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==RULE_S) ) {
                        alt53=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 0, input);

                        throw nvae;
                    }
                    switch (alt53) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2561:3: lv_name_2_1= RULE_ID
                            {
                            lv_name_2_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5092); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2576:8: lv_name_2_2= RULE_S
                            {
                            lv_name_2_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5112); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2594:2: ( ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==RULE_DOT) ) {
                            int LA55_2 = input.LA(2);

                            if ( (LA55_2==RULE_ID) ) {
                                int LA55_3 = input.LA(3);

                                if ( (synpred8_InternalGDSL()) ) {
                                    alt55=1;
                                }


                            }
                            else if ( (LA55_2==RULE_S) ) {
                                int LA55_4 = input.LA(3);

                                if ( (synpred8_InternalGDSL()) ) {
                                    alt55=1;
                                }


                            }


                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2594:3: ( ( RULE_DOT )=>this_DOT_3= RULE_DOT ) ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2594:3: ( ( RULE_DOT )=>this_DOT_3= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2594:4: ( RULE_DOT )=>this_DOT_3= RULE_DOT
                    	    {
                    	    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp5138); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_3, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_2_1_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2598:2: ( ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2599:1: ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2599:1: ( (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2600:1: (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2600:1: (lv_id_4_1= RULE_ID | lv_id_4_2= RULE_S )
                    	    int alt54=2;
                    	    int LA54_0 = input.LA(1);

                    	    if ( (LA54_0==RULE_ID) ) {
                    	        alt54=1;
                    	    }
                    	    else if ( (LA54_0==RULE_S) ) {
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2601:3: lv_id_4_1= RULE_ID
                    	            {
                    	            lv_id_4_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5157); if (state.failed) return current;
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2616:8: lv_id_4_2= RULE_S
                    	            {
                    	            lv_id_4_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5177); if (state.failed) return current;
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
                    	    break loop55;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2635:6: ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2635:6: ( ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2635:7: ( (lv_name_5_0= '@' ) ) otherlv_6= '{' ( (lv_fields_7_0= ruleField ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )* otherlv_10= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2635:7: ( (lv_name_5_0= '@' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2636:1: (lv_name_5_0= '@' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2636:1: (lv_name_5_0= '@' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2637:3: lv_name_5_0= '@'
                    {
                    lv_name_5_0=(Token)match(input,61,FOLLOW_61_in_ruleAtomicExp5213); if (state.failed) return current;
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

                    otherlv_6=(Token)match(input,39,FOLLOW_39_in_ruleAtomicExp5238); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_3_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2654:1: ( (lv_fields_7_0= ruleField ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2655:1: (lv_fields_7_0= ruleField )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2655:1: (lv_fields_7_0= ruleField )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2656:3: lv_fields_7_0= ruleField
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp5259);
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2672:2: (otherlv_8= ',' ( (lv_fields_9_0= ruleField ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==34) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2672:4: otherlv_8= ',' ( (lv_fields_9_0= ruleField ) )
                    	    {
                    	    otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExp5272); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_8, grammarAccess.getAtomicExpAccess().getCommaKeyword_3_3_0());
                    	          
                    	    }
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2676:1: ( (lv_fields_9_0= ruleField ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2677:1: (lv_fields_9_0= ruleField )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2677:1: (lv_fields_9_0= ruleField )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2678:3: lv_fields_9_0= ruleField
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getFieldsFieldParserRuleCall_3_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleField_in_ruleAtomicExp5293);
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
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,40,FOLLOW_40_in_ruleAtomicExp5307); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_3_4());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2699:6: (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2699:6: (otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2699:8: otherlv_11= '$' ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) )
                    {
                    otherlv_11=(Token)match(input,62,FOLLOW_62_in_ruleAtomicExp5327); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getAtomicExpAccess().getDollarSignKeyword_4_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2703:1: ( ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2704:1: ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2704:1: ( (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2705:1: (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2705:1: (lv_name_12_1= RULE_ID | lv_name_12_2= RULE_S )
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==RULE_ID) ) {
                        alt57=1;
                    }
                    else if ( (LA57_0==RULE_S) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2706:3: lv_name_12_1= RULE_ID
                            {
                            lv_name_12_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5346); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2721:8: lv_name_12_2= RULE_S
                            {
                            lv_name_12_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5366); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2740:6: (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2740:6: (otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )* )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2740:8: otherlv_13= '(' ( (lv_expr_14_0= ruleExp ) ) otherlv_15= ')' ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )*
                    {
                    otherlv_13=(Token)match(input,41,FOLLOW_41_in_ruleAtomicExp5394); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getAtomicExpAccess().getLeftParenthesisKeyword_5_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2744:1: ( (lv_expr_14_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2745:1: (lv_expr_14_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2745:1: (lv_expr_14_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2746:3: lv_expr_14_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExprExpParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5415);
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

                    otherlv_15=(Token)match(input,42,FOLLOW_42_in_ruleAtomicExp5427); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getAtomicExpAccess().getRightParenthesisKeyword_5_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2766:1: ( ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==RULE_DOT) ) {
                            int LA59_2 = input.LA(2);

                            if ( (LA59_2==RULE_ID) ) {
                                int LA59_3 = input.LA(3);

                                if ( (synpred9_InternalGDSL()) ) {
                                    alt59=1;
                                }


                            }
                            else if ( (LA59_2==RULE_S) ) {
                                int LA59_4 = input.LA(3);

                                if ( (synpred9_InternalGDSL()) ) {
                                    alt59=1;
                                }


                            }


                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2766:2: ( ( RULE_DOT )=>this_DOT_16= RULE_DOT ) ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2766:2: ( ( RULE_DOT )=>this_DOT_16= RULE_DOT )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2766:3: ( RULE_DOT )=>this_DOT_16= RULE_DOT
                    	    {
                    	    this_DOT_16=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleAtomicExp5445); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_DOT_16, grammarAccess.getAtomicExpAccess().getDOTTerminalRuleCall_5_3_0()); 
                    	          
                    	    }

                    	    }

                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2770:2: ( ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2771:1: ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2771:1: ( (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S ) )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2772:1: (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2772:1: (lv_id_17_1= RULE_ID | lv_id_17_2= RULE_S )
                    	    int alt58=2;
                    	    int LA58_0 = input.LA(1);

                    	    if ( (LA58_0==RULE_ID) ) {
                    	        alt58=1;
                    	    }
                    	    else if ( (LA58_0==RULE_S) ) {
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2773:3: lv_id_17_1= RULE_ID
                    	            {
                    	            lv_id_17_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5464); if (state.failed) return current;
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
                    	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2788:8: lv_id_17_2= RULE_S
                    	            {
                    	            lv_id_17_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5484); if (state.failed) return current;
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
                    	    break loop59;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 7 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2807:6: ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2807:6: ( () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2807:7: () otherlv_19= '{' ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )? otherlv_27= '}'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2807:7: ()
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2808:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExpAccess().getAtomicExpAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_19=(Token)match(input,39,FOLLOW_39_in_ruleAtomicExp5523); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getAtomicExpAccess().getLeftCurlyBracketKeyword_6_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2817:1: ( ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )* )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( ((LA63_0>=RULE_ID && LA63_0<=RULE_S)) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2817:2: ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) ) otherlv_21= '=' ( (lv_exps_22_0= ruleExp ) ) (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )*
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2817:2: ( ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2818:1: ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2818:1: ( (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2819:1: (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2819:1: (lv_id_20_1= RULE_ID | lv_id_20_2= RULE_S )
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2820:3: lv_id_20_1= RULE_ID
                                    {
                                    lv_id_20_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5543); if (state.failed) return current;
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
                                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2835:8: lv_id_20_2= RULE_S
                                    {
                                    lv_id_20_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5563); if (state.failed) return current;
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

                            otherlv_21=(Token)match(input,29,FOLLOW_29_in_ruleAtomicExp5583); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_21, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_6_2_1());
                                  
                            }
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2857:1: ( (lv_exps_22_0= ruleExp ) )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2858:1: (lv_exps_22_0= ruleExp )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2858:1: (lv_exps_22_0= ruleExp )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2859:3: lv_exps_22_0= ruleExp
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_6_2_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5604);
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

                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2875:2: (otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) ) )*
                            loop62:
                            do {
                                int alt62=2;
                                int LA62_0 = input.LA(1);

                                if ( (LA62_0==34) ) {
                                    alt62=1;
                                }


                                switch (alt62) {
                            	case 1 :
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2875:4: otherlv_23= ',' ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) ) otherlv_25= '=' ( (lv_exps_26_0= ruleExp ) )
                            	    {
                            	    otherlv_23=(Token)match(input,34,FOLLOW_34_in_ruleAtomicExp5617); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_23, grammarAccess.getAtomicExpAccess().getCommaKeyword_6_2_3_0());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2879:1: ( ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2880:1: ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2880:1: ( (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2881:1: (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2881:1: (lv_id_24_1= RULE_ID | lv_id_24_2= RULE_S )
                            	    int alt61=2;
                            	    int LA61_0 = input.LA(1);

                            	    if ( (LA61_0==RULE_ID) ) {
                            	        alt61=1;
                            	    }
                            	    else if ( (LA61_0==RULE_S) ) {
                            	        alt61=2;
                            	    }
                            	    else {
                            	        if (state.backtracking>0) {state.failed=true; return current;}
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 61, 0, input);

                            	        throw nvae;
                            	    }
                            	    switch (alt61) {
                            	        case 1 :
                            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2882:3: lv_id_24_1= RULE_ID
                            	            {
                            	            lv_id_24_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomicExp5636); if (state.failed) return current;
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
                            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2897:8: lv_id_24_2= RULE_S
                            	            {
                            	            lv_id_24_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleAtomicExp5656); if (state.failed) return current;
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

                            	    otherlv_25=(Token)match(input,29,FOLLOW_29_in_ruleAtomicExp5676); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_25, grammarAccess.getAtomicExpAccess().getEqualsSignKeyword_6_2_3_2());
                            	          
                            	    }
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2919:1: ( (lv_exps_26_0= ruleExp ) )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2920:1: (lv_exps_26_0= ruleExp )
                            	    {
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2920:1: (lv_exps_26_0= ruleExp )
                            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2921:3: lv_exps_26_0= ruleExp
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExpsExpParserRuleCall_6_2_3_3_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5697);
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
                            	    break loop62;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_27=(Token)match(input,40,FOLLOW_40_in_ruleAtomicExp5713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getAtomicExpAccess().getRightCurlyBracketKeyword_6_3());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2942:6: ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2942:6: ( ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2942:7: ( (lv_name_28_0= 'let' ) ) ( (lv_valDecl_29_0= ruleValueDecl ) )+ otherlv_30= 'in' ( (lv_expr_31_0= ruleExp ) ) otherlv_32= 'end'
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2942:7: ( (lv_name_28_0= 'let' ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2943:1: (lv_name_28_0= 'let' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2943:1: (lv_name_28_0= 'let' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2944:3: lv_name_28_0= 'let'
                    {
                    lv_name_28_0=(Token)match(input,63,FOLLOW_63_in_ruleAtomicExp5739); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2957:2: ( (lv_valDecl_29_0= ruleValueDecl ) )+
                    int cnt64=0;
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==31) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2958:1: (lv_valDecl_29_0= ruleValueDecl )
                    	    {
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2958:1: (lv_valDecl_29_0= ruleValueDecl )
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2959:3: lv_valDecl_29_0= ruleValueDecl
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getValDeclValueDeclParserRuleCall_7_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleValueDecl_in_ruleAtomicExp5773);
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
                    	    if ( cnt64 >= 1 ) break loop64;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(64, input);
                                throw eee;
                        }
                        cnt64++;
                    } while (true);

                    otherlv_30=(Token)match(input,64,FOLLOW_64_in_ruleAtomicExp5786); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_30, grammarAccess.getAtomicExpAccess().getInKeyword_7_2());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2979:1: ( (lv_expr_31_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2980:1: (lv_expr_31_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2980:1: (lv_expr_31_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2981:3: lv_expr_31_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExpAccess().getExprExpParserRuleCall_7_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleAtomicExp5807);
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

                    otherlv_32=(Token)match(input,47,FOLLOW_47_in_ruleAtomicExp5819); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3009:1: entryRuleField returns [EObject current=null] : iv_ruleField= ruleField EOF ;
    public final EObject entryRuleField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3010:2: (iv_ruleField= ruleField EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3011:2: iv_ruleField= ruleField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldRule()); 
            }
            pushFollow(FOLLOW_ruleField_in_entryRuleField5856);
            iv_ruleField=ruleField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleField5866); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3018:1: ruleField returns [EObject current=null] : ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3021:28: ( ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3022:1: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3022:1: ( ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) ) | (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=RULE_ID && LA68_0<=RULE_S)) ) {
                alt68=1;
            }
            else if ( (LA68_0==60) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3022:2: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3022:2: ( ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3022:3: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) ) otherlv_1= '=' ( (lv_exp_2_0= ruleExp ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3022:3: ( ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3023:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3023:1: ( (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3024:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3024:1: (lv_name_0_1= RULE_ID | lv_name_0_2= RULE_S )
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==RULE_ID) ) {
                        alt66=1;
                    }
                    else if ( (LA66_0==RULE_S) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3025:3: lv_name_0_1= RULE_ID
                            {
                            lv_name_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleField5911); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3040:8: lv_name_0_2= RULE_S
                            {
                            lv_name_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleField5931); if (state.failed) return current;
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

                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleField5951); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getFieldAccess().getEqualsSignKeyword_0_1());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3062:1: ( (lv_exp_2_0= ruleExp ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3063:1: (lv_exp_2_0= ruleExp )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3063:1: (lv_exp_2_0= ruleExp )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3064:3: lv_exp_2_0= ruleExp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFieldAccess().getExpExpParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExp_in_ruleField5972);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3081:6: (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3081:6: (otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3081:8: otherlv_3= '~' ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) )
                    {
                    otherlv_3=(Token)match(input,60,FOLLOW_60_in_ruleField5992); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFieldAccess().getTildeKeyword_1_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3085:1: ( ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3086:1: ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3086:1: ( (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3087:1: (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3087:1: (lv_name_4_1= RULE_ID | lv_name_4_2= RULE_S )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==RULE_ID) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==RULE_S) ) {
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3088:3: lv_name_4_1= RULE_ID
                            {
                            lv_name_4_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleField6011); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3103:8: lv_name_4_2= RULE_S
                            {
                            lv_name_4_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleField6031); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3129:1: entryRuleValueDecl returns [EObject current=null] : iv_ruleValueDecl= ruleValueDecl EOF ;
    public final EObject entryRuleValueDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueDecl = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3130:2: (iv_ruleValueDecl= ruleValueDecl EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3131:2: iv_ruleValueDecl= ruleValueDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueDeclRule()); 
            }
            pushFollow(FOLLOW_ruleValueDecl_in_entryRuleValueDecl6076);
            iv_ruleValueDecl=ruleValueDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueDecl6086); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3138:1: ruleValueDecl returns [EObject current=null] : (otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3141:28: ( (otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3142:1: (otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3142:1: (otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3142:3: otherlv_0= 'val' ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleValueDecl6123); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getValueDeclAccess().getValKeyword_0());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3146:1: ( ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( (lv_name_2_0= ruleSYM ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) && (synpred10_InternalGDSL())) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_S) && (synpred10_InternalGDSL())) {
                alt70=1;
            }
            else if ( ((LA70_0>=RULE_LESS && LA70_0<=RULE_GREATER)||(LA70_0>=RULE_DOT && LA70_0<=RULE_USCORE)||(LA70_0>=RULE_BS && LA70_0<=RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER)) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3146:2: ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3146:2: ( ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3146:3: ( ( ( RULE_ID | RULE_S ) ) )=> ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3157:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3158:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3158:1: (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3159:3: lv_name_1_1= RULE_ID
                            {
                            lv_name_1_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueDecl6169); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3174:8: lv_name_1_2= RULE_S
                            {
                            lv_name_1_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleValueDecl6189); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3193:6: ( (lv_name_2_0= ruleSYM ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3193:6: ( (lv_name_2_0= ruleSYM ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3194:1: (lv_name_2_0= ruleSYM )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3194:1: (lv_name_2_0= ruleSYM )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3195:3: lv_name_2_0= ruleSYM
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueDeclAccess().getNameSYMParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSYM_in_ruleValueDecl6224);
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

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3211:3: ( ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0>=RULE_ID && LA72_0<=RULE_S)) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3212:1: ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3212:1: ( (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S ) )
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3213:1: (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S )
            	    {
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3213:1: (lv_ids_3_1= RULE_ID | lv_ids_3_2= RULE_S )
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3214:3: lv_ids_3_1= RULE_ID
            	            {
            	            lv_ids_3_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueDecl6244); if (state.failed) return current;
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
            	            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3229:8: lv_ids_3_2= RULE_S
            	            {
            	            lv_ids_3_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleValueDecl6264); if (state.failed) return current;
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
            	    break loop72;
                }
            } while (true);

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleValueDecl6285); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getValueDeclAccess().getEqualsSignKeyword_3());
                  
            }
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3251:1: ( (lv_exp_5_0= ruleExp ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3252:1: (lv_exp_5_0= ruleExp )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3252:1: (lv_exp_5_0= ruleExp )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3253:3: lv_exp_5_0= ruleExp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueDeclAccess().getExpExpParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExp_in_ruleValueDecl6306);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3277:1: entryRulePAT returns [EObject current=null] : iv_rulePAT= rulePAT EOF ;
    public final EObject entryRulePAT() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3278:2: (iv_rulePAT= rulePAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3279:2: iv_rulePAT= rulePAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPATRule()); 
            }
            pushFollow(FOLLOW_rulePAT_in_entryRulePAT6342);
            iv_rulePAT=rulePAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePAT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePAT6352); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3286:1: rulePAT returns [EObject current=null] : ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) ) ;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3289:28: ( ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3290:1: ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3290:1: ( ( (lv_uscore_0_0= RULE_USCORE ) ) | ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) ) | ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) ) | (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' ) )
            int alt75=4;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_USCORE) ) {
                alt75=1;
            }
            else if ( (LA75_0==RULE_POSINT_WO_DUALS) && (synpred11_InternalGDSL())) {
                alt75=2;
            }
            else if ( (LA75_0==RULE_DUALS) && (synpred11_InternalGDSL())) {
                alt75=2;
            }
            else if ( (LA75_0==RULE_HEXINT) && (synpred11_InternalGDSL())) {
                alt75=2;
            }
            else if ( (LA75_0==RULE_NEGINT) && (synpred11_InternalGDSL())) {
                alt75=2;
            }
            else if ( (LA75_0==RULE_ID) && (synpred12_InternalGDSL())) {
                alt75=3;
            }
            else if ( (LA75_0==RULE_S) && (synpred12_InternalGDSL())) {
                alt75=3;
            }
            else if ( (LA75_0==65) ) {
                alt75=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3290:2: ( (lv_uscore_0_0= RULE_USCORE ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3290:2: ( (lv_uscore_0_0= RULE_USCORE ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3291:1: (lv_uscore_0_0= RULE_USCORE )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3291:1: (lv_uscore_0_0= RULE_USCORE )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3292:3: lv_uscore_0_0= RULE_USCORE
                    {
                    lv_uscore_0_0=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_rulePAT6394); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3309:6: ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3309:6: ( ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3309:7: ( ( ( ruleINTEGER ) ) )=> ( (lv_int_1_0= ruleINTEGER ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3313:5: ( (lv_int_1_0= ruleINTEGER ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3314:1: (lv_int_1_0= ruleINTEGER )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3314:1: (lv_int_1_0= ruleINTEGER )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3315:3: lv_int_1_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPATAccess().getIntINTEGERParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_rulePAT6439);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3332:6: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3332:6: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3332:7: ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )=> ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3346:7: ( ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3346:8: ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) ) ( (lv_pat_3_0= rulePAT ) )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3346:8: ( ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3347:1: ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3347:1: ( (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3348:1: (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3348:1: (lv_id_2_1= RULE_ID | lv_id_2_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3349:3: lv_id_2_1= RULE_ID
                            {
                            lv_id_2_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePAT6507); if (state.failed) return current;
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3364:8: lv_id_2_2= RULE_S
                            {
                            lv_id_2_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_rulePAT6527); if (state.failed) return current;
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

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3382:2: ( (lv_pat_3_0= rulePAT ) )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_S)||(LA74_0>=RULE_USCORE && LA74_0<=RULE_HEXINT)||(LA74_0>=RULE_NEGINT && LA74_0<=RULE_DUALS)||LA74_0==65) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3383:1: (lv_pat_3_0= rulePAT )
                            {
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3383:1: (lv_pat_3_0= rulePAT )
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3384:3: lv_pat_3_0= rulePAT
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPATAccess().getPatPATParserRuleCall_2_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePAT_in_rulePAT6556);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3401:6: (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3401:6: (otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3401:8: otherlv_4= '\\'' ( (lv_bitpat_5_0= ruleBITPAT ) ) otherlv_6= '\\''
                    {
                    otherlv_4=(Token)match(input,65,FOLLOW_65_in_rulePAT6578); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPATAccess().getApostropheKeyword_3_0());
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3405:1: ( (lv_bitpat_5_0= ruleBITPAT ) )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3406:1: (lv_bitpat_5_0= ruleBITPAT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3406:1: (lv_bitpat_5_0= ruleBITPAT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3407:3: lv_bitpat_5_0= ruleBITPAT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPATAccess().getBitpatBITPATParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBITPAT_in_rulePAT6599);
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

                    otherlv_6=(Token)match(input,65,FOLLOW_65_in_rulePAT6611); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3435:1: entryRuleCONS returns [EObject current=null] : iv_ruleCONS= ruleCONS EOF ;
    public final EObject entryRuleCONS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCONS = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3436:2: (iv_ruleCONS= ruleCONS EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3437:2: iv_ruleCONS= ruleCONS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCONSRule()); 
            }
            pushFollow(FOLLOW_ruleCONS_in_entryRuleCONS6648);
            iv_ruleCONS=ruleCONS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCONS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONS6658); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3444:1: ruleCONS returns [EObject current=null] : ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) ) ;
    public final EObject ruleCONS() throws RecognitionException {
        EObject current = null;

        Token lv_conName_0_1=null;
        Token lv_conName_0_2=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3447:28: ( ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3448:1: ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3448:1: ( ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3449:1: ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3449:1: ( (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3450:1: (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3450:1: (lv_conName_0_1= RULE_ID | lv_conName_0_2= RULE_S )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            else if ( (LA76_0==RULE_S) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3451:3: lv_conName_0_1= RULE_ID
                    {
                    lv_conName_0_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCONS6701); if (state.failed) return current;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3466:8: lv_conName_0_2= RULE_S
                    {
                    lv_conName_0_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleCONS6721); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3492:1: entryRuleDECODEPAT returns [String current=null] : iv_ruleDECODEPAT= ruleDECODEPAT EOF ;
    public final String entryRuleDECODEPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDECODEPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3493:2: (iv_ruleDECODEPAT= ruleDECODEPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3494:2: iv_ruleDECODEPAT= ruleDECODEPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDECODEPATRule()); 
            }
            pushFollow(FOLLOW_ruleDECODEPAT_in_entryRuleDECODEPAT6765);
            iv_ruleDECODEPAT=ruleDECODEPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDECODEPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDECODEPAT6776); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3501:1: ruleDECODEPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT ) ;
    public final AntlrDatatypeRuleToken ruleDECODEPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_BITPAT_1 = null;

        AntlrDatatypeRuleToken this_TOKPAT_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3504:28: ( ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3505:1: ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3505:1: ( (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' ) | this_TOKPAT_3= ruleTOKPAT )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==65) ) {
                alt78=1;
            }
            else if ( ((LA78_0>=RULE_ID && LA78_0<=RULE_S)||LA78_0==RULE_HEXINT) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3505:2: (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3505:2: (kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3506:2: kw= '\\'' (this_BITPAT_1= ruleBITPAT )+ kw= '\\''
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleDECODEPAT6815); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDECODEPATAccess().getApostropheKeyword_0_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3511:1: (this_BITPAT_1= ruleBITPAT )+
                    int cnt77=0;
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( ((LA77_0>=RULE_ID && LA77_0<=RULE_S)||LA77_0==RULE_DOT||LA77_0==RULE_BS||(LA77_0>=RULE_DUALS && LA77_0<=RULE_BINS)) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3512:5: this_BITPAT_1= ruleBITPAT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getDECODEPATAccess().getBITPATParserRuleCall_0_1()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_ruleBITPAT_in_ruleDECODEPAT6838);
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
                    	    if ( cnt77 >= 1 ) break loop77;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(77, input);
                                throw eee;
                        }
                        cnt77++;
                    } while (true);

                    kw=(Token)match(input,65,FOLLOW_65_in_ruleDECODEPAT6858); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDECODEPATAccess().getApostropheKeyword_0_2()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3530:5: this_TOKPAT_3= ruleTOKPAT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDECODEPATAccess().getTOKPATParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTOKPAT_in_ruleDECODEPAT6887);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3548:1: entryRuleTOKPAT returns [String current=null] : iv_ruleTOKPAT= ruleTOKPAT EOF ;
    public final String entryRuleTOKPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTOKPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3549:2: (iv_ruleTOKPAT= ruleTOKPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3550:2: iv_ruleTOKPAT= ruleTOKPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTOKPATRule()); 
            }
            pushFollow(FOLLOW_ruleTOKPAT_in_entryRuleTOKPAT6933);
            iv_ruleTOKPAT=ruleTOKPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTOKPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTOKPAT6944); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3557:1: ruleTOKPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) ) ;
    public final AntlrDatatypeRuleToken ruleTOKPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEXINT_0=null;
        Token this_ID_1=null;
        Token this_S_2=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3560:28: ( (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3561:1: (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3561:1: (this_HEXINT_0= RULE_HEXINT | (this_ID_1= RULE_ID | this_S_2= RULE_S ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_HEXINT) ) {
                alt80=1;
            }
            else if ( ((LA80_0>=RULE_ID && LA80_0<=RULE_S)) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3561:6: this_HEXINT_0= RULE_HEXINT
                    {
                    this_HEXINT_0=(Token)match(input,RULE_HEXINT,FOLLOW_RULE_HEXINT_in_ruleTOKPAT6984); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXINT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEXINT_0, grammarAccess.getTOKPATAccess().getHEXINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3569:6: (this_ID_1= RULE_ID | this_S_2= RULE_S )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3569:6: (this_ID_1= RULE_ID | this_S_2= RULE_S )
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==RULE_ID) ) {
                        alt79=1;
                    }
                    else if ( (LA79_0==RULE_S) ) {
                        alt79=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 79, 0, input);

                        throw nvae;
                    }
                    switch (alt79) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3569:11: this_ID_1= RULE_ID
                            {
                            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTOKPAT7011); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_ID_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_ID_1, grammarAccess.getTOKPATAccess().getIDTerminalRuleCall_1_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3577:10: this_S_2= RULE_S
                            {
                            this_S_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleTOKPAT7037); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3592:1: entryRuleBITPAT returns [String current=null] : iv_ruleBITPAT= ruleBITPAT EOF ;
    public final String entryRuleBITPAT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITPAT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3593:2: (iv_ruleBITPAT= ruleBITPAT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3594:2: iv_ruleBITPAT= ruleBITPAT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITPATRule()); 
            }
            pushFollow(FOLLOW_ruleBITPAT_in_entryRuleBITPAT7084);
            iv_ruleBITPAT=ruleBITPAT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITPAT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITPAT7095); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3601:1: ruleBITPAT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) ) ;
    public final AntlrDatatypeRuleToken ruleBITPAT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_1=null;
        Token this_S_2=null;
        AntlrDatatypeRuleToken this_BINARY_0 = null;

        AntlrDatatypeRuleToken this_BITPATORINT_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3604:28: ( (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3605:1: (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3605:1: (this_BINARY_0= ruleBINARY | ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? ) )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_DOT||LA83_0==RULE_BS||(LA83_0>=RULE_DUALS && LA83_0<=RULE_BINS)) ) {
                alt83=1;
            }
            else if ( ((LA83_0>=RULE_ID && LA83_0<=RULE_S)) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3606:5: this_BINARY_0= ruleBINARY
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATAccess().getBINARYParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBINARY_in_ruleBITPAT7142);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3617:6: ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3617:6: ( (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )? )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3617:7: (this_ID_1= RULE_ID | this_S_2= RULE_S ) (this_BITPATORINT_3= ruleBITPATORINT )?
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3617:7: (this_ID_1= RULE_ID | this_S_2= RULE_S )
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
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3617:12: this_ID_1= RULE_ID
                            {
                            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBITPAT7170); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_ID_1);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_ID_1, grammarAccess.getBITPATAccess().getIDTerminalRuleCall_1_0_0()); 
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3625:10: this_S_2= RULE_S
                            {
                            this_S_2=(Token)match(input,RULE_S,FOLLOW_RULE_S_in_ruleBITPAT7196); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_S_2);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_S_2, grammarAccess.getBITPATAccess().getSTerminalRuleCall_1_0_1()); 
                                  
                            }

                            }
                            break;

                    }

                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3632:2: (this_BITPATORINT_3= ruleBITPATORINT )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==27||LA82_0==61) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3633:5: this_BITPATORINT_3= ruleBITPATORINT
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getBITPATAccess().getBITPATORINTParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBITPATORINT_in_ruleBITPAT7225);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3651:1: entryRuleBITPATORINT returns [String current=null] : iv_ruleBITPATORINT= ruleBITPATORINT EOF ;
    public final String entryRuleBITPATORINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBITPATORINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3652:2: (iv_ruleBITPATORINT= ruleBITPATORINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3653:2: iv_ruleBITPATORINT= ruleBITPATORINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBITPATORINTRule()); 
            }
            pushFollow(FOLLOW_ruleBITPATORINT_in_entryRuleBITPATORINT7274);
            iv_ruleBITPATORINT=ruleBITPATORINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBITPATORINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBITPATORINT7285); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3660:1: ruleBITPATORINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) ) ;
    public final AntlrDatatypeRuleToken ruleBITPATORINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_POSINT_1 = null;

        AntlrDatatypeRuleToken this_BINARY_3 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3663:28: ( ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3664:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3664:1: ( (kw= ':' this_POSINT_1= rulePOSINT ) | (kw= '@' this_BINARY_3= ruleBINARY ) )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==27) ) {
                alt84=1;
            }
            else if ( (LA84_0==61) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3664:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3664:2: (kw= ':' this_POSINT_1= rulePOSINT )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3665:2: kw= ':' this_POSINT_1= rulePOSINT
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleBITPATORINT7324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBITPATORINTAccess().getColonKeyword_0_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATORINTAccess().getPOSINTParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleBITPATORINT7346);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3682:6: (kw= '@' this_BINARY_3= ruleBINARY )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3682:6: (kw= '@' this_BINARY_3= ruleBINARY )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3683:2: kw= '@' this_BINARY_3= ruleBINARY
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleBITPATORINT7372); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBITPATORINTAccess().getCommercialAtKeyword_1_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBITPATORINTAccess().getBINARYParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBINARY_in_ruleBITPATORINT7394);
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3707:1: entryRuleLIT returns [String current=null] : iv_ruleLIT= ruleLIT EOF ;
    public final String entryRuleLIT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLIT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3708:2: (iv_ruleLIT= ruleLIT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3709:2: iv_ruleLIT= ruleLIT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLITRule()); 
            }
            pushFollow(FOLLOW_ruleLIT_in_entryRuleLIT7441);
            iv_ruleLIT=ruleLIT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLIT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLIT7452); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3716:1: ruleLIT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) ) ;
    public final AntlrDatatypeRuleToken ruleLIT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_INTEGER_0 = null;

        AntlrDatatypeRuleToken this_BINARY_2 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3719:28: ( (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3720:1: (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3720:1: (this_INTEGER_0= ruleINTEGER | (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_HEXINT||(LA86_0>=RULE_NEGINT && LA86_0<=RULE_DUALS)) ) {
                alt86=1;
            }
            else if ( (LA86_0==65) ) {
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3721:5: this_INTEGER_0= ruleINTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLITAccess().getINTEGERParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleINTEGER_in_ruleLIT7499);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3732:6: (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' )
                    {
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3732:6: (kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\'' )
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3733:2: kw= '\\'' (this_BINARY_2= ruleBINARY )? kw= '\\''
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleLIT7524); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLITAccess().getApostropheKeyword_1_0()); 
                          
                    }
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3738:1: (this_BINARY_2= ruleBINARY )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==RULE_DOT||LA85_0==RULE_BS||(LA85_0>=RULE_DUALS && LA85_0<=RULE_BINS)) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3739:5: this_BINARY_2= ruleBINARY
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getLITAccess().getBINARYParserRuleCall_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleBINARY_in_ruleLIT7547);
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

                    kw=(Token)match(input,65,FOLLOW_65_in_ruleLIT7567); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3763:1: entryRuleMID returns [String current=null] : iv_ruleMID= ruleMID EOF ;
    public final String entryRuleMID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMID = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3764:2: (iv_ruleMID= ruleMID EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3765:2: iv_ruleMID= ruleMID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMIDRule()); 
            }
            pushFollow(FOLLOW_ruleMID_in_entryRuleMID7609);
            iv_ruleMID=ruleMID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMID7620); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3772:1: ruleMID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE ) ;
    public final AntlrDatatypeRuleToken ruleMID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MIXID_0=null;
        Token this_USCORE_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3775:28: ( (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3776:1: (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3776:1: (this_MIXID_0= RULE_MIXID | this_USCORE_1= RULE_USCORE )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_MIXID) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_USCORE) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3776:6: this_MIXID_0= RULE_MIXID
                    {
                    this_MIXID_0=(Token)match(input,RULE_MIXID,FOLLOW_RULE_MIXID_in_ruleMID7660); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MIXID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_MIXID_0, grammarAccess.getMIDAccess().getMIXIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3784:10: this_USCORE_1= RULE_USCORE
                    {
                    this_USCORE_1=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_ruleMID7686); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3799:1: entryRuleSYM returns [String current=null] : iv_ruleSYM= ruleSYM EOF ;
    public final String entryRuleSYM() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSYM = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3800:2: (iv_ruleSYM= ruleSYM EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3801:2: iv_ruleSYM= ruleSYM EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSYMRule()); 
            }
            pushFollow(FOLLOW_ruleSYM_in_entryRuleSYM7732);
            iv_ruleSYM=ruleSYM();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSYM.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSYM7743); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3808:1: ruleSYM returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_5= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER ) ;
    public final AntlrDatatypeRuleToken ruleSYM() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_USCORE_0=null;
        Token this_BS_1=null;
        Token this_DOT_2=null;
        Token this_LESS_3=null;
        Token this_GREATER_4=null;
        Token this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_5=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3811:28: ( (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_5= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3812:1: (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_5= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3812:1: (this_USCORE_0= RULE_USCORE | this_BS_1= RULE_BS | this_DOT_2= RULE_DOT | this_LESS_3= RULE_LESS | this_GREATER_4= RULE_GREATER | this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_5= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER )
            int alt88=6;
            switch ( input.LA(1) ) {
            case RULE_USCORE:
                {
                alt88=1;
                }
                break;
            case RULE_BS:
                {
                alt88=2;
                }
                break;
            case RULE_DOT:
                {
                alt88=3;
                }
                break;
            case RULE_LESS:
                {
                alt88=4;
                }
                break;
            case RULE_GREATER:
                {
                alt88=5;
                }
                break;
            case RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER:
                {
                alt88=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3812:6: this_USCORE_0= RULE_USCORE
                    {
                    this_USCORE_0=(Token)match(input,RULE_USCORE,FOLLOW_RULE_USCORE_in_ruleSYM7783); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_USCORE_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_USCORE_0, grammarAccess.getSYMAccess().getUSCORETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3820:10: this_BS_1= RULE_BS
                    {
                    this_BS_1=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleSYM7809); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_1, grammarAccess.getSYMAccess().getBSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3828:10: this_DOT_2= RULE_DOT
                    {
                    this_DOT_2=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSYM7835); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_2, grammarAccess.getSYMAccess().getDOTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3836:10: this_LESS_3= RULE_LESS
                    {
                    this_LESS_3=(Token)match(input,RULE_LESS,FOLLOW_RULE_LESS_in_ruleSYM7861); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_LESS_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LESS_3, grammarAccess.getSYMAccess().getLESSTerminalRuleCall_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3844:10: this_GREATER_4= RULE_GREATER
                    {
                    this_GREATER_4=(Token)match(input,RULE_GREATER,FOLLOW_RULE_GREATER_in_ruleSYM7887); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_GREATER_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_GREATER_4, grammarAccess.getSYMAccess().getGREATERTerminalRuleCall_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3852:10: this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_5= RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER
                    {
                    this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_5=(Token)match(input,RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER,FOLLOW_RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_in_ruleSYM7913); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_5);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_5, grammarAccess.getSYMAccess().getSYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATERTerminalRuleCall_5()); 
                          
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3867:1: entryRuleINTEGER returns [String current=null] : iv_ruleINTEGER= ruleINTEGER EOF ;
    public final String entryRuleINTEGER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTEGER = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3868:2: (iv_ruleINTEGER= ruleINTEGER EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3869:2: iv_ruleINTEGER= ruleINTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleINTEGER_in_entryRuleINTEGER7959);
            iv_ruleINTEGER=ruleINTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTEGER.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTEGER7970); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3876:1: ruleINTEGER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT ) ;
    public final AntlrDatatypeRuleToken ruleINTEGER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEXINT_1=null;
        Token this_NEGINT_2=null;
        AntlrDatatypeRuleToken this_POSINT_0 = null;


         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3879:28: ( (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3880:1: (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3880:1: (this_POSINT_0= rulePOSINT | this_HEXINT_1= RULE_HEXINT | this_NEGINT_2= RULE_NEGINT )
            int alt89=3;
            switch ( input.LA(1) ) {
            case RULE_POSINT_WO_DUALS:
            case RULE_DUALS:
                {
                alt89=1;
                }
                break;
            case RULE_HEXINT:
                {
                alt89=2;
                }
                break;
            case RULE_NEGINT:
                {
                alt89=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3881:5: this_POSINT_0= rulePOSINT
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getINTEGERAccess().getPOSINTParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePOSINT_in_ruleINTEGER8017);
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3892:10: this_HEXINT_1= RULE_HEXINT
                    {
                    this_HEXINT_1=(Token)match(input,RULE_HEXINT,FOLLOW_RULE_HEXINT_in_ruleINTEGER8043); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_HEXINT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_HEXINT_1, grammarAccess.getINTEGERAccess().getHEXINTTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3900:10: this_NEGINT_2= RULE_NEGINT
                    {
                    this_NEGINT_2=(Token)match(input,RULE_NEGINT,FOLLOW_RULE_NEGINT_in_ruleINTEGER8069); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3915:1: entryRulePOSINT returns [String current=null] : iv_rulePOSINT= rulePOSINT EOF ;
    public final String entryRulePOSINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePOSINT = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3916:2: (iv_rulePOSINT= rulePOSINT EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3917:2: iv_rulePOSINT= rulePOSINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPOSINTRule()); 
            }
            pushFollow(FOLLOW_rulePOSINT_in_entryRulePOSINT8115);
            iv_rulePOSINT=rulePOSINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePOSINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePOSINT8126); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3924:1: rulePOSINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS ) ;
    public final AntlrDatatypeRuleToken rulePOSINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_POSINT_WO_DUALS_0=null;
        Token this_DUALS_1=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3927:28: ( (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3928:1: (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3928:1: (this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS | this_DUALS_1= RULE_DUALS )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_POSINT_WO_DUALS) ) {
                alt90=1;
            }
            else if ( (LA90_0==RULE_DUALS) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3928:6: this_POSINT_WO_DUALS_0= RULE_POSINT_WO_DUALS
                    {
                    this_POSINT_WO_DUALS_0=(Token)match(input,RULE_POSINT_WO_DUALS,FOLLOW_RULE_POSINT_WO_DUALS_in_rulePOSINT8166); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_POSINT_WO_DUALS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_POSINT_WO_DUALS_0, grammarAccess.getPOSINTAccess().getPOSINT_WO_DUALSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3936:10: this_DUALS_1= RULE_DUALS
                    {
                    this_DUALS_1=(Token)match(input,RULE_DUALS,FOLLOW_RULE_DUALS_in_rulePOSINT8192); if (state.failed) return current;
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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3951:1: entryRuleBINARY returns [String current=null] : iv_ruleBINARY= ruleBINARY EOF ;
    public final String entryRuleBINARY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBINARY = null;


        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3952:2: (iv_ruleBINARY= ruleBINARY EOF )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3953:2: iv_ruleBINARY= ruleBINARY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBINARYRule()); 
            }
            pushFollow(FOLLOW_ruleBINARY_in_entryRuleBINARY8238);
            iv_ruleBINARY=ruleBINARY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBINARY.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBINARY8249); if (state.failed) return current;

            }

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
    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3960:1: ruleBINARY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT ) ;
    public final AntlrDatatypeRuleToken ruleBINARY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DUALS_0=null;
        Token this_BINS_1=null;
        Token this_BS_2=null;
        Token this_DOT_3=null;

         enterRule(); 
            
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3963:28: ( (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3964:1: (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT )
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3964:1: (this_DUALS_0= RULE_DUALS | this_BINS_1= RULE_BINS | this_BS_2= RULE_BS | this_DOT_3= RULE_DOT )
            int alt91=4;
            switch ( input.LA(1) ) {
            case RULE_DUALS:
                {
                alt91=1;
                }
                break;
            case RULE_BINS:
                {
                alt91=2;
                }
                break;
            case RULE_BS:
                {
                alt91=3;
                }
                break;
            case RULE_DOT:
                {
                alt91=4;
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
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3964:6: this_DUALS_0= RULE_DUALS
                    {
                    this_DUALS_0=(Token)match(input,RULE_DUALS,FOLLOW_RULE_DUALS_in_ruleBINARY8289); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DUALS_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DUALS_0, grammarAccess.getBINARYAccess().getDUALSTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3972:10: this_BINS_1= RULE_BINS
                    {
                    this_BINS_1=(Token)match(input,RULE_BINS,FOLLOW_RULE_BINS_in_ruleBINARY8315); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BINS_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BINS_1, grammarAccess.getBINARYAccess().getBINSTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3980:10: this_BS_2= RULE_BS
                    {
                    this_BS_2=(Token)match(input,RULE_BS,FOLLOW_RULE_BS_in_ruleBINARY8341); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_BS_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_BS_2, grammarAccess.getBINARYAccess().getBSTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3988:10: this_DOT_3= RULE_DOT
                    {
                    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleBINARY8367); if (state.failed) return current;
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
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:3: ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:4: ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:4: ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:5: ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )*
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:313:5: ( ( ruleConDecl ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:314:1: ( ruleConDecl )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:314:1: ( ruleConDecl )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:315:1: ruleConDecl
        {
        pushFollow(FOLLOW_ruleConDecl_in_synpred1_InternalGDSL635);
        ruleConDecl();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:2: ( '|' ( ( ruleConDecl ) ) )*
        loop92:
        do {
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==30) ) {
                alt92=1;
            }


            switch (alt92) {
        	case 1 :
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:317:4: '|' ( ( ruleConDecl ) )
        	    {
        	    match(input,30,FOLLOW_30_in_synpred1_InternalGDSL642); if (state.failed) return ;
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:318:1: ( ( ruleConDecl ) )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:319:1: ( ruleConDecl )
        	    {
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:319:1: ( ruleConDecl )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:320:1: ruleConDecl
        	    {
        	    pushFollow(FOLLOW_ruleConDecl_in_synpred1_InternalGDSL649);
        	    ruleConDecl();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop92;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred1_InternalGDSL

    // $ANTLR start synpred2_InternalGDSL
    public final void synpred2_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:480:7: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:481:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:481:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:482:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred2_InternalGDSL973);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalGDSL

    // $ANTLR start synpred3_InternalGDSL
    public final void synpred3_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:3: ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:4: ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:4: ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:5: ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:5: ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) )
        int alt93=2;
        int LA93_0 = input.LA(1);

        if ( ((LA93_0>=RULE_ID && LA93_0<=RULE_S)) ) {
            alt93=1;
        }
        else if ( (LA93_0==RULE_USCORE) && (synpred2_InternalGDSL())) {
            alt93=2;
        }
        else if ( (LA93_0==RULE_BS) && (synpred2_InternalGDSL())) {
            alt93=2;
        }
        else if ( (LA93_0==RULE_DOT) && (synpred2_InternalGDSL())) {
            alt93=2;
        }
        else if ( (LA93_0==RULE_LESS) && (synpred2_InternalGDSL())) {
            alt93=2;
        }
        else if ( (LA93_0==RULE_GREATER) && (synpred2_InternalGDSL())) {
            alt93=2;
        }
        else if ( (LA93_0==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred2_InternalGDSL())) {
            alt93=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 93, 0, input);

            throw nvae;
        }
        switch (alt93) {
            case 1 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:6: ( ( ( RULE_ID | RULE_S ) ) )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:469:6: ( ( ( RULE_ID | RULE_S ) ) )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:470:1: ( ( RULE_ID | RULE_S ) )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:470:1: ( ( RULE_ID | RULE_S ) )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:471:1: ( RULE_ID | RULE_S )
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
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:480:6: ( ( ( ruleSYM ) )=> ( ruleSYM ) )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:480:6: ( ( ( ruleSYM ) )=> ( ruleSYM ) )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:480:7: ( ( ruleSYM ) )=> ( ruleSYM )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:485:1: ( ruleSYM )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:486:1: ruleSYM
                {
                pushFollow(FOLLOW_ruleSYM_in_synpred3_InternalGDSL982);
                ruleSYM();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:488:3: ( ( ( RULE_ID | RULE_S ) ) )*
        loop94:
        do {
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( ((LA94_0>=RULE_ID && LA94_0<=RULE_S)) ) {
                alt94=1;
            }


            switch (alt94) {
        	case 1 :
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:489:1: ( ( RULE_ID | RULE_S ) )
        	    {
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:489:1: ( ( RULE_ID | RULE_S ) )
        	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:490:1: ( RULE_ID | RULE_S )
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
        	    break loop94;
            }
        } while (true);

        match(input,29,FOLLOW_29_in_synpred3_InternalGDSL1015); if (state.failed) return ;
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:499:1: ( ( ruleExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:500:1: ( ruleExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:500:1: ( ruleExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:501:1: ruleExp
        {
        pushFollow(FOLLOW_ruleExp_in_synpred3_InternalGDSL1022);
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
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:540:7: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:541:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:541:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:542:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred4_InternalGDSL1090);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalGDSL

    // $ANTLR start synpred5_InternalGDSL
    public final void synpred5_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1945:3: ( ( ruleExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1946:1: ( ruleExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1946:1: ( ruleExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1947:1: ruleExp
        {
        pushFollow(FOLLOW_ruleExp_in_synpred5_InternalGDSL3744);
        ruleExp();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalGDSL

    // $ANTLR start synpred6_InternalGDSL
    public final void synpred6_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2194:3: ( ( ruleSYM ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2195:1: ( ruleSYM )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2195:1: ( ruleSYM )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2196:1: ruleSYM
        {
        pushFollow(FOLLOW_ruleSYM_in_synpred6_InternalGDSL4268);
        ruleSYM();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalGDSL

    // $ANTLR start synpred7_InternalGDSL
    public final void synpred7_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2477:7: ( ( ( ruleAtomicExp ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2477:8: ( ( ruleAtomicExp ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2477:8: ( ( ruleAtomicExp ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2478:1: ( ruleAtomicExp )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2478:1: ( ruleAtomicExp )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2479:1: ruleAtomicExp
        {
        pushFollow(FOLLOW_ruleAtomicExp_in_synpred7_InternalGDSL4925);
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
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2594:4: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2594:6: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred8_InternalGDSL5133); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalGDSL

    // $ANTLR start synpred9_InternalGDSL
    public final void synpred9_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2766:3: ( RULE_DOT )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:2766:5: RULE_DOT
        {
        match(input,RULE_DOT,FOLLOW_RULE_DOT_in_synpred9_InternalGDSL5440); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalGDSL

    // $ANTLR start synpred10_InternalGDSL
    public final void synpred10_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3146:3: ( ( ( RULE_ID | RULE_S ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3147:1: ( ( RULE_ID | RULE_S ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3147:1: ( ( RULE_ID | RULE_S ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3148:1: ( RULE_ID | RULE_S )
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
    // $ANTLR end synpred10_InternalGDSL

    // $ANTLR start synpred11_InternalGDSL
    public final void synpred11_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3309:7: ( ( ( ruleINTEGER ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3309:8: ( ( ruleINTEGER ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3309:8: ( ( ruleINTEGER ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3310:1: ( ruleINTEGER )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3310:1: ( ruleINTEGER )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3311:1: ruleINTEGER
        {
        pushFollow(FOLLOW_ruleINTEGER_in_synpred11_InternalGDSL6420);
        ruleINTEGER();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred11_InternalGDSL

    // $ANTLR start synpred12_InternalGDSL
    public final void synpred12_InternalGDSL_fragment() throws RecognitionException {   
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3332:7: ( ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3332:8: ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3332:8: ( ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )? )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3332:9: ( ( ( RULE_ID | RULE_S ) ) ) ( ( rulePAT ) )?
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3332:9: ( ( ( RULE_ID | RULE_S ) ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3333:1: ( ( RULE_ID | RULE_S ) )
        {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3333:1: ( ( RULE_ID | RULE_S ) )
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3334:1: ( RULE_ID | RULE_S )
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

        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3342:2: ( ( rulePAT ) )?
        int alt95=2;
        int LA95_0 = input.LA(1);

        if ( ((LA95_0>=RULE_ID && LA95_0<=RULE_S)||(LA95_0>=RULE_USCORE && LA95_0<=RULE_HEXINT)||(LA95_0>=RULE_NEGINT && LA95_0<=RULE_DUALS)||LA95_0==65) ) {
            alt95=1;
        }
        switch (alt95) {
            case 1 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3343:1: ( rulePAT )
                {
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3343:1: ( rulePAT )
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3344:1: rulePAT
                {
                pushFollow(FOLLOW_rulePAT_in_synpred12_InternalGDSL6487);
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
    // $ANTLR end synpred12_InternalGDSL

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


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA51 dfa51 = new DFA51(this);
    static final String DFA7_eotS =
        "\14\uffff";
    static final String DFA7_eofS =
        "\2\uffff\1\13\11\uffff";
    static final String DFA7_minS =
        "\1\4\1\0\1\4\11\uffff";
    static final String DFA7_maxS =
        "\1\54\1\0\1\54\11\uffff";
    static final String DFA7_acceptS =
        "\3\uffff\1\2\10\1";
    static final String DFA7_specialS =
        "\1\uffff\1\0\1\1\11\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\1\2\5\uffff\1\3\3\uffff\3\3\22\uffff\4\3\1\uffff\1\3\2"+
            "\uffff\1\3",
            "\1\uffff",
            "\2\3\5\uffff\1\3\3\uffff\3\3\7\uffff\1\7\1\10\1\uffff\1\11"+
            "\1\uffff\1\6\1\12\3\uffff\1\5\4\3\1\uffff\1\3\2\uffff\1\3",
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

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "313:1: ( ( ( ( ( ( ruleConDecl ) ) ( '|' ( ( ruleConDecl ) ) )* ) )=> ( ( (lv_conDecl_3_0= ruleConDecl ) ) (otherlv_4= '|' ( (lv_conDecl_5_0= ruleConDecl ) ) )* ) ) | ( (lv_value_6_0= ruleTy ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_1 = input.LA(1);

                         
                        int index7_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalGDSL()) ) {s = 4;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index7_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_2 = input.LA(1);

                         
                        int index7_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA7_2==35) && (synpred1_InternalGDSL())) {s = 5;}

                        else if ( (LA7_2==30) && (synpred1_InternalGDSL())) {s = 6;}

                        else if ( (LA7_2==25) && (synpred1_InternalGDSL())) {s = 7;}

                        else if ( (LA7_2==26) && (synpred1_InternalGDSL())) {s = 8;}

                        else if ( (LA7_2==28) && (synpred1_InternalGDSL())) {s = 9;}

                        else if ( (LA7_2==31) && (synpred1_InternalGDSL())) {s = 10;}

                        else if ( (LA7_2==EOF) && (synpred1_InternalGDSL())) {s = 11;}

                        else if ( ((LA7_2>=RULE_ID && LA7_2<=RULE_S)||LA7_2==RULE_HEXINT||(LA7_2>=RULE_NEGINT && LA7_2<=RULE_DUALS)||(LA7_2>=36 && LA7_2<=39)||LA7_2==41||LA7_2==44) ) {s = 3;}

                         
                        input.seek(index7_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA20_eotS =
        "\14\uffff";
    static final String DFA20_eofS =
        "\14\uffff";
    static final String DFA20_minS =
        "\1\4\3\0\10\uffff";
    static final String DFA20_maxS =
        "\1\35\3\0\10\uffff";
    static final String DFA20_acceptS =
        "\4\uffff\5\1\1\2\1\uffff\1\3";
    static final String DFA20_specialS =
        "\1\0\1\1\1\2\1\3\10\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\1\2\1\6\1\7\1\uffff\1\5\1\3\1\uffff\1\11\1\4\1\10\16\uffff"+
            "\1\11",
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

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "469:1: ( ( ( ( ( ( ( ( RULE_ID | RULE_S ) ) ) | ( ( ( ruleSYM ) )=> ( ruleSYM ) ) ) ( ( ( RULE_ID | RULE_S ) ) )* '=' ( ( ruleExp ) ) ) )=> ( ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) | ( ( ( ruleSYM ) )=> (lv_name_2_0= ruleSYM ) ) ) ( ( (lv_attr_3_1= RULE_ID | lv_attr_3_2= RULE_S ) ) )* otherlv_4= '=' ( (lv_exp_5_0= ruleExp ) ) ) ) | ( ( ( (lv_mid_6_0= ruleMID ) ) ( ( (lv_attr_7_1= RULE_ID | lv_attr_7_2= RULE_S ) ) ) )* otherlv_8= '=' ( (lv_exp_9_0= ruleExp ) ) ) | ( ( ( (lv_name_10_1= RULE_ID | lv_name_10_2= RULE_S ) ) ) otherlv_11= '[' ( (lv_decPat_12_0= ruleDECODEPAT ) )* otherlv_13= ']' ( (otherlv_14= '=' ( (lv_exp_15_0= ruleExp ) ) ) | (otherlv_16= '|' ( (lv_exps_17_0= ruleExp ) ) otherlv_18= '=' ( (lv_exps_19_0= ruleExp ) ) )+ ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_0 = input.LA(1);

                         
                        int index20_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_0==RULE_ID) ) {s = 1;}

                        else if ( (LA20_0==RULE_S) ) {s = 2;}

                        else if ( (LA20_0==RULE_USCORE) ) {s = 3;}

                        else if ( (LA20_0==RULE_BS) && (synpred3_InternalGDSL())) {s = 4;}

                        else if ( (LA20_0==RULE_DOT) && (synpred3_InternalGDSL())) {s = 5;}

                        else if ( (LA20_0==RULE_LESS) && (synpred3_InternalGDSL())) {s = 6;}

                        else if ( (LA20_0==RULE_GREATER) && (synpred3_InternalGDSL())) {s = 7;}

                        else if ( (LA20_0==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred3_InternalGDSL())) {s = 8;}

                        else if ( (LA20_0==RULE_MIXID||LA20_0==29) ) {s = 9;}

                         
                        input.seek(index20_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_1 = input.LA(1);

                         
                        int index20_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_2 = input.LA(1);

                         
                        int index20_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalGDSL()) ) {s = 8;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\47\uffff";
    static final String DFA42_eofS =
        "\10\uffff\2\43\35\uffff";
    static final String DFA42_minS =
        "\1\4\7\uffff\2\4\35\uffff";
    static final String DFA42_maxS =
        "\1\101\7\uffff\2\101\35\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\7\1\2\uffff\34\1\1\2";
    static final String DFA42_specialS =
        "\1\0\7\uffff\1\1\1\2\35\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\10\1\11\2\uffff\1\7\1\uffff\1\23\1\4\1\22\2\uffff\1\5\1\2"+
            "\1\3\25\uffff\1\15\1\uffff\1\14\4\uffff\1\21\1\uffff\1\17\2"+
            "\uffff\1\20\10\uffff\1\1\1\12\1\13\1\16\1\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\44\1\45\1\34\1\35\1\7\1\24\1\32\1\4\1\uffff\1\33\1\36\1"+
            "\5\1\2\1\3\7\uffff\1\41\15\uffff\1\15\1\uffff\1\14\5\uffff\1"+
            "\42\4\uffff\1\46\1\40\1\37\1\30\1\31\1\26\1\27\1\25\1\uffff"+
            "\1\12\1\13\1\16\1\uffff\1\6",
            "\1\44\1\45\1\34\1\35\1\7\1\24\1\32\1\4\1\uffff\1\33\1\36\1"+
            "\5\1\2\1\3\7\uffff\1\41\15\uffff\1\15\1\uffff\1\14\5\uffff\1"+
            "\42\4\uffff\1\46\1\40\1\37\1\30\1\31\1\26\1\27\1\25\1\uffff"+
            "\1\12\1\13\1\16\1\uffff\1\6",
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
            return "1945:1: ( ( ( ( ruleExp ) )=> (lv_exp_0_0= ruleExp ) ) | ( ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= RULE_S ) ) ) otherlv_2= '<-' ( (lv_exp_3_0= ruleExp ) ) ) )";
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
                        if ( (LA42_0==60) && (synpred5_InternalGDSL())) {s = 1;}

                        else if ( (LA42_0==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA42_0==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA42_0==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA42_0==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA42_0==65) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA42_0==RULE_STRING) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA42_0==RULE_ID) ) {s = 8;}

                        else if ( (LA42_0==RULE_S) ) {s = 9;}

                        else if ( (LA42_0==61) && (synpred5_InternalGDSL())) {s = 10;}

                        else if ( (LA42_0==62) && (synpred5_InternalGDSL())) {s = 11;}

                        else if ( (LA42_0==41) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA42_0==39) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA42_0==63) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA42_0==48) && (synpred5_InternalGDSL())) {s = 15;}

                        else if ( (LA42_0==51) && (synpred5_InternalGDSL())) {s = 16;}

                        else if ( (LA42_0==46) && (synpred5_InternalGDSL())) {s = 17;}

                        else if ( (LA42_0==RULE_MIXID) && (synpred5_InternalGDSL())) {s = 18;}

                        else if ( (LA42_0==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 19;}

                         
                        input.seek(index42_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_8 = input.LA(1);

                         
                        int index42_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA42_8==RULE_DOT) && (synpred5_InternalGDSL())) {s = 20;}

                        else if ( (LA42_8==59) && (synpred5_InternalGDSL())) {s = 21;}

                        else if ( (LA42_8==57) && (synpred5_InternalGDSL())) {s = 22;}

                        else if ( (LA42_8==58) && (synpred5_InternalGDSL())) {s = 23;}

                        else if ( (LA42_8==55) && (synpred5_InternalGDSL())) {s = 24;}

                        else if ( (LA42_8==56) && (synpred5_InternalGDSL())) {s = 25;}

                        else if ( (LA42_8==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 26;}

                        else if ( (LA42_8==RULE_BS) && (synpred5_InternalGDSL())) {s = 27;}

                        else if ( (LA42_8==RULE_LESS) && (synpred5_InternalGDSL())) {s = 28;}

                        else if ( (LA42_8==RULE_GREATER) && (synpred5_InternalGDSL())) {s = 29;}

                        else if ( (LA42_8==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred5_InternalGDSL())) {s = 30;}

                        else if ( (LA42_8==54) && (synpred5_InternalGDSL())) {s = 31;}

                        else if ( (LA42_8==53) && (synpred5_InternalGDSL())) {s = 32;}

                        else if ( (LA42_8==25) && (synpred5_InternalGDSL())) {s = 33;}

                        else if ( (LA42_8==47) && (synpred5_InternalGDSL())) {s = 34;}

                        else if ( (LA42_8==EOF) && (synpred5_InternalGDSL())) {s = 35;}

                        else if ( (LA42_8==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA42_8==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA42_8==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA42_8==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA42_8==65) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA42_8==RULE_STRING) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA42_8==RULE_ID) && (synpred5_InternalGDSL())) {s = 36;}

                        else if ( (LA42_8==RULE_S) && (synpred5_InternalGDSL())) {s = 37;}

                        else if ( (LA42_8==61) && (synpred5_InternalGDSL())) {s = 10;}

                        else if ( (LA42_8==62) && (synpred5_InternalGDSL())) {s = 11;}

                        else if ( (LA42_8==41) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA42_8==39) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA42_8==63) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA42_8==52) ) {s = 38;}

                         
                        input.seek(index42_8);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_9 = input.LA(1);

                         
                        int index42_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA42_9==RULE_DOT) && (synpred5_InternalGDSL())) {s = 20;}

                        else if ( (LA42_9==59) && (synpred5_InternalGDSL())) {s = 21;}

                        else if ( (LA42_9==57) && (synpred5_InternalGDSL())) {s = 22;}

                        else if ( (LA42_9==58) && (synpred5_InternalGDSL())) {s = 23;}

                        else if ( (LA42_9==55) && (synpred5_InternalGDSL())) {s = 24;}

                        else if ( (LA42_9==56) && (synpred5_InternalGDSL())) {s = 25;}

                        else if ( (LA42_9==RULE_USCORE) && (synpred5_InternalGDSL())) {s = 26;}

                        else if ( (LA42_9==RULE_BS) && (synpred5_InternalGDSL())) {s = 27;}

                        else if ( (LA42_9==RULE_LESS) && (synpred5_InternalGDSL())) {s = 28;}

                        else if ( (LA42_9==RULE_GREATER) && (synpred5_InternalGDSL())) {s = 29;}

                        else if ( (LA42_9==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred5_InternalGDSL())) {s = 30;}

                        else if ( (LA42_9==54) && (synpred5_InternalGDSL())) {s = 31;}

                        else if ( (LA42_9==53) && (synpred5_InternalGDSL())) {s = 32;}

                        else if ( (LA42_9==25) && (synpred5_InternalGDSL())) {s = 33;}

                        else if ( (LA42_9==47) && (synpred5_InternalGDSL())) {s = 34;}

                        else if ( (LA42_9==EOF) && (synpred5_InternalGDSL())) {s = 35;}

                        else if ( (LA42_9==RULE_POSINT_WO_DUALS) && (synpred5_InternalGDSL())) {s = 2;}

                        else if ( (LA42_9==RULE_DUALS) && (synpred5_InternalGDSL())) {s = 3;}

                        else if ( (LA42_9==RULE_HEXINT) && (synpred5_InternalGDSL())) {s = 4;}

                        else if ( (LA42_9==RULE_NEGINT) && (synpred5_InternalGDSL())) {s = 5;}

                        else if ( (LA42_9==65) && (synpred5_InternalGDSL())) {s = 6;}

                        else if ( (LA42_9==RULE_STRING) && (synpred5_InternalGDSL())) {s = 7;}

                        else if ( (LA42_9==RULE_ID) && (synpred5_InternalGDSL())) {s = 36;}

                        else if ( (LA42_9==RULE_S) && (synpred5_InternalGDSL())) {s = 37;}

                        else if ( (LA42_9==61) && (synpred5_InternalGDSL())) {s = 10;}

                        else if ( (LA42_9==62) && (synpred5_InternalGDSL())) {s = 11;}

                        else if ( (LA42_9==41) && (synpred5_InternalGDSL())) {s = 12;}

                        else if ( (LA42_9==39) && (synpred5_InternalGDSL())) {s = 13;}

                        else if ( (LA42_9==63) && (synpred5_InternalGDSL())) {s = 14;}

                        else if ( (LA42_9==52) ) {s = 38;}

                         
                        input.seek(index42_9);
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
    static final String DFA45_eotS =
        "\31\uffff";
    static final String DFA45_eofS =
        "\1\1\30\uffff";
    static final String DFA45_minS =
        "\1\6\17\uffff\1\0\10\uffff";
    static final String DFA45_maxS =
        "\1\100\17\uffff\1\0\10\uffff";
    static final String DFA45_acceptS =
        "\1\uffff\1\2\22\uffff\5\1";
    static final String DFA45_specialS =
        "\1\0\17\uffff\1\1\10\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\26\1\27\1\uffff\1\25\1\20\1\uffff\1\1\1\24\1\30\12\uffff"+
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

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "()* loopback of 2194:1: ( ( ( ( ruleSYM ) )=> (lv_sym_1_0= ruleSYM ) ) ( (lv_aexps_2_0= ruleAExp ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_0 = input.LA(1);

                         
                        int index45_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA45_0==EOF||LA45_0==RULE_MIXID||(LA45_0>=25 && LA45_0<=26)||(LA45_0>=28 && LA45_0<=31)||(LA45_0>=34 && LA45_0<=35)||LA45_0==40||LA45_0==42||LA45_0==47||(LA45_0>=49 && LA45_0<=50)||(LA45_0>=53 && LA45_0<=54)||LA45_0==64) ) {s = 1;}

                        else if ( (LA45_0==RULE_USCORE) ) {s = 16;}

                        else if ( (LA45_0==RULE_BS) && (synpred6_InternalGDSL())) {s = 20;}

                        else if ( (LA45_0==RULE_DOT) && (synpred6_InternalGDSL())) {s = 21;}

                        else if ( (LA45_0==RULE_LESS) && (synpred6_InternalGDSL())) {s = 22;}

                        else if ( (LA45_0==RULE_GREATER) && (synpred6_InternalGDSL())) {s = 23;}

                        else if ( (LA45_0==RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER) && (synpred6_InternalGDSL())) {s = 24;}

                         
                        input.seek(index45_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_16 = input.LA(1);

                         
                        int index45_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalGDSL()) ) {s = 24;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index45_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA51_eotS =
        "\17\uffff";
    static final String DFA51_eofS =
        "\1\1\16\uffff";
    static final String DFA51_minS =
        "\1\4\16\uffff";
    static final String DFA51_maxS =
        "\1\101\16\uffff";
    static final String DFA51_acceptS =
        "\1\uffff\1\2\15\1";
    static final String DFA51_specialS =
        "\1\0\16\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\10\1\11\2\1\1\7\2\1\1\4\3\1\1\5\1\2\1\3\7\uffff\2\1\1\uffff"+
            "\4\1\2\uffff\2\1\3\uffff\1\15\1\1\1\14\1\1\4\uffff\1\1\1\uffff"+
            "\2\1\2\uffff\7\1\1\uffff\1\12\1\13\1\16\1\1\1\6",
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

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2477:6: ( ( ( ( ruleAtomicExp ) ) )=> ( (lv_atomicExp_2_0= ruleAtomicExp ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_0 = input.LA(1);

                         
                        int index51_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_0==EOF||(LA51_0>=RULE_LESS && LA51_0<=RULE_GREATER)||(LA51_0>=RULE_DOT && LA51_0<=RULE_USCORE)||(LA51_0>=RULE_MIXID && LA51_0<=RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER)||(LA51_0>=25 && LA51_0<=26)||(LA51_0>=28 && LA51_0<=31)||(LA51_0>=34 && LA51_0<=35)||LA51_0==40||LA51_0==42||LA51_0==47||(LA51_0>=49 && LA51_0<=50)||(LA51_0>=53 && LA51_0<=59)||LA51_0==64) ) {s = 1;}

                        else if ( (LA51_0==RULE_POSINT_WO_DUALS) && (synpred7_InternalGDSL())) {s = 2;}

                        else if ( (LA51_0==RULE_DUALS) && (synpred7_InternalGDSL())) {s = 3;}

                        else if ( (LA51_0==RULE_HEXINT) && (synpred7_InternalGDSL())) {s = 4;}

                        else if ( (LA51_0==RULE_NEGINT) && (synpred7_InternalGDSL())) {s = 5;}

                        else if ( (LA51_0==65) && (synpred7_InternalGDSL())) {s = 6;}

                        else if ( (LA51_0==RULE_STRING) && (synpred7_InternalGDSL())) {s = 7;}

                        else if ( (LA51_0==RULE_ID) && (synpred7_InternalGDSL())) {s = 8;}

                        else if ( (LA51_0==RULE_S) && (synpred7_InternalGDSL())) {s = 9;}

                        else if ( (LA51_0==61) && (synpred7_InternalGDSL())) {s = 10;}

                        else if ( (LA51_0==62) && (synpred7_InternalGDSL())) {s = 11;}

                        else if ( (LA51_0==41) && (synpred7_InternalGDSL())) {s = 12;}

                        else if ( (LA51_0==39) && (synpred7_InternalGDSL())) {s = 13;}

                        else if ( (LA51_0==63) && (synpred7_InternalGDSL())) {s = 14;}

                         
                        input.seek(index51_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
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
    public static final BitSet FOLLOW_27_in_ruleDeclExport453 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclExport474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclType_in_entryRuleDeclType510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclType520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDeclType557 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclType576 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclType596 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclType618 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType672 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleDeclType685 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType706 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleTy_in_ruleDeclType737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyVars_in_ruleDeclType767 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclType779 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType801 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleDeclType814 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleConDecl_in_ruleDeclType835 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleDeclVal_in_entryRuleDeclVal876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclVal886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDeclVal923 = new BitSet(new long[]{0x00000000200076F0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1042 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1062 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleDeclVal1107 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1127 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1147 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1168 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_ruleDeclVal1220 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1239 = new BitSet(new long[]{0x0000000020001400L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1259 = new BitSet(new long[]{0x0000000020001400L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1281 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclVal1329 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleDeclVal1349 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleDeclVal1369 = new BitSet(new long[]{0x0000000200000830L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECODEPAT_in_ruleDeclVal1390 = new BitSet(new long[]{0x0000000200000830L,0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleDeclVal1403 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1417 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDeclVal1458 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1479 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleDeclVal1491 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleDeclVal1512 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleTyVars_in_entryRuleTyVars1553 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyVars1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleTyVars1600 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyVar_in_ruleTyVars1621 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleTyVars1634 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyVar_in_ruleTyVars1655 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleTyVars1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyVar_in_entryRuleTyVar1705 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyVar1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyVar1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTyVar1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_entryRuleConDecl1821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConDecl1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_ruleConDecl1877 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleConDecl1890 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleConDecl1911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTy_in_entryRuleTy1949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTy1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleTy2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTy2033 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_36_in_ruleTy2059 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_37_in_ruleTy2088 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_38_in_ruleTy2117 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleTy2147 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2168 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleTy2181 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyBind_in_ruleTy2202 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleTy2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleTy2247 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2269 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_34_in_ruleTy2282 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTyElement_in_ruleTy2303 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_40_in_ruleTy2319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleTy2339 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2360 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_34_in_ruleTy2373 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2394 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_42_in_ruleTy2408 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleTy2420 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleTy2470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTy2489 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2509 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_LESS_in_ruleTy2520 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2540 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleTy2552 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTy2573 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_GREATER_in_ruleTy2584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyBind_in_entryRuleTyBind2620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyBind2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyBind2674 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTyBind2694 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleTyBind2715 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyBind2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTyElement_in_entryRuleTyElement2774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTyElement2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTyElement2828 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTyElement2848 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleTyElement2868 = new BitSet(new long[]{0x000012F000038830L});
    public static final BitSet FOLLOW_ruleTy_in_ruleTyElement2889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_entryRuleExp2925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExp2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_ruleExp3009 = new BitSet(new long[]{0xF009428000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleExp3030 = new BitSet(new long[]{0x0000000000001402L});
    public static final BitSet FOLLOW_ruleCaseExp_in_entryRuleCaseExp3068 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseExp3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleCaseExp3149 = new BitSet(new long[]{0xF009028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_ruleCaseExp3183 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleCaseExp3195 = new BitSet(new long[]{0x0000000000038C30L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_ruleCaseExp3217 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleCaseExp3229 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCaseExp3250 = new BitSet(new long[]{0x0000800040000000L});
    public static final BitSet FOLLOW_30_in_ruleCaseExp3263 = new BitSet(new long[]{0x0000000000038C30L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_ruleCaseExp3284 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleCaseExp3296 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleCaseExp3317 = new BitSet(new long[]{0x0000800040000000L});
    public static final BitSet FOLLOW_47_in_ruleCaseExp3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedExp_in_entryRuleClosedExp3369 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedExp3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_ruleClosedExp3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleClosedExp3450 = new BitSet(new long[]{0xF009428000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3484 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleClosedExp3496 = new BitSet(new long[]{0xF009428000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3517 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleClosedExp3529 = new BitSet(new long[]{0xF009428000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseExp_in_ruleClosedExp3550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleClosedExp3576 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3610 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_25_in_ruleClosedExp3623 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_ruleClosedExp3644 = new BitSet(new long[]{0x0000800002000000L});
    public static final BitSet FOLLOW_47_in_ruleClosedExp3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMonadicExp_in_entryRuleMonadicExp3695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMonadicExp3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMonadicExp3787 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleMonadicExp3807 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleMonadicExp3827 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleMonadicExp3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrElseExp_in_entryRuleOrElseExp3885 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrElseExp3895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp3942 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOrElseExp3969 = new BitSet(new long[]{0xF000028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_ruleOrElseExp4003 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_ruleAndAlsoExp_in_entryRuleAndAlsoExp4041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndAlsoExp4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp4098 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_ruleAndAlsoExp4125 = new BitSet(new long[]{0xF000028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_ruleAndAlsoExp4159 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_ruleRExp_in_entryRuleRExp4197 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRExp4207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp4254 = new BitSet(new long[]{0x00000000000066F2L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleRExp4285 = new BitSet(new long[]{0xF000028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExp_in_ruleRExp4306 = new BitSet(new long[]{0x00000000000066F2L});
    public static final BitSet FOLLOW_ruleAExp_in_entryRuleAExp4344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExp4354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4401 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_55_in_ruleAExp4421 = new BitSet(new long[]{0xF000028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleAExp4450 = new BitSet(new long[]{0xF000028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_ruleAExp4487 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_ruleMExp_in_entryRuleMExp4525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMExp4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectExp_in_ruleMExp4582 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_57_in_ruleMExp4602 = new BitSet(new long[]{0xF000028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleMExp4631 = new BitSet(new long[]{0xF000028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleMExp4668 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleSelectExp_in_entryRuleSelectExp4706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectExp4716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleSelectExp4763 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleSelectExp4775 = new BitSet(new long[]{0xF000028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_ruleSelectExp4796 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleApplyExp_in_entryRuleApplyExp4834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleApplyExp4844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleApplyExp4882 = new BitSet(new long[]{0xF000028000038930L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleApplyExp4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_ruleApplyExp4944 = new BitSet(new long[]{0xF000028000038932L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_entryRuleAtomicExp4982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicExp4992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLIT_in_ruleAtomicExp5038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAtomicExp5061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5092 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5112 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp5138 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5157 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5177 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_61_in_ruleAtomicExp5213 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleAtomicExp5238 = new BitSet(new long[]{0x1000000000000030L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp5259 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExp5272 = new BitSet(new long[]{0x1000000000000030L});
    public static final BitSet FOLLOW_ruleField_in_ruleAtomicExp5293 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_40_in_ruleAtomicExp5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleAtomicExp5327 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleAtomicExp5394 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5415 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleAtomicExp5427 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleAtomicExp5445 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5464 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5484 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_39_in_ruleAtomicExp5523 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5543 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5563 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAtomicExp5583 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5604 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_34_in_ruleAtomicExp5617 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomicExp5636 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleAtomicExp5656 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAtomicExp5676 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5697 = new BitSet(new long[]{0x0000010400000000L});
    public static final BitSet FOLLOW_40_in_ruleAtomicExp5713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAtomicExp5739 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleValueDecl_in_ruleAtomicExp5773 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleAtomicExp5786 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleAtomicExp5807 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleAtomicExp5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleField_in_entryRuleField5856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleField5866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleField5911 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_RULE_S_in_ruleField5931 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleField5951 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleField5972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleField5992 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleField6011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleField6031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueDecl_in_entryRuleValueDecl6076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueDecl6086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleValueDecl6123 = new BitSet(new long[]{0x00000000000066F0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueDecl6169 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleValueDecl6189 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_ruleSYM_in_ruleValueDecl6224 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueDecl6244 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_RULE_S_in_ruleValueDecl6264 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_29_in_ruleValueDecl6285 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_ruleValueDecl6306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_entryRulePAT6342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePAT6352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_rulePAT6394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_rulePAT6439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePAT6507 = new BitSet(new long[]{0x0000000000038C32L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_rulePAT6527 = new BitSet(new long[]{0x0000000000038C32L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_rulePAT6556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rulePAT6578 = new BitSet(new long[]{0x0000000000062230L});
    public static final BitSet FOLLOW_ruleBITPAT_in_rulePAT6599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_rulePAT6611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCONS_in_entryRuleCONS6648 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONS6658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCONS6701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleCONS6721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDECODEPAT_in_entryRuleDECODEPAT6765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDECODEPAT6776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleDECODEPAT6815 = new BitSet(new long[]{0x0000000000062230L});
    public static final BitSet FOLLOW_ruleBITPAT_in_ruleDECODEPAT6838 = new BitSet(new long[]{0x0000000000062230L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleDECODEPAT6858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTOKPAT_in_ruleDECODEPAT6887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTOKPAT_in_entryRuleTOKPAT6933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTOKPAT6944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXINT_in_ruleTOKPAT6984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTOKPAT7011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleTOKPAT7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITPAT_in_entryRuleBITPAT7084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITPAT7095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITPAT7142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBITPAT7170 = new BitSet(new long[]{0x2000000008000002L});
    public static final BitSet FOLLOW_RULE_S_in_ruleBITPAT7196 = new BitSet(new long[]{0x2000000008000002L});
    public static final BitSet FOLLOW_ruleBITPATORINT_in_ruleBITPAT7225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBITPATORINT_in_entryRuleBITPATORINT7274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBITPATORINT7285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleBITPATORINT7324 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleBITPATORINT7346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleBITPATORINT7372 = new BitSet(new long[]{0x0000000000062200L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleBITPATORINT7394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLIT_in_entryRuleLIT7441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLIT7452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_ruleLIT7499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLIT7524 = new BitSet(new long[]{0x0000000000062200L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_ruleLIT7547 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleLIT7567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMID_in_entryRuleMID7609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMID7620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIXID_in_ruleMID7660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_ruleMID7686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_entryRuleSYM7732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSYM7743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USCORE_in_ruleSYM7783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleSYM7809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSYM7835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LESS_in_ruleSYM7861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_GREATER_in_ruleSYM7887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER_in_ruleSYM7913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_entryRuleINTEGER7959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTEGER7970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_ruleINTEGER8017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXINT_in_ruleINTEGER8043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEGINT_in_ruleINTEGER8069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePOSINT_in_entryRulePOSINT8115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePOSINT8126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_POSINT_WO_DUALS_in_rulePOSINT8166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DUALS_in_rulePOSINT8192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBINARY_in_entryRuleBINARY8238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBINARY8249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DUALS_in_ruleBINARY8289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BINS_in_ruleBINARY8315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BS_in_ruleBINARY8341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleBINARY8367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConDecl_in_synpred1_InternalGDSL635 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_synpred1_InternalGDSL642 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleConDecl_in_synpred1_InternalGDSL649 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred2_InternalGDSL973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred3_InternalGDSL941 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred3_InternalGDSL982 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_set_in_synpred3_InternalGDSL992 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_29_in_synpred3_InternalGDSL1015 = new BitSet(new long[]{0xF009428000039D30L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_synpred3_InternalGDSL1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred4_InternalGDSL1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExp_in_synpred5_InternalGDSL3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSYM_in_synpred6_InternalGDSL4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicExp_in_synpred7_InternalGDSL4925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred8_InternalGDSL5133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOT_in_synpred9_InternalGDSL5440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred10_InternalGDSL6138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_in_synpred11_InternalGDSL6420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred12_InternalGDSL6462 = new BitSet(new long[]{0x0000000000038C32L,0x0000000000000002L});
    public static final BitSet FOLLOW_rulePAT_in_synpred12_InternalGDSL6487 = new BitSet(new long[]{0x0000000000000002L});

}