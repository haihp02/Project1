package parser;

enum CharCode {
    CHAR_SPACE,
    CHAR_LETTER,
    CHAR_DIGIT,
    CHAR_PLUS,
    CHAR_MINUS,
    CHAR_TIMES,
    CHAR_SLASH,
    CHAR_LT,
    CHAR_GT,
    CHAR_EXCLAIMATION,
    CHAR_EQ,
    CHAR_COMMA,
    CHAR_PERIOD,
    CHAR_COLON,
    CHAR_SEMICOLON,
    CHAR_SINGLEQUOTE,
    CHAR_LPAR,
    CHAR_RPAR,
    CHAR_UNKNOWN
}

public class CharCodeClass {
    public static final CharCode charCodes[] = {
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_SPACE, CharCode.CHAR_SPACE, CharCode.CHAR_SPACE, CharCode.CHAR_SPACE, CharCode.CHAR_SPACE, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
      
        CharCode.CHAR_SPACE, CharCode.CHAR_EXCLAIMATION, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_SINGLEQUOTE,
        CharCode.CHAR_LPAR, CharCode.CHAR_RPAR, CharCode.CHAR_TIMES, CharCode.CHAR_PLUS, CharCode.CHAR_COMMA, CharCode.CHAR_MINUS, CharCode.CHAR_PERIOD, CharCode.CHAR_SLASH,
        CharCode.CHAR_DIGIT, CharCode.CHAR_DIGIT, CharCode.CHAR_DIGIT, CharCode.CHAR_DIGIT, CharCode.CHAR_DIGIT, CharCode.CHAR_DIGIT, CharCode.CHAR_DIGIT, CharCode.CHAR_DIGIT,
        CharCode.CHAR_DIGIT, CharCode.CHAR_DIGIT, CharCode.CHAR_COLON, CharCode.CHAR_SEMICOLON, CharCode.CHAR_LT, CharCode.CHAR_EQ, CharCode.CHAR_GT, CharCode.CHAR_UNKNOWN,
      
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER,
        CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER,
        CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER,
        CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
      
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER,
        CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER,
        CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER,
        CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_LETTER, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
      
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
      
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
      
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
      
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN,
        CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN, CharCode.CHAR_UNKNOWN
    };
}
