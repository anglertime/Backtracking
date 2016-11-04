package snapchat2;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minimumWindowSubstring(String s, String target) {
		int totalCount = target.length();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0 ; i < target.length() ; i ++) {
			char cur = target.charAt(i);
			int freq = 1;
			if (map.containsKey(cur)) {
				freq += map.get(cur);
			}
			map.put(cur, freq);
		}
		int start = 0;
		String ret = "";
		int minLen = Integer.MAX_VALUE;
		for (int i = 0 ; i < s.length() ; i ++) {
			char cur = s.charAt(i);
			if (!map.containsKey(cur)) {
				continue;
			}
			map.put(cur, map.get(cur) - 1);
			if (map.get(cur) >= 0) {
				totalCount --;
			}
			if (totalCount > 0) {
			    continue;
			}
			for (int j = start ; j <= i ; j ++) {
				char tmp = s.charAt(j);
				if (map.containsKey(tmp) && map.get(tmp) == 0) {
					start = j;
					break;
				} else if (map.containsKey(tmp) && map.get(tmp) < 0) {
					map.put(tmp, map.get(tmp) + 1);
				}
			}
			if (i - start + 1 < minLen) {
				ret = s.substring(start, i + 1);
				minLen = i - start + 1;
			}
		}
		return ret;
	}
}
		//		// read target information
//		int totalCount = target.length();
//		Map<Character, Integer> map = new HashMap<>();
//		for (int i = 0 ; i < target.length() ; i ++) {
//			char cur = target.charAt(i);
//			int freq = 1;
//			if (map.containsKey(cur)) {
//				freq += map.get(cur);
//			}
//			map.put(cur, freq);
//		}
//		int start = 0;
//		String ret = "";
//		int minLen = Integer.MAX_VALUE;
//		boolean boundary = false;
//		for (int i = 0 ; i < s.length() ; i ++) {
//			char cur = s.charAt(i);
//			if (!map.containsKey(cur)) {
//				continue;
//			}
//			if (totalCount > 0) {
//				map.put(cur, map.get(cur) - 1);
//				if (map.get(cur) >= 0) {
//					totalCount --;
//				}
//				if (totalCount == 0) {
//					boundary = true;
//				}
//			}
//			if (totalCount > 0) {
//				continue;
//			}
//			if (!boundary) {
//				map.put(cur, map.get(cur) - 1);
//			}
//			if (boundary) {
//				boundary = false;
//			}
//			for (int j = start ; j <= i ; j ++) {
//				char tmp = s.charAt(j);
//				if (map.containsKey(tmp) && map.get(tmp) == 0) {
//					start = j;
//					break;
//				} else if (map.containsKey(tmp) && map.get(tmp) < 0) {
//					map.put(tmp, map.get(tmp) + 1);
//				}
//			}
//			if (i - start + 1 < minLen) {
//				ret = s.substring(start, i + 1);
//				minLen = i - start + 1;
//			}
//		}
//		return ret;
//	}
//}
		//		// read target information
//		int totalCount = target.length();
//		Map<Character, Integer> map = new HashMap<>();
//		for (int i = 0 ; i < target.length() ; i ++) {
//			char cur = target.charAt(i);
//			int freq = 1;
//			if (map.containsKey(cur)) {
//				freq += map.get(cur);
//			}
//			map.put(cur, freq);
//		}
//		int start = 0;
//		String ret = "";
//		int minLen = Integer.MAX_VALUE;
//		boolean boundary = false;
//		for (int i = 0 ; i < s.length() ; i ++) {
//			char cur = s.charAt(i);
//			if (!map.containsKey(cur)) {
//				continue;
//			}
//			if (totalCount > 0) {
//				map.put(cur, map.get(cur) - 1);
//				if (map.get(cur) >= 0) {
//					totalCount --;
//				}
//				if (totalCount == 0) {
//					boundary = true;
//				}
//			}
//			if (totalCount > 0) {
//				continue;
//			}
//			// find start
//			for (int j = start ; j <= i ; j ++) {
//				char tmp = s.charAt(j);
//				if (!map.containsKey(tmp)) {
//					continue;
//				}
//				if (map.get(tmp) == 0) {
//					if (tmp != cur) {
//						start = j;
//						break;
//					}
//				} else if (map.get(tmp) < 0) {
//					map.put(tmp, map.get(tmp) + 1);
//				}
//			}
//			if (!boundary) {
//				map.put(cur, map.get(cur) - 1);
//			}
//			if (boundary) {
//				boundary = false;
//			}
//			if (i - start + 1 < minLen) {
//				System.out.println(i);
//				ret = s.substring(start, i + 1);
//				minLen = i - start + 1;
//			}
//		}
//		return ret;
//	}
//}
