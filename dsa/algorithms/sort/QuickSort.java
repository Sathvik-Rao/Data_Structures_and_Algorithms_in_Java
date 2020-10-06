package dsa.algorithms.sort;


/**
 * This class contains sort methods which are implemented using traditional (one-pivot) Quicksort.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p>Time and space complexity varies according to the input. 
 * It is implemented using traditional quicksort which is <b>least effecient</b>.</p>
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
 * @see <a href="InvalidChoiceException.html">InvalidChoiceException</a>
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(char[] a, char c) throws InvalidChoiceException
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
				throw new InvalidChoiceException(c);
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(char[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					throw new InvalidChoiceException(c);
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
			int pIndex = quickAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int quickAscending(char[] a, int start, int end)
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
			int pIndex = quickDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int quickDescending(char[] a, int start, int end)
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(byte[] a, char c) throws InvalidChoiceException
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
				throw new InvalidChoiceException(c);
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(byte[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					throw new InvalidChoiceException(c);
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
			int pIndex = quickAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int quickAscending(byte[] a, int start, int end)
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
			int pIndex = quickDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int quickDescending(byte[] a, int start, int end)
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(short[] a, char c) throws InvalidChoiceException
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
				throw new InvalidChoiceException(c);
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(short[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					throw new InvalidChoiceException(c);
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
			int pIndex = quickAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int quickAscending(short[] a, int start, int end)
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
			int pIndex = quickDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int quickDescending(short[] a, int start, int end)
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(int[] a, char c) throws InvalidChoiceException
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
				throw new InvalidChoiceException(c);
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(int[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					throw new InvalidChoiceException(c);
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
			int pIndex = quickAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int quickAscending(int[] a, int start, int end)
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
			int pIndex = quickDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int quickDescending(int[] a, int start, int end)
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(long[] a, char c) throws InvalidChoiceException
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
				throw new InvalidChoiceException(c);
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(long[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					throw new InvalidChoiceException(c);
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
			int pIndex = quickAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int quickAscending(long[] a, int start, int end)
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
			int pIndex = quickDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int quickDescending(long[] a, int start, int end)
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(float[] a, char c) throws InvalidChoiceException
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
				throw new InvalidChoiceException(c);
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(float[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					throw new InvalidChoiceException(c);
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
			int pIndex = quickAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int quickAscending(float[] a, int start, int end)
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
			int pIndex = quickDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int quickDescending(float[] a, int start, int end)
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(double[] a, char c) throws InvalidChoiceException
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
				throw new InvalidChoiceException(c);
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static void sort(double[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					throw new InvalidChoiceException(c);
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
			int pIndex = quickAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static int quickAscending(double[] a, int start, int end)
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
			int pIndex = quickDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static int quickDescending(double[] a, int start, int end)
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static <T extends Comparable<T>> void sort(T[] a, char c) throws InvalidChoiceException
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
				throw new InvalidChoiceException(c);
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
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public static <T extends Comparable<T>> void sort(T[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					throw new InvalidChoiceException(c);
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
			int pIndex = quickAscending(a, start, end);
			quickSortAscending(a, start, pIndex - 1);
			quickSortAscending(a, pIndex + 1, end);
		}
	}
	private static <T extends Comparable<T>> int quickAscending(T[] a, int start, int end)
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
			int pIndex = quickDescending(a, start, end);
			quickSortDescending(a, start, pIndex - 1);
			quickSortDescending(a, pIndex + 1, end);
		}
	}
	private static <T extends Comparable<T>> int quickDescending(T[] a, int start, int end)
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
