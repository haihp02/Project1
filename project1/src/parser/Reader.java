package parser;

public class Reader {

    public static final int IO_ERROR = 0;
    public static final int IO_SUCCESS = 1;
    
    private int lineNo, colNo;
    private int currentChar;
    private int currentCharIndex = 0;
    

    public void setExpression(String expression) {
        this.expression = expression;
    }

    String expression;

    public int readChar() {
        try {
            currentChar = expression.charAt(currentCharIndex++);
            colNo++;
            if(currentChar == '\n') {
                lineNo++;
                colNo = 0;
            }
        }
        catch(IndexOutOfBoundsException e) {
            currentChar = -1;
        }
        return currentChar;
    }

    public int openInputStream(String string) {
        expression = string;
        if(string.isBlank()) return IO_ERROR;
        lineNo = 1;
        colNo = 0;
        readChar();
        return IO_SUCCESS;
    }


    // Getter setter
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

    public int getCurrentChar() {
        return currentChar;
    }

    public void setCurrentChar(int currentChar) {
        this.currentChar = currentChar;
    }

    public int getCurrentCharIndex() {
        return currentCharIndex;
    }

    public void setCurrentCharIndex(int currentCharIndex) {
        this.currentCharIndex = currentCharIndex;
    }

    public String getExpression() {
        return expression;
    }
}
