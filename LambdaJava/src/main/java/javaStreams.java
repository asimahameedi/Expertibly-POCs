import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class javaStreams {

	public static void main(String[] args) {
		List<Integer> values = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			values.add(i);
		}
		// this code will not give any output, 'filter' is an intermediary function. Lazy processing 
//		values.stream().filter(i -> {
//			System.out.println("hi");
//			return true;
//		}).findFirst().orElse(1);

		List<Integer> values2 = Arrays.asList(1,2,23,3,4,5,6);
		Stream<Integer> s = values2.stream();
		s.forEach(System.out::println);// will work
		s.forEach(System.out::println); // do this again and it will not work. Streams can only be processed once
	}// main

}
