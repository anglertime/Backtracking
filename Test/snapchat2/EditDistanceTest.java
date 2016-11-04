package snapchat2;

import static org.junit.Assert.*;

import org.junit.Test;

public class EditDistanceTest {
	EditDistance test = new EditDistance();
	
	@Test
	public void testEditDistance1() {
		String s = new String("love");
		String target = new String("glove");
		int expected = 1;
		assertEquals(expected, test.editDistance(s, target));
	}
	
	@Test
	public void testEditDistance2() {
		String s = new String("love");
		String target = new String("glovey");
		int expected = 2;
		assertEquals(expected, test.editDistance(s, target));
	}
	
	@Test
	public void testEditDistance3() {
		String s = new String("aaabbbddd");
		String target = new String("aaabddd");
		int expected = 2;
		assertEquals(expected, test.editDistance(s, target));
	}
	
	@Test
	public void testEditDistance4() {
		String s = new String("sea");
		String target = new String("eat");
		int expected = 2;
		assertEquals(expected, test.editDistance(s, target));
	}
}
