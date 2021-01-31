package dsa.algorithms.sort;

import dsa.datastructures.heap.Heap;

/**
 * This class contains sort methods which are implemented using Heap Sort.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p>The <b>heap sort</b> itself might not be frequently used for sorting a set of items but
 * its underlying data structure, <b>heap</b>, is frequently used for maintaining a particular ordering 
 * when you want to extract either minimum or maximum.</p>
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
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n logn)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 * @see <a href="../../datastructures/heap/Heap.html">Heap</a>
 */
public class HeapSort
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private HeapSort() {}
	
	
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
				Heap<Character> h = new Heap<Character>(a.length, "min");
				for(Character ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				Heap<Character> h = new Heap<Character>(a.length, "max");
				for(Character ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
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
					Heap<Character> h = new Heap<Character>(a.length, "min");
					
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
					}
					
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					Heap<Character> h = new Heap<Character>(a.length, "max");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
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
				Heap<Byte> h = new Heap<Byte>(a.length, "min");
				for(Byte ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				Heap<Byte> h = new Heap<Byte>(a.length, "max");
				for(Byte ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
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
					Heap<Byte> h = new Heap<Byte>(a.length, "min");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					Heap<Byte> h = new Heap<Byte>(a.length, "max");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
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
				Heap<Short> h = new Heap<Short>(a.length, "min");
				for(Short ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				Heap<Short> h = new Heap<Short>(a.length, "max");
				for(Short ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
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
					Heap<Short> h = new Heap<Short>(a.length, "min");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					Heap<Short> h = new Heap<Short>(a.length, "max");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
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
				Heap<Integer> h = new Heap<Integer>(a.length, "min");
				for(Integer ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				Heap<Integer> h = new Heap<Integer>(a.length, "max");
				for(Integer ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
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
					Heap<Integer> h = new Heap<Integer>(a.length, "min");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					Heap<Integer> h = new Heap<Integer>(a.length, "max");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
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
				Heap<Long> h = new Heap<Long>(a.length, "min");
				for(Long ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
				a[i] = h.poll();
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				Heap<Long> h = new Heap<Long>(a.length, "max");
				for(Long ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
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
					Heap<Long> h = new Heap<Long>(a.length, "min");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					Heap<Long> h = new Heap<Long>(a.length, "max");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
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
				Heap<Float> h = new Heap<Float>(a.length, "min");
				for(Float ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				Heap<Float> h = new Heap<Float>(a.length, "max");
				for(Float ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
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
					Heap<Float> h = new Heap<Float>(a.length, "min");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					Heap<Float> h = new Heap<Float>(a.length, "max");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
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
				Heap<Double> h = new Heap<Double>(a.length, "min");
				for(Double ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				Heap<Double> h = new Heap<Double>(a.length, "max");
				for(Double ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
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
					Heap<Double> h = new Heap<Double>(a.length, "min");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					Heap<Double> h = new Heap<Double>(a.length, "max");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
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
				Heap<T> h = new Heap<T>(a.length, "min");
				for(T ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				Heap<T> h = new Heap<T>(a.length, "max");
				for(T ref : a)
				{
					h.add(ref);
				}
				for(int i = 0; i < a.length; i++)
				{
					a[i] = h.poll();
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
					Heap<T> h = new Heap<T>(a.length, "min");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
					}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					Heap<T> h = new Heap<T>(a.length, "max");
					for(int i = fromIndex; i < toIndex; i++)
					{
						h.add(a[i]);
					}
					for(int i = fromIndex; i < toIndex; i++)
					{
						a[i] = h.poll();
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
