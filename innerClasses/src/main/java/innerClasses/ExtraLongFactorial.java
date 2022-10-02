package innerClasses;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ExtraLongFactorial {
		
	    // Complete the extraLongFactorials function below.
//	    static void extraLongFactorials(int n) {  
////	    	static BigInteger extraLongFactorials(int n) {  
//	    	
////	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:ms");
////	    	LocalDateTime now = LocalDateTime.now();
////	    	System.out.println("before "+ dtf.format(now));
//	   	
//	        BigInteger f = BigInteger.ONE;
//	       
//	        for (int i = 2; i <= n; i++) 
//	            f = f.multiply(BigInteger.valueOf(i)); 
//	  
//	        System.out.println("   ");
//	    	System.out.println(f);
//	        
////	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
////	    	LocalDateTime nowAfter = LocalDateTime.now();
////	    	System.out.println("after "+ dtf.format(nowAfter));
//	    	
////	        return f;
//	    }
//	    
	    static BigInteger extraLongFactorials(int n) {    	
	    	

	    	
	        BigInteger f=BigInteger.ONE;;
	        BigInteger bigN = new BigInteger(String.valueOf(n));
	        if (n<=1){
        		return f;
        	}
	        
	        if (n> 1 && n<=100){
	        	f= bigN.multiply(extraLongFactorials(n-1));
	        }
	        System.out.println(f);
	        return f;

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    	
//	    	int n = 20;
	        extraLongFactorials(n);
//	        System.out.println(extraLongFactorials(n));
//	        scanner.close();
	    }
	}
