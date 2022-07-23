package Kata_7;

import java.util.function.Function;
import java.util.function.Predicate;


public class Func_Interf {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return (T t) -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

    }

} //end









/*
//реализация функциональных интерфейсов такая

@FunctionalInterface
public interface Predicate<T>{//IntP, LongP, DoubleP, BiPredicate
    boolean test(T t);
}

@FunctionalInterface
public interface Function<T, R>{//BiFunction, DoubleF: double->T, LongToIntF:long->int, ToIntF:T->Int
    R apply(T t);
}

//создавая объект этих типов реализуют эти методы только так можно использовать интерфейсы

Predicate<Object> condition = Objects::isNull;
Function<Object, Integer> ifTrue = obj -> 0;
Function<CharSequence, Integer> ifFalse = CharSequence::length;
Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

//например

condition.test(x)// это и есть

boolean test(String x){
   return Objects.isNull(x);
}

ifTrue.apply(x)// это и есть

Integer apply(String x){
       return 0;
}

ifTrue.apply(x)// это и есть
String y = "Elephant";

apply((CharSequence)y);

Integer apply(CharSequence x){

      return x.leng;

}

return t ->condition.test(x) ? ifTrue.apply(x): ifFalse.apply(x);
 */