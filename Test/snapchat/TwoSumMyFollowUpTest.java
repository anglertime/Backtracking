package snapchat;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class TwoSumMyFollowUpTest {
	TwoSumMyFollowUp test = new TwoSumMyFollowUp();
	
	int[] input = new int[] {2,3,94,5,100,-5,105,6,92,95,97,98,98};
	int target = 100;
	
	@Test
	public void testTwoSumMyFollowUp1() {
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(new ArrayList<>(Arrays.asList(0, 11)));
		expected.add(new ArrayList<>(Arrays.asList(1, 10)));
		expected.add(new ArrayList<>(Arrays.asList(0, 12)));
		expected.add(new ArrayList<>(Arrays.asList(2, 7)));
		expected.add(new ArrayList<>(Arrays.asList(3, 9)));
		expected.add(new ArrayList<>(Arrays.asList(5, 6)));
		List<List<Integer>> actual = test.twoSumMyFollowUp1(input, target);
		assertEquals(expected.size(), actual.size());
		assertEquals(true, expected.containsAll(actual));
	}

	@Test
	public void testTwoSumMyFollowUp2() {
		Set<List<Integer>> expected = new HashSet<>();
		expected.add(new ArrayList<>(Arrays.asList(2, 98)));
		expected.add(new ArrayList<>(Arrays.asList(3, 97)));
		expected.add(new ArrayList<>(Arrays.asList(94, 6)));
		expected.add(new ArrayList<>(Arrays.asList(5, 95)));
		expected.add(new ArrayList<>(Arrays.asList(-5, 105)));
		Set<List<Integer>> actual = test.twoSumMyFollowUp2(input, target);
		assertEquals(expected.size(), actual.size());
		assertEquals(true, expected.containsAll(actual));
	}

}
