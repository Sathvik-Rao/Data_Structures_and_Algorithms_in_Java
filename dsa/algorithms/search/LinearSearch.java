package dsa.algorithms.search;


/**
 * This class contains search methods which are implemented using Linear Search.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p>It is used when the array has only a few elements, or when performing a 
 * single search in an un-ordered array.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time and Space complexity">
 * 	<tr>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Space Complexity</th>
 * 	</tr>
 * 	<tr>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n/2)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(1)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 */
public class LinearSearch
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private LinearSearch() {}
	
	
	// char array
	/**
	 * Searches the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 */
	public static int search(char[] a, char key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		return search(a, 0, a.length, key);
	}
	
	/**
	 * Searches a range of the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param fromIndex the index of the first element (inclusive) to be searched
	 * @param toIndex the index of the last element (exclusive) to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 */
	public static int search(char[] a, int fromIndex, int toIndex, char key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				for(int i = fromIndex; i < toIndex; i++)
				{
					if(a[i] == key)
					{
						return i;
					}
				}
				return -1;
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
	 * Searches the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 */
	public static int search(byte[] a, byte key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		return search(a, 0, a.length, key);
	}
	
	/**
	 * Searches a range of the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param fromIndex the index of the first element (inclusive) to be searched
	 * @param toIndex the index of the last element (exclusive) to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 */
	public static int search(byte[] a, int fromIndex, int toIndex, byte key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				for(int i = fromIndex; i < toIndex; i++)
				{
					if(a[i] == key)
					{
						return i;
					}
				}
				return -1;
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
	 * Searches the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 */
	public static int search(short[] a, short key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		return search(a, 0, a.length, key);
	}
	
	/**
	 * Searches a range of the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param fromIndex the index of the first element (inclusive) to be searched
	 * @param toIndex the index of the last element (exclusive) to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 */
	public static int search(short[] a, int fromIndex, int toIndex, short key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				for(int i = fromIndex; i < toIndex; i++)
				{
					if(a[i] == key)
					{
						return i;
					}
				}
				return -1;
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
	 * Searches the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 */
	public static int search(int[] a, int key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		return search(a, 0, a.length, key);
	}
	
	/**
	 * Searches a range of the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param fromIndex the index of the first element (inclusive) to be searched
	 * @param toIndex the index of the last element (exclusive) to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 */
	public static int search(int[] a, int fromIndex, int toIndex, int key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				for(int i = fromIndex; i < toIndex; i++)
				{
					if(a[i] == key)
					{
						return i;
					}
				}
				return -1;
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
	 * Searches the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 */
	public static int search(long[] a, long key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		return search(a, 0, a.length, key);
	}
	
	/**
	 * Searches a range of the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param fromIndex the index of the first element (inclusive) to be searched
	 * @param toIndex the index of the last element (exclusive) to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 */
	public static int search(long[] a, int fromIndex, int toIndex, long key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				for(int i = fromIndex; i < toIndex; i++)
				{
					if(a[i] == key)
					{
						return i;
					}
				}
				return -1;
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
	 * Searches the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 */
	public static int search(float[] a, float key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		return search(a, 0, a.length, key);
	}
	
	/**
	 * Searches a range of the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param fromIndex the index of the first element (inclusive) to be searched
	 * @param toIndex the index of the last element (exclusive) to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 */
	public static int search(float[] a, int fromIndex, int toIndex, float key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				for(int i = fromIndex; i < toIndex; i++)
				{
					if(a[i] == key)
					{
						return i;
					}
				}
				return -1;
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
	 * Searches the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 */
	public static int search(double[] a, double key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		return search(a, 0, a.length, key);
	}
	
	/**
	 * Searches a range of the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param fromIndex the index of the first element (inclusive) to be searched
	 * @param toIndex the index of the last element (exclusive) to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 */
	public static int search(double[] a, int fromIndex, int toIndex, double key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				for(int i = fromIndex; i < toIndex; i++)
				{
					if(a[i] == key)
					{
						return i;
					}
				}
				return -1;
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
	
	
	// Object array
	/**
	 * Searches the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 */
	public static int search(Object[] a, Object key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		return search(a, 0, a.length, key);
	}
	
	/**
	 * Searches a range of the specified array for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, then first element is considered.
	 *
	 * @param a the array to be searched
	 * @param fromIndex the index of the first element (inclusive) to be searched
	 * @param toIndex the index of the last element (exclusive) to be searched
	 * @param key the value to be searched for
	 * @return index of the search key, if it is contained in the array; otherwise, <tt>-1</tt>.
	 *         Note that this guarantees that the return value will be &gt;= 0 if and only if the key is found.
	 *
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > a.length)}
	 */
	public static int search(Object[] a, int fromIndex, int toIndex, Object key) 
	{
		if(a == null)
		{
			throw new NullPointerException();
		}
		
		if(fromIndex > -1 && toIndex <= a.length)
		{
			if(fromIndex <= toIndex)
			{	
				for(int i = fromIndex; i < toIndex; i++)
				{
					if(a[i].equals(key))
					{
						return i;
					}
				}
				return -1;
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
