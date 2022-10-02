package innerClasses;


import java.io.*;

import java.util.*;

import java.util.stream.*;

import static java.util.stream.Collectors.toList;
// code from google plus my code
public class MatrixRotation2 {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
   	
    	int layers = 0;
    	int row = 0;
    	int col = 0;
    	int ro = 0;
    	int co = 0;
    	Integer firstElementRow = null;
    	Integer lastElementCol = null;
    	Integer lastElementRow = null;
    	Integer firstElement = null;
    	
    	
    	Integer[][] array = new Integer[matrix.size()][];
    	for (int i = 0; i < matrix.size(); i++) {
    	    ArrayList<Integer> singleRow = (ArrayList<Integer>) matrix.get(i);
    	    array[i] = singleRow.toArray(new Integer[singleRow.size()]);
    	}
    	
	
    	int numCol = array[0].length;
    	int numRow = array.length;
    	int mRows = numRow;
    	int nCols = numCol;
    	int minimum = Math.min(numCol, numRow);
    	layers = minimum /2;
//    	int currentLayer = 1;
    	int currentLayer = 0;
    	System.out.println("layers is: " + layers );
    
    	while(currentLayer < layers){ // layers ???
			firstElement = array[currentLayer][currentLayer];
			currentLayer++;
//			break;
		}
//    	System.out.println("firstElement is: " + firstElement );
    	System.out.println("currentLayer is: " + currentLayer );
    	while (row < mRows && col < nCols) 
        { 
      
            if (row + 1 == numRow || col + 1 == numCol) 
                break; 
      
    	for (int i=0; i<r; i++){ // rotations
//    		firstElementRow = array[row][col]; // 1 
    		firstElementRow = array[row][col]; // 1
    		ro=row;
    		co=col;
    		System.out.println("firstElementRow is: " + firstElementRow );
    		
//    		for (int i = col; i < n; i++) 
//            { 
//                curr = mat[row][i]; 
//                mat[row][i] = prev; 
//                prev = curr; 
//            } 
    		
	
    		for (int firstRowInd=col;firstRowInd < nCols -1; firstRowInd++ ) { // first row
//    			for (int firstRowInd=0;firstRowInd < numCol -1; firstRowInd++ ) { // first row
    			
//    				array[0][firstRowInd ] =array[0][firstRowInd +1 ];  
    			array[row][firstRowInd ] =array[row][firstRowInd +1 ]; 
    		}
    		
   		row++;
   		
    		//-------------------------------------
			
//   		for (int i = row; i < m; i++) 
//        { 
//            curr = mat[i][n-1]; 
//            mat[i][n-1] = prev; 
//            prev = curr; 
//        } 
//        n--; 
//    		for (int lastColInd=0; lastColInd < numRow-1; lastColInd++){// last col
   		for (int lastColInd=row; lastColInd < mRows; lastColInd++){// last col
//    			array[lastColInd][numCol -1] = array [lastColInd + 1][numCol -1 ];
    			array[lastColInd][nCols -1] = array [lastColInd + 1][nCols -1 ];
    		}
    		nCols--;
//    		array[2][numCol - 1 ] = lastElementRow;//uncomment when ready
    		//-----------------------------------
//    		if (row < m) 
//            { 
//                for (int i = n-1; i >= col; i--) 
//                { 
//                    curr = mat[m-1][i]; 
//                    mat[m-1][i] = prev; 
//                    prev = curr; 
//                } 
//            } 
//            m--; 
    		
    		lastElementRow = array[numRow -1 ][numCol -1];
    		if (row < mRows) 
            { 
//    			for (int lastRowInd=numCol - 2; lastRowInd >= 0; lastRowInd--){ //last row
//
//    				array[numCol-1][lastRowInd+1] = array [numCol-1][lastRowInd];
//    			}
    			for (int lastRowInd=nCols - 2; lastRowInd >= 0; lastRowInd--){ //last row

    				array[nCols-1][lastRowInd+1] = array [nCols-1][lastRowInd];
    			}
            }
//    		array[numRow -1 ][1] = lastElementCol; // uncomment when ready
    		mRows--;
    		
    		//-------------------------------
//    		if (col < n) 
//            { 
//                for (int i = m-1; i >= row; i--) 
//                { 
//                    curr = mat[i][col]; 
//                    mat[i][col] = prev; 
//                    prev = curr; 
//                } 
//            } 
//            col++; 
    		lastElementCol = array[numRow -1 ][0];
    		if (col < nCols) 
            {
//    			for (int firstColInd=numRow - 2; firstColInd >= 0; firstColInd--){// first col
//    				array[firstColInd+1][0] = array [firstColInd][0];
//    			}
    			for (int firstColInd=mRows - 2; firstColInd >= 0; firstColInd--){// first col

    				array[firstColInd+1][0] = array [firstColInd][0];
    			}
   		
//    			array[1][0] = firstElementRow;
    			System.out.println("ro  is: " + ro + "co is: " +co);
    			array[ro + 1][co] = firstElementRow;
            }
			col++;
		//-------------------------------
  			
    	}//for rotations.
        } // while for rows & col
    	
//    	currentLayer++;

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
