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
 * @see <a href="InvalidChoiceException.html">InvalidChoiceException</a>
 * @see <a href="../../../dsa/datastructures/heap/Heap.html">Heap</a>
 */
public class HeapSort
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private HeapSort() {}
	
	
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
				try 
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
				catch(dsa.datastructures.heap.InvalidChoiceException e) {}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				try 
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
				catch(dsa.datastructures.heap.InvalidChoiceException e) {}
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
	public static <T extends Comparable<T>> void sort(T[] a, int fromIndex, int toIndex, char c) 
																				throws InvalidChoiceException
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
					try 
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
					catch(dsa.datastructures.heap.InvalidChoiceException e) {}
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					try 
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
					catch(dsa.datastructures.heap.InvalidChoiceException e) {}
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