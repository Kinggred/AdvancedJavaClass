package Second;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fourth {
    private static final Random rand = new Random();
    private static final Integer LENGTH = 12;
    public static void main(String[] args) {
        List<List<Integer>> intLists = generateListOfListsWithIntegers(LENGTH);

        double sum = intLists.stream().mapToDouble(integers -> integers.stream().mapToInt(Integer::intValue).sum()).sum();
        System.out.println(sum);
    }

    private static List<List<Integer>> generateListOfListsWithIntegers(int length){
        List<List<Integer>> listOfListsWithIntegers = new ArrayList<>();

        do {
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
               integers.add(rand.nextInt(100));
            }
            listOfListsWithIntegers.add(integers);
            length -= 1;
        } while (length >= 1);

        return listOfListsWithIntegers;
    }
}
