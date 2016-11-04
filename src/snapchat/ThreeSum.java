package snapchat;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
// sum3�����һ��������������������������target���� ����[2,4,5,6,2,5,3,1] ��������10����[2,6,2]����һ���Ķ����Ǻ�һ������index�����н�������С�ġ�
	public static int[] threeSum(int[] x, int target) {
		// ���indices�ȽϺã���Ϊ���Ҫ���values����ôÿ�ι̶�һ����ʣ�µ�two sum��ʱ���Ҫ��סvalues����Ҫ��ס���һ��index
		int[] ret = new int[3];
		int end = x.length - 1;
		for (int i = 0 ; i <= end ; i ++) {
			int remainder = target - x[i];
			List<Integer> res = twoSum(i + 1, end, x, remainder);
			if (res.size() == 2) {
				ret = new int[] {i, res.get(0), res.get(1)};
				end = res.get(1) - 1;
			}
		}
		return ret;
	}
	
	public static List<Integer> twoSum(int start, int end, int[] x, int target) {
		if (start > end) {
			return new ArrayList<>();
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start ; i <= end ; i ++) {
			if (map.containsKey(target - x[i])) {
				return new ArrayList<>(Arrays.asList(map.get(target - x[i]), i));
			} else {
				map.put(x[i], i);
			}
		}
		return new ArrayList<>();
	}
	
	public static void main(String args[]) {
		int[] input = new int[] {4, 1, 1, 8, 5, 14, 25, 35, 11, 18};
		int target = 20;
		int[] res = threeSum(input, target);
		System.out.println("expected 1 : " + res[0]);
		System.out.println("expected 4 : " + res[1]);
		System.out.println("expected 5 : " + res[2]);
	}
}
