package leetTest;

import java.util.Arrays;

/**
 * @description
 * 
 * 				Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 *              The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author xueshangling
 * @date 2019-03-26
 */
public class demo16 {

	public static void main(String args[]) {

		int[] nums = { -1, 2, 1, -4 };
		int target = 1;

		System.out.println(threeSumClosest(nums, target));
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums); // 优化后的快速排序
		// -4 -1 1 2
		int ret = nums[0] + nums[1] + nums[nums.length - 1];

		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int begin = i + 1;
			int end = length - 1;

			while (begin < end ) {
				int sum = nums[i] + nums[begin] + nums[end];
				if (sum == target) {
					return sum;
				} else if (sum > target) {
					end--;
				} else {
					begin++;
				}

				if (Math.abs(sum - target) < Math.abs(ret - target)) {
					ret = sum;
				}
			}
		}
		return ret;
	}
}
