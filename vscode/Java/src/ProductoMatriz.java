import java.util.Scanner;

public class ProductoMatriz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A[][] = new int [101][101];
        int B[][] = new int [101][101];
        int C[][] = new int [101][101];
        int n, m, q, ac;
        System.out.println("Digite n");
        n = input.nextInt();
        System.out.println("Digite m");
        m = input.nextInt();
        System.out.println("Digite q");
        q = input.nextInt();
        if (n>0 && m > 0  && q >0) {
            System.out.println("Ingrese los elementos de A");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.printf("Escriba A[%d,%d]",i,j);
                    A[i][j] = input.nextInt();
                }
            }
            System.out.println("Ingrese los elementos de B");
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= q; j++) {
                    System.out.printf("Escriba B[%d,%d]",i,j);
                    B[i][j] = input.nextInt();

                }
            }
            input.close();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= q; j++) {
                    ac = 0;
                    for (int k = 1; k <= m; k++) {
                        ac = ac + A[i][k] * B[k][j];
                    }
                    C[i][j]= ac;
                }
            }
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= q; j++) {
                    System.out.print(C[i][j]+"|");
                }
                System.out.println("");
            }

        }
    }
}
