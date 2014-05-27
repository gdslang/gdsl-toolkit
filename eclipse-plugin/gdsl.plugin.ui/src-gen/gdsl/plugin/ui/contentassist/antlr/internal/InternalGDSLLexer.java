package gdsl.plugin.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGDSLLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int RULE_POSINT=6;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int RULE_CONS=4;
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

    public InternalGDSLLexer() {;} 
    public InternalGDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalGDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:11:7: ( ';' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:11:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:12:7: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:12:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:13:7: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:13:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:14:7: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:14:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:15:7: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:15:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:16:7: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:16:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:17:7: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:17:9: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:18:7: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:18:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:19:7: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:19:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:20:7: ( '|' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:20:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:21:7: ( 'of' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:21:9: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:22:7: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:22:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:23:7: ( 'granularity' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:23:9: 'granularity'
            {
            match("granularity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:24:7: ( 'export' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:24:9: 'export'
            {
            match("export"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "RULE_CONS"
    public final void mRULE_CONS() throws RecognitionException {
        try {
            int _type = RULE_CONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3220:11: ( 'constodo' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3220:13: 'constodo'
            {
            match("constodo"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CONS"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3222:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3222:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3222:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3222:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3222:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_POSINT"
    public final void mRULE_POSINT() throws RecognitionException {
        try {
            int _type = RULE_POSINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3224:13: ( ( '0' .. '9' )+ )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3224:15: ( '0' .. '9' )+
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3224:15: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3224:16: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_POSINT"

    // $ANTLR start "RULE_NEGINT"
    public final void mRULE_NEGINT() throws RecognitionException {
        try {
            int _type = RULE_NEGINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3226:13: ( '~' '1' .. '9' ( '0' .. '9' )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3226:15: '~' '1' .. '9' ( '0' .. '9' )*
            {
            match('~'); 
            matchRange('1','9'); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3226:28: ( '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3226:29: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEGINT"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3228:17: ( '(*' ( options {greedy=false; } : . )* '*)' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3228:19: '(*' ( options {greedy=false; } : . )* '*)'
            {
            match("(*"); 

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3228:24: ( options {greedy=false; } : . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='*') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==')') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='(')||(LA5_1>='*' && LA5_1<='\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<=')')||(LA5_0>='+' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3228:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match("*)"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3230:17: ( '#' (~ ( '\\n' ) )* '\\n' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3230:19: '#' (~ ( '\\n' ) )* '\\n'
            {
            match('#'); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3230:23: (~ ( '\\n' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3230:23: ~ ( '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3232:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3232:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:3232:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    public void mTokens() throws RecognitionException {
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | RULE_CONS | RULE_ID | RULE_POSINT | RULE_NEGINT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS )
        int alt8=21;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:70: T__21
                {
                mT__21(); 

                }
                break;
            case 12 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:76: T__22
                {
                mT__22(); 

                }
                break;
            case 13 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:82: T__23
                {
                mT__23(); 

                }
                break;
            case 14 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:88: T__24
                {
                mT__24(); 

                }
                break;
            case 15 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:94: RULE_CONS
                {
                mRULE_CONS(); 

                }
                break;
            case 16 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:104: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 17 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:112: RULE_POSINT
                {
                mRULE_POSINT(); 

                }
                break;
            case 18 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:124: RULE_NEGINT
                {
                mRULE_NEGINT(); 

                }
                break;
            case 19 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:136: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 20 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:152: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 21 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:168: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\3\uffff\1\20\3\uffff\1\20\3\uffff\1\20\1\uffff\3\20\6\uffff\2\20"+
        "\1\36\4\20\1\43\1\uffff\3\20\1\47\1\uffff\3\20\1\uffff\4\20\1\57"+
        "\2\20\1\uffff\2\20\1\64\1\20\1\uffff\1\20\1\67\1\uffff";
    static final String DFA8_eofS =
        "\70\uffff";
    static final String DFA8_minS =
        "\1\11\2\uffff\1\171\3\uffff\1\141\3\uffff\1\146\1\uffff\1\162\1"+
        "\170\1\157\6\uffff\1\160\1\154\1\60\1\141\1\160\1\156\1\145\1\60"+
        "\1\uffff\1\156\1\157\1\163\1\60\1\uffff\1\165\1\162\1\164\1\uffff"+
        "\1\154\1\164\1\157\1\141\1\60\1\144\1\162\1\uffff\1\157\1\151\1"+
        "\60\1\164\1\uffff\1\171\1\60\1\uffff";
    static final String DFA8_maxS =
        "\1\176\2\uffff\1\171\3\uffff\1\141\3\uffff\1\146\1\uffff\1\162\1"+
        "\170\1\157\6\uffff\1\160\1\154\1\172\1\141\1\160\1\156\1\145\1\172"+
        "\1\uffff\1\156\1\157\1\163\1\172\1\uffff\1\165\1\162\1\164\1\uffff"+
        "\1\154\1\164\1\157\1\141\1\172\1\144\1\162\1\uffff\1\157\1\151\1"+
        "\172\1\164\1\uffff\1\171\1\172\1\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\6\1\uffff\1\10\1\11\1\12\1\uffff"+
        "\1\14\3\uffff\1\20\1\21\1\22\1\23\1\24\1\25\10\uffff\1\13\4\uffff"+
        "\1\7\3\uffff\1\3\7\uffff\1\16\4\uffff\1\17\2\uffff\1\15";
    static final String DFA8_specialS =
        "\70\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\25\2\uffff\1\25\22\uffff\1\25\2\uffff\1\24\4\uffff\1\23\3"+
            "\uffff\1\6\3\uffff\12\21\1\14\1\1\1\uffff\1\2\3\uffff\32\20"+
            "\1\4\1\uffff\1\5\2\20\1\uffff\2\20\1\17\1\20\1\16\1\20\1\15"+
            "\7\20\1\13\4\20\1\3\1\20\1\7\4\20\1\10\1\12\1\11\1\22",
            "",
            "",
            "\1\26",
            "",
            "",
            "",
            "\1\27",
            "",
            "",
            "",
            "\1\30",
            "",
            "\1\31",
            "\1\32",
            "\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34",
            "\1\35",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\44",
            "\1\45",
            "\1\46",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "",
            "\1\50",
            "\1\51",
            "\1\52",
            "",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\60",
            "\1\61",
            "",
            "\1\62",
            "\1\63",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
            "\1\65",
            "",
            "\1\66",
            "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
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
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | RULE_CONS | RULE_ID | RULE_POSINT | RULE_NEGINT | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS );";
        }
    }
 

}