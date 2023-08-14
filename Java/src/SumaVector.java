import java.util.Scanner;

public class SumaVector {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        int x[] = new int[100];
        int y[] = new int[100];
        int sum[] = new int[101];
        int n, r = 0, sumando = 0;
        System.out.println("Escriba la dim");
        n = lea.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("Ingrese x[%d]", i);
            x[i] = lea.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("Ingrese y[%d]", i);
            y[i] = lea.nextInt();
        }
        lea.close();

        for (int i = n - 1; i >= 0; i--) {
            sumando = x[i] + y[i] + r;
            if (sumando >= 10) {
                sum[i + 1] = sumando - 10;
                r = 1;
            } else {
                sum[i + 1] = sumando;
                r = 0;
            }
        }
        if (r == 1) {
            sum[0] = 1;
            for (int i = 0; i < n + 1; i++) {
                System.out.print(sum[i] + "|");
            }
        } else {
            for (int i = 1; i < n + 1; i++) {
                System.out.print(sum[i] + "|");
            }
        }

    }
}
