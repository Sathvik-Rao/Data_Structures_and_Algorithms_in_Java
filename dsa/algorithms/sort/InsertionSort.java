package dsa.algorithms.sort;


/**
 * This class contains sort methods which are implemented using Insertion Sort.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p><b>Insertion sort</b> is used when number of elements is small.
 * It can also be useful when input array is almost <b>sorted</b>, 
 * only few elements are misplaced in complete big array.
 * It is also good to use when memory <b>space</b> is limited.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time and Space complexity">
 * 	<tr>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Space Complexity</th>
 * 	</tr>
 * 	<tr>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n<sup STYLE="font-size:8.0pt">2</sup>)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n<sup STYLE="font-size:8.0pt">2</sup>)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(1)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 * @see <a href="InvalidChoiceException.html">InvalidChoiceException</a>
 */
public class InsertionSort
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private InsertionSort() {}
	
	
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
				char key;
				int	j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] > key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				char key;
				int	j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] < key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
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
					char key;
					int	j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] > key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					char key;
					int	j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] < key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
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
				byte key;
				int	j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] > key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				byte key;
				int	j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] < key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
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
					byte key;
					int	j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] > key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					byte key;
					int	j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] < key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
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
				short key;
				int	j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] > key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				short key;
				int	j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] < key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
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
					short key;
					int	j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] > key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					short key;
					int	j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] < key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
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
				int key, j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] > key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				int key, j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] < key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
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
					int key, j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] > key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					int key, j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] < key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
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
				long key;
				int j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] > key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				long key;
				int j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] < key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
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
					long key;
					int j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] > key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					long key;
					int j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] < key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
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
				float key;
				int j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] > key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				float key;
				int j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] < key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
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
					float key;
					int j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] > key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					float key;
					int j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] < key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
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
				double key;
				int j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] > key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				double key;
				int j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && a[j] < key)
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
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
					double key;
					int j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] > key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					double key;
					int j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && a[j] < key)
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
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
	
	
	// Generic array
	/**
	 * Sorts the specified array into ascending/descending order, according to the natural ordering of its elements.
	 * All elements in the array must implement the Comparable interface. 
	 * Furthermore, all elements in the array must be mutually comparable (that is, e1.compareTo(e2) 
	 * must not throw a ClassCastException for any elements e1 and e2 in the array).
	 *
	 * @param <T> the type of elements that implements Comparable interface
	 * @param a the array to be sorted
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 *
	 * @throws InvalidChoiceException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 * @throws ClassCastException if the array contains elements that are not mutually comparable 
	 *		   (for example, strings and integers)
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
				T key;
				int j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && ((a[j]).compareTo(key) > 0))
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				T key;
				int j;
				for(int i = 1; i < a.length; i++)
				{
					key = a[i];
					j = i - 1;
					while(j > -1 && ((a[j]).compareTo(key) < 0))
					{
						a[j + 1] = a[j];
						j--;
					}
					a[j + 1] = key;
				}
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
	 * @throws ClassCastException if the array contains elements that are not mutually comparable 
	 *		   (for example, strings and integers)
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
					T key;
					int j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && ((a[j]).compareTo(key) > 0))
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					T key;
					int j;
					for(int i = fromIndex; i < toIndex; i++)
					{
						key = a[i];
						j = i - 1;
						while(j >= fromIndex && ((a[j]).compareTo(key) < 0))
						{
							a[j + 1] = a[j];
							j--;
						}
						a[j + 1] = key;
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
}
