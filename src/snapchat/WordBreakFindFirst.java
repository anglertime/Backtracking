package snapchat;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakFindFirst {
	List<String> ret = new LinkedList<>();
	public List<String> wordBreakFindFirst(String s, Set<String> dict) {
		Set<Integer> visited = new HashSet<>();
		helper(0, s, dict, visited);
		return ret;
	}
	private boolean helper(int start, String s, Set<String> dict, Set<Integer> visited) {
		if (start >= s.length()) {
			return true;
		}
		if (visited.contains(start)) {
			return false;
		}
		for (int i = start ; i < s.length() ; i ++) {
			// space between i and i - 1 => we need to consider when i == 0, 
			// we check the entire String. Otherwise we cannot cover all cases by 
			// this space insertion. if we insert between i and i + 1, then our i can be s.length() - 1
			// now i and i + 1
			System.out.println(i + 1 + "   " + s.substring(start, i + 1));
			if (dict.contains(s.substring(start, i + 1))) {
				if (helper(i + 1, s, dict, visited)) {
					ret.add(0, s.substring(start, i + 1));
					return true;
				}
			}
		}
//		if (dict.contains(s.substring(start, s.length()))) {
//			ret.add(s.substring(start, s.length()));
//			return true;
//		}
//		for (int i = start + 1 ; i < s.length() ; i ++) {
//			if (dict.contains(s.substring(start, i))) {
//				if (helper(i, s, dict, visited)) {
//					ret.add(0, s.substring(start, i));
//				}
//				return true;
//			}
//		}
		visited.add(start);
		return false;
	}
}
