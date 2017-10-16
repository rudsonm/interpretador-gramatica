/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marotagelanguage;

import gals.LexicalError;
import gals.Lexico;
import gals.SemanticError;
import gals.Semantico;
import gals.Sintatico;
import gals.SyntaticError;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DG
 */
public class MarotageFRM extends javax.swing.JFrame {

    
    private static int cont = 0;
    private static MarotageFRM fRMMarotageLanguage;
    
    /**
     * Creates new form MarotageFRM
     */
    public MarotageFRM() {
        initComponents();
    }
    
     public static synchronized MarotageFRM getInstance() {

        if (getfRMMarotageLanguage() == null) {
            setfRMMarotageLanguage(new MarotageFRM());
            System.out.println(cont++);
        }
        return getfRMMarotageLanguage();
    }
     
     /**
     * @return the fRMMarotageLanguage
     */
    public static MarotageFRM getfRMMarotageLanguage() {
        return fRMMarotageLanguage;
    }
    
    public void alterarTextArea(String texto){
        System.out.println("alterando texto resultado");
        this.jtaResultado.setText("");
        this.jtaResultado.append(texto);
       
    }

     /**
     * @param afRMMarotageLanguage the fRMMarotageLanguage to set
     */
    public static void setfRMMarotageLanguage(MarotageFRM afRMMarotageLanguage) {
        fRMMarotageLanguage = afRMMarotageLanguage;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtaCodigoFonte = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaResultado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jbtCompilarExecutar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ML - Marotage Language");

        jtaCodigoFonte.setColumns(20);
        jtaCodigoFonte.setRows(5);
        jScrollPane1.setViewportView(jtaCodigoFonte);

        jtaResultado.setEditable(false);
        jtaResultado.setColumns(20);
        jtaResultado.setRows(5);
        jScrollPane2.setViewportView(jtaResultado);

        jLabel1.setText("Crie seu código fonte");

        jbtCompilarExecutar.setText("Compilar/Executar");
        jbtCompilarExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCompilarExecutarActionPerformed(evt);
            }
        });

        jLabel2.setText("Saída");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 495, Short.MAX_VALUE)
                        .addComponent(jbtCompilarExecutar))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbtCompilarExecutar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(754, 443));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCompilarExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCompilarExecutarActionPerformed

        Stack<Double> pilha = new Stack<Double>();
        try {
            Lexico lex = new Lexico(jtaCodigoFonte.getText());
            System.out.println(jtaCodigoFonte.getText());
            Sintatico sin = new Sintatico();
            Semantico sem = new Semantico(pilha);
            sin.parse(lex, sem);
            
        } catch (LexicalError | SemanticError |SyntaticError ex) {
            Logger.getLogger(MarotageLanguage.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }//GEN-LAST:event_jbtCompilarExecutarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MarotageFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarotageFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarotageFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarotageFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarotageFRM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtCompilarExecutar;
    private javax.swing.JTextArea jtaCodigoFonte;
    public javax.swing.JTextArea jtaResultado;
    // End of variables declaration//GEN-END:variables

   

   
}
