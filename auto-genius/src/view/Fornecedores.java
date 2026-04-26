
package view;

import control.MetodosEndereco;
import control.MetodosFornecedor;
import control.Validacoes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Fornecedor;


public class Fornecedores extends javax.swing.JFrame {
    MetodosEndereco funEndereco = new MetodosEndereco();
    MetodosFornecedor funFornecedor = new MetodosFornecedor();
    DefaultTableModel model = new DefaultTableModel();
    Validacoes valida = new Validacoes();
    
    int idFornecedor = 0, cnpj = 0;

    
    public Fornecedores() {
        initComponents();
        tabela(funFornecedor.tabela());
        ajustarTamanhoColunas();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        txtCNPJ.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                if(cnpj == 2 || cnpj == 6){
                    txtCNPJ.setText(txtCNPJ.getText() + ".");
                }
                if(cnpj == 10){
                    txtCNPJ.setText(txtCNPJ.getText() + "/");
                }
                if(cnpj == 15){
                    txtCNPJ.setText(txtCNPJ.getText() + "-");
                }
                if(cnpj > 17){
                    e.consume();
                    getToolkit().beep();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                try{
                    if(cnpj == 18){
                        if(!valida.isCNPJValido(txtCNPJ.getText())){
                            txtCNPJ.setText(null);
                            JOptionPane.showMessageDialog(null, "CNPJ digitado é inválido", "Aviso", 2);
                            cnpj = 0;
                        }
                    }                    
                }catch(Exception ex){
//                    JOptionPane.showMessageDialog(null, "Válido");
                }
            }
        });
        txtCNPJ.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {cnpj = txtCNPJ.getText().length();}

            @Override
            public void removeUpdate(DocumentEvent e) {cnpj = 0;}

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        txtNumero.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || 
                        (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if (c == '.' && txtNumero.getText().contains(".") ||
                        c == ',' && txtNumero.getText().contains(",")) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblCNPJ = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblRua = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCNPJ = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JFormattedTextField();
        txtComplemento = new javax.swing.JTextField();
        txtCEP = new javax.swing.JFormattedTextField();
        txtCidade = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtBusca = new javax.swing.JTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        lblCelular = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        lblRecarregar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fornecedor");
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

        lblNome.setText("Nome");

        lblCNPJ.setText("CNPJ");

        lblEmail.setText("Email");

        lblRua.setText("Rua");

        lblBairro.setText("Bairro");

        lblNumero.setText("Número");

        lblComplemento.setText("Complemento");

        lblCEP.setText("CEP");

        lblCidade.setText("Cidade");

        lblEstado.setText("Estado");

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE...", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CNPJ", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCelular.setText("Celular");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblTelefone.setText("Telefone");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblComplemento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCEP, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCNPJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAlterar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnNovo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnAdicionar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblCidade)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblEstado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCelular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecarregar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRecarregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCNPJ)
                            .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefone)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCelular)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNumero)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRua)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBairro)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblComplemento)
                            .addComponent(lblCEP)
                            .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCidade)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstado)
                            .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdicionar)
                            .addComponent(btnNovo)
                            .addComponent(btnExcluir)
                            .addComponent(btnAlterar))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpar();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        tabela(funFornecedor.buscaFornecedor(txtBusca.getText()));
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(txtNome.getText().isEmpty() && txtCNPJ.getText().isEmpty() && txtEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Campos de textos estão vazios\n\n"
                    + "Por favor insira os dados", "Aviso", 2);
        }else{
            if(verificaCNPJ(funFornecedor.tabela()) == true){
                JOptionPane.showMessageDialog(null,"CNPJ já cadastrado","Aviso",2);
                limpar();
            }else{
                Endereco endereco = new Endereco();

                endereco.setRua(txtRua.getText().toUpperCase());
                endereco.setComplemento(txtComplemento.getText().toUpperCase());
                endereco.setBairro(txtBairro.getText().toUpperCase());
                endereco.setCidade(txtCidade.getText().toUpperCase());

                if(comboEstado.getSelectedIndex() == 0){
                    endereco.setEstado(null);
                }else{
                    endereco.setEstado(comboEstado.getSelectedItem().toString());            
                }        
                if(txtNumero.getText().isEmpty()){
                    endereco.setNumero(0);
                }else{
                    endereco.setNumero(Integer.parseInt(txtNumero.getText()));
                }        
                if(txtCEP.getValue() == null){
                    endereco.setCep(null);
                }else{
                    endereco.setCep(txtCEP.getText());
                }

                funEndereco.inserirEndereco(endereco);

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setNome(txtNome.getText().toUpperCase());
                fornecedor.setCnpj(txtCNPJ.getText());
                fornecedor.setEmail(txtEmail.getText());

                if(txtTelefone.getValue() == null){
                    fornecedor.setTelefone(null);
                }else{
                    fornecedor.setTelefone(txtTelefone.getText());
                }
                if(txtCelular.getValue() == null){
                    fornecedor.setCelular(null);
                }else{
                    fornecedor.setCelular(txtCelular.getText());
                }

                funFornecedor.inserirFornecedor(fornecedor);

                limpar();

                tabela(funFornecedor.tabela());
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int linha = jTable1.getSelectedRow();
        
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        
        if(evt.getClickCount() == 1){
            btnExcluir.setEnabled(true);
            btnAdicionar.setEnabled(true);
        
            idFornecedor = Integer.parseInt(jTable1.getValueAt(linha, 0).toString());
            
            limpar();
        }
        
        if(evt.getClickCount() == 2){
            idFornecedor = Integer.parseInt(jTable1.getValueAt(linha, 0).toString());
                        
            alimentaFields(funFornecedor.dados(idFornecedor),
                           funEndereco.dados(idFornecedor, null, false));
            
            btnAlterar.setEnabled(true);
            btnAdicionar.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        funFornecedor.deletar(idFornecedor);
        
        tabela(funFornecedor.tabela());
        
        limpar();
        
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if(txtNome.getText().isEmpty() && txtCNPJ.getText().isEmpty() && txtEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Campos de textos estão vazios\n\n"
                    + "Por favor insira os dados", "Aviso", 2);
        }else{
            Endereco endereco = new Endereco();

            endereco.setRua(txtRua.getText().toUpperCase());
            endereco.setComplemento(txtComplemento.getText().toUpperCase());
            endereco.setBairro(txtBairro.getText().toUpperCase());
            endereco.setCidade(txtCidade.getText().toUpperCase());

            if(comboEstado.getSelectedIndex() == 0){
                endereco.setEstado(null);
            }else{
                endereco.setEstado(comboEstado.getSelectedItem().toString());            
            }        
            if(txtNumero.getText().isEmpty()){
                endereco.setNumero(0);
            }else{
                endereco.setNumero(Integer.parseInt(txtNumero.getText()));
            }        
            if(txtCEP.getValue() == null){
                endereco.setCep(null);
            }else{
                endereco.setCep(txtCEP.getText());
            }

            funEndereco.alterar(endereco, idFornecedor, false);

            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setNome(txtNome.getText().toUpperCase());
            fornecedor.setCnpj(txtCNPJ.getText());
            fornecedor.setEmail(txtEmail.getText());

            if(txtTelefone.getValue() == null){
                fornecedor.setTelefone(null);
            }else{
                fornecedor.setTelefone(txtTelefone.getText());
            }
            if(txtCelular.getValue() == null){
                fornecedor.setCelular(null);
            }else{
                fornecedor.setCelular(txtCelular.getText());
            }

            funFornecedor.alterar(fornecedor, idFornecedor);

            tabela(funFornecedor.tabela());

            limpar();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void lblRecarregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecarregarMouseClicked
        tabela(funFornecedor.tabela());
    }//GEN-LAST:event_lblRecarregarMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Menu x = new Menu();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnAdicionar.setEnabled(true);
        jTable1.clearSelection();
        
        limpar();
    }//GEN-LAST:event_formMouseClicked

    public void limpar(){
        txtNome.setText(null);
        txtCNPJ.setText(null);
        txtEmail.setText(null);
        txtTelefone.setText(null);
        txtCelular.setText(null);
        txtRua.setText(null);
        txtNumero.setText(null);
        txtComplemento.setText(null);
        txtBairro.setText(null);
        txtCidade.setText(null);
        comboEstado.setSelectedIndex(0);
        txtCEP.setText(null);
   }
    
    public void tabela(ArrayList<Fornecedor> fornecedor){
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for(Fornecedor x: fornecedor){
            model.addRow(new Object[]{
                x.getIdFornecedor(),
                x.getNome(),
                x.getCnpj(),
                x.getTelefone(),
                x.getEmail()
            });
        }        
    }
    
    public void ajustarTamanhoColunas() {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
    }
    
    public void alimentaFields(ArrayList<Fornecedor> fornecedor, 
                               ArrayList<Endereco> endereco){
        txtNome.setText(fornecedor.get(0).getNome());
        txtCNPJ.setText(fornecedor.get(0).getCnpj());
        txtEmail.setText(fornecedor.get(0).getEmail());
        txtTelefone.setText(fornecedor.get(0).getTelefone());
        txtCelular.setText(fornecedor.get(0).getCelular());
        
        txtRua.setText(endereco.get(0).getRua());
        txtNumero.setText(String.valueOf(endereco.get(0).getNumero()));
        txtComplemento.setText(endereco.get(0).getComplemento());
        txtBairro.setText(endereco.get(0).getBairro());
        txtCidade.setText(endereco.get(0).getCidade());
        txtCEP.setText(endereco.get(0).getCep());
        if(endereco.get(0).getEstado() == null){
            comboEstado.setSelectedIndex(0);
        }else{
            comboEstado.setSelectedItem(endereco.get(0).getEstado());
        }
    }
    
    public boolean verificaCNPJ(ArrayList<Fornecedor> fornecedor){
        for(int i=0;i<fornecedor.size();i++){
            if(txtCNPJ.getText().equals(fornecedor.get(i).getCnpj())){
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
            java.util.logging.Logger.getLogger(Fornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fornecedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fornecedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCNPJ;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRecarregar;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtNumero;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
