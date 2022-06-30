
public class Solution {
    public static void main(String[] args) {
       int[] arr = {3,5,20,8,0,3,10};
       printOddNumbers(arr);
    }
    public static void printOddNumbers(int[] arr) {
        StringBuilder stroka = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
               stroka.append("," + arr[i]);
            }
        }
        if (stroka.length() == 0) {
            System.out.println();
        }
        else {
            stroka.deleteCharAt(0);
            System.out.print(stroka + "\n");
        }
    }
} // не удалять