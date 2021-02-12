package assignment1;

//Throws if password contains more than 2 of the same character in sequence
public class InvalidSequenceException extends Exception {

	public InvalidSequenceException (String message) {
			super(message);
		}
}



