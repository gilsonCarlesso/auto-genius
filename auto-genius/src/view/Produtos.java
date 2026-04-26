
package view;

import control.MetodoEstoque;
import control.MetodoFornecedor_Produtos;
import control.MetodosFornecedor;
import control.MetodosProduto;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.Estoque;
import model.Fornecedor;
import model.Produto;

public class Produtos extends javax.swing.JFrame {
    MetodosProduto funProduto = new MetodosProduto();
    MetodoEstoque funEstoque = new MetodoEstoque();
    MetodosFornecedor funFornecedor = new MetodosFornecedor();
    MetodoFornecedor_Produtos funFornProd = new MetodoFornecedor_Produtos();
    DefaultTableModel model = new DefaultTableModel();
    
    int idProduto = 0;

    
    public Produtos() {
        initComponents();        
        tabela(funProduto.tabela());
        ajustarTamanhoColunas();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        combo();
        comboFornecedor();
        
        txtPrecoCusto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == ',' ||
                        (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if (c == '.' && txtPrecoCusto.getText().contains(".") ||
                        c == ',' && txtPrecoCusto.getText().contains(",")) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent evt) {}
        });
        txtPrecoVenda.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == ',' ||
                        (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if (c == '.' && txtPrecoVenda.getText().contains(".") ||
                        c == ',' && txtPrecoVenda.getText().contains(",")) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent evt) {}
        });
        txtCodigo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || 
                        (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if (c == '.' && txtCodigo.getText().contains(".") ||
                        c == ',' && txtCodigo.getText().contains(",")) {
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

        lblProduto = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblPrecoCusto = new javax.swing.JLabel();
        lblPrecoVenda = new javax.swing.JLabel();
        lblQntEstoque = new javax.swing.JLabel();
        lblQntEstoqueMininmo = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblArmazenamento = new javax.swing.JLabel();
        lblFornecedor = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtPrecoCusto = new javax.swing.JTextField();
        txtPrecoVenda = new javax.swing.JTextField();
        spinnerQntEstoque = new javax.swing.JSpinner();
        spinnerQntEstoqueMinimo = new javax.swing.JSpinner();
        comboCategoria = new javax.swing.JComboBox<>();
        comboArmazenamento = new javax.swing.JComboBox<>();
        comboFornecedor = new javax.swing.JComboBox<>();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtBusca = new javax.swing.JTextField();
        lblRecarregar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");
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

        lblProduto.setText("Nome do Produto");

        lblCodigo.setText("Código do Produto");

        lblDescricao.setText("Descrição");

        lblMarca.setText("Marca");

        lblPrecoCusto.setText("Preço de Custo");

        lblPrecoVenda.setText("Preço de Venda");

        lblQntEstoque.setText("Quantidade em Estoque");

        lblQntEstoqueMininmo.setText("Quantidade em Estoque Minímo");

        lblCategoria.setText("Categoria");

        lblArmazenamento.setText("Local de Armazenamento");

        lblFornecedor.setText("Fornecedor");

        spinnerQntEstoque.setModel(new javax.swing.SpinnerNumberModel());
        spinnerQntEstoque.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerQntEstoqueStateChanged(evt);
            }
        });

        spinnerQntEstoqueMinimo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerQntEstoqueMinimoStateChanged(evt);
            }
        });

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE...", "Eletrônico", "Mecânico" }));

        comboArmazenamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE..." }));

        comboFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE..." }));

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
                "ID", "Nome", "Marca", "Preço", "Quantidade em Estoque"
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(txtBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecarregar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCodigo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDescricao)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMarca)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPrecoCusto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblPrecoVenda)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblQntEstoque)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spinnerQntEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblQntEstoqueMininmo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spinnerQntEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCategoria)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnAlterar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnExcluir)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnNovo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAdicionar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblArmazenamento)
                                    .addComponent(lblFornecedor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboArmazenamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCodigo, txtDescricao, txtMarca, txtProduto});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboArmazenamento, comboCategoria});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtPrecoCusto, txtPrecoVenda});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblArmazenamento, lblCategoria, lblFornecedor});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblProduto)
                                .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescricao)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarca)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecoCusto)
                            .addComponent(txtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecoVenda)
                            .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQntEstoque)
                            .addComponent(spinnerQntEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQntEstoqueMininmo)
                            .addComponent(spinnerQntEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblArmazenamento)
                            .addComponent(comboArmazenamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFornecedor)
                            .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdicionar)
                            .addComponent(btnNovo)
                            .addComponent(btnExcluir)
                            .addComponent(btnAlterar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRecarregar)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        funProduto.deletar(idProduto);
        
        tabela(funProduto.tabela());
        
        limpar();
        
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpar();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(txtProduto.getText().isEmpty() && txtCodigo.getText().isEmpty() && 
            txtDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Campos de textos estão vazios\n\n"
                    + "Por favor insira os dados", "Aviso", 2);
        }else{
            if(txtPrecoCusto.getText().isEmpty() || txtPrecoVenda.getText().isEmpty() || 
                    comboArmazenamento.getSelectedIndex() == 0 || comboCategoria.getSelectedIndex() == 0 ||
                    comboFornecedor.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Contém campos que não foram preenchidos","Aviso", 2);
            }else{                
                Produto produto = new Produto();

                produto.setNomeProduto(txtProduto.getText().toUpperCase());
                if(txtCodigo.getText().isEmpty()){
                    produto.setNumeroProduto(0);
                }else{
                    produto.setNumeroProduto(Integer.parseInt(txtCodigo.getText()));
                }                
                produto.setDescricao(txtDescricao.getText().toUpperCase());
                produto.setMarca(txtMarca.getText().toUpperCase());
                produto.setPrecoCompra(Double.parseDouble(txtPrecoCusto.getText().replace(',','.')));
                produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText().replace(',','.')));
                produto.setQuantidadeEstoque(Integer.parseInt(spinnerQntEstoque.getValue().toString()));
                produto.setQuantidadeEstoqueMinimo(Integer.parseInt(spinnerQntEstoqueMinimo.getValue().toString()));
                produto.setCategoria(comboCategoria.getSelectedItem().toString());
                produto.setLocalArmazenamento(comboArmazenamento.getSelectedItem().toString());

                ArrayList<Estoque> estoque = funEstoque.tabela();

                for(Estoque x: estoque){
                    if(x.getLocalArmazenamento().equalsIgnoreCase(comboArmazenamento.getSelectedItem().toString())){
                        produto.setIdEstoque(x.getIdEstoque());
                    }
                }

                funProduto.inserirProduto(produto);

                ArrayList<Fornecedor> fornecedor = funFornecedor.tabela();
                int idFornecedor = 0;

                for(Fornecedor x: fornecedor){
                    if(x.getNome().equalsIgnoreCase(comboFornecedor.getSelectedItem().toString())){
                        idFornecedor = x.getIdFornecedor();
                    }
                }

                funFornProd.inserirFornecedor_Produtos(idFornecedor);

                limpar();

                tabela(funProduto.tabela());
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
        
            idProduto = Integer.parseInt(jTable1.getValueAt(linha, 0).toString());
            
            limpar();
        }
        
        if(evt.getClickCount() == 2){
            idProduto = Integer.parseInt(jTable1.getValueAt(linha, 0).toString());
                        
            alimentaFields(funProduto.dados(idProduto), funFornProd.dados(idProduto));
            
            btnAlterar.setEnabled(true);
            btnAdicionar.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if(txtProduto.getText().isEmpty() && txtCodigo.getText().isEmpty() && 
            txtDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Campos de textos estão vazios\n\n"
                    + "Por favor insira os dados", "Aviso", 2);
        }else{
            if(txtPrecoCusto.getText().isEmpty() || txtPrecoVenda.getText().isEmpty() || 
                    comboArmazenamento.getSelectedIndex() == 0 || comboCategoria.getSelectedIndex() == 0 ||
                    comboFornecedor.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Contém campos que não foram preenchidos","Aviso", 2);
            }else{
                Produto produto = new Produto();

                produto.setNomeProduto(txtProduto.getText().toUpperCase());
                if(txtCodigo.getText().isEmpty()){
                    produto.setNumeroProduto(0);
                }else{
                    produto.setNumeroProduto(Integer.parseInt(txtCodigo.getText()));
                }     
                produto.setDescricao(txtDescricao.getText().toUpperCase());
                produto.setMarca(txtMarca.getText().toUpperCase());
                produto.setPrecoCompra(Double.parseDouble(txtPrecoCusto.getText().replace(',','.')));
                produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText().replace(',','.')));
                produto.setQuantidadeEstoque(Integer.parseInt(spinnerQntEstoque.getValue().toString()));
                produto.setQuantidadeEstoqueMinimo(Integer.parseInt(spinnerQntEstoqueMinimo.getValue().toString()));
                produto.setCategoria(comboCategoria.getSelectedItem().toString());
                produto.setLocalArmazenamento(comboArmazenamento.getSelectedItem().toString());

                ArrayList<Estoque> estoque = funEstoque.tabela();

                for(Estoque x: estoque){
                    if(x.getLocalArmazenamento().equalsIgnoreCase(comboArmazenamento.getSelectedItem().toString())){
                        produto.setIdEstoque(x.getIdEstoque());
                    }
                }

                funProduto.alterar(produto, idProduto);

                ArrayList<Fornecedor> fornecedor = funFornecedor.tabela();
                int idFornecedor = 0;

                for(Fornecedor x: fornecedor){
                    if(x.getNome().equalsIgnoreCase(comboFornecedor.getSelectedItem().toString())){
                        idFornecedor = x.getIdFornecedor();
                    }
                }

                funFornProd.alterar(idFornecedor, idProduto);

                tabela(funProduto.tabela());
                limpar();
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnAdicionar.setEnabled(true);
        jTable1.clearSelection();
        
        limpar();
    }//GEN-LAST:event_formMouseClicked

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        tabela(funProduto.buscaProduto(txtBusca.getText()));
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void lblRecarregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecarregarMouseClicked
        tabela(funProduto.tabela());
    }//GEN-LAST:event_lblRecarregarMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Menu x = new Menu();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void spinnerQntEstoqueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerQntEstoqueStateChanged
        if(Integer.parseInt(spinnerQntEstoque.getValue().toString()) < 0){
            JOptionPane.showMessageDialog(null, "Não é possivel utilizar valor negativo", "Aviso", 2);
            spinnerQntEstoque.setValue(0);
        }
    }//GEN-LAST:event_spinnerQntEstoqueStateChanged

    private void spinnerQntEstoqueMinimoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerQntEstoqueMinimoStateChanged
        if(Integer.parseInt(spinnerQntEstoqueMinimo.getValue().toString()) < 0){
            JOptionPane.showMessageDialog(null, "Não é possivel utilizar valor negativo", "Aviso", 2);
            spinnerQntEstoqueMinimo.setValue(0);
        }
    }//GEN-LAST:event_spinnerQntEstoqueMinimoStateChanged

    public void limpar(){
        txtProduto.setText(null);
        txtCodigo.setText(null);
        txtDescricao.setText(null);
        txtMarca.setText(null);
        txtPrecoCusto.setText(null);
        txtPrecoVenda.setText(null);
        spinnerQntEstoque.setValue(0);
        spinnerQntEstoqueMinimo.setValue(0);
        comboCategoria.setSelectedIndex(0);
        comboArmazenamento.setSelectedIndex(0);
        comboFornecedor.setSelectedIndex(0);
    }
    
    public void tabela(ArrayList<Produto> produto){
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for(Produto x: produto){
            model.addRow(new Object[]{
                x.getIdProduto(),
                x.getNomeProduto(),
                x.getMarca(),
                x.getPrecoVenda(),
                x.getQuantidadeEstoque()
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
    
    public void alimentaFields(ArrayList<Produto> produto,
                               ArrayList<Fornecedor> fornecedor){
        txtProduto.setText(produto.get(0).getNomeProduto());
        txtCodigo.setText(String.valueOf(produto.get(0).getNumeroProduto()));
        txtDescricao.setText(produto.get(0).getDescricao());
        txtMarca.setText(produto.get(0).getMarca());
        txtPrecoCusto.setText(String.valueOf(produto.get(0).getPrecoCompra()));
        txtPrecoVenda.setText(String.valueOf(produto.get(0).getPrecoVenda()));
        spinnerQntEstoque.setValue(produto.get(0).getQuantidadeEstoque());
        spinnerQntEstoqueMinimo.setValue(produto.get(0).getQuantidadeEstoqueMinimo());
        comboCategoria.setSelectedItem(produto.get(0).getCategoria());
        comboArmazenamento.setSelectedItem(produto.get(0).getLocalArmazenamento());
        
        if(!fornecedor.isEmpty()){
            comboFornecedor.setSelectedItem(fornecedor.get(0).getNome());
        }else{
            comboFornecedor.setSelectedIndex(0);
        }
    }
    
    public void combo(){
        ArrayList<Estoque> estoque = new ArrayList<Estoque>();
        
        estoque = funEstoque.tabela();
        
        for(Estoque x: estoque){
            comboArmazenamento.addItem(x.getLocalArmazenamento());
        }
    }
    
    public void comboFornecedor(){
        ArrayList<Fornecedor> fornecedor = funFornecedor.tabela();
        
        for(Fornecedor x: fornecedor){
            comboFornecedor.addItem(x.getNome());
        }
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
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produtos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> comboArmazenamento;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboFornecedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblArmazenamento;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblPrecoCusto;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQntEstoque;
    private javax.swing.JLabel lblQntEstoqueMininmo;
    private javax.swing.JLabel lblRecarregar;
    private javax.swing.JSpinner spinnerQntEstoque;
    private javax.swing.JSpinner spinnerQntEstoqueMinimo;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPrecoCusto;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
