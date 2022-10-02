package main;

import java.util.Scanner;

public class FibsRecursion {


	public int fib(int n) {
		if (n <= 1) {
			return 1;
		} else {

			return fib(n - 1) + fib(n - 2);
		}
		
	}
	
	public static void main(String[] args) 
	{
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the maximum number");
	
	int i = scanner.nextInt();
	
	FibsRecursion pn= new FibsRecursion();
	 int f= pn.fib(i);
	 System.out.println("f " + f);
		
	}
	
	
	}
