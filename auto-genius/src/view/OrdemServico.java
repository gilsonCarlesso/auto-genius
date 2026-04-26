
package view;

import control.MetodoProduto_Servico;
import control.MetodosCliente_Servico;
import control.MetodosPessoa;
import control.MetodosProduto;
import control.MetodosServico;
import control.MetodosServico_Funcionario;
import control.MetodosVeiculo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.Pessoa;
import model.Produto;
import model.Produto_Servico;
import model.Servico;
import model.Veiculo;


public class OrdemServico extends javax.swing.JFrame {
    MetodosPessoa funPessoa = new MetodosPessoa();
    MetodosProduto funProduto = new MetodosProduto();
    MetodosVeiculo funVeiculo = new MetodosVeiculo();
    MetodosServico funServico = new MetodosServico();
    MetodosCliente_Servico funCliSer = new MetodosCliente_Servico();
    MetodosServico_Funcionario funServFun = new MetodosServico_Funcionario();
    MetodoProduto_Servico funProSer =  new MetodoProduto_Servico();
    DefaultTableModel model = new DefaultTableModel();
    DefaultListModel<String> listModel = new DefaultListModel<>(); 
    
    int idCliente = 0;
    int idProduto = 0;
    double totalProduto = 0;
    boolean tela = false;

    
    public OrdemServico() {
        initComponents();
        tabelaCliente(funPessoa.tabela("cliente"));
        jTableCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProduto(funProduto.tabela());
        ajustarTamanhoColunas();
        comboFuncionario(funPessoa.tabela("funcionario"));
        txtValor.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == ',' ||
                        (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if (c == '.' && txtValor.getText().contains(".") ||
                        c == ',' && txtValor.getText().contains(",")) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent evt) {}
        });
        txtParcelas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || 
                        (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
                if (c == '.' && txtParcelas.getText().contains(".") ||
                        c == ',' && txtParcelas.getText().contains(",")) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    public void tabelaCliente(ArrayList<Pessoa> pessoa){
        model = (DefaultTableModel) jTableCliente.getModel();
        model.setRowCount(0);
        
        for(Pessoa x: pessoa){
            model.addRow(new Object[]{
                x.getIdPessoa(),
                x.getNome()
            });
        }     
    }
    
    public void ajustarTamanhoColunas() {
        jTableCliente.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableCliente.getColumnModel().getColumn(1).setPreferredWidth(500);
        jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableProduto.getColumnModel().getColumn(3).setPreferredWidth(70);
    }
    
    public void listaProduto(ArrayList<Produto> produto){        
        for(Produto x: produto){
            listModel.addElement(String.valueOf(x.getNumeroProduto())+" ("+ x.getDescricao()+")");
        }
        
        jListProduto.setModel(listModel);
    }
    
    public void comboFuncionario(ArrayList<Pessoa> pessoa){
        for(Pessoa x: pessoa){
            comboFuncionario.addItem(x.getNome());
        }
    }
    
    public void limpar(){
        txtCliente.setText(null);
        txtPlaca.setText(null);
        txtMarca.setText(null);
        txtNome.setText(null);
        txtAno.setText(null);
        txtModelo.setText(null);
        comboCor.setSelectedIndex(0);
        
        txtValor.setText(null);
        txtDescricao.setText(null);
        txtParcelas.setText(null);
        groupFormaPagamento.clearSelection();
        groupTipoPagamento.clearSelection();
        comboSituacao.setSelectedIndex(0);
        comboSituacao.setEnabled(true);
        
        comboFuncionario.setSelectedIndex(0);
        
        jTableCliente.clearSelection();
        jListProduto.clearSelection();
        
        model = (DefaultTableModel) jTableProduto.getModel();
        model.setRowCount(0);
    }
    
    public void inserirVeiculo(){
        Veiculo veiculo = new Veiculo();

        if(txtPlaca.getValue() == null){
            veiculo.setPlaca(null);
        }else{
            veiculo.setPlaca(txtPlaca.getText().toUpperCase());
        }
        veiculo.setMarca(txtMarca.getText().toUpperCase());
        veiculo.setNome(txtNome.getText().toUpperCase());

        if(txtAno.getValue() == null){
            veiculo.setAno(0);
        }else{
            veiculo.setAno(Integer.parseInt(txtAno.getText()));
        }

        veiculo.setModelo(txtModelo.getText().toUpperCase());
        veiculo.setCor(comboCor.getSelectedItem().toString());

        funVeiculo.inserirVeiculo(veiculo);
        
    }
    
    public void inserirServico(){
        Servico servico = new Servico();
        
        servico.setDescricao(txtDescricao.getText().toUpperCase());
        servico.setPreco(Double.parseDouble(txtValor.getText()) + totalProduto);
        servico.setCondicaoPagamento(txtParcelas.getText().toUpperCase());
        servico.setSituacao(comboSituacao.getSelectedItem().toString());

        // Forma de Pagamento
        if(rbDebito.isSelected()){
            servico.setFormaPagamento("DÉBITO");
        }if(rbCredito.isSelected()){
            servico.setFormaPagamento("CRÉDITO");
        }if(rbPix.isSelected()){
            servico.setFormaPagamento("PIX");
        }if(rbTransferencia.isSelected()){
            servico.setFormaPagamento("TRRANSFERÊNCIA");
        }if(rbDinheiro.isSelected()){
            servico.setFormaPagamento("DINHERIO");
        }if(rbBoleto.isSelected()){
            servico.setFormaPagamento("BOLETO");
        }
        
        // Tipo de pagamento
        if(rbAvista.isSelected()){
            servico.setTipoPagamento("Á VISTA");
        }if(rbAprazo.isSelected()){
            servico.setTipoPagamento("Á PRAZO");
        }
        
        funServico.inserirOrdemServico(servico);
    }
    
    public int idFuncionario(ArrayList<Pessoa> pessoa){
        int idFuncionario = 0;
        
        for(Pessoa x: pessoa){
            if(x.getNome().equalsIgnoreCase(comboFuncionario.getSelectedItem().toString())){
                idFuncionario = funServico.retornaId("funcionario", x.getIdPessoa());
            }
        }
        return idFuncionario;
    }
    
    public void retornaValor(){
        Pagamento x = new Pagamento();

        double total = Double.parseDouble(txtValor.getText().replace(',', '.')) + totalProduto;
        double valor = total;

        if(rbAprazo.isSelected()){
            valor = valor / Integer.parseInt(txtParcelas.getText());
        }

        x.total(valor, total);

        x.setVisible(true);
    }
    
    public void addCliente(String nome){
        ArrayList<Pessoa> pessoa = funPessoa.buscaPessoa(nome, "cliente");
        
        idCliente = pessoa.get(0).getIdPessoa();
        txtCliente.setText(pessoa.get(0).getNome());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupFormaPagamento = new javax.swing.ButtonGroup();
        groupTipoPagamento = new javax.swing.ButtonGroup();
        jPanelCliente = new javax.swing.JPanel();
        lblCor = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtAno = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JFormattedTextField();
        txtCliente = new javax.swing.JTextField();
        comboCor = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        lblAdicionar = new javax.swing.JLabel();
        jPanelOrderServico = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblFormaPagamento = new javax.swing.JLabel();
        lblTipoPagamento = new javax.swing.JLabel();
        lblParcelas = new javax.swing.JLabel();
        lblSituacao = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtParcelas = new javax.swing.JTextField();
        comboSituacao = new javax.swing.JComboBox<>();
        rbDebito = new javax.swing.JRadioButton();
        rbCredito = new javax.swing.JRadioButton();
        rbPix = new javax.swing.JRadioButton();
        rbTransferencia = new javax.swing.JRadioButton();
        rbDinheiro = new javax.swing.JRadioButton();
        rbBoleto = new javax.swing.JRadioButton();
        rbAvista = new javax.swing.JRadioButton();
        rbAprazo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jPanelProduto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListProduto = new javax.swing.JList<>();
        btnRemover = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        lblFuncionario = new javax.swing.JLabel();
        comboFuncionario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordem de Serviço");
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

        jPanelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados Cliente"));

        lblCor.setText("Cor");

        lblModelo.setText("Modelo");

        lblAno.setText("Ano");

        lblNome.setText("Nome");

        lblMarca.setText("Marca");

        lblPlaca.setText("Placa");

        lblCliente.setText("Cliente");

        try {
            txtAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAA-#A##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtCliente.setEditable(false);

        comboCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE...", "Branco", "Preto", "Prata", "Cinza", "Vermelho", "Azul", "Verde", "Amarelo", "Laranja", "Marrom", "Bege", "Roxo", "Dourado", "Bronze", "Creme" }));

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClienteMouseClicked(evt);
            }
        });
        jTableCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableClienteKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jTableCliente);

        lblAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar-24px.png"))); // NOI18N
        lblAdicionar.setToolTipText("adicionar cliente");
        lblAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdicionarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelClienteLayout = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(jPanelClienteLayout);
        jPanelClienteLayout.setHorizontalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addComponent(lblCor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addComponent(lblMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addComponent(lblAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addComponent(lblModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelClienteLayout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelClienteLayout.createSequentialGroup()
                                .addComponent(lblPlaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAdicionar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jPanelClienteLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblAno, lblCliente, lblCor, lblMarca, lblModelo, lblNome, lblPlaca});

        jPanelClienteLayout.setVerticalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCliente)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAdicionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlaca)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarca)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAno)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblModelo)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCor)
                            .addComponent(comboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE))))
        );

        jPanelOrderServico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ordem Serviço"));

        lblDescricao.setText("Descrição");

        lblValor.setText("Mão de Obra");

        lblFormaPagamento.setText("Forma de Pagamento");

        lblTipoPagamento.setText("Tipo de Pagamento");

        lblParcelas.setText("Parcelas");

        lblSituacao.setText("Situação");

        comboSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE...", "PAGO", "AGUARDANDO" }));

        groupFormaPagamento.add(rbDebito);
        rbDebito.setText("Débito");
        rbDebito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbDebitoMouseClicked(evt);
            }
        });

        groupFormaPagamento.add(rbCredito);
        rbCredito.setText("Crédito");
        rbCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbCreditoMouseClicked(evt);
            }
        });

        groupFormaPagamento.add(rbPix);
        rbPix.setText("Pix");
        rbPix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbPixMouseClicked(evt);
            }
        });

        groupFormaPagamento.add(rbTransferencia);
        rbTransferencia.setText("Transferência");
        rbTransferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbTransferenciaMouseClicked(evt);
            }
        });

        groupFormaPagamento.add(rbDinheiro);
        rbDinheiro.setText("Dinheiro");
        rbDinheiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbDinheiroMouseClicked(evt);
            }
        });

        groupFormaPagamento.add(rbBoleto);
        rbBoleto.setText("Boleto");
        rbBoleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbBoletoMouseClicked(evt);
            }
        });

        groupTipoPagamento.add(rbAvista);
        rbAvista.setText("Á vista");
        rbAvista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbAvistaMouseClicked(evt);
            }
        });

        groupTipoPagamento.add(rbAprazo);
        rbAprazo.setText("Á prazo");
        rbAprazo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbAprazoMouseClicked(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        txtDescricao.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jScrollPane1.setViewportView(txtDescricao);

        javax.swing.GroupLayout jPanelOrderServicoLayout = new javax.swing.GroupLayout(jPanelOrderServico);
        jPanelOrderServico.setLayout(jPanelOrderServicoLayout);
        jPanelOrderServicoLayout.setHorizontalGroup(
            jPanelOrderServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderServicoLayout.createSequentialGroup()
                .addComponent(rbDebito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbCredito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPix)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAprazo)
                    .addGroup(jPanelOrderServicoLayout.createSequentialGroup()
                        .addComponent(rbTransferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDinheiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbBoleto)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelOrderServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOrderServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelOrderServicoLayout.createSequentialGroup()
                        .addGroup(jPanelOrderServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescricao)
                            .addGroup(jPanelOrderServicoLayout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblFormaPagamento)
                            .addGroup(jPanelOrderServicoLayout.createSequentialGroup()
                                .addComponent(lblTipoPagamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbAvista))
                            .addGroup(jPanelOrderServicoLayout.createSequentialGroup()
                                .addComponent(lblParcelas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSituacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelOrderServicoLayout.setVerticalGroup(
            jPanelOrderServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderServicoLayout.createSequentialGroup()
                .addGroup(jPanelOrderServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFormaPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDebito)
                    .addComponent(rbCredito)
                    .addComponent(rbPix)
                    .addComponent(rbTransferencia)
                    .addComponent(rbDinheiro)
                    .addComponent(rbBoleto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoPagamento)
                    .addComponent(rbAvista)
                    .addComponent(rbAprazo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParcelas)
                    .addComponent(txtParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSituacao)
                    .addComponent(comboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Produto"));

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Descrição", "Valor", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProduto);
        jTableProduto.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jListProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProdutoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListProduto);

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remover-16px.png"))); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProdutoLayout = new javax.swing.GroupLayout(jPanelProduto);
        jPanelProduto.setLayout(jPanelProdutoLayout);
        jPanelProdutoLayout.setHorizontalGroup(
            jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProdutoLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnRemover, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelProdutoLayout.setVerticalGroup(
            jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutoLayout.createSequentialGroup()
                .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover))
        );

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar-24px.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo-24px.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        lblFuncionario.setText("Funcionário");

        comboFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE..." }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelOrderServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFuncionario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 136, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelOrderServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFuncionario)
                            .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnNovo))))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClienteMouseClicked
        int linha = jTableCliente.getSelectedRow();
        
        if(evt.getClickCount() == 1){        
            idCliente = Integer.parseInt(jTableCliente.getValueAt(linha, 0).toString());
            txtCliente.setText(jTableCliente.getValueAt(linha, 1).toString());
        }
    }//GEN-LAST:event_jTableClienteMouseClicked

    private void jListProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProdutoMouseClicked
        ArrayList<Produto> checklist = funProduto.tabela();
        model = (DefaultTableModel) jTableProduto.getModel();
        
        if(evt.getClickCount() == 2){
            String selecionado = jListProduto.getSelectedValue();
            
            for(Produto x: checklist){
                if(selecionado.equals(String.valueOf(x.getNumeroProduto())+" ("+ x.getDescricao()+")")){
                    model.addRow(new Object[]{
                        x.getIdProduto(),
                        x.getNumeroProduto(),
                        x.getDescricao(),
                        x.getPrecoVenda()
                    });
                }
            }
        }        
    }//GEN-LAST:event_jListProdutoMouseClicked

    private void jTableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutoMouseClicked
        if(evt.getClickCount() == 1){
            btnRemover.setEnabled(true);    
        }
    }//GEN-LAST:event_jTableProdutoMouseClicked

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        model = (DefaultTableModel) jTableProduto.getModel();
        int[] linha = jTableProduto.getSelectedRows();
        
        for(int i=linha.length-1;i>=0;i--){
            model.removeRow(linha[i]);  
        }
        
        btnRemover.setEnabled(false);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       btnRemover.setEnabled(false);
    }//GEN-LAST:event_formMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpar();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // Pegando informações da tabela Produto
        model = (DefaultTableModel) jTableProduto.getModel();        
        ArrayList<Produto_Servico> listaProdutoServico = new ArrayList<>();        
        ArrayList<Produto> listaProduto = funProduto.tabela();
        ArrayList<Produto> updateProduto = new ArrayList<>();
        int op = 0;
        totalProduto = 0;
        
        if(txtCliente.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Por favor informe o cliente","Aviso",2);
                        op = 1;
        }else{
            if(txtPlaca.getValue() == null && txtMarca.getText().isEmpty() && txtNome.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Informe os dados do veículo","Aviso",2);
                op = 1;
            }else{
                if(comboCor.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null,"Informe a cor do veículo","Aviso", 2);
                    op = 1;
                }else{                    
                    if(txtValor.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Informe o valor da mão de obra","Aviso",2);
                        op = 1;
                    }else{
                        if(txtParcelas.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Informe o número de parcelas","Aviso",2);
                            op = 1;
                        }else{
                            if(comboSituacao.getSelectedIndex() == 0){
                                JOptionPane.showMessageDialog(null,"Informe a situação do pagamneto","Aviso",2);
                                op = 1;
                            }else{
                                if(comboFuncionario.getSelectedIndex() == 0){
                                    JOptionPane.showMessageDialog(null,"Informe o funcionário que realizou o serviço","Aviso",2);
                                    op = 1;
                                }else{
                                    if(jTableProduto.getRowCount() > 0){
                                        for (int i=0;i<model.getRowCount();i++) {
                                            Produto_Servico produtoServico = new Produto_Servico();

                                            if(model.getValueAt(i, 4) == null){
                                                JOptionPane.showMessageDialog(null,"Por favor informe a quantidade de produtos utilizados","Aviso",2);
                                                op = 1;
                                                
                                                break;
                                            }else{
                                                int id = Integer.parseInt(String.valueOf(model.getValueAt(i, 0)));
                                                int qntRequerida = Integer.parseInt(String.valueOf(model.getValueAt(i, 4)));

                                                if(qntRequerida < 0){
                                                    JOptionPane.showMessageDialog(null,"Foram informado valores negativos na tabela produto!","Aviso",2);
                                                    op = 1;

                                                    for(int c=0;c<jTableProduto.getRowCount();c++){
                                                        jTableProduto.setValueAt(null, c, 4);
                                                    }

                                                    break;
                                                }else{
                                                    produtoServico.setIdProduto(id);
                                                    produtoServico.setQuantidadeRequerida(qntRequerida);

                                                    listaProdutoServico.add(produtoServico);

                                                    totalProduto += Double.parseDouble(String.valueOf(model.getValueAt(i, 3))) *
                                                            Integer.parseInt(String.valueOf(model.getValueAt(i, 4)));

                                                    // Update Quantidade de produtos     
                                                    Produto produto = new Produto();
                                                    if(id == listaProduto.get(i).getIdProduto()){                
                                                        int produtoEstoque = listaProduto.get(i).getQuantidadeEstoque();
                                                        int estoqueAtual = produtoEstoque - qntRequerida;

                                                        if(estoqueAtual < 0){
                                                            JOptionPane.showMessageDialog(null, 
                                                                    listaProduto.get(i).getNomeProduto() +" "+ 
                                                                    listaProduto.get(i).getDescricao()+ " com "
                                                                    + "estoque insuficiente\n\nQuantidade disponível: "+
                                                                    produtoEstoque+"\n\nQuantidade desejada: "+ 
                                                                    qntRequerida, "Aviso", 2);

                                                            op = 1;
                                                        }else{
                                                            produto.setIdProduto(id);
                                                            produto.setQuantidadeEstoque(estoqueAtual);

                                                            updateProduto.add(produto);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            

            if(op == 0){                            
                for(Produto x: updateProduto){
                    funProduto.updateProduto(x.getQuantidadeEstoque(), x.getIdProduto());
                }

                retornaValor();

                // Inserindo dados na tabela veiculo
                inserirVeiculo();

                // Inserindo dados na tabela serviço
                inserirServico();

                // Inserindo dados na tabela Cliente_Servico
                funCliSer.inserirCliente_Servico(funServico.retornaId("cliente", idCliente));

                // Inserindo dados na tabela Servico_Funcionario
                funServFun.inserirServico_Funcionario(idFuncionario(funPessoa.tabela("funcionario")));


                // Inserindo dados na tabela Produto_Servico
                for(Produto_Servico x: listaProdutoServico){
                    funProSer.inserirProduto_Servico(x.getIdProduto(), x.getQuantidadeRequerida());            
                }
                limpar();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void rbAvistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbAvistaMouseClicked
        if(rbAvista.isSelected()){
            txtParcelas.setText("1");
            txtParcelas.setEditable(false);
            comboSituacao.setSelectedIndex(1);
            comboSituacao.setEnabled(false);
        }
    }//GEN-LAST:event_rbAvistaMouseClicked

    private void rbAprazoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbAprazoMouseClicked
        if(rbAprazo.isSelected()){
            txtParcelas.setText(null);
            txtParcelas.setEditable(true);
            comboSituacao.setSelectedIndex(2);
            comboSituacao.setEnabled(false);
        }
        
        if(rbCredito.isSelected()){
            comboSituacao.setSelectedIndex(1);
            comboSituacao.setEnabled(false);
        }
    }//GEN-LAST:event_rbAprazoMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(tela == false){
            Menu x = new Menu();
            x.setExtendedState(JFrame.MAXIMIZED_BOTH);
            x.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosed

    private void lblAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdicionarMouseClicked
        AdicionarCliente x = new AdicionarCliente();
        x.setVisible(true);
        tela = true;
        dispose();
    }//GEN-LAST:event_lblAdicionarMouseClicked

    private void jTableClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableClienteKeyPressed
        try{
            if(evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_KP_DOWN){ 
                 int linha = jTableCliente.getSelectedRow() + 1;

                idCliente = Integer.parseInt(jTableCliente.getValueAt(linha, 0).toString());
                txtCliente.setText(jTableCliente.getValueAt(linha, 1).toString());        
            }

            if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_KP_UP){
                 int linha = jTableCliente.getSelectedRow() - 1;

                idCliente = Integer.parseInt(jTableCliente.getValueAt(linha, 0).toString());
                txtCliente.setText(jTableCliente.getValueAt(linha, 1).toString());  
            }
        }catch(Exception e){}
    }//GEN-LAST:event_jTableClienteKeyPressed

    private void rbPixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbPixMouseClicked
        if(rbPix.isSelected()){
            rbAvista.setSelected(true);
            rbAprazo.setEnabled(false);
            txtParcelas.setText("1");
            txtParcelas.setEditable(false);
            comboSituacao.setSelectedIndex(1);
            comboSituacao.setEnabled(false);
        }
    }//GEN-LAST:event_rbPixMouseClicked

    private void rbDebitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbDebitoMouseClicked
        if(rbDebito.isSelected()){
            rbAvista.setSelected(true);
            rbAprazo.setEnabled(false);
            txtParcelas.setText("1");
            txtParcelas.setEditable(false);
            comboSituacao.setSelectedIndex(1);
            comboSituacao.setEnabled(false);
        }
    }//GEN-LAST:event_rbDebitoMouseClicked

    private void rbCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbCreditoMouseClicked
        if(rbCredito.isSelected()){
            groupTipoPagamento.clearSelection();
            rbAprazo.setEnabled(true);
            txtParcelas.setText(null);
            txtParcelas.setEditable(true);
            comboSituacao.setSelectedIndex(0);
            comboSituacao.setEnabled(true);
        }
    }//GEN-LAST:event_rbCreditoMouseClicked

    private void rbTransferenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbTransferenciaMouseClicked
        if(rbTransferencia.isSelected()){
            groupTipoPagamento.clearSelection();
            rbAprazo.setEnabled(true);
            txtParcelas.setText(null);
            txtParcelas.setEditable(true);
            comboSituacao.setSelectedIndex(0);
            comboSituacao.setEnabled(true);
        }
    }//GEN-LAST:event_rbTransferenciaMouseClicked

    private void rbDinheiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbDinheiroMouseClicked
        if(rbDinheiro.isSelected()){
            groupTipoPagamento.clearSelection();
            rbAprazo.setEnabled(true);
            txtParcelas.setText(null);
            txtParcelas.setEditable(true);
            comboSituacao.setSelectedIndex(0);
            comboSituacao.setEnabled(true);
        }
    }//GEN-LAST:event_rbDinheiroMouseClicked

    private void rbBoletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbBoletoMouseClicked
        if(rbBoleto.isSelected()){
            groupTipoPagamento.clearSelection();
            rbAprazo.setEnabled(true);
            txtParcelas.setText(null);
            txtParcelas.setEditable(true);
            comboSituacao.setSelectedIndex(0);
            comboSituacao.setEnabled(true);
        }
    }//GEN-LAST:event_rbBoletoMouseClicked

    
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
            java.util.logging.Logger.getLogger(OrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdemServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboCor;
    private javax.swing.JComboBox<String> comboFuncionario;
    private javax.swing.JComboBox<String> comboSituacao;
    private javax.swing.ButtonGroup groupFormaPagamento;
    private javax.swing.ButtonGroup groupTipoPagamento;
    private javax.swing.JList<String> jListProduto;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelOrderServico;
    private javax.swing.JPanel jPanelProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JLabel lblAdicionar;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblParcelas;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JLabel lblTipoPagamento;
    private javax.swing.JLabel lblValor;
    private javax.swing.JRadioButton rbAprazo;
    private javax.swing.JRadioButton rbAvista;
    private javax.swing.JRadioButton rbBoleto;
    private javax.swing.JRadioButton rbCredito;
    private javax.swing.JRadioButton rbDebito;
    private javax.swing.JRadioButton rbDinheiro;
    private javax.swing.JRadioButton rbPix;
    private javax.swing.JRadioButton rbTransferencia;
    private javax.swing.JFormattedTextField txtAno;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtParcelas;
    private javax.swing.JFormattedTextField txtPlaca;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
