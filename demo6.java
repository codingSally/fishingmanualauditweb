package leetTest;

/**
 * ZigZag
 * @author xueshangling
 * @date 2019-03-25
 */
public class demo6 {

	public static void main(String[] args) {
		
		String str = "PAYPALISHIRING";
		int numRows = 4;
		System.out.println(convert(str, numRows));
	}
	
	
    public static String convert(String s, int numRows) {
    	
    	if(s == null || s.length() == 0 || numRows < 0){
    		return "";
    	}
    	
    	if(numRows == 1){
    		return s;
    	}
        
    	StringBuffer result = new StringBuffer();
    	int size = 2*numRows -2;
    	for(int i =0; i< numRows; i++){
    		for(int j = i; j<s.length(); j+=size){
    			result.append(s.charAt(j));
    			if(i != 0 && i != numRows -1){
    				int xieSize = j + size -2*i;
    				if(xieSize < s.length()){
    					result.append(s.charAt(xieSize));
    				}
    			}
    		}
    	}
    	return result.toString();  
    }
}
