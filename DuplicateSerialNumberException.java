package Warships;

public class DuplicateSerialNumberException extends Exception{
	private static final String message = "Duplicate Serial Number";
	public DuplicateSerialNumberException() //constructor
	{
		super(message);
	}
	public DuplicateSerialNumberException(String MESSAGE)//constructor cathing it to display message and promt the user again
	{
		super(MESSAGE);
	}
}
