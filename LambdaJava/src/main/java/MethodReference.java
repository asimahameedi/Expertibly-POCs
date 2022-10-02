import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

interface Parser
{
	String parse(String str);
}

//class StringParser{
//	public static String convert(String s){
//		if (s.length() <=3){
//			s = s.toUpperCase();
//		}
//			else{
//				s = s.toLowerCase();
//			}
//		
//		return s;
//	}
//}
// if the above method was not a static method (as below) then we will need to create an instance in order to call the method
class StringParser{
	public  String convert(String s){
		if (s.length() <=3){
			s = s.toUpperCase();
		}
			else{
				s = s.toLowerCase();
			}
		
		return s;
	}
}
class MyPrinter
{
	public void print(String str, Parser p){
		str = p.parse(str);
		System.out.println(str);
	}
}
public class MethodReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Parser p = new Parser();

		List<String> names =  Arrays.asList("Lisa", "Adam", "Susan", "Tom");
		//annonymous class
//		Consumer<String> con = new Consumer<String>()
//		{
//			public void accept(String s){
//				System.out.println(s);	
//			}
//			
//		};
		//converted above to lambda expression
//		Consumer<String> con = (s) ->System.out.println(s);	
//		names.forEach(con);
		// more concise 
		//call by METHOD - using method as reference (parameter)
//		names.forEach(System.out::println);
		String name = "Asima Hameedi";
		MyPrinter mp = new MyPrinter();
//		mp.print(name, new Parser(){
//			public String parse(String s){
//				return StringParser.convert(s);
//			}
//		});
		// using class name 'StringParser' 
//		mp.print(name, (String s) ->{
//				return StringParser.convert(s);
//			}
//		);
		// more concise
//		mp.print(name, (s) -> StringParser.convert(s));
		
//		//  even more concise 
//		mp.print(name, (StringParser::convert));
		// if StringParser was not a static class, we would need to create an instance and pass in the object name 
		StringParser sp = new StringParser();
		mp.print(name, (sp::convert)); 
//		
//		new Thread(new Runnable() 
//        { 
//            @Override
//            public void run() 
//            { 
//                System.out.println("New thread created"); 
//            } 
//        }).start(); 
		new Thread(() -> {System.out.println("New thread created");}).start(); 
		
	}

}
