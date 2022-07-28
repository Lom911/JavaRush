package Kata_5;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ByteToAnimal_5_4_7 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]
                {new Animal("cat"),
                        new Animal("dog"),
                        new Animal("duck"),
                        new Animal("horse")};

        System.out.println(Arrays.toString(animals));
        byte[] serializedAnimals = serializeAnimalArray(animals);
        Animal[] deserializedAnimals = deserializeAnimalArray(serializedAnimals);
        System.out.println(Arrays.toString(deserializedAnimals));
        System.out.printf("arrays are equals: %s", Arrays.equals(animals, deserializedAnimals));

    }

    public static byte[] serializeAnimalArray(Animal[] animals) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(outputStream)) {
            oos.writeInt(animals.length);
            for (Animal animal : animals) {
                oos.writeObject(animal);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return outputStream.toByteArray();
    }


    public static Animal[] deserializeAnimalArray(byte[] data) {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            int x = ois.readInt();
            Animal[] animal = new Animal[x];
            for (int i = 0; i < animal.length; i++) {
                animal[i] = (Animal) ois.readObject();
            }
            return animal;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        } catch (NegativeArraySizeException e){
            throw new IllegalArgumentException(e);
//        } catch (ArrayIndexOutOfBoundsException e){
//            throw new IllegalArgumentException(e);
        }
    }

    static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }
}











