package innerClasses;


import java.io.*;

import java.util.*;

import java.util.stream.*;

import static java.util.stream.Collectors.toList;
//works with multiple iterations and accurately with one layer - purely my code
public class MatrixRotation6 {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
   	
//    	int layers = 0;
    	Integer firstElementRow = null;
    	
    	
    	Integer[][] array = new Integer[matrix.size()][];
    	for (int i = 0; i < matrix.size(); i++) {
    	    ArrayList<Integer> row = (ArrayList<Integer>) matrix.get(i);
    	    array[i] = row.toArray(new Integer[row.size()]);
    	}
    	
    	int numCol = array[0].length;
    	int numRow = array.length;
    	int row =0;
    	int col =0;
    	
//    	int minimum = Math.min(numCol, numRow);
//    	layers = minimum /2;
////    	int currentLayer = 0;
	
    while (row< numRow && col < numCol){
    	

    	for (int i=0; i<r; i++){ // rotations


    		firstElementRow = array[row][col]; // 1
    		
    		for (int firstRowInd=row;firstRowInd < numCol -1; firstRowInd++ ) { // first row	
    			if (firstRowInd+1 < numCol)
    				array[row][firstRowInd ] =array[row][firstRowInd +1 ]; 		
    		}
    		//-------------------------------------
 		for (int lastColInd=col; lastColInd < numRow-1; lastColInd++){// last col

    				array[lastColInd][numCol -1] = array [lastColInd + 1][numCol -1 ];

    			}  		
    		//-------------------------------
  		for (int lastRowInd=numCol - 1; lastRowInd >= 0; lastRowInd--){ //last row	
			if (lastRowInd+1 < numCol){
  				array[numRow-1][lastRowInd+1] = array [numRow-1][lastRowInd]; 
    				
    			}
    		}
    		
    		//-------------------------------------
 		
  		for (int firstColInd=numRow - 1; firstColInd > 0; firstColInd--){// first col
//  			System.out.println("numRow is: " + numRow);	
//			System.out.println("firstColInd is: " + firstColInd);
//			System.out.println("col is: " + col);
			
			if ((firstColInd+1) < numRow && (numRow) >2 ){
//				System.out.println("array[firstColInd+1][col] before is: " + array[firstColInd+1][col] );
				array[firstColInd+1][col] = array [firstColInd][col];
//				System.out.println("array[firstColInd+1][col] after is: " + array[firstColInd+1][col] );
			}
			
		}
  	//-------------------------------------

    		
    		if (row+1 < numRow){
    			array[row+1][col] = firstElementRow;
    		}
    		
  			
    	}//for rotations.
    		numRow = numRow -1;
    		numCol = numCol -1;

    		row++;
    		col++;
    }//while rows and col  	
   	

    
    for (int i=0; i< array.length; i++){
//		System.out.println(" array.length " + array.length);
		for (int j=0; j< array[i].length; j++){
			System.out.print(array[i][j] );
			System.out.print(" ");
		}
		System.out.println(" ");
	}
    		
    		
    	}// method
    	
    	
    

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
