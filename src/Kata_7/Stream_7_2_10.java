package Kata_7;

import java.util.stream.IntStream;

public class Stream_7_2_10 {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);

    }

}
