package main;

import java.util.stream.Stream;

public class Stream2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//As you can see, there are numbers less than or equals to five in the latter half of the sequence. 
		//Why? It’s simple: they came after the first element which failed to match the predicate, so the 
		//method stopped dropping at that point.
		Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
        .dropWhile(x -> x <= 5)
        .forEach(System.out::println);
	}

}
