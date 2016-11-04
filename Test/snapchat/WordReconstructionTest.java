package snapchat;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordReconstructionTest {
	WordReconstruction test = new WordReconstruction();
	
	@Test
	public void testWordReconstruction1() {
		String[] input = new String[] {
				"CAT",
				"DOG"
		};
		String[] dict = new String[] {
				"GAT",
				"DOC",
				"CD",
				"GOAT",
				"BAD",
				"COOL"
		};
		List<List<String>> expected = new ArrayList<>();
		expected.add(new ArrayList<>(Arrays.asList("GAT", "DOC")));
		expected.add(new ArrayList<>(Arrays.asList("CD", "GOAT")));
		assertEquals(expected.size(), test.wordReconstruction(input, dict).size());
		assertEquals(true, expected.containsAll(test.wordReconstruction(input, dict)));
	}
	
	@Test
	public void testWordReconstruction2() {
		String[] input = new String[] {
				"LOVE",
				"GOD"
		};
		String[] dict = new String[] {
				"GOOD",
				"LOVE",
				"LVE",
				"DOG",
				"HIT",
				"COOL",
				"SHIT",
				"FABULOUS",
				"LOOD",
				"GVE"
		};
		List<List<String>> expected = new ArrayList<>();
		expected.add(new ArrayList<>(Arrays.asList("LVE", "GOOD")));
		expected.add(new ArrayList<>(Arrays.asList("DOG", "LOVE")));
		expected.add(new ArrayList<>(Arrays.asList("GVE", "LOOD")));
		assertEquals(expected.size(), test.wordReconstruction(input, dict).size());
		assertEquals(true, expected.containsAll(test.wordReconstruction(input, dict)));
	}
}
