package snapchat2;

import java.util.HashMap;
import java.util.Map;

public class BadIps {
	// 40 minutes
	public boolean badIps(String[] badIPs, String toCheck) {
		String[][] toStore = new String[badIPs.length][];
		for (int i = 0 ; i < badIPs.length ; i ++) {
			toStore[i] = badIPs[i].split("\\.");
//			String[] cur = toSplit.split("\\.");
//			System.out.println(cur.length);
//			for (int j = 0 ; j < cur.length ; j ++) {
//				toStore[i][j] = cur[j];
//			}
		}
		// build Trie
		TrieNode root = new TrieNode(-1);
		for (int i = 0 ; i < toStore.length ; i ++) {
			int leafDepth = Integer.parseInt(toStore[i][4]) / 8;
//			int curVal = Integer.parseInt(toStore[i][0]);
			store(1, root, toStore[i], leafDepth);
		}
		// check toCheck
		String[] arr = toCheck.split("\\.");
		return isBadIP(1, root, arr);
	}
	private boolean isBadIP(int depth, TrieNode parent, String[] arr) {
		if (depth > 4) {
			return false;
		}
		int curVal = Integer.parseInt(arr[depth - 1]);
		Map<Integer, TrieNode> chil = parent.children;
		if (!chil.containsKey(curVal)) {
			return false;
		}
		TrieNode cur = chil.get(curVal);
		if (cur.isLeaf) {
			return true;
		}
		return isBadIP(depth + 1, cur, arr);
	}
	private void store(int depth, TrieNode parent, String[] str, int leafDepth) {
		int curVal = Integer.parseInt(str[depth - 1]);
		Map<Integer, TrieNode> chil = parent.children;
		TrieNode cur = new TrieNode(curVal);
		// leaf
		if (depth == leafDepth) {
			if (chil.containsKey(curVal)) {
				cur = chil.get(curVal);
				cur.isLeaf = true;
			} else {
				cur.isLeaf = true;
				chil.put(curVal, cur);
			}
//			System.out.println(curVal);
			return;
		}
		if (chil.containsKey(curVal)) {
			cur = chil.get(curVal);
		} else {
			chil.put(curVal, cur);
		}
		store(depth + 1, cur, str, leafDepth);
	}
	private class TrieNode {
		int val;
		boolean isLeaf;
		Map<Integer, TrieNode> children;
		public TrieNode(int newVal) {
			val = newVal;
			isLeaf = false;
			children = new HashMap<Integer, TrieNode>();
		}
	}
}
