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
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER=15;
    public static final int RULE_CONS_WO_S=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
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
    public static final int RULE_BS=14;
    public static final int RULE_ML_COMMENT=25;
    public static final int RULE_BINS=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=7;
    public static final int T__33=33;
    public static final int RULE_MIXID=13;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int RULE_ID_WO_CONS=11;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_OTHERSYM=22;
    public static final int RULE_NEGINT=16;
    public static final int RULE_DUALS=18;
    public static final int RULE_LESS=5;
    public static final int RULE_SLASH=12;
    public static final int RULE_CHARSYM=21;
    public static final int RULE_WS=24;
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

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
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
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
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
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
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
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
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
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
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
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
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
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
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
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
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
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
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
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
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
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
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
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
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
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
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
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
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
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
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
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
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
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
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
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
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
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
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
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
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
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
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
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
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
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
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
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
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
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
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
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
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
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
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
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
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
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
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
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
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
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
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
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
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
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
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
    // $ANTLR end "T__67"

    // $ANTLR start "RULE_USCORE"
    public final void mRULE_USCORE() throws RecognitionException {
        try {
            int _type = RULE_USCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3637:13: ( '_' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3637:15: '_'
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

    // $ANTLR start "RULE_SLASH"
    public final void mRULE_SLASH() throws RecognitionException {
        try {
            int _type = RULE_SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3639:12: ( '/' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3639:14: '/'
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

    // $ANTLR start "RULE_BS"
    public final void mRULE_BS() throws RecognitionException {
        try {
            int _type = RULE_BS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3641:9: ( '\\\\' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3641:11: '\\\\'
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3643:10: ( '.' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3643:12: '.'
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3645:8: ( 'S' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3645:10: 'S'
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3647:11: ( '<' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3647:13: '<'
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3649:14: ( '>' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3649:16: '>'
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

    // $ANTLR start "RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER"
    public final void mRULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER() throws RecognitionException {
        try {
            int _type = RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3651:61: ( ( RULE_CHARSYM | RULE_OTHERSYM )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3651:63: ( RULE_CHARSYM | RULE_OTHERSYM )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3651:63: ( RULE_CHARSYM | RULE_OTHERSYM )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='!'||(LA1_0>='#' && LA1_0<='&')||(LA1_0>='*' && LA1_0<='+')||LA1_0=='-'||LA1_0=='/'||LA1_0==':'||(LA1_0>='<' && LA1_0<='@')||LA1_0=='\\'||LA1_0=='^'||LA1_0=='`'||LA1_0=='|'||LA1_0=='~') ) {
                    alt1=1;
                }


                switch (alt1) {
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
    // $ANTLR end "RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER"

    // $ANTLR start "RULE_MIXID"
    public final void mRULE_MIXID() throws RecognitionException {
        try {
            int _type = RULE_MIXID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3653:12: ( '_' ( RULE_USCORE | RULE_IDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3653:14: '_' ( RULE_USCORE | RULE_IDCHAR )*
            {
            match('_'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3653:18: ( RULE_USCORE | RULE_IDCHAR )*
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
    // $ANTLR end "RULE_MIXID"

    // $ANTLR start "RULE_CONS_WO_S"
    public final void mRULE_CONS_WO_S() throws RecognitionException {
        try {
            int _type = RULE_CONS_WO_S;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3655:16: ( 'A' .. 'Z' ( RULE_USCORE | RULE_IDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3655:18: 'A' .. 'Z' ( RULE_USCORE | RULE_IDCHAR )*
            {
            matchRange('A','Z'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3655:27: ( RULE_USCORE | RULE_IDCHAR )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='!'||LA3_0=='-'||(LA3_0>='/' && LA3_0<='9')||LA3_0=='?'||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
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
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CONS_WO_S"

    // $ANTLR start "RULE_ID_WO_CONS"
    public final void mRULE_ID_WO_CONS() throws RecognitionException {
        try {
            int _type = RULE_ID_WO_CONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3657:17: ( ( 'A' .. 'Z' | 'a' .. 'z' | '/' ) ( RULE_USCORE | RULE_IDCHAR )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3657:19: ( 'A' .. 'Z' | 'a' .. 'z' | '/' ) ( RULE_USCORE | RULE_IDCHAR )*
            {
            if ( input.LA(1)=='/'||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3657:43: ( RULE_USCORE | RULE_IDCHAR )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='!'||LA4_0=='-'||(LA4_0>='/' && LA4_0<='9')||LA4_0=='?'||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
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
    // $ANTLR end "RULE_ID_WO_CONS"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3659:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3659:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3659:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3659:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3659:65: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop5;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3661:22: ( ( 'A' .. 'Z' | 'a' .. 'z' | '/' | '0' .. '9' | RULE_CHARSYM ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3661:24: ( 'A' .. 'Z' | 'a' .. 'z' | '/' | '0' .. '9' | RULE_CHARSYM )
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3663:23: ( ( '-' | '?' | '!' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3663:25: ( '-' | '?' | '!' )
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3665:24: ( ( '%' | '&' | '$' | '+' | '/' | ':' | '<' | '=' | '>' | '@' | '~' | '`' | '^' | '|' | '#' | '*' | '\\\\' ) )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3665:26: ( '%' | '&' | '$' | '+' | '/' | ':' | '<' | '=' | '>' | '@' | '~' | '`' | '^' | '|' | '#' | '*' | '\\\\' )
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3667:12: ( ( '0' | '1' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3667:14: ( '0' | '1' )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3667:14: ( '0' | '1' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='1')) ) {
                    alt6=1;
                }


                switch (alt6) {
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3669:11: ( ( '0' | '1' | '\\\\' | '.' | '|' )* )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3669:13: ( '0' | '1' | '\\\\' | '.' | '|' )*
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3669:13: ( '0' | '1' | '\\\\' | '.' | '|' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='.'||(LA7_0>='0' && LA7_0<='1')||LA7_0=='\\'||LA7_0=='|') ) {
                    alt7=1;
                }


                switch (alt7) {
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
            	    break loop7;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3671:22: ( ( '0' .. '9' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3671:24: ( '0' .. '9' )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3671:24: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3671:25: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_POSINT_WO_DUALS"

    // $ANTLR start "RULE_HEXINT"
    public final void mRULE_HEXINT() throws RecognitionException {
        try {
            int _type = RULE_HEXINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3673:13: ( '0x' ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3673:15: '0x' ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' )+
            {
            match("0x"); 

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3673:20: ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='F')||(LA9_0>='a' && LA9_0<='f')) ) {
                    alt9=1;
                }


                switch (alt9) {
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
    // $ANTLR end "RULE_HEXINT"

    // $ANTLR start "RULE_NEGINT"
    public final void mRULE_NEGINT() throws RecognitionException {
        try {
            int _type = RULE_NEGINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3675:13: ( '~' ( '0' .. '9' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3675:15: '~' ( '0' .. '9' )+
            {
            match('~'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3675:19: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3675:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
    // $ANTLR end "RULE_NEGINT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3677:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3677:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3677:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3679:17: ( '(*' ( options {greedy=false; } : . )* '*)' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3679:19: '(*' ( options {greedy=false; } : . )* '*)'
            {
            match("(*"); 

            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3679:24: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==')') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='(')||(LA12_1>='*' && LA12_1<='\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3679:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3681:17: ( '#' (~ ( '\\n' ) )* '\\n' )
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3681:19: '#' (~ ( '\\n' ) )* '\\n'
            {
            match('#'); 
            // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3681:23: (~ ( '\\n' ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:3681:23: ~ ( '\\n' )
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
            	    break loop13;
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
        // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:8: ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | RULE_USCORE | RULE_SLASH | RULE_BS | RULE_DOT | RULE_S | RULE_LESS | RULE_GREATER | RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER | RULE_MIXID | RULE_CONS_WO_S | RULE_ID_WO_CONS | RULE_STRING | RULE_DUALS | RULE_BINS | RULE_POSINT_WO_DUALS | RULE_HEXINT | RULE_NEGINT | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT )
        int alt14=61;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:10: T__27
                {
                mT__27(); 

                }
                break;
            case 2 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:16: T__28
                {
                mT__28(); 

                }
                break;
            case 3 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:22: T__29
                {
                mT__29(); 

                }
                break;
            case 4 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:28: T__30
                {
                mT__30(); 

                }
                break;
            case 5 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:34: T__31
                {
                mT__31(); 

                }
                break;
            case 6 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:40: T__32
                {
                mT__32(); 

                }
                break;
            case 7 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:46: T__33
                {
                mT__33(); 

                }
                break;
            case 8 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:52: T__34
                {
                mT__34(); 

                }
                break;
            case 9 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:58: T__35
                {
                mT__35(); 

                }
                break;
            case 10 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:64: T__36
                {
                mT__36(); 

                }
                break;
            case 11 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:70: T__37
                {
                mT__37(); 

                }
                break;
            case 12 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:76: T__38
                {
                mT__38(); 

                }
                break;
            case 13 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:82: T__39
                {
                mT__39(); 

                }
                break;
            case 14 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:88: T__40
                {
                mT__40(); 

                }
                break;
            case 15 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:94: T__41
                {
                mT__41(); 

                }
                break;
            case 16 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:100: T__42
                {
                mT__42(); 

                }
                break;
            case 17 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:106: T__43
                {
                mT__43(); 

                }
                break;
            case 18 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:112: T__44
                {
                mT__44(); 

                }
                break;
            case 19 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:118: T__45
                {
                mT__45(); 

                }
                break;
            case 20 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:124: T__46
                {
                mT__46(); 

                }
                break;
            case 21 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:130: T__47
                {
                mT__47(); 

                }
                break;
            case 22 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:136: T__48
                {
                mT__48(); 

                }
                break;
            case 23 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:142: T__49
                {
                mT__49(); 

                }
                break;
            case 24 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:148: T__50
                {
                mT__50(); 

                }
                break;
            case 25 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:154: T__51
                {
                mT__51(); 

                }
                break;
            case 26 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:160: T__52
                {
                mT__52(); 

                }
                break;
            case 27 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:166: T__53
                {
                mT__53(); 

                }
                break;
            case 28 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:172: T__54
                {
                mT__54(); 

                }
                break;
            case 29 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:178: T__55
                {
                mT__55(); 

                }
                break;
            case 30 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:184: T__56
                {
                mT__56(); 

                }
                break;
            case 31 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:190: T__57
                {
                mT__57(); 

                }
                break;
            case 32 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:196: T__58
                {
                mT__58(); 

                }
                break;
            case 33 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:202: T__59
                {
                mT__59(); 

                }
                break;
            case 34 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:208: T__60
                {
                mT__60(); 

                }
                break;
            case 35 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:214: T__61
                {
                mT__61(); 

                }
                break;
            case 36 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:220: T__62
                {
                mT__62(); 

                }
                break;
            case 37 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:226: T__63
                {
                mT__63(); 

                }
                break;
            case 38 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:232: T__64
                {
                mT__64(); 

                }
                break;
            case 39 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:238: T__65
                {
                mT__65(); 

                }
                break;
            case 40 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:244: T__66
                {
                mT__66(); 

                }
                break;
            case 41 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:250: T__67
                {
                mT__67(); 

                }
                break;
            case 42 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:256: RULE_USCORE
                {
                mRULE_USCORE(); 

                }
                break;
            case 43 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:268: RULE_SLASH
                {
                mRULE_SLASH(); 

                }
                break;
            case 44 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:279: RULE_BS
                {
                mRULE_BS(); 

                }
                break;
            case 45 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:287: RULE_DOT
                {
                mRULE_DOT(); 

                }
                break;
            case 46 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:296: RULE_S
                {
                mRULE_S(); 

                }
                break;
            case 47 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:303: RULE_LESS
                {
                mRULE_LESS(); 

                }
                break;
            case 48 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:313: RULE_GREATER
                {
                mRULE_GREATER(); 

                }
                break;
            case 49 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:326: RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER
                {
                mRULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER(); 

                }
                break;
            case 50 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:386: RULE_MIXID
                {
                mRULE_MIXID(); 

                }
                break;
            case 51 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:397: RULE_CONS_WO_S
                {
                mRULE_CONS_WO_S(); 

                }
                break;
            case 52 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:412: RULE_ID_WO_CONS
                {
                mRULE_ID_WO_CONS(); 

                }
                break;
            case 53 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:428: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 54 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:440: RULE_DUALS
                {
                mRULE_DUALS(); 

                }
                break;
            case 55 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:451: RULE_BINS
                {
                mRULE_BINS(); 

                }
                break;
            case 56 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:461: RULE_POSINT_WO_DUALS
                {
                mRULE_POSINT_WO_DUALS(); 

                }
                break;
            case 57 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:482: RULE_HEXINT
                {
                mRULE_HEXINT(); 

                }
                break;
            case 58 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:494: RULE_NEGINT
                {
                mRULE_NEGINT(); 

                }
                break;
            case 59 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:506: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 60 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:514: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 61 :
                // ../gdsl.plugin/src-gen/gdsl/plugin/parser/antlr/internal/InternalGDSL.g:1:530: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\54\1\uffff\1\51\1\64\1\51\1\70\1\71\1\51\3\uffff\4\51\2\uffff"+
        "\1\104\1\uffff\1\106\2\51\1\112\1\51\1\114\1\115\1\116\1\117\1\121"+
        "\1\122\1\123\1\51\1\uffff\1\125\1\130\1\131\1\132\1\134\1\135\1"+
        "\60\1\140\2\uffff\1\142\2\uffff\1\142\2\uffff\3\51\1\uffff\2\51"+
        "\1\150\2\uffff\1\60\1\51\1\152\1\153\1\155\1\156\2\51\3\uffff\1"+
        "\161\1\uffff\1\51\1\163\1\164\1\uffff\1\51\10\uffff\1\51\2\uffff"+
        "\1\60\3\uffff\1\140\2\uffff\1\60\4\uffff\1\51\1\170\3\51\1\uffff"+
        "\1\174\2\uffff\1\175\2\uffff\2\51\1\uffff\1\51\2\uffff\1\u0081\1"+
        "\u0082\1\51\1\uffff\1\u0084\1\u0085\1\u0086\2\uffff\1\51\1\u0088"+
        "\1\u0089\2\uffff\1\51\3\uffff\1\51\2\uffff\1\u008c\1\u008d\2\uffff";
    static final String DFA14_eofS =
        "\u008e\uffff";
    static final String DFA14_minS =
        "\1\11\1\uffff\1\154\1\41\1\150\2\41\1\141\3\uffff\2\146\1\164\1"+
        "\156\2\uffff\1\51\1\uffff\1\41\1\141\1\157\1\41\1\156\7\41\1\145"+
        "\1\uffff\3\41\1\56\2\41\1\0\1\41\2\uffff\1\56\2\uffff\1\56\2\uffff"+
        "\1\160\1\144\1\163\1\uffff\1\160\1\145\1\41\2\uffff\1\56\1\154\4"+
        "\41\1\162\1\151\3\uffff\1\41\1\uffff\1\163\2\41\1\uffff\1\144\10"+
        "\uffff\1\164\2\uffff\1\41\3\uffff\1\41\2\uffff\1\0\4\uffff\1\157"+
        "\1\41\2\145\1\156\1\uffff\1\41\2\uffff\1\41\2\uffff\1\151\1\164"+
        "\1\uffff\1\145\2\uffff\2\41\1\162\1\uffff\3\41\2\uffff\1\156\2\41"+
        "\2\uffff\1\164\3\uffff\1\147\2\uffff\2\41\2\uffff";
    static final String DFA14_maxS =
        "\1\176\1\uffff\1\170\1\176\1\171\2\176\1\141\3\uffff\1\162\1\156"+
        "\1\164\1\156\2\uffff\1\52\1\uffff\1\176\1\141\1\157\1\176\1\156"+
        "\7\176\1\145\1\uffff\1\172\2\176\1\174\1\172\1\176\1\uffff\1\172"+
        "\2\uffff\1\174\2\uffff\1\174\2\uffff\1\160\1\144\1\163\1\uffff\1"+
        "\160\1\145\1\176\2\uffff\1\174\1\154\4\172\1\162\1\151\3\uffff\1"+
        "\176\1\uffff\1\163\1\172\1\176\1\uffff\1\144\10\uffff\1\164\2\uffff"+
        "\1\172\3\uffff\1\172\2\uffff\1\uffff\4\uffff\1\157\1\172\2\145\1"+
        "\156\1\uffff\1\172\2\uffff\1\172\2\uffff\1\151\1\164\1\uffff\1\145"+
        "\2\uffff\2\172\1\162\1\uffff\3\172\2\uffff\1\156\2\172\2\uffff\1"+
        "\164\3\uffff\1\147\2\uffff\2\172\2\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\6\uffff\1\10\1\11\1\12\4\uffff\1\17\1\20\1\uffff\1"+
        "\22\15\uffff\1\51\10\uffff\1\64\1\65\1\uffff\1\67\1\70\1\uffff\1"+
        "\73\1\61\3\uffff\1\3\3\uffff\1\5\1\6\10\uffff\1\24\1\74\1\21\1\uffff"+
        "\1\40\3\uffff\1\57\1\uffff\1\37\1\41\1\42\1\43\1\72\1\44\1\45\1"+
        "\46\1\uffff\1\52\1\62\1\uffff\1\53\1\54\1\55\1\uffff\1\56\1\60\1"+
        "\uffff\1\75\1\63\1\71\1\66\5\uffff\1\25\1\uffff\1\13\1\35\1\uffff"+
        "\1\50\1\30\2\uffff\1\23\1\uffff\1\33\1\34\3\uffff\1\27\3\uffff\1"+
        "\7\1\14\3\uffff\1\36\1\47\1\uffff\1\32\1\4\1\31\1\uffff\1\16\1\26"+
        "\2\uffff\1\2\1\15";
    static final String DFA14_specialS =
        "\47\uffff\1\1\66\uffff\1\0\57\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\57\2\uffff\1\57\22\uffff\1\57\1\60\1\52\1\47\1\36\1\32\1"+
            "\60\1\40\1\21\1\22\1\31\1\30\1\12\1\23\1\44\1\42\1\53\1\56\10"+
            "\55\1\3\1\1\1\26\1\5\1\46\1\60\1\35\22\50\1\45\7\50\1\10\1\43"+
            "\1\11\1\33\1\41\1\60\1\27\1\51\1\24\1\25\1\2\3\51\1\14\2\51"+
            "\1\37\2\51\1\13\3\51\1\15\1\4\1\16\1\7\4\51\1\17\1\6\1\20\1"+
            "\34",
            "",
            "\1\63\1\uffff\1\62\11\uffff\1\61",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\66\20\uffff\1\65",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\2\60\1\67\2\60\33\uffff\1\60\1\uffff\1\60"+
            "\1\uffff\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\54\1\60\2\54"+
            "\10\uffff\1\60\1\uffff\5\60\33\uffff\1\72\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\72\1\uffff\1\60",
            "\1\73",
            "",
            "",
            "",
            "\1\74\13\uffff\1\75",
            "\1\77\7\uffff\1\76",
            "\1\100",
            "\1\101",
            "",
            "",
            "\1\102\1\103",
            "",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\2\60\1\105\2\60\33\uffff\1\60\1\uffff\1"+
            "\60\1\uffff\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\107",
            "\1\110",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\111\1\uffff\1\60"+
            "\12\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\113",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\120\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff\1"+
            "\60\33\uffff\1\60\1\uffff\1\60",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "\1\124",
            "",
            "\1\126\13\uffff\1\126\1\uffff\13\126\5\uffff\1\126\1\uffff"+
            "\32\126\4\uffff\1\126\1\uffff\32\126",
            "\1\127\1\uffff\4\60\3\uffff\2\60\1\uffff\1\127\1\uffff\1\127"+
            "\12\51\1\60\1\uffff\3\60\1\127\1\60\32\51\1\uffff\1\60\1\uffff"+
            "\1\60\1\51\1\60\32\51\1\uffff\1\60\1\uffff\1\60",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\54\1\60\2\54"+
            "\10\uffff\1\60\1\uffff\5\60\33\uffff\1\72\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\72\1\uffff\1\60",
            "\1\54\1\uffff\2\54\52\uffff\1\54\37\uffff\1\54",
            "\1\133\13\uffff\1\133\1\uffff\13\133\5\uffff\1\133\1\uffff"+
            "\32\133\4\uffff\1\133\1\uffff\32\133",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "\41\137\1\136\1\137\4\136\3\137\2\136\1\137\1\136\1\137\1\136"+
            "\12\137\1\136\1\137\5\136\33\137\1\136\1\137\1\136\1\137\1\136"+
            "\33\137\1\136\1\137\1\136\uff81\137",
            "\1\133\13\uffff\1\133\1\uffff\13\133\5\uffff\1\133\1\uffff"+
            "\32\133\4\uffff\1\133\1\uffff\32\133",
            "",
            "",
            "\1\54\1\uffff\2\56\10\55\42\uffff\1\54\33\uffff\1\141\3\uffff"+
            "\1\54",
            "",
            "",
            "\1\54\1\uffff\2\56\10\55\42\uffff\1\54\37\uffff\1\54",
            "",
            "",
            "\1\143",
            "\1\144",
            "\1\145",
            "",
            "\1\146",
            "\1\147",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "",
            "",
            "\1\54\1\uffff\2\54\52\uffff\1\72\37\uffff\1\72",
            "\1\151",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\23\51\1\154\6\51",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\157",
            "\1\160",
            "",
            "",
            "",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "",
            "\1\162",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\60\1\uffff\4\60\3\uffff\2\60\1\uffff\1\60\1\uffff\1\60\12"+
            "\uffff\1\60\1\uffff\5\60\33\uffff\1\60\1\uffff\1\60\1\uffff"+
            "\1\60\33\uffff\1\60\1\uffff\1\60",
            "",
            "\1\165",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\166",
            "",
            "",
            "\1\127\13\uffff\1\127\1\uffff\1\127\12\51\5\uffff\1\127\1\uffff"+
            "\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "",
            "\1\133\13\uffff\1\133\1\uffff\13\133\5\uffff\1\133\1\uffff"+
            "\32\133\4\uffff\1\133\1\uffff\32\133",
            "",
            "",
            "\41\137\1\136\1\137\4\136\3\137\2\136\1\137\1\136\1\137\1\136"+
            "\12\137\1\136\1\137\5\136\33\137\1\136\1\137\1\136\1\137\1\136"+
            "\33\137\1\136\1\137\1\136\uff81\137",
            "",
            "",
            "",
            "",
            "\1\167",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\171",
            "\1\172",
            "\1\173",
            "",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\176",
            "\1\177",
            "",
            "\1\u0080",
            "",
            "",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\u0083",
            "",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\u0087",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "\1\u008a",
            "",
            "",
            "",
            "\1\u008b",
            "",
            "",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "\1\51\13\uffff\1\51\1\uffff\13\51\5\uffff\1\51\1\uffff\32\51"+
            "\4\uffff\1\51\1\uffff\32\51",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | RULE_USCORE | RULE_SLASH | RULE_BS | RULE_DOT | RULE_S | RULE_LESS | RULE_GREATER | RULE_SYM_WO_USCORE_WO_SLASH_WO_BS_WO_DOT_WO_LESS_WO_GREATER | RULE_MIXID | RULE_CONS_WO_S | RULE_ID_WO_CONS | RULE_STRING | RULE_DUALS | RULE_BINS | RULE_POSINT_WO_DUALS | RULE_HEXINT | RULE_NEGINT | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_94 = input.LA(1);

                        s = -1;
                        if ( (LA14_94=='!'||(LA14_94>='#' && LA14_94<='&')||(LA14_94>='*' && LA14_94<='+')||LA14_94=='-'||LA14_94=='/'||LA14_94==':'||(LA14_94>='<' && LA14_94<='@')||LA14_94=='\\'||LA14_94=='^'||LA14_94=='`'||LA14_94=='|'||LA14_94=='~') ) {s = 94;}

                        else if ( ((LA14_94>='\u0000' && LA14_94<=' ')||LA14_94=='\"'||(LA14_94>='\'' && LA14_94<=')')||LA14_94==','||LA14_94=='.'||(LA14_94>='0' && LA14_94<='9')||LA14_94==';'||(LA14_94>='A' && LA14_94<='[')||LA14_94==']'||LA14_94=='_'||(LA14_94>='a' && LA14_94<='{')||LA14_94=='}'||(LA14_94>='\u007F' && LA14_94<='\uFFFF')) ) {s = 95;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_39 = input.LA(1);

                        s = -1;
                        if ( (LA14_39=='!'||(LA14_39>='#' && LA14_39<='&')||(LA14_39>='*' && LA14_39<='+')||LA14_39=='-'||LA14_39=='/'||LA14_39==':'||(LA14_39>='<' && LA14_39<='@')||LA14_39=='\\'||LA14_39=='^'||LA14_39=='`'||LA14_39=='|'||LA14_39=='~') ) {s = 94;}

                        else if ( ((LA14_39>='\u0000' && LA14_39<=' ')||LA14_39=='\"'||(LA14_39>='\'' && LA14_39<=')')||LA14_39==','||LA14_39=='.'||(LA14_39>='0' && LA14_39<='9')||LA14_39==';'||(LA14_39>='A' && LA14_39<='[')||LA14_39==']'||LA14_39=='_'||(LA14_39>='a' && LA14_39<='{')||LA14_39=='}'||(LA14_39>='\u007F' && LA14_39<='\uFFFF')) ) {s = 95;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}