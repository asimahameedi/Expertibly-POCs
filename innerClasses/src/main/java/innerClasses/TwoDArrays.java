package innerClasses;


	import java.io.*;
	

	public class TwoDArrays {
	    // Complete the hourglassSum function below.
	    static int hourglassSum(int[][] arr) {
		  //  static int[] hourglassSum(int[][] arr) {
	    	
	    		int col=0, row=0, stop=0, coltoProcess =0, sum=0, middle=0, sv=0;
	    		int sumValues[] = new int[16];


	for ( row = 0; row < 4; row++) 
	{
	             		
	    //while (col<4)
		for ( col = 0; col < 4; col++)
	    {
	            	switch(col)
	            	{  
	            	   case 0 :
	            		   	stop=2;
	            		   	break; 
	            	   
	            	   case 1 :
		            	      stop=3;
		            	      break; 
	            	   case 2 :
		            	      stop=4;
		            	      break; 
		            	      
	            	   case 3 :
		            	      stop=5;
		            	      break;
	            	   } //switch
	            	
	            	coltoProcess=col;
	            	sum=0;
	            	while(coltoProcess<=stop)
	            	{
	            		sum = sum + arr[row][coltoProcess];
	            		sum = sum + arr[row+2][coltoProcess];
	            		
	            		coltoProcess++;
	            		
	            	}
	            	
	            	middle=row+1;
	            	sum = sum + arr[middle][col+1];
	            	
	            	if (sv<16) 
	            	{
	            	sumValues[sv]=sum;
	            	sv++;
	            	}
	       //    col++;
	            	
	        }//for col < 4
	    	
	    	
	    
}//outer for row
	int max=0;
	for (int i = 1; i < sumValues.length; i++) 
        if (sumValues[i] > max) 
            max = sumValues[i];
	        
	return max;
	    }

	   
	    public static void main(String[] args) throws IOException {
	        
	        int[][] arr = new int[6][6];
	        
	        arr[0][0]=-9;
	        arr[0][1]=-9;
	        arr[0][2]=-9;
	        arr[0][3]=1;
	        arr[0][4]=1;
	        arr[0][5]=1;
	        
	        arr[1][0]=0;
	        arr[1][1]=-9;
	        arr[1][2]=0;
	        arr[1][3]=4;
	        arr[1][4]=3;
	        arr[1][5]=2;
	        
	        arr[2][0]=-9;
	        arr[2][1]=-9;
	        arr[2][2]=-9;
	        arr[2][3]=1;
	        arr[2][4]=2;
	        arr[2][5]=3;
	        
	        arr[3][0]=0;
	        arr[3][1]=0;
	        arr[3][2]=8;
	        arr[3][3]=6;
	        arr[3][4]=6;
	        arr[3][5]=0;
	        
	        arr[4][0]=0;
	        arr[4][1]=0;
	        arr[4][2]=0;
	        arr[4][3]=-2;
	        arr[4][4]=0;
	        arr[4][5]=0;
	        
	        arr[5][0]=0;
	        arr[5][1]=0;
	        arr[5][2]=1;
	        arr[5][3]=2;
	        arr[5][4]=4;
	        arr[5][5]=0;

	        for (int row=0;row<6; row++){
	        	for (int col=0; col<6; col++){
	        		System.out.print(arr[row][col]);
	        		System.out.print(" ");
	        	}
	        	System.out.println("");
	        }
	        

//	        int result[] = hourglassSum(arr);
	        
//	        for (int i=0; i<result.length; i++){
//        		System.out.print(result[i]);
//        		System.out.print(" ");
//        	}
	        int max = hourglassSum(arr);
	        
        		System.out.println("max is: "+ max);
        		
        	
//System.out.println("result: " + result);
	    }
	}
