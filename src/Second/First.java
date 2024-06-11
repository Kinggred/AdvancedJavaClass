package Second;

import java.util.ArrayList;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(3);
        lista.add(6);
        lista.add(1);

        List<Integer> copy = new ArrayList<>();

        lista.forEach( m -> copy.add(m+2));
        System.out.println(lista);
        System.out.println(copy);
    }
}
