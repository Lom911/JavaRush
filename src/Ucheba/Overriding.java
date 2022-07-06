package Ucheba;

public class Overriding {
    public static void main(String[] args) {
        Doctor doc = new Doctor();
        doc.sleep();
        Xirurg xer = new Xirurg();
        xer.age = 35;
        xer.ageage();


    }
}

class Employee {
    String name;
    int age;
    int experience;

    void eat() {
        System.out.println("Eating");
    }

    void sleep() {
        System.out.println("Sleeping");
    }
}

class Doctor extends Employee {
    String specializacia;

    void lichit() {
        System.out.println("Lechit");
    }
}

class Tiacher extends Employee {
    int colichesvoDetey;

    void uchit() {
        System.out.println("Uchit");
    }
}
class Xirurg extends Doctor{
    void ageage (){
        System.out.println(age);
    }
}


