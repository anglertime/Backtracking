package snapchat2;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximumProductSubarrayTest {
	MaximumProductSubarray test = new MaximumProductSubarray();
	
	@Test
	public void testMaximumProductSubarray1() {
		int[] a = new int[]{
				2, 3, -2, 4
		};
		int expected = 6;
		assertEquals(expected, test.maximumProductSubarray(a));
	}
	
	@Test
	public void testMaximumProductSubarray2() {
		int[] a = new int[]{
				-2, 3, -4
		};
		int expected = 24;
		assertEquals(expected, test.maximumProductSubarray(a));
	}

}
