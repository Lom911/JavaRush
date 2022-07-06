package Ucheba;

public class MethodOverload {
    void show (int i){
        System.out.println(i);
    }

    void show (boolean b1){
        System.out.println(b1);
    }

    void show (String s){
        System.out.println(s);
    }
}


class Osnovnoi {
    public static void main(String[] args) {
        MethodOverload t0 = new MethodOverload();
        int a = 300;
        t0.show(a);
        t0.show(true);
        t0.show("Privet");
    }
}
