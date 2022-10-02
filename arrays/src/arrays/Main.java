package arrays;

public class Main {
public static void main(String[] args){
		int arr[]=new int[]{0,1,2,3,4,5,6,7,8,9};
		int n=6;
		System.out.println("before arr[0]   "+arr[0]);
		System.out.println("before arr[1]   "+arr[1]);
		System.out.println("before arr[2]   "+arr[2]);
		System.out.println("before arr[3]   "+arr[3]);
		System.out.println("before arr[4]   "+arr[4]);
		System.out.println("before arr[5]   "+arr[5]);
		System.out.println("before arr[6]   "+arr[6]);
		
		
		System.out.println("before arr[n]   "+arr[n]);
		System.out.println("before arr[n]/2   "+arr[n]/2);
		n=arr[arr[n]/2];
		System.out.println(arr[n]/2);
}
}
