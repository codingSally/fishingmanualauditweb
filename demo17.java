package leetTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Letter Combinations of a Phone Number
 * @author xueshangling
 *	Input: "234"
  	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
   @date 2019-04-08
 */
public class demo17 {

	public static void main(String[] args) {
		
		String digits = "234";
		List<String> result = letterCombinations(digits);
		result.forEach(System.out::println);;
	}
	
	
    private static List<String> letterCombinations(String digits) {
        
    	List<String> result = new ArrayList<String>();
    	if(digits == null || digits.length() == 0 || digits.trim().equals("")){
    		return result;
    	}
    	Map<Character, List<String>> maps = new HashMap<Character, List<String>>();
    	maps.put('2', Arrays.asList("a","b","c"));
    	maps.put('3', Arrays.asList("d","e","f"));
    	maps.put('4', Arrays.asList("g","h","i"));
    	maps.put('5', Arrays.asList("j","k","l"));
    	maps.put('6', Arrays.asList("m","n","o"));
    	maps.put('7', Arrays.asList("p","q","r","s"));
    	maps.put('8', Arrays.asList("t","u","v"));
    	maps.put('9', Arrays.asList("w","x","y","z"));
    	
    	letterCombinationsRecur(digits, maps, 0, "", result);
    	return result;
    }
    
    private static void letterCombinationsRecur(String digits, Map<Character, List<String>> maps, int cursor, String out, List<String> ret){
    	if(cursor == digits.length()){
    		ret.add(out);
    		return;
    	}
    	
    	List<String> strList = maps.get(digits.charAt(cursor));
    	for(int i = 0 ; i < strList.size(); i++ ){
    		letterCombinationsRecur(digits, maps, cursor + 1 , out + strList.get(i), ret);
    	}
    }
}
