import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class task1 {
    public static String filterOddIndexedNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(names::get)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Peter", "John", "Alice", "Bob");
        String result = filterOddIndexedNames(names);
        System.out.println(result); // Output: Ivan, John, Bob
    }
}
