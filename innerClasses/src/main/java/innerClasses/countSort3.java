package innerClasses;

import java.io.*;

import java.util.*;

import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class countSort3 {

    // Complete the countSort function below.
    static void countSortFun(List<List<String>> arr) {

int sizeOuter = arr.size();

for (int i=0; i < sizeOuter/2; i++){
	arr.get(i).set(1,"-");
}

//qSort(arr, 0, n-1); 
qSort(arr, 0, sizeOuter-1);


//for (int i = 1; i < sizeOuter; i++) {
//    for(int j = i ; j > 0 ; j--){
//
//        if(Integer.parseInt(arr.get(j).get(0)) < Integer.parseInt(arr.get(j-1).get(0))){
//
//        	tempNum = arr.get(j).get(0);
//        	tempString = arr.get(j).get(1);
//
//            arr.get(j).set(0,arr.get(j-1).get(0));
//            arr.get(j).set(1,arr.get(j-1).get(1));
//
//            arr.get(j-1).set(0,tempNum);
//            arr.get(j-1).set(1,tempString);
//        }
//    }
//}

for (int i=0; i < sizeOuter; i++){
	
	
	System.out.print(arr.get(i).get(1));
	System.out.print(" ");

}

    }
    
    static void qSort(List<List<String>> arr, int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is 
            now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            qSort(arr, low, pi-1); 
            qSort(arr, pi+1, high); 
        } 
    } 
    static int partition(List<List<String>> arr, int low, int high) 
    { 
//        int pivot = arr[high];
        int pivot = Integer.parseInt(arr.get(high).get(0));
//        System.out.println("pivot: " +pivot);
        int i = (low-1); // index of smaller element 
        for (int j=low; j<=high-1; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
//            if (arr[j] <= pivot) 
        	if (Integer.parseInt(arr.get(j).get(0)) <= pivot) 
            { 
                i++; 
                System.out.println("here: ");
                // swap arr[i] and arr[j] 
//                int temp = arr[i]; 
                int temp = Integer.parseInt(arr.get(i).get(0)); 
//                arr[i] = arr[j]; 
                arr.get(i).set(0,arr.get(j).get(0));
//                arr[j] = temp; 
                arr.get(j).set(0,String.valueOf(temp));
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
//        int temp = arr[i+1]; 
        int temp = Integer.parseInt(arr.get(i+1).get(0)); 
//        arr[i+1] = arr[high]; 
        arr.get(i+1).set(0, arr.get(high).get(0));
  
        return i+1; 
    } 
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        countSortFun(arr);

        bufferedReader.close();
    }
}
