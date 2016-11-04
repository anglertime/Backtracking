package snapchat2;

public class LongestIncreasingPath {
	int maxLen;
	int m;
	int n;
	int[][] lens;
	public int longestIncreasingPa(int[][] input) {
		m = input.length;
		n = input[0].length;
		lens = new int[m][n];
		for (int row = 0 ; row < m ; row ++) {
			for (int col = 0 ; col < n ; col ++) {
				maxLen = Math.max(maxLen, backtracking(0, row, col, Integer.MIN_VALUE, input));
			}
		}
		return maxLen;
	}
	
	private int backtracking(int depthSoFar, int row, int col, int prev, int[][] input) {
		if (row < 0 || col < 0 || row >= m || col >= n || input[row][col] <= prev) {
			return depthSoFar;
		}
		if (lens[row][col] != 0) {
			return depthSoFar + lens[row][col];
		}
		int ret = -1;
		ret = Math.max(ret, backtracking(depthSoFar + 1, row - 1, col, input[row][col], input));
		ret = Math.max(ret, backtracking(depthSoFar + 1, row + 1, col, input[row][col], input));
		ret = Math.max(ret, backtracking(depthSoFar + 1, row, col - 1, input[row][col], input));
		ret = Math.max(ret, backtracking(depthSoFar + 1, row, col + 1, input[row][col], input));
		lens[row][col] = ret - depthSoFar;
		return ret;
	}
}

	//	int maxLen;
//	int m;
//	int n;
//	int[][] lens;
//	public int longestIncreasingPa(int[][] input) {
//		m = input.length;
//		n = input[0].length;
//		lens = new int[m][n];
//		for (int row = 0 ; row < m ; row ++) {
//			for (int col = 0 ; col < n ; col ++) {
//				boolean[][] visiting = new boolean[m][n];
//				maxLen = Math.max(maxLen, backtracking(0, row, col, Integer.MIN_VALUE, input, visiting));
//			}
//		}
//		return maxLen;
//	}
//	
//	private int backtracking(int depthSoFar, int row, int col, int prev, int[][] input, boolean[][] visiting) {
//		if (row < 0 || col < 0 || row >= m || col >= n || visiting[row][col] || input[row][col] <= prev) {
//			return depthSoFar;
//		}
//		if (lens[row][col] != 0) {
//			return depthSoFar + lens[row][col];
//		}
//		visiting[row][col] = true;
//		int ret = -1;
//		ret = Math.max(ret, backtracking(depthSoFar + 1, row - 1, col, input[row][col], input, visiting));
//		ret = Math.max(ret, backtracking(depthSoFar + 1, row + 1, col, input[row][col], input, visiting));
//		ret = Math.max(ret, backtracking(depthSoFar + 1, row, col - 1, input[row][col], input, visiting));
//		ret = Math.max(ret, backtracking(depthSoFar + 1, row, col + 1, input[row][col], input, visiting));
//		visiting[row][col] = false;
//		lens[row][col] = ret - depthSoFar;
//		return ret;
//	}
//}

	//	int maxLen;
//	int m;
//	int n;
//	int[][] lens;
//	public int longestIncreasingPa(int[][] input) {
//		m = input.length;
//		n = input[0].length;
//		lens = new int[m][n];
//		for (int row = 0 ; row < m ; row ++) {
//			for (int col = 0 ; col < n ; col ++) {
//				boolean[][] visiting = new boolean[m][n];
//				backtracking(0, row, col, Integer.MIN_VALUE, input, visiting);
//			}
//		}
//		return maxLen;
//	}
//	
//	private void backtracking(int depthSoFar, int row, int col, int prev, int[][] input, boolean[][] visiting) {
//		if (row < 0 || col < 0 || row >= m || col >= n) {
//			maxLen = Math.max(maxLen, depthSoFar);
//			return;
//		}
//		if (visiting[row][col] || input[row][col] <= prev) {
//			maxLen = Math.max(maxLen, depthSoFar);
//			return;
//		}
//		if (depthSoFar != 0 && lens[row][col] >= depthSoFar) {
//			return;
//		}
//		lens[row][col] = depthSoFar;
//		visiting[row][col] = true;
//		backtracking(depthSoFar + 1, row - 1, col, input[row][col], input, visiting);
//		backtracking(depthSoFar + 1, row + 1, col, input[row][col], input, visiting);
//		backtracking(depthSoFar + 1, row, col - 1, input[row][col], input, visiting);
//		backtracking(depthSoFar + 1, row, col + 1, input[row][col], input, visiting);
//		visiting[row][col] = false;
//	}
//}

//	int maxLen;
//	int m;
//	int n;
//	int[][] lens;
//	public int longestIncreasingPa(int[][] input) {
//		m = input.length;
//		n = input[0].length;
//		lens = new int[m][n];
//		for (int row = 0 ; row < m ; row ++) {
//			for (int col = 0 ; col < n ; col ++) {
//				boolean[][] visiting = new boolean[m][n];
//				backtracking(0, row, col, Integer.MIN_VALUE, input, visiting);
//			}
//		}
//		return maxLen;
//	}
//	
//	private void backtracking(int depth, int row, int col, int prev, int[][] input, boolean[][] visiting) {
//		if (row < 0 || col < 0 || row >= m || col >= n) {
//			maxLen = Math.max(maxLen, depth);
//			return;
//		}
//		if (visiting[row][col] || input[row][col] <= prev) {
//			maxLen = Math.max(maxLen, depth);
//			return;
//		}
//		visiting[row][col] = true;
//		backtracking(depth + 1, row - 1, col, input[row][col], input, visiting);
//		backtracking(depth + 1, row + 1, col, input[row][col], input, visiting);
//		backtracking(depth + 1, row, col - 1, input[row][col], input, visiting);
//		backtracking(depth + 1, row, col + 1, input[row][col], input, visiting);
//		visiting[row][col] = false;
//	}
//}
