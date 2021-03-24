import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        Stream<String> stream = randomIntsGenerator().stream()
                .map(Object::toString)
                .filter(o -> o.length() % 2 == 0);
       System.out.print(stream.count());
    }

    public static List<Integer> randomIntsGenerator() {
        return new Random()
                .ints(50, 10, 1000000)
                .boxed()
                .collect(Collectors.toList());
    }
}
