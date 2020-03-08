package leetTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Valid Parentheses
 * @author xueshangling
 * @date 2019-06-05
 * 
 * Input: "()[]{}"
   Output: true
   
   Input: "([)]"
   Output: false
   
   Input: "{[]}"
   Output: true
 */
public class demo20 {

	public static void main(String[] args) {
		
		String s = "{]}";
        System.out.println(isValid(s));
	}
	
    public static boolean isValid(String s) {
    	
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	map.put(')', '(');
    	map.put('}', '{');
    	map.put(']', '[');
        
        Stack<Character> stack = new Stack<Character>();
        int length = s.length();
        
        for(int index = 0; index < length; index ++){
        	Character cur = s.charAt(index);
        	if('{' == cur || '[' == cur || '(' == cur){
        		stack.push(cur);
        	}else {
        		if(stack.isEmpty()){
        			return false;
        		}
        		Character top = stack.pop();
        		if(top != map.get(cur)){
        			stack.push(top);
        			stack.push(cur);
        		}
        	}
        }
    	return stack.isEmpty();
    }

}
