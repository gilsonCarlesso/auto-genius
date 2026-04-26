
package control;

import model.Veiculo;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MetodosVeiculo {
    Conexao conexao = new Conexao();
    
    public void inserirVeiculo(Veiculo veiculo){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Veiculo(Placa, Marca, Nome, Ano, Modelo, Cor) "
                    + "values (?,?,?,?,?,?)");
            
            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getMarca());
            statement.setString(3, veiculo.getNome());
            statement.setInt(4, veiculo.getAno());
            statement.setString(5, veiculo.getModelo());
            statement.setString(6, veiculo.getCor());
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void alterar(Veiculo veiculo, int idVeiculo){
        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "veiculo set placa = ?, marca = ?, nome = ?, ano = ?, "
                    + "modelo = ?, cor = ? where idVeiculo = ?");
            
            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getMarca());
            statement.setString(3, veiculo.getNome());
            statement.setInt(4, veiculo.getAno());
            statement.setString(5, veiculo.getModelo());
            statement.setString(6, veiculo.getCor());
            statement.setInt(7, idVeiculo);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
    }
    
    public void deletar(int idVeiculo){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("delete "
                    + "from veiculo where idVeiculo = ?");
            
            statement.setInt(1, idVeiculo);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public ArrayList tabela(){
        ArrayList<Veiculo> listaVeiculo = new ArrayList<>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "* from veiculo order by idveiculo");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Veiculo veiculo = new Veiculo();
                
                veiculo.setIdVeiculo(result.getInt("idVeiculo"));
                veiculo.setPlaca(result.getString("placa"));
                veiculo.setMarca(result.getString("marca"));
                veiculo.setNome(result.getString("nome"));
                veiculo.setAno(result.getInt("ano"));
                veiculo.setModelo(result.getString("modelo"));
                veiculo.setCor(result.getString("cor"));
                
                listaVeiculo.add(veiculo);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }        
        return listaVeiculo;
    }
    
    public ArrayList buscaVeiculo(String nome, boolean op){
        ArrayList<Veiculo> listaVeiculo = new ArrayList<>();
        
        try{
            conexao.Conectar();
            String sql = "";
            if(op == true){
                sql = "select "
                    + "* from veiculo "
                    + "where nome ilike '%"+ nome +"%' "
                        + "order by idVeiculo";
            }
            if(op == false){
                sql = "SELECT v.* FROM veiculo v " 
                        + "JOIN cliente c ON c.idcliente = v.idcliente " 
                        + "JOIN pessoa p ON p.idpessoa = c.idpessoa " 
                        + "WHERE p.nome ILIKE '%"+ nome +"%' "
                        + "order by idveiculo";
            }
            PreparedStatement statement = conexao.conexao.prepareStatement(sql);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Veiculo veiculo = new Veiculo();
                
                veiculo.setIdVeiculo(result.getInt("idVeiculo"));
                veiculo.setPlaca(result.getString("placa"));
                veiculo.setMarca(result.getString("marca"));
                veiculo.setNome(result.getString("nome"));
                veiculo.setAno(result.getInt("ano"));
                veiculo.setModelo(result.getString("modelo"));
                veiculo.setCor(result.getString("cor"));
                
                listaVeiculo.add(veiculo);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }        
        return listaVeiculo;
    }
    
    public ArrayList dados(int id){
        ArrayList<Veiculo> listaVeiculo = new ArrayList<>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("SELECT "
                    + "* FROM veiculo WHERE idVeiculo = ?");
            
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Veiculo veiculo = new Veiculo();
                
                veiculo.setIdVeiculo(result.getInt("idVeiculo"));
                veiculo.setPlaca(result.getString("placa"));
                veiculo.setMarca(result.getString("marca"));
                veiculo.setNome(result.getString("nome"));
                veiculo.setAno(result.getInt("ano"));
                veiculo.setModelo(result.getString("modelo"));
                veiculo.setCor(result.getString("cor"));
                
                listaVeiculo.add(veiculo);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }        
        return listaVeiculo;
    }
}
