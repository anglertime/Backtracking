package snapchat2;

public class EditDistance {
	public int editDistance(String s, String target) {
		int m = s.length();
		int n = target.length();
		int[][] dp = new int[m + 1][n];
		// initialization
		// i = -1, 0 <= j <= n-1
		for (int j = 0 ; j < n ; j ++) {
			dp[0][j] = j + 1;
		}
		// i = 0, j = 0
		dp[1][0] = s.charAt(0) == target.charAt(0) ? 0 : 1;
		// 0 < i <= m-1, j = 0
		for (int i = 1 ; i < m ; i ++) {
		    dp[i + 1][0] = s.charAt(i) == target.charAt(0) ? i : dp[i][0] + 1;
		}
		// bottom up iteration
		for (int i = 0 ; i < m ; i ++) {
			for (int j = 1 ; j < n ; j ++) {
				if (s.charAt(i) == target.charAt(j)) {
					dp[i + 1][j] = dp[i][j - 1];
				} else {
					dp[i + 1][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[m][n - 1];
	}
}
		
		//		int m = s.length();
//		int n = target.length();
//		int[][] dp = new int[m + 1][n];
//		// i = -1, 0 <= j <= n-1
//		for (int j = 0 ; j < n ; j ++) {
//			dp[0][j] = j + 1;
//		}
//		// 0 <= i <= m-1, j = 0
//		for (int i = 0 ; i < m ; i ++) {
//			dp[i + 1][0] = s.charAt(i) == target.charAt(0) ? i : dp[i][0] + 1;
//		}
//		for (int i = 0 ; i < m ; i ++) {
//			for (int j = 1 ; j < n ; j ++) {
//				if (s.charAt(i) == target.charAt(j)) {
//					dp[i + 1][j] = dp[i][j - 1];
//				} else {
//					dp[i + 1][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i][j], dp[i][j - 1])) + 1;
//				}
//			}
//		}
//		return dp[m][n - 1];
//	}
//}

		//		int m = s.length();
//		int n = target.length();
//		int[][] dp = new int[m + 1][n];
//		// initialization
//		// i = -1, 0 <= j <= n-1
//		for (int j = 0 ; j < n ; j ++) {
//			dp[0][j] = j + 1;
//		}
//		// i = 0 , j = 0
//		dp[1][0] = s.charAt(0) == target.charAt(0) ? 0 : 1;
//		// 1 <= i <= m-1, j = 0
//		for (int i = 1 ; i < m ; i ++) {
//			dp[i + 1][0] = s.charAt(i) == target.charAt(0) ? i : i + dp[1][0];
//		}
//		// bottom up iteration
//		for (int i = 0 ; i < m ; i ++) {
//			for (int j = 1 ; j < n ; j ++) {
//				if (s.charAt(i) == target.charAt(j)) {
//					dp[i + 1][j] = dp[i][j - 1];
//				} else {
//					dp[i + 1][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i][j], dp[i][j - 1])) + 1;
//				}
//			}
//		}
//		return dp[m][n - 1];
//	}
//}
