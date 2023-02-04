package parser;

enum ErrorCode {
    ERR_ENDOFCOMMENT,
    ERR_IDENTTOOLONG,
    ERR_INVALIDCHARCONSTANT,
    ERR_INVALIDSYMBOL,
    ERR_INVALIDCONSTANT,
    ERR_INVALIDTYPE,
    ERR_INVALIDBASICTYPE,
    ERR_INVALIDPARAM,
    ERR_INVALIDSTATEMENT,
    ERR_INVALIDARGUMENTS,
    ERR_INVALIDCOMPARATOR,
    ERR_INVALIDEXPRESSION,
    ERR_INVALIDTERM,
    ERR_INVALIDFACTOR
}

public class Error {

    public final String ERM_ENDOFCOMMENT = "End of comment expected!";
    public final String ERM_IDENTTOOLONG = "Identification too long!";
    public final String ERM_INVALIDCHARCONSTANT = "Invalid const char!";
    public final String ERM_INVALIDSYMBOL = "Invalid symbol!";
    public final String ERM_INVALIDCONSTANT = "Invalid constant!";
    public final String ERM_INVALIDTYPE = "Invalid type!";
    public final String ERM_INVALIDBASICTYPE = "Invalid basic type!";
    public final String ERM_INVALIDPARAM = "Invalid parameter!";
    public final String ERM_INVALIDSTATEMENT = "Invalid statement!";
    public final String ERM_INVALIDARGUMENTS = "Invalid arguments!";
    public final String ERM_INVALIDCOMPARATOR = "Invalid comparator!";
    public final String ERM_INVALIDEXPRESSION = "Invalid expression!";
    public final String ERM_INVALIDTERM = "Invalid term!";
    public final String ERM_INVALIDFACTOR = "Invalid factor!";

    private boolean passed = true;

    public void error(ErrorCode err, int lineNo, int colNo) {
        switch (err) {
        case ERR_ENDOFCOMMENT:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_ENDOFCOMMENT);
            break;
        case ERR_IDENTTOOLONG:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_IDENTTOOLONG);
            break;
        case ERR_INVALIDCHARCONSTANT:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDCHARCONSTANT);
            break;
        case ERR_INVALIDSYMBOL:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDSYMBOL);
            break;
        case ERR_INVALIDCONSTANT:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDCONSTANT);
            break;
        case ERR_INVALIDTYPE:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDTYPE);
            break;
        case ERR_INVALIDBASICTYPE:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDBASICTYPE);
            break;
        case ERR_INVALIDPARAM:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDPARAM);
            break;
        case ERR_INVALIDSTATEMENT:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDSTATEMENT);
            break;
        case ERR_INVALIDARGUMENTS:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDARGUMENTS);
            break;
        case ERR_INVALIDCOMPARATOR:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDCOMPARATOR);
            break;
        case ERR_INVALIDEXPRESSION:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDEXPRESSION);
            break;
        case ERR_INVALIDTERM:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDTERM);
            break;
        case ERR_INVALIDFACTOR:
            System.out.printf("%d-%d:%s\n", lineNo, colNo, ERM_INVALIDFACTOR);
            break;
        }
        passed = false;
    }
    
    public void missingToken(TokenType tokenType, int lineNo, int colNo) {
        System.out.printf("%d-%d:Missing %s\n", lineNo, colNo, Token.tokenToString(tokenType));
        passed = false;
    }
    
    public void printAssert(String msg) {
        System.out.printf("%s\n", msg);
    }


    // Getter setter
    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    
}

