package br.com.Estoque;

import java.util.*;
import br.com.Estoque.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GerenciadorEstoque sistema = new GerenciadorEstoque();

        int opc = -1;

        while (opc != 0) {

            System.out.println("\n==== SISTEMA DE ESTOQUE ====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Entrada de Estoque");
            System.out.println("3 - Saída de Estoque");
            System.out.println("4 - Listar Produtos");
            System.out.println("5 - Sair");
            opc = sc.nextInt();
            sc.nextLine(); // limpar buffer

            try {

                switch (opc) {

                    case 1:
                        System.out.println("\n--- CADASTRAR PRODUTO ---");
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();

                        System.out.print("Quantidade inicial: ");
                        int qtd = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Tipo:");
                        System.out.println("1 - Comum");
                        System.out.println("2 - Perecível");
                        int tipo = sc.nextInt();
                        sc.nextLine();

                        if (tipo == 1) {
                            sistema.adicionarProduto(new ProdutoComum(nome, preco, qtd));
                        } else if (tipo == 2) {
                            System.out.print("Data de validade: ");
                            String validade = sc.nextLine();
                            sistema.adicionarProduto(new ProdutoPerecivel(nome, preco, qtd, validade));
                        } else {
                            System.out.println("Tipo inválido!");
                        }

                        break;

                    case 2:
                        System.out.println("\n--- ENTRADA NO ESTOQUE ---");
                        System.out.print("Nome do produto: ");
                        String nomeEntrada = sc.nextLine();

                        System.out.print("Quantidade: ");
                        int qtdEntrada = sc.nextInt();

                        sistema.entradaEstoque(nomeEntrada, qtdEntrada);
                        System.out.println("Entrada realizada!");
                        break;

                    case 3:
                        System.out.println("\n--- SAÍDA DO ESTOQUE ---");
                        System.out.print("Nome do produto: ");
                        String nomeSaida = sc.nextLine();

                        System.out.print("Quantidade: ");
                        int qtdSaida = sc.nextInt();

                        sistema.saidaEstoque(nomeSaida, qtdSaida);
                        System.out.println("Saída realizada!");
                        break;

                    case 4:
                        sistema.listar();
                        break;

                    case 5:
                        System.out.println("Encerrando o sistema...");
                        System.out.println("Até a próxima");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (EstoqueException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
    }
}