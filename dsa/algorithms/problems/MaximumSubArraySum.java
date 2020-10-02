package dsa.algorithms.problems;


/**
 * <p>This class contains sum methods which are implemented using Kadane's algorithm.</p>
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
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(1)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 */
public class MaximumSubArraySum
{	
	// Suppresses default constructor, ensuring non-instantiability.
    private MaximumSubArraySum() {}
	
	
	// char
	/**
	 * Finds the maximum sum of a contiguous subarray, within a given one-dimensional array.
	 *
	 * @param a input array
	 * @throws IllegalArgumentException when array is empty
	 * @return maximum sum of a contiguous subarray
	 */
	public static long sum(char[] a) 
	{
		if(a.length == 0)
		{
			throw new IllegalArgumentException("empty array");
		}
		
		long max = Character.MIN_VALUE, sum = 0;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] + sum > 0)
			{	
				sum += a[i];
			}
			else
			{
				sum = 0;
			}
			
			if(max < sum)
			{
				max = sum;
			}
		}
		return max;
	}
	
	
	// byte
	/**
	 * Finds the maximum sum of a contiguous subarray, within a given one-dimensional array.
	 *
	 * @param a input array
	 * @throws IllegalArgumentException when array is empty
	 * @return maximum sum of a contiguous subarray
	 */
	public static long sum(byte[] a) 
	{
		if(a.length == 0)
		{
			throw new IllegalArgumentException("empty array");
		}
		
		long max = Byte.MIN_VALUE, sum = 0;
		boolean positive = false;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > -1)
			{	
				positive = true;
				break;
			}
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		if(positive)
		{
			max = sum = 0;
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] + sum > 0)
				{	
					sum += a[i];
				}
				else
				{
					sum = 0;
				}
				
				if(max < sum)
				{
					max = sum;
				}
			}
		}
		return max;
	}
	
	
	// short
	/**
	 * Finds the maximum sum of a contiguous subarray, within a given one-dimensional array.
	 *
	 * @param a input array
	 * @throws IllegalArgumentException when array is empty
	 * @return maximum sum of a contiguous subarray
	 */
	public static long sum(short[] a) 
	{
		if(a.length == 0)
		{
			throw new IllegalArgumentException("empty array");
		}
		
		long max = Short.MIN_VALUE, sum = 0;
		boolean positive = false;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > -1)
			{	
				positive = true;
				break;
			}
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		if(positive)
		{
			max = sum = 0;
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] + sum > 0)
				{	
					sum += a[i];
				}
				else
				{
					sum = 0;
				}
				
				if(max < sum)
				{
					max = sum;
				}
			}
		}
		return max;
	}
	
	
	// int
	/**
	 * Finds the maximum sum of a contiguous subarray, within a given one-dimensional array.
	 *
	 * @param a input array
	 * @throws IllegalArgumentException when array is empty
	 * @return maximum sum of a contiguous subarray
	 */
	public static long sum(int[] a) 
	{
		if(a.length == 0)
		{
			throw new IllegalArgumentException("empty array");
		}
		
		long max = Integer.MIN_VALUE, sum = 0;
		boolean positive = false;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > -1)
			{	
				positive = true;
				break;
			}
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		if(positive)
		{
			max = sum = 0;
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] + sum > 0)
				{	
					sum += a[i];
				}
				else
				{
					sum = 0;
				}
				
				if(max < sum)
				{
					max = sum;
				}
			}
		}
		return max;
	}
	
	
	// long
	/**
	 * Finds the maximum sum of a contiguous subarray, within a given one-dimensional array.
	 *
	 * @param a input array
	 * @throws IllegalArgumentException when array is empty
	 * @return maximum sum of a contiguous subarray
	 */
	public static long sum(long[] a) 
	{
		if(a.length == 0)
		{
			throw new IllegalArgumentException("empty array");
		}
		
		long max = Long.MIN_VALUE, sum = 0;
		boolean positive = false;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > -1)
			{	
				positive = true;
				break;
			}
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		if(positive)
		{
			max = sum = 0;
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] + sum > 0)
				{	
					sum += a[i];
				}
				else
				{
					sum = 0;
				}
				
				if(max < sum)
				{
					max = sum;
				}
			}
		}
		return max;
	}
	
	
	// float
	/**
	 * Finds the maximum sum of a contiguous subarray, within a given one-dimensional array.
	 *
	 * @param a input array
	 * @throws IllegalArgumentException when array is empty
	 * @return maximum sum of a contiguous subarray
	 */
	public static double sum(float[] a) 
	{
		if(a.length == 0)
		{
			throw new IllegalArgumentException("empty array");
		}
		
		double max = Float.MIN_VALUE, sum = 0.0;
		boolean positive = false;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > -1)
			{	
				positive = true;
				break;
			}
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		if(positive)
		{
			max = sum = 0;
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] + sum > 0)
				{	
					sum += a[i];
				}
				else
				{
					sum = 0;
				}
				
				if(max < sum)
				{
					max = sum;
				}
			}
		}
		return max;
	}
	
	// double
	/**
	 * Finds the maximum sum of a contiguous subarray, within a given one-dimensional array.
	 *
	 * @param a input array
	 * @throws IllegalArgumentException when array is empty
	 * @return maximum sum of a contiguous subarray
	 */
	public static double sum(double[] a) 
	{
		if(a.length == 0)
		{
			throw new IllegalArgumentException("empty array");
		}
		
		double max = Double.MIN_VALUE, sum = 0.0;
		boolean positive = false;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > -1)
			{	
				positive = true;
				break;
			}
			if(a[i] > max)
			{
				max = a[i];
			}
		}
		if(positive)
		{
			max = sum = 0;
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] + sum > 0)
				{	
					sum += a[i];
				}
				else
				{
					sum = 0;
				}
				
				if(max < sum)
				{
					max = sum;
				}
			}
		}
		return max;
	}
}
