package leetTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * @author xueshangling
 * @date 2019-04-23
 */
public class demo18 {

	public static void main(String[] args) {
		
		int[] nums = {-5,5,4,-3,0,0,4,-2};
		int target = 4;
		List<List<Integer>> result = fourSum(nums, target);
		result.forEach(each -> {
			each.forEach(System.out::println);
		});
	}

    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	if(nums.length == 0 ){
    		return new ArrayList<List<Integer>>();
    	}
        
    	Set<List<Integer>> result = new HashSet<List<Integer>>();
//    	nums = [1, 0, -1, 0, -2, 2]
    	for(int index1 = 0; index1 < nums.length - 3; index1++){
    		for(int index2 = index1 + 1; index2 < nums.length - 2; index2 ++){
    			for(int index3 = index2 + 1; index3 < nums.length - 1; index3 ++){
    	    		for(int j = index3 + 1; j < nums.length; j ++){
    	    			if(sumIsTarget(nums[index1], nums[index2], nums[index3], nums[j], target)){
    	    				int[] temp = {nums[index1], nums[index2], nums[index3], nums[j]};
    	    				Arrays.sort(temp);
    	    				List<Integer> item = Arrays.asList(
    	    						temp[0],temp[1],temp[2],temp[3]
//    	    					nums[index1], nums[index2], nums[index3], nums[j]
    	    				);
    	    				result.add(item);
    	    			}
    	    		}
    			}
    		}
    	}
    	
    	return new ArrayList<List<Integer>>(result);
    }
    
    private static boolean sumIsTarget(int num1, int num2, int num3, int num4, int target){
    	int sum = num1 + num2 + num3 + num4;
    	return sum == target ? true : false;
    }
}
