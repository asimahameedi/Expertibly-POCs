package innerClasses;



	import java.io.*;
	
	import java.util.*;
	

	public class CompareTriplets {

	    // Complete the compareTriplets function below.
	    static List<Integer> compareTrip(List<Integer> a, List<Integer> b) {
	    	
	    	List<Integer> points = new ArrayList<Integer>(2);
	    		
	    	int alice=0, bob=0;
	    	
	    	for (int i = 0; i < a.size() && i < b.size(); i++) {

	    		if (a.get(i) > b.get(i)){

	    			alice = alice+1;    
	    			
	    		}
	    		else if (a.get(i) < b.get(i)){

	    			bob= bob+1;
	    			
	    		}

			}
	    	
	    	points.add(Integer.valueOf(alice));
    		points.add(Integer.valueOf(bob));
    		System.out.print(points.get(0));
    		System.out.print(" ");
			System.out.println(points.get(1));
   		
	    	return points;
	    }

	    public static void main(String[] args) throws IOException {
	        
	        List<Integer> a = new ArrayList(4);

	        List<Integer> b = new ArrayList(4);
	        
	        a.add(17);
	        a.add(28);
	        a.add(30);
	        
	        b.add(99);
	        b.add(16);
	        b.add(8);
	        
	        List<Integer> result = compareTrip(a, b);

	        

	        
	    }
	}
