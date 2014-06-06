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
    public static final int RULE_DIG=5;
    public static final int RULE_ID=4;
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
    public static final int RULE_HEXDIGIT=8;
    public static final int RULE_SYM=7;
    public static final int RULE_ESC=13;
    public static final int RULE_SL_COMMENT=18;
    public static final int EOF=-1;
    public static final int RULE_CONSTART=9;
    public static final int RULE_LETTER=15;
    public static final int RULE_ML_COMMENT=17;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int RULE_IDCHAR=10;
    public static final int T__38=38;
    public static final int RULE_BINARY=6;
    public static final int RULE_WS=16;

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

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:11:7: ( 'exptodo' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:11:9: 'exptodo'
            {
            match("exptodo"); 


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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:12:7: ( ';' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:12:9: ';'
            {
            match(';'); 

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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:13:7: ( '=' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:13:9: '='
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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:14:7: ( 'type' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:14:9: 'type'
            {
            match("type"); 


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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:15:7: ( '[' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:15:9: '['
            {
            match('['); 

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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:16:7: ( ']' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:16:9: ']'
            {
            match(']'); 

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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:17:7: ( ',' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:17:9: ','
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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:18:7: ( 'val' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:18:9: 'val'
            {
            match("val"); 


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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:19:7: ( '|' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:19:9: '|'
            {
            match('|'); 

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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:20:7: ( '{' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:20:9: '{'
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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:21:7: ( '}' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:21:9: '}'
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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:22:7: ( 'of' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:22:9: 'of'
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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:23:7: ( ':' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:23:9: ':'
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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:24:7: ( '\\'' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:24:9: '\\''
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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:25:7: ( '@' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:25:9: '@'
            {
            match('@'); 

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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:26:7: ( '+' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:26:9: '+'
            {
            match('+'); 

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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:27:7: ( '~' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:27:9: '~'
            {
            match('~'); 

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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:28:7: ( '0x' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:28:9: '0x'
            {
            match("0x"); 


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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:29:7: ( 'granularity' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:29:9: 'granularity'
            {
            match("granularity"); 


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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:30:7: ( 'export' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:30:9: 'export'
            {
            match("export"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "RULE_BITSTRIDCHAR"
    public final void mRULE_BITSTRIDCHAR() throws RecognitionException {
        try {
            int _type = RULE_BITSTRIDCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5006:19: ( 'bistridchar' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5006:21: 'bistridchar'
            {
            match("bistridchar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BITSTRIDCHAR"

    // $ANTLR start "RULE_BITSTRID"
    public final void mRULE_BITSTRID() throws RecognitionException {
        try {
            int _type = RULE_BITSTRID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5008:15: ( 'bitstrid' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5008:17: 'bitstrid'
            {
            match("bitstrid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BITSTRID"

    // $ANTLR start "RULE_ESC"
    public final void mRULE_ESC() throws RecognitionException {
        try {
            int _type = RULE_ESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5010:10: ( 'esc' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5010:12: 'esc'
            {
            match("esc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ESC"

    // $ANTLR start "RULE_SGOOD"
    public final void mRULE_SGOOD() throws RecognitionException {
        try {
            int _type = RULE_SGOOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5012:12: ( 'sgoodtodo' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5012:14: 'sgoodtodo'
            {
            match("sgoodtodo"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SGOOD"

    // $ANTLR start "RULE_SYM"
    public final void mRULE_SYM() throws RecognitionException {
        try {
            int _type = RULE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5014:10: ( ( '-' | '!' | '%' | '&' | '$' | '+' | '/' | ':' | '<' | '=' | '>' | '?' | '@' | '~' | '`' | '\\\\' | '^' | '|' | '#' | '*' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5014:12: ( '-' | '!' | '%' | '&' | '$' | '+' | '/' | ':' | '<' | '=' | '>' | '?' | '@' | '~' | '`' | '\\\\' | '^' | '|' | '#' | '*' )
            {
            if ( input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||input.LA(1)=='/'||input.LA(1)==':'||(input.LA(1)>='<' && input.LA(1)<='@')||input.LA(1)=='\\'||input.LA(1)=='^'||input.LA(1)=='`'||input.LA(1)=='|'||input.LA(1)=='~' ) {
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
    // $ANTLR end "RULE_SYM"

    // $ANTLR start "RULE_BINARY"
    public final void mRULE_BINARY() throws RecognitionException {
        try {
            int _type = RULE_BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5016:13: ( ( '0' | '1' | '\\\\' | '.' | '|' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5016:15: ( '0' | '1' | '\\\\' | '.' | '|' )
            {
            if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='1')||input.LA(1)=='\\'||input.LA(1)=='|' ) {
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
    // $ANTLR end "RULE_BINARY"

    // $ANTLR start "RULE_DIG"
    public final void mRULE_DIG() throws RecognitionException {
        try {
            int _type = RULE_DIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5018:10: ( '0' .. '9' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5018:12: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIG"

    // $ANTLR start "RULE_HEXDIGIT"
    public final void mRULE_HEXDIGIT() throws RecognitionException {
        try {
            int _type = RULE_HEXDIGIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5020:15: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5020:17: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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
    // $ANTLR end "RULE_HEXDIGIT"

    // $ANTLR start "RULE_CONSTART"
    public final void mRULE_CONSTART() throws RecognitionException {
        try {
            int _type = RULE_CONSTART;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5022:15: ( 'A' .. 'Z' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5022:17: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CONSTART"

    // $ANTLR start "RULE_LETTER"
    public final void mRULE_LETTER() throws RecognitionException {
        try {
            int _type = RULE_LETTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5024:13: ( ( 'a' .. 'z' | 'A' .. 'Z' | '\\\\' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5024:15: ( 'a' .. 'z' | 'A' .. 'Z' | '\\\\' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='\\'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
    // $ANTLR end "RULE_LETTER"

    // $ANTLR start "RULE_IDCHAR"
    public final void mRULE_IDCHAR() throws RecognitionException {
        try {
            int _type = RULE_IDCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5026:13: ( ( RULE_LETTER | RULE_DIG | '_' | '-' | '?' | '\\'' | '!' ) )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5026:15: ( RULE_LETTER | RULE_DIG | '_' | '-' | '?' | '\\'' | '!' )
            {
            if ( input.LA(1)=='!'||input.LA(1)=='\''||input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='\\'||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
    // $ANTLR end "RULE_IDCHAR"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5028:9: ( RULE_LETTER ( RULE_IDCHAR )* )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5028:11: RULE_LETTER ( RULE_IDCHAR )*
            {
            mRULE_LETTER(); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5028:23: ( RULE_IDCHAR )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='!'||LA1_0=='\''||LA1_0=='-'||(LA1_0>='0' && LA1_0<='9')||LA1_0=='?'||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='\\'||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5028:23: RULE_IDCHAR
            	    {
            	    mRULE_IDCHAR(); 

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
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5030:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5030:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5030:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\t' && LA2_0<='\n')||LA2_0=='\r'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5032:17: ( '(*' ( options {greedy=false; } : . )* '*)' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5032:19: '(*' ( options {greedy=false; } : . )* '*)'
            {
            match("(*"); 

            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5032:24: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==')') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='(')||(LA3_1>='*' && LA3_1<='\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<=')')||(LA3_0>='+' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5032:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
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
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5034:17: ( '#' (~ ( '\\n' ) )* '\\n' )
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5034:19: '#' (~ ( '\\n' ) )* '\\n'
            {
            match('#'); 
            // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5034:23: (~ ( '\\n' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:5034:23: ~ ( '\\n' )
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
            	    break loop4;
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
        // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | RULE_BITSTRIDCHAR | RULE_BITSTRID | RULE_ESC | RULE_SGOOD | RULE_SYM | RULE_BINARY | RULE_DIG | RULE_HEXDIGIT | RULE_CONSTART | RULE_LETTER | RULE_IDCHAR | RULE_ID | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT )
        int alt5=35;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:10: T__19
                {
                mT__19(); 

                }
                break;
            case 2 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:16: T__20
                {
                mT__20(); 

                }
                break;
            case 3 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:22: T__21
                {
                mT__21(); 

                }
                break;
            case 4 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:28: T__22
                {
                mT__22(); 

                }
                break;
            case 5 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:34: T__23
                {
                mT__23(); 

                }
                break;
            case 6 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:40: T__24
                {
                mT__24(); 

                }
                break;
            case 7 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:46: T__25
                {
                mT__25(); 

                }
                break;
            case 8 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:52: T__26
                {
                mT__26(); 

                }
                break;
            case 9 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:58: T__27
                {
                mT__27(); 

                }
                break;
            case 10 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:64: T__28
                {
                mT__28(); 

                }
                break;
            case 11 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:70: T__29
                {
                mT__29(); 

                }
                break;
            case 12 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:76: T__30
                {
                mT__30(); 

                }
                break;
            case 13 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:82: T__31
                {
                mT__31(); 

                }
                break;
            case 14 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:88: T__32
                {
                mT__32(); 

                }
                break;
            case 15 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:94: T__33
                {
                mT__33(); 

                }
                break;
            case 16 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:100: T__34
                {
                mT__34(); 

                }
                break;
            case 17 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:106: T__35
                {
                mT__35(); 

                }
                break;
            case 18 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:112: T__36
                {
                mT__36(); 

                }
                break;
            case 19 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:118: T__37
                {
                mT__37(); 

                }
                break;
            case 20 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:124: T__38
                {
                mT__38(); 

                }
                break;
            case 21 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:130: RULE_BITSTRIDCHAR
                {
                mRULE_BITSTRIDCHAR(); 

                }
                break;
            case 22 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:148: RULE_BITSTRID
                {
                mRULE_BITSTRID(); 

                }
                break;
            case 23 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:162: RULE_ESC
                {
                mRULE_ESC(); 

                }
                break;
            case 24 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:171: RULE_SGOOD
                {
                mRULE_SGOOD(); 

                }
                break;
            case 25 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:182: RULE_SYM
                {
                mRULE_SYM(); 

                }
                break;
            case 26 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:191: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 27 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:203: RULE_DIG
                {
                mRULE_DIG(); 

                }
                break;
            case 28 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:212: RULE_HEXDIGIT
                {
                mRULE_HEXDIGIT(); 

                }
                break;
            case 29 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:226: RULE_CONSTART
                {
                mRULE_CONSTART(); 

                }
                break;
            case 30 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:240: RULE_LETTER
                {
                mRULE_LETTER(); 

                }
                break;
            case 31 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:252: RULE_IDCHAR
                {
                mRULE_IDCHAR(); 

                }
                break;
            case 32 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:264: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 33 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:272: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 34 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:280: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 35 :
                // ../gdsl.plugin.ui/src-gen/gdsl/plugin/ui/contentassist/antlr/internal/InternalGDSL.g:1:296: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\1\46\2\uffff\1\52\3\uffff\1\52\3\uffff\1\52\5\uffff\1\31"+
        "\1\52\1\46\1\52\1\43\4\uffff\2\46\1\70\1\52\1\43\4\uffff\2\47\3"+
        "\uffff\1\47\1\uffff\1\47\1\uffff\1\76\6\uffff\3\47\3\uffff\1\47"+
        "\1\105\1\47\1\107\1\uffff\6\47\1\uffff\1\116\1\uffff\6\47\1\uffff"+
        "\5\47\1\132\4\47\1\137\1\uffff\4\47\1\uffff\2\47\1\146\3\47\1\uffff"+
        "\1\152\2\47\1\uffff\1\155\1\156\2\uffff";
    static final String DFA5_eofS =
        "\157\uffff";
    static final String DFA5_minS =
        "\1\11\1\41\2\uffff\1\41\3\uffff\1\41\3\uffff\1\41\5\uffff\1\170"+
        "\4\41\4\uffff\4\41\1\0\4\uffff\1\160\1\143\3\uffff\1\160\1\uffff"+
        "\1\154\1\uffff\1\41\6\uffff\1\141\1\163\1\157\3\uffff\1\157\1\41"+
        "\1\145\1\41\1\uffff\1\156\1\164\1\163\2\157\1\162\1\uffff\1\41\1"+
        "\uffff\1\165\1\162\1\164\2\144\1\164\1\uffff\1\154\1\151\1\162\1"+
        "\164\1\157\1\41\1\141\1\144\1\151\1\157\1\41\1\uffff\1\162\1\143"+
        "\2\144\1\uffff\1\151\1\150\1\41\1\157\1\164\1\141\1\uffff\1\41\1"+
        "\171\1\162\1\uffff\2\41\2\uffff";
    static final String DFA5_maxS =
        "\1\176\1\172\2\uffff\1\172\3\uffff\1\172\3\uffff\1\172\5\uffff\1"+
        "\170\4\172\4\uffff\4\172\1\uffff\4\uffff\1\160\1\143\3\uffff\1\160"+
        "\1\uffff\1\154\1\uffff\1\172\6\uffff\1\141\1\164\1\157\3\uffff\1"+
        "\164\1\172\1\145\1\172\1\uffff\1\156\1\164\1\163\2\157\1\162\1\uffff"+
        "\1\172\1\uffff\1\165\1\162\1\164\2\144\1\164\1\uffff\1\154\1\151"+
        "\1\162\1\164\1\157\1\172\1\141\1\144\1\151\1\157\1\172\1\uffff\1"+
        "\162\1\143\2\144\1\uffff\1\151\1\150\1\172\1\157\1\164\1\141\1\uffff"+
        "\1\172\1\171\1\162\1\uffff\2\172\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\3\1\uffff\1\5\1\6\1\7\1\uffff\1\11\1\12\1\13\1\uffff"+
        "\1\15\1\16\1\17\1\20\1\21\5\uffff\1\31\2\32\1\33\5\uffff\1\37\1"+
        "\41\1\42\1\31\2\uffff\1\34\1\40\1\3\1\uffff\1\36\1\uffff\1\11\1"+
        "\uffff\1\15\1\16\1\17\1\20\1\21\1\22\3\uffff\1\33\1\35\1\43\4\uffff"+
        "\1\14\6\uffff\1\27\1\uffff\1\10\6\uffff\1\4\13\uffff\1\24\4\uffff"+
        "\1\1\6\uffff\1\26\3\uffff\1\30\2\uffff\1\23\1\25";
    static final String DFA5_specialS =
        "\37\uffff\1\0\117\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\41\2\uffff\1\41\22\uffff\1\41\1\27\1\uffff\1\37\3\43\1\16"+
            "\1\42\1\uffff\1\43\1\20\1\7\1\27\1\31\1\43\1\22\1\30\10\32\1"+
            "\15\1\2\1\43\1\3\1\43\1\27\1\17\6\33\24\35\1\5\1\26\1\6\1\43"+
            "\1\40\1\43\1\34\1\24\2\34\1\1\1\34\1\23\7\36\1\14\3\36\1\25"+
            "\1\4\1\36\1\10\4\36\1\12\1\11\1\13\1\21",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\22\47\1\45"+
            "\4\47\1\44\2\47",
            "",
            "",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\30\47\1\51"+
            "\1\47",
            "",
            "",
            "",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\1\53\31\47",
            "",
            "",
            "",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\5\47\1\55\24"+
            "\47",
            "",
            "",
            "",
            "",
            "",
            "\1\63",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\21\47\1\64"+
            "\10\47",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\10\47\1\65"+
            "\21\47",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\6\47\1\66\23"+
            "\47",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "",
            "",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "\0\71",
            "",
            "",
            "",
            "",
            "\1\72",
            "\1\73",
            "",
            "",
            "",
            "\1\74",
            "",
            "\1\75",
            "",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\77",
            "\1\100\1\101",
            "\1\102",
            "",
            "",
            "",
            "\1\104\4\uffff\1\103",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "\1\106",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "",
            "\1\144",
            "\1\145",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "\1\147",
            "\1\150",
            "\1\151",
            "",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "\1\153",
            "\1\154",
            "",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "\1\47\5\uffff\1\47\5\uffff\1\47\2\uffff\12\47\5\uffff\1\47"+
            "\1\uffff\32\47\1\uffff\1\47\2\uffff\1\47\1\uffff\32\47",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | RULE_BITSTRIDCHAR | RULE_BITSTRID | RULE_ESC | RULE_SGOOD | RULE_SYM | RULE_BINARY | RULE_DIG | RULE_HEXDIGIT | RULE_CONSTART | RULE_LETTER | RULE_IDCHAR | RULE_ID | RULE_WS | RULE_ML_COMMENT | RULE_SL_COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_31 = input.LA(1);

                        s = -1;
                        if ( ((LA5_31>='\u0000' && LA5_31<='\uFFFF')) ) {s = 57;}

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}