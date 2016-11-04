package snapchat2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BadIpsTest {
	BadIps test = new BadIps();
	
	@Test
	public void testBadIps() {
		String[] input = new String[] {
				"7.0.0.0.8",
				"10.3.0.0.16",
				"6.7.8.134.32"
		};
		String target1 = "7.0.0.0";
		assertEquals(true, test.badIps(input, target1));
		String target2 = "7.3.4.5";
		assertEquals(true, test.badIps(input, target2));
		String target3 = "6.4.8.0";
		assertEquals(false, test.badIps(input, target3));
	}

}
