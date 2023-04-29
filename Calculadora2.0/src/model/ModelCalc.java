package model;

public class ModelCalc {

    public static double calculate(double n1, double n2, Operacao operator) {
        double n3;
        switch (operator) {
            case SOMA:
                return n1 + n2;
            case SUBTRACAO:
                return n1 - n2;
            case DIVISAO:
                return n1 / n2;
            case MULTIPLICACAO:
                return n1 * n2;
            case IGUAL:
                return n1;
        }
        return 0;
    }

    public static boolean checkDecimal(String num) {
        if (!num.contains("."))
            return true;
        else
            return false;
    }

    public static boolean checkInteiro(double num) {
        if (num == (int) num)
            return true;
        else
            return false;
    }
}
