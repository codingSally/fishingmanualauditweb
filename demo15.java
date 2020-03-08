package leetTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 3Sum
 * @author xueshangling
 *Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
  [-1, 0, 1],
  [-1, -1, 2]
 ]
 @date 2019-04-04
 */
public class demo15 {

	public static void main(String[] args) {

		int[] nums = {-2,0,1,1,2};
		
		List<List<Integer>> ret = threeSum2(nums);
		ret.forEach(each -> {
			each.forEach(item -> {
				System.out.print(item + " ");
			});
		});
	}

    private static  List<List<Integer>> threeSum(int[] nums) {
        //[-4, -1, -1, 0, 1, 2]
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length == 0){
    		return ret;
    	}
    	Arrays.sort(nums);
    	int begin = 0;
    	int end = nums.length -1;
    	
    	int result = 0;
    	boolean tag = true;
    	while(begin < end){
    		int middle = (begin + end) / 2;
    		result = nums[begin] + nums[end];
    		if(result < 0){
    			int tend = end - 1;
    			while(tend >= middle){
    				if(result + nums[tend] == 0){
    					ret.add(Arrays.asList(nums[begin], nums[end], nums[tend]));
    				}
    				tend --;
    			}
    			begin ++;
    		}else if (result > 0){
    			int tbegin = begin + 1;
    			while(tbegin <= middle){
    				if(result + nums[tbegin] == 0){
    					ret.add(Arrays.asList(nums[begin], nums[end], nums[tbegin]));
    				}
    				tbegin ++;
    			}
    			end --;
    		}else {
    			for(int i = begin + 1; i < end; i ++){
    				if((nums[begin] == nums[end]) && (nums[end] == nums[i]) && tag){
    					ret.add(Arrays.asList(nums[begin], nums[end], nums[i]));
    					tag = false;
    					break;
    				}
    				
    				if(nums[i] == 0 && tag){
    					ret.add(Arrays.asList(nums[begin], nums[end], nums[i]));
    					break;
    				}
    			}
    			if(end - middle >= (middle - begin)){
    				end --;
    				while(end > 0 && nums[end] == nums[end+1]){
    					end --;
    				}
    			}else {
    				begin ++;
    				while(begin < nums.length && nums[begin] == nums[begin-1]){
    					begin ++;
    				}
    			}
    		}
    	}
    	
    	return ret;
    }
    
    private static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int k = 0 ; k< nums.length -2 ; k++){
        	int i = k+1;
        	int j = nums.length - 1;
        	int target = 0 - nums[k];
        	
        	while(i < j){
        		if(nums[i] + nums[j] == target){
        			 lists.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
        			 while(i < j && nums[i] == nums[i-1]) i++;
        			 while(i < j && nums[j] == nums[j+1]) j--;
        		}else if(nums[i] + nums[j] < target){
        			i ++;
        		}else {
        			j --;
        		}
        	}
        	while(k < nums.length - 2 &&  nums[k] == nums[k + 1]){
        		k++;
        	}
        }
        return lists;
    }
    
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int k = 0; k < nums.length - 2; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            int target = 0 - nums[k];
            while(i < j) {
                if(nums[i]+ nums[j] == target) {
                    lists.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
                    while(i < j && nums[i] == nums[i - 1]) i++;
                    while(i < j && nums[j] == nums[j + 1]) j--;
                }
                else if(nums[i]+ nums[j] < target) i++;
                else j--;
            }
            while(k < nums.length - 2 && nums[k] == nums[k+1])
                k++;
        }

        return lists;
    }
}
