package dsa.datastructures.list;

import dsa.algorithms.search.LinearSearch;
import java.util.Arrays;

/**
 * The {@code DynamicArray} class contains components that can be accessed using
 * an integer index.
 * However, the size of a {@code DynamicArray} can grow or shrink as needed to
 * accommodate
 * adding and removing items after the {@code DynamicArray} has been created.
 *
 * <p>
 * Each DynamicArray tries to optimize storage management by maintaining a
 * {@code capacity} and a {@code capacityIncrement}. The
 * {@code capacity} is always at least as large as the DynamicArray
 * size; it is usually larger because as components are added to the
 * DynamicArray, the DynamicArray's storage increases in chunks the size of
 * {@code capacityIncrement}. An application can increase the
 * capacity of a DynamicArray before inserting a large number of
 * components; this reduces the amount of incremental reallocation.
 * </p>
 *
 * <p>
 * {@code DynamicArray} is <b>thread-safe</b> and is implemented for
 * <b>primitive types</b> only.
 * </p>
 * 
 * <table style = "border: 1px solid black; border-collapse: collapse;" summary=
 * "Time complexity">
 * <tr>
 * <th style = "border: 1px solid black; padding: 15px;"></th>
 * <th style = "border: 1px solid black; padding: 15px;">Time
 * Complexity(Best)</th>
 * <th style = "border: 1px solid black; padding: 15px;">Time
 * Complexity(Average)</th>
 * <th style = "border: 1px solid black; padding: 15px;">Time
 * Complexity(Worst)</th>
 * </tr>
 * <tr>
 * <th style = "border: 1px solid black; padding: 15px;">Insert(add)</th>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#937;(1)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#952;(n)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">O(n)</td>
 * </tr>
 * <tr>
 * <th style = "border: 1px solid black; padding: 15px;">Delete(remove)</th>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#937;(1)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#952;(n)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">O(n)</td>
 * </tr>
 * <tr>
 * <th style = "border: 1px solid black; padding: 15px;">Random Access(get)</th>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#937;(1)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#952;(1)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">O(1)</td>
 * </tr>
 * <tr>
 * <th style = "border: 1px solid black; padding: 15px;">Search(contains)</th>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#937;(1)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#952;(n/2)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">O(n)</td>
 * </tr>
 * <tr>
 * <th style = "border: 1px solid black; padding: 15px;">Sort(sort)</th>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#937;(n)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">&#952;(n logn)</td>
 * <td style = "border: 1px solid black; text-align: center; padding:
 * 15px;">O(n<sup STYLE="font-size:8.0pt">2</sup>)</td>
 * </tr>
 * </table>
 *
 * @author Sathvik
 * @version 1.0
 */
public class DynamicArray {

	/**
	 * {@code capacity} is the actual capacity of dynamic array.
	 * Default capacity is {@code 11} if not specified.
	 */
	private int capacity;

	/**
	 * The amount by which the capacity of the {@code DynamicArray} is automatically
	 * incremented when its size becomes greater than or equal to its capacity.
	 * If {@code capacityIncrement} is not specified then incrementation is
	 * {@code capacity += (capacity/2) + 1}.
	 * If {@code capacityIncrement} is specified then incrementation is
	 * {@code capacity += capacityIncrement}.
	 */
	private int capacityIncrement;

	/**
	 * {@code end} holds the last index of {@code DynamicArray}.
	 */
	private int end = 0;

	/**
	 * char array
	 */
	private char[] _char_;

	/**
	 * byte array
	 */
	private byte[] _byte_;

	/**
	 * short array
	 */
	private short[] _short_;

	/**
	 * int array
	 */
	private int[] _int_;

	/**
	 * long array
	 */
	private long[] _long_;

	/**
	 * float array
	 */
	private float[] _float_;

	/**
	 * double array
	 */
	private double[] _double_;

	/**
	 * It is the array representaion of choices and their corresponding values. <br>
	 * choice[0] = char <br>
	 * choice[1] = byte <br>
	 * choice[2] = short <br>
	 * choice[3] = int <br>
	 * choice[4] = long <br>
	 * choice[5] = float <br>
	 * choice[6] = double <br>
	 * <br>
	 * ex - choice = {0, 0, 0, 1, 0, 0, 0}; //choice is int
	 */
	private byte[] choice = { 0, 0, 0, 0, 0, 0, 0 };

	private final byte ONE = 1;

	/**
	 * Constructs an array according to choice specified, with the initial
	 * capacity of {@code 11} and capacity increment of
	 * {@code capacity += (capacity/2) + 1}.<br>
	 *
	 * @param choice
	 * 
	 *               <pre style="display:
	 *               inline;">{@code if(choice.equals("char"))} then _char_ is initialized.
	 *	 {@code if(choice.equals("byte"))} then _byte_ is initialized.
	 *	 {@code if(choice.equals("short"))} then _short_ is initialized.
	 *	 {@code if(choice.equals("int"))} then _int_ is initialized.
	 *	 {@code if(choice.equals("long"))} then _long_ is initialized.
	 *	 {@code if(choice.equals("float"))} then _float_ is initialized.
	 *	 {@code if(choice.equals("double"))} then _double_ is initialized.</pre>
	 *
	 * @throws NullPointerException     {@code if(choice == null)}
	 * @throws IllegalArgumentException
	 * 
	 *                                  <pre style="display:
	 *                                  inline;">{@code if(!choice.equals("char") &&
	 *	 				!choice.equals("byte") && 
	 *	 				!choice.equals("short") && 
	 *	 				!choice.equals("int") && 
	 *	 				!choice.equals("long") && 
	 *	 				!choice.equals("float") && 
	 *	 				!choice.equals("double"))}</pre>
	 */
	public DynamicArray(String choice) {
		this(11, choice);
	}

	/**
	 * Constructs an array according to choice specified, with the specified
	 * initial capacity and capacity increment of
	 * {@code capacity += (capacity/2) + 1}.<br>
	 *
	 * @param choice
	 * 
	 *                        <pre style="display:
	 *                        inline;">{@code if(choice.equals("char"))} then _char_ is initialized.
	 *	 {@code if(choice.equals("byte"))} then _byte_ is initialized.
	 *	 {@code if(choice.equals("short"))} then _short_ is initialized.
	 *	 {@code if(choice.equals("int"))} then _int_ is initialized.
	 *	 {@code if(choice.equals("long"))} then _long_ is initialized.
	 *	 {@code if(choice.equals("float"))} then _float_ is initialized.
	 *	 {@code if(choice.equals("double"))} then _double_ is initialized.</pre>
	 * 
	 * @param initialCapacity the initial capacity of the DynamicArray
	 *
	 * @throws IllegalArgumentException {@code if(initialCapacity < 0)}
	 * @throws NullPointerException     {@code if(choice == null)}
	 * @throws IllegalArgumentException
	 * 
	 *                                  <pre style="display:
	 *                                  inline;">{@code if(!choice.equals("char") &&
	 *	 				!choice.equals("byte") && 
	 *	 				!choice.equals("short") && 
	 *	 				!choice.equals("int") && 
	 *	 				!choice.equals("long") && 
	 *	 				!choice.equals("float") && 
	 *	 				!choice.equals("double"))}</pre>
	 */
	public DynamicArray(int initialCapacity, String choice) {
		this(initialCapacity, 1, choice);
		capacityIncrement = -1;
	}

	/**
	 * Constructs an array according to choice specified, with the specified
	 * initial capacity and specified capacity increment of
	 * {@code capacity += capacityIncrement}.<br>
	 *
	 * @param choice
	 * 
	 *                          <pre style="display:
	 *                          inline;">{@code if(choice.equals("char"))} then _char_ is initialized.
	 *	 {@code if(choice.equals("byte"))} then _byte_ is initialized.
	 *	 {@code if(choice.equals("short"))} then _short_ is initialized.
	 *	 {@code if(choice.equals("int"))} then _int_ is initialized.
	 *	 {@code if(choice.equals("long"))} then _long_ is initialized.
	 *	 {@code if(choice.equals("float"))} then _float_ is initialized.
	 *	 {@code if(choice.equals("double"))} then _double_ is initialized.</pre>
	 * 
	 * @param initialCapacity   the initial capacity of the DynamicArray
	 * @param capacityIncrement the amount by which the capacity is
	 *                          increased when the DynamicArray overflows
	 *
	 * @throws IllegalArgumentException {@code if(initialCapacity < 0)}
	 * @throws IllegalArgumentException {@code if(capacityIncrement < 1)}
	 * @throws NullPointerException     {@code if(choice == null)}
	 * @throws IllegalArgumentException
	 * 
	 *                                  <pre style="display:
	 *                                  inline;">{@code if(!choice.equals("char") &&
	 *	 				!choice.equals("byte") && 
	 *	 				!choice.equals("short") && 
	 *	 				!choice.equals("int") && 
	 *	 				!choice.equals("long") && 
	 *	 				!choice.equals("float") && 
	 *	 				!choice.equals("double"))}</pre>
	 */
	public DynamicArray(int initialCapacity, int capacityIncrement, String choice) {
		if (initialCapacity > 0) {
			capacity = initialCapacity;
		} else if (initialCapacity == 0) {
			capacity = 0;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}

		if (capacityIncrement > 0) {
			this.capacityIncrement = capacityIncrement;
		} else {
			throw new IllegalArgumentException("Illegal Capacity Increment: " + capacityIncrement);
		}

		if (choice == null) {
			throw new NullPointerException();
		}

		choice = choice.trim().toLowerCase();

		if (choice.equals("char")) {
			_char_ = new char[capacity];
			this.choice[0] = ONE;
		} else if (choice.equals("byte")) {
			_byte_ = new byte[capacity];
			this.choice[1] = ONE;
		} else if (choice.equals("short")) {
			_short_ = new short[capacity];
			this.choice[2] = ONE;
		} else if (choice.equals("int")) {
			_int_ = new int[capacity];
			this.choice[3] = ONE;
		} else if (choice.equals("long")) {
			_long_ = new long[capacity];
			this.choice[4] = ONE;
		} else if (choice.equals("float")) {
			_float_ = new float[capacity];
			this.choice[5] = ONE;
		} else if (choice.equals("double")) {
			_double_ = new double[capacity];
			this.choice[6] = ONE;
		} else {
			throw new IllegalArgumentException("Invalid choice \"" + choice +
					"\", excepted \"char\" or \"byte\" or \"short\" or \"int\" or \"long\" or \"float\" or \"double\".");
		}
	}

	private void grow(int minCapacity) {
		if (end >= capacity || minCapacity != 0) {
			if (minCapacity > 0) {
				capacity = minCapacity;
			} else {
				if (capacityIncrement > 0) {
					capacity += capacityIncrement;
				} else {
					capacity += (capacity >>> 1) + 1;
				}
			}

			if (choice[0] == ONE) {
				char[] temp = new char[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _char_[i];
				}
				_char_ = temp;
			} else if (choice[1] == ONE) {
				byte[] temp = new byte[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _byte_[i];
				}
				_byte_ = temp;
			} else if (choice[2] == ONE) {
				short[] temp = new short[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _short_[i];
				}
				_short_ = temp;
			} else if (choice[3] == ONE) {
				int[] temp = new int[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _int_[i];
				}
				_int_ = temp;
			} else if (choice[4] == ONE) {
				long[] temp = new long[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _long_[i];
				}
				_long_ = temp;
			} else if (choice[5] == ONE) {
				float[] temp = new float[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _float_[i];
				}
				_float_ = temp;
			} else {
				double[] temp = new double[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _double_[i];
				}
				_double_ = temp;
			}
		}
	}

	private void shrink(boolean trim) {
		if (end < (capacity / 2) || trim) {
			capacity = end;
			if (choice[0] == ONE) {
				char[] temp = new char[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _char_[i];
				}
				_char_ = temp;
			} else if (choice[1] == ONE) {
				byte[] temp = new byte[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _byte_[i];
				}
				_byte_ = temp;
			} else if (choice[2] == ONE) {
				short[] temp = new short[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _short_[i];
				}
				_short_ = temp;
			} else if (choice[3] == ONE) {
				int[] temp = new int[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _int_[i];
				}
				_int_ = temp;
			} else if (choice[4] == ONE) {
				long[] temp = new long[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _long_[i];
				}
				_long_ = temp;
			} else if (choice[5] == ONE) {
				float[] temp = new float[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _float_[i];
				}
				_float_ = temp;
			} else {
				double[] temp = new double[capacity];
				for (int i = 0; i < end; i++) {
					temp[i] = _double_[i];
				}
				_double_ = temp;
			}
		}
	}

	/**
	 * Appends the specified element to the end of this DynamicArray(char).
	 *
	 * @param element element to be appended to this DynamicArray
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(char element) {
		choiceCheck(0);
		grow(0);
		_char_[end++] = element;
		return true;
	}

	/**
	 * Appends the specified element to the end of this DynamicArray(byte).
	 *
	 * @param element element to be appended to this DynamicArray
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(byte element) {
		choiceCheck(1);
		grow(0);
		_byte_[end++] = element;
		return true;
	}

	/**
	 * Appends the specified element to the end of this DynamicArray(short).
	 *
	 * @param element element to be appended to this DynamicArray
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(short element) {
		choiceCheck(2);
		grow(0);
		_short_[end++] = element;
		return true;
	}

	/**
	 * Appends the specified element to the end of this DynamicArray(int).
	 *
	 * @param element element to be appended to this DynamicArray
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(int element) {
		choiceCheck(3);
		grow(0);
		_int_[end++] = element;
		return true;
	}

	/**
	 * Appends the specified element to the end of this DynamicArray(long).
	 *
	 * @param element element to be appended to this DynamicArray
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(long element) {
		choiceCheck(4);
		grow(0);
		_long_[end++] = element;
		return true;
	}

	/**
	 * Appends the specified element to the end of this DynamicArray(float).
	 *
	 * @param element element to be appended to this DynamicArray
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(float element) {
		choiceCheck(5);
		grow(0);
		_float_[end++] = element;
		return true;
	}

	/**
	 * Appends the specified element to the end of this DynamicArray(double).
	 *
	 * @param element element to be appended to this DynamicArray
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @return {@code true} if successfully appended
	 */
	public synchronized boolean add(double element) {
		choiceCheck(6);
		grow(0);
		_double_[end++] = element;
		return true;
	}

	private void rangeCheck(int index) {
		if (index > end) {
			throw new ArrayIndexOutOfBoundsException(index + " > " + end);
		}
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	private void choiceCheck(int index) {
		if (choice[index] != ONE) {
			if (index == 0) {
				throw new IllegalArgumentException("\'char\' method call not allowed");
			} else if (index == 1) {
				throw new IllegalArgumentException("\'byte\' method call not allowed");
			} else if (index == 2) {
				throw new IllegalArgumentException("\'short\' method call not allowed");
			} else if (index == 3) {
				throw new IllegalArgumentException("\'int\' method call not allowed");
			} else if (index == 4) {
				throw new IllegalArgumentException("\'long\' method call not allowed");
			} else if (index == 5) {
				throw new IllegalArgumentException("\'float\' method call not allowed");
			} else {
				throw new IllegalArgumentException("\'double\' method call not allowed");
			}
		}
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * DynamicArray(char).
	 * Shifts the element currently at that position (if any) and any
	 * subsequent elements to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException       {@code if(choice[0] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(int index, char element) {
		choiceCheck(0);
		rangeCheck(index);
		grow(0);
		int i = end;
		for (; i > index; i--) {
			_char_[i] = _char_[i - 1];
		}
		_char_[i] = element;
		end++;
		return true;
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * DynamicArray(byte).
	 * Shifts the element currently at that position (if any) and any
	 * subsequent elements to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException       {@code if(choice[1] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(int index, byte element) {
		choiceCheck(1);
		rangeCheck(index);
		grow(0);
		int i = end;
		for (; i > index; i--) {
			_byte_[i] = _byte_[i - 1];
		}
		_byte_[i] = element;
		end++;
		return true;
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * DynamicArray(short).
	 * Shifts the element currently at that position (if any) and any
	 * subsequent elements to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException       {@code if(choice[2] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(int index, short element) {
		choiceCheck(2);
		rangeCheck(index);
		grow(0);
		int i = end;
		for (; i > index; i--) {
			_short_[i] = _short_[i - 1];
		}
		_short_[i] = element;
		end++;
		return true;
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * DynamicArray(int).
	 * Shifts the element currently at that position (if any) and any
	 * subsequent elements to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException       {@code if(choice[3] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(int index, int element) {
		choiceCheck(3);
		rangeCheck(index);
		grow(0);
		int i = end;
		for (; i > index; i--) {
			_int_[i] = _int_[i - 1];
		}
		_int_[i] = element;
		end++;
		return true;
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * DynamicArray(long).
	 * Shifts the element currently at that position (if any) and any
	 * subsequent elements to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException       {@code if(choice[4] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(int index, long element) {
		choiceCheck(4);
		rangeCheck(index);
		grow(0);
		int i = end;
		for (; i > index; i--) {
			_long_[i] = _long_[i - 1];
		}
		_long_[i] = element;
		end++;
		return true;
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * DynamicArray(float).
	 * Shifts the element currently at that position (if any) and any
	 * subsequent elements to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException       {@code if(choice[5] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(int index, float element) {
		choiceCheck(5);
		rangeCheck(index);
		grow(0);
		int i = end;
		for (; i > index; i--) {
			_float_[i] = _float_[i - 1];
		}
		_float_[i] = element;
		end++;
		return true;
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * DynamicArray(double).
	 * Shifts the element currently at that position (if any) and any
	 * subsequent elements to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IllegalArgumentException       {@code if(choice[6] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index > end || index < 0)}
	 * @return {@code true} if successfully inserted
	 */
	public synchronized boolean add(int index, double element) {
		choiceCheck(6);
		rangeCheck(index);
		grow(0);
		int i = end;
		for (; i > index; i--) {
			_double_[i] = _double_[i - 1];
		}
		_double_[i] = element;
		end++;
		return true;
	}

	private void rangeCheck0(int index) {
		if (index >= end) {
			throw new ArrayIndexOutOfBoundsException("Array index out of range: " + index);
		}
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	/**
	 * Removes the element at the specified position in this DynamicArray.
	 * Shifts any subsequent elements to the left (subtracts one from their
	 * indices). Returns the element that was removed from the DynamicArray.
	 *
	 * @param index the index of the element to be removed
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 * @return element that was removed
	 */
	public synchronized Object removeAtIndex(int index) {
		rangeCheck0(index);
		Object o = null;

		if (choice[0] == ONE) {
			shrink(false);
			o = _char_[index];
			end--;
			for (int i = index; i < end; i++) {
				_char_[i] = _char_[i + 1];
			}
		} else if (choice[1] == ONE) {
			shrink(false);
			o = _byte_[index];
			end--;
			for (int i = index; i < end; i++) {
				_byte_[i] = _byte_[i + 1];
			}
		} else if (choice[2] == ONE) {
			shrink(false);
			o = _short_[index];
			end--;
			for (int i = index; i < end; i++) {
				_short_[i] = _short_[i + 1];
			}
		} else if (choice[3] == ONE) {
			shrink(false);
			o = _int_[index];
			end--;
			for (int i = index; i < end; i++) {
				_int_[i] = _int_[i + 1];
			}
		} else if (choice[4] == ONE) {
			shrink(false);
			o = _long_[index];
			end--;
			for (int i = index; i < end; i++) {
				_long_[i] = _long_[i + 1];
			}
		} else if (choice[5] == ONE) {
			shrink(false);
			o = _float_[index];
			end--;
			for (int i = index; i < end; i++) {
				_float_[i] = _float_[i + 1];
			}
		} else {
			shrink(false);
			o = _double_[index];
			end--;
			for (int i = index; i < end; i++) {
				_double_[i] = _double_[i + 1];
			}
		}
		return o;
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this DynamicArray(char), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[0] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int indexOf(char element) {
		return indexOf(element, 0);
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this DynamicArray(byte), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[1] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int indexOf(byte element) {
		return indexOf(element, 0);
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this DynamicArray(short), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[2] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int indexOf(short element) {
		return indexOf(element, 0);
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this DynamicArray(int), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[3] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int indexOf(int element) {
		return indexOf(element, 0);
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this DynamicArray(long), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[4] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int indexOf(long element) {
		return indexOf(element, 0);
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this DynamicArray(float), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[5] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int indexOf(float element) {
		return indexOf(element, 0);
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this DynamicArray(double), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[6] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int indexOf(double element) {
		return indexOf(element, 0);
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DynamicArray(char), searching forwards from {@code index}, or returns -1
	 * if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this DynamicArray at position {@code index} or later in the
	 *         DynamicArray;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[0] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int indexOf(char element, int index) {
		choiceCheck(0);
		rangeCheck0(index);
		for (int i = index; i < end; i++) {
			if (_char_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DynamicArray(byte), searching forwards from {@code index}, or returns -1
	 * if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this DynamicArray at position {@code index} or later in the
	 *         DynamicArray;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[1] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int indexOf(byte element, int index) {
		choiceCheck(1);
		rangeCheck0(index);
		for (int i = index; i < end; i++) {
			if (_byte_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DynamicArray(short), searching forwards from {@code index}, or returns
	 * -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this DynamicArray at position {@code index} or later in the
	 *         DynamicArray;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[2] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int indexOf(short element, int index) {
		choiceCheck(2);
		rangeCheck0(index);
		for (int i = index; i < end; i++) {
			if (_short_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DynamicArray(int), searching forwards from {@code index}, or returns -1
	 * if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this DynamicArray at position {@code index} or later in the
	 *         DynamicArray;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[3] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int indexOf(int element, int index) {
		choiceCheck(3);
		rangeCheck0(index);
		for (int i = index; i < end; i++) {
			if (_int_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DynamicArray(long), searching forwards from {@code index}, or returns -1
	 * if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this DynamicArray at position {@code index} or later in the
	 *         DynamicArray;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[4] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int indexOf(long element, int index) {
		choiceCheck(4);
		rangeCheck0(index);
		for (int i = index; i < end; i++) {
			if (_long_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DynamicArray(float), searching forwards from {@code index}, or returns
	 * -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this DynamicArray at position {@code index} or later in the
	 *         DynamicArray;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[5] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int indexOf(float element, int index) {
		choiceCheck(5);
		rangeCheck0(index);
		for (int i = index; i < end; i++) {
			if (_float_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DynamicArray(double), searching forwards from {@code index}, or returns
	 * -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching from
	 * @return the index of the first occurrence of the element in
	 *         this DynamicArray at position {@code index} or later in the
	 *         DynamicArray;
	 *         {@code -1} if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[6] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int indexOf(double element, int index) {
		choiceCheck(6);
		rangeCheck0(index);
		for (int i = index; i < end; i++) {
			if (_double_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this DynamicArray(char), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[0] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int lastIndexOf(char element) {
		return lastIndexOf(element, (end - 1));
	}

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this DynamicArray(byte), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[1] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int lastIndexOf(byte element) {
		return lastIndexOf(element, (end - 1));
	}

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this DynamicArray(short), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[2] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int lastIndexOf(short element) {
		return lastIndexOf(element, (end - 1));
	}

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this DynamicArray(int), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[3] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int lastIndexOf(int element) {
		return lastIndexOf(element, (end - 1));
	}

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this DynamicArray(long), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[4] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int lastIndexOf(long element) {
		return lastIndexOf(element, (end - 1));
	}

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this DynamicArray(float), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[5] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int lastIndexOf(float element) {
		return lastIndexOf(element, (end - 1));
	}

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this DynamicArray(double), or -1 if this DynamicArray does not contain the
	 * element.
	 *
	 * @param element element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this DynamicArray, or -1 if this DynamicArray does not contain the
	 *         element
	 * @throws IllegalArgumentException       {@code if(choice[6] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException if array is empty
	 */
	public synchronized int lastIndexOf(double element) {
		return lastIndexOf(element, (end - 1));
	}

	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this DynamicArray(char), searching backwards from {@code index}, or returns
	 * -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this DynamicArray;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[0] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int lastIndexOf(char element, int index) {
		choiceCheck(0);
		rangeCheck0(index);
		for (int i = index; i > -1; i--) {
			if (_char_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this DynamicArray(byte), searching backwards from {@code index}, or returns
	 * -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this DynamicArray;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[1] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int lastIndexOf(byte element, int index) {
		choiceCheck(1);
		rangeCheck0(index);
		for (int i = index; i > -1; i--) {
			if (_byte_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this DynamicArray(short), searching backwards from {@code index}, or returns
	 * -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this DynamicArray;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[2] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int lastIndexOf(short element, int index) {
		choiceCheck(2);
		rangeCheck0(index);
		for (int i = index; i > -1; i--) {
			if (_short_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this DynamicArray(int), searching backwards from {@code index}, or returns -1
	 * if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this DynamicArray;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[3] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int lastIndexOf(int element, int index) {
		choiceCheck(3);
		rangeCheck0(index);
		for (int i = index; i > -1; i--) {
			if (_int_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this DynamicArray(long), searching backwards from {@code index}, or returns
	 * -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this DynamicArray;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[4] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int lastIndexOf(long element, int index) {
		choiceCheck(4);
		rangeCheck0(index);
		for (int i = index; i > -1; i--) {
			if (_long_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this DynamicArray(float), searching backwards from {@code index}, or returns
	 * -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this DynamicArray;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[5] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int lastIndexOf(float element, int index) {
		choiceCheck(5);
		rangeCheck0(index);
		for (int i = index; i > -1; i--) {
			if (_float_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in
	 * this DynamicArray(double), searching backwards from {@code index}, or returns
	 * -1 if
	 * the element is not found.
	 *
	 * @param element element to search for
	 * @param index   index to start searching backwards from
	 * @return the index of the last occurrence of the element at position
	 *         less than or equal to {@code index} in this DynamicArray;
	 *         -1 if the element is not found.
	 * @throws IllegalArgumentException       {@code if(choice[6] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized int lastIndexOf(double element, int index) {
		choiceCheck(6);
		rangeCheck0(index);
		for (int i = index; i > -1; i--) {
			if (_double_[i] == element) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns the first component (the item at index {@code 0}) of
	 * the DynamicArray.
	 *
	 * @return {@code null} if DynamicArray is empty, else the first component of
	 *         the DynamicArray
	 */
	public synchronized Object firstElement() {
		if (isEmpty()) {
			return null;
		}
		if (choice[0] == ONE) {
			return (Object) _char_[0];
		} else if (choice[1] == ONE) {
			return (Object) _byte_[0];
		} else if (choice[2] == ONE) {
			return (Object) _short_[0];
		} else if (choice[3] == ONE) {
			return (Object) _int_[0];
		} else if (choice[4] == ONE) {
			return (Object) _long_[0];
		} else if (choice[5] == ONE) {
			return (Object) _float_[0];
		} else {
			return (Object) _double_[0];
		}
	}

	/**
	 * Returns the last component of the DynamicArray.
	 *
	 * @return {@code null} if DynamicArray is empty, else the last component of the
	 *         DynamicArray
	 */
	public synchronized Object lastElement() {
		if (isEmpty()) {
			return null;
		}
		if (choice[0] == ONE) {
			return (Object) _char_[end - 1];
		} else if (choice[1] == ONE) {
			return (Object) _byte_[end - 1];
		} else if (choice[2] == ONE) {
			return (Object) _short_[end - 1];
		} else if (choice[3] == ONE) {
			return (Object) _int_[end - 1];
		} else if (choice[4] == ONE) {
			return (Object) _long_[end - 1];
		} else if (choice[5] == ONE) {
			return (Object) _float_[end - 1];
		} else {
			return (Object) _double_[end - 1];
		}
	}

	/**
	 * Returns {@code true} if this DynamicArray(char) contains the specified
	 * element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this DynamicArray is to be tested
	 * @return {@code true} if this DynamicArray contains the specified element;
	 *         else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @see <a href="../../algorithms/search/LinearSearch.html">LinearSearch</a>
	 */
	public synchronized boolean contains(char element) {
		choiceCheck(0);
		if (LinearSearch.search(_char_, 0, end, element) > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns {@code true} if this DynamicArray(byte) contains the specified
	 * element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this DynamicArray is to be tested
	 * @return {@code true} if this DynamicArray contains the specified element;
	 *         else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @see <a href="../../algorithms/search/LinearSearch.html">LinearSearch</a>
	 */
	public synchronized boolean contains(byte element) {
		choiceCheck(1);
		if (LinearSearch.search(_byte_, 0, end, element) > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns {@code true} if this DynamicArray(short) contains the specified
	 * element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this DynamicArray is to be tested
	 * @return {@code true} if this DynamicArray contains the specified element;
	 *         else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @see <a href="../../algorithms/search/LinearSearch.html">LinearSearch</a>
	 */
	public synchronized boolean contains(short element) {
		choiceCheck(2);
		if (LinearSearch.search(_short_, 0, end, element) > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns {@code true} if this DynamicArray(int) contains the specified
	 * element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this DynamicArray is to be tested
	 * @return {@code true} if this DynamicArray contains the specified element;
	 *         else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @see <a href="../../algorithms/search/LinearSearch.html">LinearSearch</a>
	 */
	public synchronized boolean contains(int element) {
		choiceCheck(3);
		if (LinearSearch.search(_int_, 0, end, element) > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns {@code true} if this DynamicArray(long) contains the specified
	 * element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this DynamicArray is to be tested
	 * @return {@code true} if this DynamicArray contains the specified element;
	 *         else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @see <a href="../../algorithms/search/LinearSearch.html">LinearSearch</a>
	 */
	public synchronized boolean contains(long element) {
		choiceCheck(4);
		if (LinearSearch.search(_long_, 0, end, element) > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns {@code true} if this DynamicArray(float) contains the specified
	 * element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this DynamicArray is to be tested
	 * @return {@code true} if this DynamicArray contains the specified element;
	 *         else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @see <a href="../../algorithms/search/LinearSearch.html">LinearSearch</a>
	 */
	public synchronized boolean contains(float element) {
		choiceCheck(5);
		if (LinearSearch.search(_float_, 0, end, element) > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns {@code true} if this DynamicArray(double) contains the specified
	 * element.
	 * Algorithm used to search elements is linear search.
	 *
	 * @param element element whose presence in this DynamicArray is to be tested
	 * @return {@code true} if this DynamicArray contains the specified element;
	 *         else {@code false}
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @see <a href="../../algorithms/search/LinearSearch.html">LinearSearch</a>
	 */
	public synchronized boolean contains(double element) {
		choiceCheck(6);
		if (LinearSearch.search(_double_, 0, end, element) > -1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the element at the specified position in this DynamicArray.
	 *
	 * @param index index of the element to return
	 * @return object at the specified index
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized Object get(int index) {
		rangeCheck0(index);
		if (choice[0] == ONE) {
			return (Object) _char_[index];
		} else if (choice[1] == ONE) {
			return (Object) _byte_[index];
		} else if (choice[2] == ONE) {
			return (Object) _short_[index];
		} else if (choice[3] == ONE) {
			return (Object) _int_[index];
		} else if (choice[4] == ONE) {
			return (Object) _long_[index];
		} else if (choice[5] == ONE) {
			return (Object) _float_[index];
		} else {
			return (Object) _double_[index];
		}
	}

	/**
	 * Tests if this DynamicArray has no components.
	 *
	 * @return {@code true} if and only if this DynamicArray has
	 *         no components, that is, its size is zero;
	 *         {@code false} otherwise.
	 */
	public synchronized boolean isEmpty() {
		return end == 0;
	}

	/**
	 * Removes the first occurrence of the specified element in this
	 * DynamicArray(char)
	 * If the DynamicArray does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this DynamicArray, if present
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @return true if the DynamicArray contained the specified element; else false
	 */
	public synchronized boolean remove(char element) {
		if (isEmpty()) {
			return false;
		}
		int i = indexOf(element);
		if (i > -1) {
			removeAtIndex(i);
			return true;
		}
		return false;
	}

	/**
	 * Removes the first occurrence of the specified element in this
	 * DynamicArray(byte)
	 * If the DynamicArray does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this DynamicArray, if present
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @return true if the DynamicArray contained the specified element; else false
	 */
	public synchronized boolean remove(byte element) {
		if (isEmpty()) {
			return false;
		}
		int i = indexOf(element);
		if (i > -1) {
			removeAtIndex(i);
			return true;
		}
		return false;
	}

	/**
	 * Removes the first occurrence of the specified element in this
	 * DynamicArray(short)
	 * If the DynamicArray does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this DynamicArray, if present
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @return true if the DynamicArray contained the specified element; else false
	 */
	public synchronized boolean remove(short element) {
		if (isEmpty()) {
			return false;
		}
		int i = indexOf(element);
		if (i > -1) {
			removeAtIndex(i);
			return true;
		}
		return false;
	}

	/**
	 * Removes the first occurrence of the specified element in this
	 * DynamicArray(int)
	 * If the DynamicArray does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this DynamicArray, if present
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @return true if the DynamicArray contained the specified element; else false
	 */
	public synchronized boolean remove(int element) {
		if (isEmpty()) {
			return false;
		}
		int i = indexOf(element);
		if (i > -1) {
			removeAtIndex(i);
			return true;
		}
		return false;
	}

	/**
	 * Removes the first occurrence of the specified element in this
	 * DynamicArray(long)
	 * If the DynamicArray does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this DynamicArray, if present
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @return true if the DynamicArray contained the specified element; else false
	 */
	public synchronized boolean remove(long element) {
		if (isEmpty()) {
			return false;
		}
		int i = indexOf(element);
		if (i > -1) {
			removeAtIndex(i);
			return true;
		}
		return false;
	}

	/**
	 * Removes the first occurrence of the specified element in this
	 * DynamicArray(float)
	 * If the DynamicArray does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this DynamicArray, if present
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @return true if the DynamicArray contained the specified element; else false
	 */
	public synchronized boolean remove(float element) {
		if (isEmpty()) {
			return false;
		}
		int i = indexOf(element);
		if (i > -1) {
			removeAtIndex(i);
			return true;
		}
		return false;
	}

	/**
	 * Removes the first occurrence of the specified element in this
	 * DynamicArray(double)
	 * If the DynamicArray does not contain the element, it is unchanged.
	 *
	 * @param element element to be removed from this DynamicArray, if present
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @return true if the DynamicArray contained the specified element; else false
	 */
	public synchronized boolean remove(double element) {
		if (isEmpty()) {
			return false;
		}
		int i = indexOf(element);
		if (i > -1) {
			removeAtIndex(i);
			return true;
		}
		return false;
	}

	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this
	 * DynamicArray(char).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[0] != ONE)}
	 * @return {@code true} if atleast one {@code oldElement} element is replaces
	 *         with {@code newElement}
	 */
	public synchronized boolean replace(char oldElement, char newElement) {
		choiceCheck(0);
		if (isEmpty()) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < end; i++) {
			if (_char_[i] == oldElement) {
				flag = true;
				_char_[i] = newElement;
			}
		}
		return flag;
	}

	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this
	 * DynamicArray(byte).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[1] != ONE)}
	 * @return {@code true} if atleast one {@code oldElement} element is replaces
	 *         with {@code newElement}
	 */
	public synchronized boolean replace(byte oldElement, byte newElement) {
		choiceCheck(1);
		if (isEmpty()) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < end; i++) {
			if (_byte_[i] == oldElement) {
				flag = true;
				_byte_[i] = newElement;
			}
		}
		return flag;
	}

	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this
	 * DynamicArray(short).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[2] != ONE)}
	 * @return {@code true} if atleast one {@code oldElement} element is replaces
	 *         with {@code newElement}
	 */
	public synchronized boolean replace(short oldElement, short newElement) {
		choiceCheck(2);
		if (isEmpty()) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < end; i++) {
			if (_short_[i] == oldElement) {
				flag = true;
				_short_[i] = newElement;
			}
		}
		return flag;
	}

	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this
	 * DynamicArray(int).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[3] != ONE)}
	 * @return {@code true} if atleast one {@code oldElement} element is replaces
	 *         with {@code newElement}
	 */
	public synchronized boolean replace(int oldElement, int newElement) {
		choiceCheck(3);
		if (isEmpty()) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < end; i++) {
			if (_int_[i] == oldElement) {
				flag = true;
				_int_[i] = newElement;
			}
		}
		return flag;
	}

	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this
	 * DynamicArray(long).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[4] != ONE)}
	 * @return {@code true} if atleast one {@code oldElement} element is replaces
	 *         with {@code newElement}
	 */
	public synchronized boolean replace(long oldElement, long newElement) {
		choiceCheck(4);
		if (isEmpty()) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < end; i++) {
			if (_long_[i] == oldElement) {
				flag = true;
				_long_[i] = newElement;
			}
		}
		return flag;
	}

	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this
	 * DynamicArray(float).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[5] != ONE)}
	 * @return {@code true} if atleast one {@code oldElement} element is replaces
	 *         with {@code newElement}
	 */
	public synchronized boolean replace(float oldElement, float newElement) {
		choiceCheck(5);
		if (isEmpty()) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < end; i++) {
			if (_float_[i] == oldElement) {
				flag = true;
				_float_[i] = newElement;
			}
		}
		return flag;
	}

	/**
	 * Replace all the {@code oldElement}, with the {@code newElement} in this
	 * DynamicArray(double).
	 *
	 * @param oldElement the old element
	 * @param newElement the new element
	 * @throws IllegalArgumentException {@code if(choice[6] != ONE)}
	 * @return {@code true} if atleast one {@code oldElement} element is replaces
	 *         with {@code newElement}
	 */
	public synchronized boolean replace(double oldElement, double newElement) {
		choiceCheck(6);
		if (isEmpty()) {
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < end; i++) {
			if (_double_[i] == oldElement) {
				flag = true;
				_double_[i] = newElement;
			}
		}
		return flag;
	}

	/**
	 * Replace value at {@code index}, with the {@code newElement} in this
	 * DynamicArray(char).
	 *
	 * @param newElement the new element
	 * @param index      index at which element is to be placed
	 * @throws IllegalArgumentException       {@code if(choice[0] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(char newElement, int index) {
		choiceCheck(0);
		rangeCheck0(index);
		_char_[index] = newElement;
	}

	/**
	 * Replace value at {@code index}, with the {@code newElement} in this
	 * DynamicArray(byte).
	 *
	 * @param newElement the new element
	 * @param index      index at which element is to be placed
	 * @throws IllegalArgumentException       {@code if(choice[1] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(byte newElement, int index) {
		choiceCheck(1);
		rangeCheck0(index);
		_byte_[index] = newElement;
	}

	/**
	 * Replace value at {@code index}, with the {@code newElement} in this
	 * DynamicArray(short).
	 *
	 * @param newElement the new element
	 * @param index      index at which element is to be placed
	 * @throws IllegalArgumentException       {@code if(choice[2] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(short newElement, int index) {
		choiceCheck(2);
		rangeCheck0(index);
		_short_[index] = newElement;
	}

	/**
	 * Replace value at {@code index}, with the {@code newElement} in this
	 * DynamicArray(int).
	 *
	 * @param newElement the new element
	 * @param index      index at which element is to be placed
	 * @throws IllegalArgumentException       {@code if(choice[3] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(int newElement, int index) {
		choiceCheck(3);
		rangeCheck0(index);
		_int_[index] = newElement;
	}

	/**
	 * Replace value at {@code index}, with the {@code newElement} in this
	 * DynamicArray(long).
	 *
	 * @param newElement the new element
	 * @param index      index at which element is to be placed
	 * @throws IllegalArgumentException       {@code if(choice[4] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(long newElement, int index) {
		choiceCheck(4);
		rangeCheck0(index);
		_long_[index] = newElement;
	}

	/**
	 * Replace value at {@code index}, with the {@code newElement} in this
	 * DynamicArray(float).
	 *
	 * @param newElement the new element
	 * @param index      index at which element is to be placed
	 * @throws IllegalArgumentException       {@code if(choice[5] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(float newElement, int index) {
		choiceCheck(5);
		rangeCheck0(index);
		_float_[index] = newElement;
	}

	/**
	 * Replace value at {@code index}, with the {@code newElement} in this
	 * DynamicArray(double).
	 *
	 * @param newElement the new element
	 * @param index      index at which element is to be placed
	 * @throws IllegalArgumentException       {@code if(choice[6] != ONE)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(index >= end || index < 0)}
	 */
	public synchronized void replaceAt(double newElement, int index) {
		choiceCheck(6);
		rangeCheck0(index);
		_double_[index] = newElement;
	}

	/**
	 * Removes all of the elements from this DynamicArray. The DynamicArray will
	 * be empty after this call returns (unless it throws an exception).
	 */
	public synchronized void clear() {
		end = 0;
		shrink(true);
	}

	/**
	 * Returns the number of components in this DynamicArray.
	 *
	 * @return the number of components in this DynamicArray
	 */
	public synchronized int size() {
		return end;
	}

	/**
	 * Returns the current capacity of this DynamicArray.
	 *
	 * @return the current capacity (the length of its internal data array)
	 */
	public synchronized int capacity() {
		return capacity;
	}

	/**
	 * Increases the capacity of this DynamicArray, if necessary, to ensure
	 * that it can hold at least the number of components specified by
	 * the minimum capacity argument.
	 *
	 * <p>
	 * If the current capacity of this DynamicArray is less than
	 * {@code minCapacity}, then its capacity is increased.
	 *
	 * @param minCapacity the desired minimum capacity
	 */
	public synchronized void ensureCapacity(int minCapacity) {
		if (minCapacity > 0 && capacity < minCapacity) {
			grow(minCapacity);
		}
	}

	/**
	 * Trims the capacity of this DynamicArray to be the DynamicArray's current
	 * size. If the capacity of this DynamicArray is larger than its current
	 * size, then the capacity is changed to equal the size by replacing
	 * its internal data array. An application can use this operation to
	 * minimize the storage of a DynamicArray.
	 */
	public synchronized void trimToSize() {
		shrink(true);
	}

	/**
	 * Sorts this DynamicArray according to the order specified by the character
	 * {@code c}.<br>
	 * <b>Note: Array trims to it's size before sorting.</b>
	 *
	 * @param c {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in ascending
	 *          order,
	 *          {@code if(c == 'd' || c == 'D')} then sort <b>a</b> in descending
	 *          order
	 * @throws IllegalArgumentException {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 */
	public synchronized void sort(char c) {
		if (choice[0] == ONE) {
			sort(0, end, c);
		} else if (choice[1] == ONE) {
			sort(0, end, c);
		} else if (choice[2] == ONE) {
			sort(0, end, c);
		} else if (choice[3] == ONE) {
			sort(0, end, c);
		} else if (choice[4] == ONE) {
			sort(0, end, c);
		} else if (choice[5] == ONE) {
			sort(0, end, c);
		} else {
			sort(0, end, c);
		}
	}

	/**
	 * Sorts this DynamicArray according to the order specified by the character
	 * {@code c}.<br>
	 * <b>Note: Array trims to it's size before sorting.</b>
	 *
	 * @param c         {@code if(c == 'a' || c == 'A')} then sort <b>a</b> in
	 *                  ascending order,
	 *                  {@code if(c == 'd' || c == 'D')} then sort <b>a</b> in
	 *                  descending order
	 * @param fromIndex the index of the first element, inclusive, to be sorted
	 * @param toIndex   the index of the last element, exclusive, to be sorted
	 * @throws IllegalArgumentException       {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}
	 * @throws IllegalArgumentException       {@code if(fromIndex > toIndex)}
	 * @throws ArrayIndexOutOfBoundsException {@code if(fromIndex < 0 || toIndex > array.length)}
	 */
	public synchronized void sort(int fromIndex, int toIndex, char c) {
		if (choice[0] == ONE) {
			if (c == 'a' || c == 'A') {
				shrink(true);
				Arrays.sort(_char_, fromIndex, toIndex);
			} else if (c == 'd' || c == 'D') {
				shrink(true);
				Arrays.sort(_char_, fromIndex, toIndex);
				char temp;
				for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
					temp = _char_[i];
					_char_[i] = _char_[j];
					_char_[j] = temp;
				}
			} else {
				throw new IllegalArgumentException("Invalid choice \'" + c +
						"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		} else if (choice[1] == ONE) {
			if (c == 'a' || c == 'A') {
				shrink(true);
				Arrays.sort(_byte_, fromIndex, toIndex);
			} else if (c == 'd' || c == 'D') {
				shrink(true);
				Arrays.sort(_byte_, fromIndex, toIndex);
				byte temp;
				for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
					temp = _byte_[i];
					_byte_[i] = _byte_[j];
					_byte_[j] = temp;
				}
			} else {
				throw new IllegalArgumentException("Invalid choice \'" + c +
						"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		} else if (choice[2] == ONE) {
			if (c == 'a' || c == 'A') {
				shrink(true);
				Arrays.sort(_short_, fromIndex, toIndex);
			} else if (c == 'd' || c == 'D') {
				shrink(true);
				Arrays.sort(_short_, fromIndex, toIndex);
				short temp;
				for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
					temp = _short_[i];
					_short_[i] = _short_[j];
					_short_[j] = temp;
				}
			} else {
				throw new IllegalArgumentException("Invalid choice \'" + c +
						"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		} else if (choice[3] == ONE) {
			if (c == 'a' || c == 'A') {
				shrink(true);
				Arrays.sort(_int_, fromIndex, toIndex);
			} else if (c == 'd' || c == 'D') {
				shrink(true);
				Arrays.sort(_int_, fromIndex, toIndex);
				int temp;
				for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
					temp = _int_[i];
					_int_[i] = _int_[j];
					_int_[j] = temp;
				}
			} else {
				throw new IllegalArgumentException("Invalid choice \'" + c +
						"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		} else if (choice[4] == ONE) {
			if (c == 'a' || c == 'A') {
				shrink(true);
				Arrays.sort(_long_, fromIndex, toIndex);
			} else if (c == 'd' || c == 'D') {
				shrink(true);
				Arrays.sort(_long_, fromIndex, toIndex);
				long temp;
				for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
					temp = _long_[i];
					_long_[i] = _long_[j];
					_long_[j] = temp;
				}
			} else {
				throw new IllegalArgumentException("Invalid choice \'" + c +
						"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		} else if (choice[5] == ONE) {
			if (c == 'a' || c == 'A') {
				shrink(true);
				Arrays.sort(_float_, fromIndex, toIndex);
			} else if (c == 'd' || c == 'D') {
				shrink(true);
				Arrays.sort(_float_, fromIndex, toIndex);
				float temp;
				for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
					temp = _float_[i];
					_float_[i] = _float_[j];
					_float_[j] = temp;
				}
			} else {
				throw new IllegalArgumentException("Invalid choice \'" + c +
						"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		} else {
			if (c == 'a' || c == 'A') {
				shrink(true);
				Arrays.sort(_double_, fromIndex, toIndex);
			} else if (c == 'd' || c == 'D') {
				shrink(true);
				Arrays.sort(_double_, fromIndex, toIndex);
				double temp;
				for (int i = fromIndex, j = toIndex - 1; i < j; i++, j--) {
					temp = _double_[i];
					_double_[i] = _double_[j];
					_double_[j] = temp;
				}
			} else {
				throw new IllegalArgumentException("Invalid choice \'" + c +
						"\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.");
			}
		}
	}

	/**
	 * Returns an array containing all of the elements in this DynamicArray.
	 * 
	 * <p>
	 * The returned array will be "safe" in that no references to it are
	 * maintained by the DynamicArray. (In other words, this method must allocate
	 * a new array). The caller is thus free to modify the returned array.
	 * </p>
	 * 
	 * @return an array containing all of the elements in this DynamicArray
	 */
	public synchronized Object[] toArray() {
		Object[] o = new Object[end];
		if (choice[0] == ONE) {
			for (int i = 0; i < end; i++) {
				o[i] = _char_[i];
			}
		} else if (choice[1] == ONE) {
			for (int i = 0; i < end; i++) {
				o[i] = _byte_[i];
			}
		} else if (choice[2] == ONE) {
			for (int i = 0; i < end; i++) {
				o[i] = _short_[i];
			}
		} else if (choice[3] == ONE) {
			for (int i = 0; i < end; i++) {
				o[i] = _int_[i];
			}
		} else if (choice[4] == ONE) {
			for (int i = 0; i < end; i++) {
				o[i] = _long_[i];
			}
		} else if (choice[5] == ONE) {
			for (int i = 0; i < end; i++) {
				o[i] = _float_[i];
			}
		} else {
			for (int i = 0; i < end; i++) {
				o[i] = _double_[i];
			}
		}
		return o;
	}

	/**
	 * All the elements in the DynamicArray are initialized to zero without changing
	 * the capacity.
	 */
	public synchronized void zeroFill() {
		if (choice[0] == ONE) {
			for (int i = 0; i < end; i++) {
				_char_[i] = 0;
			}
		} else if (choice[1] == ONE) {
			for (int i = 0; i < end; i++) {
				_byte_[i] = 0;
			}
		} else if (choice[2] == ONE) {
			for (int i = 0; i < end; i++) {
				_short_[i] = 0;
			}
		} else if (choice[3] == ONE) {
			for (int i = 0; i < end; i++) {
				_int_[i] = 0;
			}
		} else if (choice[4] == ONE) {
			for (int i = 0; i < end; i++) {
				_long_[i] = 0;
			}
		} else if (choice[5] == ONE) {
			for (int i = 0; i < end; i++) {
				_float_[i] = 0;
			}
		} else {
			for (int i = 0; i < end; i++) {
				_double_[i] = 0;
			}
		}
	}

	/**
	 * Returns a string representation of the DynamicArray, enclosed in a square
	 * brackets ("[]")
	 * and separated by comma and a space(", ").
	 *
	 * @return a string representation of this DynamicArray
	 */
	@Override
	public synchronized String toString() {
		if (end == 0) {
			return "[]";
		}
		StringBuilder str = new StringBuilder((3 * end) + 2);
		str.append("[");
		int i = 0;

		if (choice[0] == ONE) {
			for (; i < end - 1; i++) {
				str.append(_char_[i] + ", ");
			}
			str.append(_char_[i] + "]");
		} else if (choice[1] == ONE) {
			for (; i < end - 1; i++) {
				str.append(_byte_[i] + ", ");
			}
			str.append(_byte_[i] + "]");
		} else if (choice[2] == ONE) {
			for (; i < end - 1; i++) {
				str.append(_short_[i] + ", ");
			}
			str.append(_short_[i] + "]");
		} else if (choice[3] == ONE) {
			for (; i < end - 1; i++) {
				str.append(_int_[i] + ", ");
			}
			str.append(_int_[i] + "]");
		} else if (choice[4] == ONE) {
			for (; i < end - 1; i++) {
				str.append(_long_[i] + ", ");
			}
			str.append(_long_[i] + "]");
		} else if (choice[5] == ONE) {
			for (; i < end - 1; i++) {
				str.append(_float_[i] + ", ");
			}
			str.append(_float_[i] + "]");
		} else if (choice[6] == ONE) {
			for (; i < end - 1; i++) {
				str.append(_double_[i] + ", ");
			}
			str.append(_double_[i] + "]");
		}
		return str.toString();
	}
}