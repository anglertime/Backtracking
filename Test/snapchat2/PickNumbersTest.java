package snapchat2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PickNumbersTest {
	PickNumbers test = new PickNumbers();
	
	@Test
	public void testCanWin1() {
		int n = 5;
		int target = 3;
		boolean expected = true;
		assertEquals(expected, test.canWin(n, target));
	}
	
	@Test
	public void testCanWin2() {
		int n = 5;
		int target = 6;
		boolean expected = false;
		assertEquals(expected, test.canWin(n, target));
	}
	
	@Test
	public void testCanWin3() {
		int n = 5;
		int target = 7;
		boolean expected = true;
		assertEquals(expected, test.canWin(n, target));
	}
	
	@Test
	public void testCanWin4() {
		int n = 5;
		int target = 10;
		boolean expected = true;
		assertEquals(expected, test.canWin(n, target));
	}
	
	@Test
	public void testCanWin5() {
		int n = 5;
		int target = 15;
		boolean expected = true;
		assertEquals(expected, test.canWin(n, target));
	}
	
	@Test
	public void testCanWin6() {
		int n = 5;
		int target = 12;
		boolean expected = true;
		assertEquals(expected, test.canWin(n, target));
	}
}
