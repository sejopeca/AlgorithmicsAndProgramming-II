import java.math.BigDecimal;
import java.util.Scanner;

public class Conversor {

    public static int puntoPos(String num) {
        int i = 0, tam = num.length();
        while (i < tam) {
            if (num.substring(i, i + 1).equals("."))
                return i;
            i++;
        }
        return -1;
    }

    public static String convParteEntera(String parteEntera, int x, int s) {
        String numConvParteEntera = "";
        int coc = Integer.parseInt(parteEntera);
        while (coc != 0) {
            int res = coc % s;
            if (res == 10) {
                numConvParteEntera = "A" + numConvParteEntera;
            } else {
                numConvParteEntera = Integer.toString(res) + numConvParteEntera;
            }
            coc = coc / s;
        }
        return numConvParteEntera;
    }

    public static String convParteDecimal(String parteDecimal, int x, int s) {
        String numConvparteDecimal = "";
        BigDecimal partBigDecimal_aux = new BigDecimal(parteDecimal);
        System.out.println(partBigDecimal_aux);
        BigDecimal baseTo = new BigDecimal(s);
        for (int i = 0; i < 24; i++) {
            partBigDecimal_aux = partBigDecimal_aux.multiply(baseTo);
            if (partBigDecimal_aux.compareTo(BigDecimal.ONE) >= 0) {
                if (partBigDecimal_aux.compareTo(BigDecimal.TEN) >= 0) {
                    partBigDecimal_aux = new BigDecimal(
                            "0." +
                                    partBigDecimal_aux.toString().substring(puntoPos(partBigDecimal_aux.toString()) + 1,
                                            partBigDecimal_aux.toString().length()));
                    numConvparteDecimal = numConvparteDecimal + "A";
                } else {
                    numConvparteDecimal = numConvparteDecimal +
                            partBigDecimal_aux.toString().substring(0, 1);
                    partBigDecimal_aux = new BigDecimal(
                            "0." +
                                    partBigDecimal_aux.toString().substring(puntoPos(partBigDecimal_aux.toString()) + 1,
                                            partBigDecimal_aux.toString().length()));
                }
            } else {
                numConvparteDecimal = numConvparteDecimal +
                        partBigDecimal_aux.toString().substring(0, 1);
                partBigDecimal_aux = new BigDecimal(
                        "0." +
                                partBigDecimal_aux.toString().substring(puntoPos(partBigDecimal_aux.toString()) + 1,
                                        partBigDecimal_aux.toString().length()));

            }

        }
        return numConvparteDecimal;
    }

    public static String convertir(String num, int x, int s) {
        String numConv = "";
        BigDecimal coc = new BigDecimal(num);

        System.out.println(coc);
        return numConv;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        int x = 10;
        int s = 11;
        String parteEntera = convParteEntera(num.substring(0, puntoPos(num)), x, s);
        String parteDecimal = convParteDecimal("0." + num.substring(puntoPos(num) + 1, num.length()), x, s);
        System.out.println(parteEntera + "." + parteDecimal);
        input.close();
    }
}
