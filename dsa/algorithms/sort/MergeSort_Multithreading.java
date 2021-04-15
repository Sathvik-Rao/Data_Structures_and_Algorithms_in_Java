package dsa.algorithms.sort;

import java.util.concurrent.CyclicBarrier;


/**
 * This class contains sort methods which are implemented using Multithreading Merge Sort.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.</p>
 *
 * <p><b>Mergesort</b> is used when we want a guaranteed running time of <b>O(n logn)</b>.
 * It is also good to use when memory <b>space</b> is not limited.
 * It is not guaranteed Multithreading works as expected, it depends on JVM.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time and Space complexity">
 * 	<tr>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Space Complexity</th>
 * 	</tr>
 * 	<tr>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(n logn / no. of logical processors)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n logn / no. of logical processors)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n logn / no. of logical processors)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 */
public class MergeSort_Multithreading 
{
	// Suppresses default constructor, ensuring non-instantiability.
	private MergeSort_Multithreading() {}
	
	//no. of logical processors
	private final static int processorsCount = Runtime.getRuntime().availableProcessors();
	
	//use Multithreading only if size of array is greater than threshold
	private final static int threshold = 100 + processorsCount;
	
	private static CyclicBarrier gate = null;
	
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
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortAscending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					char[][] temp = new char[processorsCount][];
					char[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new char[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortAscendingChar(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeAscending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new char[1][];
								temp1[0] = new char[temp[0].length + temp[1].length];
								mergeAscending(temp1[0], temp[0], temp[1]);
								mergeAscending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new char[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new char[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeAscendingChar(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortDescending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					char[][] temp = new char[processorsCount][];
					char[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new char[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortDescendingChar(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeDescending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new char[1][];
								temp1[0] = new char[temp[0].length + temp[1].length];
								mergeDescending(temp1[0], temp[0], temp[1]);
								mergeDescending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new char[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new char[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeDescendingChar(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
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
					char[] temp = new char[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					sort(temp, 'a');
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
					sort(temp, 'd');
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
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
	
	// char array Ascending order
	private static class MergeSortAscendingChar implements Runnable
	{
		char[] a;
		MergeSortAscendingChar(char[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortAscending(a);
		}
	}
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
	private static class MergeAscendingChar implements Runnable
	{
		char[] a, left, right;
		MergeAscendingChar(char[] a, char[] left, char[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(char[] a, char[] l, char[] r)
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
	private static class MergeSortDescendingChar implements Runnable
	{
		char[] a;
		MergeSortDescendingChar(char[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortDescending(a);
		}
	}
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
	private static class MergeDescendingChar implements Runnable
	{
		char[] a, left, right;
		MergeDescendingChar(char[] a, char[] left, char[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(char[] a, char[] l, char[] r)
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
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortAscending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					byte[][] temp = new byte[processorsCount][];
					byte[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new byte[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortAscendingByte(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeAscending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new byte[1][];
								temp1[0] = new byte[temp[0].length + temp[1].length];
								mergeAscending(temp1[0], temp[0], temp[1]);
								mergeAscending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new byte[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new byte[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeAscendingByte(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortDescending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					byte[][] temp = new byte[processorsCount][];
					byte[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new byte[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortDescendingByte(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeDescending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new byte[1][];
								temp1[0] = new byte[temp[0].length + temp[1].length];
								mergeDescending(temp1[0], temp[0], temp[1]);
								mergeDescending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new byte[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new byte[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeDescendingByte(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
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
					byte[] temp = new byte[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					sort(temp, 'a');
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
					sort(temp, 'd');
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
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
	
	// byte array Ascending order
	private static class MergeSortAscendingByte implements Runnable
	{
		byte[] a;
		MergeSortAscendingByte(byte[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortAscending(a);
		}
	}
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
	private static class MergeAscendingByte implements Runnable
	{
		byte[] a, left, right;
		MergeAscendingByte(byte[] a, byte[] left, byte[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(byte[] a, byte[] l, byte[] r)
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
	private static class MergeSortDescendingByte implements Runnable
	{
		byte[] a;
		MergeSortDescendingByte(byte[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortDescending(a);
		}
	}
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
	private static class MergeDescendingByte implements Runnable
	{
		byte[] a, left, right;
		MergeDescendingByte(byte[] a, byte[] left, byte[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(byte[] a, byte[] l, byte[] r)
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
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortAscending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					short[][] temp = new short[processorsCount][];
					short[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new short[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortAscendingShort(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeAscending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new short[1][];
								temp1[0] = new short[temp[0].length + temp[1].length];
								mergeAscending(temp1[0], temp[0], temp[1]);
								mergeAscending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new short[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new short[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeAscendingShort(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortDescending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					short[][] temp = new short[processorsCount][];
					short[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new short[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortDescendingShort(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeDescending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new short[1][];
								temp1[0] = new short[temp[0].length + temp[1].length];
								mergeDescending(temp1[0], temp[0], temp[1]);
								mergeDescending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new short[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new short[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeDescendingShort(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
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
					short[] temp = new short[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					sort(temp, 'a');
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
					sort(temp, 'd');
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
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
	
	// short array Ascending order
	private static class MergeSortAscendingShort implements Runnable
	{
		short[] a;
		MergeSortAscendingShort(short[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortAscending(a);
		}
	}
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
	private static class MergeAscendingShort implements Runnable
	{
		short[] a, left, right;
		MergeAscendingShort(short[] a, short[] left, short[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(short[] a, short[] l, short[] r)
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
	private static class MergeSortDescendingShort implements Runnable
	{
		short[] a;
		MergeSortDescendingShort(short[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortDescending(a);
		}
	}
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
	private static class MergeDescendingShort implements Runnable
	{
		short[] a, left, right;
		MergeDescendingShort(short[] a, short[] left, short[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(short[] a, short[] l, short[] r)
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
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortAscending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					int[][] temp = new int[processorsCount][];
					int[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new int[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortAscendingInt(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeAscending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new int[1][];
								temp1[0] = new int[temp[0].length + temp[1].length];
								mergeAscending(temp1[0], temp[0], temp[1]);
								mergeAscending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new int[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new int[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeAscendingInt(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortDescending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					int[][] temp = new int[processorsCount][];
					int[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new int[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortDescendingInt(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeDescending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new int[1][];
								temp1[0] = new int[temp[0].length + temp[1].length];
								mergeDescending(temp1[0], temp[0], temp[1]);
								mergeDescending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new int[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new int[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeDescendingInt(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
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
					int[] temp = new int[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					sort(temp, 'a');
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
					sort(temp, 'd');
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
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
	
	// int array Ascending order
	private static class MergeSortAscendingInt implements Runnable
	{
		int[] a;
		MergeSortAscendingInt(int[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortAscending(a);
		}
	}
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
	private static class MergeAscendingInt implements Runnable
	{
		int[] a, left, right;
		MergeAscendingInt(int[] a, int[] left, int[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(int[] a, int[] l, int[] r)
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
	private static class MergeSortDescendingInt implements Runnable
	{
		int[] a;
		MergeSortDescendingInt(int[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortDescending(a);
		}
	}
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
	private static class MergeDescendingInt implements Runnable
	{
		int[] a, left, right;
		MergeDescendingInt(int[] a, int[] left, int[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(int[] a, int[] l, int[] r)
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
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortAscending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					long[][] temp = new long[processorsCount][];
					long[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new long[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortAscendingLong(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeAscending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new long[1][];
								temp1[0] = new long[temp[0].length + temp[1].length];
								mergeAscending(temp1[0], temp[0], temp[1]);
								mergeAscending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new long[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new long[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeAscendingLong(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortDescending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					long[][] temp = new long[processorsCount][];
					long[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new long[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortDescendingLong(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeDescending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new long[1][];
								temp1[0] = new long[temp[0].length + temp[1].length];
								mergeDescending(temp1[0], temp[0], temp[1]);
								mergeDescending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new long[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new long[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeDescendingLong(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
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
					long[] temp = new long[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					sort(temp, 'a');
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
					sort(temp, 'd');
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
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
	
	// long array Ascending order
	private static class MergeSortAscendingLong implements Runnable
	{
		long[] a;
		MergeSortAscendingLong(long[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortAscending(a);
		}
	}
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
	private static class MergeAscendingLong implements Runnable
	{
		long[] a, left, right;
		MergeAscendingLong(long[] a, long[] left, long[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(long[] a, long[] l, long[] r)
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
	private static class MergeSortDescendingLong implements Runnable
	{
		long[] a;
		MergeSortDescendingLong(long[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortDescending(a);
		}
	}
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
	private static class MergeDescendingLong implements Runnable
	{
		long[] a, left, right;
		MergeDescendingLong(long[] a, long[] left, long[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(long[] a, long[] l, long[] r)
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
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortAscending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					float[][] temp = new float[processorsCount][];
					float[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new float[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortAscendingFloat(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeAscending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new float[1][];
								temp1[0] = new float[temp[0].length + temp[1].length];
								mergeAscending(temp1[0], temp[0], temp[1]);
								mergeAscending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new float[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new float[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeAscendingFloat(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortDescending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					float[][] temp = new float[processorsCount][];
					float[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new float[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortDescendingFloat(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeDescending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new float[1][];
								temp1[0] = new float[temp[0].length + temp[1].length];
								mergeDescending(temp1[0], temp[0], temp[1]);
								mergeDescending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new float[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new float[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeDescendingFloat(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
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
					float[] temp = new float[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					sort(temp, 'a');
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
					sort(temp, 'd');
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
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
	
	// float array Ascending order
	private static class MergeSortAscendingFloat implements Runnable
	{
		float[] a;
		MergeSortAscendingFloat(float[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortAscending(a);
		}
	}
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
	private static class MergeAscendingFloat implements Runnable
	{
		float[] a, left, right;
		MergeAscendingFloat(float[] a, float[] left, float[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(float[] a, float[] l, float[] r)
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
	private static class MergeSortDescendingFloat implements Runnable
	{
		float[] a;
		MergeSortDescendingFloat(float[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortDescending(a);
		}
	}
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
	private static class MergeDescendingFloat implements Runnable
	{
		float[] a, left, right;
		MergeDescendingFloat(float[] a, float[] left, float[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(float[] a, float[] l, float[] r)
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
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortAscending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					double[][] temp = new double[processorsCount][];
					double[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new double[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortAscendingDouble(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeAscending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new double[1][];
								temp1[0] = new double[temp[0].length + temp[1].length];
								mergeAscending(temp1[0], temp[0], temp[1]);
								mergeAscending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new double[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new double[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeAscendingDouble(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortDescending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					double[][] temp = new double[processorsCount][];
					double[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new double[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortDescendingDouble(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeDescending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new double[1][];
								temp1[0] = new double[temp[0].length + temp[1].length];
								mergeDescending(temp1[0], temp[0], temp[1]);
								mergeDescending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new double[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new double[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeDescendingDouble(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							if(pcTemp%2 == 0)
							{
								for(i = 0; i < procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[0] = temp[(procCount*2)];
								for(i = 1; i <= procCount ; i++)
								{
									temp[i] = temp1[i];
								}
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
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
					double[] temp = new double[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					sort(temp, 'a');
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
					sort(temp, 'd');
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = temp[j++];
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
	
	// double array Ascending order
	private static class MergeSortAscendingDouble implements Runnable
	{
		double[] a;
		MergeSortAscendingDouble(double[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortAscending(a);
		}
	}
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
	private static class MergeAscendingDouble implements Runnable
	{
		double[] a, left, right;
		MergeAscendingDouble(double[] a, double[] left, double[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeAscending(a, left, right);
		}
	}
	private static void mergeAscending(double[] a, double[] l, double[] r)
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
	private static class MergeSortDescendingDouble implements Runnable
	{
		double[] a;
		MergeSortDescendingDouble(double[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortDescending(a);
		}
	}
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
	private static class MergeDescendingDouble implements Runnable
	{
		double[] a, left, right;
		MergeDescendingDouble(double[] a, double[] left, double[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeDescending(a, left, right);
		}
	}
	private static void mergeDescending(double[] a, double[] l, double[] r)
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
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortAscending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					Object[][] temp = new Object[processorsCount][];
					Object[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new Object[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortAscendingGeneric(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for( i = 0; i < processorsCount; i++)
						{
							t[i].join();
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeAscending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new Object[1][];
								temp1[0] = new Object[temp[0].length + temp[1].length];
								mergeAscending(temp1[0], temp[0], temp[1]);
								mergeAscending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new Object[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new Object[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeAscendingGeneric(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							for(i = 0; i < procCount ; i++)
							{
								temp[i] = temp1[i];
							}
							if(pcTemp%2 == 0)
							{
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[i++] = temp[(procCount*2)];
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
					}
				}
			}
			
			// Descending Order
			else if(c == 'd' || c == 'D')
			{
				if(processorsCount == 1 || a.length <= threshold)
				{
					mergeSortDescending(a);
				}
				else
				{
					int i = 0;
					int procCount = processorsCount;
					gate = new CyclicBarrier(processorsCount + 1);
					Thread[] t = new Thread[processorsCount];
					Object[][] temp = new Object[processorsCount][];
					Object[][] temp1 = null;
					for(int start, end = 0; i < processorsCount; i++)
					{
						start = end;
						if(procCount == 1)
						{
							end = a.length;
						}
						else
						{
						    end += (int)Math.round((a.length-start)/(float)procCount--);
						}
						temp[i] = new Object[end-start];
						for(int j = 0,k = start; k < end; k++, j++)
						{
							temp[i][j] = a[k];
						}
						t[i] = new Thread(new MergeSortDescendingGeneric(temp[i]));
						t[i].start();
					}
					try
					{
						gate.await();
						for(i = 0; i < processorsCount; i++)
						{
							t[i].join(); 
						}
					} catch(Exception e){}
					
					procCount = processorsCount;
					while(true)
					{
						if(procCount < 4)
						{
							if(procCount == 2)
							{
								mergeDescending(a, temp[0], temp[1]);
							}
							else
							{
								temp1 = new Object[1][];
								temp1[0] = new Object[temp[0].length + temp[1].length];
								mergeDescending(temp1[0], temp[0], temp[1]);
								mergeDescending(a, temp1[0], temp[2]);
							}
							break;
						}
						else
						{
							int j = 0, pcTemp = procCount;
							procCount /= 2;
							temp1 = new Object[procCount][];
							gate = new CyclicBarrier(procCount + 1);
							t = new Thread[procCount];
							for(i = 0; i < pcTemp-1; i+=2, j++)
							{
								temp1[j] = new Object[temp[i].length + temp[i+1].length];
								t[j] = new Thread(new MergeDescendingGeneric(temp1[j], temp[i], temp[i+1]));
								t[j].start();
							}
							try
							{
								gate.await();
								for(i = 0; i < procCount; i++)
								{
									t[i].join();
								}
							} catch(Exception e){}
							for(i = 0; i < procCount ; i++)
							{
								temp[i] = temp1[i];
							}
							if(pcTemp%2 == 0)
							{
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
							}
							else
							{
								temp[i++] = temp[(procCount*2)];
								for( ; i < processorsCount; i++)
								{
									temp[i] = null;
								}
								procCount++;
							}
						}
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
	@SuppressWarnings("unchecked")
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
					Object[] temp = new Object[toIndex - fromIndex];
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						temp[j++] = a[i];
					}
					sort((T[])temp, 'a');
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = (T)temp[j++];
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
					sort((T[])temp, 'd');
					for(int i = fromIndex, j = 0; i < toIndex; i++)
					{
						a[i] = (T)temp[j++];
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
	
	// Generic array Ascending order
	private static class MergeSortAscendingGeneric implements Runnable
	{
		Object[] a;
		MergeSortAscendingGeneric(Object[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortAscending(a);
		}
	}
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
	private static class MergeAscendingGeneric implements Runnable
	{
		Object[] a, left, right;
		MergeAscendingGeneric(Object[] a, Object[] left, Object[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeAscending(a, left, right);
		}
	}
	@SuppressWarnings({"unchecked", "rawtypes"})
	private static void mergeAscending(Object[] a, Object[] l, Object[] r)
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

	// Generic array Descending order
	private static class MergeSortDescendingGeneric implements Runnable
	{
		Object[] a;
		MergeSortDescendingGeneric(Object[] a)
		{
			this.a = a;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeSortDescending(a);
		}
	}
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
	private static class MergeDescendingGeneric implements Runnable
	{
		Object[] a, left, right;
		MergeDescendingGeneric(Object[] a, Object[] left, Object[] right)
		{
			this.a = a;
			this.left = left;
			this.right = right;
		}
		public void run()
		{
			try
			{
				gate.await();
			} catch(Exception e) {}
			mergeDescending(a, left, right);
		}
	}
	@SuppressWarnings({"unchecked", "rawtypes"})
	private static void mergeDescending(Object[] a, Object[] l, Object[] r)
	{	
		int i=0, j=0, k=0;
		while(i < l.length && j < r.length)
		{
			if(((Comparable)l[i]).compareTo(r[j]) > 0) 
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