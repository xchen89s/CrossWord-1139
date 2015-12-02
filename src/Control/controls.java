package Control;

import java.util.Random;
import Model.*;

public class controls {
	public void intialize(int x) {
		//create the word list
		//print out the layout
		//x is the size of the board
		GameBoard gb = new GameBoard(x);
		WordList list = new WordList();
		WordList curWord = list;
		//create and add the first word
		Position firstPosition = rdmPosition(null);
		String res = getStringRestrictions(firstPosition, 0);
		String w = randomWord(res);
		curWord.next = new WordList(w, firstPosition, 0);
		curWord = curWord.next;
		while (gb.isFull()) {
			//TODO need to deal with backtracking cases
			Position nextPosition = rdmPosition(curWord);
			String restrictions = getStringRestrictions(nextPosition, curWord.getDirection());
			String word = randomWord(restrictions);
			curWord.next = new WordList(word, nextPosition, (curWord.getDirection()^1));
			curWord = curWord.next;
		}
		
		//print out the word list for now.
		//TODO UI design based on the list
		printLayout(list);
	}
	
	//add length as a restriction?
	//public String randomWord(String restrictions, int length)
	public String randomWord(String restrictions) {
		//search the dictionary and return the first word that meets the criteria
		return null;
	}

	public Position rdmPosition(WordList word) {
		if (word == null) return new Position(0, 0);
		int x=0, y=0;
		Random rm = new Random();
		
		if (word.getDirection()==0) {
			y = word.getPosition().getY();
			x = rm.nextInt(word.getWord().length())-word.getPosition().getX();
			return new Position(x, y);
		}
		else {
			x = word.getPosition().getX();
			y = rm.nextInt(word.getWord().length())-word.getPosition().getY();
			return new Position(x,y);
		}
	}
	/*
	public int rdmlen(int max) {
		Random rm = new Random();
		return rm.nextInt(max);
	}
	*/
	public String getStringRestrictions(Position p, int direction) {
		//return a string to indicate any existing chars.
		//"s  t  "
		return "";
	}
	
	public void printLayout(WordList list) {
		//to return the result
	}
}
