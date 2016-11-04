package snapchat2;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int front = 0;
        int back = s.length() - 1;
        while (front <= back) {
            while (front < s.length() && !Character.isLetterOrDigit(s.charAt(front))) {
                front ++;
            }
            while (back >= 0 && !Character.isLetterOrDigit(s.charAt(back))) {
                back --;
            }
            if (front > back) {
                return true;
            }
            if (s.charAt(front) != s.charAt(back)) {
                return false;
            }
            front ++;
            back --;
        }
        return true;
    }
}
