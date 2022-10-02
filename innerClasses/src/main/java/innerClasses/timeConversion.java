package innerClasses;


	import java.io.*;
	import java.math.*;
	import java.text.*;
	import java.util.*;
	import java.util.regex.*;

	public class timeConversion {

	    /*
	     * Complete the timeConversion function below.
	     */
	    static String timeConvert(String s) {
	    	StringBuilder input= new StringBuilder(s);
	    	if (s.length() < 12)
	    	{ 	
	    		input.insert(s.length() -2 , " ");
	    		//System.out.println("input: "+ input);
	    	}
	    		
	       String proper = input.toString();
	    	
	        DateFormat df = new SimpleDateFormat("hh:mm:ss aa");
	        //Desired format: 24 hour format: Change the pattern as per the need
	        DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
	        Date date = null;
	        String output = null;
	        try{
	           //Converting the input String to Date
	      	 date= df.parse(proper);
	           //Changing the format of date and storing it in String
	      	 output = outputformat.format(date);
	           //Displaying the date
	      	 System.out.println(output);
	        }catch(ParseException pe){
	           pe.printStackTrace();
	         }
			return output;
	        /*
	         * Write your code here.
	         */

	    }

	    private static final Scanner scan = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	       
	    	String s = "07:05:45PM";
	    	
	        String result = timeConvert(s);
	        
	      System.out.println("result: "+ result);
	        
	    }
	}
