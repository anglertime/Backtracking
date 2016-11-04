package snapchat2;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumWindowSubstringTest {
	MinimumWindowSubstring test = new MinimumWindowSubstring();
	
	@Test
	public void testMinimumWindowSubstring() {
		String s = new String("ADOBECODEBANC");
		String target = new String("ABC");
		String expected = "BANC";
		assertEquals(expected, test.minimumWindowSubstring(s, target));
	}

}
