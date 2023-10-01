import java.util.Scanner;

public class ValidarEntero {

    /**
     * @param cad
     * @return boolean
     */
    public static boolean validarEntero(String cad) {
        Integer tam = cad.length(), i = 0;
        boolean sw = true;
        while (i < tam && sw) {
            String h = cad.substring(i, i + 1);
            if (h.equals("0") || h.equals("1") || h.equals("2") || h.equals("3") || h.equals("4") || h.equals("5")
                    || h.equals("6") || h.equals("7") || h.equals("8") || h.equals("9")) {
                i++;
            } else if (i == 0 && h.equals("-")) {
                i++;
            } else {
                sw = false;
            }
        }
        return sw;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num = "";
        boolean val;
        num = input.nextLine();
        val = validarEntero(num);
        if (val) {
            System.out.println("Lo ingresado es un número entero");
        } else {
            System.out.println("Lo ingresaso NO es un número entero");
        }
        input.close();
    }
}
