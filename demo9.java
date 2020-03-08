package leetTest;

/**
 * 判断回文数
 * @author xueshangling
 * 121 -- true
 * 21312
 * -121 -- false 
 * 10 -- false
 * @date 2019-04-01
 */
public class demo9 {

	public static void main(String[] args) {
		
		int test = 1221;
		System.out.println(isPalindrome2(test));

	}
	
    private static boolean isPalindrome(int x) {
        
    	String temp = String.valueOf(x);
    	
    	if(temp.length() == 1){
    		return true;
    	}
    	if(temp.startsWith("-") || temp.startsWith("+")){
    		return false;
    	}
    	int middle = temp.length() / 2;

    	StringBuffer sb = null;
    	if(temp.length() % 2 == 0){
        	sb = new StringBuffer();
        	for(int index = temp.length() -1 ; index > middle - 1; index --){
        		sb.append(temp.charAt(index));
        	}

    	}else {
        	sb = new StringBuffer();
        	for(int index = temp.length() -1 ; index > middle; index --){
        		sb.append(temp.charAt(index));
        	}
    	}
    	
    	if(Integer.parseInt(temp.substring(0, middle)) != 
    			Integer.parseInt(sb.toString())){
    		return false;
    	}

    	return true;
    }
    
    //https://www.cnblogs.com/grandyang/p/4125510.html
    static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
