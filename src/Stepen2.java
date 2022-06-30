public class Stepen2 {
    public static boolean isPowerOfTwo(int value) {
        return (Integer.bitCount(Math.abs(value)) == 1);
    }

    public static void main(String[] args) {
        int value = -64;
        System.out.println(isPowerOfTwo(value));
    }
}
