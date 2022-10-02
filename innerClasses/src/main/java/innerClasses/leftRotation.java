package innerClasses;


	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.regex.*;

	public class leftRotation {

//public int[] spinLeft(){
//	int result [] = new int[] 
//	return ;
//}

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        String[] nd = scanner.nextLine().split(" ");

	        int n = Integer.parseInt(nd[0]);

	        int d = Integer.parseInt(nd[1]);

	        
//	        System.out.println("n: "+ n);
//	        System.out.println("d: "+ d);
	        int[] a = new int[n];

	        String[] aItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        System.out.println("aitems: "+ aItems);
	        for (int i = 0; i < n; i++) {
	            int aItem = Integer.parseInt(aItems[i]);
	            a[i] = aItem;
	         //   System.out.println(aItem);
	            //-----
	            
	           
//	            
	           
	            //------
	            
	           
	        }
	        
	        
	        
	        scanner.close();
	        
//	        System.out.println("n : "+ n);
//            for (int ind=0;ind<n; ind++){
//            	System.out.println("a[i]: "+ a[ind]);
//            }
            
	        
            int temp;
            for (int times=0; times<d; times++)
            {
            	temp = a[0];
            	
            	for (int j=0; j<n-1; j++)
            	{
            	a[j]= a[j+1];
            	}
            	a[n-1]	= temp;
            }
            
	        System.out.println("n : "+ n);
          for (int ind=0;ind<n; ind++){
          	System.out.println("a[i]: "+ a[ind]);
          }
            
	    }
	}
