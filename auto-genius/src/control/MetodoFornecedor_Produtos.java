
package control;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fornecedor;
import model.Fornecedor_Produto;


public class MetodoFornecedor_Produtos {
    Conexao conexao = new Conexao();
    
    public void inserirFornecedor_Produtos(int idFornecedor){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Fornecedor_Produtos(idFornecedor, idProduto) values "
                    + "(?,(select max(idProduto) from produtos))");
            
            statement.setInt(1, idFornecedor);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void deletar(int idFornecedor_Produtos){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("delete "
                    + "from Fornecedor_Produtos where idFornecedor_Produtos = ?");
            
            statement.setInt(1, idFornecedor_Produtos);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void alterar(int idFornecedor, int idProduto){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "fornecedor_produtos set idfornecedor = ? " 
                    + "where idproduto = (select idproduto from produtos where idproduto = ?)");
            
            statement.setInt(1, idFornecedor);
            statement.setInt(2, idProduto);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
    }
    
    public ArrayList dados(int idproduto){
        ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "f.nome from fornecedor_produtos fp " 
                    + "join produtos p on p.idproduto = fp.idproduto " 
                    + "join fornecedor f on f.idfornecedor = fp.idfornecedor " 
                    + "where p.idproduto =  ?");
            
            statement.setInt(1, idproduto);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setNome(result.getString("nome"));
                
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
