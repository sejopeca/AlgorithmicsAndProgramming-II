import java.util.Scanner;

/**
 * @author sdariza
 * Given 2 vector x[n], y[n] where x and y have digits
 * of 2 numbers respectively create a vector sum to store x[i] + y[i] 
 * and print sum vector.
 */

public class SumaVector {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in); //  instantiate scanner object
        int x[] = new int[100]; // instantiate x[n] vector: 0<=n<=99
        int y[] = new int[100]; // instantiate y[n] vector: 0<=n<=99
        int sum[] = new int[101];// instantiate sum[n] vector: 0<=n<=100
        int n, r = 0, sumando = 0;// instantiate variables needed
        System.out.println("Escriba la dim");// print info to read n value
        n = lea.nextInt();//read n value and store it into variable n
        for (int i = 0; i < n; i++) {//reading x[i] elements
            System.out.printf("Ingrese x[%d]", i);
            x[i] = lea.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("Ingrese y[%d]", i);//reading y[i] elements
            y[i] = lea.nextInt();
        }
        lea.close();// close Scanner object !

        for (int i = n - 1; i >= 0; i--) {// storing x[i]+y[i] into sum[i]
            sumando = x[i] + y[i] + r;// r--> helps us to add decimal, remind: x[i]+y[i]+1<=19
            if (sumando >= 10) {// x[i]+y[i] >=10 ---> r = 1, we just store x[i]+y[i]-10 into sum[i]
                sum[i + 1] = sumando - 10;
                r = 1;
            } else {
                sum[i + 1] = sumando;// x[i]+y[i] < 10 --> r = 0
                r = 0;
            }
        }
        if (r == 1) {// we have to add into sum[0] = 1 --> 0<=i<n+1
            sum[0] = 1;
            for (int i = 0; i < n + 1; i++) {
                System.out.print(sum[i] + "|");
            }
        } else {//r = 0--> omit 0 --> 0<i<n+1
            for (int i = 1; i < n + 1; i++) {
                System.out.print(sum[i] + "|");
            }
        }

    }
}
