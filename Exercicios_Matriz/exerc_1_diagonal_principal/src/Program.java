import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int tamanhoMatriz, linha, coluna, contarNegativos = 0;

        tamanhoMatriz = sc.nextInt();
        int matriz[][] = new int[tamanhoMatriz][tamanhoMatriz];

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz[linha].length; coluna++) {
                matriz[linha][coluna] = sc.nextInt();
            }
        }

        System.out.print("Main diagonal: ");
        for (linha = 0; linha < matriz.length; linha++) {
            System.out.print(matriz[linha][linha] + " ");
        }
        System.out.println();

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz[linha].length; coluna++) {
                
                if (matriz[linha][coluna] < 0) {
                    contarNegativos++;
                }
            }
        }
        
        System.out.println("Negative numbers: " + contarNegativos);

        sc.close();
    }
}
