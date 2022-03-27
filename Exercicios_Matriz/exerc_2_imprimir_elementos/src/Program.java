import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int linha, coluna, qtdLinhas, qtdColunas, procurarNaMatriz, naoEncontrado = 0;

        qtdLinhas = sc.nextInt();
        qtdColunas = sc.nextInt();
        int matriz[][] = new int[qtdLinhas][qtdColunas];

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz[linha].length; coluna++) {
                matriz[linha][coluna] = sc.nextInt();
            }
        }

        System.out.print("Entre com o elemento a ser procurado: ");
        procurarNaMatriz = sc.nextInt();
        System.out.println();

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz[linha].length; coluna++) {

                if (procurarNaMatriz == matriz[linha][coluna]) {
                    System.out.printf("Posicao %d, %d: \n", linha+1, coluna+1);

                    if (linha > 0) {
                        System.out.printf("Em cima: %d\n", matriz[linha-1][coluna]);
                    }

                    if (linha < matriz.length - 1) {
                        System.out.printf("Embaixo: %d\n", matriz[linha+1][coluna]);
                    }

                    if (coluna > 0) {
                        System.out.printf("A esquerda: %d\n", matriz[linha][coluna-1]);
                    }

                    if (coluna < matriz[linha].length - 1) {
                        System.out.printf("A direita: %d\n", matriz[linha][coluna+1]);
                    }

                    System.out.println();
                } else {
                    naoEncontrado++;
                }
            }
        }

        if (naoEncontrado == qtdLinhas * qtdColunas) {
            System.out.println("Esse elemento nao esta na matriz!");
        }

        sc.close();
    }
}