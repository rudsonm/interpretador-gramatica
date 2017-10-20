package gals;

import java.util.HashMap;
import java.util.Stack;
import javax.swing.JOptionPane;
import marotagelanguage.MarotageFRM;

public class Semantico implements Constants {

    public static Stack<Double> pilha = new Stack<Double>();
    private static String variavel1 = "";
    private static String variavel2 = "";
    private static String variavelAtribuicao = "";
    private static HashMap<String, Double> variaveis = new HashMap<>();
    private static boolean querImprimir = false;
    private static boolean querAtribuir = false;
    private static boolean querSomar = false;
    private static Double soma = 0.0;

    public Semantico(Stack<Double> pilha) {
        this.pilha = pilha;
    }

    public void executeAction(int action, Token token) throws SemanticError {
        //System.out.println("Ação #" + action + ", Token: " + token);
        //System.out.println(token.getLexeme());
        Double a, b;
        switch (action) {

            case 0: //atribuir valores as variaveis

                a = Double.parseDouble(token.getLexeme());
                pilha.push(a);

                if (querSomar) {
                    soma = pilha.pop() + pilha.pop();
                    querSomar = false;
                    //System.out.println(soma);
                    atribuir(variavel1, soma);
                }

                if (querAtribuir) {
                    atribuir(variavel1, a);
                    querAtribuir = false;
                }

//                if (querImprimir) {
//
//                    imprimir(variavel1);
//                }

                break;

            case 1: // cria variavel
                
                variavel1 = token.getLexeme();
                // verificar se existe
                if (!variaveis.containsKey(token.getLexeme())) {// && querAtribuir) {
                    
                    criarVariavelNova(token.getLexeme());
                    
                }else{
                    
                    atribuir(variavel2, variaveis.get(variavel1));
                }
                

                if (querImprimir) {

                    imprimir(variavel1);
                    
                }
                
                variavel2 = variavel1;

                break;

            case 2:

                //a = pilha.pop();
                querSomar = true;

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

            case 7: // atribuir valor á variaveis

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
        MarotageFRM.getInstance().alterarTextArea(""+variaveis.get(variavel));
        
        
    }

    private void atribuir(String variavel, Double valor) {

       
                variaveis.replace(variavel, valor);
        
    }

    private void criarVariavelNova(String variavel) {

        //variavel nova
        variaveis.put(variavel, 0.0);

    }

}
