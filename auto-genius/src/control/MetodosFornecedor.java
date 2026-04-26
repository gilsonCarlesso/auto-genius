
package control;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fornecedor;


public class MetodosFornecedor {
    Conexao conexao = new Conexao();
    
    public void inserirFornecedor(Fornecedor fornecedor){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Fornecedor(Nome, CNPJ, Email, Telefone, Celular, idEndereco) "
                    + "values (?,?,?,?,?,(select max(idEndereco) from endereco))");
            
            statement.setString(1, fornecedor.getNome());
            statement.setString(2, fornecedor.getCnpj());
            statement.setString(3, fornecedor.getEmail());
            statement.setString(4, fornecedor.getTelefone());
            statement.setString(5, fornecedor.getCelular());
            
            statement.execute();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void deletar(int idFornecedor){
        try{
            conexao.Conectar();
            
            CallableStatement statement = conexao.conexao.prepareCall("CALL deletaFornecedor(?)");
            
            statement.setInt(1, idFornecedor);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
            JOptionPane.showMessageDialog(null,"A cadastro de produtos vinculado a este fornecedor","Aviso",2);
        }
    }
    
    public void alterar(Fornecedor fornecedor, int idFornecedor){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "fornecedor set nome = ?, cnpj = ?, email = ?, "
                    + "telefone = ?, celular = ? where idFornecedor= ?");
            
            statement.setString(1, fornecedor.getNome());
            statement.setString(2, fornecedor.getCnpj());
            statement.setString(3, fornecedor.getEmail());
            statement.setString(4, fornecedor.getTelefone());
            statement.setString(5, fornecedor.getCelular());
            statement.setInt(6, idFornecedor);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(),
                    "Alteraçao de Fornecedor", 0);
        }
    }
    
    public ArrayList tabela(){
        ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        
        conexao.Conectar();
        
        try{
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "idfornecedor, nome, cnpj, email, telefone from fornecedor "
                    + "order by idFornecedor");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setIdFornecedor(result.getInt("idfornecedor"));
                fornecedor.setNome(result.getString("nome"));
                fornecedor.setCnpj(result.getString("cnpj"));
                fornecedor.setEmail(result.getString("email"));
                fornecedor.setTelefone(result.getString("telefone"));
                
                listaFornecedor.add(fornecedor);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaFornecedor;
    }
    
    public ArrayList buscaFornecedor(String nome){
        ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        
        conexao.Conectar();
        
        try{
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "idfornecedor, nome, cnpj, email, telefone from fornecedor "
                    + "where nome ilike '%"+ nome +"%'");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setIdFornecedor(result.getInt("idFornecedor"));
                fornecedor.setNome(result.getString("nome"));
                fornecedor.setCnpj(result.getString("cnpj"));
                fornecedor.setEmail(result.getString("email"));
                fornecedor.setTelefone(result.getString("telefone"));
                
                listaFornecedor.add(fornecedor);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaFornecedor;
    }
    
    public ArrayList dados(int idFornecedor){
        ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "f.*, e.* from fornecedor f "
                    + "join endereco e on e.idendereco = f.idendereco "
                    + "where f.idFornecedor = ?");
            
            statement.setInt(1, idFornecedor);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Fornecedor fornecedor = new Fornecedor();
                                
                fornecedor.setIdFornecedor(result.getInt("idFornecedor"));
                fornecedor.setNome(result.getString("Nome"));
                fornecedor.setCnpj(result.getString("cnpj"));
                fornecedor.setEmail(result.getString("Email"));
                fornecedor.setTelefone(result.getString("telefone"));
                fornecedor.setCelular(result.getString("celular"));
                fornecedor.setIdEndereco(result.getInt("idEndereco"));
                
                listaFornecedor.add(fornecedor);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaFornecedor;
    }
}
