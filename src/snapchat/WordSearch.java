package snapchat;

public class WordSearch {
	int m;
	int n;
	public boolean wordSearch(char[][] board, String word) {
		m = board.length;
		n = board[0].length;
		for (int row = 0 ; row < m ; row ++) {
			for (int col = 0 ; col < n ; col ++) {
				if (board[row][col] == word.charAt(0)) {
					boolean[][] visited = new boolean[m][n];
					if (backtracking(0, row, col, word, board, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	private boolean backtracking(int depth, int row, int col, String word, char[][] board, boolean[][] visited) {
		if (depth >= word.length()) {
			return true;
		}
		if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word.charAt(depth) || visited[row][col]) {
			return false;
		}
		visited[row][col] = true;
		boolean found = false;
		// four directions
		found |= backtracking(depth + 1, row - 1, col, word, board, visited);
		found |= backtracking(depth + 1, row + 1, col, word, board, visited);
		found |= backtracking(depth + 1, row, col - 1, word, board, visited);
		found |= backtracking(depth + 1, row, col + 1, word, board, visited);
		if (found) {
			return true;
		} else {
			visited[row][col] = false;
			return false;
		}
	}
}
