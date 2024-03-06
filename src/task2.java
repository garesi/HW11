import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class task2 {
    public static List<String> uppercaseSorted(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Peter", "John", "Alice", "Bob");
        List<String> result = uppercaseSorted(names);
        System.out.println(result); // Output: [PETER, JOHN, IVAN, BOB, ALICE]
    }
}
