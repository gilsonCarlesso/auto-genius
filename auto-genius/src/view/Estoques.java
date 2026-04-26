
package view;

import java.util.ArrayList;
import model.Estoque;
import javax.swing.table.DefaultTableModel;
import control.MetodoEstoque;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class Estoques extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    MetodoEstoque fun = new MetodoEstoque();

    
    public Estoques() {
        initComponents();
        
        tabela(fun.tabela());
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ajustarTamanhoColunas();
        txtIdEstoque.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArmazenamento = new javax.swing.JLabel();
        txtArmazenamento = new javax.swing.JTextField();
        txtIdEstoque = new javax.swing.JTextField();
        txtBusca = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblRecarregar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estoque");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblArmazenamento.setText("Local de Armazenamento");

        txtIdEstoque.setEditable(false);
        txtIdEstoque.setEnabled(false);

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar-24px.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excluir-24px.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar-24px.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo-24px.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Local"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lblRecarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/recarregar-24px.png"))); // NOI18N
        lblRecarregar.setToolTipText("recarregar");
        lblRecarregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRecarregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRecarregarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblArmazenamento)
                        .addComponent(txtArmazenamento)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAlterar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnNovo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnAdicionar)))
                    .addComponent(txtIdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBusca)
                        .addGap(8, 8, 8)
                        .addComponent(lblRecarregar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblArmazenamento)
                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArmazenamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnExcluir)
                                .addComponent(btnAlterar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdicionar)
                                .addComponent(btnNovo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(txtIdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRecarregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblArmazenamento, txtArmazenamento});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpar();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(txtArmazenamento.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Campo de textos está vazio\n\n"
                    + "Por favor insira os dados", "Aviso", 2);
        }else{
            if(verificaArmazenamento(fun.tabela()) == true){
                JOptionPane.showMessageDialog(null,"Local já cadastrado","Aviso",2);
                limpar();
            }else{
                Estoque estoque = new Estoque();

                estoque.setLocalArmazenamento(txtArmazenamento.getText().toUpperCase());

                fun.inserirEstoque(estoque);

                limpar();

                tabela(fun.tabela());
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = jTable1.getSelectedRow();
        
        fun.deletar(Integer.parseInt(String.valueOf(jTable1.getValueAt(linha, 0))));
        
        tabela(fun.tabela());
        
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int linha = jTable1.getSelectedRow();
        
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        
        if(evt.getClickCount() == 1){
            btnExcluir.setEnabled(true);
            btnAdicionar.setEnabled(true);
            limpar();
        }
        
        if(evt.getClickCount() == 2){
            txtIdEstoque.setText(String.valueOf(jTable1.getValueAt(linha, 0)));
            txtArmazenamento.setText(String.valueOf(jTable1.getValueAt(linha, 1)));
            
            btnAlterar.setEnabled(true);
            btnAdicionar.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if(txtArmazenamento.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Campo de textos está vazio\n\n"
                    + "Por favor insira os dados", "Aviso", 2);
        }else{
            if(verificaArmazenamento(fun.tabela()) == true){
                JOptionPane.showMessageDialog(null,"Local já cadastrado","Aviso",2);
                limpar();
            }else{
                Estoque estoque = new Estoque();

                estoque.setIdEstoque(Integer.parseInt(txtIdEstoque.getText()));
                estoque.setLocalArmazenamento(txtArmazenamento.getText().toUpperCase());

                fun.alterar(estoque);

                tabela(fun.tabela());

                limpar();
            }
        }    
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        tabela(fun.buscaEstoque(txtBusca.getText()));
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnAdicionar.setEnabled(true);
        jTable1.clearSelection();
        
        limpar();        
    }//GEN-LAST:event_formMouseClicked

    private void lblRecarregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecarregarMouseClicked
        txtBusca.setText(null);
        tabela(fun.tabela());
    }//GEN-LAST:event_lblRecarregarMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Menu x = new Menu();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    public void limpar(){
        txtArmazenamento.setText(null);
    }
    
    public void tabela(ArrayList<Estoque> estoque){
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for(Estoque x: estoque){
            model.addRow(new Object[]{
                x.getIdEstoque(),
                x.getLocalArmazenamento()
            });
        }
    }
    
    public void ajustarTamanhoColunas() {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(350);
    }
    
    public boolean verificaArmazenamento(ArrayList<Estoque> estoque){
        for(int i=0;i<estoque.size();i++){
            if(txtArmazenamento.getText().equals(estoque.get(i).getLocalArmazenamento())){
                return true;
            }
            break;
        }
        return false;
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
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estoques().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblArmazenamento;
    private javax.swing.JLabel lblRecarregar;
    private javax.swing.JTextField txtArmazenamento;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtIdEstoque;
    // End of variables declaration//GEN-END:variables
}
