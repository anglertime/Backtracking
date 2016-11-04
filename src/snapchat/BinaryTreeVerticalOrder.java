package snapchat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTreeVerticalOrder {
	int maxRow;
    public List<List<Integer>> verticalOrder(TreeNode root) {
    	// build tree
        Map<String, List<Integer>> map = new HashMap<>();
        dfs(0, 0, root, 0, map);
        
        // walk tree diagonally
        List<List<Integer>> res = new ArrayList<>();
        // lower triangular
        for (int count = 1 ; count <= maxRow + 1 ; count ++) {
            List<Integer> list = new ArrayList<>();
            for (int startRow = maxRow - (count - 1) , startCol = 0 ; startRow <= maxRow && startCol <= maxRow ; startRow ++ , startCol ++) {
            	StringBuilder sb = new StringBuilder();
                sb.append(startRow);
                sb.append("_");
                sb.append(startCol);
                String key = sb.toString();
                if (map.containsKey(key)) {
                    list.addAll(map.get(key));
                }
            }
            if (list.size() > 0) {
            	res.add(list);
            }
        }
        // upper triangular
        for (int count = maxRow ; count >= 1 ; count --) {
            List<Integer> list = new ArrayList<>();
            for (int startRow = 0 , startCol = (maxRow + 1) - count ; startRow < maxRow && startCol <= maxRow ; startRow ++ , startCol ++) {
            	StringBuilder sb = new StringBuilder();
                sb.append(startRow);
                sb.append("_");
                sb.append(startCol);
                String key = sb.toString();
                
                if (map.containsKey(key)) {
                	list.addAll(map.get(key));
                }
            }
            if (list.size() > 0) {
            	res.add(list);
            }
        }
        return res;
    }
    
    private void dfs(int row, int col, TreeNode cur, int direction, Map<String, List<Integer>> map) {
        // direction: 0 -> root, -1 -> left, 1 -> right
        if (cur == null) {
            return;
        }
        dfs(row + 1, col, cur.left, -1, map);
        
        maxRow = Math.max(maxRow, Math.max(row, col));
        StringBuilder sb = new StringBuilder();
        sb.append(row);
        sb.append("_");
        sb.append(col);
        String key = sb.toString();
        
        List<Integer> newList = new ArrayList<>();
        if (map.containsKey(key)) {
            newList = map.get(key);
        }
        newList.add(cur.val);
        map.put(key, newList);
        
        dfs(row, col + 1, cur.right, 1, map);
    }

	public static class TreeNode {
	    public int val;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int x) { val = x; }
	}
}

////build tree
//Map<String, List<Integer>> map = new HashMap<>();
//dfs(0, 0, root, 0, map);
//
//// walk tree diagonally
//List<List<Integer>> res = new ArrayList<>();
//// lower triangular
//for (int count = 1 ; count <= maxRow + 1 ; count ++) {
//    List<Integer> list = new ArrayList<>();
//    for (int startRow = maxRow - (count - 1) , startCol = 0 ; startRow <= maxRow && startCol <= maxRow ; startRow ++ , startCol ++) {
//    	StringBuilder sb = new StringBuilder();
//        sb.append(startRow);
//        sb.append("_");
//        sb.append(startCol);
//        String key = sb.toString();
//        if (map.containsKey(key)) {
//            list.addAll(map.get(key));
//        }
//    }
//    if (list.size() > 0) {
//    	res.add(list);
//    }
//}
//// upper triangular
//for (int count = maxRow ; count >= 1 ; count --) {
//    List<Integer> list = new ArrayList<>();
//    for (int startCol = maxRow - (count - 1) , startRow = 0 ; startRow <= maxRow && startCol <= maxRow ; startRow ++ , startCol ++) {
//    	StringBuilder sb = new StringBuilder();
//        sb.append(startRow);
//        sb.append("_");
//        sb.append(startCol);
//        String key = sb.toString();
//        
//        if (map.containsKey(key)) {
//        	list.addAll(map.get(key));
//        }
//    }
//    if (list.size() > 0) {
//    	res.add(list);
//    }
//}
//return res;
//}
//
//private void dfs(int row, int col, TreeNode cur, int direction, Map<String, List<Integer>> map) {
//// direction: 0 -> root, -1 -> left, 1 -> right
//if (cur == null) {
//    return;
//}
//
//maxRow = Math.max(maxRow, Math.max(row, col));
//StringBuilder sb = new StringBuilder();
//sb.append(row);
//sb.append("_");
//sb.append(col);
//String key = sb.toString();
//
//List<Integer> newList = new LinkedList<>();
//// operation on cur
//if (direction == 0) {
//    newList.add(0, cur.val);
//} else {
//    if (map.containsKey(key)) {
//        newList = map.get(key);
//    }
//    if (direction == 1) {
//        newList.add(0, cur.val);
//    } else {
//        newList.add(cur.val);
//    }
//}
//map.put(key, newList);
//dfs(row, col + 1, cur.right, 1, map);
//dfs(row + 1, col, cur.left, -1, map);
//}

	//    int maxRow;
//    public List<List<Integer>> verticalOrder(TreeNode root) {
//        // build tree
//        Map<String, List<Integer>> map = new HashMap<>();
//        dfs(0, 0, root, 0, map);
//        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
//        	String key = entry.getKey();
//        	List<Integer> list = new ArrayList<>(entry.getValue());
////        	System.out.println("key is " + key);
//        	for (int i = 0 ; i < list.size() ; i ++) {
////        		System.out.print(" " + list.get(i));
//        	}
////        	System.out.println();
//        }
////        System.out.println("maxRow" + " " + maxRow);
////        System.out.println("maxCol" + " " + maxRow);
//        
//        // walk tree diagonally
//        List<List<Integer>> res = new ArrayList<>();
//        // lower triangular
//        for (int count = 1 ; count <= maxRow + 1 ; count ++) {
//            List<Integer> list = new ArrayList<>();
//            for (int startRow = maxRow - (count - 1) , startCol = 0 ; startRow <= maxRow && startCol <= maxRow ; startRow ++ , startCol ++) {
////                System.out.println("row and col are " + startRow + " " + startCol);
//            	StringBuilder sb = new StringBuilder();
//                sb.append(startRow);
//                sb.append("_");
//                sb.append(startCol);
//                String key = sb.toString();
//                if (map.containsKey(key)) {
////                	System.out.print("    " + "Value Found at count " + count);
////                	System.out.println();
//                    list.addAll(map.get(key));
//                }
//            }
//            if (list.size() > 0) {
//            	res.add(list);
//            }
//        }
//        System.out.println("---------------------");
//        // upper triangular
//        for (int count = maxRow ; count >= 1 ; count --) {
//            List<Integer> list = new ArrayList<>();
//            for (int startCol = maxRow - (count - 1) , startRow = 0 ; startRow <= maxRow && startCol <= maxRow ; startRow ++ , startCol ++) {
//            	System.out.println("row and col are " + startRow + " " + startCol);
//            	StringBuilder sb = new StringBuilder();
//                sb.append(startRow);
//                sb.append("_");
//                sb.append(startCol);
//                String key = sb.toString();
//                
//                if (map.containsKey(key)) {
//                	System.out.print("    " + "Value Found at count " + count);
//                	System.out.println();
//                	list.addAll(map.get(key));
//                }
//            }
//            if (list.size() > 0) {
//            	res.add(list);
//            }
//        }
//        
//        return res;
//        
//    }
//    
//    private void dfs(int row, int col, TreeNode cur, int direction, Map<String, List<Integer>> map) {
//        // direction: 0 -> root, -1 -> left, 1 -> right
//        if (cur == null) {
//            return;
//        }
//        
//        // update maxRow and maxCol
//        maxRow = Math.max(maxRow, Math.max(row, col));
//        
//        StringBuilder sb = new StringBuilder();
//        sb.append(row);
//        sb.append("_");
//        sb.append(col);
//        String key = sb.toString();
//        
//        List<Integer> newList = new LinkedList<>();
//        // operation on cur
//        if (direction == 0) {
//            newList.add(0, cur.val);
//        } else {
//            if (map.containsKey(key)) {
//                newList = map.get(key);
//            }
//            if (direction == 1) {
//                newList.add(0, cur.val);
//            } else {
//                newList.add(cur.val);
//            }
//        }
//        map.put(key, newList);
//        // this order matters? I think so : No if we handle it well.
//        dfs(row, col + 1, cur.right, 1, map);
//        dfs(row + 1, col, cur.left, -1, map);
////        dfs(row, col + 1, cur.right, 1, map);
//    }
//
//	public static class TreeNode {
//	    public int val;
//	    public TreeNode left;
//	    public TreeNode right;
//	    public TreeNode(int x) { val = x; }
//	}
//}
