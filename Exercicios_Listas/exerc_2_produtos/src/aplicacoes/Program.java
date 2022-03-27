package aplicacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;

public class Program {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int qtdProdutos, listarProdutos = 1;
        List<Produto> lista = new ArrayList<>();
        
        System.out.print("Quantos produtos serao cadastrados no estoque? ");
        qtdProdutos = sc.nextInt();

        for (int i = 0; i < qtdProdutos; i++) {

            System.out.println();
            System.out.printf("Produto #%d:\n", i+1);

            System.out.print("Codigo: ");
            Integer codigo = sc.nextInt();
            while (validarCodigo(lista, codigo)) {
                System.out.print("Esse codigo ja existe! Tente novamente: ");
                codigo = sc.nextInt();
            }

            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Preco de compra: ");
            Double precoCompra = sc.nextDouble();
            System.out.print("Preco de venda: ");
            Double precoVenda = sc.nextDouble();
            System.out.print("Quantidade em estoque: ");
            Integer qtdEstoque = sc.nextInt();

            Produto pdt = new Produto(codigo ,nome, precoCompra, precoVenda, qtdEstoque);

            lista.add(pdt);
        }

        System.out.println();
        System.out.println("+-----------------------------------+"); 
        System.out.println("|  L I S T A  D E  P R O D U T O S  |");
        System.out.println("+-----------------------------------+");
        
        for (Produto pdt : lista ) {
            System.out.println("---------------------------");
            System.out.printf("\tProduto #%d:\n\n", listarProdutos);
            System.out.println(pdt);
            System.out.println("---------------------------");
            System.out.println();
            listarProdutos++;
        }

        sc.close();
    }

    /**
     * Método para verificar se o código do produto já existe
     * 
     * @param lista Lista de objetos, nesse caso as propriedades de cada produto
     * @param codigo código do novo produto que vai ser verificado
     * @return verdadeiro ou falso
     */
    public static boolean validarCodigo(List<Produto> lista, Integer codigo) {
        Produto pdt = lista.stream().filter(x -> x.getCodigo() == codigo).findFirst().orElse(null);
        return pdt != null;
    }
}
