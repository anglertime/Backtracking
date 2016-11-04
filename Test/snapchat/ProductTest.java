package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductTest {
	Product test = new Product();
	
	@Test
	public void testProduct() {
		int[] inputX = new int[] {
				1, 2, 3, 4
		};
		int[] expected = new int[] {
				24, 12, 8, 6
		};
		for (int i = 0 ; i < inputX.length ; i ++) {
			assertEquals(expected[i], test.product(inputX)[i]);
		}
	}

}
