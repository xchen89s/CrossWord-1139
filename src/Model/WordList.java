package Model;

public class WordList {
	String word;
	Position startPosition;
	//1 = horizontal  0=vertical
	int direction;
	public WordList next;
	public WordList(String word, Position sp, int d) {
		this.word = word;
		this.startPosition = sp;
		this.direction = d;
	}
	public WordList(){}
	public Position getPosition() {
		return this.startPosition;
	}
	public int getDirection() {
		return this.direction;
	}
	public String getWord() {
		return this.word;
	}
}
