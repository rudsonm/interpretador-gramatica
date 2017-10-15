/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public static void main(String[] args) {
        Stack<Double> pilha = new Stack<Double>();
        try {
            Lexico lex = new Lexico("2 + 9");
            
            Sintatico sin = new Sintatico(pilha);
            Semantico sem = new Semantico();
            sin.parse(lex, sem);
            System.out.println("Resultado: " + pilha.pop());
        } catch (LexicalError ex) {
            Logger.getLogger(MarotageLanguage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
