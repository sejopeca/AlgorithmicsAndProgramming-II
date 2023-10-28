/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assessment2;

import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Assessment2 {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static int k = 0, l = 0;

    public static boolean validarElementoMatriz(String cadena) {
        int tam = cadena.length();
        if (tam < 3 || tam > 9) {
            return false;
        }
        int i = 0;
        boolean sw = true;
        while (i < tam && sw) {
            int h = (int) cadena.charAt(i);
            if ((65 <= h && h <= 90) || (97 <= h && h <= 122) || (48 <= h && h <= 57)) {
                i++;
            } else {
                sw = false;
            }
        }
        return sw;

    }

    public static void leerMatriz(String M[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("Ingrese el elemento en la posición:M[%d,%d]", i, j);
                String c = input.nextLine();
                while (!validarElementoMatriz(c)) {
                    System.out.printf("Ingrese el elemento en la posición:M[%d,%d]", i, j);
                    c = input.nextLine();
                }
                M[i][j] = c;
            }
        }
    }

    public static void imprimirMatriz(String M[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(M[i][j] + "|");
            }
            System.out.println(" ");
        }
    }

    public static void imprimirVectorCadenas(String v[], int n) {
        for (int i = 0; i < n; i++) {

            System.out.println(v[i] + "|");
        }
    }

    public static void imprimirEnteros(int v[], int n) {
        for (int i = 0; i < n; i++) {

            System.out.println(v[i] + "|");
        }
    }

    public static int contCaracter(String M[][], int n, int m, String caracter) {
        int cont = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j].substring(0, 1).equals(caracter)) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static boolean esPrimo(int n) {
        int div = 1;
        int contDiv = 0;
        while (div <= n && contDiv <= 2) {
            if (n % div == 0) {
                contDiv++;
            }
            div++;
        }
        if (contDiv == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean esPalindromo(String cadena) {
        boolean sw = true;
        int mitadCadena = cadena.length() / 2;
        int tam = cadena.length();
        cadena = cadena.toUpperCase();
        int i = 0;
        while (i <= mitadCadena && sw) {
            if (cadena.substring(i, i + 1).equals(cadena.substring(tam - i - 1, tam - i))) {
                i++;
            } else {
                sw = false;
            }
        }
        return sw;
    }

    public static boolean cadenaEntero(String cadena) {
        boolean sw = true;
        int tam = cadena.length();
        int i = 0;
        while (i < tam && sw) {
            int h = (int) cadena.charAt(i);
            if ((48 <= h && h <= 57)) {
                i++;
            } else {
                sw = false;
            }

        }
        return sw;
    }

    public static boolean cadenaAlfabeta(String cadena) {
        boolean sw = true;
        int tam = cadena.length();
        int i = 0;
        while (i < tam && sw) {
            int h = (int) cadena.charAt(i);
            if ((65 <= h && h <= 90) || (97 <= h && h <= 122)) {
                i++;
            } else {
                sw = false;
            }

        }
        return sw;
    }

    public static boolean estaEnVectorEntero(int v[], int elem) {
        boolean sw = false;
        int i = 0;
        while (i < l && !sw) {
            if (v[i] != elem) {
                i++;
            } else {
                sw = true;
            }
        }
        return sw;
    }

    public static boolean estaEnVectorPalindromo(String v[], String elem) {
        boolean sw = false;
        int i = 0;
        while (i < k && !sw) {
            if (!v[i].equals(elem)) {
                i++;
            } else {
                sw = true;
            }
        }
        return sw;
    }

    /**
     *
     * @param v
     * @param k
     * @param M
     * @param n
     * @param m
     */
    public static void generarVectorPrimo(int v[], String M[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cadenaEntero(M[i][j])) {
                    if (esPrimo(Integer.parseInt(M[i][j])) && !estaEnVectorEntero(v, Integer.parseInt(M[i][j]))) {
                        v[l] = Integer.parseInt(M[i][j]);
                        l++;
                    }
                }
            }
        }
    }

    public static void generarVectorPalindromos(String v[], String M[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cadenaAlfabeta(M[i][j])) {
                    if (esPalindromo(M[i][j]) && !estaEnVectorPalindromo(v, M[i][j])) {
                        v[k] = M[i][j];
                        k++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        String M[][] = new String[100][100];
        String z[] = new String[100 * 100];
        int v[] = new int[100 * 100];
        System.out.println("Ingrese el número de filas");
        int n = input.nextInt();

        System.out.println("Ingrese el número de columnas");
        int m = input.nextInt();

        leerMatriz(M, n, m);
        System.out.println("# de cadenas que empienzan con A : " + contCaracter(M, n, m, "A"));
        System.out.println("# de cadenas que empienzan con L: " + contCaracter(M, n, m, "L"));
        System.out.println("# de cadenas que empienzan con Z: " + contCaracter(M, n, m, "Z"));

        generarVectorPalindromos(z, M, n, m);
        imprimirVectorCadenas(z, k);

        generarVectorPrimo(v, M, n, m);
        imprimirEnteros(v, l);
    }

}
