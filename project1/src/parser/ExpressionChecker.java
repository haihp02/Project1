package parser;

public class ExpressionChecker {
    
    private Parser parser;
    private Scanner scanner;
    private Reader reader;
    private Error err;
    private CharCodeClass charcode;
    
    public ExpressionChecker() {
        parser = new Parser();
        scanner = new Scanner();
        reader = new Reader();
        err = new Error();
        charcode = new CharCodeClass();
        
        parser.setReader(reader);
        parser.setError(err);
        parser.setScanner(scanner);
        scanner.setReader(reader);
        scanner.setError(err); 
        scanner.setCharcode(charcode);
    }
    
    public boolean check(String expression) {
        if(expression == null || parser.compile(expression + ";") == Reader.IO_ERROR) {
            System.out.println("Can't read");
            return false;
        }
        else if(err.isPassed()) {
            System.out.println("Checked");
            return true;
        } else {
            System.out.println("Not checked");
            return false;
        }
    }
}
