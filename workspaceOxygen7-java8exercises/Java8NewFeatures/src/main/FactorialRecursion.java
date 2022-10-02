package main;

import java.util.Scanner;

public class FactorialRecursion {

	public int fact(int n) {
		if (n <= 1) {
			return 1;
		} else {

			return fact(n - 1) * n;
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the maximum number");

		int i = scanner.nextInt();

		FactorialRecursion pf = new FactorialRecursion();
		int f = pf.fact(i);
		System.out.println("f " + f);

	}

}
