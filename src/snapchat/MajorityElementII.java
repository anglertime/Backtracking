package snapchat;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	// O(n) time and O(n) space with hashmap is straightforward
	// O(nlogn) time and O(1) space with refresh count is not hard
	/*
	 * Arrays.sort(nums);
        int freq = 0;
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < nums.length ; i ++) {
            if (i == 0) {
                freq ++;
            }
            if (i >= 1 && nums[i] == nums[i - 1]) {
                freq ++;
            }
            if (i >= 1 && nums[i] != nums[i - 1]) {
                freq = 1;
            }
            if (freq > nums.length / 3) {
                set.add(nums[i]);
                freq = 0;
            }
        }
        res.addAll(set);
        return res;
    }
	 */
	// O(n) time and O(1) space
	public List<Integer> majorityElement(int[] nums) {
        int major1 = Integer.MIN_VALUE;
        int major2 = Integer.MAX_VALUE;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0 ; i < nums.length ; i ++) {
            // initialization
            if (nums[i] != major2 && count1 == 0) {
                major1 = nums[i];
                count1 ++;
                continue;
            } else if (nums[i] != major1 && count2 == 0) {
                major2 = nums[i];
                count2 ++;
                continue;
            }
            
            if (nums[i] == major1) {
                count1 ++;
                continue;
            }
            if (nums[i] == major2) {
                count2 ++;
                continue;
            }
            
            if (count1 > 0) {
                count1 --;
            }
            if (count2 > 0) {
                count2 --;
            }
        }
        
        int freq1 = 0;
        int freq2 = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i ++) {
            if (nums[i] == major1) {
                freq1 ++;
            } else if (nums[i] == major2) {
                freq2 ++;
            }
        }
        if (freq1 > nums.length / 3) {
            res.add(major1);
        }
        if (freq2 > nums.length / 3) {
            res.add(major2);
        }
        return res;
    }
}
