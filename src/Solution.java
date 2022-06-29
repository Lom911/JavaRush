import java.math.BigInteger;
public class Solution {


    public static BigInteger factorial(int value) {
        BigInteger intRezul = new BigInteger("1");
        for (int i = 1; i < value + 1; i++) {
            BigInteger cikl = new BigInteger("" + (i));
            BigInteger intRezul2 = intRezul.multiply(cikl);
            return intRezul2;
         }

    }

    public static void main(String[] args) {
        int value = 3;
        System.out.println(factorial(value));
    }




} // не удалять