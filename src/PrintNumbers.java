public class PrintNumbers {
    public static void main(String[] args) {
        int[] ints = {3,5,20,8,7,3,100};
        printOddNumbers(ints);
    }
    public static void printOddNumbers(int[] arr) {
        StringBuilder stroka = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                stroka.append(",").append(arr[i]);
            }
        }
        if (stroka.length() == 0) {
            System.out.println();
        } else {
            stroka.deleteCharAt(0);
            System.out.print(stroka + "\n");
        }
    }
}
