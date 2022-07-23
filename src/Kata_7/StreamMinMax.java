package Kata_7;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class StreamMinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

    }
}






//      stream.collect(Collectors.teeing(Collectors.minBy(order), Collectors.maxBy(order), (min, max) -> {
//              minMaxConsumer.accept(min.orElse(null), max.orElse(null));
//              return null;
//              }));