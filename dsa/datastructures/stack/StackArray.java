package dsa.datastructures.stack;

import dsa.datastructures.list.DynamicArray;

/**
 * The {@code StackArray} class contains stack operation which uses array to store data.
 *
 * <p>{@code StackArray} works on <b>primitive types</b> and <b>thread-safe</b>.</p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary="Time complexity">
 * 	<tr>
 *   <th style = "border: 1px solid black; padding: 15px;"></th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Best)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Average)</th>
 * 	 <th style = "border: 1px solid black; padding: 15px;">Time Complexity(Worst)</th>
 * 	</tr>
 * 	<tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Insert(puch)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 *  <tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Delete(pop)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 * @see <a href="../list/DynamicArray.html">DynamicArray</a>
 */
public class StackArray extends DynamicArray
{
	/**
	 * Constructs a {@code DynamicArray} according to choice specified, with the initial
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
	public StackArray(String choice)
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
	public StackArray(int initialCapacity, String choice)
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
	public StackArray(int initialCapacity, int capacityIncrement, String choice)
	{
		super(initialCapacity, capacityIncrement, choice);
	}
	
	/**
	 * Adds an element to the collection.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @param element the element to push
	 */
	public synchronized void push(char element) 
	{
		add(element);
	}
	
	/**
	 * Adds an element to the collection.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @param element the element to push
	 */
	public synchronized void push(byte element) 
	{
		add(element);
	}
	
	/**
	 * Adds an element to the collection.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @param element the element to push
	 */
	public synchronized void push(short element) 
	{
		add(element);
	}
	
	/**
	 * Adds an element to the collection.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @param element the element to push
	 */
	public synchronized void push(int element) 
	{
		add(element);
	}
	
	/**
	 * Adds an element to the collection.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @param element the element to push
	 */
	public synchronized void push(long element) 
	{
		add(element);
	}
	
	/**
	 * Adds an element to the collection.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @param element the element to push
	 */
	public synchronized void push(float element) 
	{
		add(element);
	}
	
	/**
	 * Adds an element to the collection.
	 *
	 * <p>This method is equivalent to {@link #add}.</p>
	 *
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @param element the element to push
	 */
	public synchronized void push(double element) 
	{
		add(element);
	}
	
	/**
	 * Removes the most recently added element.
	 *
	 * <p>This method is equivalent to {@link #removeAtIndex} where index is {@code size() - 1}.
	 *
	 * @return the element at the top of the stack
	 * @throws java.util.NoSuchElementException if this stack is empty
	 */
	public synchronized Object pop() 
	{
		if(isEmpty())
		{
			throw new java.util.NoSuchElementException();
		}
		return removeAtIndex(size() - 1);
	}
	
	/**
	 * Retrieves, but does not remove, the top of stack.
	 *
	 * @return the top of stack, or {@code null} if the stack is empty
	 */
	public synchronized Object peek() 
	{
		return lastElement();
	}
}