package snapchat2;

import static org.junit.Assert.*;

import org.junit.Test;

public class EncodeDecodeTest {
	EncodeDecode test = new EncodeDecode();
	
	@Test
	public void testEncode() {
		String input = new String("hello world");
		test.encode(input);
	}
	
	@Test
	public void testDecode() {
		String input = new String("8lohe wrd011101111010101101111101111110110111111101011111111");
		test.decode(input);
	}

}
