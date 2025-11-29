package br.com.Estoque;

public class ProdutoPerecivel extends Produto {

    private String dataValidade;

    public ProdutoPerecivel(String nome, double preco, int quantidade, String dataValidade) {
        super(nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    @Override
    public String getTipo() {
        return "Perecível - Validade: " + dataValidade;
    }
}