package snapchat;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleWords {
	public List<String> simpleWords(String[] x) {
		Arrays.sort(x, new Comparator<String> () {
			@Override
			public int compare(String front, String back) {
				return front.length() - back.length();
			}
		});
		
		// iterate
		int[] compound = new int[x.length];
		for (int i = 0 ; i < x.length ; i ++) {
			boolean simple = false;
			for (int j = i + 1 ; j < x.length ; j ++) {
//				if (compound[j] != -1 && x[j].length() > x[i].length()) {
				if (x[j].length() > x[i].length()) {
					simple |= checkCompound(i, j, x, compound);
				}
			}
			if (compound[i] != -1 && simple) {
				compound[i] = 1;
			}
		}
		
		// output
		List<String> ret = new ArrayList<>();
		for (int i = 0 ; i < x.length ; i ++) {
			if (compound[i] == 1) {
				ret.add(x[i]);
			}
		}
		return ret;
	}
	
	private boolean checkCompound(int simple, int target, String[] x, int[] compound) {
		// exception...
		if (x[target].toLowerCase().contains(x[simple].toLowerCase())) {
			compound[target] = -1;
			return true;
		}
		return false;
	}
}
