
package control;

import model.Servico;
import java.sql.*;
import javax.swing.JOptionPane;


public class MetodosServico {
    Conexao conexao = new Conexao();
    
    public void inserirOrdemServico(Servico servico){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into servico(Descricao, Preco, data, hora, formaPagamento, "
                    + "tipoPagamento, condicaoPagamento, situacao) values "
                    + "(?,?,"
                    + "to_char(now(),'DD/MM/YYYY'),"
                    + "to_char(now(),'HH24:MI:SS'),"
                    + "?,?,?,?)");
            
            statement.setString(1, servico.getDescricao());
            statement.setDouble(2, servico.getPreco());
            statement.setString(3, servico.getFormaPagamento());
            statement.setString(4, servico.getTipoPagamento());
            statement.setString(5, servico.getCondicaoPagamento());
            statement.setString(6, servico.getSituacao());
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void deletar(int idServico){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("delete "
                    + "from servico where idServico = ?");
            
            statement.setInt(1, idServico);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void alterar(Servico servico, int idServico){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "servico set descricao = ?, preco = ?, formaPagamento = ?, "
                    + "tipoPagamento = ?, condicaoPagamento = ?, situacao = ? "
                    + "where idServico = ?");
            
            statement.setString(1, servico.getDescricao());
            statement.setDouble(2, servico.getPreco());
            statement.setString(3, servico.getFormaPagamento());
            statement.setString(4, servico.getTipoPagamento());
            statement.setString(5, servico.getCondicaoPagamento());
            statement.setString(6, servico.getSituacao());
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
    }
    
    public int retornaId(String op, int idPessoa){
        int id = 0;
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                + "id"+op+" from "+op+" where idpessoa = ?");
            
            statement.setInt(1, idPessoa);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                id = result.getInt("id"+op);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return id;
    }
}
