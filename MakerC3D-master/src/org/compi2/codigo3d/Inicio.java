package org.compi2.codigo3d;

import java.io.BufferedReader;
import java.io.StringReader;
import org.compi2.codigo3d.parser.ControlC3D;
import org.compi2.codigo3d.parser.parser;
import org.compi2.codigo3d.parser.scanner;

/**
 *
 * @author esvux
 */
public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_GenerarC3D = new javax.swing.JButton();
        jTextField_Expresion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Codigo3Dgenerado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_GenerarC3D.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        jButton_GenerarC3D.setText("Generar");
        jButton_GenerarC3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GenerarC3DActionPerformed(evt);
            }
        });

        jTextField_Expresion.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N

        jTextArea_Codigo3Dgenerado.setColumns(20);
        jTextArea_Codigo3Dgenerado.setFont(new java.awt.Font("Roboto Mono Light", 0, 18)); // NOI18N
        jTextArea_Codigo3Dgenerado.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Codigo3Dgenerado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField_Expresion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_GenerarC3D, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_Expresion, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButton_GenerarC3D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GenerarC3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GenerarC3DActionPerformed

        String texto = jTextField_Expresion.getText();
        if(texto.isEmpty()){
            System.err.println("No es posible evaluar una cadena en blanco.");
            return;
        }
        try {
           // ControlC3D.reiniciar();
            jTextArea_Codigo3Dgenerado.setText("");
            System.out.println("Inicia la generación de C3D...");
            scanner scan = new scanner(new BufferedReader( new StringReader(texto)));
            parser parser = new parser(scan);
            parser.parse();
            jTextArea_Codigo3Dgenerado.setText(ControlC3D.getC3D());
            System.out.println("Finaliza la generación de C3D...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButton_GenerarC3DActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_GenerarC3D;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_Codigo3Dgenerado;
    private javax.swing.JTextField jTextField_Expresion;
    // End of variables declaration//GEN-END:variables
}
