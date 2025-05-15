package br.fiap.notafiscal;

import br.fiap.cliente.Cliente;
import br.fiap.item.ItemProduto;
import br.fiap.produto.Produto;

import java.util.ArrayList;

public class NotaFiscal {
    private Cliente cliente;
    private ArrayList<ItemProduto> lista;
    private boolean status;

    public NotaFiscal(Cliente cliente) {
        this.cliente = cliente;
        this.lista = new ArrayList<ItemProduto>();
        this.status = true;
    }

    public void adicionarItem(ItemProduto produto) {
        lista.add(produto);
    }

    public void removerItem(Produto produto) {
        for (ItemProduto ip : lista) {
            if (ip.getProduto().equals(produto)) {
                lista.remove(ip);
            }
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemProduto ip : lista) {
            total += ip.getProduto().getPrecoUnitario();
        }
        return total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<ItemProduto> getLista() {
        return lista;
    }
}
