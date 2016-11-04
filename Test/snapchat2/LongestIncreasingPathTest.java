package snapchat2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingPathTest {
	LongestIncreasingPath test = new LongestIncreasingPath();
	
	@Test
	public void testLongestIncreasingPa1() {
		int[][] input = new int[][] {
			{9,9,4},
			{6,6,8},
			{2,1,1}
		};
		int expected = 4;
		assertEquals(expected, test.longestIncreasingPa(input));
	}
	
	@Test
	public void testLongestIncreasingPa2() {
		int[][] input = new int[][] {
			{3,4,5},
			{3,2,6},
			{2,2,1}
		};
		int expected = 4;
		assertEquals(expected, test.longestIncreasingPa(input));
	}
	
	@Test
	public void testLongestIncreasingPa3() {
		int[][] input = new int[][] {
			{5,9,4,5},
			{6,5,4,3},
			{7,8,1,2}
		};
		int expected = 8;
		assertEquals(expected, test.longestIncreasingPa(input));
	}
}
