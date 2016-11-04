package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrogJumpTest {
	FrogJump test = new FrogJump();
	
	@Test
	public void testCanCross() {
		int[] stones = new int[] {0,1,3,5,6,8,12,17};
		assertEquals(false, test.canCross(stones));
	}

}
