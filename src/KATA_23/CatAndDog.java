package KATA_23;

public class CatAndDog {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat Cat = new Cat();
        dog.catchCat(Cat);
            }


    public static class Cat {
        public void sayHello() {
            System.out.println("Мяу!");
        }
    }

    public static class Dog {
        public void sayHello() {
            System.out.println("Гав!");
        }

        public void catchCat(Cat Cat) {
            System.out.println("Кошка поймана");
            sayHello();
            Cat.sayHello();
        }
    }
}

