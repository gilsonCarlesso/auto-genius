
package control;

import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MetodosCliente {
    Conexao conexao = new Conexao();
    
    public void inserirCliente(Cliente cliente){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into Cliente(NumeroRegistroCliente, Empresa, Profissao, idPessoa) "
                    + "values (?,?,?,(select max(idPessoa) from pessoa))");
            
            statement.setInt(1, cliente.getNumeroResgitroCliente());
            statement.setString(2, cliente.getEmpresa());
            statement.setString(3, cliente.getProfissao());
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void deletar(int idPessoa){        
        try{
            conexao.Conectar();
            
            CallableStatement statement = conexao.conexao.prepareCall("CALL deletaCliente(?)");
            
            statement.setInt(1, idPessoa);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
//            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null,"Existe relatórios vinculados a este cliente","Aviso",2);
        }
    }
    
    public void alterar(Cliente cliente, int idPessoa){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "cliente set numeroregistrocliente = ?, empresa = ?, "
                    + "profissao = ? where idpessoa = ?");
            
            statement.setInt(1, cliente.getNumeroResgitroCliente());
            statement.setString(2, cliente.getEmpresa());
            statement.setString(3, cliente.getProfissao());
            statement.setInt(4, idPessoa);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(),
                    "Alteraçao de Cliente", 0);
        }
    }
    
    public ArrayList dados(int idPessoa){
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "p.*, e.*, c.* from pessoa p "
                    + "join endereco e on e.idendereco = p.idendereco "
                    + "join cliente c on c.idpessoa = p.idpessoa "
                    + "where p.idpessoa = ?");
            
            statement.setInt(1, idPessoa);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Cliente cliente = new Cliente();
                
                cliente.setIdCliente(result.getInt("idCliente"));
                cliente.setNumeroResgitroCliente(result.getInt("numeroRegistroCliente"));
                cliente.setEmpresa(result.getString("empresa"));
                cliente.setProfissao(result.getString("profissao"));
                cliente.setIdPessoa(result.getInt("idPessoa"));
                
                
                listaCliente.add(cliente);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaCliente;
    }
    
    public int numeroRegistro(){
        int registro = 0;
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "max(numeroRegistroCliente) as registro from cliente");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                registro = result.getInt("registro");
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return registro;
    }
}
