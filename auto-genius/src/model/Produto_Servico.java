/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Produto_Servico {
    private int idProduto_Servico;
    private int idProduto;
    private int idServico;
    private int quantidadeRequerida;

    public int getIdProduto_Servico() {
        return idProduto_Servico;
    }

    public void setIdProduto_Servico(int idProduto_Servico) {
        this.idProduto_Servico = idProduto_Servico;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getQuantidadeRequerida() {
        return quantidadeRequerida;
    }

    public void setQuantidadeRequerida(int quantidadeRequerida) {
        this.quantidadeRequerida = quantidadeRequerida;
    }
}
