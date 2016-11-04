package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearchTest {
	WordSearch test = new WordSearch();
	
	@Test
	public void testWordSearch1() {
		String word = new String("ABCCED");
		char[][] board = new char[][] {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}
		};
		boolean expected = true;
		assertEquals(expected, test.wordSearch(board, word));
	}
	
	@Test
	public void testWordSearch2() {
		String word = new String("SEE");
		char[][] board = new char[][] {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}
		};
		boolean expected = true;
		assertEquals(expected, test.wordSearch(board, word));
	}
	
	@Test
	public void testWordSearch3() {
		String word = new String("ABCB");
		char[][] board = new char[][] {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}
		};
		boolean expected = false;
		assertEquals(expected, test.wordSearch(board, word));
	}
	
	@Test
	public void testWordSearch4() {
		String word = new String("ABCC");
		char[][] board = new char[][] {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}
		};
		boolean expected = true;
		assertEquals(expected, test.wordSearch(board, word));
	}

}
