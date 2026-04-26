/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.*;


public class Conexao {
    public Connection conexao;
    
    static String usuario = "#######";
    static String senha = "#########";
    static String database = "######";
    
    //static String url = "jdbc:mysql://localhost:3306/" + database; //MySql
    static String url = "jdbc:postgresql://dpg-d7n03b0sfn5c73dp94g0-a.oregon-postgres.render.com:5432/" + database +"?sslmode=require"; //Postgres
    
    public void Conectar(){
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver"); //MySql
            Class.forName("org.postgresql.Driver");
            
            conexao = DriverManager.getConnection(url, usuario, senha);
        }catch(ClassNotFoundException e){
            System.out.println("Erro no driver: "+ e.getMessage());
        }catch(SQLException e){
            System.out.println("Erro de conexao: "+ e.getMessage());
        }
    }
    
    public void CloseConnnection(){
        try{
            conexao.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
