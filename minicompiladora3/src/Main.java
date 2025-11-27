import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java Main <arquivo.programa>");
            System.exit(1);
        }

        try {
            String source = new String(Files.readAllBytes(Paths.get(args[0])));
            Interp interpreter = new Interp();
            interpreter.execute(source);
        } catch (Exception e) {
            System.err.println("Erro ao executar: " + e.getMessage());
        }
    }
}
