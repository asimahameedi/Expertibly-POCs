
public class overloading {
	
public void method1(String arg){
	System.out.println(arg);
}
public void method1(Integer arg){
	System.out.println(arg);
}
//public void method1(overloading arg){
//	System.out.println(arg);
//}
	
	public static void main(String[] args) {
		
		overloading obj = new overloading();
		// though String and Integer are both objects, this will not compile because the object type for obj is overloading not 
		// String or Integer unless there is a method that has the arugment type of overlaoding
		//obj.method1(obj);
		obj.method1("asima");
	
	}
}
