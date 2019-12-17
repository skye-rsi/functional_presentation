import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorFun {

    public static void doWork(int value, Function<Integer, Integer> func) {
        System.out.println(func.apply(value));
    }

    public static void main(String[] args) {

        printSnap(new Camera());
        printSnap(new Camera(Color::brighter));
        printSnap(new Camera(Color::darker));
        printSnap(new Camera(Color::brighter, Color::darker));
    }

    public static void printSnap(Camera camera) {
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }
}

class Camera {

    private Function<Color, Color> filter;

    public Color snap(Color input) {
        return filter.apply(input);
    }

    public Camera(Function<Color, Color>... filters) {
        setFilters(filters);
    }

    public void setFilters(Function<Color, Color>... filters) {
        filter = Stream.of(filters)
                .reduce(Function.identity(), 
                Function::andThen);
    }




}