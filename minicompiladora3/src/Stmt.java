import java.util.List;

public abstract class Stmt {

    public static class VarDecl extends Stmt {
        public final String name;

        public VarDecl(String name) {
            this.name = name;
        }
    }

    public static class Assign extends Stmt {
        public final String name;
        public final Expr value;

        public Assign(String name, Expr value) {
            this.name = name;
            this.value = value;
        }
    }

    public static class Print extends Stmt {
        public final Expr expression;

        public Print(Expr expression) {
            this.expression = expression;
        }
    }
}
