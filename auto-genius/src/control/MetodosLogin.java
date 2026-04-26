/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.Menu;


public class MetodosLogin {
    Conexao conexao = new Conexao();
    
    public int logar(String user, String senha){
        conexao.Conectar();
        PreparedStatement statement;
        ResultSet result;
        
        String sql = "select * from funcionario "
                + "where login = ? and senha = ?";
        
        try{
            statement = conexao.conexao.prepareStatement(sql);
            
            statement.setString(1, user);
            statement.setString(2, senha);
            
            result = statement.executeQuery();
            
            if(result.next()){
                JOptionPane.showMessageDialog(null, "Bem vindo!");
                
                return 0;
            }else{
                JOptionPane.showMessageDialog(null, "Usuário e senha incorretos",
                        "Aviso", 2);
            }
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return 1;
    }
}
