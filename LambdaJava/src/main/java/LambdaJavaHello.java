
// lambda functions help remove a lot of boiler plate code
interface A
{

//		public static void show()
//		{
//		System.out.println("Hello from Java xyz");
//		}
//		public default void show()
//		{
//		System.out.println("Hello from Java xyz");
//		}
//	public  void show();
	public  void show(int i);
	 
}
//class xyz implements A
//{
//	//this is ok if the interface method is static and therefore has implementation
////	public static void show()
////	{
////	System.out.println("Hello from Java xyz");
////	}
//	
//	public  void show()
//	{
//	System.out.println("Hello from Java xyz");
//	}
//	
//	public  void show(int i)
//	{
//	System.out.println("print i: " + i);
//	}
//	
//
//	
//}
//public class LambdaJavaHello implements A{ // this will work because static main can only access other static methods and variables and Static methods inside interface require implementation
public class LambdaJavaHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj;
		A obj2;
//		obj = new A();// can not do this because A is an interface if not implementing
//		A.show();
//		A.show();// can call static method the implemented interface like this. 
		// lambda way of doing things
		// whenever there's a method inside a block of code, it's an anonymous inner class. In this case named LambdaJavaHello$1.class
//		obj = new A(){
//			public  void show()
//			{
//			System.out.println("Hello from Java lambda function");
//			}
//		};
//		obj.show();
		
		// we have defined the return type, parameters and method name inside the interface, we don't need to redefine these
		// we can remove the below code from the above code
		//// new A(){
		////		public  void show
		// also remove the outer curly braces
		// '()' is the braces of the function show()
//		obj = () ->
//		{
//		System.out.println("Hello from Java lambda function");
//		};
//	obj.show();
		// because we only have one line, we can remove the curly braces and it will become one line of code. And now this code NOT generate an inner class. This is a way of implementing an interface
//		obj = () ->System.out.println("Hello from Java lambda function");
//		obj2 = (int i) ->System.out.println("Hello from Java lambda function"+ i);
		// i is already defined int inside the function declaration of the interface, therefore, we don't have to specify the type
//		obj2 = (j) ->System.out.println("Hello from Java lambda function: "+ j);
		// if the method only has one parameter, we can remove the parentheses
		// below is the implementation of the interface A. And this is called a consumer interface
		obj2 = j ->System.out.println("Hello from Java lambda function: "+ j);
//	obj.show();
	obj2.show(6);
		
		
	}

	}




