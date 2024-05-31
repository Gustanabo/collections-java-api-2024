package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void AdicionarItem(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void RemoverItem(String nomeString) {
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item item : itemList) {
            if (item.getNome().equalsIgnoreCase(nomeString)) {
                itensParaRemover.add(item);
            }
        }
        itemList.removeAll(itensParaRemover);
    }

    public double CalcularValorTotal() {
        double valorTotal = 0;
        for (Item item : itemList) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }

    public void ExibirItens() {
        System.out.println(itemList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        System.out.println("Preço total do carrinho de compras: " + carrinhoDeCompras.CalcularValorTotal());
        carrinhoDeCompras.AdicionarItem("Margarina", 4.5, 1);
        carrinhoDeCompras.AdicionarItem("Café", 10, 1);
        carrinhoDeCompras.AdicionarItem("Cacetinho", 0.5, 8);
        carrinhoDeCompras.AdicionarItem("Azeite de Oliva", 800, 10);
        System.out.println("Preço total do carrinho de compras: " + carrinhoDeCompras.CalcularValorTotal());
        carrinhoDeCompras.RemoverItem("Azeite de Oliva");
        System.out.println("Preço total do carrinho de compras: " + carrinhoDeCompras.CalcularValorTotal());
        carrinhoDeCompras.ExibirItens();
    }
}
