
package view;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JOptionPane;


public class Pagamento extends javax.swing.JFrame {
    double totalRecebido = 0;
    double total = 0;
    int op = 0;
    OrdemServico x = new OrdemServico();
    
    String padrao = ("###,##0.00");
    DecimalFormat df = new DecimalFormat(padrao);
    DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "Brazil"));

    
    public Pagamento() {
        initComponents();
        txtValorRecebido.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == ',' ||
                        (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if (c == '.' && txtValorRecebido.getText().contains(".") ||
                        c == ',' && txtValorRecebido.getText().contains(",")) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent evt) {}
        });
        
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df = new DecimalFormat(padrao, dfs);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotalRecebido = new javax.swing.JLabel();
        lblValorRecebido = new javax.swing.JLabel();
        lblTroco = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        lblTotalCompra = new javax.swing.JLabel();
        txtTotalRecebido = new javax.swing.JTextField();
        txtValorRecebido = new javax.swing.JTextField();
        txtTroco = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        txtTotalCompra = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pagamento");
        setResizable(false);

        lblTotalRecebido.setText("TOTAL RECEBIDO");

        lblValorRecebido.setText("VALOR RECEBIDO");

        lblTroco.setText("TROCO");

        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSubTotal.setText("SUB TOTAL");

        lblTotalCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalCompra.setText("VALOR DA COMPRA");

        txtTotalRecebido.setEditable(false);

        txtValorRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorRecebidoActionPerformed(evt);
            }
        });

        txtTroco.setEditable(false);

        txtSubTotal.setEditable(false);
        txtSubTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtTotalCompra.setEditable(false);
        txtTotalCompra.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblTotal.setText("TOTAL COMPRA");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalCompra, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalRecebido)
                            .addComponent(txtTotalRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValorRecebido)
                            .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubTotal)
                            .addComponent(lblTroco))
                        .addGap(18, 356, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblSubTotal, lblTotalCompra, lblTotalRecebido, lblTroco, lblValorRecebido});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtSubTotal, txtTotal, txtTotalCompra, txtTotalRecebido, txtTroco, txtValorRecebido});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblValorRecebido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalRecebido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSubTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTroco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTotalCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public double troco(){
        double valRecebido = Double.parseDouble(txtValorRecebido.getText().replace(',','.'));
        
        totalRecebido += valRecebido;
        
        txtTotalRecebido.setText(String.valueOf(df.format(totalRecebido)));
        
        double troco = valRecebido - this.total;
        
        if(txtTotalRecebido.getText().isEmpty()){
            if(troco < 0){
                txtSubTotal.setText(String.valueOf(df.format(troco * (-1))));
            }else if(troco > 0){
                txtTroco.setText(String.valueOf(df.format(troco)));
            }
        }else{
            troco = totalRecebido - this.total;
            
            if(troco < 0){
                txtSubTotal.setText(String.valueOf(df.format(troco * (-1))));
                txtTroco.setText("0,00");
            }else if(troco > 0){
                txtSubTotal.setText("0,00");
                txtTroco.setText(String.valueOf(df.format(troco)));
            }else{
                txtSubTotal.setText("0,00");
                txtTroco.setText("0,00");
            }
        }
        
        txtValorRecebido.setText(null);
        
        return troco;
    }    
    
    private void txtValorRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorRecebidoActionPerformed
        double troco = troco();
        
        if(troco == 0){
            dispose();
            op = 1;
        }else if(troco > 0){            
            JOptionPane.showMessageDialog(null, "Valor do troco: "+ df.format(troco));
            dispose();
            op = 1;
        }
        
        if(op == 1){
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }
    }//GEN-LAST:event_txtValorRecebidoActionPerformed

    public void total(double totalCompra, double total){
        txtTotalCompra.setText(df.format(totalCompra));
        txtTotal.setText(df.format(total));
        
        this.total = totalCompra;
    }
    
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
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalCompra;
    private javax.swing.JLabel lblTotalRecebido;
    private javax.swing.JLabel lblTroco;
    private javax.swing.JLabel lblValorRecebido;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalCompra;
    private javax.swing.JTextField txtTotalRecebido;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtValorRecebido;
    // End of variables declaration//GEN-END:variables
}
