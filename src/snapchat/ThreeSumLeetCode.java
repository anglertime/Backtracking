package snapchat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSumLeetCode {
	/*
	 * List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
                if(sum >= 0) while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return result;
	 */
	
	/*
	 * List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
    
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;        // Skip same results
            int target = 0 - nums[i];
            int j = i + 1, k = len - 1;
            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]) j++;  // Skip same results
                    while(j < k && nums[k] == nums[k - 1]) k--;  // Skip same results
                    j++; k--;
                } else if(nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
	 */
	
	// ������������ʼ���㷨��ԭ���ˣ���Ϊ��̫���ظ����㲻����ϵͳҪ����������Ҫ��
	// ��map freq֮����ȥ������freqΪ2���ߴ��ڵ���3�������������Ȼ��ֻ��single appearance�ٸ�
	// ʵ����ֻ��leetcodeһ��ϵͳ�Լ���磬���ܶ���Ż��ļ�֦��solutions��Ī����ʱ������Ҳ����������Щ������ 
	// ����Ҳû��Ҫ��ϸ��leetcode���ʱ���ˣ���Ϊ�Ѿ�֪����nƽ���ˣ�������ʱ��ռ��͸���ˣ����ٸ�case���ޱ�Ҫ
	
	// ��Ȼ��85ms���ˣ��Ǻǣ��������һ��set�Լ�����������û���Ĵ����ظ��߹���triple����
	public List<List<Integer>> threeSum(int[] nums) {
		// ��Map-freq��֦������sort���input
		Arrays.sort(nums);
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0 ; i < nums.length ; i ++) {
			int freq = 1;
			if (map.containsKey(nums[i])) {
				freq += map.get(nums[i]);
			}
			map.put(nums[i], freq);
		}
		
		// 2. iterate nums
		boolean threeZeros = false;
		List<List<Integer>> ret = new ArrayList<>();
		for (int i = 0 ; i <= nums.length - 3 ; i ++) {
			if (map.get(nums[i]) >= 3) {
				if (nums[i] == 0) {
					threeZeros = true;
				}
			} else if (map.get(nums[i]) == 2) {
				oneSum(i + 2, nums, 0 - 2 * nums[i], ret);
			} else {
				twoSum(i + 1, nums, 0 - nums[i], ret);
			}
			map.put(nums[i], map.get(nums[i]) - 1);
		}
		if (threeZeros) {
		    ret.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
		}
		return ret;
    }
	
	private void twoSum(int start, int[] nums, int newTarget, List<List<Integer>> result) {
		int first = nums[start - 1];
		// find all possibilities from start in nums
		Set<Integer> set = new HashSet<>();
		for (int i = start ; i < nums.length ; i ++) {
			if (set.contains(newTarget - nums[i])) {
				List<Integer> newList = new ArrayList<>(Arrays.asList(first, newTarget - nums[i], nums[i]));
				result.add(newList);
			} else {
				set.add(nums[i]);
			}
		}
	}
	
	private void oneSum(int start, int[] nums, int newTarget, List<List<Integer>> result) {
		int first = nums[start - 1];
		for (int i = start ; i < nums.length ; i ++) {
			if (nums[i] == newTarget) {
				List<Integer> newList = new ArrayList<>(Arrays.asList(first, first, nums[i]));
				result.add(newList);
			}
		}
	}
}
		//		// ��Map-freq��֦������sort���input
//		Arrays.sort(nums);
//		
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0 ; i < nums.length ; i ++) {
//			int freq = 1;
//			if (map.containsKey(nums[i])) {
//				freq += map.get(nums[i]);
//			}
//			map.put(nums[i], freq);
//		}
//		
//		// 2. iterate nums
//		Set<List<Integer>> set = new HashSet<>();
//		for (int i = 0 ; i <= nums.length - 3 ; i ++) {
//			if (map.get(nums[i]) >= 3) {
//				if (nums[i] == 0) {
//					set.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
//				}
//			} else if (map.get(nums[i]) == 2) {
//				oneSum(i + 2, nums, 0 - 2 * nums[i], set);
//			} else {
//				twoSum(i + 1, nums, 0 - nums[i], set);
//			}
//			map.put(nums[i], map.get(nums[i]) - 1);
//		}
//		
//		List<List<Integer>> ret = new ArrayList<>();
//		ret.addAll(set);
//		return ret;
//    }
//	
//	private void twoSum(int start, int[] nums, int newTarget, Set<List<Integer>> result) {
//		int first = nums[start - 1];
//		// find all possibilities from start in nums
//		Set<Integer> set = new HashSet<>();
//		for (int i = start ; i < nums.length ; i ++) {
//			if (set.contains(newTarget - nums[i])) {
//				List<Integer> newList = new ArrayList<>(Arrays.asList(first, newTarget - nums[i], nums[i]));
//				result.add(newList);
//			} else {
//				set.add(nums[i]);
//			}
//		}
//	}
//	
//	private void oneSum(int start, int[] nums, int newTarget, Set<List<Integer>> result) {
//		int first = nums[start - 1];
//		for (int i = start ; i < nums.length ; i ++) {
//			if (nums[i] == newTarget) {
//				List<Integer> newList = new ArrayList<>(Arrays.asList(first, first, nums[i]));
//				result.add(newList);
//			}
//		}
//	}
//}
		//		// because the output are values not indices:
//        // 1. sort to make sure final duplicate list has same order
//		Arrays.sort(nums);
//		
//		// 2. iterate nums
//		Set<List<Integer>> set = new HashSet<>();
//		for (int i = 0 ; i <= nums.length - 3 ; i ++) {
//			int newTarget = 0 - nums[i];
//			twoSum(i + 1, nums, newTarget, set);
//		}
//		
//		List<List<Integer>> ret = new ArrayList<>();
//		ret.addAll(set);
//		return ret;
//    }
//	
//	private void twoSum(int start, int[] nums, int newTarget, Set<List<Integer>> result) {
//		int first = nums[start - 1];
//		// find all possibilities from start in nums
//		Set<Integer> set = new HashSet<>();
//		for (int i = start ; i < nums.length ; i ++) {
//			if (set.contains(newTarget - nums[i])) {
//				List<Integer> newList = new ArrayList<>(Arrays.asList(first, newTarget - nums[i], nums[i]));
//				result.add(newList);
//			} else {
//				set.add(nums[i]);
//			}
//		}
//	}
//}
	// ��Accepted
//		// because the output are values not indices:
//        // 1. sort to make sure final duplicate list has same order
//		Arrays.sort(nums);
//		
//		// 2. iterate nums
//		Set<List<Integer>> set = new HashSet<>();
//		for (int i = 0 ; i <= nums.length - 3 ; i ++) {
//			int newTarget = 0 - nums[i];
//			Set<List<Integer>> subproblem = twoSum(i + 1, nums, newTarget);
//			for (List<Integer> list : subproblem) {
//				List<Integer> newList = new LinkedList<>(list);
//				newList.add(0, nums[i]);
//				set.add(newList);
//			}
//		}
//		
//		List<List<Integer>> ret = new ArrayList<>();
//		ret.addAll(set);
//		return ret;
//    }
//	
//	private Set<List<Integer>> twoSum(int start, int[] nums, int newTarget) {
//		// find all possibilities from start in nums
//		Set<Integer> set = new HashSet<>();
//		Set<List<Integer>> ret = new HashSet<>();
//		for (int i = start ; i < nums.length ; i ++) {
//			if (set.contains(newTarget - nums[i])) {
//				List<Integer> newList = new ArrayList<>(Arrays.asList(newTarget - nums[i], nums[i]));
//				ret.add(newList);
//			} else {
//				set.add(nums[i]);
//			}
//		}
//		return ret;
//	}
//}
