package facebook.exception;

public class ReservedWordException extends Exception {
	public String toString() {
		return "Reserved words are not allowed" + "\n";
	}
}
