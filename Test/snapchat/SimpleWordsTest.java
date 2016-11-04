package snapchat;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SimpleWordsTest {
	SimpleWords test = new SimpleWords();
	
	@Test
	public void testSimpleWords() {
		// bbbbaa 包含baa和bba，而且长度等于baa和bba的和，但是bbbbaa却不是compound，而baa和bba却因此成为simple words？
		String[] input = new String[] {
				"chat", "ever", 
				"snapchat", "snap", 
				"salesperson", 
				"per", "person", 
				"sales", "son", 
				"whatsoever", 
				"what", "so"
		};
		List<String> expected = new ArrayList<>();
		expected.add("chat");
		expected.add("ever");
		expected.add("snap");
		expected.add("per");
		expected.add("sales");
		expected.add("son");
		expected.add("what");
		expected.add("so");
		assertEquals(expected.size(), test.simpleWords(input).size());
		assertEquals(true, expected.containsAll(test.simpleWords(input)));
	}

}
