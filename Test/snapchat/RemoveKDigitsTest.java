package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveKDigitsTest {
	RemoveKDigits test = new RemoveKDigits();
	
	@Test
	public void testRemoveKdigits1() {
		String input = "1432219";
		int k = 3;
		String expected = "1219";
		assertEquals(expected, test.removeKdigits(input, k));
	}
	
	@Test
	public void testRemoveKdigits2() {
		String input = "5";
		int k = 1;
		String expected = "0";
		assertEquals(expected, test.removeKdigits(input, k));
	}
	
	@Test
	public void testRemoveKdigits3() {
		String input = "1002009";
		int k = 1;
		String expected = "2009";
		assertEquals(expected, test.removeKdigits(input, k));
	}
	
	@Test
	public void testRemoveKdigits4() {
		String input = "1002009";
		int k = 2;
		String expected = "9";
		assertEquals(expected, test.removeKdigits(input, k));
	}
}
