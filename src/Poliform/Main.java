package Poliform;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Вася", 25);
        Fish fish = new Fish("Сом");
        UBoat uBoat = new UBoat(50);


        List<Swim> swimList = Arrays.asList(human, fish, uBoat);
        for (Swim s: swimList){
            s.Swim();
        }

    }
}
