package snapchat2;

import java.util.ArrayList;
import java.util.List;

public class BloomFilter<T> {
/*
 * construct, add, mightcontain, delete, extend(if near full, extend)
 */
	// capacity = 2^length - 1 (minus 1 b/c all zeros is not good)
	int length;
	int count;
	double capFactor;
	boolean[] values;
	public BloomFilter() {
		length = 10;
		capFactor = 0.75;
	}
	public BloomFilter(int newLength, double newCapFactor) {
		length = newLength;
		capFactor = newCapFactor;
	}
	
	public void add(T t) {
		if (count >= capFactor * (Math.pow(2, length) - 1)) {
			extend();
		}
		List<Integer> hash = getHash(t);
		for (int i = 0 ; i < hash.size(); i ++) {
			values[hash.get(i)] = true;
		}
		count ++;
	}
	
	public boolean mightcontain(T t) {
		List<Integer> hash = getHash(t);
		for (int i = 0 ; i < hash.size(); i ++) {
			if (!values[hash.get(i)]) {
				return false;
			}
		}
		return true;
	}
	
	public void delete(T t) {
		List<Integer> hash = getHash(t);
		// removing one true is enough -> which one?
		// trade off 
		// maybe hashset to store removed elements
		// we use bloomfilter that means we would not remove often, otherwise...
	}
	
	private void extend() {
		length += 2;
	}
	// hash functions
	private List<Integer> getHash(T t) {
		// operations to obtain results
		return new ArrayList<Integer>();
	}
}
