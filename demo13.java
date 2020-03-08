package leetTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Integer
 *  I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
 * @author xueshangling
 * @date 2019-04-03
 */
public class demo13 {

	public static void main(String[] args) {
		
		String test = "MCMXCIV";
		System.out.println(romanToInt(test));

	}

    private static int romanToInt(String s) {
        
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	map.put('M', 1000);
    	map.put('D', 500);
    	map.put('C', 100);
    	map.put('L', 50);
    	map.put('X', 10);
    	map.put('V', 5);
    	map.put('I', 1);
    	
        int length = s.length();
        int result = 0;
        int pre = 0;
        for (int i = length - 1; i >= 0; i--) {
            char key = s.charAt(i);
            int value = map.get(key);
            if (value >= pre) {
                result += value;
            } else {
                result -= value;
            }

            pre = value;
        }
    	
    	return result;
    }
}
