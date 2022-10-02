package innerClasses;



import java.io.*;

import java.util.*;

import java.util.stream.*;

import static java.util.stream.Collectors.toList;
//works with multiple iterations and accurately with one layer - purely my code
public class MatrixRotation4 {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
   	
    	int layers = 0;
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
    	int nRow = numRow;
    	int nCol = numCol;
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
    		
    		while (row < nRow && col <nCol) { //rows & cols
    			 
    			 if (row + 1 == nRow || col + 1 == nCol) 
    			 { break;}
    			 
    		firstElementRow = array[row][col]; // 1
    		System.out.println("firstElementRow is: " + firstElementRow );
    		

    		
//    		for (int firstRowInd=0;firstRowInd < numCol -1; firstRowInd++ ) { // first row
    		for (int firstRowInd=col;firstRowInd < nCol - 1; firstRowInd++ ) { // first row
    			
//    			array[0][firstRowInd ] =array[0][firstRowInd +1 ]; 
    			array[row][firstRowInd ] =array[row][firstRowInd +1 ]; 
    		}
    		row++;
    		//-------------------------------------
//    		for (int i = row; i < m; i++) 
//            { 
//                curr = mat[i][n-1]; 
//                mat[i][n-1] = prev; 
//                prev = curr; 
//            } 
//            n--; 
    		
//    		for (int lastColInd=0; lastColInd < numRow-1; lastColInd++){// last col
//    			for (int lastColInd=row; lastColInd < nRow; lastColInd++){// last col
    				for (int lastColInd=row; lastColInd < nRow -1; lastColInd++){// last col
    				System.out.println("nCol is: " + nCol  );
    				System.out.println("lastColInd is: " + lastColInd);
    				System.out.println("array[lastColInd][nCol -1] is: " + array[lastColInd][nCol -1] );
//    				array[lastColInd][numCol -1] = array [lastColInd + 1][numCol -1 ];
    				
    					array[lastColInd][nCol -1] = array [lastColInd + 1][nCol -1 ];
    				
    			}
    				col--;
//    		nCol--;
//    		nCol++;
    		//-------------------------------
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
//    		
    		for (int lastRowInd=nCol - 1 ; lastRowInd >= 0; lastRowInd--){ //last row
//    		for (int lastRowInd=numCol - 2; lastRowInd >= 0; lastRowInd--){ //last row
//    			mat[i][n-1];
//    			array[numCol-1][lastRowInd+1] = array [numCol-1][lastRowInd];
    			System.out.println("col is: "+ col + "lastRowInd is: "+ lastRowInd);
    			if (lastRowInd+1 > numRow)
    			array[nRow-1][lastRowInd+1] = array [nRow-1][lastRowInd];
    		}
//    		nRow--;
    		row--;
    		//-------------------------------------
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
    		
    		
//    		for (int firstColInd=numRow - 2; firstColInd >= 0; firstColInd--){// first col 		
    		for (int firstColInd=nRow -1; firstColInd >= row; firstColInd--){// first col 
//    			array[firstColInd+1][0] = array [firstColInd][0];
    			System.out.println("firstColInd is: "+ firstColInd);
    			System.out.println("col is: "+ col);
    			
    			array[firstColInd+1][col] = array [firstColInd][col];
    		}
   		col++;
//   		array[1][0] = firstElementRow;
   		array[row+1][col] = firstElementRow; // ???????
    		}// rows & cols
  			
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
