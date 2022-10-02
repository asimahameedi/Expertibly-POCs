package innerClasses;


	import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;



	public class leaderBoard {

	    // Complete the climbingLeaderboard function below.
	    static int[] climbingLeaderboard(int[] scores, int[] alice) {
	    	
	    	int scoresSize = scores.length;
	    	// remove dup
	    	TreeSet<Integer> scoresSet = new TreeSet<Integer>( Collections.reverseOrder() ) ;
	    	for (int i = 0; i< scoresSize; i++){
	    		scoresSet.add(scores[i]);
	    	}
//	    	System.out.println(scoresSet);
	        	
	    	int aliceSize = alice.length;
    	

	    	Iterator<Integer> scoresSetIr = scoresSet.iterator(); 
	    		    	
	    	
	    	int scoresArray []=new int[scoresSet.size()];
	    		
	    	// put set elements into an array
	    	int  scoresInd =0;

	    	
	    	while (scoresSetIr.hasNext()){
	    		scoresArray[scoresInd++] =  scoresSetIr.next();
	    	}
	    	

	    	// put set elements into an array end 
	    	
	    	// figure out scores using the array
	    	
    		int scoresArraySize = scoresArray.length;
    		    	
	    	int result []=new int [alice.length];	
	    	int aliceIdx = 0;
	    	int resultIdx = 0;

	    	while(aliceIdx < aliceSize){

	    		for (int scoresIdx=0; scoresIdx < scoresArraySize; scoresIdx++ ){
	    			
	    			if (alice[aliceIdx] < scoresArray[scoresIdx]){ 
	    				if (scoresIdx+1 == scoresArraySize  ){
//	    					System.out.println("scoresIdx here "+ scoresIdx );
	    					result[resultIdx]=scoresArraySize +1;
//	    					System.out.println("result[resultIdx] "+ result[resultIdx] );
	    					resultIdx++;
	    					aliceIdx++;
	    					break;

	    				}else {
	    					continue;
	    					
	    				}	    				
	    			}else if (alice[aliceIdx] > scoresArray[scoresIdx]){
//	    				System.out.println("scoresIdx here "+ scoresIdx );  				
	    				result[resultIdx]=scoresIdx +1;
//	    			    System.out.println("result[resultIdx] "+ result[resultIdx] );
	    				resultIdx++;
	    				aliceIdx++;
	    				break;
	    			}else if (alice[aliceIdx] == scoresArray[scoresIdx]){
	    				result[resultIdx]=scoresIdx + 1;
//	    				System.out.println("result[resultIdx] "+ result[resultIdx] );
	    				resultIdx++;
	    				aliceIdx++;
	    				break;
	    			}
	    		}

	    		
	    	}
	    	
	    	
//    		for (int element : result){
//    		    System.out.println("result "+ element);
//    		}

	    	
	    	
	    	
	    	
	    		
return result;
	    }

	    
	    public static void main(String[] args) throws IOException {
	       
//	        int scoresCount = 7;
//	        int scoresCount = 6;
	        int scoresCount = 1;

	        int[] scores = new int[scoresCount];

//	        scores[0] = 100;
//	        scores[1] = 100;
//	        scores[2] = 50;
//	        scores[3] = 40;
//	        scores[4] = 40;
//	        scores[5] = 20;
//	        scores[6] = 10;
	        
//	        scores[0] = 100;
//	        scores[1] = 90;
//	        scores[2] = 90;
//	        scores[3] = 80;
//	        scores[4] = 75;
//	        scores[5] = 60;
	        
	        scores[0] = 1;
	        
	        
	        
	        
//	        int aliceCount = 4;
//	        int aliceCount = 5;
	        int aliceCount = 2;

	        int[] alice = new int[aliceCount];
//	        alice[0] = 5;
//	        alice[1] = 25;
//	        alice[2] = 50;
//	        alice[3] = 120;
	        
//	        alice[0] = 50;
//	        alice[1] = 65;
//	        alice[2] = 77;
//	        alice[3] = 90;
//	        alice[4] = 102;
	        
	        alice[0] = 1;
	        alice[1] = 1;
	        
	        

	        int[] result = climbingLeaderboard(scores, alice);

	        

	       
	    }
	}
