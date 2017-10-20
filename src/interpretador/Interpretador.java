/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;

import gals.LexicalError;
import gals.Lexico;
import gals.SemanticError;
import gals.Semantico;
import gals.Sintatico;
import gals.SyntaticError;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rudsonm
 */
public class Interpretador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SemanticError {
        try {
            String expressao = "a = 1010 + 10; b = (a + 10) * 101; rudshow(b);";
            System.out.println(expressao);
            Lexico lex = new Lexico(expressao);
            Sintatico sin = new Sintatico();
            Semantico sem = new Semantico();
            sin.parse(lex, sem);
        } catch (LexicalError | SyntaticError ex) {
            Logger.getLogger(Interpretador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
