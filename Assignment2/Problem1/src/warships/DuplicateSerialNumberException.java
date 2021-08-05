package warships;

public class DuplicateSerialNumberException extends Exception {
	private static final long serialVersionUID = 1468632066903849682L;
	private static final String message = "Duplicate Serial Number";

	// Constructors
	public DuplicateSerialNumberException() {
		super(message);
	}

	public DuplicateSerialNumberException(String MESSAGE) {
		super(MESSAGE);
	}
}
