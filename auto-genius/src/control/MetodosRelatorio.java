
package control;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;
import model.Produto_Servico;
import model.Relatorios;
import model.Veiculo;


public class MetodosRelatorio {
    Conexao conexao = new Conexao();
    
    public ArrayList relatorio(String pessoa, boolean busca){
        ArrayList<Relatorios> listaRelatorio = new ArrayList<>();
        String sql = "";
        try{
            conexao.Conectar();
            
            if(busca == false){
                sql = "SELECT "
                    + "p.idPessoa AS id, p.nome AS cliente, p.cpf_rg, p.dataNascimento, " 
                    + "p.telefone, p.celular, p.email, p.idEndereco, v.*, c.idcliente, s.*, (SELECT p.nome FROM " 
                    + "pessoa p WHERE p.idpessoa = f.idpessoa) AS funcionario, f.* FROM pessoa p " 
                    + "JOIN cliente c ON c.idPessoa = p.idPessoa " 
                    + "JOIN cliente_servico cs ON cs.idcliente = c.idcliente " 
                    + "JOIN servico s ON s.idservico = cs.idservico " 
                    + "JOIN veiculo v ON v.idveiculo = cs.idveiculo " 
                    + "JOIN servico_funcionario sf ON sf.idservico = s.idservico " 
                    + "JOIN funcionario f ON f.idfuncionario = sf.idfuncionario "
                    + "order by s.idServico";
            }else{
                sql = "SELECT "
                    + "p.idPessoa AS id, p.nome AS cliente, p.cpf_rg, p.dataNascimento, " 
                    + "p.telefone, p.celular, p.email, p.idEndereco, v.*, c.idcliente, s.*, (SELECT p.nome FROM " 
                    + "pessoa p WHERE p.idpessoa = f.idpessoa) AS funcionario, f.* FROM pessoa p " 
                    + "JOIN cliente c ON c.idPessoa = p.idPessoa " 
                    + "JOIN cliente_servico cs ON cs.idcliente = c.idcliente " 
                    + "JOIN servico s ON s.idservico = cs.idservico " 
                    + "JOIN veiculo v ON v.idveiculo = cs.idveiculo " 
                    + "JOIN servico_funcionario sf ON sf.idservico = s.idservico " 
                    + "JOIN funcionario f ON f.idfuncionario = sf.idfuncionario "
                    + "WHERE p.nome ILIKE '%" + pessoa + "%' "
                    + "order by s.idServico";
            }
            
            PreparedStatement statement = conexao.conexao.prepareStatement(sql);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Relatorios relatorio = new Relatorios();
                
                // Dados da tabela servico
                relatorio.setIdServico(result.getInt("idServico"));
                relatorio.setDescricao(result.getString("descricao"));
                relatorio.setPreco(result.getDouble("preco"));
                relatorio.setData(result.getString("data"));
                relatorio.setHora(result.getString("hora"));
                relatorio.setFormaPagamento(result.getString("formaPagamento"));
                relatorio.setTipoPagamento(result.getString("tipoPagamento"));
                relatorio.setCondicaoPagamento(result.getString("condicaoPagamento"));
                relatorio.setSituacao(result.getString("situacao"));
                
                // Dados da tabela Pessoa
                relatorio.setIdPessoa(result.getInt("id"));
                relatorio.setNome(result.getString("cliente"));
                relatorio.setCpf_rg(result.getString("cpf_rg"));
                relatorio.setDataNascimento(result.getString("dataNascimento"));
                relatorio.setTelefone(result.getString("telefone"));
                relatorio.setCelular(result.getString("celular"));
                relatorio.setEmail(result.getString("email"));
                relatorio.setIdEndereco(result.getInt("idEndereco"));
                
                // Dado da tabela Cliente
                relatorio.setIdCliente(result.getInt("idcliente"));
                
                // Dados da tabela Funcionário
                relatorio.setIdFuncionario(result.getInt("idFuncionario"));
                relatorio.setFuncionario(result.getString("funcionario"));
                relatorio.setNumeroRegistroFuncionario(result.getInt("numeroRegistroFuncionario"));
                relatorio.setCargo(result.getString("cargo"));
                relatorio.setSalario(result.getDouble("salario"));
                relatorio.setDataAdmissao(result.getString("dataAdmissao"));
                relatorio.setLogin(result.getString("login"));
                relatorio.setSenha(result.getString("senha"));
                relatorio.setIdPessoa(result.getInt("idPessoa"));
                
                // Dados da tabela Veiculo
                relatorio.setIdVeiculo(result.getInt("idVeiculo"));
                relatorio.setPlaca(result.getString("placa"));
                relatorio.setMarca(result.getString("marca"));
                relatorio.setNomeCarro(result.getString("nome"));
                relatorio.setAno(result.getInt("ano"));
                relatorio.setModelo(result.getString("modelo"));
                relatorio.setCor(result.getString("cor"));
                
                listaRelatorio.add(relatorio);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }        
        return listaRelatorio;
    }
    
    public ArrayList relatorioFiltrado(String pessoa, String filtro, boolean busca){
        ArrayList<Relatorios> listaRelatorio = new ArrayList<>();
        String sql = "";
        try{
            conexao.Conectar();
            
            if(busca == false){
                sql = "SELECT "
                    + "p.idPessoa AS id, p.nome AS cliente, p.cpf_rg, p.dataNascimento, " 
                    + "p.telefone, p.celular, p.email, p.idEndereco, v.*, c.idcliente, s.*, (SELECT p.nome FROM " 
                    + "pessoa p WHERE p.idpessoa = f.idpessoa) AS funcionario, f.* FROM pessoa p " 
                    + "JOIN cliente c ON c.idPessoa = p.idPessoa " 
                    + "JOIN cliente_servico cs ON cs.idcliente = c.idcliente " 
                    + "JOIN servico s ON s.idservico = cs.idservico " 
                    + "JOIN veiculo v ON v.idveiculo = cs.idveiculo " 
                    + "JOIN servico_funcionario sf ON sf.idservico = s.idservico " 
                    + "JOIN funcionario f ON f.idfuncionario = sf.idfuncionario "
                    + "WHERE s.situacao = ? "
                    + "order by s.idServico";
            }else{
                sql = "SELECT "
                    + "p.idPessoa AS id, p.nome AS cliente, p.cpf_rg, p.dataNascimento, " 
                    + "p.telefone, p.celular, p.email, p.idEndereco, v.*, c.idcliente, s.*, (SELECT p.nome FROM " 
                    + "pessoa p WHERE p.idpessoa = f.idpessoa) AS funcionario, f.* FROM pessoa p " 
                    + "JOIN cliente c ON c.idPessoa = p.idPessoa " 
                    + "JOIN cliente_servico cs ON cs.idcliente = c.idcliente " 
                    + "JOIN servico s ON s.idservico = cs.idservico " 
                    + "JOIN veiculo v ON v.idveiculo = cs.idveiculo " 
                    + "JOIN servico_funcionario sf ON sf.idservico = s.idservico " 
                    + "JOIN funcionario f ON f.idfuncionario = sf.idfuncionario "
                    + "WHERE p.nome ILIKE '%" + pessoa + "%' AND s.situacao = ? "
                    + "order by s.idservico";
            }
            
            PreparedStatement statement = conexao.conexao.prepareStatement(sql);
            
            statement.setString(1, filtro);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Relatorios relatorio = new Relatorios();
                
                // Dados da tabela servico
                relatorio.setIdServico(result.getInt("idServico"));
                relatorio.setDescricao(result.getString("descricao"));
                relatorio.setPreco(result.getDouble("preco"));
                relatorio.setData(result.getString("data"));
                relatorio.setHora(result.getString("hora"));
                relatorio.setFormaPagamento(result.getString("formaPagamento"));
                relatorio.setTipoPagamento(result.getString("tipoPagamento"));
                relatorio.setCondicaoPagamento(result.getString("condicaoPagamento"));
                relatorio.setSituacao(result.getString("situacao"));
                
                // Dados da tabela Pessoa
                relatorio.setIdPessoa(result.getInt("id"));
                relatorio.setNome(result.getString("cliente"));
                relatorio.setCpf_rg(result.getString("cpf_rg"));
                relatorio.setDataNascimento(result.getString("dataNascimento"));
                relatorio.setTelefone(result.getString("telefone"));
                relatorio.setCelular(result.getString("celular"));
                relatorio.setEmail(result.getString("email"));
                relatorio.setIdEndereco(result.getInt("idEndereco"));
                
                // Dado da tabela Cliente
                relatorio.setIdCliente(result.getInt("idcliente"));
                
                // Dados da tabela Funcionário
                relatorio.setIdFuncionario(result.getInt("idFuncionario"));
                relatorio.setFuncionario(result.getString("funcionario"));
                relatorio.setNumeroRegistroFuncionario(result.getInt("numeroRegistroFuncionario"));
                relatorio.setCargo(result.getString("cargo"));
                relatorio.setSalario(result.getDouble("salario"));
                relatorio.setDataAdmissao(result.getString("dataAdmissao"));
                relatorio.setLogin(result.getString("login"));
                relatorio.setSenha(result.getString("senha"));
                relatorio.setIdPessoa(result.getInt("idPessoa"));
                
                // Dados da tabela Veiculo
                relatorio.setIdVeiculo(result.getInt("idVeiculo"));
                relatorio.setPlaca(result.getString("placa"));
                relatorio.setMarca(result.getString("marca"));
                relatorio.setNomeCarro(result.getString("nome"));
                relatorio.setAno(result.getInt("ano"));
                relatorio.setModelo(result.getString("modelo"));
                relatorio.setCor(result.getString("cor"));
                
                listaRelatorio.add(relatorio);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }        
        return listaRelatorio;
    }
    
    public void deletaRelatorio(int id){
        try{
            conexao.Conectar();
            
            CallableStatement statement = conexao.conexao.prepareCall("CALL "
                    + "deletaRelatorioServico(?)");
            
            statement.setInt(1, id);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public ArrayList dados(int id){
        ArrayList<Relatorios> listaRelatorio = new ArrayList<>();
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("SELECT "
                    + "p.idPessoa AS id, p.nome AS cliente, p.cpf_rg, p.dataNascimento, " 
                    + "p.telefone, p.celular, p.email, p.idEndereco, c.*, s.*, v.* FROM pessoa p " 
                    + "JOIN cliente c ON c.idPessoa = p.idPessoa " 
                    + "JOIN cliente_servico cs ON cs.idcliente = c.idcliente " 
                    + "JOIN servico s ON s.idservico = cs.idservico " 
                    + "JOIN veiculo v ON v.idveiculo = cs.idveiculo " 
                    + "WHERE s.idservico = ?");
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Relatorios relatorio = new Relatorios();
                
                // Dados da tabela Pessoa
                relatorio.setIdPessoa(result.getInt("id"));
                relatorio.setNome(result.getString("cliente"));
                relatorio.setCpf_rg(result.getString("cpf_rg"));
                relatorio.setDataNascimento(result.getString("dataNascimento"));
                relatorio.setTelefone(result.getString("telefone"));
                relatorio.setCelular(result.getString("celular"));
                relatorio.setEmail(result.getString("email"));
                
                // Dados da tabela Cliente
                relatorio.setIdCliente(result.getInt("idCliente"));
                relatorio.setNumeroResgitroCliente(result.getInt("numeroRegistroCliente"));
                relatorio.setEmpresa(result.getString("empresa"));
                relatorio.setProfissao(result.getString("profissao"));
                relatorio.setIdPessoa(result.getInt("idPessoa"));
                
                // Dados da tabela servico
                relatorio.setIdServico(result.getInt("idServico"));
                relatorio.setDescricao(result.getString("descricao"));
                relatorio.setPreco(result.getDouble("preco"));
                relatorio.setData(result.getString("data"));
                relatorio.setHora(result.getString("hora"));
                relatorio.setFormaPagamento(result.getString("formaPagamento"));
                relatorio.setTipoPagamento(result.getString("tipoPagamento"));
                relatorio.setCondicaoPagamento(result.getString("condicaoPagamento"));
                relatorio.setSituacao(result.getString("situacao"));
                
                // Dados da tabela Veiculo
                relatorio.setIdVeiculo(result.getInt("idVeiculo"));
                relatorio.setPlaca(result.getString("placa"));
                relatorio.setMarca(result.getString("marca"));
                relatorio.setNomeCarro(result.getString("nome"));
                relatorio.setAno(result.getInt("ano"));
                relatorio.setModelo(result.getString("modelo"));
                relatorio.setCor(result.getString("cor"));
                
                listaRelatorio.add(relatorio);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaRelatorio;
    }
    
    public void updateSituacao(String situacao, int id){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("UPDATE "
                    + "servico SET situacao = ? "
                    + "WHERE idServico = ?");
            
            statement.setString(1, situacao);
            statement.setInt(2, id);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 3);
        }
    }
}