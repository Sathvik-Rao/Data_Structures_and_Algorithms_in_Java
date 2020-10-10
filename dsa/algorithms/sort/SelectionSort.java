package dsa.algorithms.sort;


/**
 * This class contains sort methods which are implemented using Selection Sort.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p><b>Selection sort</b> can be good at checking if everything is already <b>sorted</b>. 
 * It is also good to use when memory <b>space</b> is limited and the number of 
 * <b>write</b> operations should be low.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time and Space complexity">
 * 	<tr>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Space Complexity</th>
 * 	</tr>
 * 	<tr>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(n<sup STYLE="font-size:8.0pt">2</sup>)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n<sup STYLE="font-size:8.0pt">2</sup>)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n<sup STYLE="font-size:8.0pt">2</sup>)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(1)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 */
public class SelectionSort
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private SelectionSort() {}
	
	
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
				char temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] < a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				char temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] > a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
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
					char temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] < a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					char temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] > a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
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
				byte temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] < a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				byte temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] > a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
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
					byte temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] < a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					byte temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] > a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
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
				short temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] < a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				short temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] > a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
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
					short temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] < a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					short temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] > a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
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
				int temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] < a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				int temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] > a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
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
					int temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] < a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					int temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] > a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
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
				long temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] < a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				long temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] > a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
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
					long temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] < a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					long temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] > a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
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
				float temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] < a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				float temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] > a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
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
					float temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] < a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					float temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] > a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
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
				double temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] < a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				double temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if(a[j] > a[minLocation])
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
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
					double temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] < a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					double temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if(a[j] > a[minLocation])
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
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
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 * @throws ClassCastException if the array contains elements that are not mutually comparable 
	 *		   (for example, strings and integers)
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
				T temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if((a[j]).compareTo(a[minLocation]) < 0)
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				T temp;
				int	minLocation, j;
				for(int i = 0; i < a.length - 1; i++)
				{
					temp = a[i];
					minLocation = i;
					for(j = i + 1; j < a.length; j++)
					{
						if((a[j]).compareTo(a[minLocation]) > 0)
						{
							minLocation = j;
						}
					}
					a[i] = a[minLocation];
					a[minLocation] = temp;
				}
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
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 * @throws ClassCastException if the array contains elements that are not mutually comparable 
	 *		   (for example, strings and integers)
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
					T temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if((a[j]).compareTo(a[minLocation]) < 0)
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					T temp;
					int	minLocation, j;
					for(int i = fromIndex; i < toIndex - 1; i++)
					{
						temp = a[i];
						minLocation = i;
						for(j = i + 1; j < toIndex; j++)
						{
							if((a[j]).compareTo(a[minLocation]) > 0)
							{
								minLocation = j;
							}
						}
						a[i] = a[minLocation];
						a[minLocation] = temp;
					}
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
}
