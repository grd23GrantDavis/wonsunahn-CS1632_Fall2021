//TODO: Import libraries as needed
import java.io.*;
import java.util.*;

public class SortedCollection {
	// TODO: Add member variables or methods as needed
	private Vector<Integer> numVec = new Vector<Integer>(0);
	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	public boolean add(int n) {
		numVec.add(n);
		// TODO: Implement
		return true;
	}

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		// TODO: Implement
		int smallest;
		int smallpos=0;
		if(numVec.isEmpty()){
			throw new NoSuchElementException("No elements present");
		}
		else{
			smallest=numVec.get(0);
			for (int i = 0; i<numVec.size(); i++){
				if(i+1==numVec.size()){
					break;
				}
				else{
					if(numVec.get(i+1)<smallest){
						smallest=numVec.get(i+1);
						smallpos=i+1;
					}
				}
			}
			numVec.remove(smallpos);
			return smallest;
		}
	}

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(String[] args) {
		SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			return;
		}
		
		// TODO: add numbers in commandline arguments to collection using the add(int) method.
		// If any commandline argument is not a number, call showUsage() and return.;
	;
		for(int i=0;i<args.length;i++){
			try{
				int num = Integer.parseInt(args[i]);
			}catch (NumberFormatException NaN){
				showUsage();
				return;
			}
		}
		
		for(int i=0;i<args.length;i++){
			collection.add(Integer.parseInt(args[i]));
		}
		
		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
