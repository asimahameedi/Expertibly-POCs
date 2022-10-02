package main;

public class BubbleSort {

	
	
	public static void main(String[] args) {
		
//		int[] array = {5, 2, 82, 3, 8, 4, 1, 90};
		int[] array = {90, 82, 8, 5, 4, 5, 2, 1};
		int temp;
		boolean swapped=false;
//		for (int i=0; i< array.length;i++) { commented out to save interations where nothing is swapped, nothing swapped means it's already sorted
		int pass=0;
		do {
			swapped=false;
			for (int j=0; j< array.length;j++) {
				if (j+1 < array.length && array[j] < array[j+1]) {
					temp =  array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					swapped = true;
			 		}
				
				System.out.println("swapped "+ swapped);
			}
			
			pass++;
//			System.out.println("i++ "+ i);
		} while (swapped && pass< array.length );
		
		for (int k=0; k< array.length;k++) {
				System.out.println(array[k]);
		}
		
	}
}
