package snapchat;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class WordBreakFindFirstTest {
	WordBreakFindFirst test = new WordBreakFindFirst();
	
	@Test
	public void testWordBreakFindFirst() {
		String inputS = new String("leetcodeking");
		Set<String> set = new HashSet<>();
		set.add("leet");
		set.add("code");
		set.add("leetcode");
		set.add("king");
		set.add("kin");
		List<String> expected = new LinkedList<>();
		// recursion 的查找顺序问题，如果用recursion，最先找到的是最底层先满足的，所以第一个按照recursion满足的应该是 leetcode + king
		// 放屁，不对，我先经过4的！！！
		expected.add("leet");
		expected.add("code");
		expected.add("king");
		assertEquals(expected.size(), test.wordBreakFindFirst(inputS, set).size());
		assertEquals(true, expected.containsAll(test.wordBreakFindFirst(inputS, set)));
	}

}
