package snapchat;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import snapchat.BinaryTreeVerticalOrder.TreeNode;

public class ClosestBinarySearchTreeValueTest {
	ClosestBinarySearchTreeValue test = new ClosestBinarySearchTreeValue();
	
	@Test
	public void testVerticalOrder1() {
		double target = 7.8;
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(19);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(72);
		int actual = test.closestValue(root, target);
		int expected = 8;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVerticalOrder2() {
		double target = 6.1;
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(19);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(72);
		int actual = test.closestValue(root, target);
		int expected = 6;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVerticalOrder3() {
		double target = 72;
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(19);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(72);
		int actual = test.closestValue(root, target);
		int expected = 72;
		assertEquals(expected, actual);
	}

}
