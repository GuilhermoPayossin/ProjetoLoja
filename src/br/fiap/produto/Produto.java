package br.fiap.produto;

import java.text.DecimalFormat;

public class Produto {
    private long id;
    private String nome;
    private double precoUnitario;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, double precoUnitario, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Produto(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String aux = "";
        aux += "Nome: " + nome + "\n";
        aux += "Valor: R$ " + df.format(precoUnitario) + "\n";
        aux += "Quantidade: " + quantidadeEmEstoque + "\n";
        return aux;
    }

    public void adicionaEstoque(int quantidade) {
        this.quantidadeEmEstoque += quantidade;
    }

    public void debitarEstoque(int quantidade) {
        this.quantidadeEmEstoque -= quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public String getNome() {
        return nome;
    }
}
