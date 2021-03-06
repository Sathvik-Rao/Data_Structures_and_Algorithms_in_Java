package dsa.algorithms.sort;


/**
 * This class contains sort methods which are implemented using traditional (one-pivot) Quicksort.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p>Time and space complexity varies according to the input.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time and Space complexity">
 * 	<tr>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Space Complexity</th>
 * 	</tr>
 * 	<tr>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(n logn)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n logn)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n<sup STYLE="font-size:8.0pt">2</sup>)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 */
public class QuickSort
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private QuickSort() {}
	
	
	// char array
	/**
	 * Sorts the specified array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(char[] a, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(a.length > 1)
		{
			// Ascending Order
			if(c == 'a' || c == 'A')
			{
				quickSortAscending(a, 0, a.length - 1);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				quickSortDescending(a, 0, a.length - 1);
			}
			
			// Invalid Character
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}
	
	/**
	 * Sorts the specified range of array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex the index of the last element, exclusive, to be sorted
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(char[] a, int fromIndex, int toIndex, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				// Ascending Order
				if(c == 'a' || c == 'A')
				{
					quickSortAscending(a, fromIndex, toIndex - 1);
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					quickSortDescending(a, fromIndex, toIndex - 1);
				}
				
				// Invalid Character
				else
				{
					throw new IllegalArgumentException("Invalid choice \'" + c + 
					"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
				}
			}
			else
			{
				throw new IllegalArgumentException("fromIndex(" + fromIndex +
													") > toIndex(" + toIndex + ")");
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("[" + fromIndex + ", "+toIndex + "]");
		}
	}
	
	// char array Ascending order
	private static void quickSortAscending(char[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int partitionAscending(char[] a, int start, int end)
	{
		char pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] <= pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	// char array Descending order
	private static void quickSortDescending(char[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int partitionDescending(char[] a, int start, int end)
	{
		char pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] > pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	
	// byte array
	/**
	 * Sorts the specified array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(byte[] a, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(a.length > 1)
		{
			// Ascending Order
			if(c == 'a' || c == 'A')
			{
				quickSortAscending(a, 0, a.length - 1);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				quickSortDescending(a, 0, a.length - 1);
			}
			
			// Invalid Character
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}
	
	/**
	 * Sorts the specified range of array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex the index of the last element, exclusive, to be sorted
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(byte[] a, int fromIndex, int toIndex, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				// Ascending Order
				if(c == 'a' || c == 'A')
				{
					quickSortAscending(a, fromIndex, toIndex - 1);
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					quickSortDescending(a, fromIndex, toIndex - 1);
				}
				
				// Invalid Character
				else
				{
					throw new IllegalArgumentException("Invalid choice \'" + c + 
					"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
				}
			}
			else
			{
				throw new IllegalArgumentException("fromIndex(" + fromIndex +
													") > toIndex(" + toIndex + ")");
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("[" + fromIndex + ", "+toIndex + "]");
		}
	}
	
	// byte array Ascending order
	private static void quickSortAscending(byte[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int partitionAscending(byte[] a, int start, int end)
	{
		byte pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] <= pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	// byte array Descending order
	private static void quickSortDescending(byte[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int partitionDescending(byte[] a, int start, int end)
	{
		byte pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] > pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	
	// short array
	/**
	 * Sorts the specified array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(short[] a, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(a.length > 1)
		{
			// Ascending Order
			if(c == 'a' || c == 'A')
			{
				quickSortAscending(a, 0, a.length - 1);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				quickSortDescending(a, 0, a.length - 1);
			}
			
			// Invalid Character
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}
	
	/**
	 * Sorts the specified range of array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex the index of the last element, exclusive, to be sorted
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(short[] a, int fromIndex, int toIndex, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				// Ascending Order
				if(c == 'a' || c == 'A')
				{
					quickSortAscending(a, fromIndex, toIndex - 1);
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					quickSortDescending(a, fromIndex, toIndex - 1);
				}
				
				// Invalid Character
				else
				{
					throw new IllegalArgumentException("Invalid choice \'" + c + 
					"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
				}
			}
			else
			{
				throw new IllegalArgumentException("fromIndex(" + fromIndex +
													") > toIndex(" + toIndex + ")");
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("[" + fromIndex + ", "+toIndex + "]");
		}
	}
	
	// short array Ascending order
	private static void quickSortAscending(short[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int partitionAscending(short[] a, int start, int end)
	{
		short pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] <= pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	// short array Descending order
	private static void quickSortDescending(short[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int partitionDescending(short[] a, int start, int end)
	{
		short pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] > pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	
	// int array
	/**
	 * Sorts the specified array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(int[] a, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(a.length > 1)
		{
			// Ascending Order
			if(c == 'a' || c == 'A')
			{
				quickSortAscending(a, 0, a.length - 1);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				quickSortDescending(a, 0, a.length - 1);
			}
			
			// Invalid Character
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}
	
	/**
	 * Sorts the specified range of array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex the index of the last element, exclusive, to be sorted
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(int[] a, int fromIndex, int toIndex, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				// Ascending Order
				if(c == 'a' || c == 'A')
				{
					quickSortAscending(a, fromIndex, toIndex - 1);
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					quickSortDescending(a, fromIndex, toIndex - 1);
				}
				
				// Invalid Character
				else
				{
					throw new IllegalArgumentException("Invalid choice \'" + c + 
					"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
				}
			}
			else
			{
				throw new IllegalArgumentException("fromIndex(" + fromIndex +
													") > toIndex(" + toIndex + ")");
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("[" + fromIndex + ", "+toIndex + "]");
		}
	}
	
	// int array Ascending order
	private static void quickSortAscending(int[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int partitionAscending(int[] a, int start, int end)
	{
		int pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] <= pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	// int array Descending order
	private static void quickSortDescending(int[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int partitionDescending(int[] a, int start, int end)
	{
		int pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] > pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	
	// long array
	/**
	 * Sorts the specified array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(long[] a, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(a.length > 1)
		{
			// Ascending Order
			if(c == 'a' || c == 'A')
			{
				quickSortAscending(a, 0, a.length - 1);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				quickSortDescending(a, 0, a.length - 1);
			}
			
			// Invalid Character
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}
	
	/**
	 * Sorts the specified range of array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex the index of the last element, exclusive, to be sorted
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(long[] a, int fromIndex, int toIndex, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				// Ascending Order
				if(c == 'a' || c == 'A')
				{
					quickSortAscending(a, fromIndex, toIndex - 1);
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					quickSortDescending(a, fromIndex, toIndex - 1);
				}
				
				// Invalid Character
				else
				{
					throw new IllegalArgumentException("Invalid choice \'" + c + 
					"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
				}
			}
			else
			{
				throw new IllegalArgumentException("fromIndex(" + fromIndex +
													") > toIndex(" + toIndex + ")");
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("[" + fromIndex + ", "+toIndex + "]");
		}
	}
	
	// long array Ascending order
	private static void quickSortAscending(long[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int partitionAscending(long[] a, int start, int end)
	{
		long pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] <= pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	// long array Descending order
	private static void quickSortDescending(long[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int partitionDescending(long[] a, int start, int end)
	{
		long pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] > pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	
	// float array
	/**
	 * Sorts the specified array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(float[] a, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(a.length > 1)
		{
			// Ascending Order
			if(c == 'a' || c == 'A')
			{
				quickSortAscending(a, 0, a.length - 1);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				quickSortDescending(a, 0, a.length - 1);
			}
			
			// Invalid Character
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}
	
	/**
	 * Sorts the specified range of array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex the index of the last element, exclusive, to be sorted
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(float[] a, int fromIndex, int toIndex, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				// Ascending Order
				if(c == 'a' || c == 'A')
				{
					quickSortAscending(a, fromIndex, toIndex - 1);
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					quickSortDescending(a, fromIndex, toIndex - 1);
				}
				
				// Invalid Character
				else
				{
					throw new IllegalArgumentException("Invalid choice \'" + c + 
					"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
				}
			}
			else
			{
				throw new IllegalArgumentException("fromIndex(" + fromIndex +
													") > toIndex(" + toIndex + ")");
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("[" + fromIndex + ", "+toIndex + "]");
		}
	}
	
	// float array Ascending order
	private static void quickSortAscending(float[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int partitionAscending(float[] a, int start, int end)
	{
		float pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] <= pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	// float array Descending order
	private static void quickSortDescending(float[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int partitionDescending(float[] a, int start, int end)
	{
		float pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] > pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	
	// double array
	/**
	 * Sorts the specified array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(double[] a, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(a.length > 1)
		{
			// Ascending Order
			if(c == 'a' || c == 'A')
			{
				quickSortAscending(a, 0, a.length - 1);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				quickSortDescending(a, 0, a.length - 1);
			}
			
			// Invalid Character
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}
	
	/**
	 * Sorts the specified range of array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex the index of the last element, exclusive, to be sorted
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(double[] a, int fromIndex, int toIndex, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				// Ascending Order
				if(c == 'a' || c == 'A')
				{
					quickSortAscending(a, fromIndex, toIndex - 1);
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					quickSortDescending(a, fromIndex, toIndex - 1);
				}
				
				// Invalid Character
				else
				{
					throw new IllegalArgumentException("Invalid choice \'" + c + 
					"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
				}
			}
			else
			{
				throw new IllegalArgumentException("fromIndex(" + fromIndex +
													") > toIndex(" + toIndex + ")");
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("[" + fromIndex + ", "+toIndex + "]");
		}
	}
	
	// double array Ascending order
	private static void quickSortAscending(double[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int partitionAscending(double[] a, int start, int end)
	{
		double pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] <= pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	// double array Descending order
	private static void quickSortDescending(double[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int partitionDescending(double[] a, int start, int end)
	{
		double pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if(a[i] > pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	
	// Generic array
	/**
	 * Sorts the specified array into ascending/descending order 
	 * based on the character input.
	 *
	 * @param <T> the type of elements that implements Comparable interface
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static <T extends Comparable<T>> void sort(T[] a, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(a.length > 1)
		{
			// Ascending Order
			if(c == 'a' || c == 'A')
			{
				quickSortAscending(a, 0, a.length - 1);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				quickSortDescending(a, 0, a.length - 1);
			}
			
			// Invalid Character
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}
	
	/**
	 * Sorts the specified range of array into ascending/descending order 
	 * based on the character input.
	 *
     * @param <T> the type of elements that implements Comparable interface
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex the index of the last element, exclusive, to be sorted
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static <T extends Comparable<T>> void sort(T[] a, int fromIndex, int toIndex, char c) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				// Ascending Order
				if(c == 'a' || c == 'A')
				{
					quickSortAscending(a, fromIndex, toIndex - 1);
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					quickSortDescending(a, fromIndex, toIndex - 1);
				}
				
				// Invalid Character
				else
				{
					throw new IllegalArgumentException("Invalid choice \'" + c + 
					"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
				}
			}
			else
			{
				throw new IllegalArgumentException("fromIndex(" + fromIndex +
													") > toIndex(" + toIndex + ")");
			}
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException("[" + fromIndex + ", "+toIndex + "]");
		}
	}
	
	// Generic array Ascending order
	private static <T extends Comparable<T>> void quickSortAscending(T[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static <T extends Comparable<T>> int partitionAscending(T[] a, int start, int end)
	{
		T pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if((a[i]).compareTo(pivot) < 1)	
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
	
	// Generic array Descending order
	private static <T extends Comparable<T>> void quickSortDescending(T[] a, int start, int end)
	{
		if(start < end)
		{
			int pIndex = partitionDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static <T extends Comparable<T>> int partitionDescending(T[] a, int start, int end)
	{
		T pivot = a[end], temp;
		int pIndex = start;
		for(int i = start; i < end; i++)
		{
			if((a[i]).compareTo(pivot) > 0)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
}
