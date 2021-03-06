package Kata_4;

public class Ot_Kuda_Metod {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] otKudaMetod = Thread.currentThread().getStackTrace();
        if (otKudaMetod.length <= 3) {
            return null;
        }
        return otKudaMetod[3].getClassName() + "#" + otKudaMetod[3].getMethodName();
    }
}


/*
Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.

Метод getCallerClassAndMethodName() должен возвращать имя класса и метода,
 откуда вызван метод, вызвавший данный утилитный метод. Или null (нулевую ссылку,
 а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является
 точкой входа в программу, т.е. его никто не вызывал.

Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе
надо выводить класс и метод, откуда сообщение было залогировано.

Пример

package org.stepic.java.example;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        // ...
    }
}

При запуске эта программа должна вывести:

null
org.your.project.Test#main

P.S. При тестировании этой программы в среде разработки вы можете получить другой результат:
вместо null в первой строчке будет напечатан какой-то посторонний класс и метод. Это связано с
тем, что среда разработки обычно запускает не ваш класс, а свой собственный, который затем уже
вызывает ваш. Чтобы этого избежать, запускайте программу командой "java" в командной строке.
 */
