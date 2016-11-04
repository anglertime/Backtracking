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
		// recursion �Ĳ���˳�����⣬�����recursion�������ҵ�������ײ�������ģ����Ե�һ������recursion�����Ӧ���� leetcode + king
		// ��ƨ�����ԣ����Ⱦ���4�ģ�����
		expected.add("leet");
		expected.add("code");
		expected.add("king");
		assertEquals(expected.size(), test.wordBreakFindFirst(inputS, set).size());
		assertEquals(true, expected.containsAll(test.wordBreakFindFirst(inputS, set)));
	}

}
