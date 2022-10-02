package innerClasses;


import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
	

	public class bigSum {

	    
		// Complete the aVeryBigSum function below.
	    static long aVeryBigSum(long[] ar) {
	    	
	    	
	    	
	    	long bigSum= 0;
	    	
	    	for (int i=0; i < ar.length; i++){
	    		
	    		bigSum = bigSum+ ar[i];
	    		
	    	}
//	    	System.out.println("bigSum: " + bigSum);
	    	
	    	
return bigSum;

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        
	        int arCount = 5;
	        

	        long[] ar = new long[arCount];
	        
	        
//	        5
//	        1000000001 1000000002 1000000003 1000000004 1000000005
	        ar[0]= 1000000001;
	        ar[1]= 1000000002;
	        ar[2]= 1000000003;
	        ar[3]= 1000000004;
	        ar[4]= 1000000005;
	        

	        long result = aVeryBigSum(ar);

	        System.out.println("result: " + result);
	    }
	}
