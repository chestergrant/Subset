/**
 * @(#)Subset.java
 *
 * Subset application
 * My solution to problem 3
 *
 * @author Chester Grant
 * @version 1.00 2010/10/9
 */
 
import java.io.*;
import java.util.*;
public class Subset {
  	

    //Prints the sum in a set	
	public static int sumset(Vector arr, Vector index){
		int sum = 0;
		for(int i =0; i<index.size(); i++){
			int item = ((Integer)arr.get( ((Integer)index.get(i)).intValue())).intValue();
			sum += item;
			
		}
		return sum;		
	}
	public static void printset(Vector arr, Vector index){
		
		for(int i =0; i<index.size(); i++){
			int item = ((Integer)arr.get( ((Integer)index.get(i)).intValue())).intValue();
			System.out.print(item+" ");
			
		}		
		System.out.println();
	}

	
	
	//Find the maximum number in a set
    public static int max(Vector arr, Vector index){
		int max = 0;
		for(int i =0; i<index.size(); i++){
			if(max <((Integer)arr.get( ((Integer)index.get(i)).intValue())).intValue()){
				max = ((Integer)arr.get( ((Integer)index.get(i)).intValue())).intValue();
			}
		}
		return max;
		
	}
	public static String getKey(Vector index){
		String aStr ="";
		for(int i =0; i< index.size();i++){
			aStr += "-"+index.get(i).toString();
		}
		
		return aStr;
	}
	
	//Recursive function to find all subsets of an array at particular start point
	//For each subset found check to see if the sum is twice the maximum number
	//Returns the number of subsets that are
	public static int numSub(Vector arr, int start, Vector index){
		int sum = 0;
				
		if(start == arr.size()-1){
			return 0;
		}
		
		for(int i = start+1; i< arr.size(); i++){
			Integer aNum = new Integer(i);
			index.add(aNum);
			sum += numSub(arr,i,index);
			index.remove(aNum);		
		}
		int maximum = max(arr,index);
		int sum2 = sumset(arr,index);
		    
		if(sum2-maximum == maximum){
			   if(index.size() > 1){
					sum++;
					
			   }
		}
		
	
		return sum;
	}
	
    public static void main(String[] args) {
    	 try{
    	 	//Reads in the Data from file into a vector
    	 	BufferedReader in = new BufferedReader(new FileReader("C:\\numbers.csv"));
    	 	String input = in.readLine();
    	 	
    	 	String strArr[] = input.split("[,]|[\\s]");
    	 	Vector aVec = new Vector();
    	 	
    	 	for(int i = 0; i< strArr.length; i++){
    	 		if(strArr[i].compareTo("")!=0){
    	 		   aVec.add(Integer.parseInt(strArr[i]));
    	 		}
    	 	}
    	 	aVec.add(new Integer(0));
    	 	
    	 	int ans = 0;
    	 	
    	 	//Finds the required answer 
    	 	for(int i = aVec.size()-2;i >=0; i--){
    	 		Vector start = new Vector();
    	 		start.add(new Integer(i));
    	 		ans += numSub(aVec,i,start);
    	 		//System.out.println("YEP");
    	 	}
    	 	
    	 	//Displays answer
    	 	System.out.println();
    	 	System.out.println("The answer to problem 3 is: "+ans);
    	 }catch(IOException ex){
    	 	System.out.println("Input Error: Abort ");
    	 	System.exit(1);
    	 }
    }
}
