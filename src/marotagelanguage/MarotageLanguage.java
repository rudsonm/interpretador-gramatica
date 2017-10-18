package marotagelanguage;

import gals.*;
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
    public static void main(String[] args) throws SemanticError {
        // Stack<Double> pilha = new Stack<Double>();
        try {
            Lexico lex = new Lexico("a = 2 + 5;\n"
                                   +"rudshow(a);\n"
                                   +"b = a + 2;\n" +
                                    "rudshow(a);");
            System.out.println("a = 2 + 5;\n"
                                   +"rudshow(a);\n"
                                   +"b = a + 2;\n" +
                                    "rudshow(b);");
            Sintatico sin = new Sintatico();
            Semantico sem = new Semantico();
            sin.parse(lex, sem);

        } catch (LexicalError | SyntaticError ex) {
            Logger.getLogger(MarotageLanguage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
