
package control;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcionario;


public class MetodosFuncionario {
    Conexao conexao = new Conexao();
    
    public void inserirFuncionario(Funcionario funcionario){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into funcionario(NumeroRegistroFuncionario, cargo, salario, dataAdmissao, "
                    + "login, senha, idPessoa) "
                    + "values (?,?,?,?,?,?,(select max(idPessoa) from pessoa))");
            
            statement.setInt(1, funcionario.getNumeroRegistroFuncionario());
            statement.setString(2, funcionario.getCargo());
            statement.setDouble(3, funcionario.getSalario());
            statement.setString(4, funcionario.getDataAdmissao());
            statement.setString(5, funcionario.getLogin());
            statement.setString(6, funcionario.getSenha());
            
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
            
            CallableStatement statement = conexao.conexao.prepareCall("CALL deletaFuncionario(?)");
            
            statement.setInt(1, idPessoa);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Há histórico de serviço realizado por este funcionário","Aviso",2);
        }
    }
    
    public void alterar(Funcionario funcionario, int idPessoa){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "funcionario set numeroregistroFuncionario = ?, cargo = ?, "
                    + "salario = ?, dataAdmissao = ?, login = ?, senha = ? "
                    + "where idpessoa = ?");
            
            statement.setInt(1, funcionario.getNumeroRegistroFuncionario());
            statement.setString(2, funcionario.getCargo());
            statement.setDouble(3, funcionario.getSalario());
            statement.setString(4, funcionario.getDataAdmissao());
            statement.setString(5, funcionario.getLogin());
            statement.setString(6, funcionario.getSenha());
            statement.setInt(7, idPessoa);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(),
                    "Alteraçao de Funcionario", 0);
        }
    }
    
    public ArrayList dados(int idPessoa){
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "p.*, e.*, f.* from pessoa p "
                    + "join endereco e on e.idendereco = p.idendereco "
                    + "join funcionario f on f.idpessoa = p.idpessoa "
                    + "where p.idpessoa = ? "
                    + "order by p.idpessoa");
            
            statement.setInt(1, idPessoa);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setIdFuncionario(result.getInt("idFuncionario"));
                funcionario.setNumeroRegistroFuncionario(result.getInt("numeroRegistroFuncionario"));
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setSalario(result.getDouble("salario"));
                funcionario.setDataAdmissao(result.getString("dataAdmissao"));
                funcionario.setLogin(result.getString("login"));
                funcionario.setSenha(result.getString("senha"));
                funcionario.setIdPessoa(result.getInt("idPessoa"));
                
                listaFuncionario.add(funcionario);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaFuncionario;
    }
    
    public int numeroRegistro(){
        int registro = 0;
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "max(numeroRegistroFuncionario) as registro from funcionario");
            
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
    
    public ArrayList tabela(){
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "f.* from funcionario f "
                    + "join pessoa p on p.idpessoa = f.idpessoa "
                    + "order by p.idpessoa");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setIdFuncionario(result.getInt("idFuncionario"));
                funcionario.setNumeroRegistroFuncionario(result.getInt("numeroRegistroFuncionario"));
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setSalario(result.getDouble("salario"));
                funcionario.setDataAdmissao(result.getString("dataAdmissao"));
                funcionario.setLogin(result.getString("login"));
                funcionario.setSenha(result.getString("senha"));
                funcionario.setIdPessoa(result.getInt("idPessoa"));
                
                listaFuncionario.add(funcionario);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 3);
        }
        return listaFuncionario;
    }
    
    public ArrayList busca(String nome){
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "f.* from funcionario f "
                    + "join pessoa p on p.idpessoa = f.idpessoa "
                    + "where p.nome ilike '%" + nome + "%'"
                    + "order by p.idpessoa");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setIdFuncionario(result.getInt("idFuncionario"));
                funcionario.setNumeroRegistroFuncionario(result.getInt("numeroRegistroFuncionario"));
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setSalario(result.getDouble("salario"));
                funcionario.setDataAdmissao(result.getString("dataAdmissao"));
                funcionario.setLogin(result.getString("login"));
                funcionario.setSenha(result.getString("senha"));
                funcionario.setIdPessoa(result.getInt("idPessoa"));
                
                listaFuncionario.add(funcionario);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 3);
        }
        return listaFuncionario;
    }
}
