package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import normal.KMP;


public class Client {

	
	/**
	 * @Descripton 【两数之和】
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * @author 胡鹏
	 * @date 2019年11月13日 下午10:29:39
	 * @param nums 给定一个整数数组 nums
	 * @param target 和一个目标值 target
	 * @return
	 * int[]
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for(int i=0; i<nums.length; i++) {
			int res = target - nums[i];
			Integer resIndex = map.get(res);
			if(null != resIndex) {
				return new int[] {i, resIndex};
			}
			map.put(nums[i], i);
		}
		return null;
	}
	
	
    /**
     *
     * @Descripton 【整数反转】给出一个 32 位（比特位）的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @author 胡鹏
     * @date 2019年11月14日 下午10:43:41
     * @param x
     * @return
     * int
     */
    public static int reverse(int x) {
    	int result = 0;
    	do {
    		int pop = x % 10;
    		x /= 10;
    		if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && pop > 7)) {
    			return 0;
    		}
    		if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && pop < -8)) {
    			return 0;
    		}
    		result = result * 10 + pop;
    	} while(x != 0);
        return result;
    }
    
    
    
    /**
     *
     * @Descripton 【回文数】判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * @author 胡鹏
     * @date 2019年11月14日 下午10:45:03
     * @param x
     * @return
     * boolean
     */
    public static boolean isPalindrome(int x) {
    	
    	if (x!= 0 && x % 10 == 0 || x < 0) {
    		return false;
    	}
    	
    	int result = 0;
    	while(result < x) {
    		int pop = x % 10;
    		x /= 10;
    		result = result * 10 + pop;
    	}
    	
    	if(result == x || result/10  == x) {
    		return true;
    	}
    	return false;
    }
    
    
    /**
     *
     * @Descripton 【罗马数字转整数】
     * @author 胡鹏
     * @date 2019年11月14日 下午11:01:35
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
    	Map<Character, Integer> map = new HashMap<>(7);
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	
    	char[] charArray = s.toCharArray();
    	int length = charArray.length;
    	int result = map.get(charArray[length-1]);
    	for(int i=0; i< charArray.length-1; i++) {
    		int current = map.get(charArray[i]);
    		int next = map.get(charArray[i+1]);
    		if (current < next) {
    			result -= current;
    		} else {
    			result += current;
    		}
    	}
    	return result;
    }
    
    
    /**
     *
     * @Descripton 【最长公共前缀】编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
     * 例：
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * @author 胡鹏
     * @date 2019年11月15日 上午9:12:14
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0) {
    		return "";
    	}
        String tempStr = strs[0];
        boolean matchFlag = true;
        while(tempStr.length() > 0) {
        	matchFlag = true;
        	for(int i=1; i<strs.length; i++) {
        		if(!strs[i].startsWith(tempStr)) {
        			matchFlag = false;
        			break;
        		}
        	}
        	
        	if(matchFlag) {
        		return tempStr;
        	}
        	tempStr = tempStr.substring(0, tempStr.length()-1);
        }
        return "";
    }
    
    
    
    /**
     *
     * @Descripton 【有效的括号】给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 	1、左括号必须用相同类型的右括号闭合。
     *  2、左括号必须以正确的顺序闭合。
     * @author 胡鹏
     * @date 2019年11月19日 上午11:39:11
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
    	if(s.length()%2 != 0) {
    		return false;
    	}
    	
    	Map<Character, Character> map = new HashMap<>();
    	map.put('(', ')');
    	map.put('[', ']');
    	map.put('{', '}');
    	char[] charArray = s.toCharArray();
    	Stack<Character> stack = new Stack<>();
    	for(char ch : charArray) {
    		if(map.containsKey(ch)){
    			stack.push(ch);
    		} else {
    			if(stack.isEmpty()) {
    				return false;
    			}
    			Character topChar = stack.pop();
    			if(map.get(topChar) != ch) {
    				return false;
    			}
    		}
    	}
    	return stack.isEmpty();
    }
    
    
    
    /**
     *
     * @Descripton【合并两个有序链表】将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 示例：
     * 	输入：1->2->4, 1->3->4
     * 	输出：1->1->2->3->4->4
     * @author 胡鹏
     * @date 2019年11月19日 下午5:56:00
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode first = new ListNode(Integer.MIN_VALUE);
    	ListNode curr = first;
    	while(l1 != null && l2 != null) {
    		
    		if(l1.val < l2.val) {
    			curr.next = l1;
    			l1 = l1.next;
    		} else {
    			curr.next = l2;
    			l2 = l2.next;
    		}
    		curr = curr.next;
    	}
    	curr.next = l1==null ? l2 : l1;
    	return first.next;
    }
    
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    
	
	
    /**
     *
     * @Descripton 【删除排序数组中的重复项】
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * @author 胡鹏
     * @date 2019年11月19日 下午5:57:33
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
    	if(nums.length == 0) {
    		return 0;
    	}
    	
    	int i=0;
    	for(int j=1; j<nums.length; j++) {
    		if(nums[i] != nums[j]) {
    			i++;
    			nums[i] = nums[j];
    		}
    	}
    	System.out.println(Arrays.toString(nums));
    	return i+1;
    }
	
	
    /**
     *
     * @Descripton 【移除元素】给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @author 胡鹏
     * @date 2019年11月19日 下午6:50:45
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
    	int i=-1;
    	for(int j=0; j<nums.length; j++) {
    		if(nums[j] != val) {
    			i++;
    			nums[i] = nums[j];
    		}
    	}
    	return i + 1;
    }
    
    
    /**
     *
     * @Descripton 类似JDK indexOf
     * @author 胡鹏
     * @date 2019年11月20日 上午9:52:50
     * @param haystack 
     * @param needle 需要查找的字符串
     * @return
     */
    public static int indexOf(String haystack, String needle) {
    	if(needle.equals("")) {
    		return 0;
    	}
    	return new KMP("ll").search(haystack);
    }
    
    
	

    
    /**
     * @Descripton给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * @author 胡鹏
     * @date 2019年11月21日 下午2:45:11
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
    	int left = 0;
    	int right = nums.length -1;
    	while(left <= right) {
    		int mid = left + (right - left) / 2;
    		if(nums[mid] == target) {
    			return mid;
    		} else if (nums[mid] < target) {
    			left = mid + 1;
    		} else if (nums[mid] > target) {
    			right = mid - 1;
    		}
    	}

        return left;
    }
    
    
    
    /**
     * @Descripton 【报数】报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * 1、1
     * 2、11
     * 3、21
     * 4、1211
     * 5、111221
     * @author 胡鹏
     * @date 2019年11月27日 下午6:29:18
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
    	if(n ==1) {
    		return "1";
    	}
    	
    	String result = countAndSay(n-1);
        StringBuilder builder = new StringBuilder();
        char currCh = result.charAt(0);
        int startIndex = 0;
        for(int i=0; i<result.length(); i++) {
        	if(currCh != result.charAt(i)) {
        		builder.append(i-startIndex).append(currCh);
        		currCh = result.charAt(i);
        		startIndex = i;
        	}
        }
        builder.append(result.length()-startIndex).append(currCh);
        return builder.toString();
    }
    
    
    /**
     * @Descripton 【最大自序和】给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @author 胡鹏
     * @date 2019年11月27日 下午6:30:58
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
    	int ans = nums[0];
    	int sum = 0;
    	for(int num: nums) {
    		if(sum > 0) {
    			sum += num;
    		} else {
    			sum = num;
    		}
    		ans = Math.max(ans, sum);
    	}
    	return ans;
    }
    
    
    
    /**
     * @Descripton 【爬楼梯-70】
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @author 胡鹏
     * @date 2019年11月29日 下午5:15:37
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
    	int[] arr = new int[n+1];
    	return test(n, arr);
    }
    
    public static int test(int n, int[] arr) {
        if(n == 1) {
        	return 1;
        } else if(n == 2) {
        	return 2;
        } else {
        	if(arr[n] != 0) {
        		return arr[n];
        	}
        	arr[n] = test(n-1, arr) + test(n-2, arr);
        	return arr[n];
        }
    }
    
    
	public static void main(String[] args) {
		int climbStairs = climbStairs(10);
		System.out.println(climbStairs);
	}

}
