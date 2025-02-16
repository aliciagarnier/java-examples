package streams;

// O conceito de streams é introduzido no Java 8
// With Collection interface has two methods to generate a Stream: stream() and
// parallelStream().


// Stream operations are either intermediate or terminal, intermediate operations return a Stream
// so multiple intermediate operations can be chained before the Stream is closed.


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streams {

    public static void main(String[] args) {
        Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");

        fruitStream.filter (s -> s.contains("a")) // filter operation retains only elements that match a given predicate
                .map(s -> s.toUpperCase()) // Using lambda. operation transforms each element using a given function, called a mapper
                .sorted() // sorts the elements of the Stream according to their natural ordering
                .forEach(System.out::println); // Method reference. .forEach performs an action which acts on each element of the stream
        // passing it to a consumer. This is a terminal operation

        System.out.println(Stream.of("apple", "banana", "pear", "kiwi", "orange")
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList())); // Collecting elements from a Stream. It's possible to use Collectors.toSet();




        // Note that operations defined on the stream are performed because of the terminal operation. Without a terminal operation
        // the stream is not processed. Streams cannot be reused. The stream object becomes unusable.


        // A Stream object's processing can be sequential or parallel.
        // In a sequential mode, the elements are processed in the order of the source of the Stream. If the stream, is ordered such as
        // a SortedMap the processing is guaranteed to make the ordering of the source.

        List<Integer> integerList = Arrays.asList(0,1,2,6,54,3, 7);
        int howManyOddNumbers = (int) integerList.parallelStream().filter(i -> (i % 2) != 0).count();
        // integerList.stream().filter.count();
        System.out.println(howManyOddNumbers);

        // Parallel mode allows the use of multiple threads cores but there is no guarantee of the order in which
        // elements are processed. If multiple methods are called on a sequential Stream not every method has to be invoked.




        // The groupingBy collector allows the collection of Stream elements into a Map by classifying each element in a group and
        // performing a downstream operation on the elements classified in the same group.

        Stream.of("apple", "banana", "pear", "kiwi", "orange", "apple", "pear")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // a second collector
                .entrySet()
                .forEach(System.out::println);



    }






}
