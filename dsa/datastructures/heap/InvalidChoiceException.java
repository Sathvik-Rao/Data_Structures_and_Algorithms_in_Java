package dsa.datastructures.heap;

/**
 * <p>InvalidChoiceException is a checked exception. 
 * If the choice entered in Heap constructor is invalid 
 * <i>InvalidChoiceException</i> is thrown.</p>
 *
 * <p>Choice in invalid {@code if(s != "max" || s != "min")}.
 *  (Leading and trailing whitespace are omitted and is case insensitive.) </p>
 *
 * @author Sathvik
 * @version 1.0
 */
public class InvalidChoiceException extends Exception
{
	static final long serialVersionUID = 7818375820146090190L;
	
	private String s;
	
	/**
     * Constructs an {@code InvalidChoiceException} and initialize <b>s</b>.
     *
     * @param s the invalid string(choice)
     */
	public InvalidChoiceException(String s)
	{
		this.s = s;
	}
	
	/**
     * Returns a description about exception. The result is the concatenation of:
     * <ul>
     * <li> "dsa.datastructures.heap.InvalidChoiceException" (the name of the package) </li>
     * <li> ": " (a colon and a space) </li>
     * <li> "Invalid choice \"" + s + "\", excepted \"min\" for min heap and \"max\" for max heap."
	 * 		 (where s is the invalid choice) </li>
     * </ul>
	 *
     * @return a string representation of this exception.
     */
	@Override
	public String toString()
	{
		return "dsa.datastructures.heap.InvalidChoiceException: Invalid choice \"" + s +  
			   "\", excepted \"min\" for min heap or \"max\" for max heap.";
	}
}