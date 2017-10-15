package gals;

import java.util.HashMap;
import java.util.Stack;

public class Semantico implements Constants {

    public static Stack<Double> pilha = new Stack<Double>();

    private static boolean querImprimir = false;
    private static boolean querAtribuir = false;
    private static HashMap<String, Double> variaveis = new HashMap<>();
    private static String variavel1 = "";
    private static String variavel2 = "";

    public Semantico(Stack<Double> pilha) {
        this.pilha = pilha;
    }

    public void executeAction(int action, Token token) throws SemanticError {
        System.out.println("Ação #" + action + ", Token: " + token);
        //System.out.println( token.getLexeme());

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
                    variaveis.replace(variavel2, variaveis.get(token.getLexeme()));
                } else {
                    variaveis.put(variavel1, 0.0);
                }
                if (querImprimir) {
                    System.out.println(variaveis.get(token.getLexeme()));
                    querImprimir = false;
                }
                variavel2 = variavel1;
                break;
            case 2:
                
                a = pilha.peek();
                b = pilha.peek();
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
               // System.out.println("abrir paretese impressao(");
                break;
            case 9:
                // fecha
                //System.out.println("fechar paretese impressao)");
                break;
            case 10:
                // fim
                variavel1 = "";
                variavel2 = "";
                break;
            case 11:
                querImprimir = true;
                //System.out.println("Teste impressao");
                break;
        }
    }
}
