package snapchat2;

public class MaximumProductSubarray {
	public int maximumProductSubarray(int[] a) {
		if (a.length == 0) {
            return 0;
        }
        int maxPro = a[0];
		int submax = a[0];
		int submin = a[0];
		for (int i = 1 ; i < a.length ; i ++) {
		    int tmp = submax;
			submax = Math.max(a[i], Math.max(submax*a[i], submin*a[i]));
			submin = Math.min(a[i], Math.min(tmp*a[i], submin*a[i]));
            // System.out.println(submin);
			maxPro = Math.max(maxPro, submax);
		}
		return maxPro;
	}
}
		//		// expection x == null
//		int maxPro = a[0];
//		int submax = a[0];
//		int submin = a[0];
//		for (int i = 1 ; i < a.length ; i ++) {
//			submax = Math.max(a[i], Math.max(submax*a[i], submin*a[i]));
//			submin = Math.min(a[i], Math.min(submax*a[i], submin*a[i]));
//			maxPro = Math.max(maxPro, submax);
//		}
//		return maxPro;
//	}
//}


		//		// expection x == null
//		int maxPro = a[0];
//		int submax = a[0];
//		for (int i = 1 ; i < a.length ; i ++) {
//			submax = Math.max(a[i], submax*a[i]);
//			System.out.println(submax);
//			maxPro = Math.max(maxPro, submax);
//		}
//		return maxPro;
//	}
//}


		//		// expection x == null
//		int maxPro = a[0];
//		int submax = a[0];
//		for (int i = 1 ; i < a.length ; i ++) {
//			if (a[i] > 0) {
//				if (submax > 0) {
//					submax *= a[i];
//				} else {
//					submax = a[i];
//				}
//			} else {
//				if (submax > 0) {
//					submax = a[i];
//				} else {
//					submax *= a[i];
//				}
//			}
//			maxPro = Math.max(maxPro, submax);
//		}
//		return maxPro;
//	}
//}
		//		// expection x == null
//		int maxPro = a[0];
//		int submax = a[0];
//		for (int i = 1 ; i < a.length ; i ++) {
//			if (a[i] == 0) {
//				submax = 0;
//			} else if (a[i] > 0) {
//				if (submax > 0) {
//					submax *= a[i];
//				} else {
//					submax = a[i];
//				}
//			} else {
//				if (submax > 0) {
//					submax = a[i];
//				} else {
//					submax *= a[i];
//				}
//			}
//			maxPro = Math.max(maxPro, submax);
//		}
//		return maxPro;
//	}
//}
