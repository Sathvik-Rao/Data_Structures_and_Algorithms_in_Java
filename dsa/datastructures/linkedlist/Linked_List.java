package dsa.datastructures.linkedlist;

import java.util.Arrays;
import java.util.Collections; 

/**
 * The {@code Linked_List} class contains components that can be accessed using an integer index. 
 *
 * <p> Linked list is a linear collection of data elements whose order is not given by their 
 * physical placement in memory. Instead, each element points to the next and previous element.</p>
 *
 * <p>{@code Linked_List} is <b>thread-safe</b> and is implemented for <b>primitive types</b> only.</p>
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
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 * 	<tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Delete(remove)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 *	<tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Random Access(get)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 *  <tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Search(contains)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(1)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n/2)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n)</td>
 * 	</tr>
 *	<tr>
 *	 <th style = "border: 1px solid black; padding: 15px;">Sort(sort)</th>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#937;(n)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">&#952;(n logn)</td>
 * 	 <td style = "border: 1px solid black; text-align: center; padding: 15px;">O(n<sup STYLE="font-size:8.0pt">2</sup>)</td>
 * 	</tr>
 * </table>
 *
 * @author  Sathvik
 * @version 1.0
 */
public class Linked_List
{
	private class Node_Char
	{
		Node_Char prev = null;
		char data;
		Node_Char next = null;
	}

	private class Node_Byte
	{
		Node_Byte prev = null;
		byte data;
		Node_Byte next = null;
	}

	private class Node_Short
	{
		Node_Short prev = null;
		short data;
		Node_Short next = null;
	}

	private class Node_Int
	{
		Node_Int prev = null;
		int data;
		Node_Int next = null;
	}

	private class Node_Long
	{
		Node_Long prev = null;
		long data;
		Node_Long next = null;
	}

	private class Node_Float
	{
		Node_Float prev = null;
		float data;
		Node_Float next = null;
	}

	private class Node_Double
	{
		Node_Double prev = null;
		double data;
		Node_Double next = null;
	}
	
	private Node_Char first_char = null;
	private Node_Char last_char = null;
	private Node_Byte first_byte = null;
	private Node_Byte last_byte = null;
	private Node_Short first_short = null;
	private Node_Short last_short = null;
	private Node_Int first_int = null;
	private Node_Int last_int = null;
	private Node_Long first_long = null;
	private Node_Long last_long = null;
	private Node_Float first_float = null;
	private Node_Float last_float = null;
	private Node_Double first_double = null;
	private Node_Double last_double = null;
	
	private byte[] choice = {0, 0, 0, 0, 0, 0, 0};
	
	private final byte ONE = 1;
	
	private long size = 0;
	
	/**
	 * Constructs a Linked List according to choice specified. 
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
	public Linked_List(String choice)
	{
		if (choice == null)
		{
			throw new NullPointerException();
		}
		
		choice = choice.trim().toLowerCase();
		if (choice.equals("char"))
		{
			this.choice[0] = ONE;
		}
		else if (choice.equals("byte"))
		{
			this.choice[1] = ONE;
		}
		else if (choice.equals("short"))
		{
			this.choice[2] = ONE;
		}
		else if (choice.equals("int"))
		{
			this.choice[3] = ONE;
		}
		else if (choice.equals("long"))
		{
			this.choice[4] = ONE;
		}
		else if (choice.equals("float"))
		{
			this.choice[5] = ONE;
		}
		else if (choice.equals("double"))
		{
			this.choice[6] = ONE;
		}
		else
		{
			throw new IllegalArgumentException("Invalid choice \"" + choice +  
			"\", excepted \"char\" or \"byte\" or \"short\" or \"int\" or \"long\" or \"float\" or \"double\".");
		}
	}

	private void choiceCheck(int index)
	{
		if(choice[index] != ONE)
		{
			if(index == 0)
			{
				throw new IllegalArgumentException("\'char\' method call not allowed");
			}
			else if(index == 1)
			{
				throw new IllegalArgumentException("\'byte\' method call not allowed");
			}
			else if(index == 2)
			{
				throw new IllegalArgumentException("\'short\' method call not allowed");
			}
			else if(index == 3)
			{
				throw new IllegalArgumentException("\'int\' method call not allowed");
			}
			else if(index == 4)
			{
				throw new IllegalArgumentException("\'long\' method call not allowed");
			}
			else if(index == 5)
			{
				throw new IllegalArgumentException("\'float\' method call not allowed");
			}
			else
			{
				throw new IllegalArgumentException("\'double\' method call not allowed");
			}
		}
	}
	
	/**
	 * Appends the specified element to the end of this Linked_List(char).
	 *
	 * @param element element to be appended to this Linked_List
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(char element)
	{
		choiceCheck(0);
		Node_Char temp = new Node_Char();
		temp.data = element;
		if(first_char == null)
		{
			first_char = temp;
			last_char = temp;
		}
		else
		{
			last_char.next = temp;
			temp.prev = last_char;
			last_char = temp;
		}
		size++;
		return true;
	}
	
	/**
	 * Appends the specified element to the end of this Linked_List(byte).
	 *
	 * @param element element to be appended to this Linked_List
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(byte element)
	{
		choiceCheck(1);
		Node_Byte temp = new Node_Byte();
		temp.data = element;
		if(first_byte == null)
		{
			first_byte = temp;
			last_byte = temp;
		}
		else
		{
			last_byte.next = temp;
			temp.prev = last_byte;
			last_byte = temp;
		}
		size++;
		return true;
	}
	
	/**
	 * Appends the specified element to the end of this Linked_List(short).
	 *
	 * @param element element to be appended to this Linked_List
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(short element)
	{
		choiceCheck(2);
		Node_Short temp = new Node_Short();
		temp.data = element;
		if(first_short == null)
		{
			first_short = temp;
			last_short = temp;
		}
		else
		{
			last_short.next = temp;
			temp.prev = last_short;
			last_short = temp;
		}
		size++;
		return true;
	}
	
	/**
	 * Appends the specified element to the end of this Linked_List(int).
	 *
	 * @param element element to be appended to this Linked_List
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(int element)
	{
		choiceCheck(3);
		Node_Int temp = new Node_Int();
		temp.data = element;
		if(first_int == null)
		{
			first_int = temp;
			last_int = temp;
		}
		else
		{
			last_int.next = temp;
			temp.prev = last_int;
			last_int = temp;
		}
		size++;
		return true;
	}
	
	/**
	 * Appends the specified element to the end of this Linked_List(long).
	 *
	 * @param element element to be appended to this Linked_List
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(long element)
	{
		choiceCheck(4);
		Node_Long temp = new Node_Long();
		temp.data = element;
		if(first_long == null)
		{
			first_long = temp;
			last_long = temp;
		}
		else
		{
			last_long.next = temp;
			temp.prev = last_long;
			last_long = temp;
		}
		size++;
		return true;
	}
	
	/**
	 * Appends the specified element to the end of this Linked_List(float).
	 *
	 * @param element element to be appended to this Linked_List
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(float element)
	{
		choiceCheck(5);
		Node_Float temp = new Node_Float();
		temp.data = element;
		if(first_float == null)
		{
			first_float = temp;
			last_float = temp;
		}
		else
		{
			last_float.next = temp;
			temp.prev = last_float;
			last_float = temp;
		}
		size++;
		return true;
	}
	
	/**
	 * Appends the specified element to the end of this Linked_List(double).
	 *
	 * @param element element to be appended to this Linked_List
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(double element)
	{
		choiceCheck(6);
		Node_Double temp = new Node_Double();
		temp.data = element;
		if(first_double == null)
		{
			first_double = temp;
			last_double = temp;
		}
		else
		{
			last_double.next = temp;
			temp.prev = last_double;
			last_double = temp;
		}
		size++;
		return true;
	}
	
	private void rangeCheck(long index)
	{
		if(index > size)
		{
			throw new IndexOutOfBoundsException(index + " > " + size);
		}
		if(index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Inserts the specified element at the specified position in this Linked_List(char).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(long index, char element)
	{
		choiceCheck(0);
		rangeCheck(index);
		Node_Char temp = new Node_Char();
		temp.data = element;
		if(size == 0)
		{
			first_char = last_char = temp;
		}
		else if(index == 0)
		{
			temp.next = first_char;
			first_char.prev = temp;
			first_char = temp;
		}
		else if(index == size)
		{
			temp.prev = last_char;
			last_char.next = temp;
			last_char = temp;
		}
		else
		{
			Node_Char pointer = first_char;
			for(long i = 1; i < index; i++)
			{
				pointer = pointer.next;
			}
			temp.next = pointer.next;
			temp.prev = pointer;
			pointer.next = temp;
			temp.next.prev = temp;
		}
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position in this Linked_List(byte).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(long index, byte element)
	{
		choiceCheck(1);
		rangeCheck(index);
		Node_Byte temp = new Node_Byte();
		temp.data = element;
		if(size == 0)
		{
			first_byte = last_byte = temp;
		}
		else if(index == 0)
		{
			temp.next = first_byte;
			first_byte.prev = temp;
			first_byte = temp;
		}
		else if(index == size)
		{
			temp.prev = last_byte;
			last_byte.next = temp;
			last_byte = temp;
		}
		else
		{
			Node_Byte pointer = first_byte;
			for(long i = 1; i < index; i++)
			{
				pointer = pointer.next;
			}
			temp.next = pointer.next;
			temp.prev = pointer;
			pointer.next = temp;
			temp.next.prev = temp;
		}
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position in this Linked_List(short).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(long index, short element)
	{
		choiceCheck(2);
		rangeCheck(index);
		Node_Short temp = new Node_Short();
		temp.data = element;
		if(size == 0)
		{
			first_short = last_short = temp;
		}
		else if(index == 0)
		{
			temp.next = first_short;
			first_short.prev = temp;
			first_short = temp;
		}
		else if(index == size)
		{
			temp.prev = last_short;
			last_short.next = temp;
			last_short = temp;
		}
		else
		{
			Node_Short pointer = first_short;
			for(long i = 1; i < index; i++)
			{
				pointer = pointer.next;
			}
			temp.next = pointer.next;
			temp.prev = pointer;
			pointer.next = temp;
			temp.next.prev = temp;
		}
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position in this Linked_List(int).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(long index, int element)
	{
		choiceCheck(3);
		rangeCheck(index);
		Node_Int temp = new Node_Int();
		temp.data = element;
		if(size == 0)
		{
			first_int = last_int = temp;
		}
		else if(index == 0)
		{
			temp.next = first_int;
			first_int.prev = temp;
			first_int = temp;
		}
		else if(index == size)
		{
			temp.prev = last_int;
			last_int.next = temp;
			last_int = temp;
		}
		else
		{
			Node_Int pointer = first_int;
			for(long i = 1; i < index; i++)
			{
				pointer = pointer.next;
			}
			temp.next = pointer.next;
			temp.prev = pointer;
			pointer.next = temp;
			temp.next.prev = temp;
		}
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position in this Linked_List(long).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(long index, long element)
	{
		choiceCheck(4);
		rangeCheck(index);
		Node_Long temp = new Node_Long();
		temp.data = element;
		if(size == 0)
		{
			first_long = last_long = temp;
		}
		else if(index == 0)
		{
			temp.next = first_long;
			first_long.prev = temp;
			first_long = temp;
		}
		else if(index == size)
		{
			temp.prev = last_long;
			last_long.next = temp;
			last_long = temp;
		}
		else
		{
			Node_Long pointer = first_long;
			for(long i = 1; i < index; i++)
			{
				pointer = pointer.next;
			}
			temp.next = pointer.next;
			temp.prev = pointer;
			pointer.next = temp;
			temp.next.prev = temp;
		}
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position in this Linked_List(float).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(long index, float element)
	{
		choiceCheck(5);
		rangeCheck(index);
		Node_Float temp = new Node_Float();
		temp.data = element;
		if(size == 0)
		{
			first_float = last_float = temp;
		}
		else if(index == 0)
		{
			temp.next = first_float;
			first_float.prev = temp;
			first_float = temp;
		}
		else if(index == size)
		{
			temp.prev = last_float;
			last_float.next = temp;
			last_float = temp;
		}
		else
		{
			Node_Float pointer = first_float;
			for(long i = 1; i < index; i++)
			{
				pointer = pointer.next;
			}
			temp.next = pointer.next;
			temp.prev = pointer;
			pointer.next = temp;
			temp.next.prev = temp;
		}
		return true;
	}
	
	/**
	 * Inserts the specified element at the specified position in this Linked_List(double).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(long index, double element)
	{
		choiceCheck(5);
		rangeCheck(index);
		Node_Double temp = new Node_Double();
		temp.data = element;
		if(size == 0)
		{
			first_double = last_double = temp;
		}
		else if(index == 0)
		{
			temp.next = first_double;
			first_double.prev = temp;
			first_double = temp;
		}
		else if(index == size)
		{
			temp.prev = last_double;
			last_double.next = temp;
			last_double = temp;
		}
		else
		{
			Node_Double pointer = first_double;
			for(long i = 1; i < index; i++)
			{
				pointer = pointer.next;
			}
			temp.next = pointer.next;
			temp.prev = pointer;
			pointer.next = temp;
			temp.next.prev = temp;
		}
		return true;
	}
	
	private void rangeCheck0(long index)
	{
		if(index >= size)
		{
			throw new IndexOutOfBoundsException("Index out of range: " + index);
		}
		if(index < 0)
		{
			throw new IndexOutOfBoundsException("" + index);
		}
	}
	
	/**
	 * Removes the element at the specified position in this Linked_List.
	 * Returns the element that was removed from the Linked_List.
	 *
	 * @param index the index of the element to be removed
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 * @return element that was removed
	 */
	public synchronized Object removeAtIndex(long index)
	{
		rangeCheck0(index);
		Object o = null;
		
		if (choice[0] == ONE)
		{
			if((size-1) == 0)
			{
				o = first_char.data;
				first_char = last_char = null;
			}
			else if(index == 0)
			{
				o = first_char.data;
				first_char = first_char.next;
				first_char.prev = null;
			}
			else if(index == (size-1))
			{
				o = last_char.data;
				last_char = last_char.prev;
				last_char.next = null;
			}
			else
			{
				Node_Char pointer = first_char;
				for(long i = 1; i <= index; i++)
				{
					pointer = pointer.next;
				}
				o = pointer.data;
				pointer.prev.next = pointer.next;
				pointer.next.prev = pointer.prev;
			}
			size--;
		}
		else if(choice[1] == ONE)
		{
			if((size-1) == 0)
			{
				o = first_byte.data;
				first_byte = last_byte = null;
			}
			else if(index == 0)
			{
				o = first_byte.data;
				first_byte = first_byte.next;
				first_byte.prev = null;
			}
			else if(index == (size-1))
			{
				o = last_byte.data;
				last_byte = last_byte.prev;
				last_byte.next = null;
			}
			else
			{
				Node_Byte pointer = first_byte;
				for(long i = 1; i <= index; i++)
				{
					pointer = pointer.next;
				}
				o = pointer.data;
				pointer.prev.next = pointer.next;
				pointer.next.prev = pointer.prev;
			}
			size--;
		}
		else if(choice[2] == ONE)
		{
			if((size-1) == 0)
			{
				o = first_short.data;
				first_short = last_short = null;
			}
			else if(index == 0)
			{
				o = first_short.data;
				first_short = first_short.next;
				first_short.prev = null;
			}
			else if(index == (size-1))
			{
				o = last_short.data;
				last_short = last_short.prev;
				last_short.next = null;
			}
			else
			{
				Node_Short pointer = first_short;
				for(long i = 1; i <= index; i++)
				{
					pointer = pointer.next;
				}
				o = pointer.data;
				pointer.prev.next = pointer.next;
				pointer.next.prev = pointer.prev;
			}
			size--;
		}
		else if(choice[3] == ONE)
		{
			if((size-1) == 0)
			{
				o = first_int.data;
				first_int = last_int = null;
			}
			else if(index == 0)
			{
				o = first_int.data;
				first_int = first_int.next;
				first_int.prev = null;
			}
			else if(index == (size-1))
			{
				o = last_int.data;
				last_int = last_int.prev;
				last_int.next = null;
			}
			else
			{
				Node_Int pointer = first_int;
				for(long i = 1; i <= index; i++)
				{
					pointer = pointer.next;
				}
				o = pointer.data;
				pointer.prev.next = pointer.next;
				pointer.next.prev = pointer.prev;
			}
			size--;
		}
		else if(choice[4] == ONE)
		{
			if((size-1) == 0)
			{
				o = first_long.data;
				first_long = last_long = null;
			}
			else if(index == 0)
			{
				o = first_long.data;
				first_long = first_long.next;
				first_long.prev = null;
			}
			else if(index == (size-1))
			{
				o = last_long.data;
				last_long = last_long.prev;
				last_long.next = null;
			}
			else
			{
				Node_Long pointer = first_long;
				for(long i = 1; i <= index; i++)
				{
					pointer = pointer.next;
				}
				o = pointer.data;
				pointer.prev.next = pointer.next;
				pointer.next.prev = pointer.prev;
			}
			size--;
		}
		else if(choice[5] == ONE)
		{
			if((size-1) == 0)
			{
				o = first_float.data;
				first_float = last_float = null;
			}
			else if(index == 0)
			{
				o = first_float.data;
				first_float = first_float.next;
				first_float.prev = null;
			}
			else if(index == (size-1))
			{
				o = last_float.data;
				last_float = last_float.prev;
				last_float.next = null;
			}
			else
			{
				Node_Float pointer = first_float;
				for(long i = 1; i <= index; i++)
				{
					pointer = pointer.next;
				}
				o = pointer.data;
				pointer.prev.next = pointer.next;
				pointer.next.prev = pointer.prev;
			}
			size--;
		}
		else
		{
			if((size-1) == 0)
			{
				o = first_double.data;
				first_double = last_double = null;
			}
			else if(index == 0)
			{
				o = first_double.data;
				first_double = first_double.next;
				first_double.prev = null;
			}
			else if(index == (size-1))
			{
				o = last_double.data;
				last_double = last_double.prev;
				last_double.next = null;
			}
			else
			{
				Node_Double pointer = first_double;
				for(long i = 1; i <= index; i++)
				{
					pointer = pointer.next;
				}
				o = pointer.data;
				pointer.prev.next = pointer.next;
				pointer.next.prev = pointer.prev;
			}
			size--;
		}
		return o;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this Linked_List(char), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @throws IndexOutOfBoundsException if Linked_List is empty
	 */	
	public synchronized long indexOf(char element) 
	{
		return indexOf(element, 0);
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this Linked_List(byte), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @throws IndexOutOfBoundsException if Linked_List is empty
	 */	
	public synchronized long indexOf(byte element) 
	{
		return indexOf(element, 0);
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this Linked_List(short), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @throws IndexOutOfBoundsException if Linked_List is empty
	 */	
	public synchronized long indexOf(short element) 
	{
		return indexOf(element, 0);
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this Linked_List(int), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @throws IndexOutOfBoundsException if Linked_List is empty
	 */	
	public synchronized long indexOf(int element) 
	{
		return indexOf(element, 0);
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this Linked_List(long), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @throws IndexOutOfBoundsException if Linked_List is empty
	 */	
	public synchronized long indexOf(long element) 
	{
		return indexOf(element, 0);
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this Linked_List(float), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @throws IndexOutOfBoundsException if Linked_List is empty
	 */	
	public synchronized long indexOf(float element) 
	{
		return indexOf(element, 0);
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this Linked_List(double), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @throws IndexOutOfBoundsException if Linked_List is empty
	 */	
	public synchronized long indexOf(double element) 
	{
		return indexOf(element, 0);
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this Linked_List(char), searching forwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this Linked_List at position {@code index} or later in the Linked_List;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long indexOf(char element, long index) 
	{
		choiceCheck(0);
		rangeCheck0(index);
		Node_Char pointer = first_char;
		long i = 0;
		for(; i < index; i++)
		{
			pointer = pointer.next;
		}
		for(; i < size; i++)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.next;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this Linked_List(byte), searching forwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this Linked_List at position {@code index} or later in the Linked_List;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long indexOf(byte element, long index) 
	{
		choiceCheck(1);
		rangeCheck0(index);
		Node_Byte pointer = first_byte;
		long i = 0;
		for(; i < index; i++)
		{
			pointer = pointer.next;
		}
		for(; i < size; i++)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.next;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this Linked_List(short), searching forwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this Linked_List at position {@code index} or later in the Linked_List;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long indexOf(short element, long index) 
	{
		choiceCheck(2);
		rangeCheck0(index);
		Node_Short pointer = first_short;
		long i = 0;
		for(; i < index; i++)
		{
			pointer = pointer.next;
		}
		for(; i < size; i++)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.next;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this Linked_List(int), searching forwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this Linked_List at position {@code index} or later in the Linked_List;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long indexOf(int element, long index) 
	{
		choiceCheck(3);
		rangeCheck0(index);
		Node_Int pointer = first_int;
		long i = 0;
		for(; i < index; i++)
		{
			pointer = pointer.next;
		}
		for(; i < size; i++)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.next;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this Linked_List(long), searching forwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this Linked_List at position {@code index} or later in the Linked_List;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long indexOf(long element, long index) 
	{
		choiceCheck(4);
		rangeCheck0(index);
		Node_Long pointer = first_long;
		long i = 0;
		for(; i < index; i++)
		{
			pointer = pointer.next;
		}
		for(; i < size; i++)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.next;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this Linked_List(float), searching forwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this Linked_List at position {@code index} or later in the Linked_List;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long indexOf(float element, long index) 
	{
		choiceCheck(5);
		rangeCheck0(index);
		Node_Float pointer = first_float;
		long i = 0;
		for(; i < index; i++)
		{
			pointer = pointer.next;
		}
		for(; i < size; i++)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.next;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this Linked_List(double), searching forwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this Linked_List at position {@code index} or later in the Linked_List;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long indexOf(double element, long index) 
	{
		choiceCheck(6);
		rangeCheck0(index);
		Node_Double pointer = first_double;
		long i = 0;
		for(; i < index; i++)
		{
			pointer = pointer.next;
		}
		for(; i < size; i++)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.next;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this Linked_List(char), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @throws IndexOutOfBoundsException if array is empty
	 */
	public synchronized long lastIndexOf(char element)
	{
		return lastIndexOf(element, (size-1));
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this Linked_List(byte), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @throws IndexOutOfBoundsException if array is empty
	 */
	public synchronized long lastIndexOf(byte element)
	{
		return lastIndexOf(element, (size-1));
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this Linked_List(short), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @throws IndexOutOfBoundsException if array is empty
	 */
	public synchronized long lastIndexOf(short element)
	{
		return lastIndexOf(element, (size-1));
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this Linked_List(int), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @throws IndexOutOfBoundsException if array is empty
	 */
	public synchronized long lastIndexOf(int element)
	{
		return lastIndexOf(element, (size-1));
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this Linked_List(long), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @throws IndexOutOfBoundsException if array is empty
	 */
	public synchronized long lastIndexOf(long element)
	{
		return lastIndexOf(element, (size-1));
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this Linked_List(float), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @throws IndexOutOfBoundsException if array is empty
	 */
	public synchronized long lastIndexOf(float element)
	{
		return lastIndexOf(element, (size-1));
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this Linked_List(double), or -1 if this Linked_List does not contain the element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this Linked_List, or -1 if this Linked_List does not contain the element
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @throws IndexOutOfBoundsException if array is empty
	 */
	public synchronized long lastIndexOf(double element)
	{
		return lastIndexOf(element, (size-1));
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this Linked_List(char), searching backwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this Linked_List;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long lastIndexOf(char element, long index) 
	{
		choiceCheck(0);
		rangeCheck0(index);
		Node_Char pointer = last_char;
		long i = (size - 1);
		for(; i > index; i--)
		{
			pointer = pointer.prev;
		}
		for(; i > -1; i--)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.prev;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this Linked_List(byte), searching backwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this Linked_List;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long lastIndexOf(byte element, long index) 
	{
		choiceCheck(1);
		rangeCheck0(index);
		Node_Byte pointer = last_byte;
		long i = (size - 1);
		for(; i > index; i--)
		{
			pointer = pointer.prev;
		}
		for(; i > -1; i--)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.prev;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this Linked_List(short), searching backwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this Linked_List;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long lastIndexOf(short element, long index) 
	{
		choiceCheck(2);
		rangeCheck0(index);
		Node_Short pointer = last_short;
		long i = (size - 1);
		for(; i > index; i--)
		{
			pointer = pointer.prev;
		}
		for(; i > -1; i--)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.prev;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this Linked_List(int), searching backwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this Linked_List;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long lastIndexOf(int element, long index) 
	{
		choiceCheck(3);
		rangeCheck0(index);
		Node_Int pointer = last_int;
		long i = (size - 1);
		for(; i > index; i--)
		{
			pointer = pointer.prev;
		}
		for(; i > -1; i--)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.prev;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this Linked_List(long), searching backwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this Linked_List;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long lastIndexOf(long element, long index) 
	{
		choiceCheck(4);
		rangeCheck0(index);
		Node_Long pointer = last_long;
		long i = (size - 1);
		for(; i > index; i--)
		{
			pointer = pointer.prev;
		}
		for(; i > -1; i--)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.prev;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this Linked_List(float), searching backwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this Linked_List;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long lastIndexOf(float element, long index) 
	{
		choiceCheck(5);
		rangeCheck0(index);
		Node_Float pointer = last_float;
		long i = (size - 1);
		for(; i > index; i--)
		{
			pointer = pointer.prev;
		}
		for(; i > -1; i--)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.prev;
		}
		return -1;
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this Linked_List(double), searching backwards from {@code index}, or returns -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this Linked_List;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized long lastIndexOf(double element, long index) 
	{
		choiceCheck(6);
		rangeCheck0(index);
		Node_Double pointer = last_double;
		long i = (size - 1);
		for(; i > index; i--)
		{
			pointer = pointer.prev;
		}
		for(; i > -1; i--)
		{
			if(pointer.data == element)
			{
				return i;
			}
			pointer = pointer.prev;
		}
		return -1;
	}
	
	/**
	 * Removes the first occurrence of the specified element in this Linked_List(char)
	 * If the Linked_List does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this Linked_List, if present
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @return true if the Linked_List contained the specified element; else false
	 */
	public synchronized boolean remove(char element)
	{
		choiceCheck(0);
		if(isEmpty())
		{
			return false;
		}
		if((size-1) == 0)
		{
			if(first_char.data == element)
			{
				first_char = last_char = null;
				size--;
				return true;
			}
		}
		else
		{
			for(Node_Char pointer = first_char; pointer != null; pointer = pointer.next)
			{
				if(pointer.data == element)
				{
					size--;
					if(pointer == first_char)
					{
						first_char = first_char.next;
						first_char.prev = null;
						return true;
					}
					else if(pointer == last_char)
					{
						last_char = last_char.prev;
						last_char.next = null;
						return true;
					}
					else
					{
						pointer.prev.next = pointer.next;
						pointer.next.prev = pointer.prev;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Removes the first occurrence of the specified element in this Linked_List(byte)
	 * If the Linked_List does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this Linked_List, if present
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @return true if the Linked_List contained the specified element; else false
	 */
	public synchronized boolean remove(byte element)
	{
		choiceCheck(1);
		if(isEmpty())
		{
			return false;
		}
		if((size-1) == 0)
		{
			if(first_byte.data == element)
			{
				first_byte = last_byte = null;
				size--;
				return true;
			}
		}
		else
		{
			for(Node_Byte pointer = first_byte; pointer != null; pointer = pointer.next)
			{
				if(pointer.data == element)
				{
					size--;
					if(pointer == first_byte)
					{
						first_byte = first_byte.next;
						first_byte.prev = null;
						return true;
					}
					else if(pointer == last_byte)
					{
						last_byte = last_byte.prev;
						last_byte.next = null;
						return true;
					}
					else
					{
						pointer.prev.next = pointer.next;
						pointer.next.prev = pointer.prev;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Removes the first occurrence of the specified element in this Linked_List(short)
	 * If the Linked_List does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this Linked_List, if present
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @return true if the Linked_List contained the specified element; else false
	 */
	public synchronized boolean remove(short element)
	{
		choiceCheck(2);
		if(isEmpty())
		{
			return false;
		}
		if((size-1) == 0)
		{
			if(first_short.data == element)
			{
				first_short = last_short = null;
				size--;
				return true;
			}
		}
		else
		{
			for(Node_Short pointer = first_short; pointer != null; pointer = pointer.next)
			{
				if(pointer.data == element)
				{
					size--;
					if(pointer == first_short)
					{
						first_short = first_short.next;
						first_short.prev = null;
						return true;
					}
					else if(pointer == last_short)
					{
						last_short = last_short.prev;
						last_short.next = null;
						return true;
					}
					else
					{
						pointer.prev.next = pointer.next;
						pointer.next.prev = pointer.prev;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Removes the first occurrence of the specified element in this Linked_List(int)
	 * If the Linked_List does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this Linked_List, if present
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @return true if the Linked_List contained the specified element; else false
	 */
	public synchronized boolean remove(int element)
	{
		choiceCheck(3);
		if(isEmpty())
		{
			return false;
		}
		if((size-1) == 0)
		{
			if(first_int.data == element)
			{
				first_int = last_int = null;
				size--;
				return true;
			}
		}
		else
		{
			for(Node_Int pointer = first_int; pointer != null; pointer = pointer.next)
			{
				if(pointer.data == element)
				{
					size--;
					if(pointer == first_int)
					{
						first_int = first_int.next;
						first_int.prev = null;
						return true;
					}
					else if(pointer == last_int)
					{
						last_int = last_int.prev;
						last_int.next = null;
						return true;
					}
					else
					{
						pointer.prev.next = pointer.next;
						pointer.next.prev = pointer.prev;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Removes the first occurrence of the specified element in this Linked_List(long)
	 * If the Linked_List does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this Linked_List, if present
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @return true if the Linked_List contained the specified element; else false
	 */
	public synchronized boolean remove(long element)
	{
		choiceCheck(4);
		if(isEmpty())
		{
			return false;
		}
		if((size-1) == 0)
		{
			if(first_long.data == element)
			{
				first_long = last_long = null;
				size--;
				return true;
			}
		}
		else
		{
			for(Node_Long pointer = first_long; pointer != null; pointer = pointer.next)
			{
				if(pointer.data == element)
				{
					size--;
					if(pointer == first_long)
					{
						first_long = first_long.next;
						first_long.prev = null;
						return true;
					}
					else if(pointer == last_long)
					{
						last_long = last_long.prev;
						last_long.next = null;
						return true;
					}
					else
					{
						pointer.prev.next = pointer.next;
						pointer.next.prev = pointer.prev;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Removes the first occurrence of the specified element in this Linked_List(float)
	 * If the Linked_List does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this Linked_List, if present
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @return true if the Linked_List contained the specified element; else false
	 */
	public synchronized boolean remove(float element)
	{
		choiceCheck(5);
		if(isEmpty())
		{
			return false;
		}
		if((size-1) == 0)
		{
			if(first_float.data == element)
			{
				first_float = last_float = null;
				size--;
				return true;
			}
		}
		else
		{
			for(Node_Float pointer = first_float; pointer != null; pointer = pointer.next)
			{
				if(pointer.data == element)
				{
					size--;
					if(pointer == first_float)
					{
						first_float = first_float.next;
						first_float.prev = null;
						return true;
					}
					else if(pointer == last_float)
					{
						last_float = last_float.prev;
						last_float.next = null;
						return true;
					}
					else
					{
						pointer.prev.next = pointer.next;
						pointer.next.prev = pointer.prev;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Removes the first occurrence of the specified element in this Linked_List(double)
	 * If the Linked_List does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this Linked_List, if present
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @return true if the Linked_List contained the specified element; else false
	 */
	public synchronized boolean remove(double element)
	{
		choiceCheck(6);
		if(isEmpty())
		{
			return false;
		}
		if((size-1) == 0)
		{
			if(first_double.data == element)
			{
				first_double = last_double = null;
				size--;
				return true;
			}
		}
		else
		{
			for(Node_Double pointer = first_double; pointer != null; pointer = pointer.next)
			{
				if(pointer.data == element)
				{
					size--;
					if(pointer == first_double)
					{
						first_double = first_double.next;
						first_double.prev = null;
						return true;
					}
					else if(pointer == last_double)
					{
						last_double = last_double.prev;
						last_double.next = null;
						return true;
					}
					else
					{
						pointer.prev.next = pointer.next;
						pointer.next.prev = pointer.prev;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Tests if this Linked_List has no components.
	 *
	 * @return  {@code true} if and only if this Linked_List has
	 *          no components, that is, its size is zero;
	 *          {@code false} otherwise.
	 */	
	public synchronized boolean isEmpty() 
	{
		return size == 0;
	}
	
	/**
	 * Returns {@code true} if this Linked_List(char) contains the specified element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this Linked_List is to be tested
	 * @return {@code true} if this Linked_List contains the specified element; else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 */
	public synchronized boolean contains(char element) 
	{
		choiceCheck(0);
		for(Node_Char pointer = first_char; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == element)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns {@code true} if this Linked_List(byte) contains the specified element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this Linked_List is to be tested
	 * @return {@code true} if this Linked_List contains the specified element; else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 */
	public synchronized boolean contains(byte element) 
	{
		choiceCheck(1);
		for(Node_Byte pointer = first_byte; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == element)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns {@code true} if this Linked_List(short) contains the specified element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this Linked_List is to be tested
	 * @return {@code true} if this Linked_List contains the specified element; else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 */
	public synchronized boolean contains(short element) 
	{
		choiceCheck(2);
		for(Node_Short pointer = first_short; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == element)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns {@code true} if this Linked_List(int) contains the specified element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this Linked_List is to be tested
	 * @return {@code true} if this Linked_List contains the specified element; else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 */
	public synchronized boolean contains(int element) 
	{
		choiceCheck(3);
		for(Node_Int pointer = first_int; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == element)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns {@code true} if this Linked_List(long) contains the specified element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this Linked_List is to be tested
	 * @return {@code true} if this Linked_List contains the specified element; else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 */
	public synchronized boolean contains(long element) 
	{
		choiceCheck(4);
		for(Node_Long pointer = first_long; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == element)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns {@code true} if this Linked_List(float) contains the specified element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this Linked_List is to be tested
	 * @return {@code true} if this Linked_List contains the specified element; else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 */
	public synchronized boolean contains(float element) 
	{
		choiceCheck(5);
		for(Node_Float pointer = first_float; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == element)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns {@code true} if this Linked_List(double) contains the specified element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this Linked_List is to be tested
	 * @return {@code true} if this Linked_List contains the specified element; else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 */
	public synchronized boolean contains(double element) 
	{
		choiceCheck(6);
		for(Node_Double pointer = first_double; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == element)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this Linked_List(char).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)} 
	 * @return {@code true} if atleast one {@code oldElement} element is replaces with {@code newElement}
	 */
	public synchronized boolean replace(char oldElement, char newElement) 
	{
		choiceCheck(0);
		if(isEmpty())
		{
			return false;
		}
		boolean flag = false;
		for(Node_Char pointer = first_char; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == oldElement)
			{
				flag = true;
				pointer.data = newElement;
			}
		}
		return flag;
	}
	
	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this Linked_List(byte).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)} 
	 * @return {@code true} if atleast one {@code oldElement} element is replaces with {@code newElement}
	 */
	public synchronized boolean replace(byte oldElement, byte newElement) 
	{
		choiceCheck(1);
		if(isEmpty())
		{
			return false;
		}
		boolean flag = false;
		for(Node_Byte pointer = first_byte; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == oldElement)
			{
				flag = true;
				pointer.data = newElement;
			}
		}
		return flag;
	}
	
	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this Linked_List(short).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)} 
	 * @return {@code true} if atleast one {@code oldElement} element is replaces with {@code newElement}
	 */
	public synchronized boolean replace(short oldElement, short newElement) 
	{
		choiceCheck(2);
		if(isEmpty())
		{
			return false;
		}
		boolean flag = false;
		for(Node_Short pointer = first_short; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == oldElement)
			{
				flag = true;
				pointer.data = newElement;
			}
		}
		return flag;
	}
	
	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this Linked_List(int).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)} 
	 * @return {@code true} if atleast one {@code oldElement} element is replaces with {@code newElement}
	 */
	public synchronized boolean replace(int oldElement, int newElement) 
	{
		choiceCheck(3);
		if(isEmpty())
		{
			return false;
		}
		boolean flag = false;
		for(Node_Int pointer = first_int; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == oldElement)
			{
				flag = true;
				pointer.data = newElement;
			}
		}
		return flag;
	}
	
	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this Linked_List(long).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)} 
	 * @return {@code true} if atleast one {@code oldElement} element is replaces with {@code newElement}
	 */
	public synchronized boolean replace(long oldElement, long newElement) 
	{
		choiceCheck(4);
		if(isEmpty())
		{
			return false;
		}
		boolean flag = false;
		for(Node_Long pointer = first_long; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == oldElement)
			{
				flag = true;
				pointer.data = newElement;
			}
		}
		return flag;
	}
	
	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this Linked_List(float).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)} 
	 * @return {@code true} if atleast one {@code oldElement} element is replaces with {@code newElement}
	 */
	public synchronized boolean replace(float oldElement, float newElement) 
	{
		choiceCheck(5);
		if(isEmpty())
		{
			return false;
		}
		boolean flag = false;
		for(Node_Float pointer = first_float; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == oldElement)
			{
				flag = true;
				pointer.data = newElement;
			}
		}
		return flag;
	}
	
	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this Linked_List(double).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)} 
	 * @return {@code true} if atleast one {@code oldElement} element is replaces with {@code newElement}
	 */
	public synchronized boolean replace(double oldElement, double newElement) 
	{
		choiceCheck(6);
		if(isEmpty())
		{
			return false;
		}
		boolean flag = false;
		for(Node_Double pointer = first_double; pointer != null; pointer = pointer.next)
		{
			if(pointer.data == oldElement)
			{
				flag = true;
				pointer.data = newElement;
			}
		}
		return flag;
	}
	
	/**
	 * Replace value at {@code index}, with the {@code newElement} in this Linked_List(char).
	 *
	 * @param newElement the new element
	 * @param index index at which element is to be placed
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(char newElement, long index) 
	{
		choiceCheck(0);
		rangeCheck0(index);
		long i = 0;
		for(Node_Char pointer = first_char; pointer != null; pointer = pointer.next, i++)
		{
			if(i == index)
			{
				pointer.data = newElement;
			}
		}
	}
	
	/**
	 * Replace value at {@code index}, with the {@code newElement} in this Linked_List(byte).
	 *
	 * @param newElement the new element
	 * @param index index at which element is to be placed
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(byte newElement, long index) 
	{
		choiceCheck(1);
		rangeCheck0(index);
		long i = 0;
		for(Node_Byte pointer = first_byte; pointer != null; pointer = pointer.next, i++)
		{
			if(i == index)
			{
				pointer.data = newElement;
			}
		}
	}
	
	/**
	 * Replace value at {@code index}, with the {@code newElement} in this Linked_List(short).
	 *
	 * @param newElement the new element
	 * @param index index at which element is to be placed
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(short newElement, long index) 
	{
		choiceCheck(2);
		rangeCheck0(index);
		long i = 0;
		for(Node_Short pointer = first_short; pointer != null; pointer = pointer.next, i++)
		{
			if(i == index)
			{
				pointer.data = newElement;
			}
		}
	}
	
	/**
	 * Replace value at {@code index}, with the {@code newElement} in this Linked_List(int).
	 *
	 * @param newElement the new element
	 * @param index index at which element is to be placed
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(int newElement, long index) 
	{
		choiceCheck(3);
		rangeCheck0(index);
		long i = 0;
		for(Node_Int pointer = first_int; pointer != null; pointer = pointer.next, i++)
		{
			if(i == index)
			{
				pointer.data = newElement;
			}
		}
	}
	
	/**
	 * Replace value at {@code index}, with the {@code newElement} in this Linked_List(long).
	 *
	 * @param newElement the new element
	 * @param index index at which element is to be placed
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(long newElement, long index) 
	{
		choiceCheck(4);
		rangeCheck0(index);
		long i = 0;
		for(Node_Long pointer = first_long; pointer != null; pointer = pointer.next, i++)
		{
			if(i == index)
			{
				pointer.data = newElement;
			}
		}
	}
	
	/**
	 * Replace value at {@code index}, with the {@code newElement} in this Linked_List(float).
	 *
	 * @param newElement the new element
	 * @param index index at which element is to be placed
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(float newElement, long index) 
	{
		choiceCheck(5);
		rangeCheck0(index);
		long i = 0;
		for(Node_Float pointer = first_float; pointer != null; pointer = pointer.next, i++)
		{
			if(i == index)
			{
				pointer.data = newElement;
			}
		}
	}
	
	/**
	 * Replace value at {@code index}, with the {@code newElement} in this Linked_List(double).
	 *
	 * @param newElement the new element
	 * @param index index at which element is to be placed
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(double newElement, long index) 
	{
		choiceCheck(6);
		rangeCheck0(index);
		long i = 0;
		for(Node_Double pointer = first_double; pointer != null; pointer = pointer.next, i++)
		{
			if(i == index)
			{
				pointer.data = newElement;
			}
		}
	}
	
	/**
	 * Sorts this Linked_List according to the order specified by the character {@code c}.<br>
	 *
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public synchronized void sort(char c)
	{
		if (choice[0] == ONE)
		{
			sort(0, (int)size, c);
		}
		else if(choice[1] == ONE)
		{
			sort(0, (int)size, c);
		}
		else if(choice[2] == ONE)
		{
			sort(0, (int)size, c);
		}
		else if(choice[3] == ONE)
		{
			sort(0, (int)size, c);
		}
		else if(choice[4] == ONE)
		{
			sort(0, (int)size, c);
		}
		else if(choice[5] == ONE)
		{
			sort(0, (int)size, c);
		}
		else
		{
			sort(0, (int)size, c);
		}
	}
	
	/**
	 * Sorts this Linked_List according to the order specified by the character {@code c}.<br>
	 *
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending order,
	 *			{@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex the index of the last element, exclusive, to be sorted
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 * @throws IllegalArgumentException {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > array.length)}
	 */
	public synchronized void sort(int fromIndex, int toIndex, char c)
	{
		if (choice[0] == ONE)
		{
			if(c == 'a' || c == 'A')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex);
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((char)o[i]);
				}
			}
			else if (c == 'd' || c == 'D')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex, Collections.reverseOrder());
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((char)o[i]);
				}
			}
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
		else if(choice[1] == ONE)
		{
			if(c == 'a' || c == 'A')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex);
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((byte)o[i]);
				}
			}
			else if (c == 'd' || c == 'D')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex, Collections.reverseOrder());
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((byte)o[i]);
				}
			}
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
		else if(choice[2] == ONE)
		{
			if(c == 'a' || c == 'A')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex);
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((short)o[i]);
				}
			}
			else if (c == 'd' || c == 'D')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex, Collections.reverseOrder());
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((short)o[i]);
				}
			}
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
		else if(choice[3] == ONE)
		{
			if(c == 'a' || c == 'A')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex);
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((int)o[i]);
				}
			}
			else if (c == 'd' || c == 'D')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex, Collections.reverseOrder());
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((int)o[i]);
				}
			}
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
		else if(choice[4] == ONE)
		{
			if(c == 'a' || c == 'A')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex);
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((long)o[i]);
				}
			}
			else if (c == 'd' || c == 'D')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex, Collections.reverseOrder());
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((long)o[i]);
				}
			}
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
		else if(choice[5] == ONE)
		{
			if(c == 'a' || c == 'A')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex);
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((float)o[i]);
				}
			}
			else if (c == 'd' || c == 'D')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex, Collections.reverseOrder());
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((float)o[i]);
				}
			}
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
		else
		{
			if(c == 'a' || c == 'A')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex);
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((double)o[i]);
				}
			}
			else if (c == 'd' || c == 'D')
			{
				Object[] o = toArray();
				Arrays.sort(o, fromIndex, toIndex, Collections.reverseOrder());
				clear();
				for(int i = 0; i < o.length ; i++)
				{
					add((double)o[i]);
				}
			}
			else
			{
				throw new IllegalArgumentException("Invalid choice \'" + c + 
				"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}
	
	/**
	 * Returns the element at the specified position in this Linked_List.
	 *
	 * @param index index of the element to return
	 * @return object at the specified index
	 * @throws IndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */	
	public synchronized Object get(long index) 
	{
		rangeCheck0(index);
		long temp = 0;
		if (choice[0] == ONE)
		{
			for(Node_Char pointer = first_char; pointer != null; pointer = pointer.next, temp++)
			{
				if(index == temp)
				{
					return (Object)pointer.data;
				}
			}
		}
		else if(choice[1] == ONE)
		{
			for(Node_Byte pointer = first_byte; pointer != null; pointer = pointer.next, temp++)
			{
				if(index == temp)
				{
					return (Object)pointer.data;
				}
			}
		}
		else if(choice[2] == ONE)
		{
			for(Node_Short pointer = first_short; pointer != null; pointer = pointer.next, temp++)
			{
				if(index == temp)
				{
					return (Object)pointer.data;
				}
			}
		}
		else if(choice[3] == ONE)
		{
			for(Node_Int pointer = first_int; pointer != null; pointer = pointer.next, temp++)
			{
				if(index == temp)
				{
					return (Object)pointer.data;
				}
			}
		}
		else if(choice[4] == ONE)
		{
			for(Node_Long pointer = first_long; pointer != null; pointer = pointer.next, temp++)
			{
				if(index == temp)
				{
					return (Object)pointer.data;
				}
			}
		}
		else if(choice[5] == ONE)
		{
			for(Node_Float pointer = first_float; pointer != null; pointer = pointer.next, temp++)
			{
				if(index == temp)
				{
					return (Object)pointer.data;
				}
			}
		}
		else
		{
			for(Node_Double pointer = first_double; pointer != null; pointer = pointer.next, temp++)
			{
				if(index == temp)
				{
					return (Object)pointer.data;
				}
			}
		}
		return null;
	}	
	
	/**
	 * Returns the first component (the item at index {@code 0}) of
	 * the Linked_List.
	 *
	 * @return {@code null} if Linked_List is empty, else the first component of the Linked_List
	 */	
	public synchronized Object firstElement() 
	{
		if(isEmpty())
		{
			return null;
		}
		if (choice[0] == ONE)
		{
			return (Object)first_char.data;
		}
		else if(choice[1] == ONE)
		{
			return (Object)first_byte.data;
		}
		else if(choice[2] == ONE)
		{
			return (Object)first_short.data;
		}
		else if(choice[3] == ONE)
		{
			return (Object)first_int.data;
		}
		else if(choice[4] == ONE)
		{
			return (Object)first_long.data;
		}
		else if(choice[5] == ONE)
		{
			return (Object)first_float.data;
		}
		else
		{
			return (Object)first_double.data;
		}
	}
	
	/**
	 * Returns the last component of the Linked_List.
	 *
	 * @return {@code null} if Linked_List is empty, else the last component of the Linked_List
	 */
	public synchronized Object lastElement() 
	{
		if(isEmpty())
		{
			return null;
		}
		if (choice[0] == ONE)
		{
			return (Object)last_char.data;
		}
		else if(choice[1] == ONE)
		{
			return (Object)last_byte.data;
		}
		else if(choice[2] == ONE)
		{
			return (Object)last_short.data;
		}
		else if(choice[3] == ONE)
		{
			return (Object)last_int.data;
		}
		else if(choice[4] == ONE)
		{
			return (Object)last_long.data;
		}
		else if(choice[5] == ONE)
		{
			return (Object)last_float.data;
		}
		else
		{
			return (Object)last_double.data;
		}
	}
	
	/**
	 * Removes all of the elements from this Linked_List.  The Linked_List will
	 * be empty after this call returns (unless it throws an exception).
	 */	
	public synchronized void clear() 
	{
		size = 0;
		if (choice[0] == ONE)
		{
			first_char = null;
			last_char = null;
		}
		else if(choice[1] == ONE)
		{
			first_byte = null;
			last_byte = null;
		}
		else if(choice[2] == ONE)
		{
			first_short = null;
			last_short = null;
		}
		else if(choice[3] == ONE)
		{	
			first_int = null;
			last_int = null;
		}
		else if(choice[4] == ONE)
		{
			first_long = null;
			last_long = null;
		}
		else if(choice[5] == ONE)
		{
			first_float = null;
			last_float = null;
		}
		else
		{
			first_double = null;
			last_double = null;
		}
	}
	
	/**
	 * Returns the number of components in this Linked_List.
	 *
	 * @return the number of components in this Linked_List
	 */	
	public synchronized long size() 
	{
		return size;
	}
	
	/**
	 * Returns an array containing all of the elements in this Linked_List.
	 * 
	 * <p>The returned array will be "safe" in that no references to it are
	 * maintained by the Linked_List.  (In other words, this method must allocate
	 * a new array). The caller is thus free to modify the returned array.</p>
	 * 
	 * @return an array containing all of the elements in this Linked_List
	 */
	public synchronized Object[] toArray()
	{
		Object[] o = new Object[(int)size];
		int i = 0;
		if (choice[0] == ONE)
		{
			for(Node_Char pointer = first_char; pointer != null; pointer = pointer.next)
			{
				o[i++] = pointer.data;
			}
		}
		else if(choice[1] == ONE)
		{
			for(Node_Byte pointer = first_byte; pointer != null; pointer = pointer.next)
			{
				o[i++] = pointer.data;
			}
		}
		else if(choice[2] == ONE)
		{
			for(Node_Short pointer = first_short; pointer != null; pointer = pointer.next)
			{
				o[i++] = pointer.data;
			}
		}
		else if(choice[3] == ONE)
		{
			for(Node_Int pointer = first_int; pointer != null; pointer = pointer.next)
			{
				o[i++] = pointer.data;
			}
		}
		else if(choice[4] == ONE)
		{
			for(Node_Long pointer = first_long; pointer != null; pointer = pointer.next)
			{
				o[i++] = pointer.data;
			}
		}
		else if(choice[5] == ONE)
		{
			for(Node_Float pointer = first_float; pointer != null; pointer = pointer.next)
			{
				o[i++] = pointer.data;
			}
		}
		else
		{
			for(Node_Double pointer = first_double; pointer != null; pointer = pointer.next)
			{
				o[i++] = pointer.data;
			}
		}
		return o;
	}
	
	/**
	 * Returns a string representation of the Linked_List, enclosed in a square brackets ("[]")
	 * and separated by comma and a space(", "). 
	 *
	 * @return a string representation of this Linked_List
	 */
	@Override
	public synchronized String toString()
	{
		if(size == 0)
		{
			return "[]";
		}
		StringBuilder str = new StringBuilder(java.lang.Math.abs((3*(int)size) + 2));
		str.append("[");
		if (choice[0] == ONE)
		{
			Node_Char pointer = first_char;
			for( ; pointer.next != null; pointer = pointer.next)
			{
				str.append(pointer.data + ", ");
			}
			str.append(pointer.data + "]");
		}
		else if (choice[1] == ONE)
		{
			Node_Byte pointer = first_byte;
			for( ; pointer.next != null; pointer = pointer.next)
			{
				str.append(pointer.data + ", ");
			}
			str.append(pointer.data + "]");
		}
		else if (choice[2] == ONE)
		{
			Node_Short pointer = first_short;
			for( ; pointer.next != null; pointer = pointer.next)
			{
				str.append(pointer.data + ", ");
			}
			str.append(pointer.data + "]");
		}
		else if (choice[3] == ONE)
		{
			Node_Int pointer = first_int;
			for( ; pointer.next != null; pointer = pointer.next)
			{
				str.append(pointer.data + ", ");
			}
			str.append(pointer.data + "]");
		}
		else if (choice[4] == ONE)
		{
			Node_Long pointer = first_long;
			for( ; pointer.next != null; pointer = pointer.next)
			{
				str.append(pointer.data + ", ");
			}
			str.append(pointer.data + "]");
		}
		else if (choice[5] == ONE)
		{
			Node_Float pointer = first_float;
			for( ; pointer.next != null; pointer = pointer.next)
			{
				str.append(pointer.data + ", ");
			}
			str.append(pointer.data + "]");
		}
		else if (choice[6] == ONE)
		{
			Node_Double pointer = first_double;
			for( ; pointer.next != null; pointer = pointer.next)
			{
				str.append(pointer.data + ", ");
			}
			str.append(pointer.data + "]");
		}
		return str.toString();
	}
}