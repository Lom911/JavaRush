package Poliform;

public class Fish implements Swim {
    private String name;
    public Fish (String name){
        this.name = name;
    }


    @Override
    public void Swim() {
        System.out.println("Я рыба " + name + ". Я плыву, двигая плавниками.");
    }
}
