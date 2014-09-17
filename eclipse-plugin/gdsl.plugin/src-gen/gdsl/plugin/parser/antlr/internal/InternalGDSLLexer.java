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
    public static final int RULE_ID=4;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
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
    public static final int RULE_BS=14;
    public static final int RULE_ML_COMMENT=23;
    public static final int RULE_BINS=6;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=9;
    public static final int T__33=33;
    public static final int RULE_MIXID=13;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_OTHERSYM=21;
    public static final int RULE_NEGINT=16;
    public static final int RULE_DUALS=18;
    public static final int RULE_LESS=7;
    public static final int RULE_CHARSYM=20;
    public static final int RULE_WS=22;
    public static final int RULE_POSINT_WO_DUALS=17;

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

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:12:7: ( 'export' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:12:9: 'export'
            {
            match("export"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:13:7: ( ':' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:13:9: ':'
            {
            match(':'); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:14:7: ( 'type' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:14:9: 'type'
            {
            match("type"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:15:7: ( '=' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:15:9: '='
            {
            match('='); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:16:7: ( '|' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:16:9: '|'
            {
            match('|'); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:17:7: ( 'val' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:17:9: 'val'
            {
            match("val"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:18:7: ( '[' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:18:9: '['
            {
            match('['); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:19:7: ( ']' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:19:9: ']'
            {
            match(']'); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:20:7: ( ',' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:20:9: ','
            {
            match(','); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:21:7: ( 'of' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:21:9: 'of'
            {
            match("of"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:22:7: ( 'int' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:22:9: 'int'
            {
            match("int"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:23:7: ( 'string' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:23:9: 'string'
            {
            match("string"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:24:7: ( 'unit' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:24:9: 'unit'
            {
            match("unit"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:25:7: ( '{' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:25:9: '{'
            {
            match('{'); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:26:7: ( '}' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:26:9: '}'
            {
            match('}'); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:27:7: ( '(' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:27:9: '('
            {
            match('('); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:28:7: ( ')' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:28:9: ')'
            {
            match(')'); 

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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:29:7: ( '->' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:29:9: '->'
            {
            match("->"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:30:7: ( '()' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:30:9: '()'
            {
            match("()"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:31:7: ( '=>' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:31:9: '=>'
            {
            match("=>"); 


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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:32:7: ( 'case' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:32:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:33:7: ( 'end' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:33:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:34:7: ( 'if' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:34:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:35:7: ( 'then' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:35:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:36:7: ( 'else' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:36:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:37:7: ( 'do' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:37:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:38:7: ( '<-' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:38:9: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:39:7: ( 'or' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:39:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:40:7: ( 'and' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:40:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:41:7: ( '+' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:41:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:42:7: ( '-' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:42:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:43:7: ( '*' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:43:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:44:7: ( '%' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:44:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:45:7: ( '^' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:45:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:46:7: ( '~' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:46:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:47:7: ( '@' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:47:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:48:7: ( '$' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:48:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:49:7: ( 'let' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:49:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:50:7: ( 'in' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:50:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:51:7: ( '\\'' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:51:9: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "RULE_USCORE"
    public final void mRULE_USCORE() throws RecognitionException {
        try {
            int _type = RULE_USCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4088:13: ( '_' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4088:15: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_USCORE"

    // $ANTLR start "RULE_BS"
    public final void mRULE_BS() throws RecognitionException {
        try {
            int _type = RULE_BS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4090:9: ( '\\\\' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4090:11: '\\\\'
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

    // $ANTLR start "RULE_DOT"
    public final void mRULE_DOT() throws RecognitionException {
        try {
            int _type = RULE_DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4092:10: ( '.' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4092:12: '.'
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

    // $ANTLR start "RULE_S"
    public final void mRULE_S() throws RecognitionException {
        try {
            int _type = RULE_S;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4094:8: ( 'S' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4094:10: 'S'
            {
            match('S'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_S"

    // $ANTLR start "RULE_LESS"
    public final void mRULE_LESS() throws RecognitionException {
        try {
            int _type = RULE_LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4096:11: ( '<' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4096:13: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_LESS"

    // $ANTLR start "RULE_GREATER"
    public final void mRULE_GREATER() throws RecognitionException {
        try {
            int _type = RULE_GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4098:14: ( '>' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4098:16: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_GREATER"

    // $ANTLR start "RULE_MIXID"
    public final void mRULE_MIXID() throws RecognitionException {
        try {
            int _type = RULE_MIXID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4100:12: ( '_' ( RULE_USCORE | RULE_IDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4100:14: '_' ( RULE_USCORE | RULE_IDCHAR )*
            {
            match('_'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4100:18: ( RULE_USCORE | RULE_IDCHAR )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='!'||LA1_0=='-'||(LA1_0>='/' && LA1_0<='9')||LA1_0=='?'||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:
            	    {
            	    if ( input.LA(1)=='!'||input.LA(1)=='-'||(input.LA(1)>='/' && input.LA(1)<='9')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MIXID"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4102:9: ( ( 'A' .. 'Z' | 'a' .. 'z' | '/' ) ( RULE_USCORE | RULE_IDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4102:11: ( 'A' .. 'Z' | 'a' .. 'z' | '/' ) ( RULE_USCORE | RULE_IDCHAR )*
            {
            if ( input.LA(1)=='/'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4102:35: ( RULE_USCORE | RULE_IDCHAR )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='!'||LA2_0=='-'||(LA2_0>='/' && LA2_0<='9')||LA2_0=='?'||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:
            	    {
            	    if ( input.LA(1)=='!'||input.LA(1)=='-'||(input.LA(1)>='/' && input.LA(1)<='9')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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

    // $ANTLR start "RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER"
    public final void mRULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER() throws RecognitionException {
        try {
            int _type = RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4104:46: ( ( RULE_CHARSYM | RULE_OTHERSYM )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4104:48: ( RULE_CHARSYM | RULE_OTHERSYM )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4104:48: ( RULE_CHARSYM | RULE_OTHERSYM )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='!'||(LA3_0>='#' && LA3_0<='&')||(LA3_0>='*' && LA3_0<='+')||LA3_0=='-'||LA3_0=='/'||LA3_0==':'||(LA3_0>='<' && LA3_0<='@')||LA3_0=='\\'||LA3_0=='^'||LA3_0=='`'||LA3_0=='|'||LA3_0=='~') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:
            	    {
            	    if ( input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||input.LA(1)=='/'||input.LA(1)==':'||(input.LA(1)>='<' && input.LA(1)<='@')||input.LA(1)=='\\'||input.LA(1)=='^'||input.LA(1)=='`'||input.LA(1)=='|'||input.LA(1)=='~' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
    // $ANTLR end "RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4106:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4106:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4106:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4106:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4106:65: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_IDCHAR"
    public final void mRULE_IDCHAR() throws RecognitionException {
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4108:22: ( ( 'A' .. 'Z' | 'a' .. 'z' | '/' | '0' .. '9' | RULE_CHARSYM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4108:24: ( 'A' .. 'Z' | 'a' .. 'z' | '/' | '0' .. '9' | RULE_CHARSYM )
            {
            if ( input.LA(1)=='!'||input.LA(1)=='-'||(input.LA(1)>='/' && input.LA(1)<='9')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_IDCHAR"

    // $ANTLR start "RULE_CHARSYM"
    public final void mRULE_CHARSYM() throws RecognitionException {
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4110:23: ( ( '-' | '?' | '!' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4110:25: ( '-' | '?' | '!' )
            {
            if ( input.LA(1)=='!'||input.LA(1)=='-'||input.LA(1)=='?' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHARSYM"

    // $ANTLR start "RULE_OTHERSYM"
    public final void mRULE_OTHERSYM() throws RecognitionException {
        try {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4112:24: ( ( '%' | '&' | '$' | '+' | '/' | ':' | '<' | '=' | '>' | '@' | '~' | '`' | '^' | '|' | '#' | '*' | '\\\\' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4112:26: ( '%' | '&' | '$' | '+' | '/' | ':' | '<' | '=' | '>' | '@' | '~' | '`' | '^' | '|' | '#' | '*' | '\\\\' )
            {
            if ( (input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='/'||input.LA(1)==':'||(input.LA(1)>='<' && input.LA(1)<='>')||input.LA(1)=='@'||input.LA(1)=='\\'||input.LA(1)=='^'||input.LA(1)=='`'||input.LA(1)=='|'||input.LA(1)=='~' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_OTHERSYM"

    // $ANTLR start "RULE_DUALS"
    public final void mRULE_DUALS() throws RecognitionException {
        try {
            int _type = RULE_DUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4114:12: ( ( '0' | '1' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4114:14: ( '0' | '1' )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4114:14: ( '0' | '1' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='1')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DUALS"

    // $ANTLR start "RULE_BINS"
    public final void mRULE_BINS() throws RecognitionException {
        try {
            int _type = RULE_BINS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4116:11: ( ( '0' | '1' | '\\\\' | '.' | '|' )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4116:13: ( '0' | '1' | '\\\\' | '.' | '|' )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4116:13: ( '0' | '1' | '\\\\' | '.' | '|' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='.'||(LA6_0>='0' && LA6_0<='1')||LA6_0=='\\'||LA6_0=='|') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='1')||input.LA(1)=='\\'||input.LA(1)=='|' ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINS"

    // $ANTLR start "RULE_POSINT_WO_DUALS"
    public final void mRULE_POSINT_WO_DUALS() throws RecognitionException {
        try {
            int _type = RULE_POSINT_WO_DUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4118:22: ( ( '0' .. '9' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4118:24: ( '0' .. '9' )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4118:24: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4118:25: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_POSINT_WO_DUALS"

    // $ANTLR start "RULE_HEXINT"
    public final void mRULE_HEXINT() throws RecognitionException {
        try {
            int _type = RULE_HEXINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4120:13: ( '0x' ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4120:15: '0x' ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' )+
            {
            match("0x"); 

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4120:20: ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='F')||(LA8_0>='a' && LA8_0<='f')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEXINT"

    // $ANTLR start "RULE_NEGINT"
    public final void mRULE_NEGINT() throws RecognitionException {
        try {
            int _type = RULE_NEGINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4122:13: ( '~' ( '0' .. '9' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4122:15: '~' ( '0' .. '9' )+
            {
            match('~'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4122:19: ( '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4122:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEGINT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4124:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4124:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4124:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4126:17: ( '(*' ( options {greedy=false; } : . )* '*)' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4126:19: '(*' ( options {greedy=false; } : . )* '*)'
            {
            match("(*"); 

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4126:24: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==')') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1>='\u0000' && LA11_1<='(')||(LA11_1>='*' && LA11_1<='\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<=')')||(LA11_0>='+' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4126:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4128:17: ( '#' (~ ( '\\n' ) )* '\\n' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4128:19: '#' (~ ( '\\n' ) )* '\\n'
            {
            match('#'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4128:23: (~ ( '\\n' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:4128:23: ~ ( '\\n' )
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
            	    break loop12;
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
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:8: ( T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | RULE_USCORE | RULE_BS | RULE_DOT | RULE_S | RULE_LESS | RULE_GREATER | RULE_MIXID | RULE_ID | RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER | RULE_STRING | RULE_DUALS | RULE_BINS | RULE_POSINT_WO_DUALS | RULE_HEXINT | RULE_NEGINT | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT )
        int alt13=59;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:10: T__25
                {
                mT__25(); 

                }
                break;
            case 2 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:16: T__26
                {
                mT__26(); 

                }
                break;
            case 3 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:22: T__27
                {
                mT__27(); 

                }
                break;
            case 4 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:28: T__28
                {
                mT__28(); 

                }
                break;
            case 5 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:34: T__29
                {
                mT__29(); 

                }
                break;
            case 6 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:40: T__30
                {
                mT__30(); 

                }
                break;
            case 7 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:46: T__31
                {
                mT__31(); 

                }
                break;
            case 8 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:52: T__32
                {
                mT__32(); 

                }
                break;
            case 9 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:58: T__33
                {
                mT__33(); 

                }
                break;
            case 10 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:64: T__34
                {
                mT__34(); 

                }
                break;
            case 11 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:70: T__35
                {
                mT__35(); 

                }
                break;
            case 12 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:76: T__36
                {
                mT__36(); 

                }
                break;
            case 13 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:82: T__37
                {
                mT__37(); 

                }
                break;
            case 14 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:88: T__38
                {
                mT__38(); 

                }
                break;
            case 15 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:94: T__39
                {
                mT__39(); 

                }
                break;
            case 16 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:100: T__40
                {
                mT__40(); 

                }
                break;
            case 17 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:106: T__41
                {
                mT__41(); 

                }
                break;
            case 18 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:112: T__42
                {
                mT__42(); 

                }
                break;
            case 19 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:118: T__43
                {
                mT__43(); 

                }
                break;
            case 20 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:124: T__44
                {
                mT__44(); 

                }
                break;
            case 21 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:130: T__45
                {
                mT__45(); 

                }
                break;
            case 22 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:136: T__46
                {
                mT__46(); 

                }
                break;
            case 23 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:142: T__47
                {
                mT__47(); 

                }
                break;
            case 24 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:148: T__48
                {
                mT__48(); 

                }
                break;
            case 25 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:154: T__49
                {
                mT__49(); 

                }
                break;
            case 26 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:160: T__50
                {
                mT__50(); 

                }
                break;
            case 27 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:166: T__51
                {
                mT__51(); 

                }
                break;
            case 28 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:172: T__52
                {
                mT__52(); 

                }
                break;
            case 29 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:178: T__53
                {
                mT__53(); 

                }
                break;
            case 30 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:184: T__54
                {
                mT__54(); 

                }
                break;
            case 31 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:190: T__55
                {
                mT__55(); 

                }
                break;
            case 32 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:196: T__56
                {
                mT__56(); 

                }
                break;
            case 33 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:202: T__57
                {
                mT__57(); 

                }
                break;
            case 34 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:208: T__58
                {
                mT__58(); 

                }
                break;
            case 35 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:214: T__59
                {
                mT__59(); 

                }
                break;
            case 36 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:220: T__60
                {
                mT__60(); 

                }
                break;
            case 37 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:226: T__61
                {
                mT__61(); 

                }
                break;
            case 38 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:232: T__62
                {
                mT__62(); 

                }
                break;
            case 39 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:238: T__63
                {
                mT__63(); 

                }
                break;
            case 40 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:244: T__64
                {
                mT__64(); 

                }
                break;
            case 41 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:250: T__65
                {
                mT__65(); 

                }
                break;
            case 42 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:256: RULE_USCORE
                {
                mRULE_USCORE(); 

                }
                break;
            case 43 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:268: RULE_BS
                {
                mRULE_BS(); 

                }
                break;
            case 44 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:276: RULE_DOT
                {
                mRULE_DOT(); 

                }
                break;
            case 45 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:285: RULE_S
                {
                mRULE_S(); 

                }
                break;
            case 46 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:292: RULE_LESS
                {
                mRULE_LESS(); 

                }
                break;
            case 47 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:302: RULE_GREATER
                {
                mRULE_GREATER(); 

                }
                break;
            case 48 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:315: RULE_MIXID
                {
                mRULE_MIXID(); 

                }
                break;
            case 49 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:326: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 50 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:334: RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER
                {
                mRULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER(); 

                }
                break;
            case 51 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:379: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 52 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:391: RULE_DUALS
                {
                mRULE_DUALS(); 

                }
                break;
            case 53 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:402: RULE_BINS
                {
                mRULE_BINS(); 

                }
                break;
            case 54 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:412: RULE_POSINT_WO_DUALS
                {
                mRULE_POSINT_WO_DUALS(); 

                }
                break;
            case 55 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:433: RULE_HEXINT
                {
                mRULE_HEXINT(); 

                }
                break;
            case 56 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:445: RULE_NEGINT
                {
                mRULE_NEGINT(); 

                }
                break;
            case 57 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:457: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 58 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:465: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 59 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:481: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\53\1\uffff\1\47\1\63\1\47\1\67\1\70\1\47\3\uffff\4\47\2\uffff"+
        "\1\103\1\uffff\1\105\2\47\1\111\1\47\1\113\1\114\1\115\1\116\1\117"+
        "\1\121\1\122\1\47\1\uffff\1\124\1\126\1\127\1\130\1\131\1\47\1\uffff"+
        "\1\57\1\uffff\1\136\2\uffff\1\136\2\uffff\3\47\1\uffff\2\47\1\144"+
        "\2\uffff\1\57\1\47\1\146\1\147\1\151\1\152\2\47\3\uffff\1\155\1"+
        "\uffff\1\47\1\157\1\160\1\uffff\1\47\10\uffff\1\47\6\uffff\1\47"+
        "\1\57\3\uffff\1\47\1\164\3\47\1\uffff\1\170\2\uffff\1\171\2\uffff"+
        "\2\47\1\uffff\1\47\2\uffff\1\175\1\176\1\47\1\uffff\1\u0080\1\u0081"+
        "\1\u0082\2\uffff\1\47\1\u0084\1\u0085\2\uffff\1\47\3\uffff\1\47"+
        "\2\uffff\1\u0088\1\u0089\2\uffff";
    static final String DFA13_eofS =
        "\u008a\uffff";
    static final String DFA13_minS =
        "\1\11\1\uffff\1\154\1\41\1\150\2\41\1\141\3\uffff\2\146\1\164\1"+
        "\156\2\uffff\1\51\1\uffff\1\41\1\141\1\157\1\41\1\156\7\41\1\145"+
        "\1\uffff\2\41\1\56\3\41\1\uffff\1\0\1\uffff\1\56\2\uffff\1\56\2"+
        "\uffff\1\160\1\144\1\163\1\uffff\1\160\1\145\1\41\2\uffff\1\56\1"+
        "\154\4\41\1\162\1\151\3\uffff\1\41\1\uffff\1\163\2\41\1\uffff\1"+
        "\144\10\uffff\1\164\6\uffff\1\41\1\0\3\uffff\1\157\1\41\2\145\1"+
        "\156\1\uffff\1\41\2\uffff\1\41\2\uffff\1\151\1\164\1\uffff\1\145"+
        "\2\uffff\2\41\1\162\1\uffff\3\41\2\uffff\1\156\2\41\2\uffff\1\164"+
        "\3\uffff\1\147\2\uffff\2\41\2\uffff";
    static final String DFA13_maxS =
        "\1\176\1\uffff\1\170\1\176\1\171\2\176\1\141\3\uffff\1\162\1\156"+
        "\1\164\1\156\2\uffff\1\52\1\uffff\1\176\1\141\1\157\1\176\1\156"+
        "\7\176\1\145\1\uffff\1\172\1\176\1\174\1\172\2\176\1\uffff\1\uffff"+
        "\1\uffff\1\174\2\uffff\1\174\2\uffff\1\160\1\144\1\163\1\uffff\1"+
        "\160\1\145\1\176\2\uffff\1\174\1\154\4\172\1\162\1\151\3\uffff\1"+
        "\176\1\uffff\1\163\1\172\1\176\1\uffff\1\144\10\uffff\1\164\6\uffff"+
        "\1\176\1\uffff\3\uffff\1\157\1\172\2\145\1\156\1\uffff\1\172\2\uffff"+
        "\1\172\2\uffff\1\151\1\164\1\uffff\1\145\2\uffff\2\172\1\162\1\uffff"+
        "\3\172\2\uffff\1\156\2\172\2\uffff\1\164\3\uffff\1\147\2\uffff\2"+
        "\172\2\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\6\uffff\1\10\1\11\1\12\4\uffff\1\17\1\20\1\uffff\1"+
        "\22\15\uffff\1\51\6\uffff\1\61\1\uffff\1\63\1\uffff\1\65\1\66\1"+
        "\uffff\1\71\1\62\3\uffff\1\3\3\uffff\1\5\1\6\10\uffff\1\24\1\72"+
        "\1\21\1\uffff\1\40\3\uffff\1\56\1\uffff\1\37\1\41\1\42\1\43\1\44"+
        "\1\70\1\45\1\46\1\uffff\1\52\1\60\1\53\1\54\1\55\1\57\2\uffff\1"+
        "\73\1\67\1\64\5\uffff\1\25\1\uffff\1\13\1\35\1\uffff\1\50\1\30\2"+
        "\uffff\1\23\1\uffff\1\33\1\34\3\uffff\1\27\3\uffff\1\7\1\14\3\uffff"+
        "\1\36\1\47\1\uffff\1\32\1\4\1\31\1\uffff\1\16\1\26\2\uffff\1\2\1"+
        "\15";
    static final String DFA13_specialS =
        "\50\uffff\1\0\62\uffff\1\1\56\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\56\2\uffff\1\56\22\uffff\1\56\1\57\1\51\1\50\1\36\1\32\1"+
            "\57\1\40\1\21\1\22\1\31\1\30\1\12\1\23\1\43\1\46\1\52\1\55\10"+
            "\54\1\3\1\1\1\26\1\5\1\45\1\57\1\35\22\47\1\44\7\47\1\10\1\42"+
            "\1\11\1\33\1\41\1\57\1\27\1\47\1\24\1\25\1\2\3\47\1\14\2\47"+
            "\1\37\2\47\1\13\3\47\1\15\1\4\1\16\1\7\4\47\1\17\1\6\1\20\1"+
            "\34",
            "",
            "\1\62\1\uffff\1\61\11\uffff\1\60",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\65\20\uffff\1\64",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\2\57\1\66\2\57\33\uffff\1\57\1\uffff\1\57"+
            "\1\uffff\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\53\1\57\2\53"+
            "\10\uffff\1\57\1\uffff\5\57\33\uffff\1\71\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\71\1\uffff\1\57",
            "\1\72",
            "",
            "",
            "",
            "\1\73\13\uffff\1\74",
            "\1\76\7\uffff\1\75",
            "\1\77",
            "\1\100",
            "",
            "",
            "\1\101\1\102",
            "",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\2\57\1\104\2\57\33\uffff\1\57\1\uffff\1"+
            "\57\1\uffff\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\106",
            "\1\107",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\110\1\uffff\1\57"+
            "\12\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\112",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\120\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff\1"+
            "\57\33\uffff\1\57\1\uffff\1\57",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\123",
            "",
            "\1\125\13\uffff\1\125\1\uffff\13\125\5\uffff\1\125\1\uffff"+
            "\32\125\4\uffff\1\125\1\uffff\32\125",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\53\1\57\2\53"+
            "\10\uffff\1\57\1\uffff\5\57\33\uffff\1\71\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\71\1\uffff\1\57",
            "\1\53\1\uffff\2\53\52\uffff\1\53\37\uffff\1\53",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "\1\132\1\uffff\4\57\3\uffff\2\57\1\uffff\1\132\1\uffff\1\132"+
            "\12\uffff\1\57\1\uffff\3\57\1\132\1\57\33\uffff\1\57\1\uffff"+
            "\1\57\1\uffff\1\57\33\uffff\1\57\1\uffff\1\57",
            "",
            "\41\134\1\133\1\134\4\133\3\134\2\133\1\134\1\133\1\134\1\133"+
            "\12\134\1\133\1\134\5\133\33\134\1\133\1\134\1\133\1\134\1\133"+
            "\33\134\1\133\1\134\1\133\uff81\134",
            "",
            "\1\53\1\uffff\2\55\10\54\42\uffff\1\53\33\uffff\1\135\3\uffff"+
            "\1\53",
            "",
            "",
            "\1\53\1\uffff\2\55\10\54\42\uffff\1\53\37\uffff\1\53",
            "",
            "",
            "\1\137",
            "\1\140",
            "\1\141",
            "",
            "\1\142",
            "\1\143",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "",
            "",
            "\1\53\1\uffff\2\53\52\uffff\1\71\37\uffff\1\71",
            "\1\145",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\23\47\1\150\6\47",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\153",
            "\1\154",
            "",
            "",
            "",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "",
            "\1\156",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\57\1\uffff\4\57\3\uffff\2\57\1\uffff\1\57\1\uffff\1\57\12"+
            "\uffff\1\57\1\uffff\5\57\33\uffff\1\57\1\uffff\1\57\1\uffff"+
            "\1\57\33\uffff\1\57\1\uffff\1\57",
            "",
            "\1\161",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\162",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\132\1\uffff\4\57\3\uffff\2\57\1\uffff\1\132\1\uffff\1\132"+
            "\12\uffff\1\57\1\uffff\3\57\1\132\1\57\33\uffff\1\57\1\uffff"+
            "\1\57\1\uffff\1\57\33\uffff\1\57\1\uffff\1\57",
            "\41\134\1\133\1\134\4\133\3\134\2\133\1\134\1\133\1\134\1\133"+
            "\12\134\1\133\1\134\5\133\33\134\1\133\1\134\1\133\1\134\1\133"+
            "\33\134\1\133\1\134\1\133\uff81\134",
            "",
            "",
            "",
            "\1\163",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\172",
            "\1\173",
            "",
            "\1\174",
            "",
            "",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\177",
            "",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\u0083",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\u0086",
            "",
            "",
            "",
            "\1\u0087",
            "",
            "",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "\1\47\13\uffff\1\47\1\uffff\13\47\5\uffff\1\47\1\uffff\32\47"+
            "\4\uffff\1\47\1\uffff\32\47",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | RULE_USCORE | RULE_BS | RULE_DOT | RULE_S | RULE_LESS | RULE_GREATER | RULE_MIXID | RULE_ID | RULE_SYM_WO_USCORE_SLASH_BS_DOT_LESS_GREATER | RULE_STRING | RULE_DUALS | RULE_BINS | RULE_POSINT_WO_DUALS | RULE_HEXINT | RULE_NEGINT | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_40 = input.LA(1);

                        s = -1;
                        if ( (LA13_40=='!'||(LA13_40>='#' && LA13_40<='&')||(LA13_40>='*' && LA13_40<='+')||LA13_40=='-'||LA13_40=='/'||LA13_40==':'||(LA13_40>='<' && LA13_40<='@')||LA13_40=='\\'||LA13_40=='^'||LA13_40=='`'||LA13_40=='|'||LA13_40=='~') ) {s = 91;}

                        else if ( ((LA13_40>='\u0000' && LA13_40<=' ')||LA13_40=='\"'||(LA13_40>='\'' && LA13_40<=')')||LA13_40==','||LA13_40=='.'||(LA13_40>='0' && LA13_40<='9')||LA13_40==';'||(LA13_40>='A' && LA13_40<='[')||LA13_40==']'||LA13_40=='_'||(LA13_40>='a' && LA13_40<='{')||LA13_40=='}'||(LA13_40>='\u007F' && LA13_40<='\uFFFF')) ) {s = 92;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_91 = input.LA(1);

                        s = -1;
                        if ( (LA13_91=='!'||(LA13_91>='#' && LA13_91<='&')||(LA13_91>='*' && LA13_91<='+')||LA13_91=='-'||LA13_91=='/'||LA13_91==':'||(LA13_91>='<' && LA13_91<='@')||LA13_91=='\\'||LA13_91=='^'||LA13_91=='`'||LA13_91=='|'||LA13_91=='~') ) {s = 91;}

                        else if ( ((LA13_91>='\u0000' && LA13_91<=' ')||LA13_91=='\"'||(LA13_91>='\'' && LA13_91<=')')||LA13_91==','||LA13_91=='.'||(LA13_91>='0' && LA13_91<='9')||LA13_91==';'||(LA13_91>='A' && LA13_91<='[')||LA13_91==']'||LA13_91=='_'||(LA13_91>='a' && LA13_91<='{')||LA13_91=='}'||(LA13_91>='\u007F' && LA13_91<='\uFFFF')) ) {s = 92;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}