package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

public class OneEditDistanceTest {
	OneEditDistance test = new OneEditDistance();
	
	@Test
	public void testIsOneEditDistance1() {
		String s = new String("");
		String t = new String("A");
		boolean expected = true;
		assertEquals(expected, test.isOneEditDistance(s, t));
	}
	
	@Test
	public void testIsOneEditDistance2() {
		String s = new String("ab");
		String t = new String("abc");
		boolean expected = true;
		assertEquals(expected, test.isOneEditDistance(s, t));
	}
	
	@Test
	public void testIsOneEditDistance3() {
		String s = new String("abbbbb");
		String t = new String("abcbbb");
		boolean expected = true;
		assertEquals(expected, test.isOneEditDistance(s, t));
	}
	
	@Test
	public void testIsOneEditDistance4() {
		String s = new String("abcd");
		String t = new String("ab");
		boolean expected = false;
		assertEquals(expected, test.isOneEditDistance(s, t));
	}
	
	@Test
	public void testIsOneEditDistance5() {
		String s = new String("acd");
		String t = new String("abc");
		boolean expected = false;
		assertEquals(expected, test.isOneEditDistance(s, t));
	}
	
	@Test
	public void testIsOneEditDistance6() {
		String s = new String("abcsd");
		String t = new String("abssdf");
		boolean expected = false;
		assertEquals(expected, test.isOneEditDistance(s, t));
	}
}
