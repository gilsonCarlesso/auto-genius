
package control;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.Produto_Servico;


public class MetodoProduto_Servico {
    Conexao conexao = new Conexao();
    
    public void inserirProduto_Servico(int idProduto, int qntRequerida){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Produtos_Servico(idProduto, idServico, "
                    + "quantidadeRequerida) values (?,(select max(idServico) "
                    + "from servico),?)");
            
            statement.setInt(1, idProduto);
            statement.setInt(2, qntRequerida);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void deletar(int idProdutos_Servico){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("delete "
                    + "from Produtos_Servico where idProdutos_Servico = ?");
            
            statement.setInt(1, idProdutos_Servico);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
}
