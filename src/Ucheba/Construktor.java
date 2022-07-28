package Ucheba;

public class Construktor {
    static class BankAccount {
        BankAccount() {


        }

        void popolnenieSheta(double popolnenie) {
            balance += popolnenie;
            System.out.println(balance);

        }


        void snyatie(double snatie) {
            balance -= snatie;
            System.out.println(balance);
        }

        int id = 17;
        double balance = 10000;

    }


    public static void main(String[] args) {
        BankAccount t = new BankAccount();
        t.snyatie(0);
        t.popolnenieSheta(14.45);
        System.out.println(t.balance);

        int i;
        byte x = 64;
        byte y;
        i = x << 2;
        y = (byte)(x << 2);
        System.out.println(i + " " + y);

    }


}

