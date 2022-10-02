package main;

public class FactorialLoop {
	
	
	public static int fact(int n) {
		int f = 1;
		for (int i =n; i>0;i--) {
			if (n==1 || n==0) {
				System.out.println("i "+ i);
				return f;
			}else {
				System.out.println("i "+ i);	
				f = f * i;
				System.out.println("f "+ f);
			}
		}
		
		return f;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fact(5);
		
		
	}

}
