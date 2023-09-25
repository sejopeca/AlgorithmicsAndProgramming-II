
/**
 * @author: sdariza
 * Generate fibonacci into a vector
 */
import java.util.Scanner;
public class Fibonacci {
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);// instantiate scanner object
        int fib[] = new int[100]; //instantiate fib vector : 0<=n<99
        System.out.println("Ingrese n");// print info to read n value
        int n = lea.nextInt();//read n value and store it into variable n
        lea.close(); // close Scanner object!
        fib[0] = 0;// put fib[0] = 0 means f_0 = 0
        fib[1] = 1;//put fib[1] = 1 means f_1 = 1
        // Now we know that f_n = f_{n-1} + f_{n-2} so
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        //Print results
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i]+"|");
        }

    }
}
