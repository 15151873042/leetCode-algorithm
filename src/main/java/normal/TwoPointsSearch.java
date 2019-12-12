package normal;

/**
 * 二分查找
 * @author 胡鹏
 *
 */
public class TwoPointsSearch {

    /**
     * @Descripton 寻找一个数，存在则返回数组下标，不存在则返回-1
     * @author 胡鹏
     * @date 2019年11月25日 下午6:09:14
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // int right = nums.length;
        while(left <= right) { // while(left < right)
        	int mid = left + (right -left) / 2;
        	if(nums[mid] == target) {
        		return mid;
        	} else if (nums[mid] < target) {
        		left = mid + 1;
        	} else if (nums[mid] > target) {
        		right = mid - 1; // right = mid;
        	}
        }
        return -1;
    }
    
    /**
     * @Descripton 寻找左侧边界的二分搜索
     * @author 胡鹏
     * @date 2019年11月25日 下午8:16:56
     * @param nums
     * @param target
     * @return
     */
    public int left_bound(int[] nums, int target) {
    	int left = 0;
    	int right = nums.length -1;
    	while(left <= right) {
    		int mid = left + (right - left) / 2;
    		if(nums[mid] == target) {
    			right = mid;
    		} else if (nums[mid] < target) {
    			left = mid + 1;
    		} else if (nums[mid] > target) {
    			right = mid - 1;
    		}
    	}
    	return nums[left] == target ? left : -1;
    }
    
    /**
     * @Descripton 寻找右侧边界的二分搜索
     * @author 胡鹏
     * @date 2019年11月25日 下午8:17:03
     * @param nums
     * @param target
     * @return
     */
    public int right_bound(int[] nums, int target) {
    	int left = 0;
    	int right = nums.length -1;
    	while(left <= right) {
    		int mid = left + (right - left) / 2;
    		if(nums[mid] == target) {
    			left = mid;
    		} else if (nums[mid] < target) {
    			left = mid + 1;
    		} else if (nums[mid] > target) {
    			right = mid - 1;
    		}
    	}
    	return nums[left] == target ? left : -1;
    }
}
