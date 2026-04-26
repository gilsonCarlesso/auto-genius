
package control;

import model.Estoque;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MetodoEstoque {
    Conexao conexao = new Conexao();
    
    public void inserirEstoque(Estoque estoque){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Estoque (localArmazenamento) values (?)");
            
            statement.setString(1, estoque.getLocalArmazenamento());
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage(), "Erro", 0);
        }
    }
    
    public ArrayList buscaEstoque(String nome){
        ArrayList<Estoque> lista = new ArrayList<Estoque>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "* from estoque where localArmazenamento ilike '%" + nome + "%'"
                    + "order by idEstoque");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Estoque estoque = new Estoque();
                
                estoque.setIdEstoque(result.getInt("idEstoque"));
                estoque.setLocalArmazenamento(result.getString("localArmazenamento"));
                
                lista.add(estoque);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
        
        return lista;
    }
    
    public void deletar(int idEstoque){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("delete "
                    + "from estoque where idEstoque = ?");
            
            statement.setInt(1, idEstoque);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
            JOptionPane.showMessageDialog(null,"Há produtos vinculados a este local de estoque","Aviso",2);
        }
    }
    
    public ArrayList tabela(){
        ArrayList<Estoque> lista = new ArrayList<Estoque>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "* from estoque order by idestoque");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Estoque estoque = new Estoque();
                
                estoque.setIdEstoque(result.getInt("idEstoque"));
                estoque.setLocalArmazenamento(result.getString("localArmazenamento"));
                
                lista.add(estoque);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
        
        return lista;
    }
    
    public void alterar(Estoque estoque){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "estoque set localArmazenamento = ? where idEstoque = ?");
            
            statement.setString(1, estoque.getLocalArmazenamento());
            statement.setInt(2, estoque.getIdEstoque());
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
    }
}
