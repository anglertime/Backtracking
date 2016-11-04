package snapchat;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import snapchat.BinaryTreeVerticalOrder.TreeNode;
import org.junit.Test;

public class BinaryTreeVerticalOrderTest {
	BinaryTreeVerticalOrder test = new BinaryTreeVerticalOrder();
	
	@Test
	public void testVerticalOrder1() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
//		root.left.left = null;
//		root.left.right = null;
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> result = test.verticalOrder(root);
		List<List<Integer>> expected = new ArrayList<>();
		
		expected.add(new ArrayList<>(Arrays.asList(9)));
		expected.add(new ArrayList<>(Arrays.asList(3, 15)));
		expected.add(new ArrayList<>(Arrays.asList(20)));
		expected.add(new ArrayList<>(Arrays.asList(7)));
		
		assertEquals(expected.size(), result.size());
		assertEquals(new HashSet<>(expected), new HashSet<>(result));
	}
	
	@Test
	public void testVerticalOrder2() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		List<List<Integer>> result = test.verticalOrder(root);
		List<List<Integer>> expected = new ArrayList<>();
		
		expected.add(new ArrayList<>(Arrays.asList(4)));
		expected.add(new ArrayList<>(Arrays.asList(9)));
		expected.add(new ArrayList<>(Arrays.asList(3, 0, 1)));
		expected.add(new ArrayList<>(Arrays.asList(8)));
		expected.add(new ArrayList<>(Arrays.asList(7)));
		
		assertEquals(expected.size(), result.size());
		assertEquals(new HashSet<>(expected), new HashSet<>(result));
	}
//	[-64,12,18,-4,-53,null,76,null,-51,null,null,-93,3,null,-31,47,null,3,53,-81,33,4,null,-51,-44,-60,11,null,null,null,null,78,null,-35,-64,26,-81,-31,27,60,74,null,null,8,-38,47,12,-24,null,-59,-49,-11,-51,67,null,null,null,null,null,null,null,-67,null,-37,-19,10,-55,72,null,null,null,-70,17,-4,null,null,null,null,null,null,null,3,80,44,-88,-91,null,48,-90,-30,null,null,90,-34,37,null,null,73,-38,-31,-85,-31,-96,null,null,-18,67,34,72,null,-17,-77,null,56,-65,-88,-53,null,null,null,-33,86,null,81,-42,null,null,98,-40,70,-26,24,null,null,null,null,92,72,-27,null,null,null,null,null,null,-67,null,null,null,null,null,null,null,-54,-66,-36,null,-72,null,null,43,null,null,null,-92,-1,-98,null,null,null,null,null,null,null,39,-84,null,null,null,null,null,null,null,null,null,null,null,null,null,-93,null,null,null,98]
	
//			[[-4,78,-77,73,-36,-54],[12,-51,4,-81,8,-30,3,-33,24,98,81,86],[-64,-53,-31,47,-35,-4,72,-37,-67,-38,-18,-31,-31,-66,43,-72],[18,-93,33,-51,-38,-11,-24,47,80,-91,44,-42,-40,70,-93],[76,3,-64,-31,26,-19,10,-85,-96,67,34,-92,-1],[3,-44,-60,12,-51,67,-59,-88,48,-26,92,72],[53,-81,27,60,-55,-70,72,-88,56,-98,-84],[11,-49,-90,90,-34,-27,-67,98],[74,17,-17,-65,-53,39],[37]]
	@Test
	public void testVerticalOrder3() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.left.right.right = new TreeNode(2);
		
		root.right.left = new TreeNode(1);
		root.right.left.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> result = test.verticalOrder(root);
		List<List<Integer>> expected = new ArrayList<>();
		
		expected.add(new ArrayList<>(Arrays.asList(4)));
		expected.add(new ArrayList<>(Arrays.asList(9, 5)));
		expected.add(new ArrayList<>(Arrays.asList(3, 0, 1)));
		expected.add(new ArrayList<>(Arrays.asList(8, 2)));
		expected.add(new ArrayList<>(Arrays.asList(7)));
		
		assertEquals(expected.size(), result.size());
		assertEquals(new HashSet<>(expected), new HashSet<>(result));
	}

}
