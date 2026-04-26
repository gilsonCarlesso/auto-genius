
package control;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente_Servico;

public class MetodosCliente_Servico {
    Conexao conexao = new Conexao();
    
    public void inserirCliente_Servico(int idCliente){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Cliente_Servico(idCliente, idServico, idVeiculo) values (?, "
                    + "(select max(idServico) from servico), (select max(idVeiculo) "
                    + "from veiculo))");
            
            statement.setInt(1, idCliente);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void deletar(int idcliente_servico){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("delete "
                    + "from cliente_servico where idCliente_Servico = ?");
            
            statement.setInt(1, idcliente_servico);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public ArrayList dados(){
        ArrayList<Cliente_Servico> lista = new ArrayList<>();
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("SELECT "
                    + "* FROM cliente_servico");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Cliente_Servico cliente_servico = new Cliente_Servico();
                
                cliente_servico.setIdCliente(result.getInt("idcliente"));
                cliente_servico.setIdServico(result.getInt("idservico"));
                cliente_servico.setIdVeiculo(result.getInt("idVeiculo"));
                
                lista.add(cliente_servico);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 3);
        }
        return lista;
    }
}
