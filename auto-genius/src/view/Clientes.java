
package view;

import control.MetodosCliente;
import control.MetodosEndereco;
import control.MetodosPessoa;
import control.Validacoes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Cliente;
import model.Pessoa;


public class Clientes extends javax.swing.JFrame {
    MetodosEndereco funEndereco = new MetodosEndereco();
    MetodosPessoa funPessoa = new MetodosPessoa();
    MetodosCliente funCliente = new MetodosCliente();
    DefaultTableModel model = new DefaultTableModel();
    Validacoes valida = new Validacoes();
    
    int idPessoa = 0;
    int aux = 0;
    int data = 1;
    boolean caractere = false;
    
    public Clientes() {
        initComponents();
        tabela(funPessoa.tabela("cliente"));
        ajustarTamanhoColunas();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        txtNumeroRegistro.setText(String.valueOf(funCliente.numeroRegistro() + 1));        
        txtData.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if(data == 2 || data == 5){
                        txtData.setText(txtData.getText() + "/");
                    }
                    if(data > 9){
                        e.consume();
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {}

                @Override
                public void keyReleased(KeyEvent e) {
                    String dataNascimento = txtData.getText();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dateFormat.setLenient(false); // Desativa o modo tolerante para dias que não contém no calendário
                    if(data == 10){
                        try {
                            Date inputDate = dateFormat.parse(dataNascimento);
                            Date currentDate = new Date();

                            // Verifica se a data inserida é futura
                            if (inputDate.after(currentDate)) {
                                JOptionPane.showMessageDialog(null, "Não é possível inserir uma data futura","Aviso", 2);
                                txtData.setText(null); // Limpa o campo se a data for futura
                            }
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(null,"Data inserida inválida","Aviso", 2);
                            txtData.setText(null);
                            data = 0;
                        }
                    }
                }
            });
        txtData.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {data = txtData.getText().length();}

            @Override
            public void removeUpdate(DocumentEvent e) {data = 0;}

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
        txtCPF.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                if(aux > 13){
                    e.consume();
                    getToolkit().beep();
                }                
                if(aux == 3 || aux == 7){
                    String cpf = txtCPF.getText() + ".";
                    txtCPF.setText(cpf);
                }
                if(aux == 11){
                    String cpf = txtCPF.getText() + "-";
                    txtCPF.setText(cpf);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {                
                try{
                    if(aux == 14){
                        if(!valida.isCPFValido(txtCPF.getText())){
                            txtCPF.setText(null);
                            JOptionPane.showMessageDialog(null, "CPF digitado é inválido", "Aviso", 2);
                            aux = 0;
                        }
                    }                    
                }catch(Exception ex){
//                    JOptionPane.showMessageDialog(null, "Válido");
                }
            }});
        txtCPF.getDocument().addDocumentListener(new DocumentListener(){            
            @Override
            public void insertUpdate(DocumentEvent e) {aux = txtCPF.getText().length();}

            @Override
            public void removeUpdate(DocumentEvent e) {aux = 0;}

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

    
    public void limpar(){
        txtNome.setText(null);
        txtCPF.setText(null);
        txtData.setText(null);
        txtTelefone.setText(null);
        txtCelular.setText(null);
        txtEmail.setText(null);
        txtNumeroRegistro.setText(String.valueOf(funCliente.numeroRegistro() + 1));
        txtEmpresa.setText(null);
        txtProfissao.setText(null);
        txtRua.setText(null);
        txtNumero.setText(null);
        txtComplemento.setText(null);
        txtBairro.setText(null);
        txtCidade.setText(null);
        comboEstado.setSelectedIndex(0);
        txtCEP.setText(null);
        btnAdicionar.setEnabled(true);
        btnAlterar.setEnabled(false);
   }
    
    public void tabela(ArrayList<Pessoa> pessoa){
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for(Pessoa x: pessoa){
            model.addRow(new Object[]{
                x.getIdPessoa(),
                x.getNome(),
                x.getCpf_rg(),
                x.getCelular(),
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
    
    public void alimentaFields(ArrayList<Pessoa> pessoa, 
                               ArrayList<Cliente> cliente, 
                               ArrayList<Endereco> endereco){
        txtNome.setText(pessoa.get(0).getNome());
        txtCPF.setText(pessoa.get(0).getCpf_rg());
        txtData.setText(pessoa.get(0).getDataNascimento());
        txtTelefone.setText(pessoa.get(0).getTelefone());
        txtCelular.setText(pessoa.get(0).getCelular());
        txtEmail.setText(pessoa.get(0).getEmail());
        
        txtNumeroRegistro.setText(String.valueOf(cliente.get(0).getNumeroResgitroCliente()));
        txtEmpresa.setText(cliente.get(0).getEmpresa());
        txtProfissao.setText(cliente.get(0).getProfissao());
        
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
    
    public boolean verificaCPF(ArrayList<Pessoa> pessoa){
        for(int i=0;i<pessoa.size();i++){
            if(txtCPF.getText().equals(pessoa.get(i).getCpf_rg())){
                return true;
            }
            break;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        lblComplemento = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblNumeroRegistro = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        lblProfissao = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblRua = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        txtCEP = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        txtNumero = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        txtNumeroRegistro = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        txtProfissao = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtRua = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtBusca = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        lblRecarregar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");
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

        lblNumero.setText("Número");

        lblComplemento.setText("Complemento");

        lblBairro.setText("Bairro");

        lblCidade.setText("Cidade");

        lblEstado.setText("Estado");

        lblCEP.setText("CEP");

        lblCelular.setText("Celular");

        lblEmail.setText("Email");

        lblNumeroRegistro.setText("Nº de Registro");

        lblEmpresa.setText("Empresa");

        lblProfissao.setText("Profissão");

        lblNome.setText("Nome");

        lblCPF.setText("CPF");

        lblDataNascimento.setText("Data de Nascimento");

        lblTelefone.setText("Telefone");

        lblRua.setText("Rua");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE...", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtNumeroRegistro.setEditable(false);
        txtNumeroRegistro.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblProfissao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProfissao, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpresa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDataNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCelular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblEmail)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtEmail))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNome))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblCPF)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblNumeroRegistro)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNumeroRegistro))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblRua)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRua))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblBairro)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblNumero)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblCidade)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblEstado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblComplemento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCEP)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCEP))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblEmail, lblEmpresa, lblProfissao});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(lblNumeroRegistro)
                    .addComponent(txtNumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNascimento)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComplemento)
                    .addComponent(lblCEP)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCelular)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpresa)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfissao)
                    .addComponent(txtProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar-24px.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
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
                "ID", "Nome", "CPF/RG", "Celular", "Email"
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
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

        lblRecarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/recarregar-24px.png"))); // NOI18N
        lblRecarregar.setToolTipText("Recarregar");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecarregar)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnAlterar, btnExcluir, btnNovo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnExcluir)
                                .addComponent(btnAlterar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdicionar)
                                .addComponent(btnNovo))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRecarregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpar();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(txtNome.getText().isEmpty() && txtCPF.getText().isEmpty() &&
            txtData.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Campos de textos estão vazios\n\n"
                    + "Por favor insira os dados", "Aviso", 2);
        }else{
            if(verificaCPF(funPessoa.tabela("cliente")) == true){
                JOptionPane.showMessageDialog(null,"CPF já cadastrado","Aviso",2);
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

                Pessoa pessoa = new Pessoa();

                pessoa.setNome(txtNome.getText().toUpperCase());
                pessoa.setCpf_rg(txtCPF.getText());
                pessoa.setDataNascimento(txtData.getText());
                pessoa.setEmail(txtEmail.getText());

                if(txtTelefone.getValue() == null){
                    pessoa.setTelefone(null);
                }else{
                    pessoa.setTelefone(txtTelefone.getText());
                }
                if(txtCelular.getValue() == null){
                    pessoa.setCelular(null);
                }else{
                    pessoa.setCelular(txtCelular.getText());
                }

                funPessoa.inserirPessoa(pessoa);

                Cliente cliente = new Cliente();

                cliente.setNumeroResgitroCliente(Integer.parseInt(txtNumeroRegistro.getText()));
                cliente.setEmpresa(txtEmpresa.getText().toUpperCase());
                cliente.setProfissao(txtProfissao.getText().toUpperCase());

                funCliente.inserirCliente(cliente);

                limpar();

                tabela(funPessoa.tabela("cliente"));

                limpar();   
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
        
            idPessoa = Integer.parseInt(jTable1.getValueAt(linha, 0).toString());
            
            limpar();
        }
        
        if(evt.getClickCount() == 2){
            idPessoa = Integer.parseInt(jTable1.getValueAt(linha, 0).toString());
                        
            alimentaFields(funPessoa.dados(idPessoa, "cliente"), 
                           funCliente.dados(idPessoa), 
                           funEndereco.dados(idPessoa, "cliente", true));
            
            btnAlterar.setEnabled(true);
            btnAdicionar.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnAdicionar.setEnabled(true);
        jTable1.clearSelection();
        
        limpar();
    }//GEN-LAST:event_formMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        funCliente.deletar(idPessoa);
        
        tabela(funPessoa.tabela("cliente"));
        
        limpar();
        
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if(txtNome.getText().isEmpty() && txtCPF.getText().isEmpty() &&
            txtData.getText().isEmpty()){
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

            funEndereco.alterar(endereco, idPessoa, true);

            Pessoa pessoa = new Pessoa();

            pessoa.setNome(txtNome.getText().toUpperCase());
            pessoa.setCpf_rg(txtCPF.getText());
            pessoa.setDataNascimento(txtData.getText());
            pessoa.setEmail(txtEmail.getText());

            if(txtTelefone.getValue() == null){
                pessoa.setTelefone(null);
            }else{
                pessoa.setTelefone(txtTelefone.getText());
            }
            if(txtCelular.getValue() == null){
                pessoa.setCelular(null);
            }else{
                pessoa.setCelular(txtCelular.getText());
            }

            funPessoa.alterar(pessoa, idPessoa);

            Cliente cliente = new Cliente();

            cliente.setNumeroResgitroCliente(Integer.parseInt(txtNumeroRegistro.getText()));
            cliente.setEmpresa(txtEmpresa.getText().toUpperCase());
            cliente.setProfissao(txtProfissao.getText().toUpperCase());

            funCliente.alterar(cliente, idPessoa);

            tabela(funPessoa.tabela("cliente"));
            limpar();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        tabela(funPessoa.buscaPessoa(txtBusca.getText(), "cliente"));
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void lblRecarregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecarregarMouseClicked
        tabela(funPessoa.tabela("cliente"));
    }//GEN-LAST:event_lblRecarregarMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Menu x = new Menu();
        x.setExtendedState(JFrame.MAXIMIZED_BOTH);
        x.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    
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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblNumeroRegistro;
    private javax.swing.JLabel lblProfissao;
    private javax.swing.JLabel lblRecarregar;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtNumero;
    private javax.swing.JTextField txtNumeroRegistro;
    private javax.swing.JTextField txtProfissao;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
