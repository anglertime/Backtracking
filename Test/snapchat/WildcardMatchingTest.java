package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

public class WildcardMatchingTest {
	WildcardMatching test = new WildcardMatching();
	
	@Test
	public void testIsMatch1() {
		String s = new String("abc");
		String p = new String("abc***");
		boolean expected = true;
		assertEquals(expected, test.isMatch(s, p));
	}
	
	@Test
	public void testIsMatch2() {
		String s = new String("abc");
		String p = new String("abc");
		boolean expected = true;
		assertEquals(expected, test.isMatch(s, p));
	}
	
	@Test
	public void testIsMatch3() {
		String s = new String("abc");
		String p = new String("ab");
		boolean expected = false;
		assertEquals(expected, test.isMatch(s, p));
	}
	
	@Test
	public void testIsMatch4() {
		String s = new String("abc");
		String p = new String("a?c");
		boolean expected = true;
		assertEquals(expected, test.isMatch(s, p));
	}
	
	@Test
	public void testIsMatch5() {
		String s = new String("avc");
		String p = new String("a?*");
		boolean expected = true;
		assertEquals(expected, test.isMatch(s, p));
	}
	
	@Test
	public void testIsMatch6() {
		String s = new String("abcc");
		String p = new String("ab*");
		boolean expected = true;
		assertEquals(expected, test.isMatch(s, p));
	}
	
	@Test
	public void testIsMatch7() {
		String s = new String("abfc");
		String p = new String("a*?c");
		boolean expected = true;
		assertEquals(expected, test.isMatch(s, p));
	}
	
	@Test
	public void testIsMatch8() {
		String s = new String("abccabcabc");
		String p = new String("a?*c");
		boolean expected = true;
		assertEquals(expected, test.isMatch(s, p));
	}
	
	@Test
	public void testIsMatch9() {
		String s = new String("ab");
		String p = new String("*?*?*");
		boolean expected = true;
		assertEquals(expected, test.isMatch(s, p));
	}
}
