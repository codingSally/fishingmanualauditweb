package leetTest;

/**
 * Median of Two Sorted Arrays
 * @author xueshangling
 * nums1 = [1, 3]
   nums2 = [2]

   The median is 2.0
   
   nums1 = [1, 2]
   nums2 = [3, 4]

   The median is (2 + 3)/2 = 2.5
   
   找有序数组的中位数
   中位数的定义：奇数个就是中间的数字  偶数个就是中间两位的平均值
 */
public class demo4 {

	public static void main(String[] args) {
		
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		double result = findMedianSortedArrays(nums1,nums2);
		System.out.println(result);
	}
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	
    	if(nums1.length == 0 && nums2.length == 0){
    		return 0;
    	}
    	if(nums1.length == 0){
    		int mid = nums2.length/2;
    		if(nums2.length % 2 == 0){
    			return (nums2[mid -1] + nums2[mid])/2.0;
    		}else {
    			return nums2[mid];
    		}
    	}
    	
    	if(nums2.length == 0){
    		int mid = nums1.length/2;
    		if(nums1.length % 2 == 0){
    			return (nums1[mid -1] + nums1[mid])/2.0;
    		}else {
    			return nums1[mid];
    		}
    	}
    	int[] combi = new int[nums1.length + nums2.length];
    	int k = 0;
//    	for(int i = 0; i < nums1.length; )'
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	int i = 0;
    	int j = 0;
    	while(i < len1 && j < len2){
    		if(nums1[i] <= nums2[j]){
    			combi[k++] = nums1[i];
    			i++;
//    			k++;
    		}else {
    			combi[k++] = nums2[j];
    			j++;
//    			k++;
    		}
    	}
    	while(i < len1){
    		combi[k++] = nums1[i++];
    	}
    	while(j < len2){
    		combi[k++] = nums2[j++];
    	}
    	
		int mid = combi.length/2;
		System.out.println(combi.length + " " + mid);
		if(combi.length % 2 == 0){
			return (combi[mid -1 ] + combi[mid])/2.0;
		}else {
			return combi[mid];
		}
    }

}
