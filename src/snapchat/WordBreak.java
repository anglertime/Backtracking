package snapchat;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		// ±ê×¼´ð°¸£¡£¡£¡£¡
		if (dict.contains(s)) {
            return true;
        }
        // memorization
        Set<Integer> visitedFalse = new HashSet<>();
        return helper(0, s, dict, visitedFalse);
    }
    
    private boolean helper(int start, String s, Set<String> dict, Set<Integer> visitedFalse) {
        if (start >= s.length()) {
			return true;
		}
        if (visitedFalse.contains(start)) {
            return false;
        }
        for (int i = start ; i < s.length() ; i ++) {
            if (dict.contains(s.substring(start, i + 1))) {
				if (helper(i + 1, s, dict, visitedFalse)) {
					return true;
				}
			}
        }
        visitedFalse.add(start);
        return false;
    }
}   
    //		if (dict.contains(s)) {
//            return true;
//        }
//        // memorization
//        Set<Integer> visitedFalse = new HashSet<>();
//        
//        for (int i = 0 ; i < s.length() ; i ++) {
//            if (dict.contains(s.substring(0, i))) {
//                if (helper(i, s, dict, visitedFalse)) {
//                    return true;
//                }
//                visitedFalse.add(i);
//            }
//        }
//        return false;
//    }
//    
//    private boolean helper(int start, String s, Set<String> dict, Set<Integer> visitedFalse) {
//        if (dict.contains(s.substring(start, s.length()))) {
//            return true;
//        }
//        if (visitedFalse.contains(start)) {
//            return false;
//        }
//        for (int i = start + 1 ; i < s.length() ; i ++) {
//            if (dict.contains(s.substring(start, i))) {
//                if (helper(i, s, dict, visitedFalse)) {
//                    return true;
//                }
//            }
//        }
//        visitedFalse.add(start);
//        return false;
//    }
//}
		//        if (dict.contains(s)) {
//            return true;
//        }
//        for (int i = 0 ; i < s.length() ; i ++) {
//            if (dict.contains(s.substring(0, i))) {
//                if (helper(i, s, dict)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    
//    private boolean helper(int start, String s, Set<String> dict) {
//        if (dict.contains(s.substring(start, s.length()))) {
//            return true;
//        }
//        for (int i = start + 1 ; i < s.length() ; i ++) {
//            if (dict.contains(s.substring(start, i))) {
//                if (helper(i, s, dict)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//}
