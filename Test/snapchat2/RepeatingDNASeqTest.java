package snapchat2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RepeatingDNASeqTest {
	RepeatingDNASeq test = new RepeatingDNASeq();
	
	@Test
	public void testRepeatingDNASeq() {
		String input = new String("AAAAACCCCCAAAAACCCCCCAAAAAGGGTT");
		List<String> expected = new ArrayList<>();
		expected.add("AAAAACCCCC");
		expected.add("CCCCCAAAAA");
		assertEquals(expected.size(), test.repeatingDNASeq(input).size());
		assertEquals(true, expected.containsAll(test.repeatingDNASeq(input)));
	}

}
