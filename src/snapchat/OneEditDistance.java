package snapchat;

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		// 演绎推导 done
		if (s.length() - t.length() > 1 || t.length() - s.length() > 1 ) {
			return false;
		}
		
		if (s.length() == 0 && t.length() == 0) {
		    return false;
		} else if (s.length() == 0 || t.length() == 0) {
		    return true;
		}
		
		int count = 0;
		for (int index = 0 ; index < s.length() ; index ++) {
			if (index == t.length()) {
				return true;
			}
			
			if (s.charAt(index) != t.charAt(index)) {
				if (s.length() == t.length()) {
					count ++;
				} else if (s.length() > t.length()){
					if (s.substring(index + 1, s.length()).equals(t.substring(index, t.length()))) {
						return true;
					} else {
						return false;
					}
				} else {
					if (s.substring(index, s.length()).equals(t.substring(index + 1, t.length()))) {
						return true;
					} else {
						return false;
					}
				}
				if (count > 1) {
					return false;
				}
			}
		}
		
	    if (count != 1 && s.length() == t.length()) {
	        return false;
	    }
		return true;
    }
}

//		// 演绎推导 done
//		if (s.length() - t.length() > 1 || t.length() - s.length() > 1 ) {
//			return false;
//		}
//		
//		if (s.length() == 0 && t.length() == 0) {
//		    return false;
//		} else if (s.length() == 0 || t.length() == 0) {
//		    return true;
//		}
//		
//		int count = 0;
//		for (int index = 0 ; index < s.length() ; index ++) {
//			if (index == t.length()) {
//				return true;
//			}
//			
//			if (s.charAt(index) != t.charAt(index)) {
//				if (s.length() == t.length()) {
//					count ++;
//				} else if (s.length() > t.length()){
//					if (s.substring(index + 1, s.length()).equals(t.substring(index, t.length()))) {
//						return true;
//					} else {
//						return false;
//					}
//				} else {
//					if (s.substring(index, s.length()).equals(t.substring(index + 1, t.length()))) {
//						return true;
//					} else {
//						return false;
//					}
//				}
//				if (count > 1) {
//					return false;
//				}
//			}
//		}
//		
// 		if (count == 1) {
// 		    return true;
// 		} else {
// 		    if (s.length() == t.length()) {
// 		        return false;
// 		    } else {
// 		        return true;
// 		    }
// 		}
//		
//      //
//	    //if (count != 1 && s.length() == t.length()) {
//	    //    return false;
//	    //}
//		//return true;
//    }
//}


//        // 演绎推导 done
//		
//		if (s.length() - t.length() > 1 || t.length() - s.length() > 1 ) {
//			return false;
//		}
//		int count = 0;
//		for (int index = 0 ; index < s.length() ; index ++) {
//			if (index == t.length()) {
//				return true;
//			}
//			
//			if (s.charAt(index) != t.charAt(index)) {
//				if (s.length() == t.length()) {
//					count ++;
//				} else if (s.length() > t.length()){
//					if (s.substring(index + 1, s.length()).equals(t.substring(index, t.length()))) {
//						return true;
//					} else {
//						return false;
//					}
//				} else {
//					if (s.substring(index, s.length()).equals(t.substring(index + 1, t.length()))) {
//						return true;
//					} else {
//						return false;
//					}
//				}
//				if (count > 1) {
//					return false;
//				}
//			}
//		}
//		return true;
//    }
//}
