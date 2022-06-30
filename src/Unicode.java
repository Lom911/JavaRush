public class Unicode {
    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }
    public static void main(String[] args) {
        int a = 10;
        System.out.println(charExpression(a));
    }
}
