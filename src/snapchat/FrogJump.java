package snapchat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrogJump {
	public boolean canCross(int[] stones) {
        List<Set<Integer>> list = new ArrayList<>();
        // stones first element is zero
        Set<Integer> first = new HashSet<>();
        first.add(-1);
        list.add(first);
        
        for (int i = 1 ; i < stones.length ; i ++) {
            Set<Integer> curSet = new HashSet<>();
            for (int j = 0 ; j < i ; j ++) {
                if (!list.get(j).isEmpty()) {
                    int dist = stones[i] - stones[j];
                    if (list.get(j).contains(dist)) {
                        curSet.add(dist - 1);
                        curSet.add(dist);
                        curSet.add(dist + 1);
                    }
                }
            }
            list.add(curSet);
        }
        
        if (list.get(list.size() - 1).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}


//Scanner sc = new Scanner(System.in);
//int n = Integer.parseInt(sc.nextLine());
//int[][] X = new int[n][3];
//int[] Y = new int[n];
//for (int i = 0 ; i < n ; i ++) {
//    String[] curArr = sc.nextLine().split(" ");
//    X[i][0] = Integer.parseInt(curArr[0]);
//    X[i][1] = Integer.parseInt(curArr[1]);
//    X[i][2] = Integer.parseInt(curArr[2]);
//    Y[i] = Integer.parseInt(curArr[3]);
//}
//int q = Integer.parseInt(sc.nextLine());
//int[][] newX = new int[q][3];
//for (int i = 0 ; i < q ; i ++) {
//    String[] curArr = sc.nextLine().split(" ");
//    newX[i][0] = Integer.parseInt(curArr[0]);
//    newX[i][1] = Integer.parseInt(curArr[1]);
//    newX[i][2] = Integer.parseInt(curArr[2]);
//}
//
//int[] para = new int[3];
//// XT*X
//int[][] product = multiplyXTX(n, X);
//System.out.println(product[0][0]);
//}
//
//private static int[][] multiplyXTX(int n, int[][] X) {
//int[][] transpose = new int[3][n];
//for (int row = 0 ; row < n ; row ++) {
//    for (int col = 0 ; col < 3 ; col ++) {
//        transpose[col][row] = X[row][col];
//    }
//}
//int[][] ret = new int[3][3];
//for (int i = 0 ; i < 3 ; i ++) {
//    for (int j = 0 ; j < 3 ; j ++) {
//        int cur = 0;
//        // i row in transpose and j col in X
//        for (int trans = 0 , xRow = 0 ; trans < n && xRow < n ; trans ++, xRow ++) {
//            cur += transpose[i][trans] * X[xRow][j];
//        }
//        System.out.println(cur);
//        ret[i][j] = cur;
//    }
//}
//return ret;
//}