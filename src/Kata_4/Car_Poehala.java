package Kata_4;

public class Car_Poehala {

    public static class Car implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Машина закрывается...");
        }

        public void drive() {
            System.out.println("Машина поехала.");
        }
    }
    public static void main(String... args) throws Exception {
        try (Car go = new Car()) {
           go.drive();
        } catch (Exception ignored) {
        }
   }
}
/*
В ресурсе создаем объект класса Car(), вызываем метод drive
(его создаем ниже переопределенного метода close(), а в catch, ловим Exception e, и просто игнорируем ее)))

Создайте статический класс Car, чтобы объекты этого типа можно было использовать в try-with-resources.
Метод close() должен выводить на экран фразу "Машина закрывается...".
Try должен ловить все непроверяемые исключения и игнорировать их.
В методе main в блоке try вызови метод drive(). Метод drive должен выводить на экран сообщение "Машина поехала."
Требования:
1. Решение должно содержать статический класс Car.
2. Решение должно содержать метод main.
3. В решение должен использоваться try с ресурсами.
 */