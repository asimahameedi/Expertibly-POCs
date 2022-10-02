package main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class stream {
	public static void main(String args[]) {
		List<Integer> values = Arrays.asList(12, 20, 35, 46, 55, 68, 75);
//		List<Integer> values = Arrays.asList(6,88,99);
		
//		System.out.println(values.stream()
//								.filter(i-> i%5==0)
//								.reduce(0, (c,e)-> c+e));
//		
//		Predicate<Integer> p = new Predicate<Integer>()
//		{
//			public boolean test(Integer i) {
//				return i%5==0;
//			}
//			
//			
//		};
//		System.out.println(values.stream()
//								.filter(p));
		
		
//		System.out.println(values.stream()
//								.map(i-> i*2)
//								.filter( i->  i%5==0)
//								.reduce(0, (c,e)-> c+e));
//		
//		System.out.println(values.stream()
//				.map(i-> i*2)
//				.filter( i->  i%5==0)
//				.reduce(0, (c,e)-> c+e));
		
//		System.out.println(values.stream()
//				.filter( i->  i%5==0)
//				.map(i-> i*2)
//				.findFirst());
		
//		System.out.println(values.stream()
//				.map(i -> i*2)
//				.filter( i ->  i%5==0)
//				.findFirst()
//				.orElse(0));
//		
		System.out.println(values.stream()
				.filter(stream::isDivisible)
				.map(stream::mapDouble)
				.findFirst()
				.orElse(0));
	}
	//lazy method evaluation proof. Filter & map are more efficient that the For loop ( prcoesses all values)
	public static boolean isDivisible(int i) {
		System.out.println("is in isDivisible " + i);
		return  i%5==0;
		
	}
	
public static int mapDouble(int i) {
	System.out.println("is in mapDouble " + i);
		return  i*2;
		
	}
	
}
