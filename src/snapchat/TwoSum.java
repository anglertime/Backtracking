package snapchat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
//sum2，求第一个正数数组里两个数加起来是target数， 比如[2,4,5,6,2,5,3,1] 加起来是10，答案[4,6]，第一个的定义是后一个数的index是所有结果里的最小的。
	public static int[] twoSum(int[] x, int target) {
		int[] ret = new int[2];
		// if we need to return indices, use map.
		Set<Integer> set = new HashSet<>();
		for (int i = 0 ; i < x.length ; i ++) {
			if (set.contains(target - x[i])) {
				ret = new int[] {target - x[i], x[i]};
				return ret;
			} else {
				set.add(x[i]);
			}
		}
		return ret;
	}
	
	public static void main(String args[]) {
		int[] input1 = new int[] {2,3,4,5,6,2,5,7,8};
		int target1 = 10;
		
		int[] res1 = twoSum(input1, target1);
		// 2 and 4
		System.out.println(res1[0]);
		System.out.println(res1[1]);
		
		int[] input2 = new int[] {2,3,94,5,100,-5,105,6,92,95,97,98};
		int target2 = 100;
		
		int[] res2 = twoSum(input2, target2);
		// -5 and 105
		System.out.println(res2[0]);
		System.out.println(res2[1]);
	}
	
	public static int[] twoSumIndices(int[] x, int target) {
//		int[] ret = new int[2];
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0 ; i < x.length ; i ++) {
//			if (map.containsKey(target - x[i])) {
//				ret = new int[] {map.get(target - x[i]), i};
//				return ret;
//			} else {
//				map.put(x[i], i);
//			}
//		}
//		return ret;
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0 ; i < x.length ; i ++) {
			if (map.containsKey(target - x[i])) {
				return new int[] {map.get(target - x[i]), i};
			}
			map.put(x[i], i);
		}
		return new int[2];
	}
}
