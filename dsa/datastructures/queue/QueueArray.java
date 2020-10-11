package dsa.datastructures.queue;

import dsa.datastructures.list.DynamicArray;

/**
 * The {@code QueueArray} class contains queue operation which uses array to store data.
 *
 * <p>{@code QueueArray} works on <b>primitive types</b> and <b>thread-safe</b>.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time complexity">
 * 	<tr>
 *   <th style = "border: 1px solid black; padding: 15px;"></th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	</tr>
 * 	<tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Insert(enqueue)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 *  <tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Delete(dequeue)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 * @see <a href="../list/DynamicArray.html">Heap</a>
 */
public class QueueArray extends DynamicArray
{
	/**
	 * Constructs an array according to choice specified, with the initial
	 * capacity of {@code 11} and capacity increment of {@code capacity += (capacity/2) + 1}.<br>
	 *
	 * @param choice <pre style="display: inline;">{@code if(choice.equals("char"))} then _char_ is initialized.
	 *	 {@code if(choice.equals("byte"))} then _byte_ is initialized.
	 *	 {@code if(choice.equals("short"))} then _short_ is initialized.
	 *	 {@code if(choice.equals("int"))} then _int_ is initialized.
	 *	 {@code if(choice.equals("long"))} then _long_ is initialized.
	 *	 {@code if(choice.equals("float"))} then _float_ is initialized.
	 *	 {@code if(choice.equals("double"))} then _double_ is initialized.</pre>
	 *
	 * @throws NullPointerException {@code if(choice == null)}
	 * @throws IllegalArgumentException <pre style="display: inline;">{@code if(!choice.equals("char") &&
	 *	 				!choice.equals("byte") && 
	 *	 				!choice.equals("short") && 
	 *	 				!choice.equals("int") && 
	 *	 				!choice.equals("long") && 
	 *	 				!choice.equals("float") && 
	 *	 				!choice.equals("double"))}</pre>
	 */
	public QueueArray(String choice)
	{
		super(choice);
	}
	
	/**
	 * Constructs an array according to choice specified, with the specified 
	 * initial capacity and capacity increment of {@code capacity += (capacity/2) + 1}.<br>
	 *
	 * @param choice <pre style="display: inline;">{@code if(choice.equals("char"))} then _char_ is initialized.
	 *	 {@code if(choice.equals("byte"))} then _byte_ is initialized.
	 *	 {@code if(choice.equals("short"))} then _short_ is initialized.
	 *	 {@code if(choice.equals("int"))} then _int_ is initialized.
	 *	 {@code if(choice.equals("long"))} then _long_ is initialized.
	 *	 {@code if(choice.equals("float"))} then _float_ is initialized.
	 *	 {@code if(choice.equals("double"))} then _double_ is initialized.</pre>
	 * @param initialCapacity the initial capacity of the DynamicArray
	 *
	 * @throws IllegalArgumentException {@code if(initialCapacity < 0)}
	 * @throws NullPointerException {@code if(choice == null)}
	 * @throws IllegalArgumentException <pre style="display: inline;">{@code if(!choice.equals("char") &&
	 *	 				!choice.equals("byte") && 
	 *	 				!choice.equals("short") && 
	 *	 				!choice.equals("int") && 
	 *	 				!choice.equals("long") && 
	 *	 				!choice.equals("float") && 
	 *	 				!choice.equals("double"))}</pre>
	 */
	public QueueArray(int initialCapacity, String choice)
	{
		super(initialCapacity, choice);
	}
	
	/**
	 * Constructs an array according to choice specified, with the specified 
	 * initial capacity and specified capacity increment of {@code capacity += capacityIncrement}.<br>
	 *
	 * @param choice <pre style="display: inline;">{@code if(choice.equals("char"))} then _char_ is initialized.
	 *	 {@code if(choice.equals("byte"))} then _byte_ is initialized.
	 *	 {@code if(choice.equals("short"))} then _short_ is initialized.
	 *	 {@code if(choice.equals("int"))} then _int_ is initialized.
	 *	 {@code if(choice.equals("long"))} then _long_ is initialized.
	 *	 {@code if(choice.equals("float"))} then _float_ is initialized.
	 *	 {@code if(choice.equals("double"))} then _double_ is initialized.</pre>
	 * @param initialCapacity the initial capacity of the DynamicArray
	 * @param capacityIncrement the amount by which the capacity is
	 *                              increased when the DynamicArray overflows
	 *
	 * @throws IllegalArgumentException {@code if(initialCapacity < 0)}
	 * @throws IllegalArgumentException {@code if(capacityIncrement < 1)} 
	 * @throws NullPointerException {@code if(choice == null)}
	 * @throws IllegalArgumentException <pre style="display: inline;">{@code if(!choice.equals("char") &&
	 *	 				!choice.equals("byte") && 
	 *	 				!choice.equals("short") && 
	 *	 				!choice.equals("int") && 
	 *	 				!choice.equals("long") && 
	 *	 				!choice.equals("float") && 
	 *	 				!choice.equals("double"))}</pre>
	 */
	public QueueArray(int initialCapacity, int capacityIncrement, String choice)
	{
		super(initialCapacity, capacityIncrement, choice);
	}
	
	/**
	 * adds an element to the queue.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @param element the element to add
	 */
	public synchronized void enqueue(char element) 
	{
		add(element);
	}
	
	/**
	 * adds an element to the queue.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @param element the element to add
	 */
	public synchronized void enqueue(byte element) 
	{
		add(element);
	}
	
	/**
	 * adds an element to the queue.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @param element the element to add
	 */
	public synchronized void enqueue(short element) 
	{
		add(element);
	}
	
	/**
	 * adds an element to the queue.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @param element the element to add
	 */
	public synchronized void enqueue(int element) 
	{
		add(element);
	}
	
	/**
	 * adds an element to the queue.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @param element the element to add
	 */
	public synchronized void enqueue(long element) 
	{
		add(element);
	}
	
	/**
	 * adds an element to the queue.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @param element the element to add
	 */
	public synchronized void enqueue(float element) 
	{
		add(element);
	}
	
	/**
	 * adds an element to the queue.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @param element the element to add
	 */
	public synchronized void enqueue(double element) 
	{
		add(element);
	}
	
	/**
	 * removes an element from the queue.
	 *
	 * <p>This method is equivalent to {@link #removeAtIndex} where index is {@code 0}.
	 *
	 * @return the element which is removed
	 * @throws java.util.NoSuchElementException if this queue is empty
	 */
	public synchronized Object dequeue() 
	{
		if(isEmpty())
		{
			throw new java.util.NoSuchElementException();
		}
		return removeAtIndex(0);
	}
	
	/**
	 * Retrieves, but does not remove, the front element of queue.
	 *
	 * @return the front element of queue, or {@code null} if the queue is empty
	 */
	public synchronized Object front() 
	{
		return firstElement();
	}

	/**
	 * Retrieves, but does not remove, the rear element of queue.
	 *
	 * @return the rear element of queue, or {@code null} if the queue is empty
	 */	
	public synchronized Object rear() 
	{
		return lastElement();
	}
}