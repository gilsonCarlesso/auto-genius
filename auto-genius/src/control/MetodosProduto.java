
package control;

import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MetodosProduto {
    Conexao conexao = new Conexao();
    
    public void inserirProduto(Produto produto){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("insert "
                    + "into produtos(nomeProduto, numeroProduto, descricao, marca, "
                    + "precoCompra, precoVenda, quantidadeEstoque, quantidadeEstoqueMinimo, "
                    + "categoria, localArmazenamento, idEstoque) values (?,?,?,?,?,?,?,?,?,?,?)");
            
            statement.setString(1, produto.getNomeProduto());
            statement.setInt(2, produto.getNumeroProduto());
            statement.setString(3, produto.getDescricao());
            statement.setString(4, produto.getMarca());
            statement.setDouble(5, produto.getPrecoCompra());
            statement.setDouble(6, produto.getPrecoVenda());
            statement.setInt(7,produto.getQuantidadeEstoque());
            statement.setInt(8,produto.getQuantidadeEstoqueMinimo());
            statement.setString(9, produto.getCategoria());
            statement.setString(10, produto.getLocalArmazenamento());
            statement.setInt(11, produto.getIdEstoque());
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
        }
    }
    
    public void alterar(Produto produto, int idProduto){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "produtos set nomeProduto = ?, numeroProduto = ?, descricao = ?,"
                    + "marca = ?, precoCompra = ?, precoVenda = ?, quantidadeEstoque = ?, "
                    + "quantidadeEstoqueMinimo = ?, categoria = ?, localArmazenamento = ?, "
                    + "idEstoque = ? where idProduto = ?");
            
            statement.setString(1, produto.getNomeProduto());
            statement.setInt(2, produto.getNumeroProduto());
            statement.setString(3, produto.getDescricao());
            statement.setString(4, produto.getMarca());
            statement.setDouble(5, produto.getPrecoCompra());
            statement.setDouble(6, produto.getPrecoVenda());
            statement.setInt(7,produto.getQuantidadeEstoque());
            statement.setInt(8,produto.getQuantidadeEstoqueMinimo());
            statement.setString(9, produto.getCategoria());
            statement.setString(10, produto.getLocalArmazenamento());
            statement.setInt(11, produto.getIdEstoque());
            statement.setInt(12, idProduto);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
    }
    
    public void deletar(int idProduto){
        conexao.Conectar();
        
        try{
            CallableStatement statement = conexao.conexao.prepareCall("call deletaProduto(?)");
            
            statement.setInt(1, idProduto);
            
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(), "Erro", 0);
            JOptionPane.showMessageDialog(null,"Este produto esta vinculado a um ordem de serviço realizada","Aviso",2);
        }
    }
    
    public ArrayList tabela(){
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        
        conexao.Conectar();
        
        try{
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "idProduto, nomeProduto, numeroProduto, descricao, marca, "
                    + "precoCompra, precoVenda, quantidadeEstoque, "
                    + "quantidadeEstoqueMinimo from produtos "
                    + "order by idproduto");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto(result.getInt("idProduto"));
                produto.setNomeProduto(result.getString("nomeProduto"));
                produto.setNumeroProduto(result.getInt("numeroProduto"));
                produto.setDescricao(result.getString("descricao"));
                produto.setMarca(result.getString("marca"));
                produto.setPrecoCompra(result.getDouble("precoCompra"));
                produto.setPrecoVenda(result.getDouble("precoVenda"));
                produto.setQuantidadeEstoque(result.getInt("quantidadeEstoque"));
                produto.setQuantidadeEstoqueMinimo(result.getInt("quantidadeEstoqueMinimo"));
                
                listaProduto.add(produto);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaProduto;
    }
    
    public ArrayList buscaProduto(String nomeProduto){
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        
        conexao.Conectar();
        
        try{
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "idProduto, nomeProduto, marca, precoVenda, quantidadeEstoque "
                    + "from produtos where nomeProduto ilike '%"+ nomeProduto +"%' "
                    + "order by idProduto");
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto(result.getInt("idProduto"));
                produto.setNomeProduto(result.getString("nomeProduto"));
                produto.setMarca(result.getString("marca"));
                produto.setPrecoVenda(result.getDouble("precoVenda"));
                produto.setQuantidadeEstoque(result.getInt("quantidadeEstoque"));
                
                listaProduto.add(produto);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaProduto;
    }
    
    public ArrayList dados(int idProduto){
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("select "
                    + "* from produtos where idProduto = ?");
            
            statement.setInt(1, idProduto);
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto(result.getInt("idProduto"));
                produto.setNomeProduto(result.getString("nomeProduto"));
                produto.setNumeroProduto(result.getInt("numeroProduto"));
                produto.setDescricao(result.getString("descricao"));
                produto.setMarca(result.getString("marca"));
                produto.setPrecoCompra(result.getDouble("precoCompra"));
                produto.setPrecoVenda(result.getDouble("precoVenda"));
                produto.setQuantidadeEstoque(result.getInt("quantidadeEstoque"));
                produto.setQuantidadeEstoqueMinimo(result.getInt("quantidadeEstoqueMinimo"));
                produto.setCategoria(result.getString("categoria"));
                produto.setLocalArmazenamento(result.getString("localArmazenamento"));
                produto.setIdEstoque(result.getInt("idEstoque"));
                
                listaProduto.add(produto);
            }
            
            result.close();
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 3);
        }
        return listaProduto;
    }
    
    public void updateProduto(int quantidade, int id){
        try{
            conexao.Conectar();
            
            PreparedStatement statement = conexao.conexao.prepareStatement("update "
                    + "produtos set quantidadeEstoque = ? where idProduto = ?");
            
            statement.setInt(1, quantidade);
            statement.setInt(2, id);
            
            statement.execute();
            
            statement.close();
            conexao.CloseConnnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", 0);
        }
    }
}
