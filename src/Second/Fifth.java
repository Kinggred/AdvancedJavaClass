package Second;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Fifth {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "boobery", "blueberry", "cherry", "blackberry");

        // Równoczesne filtrowanie wątków
        Optional<String> firstMatch = words.parallelStream()
                .filter(word -> word.startsWith("b"))
                .findFirst(); // Znajdź pierwsze dopasowanie

        Optional<String> anyMatch = words.parallelStream()
                .filter(word -> word.startsWith("b"))
                .findAny(); // Znajdź dowolne dopasowanie

        System.out.println(words.stream().filter(word -> word.startsWith("b")).toList());
        System.out.println("findFirst(): " + firstMatch.orElse("Brak dopasowania"));
        System.out.println("findAny(): " + anyMatch.orElse("Brak dopasowania"));

        // findAny() nie wybiera określonego elementu ze streamu, nie ma pewności który element zwróci.
    }
}
