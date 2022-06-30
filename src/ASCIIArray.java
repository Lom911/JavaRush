public class ASCIIArray {
    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer);//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello

//проверка на нарушение инкапсуляции private поля
        System.out.println(answer);//Hello!
        example[0] = 74;
        System.out.println(answer);//Hello!
    }

    //    Метод subSequence должен вернуть объект класса AsciiCharSequence.
    public static class AsciiCharSequence implements CharSequence {

        public AsciiCharSequence(byte[] byteName) {
            this.byteName = byteName;
        }

        private final byte[] byteName;

        @Override
        public int length() {
            return toString().length();
        }

        @Override
        public char charAt(int index) {
            return toString().charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(java.util.Arrays.copyOfRange
                    (byteName, start, end));
        }

        @Override
        public String toString() {
            return new String(byteName);
        }
    }
}