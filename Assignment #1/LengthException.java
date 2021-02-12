package assignment1;

//Throws if length of password is less than 6 characters
public class LengthException extends Exception{
	
	public LengthException (String message) {
		super(message);
	}

}
