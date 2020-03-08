package leetTest;

/**
 * Longest Common Prefix
 * @author xueshangling
 * 
 * Input: ["flower","flow","flight"]
   Output: "fl"

   Input: ["dog","racecar","car"]
   Output: ""
 * @date 2019-04-44
 */
public class demo14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix2(strs));
	}
	
	private static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = new String();
        for (int j = 0; j < strs[0].length(); ++j) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; ++i) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }

    private static String longestCommonPrefix(String[] strs) {
        
    	int length = strs.length;
    	String prefix = "";
    	for(int i = 0 ; i < length ; i ++){
    		if("".equals(prefix)){
    			int size1 = strs[i].length();
    			int size2 = strs[i+1].length();
    			int size = Math.min(size1, size2);
    			
    			StringBuffer temp = new StringBuffer();
    			for(int j = 0 ; j < size ; j++){
    				if(strs[i].charAt(j) == strs[i+1].charAt(j)){
    					temp.append(strs[i].charAt(j));
    				}else {
    					if(null != temp){
    						prefix = temp.toString();
    					}
    					continue;
    				}
    			}
    		}else {
    			int sizei = strs[i].length();
    			int sizep = prefix.length();
    			int size = Math.max(sizei, sizep);
    			
    			for(int j = 0; j < size; j++){
    				if(prefix.charAt(j) == strs[i].charAt(j)){
    					prefix += strs[i].charAt(j);
    				}else {
    					continue;
    				}
    			}
    		}
    	}
    	
    	return prefix;
    }
}
