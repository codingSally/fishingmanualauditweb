package leetTest;

/**
 * @description 最大水位
 * @author xueshangling
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, 
 * the max area of water (blue section) the container can contain is 49.
 *@date 2019-04-02
 */
public class demo11 {

	public static void main(String[] args) {
		int[] height = {1,10,6,5,4,10,3,7};
		System.out.println(maxArea(height));
	}
	
	
    private static int maxArea(int[] height) {
        //[1,10,6,5,4,10,3,7]
    	if(height.length <= 1){
    		return 0;
    	}
    	int begin = 0;
    	int end = height.length - 1;
    	int max = (end - begin) * Math.min(height[begin], height[end]); 
    	while(begin < end){
    		if(height[begin] < height[end]){
    			begin ++;
    		}else {
    			end --;
    		}
    		if((end - begin) * Math.min(height[begin], height[end]) > max){
    			max = (end - begin) * Math.min(height[begin], height[end]);
    		}
    	}
    	
    	return max;
    }
}
