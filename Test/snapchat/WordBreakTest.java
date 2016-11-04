package snapchat;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WordBreakTest {
	WordBreak test = new WordBreak();
	
	@Test
	public void testWordBreak() {
		String inputS = new String("leetcodeking");
		Set<String> set = new HashSet<>();
		set.add("leet");
		set.add("code");
		set.add("leetcode");
		set.add("king");
		set.add("kin");
		boolean expected = true;
		assertEquals(expected, test.wordBreak(inputS, set));
	}

}
