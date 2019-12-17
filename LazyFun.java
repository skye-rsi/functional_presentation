import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LazyFun {

    public static boolean isGreaterThan3(int number) {
        System.out.println("isGreaterThan3 " + number);
        return number > 3;
    }

    public static boolean isEven(int number) {
        System.out.println("isEven " + number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        System.out.println("doubleIt " + number);
        return number * 2;
    }

   public static void main(String[] args) {
       List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        Function<Integer, Predicate<Integer>> isGreaterThan = pivot ->
        number -> number > pivot;

        //.filter(isGreaterThan.apply(3))

          final Stream<Integer> temp = values.stream()
                .filter(isGreaterThan.apply(3))
                .filter(LazyFun::isEven)
                .map(LazyFun::doubleIt);

        System.out.println(temp.findFirst());
   } 











   


       //    final Stream<Integer> temp = values.stream()
    //             .filter(LazyFun::isGreaterThan3)
    //             .filter(LazyFun::isEven)
    //             .map(LazyFun::doubleIt);

        //System.out.println(temp.findFirst());

        // Function<Integer, Predicate<Integer>> isGreaterThan = pivot ->
        // number -> number > pivot;

        //.filter(isGreaterThan.apply(3))

}