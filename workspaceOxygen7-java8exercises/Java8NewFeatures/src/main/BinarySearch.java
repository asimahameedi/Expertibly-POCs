package main;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer searchFor=8;
		Integer [] array= {2, 4, 6, 7, 8, 10, 12};
		
		boolean found =searchRecursive(0, array.length -1, array, searchFor);
		System.out.println("found "+ found);
		
		boolean found2 =searchIterative(0, array.length -1, array, searchFor);
		System.out.println("found2 "+ found2);
	}

	private static boolean searchRecursive(int low, int high, Integer []array, Integer searchFor) {
	
		// TODO Auto-generated method stub
		
	
		boolean isThere=false;
		
		int mid = (low+high)/2;
		
		if (searchFor == array[mid]) {
			isThere=true;
			System.out.println("index where found "+ mid);
			return isThere;
		}
		
		//check this later
		if (mid == array.length -1) {
			
			isThere=false;
			return isThere;
		}
		
		
		
		if (searchFor > array[mid]) {
			low = mid + 1;
			 return searchRecursive(low, high, array, searchFor);}
		
		if (searchFor < array[mid]) {
			high = mid -1;
			return searchRecursive(low, high, array, searchFor);}
		
		
		
		
																																						
		return isThere;
	}
	
	private static boolean searchIterative(int low, int high, Integer []array, Integer searchFor) {
		
		// TODO Auto-generated method stub
		
		boolean isThere=false;
		
		while (low <= high) {
		
			int mid = (low+high)/2;
		
			if (searchFor == array[mid]) {
				System.out.println("index where found "+ mid);
				isThere=true;
				break;
			}
			
			if (mid == array.length -1) {		
				isThere=false;
				break;
			}
			
			if (searchFor > array[mid]) {
				low = mid + 1;
			}
			
			if (searchFor < array[mid]) {
				high = mid - 1;
			}
			
		}
	
																																						
		return isThere;

}
}
