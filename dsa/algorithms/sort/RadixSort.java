package dsa.algorithms.sort;


/**
 * This class contains sort methods which are implemented using Radix Sort.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p>It is <b>preferred</b> over Counting Sort. And <b>k</b> is max number of digits.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time and Space complexity 
 *																				 where k is max no of digits.">
 * 	<tr>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Space Complexity</th>
 * 	</tr>
 * 	<tr>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(nk)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(nk)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(nk)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 */
public class RadixSort
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private RadixSort() {}
	
	
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
				char max = Character.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				char output[] = new char[a.length];
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					char count[] = new char[19];  
					for (i = 0; i < a.length; i++) 
					{ 
						count[((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 1; i < 19; i++) 
					{ 
						count[i] += count[i - 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				char max = Character.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				char output[] = new char[a.length]; 
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					char count[] = new char[19]; 
					for (i = 0; i < a.length; i++) 
					{ 
						count[((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 17; i > -1; i--) 
					{ 
						count[i] += count[i + 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
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
					char max = Character.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					char output[] = new char[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						char count[] = new char[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 1; i < 19; i++) 
						{ 
							count[i] += count[i - 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					char max = Character.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					char output[] = new char[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						char count[] = new char[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 17; i > -1; i--) 
						{ 
							count[i] += count[i + 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
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
				byte max = Byte.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				byte output[] = new byte[a.length]; 
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					byte count[] = new byte[19]; 
					for (i = 0; i < a.length; i++) 
					{ 
						count[((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 1; i < 19; i++) 
					{ 
						count[i] += count[i - 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				byte max = Byte.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				byte output[] = new byte[a.length]; 
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					byte count[] = new byte[19]; 
					for (i = 0; i < a.length; i++) 
					{ 
						count[((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 17; i > -1; i--) 
					{ 
						count[i] += count[i + 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
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
					byte max = Byte.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					byte output[] = new byte[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						byte count[] = new byte[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 1; i < 19; i++) 
						{ 
							count[i] += count[i - 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					byte max = Byte.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					byte output[] = new byte[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						byte count[] = new byte[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 17; i > -1; i--) 
						{ 
							count[i] += count[i + 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
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
				short max = Short.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				short output[] = new short[a.length];
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					short count[] = new short[19]; 
					for (i = 0; i < a.length; i++) 
					{ 
						count[((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 1; i < 19; i++) 
					{ 
						count[i] += count[i - 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				short max = Short.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				short output[] = new short[a.length];
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					short count[] = new short[19]; 
					for (i = 0; i < a.length; i++) 
					{ 
						count[((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 17; i > -1; i--) 
					{ 
						count[i] += count[i + 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
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
					short max = Short.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					short output[] = new short[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						short count[] = new short[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 1; i < 19; i++) 
						{ 
							count[i] += count[i - 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					short max = Short.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					short output[] = new short[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						short count[] = new short[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 17; i > -1; i--) 
						{ 
							count[i] += count[i + 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
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
				int max = Integer.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				int output[] = new int[a.length];
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					int count[] = new int[19]; 
					for (i = 0; i < a.length; i++) 
					{ 
						count[((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 1; i < 19; i++) 
					{ 
						count[i] += count[i - 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				int max = Integer.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				int output[] = new int[a.length]; 
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					int count[] = new int[19]; 
					for (i = 0; i < a.length; i++) 
					{ 
						count[((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 17; i > -1; i--) 
					{ 
						count[i] += count[i + 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
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
					int max = Integer.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					int output[] = new int[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						int count[] = new int[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 1; i < 19; i++) 
						{ 
							count[i] += count[i - 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					int max = Integer.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					int output[] = new int[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						int count[] = new int[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 17; i > -1; i--) 
						{ 
							count[i] += count[i + 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[count[((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
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
				long max = Long.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				long output[] = new long[a.length]; 
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					long count[] = new long[19]; 
					for (i = 0; i < a.length; i++) 
					{ 
						count[(int)((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 1; i < 19; i++) 
					{ 
						count[i] += count[i - 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[(int)count[(int)((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[(int)((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				long max = Long.MIN_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
				}
				long output[] = new long[a.length]; 
				for (int exp = 1; max / exp > 0; exp *= 10)
				{
					long count[] = new long[19]; 
					for (i = 0; i < a.length; i++) 
					{ 
						count[(int)((a[i] / exp) % 10) + 9]++; 
					} 
					for (i = 17; i > -1; i--) 
					{ 
						count[i] += count[i + 1]; 
					} 
					for (i = a.length - 1; i > -1; i--) 
					{ 
						output[(int)count[(int)((a[i] / exp) % 10) + 9] - 1] = a[i]; 
						count[(int)((a[i] / exp) % 10) + 9]--; 
					} 
					for (i = 0; i < a.length; i++) 
					{ 
						a[i] = output[i]; 
					}
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
					long max = Long.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					long output[] = new long[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						long count[] = new long[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[(int)((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 1; i < 19; i++) 
						{ 
							count[i] += count[i - 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[(int)count[(int)((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[(int)((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					long max = Long.MIN_VALUE; 
					int i;
					for(i = 0; i < a.length; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
					}
					long output[] = new long[toIndex - fromIndex]; 
					for (int exp = 1; max / exp > 0; exp *= 10)
					{
						long count[] = new long[19]; 
						for (i = fromIndex; i < toIndex; i++) 
						{ 
							count[(int)((a[i] / exp) % 10) + 9]++; 
						} 
						for (i = 17; i > -1; i--) 
						{ 
							count[i] += count[i + 1]; 
						} 
						for (i = toIndex - 1; i >= fromIndex; i--) 
						{ 
							output[(int)count[(int)((a[i] / exp) % 10) + 9] - 1] = a[i]; 
							count[(int)((a[i] / exp) % 10) + 9]--; 
						} 
						int j = 0;
						for (i = fromIndex; i < toIndex; i++, j++) 
						{ 
							a[i] = output[j]; 
						}
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
