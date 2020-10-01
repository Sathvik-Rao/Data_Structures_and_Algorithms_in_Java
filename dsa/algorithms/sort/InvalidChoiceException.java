package dsa.algorithms.sort;

/**
 * <p>InvalidChoiceException is a checked exception. If the choice entered in sort method is invalid
 * InvalidChoiceException is thrown.</p>
 *
 * <p>Choice in invalid {@code if((c != 'a' || c != 'A') && (c != 'd' || c != 'D'))}</p>
 *
 * @author Sathvik
 * @version 1.0
 */
public class InvalidChoiceException extends Exception
{
	static final long serialVersionUID = 7818375820146090199L;
	
	private char c;
	
	/**
     * Constructs an {@code InvalidChoiceException} and initialize <b>c</b>.
     *
     * @param c the invalid character(choice)
     */
	public InvalidChoiceException(char c)
	{
		this.c = c;
	}
	
	/**
     * Returns a description about exception. The result is the concatenation of:
     * <ul>
     * <li> "dsa.algorithms.sort.InvalidChoiceException" (the name of the package) </li>
     * <li> ": " (a colon and a space) </li>
     * <li> "Invalid choice \'" + c + "\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending." 
	 * 		 (where c is the invalid choice) </li>
     * </ul>
	 *
     * @return a string representation of this exception.
     */
	@Override
	public String toString()
	{
		return "dsa.algorithms.sort.InvalidChoiceException: Invalid choice \'" + c + 
			   "\', excepted \'a\'/\'A\' for ascending and \'d\'/\'D\' for descending.";
	}
}