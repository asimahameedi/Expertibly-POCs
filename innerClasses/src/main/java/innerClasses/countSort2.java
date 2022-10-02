package innerClasses;

import java.io.*;

import java.util.*;

import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class countSort2 {

    // Complete the countSort function below.
    static void countSortFun(List<List<String>> arr) {

int sizeOuter = arr.size();

for (int i=0; i < sizeOuter/2; i++){
	arr.get(i).set(1,"-");
}

String tempNum;
String tempString;


int pivot = sizeOuter -1;
int ind = -1;
int j= 0;
String pivotElement = arr.get(pivot).get(0);
while (j< (sizeOuter - 1) ){
if(Integer.parseInt(arr.get(j).get(0)) < Integer.parseInt(pivotElement)){
	ind++;
	tempNum = arr.get(ind).get(0);
	arr.get(ind).set(0,arr.get(j).get(0));
	arr.get(j).set(0,tempNum);
	j++;
}else if(Integer.parseInt(arr.get(j).get(0)) > Integer.parseInt(pivotElement)) {
	j++;
}
//
else if(Integer.parseInt(arr.get(j).get(0)) == Integer.parseInt(pivotElement)) {
	j++;
}
}
//shift array & swap pivot with i+1 element

String temp =arr.get(pivot).get(0);

//for (int k=sizeOuter -2 ; k>-1; k--){
for (int k=sizeOuter -2 ; k>ind; k--){
	arr.get(k+1).set(0,arr.get(k).get(0));
}
arr.get(ind+1).set(0,temp);
pivot = ind+1;


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
