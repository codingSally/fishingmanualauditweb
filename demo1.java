package leetTest;

/**
 * Given nums = [2, 7, 11, 15], target = 9,

   Because nums[0] + nums[1] = 2 + 7 = 9,
   return [0, 1].
 * @author xueshangling
 *
 */
public class demo1 {

	public static void main(String[] args) {
		
		int[] given = new int[]{2, 7, 11, 15};
		int target = 9;
		
		int[] result = twoSum(given, target);
		
		System.out.println(result[0] + "_" + result[1]);
	}
	
	
	public static int[] twoSum(int[] given, int target) {
	     
		for(int i = 0; i < given.length; i++){
			for(int j= i+1 ;j<given.length; j++){
				if(given[i] + given[j] == target){
					return new int[] {i,j};
				}
			}
		}
		return new int[]{};
	}
}
