import java.util.Arrays;
import java.util.stream.Collectors;

public class task3 {
    public static String extractAndSortNumbers(String[] arr) {
        return Arrays.stream(arr)
                .flatMapToInt(s -> Arrays.stream(s.split(", "))
                        .mapToInt(Integer::parseInt))
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        String[] arr = {"1, 2, 0", "4, 5"};
        String result = extractAndSortNumbers(arr);
        System.out.println(result); // Output: 0, 1, 2, 4, 5
    }
}
