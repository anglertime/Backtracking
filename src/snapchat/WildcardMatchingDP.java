package snapchat;

import java.util.Arrays;

/* int m=s.length(), n=p.length();
boolean[][] dp = new boolean[m+1][n+1];
dp[0][0] = true;
for (int i=1; i<=m; i++) {
	dp[i][0] = false;
}

for(int j=1; j<=n; j++) {
	if(p.charAt(j-1)=='*'){
		dp[0][j] = true;
	} else {
		break;
	}
}

for(int i=1; i<=m; i++) {
	for(int j=1; j<=n; j++) {
		if (p.charAt(j-1)!='*') {
			dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?');
		} else {
			dp[i][j] = dp[i-1][j] || dp[i][j-1];
		}
	}
}
return dp[m][n];


final int lenP = p.length();
        final int lenS = s.length();
        int cntS, cntP;
        int preFirstMatchIndex, curFirstMatchIndex;
        boolean[][] dp = new boolean[ lenP+1 ][ lenS+1 ];
        
        dp[ 0 ][ 0 ] = true;
        for(cntP = 1; cntP < lenP+1; cntP++){
            if(dp[ cntP-1 ][ 0 ]==true && p.charAt(cntP-1)=='*'){
                dp[ cntP ][ 0 ] = true;
            }
        }
        
        preFirstMatchIndex = 0;
        for(cntP = 1; cntP < lenP+1; cntP++){
            curFirstMatchIndex = dp[ cntP ][ 0 ]?0:lenS;
            for(cntS = 1; cntS < lenS+1; cntS++){
                if(((p.charAt(cntP-1)=='?' || p.charAt(cntP-1)==s.charAt(cntS-1)) && dp[ cntP-1 ][ cntS-1 ]) || 
                (p.charAt(cntP-1)=='*' && cntS-1>=preFirstMatchIndex)){
                    dp[ cntP ][ cntS ] = true;
                    curFirstMatchIndex = Math.min(curFirstMatchIndex, cntS-1);
                } 
            }
            preFirstMatchIndex = curFirstMatchIndex;
        }
        
        return dp[ lenP ][ lenS ];
 */

public class WildcardMatchingDP {
	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[] prevCol = new boolean[m];
		boolean[] firstRow = new boolean[n];
		// (0, 0)
		if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*') {
			firstRow[0] = true;
		}
		// (0, 1 -> n-1)
		for (int j = 1 ; j < n ; j ++) {
			if (firstRow[j - 1] && p.charAt(j) == '*') {
				firstRow[j] = true;
			} else if (firstRow[j - 1] && p.charAt(j) == '?' || p.charAt(j) == s.charAt(0)) {
				boolean valid = true;
				for (int prev = 0 ; prev < j ; prev ++) {
					if (p.charAt(prev) != '*') {
						valid = false;
					}
				}
				firstRow[j] = valid;
			}
		}
		
		// (0, 0) and (1 -> m-1, 0) 
		prevCol[0] = firstRow[0];
		if (prevCol[0]) {
			if (p.charAt(0) == '*') {
				Arrays.fill(prevCol, true);
			}
		}
		
		// (row, col) and column by column
		for (int col = 1 ; col < n ; col ++) {
			boolean[] curCol = new boolean[m];
			for (int row = 1 ; row < m ; row ++) {
				if ((p.charAt(col) == '?' || s.charAt(row) == p.charAt(col)) && prevCol[row - 1]) {
						curCol[row] = true;
				} else if (p.charAt(col) == '*') {
					for (int i = 0 ; i <= row ; i ++) {
						if (prevCol[i]) {
							curCol[row] = true;
							break;
						}
					}
				}
			}
			prevCol = curCol;
			prevCol[0] = firstRow[col];
		}
		return prevCol[m - 1];
	}
}

//		int m = s.length();
//		int n = p.length();
//		boolean[] prevCol = new boolean[m];
//		boolean[] firstRow = new boolean[n];
//		// (0, 0)
//		if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*') {
//			firstRow[0] = true;
//		}
//		// (0, 1 -> n-1)
//		for (int j = 1 ; j < n ; j ++) {
//			if (firstRow[j - 1]) {
//				if (p.charAt(j) == '*') {
//					firstRow[j] = true;
//				} else if (p.charAt(j) == '?') {
//					boolean valid = true;
//					for (int prev = 0 ; prev < j ; prev ++) {
//						if (p.charAt(prev) != '*') {
//							valid = false;
//						}
//					}
//					firstRow[j] = valid;
//				} else if (p.charAt(j) == s.charAt(0)) {
//					boolean valid = true;
//					for (int prev = 0 ; prev < j ; prev ++) {
//						if (p.charAt(prev) != '*') {
//							valid = false;
//						}
//					}
//					firstRow[j] = valid;
//				}
//			}
//		}
//		
//		// (0, 0) and (1 -> m-1, 0) 
//		prevCol[0] = firstRow[0];
//		if (prevCol[0]) {
//			if (p.charAt(0) == '*') {
//				Arrays.fill(prevCol, true);
//			}
//		}
//		
//		// (row, col) and column by column
//		for (int col = 1 ; col < n ; col ++) {
//			boolean[] curCol = new boolean[m];
//			for (int row = 1 ; row < m ; row ++) {
//				if (p.charAt(col) == '?') {
//					if (prevCol[row - 1]) {
//						curCol[row] = true;
//					}
//				} else if (p.charAt(col) == '*') {
//					for (int i = 0 ; i <= row ; i ++) {
//						if (prevCol[i]) {
//							curCol[row] = true;
//							break;
//						}
//					}
//				} else {
//					if (s.charAt(row) == p.charAt(col) && prevCol[row - 1]) {
//						curCol[row] = true;
//					}
//				}
//			}
//			prevCol = curCol;
//			prevCol[0] = firstRow[col];
//		}
//		return prevCol[m - 1];
//	}
//}
