/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import miblockchain.BlockChain;
import miblockchain.Transaction;

/**
 *
 * @author tosh
 */
public class MainFrame extends javax.swing.JFrame {
    
    Transaction[]   transacciones;
    BlockChain      miBlockchain;
    int             numeroDeTransacciones;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        numeroDeTransacciones = 0;
        lbl_numeroDeTransacciones.setText("0");        
        
        miBlockchain    =   new BlockChain();
        lbl_numeroDeBloques.setText(Integer.toString(miBlockchain.getNumeroDeBloques()));
        
        transacciones   =   new Transaction[4];
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_realizarTransaccion = new javax.swing.JButton();
        txt_destinoTransaccion = new javax.swing.JTextField();
        txt_montoTransaccion = new javax.swing.JTextField();
        lbl_destinoTransaccion = new javax.swing.JLabel();
        lbl_montoTransaccion = new javax.swing.JLabel();
        lbl_numeroTransacciones = new javax.swing.JLabel();
        lbl_numeroDeTransacciones = new javax.swing.JLabel();
        lbl_origenTransaccion = new javax.swing.JLabel();
        txt_origenTransaccion = new javax.swing.JTextField();
        pnl_blockchain = new javax.swing.JPanel();
        btn_mostrarBlockhain = new javax.swing.JButton();
        lbl_numeroBloques = new javax.swing.JLabel();
        lbl_numeroDeBloques = new javax.swing.JLabel();
        txt_mostrarBloque = new javax.swing.JTextField();
        btn_mostrarBloque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_realizarTransaccion.setText("Transferir");
        btn_realizarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_realizarTransaccionActionPerformed(evt);
            }
        });

        lbl_destinoTransaccion.setText("Destinatario");

        lbl_montoTransaccion.setText("Monto");

        lbl_numeroTransacciones.setText("# Transacciones");

        lbl_origenTransaccion.setText("Origen");

        pnl_blockchain.setBorder(javax.swing.BorderFactory.createTitledBorder("Blockchain"));

        btn_mostrarBlockhain.setText("Blockchain");
        btn_mostrarBlockhain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarBlockhainActionPerformed(evt);
            }
        });

        lbl_numeroBloques.setText("# Bloques");

        btn_mostrarBloque.setText("Bloque");
        btn_mostrarBloque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarBloqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_blockchainLayout = new javax.swing.GroupLayout(pnl_blockchain);
        pnl_blockchain.setLayout(pnl_blockchainLayout);
        pnl_blockchainLayout.setHorizontalGroup(
            pnl_blockchainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_blockchainLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btn_mostrarBlockhain)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_blockchainLayout.createSequentialGroup()
                .addGroup(pnl_blockchainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_blockchainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_mostrarBloque)
                        .addGap(18, 18, 18)
                        .addComponent(txt_mostrarBloque))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_blockchainLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbl_numeroBloques)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(lbl_numeroDeBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        pnl_blockchainLayout.setVerticalGroup(
            pnl_blockchainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_blockchainLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnl_blockchainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_numeroBloques)
                    .addComponent(lbl_numeroDeBloques, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnl_blockchainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mostrarBloque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mostrarBloque))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btn_mostrarBlockhain)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_destinoTransaccion)
                            .addComponent(lbl_montoTransaccion)
                            .addComponent(lbl_origenTransaccion))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_destinoTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(txt_montoTransaccion)
                            .addComponent(txt_origenTransaccion)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_numeroTransacciones)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_realizarTransaccion)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_numeroDeTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))))
                .addGap(44, 44, 44)
                .addComponent(pnl_blockchain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_origenTransaccion)
                            .addComponent(txt_origenTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_destinoTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_destinoTransaccion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_montoTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_montoTransaccion))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_numeroTransacciones, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_numeroDeTransacciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(btn_realizarTransaccion))
                    .addComponent(pnl_blockchain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_realizarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_realizarTransaccionActionPerformed
        // TODO add your handling code here:        
        transacciones[numeroDeTransacciones] =  new Transaction(txt_origenTransaccion.getText(),
                                                                txt_destinoTransaccion.getText(),
                                                                txt_montoTransaccion.getText());
        numeroDeTransacciones++;
        
        if( numeroDeTransacciones == 4 ){
            
            numeroDeTransacciones   =   0;
            crearBloque(transacciones);
            lbl_numeroDeBloques.setText(Integer.toString(miBlockchain.getNumeroDeBloques()));
            JOptionPane.showMessageDialog(null, "Se ha creado un nuevo bloque");
            transacciones   =   new Transaction[4];
            
        }
        lbl_numeroDeTransacciones.setText(Integer.toString(numeroDeTransacciones));
    }//GEN-LAST:event_btn_realizarTransaccionActionPerformed

    private void btn_mostrarBlockhainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarBlockhainActionPerformed
        // TODO add your handling code here:
        miBlockchain.mostrar();
    }//GEN-LAST:event_btn_mostrarBlockhainActionPerformed

    private void btn_mostrarBloqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarBloqueActionPerformed
        // TODO add your handling code here:
        int bloqueBuscado   =   Integer.parseInt(txt_mostrarBloque.getText());
        if(bloqueBuscado    >=   miBlockchain.getNumeroDeBloques()){
            JOptionPane.showMessageDialog(null, "NO existe el bloque");
        }else{
            miBlockchain.obtenerBloque(bloqueBuscado);
        }        
    }//GEN-LAST:event_btn_mostrarBloqueActionPerformed

    private void crearBloque(Transaction[] transacciones) {
        this.miBlockchain.agregarBloque(transacciones);
    }
        
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mostrarBlockhain;
    private javax.swing.JButton btn_mostrarBloque;
    private javax.swing.JButton btn_realizarTransaccion;
    private javax.swing.JLabel lbl_destinoTransaccion;
    private javax.swing.JLabel lbl_montoTransaccion;
    private javax.swing.JLabel lbl_numeroBloques;
    private javax.swing.JLabel lbl_numeroDeBloques;
    private javax.swing.JLabel lbl_numeroDeTransacciones;
    private javax.swing.JLabel lbl_numeroTransacciones;
    private javax.swing.JLabel lbl_origenTransaccion;
    private javax.swing.JPanel pnl_blockchain;
    private javax.swing.JTextField txt_destinoTransaccion;
    private javax.swing.JTextField txt_montoTransaccion;
    private javax.swing.JTextField txt_mostrarBloque;
    private javax.swing.JTextField txt_origenTransaccion;
    // End of variables declaration//GEN-END:variables
}
