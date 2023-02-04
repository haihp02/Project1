package parser;

enum TokenType {
    TK_NONE, TK_IDENT, TK_NUMBER, TK_CHAR, TK_EOF,

    KW_PROGRAM, KW_CONST, KW_TYPE, KW_VAR,
    KW_INTEGER, KW_CHAR, KW_ARRAY, KW_OF, 
    KW_FUNCTION, KW_PROCEDURE,
    KW_BEGIN, KW_END, KW_CALL,
    KW_IF, KW_THEN, KW_ELSE,
    KW_WHILE, KW_DO, KW_FOR, KW_TO,

    SB_SEMICOLON, SB_COLON, SB_PERIOD, SB_COMMA,
    SB_ASSIGN, SB_EQ, SB_NEQ, SB_LT, SB_LE, SB_GT, SB_GE,
    SB_PLUS, SB_MINUS, SB_TIMES, SB_SLASH,
    SB_LPAR, SB_RPAR, SB_LSEL, SB_RSEL
}

class KeyWord {
    
    StringBuilder string;
    TokenType tokenType;

    public KeyWord(String string, TokenType tokenType) {
        this.string = new StringBuilder(string);
        this.string.setLength(Token.MAX_IDENT_LEN+1);
        this. tokenType = tokenType;
    }
}

public class Token {

    public static final int MAX_IDENT_LEN = 15;
    public static final int KEYWORDS_COUNT = 20;

    private StringBuilder string;
    private int lineNo, colNo;
    private TokenType tokenType;
    private int value;

    public static final KeyWord keywords[] = {
        new KeyWord("PROGRAM", TokenType.KW_PROGRAM),
        new KeyWord("CONST", TokenType.KW_CONST),
        new KeyWord("TYPE", TokenType.KW_TYPE),
        new KeyWord("VAR", TokenType.KW_VAR),
        new KeyWord("INTEGER", TokenType.KW_INTEGER),
        new KeyWord("CHAR", TokenType.KW_CHAR),
        new KeyWord("ARRAY", TokenType.KW_ARRAY),
        new KeyWord("OF", TokenType.KW_OF),
        new KeyWord("FUNCTION", TokenType.KW_FUNCTION),
        new KeyWord("PROCEDURE", TokenType.KW_PROCEDURE),
        new KeyWord("BEGIN", TokenType.KW_BEGIN),
        new KeyWord("END", TokenType.KW_END),
        new KeyWord("CALL", TokenType.KW_CALL),
        new KeyWord("IF", TokenType.KW_IF),
        new KeyWord("THEN", TokenType.KW_THEN),
        new KeyWord("ELSE", TokenType.KW_ELSE),
        new KeyWord("WHILE", TokenType.KW_WHILE),
        new KeyWord("DO", TokenType.KW_DO),
        new KeyWord("FOR", TokenType.KW_FOR),
        new KeyWord("TO", TokenType.KW_TO)
    };

    public static boolean keywordEq(String kw, String string) {
        return kw.equals(string.toUpperCase());
    }

    public static TokenType checkKeyword(StringBuilder tokenString) {
        for(KeyWord kw : keywords) {
            if(keywordEq(kw.string.toString(), tokenString.toString())) return kw.tokenType;
        }
        return TokenType.TK_NONE;
    }

    public Token(TokenType tokenType, int lineNo, int colNo) {
        this.tokenType = tokenType;
        this.lineNo = lineNo;
        this.colNo = colNo;
        this.string = new StringBuilder();
        this.string.setLength(MAX_IDENT_LEN+1);
    }

    public static String tokenToString(TokenType tokenType) {
        switch (tokenType) {
            case TK_NONE: return "None";
            case TK_IDENT: return "an identification";
            case TK_NUMBER: return "a number";
            case TK_CHAR: return "a constant char";
            case TK_EOF: return "end of file";
        
            case KW_PROGRAM: return "keyword PROGRAM";
            case KW_CONST: return "keyword CONST";
            case KW_TYPE: return "keyword TYPE";
            case KW_VAR: return "keyword VAR";
            case KW_INTEGER: return "keyword INTEGER";
            case KW_CHAR: return "keyword CHAR";
            case KW_ARRAY: return "keyword ARRAY";
            case KW_OF: return "keyword OF";
            case KW_FUNCTION: return "keyword FUNCTION";
            case KW_PROCEDURE: return "keyword PROCEDURE";
            case KW_BEGIN: return "keyword BEGIN";
            case KW_END: return "keyword END";
            case KW_CALL: return "keyword CALL";
            case KW_IF: return "keyword IF";
            case KW_THEN: return "keyword THEN";
            case KW_ELSE: return "keyword ELSE";
            case KW_WHILE: return "keyword WHILE";
            case KW_DO: return "keyword DO";
            case KW_FOR: return "keyword FOR";
            case KW_TO: return "keyword TO";
        
            case SB_SEMICOLON: return "\';\'";
            case SB_COLON: return "\':\'";
            case SB_PERIOD: return "\'.\'";
            case SB_COMMA: return "\',\'";
            case SB_ASSIGN: return "\':=\'";
            case SB_EQ: return "\'=\'";
            case SB_NEQ: return "\'!=\'";
            case SB_LT: return "\'<\'";
            case SB_LE: return "\'<=\'";
            case SB_GT: return "\'>\'";
            case SB_GE: return "\'>=\'";
            case SB_PLUS: return "\'+\'";
            case SB_MINUS: return "\'-\'";
            case SB_TIMES: return "\'*\'";
            case SB_SLASH: return "\'/\'";
            case SB_LPAR: return "\'(\'";
            case SB_RPAR: return "\')\'";
            case SB_LSEL: return "\'(.\'";
            case SB_RSEL: return "\'.)\'";
            default: return "";
        }
    }


    // Getter setter
    public StringBuilder getString() {
        return string;
    }

    public void setString(StringBuilder string) {
        this.string = string;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public int getColNo() {
        return colNo;
    }

    public void setColNo(int colNo) {
        this.colNo = colNo;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

