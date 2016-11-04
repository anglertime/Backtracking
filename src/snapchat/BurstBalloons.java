package snapchat;

public class BurstBalloons {
	public static void main(String args[]) {
		int[] input = {3, 1, 5, 8};
		int expected = 167;
		System.out.println("Expected value is " + expected);
		int actual = burstBallons(input);
		System.out.println("Actual value is " + actual);
	}
	public static int burstBallons(int[] x) {
		int n = x.length;
		int[][] dp = new int[n][n];
		int res = 0;
		
		for (int nr = 1 ; nr <= n ; nr ++) {
			// diagonal index dia; diagonal by diagonal
			for (int dia = 0 ; dia <= n - nr ; dia ++) {
				// for each (i, i + nr - 1)
				for (int k = dia ; k <= dia + nr - 1 ; k ++) {
					dp[dia][dia + nr - 1] = Math.max(dp[dia][dia + nr - 1], helper(dia, dia + nr - 1, k, dp, x));
				}
			}
		}
		return dp[0][n - 1];
	}
	
	private static int getValue(int index, int[] x) {
		if (index < 0 || index >= x.length) {
			return 1;
		}
		return x[index];
	}
	
	private static int helper(int i, int j, int k, int[][] dp, int[] x) {
		int ret = 0;
		int curCoin = getValue(i - 1, x) * x[k] * getValue(j + 1, x);
		int leftDP = k == i ? 0 : dp[i][k - 1];
		int rightDP = k == j ? 0 : dp[k + 1][j];
		ret += leftDP + rightDP + curCoin;
		return ret;
	}
}


//if (x.length == 0) {
//    return 0;
//}
//
//int n = x.length;
//int[][] dp = new int[n][n];
//int res = 0;
//
//for (int nr = 1 ; nr <= n ; nr ++) {
//	// diagonal index dia; diagonal by diagonal
//	for (int dia = 0 ; dia <= n - nr ; dia ++) {
//		// for each (i, i + nr - 1)
//		for (int k = dia ; k <= dia + nr - 1 ; k ++) {
//			int curCoin = getValue(dia - 1, x) * x[k] * getValue(dia + nr - 1 + 1, x);
//			int leftDP = k == dia ? 0 : dp[dia][k - 1];
//			int rightDP = k == dia + nr - 1 ? 0 : dp[k + 1][dia + nr - 1];
//			dp[dia][dia + nr - 1] = Math.max(dp[dia][dia + nr - 1], leftDP + rightDP + curCoin);
//		}
//	}
//}
//return dp[0][n - 1];
//}
//
//private static int getValue(int index, int[] x) {
//if (index < 0 || index >= x.length) {
//	return 1;
//}
//return x[index];
//}
//}



//public int maxCoins(int[] x) {
//    if (x.length == 0) {
//        return 0;
//    }
//    
//    int n = x.length;
//	int[][] dp = new int[n][n];
//	int res = 0;
//	
//	for (int nr = 1 ; nr <= n ; nr ++) {
//		// diagonal index dia; diagonal by diagonal
//		for (int dia = 0 ; dia <= n - nr ; dia ++) {
//			// for each (i, i + nr - 1)
//			int curMax = 0;
//			for (int k = dia ; k <= dia + nr - 1 ; k ++) {
//				// burst k
//				curMax = Math.max(curMax, helper(dia, dia + nr - 1, k, dp, x));
//			}
//			dp[dia][dia + nr - 1] = curMax;
//		}
//	}
//	return dp[0][n - 1];
//}
//
//private static int helper(int i, int j, int k, int[][] dp, int[] x) {
//	if (i > j) {
//		throw new IllegalArgumentException("Invalid input!");
//	}
//	int ret = 0;
//	int curCoin = 0;
//	
//	if (i - 1 < 0 && j + 1 >= x.length) {
//		curCoin = x[k];
//	} else if (i - 1 < 0) {
//		curCoin = x[k] * x[j + 1];
//	} else if (j + 1 >= x.length) {
//		curCoin = x[i - 1] * x[k];
//	} else {
//		curCoin = x[i - 1] * x[k] * x[j + 1];
//	}
//	
//	if (i == j) {
//		return curCoin;
//	}
//	
//	if (k == i) {
//		ret += dp[i + 1][j] + curCoin;
//	} else if (k == j) {
//		ret += dp[i][j - 1] + curCoin;
//	} else {
//		ret += dp[i][k - 1] + dp[k + 1][j] + curCoin;
//	}
//	
//	return ret;
//}
//}
