package parser;

public class Parser {

    private Reader reader;
    private Scanner scanner;
    private Error err;

    private Token currentToken;
    private Token lookAhead;


    // Process
    public void scan() {
        currentToken = lookAhead;
        lookAhead = scanner.getValidToken();
    }

    public void eat(TokenType tokenType) {
        if(lookAhead.getTokenType() == tokenType) {
//            scanner.printToken(lookAhead);
            scan();
        } else err.missingToken(tokenType, lookAhead.getLineNo(), lookAhead.getColNo());
    }

    public void compileArguments() {
        switch (lookAhead.getTokenType()) {
            case SB_LPAR:
                eat(TokenType.SB_LPAR);
                compileExpression();
                compileArguments2();
                eat(TokenType.SB_RPAR);
                break;
                // Check FOLLOW set 
            case SB_TIMES:
            case SB_SLASH:
            case SB_PLUS:
            case SB_MINUS:
            case SB_RPAR:
            case SB_COMMA:
            case SB_RSEL:
            case SB_SEMICOLON:
                break;
            default:
                err.error(ErrorCode.ERR_INVALIDARGUMENTS, lookAhead.getLineNo(), lookAhead.getColNo());
        }
    }

    public void compileArguments2() {
        switch (lookAhead.getTokenType()) {
        case SB_COMMA:
            eat(TokenType.SB_COMMA);
            compileExpression();
            compileArguments2();
            break;
            // check the FOLLOW set
        case SB_RPAR:
            break;
        default:
            err.error(ErrorCode.ERR_INVALIDARGUMENTS, lookAhead.getLineNo(), lookAhead.getColNo());
        }
    }

    public void compileExpression() {
//        err.printAssert("Parsing an expression");
        switch(lookAhead.getTokenType()) {
            case SB_PLUS:
                eat(TokenType.SB_PLUS);
                compileExpression2();
                break;
            case SB_MINUS:
                eat(TokenType.SB_MINUS);
                compileExpression2();
                break;
            default:
                compileExpression2();
        }
    }

    public void compileExpression2() {
        compileTerm();
        compileExpression3();
    }
    
    public void compileExpression3() {
        switch (lookAhead.getTokenType()) {
            case SB_PLUS:
                eat(TokenType.SB_PLUS);
                compileTerm();
                compileExpression3();
                break;
            case SB_MINUS:
                eat(TokenType.SB_MINUS);
                compileTerm();
                compileExpression3();
                break;
              // check the FOLLOW set
            case SB_RPAR:
            case SB_COMMA:
            case SB_RSEL:
            case SB_SEMICOLON:
                break;
            default:
                err.error(ErrorCode.ERR_INVALIDEXPRESSION, lookAhead.getLineNo(), lookAhead.getColNo());
        }
    }

    public void compileTerm() {
        compileFactor();
        compileTerm2();
    }

    public void compileTerm2() {
        switch (lookAhead.getTokenType()) {
            case SB_TIMES:
                eat(TokenType.SB_TIMES);
                compileFactor();
                compileTerm2();
                break;
            case SB_SLASH:
                eat(TokenType.SB_SLASH);
                compileFactor();
                compileTerm2();
                break;
              // check the FOLLOW set
            case SB_PLUS:
            case SB_MINUS:
            case SB_RPAR:
            case SB_COMMA:
            case SB_RSEL:
            case SB_SEMICOLON:
                break;
            default:
                err.error(ErrorCode.ERR_INVALIDTERM, lookAhead.getLineNo(), lookAhead.getColNo());
        }
    }

    public void compileFactor() {
        switch (lookAhead.getTokenType()) {
            case TK_NUMBER:
                eat(TokenType.TK_NUMBER);
                break;
            case TK_CHAR:
                eat(TokenType.TK_CHAR);
                break;
            case TK_IDENT:
                eat(TokenType.TK_IDENT);
                switch (lookAhead.getTokenType()) {
                    case SB_LSEL:
                        compileIndexes();
                        break;
                    case SB_LPAR:
                        compileArguments();
                        break;
                    default: break;
                }
                break;
            case SB_LPAR:
                eat(TokenType.SB_LPAR);
                compileExpression();
                eat(TokenType.SB_RPAR);
                break;
            default:
                err.error(ErrorCode.ERR_INVALIDFACTOR, lookAhead.getLineNo(), lookAhead.getColNo());
        }
    }

    public void compileIndexes() {
        while (lookAhead.getTokenType() == TokenType.SB_LSEL) {
            eat(TokenType.SB_LSEL);
            compileExpression();
            eat(TokenType.SB_RSEL);
        }
    }

    int compile(String string) {
        if (reader.openInputStream(string) == Reader.IO_ERROR)
            return Reader.IO_ERROR;
      
        currentToken = null;
        lookAhead = scanner.getValidToken();
      
        compileExpression();

        return Reader.IO_SUCCESS;
    }


    
    // Getter setter
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Error getError() {
        return err;
    }

    public void setError(Error err) {
        this.err = err;
    }

    public Token getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(Token currentToken) {
        this.currentToken = currentToken;
    }

    public Token getLookAhead() {
        return lookAhead;
    }

    public void setLookAhead(Token lookAhead) {
        this.lookAhead = lookAhead;
    }
}

