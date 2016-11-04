package snapchat2;

import static org.junit.Assert.*;

import org.junit.Test;

public class NrofCirclesTest {
	NrofCircles test = new NrofCircles();
	
	@Test
	public void testNrofCircles1() {
		int[][] input = new int[][] {
			{0, 1},
			{1, 2},
			{0, 2},
			{4, 5}
		};
		int n = 6;
		int expected = 3;
		assertEquals(expected, test.nrofCircles(n, input));
	}
	
	@Test
	public void testNrofCircles2() {
		int[][] input = new int[][] {
			{0, 2},
			{1, 2},
			{4, 5},
			{1, 3},
			{3, 4}
		};
		int n = 6;
		int expected = 1;
		assertEquals(expected, test.nrofCircles(n, input));
	}
}
