import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
// we have commented out this class because now we want to avoid using a separate named class, we will use an anonymous class as lambda fucntion
//class ConsImpl implements Consumer<Integer> {
//
//	@Override
//	public void accept(Integer t) {
//		// TODO Auto-generated method stub
//		System.out.println(t);
//	}
//
//}
public class demoForEach<T> {
	//whenever there's a functional interface, we can use lambda expression
// can't instantiate because Consumer is an interface
	//Consumer<T> c = new Consumer();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> values = Arrays.asList(4,5,6,7,8);
		//parameter of forEach method is object of Consumer
//		values.forEach(i -> System.out.println(i));
//		Consumer<T> is an in-built functional interface introduced in Java 8 in the java. util. function package. 
//		Consumer can be used in all contexts where an object needs to be consumed,i.e. taken as input, and some operation
//		is to be performed on the object without returning any result. Consumers are useful when it not needed to return any 
		//value as they are expected to operate via side-effects.
		// using the class that implements the Consumer interface
//		Consumer<Integer> c = new ConsImpl();
//		values.forEach(c);
//		An inner class declared without a class name is known as an anonymous inner class. 
//		In case of anonymous inner classes, we declare and instantiate them at the same time. 
//		Generally, they are used whenever you need to override the method of a class or an interface. 
//		The syntax of an anonymous inner class is as follows −
		// anonymous inner class - 'Consumer' is actually the interface name
//		Consumer<Integer> c = new Consumer<Integer>(){
//			public void accept(Integer i ){
//				System.out.println(i);	
//			}
//		};
//		values.forEach(c);
		// lambda function
//		Consumer<Integer> c = ( i ) ->{
//				System.out.println(i);	
//			
//		};
//		values.forEach(c);
		//making it even more concise than above
//		Consumer<Integer> c = i -> System.out.println(i);	
//		values.forEach(c);
		// since c is equal to the above lambda expression, we can substitute c with the lambda expression
		
	
		
		values.forEach(i -> System.out.println(i));
	}

}
