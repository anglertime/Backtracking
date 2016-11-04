package snapchat;

import java.util.HashMap;
import java.util.Map;

public class WildcardMatching {
	Map<String, Boolean> map;
	public boolean isMatch(String s, String p) {
		// id1_id2
		map = new HashMap<>();
        if (!p.equals("")) {
    		StringBuilder sbP = new StringBuilder();
    		sbP.append(p.charAt(0));
    		for (int i = 1 ; i < p.length() ; i ++) {
    		    if (p.charAt(i) == '*' && p.charAt(i - 1) == '*') {
    		        continue;
    		    }
    		    sbP.append(p.charAt(i));
    		}
    		p = sbP.toString();
        }
		return compareTwoStrings(0, s, 0, p);
	}
	
	private boolean backtracking(int indexStr, String str, int index, String asteriskStr) {
		if (index == asteriskStr.length() - 1) {
			return true;
		}
		
		boolean ret = false;
		int strID = indexStr;
		int asteriskStrID = index + 1;
		while (strID < str.length()) {
			if (asteriskStr.charAt(asteriskStrID) == '?' || str.charAt(strID) == asteriskStr.charAt(asteriskStrID)) {
				if (map.containsKey((strID + 1) + "_" + (asteriskStrID + 1))) {
					if (map.get((strID + 1) + "_" + (asteriskStrID + 1))) {
						return true;
					}
				} else {
					if (compareTwoStrings(strID + 1, str, asteriskStrID + 1, asteriskStr)) {
						map.put((strID + 1) + "_" + (asteriskStrID + 1), true);
						return true;
					}
					map.put((strID + 1) + "_" + (asteriskStrID + 1), false);
				}
				if (asteriskStrID + 1 < asteriskStr.length() && asteriskStr.charAt(asteriskStrID + 1) == '*') {
					return false;
				}
			}
			strID ++;
		}
		map.put(indexStr + "_" + index, false);
		return ret;
	}
	
	private boolean compareTwoStrings(int id1, String str1, int id2, String str2) {
		if (id1 >= str1.length() && id2 >= str2.length()) {
			return true;
		} else if (id1 >= str1.length() || id2 >= str2.length()) {
			return differentLength(id1, str1, id2, str2);
		}
		
		while (id1 < str1.length() && id2 < str2.length()) {
			if (str2.charAt(id2) == '*') {
				boolean cur = backtracking(id1, str1, id2, str2);
				map.put(id1 + "_" + id2, cur);
				return cur;
			}
			if (str2.charAt(id2) != '?' && str1.charAt(id1) != str2.charAt(id2)) {
				map.put(id1 + "_" + id2, false);
				return false;
			}
			id1 ++;
			id2 ++;
		}
		boolean cur = differentLength(id1, str1, id2, str2);
		map.put(id1 + "_" + id2, cur);
		return cur;
	}
	
	private boolean differentLength(int sID, String s, int pID, String p) {
		if (sID == s.length() && pID != p.length()) {
			return checkAsterisk(p, pID);
		} else if (sID != s.length() && pID == p.length()) {
			return checkAsterisk(s, sID);
		} else if (sID == s.length() && pID == p.length()){
			return true;
		}
		return false;
	}
	
	private boolean checkAsterisk(String longer, int index) {
		while (index < longer.length()) {
			if (longer.charAt(index) != '*') {
				return false;
			}
			index ++;
		}
		return true;
	}
}

//	Map<String, Boolean> map;
//	public boolean isMatch(String s, String p) {
//		// id1_id2
//		map = new HashMap<>();
//        if (!p.equals("")) {
//    		StringBuilder sbP = new StringBuilder();
//    		sbP.append(p.charAt(0));
//    		for (int i = 1 ; i < p.length() ; i ++) {
//    		    if (p.charAt(i) == '*' && p.charAt(i - 1) == '*') {
//    		        continue;
//    		    }
//    		    sbP.append(p.charAt(i));
//    		}
//    		p = sbP.toString();
//        }
//		return compareTwoStrings(0, s, 0, p);
//	}
//	
//	private boolean backtracking(int indexStr, String str, int index, String asteriskStr) {
//		if (index == asteriskStr.length() - 1) {
//			return true;
//		}
//		
//		boolean ret = false;
//		int strID = indexStr;
//		int asteriskStrID = index + 1;
//		while (strID < str.length()) {
//			if (str.charAt(strID) == '?' || asteriskStr.charAt(asteriskStrID) == '?' || str.charAt(strID) == asteriskStr.charAt(asteriskStrID)) {
//				if (map.containsKey((strID + 1) + "_" + (asteriskStrID + 1))) {
//					if (map.get((strID + 1) + "_" + (asteriskStrID + 1))) {
//						return true;
//					} else if (asteriskStrID + 1 < asteriskStr.length() && asteriskStr.charAt(asteriskStrID + 1) == '*') {
//						return false;
//					}
//				} else {
//					if (compareTwoStrings(strID + 1, str, asteriskStrID + 1, asteriskStr)) {
//						map.put((strID + 1) + "_" + (asteriskStrID + 1), true);
//						return true;
//					} else if (asteriskStrID + 1 < asteriskStr.length() && asteriskStr.charAt(asteriskStrID + 1) == '*') {
//						return false;
//					}
//					map.put((strID + 1) + "_" + (asteriskStrID + 1), false);
//				}
//			}
//			strID ++;
//		}
//		map.put(indexStr + "_" + index, false);
//		return ret;
//	}
//	
//	private boolean compareTwoStrings(int id1, String str1, int id2, String str2) {
//		if (id1 >= str1.length() && id2 >= str2.length()) {
//			return true;
//		} else if (id1 >= str1.length() || id2 >= str2.length()) {
//			return differentLength(id1, str1, id2, str2);
//		}
//		
//		while (id1 < str1.length() && id2 < str2.length()) {
//			// *, ?, common, three options for each string, nine possibilities in total
//			// * + ? or * + common
//			if (str1.charAt(id1) == '*' && str2.charAt(id2) != '*') {
//				boolean cur = backtracking(id2, str2, id1, str1);
//				map.put(id1 + "_" + id2, cur);
//				return cur;
//			}
//			// ? + * or common + *
//			if (str1.charAt(id1) != '*' && str2.charAt(id2) == '*') {
//				boolean cur = backtracking(id1, str1, id2, str2);
//				map.put(id1 + "_" + id2, cur);
//				return cur;
//			}
//			// * + *
//			if (str1.charAt(id1) == '*' && str2.charAt(id2) == '*') {
//				boolean cur = backtracking(id2, str2, id1, str1);
//				map.put(id1 + "_" + id2, cur);
//				return cur;
//			}
//			// common + common
//			if (str1.charAt(id1) != '?' && str2.charAt(id2) != '?' && str1.charAt(id1) != str2.charAt(id2)) {
//				map.put(id1 + "_" + id2, false);
//				return false;
//			}
//			// ? + common ; common + ? ; ? + ? 
//			id1 ++;
//			id2 ++;
//		}
//		boolean cur = differentLength(id1, str1, id2, str2);
//		map.put(id1 + "_" + id2, cur);
//		return cur;
//	}
//	
//	private boolean differentLength(int sID, String s, int pID, String p) {
//		if (sID == s.length() && pID != p.length()) {
//			return checkAsterisk(p, pID);
//		} else if (sID != s.length() && pID == p.length()) {
//			return checkAsterisk(s, sID);
//		} else if (sID == s.length() && pID == p.length()){
//			return true;
//		}
//		return false;
//	}
//	
//	private boolean checkAsterisk(String longer, int index) {
//		while (index < longer.length()) {
//			if (longer.charAt(index) != '*') {
//				return false;
//			}
//			index ++;
//		}
//		return true;
//	}
//}

//	public boolean isMatch(String s, String p) {
//		return compareTwoStrings(0, s, 0, p);
//	}
//	
//	private boolean backtracking(int index, String asteriskStr, int indexStr, String str) {
//		// base case
//		if (index == asteriskStr.length() - 1) {
//			return true;
//		}
//		
//		boolean ret = false;
//		// asteriskStr : index + 1; str : index ->
//		int strID = indexStr;
//		int asteriskStrID = index + 1;
//		while (strID < str.length()) {
//			if (str.charAt(strID) == '?' || asteriskStr.charAt(asteriskStrID) == '?' || str.charAt(strID) == asteriskStr.charAt(asteriskStrID)) {
//				if (compareTwoStrings(asteriskStrID + 1, asteriskStr, strID + 1, str)) {
//					return true;
//				}
//			}
////			if (compareTwoStrings(asteriskStrID, asteriskStr, strID, str)) {
////				return true;
////			}
////			 else {
////					for (int i = asteriskStrID ; i < asteriskStr.length() ; i ++) {
////						if (asteriskStr.charAt(i) == '*') {
////							return false;
////						}
////					}
////				}
//			strID ++;
//		}
//		return ret;
//	}
//	
//	private boolean compareTwoStrings(int id1, String str1, int id2, String str2) {
//		if (id1 >= str1.length() && id2 >= str2.length()) {
//			return true;
//		} else if (id1 >= str1.length() || id2 >= str2.length()) {
//			return differentLength(id1, str1, id2, str2);
//		}
//		
//		while (id1 < str1.length() && id2 < str2.length()) {
//			// *, ?, common, three options for each string, nine possibilities in total
//			// * + ? or * + common
//			if (str1.charAt(id1) == '*' && str2.charAt(id2) != '*') {
//				return backtracking(id1, str1, id2, str2);
//			}
//			// ? + * or common + *
//			if (str1.charAt(id1) != '*' && str2.charAt(id2) == '*') {
//				return backtracking(id2, str2, id2, str1);
//			}
//			// * + *
//			if (str1.charAt(id1) == '*' && str2.charAt(id2) == '*') {
//				return backtracking(id1, str1, id2, str2);
//			}
//			// common + common
//			if (str1.charAt(id1) != '?' && str2.charAt(id2) != '?' && str1.charAt(id1) != str2.charAt(id2)) {
//				return false;
//			}
//			// ?+common ; common + ? ; ? + ? 
//			id1 ++;
//			id2 ++;
//		}
//		return differentLength(id1, str1, id2, str2);
//	}
//	
//	private boolean differentLength(int sID, String s, int pID, String p) {
//		if (sID == s.length() && pID != p.length()) {
//			return checkAsterisk(p, pID);
//		} else if (sID != s.length() && pID == p.length()) {
//			return checkAsterisk(s, sID);
//		} else if (sID == s.length() && pID == p.length()){
//			return true;
//		}
//		return false;
//	}
//	
//	private boolean checkAsterisk(String longer, int index) {
//		while (index < longer.length()) {
//			if (longer.charAt(index) != '*') {
//				return false;
//			}
//			index ++;
//		}
//		return true;
//	}
//}

//	public boolean isMatch(String s, String p) {
//		// corner cases
//		
//		// iterate two strings
//		return compareTwoStrings(0, s, 0, p);
//	}
//	
//	private boolean backtracking(int index, String asteriskStr, int indexStr, String str) {
//		// base case
//		if (index == asteriskStr.length() - 1) {
//			return true;
//		}
//		
//		boolean ret = false;
//		// asteriskStr : index + 1; str : index ->
//		int strID = indexStr;
//		int asteriskStrID = index + 1;
//		while (strID < str.length()) {
//			if (compareTwoStrings(asteriskStrID, asteriskStr, strID, str)) {
//				return true;
//			}
//			strID ++;
//		}
//		return ret;
//	}
//	
//	private boolean compareTwoStrings(int id1, String str1, int id2, String str2) {
//		if (id1 >= str1.length() || id2 >= str2.length()) {
//			
//		}
//		
//		// same parts of s and p
//		while (id1 < str1.length() && id2 < str2.length()) {
//			// *, ?, common, three options for each string, nine possibilities in total
//			
//			// * + ? or * + common
//			if (str1.charAt(id1) == '*' && str2.charAt(id2) != '*') {
//				return backtracking(id1, str1, id2, str2);
//			}
//			
//			// ? + * or common + *
//			if (str1.charAt(id1) != '*' && str2.charAt(id2) == '*') {
//				return backtracking(id2, str2, id2, str1);
//			}
//			
//			// * + *
//			if (str1.charAt(id1) == '*' && str2.charAt(id2) == '*') {
//				return backtracking(id1, str1, id2, str2);
//			}
//			
//			// common + common
//			if (str1.charAt(id1) != '?' && str2.charAt(id2) != '?' && str1.charAt(id1) != str2.charAt(id2)) {
//				return false;
//			}
//			// ?+common ; common + ? ; ? + ? 
//			id1 ++;
//			id2 ++;
//		}
//		return differentLength(id1, str1, id2, str2);
//	}
//	
//	private boolean differentLength(int sID, String s, int pID, String p) {
//		if (sID == s.length() && pID != p.length()) {
//			return checkAsterisk(p, pID);
//		} else if (sID != s.length() && pID == p.length()) {
//			return checkAsterisk(s, sID);
//		} else if (sID == s.length() && pID == p.length()){
//			return true;
//		} else {
//			throw new IllegalArgumentException("Same length.");
//		}
//	}
//	
//	private boolean checkAsterisk(String longer, int index) {
//		while (index < longer.length()) {
//			if (longer.charAt(index) != '*') {
//				return false;
//			}
//			index ++;
//		}
//		return true;
//	}
//}

//int index = 0;
//// same parts of s and p
//while (index < s.length() && index < p.length()) {
//	// *, ?, common, three options for each string, nine possibilities in total
//	
//	// * + ? or * + common
//	if (s.charAt(index) == '*' && p.charAt(index) != '*') {
//		return backtracking(index, s, p);
//	}
//	
//	// ? + * or common + *
//	if (s.charAt(index) != '*' && p.charAt(index) == '*') {
//		return backtracking(index, p, s);
//	}
//	
//	// * + *
//	if (s.charAt(index) == '*' && p.charAt(index) == '*') {
//		return backtracking(index, p, s);
//	}
//	
//	// common + common
//	if (s.charAt(index) != '?' && p.charAt(index) != '?' && s.charAt(index) != p.charAt(index)) {
//		return false;
//	}
//	// ?+common ; common + ? ; ? + ? 
//	
//	index ++;
//}
//// handle the length() : same length -> true or different length : only "abc***" and "abc" work b/c * can be empty
//return differentLength(index, s, index, p);
//same length
//		if (s.length() == p.length()) {
//			return true;
//		}