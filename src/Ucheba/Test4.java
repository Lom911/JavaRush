package Ucheba;

public class Test4 {
    public static void main(String[] args) {
        Human2 hhh = new Human2("Sergey", "Robokin");

    }
}

    class Human2 {
        Human2(String name, String sername) {
            this.name = name;
            this.sername = sername;
            System.out.printf("%s %s", name, sername);

        }

        String name = "Uvan";
        String sername = "Guguchkin";
    }

