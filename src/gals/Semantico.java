
import java.util.HashMap;
import java.util.Stack;

public class Semantico implements Constants
{
    public Stack<Double> pilha = new Stack<Double>();
    
    public Semantico(Stack<Double> pilha) {
        this.pilha = pilha;
    }
    
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("A��o #"+action+", Token: "+token);
        String variavel = null;
        HashMap<String, Double> variaveis = new HashMap<>();
        boolean querImprimir = false;
        boolean querAtribuir = false;
        Double a, b;
        switch(action){
            case 0:
                a = Double.parseDouble(token.getLexeme());
                if(querAtribuir) {
                    variaveis.replace(variavel, a);
                    querAtribuir = false;
                } else {
                    pilha.push(a);
                }                
            break;
            case 1:                
                variavel = token.getLexeme();
                // verificar se existe
                variaveis.put(variavel, 0.0);
                if(querImprimir) {
                    System.out.println(variavel);
                    querImprimir = false;
                }
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
                break;
            case 11:
                querImprimir = true;
                break;
        }
    }	
}
