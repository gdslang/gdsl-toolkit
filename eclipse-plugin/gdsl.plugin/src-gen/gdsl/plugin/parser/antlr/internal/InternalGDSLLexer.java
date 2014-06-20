package gdsl.plugin.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGDSLLexer extends Lexer {
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

    public InternalGDSLLexer() {;} 
    public InternalGDSLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalGDSLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g"; }

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:11:7: ( ';' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:11:9: ';'
            {
            match(';'); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:12:7: ( 'granularity' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:12:9: 'granularity'
            {
            match("granularity"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:13:7: ( '=' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:13:9: '='
            {
            match('='); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:14:7: ( 'export' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:14:9: 'export'
            {
            match("export"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:15:7: ( 'type' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:15:9: 'type'
            {
            match("type"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:16:7: ( '[' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:16:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:17:7: ( ',' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:17:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:18:7: ( ']' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:18:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:19:7: ( 'val' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:19:9: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:20:7: ( '{' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:20:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:21:7: ( '}' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:21:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:22:7: ( 'of' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:22:9: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:23:7: ( ':' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:23:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:24:7: ( '\\'' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:24:9: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:25:7: ( 'case' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:25:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:26:7: ( 'end' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:26:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:27:7: ( 'if' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:27:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:28:7: ( 'then' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:28:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:29:7: ( 'else' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:29:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:30:7: ( 'do' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:30:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:31:7: ( '<-' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:31:9: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:32:7: ( 'or' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:32:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:33:7: ( 'and' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:33:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:34:7: ( 'todo' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:34:9: 'todo'
            {
            match("todo"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:35:7: ( '_' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:35:9: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:36:7: ( '@' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:36:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:37:7: ( '~' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:37:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:38:7: ( '0x' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:38:9: '0x'
            {
            match("0x"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "RULE_BINDIG"
    public final void mRULE_BINDIG() throws RecognitionException {
        try {
            int _type = RULE_BINDIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3110:13: ( ( '0' | '1' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3110:15: ( '0' | '1' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINDIG"

    // $ANTLR start "RULE_NBINDIG"
    public final void mRULE_NBINDIG() throws RecognitionException {
        try {
            int _type = RULE_NBINDIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3112:14: ( '2' .. '9' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3112:16: '2' .. '9'
            {
            matchRange('2','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NBINDIG"

    // $ANTLR start "RULE_LHEXCHAR"
    public final void mRULE_LHEXCHAR() throws RecognitionException {
        try {
            int _type = RULE_LHEXCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3114:15: ( 'a' .. 'f' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3114:17: 'a' .. 'f'
            {
            matchRange('a','f'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LHEXCHAR"

    // $ANTLR start "RULE_UHEXCHAR"
    public final void mRULE_UHEXCHAR() throws RecognitionException {
        try {
            int _type = RULE_UHEXCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3116:15: ( 'A' .. 'F' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3116:17: 'A' .. 'F'
            {
            matchRange('A','F'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UHEXCHAR"

    // $ANTLR start "RULE_LNHEXCHAR"
    public final void mRULE_LNHEXCHAR() throws RecognitionException {
        try {
            int _type = RULE_LNHEXCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3118:16: ( 'g' .. 'z' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3118:18: 'g' .. 'z'
            {
            matchRange('g','z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LNHEXCHAR"

    // $ANTLR start "RULE_UNHEXCHAR"
    public final void mRULE_UNHEXCHAR() throws RecognitionException {
        try {
            int _type = RULE_UNHEXCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3120:16: ( 'G' .. 'Z' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3120:18: 'G' .. 'Z'
            {
            matchRange('G','Z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNHEXCHAR"

    // $ANTLR start "RULE_BS"
    public final void mRULE_BS() throws RecognitionException {
        try {
            int _type = RULE_BS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3122:9: ( '\\\\' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3122:11: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BS"

    // $ANTLR start "RULE_SLASH"
    public final void mRULE_SLASH() throws RecognitionException {
        try {
            int _type = RULE_SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3124:12: ( '/' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3124:14: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SLASH"

    // $ANTLR start "RULE_DOT"
    public final void mRULE_DOT() throws RecognitionException {
        try {
            int _type = RULE_DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3126:10: ( '.' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3126:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOT"

    // $ANTLR start "RULE_PIPE"
    public final void mRULE_PIPE() throws RecognitionException {
        try {
            int _type = RULE_PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3128:11: ( '|' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3128:13: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PIPE"

    // $ANTLR start "RULE_CHARSYM"
    public final void mRULE_CHARSYM() throws RecognitionException {
        try {
            int _type = RULE_CHARSYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3130:14: ( ( '_' | '-' | '?' | '\\'' | '!' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3130:16: ( '_' | '-' | '?' | '\\'' | '!' )
            {
            if ( input.LA(1)=='!'||input.LA(1)=='\''||input.LA(1)=='-'||input.LA(1)=='?'||input.LA(1)=='_' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARSYM"

    // $ANTLR start "RULE_OTHERSYM"
    public final void mRULE_OTHERSYM() throws RecognitionException {
        try {
            int _type = RULE_OTHERSYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3132:15: ( ( '%' | '&' | '$' | '+' | ':' | '<' | '=' | '>' | '@' | '~' | '`' | '^' | '#' | '*' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3132:17: ( '%' | '&' | '$' | '+' | ':' | '<' | '=' | '>' | '@' | '~' | '`' | '^' | '#' | '*' )
            {
            if ( (input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)==':'||(input.LA(1)>='<' && input.LA(1)<='>')||input.LA(1)=='@'||input.LA(1)=='^'||input.LA(1)=='`'||input.LA(1)=='~' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OTHERSYM"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3134:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3134:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3134:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3136:17: ( '(*' ( options {greedy=false; } : . )* '*)' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3136:19: '(*' ( options {greedy=false; } : . )* '*)'
            {
            match("(*"); 

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3136:24: ( options {greedy=false; } : . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==')') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='(')||(LA2_1>='*' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3136:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3138:17: ( '#' (~ ( '\\n' ) )* '\\n' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3138:19: '#' (~ ( '\\n' ) )* '\\n'
            {
            match('#'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3138:23: (~ ( '\\n' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3138:23: ~ ( '\\n' )
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
            	    break loop3;
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

    public void mTokens() throws RecognitionException {
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | RULE_BINDIG | RULE_NBINDIG | RULE_LHEXCHAR | RULE_UHEXCHAR | RULE_LNHEXCHAR | RULE_UNHEXCHAR | RULE_BS | RULE_SLASH | RULE_DOT | RULE_PIPE | RULE_CHARSYM | RULE_OTHERSYM | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT )
        int alt4=43;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:10: T__19
                {
                mT__19(); 

                }
                break;
            case 2 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:16: T__20
                {
                mT__20(); 

                }
                break;
            case 3 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:22: T__21
                {
                mT__21(); 

                }
                break;
            case 4 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:28: T__22
                {
                mT__22(); 

                }
                break;
            case 5 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:34: T__23
                {
                mT__23(); 

                }
                break;
            case 6 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:40: T__24
                {
                mT__24(); 

                }
                break;
            case 7 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:46: T__25
                {
                mT__25(); 

                }
                break;
            case 8 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:52: T__26
                {
                mT__26(); 

                }
                break;
            case 9 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:58: T__27
                {
                mT__27(); 

                }
                break;
            case 10 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:64: T__28
                {
                mT__28(); 

                }
                break;
            case 11 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:70: T__29
                {
                mT__29(); 

                }
                break;
            case 12 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:76: T__30
                {
                mT__30(); 

                }
                break;
            case 13 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:82: T__31
                {
                mT__31(); 

                }
                break;
            case 14 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:88: T__32
                {
                mT__32(); 

                }
                break;
            case 15 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:94: T__33
                {
                mT__33(); 

                }
                break;
            case 16 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:100: T__34
                {
                mT__34(); 

                }
                break;
            case 17 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:106: T__35
                {
                mT__35(); 

                }
                break;
            case 18 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:112: T__36
                {
                mT__36(); 

                }
                break;
            case 19 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:118: T__37
                {
                mT__37(); 

                }
                break;
            case 20 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:124: T__38
                {
                mT__38(); 

                }
                break;
            case 21 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:130: T__39
                {
                mT__39(); 

                }
                break;
            case 22 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:136: T__40
                {
                mT__40(); 

                }
                break;
            case 23 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:142: T__41
                {
                mT__41(); 

                }
                break;
            case 24 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:148: T__42
                {
                mT__42(); 

                }
                break;
            case 25 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:154: T__43
                {
                mT__43(); 

                }
                break;
            case 26 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:160: T__44
                {
                mT__44(); 

                }
                break;
            case 27 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:166: T__45
                {
                mT__45(); 

                }
                break;
            case 28 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:172: T__46
                {
                mT__46(); 

                }
                break;
            case 29 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:178: RULE_BINDIG
                {
                mRULE_BINDIG(); 

                }
                break;
            case 30 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:190: RULE_NBINDIG
                {
                mRULE_NBINDIG(); 

                }
                break;
            case 31 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:203: RULE_LHEXCHAR
                {
                mRULE_LHEXCHAR(); 

                }
                break;
            case 32 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:217: RULE_UHEXCHAR
                {
                mRULE_UHEXCHAR(); 

                }
                break;
            case 33 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:231: RULE_LNHEXCHAR
                {
                mRULE_LNHEXCHAR(); 

                }
                break;
            case 34 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:246: RULE_UNHEXCHAR
                {
                mRULE_UNHEXCHAR(); 

                }
                break;
            case 35 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:261: RULE_BS
                {
                mRULE_BS(); 

                }
                break;
            case 36 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:269: RULE_SLASH
                {
                mRULE_SLASH(); 

                }
                break;
            case 37 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:280: RULE_DOT
                {
                mRULE_DOT(); 

                }
                break;
            case 38 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:289: RULE_PIPE
                {
                mRULE_PIPE(); 

                }
                break;
            case 39 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:299: RULE_CHARSYM
                {
                mRULE_CHARSYM(); 

                }
                break;
            case 40 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:312: RULE_OTHERSYM
                {
                mRULE_OTHERSYM(); 

                }
                break;
            case 41 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:326: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 42 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:334: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 43 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:350: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\2\uffff\1\34\1\uffff\1\32\1\34\3\uffff\1\34\2\uffff\1\34\2\uffff"+
        "\1\32\1\34\1\32\1\46\1\32\3\uffff\1\30\13\uffff\1\46\32\uffff";
    static final String DFA4_eofS =
        "\76\uffff";
    static final String DFA4_minS =
        "\1\11\1\uffff\1\162\1\uffff\1\154\1\150\3\uffff\1\141\2\uffff\1"+
        "\146\2\uffff\1\141\1\146\1\157\1\55\1\156\3\uffff\1\170\13\uffff"+
        "\1\0\32\uffff";
    static final String DFA4_maxS =
        "\1\176\1\uffff\1\162\1\uffff\1\170\1\171\3\uffff\1\141\2\uffff\1"+
        "\162\2\uffff\1\141\1\146\1\157\1\55\1\156\3\uffff\1\170\13\uffff"+
        "\1\uffff\32\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\2\uffff\1\6\1\7\1\10\1\uffff\1\12\1\13"+
        "\1\uffff\1\15\1\16\5\uffff\1\31\1\32\1\33\1\uffff\1\35\1\36\1\37"+
        "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\uffff\1\51\1\52\1\50"+
        "\1\2\1\3\1\4\1\20\1\23\1\5\1\22\1\30\1\11\1\14\1\26\1\15\1\16\1"+
        "\17\1\21\1\24\1\25\1\27\1\31\1\32\1\33\1\34\1\53";
    static final String DFA4_specialS =
        "\43\uffff\1\0\32\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\44\2\uffff\1\44\22\uffff\1\44\1\42\1\uffff\1\43\3\46\1\16"+
            "\1\45\1\uffff\2\46\1\7\1\42\1\40\1\37\1\27\1\30\10\31\1\15\1"+
            "\1\1\22\1\3\1\46\1\42\1\25\6\33\24\35\1\6\1\36\1\10\1\46\1\24"+
            "\1\46\1\23\1\32\1\17\1\21\1\4\1\32\1\2\1\34\1\20\5\34\1\14\4"+
            "\34\1\5\1\34\1\11\4\34\1\12\1\41\1\13\1\26",
            "",
            "\1\47",
            "",
            "\1\53\1\uffff\1\52\11\uffff\1\51",
            "\1\55\6\uffff\1\56\11\uffff\1\54",
            "",
            "",
            "",
            "\1\57",
            "",
            "",
            "\1\60\13\uffff\1\61",
            "",
            "",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "",
            "",
            "",
            "\1\74",
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
            "\0\75",
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

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | RULE_BINDIG | RULE_NBINDIG | RULE_LHEXCHAR | RULE_UHEXCHAR | RULE_LNHEXCHAR | RULE_UNHEXCHAR | RULE_BS | RULE_SLASH | RULE_DOT | RULE_PIPE | RULE_CHARSYM | RULE_OTHERSYM | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_35 = input.LA(1);

                        s = -1;
                        if ( ((LA4_35>='\u0000' && LA4_35<='\uFFFF')) ) {s = 61;}

                        else s = 38;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}