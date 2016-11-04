package snapchat;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumMyFollowUp {
// return all possible combinations: 1. indices combination 2. value combination(no duplicates)
	public List<List<Integer>> twoSumMyFollowUp1(int[] x, int target) {
		// 1. indices combinations
		Map<Integer, Integer> map = new HashMap<>();
		List<List<Integer>> ret = new ArrayList<>();
		for (int i = 0 ; i < x.length ; i ++) {
			if (map.containsKey(target - x[i])) {
				List<Integer> list = new ArrayList<>(Arrays.asList(map.get(target - x[i]), i));
				ret.add(list);
			} else {
				map.put(x[i], i);
			}
		}
		return ret;
	}
	
	public Set<List<Integer>> twoSumMyFollowUp2(int[] x, int target) {
		// 2. value combinations
		Set<Integer> set = new HashSet<>();
		Set<List<Integer>> ret = new HashSet<>();
		for (int i = 0 ; i < x.length ; i ++) {
			if (set.contains(target - x[i])) {
				List<Integer> list = new ArrayList<>(Arrays.asList(target - x[i], x[i]));
				ret.add(list);
			} else {
				set.add(x[i]);
			}
		}
		return ret;
	}
}
