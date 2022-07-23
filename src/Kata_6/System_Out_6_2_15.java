package Kata_6;

import java.util.ArrayDeque;
import java.util.Scanner;

public class System_Out_6_2_15 {
    public static void main(String[] args) {
        int counter = 1;
        Scanner scanner = new Scanner(System.in);
//        Deque numbers = new LinkedList();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        while (scanner.hasNext()) {
            if (counter % 2 == 0) {
                numbers.addFirst(scanner.nextInt());
            } else {
                scanner.next();
            }
            counter++;
        }
        scanner.close();
        for (Integer p : numbers) {

            System.out.print (p + " ");
        }
    }
}

