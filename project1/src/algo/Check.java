package algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Check {
    

    public static boolean isOperator(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '/') return true;
        else return false;
    }
    
    public static boolean isOperator(String s) {
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) return true;
        else return false;
    }
    
    public static boolean isComma(String s) {
        return (s.trim()).equals(",");
    }
    
    public static boolean isFuncIdent(String s) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        return matcher.find(); 
    }
    
    public static boolean isOperand(String s) {
        if(isOperator(s)) return false;
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+[.]?[a-zA-Z0-9]*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        return matcher.find(); 
    }

    public static boolean endsWithDigit(String s) {
        Pattern pattern = Pattern.compile("^.*[0-9]$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        return matcher.find(); 
    }
    
    public static boolean startsWithDigit(String s) {
        Pattern pattern = Pattern.compile("^[0-9].*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        return matcher.find(); 
    }
}
