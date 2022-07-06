package KATA_23;

public class Polindrom {
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//        text = text.toLowerCase();
        String text2 = new StringBuilder(text).reverse().toString();
        return (text.equals(text2));
    }

    public static void main(String[] args) {
        String text = "Ws it a cat I saw?";
        System.out.println(isPalindrome(text));
    }

}
