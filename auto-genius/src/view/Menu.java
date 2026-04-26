
package view;

import control.MetodosRelatorio;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Menu extends javax.swing.JFrame {
    MetodosRelatorio funRelatorio = new MetodosRelatorio();

    
    public Menu() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInferior = new javax.swing.JPanel();
        lblSair = new javax.swing.JLabel();
        panelSuperior = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        lblFuncionario = new javax.swing.JLabel();
        lblFornecedor = new javax.swing.JLabel();
        lblVeiculo = new javax.swing.JLabel();
        lblProduto = new javax.swing.JLabel();
        lblConsultaProduto = new javax.swing.JLabel();
        lblEstoque = new javax.swing.JLabel();
        lblRelatorio = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnNovo = new javax.swing.JButton();
        btnPendentes = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnFinalizados = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemFuncionario = new javax.swing.JMenuItem();
        jMenuItemFornecedor = new javax.swing.JMenuItem();
        jMenuItemProduto = new javax.swing.JMenuItem();
        jMenuItemEstoque = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        jMenuItemServico = new javax.swing.JMenuItem();
        jMenuItemVeiculo = new javax.swing.JMenuItem();
        jMenuItemRelatorioProduto = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        panelInferior.setBackground(new java.awt.Color(204, 204, 204));

        lblSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/desligar-32px.png"))); // NOI18N
        lblSair.setText("Encerrar Sessão");
        lblSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSair.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSair)
                .addContainerGap())
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblSair)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panelSuperior.setBackground(new java.awt.Color(204, 204, 204));

        lblCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente-64px.png"))); // NOI18N
        lblCliente.setText("Cliente");
        lblCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClienteMouseClicked(evt);
            }
        });

        lblFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/funcionario-64px.png"))); // NOI18N
        lblFuncionario.setText("Funcionário");
        lblFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFuncionario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFuncionario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFuncionarioMouseClicked(evt);
            }
        });

        lblFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fornecedor-64px.png"))); // NOI18N
        lblFornecedor.setText("Fornecedor");
        lblFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFornecedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFornecedorMouseClicked(evt);
            }
        });

        lblVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/veiculo-64px.png"))); // NOI18N
        lblVeiculo.setText("Veículo");
        lblVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVeiculoMouseClicked(evt);
            }
        });

        lblProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/produtos-64px.png"))); // NOI18N
        lblProduto.setText("Produtos");
        lblProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProdutoMouseClicked(evt);
            }
        });

        lblConsultaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorio-produto-64px.png"))); // NOI18N
        lblConsultaProduto.setText("Consultar");
        lblConsultaProduto.setToolTipText("");
        lblConsultaProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblConsultaProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblConsultaProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblConsultaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConsultaProdutoMouseClicked(evt);
            }
        });

        lblEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estoque-64px.png"))); // NOI18N
        lblEstoque.setText("Estoque");
        lblEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEstoque.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblEstoque.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEstoqueMouseClicked(evt);
            }
        });

        lblRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorio-64px.png"))); // NOI18N
        lblRelatorio.setText("Relatório");
        lblRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRelatorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRelatorioMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCliente)
                .addGap(18, 18, 18)
                .addComponent(lblFuncionario)
                .addGap(18, 18, 18)
                .addComponent(lblFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVeiculo)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProduto)
                .addGap(18, 18, 18)
                .addComponent(lblConsultaProduto)
                .addGap(18, 18, 18)
                .addComponent(lblEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRelatorio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblConsultaProduto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuncionario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFornecedor, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstoque, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRelatorio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblVeiculo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nova-ordem-128px.png"))); // NOI18N
        btnNovo.setText("Nova Ordem de Serviço");
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnPendentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar-pendentes-128px.png"))); // NOI18N
        btnPendentes.setText("Pesquisar Pendentes");
        btnPendentes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendentesActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar-ordem-128px.png"))); // NOI18N
        btnAlterar.setText("Alterar Ordem de Serviço");
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnFinalizados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar-finalizados-128px.png"))); // NOI18N
        btnFinalizados.setText("Pesquisar Finalizados");
        btnFinalizados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFinalizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizadosActionPerformed(evt);
            }
        });

        menuCadastro.setText("Cadastro");

        jMenuItemCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCliente.setText("Cliente");
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItemCliente);

        jMenuItemFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemFuncionario.setText("Funcionário");
        jMenuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItemFuncionario);

        jMenuItemFornecedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemFornecedor.setText("Fornecedor");
        jMenuItemFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFornecedorActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItemFornecedor);

        jMenuItemProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemProduto.setText("Produto");
        jMenuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutoActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItemProduto);

        jMenuItemEstoque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemEstoque.setText("Estoque");
        jMenuItemEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstoqueActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItemEstoque);
        menuCadastro.add(jSeparator);

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItemSair);

        menuBar.add(menuCadastro);

        menuRelatorio.setText("Relatório");

        jMenuItemServico.setText("Serviços");
        jMenuItemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemServicoActionPerformed(evt);
            }
        });
        menuRelatorio.add(jMenuItemServico);

        jMenuItemVeiculo.setText("Veículos");
        jMenuItemVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVeiculoActionPerformed(evt);
            }
        });
        menuRelatorio.add(jMenuItemVeiculo);

        jMenuItemRelatorioProduto.setText("Produtos");
        jMenuItemRelatorioProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelatorioProdutoActionPerformed(evt);
            }
        });
        menuRelatorio.add(jMenuItemRelatorioProduto);

        menuBar.add(menuRelatorio);

        menuSobre.setText("Sobre");

        jMenuItemSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemSobre.setText("Sobre");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        menuSobre.add(jMenuItemSobre);

        menuBar.add(menuSobre);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo)
                    .addComponent(btnPendentes))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar)
                    .addComponent(btnFinalizados))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnFinalizados, btnNovo, btnPendentes});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnPendentes))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAlterar, btnFinalizados, btnNovo, btnPendentes});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClienteMouseClicked
        Clientes x = new Clientes();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblClienteMouseClicked

    private void lblFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFuncionarioMouseClicked
        Funcionarios x = new Funcionarios();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblFuncionarioMouseClicked

    private void lblFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFornecedorMouseClicked
        Fornecedores x = new Fornecedores();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblFornecedorMouseClicked

    private void lblVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVeiculoMouseClicked
        RelatorioVeiculos x = new RelatorioVeiculos();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblVeiculoMouseClicked

    private void lblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProdutoMouseClicked
        Produtos x = new Produtos();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblProdutoMouseClicked

    private void lblConsultaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultaProdutoMouseClicked
        RelatorioProduto x = new RelatorioProduto();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblConsultaProdutoMouseClicked

    private void lblEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEstoqueMouseClicked
        Estoques x = new Estoques();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_lblEstoqueMouseClicked

    private void lblRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRelatorioMouseClicked
        Relatorio x = new Relatorio();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblRelatorioMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        OrdemServico x = new OrdemServico();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void lblSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSairMouseClicked
        int op = JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", 
                "Confirmação", JOptionPane.YES_NO_OPTION, 2);
        if(op == JOptionPane.YES_OPTION){
            Login x = new Login();
            x.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_lblSairMouseClicked

    private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
        Clientes x = new Clientes();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemClienteActionPerformed

    private void jMenuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionarioActionPerformed
        Funcionarios x = new Funcionarios();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemFuncionarioActionPerformed

    private void jMenuItemFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFornecedorActionPerformed
        Fornecedores x = new Fornecedores();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemFornecedorActionPerformed

    private void jMenuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutoActionPerformed
        Produtos x = new Produtos();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemProdutoActionPerformed

    private void jMenuItemEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstoqueActionPerformed
        Estoques x = new Estoques();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemEstoqueActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemServicoActionPerformed
        Relatorio x = new Relatorio();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemServicoActionPerformed

    private void jMenuItemVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVeiculoActionPerformed
        RelatorioVeiculos x = new RelatorioVeiculos();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemVeiculoActionPerformed

    private void jMenuItemRelatorioProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelatorioProdutoActionPerformed
        RelatorioProduto x = new RelatorioProduto();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItemRelatorioProdutoActionPerformed

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
        String sobre = "Bem-vindo ao Auto Genius\n" +
            "\n" +
            "O Auto Genius é uma plataforma dedicada para realização de cadastros de clientes, veículos e fornecedor, \n"
            + "produtos, contendo um controle de estoque simples. Nosso objetivo é proporcionar uma experiência eficiente e eficaz para .\n"
            + "oficinas mecânica. \n\n"
            + "Desenvolvido por: Gilson Carlesso da Silveira\n"
            + "Este projeto foi desenvolvido para ser apresentado como trabalho de conclusão de curso (TCC)";
        JOptionPane.showMessageDialog(null, sobre, "Sobre", 1);
    }//GEN-LAST:event_jMenuItemSobreActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        Relatorio x = new Relatorio();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnPendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendentesActionPerformed
        Relatorio x = new Relatorio();
        x.tabelaFiltrada(funRelatorio.relatorioFiltrado(null,"AGUARDANDO", false));
        x.op = 1;
        x.situacao = "AGUARDANDO";
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPendentesActionPerformed

    private void btnFinalizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizadosActionPerformed
        Relatorio x = new Relatorio();
        x.tabelaFiltrada(funRelatorio.relatorioFiltrado(null,"PAGO", false));
        x.op = 1;
        x.situacao = "PAGO";
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnFinalizadosActionPerformed

    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Menu().setVisible(true);
                Menu menu = new Menu();
                menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
                menu.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnFinalizados;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPendentes;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemEstoque;
    private javax.swing.JMenuItem jMenuItemFornecedor;
    private javax.swing.JMenuItem jMenuItemFuncionario;
    private javax.swing.JMenuItem jMenuItemProduto;
    private javax.swing.JMenuItem jMenuItemRelatorioProduto;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemServico;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenuItem jMenuItemVeiculo;
    private javax.swing.JPopupMenu.Separator jSeparator;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblConsultaProduto;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblRelatorio;
    private javax.swing.JLabel lblSair;
    private javax.swing.JLabel lblVeiculo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
