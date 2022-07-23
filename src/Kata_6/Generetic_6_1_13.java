package Kata_6;

/*
Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение.
Создайте класс DynamicArray, который хранит в себе массив, и имеет методы для добавления void add(T el),
 void remove(int index) удаления и извлечения T get(int index) из него элементов,
 при переполнении текущего массива, должен создаваться новый, большего размера.

Для возможности работы с различными классами DynamicArray должен быть дженериком.
 */
public class Generetic_6_1_13 {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        array.remove(7);
        array.remove(7);
        array.remove(7);
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        for (int i = 0; i < array.size; i++) {
            System.out.print(array.get(i) + " ");
        }

    }

    public static class DynamicArray<T> {
        private static final int DEF_SIZE = 10;
        private T[] element;
        private int size;
        private int index;

        public DynamicArray() {
            this.element = (T[]) new Object[DEF_SIZE];
            this.size = 0;
        }

        public void add(T el) {
            if (size == element.length) {
                T[] oldElement = element;
                this.element = (T[]) new Object[oldElement.length + oldElement.length / 2];
                for (int i = 0; i < size; i++) {
                    this.element[i] = oldElement[i];

                }
            }
            this.element[size] = el;
            size++;
        }

        public void remove(int index) {
            this.index = index;

            if (index < 0 || index >= element.length) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                for (int i = index; i < element.length - 1; i++) {
                    element[i] = element[i + 1];
                    element[i + 1] = null;

                }
                size--;

            }

        }

        public T get(int index) {
            this.index = index;
            if (index < 0 || index >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return element[index];
        }


//        public int size() {
//            return element.length;
//        }
    }


}
