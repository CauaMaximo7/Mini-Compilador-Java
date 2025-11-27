public class Token {
    public enum Type {
        INT, IDENTIFIER, NUMBER,
        ASSIGN, PLUS, MINUS, STAR, SLASH,
        SEMICOLON, LPAREN, RPAREN,
        PRINT,
        EOF
    }

    public final Type type;
    public final String lexeme;

    public Token(Type type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return type + "('" + lexeme + "')";
    }
}
