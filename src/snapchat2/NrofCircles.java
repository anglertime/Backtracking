package snapchat2;

public class NrofCircles {
	public int nrofCircles(int n, int[][] friendship) {
		// initialization
		int[] circles = new int[n];
		for (int i = 0 ; i < n ; i ++) {
			circles[i] = i;
		}
		int result = n;
		// read friendship
		for (int row = 0 ; row < friendship.length ; row ++) {
			// find root of each person
			int rootA = findRoot(friendship[row][0], circles);
			int rootB = findRoot(friendship[row][1], circles);
			if (rootA != rootB) {
				// merge
				merge(rootA, rootB, circles);
				result --;
			}
		}
		for (int i = 0 ; i < n ; i ++) {
			System.out.println("index : " + i + " " + circles[i]);
		}
		return result;
	}
	
	private int findRoot(int person, int[] circles) {
		int ret = person;
		while (circles[ret] != ret) {
			circles[ret] = circles[circles[ret]]; // compressed path
			ret = circles[ret];
		}
		return ret;
	}
	private void merge(int rootA, int rootB, int[] circles) {
		circles[rootB] = rootA;
	}
}
