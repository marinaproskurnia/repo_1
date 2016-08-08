package mypackage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* Finds first non repeating character in String;
 * E.g. for String "Streets" -> 'r';
 */

public class FindFirstNonRepeatingChar {
	static String str = "Streets";
	public static void main(String[] args) {
		System.out.println("First non repeating character in string " + str + " is: " + getFirstNonRepeatingChar(str)); 
	}
	
	public static Character getFirstNonRepeatingChar(String str) {
		// using LinkedHashMap due to it maintains insertion order 
		// resulting map represents (char, number of repeating) as (key, value) pair		
		Map<Character, Integer> counterChar = new LinkedHashMap <Character, Integer> ();
		// iterating through each char in the string
		for(int i = 0; i < str.length(); i++) {
			// casting all characters to lower case
			Character c = str.toLowerCase().charAt(i); 
			//checking if this char already presents in the map
			if(counterChar.containsKey(c)) {
				// yes, so increment its value +1
				counterChar.put(c, counterChar.get(c) + 1);
			} else {
				// no, just add it
				counterChar.put(c, 1);
			}
		}
		  // iterating through LinkedHashMap
		for(Entry<Character, Integer> entry : counterChar.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		// due to the method should return some Character and it's done at the previous step
		return null;		
	}
}
