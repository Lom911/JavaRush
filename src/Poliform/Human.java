package Poliform;

public class Human implements Swim {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Я " + name + ", мне " + age + " лет. ";
    }

    @Override
    public void Swim() {
        System.out.println(toString()+" Я плаваю с помощью надувного круга.");
    }
}
