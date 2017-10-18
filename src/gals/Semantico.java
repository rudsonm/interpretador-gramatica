package gals;

import java.util.HashMap;
import java.util.Stack;
import marotagelanguage.MarotageFRM;

public class Semantico implements Constants {

    public static Stack<Double> pilha = new Stack<Double>();
    private static String variavelAtribuicao = "";
    private static HashMap<String, Double> variaveis = new HashMap<>();
    private static boolean querImprimir = false;
    private static boolean querAtribuir = false;
    private static boolean querSomar = false;
    private static boolean querSubtrair = false;
    private static boolean querDividir = false;
    private static boolean querMultiplicar = false;
    private static boolean querExponenciar = false;
    private static Double soma = 0.0;
    

    public void executeAction(int action, Token token) throws SemanticError {
        System.out.println("Ação #" + action + ", Token: " + token);
        //System.out.println(token.getLexeme());
        
        switch (action) {
            case 0:
                
                pilha.push(Double.parseDouble(token.getLexeme()));
                
                if (querSomar) {
                    Double a1 = pilha.peek();
                    Double b1 = pilha.peek();
                    atribuir(variavelAtribuicao, pilha.pop() + pilha.pop());
                    querAtribuir = false;
                    querSomar = false;
                    System.out.println("Variavel de atribuição soma: "+variavelAtribuicao +" valor: "+(a1 + b1));
                    
                }
                
                
                if (querSubtrair) {
                    Double a1 =0.0;
                    Double b1 = 0.0;
                    b1 = pilha.pop();
                    a1 = pilha.pop();
                    querSubtrair = false;
                    atribuir(variavelAtribuicao, a1 - b1);
                    System.out.println("Variavel de atribuição subtração: "+variavelAtribuicao+" valor: " +(a1 - b1));
                    
                    querAtribuir = false;
                }
                
                if (querDividir) {
                    Double a1 =0.0;
                    Double b1 = 0.0;
                    b1 = pilha.pop();
                    a1 = pilha.pop();
                    querDividir = false;
                    atribuir(variavelAtribuicao, a1 / b1);
                    System.out.println("Variavel de atribuição divisao: "+variavelAtribuicao+" valor: "+a1 / b1);
                    
                    querAtribuir = false;
                }
                
                 if (querMultiplicar) {
                    Double a1 =0.0;
                    Double b1 = 0.0;
                    b1 = pilha.pop();
                    a1 = pilha.pop();
                    querMultiplicar = false;
                    atribuir(variavelAtribuicao, a1 * b1);
                    System.out.println("Variavel de atribuição multiplicacao: "+variavelAtribuicao+" valor: "+a1 * b1);
                    
                    querAtribuir = false;
                }
                 
                  if (querExponenciar) {
                    Double a1 =0.0;
                    Double b1 = 0.0;
                    b1 = pilha.pop();
                    a1 = pilha.pop();
                    querExponenciar = false;
                    
                    atribuir(variavelAtribuicao, Math.pow(a1, b1));
                    System.out.println("Variavel de atribuição exponenciação: "+variavelAtribuicao+" valor: "+Math.pow(a1, b1));
                    querAtribuir = false;
                }
                
                
                 if (querAtribuir) {
                     
                    atribuir(variavelAtribuicao, pilha.peek());
                    System.out.println("Variavel de atribuição (quer atribuir): "+variavelAtribuicao +" valor: " +pilha.peek());
                    querAtribuir = false;
                }
                
                break;

            case 1: // cria variavel

                                
                // verificar se existe
                if (!variaveis.containsKey(token.getLexeme())) {// && querAtribuir) {

                    criarVariavelNova(token.getLexeme());

                }else if (querAtribuir) {
                    System.out.println("Variavel para atribuir: "+variavelAtribuicao + " irá atribuir o valor de: " + token.getLexeme());
                    atribuir(variavelAtribuicao, variaveis.get(token.getLexeme()));
                    pilha.push(variaveis.get(token.getLexeme()));
                }
//else if (querSomar) {
//                    soma = pilha.pop() + pilha.pop();
//                    querSomar = false;
//                    //System.out.println(soma);
//                    atribuir(variavel1, soma);
//                }

                if (querImprimir) {

                    imprimir(variavelAtribuicao);

                }
                
                //variavelAtribuicao = token.getLexeme();

                break;
            case 2:
                
                querSomar = true;
                
                break;
                
                case 3:
                  querSubtrair = true;
//                a = pilha.pop();
//                b = pilha.pop();
//                pilha.push(b - a);

                break;

            case 4:
                
                querMultiplicar = true;
//                a = pilha.pop();
//                b = pilha.pop();
//                pilha.push(a * b);
                break;
                
                
            case 5:

                querDividir = true;
//                a = pilha.pop();
//                b = pilha.pop();
//                pilha.push(b / a);

                break;

            case 6:

                querExponenciar = true;
//                a = pilha.pop();
//                b = pilha.pop();
//                pilha.push(Math.pow(b, a));

                break;

            case 7: // atribuir valor á variaveis

                querAtribuir = true;
                //variavelAtribuicao = variavel1;
                break;

            case 8:

                // abre parentese
                break;
            case 9:

                // fecha parentese
                break;
            case 10:

                // fim
                //variavel1 = "";
                //variavel2 = "";
                break;
            case 11:
                
                querImprimir = true;
                break;
        }
    }

    private void imprimir(String variavel) {
        querImprimir = false;
        System.out.println(variaveis.get(variavel));
        MarotageFRM.getInstance().alterarTextArea("" + variaveis.get(variavel));

    }

    private void atribuir(String variavel, Double valor) {

        variaveis.replace(variavel, valor);

    }

    private void criarVariavelNova(String variavel) {

        //variavel nova
        variavelAtribuicao = variavel;
        variaveis.put(variavel, 0.0);

    }

}
