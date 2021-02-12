
package assignment1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author kevin
 *
 */
public class PasswordCheckerUtility {

	/**
	 * 
	 * @param T
	 * @return
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws InvalidSequnceException
	 * @throws NoSpecialCharacterException
	 */
	
	public PasswordCheckerUtility() {
	}

	/**
	* It will check the validity of the password
	* It returns true if the password is valid and will return false if it is not
	* @param  passwordString - this is the password that will be tested
	* @return true if password turns out valid and false if not
	*/
	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException, 
	NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException{
		
		boolean check_password_validity = true;
		
		try
		{
			lengthChecker(passwordString);
		}
		catch (LengthException e)
		{
			throw new LengthException("The password must be at least 6 characters long");
		}
		
		try
		{
			digitChecker(passwordString);
		}
		catch (NoDigitException e)
		{
			throw new NoDigitException("The password must contain at least one digit");
		}
		
		try
		{
			upperChecker(passwordString);
		}
		catch (NoUpperAlphaException e)
		{
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		}
		
		try
		{
			lowerChecker(passwordString);
		}
		catch (NoLowerAlphaException e)
		{
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		}
		
		try
		{
			specialChecker(passwordString);
		}
		catch (NoSpecialCharacterException e)
		{
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
		
		try
		{
			sequenceChecker(passwordString);
		}
		catch (InvalidSequenceException e)
		{
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
		}
		
		return check_password_validity;
	}
	/**
	* @throws LengthException - the condition being the password has less than 6 characters
	*/
	public static boolean lengthChecker(String passwordString) throws LengthException {
		boolean check_length = false;
		
		if (passwordString.length() < 6) 
		{
			throw new LengthException("The password must be at least 6 characters long");
		}
		else
		{
			check_length = true;
		}
		
		return check_length;
	}	
	
	/**
	* @throws NoDigitException - the condition being that the password has no digits
	*/
	public static boolean digitChecker(String passwordString) throws NoDigitException {
		boolean check_digit = false;
		
		for (int i = 0; i < passwordString.length(); i++) {
				if (Character.isDigit(passwordString.charAt(i))) 
				{
					check_digit = true;
				}
			}
		
		if(check_digit == false)
		{
			throw new NoDigitException("The password must contain at least one digit");
		}
		
		return check_digit;
	}
	/**
	* @throws NoUpperAlphaException - the condition being that the password has no uppercase letter
	*/
	public static boolean upperChecker(String passwordString) throws NoUpperAlphaException {
		boolean check_upper = false;
		
		for (int i = 0; i < passwordString.length(); i++) {
				if (Character.isUpperCase(passwordString.charAt(i))) 
				{
					check_upper = true;
				}
			}
		
		if(check_upper == false)
		{
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		}
		
		return check_upper;
	}
		
	/**
	* @throws NoLowerAlphaException - the condition being the password has no lowercase letter
	*/
	public static boolean lowerChecker(String passwordString) throws NoLowerAlphaException {
		boolean check_lower = false;
		
		for (int i = 0; i < passwordString.length(); i++) {
				if (Character.isLowerCase(passwordString.charAt(i))) 
				{
					check_lower = true;
				}
			}
		
		if(check_lower == false)
		{
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		}
		
		return check_lower;
	}
	
	/**
	* @throws NoSpecialCharacterException - the condition being that the password has no special character
	*/
	public static boolean specialChecker(String passwordString) throws NoSpecialCharacterException {
		boolean check_special = true;
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(passwordString);
		check_special = (matcher.matches());
		
		if (matcher.matches())
		{
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}

			return true;
	}
	
	/**
	* @throws InvalidSequenceException - the condition being that there are more than 2 of the same chracter in the sequence of the password
	*/
	public static boolean sequenceChecker(String passwordString) throws InvalidSequenceException {
		boolean check_sequence = true;
		
		for (int i = 0; i < passwordString.length() - 2; i++) {
					if (passwordString.charAt(i+1) == passwordString.charAt(i+2) && passwordString.charAt(i) == passwordString.charAt(i+1))
					{
						check_sequence = false;
					}
			}
		
		if(check_sequence == false)
		{
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
		}
		
		return check_sequence;
	}
	
	/**
	* This will check if the password is strong or weak
	* It will return true if the password is weak and false if it is not.
	* @param  passwordString - this is the variable being tested.
	* @return true if found valid and false if not
	*/
	public static boolean isWeakPassword(String passwordString) {
		boolean strength_checker = false;
		
		if (passwordString.length() >= 6 && passwordString.length() <= 9)
		{
			strength_checker = true;
		}
		
		return strength_checker;
	}	
	
	
	/**
	 * It will create as well as return an arraylist of invalid passwords
	* @return ArrayList<String> of invalid passwords
	*/
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> pswdList) {
		
		ArrayList<String> invalid_checker = new ArrayList<String>();
		
		for ( int i = 0 ; i < pswdList.size() ; i++ ) {
			
			try 
			{
				isValidPassword(pswdList.get(i));	
			} 
			catch (Exception e) 
			{
				invalid_checker.add(pswdList.get(i) + " " + e.getMessage());
			}
			
		}
		
		return invalid_checker;
	}

}
