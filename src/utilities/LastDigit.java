package utilities;

/**
 * Strip last digit from an integer. 
 * 
 * @author victorpenalo
 *
 */
public class LastDigit {
	
	
	public static int stripLastDigit(int value){
		String stringOfValue = Integer.toString(value);		
		char lastChar = stringOfValue.charAt(stringOfValue.length()-1);
		
		int lastDigit = Integer.valueOf(lastChar);
		
		return lastDigit;
	}
		

}
