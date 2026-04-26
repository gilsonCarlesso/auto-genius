
package control;

import java.sql.*;
import javax.swing.JOptionPane;

public class MetodosServico_Funcionario {
    Conexao conexao = new Conexao();
    
    public void inserirServico_Funcionario(int idFuncionario){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Servico_Funcionario(idFuncionario, idServico) values (?,"
                    + "(select max(idServico) from servico))");
            
            statement.setInt(1, idFuncionario);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void deletar(int idServico_Funcionario){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("delete "
                    + "from Servico_Funcionario where idServico_Funcionario = ?");
            
            statement.setInt(1, idServico_Funcionario);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
}
