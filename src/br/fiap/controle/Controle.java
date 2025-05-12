package br.fiap.controle;

import br.fiap.cliente.Cliente;
import br.fiap.item.ItemProduto;
import br.fiap.notafiscal.NotaFiscal;
import br.fiap.produto.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class Controle {

    private static List<Cliente> listaCliente = new ArrayList<>();
    private static List<Produto> listaProduto = new ArrayList<>();
    private NotaFiscal nf;

    static {
        //Dados dos clientes
        listaCliente.add(new Cliente(123, "Ana Maria"));
        listaCliente.add(new Cliente(456, "Roberto Carlos"));
        listaCliente.add(new Cliente(789, "Xuxa Maria"));
        //Dados dos produtos
        listaProduto.add(new Produto(1, "Camiseta", 390, 100));
        listaProduto.add(new Produto(2, "Calça", 1500, 1000));
        listaProduto.add(new Produto(3, "Boné", 200, 500));
    }

    public Controle() {
        Random rd = new Random();
        Cliente cliente = listaCliente.get(rd.nextInt(listaCliente.size()));
        nf = new NotaFiscal(cliente);
    }

    private void comprar() {
        int quantidade;
        String nomeProduto = showInputDialog("Qual produto você quer comprar?");
        for (Produto p : listaProduto) {
            if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                quantidade = parseInt(showInputDialog("Qual quatidade será comprada?"));
                p.debitarEstoque(quantidade);
                nf.adicionarItem(new ItemProduto(p, quantidade));
            }


        }
    }

    public void menu() {
        int opcao;
        while (true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
                if (opcao == 5) {
                    return;
                }
                switch (opcao) {
                    case 1:
                        comprar();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        fecharCompra();
                        break;
                    default:
                        showMessageDialog(null, "Opção inválida");
                }
            } catch (Exception e) {
                showMessageDialog(null, e.getMessage());
            }
        }
    }

    private void fecharCompra() {
        double total = 0;
        for (ItemProduto ip : nf.getLista()) {
            total += ip.calcularTotal();
        }
        showMessageDialog(null, "R$" + total);
    }

    private String gerarMenu() {
        return """
                SISTEMA DE COMPRAS ONLINE
                1 - Comprar
                2 - Adicionar Produto
                3 - Remover Produto
                4 - Fechar Compra
                5 - Finalizar Compra
                """;
    }
}
