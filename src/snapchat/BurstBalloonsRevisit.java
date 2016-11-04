package snapchat;

public class BurstBalloonsRevisit {
	public int burstBalloonsRevisit(int[] x) {
		int n = x.length;
		int[][] dp = new int[n][n];
		
		for (int j = 0 ; j < n ; j ++) {
			for (int i = j ; i >= 0 ; i --) {
				// compute dp[i][j]
				dp[i][j] = solveSubproblem(i, j, x, dp);
			}
		}
		return dp[0][n - 1];
	}
	
	private int solveSubproblem(int row, int col, int[] x, int[][] dp) {
		if (row > col) {
			throw new IllegalArgumentException();
		}
		int ret = Integer.MIN_VALUE;
		for (int k = row ; k <= col ; k ++) {
			int burstKCoin = getValue(row - 1, x) * x[k] * getValue(col + 1, x);
			int left = k - 1 >= row ? dp[row][k - 1] : 0;
			int right = k + 1 <= col ? dp[k + 1][col] : 0;
			ret = Math.max(ret, burstKCoin + left + right);
		}
		return ret;
	}
	
	private int getValue(int index, int[] x) {
		if (index < 0 || index >= x.length) {
			return 1;
		}
		return x[index];
	}
}
