package snapchat;

public class Product {
	public int[] product(int[] x) {
		int n = x.length;
		int[] leftPro = new int[n];
		// find leftPro and rightPro
		leftPro[0] = 1;
		for (int i = 1 ; i < n ; i ++) {
			leftPro[i] = leftPro[i - 1] * x[i - 1];
		}
		// 真是优美啊！！！！！
		int prev = 1;
		for (int i = n - 1 ; i >= 0 ; i --) {
			leftPro[i] *= prev;
			prev *= x[i];        
		}
		return leftPro;
	}
}
	
	//	public int[] product(int[] x) {
//		int n = x.length;
//		int[] leftPro = new int[n];
//		// find leftPro and rightPro
//		leftPro[0] = 1;
//		for (int i = 1 ; i < n ; i ++) {
//			leftPro[i] = leftPro[i - 1] * x[i - 1];
//		}
//		int prev = 1;
//		leftPro[n - 1] *= 1;
//		for (int i = n - 2 ; i >= 0 ; i --) {
//			int cur = prev * x[i + 1];
//			prev = cur;
//			
//			leftPro[i] *= cur;
//		}
//		return leftPro;
//	}
//}

//	public int[] product(int[] x) {
//		int n = x.length;
//		int[] leftPro = new int[n];
//		// find leftPro and rightPro
//		int prev = 1;
//		leftPro[0] = 1;
//		for (int i = 1 ; i < n ; i ++) {
//			leftPro[i] = prev * x[i - 1];
//			prev = leftPro[i];
//		}
//		prev = 1;
//		leftPro[n - 1] = leftPro[n - 1] * prev;
//		for (int i = n - 2 ; i >= 0 ; i --) {
//			int cur = prev * x[i + 1];
//			leftPro[i] = leftPro[i] * cur;
//			prev = cur;
//		}
//		return leftPro;
//	}
//}

//	public int[] product(int[] x) {
//		int n = x.length;
//		int[] leftPro = new int[n];
//		int[] res = new int[n];
//		// find leftPro and rightPro
//		int prev = 1;
//		leftPro[0] = 1;
//		for (int i = 1 ; i < n ; i ++) {
//			leftPro[i] = prev * x[i - 1];
//			prev = leftPro[i];
//		}
//		prev = 1;
//		res[n - 1] = leftPro[n - 1] * prev;
//		for (int i = n - 2 ; i >= 0 ; i --) {
//			int cur = prev * x[i + 1];
//			res[i] = leftPro[i] * cur;
//			prev = cur;
//		}
//		return res;
//	}
//}
	//	public int[] product(int[] x) {
//		int n = x.length;
//		int[] leftPro = new int[n];
//		int[] rightPro = new int[n];
//		int[] res = new int[n];
//		// find leftPro and rightPro
//		int prev = 1;
//		leftPro[0] = 1;
//		for (int i = 1 ; i < n ; i ++) {
//			leftPro[i] = prev * x[i - 1];
//			prev = leftPro[i];
//		}
//		prev = 1;
//		rightPro[n - 1] = 1;
//		for (int i = n - 2 ; i >= 0 ; i --) {
//			rightPro[i] = prev * x[i + 1];
//			prev = rightPro[i];
//			res[i] = leftPro[i] * rightPro[i];
//		}
//		res[n - 1] = leftPro[n - 1] * rightPro[n - 1];
//		return res;
//	}
//}
	//	public int[] product(int[] x) {
//		int n = x.length;
//		int[] leftPro = new int[n];
//		int[] rightPro = new int[n];
//		int[] res = new int[n];
//		// find leftPro and rightPro
//		int prev = 1;
//		leftPro[0] = 1;
//		for (int i = 1 ; i < n ; i ++) {
//			leftPro[i] = prev * x[i - 1];
//			prev = leftPro[i];
//		}
//		prev = 1;
//		rightPro[n - 1] = 1;
//		for (int i = n - 2 ; i >= 0 ; i --) {
//			rightPro[i] = prev * x[i + 1];
//			prev = rightPro[i];
//		}
//		// obtain result
//		for (int i = 0 ; i < n ; i ++) {
//			res[i] = leftPro[i] * rightPro[i];
//		}
//		return res;
//	}
//}
