
public class MyException extends Exception {
	// Variables
	private String str1;

	// Constructors
	MyException(String str2) {
		str1 = str2;
	}

	// Methods
	public String toString() {
		return ("MyException Occurred: " + str1);
	}

	// Driver
	public static void main(String[] args) {

		MyException myExcept = new MyException("hello world");

		// Catch Error
		try {
			System.out.println(myExcept.toString());
		} catch (Error e) {
			System.out.println(e);
		} finally {
			System.out.println("finished");
		}
	}

}
