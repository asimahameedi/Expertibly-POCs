package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = 10;
		Integer [] array = {1,2, 3, 4, 5, 6,8};
		
//		Map<Integer,Integer> map =  new HashMap<>(Arrays.asList(array)); 
//		map.putAll(Arrays.asList(array));
		
		 int index= 0;
		
		 int sum =0;
		 boolean found=false;
		 
		
		 
		 for(int i =0; i<array.length; i++)
		 {
			 if (found) {
				 break;
			 }
			 for(int j =i +1; j<array.length; j++) 
			 {
				 sum = array[i] +  array[j];
				 if( sum == result) {
					 found = true;
					 System.out.println(array[i] +" " + array[j]);
					 System.out.println("i "  + i + " j " + j);
					 break;
					 
				 }
			 }
			 
		 }
		 
//		 for(int i =0; i<array.length; i++)
//		 {
//			 
//			 for(int j =i +1; j<array.length; j++) 
//			 {
//				 sum = array[i] +  array[j];
//				 if( sum == result) {
//					 found = true;
//					 System.out.println(array[i] +" " + array[j]);
//					 break;
//					 
//				 }
//			 }
//			 
//		 }

		

	}

}
