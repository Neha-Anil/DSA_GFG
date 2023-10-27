// Java Program to Create a Dynamic Array

// Class 1
// Helper class
class Array {

	// Member variables of this class
	// Private access modifier
	private int arr[];
	private int count;

	// Note they can only be called through function

	// Method 1
	// Inside helper class
	// to compute length of an array
	public Array(int length) { arr = new int[length]; }

	// Method 2
	// Inside helper class
	// To print array
	public void printArray()
	{

		// Iterating over array using for loop
		for (int i = 0; i < count; i++) {

			// Print the elements of an array
			System.out.print(arr[i] + " ");
		}
	}

	// Method 3
	// Inside Helper class
	public void insert(int element)
	{

		if (arr.length == count) {

			// Creating a new array double the size
			// of array declared above
			int newArr[] = new int[2 * count];

			// Iterating over new array using for loop
			for (int i = 0; i < count; i++) {
				newArr[i] = arr[i];
			}

			// Assigning new array to original array
			// created above
			arr = newArr;
		}

		arr[count++] = element;
	}
}

// Class 2
// Main class
public class GFG {

	// Main driver method
	public static void main(String[] args)
	{

		// Creating object of Array(user-defined) class
		Array numbers = new Array(3);

		// Adding elements more than size specified above
		// to the array to illustrate dynamic nature
		// using the insert() method

		// Custom input elements
		numbers.insert(10);
		numbers.insert(30);
		numbers.insert(40);
		numbers.insert(50);

		// Calling the printArray() method to print
		// new array been dynamically created
		numbers.printArray();
	}
}
