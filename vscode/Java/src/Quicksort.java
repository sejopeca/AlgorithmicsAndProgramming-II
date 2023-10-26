public class Quicksort {
    /**
     * Busca la posición del menor elemento que pivote
     * 
     * @param v : vector
     * @param i : posición en i
     * @param p : posición del pivote
     * @return posición del menor elemento que el pivote
     */
    public static int rightMove(int v[], int i, int p) {
        if (v[i] < v[p]) // mq(v[i]<v[p])
            return rightMove(v, i + 1, p);
        return i;
    }

    /**
     * Busca la posición del mayor elemento que pivote
     * 
     * @param v : vector
     * @param j : posición en j
     * @param p : posición del pivote
     * @return posición del mayor elemento que el pivote
     */
    public static int leftMove(int v[], int j, int p) {
        if (v[j] > v[p]) // mq(v[j] > v[p])
            return leftMove(v, j - 1, p);
        return j;
    }

    /**
     * Intercambia el elemento del vector
     * 
     * @param v: vector
     * @param i  : posición en i
     * @param j  : posición en j
     */
    public static void swapping(int v[], int i, int j) {
        int t = v[i];
        v[i] = v[j];
        v[j] = t;
    }

    /**
     * Método de quicksort
     * 
     * @param v     : vector
     * @param first : posición inicial
     * @param last  : posición final
     */

    public static void quickSort(int v[], int first, int last) {
        if (first < last) { // mq(pueda particionar)
            int i = first, j = last, p = (first + last) / 2;
            i = rightMove(v, i, p); // busco la posición a izq
            j = leftMove(v, j, p); // busco la posición a der
            if (i <= j) { // si están dentro del rango
                // printVec(v, v.length);
                swapping(v, i, j); // intercambio
                i++; // aumento la derecha y sigo ordenando
                j--; // reduzco a izq y sigo ordenando
            }
            if (first < j) // hay elementos en la izq por ordenar
                quickSort(v, first, j);
            if (i < last) // hay elementos a la derecha por ordenar
                quickSort(v, i, last);
        }
    }

    /**
     * Método para imprimir el vector
     * 
     * @param v
     * @param n
     */
    public static void printVec(int v[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(v[i] + "  | ");

        System.out.println("");
    }

    /**
     * Director de la orquesta
     * 
     * @param args
     */
    public static void main(String[] args) {
        int v[] = { 6, 14, 17, 1, 16, 5, 15, 2, 11, 10, 13 };
        int n = v.length;
        quickSort(v, 0, n - 1);
        printVec(v, n);
    }
}
