package snapchat2;

public class AddOperations {
	public int addOperations(int[] x) {
		int n = x.length;
		int[][] dp = new int[n][n];
		for (int j = 0 ; j < n ; j ++) {
			for (int i = j ; i >= 0 ; i --) {
				if (i == j) {
					dp[i][j] = x[i];
				} else {
					for (int k = 1 ; k <= j - i ; k ++) {
						dp[i][j] = Math.max(dp[i][i + k - 1] + dp[i + k][j], dp[i][i + k - 1] * dp[i + k][j]);
					}
				}
			}
		}
		return dp[0][n - 1];
	}
}
