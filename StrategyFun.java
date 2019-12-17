import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyFun {

    public static int totalValues(List<Integer> values) {
        int result = 0;

        for(int e : values) {
            result += e;
        }
        return result;
    }

    public static int totalEvenValues(List<Integer> values) {
        int result = 0;

        for(int e : values) {
            if (e % 2 == 0) {
                result += e;
            }
        }
        return result;
    }

    public static int totalOddValues(List<Integer> values) {
        int result = 0;

        for(int e : values) {
            if (e % 2 != 0) {
                result += e;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // System.out.println(totalValues(numbers));
        // System.out.println(totalEvenValues(numbers));
        // System.out.println(totalOddValues(numbers));

        System.out.println(higherOrderTotalValues(numbers, e -> true));
        System.out.println(higherOrderTotalValues(numbers, Util::isEven));
        System.out.println(higherOrderTotalValues(numbers, Util::isOdd));
    }




    public static int higherOrderTotalValues(List<Integer> values, Predicate<Integer> selector) {
        int result = 0;






        return values.stream()
                     .filter(selector)
                     .reduce(0, Integer::sum);
    }
}

    // lightweight strategy pattern function library, no interface, no implementations.
class Util {
    public static boolean isEven(int number) {
        return number % 2 ==0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}