package dsa.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections; 
/**
 * This class contains sort methods which are implemented using Bucket Sort for decimal numbers 
 * ranging from (-1.0,1.0).
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p><b>Bucket sort</b> is mainly useful when input is uniformly distributed over a range.
 * Where <b>k</b> is the no of buckets.</p>
 * 
 * <p><b>It accepts values out of range(-1.0,1.0), but the result is ambiguous</b>.</p>
 *
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time and Space complexity
 *																				 where k is no of buckets.">
 * 	<tr>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Space Complexity</th>
 * 	</tr>
 * 	<tr>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(n + k)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n + k)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n<sup STYLE="font-size:8.0pt">2</sup>)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(nk)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 * @see <a href="InvalidChoiceException.html">InvalidChoiceException</a>
 */
public class BucketSort
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private BucketSort() {}
	

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
				@SuppressWarnings("unchecked") 
				ArrayList<Float>[] buckets = new ArrayList[18];
				byte[] ref = {-1,7,6,5,4,3,2,1,0};
				for (int i = 0; i < 18; i++) 
				{ 
					buckets[i] = new ArrayList<Float>(0); 
				} 
				for (int i = 0; i < a.length; i++) 
				{ 
					int loc = String.valueOf(a[i]).charAt(2) - 40;
					if(loc != 6)
					{
						buckets[loc].add(a[i]);
					}
					else
					{	
						buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
					}
				} 
				for (int i = 0; i < 18; i++) 
				{ 
					Collections.sort(buckets[i]); 
				} 
				int index = 0; 
				for (int i = 0; i < 18; i++)
				{ 
					for (int j = 0; j < buckets[i].size(); j++) 
					{ 
						a[index++] = buckets[i].get(j); 
					} 
				} 
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				@SuppressWarnings("unchecked") 
				ArrayList<Float>[] buckets = new ArrayList[18];
				byte[] ref = {-1,7,6,5,4,3,2,1,0};
				for (int i = 0; i < 18; i++) 
				{ 
					buckets[i] = new ArrayList<Float>(0); 
				} 
				for (int i = 0; i < a.length; i++) 
				{ 
					int loc = String.valueOf(a[i]).charAt(2) - 40;
					if(loc != 6)
					{
						buckets[loc].add(a[i]);
					}
					else
					{	
						buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
					}
				} 
				for (int i = 0; i < 18; i++) 
				{ 
					Collections.sort(buckets[i], Collections.reverseOrder()); 
				} 
				int index = 0; 
				for (int i = 17; i > -1; i--)
				{ 
					for (int j = 0; j < buckets[i].size(); j++) 
					{ 
						a[index++] = buckets[i].get(j); 
					} 
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
					@SuppressWarnings("unchecked") 
					ArrayList<Float>[] buckets = new ArrayList[18];
					byte[] ref = {-1,7,6,5,4,3,2,1,0};
					for (int i = 0; i < 18; i++) 
					{ 
						buckets[i] = new ArrayList<Float>(0); 
					} 
					for (int i = fromIndex; i < toIndex; i++) 
					{ 
						int loc = String.valueOf(a[i]).charAt(2) - 40;
						if(loc != 6)
						{
							buckets[loc].add(a[i]);
						}
						else
						{	
							buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
						}
					}
					for (int i = 0; i < 18; i++) 
					{ 
						Collections.sort(buckets[i]); 
					} 
					int index = fromIndex; 
					for (int i = 0; i < 18; i++)
					{ 
						for (int j = 0; j < buckets[i].size(); j++) 
						{
							a[index++] = buckets[i].get(j); 
						} 
					} 
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					@SuppressWarnings("unchecked") 
					ArrayList<Float>[] buckets = new ArrayList[18];
					byte[] ref = {-1,7,6,5,4,3,2,1,0};
					for (int i = 0; i < 18; i++) 
					{ 
						buckets[i] = new ArrayList<Float>(0); 
					} 
					for (int i = fromIndex; i < toIndex; i++) 
					{ 
						int loc = String.valueOf(a[i]).charAt(2) - 40;
						if(loc != 6)
						{
							buckets[loc].add(a[i]);
						}
						else
						{	
							buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
						}
					} 
					for (int i = 0; i < 18; i++) 
					{ 
						Collections.sort(buckets[i], Collections.reverseOrder()); 
					} 
					int index = fromIndex; 
					for (int i = 17; i > -1; i--)
					{ 
						for (int j = 0; j < buckets[i].size(); j++) 
						{ 
							a[index++] = buckets[i].get(j); 
						} 
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
				@SuppressWarnings("unchecked") 
				ArrayList<Double>[] buckets = new ArrayList[18];
				byte[] ref = {-1,7,6,5,4,3,2,1,0};
				for (int i = 0; i < 18; i++) 
				{ 
					buckets[i] = new ArrayList<Double>(0); 
				} 
				for (int i = 0; i < a.length; i++) 
				{ 
					int loc = String.valueOf(a[i]).charAt(2) - 40;
					if(loc != 6)
					{
						buckets[loc].add(a[i]);
					}
					else
					{	
						buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
					}
				} 
				for (int i = 0; i < 18; i++) 
				{ 
					Collections.sort(buckets[i]); 
				} 
				int index = 0; 
				for (int i = 0; i < 18; i++)
				{ 
					for (int j = 0; j < buckets[i].size(); j++) 
					{ 
						a[index++] = buckets[i].get(j); 
					} 
				} 
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				@SuppressWarnings("unchecked") 
				ArrayList<Double>[] buckets = new ArrayList[18];
				byte[] ref = {-1,7,6,5,4,3,2,1,0};
				for (int i = 0; i < 18; i++) 
				{ 
					buckets[i] = new ArrayList<Double>(0); 
				} 
				for (int i = 0; i < a.length; i++) 
				{ 
					int loc = String.valueOf(a[i]).charAt(2) - 40;
					if(loc != 6)
					{
						buckets[loc].add(a[i]);
					}
					else
					{	
						buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
					}
				} 
				for (int i = 0; i < 18; i++) 
				{ 
					Collections.sort(buckets[i], Collections.reverseOrder()); 
				} 
				int index = 0; 
				for (int i = 17; i > -1; i--)
				{ 
					for (int j = 0; j < buckets[i].size(); j++) 
					{ 
						a[index++] = buckets[i].get(j); 
					} 
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
					@SuppressWarnings("unchecked") 
					ArrayList<Double>[] buckets = new ArrayList[18];
					byte[] ref = {-1,7,6,5,4,3,2,1,0};
					for (int i = 0; i < 18; i++) 
					{ 
						buckets[i] = new ArrayList<Double>(0); 
					} 
					for (int i = fromIndex; i < toIndex; i++) 
					{ 
						int loc = String.valueOf(a[i]).charAt(2) - 40;
						if(loc != 6)
						{
							buckets[loc].add(a[i]);
						}
						else
						{	
							buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
						}
					}
					for (int i = 0; i < 18; i++) 
					{ 
						Collections.sort(buckets[i]); 
					} 
					int index = fromIndex; 
					for (int i = 0; i < 18; i++)
					{ 
						for (int j = 0; j < buckets[i].size(); j++) 
						{
							a[index++] = buckets[i].get(j); 
						} 
					} 
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					@SuppressWarnings("unchecked") 
					ArrayList<Double>[] buckets = new ArrayList[18];
					byte[] ref = {-1,7,6,5,4,3,2,1,0};
					for (int i = 0; i < 18; i++) 
					{ 
						buckets[i] = new ArrayList<Double>(0); 
					} 
					for (int i = fromIndex; i < toIndex; i++) 
					{ 
						int loc = String.valueOf(a[i]).charAt(2) - 40;
						if(loc != 6)
						{
							buckets[loc].add(a[i]);
						}
						else
						{	
							buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
						}
					} 
					for (int i = 0; i < 18; i++) 
					{ 
						Collections.sort(buckets[i], Collections.reverseOrder()); 
					} 
					int index = fromIndex; 
					for (int i = 17; i > -1; i--)
					{ 
						for (int j = 0; j < buckets[i].size(); j++) 
						{ 
							a[index++] = buckets[i].get(j); 
						} 
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
	
	
	// Float array
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
	public static void sort(Float[] a, char c) throws InvalidChoiceException
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
				@SuppressWarnings("unchecked") 
				ArrayList<Float>[] buckets = new ArrayList[18];
				byte[] ref = {-1,7,6,5,4,3,2,1,0};
				for (int i = 0; i < 18; i++) 
				{ 
					buckets[i] = new ArrayList<Float>(0); 
				} 
				for (int i = 0; i < a.length; i++) 
				{ 
					int loc = String.valueOf(a[i]).charAt(2) - 40;
					if(loc != 6)
					{
						buckets[loc].add(a[i]);
					}
					else
					{	
						buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
					}
				} 
				for (int i = 0; i < 18; i++) 
				{ 
					Collections.sort(buckets[i]); 
				} 
				int index = 0; 
				for (int i = 0; i < 18; i++)
				{ 
					for (int j = 0; j < buckets[i].size(); j++) 
					{ 
						a[index++] = buckets[i].get(j); 
					} 
				} 
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				@SuppressWarnings("unchecked") 
				ArrayList<Float>[] buckets = new ArrayList[18];
				byte[] ref = {-1,7,6,5,4,3,2,1,0};
				for (int i = 0; i < 18; i++) 
				{ 
					buckets[i] = new ArrayList<Float>(0); 
				} 
				for (int i = 0; i < a.length; i++) 
				{ 
					int loc = String.valueOf(a[i]).charAt(2) - 40;
					if(loc != 6)
					{
						buckets[loc].add(a[i]);
					}
					else
					{	
						buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
					}
				} 
				for (int i = 0; i < 18; i++) 
				{ 
					Collections.sort(buckets[i], Collections.reverseOrder()); 
				} 
				int index = 0; 
				for (int i = 17; i > -1; i--)
				{ 
					for (int j = 0; j < buckets[i].size(); j++) 
					{ 
						a[index++] = buckets[i].get(j); 
					} 
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
	public static void sort(Float[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					@SuppressWarnings("unchecked") 
					ArrayList<Float>[] buckets = new ArrayList[18];
					byte[] ref = {-1,7,6,5,4,3,2,1,0};
					for (int i = 0; i < 18; i++) 
					{ 
						buckets[i] = new ArrayList<Float>(0); 
					} 
					for (int i = fromIndex; i < toIndex; i++) 
					{ 
						int loc = String.valueOf(a[i]).charAt(2) - 40;
						if(loc != 6)
						{
							buckets[loc].add(a[i]);
						}
						else
						{	
							buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
						}
					}
					for (int i = 0; i < 18; i++) 
					{ 
						Collections.sort(buckets[i]); 
					} 
					int index = fromIndex; 
					for (int i = 0; i < 18; i++)
					{ 
						for (int j = 0; j < buckets[i].size(); j++) 
						{
							a[index++] = buckets[i].get(j); 
						} 
					} 
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					@SuppressWarnings("unchecked") 
					ArrayList<Float>[] buckets = new ArrayList[18];
					byte[] ref = {-1,7,6,5,4,3,2,1,0};
					for (int i = 0; i < 18; i++) 
					{ 
						buckets[i] = new ArrayList<Float>(0); 
					} 
					for (int i = fromIndex; i < toIndex; i++) 
					{ 
						int loc = String.valueOf(a[i]).charAt(2) - 40;
						if(loc != 6)
						{
							buckets[loc].add(a[i]);
						}
						else
						{	
							buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
						}
					} 
					for (int i = 0; i < 18; i++) 
					{ 
						Collections.sort(buckets[i], Collections.reverseOrder()); 
					} 
					int index = fromIndex; 
					for (int i = 17; i > -1; i--)
					{ 
						for (int j = 0; j < buckets[i].size(); j++) 
						{ 
							a[index++] = buckets[i].get(j); 
						} 
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
	
	
	// Double array
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
	public static void sort(Double[] a, char c) throws InvalidChoiceException
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
				@SuppressWarnings("unchecked") 
				ArrayList<Double>[] buckets = new ArrayList[18];
				byte[] ref = {-1,7,6,5,4,3,2,1,0};
				for (int i = 0; i < 18; i++) 
				{ 
					buckets[i] = new ArrayList<Double>(0); 
				} 
				for (int i = 0; i < a.length; i++) 
				{ 
					int loc = String.valueOf(a[i]).charAt(2) - 40;
					if(loc != 6)
					{
						buckets[loc].add(a[i]);
					}
					else
					{	
						buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
					}
				} 
				for (int i = 0; i < 18; i++) 
				{ 
					Collections.sort(buckets[i]); 
				} 
				int index = 0; 
				for (int i = 0; i < 18; i++)
				{ 
					for (int j = 0; j < buckets[i].size(); j++) 
					{ 
						a[index++] = buckets[i].get(j); 
					} 
				} 
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				@SuppressWarnings("unchecked") 
				ArrayList<Double>[] buckets = new ArrayList[18];
				byte[] ref = {-1,7,6,5,4,3,2,1,0};
				for (int i = 0; i < 18; i++) 
				{ 
					buckets[i] = new ArrayList<Double>(0); 
				} 
				for (int i = 0; i < a.length; i++) 
				{ 
					int loc = String.valueOf(a[i]).charAt(2) - 40;
					if(loc != 6)
					{
						buckets[loc].add(a[i]);
					}
					else
					{	
						buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
					}
				} 
				for (int i = 0; i < 18; i++) 
				{ 
					Collections.sort(buckets[i], Collections.reverseOrder()); 
				} 
				int index = 0; 
				for (int i = 17; i > -1; i--)
				{ 
					for (int j = 0; j < buckets[i].size(); j++) 
					{ 
						a[index++] = buckets[i].get(j); 
					} 
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
	public static void sort(Double[] a, int fromIndex, int toIndex, char c) throws InvalidChoiceException
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
					@SuppressWarnings("unchecked") 
					ArrayList<Double>[] buckets = new ArrayList[18];
					byte[] ref = {-1,7,6,5,4,3,2,1,0};
					for (int i = 0; i < 18; i++) 
					{ 
						buckets[i] = new ArrayList<Double>(0); 
					} 
					for (int i = fromIndex; i < toIndex; i++) 
					{ 
						int loc = String.valueOf(a[i]).charAt(2) - 40;
						if(loc != 6)
						{
							buckets[loc].add(a[i]);
						}
						else
						{	
							buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
						}
					}
					for (int i = 0; i < 18; i++) 
					{ 
						Collections.sort(buckets[i]); 
					} 
					int index = fromIndex; 
					for (int i = 0; i < 18; i++)
					{ 
						for (int j = 0; j < buckets[i].size(); j++) 
						{
							a[index++] = buckets[i].get(j); 
						} 
					} 
				}
				
				// Descending Order
				else if(c == 'd' || c == 'D')
				{
					@SuppressWarnings("unchecked") 
					ArrayList<Double>[] buckets = new ArrayList[18];
					byte[] ref = {-1,7,6,5,4,3,2,1,0};
					for (int i = 0; i < 18; i++) 
					{ 
						buckets[i] = new ArrayList<Double>(0); 
					} 
					for (int i = fromIndex; i < toIndex; i++) 
					{ 
						int loc = String.valueOf(a[i]).charAt(2) - 40;
						if(loc != 6)
						{
							buckets[loc].add(a[i]);
						}
						else
						{	
							buckets[ref[String.valueOf(a[i]).charAt(3) - 48]].add(a[i]);
						}
					} 
					for (int i = 0; i < 18; i++) 
					{ 
						Collections.sort(buckets[i], Collections.reverseOrder()); 
					} 
					int index = fromIndex; 
					for (int i = 17; i > -1; i--)
					{ 
						for (int j = 0; j < buckets[i].size(); j++) 
						{ 
							a[index++] = buckets[i].get(j); 
						} 
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
