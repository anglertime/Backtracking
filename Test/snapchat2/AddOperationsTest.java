package snapchat2;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddOperationsTest {
	AddOperations test = new AddOperations();
	
	@Test
	public void testAddOperations() {
		int[] x = new int[] {
				1, 2, 3
		};
		int expected = 7;
		assertEquals(expected, test.addOperations(x));
	}

}
