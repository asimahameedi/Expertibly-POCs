package innerClasses;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Java program to rotate a matrix 
import java.lang.*; 
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream; 

class GeekMatrixRotation 
{ 
	static int R = 4; 
	static int C = 4; 

	// A function to rotate a matrix 
	// mat[][] of size R x C. 
	// Initially, m = R and n = C 
//	static void matrixRotation(int m, 
//					int n, int mat[][]) 
	static void matrixRotation(List<List<Integer>> matrix, int r) {
	{ 
		int row = 0, col = 0; 
		int prev, curr; 
		
		Integer[][] mat = new Integer[matrix.size()][];
    	for (int i = 0; i < matrix.size(); i++) {
    	    ArrayList<Integer> singleRow = (ArrayList<Integer>) matrix.get(i);
    	    mat[i] = singleRow.toArray(new Integer[singleRow.size()]);
    	}

    	
    	int numCol = mat[0].length;
    	int numRow = mat.length;
    	int m = numRow;
    	int n = numCol;
    	int minimum = Math.min(numCol, numRow);
//    	layers = minimum /2;
//    	int currentLayer = 1;
    	int currentLayer = 0;
		/* 
		row - Staring row index 
		m - ending row index 
		col - starting column index 
		n - ending column index 
		i - iterator 
		*/
		while (row < m && col < n) 
		{ 
	
			if (row + 1 == m || col + 1 == n) 
				break; 
	
			// Store the first element of next 
			// row, this element will replace 
			// first element of current row 
//			prev = mat[row + 1][col]; 
			prev = mat[row][col]; 
	
			// Move elements of first row 
			// from the remaining rows 
			for (int i = col; i < n; i++) 
			{ 
//				curr = mat[row][i]; 
//				mat[row][i] = prev; 
//				prev = curr; 
				
				curr = mat[row+1][i]; 
				System.out.println("prev is: "+ prev );
				System.out.println("row is: "+ row +"i is: "+ i);
				System.out.println("curr = mat[row+1][i] is: "+ mat[row+1][i]);
				mat[row+1][i] = prev; 
				prev = curr; 
			} 
			row++; 
			
	
			// Move elements of last column 
			// from the remaining columns 
			for (int i = row; i < m; i++) 
			{ 
				curr = mat[i][n-1]; 
				mat[i][n-1] = prev; 
				prev = curr; 
				
//				array[lastColInd][numCol -1] = array [lastColInd + 1][numCol -1 ];
				

			} 
			n--; 
	
			// Move elements of last row 
			// from the remaining rows 
			if (row < m) 
			{ 
				for (int i = n-1; i >= col; i--) 
				{ 
					curr = mat[m-1][i]; 
					mat[m-1][i] = prev; 
					prev = curr; 
//					for (int lastRowInd=numCol - 2; lastRowInd >= 0; lastRowInd--){ //last row
////		    			System.out.println("array[firstColInd][0] is: " + array[firstColInd][0] );	
//		    			array[numCol-1][lastRowInd+1] = array [numCol-1][lastRowInd];
//		    		}	
					
//					curr = mat[m-1][i];  // still need to figure out
//					// prev is mat[i][n-1]
////					mat[m-1][i] = prev; 
//					mat[m-1][i] = mat[i][n-1]; 
//					prev = curr;
					
					
					
				} 
			} 
			m--; 
	
			// Move elements of first column 
			// from the remaining rows 
			if (col < n) 
			{ 
				for (int i = m-1; i >= row; i--) 
				{ 
//					curr = mat[i][col]; 
//					mat[i][col] = prev; 
//					prev = curr; 
//					for (int firstColInd=numRow - 2; firstColInd >= 0; firstColInd--){// first col
//					array[firstColInd+1][0] = array [firstColInd][0];
					
					curr = mat[i][col]; 
					mat[i+1][col] = mat[i][col]; //????
					prev = curr;
				} 
			} 
			col++; 
		} 

			// Print rotated matrix 
			for (int i = 0; i < R; i++) 
			{ 
				for (int j = 0; j < C; j++) 
				System.out.print( mat[i][j] + " "); 
				System.out.print("\n"); 
			} 
	}
	}

/* Driver program to test above functions */
	public static void main(String[] args) 
	{ 
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] mnr=null;;
        try {
			mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

        try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
} 

//This code is contributed by Sahil_Bansall 
