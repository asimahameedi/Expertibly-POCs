package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SortNumbers   {
// sort array in ascending order (no loops)
// remove duplicates using sets (no loops)
// collect frequency of each number using the original array (two nested loops)
// find maximum print and then remove it from the hashmap (two nested loops)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] inputArray={4,3,1,6,4,3,6,4};

		Arrays.sort(inputArray);
			 Set<Integer> set = new HashSet<>(Arrays.asList(inputArray)); 
		
		 Integer[][] result = new Integer[set.size()][2];
	
		// copying set into the array 
		 int j= 0;
		 Iterator<Integer> in = set.iterator(); 
		 while (in.hasNext() && (j<result.length )) {
				 result[j][0]=in.next();
				 j++;
		 }
		 
		 int indarr=0;
		 int freq = 0;
		
		 ConcurrentHashMap<Integer, Integer> hm = new ConcurrentHashMap<Integer, Integer>();
		 
		 //collect frequency 
		 Iterator<Integer> i = set.iterator(); 
	        while (i.hasNext()) {
	            Integer setElement = i.next();
	            while (indarr < inputArray.length){
	            	if (setElement.equals(inputArray[indarr])){
	            		freq++;
	            	}else {
	            		hm.put(setElement, freq);
	            		
	            		freq=0;
	            		break;
	            	}
	            	indarr++;
	            }

	            if (indarr>= inputArray.length){
            	
	            	hm.put(setElement, freq);
            		break;
            		
	            }
	        }

	 
	        // using java 8 removeIf method
	       
//			courseMap.entrySet().removeIf(e - > e.getKey().equals("Java"));
	        
// finding the max and removing the found max from the map
	        int maxKey = 0;
	        int maxValue = 0;

		Iterator hmIterator = hm.entrySet().iterator();
		
		while (hmIterator.hasNext()) {
			hmIterator.next();
//			System.out.println("hmIterator.next() 1  " + hmIterator.next()); 
			maxKey = hm.entrySet().stream().max((entry1, entry2) -> entry1.getValue() >= entry2.getValue() ? 1 : -1).get().getKey();
			maxValue = hm.entrySet().stream().max((entry1, entry2) -> entry1.getValue() >= entry2.getValue() ? 1 : -1).get().getValue();
			for(int index=0; index < maxValue;index++){
            	System.out.print(maxKey);
            }
			hm.remove(maxKey);
		}
		
		
		
		Set<Entry<Integer, Integer>> s = hm.entrySet(); 
		for (Entry<Integer, Integer> it: s) 
        { 
			int key = it.getKey();
			int Val = it.getValue();
            for(int indexLast=0; indexLast<Val;indexLast++){
            	System.out.print(key);
            }
            System.out.println("");
        }
        
//			int indMax = 0;  
//			
//			 for (int a=0; a<result.length;a++ ){
//				 System.out.println("result[a][0] "+result[a][0] );
//				 System.out.println("result[a][1] "+result[a][1] );
//			 }
//			 int max= result[0][1];
//			 
//			 for (int row=0; row<result.length;row++){
//				if (row <result.length-1){
//					if (max <= result[row+1][1]){
//					max = result[row+1][1];
//					indMax = row+1;
//					
//					
//				}
//			 }
//			 }
//			 System.out.println("max "+max );
//			 System.out.println("indMax "+indMax );
//			 for(int m=0; m<max;m++){
//			 System.out.println("result[indMax][0] "+result[indMax][0] );
//			 }
		 
//		 for (int a=0; a<result.length;a++ ){
//			 System.out.println("result[a][0] "+result[a][0] );
////			 System.out.println("result[a][1] "+result[a][1] );
//		 }
//		 //using arrays
//		 int indResult = 0;
//		 int indarr=0;
//		 int freq = 0;
//		   
//		while (indResult < result.length) {
//			while (indarr < inputArray.length) {
//				if (result[indResult][0].equals(inputArray[indarr])) {
//					freq++;
//				} else {
//					result[indResult][1] = freq;
//					freq = 0;
//					break;
//				}
//				indarr++;
//			} // inner while
//			if (indarr >= inputArray.length) {
//				result[indResult][1] = freq;
//			}
//			indResult++;
//		} // outer while
//		
//	//find max 	
//		int indMax = 0;  
//
//		 for (int a=0; a<result.length;a++ ){
//			 System.out.println("result[a][0] "+result[a][0] );
//			 System.out.println("result[a][1] "+result[a][1] );
//		 }
//		 int max= result[0][1];
//		 
//		 for (int row=0; row<result.length;row++){
//			if (row <result.length-1){
//				if (max <= result[row+1][1]){
//				max = result[row+1][1];
//				indMax = row+1;
//				
//				
//			}
//		 }
//		 }
//		 System.out.println("max "+max );
//		 System.out.println("indMax "+indMax );
//		 for(int m=0; m<max;m++){
//		 System.out.println("result[indMax][0] "+result[indMax][0] );
//		 }
//		 int j=0;
//		 int j= result.length-1;
////		 System.out.println("j "+j );
//		 while (i.hasNext() && (j>=0 )) {
//				 result[j][0]=i.next();
//				 
////				 System.out.println("result[j][0] "+result[j][0] );
//				 j--;
//		 }		 
		 

//		Collection<Integer> values = hm.values();
//		Collection<Integer> keys = hm.keySet();
////		//using for loop
//		for(Integer value : values){
//		    System.out.println("value is "+  value );
//		}
//		
//		//using for loop
//				for(Integer key : keys){
//				    System.out.println("keys is "+  keys );
//				}
	
}
}

