package Second;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sixth {
    private static final Random rand = new Random();
    private static final Integer LENGTH = 125512;

    public static void main(String[] args) {
        // Parallel stream has to allocate required resources which can be more costly than gains provided, especially on small collections
        List<List<Integer>> integersList = generateListOfListsWithIntegers(12512);
        Long startStream = System.nanoTime();
        Long bigInt = integersList.stream().mapToLong(integers -> integers.stream().mapToInt(Integer::intValue).sum()).sum();
        Long endStream = System.nanoTime();
        Long streamExTime = (endStream - startStream) / 1000000;
        System.out.println(streamExTime);

        Long startParStream = System.nanoTime();
        Long bigParInt = integersList.parallelStream().mapToLong(integers -> integers.stream().mapToInt(Integer::intValue).sum()).sum();
        Long endParStream = System.nanoTime();
        Long parStreamExTime = (endParStream - startParStream) / 1000000;
        System.out.println(parStreamExTime);
    }

    private static List<List<Integer>> generateListOfListsWithIntegers(int length){
        List<List<Integer>> listOfListsWithIntegers = new ArrayList<>();

        do {
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < 10110; i++) {
                integers.add(rand.nextInt(10000));
            }
            listOfListsWithIntegers.add(integers);
            length -= 1;
        } while (length >= 1);

        return listOfListsWithIntegers;
    }
}
