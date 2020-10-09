package dsa.datastructures.heap;


/**
 * Heap is a special Tree-based data structure in which the tree is a complete binary tree.
 * Generally, Heaps can be of two types:<br>
 *
 * Max-Heap: In a Max-Heap the key present at the root node must be greatest among the 
 * keys present at all of it’s children. The same property must be recursively true for all 
 * sub-trees in that Binary Tree.<br>
 *
 * Min-Heap: In a Min-Heap the key present at the root node must be minimum among the 
 * keys present at all of it’s children. The same property must be recursively true for all 
 * sub-trees in that Binary Tree.
 *
 * <p><b>Note that this implementation is not synchronized</b>. Multiple threads should not 
 * access a Heap instance concurrently if any of the threads modifies the heap.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time complexity">
 * 	<tr>
 *   <th style = "border: 1px solid black; padding: 15px;"></th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	</tr>
 * 	<tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Insert(add)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(logn)</td>
 * 	</tr>
 *  <tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Delete(poll)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(logn)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(logn)</td>
 * 	</tr>
 *  <tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Peek(peek)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(1)</td>
 * 	</tr>
 *	<tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Search(contains)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 * @param <T> the type of elements that implements Comparable interface
 * @see <a href="InvalidChoiceException.html">InvalidChoiceException</a>
 */
public final class Heap<T extends Comparable<T>>
{	
	// choice holds the input operations to be done max or min.
	private String choice;
	
	// Array representation of heap.
	private Object[] elementData;
	
	// Temporary Array for heap.
	private Object[] elementDataTemp;
	
	// Array length(capacity).
	private int capacity = 11;
	
	// The number of elements in the heap.
	private int end = 0;
	
	/**
	 * Creates a {@code Heap} with the default initial
	 * capacity (11) that orders its elements according to the order specified.
	 *
	 * @param str min heap {@code if(str == "min")} or max heap {@code if(str == "min")}
	 * @throws InvalidChoiceException {@code if(str != "min" || str != "max") }
	 * @throws NullPointerException if the {@code str} element is null
	 */
    public Heap(String str) throws InvalidChoiceException
	{
		if(str == null)
		{
            throw new NullPointerException();
		}
		
		elementData = new Object[capacity];
		choice = str.trim().toLowerCase();
		if(!choice.equals("min") && !(choice.equals("max")))
		{
			throw new InvalidChoiceException(choice);
		}
		initialize();
	}
	
	/**
	 * Creates a {@code PriorityQueue} with the specified initial
	 * capacity that orders its elements according to the order specified.
	 *
	 * @param initialCapacity the initial capacity for the heap
	 * @param str min heap {@code if(str == "min")} or max heap {@code if(str == "min")}
	 * @throws InvalidChoiceException {@code if(str != "min" || str != "max") }
	 * @throws NullPointerException if the {@code str} element is null
	 */
	public Heap(int initialCapacity, String str) throws InvalidChoiceException
	{
		if(str == null)
		{
            throw new NullPointerException();
		}
		
		if (initialCapacity > 0) 
		{
			capacity = initialCapacity;
            elementData = new Object[capacity];
			initialize();
        }
		else if (initialCapacity == 0) 
		{
            capacity = 0;
			elementData = new Object[capacity];
        }
		else 
		{
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
		
		choice = str.trim().toLowerCase();
		if(!choice.equals("min") && !(choice.equals("max")))
		{
			throw new InvalidChoiceException(choice);
		}
	}
	
	private void initialize()
	{
		for(int i = 0; i < capacity ;i++)
		{
			elementData[i] = new Object();
		}
	}

	private boolean isFull() 
	{
		if(capacity > end)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private void grow() 
	{
		capacity += (capacity >>> 1) + 1;
		elementDataTemp = new Object[capacity];
		int i = 0;
		if(end > 0)
		{
			for( ; i < end; i++)
			{
				elementDataTemp[i] = elementData[i];
			}
		}
		for( ; i < capacity; i++)
		{
				elementDataTemp[i] = new Object();
		}
		elementData = elementDataTemp;
	}
	
	/**
	 * Inserts the specified element into the heap.
	 *
	 * @param e the element to add
	 * @throws NullPointerException if the specified element is null
	 */
	public void add(T e)
	{
		if(e == null)
		{
            throw new NullPointerException();
		}
		
		if(isFull())
		{
			elementData[end++] = e;		
		}
		else
		{
			grow();
			elementData[end++] = e;		
		}
		
		if(choice.equals("max"))
		{
			insertMax();
		}
		else
		{
			insertMin();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void insertMax()
	{	
		if(end > 1)
		{
			int child = end - 1;
			int parent;
			while(child > 0)
			{
				parent = child / 2;
				if(child % 2 == 0)
				{
					parent--;
				}
				
				if(((T) elementData[parent]).compareTo((T) elementData[child]) < 0)
				{
					Object temp = elementData[parent];
					elementData[parent] = elementData[child];
					elementData[child] = temp;
					child = parent;
				}
				else
				{
					break;
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void insertMin()
	{
		if(end > 1)
		{
			int child = end - 1;
			int parent;
			while(child > 0)
			{
				parent = child / 2;
				if(child % 2 == 0)
				{
					parent--;
				}
				
				if(((T) elementData[parent]).compareTo((T) elementData[child]) > 0)
				{
					Object temp = elementData[parent];
					elementData[parent] = elementData[child];
					elementData[child] = temp;
					child = parent;
				}
				else
				{
					break;
				}
			}
		}
	}
	
	private boolean isFree() 
	{
		if(end < (capacity / 2)) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private void shrink()
	{
		capacity = end;
		elementDataTemp = new Object[capacity];
		for( int i = 0; i < end; i++)
		{
			elementDataTemp[i] = elementData[i];
		}
		elementData = elementDataTemp;
	}
	
	/**
	 * Retrieves and removes the root of the heap, 
	 * or returns null if the heap is empty.
	 *
	 * @return the root of the heap, or null if the heap is empty
	 */
	@SuppressWarnings("unchecked")
	public T poll()
	{
		if(isFree())
		{
			shrink();	
		}
		
		if(choice.equals("max"))
		{
			return (T)deleteMax();
		}
		else
		{
			return (T)deleteMin();
		}
	}
	
	@SuppressWarnings("unchecked")
	private Object deleteMax()
	{	
		if(end == 0)
		{
			return null;
		}
		
		Object deleatedValue = elementData[0];
		if(end == 1)
		{
			end--;
		}
		else
		{
			int parent = 0;
			elementData[parent] = elementData[--end];
			int childLeft, childRight;
			T a,b,p;
			while(true)
			{
				p = (T) elementData[parent];
				childLeft = (2 * parent) + 1;
				childRight = (2 * parent) + 2;
				if(childLeft < end && childRight < end)
				{
					a = (T) elementData[childLeft];
					b = (T) elementData[childRight];
					if(a.compareTo(b) < 0)
					{
						if(p.compareTo(b) == 0)
						{
							break;
						}
						elementData[parent] = b;
						elementData[childRight] = p;
						parent = childRight;	
					}
					else
					{
						if(p.compareTo(a) == 0)
						{
							break;
						}
						elementData[parent] = a;
						elementData[childLeft] = p;
						parent = childLeft;
					}	
				}
				else if(childLeft < end && !(childRight < end))
				{
					a = (T) elementData[childLeft];
					if(p.compareTo(a) < 0)
					{
						elementData[parent] = a;
						elementData[childLeft] = p;
						parent = childLeft;
					}
					else
					{
						break;
					}
				}
				else if(!(childLeft < end) && childRight < end)
				{
					b = (T) elementData[childRight];
					if(p.compareTo(b) < 0)
					{
						elementData[parent] = b;
						elementData[childRight] = p;
						parent = childRight;
					}
					else
					{
						break;
					}
				}
				else
				{
					break;
				}
			}
		}
		return deleatedValue;
	}
	
	@SuppressWarnings("unchecked")
	private Object deleteMin()
	{	
		if(end == 0)
		{
			return null;
		}
		
		Object deleatedValue = elementData[0];
		if(end == 1)
		{
			end--;
		}
		else
		{
			int parent = 0;
			elementData[parent] = elementData[--end];
			int childLeft, childRight;
			T a,b,p;
			while(true)
			{
				p = (T) elementData[parent];
				childLeft = (2 * parent) + 1;
				childRight = (2 * parent) + 2;
				if(childLeft < end && childRight < end)
				{
					a = (T) elementData[childLeft];
					b = (T) elementData[childRight];
					if(a.compareTo(b) < 0)
					{
						if(p.compareTo(a) > 0)
						{
							elementData[parent] = a;
							elementData[childLeft] = p;
							parent = childLeft;
						}
						else
						{
							break;
						}
					}
					else
					{
						if(p.compareTo(b) > 0)
						{
							elementData[parent] = b;
							elementData[childRight] = p;
							parent = childRight;
						}
						else
						{
							break;
						}
					}	
				}
				else if(childLeft < end && !(childRight < end))
				{
					a = (T) elementData[childLeft];
					if(p.compareTo(a) > 0)
					{
						elementData[parent] = a;
						elementData[childLeft] = p;
						parent = childLeft;
					}
					else
					{
						break;
					}
				}
				else if(!(childLeft < end) && childRight < end)
				{
					b = (T) elementData[childRight];
					if(p.compareTo(b) > 0)
					{
						elementData[parent] = b;
						elementData[childRight] = p;
						parent = childRight;
					}
					else
					{
						break;
					}
				}
				else
				{
					break;
				}
			}
		}
		return deleatedValue;
	}
	
	/**
	 * Retrieves, but does not remove, the root of the heap, 
	 * or returns null if the heap is empty.
	 *
	 * @return the root of the heap, or null if the heap is empty
	 */
	@SuppressWarnings("unchecked")
	public T peek()
	{
		if(end == 0)
		{
			return null;
		}
		return (T)elementData[0];
	}
	
	/**
	 * Removes all of the elements from the heap.
	 * The heap will be empty after this call returns.
	 */
	public void clear()
	{
		end = 0;
		if(isFree())
		{
			shrink();	
		}
	}
	
	/**
	 * Returns {@code true} if this heap contains the specified element.
	 * More formally, returns {@code true} if and only if the heap contains
	 * at least one element {@code e} such that {@code e.equals(o)}.
	 *
	 * @param e object to be checked for containment in the heap
	 * @return {@code true} if this heap contains the specified element, else {@code false}
	 * @throws NullPointerException if the specified element is null
	 */
	@SuppressWarnings("unchecked")
	public boolean contains(T e)
	{
		if(e == null)
		{
            throw new NullPointerException();
		}
		for(int i = 0; i < end; i++)
        {
			if(e.compareTo((T) elementData[i]) == 0)
			{
                return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the number of elements present in the heap.
	 *
	 * @return the number of elements in the heap
	 */
	public int size()
	{
		return end;
	}
	
	/**
	 * Returns an array containing all of the elements in the queue.
	 * The elements are in level order of heap.
	 *
	 * <p>The returned array will be "safe" in that no references to it are
	 * maintained by the heap.  (In other words, this method must allocate
	 * a new array).  The caller is thus free to modify the returned array.</p>
	 *
	 * @return an array containing all of the elements in the queue.
	 */
	public Object[] toArray()
	{
		Object[] o = new Object[end];
		for(int i = 0; i < end ;i++)
		{
			o[i] = elementData[i];
		}
		return o;
	}
	
	/**
	 * Returns a string representation of the heap. The string representation 
	 * consists of a list of the heap elements in the order of it's level, 
	 * enclosed in square brackets ("[]").
	 * Adjacent elements are separated by the characters ", " (comma and space). 
	 *
	 * @return a string representation of the heap
	 */
	@Override
	public String toString()
	{
		if(end == 0)
		{
			return "[]";
		}
		
		StringBuilder str = new StringBuilder((3*end) + 2);
		str.append("[");
		int i = 0;
		for( ; i < end - 1; i++)
		{
			str.append(elementData[i] + ", ");
		}
		str.append(elementData[i] + "]");
		
		return str.toString();
	}
}
