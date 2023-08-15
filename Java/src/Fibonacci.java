import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        int fib[] = new int[100];
        System.out.println("Ingrese n");
        int n = lea.nextInt();
        lea.close();
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i]+"|");
        }

    }
}
