package snapchat;
import snapchat.BinaryTreeVerticalOrder.TreeNode;

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		// exception : root is null ; 
		Integer res = null;
		TreeNode cur = root;
		while (cur != null) {
			int val = cur.val;
			if (target == val) {
				return val;
			} else if (target < val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
			
			if (res == null || Math.abs(res - target) >= Math.abs(val - target)) {
				res = val;
			}
		}
	return res;
	}
}
//		// exception : root is null ; 
//        int res = Integer.MIN_VALUE;
//        TreeNode cur = root;
//        while (cur != null) {
//        	int val = cur.val;
//        	if (target == cur.val) {
//        		return val;
//        	} else if (target < cur.val) {
//        		cur = cur.left;
//        	} else {
//        		cur = cur.right;
//        	}
//        	
//        	if (Math.abs(res - target) >= Math.abs(val - target)) {
//        		res = val;
//        	}
//        }
//        return res;
//    }
//}
/// exception : root is null ; 
//Integer res = null;
//TreeNode cur = root;
//while (cur != null) {
//	int val = cur.val;
//	if (target == val) {
//		return val;
//	} else if (target < val) {
//		cur = cur.left;
//	} else {
//		cur = cur.right;
//	}
//	
//	if (res == null || Math.abs(res - target) >= Math.abs(val - target)) {
//		res = val;
//	}
//}
//return res;
//}
//}

/// exception : root is null ; 
//Integer res = null;
//TreeNode cur = root;
//while (cur != null) {
//	int val = cur.val;
//	if (target == val) {
//		return val;
//	} else if (target < val) {
//		cur = cur.left;
//	} else {
//		cur = cur.right;
//	}
//	
//	if (res == null || Math.abs(res - target) >= Math.abs(val - target)) {
//		res = val;
//	}
//}
//return res;
//}
//}