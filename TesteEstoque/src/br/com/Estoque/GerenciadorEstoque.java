package br.com.Estoque;

import java.util.ArrayList;
import java.util.List;

import br.com.Estoque.*;

public class GerenciadorEstoque {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public Produto buscar(String nome) throws EstoqueException {
        return produtos.stream()
            .filter(p -> p.getNome().equalsIgnoreCase(nome))
            .findFirst()
            .orElseThrow(() -> new EstoqueException("Produto não encontrado!"));
    }

    public void entradaEstoque(String nome, int qtd) throws EstoqueException {
        if (qtd <= 0) {
            throw new EstoqueException("Quantidade inválida!");
        }

        Produto p = buscar(nome);
        p.adicionarEstoque(qtd);
    }

    public void saidaEstoque(String nome, int qtd) throws EstoqueException {
        Produto p = buscar(nome);

        if (qtd > p.getQuantidade()) {
            throw new EstoqueException("Estoque insuficiente!");
        }

        p.removerEstoque(qtd);
    }

    public void listar() {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        for (Produto p : produtos) {
            System.out.println(
                p.getNome() + " | " + 
                p.getTipo() + " | Quantidade: " + p.getQuantidade() + 
                " | Preço: R$" + p.getPreco()
            );
        }
    }
}