import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static boolean doubleExpression(double a, double b, double c) {
        double z = a + b;
//        if (c == d)
//        return true;
//        else
//            return false;
        boolean b1 = (Math.abs(c) == Math.abs(z));
        return b1;
    }


    public static void main(String[] args) {
        double a = 8.50;
        double b = 8.55;
        double c = 17.0;
        System.out.println(doubleExpression(a, b, c));
    }
    }


