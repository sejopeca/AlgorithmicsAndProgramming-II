/**
 * SortVectorString
 */
public class SortVectorString {

    public static int minLength(String cad1, String cad2) {
        if (cad1.length() > cad2.length()) {
            return cad2.length();
        } else if (cad2.length() > cad1.length()) {
            return cad1.length();
        }
        return cad1.length();
    }

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

    public static void swapping(String vec[], int pos) {
        String temp = vec[pos];
        vec[pos] = vec[pos + 1];
        vec[pos + 1] = temp;
    }

    public static void main(String[] args) {
        String cad1 = "ariza", cad2 = "Arias";
        System.out.println(compareTo(cad1, cad2));
        System.out.println(cad1.compareTo(cad2));
        String M[][] = { { "Zambrano", "1", "3" }, { "Ariza", "23", "34" }, { "Mendoza", "434", "332" },
                { "Martinez", "434", "332" }, { "Arias", "4", "32w2" }, { "Arias", "4a", "32w2" } };

        for (int i = 0; i < M.length - 1; i++) {
            for (int j = 0; j < M.length - i - 1; j++) {
                if (compareTo(M[j][0], M[j + 1][0]) > 0) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        String temp = M[j][j2];
                        M[j][j2] = M[j + 1][j2];
                        M[j + 1][j2] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(M[i][j] + "|");
            }
            System.out.println("");
        }
    }
}