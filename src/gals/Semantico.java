package gals;

import interpretador.InterpretadorFRM;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    public static Stack<Integer> pilha = new Stack<Integer>();
    public static Map<String, Integer> variaveis = new HashMap<String, Integer>();
    public static String atribuicao;
    
    public void executeAction(int action, Token token) throws SemanticError
    {
//        System.out.println("A��o #"+action+", Token: "+token);
        String variavel;
        Integer a, b;
        switch(action) {
            case 0:
                a = Integer.parseInt(token.getLexeme(), 2);
                pilha.push(a);
            break;
            case 1:
                variavel = token.getLexeme();
                a = variaveis.get(variavel);
                pilha.push(a);
            break;
            case 2:
                b = pilha.pop();
                a = pilha.pop();
                pilha.push(a + b);
            break;
            case 3:
                b = pilha.pop();
                a = pilha.pop();
                pilha.push(a - b);
            break;
            case 4:
                b = pilha.pop();
                a = pilha.pop();
                pilha.push(a * b);
            break;
            case 5:
                b = pilha.pop();
                a = pilha.pop();
                pilha.push(a / b);
            break;
            case 6:
                b = pilha.pop();
                a = pilha.pop();
                Double aux = Math.pow(a, b);
                pilha.push(aux.intValue());
            break;
            case 7:
                
            break;
            case 8:
                variavel = token.getLexeme();
                System.out.println(variaveis.get(variavel));
                InterpretadorFRM.getInstance().alterarTextArea(variaveis.get(variavel).toString());
            break;
            case 9:
                variavel = atribuicao;
                if(variaveis.containsKey(variavel)) {
                    variaveis.replace(variavel, pilha.pop());
                } else {
                    variaveis.put(variavel, pilha.pop());
                }
            break;
            case 10:
                atribuicao = token.getLexeme();
            break;
        }
    }	
}
