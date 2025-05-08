import java.util.ArrayList;

public class NotaFiscal {
    private Cliente cliente;
    private ArrayList<ItemProduto> lista;

    public void adicionarNalista(ItemProduto produto) {
        lista.add(produto);
    }

    public double calcularValorNotaFiscal() {
        double soma = 0;
        for (ItemProduto ip : lista) {
            soma += ip.getProduto().getPrecoUnitario();
        }
        return soma;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() +
                "\nProdutos comprados: " + lista;
    }
}
