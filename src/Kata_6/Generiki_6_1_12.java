
package Kata_6;

import java.util.Objects;

public class Generiki_6_1_12 {
    public static class Pair<T, Y> {
        private T first;
        private Y second;

        public Y getSecond() {
            return second;
        }

        public T getFirst() {
            return first;
        }

        private Pair(T first, Y second) {
            this.first = first;
            this.second = second;
        }

        public static <T, Y> Pair<T, Y> of(T first, Y second) {
            return new Pair<>(first, second);

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }


    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
    }
}







