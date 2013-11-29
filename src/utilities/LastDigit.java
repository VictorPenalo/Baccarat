package utilities;

/**
 * Strip last digit from an integer. 
 * 
 * @author victorpenalo
 *
 */
public class LastDigit {
	
	
	public static int stripLastDigit(int value){
		// 1. Convert int value to String
		String stringOfValue = Integer.toString(value);
		
		// 2. Take last element of String
		char lastChar = stringOfValue.charAt(stringOfValue.length()-1);
		
		// 3. Convert the last element to an int
		int lastDigit = Character.getNumericValue(lastChar);
		
		return lastDigit;
	}
		

}
