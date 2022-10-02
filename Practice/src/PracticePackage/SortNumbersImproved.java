package PracticePackage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SortNumbersImproved {

	// 1- sort array in ascending order (no loops)
	// 2- remove duplicates using sets (no loops). I could have written the digits at the same time as writing frequencies
	// 3- adding up frequencies of each number and writing to the result 2d array (2 loops)
	// 4- sorting the result array based on frequency (2 nested loops)
	// 5- printing the numbers in descending order (2 loops)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] inputArray = { 4, 3, 1, 6, 4, 3, 6, 4 };
		
		//sorting in ascending order
		Arrays.sort(inputArray);
		// inputArray now has inputArray={1,3,3,4,4,4,6,6};
		Set<Integer> set = new HashSet<>(Arrays.asList(inputArray));
//		Set<Integer> set = new TreeSet<>(Arrays.asList(inputArray));
		int[][] result = new int[set.size()][2];

		
		
		// copying set into the array
		int j = 0;
		Iterator<Integer> in = set.iterator();
		while (in.hasNext() && (j < result.length)) {
			result[j][0] = in.next();
			j++;
		}
// adding up frequencies of each number and writing to the result 2d array
		result[0][1] = 1;
		int resultIndex = 0;

		while (resultIndex < result.length) {
			for (int inputIndex = 1; inputIndex < inputArray.length; inputIndex++) {

				if (inputArray[inputIndex] == inputArray[inputIndex - 1]) {
					result[resultIndex][1] = result[resultIndex][1] + 1;
				} else {

					if (resultIndex < result.length - 1) {
						resultIndex++;
						result[resultIndex][1] = 1;
					}
				}
			}
			resultIndex++;
		}
		
//		
		
		
// sorting the result array based on frequencies (2 loops)-finding maximum
int[][] temp = new int[1][2];

for (int row = 0; row < result.length; row++) {

	for (int next = row; next < result.length; next++) {

		if (result[next][1] > result[row][1]) {
			temp[0][0] = result[row][0];
			temp[0][1] = result[row][1];

			result[row][0] = result[next][0];
			result[row][1] = result[next][1];

			result[next][0] = temp[0][0];
			result[next][1] = temp[0][1];
		}

	}
}
//printing the numbers in descending order (2 loops)
int freq = 0;
for (int row = 0; row < result.length; row++) {
	freq = result[row][1];
	for (int f = 0; f < freq; f++) {
		System.out.print(result[row][0]);
		System.out.print(" ");
	}
	
}
//print out the array
		for (int row = 0; row < result.length; row++) {
			System.out.println("");
			System.out.print(result[row][0]);
			System.out.print(" ");
			System.out.print(result[row][1]);
			if (row + 1 < result.length) {
				System.out.print(", ");
				System.out.println("");
			}
		}

	}
}
