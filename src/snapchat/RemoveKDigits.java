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
	
	// ��һ�δ�����΢��ª������ĳ�int����int[]������Ҳ���øĹ�ȥ
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
	
// �һ��Ǿ��������⣬��Ϊ��û��֤��ÿһ��removal����greedy�Ļ����Ƿ�һ�����õ�min һ����Cn_k��ѡ��ʽ������greedyֱ�ӱ���˴�Լk*n
	
	// �˷���������ʱ�ˣ��������ҵ�ȷ������
	// ��һ������greedy�ķ������������һ��digit�����ڵ�С��ֱ��ɾ���ڵģ��������� ��Ҳ����greedy����Ϊ����Ա�֤����������Դ��һ�������õĹ۲죬�Ǿ��ǣ�digitֻ����0��9
	// ���˵ķ������ܺõĹ۲�����observation���������understanding��insight����Ϊ�ܶ�general�ķ���������Ч��������û�����õ�ǰ��problem dependent������������
	// ������cost efficiency�Ĳ��� -----> �Ǹ�DP�ķ�����pdf
	
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
