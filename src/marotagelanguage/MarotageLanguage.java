
package marotagelanguage;

import gals.*;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 5966868
 */
public class MarotageLanguage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Stack<Double> pilha = new Stack<Double>();
        try {
            Lexico lex = new Lexico("a = 2;\n" +
                                    "b = a + 2;\n"+
                                    "rudshow(b);");
            System.out.println("a = 2;\n" +
                                    "b = a +2;\n"+
                                    "rudshow(b);");
            Sintatico sin = new Sintatico();
            Semantico sem = new Semantico(pilha);
            sin.parse(lex, sem);
            
            
        } catch (SyntaticError | LexicalError | SemanticError ex) {
            Logger.getLogger(MarotageLanguage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
