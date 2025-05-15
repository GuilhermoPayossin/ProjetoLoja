package br.fiap.item;

import br.fiap.produto.Produto;

import java.text.DecimalFormat;

public class ItemProduto {
    private Produto produto;
    private int quantidadeComprada;

    public ItemProduto(Produto produto, int quantidadeComprada) {
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
    }

    public double calcularTotal() {
        return this.produto.getPrecoUnitario() * this.quantidadeComprada;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String aux = "";
        aux += "Produto: " + produto.getNome() + "\n";
        aux += "Valor unitári: R$ " + produto.getPrecoUnitario() + "\n";
        aux += "Quantidade compradada: " + quantidadeComprada + "\n";
        return aux;
    }
}
