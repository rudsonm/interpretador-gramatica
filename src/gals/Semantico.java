package gals;

import java.util.HashMap;
import java.util.Stack;

public class Semantico implements Constants {

    public static Stack<Double> pilha = new Stack<Double>();
    private static String variavel1 = "";
    private static String variavel2 = "";
    private static HashMap<String, Double> variaveis = new HashMap<>();
    private static boolean querImprimir = false;
    private static boolean querAtribuir = false;

    public Semantico(Stack<Double> pilha) {
        this.pilha = pilha;
    }

    public void executeAction(int action, Token token) throws SemanticError {
        System.out.println("Ação #" + action + ", Token: " + token);

        Double a, b;
        switch (action) {

            case 0:

                a = Double.parseDouble(token.getLexeme());

                if (querAtribuir) {
                    variaveis.replace(variavel1, a);
                    querAtribuir = false;
                }

                pilha.push(a);

                break;

            case 1:

                variavel1 = token.getLexeme();
                
                // verificar se existe
                if (variaveis.containsKey(variavel1)) {
                    variaveis.replace(variavel2, variaveis.get(variavel1));
                } else {
                    variaveis.put(variavel1, 0.0);
                }
                
                if (querImprimir) {
                    System.out.println(variavel1);
                    querImprimir = false;
                }

                variavel2 = variavel1;

                break;

            case 2:

                a = pilha.pop();
                b = pilha.pop();
                pilha.push(a + b);

                break;

            case 3:

                a = pilha.pop();
                b = pilha.pop();
                pilha.push(b - a);

                break;

            case 4:

                a = pilha.pop();
                b = pilha.pop();
                pilha.push(a * b);

                break;

            case 5:

                a = pilha.pop();
                b = pilha.pop();
                pilha.push(b / a);

                break;

            case 6:

                a = pilha.pop();
                b = pilha.pop();
                pilha.push(Math.pow(b, a));

                break;

            case 7:

                querAtribuir = true;

                break;

            case 8:

                // abre
                break;

            case 9:

                // fecha
                break;

            case 10:

                // fim
                variavel1 = "";
                variavel2 = "";
                break;

            case 11:

                querImprimir = true;

                break;
        }
    }
}
