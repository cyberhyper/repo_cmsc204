package assignment1;

//Throws if password doesn’t contain a lowercase alpha character
public class NoLowerAlphaException extends Exception {
	
	public NoLowerAlphaException (String message) {
		super(message);
	}
}
