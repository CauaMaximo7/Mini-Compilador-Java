Mini Compilador ⚙️🖥️

Este projeto consiste em um mini compilador desenvolvido em Java, capaz de analisar comandos definidos em uma linguagem simples criada para fins acadêmicos. O objetivo principal é demonstrar o funcionamento básico de um compilador: análise léxica, sintática e execução de instruções pré-definidas.

🚀 Funcionalidades

Interpretar comandos da linguagem criada

Exemplo de instruções já suportadas:

PRINT x; → Exibe valores numéricos ou texto

ADD x, y; → Soma dois valores inteiros

Geração de saída com base nas instruções

🧩 Estrutura da Linguagem

A linguagem é composta por instruções simples, finalizadas com ;.

Exemplos de sintaxe:

PRINT 5;
ADD 3, 7;

📌 Exemplos de Código + Saída
Exemplo 1

Entrada:

PRINT 5;


Saída esperada:

5

Exemplo 2

Entrada:

ADD 10, 20;


Saída esperada:

30

📂 Estrutura do Projeto
/src
 ├── Main.java           → Classe principal
 ├── Tokenizer.java      → Analisador léxico
 ├── Parser.java         → Analisador sintático
 └── Executor.java       → Executa os comandos


Os nomes podem variar conforme sua implementação.

▶️ Como executar

Instale o JDK 8+

Compile o projeto:

javac src/*.java


Execute:

java Main


Ao rodar, o programa pedirá que você digite os comandos da linguagem.

Cole qualquer exemplo na entrada para testar. ✔️

🧠 Objetivo do Projeto

Este mini compilador foi desenvolvido como parte acadêmica para demonstrar conceitos essenciais de compilação:

✔️ Tokenização
✔️ Análise e validação de comandos
✔️ Interpretação de instruções simples
