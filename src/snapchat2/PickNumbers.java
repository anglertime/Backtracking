package snapchat2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PickNumbers {
	public boolean canWin(int n, int target) {
		// exception
		if (target < 1 || target > (n * (n + 1)) / 2) {
			throw new IllegalArgumentException("Invalid input!");
		}
		List<Integer> list = new LinkedList<>();
		for (int i = 1 ; i <= n ; i ++) {
			list.add(i);
		}
		int nrOfPicks = optimalChoice(list, target);
		if (nrOfPicks % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}
	private int optimalChoice(List<Integer> list, int target) {
		int maxCount = findMaxCount(list, target);
		if (maxCount == 1) {
			System.out.println("Last pick : " + list.get(list.size() - 1));
			return 1;
		}
		// optimal choice such that the returned integer from chil is even
		for (int i = 0 ; i < list.size() ; i ++) {
			List<Integer> tmpList = new LinkedList<>(list);
			tmpList.remove(i);
			int chilNr = optimalChoice(tmpList, target - list.get(i));
			if (chilNr % 2 == 0) {
				return chilNr + 1;
			}
		}
		// lose anyway, return an even number
		return 2;
	}
	
	
	
	public boolean canWin1(int n, int target) {
		// exception
		if (target < 1 || target > (n * (n + 1)) / 2) {
			throw new IllegalArgumentException("Invalid input!");
		}
//		Set<Integer> set = new HashSet<>();
//		for (int i = 1 ; i <= n ; i ++) {
//			set.add(i);
//		}
		List<Integer> list = new LinkedList<>();
		for (int i = 1 ; i <= n ; i ++) {
			list.add(i);
		}
		int nrOfPicks = helper(list, target);
		if (nrOfPicks % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}
	private int helper(List<Integer> list, int target) {
		// exit condition : max >= target (or maxCount == 1)
		int maxCount = findMaxCount(list, target);
		if (maxCount == 1) {
			System.out.println("Last pick : " + list.get(list.size() - 1));
			return 1;
		}
		// optimal choice : 1. if odd, try to pick the smallest 
		// that make the new maxCount even. 2. if even, try to keep it even =>
		for (int i = 0 ; i < list.size() ; i ++) {
			List<Integer> tmpList = new LinkedList<>(list);
			tmpList.remove(i);
			int curMaxCount = findMaxCount(tmpList, target - list.get(i));
			if (maxCount % 2 == 1 && curMaxCount % 2 == 0) {
				return helper(tmpList, target - list.get(i)) + 1;
			} else if (maxCount % 2 == 0 && curMaxCount % 2 == 0) {
				return helper(tmpList, target - list.get(i)) + 1;
			}
		}
		target -= list.get(0);
		list.remove(0);
		return helper(list, target) + 1;
	}
	private int findMaxCount(List<Integer> list, int target) {
		int maxCount = 0;
		int sum = 0;
		for (int i = list.size() - 1 ; i >= 0  ; i --) {
			sum += list.get(i);
			maxCount ++;
			if (sum >= target) {
				break;
			}
		}
		return maxCount;
	}
}
