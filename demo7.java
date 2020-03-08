package leetTest;

import java.util.Stack;

/**
 * Input: 123 Output: 321
 * 
 * Input: -123 Output: -321
 * 
 * Input: 120 Output: 21
 * 
 * @author xueshangling
 * @date 2019-03-28
 */
public class demo7 {

	public static void main(String[] args) {
		
		int test =  321;
		System.out.println(reverse2(test));
	}

	public static int reverse(int x) {

		if(x > 2147483647 || x < -2147483647){
			return 0;
		}
		String xStr = String.valueOf(x);
		Stack<Character> stack = new Stack<Character>();
		
		char head = xStr.charAt(0);
		String ret = "";
		if(head == '-'){
			ret = "-";
		}
		
		int index = 0;
		while(index < xStr.length()){
			char item = xStr.charAt(index);
			if(item == '-'){
				index ++;
				continue;
			}
			if(xStr.charAt(xStr.length() -1) != '0'){
				stack.push(item);
			}else {
				if(item != '0' || Integer.parseInt(xStr.substring(index)) != 0){
					stack.push(item);
				}
			}
			index ++;
		}

		while(!stack.isEmpty()){
			String temp  = ret + stack.pop();
			ret = temp;
		}
		if(ret.equals("")){
			return 0;
		}
		if(!ret.startsWith("-") && ret.length() >= 10){
			return 0;
		}
		return Integer.valueOf(ret).intValue();
	}
	
    public static int reverse2(int x) {
        if(x == 0)
            return 0;
        int result = 0;

        while(x != 0){
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10)
                return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }
        
        return result;
    }
}
