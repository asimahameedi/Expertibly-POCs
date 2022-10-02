package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReverseStringWithSpecial {
	
//	1) Create a temporary character array say temp[].
//	2) Copy alphabetic characters from given array to temp[].
//	3) Reverse temp[] using standard string reversal algorithm.
//	4) Now traverse input string and temp in a single loop. Wherever there is alphabetic character is input string, replace it with current character of temp[].
//	Input:   str = "a,b$c"
//	Output:  str = "c,b$a"
//	Input:   str = "Ab,c,de!$"
//	Output:  str = "ed,c,bA!$"
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String input = "a,b$c";
		String input = "Ab,c,de!$";
		
		
		char [] array = input.toCharArray();
		char [] ret = reverse(array);
		String output = String.valueOf(ret);
		System.out.println("input is "+ input);
	    System.out.println("output is "+ output);

	}

	public static char [] reverse(char [] array) {
		List<Character> temp = new ArrayList<Character>();
		
		for (int i =array.length -1; i>=0; i--) {
			if (Character.isLetter(array[i])){
				temp.add(array[i]);			
			}
			
		}
//		temp.forEach(System.out::println);
		
		int i=0;
		Iterator j = temp.iterator();
		while ( i< array.length && j.hasNext()) {
			if (Character.isLetter(array[i])){
				array[i]=(char) j.next();
			}
			i++;
		}
		Arrays.asList(array) .forEach(System.out::println);
		return array;
		
	}

}
