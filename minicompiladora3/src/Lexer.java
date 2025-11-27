import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String input;
    private int pos = 0;

    public Lexer(String input) {
        this.input = input;
    }

    private char peek() {
        if (pos >= input.length()) return '\0';
        return input.charAt(pos);
    }

    private char advance() {
        return input.charAt(pos++);
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        while (pos < input.length()) {
            char c = peek();

            if (Character.isWhitespace(c)) {
                advance();
                continue;
            }

            if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                while (Character.isDigit(peek())) number.append(advance());
                tokens.add(new Token(Token.Type.NUMBER, number.toString()));
                continue;
            }

            if (Character.isLetter(c)) {
                StringBuilder id = new StringBuilder();
                while (Character.isLetterOrDigit(peek())) id.append(advance());
                String word = id.toString();

                if (word.equals("int"))
                    tokens.add(new Token(Token.Type.INT, word));
                else if (word.equals("print"))
                    tokens.add(new Token(Token.Type.PRINT, word));
                else
                    tokens.add(new Token(Token.Type.IDENTIFIER, word));
                continue;
            }

            switch (advance()) {
                case '=' -> tokens.add(new Token(Token.Type.ASSIGN, "="));
                case '+' -> tokens.add(new Token(Token.Type.PLUS, "+"));
                case '-' -> tokens.add(new Token(Token.Type.MINUS, "-"));
                case '*' -> tokens.add(new Token(Token.Type.STAR, "*"));
                case '/' -> tokens.add(new Token(Token.Type.SLASH, "/"));
                case ';' -> tokens.add(new Token(Token.Type.SEMICOLON, ";"));
                case '(' -> tokens.add(new Token(Token.Type.LPAREN, "("));
                case ')' -> tokens.add(new Token(Token.Type.RPAREN, ")"));
                default -> throw new RuntimeException("Caractere inválido: " + c);
            }
        }

        tokens.add(new Token(Token.Type.EOF, ""));
        return tokens;
    }
}
