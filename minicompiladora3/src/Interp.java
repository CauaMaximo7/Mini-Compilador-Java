import java.util.HashMap;
import java.util.Map;

public class Interp {

    private final Map<String, Integer> variables = new HashMap<>();

    public void execute(String source) {
        String[] lines = source.split("\\r?\\n");

        for (int lineNumber = 0; lineNumber < lines.length; lineNumber++) {
            String line = lines[lineNumber].trim();

            if (line.isEmpty() || line.startsWith("//")) {
                continue; // Ignorar comentários e linhas vazias
            }

            try {
                if (line.startsWith("print")) {
                    executePrint(line);
                } else if (line.contains("=")) {
                    executeAssign(line);
                } else {
                    throw new RuntimeException("Comando inválido");
                }
            } catch (Exception e) {
                System.err.println("Erro na linha " + (lineNumber + 1) + ": " + e.getMessage());
            }
        }
    }

    private void executePrint(String line) {
        String expr = line.substring(5).trim();
        int value = eval(expr);
        System.out.println(value);
    }

    private void executeAssign(String line) {
        String[] parts = line.split("=");
        if (parts.length != 2)
            throw new RuntimeException("Erro de sintaxe");

        String variable = parts[0].trim();
        int value = eval(parts[1].trim());
        variables.put(variable, value);
    }

    private int eval(String expr) {
        String[] tokens = expr.split("\\s+");

        int result = getValue(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int number = getValue(tokens[i + 1]);

            switch (operator) {
                case "+": result += number; break;
                case "-": result -= number; break;
                case "*": result *= number; break;
                case "/":
                    if (number == 0) throw new RuntimeException("Divisão por zero");
                    result /= number;
                    break;
                default:
                    throw new RuntimeException("Operador desconhecido: " + operator);
            }
        }

        return result;
    }

    private int getValue(String token) {
        if (variables.containsKey(token)) {
            return variables.get(token);
        }

        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Variável não declarada: " + token);
        }
    }
}
