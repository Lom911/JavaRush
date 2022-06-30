import java.util.Arrays;

public class SliynieArrays {
    public static void main(String[] args) {

        int[] ints = {0, 2, 2, 7, 12, 34};
        int[] ints2 = {1, 3, 8 ,9 , 22};
        mergeArrays(ints, ints2);

    }
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int [] a3 = new int[a1.length + a2.length];
        int counterA1 = 0;
        int counterA2 = 0;
        int counterA3 = 0;
        while ((counterA1 < a1.length) && (counterA2 < a2.length)) {
            if (a1[counterA1] < a2[counterA2]) {
                a3[counterA3++] = a1[counterA1++];
//                counterA3++;
//                counterA1++;
            } else {
                a3[counterA3++] = a2[counterA2++];
//                counterA3++;
//                counterA2++;
            }
        }
        while (counterA1 < a1.length) {
            a3[counterA3++] = a1[counterA1++];
//            counterA3++;
//            counterA1++;
        }
        while (counterA2 < a2.length) {
            a3[counterA3++] = a2[counterA2++];
//            counterA3++;
//            counterA2++;
        }
        System.out.println(Arrays.toString(a3));
        return a3;
    }
}
