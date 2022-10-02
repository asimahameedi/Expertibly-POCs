package PracticePackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class SortNumbers   {
// 1-	sort array in ascending order (no loops)
// 2-	remove duplicates using sets (no loops)
// 3-	collect frequency of each number using the original array (two nested loops)
// 4-	find maximum, print and then remove it from the hashmap (two nested loops)
// I could have put the sorted array back into the original array
// I could have done step 2&3 in one by peeking back 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortNumbers myClass = new SortNumbers();
		
		System.out.println(myClass.myMethod());
		
		Integer[] inputArray={4,3,1,6,4,3,6,4};

		Arrays.sort(inputArray);
			 Set<Integer> set = new HashSet<>(Arrays.asList(inputArray));
//			 Set set = new HashSet (Arrays.asList(inputArray));
//			 Set<Integer> set = new TreeSet<>(Arrays.asList(inputArray));
			 
			 Iterator <Integer> setIt = set.iterator();
			 while (setIt.hasNext() ) {
				 System.out.println ("setIt.next() "+ setIt.next());
			 }
			 
			 
		
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
        

	
}
//	public Class<? extends SortNumbers> myMethod() {
		public String myMethod() {
		return this.getClass().getName();
//		return this.getClass();
	}
}

