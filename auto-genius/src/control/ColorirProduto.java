
package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Produto;


public class ColorirProduto extends DefaultTableCellRenderer {
    private Component componente;
    ArrayList<Produto> produtos;
    
    public ColorirProduto(ArrayList<Produto> produto) {
        this.produtos = produto;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Produto produto = produtos.get(row);        
        if(Integer.parseInt(table.getValueAt(row, 7).toString()) <= produto.getQuantidadeEstoqueMinimo()){
            this.setForeground(Color.RED);
        }
        else {
            this.setForeground(Color.BLACK);
        }        
        return this;
    }  
}
