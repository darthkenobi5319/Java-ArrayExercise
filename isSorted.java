import java.util.*;

public class isSorted{
	
	public static void main(String[] args) {
		//Construct the array
		Scanner input = null;
		System.out.println("Enter the integer number of items: ");
		input = new Scanner (System.in);
		int number = input.nextInt();
		double[] doubleArray = generateArray(number);
		System.out.println(issorted(doubleArray));
		
		input.close();
	}
	

	/**
	 * This method generates an array and fills it with doubles
	 * @param number the number of items in the array
	 * @return the generated array 
	 * @throws NoSuchElementException if the user inputs a datatype which is not double
	 */
	public static double[] generateArray(int number) throws NoSuchElementException{
		double[] doubleArray = new double[number];
		for (int i = 0; i < number; i++) {
			System.out.println("Enter a double in the array");
			Scanner inArray = null;
			inArray = new Scanner(System.in);
			if (!inArray.hasNextDouble()) {
				inArray.close();
				throw new NoSuchElementException("You need to enter a number of type double");				
			}
			double doubleNumber = inArray.nextDouble();
			doubleArray[i] = doubleNumber;
			inArray.close();
	}
		return doubleArray;
	}
	
	
	
	/**
	 * This method takes a constructed array and determine whether the array is 
	 * sorted in an ascending order
	 * @param doubleArray the existing array of double numbers
	 * @return the boolean value of whether the array is ordered in an ascending fasion.
	 * 
	 */
	public static boolean issorted(double[] doubleArray) {
		int i = 1;
		while (i < doubleArray.length) {
			if (doubleArray[i] < doubleArray[i-1]) {
				return false;
			}
			i++;
		}
		return true;
	}
}