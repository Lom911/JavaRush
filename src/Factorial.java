import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(int value) {
        BigInteger intRezul = BigInteger.ONE;
        for (int i = 2; i < value + 1; i++) {
            BigInteger cikl = BigInteger.valueOf(i);
            intRezul = intRezul.multiply(cikl);
        }
        return intRezul;
    }

    public static void main(String[] args) {
        int value = 6;
        System.out.println(factorial(value));
    }
}
