import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        Iterator<T> zippedIterator = new Iterator<T>() {
            boolean hasNextFirst = iterator1.hasNext();
            boolean hasNextSecond = iterator2.hasNext();

            @Override
            public boolean hasNext() {
                return hasNextFirst || hasNextSecond;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (hasNextFirst) {
                    hasNextFirst = iterator1.hasNext();
                    return hasNextFirst ? iterator1.next() : null;
                } else {
                    hasNextSecond = iterator2.hasNext();
                    return hasNextSecond ? iterator2.next() : null;
                }
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false).filter(Objects::nonNull);
    }

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6, 7);

        zip(stream1, stream2).forEach(System.out::println);
        // Output: 1 4 2 5 3 6
    }
}
