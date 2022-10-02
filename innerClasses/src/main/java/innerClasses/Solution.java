package innerClasses;

import java.io.*;
import java.util.Arrays;


public class Solution {

    // Complete the reverseArray function below.
	static int[] reverseArray(int[] a) {
   // static void reverseArray(int[] a) {
int result[] = new int[a.length];
int size = a.length;

int j=0;
for ( int i=size-1;i>=0; i--)
{
    result[j++]= a[i];
    System.out.print(a[i] +" ");
    System.out.println("");
}
return result;
    }

    

    public static void main(String[] args) throws IOException {
        
    	//Solution sol = new Solution();
    	int[] a = {1,2,3,4,5};
    	
    	//Solution.reverseArray(a);
    	System.out.println("array: "+ Arrays.toString(Solution.reverseArray(a)));

        
    }
}
