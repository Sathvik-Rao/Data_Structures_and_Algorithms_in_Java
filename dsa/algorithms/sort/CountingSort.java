package dsa.algorithms.sort;


/**
 * This class contains sort methods which are implemented using Counting Sort.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p>Counting sort is generally only ever used if <b>k</b> isn’t larger than <b>n</b>; in other words, 
 * if the <b>range of input</b> values isn’t greater than the <b>number of values</b> to be sorted.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time and Space complexity">
 * 	<tr>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Space Complexity</th>
 * 	</tr>
 * 	<tr>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(n + k)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n + k)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n + k)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(k)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 * @see <a href="InvalidChoiceException.html">InvalidChoiceException</a>
 */
public class CountingSort
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private CountingSort() {}
	

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
				char max = Character.MIN_VALUE, min = Character.MAX_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
					if(a[i] < min)
					{
						min = a[i];
					}
				}
				int range = (max - min) + 1; 
				char count[] = new char[range]; 
				char output[] = new char[a.length]; 
				for (i = 0; i < a.length; i++) 
				{ 
					count[a[i] - min]++; 
				} 
				for (i = 1; i < count.length; i++) 
				{ 
					count[i] += count[i - 1]; 
				} 
				for (i = a.length - 1; i > -1; i--) 
				{ 
					output[count[a[i] - min] - 1] = a[i]; 
					count[a[i] - min]--; 
				} 
				for (i = 0; i < a.length; i++) 
				{ 
					a[i] = output[i]; 
				} 
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				char max = Character.MIN_VALUE, min = Character.MAX_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
					if(a[i] < min)
					{
						min = a[i];
					}
				}
				int range = (max - min) + 1; 
				char count[] = new char[range]; 
				char output[] = new char[a.length]; 
				for (i = 0; i < a.length; i++) 
				{ 
					count[a[i] - min]++; 
				} 
				for (i = count.length - 2; i > -1; i--) 
				{ 
					count[i] += count[i + 1]; 
				} 
				for (i = a.length - 1; i > -1; i--) 
				{ 
					output[count[a[i] - min] - 1] = a[i]; 
					count[a[i] - min]--; 
				} 
				for (i = 0; i < a.length; i++) 
				{ 
					a[i] = output[i]; 
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
					char max = Character.MIN_VALUE, min = Character.MAX_VALUE; 
					int i;
					for(i = fromIndex; i < toIndex; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
						if(a[i] < min)
						{
							min = a[i];
						}
					}
					int range = (max - min) + 1; 
					char count[] = new char[range]; 
					char output[] = new char[toIndex - fromIndex]; 
					for (i = fromIndex; i < toIndex; i++) 
					{ 
						count[a[i] - min]++; 
					} 
					for (i = 1; i < count.length; i++) 
					{ 
						count[i] += count[i - 1]; 
					} 
					for (i = toIndex - 1; i >= fromIndex; i--) 
					{ 
						output[count[a[i] - min] - 1] = a[i]; 
						count[a[i] - min]--;
					}			
					int j = 0;
					for (i = fromIndex; i < toIndex; i++, j++) 
					{ 
						a[i] = output[j]; 
					} 
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					char max = Character.MIN_VALUE, min = Character.MAX_VALUE; 
					int i;
					for(i = fromIndex; i < toIndex; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
						if(a[i] < min)
						{
							min = a[i];
						}
					}
					int range = (max - min) + 1; 
					char count[] = new char[range]; 
					char output[] = new char[toIndex - fromIndex]; 
					for (i = fromIndex; i < toIndex; i++) 
					{ 
						count[a[i] - min]++; 
					} 
					for (i = count.length - 2; i > -1; i--) 
					{ 
						count[i] += count[i + 1]; 
					} 
					for (i = toIndex - 1; i >= fromIndex; i--) 
					{ 
						output[count[a[i] - min] - 1] = a[i]; 
						count[a[i] - min]--;
					}			
					int j = 0;
					for (i = fromIndex; i < toIndex; i++, j++) 
					{ 
						a[i] = output[j]; 
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
				byte max = Byte.MIN_VALUE, min = Byte.MAX_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
					if(a[i] < min)
					{
						min = a[i];
					}
				}
				int range = (max - min) + 1; 
				byte count[] = new byte[range]; 
				byte output[] = new byte[a.length]; 
				for (i = 0; i < a.length; i++) 
				{ 
					count[a[i] - min]++; 
				} 
				for (i = 1; i < count.length; i++) 
				{ 
					count[i] += count[i - 1]; 
				} 
				for (i = a.length - 1; i > -1; i--) 
				{ 
					output[count[a[i] - min] - 1] = a[i]; 
					count[a[i] - min]--; 
				} 
				for (i = 0; i < a.length; i++) 
				{ 
					a[i] = output[i]; 
				} 
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				byte max = Byte.MIN_VALUE, min = Byte.MAX_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
					if(a[i] < min)
					{
						min = a[i];
					}
				}
				int range = (max - min) + 1; 
				byte count[] = new byte[range]; 
				byte output[] = new byte[a.length]; 
				for (i = 0; i < a.length; i++) 
				{ 
					count[a[i] - min]++; 
				} 
				for (i = count.length - 2; i > -1; i--) 
				{ 
					count[i] += count[i + 1]; 
				} 
				for (i = a.length - 1; i > -1; i--) 
				{ 
					output[count[a[i] - min] - 1] = a[i]; 
					count[a[i] - min]--; 
				} 
				for (i = 0; i < a.length; i++) 
				{ 
					a[i] = output[i]; 
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
					byte max = Byte.MIN_VALUE, min = Byte.MAX_VALUE; 
					int i;
					for(i = fromIndex; i < toIndex; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
						if(a[i] < min)
						{
							min = a[i];
						}
					}
					int range = (max - min) + 1; 
					byte count[] = new byte[range]; 
					byte output[] = new byte[toIndex - fromIndex]; 
					for (i = fromIndex; i < toIndex; i++) 
					{ 
						count[a[i] - min]++; 
					} 
					for (i = 1; i < count.length; i++) 
					{ 
						count[i] += count[i - 1]; 
					} 
					for (i = toIndex - 1; i >= fromIndex; i--) 
					{ 
						output[count[a[i] - min] - 1] = a[i]; 
						count[a[i] - min]--;
					}			
					int j = 0;
					for (i = fromIndex; i < toIndex; i++, j++) 
					{ 
						a[i] = output[j]; 
					} 
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					byte max = Byte.MIN_VALUE, min = Byte.MAX_VALUE; 
					int i;
					for(i = fromIndex; i < toIndex; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
						if(a[i] < min)
						{
							min = a[i];
						}
					}
					int range = (max - min) + 1; 
					byte count[] = new byte[range]; 
					byte output[] = new byte[toIndex - fromIndex]; 
					for (i = fromIndex; i < toIndex; i++) 
					{ 
						count[a[i] - min]++; 
					} 
					for (i = count.length - 2; i > -1; i--) 
					{ 
						count[i] += count[i + 1]; 
					} 
					for (i = toIndex - 1; i >= fromIndex; i--) 
					{ 
						output[count[a[i] - min] - 1] = a[i]; 
						count[a[i] - min]--;
					}			
					int j = 0;
					for (i = fromIndex; i < toIndex; i++, j++) 
					{ 
						a[i] = output[j]; 
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
				short max = Short.MIN_VALUE, min = Short.MAX_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
					if(a[i] < min)
					{
						min = a[i];
					}
				}
				int range = (max - min) + 1; 
				short count[] = new short[range]; 
				short output[] = new short[a.length]; 
				for (i = 0; i < a.length; i++) 
				{ 
					count[a[i] - min]++; 
				} 
				for (i = 1; i < count.length; i++) 
				{ 
					count[i] += count[i - 1]; 
				} 
				for (i = a.length - 1; i > -1; i--) 
				{ 
					output[count[a[i] - min] - 1] = a[i]; 
					count[a[i] - min]--; 
				} 
				for (i = 0; i < a.length; i++) 
				{ 
					a[i] = output[i]; 
				} 
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				short max = Short.MIN_VALUE, min = Short.MAX_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
					if(a[i] < min)
					{
						min = a[i];
					}
				}
				int range = (max - min) + 1; 
				short count[] = new short[range]; 
				short output[] = new short[a.length]; 
				for (i = 0; i < a.length; i++) 
				{ 
					count[a[i] - min]++; 
				} 
				for (i = count.length - 2; i > -1; i--) 
				{ 
					count[i] += count[i + 1]; 
				} 
				for (i = a.length - 1; i > -1; i--) 
				{ 
					output[count[a[i] - min] - 1] = a[i]; 
					count[a[i] - min]--; 
				} 
				for (i = 0; i < a.length; i++) 
				{ 
					a[i] = output[i]; 
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
					short max = Short.MIN_VALUE, min = Short.MAX_VALUE; 
					int i;
					for(i = fromIndex; i < toIndex; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
						if(a[i] < min)
						{
							min = a[i];
						}
					}
					int range = (max - min) + 1; 
					short count[] = new short[range]; 
					short output[] = new short[toIndex - fromIndex]; 
					for (i = fromIndex; i < toIndex; i++) 
					{ 
						count[a[i] - min]++; 
					} 
					for (i = 1; i < count.length; i++) 
					{ 
						count[i] += count[i - 1]; 
					} 
					for (i = toIndex - 1; i >= fromIndex; i--) 
					{ 
						output[count[a[i] - min] - 1] = a[i]; 
						count[a[i] - min]--;
					}			
					int j = 0;
					for (i = fromIndex; i < toIndex; i++, j++) 
					{ 
						a[i] = output[j]; 
					} 
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					short max = Short.MIN_VALUE, min = Short.MAX_VALUE; 
					int i;
					for(i = fromIndex; i < toIndex; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
						if(a[i] < min)
						{
							min = a[i];
						}
					}
					int range = (max - min) + 1; 
					short count[] = new short[range]; 
					short output[] = new short[toIndex - fromIndex]; 
					for (i = fromIndex; i < toIndex; i++) 
					{ 
						count[a[i] - min]++; 
					} 
					for (i = count.length - 2; i > -1; i--) 
					{ 
						count[i] += count[i + 1]; 
					} 
					for (i = toIndex - 1; i >= fromIndex; i--) 
					{ 
						output[count[a[i] - min] - 1] = a[i]; 
						count[a[i] - min]--;
					}			
					int j = 0;
					for (i = fromIndex; i < toIndex; i++, j++) 
					{ 
						a[i] = output[j]; 
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
	 * Sorts the specified array into ascending/descending order based on the character input. 
	 * If the range(min to max) is greater than array size then {@code OutOfMemoryError} is thrown.
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
				int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
					if(a[i] < min)
					{
						min = a[i];
					}
				}
				int range = (max - min) + 1; 
				int count[] = new int[range]; 
				int output[] = new int[a.length]; 
				for (i = 0; i < a.length; i++) 
				{ 
					count[a[i] - min]++; 
				} 
				for (i = 1; i < count.length; i++) 
				{ 
					count[i] += count[i - 1]; 
				} 
				for (i = a.length - 1; i > -1; i--) 
				{ 
					output[count[a[i] - min] - 1] = a[i]; 
					count[a[i] - min]--; 
				} 
				for (i = 0; i < a.length; i++) 
				{ 
					a[i] = output[i]; 
				} 
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; 
				int i;
				for(i = 0; i < a.length; i++)
				{
					if(a[i] > max)
					{
						max = a[i];
					}
					if(a[i] < min)
					{
						min = a[i];
					}
				}
				int range = (max - min) + 1; 
				int count[] = new int[range]; 
				int output[] = new int[a.length]; 
				for (i = 0; i < a.length; i++) 
				{ 
					count[a[i] - min]++; 
				} 
				for (i = count.length - 2; i > -1; i--) 
				{ 
					count[i] += count[i + 1]; 
				} 
				for (i = a.length - 1; i > -1; i--) 
				{ 
					output[count[a[i] - min] - 1] = a[i]; 
					count[a[i] - min]--; 
				} 
				for (i = 0; i < a.length; i++) 
				{ 
					a[i] = output[i]; 
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
	 * Sorts the specified range of array into ascending/descending order based on the character input. 
	 * If the range(min to max) is greater than array size then {@code OutOfMemoryError} is thrown.
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
					int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; 
					int i;
					for(i = fromIndex; i < toIndex; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
						if(a[i] < min)
						{
							min = a[i];
						}
					}
					int range = (max - min) + 1; 
					int count[] = new int[range]; 
					int output[] = new int[toIndex - fromIndex]; 
					for (i = fromIndex; i < toIndex; i++) 
					{ 
						count[a[i] - min]++; 
					} 
					for (i = 1; i < count.length; i++) 
					{ 
						count[i] += count[i - 1]; 
					} 
					for (i = toIndex - 1; i >= fromIndex; i--) 
					{ 
						output[count[a[i] - min] - 1] = a[i]; 
						count[a[i] - min]--;
					}			
					int j = 0;
					for (i = fromIndex; i < toIndex; i++, j++) 
					{ 
						a[i] = output[j]; 
					} 
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; 
					int i;
					for(i = fromIndex; i < toIndex; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
						}
						if(a[i] < min)
						{
							min = a[i];
						}
					}
					int range = (max - min) + 1; 
					int count[] = new int[range]; 
					int output[] = new int[toIndex - fromIndex]; 
					for (i = fromIndex; i < toIndex; i++) 
					{ 
						count[a[i] - min]++; 
					} 
					for (i = count.length - 2; i > -1; i--) 
					{ 
						count[i] += count[i + 1]; 
					} 
					for (i = toIndex - 1; i >= fromIndex; i--) 
					{ 
						output[count[a[i] - min] - 1] = a[i]; 
						count[a[i] - min]--;
					}			
					int j = 0;
					for (i = fromIndex; i < toIndex; i++, j++) 
					{ 
						a[i] = output[j]; 
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
