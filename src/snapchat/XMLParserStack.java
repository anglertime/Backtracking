package snapchat;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class XMLParserStack {
	// getNextToken()
	// "open", "name"
	// "text", ...
	// "close", ...
	
	public void xMLParserStack(String[][] input) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode res = new TreeNode("initial");
		for (int i = 0 ; i < input.length ; i ++) {
			String curTag = input[i][0];
			String curStr = input[i][1];
			if (i == 0) {
				// exception
				if (!curTag.equals("open")) {
					throw new IllegalArgumentException("Not valid input!");
				}
				TreeNode root = new TreeNode(curStr);
				res = root;
				stack.push(root);
			}
			if (i > 0) {
				// case 1: leaf children
				if (curTag.equals("open")) {
					// exceptions
					if (i >= input.length - 2) {
						throw new IllegalArgumentException("Not valid input!");
					}
					// leaf
					List<TreeNode> curChil = stack.peek().children;
					if (input[i + 1][0].equals("text")) {
						if (!input[i + 2][0].equals("close") || !input[i + 2][1].equals(curStr)) {
							throw new IllegalArgumentException("Not valid input!");
						}
						TreeNode chil = new TreeNode(curStr);
						chil.content = input[i + 1][1];
						
						curChil.add(chil);
						// update index
						i = i + 2;
					} else {
						// case 2: non leaf children
						TreeNode cur = new TreeNode(curStr);
						curChil.add(cur);
						stack.push(cur);
					}
					continue;
				}
				// case 3: closing token
				if (curTag.equals("close")) {
					if (!curStr.equals(stack.peek().name)) {
						throw new IllegalArgumentException("Not valid input!");
					} else {
						
						stack.pop();
					}
				}
			}
		}
		
		if (!stack.empty()) {
			throw new IllegalArgumentException("Not valid input!");
		}
		printTree(0, res);
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
