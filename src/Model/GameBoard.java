package Model;

public class GameBoard {
	char[][] board;
	public GameBoard(int x) {
		board = new char[x][x];
	}
	
	public boolean isFull() {
		return true;
	}
}
