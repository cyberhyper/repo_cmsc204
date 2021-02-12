package assignment1;

//Throws if password doesn’t contain an uppercase alpha character
public class NoUpperAlphaException extends Exception {
	
	public NoUpperAlphaException (String message) {
		super(message);
	}

}
