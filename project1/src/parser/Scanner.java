package parser;

public class Scanner {

    private Reader reader;
    private Error err;
    private CharCodeClass charcode;


    public void skipBlank() {
        while ((reader.getCurrentChar() != -1) && (CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_SPACE))
            reader.readChar();
    }

    public void skipComment() {
        int state = 0;
        while ((reader.getCurrentChar() != -1) && (state < 2)) {
            switch (CharCodeClass.charCodes[reader.getCurrentChar()]) {
                case CHAR_TIMES:
                    state = 1;
                    break;
                case CHAR_RPAR:
                    if (state == 1) state = 2;
                    else state = 0;
                    break;
                default:
                    state = 0;
            }
            reader.readChar();
        }
        if (state != 2) 
            err.error(ErrorCode.ERR_ENDOFCOMMENT, reader.getLineNo(), reader.getColNo());
    }

    public Token readIdentKeyword() {
        Token token = new Token(TokenType.TK_NONE, reader.getLineNo(), reader.getColNo());
        int count = 1;

        token.getString().setCharAt(0, (char)reader.getCurrentChar());
        reader.readChar();

        while ((reader.getCurrentChar() != -1) && 
            ((CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_LETTER) || (CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_DIGIT))) {
            if (count <= Token.MAX_IDENT_LEN) 
                token.getString().setCharAt(count++, (char)reader.getCurrentChar());
            reader.readChar();
        }

        if (count > Token.MAX_IDENT_LEN) {
            err.error(ErrorCode.ERR_IDENTTOOLONG, token.getLineNo(), token.getColNo());
            return token;
        }

        token.getString().setCharAt(count, '\0');
        token.setTokenType(Token.checkKeyword(token.getString()));

        if (token.getTokenType() == TokenType.TK_NONE)
        token.setTokenType(TokenType.TK_IDENT);

        return token;
    }

    public Token readNumber() {
        Token token = new Token(TokenType.TK_NUMBER, reader.getLineNo(), reader.getColNo());
        int count = 0;
      
        while ((reader.getCurrentChar() != -1) && (CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_DIGIT)) {
            token.getString().setCharAt(count++, (char)reader.getCurrentChar());
            reader.readChar();
        }
        
        token.getString().setCharAt(count, '\0');
        token.setValue(Integer.parseInt(token.getString().toString().trim()));
        return token;
    }

    public Token readConstChar() {
        Token token = new Token(TokenType.TK_CHAR, reader.getLineNo(), reader.getColNo());
      
        reader.readChar();
        if (reader.getCurrentChar() == -1) {
          token.setTokenType(TokenType.TK_NONE);
          err.error(ErrorCode.ERR_INVALIDCHARCONSTANT, token.getLineNo(), token.getColNo());
          return token;
        }

        token.getString().setCharAt(0, (char)reader.getCurrentChar());
        token.getString().setCharAt(1, '\0');

      
        reader.readChar();
        if (reader.getCurrentChar() == -1) {
          token.setTokenType(TokenType.TK_NONE);
          err.error(ErrorCode.ERR_INVALIDCHARCONSTANT, token.getLineNo(), token.getColNo());
          return token;
        }
      
        if (CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_SINGLEQUOTE) {
            reader.readChar();
            return token;
        } else {
            token.setTokenType(TokenType.TK_NONE);
            err.error(ErrorCode.ERR_INVALIDCHARCONSTANT, token.getLineNo(), token.getColNo());
            return token;
        }
    }

    public Token getToken() {
        Token token;
        int ln, cn;
      
        if (reader.getCurrentChar() == -1) 
            return new Token(TokenType.TK_EOF, reader.getLineNo(), reader.getColNo());

        switch (CharCodeClass.charCodes[reader.getCurrentChar()]) {
            case CHAR_SPACE: skipBlank(); return getToken();
            case CHAR_LETTER: return readIdentKeyword();
            case CHAR_DIGIT: return readNumber();
            case CHAR_PLUS: 
                token = new Token(TokenType.SB_PLUS, reader.getLineNo(), reader.getColNo());
                reader.readChar(); 
                return token;
            case CHAR_MINUS:
                token = new Token(TokenType.SB_MINUS, reader.getLineNo(), reader.getColNo());
                reader.readChar(); 
                return token;
            case CHAR_TIMES:
                token = new Token(TokenType.SB_TIMES, reader.getLineNo(), reader.getColNo());
                reader.readChar(); 
                return token;
            case CHAR_SLASH:
                token = new Token(TokenType.SB_SLASH, reader.getLineNo(), reader.getColNo());
                reader.readChar(); 
                return token;
            case CHAR_LT:
                ln = reader.getLineNo();
                cn = reader.getColNo();
                reader.readChar();
                if ((reader.getCurrentChar() != -1) && (CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_EQ)) {
                    reader.readChar();
                    return new Token(TokenType.SB_LE, ln, cn);
                } else return new Token(TokenType.SB_LT, ln, cn);
            case CHAR_GT:
                ln = reader.getLineNo();
                cn = reader.getColNo();
                reader.readChar();
                if ((reader.getCurrentChar() != -1) && (CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_EQ)) {
                    reader.readChar();
                    return new Token(TokenType.SB_GE, ln, cn);
                } else return new Token(TokenType.SB_GT, ln, cn);
            case CHAR_EQ: 
                token = new Token(TokenType.SB_EQ, reader.getLineNo(), reader.getColNo());
                reader.readChar(); 
                return token;
            case CHAR_EXCLAIMATION:
                ln = reader.getLineNo();
                cn = reader.getColNo();
                reader.readChar();
                if ((reader.getCurrentChar() != -1) && (CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_EQ)) {
                    reader.readChar();
                    return new Token(TokenType.SB_NEQ, ln, cn);
                } else {
                    token = new Token(TokenType.TK_NONE, ln, cn);
                    err.error(ErrorCode.ERR_INVALIDSYMBOL, ln, cn);
                    return token;
                }
            case CHAR_COMMA:
                token = new Token(TokenType.SB_COMMA, reader.getLineNo(), reader.getColNo());
                reader.readChar(); 
                return token;
            case CHAR_PERIOD:
                ln = reader.getLineNo();
                cn = reader.getColNo();
                reader.readChar();
                if ((reader.getCurrentChar() != -1) && (CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_RPAR)) {
                    reader.readChar();
                    return new Token(TokenType.SB_RSEL, ln, cn);
                } else return new Token(TokenType.SB_PERIOD, ln, cn);
            case CHAR_SEMICOLON:
                token = new Token(TokenType.SB_SEMICOLON, reader.getLineNo(), reader.getColNo());
                reader.readChar(); 
                return token;
            case CHAR_COLON:
                ln = reader.getLineNo();
                cn = reader.getColNo();
                reader.readChar();
                if ((reader.getCurrentChar() != -1) && (CharCodeClass.charCodes[reader.getCurrentChar()] == CharCode.CHAR_EQ)) {
                    reader.readChar();
                    return new Token(TokenType.SB_ASSIGN, ln, cn);
                } else return new Token(TokenType.SB_COLON, ln, cn);
            case CHAR_SINGLEQUOTE: return readConstChar();
            case CHAR_LPAR:
                ln = reader.getLineNo();
                cn = reader.getColNo();
                reader.readChar();
        
                if (reader.getCurrentChar() == -1) 
                    return new Token(TokenType.SB_LPAR, ln, cn);
            
                switch (CharCodeClass.charCodes[reader.getCurrentChar()]) {
                    case CHAR_PERIOD:
                        reader.readChar();
                        return new Token(TokenType.SB_LSEL, ln, cn);
                    case CHAR_TIMES:
                        reader.readChar();
                        skipComment();
                        return getToken();
                    default:
                        return new Token(TokenType.SB_LPAR, ln, cn);
                    }
            case CHAR_RPAR:
                token = new Token(TokenType.SB_RPAR, reader.getLineNo(), reader.getColNo());
                reader.readChar(); 
                return token;
            default:
                token = new Token(TokenType.TK_NONE, reader.getLineNo(), reader.getColNo());
                err.error(ErrorCode.ERR_INVALIDSYMBOL, reader.getLineNo(), reader.getColNo());
                reader.readChar(); 
                return token;
        }
    }

    public Token getValidToken() {
        Token token = getToken();
        while (token.getTokenType() == TokenType.TK_NONE) 
            token = getToken();
        return token;
    }

    public void printToken(Token token) {
        System.out.println(token.getLineNo()-token.getColNo() + ":");

        switch (token.getTokenType()) {
            case TK_NONE: System.out.printf("TK_NONE\n"); break;
            case TK_IDENT: System.out.printf("TK_IDENT(%s)\n", token.getString()); break;
            case TK_NUMBER: System.out.printf("TK_NUMBER(%s)\n", token.getString()); break;
            case TK_CHAR: System.out.printf("TK_CHAR(\'%s\')\n", token.getString()); break;
            case TK_EOF: System.out.printf("TK_-1\n"); break;
          
            case KW_PROGRAM: System.out.printf("KW_PROGRAM\n"); break;
            case KW_CONST: System.out.printf("KW_CONST\n"); break;
            case KW_TYPE: System.out.printf("KW_TYPE\n"); break;
            case KW_VAR: System.out.printf("KW_VAR\n"); break;
            case KW_INTEGER: System.out.printf("KW_INTEGER\n"); break;
            case KW_CHAR: System.out.printf("KW_CHAR\n"); break;
            case KW_ARRAY: System.out.printf("KW_ARRAY\n"); break;
            case KW_OF: System.out.printf("KW_OF\n"); break;
            case KW_FUNCTION: System.out.printf("KW_FUNCTION\n"); break;
            case KW_PROCEDURE: System.out.printf("KW_PROCEDURE\n"); break;
            case KW_BEGIN: System.out.printf("KW_BEGIN\n"); break;
            case KW_END: System.out.printf("KW_END\n"); break;
            case KW_CALL: System.out.printf("KW_CALL\n"); break;
            case KW_IF: System.out.printf("KW_IF\n"); break;
            case KW_THEN: System.out.printf("KW_THEN\n"); break;
            case KW_ELSE: System.out.printf("KW_ELSE\n"); break;
            case KW_WHILE: System.out.printf("KW_WHILE\n"); break;
            case KW_DO: System.out.printf("KW_DO\n"); break;
            case KW_FOR: System.out.printf("KW_FOR\n"); break;
            case KW_TO: System.out.printf("KW_TO\n"); break;
          
            case SB_SEMICOLON: System.out.printf("SB_SEMICOLON\n"); break;
            case SB_COLON: System.out.printf("SB_COLON\n"); break;
            case SB_PERIOD: System.out.printf("SB_PERIOD\n"); break;
            case SB_COMMA: System.out.printf("SB_COMMA\n"); break;
            case SB_ASSIGN: System.out.printf("SB_ASSIGN\n"); break;
            case SB_EQ: System.out.printf("SB_EQ\n"); break;
            case SB_NEQ: System.out.printf("SB_NEQ\n"); break;
            case SB_LT: System.out.printf("SB_LT\n"); break;
            case SB_LE: System.out.printf("SB_LE\n"); break;
            case SB_GT: System.out.printf("SB_GT\n"); break;
            case SB_GE: System.out.printf("SB_GE\n"); break;
            case SB_PLUS: System.out.printf("SB_PLUS\n"); break;
            case SB_MINUS: System.out.printf("SB_MINUS\n"); break;
            case SB_TIMES: System.out.printf("SB_TIMES\n"); break;
            case SB_SLASH: System.out.printf("SB_SLASH\n"); break;
            case SB_LPAR: System.out.printf("SB_LPAR\n"); break;
            case SB_RPAR: System.out.printf("SB_RPAR\n"); break;
            case SB_LSEL: System.out.printf("SB_LSEL\n"); break;
            case SB_RSEL: System.out.printf("SB_RSEL\n"); break;
        }
    }


    // Getter setter
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Error getError() {
        return err;
    }

    public void setError(Error error) {
        this.err = error;
    }

    public CharCodeClass getCharcode() {
        return charcode;
    }

    public void setCharcode(CharCodeClass charcode) {
        this.charcode = charcode;
    }
}

