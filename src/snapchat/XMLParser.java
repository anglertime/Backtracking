package snapchat;

import java.util.ArrayList;
import java.util.List;

public class XMLParser {
	public void xMLParser(String[] input) {
		// build tree
		boolean[] visited = new boolean[input.length];
		TreeNode root = buildTree(0, input, visited);
		// print tree
		printTree(0, root);
	}
	
	private void printTree(int depth, TreeNode cur) {
		// dfs to printout
		System.out.println();
		for (int i = 0 ; i <= depth * 4 ; i ++) {
			System.out.print(" ");
		}
		if (!cur.content.equals("")) {
			// leaf
			System.out.print(cur.name + ": " + cur.content);
			return;
		} else {
			System.out.print(cur.name);
		}
		List<TreeNode> curChil = cur.children;
		for (int i = 0 ; i < curChil.size() ; i ++) {
			printTree(depth + 1, curChil.get(i));
		}
	}
	
	private TreeNode buildTree(int index, String[] input, boolean[] visited) {
		String cur = input[index];
		if (!cur.substring(0, 4).equals("open")) {
			throw new IllegalArgumentException("2"); // "not valid input"
		}
		visited[index] = true;
		
		TreeNode curNode = new TreeNode(cur.substring(5, cur.length()));
		// closure
		StringBuilder sb = new StringBuilder("close");
		sb.append(",");
		sb.append(curNode.name);
		
		// check if curNode is leaf
		String next = input[index + 1];
		if (next.substring(0, 4).equals("text")) {
			if (index + 2 >= input.length || !input[index + 2].equals(sb.toString())) {
				throw new IllegalArgumentException("not valid input: bad leaf");
			}
			
			visited[index + 1] = true;
			visited[index + 2] = true;
			curNode.content = next.substring(5, next.length());
			return curNode;
		}
		
		boolean valid = false;
		// not a leaf. find all its children between index + 1 and "close + name"
		List<TreeNode> curChil = new ArrayList<TreeNode>();
		for (int child = index + 1 ; child < input.length ; child ++) {
			if (!visited[child] && input[child].substring(0, 4).equals("open")) {
				curChil.add(buildTree(child, input, visited));
			} else if (input[child].equals(sb.toString())) {
				visited[child] = true;
				valid = true;
				curNode.children = curChil;
				return curNode;
			}
			
			if (!visited[child] && input[child].substring(0, 5).equals("close")) {
				throw new IllegalArgumentException("not valid input");
			}
		}
		if (!valid) {
			throw new IllegalArgumentException("not valid input: no closure for " + curNode.name);
		}
		return curNode;
	}
	
	private class TreeNode {
		String name;
		String content;
		List<TreeNode> children;
		public TreeNode(String newName) {
			name = newName;
			content = new String("");
			children = new ArrayList<TreeNode>();
		}
	}
}
	//	public void xMLParser(String[] input) {
//		// build tree
//		boolean[] visited = new boolean[input.length];
//		TreeNode root = buildTree(0, input, visited);
//		// print tree
//		printTree(0, root);
//	}
//	
//	private void printTree(int depth, TreeNode cur) {
//		// dfs to printout
//		System.out.println();
//		for (int i = 0 ; i <= depth * 4 ; i ++) {
//			System.out.print(" ");
//		}
//		if (!cur.content.equals("")) {
//			// leaf
//			System.out.print(cur.name + ": " + cur.content);
//			return;
//		} else {
//			System.out.print(cur.name);
//		}
//		List<TreeNode> curChil = cur.children;
//		for (int i = 0 ; i < curChil.size() ; i ++) {
//			printTree(depth + 1, curChil.get(i));
//		}
//	}
//	
//	private TreeNode buildTree(int index, String[] input, boolean[] visited) {
//		if (index >= input.length) {
//			throw new IllegalArgumentException("1");
//		}
//		String cur = input[index];
//		if (!cur.substring(0, 4).equals("open")) {
//			throw new IllegalArgumentException("2"); // "not valid input"
//		}
//		visited[index] = true;
//		
//		TreeNode curNode = new TreeNode(cur.substring(5, cur.length()));
//		
//		// check if curNode is leaf
//		String next = input[index + 1];
//		if (next.substring(0, 4).equals("text")) {
//			// check valid
//			StringBuilder sb = new StringBuilder("close");
//			sb.append(",");
//			sb.append(curNode.name);
//			if (index + 2 >= input.length || !input[index + 2].equals(sb.toString())) {
//				throw new IllegalArgumentException("not valid input: bad leaf");
//			}
//			
//			visited[index + 1] = true;
//			visited[index + 2] = true;
//			curNode.content = next.substring(5, next.length());
//			return curNode;
//		}
//		
//		// not a leaf. update its children
//		List<TreeNode> curChil = new ArrayList<TreeNode>();
//		for (int child = index + 1 ; child < input.length ; child ++) {
//			if (!visited[child] && input[child].substring(0, 4).equals("open")) {
//				curChil.add(buildTree(child, input, visited));
//			} else if (input[child].substring(0, 5).equals("close") && input[child].substring(6, input[child].length()).equals(curNode.name)) {
//				curNode.children = curChil;
//				return curNode;
//			}
//		}
//		return curNode;
//	}
//	
//	private class TreeNode {
//		String name;
//		String content;
//		List<TreeNode> children;
//		public TreeNode(String newName) {
//			name = newName;
//			content = new String("");
//			children = new ArrayList<TreeNode>();
//		}
//	}
//}
