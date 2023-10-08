/**
 * SortVectorString
 */
public class SortingStringMatrix {

    /**
     * Get min lenght given 2 Strings
     * 
     * @param cad1
     * @param cad2
     * @return minlenght between cad1 and cad2
     */
    public static int minLength(String cad1, String cad2) {
        if (cad1.length() > cad2.length()) {
            return cad2.length();
        } else if (cad2.length() > cad1.length()) {
            return cad1.length();
        }
        return cad1.length();
    }

    /**
     * compare 2 strings
     * 
     * @param cad1
     * @param cad2
     * @return diff between cad1 and cad2
     */
    public static int compareTo(String cad1, String cad2) {
        int minLength = minLength(cad1, cad2);
        boolean sw = false;
        int i = 0, diff = 0;
        while (!sw && i < minLength) {
            if (cad1.charAt(i) != cad2.charAt(i)) {
                sw = true;
                diff = cad1.charAt(i) - cad2.charAt(i);
            } else {
                i++;
            }
        }
        if (!sw) {
            diff = cad1.length() - cad2.length();
        }

        return diff;
    }

    /**
     * swapp v[j] with v[j+1]
     * 
     * @param vec
     * @param pos
     */
    public static void swapping(String vec[], int pos) {
        String temp = vec[pos];
        vec[pos] = vec[pos + 1];
        vec[pos + 1] = temp;
    }

    /**
     * Sort matrix by one column 0 using bubble sort method
     * 
     * @param M: matriz to sort
     * @param n: rows
     * @param m: columns
     */
    public static void bubbleSortMatrix(String M[][], int n, int m) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareTo(M[j][0], M[j + 1][0]) > 0) {
                    for (int j2 = 0; j2 < m; j2++) {
                        String temp = M[j][j2];
                        M[j][j2] = M[j + 1][j2];
                        M[j + 1][j2] = temp;
                    }
                }
            }
        }
    }

    /**
     * Print matrix
     * 
     * @param M: matrix
     * @param n: rows
     * @param m: columns
     */
    public static void printStringMatrix(String M[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(M[i][j] + "|");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        String M[][] = { { "Zambrano", "1", "3" }, { "Ariza", "23", "34" }, { "Mendoza", "434", "332" },
                { "Martinez", "434", "332" }, { "Arias", "4", "32w2" }, { "Arismendi", "4a", "32w2" } };
        System.out.println("Last name|cod1|cod2");
        bubbleSortMatrix(M, M.length, 3);
        printStringMatrix(M, M.length, 3);
    }
}