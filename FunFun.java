import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunFun {

    public static void main(final String[] args) {
        functional();
    }

    static void functional() {
        List<String> names = Arrays.asList("Charles", "Hank", "Scott", "Warren", "Jean", "Taco");

        Predicate<String> selector = name -> name.contains("e");

        List<String> ayes = names.stream().filter(selector).collect(toList());
        System.out.println(ayes);

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
    }
}