package snapchat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WordReconstruction {
	public List<List<String>> wordReconstruction(String[] input, String[] dict) {
		// read input to get count information
		int[] map = new int[26];
		int totalLen = 0;
		for (int i = 0 ; i < input.length ; i ++) {
			for (int j = 0 ; j < input[i].length() ; j ++) {
				map[input[i].charAt(j) - 'A'] ++;
				totalLen ++;
			}
		}
		
		// we don't have to sort dict. but consider the time n^2, we could do so
		Arrays.sort(dict, new Comparator<String> () {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		List<List<String>> ret = new ArrayList<>();
		
		// iterate the dict
		for (int i = 0 ; i < dict.length ; i ++) {
			// we go through all possible combinations until totalLen / 2
			// 0 + totalLen, 1 + totalLen-1, 2 + totalLen-2, ..., one half + one half
			if (dict[i].length() <= totalLen/2) {
				helper(totalLen, i, dict, map, ret);
			} else if (dict[i].length() == totalLen) {
				if (checkOneString(dict[i], map)) {
					ret.add(new ArrayList<String>(Arrays.asList(dict[i])));
				}
			} else if (dict[i].length() > totalLen) {
				break;
			}
		}
		return ret;
	}
	
	private void helper(int totalLen, int start, String[] dict, int[] map, List<List<String>> ret) {
		for (int i = start + 1 ; i < dict.length ; i ++) {
			if (dict[start].length() + dict[i].length() == totalLen) {
				StringBuilder sb = new StringBuilder(dict[start]);
				sb.append(dict[i]);
				if (checkOneString(sb.toString(), map)) {
					ret.add(new ArrayList<String>(Arrays.asList(dict[start], dict[i])));
				}
			} else if (dict[start].length() + dict[i].length() > totalLen) {
				break;
			}
		}
	}
	
	private boolean checkOneString(String str, int[] map) {
		// make a copy
		int[] tmpMap = new int[26];
		for (int i = 0 ; i < map.length ; i ++) {
			tmpMap[i] = map[i];
		}
		
		boolean ret = true;
		// iterate str
		for (int i = 0 ; i < str.length() ; i ++) {
			tmpMap[str.charAt(i) - 'A'] --;
			if (tmpMap[str.charAt(i) - 'A'] < 0) {
				return false;
			}
		}
		return ret;
	}
//	private boolean checkTwoStrings(String str1, String str2, int[] map) {
//		// make a copy
//		int[] tmpMap = new int[26];
//		for (int i = 0 ; i < map.length ; i ++) {
//			tmpMap[i] = map[i];
//		}
//		
//		boolean ret = true;
//		for (int i = 0 ; i < str1.length() ; i ++) {
//			tmpMap[str1.charAt(i) - 'A'] --;
//			if (tmpMap[str1.charAt(i) - 'A'] < 0) {
//				return false;
//			}
//		}
//		
//		for (int i = 0 ; i < str2.length() ; i ++) {
//			tmpMap[str2.charAt(i) - 'A'] --;
//			if (tmpMap[str2.charAt(i) - 'A'] < 0) {
//				return false;
//			}
//		}
//		return ret;
//	}
}
