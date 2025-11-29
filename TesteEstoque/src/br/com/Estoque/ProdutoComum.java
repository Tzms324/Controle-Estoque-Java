package br.com.Estoque;

public class ProdutoComum extends Produto {

    public ProdutoComum(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    @Override
    public String getTipo() {
        return "Produto Comum";
    }
}