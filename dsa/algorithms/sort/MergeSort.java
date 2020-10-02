package dsa.algorithms.sort;


/**
 * This class contains sort methods which are implemented using Merge Sort.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p><b>Mergesort</b> is used when we want a guaranteed running time of <b>O(n logn)</b></p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time and Space complexity">
 * 	<tr>
 * 		<th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 		<th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 		<th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 		<th style = "border: 1px solid black; padding: 15px;">Space Complexity</th>
 * 	</tr>
 * 	<tr>
 * 		<td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n logn)</td>
 * 		<td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n logn)</td>
 * 		<td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n logn)</td>
 * 		<td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 * @see <a href="InvalidChoiceException.html">InvalidChoiceException</a>
 */
public class MergeSort
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private MergeSort() {}
	
	
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
				mergeSortAscending(a);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				mergeSortDescending(a);
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
					char[] temp = new char[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortAscending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					char[] temp = new char[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortDescending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
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
	private static void mergeSortAscending(char[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			char[] left = new char[(a.length + 1)/2];
			char[] right = new char[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortAscending(left);
			mergeSortAscending(right);
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(char[] a,char[] l, char[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] <= r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
	
	// char array Descending order
	private static void mergeSortDescending(char[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			char[] left = new char[(a.length + 1)/2];
			char[] right = new char[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortDescending(left);
			mergeSortDescending(right);
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(char[] a,char[] l, char[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] > r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
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
				mergeSortAscending(a);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				mergeSortDescending(a);
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
					byte[] temp = new byte[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortAscending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					byte[] temp = new byte[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortDescending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
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
	private static void mergeSortAscending(byte[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			byte[] left = new byte[(a.length + 1)/2];
			byte[] right = new byte[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortAscending(left);
			mergeSortAscending(right);
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(byte[] a,byte[] l, byte[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] <= r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
	
	// byte array Descending order
	private static void mergeSortDescending(byte[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			byte[] left = new byte[(a.length + 1)/2];
			byte[] right = new byte[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortDescending(left);
			mergeSortDescending(right);
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(byte[] a,byte[] l, byte[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] > r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
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
				mergeSortAscending(a);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				mergeSortDescending(a);
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
					short[] temp = new short[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortAscending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					short[] temp = new short[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortDescending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
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
	private static void mergeSortAscending(short[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			short[] left = new short[(a.length + 1)/2];
			short[] right = new short[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortAscending(left);
			mergeSortAscending(right);
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(short[] a,short[] l, short[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] <= r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
	
	// short array Descending order
	private static void mergeSortDescending(short[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			short[] left = new short[(a.length + 1)/2];
			short[] right = new short[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortDescending(left);
			mergeSortDescending(right);
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(short[] a,short[] l, short[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] > r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
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
				mergeSortAscending(a);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				mergeSortDescending(a);
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
					int[] temp = new int[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortAscending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					int[] temp = new int[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortDescending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
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
	private static void mergeSortAscending(int[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			int[] left = new int[(a.length + 1)/2];
			int[] right = new int[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortAscending(left);
			mergeSortAscending(right);
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(int[] a,int[] l, int[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] <= r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
	
	// int array Descending order
	private static void mergeSortDescending(int[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			int[] left = new int[(a.length + 1)/2];
			int[] right = new int[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortDescending(left);
			mergeSortDescending(right);
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(int[] a,int[] l, int[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] > r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
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
				mergeSortAscending(a);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				mergeSortDescending(a);
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
					long[] temp = new long[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortAscending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					long[] temp = new long[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortDescending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
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
	private static void mergeSortAscending(long[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			long[] left = new long[(a.length + 1)/2];
			long[] right = new long[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortAscending(left);
			mergeSortAscending(right);
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(long[] a,long[] l, long[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] <= r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
	
	// long array Descending order
	private static void mergeSortDescending(long[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			long[] left = new long[(a.length + 1)/2];
			long[] right = new long[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortDescending(left);
			mergeSortDescending(right);
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(long[] a,long[] l, long[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] > r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
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
				mergeSortAscending(a);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				mergeSortDescending(a);
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
					float[] temp = new float[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortAscending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					float[] temp = new float[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortDescending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
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
	private static void mergeSortAscending(float[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			float[] left = new float[(a.length + 1)/2];
			float[] right = new float[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortAscending(left);
			mergeSortAscending(right);
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(float[] a,float[] l, float[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] <= r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
	
	// float array Descending order
	private static void mergeSortDescending(float[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			float[] left = new float[(a.length + 1)/2];
			float[] right = new float[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortDescending(left);
			mergeSortDescending(right);
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(float[] a,float[] l, float[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] > r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
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
				mergeSortAscending(a);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				mergeSortDescending(a);
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
					double[] temp = new double[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortAscending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					double[] temp = new double[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortDescending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
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
	private static void mergeSortAscending(double[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			double[] left = new double[(a.length + 1)/2];
			double[] right = new double[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortAscending(left);
			mergeSortAscending(right);
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(double[] a,double[] l, double[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] <= r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
	
	// double array Descending order
	private static void mergeSortDescending(double[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			double[] left = new double[(a.length + 1)/2];
			double[] right = new double[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortDescending(left);
			mergeSortDescending(right);
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(double[] a,double[] l, double[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(l[i] > r[j])
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
	
	
	// Object array
	/**
	 * Sorts the specified array into ascending/descending order, according to the natural ordering of its elements.
	 * All elements in the array must implement the Comparable interface. 
	 * Furthermore, all elements in the array must be mutually comparable (that is, e1.compareTo(e2) 
	 * must not throw a ClassCastException for any elements e1 and e2 in the array).
	 *
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 * @throws ClassCastException if the array contains elements that are not mutually comparable 
	 *		   (for example, strings and integers)
	 */
	public static void sort(Object[] a, char c) throws InvalidChoiceException
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
				mergeSortAscending(a);
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				mergeSortDescending(a);
			}
			
			// Invalid Character
			else
			{
				throw new InvalidChoiceException(c);
			}
		}
	}
	
	/**
	 * Sorts the specified array into ascending/descending order, according to the natural ordering of its elements.
	 * The range to be sorted extends from index fromIndex, inclusive, to index toIndex, exclusive. 
	 * (If fromIndex==toIndex, the range to be sorted is empty.) All elements in this range must 
	 * implement the Comparable interface. Furthermore, all elements in this range must be mutually 
	 * comparable (that is, e1.compareTo(e2) must not throw a ClassCastException for any elements e1 and e2 in the array).
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
	 * @throws ClassCastException if the array contains elements that are not mutually comparable 
	 *		   (for example, strings and integers)
	 */
	public static void sort(Object[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					Object[] temp = new Object[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortAscending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					Object[] temp = new Object[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					mergeSortDescending(temp);
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
					}
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
	
	// Object array Ascending order
	private static void mergeSortAscending(Object[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			Object[] left = new Object[(a.length + 1)/2];
			Object[] right = new Object[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortAscending(left);
			mergeSortAscending(right);
			mergeAscending(a, left, right);
		}
	}
	@SuppressWarnings({"unchecked", "rawtypes"})
	private static void mergeAscending(Object[] a,Object[] l, Object[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(((Comparable) l[i]).compareTo(r[j]) < 1) 
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
	
	// Object array Descending order
	private static void mergeSortDescending(Object[] a)
	{
		if(a.length > 1)
		{
			int mid = (a.length - 1) / 2;
			Object[] left = new Object[(a.length + 1)/2];
			Object[] right = new Object[a.length/2];
			int i = 0;
			for( ; i <= mid; i++)
			{
				left[i] = a[i];
			}
			for(int j = 0; i < a.length; )
			{
				right[j++] = a[i++];
			}
			mergeSortDescending(left);
			mergeSortDescending(right);
			mergeDescending(a, left, right);
		}
	}
	@SuppressWarnings({"unchecked", "rawtypes"})
	private static void mergeDescending(Object[] a,Object[] l, Object[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(((Comparable) l[i]).compareTo(r[j]) > 0) 
			{
				a[k++] = l[i++];
			}
			else
			{
				a[k++] = r[j++];
			}
		}
		while(i < l.length)
		{
			a[k++] = l[i++];
		}
		while(j < r.length)
		{
			a[k++] = r[j++];
		}
	}
}
