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
        private T[] element = (T[]) new Object[10];
        private int size;

        public void add(T el) {
            if (size == element.length) {
                T[] oldElement = element;
                this.element = (T[]) new Object[oldElement.length + oldElement.length / 2];
                System.arraycopy(oldElement, 0, this.element, 0, size);
            }
            this.element[size++] = el;
        }

        public void remove(int index) {
            System.arraycopy(element, index + 1, element, index, size - index - 1);
                size--;
        }

        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return element[index];
        }
    }
}
