package snapchat;

public class RemoveKDigits {
	public String removeKDigits(String str, int k) {
		if (k == 0) {
            return str;
        }
		String ret = new String("");
		for (int i = 0 ; i < k ; i ++) {
			// removal
			ret = remove(str);
			if (ret.equals("0")) {
				return ret;
			}
			str = ret;
		}
		return ret;
	}
	
	// 这一段代码略微丑陋，另外改成int或者int[]的输入也不好改过去
	private String remove(String str) {
		// exception
		if (str.length() <= 1) {
			return "0";
		}
		// remove leading 0's
		while (str.charAt(0) == '0') {
			if (str.length() == 1) {
				return "0";
			}
			StringBuilder sb = new StringBuilder(str.substring(1, str.length()));
			str = sb.toString();
		}
		if (str.length() <= 1) {
			return "0";
		}
		
		for (int i = 0 ; i < str.length() ; i ++) {
			if (i == str.length() - 1 || Character.getNumericValue(str.charAt(i)) > Character.getNumericValue(str.charAt(i + 1))) {
				StringBuilder sb = new StringBuilder(str);
				sb.deleteCharAt(i);
				return sb.toString();
			}
		}
		return "D:LKFJS:LKF";
	}
	
// 我还是觉得有问题，因为我没法证明每一步removal都用greedy的话，是否一定最后得到min 一共有Cn_k的选择方式，而用greedy直接变成了大约k*n
	
	// 此方法反而超时了，汗，而且的确有问题
	// 换一个更加greedy的方法，如果后面一个digit比现在的小，直接删现在的！！！！！ 这也不算greedy，因为这可以被证明成立，这源于一个很有用的观察，那就是：digit只能是0到9
	// 夸人的方法：很好的观察力，observation，理解力，understanding和insight，因为很多general的方法可能奏效，但往往没法利用当前的problem dependent的特殊条件，
	// 所以有cost efficiency的不如 -----> 那个DP的方法的pdf
	
	public String removeKdigits(String str, int k) {
        
		String ret = new String("");
		for (int i = 0 ; i < k ; i ++) {
			// removal
			ret = removeOneDigit(str);
			if (ret.equals("0")) {
				return ret;
			}
			str = ret;
		}
		return ret;
    }
	
	private String removeOneDigit(String str) {
		// exception
		if (str.length() <= 1) {
			return "0";
		}
		// remove leading 0's
		while (str.charAt(0) == '0') {
			if (str.length() == 1) {
				return "0";
			}
			StringBuilder sb = new StringBuilder(str.substring(1, str.length()));
			str = sb.toString();
		}
		if (str.length() <= 1) {
			return "0";
		}
		
		int indexToBeRemoved = -1;
		String min = new String("");
		for (int i = 0 ; i < str.length() ; i ++) {
			StringBuilder sb = new StringBuilder(str);
			sb.deleteCharAt(i);
			if (indexToBeRemoved == -1) {
				indexToBeRemoved = i;
				min = sb.toString();
				while (min.charAt(0) == '0') {
					if (min.length() == 1) {
						break;
					}
					StringBuilder tmp = new StringBuilder(min.substring(1, min.length()));
					min = tmp.toString();
				}
			} else {
				boolean newMin = compare(min, sb.toString());
				if (newMin) {
					indexToBeRemoved = i;
					min = sb.toString();
				}
			}
		}
		return min;
	}
	
	private boolean compare(String min, String cur) {
		// remove leading 0's
		while (cur.charAt(0) == '0') {
			if (cur.length() == 1) {
				break;
			}
			StringBuilder sb = new StringBuilder(cur.substring(1, cur.length()));
			cur = sb.toString();
		}
		
		if (min.length() < cur.length()) {
			return false;
		} else if (min.length() > cur.length()) {
			return true;
		}
		
		for (int i = 0 ; i < min.length() ; i ++) {
			if (Character.getNumericValue(min.charAt(i)) < Character.getNumericValue(cur.charAt(i))) {
				return false;
			} else if (Character.getNumericValue(min.charAt(i)) > Character.getNumericValue(cur.charAt(i))) {
				return true;
			}
		}
		return true;
	}
	
}
