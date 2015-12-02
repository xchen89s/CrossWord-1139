package Model;

public class GameBoard {
	char[][] board;
	public GameBoard(int x) {
		board = new char[x][x];
		for (int i=0;i<x;i++) {
			for (int j=0;j<x;j++) {
				board[i][i] = 32;
			}
		}
	}
	
	public boolean isFull() {
		return false;
	}
	
	public char[] getRow(int row) {
		return board[row];
	}
	
	public char[] getCol(int col) {
		char[] ans = new char[board.length];
		for (int i=0;i<board.length;i++) {
			ans[i]=board[i][col];
		}
		return ans;
	}
	
	public void setEntry(int x, int y, char c) {
		board[x][y] = c;
	}
	
	public char getEntry(int x, int y) {
		return board[x][y];
	}
	
	public int size() {
		return board.length;
	}
}
