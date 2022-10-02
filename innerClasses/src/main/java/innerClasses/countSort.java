package innerClasses;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class countSort {

    // Complete the countSort function below.
    static void countSortFun(List<List<String>> arr) {

int sizeOuter = arr.size();

for (int i=0; i < sizeOuter/2; i++){
	arr.get(i).set(1,"-");
}

String tempNum;
String tempString;
for (int i = 1; i < sizeOuter; i++) {
    for(int j = i ; j > 0 ; j--){

        if(Integer.parseInt(arr.get(j).get(0)) < Integer.parseInt(arr.get(j-1).get(0))){

        	tempNum = arr.get(j).get(0);
        	tempString = arr.get(j).get(1);

            arr.get(j).set(0,arr.get(j-1).get(0));
            arr.get(j).set(1,arr.get(j-1).get(1));

            arr.get(j-1).set(0,tempNum);
            arr.get(j-1).set(1,tempString);
        }
    }
}

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
