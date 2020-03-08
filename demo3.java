package leetTest;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/** 求最大子串
 * Input: "abcabcbb"
   Output: 3 
   Explanation: The answer is "abc", with the length of 3. 
 * @author xueshangling
 *
 */
public class demo3 {

	public static void main(String[] args) {

		int len = lengthOfLongestSubstring("bdb");
		System.out.println(len);
	}
	
    private static int lengthOfLongestSubstring(String s) {
    	
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            }
//            else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
        
    	int result = 0;
    	int length = s.length();
    	Set<Object> set = new HashSet<Object>();
    	int count = 0;
    	for(int i = 0; i< length; i++){
    		count ++ ;
    		Object obj = s.charAt(i);
    		if(count != i && length - i <= result && length != count ){
    			return result;
    		}
    		if((i < length -1 ) && Objects.equals(s.charAt(i), s.charAt(i+1))){
    			continue;
    		}
    		if(set.contains(obj)){
    			set.clear();
    			result = 0;
    			i = Math.abs(i- count);
    			count = 0;
    		}else {
    			set.add(s.charAt(i));
    		    result  = result >= set.size() ? result : set.size();
    		}
    	}
    	return result;
    }

}
