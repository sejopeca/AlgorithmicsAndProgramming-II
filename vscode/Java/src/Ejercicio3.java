import java.util.Scanner;

public class Ejercicio3 {

    static Scanner input = new Scanner(System.in);

    /**
     * Leer matrix
     * 
     * @param A: matriz
     * @param n: número de filas
     * @param m: número de columnas
     */
    public static void leerMatrix(int A[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("Ingrese el valor de la posición: A[%d,%d]", i, j);
                A[i][j] = input.nextInt();
            }
        }
    }

    /**
     * Imprimir matriz
     * 
     * @param A: matriz
     * @param n: número de filas
     * @param m: número de columnas
     */
    public static void impMatrix(int A[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + "|");
            }
            System.out.println("");
        }
    }

    /**
     * Obtiene el mayor elemento de una matriz
     * 
     * @param A: matriz
     * @param n: número de filas
     * @param m: número de columnas
     * @return: mayor elemento
     */
    public static int mayorElemMatriz(int A[][], int n, int m) {
        int mayor = A[0][0], z = 1;
        for (int i = 0; i < n; i++) {
            for (int j = z; j < m; j++) {
                if (mayor < A[i][j]) {
                    mayor = A[i][j];
                }
            }
            z = 0;
        }
        return mayor;
    }

    /**
     * Calcular transpuesta de una matriz
     * 
     * @param A:  Matriz a ser transpuesta
     * @param n:  número de filas A
     * @param m:  número de columnas de A
     * @param AT: Matriz con la transpuesta de A
     */
    public static void transpuesta(int A[][], int n, int m, int AT[][]) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                AT[i][j] = A[j][i];
            }
        }
    }

    /**
     * Este método nos ayuda a calcular (AT)(A)
     * 
     * @param A: Matriz izq
     * @param B: Matriz der
     * @param n: número de columnas de A
     * @param m: número de filas de B
     * @param C: matrix with AB, C = AB
     *           Recuerde: ATA = C, entonces ATA tiene dimensión m x m
     */
    public static void multMatrizNC(int A[][], int B[][], int n, int m, int C[][]) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] = A[i][k] * B[k][j] + C[i][j];
                }
            }
        }
    }

    /**
     * Este método calcula (H)(ATA) y lo almacena en C para la i-ésima iteración
     * 
     * @param H:   Matriz izquierda: almacena lo que lleva en (ATA)(ATA) en la
     *             i-ésima iteración
     * @param ATA: Matriz de la derecha
     * @param m:   dimension cuadrada mxm.
     * @param C:   Matriz para almadenar (H)(ATA) en la i-ésima iteración
     */
    public static void ATANVeces(int H[][], int ATA[][], int m, int C[][]) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int cont = 0;
                for (int k = 0; k < m; k++) {
                    cont = cont + H[i][k] * ATA[k][j];
                }
                C[i][j] = cont;
            }
        }
    }

    /**
     * Método para copiar una matriz en otra: nos ayuda a actualizar la matriz H
     * 
     * @param A: Matriz a copiar
     * @param m: dimensiones cuadradas mxm
     * @param C: Matriz con la copia de A
     *           Recuerde que debemos actualizar en H lo que se lleva en (H)(ATA) =
     *           C
     */
    public static void copiarMatriz(int A[][], int m, int C[][]) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = A[i][j];
            }
        }
    }

    /**
     * Calcula (ATA)(ATA)...(ATA), n-veces
     * 
     * @param H:   Matriz izquierda con (ATA)(ATA) en la i-ésima iteración
     * @param ATA: Matriz derecha (ATA)
     * @param m:   dimensiones cuadradas mxm
     * @param C:   Matriz para almacenar (ATA)(ATA) in la i-ésima iteración
     * @param n:   número de veces a calcular (ATA)(ATA)
     */
    public static void multATAN(int H[][], int ATA[][], int m, int C[][], int n) {
        for (int i = 0; i < n - 1; i++) {
            ATANVeces(H, ATA, m, C);
            copiarMatriz(C, m, H);
        }
    }

    public static void main(String[] args) {
        int A[][] = new int[100][100];
        int AT[][] = new int[100][100];
        int ATA[][] = new int[100][100];
        int H[][] = new int[100][100];
        int C[][] = new int[100][100];
        int n, m;
        System.out.println("Digite el número de filas");
        n = input.nextInt();
        System.out.println("Digite el número de columnas");
        m = input.nextInt();
        leerMatrix(A, n, m);
        System.out.println("Los elementos leídos en A son:");
        impMatrix(A, n, m);
        System.out.println("El mayor elemento es:" + mayorElemMatriz(A, n, m));
        System.out.println("(ATA)^n es:");
        transpuesta(A, n, m, AT);
        System.out.println("AT");
        impMatrix(AT, m, n);
        multMatrizNC(AT, A, n, m, ATA);
        System.out.println("ATA");
        impMatrix(ATA, m, m);
        copiarMatriz(ATA, m, H);
        copiarMatriz(ATA, m, C);// lo ideal es llenar a C con nada al inicio
        System.out.println("(ATA)(ATA)...(ATA) n veces es:");
        multATAN(H, ATA, m, C, n);
        impMatrix(H, m, m);
    }
}
