import java.util.stream.Stream;

public class task4 {
    public static Stream<Long> linearCongruentialGenerator(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        long seed = 42;
        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);

        linearCongruentialGenerator(seed, a, c, m)
                .limit(10)
                .forEach(System.out::println); // Output: First 10 random numbers
    }
}
