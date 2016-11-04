package snapchat;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ThreeSumLeetCodeTest {
	ThreeSumLeetCode test = new ThreeSumLeetCode();
	
	@Test
	public void testThreeSum1() {
		int[] input = new int[] {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(new ArrayList<>(Arrays.asList(-1, 0, 1)));
		expected.add(new ArrayList<>(Arrays.asList(-1, -1, 2)));
		assertEquals(expected.size(), test.threeSum(input).size());
		assertEquals(true, expected.containsAll(test.threeSum(input)));
	}

	@Test
	public void testThreeSum2() {
		int[] input = new int[] {-1, 1, -1, 1};
		List<List<Integer>> expected = new ArrayList<>();
		assertEquals(expected.size(), test.threeSum(input).size());
		assertEquals(true, expected.containsAll(test.threeSum(input)));
	}
}
