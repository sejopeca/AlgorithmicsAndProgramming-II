public class ContarElementosVector {

    /**
     * Función para contar cuántas veces aparece un elemento en un vector.
     * Teniendo en cuenta una instancia previa, es decir se valida desde
     * la dimensión del vector hasta su primera posición
     * 
     * @param v     : vector de enteros
     * @param i:    posición del vector // en el primer ejecución i == v.lenght-1
     * @param elem: elemento a contar
     * @return el # de veces que se encontró elem en el vector.
     */
    public static int contarElementosPrevia(int v[], int i, int elem) {
        if (i == -1) {
            return 0;
        } else if (v[i] == elem) {
            return contarElementosPrevia(v, i - 1, elem) + 1;
        } else {
            return contarElementosPrevia(v, i - 1, elem);
        }
    }

    public static void main(String[] args) {
        int v[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 101, 12, 1, 3, 1, 3, 2, 4, 3, 5, 4, 2, 4, 5, 32, 4, 2 };
        System.out.printf("El elemento %d se encuentra %d veces", 10, contarElementosPrevia(v, v.length - 1, 10));
    }
}
