
package control;

import model.Endereco;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MetodosEndereco {
    Conexao conexao = new Conexao();
    
    public void inserirEndereco(Endereco endereco){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Endereco(Rua, Numero, Complemento, Bairro, Cidade, "
                    + "Estado, CEP) values (?,?,?,?,?,?,?)");
            
            statement.setString(1, endereco.getRua());
            statement.setInt(2, endereco.getNumero());
            statement.setString(3, endereco.getComplemento());
            statement.setString(4, endereco.getBairro());
            statement.setString(5, endereco.getCidade());
            statement.setString(6, endereco.getEstado());
            statement.setString(7, endereco.getCep());
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
    }
    
    public void alterar(Endereco endereco, int id, boolean op){
        try{
            conexao.Conectar();
            
            String sql;
            if(op == true){
                sql = "update Endereco set Rua = ?, Numero = ?, Complemento = ?, "
                        + "Bairro = ?, Cidade = ?, Estado = ?, CEP = ? "
                        + "where idEndereco = (select idEndereco from pessoa "
                        + "where idPessoa = ?)";
            }else{
                sql = "update Endereco set Rua = ?, Numero = ?, Complemento = ?, "
                        + "Bairro = ?, Cidade = ?, Estado = ?, CEP = ? "
                        + "where idEndereco = (select idEndereco from fornecedor "
                        + "where idFornecedor = ?)";
            }
            
            PreparedStatement statement = conexao. conexao.prepareStatement(sql);
            
            statement.setString(1, endereco.getRua());
            statement.setInt(2, endereco.getNumero());
            statement.setString(3, endereco.getComplemento());
            statement.setString(4, endereco.getBairro());
            statement.setString(5, endereco.getCidade());
            statement.setString(6, endereco.getEstado());
            statement.setString(7, endereco.getCep());
            statement.setInt(8, id);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");  
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
    }
    
    public ArrayList dados(int id, String opcao, boolean op){
        ArrayList<Endereco> listaEndereco = new ArrayList<Endereco>();
        
        try{
            conexao.Conectar();
            
            String sql;
            if(op == true){
                sql = "select p.*, e.*, c.* from pessoa p "
                        + "join endereco e on e.idendereco = p.idendereco "
                        + "join " + opcao + " c on c.idpessoa = p.idpessoa "
                        + "where p.idpessoa = ?";
            }else{
                sql = "select f.*, e.* from fornecedor f "
                        + "join endereco e on e.idendereco = f.idendereco "
                        + "where f.idfornecedor = ?";
            }
            
            PreparedStatement statement = conexao.conexao.prepareStatement(sql);
            
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Endereco endereco = new Endereco();
                
                endereco.setIdEndereco(result.getInt("idEndereco"));
                endereco.setRua(result.getString("rua"));
                endereco.setNumero(result.getInt("numero"));
                endereco.setComplemento(result.getString("complemento"));
                endereco.setBairro(result.getString("bairro"));
                endereco.setCidade(result.getString("cidade"));
                endereco.setEstado(result.getString("estado"));
                endereco.setCep(result.getString("cep"));
                
                listaEndereco.add(endereco);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaEndereco;
    }
}
