package algo;

import java.util.Stack;

public class Converter {
    
    public static String infixToPostfix(String infixExpression) {
        infixExpression = formatInfixExpression(infixExpression);
        Stack<String> stack = new Stack<String>();
        String res = "";
        String[] tokens = infixExpression.split(" ");
        
        for(int i = 0; i <= tokens.length-1; i++) {
            if(Check.isOperator(tokens[i])) {
                while(!stack.isEmpty() && 
                        ((Check.isOperator(stack.peek()) && operatorPrecedence(tokens[i]) <= operatorPrecedence(stack.peek()))
                        || Check.isFuncIdent(stack.peek()))){
                    res += stack.pop() + " ";
                }
                stack.push(tokens[i]);
            }
            else if(i < tokens.length-1 && tokens[i+1].equals("(") && Check.isFuncIdent(tokens[i])) {
                stack.push(tokens[i]);
            }
            else if(Check.isComma(tokens[i])) {
                while(!stack.peek().equals("(")) res += stack.pop() + " ";
            }
            else if(tokens[i].equals("(")) stack.push(tokens[i]);
            else if(tokens[i].equals(")")) {
                while(!stack.peek().equals("(")) res += stack.pop() + " ";
                stack.pop();
            }
            else if(Check.isOperand(tokens[i])) res += tokens[i] + " ";
            else return null;
        }
        while(!stack.empty()) res += stack.pop() + " ";
        return res.trim();
    }

    public static String infixToPrefix(String infixExpression) {
        infixExpression = formatInfixExpression(infixExpression);
        Stack<String> stack = new Stack<String>();
        Stack<String> resStack = new Stack<String>();
        String[] tokens = infixExpression.split(" ");
        
        for(int i = tokens.length-1; i >= 0; i--) {
            if(Check.isOperator(tokens[i])) {
                while(!stack.isEmpty() && 
                        ((Check.isOperator(stack.peek()) && operatorPrecedence(tokens[i]) < operatorPrecedence(stack.peek()))
                        || Check.isFuncIdent(stack.peek()))){
                    resStack.push(stack.pop());
                    resStack.push(" ");
                }
                stack.push(tokens[i]);
            }
            else if(i < tokens.length-1 && tokens[i+1] == "(" && Check.isFuncIdent(tokens[i])) stack.push(tokens[i]);
            else if(Check.isComma(tokens[i])) {
                while(!stack.peek().equals(")")) {
                    resStack.push(stack.pop());
                    resStack.push(" ");
                }
            }
            else if(tokens[i].equals(")")) stack.push(tokens[i]);
            else if(tokens[i].equals("(")) {
                while(!stack.peek().equals(")")) {
                    resStack.push(stack.pop());
                    resStack.push(" ");
                }
                stack.pop();
            }
            else if(Check.isOperand(tokens[i])) {
                resStack.push(tokens[i]);
                resStack.push(" ");
            }
            else return null;
        }
        while(!stack.isEmpty()) {
            resStack.push(stack.pop());
            resStack.push(" ");
        }
        String res = "";
        while(!resStack.isEmpty()) res += resStack.pop();
        return res.trim();
    }

    public static String postfixToInfix(String postfixExpression) {
        Stack<String> stack = new Stack<String>();
        String[] tokens = postfixExpression.trim().split(" ");
        
        for(String token : tokens) {
            if(Check.isOperator(token)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push("(" + operand1 + token + operand2 + ")");
            }
            else if(Check.isOperand(token)) stack.push(token);
            else return null;
        }
        String res = stack.pop();
        if(stack.isEmpty()) return res;
        else return null;
    }

    public static String postfixToPrefix(String postfixExpression) {
        Stack<String> stack = new Stack<String>();
        String[] tokens = postfixExpression.trim().split(" ");
        
        for(String token : tokens) {
            if(Check.isOperator(token)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push(token + " " + operand1 + operand2);
            }
            else if(Check.isOperand(token)) stack.push(token + " ");
            else return null;
        }
        String res = stack.pop().trim();
        if(stack.isEmpty()) return res;
        else return null;
    }

    public static String prefixToInfix(String prefixExpression) {
        Stack<String> stack = new Stack<String>();
        String[] tokens = prefixExpression.split(" ");
        
        for(int i = tokens.length-1; i >= 0; i--) {
            if(Check.isOperator(tokens[i])) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push("(" + operand1 + tokens[i] + operand2 + ")");
            }
            else if(Check.isOperand(tokens[i])) stack.push(tokens[i]);
            else return null;
        }
        
        String res = stack.pop().trim();
        if(stack.isEmpty()) return res;
        else return null;
    }
    
    public static String prefixToPostfix(String prefixExpression) {
        Stack<String> stack = new Stack<String>();
        String[] tokens = prefixExpression.split(" ");
        
        for(int i = tokens.length-1; i >= 0; i--) {
            if(Check.isOperator(tokens[i])) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push(operand1 + operand2 + tokens[i] + " ");
            }
            else if(Check.isOperand(tokens[i])) stack.push(tokens[i] + " ");
            else return null;
        }
        String res = stack.pop().trim();
        if(stack.isEmpty()) return res;
        else return null;
    }
    
    public static String formatInfixExpression(String infixExpression) {
        String res = "";
        for(char c : infixExpression.toCharArray()) {
            if(Check.isOperator(c) || c == '(' || c == ')') res += " " + c + " ";
            else if(c == ',') res += " , ";
            else if(c == ' ') continue;
            else res += c;
        }
        return res.trim().replace("  ", " ");
    }

    public static int operatorPrecedence(char operator) {
        if(operator == '+' || operator == '-') return 1;
        else if(operator == '*' || operator == '/') return 2;
        else if(operator == '^') return 3;
        else return 0;
    }

    public static int operatorPrecedence(String operator) {
        if(operator.equals("+") || operator.equals("-")) return 1;
        else if(operator.equals("*") || operator.equals("/")) return 2;
        else if(operator.equals("^")) return 3;
        else if(operator.equals("!")) return 4;
        else if(operator.equals("sqrt")) return 5;
        else return 0;
    }
}