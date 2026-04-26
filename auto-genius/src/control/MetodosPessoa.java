
package control;

import model.Pessoa;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MetodosPessoa {
    Conexao conexao = new Conexao();
    
    public void inserirPessoa(Pessoa pessoa){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Pessoa(Nome, CPF_RG, DataNascimento, Telefone, Celular, Email, "
                    + "idEndereco) values (?,?,?,?,?,?,(select max(idEndereco) from "
                    + "endereco))");
            
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getCpf_rg());
            statement.setString(3, pessoa.getDataNascimento());
            statement.setString(4, pessoa.getTelefone());
            statement.setString(5, pessoa.getCelular());
            statement.setString(6, pessoa.getEmail());
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void alterar(Pessoa pessoa, int idPessoa){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "pessoa set nome = ?, cpf_rg = ?, dataNascimento = ?, telefone = ?, "
                    + "celular = ?, email = ? where idpessoa = ?");
            
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getCpf_rg());
            statement.setString(3, pessoa.getDataNascimento());
            statement.setString(4, pessoa.getTelefone());
            statement.setString(5, pessoa.getCelular());
            statement.setString(6, pessoa.getEmail());
            statement.setInt(7, idPessoa);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
    }
    
    public ArrayList tabela(String opcao){
        ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
        
        conexao.Conectar();
        
        try{
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "p.idPessoa, p.nome, p.cpf_rg, p.telefone, p.celular, p.email "
                    + "from pessoa p "
                    + "join " + opcao + " c on c.idpessoa = p.idpessoa "
                    + "order by p.idpessoa");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Pessoa pessoa = new Pessoa();
                
                pessoa.setIdPessoa(result.getInt("idPessoa"));
                pessoa.setNome(result.getString("nome"));
                pessoa.setCpf_rg(result.getString("cpf_rg"));
                pessoa.setTelefone(result.getString("telefone"));
                pessoa.setCelular(result.getString("celular"));
                pessoa.setEmail(result.getString("email"));
                
                listaPessoa.add(pessoa);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaPessoa;
    }
    
    public ArrayList buscaPessoa(String nome, String opcao){
        ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
        
        conexao.Conectar();
        
        try{
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "p.idPessoa, p.nome, p.cpf_rg, p.telefone, p.email "
                    + "from pessoa p "
                    + "join " + opcao + " c on c.idpessoa = p.idpessoa "
                    + "where nome ilike '%"+ nome +"%' "
                    + "order by p.idpessoa");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Pessoa pessoa = new Pessoa();
                
                pessoa.setIdPessoa(result.getInt("idPessoa"));
                pessoa.setNome(result.getString("nome"));
                pessoa.setCpf_rg(result.getString("cpf_rg"));
                pessoa.setTelefone(result.getString("telefone"));
                pessoa.setEmail(result.getString("email"));
                
                listaPessoa.add(pessoa);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaPessoa;
    }
    
    public ArrayList dados(int idPessoa, String opcao){
        ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "p.*, e.*, c.* from pessoa p "
                    + "join endereco e on e.idendereco = p.idendereco "
                    + "join " + opcao + " c on c.idpessoa = p.idpessoa "
                    + "where p.idpessoa = ?");
            
            statement.setInt(1, idPessoa);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Pessoa pessoa = new Pessoa();
                
                pessoa.setIdPessoa(result.getInt("idPessoa"));
                pessoa.setNome(result.getString("Nome"));
                pessoa.setCpf_rg(result.getString("cpf_rg"));
                pessoa.setDataNascimento(result.getString("DataNascimento"));
                pessoa.setTelefone(result.getString("telefone"));
                pessoa.setCelular(result.getString("celular"));
                pessoa.setEmail(result.getString("Email"));
                pessoa.setIdEndereco(result.getInt("idEndereco"));
                
                listaPessoa.add(pessoa);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaPessoa;
    }
}
