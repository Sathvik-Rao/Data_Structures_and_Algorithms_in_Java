package dsa.datastructures.stack;

import dsa.datastructures.linkedlist.Linked_List;

/**
 * The {@code StackLinkedList} class contains stack operation which uses linked list to store data.
 *
 * <p>{@code StackLinkedList} is <b>thread-safe</b> and is implemented for <b>primitive types</b> only.</p>
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
 * @see <a href="../linkedlist/Linked_List.html">Linked_List</a>
 */
public class StackLinkedList extends Linked_List
{
	/**
	 * Constructs a {@code Linked_List} according to choice specified.
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
	public StackLinkedList(String choice)
	{
		super(choice);
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