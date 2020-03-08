package leetTest;

/**
 * @description String to number
 * @author xueshangling
 *Input: "42"
  Output: 42
  
  Input: "4193 with words"
  Output: 4193
  
  Input: "words and 987"
  Output: 0
  
  Input: "-91283472332"
  Output: -2147483648
  
  @date 2019-04-01
 */
public class demo8 {

	public static void main(String[] args) {
		
		String test = "     "; 
		System.out.println(myAtoi(test));
	}
	
    private static int myAtoi(String str) {
    	
    	str = str.trim();
		if(str == null || str.length() < 1 || " ".equals(str)){
			return 0;
		}
		
		char flag = '+';
		
		int i = 0;
		if(str.charAt(0) == '-'){
			flag = '-';
			i++;
		}else if(str.charAt(0) == '+'){
			flag = '+';
			i++;
		}
		
		int result = 0;
		
		while(str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
			if(Integer.MAX_VALUE /10 < result ||
					(Integer.MAX_VALUE /10 == result && Integer.MAX_VALUE %10 < str.charAt(i) - '0')){
				return flag == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		
		if(flag == '-'){
			result = -result;
		}
		
    	return result;
    }
}
