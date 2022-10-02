package innerClasses;

import java.io.*;

import java.util.*;

import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class MatrixRotations {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
   	
    	int layers = 0;
    	Integer firstElementRow = null;
    	Integer lastElementCol = null;
    	Integer lastElementRow = null;
    	Integer firstElement = null;
    	Integer el2Move = null;
    	Integer  el2Rep=null;
    	
    	Integer[][] array = new Integer[matrix.size()][];
    	for (int i = 0; i < matrix.size(); i++) {
    	    ArrayList<Integer> row = (ArrayList<Integer>) matrix.get(i);
    	    array[i] = row.toArray(new Integer[row.size()]);
    	}
    	
	
    	int numCol = array[0].length;
    	int numRow = array.length;
    	int minimum = Math.min(numCol, numRow);
    	layers = minimum /2;
//    	int currentLayer = 1;
    	int currentLayer = 0;
    	System.out.println("layers is: " + layers );
    	
//    	while(currentLayer < layers){ // layers ???
//			firstElement = array[currentLayer][currentLayer];
//			currentLayer++;
//			break;
//		}
//    	System.out.println("firstElement is: " + firstElement );
    	System.out.println("currentLayer is: " + currentLayer );
    	for (int i=0; i<r; i++){ // rotations

    		firstElementRow = array[currentLayer][currentLayer]; // 1
    		System.out.println("firstElementRow is: " + firstElementRow );
    		lastElementRow = array[0][numCol-1]; // 4
//    		System.out.println("lastElementRow is: " + lastElementRow );
    		for (int firstRowInd=0;firstRowInd < numCol -1; firstRowInd++ ) { // first row
//    			if (firstRowInd +1 < numCol -1){
    			array[0][firstRowInd ] =array[0][firstRowInd +1 ];     			
//    			}
    		}
    		
    		
//    		array[0 ][numCol - 2] = lastElementRow; //4????? do I need it?
//    		System.out.println("array[1][0] before is: " + array[1][0] );
//    		array[1][0] = firstElementRow;
//    		System.out.println("array[1][0] after is: " + array[1][0] );
//    		array[currentLayer][0]=firstElement;
    		
    		//-------------------------------------
    		lastElementCol = array[numRow -1 ][0];
//    		System.out.println("lastElementCol is: " + lastElementCol );
   		for (int firstColInd=numRow - 2; firstColInd >= 0; firstColInd--){// first col
//   			for (int firstColInd=numRow - 2; firstColInd >= 0; firstColInd--){// first col
    			array[firstColInd+1][0] = array [firstColInd][0];
    		}
   		System.out.println("array[1][0] before is: " + array[1][0] );
   		array[1][0] = firstElementRow;
		System.out.println("array[1][0] after is: " + array[1][0] );
    		//-------------------------------
    		lastElementRow = array[numRow -1 ][numCol -1];
//    		System.out.println("lastElementRow is: " + lastElementRow );
    		for (int lastRowInd=numCol - 2; lastRowInd >= 0; lastRowInd--){ //last row
//    			System.out.println("array[firstColInd][0] is: " + array[firstColInd][0] );	
    			array[numCol-1][lastRowInd+1] = array [numCol-1][lastRowInd];
    		}
    		array[numRow -1 ][1] = lastElementCol;
    		//----------------------------------
    		
//    		lastElementCol = array[0][numCol -1];  don't need this one 4
//    		System.out.println("lastElementCol is: " + lastElementCol );
//    		System.out.println("lastElementCol is: " + lastElementCol );
    				
    		for (int lastColInd=0; lastColInd < numRow-2; lastColInd++){// last col
    			array[lastColInd][numCol -1] = array [lastColInd + 1][numCol -1 ];
    		}
    		array[2][numCol - 1 ] = lastElementRow;
    		//-----------------------------------

//    		for (int firstRowInd=0;firstRowInd < numCol -1; firstRowInd++ ) { // first row
//    			if (firstRowInd +1 < numCol -1){
//    			array[0][firstRowInd ] =array[0][firstRowInd +1 ];     			
//    			}
//    		}
//    		array[0 ][numCol - 2] = lastElementCol;
    		//------------------------------------------
//    		lastElementRow = array[numRow -1 ][numCol -1];  // don't need this for the last row
//    		
//    		for (int firstRowInd=0;firstRowInd < numCol -1; firstRowInd++ ){ // first row
//			el2Rep = array[0][firstRowInd];
//			if (firstRowInd +1 < numCol){
//				el2Move = array[0][firstRowInd +1 ];
//			}
//			
//			if (firstRowInd +1 < numCol){
//				array[0][firstRowInd]= el2Move;
//			}else {
//				break;
//			}
		
//		}//end first row
//    		array[0 ][numCol - 2] = lastElementCol;
    		//------------------------------
  			
    	}//for rotations.
    	
//    	currentLayer++;
//
//	} // while layer
//    	
    	for (int i=0; i< array.length; i++){
//    		System.out.println(" array.length " + array.length);
    		for (int j=0; j< array[i].length; j++){
    			System.out.println(" after  i: " + i + " j: "+j + " array[i][j] " + array[i][j] );
    		}
//    		System.out.println(" ");
    	}
    		
    		
    	}
    	
    	
    

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
